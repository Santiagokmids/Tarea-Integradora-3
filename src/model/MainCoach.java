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
	public MainCoach(String name, String id, int salary,int yearsOfExp,int amountTeams,ArrayList<String> championships){
		super(name,id,salary,yearsOfExp);
		this.amountTeams = amountTeams;
		this.championships = championships;
	}//end Constructor

	public int getAmountTeams(){
		return amountTeams;
	}

	public void setAmountTeams(int amountTeams){
		this.amountTeams = amountTeams;
	}

	public ArrayList<String> getCham(){
		return championships;
	}

	public double marketPrice(){
		double x = 0;
		return x;
	}
}