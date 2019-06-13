package tdas;
/** 
 * 
 * Similar al Conjunto de enteros pero ahora con elementos cadena de caracteres.
 * 
 * */
public interface ConjuntoTDA {
	/**
	 * inicializado
	 * */
	public void inicializar();
	/**
	 * inicializado
	 * */
	public boolean conjuntoVacio();
	/**
	 * inicializado
	 * */
	public void agregar(String valor);
	/**
	 * inicializado y no vacío
	 * */
	public String elegir();
	/**
	 * inicializado
	 * */
	public void sacar(String valor);
	/**
	 * inicializado
	 * */
	public boolean pertenece(String valor);
}
