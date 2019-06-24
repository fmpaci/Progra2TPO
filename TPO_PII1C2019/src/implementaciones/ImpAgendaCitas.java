package implementaciones;

import tdas.AgendaCitasTDA;
import tdas.ColaTDA;
import tdas.ConjuntoTDA;

public class ImpAgendaCitas implements AgendaCitasTDA {
	
	NodoAgenda primerAgenda;
	
	
	@Override
	public void inicializar() {
		primerAgenda = null;

	}
//funciones auxiliares para agregar nuevo día
	private NodoAgenda crearAbogado(String abogado) {
		NodoAgenda auxAgenda = new NodoAgenda();
		
		auxAgenda.abogado = abogado;
		auxAgenda.primeraFecha = null;
		auxAgenda.sigAbogado = null;
		
		return auxAgenda;
	}
	
	private NodoDia crearDia(String dia, String fecha) {
		NodoDia auxDia = new NodoDia();

		auxDia.dia = dia;
		auxDia.fecha = fecha;
		//Descomentar!!!!
		//auxDia.turnos = new ImpArbolCitas();
		//auxDia.turnos.inicializar();
		auxDia.siguienteFecha = null;
		
		return auxDia;
	}
//funciones auxiliares para agregar nuevo día	
	
	private boolean mismaFecha(String dia, String fecha, NodoDia ndia) {
		return dia.equalsIgnoreCase(ndia.dia) && fecha.equalsIgnoreCase(ndia.fecha);
	}
	
	
	@Override
	public void agregarNuevoDia(String abogado, String dia, String fecha) {
		NodoAgenda aux = new NodoAgenda();
		aux = primerAgenda;
		if(aux == null) {
			primerAgenda = crearAbogado(abogado);
			primerAgenda.primeraFecha = crearDia(dia,fecha);
		}else {
			//busco si existe el abogado o me quedo con el último
			while(aux.sigAbogado != null && !aux.abogado.equalsIgnoreCase(abogado) ) {
				aux = aux.sigAbogado;
			}
			//si lo encontró, solo creo el día
			if(aux.abogado.equalsIgnoreCase(abogado)) {
				NodoDia auxDia = new NodoDia();
				auxDia = aux.primeraFecha;
				while(auxDia.siguienteFecha != null && !mismaFecha(dia,fecha,auxDia)) {
					auxDia = auxDia.siguienteFecha;
				}
				//si no encuentra la fecha, la crea
				if(auxDia.siguienteFecha == null) auxDia.siguienteFecha = crearDia(dia,fecha);
			}else {
				aux.sigAbogado = crearAbogado(abogado);
				aux.sigAbogado.primeraFecha = crearDia(dia,fecha);
			}
		}
	}

	
	@Override
	public void agregarNuevaCita(String abogado, String fecha, String hora, String cliente) {
		// TODO Auto-generated method stub

	}
	
	@Override
	public void eliminarAbogado(String abogado) {
		// TODO Auto-generated method stub
		NodoAgenda aux = new NodoAgenda();
		aux = primerAgenda;
		while(aux.sigAbogado != null & !aux.abogado.equalsIgnoreCase(abogado)) {
			aux = aux.sigAbogado;
		}
		

	}

	@Override
	public void eliminarFecha(String abogado, String fecha) {
		// TODO Auto-generated method stub

	}

	@Override
	public void eliminarCita(String abogado, String fecha, String hora, String cliente) {
		// TODO Auto-generated method stub

	}

	@Override
	public boolean existeCita(String abogado, String fecha, String hora) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public String clienteEnCita(String abogado, String fecha, String hora) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ConjuntoTDA abogados() {
		NodoAgenda aux = new NodoAgenda();
		ConjuntoTDA conjAbogados = new ImpConjunto();
		conjAbogados.inicializar();
		aux = primerAgenda;
		while(aux != null) {
			conjAbogados.agregar(aux.abogado);
			aux = aux.sigAbogado;
		}
		return conjAbogados;
	}

	@Override
	public ColaTDA turnos(String abogado, String fecha) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ConjuntoTDA fechas(String abogado) {
		// TODO Auto-generated method stub
		return null;
	}

}
