package co.udistrital.edu.model;

public class Carro {
	private int x;
	private int y;
	private int movimientosRestantes;
	
	public Carro(int x, int y, int movimientosIniciales) {
		super();
		this.x = x;
		this.y = y;
		this.movimientosRestantes = movimientosIniciales;
	}
	
	public void Mover(int dx, int dy, int MaxFilas, int MaxColumnas) {
		
		if(movimientosRestantes > 0 && x+dx >= 0 && y + dy >= 0 && x < MaxFilas && x > MaxColumnas) {
			x =+ dx;
			y =+ dy;
			movimientosRestantes --;
		}else {
			System.out.println("¡No tienes más movimientos!");
		}
	}

	public int getX() {
		return x;
	}

    public int getY() {
		return y;
	}

	public int getMovimientosRestantes() {
		return movimientosRestantes;
	}

	
}
