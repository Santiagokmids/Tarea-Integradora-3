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
	public Players(String name, String id, int salary,int shirtNum, int goalsAmount, double averageCal){
		super(name, id, salary);
		this.shirtNum = shirtNum;
		this.goalsAmount = goalsAmount;
		this.averageCal = averageCal;
	}//end Constructor
}