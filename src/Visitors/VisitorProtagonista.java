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
		z.removeEntidad(bomba);
		bomba.setVisible(false);
		j.getProtagonista().activarBomba();
		j.getProtagonista().getGUI().setBomba("/imagenesA/autoArribaBomba.png", "/imagenesA/autoAbajoBomba.png", "/imagenesA/autoDerechaBomba.png", "/imagenesA/autoIzquierdaBomba.png");
	}

	@Override
	public void visit(Velocidad velocidad, Juego j) {
		System.out.println("visite velocidad");
		Zona z = j.calcularZona(velocidad.getX(), velocidad.getY());
		z.removeEntidad(velocidad);
		velocidad.setVisible(false);
		j.getProtagonista().activarVelocidad();
		j.getProtagonista().getGUI().setBomba("/imagenesA/autoArribaVelocidad.png", "/imagenesA/autoAbajoVelocidad.png", "/imagenesA/autoDerechaVelocidad.png", "/imagenesA/autoIzquierdaVelocidad.png");
		//Aumentar velocidad, cambiar estado del protagonista
	}

	@Override
	public void visit(PowerPellet powerpellet, Juego j) {
		System.out.println("visite powerPellet");
		//powerpellet.setCantPuntos(powerpellet.getCantPuntos()-1);
		Zona z = j.calcularZona(powerpellet.getX(), powerpellet.getY());
		z.removeEntidad(powerpellet);
		powerpellet.setVisible(false);
		j.setPuntaje(j.getPuntaje()+30);
		j.getProtagonista().activarPowerPellet();
		List<Enemigo> lista=j.getNivel().getEnemigos();
		for(Enemigo e: lista)
		e.getGUI().setAzul("/imagenesA/autoAbajo.png","/imagenesA/autoArriba.png","/imagenesA/autoIzquierda.png","/imagenesA/autoDerecha.png");
		
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
