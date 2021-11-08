package Entidades.Estaticas;

import GUI.ParedGUI;
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
	}
	
	public ParedGUI getRepre() {
		return miRepresentacion;
	}
	
	public void setImagen(int repre) {
		miRepresentacion.setImagen(repre);
		this.representacion = miRepresentacion.getImagen();
	}

	@Override
	public void accept(Visitor v) {
		// TODO Auto-generated method stub
		
	}
	
}
