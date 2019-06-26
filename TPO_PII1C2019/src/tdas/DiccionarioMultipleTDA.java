package tdas;

import tdas.ConjuntoTDA;

public interface DiccionarioMultipleTDA {
	void inicializar() ;
	// siempre que el diccionario este inicializado
	void agregar( String clave , String valor);
	// siempre que el diccionario este inicializado
	void eliminar( String clave);
	// siempre que el diccionario este inicializado
	void eliminarValor( String clave , String valor);
	// siempre que el diccionario este inicializado
	ConjuntoTDA recuperar( String clave);
	// siempre que el diccionario este inicializado
	ConjuntoTDA claves();
}
