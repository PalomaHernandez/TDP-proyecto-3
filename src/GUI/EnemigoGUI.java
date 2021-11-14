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
		this.estadoActual = abajo;
	}

	public void setAzul(String azulAbajo, String azulArriba, String azulIzquierda, String azulDerecha) {
		representacion[4] = azulAbajo;
		representacion[5] = azulArriba;
		representacion[6] = azulDerecha;
		representacion[7] = azulIzquierda;
		this.estadoActual=azulAbajo;
	}
	
	public void azulAbajo() {
		this.estadoActual = representacion[4];
	}

	public void azulArriba() {
		this.estadoActual = representacion[5];
	}

	public void azulDer() {
		this.estadoActual = representacion[6];
	}

	public void azulIzquierda() {
		this.estadoActual = representacion[7];
	}
}
