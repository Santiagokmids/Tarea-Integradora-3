package model;
import java.util.*;

public class Team{

	//Constants
	public final static int MAX_OFFICE = 6;
	public final static int PLAY = 25;
	public final static int MAX_WIDTH = 7;
	public final static int MAX_LONG = 10;

	//Relationships
	private ArrayList<Formation> formation;
	private Players[][] installationsA;
	private Players[][] installationsB;
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
		player = new Players[PLAY];
		assistant = new AssistantCoach[3];
		formation = new ArrayList<Formation>();
		offices = new Coach[MAX_OFFICE][MAX_OFFICE];
	 	installationsA = new Players[MAX_WIDTH][MAX_WIDTH];
	 	installationsB = new Players[MAX_WIDTH][MAX_OFFICE];
	 }//end Constructor

	public void setName(String name){
		this.name = name;
	}

	public boolean verifyCoach(){
		boolean stop = false;
		if(countMain == 0){
			stop = true; 
		}
		return stop; 
	}

	public boolean verifyAss(){
		boolean stop = false;
		if(assistant[2] != null){
			stop = true; 
		}
		return stop; 
	}

	public boolean verifyPlayer(){
		boolean stop = false;
		if(player[24] != null){
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
			if(player[i] != null && player[i].getId().equalsIgnoreCase(id)){
				position = i;
				exit = false;
			}
			i++;
		}
		return position;
	}

	public int findPlayer(){
		boolean exit = true;
		int position = 0;
		for(int i = 0;exit && i<player.length;i++){
			if(player[i] == null){
				position = i;
				exit = false;
			}
		}
		return position;
	}

	public boolean findShirt(int number){
		boolean stop = false; 
		for(int i = 0;i<player.length;i++){
			if(player[i] != null){
				if(player[i].getShirtNum() == number){
					stop = true;
				}
			}
		}
		return stop;
	}

	public MainCoach addCoach(String name, String id, int salary,int years,int amountTeams,ArrayList<String> championships){ 
		main = new MainCoach(name, id, salary,years,amountTeams,championships);
		countMain += 1;
		return main;
	}

	public AssistantCoach addAss(String name, String id, int salary,int years,int opt,int master[]){ 
		int i = findAss();
		boolean exit = true;
		Master[] pro = new Master[master.length];
		for(int m = 0;m<pro.length && exit;m++){
			if(pro[m] == null && master[m] >= 1){
				pro[m] = putMaster(master[m]);
				exit = false;
			}
		}
		boolean player = player(opt);
		assistant[i] = new AssistantCoach(name, id, salary,years,player,pro);
		return assistant[i];
	}

	public Master putMaster(int opt){
		Master master = null;
		if(opt == 1){
			master = Master.OFFENSIVE;
		}
		else if(opt == 2){
			master = Master.DEFFENSIVE;
		}
		else if(opt == 3){
			master = Master.POSSESSION;
		}
		else if(opt == 4){
			master = Master.LAB_PLAYS;
		}
		else if(opt == 5){
			master = Master.GK_COACH;
		}
		else if(opt == 6){
			master = Master.PHY_COACH;
		}
		return master;
	}

	public boolean player(int opt){
		boolean player = true;
		if(opt == 2){
			player = false;
		}
		return player;
	}

	public Players addPlayer(String name, String id, int salary,int number,int position){ 
		int play = findPlayer();
		Position pos = putPosition(position);
		player[play] =  new Players(name, id, salary,number,pos);
		return player[play];
	}

	public Position putPosition(int opt){
		Position position = null;
		if(opt == 1){
			position = Position.GK;
		}
		else if(opt == 2){
			position = Position.DEF;
		}
		else if(opt == 3){
			position = Position.CM;
		}
		else if(opt == 4){
			position = Position.CF;
		}
		return position;
	}

	public String deleteEmploy(String id){
		String message = "";
		if(main.getId().equalsIgnoreCase(id)){
			boolean exit = false;
			main.setState(exit);
			message = "El entrenador "+main.getName()+" fue despedido";
			main = null;
		}
		boolean exit = true;
		for(int i = 0;i<assistant.length && exit;i++){
			if(assistant[i] != null && assistant[i].getId().equalsIgnoreCase(id)){
				String name = assistant[i].getName();
				assistant[i] = null;
				message = "El asistente "+name+" fue despedido";
				exit = false;
			}	
		}
		boolean stop;
		for(int m = 0;m<player.length;m++){
			if(player[m] != null && player[m].getId().equalsIgnoreCase(id)){
				String playName = player[m].getName();
				player[m] = null;
				message = "El jugador "+playName+" fue despedido";
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
				Master newPro = putMaster(master);	
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
			if(putMaster(pro) != master[i] && master[i] == null){
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
		String nit = "No hay jugadores con ese ID";
		if(i > -1){
			nit = player[i].getId();
		}
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
		player[i].setPosition(putPosition(position));
	}

	public void lineUp(int date[],int def, int mc, int cd,int tactic){
		int[][] lineUp = addLinesUps(cd, mc, def);
		Tactic tactics = putTactic(tactic);
		Formation line = new Formation(date,tactics,lineUp);
		formation.add(line);
	}

	public Tactic putTactic(int opt){
		Tactic tactic = null;
		if(opt == 1){
			tactic = Tactic.POSSESSION;
		}
		else if(opt == 2){
			tactic = Tactic.COUNTERATACK;
		}
		else if(opt == 3){
			tactic = Tactic.HIGH_PRESSURE;
		}
		else if(opt == 4){
			tactic = Tactic.DEFAULT;
		}
		return tactic;
	}

	public int[][] addLinesUps(int cd, int cm, int def){
		int [][]formation = new int[MAX_LONG][MAX_WIDTH];
		int count1 = 0, count2 = 0, count3 = 0;
		boolean exit = true, stop = true, end = true;
		for(int i=1;i<3;i++){	
			for(int j=1;j<MAX_WIDTH && exit;j++){
				formation[i][j] = 1;
				count1+=1;
				if(count1 == cd){
					exit = false;
				}
			}			
		}
		for(int i=4;i<6;i++){	
			for(int j=1;j<MAX_WIDTH && stop;j++){
				formation[i][j] = 1;
				count2+=1;
				if(count2 == cm){
					stop = false;
				}
			}			
		}
		for(int i=7;i<9;i++){	
			for(int j=1;j<MAX_WIDTH && end;j++){
				formation[i][j] = 1;
				count3+=1;
				if(count3 == def){
					end = false;
				}	
			}			
		}
		return formation;
	}

	public void asingOffice(ArrayList<Employees>employ){
		boolean exit = true;
		for(int i = 0;i<MAX_OFFICE;i++){
			for(int j = 0;j<MAX_OFFICE;j++){
				offices[i][j] = null;
			}
		}
		for(int i = 0;i<employ.size() && exit;i++){
			if(employ.get(i) instanceof AssistantCoach || employ.get(i) instanceof MainCoach){
				asign(employ.get(i));
			}
		}
	}

	public void asign(Employees employ){
		boolean exit = true;
		int count = 0;
		for(int i = 0;i<MAX_OFFICE && exit;i+=2){
			for(int j = 0;j<MAX_OFFICE && exit;j+=2){
				if((Employees)offices[i][j] == employ && !employ.getState()){
					offices[i][j] = null;
				}
				else if((Employees)offices[i][j] != employ || (Employees)offices[i][j] != employ){
					count += 1;
				}
			}
		}

		if(count == 9){
			for(int i = 0;i<MAX_OFFICE && exit;i+=2){
				for(int j = 0;j<MAX_OFFICE && exit;j+=2){
					if(offices[i][j] == null){
						if(employ instanceof MainCoach){
							offices[i][j] = (MainCoach)employ;
							exit = false; 
						}
						else if(employ instanceof AssistantCoach){
							offices[i][j] = (AssistantCoach)employ;
							exit = false; 
						}
					}
				}
			}
		}	
	}

	public String offices(){
		String message = "";
		boolean exit = true;
		for(int i=0;i<MAX_OFFICE && exit;i++){
			for(int j=0;j<MAX_OFFICE && exit;j++){
				if(offices[i][j] != null){
					message += " ["+offices[i][j].getName()+"] ";
				}
				else if(offices[0][0] == null){
					message = "No hay entrenadores en las oficinas";
					exit = false;
				}
				else if(offices[i][j] == null){
					message += " [Vacio] ";
				}
			}
			message += "\n";
		}
		return message;
	}

	public String lines(){
		String message = " **** Alineaciones **** \n";
		if(formation.size() == 0){
			message = "\nNo hay Alineaciones creadas";
		}else{
			for(int i = 0;i<formation.size();i++){
				message += " ["+formation.get(i).messageLineUps()+"] ";
			}
		}
		return  message;
	}

    public String showInfoTeam(){
        String message = "\n***** Equipo *****\n"+
        " -Nombre del Equipo: "+getName();
        return message;
    }

    public int countPlayers(){
    	int count = 0;
    	for(int p = 0;p<player.length;p++){
    		if(player[p] != null){
    			count += 1;
    		}
    	}
    	return count;
    }

    public String playerPositionA(){
    	String message = "";
    	boolean exit = true;
    	Players[] players = new Players[countPlayers()];
    	for(int p = 0;p<player.length;p++){
    		for(int m = 0;m<players.length && exit;m++){
    			if(player[p] != null && player[m] == null){
    				players[m] = player[p];
    				exit = false;
    			}
    		}	
    	}
	   	List<Players>installations = Arrays.asList(player);
	 	Collections.shuffle(installations);
	  	installations.toArray(player);
	  	message = " \n***** Jugadores en los Camerinos *****\n";
		for(int i = 0;i<player.length;i++){
	  		if(player[i] != null){
	  			message += installationsA(installations.get(i));
	  		}
	  	}
    	return message;
    }

    public String installationsA(Players player){
    	String message = "";
    	boolean exit = true;
    	for(int i = 0;i<MAX_WIDTH && exit;i++){
			for(int j = 0;j<MAX_WIDTH && exit;j+=2){
				if(installationsA[i][j] == null && player != null){
					installationsA[i][j] = player;
					message = " ["+installationsA[i][j].getName()+"] ";
					exit = false; 
				}if(j == MAX_WIDTH-1){
					message += "\n";
				}
			}
		}
		return  message;
    }

    public String playerPositionB(){
    	String message = "";
    	boolean exit = true;
    	Players[] players = new Players[countPlayers()];
    	for(int p = 0;p<player.length;p++){
    		for(int m = 0;m<players.length && exit;m++){
    			if(player[p] != null && player[m] == null){
    				players[m] = player[p];
    				exit = false;
    			}
    		}	
    	}
	   	List<Players>installations = Arrays.asList(player);
	 	Collections.shuffle(installations);
	  	installations.toArray(player);
	  	message = " \n***** Jugadores en los Camerinos *****\n";
	  	for(int i = 0;i<player.length;i++){
	  		if(player[i] != null){
	  			message += installationsB(installations.get(i));
	  		}
	   	}
    	return message;
    }

    public String installationsB(Players player){
    	String message = "";
    	boolean exit = true;
    	for(int i = 0;i<MAX_WIDTH && exit;i++){
			for(int j = 0;j<MAX_OFFICE && exit;j+=2){
				if(installationsB[i][j] == null && player != null){
					installationsB[i][j] = player;
					message = " ["+installationsB[i][j].getName()+"] ";
					exit = false; 
				}if(j == MAX_OFFICE-1){
					message += "\n";
				}
			}
		}
		return  message;
    }

    public String showEmployees(){
    	String message = "";
    	if(main != null){
    		message += main.toString()+"\n";
    	}else
    		message += "\nEl Equipo no tiene entrenador principal\n";
    	if(assistant[0] != null){
    		boolean exit = true;
    		for(int i = 0;i<assistant.length && exit;i++){
    			if(assistant[i] == null){
    				exit = false;
    			}else
    				message += assistant[i].toString()+"\n";
    		}
    	}else 
    		message += "\nEl Equipo no tiene entrenadores asistentes\n";

    	if(player[0] != null || player[1] != null){
    		boolean stop = true;
    		for(int i = 0;i<player.length && stop;i++){
    			if(player[i] == null){
    				stop = false;
    			}else
    				message += player[i].toString()+"\n";
    		}	
    	}else 
    		message += "\nEl Equipo no tiene jugadores\n";
    	return message;
    }

    public void getNameTeam(String name){
    	setName(name);
    }
}

