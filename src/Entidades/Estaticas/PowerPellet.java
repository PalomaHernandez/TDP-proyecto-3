package Entidades.Estaticas;

import Entidades.Entidad;
import Logica.Juego;
import Visitors.Visitor;

public class PowerPellet extends Entidad{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public PowerPellet(String powerPellet) {
		this.representacion = powerPellet;
		tamano = 20;
	}

	@Override
	public boolean accept(Visitor v, Juego j) {
		v.visit(this,j); 
		return false;
	}

}
