package model;

import java.io.*;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.text.ParseException;

public class Club {
	
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
		this.dateCreation = dateCreation;
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

	public ArrayList<Owner> getClubOwners() {
		return clubOwners;
	}

	public void setClubOwners(ArrayList<Owner> clubOwners) {
		this.clubOwners = clubOwners;
	}
	
	//METODO TOSTRING

	@Override
	public String toString() {
		return idClub + ", " + clubName + ", " + dateCreation + ", " + petTypeClub;
	}
	
	//METODOS
	
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
		boolean agregado = false;
		for(int i = 0; i < clubOwners.size() && !agregado; i++) {
			if(clubOwners.get(i).verificarNombreMascotas(pet) == false) {
				clubOwners.get(i).agregarPet(pet);
				agregado = true;
			}
		}
	}
	
	
	//Metodo para agregar las mascotas a un dueño
	
		public void addPetToOwner(Owner owner, Pet pet) {
			if(owner.verificarNombreMascotas(pet) == false) {
				owner.agregarPet(pet);
			}
		}  
	
	//Metodo para mostrar el nombre de los dueños disponibles
		
		public String mostrarNombreDuenos() {
			String msg = "";
			for(int i = 0; i < clubOwners.size(); i++) {
				msg += clubOwners.get(i).getNameOwner() + "\n";
			}
			return msg;
		}
		
	//Metodo para buscar un dueño por el nombre
		
		public boolean searchOwnerByName(String name) {
			boolean ownerPertenece = false;
			for(int i = 0; i < clubOwners.size(); i++) {
				if(clubOwners.get(i).getNameOwner().equals(name)) {
					ownerPertenece = true;
				}
			}
			return ownerPertenece;
		}
		
		public void agregarPetToOwner(String name, Pet pet) {
			boolean agregado = false;
			for(int i = 0; i < clubOwners.size() && !agregado; i++) {
				if(clubOwners.get(i).getNameOwner().equals(name)) {
					Owner owner = clubOwners.get(i);
					owner.agregarPet(pet);
					agregado = true;
				}
			}
		}
	

	
	//Metodos para saber cuantas mascotas tiene un dueño

//	public ArrayList<Owner> numeroMascotasOrdenamiento() {
//		
//		for(int i = 0; i < clubOwners.size(); i++) {
//			clubOwners.get(i).cantidadMascotas();
//		}	
//	}
} //Cierra la clase
