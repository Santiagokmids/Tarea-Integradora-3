package model;
import java.util.*;

public class Club{

	//Relationships
	private Team teamA;
	private Team teamB;
	private ArrayList <Employees> employ;

	//Artibutes
	private String name;
	private String nit;
	private int[]fundation;

	//Methods
	 /** 
		*Name: Club.
		*Constructor of class Club <br> 
		*<b> post: </b> The class was initializaded..
	   */
	public Club(String name, String nit, int fundation[], String nameA, String nameB){
		this.name = name;
		this.nit = nit;
		this.fundation = fundation;
		employ = new ArrayList<Employees>();
		teamA = new Team(nameA);
		teamB = new Team(nameB);
	}//End constructor

    public String showTeams(){
    	String message = "El club no tiene 2 equipos";
    	if(teamA != null && teamB != null){
    		message = "\n[1]"teamA.getName()"\n[2]"teamB.getName()"\n";
    	}
    	return message;
    }

    public boolean findEmploy(String id){
    	boolean exit = true, stop = true;
    	for(int i = 0;i<employ.size() && exit;i++){
    		String nit = employ.get(i).getId();
    		if(nit.equalsIgnoreCase(id)){
    			exit = false;
    			stop = false;
    		}
    	}
    	return stop;
    }

    public String addCoach(String name, String id, int salary,int years,int amountTeams,ArrayList championships[],int opt){
    	String message = "El Entrenador no pudo ser agregado. Ya hay uno en su lugar";
    	if(opt == 1){
    		boolean exit = teamA.verifyCoach();
    		if(exit){
    			employ.add(teamA.addCoach(name,id,salary,years,amountTeams,championships[]));
    			message = "Entrenador contratado correctamente";
    		}
    	}
    	else {
    		boolean stop = teamB.verifyAss();
    		if(stop){
	    		employ.add(teamB.addCoach(name,id,salary,years,amountTeams,championships[]));
	    		message = "Entrenador contratado correctamente";
	    	}
    	}
    	return message;
    }

    public String
}