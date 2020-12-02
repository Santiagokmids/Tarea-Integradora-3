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

	public int[][] addLinesUps(int cd, int cm, int def){
		formation = new int[LONG][WIDTH];
		boolean exit = true, stop = true, end = true;
		for(int i=1;i<3;i++){	
			for(int j=1;j<WIDTH && exit;j++){
				formation[i][j] = 1;
				exit = false;
			}			
		}
		for(int i=4;i<6;i++){	
			for(int j=1;j<WIDTH && stop;j++){
				formation[i][j] = 1;
				stop = false;
			}			
		}
		for(int i=7;i<9;i++){	
			for(int j=1;j<WIDTH && end;j++){
				formation[i][j] = 1;
				end = false;
			}			
		}
		return formation;
	}

	public String messageLineUps(int formation[][]){
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

}