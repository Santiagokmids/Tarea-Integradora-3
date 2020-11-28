package model;
import java.util.*;

public class Team{

	//Constants
	public final static int MAX_OFFICE = 6;

	//Relationships
	private ArrayList<Formation> formationA;
	private ArrayList<Formation> formationB;
	private Players[][] intallationsA;
	private Players[][] intallationsB;
	private Coach[][] offices;
	private MainCoach main;
	private AssistantCoach[] assistant;
	private Players[] player;

	//Atributes
	private String name;
	private int countMain;

	//Methods
	/** 
	*Name: Team.
	*Constructor of Team <br> 
	*<b> post: </b> Start the class Team.
   */
	public Team(String name){
		this.name = name;
		countMain = 0;
		main = null;
		player = new Players[25];
		assistant = new AssistantCoach[3];
		formationA = new ArrayList<Formation>();
		formationB = new ArrayList<Formation>();
	 	Coach[][] offices = new Coach[MAX_OFFICE][MAX_OFFICE];
	 	Players[][] intallationsA = new Players[7][7];
	 	Players[][] intallationsB = new Players[7][MAX_OFFICE];
	 }//end Constructor

	public boolean verifyCoach(){
		boolean stop = false;
		if(countMain == 0){
			stop = true; 
		}
		return stop; 
	}

	public boolean verifyAss(){
		boolean stop = false;
		if(assistant[3] != null){
			stop = true; 
		}
		return stop; 
	}

	public boolean verifyPlayer(){
		boolean stop = false;
		if(player[25] != null){
			stop = true; 
		}
		return stop; 
	}

	public int findAss(){
		boolean exit = true;
		int i = 0, position = 0;
		while(exit && i<assistant.length){
			if(assistant[i] == null){
				position = i;
				exit = false;
			}
			i++;
		}
		return position;
	}

	public int findPlayer(){
		boolean exit = true;
		int i = 0, position = 0;
		while(exit && i<player.length){
			if(player[i] == null){
				position = i;
				exit = false;
			}
			i++;
		}
		return position;
	}

	public boolean findShirt(int number){
		int i = 0;
		boolean stop = false; 
		while(i<player.length){
			if(player[i].verifyShirt(number)){
				player[i].getShirtNum() == number;
				stop = true;
			}
		}
		return stop;
	}

	public MainCoach addCoach(String name, String id, int salary,int years,int amountTeams,String championships[]){ 
		MainCoach main = new MainCoach(name, id, salary,years,amountTeams,championships[]);
		countMain += 1;
		return main;
	}

	public AssistantCoach addAss(String name, String id, int salary,int years,int opt,int master[]){ 
		int i = findAss();
		Master[] pro = new Master[master.length];
		for(int m = 0;m<pro.length;m++){
			pro[m] = assistant[i].putMaster(master[m]);
		}
		boolean player = assistant[i].player(opt);
		AssistantCoach obj = new AssistantCoach(name, id, salary,years,player,pro);
		return obj;
	}

	public MainCoach addPlayer(String name, String id, int salary,int number,int position){ 
		int play = findPlayer();
		Position pos = player[play].putPosition(position);
		Players obj = new Players(name, id, salary,number,pos);
		player[play] = obj;
		return obj;
	}

	public String deleteEmploy(String id){
		String message = "";
		if(main.getId().equalsIgnoreCase(id)){
			countMain--;
			main.setState();
			message = "El entrenador "+main.getName()+" fue despedido";
		}
		boolean exit = true;
		for(int i = 0;i<assistant.length && exit;i++){
			if(assistant[i].getId().equalsIgnoreCase(id)){
				assistant[i] = null;
				message = "El asistente "+assistant[i].getName()+" fue despedido";
				exit = false;
			}	
		}
		boolean stop;
		for(int m = 0;m<player.length;m++){
			if(player[m].getId().equalsIgnoreCase(id)){
				player[m] = null;
				message = "El jugador "+player[m].getName()+" fue despedido";
			}
		}
		return message;
	}

	public String dressingRooms(Players player[],int team){
		if(team == 1){
			for(int i=0;i<7;i++){
				int p = 0;	
				for(int j=0;j<7;j+=2){
					intallationsA[i][j] = player[p];
					p++;
				}			
			}
		}
		else{
			for(int i=0;i<7;i++){
				int p = 0;	
				for(int j=0;j<MAX_OFFICE;j+=2){
					intallationsB[i][j] = player[p];
					p++;
				}			
			}
		}
	}

	public void changeAmountTeams(int teams){
		main.setAmountTeams(teams);
	}

	public void addChamp(String name){
		main.getCham().add(name);
	}

	public String getName(){
		return name;
	}

	public String getIdCoach(){
		String id = main.getId();
		return id;
	}

}
