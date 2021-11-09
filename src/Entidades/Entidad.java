package Entidades;

import javax.swing.JLabel;

import Logica.Juego;
import Logica.Nivel;
import Logica.Zona;
import Visitors.Visitor;

public abstract class Entidad extends JLabel{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	protected int posX;
	protected int posY;
	protected Visitor v;
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
		this.setBounds(posX, posY, this.getWidth(), this.getHeight());
	}
	
	public void setPos(int posX, int posY) {
		this.posX = posX;
		this.posY = posY;
		this.setBounds(this.posX, this.posY, this.getWidth(), this.getHeight());
	}
	
	public void setY(int posY) {
		this.posY = posY;
		this.setBounds(posX, posY, this.getWidth(), this.getHeight());
	}
	
	public Zona getZona() {
		return miZona;
	}
	
	public Visitor getVisitor() {
		return v;
	}
	
	public abstract void accept(Visitor v);
	
	public String getRepresentacion() {
		return representacion;
	}
	
//	public void setRepresentacion(String s) {
//		representacion=s;
//	}
}
