package model;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class Investor {
	
	//RELACIONES
	
	private ArrayList<Club> clubs;
	
	//CONSTRUCTOR
	
	public Investor () {
		clubs = new ArrayList<Club>();
		
		try {
			serializarDatosOwner();
		} catch (IOException | ParseException e1) {
			e1.printStackTrace();
		}
		
		
		try {
			serializarDatosClub();
		} catch (IOException | ParseException e) {
			e.printStackTrace();
		}
	}
	
	//METODOS
	
	//Metodos get y set
	
	public ArrayList<Club> getClubs() {
		return clubs;
	}

	public void setClubs(ArrayList<Club> clubs) {
		this.clubs = clubs;
	}
	

	//Metodo para serializar los datos del club
	
		public String serializarDatosClub() throws FileNotFoundException, IOException, ParseException{
	
			String nombreArchivo = "\\DATOSCLUB.csv";
			String rutaArchivo = Club.RAIZ + nombreArchivo;
			File archivo = new File(rutaArchivo);
			BufferedReader lector = new BufferedReader(new FileReader(archivo));
			String msg = "";
			
			try {
				//lee la primera linea
				lector.readLine();
			}
			catch(IOException ioException) {
				System.err.printf("\nExcepcion: %s\n", ioException);
				System.out.println("Debe haber por lo menos un dato");
			}
			
			String datos = "";
			
			do {
			
				try {
					//lee la segunda linea
					datos = lector.readLine();
				}
				catch(IOException ioException) {
					System.err.printf("\nExcepcion: %s\n", ioException);
					System.out.println("Debe haber por lo menos un dato");
				}
				
				if(datos != null) {
				
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
							String clubN = despuesPrimeraComa.substring(0, segundaComa);
							String dateC = despuesSegundaComa.substring(0, terceraComa);
							String petTC = despuesTerceraComa.substring(0);
						
							DateFormat formato = new SimpleDateFormat ("yyyy-MM-dd");
							Date dateClubs = formato.parse(dateC);
							Club clubNuevo = new Club(idC, clubN, dateClubs, petTC);
							addClub(clubNuevo);
						}
					}
				}
			}
			} while((datos = lector.readLine()) != null);
			
			lector.close();
			
			return msg;
		}
		
		//Metodo para serializar los datos de los dueños
		
		public void serializarDatosOwner() throws FileNotFoundException, IOException, ParseException{
				
			//do {
				int contador = 1;
				String nombreArchivo = "//MOCK_DATA" + " (" + contador + ").csv";
				File archivo = new File(Club.RUTA_DATOS_OWNER + nombreArchivo);
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
				
								String idO = datos.substring(0, primeraComa);
								String nameO = despuesPrimeraComa.substring(0, segundaComa);
								String bornDateO = despuesSegundaComa.substring(0, terceraComa);
								String petTO = despuesTerceraComa.substring(terceraComa);
					
								DateFormat formato = new SimpleDateFormat ("yyyy-MM-dd");
								Date bornDate = formato.parse(bornDateO);
								Owner owner = new Owner(idO, nameO, bornDate, petTO);
								agregarOwner(owner);
							}
						}
					} 
				}
				
				if(datos == null) {
					contador++;
					try {	
						nombreArchivo = "//MOCK_DATA" + " (" + contador + ").csv";
						archivo = new File(Club.RUTA_DATOS_OWNER + nombreArchivo);
						lector = new BufferedReader(new FileReader(archivo));	
					} catch (FileNotFoundException fileNotFoundE) {
						archivo = null;
					}
				}
				
			} while(archivo != null);
			
			
			lector.close();
		}
		
	//Metodo para agregar dueños a los clubs
		
	public void agregarOwner(Owner owner) {
		boolean agregado = false;
		for(int i = 0; i < clubs.size() && !agregado; i++) {
			if(clubs.get(i).verificarId(owner) == false) {
				clubs.get(i).agregarDueno(owner);
				agregado = true;
				
			}
		}
	}
	//Metodo para agregar los clubs
		
	public void addClub(Club club) {
		clubs.add(club);
	}
	
	public String mostrarInfo() {
		String msg = "Datos: \n";
		for(int i = 0; i < clubs.size(); i++) {
			msg += clubs.get(i).getClubName();
		}
		return msg;
	}
	
	public String mostrarInfoO() {
		String msg = "Datos: \n";
		for(int i = 0; i < clubs.size(); i++) {
			msg += clubs.get(i).mostrarInfoOwner();
		}
		return msg;
	}
	
	
}//cierra la clase
