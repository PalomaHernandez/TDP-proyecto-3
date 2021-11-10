package Entidades.Estaticas;

import GUI.BombaGUI;
import Logica.Juego;
import Visitors.Visitor;

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

	@Override
	public void accept(Visitor v, Juego j) {
		v.visit(this, j);
	}
	
}
