package Entidades.Estaticas;

import Entidades.Entidad;
import Logica.Juego;
import Visitors.Visitor;

public class Velocidad extends Entidad {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public Velocidad(String velocidad) {
		this.representacion = velocidad;
		tamano = 20;
	}
	
	@Override
	public boolean accept(Visitor v, Juego j) {
		v.visit(this, j);
		return false;
	}
	
}
