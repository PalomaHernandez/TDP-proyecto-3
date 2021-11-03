package Entidades.Moviles;

import Entidades.Entidad;
import GUI.MovilGUI;
import Hilos.HiloMover;
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
	
	public Movil() {
		direccion = 3; //se inicializa moviendose hacia la izquierda
	}
	
	public void moverArriba() {
		
		if(direccion != 0) {
			cambiarImagen(0);
			direccion = 0;
		}
		
		if(posY -32 >= 32) {
			
			miJuego.moverEntidad(posX, posY, posX, posY - 32, 1, this); //Esto chequearia las colisiones
			//this.setY(posY - 32);
			//Falta cambiar de zona si es necesario hacerlo
			
			
		}
	}
	
	
	public void moverAbajo() {
		int posFin;
		
		posFin = posY + 4;
		
		if(direccion != 1) {
			cambiarImagen(1);
			direccion = 1;
		}
		
		if(posFin <= rango) {
			
				miJuego.moverEntidad(posX, posY, posX, posY + 4, 0, this);
				this.setY(posY + 4);
				//Falta cambiar de zona si es necesario hacerlo
			
			
		}
	}
	
	public void moverIzquierda() {
		int posFin;
		
		posFin = posX - 4;
		
		if(direccion != 3) {
			cambiarImagen(3);
			direccion = 3;
		}
		
		if(posFin >= 32) {
			miJuego.moverEntidad(posX, posY, posX - 4, posY, 3, this);
			this.setX(posX - 4);
			//Falta cambiar de zona si es necesario hacerlo
			
			
		}
		
	}
	
	public void moverDerecha() {
		int posFin;
		
		posFin = posX + 4;
		
		if(direccion != 2) {
			cambiarImagen(2);
			direccion = 2;
		}
		
		if(posFin <= rango) {
				miJuego.moverEntidad(posX, posY, posX + 4, posY,2, this); // El +4 sumado a posX seria los pixeles que se corre la imagen en la grafica
				this.setX(posX + 4);
				//Falta cambiar de zona si es necesario hacerlo
			
		}
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
