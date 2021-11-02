package Entidades.Moviles;

import Entidades.Entidad;
import GUI.MovilGUI;
import Logica.Juego;

public abstract class Movil extends Entidad{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	protected int direccion;
	protected MovilGUI miRepresentacion;
	private final int rango = 768;
	protected Juego miJuego;
	
	public Movil() {
		direccion = 0; //se inicializa moviendose hacia arriba
	}
	
	public void moverArriba() {
		int posFin;
		
		posFin = posY - 4;
		
		if(direccion != 0) {
			cambiarImagen(0);
			direccion = 0;
		}
		
		if(posFin >= 0) {
				miJuego.moverEntidad(posX, posY, posX, posY - 4, this); //Esto chequearia las colisiones
				this.setY(posY - 4);
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
			
				miJuego.moverEntidad(posX, posY, posX, posY + 4, this);
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
		
		if(posFin >= 0) {
			miJuego.moverEntidad(posX, posY, posX - 4, posY, this);
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
				miJuego.moverEntidad(posX, posY, posX + 4, posY, this); // El +4 sumado a posX seria los pixeles que se corre la imagen en la grafica
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
