package model;
import java.util.*;

public class Club{

	//Relationships
	private Team teamA;
	private Team teamB;
	private ArrayList <Employees> employ;

	//Artibutes
	private String name;
	private String nit;
	private int[]fundation;

	//Methods
	 /** 
		*Name: Club.
		*Constructor of class Club <br> 
		*<b> post: </b> The class was initializaded..
	   */
	public Club(String name, String nit, int fundation[], String nameA, String nameB){
		this.name = name;
		this.nit = nit;
		this.fundation = fundation;
		employ = new ArrayList<Employees>();
		teamA = new Team(nameA);
		teamB = new Team(nameB);
	}//End constructor

    public String showTeams(){
    	String message = "El club no tiene 2 equipos";
    	if(teamA != null && teamB != null){
    		message = "\n[1]"teamA.getName()"\n[2]"teamB.getName()"\n";
    	}
    	return message;
    }

    public boolean findEmploy(String id){
    	boolean exit = true, stop = true;
    	for(int i = 0;i<employ.size() && exit;i++){
    		String nit = employ.get(i).getId();
    		if(nit.equalsIgnoreCase(id)){
    			exit = false;
    			stop = false;
    		}
    	}
    	return stop;
    }

    public int positionEmploy(String id){
        boolean exit = true;
        int i = 0;
        for(i;exit;i++){
            if(id.equalsIgnoreCase(employ.getId(i))){
                exit = false;
            }
        }
        return i;
    }

    public boolean shirtNum(int number, int opt){
        boolean exit = true, stop = true;
        if(opt == 1){
            exit = teamA.findShirt();
            if(exit){
                stop = false;
            }
        }
        else{
            exit = teamB.findShirt();
            if(exit){
                stop = false;
            }
        }
        return stop;
    }

    public String addCoach(String name, String id, int salary,int years,int amountTeams,ArrayList championships[],int opt){
        String message = "El Entrenador no pudo ser agregado. Ya hay uno en su lugar";
        if(opt == 1){
            boolean exit = teamA.verifyCoach();
            if(exit){
                employ.add(teamA.addCoach(name,id,salary,years,amountTeams,championships[]));
                message = "Entrenador contratado correctamente";
            }
        }
        else {
            boolean stop = teamB.verifyCoach();
            if(stop){
                employ.add(teamB.addCoach(name,id,salary,years,amountTeams,championships[]));
                message = "Entrenador contratado correctamente";
            }
        }
        return message;
    }

    public String addAss(String name, String id, int salary,int years,int opt,int master[],int team){
    	String message = "El Entrenador no pudo ser agregado. Ya hay uno en su lugar";
    	if(team == 1){
    		boolean exit = teamA.verifyAss();
    		if(exit){
    			employ.add(teamA.addAss(name,id,salary,years,opt,master[]));
    			message = "Entrenador contratado correctamente";
    		}
    	}
    	else {
    		boolean stop = teamB.verifyAss();
    		if(stop){
	    		employ.add(teamB.addAss(name,id,salary,years,opt,master[]));
	    		message = "Entrenador contratado correctamente";
	    	}
    	}
    	return message;
    }

    public String addPlayer(String name, String id, int salary,int number, int position, int team){
        String message = "El jugador no pudo ser agregado. Ya hay el limite maximo en la plantilla";
        if(team == 1){
            boolean exit = teamA.verifyPlayer();
            if(exit){
                employ.add(teamA.addPlayer(name,id,salary,number,position));
                message = "Jugador contratado correctamente";
            }
        }
        else {
            boolean stop = teamB.verifyPlayer();
            if(stop){
                employ.add(teamB.addPlayer(name,id,salary,years,number));
                message = "Jugador contratado correctamente";
            }
        }
        return message;
    }

    public String deleteEmploy(String id){
        String message = "";
        boolean stop = findEmploy(id);
        if(!stop){
             int position = positionEmploy(id);
             String nit = employ(position).getId();
             message = teamA.deleteEmploy(nit);
             if(message.equalsIgnoreCase("")){
                message = teamB.deleteEmploy(nit);
                if(message.equalsIgnoreCase("")){
                    message = "El empleado no existe";
                }
            }
        }
        else {
            message = "El empleado no existe";
        }
        return message;
    }   

    public void changeSalary(String id, int salary){
        int position = positionEmploy(id);
        employ.get(position).setSalary(salary);
    }

    public int findTeam(String id){
        int stop = 0;       
        if(teamA.getIdCoach().equalsIgnoreCase(id)){
            stop = 1;
        }
        else if(teamB.getIdCoach().equalsIgnoreCase(id)){
            stop = 2;
        }
        return stop;
    }

    public int findTeamAss(String id){
        int stop = 0;       
        if(teamA.getIdAs().equalsIgnoreCase(id)){
            stop = 1;
        }
        else if(teamB.getIdAs().equalsIgnoreCase(id)){
            stop = 2;
        }
        return stop;
    }

    public String actAmount(String id, int teams){
        String message = "No se actualizo. No hay entrenadores con ese ID";
        int verify = findTeam(id);    
        if(verify == 1){
            teamA.changeAmountTeams(teams);
            message = "Actualizado!";
        }
        else if(verify == 2){
            teamB.changeAmountTeams(teams);
            message = "Actualizado!";
        }            
        return message;
    }

    public String addChamp(String id, String name){
        String message = "No se actualizo. No hay entrenadores con ese ID ";
        int verify = findTeam(id); 
        if(verify == 1){
            teamA.addChamp(name);
            message = "Actualizado!";
        }
        else if(verify == 2){
            teamB.addChamp(name);
            message = "Actualizado!";
        }            
        return message;  
    }

    public String addMaster(String id, int master){
        String message = "No se actualizo. No hay entrenadores con ese ID ";
        int verify = findTeamAss(id); 
        if(verify == 1){
            teamA.addMaster(master);
            message = "Actualizado!";
        }
        else if(verify == 2){
            teamB.addMaster(master);
            message = "Actualizado!";
        }            
        return message;  
    }


}