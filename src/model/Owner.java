package model;

import java.io.*;
import java.text.*;
import java.util.*;

public class Owner implements Serializable {
	
	//ATRIBUTOS
	
	private String idOwner;
	private String nameOwner;
	private Date bornDateOwner;
	private String petTypeOwner;
	private int numeroDeMascotas;
	
	//RELACIONES
	
	private ArrayList<Pet> pets;
	
	//CONSTRUCTOR
	
	public Owner(String idOwner, String nameOwner, Date bornDateOwner, String petTypeOwner) {
		this.idOwner = idOwner;
		this.nameOwner = nameOwner;
		this.bornDateOwner = bornDateOwner;
		this.petTypeOwner = petTypeOwner;
		pets = new ArrayList<Pet>();
		numeroDeMascotas = cantidadMascotas();
		
//		try {
//			String msg = "";
//			String nombreArchivo = Investor.RUTA_DATOS + Investor.SP + "SerializacionDatosPet.txt";
//			ObjectInputStream ois = new ObjectInputStream (new FileInputStream (nombreArchivo));
//			
//			pets = (ArrayList) ois.readObject();
//			ois.close();
//			
//		} catch(IOException e) {
//			e.printStackTrace();
//		} catch (ClassNotFoundException e) {
//			e.printStackTrace();
//		}
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
	
	public int getNumeroDeMascotas() {
		return numeroDeMascotas;
	}

	public void setNumeroDeMascotas(int numeroDeMascotas) {
		this.numeroDeMascotas = numeroDeMascotas;
	}

	//METODO TOSTRING

	@Override
	public String toString() {
		return "Owner id " + idOwner + ", name owner " + nameOwner + ", born date " + bornDateOwner
				+ ", favorite type of pet " + petTypeOwner;
	}	
	
	
	//Metodo para verificar que las mascotas de un dueño no tengan el mismo nombre
	
	public boolean verificarNombreMascotas(Pet pet) {
		boolean nombresIguales = false;
		for (int i = 0; i < pets.size(); i++) {
			if(pets.get(i).getPetName().equals(pet.getPetName())) {
				nombresIguales = true;
			}
		}
		return nombresIguales;
	}
	
	
	//Metodo para agregar mascotas
	
		public void agregarPet (Pet pet) {
			pets.add(pet);
		}
		
	//Metodo para saber cuantas mascotas tiene un dueño
		
		public int cantidadMascotas () {
			int numeroMascotas = 0;
			for(int i = 0; i < pets.size(); i++) {
				numeroMascotas = pets.size();
			}
			return numeroDeMascotas;
		}
		
		//
		public void serializarPet(Pet pet) {
			try {
				String msg = "";
				String nombreArchivo = Investor.RUTA_DATOS + Investor.SP + "SerializacionDatosPet.txt";
				ObjectOutputStream oos = new ObjectOutputStream (new FileOutputStream(nombreArchivo));
				
				oos.writeObject(pet);
				oos.close();
				
			}catch (IOException e) {
				System.err.printf("\nExcepcion: %s\n", e);
				System.out.println("No se ha podido guardar los datos");
			}
		}
		
		public String borrar(){
			String msg = "";
			for(int i = 0; i < pets.size(); i++) {
				msg += pets.get(i).getPetName() + "\n";
			}
			return msg;
		}
		
			
}//Cierra la clase


