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
}//Cierra la clase


