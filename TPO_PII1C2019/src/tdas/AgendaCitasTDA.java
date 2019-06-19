package tdas;

public interface AgendaCitasTDA {
	
	/**
	 * 
	 * Sin precondiciones ni parámetros.
	 * 
	 * */
	public void inicializar();
	
	/**
	 *  Agrega un nuevo día para agendar citas a sus clientes.
	 *  	Si no existe el abogado lo crea y asigna la nueva fecha. 
	 *  	Si existe el abogado y no la fecha, crea la nueva fecha
	 *  	Si existe el abogado y la fecha no hace nada.
	 * 
	 *  Precondición:
	 *  	inicializada.
	 *  Parámetros: 
	 * 		@param abogado  
	 * 		@param dia cadena de caracteres con los nombre de los días (lunes, martes, etc.)
	 * 		@param fecha cadena de caracteres con formato AAAA/MM/DD (año, mes, día) 
	 * 
	 * */
	public void agregarNuevoDia(String abogado, String dia, String fecha);
	
	/**
	 *  Agrega una nueva cita a un abogado para un cliente determinado, en una fecha y hora determinada. 
	 * 
	 * Precondición
	 * 		inicializada, existe el abogado y la fecha pero no existe una cita en esa fecha y horario.
	 * 
	 * Parámetros: 
	 * 		String abogado 
	 * 		String fecha
	 * 		String hora
	 * 		String cliente
	 * */
	public void agregarNuevaCita(String abogado, String fecha, String hora, String cliente);
	
	/**
	 *  Elimina un abogado y a toda su agenda de citas. Si el abogado no existe no hace nada.
	 * 
	 * Precondición: 
	 * 		inicializada
	 * 
	 * Parámetros: 
	 * 		String abogado 
	 * */	
	public void eliminarAbogado(String abogado);
	
	/**
	 *  Elimina un abogado y a toda su agenda de citas para una fecha determinada. 
	 *  Si el abogado no existe no hace nada.
	 * 
	 * Precondición: 
	 * 		inicializada
	 * 
	 * Parámetros: 
	 * 		String abogado
	 * 		String fecha 
	 * */	
	public void eliminarFecha(String abogado, String fecha);
	
	/**
	 * Elimina una cita determinada. Si no concuerda la fecha, la hora y el cliente no se borrará la cita.
	 * 
	 * Precondición:
	 * 		inicializada y existe el turno para ese paciente.
	 * 
	 * Parámetros: 
	 * 		String abogado 
	 * 		String fecha
	 * 		String hora
	 * 		String cliente
	 * */	
	public void eliminarCita(String abogado, String fecha, String hora, String cliente);
	
	/**
	 * Devuelve el verdadero si existe una cita para ese abogado, en esa fecha y en ese horario. 
	 * Si no existe devuelve falso.
	 * 
	 * Precondicón:
	 * 		inicializada
	 * 
	 * Parámetros: 
	 * 		@param abogado 
	 * 		@param fecha
	 * 		@param hora
	 * */	
	public boolean existeCita(String abogado, String fecha, String hora);
	
	/**
	 * Devuelve el nombre del cliente que posee la cita.
	 * 
	 * Precondición:
	 * 		inicializada y existe la cita
	 * 
	 * Parámetros: 
	 * 		@param abogado 
	 * 		@param fecha
	 * 		@param hora
	 * 		@return nombre del cliente de la cita
	 * */
	public String clienteEnCita(String abogado, String fecha, String hora);
	
	/**
	 * Devuelve una Conjunto con todos los abogados existentes en la agenda. Si no existen abogados devuelve un conjunto vacío.
	 * 
	 * Precondición:
	 * 		inicializada
	 * 
	 * Parámetros:
	 * 		@return conjunto de los nombres de todos los abogados existentes en la estructura.
	 * 
	 * */	
	public ConjuntoTDA abogados();
	
	/**
	 * Devuelve una cola con todos las citas que posee ese abogado en esa fecha ordenado por horario de las citas. 
	 * Si no existe el abogado o la fecha devuelve una cola vacía.
	 * 
	 * Precondición:
	 * 		inicializada
	 * 
	 * Parámetros: 
	 * 		@param abogado 
	 * 		@param fecha
	 * */
	public ColaTDA turnos (String abogado, String fecha);
	
	
	
	/**
	 * Devuelve un conjunto con todas las fechas de citas que tenga un abogado 
	 *  
	 * Precondición:
	 * 		inicializada
	 * 
	 * Parámetros: 
	 * 		@param abogado 
	 * 
	 * */
	public ConjuntoTDA fechas(String abogado);
}
