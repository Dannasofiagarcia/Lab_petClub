package ui;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.InputMismatchException;
import java.util.Scanner;
import model.*;

public class Main {

	// RELACIONES

	private Scanner lector;
	private ClubManager clubManager;

	// CONSTRUCTOR

	public Main() {
		clubManager = new ClubManager();
		lector = new Scanner(System.in);
	}

	public static void main(String[] args) {
		Main interfaz = new Main();
		try {
			interfaz.showMenu();
		} catch (ExceptionOpcionIncorrecta e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void showMenu() throws ExceptionOpcionIncorrecta {
		int userInput = 0;

		while (userInput != 11) {
			showOptions();
			userInput = lector.nextInt();
			lector.nextLine();

			switch (userInput) {

			case 1:
				boolean continuarCiclo = true;
				do {
					try {
						System.out.println("Ingrese el id del club que desea agregar");
						String idClub = lector.nextLine();

						System.out.println("Ingrese el nombre del club que desea agregar");
						String nombreClub = lector.nextLine();

						System.out.println("Ingrese la fecha actual en el siguiente formato yyyy-MM-dd");
						String dateString = lector.nextLine();
						DateFormat formato = new SimpleDateFormat("yyyy-MM-dd");
						Date dateClubs = formato.parse(dateString);

						System.out.println("Ingrese el tipo de mascota favorito del club");
						String typePet = lector.nextLine();

						Club club = new Club(idClub, nombreClub, dateClubs, typePet);
						System.out.println(clubManager.addClub(club));
						clubManager.guardarClub(club);

						System.out.println("Desea registrar un dueño al club creado?");
						System.out.println("1. Si \n 2. No");
						int decision = lector.nextInt();
						lector.nextLine();

						if (decision == 1) {
							System.out.println("Ingrese el id del dueño que desea agregar");
							String idOwner = lector.nextLine();

							System.out.println("Ingrese el nombre del dueño que desea agregar");
							String nameOwner = lector.nextLine();

							System.out.println(
									"Ingrese la fecha de nacimiento del dueño en el siguiente formato mes/dia/año");
							String bornDateOwnerString = lector.nextLine();
							DateFormat formato1 = new SimpleDateFormat("MM/dd/yyyy");
							Date bornDateOwner = formato1.parse(bornDateOwnerString);

							System.out.println("Ingrese el tipo de mascota favorito del dueño que desea agregar");
							String petTypeOwner = lector.nextLine();

							Owner owner = new Owner(idOwner, nameOwner, bornDateOwner, petTypeOwner);
							System.out.println(clubManager.agregarOwnerClubEspecifico(owner, club));
							continuarCiclo = false;
						} else {
							continuarCiclo = false;
						}
					} catch (ParseException e) {
						System.err.printf("\nExcepcion: %s\n", e);
						System.out.println("No se pudo convertir de String a Date. Intente de nuevo");
						continuarCiclo = false;
					} catch (InputMismatchException e) {
						System.err.printf("\nExcepcion: %s\n", e);
						System.out.println("El dato que ingreso es incorrecto. Intente de nuevo");
					}
				} while (continuarCiclo == true);

				break;

			case 2:
				boolean continuarCiclo1 = true;
				do {
					try {
						System.out.println("Ingrese el id del dueño que desea agregar");
						String idOwner = lector.nextLine();

						System.out.println("Ingrese el nombre del dueño que desea agregar");
						String nameOwner = lector.nextLine();

						System.out
								.println("Ingrese la fecha de nacimiento del dueño en el siguiente formato mes/dia/año");
						String bornDateOwnerString = lector.nextLine();
						DateFormat formato1 = new SimpleDateFormat("MM/dd/yyyy");
						Date bornDateOwner = formato1.parse(bornDateOwnerString);

						System.out.println("Ingrese el tipo de mascota favorito del dueño que desea agregar");
						String petTypeOwner = lector.nextLine();

						Owner owner = new Owner(idOwner, nameOwner, bornDateOwner, petTypeOwner);

						System.out.println(
								"La siguiente es una lista con el nombre de los clubs disponibles, seleccione al que desea agregar el nuevo dueño");
						System.out.println(clubManager.nombreClubsDisponibles());
						String nombreClubSeleccionado = lector.nextLine();
						clubManager.agregarOwnerByName(owner, nombreClubSeleccionado);

						System.out.println("Desea registrar una mascota al dueño creado?");
						System.out.println("1. Si \n2. No");
						int decisionPet = lector.nextInt();
						lector.nextLine();

						if (decisionPet == 1) {

							System.out.println("Ingrese el ID de la mascota que desea agregar");
							String petId = lector.nextLine();

							System.out.println("Ingrese el nombre de la mascota que desea agregar");
							String petName = lector.nextLine();

							System.out.println("Ingrese la fecha de nacimiento de la mascota que desea agregar en el siguiente formato mes/dia/año");
							String bornDateString = lector.nextLine();
							DateFormat formato2 = new SimpleDateFormat("MM/dd/yyyy");
							Date bornDatePet = formato2.parse(bornDateString);

							System.out.println("Seleccione el genero de la mascota \n 1. Femenino \n 2. Masculino");
							int seleccionGenero = lector.nextInt();
							lector.nextLine();

							String genero = "";

							if (seleccionGenero == 1) {
								genero = Pet.FEMALE;
							}

							else {
								genero = Pet.MALE;
							}

							System.out.println("Ingrese que tipo es la mascota que desea agregar");
							String typePet = lector.nextLine();

							Pet pet = new Pet(petId, petName, bornDatePet, genero, typePet);
							clubManager.agregarPetByName(owner, nombreClubSeleccionado, pet);
							continuarCiclo1 = false;
						} else {
							continuarCiclo1 = false;
						}
					} catch (ParseException e) {
						System.err.printf("\nExcepcion: %s\n", e);
						System.out.println("No se pudo convertir de String a Date");
						continuarCiclo1 = false;
					} catch (InputMismatchException e) {
						System.err.printf("\nExcepcion: %s\n", e);
						System.out.println("El dato que ingreso es incorrecto. Intente de nuevo");
					}
				} while (continuarCiclo1 == true);

				break;

			case 3:
				boolean continuarCiclo2 = true;
				do {
					try {

						System.out.println("Ingrese el ID de la mascota que desea agregar");
						String petId = lector.nextLine();

						System.out.println("Ingrese el nombre de la mascota que desea agregar");
						String petName = lector.nextLine();

						System.out.println(
								"Ingrese la fecha de nacimiento de la mascota que desea agregar en el siguiente formato mes/dia/año");
						String bornDateString = lector.nextLine();
						DateFormat formato1 = new SimpleDateFormat("MM/dd/yyyy");
						Date bornDatePet = formato1.parse(bornDateString);

						System.out.println("Seleccione el genero de la mascota \n 1. Femenino \n2. Masculino");
						int seleccionGenero = lector.nextInt();
						lector.nextLine();

						String genero = "";

						if (seleccionGenero == 1) {
							genero = Pet.FEMALE;
						}

						else {
							genero = Pet.MALE;
						}

						System.out.println("Ingrese que tipo es la mascota que desea agregar");
						String typePet = lector.nextLine();

						Pet pet = new Pet(petId, petName, bornDatePet, genero, typePet);

						System.out.println("Ingrese el nombre del dueño al que desea agregarle la mascota creada");
						String seleccionDueno = lector.nextLine();
						System.out.println(clubManager.agregarPetByOwner(seleccionDueno, pet));
						continuarCiclo2 = false;

					} catch (ParseException e) {
						System.err.printf("\nExcepcion: %s\n", e);
						System.out.println("No se pudo convertir de String a Date");
						continuarCiclo2 = false;
					} catch (InputMismatchException e) {
						System.err.printf("\nExcepcion: %s\n", e);
						System.out.println("El dato que ingreso es incorrecto. Intente de nuevo");
					}
				} while (continuarCiclo2 == true);
				break;

			case 4:
				System.out.println("Seleccione como desea eliminar el club \n1. Nombre del club\n2. Id del club");
				int decisionEliminarClub = lector.nextInt();
				lector.nextLine();

				if (decisionEliminarClub == 1) {
					System.out.println("Ingrese el nombre del club que desea eliminar");
					String nombreClubEliminar = lector.nextLine();
					System.out.println(clubManager.eliminarClubPorNombre(nombreClubEliminar));
				}

				else if (decisionEliminarClub == 2) {
					System.out.println("Ingrese el id del club que desea eliminar");
					String idClubEliminar = lector.nextLine();
					System.out.println(clubManager.eliminarClubPorId(idClubEliminar));
				}
				break;

			case 5:
				System.out.println("Seleccione como desea eliminar el dueño \n1. Nombre del dueño\n2. Id del dueño");
				int decisionEliminarOwner = lector.nextInt();
				lector.nextLine();

				if (decisionEliminarOwner == 1) {
					System.out.println("Ingrese el nombre del dueño que desea eliminar");
					String nombreDuenoEliminar = lector.nextLine();
					System.out.println(clubManager.eliminarOwnerPorNombre(nombreDuenoEliminar));
				}

				else if (decisionEliminarOwner == 2) {
					System.out.println("Ingrese el id del dueño que desea eliminar");
					String idOwnerEliminar = lector.nextLine();
					System.out.println(clubManager.eliminarOwnerPorId(idOwnerEliminar));
				}
				break;

			case 6:
				System.out.println(
						"Seleccione como desea eliminar la mascota \n1. Nombre de la mascota\n2. Id de la mascota");
				int decisionEliminarMascota = lector.nextInt();
				lector.nextLine();

				if (decisionEliminarMascota == 1) {
					System.out.println("Ingrese el nombre de la mascota que desea eliminar");
					String nombrePetE = lector.nextLine();
					System.out.println(clubManager.eliminarPetPorNombre(nombrePetE));
				}

				else if (decisionEliminarMascota == 2) {
					System.out.println("Ingrese el id de la mascota que desea eliminar");
					String idPetE = lector.nextLine();
					System.out.println(clubManager.eliminarPetPorId(idPetE));
				}
				break;

			case 7:
				boolean continuar = true;
				do {					
					System.out.println("El reporte se realiza ordenando los datos segun el criterio que escoja");
					System.out.println("Seleccione en que clase desea realizar el reporte");
					System.out.println("1. Clubs\n2.Dueños\n3.Mascotas");
					int decisionOrdenamiento = lector.nextInt();
					lector.nextLine();

					if (decisionOrdenamiento == 1) {
						System.out.println("Seleccione el criterio por el que desea ordenar los clubs");
						System.out.println(
								"1. Id\n2. Nombre\n3. Fecha creacion\n4. Tipo de mascota favorito\n5. Cantidad de dueños");
						int decisionOrdenamientoClubs = lector.nextInt();
						lector.nextLine();
						if (decisionOrdenamientoClubs == 1) {
							System.out.println(clubManager.ordenamientoBurbujaIdClub());
							continuar = false;
						} else if (decisionOrdenamientoClubs == 2) {
							System.out.println(clubManager.ordenamientoCTNombreClubs());
							continuar = false;
						} else if (decisionOrdenamientoClubs == 3) {
							System.out.println(clubManager.ordenamientoIncersionDateClub());
							continuar = false;
						} else if (decisionOrdenamientoClubs == 4) {
							System.out.println(clubManager.ordenamientoCTypePetClub());
							continuar = false;
						} else if (decisionOrdenamientoClubs == 5) {
							System.out.println(clubManager.ordenamientoPorCantidadDuenos());
							continuar = false;
						} else {
							throw new ExceptionOpcionIncorrecta(decisionOrdenamientoClubs);
						}

					} else if (decisionOrdenamiento == 2) {
						System.out.println("Seleccione el criterio por el que desea ordenar los dueños");
						System.out.println(
								"1. Id\n2. Nombre\n3. Fecha nacimiento\n4. Tipo de mascota favorito\n5 .Cantidad de mascotas");
						int decisionOrdenamientoOwners = lector.nextInt();
						lector.nextLine();

						if (decisionOrdenamientoOwners == 1) {
							System.out.println(clubManager.ordenamientoBurbujaOwnerID());
							continuar = false;
						} else if (decisionOrdenamientoOwners == 2) {
							System.out.println(clubManager.ordenamientoCTOwnerName());
							continuar = false;
						} else if (decisionOrdenamientoOwners == 3) {
							System.out.println(clubManager.ordenamientoInsercionOwnerBornDate());
							continuar = false;
						} else if (decisionOrdenamientoOwners == 4) {
							System.out.println(clubManager.ordenamientoBurbujaCTypePetOwner());
							continuar = false;
						} else if (decisionOrdenamientoOwners == 5) {
							continuar = false;
						} else {
							throw new ExceptionOpcionIncorrecta(decisionOrdenamientoOwners);
						}

					} else if (decisionOrdenamiento == 3) {
						System.out.println("Seleccione el criterio por el que desea ordenar las mascotas");
						System.out.println(
								"1.Id\n2.Nombre\n3.Fecha nacimiento\n4.Tipo de mascota");
						int decisionOrdenamientoPets = lector.nextInt();
						lector.nextLine();

						if (decisionOrdenamientoPets == 1) {
							System.out.println(clubManager.ordenamientoBurbujaPetId());
							continuar = false;
						} else if (decisionOrdenamientoPets == 2) {
							System.out.println(clubManager.ordenamientoCTnombrePet());
							continuar = false;
						} else if (decisionOrdenamientoPets == 3) {
							System.out.println(clubManager.ordenamientoInsercionPetDate());
							continuar = false;
						} else if (decisionOrdenamientoPets == 4) {
							System.out.println(clubManager.ordenamientoCCPetTypePet());
							continuar = false;

						} else {
							throw new ExceptionOpcionIncorrecta(decisionOrdenamientoPets);
						}
					} else {
						throw new ExceptionOpcionIncorrecta(decisionOrdenamiento);
					}

				} while (continuar == true);

				break;

			case 9:
				clubManager.cargarTodosLosDatosGenerados();
				System.out.println("Datos actualizados");
			
				break;

			}// Cierra el switch

			if (userInput > 11) {
				throw new ExceptionOpcionIncorrecta(userInput);
			}

			if (userInput == 11) {
				for (Club clubs : clubManager.getClubs()) {
					clubs.serializarOwners();
				}
			}
		} // Cierra el while

	}// Cierra el metodo

	public void showOptions() {
		System.out.println("Bienvenido, digite la opcion que desea");
		System.out.println("1. Para registrar un nuevo club");
		System.out.println("2. Para registrar un dueño a un club en especifico");
		System.out.println("3. Para registrar una mascota a un dueño en especifico");
		System.out.println("4. Para eliminar un club");
		System.out.println("5. Para eliminar un dueño");
		System.out.println("6. Para eliminar una mascota");
		System.out.println("7. Para realizar un reporte de la informacion");
		System.out.println("8. Para realizar una busqueda");
		System.out.println("9. Para actualizar la información obtenida de MockData");
		System.out.println("10. Para guardar la informacion");
		System.out.println("11. Para salir");
	}
}
