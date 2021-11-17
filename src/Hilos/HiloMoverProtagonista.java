package Hilos;

import Entidades.Moviles.Movil;
import Entidades.Moviles.Protagonista;
import GUI.VentanaGUI;
import Logica.Juego;
import Logica.Zona;

public class HiloMoverProtagonista extends Thread {
	
	private int movimiento;
	private Protagonista miProtagonista;
	private int step;
	private Juego miJuego;
	private boolean activo;
	private boolean estadoBomba;
	private boolean estadoPowerPellet;
	private boolean estadoVelocidad;
	private long tiempoBomba;
	private long tiempoVelocidad;
	private long tiempoPowerPellet;
	private long tiempoActual;
	private int movimientoPendiente;
	
	private static final int direccionAbajo = 0;
	private static final int direccionArriba = 1;
	private static final int direccionDerecha = 2;
	private static final int direccionIzquierda = 3;
	private static final int direccionNula = 4;
	
	public HiloMoverProtagonista(int s, Juego miJuego, Protagonista miProtagonista) {
		step=s;
		this.miJuego = miJuego;
		this.miProtagonista = miProtagonista;
		movimiento = direccionIzquierda;
		movimientoPendiente = direccionNula;
		estadoBomba = false;
		estadoPowerPellet = false;
		estadoVelocidad = false;
		activo = true;
	}
	
	public void setBomba() {
		estadoBomba = true;
		tiempoBomba = System.currentTimeMillis()/1000; //tiempo en el que se activo la bomba
	}
	
	public void setPowerPellet() {
		estadoPowerPellet = true;
		tiempoPowerPellet = System.currentTimeMillis()/1000; //tiempo en el que se activo el powerpellet
	}
	
	public void setVelocidad() {
		estadoVelocidad = true;
		tiempoVelocidad = System.currentTimeMillis()/1000; //tiempo en el que se activo la velocidad
		step = 20;
	}
	
	public void setStep(int s) {
		this.step = s;
	}

	public void detener() {
		activo = false;
	}
	
	public void movimiento(int movimientoPendiente) {
		this.movimientoPendiente = movimientoPendiente;
	}
	
	public void run() {
		boolean puedeMover = false;
		boolean puedeMoverActual = false;
		try {
			while(activo) {
				Thread.sleep(step);
				switch(movimientoPendiente) {
				case direccionAbajo:
					puedeMover = miJuego.moverAbajo(miProtagonista);
					break;
				case direccionArriba:
					puedeMover = miJuego.moverArriba(miProtagonista);
					break;
				case direccionDerecha:
					puedeMover = miJuego.moverDer(miProtagonista);
					break;
				case direccionIzquierda:
					puedeMover = miJuego.moverIzq(miProtagonista);
					break;
				}
				
				if(puedeMover) {
					movimiento = movimientoPendiente;
				}else {
					switch(movimiento) {
					case direccionAbajo:
						puedeMoverActual = miJuego.moverAbajo(miProtagonista);
						break;
					case direccionArriba:
						puedeMoverActual = miJuego.moverArriba(miProtagonista);
						break;
					case direccionDerecha:
						puedeMoverActual = miJuego.moverDer(miProtagonista);
						break;
					case direccionIzquierda:
						puedeMoverActual = miJuego.moverIzq(miProtagonista);
						break;
					}
					if(!puedeMoverActual && !puedeMover)
						movimiento = direccionNula;//Para que no siga chequeando la misma colision
					
				}
				
					
				if(estadoBomba) {
					tiempoActual = System.currentTimeMillis()/1000;
					if(tiempoBomba + 10 <= tiempoActual) {
						estadoBomba = false;
						miJuego.desactivarBomba();
					}
				}
				if(estadoPowerPellet) {
					tiempoActual = System.currentTimeMillis()/1000;
					if(tiempoPowerPellet + 5 <= tiempoActual) {
						estadoPowerPellet = false;
						miJuego.desactivarPowerPellet();
					}
				}
				if(estadoVelocidad) {
					tiempoActual = System.currentTimeMillis()/1000;
					if(tiempoVelocidad + 10 <= tiempoActual) {
						estadoVelocidad = false;
						miJuego.desactivarVelocidad();
					}
				}
			}
		}catch(InterruptedException e) {
			e.printStackTrace();
		}
		
	}
	
	

}
