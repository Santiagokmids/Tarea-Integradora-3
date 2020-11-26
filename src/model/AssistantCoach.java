package model;
import java.util.*;

public class AssistantCoach extends Coach {

	//Atributes
	private boolean playerOrNot;

	//Methods
	/** 
	*Name: AssistantCoach.
	*Constructor of AssistantCoach <br> 
	*<b> post: </b> Start the class AssistantCoach.
   */
	public AssistantCoach(int yearsOfExp,boolean playerOrNot){
		super(yearsOfExp);
		this.playerOrNot = playerOrNot;
	}//end Constructor
}