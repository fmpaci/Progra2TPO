package algoritmos;

public class TestColaPrioridad {

	public static void main(String[] args) {
		implementaciones.ImpColaPrioridad colaP = new implementaciones.ImpColaPrioridad();
		colaP.inicializar();
		
		colaP.acolar("Carlos", "b");
		colaP.acolar("Lucas", "c");
		colaP.acolar("Juan", "A");
		colaP.acolar("Dalton", "b");
		colaP.acolar("Mateo", "A");
		
		while(!colaP.colaVacia()) {
			System.out.println(colaP.primero());
			colaP.desacolar();
		}
		/*debería imprimir:
		 * Juan
		 * Mateo
		 * Carlos
		 * Dalton
		 * Lucas
		 * */

	}

}
