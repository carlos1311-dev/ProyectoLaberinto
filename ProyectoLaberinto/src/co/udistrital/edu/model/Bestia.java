package co.udistrital.edu.model;

public abstract class Bestia {
	protected int x;
	protected int y;
	
	public Bestia(int x, int y) {
		super();
		this.x = x;
		this.y = y;
	} 
	
	public abstract void mover(int MaxFilas, int MaxColumnas);

	public int getX() {
		return x;
	}
	public int getY() {
		return y;
	}

}
