package algoritmos;

import tdas.ConjuntoTDA;

public class TestVariosFPA {

	public static void main(String[] args) {
		implementaciones.ImpAgendaCitas citas = new implementaciones.ImpAgendaCitas();
		ConjuntoTDA abogados = new implementaciones.Conjunto();
		String aux = "lol";
		//aux = null;
		abogados.inicializar();
		citas.inicializar();
		
		citas.agregarNuevoDia("Alberto", "hoy", "23/06/2019");
		citas.agregarNuevoDia("Alberto", "mañana", "24/06/2019");
		citas.agregarNuevoDia("Juan", "hoy", "23/06/2019");
		citas.agregarNuevoDia("Juan", "mañana", "24/06/2019");
		citas.agregarNuevoDia("pedro", "hoy", "23/06/2019");
		citas.agregarNuevoDia("Ramon", "hoy", "23/06/2019");
		citas.agregarNuevoDia("Jose", "hoy", "23/06/2019");
		citas.agregarNuevoDia("Matias", "hoy", "23/06/2019");
		
		citas.eliminarAbogado("pedro");
		abogados = citas.abogados();
		
		while(!abogados.conjuntoVacio()){
			aux = abogados.elegir();
			System.out.println(aux);
			abogados.sacar(aux);
		}
		System.out.println("Terminado");
		

	}
	

}
