package model;
import java.util.*;

public class Team{

	//Constants
	public final static int MAX_OFFICE = 6;

	//Relationships
	private ArrayList<Formation> formationA;
	private ArrayList<Formation> formationB;
	private Installations intallationsA;
	private Installations intallationsB;
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
		player = new Players[25];
		assistant = new AssistantCoach[3];
		formationA = new ArrayList<Formation>();
		formationB = new ArrayList<Formation>();
	 	Coach[][] offices = new Coach[MAX_OFFICE][MAX_OFFICE];
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

	public MainCoach addCoach(String name, String id, int salary,int years,int amountTeams,String championships[]){ 
		MainCoach obj = new MainCoach(name, id, salary,years,amountTeams,championships[]);
		countMain += 1;
		return obj;
	}

	public AssistantCoach addAss(String name, String id, int salary,int years,int opt,int master){ 
		int i = findAss();
		Master pro = assistant[i].putMaster(master);
		boolean player = assistant[i].player(opt);
		AssistantCoach obj = new AssistantCoach(name, id, salary,years,player,pro);
		return obj;
	}

	public String getName(){
		return name;
	}

}
