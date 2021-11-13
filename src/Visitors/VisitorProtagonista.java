package Visitors;

import java.util.List;

import Entidades.Entidad;
import Entidades.Estaticas.Bomba;
import Entidades.Estaticas.Fruta;
import Entidades.Estaticas.PacDot;
import Entidades.Estaticas.Pared;
import Entidades.Estaticas.PowerPellet;
import Entidades.Estaticas.Punto;
import Entidades.Estaticas.Velocidad;
import Entidades.Moviles.Enemigo;
import Entidades.Moviles.Protagonista;
import Logica.Juego;
import Logica.Zona;

public class VisitorProtagonista implements Visitor{

	@Override
	public void visit(Enemigo enemigo, Juego j) {
//		if(j.getProtagonista().getPowerPellet()==true)
//			eliminarEnemigo();
//		else {
//			if(j.getProtagonista().getVidas()>0)
//			eliminarProtagonista();
//			else
//				finalizarJuego();
//		}
		System.out.println("visite enemigo");
		
	}

	@Override
	public void visit(Protagonista protagonista) {
		System.out.println("visite protagonista");
		
	}

	@Override
	public void visit(Bomba bomba, Juego j) {
		System.out.println("visite bomba");
		Zona z = j.calcularZona(bomba.getX(), bomba.getY());
		bomba.setVisible(false);
		z.removeEntidad(bomba);
		j.activarBomba();
	}

	@Override
	public void visit(Velocidad velocidad, Juego j) {
		System.out.println("visite velocidad");
		Zona z = j.calcularZona(velocidad.getX(), velocidad.getY());
		velocidad.setVisible(false);
		z.removeEntidad(velocidad);
		j.activarVelocidad(); //Este metodo Aumenta velocidad del hilo
	}

	@Override
	public void visit(PowerPellet powerpellet, Juego j) {
		System.out.println("visite powerPellet");
		//powerpellet.setCantPuntos(powerpellet.getCantPuntos()-1);
		Zona z = j.calcularZona(powerpellet.getX(), powerpellet.getY());
		z.removeEntidad(powerpellet);
		powerpellet.setVisible(false);
		j.setPuntaje(j.getPuntaje()+30);
		j.activarPowerPellet();//este metodo actualizaria los estados del fantasma (actualizando su imagen)
		
	}

	@Override
	public void visit(PacDot pacdot, Juego j) {
		System.out.println("visite pacdot");
		pacdot.setCantPuntos(pacdot.getCantPuntos()-1);
		Zona z = j.calcularZona(pacdot.getX(), pacdot.getY());
		z.removeEntidad(pacdot);
		pacdot.setVisible(false);
		j.setPuntaje(j.getPuntaje()+10);
	}

	@Override
	public void visit(Fruta fruta, Juego j) {
		System.out.println("visite fruta");
		Zona z = j.calcularZona(fruta.getX(), fruta.getY());
		z.removeEntidad(fruta);
		fruta.setVisible(false);
		j.setPuntaje(j.getPuntaje()+100);   //ver  como cambiar el valor segun el nivel
	}

	@Override
	public void visit(Pared pared) {
		System.out.println("visite pared");
		
	}


}
