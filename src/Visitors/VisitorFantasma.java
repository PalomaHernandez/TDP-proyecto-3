package Visitors;

import java.util.List;

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

public class VisitorFantasma implements Visitor {

	@Override
	public void visit(Enemigo enemigo, Juego j) {
		// TODO Auto-generated method stub
		
	}

	public void visit(Protagonista protagonista, Juego j) { //falta ver como conocer al enemigo que actua en el metodo
//		Protagonista miProta= j.getProtagonista();
//		if(miProta.getPowerPellet()==true) {
//			//el enemigo vuelve a la casa
//			enemigo.setX(320);
//			enemigo.setY(320);
//		}
//		else {
//			if(miProta.getVidas()>0) { //si el protagonista aun tiene vida
//			j.eliminarProtagonista();
//			miProta.setVidas(miProta.getVidas() - 1);
//			//reiniciar posiciones de las entidades moviles
//			miProta.setX(320);
//			miProta.setY(544);
//			//aca deberia pedir la lista de los enemigos y reiniciarle la pos a todos
//			enemigo.setX(320);
//			enemigo.setY(320);
//			}
//			else
//				j.finalizarJuego();
//		}
		System.out.println("visite protagonista");
		
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


	@Override
	public void visit(Pared pared) {
		// TODO Auto-generated method stub
		
	}

}
