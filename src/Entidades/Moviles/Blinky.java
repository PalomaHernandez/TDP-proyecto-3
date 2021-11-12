package Entidades.Moviles;

public class Blinky extends Enemigo{

	private static final long serialVersionUID = 1L;

	public Blinky(String s) {
		super(s);
		this.estado = 1;
	}

	@Override
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

}
