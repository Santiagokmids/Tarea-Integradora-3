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
	*@param name. name of the employee.
    *@param id. id of the employee.
    *@param salary. salary of the employee. Cant be less of 0.
   */
	public Employees(String name, String id, int salary){
		this.name = name;
		this.id = id;
		this.salary = salary;
		state = true;
	}//end Constructor

	 /** 
        *Name: getName.
        *Get the name of the employee<br> 
        *<b> post: </b> Name of the employee.
        *@return String name. This is the name of the employee.
       */
	public String getName(){
		return name;
	}//end getName

	/** 
        *Name: setName.
        *Change the name of the employee<br> 
        *<b> post: </b> New name of the employee.
        *@param name. name of the employee.
       */
	public void setName(String name){
		this.name = name;
	}

	 /** 
        *Name: getId.
        *Get the id of the employee<br> 
        *<b> post: </b> Id of the employee.
        *@return String id. This is the id of the employee.
       */
	public String getId(){
		return id;
	}//end getId

	/** 
        *Name: setId.
        *Change the id of the employee<br> 
        *<b> post: </b> Id of the employee.
        *@param id. id of the employee.
       */
	public void setId(String id){
		this.id = id;
	}//end setId

	 /** 
        *Name: getSalary.
        *Get the salary of the employee<br> 
        *<b> post: </b> Salary of the employee.
        *@return int salaty This is the salary of the employ.
       */
	public int getSalary(){
		return salary;
	}

	/** 
        *Name: setSalary.
        *Change the salary of the employee<br> 
        *<b> post: </b> New salary of the employee.
        *@param salary. salary of the employee. Cant be less of 0.
       */
	public void setSalary(int salary){
		this.salary = salary;
	}//end setSalary

	 /** 
        *Name: getState.
        *Get the state of the employee<br> 
        *<b> post: </b> State of the employee.
        *@return boolean state. This is the state of the employee.
       */
	public boolean getState(){
		return state;
	}//end getState

	/** 
        *Name: setState.
        *Change the state of the employee<br> 
        *<b> post: </b> New state of the employee.
        *@param state. Value of the employee. Can be active or inactive.
       */
	public void setState(boolean state){
		this.state = state;
	}//end setState

	 /** 
        *Name: state.
        *Show the info if the state is false or true<br> 
        *<b> post: </b> Message about state of the employee.
        *@return String message. This is the message where is the state of the employee.
       */
	public String state(){
		String message = "";
		if(getState()){
			message = "Activo";
		}else
			message = "Inactivo";
		return  message;	
	}//end state

	 /** 
        *Name: toString.
        *Show the general information of the employee<br> 
        *<b> post: </b> General Information about employee.
        *@return String message. This is the message where is the general information about employee.
       */
	public String toString(){
		String message = "";
		message = " -Nombre: "+getName()+"\n -Identificacion: "+getId()+"\n -Salario: "+getSalary()+"\n -Estado: "+state();
		return message;
	}//end toString
	
}//end employees