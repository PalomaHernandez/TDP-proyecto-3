package Entidades.Estaticas;

import GUI.BombaGUI;

public class Bomba extends Pocion {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private BombaGUI miRepresentacion;
	
	public Bomba(String bomba) {
		miRepresentacion = new BombaGUI(bomba);
		this.representacion = bomba;
		tamano = 20;
	}
	
}
