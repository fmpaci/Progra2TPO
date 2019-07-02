package implementaciones;

import tdas.ColaPrioridadTDA;

public class ColaPrioridad implements ColaPrioridadTDA {
	
	public class NodoPrioridad {
		String valor;
		String prioridad;
		NodoPrioridad sig;
	}
	
	NodoPrioridad nPrioridad;
	
	@Override
	public void inicializar() {
		nPrioridad = null;
		
	}

	@Override
	public void acolar(String valor, String prioridad) {
		NodoPrioridad nuevo = new NodoPrioridad();
		nuevo.valor = valor;
		nuevo.prioridad = prioridad;
		
		if(nPrioridad == null || prioridad.compareToIgnoreCase(nPrioridad.prioridad) < 0 ) {
			nuevo.sig = nPrioridad;
			nPrioridad = nuevo;
		}else {
			NodoPrioridad aux = nPrioridad;
			while(aux.sig != null && prioridad.compareToIgnoreCase(aux.sig.prioridad)>=0) {
				aux = aux.sig;
			}
			nuevo.sig = aux.sig;
			aux.sig = nuevo;
		}
		
	}

	@Override
	public void desacolar() {
		nPrioridad = nPrioridad.sig;
		
	}

	@Override
	public String primero() {
		// TODO Auto-generated method stub
		return nPrioridad.valor;
	}

	@Override
	public String prioridad() {
		// TODO Auto-generated method stub
		return nPrioridad.prioridad;
	}

	@Override
	public boolean colaVacia() {
		// TODO Auto-generated method stub
		return nPrioridad == null;
	}

}

