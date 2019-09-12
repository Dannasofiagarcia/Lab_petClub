package model;

import java.io.*;
import java.util.Comparator;
import java.util.Date;

public class Pet implements Serializable, Comparable<Pet>, Comparator<Pet> {
	
	//CONSTANTES
	
	public final static String FEMALE = "Female";
	public final static String MALE = "Male";
	
	//ATRIBUTOS
	
	private String petId;
	private String petName;
	private Date bornDatePet;
	private String petGender;
	private String typePet;
	
	//CONSTRUCTOR
	
	public Pet(String petId, String petName, Date bornDatePet, String petGender, String typePet) {
		this.petId = petId;
		this.petName = petName;
		this.bornDatePet = bornDatePet;
		this.petGender = petGender;
		this.typePet = typePet;
	}

	//METODOS GET Y SET
	
	public String getPetId() {
		return petId;
	}

	public void setPetId(String petId) {
		this.petId = petId;
	}

	public String getPetName() {
		return petName;
	}

	public void setPetName(String petName) {
		this.petName = petName;
	}

	public Date getBornDatePet() {
		return bornDatePet;
	}

	public void setBornDatePet(Date bornDatePet) {
		this.bornDatePet = bornDatePet;
	}

	public String getPetGender() {
		return petGender;
	}

	public void setPetGender(String petGender) {
		this.petGender = petGender;
	}

	public String getTypePet() {
		return typePet;
	}

	public void setTypePet(String typePet) {
		this.typePet = typePet;
	}
	
	//METODO TOSTRING
	
	@Override
	public String toString() {
		return petId + ", " + petName + ", " + petGender + ", " + typePet;
	}

	@Override
	public int compareTo(Pet o) {
		return petName.compareTo(o.getPetName());
	}

	@Override
	public int compare(Pet o1, Pet o2) {
		// TODO Auto-generated method stub
		return 0;
	}
	
}
