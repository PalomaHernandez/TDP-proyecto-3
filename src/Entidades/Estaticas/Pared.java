package Entidades.Estaticas;

import GUI.ParedGUI;

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
	
}
