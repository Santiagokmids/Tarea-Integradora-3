package model;
import java.util.*;

public class Coach extends Employees{

	//Atributes
	private int yearsOfExp;

	//Methods
	/** 
	*Name: Coach.
	*Constructor of Coach <br> 
	*<b> post: </b> Start the class Coach.
   */
	public Coach(String name, String id, int salary,int yearsOfExp){
		super(name, id, salary);
		this.yearsOfExp = yearsOfExp;
	}//end Constructor

}
