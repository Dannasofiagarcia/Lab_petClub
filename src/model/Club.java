package model;

import java.io.*;
import java.util.ArrayList;
import java.util.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.text.ParseException;

public class Club {
	
	//CONSTANTES
	
//	public final static String DOG = "Dog";
//	public final static String CAT = "Cat";
//	public final static String MONKEY = "Monkey";
//	public final static String HORSE = "Horse";
//	public final static String RODENT = "Rodent";
//	public final static String PIG = "Pig";
//	public final static String FISH = "Fish";
//	public final static String TURTLE = "Turtle";
//	public final static String FROG = "Frog";
//	public final static String PARROT = "Parrot";
//	public final static String CANARY = "Canary";
//	public final static String HAMSTER = "Hamster";
	
	 public static final String SP = File.separator;
	 public static final String RAIZ = "C:" + SP + "Users" + SP + "Danna García" + SP + "Downloads";
	 public static final String RUTA_DATOS_OWNER = RAIZ + SP + "Owner";
	 public static final String RUTA_DATOS_PET = RAIZ + SP + "Pet";
	
	//ATRIBUTOS
	
	//Identificacion del club
	private String idClub;
	
	//Nombre del club
	private String clubName;
	
	//Fecha creacion del club
	private Date dateCreation;
	 
	//Tipo de mascotas
	private String petTypeClub;
	
	//RELACIONES
	
	private ArrayList <Owner> clubOwners;
	
	//CONSTRUCTOR
	
	public Club(String id, String name, Date dateCreation, String petTypeClub) {

		this.idClub = id;
		this.clubName = name;
		dateCreation = dateCreation;
		this.petTypeClub = petTypeClub;
		clubOwners = new ArrayList<Owner>();
		
		try {
			serializarDatosPets();
		} catch (IOException | ParseException e) {
			e.printStackTrace();
		}
	}
	
	//METODOS GET Y SET
	
	public String getIdClub() {
		return idClub;
	}
	public void setIdClub(String id) {
		this.idClub = idClub;
	}
	public String getClubName() {
		return clubName;
	}
	public void setClubName(String name) {
		this.clubName = clubName;
	}
	public Date getDateCreation() {
		return dateCreation;
	}
	public void setDateCreation(Date dateCreation) {
		this.dateCreation = dateCreation;
	}
	public String getpetTypeClub() {
		return petTypeClub;
	}
	public void setpetTypeClub(String petTypeClub) {
		this.petTypeClub = petTypeClub;
	}

	public ArrayList<Owner> getClubOwners() {
		return clubOwners;
	}

	public void setClubOwners(ArrayList<Owner> clubOwners) {
		this.clubOwners = clubOwners;
	}
	
	//METODO TOSTRING

	@Override
	public String toString() {
		return "Club id " + idClub + ", club name " + clubName + ", date of creation " + dateCreation + ", favorite pet type "
				+ petTypeClub;
	}
	
	//METODOS
	
	//Metodo para serializar los datos de los dueños
	
	public void serializarDatosPets() throws FileNotFoundException, IOException, ParseException{
			
		//do {
			int contador = 1;
			String nombreArchivo = "//MOCKDATA" + " (" + contador + ").csv";
			File archivo = new File(Club.RUTA_DATOS_PET + nombreArchivo);
			BufferedReader lector = new BufferedReader(new FileReader(archivo));
		do {
			try {
				//lee la primera linea
				lector.readLine();
			} catch(IOException ioException) {
				System.err.printf("\nExcepcion: %s\n", ioException);
				System.out.println("Debe haber por lo menos un dato");
			}
		
			String datos = null;
		//do {
			
			try {
				//lee la segunda linea
				datos = lector.readLine();
			}
			catch(IOException ioException) {
				System.err.printf("\nExcepcion: %s\n", ioException);
				System.out.println("Debe haber por lo menos un dato");
			}
			
			if (datos != null) {
				
				//Buscamos la primera coma de la linea
				int primeraComa = datos.indexOf(",");
		
				//Si primeraComa es = -1 quiere decir que no la encontro
				if(primeraComa != -1) {
					//despuesPrimeraComa es el texto que resta despues de encontrar la primera coma
					String despuesPrimeraComa = datos.substring(primeraComa + 1);
					//Buscamos en despuesPrimeraComa la segunda coma de la linea
					int segundaComa = despuesPrimeraComa.indexOf(",");
		
					if(segundaComa != -1) {
						//despuesSegundaComa es el texto que resta despues de encontrar la segunda coma
						String despuesSegundaComa = despuesPrimeraComa.substring(segundaComa + 1);
						//Buscamos en despuesSegundaComa la tercera y ultima coma que deberia tener la linea
						int terceraComa = despuesSegundaComa.indexOf(",");
		
						if(terceraComa != -1) {
							String despuesTerceraComa = despuesSegundaComa.substring(terceraComa + 1);
							int cuartaComa = despuesTerceraComa.indexOf(",");
							
							if(cuartaComa != -1) {
								String despuesCuartaComa = despuesTerceraComa.substring(cuartaComa + 1);
							}
			
							String petId = datos.substring(0, primeraComa);
							String petName = despuesPrimeraComa.substring(0, segundaComa);
							String bornDateP = despuesSegundaComa.substring(0, terceraComa);
							String petGender = despuesTerceraComa.substring(0, terceraComa);
							String petType = despuesTerceraComa.substring(cuartaComa);
				
							DateFormat formato = new SimpleDateFormat ("yyyy-MM-dd");
							Date bornDate = formato.parse(bornDateP);
							Pet pet = new Pet (petId, petName, bornDate, petGender, petType);
							addPet(pet);
						}
					}
				} 
			}
			
			if(datos == null) {
				contador++;
				try {	
					nombreArchivo = "//MOCK_DATA" + " (" + contador + ").csv";
					archivo = new File(Club.RUTA_DATOS_PET + nombreArchivo);
					lector = new BufferedReader(new FileReader(archivo));	
				} catch (FileNotFoundException fileNotFoundE) {
					archivo = null;
				}
			}
			
		} while(archivo != null);
		
		
		lector.close();
	}
	
	
	//Metodo que verifica que el id de un dueño no sea igual a otro
	
	public boolean verificarId(Owner owner) {
		boolean existeIdIgual = false;
		for(int i = 0; i < clubOwners.size(); i++) {
			if(clubOwners.get(i).getIdOwner().equals(owner.getIdOwner())) {
				existeIdIgual = true;
			}
		}
		
		return existeIdIgual;
	}
	
	public void agregarDueno(Owner owner) {
		clubOwners.add(owner);
	}
	
	//Metodo mostrar informacion dueños
	
	public String mostrarInfoOwner() {
		String msg = "";
		for(int i = 0; i < clubOwners.size(); i++) {
			msg += "Nombre: " + clubOwners.get(i).getNameOwner();
		}
		return msg;
	}
	
	//Metodo para agregar las mascotas a un dueño
	
	public void addPet(Pet pet) {
		for(int i = 0; i < clubOwners.size(); i++) {
			if(clubOwners.get(i).verificarNombreMascotas(pet) == false) {
				clubOwners.get(i).agregarPet(pet);
			}
		}
	}
	
} //Cierra la clase
