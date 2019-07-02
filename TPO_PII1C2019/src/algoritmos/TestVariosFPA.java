package algoritmos;


import implementaciones.AgendaCitas;

import tdas.ColaPrioridadTDA;

public class TestVariosFPA {

	public static void main(String[] args) {
		System.out.println("iniciando");
		Algoritmo algoritmo = new Algoritmo();
		AgendaCitas agenda = new AgendaCitas();
		agenda.inicializar();
		
		agenda.agregarNuevoDia("un abogado", "lunes", "2019/01/07");
		agenda.agregarNuevoDia("un abogado", "martes", "2019/01/08");
		agenda.agregarNuevoDia("un abogado", "miercoles", "2019/01/09");
		agenda.agregarNuevoDia("un abogado", "jueves", "2019/01/10");
		agenda.agregarNuevoDia("un abogado", "martes", "2019/01/01");
		
		agenda.agregarNuevaCita("un abogado", "2019/01/01", "00:00", "un cliente");
		
		
		agenda.agregarNuevoDia("otro abogado", "martes", "2019/01/01");
		agenda.agregarNuevaCita("otro abogado", "2019/01/01", "23:30", "un cliente");

		// Operación
		ColaPrioridadTDA horariosLibres = algoritmo.libresTotal(agenda, "2018/12/31");
		int cantidadElementosCola = 0;
		String primerAbogado = horariosLibres.primero();
		String ultimoAbogado = "";
		int i = 1;
		while (!horariosLibres.colaVacia()) {
			ultimoAbogado = horariosLibres.primero();
			System.out.println(i +horariosLibres.primero() +" " + horariosLibres.prioridad());
			i++;
			horariosLibres.desacolar();
			cantidadElementosCola++;
		}

		// Validación

		/**
		 * 48 turnos por día 2 abogados 2 turnos no disponibles (48*2)-2 = 94
		 */
		
		
		
		
		System.out.println(cantidadElementosCola);
		System.out.println(primerAbogado);//"otro abogado
		System.out.println(ultimoAbogado);//"un abogado"
	}
	

}
