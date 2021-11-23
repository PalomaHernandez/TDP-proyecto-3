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
import Logica.Nivel;
import Logica.Zona;

public class VisitorProtagonista implements Visitor{

	@Override
	public void visit(Enemigo enemigo, Juego j) {
		Protagonista miProta= j.getProtagonista();
		if(miProta.getPowerPellet()==true) {
			//el enemigo vuelve a la casa
			j.reiniciarEnemigo(enemigo);
			j.aumentarPuntaje(200);
		}
		else {
			if(miProta.getVidas()>0) { //si el protagonista aun tiene vida
				j.eliminarProtagonista();
				miProta.setVidas(miProta.getVidas() - 1);
				//reiniciar posiciones de las entidades moviles
				j.reiniciarProtagonista();
				j.reiniciarEnemigos();
			}
			else
				j.perdiElJuego();
		}
	}

	@Override
	public void visit(Protagonista protagonista, Juego j) {

	}
	
	@Override
	public void visit(Bomba bomba, Juego j) {
		Zona z = j.calcularZona(bomba.getX(), bomba.getY());
		bomba.setVisible(false);
		z.removeEntidad(bomba);
		j.activarBomba(bomba);
	}

	@Override
	public void visit(Velocidad velocidad, Juego j) {
		Zona z = j.calcularZona(velocidad.getX(), velocidad.getY());
		velocidad.setVisible(false);
		z.removeEntidad(velocidad);
		j.activarVelocidad(); //Este metodo Aumenta velocidad del hilo
	}

	@Override
	public void visit(PowerPellet powerpellet, Juego j) {
		Nivel nivel= j.getNivel();
		nivel.restarPunto();
		Zona z = j.calcularZona(powerpellet.getX(), powerpellet.getY());
		z.removeEntidad(powerpellet);
		powerpellet.setVisible(false);
		j.aumentarPuntaje(30);
		j.activarPowerPellet();//este metodo actualizaria los estados del fantasma (actualizando su imagen)
		if(nivel.getCantPuntos()==0) {
			j.avanzarNivel();
		}

	}

	@Override
	public void visit(PacDot pacdot, Juego j) {
		Nivel nivel= j.getNivel();
		nivel.restarPunto();
		Zona z = j.calcularZona(pacdot.getX(), pacdot.getY());
		z.removeEntidad(pacdot);
		pacdot.setVisible(false);
		j.aumentarPuntaje(10);
		if(nivel.getCantPuntos()==0) {
			j.avanzarNivel();
		}
	}

	@Override
	public void visit(Fruta fruta, Juego j) {
		Zona z = j.calcularZona(fruta.getX(), fruta.getY());
		z.removeEntidad(fruta);
		fruta.setVisible(false);
		j.aumentarPuntaje(j.getNivel().getValorFruta());
	}

	@Override
	public void visit(Pared pared) {
	
	}


}
