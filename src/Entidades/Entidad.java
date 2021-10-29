package Entidades;

import Logica.Juego;
import Logica.Zona;
import Visitors.Visitor;

public abstract class Entidad {
	
	protected int posX;
	protected int posY;
	protected Visitor visitor;
	protected Zona miZona;
	protected Juego miJuego;
	
	public int getX() {
		return posX;
	}
	
	public int getY() {
		return posY;
	}
	
	public Zona getZona() {
		return miZona;
	}
	
	public Visitor getVisitor() {
		return visitor;
	}
}
