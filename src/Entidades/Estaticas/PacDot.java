package Entidades.Estaticas;

import Entidades.Entidad;
import GUI.PacDotGUI;
import Logica.Juego;
import Visitors.Visitor;

public class PacDot extends Entidad{

	private static final long serialVersionUID = 1L;
	private PacDotGUI miRepresentacion;
	
	public PacDot(String pacDot) {
		miRepresentacion = new PacDotGUI(pacDot);
		this.representacion = pacDot;
		tamano = 10;
	}

	public boolean accept(Visitor v, Juego j) {
		v.visit(this, j);
		return false;
	}

	public PacDotGUI getGUI() {
		return miRepresentacion;
	}
	
}
