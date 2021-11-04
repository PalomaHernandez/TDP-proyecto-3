package Hilos;

import Entidades.Moviles.Movil;
import GUI.VentanaGUI;
import Logica.Juego;

public class HiloMoverProtagonista extends Thread {
	
	private int movimiento;
	private Movil miEntidad;
	private int step;
	private boolean activo;
	private int posX;
	private int posY;
	private int posXFin;
	private int posYFin;
	
	public HiloMoverProtagonista(int s) {
		step=s;
	}
	
	public void detener() {
		activo = false;
	}
	
	public void setStep(int s) {
		this.step = s;
	}

	public void moverEntidad(int posX, int posY, int posXFin, int posYFin, int movimiento, Movil entidad) {
		miEntidad = entidad;
		this.posX = posX;
		this.posY = posY;
		this.posXFin = posXFin;
		this.posYFin = posYFin;
		this.movimiento = movimiento;// 0 abajo, 1 arriba, 2 derecha, 3 izquierda
		
	}
	
	public void run() {
		while(posXFin != posX || posYFin != posY) {
			try {
				Thread.sleep(step);
				switch(movimiento) {
				case 0: 
					miEntidad.setY(posY + 4);
					posY +=4;
					break;
				case 1:
					miEntidad.setY(posY - 4);
					posY -=4;
					break;
				case 2:
					miEntidad.setX(posX + 4);
					posX +=4;
					break;
				case 3: 
					miEntidad.setX(posX - 4);
					posX -= 4;
					break;
				}
			}catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	
	
	/*
	public void run() {
		while(activo) {
			try {
				Thread.sleep(step); //parametro en milisegundos
				miJuego.bajarAction();
			   tiempoActual= System.currentTimeMillis();
			   tiempoTranscurrido= ((tiempoActual-startTime)/1000); //tiempo en segundos /60; es tiempo en minutos
			   
			   if(tiempoTranscurrido%segEntreAceleracion==0 && step>aceleracionMax)
				   step-=aceleracion;
			   
			} catch(InterruptedException e) {}
		}
		
	}
	*/
}
