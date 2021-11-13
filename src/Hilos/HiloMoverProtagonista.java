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
	
	public HiloMoverProtagonista(int s, Juego miJuego, Protagonista miProtagonista) {
		step=s;
		this.miJuego = miJuego;
		this.miProtagonista = miProtagonista;
		movimiento = 3;
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
	}
	
	public void setStep(int s) {
		this.step = s;
	}

	public void detener() {
		activo = false;
	}
	
	public void movimiento(int movimiento) {
		this.movimiento = movimiento;
	}
	
	public void run() {
		try {
			while(activo) {
				Thread.sleep(step);
				switch(movimiento) {
				case 0:
					miJuego.moverAbajoAction();
					break;
				case 1:
					miJuego.moverArribaAction();
					break;
				case 2:
					miJuego.moverDerAction();
					break;
				case 3:
					miJuego.moverIzqAction();
					break;
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
