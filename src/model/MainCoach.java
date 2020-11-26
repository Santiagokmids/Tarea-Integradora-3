package model;
import java.util.*;

public class MainCoach extends Coach implements Price{

	//Atributes
	private int amountTeams;
	private ArrayList <String> championships;

	//Methods
	/** 
	*Name: MainCoach.
	*Constructor of MainCoach <br> 
	*<b> post: </b> Start the class MainCoach.
   */
	public MainCoach(int yearsOfExp,int amountTeams,ArrayList championships[]){
		super(yearsOfExp);
		this.amountTeams = amountTeams;
		this.championships = championships;
	}//end Constructor
}