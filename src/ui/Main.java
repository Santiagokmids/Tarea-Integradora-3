package ui;

import java.util.*;

import model.Club;

public class Main {

	//Atributes
	private Club club;

	//Globals variable
    public Scanner lector;

	public Main(){
	lector = new Scanner(System.in);
	showIcon();
	startApp();
	} 

	public static void main (String[]args){
		Main objMain = new Main();
		objMain.Menu();
	}
	//Methods
	 /** 
		*Name: ShowIcon.
		*Show the inicialited icon of the app <br> 
		*<b> post: </b> The icon of the app in screen.
	   */
	public void showIcon(){
		System.out.println("\n  *** BIENVENIDOS ***   \n");
		System.out.println("****************************");
	}

	 /** 
		*Name: starApp.
		*Start the app with the object of Club <br> 
		*<b> post: </b> The object of the Club was created.
	   */
	public void startApp(){
		int[] fundation = new int[2];
		boolean exit = true;
		System.out.println("Introduzca el nombre del Club");
		String name = lector.nextLine();
		System.out.println("Introduzca el numero de identificacion de "+name);
		String nit = lector.nextLine();
		for(int i=0;exit;i++){
			System.out.println("Introduzca solo el dia de fundacion de "+name);
			fundation[0] = lector.nextInt();
			if(fundation[0]<31){
				System.out.println("Introduzca solo el mes de fundacion de "+name);
				fundation[1] = lector.nextInt();
				if(fundation[1]<12){
					System.out.println("Introduzca solo el anio de fundacion de "+name);
					fundation[2] = lector.nextInt();
					lector.nextLine();
					System.out.println("Introduzca el nombre del equipo A");
					String a = lector.nextLine();
					System.out.println("Introduzca el nombre del equipo B");
					String b = lector.nextLine();
					club = new Club(name,nit,fundation,a,b);
					exit = false;
				} else
				 	System.out.println("Mes INCORRECTO! ");
			} else
				System.out.println("Dia INCORRECTO! ");
		}
	}//End startApp

	 /** 
		*Name: Menu.
		*Show the menu for choose one option <br> 
		*<b> post: </b> The menu is started.
	   */
	public void Menu(){
	   	 boolean stop = false;
	   	 for(int l = 0;!stop;l++){
	   	 	 System.out.println("");
	   	     System.out.println("------------------------------------------------------");
             System.out.println("      * QUE DESEA HACER? *");	   	
             System.out.println("------------------------------------------------------");
	         System.out.println("");
	         System.out.println("************************************************************************");
	         System.out.println(" (1.) Contratar empleados                                               |");
	         System.out.println(" (2.) Mostrar los usuarios agregados                                    |");
	         System.out.println(" (3.) Agregar una cancion al pool de canciones                          |");
	         System.out.println(" (4.) Mostrar canciones que hay en el pool de canciones                 |");
	         System.out.println(" (5.) Crear PlayList                                                    |");
	         System.out.println(" (6.) Agregar cancion del pool al PlayList                              |");
	         System.out.println(" (7.) Mostrar PlayList existentes                                       |");
	         System.out.println(" (8.) Calificar una PlayList                                            |");
	         System.out.println(" (9.) Salir de la aplicacion                                            |");
	         System.out.println("************************************************************************");
	         int option = lector.nextInt();
	         System.out.println("");
	         lector.nextLine();
         
         switch(option){
         	case 1: 
         	   System.out.println("\n** Agregar empleados **");
         	   menuEmploy();
         	   break;

         	case 2:
         		System.out.println("** Mostrar los usuarios agregados **");
         		System.out.println("");
         	    String show = musicCS.showUsers();
         	    System.out.println(show);
         	    break;

         	case 3:
         	     System.out.println("** Agregar una cancion al pool de canciones **");
         	     createSong();
         	    break;

         	case 4:
         	     System.out.println("** Mostrar canciones que hay en el pool de canciones **");
         	     System.out.println("");
         	     String show2 = musicCS.showSongs();
         	     System.out.println(show2);
         	    break;

         	case 5:
         	     System.out.println("** Crear PlayList **");
         	     int opt = menuPlaylist();
         	     createPlaylist(opt);
         	    break;

         	case 6:
         	     System.out.println("** Agregar cancion del pool a la PlayList **");
         	     System.out.println("");
         	     addSongPlay();
         	    break;

			case 7:
         		 System.out.println("** Mostrar Playlist existentes **");
         		 System.out.println("");
         		 String show3 = musicCS.showPlay();
         	     System.out.println(show3);
         	    break;

         	case 8:
         	     System.out.println("** Calificar Playlist **");
         	     System.out.println("");
         	     putCalification();
         	    break;    

         	case 9:
         		 stop = true;
         	     System.out.println("\nGRACIAS POR UTILIZAR MCS :D");
         	    break;
    
            default: 
                System.out.println("\nIngreso un numero NO valido");
            }
	    }
	}//End Menu

	public void menuEmploy(){
		boolean stop = false;
		while(!stop){
			System.out.println("\nQue opcion desea realizar?\n");
			System.out.println("[1] Agregar entrenador principal\n[2] Agregar entrenador asistente\n[3]Agregar jugador\n[0]Salir al menu principal\n");
			int option = lector.nextInt();
			lector.nextLine();
			switch(option){

				case 1:
					addCoach();
					break; 

				case 2:
					addCoach();
					break; 

				case 3:
					addCoach();
					break;

				case 0:
					stop = true;
					break; 	

				default: 
                	System.out.println("\nIngreso un numero NO valido");
			}
		}
	}

	public void addCoach(){
		System.out.println("\nIngrese el nombre del entrenador principal");
		String name = lector.nextLine();
		System.out.println("\nIngrese la identificacion de "+name);
		String id = lector.nextLine();
		boolean stop = club.findEmploy(id);
		if(stop){
			System.out.println("\nIngrese el salario que gana "+name);
			int salary = lector.nextInt();
			System.out.println("\nIngrese los anios de experiencia que tiene "+name);
			int years = lector.nextInt();
			System.out.println("\nIngrese la cantidad de equipos que ha dirigido "+name);
			int amount = lector.nextInt();
			System.out.println("\nIngrese la cantidad de campeonatos que ha ganado "+name);
			int champions = lector.nextInt();
			lector.nextLine();
			ArrayList<String>cham = new ArrayList<String>();
			System.out.println("\nIngrese el nombre de los campeonatos");
			for (int i = 0;i<cham.lenght;i++) {
				System.out.println("\nCampeonato "+(i+1));
				String nameCham = lector.nextLine();
				cham.add(nameCham);
			}
			System.out.println("\nDe que equipo va a ser entrenador?");
			club.showTeams();
			int opt = lector.nextInt();
			lector.nextLine();
			if(opt >= 1 && opt <= 2){
				String message = club.addCoach(name,id,salary,years,amount,cham,opt);
				System.out.println(message);
			}
		}
		else
			System.out.println("\nEl entrenador ya esta en el club, no se pudo agregar");
	}

	public void addAssis(){
		System.out.println("\nIngrese el nombre del entrenador principal");
		String name = lector.nextLine();
		System.out.println("\nIngrese la identificacion de "+name);
		String id = lector.nextLine();
		boolean stop = club.findEmploy(id);
		if(stop){
			System.out.println("\nIngrese el salario que gana "+name);
			int salary = lector.nextInt();
			lector.nextLine();
			System.out.println("\nIngrese los anios de experiencia que tiene "+name);
			int years = lector.nextInt();
			System.out.println("\n"name+" fue jugador profesional?\n  [1]Si\n  [2]No\n");
			int opt = lector.nextInt();
			if(opt >= 1 && opt <= 2){
				System.out.println("\nCual la esperticia de"+name+"?\n  [1]Ofensiva\n  [2]Defensiva\n  [3]Posesion\n"
					"  [4]Jugadas de laboratorio\n  [5]Entrenador de Arqueros\n  [6]Entrenador fisico\n");
				int pro = lector.nextInt();
				lector.nextLine();
				String message = club.addAss(name,id,salary,years,opt,pro);
				System.out.println(message);
			}
		}
		else
			System.out.println("\nEl entrenador ya esta en el club, no se pudo agregar");
	}



}
