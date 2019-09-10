package model;

import java.io.*;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Comparator;
import java.util.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.text.ParseException;

public class Club implements Comparable, Comparator {

	// ATRIBUTOS

	// Identificacion del club
	private String idClub;

	// Nombre del club
	private String clubName;

	// Fecha creacion del club
	private Date dateCreation;

	// Tipo de mascotas
	private String petTypeClub;

	// RELACIONES

	private ArrayList<Owner> clubOwners;

	// CONSTRUCTOR

	public Club(String id, String name, Date dateCreation, String petTypeClub) {

		this.idClub = id;
		this.clubName = name;
		this.dateCreation = dateCreation;
		this.petTypeClub = petTypeClub;
		clubOwners = new ArrayList<Owner>();
		deserializar();

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

	// METODO TOSTRING

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

	public void agregarDueno(Owner owner) {
		clubOwners.add(owner);
	}

	// Metodo mostrar informacion dueños

	public String mostrarInfoOwner() {
		String msg = "";
		for (int i = 0; i < clubOwners.size(); i++) {
			msg += "Nombre: " + clubOwners.get(i).getNameOwner();
		}
		return msg;
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

	// Metodo para mostrar el nombre de los dueños disponibles

	public String mostrarNombreDuenos() {
		String msg = "";
		for (int i = 0; i < clubOwners.size(); i++) {
			msg += clubOwners.get(i).getNameOwner() + "\n";
		}
		return msg;
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

	public boolean arregloOWnersVacio() {
		boolean vacio = false;
		if (clubOwners == null | clubOwners.size() == 0) {
			vacio = true;
		}
		return vacio;
	}

	public boolean arregloPetVacio() {
		boolean vacio = false;
		for (int i = 0; i < clubOwners.size(); i++) {
			if (clubOwners.get(i).arregloPetsVacio() == true) {
				vacio = true;
			}
		}
		return vacio;
	}

	// Metodo para serializar las personas

	public void serializarOwners() {
		try {
			String msg = "";
			String nombreArchivo = ClubManager.RUTA_DATOS + ClubManager.SP + "SerializacionDatosOwner.txt";
			ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(nombreArchivo));

			oos.writeObject(clubOwners);
			oos.close();

		} catch (IOException e) {
			System.err.printf("\nExcepcion: %s\n", e);
			System.out.println("No se ha podido guardar los datos");
		}
	}
	
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
	
	public boolean eliminarMascotaId(String id) {
		boolean eliminado = false;
		for (int i = 0; i < clubOwners.size(); i++) {
			if (clubOwners.get(i).eliminarMascotaId(id) == true){
				eliminado = true;
				serializarOwners();
			}
		}
		return eliminado;
	}
	
	public boolean eliminarMascotaNombre(String nombre) {
		boolean eliminado = false;
		for (int i = 0; i < clubOwners.size(); i++) {
			if (clubOwners.get(i).eliminarMascotaNombre(nombre) == true){
				eliminado = true;
				serializarOwners();
			}
		}
		return eliminado;
	}

	public void deserializar() {
		try {
			String msg = "";
			String nombreArchivo = ClubManager.RUTA_DATOS + ClubManager.SP + "SerializacionDatosOwner.txt";
			ObjectInputStream ois = new ObjectInputStream(new FileInputStream(nombreArchivo));

			clubOwners = (ArrayList) ois.readObject();
			ois.close();

		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	@Override
	public int compareTo(Object arg0) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int compare(Object arg0, Object arg1) {
		// TODO Auto-generated method stub
		return 0;
	}

	// Metodos para saber cuantas mascotas tiene un dueño

//	public ArrayList<Owner> numeroMascotasOrdenamiento() {
//		
//		for(int i = 0; i < clubOwners.size(); i++) {
//			clubOwners.get(i).cantidadMascotas();
//		}	
//	}
} // Cierra la clase
