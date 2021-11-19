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

	}

	public void visit(Protagonista protagonista, Juego j) { //falta ver como conocer al enemigo que actua en el metodo
		Enemigo enemigo = j.buscarEnemigo();
		if(protagonista.getPowerPellet()==true) {
			//el enemigo vuelve a la casa
			j.reiniciarEnemigo(enemigo);
			j.aumentarPuntaje(200);
		}
		else {
			if(protagonista.getVidas()>0) {// si el protagonista aun tiene vida
				j.eliminarProtagonista();
				protagonista.setVidas(protagonista.getVidas() - 1);
				//reiniciar posiciones de las entidades moviles
				j.reiniciarProtagonista();
				//aca deberia pedir la lista de los enemigos y reiniciarle la pos a todos
				enemigo.setX(320);
				enemigo.setY(320);
			}
			else
				j.finalizarJuego();
		}
		System.out.println("visite protagonista");

	}

	@Override
	public void visit(Bomba bomba, Juego j) {

	}

	@Override
	public void visit(Velocidad velocidad, Juego j) {

	}

	@Override
	public void visit(PowerPellet powerpellet, Juego j) {

	}

	@Override
	public void visit(PacDot pacdot, Juego j) {

	}

	@Override
	public void visit(Fruta fruta, Juego j) {

	}


	@Override
	public void visit(Pared pared) {

	}

}
