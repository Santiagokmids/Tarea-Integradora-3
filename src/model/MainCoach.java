package model;
import java.util.*;

public class MainCoach extends Coach implements Price, Level{

	//Atributes
	private int amountTeams;
	private ArrayList <String> championships;

	//Methods
	/** 
	*Name: MainCoach.
	*Constructor of MainCoach <br> 
	*<b> post: </b> Start the class MainCoach.
	*@param name. name of the main coach.
    *@param id. id of the main coach.
    *@param salary. salary of the main coach. Cant be less of 0
    *@param yearsOfExp. years of experience of the main coach. Cant be less of 0.
    *@param amountTeams. amount of teams of the main coach. Cant be less of 0.
    *@param championships. arrayList of Strings with of the name of the championships.
   */
	public MainCoach(String name, String id, int salary,int yearsOfExp,int amountTeams,ArrayList<String> championships){
		super(name,id,salary,yearsOfExp);
		this.amountTeams = amountTeams;
		this.championships = championships;
	}//end Constructor

	 /** 
        *Name: getAmountTeams.
        *Get the amount of teams of the main coach<br> 
        *<b> post: </b> Amount of teams of the main coach.
        *@return int amountTeams. This is the amount of teams of the main coach.
       */
	public int getAmountTeams(){
		return amountTeams;
	}//end getA,ountTeams

	/** 
        *Name: setAmountTeams.
        *Change the amount of teams of the main coach<br> 
        *<b> post: </b> New amount of teams of the main coach.
        *@param amountTeams. amount of teams of the main coach. Cant be less of 0.
       */
	public void setAmountTeams(int amountTeams){
		this.amountTeams = amountTeams;
	}//end setAmountTeams

	/** 
        *Name: getCham.
        *Get the amount of championship of the main coach<br> 
        *<b> post: </b> Amount of championships of the main coach.
        *@return ArrayList of String championships. This is the amount of championships of the main coach.
       */
	public ArrayList<String> getCham(){
		return championships;
	}//end getCham

	/** 
        *Name: marketPrice.
        *Calculate the price in the market of the main coach<br> 
        *<b> pre: </b> should is add main Coach's.<br> 
        *<b> post: </b> Price of the main coach in the market.
        *@return double price. This is the price of the main coach in the market.
       */
	public double marketPrice(){
		double price = (super.getSalary() * 10) + (super.getYears() * 100) + (getCham().size() * 50);
		return price;
	}//end marketPrice

	/** 
        *Name: level.
        *Calculate the level of the main coach<br> 
        *<b> post: </b> level of the main coach.
        *@return double level. This is the leve of the main coach.
       */
	public double level(){
		double level;
		level = 5+(getCham().size()/10.0);
		return level;
	}//end level

	 /** 
        *Name: toString.
        *Show the information of the Main Coach<br> 
        *<b> post: </b> Information about main Coach.
        *@return String message. This is the message where is the information about main Coach.
       */
	@Override
	public String toString(){
		String message = "", teams = "0";
		if(getCham().size() > 0){
			teams = "";
			for(int i = 0;i<getCham().size();i++){
				teams += getCham().get(i)+" - ";
			}
		}
		message = "\n ** Entrenador Principal ** \n"+super.toString()+"\n -Equipos Totales: "+getAmountTeams()+
		"\n -Campeonatos ganados: "+teams+"\n -Precio en el mercado: "+marketPrice()+"\n -Nivel: "+level()+"\n";
		return message;
	}//end toString 

}//end MainCoach