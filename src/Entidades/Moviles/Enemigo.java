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
	

	private static final int direccionAbajo = 0;
	private static final int direccionArriba = 1;
	private static final int direccionDerecha = 2;
	private static final int direccionIzquierda = 3;
	private static final int normalAbajo = 0;
	private static final int normalArriba = 1;
	private static final int normalDerecha = 2;
	private static final int normalIzquierda = 3;
	private static final int abajoAzul = 4;
	private static final int arribaAzul = 5;
	private static final int derechaAzul = 6;
	private static final int izquierdaAzul = 7;
	
	private int movimientoAnterior;
	
	public Enemigo(String string) {
		miRepresentacion = new EnemigoGUI();
		tamano = 32;
		v= new VisitorFantasma();
		representacion=string;
		estadoPowerPellet = false;
		movimientoAnterior = 4;
		 //Estado dispersarse
	}
	
	public int movAnterior() {
		return movimientoAnterior;
	}
	
	public void setMovAnterior(int mov) {
		movimientoAnterior = mov;
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
			cambiarImagen(arribaAzul);
		else 
			cambiarImagen(normalArriba);
		if(direccion != direccionArriba) {
			direccion = direccionArriba;
		}
		this.setY(posY - 4);
	}

	@Override
	public void moverAbajo() {
		if(estadoPowerPellet)
			cambiarImagen(abajoAzul);
		else
			cambiarImagen(normalAbajo);
		if(direccion != direccionAbajo) {
			direccion = direccionAbajo;
		}
		this.setY(posY + 4);
	}

	@Override
	public void moverIzquierda() {
		if(estadoPowerPellet)
			cambiarImagen(izquierdaAzul);
		else
			cambiarImagen(normalIzquierda);
		if(direccion != direccionIzquierda) {
			direccion = direccionIzquierda;
		}
		this.setX(posX - 4);
	}

	@Override
	public void moverDerecha() {
		if(estadoPowerPellet)
			cambiarImagen(derechaAzul);
		else
			cambiarImagen(normalDerecha);
		if(direccion != direccionDerecha) {
			direccion = direccionDerecha;
		}
		this.setX(posX + 4);
	}
	
	public void setEstadoPowerPellet(boolean estado) {
		this.estadoPowerPellet = estado;
		if(estado) {
			switch(direccion) {
			case direccionAbajo:
				cambiarImagen(abajoAzul);
				break;
			case direccionArriba: 
				cambiarImagen(arribaAzul);
				break;
			case direccionDerecha:
				cambiarImagen(derechaAzul);
				break;
			case direccionIzquierda:
				cambiarImagen(izquierdaAzul);
				break;
			}
		}else {
			switch(direccion) {
			case direccionAbajo:
				cambiarImagen(normalAbajo);
				break;
			case direccionArriba: 
				cambiarImagen(normalArriba);
				break;
			case direccionDerecha:
				cambiarImagen(normalDerecha);
				break;
			case direccionIzquierda:
				cambiarImagen(normalIzquierda);
				break;
			}
		}
	}
	
	public void cambiarImagen(int num) {
		switch(num) {
		case normalAbajo:
			this.miRepresentacion.rotarAbajo();
			break;
		case normalArriba: 
			this.miRepresentacion.rotarArriba();
			break;
		case normalDerecha:
			this.miRepresentacion.rotarDer();
			break;
		case normalIzquierda:
			this.miRepresentacion.rotarIzq();
			break;
		case abajoAzul:
			this.miRepresentacion.azulAbajo();
			break;
		case arribaAzul:
			this.miRepresentacion.azulArriba();
			break;
		case derechaAzul: 
			this.miRepresentacion.azulDer();
			break;
		case izquierdaAzul: 
			miRepresentacion.azulIzquierda();
			break;
		}
		this.setIcon(new ImageIcon(VentanaGUI.class.getResource(miRepresentacion.getImagen())));
	}
	
}
