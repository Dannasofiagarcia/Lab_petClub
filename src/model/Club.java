package model;

import java.io.*;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.text.ParseException;

public class Club implements Comparable<Club>, Comparator<Club>{

	// ATRIBUTOS

	// Identificacion del club
	private String idClub;

	// Nombre del club
	private String clubName;

	// Fecha creacion del club
	private Date dateCreation;

	// Tipo de mascotas
	private String petTypeClub;

	private int cantidadDuenos;
	
	// RELACIONES

	private ArrayList<Owner> clubOwners;

	// CONSTRUCTOR

	public Club(String id, String name, Date dateCreation, String petTypeClub) {

		this.idClub = id;
		this.clubName = name;
		this.dateCreation = dateCreation;
		this.petTypeClub = petTypeClub;
		clubOwners = new ArrayList<Owner>();
		cantidadDuenos = cantidadDuenosClub();
	//	deserializar();

	}

	// METODOS GET Y SET

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
	
	public int getCantidadDuenos() {
		return cantidadDuenos;
	}

	public void setCantidadDuenos(int cantidadDueños) {
		this.cantidadDuenos = cantidadDueños;
	}

	//Metodo toString

	@Override
	public String toString() {
		return idClub + ", " + clubName + ", " + (new SimpleDateFormat("yyyy-MM-dd").format(dateCreation)) + ", "
				+ petTypeClub;
	}

	// METODOS

	// Metodo que verifica que el id de un dueño no sea igual a otro

	public boolean verificarId(Owner owner) {
		boolean existeIdIgual = false;
		for (int i = 0; i < clubOwners.size(); i++) {
			if (clubOwners.get(i).getIdOwner().equals(owner.getIdOwner())) {
				existeIdIgual = true;
			}
		}

		return existeIdIgual;
	}
	
	//Metodo que se encarga de agregar un dueño a un club

	public void agregarDueno(Owner owner) {
		clubOwners.add(owner);
	}


	// Metodo para agregar las mascotas a un dueño

	public void addPet(Pet pet) {
		boolean agregado = false;
		for (int i = 0; i < clubOwners.size() && !agregado; i++) {
			if (clubOwners.get(i).verificarNombreMascotas(pet) == false) {
				clubOwners.get(i).agregarPet(pet);
				agregado = true;
			}
		}
	}

	// Metodo para agregar las mascotas a un dueño

	public void addPetToOwner(Owner owner, Pet pet) {
		if (owner.verificarNombreMascotas(pet) == false) {
			owner.agregarPet(pet);
		}
	}


	// Metodo para buscar un dueño por el nombre

	public boolean searchOwnerByName(String name) {
		boolean ownerPertenece = false;
		for (int i = 0; i < clubOwners.size(); i++) {
			if (clubOwners.get(i).getNameOwner().equals(name)) {
				ownerPertenece = true;
			}
		}
		return ownerPertenece;
	}

	//Metodo para agregar una mascota a un dueño en especifico teniendo unicamente el nombre de ese dueño
	
	public void agregarPetToOwner(String name, Pet pet) {
		boolean agregado = false;
		for (int i = 0; i < clubOwners.size() && !agregado; i++) {
			if (clubOwners.get(i).getNameOwner().equals(name)) {
				Owner owner = clubOwners.get(i);
				owner.agregarPet(pet);
				agregado = true;
			}
		}
	}

	// Metodo para serializar las personas

	public void serializarOwners() {
		try {
			String nombreArchivo = ClubManager.RUTA_ALMACENAMIENTO + ClubManager.SP + "SerializacionDatosOwner.txt";
			ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(nombreArchivo));
			
			oos.writeObject(clubOwners);
			oos.close();

		} catch (IOException e) {
			System.err.printf("\nExcepcion: %s\n", e);
			System.out.println("No se ha podido guardar los datos");
		}
	}
	
	//Metodo para eliminar un dueño por el ID

	public boolean eliminarDuenoId(String id) {
		boolean eliminado = false;
		for (int i = 0; i < clubOwners.size(); i++) {
			if (clubOwners.get(i).getIdOwner().equals(id)) {
				clubOwners.remove(i);
				serializarOwners();
				eliminado = true;
			}
		}
		return eliminado;
	}
	
	//Metodo para eliminar un dueño por el nombre

	public boolean eliminarDuenoNombre(String nombre) {
		boolean eliminado = false;
		for (int i = 0; i < clubOwners.size(); i++) {
			if (clubOwners.get(i).getNameOwner().equals(nombre)) {
				clubOwners.remove(i);
				serializarOwners();
				eliminado = true;
			}
		}
		return eliminado;
	}
	
	//Metodo para eliminar una mascota por el ID

	public boolean eliminarMascotaId(String id) {
		boolean eliminado = false;
		for (int i = 0; i < clubOwners.size(); i++) {
			if (clubOwners.get(i).eliminarMascotaId(id) == true) {
				eliminado = true;
				serializarOwners();
			}
		}
		return eliminado;
	}
	
	//Metodo para eliminar una mascota por el nombre

	public boolean eliminarMascotaNombre(String nombre) {
		boolean eliminado = false;
		for (int i = 0; i < clubOwners.size(); i++) {
			if (clubOwners.get(i).eliminarMascotaNombre(nombre) == true) {
				eliminado = true;
				serializarOwners();
			}
		}
		return eliminado;
	}
	
//	//Metodo para deserializar las mascotas y los dueños
//
//	public void deserializar() {
//		try {
//			ArrayList<Owner> owners;
//			String msg = "";
//			String nombreArchivo = ClubManager.RUTA_ALMACENAMIENTO + ClubManager.SP + "SerializacionDatosOwner.txt";
//			ObjectInputStream ois = new ObjectInputStream(new FileInputStream(nombreArchivo));
//
//			owners =  (ArrayList<Owner>) ois.readObject();
//			setClubOwners(owners);
//			
//			ois.close();
//
//		} catch (IOException e) {
//			e.printStackTrace();
//		} catch (ClassNotFoundException e) {
//			e.printStackTrace();
//		}
//	}
	
	//Metodo para ordenar los dueños por medio del ID utilizando el metodo de burbuja

	public String ordenamientoBurbujaOwnerID() {
		String msg = "";
		int tamanio = clubOwners.size();
		Owner[] ownersArreglo = new Owner[tamanio];
		for (int i = 0; i < clubOwners.size(); i++) {
			ownersArreglo[i] = clubOwners.get(i);
		}

		for (int i = ownersArreglo.length; i > 0; i--) {
			for (int j = 0; j < i-1; j++) {
				// Si es menor que 0, el primer String es menor que el segundo. Si es mayor que
				// 0, el primer String es mayor que el segundo
				if (ownersArreglo[j].getIdOwner().compareTo(ownersArreglo[j + 1].getIdOwner()) > 0) {
					Owner temp = ownersArreglo[j];
					ownersArreglo[j] = ownersArreglo[j + 1];
					ownersArreglo[j + 1] = temp;
				}
			}
		}

		for (int i = 0; i < ownersArreglo.length; i++) {
			msg += "     " + ownersArreglo[i].getIdOwner() + "     " + "     " + ownersArreglo[i].getNameOwner()
					+ "     " + "     " + ownersArreglo[i].getBornDateOwner() + "     " + "     "
					+ ownersArreglo[i].getPetTypeOwner() + "     " + "\n";
		}

		return msg;
	}
	
	//Metodo que muestra los datos del reporte del ordenamiento de los dueños por medio del nombre

	public String mostrarDatosReporteDuenosNombre() {
		String msg = "";
		for (int i = 0; i < clubOwners.size(); i++) {
			msg += "     " + clubOwners.get(i).getNameOwner() + "     " + "     " + clubOwners.get(i).getIdOwner()
					+ "     " + "     " + clubOwners.get(i).getBornDateOwner() + "     " + "     "
					+ clubOwners.get(i).getPetTypeOwner() + "     " + "\n";
		}
		return msg;
	}
	
	//Metodo que ordena los dueños utilizando la interfaz Compare

	public String ordenamientoCompareToNombreOwner() {
		String msg = "";
		Collections.sort(clubOwners);
		msg += mostrarDatosReporteDuenosNombre();

		return msg;
	}
	
	//Metodo que ordena los dueños utilizando el metodo de insercion

	public String ordenamientoInsercionBornOwner() {
		String msg = "";
		int tamanio = clubOwners.size();
		Owner[] ownersArreglo = new Owner[tamanio];
		for (int i = 0; i < clubOwners.size(); i++) {
			for (int j = 0; j < ownersArreglo.length; j++) {
				ownersArreglo[j] = clubOwners.get(i);
			}
		}

		for (int i = 1; i < ownersArreglo.length; i++) {
			for (int j = i; j > 0 && ownersArreglo[j - 1].getBornDateOwner().after(ownersArreglo[j].getBornDateOwner()); j--) {
				Owner temp = ownersArreglo[j];
				ownersArreglo[j] = ownersArreglo[j - 1];
				ownersArreglo[j - 1] = temp;
			}
		}
		
		for (int i = 0; i < ownersArreglo.length; i++) {
			msg += "     " + ownersArreglo[i].getBornDateOwner() + "     " + ownersArreglo[i].getIdOwner() + "     "  + "     " + ownersArreglo[i].getNameOwner()
					+ "     "  + "     "
					+ ownersArreglo[i].getPetTypeOwner() + "     " + "\n";
		}

		return msg;
	}
	
	public String ordenamientoCPetTypeOwner() {
		String msg = "";
		int tamanio = clubOwners.size();
		Owner[] ownersArreglo = new Owner[tamanio];
		for (int i = 0; i < clubOwners.size(); i++) {
			for (int j = 0; j < ownersArreglo.length; j++) {
				ownersArreglo[j] = clubOwners.get(i);
			}
		}

		for (int i = 0; i < ownersArreglo.length - 1; i++) {
			Owner menor = ownersArreglo[i];
			int cual = i;
			for (int j = i + 1; j < ownersArreglo.length; j++) {
				// Si es menor que 0, el primer String es menor que el segundo. Si es mayor que
				// 0, el primer String es mayor que el segundo
				if (ownersArreglo[i].compare(ownersArreglo[j],ownersArreglo[i]) < 0) {
					menor = ownersArreglo[j];
					cual = j;
				}
			}
			Owner temp = ownersArreglo[i];
			ownersArreglo[i] = menor;
			ownersArreglo[cual] = temp;
		}

		for (int i = 0; i < ownersArreglo.length; i++) {
			msg += "     " + ownersArreglo[i].getPetTypeOwner() + "     "  + "     "
					+ ownersArreglo[i].getIdOwner() + "     " + "     " + ownersArreglo[i].getNameOwner()
					+ "     " + "     " + ownersArreglo[i].getBornDateOwner() + "     " + "\n";
		}

		return msg;

	}
	
	public String ordenamientoBurbujaIdPet() {
		String msg = "";
		for(int i = 0; i < clubOwners.size(); i++) {
			msg += clubOwners.get(i).ordenamientoBurbujaOwnerPet();
		}
		return msg;
	}
	
	public String ordenamientoCTnombrePet() {
		String msg = "";
		for(int i = 0; i < clubOwners.size(); i++) {
			msg += clubOwners.get(i).ordenamientoCompareToNombrePet();
		}
		return msg;
	}
	
	public String ordenamientoInsercionDatePet() {
		String msg = "";
		for(int i = 0; i < clubOwners.size(); i++) {
			msg += clubOwners.get(i).ordenamientoInsercionDatePet();
		}
		return msg;
	}
	
	public String ordenamientoCPPetTypePets() {
		String msg = "";
		for(int i = 0; i < clubOwners.size(); i++) {
			msg += clubOwners.get(i).ordenamientoCPPetTypePet();
		}
		return msg;
	}
	
	public int cantidadDuenosClub() {
		int cantidad = 0;
		for(int i = 0; i < clubOwners.size(); i++) {
			cantidad++;
		}
		return cantidad;
	}


	@Override
	public int compareTo(Club o) {
		return clubName.compareTo(o.getClubName());
	}
	
	@Override
	public int compare(Club o1, Club o2) {
		return o1.getpetTypeClub().compareToIgnoreCase(o2.getpetTypeClub());
	}
	
	

	// Metodos para saber cuantas mascotas tiene un dueño

//	public ArrayList<Owner> numeroMascotasOrdenamiento() {
//		
//		for(int i = 0; i < clubOwners.size(); i++) {
//			clubOwners.get(i).cantidadMascotas();
//		}	
//	}
} // Cierra la clase
