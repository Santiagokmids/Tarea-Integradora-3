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
   */
	public MainCoach(String name, String id, int salary,int yearsOfExp,int amountTeams,ArrayList<String> championships){
		super(name,id,salary,yearsOfExp);
		this.amountTeams = amountTeams;
		this.championships = championships;
	}//end Constructor

	public int getAmountTeams(){
		return amountTeams;
	}

	public void setAmountTeams(int amountTeams){
		this.amountTeams = amountTeams;
	}

	public ArrayList<String> getCham(){
		return championships;
	}

	public double marketPrice(){
		double price = (super.getSalary() * 10) + (super.getYears() * 100) + ((getCham().size() + 1) * 50);
		return price;
	}

	public double level(){
		double level;
		level = (5 + getCham().size())/10.0;
		return level;
	}

	@Override
	public String toString(){
		String message = "", teams = "";
		for(int i = 0;i<getCham().size();i++){
			teams += getCham().get(i)+" - ";
		}
		message = "\n ** Entrenador Principal ** \n"+super.toString()+"\n -Equipos Totales: "+getAmountTeams()+
		"\n -Campeonatos ganados: "+teams+"\n -Precio en el mercado: "+marketPrice()+"\n -Nivel: "+level()+"\n";
		return message;
	}
}