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
    *@param date. array of integers where is the date of creation of the lineUp. The position 0 cant be more that 31 and the position 1 cant be more that 12.
    *@param tactic. Object of Tactis that give the tactic of the lineUp.
    *@param formation. Matriz of formation that have the lineUp. 
   */
	public Formation(int date[], Tactic tactic,int[][] formation){
		this.date = date;
	 	this.tactic = tactic;
	 	this.formation = formation;

	}//end Constructor

	 /** 
        *Name: messageLineUps
        *Show the information about lineUps of the team<br> 
        *<b> post: </b> information about lineUps of the team.
        *@return String message. This is the message where is the information about lineUps.
       */
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
		String message = def+"-"+mc+"-"+dc+" creada el dia: "+getDate()[0]+"/"+getDate()[1]+"/"+getDate()[2]+
		" con una tactica de "+getTactic();
		return message;
	}//end messageLineUps

	 /** 
        *Name: getDate.
        *Get the date about when was created the lineUp<br> 
        *<b> post: </b> Date of creation of the lineUp.
        *@return int[] date. This is the date of creation of the lineUp.
       */
	public int[] getDate(){
		return date;
	}//end getDate

	 /** 
        *Name: getTactic.
        *Get the tactic of the lineUp<br> 
        *<b> post: </b> Tactic of the lineUp.
        *@return Tactic tacit. This is the object of tactic of the lineUp.
       */
	public Tactic getTactic(){
		return tactic;
	}//end getTactic

}//end Formation