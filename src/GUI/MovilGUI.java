package GUI;

import javax.swing.JPanel;

public abstract class MovilGUI {
	private String[] representacion;
	private String estadoActual; 
	protected int posX;
	protected int posY; 
	
	public MovilGUI(int x, int y) {
		posX = x;
		posY = y;
	}
	
	public void rotarAbajo() {
		estadoActual = representacion[0];
	}
	
	public void rotarArriba() {
		estadoActual = representacion[1];
	}
	
	public void rotarDer() {
		estadoActual = representacion[2];
	}
	
	public void rotarIzq() {
		estadoActual = representacion[3];
	}
	
	public void ponerAzul() {
		estadoActual = representacion[4];
	}
	
	public String getImagen() {
		return estadoActual;
	}
}
