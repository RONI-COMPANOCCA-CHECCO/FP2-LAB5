
// RONI COMPANOCCA CHECCO
// CUI: 20210558
// LABORATORIO 05
// FUNDAMENTOS DE PROGRAMACION 
import java.util.*;

public class VideoJuego3 {

	public static void main(String[] args) {

		//DECLARACION DE VARIABLES Y ARREGLOS NECESARIOS
		ArrayList<Soldado> ejercito1 = new ArrayList();
		ArrayList<Soldado> ejercito2 = new ArrayList();
		ArrayList<ArrayList<Soldado>> tablero = new ArrayList();
		int batallon1, batallon2;
		int vidatotal1=0, vidatotal2=0;
		double promedioVida1=0, promedioVida2=0;

		// BUCLE PARA DESIGNAR LA CANTIDAD DE FILAS Y COLUMNAS DEL TABLERO
		for(int i=0; i<10; i++) {
			tablero.add(new ArrayList<Soldado>());
			for(int j=0; j<10; j++) {
				tablero.get(i).add(new Soldado());
			}
		}

		// CREACION DEL NUMERO DE POSICIONES DE CADA EJERCITO
		batallon1 = aleatorio(1,10);
		batallon2 = aleatorio(1,10);

		// INICIALIZAR ARREGLOS
		inicializarArreglo(ejercito1, batallon1);
		inicializarArreglo(ejercito2, batallon2);

		// GENERAR EJERCITOS VALIDOS
		generarEjercitos(ejercito1, ejercito2);

		// AÑADIR LOS EJERCITOS AL TABLERO
		añadirTablero(ejercito1, tablero);
		añadirTablero(ejercito2, tablero);

		//IMPRIMIR EL TABLERO
		imprimirTablero(tablero);

		//IMPRIMIR LOS SOLDADOS DE MAYOR VIDA DE CADA EJERCITO
		System.out.println("Soldado de mayor vida del ejercito 1");
		SoldadoConMayorVida(ejercito1);
		System.out.println("soldado de mayor vida del ejercito 2");
		SoldadoConMayorVida(ejercito2);

		//IMPRIMIR LA VIDA TOTAL Y EL PROMEDIO DEL EJERCITO 1
		System.out.println("\nEJERCITO 1: ");
		for (int i=0; i<ejercito1.size(); i++) {
			vidatotal1+=ejercito1.get(i).getPuntos();
			promedioVida1 = vidatotal1/(ejercito1.size()*1.0);
		}
		System.out.println("Vida total: "+vidatotal1);
		System.out.println("Promedio de vida: "+promedioVida1);
		
		//IMPRIMIR LA VIDA TOTAL Y EL PROMEDIO DEL EJERCITO 2
		System.out.println("\nEJERCITO 2: ");
		for (int i=0; i<ejercito2.size(); i++) {
			vidatotal2+=ejercito2.get(i).getPuntos();
			promedioVida2 = vidatotal2/(ejercito2.size()*1.0);
		}
		System.out.println("Vida total: "+vidatotal2);
		System.out.println("Promedio de vida: "+promedioVida2);

		//IMPRIMIR LOS SOLDADOS CREADOS EN EL ORDEN POR DEFECTO
		System.out.println("\nLista ejercito 1:");
		for(int i=0; i<ejercito1.size(); i++) {
			imprimir(ejercito1.get(i));
		}
		System.out.println("\nLista ejercito 2:");
		for(int i=0; i<ejercito2.size(); i++) {
			imprimir(ejercito2.get(i));
		}

		// IMPRIMIR LOS DATOS DE LOS SOLDADOS ORDENADOS DE MAYOR A MENOR DEPENDIENDO DE SU NIVEL DE VIDA USANDO DOS TIPOS DE ALGORITMO
		ordenarPorVidaMetodoA(ejercito1);
		ordenarPorVidaMetodoB(ejercito2);
		System.out.println("\nEjercito 1 Ordenados por nivel de vida");
		for(int i=0; i<ejercito1.size(); i++) {
			imprimir(ejercito1.get(i));
		}
		System.out.println("\nEjercito 2 Ordenados por nivel de vida");
		for(int i=0; i<ejercito2.size(); i++) {
			imprimir(ejercito2.get(i));
		}
		
		// MOSTRAR EJERCITO GANADOR LA METRICA USADA ARA DESIGNAR AL GANADOR ES POR EL NIVEL DEL PROMEDIO DE VIDA DE CADA EJERCITO
		if(promedioVida1>promedioVida2) {
			System.out.println("\nGANADOR ***EJERCITO 1***");
		}else if (promedioVida1<promedioVida2) {
			System.out.println("\nGANADOR ***EJERCITO 2***");
			}
		else {
			System.out.print("\n***ES UN EMPATE***");
		}
	}

	// METODO PARA CREAR NUMEROS ALEATORIOS EN UN RANGO
	public static int aleatorio(int min, int max) {
		return(int)(Math.random()*(max-min+1)+min);
	}

	// METODO PARA INICIAR UN ARRAYLIST
	public static void inicializarArreglo (ArrayList<Soldado> soldadito, int num) {
		for (int i=0; i<num; i++) {
			soldadito.add(new Soldado());
		}
	}

	// METODO PARA GENERAR DATOS DEL OBJETO SOLDADO
	public static Soldado generarDatos() {
		Soldado soldadito = new Soldado();
		soldadito.setPuntos(aleatorio(1,5));
		soldadito.setColumna(aleatorio(1,10));
		soldadito.setFila(aleatorio(1,10));
		return soldadito;
	}

	// METODOS PARA GENERAR LOS EJERCITOS DE MANERA ALEATORIA
	public static void generarEjercitos(ArrayList<Soldado>B1, ArrayList<Soldado>B2) {
		ArrayList<Soldado>Soldados = new ArrayList();
		Soldados.add(generarDatos());
		for (int i=1; i<(B1.size()+B2.size()); i++) {
			Soldados.add(generarDatos());
			for (int j=0; j<i; j++) {
				if(Soldados.get(i).getFila()==Soldados.get(j).getFila()) {
					if(Soldados.get(i).getColumna()==Soldados.get(j).getColumna()){
						Soldados.remove(i);
						i--;
					}
				}
			}
		}
		for (int i=0; i<B1.size(); i++) {
			B1.add(i, Soldados.get(i));
			B1.get(i).setNombre("Soldado"+i+"x1");
			B1.get(i).setColumn(B1.get(i).getPuntos()+"[E1]");
			B1.remove(i+1);
		}
		for (int i=0; i<B2.size(); i++) {
			B2.add(i, Soldados.get(i+B1.size()));
			B2.get(i).setNombre("Soldado"+i+"x2");
			B2.remove(i+1);
			B2.get(i).setColumn(B2.get(i).getPuntos()+"[E2]");
		}
	}

	// METODO PARA AÑADIR LOS EJERCITOS AL TABLERO
	public static void añadirTablero(ArrayList<Soldado>soldadito, ArrayList<ArrayList<Soldado>>table) {
		for (int i=0; i<soldadito.size(); i++) {
			table.get(soldadito.get(i).getColumna()-1).add(soldadito.get(i).getFila()-1,soldadito.get(i));
			table.get(soldadito.get(i).getColumna()-1).remove(soldadito.get(i).getFila());
		}
	}

	// METODO PARA IMPRIMIR EL TABLERO EN LA CUAL SE DESARROLLA EL JUEGO
	public static void imprimirTablero(ArrayList<ArrayList<Soldado>> table) {
		System.out.println("\tA\tB\tC\tD\tF\tG\tH\tI\tJ");
		for(int i=0; i<table.size(); i++) {
			System.out.print(i+1);
			for(int j=0; j<table.get(i).size();j++) {
				System.out.print("\t"+table.get(i).get(j).getColumn());
			}
			System.out.println("\n");
		}
	}
	
	//METODO PARA IMPRIMIR LOS SOLDADOS DE MAYOR VIDA
	public static void SoldadoConMayorVida (ArrayList<Soldado>soldadito) {
		Soldado mayor = new Soldado();
		mayor.setPuntos(0);
		for(int i=0; i<soldadito.size();i++) {
			if (mayor.getPuntos()<soldadito.get(i).getPuntos()) {
				mayor = soldadito.get(i);
			}
		}
		imprimir(mayor);
	}
	
	// METODO PARA IMPRIMIR EL NOMBRE, LA POSICION Y NIVEL DE VIDA DEL SOLDADO
	public static void imprimir(Soldado soldadito) {
		System.out.println("Nombre: "+soldadito.getNombre()+"\nPosicion: "+soldadito.getColumna()+"X"+soldadito.getFila()+"\tVida: "+soldadito.getPuntos());
	}
	
	// METODO QUE NOS AYUDA A ORDENAR LOS SOLDADOS DE ACUERDO A SU NIVEL DE VIDA, USUANDO UN ALGORITMO DE ORDENAMIENTO DE BURBUJA
	public static void ordenarPorVidaMetodoA(ArrayList<Soldado>soldadito) {
		Soldado aux = new Soldado();
		for(int i=0; i<soldadito.size()-1; i++) {
			for(int j=0; j<soldadito.size()-i-1; j++) {
				if(soldadito.get(j).getPuntos()<soldadito.get(j+1).getPuntos()) {
					aux = soldadito.get(j);
					soldadito.set(j,soldadito.get(j+1));
					soldadito.set(j+1,aux);
				}
			}
		}
	}

    // METODO QUE NOS AYUDA A ORDENAR LOS SOLDADOS DE ACUERDO A SU NIVEL DE VIDA, EN ESTA OCACION DIFERENTE A LA ANTERIOR QUE ERA ALGORITMO DE BURBUJA
    public static void ordenarPorVidaMetodoB(ArrayList<Soldado> soldadito) {
        Collections.sort(soldadito, new Comparator<Soldado>() {
            public int compare(Soldado s1, Soldado s2) {
                // Orden descendente por puntos de vida
                return Integer.compare(s2.getPuntos(), s1.getPuntos());
            }
        });
    }
}