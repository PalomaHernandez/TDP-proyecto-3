package Entidades;

import javax.swing.JLabel;

import Entidades.Moviles.Protagonista;
import GUI.EntidadGUI;
import Logica.Juego;
import Visitors.Visitor;

public abstract class Entidad extends JLabel{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	protected int posX;
	protected int posY;
	protected Visitor v;
	protected boolean visible;
	protected String representacion;
	protected int tamano;
	protected boolean esPared = false;

	
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
	
	public Visitor getVisitor() {
		return v;
	}
	
	public abstract boolean accept(Visitor v, Juego j);
	
	public String getRepresentacion() {
		return representacion;
	}

	public boolean esPared() {
		return esPared;
	}

	
//	public void setRepresentacion(String s) {
//		representacion=s;
//	}
}
