package algoritmos;
import java.util.Arrays;



public class TestAgendaCitas {
	
	public static void main(String[] args) {
		Algoritmo algo = new Algoritmo();
		
		System.out.println(algo.sumarDia("2019/01/01"));
		System.out.println(algo.sumarDia("2019/01/29"));
		System.out.println(algo.sumarDia("2019/01/30"));
		System.out.println(algo.sumarDia("2019/01/31"));
		System.out.println(algo.sumarDia("2019/02/01"));
		System.out.println(algo.sumarDia("2019/02/28"));
		System.out.println(algo.sumarDia("2019/03/01"));
		System.out.println(algo.sumarDia("2019/03/30"));
		System.out.println(algo.sumarDia("2019/03/31"));
		System.out.println(algo.sumarDia("2019/04/01"));
		System.out.println(algo.sumarDia("2019/04/30"));
		System.out.println(algo.sumarDia("2019/05/01"));
		System.out.println(algo.sumarDia("2019/05/31"));
		System.out.println(algo.sumarDia("2019/06/01"));
		System.out.println(algo.sumarDia("2019/06/30"));
		System.out.println(algo.sumarDia("2019/07/01"));
		System.out.println(algo.sumarDia("2019/07/31"));
		System.out.println(algo.sumarDia("2019/08/01"));
		System.out.println(algo.sumarDia("2019/08/31"));
		System.out.println(algo.sumarDia("2019/09/01"));
		System.out.println(algo.sumarDia("2019/09/30"));
		System.out.println(algo.sumarDia("2019/10/01"));
		System.out.println(algo.sumarDia("2019/10/31"));
		System.out.println(algo.sumarDia("2019/11/01"));
		System.out.println(algo.sumarDia("2019/11/30"));
		System.out.println(algo.sumarDia("2019/12/01"));
		System.out.println(algo.sumarDia("2019/12/31"));
		System.out.println("--");
		for (String[] dias : algo.diasSemana("2019/01/28") ) {
			for (String dia : dias) {
				System.out.println(dia);
			}
		}
		String[][] dias = algo.diasSemana("2019/01/28");
		System.out.println(Arrays.asList(dias[0]).contains("2019/02/03"));
		System.out.println(Arrays.asList(dias[1]).contains("miercoles"));
		Integer index = Arrays.asList(dias[0]).indexOf("2019/02/01");
		System.out.println(dias[0][index] + " - " + dias[1][index]);
		
		String[][] citas = new String[][] {
			{ "martes", "14:00", "otro cliente mas" },
			{ null, null, null },
			{ "martes", "14:30", "otro cliente" },
			{ "miercoles", "10:30", "un cliente" },
			{ null, null, null }
		};
		String[][] compacto = algo.compactarArreglo(citas);
		for (String[] f : compacto) {
			for (String c : f) {
				System.out.println(c);
			}
		}
		
		String[][] citas2 = new String[][] {
			{ "martes", "14:30", "otro cliente" },
			{ "miercoles", "10:30", "un cliente" },
			{ "martes", "14:00", "otro cliente mas" }
		};
		algo.ordenarArreglo(citas2, 0, 1);
		System.out.println("--");
		for (String[] f : citas2) {
			for (String c : f) {
				System.out.println(c);
			}
		}
		

	}

}
