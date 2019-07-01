package implementaciones;


import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import tdas.ColaTDA;
import tdas.ConjuntoTDA;

public class AgendaCitasTest {

	AgendaCitas agendaCitas;

	@Before
	public void setUp() throws Exception {
		agendaCitas = new AgendaCitas();
		agendaCitas.inicializar();
	}

	@Test
	public void testConjuntoAbogadosVacio() {
		// Operación
		ConjuntoTDA abogados = agendaCitas.abogados();

		// Validación
		Assert.assertTrue(abogados.conjuntoVacio());
	}

	@Test
	public void testConjuntoAbogadosNoVacioDespuesDeAgregarDia() {
		// Inicialización
		agendaCitas.agregarNuevoDia("un abogado", "martes", "2019/01/01");

		// Operación
		ConjuntoTDA abogados = agendaCitas.abogados();
		boolean conjuntoAbogadosNoVacioAntesDeEliminarUno = abogados.conjuntoVacio();
		String abogado = abogados.elegir();
		abogados.sacar(abogado);

		// Validación
		Assert.assertFalse(conjuntoAbogadosNoVacioAntesDeEliminarUno);
		Assert.assertTrue(abogados.conjuntoVacio());
		Assert.assertEquals("un abogado", abogado);
	}

	@Test
	public void testConjuntoTurnosVacioConDiaAgregado() {
		// Inicialización
		agendaCitas.agregarNuevoDia("un abogado", "martes", "2019/01/01");

		// Operación
		ColaTDA turnos = agendaCitas.turnos("un abogado", "2019/01/01");

		// Validación
		Assert.assertTrue(turnos.colaVacia());
	}

	@Test
	public void testConjuntoTurnosVacioConAbogadoNoExistente() {
		// Inicialización
		agendaCitas.agregarNuevoDia("un abogado", "martes", "2019/01/01");
		agendaCitas.agregarNuevaCita("un abogado", "2019/01/01", "10:00", "un cliente");

		// Operación
		ColaTDA turnos = agendaCitas.turnos("abogado no existente", "2019/01/01");

		// Validación
		Assert.assertTrue(turnos.colaVacia());
	}

	@Test
	public void testConjuntoTurnosVacioConDiaNoExistente() {
		// Inicialización
		agendaCitas.agregarNuevoDia("un abogado", "martes", "2019/01/01");
		agendaCitas.agregarNuevaCita("un abogado", "2019/01/01", "10:00", "un cliente");

		// Operación
		ColaTDA turnos = agendaCitas.turnos("un abogado", "2019/01/02");

		// Validación
		Assert.assertTrue(turnos.colaVacia());
	}

	@Test
	public void testConjuntoTurnosConDosTurnos() {
		// Inicialización
		agendaCitas.agregarNuevoDia("un abogado", "martes", "2019/01/01");
		agendaCitas.agregarNuevaCita("un abogado", "2019/01/01", "10:00", "un cliente");
		agendaCitas.agregarNuevaCita("un abogado", "2019/01/01", "09:00", "otro cliente");

		// Operación
		ColaTDA turnos = agendaCitas.turnos("un abogado", "2019/01/01");
		String primerCliente = turnos.primero();
		turnos.desacolar();
		String segundoCliente = turnos.primero();
		turnos.desacolar();

		// Validación
		Assert.assertTrue(turnos.colaVacia());
		Assert.assertEquals("09:00", primerCliente);
		Assert.assertEquals("10:00", segundoCliente);
	}

	@Test
	public void testConjuntoAbogadosVacioDespuesDeEliminarlo() {
		// Inicialización
		agendaCitas.agregarNuevoDia("un abogado", "martes", "2019/01/01");
		agendaCitas.agregarNuevaCita("un abogado", "2019/01/01", "10:00", "un cliente");
		agendaCitas.agregarNuevaCita("un abogado", "2019/01/01", "09:00", "otro cliente");

		// Operación
		agendaCitas.eliminarAbogado("un abogado");
		ConjuntoTDA abogados = agendaCitas.abogados();

		// Validación
		Assert.assertTrue(abogados.conjuntoVacio());
	}
	
	@Test
	public void testConjuntoAbogadosNoVacioDespuesDeEliminarUnoDeDosAbogados() {
		// Inicialización
		agendaCitas.agregarNuevoDia("un abogado", "martes", "2019/01/01");
		agendaCitas.agregarNuevaCita("un abogado", "2019/01/01", "10:00", "un cliente");
		agendaCitas.agregarNuevaCita("un abogado", "2019/01/01", "09:00", "otro cliente");
		agendaCitas.agregarNuevoDia("otro abogado", "martes", "2019/01/01");
		
		// Operación
		agendaCitas.eliminarAbogado("un abogado");
		ConjuntoTDA abogados = agendaCitas.abogados();

		// Validación
		Assert.assertFalse(abogados.conjuntoVacio());
		Assert.assertFalse(abogados.pertenece("un abogado"));
		Assert.assertTrue(abogados.pertenece("otro abogado"));
	}

	@Test
	public void testEliminarUnicaFechaParaUnAbogado() {
		// Inicialización
		agendaCitas.agregarNuevoDia("un abogado", "martes", "2019/01/01");
		agendaCitas.agregarNuevaCita("un abogado", "2019/01/01", "10:00", "un cliente");
		agendaCitas.agregarNuevaCita("un abogado", "2019/01/01", "09:00", "otro cliente");
		agendaCitas.agregarNuevoDia("otro abogado", "martes", "2019/01/01");
		agendaCitas.agregarNuevaCita("otro abogado", "2019/01/01", "10:00", "un cliente");
		agendaCitas.agregarNuevaCita("otro abogado", "2019/01/01", "09:00", "otro cliente");
		//		estos son casos adicionales de prueba
		agendaCitas.agregarNuevoDia("abogado 4", "miercoles", "2019/01/02");
		agendaCitas.agregarNuevaCita("abogado 4", "2019/01/02", "10:00", "un cliente");
		agendaCitas.agregarNuevoDia("abogado 2", "martes", "2019/01/01");
		agendaCitas.agregarNuevoDia("abogado 2", "miercoles", "2019/01/02");
		agendaCitas.agregarNuevaCita("abogado 2", "2019/01/01", "10:00", "un cliente");
		agendaCitas.agregarNuevaCita("abogado 2", "2019/01/02", "10:30", "otro cliente");
		agendaCitas.agregarNuevoDia("abogado 3", "martes", "2019/01/01");
		agendaCitas.agregarNuevaCita("abogado 3", "2019/01/01", "10:00", "un cliente");
		agendaCitas.agregarNuevaCita("abogado 3", "2019/01/01", "10:30", "otro cliente");

		// Operación
		agendaCitas.eliminarFecha("un abogado", "2019/01/01");
		agendaCitas.eliminarFecha("abogado 3", "2019/01/01");
		agendaCitas.eliminarFecha("abogado 2", "2019/01/01");
		agendaCitas.eliminarFecha("abogado 4", "2019/01/02");
		ConjuntoTDA abogados = agendaCitas.abogados();

		// Validación
		Assert.assertFalse(abogados.pertenece("un abogado"));
		Assert.assertFalse(abogados.pertenece("abogado 3")); //adicional
		Assert.assertFalse(abogados.pertenece("abogado 4")); //adicional
		Assert.assertTrue(abogados.pertenece("otro abogado"));
		Assert.assertTrue(abogados.pertenece("abogado 2")); //adicional
	}

	@Test
	public void testEliminarUnaFechaParaUnAbogadoTeniendoOtraFecha() {
		// Inicialización
		agendaCitas.agregarNuevoDia("un abogado", "martes", "2019/01/01");
		agendaCitas.agregarNuevaCita("un abogado", "2019/01/01", "10:00", "un cliente");
		agendaCitas.agregarNuevaCita("un abogado", "2019/01/01", "09:00", "otro cliente");
		agendaCitas.agregarNuevoDia("un abogado", "miercoles", "2019/01/02");
		agendaCitas.agregarNuevaCita("un abogado", "2019/01/02", "10:00", "un cliente");
		agendaCitas.agregarNuevaCita("un abogado", "2019/01/02", "09:00", "otro cliente");
		agendaCitas.agregarNuevoDia("otro abogado", "martes", "2019/01/01");
		agendaCitas.agregarNuevaCita("otro abogado", "2019/01/01", "10:00", "un cliente");
		agendaCitas.agregarNuevaCita("otro abogado", "2019/01/01", "09:00", "otro cliente");

		// Operación
		agendaCitas.eliminarFecha("un abogado", "2019/01/01");
		ConjuntoTDA abogados = agendaCitas.abogados();
		ColaTDA noDeberiaHaberTurnos = agendaCitas.turnos("un abogado", "2019/01/01");
		ColaTDA deberianHaberTurnos = agendaCitas.turnos("un abogado", "2019/01/02");

		// Validación
		Assert.assertTrue(abogados.pertenece("un abogado"));
		Assert.assertTrue(abogados.pertenece("otro abogado"));
		Assert.assertTrue(noDeberiaHaberTurnos.colaVacia());
		Assert.assertFalse(deberianHaberTurnos.colaVacia());
	}
	
	@Test
	public void testExistenCitasAgregadasParaAmbosAbogados() {
		// Inicialización
		agendaCitas.agregarNuevoDia("un abogado", "martes", "2019/01/01");
		agendaCitas.agregarNuevaCita("un abogado", "2019/01/01", "10:00", "un cliente");
		agendaCitas.agregarNuevaCita("un abogado", "2019/01/01", "09:00", "otro cliente");
		agendaCitas.agregarNuevoDia("un abogado", "miercoles", "2019/01/02");
		agendaCitas.agregarNuevaCita("un abogado", "2019/01/02", "10:00", "un cliente");
		agendaCitas.agregarNuevaCita("un abogado", "2019/01/02", "09:00", "otro cliente");
		agendaCitas.agregarNuevoDia("otro abogado", "martes", "2019/01/01");
		agendaCitas.agregarNuevaCita("otro abogado", "2019/01/01", "10:00", "un cliente");
		agendaCitas.agregarNuevaCita("otro abogado", "2019/01/01", "09:00", "otro cliente");

		// Operación
		boolean existeCitaUnAbogadoNueveAm = agendaCitas.existeCita("un abogado", "2019/01/01", "09:00");
		boolean existeCitaOtroAbogadoDiezAm = agendaCitas.existeCita("otro abogado", "2019/01/01", "10:00");

		// Validación
		Assert.assertTrue(existeCitaUnAbogadoNueveAm);
		Assert.assertTrue(existeCitaOtroAbogadoDiezAm);
	}
	
	@Test
	public void testNoExisteCitaParaAbogadoNoExistente() {
		// Inicialización
		agendaCitas.agregarNuevoDia("un abogado", "martes", "2019/01/01");
		agendaCitas.agregarNuevaCita("un abogado", "2019/01/01", "10:00", "un cliente");
		agendaCitas.agregarNuevaCita("un abogado", "2019/01/01", "09:00", "otro cliente");
		agendaCitas.agregarNuevoDia("un abogado", "miercoles", "2019/01/02");
		agendaCitas.agregarNuevaCita("un abogado", "2019/01/02", "10:00", "un cliente");
		agendaCitas.agregarNuevaCita("un abogado", "2019/01/02", "09:00", "otro cliente");
		agendaCitas.agregarNuevoDia("otro abogado", "martes", "2019/01/01");
		agendaCitas.agregarNuevaCita("otro abogado", "2019/01/01", "10:00", "un cliente");
		agendaCitas.agregarNuevaCita("otro abogado", "2019/01/01", "09:00", "otro cliente");

		// Operación
		boolean existeCitaUnAbogadoNoExistenteNueveAm = agendaCitas.existeCita("un abogado no existente", "2019/01/01", "09:00");

		// Validación
		Assert.assertFalse(existeCitaUnAbogadoNoExistenteNueveAm);
	}
	
	@Test
	public void testNoExisteCitaAgregadasParaHorarioNoExistente() {
		// Inicialización
		agendaCitas.agregarNuevoDia("un abogado", "martes", "2019/01/01");
		agendaCitas.agregarNuevaCita("un abogado", "2019/01/01", "10:00", "un cliente");
		agendaCitas.agregarNuevaCita("un abogado", "2019/01/01", "09:00", "otro cliente");
		agendaCitas.agregarNuevoDia("un abogado", "miercoles", "2019/01/02");
		agendaCitas.agregarNuevaCita("un abogado", "2019/01/02", "10:00", "un cliente");
		agendaCitas.agregarNuevaCita("un abogado", "2019/01/02", "09:00", "otro cliente");
		agendaCitas.agregarNuevoDia("otro abogado", "martes", "2019/01/01");
		agendaCitas.agregarNuevaCita("otro abogado", "2019/01/01", "10:00", "un cliente");
		agendaCitas.agregarNuevaCita("otro abogado", "2019/01/01", "09:00", "otro cliente");

		// Operación
		boolean existeCitaUnAbogadoNueveYMediaAm = agendaCitas.existeCita("un abogado", "2019/01/01", "09:30");

		// Validación
		Assert.assertFalse(existeCitaUnAbogadoNueveYMediaAm);
	}
	
	@Test
	public void testNoExisteCitaCuandoSeEliminaElAbogado() {
		// Inicialización
		agendaCitas.agregarNuevoDia("un abogado", "martes", "2019/01/01");
		agendaCitas.agregarNuevaCita("un abogado", "2019/01/01", "10:00", "un cliente");
		agendaCitas.agregarNuevaCita("un abogado", "2019/01/01", "09:00", "otro cliente");
		agendaCitas.agregarNuevoDia("un abogado", "miercoles", "2019/01/02");
		agendaCitas.agregarNuevaCita("un abogado", "2019/01/02", "10:00", "un cliente");
		agendaCitas.agregarNuevaCita("un abogado", "2019/01/02", "09:00", "otro cliente");
		agendaCitas.agregarNuevoDia("otro abogado", "martes", "2019/01/01");
		agendaCitas.agregarNuevaCita("otro abogado", "2019/01/01", "10:00", "un cliente");
		agendaCitas.agregarNuevaCita("otro abogado", "2019/01/01", "09:00", "otro cliente");

		// Operación
		agendaCitas.eliminarAbogado("otro abogado");
		boolean existeCitaUnAbogadoNueveAm = agendaCitas.existeCita("un abogado", "2019/01/01", "09:00");
		boolean existeCitaOtroAbogadoDiezAm = agendaCitas.existeCita("otro abogado", "2019/01/01", "10:00");

		// Validación
		Assert.assertTrue(existeCitaUnAbogadoNueveAm);
		Assert.assertFalse(existeCitaOtroAbogadoDiezAm);
	}
	
	@Test
	public void testNoExisteCitaCuandoSeEliminaLaFecha() {
		// Inicialización
		agendaCitas.agregarNuevoDia("un abogado", "martes", "2019/01/01");
		agendaCitas.agregarNuevaCita("un abogado", "2019/01/01", "10:00", "un cliente");
		agendaCitas.agregarNuevaCita("un abogado", "2019/01/01", "09:00", "otro cliente");
		agendaCitas.agregarNuevoDia("un abogado", "miercoles", "2019/01/02");
		agendaCitas.agregarNuevaCita("un abogado", "2019/01/02", "10:00", "un cliente");
		agendaCitas.agregarNuevaCita("un abogado", "2019/01/02", "09:00", "otro cliente");
		agendaCitas.agregarNuevoDia("otro abogado", "martes", "2019/01/01");
		agendaCitas.agregarNuevaCita("otro abogado", "2019/01/01", "10:00", "un cliente");
		agendaCitas.agregarNuevaCita("otro abogado", "2019/01/01", "09:00", "otro cliente");

		// Operación
		agendaCitas.eliminarFecha("un abogado", "2019/01/01");
		boolean existeCitaUnAbogadoNueveAmDiaEliminado = agendaCitas.existeCita("un abogado", "2019/01/01", "09:00");
		boolean existeCitaUnAbogadoNueveAmDiaExistente = agendaCitas.existeCita("un abogado", "2019/01/02", "09:00");

		// Validación
		Assert.assertFalse(existeCitaUnAbogadoNueveAmDiaEliminado);
		Assert.assertTrue(existeCitaUnAbogadoNueveAmDiaExistente);
	}
	
	@Test
	public void testNoExisteCitaCuandoSeEliminaLaCita() {
		// Inicialización
		agendaCitas.agregarNuevoDia("un abogado", "martes", "2019/01/01");
		agendaCitas.agregarNuevaCita("un abogado", "2019/01/01", "10:00", "un cliente");
		agendaCitas.agregarNuevaCita("un abogado", "2019/01/01", "09:00", "otro cliente");
		agendaCitas.agregarNuevoDia("un abogado", "miercoles", "2019/01/02");
		agendaCitas.agregarNuevaCita("un abogado", "2019/01/02", "10:00", "un cliente");
		agendaCitas.agregarNuevaCita("un abogado", "2019/01/02", "09:00", "otro cliente");
		agendaCitas.agregarNuevoDia("otro abogado", "martes", "2019/01/01");
		agendaCitas.agregarNuevaCita("otro abogado", "2019/01/01", "10:00", "un cliente");
		agendaCitas.agregarNuevaCita("otro abogado", "2019/01/01", "09:00", "otro cliente");

		// Operación
		agendaCitas.eliminarCita("un abogado", "2019/01/01", "09:00", "otro cliente");
		boolean existeCitaUnAbogadoNueveAm = agendaCitas.existeCita("un abogado", "2019/01/01", "09:00");
		boolean existeCitaUnAbogadoDiezAm = agendaCitas.existeCita("un abogado", "2019/01/01", "10:00");

		// Validación
		Assert.assertFalse(existeCitaUnAbogadoNueveAm);
		Assert.assertTrue(existeCitaUnAbogadoDiezAm);
	}
	
	@Test
	public void testObtenerClientesEnCitas() {
		// Inicialización
		agendaCitas.agregarNuevoDia("un abogado", "martes", "2019/01/01");
		agendaCitas.agregarNuevaCita("un abogado", "2019/01/01", "10:00", "primer cliente");
		agendaCitas.agregarNuevaCita("un abogado", "2019/01/01", "09:00", "segundo cliente");
		agendaCitas.agregarNuevoDia("un abogado", "miercoles", "2019/01/02");
		agendaCitas.agregarNuevaCita("un abogado", "2019/01/02", "10:00", "tercer cliente");
		agendaCitas.agregarNuevaCita("un abogado", "2019/01/02", "09:00", "cuarto cliente");
		agendaCitas.agregarNuevoDia("otro abogado", "martes", "2019/01/01");
		agendaCitas.agregarNuevaCita("otro abogado", "2019/01/01", "10:00", "quinto cliente");
		agendaCitas.agregarNuevaCita("otro abogado", "2019/01/01", "09:00", "sexto cliente");

		// Operación
		String primerCliente = agendaCitas.clienteEnCita("un abogado", "2019/01/01", "10:00");
		String segundoCliente = agendaCitas.clienteEnCita("un abogado", "2019/01/01", "09:00");
		String tercerCliente = agendaCitas.clienteEnCita("un abogado", "2019/01/02", "10:00");
		String cuartoCliente = agendaCitas.clienteEnCita("un abogado", "2019/01/02", "09:00");
		String quintoCliente = agendaCitas.clienteEnCita("otro abogado", "2019/01/01", "10:00");
		String sextoCliente = agendaCitas.clienteEnCita("otro abogado", "2019/01/01", "09:00");
		//  Caso adicional: en caso de que no exista una cita para una hora determinada
		String septimoCliente = agendaCitas.clienteEnCita("otro abogado", "2019/01/01", "17:00");

		// Validación
		Assert.assertEquals("primer cliente", primerCliente);
		Assert.assertEquals("segundo cliente", segundoCliente);
		Assert.assertEquals("tercer cliente", tercerCliente);
		Assert.assertEquals("cuarto cliente", cuartoCliente);
		Assert.assertEquals("quinto cliente", quintoCliente);
		Assert.assertEquals("sexto cliente", sextoCliente);
		Assert.assertEquals("", septimoCliente); // adicional
	}

}
