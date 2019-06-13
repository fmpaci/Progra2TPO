package algoritmos;

import tdas.AgendaCitasTDA;
import tdas.ColaPrioridadTDA;
import tdas.ConjuntoTDA;

public interface IAlgoritmo {

	/**
	 * Determinar si el abogado tiene tiempo disponible para una cita en un día y horario determinado.
	 * */
	public boolean disponible(AgendaCitasTDA agenda, String abogado, String fecha, String hora);
	
	/**
	 * Determinar el/los abogados que tienen más citas en un período de tiempo. 
	 * 
	 * Las fecha tienen el mismo formato que el utilizado en la agenda.
	 * */
	public ConjuntoTDA masCitas(AgendaCitasTDA agenda, String fechaDesde, String fechaHasta);
	
	/**
	 * Cual es el abogado que tuvo la última cita con un cliente determinado pasado como parámetro
	 * */
	public String abogadoUltimaVez(AgendaCitasTDA agenda, String cliente);
	
	/**
	 * Obtener todas las citas de un abogado determinado durante una semana determinada.
	 * 
	 * Se pasa la fecha correspondiente al Lunes de la mensionada semana.
	 * 
	 * Debe devolver un arreglo conteniendo el nombre del día, la hora y el cliente ordenado por
	 * día de la semana y horario.  
	 */
	public String[][] obtenerCitas(AgendaCitasTDA agenda, String abogado, String fecha);
	
	/**
	 * Obtener para un cliente determinado, la lista de todos los abogados con que se reunío junto con la fecha y la hora.
	 * 
	 * Debe devolver un arreglo conteniendo el nombre del abogado, la fecha y la hora y el cliente ordenado por
	 * día de la semana y horario.  
	 * */
	public String[][] conQuienSeReunio(AgendaCitasTDA agenda, String cliente);
	
	/**
	 * Obtener todas los horarios libres de todos los abogados para una semana determinada.
	 * 
	 * Se pasa la fecha correspondiente al Lunes de la mensionada semana.
	 * 
	 * Devolver una cola con prioridad que tenga como valor el nombre del abogado y como prioridad el horario
	 * */
	public ColaPrioridadTDA libresTotal(AgendaCitasTDA agenda, String fecha);
}
