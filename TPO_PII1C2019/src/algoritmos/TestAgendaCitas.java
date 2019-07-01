package algoritmos;
import tdas.AgendaCitasTDA;
import tdas.ConjuntoTDA;
import tdas.ColaPrioridadTDA;

public class TestAgendaCitas {

	public static void main(String[] args) {
		AgendaCitasTDA citas = new implementaciones.ImpAgendaCitas();
		ConjuntoTDA abogados = new implementaciones.ImpConjunto();
		String aux = "lol";
		//aux = null;
		abogados.inicializar();
		citas.inicializar();
		
		citas.agregarNuevoDia("Alberto", "hoy", "23/06/2019");
		citas.agregarNuevoDia("Alberto", "mañana", "24/06/2019");
		citas.agregarNuevoDia("juan", "hoy", "23/06/2019");
		citas.agregarNuevoDia("Juan", "mañana", "24/06/2019");
		citas.agregarNuevoDia("Pedro", "hoy", "23/06/2019");
		citas.agregarNuevoDia("Ramon", "hoy", "23/06/2019");
		citas.agregarNuevoDia("Jose", "hoy", "23/06/2019");
		citas.agregarNuevoDia("Matias", "hoy", "23/06/2019");
		
		
		citas.agregarNuevaCita("Alberto", "23/06/2019", "1000", "Cliente1");
		//citas.agregarNuevaCita("Alberto", "24/06/2019", "1300", "Cliente2");
		citas.agregarNuevaCita("juan", "23/06/2019", "1500", "Cliente3");
		//citas.agregarNuevaCita("juan", "23/06/2019", "1500", "Cliente4");
		citas.agregarNuevaCita("Ramon", "23/06/2019", "1000", "Cliente5");
		//citas.agregarNuevaCita("Ramon", "24/06/2019", "1030", "Cliente6");
		citas.agregarNuevaCita("Jose", "23/06/2019", "1300", "Cliente7");
		//citas.agregarNuevaCita("Jose", "23/06/2019", "1030", "Cliente8");
		citas.agregarNuevaCita("Matias", "23/06/2019", "1100", "Cliente9");
		//citas.agregarNuevaCita("Matias", "25/06/2019", "0900", "Cliente1");
		
		if(citas.existeCita( "juan" ,"23/06/2019", "1500")){
			System.out.println(citas.clienteEnCita( "juan" ,"23/06/2019", "1500"));
		}
		
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
