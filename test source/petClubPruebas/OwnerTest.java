package petClubPruebas;

import static org.junit.Assert.assertEquals;

import java.sql.Date;

import org.junit.Test;

import model.Club;
import model.ClubManager;
import model.Owner;
import model.Pet;

public class OwnerTest {
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
	
	private void setupEscenario7() {
		clubManager = new ClubManager();
		Club club1 = new Club("1", "Club1", new Date(01 / 01 / 2019), "Ave");
		clubManager.addClub(club1);

		Owner owner1 = new Owner("1", "Owner1", new Date(01 / 01 / 2000), "Ave");
		clubManager.agregarOwner(owner1);
		
		Pet pet15 = new Pet("14", "pet15", new Date(02 / 01 / 2010), "Femenino", "Perro");
		Pet pet13 = new Pet("13", "pet13", new Date(06 / 01 / 2010), "Femenino", "Mosca");
		Pet pet14 = new Pet("14", "pet14", new Date(01 / 01 / 2010), "Masculino", "Nutria");
		owner1.agregarPet(pet15);
		owner1.agregarPet(pet13);
		owner1.agregarPet(pet14);
}
	
	@Test
	
	public void testVerificarNombreMascotas() {
		
		setupEscenario7();
		
		boolean esperado = true;
		
		boolean resultado = clubManager.getClubs().get(0).getClubOwners().get(0).verificarNombreMascotas(clubManager.getClubs().get(0).getClubOwners().get(0).getPets().get(0));
		
		assertEquals(esperado, resultado);
	}
	
	@Test
	
	public void testAgregarPet() {
		setupEscenario5();
		
		boolean notNull = true;
		Pet pet15 = new Pet("14", "pet15", new Date(02 / 01 / 2010), "Femenino", "Perro");
		boolean resultado = false;
		clubManager.getClubs().get(0).getClubOwners().get(0).agregarPet(pet15);
		if(clubManager.getClubs().get(0).getClubOwners().get(0).getPets() != null) {
			resultado = true;
		}
		assertEquals(notNull, resultado);
		
	}
	
	@Test
	
	public void testCantidadMascotas() {
		setupEscenario5();
		int esperado = 0;
		int resultado = clubManager.getClubs().get(0).getClubOwners().get(0).cantidadMascotas();
		assertEquals(esperado, resultado);
	}

	@Test
	
	public void testEliminarMascotaId() {
		setupEscenario7();
		boolean esperado = false;
		boolean resultado = false;
		clubManager.getClubs().get(0).getClubOwners().get(0).eliminarMascotaId(clubManager.getClubs().get(0).getClubOwners().get(0).getPets().get(0).getPetId());
		if(clubManager.getClubs().get(0).getClubOwners().get(0).getPets().size() == 2) {
			resultado = true;
		}
		assertEquals (esperado, resultado);
	}
	
@Test
	
	public void testEliminarMascotaNombre() {
		setupEscenario7();
		boolean esperado = false;
		boolean resultado = false;
		clubManager.getClubs().get(0).getClubOwners().get(0).eliminarMascotaNombre(clubManager.getClubs().get(0).getClubOwners().get(0).getPets().get(0).getPetId());
		if(clubManager.getClubs().get(0).getClubOwners().get(0).getPets().size() == 2) {
			resultado = true;
		}
		assertEquals (esperado, resultado);
	}
}
