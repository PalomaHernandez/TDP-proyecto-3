package Entidades.Moviles;

import javax.swing.ImageIcon;

import GUI.ProtagonistaGUI;
import GUI.VentanaGUI;
import Logica.Juego;
import Visitors.Visitor;
import Visitors.VisitorProtagonista;

public class Protagonista extends Movil {

	private static final long serialVersionUID = 1L;
	protected Visitor v;
	protected boolean estadoVelocidad;
	protected boolean estadoBomba;
	protected boolean estadoPowerPellet;
	protected int vidas;
	protected ProtagonistaGUI miRepresentacion;
	
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
	private static final int abajoBomba = 8;
	private static final int arribaBomba = 9;
	private static final int derechaBomba = 10;
	private static final int izquierdaBomba = 11;
	private static final int abajoVelocidad = 12;
	private static final int arribaVelocidad = 13;
	private static final int derechaVelocidad = 14;
	private static final int izquierdaVelocidad = 15;
	
	
	public Protagonista(Juego miJuego) {
		this.miJuego = miJuego;
		miRepresentacion = new ProtagonistaGUI();
		estadoVelocidad = false;
		estadoBomba = false;
		estadoPowerPellet = false;
		vidas = 3;
		tamano = 32;
		v= new VisitorProtagonista();
	}
	
	public int getDireccion() {
		return direccion;
	}
	
	public void setEstadoBomba(boolean estado) {
		this.estadoBomba = estado;
		if(estado) {
			switch(direccion) {
			case direccionAbajo:
				cambiarImagen(abajoBomba);
				break;
			case direccionArriba: 
				cambiarImagen(arribaBomba);
				break;
			case direccionDerecha:
				cambiarImagen(derechaBomba);
				break;
			case direccionIzquierda:
				cambiarImagen(izquierdaBomba);
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
	
	public void setEstadoPowerPellet(boolean estado) {
		this.estadoPowerPellet = estado;
		if(estado) {
			switch(direccion) {
			case direccionAbajo:
				cambiarImagen(abajoAzul);
				break;
			case arribaAzul: 
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
	
	public void setEstadoVelocidad(boolean estado) {
		this.estadoVelocidad = estado;
		if(estado) {
			switch(direccion) {
			case direccionAbajo:
				cambiarImagen(abajoVelocidad);
				break;
			case direccionArriba: 
				cambiarImagen(arribaVelocidad);
				break;
			case direccionDerecha:
				cambiarImagen(derechaVelocidad);
				break;
			case direccionIzquierda:
				cambiarImagen(izquierdaVelocidad);
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
	
	public void moverAbajo() {
		if(estadoVelocidad) 
			cambiarImagen(abajoVelocidad);
		if(estadoPowerPellet) 
			cambiarImagen(abajoAzul);
		if(estadoBomba) 
			cambiarImagen(abajoBomba);
		if(!estadoVelocidad && !estadoBomba && !estadoPowerPellet)
			cambiarImagen(normalAbajo);
		
		if(direccion != direccionAbajo) {
			direccion = direccionAbajo;
		}
		this.setY(posY + 4);
	}
	
	public void moverArriba() {
		if(estadoVelocidad) 
			cambiarImagen(arribaVelocidad);
		if(estadoPowerPellet) 
			cambiarImagen(arribaAzul);
		if(estadoBomba) 
			cambiarImagen(arribaBomba);
		if(!estadoVelocidad && !estadoBomba && !estadoPowerPellet)
			cambiarImagen(normalArriba);
		if(direccion != direccionArriba) {
			direccion = direccionArriba;
		}
		this.setY(posY - 4);
	}

	public void moverIzquierda() {
		if(estadoVelocidad) 
			cambiarImagen(izquierdaVelocidad);
		else if(estadoPowerPellet) 
			cambiarImagen(izquierdaAzul);
		else if(estadoBomba) 
			cambiarImagen(izquierdaBomba);
		if(!estadoVelocidad && !estadoBomba && !estadoPowerPellet)
			cambiarImagen(normalIzquierda);

		if(direccion != direccionIzquierda) {
			direccion = direccionIzquierda;
		}
		this.setX(posX - 4);
		
	}
	
	public void moverDerecha() {
		if(estadoVelocidad) 
			cambiarImagen(derechaVelocidad);
		if(estadoPowerPellet) 
			cambiarImagen(derechaAzul);
		if(estadoBomba) 
			cambiarImagen(derechaBomba);
		if(!estadoVelocidad && !estadoBomba && !estadoPowerPellet)
			cambiarImagen(normalDerecha);
		
		if(direccion != direccionDerecha) {
			direccion = direccionDerecha;
		}
		this.setX(posX + 4);
		
	}
	
	public ProtagonistaGUI getGUI() {
		return miRepresentacion;
	}
	
	public void setVidas(int vidas) {
		this.vidas = vidas;
	}
	
	public Visitor getVisitor() {
		return v;
	}
	public boolean getVelocidad() {
		return estadoVelocidad;
	}
	
	public boolean getBomba() {
		return estadoBomba;
	}
	
	public int getVidas() {
		return vidas;
	}
	
	public boolean getPowerPellet() {
		return estadoPowerPellet;
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
		case abajoBomba:
			miRepresentacion.bombaAbajo();
			break;
		case arribaBomba: 
			miRepresentacion.bombaArriba();
			break;
		case derechaBomba: 
			miRepresentacion.bombaDer();
			break;
		case izquierdaBomba: 
			miRepresentacion.bombaIzquierda();
			break;
		case abajoVelocidad:
			miRepresentacion.velocidadAbajo();
			break;
		case arribaVelocidad:
			miRepresentacion.velocidadArriba();
			break;
		case derechaVelocidad:
			miRepresentacion.velocidadDer();
			break;
		case izquierdaVelocidad:
			miRepresentacion.velocidadIzquierda();
			break;
		}
		this.setIcon(new ImageIcon(VentanaGUI.class.getResource(miRepresentacion.getImagen())));
	}
	
	public String getRepresentacion() {
		return miRepresentacion.getImagen();
	}

	@Override
	public boolean accept(Visitor v, Juego j) {
		v.visit(this, j);
		return false;
	}
	
}
