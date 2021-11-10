package Visitors;

import Entidades.Estaticas.Bomba;
import Entidades.Estaticas.Fruta;
import Entidades.Estaticas.PacDot;
import Entidades.Estaticas.Pared;
import Entidades.Estaticas.PowerPellet;
import Entidades.Estaticas.Velocidad;
import Entidades.Moviles.Enemigo;
import Entidades.Moviles.Protagonista;
import Logica.Zona;

public class VisitorProtagonista implements Visitor{

	@Override
	public void visit(Enemigo enemigo) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void visit(Protagonista protagonista) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void visit(Bomba bomba) {//Falta el accept en bomba
		System.out.println("visite bomba");
		//Zona z=velocidad.getZona();
		//z.removeEntidad(bomba);
		bomba.setVisible(false);
		//actualizarPuntaje
		//Aumentar velocidad, cambiar estado del protagonista
	}

	@Override
	public void visit(Velocidad velocidad) {//Falta el accept en velocidad
		System.out.println("visite velocidad");
		//Zona z=velocidad.getZona();
		//z.removeEntidad(powerpellet);
		velocidad.setVisible(false);
		//actualizarPuntaje
		//Aumentar velocidad, cambiar estado del protagonista
	}

	@Override
	public void visit(PowerPellet powerpellet) {
		System.out.println("visite powerPellet");
		//powerpellet.setCantPuntos(powerpellet.getCantPuntos()-1);
		//Zona z=powerpellet.getZona();
		//z.removeEntidad(powerpellet);
		powerpellet.setVisible(false);
		//actualizarPuntaje
	}

	@Override
	public void visit(PacDot pacdot) {
		System.out.println("visite pacdot");
		pacdot.setCantPuntos(pacdot.getCantPuntos()-1);
		//Zona z=pacdot.getZona();
		//z.removeEntidad(pacdot);
		pacdot.setVisible(false);
		//actualizarPuntaje
	}

	@Override
	public void visit(Fruta fruta) {//falta el accept en fruta
		System.out.println("visite fruta");
		//Zona z=fruta.getZona();
		//z.removeEntidad(fruta);
		fruta.setVisible(false);
		//actualizarPuntaje
	}

	@Override
	public void visit(Pared pared) {
		System.out.println("Visite pared");
		//no deberia dejar mover
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
