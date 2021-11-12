package GUI;

public abstract class MovilGUI {
	protected String[] representacion;
	protected String estadoActual; 
	protected int posX;
	protected int posY; 
	
	public MovilGUI() {
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
	
	public void bomba() {
		estadoActual= representacion[8];
	}
	
	public void velocidad() {
		estadoActual= representacion[12];
		
	}
	
	public String getImagen() {
		return estadoActual;
	}

}
