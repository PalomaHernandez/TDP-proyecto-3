package Entidades;

import Logica.Juego;
import Logica.Zona;
import Visitors.Visitor;

public abstract class Entidad {
	
	protected int posX;
	protected int posY;
	protected Visitor visitor;
	protected Zona miZona;
	protected boolean visible;
	protected String representacion;
	protected int tamano;
	
	public void setVisible(boolean visible) {
		this.visible = visible;
	}
	
	public int getTamano() {
		return tamano;
	}
	
	public boolean getVisible() {
		return visible;
	}
	
	public int getX() {
		return posX;
	}
	
	public int getY() {
		return posY;
	}
	
	public void setX(int posX) {
		this.posX = posX;
	}
	
	public void setY(int posY) {
		this.posY = posY;
	}
	
	public Zona getZona() {
		return miZona;
	}
	
	public Visitor getVisitor() {
		return visitor;
	}
	
	public String getRepresentacion() {
		return representacion;
	}
}
