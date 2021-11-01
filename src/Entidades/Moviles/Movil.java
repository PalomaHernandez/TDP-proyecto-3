package Entidades.Moviles;

import Entidades.Entidad;
import GUI.MovilGUI;

public abstract class Movil extends Entidad{

	protected int direccion;
	protected MovilGUI miRepresentacion;
	private final int rango = 768;
	
	public Movil() {
		direccion = 0; //se inicializa moviendose hacia arriba
	}
	
	public void moverArriba() {
		int posFin;
		
		posFin = posY - 32;
		
		if(direccion != 0) {
			cambiarImagen(0);
			direccion = 0;
		}
		
		if(posFin >= 0) {
			while(posY != posFin) {
				miJuego.moverEntidad(posX, posY, posX, posY - 4, this); //Esto chequearia las colisiones
				posY -= 4;
				//Falta cambiar de zona si es necesario hacerlo
			}
			
		}
	}
	
	
	public void moverAbajo() {
		int posFin;
		
		posFin = posY + 32;
		
		if(direccion != 1) {
			cambiarImagen(1);
			direccion = 1;
		}
		
		if(posFin <= rango) {
			while(posY != posFin) {
				miJuego.moverEntidad(posX, posY, posX, posY + 4, this);
				posY += 4;
				//Falta cambiar de zona si es necesario hacerlo
			}
			
		}
	}
	
	public void moverIzquierda() {
		int posFin;
		
		posFin = posX - 32;
		
		if(direccion != 3) {
			cambiarImagen(3);
			direccion = 3;
		}
		
		if(posFin >= 0) {
			while(posX != posFin) {
				miJuego.moverEntidad(posX, posY, posX - 4, posY, this);
				posX -= 4;
				//Falta cambiar de zona si es necesario hacerlo
				
			}
		}
		
	}
	
	public void moverDerecha() {
		int posFin;
		
		posFin = posX + 32;
		
		if(direccion != 2) {
			cambiarImagen(2);
			direccion = 2;
		}
		
		if(posFin <= rango) {
			while(posX != posFin) {
				miJuego.moverEntidad(posX, posY, posX + 4, posY, this); // El +4 sumado a posX seria los pixeles que se corre la imagen en la grafica
				posX += 4; 
				//Falta cambiar de zona si es necesario hacerlo
			}
		}
	}
	
	
	public abstract void cambiarImagen(int num);
	
	public String getRepresentacion() {
		return representacion;
	}
}
