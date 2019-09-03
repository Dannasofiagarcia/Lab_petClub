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

public class Owner {
	
	//ATRIBUTOS
	
	private String idOwner;
	private String nameOwner;
	private Date bornDateOwner;
	private String petTypeOwner;
	
	//RELACIONES
	
	private ArrayList<Pet> pets;
	
	//CONSTRUCTOR
	
	public Owner(String idOwner, String nameOwner, Date bornDateOwner, String petTypeOwner) {
		this.idOwner = idOwner;
		this.nameOwner = nameOwner;
		this.bornDateOwner = bornDateOwner;
		this.petTypeOwner = petTypeOwner;
		pets = new ArrayList<Pet>();
	}
	
	//METODOS GET Y SET

	public String getIdOwner() {
		return idOwner;
	}

	public void setIdOwner(String idOwner) {
		this.idOwner = idOwner;
	}

	public String getNameOwner() {
		return nameOwner;
	}

	public void setNameOwner(String nameOwner) {
		this.nameOwner = nameOwner;
	}

	public Date getBornDateOwner() {
		return bornDateOwner;
	}

	public void setBornDateOwner(Date bornDateOwner) {
		this.bornDateOwner = bornDateOwner;
	}

	public String getPetTypeOwner() {
		return petTypeOwner;
	}

	public void setPetTypeOwner(String petTypeOwner) {
		this.petTypeOwner = petTypeOwner;
	}
	
	public ArrayList<Pet> getPets() {
		return pets;
	}

	public void setPets(ArrayList<Pet> pets) {
		this.pets = pets;
	}
	
	//METODO TOSTRING

	@Override
	public String toString() {
		return "Owner id " + idOwner + ", name owner " + nameOwner + ", born date " + bornDateOwner
				+ ", favorite type of pet " + petTypeOwner;
	}	
	
	
	//Metodo para serializar los datos de las mascotas
	
	private void serializarDatosPet() throws FileNotFoundException, IOException, ParseException{
		
		int contador = 0;
		String nombreArchivo = "MOCK_DATA" + " (" + contador + ")";
		File archivo = new File(Club.RUTA_DATOS_PET, nombreArchivo);
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
						int cuartaComa = despuesTerceraComa.indexOf(",");
						
						if(cuartaComa != -1) {
							String despuesCuartaComa = despuesTerceraComa.substring(cuartaComa + 1);
						
							String petId = datos.substring(0, primeraComa);
							String petName = datos.substring(primeraComa, segundaComa);
							String bornDateP = datos.substring(segundaComa, terceraComa);
							String petGender = datos.substring(terceraComa, cuartaComa);
							String petType = datos.substring(cuartaComa);
							
					
							DateFormat formato = new SimpleDateFormat ("yyyy/MM/dd");
							Date bornDate = formato.parse(bornDateP);
							Pet pet = new Pet (petId, petName, bornDate, petGender, petType);
							contador++;
					}
				}
			}
		}
		lector.close();
	}
}
	
}


