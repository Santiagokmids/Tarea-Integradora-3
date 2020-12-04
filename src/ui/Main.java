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
		System.out.println("\n  ************* BIENVENIDOS *************   \n");
		System.out.println("*************************************************");
	}

	 /** 
		*Name: starApp.
		*Start the app with the object of Club <br> 
		*<b> post: </b> The object of the Club was created.
	   */
	public void startApp(){
		int[] fundation = new int[3];
		System.out.println("Introduzca el nombre del Club");
		String name = lector.nextLine();
		
		System.out.println("Introduzca el numero de identificacion de "+name);
		String nit = lector.nextLine();
		boolean exit = true;
		for(int i=0;exit;i++){
			System.out.println("Introduzca solo el dia de fundacion de "+name);
			fundation[0] = lector.nextInt();

			if(fundation[0]<=31){
				System.out.println("Introduzca solo el mes de fundacion de "+name);
				fundation[1] = lector.nextInt();

				if(fundation[1]<=12){
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
	         System.out.println("  (1.) Contratar empleados                                               |");
	         System.out.println("  (2.) Despedir empleados                                                |");
	         System.out.println("  (3.) Actualizar informacion                                            |");
	         System.out.println("  (4.) Agregar alineacion a un equipo                                    |");
	         System.out.println("  (5.) Mostrar informacion de todo el club                               |");
	         System.out.println("  (6.) Mostrar informacion especifica                                    |");
	         System.out.println("  (7.) Salir de la aplicacion                                            |");
	         System.out.println("************************************************************************");
	         int option = lector.nextInt();
	         System.out.println("");
	         lector.nextLine();
         
         switch(option){
         	case 1: 
         	   System.out.println("\n ***** Contratar empleados *****");
         	   menuEmploy();
         	   break;

         	case 2:
         		System.out.println("\n ***** Despedir empleados *****");
         		delete();
         	    break;

         	case 3:
         		System.out.println("\n ***** Actualizar informacion *****");
         		menuActInfo();
         	    break;

         	case 4:
         		System.out.println("\n ***** Agregar alineacion a un equipo *****");
         		addLineUps();
         	    break;

         	case 5:
         		System.out.println("\n ***** Informacion del Club *****");
         		showInfo();
         	    break;

         	case 6:
         		System.out.println("\n ***** Informacion en especifico *****");
         		menuTeams();
         	    break;

         	case 7:
         		System.out.println("\n *** Gracias por usar nuestra aplicacion *** ");
         		stop = true;
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
			System.out.println("[1] Contratar entrenador principal\n[2] Contratar entrenador asistente\n[3] Contratar jugador\n[0] Salir al menu principal\n");
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

		boolean stop = club.findEmployee(id);
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

			for(int i = 0;i<champions;i++){
				System.out.println("\nCampeonato "+(i+1));
				String nameCham = lector.nextLine();
				cham.add(nameCham);
			}
			boolean exit = true;
			while(exit){
				System.out.println("\nDe que equipo va a ser entrenador?");
				String teams = club.showTeams();
				System.out.println(teams);
				int opt = lector.nextInt();
				lector.nextLine();
				if(opt >= 1 && opt <= 2){
					String message = club.addEmployee(name,id,salary,years,amount,cham,opt);
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
		boolean stop = club.findEmployee(id);

		if(stop){
			System.out.println("\nIngrese el salario que gana "+name);
			int salary = lector.nextInt();

			System.out.println("\nIngrese los anios de experiencia que tiene "+name);
			int years = lector.nextInt();

			boolean exit = true;
			while(exit){
				System.out.println("\n"+name+" fue jugador profesional?\n  [1]Si\n  [2]No\n");
				int opt = lector.nextInt();
				if(opt == 1 || opt == 2){
					System.out.println("Cuantas experticias tiene "+name+"?");
					int amount = lector.nextInt();
					if(amount <= 6){
						int[] masters = new int[amount];
				
						for(int i = 0;i<masters.length;i++){
							System.out.println("\nCual es la experticia de "+name+"?\n  [1]Ofensiva\n  [2]Defensiva\n  [3]Posesion\n"+
							"  [4]Jugadas de laboratorio\n  [5]Entrenador de Arqueros\n  [6]Entrenador fisico\n");
							int pro = lector.nextInt();
							if(pro >= 1 && pro <= 6){
								boolean same = club.findSame(pro,masters);
								if(!same){
									masters[i] = pro;
								}else{
									System.out.println("El asistente ya tiene esa experticia");
									i--;
								}
							}
							else 
								System.out.println("\nIngreso un numero NO valido");
						}
						System.out.println("\nDe que equipo va a ser Asistente?");
						String teams = club.showTeams();
						System.out.println(teams);
						int team = lector.nextInt();
						lector.nextLine();
						if(team == 1 || team == 2){
							String message = club.addEmployee(name,id,salary,years,opt,masters,team);
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
		boolean stop = club.findEmployee(id);

		if(stop){
			System.out.println("\nIngrese el salario que gana "+name);
			int salary = lector.nextInt();

			boolean exit = true;
			while(exit){
				System.out.println("\nDe que equipo va a ser jugador?");
				String teams = club.showTeams();
				System.out.println(teams);
				int team = lector.nextInt();
				if(team >= 1 && team <=2){
					System.out.println("\nIngrese el numero de la camiseta de "+name);
					int number = lector.nextInt();
					lector.nextLine();
					boolean shirt = club.shirtNum(number,team);

					if(shirt){
						System.out.println("\nIngrese la posicion de juego de "+name+"\n[1] Portero\n[2] Defensa\n[3] Volante\n[4] Delantero\n");
						int pos = lector.nextInt();
						if(pos >= 1 && pos<= 4){
							String message = club.addEmployee(name,id,salary,number,pos,team);
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
		String message = club.deleteEmployee(id);
		System.out.println(message);
	}

	public void menuActInfo(){
		boolean exit = true;
		while(exit){
			System.out.println("Actualizar informacion de:\n[1] Equipos\n[2] Empleados\n[0] Volver al menu principal");
			int option = lector.nextInt();
			lector.nextLine();
			switch(option){

				case 1:
					actClub();
					break;
				case 2:
					menuAct();
					break;
				case 0:
					exit = false;
					break;

				default:
					System.out.println("Numero invalido");
			}
		}
	}

	public void menuAct(){
		boolean exit = true;
		while(exit){
			System.out.println("Actualizar informacion de:\n[1] Entrenador principal\n[2] Entrenador asistente\n"+
				"[3] Jugador\n[0] Atras");
			int option = lector.nextInt();
			lector.nextLine();
			switch(option){

				case 1:
					actCoach();
					break;
				case 2:
					actAssis();
					break;
				case 3:
					actPlayer();
					break;
				case 0:
					exit = false;
					break;

				default:
					System.out.println("Numero invalido");
			}
		}
	}

	public void actClub(){
		boolean exit = true;
		while(exit){
			System.out.println("Que equipo quiere Actualizar?");
			String teams = club.showTeams();
			System.out.println(teams);
			int team = lector.nextInt();
			lector.nextLine();
			if(team == 1 || team == 2){
				System.out.println("\nIngrese el nuevo nombre del equipo");
				String name = lector.nextLine();
				String message = club.setNameTeam(name,team);
				System.out.println(message);
				exit = false;
			}else
				System.out.println("Numero INVALIDO");
		}
	}

	public void actCoach(){
		boolean exit = true;
		while(exit){
			System.out.println("[1] Actualizar salario\n[2] Actualizar numero de equipos que ha manejado\n[3] Actualizar numero de campeonatos ganados\n[4] Actualizar anios de experiencia");
			int option = lector.nextInt();
			lector.nextLine();

			System.out.println("Ingrese el ID del entrenador");
			String id = lector.nextLine();
			boolean stop = club.findEmployee(id);
			if(!stop){

				if(option == 1){
					System.out.println("Ingrese el nuevo salario para el entrenador");
					int salary = lector.nextInt();
					lector.nextLine();
					club.changeSalary(id,salary);
					System.out.println("El salario ha sido actualizado");
					exit = false;
				} 
				else if(option == 2){
					System.out.println("Ingrese el numero de equipos que ha manejado el entrenador");
					int teams = lector.nextInt();
					lector.nextLine();
					String message = club.actAmount(id,teams);
					System.out.println(message);
					exit = false;
				}
				else if(option == 3){
					System.out.println("Ingrese el nuevo campeonato ganado por el entrenador");
					String champ = lector.nextLine();
					String sign = club.addChamp(id,champ);
					System.out.println(sign);
					exit = false;
				}
				else if(option == 4){
					System.out.println("Ingrese el numero de anios de experiencia del Entrenador");
					int exp = lector.nextInt();
					lector.nextLine();
					String text = club.addYearsCoach(id, exp);
					System.out.println(text);
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
			System.out.println("[1] Actualizar salario\n[2] Agregar experticias\n[3] Actualizar anios de experiencia");
			int option = lector.nextInt();
			lector.nextLine();

			System.out.println("Ingrese el ID del Asistente");
			String id = lector.nextLine();
			boolean stop = club.findEmployee(id);
			if(!stop){

				if(option == 1){
					System.out.println("Ingrese el nuevo salario para el Asistente");
					int salary = lector.nextInt();
					lector.nextLine();
					club.changeSalary(id,salary);
					System.out.println("El salario ha sido actualizado");
					exit = false;
				}
				else if(option == 2){
					System.out.println("Ingrese la nueva experticia que va a agregar?");
					System.out.println("\nCual es la experticia?\n  [1]Ofensiva\n  [2]Defensiva\n  [3]Posesion\n"+
						"  [4]Jugadas de laboratorio\n  [5]Entrenador de Arqueros\n  [6]Entrenador fisico\n");
					int masters = lector.nextInt();
					lector.nextLine();
					String message = club.addMaster(id,masters);
					System.out.println(message);
					exit = false;
				}
				else if(option == 3){
					System.out.println("Ingrese el numero de anios de experiencia del Asistente");
					int exp = lector.nextInt();
					lector.nextLine();

					String text = club.changeExp(id, exp);
					System.out.println(text);
					exit = false;
				}
				else 
					System.out.println("Numero NO valido");
			}
			else
				System.out.println("El asistente NO existe");
		}
	}

	public void actPlayer(){
		boolean exit = true;
		while(exit){
			System.out.println("[1] Actualizar salario\n[2] Cambiar numero de camiseta\n[3] Actualizar cantidad de goles anotados\n"+
				"[4] Actualizar calificacion promedio\n[5] Cambiar posicion");
			int option = lector.nextInt();
			lector.nextLine();

			System.out.println("Ingrese el ID del Jugador");
			String id = lector.nextLine();
			boolean stop = club.findEmployee(id);
			if(!stop){

				if(option == 1){
					System.out.println("Ingrese el nuevo salario para el jugador");
					int salary = lector.nextInt();
					lector.nextLine();
					club.changeSalary(id,salary);
					System.out.println("El salario ha sido actualizado");
					exit = false;
				}
				else if(option == 2){
					System.out.println("Ingrese el nuevo numero de camiseta para el jugador");
					int number = lector.nextInt();
					lector.nextLine();

					String message = club.changeNumber(id,number);
					System.out.println(message);
					exit = false;
				}
				else if(option == 3){
					System.out.println("Ingrese la cantidad de goles anotados por el jugador");
					int amountGoals = lector.nextInt();
					lector.nextLine();

					String sign = club.putGoals(id, amountGoals);
					System.out.println(sign);
					exit = false;
				}
				else if(option == 4){
					System.out.println("Ingrese la calificacion promedio del jugador");
					double average = lector.nextDouble();
					lector.nextLine();

					String text = club.putAverage(id,average);
					System.out.println(text);
					exit = false;
				}
				else if(option == 5){System.out.println("\nIngrese la nueva posicion\n[1] Portero\n[2] Defensa\n[3] Volante\n[4] Delantero\n");
					int position = lector.nextInt();
					lector.nextLine();

					String text = club.putNewPosition(id,position);
					System.out.println(text);
					exit = false;
				}
				else
					System.out.println("Numero NO valido");
			}else
				System.out.println("El jugador NO existe");
		}
	}

	public void addLineUps(){
		boolean exit = true;
		while(exit){	
			System.out.println("\nA que equipo va a agregar la alineacion?");
			String teams = club.showTeams();
			System.out.println(teams);
			int team = lector.nextInt();
			int[] date = dates();

			System.out.println("\nQue tactica se usa en la formacion?\n");
			System.out.println("[1] Posesion\n[2] ContraAtaque\n[3] Presion Alta\n[4] Por defecto\n");
			int tactic = lector.nextInt();
			if(tactic >= 1 && tactic <= 4){

				if(team == 1 || team == 2){
					System.out.println("\nCuantos defensas tiene la formacion?");
					int def = lector.nextInt();

					if(def >= 1 && def < 10){
						System.out.println("\nCuantos mediocampistas tiene la formacion?");
						int mc = lector.nextInt();

						if(mc >= 1 && mc < 10){
							System.out.println("\nCuantos Delanteros tiene la formacion?");
							int cd = lector.nextInt();

							if(cd >= 1 && cd < 10){
								String message = club.addLineUps(team,def,mc,cd,date,tactic);
								System.out.println(message);
								if(message.equals("Alineacion creada!")){
									exit = false;
								}

							}else 
								System.out.println("En la formacion debe haber al menos un Delantero");
						}else 
							System.out.println("En la formacion debe haber al menos un mediocampista");
					}else 
						System.out.println("En la formacion debe haber al menos un defensa");
				}else 
					System.out.println("Ingreso un numero NO valido");
			}else
				System.out.println("Ingreso un numero NO valido");
		}
	}

	public int[] dates(){
		int[] date = new int[3];
		boolean exit = true;
		for(int i=0;exit;i++){
			System.out.println("Introduzca solo el dia en que se creo la formacion");
			date[0] = lector.nextInt();

			if(date[0]<=31){
				System.out.println("Introduzca solo el mes en que se creo la formacion");
				date[1] = lector.nextInt();
				
				if(date[1]<=12){
					System.out.println("Introduzca solo el anio en que se creo la formacion");
					date[2] = lector.nextInt();
					lector.nextLine();
					exit = false;
				
				}else
					System.out.println("Mes INCORRECTO!");
			}else
				System.out.println("Dia INCORRECTO!");
		}
		return date;
	}

	public void showInfo(){
		String show = "";
		show = club.showInfoClub()+"\n";

		show += club.showInfoA()+"\n";
		show += club.showEmployeesA();
		show += club.linesA()+"\n";
		show += club.installations()+"\n";

		show += club.showInfoB()+"\n";
		show += club.showEmployeesB();
		show += club.linesB()+"\n";
		show += club.installationsB()+"\n";
		show += club.showOffices()+"\n";

		System.out.println(show);
	}

	public void menuTeams(){
		boolean stop = false;
		while(!stop){
			System.out.println("\nQue opcion desea realizar?\n");
			System.out.println("[1] Informacion de el equipo A\n[2] Informacion del equipo B\n"+
				"[3] Entrenadores en las oficinas\n[0] Salir al menu principal\n");
			int option = lector.nextInt();
			lector.nextLine();
			switch(option){

				case 1:
					showInfoTeamA();
					break; 

				case 2:
					showInfoTeamB();
					break; 

				case 3:
					showOffice();
					break;

				case 0:
					stop = true;
					break; 	

				default: 
                	System.out.println("\nIngreso un numero NO valido");
			}
		}
	}

	public void showInfoTeamA(){
		String show = "";
		show += club.showInfoA()+"\n";
		show += club.showEmployeesA();
		show += club.linesA()+"\n";
		show += club.installations()+"\n";
		System.out.println(show);
	}

	public void showInfoTeamB(){
		String show = "";
		show += club.showInfoB()+"\n";
		show += club.showEmployeesB();
		show += club.linesB()+"\n";
		show += club.installationsB()+"\n";
		System.out.println(show);
	}

	public void showOffice(){
		String show = "";
		show = club.showOffices()+"\n";
		System.out.println(show);
	}

}
