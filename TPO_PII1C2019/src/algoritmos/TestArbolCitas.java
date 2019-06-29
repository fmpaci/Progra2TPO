package algoritmos;
import tdas.ArbolCitasTDA;
import implementaciones.ArbolCitas;


public class TestArbolCitas {
	public static void main(String[] args) {
		ArbolCitasTDA arbol1 = new ArbolCitas();
		arbol1.inicializar();
		arbol1.agregar("1530", "Pedro");
		arbol1.agregar("930", "Alex");
		arbol1.agregar("1030", "Diego");
		arbol1.agregar("1000", "Carlos");
		arbol1.agregar("1730", "Carlos");
		System.out.println(arbol1.toString());
		arbol1.eliminar("930", "Alex");
		System.out.println(arbol1.toString());

		ArbolCitasTDA arbol2 = new ArbolCitas();
		arbol2.inicializar();
		arbol2.agregar("1330", "a");
		arbol2.agregar("1000", "b");
		arbol2.agregar("1100", "c");
		arbol2.agregar("1530", "d");
		arbol2.agregar("1400", "e");
		arbol2.agregar("900", "f");
		arbol2.agregar("1030", "g");
		arbol2.agregar("1430", "h");
		arbol2.agregar("930", "i");
		System.out.println(arbol2);
		arbol2.eliminar("1400", "e");
		System.out.println(arbol2);
		arbol2.eliminar("1000", "b");
		System.out.println(arbol2);
		arbol2.eliminar("1330", "a");
		System.out.println(arbol2);
		arbol2.agregar("1500", "x");
		System.out.println(arbol2);
		arbol2.agregar("1200", "y");
		System.out.println(arbol2);
		arbol2.eliminar("930", "i");
		System.out.println(arbol2);
		arbol2.eliminar("1100", "c");
		System.out.println(arbol2);
		arbol2.eliminar("1500", "x");
		System.out.println(arbol2);
		
	}

}
