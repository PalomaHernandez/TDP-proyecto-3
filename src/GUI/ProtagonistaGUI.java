package GUI;

public class ProtagonistaGUI extends MovilGUI {
	
	public ProtagonistaGUI() {
		representacion = new String[16];
	}
	
	public void setNormal(String arriba, String abajo, String derecha, String izquierda) {
		representacion[0] = abajo;
		representacion[1] = arriba;
		representacion[2] = derecha;
		representacion[3] = izquierda;
		this.estadoActual = izquierda;
	}
	
	public void setAzul(String azulArriba, String azulAbajo, String azulDerecha, String azulIzquierda) {
		representacion[4] = azulAbajo;
		representacion[5] = azulArriba;
		representacion[6] = azulDerecha;
		representacion[7] = azulIzquierda;
	}
	
	public void setBomba(String bombaArriba, String bombaAbajo, String bombaDerecha, String bombaIzquierda) {
		representacion[8] = bombaAbajo;
		representacion[9] = bombaArriba;
		representacion[10] = bombaDerecha;
		representacion[11] = bombaIzquierda;
	}
	
	public void setVelocidad(String velocidadArriba, String velocidadAbajo, String velocidadDerecha, String velocidadIzquierda) {
		representacion[12] = velocidadAbajo;
		representacion[13] = velocidadArriba;
		representacion[14] = velocidadIzquierda;
		representacion[15] = velocidadDerecha;
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

	public void bombaAbajo() {
		this.estadoActual = representacion[8];
	}

	public void bombaArriba() {
		this.estadoActual = representacion[9];
	}

	public void bombaDer() {
		this.estadoActual = representacion[10];
	}

	public void bombaIzquierda() {
		this.estadoActual = representacion[11];
	}

	public void velocidadAbajo() {
		this.estadoActual = representacion[12];
	}

	public void velocidadArriba() {
		this.estadoActual = representacion[13];
	}

	public void velocidadIzquierda() {
		this.estadoActual = representacion[14];
	}

	public void velocidadDer() {
		this.estadoActual = representacion[15];
	}
	
	
}
