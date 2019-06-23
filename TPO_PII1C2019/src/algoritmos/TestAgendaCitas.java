package algoritmos;
import implementaciones.ImpArbolCitas;


public class TestAgendaCitas {
	public static void main(String[] args) {
		implementaciones.ImpArbolCitas arbol = new implementaciones.ImpArbolCitas();
		arbol.inicializar();
		arbol.agregar("1530", "Pedro");
		arbol.agregar("930", "Alex");
		arbol.agregar("1630", "Diego");
		arbol.eliminar("1530", "Pedro");
		System.out.println(arbol.hijoIzquierdo());
		
	}

}
