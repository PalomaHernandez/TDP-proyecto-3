package Entidades.Estaticas;

import Entidades.Moviles.Protagonista;
import GUI.PacDotGUI;
import Logica.Juego;
import Visitors.Visitor;

public class PacDot extends Punto{

	private static final long serialVersionUID = 1L;
	private PacDotGUI miRepresentacion;
	
	public PacDot(String pacDot) {
		miRepresentacion = new PacDotGUI(pacDot);
		this.representacion = pacDot;
		tamano = 10;
	}

	@Override
	public void accept(Visitor v, Juego j) {
		v.visit(this, j);
	}

}
