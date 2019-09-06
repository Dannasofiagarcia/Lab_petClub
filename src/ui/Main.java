package ui;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.ParseException;
import java.util.Scanner;
import model.*;

public class Main {
	
	//RELACIONES
	
	private Scanner lector;	
	private Investor investor;

	//CONSTRUCTOR
	
	public Main() {
		investor = new Investor();
		lector = new Scanner(System.in);
	}

	public static void main(String[] args) throws FileNotFoundException, IOException, ParseException {
		Main m = new Main (); 
		m.showInformation();
	}
	
	public void showInformation() throws FileNotFoundException, IOException, ParseException {
		investor.serializarDatosClub();
		investor.serializarDatosOwner();
		System.out.println(investor.mostrarInfo());
		System.out.println(investor.mostrarInfoO());
	}

}
