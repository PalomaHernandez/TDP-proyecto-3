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
	
	
	public abstract void cambiarImagen(int num);
	
	public String getRepresentacion() {
		return representacion;
	}
}
