package model;
import java.util.*;

public class AssistantCoach extends Coach {

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

	public Master putMaster(int opt){
		Master master = null;
		if(opt == 1){
			master = Master.OFFENSIVE;
		}
		else if(opt == 2){
			master = Master.DEFFENSIVE;
		}
		else if(opt == 3){
			master = Master.POSSESSION;
		}
		else if(opt == 4){
			master = Master.LAB_PLAYS;
		}
		else if(opt == 5){
			master = Master.GK_COACH;
		}
		else if(opt == 6){
			master = Master.PHY_COACH;
		}
		return master;
	}

	public boolean player(int opt){
		boolean player = true;
		if(opt == 2){
			player = false;
		}
		return player;
	}

	public String getMasters(){
		String message = "";
		for(int i = 0;1<getMaster().length;i++){
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
		message = "\n ** Entrenador Asistente ** \n"+super.toString()+"\n -"+really+"\n -Experticias: "+getMasters();
		return message;
	}
}