package implementaciones;

import tdas.ColaTDA;

public class Cola implements ColaTDA {
	
	public class NodoCola {
		String valor;
		NodoCola sig;
	}
	

	NodoCola primero = new NodoCola();
	NodoCola ultimo = new NodoCola();
		
	@Override
	public void inicilizar() {
		primero = null;
		ultimo = null;
	}

	@Override
	public void acolar(String valor) {
		NodoCola aux = new NodoCola();
		aux.valor = valor;
		aux.sig = null;
		//si la cola no está vacía
		if(ultimo != null) {
			ultimo.sig = aux;
		}
		ultimo = aux;
		//si la cola está vacía
		if(primero == null) {
			primero = ultimo;
		}
	}

	@Override
	public void desacolar() {
		primero = primero.sig;
		
		if (primero==null)
			ultimo = null;
	}

	@Override
	public String primero() {
		return primero.valor;
	}

	@Override
	public boolean colaVacia() {
		return (ultimo == null);
	}

}
