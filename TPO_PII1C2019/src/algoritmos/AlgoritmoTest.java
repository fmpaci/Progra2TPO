package algoritmos;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import implementaciones.AgendaCitas;
import tdas.AgendaCitasTDA;
import tdas.ColaPrioridadTDA;
import tdas.ConjuntoTDA;

public class AlgoritmoTest {

	Algoritmo algoritmo;
	AgendaCitasTDA agenda;

	@Before
	public void setUp() throws Exception {
		algoritmo = new Algoritmo();
		agenda = new AgendaCitas();
		agenda.inicializar();
	}

	@Test
	public void testUnAbogadoNoExistenteNoEstaDisponible() {
		// Operación
		boolean abogadoEstaDisponible = algoritmo.disponible(agenda, "un abogado no existente", "2019/01/01", "13:00");

		// Validación
		Assert.assertFalse(abogadoEstaDisponible);
	}

	@Test
	public void testUnAbogadoExistenteSinCitasEstaDisponible() {
		// Inicialización
		agenda.agregarNuevoDia("un abogado", "martes", "2019/01/01");

		// Operación
		boolean abogadoEstaDisponible = algoritmo.disponible(agenda, "un abogado", "2019/01/01", "13:00");

		// Validación
		Assert.assertTrue(abogadoEstaDisponible);
	}

	@Test
	public void testUnAbogadoExistenteSinDiaCreadoNoEstaDisponible() {
		// Inicialización
		agenda.agregarNuevoDia("un abogado", "martes", "2019/01/01");

		// Operación
		boolean abogadoEstaDisponible = algoritmo.disponible(agenda, "un abogado", "2019/01/02", "13:00");

		// Validación
		Assert.assertFalse(abogadoEstaDisponible);
	}

	@Test
	public void testUnAbogadoExistenteConCitaEseDiaYHorarioNoEstaDisponible() {
		// Inicialización
		agenda.agregarNuevoDia("un abogado", "martes", "2019/01/01");
		agenda.agregarNuevaCita("un abogado", "2019/01/01", "13:00", "un cliente");

		// Operación
		boolean abogadoEstaDisponible = algoritmo.disponible(agenda, "un abogado", "2019/01/01", "13:00");

		// Validación
		Assert.assertFalse(abogadoEstaDisponible);
	}

	@Test
	public void testConjuntoVacioAbogadosConMasCitasCuandoNoHayAbogados() {
		// Operación
		ConjuntoTDA abogadosConMasCitas = algoritmo.masCitas(agenda, "2019/01/01", "2019/01/31");

		// Validación
		Assert.assertTrue(abogadosConMasCitas.conjuntoVacio());
	}

	@Test
	public void testConjuntoVacioAbogadosConMasCitasCuandoNoHayAbogadosEnEseRangoDeFechas() {
		// Inicialización
		agenda.agregarNuevoDia("un abogado", "martes", "2019/01/01");
		agenda.agregarNuevaCita("un abogado", "2019/01/01", "12:00", "un cliente");
		agenda.agregarNuevaCita("un abogado", "2019/01/01", "13:00", "otro cliente");

		// Operación
		ConjuntoTDA abogadosConMasCitas = algoritmo.masCitas(agenda, "2019/01/02", "2019/01/31");

		// Validación
		Assert.assertTrue(abogadosConMasCitas.conjuntoVacio());
	}

	@Test
	public void testConjuntoAbogadosConMasCitasCuandoHayUnAbogadoConCitasEnElRangoDeFechas() {
		// Inicialización
		agenda.agregarNuevoDia("un abogado", "martes", "2019/01/01");
		agenda.agregarNuevaCita("un abogado", "2019/01/01", "12:00", "un cliente");
		agenda.agregarNuevaCita("un abogado", "2019/01/01", "13:00", "otro cliente");

		// Operación
		ConjuntoTDA abogadosConMasCitas = algoritmo.masCitas(agenda, "2019/01/01", "2019/01/31");
		boolean abogadosConjuntoVacioAntesDeSacarAbogado = abogadosConMasCitas.conjuntoVacio();
		String abogado = abogadosConMasCitas.elegir();
		abogadosConMasCitas.sacar(abogado);

		// Validación
		Assert.assertFalse(abogadosConjuntoVacioAntesDeSacarAbogado);
		Assert.assertEquals("un abogado", abogado);
		Assert.assertTrue(abogadosConMasCitas.conjuntoVacio());
	}

	@Test
	public void testConjuntoAbogadosConMasCitasCuandoHayUnAbogadoConDosCitasYUnoConUnaCitaEnElRangoDeFechas() {
		// Inicialización
		agenda.agregarNuevoDia("un abogado", "martes", "2019/01/01");
		agenda.agregarNuevaCita("un abogado", "2019/01/01", "12:00", "un cliente");
		agenda.agregarNuevaCita("un abogado", "2019/01/01", "13:00", "otro cliente");
		agenda.agregarNuevoDia("otro abogado", "jueves", "2019/01/03");
		agenda.agregarNuevaCita("otro abogado", "2019/01/03", "20:00", "un cliente");

		// Operación
		ConjuntoTDA abogadosConMasCitas = algoritmo.masCitas(agenda, "2019/01/02", "2019/01/31");
		String abogado = abogadosConMasCitas.elegir();
		abogadosConMasCitas.sacar(abogado);

		// Validación
		//Assert.assertEquals("un abogado", abogado); // ESTO NO ESTABA BIEN
		Assert.assertEquals("otro abogado", abogado);
		Assert.assertTrue(abogadosConMasCitas.conjuntoVacio());
	}

	@Test
	public void testConjuntoAbogadosConMasCitasCuandoHayTresAbogadoConDosCitasCadaUnoEnElRangoDeFechas() {
		// Inicialización
		agenda.agregarNuevoDia("un abogado", "miercoles", "2019/01/02");
		agenda.agregarNuevaCita("un abogado", "2019/01/02", "12:00", "un cliente");
		agenda.agregarNuevaCita("un abogado", "2019/01/02", "13:00", "otro cliente");
		agenda.agregarNuevoDia("otro abogado", "jueves", "2019/01/03");
		agenda.agregarNuevoDia("otro abogado", "viernes", "2019/01/04");
		agenda.agregarNuevaCita("otro abogado", "2019/01/03", "20:00", "un cliente");
		agenda.agregarNuevaCita("otro abogado", "2019/01/04", "20:00", "otro cliente");
		agenda.agregarNuevoDia("un ultimo abogado", "jueves", "2019/01/30");
		agenda.agregarNuevoDia("un ultimo abogado", "viernes", "2019/01/31");
		agenda.agregarNuevoDia("un ultimo abogado", "sabado", "2019/02/01");
		agenda.agregarNuevaCita("un ultimo abogado", "2019/01/30", "20:00", "un cliente");
		agenda.agregarNuevaCita("un ultimo abogado", "2019/01/31", "20:00", "otro cliente");
		agenda.agregarNuevaCita("un ultimo abogado", "2019/02/01", "20:00", "un ultimo cliente");
		List<String> abogadosEsperados = Arrays.asList("un abogado", "otro abogado", "un ultimo abogado");
		List<String> abogadosDelConjunto = new ArrayList<String>();

		// Operación
		ConjuntoTDA abogadosConMasCitas = algoritmo.masCitas(agenda, "2019/01/02", "2019/01/31");
		while (!abogadosConMasCitas.conjuntoVacio()) {
			String abogado = abogadosConMasCitas.elegir();
			abogadosConMasCitas.sacar(abogado);
			abogadosDelConjunto.add(abogado);
		}

		// Validación
		Assert.assertEquals(abogadosEsperados, abogadosDelConjunto);
	}

	@Test
	public void testAbogadoUltimaVezCuandoLaAgendaEstaVaciaDeberiaDevolverVacio() {
		// Operación
		String abogado = algoritmo.abogadoUltimaVez(agenda, "un cliente");

		// Validación
		Assert.assertEquals("", abogado);
	}

	@Test
	public void testAbogadoUltimaVezCuandoNadieAtiendeAlClienteDeberiaDevolverVacio() {
		// Inicialización
		agenda.agregarNuevoDia("un abogado", "martes", "2019/01/01");
		agenda.agregarNuevaCita("un abogado", "2019/01/01", "13:00", "un cliente");
		agenda.agregarNuevoDia("otro abogado", "miercoles", "2019/01/02");
		agenda.agregarNuevaCita("otro abogado", "2019/01/02", "14:00", "un cliente");

		// Operación
		String abogado = algoritmo.abogadoUltimaVez(agenda, "un cliente no atendido");

		// Validación
		Assert.assertEquals("", abogado);
	}

	@Test
	public void testAbogadoUltimaVezCuandoUnAbogadoAtiendeAlClienteDeberiaDevolverUnAbogado() {
		// Inicialización
		agenda.agregarNuevoDia("un abogado", "martes", "2019/01/01");
		agenda.agregarNuevaCita("un abogado", "2019/01/01", "13:00", "un cliente");
		agenda.agregarNuevoDia("otro abogado", "miercoles", "2019/01/02");
		agenda.agregarNuevaCita("otro abogado", "2019/01/02", "14:00", "otro cliente");
		
		// Operación
		String abogado = algoritmo.abogadoUltimaVez(agenda, "un cliente");

		// Validación
		Assert.assertEquals("un abogado", abogado);
	}

	@Test
	public void testAbogadoUltimaVezCuandoOtroAbogadoAtiendeUltimoAlClienteDeberiaDevolverOtroAbogado() {
		// Inicialización
		agenda.agregarNuevoDia("un abogado", "martes", "2019/01/01");
		agenda.agregarNuevaCita("un abogado", "2019/01/01", "13:00", "un cliente");
		agenda.agregarNuevoDia("un abogado", "miercoles", "2019/01/02");
		agenda.agregarNuevaCita("un abogado", "2019/01/02", "13:00", "otro cliente");
		agenda.agregarNuevoDia("otro abogado", "miercoles", "2019/01/02");
		agenda.agregarNuevaCita("otro abogado", "2019/01/02", "12:00", "un cliente");
		
		// Operación
		String abogado = algoritmo.abogadoUltimaVez(agenda, "un cliente");

		// Validación
		Assert.assertEquals("otro abogado", abogado);
	}

	@Test
	public void testObtenerCitasCuandoLaAgendaEstaVaciaDeberiaDevolverMatrizVacia() {
		// Operación
		String[][] citas = algoritmo.obtenerCitas(agenda, "un abogado", "2018/12/31");

		// Validación
		Assert.assertEquals(0, citas.length);
	}

	@Test
	public void testObtenerCitasCuandoLaAgendaTieneUnAbogadoConCitasOtraSemanaDeberiaDevolverMatrizVacia() {
		// Inicialización
		agenda.agregarNuevoDia("un abogado", "lunes", "2019/01/07");
		agenda.agregarNuevaCita("un abogado", "2019/01/07", "13:30", "un cliente");
		agenda.agregarNuevoDia("un abogado", "martes", "2019/01/08");
		agenda.agregarNuevaCita("un abogado", "2019/01/08", "14:30", "otro cliente");
		agenda.agregarNuevoDia("un abogado", "miercoles", "2019/01/09");
		agenda.agregarNuevaCita("un abogado", "2019/01/09", "15:30", "un ultimo cliente");

		// Operación
		String[][] citas = algoritmo.obtenerCitas(agenda, "un abogado", "2019/12/31");

		// Validación
		Assert.assertEquals(0, citas.length);
	}

	@Test
	public void testObtenerCitasCuandoLaAgendaTieneTresCitasEsaSemanaYUnaOtraSemanaDeberiaDevolverMatrizConDosCitas() {
		// Inicialización
		agenda.agregarNuevoDia("un abogado", "miercoles", "2019/01/02");
		agenda.agregarNuevaCita("un abogado", "2019/01/02", "10:30", "un cliente");
		agenda.agregarNuevoDia("otro abogado", "miercoles", "2019/01/02");
		agenda.agregarNuevaCita("otro abogado", "2019/01/02", "11:30", "un cliente diferente");
		agenda.agregarNuevoDia("un abogado", "martes", "2019/01/01");
		agenda.agregarNuevaCita("un abogado", "2019/01/01", "14:30", "otro cliente");
		agenda.agregarNuevaCita("un abogado", "2019/01/01", "14:00", "otro cliente mas");
		agenda.agregarNuevoDia("un abogado", "lunes", "2019/01/07");
		agenda.agregarNuevaCita("un abogado", "2019/01/07", "13:30", "un ultimo cliente");
		String[] primeraCitaEsperada = new String[] { "martes", "14:00", "otro cliente mas" };
		String[] segundaCitaEsperada = new String[] { "martes", "14:30", "otro cliente" };
		String[] terceraCitaEsperada = new String[] { "miercoles", "10:30", "un cliente" };

		// Operación
		String[][] citas = algoritmo.obtenerCitas(agenda, "un abogado", "2019/12/31");

		// Validación
		Assert.assertEquals(3, citas.length);
		Assert.assertArrayEquals(primeraCitaEsperada, citas[0]);
		Assert.assertArrayEquals(segundaCitaEsperada, citas[1]);
		Assert.assertArrayEquals(terceraCitaEsperada, citas[2]);
	}

	@Test
	public void testConQuienSeReunioCuandoLaAgendaEstaVaciaDeberiaDevolverMatrizVacia() {
		// Operación
		String[][] conQuienSeReunio = algoritmo.conQuienSeReunio(agenda, "un cliente");

		// Validación
		Assert.assertEquals(0, conQuienSeReunio.length);
	}

	@Test
	public void testConQuienSeReunioCuandoNoSeReunioConEseClienteDeberiaDevolverMatrizVacia() {
		// Inicialización
		agenda.agregarNuevoDia("un abogado", "martes", "2019/01/01");
		agenda.agregarNuevaCita("un abogado", "2019/01/01", "12:30", "un cliente");

		// Operación
		String[][] reuniones = algoritmo.conQuienSeReunio(agenda, "otro cliente");

		// Validación
		Assert.assertEquals(0, reuniones.length);
	}

	@Test
	public void testConQuienSeReunioCuandoUnAbogadoSeReunioConEseClienteDeberiaDevolverMatrizConValores() {
		// Inicialización
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

		// Validación
		Assert.assertEquals(3, reuniones.length);
		Assert.assertArrayEquals(primeraReunionEsperada, reuniones[0]);
		Assert.assertArrayEquals(segundaReunionEsperada, reuniones[1]);
		Assert.assertArrayEquals(terceraReunionEsperada, reuniones[2]);
	}

	@Test
	public void testConQuienSeReunioCuandoDosAbogadoSeReunieronConEseClienteDeberiaDevolverMatrizConValores() {
		// Inicialización
		agenda.agregarNuevoDia("un abogado", "martes", "2019/01/01");
		agenda.agregarNuevaCita("un abogado", "2019/01/01", "09:00", "un cliente");
		agenda.agregarNuevaCita("un abogado", "2019/01/01", "10:30", "un cliente");
		agenda.agregarNuevoDia("otro abogado", "martes", "2019/01/01");
		agenda.agregarNuevaCita("otro abogado", "2019/01/01", "09:00", "otro cliente");
		agenda.agregarNuevaCita("otro abogado", "2019/01/01", "10:30", "un cliente");
		agenda.agregarNuevoDia("un abogado", "lunes", "2018/12/31");
		agenda.agregarNuevaCita("un abogado", "2018/12/31", "11:30", "un cliente");
		agenda.agregarNuevaCita("un abogado", "2018/12/31", "10:30", "otro cliente");
		String[] primeraReunionEsperada = new String[] { "un abogado", "2018/12/31", "11:30" };
		String[] segundaReunionEsperada = new String[] { "un abogado", "2019/01/01", "09:00" };
		String[] terceraReunionEsperada = new String[] { "otro abogado", "2019/01/01", "09:30" };
		String[] cuartaReunionEsperada = new String[] { "un abogado", "2019/01/01", "10:30" };

		// Operación
		String[][] reuniones = algoritmo.conQuienSeReunio(agenda, "un cliente");

		// Validación
		Assert.assertEquals(4, reuniones.length);
		Assert.assertArrayEquals(primeraReunionEsperada, reuniones[0]);
		Assert.assertArrayEquals(segundaReunionEsperada, reuniones[1]);
		Assert.assertArrayEquals(terceraReunionEsperada, reuniones[2]);
		Assert.assertArrayEquals(cuartaReunionEsperada, reuniones[3]);
	}

	@Test
	public void testLibresTotalCuandoLaAgendaEstaVaciaDeberiaDevolverColaVacia() {
		// Operación
		ColaPrioridadTDA horariosLibres = algoritmo.libresTotal(agenda, "2018/12/31");

		// Validación
		Assert.assertTrue(horariosLibres.colaVacia());
	}

	@Test
	public void testLibresTotalCuandoLaAgendaNoTieneDiasEsaSemanaDeberiaDevolverColaVacia() {
		// Inicialización
		agenda.agregarNuevoDia("un abogado", "lunes", "2019/01/07");
		agenda.agregarNuevoDia("un abogado", "martes", "2019/01/08");
		agenda.agregarNuevoDia("un abogado", "miercoles", "2019/01/09");
		agenda.agregarNuevoDia("un abogado", "jueves", "2019/01/10");

		// Operación
		ColaPrioridadTDA horariosLibres = algoritmo.libresTotal(agenda, "2018/12/31");

		// Validación
		Assert.assertTrue(horariosLibres.colaVacia());
	}

	@Test
	public void testLibresTotalCuandoLaAgendaTieneUnDiaTotalmenteLibreEsaSemanaDeberiaDevolverColaConTodosLosHorarios() {
		// Inicialización
		agenda.agregarNuevoDia("un abogado", "lunes", "2019/01/07");
		agenda.agregarNuevoDia("un abogado", "martes", "2019/01/08");
		agenda.agregarNuevoDia("un abogado", "miercoles", "2019/01/09");
		agenda.agregarNuevoDia("un abogado", "jueves", "2019/01/10");
		agenda.agregarNuevoDia("otro abogado", "martes", "2019/01/01");

		// Operación
		ColaPrioridadTDA horariosLibres = algoritmo.libresTotal(agenda, "2018/12/31");
		int cantidadElementosCola = 0;
		String primerAbogado = horariosLibres.primero();
		String ultimoAbogado = "";
		while (!horariosLibres.colaVacia()) {
			ultimoAbogado = horariosLibres.primero();
			horariosLibres.desacolar();
			cantidadElementosCola++;
		}

		// Validación
		/**
		 * 24 horas Turnos de media hora 24*2 = 48
		 */
		Assert.assertEquals(48, cantidadElementosCola);
		Assert.assertEquals("otro abogado", primerAbogado);
		Assert.assertEquals("otro abogado", ultimoAbogado);
	}

	@Test
	public void testLibresTotalCuandoLaAgendaTieneUnAbogadoLibrePrimerHorarioYOtroLibreUltimoHorarioEsaSemana() {
		// Inicialización
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
		while (!horariosLibres.colaVacia()) {
			ultimoAbogado = horariosLibres.primero();
			horariosLibres.desacolar();
			cantidadElementosCola++;
		}

		// Validación

		/**
		 * 48 turnos por día 2 abogados 2 turnos no disponibles (48*2)-2 = 94
		 */
		Assert.assertEquals(94, cantidadElementosCola);
		Assert.assertEquals("otro abogado", primerAbogado);
		Assert.assertEquals("un abogado", ultimoAbogado);
	}

}
