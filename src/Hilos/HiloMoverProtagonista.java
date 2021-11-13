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
	
	public HiloMoverProtagonista(int s, Juego miJuego, Protagonista miProtagonista) {
		step=s;
		this.miJuego = miJuego;
		this.miProtagonista = miProtagonista;
		movimiento = 3;
		activo = true;
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
			}
		}catch(InterruptedException e) {
			e.printStackTrace();
		}
		
	}
	
	

}
