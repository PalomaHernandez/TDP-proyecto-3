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
import Logica.Nivel;
import Logica.Zona;

public class VisitorProtagonista implements Visitor{

	@Override
	public void visit(Enemigo enemigo, Juego j) {
		Protagonista miProta= j.getProtagonista();
		if(miProta.getPowerPellet()==true) {
			//el enemigo vuelve a la casa
			j.reiniciarEnemigos(enemigo);
		}
		else {
			if(miProta.getVidas()>0) { //si el protagonista aun tiene vida
				j.eliminarProtagonista();
				miProta.setVidas(miProta.getVidas() - 1);
				//reiniciar posiciones de las entidades moviles
				j.reiniciarProtagonista();
				//aca deberia pedir la lista de los enemigos y reiniciarle la pos a todos
				j.reiniciarEnemigos(enemigo);
			}
			else
				j.finalizarJuego();
		}
		System.out.println("visite enemigo");

	}

	@Override
	public void visit(Protagonista protagonista, Juego j) {
		
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
		Nivel nivel= j.getNivel();
		nivel.restarPunto();
		Zona z = j.calcularZona(powerpellet.getX(), powerpellet.getY());
		z.removeEntidad(powerpellet);
		powerpellet.setVisible(false);
		j.aumentarPuntaje(30);
		j.activarPowerPellet();//este metodo actualizaria los estados del fantasma (actualizando su imagen)
		if(nivel.getCantPuntos()==0) {
			System.out.println("paseNivel");
			j.avanzarNivel();
		}

	}

	@Override
	public void visit(PacDot pacdot, Juego j) {
		System.out.println("visite pacdot");
		Nivel nivel= j.getNivel();
		nivel.restarPunto();
		Zona z = j.calcularZona(pacdot.getX(), pacdot.getY());
		z.removeEntidad(pacdot);
		pacdot.setVisible(false);
		j.aumentarPuntaje(10);
		if(nivel.getCantPuntos()==0) {
			System.out.println("paseNivel");
			j.avanzarNivel();
		}
	}

	@Override
	public void visit(Fruta fruta, Juego j) {
		System.out.println("visite fruta");
		Zona z = j.calcularZona(fruta.getX(), fruta.getY());
		z.removeEntidad(fruta);
		fruta.setVisible(false);
		j.aumentarPuntaje(100);//ver  como cambiar el valor segun el nivel
	}

	@Override
	public void visit(Pared pared) {
		System.out.println("visite pared");

	}


}
