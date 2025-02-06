package co.udistrital.edu.model;

public class PuntosObjetivo {
	private int x;
	private int y; 
	private int orden;
	public boolean alcanzado;
	
	public PuntosObjetivo(int x, int y, int orden, boolean alcanzado) {
		super();
		this.x = x;
		this.y = y;
		this.orden = orden;
		this.alcanzado = false;
	}

	public int getX() {
		return x;
	}
	
	public int getY() {
		return y;
	}
	
	public int getOrden() {
		return orden;
	}

	public boolean isAlcanzado() {
		return alcanzado;
	}

	public void setAlcanzado(boolean alcanzado) {
		this.alcanzado = alcanzado;
	}
	
}

	