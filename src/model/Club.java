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
    		message = "\n[1]"+teamA.getName()+"\n[2]"+teamB.getName()+"\n";
    	}
    	return message;
    }

    public boolean findEmployee(String id){
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
        for(int p = 0;exit;p++){
            if(id.equalsIgnoreCase(employ.get(p).getId())){
                i = p;
                exit = false;
            }
        }
        return i;
    }

    public boolean shirtNum(int number, int opt){
        boolean exit = true, stop = true;
        if(opt == 1){
            exit = teamA.findShirt(number);
            if(exit){
                stop = false;
            }
        }
        else{
            exit = teamB.findShirt(number);
            if(exit){
                stop = false;
            }
        }
        return stop;
    }

    public String addEmployee(String name, String id, int salary,int years,int amountTeams,ArrayList<String> championships,int opt){
        String message = "El Entrenador no pudo ser agregado. Ya hay uno en su lugar";
        if(opt == 1){
            boolean exit = teamA.verifyCoach();
            if(exit){
                employ.add(teamA.addCoach(name,id,salary,years,amountTeams,championships));
                message = "Entrenador contratado correctamente";
            }
        }
        else {
            boolean stop = teamB.verifyCoach();
            if(stop){
                employ.add(teamB.addCoach(name,id,salary,years,amountTeams,championships));
                message = "Entrenador contratado correctamente";
            }
        }
        return message;
    }

    public String addEmployee(String name, String id, int salary,int years,int opt,int master[],int team){
    	String message = "El Entrenador no pudo ser agregado. Ya hay uno en su lugar";
    	if(team == 1){
    		boolean exit = teamA.verifyAss();
    		if(exit){
    			employ.add(teamA.addAss(name,id,salary,years,opt,master));
    			message = "Entrenador contratado correctamente";
    		}
    	}
    	else {
    		boolean stop = teamB.verifyAss();
    		if(stop){
	    		employ.add(teamB.addAss(name,id,salary,years,opt,master));
	    		message = "Entrenador contratado correctamente";
	    	}
    	}
    	return message;
    }

    public boolean findSame(int master, int pro[]){
        boolean same = false;
        for(int i = 0;i<pro.length;i++){
             if(pro[i] == master){
                same = true;
            }
        }   
        return same;
    }

    public String addEmployee(String name, String id, int salary,int number, int position, int team){
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
                employ.add(teamB.addPlayer(name,id,salary,number,position));
                message = "Jugador contratado correctamente";
            }
        }
        return message;
    }

    public String deleteEmployee(String id){
        String message = "";
        boolean stop = findEmployee(id);
        if(!stop){
             int position = positionEmploy(id);
             String nit = employ.get(position).getId();
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
        if(teamA.getIdAs(id).equalsIgnoreCase(id)){
            stop = 1;
        }
        else if(teamB.getIdAs(id).equalsIgnoreCase(id)){
            stop = 2;
        }
        return stop;
    }

     public int findTeamPly(String id){
        int stop = 0;       
        if(teamA.getIdPly(id).equalsIgnoreCase(id)){
            stop = 1;
        }
        else if(teamB.getIdPly(id).equalsIgnoreCase(id)){
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


    public String addYearsCoach(String id, int years){
        String message = "No se actualizo. No hay entrenadores con ese ID ";
        int verify = findTeam(id); 
        if(verify == 1){
            teamA.setExpCoach(years);
            message = "Actualizado!";
        }
        else if(verify == 2){
            teamB.setExpCoach(years);
            message = "Actualizado!";
        }            
        return message;  
    }

    public String addMaster(String id, int master){
        String message = "No se actualizo. No hay Asistentes con ese ID ";
        int verify = findTeamAss(id); 
        boolean sign = true;
        if(verify == 1){
            sign = teamA.addMaster(id,master);
            if(!sign){
                message = "Actualizado!";
            }else
                message = "La experticia ya la posee el Asistente";
        }
        else if(verify == 2){
            sign = teamB.addMaster(id, master);
            if(!sign){
                message = "Actualizado!";
            }else
                message = "La experticia ya la posee el Asistente"; 
        }            
        return message;  
    }

    public String changeExp(String id,int exp){
        String message = "No se actualizo. No hay Asistentes con ese ID ";
        int verify = findTeamAss(id); 
        if(verify == 1){
            teamA.setExpAss(id,exp);
            message = "Actualizado!";
        }
        else if(verify == 2){
            teamB.setExpAss(id,exp);
            message = "Actualizado!";
        }            
        return message;  
    }

    public String changeNumber(String id,int number){
        String message = "No se actualizo. No hay jugadores con ese ID ";
        int verify = findTeamPly(id); 
        if(verify == 1){
            boolean exit = teamA.findShirt(number);
            if(!exit){
                teamA.setNumber(id,number);
                message = "Actualizado!";
            }else
                message = "Ya hay jugadores con ese numero";
        }
        else if(verify == 2){
            boolean stop = teamA.findShirt(number);
            if(!stop){
                teamB.setNumber(id,number);
                message = "Actualizado!";
            }else
                message = "Ya hay jugadores con ese numero";
        }            
        return message;  
    }

    public String putGoals(String id,int goals){
        String message = "No se actualizo. No hay jugadores con ese ID ";
        int verify = findTeamPly(id); 
        if(verify == 1){
            teamA.setGoals(id,goals);
            message = "Actualizado!";
        }
        else if(verify == 2){
            teamB.setExpAss(id,goals);
            message = "Actualizado!";
        }            
        return message;  
    }

    public String putAverage(String id, double average){
        String message = "No se actualizo. No hay jugadores con ese ID ";
        int verify = findTeamPly(id); 
        if(verify == 1){
            teamA.setAverage(id,average);
            message = "Actualizado!";
        }
        else if(verify == 2){
            teamB.setAverage(id,average);
            message = "Actualizado!";
        }            
        return message;  
    }

     public String putNewPosition(String id, int position){
        String message = "No se actualizo. No hay jugadores con ese ID ";
        int verify = findTeamPly(id); 
        if(verify == 1){
            teamA.setPosition(id,position);
            message = "Actualizado!";
        }
        else if(verify == 2){
            teamB.setPosition(id,position);
            message = "Actualizado!";
        }            
        return message;  
    }

    public String addLineUps(int team,int def, int mc, int cd,int date[],int tactic){
        String message = "No se puede crear la formacion. Hay mas de 11 jugadores";
        int amount = def + mc + cd;
        if(team == 1){
            if(amount < 11){
                teamA.lineUps(date,def, mc, cd,tactic);
                message = "Alineacion creada!";
            }
        }
        else{
            if(amount < 11){
                teamB.lineUps(date,def, mc, cd,tactic);
                message = "Alineacion creada!";
            }
        }
        return message;
    }

    public void office(){
        teamA.asingOffice(employ);
        teamB.asingOffice(employ); 
    }

    public String getName(){
        return name;
    }

    public String getNit(){
        return nit;
    }

    public int[] getFundation(){
        return fundation;
    }

    public String showInfoClub(){
        String message = "******* CLUB *******\n"+
        " -Nombre del club: "+getName()+
        " -Numero de identificacion del club: "+getNit()+
        " -Fecha de fundacion del Club: "+getFundation()[0]+"/"+getFundation()[1]+"/"+getFundation()[2];
        return message;
    }

    public String linesA(){
        String message = teamA.lines();
        return message;
    }

    public String linesB(){
        String message = teamB.lines();
        return message;
    }

}