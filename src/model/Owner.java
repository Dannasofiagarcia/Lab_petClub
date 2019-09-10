package model;

import java.io.*;
import java.text.*;
import java.util.*;

public class Owner implements Serializable {

	// ATRIBUTOS

	private String idOwner;
	private String nameOwner;
	private Date bornDateOwner;
	private String petTypeOwner;
	private int numeroDeMascotas;

	// RELACIONES

	private ArrayList<Pet> pets;

	// CONSTRUCTOR

	public Owner(String idOwner, String nameOwner, Date bornDateOwner, String petTypeOwner) {
		this.idOwner = idOwner;
		this.nameOwner = nameOwner;
		this.bornDateOwner = bornDateOwner;
		this.petTypeOwner = petTypeOwner;
		pets = new ArrayList<Pet>();
		numeroDeMascotas = cantidadMascotas();
		// cargar();
	}

	// METODOS GET Y SET

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

	// METODO TOSTRING

	@Override
	public String toString() {
		return idOwner + ", " + nameOwner + ", " + bornDateOwner + ", " + petTypeOwner;
	}

	// Metodo para verificar que las mascotas de un dueño no tengan el mismo nombre

	public boolean verificarNombreMascotas(Pet pet) {
		boolean nombresIguales = false;
		for (int i = 0; i < pets.size(); i++) {
			if (pets.get(i).getPetName().equals(pet.getPetName())) {
				nombresIguales = true;
			}
		}
		return nombresIguales;
	}

	// Metodo para agregar mascotas

	public void agregarPet(Pet pet) {
		pets.add(pet);
	}

	// Metodo para saber cuantas mascotas tiene un dueño

	public int cantidadMascotas() {
		int numeroMascotas = 0;
		for (int i = 0; i < pets.size(); i++) {
			numeroMascotas = pets.size();
		}
		return numeroDeMascotas;
	}

	public boolean arregloPetsVacio() {
		boolean vacio = false;
		if (pets == null | pets.size() == 0) {
			vacio = true;
		}
		return vacio;
	}

	// Metodo para serializar las mascotas

	public void serializarPet(Pet pet) {
		try {
			String msg = "";
			String nombreArchivo = ClubManager.RUTA_DATOS + ClubManager.SP + "SerializacionDatosPet.txt";
			ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(nombreArchivo));

			oos.writeObject(pet);
			oos.close();

		} catch (IOException e) {
			System.err.printf("\nExcepcion: %s\n", e);
			System.out.println("No se ha podido guardar los datos");
		}
	}

	public boolean eliminarMascotaId(String id) {
		boolean eliminado = false;
		for (int i = 0; i < pets.size(); i++) {
			if (pets.get(i).getPetId().equals(id)) {
				pets.remove(i);
				eliminado = true;
			}
		}
		return eliminado;
	}

	public boolean eliminarMascotaNombre(String nombre) {
		boolean eliminado = false;
		for (int i = 0; i < pets.size(); i++) {
			if (pets.get(i).getPetName().equals(nombre)) {
				pets.remove(i);
				eliminado = true;
			}
		}
		return eliminado;
	}

//	public void cargar() {
//		String nombreArchivo = ClubManager.RUTA_DATOS + ClubManager.SP + "SerializacionDatosPet.txt";
//		File file = new File(nombreArchivo);
//		if (pets == null | pets.size() == 0) {
//			if (file.exists()) {
//				deserializarPet();
//			} else {
//				cargarDatosPetGenerados();
//			}
//		}
//	}

}// Cierra la clase
