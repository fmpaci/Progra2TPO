package algoritmos;

import tdas.AgendaCitasTDA;
import tdas.ColaPrioridadTDA;
import tdas.ColaTDA;
import tdas.ConjuntoTDA;

import java.util.Arrays;

import implementaciones.Conjunto;

public class Algoritmo implements IAlgoritmo {

	@Override
	public boolean disponible(AgendaCitasTDA agenda, String abogado, String fecha, String hora) {
		if (!agenda.abogados().pertenece(abogado)) return false;
		if (!agenda.fechas(abogado).pertenece(fecha)) return false;
		return !agenda.existeCita(abogado, fecha, hora);
	}

	@Override
	public ConjuntoTDA masCitas(AgendaCitasTDA agenda, String fechaDesde, String fechaHasta) {
		ConjuntoTDA abogadosResultantes = new Conjunto();
		abogadosResultantes.inicializar();
		
		ConjuntoTDA abogados = agenda.abogados();
		while(!abogados.conjuntoVacio()) {
			String abogado = abogados.elegir();
			abogados.sacar(abogado);
			
			Integer cantidadCitas = 0;
			ConjuntoTDA fechas = agenda.fechas(abogado);
			while(!fechas.conjuntoVacio()) {
				String fecha = fechas.elegir();
				fechas.sacar(fecha);
			
				if (fecha.compareTo(fechaDesde) >= 0 && fecha.compareTo(fechaHasta) < 0) {
					ColaTDA turnos = agenda.turnos(abogado, fecha);
					while (!turnos.colaVacia()) {
						cantidadCitas += 1;
						turnos.desacolar();
					}
				}
			}
			
			if (cantidadCitas > 0) abogadosResultantes.agregar(abogado);
		}
		
		return abogadosResultantes;
	}

	@Override
	public String abogadoUltimaVez(AgendaCitasTDA agenda, String cliente) {
		String ultimaFechaAtencion = "";
		String ultimaHoraAtencion = "";
		String abogadoSeleccionado = "";
		ConjuntoTDA abogados = agenda.abogados();
		while (!abogados.conjuntoVacio()) {
			String abogado = abogados.elegir();
			abogados.sacar(abogado);
			
			ConjuntoTDA fechas = agenda.fechas(abogado);
			while (!fechas.conjuntoVacio()) {
				String fecha = fechas.elegir();
				fechas.sacar(fecha);
				
				if (fecha.compareTo(ultimaFechaAtencion) >= 0) {
					ColaTDA turnos = agenda.turnos(abogado, fecha);
					while (!turnos.colaVacia()) {
						String hora = turnos.primero();
						turnos.desacolar();
						
						String clienteEnCita = agenda.clienteEnCita(abogado, fecha, hora);
						if (clienteEnCita.equalsIgnoreCase(cliente) && hora.compareTo(ultimaHoraAtencion) > 0) {
							abogadoSeleccionado = abogado;
							ultimaFechaAtencion = fecha;
							ultimaHoraAtencion = hora;
						}
					}
				}
			}
		}
		
		return abogadoSeleccionado;
	}

	@Override
	public String[][] obtenerCitas(AgendaCitasTDA agenda, String abogado, String fecha) {
		String[][] citas = new String[30][3];
		String[][] rangoDias = diasSemana(fecha);
		ConjuntoTDA fechas = agenda.fechas(abogado);
		while (!fechas.conjuntoVacio()) {
			String auxFecha = fechas.elegir();
			fechas.sacar(auxFecha);
			if (Arrays.asList(rangoDias[0]).contains(auxFecha)) {
				
			}
		}
		return null;
	}

	@Override
	public String[][] conQuienSeReunio(AgendaCitasTDA agenda, String cliente) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ColaPrioridadTDA libresTotal(AgendaCitasTDA agenda, String fecha) {
		// TODO Auto-generated method stub
		return null;
	}
	
	protected String[][] diasSemana(String fechaDesde) {
		String[][] fechas = new String[2][7];
		String nuevaFecha = fechaDesde;
		String nuevoDia = "lunes";
		for (int i = 0; i < 7; i++) {
			fechas[0][i] = nuevaFecha;
			fechas[1][i] = nuevoDia;
			nuevoDia = siguienteDiaSemana(nuevoDia);
			nuevaFecha = sumarDia(nuevaFecha);
		}
		return fechas;
	}
	
	protected String sumarDia(String fecha) {
		String[] auxFecha = fecha.split("/");
		Integer anio = Integer.parseInt(auxFecha[0]);
		Integer mes = Integer.parseInt(auxFecha[1]);
		Integer dia = Integer.parseInt(auxFecha[2]);
		
		if (mes == 4 || mes == 6 || mes == 9 || mes == 11) {
			if (dia < 30) {
				dia += 1; 
			} else {
				dia = 1;
				mes += 1;
			}
		} else if (mes == 1 || mes == 3 || mes == 5 || mes == 7 || mes == 8 || mes == 10 || mes == 12) {
			if (dia < 31) {
				dia += 1;
			} else {
				dia = 1;
				if (mes < 12) {
					mes += 1;
				} else {
					mes = 1;
					anio += 1;
				}
			}
		} else {
			if (dia < 28) {
				dia += 1;
			} else {
				dia = 1;
				mes = 3;
			}
		}
		
		String nuevaFecha = anio.toString();
		if (mes.toString().length() == 1) {
			nuevaFecha += "/0" + mes.toString();
		} else {
			nuevaFecha += "/" + mes.toString();
		}
		if (dia.toString().length() == 1) {
			nuevaFecha += "/0" + dia.toString();
		} else {
			nuevaFecha += "/" + dia.toString();
		}
		
		return nuevaFecha;
	}
	
	protected String siguienteDiaSemana(String diaSemana) {
		if (diaSemana == "lunes") return "martes";
		if (diaSemana == "martes") return "miercoles";
		if (diaSemana == "miercoles") return "jueves";
		if (diaSemana == "jueves") return "viernes";
		if (diaSemana == "viernes") return "sábado";
		if (diaSemana == "sábado") return "domingo";
		if (diaSemana == "domingo") return "lunes";
		return null;
	}
}
