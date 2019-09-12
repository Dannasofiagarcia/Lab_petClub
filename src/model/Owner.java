package model;

import java.io.*;
import java.text.*;
import java.util.*;



public class Owner implements Serializable, Comparable<Owner>, Comparator<Owner> {

	// ATRIBUTOS

	//Burbuja
	private String idOwner;
	
	//Comparable
	private String nameOwner;
	
	//Metodo ordenamiento inserccion
	private Date bornDateOwner;
	
	//Comparator
	private String petTypeOwner;
	
	//Metodo ordenamiento seleccion
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
	
	public String ordenamientoBurbujaOwnerPet() {
		String msg = "";
		int tamanio = pets.size();
		Pet[] petsArreglo = new Pet[tamanio];
		for (int i = 0; i < pets.size(); i++) {
			for (int j = 0; j < petsArreglo.length; j++) {
				petsArreglo[j] = pets.get(i);
			}
		}

		for (int i = 0; i < petsArreglo.length - 1; i++) {
			Pet menor = petsArreglo[i];
			int cual = i;
			for (int j = i + 1; j < petsArreglo.length; j++) {
				// Si es menor que 0, el primer String es menor que el segundo. Si es mayor que
				// 0, el primer String es mayor que el segundo
				if (petsArreglo[j].getPetId().compareToIgnoreCase(menor.getPetId()) < 0) {
					menor = petsArreglo[j];
					cual = j;
				}
			}
			Pet temp = petsArreglo[i];
			petsArreglo[i] = menor;
			petsArreglo[cual] = temp;
		}
		
		for (int i = 0; i < petsArreglo.length; i++) {
			msg += "     " + petsArreglo[i].getPetId() + "     "  + "     "
					+ petsArreglo[i].getPetName() + "     " + "     " + petsArreglo[i].getBornDatePet()
					+ "     " + "     " + petsArreglo[i].getPetGender() + "     " +  "     " + petsArreglo[i].getTypePet() + "     " + "\n";
		}

		return msg;
	}
	
	public String ordenamientoCompareToNombrePet() {
		String msg = "";
		Collections.sort(pets);
		msg += mostrarDatosReporteNombrePet();

		return msg;
	}
	
	public String mostrarDatosReporteNombrePet() {
		String msg = "";
		for (int i = 0; i < pets.size(); i++) {
			msg += "     " + pets.get(i).getPetName() + "     " + "     " + pets.get(i).getPetId()
					+ "     " + "     " + pets.get(i).getBornDatePet() + "     " +  "     " + pets.get(i).getPetGender() + "     " + "     "
					+ pets.get(i).getTypePet() + "     " + "\n";
		}
		return msg;
	}
	
	public String ordenamientoInsercionDatePet() {
		String msg = "";
		int tamanio = pets.size();
		Pet[] petsArreglo = new Pet[tamanio];
		for (int i = 0; i < pets.size(); i++) {
			for (int j = 0; j < petsArreglo.length; j++) {
				petsArreglo[j] = pets.get(i);
			}
		}

		for (int i = 1; i < petsArreglo.length; i++) {
			for (int j = i; j > 0 && petsArreglo[j - 1].getBornDatePet().after(petsArreglo[j].getBornDatePet()); j--) {
				Pet temp = petsArreglo[j];
				petsArreglo[j] = petsArreglo[j - 1];
				petsArreglo[j - 1] = temp;
			}
		}
		
		for (int i = 0; i < petsArreglo.length; i++) {
			msg += "     " + petsArreglo[i].getBornDatePet() + "     " + petsArreglo[i].getPetId() + "     "  + "     " + petsArreglo[i].getPetName()
					+ "     "  + "     " + petsArreglo[i].getPetGender() + "     " + "     " + petsArreglo[i].getTypePet() + "     " + "\n";
		}

		return msg;
	}
	
	public String ordenamientoCPPetTypePet() {
	
	String msg = "";
	int tamanio = pets.size();
	Pet [] petsArreglo = new Pet [tamanio];
	for (int i = 0; i < pets.size(); i++) {
		for (int j = 0; j < petsArreglo.length; j++) {
			petsArreglo[j] = pets.get(i);
		}
	}

	for (int i = 0; i < petsArreglo.length - 1; i++) {
		Pet menor = petsArreglo[i];
		int cual = i;
		for (int j = i + 1; j < petsArreglo.length; j++) {
			// Si es menor que 0, el primer String es menor que el segundo. Si es mayor que
			// 0, el primer String es mayor que el segundo
			if (petsArreglo[i].compare(petsArreglo[j],petsArreglo[i]) < 0) {
				menor = petsArreglo[j];
				cual = j;
			}
		}
		Pet temp = petsArreglo[i];
		petsArreglo[i] = menor;
		petsArreglo[cual] = temp;
	}

	for (int i = 0; i < petsArreglo.length; i++) {
		msg += "     " + petsArreglo[i].getTypePet() + "     "  + "     "
				+ petsArreglo[i].getPetId() + "     " + "     " + petsArreglo[i].getPetName()
				+ "     " + "     " + petsArreglo[i].getBornDatePet() + "     " +  "     " + petsArreglo[i].getPetGender() + "     " + "\n";
	}

	return msg;

}
	
	@Override
	
	public int compareTo(Owner o) {
		return nameOwner.compareTo(o.getNameOwner());
	}
	
	@Override
	
	public int compare(Owner o1, Owner o2) {
		return o1.getPetTypeOwner().compareToIgnoreCase(o2.getPetTypeOwner());
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
