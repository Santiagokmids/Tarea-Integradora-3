package model;
import java.util.*;

public class Installations{

	//Constants
	public final static int WIDTH = 7;
	public final static int LONG = 6;

	//Relationships
	private Players player;

	//Atributes
	private Players[][] dressingRoom;
	private Players[][] dressingRoom2;

	//Methods
	/** 
	*Name: Installations.
	*Constructor of Installations <br> 
	*<b> post: </b> Start the class Installations.
   */
	public Installations(){
	 	Players[][] dressingRoom = new Players[WIDTH][LONG];
	 	Players[][] dressingRoom2 = new Players[WIDTH][WIDTH];
	}//end Constructor
}