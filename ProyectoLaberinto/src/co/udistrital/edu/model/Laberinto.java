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
	
	public void verificarEncuentros() {
		for(Bestia bestia: bestias) {
			if(carro.getX() == bestia.getX() && carro.getY() == bestia.getY()) {
				if(bestia instanceof AsesinoLetal) {
					System.out.println("¡Te encontraste con un AsesinoLetal, has perdido!!!");
				}else if(bestia instanceof Tormentoso) {
					int penalizacion = (int) (carro.getMovimientosRestantes()*0.05); //consul
					System.out.println("¡Te encontraste con Bestia Tormentosa: se penalizan: "+ (int) (carro.getMovimientosRestantes()*0.05)+ "movimientos");
					
				}
			}
		}
	}
	
	public void penalizarMovimientos(int movimientos) {
		int penalizacion = (int) (carro.getMovimientosRestantes()*0.05);
		carro.setMovimientosRestantes(Math.max(0, carro.getMovimientosRestantes() - penalizacion)); // usa Math.max que elige el mayor de dos números dados, para que no haya negativos
		
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
