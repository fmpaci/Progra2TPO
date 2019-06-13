package tdas;

/**
 * 
 * Similar a la Cola de enteros pero ahora con elementos cadena de caracteres.
 * 
 * */
public interface ColaTDA {

	/**
	 * Si precondiciones
	 * */
	public void inicilizar();
	/**
	 * Inicializada
	 * */
	public void acolar(String valor);
	/**
	 * inicializada y no vacía
	 * */
	public void desacolar();
	/**
	 * inicializada y no vacía
	 * */
	public String primero();
	/**
	 * inicializada
	 * */
	public boolean colaVacia();
}
