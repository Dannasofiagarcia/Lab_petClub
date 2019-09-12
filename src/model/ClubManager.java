package model;

import java.io.*;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;

public class ClubManager {

	// CONSTANTES

	public final static String SP = File.separator;
	public final static String RAIZ = "C:" + SP + "Users" + SP + "Danna García" + SP + "Documents" + SP + "petClub" + SP
			+ "data";
	public final static String RUTA_GENERADOS = RAIZ + SP + "Generados";
	public final static String RUTA_PRUEBA = RAIZ + SP + "GeneradosSimplificados";
	public final static String RUTA_ALMACENAMIENTO = RAIZ + SP + "Almacenamiento";

	// RELACIONES

	private ArrayList<Club> clubs;

	// CONSTRUCTOR

	public ClubManager() {
		clubs = new ArrayList<Club>();
		cargar();
		deserializar();
		//cargarDatosPetGenerados();
		//cargarDatosOwnerGenerados();
	}

	// METODOS

	// Metodos get y set

	public ArrayList<Club> getClubs() {
		return clubs;
	}

	public void setClubs(ArrayList<Club> clubs) {
		this.clubs = clubs;
	}

	// Metodo para cargar los datos del club

	public void cargarDatosClubGenerados() {

		String nombreArchivo = SP + "Clubs.csv";

		// Active la siguiente ruta para cargar los datos de prubea
		String rutaArchivo = RUTA_PRUEBA + nombreArchivo;

		// Active la siguiente ruta para cargar los datos generados
		// String rutaArchivo = RUTA_GENERADOS + nombreArchivo;

		try {
			File archivo = new File(rutaArchivo);
			BufferedReader lector = new BufferedReader(new FileReader(archivo));

			try {
				// lee la primera linea
				lector.readLine();
			} catch (IOException ioException) {
				System.err.printf("\nExcepcion: %s\n", ioException);
				System.out.println("Debe haber por lo menos un dato");
			}

			String datos = "";

			try {
				// lee la segunda linea
				datos = lector.readLine();
			} catch (IOException ioException) {
				System.err.printf("\nExcepcion: %s\n", ioException);
				System.out.println("Debe haber por lo menos un dato");
			}
			do {

				if (datos != null) {

					// Buscamos la primera coma de la linea
					int primeraComa = datos.indexOf(",");

					// Si primeraComa es = -1 quiere decir que no la encontro
					if (primeraComa != -1) {
						// despuesPrimeraComa es el texto que resta despues de encontrar la primera coma
						String despuesPrimeraComa = datos.substring(primeraComa + 1);
						// Buscamos en despuesPrimeraComa la segunda coma de la linea
						int segundaComa = despuesPrimeraComa.indexOf(",");

						if (segundaComa != -1) {
							// despuesSegundaComa es el texto que resta despues de encontrar la segunda coma
							String despuesSegundaComa = despuesPrimeraComa.substring(segundaComa + 1);
							// Buscamos en despuesSegundaComa la tercera y ultima coma que deberia tener la
							// linea
							int terceraComa = despuesSegundaComa.indexOf(",");

							if (terceraComa != -1) {
								String despuesTerceraComa = despuesSegundaComa.substring(terceraComa + 1);

								String idC = datos.substring(0, primeraComa);
								String clubN = despuesPrimeraComa.substring(0, segundaComa);
								String dateC = despuesSegundaComa.substring(0, terceraComa);
								String petTC = despuesTerceraComa.substring(0);

								DateFormat formato = new SimpleDateFormat("MM/dd/YYYY");
								Date dateClubs = formato.parse(dateC);
								Club club = new Club(idC, clubN, dateClubs, petTC);
								addClub(club);
								guardarClub(club);
							}
						}
					}
				}
			} while ((datos = lector.readLine()) != null);

			lector.close();

		} catch (FileNotFoundException e) {
			System.err.printf("\nExcepcion: %s\n", e);
			System.out.println("No se encontro ningun archivo con el nombre " + nombreArchivo);
		} catch (ParseException e) {
			System.err.printf("\nExcepcion: %s\n", e);
			System.out.println("No se pudo convertir de String a Date");
		} catch (IOException e) {
			System.err.printf("\nExcepcion: %s\n", e);
			System.out.println("No se pudo leer la linea");
		}
	}

	// Metodo para cargar los datos de los dueños

	public void cargarDatosOwnerGenerados() {

		String nombreArchivo = SP + "Owners.csv";

		// Active la siguiente ruta para cargar los datos de prueba
		String rutaArchivo = RUTA_PRUEBA + nombreArchivo;

		// Active la siguiente ruta para cargar los datos generados
		// String rutaArchivo = RUTA_GENERADOS + nombreArchivo;

		try {
			File archivo = new File(RUTA_GENERADOS + nombreArchivo);
			BufferedReader lector = new BufferedReader(new FileReader(archivo));

			try {
				// lee la primera linea
				lector.readLine();
			} catch (IOException ioException) {
				System.err.printf("\nExcepcion: %s\n", ioException);
				System.out.println("Debe haber por lo menos un dato");
			}

			String datos = null;
			do {

				try {
					// lee la segunda linea
					datos = lector.readLine();
				} catch (IOException ioException) {
					System.err.printf("\nExcepcion: %s\n", ioException);
					System.out.println("Debe haber por lo menos un dato");
				}

				if (datos != null) {

					// Buscamos la primera coma de la linea
					int primeraComa = datos.indexOf(",");

					// Si primeraComa es = -1 quiere decir que no la encontro
					if (primeraComa != -1) {
						// despuesPrimeraComa es el texto que resta despues de encontrar la primera coma
						String despuesPrimeraComa = datos.substring(primeraComa + 1);
						// Buscamos en despuesPrimeraComa la segunda coma de la linea
						int segundaComa = despuesPrimeraComa.indexOf(",");

						if (segundaComa != -1) {
							// despuesSegundaComa es el texto que resta despues de encontrar la segunda coma
							String despuesSegundaComa = despuesPrimeraComa.substring(segundaComa + 1);
							// Buscamos en despuesSegundaComa la tercera y ultima coma que deberia tener la
							// linea
							int terceraComa = despuesSegundaComa.indexOf(",");

							if (terceraComa != -1) {
								String despuesTerceraComa = despuesSegundaComa.substring(terceraComa + 1);

								String idO = datos.substring(0, primeraComa);
								String nameO = despuesPrimeraComa.substring(0, segundaComa);
								String bornDateO = despuesSegundaComa.substring(0, terceraComa);
								String petTO = despuesTerceraComa;

								DateFormat formato = new SimpleDateFormat("MM/dd/yyyy");
								Date bornDate = formato.parse(bornDateO);
								Owner owner = new Owner(idO, nameO, bornDate, petTO);
								agregarOwner(owner);
							}
						}
					}
				}

			} while (datos != null);

			lector.close();

		} catch (FileNotFoundException e) {
			System.err.printf("\nExcepcion: %s\n", e);
			System.out.println("No se encontro ningun archivo con el nombre " + nombreArchivo);
		} catch (ParseException e) {
			System.err.printf("\nExcepcion: %s\n", e);
			System.out.println("No se pudo convertir de String a Date");
		} catch (IOException e) {
			System.err.printf("\nExcepcion: %s\n", e);
			System.out.println("No se pudo leer la linea");
		}
	}

	// Metodo para agregar dueños a los clubs

	public String agregarOwner(Owner owner) {
		String msg = "";
		boolean agregado = false;
		for (int i = 0; i < clubs.size() && !agregado; i++) {
			if (clubs.get(i).getClubOwners().size() < 100000) {
				if (clubs.get(i).verificarId(owner) == false) {
					clubs.get(i).agregarDueno(owner);
					agregado = true;
				}
			} else {
				msg = "Ya existe otra persona con el ID " + owner.getIdOwner() + ". No fue posible agregar el dueño";
			}
		}
		return msg;
	}

	// Metodo para agregar a un dueño a un club especifico

	public String agregarOwnerClubEspecifico(Owner owner, Club club) {
		String msg = "";
		boolean agregado = false;
		for (int i = 0; i < clubs.size() && !agregado; i++) {
			if (clubs.get(i).getIdClub().equals(club.getIdClub())) {
				if (clubs.get(i).getClubOwners().size() < 100000) {
					if (clubs.get(i).verificarId(owner) == false) {
						clubs.get(i).agregarDueno(owner);
						agregado = true;
						msg = "Se ha agregado el dueño con exito";
					} else {
						msg = "Ya existe otra persona con el ID " + owner.getIdOwner()
								+ ". No fue posible agregar el dueño";
					}
				} else {
					msg = "No se puede agregar al club porque ya tiene más de 100.000 miembros";
				}
			}
		}
		return msg;
	}

	// Metodo para agregar un dueño a un club teniendo el nombre del club

	public String agregarOwnerByName(Owner owner, String name) {
		String msg = "";
		boolean agregado = false;
		for (int i = 0; i < clubs.size() && !agregado; i++) {
			if (clubs.get(i).getClubName().equals(name)) {
				if (clubs.get(i).getClubOwners().size() < 100000) {
					if (clubs.get(i).verificarId(owner) == false) {
						clubs.get(i).agregarDueno(owner);
						agregado = true;
						msg = "Se ha agregado el dueño con exito";
					} else {
						msg = "Ya existe otra persona con el ID " + owner.getIdOwner()
								+ ". No fue posible agregar el dueño";
					}
				} else {
					msg = "No se puede agregar al club porque ya tiene más de 100.000 miembros";
				}
			}
		}
		return msg;
	}

	// Metodo para cargar los datos de las mascotas de MockData

	public void cargarDatosPetGenerados() {
		String nombreArchivo = SP + "Pets.csv";

		// Active la siguiente ruta para cargar los datos generados
		// String rutaArchivo = RUTA_GENERADOS + nombreArchivo;

		// Active la siguiente ruta para cargar los datos de prueba
		String rutaArchivo = RUTA_PRUEBA + nombreArchivo;

		try {
			File archivo = new File(rutaArchivo);
			BufferedReader lector = new BufferedReader(new FileReader(archivo));

			try {
				// lee la primera linea
				lector.readLine();
			} catch (IOException ioException) {
				System.err.printf("\nExcepcion: %s\n", ioException);
				System.out.println("Debe haber por lo menos un dato");
			}

			String datos = null;
			do {
				try {
					// lee la segunda linea
					datos = lector.readLine();
				} catch (IOException ioException) {
					System.err.printf("\nExcepcion: %s\n", ioException);
					System.out.println("Debe haber por lo menos un dato");
				}

				if (datos != null) {

					// Buscamos la primera coma de la linea
					int primeraComa = datos.indexOf(",");

					// Si primeraComa es = -1 quiere decir que no la encontro
					if (primeraComa != -1) {
						// despuesPrimeraComa es el texto que resta despues de encontrar la primera coma
						String despuesPrimeraComa = datos.substring(primeraComa + 1);
						// Buscamos en despuesPrimeraComa la segunda coma de la linea
						int segundaComa = despuesPrimeraComa.indexOf(",");

						if (segundaComa != -1) {
							// despuesSegundaComa es el texto que resta despues de encontrar la segunda coma
							String despuesSegundaComa = despuesPrimeraComa.substring(segundaComa + 1);
							// Buscamos en despuesSegundaComa la tercera y ultima coma que deberia tener la
							// linea
							int terceraComa = despuesSegundaComa.indexOf(",");

							if (terceraComa != -1) {
								String despuesTerceraComa = despuesSegundaComa.substring(terceraComa + 1);
								int cuartaComa = despuesTerceraComa.indexOf(",");

								if (cuartaComa != -1) {
									String despuesCuartaComa = despuesTerceraComa.substring(cuartaComa + 1);

									String petId = datos.substring(0, primeraComa);
									String petName = despuesPrimeraComa.substring(0, segundaComa);
									String bornDateP = despuesSegundaComa.substring(0, terceraComa);
									String petGender = despuesTerceraComa.substring(0, cuartaComa);
									String petType = despuesCuartaComa;

									DateFormat formato = new SimpleDateFormat("MM/dd/yyyy");
									Date bornDate = formato.parse(bornDateP);
									Pet pet = new Pet(petId, petName, bornDate, petGender, petType);
									addPets(pet);
								}
							}
						}
					}
				}

			} while ((datos = lector.readLine()) != null);

			lector.close();

		} catch (FileNotFoundException e) {
			System.err.printf("\nExcepcion: %s\n", e);
			System.out.println("No se encontro ningun archivo con el nombre " + nombreArchivo);
		} catch (ParseException e) {
			System.err.printf("\nExcepcion: %s\n", e);
			System.out.println("No se pudo convertir de String a Date");
		} catch (IOException e) {
			System.err.printf("\nExcepcion: %s\n", e);
			System.out.println("No se pudo leer la linea");
		}

	}

	// Metodo para agregar las mascotas

	public void addPets(Pet pet) {
		boolean agregado = false;
		for (int i = 0; i < clubs.size() && !agregado; i++) {
			clubs.get(i).addPet(pet);
			agregado = true;
		}
	}

	// Metodo para agregar una mascota a un club teniendo el nombre del club

	public void agregarPetByName(Owner owner, String name, Pet pet) {
		boolean agregado = false;
		for (int i = 0; i < clubs.size() && !agregado; i++) {
			if (clubs.get(i).getClubName().equals(name)) {
				Club club = clubs.get(i);
				club.addPetToOwner(owner, pet);
				agregado = true;
			}
		}
	}

	// Metodo para agregar a una mascota a un dueño teniendo el nombre del dueño

	public String agregarPetByOwner(String name, Pet pet) {
		String msg = "";
		boolean agregado = false;
		for (int i = 0; i < clubs.size() && !agregado; i++) {
			if (clubs.get(i).searchOwnerByName(name) == true) {
				Club club = clubs.get(i);
				club.agregarPetToOwner(name, pet);
				msg = "Se ha agregado a la mascota " + pet.getPetName() + " correctamente";
			} else {
				msg = "No se ha podido crear la mascota porque no existe dueño con el nombre ingresado";
			}
		}
		return msg;
	}

	// Metodo para guardar la informacion de TODOS los clubs

	public void guardarTodaLaInformacionClubs() {
		String msg = "";
		String nombreArchivo = SP + "InformacionClub.txt";
		String rutaArchivo = RUTA_ALMACENAMIENTO + nombreArchivo;
		try {
			FileWriter archivo = new FileWriter(rutaArchivo);
			BufferedWriter escritor = new BufferedWriter(archivo);
			for (int i = 0; i < clubs.size(); i++) {
				msg = clubs.get(i).toString();

				try {
					escritor.write(msg);
					escritor.newLine();
				} catch (IOException ioException) {
					System.err.printf("\nExcepcion: %s\n", ioException);
					System.out.println("No se pudo escribir el mensaje en " + nombreArchivo);
				}

				escritor.flush();
			}
			escritor.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	// Metodo para guardar un club especifico

	public void guardarClub(Club club) {
		String msg = "";
		String nombreArchivo = SP + "InformacionClub.txt";
		String rutaArchivo = RUTA_ALMACENAMIENTO + nombreArchivo;
		FileWriter archivoParaEscribir = null;
		BufferedWriter escritor = null;

		try {
			File archivo = new File(rutaArchivo);
			if (!archivo.exists()) {
				archivo.createNewFile();
			}

			archivoParaEscribir = new FileWriter(archivo.getAbsolutePath(), true);
			escritor = new BufferedWriter(archivoParaEscribir);
			msg = club.toString();
			escritor.write(msg);
			escritor.newLine();
		} catch (IOException ioException) {
			System.err.printf("\nExcepcion: %s\n", ioException);
			System.out.println("No se pudo escribir el mensaje en " + nombreArchivo);
		}
		try {
			escritor.flush();
			escritor.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	// Metodo que carga los datos guardados de los clubs

	public void cargarDatosGuardadosClub() {

		String nombreArchivo = SP + "InformacionClub.txt";
		String rutaArchivo = RUTA_ALMACENAMIENTO + nombreArchivo;

		try {
			File archivo = new File(rutaArchivo);
			BufferedReader lector = new BufferedReader(new FileReader(archivo));

			String datos = "";

			try {
				datos = lector.readLine();
			} catch (IOException ioException) {
				System.err.printf("\nExcepcion: %s\n", ioException);
				System.out.println("Debe haber por lo menos un dato");
			}
			do {

				if (datos != null) {

					// Buscamos la primera coma de la linea
					int primeraComa = datos.indexOf(",");

					// Si primeraComa es = -1 quiere decir que no la encontro
					if (primeraComa != -1) {
						// despuesPrimeraComa es el texto que resta despues de encontrar la primera coma
						String despuesPrimeraComa = datos.substring(primeraComa + 1);
						// Buscamos en despuesPrimeraComa la segunda coma de la linea
						int segundaComa = despuesPrimeraComa.indexOf(",");

						if (segundaComa != -1) {
							// despuesSegundaComa es el texto que resta despues de encontrar la segunda coma
							String despuesSegundaComa = despuesPrimeraComa.substring(segundaComa + 1);
							// Buscamos en despuesSegundaComa la tercera y ultima coma que deberia tener la
							// linea
							int terceraComa = despuesSegundaComa.indexOf(",");

							if (terceraComa != -1) {
								String despuesTerceraComa = despuesSegundaComa.substring(terceraComa + 1);

								String idC = datos.substring(0, primeraComa);
								String clubN = despuesPrimeraComa.substring(0, segundaComa);
								String dateC = despuesSegundaComa.substring(0, terceraComa);
								String petTC = despuesTerceraComa.substring(0);

								DateFormat formato = new SimpleDateFormat("yyyy-MM-dd");
								Date dateClubs = formato.parse(dateC);
								Club club = new Club(idC, clubN, dateClubs, petTC);
								addClub(club);
							}
						}
					}
				}
			} while ((datos = lector.readLine()) != null);

			lector.close();

		} catch (FileNotFoundException e) {
			System.err.printf("\nExcepcion: %s\n", e);
			System.out.println("No se encontro ningun archivo con el nombre " + nombreArchivo);
		} catch (ParseException e) {
			System.err.printf("\nExcepcion: %s\n", e);
			System.out.println("No se pudo convertir de String a Date");
		} catch (IOException e) {
			System.err.printf("\nExcepcion: %s\n", e);
			System.out.println("No se pudo leer la linea");
		}
	}

	// Metodo para agregar los clubs

	public String addClub(Club club) {
		String msg = "";
		boolean idIguales = false;
		for (int i = 0; i < clubs.size(); i++) {
			if (clubs.get(i).getIdClub().equals(club.getIdClub())
					| clubs.get(i).getClubName().equals(club.getClubName())) {
				idIguales = true;
				System.out.println("No se pudo agregar el club porque ya existe otro club con un nombre u ID igual");
			}
		}

		if (idIguales == false) {
			clubs.add(club);
			// msg = "Se ha agregado con exito el club " + club.getClubName();
		}
		return msg;
	}

	// Metodo que muestra el nombre de los clubs disponibles

	public String nombreClubsDisponibles() {
		String msg = "";
		for (int i = 0; i < clubs.size(); i++) {
			msg += (i + 1) + ". " + clubs.get(i).getClubName() + "\n";
		}
		return msg;
	}

	// Metodo que se encarga de cargar los datos de los clubs

	public void cargar() {
		String nombreArchivo = SP + "InformacionClub.txt";
		String rutaArchivo = RUTA_ALMACENAMIENTO + nombreArchivo;
		File file = new File(rutaArchivo);
		if (clubs == null | clubs.size() == 0) {
			if (file.exists()) {
				cargarDatosGuardadosClub();
			} else {
				cargarDatosClubGenerados();
			}
		}
	}

	// Metodo que elimina un club por el ID

	public String eliminarClubPorId(String id) {
		String msg = "";
		for (int i = 0; i < clubs.size(); i++) {
			if (clubs.get(i).getIdClub().equals(id)) {
				clubs.remove(i);
				msg = "El club ha sido eliminado con exito";
				guardarTodaLaInformacionClubs();
			} else {
				msg = "Ha ocurrido algo cuando se intentaba eliminar el club";
			}
		}
		return msg;
	}

	// Metodo que elimina un club por su nombre

	public String eliminarClubPorNombre(String nombre) {
		String msg = "";
		for (int i = 0; i < clubs.size(); i++) {
			if (clubs.get(i).getClubName().equals(nombre)) {
				clubs.remove(i);
				msg = "El club ha sido eliminado con exito";
			} else {
				msg = "Ha ocurrido algo cuando se intentaba eliminar el club";
			}
		}
		return msg;
	}

	// Metodo que elimina un dueño por su ID

	public String eliminarOwnerPorId(String id) {
		String msg = "";
		for (int i = 0; i < clubs.size(); i++) {
			if (clubs.get(i).eliminarDuenoId(id) == true) {
				msg = "El dueño ha sido eliminado con exito";
			} else {
				msg = "Ha ocurrido algo cuando se intentaba eliminar el dueño";
			}
		}
		return msg;
	}

	// Metodo que elimina un dueño por su nombre

	public String eliminarOwnerPorNombre(String nombre) {
		String msg = "";
		for (int i = 0; i < clubs.size(); i++) {
			if (clubs.get(i).eliminarDuenoNombre(nombre) == true) {
				msg = "El dueño ha sido eliminado con exito";
			} else {
				msg = "Ha ocurrido algo cuando se intentaba eliminar el dueño";
			}
		}
		return msg;
	}

	// Metodo que elimina una mascota por su ID

	public String eliminarPetPorId(String id) {
		String msg = "";
		for (int i = 0; i < clubs.size(); i++) {
			if (clubs.get(i).eliminarMascotaId(id) == true) {
				msg = "La mascota ha sido eliminado con exito";
			} else {
				msg = "Ha ocurrido algo cuando se intentaba eliminar la mascota";
			}
		}
		return msg;
	}

	// Metodo que elimina una mascota por su nombre

	public String eliminarPetPorNombre(String nombre) {
		String msg = "";
		for (int i = 0; i < clubs.size(); i++) {
			if (clubs.get(i).eliminarDuenoNombre(nombre) == true) {
				msg = "El dueño ha sido eliminado con exito";
			} else {
				msg = "Ha ocurrido algo cuando se intentaba eliminar la mascota";
			}
		}
		return msg;
	}

	// Metodo para ordenar los dueños por medio del ID

	public String ordenamientoBurbujaOwnerID() {
		String msg = "";
		msg = "                                        Datos ordenados por ID                              \n";
		msg += "     ID DUEÑO     " + "     NOMBRE DUEÑO     " + "     FECHA NACIMIENTO OWNER     "
				+ "     TIPO DE MASCOTA FAVORITO     " + "\n";
		for (int i = 0; i < clubs.size(); i++) {
			msg += clubs.get(i).ordenamientoBurbujaOwnerID();
		}
		return msg;
	}

	// Metodo para ordenar los dueños por medio de su nombre utilizando la interfaz
	// Comparable

	public String ordenamientoCTOwnerName() {
		String msg = "";
		msg = "                                        Datos ordenados por nombre                           \n";
		msg += "    NOMBRE DUEÑO     " + "     ID DUEÑO    " + "     FECHA NACIMIENTO     "
				+ "     TIPO DE MASCOTA FAVORITO     " + "\n";
		for (int i = 0; i < clubs.size(); i++) {
			msg += clubs.get(i).mostrarDatosReporteDuenosNombre();
		}
		return msg;
	}

	// Metodo para ordenar los dueños segun su fecha de nacimiento con el metodo de
	// insercion

	public String ordenamientoInsercionOwnerBornDate() {
		String msg = "";
		msg = "                                        Datos ordenados por fecha de nacimiento                           \n";
		msg += "    FECHA NACIMIENTO     " + "     ID DUEÑO    " + "     NOMBRE DUEÑO     "
				+ "     TIPO DE MASCOTA FAVORITO     " + "\n";
		for (int i = 0; i < clubs.size(); i++) {
			msg += clubs.get(i).ordenamientoInsercionBornOwner();
		}
		return msg;
	}

	// Metodo para ordenar los dueños por el tipo de mascota utilizando la interfaz
	// Comparator

	public String ordenamientoBurbujaCTypePetOwner() {
		String msg = "";
		msg = "                                        Datos ordenados por tipo de mascota favorita                           \n";
		msg += "    TIPO DE MASCOTA FAVORITA     " + "     ID DUEÑO    " + "     NOMBRE DUEÑO     "
				+ "     FECHA NACIMIENTO     " + "\n";
		for (int i = 0; i < clubs.size(); i++) {
			msg += clubs.get(i).ordenamientoInsercionBornOwner();
		}
		return msg;
	}

	// Metodo para ordenar los clubs por medio del ID utilizando el metodo de
	// burbuja

	public String ordenamientoBurbujaIdClub() {
		String msg = "";
		int tamanio = clubs.size();
		Club[] clubsArreglo = new Club[tamanio];
		// for (int i = 0; i < clubsArreglo.length; i++) {
		for (int j = 0; j < clubs.size(); j++) {
			clubsArreglo[j] = clubs.get(j);
		}

		for (int i = clubsArreglo.length; i > 0; i--) {
			for (int j = 0; j < i - 1; j++) {
				// Si es menor que 0, el primer String es menor que el segundo. Si es mayor que
				// 0, el primer String es mayor que el segundo
				if (clubsArreglo[j].getIdClub().compareTo(clubsArreglo[j + 1].getIdClub()) > 0) {
					Club temp = clubsArreglo[j];
					clubsArreglo[j] = clubsArreglo[j + 1];
					clubsArreglo[j + 1] = temp;
				}
			}
		}

		msg = "                                        Datos ordenados por ID                              \n";
		msg += "     ID DUEÑO     " + "     NOMBRE DUEÑO     " + "     FECHA DE CREACION     "
				+ "     TIPO DE MASCOTA FAVORITO     " + "\n";

		for (int i = 0; i < clubsArreglo.length; i++) {
			msg += "     " + clubsArreglo[i].getIdClub() + "     " + "     " + clubsArreglo[i].getClubName() + "     "
					+ "     " + clubsArreglo[i].getDateCreation() + "     " + "     " + clubsArreglo[i].getpetTypeClub()
					+ "     " + "\n";
		}

		return msg;
	}

	// Metodo para ordenar los clubs por medio del nombre utilizando la interfaz
	// Comparable

	public String ordenamientoCTNombreClubs() {
		String msg = "";
		msg = "                                        Datos ordenados por nombre                           \n";
		msg += "    NOMBRE DUEÑO     " + "     ID DUEÑO    " + "     FECHA CREACION     "
				+ "     TIPO DE MASCOTA FAVORITO     " + "\n";
		Collections.sort(clubs);
		for (int i = 0; i < clubs.size(); i++) {
			msg += "     " + clubs.get(i).getClubName() + "     " + "     " + clubs.get(i).getIdClub() + "     "
					+ "     " + clubs.get(i).getDateCreation() + "     " + "     " + clubs.get(i).getpetTypeClub()
					+ "     " + "\n";
		}
		return msg;
	}

	// Metodo para ordenar los clubs por medio de la fecha de creacion utilizando el
	// metodo incersion

	public String ordenamientoIncersionDateClub() {
		String msg = "";
		int tamanio = clubs.size();
		Club[] clubsArreglo = new Club[tamanio];
		msg = "                                        Datos ordenados por fecha de creacion                           \n";
		msg += "    FECHA NACIMIENTO     " + "     ID DUEÑO    " + "     NOMBRE DUEÑO     "
				+ "     FECHA NACIMIENTO     " + "     TIPO DE MASCOTA FAVORITO     " + "\n";
		for (int i = 0; i < clubs.size(); i++) {
			for (int j = 0; j < clubsArreglo.length; j++) {
				clubsArreglo[j] = clubs.get(i);
			}
		}

		for (int i = 1; i < clubsArreglo.length; i++) {
			for (int j = i; j > 0
					&& clubsArreglo[j - 1].getDateCreation().after(clubsArreglo[j].getDateCreation()); j--) {
				Club temp = clubsArreglo[j];
				clubsArreglo[j] = clubsArreglo[j - 1];
				clubsArreglo[j - 1] = temp;
			}
		}

		for (int i = 0; i < clubsArreglo.length; i++) {
			msg += "     " + clubsArreglo[i].getDateCreation() + "     " + clubsArreglo[i].getIdClub() + "     "
					+ "     " + clubsArreglo[i].getClubName() + "     " + "     " + clubsArreglo[i].getpetTypeClub()
					+ "     " + "\n";
		}

		return msg;
	}

	// Metodo para ordenar los clubs por medio del tipo de mascota

	public String ordenamientoCTypePetClub() {
		String msg = "";
		int tamanio = clubs.size();
		Club[] clubsArreglo = new Club[tamanio];
		msg = "                                        Datos ordenados por tipo de mascota favorita                           \n";
		msg += "    TIPO DE MASCOTA FAVORITA     " + "       ID DUEÑO      " + "     NOMBRE DUEÑO     "
				+ "     FECHA NACIMIENTO     " + "\n";
		for (int i = 0; i < clubs.size(); i++) {
			clubsArreglo[i] = clubs.get(i);
		}

		for (int i = 0; i < clubsArreglo.length - 1; i++) {
			Club menor = clubsArreglo[i];
			int cual = i;
			for (int j = i + 1; j < clubsArreglo.length; j++) {
				// Si es menor que 0, el primer String es menor que el segundo. Si es mayor que
				// 0, el primer String es mayor que el segundo
				if (clubsArreglo[i].compare(clubsArreglo[j], clubsArreglo[i]) < 0) {
					menor = clubsArreglo[j];
					cual = j;
				}
			}
			Club temp = clubsArreglo[i];
			clubsArreglo[i] = menor;
			clubsArreglo[cual] = temp;
		}

		for (int i = 0; i < clubsArreglo.length; i++) {
			msg += "     " + clubsArreglo[i].getpetTypeClub() + "     " + "        " + clubsArreglo[i].getIdClub()
					+ "        " + "     " + clubsArreglo[i].getClubName() + "     " + "     "
					+ clubsArreglo[i].getDateCreation() + "     " + "\n";
		}

		return msg;

	}

	// Metodo para ordenar las mascotas por medio del ID utilizando el metodo de
	// burbuja

	public String ordenamientoBurbujaPetId() {
		String msg = "";
		msg = "                                        Datos ordenados por ID                              \n";
		msg += "     ID MASCOTA     " + "     NOMBRE MASCOTA     " + "     FECHA NACIMIENTO MASCOTA     "
				+ "     GENERO MASCOTA     " + "     TIPO MASCOTA     " + "\n";
		for (int i = 0; i < clubs.size(); i++) {
			msg += clubs.get(i).ordenamientoBurbujaIdPet();
		}
		return msg;
	}

	// Metodo para ordenar las mascotas por el ID

	public String ordenamientoCTnombrePet() {
		String msg = "";
		msg = "                                        Datos ordenados por ID                              \n";
		msg += "     NOMBRE MASCOTA     " + "     ID MASCOTA     " + "     FECHA NACIMIENTO MASCOTA     "
				+ "     GENERO MASCOTA     " + "     TIPO MASCOTA     " + "\n";
		for (int i = 0; i < clubs.size(); i++) {
			msg += clubs.get(i).ordenamientoCTnombrePet();
		}
		return msg;
	}

	// Metodo para ordenar las mascotas por la fecha de nacimiento utilizando el
	// metodo insercion

	public String ordenamientoInsercionPetDate() {
		String msg = "";
		msg = "                                        Datos ordenados por fecha de nacimiento                           \n";
		msg += "    FECHA NACIMIENTO     " + "     ID MASCOTA    " + "     NOMBRE MASCOTA     "
				+ "     GENERO MASCOTA     " + "     TIPO DE MASCOTA     " + "\n";
		for (int i = 0; i < clubs.size(); i++) {
			msg += clubs.get(i).ordenamientoInsercionDatePet();
		}
		return msg;
	}

	// Metodo para ordenar las mascotas por la fecha de nacimiento utilizando el
	// Comparator

	public String ordenamientoCCPetTypePet() {
		String msg = "";
		msg = "                                        Datos ordenados por fecha de nacimiento                           \n";
		msg += "    TIPO DE MASCOTA     " + "     ID MASCOTA    " + "     NOMBRE MASCOTA     "
				+ "     FECHA NACIMIENTO     " + "     GENERO MASCOTA     " + "\n";
		for (int i = 0; i < clubs.size(); i++) {
			msg += clubs.get(i).ordenamientoInsercionDatePet();
		}
		return msg;
	}

	// Metodo que se encarga de cargar todos los datos generados

	public void cargarTodosLosDatosGenerados() {
		cargarDatosClubGenerados();
		cargarDatosPetGenerados();
		cargarDatosOwnerGenerados();
		guardarTodaLaInformacionClubs();
	}

	// Metodo que se encarga de decir cuantos dueños tiene un club

	public void cantidadDuenosClub() {
		for (int i = 0; i < clubs.size(); i++) {
			int cantidadDuenos = clubs.get(i).getClubOwners().size();
			clubs.get(i).setCantidadDuenos(cantidadDuenos);
		}
	}

	// Metodo que se encarga de ordenar los clubs por cantidad de due

	public String ordenamientoPorCantidadDuenos() {
		String msg = "";
		int tamanio = clubs.size();
		Club[] clubsArreglo = new Club[tamanio];
		// for (int i = 0; i < clubsArreglo.length; i++) {
		for (int j = 0; j < clubs.size(); j++) {
			clubsArreglo[j] = clubs.get(j);
		}

		
		for(int i = 0; i < clubsArreglo.length - 1; i++) {
			Club menor = clubsArreglo[i];
			int cual = i;
			for(int j = i + 1; j < clubsArreglo.length; j++) {
				if(clubsArreglo[j].getCantidadDuenos() < menor.getCantidadDuenos()) {
					menor = clubsArreglo[j];
					cual = j;
				}
			}
			Club temp = clubsArreglo[i];
			clubsArreglo[i] = menor;
			clubsArreglo [cual] = temp;

		}
//		for (int i = clubsArreglo.length; i > 0; i--) {
//			for (int j = 0; j < i - 1; j++) {
//				// Si es menor que 0, el primer String es menor que el segundo. Si es mayor que
//				// 0, el primer String es mayor que el segundo
//				if (clubsArreglo[j].getCantidadDuenos() > clubsArreglo[i].getCantidadDuenos()) {
//					Club temp = clubsArreglo[j];
//					clubsArreglo[j] = clubsArreglo[j + 1];
//					clubsArreglo[j + 1] = temp;
//				}
//			}
//		}

		msg = "                                        Datos ordenados por cantidad de dueños                              \n";
		msg += "     CANTIDAD DE DUEÑOS     " + "     ID CLUB     " + "     NOMBRE CLUB     "
				+ "     FECHA CREACION CLUB     " + "     TIPO DE MASCOTA FAVORITO     " + "\n";

		for (int i = 0; i < clubsArreglo.length; i++) {
			msg += "     " + clubsArreglo[i].getCantidadDuenos() + "     " + "        " + clubsArreglo[i].getIdClub()
					+ "        " + "     " + clubsArreglo[i].getClubName() + "     " + "     "
					+ clubsArreglo[i].getDateCreation() + "     " + "     " + clubsArreglo[i].getpetTypeClub() + "     "
					+ "\n";
		}

		return msg;
	}
	
	//Metodo para deserializar las mascotas y los dueños

		public void deserializar() {
			try {
				ArrayList<Owner> owners;
				String msg = "";
				String nombreArchivo = ClubManager.RUTA_ALMACENAMIENTO + ClubManager.SP + "SerializacionDatosOwner.txt";
				ObjectInputStream ois = new ObjectInputStream(new FileInputStream(nombreArchivo));

				owners =  (ArrayList<Owner>) ois.readObject();
				for(int i = 0; i < clubs.size(); i++) {
					for(int j = 0; j < owners.size(); j++) {
						clubs.get(i).agregarDueno(owners.get(j));
					}
				}
				
				ois.close();

			} catch (IOException e) {
				e.printStackTrace();
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
		}

}// cierra la clase
