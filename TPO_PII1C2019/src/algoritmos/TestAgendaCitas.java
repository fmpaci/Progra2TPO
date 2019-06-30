package algoritmos;
import tdas.AgendaCitasTDA;
import tdas.ConjuntoTDA;
import tdas.ColaPrioridadTDA;
import tdas.ColaTDA;

public class TestAgendaCitas {

	public static void main(String[] args) {
		AgendaCitasTDA citas = new implementaciones.AgendaCitas();
		ConjuntoTDA abogados = new implementaciones.Conjunto();
		ConjuntoTDA fechas = new implementaciones.Conjunto();
		ColaTDA cola = new implementaciones.Cola();
		String aux = "lol";
		//aux = null;
		abogados.inicializar();
		citas.inicializar();
		
		citas.agregarNuevoDia("Alberto", "hoy", "23/06/2019");		
		citas.agregarNuevoDia("juan", "hoy", "23/06/2019");
		citas.agregarNuevoDia("Pedro", "hoy", "23/06/2019");
		citas.agregarNuevoDia("Ramon", "hoy", "23/06/2019");
		
		citas.agregarNuevoDia("Alberto", "mañana", "24/06/2019");		
		citas.agregarNuevoDia("juan", "mañana", "24/06/2019");
		citas.agregarNuevoDia("Pedro", "mañana", "24/06/2019");
		citas.agregarNuevoDia("Ramon", "mañana", "24/06/2019");
		
		
		citas.agregarNuevoDia("Alberto", "pasado", "25/06/2019");		
		citas.agregarNuevoDia("juan", "pasado", "25/06/2019");
		citas.agregarNuevoDia("Pedro", "pasado", "25/06/2019");
		citas.agregarNuevoDia("Ramon", "pasado", "25/06/2019");
		
		
		citas.agregarNuevaCita("Alberto", "24/06/2019", "1300", "Cliente1");
		citas.agregarNuevaCita("Alberto", "24/06/2019", "1200", "Cliente2");
		citas.agregarNuevaCita("Alberto", "24/06/2019", "1100", "Cliente3");
		citas.agregarNuevaCita("Alberto", "24/06/2019", "1000", "Cliente4");
		
		citas.agregarNuevaCita("Alberto", "25/06/2019", "1000", "Cliente5");
		citas.agregarNuevaCita("Alberto", "25/06/2019", "1100", "Cliente6");
		citas.agregarNuevaCita("Alberto", "25/06/2019", "1200", "Cliente7");
		
		citas.agregarNuevaCita("juan", "23/06/2019", "1500", "Cliente3");
		citas.agregarNuevaCita("juan", "23/06/2019", "1500", "Cliente4");
		citas.agregarNuevaCita("Pedro", "23/06/2019", "1000", "Cliente5");
		citas.agregarNuevaCita("Ramon", "24/06/2019", "1030", "Cliente6");
		
		/*Prueba de conjunto Fechas*/
		fechas = citas.fechas("Alberto");
		while(!fechas.conjuntoVacio()) {
			aux = fechas.elegir();
			System.out.println(aux);
			fechas.sacar(aux);
		}
		
		
		
		/*Prueba de Cola de turnos*/
		cola = citas.turnos("Alberto", "24/06/2019");
		
		while(!cola.colaVacia()) {
			System.out.println(cola.primero());
			cola.desacolar();
		}
		
		
		
		/*
		citas.eliminarFecha("Alberto", "24/06/2019");
		
		if(citas.existeCita( "Alberto", "24/06/2019", "1100")){
			System.out.println(citas.clienteEnCita( "Alberto", "24/06/2019", "1100"));//cliente1
		}else{
			System.out.println("FechaBorrada");
		}

		
		if(citas.existeCita( "Alberto", "25/06/2019", "1200")){
			System.out.println(citas.clienteEnCita( "Alberto", "25/06/2019", "1200"));
		}else {
			System.out.println("Borro cualquiera");
		}
		*/
		
		
		
		/*
		if(citas.existeCita( "Alberto", "24/06/2019", "1100")){
			System.out.println(citas.clienteEnCita( "Alberto", "24/06/2019", "1100"));//cliente1
		}

		if(citas.existeCita( "Alberto", "24/06/2019", "1300")){
			System.out.println(citas.clienteEnCita( "Alberto", "24/06/2019", "1300"));
		}
		
		if(citas.existeCita( "Ramon", "24/06/2019", "1030")){
			System.out.println(citas.clienteEnCita( "Ramon", "24/06/2019", "1030"));//cliente3
		}
		
		
		citas.eliminarCita("Alberto", "24/06/2019", "1100","Cliente2");
		
		if(citas.existeCita( "Alberto", "24/06/2019", "1100")){
			System.out.println(citas.clienteEnCita( "Alberto", "24/06/2019", "1100"));//cliente1
		}else {
			System.out.println("Cita Eliminada");
		}//cliente1}
		*/

		System.out.println("-----------------------------------------------------");
		//citas.eliminarAbogado("pedro");
		//citas.eliminarAbogado("alberto");
		//citas.eliminarAbogado("ramon");
		abogados = citas.abogados();
		
		
		while(!abogados.conjuntoVacio()){
			aux = abogados.elegir();
			System.out.println(aux);
			abogados.sacar(aux);
		}
		
		
		System.out.println("Terminado");
		
		

	}

}
