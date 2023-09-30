// RONI COMPANOCCA CHECCO
// CUI: 20210558
// LABORATORIO 05
// FUNDAMENTOS DE PROGRAMACION - laboratorio
// clase Soldado.java
public class Soldado {
	private String nombre;
	private int fila;
	private int columna;
	private int puntos;
	private String column;
	
	public Soldado() {
		nombre = "";
		fila = 0;
		columna = 0;
		puntos = 0;
		column = "";
	}

	// METODOS MUTADORES
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public void setFila(int fila) {
		this.fila = fila;
	}

	public void setColumna(int columna) {
		this.columna = columna;
	}

	public void setPuntos(int puntos) {
		this.puntos = puntos;
	}
	
	public void setColumn(String column) {
		this.column = column;
	}

	// METODOS ACCESORES
	public String getNombre() {
		return nombre;
	}

	public int getFila() {
		return fila;
	}

	public int getColumna() {
		return columna;
	}

	public int getPuntos() {
		return puntos;
	}
	
	public String getColumn() {
		return column;
	}
}
