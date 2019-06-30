package algoritmos;

import tdas.AgendaCitasTDA;
import tdas.ColaPrioridadTDA;
import tdas.ConjuntoTDA;

public class Algoritmo implements IAlgoritmo {

	@Override
	public boolean disponible(AgendaCitasTDA agenda, String abogado, String fecha, String hora) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public ConjuntoTDA masCitas(AgendaCitasTDA agenda, String fechaDesde, String fechaHasta) {
		// TODO Auto-generated method stub
		return null;
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
