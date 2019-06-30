package implementaciones;

import tdas.ConjuntoTDA;


public class impConjunto implements ConjuntoTDA {
	
	public class NodoConjunto {
		String valor;
		NodoConjunto sig;
	}

		
	
	NodoConjunto nConjunto;
	
	@Override
	public void inicializar() {
		nConjunto = null;
	}

	@Override
	public boolean conjuntoVacio() {
		return nConjunto == null;
	}

	@Override
	public void agregar(String valor) {
		if(!this.pertenece(valor)) {
			NodoConjunto aux = new NodoConjunto();
			aux.valor = valor;
			aux.sig = nConjunto;
			nConjunto = aux;
		}
	}

	@Override
	public String elegir() {
		return nConjunto.valor;
	}

	@Override
	public void sacar(String valor) {
		if(this.pertenece(valor)) {
			if(nConjunto.valor.equals(valor)) {
				nConjunto = nConjunto.sig;
			}else {
				NodoConjunto aux = nConjunto;
				//while(aux.sig != null && !aux.sig.valor.equals(valor)) {
				while(!aux.sig.valor.equals(valor)) {
					aux = aux.sig;
				}
				aux.sig = aux.sig.sig;
			}
		}

	}

	@Override
	public boolean pertenece(String valor) {
		NodoConjunto aux = nConjunto;
		while (aux != null && !aux.valor.equals(valor)) {
			aux = aux.sig;
		}
		return (aux != null);
	}

}
