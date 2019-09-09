package model;

import java.io.*;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class Investor {

	// CONSTANTES

	public final static String SP = File.separator;
	public final static String RAIZ = "C:" + SP + "Users" + SP + "Danna García" + SP + "Documents" + SP + "petClub" + SP
			+ "data";
	public final static String RUTA_DATOS_CLUB = RAIZ + SP + "Club";
	public final static String RUTA_DATOS_OWNER = RAIZ + SP + "Owner";
	public final static String RUTA_DATOS_PET = RAIZ + SP + "Pet";
	public final static String RUTA_DATOS = RAIZ + SP + "Datos";

	// RELACIONES

	private ArrayList<Club> clubs;

	// CONSTRUCTOR

	public Investor() {
		clubs = new ArrayList<Club>();
		guardarInformacionClubs();

		cargarDatosOwner();
		cargarDatosPets();

	}

	// METODOS

	// Metodos get y set

	public ArrayList<Club> getClubs() {
		return clubs;
	}

	public void setClubs(ArrayList<Club> clubs) {
		this.clubs = clubs;
	}

	// Metodo para serializar los datos del club

	public void cargarDatosClubGenerados() {

		String nombreArchivo = "\\DATOSCLUB.csv";
		String rutaArchivo = RUTA_DATOS_CLUB + nombreArchivo;

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

	// Metodo para serializar los datos de los dueños

	public void cargarDatosOwner() {

		int contador = 1;
		String nombreArchivo = "//MOCK_DATA" + " (" + contador + ").csv";
		try {
			File archivo = new File(RUTA_DATOS_OWNER + nombreArchivo);
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

								DateFormat formato = new SimpleDateFormat("yyyy-MM-dd");
								Date bornDate = formato.parse(bornDateO);
								Owner owner = new Owner(idO, nameO, bornDate, petTO);
								agregarOwner(owner);
							}
						}
					}
				}

				if (datos == null) {
					contador++;
					try {
						nombreArchivo = "//MOCK_DATA" + " (" + contador + ").csv";
						archivo = new File(RUTA_DATOS_OWNER + nombreArchivo);
						lector = new BufferedReader(new FileReader(archivo));
						lector.readLine();
					} catch (FileNotFoundException fileNotFoundE) {
						archivo = null;
					}
				}

			} while (archivo != null);

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

	public void cargarDatosPets() {

		int contador = 1;
		String nombreArchivo = "//MOCK_DATA" + " (" + contador + ").csv";

		try {
			File archivo = new File(Investor.RUTA_DATOS_PET + nombreArchivo);
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

									DateFormat formato = new SimpleDateFormat("yyyy-MM-dd");
									Date bornDate = formato.parse(bornDateP);
									Pet pet = new Pet(petId, petName, bornDate, petGender, petType);
									addPets(pet);
								}
							}
						}
					}
				}

				if (datos == null) {
					contador++;
					try {
						nombreArchivo = "//MOCK_DATA" + " (" + contador + ").csv";
						archivo = new File(Investor.RUTA_DATOS_PET + nombreArchivo);
						lector = new BufferedReader(new FileReader(archivo));
						lector.readLine();
					} catch (FileNotFoundException fileNotFoundE) {
						archivo = null;
					}
				}

			} while (archivo != null);

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

	public void agregarOwner(Owner owner) {
		boolean agregado = false;
		for (int i = 0; i < clubs.size() && !agregado; i++) {
			if (clubs.get(i).verificarId(owner) == false) {
				clubs.get(i).agregarDueno(owner);
				agregado = true;

			}
		}
	}

	public void agregarOwnerClubE(Owner owner, Club club) {
		boolean agregado = false;
		for (int i = 0; i < clubs.size() && !agregado; i++) {
			if (clubs.get(i).getIdClub().equals(club.getIdClub())) {
				if (clubs.get(i).verificarId(owner) == false) {
					clubs.get(i).agregarDueno(owner);
					agregado = true;

				}
			}
		}
	}
	// Metodo para agregar los clubs

	public void addClub(Club club) {
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
		}
	}

	// Metodo para agregar un dueño a un club teniendo el nombre del club
	public void agregarOwnerByName(Owner owner, String name) {
		boolean agregado = false;
		for (int i = 0; i < clubs.size() && !agregado; i++) {
			if (clubs.get(i).getClubName().equals(name)) {
				Club club = clubs.get(i);
				club.agregarDueno(owner);
				agregado = true;
			}
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

	// Metodo para agregar un dueño a un club teniendo el nombre del club
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

	public void agregarPetByOwner(String name, Pet pet) {
		boolean agregado = false;
		for (int i = 0; i < clubs.size() && !agregado; i++) {
			if (clubs.get(i).searchOwnerByName(name) == true) {
				Club club = clubs.get(i);
				club.agregarPetToOwner(name, pet);
			}
		}
	}

	// Metodo para guardar la informacion de los clubes

	public void guardarInformacionClubs() {
		String msg = "";
		String nombreArchivo = Investor.SP + "InformacionClub.txt";
		String rutaArchivo = Investor.RUTA_DATOS + nombreArchivo;
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

	public String nombreClubsDisponibles() {
		String msg = "";
		for (int i = 0; i < clubs.size(); i++) {
			msg += (i + 1) + ". " + clubs.get(i).getClubName() + "\n";
		}
		return msg;
	}

	public String nombreDuenos() {
		String msg = "";
		for (int i = 0; i < clubs.size(); i++) {
			msg += (i + 1) + ". " + clubs.get(i).mostrarNombreDuenos();
		}
		return msg;
	}
	
	public void cargarDatos() {
		
		String nombreArchivo = "\\DATOSCLUB.csv";
		String rutaArchivo = RUTA_DATOS_CLUB + nombreArchivo;

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

}// cierra la clase
