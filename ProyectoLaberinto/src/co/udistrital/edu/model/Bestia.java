package co.udistrital.edu.model;
import java.util.Random;

public class Bestia {
	protected int x;
	protected int y;
	
	public Bestia(int x, int y) {
		super();
		this.x = x;
		this.y = y;
	} 
	
	public void mover(int MaxFilas, int MaxColumnas){
		Random random = new Random();
		int dx = random.nextInt(3) -1; // de -1 hasta 1
		int dy = random.nextInt(3) -1;
		
		int newX = x+dx;
		int newY = y+dy;
		
		if(newX >= 0 && newX < MaxFilas && newY >= 0 && newY < MaxColumnas) {
			x = newX;
			y = newY;
		}
		
	}

	protected int getX() {
		return x;
	}
	protected int getY() {
		return y;
	}

}
