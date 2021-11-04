package Entidades.Moviles;


import Entidades.Entidad;
import GUI.MovilGUI;
import Hilos.HiloMoverProtagonista;
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
	
	public Movil() {
		direccion = 3; //se inicializa moviendose hacia la izquierda
	}
	
	public void moverArriba() {
		int posYFin;

		hilo = new HiloMoverProtagonista(20);
		posYFin = posY - 32;
		if(direccion != 1) {
			cambiarImagen(1);
			direccion = 1;
		}
		
		// Este if deberia hacerse chequeando colisiones con paredes, no mirando el rangoif(posY - 32 >= 32) {

		hilo.moverEntidad(posX, posY, posX, posYFin, 1, this);
		hilo.start();
			
			
		
	}
	
	
	public void moverAbajo() {
		int posFin;

		hilo = new HiloMoverProtagonista(20);
		posFin = posY + 32;
		
		if(direccion != 0) {
			cambiarImagen(0);
			direccion = 0;
		}
		
		hilo.moverEntidad(posX, posY, posX, posFin, 0, this);
		hilo.start();	
			
		
	}
	
	public void moverIzquierda() {
		int posFin;

		hilo = new HiloMoverProtagonista(20);
		posFin = posX - 32;
		
		if(direccion != 3) {
			cambiarImagen(3);
			direccion = 3;
		}
	
		hilo.moverEntidad(posX, posY, posFin, posY, 3, this);
		hilo.start();
		//Falta cambiar de zona si es necesario hacerlo
			
			
		
		
	}
	
	public void moverDerecha() {
		int posFin;
		
		hilo = new HiloMoverProtagonista(20);
		posFin = posX + 32;
		
		if(direccion != 2) {
			cambiarImagen(2);
			direccion = 2;
		}
		
		hilo.moverEntidad(posX, posY, posFin, posY, 2, this);
		hilo.start();
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
		}
	}
	
	public String getRepresentacion() {
		return representacion;
	}
}
