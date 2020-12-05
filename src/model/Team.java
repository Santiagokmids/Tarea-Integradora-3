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
	 *@param name. name of the team .
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

	 /** 
		*Name: setName.
		*Change the name of one team <br> 
		*@param name. new name of the team .
		*<b> post: </b> The name of the team was update.
	   */
	public void setName(String name){
		this.name = name;
	}//end setName


	 /** 
		*Name: verifyCoach.
		*Verify if the team have or not coach <br> 
		*<b> post: </b> The value of the verify.
		*@return boolean stop. This is the value of the verify.
	   */
	public boolean verifyCoach(){
		boolean stop = false;
		if(countMain == 0){
			stop = true; 
		}
		return stop; 
	}//end verifyCoach


	 /** 
		*Name: verifyAss.
		*Verify if the team have or not assistant coach <br> 
		*<b> post: </b> The value of the verify.
		*@return boolean stop. This is the value of the verify.
	   */
	public boolean verifyAss(){
		boolean stop = false;
		if(assistant[2] != null){
			stop = true; 
		}
		return stop; 
	}//end verifyAss


	 /** 
		*Name: verifyPlayer.
		*Verify if the team have or not players <br> 
		*<b> post: </b> The value of the verify.
		*@return boolean stop. This is the value of the verify.
	   */
	public boolean verifyPlayer(){
		boolean stop = false;
		if(player[24] != null){
			stop = true; 
		}
		return stop; 
	}//end of verifyPlayer


	 /** 
		*Name: findAss.
		*Find the position of the assitant coach empty<br> 
		*<b> post: </b> The position of the assistant coach empty.
		*@return int position. This is the position empty in the team for add a assistant coach.
	   */
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
	}//end findAss

	 /** 
		*Name: foundAss.
		*Find the position of the assitant coach <br> 
		*<b> post: </b> The position of the assistant coach.
		*@param id. id of the assistant coach.
		*@return int position. This is the position where is the assistant coach.
	   */
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
	}//end foundAss

	/** 
		*Name: foundPly.
		*Find the position of the player <br> 
		*<b> post: </b> The position of the player.
		*@param id. id of the player.
		*@return int position. This is the position where is the player.
	   */
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
	}//end position

	/** 
		*Name: findPlayer.
		*Find the position empty of players <br> 
		*<b> post: </b> The position empty of the players.
		*@return int position. This is the position empty of the players.
	   */
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
	}//end findPlayer

	/** 
		*Name: findShirt.
		*Find shirt number of a player<br> 
		*<b> post: </b> The value if the shirt was found.
		*@param number. shirt number of the player. Cant be less of 0 and more that 99.
		*@return boolean stop. This is value if the shirt number was found.
	   */
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
	}//end findShirt

	 /** 
        *Name: addCoach.
        *Add employee of kind main coach to the team<br> 
        *<b> post: </b> The main coach was add to the team.
        *@param name. name of the main coach.
        *@param id. id of the main coach.
        *@param salary. salary of the main coach. Cant be less of 0.
        *@param years. years of experience of the main coach. Cant be less of 0.
        *@param amountTeams. amount of teams of the main coach.
        *@param championships. arrayList of Strings with of the name of the championships.
        *@return MainCoach main. This is the object of the mainCoach that was add.
       */
	public MainCoach addCoach(String name, String id, int salary,int years,int amountTeams,ArrayList<String> championships){ 
		main = new MainCoach(name, id, salary,years,amountTeams,championships);
		countMain += 1;
		return main;
	}//end addCoach

	 /** 
        *Name: addAss.
        *Add employee of kind Assistant coach to the team<br> 
        *<b> post: </b> The assistant coach was add to the team.
        *@param name. name of the assistant coach.
        *@param id. id of the assistant coach.
        *@param salary. salary of the assistant coach. Cant be less of 0.
        *@param years. years of experience of the assistant coach. Cant be less of 0.
        *@param opt. number that give the value of the assistant coach if was or not player. Cant be more that 2 and less that 0.
        *@param master. array of integers with of the experticies of the assistant Coach.
        *@return AssistantCoach assistant[]. This is the object of the assistant Coach that was add.
       */
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
	}//end addAss

	 /** 
        *Name: putMaster.
        *Put experticie to one assistant Coach<br> 
        *<b> post: </b> The experticie was put.
        *@param opt. number that give the experticie of the assistant coach. Cant be more that 6 and less that 1.
        *@return Master master. This is the object of the experticie that was put to a asssitant Coach.
       */
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
	}//end putMaster

	 /** 
        *Name: player.
        *Value if the assistant coach was or not player<br> 
        *<b> post: </b> The value of the question if the assistant coach was or not assistant coach.
        *@param opt. number that give the value of the assistant coach if was or not player. Cant be more that 2 and less that 1.
        *@return boolean Player. This is the value if the assistant coach was or not player.
       */
	public boolean player(int opt){
		boolean player = true;
		if(opt == 2){
			player = false;
		}
		return player;
	}//end player

	 /** 
        *Name: addPlayer.
        *Add employee of kind player to the team<br> 
        *<b> post: </b> The player was add to the team.
        *@param name. name of the player.
        *@param id. id of the player.
        *@param salary. salary of the player. Cant be less of 0.
        *@param number. shirt number of the player. Cant be less of 0 and more that 99.
        *@param position. number that give the position of the player. Cant be more that 4 and less that 0.
        *@return Players player[]. This is the object of players that was add.
       */
	public Players addPlayer(String name, String id, int salary,int number,int position){ 
		int play = findPlayer();
		Position pos = putPosition(position);
		player[play] =  new Players(name, id, salary,number,pos);
		return player[play];
	}

	 /** 
        *Name: putPosition.
        *Put position to one Player<br> 
        *<b> post: </b> The position was put.
        *@param opt. number that give the position of the player. Cant be more that 4 and less that 0.
        *@return Position position. This is the object of the position that was put to a player.
       */
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
	}//end putPosition

	 /** 
        *Name: deleteEmploy.
        *Delete a employee<br> 
        *<b> post: </b> The employee was deleted.
        *@param id. id of the employee.
        *@return String message. This is a message if the employee was deleted.
       */
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
	}//End deleteEmploy

	 /** 
        *Name: changeAmountTeams.
        *Change the number of teams that the coach directed<br> 
        *<b> post: </b> The amount of what teams has been directed the coach.
        *@param teams. number of teams that have the main coach.
       */
	public void changeAmountTeams(int teams){
		main.setAmountTeams(teams);
	}//end changeAmountTeams

	 /** 
        *Name: addChamp.
        *Update championships of the coach<br> 
        *<b> post: </b> Add championships of the coach.
		*@param name. name of the championship.
       */
	public void addChamp(String name){
		main.getCham().add(name);
	}//end addChamp

	 /** 
        *Name: addMaster.
        *Update the experticies of the one assistant coach<br> 
        *<b> post: </b> Add experticias to one assitant coach.
        *@param id. id of the assitant coach.
        *@param master. integer of give the experticie for the assistent coach. Cant be less of 1 and more that 6.
        *@return boolean exit. This is the value if was or not update the experticies of the assistant coach.
       */   
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
	}//End addMaster

	 /** 
        *Name: findPos.
        *Find position where is the experticies<br> 
        *<b> post: </b> The position of the expertice.
        *@param id. id of the assitant coach.
        *@param pro. integer of give the experticie for the assistent coach. Cant be less of 1 and more that 6.
        *@param master. array of Master that have the experticies of assistent coach.
        *@return int position. This is the position of the experticie found.
       */   
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
	}//end findPos

	 /** 
        *Name: getName.
        *Get the name of the team<br> 
        *<b> post: </b> Name the team.
        *@return String name. This is the name of the team.
       */
	public String getName(){
		return name;
	}//end getTeam

     /** 
        *Name: getIdCoach.
        *Get the id of the main coach<br> 
        *<b> post: </b> ID of the main coach.
        *@return String id. This is the id of the main coach.
       */
	public String getIdCoach(){
		String id = main.getId();
		return id;
	}//end getIdCoach


     /** 
        *Name: getNameCoach.
        *Get the name of the coach<br> 
        *<b> post: </b> Name of the coach.
        *@return String name. This is the Name of the coach.
       */
	public String getNameCoach(){
		String name = main.getName();
		return name;
	}//end getNameCoach


     /** 
        *Name: getIdAs.
        *Get the id of the assistant Coach<br> 
        *<b> post: </b> ID of the assistant coach.
        *@param id. id of the assitant coach.
        *@return String nit. This is the ID of the assitant coach.
       */
	public String getIdAs(String id){
		int i = foundAss(id);
		String nit = assistant[i].getId();
		return nit;
	}//end getIdAs

	  /** 
        *Name: getIdPky.
        *Get the id of the player<br> 
        *<b> post: </b> ID of the player.
        *@param id. id of the player.
        *@return String nit. This is the ID of the player.
       */
	public String getIdPly(String id){
		int i = foundPly(id);
		String nit = "No hay jugadores con ese ID";
		if(i > -1){
			nit = player[i].getId();
		}
		return nit;
	}//end getIdPly

	 /** 
        *Name: setExpCoach.
        *Change the experience of one main coach<br> 
        *<b> post: </b> Change experience of one main coach.
        *@param years. number of years of the main coach.
      */
	public void setExpCoach(int years){
		main.setYears(years);
	}//end setExpCoach

	 /** 
        *Name: setExpAss.
        *Change the experience of one assistant coach<br> 
        *@param id. id of the assistant coach.
        *@param years. integer that give the years if experience of the assitant coach.
        *<b> post: </b> Change experience of one assistant coach.
       */
	public void setExpAss(String id, int years){
		int i = foundAss(id);
		assistant[i].setYears(years);
	}//end setExpAss

	 /** 
        *Name: setNumber.
        *Change the shirt number of one player<br> 
        *<b> post: </b> Change shirt number of one player.
        *@param id. id of the player.
        *@param number. integer that give the shirt number of the player. Cant be less of 1 and more that 99.
       */
	public void setNumber(String id,int number){
		int i = foundPly(id);
		player[i].setShirtNum(number);
	}//end setNumber

	 /** 
        *Name: setGoals.
        *Update the goals of one player<br> 
        *<b> post: </b> Change shirt goals of one player.
        *@param id. id of the player.
        *@param goals. integer of goals of the player. Cant be less that 0.
       */
	public void setGoals(String id,int goals){
		int i = foundPly(id);
		player[i].setGoals(goals);
	}//end setGoals

	 /** 
        *Name: setAverage.
        *Change the average calification of one player<br> 
        *<b> post: </b> Change average calification of one player.
        *@param id. id of the player.
        *@param average. number double that give the average calification of the player. Cant be less of 0 and more that 10.
       */
	public void setAverage(String id, double average){
		int i = foundPly(id);
		player[i].setAverage(average);
	}//end setAverage

	 /** 
        *Name: setPosition.
        *Change the position of one player<br> 
        *<b> post: </b> Change position of one player.
        *@param id. id of the player.
        *@param position. number that give the position of the player. Cant be more that 4 and less that 1.
       */
	public void setPosition(String id, int position){
		int i = foundPly(id);
		player[i].setPosition(putPosition(position));
	}//end setPosition

	 /** 
        *Name: lineUp.
        *Add lineUp to the amount of lineUps of one team<br> 
        *<b> post: </b> LineUp add to a team.
        *@param date. array of integers where is the date of creation of the lineUp. The position 0 cant be more that 31 and the position 1 cant be more that 12.
        *@param def. number of defenses of the lineUp. Cant be less of 0 and more that 8.
        *@param mc. number of midfielders of the lineUp. Cant be less of 0 and more that 8..
        *@param cd. number of fordwards of the lineUp. Cant be less of 0 and more that 8.
        *@param tactic. number that give the tactic of the lineUp. Cant be more that 4 and less 1.
       */
	public void lineUp(int date[],int def, int mc, int cd,int tactic){
		int[][] lineUp = addLinesUps(cd, mc, def);
		Tactic tactics = putTactic(tactic);
		Formation line = new Formation(date,tactics,lineUp);
		formation.add(line);
	}//end lineUp

	 /** 
        *Name: putTactic.
        *Put Tactic to one lineUp<br> 
        *<b> post: </b> Tactic in a lineUp.
        *@param opt. number that give the tactic of the lineUp. Cant be more that 4 and less 1.
        *@return Tactic tactic. This is the tactic that add to a lineUp.
       */
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
	}//end putTactic

	/** 
        *Name: addLinesUps.
        *Add lineUp with their positions to a team<br> 
        *<b> post: </b> LineUp was add.
        *@param cd. number of fordwards of the lineUp. Cant be less of 0 and more that 8.
        *@param cm. number of midfielders of the lineUp. Cant be less of 0 and more that 8..
        *@param def. number of defenses of the lineUp. Cant be less of 0 and more that 8.
        *@return int[][] formation. This is the matriz of lineUp that add to a team.
       */
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
	}//end addLineUps

	/** 
        *Name: asingOffice.
        *Add coach's to the offices of the club<br> 
        *<b> post: </b> Coach's in the office of the club.
        *@param employ. ArrayList of employees.
      */
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
	}//end asingOffice

	/** 
        *Name: asign.
        *Put the coach's in the offices<br> 
        *<b> post: </b> Put all the coach's in their offices.
        *@param employ. Employee with active state.
       */
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
	}//end asign

	/** 
        *Name: offices.
        *Show the information of the offices of the club<br> 
        *<b> post: </b> Information about offices.
        *@return String message. This is the message where is the information about offices of the club.
       */
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
	}//end offices

	/** 
        *Name: lines.
        *Show the information of the lineUps of the team<br> 
        *<b> post: </b> Information about lineUps.
        *@return String message. This is the message where is the information about lineUps in the club.
       */
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
	}//end lines

	/** 
        *Name: showInfoTeam.
        *Show the information of the team of the club<br> 
        *<b> post: </b> Information about team.
        *@return String message. This is the message where is the information about team of the club.
       */
    public String showInfoTeam(){
        String message = "\n***** Equipo *****\n"+
        " -Nombre del Equipo: "+getName();
        return message;
    }//end showInfoTeam

    /** 
        *Name: countPlayers.
        *Get the amount of players in the team<br> 
        *<b> post: </b> Amount of players in the team.
        *@return int count. This is the amount of players in the team.
       */
    public int countPlayers(){
    	int count = 0;
    	for(int p = 0;p<player.length;p++){
    		if(player[p] != null){
    			count += 1;
    		}
    	}
    	return count;
    }//end countPlayers

    /** 
        *Name: playerPositionA.
        *Put the players in the dressing room of the team A<br> 
        *<b> post: </b> Players in the dressing room of the team A.
        *@return String message. This is the message where is the information about players in the dressing room.
       */
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
    }//end playerPositionA

     /** 
        *Name: installationsA.
        *Show the information about dressing room of the team A<br> 
        *<b> post: </b> information about dressing room of the team A.
        *@param player. Player of type Players.
        *@return String message. This is the message where is the information about dressing room.
       */
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
    }//end installationsA

     /** 
        *Name: playerPositionB.
        *Put the players in the dressing room of the team B<br> 
        *<b> post: </b> Players in the dressing room of the teamB.
        *@return String message. This is the message where is the information about players in the dressing room.
       */
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
    }//end playerPositionB

     /** 
        *Name: installationsB.
        *Show the information about dressing room of the team B<br> 
        *<b> post: </b> information about dressing room of the team B.
        *@param player. Player of type Players.
        *@return String message. This is the message where is the information about dressing room.
       */
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
    }//end installationsB

     /** 
        *Name: showEmployees.
        *Show the employees that are in the team<br> 
        *<b> post: </b> The employees that are in the team.
        *@return String message. This is the message about the employees that are in the team.
       */
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
    }//end showEmployees

     /** 
        *Name: getNameTeam.
        *Get the name of the team<br> 
        *<b> post: </b> Name of the team.
        *@param name. new name for the team.
       */
    public void getNameTeam(String name){
    	setName(name);
    }//end getNameTeam
    
}//end team

