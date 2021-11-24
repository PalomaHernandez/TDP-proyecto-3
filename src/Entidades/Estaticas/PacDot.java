package Entidades.Estaticas;

import Entidades.Entidad;
import Logica.Juego;
import Visitors.Visitor;

public class PacDot extends Entidad{

	private static final long serialVersionUID = 1L;
	
	public PacDot(String pacDot) {
		this.representacion = pacDot;
		tamano = 10;
	}

	public boolean accept(Visitor v, Juego j) {
		v.visit(this, j);
		return false;
	}

}
