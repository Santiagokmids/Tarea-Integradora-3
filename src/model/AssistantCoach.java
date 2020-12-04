package model;
import java.util.*;

public class AssistantCoach extends Coach {

	//Relationships
	private Master masters;

	//Atributes
	private boolean playerOrNot;
	private Master[] master;

	//Methods
	/** 
	*Name: AssistantCoach.
	*Constructor of AssistantCoach <br> 
	*<b> post: </b> Start the class AssistantCoach.
   */
	public AssistantCoach(String name, String id, int salary,int yearsOfExp,boolean playerOrNot,Master master[]){
		super(name,id,salary,yearsOfExp);
		this.playerOrNot = playerOrNot;
		this.master = master;
	}//end Constructor

	public boolean getPlayer(){
		return playerOrNot;
	}

	public Master[] getMaster(){
		return master;
	}

	public void setMaster(Master master[]){
		this.master = master;
	}

	public String getMasters(){
		String message = "";
		for(int i = 0;i<getMaster().length;i++){
			message += getMaster()[i];
		}
		return message;
	}

	@Override
	public String toString(){
		String message = "",really = "",masters = "";
		if(getPlayer()){
			really = "Fue jugador profesional";
		}else
			really = "No fue jugador profesional";
		masters = getMasters();
		message = "\n ** Entrenador Asistente ** \n"+super.toString()+"\n -"+really+"\n -Experticias: "+getMasters()+"\n";
		return message;
	}
}