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
	private AssistantCoach assistant;
	private Players[] player;

	//Atributes
	private String name;
	private int countMain;
	private int countAss;

	//Methods
	/** 
	*Name: Team.
	*Constructor of Team <br> 
	*<b> post: </b> Start the class Team.
   */
	public Team(String name){
		this.name = name;
		countMain = 0;
		countAss = 0;
		player = new Players[25];
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
		if(countMain < 4){
			stop = true; 
		}
		return stop; 
	}

	public MainCoach addCoach(String name, String id, int salary,int years,int amountTeams,String championships[]){ 
		MainCoach obj = new MainCoach(name, id, salary,years,amountTeams,championships[]);
		countMain += 1;
		return obj;
	}

	public AssistantCoach addAss(String name, String id, int salary,int years,int master){ 
		AssistantCoach obj = new AssistantCoach(name, id, salary,years,);
		countMain += 1;
		return obj;
	}

	public String getName(){
		return name;
	}

}
