package Entidades.Moviles;


import Entidades.Entidad;
import GUI.MovilGUI;
import Hilos.*;
import Logica.Juego;

public abstract class Movil extends Entidad{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	protected int direccion;
	protected MovilGUI miRepresentacion;
	private final int rango = 608;
	protected Juego miJuego;
	private HiloMoverProtagonista hilo;
	private HiloMoverEnemigos hiloF;
	
	public Movil() {
		direccion = 3; //se inicializa moviendose hacia la izquierda
	}
	
	public abstract void moverArriba();
	
	public abstract void moverAbajo();
	
	public abstract void moverIzquierda();
	
	public abstract void moverDerecha();
	
	
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
		}
	}
	
	public String getRepresentacion() {
		return representacion;
	}
}
