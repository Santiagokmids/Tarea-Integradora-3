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
	*@param name. name of the assistant coach.
    *@param id. id of the assistant coach.
    *@param salary. salary of the assistant coach. Cant be less of 0.
    *@param yearsOfExp. years of experience of the assistant coach. Cant be less of 0.
    *@param playerOrNot. value boolean that give the value of the assistant coach if was or not player. 
    *@param master. array of Master with the experticies of the assistant Coach. Cant have more that 6 experticies.
   */
	public AssistantCoach(String name, String id, int salary,int yearsOfExp,boolean playerOrNot,Master master[]){
		super(name,id,salary,yearsOfExp);
		this.playerOrNot = playerOrNot;
		this.master = master;
	}//end Constructor

	/** 
        *Name: getPlayer.
        *Get the value of the Assistant coach if was player or not<br> 
        *<b> post: </b> Value of player or not of the assistant coach.
        *@return boolean playerOrNot. This is the value if the assistant coach was or not player.
       */
	public boolean getPlayer(){
		return playerOrNot;
	}//end getPlayer

	/** 
        *Name: getMaster.
        *Get the experticies of the assistant coach<br> 
        *<b> post: </b> Experticies of the assistant coach.
        *@return Master[] master. This are the experticies of the assistant coach.
       */
	public Master[] getMaster(){
		return master;
	}//end getMaster

	/** 
        *Name: setMaster.
        *Change the experticies of the assistant coach<br> 
        *<b> post: </b> New experticies of the assistant coach.
        *@param master. array of Master with the experticies of the assistant Coach. Cant have more that 6 experticies.
       */
	public void setMaster(Master master[]){
		this.master = master;
	}

	/** 
        *Name: getMasters.
        *Get the name of the experticies of the assistant coach<br> 
        *<b> post: </b> Name of the Experticies of the assistant coach.
        *@return String message. This are the name of experticies of the assistant coach.
       */
	public String getMasters(){
		String message = "";
		for(int i = 0;i<getMaster().length;i++){
			message += getMaster()[i];
		}
		return message;
	}//end getMasters

	 /** 
        *Name: toString.
        *Show the information of the Assistant Coach<br> 
        *<b> post: </b> Information about Assistant Coach.
        *@return String message. This is the message where is the information about Assistant Coach.
       */
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
	}//end toString
	
}//end AssistantCoach