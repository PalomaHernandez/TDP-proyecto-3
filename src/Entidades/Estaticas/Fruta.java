package Entidades.Estaticas;

import GUI.FrutaGUI;
import Logica.Juego;
import Visitors.Visitor;

public class Fruta extends Pocion {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private FrutaGUI miRepresentacion;
	private int valorFruta;
	
	public Fruta(String fruta) {
		miRepresentacion = new FrutaGUI(fruta);
		this.representacion = fruta;
		tamano = 20;
	}

	@Override
	public boolean accept(Visitor v, Juego j) {
		v.visit(this, j);
		return false;
	}

	public int getValorFruta() {
		return valorFruta;
	}
	
	public void setValorFruta(int valor) {
		valorFruta=valor;
	}
	
}
