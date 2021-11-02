package Entidades.Estaticas;

import GUI.PowerPelletGUI;

public class PowerPellet extends Pocion{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private PowerPelletGUI miRepresentacion;
	
	public PowerPellet(String powerPellet) {
		miRepresentacion = new PowerPelletGUI(powerPellet);
		this.representacion = powerPellet;
		tamano = 20;
	}
	
}
