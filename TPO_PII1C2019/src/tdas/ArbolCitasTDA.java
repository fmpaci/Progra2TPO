package tdas;

public interface ArbolCitasTDA {

	/**
	 * Inicializa la estructura
	 * 
	 * Sin precondiciones.
	 * 
	 * Importante. Para el desarrollo del TPO vamos a considerar que TODAS las citas se darán en hora 
	 * o medias horas. Por Ejemplo 10:00; 12:30; etc.
	 *  
	 * */
	public void inicializar();
	
	/**
	 * Agrega una nueva cita en el arbol de citas de un abogado seleccionado
	 * 
	 * Precondición: 
	 * 		incializado y no existe una cita para ese horario 
	 * Parámetros:
	 * 		@param hora cadena de caracteres (con formato "HH:MM")
	 * 		@param cliente cadena de caracteres
	 */
	public void agregar(String hora, String cliente);
	
	/**
	 * Elimina una cita del arbol de citas de un abogado seleccionado
	 * 
	 * Precondición:
	 * 		incializado. Si la cita no existe no hace nada. Si la cita existe debe coincidir el cliente
	 * Parámetros:	 
	 * 		@param hora
	 * 		@param cliente
	 */
	public void eliminar(String hora, String cliente);
	
	/**
	 * Devuelve la hora de la cita correspondiente al nodo corriente.
	 * 
	 * Precondición:
	 * 		incializado y no es un arbol vacío
	 * Parámetros:	 
	 * 		@return la hora de la cita del nodo corriente
	 */
	public String hora();
	
	/**
	 * Devuelve el nombre del cliente correspondiente al nodo corriente.
	 * 
	 * Precondición:
	 * 		incializado y no es un arbol vacío
	 * Parámetros:	 
	 * 		@return el nombre del cliente del nodo corriente
	 */
	public String cliente();
	
	/**
	 * Devuelve el subarbol derecho de citas.
	 * 
	 * Precondición:
	 * 		incializado y no un arbol vacío
	 * Parámetros:	 
	 * 		@return el subarbol derecho del nodo corriente
	 */
	public ArbolCitasTDA hijoDerecho();

	/**
	 * Devuelve el subarbol derecho de citas.
	 * 
	 * Precondición:
	 * 		incializado y no un arbol vacío
	 * Parámetros:	 
	 * 		@return el subarbol izquierdo del nodo corriente
	 */
	public ArbolCitasTDA hijoIzquierdo();
	
	/**
	 * Me dice si el arbol es un arbol de citas vacío.
	 * 
	 * Precondición:
	 * 		incializado
	 * Parámetros:	 
	 * 		@return verdadero si el arbol esta vacío
	 */
	public boolean arbolVacio();
	
}
