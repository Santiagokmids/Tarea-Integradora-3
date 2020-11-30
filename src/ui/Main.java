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
	         System.out.println(" (2.) Despedir empleados                                                |");
	         System.out.println(" (3.) Actualizar informacion de un empleado                             |");
	         System.out.println(" (4.) Asignar jugadores a camerinos                                     |");
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
         	   System.out.println("\n** Contratar empleados **");
         	   menuEmploy();
         	   break;

         	case 2:
         		System.out.println("\n** Despedir empleados **");
         		delete();
         	    break;

         	case 3:
         		System.out.println("\n** Actualizar informacion de un empleado **");
         		
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
			System.out.println("[1] Contratar entrenador principal\n[2] Contratar entrenador asistente\n[3]Contratar jugador\n[0]Salir al menu principal\n");
			int option = lector.nextInt();
			lector.nextLine();
			switch(option){

				case 1:
					addCoach();
					break; 

				case 2:
					addAssis();
					break; 

				case 3:
					addPlayer();
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
			boolean exit = true;
			while(exit){
				if(opt >= 1 && opt <= 2){
					String message = club.addCoach(name,id,salary,years,amount,cham,opt);
					System.out.println(message);
					exit = false;
				}
				else 
					System.out.println("\nIngreso un numero NO valido");
			}
		}
		else
			System.out.println("\nEl entrenador ya esta en el club, no se pudo agregar");
	}

	public void addAssis(){
		System.out.println("\nIngrese el nombre del entrenador Asistente");
		String name = lector.nextLine();

		System.out.println("\nIngrese la identificacion de "+name);
		String id = lector.nextLine();
		boolean stop = club.findEmploy(id);

		if(stop){
			System.out.println("\nIngrese el salario que gana "+name);
			int salary = lector.nextInt();

			System.out.println("\nIngrese los anios de experiencia que tiene "+name);
			int years = lector.nextInt();

			System.out.println("\n"name+" fue jugador profesional?\n  [1]Si\n  [2]No\n");
			int opt = lector.nextInt();

			boolean exit = true;
			while(exit){
				if(opt == 1 || opt == 2){
					System.out.println("Cuantas experticias tiene "+name);
					int amount = lector.nextInt();
					if(amount <= 6){
						int[] masters = new int[amount];
				
						for(int i = 0;masters.lenght;i++){
							System.out.println("\nCual es la experticia #"+(i+1)" de "+name+"?\n  [1]Ofensiva\n  [2]Defensiva\n  [3]Posesion\n"
							"  [4]Jugadas de laboratorio\n  [5]Entrenador de Arqueros\n  [6]Entrenador fisico\n");
							int pro = lector.nextInt();
							if(pro >= 1 && pro <= 6){
								masters[i] = pro;
							}
							else 
							System.out.println("\nIngreso un numero NO valido");
						}
						System.out.println("\nDe que equipo va a ser Asistente?");
						club.showTeams();
						int team = lector.nextInt();
						lector.nextLine();

						if(team == 1 || team == 2){
							String message = club.addAss(name,id,salary,years,opt,masters[],team);
							System.out.println(message);
							exit = false;
						}
						else 
							System.out.println("\nIngreso un numero NO valido");
					}
					else 
						System.out.println("\nIngreso un numero NO valido");
				}
				else 
					System.out.println("\nIngreso un numero NO valido");
			}
		}
		else
			System.out.println("\nEl entrenador ya esta en el club, no se pudo agregar");
	}

	public void addPlayer(){
		System.out.println("\nIngrese el nombre del jugador");
		String name = lector.nextLine();

		System.out.println("\nIngrese la identificacion de "+name);
		String id = lector.nextLine();
		boolean stop = club.findEmploy(id);

		if(stop){
			System.out.println("\nIngrese el salario que gana "+name);
			int salary = lector.nextInt();

			System.out.println("\nDe que equipo va a ser jugador?");
			club.showTeams();
			int team = lector.nextInt();

			boolean exit = true;
			while(exit){
				if(team >= 1 && team <=2){
					System.out.println("\nIngrese el numero de la camiseta de "+name);
					int number = lector.nextInt();
					boolean shirt = club.shirtNum(number,team);

					if(shirt){
						System.out.println("\nIngrese la posicion de juego de "+name"\n[1] Portero\n[2] Defensa\n[3] Volante\n[4] Delantero\n");
						int pos = lector.nextInt();
						if(pos >= 1 && pos<= 4){
							String message = club.addPlayer(name,id,salary,number,pos,team);
							System.out.println(message);
							exit = false;
						}
						else 
							System.out.println("\nIngreso un numero NO valido");
					}
					else
						System.out.println("\nEl numero ya lo usa otro jugador. Seleccione otro");
				}
				else 
					System.out.println("\nIngreso un numero NO valido");
			}
		}
		else
			System.out.println("\nEl jugador ya esta en el club, no se pudo agregar");
	}

	public void delete(){
		System.out.println("\nIngrese el ID del empleado que va a Despedir");
		String id = lector.nextLine();
		String message = deleteEmploy(id);
		System.out.println(message);
	}

	public void menuAct(){
		boolean exit = true;
		while(exit){
			System.out.println("Actualizar informacion de:\n[1] Entrenador principal\n[2] Entrenador asistente\n"+
				"[3] Jugador\n[0] Volver al menu principal");
			int option = lector.nextInt();
			lector.nextLine();
			switch(option){

				case 1:
					addCoach();
					break;
				case 2:
					break;
			}
		}
	}

	public void actCoach(){
		boolean exit = true;
		while(exit){
			System.out.println("[1] Actualizar salario\n[2] Actualizar numero de equipos que ha manejado\n[3] Actualizar numero de campeonatos ganados");
			int option = lector.nextInt();
			lector.nextLine();

			System.out.println("Ingrese el ID del entrenador");
			String id = lector.nextLine();
			boolean exit = club.findEmploy(id);
			if(!exit){

				if(option == 1){
					System.out.println("Ingrese el nuevo salario para el entrenador");
					String salary = lector.nextInt();
					lector.nextLine();
					changeSalary(id,salary);
					System.out.println("El salario ha sido actualizado");
					exit = false;
				} 
				else if(option == 2){
					System.out.println("Ingrese el numero de equipos que ha manejado el entrenador");
					String teams = lector.nextInt();
					lector.nextLine();
					String message = club.actAmount(id,teams)
					System.out.println(message);
					exit = false;
				}
				else if(option == 3){
					System.out.println("Ingrese el nuevo campeonato ganado por el entrenador");
					String champ = lector.nextLine();
					String sign = club.addChamp(id,champ)
					System.out.println(sing);
					exit = false;
				}
				else 
					System.out.println("Ingreso un numero invalido");
			}
			else 
				System.out.println("El entrenador no existe");
		}
	}

	public void actAssis(){
		boolean exit = true;
		while(exit){
			System.out.println("[1] Actualizar salario\n[2] Agregar experticias");
			int option = lector.nextInt();
			lector.nextLine();

			System.out.println("Ingrese el ID del entrenador");
			String id = lector.nextLine();
			boolean exit = club.findEmploy(id);
			if(!exit){

				if(option == 1){
					System.out.println("Ingrese el nuevo salario para el entrenador");
					String salary = lector.nextInt();
					lector.nextLine();
					changeSalary(id,salary);
					System.out.println("El salario ha sido actualizado");
				}
				else if(option == 2){
					System.out.println("Ingrese la nueva experticia que va a agregar?");
					System.out.println("\nCual es la experticia #"+(i+1)" de "+name+"?\n  [1]Ofensiva\n  [2]Defensiva\n  [3]Posesion\n"
						"  [4]Jugadas de laboratorio\n  [5]Entrenador de Arqueros\n  [6]Entrenador fisico\n");
					int masters = lector.nextInt()
					lector.nextLine();

				} 
			}
		}
	}

	public void addToDress(){

	}

}
