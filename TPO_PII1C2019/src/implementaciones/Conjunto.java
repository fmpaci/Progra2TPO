package implementaciones;

import tdas.ConjuntoTDA;


public class Conjunto implements ConjuntoTDA {
	
	NodoConjunto nc;
	
	@Override
	public void inicializar() {
		nc = null;
	}

	@Override
	public boolean conjuntoVacio() {
		return nc == null;
	}

	@Override
	public void agregar(String valor) {
		if(!this.pertenece(valor)) {
			NodoConjunto aux = new NodoConjunto();
			aux.valor = valor;
			aux.sig = nc;
			nc = aux;
		}
	}

	@Override
	public String elegir() {
		return nc.valor;
	}

	@Override
	public void sacar(String valor) {
		if(this.pertenece(valor)) {
			if(nc.valor.equals(valor)) {
				nc = nc.sig;
			}else {
				NodoConjunto aux = nc;
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
		NodoConjunto aux = nc;
		while (aux != null && !aux.valor.equals(valor)) {
			aux = aux.sig;
		}
		return (aux != null);
	}

}
