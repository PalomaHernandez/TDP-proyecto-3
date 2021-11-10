package Entidades.Estaticas;


import Entidades.Moviles.Protagonista;
import Logica.Juego;
import Logica.Nivel;
import Logica.Zona;
import Visitors.Visitor;

public abstract class Punto extends Estatica{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	protected int cantPuntos;
	protected Visitor v;
	
	public int getCantPuntos() {
		return cantPuntos;
	}
	
	public void setCantPuntos(int cantidad) {
		cantPuntos=cantidad;
	}
	
	public Visitor getVisitor() {
		return v;
	}
	
	public abstract void accept(Visitor v, Juego j);
}
