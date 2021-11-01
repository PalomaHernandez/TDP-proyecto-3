package GUI;

public class ProtagonistaGUI extends MovilGUI {
	
	public ProtagonistaGUI() {
		representacion = new String[16];
	}
	
	public void setNormal(String arriba, String abajo, String derecha, String izquierda) {
		representacion[0] = arriba;
		representacion[1] = abajo;
		representacion[2] = derecha;
		representacion[3] = izquierda;
		this.estadoActual = izquierda;
	}
	
	public void setAzul(String azulArriba, String azulAbajo, String azulDerecha, String azulIzquierda) {
		representacion[4] = azulArriba;
		representacion[5] = azulAbajo;
		representacion[6] = azulDerecha;
		representacion[7] = azulIzquierda;
	}
	
	public void setBomba(String bombaArriba, String bombaAbajo, String bombaDerecha, String bombaIzquierda) {
		representacion[8] = bombaArriba;
		representacion[9] = bombaAbajo;
		representacion[10] = bombaDerecha;
		representacion[11] = bombaIzquierda;
	}
	
	public void setVelocidad(String velocidadArriba, String velocidadAbajo, String velocidadDerecha, String velocidadIzquierda) {
		representacion[12] = velocidadArriba;
		representacion[13] = velocidadAbajo;
		representacion[14] = velocidadDerecha;
		representacion[15] = velocidadIzquierda;
	}
	
	
}
