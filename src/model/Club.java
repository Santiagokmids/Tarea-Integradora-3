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
        *@param name. name of the club.  
        *@param nit. id of the club.
        *@param fundation. array with 3 integers when the first cant be more that 31 and the second more than 12.
        *@param nameA. name of the team A.
        *@param nameB. name of the team B.
	   */
	public Club(String name, String nit, int fundation[], String nameA, String nameB){
		this.name = name;
		this.nit = nit;
		this.fundation = fundation;
		employ = new ArrayList<Employees>();
		teamA = new Team(nameA);
		teamB = new Team(nameB);
	}//End constructor

    /** 
        *Name: showTeams.
        *Show names about two teams <br> 
        *<b> post: </b> Name of the two teams.
        *@return String message. This is about the name of the teams.
       */
    public String showTeams(){
    	String message = "El club no tiene 2 equipos";
    	if(teamA != null && teamB != null){
    		message = "\n[1] "+teamA.getName()+"\n[2] "+teamB.getName()+"\n";
    	}
    	return message;
    }//end showTeams

    /** 
        *Name: findEmployee.
        *Find the employee with the id <br> 
        *<b> pre: </b> should is add employees.<br> 
        *<b> post: </b> The user was found.
        *@param id. id of the employee.
        *@return boolean stop. This is the value if the employee was or not found.
       */
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
    }//End findEmmployee


    /** 
        *Name: positionEmploy.
        *Find the position of one employee in the arrayList <br> 
        *<b> post: </b> The position was found.
        *@param id. id of the employee.
        *@return int i. This is the position when is the employee.
       */
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
    }//end PositionEmploy

     /** 
        *Name: shirtNum.
        *Find if the shirt Number of one player has been taken <br> 
        *<b> post: </b> Value if the number was found.
        *@param number. shirt number. Cant be lees of 1 and more tha 100.
        *@param opt. number that give the team of the player.
        *@return boolean stop. This is the value if the number was found.
       */
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
    }//end shirtNum

     /** 
        *Name: addEmployee.
        *Add employee of kind main coach to the club<br> 
        *<b> post: </b> The main coach was add to the club.
        *@param name. name of the main coach.
        *@param id. id of the main coach.
        *@param salary. salary of the main coach. Cant be less of 0.
        *@param years. years of experience of the main coach. Cant be less of 0.
        *@param amountTeams. amount of teams of the main coach.
        *@param championships. arrayList of Strings with of the name of the championships.
        *@param opt. number that give the team of the main coach.
        *@return String message. This is a message if the main coach was created.
       */
    public String addEmployee(String name, String id, int salary,int years,int amountTeams,ArrayList<String> championships,int opt){
        String message = "\nEl Entrenador no pudo ser agregado. Ya hay uno en su lugar";
        if(opt == 1){
            boolean exit = teamA.verifyCoach();
            if(exit){
                employ.add(teamA.addCoach(name,id,salary,years,amountTeams,championships));
                message = "\nEntrenador contratado correctamente";
            }
        }
        else {
            boolean stop = teamB.verifyCoach();
            if(stop){
                employ.add(teamB.addCoach(name,id,salary,years,amountTeams,championships));
                message = "\nEntrenador contratado correctamente";
            }
        }
        return message;
    }//end addEmployee


     /** 
        *Name: addEmployee.
        *Add employee of kind assistant coach to the club<br> 
        *<b> post: </b> The assistant coach was add to the club.
        *@param name. name of the assistant coach.
        *@param id. id of the assistant coach.
        *@param salary. salary of the assistant coach. Cant be less of 0.
        *@param years. years of experience of the assistant coach. Cant be less of 0.
        *@param opt. number that give the value of the assistant coach if was or not player. Cant be more that 2 and less that 1.
        *@param master. array of integers with of the experticies of the assistant Coach.
        *@param team. team of the assistant coach.
        *@return String message. This is a message if the assistant coach was created.
       */
    public String addEmployee(String name, String id, int salary,int years,int opt,int master[],int team){
    	String message = "\nEl Asistente no pudo ser agregado. Ya hay 3 Asistentes en el equipo";
    	if(team == 1){
    		boolean exit = teamA.verifyAss();
    		if(!exit){
    			employ.add(teamA.addAss(name,id,salary,years,opt,master));
    			message = "\nAsistente contratado correctamente";
    		}
    	}
    	else {
    		boolean stop = teamB.verifyAss();
    		if(!stop){
	    		employ.add(teamB.addAss(name,id,salary,years,opt,master));
	    		message = "\nEntrenador contratado correctamente";
	    	}
    	}
    	return message;
    }//end addEmployee


     /** 
        *Name: findSame.
        *Find if one expertise has been created<br> 
        *<b> post: </b> The value about the expertise.
        *@param master. experticie of the assistant coach.
        *@param pro. array of integers with of the experticies of the assistant Coach.
        *@return boolean same. This is the value if the expertise was or not found.
       */
    public boolean findSame(int master, int pro[]){
        boolean same = false;
        for(int i = 0;i<pro.length;i++){
             if(pro[i] == master){
                same = true;
            }
        }   
        return same;
    }//end findSame

     /** 
        *Name: addEmployee.
        *Add employee of kind player to the club<br> 
        *<b> post: </b> The player was add to the club.
        *@param name. name of the player.
        *@param id. id of the player.
        *@param salary. salary of the player. Cant be less of 0.
        *@param number. shirt number of the player. Cant be less of 0 and more that 99.
        *@param position. number that give the position of the player. Cant be more that 4 and less that 0.
        *@param team. amount of teams of the player.
        *@return String message. This is a message if the player was created.
       */
    public String addEmployee(String name, String id, int salary,int number, int position, int team){
        String message = "\nEl jugador no pudo ser agregado. Ya hay el limite maximo en la plantilla";
        if(team == 1){
            boolean exit = teamA.verifyPlayer();
            if(!exit){
                employ.add(teamA.addPlayer(name,id,salary,number,position));
                message = "\nJugador contratado correctamente";
            }
        }
        else {
            boolean stop = teamB.verifyPlayer();
            if(!stop){
                employ.add(teamB.addPlayer(name,id,salary,number,position));
                message = "\nJugador contratado correctamente";
            }
        }
        return message;
    }//end addEmployee

     /** 
        *Name: deleteEmployee.
        *Delete a employee<br> 
        *<b> post: </b> The employee was deleted.
        *@param id. id of the employee.
        *@return String message. This is a message if the employee was deleted.
       */
    public String deleteEmployee(String id){
        String message = "No hay empleados";
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
    }//end deleteEmployee   

     /** 
        *Name: changeSalary.
        *Change the salary to one employee<br> 
        *@param id. id of the employee.
        *@param salary. id of the employee.
        *<b> post: </b> The salary was changed.
       */
    public void changeSalary(String id, int salary){
        int position = positionEmploy(id);
        employ.get(position).setSalary(salary);
    }//end changeSalary

     /** 
        *Name: findTeam.
        *Find the coach on team A or team B<br> 
        *<b> post: </b> The value if the coach was found.
        *@param id. id of the main coach.
        *@return int stop. This is the value about what team is the coach.
       */
    public int findTeam(String id){
        int stop = 0;       
        if(teamA.getIdCoach().equalsIgnoreCase(id)){
            stop = 1;
        }
        else if(teamB.getIdCoach().equalsIgnoreCase(id)){
            stop = 2;
        }
        return stop;
    }//end findTeam

     /** 
        *Name: findTeamAss.
        *Find the team where is the assitant coach<br> 
        *<b> post: </b> The team where is the assitant coach.
        *@param id. id of the assistant coach.
        *@return int stop. This is the team where is the assitant coach.
       */
    public int findTeamAss(String id){
        int stop = 0;       
        if(teamA.getIdAs(id).equalsIgnoreCase(id)){
            stop = 1;
        }
        else if(teamB.getIdAs(id).equalsIgnoreCase(id)){
            stop = 2;
        }
        return stop;
    }//end findTeamAss

    /** 
        *Name: findTeamPly.
        *Find the team where is the player<br> 
        *<b> post: </b> The team where is the player.
        *@param id. id of the player.
        *@return int stop. This is the team where is the player.
       */
    public int findTeamPly(String id){
        int stop = 0;       
        if(teamA.getIdPly(id).equalsIgnoreCase(id)){
            stop = 1;
        }
        else if(teamB.getIdPly(id).equalsIgnoreCase(id)){
            stop = 2;
        }
        return stop;
    }//end findTeamPly

     /** 
        *Name: actAmount.
        *Update the teams that the coach directed<br> 
        *<b> post: </b> The amount of what teams has been directed the coach.
        *@param id. id of the main coach.
        *@param teams. number of teams that have the main coach.
        *@return String message. This is the message if was or not update the amount of teams.
       */
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
    }//end actAmount

     /** 
        *Name: addChamp.
        *Update championships to the coach<br> 
        *<b> post: </b> Add championships to the coach.
        *@param id. id of the main coach.
        *@param name. name of the championship.
        *@return String message. This is the message if was or not update the amount of championships
       */
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
    }//end addChamp

     /** 
        *Name: addYears.
        *Update years of experience to the coach's<br> 
        *<b> post: </b> Add years of experience to the coach.
        *@param id. id of the main Coach.
        *@param years. integer of the years of experience of the main coach. Have that be more that 0.
        *@return String message. This is the message if was or not update the years of experience.
       */
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
    }//end addYearsCoach

     /** 
        *Name: addMaster.
        *Update the experticies of the one assistant coach<br> 
        *<b> post: </b> Add experticias to one assitant coach.
        *@param id. id of the assitant coach.
        *@param master. integer of give the experticie for the assistent coach. Cant be less of 1 and more that 6.
        *@return String message. This is the message if was or not update the experticies of the assistant coach.
       */   
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
    }//End addMaster

     /** 
        *Name: changeExp.
        *Change the experience of one assistant coach<br> 
        *<b> post: </b> Change experience of one assistant coach.
        *@param id. id of the assistant coach.
        *@param exp. integer that give the years if experience of the assitant coach.
        *@return String message. This is the message if was or not update the experience of the assistant coach.
       */
    public String changeExp(String id,int exp){
        String message = "\nNo se actualizo. No hay Asistentes con ese ID ";
        int verify = findTeamAss(id); 
        if(verify == 1){
            teamA.setExpAss(id,exp);
            message = "\nActualizado!";
        }
        else if(verify == 2){
            teamB.setExpAss(id,exp);
            message = "\nActualizado!";
        }            
        return message;  
    }//end changeExp

     /** 
        *Name: changeNumber.
        *Change the shirt number of one player<br> 
        *<b> post: </b> New number for the player.
        *@param id. id of the player.
        *@param number. integer that give the shirt number of the player. Cant be less of 1 and more that 99.
        *@return String message. This is the message if was or not update the shirt number of one player.
       */
    public String changeNumber(String id,int number){
        String message = "\nNo se actualizo. No hay jugadores con ese ID ";
        int verify = findTeamPly(id); 
        if(verify == 1){
            boolean exit = teamA.findShirt(number);
            if(!exit){
                teamA.setNumber(id,number);
                message = "\nActualizado!";
            }else
                message = "\nYa hay jugadores con ese numero";
        }
        else if(verify == 2){
            boolean stop = teamA.findShirt(number);
            if(!stop){
                teamB.setNumber(id,number);
                message = "\nActualizado!";
            }else
                message = "\nYa hay jugadores con ese numero";
        }            
        return message;  
    }//end changeNumber

     /** 
        *Name: putGoals.
        *Update the amount of goals of one player<br> 
        *<b> post: </b> Change the amount of goals of one player.
        *@param id. id of the player.
        *@param goals. integer of goals of the player. Cant be less that 0.
        *@return String message. This is the message if was or not update the amount of goals to one player.
       */
    public String putGoals(String id,int goals){
        String message = "\nNo se actualizo. No hay jugadores con ese ID ";
        int verify = findTeamPly(id); 
        if(verify == 1){
            teamA.setGoals(id,goals);
            message = "\nActualizado!";
        }
        else if(verify == 2){
            teamB.setGoals(id,goals);
            message = "\nActualizado!";
        }            
        return message;  
    }//end putGoals

     /** 
        *Name: putAverage.
        *Update the average calification of one player<br> 
        *<b> post: </b> Change the average of one player.
        *@param id. id of the player.
        *@param average. number double that give the average calification of the player. Cant be less of 0 and more that 10.
        *@return String message. This is the message if was or not update the average of one player.
       */
    public String putAverage(String id, double average){
        String message = "\nNo se actualizo. No hay jugadores con ese ID ";
        int verify = findTeamPly(id); 
        if(verify == 1){
            teamA.setAverage(id,average);
            message = "\nActualizado!";
        }
        else if(verify == 2){
            teamB.setAverage(id,average);
            message = "\nActualizado!";
        }            
        return message;  
    }//end putAverage

     /** 
        *Name: putNewPosition.
        *Update the new position of one player<br> 
        *<b> post: </b> Change the position of one player.
        *@param id. id of the player.
        *@param position. number that give the position of the player. Cant be more that 4 and less that 1.
        *@return String message. This is the message if was or not update the position of one player.
       */
    public String putNewPosition(String id, int position){
        String message = "\nNo se actualizo. No hay jugadores con ese ID ";
        int verify = findTeamPly(id); 
        if(verify == 1){
            teamA.setPosition(id,position);
            message = "\nActualizado!";
        }
        else if(verify == 2){
            teamB.setPosition(id,position);
            message = "\nActualizado!";
        }            
        return message;  
    }//end putNewPosition

     /** 
        *Name: addLineUps.
        *Add lineUps to one team<br> 
        *<b> post: </b> The lineUp has been created.
        *@param team. number that give the team. Cant be more than 2 and less that 1.
        *@param def. number of defenses of the lineUp. Cant be less of 0 and more that 8.
        *@param mc. number of midfielders of the lineUp. Cant be less of 0 and more that 8..
        *@param cd. number of fordwards of the lineUp. Cant be less of 0 and more that 8.
        *@param date. array of integers where is the date of creation of the lineUp. The position 0 cant be more that 31 and the position 1 cant be more that 12.
        *@param tactic. number that give the tactic of the lineUp. Cant be more that 4 and less 1.
        *@return String message. This is the message if the lineUp was or not created.
       */
    public String addLineUps(int team,int def, int mc, int cd,int date[],int tactic){
        String message = "\nNo se puede crear la formacion. Hay mas de 11 jugadores";
        int amount = def + mc + cd;
        if(team == 1){
            if(amount == 10){
                teamA.lineUp(date,def, mc, cd,tactic);
                message = "Alineacion creada!";
            }
        }
        else{
            if(amount < 11){
                teamB.lineUp(date,def, mc, cd,tactic);
                message = "Alineacion creada!";
            }
        }
        return message;
    }//End addLineUps

     /** 
        *Name: getName.
        *Get the name of the club<br> 
        *<b> post: </b> Name the club.
        *@return String name. This is the name of the club.
       */
    public String getName(){
        return name;
    }//end getName

     /** 
        *Name: getNit.
        *Get the Nit of the club<br> 
        *<b> post: </b> Nit of the club.
        *@return String Nit. This is the Nit of the club.
       */
    public String getNit(){
        return nit;
    }//end getNit

     /** 
        *Name: getFundation.
        *Get the date of fundation of the club<br> 
        *<b> post: </b> Date of fundation of the club.
        *@return int fundation. This is the fundation date of the club.
       */
    public int[] getFundation(){
        return fundation;
    }//End getFundation

     /** 
        *Name: installations.
        *Dressing room of the team A<br> 
        *<b> post: </b> Position of the players in the dressing room.
        *@return String message. This is the position of the players in the dressing rooms.
       */
    public String installations(){
        String message = "";
        message = teamA.playerPositionA();
        return message;
    }//end installations

    /** 
        *Name: installationsB.
        *Dressing room of the team B<br> 
        *<b> post: </b> Position of the players in the dressing room.
        *@return String message. This is the position of the players in the dressing rooms.
       */
    public String installationsB(){
        String message = "";
        message = teamB.playerPositionB();
        return message;
    }//end installationsB

    /** 
        *Name: showInfoClub.
        *Show info about club<br> 
        *<b> post: </b> Information of the club.
        *@return String message. This is the information of the club.
       */
    public String showInfoClub(){
        String message = "******* CLUB *******\n"+
        " -Nombre del club: "+getName()+"\n"+
        " -Numero de identificacion del club: "+getNit()+"\n"+
        " -Fecha de fundacion del Club: "+getFundation()[0]+"/"+getFundation()[1]+"/"+getFundation()[2]+"\n";
        return message;
    }//end showInfoClub

    /** 
        *Name: showInfoA.
        *Show info of the team A<br> 
        *<b> post: </b> Information about team A.
        *@return String message. This is the information about team A.
       */
    public String showInfoA(){
        String message = "";
        message = teamA.showInfoTeam();
        return  message;
    }//end showInfoA

    /** 
        *Name: showInfoEmployeesA.
        *Show info about employees of the team A<br> 
        *<b> post: </b> Employees of the team A.
        *@return String message. This are the employees of the team A.
       */
    public String showEmployeesA(){
        String message = "";
        message = teamA.showEmployees();
        return message;
    }//end showEmployeesA

     /** 
        *Name: showInfoEmployeesB.
        *Show info about employees of the team B<br> 
        *<b> post: </b> Employees of the team B.
        *@return String message. This are the employees of the team B.
       */
    public String showEmployeesB(){
        String message = "";
        message = teamB.showEmployees();
        return message;
    }//end showEmployeesB

     /** 
        *Name: showInfoB.
        *Show info of the team B<br> 
        *<b> post: </b> Information about team B.
        *@return String message. This is the information about team B.
       */
    public String showInfoB(){
        String message = "";
        message = teamB.showInfoTeam();
        return  message;
    }//end showInfoB

     /** 
        *Name: linesA.
        *Show the lineUps of the team A<br> 
        *<b> post: </b> LineUps of the team A.
        *@return String message. This is the lineUp of the team A.
       */
    public String linesA(){
        String message = teamA.lines();
        return message;
    }//end linesA

     /** 
        *Name: linesB.
        *Show the lineUps of the team B<br> 
        *<b> post: </b> LineUps of the team B.
        *@return String message. This is the lineUp of the team B.
       */
    public String linesB(){
        String message = teamB.lines();
        return message;
    }//end linesB

     /** 
        *Name: showOffices.
        *Show the position of the offices of the club<br> 
        *<b> post: </b> Position of the coach's in the offices.
        *@return String message. This are the positions of the coach's.
       */
    public String showOffices(){
        ArrayList<Employees>employs = new ArrayList<Employees>();
        for(int i = 0;i<employ.size();i++){
            if(employ.get(i).getState()){
                employs.add(employ.get(i));
            }
        }
        teamA.asingOffice(employs);
        String message = "***** OCUPACION EN LAS OFICINAS *****\n"+teamA.offices();
        return message;
    }//end showOffices

     /** 
        *Name: setNameTeam.
        *Change the name of the team<br> 
        *<b> post: </b> Show if the team was or not update.
        *@param name. name of the team.
        *@param team. number that give the team. Cant be more that 2 and less of 1.
        *@return String message. This is the message is was or not update the team.
       */
    public String setNameTeam(String name, int team){
        String message = "No se actualizo";
        if(team == 1){
            teamA.setName(name);
            message = "Equipo actualizado!\n";
        }else{
            teamB.setName(name);
             message = "Equipo actualizado!\n";
        }
        return message;
    }//end setNameTeam
}//end club