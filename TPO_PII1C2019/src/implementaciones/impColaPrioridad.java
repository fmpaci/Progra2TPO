package implementaciones;

import tdas.ColaPrioridadTDA;

public class impColaPrioridad implements ColaPrioridadTDA {
	
	public class NodoPrioridad {
		String valor;
		String prioridad;
		NodoPrioridad sig;
	}
	
	NodoPrioridad mayorPrioridad;
	
	@Override
	public void inicializar() {
		mayorPrioridad = null;
		
	}

	@Override
	public void acolar(String valor, String prioridad) {
		NodoPrioridad nuevo = new NodoPrioridad();
		nuevo.valor = valor;
		nuevo.prioridad = prioridad;
		
		if(mayorPrioridad == null || prioridad.compareToIgnoreCase(mayorPrioridad.prioridad) < 0 ) {
			nuevo.sig = mayorPrioridad;
			mayorPrioridad = nuevo;
		}else {
			NodoPrioridad aux = mayorPrioridad;
			while(aux.sig != null && prioridad.compareToIgnoreCase(aux.sig.prioridad)>=0) {
				aux = aux.sig;
			}
			nuevo.sig = aux.sig;
			aux.sig = nuevo;
		}
		
	}

	@Override
	public void desacolar() {
		mayorPrioridad = mayorPrioridad.sig;
		
	}

	@Override
	public String primero() {
		// TODO Auto-generated method stub
		return mayorPrioridad.valor;
	}

	@Override
	public String prioridad() {
		// TODO Auto-generated method stub
		return mayorPrioridad.valor;
	}

	@Override
	public boolean colaVacia() {
		// TODO Auto-generated method stub
		return mayorPrioridad == null;
	}

}

