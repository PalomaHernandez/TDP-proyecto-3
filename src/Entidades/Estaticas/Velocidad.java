package Entidades.Estaticas;

import GUI.VelocidadGUI;
import Visitors.Visitor;

public class Velocidad extends Pocion {
	
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

	@Override
	public void accept(Visitor v) {
		// TODO Auto-generated method stub
		
	}
	
}
