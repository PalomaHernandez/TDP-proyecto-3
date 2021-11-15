package GUI;

public class EnemigoGUI extends MovilGUI{

	public EnemigoGUI() {
		
		representacion= new String[8];

	}

	public void setNormal(String abajo, String arriba, String izquierda, String derecha) {
		representacion[0] = abajo;
		representacion[1] = arriba;
		representacion[2] = derecha;
		representacion[3] = izquierda;
		this.estadoActual = arriba;
	}

	public void setAzul(String azulAbajo, String azulArriba, String azulIzquierda, String azulDerecha) {
		representacion[4] = azulArriba;
		representacion[5] = azulAbajo;
		representacion[6] = azulIzquierda;
		representacion[7] = azulDerecha;
	}
	
	
	
	public void azulAbajo() {
		this.estadoActual = representacion[5];
	}

	public void azulArriba() {
		this.estadoActual = representacion[4];
	}

	public void azulDer() {
		this.estadoActual = representacion[7];
	}

	public void azulIzquierda() {
		this.estadoActual = representacion[6];
	}
}
