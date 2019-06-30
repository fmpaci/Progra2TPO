package algoritmos;

import tdas.AgendaCitasTDA;
import tdas.ColaPrioridadTDA;
import tdas.ColaTDA;
import tdas.ConjuntoTDA;
import implementaciones.Conjunto;

public class Algoritmo implements IAlgoritmo {

	@Override
	public boolean disponible(AgendaCitasTDA agenda, String abogado, String fecha, String hora) {
		if (!agenda.abogados().pertenece(abogado)) return false;
		if (!agenda.fechas(abogado).pertenece(fecha)) return false;
		return !agenda.existeCita(abogado, fecha, hora);
	}

	@Override
	public ConjuntoTDA masCitas(AgendaCitasTDA agenda, String fechaDesde, String fechaHasta) {
		ConjuntoTDA abogadosResultantes = new Conjunto();
		abogadosResultantes.inicializar();
		
		ConjuntoTDA abogados = agenda.abogados();
		while(!abogados.conjuntoVacio()) {
			String abogado = abogados.elegir();
			abogados.sacar(abogado);
			
			Integer cantidadCitas = 0;
			ConjuntoTDA fechas = agenda.fechas(abogado);
			while(!fechas.conjuntoVacio()) {
				String fecha = fechas.elegir();
				fechas.sacar(fecha);
			
				if (fecha.compareTo(fechaDesde) >= 0 && fecha.compareTo(fechaHasta) < 0) {
					ColaTDA turnos = agenda.turnos(abogado, fecha);
					while (!turnos.colaVacia()) {
						cantidadCitas += 1;
						turnos.desacolar();
					}
				}
			}
			
			if (cantidadCitas > 0) abogadosResultantes.agregar(abogado);
		}
		
		return abogadosResultantes;
	}

	@Override
	public String abogadoUltimaVez(AgendaCitasTDA agenda, String cliente) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String[][] obtenerCitas(AgendaCitasTDA agenda, String abogado, String fecha) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String[][] conQuienSeReunio(AgendaCitasTDA agenda, String cliente) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ColaPrioridadTDA libresTotal(AgendaCitasTDA agenda, String fecha) {
		// TODO Auto-generated method stub
		return null;
	}
	
}
