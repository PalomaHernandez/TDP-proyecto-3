package Logica;

import Entidades.Moviles.Movil;
import GUI.VentanaGUI;

public class Juego {

	private VentanaGUI miVentana;
	
	public void moverEntidad(int posX, int posY, int posXFin, int posYFin, Movil movil) {
		miVentana.moverEntidad(posX, posY, posXFin, posYFin, movil.getRepresentacion());
	}

}
