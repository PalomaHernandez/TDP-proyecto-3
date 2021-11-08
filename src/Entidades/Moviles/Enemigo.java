package Entidades.Moviles;

import GUI.EnemigoGUI;
import Visitors.Visitor;

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

	@Override
	public void accept(Visitor v) {
		// TODO Auto-generated method stub
		
	}
	
}
