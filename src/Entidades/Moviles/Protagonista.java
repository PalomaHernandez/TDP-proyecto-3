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
	

	public void moverAbajo() {
		if(direccion != 0) {
			cambiarImagen(0);
			direccion = 0;
		}
		this.setY(posY + 4);
		/*int posFin;

		//hilo = new HiloMoverProtagonista(20, miJuego);
		posFin = posY + 4;
		
		if(direccion != 0) {
			cambiarImagen(0);
			direccion = 0;
		}
		
		hilo.moverEntidad(posX, posY, posX, posFin, 0, this);
		//hilo.start();	
		
		*/

	}
	
	public void moverArriba() {
		if(direccion != 1) {
			cambiarImagen(1);
			direccion = 1;
		}
		this.setY(posY - 4);
		/*
		int posYFin;

		hilo = new HiloMoverProtagonista(20, miJuego);
		posYFin = posY - 4;
		if(direccion != 1) {
			cambiarImagen(1);
			direccion = 1;
		}
		
		// Este if deberia hacerse chequeando colisiones con paredes, no mirando el rangoif(posY - 32 >= 32) {

		hilo.moverEntidad(posX, posY, posX, posYFin, 1, this);
		hilo.start();*/
	
	}

	public void moverIzquierda() {
		

		if(direccion != 3) {
			cambiarImagen(3);
			direccion = 3;
		}
		this.setX(posX - 4);
		/*int posFin;

		hilo = new HiloMoverProtagonista(20, miJuego);
		posFin = posX - 4;
		
		if(direccion != 3) {
			cambiarImagen(3);
			direccion = 3;
		}
	
		hilo.moverEntidad(posX, posY, posFin, posY, 3, this);
		hilo.start();

		//Falta cambiar de zona si es necesario hacerlo
		*/
	}
	
	public void moverDerecha() {
		
		if(direccion != 2) {
			cambiarImagen(2);
			direccion = 2;
		}
		this.setX(posX + 4);
		/*
		int posFin;
		
		hilo = new HiloMoverProtagonista(20, miJuego);
		posFin = posX + 4;
		
		if(direccion != 2) {
			cambiarImagen(2);
			direccion = 2;
		}
		
		hilo.moverEntidad(posX, posY, posFin, posY, 2, this);
		hilo.start();
		*/
	}
	
	public ProtagonistaGUI getGUI() {
		return miRepresentacion;
	}
	
	public void activarVelocidad() {
		this.estadoVelocidad = true;
	}
	
	public void activarBomba() {
		this.estadoBomba = true;
	}
	
	public void activarPowerPellet() {
		this.estadoPowerPellet = true;
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
			this.miRepresentacion.ponerAzul();
			break;
		case 5:
			this.miRepresentacion.bomba();
			break;
		case 6: 
			//this.miRepresentacion.velocidad();
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
