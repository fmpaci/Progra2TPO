package implementaciones;

import tdas.ArbolCitasTDA;


public class ArbolCitas implements ArbolCitasTDA {
	
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
		
		if(this.arbolVacio()) {
			nArbol = new NodoArbol();
			nArbol.hora = hora;
			nArbol.cliente = cliente;
			nArbol.hijoIzq = new ArbolCitas();
			nArbol.hijoIzq.inicializar();
			nArbol.hijoDer = new ArbolCitas();
			nArbol.hijoDer.inicializar();
		}
		else if(Integer.valueOf(nArbol.hora) > Integer.valueOf(hora)) 
			nArbol.hijoIzq.agregar(hora, cliente);
		else if(Integer.valueOf(nArbol.hora) < Integer.valueOf(hora)) 
			nArbol.hijoDer.agregar(hora, cliente);
	}

	@Override
	public void eliminar(String hora, String cliente) {
		if(!this.arbolVacio()) {
			if(this.hijoIzquierdo().arbolVacio() && this.hijoDerecho().arbolVacio()){
				//System.out.println("5");
				nArbol = null;
			}
			else if(this.hora().equals(hora) && !this.hijoIzquierdo().arbolVacio()) {	
				//System.out.println("4");
				String[] datos = this.mayor(this.hijoIzquierdo());
				if (this.cliente().equalsIgnoreCase(cliente)) {
					//System.out.println(cliente + " es cliente");
					nArbol.hora = datos[0];
					nArbol.cliente = datos[1];
				}
				this.hijoIzquierdo().eliminar(datos[0], datos[1]);
			}
			else if(this.hora().equals(hora) && !this.hijoDerecho().arbolVacio()) {
				//System.out.println("3");
				String[] datos = this.menor(this.hijoDerecho());
				if (this.cliente().equalsIgnoreCase(cliente)) {
					nArbol.hora = datos[0];
					nArbol.cliente = datos[1];
				}
				this.hijoDerecho().eliminar(datos[0], datos[1]);
			}
			else if(Integer.valueOf(this.hora()) < Integer.valueOf(hora)) {
				//System.out.println("2");
				this.hijoDerecho().eliminar(hora, cliente);
			}
			else {
				//System.out.println("1");
				this.hijoIzquierdo().eliminar(hora, cliente);
			}
		}
	}

	@Override
	public String hora() {
		return nArbol.hora;
	}

	@Override
	public String cliente() {
		return nArbol.cliente;
	}

	@Override
	public ArbolCitasTDA hijoDerecho() {
		if (nArbol != null) {
			return nArbol.hijoDer;
		} else {
			return null;
		}
	}

	@Override
	public ArbolCitasTDA hijoIzquierdo() {
		if (nArbol != null) {
			return nArbol.hijoIzq;
		} else {
			return null;
		}
	}

	@Override
	public boolean arbolVacio() {
		return nArbol == null;
	}

	private String[] mayor(ArbolCitasTDA arbol) {
		if(arbol.hijoDerecho().arbolVacio()) {
			String[] datos = { arbol.hora(), arbol.cliente() };
			return datos;
		} else 
			return mayor(arbol.hijoDerecho());
	}
	private String[] menor(ArbolCitasTDA arbol) {
		if(arbol.hijoIzquierdo().arbolVacio()) {
			String[] datos = { arbol.hora(), arbol.cliente() };
			return datos;
		} else 
			return menor(arbol.hijoIzquierdo());
	}
	
	public String toString() {
		if (!this.arbolVacio()) {
			String izq = this.hijoIzquierdo().toString();
			String der = this.hijoDerecho().toString();
			return "(" + this.hora() + ", " + this.cliente() + ") -> { " + izq + "," + der + " } "; 
		}else {
			return "";
		}
	}

	
}
