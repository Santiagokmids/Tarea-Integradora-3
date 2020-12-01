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

	//Methods
	/** 
	*Name: Formation.
	*Constructor of Formation <br> 
	*<b> post: </b> Start the class Formation.
   */
	public Formation(int date[]){
		this.date = date;
	 	Formation[][] formation = new Formation[LONG][WIDTH];
	}//end Constructor

	public Formation addLines(int def){
		for(int i=0;i<LONG;i++){	
			for(int j=0;j<WIDTH;j++){
				formation[i][j] = ;
				p++;
			}			
		}
	}
}