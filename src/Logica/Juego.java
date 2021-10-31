package Logica;

import Entidades.Moviles.Movil;
import Fabrica.Director;
import GUI.VentanaGUI;

public class Juego {

	private VentanaGUI miVentana;
	private Director miDirector;
	
	public void moverEntidad(int posX, int posY, int posXFin, int posYFin, Movil movil) {
		miVentana.moverEntidad(posX, posY, posXFin, posYFin, movil.getRepresentacion());
	}

}
