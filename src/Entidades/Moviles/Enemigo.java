package Entidades.Moviles;

import GUI.EnemigoGUI;
import Logica.Juego;
import Visitors.Visitor;
import Visitors.VisitorFantasma;

public abstract class Enemigo extends Movil {
	
	/**
	 *                                                                                                                                                                                                                                                                                                                                                                                              
	 */
	private static final long serialVersionUID = 1L;
	protected EnemigoGUI miRepresentacion;
	protected int estado;
	
	public Enemigo(String string) {
		miRepresentacion = new EnemigoGUI();
		tamano = 20;
		v= new VisitorFantasma();
		representacion=string;
		estado = 0; //Estado dispersarse
	}
	
	public boolean accept(Visitor v, Juego j) {
		v.visit(this, j);		
		return false;
	}
	
	public EnemigoGUI getGUI() {
		return miRepresentacion;
	}

	public int getEstado() {
		return estado;
	}
	
	public void setEstado(int estado) {//0 dispersarse, 1 perseguir,  2 correr. 3 morir (ir a la casa)
		this.estado = estado;
	}
	
	@Override
	public void moverArriba() {

		if(direccion != 1) {
			cambiarImagen(1);
			direccion = 1;
		}
		this.setY(posY - 4);
	}

	@Override
	public void moverAbajo() {
		
		if(direccion != 0) {
			cambiarImagen(0);
			direccion = 0;
		}
		this.setY(posY + 4);
	}

	@Override
	public void moverIzquierda() {
		
		if(direccion != 3) {
			cambiarImagen(3);
			direccion = 3;
		}
		this.setX(posX - 4);
	}

	@Override
	public void moverDerecha() {
		if(direccion != 2) {
			cambiarImagen(2);
			direccion = 2;
		}
		this.setX(posX + 4);
	}
}
