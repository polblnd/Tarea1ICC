/**
 * Este programa es una interfaz que contiene todos los métodos que deberían implementar las clases que modelan campos algebraicos
 * Este campo es el de los números racionales: p/q, q!=0
 * @author Leonardo Paolo Blanco Medina "Pól"
 * @version 1.0
 * param <T> el nombre de la clase que modela el campo de los números racionales
 */

public interface Campo<T>{ // Punto 2. Definición del comportamiento de cada clase pot medio de una interfaz
/**
     * Suma otroSumando al elemento del campo.
     * @param otroSumando El otro número racional a sumar.
     * @return El resultado de sumar otroSumando a este número racional.
     */
    public T sumar(T otroSumando);
    /**
     * Multiplica otroMultiplicando por el elemento del campo.
     * @param otroMultiplicando El otro número racional a sumar.
     * @return El resultado de sumar otroMultiplicando a este número racional.
     */
    public T multiplicar(T otroMultiplicando);
    /**
     * Regresa el inverso aditivo del elemento del campo.
     * @return el inverso aditivo del elemento en cuestión.
     */
    public T obtenerInversoAditivo();
    /**
     * Regresa el inverso multiplicativo del elemento del campo.
     * @return el inverso multiplicativo del elemento en cuestión.
     */
    public T obtenerInversoMultiplicativo();
    /**
     * Regresa el neutro aditivo del campo.
     * @return El neutro aditivo del campo.
     */
    public T obtenerNeutroAditivo();
    /**
     * Regresa el neutro multiplicativo del campo.
     * @return El neutro multiplicativo del campo.
     */
    public T obtenerNeutroMultiplicativo();
}
