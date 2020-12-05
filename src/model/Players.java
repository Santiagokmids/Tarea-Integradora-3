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
	*@param name. name of the player.
    *@param id. id of the player.
    *@param salary. salary of the player. Cant be less of 0.
    *@param shirtNum. shirt number of the player. Cant be less of 0 and more that 99.
    *@param position. Object of position that give the position of the player.
   */
	public Players(String name, String id, int salary,int shirtNum,Position position){
		super(name, id, salary);
		this.shirtNum = shirtNum;
		goalsAmount = 0;
		averageCal = 0;
		this.position = position;
	}//end Constructor

	/** 
        *Name: getShirtNum.
        *Get the shirt number of the player<br> 
        *<b> post: </b> Shirt number of the player.
        *@return int shirtNum. This is the shirt Number of the player.
       */
	public int getShirtNum(){
		return shirtNum;
	}//end getShirtNum

	/** 
        *Name: setShirtNum.
        *Change the shirt number of the player<br> 
        *<b> post: </b> New shirt number of the player.
        *@param shirtNum. shirt number of the player. Cant be less of 0 and more that 99.
       */
	public void setShirtNum(int shirtNum){
		this.shirtNum = shirtNum;
	}//end setShirtNum

	/** 
        *Name: getGoals.
        *Get the amount of goals of the player<br> 
        *<b> post: </b> Amount of goals of the player.
        *@return int goalsAmount. This is the amount goals of the player.
       */
	public int getGoals(){
		return goalsAmount;
	}//end getGoals

	/** 
        *Name: setGoals.
        *Change the amount of goals of the player<br> 
        *<b> post: </b> New amount of goals of the player.
        *@param goalsAmount. Amount of goals of the player. Cant be less of 0.
       */
	public void setGoals(int goalsAmount){
		this.goalsAmount = goalsAmount;
	}//end setGoals

	/** 
        *Name: getAverage.
        *Get the calification average of the player<br> 
        *<b> post: </b> Calification average of the player.
        *@return double averageCal. This is the calification average of the player.
       */
	public double getAverage(){
		return averageCal;
	}//end getAverage

	/** 
        *Name: setAverage.
        *Change the calification average of the player<br> 
        *<b> post: </b> New calification average of the player.
        *@param averageCal. Average calification of the player. Cant be less of 0 and more that 10.
       */
	public void setAverage(double averageCal){
		this.averageCal = averageCal;
	}//End setAverage

	/** 
        *Name: getPosition.
        *Get the position of the player<br> 
        *<b> post: </b>Position of the player.
        *@return Position position. This is the position of the player.
       */
	public Position getPosition(){
		return position;
	}//end getPosition

	/** 
        *Name: setPosition.
        *Change the position of the player<br> 
        *<b> post: </b> New position of the player.
        *@param position. Object of position that give the position of the player.
       */
	public void setPosition(Position position){
		this.position = position;
	}//end setPosition

	/** 
        *Name: marketPrice.
        *Calculate the price in the market of the player<br> 
        *<b> pre: </b> should is created players.<br> 
        *<b> post: </b> Price of the player in the market.
        *@return double price. This is the price of the player in the market.
       */
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
	}//end MarketPrice

	/** 
        *Name: level.
        *Calculate the level of the player<br> 
        *<b> pre: </b> should is create players.<br> 
        *<b> post: </b> level of the player.
        *@return double level. This is the leve of the player.
       */
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
	}//end Level

	 /** 
        *Name: toString.
        *Show the information of the Main Coach<br> 
        *<b> post: </b> Information about main Coach.
        *@return String message. This is the message where is the information about main Coach.
       */
	@Override
	public String toString(){
		String message = "", average = "";
		if(getAverage() == 0){
			average = "No hay Calificacion Promedio";
		}else
			average = ""+getAverage();
		message = "\n ** Jugador Profesional ** \n"+super.toString()+"\n -Numero de camiseta: "+getShirtNum()+
		"\n -Numero de goles: "+getGoals()+"\n -Calificacion Promedio: "+average+"\n -Posicion: "+getPosition()+
		"\n -Precio en el mercado: "+marketPrice()+"\n -Nivel: "+level()+"\n";
		return message;
	}//end toString

}//end Players