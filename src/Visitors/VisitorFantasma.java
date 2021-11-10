package Visitors;

import Entidades.Estaticas.Bomba;
import Entidades.Estaticas.Fruta;
import Entidades.Estaticas.PacDot;
import Entidades.Estaticas.Pared;
import Entidades.Estaticas.PowerPellet;
import Entidades.Estaticas.Velocidad;
import Entidades.Moviles.Enemigo;
import Entidades.Moviles.Protagonista;
import Logica.Juego;

public class VisitorFantasma implements Visitor {

	@Override
	public void visit(Enemigo enemigo, Juego j) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void visit(Protagonista protagonista) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void visit(Bomba bomba, Juego j) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void visit(Velocidad velocidad, Juego j) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void visit(PowerPellet powerpellet, Juego j) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void visit(PacDot pacdot, Juego j) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void visit(Fruta fruta, Juego j) {
		// TODO Auto-generated method stub
		
	}
//
//	@Override
//	public void visitFantasma(Enemigo fantasma) {
//		// TODO Auto-generated method stub
//		
//	}
//
//	@Override
//	public void visitProtagonista(Protagonista protagonista) {
//		// TODO Auto-generated method stub
//		
//	}

	@Override
	public void visit(Pared pared) {
		// TODO Auto-generated method stub
		
	}

}
