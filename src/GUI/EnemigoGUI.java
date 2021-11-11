package GUI;

public class EnemigoGUI extends MovilGUI{

	public EnemigoGUI() {
		
		representacion= new String[4];

	}

	public void setNormal(String abajo, String arriba, String izquierda, String derecha) {
		representacion[0] = abajo;
		representacion[1] = arriba;
		representacion[2] = derecha;
		representacion[3] = izquierda;
		this.estadoActual = abajo;
	}

}
