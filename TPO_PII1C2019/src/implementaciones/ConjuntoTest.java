package implementaciones;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class ConjuntoTest {

	Conjunto conjunto;
	
	@Before
	public void setUp() throws Exception {
		conjunto = new Conjunto();
		conjunto.inicializar();
	}

	@Test
	public void testConjuntoVacio() {
		// Operación
		boolean elConjuntoEstaVacio = conjunto.conjuntoVacio();
		
		// Validación
		Assert.assertTrue(elConjuntoEstaVacio);
	}
	
	@Test
	public void testConjuntoNoVacio() {
		// Operación
		conjunto.agregar("un valor");
		
		// Validación
		Assert.assertFalse(conjunto.conjuntoVacio());
	}

	@Test
	public void testAgregar() {
		// Operación
		conjunto.agregar("un valor");
		
		// Validación
		Assert.assertEquals("un valor", conjunto.elegir());
	}

	@Test
	public void testElegirYSacar() {
		// Inicialización
		conjunto.agregar("un valor");
		conjunto.agregar("otro valor");
		conjunto.agregar("un ultimo valor");
		List<String> valoresEsperados = Arrays.asList("un valor", "otro valor", "un ultimo valor");
		List<String> valoresDelConjunto = new ArrayList<String>();
		
		// Operación
		while(!conjunto.conjuntoVacio()) {
			String valor = conjunto.elegir();
			conjunto.sacar(valor);
			valoresDelConjunto.add(valor);
		}
		
		// Validación
		Assert.assertTrue(valoresEsperados.size() == valoresDelConjunto.size() && 
				valoresEsperados.containsAll(valoresDelConjunto) && valoresDelConjunto.containsAll(valoresEsperados));
		
	}

	@Test
	public void testPertenece() {
		// Inicialización
		conjunto.agregar("un valor");
		conjunto.agregar("otro valor");
		conjunto.agregar("un ultimo valor");
		
		// Operación
		boolean unValorPertenece = conjunto.pertenece("un valor");
		boolean otroValorPertenece = conjunto.pertenece("otro valor");
		boolean unUltimoValorPertenece = conjunto.pertenece("un ultimo valor");
		
		// Validación
		Assert.assertTrue(unValorPertenece);
		Assert.assertTrue(otroValorPertenece);
		Assert.assertTrue(unUltimoValorPertenece);
	}
	
	@Test
	public void testNoPerteneceEnConjuntoVacio() {		
		// Operación
		boolean unValorEnUnConjuntoVacioPertenece = conjunto.pertenece("un valor en un conjunto vacio");
		
		// Validación
		Assert.assertFalse(unValorEnUnConjuntoVacioPertenece);
	}
	
	@Test
	public void testNoPerteneceEnConjuntoNoVacio() {
		// Inicialización
		conjunto.agregar("un valor");
		conjunto.agregar("otro valor");
		conjunto.agregar("un ultimo valor");
		
		// Operación
		boolean unValorQueNoExistePertenece = conjunto.pertenece("un valor que no existe");
		
		// Validación
		Assert.assertFalse(unValorQueNoExistePertenece);
	}

}
