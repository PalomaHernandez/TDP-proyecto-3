package Hilos;

import Entidades.Moviles.Movil;

public class HiloMoverFantasmas extends Thread {

	
	private int movimiento;
	private Movil miEntidad;
	private int step;
	private boolean activo;
	private int posX;
	private int posY;
	private int posXFin;
	private int posYFin;
	
	public HiloMoverFantasmas(int s) {
		step=s;
	}
	
	public void detener() {
		activo = false;
	}
	
	public void setStep(int s) {
		this.step = s;
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
		
	
}
