package Entidades.Estaticas;

import GUI.FrutaGUI;
import Visitors.Visitor;

public class Fruta extends Pocion {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private FrutaGUI miRepresentacion;
	
	public Fruta(String fruta) {
		miRepresentacion = new FrutaGUI(fruta);
		this.representacion = fruta;
		tamano = 20;
	}

	@Override
	public void accept(Visitor v) {
		// TODO Auto-generated method stub
		
	}
	
}
