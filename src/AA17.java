import java.util.Random;
import java.util.Scanner;

public class AA17 {
	
	public static void main (String [] args)
	{
		final int rango = 1000000;
		new Usuario(rango).jugar();
	}

}

class Usuario {
	
	int adivinar;
	int mayor;
	int menor;
	
	Usuario(int mayor) {
		this.mayor = mayor; menor = 1;
		adivinar = new Random().nextInt(mayor) + 1;
	}
	
	public void jugar ()
	{
		Scanner sc = new Scanner(System.in);
		int i = 5;
		boolean acertado = false;
		boolean finIntentos = false;
		while(!acertado && !finIntentos) {
			Resta resta_lambda = (t1, t2) -> t1 - t2;
			System.out.println("Introduce un numero entre " + menor + " - " + mayor + " \n");
			int n = sc.nextInt();
			int resta = restar(n, adivinar, resta_lambda);
			Resto es_cero = (t) -> t == 0;
			acertado = esCero(resta, es_cero);
			if (!acertado) {
				if (n < adivinar && n > menor) {
					menor = n;
				} else if (n > adivinar && n < mayor) {
					mayor = n;
				}
				if (--i < 1) {
					finIntentos = true;
					System.out.println("Se acabaron los intentos!!! El numero es " + adivinar);
				} else {
					System.out.println("Fallaste!!! Quedan " + i + " intentos...\n");
				}
			} else {
				System.out.println("Has acertado el numero!!!");
			}
		}
		//https://stackoverflow.com/questions/13042008/java-util-nosuchelementexception-scanner-reading-user-input
		sc.close();
	}

	public int restar(int n1, int n2, Resta formato) {
		return formato.restar(n1,  n2);
	}
	
	public boolean esCero(int n, Resto formato) {
		if (n < 0) {
			System.out.println("El numero es mayor\n");
		} else if (n > 0) {
			System.out.println("El numero es menor\n");
		}
		return formato.esCero(n);
	}
	
}

interface Resta {
	int restar (int n1, int n2);
}

interface Resto {
	boolean esCero (int n);
}


/*
 * 
 * AA17
Generar un programa que funcione como un juego de adivinanzas, donde el usuario
tenga que adivinar un numero entre 1 y 1.000.000
Donde si adivina le damos un mensaje de "Adivinaste, campeon" y sino adivino que siga iterando hasta adivinar
teniendo el usuario hasta 5 intentos para adivinar, si excede este numero se le indica que perdio el juego. 
ESTRUCTURA DEL PROGRAMA:
Clase de usuario, clase principal, interfaz que implemente alguna variable y/o metodo
que el programa utilice utilizando lambda.

ENTREGABLES:
- Codigo del proyecto
- Captura de pantalla
- Subirlo al repositorio de Github

 * 
 * 
 */