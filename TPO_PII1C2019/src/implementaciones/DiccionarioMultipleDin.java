package implementaciones;

import tdas.ConjuntoTDA;
import tdas.DiccionarioMultipleTDA;

public class DiccionarioMultipleDin implements DiccionarioMultipleTDA {
	
	class NodoClave {
		String clave;
		NodoValor valores;
		NodoClave sigClave;
	}
	
	class NodoValor{
		String valor;
		NodoValor sigValor;
	}
	
	NodoClave origen;
	
	@Override
	public void inicializar() {
		origen = null;
	}
	@Override
	public void agregar(String clave, String valor) {
		NodoClave nc = Clave2NodoClave(clave);
		if(nc == null) {
			nc = new NodoClave();
			nc.clave = clave;
			nc.sigClave = origen;
			origen = nc;
		}
		
		NodoValor aux = nc.valores;
		while(aux != null && aux.valor!=valor) {
			aux = aux.sigValor;
		}
		if (aux == null) {
			NodoValor nv = new NodoValor();
			nv.valor = valor;
			nv.sigValor = nc.valores;
			nc.valores = nv;
		}
	}
	
	private NodoClave Clave2NodoClave(String clave) {
		NodoClave aux = origen;
		while(aux != null && aux.clave != clave) {
			aux = aux.sigClave;
		}
		return aux;
	}

	@Override
	public void eliminar(String clave) {
		if(origen != null) {
			if(origen.clave == clave) {
				origen = origen.sigClave;
			}
			else {
				NodoClave aux = origen;
				while(aux.sigClave != null && aux.sigClave.clave != clave) {
					aux = aux.sigClave;
				}
				if(aux.sigClave != null) {
					aux.sigClave = aux.sigClave.sigClave;
				}
			}
		}
	}

	@Override
	public void eliminarValor(String clave, String valor) {
		if(origen != null) {
			if(origen.clave == clave) {
				eliminarValorEnNodo(origen, valor);
				if(origen.valores == null) {
					origen = origen.sigClave;
				}
			}
		else {
			NodoClave aux = origen;
			while(aux.sigClave != null && aux.sigClave.clave != clave) {
				aux = aux.sigClave;
			}
			if(aux.sigClave != null && aux.sigClave.clave != clave) {
				eliminarValorEnNodo(aux.sigClave, valor);
				if(aux.sigClave.valores == null) {
					aux.sigClave = aux.sigClave.sigClave;
					}
				}
			}
		}
	}
	
	public void eliminarValorEnNodo(NodoClave nodo, String valor) {
		if(nodo.valores != null) {
			if(nodo.valores.valor == valor) {
				nodo.valores = nodo.valores.sigValor;
			}
			else {
				NodoValor aux = nodo.valores;
				while(aux.sigValor != null && aux.sigValor.valor != valor) {
					aux = aux.sigValor;
				}
				if(aux.sigValor != null && aux.sigValor.valor != valor) {
					aux.sigValor = aux.sigValor.sigValor;
				}
			}
		}
	}

	@Override
	public ConjuntoTDA recuperar(String clave) {
		NodoClave n = Clave2NodoClave(clave);
		ConjuntoTDA c = new ImpConjunto();
		c.inicializar();
		if(n != null) {
			NodoValor aux = n.valores;
			while(aux != null) {
				c.agregar(aux.valor);
				aux = aux.sigValor;
			}
		}
		return c;
	}

	@Override
	public ConjuntoTDA claves() {
		ConjuntoTDA c = new ImpConjunto();
		c.inicializar();
		NodoClave aux = origen;
		while( aux != null) {
			c.agregar(aux.clave);
			aux = aux.sigClave;
		}
		return c;
	}

}
