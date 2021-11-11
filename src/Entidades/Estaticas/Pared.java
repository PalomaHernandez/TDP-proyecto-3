package Entidades.Estaticas;

import GUI.ParedGUI;
import Logica.Juego;
import Visitors.Visitor;

public class Pared extends Estatica {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private ParedGUI miRepresentacion;
	
	public Pared(String pared) {
		miRepresentacion = new ParedGUI(pared);
		representacion = miRepresentacion.getImagen();
		tamano = 32;
		esPared = true;
	}
	
	public ParedGUI getRepre() {
		return miRepresentacion;
	}
	
	public void setImagen(int repre) {
		miRepresentacion.setImagen(repre);
		this.representacion = miRepresentacion.getImagen();
	}

	@Override
	public boolean accept(Visitor v, Juego j) {
		v.visit(this);
		return true;
	}
	
}
