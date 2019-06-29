package implementaciones;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class ColaTest {

	Cola cola;
	
	@Before
	public void setUp() throws Exception {
		cola = new Cola();
		cola.inicilizar();
	}
	
	@Test
	public void testColaVacia() {
		// Operación
		boolean colaVacia = cola.colaVacia();
		
		// Validación
		Assert.assertTrue(colaVacia);
	}
	
	@Test
	public void testColaNoVacia() {
		// Inicialización
		cola.acolar("un valor");
		
		// Operación
		boolean colaVacia = cola.colaVacia();
		
		// Validación
		Assert.assertFalse(colaVacia);
	}

	@Test
	public void testAcolar() {
		// Inicialización
		cola.acolar("primer valor");
		cola.acolar("segundo valor");
		cola.acolar("tercer valor");
		
		// Operación
		String primerValor = cola.primero();
		cola.desacolar();
		String segundoValor = cola.primero();
		cola.desacolar();
		String tercerValor = cola.primero();
		cola.desacolar();
		
		// Validación
		Assert.assertTrue(cola.colaVacia());
		Assert.assertEquals("primer valor", primerValor);
		Assert.assertEquals("segundo valor", segundoValor);
		Assert.assertEquals("tercer valor", tercerValor);
		
	}

}
