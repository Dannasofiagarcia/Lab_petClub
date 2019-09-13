package petClubPruebas;

import org.junit.Test;
import static org.junit.Assert.*;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;

import java.sql.Date;
import java.util.ArrayList;
import model.*;

public class ClubManagerTests {
	ClubManager clubManager;

	private void setupEscenario1() {
		// Escenario solo con clubs
		clubManager = new ClubManager();
		Club club1 = new Club("1", "Club1", new Date(01 / 01 / 2019), "Ave");
		Club club2 = new Club("2", "Club2", new Date(02 / 02 / 2019), "Buho");
		Club club3 = new Club("3", "Club3", new Date(03 / 03 / 2019), "Caballo");
		clubManager.addClub(club1);
		clubManager.addClub(club2);
		clubManager.addClub(club3);
	}

	private void setupEscenario2() {
		// Escenario solo con dueños
		clubManager = new ClubManager();
		Club club1 = new Club("1", "Club1", new Date(01 / 01 / 2019), "Ave");
		Club club2 = new Club("2", "Club2", new Date(02 / 02 / 2019), "Buho");
		Club club3 = new Club("3", "Club3", new Date(03 / 03 / 2019), "Caballo");
		clubManager.addClub(club1);
		clubManager.addClub(club2);
		clubManager.addClub(club3);

		// Cada club debe tener 5 dueños en este escenario
		Owner owner1 = new Owner("1", "Owner1", new Date(01 / 01 / 2000), "Ave");
		Owner owner2 = new Owner("2", "Owner2", new Date(02 / 02 / 2000), "Buho");
		Owner owner3 = new Owner("3", "Owner3", new Date(03 / 03 / 2000), "Caballo");
		Owner owner4 = new Owner("4", "Owner4", new Date(04 / 04 / 2000), "Delfin");
		Owner owner5 = new Owner("5", "Owner5", new Date(05 / 05 / 2000), "Elefante");
		club1.agregarDueno(owner1);
		club1.agregarDueno(owner2);
		club1.agregarDueno(owner3);
		club1.agregarDueno(owner4);
		club1.agregarDueno(owner5);
	}

	private void setupEscenario3() {
		// Escenario con dueños y mascotas añadidas
		clubManager = new ClubManager();
		Club club1 = new Club("1", "Club1", new Date(01 / 01 / 2019), "Ave");
		Club club2 = new Club("2", "Club2", new Date(02 / 02 / 2019), "Buho");
		Club club3 = new Club("3", "Club3", new Date(03 / 03 / 2019), "Caballo");
		clubManager.addClub(club1);
		clubManager.addClub(club2);
		clubManager.addClub(club3);

		// Cada club debe tener 5 dueños en este escenario
		Owner owner1 = new Owner("1", "Owner1", new Date(01 / 01 / 2000), "Ave");
		Owner owner2 = new Owner("2", "Owner2", new Date(02 / 02 / 2000), "Buho");
		Owner owner3 = new Owner("3", "Owner3", new Date(03 / 03 / 2000), "Caballo");
		Owner owner4 = new Owner("4", "Owner4", new Date(04 / 04 / 2000), "Delfin");
		Owner owner5 = new Owner("5", "Owner5", new Date(05 / 05 / 2000), "Elefante");
		club1.agregarDueno(owner1);
		club1.agregarDueno(owner2);
		club1.agregarDueno(owner3);
		club1.agregarDueno(owner4);
		club1.agregarDueno(owner5);

		Owner owner6 = new Owner("6", "Owner6", new Date(06 / 06 / 2000), "Foca");
		Owner owner7 = new Owner("7", "Owner7", new Date(02 / 02 / 2000), "Gato");
		Owner owner8 = new Owner("8", "Owner8", new Date(03 / 03 / 2000), "Huron");
		Owner owner9 = new Owner("9", "Owner9", new Date(04 / 04 / 2000), "Iguana");
		Owner owner10 = new Owner("10", "Owner10", new Date(01 / 05 / 2000), "Jabali");
		club2.agregarDueno(owner6);
		club2.agregarDueno(owner7);
		club2.agregarDueno(owner8);
		club2.agregarDueno(owner9);
		club2.agregarDueno(owner10);

		Owner owner11 = new Owner("11", "Owner11", new Date(06 / 06 / 2000), "Koala");
		Owner owner12 = new Owner("12", "Owner12", new Date(02 / 02 / 2000), "Leon");
		Owner owner13 = new Owner("13", "Owner13", new Date(03 / 03 / 2000), "Mosca");
		Owner owner14 = new Owner("14", "Owner14", new Date(04 / 04 / 2000), "Nutria");
		Owner owner15 = new Owner("15", "Owner15", new Date(05 / 05 / 2000), "Perro");
		club3.agregarDueno(owner11);
		club3.agregarDueno(owner12);
		club3.agregarDueno(owner13);
		club3.agregarDueno(owner14);
		club3.agregarDueno(owner15);

		Pet pet1 = new Pet("1", "pet1", new Date(01 / 01 / 2010), "Femenio", "Ave");
		Pet pet2 = new Pet("2", "pet2", new Date(02 / 01 / 2010), "Masculino", "Buho");
		Pet pet3 = new Pet("3", "pet3", new Date(03 / 01 / 2010), "Femenino", "Caballo");
		Pet pet4 = new Pet("4", "pet4", new Date(04 / 01 / 2010), "Masculino", "Delfin");
		Pet pet5 = new Pet("5", "pet5", new Date(05 / 01 / 2010), "Femenino", "Elefante");
		Pet pet6 = new Pet("6", "pet6", new Date(06 / 01 / 2010), "Masculino", "Foca");
		Pet pet7 = new Pet("7", "pet7", new Date(07 / 01 / 2010), "Femenino", "Gato");
		Pet pet8 = new Pet("8", "pet8", new Date(01 / 01 / 2010), "Masculino", "Huron");
		Pet pet9 = new Pet("9", "pet9", new Date(02 / 01 / 2010), "Femenino", "Iguana");
		Pet pet10 = new Pet("10", "pet10", new Date(03 / 01 / 2010), "Masculino", "Jabali");
		Pet pet11 = new Pet("11", "pet11", new Date(04 / 01 / 2010), "Femenino", "Koala");
		Pet pet12 = new Pet("12", "pet12", new Date(05 / 01 / 2010), "Masculino", "Leon");
		Pet pet13 = new Pet("13", "pet13", new Date(06 / 01 / 2010), "Femenino", "Mosca");
		Pet pet14 = new Pet("14", "pet14", new Date(01 / 01 / 2010), "Masculino", "Nutria");
		Pet pet15 = new Pet("14", "pet15", new Date(02 / 01 / 2010), "Femenino", "Perro");
		owner1.agregarPet(pet1);
		owner2.agregarPet(pet2);
		owner3.agregarPet(pet3);
		owner4.agregarPet(pet4);
		owner5.agregarPet(pet5);
		owner6.agregarPet(pet6);
		owner7.agregarPet(pet7);
		owner8.agregarPet(pet8);
		owner9.agregarPet(pet9);
		owner10.agregarPet(pet10);
		owner11.agregarPet(pet11);
		owner12.agregarPet(pet12);
		owner13.agregarPet(pet13);
		owner14.agregarPet(pet14);
		owner15.agregarPet(pet15);
	}

	private void setupEscenario4() {
		clubManager = new ClubManager();
		Club club1 = new Club("1", "Club1", new Date(01 / 01 / 2019), "Ave");
		clubManager.addClub(club1);
	}

	private void setupEscenario5() {
		clubManager = new ClubManager();
		Club club1 = new Club("1", "Club1", new Date(01 / 01 / 2019), "Ave");
		clubManager.addClub(club1);

		Owner owner1 = new Owner("1", "Owner1", new Date(01 / 01 / 2000), "Ave");
		clubManager.agregarOwner(owner1);
	}

	private void setupEscenario6() {
		clubManager = new ClubManager();
	}

	private void setupEscenario7() {
		clubManager = new ClubManager();
		Club club1 = new Club("1", "Club1", new Date(01 / 01 / 2019), "Ave");
		clubManager.addClub(club1);

		Owner owner1 = new Owner("1", "Owner1", new Date(01 / 01 / 2000), "Ave");
		clubManager.agregarOwner(owner1);

		Pet pet15 = new Pet("14", "pet15", new Date(02 / 01 / 2010), "Femenino", "Perro");
		owner1.agregarPet(pet15);
	}
	
	private void setupEscenario8() {
		clubManager = new ClubManager();
		clubManager.getClubs().removeAll(clubManager.getClubs());
		Club club1 = new Club("1", "Club1", new Date(01 / 01 / 2019), "Ave");
		Club club2 = new Club("2", "Club2", new Date(01 / 01 / 2019), "Buho");
		Club club3 = new Club("3", "Club3", new Date(01 / 01 / 2019), "Caballo");
		clubManager.addClub(club1);
		clubManager.addClub(club2);
		clubManager.addClub(club3);
	}
	
	private void setupEscenario9() {
		clubManager = new ClubManager();
		Club club1 = new Club("1", "Club1", new Date(01 / 01 / 2019), "Ave");
		clubManager.addClub(club1);

		Owner owner1 = new Owner("1", "Owner1", new Date(01 / 01 / 2000), "Ave");
		clubManager.agregarOwner(owner1);

		Pet pet14 = new Pet("14", "pet14", new Date(02 / 01 / 2010), "Femenino", "A");
		owner1.agregarPet(pet14);
		Pet pet15 = new Pet("15", "pet15", new Date(02 / 01 / 2010), "Femenino", "B");
		owner1.agregarPet(pet15);
	}

	@Test

	public void testCargarDatosClubsGenerados() {
		setupEscenario1();
		Club clubT1 = new Club("1", "PETropolis", new Date(04 / 21 / 1995), "Malagasy groundboa");
		Club clubT2 = new Club("2", "InterCanes", new Date(02 / 24 / 1991), "Barasing hadeer");
		Club clubT3 = new Club("3", "Petlittlepet", new Date(8 / 03 / 1991), "Devil,tasmanian");
		Club clubT4 = new Club("4", "Kninos", new Date(10 / 13 / 1998), "Egret,cattle");

		clubManager.addClub(clubT1);
		clubManager.addClub(clubT2);
		clubManager.addClub(clubT3);
		clubManager.addClub(clubT4);

		ArrayList<Club> esperado = clubManager.getClubs();
		Club[] arregloEsperado = new Club[esperado.size()];
		for (int i = 0; i < esperado.size(); i++) {
			arregloEsperado[i] = esperado.get(i);
		}

		clubManager.cargarDatosClubGenerados();
		ArrayList<Club> resultado = clubManager.getClubs();
		Club[] arregloResultado = new Club[resultado.size()];
		for (int i = 0; i < resultado.size(); i++) {
			arregloResultado[i] = resultado.get(i);
		}
		assertArrayEquals(arregloEsperado, arregloResultado);

	}

	@Test

	public void testCargarDatosOwnerGenerados() {
		setupEscenario1();
//			Owner ownerT1 = new Owner ("1", "Sonya", new Date(8/18/1982), "Lemur");
//			Owner ownerT2 = new Owner ("2",	"Sloane", new Date(5/31/1996), "Common ringtail");
//			Owner ownerT3 = new Owner ("3", "Mary", new Date(1/29/1999), "Eastern white pelican");
//			Owner ownerT4 = new Owner ("4",	"Ember", new Date(11/9/1993), "Wallaby");
//			Owner ownerT5 = new Owner ("6",	"Jacob", new Date(2/22/2001), "Gaur");
//			Owner ownerT6 = new Owner ("7",	"Carter", new Date(2/9/1988), "Common ringtail");
//			Owner ownerT7 = new Owner ("9",	"Harry", new Date(2/07/2005), "Impala");
//			Owner ownerT8 = new Owner ("10", "Russel", new Date(4/8/2005), "FireFly");
//			
//			clubManager.agregarOwner(ownerT1);
//			clubManager.agregarOwner(ownerT2);
//			clubManager.agregarOwner(ownerT3);
//			clubManager.agregarOwner(ownerT4);
//			clubManager.agregarOwner(ownerT5);
//			clubManager.agregarOwner(ownerT6);
//			clubManager.agregarOwner(ownerT7);
//			clubManager.agregarOwner(ownerT8);

		ArrayList<Club> esperado = clubManager.getClubs();
		boolean noNullE = true;

		clubManager.cargarDatosOwnerGenerados();
		ArrayList<Club> resultado = clubManager.getClubs();
		boolean noNullR = false;
		for (int i = 0; i < resultado.size(); i++) {
			if (resultado.get(i).getClubOwners() != null) {
				noNullR = true;
			}
		}
		assertEquals(noNullE, noNullR);
	}

	@Test

	public void testAgregarOwner() {
		setupEscenario4();

		Owner ownerT1 = new Owner("1", "Sonya", new Date(8 / 18 / 1982), "Lemur");
		clubManager.agregarOwner(ownerT1);

		boolean esperado = true;
		boolean resultado = false;
		if (clubManager.getClubs().get(0).getClubOwners() != null) {
			resultado = true;
		}
		assertEquals(esperado, resultado);
	}

	@Test

	public void testAgregarOwnerDuenoEspecifico() {
		setupEscenario4();

		Owner ownerT1 = new Owner("1", "Sonya", new Date(8 / 18 / 1982), "Lemur");
		clubManager.agregarOwnerClubEspecifico(ownerT1, clubManager.getClubs().get(0));

		boolean esperado = true;
		boolean resultado = false;
		if (clubManager.getClubs().get(0).getClubOwners() != null) {
			resultado = true;
		}
		assertEquals(esperado, resultado);
	}

	@Test

	public void testAgregarOwnerByName() {
		setupEscenario4();

		Owner ownerT1 = new Owner("1", "Sonya", new Date(8 / 18 / 1982), "Lemur");
		clubManager.agregarOwnerByName(ownerT1, clubManager.getClubs().get(0).getClubName());

		boolean esperado = true;
		boolean resultado = false;
		if (clubManager.getClubs().get(0).getClubOwners() != null) {
			resultado = true;
		}
		assertEquals(esperado, resultado);
	}

	@Test

	public void testCargarDatosPetGenerados() {
		setupEscenario5();

		boolean noNullE = true;

		clubManager.cargarDatosPetGenerados();
		boolean noNullR = false;
		if (clubManager.getClubs().get(0).getClubOwners().get(0).getPets() != null) {
			noNullR = true;
		}
		assertEquals(noNullE, noNullR);
	}

	@Test

	public void testAddPet() {
		setupEscenario5();

		boolean noNullE = true;

		Pet pet1 = new Pet("1", "pet1", new Date(01 / 01 / 2010), "Femenio", "Ave");
		clubManager.addPets(pet1);

		boolean noNullR = false;
		if (clubManager.getClubs().get(0).getClubOwners().get(0).getPets() != null) {
			noNullR = true;
		}
		assertEquals(noNullE, noNullR);
	}

	@Test

	public void testAgregarPetByName() {
		setupEscenario5();
		boolean noNullE = true;

		Pet pet1 = new Pet("1", "pet1", new Date(01 / 01 / 2010), "Femenio", "Ave");
		clubManager.agregarPetByName(clubManager.getClubs().get(0).getClubOwners().get(0),
				clubManager.getClubs().get(0).getClubName(), pet1);

		boolean noNullR = false;
		if (clubManager.getClubs().get(0).getClubOwners().get(0).getPets() != null) {
			noNullR = true;
		}
		assertEquals(noNullE, noNullR);
	}

	@Test

	public void testAgregarPetByOwner() {
		setupEscenario5();
		boolean noNullE = true;

		Pet pet1 = new Pet("1", "pet1", new Date(01 / 01 / 2010), "Femenio", "Ave");
		clubManager.agregarPetByOwner(clubManager.getClubs().get(0).getClubOwners().get(0).getNameOwner(), pet1);

		boolean noNullR = false;
		if (clubManager.getClubs().get(0).getClubOwners().get(0).getPets() != null) {
			noNullR = true;
		}
		assertEquals(noNullE, noNullR);
	}

//		@Test
//		
//		public void testcargarDatosGuardadosClub() {
//			setupEscenario6();
//			boolean notNullE = true;
//			
//			boolean notNullR = false;
//			clubManager.cargarDatosGuardadosClub();
//			if(clubManager.getClubs() != null) {
//				notNullR = true;
//			}
//		}

	@Test

	public void testAddClub() {
		setupEscenario6();
		boolean notNullE = true;

		Club club3 = new Club("3", "Club3", new Date(03 / 03 / 2019), "Caballo");
		clubManager.addClub(club3);

		boolean notNullR = false;
		if (clubManager.getClubs() != null) {
			notNullR = true;
		}
	}

	@Test

	public void testNombreClubsDisponibles() {
		setupEscenario6();
		Club club3 = new Club("3", "Club3", new Date(03 / 03 / 2019), "Caballo");
		clubManager.addClub(club3);

		String mensajeEsperado = clubManager.nombreClubsDisponibles();

		String mensajeResultado = clubManager.nombreClubsDisponibles();
		assertEquals(mensajeEsperado, mensajeResultado);
	}

	@Test

	public void testCargar() {
		setupEscenario6();
		boolean notNullE = true;

		clubManager.cargar();
		boolean notNullR = false;
		if (clubManager.getClubs() != null) {
			notNullR = true;
		}
		assertEquals(notNullE, notNullR);
	}

	@Test

	public void testEliminarClubPorId() {
		setupEscenario4();
		boolean eliminadoEsperado = false;

		clubManager.eliminarClubPorId(clubManager.getClubs().get(0).getIdClub());

		boolean eliminadoResultado = false;
		if (clubManager.getClubs() == null) {
			eliminadoResultado = true;
		}
		assertEquals(eliminadoEsperado, eliminadoResultado);
	}

	@Test

	public void testEliminarClubPorNombre() {
		setupEscenario4();
		boolean eliminadoEsperado = false;

		clubManager.eliminarClubPorNombre(clubManager.getClubs().get(0).getClubName());

		boolean eliminadoResultado = false;
		if (clubManager.getClubs() == null) {
			eliminadoResultado = true;
		}
		assertEquals(eliminadoEsperado, eliminadoResultado);
	}

	@Test

	public void eliminarOwnerPorId() {
		setupEscenario5();

		boolean eliminadoEsperado = false;

		clubManager.eliminarOwnerPorId(clubManager.getClubs().get(0).getClubOwners().get(0).getIdOwner());

		boolean eliminadoResultado = false;
		if (clubManager.getClubs().get(0).getClubOwners() == null) {
			eliminadoResultado = true;
		}
		assertEquals(eliminadoEsperado, eliminadoResultado);
	}

	@Test

	public void eliminarOwnerPorNombre() {
		setupEscenario5();

		boolean eliminadoEsperado = false;

		clubManager.getClubs().get(0).eliminarDuenoId(clubManager.getClubs().get(0).getClubOwners().get(0).getNameOwner());

		boolean eliminadoResultado = false;
		if (clubManager.getClubs().get(0).getClubOwners() == null) {
			eliminadoResultado = true;
		}
		assertEquals(eliminadoEsperado, eliminadoResultado);
	}

	@Test

	public void eliminarPetPorId() {
		setupEscenario7();

		boolean eliminadoEsperado = false;

		clubManager
				.eliminarOwnerPorId(clubManager.getClubs().get(0).getClubOwners().get(0).getPets().get(0).getPetId());

		boolean eliminadoResultado = false;
		if (clubManager.getClubs().get(0).getClubOwners() == null) {
			eliminadoResultado = true;
		}
		assertEquals(eliminadoEsperado, eliminadoResultado);
	}

	@Test

	public void eliminarPetPorNombre() {
		setupEscenario7();

		boolean eliminadoEsperado = false;

		clubManager.eliminarOwnerPorNombre(
				clubManager.getClubs().get(0).getClubOwners().get(0).getPets().get(0).getPetName());

		boolean eliminadoResultado = false;
		if (clubManager.getClubs().get(0).getClubOwners() == null) {
			eliminadoResultado = true;
		}
		assertEquals(eliminadoEsperado, eliminadoResultado);
	}

	@Test

	public void ordenamientoBurbujaOwnerID() {
		setupEscenario5();

		String mensajeEsperado = "                                        Datos ordenados por ID                              \n";
		mensajeEsperado += "     ID DUEÑO     " + "     NOMBRE DUEÑO     " + "     FECHA NACIMIENTO OWNER     "
				+ "     TIPO DE MASCOTA FAVORITO     " + "\n";

		ArrayList<Owner> owners = clubManager.getClubs().get(0).getClubOwners();
		Owner[] arregloEsperado = new Owner[clubManager.getClubs().get(0).getClubOwners().size()];
		for (int i = 0; i < owners.size(); i++) {
			for (int j = 0; j < owners.size(); j++) {
				arregloEsperado[i] = owners.get(i);
				mensajeEsperado += "     " + arregloEsperado[i].getIdOwner() + "     " + "     "
						+ arregloEsperado[i].getNameOwner() + "     " + "     " + arregloEsperado[i].getBornDateOwner()
						+ "     " + "     " + arregloEsperado[i].getPetTypeOwner() + "     " + "\n";
			}
		}

		String mensajeResultado = clubManager.ordenamientoBurbujaOwnerID();

		assertEquals(mensajeEsperado, mensajeResultado);
	}

	@Test

	public void ordenamientoCTOwnerName() {
		setupEscenario5();

		String mensajeEsperado = "";
		mensajeEsperado = "                                        Datos ordenados por nombre                           \n";
		mensajeEsperado += "    NOMBRE DUEÑO     " + "     ID DUEÑO    " + "     FECHA NACIMIENTO     "
				+ "     TIPO DE MASCOTA FAVORITO     " + "\n";
		ArrayList<Owner> owners = clubManager.getClubs().get(0).getClubOwners();
		Owner[] arregloEsperado = new Owner[clubManager.getClubs().get(0).getClubOwners().size()];
		for (int i = 0; i < owners.size(); i++) {
			for (int j = 0; j < owners.size(); j++) {
				arregloEsperado[i] = owners.get(i);
				mensajeEsperado += "     " + arregloEsperado[i].getNameOwner() + "     " + "     "
						+ arregloEsperado[i].getIdOwner() + "     " + "     " + arregloEsperado[i].getBornDateOwner()
						+ "     " + "     " + arregloEsperado[i].getPetTypeOwner() + "     " + "\n";
			}
		}

		String mensajeResultado = clubManager.ordenamientoCTOwnerName();

		assertEquals(mensajeEsperado, mensajeResultado);
	}

	@Test

	public void ordenamientoInsercionOwnerBornDate() {
		setupEscenario5();
		String mensajeEsperado = "";
		mensajeEsperado = "                                        Datos ordenados por fecha de nacimiento                           \n";
		mensajeEsperado += "    FECHA NACIMIENTO     " + "     ID DUEÑO    " + "     NOMBRE DUEÑO     "
				+ "     TIPO DE MASCOTA FAVORITO     " + "\n";
		ArrayList<Owner> owners = clubManager.getClubs().get(0).getClubOwners();
		Owner[] arregloEsperado = new Owner[clubManager.getClubs().get(0).getClubOwners().size()];
		for (int i = 0; i < owners.size(); i++) {
			for (int j = 0; j < owners.size(); j++) {
				arregloEsperado[i] = owners.get(i);
				mensajeEsperado += "     " + arregloEsperado[i].getBornDateOwner() + "     "
						+ arregloEsperado[i].getIdOwner() + "     " + "     " + arregloEsperado[i].getNameOwner()
						+ "     " + "     " + arregloEsperado[i].getPetTypeOwner() + "     " + "\n";
			}
		}

		String mensajeResultado = clubManager.ordenamientoInsercionOwnerBornDate();

		assertEquals(mensajeEsperado, mensajeResultado);
	}
	
	@Test

	public void ordenamientoBurbujaCTypePetOwner() {
		setupEscenario5();
		String mensajeEsperado = "";
		mensajeEsperado = "                                        Datos ordenados por tipo de mascota favorita                           \n";
		mensajeEsperado += "    TIPO DE MASCOTA FAVORITA     " + "     ID DUEÑO    " + "     NOMBRE DUEÑO     "
				+ "     FECHA NACIMIENTO     " + "\n";
		ArrayList<Owner> owners = clubManager.getClubs().get(0).getClubOwners();
		Owner[] arregloEsperado = new Owner[clubManager.getClubs().get(0).getClubOwners().size()];
		for (int i = 0; i < owners.size(); i++) {
			for (int j = 0; j < owners.size(); j++) {
				arregloEsperado[i] = owners.get(i);
				mensajeEsperado += "     " + arregloEsperado[i].getBornDateOwner() + "     "
						+ arregloEsperado[i].getIdOwner() + "     " + "     " + arregloEsperado[i].getNameOwner()
						+ "     " + "     " + arregloEsperado[i].getPetTypeOwner() + "     " + "\n";
			}
		}

		String mensajeResultado = clubManager.ordenamientoBurbujaCTypePetOwner();

		assertEquals(mensajeEsperado, mensajeResultado);
	}
	
	@Test

	public void ordenamientoBurbujaIdClub() {
		setupEscenario8();
		String mensajeEsperado = "                                        Datos ordenados por ID                              \n";
		mensajeEsperado += "     ID DUEÑO     " + "     NOMBRE DUEÑO     " + "     FECHA DE CREACION     "
				+ "     TIPO DE MASCOTA FAVORITO     " + "\n";
		ArrayList<Club> clubs = clubManager.getClubs();
		Club[] arregloEsperado = new Club[clubManager.getClubs().size()];
		for (int i = 0; i < clubs.size(); i++) {
			arregloEsperado[i] = clubs.get(i);
				mensajeEsperado += "     " + arregloEsperado[i].getIdClub() + "     " + "     " + arregloEsperado[i].getClubName() + "     "
				+ "     " + arregloEsperado[i].getDateCreation() + "     " + "     " + arregloEsperado[i].getpetTypeClub()
				+ "     " + "\n";
		}
		String mensajeResultado = clubManager.ordenamientoBurbujaIdClub();

		assertEquals(mensajeEsperado, mensajeResultado);
	}
	
	@Test
	
	public void ordenamientoCTNombreClubs() {
		setupEscenario8();
		String mensajeEsperado = "                                        Datos ordenados por nombre                           \n";
		mensajeEsperado += "    NOMBRE DUEÑO     " + "     ID DUEÑO    " + "     FECHA CREACION     "
				+ "     TIPO DE MASCOTA FAVORITO     " + "\n";
		ArrayList<Club> clubs = clubManager.getClubs();
		Club[] arregloEsperado = new Club[clubManager.getClubs().size()];
		for (int i = 0; i < clubs.size(); i++) {
			arregloEsperado[i] = clubs.get(i);
			mensajeEsperado += "     " + arregloEsperado[i].getClubName() + "     " + "     " + arregloEsperado[i].getIdClub() + "     "
					+ "     " + arregloEsperado[i].getDateCreation() + "     " + "     " + arregloEsperado[i].getpetTypeClub()
					+ "     " + "\n";
		}
		String mensajeResultado = clubManager.ordenamientoCTNombreClubs();

		assertEquals(mensajeEsperado, mensajeResultado);
	}
	
	
	public void ordenamientoIncersionDateClub() {
		setupEscenario8();
		String mensajeEsperado = "                                        Datos ordenados por fecha de creacion                           \n";
		mensajeEsperado += "    FECHA NACIMIENTO     " + "     ID DUEÑO    " + "     NOMBRE DUEÑO     "
				+ "     FECHA NACIMIENTO     " + "     TIPO DE MASCOTA FAVORITO     " + "\n";
		
		ArrayList<Club> clubs = clubManager.getClubs();
		Club[] arregloEsperado = new Club[clubManager.getClubs().size()];
		for (int i = 0; i < clubs.size(); i++) {
			arregloEsperado[i] = clubs.get(i);
			mensajeEsperado += "     " + arregloEsperado[i].getDateCreation() + "     " + arregloEsperado[i].getIdClub() + "     "
				+ "     " + arregloEsperado[i].getClubName() + "     " + "     " + arregloEsperado[i].getpetTypeClub()
				+ "     " + "\n";
		}
		String mensajeResultado = clubManager.ordenamientoIncersionDateClub();

		assertEquals(mensajeEsperado, mensajeResultado);
		
	}
	
	@Test
	
	public void ordenamientoCTypePetClub() {
		setupEscenario5();
		String mensajeEsperado = "                                        Datos ordenados por tipo de mascota favorita                           \n";
		mensajeEsperado += "    TIPO DE MASCOTA FAVORITA     " + "       ID DUEÑO      " + "     NOMBRE DUEÑO     "
				+ "     FECHA NACIMIENTO     " + "\n";
		ArrayList<Club> clubs = clubManager.getClubs();
		Club[] arregloEsperado = new Club[clubManager.getClubs().size()];
		for (int i = 0; i < clubs.size(); i++) {
			arregloEsperado[i] = clubs.get(i);
			mensajeEsperado += "     " + arregloEsperado[i].getpetTypeClub() + "     " + "        " + arregloEsperado[i].getIdClub()
					+ "        " + "     " + arregloEsperado[i].getClubName() + "     " + "     "
					+ arregloEsperado[i].getDateCreation() + "     " + "\n";
		}
		String mensajeResultado = clubManager.ordenamientoCTypePetClub();

		assertEquals(mensajeEsperado, mensajeResultado);
	}
	
	
	public void ordenamientoBurbujaPetId() {
		setupEscenario9();
		String mensajeEsperado = "                                        Datos ordenados por ID                              \n";
		mensajeEsperado += "     ID MASCOTA     " + "     NOMBRE MASCOTA     " + "     FECHA NACIMIENTO MASCOTA     "
				+ "     GENERO MASCOTA     " + "     TIPO MASCOTA     " + "\n";
		ArrayList<Pet> pets = clubManager.getClubs().get(0).getClubOwners().get(0).getPets();
			for(int i = 0; i < pets.size(); i++) {
				mensajeEsperado += "     " + pets.get(i).getPetId() + "     "  + "     "
						+ pets.get(i).getPetName() + "     " + "     " + pets.get(i).getBornDatePet()
						+ "     " + "     " + pets.get(i).getPetGender() + "     " +  "     " + pets.get(i).getTypePet() + "     " + "\n";
			}
			
		String mensajeResultado = clubManager.ordenamientoBurbujaPetId();

		assertEquals(mensajeEsperado, mensajeResultado);
	}
	

}