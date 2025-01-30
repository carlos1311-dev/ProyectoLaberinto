package co.udistrital.edu.model;
import java.util.ArrayList;
import java.util.List;

public class Laberinto {
	private int filas;
	private int columnas;
	private Carro carro;
	private List<PuntosObjetivo> puntoObjetivo;
	private List<Muro> muros;
	private List<Bestia> bestias;
	
	public Laberinto(int filas, int columnas, int movimientosIniciales) {
		super();
		this.filas = filas;
		this.columnas = columnas;
		this.carro = new Carro(0,0,movimientosIniciales);
		this.puntoObjetivo = new ArrayList<>();
		this.bestias = new ArrayList<>();
		this.muros = new ArrayList<>();
	}

		public Carro getCarro() {
		return carro;
	}
		public void agregarPuntoObjetivo(PuntosObjetivo puntos) {
			puntoObjetivo.add(puntos);
		}
		public void agregarBestia(Bestia bestia) {
			bestias.add(bestia);
		}
		public void agregarMuro(Muro muro) {
			muros.add(muro);
		}

}
