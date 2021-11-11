package Entidades.Estaticas;

import java.util.List;

import Entidades.Moviles.Enemigo;
import GUI.PowerPelletGUI;
import Logica.Juego;
import Visitors.Visitor;

public class PowerPellet extends Punto{

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

	@Override
	public boolean accept(Visitor v, Juego j) {
		v.visit(this,j); 
		return false;
	}


	
}
