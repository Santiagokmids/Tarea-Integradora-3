package model;
import java.util.*;

public class Players extends Employees implements Price {

	//Atributes
	private int shirtNum;
	private int goalsAmount;
	private double averageCal;

	//Methods
	/** 
	*Name: Players.
	*Constructor of Players <br> 
	*<b> post: </b> Start the class Players.
   */
	public Players(String name, String id, int salary,int shirtNum,Position position){
		super(name, id, salary);
		this.shirtNum = shirtNum;
		goalsAmount = 0;
		averageCal = 0;
	}//end Constructor

	public boolean verifyShirt(int number){
		boolean exit = false;
		if(number >= 1 && number<100){
			exit = true;
		}
		return exit;
	}

	public int getShirtNum(){
		return shirtNum;
	}

	public void setShirtNum(){
		this.shirtNum = shirtNum;
	}

	public int getGoals(){
		return goalsAmount;
	}

	public void setGoals(){
		this.goalsAmount = goalsAmount;
	}

	public double getAverage(){
		return averageCal;
	}

	public void setAverage(){
		this.averageCal = averageCal;
	}

	public Position putPosition(int opt){
		Position position;
		if(opt == 1){
			position = Position.GK;
		}
		else if(opt == 2){
			position = Position.DEF;
		}
		else if(opt == 3){
			position = Position.MC;
		}
		else if(opt == 4){
			position = Position.CF;
		}
		return master;
	}



}