package GUI;

public class EnemigoGUI extends MovilGUI{

	public EnemigoGUI(String abajo, String arriba, String izquierda, String derecha, String azul) {
		
		representacion= new String[5];
		this.estadoActual = abajo;
		
		representacion[0] = abajo;
		representacion[1] = arriba;
		representacion[2] = derecha;
		representacion[3] = izquierda;
		representacion[4] = azul;
	}

}
