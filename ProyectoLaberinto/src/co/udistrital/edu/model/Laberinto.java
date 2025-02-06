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
	private int indicePuntoActual;
	private Boolean recorridoInverso;
	
	public Laberinto(int filas, int columnas, int movimientosIniciales) {
		super();
		this.filas = filas;
		this.columnas = columnas;
		this.carro = new Carro(0,0,movimientosIniciales);
		this.puntoObjetivo = new ArrayList<>();
		this.bestias = new ArrayList<>();
		this.muros = new ArrayList<>();
	}
	
	public void setRecorridoInverso(boolean recorridoInverso) { 
		this.recorridoInverso = recorridoInverso;
		if(recorridoInverso) {                                 //Si el valor de recorridoInverso(boolean) es true, el indice de puntos tomará el último valor de puntosObjetivo
			indicePuntoActual = puntoObjetivo.size()-1;
		}else{
			indicePuntoActual = 0;
		}
	}
	
	public void verificarPuntoObjetivo() {
		if(!puntoObjetivo.isEmpty()) {
			PuntosObjetivo puntoActual = puntoObjetivo.get(indicePuntoActual);
			if(carro.getX() == puntoActual.getX() && carro.getY() == puntoActual.getY()) { // Verifica que el carrito este en la misma posicion que el puntoObjetivo actual
				puntoActual.setAlcanzado(true); 
				System.out.println("Punto objetivo " + puntoActual.getOrden() + " alcanzado");
				actualizarIndicePuntoObjetivo();
			}
	   }
	}
	
	public void actualizarIndicePuntoObjetivo() {
		if(recorridoInverso) {
			if(indicePuntoActual > 0) { // Si el indice es mayor que 0, restar, pues está en orden inverso
				indicePuntoActual--;
			}
		}else {
			if(indicePuntoActual < puntoObjetivo.size()-1) { //Si el indice actual es menor que el último elemento de la lista, sumar hasta alcanzar el máximo
				indicePuntoActual ++;
			}
		}
	}
	
	public void verificarVictoria() {
		for(PuntosObjetivo punto: puntoObjetivo) {
			boolean victoria = true;
			if(!punto.isAlcanzado()) {
				victoria = false;
				break;
			}
		}
	}
	public void verificarEncuentros() {
		for(Bestia bestia: bestias) {
			if(carro.getX() == bestia.getX() && carro.getY() == bestia.getY()) {
				if(bestia instanceof AsesinoLetal) {
					System.out.println("¡Te encontraste con un AsesinoLetal, has perdido!!!");
					return;
				}else if(bestia instanceof Tormentoso) {
					int penalizacion = (int)(carro.getMovimientosRestantes()*0.05);
					System.out.println("¡Te encontraste con Bestia Tormentosa: se penalizan: "+ penalizacion + "movimientos");
					penalizarMovimientos(penalizacion);
				}
			}
		}
	}
	
	public void penalizarMovimientos(int penalizacion) {
		carro.setMovimientosRestantes(Math.max(0, carro.getMovimientosRestantes() - penalizacion)); // usa Math.max que elige el mayor de dos números dados, para que no haya negativos
	}
	
	public void verificarEntreMuros() {
		for(int i= 0; i > muros.size()-1; i++) {
			for (int j= i+1; j > muros.size(); j++) {
				Muro muro1 = muros.get(i);
				Muro muro2 = muros.get(j);
				if (estarEntreMuros(muro1,muro2)) {
					int penalizacion = carro.getX() + carro.getY();
					System.out.println("Estas entre dos muros, penalizacion de :"+ penalizacion + "movimientos");
					penalizarMovimientos(penalizacion);
				}
			}
		}
	}
	private boolean estarEntreMuros(Muro muro1, Muro muro2) {
	    return (carro.getX() == muro1.getX() && carro.getX() == muro2.getX() &&  //Verifica que el carro esté en la misma fila que los dos muros
	            carro.getY() > Math.min(muro1.getY(), muro2.getY()) &&          //Si la posicion en y es mayor que el muro que está mas bajo, y menor que el que está mas alto, significa que está entre los dos muros
	            carro.getY() < Math.max(muro1.getY(), muro2.getY()) ||
	           (carro.getY() == muro1.getY() && carro.getY() == muro2.getY()) && // Verifica que el carro esté en la misma columna que los dos muros
	            carro.getX() > Math.min(muro1.getX(), muro2.getX()) &&         //Si la posicion en x es mayor que el muro que está mas a la izquierda, y menor que el que está mas a la derecha, significa que está entre los dos muros
	            carro.getX() < Math.max(muro1.getX(), muro2.getX()));
	}
	
	public void moverBestias() {
		for(Bestia bestia: bestias) {
			bestia.mover(filas,columnas);
		}
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
