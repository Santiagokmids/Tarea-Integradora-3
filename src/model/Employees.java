package model;
import java.util.*;

public abstract class Employees{

	//Atributes
	private String name;
	private String id;
	private int salary;
	private boolean state;

	//Methods
	/** 
	*Name: Employees.
	*Constructor of Employees <br> 
	*<b> post: </b> Start the class Employees.
   */
	public Employees(String name, String id, int salary){
		this.name = name;
		this.id = id;
		this.salary = salary;
		state = true;
	}//end Constructor

	public String getName(){
		return name;
	}

	public void setName(String name){
		this.name = name;
	}

	public String getId(){
		return id;
	}

	public void setId(String id){
		this.id = id;
	}

	public int getSalary(){
		return salary;
	}

	public void setSalary(int salary){
		this.salary = salary;
	}

	public boolean getState(){
		return state;
	}

	public void setState(){
		state = false;
		this.state = state;
	}
}