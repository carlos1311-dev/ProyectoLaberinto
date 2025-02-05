package co.udistrital.edu.model;
import java.util.List;
import java.util.ArrayList;

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
	
	public void Mover(int dx, int dy, int MaxFilas, int MaxColumnas, List<Muro> muros) {
		
		if(dx == 0 && dy !=0 || dy == 0 && dx == 0) { //Solo se mueve vertical u horizontalmente
			int nuevoX = x+dx;
			int nuevoY = y+dy;
			
			if(movimientosRestantes > 0 && nuevoX >= 0 && nuevoY >= 0 && nuevoX < MaxFilas && nuevoY > MaxColumnas && !posicionBloqueadaPorMuro(nuevoX,nuevoY,muros)) {
				x = nuevoX;
				y = nuevoY;
				movimientosRestantes --;
			}else {
				System.out.println("Movimiento invalido");
			}
		}
	}
	
	private Boolean posicionBloqueadaPorMuro(int x, int y, List<Muro> muros) { //metodo que verifica que en la siguiente casilla no haya un muro
		for(Muro muro: muros) {
			if(muro.getX() == x && muro.getY() == y) {
				return true;
			}
		}return false;
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

	public void setMovimientosRestantes(int movimientosRestantes) {
		this.movimientosRestantes = movimientosRestantes;
	}
	

	
}
