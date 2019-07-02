package algoritmos;

//import org.junit.Assert;

import implementaciones.AgendaCitas;
import implementaciones.ColaPrioridad;
import tdas.ConjuntoTDA;
import tdas.ColaPrioridadTDA;

public class TestVariosFPA {

	public static void main(String[] args) {
		implementaciones.AgendaCitas citas = new implementaciones.AgendaCitas();
		IAlgoritmo algo = new Algoritmo(); 
		citas.inicializar();
		
		Algoritmo algoritmo = new Algoritmo();
		AgendaCitas agenda = new AgendaCitas();
		agenda.inicializar();
		
		
		agenda.agregarNuevoDia("un abogado", "martes", "2019/01/01");
		agenda.agregarNuevaCita("un abogado", "2019/01/01", "09:00", "un cliente");
		agenda.agregarNuevaCita("un abogado", "2019/01/01", "09:30", "un cliente");
		agenda.agregarNuevoDia("un abogado", "lunes", "2018/12/31");
		agenda.agregarNuevaCita("un abogado", "2018/12/31", "11:30", "un cliente");
		agenda.agregarNuevaCita("un abogado", "2018/12/31", "10:30", "otro cliente");
		String[] primeraReunionEsperada = new String[] { "un abogado", "2018/12/31", "11:30" };
		String[] segundaReunionEsperada = new String[] { "un abogado", "2019/01/01", "09:00" };
		String[] terceraReunionEsperada = new String[] { "un abogado", "2019/01/01", "09:30" };
		
		// Operación
		String[][] reuniones = algoritmo.conQuienSeReunio(agenda, "un cliente");

		System.out.println(reuniones.length);
		
		System.out.println(reuniones[0][0]);
		System.out.println(reuniones[0][1]);
		System.out.println(reuniones[0][2]);
		
		System.out.println(reuniones[1][0]);
		System.out.println(reuniones[1][1]);
		System.out.println(reuniones[1][2]);
		
		System.out.println(reuniones[2][0]);
		System.out.println(reuniones[2][1]);
		System.out.println(reuniones[2][2]);
	
		ColaPrioridadTDA horariosFree = new ColaPrioridad();
		horariosFree.inicializar();
		horariosFree = algoritmo.libresTotal(agenda, "2018/12/31");
		while(!horariosFree.colaVacia()) {
			System.out.println(horariosFree.primero());
			System.out.println(horariosFree.prioridad());
			horariosFree.desacolar();
		}
	}
	

}
