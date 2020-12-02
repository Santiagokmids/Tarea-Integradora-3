package model;
import java.util.*;

public class Team{

	//Constants
	public final static int MAX_OFFICE = 6;
	public final static int PLAY = 25;

	//Relationships
	private ArrayList<Formation> formation;
	private Formation lineUps;
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
		player = new Players[PLAY];
		assistant = new AssistantCoach[3];
		formation = new ArrayList<Formation>();
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

	public int foundAss(String id){
		boolean exit = true;
		int i = 0, position = -1;
		while(exit && i<assistant.length){
			if(assistant[i] != null && assistant[i].getName().equalsIgnoreCase(id)){
				position = i;
				exit = false;
			}
			i++;
		}
		return position;
	}

	public int foundPly(String id){
		boolean exit = true;
		int i = 0, position = -1;
		while(exit && i<player.length){
			if(player[i] != null && player[i].getName().equalsIgnoreCase(id)){
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
				if(player[i].getShirtNum() == number){
					stop = true;
				}
			}
		}
		return stop;
	}

	public MainCoach addCoach(String name, String id, int salary,int years,int amountTeams,ArrayList<String> championships){ 
		MainCoach main = new MainCoach(name, id, salary,years,amountTeams,championships);
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

	public Players addPlayer(String name, String id, int salary,int number,int position){ 
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

	public void changeAmountTeams(int teams){
		main.setAmountTeams(teams);
	}

	public void addChamp(String name){
		main.getCham().add(name);
	}

	public boolean addMaster(String id,int master){
		int i = foundAss(id);
		boolean exit = false;
		Master[] newMaster = new Master[assistant[i].getMaster().length + 1];
		newMaster = assistant[i].getMaster();
		if(newMaster.length < 6){
			int m = findPos(id,master,newMaster);
			if(m == -1){
				exit = true;
			}else{
				Master newPro = assistant[i].putMaster(master);	
				newMaster[m] = newPro;
				assistant[i].setMaster(newMaster);
			}
		}
		return exit;
	}

	public int findPos(String id,int pro,Master master[]){
		boolean exit = true;
		int position = -1;
		int p = foundAss(id);
		for(int i = 0;i<master.length && exit;i++){
			if(assistant[p].putMaster(pro) != master[i] && master[i] == null){
				exit = false;
				position = i;
			}
		}
		return position;
	}

	public String getName(){
		return name;
	}

	public String getIdCoach(){
		String id = main.getId();
		return id;
	}

	public String getNameCoach(){
		String name = main.getName();
		return name;
	}

	public String getIdAs(String id){
		int i = foundAss(id);
		String nit = assistant[i].getId();
		return nit;
	}

	public String getIdPly(String id){
		int i = foundPly(id);
		String nit = player[i].getId();
		return nit;
	}

	public void setExpCoach(int years){
		main.setYears(years);
	}

	public void setExpAss(String id, int years){
		int i = foundAss(id);
		assistant[i].setYears(years);
	}

	public void setNumber(String id,int number){
		int i = foundPly(id);
		player[i].setShirtNum(number);
	}

	public void setGoals(String id,int goals){
		int i = foundPly(id);
		player[i].setGoals(goals);
	}

	public void setAverage(String id, double average){
		int i = foundPly(id);
		player[i].setAverage(average);
	}

	public void setPosition(String id, int position){
		int i = foundPly(id);
		player[i].setPosition(player[i].putPosition(position));
	}

	public void lineUps(int date[],int def, int mc, int cd,int tactic){
		int[][] lineUp = lineUps.addLinesUps(cd, mc, def);
		Formation line = new Formation(date,lineUps.putTactic(tactic),lineUp);
		formation.add(line);
	}

	public void asingOffice(ArrayList<Employees>employ){
		boolean exit = true;
		for(int i = 0;exit;i++){
			if(employ.get(i) instanceof AssistantCoach || employ.get(i) instanceof MainCoach){
				asign(employ.get(i));
			}
		}
	}

	public void asign(Employees employ){
		boolean exit = true;
		for(int i = 0;i<MAX_OFFICE && exit;i+2){
			for(int j = 0;j<MAX_OFFICE && exit;j+2){
				if(offices[i][j] == null){
					if(employ instanceof MainCoach){
						offices[i][j] = (MainCoach)employ;
						exit = false; 
					}
					else if(employ instanceof AssistantCoach){
						offices[i][j] = (AssistantCoach)employ;
						exit = false; stop = false;
					}
				}
			}
		}
	}

	public String lines(){
		String message = lineUps.messageLineUps();
		return  message;
	}

    public String showInfoTeamA(){
        String message = "***** Equipo A *****\n"+
        " -Nombre del Equipo: "+getName();
        return message;
    }

    public String showInfoTeamB(){
        String message = "***** Equipo B *****\n"+
        "- Nombre del Equipo: "+getName();
        return message;
    }

    public String showOffices(){
    	String message = "";
    	for(int i=0;i<MAX_OFFICE;i++){
			for(int j=0;j<MAX_OFFICE;j++){
				message += (" ["+offices[i][j]+"] ");
				
			}
			message += "\n";
		}
		return message;
    }
}

