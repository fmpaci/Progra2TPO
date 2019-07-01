package implementaciones;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class ColaPrioridadTest {

	ColaPrioridad colaPrioridad;

	@Before
	public void setUp() throws Exception {
		colaPrioridad = new ColaPrioridad();
		colaPrioridad.inicializar();
	}

	@Test
	public void testColaVacia() {
		// Operación
		boolean colaPrioridadVacia = colaPrioridad.colaVacia();

		// Validación
		Assert.assertTrue(colaPrioridadVacia);
	}

	@Test
	public void testColaNoVacia() {
		// Inicialización
		colaPrioridad.acolar("un abogado", "10:30");

		// Operación
		boolean colaPrioridadVacia = colaPrioridad.colaVacia();

		// Validación
		Assert.assertFalse(colaPrioridadVacia);
	}

	@Test
	public void testPrimerValor() {
		// Inicialización
		colaPrioridad.acolar("un abogado que atiende 10am", "10:30");
		colaPrioridad.acolar("un abogado que atiende 12am", "12:00");
		colaPrioridad.acolar("un abogado que atiende 9am", "09:00");
		colaPrioridad.acolar("un abogado que atiende 9pm", "21:00");

		// Operación
		String abogadoQueAtiendePrimero = colaPrioridad.primero();

		// Validación
		Assert.assertEquals("un abogado que atiende 9am", abogadoQueAtiendePrimero);
	}

	@Test
	public void testSegundoValor() {
		// Inicialización
		colaPrioridad.acolar("un abogado que atiende 10.30am", "10:30");
		colaPrioridad.acolar("un abogado que atiende 12am", "12:00");
		colaPrioridad.acolar("un abogado que atiende 9am", "09:00");
		colaPrioridad.acolar("un abogado que atiende 9pm", "21:00");

		// Operación
		colaPrioridad.desacolar();
		String abogadoQueAtiendeSegundo = colaPrioridad.primero();

		// Validación
		Assert.assertEquals("un abogado que atiende 10.30am", abogadoQueAtiendeSegundo);
	}

	@Test
	public void testDosValoresEnLaMismaPrioridad() {
		// Inicialización
		colaPrioridad.acolar("un abogado que atiende 10.30am", "10:30");
		colaPrioridad.acolar("un abogado que atiende 12am", "12:00");
		colaPrioridad.acolar("un abogado que atiende 9am", "09:00");
		colaPrioridad.acolar("un abogado que atiende 9pm", "21:00");
		colaPrioridad.acolar("otro abogado que atiende 9am", "09:00");

		// Operación
		String unAbogadoQueAtiendeEnElPrimerHorario = colaPrioridad.primero();
		colaPrioridad.desacolar();
		String otroAbogadoQueAtiendeEnElPrimerHorario = colaPrioridad.primero();
		colaPrioridad.desacolar();
		String unAbogadoQueAtiendeEnElSegundoHorario = colaPrioridad.primero();

		// Validación
		Assert.assertEquals("un abogado que atiende 9am", unAbogadoQueAtiendeEnElPrimerHorario);
		Assert.assertEquals("otro abogado que atiende 9am", otroAbogadoQueAtiendeEnElPrimerHorario);
		Assert.assertEquals("un abogado que atiende 10.30am", unAbogadoQueAtiendeEnElSegundoHorario);
	}

	@Test
	public void testPrioridad() {
		// Inicialización
		colaPrioridad.acolar("un abogado que atiende 10.30am", "10:30");
		colaPrioridad.acolar("un abogado que atiende 12am", "12:00");
		colaPrioridad.acolar("un abogado que atiende 9am", "09:00");
		colaPrioridad.acolar("un abogado que atiende 9pm", "21:00");
		colaPrioridad.acolar("otro abogado que atiende 9am", "09:00");

		// Operación
		String primeraPrioridad = colaPrioridad.prioridad();
		colaPrioridad.desacolar();
		String segundaPrioridad = colaPrioridad.prioridad();
		colaPrioridad.desacolar();
		String terceraPrioridad = colaPrioridad.prioridad();
		colaPrioridad.desacolar();
		String cuartaPrioridad = colaPrioridad.prioridad();
		colaPrioridad.desacolar();
		String quintaPrioridad = colaPrioridad.prioridad();
		colaPrioridad.desacolar();
		
		// Validación
		Assert.assertEquals("09:00", primeraPrioridad);
		Assert.assertEquals("09:00", segundaPrioridad);
		Assert.assertEquals("10:30", terceraPrioridad);
		Assert.assertEquals("12:00", cuartaPrioridad);
		Assert.assertEquals("21:00", quintaPrioridad);
	}

}
