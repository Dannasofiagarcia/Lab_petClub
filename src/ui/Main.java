package ui;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.InputMismatchException;
import java.util.Scanner;
import model.*;

public class Main {

	// RELACIONES

	private Scanner lector;
	private Investor investor;

	// CONSTRUCTOR

	public Main() {
		investor = new Investor();
		lector = new Scanner(System.in);
	}

	public static void main(String[] args) {
		Main interfaz = new Main();
		interfaz.showMenu();
	}

	public void showMenu() {
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
						investor.addClub(club);

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
									"Ingrese la fecha de nacimiento del dueño en el siguiente formato yyyy-MM-dd");
							String bornDateOwnerString = lector.nextLine();
							DateFormat formato1 = new SimpleDateFormat("yyyy-MM-dd");
							Date bornDateOwner = formato1.parse(bornDateOwnerString);

							System.out.println("Ingrese el tipo de mascota favorito del dueño que desea agregar");
							String petTypeOwner = lector.nextLine();

							Owner owner = new Owner(idOwner, nameOwner, bornDateOwner, petTypeOwner);
							investor.agregarOwnerClubE(owner, club);
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
								.println("Ingrese la fecha de nacimiento del dueño en el siguiente formato yyyy-MM-dd");
						String bornDateOwnerString = lector.nextLine();
						DateFormat formato1 = new SimpleDateFormat("yyyy-MM-dd");
						Date bornDateOwner = formato1.parse(bornDateOwnerString);

						System.out.println("Ingrese el tipo de mascota favorito del dueño que desea agregar");
						String petTypeOwner = lector.nextLine();

						Owner owner = new Owner(idOwner, nameOwner, bornDateOwner, petTypeOwner);

						System.out.println(
								"La siguiente es una lista con el nombre de los clubs disponibles, seleccione al que desea agregar el nuevo dueño");
						System.out.println(investor.nombreClubsDisponibles());
						String nombreClubSeleccionado = lector.nextLine();
						investor.agregarOwnerByName(owner, nombreClubSeleccionado);

						System.out.println("Desea registrar una mascota al dueño creado?");
						System.out.println("1. Si \n 2. No");
						int decisionPet = lector.nextInt();
						lector.nextLine();

						if (decisionPet == 1) {

							System.out.println("Ingrese el ID de la mascota que desea agregar");
							String petId = lector.nextLine();

							System.out.println("Ingrese el nombre de la mascota que desea agregar");
							String petName = lector.nextLine();

							System.out.println("Ingrese la fecha de nacimiento de la mascota que desea agregar");
							String bornDateString = lector.nextLine();
							DateFormat formato2 = new SimpleDateFormat("yyyy-MM-dd");
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
							investor.agregarPetByName(owner, nombreClubSeleccionado, pet);
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
								"Ingrese la fecha de nacimiento de la mascota que desea agregar en el siguiente formato yyyy-MM-dd");
						String bornDateString = lector.nextLine();
						DateFormat formato1 = new SimpleDateFormat("yyyy-MM-dd");
						Date bornDatePet = formato1.parse(bornDateString);

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

						System.out.println(
								"Los siguiente son los dueños disponibles y sus respectivos nombres. Seleccione el dueño al que desea agregarle la mascota creada");
						System.out.println(investor.nombreDuenos());
						String seleccionDueno = lector.nextLine();
						investor.agregarPetByOwner(seleccionDueno, pet);
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
//				System.out.println()
			}// Cierra el switch

			if (userInput > 11)

			{
				// throw new ExceptionOpcionIncorrecta(userInput);
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
		System.out.println("9. Para guardar la informacion");
		System.out.println("11. Para salir");

	}

}
