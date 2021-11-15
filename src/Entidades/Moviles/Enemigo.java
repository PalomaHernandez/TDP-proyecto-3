package Entidades.Moviles;

import javax.swing.ImageIcon;

import GUI.EnemigoGUI;
import GUI.VentanaGUI;
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
	protected boolean estadoPowerPellet;
	
	public Enemigo(String string) {
		miRepresentacion = new EnemigoGUI();
		tamano = 32;
		v= new VisitorFantasma();
		representacion=string;
		estadoPowerPellet = false;
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

		if(estadoPowerPellet)
			cambiarImagen(5);
		else 
			cambiarImagen(1);
		if(direccion != 1) {
			direccion = 1;
		}
		this.setY(posY - 4);
	}

	@Override
	public void moverAbajo() {
		if(estadoPowerPellet)
			cambiarImagen(4);
		else
			cambiarImagen(0);
		if(direccion != 0) {
			direccion = 0;
		}
		this.setY(posY + 4);
	}

	@Override
	public void moverIzquierda() {
		if(estadoPowerPellet)
			cambiarImagen(7);
		else
			cambiarImagen(3);
		if(direccion != 3) {
			direccion = 3;
		}
		this.setX(posX - 4);
	}

	@Override
	public void moverDerecha() {
		if(estadoPowerPellet)
			cambiarImagen(6);
		else
			cambiarImagen(2);
		if(direccion != 2) {
			direccion = 2;
		}
		this.setX(posX + 4);
	}
	
	public void setEstadoPowerPellet(boolean estado) {
		this.estadoPowerPellet = estado;
		if(estado) {
			switch(direccion) {
			case 0:
				cambiarImagen(4);
				break;
			case 1: 
				cambiarImagen(5);
				break;
			case 2:
				cambiarImagen(6);
				break;
			case 3:
				cambiarImagen(7);
				break;
			}
		}else {
			switch(direccion) {
			case 0:
				cambiarImagen(0);
				break;
			case 1: 
				cambiarImagen(1);
				break;
			case 2:
				cambiarImagen(2);
				break;
			case 3:
				cambiarImagen(3);
				break;
			}
		}
	}
	
	public void cambiarImagen(int num) {
		switch(num) {
		case 0:
			this.miRepresentacion.rotarAbajo();
			break;
		case 1: 
			this.miRepresentacion.rotarArriba();
			break;
		case 2:
			this.miRepresentacion.rotarDer();
			break;
		case 3:
			this.miRepresentacion.rotarIzq();
			break;
		case 4:
			this.miRepresentacion.azulAbajo();
			break;
		case 5:
			this.miRepresentacion.azulArriba();
			break;
		case 6: 
			this.miRepresentacion.azulDer();
			break;
		case 7: 
			miRepresentacion.azulIzquierda();
			break;
		}
		this.setIcon(new ImageIcon(VentanaGUI.class.getResource(miRepresentacion.getImagen())));
	}
	
}
