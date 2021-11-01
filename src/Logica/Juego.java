package Logica;

import Entidades.Moviles.Movil;
import Fabrica.Builder;
import Fabrica.BuilderNivel;
import Fabrica.Director;
import GUI.VentanaGUI;

public class Juego {

	private VentanaGUI miVentana;
	private Director miDirector;
	private Nivel miNivel;
	
	public Juego(int tema, VentanaGUI ventana) {
		miDirector = new Director(tema);
		miVentana = ventana;
		inicializarNivel1();
		
	}
	
	private void inicializarNivel1() {
		Builder constructorNivel1;
		
		constructorNivel1 = new BuilderNivel();
		
		miDirector.makeNivel1(constructorNivel1);
		
		miNivel = constructorNivel1.getResult();
		miVentana.inicializarNivel(miNivel.getNivel());
	}

	public void moverEntidad(int posX, int posY, int posXFin, int posYFin, Movil movil) {
		miVentana.moverEntidad(posX, posY, posXFin, posYFin, movil.getRepresentacion());
	}

}
