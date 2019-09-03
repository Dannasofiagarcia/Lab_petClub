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

	//METODO TOSTRING
	
	@Override
	public String toString() {
		return "Club id " + idClub + ", club name " + clubName + ", date of creation " + dateCreation + ", favorite pet type "
				+ petTypeClub;
	}
	
	
	//METODOS
	
	//Metodo para serializar los datos del club
	
	private void serializarDatosClub() throws FileNotFoundException, IOException, ParseException{
		
		int contador = 0;
		String nombreArchivo = "DATOSCLUB";
		File archivo = new File(RAIZ, nombreArchivo);
		BufferedReader lector = new BufferedReader(new FileReader(archivo));
		
		try {
			//lee la primera linea
			lector.readLine();
		}
		catch(IOException ioException) {
			System.err.printf("\nExcepcion: %s\n", ioException);
			System.out.println("Debe aber por lo menos un dato");
		}
		
		String datos = null;
		
		try {
			//lee la segunda linea
			datos = lector.readLine();
		}
		catch(IOException ioException) {
			System.err.printf("\nExcepcion: %s\n", ioException);
			System.out.println("Debe haber por lo menos un dato");
		}
		
		while((datos = lector.readLine()) != null) {
			
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
				
						String idC = datos.substring(0, primeraComa);
						String clubN = datos.substring(primeraComa, segundaComa);
						String dateC = datos.substring(segundaComa, terceraComa);
						String petTC = datos.substring(terceraComa);
					
						DateFormat formato = new SimpleDateFormat ("yyyy/MM/dd");
						Date dateClubs = formato.parse(dateC);
						Club clubNuevo = new Club(idC, clubN, dateClubs, petTC);
						System.out.println(clubNuevo.toString());
					}
				}
			}
		}
		
		lector.close();
	}
	
	//Metodo para serializar los datos de los dueños
	
	private void serializarDatosOwner() throws FileNotFoundException, IOException, ParseException{
		
		int contador = 0;
		String nombreArchivo = "MOCK_DATA" + " (" + contador + ")";
		File archivo = new File(RUTA_DATOS_OWNER, nombreArchivo);
		BufferedReader lector = new BufferedReader(new FileReader(archivo));
		
		try {
			//lee la primera linea
			lector.readLine();
		}
		catch(IOException ioException) {
			System.err.printf("\nExcepcion: %s\n", ioException);
			System.out.println("Debe haber por lo menos un dato");
		}
		
		String datos = null;
		
		try {
			//lee la segunda linea
			datos = lector.readLine();
		}
		catch(IOException ioException) {
			System.err.printf("\nExcepcion: %s\n", ioException);
			System.out.println("Debe haber por lo menos un dato");
		}
		
		while((datos = lector.readLine()) != null) {
			
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
				
						String idO = datos.substring(0, primeraComa);
						String nameO = datos.substring(primeraComa, segundaComa);
						String bornDateO = datos.substring(segundaComa, terceraComa);
						String petTO = datos.substring(terceraComa);
					
						DateFormat formato = new SimpleDateFormat ("yyyy/MM/dd");
						Date bornDate = formato.parse(bornDateO);
						Owner owner = new Owner(idO, nameO, bornDate, petTO);
						addOwners(owner);
						contador++;
					}
				}
			}
		}
		
		lector.close();
	}
	
	//Metodo para agregar los dueños al club
	
	private void addOwners(Owner owner) {
		boolean igual = false;
		for(int i = 0; i < clubOwners.size(); i++) {
			if(clubOwners.size() <10) {
				if(clubOwners.get(i).getIdOwner() == owner.getIdOwner()) {
					igual = true;
				}
			}
		}
		
		if(igual != true) {
			clubOwners.add(owner);
		}
	}
	
	
} //Cierra la clase
