package algoritmos;


public class TestConjunto {

	public static void main(String[] args) {
		implementaciones.impConjunto conjHandle = new implementaciones.impConjunto();
		
		conjHandle.inicializar();
		conjHandle.agregar("1");
		conjHandle.agregar("2");
		conjHandle.agregar("3");
		conjHandle.agregar("4");
		conjHandle.agregar("5");
		
		System.out.println(conjHandle.elegir());
		
		System.out.println("1-".concat( Boolean.toString(conjHandle.pertenece("1"))) );
		System.out.println("2-".concat( Boolean.toString(conjHandle.pertenece("2"))) );
		System.out.println("3-".concat( Boolean.toString(conjHandle.pertenece("3"))) );
		System.out.println("4-".concat( Boolean.toString(conjHandle.pertenece("4"))) );
		System.out.println("5-".concat( Boolean.toString(conjHandle.pertenece("5"))) );
		
		System.out.println("--------------------------------------------------");
		conjHandle.sacar("1");
		System.out.println("1-".concat( Boolean.toString(conjHandle.pertenece("1"))) );
		System.out.println("2-".concat( Boolean.toString(conjHandle.pertenece("2"))) );
		System.out.println("3-".concat( Boolean.toString(conjHandle.pertenece("3"))) );
		System.out.println("4-".concat( Boolean.toString(conjHandle.pertenece("4"))) );
		System.out.println("5-".concat( Boolean.toString(conjHandle.pertenece("5"))) );
		

		System.out.println("--------------------------------------------------");
		conjHandle.sacar("4");
		System.out.println("1-".concat( Boolean.toString(conjHandle.pertenece("1"))) );
		System.out.println("2-".concat( Boolean.toString(conjHandle.pertenece("2"))) );
		System.out.println("3-".concat( Boolean.toString(conjHandle.pertenece("3"))) );
		System.out.println("4-".concat( Boolean.toString(conjHandle.pertenece("4"))) );
		System.out.println("5-".concat( Boolean.toString(conjHandle.pertenece("5"))) );
		

		System.out.println("--------------------------------------------------");
		conjHandle.sacar("3");
		System.out.println("1-".concat( Boolean.toString(conjHandle.pertenece("1"))) );
		System.out.println("2-".concat( Boolean.toString(conjHandle.pertenece("2"))) );
		System.out.println("3-".concat( Boolean.toString(conjHandle.pertenece("3"))) );
		System.out.println("4-".concat( Boolean.toString(conjHandle.pertenece("4"))) );
		System.out.println("5-".concat( Boolean.toString(conjHandle.pertenece("5"))) );
		

		System.out.println("--------------------------------------------------");
		conjHandle.sacar("5");
		System.out.println("1-".concat( Boolean.toString(conjHandle.pertenece("1"))) );
		System.out.println("2-".concat( Boolean.toString(conjHandle.pertenece("2"))) );
		System.out.println("3-".concat( Boolean.toString(conjHandle.pertenece("3"))) );
		System.out.println("4-".concat( Boolean.toString(conjHandle.pertenece("4"))) );
		System.out.println("5-".concat( Boolean.toString(conjHandle.pertenece("5"))) );

		
		System.out.println("--------------------------------------------------");
		conjHandle.sacar("2");
		System.out.println("1-".concat( Boolean.toString(conjHandle.pertenece("1"))) );
		System.out.println("2-".concat( Boolean.toString(conjHandle.pertenece("2"))) );
		System.out.println("3-".concat( Boolean.toString(conjHandle.pertenece("3"))) );
		System.out.println("4-".concat( Boolean.toString(conjHandle.pertenece("4"))) );
		System.out.println("5-".concat( Boolean.toString(conjHandle.pertenece("5"))) );

		/*agregar un mensaje para que aparezca en git*/
	}

}
