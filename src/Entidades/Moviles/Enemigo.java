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
	
	public Enemigo(String string) {
		miRepresentacion = new EnemigoGUI();
		tamano = 20;
		v= new VisitorFantasma();
		representacion=string ;
	}
	
	public boolean accept(Visitor v, Juego j) {
		v.visit(this, j);		
		return false;
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
