package Entidades.Estaticas;

import Visitors.Visitor;

public abstract class Punto extends Estatica{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	int cantPuntos;
	Visitor v;
	
	public int getCantPuntos() {
		return cantPuntos;
	}
	
	public void setCantPuntos(int cantidad) {
		cantPuntos=cantidad;
	}
	
	public abstract void accept(Visitor v);
}
