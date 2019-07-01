package implementaciones;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import tdas.ArbolCitasTDA;

public class ArbolCitasTest {

	ArbolCitas arbolCitas;

	@Before
	public void setUp() throws Exception {
		arbolCitas = new ArbolCitas();
		arbolCitas.inicializar();
	}

	@Test
	public void testArbolVacio() {
		// Operación
		boolean arbolCitasVacio = arbolCitas.arbolVacio();

		// Validación
		Assert.assertTrue(arbolCitasVacio);
	}

	@Test
	public void testDevolverHoraUnicoNodo() {
		// Inicialización
		arbolCitas.agregar("04:30", "cliente 4.30am");

		// Operación
		String hora = arbolCitas.hora();

		// Validación
		Assert.assertEquals("04:30", hora);
	}

	@Test
	public void testDevolverClienteUnicoNodo() {
		// Inicialización
		arbolCitas.agregar("04:30", "cliente 4.30am");

		// Operación
		String cliente = arbolCitas.cliente();

		// Validación
		Assert.assertEquals("cliente 4.30am", cliente);
	}

	@Test
	public void testHijoIzquierdoVacio() {
		// Inicialización
		arbolCitas.agregar("04:30", "cliente 4.30am");

		// Operación
		ArbolCitasTDA hijoIzquierdo = arbolCitas.hijoIzquierdo();

		// Validación
		Assert.assertTrue(hijoIzquierdo.arbolVacio());
	}

	@Test
	public void testHijoDerechoVacio() {
		// Inicialización
		arbolCitas.agregar("04:30", "cliente 4.30am");

		// Operación
		ArbolCitasTDA hijoDerecho = arbolCitas.hijoDerecho();

		// Validación
		Assert.assertTrue(hijoDerecho.arbolVacio());
	}

	@Test
	public void testDevolverHoraRaizHijoIzquierdo() {
		// Inicialización
		arbolCitas.agregar("04:30", "cliente 4.30am");
		arbolCitas.agregar("02:00", "cliente 2am");
		arbolCitas.agregar("07:30", "cliente 7.30am");

		// Operación
		String hora = arbolCitas.hijoIzquierdo().hora();

		// Validación
		Assert.assertEquals("02:00", hora);
	}

	@Test
	public void testDevolverClienteRaizHijoIzquierdo() {
		// Inicialización
		arbolCitas.agregar("04:30", "cliente 4.30am");
		arbolCitas.agregar("02:00", "cliente 2am");
		arbolCitas.agregar("07:30", "cliente 7.30am");

		// Operación
		String cliente = arbolCitas.hijoIzquierdo().cliente();

		// Validación
		Assert.assertEquals("cliente 2am", cliente);
	}

	@Test
	public void testDevolverHoraRaizHijoDerecho() {
		// Inicialización
		arbolCitas.agregar("04:30", "cliente 4.30am");
		arbolCitas.agregar("02:00", "cliente 2am");
		arbolCitas.agregar("07:30", "cliente 7.30am");

		// Operación
		String hora = arbolCitas.hijoDerecho().hora();

		// Validación
		Assert.assertEquals("07:30", hora);
	}

	@Test
	public void testDevolverClienteRaizHijoDerecho() {
		// Inicialización
		arbolCitas.agregar("04:30", "cliente 4.30am");
		arbolCitas.agregar("02:00", "cliente 2am");
		arbolCitas.agregar("07:30", "cliente 7.30am");

		// Operación
		String cliente = arbolCitas.hijoDerecho().cliente();

		// Validación
		Assert.assertEquals("cliente 7.30am", cliente);
	}

	@Test
	public void testEliminarHoja() {
		// Inicialización
		arbolCitas.agregar("04:30", "cliente 4.30am");
		arbolCitas.agregar("02:00", "cliente 2am");
		arbolCitas.agregar("07:30", "cliente 7.30am");
		
		// Operación
		arbolCitas.eliminar("07:30", "cliente 7.30am");
		
		// Validación
		Assert.assertTrue(arbolCitas.hijoDerecho().arbolVacio());
	}
	
	@Test
	public void testEliminarNodoClienteNoExistente() {
		// Inicialización
		arbolCitas.agregar("04:30", "cliente 4.30am");
		arbolCitas.agregar("02:00", "cliente 2am");
		arbolCitas.agregar("07:30", "cliente 7.30am");
		
		// Operación
		arbolCitas.eliminar("07:30", "cliente de mentira");
		
		// Validación
		Assert.assertFalse(arbolCitas.hijoDerecho().arbolVacio());
	}
	
	@Test
	public void testEliminarNodoHoraNoExistente() {
		// Inicialización
		arbolCitas.agregar("04:30", "cliente 4.30am");
		arbolCitas.agregar("02:00", "cliente 2am");
		arbolCitas.agregar("07:30", "cliente 7.30am");
		
		// Operación
		arbolCitas.eliminar("08:30", "cliente 7.30am");
		
		// Validación
		Assert.assertFalse(arbolCitas.hijoDerecho().arbolVacio());
	}
	
	@Test
	public void testEliminarNodoIntermedioConHijoDerecho() {
		// Inicialización
		arbolCitas.agregar("04:30", "cliente 4.30am");
		arbolCitas.agregar("02:00", "cliente 2am");
		arbolCitas.agregar("07:30", "cliente 7.30am");
		arbolCitas.agregar("08:30", "cliente 8.30am");
		
		// Operación
		arbolCitas.eliminar("07:30", "cliente 7.30am");
		
		// Validación
		Assert.assertFalse(arbolCitas.hijoDerecho().arbolVacio());
		Assert.assertTrue(arbolCitas.hijoDerecho().hijoDerecho().arbolVacio());
	}
	
	@Test
	public void testEliminarNodoIntermedioConHijoIzquierdo() {
		// Inicialización
		arbolCitas.agregar("04:30", "cliente 4.30am");
		arbolCitas.agregar("02:00", "cliente 2am");
		arbolCitas.agregar("07:30", "cliente 7.30am");
		arbolCitas.agregar("07:00", "cliente 7am");
		
		// Operación
		arbolCitas.eliminar("07:30", "cliente 7.30am");
		
		// Validación
		Assert.assertFalse(arbolCitas.hijoDerecho().arbolVacio());
		Assert.assertTrue(arbolCitas.hijoDerecho().hijoIzquierdo().arbolVacio());
	}

}
