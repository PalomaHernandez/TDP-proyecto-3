package Hilos;

import java.awt.Rectangle;

import Entidades.Moviles.Blinky;
import Entidades.Moviles.Clyde;
import Entidades.Moviles.Enemigo;
import Entidades.Moviles.Inky;
import Entidades.Moviles.Pinky;
import Entidades.Moviles.Protagonista;
import Logica.Juego;

public class HiloMoverEnemigos extends Thread {

	
	private int step;
	private Clyde clyde;
	private Inky inky;
	private Blinky blinky;
	private Pinky pinky;
	private Protagonista protagonista;
	private boolean activo;
	private Rectangle casa;
	private Juego miJuego;
	
	//Estado 0 dispersarse. 1 perseguir. 2 correr. 3 morir (ir a la casa)
	public HiloMoverEnemigos(Juego miJuego, int s, Clyde clyde, Inky inky, Blinky blinky, Pinky pinky, Protagonista protagonista) {
		this.clyde = clyde;
		this.inky = inky;
		this.blinky = blinky;
		this.pinky = pinky;
		this.protagonista = protagonista;
		this.miJuego = miJuego;
		casa = new Rectangle(288, 288, 64, 96);
		activo = true;
		step=s;
	}
	
	public void setStep(int s) {
		this.step = s;
	}
	
	public void detener() {
		activo = false;
	}
	
	public void run() {
		while(activo) {
			try {
				Thread.sleep(step);
				moverClyde();
				moverInky();
				moverPinky();
				moverBlinky();
			}catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	private void moverBlinky() {
		int estado = blinky.getEstado();
		switch(estado) {
		case 1:
			perseguir(blinky);
			break;
		case 2:
			correr(blinky);
			break;
		case 3:
			irACasa(blinky);
			break;
		}
	}

	private void irACasa(Enemigo enemigo) {
		// TODO Auto-generated method stub
		
	}

	private void correr(Enemigo enemigo) {
		// TODO Auto-generated method stub
		
	}

	private void perseguir(Enemigo enemigo) {
		Rectangle pos = new Rectangle(enemigo.getX(), enemigo.getY(), enemigo.getWidth(), enemigo.getHeight());
		if(pos.intersects(casa)) {
			dirigirA(320, 256, enemigo); //Puerta de la casa
		}else {
			dirigirA(protagonista.getX(), protagonista.getY(), enemigo);
		}
	}

	private void dirigirA(int x, int y, Enemigo enemigo) {
		boolean puedeMover = true;
		
		if(enemigo.getX() > x) {
			puedeMover = miJuego.moverIzqEnem(enemigo);
			if(!puedeMover && enemigo.getY() <= y)//El objetivo esta abajo
				puedeMover = miJuego.moverAbajoEnem(enemigo);
			if(!puedeMover && enemigo.getY() > y)
				puedeMover = miJuego.moverArribaEnem(enemigo);
		}else if(enemigo.getX() < x) {
			puedeMover = miJuego.moverDerEnem(enemigo);
			if(!puedeMover && enemigo.getY() <= y)//El objetivo esta abajo
				puedeMover = miJuego.moverAbajoEnem(enemigo);
			if(!puedeMover && enemigo.getY() > y)
				puedeMover = miJuego.moverArribaEnem(enemigo);
		}else if(enemigo.getX() == x) {
			if(enemigo.getY() < y)
				puedeMover = miJuego.moverAbajoEnem(enemigo);
			else if(enemigo.getY() > y)
				puedeMover = miJuego.moverArribaEnem(enemigo);
			if(!puedeMover) 
				puedeMover = miJuego.moverDerEnem(enemigo);
			if(!puedeMover)
				puedeMover = miJuego.moverIzqEnem(enemigo);
		}
		
	}

	private void moverPinky() {
		// TODO Auto-generated method stub
		
	}

	private void moverInky() {
		// TODO Auto-generated method stub
		
	}

	private void moverClyde() {
		// TODO Auto-generated method stub
		
	}
		
	
}
