package Entidades.Estaticas;

import Entidades.Entidad;
import GUI.VelocidadGUI;
import Logica.Juego;
import Visitors.Visitor;

public class Velocidad extends Entidad {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private VelocidadGUI miRepresentacion;
	
	public Velocidad(String velocidad) {
		miRepresentacion = new VelocidadGUI(velocidad);
		this.representacion = velocidad;
		tamano = 20;
	}

	public VelocidadGUI getGUI() {
		return miRepresentacion;
	}
	
	@Override
	public boolean accept(Visitor v, Juego j) {
		v.visit(this, j);
		return false;
	}
	
}
