package Hilos;

import java.awt.Rectangle;
import java.util.Random;

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
	private boolean volvio = false;
	
	
	private static final int puertaX = 320;
	private static final int puertaY = 288; 
	private static final int rango = 608;

	private static final int direccionAbajo = 0;
	private static final int direccionArriba = 1;
	private static final int direccionDerecha = 2;
	private static final int direccionIzquierda = 3;

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
		long tiempoComienzo;
		try {
			tiempoComienzo = (System.currentTimeMillis()/1000) + 3;
			while(activo) {
				tiempoActual = System.currentTimeMillis()/1000;
				Thread.sleep(step);
				moverBlinky();	
				if(tiempoActual >= tiempoComienzo) {
					moverInky();
				if(tiempoActual >= tiempoComienzo + 3)// para que no salgan todos a la vez
					moverPinky();
				if(tiempoActual >= tiempoComienzo + 6)
					moverClyde();
				}
				if(estadoPowerPellet) {//Esto creo que no hace falta
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
		boolean puedeMover = false;
		Random rand;
		int random;
		int movimientoAnterior = enemigo.movAnterior();
		
		rand = new Random();
		random = rand.nextInt(4);
		
		if(enemigo.getX() > x) {
			puedeMover = miJuego.moverIzq(enemigo);
			movAnt(puedeMover, direccionIzquierda, enemigo);
			if(!puedeMover && enemigo.getY() <= y && movimientoAnterior != direccionArriba){//El objetivo esta abajo
				puedeMover = miJuego.moverAbajo(enemigo);
				movAnt(puedeMover, direccionAbajo, enemigo);
			}
			if(!puedeMover && enemigo.getY() > y && movimientoAnterior != direccionAbajo) {
				puedeMover = miJuego.moverArriba(enemigo);
				movAnt(puedeMover, direccionArriba, enemigo);
			}
		}else if(enemigo.getX() < x) {
			puedeMover = miJuego.moverDer(enemigo);
			movAnt(puedeMover, direccionDerecha, enemigo);
			if(!puedeMover && enemigo.getY() <= y && movimientoAnterior != direccionArriba){//El objetivo esta abajo
				puedeMover = miJuego.moverAbajo(enemigo);
				movAnt(puedeMover, direccionAbajo, enemigo);
			}
			if(!puedeMover && enemigo.getY() > y && movimientoAnterior != direccionAbajo) {
				puedeMover = miJuego.moverArriba(enemigo);
				movAnt(puedeMover, direccionArriba, enemigo);
			}
		}else if(enemigo.getX() == x) {
			if((enemigo.getX() != puertaX || enemigo.getY() != puertaY) && enemigo.getY() < y && movimientoAnterior != direccionArriba) {
				puedeMover = miJuego.moverAbajo(enemigo);
				movAnt(puedeMover, direccionAbajo, enemigo);
			}
			else if(enemigo.getY() > y && movimientoAnterior != direccionAbajo) {
				puedeMover = miJuego.moverArriba(enemigo);
				movAnt(puedeMover, direccionArriba, enemigo);
			}
		}/*
		if(!puedeMover) {
			switch(random) {
			case direccionAbajo:
				puedeMover = miJuego.moverAbajo(enemigo);
				movAnt(puedeMover, direccionAbajo, enemigo);
				break;
			case direccionArriba:
				puedeMover = miJuego.moverArriba(enemigo);
				movAnt(puedeMover, direccionArriba, enemigo);
				break;
			case direccionDerecha:
				puedeMover = miJuego.moverDer(enemigo);
				movAnt(puedeMover, direccionDerecha, enemigo);
				break;
			case direccionIzquierda: 
				puedeMover = miJuego.moverIzq(enemigo);
				movAnt(puedeMover, direccionIzquierda, enemigo);
				break;
			}
		}
		*/
	}

	private void movAnt(boolean puedeMover, int direccion, Enemigo enemigo) {
		if(puedeMover)
			enemigo.setMovAnterior(direccion);
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
		int posX;
		int posY;
		Rectangle pos = new Rectangle(pinky.getX(), pinky.getY(), pinky.getWidth(), pinky.getHeight());

		if(pos.intersects(casa)) {
			dirigirA(320, 256, pinky); //Puerta de la casa
		}else {
			switch(protagonista.getDireccion()) {
				case direccionArriba:
					posY = protagonista.getY() - 128;
					posY -= (posY % 32); //Para que la posicion dada sea correcta hablando de pixeles
					posX = protagonista.getX() - 64;
					posX -= (posX % 32);
					
					if(posX < 32) {
						posX = 32;
					}
					if(posY < 32) {
						posY = 32;
					}
					dirigirA(posX, posY, pinky);
					break;
				case direccionAbajo:
					posY = 128 + protagonista.getY();
					posY -= (posY % 32); //Para que la posicion dada sea correcta hablando de pixeles
					posX = protagonista.getX() + 64;
					posX -= (posX % 32);
					
					if(posX > rango) {
						posX = rango;
					}
					if(posY > rango) {
						posY = rango;
					}
					dirigirA(posX, posY, pinky);
					break;
				case direccionDerecha:
					posY = protagonista.getY() - 64;
					posY -= (posY % 32); //Para que la posicion dada sea correcta hablando de pixeles
					posX = protagonista.getX() + 128;
					posX -= (posX % 32);
					
					if(posX > rango) {
						posX = rango;
					}
					if(posY < 32) {
						posY = 32;
					}
					dirigirA(posX, posY, pinky);
					break;
				case direccionIzquierda:
					posY = protagonista.getY() + 64;
					posY -= (posY % 32); //Para que la posicion dada sea correcta hablando de pixeles
					posX = protagonista.getX() - 128;
					posX -= (posX % 32);
					
					if(posX < 32) {
						posX = 32;
					}
					if(posY > rango) {
						posY = rango;
					}
					dirigirA(posX, posY, pinky);
					break;
			}
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
		int estado = clyde.getEstado();
		switch(estado) {
		case 0:
			dispersarClyde();
			break;
		case 2:
			irACasa(clyde);
			break;
		}
	}

	private void dispersarClyde() {
		int posX;
		int posY;
		Rectangle pos = new Rectangle(clyde.getX(), clyde.getY(), clyde.getWidth(), clyde.getHeight());

		
		if(pos.intersects(casa)) {
			dirigirA(320, 256, clyde); //Puerta de la casa
		}else {
			posX = clyde.getX();
			posY = clyde.getY();
			if(Math.abs(posX - protagonista.getX()) <= 256 && Math.abs(posY - protagonista.getY()) <= 256) {
				perseguir(clyde);
			}else {
				if(!volvio) {
					dirigirA(32, 32, clyde);//habria que ver que este vuelva
					if(clyde.getX() == 32 && clyde.getY() == 32)
						volvio = true;
				}else
					perseguir(clyde);
			}
			
		}
	}

	public void setPowerPellet() {
		estadoPowerPellet = true;
		tiempoPowerPellet = System.currentTimeMillis()/1000; //tiempo en el que se activo el powerpellet
		
	}
		
	
}
