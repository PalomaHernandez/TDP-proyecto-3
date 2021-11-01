package GUI;

public class ProtagonistaGUI extends MovilGUI {
	
	public ProtagonistaGUI(String abajo, String arriba, String derecha, String izquierda, String azul, String bomba, String velocidad, int x, int y) {
		super(x, y);
		representacion = new String[7];
		this.estadoActual = abajo;
		
		representacion[0] = abajo;
		representacion[1] = arriba;
		representacion[2] = derecha;
		representacion[3] = izquierda;
		representacion[4] = azul;
		representacion[5] = bomba;
		representacion[6] = velocidad;
	}
	
	public void bomba() {
		estadoActual = representacion[5];
	}
	
	public void velocidad() {
		estadoActual = representacion[6];
	}
	
}
