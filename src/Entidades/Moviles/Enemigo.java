package Entidades.Moviles;

import GUI.EnemigoGUI;
import GUI.ProtagonistaGUI;
import Logica.Juego;
import Visitors.Visitor;
import Visitors.VisitorFantasma;

public class Enemigo extends Movil {
	
	/**
	 *                                                                                                                                                                                                                                                                                                                                                                                              
	 */
	private static final long serialVersionUID = 1L;
	private EnemigoGUI miRepresentacion;
	
	public Enemigo(String enemigoAbajo, String enemigoArriba, String enemigoIzquierda, String enemigoDerecha, String enemigoAzul) {
		miRepresentacion = new EnemigoGUI(enemigoAbajo,enemigoArriba, enemigoIzquierda, enemigoDerecha, enemigoAzul);
		tamano = 20;
		v= new VisitorFantasma();
	}
	
	public void accept(Visitor v, Juego j) {
		v.visit(this, j);		
	}
	
	public EnemigoGUI getGUI() {
		return miRepresentacion;
	}

	@Override
	public void moverArriba() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void moverAbajo() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void moverIzquierda() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void moverDerecha() {
		// TODO Auto-generated method stub
		
	}
}
