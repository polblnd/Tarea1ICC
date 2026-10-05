/**
 * Programa que ejecuta el desarrollo de los números racionales
 * @author Leonardo Paolo Blanco Medina "Pól"
 * @version 3.0
 */

public class Racional implements Campo<Racional>, Comparable<Racional>{
	// Definimos nuestras variables
	private int numerador, denominador;

	/*
	 * Neutro aditivo 0
	 * a + 0 = a
	 */
	public static final Racional NEUTRO_ADITIVO = new Racional(0,1);

	/*
	 * Neutro multiplicativo 1
	 * a*1 = a
	 */
	public static final Racional NEUTRO_MULTIPLICATIVO = new Racional(1,1);

	/** Inicia la memoria de un objeto nuevo con valores 0/1
	 *
	 */
	public Racional(){
		this(0,1);
	}
	
	/**
	 * Inicializa la memoria de un objeto con nuevos valores numerador/denominador
	 * En caso de que sea negativo el numero racional, se saca valor absoluto y se multiplica por -1
	 * @param numerador El numerador del numero racional
	 * @param denominador El denominador del numero racional
	 */
	public Racional(int numerador, int denominador){
	// if(denominador<0 && numerador<0 || numerador>0 && denominador<0){
	//     this.numerador = numerador * -1;
	//     this.denominador = denominador * -1;
	// }
	// if(numerador<0 && denominador>0 || numerador>0 && denominador>0){
	//     this.numerador = numerador;
	//     this.denominador = denominador;
	// }
	// this.denominador = (denominador == 0) ? 1 : denominador;
		this.numerador = abs(numerador);
		this.denominador = abs(denominador);
		if(numerador * denominador < 0)
			this.numerador *= -1;
		simplificar(); 
	}
	/**
	 * Inicia la memoria de un objeto copia del argumento
	 * @param original El objeto a copiar
	 * */
	public Racional(Racional original){
		this(original.numerador,original.denominador);
	}
	
	/* 
	 * Calcula el valor absoluto entre dos enteros
	 * Esa funcion es equivalente al abs que usaremos
	 */
	private int abs(int x){
		return (x < 0)? -1 * x : x ;
	}
	/** 
	 * Simplifica este numero racional.
	 * Divide entre el máximo comun divisor al numerador y denominador
	 */
	public void simplificar(){
	
		int mcd = mcd(abs(numerador), abs(denominador));
		this.numerador /= mcd;
		this.denominador /= mcd;
			
	}
	/** Funcion para obtener el maximo comun divisor
	 * Esta en un bucle, donde si b != 0 se repite lo que esta dentro del while
	 * Saca el residuo de a entre b (65 / 13 = 5, r = 0)
	 * Procesa primero a = b, ( a = 13 )
	 * Luego procesa b = residuo ( b = 0) (Se pararía el programa)
	 * Si el programa no se para b = residuo
	 * Como b llego a 0, regresa el valor de a, el cual habia cambiado a 13
	 */
	private int mcd(int a, int b) {
        	while (b != 0) {
            		int residuo = a % b;
            		a = b;
            		b = residuo;
        	}
        	return a;
    	}
	
	public int getNumerador(){
		return numerador;
	}
	public int getDenominador(){
		return denominador;
	}
	/**
	 * Actualiza el numerador de este numero racional
	 * @param numerador El nuevo numerador de este numero racional
	 */
	public void setNumerador(int numerador){
		if(this != NEUTRO_ADITIVO && this != NEUTRO_MULTIPLICATIVO){
			this.numerador = numerador;
			simplificar();
		}
		else{
			System.err.println("No se puede actualizar los NEUTROS");
		}
	}
	/**
	 * Actualiza el numerador de este numero racional
	 * @param denominador El nuevo denominador de este numero racional
	 */
	public void setDenominador(int denominador){
		if(this != NEUTRO_ADITIVO && this != NEUTRO_MULTIPLICATIVO){
			this.denominador = denominador;
			simplificar();
		}
		else{
			System.err.println("No se puede actualizar los NEUTROS");
		}
	}	
	/**
	 * Suma r2 a este número racional
	 * @param r2 El otro numero racional a sumar
	 * @return El resultado de sumar r2 a este numero racional
	 * Se hace uso de la formula de suma de fracciones
	 */
	@Override
	public Racional sumar(Racional r2){
		return new Racional(this.numerador * r2.denominador + r2.numerador * this.denominador , this.denominador * r2.denominador);
	}
	/**
	 * Multiplica r2 a este número racional
	 * @param r2 El otro numero racional a Multiplicar
	 * @return El resultado de multiplicar r2 a este numero racional
	 * Se hace uso de la formula de multiplicacion de fracciones
	 */
	@Override
	public Racional multiplicar(Racional r2){
		return new Racional(this.numerador * r2.numerador, this.denominador * r2.denominador);
	}
	/**
 	* Obtiene el inverso aditivo de este número racional.
 	* @return El inverso aditivo de este número racional.
 	*/
	public Racional obtenerInversoAditivo(){
		return new Racional(-1 * numerador, denominador);
	}
	/**
 	* Obtiene el inverso multiplicativo de este número racional.
 	* En caso de ser (0), regresa el mismo número.
	 */
	public Racional obtenerInversoMultiplicativo(){
		Racional res = (numerador == 0) ? this : new Racional(denominador, numerador);
		res.simplificar();
		return res;
	}
	
	public Racional obtenerNeutroAditivo(){
		return NEUTRO_ADITIVO;
	}
	public Racional obtenerNeutroMultiplicativo(){
		return NEUTRO_MULTIPLICATIVO;
	}
	/**
 	* Compara este número racional con r2.
 	* @param r2 El número racional con el cual se comparará este número racional.
 	* @return -1 si este número racional es menor que r2, 0 si este número racional es igual a r2 o 1 si este número racional es mayor que r2.
	* */
	@Override
	public int compareTo(Racional r2){
		if( numerador * r2.denominador > r2.numerador * denominador)
			return 1;
		else if( numerador * r2.denominador < r2.numerador * denominador)
			return -1;
		else
			return 0;
	}
	/**
	 * Compara igualdad con otro subjeto
	 * @param o El objeto con el que se comparaa
	 */
	@Override
	public boolean equals(Object o){
		if(o != null && o instanceof Racional){
		return compareTo((Racional) o) == 0;
		}
		return false;
	}
	/*
	 * Regresa una representación del número racional en tipo String (texto)
	 * @return Una representación del número racional en tipo String
	 */
	@Override
	public String toString(){
		return "" + numerador + " / " + denominador;
	}
}
