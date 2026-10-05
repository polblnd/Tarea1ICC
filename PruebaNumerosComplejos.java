/**
 * Clase main para probar la clase NumeroRacional
 * @author Leonardo Paolo Blanco Medina "Pól"
 * @version 2.0
 */

import java.util.Scanner; 

public class PruebaNumerosComplejos {
    public static void main(String[] args) {
        Racional cero = new Racional(0, 34);
        Racional uno = new Racional(5, 5);

        System.out.print("Racional.obtenerNeutroAditivo().equals(cero): ");
        System.out.println(Racional.NEUTRO_ADITIVO.equals(cero));

        System.out.print("Racional.obtenerNeutroMultiplicativo().equals(uno): ");
        System.out.println(Racional.NEUTRO_MULTIPLICATIVO.equals(uno));

        Racional _33_11 = new Racional(33, 11);
        Racional _11_33 = new Racional(11, 33);
        Racional _58_2 = new Racional(58, 2);
        
        System.out.print("33/11: ");
        System.out.println(_33_11);
        System.out.print("11/33: ");
        System.out.println(_11_33);
        System.out.print("58/2: ");
        System.out.println(_58_2);


	// Sesión donde el usuario implementa sus valores para construir un numero racional
	Scanner scanner = new Scanner(System.in);
	System.out.println("\nIngrese un numerador y un denominador");

	int numerador = scanner.nextInt(); 
	int denominador = scanner.nextInt();
	Racional usuario = new Racional(numerador, denominador);
	
        System.out.print( numerador + "/" + denominador + ": ");
        System.out.println(usuario);

    }
}
