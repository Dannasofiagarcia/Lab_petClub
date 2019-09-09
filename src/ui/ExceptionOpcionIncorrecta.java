package ui;

public class ExceptionOpcionIncorrecta extends Exception{
	
	ExceptionOpcionIncorrecta (int numero){
		super("La opcion " + numero + " no es valida. Intente de nuevo");
	}
}
