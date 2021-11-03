package Entidades.Moviles;

import GUI.EnemigoGUI;

public class Enemigo extends Movil {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private EnemigoGUI miRepresentacion;
	
	public Enemigo(String enemigo) {
		miRepresentacion = new EnemigoGUI(enemigo,enemigo, enemigo, enemigo, enemigo);
		this.representacion = enemigo;
		tamano = 20;
	}
	
}
