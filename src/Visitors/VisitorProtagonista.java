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

public class VisitorProtagonista implements Visitor{

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
		System.out.println("visite bomba");
		//Zona z = j.calcularZona(bomba.getX(), bomba.getY());
		//z.removeEntidad(bomba);
		bomba.setVisible(false);
		//actualizarPuntaje
		//Aumentar velocidad, cambiar estado del protagonista
	}

	@Override
	public void visit(Velocidad velocidad, Juego j) {
		System.out.println("visite velocidad");
		//Zona z = j.calcularZona(velocidad.getX(), velocidad.getY());
		//z.removeEntidad(velocidad);
		velocidad.setVisible(false);
		//actualizarPuntaje
		//Aumentar velocidad, cambiar estado del protagonista
	}

	@Override
	public void visit(PowerPellet powerpellet, Juego j) {
		System.out.println("visite powerPellet");
		//powerpellet.setCantPuntos(powerpellet.getCantPuntos()-1);
		//Zona z = j.calcularZona(powerpellet.getX(), powerpellet.getY());
		//z.removeEntidad(powerpellet);
		powerpellet.setVisible(false);
		//actualizarPuntaje
	}

	@Override
	public void visit(PacDot pacdot, Juego j) {
		System.out.println("visite pacdot");
		pacdot.setCantPuntos(pacdot.getCantPuntos()-1);
		//Zona z = j.calcularZona(pacdot.getX(), pacdot.getY());
		//z.removeEntidad(pacdot);
		pacdot.setVisible(false);
		//actualizarPuntaje
	}

	@Override
	public void visit(Fruta fruta, Juego j) {
		System.out.println("visite fruta");
		//Zona z = j.calcularZona(fruta.getX(), fruta.getY());
		//z.removeEntidad(fruta);
		fruta.setVisible(false);
		//actualizarPuntaje
	}

	@Override
	public void visit(Pared pared) {
		// TODO Auto-generated method stub
		
	}

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

}
