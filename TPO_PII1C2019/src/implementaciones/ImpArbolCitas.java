package implementaciones;

import tdas.ArbolCitasTDA;


public class ImpArbolCitas implements ArbolCitasTDA {
	
	NodoArbol nArbol;	
	
	public String Raiz() {
		return nArbol.hora;
	}
	
	@Override
	public void inicializar() {
		nArbol = null;
	}

	@Override
	public void agregar(String hora, String cliente) {
		
		if(nArbol == null) {
			nArbol = new NodoArbol();
			nArbol.hora = hora;
			nArbol.cliente = cliente;
			nArbol.hijoIzq = new ImpArbolCitas();
			nArbol.hijoIzq.inicializar();
			nArbol.hijoDer = new ImpArbolCitas();
			nArbol.hijoDer.inicializar();
		}
		else if(Integer.valueOf(nArbol.hora) > Integer.valueOf(hora)) 
			nArbol.hijoIzq.agregar(hora, cliente);
		else if(Integer.valueOf(nArbol.hora) < Integer.valueOf(hora)) 
			nArbol.hijoDer.agregar(hora, cliente);
	}

	@Override
	public void eliminar(String hora, String cliente) {
		if(nArbol.hora != null) {
			if(hora.equals(nArbol.hora) && nArbol.hijoIzq.arbolVacio() && nArbol.hijoDer.arbolVacio() && nArbol.cliente.equals(cliente)){
				nArbol.cliente = null;
				nArbol.hora = null;
			}
			else if(nArbol.hora.equals(hora) && nArbol.cliente.equals(cliente) && !nArbol.hijoIzq.arbolVacio()) {				
				ArbolCitasTDA raiz = this.mayor(nArbol.hijoIzq);
				raiz.hijoIzquierdo().eliminar(hora, cliente);
			}
			else if(nArbol.hora.equals(hora) && nArbol.cliente.equals(cliente) && nArbol.hijoIzq.arbolVacio()) {
				ArbolCitasTDA raiz = this.menor(nArbol.hijoIzq);
				raiz.hijoDerecho().eliminar(hora, cliente);
			}
			else if(Integer.valueOf(nArbol.hora) < Integer.valueOf(hora)) {
				nArbol.hijoDer.eliminar(hora, cliente);
			}
			else {
				nArbol.hijoIzq.eliminar(hora, cliente);
			}
		}
	}

	@Override
	public String hora() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String cliente() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArbolCitasTDA hijoDerecho() {
		return raiz.hijoDer;
	}

	@Override
	public ArbolCitasTDA hijoIzquierdo() {
		return raiz.hijoIzq;
	}

	@Override
	public boolean arbolVacio() {
		return nArbol == null;
	}

	private ArbolCitasTDA mayor(ArbolCitasTDA arbol) {
		if(arbol.hijoDerecho().arbolVacio())
			return arbol;
		else 
			return mayor(arbol.hijoDerecho());
	}
	private ArbolCitasTDA menor(ArbolCitasTDA arbol) {
		if(arbol.hijoIzquierdo().arbolVacio())
			return arbol;
		else 
			return mayor(arbol.hijoIzquierdo());
	}
}
