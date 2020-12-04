package model;
import java.util.*;

public class Formation{

	//Constants
	public final static int WIDTH = 7;
	public final static int LONG = 10;

	//Relationships
	private Tactic tactics;

	//Atributes
	private int date[];
	private Tactic tactic;
	private int[][] formation;

	//Methods
	/** 
	*Name: Formation.
	*Constructor of Formation <br> 
	*<b> post: </b> Start the class Formation.
   */
	public Formation(int date[], Tactic tactic,int[][] formation){
		this.date = date;
	 	this.tactic = tactic;
	 	this.formation = formation;

	}//end Constructor

	public String messageLineUps(){
		int def = 0, mc = 0, dc = 0;
		for(int i = 0;i<3;i++){
			for(int j = 0;j<WIDTH;j++){
				dc += formation[i][j];
			}
		}
		for(int i = 3;i<6;i++){
			for(int j = 0;j<WIDTH;j++){
				mc += formation[i][j];
			}
		}
		for(int i = 6;i<9;i++){
			for(int j = 0;j<WIDTH;j++){
				def += formation[i][j];
			}
		}
		String message = def+"-"+mc+"-"+dc;
		return message;
	}

}