package Entidades.Moviles;

import GUI.ProtagonistaGUI;

public abstract class Protagonista extends Movil {

	protected int estadoVelocidad;
	protected int estadoBomba;
	protected int estadoPowerPellet;
	protected int vidas;
	protected ProtagonistaGUI miRepresentacion;
	
	public Protagonista() {
		super();
		estadoVelocidad = 0;
		estadoBomba = 0;
		estadoPowerPellet = 0;
		vidas = 3;
	}
	
	public void setVelocidad(int estadoVelocidad) {
		this.estadoVelocidad = estadoVelocidad;
	}
	
	public void setBomba(int estadoBomba) {
		this.estadoBomba = estadoBomba;
	}
	
	public void setPowerPellet(int estadoPowerPellet) {
		this.estadoPowerPellet = estadoPowerPellet;
	}
	
	public void setVidas(int vidas) {
		this.vidas = vidas;
	}
	
	
	public int getVelocidad() {
		return estadoVelocidad;
	}
	
	public int getBomba() {
		return estadoBomba;
	}
	
	public int getVidas() {
		return vidas;
	}
	
	public int getPowerPellet() {
		return estadoPowerPellet;
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
		case 5:
			this.miRepresentacion.bomba();
			break;
		case 6: 
			this.miRepresentacion.velocidad();
			break;
		}
	}
	
}
