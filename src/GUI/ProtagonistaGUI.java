package GUI;

public class ProtagonistaGUI extends MovilGUI {
	
	private String[] representacion;
	private String estadoActual; 
	
	public ProtagonistaGUI(String abajo, String arriba, String derecha, String izquierda, String azul, String bomba, String velocidad, int x, int y) {
		super(x, y);
		representacion = new String[7];
		estadoActual = abajo;
		
		representacion[0] = abajo;
		representacion[1] = arriba;
		representacion[2] = derecha;
		representacion[3] = izquierda;
		representacion[4] = azul;
		representacion[5] = bomba;
		representacion[6] = velocidad;
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
		estadoActual = representacion[5];
	}
	
	public void velocidad() {
		estadoActual = representacion[6];
	}
	
	public String getImagen() {
		return estadoActual;
	}
}
