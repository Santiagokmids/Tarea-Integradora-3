package model;
import java.util.*;

public class Players extends Employees implements Price, Level {

	//relationships
	private Position positions;

	//Atributes
	private int shirtNum;
	private int goalsAmount;
	private double averageCal;
	private Position position;

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
		this.position = position;
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

	public void setShirtNum(int shirtNum){
		this.shirtNum = shirtNum;
	}

	public int getGoals(){
		return goalsAmount;
	}

	public void setGoals(int goalsAmount){
		this.goalsAmount = goalsAmount;
	}

	public double getAverage(){
		return averageCal;
	}

	public void setAverage(double averageCal){
		this.averageCal = averageCal;
	}

	public Position getPosition(){
		return position;
	}

	public void setPosition(Position position){
		this.position = position;
	}

	public double marketPrice(){
		double price = 0;
		if(getPosition() == Position.GK){
			price = (super.getSalary() * 12) + (getAverage() * 150);
		}
		else if(getPosition() == Position.DEF){
			price = (super.getSalary() * 13) + (getAverage() * 125) + (getGoals() * 100);
		}
		else if(getPosition() == Position.CM){
			price = (super.getSalary() * 14) + (getAverage() * 135) + (getGoals() * 125);
		}
		else if(getPosition() == Position.CF){
			price = (super.getSalary() * 15) + (getAverage() * 145) + (getGoals() * 150);
		}
		return price;
	}

	public double level(){
		double level = 0;
		if(getPosition() == Position.GK){
			level = (getAverage() * 0.9);
		}
		else if(getPosition() == Position.DEF){
			level = (getAverage() * 0.9) + (getGoals() / 100);
		}
		else if(getPosition() == Position.CM){
			level = (getAverage() * 0.9) + (getGoals() / 90);
		}
		else if(getPosition() == Position.CF){
			level = (getAverage() * 0.9) + (getGoals() / 80);
		}
		return level;
	}

	@Override
	public String toString(){
		String message = "", average = "";
		if(getAverage() == 0){
			average = "No hay Calificacion Promedio";
		}else
			average = ""+getAverage();
		message = " ** Jugador Profesional ** \n"+super.toString()+"\n -Numero de camiseta: "+getShirtNum()+
		"\n -Numero de goles: "+getGoals()+"\n -Calificacion Promedio: "+average+"\n -Posicion: "+getPosition()+
		"\n -Precio en el mercado: "+marketPrice()+"\n -Nivel: "+level()+"\n";
		return message;
	}

}