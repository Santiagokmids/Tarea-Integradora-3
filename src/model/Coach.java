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
	*@param name. name of the coach.
    *@param id. id of the coach.
    *@param salary. salary of the coach. Cant be less of 0.
    *@param yearsOfExp. years of experience of the coach. Cant be less of 0.
   */
	public Coach(String name, String id, int salary,int yearsOfExp){
		super(name, id, salary);
		this.yearsOfExp = yearsOfExp;
	}//end Constructor

	 /** 
        *Name: getYears.
        *Get the years of experience of the coach's<br> 
        *<b> post: </b> Years of experience of the coach.
        *@return int yearsOfExp. This is the years of experience of the coach.
       */
	public int getYears(){
		return yearsOfExp;
	}//end getYears


	/** 
        *Name: setYears.
        *Change the years of experience of the coach<br> 
        *<b> post: </b> New years of experience of the coach.
        *@param yearsOfExp. years of experience of the coach. Cant be less of 0.
       */
	public void setYears(int yearsOfExp){
		this.yearsOfExp = yearsOfExp;
	}//end setYears

	 /** 
        *Name: toString.
        *Show the information of the coach<br> 
        *<b> post: </b> Information about coach.
        *@return String message. This is the message where is the information about coach.
       */
	@Override
	public String toString(){
		String message = "";
		message = super.toString()+"\n -Anios de experiencia: "+getYears();
		return message;
	}//end toString

}//end Coach
