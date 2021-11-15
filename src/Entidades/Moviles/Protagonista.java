package Entidades.Moviles;

import javax.swing.ImageIcon;

import GUI.ProtagonistaGUI;
import GUI.VentanaGUI;
import Hilos.HiloMoverProtagonista;
import Logica.Juego;
import Logica.Zona;
import Visitors.Visitor;
import Visitors.VisitorProtagonista;

public class Protagonista extends Movil {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	protected Visitor v;
	protected boolean estadoVelocidad;
	protected boolean estadoBomba;
	protected boolean estadoPowerPellet;
	protected int vidas;
	protected ProtagonistaGUI miRepresentacion;
	
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
	
	
	public void setEstadoBomba(boolean estado) {
		this.estadoBomba = estado;
		if(estado) {
			switch(direccion) {
			case 0:
				cambiarImagen(8);
				break;
			case 1: 
				cambiarImagen(9);
				break;
			case 2:
				cambiarImagen(10);
				break;
			case 3:
				cambiarImagen(11);
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
	
	public void setEstadoVelocidad(boolean estado) {
		this.estadoVelocidad = estado;
		if(estado) {
			switch(direccion) {
			case 0:
				cambiarImagen(12);
				break;
			case 1: 
				cambiarImagen(13);
				break;
			case 2:
				cambiarImagen(14);
				break;
			case 3:
				cambiarImagen(15);
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
	
	public void moverAbajo() {
		if(estadoVelocidad) 
			cambiarImagen(12);
		if(estadoPowerPellet) 
			cambiarImagen(4);
		if(estadoBomba) 
			cambiarImagen(8);
		if(!estadoVelocidad && !estadoBomba && !estadoPowerPellet)
			cambiarImagen(0);
		
		if(direccion != 0) {
			direccion = 0;
		}
		this.setY(posY + 4);
	}
	
	public void moverArriba() {
		if(estadoVelocidad) 
			cambiarImagen(13);
		if(estadoPowerPellet) 
			cambiarImagen(5);
		if(estadoBomba) 
			cambiarImagen(9);
		if(!estadoVelocidad && !estadoBomba && !estadoPowerPellet)
			cambiarImagen(1);
		if(direccion != 1) {
			direccion = 1;
		}
		this.setY(posY - 4);
	}

	public void moverIzquierda() {
		if(estadoVelocidad) 
			cambiarImagen(15);
		else if(estadoPowerPellet) 
			cambiarImagen(7);
		else if(estadoBomba) 
			cambiarImagen(11);
		if(!estadoVelocidad && !estadoBomba && !estadoPowerPellet)
			cambiarImagen(3);

		if(direccion != 3) {
			direccion = 3;
		}
		this.setX(posX - 4);
		
	}
	
	public void moverDerecha() {
		if(estadoVelocidad) 
			cambiarImagen(14);
		if(estadoPowerPellet) 
			cambiarImagen(6);
		if(estadoBomba) 
			cambiarImagen(10);
		if(!estadoVelocidad && !estadoBomba && !estadoPowerPellet)
			cambiarImagen(2);
		
		if(direccion != 2) {
			direccion = 2;
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
		case 8:
			miRepresentacion.bombaAbajo();
			break;
		case 9: 
			miRepresentacion.bombaArriba();
			break;
		case 10: 
			miRepresentacion.bombaDer();
			break;
		case 11: 
			miRepresentacion.bombaIzquierda();
			break;
		case 12:
			miRepresentacion.velocidadAbajo();
			break;
		case 13:
			miRepresentacion.velocidadArriba();
			break;
		case 14:
			miRepresentacion.velocidadDer();
			break;
		case 15:
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
		return false;
	}
	
}
