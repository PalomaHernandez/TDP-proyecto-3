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
	private int posX;
	private int posY;
	private int posXFin;
	private int posYFin;
	private Juego miJuego;
	
	public HiloMoverProtagonista(int s, Juego miJuego) {
		step=s;
		this.miJuego = miJuego;
	}
	
	public void setStep(int s) {
		this.step = s;
	}

	public void moverEntidad(int posX, int posY, int posXFin, int posYFin, int movimiento, Protagonista miProtagonista) {
		this.miProtagonista = miProtagonista;
		this.posX = posX;
		this.posY = posY;
		this.posXFin = posXFin;
		this.posYFin = posYFin;
		this.movimiento = movimiento;// 0 abajo, 1 arriba, 2 derecha, 3 izquierda
		
	}
	
	public void run() {
		/*Zona zonaActualA = null;//(0,0)
		Zona zonaActualB = null;//(32,0)
		Zona zonaActualC = null;
		Zona zonaActualD = null;
		Zona zonaFinalA = null ;
		Zona zonaFinalB = null;
		Zona zonaFinalC = null;
		Zona zonaFinalD = null;//deberian inicializarse de otra manera
		
		switch(movimiento) {
		case 0:
			zonaActualA = miJuego.calcularZona(miProtagonista.getX(), miProtagonista.getY());
			zonaActualC = miJuego.calcularZona(miProtagonista.getX(), miProtagonista.getY() + miProtagonista.getTamano());
			
			zonaFinalA = miJuego.calcularZona(miProtagonista.getX(), miProtagonista.getY() + 32);
			zonaFinalB = miJuego.calcularZona(miProtagonista.getX() + miProtagonista.getTamano(), miProtagonista.getY() + 32);
			zonaFinalC = miJuego.calcularZona(miProtagonista.getX(), miProtagonista.getY() + miProtagonista.getTamano() + 32);
			zonaFinalD = miJuego.calcularZona(miProtagonista.getX() + miProtagonista.getTamano(), miProtagonista.getY() + miProtagonista.getTamano() + 32);
			break;
		case 1:
			zonaActualA = miJuego.calcularZona(miProtagonista.getX(), miProtagonista.getY());
			zonaActualC = miJuego.calcularZona(miProtagonista.getX(), miProtagonista.getY() + miProtagonista.getTamano());
			
			zonaFinalA = miJuego.calcularZona(miProtagonista.getX(), miProtagonista.getY() - 32);
			zonaFinalB = miJuego.calcularZona(miProtagonista.getX() + miProtagonista.getTamano(), miProtagonista.getY() - 32);
			zonaFinalC = miJuego.calcularZona(miProtagonista.getX(), miProtagonista.getY() + miProtagonista.getTamano() - 32);
			zonaFinalD = miJuego.calcularZona(miProtagonista.getX() + miProtagonista.getTamano(), miProtagonista.getY() + miProtagonista.getTamano() - 32);
			break;
		case 2:
			zonaActualA = miJuego.calcularZona(miProtagonista.getX(), miProtagonista.getY());
			zonaActualB = miJuego.calcularZona(miProtagonista.getX() + miProtagonista.getTamano(), miProtagonista.getY());
		
			zonaFinalA = miJuego.calcularZona(miProtagonista.getX() + 32, miProtagonista.getY());
			zonaFinalB = miJuego.calcularZona(miProtagonista.getX() + miProtagonista.getTamano() + 32, miProtagonista.getY());
			zonaFinalC = miJuego.calcularZona(miProtagonista.getX() + 32, miProtagonista.getY() + miProtagonista.getTamano());
			zonaFinalD = miJuego.calcularZona(miProtagonista.getX() + miProtagonista.getTamano() + 32, miProtagonista.getY() + miProtagonista.getTamano());
			break;
		case 3:
			zonaActualA = miJuego.calcularZona(miProtagonista.getX(), miProtagonista.getY());
			zonaActualB = miJuego.calcularZona(miProtagonista.getX() + miProtagonista.getTamano(), miProtagonista.getY());
			
			zonaFinalA = miJuego.calcularZona(miProtagonista.getX() - 32, miProtagonista.getY());
			zonaFinalB = miJuego.calcularZona(miProtagonista.getX() + miProtagonista.getTamano() + 32, miProtagonista.getY());
			zonaFinalC = miJuego.calcularZona(miProtagonista.getX() - 32, miProtagonista.getY() + miProtagonista.getTamano());
			zonaFinalD = miJuego.calcularZona(miProtagonista.getX() + miProtagonista.getTamano() + 32, miProtagonista.getY() + miProtagonista.getTamano());
			break;
		}
			*/
		boolean esPared = false;
		
		while((posXFin != posX || posYFin != posY) && !esPared) {
			try {
				Thread.sleep(step);
				switch(movimiento) {
				case 0: 
					/*
					esPared = miJuego.colisionProtagonista(miProtagonista, zonaFinalA.getLista(), posX, posY + 4);
					if(!esPared && zonaFinalA != zonaFinalB)
						esPared = miJuego.colisionProtagonista(miProtagonista, zonaFinalB.getLista(), posX, posY + 4);
					if(!esPared && zonaFinalA != zonaFinalC && zonaFinalB != zonaFinalC)
						esPared = miJuego.colisionProtagonista(miProtagonista, zonaFinalC.getLista(), posX, posY + 4);
					if(!esPared && zonaFinalA != zonaFinalD && zonaFinalB != zonaFinalD && zonaFinalC != zonaFinalD)
						miJuego.colisionProtagonista(miProtagonista, zonaFinalD.getLista(), posX, posY + 4);
					
					if(zonaFinalA != zonaActualA) {
						zonaActualA.removeEntidad(miProtagonista);
						zonaFinalA.addEntidad(miProtagonista);
					}
					if(zonaFinalC != zonaActualC){
						zonaActualC.removeEntidad(miProtagonista);
						zonaFinalC.addEntidad(miProtagonista);
					}
					*/
					
						miProtagonista.setY(posY + 4);
						posY +=4;
					
					break;
				case 1:
					/*
					esPared = miJuego.colisionProtagonista(miProtagonista, zonaFinalA.getLista(), posX, posY -4);
					if(!esPared && zonaFinalA != zonaFinalB)
						esPared = miJuego.colisionProtagonista(miProtagonista, zonaFinalB.getLista(), posX, posY - 4);
					if(!esPared && zonaFinalA != zonaFinalC && zonaFinalB != zonaFinalC)
						esPared = miJuego.colisionProtagonista(miProtagonista, zonaFinalC.getLista(), posX, posY - 4);
					if(!esPared && zonaFinalA != zonaFinalD && zonaFinalB != zonaFinalD && zonaFinalC != zonaFinalD)
						esPared = miJuego.colisionProtagonista(miProtagonista, zonaFinalD.getLista(), posX, posY - 4);
					
					if(zonaFinalA != zonaActualA) {
						zonaActualA.removeEntidad(miProtagonista);
						zonaFinalA.addEntidad(miProtagonista);
					}
					if(zonaFinalC != zonaActualC){
						zonaActualC.removeEntidad(miProtagonista);
						zonaFinalC.addEntidad(miProtagonista);
					}
					*/
					
						miProtagonista.setY(posY - 4);
						posY -=4;
					
					break;
				case 2:
						/*
					esPared = miJuego.colisionProtagonista(miProtagonista, zonaFinalA.getLista(), posX + 4, posY);
					if(!esPared && zonaFinalA != zonaFinalB)
						esPared = miJuego.colisionProtagonista(miProtagonista, zonaFinalB.getLista(), posX + 4, posY);
					if(!esPared && zonaFinalA != zonaFinalC && zonaFinalB != zonaFinalC)
						esPared = miJuego.colisionProtagonista(miProtagonista, zonaFinalC.getLista(), posX + 4, posY);
					if(!esPared && zonaFinalA != zonaFinalD && zonaFinalB != zonaFinalD && zonaFinalC != zonaFinalD)
						esPared = miJuego.colisionProtagonista(miProtagonista, zonaFinalD.getLista(), posX + 4, posY);
					
					if(zonaFinalA != zonaActualA) {
						zonaActualA.removeEntidad(miProtagonista);
						zonaFinalA.addEntidad(miProtagonista);
					}
					if(zonaFinalB != zonaActualB) {
						zonaActualB.removeEntidad(miProtagonista);
						zonaFinalB.addEntidad(miProtagonista);
					}
					*/
						miProtagonista.setX(posX + 4);
						posX +=4;
					
					break;
				case 3: 
					/*
					esPared = miJuego.colisionProtagonista(miProtagonista, zonaFinalA.getLista(),posX - 4, posY);
					if(!esPared && zonaFinalA != zonaFinalB)
						esPared = miJuego.colisionProtagonista(miProtagonista, zonaFinalB.getLista(), posX - 4, posY);
					if(!esPared && zonaFinalA != zonaFinalC && zonaFinalB != zonaFinalC)
						esPared = miJuego.colisionProtagonista(miProtagonista, zonaFinalC.getLista(), posX - 4, posY);
					if(!esPared && zonaFinalA != zonaFinalD && zonaFinalB != zonaFinalD && zonaFinalC != zonaFinalD)
						esPared = miJuego.colisionProtagonista(miProtagonista, zonaFinalD.getLista(), posX - 4, posY);
					
					if(zonaFinalA != zonaActualA) {
						zonaActualA.removeEntidad(miProtagonista);
						zonaFinalA.addEntidad(miProtagonista);
					}
					if(zonaFinalB != zonaActualB) {
						zonaActualB.removeEntidad(miProtagonista);
						zonaFinalB.addEntidad(miProtagonista);
					}
					*/
					
						miProtagonista.setX(posX - 4);
						posX -= 4;
					
					break;
				}
			}catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

}
