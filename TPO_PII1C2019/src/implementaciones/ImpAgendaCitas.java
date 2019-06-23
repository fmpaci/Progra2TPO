package implementaciones;

import tdas.AgendaCitasTDA;
import tdas.ColaTDA;
import tdas.ConjuntoTDA;

public class ImpAgendaCitas implements AgendaCitasTDA {
	
	NodoAgenda primerAgenda;
	
	
	@Override
	public void inicializar() {
		primerAgenda.abogado = null;
		primerAgenda.primeraFecha = null;
		primerAgenda.sigAbogado = null;

	}

	@Override
	public void agregarNuevoDia(String abogado, String dia, String fecha) {
		//Si no hay ningun abogado, creo el primero y su correspondiente
		//fecha y día
		if(primerAgenda.abogado == null) {
			primerAgenda.abogado = abogado;
	
			NodoDia ndia = new NodoDia();
			
			ndia.dia = dia;
			ndia.fecha = fecha;
			//ndia.turnos = new ImpArbolCitas();
			//ndia.turnos.inicializar();
			ndia.siguienteFecha = null;
			
			primerAgenda.primeraFecha = ndia;
		}else {
			NodoAgenda aux = new NodoAgenda();
			aux = primerAgenda;
			while(primerAgenda.sigAbogado != null && !aux.abogado.equalsIgnoreCase(abogado) ) {
				aux = aux.sigAbogado;
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
		// TODO Auto-generated method stub
		return null;
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
