package Entidades.Moviles;

import GUI.ProtagonistaGUI;

public class ProtagonistaA extends Protagonista{

	public ProtagonistaA() {
		super();
		this.miRepresentacion = new ProtagonistaGUI("/imagenes/autoAbajo.jpg","/imagenes/autoArriba.jpg","/imagenes/autoDerecha.jpg","/imagenes/autoIzquierda.jpg","/imagenes/autoAzul.jpg","/imagenes/autoBomba.jpg","/imagenes/autoVelocidad.jpg", posX, posY);
	}
	
}
