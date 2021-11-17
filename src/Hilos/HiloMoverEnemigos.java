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
	private boolean estadoPowerPellet;
	private long tiempoPowerPellet;
	private long tiempoActual;
	private static final int puertaX = 320;
	private static final int puertaY = 288; 
	private static final int rango = 608;
	
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
		estadoPowerPellet = false;
	}
	
	public void setStep(int s) {
		this.step = s;
	}
	
	public void detener() {
		activo = false;
	}
	
	public void run() {
		try {
			while(activo) {
				Thread.sleep(step);
				moverClyde();
				moverInky();
				moverPinky();
				moverBlinky();	
				
				if(estadoPowerPellet) {
					tiempoActual = System.currentTimeMillis()/1000;
					if(tiempoPowerPellet + 5 <= tiempoActual) {
						estadoPowerPellet = false;
						miJuego.desactivarPowerPellet();
					}
				}
			}
		}catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	private void moverBlinky() {
		int estado = blinky.getEstado();
		switch(estado) {
		case 1:
			perseguir(blinky);
			break;
		case 2:
			irACasa(blinky);
			break;
		}
	}

	private void irACasa(Enemigo enemigo) {
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
			puedeMover = miJuego.moverIzq(enemigo);
			if(!puedeMover && enemigo.getY() <= y)//El objetivo esta abajo
				puedeMover = miJuego.moverAbajo(enemigo);
			if(!puedeMover && enemigo.getY() > y)
				puedeMover = miJuego.moverArriba(enemigo);
		}else if(enemigo.getX() < x) {
			puedeMover = miJuego.moverDer(enemigo);
			if(!puedeMover && enemigo.getY() <= y)//El objetivo esta abajo
				puedeMover = miJuego.moverAbajo(enemigo);
			if(!puedeMover && enemigo.getY() > y)
				puedeMover = miJuego.moverArriba(enemigo);
		}else if(enemigo.getX() == x) {
			if((enemigo.getX() != puertaX || enemigo.getY() != puertaY) && enemigo.getY() < y)
				puedeMover = miJuego.moverAbajo(enemigo);
			else if(enemigo.getY() > y)
				puedeMover = miJuego.moverArriba(enemigo);
			if(!puedeMover) 
				puedeMover = miJuego.moverDer(enemigo);
			if(!puedeMover)
				puedeMover = miJuego.moverIzq(enemigo);
		}
		
	}

	private void moverPinky() {
		int estado = pinky.getEstado();
		switch(estado) {
		case 0:
			dispersarPinky();
			break;
		case 2:
			irACasa(pinky);
			break;
		}
	}

	private void dispersarPinky() {
		
		Rectangle pos = new Rectangle(inky.getX(), inky.getY(), inky.getWidth(), inky.getHeight());

		if(pos.intersects(casa)) {
			dirigirA(320, 256, inky); //Puerta de la casa
		}else {
			
		}
	}

	private void moverInky() {
		int estado = inky.getEstado();
		switch(estado) {
		case 0:
			dispersarInky();
			break;
		case 2:
			irACasa(inky);
			break;
		}
	}

	private void dispersarInky() {
		int posX;
		int posY;
		Rectangle pos = new Rectangle(inky.getX(), inky.getY(), inky.getWidth(), inky.getHeight());

		posY = protagonista.getY() - blinky.getY();
		posX = blinky.getX();
		if(pos.intersects(casa)) {
			dirigirA(320, 256, inky); //Puerta de la casa
		}else {
			if(posY > 0) {
				posY += protagonista.getY();
				if(posY < rango) {
					dirigirA(posX, posY, inky);
				}else {
					dirigirA(posX, rango, inky);
				}
			}else {
				posY += protagonista.getY();
				if(posY > 32) {
					dirigirA(posX, posY, inky);
				}else
					dirigirA(posX, 32, inky);
			}
		}
		
	}

	private void moverClyde() {
		// TODO Auto-generated method stub
		
	}

	public void setPowerPellet() {
		estadoPowerPellet = true;
		tiempoPowerPellet = System.currentTimeMillis()/1000; //tiempo en el que se activo el powerpellet
		
	}
		
	
}
