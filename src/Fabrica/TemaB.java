package Fabrica;

import java.util.LinkedList;
import java.util.List;

import Entidades.Estaticas.Bomba;
import Entidades.Estaticas.Fruta;
import Entidades.Estaticas.PacDot;
import Entidades.Estaticas.Pared;
import Entidades.Estaticas.PowerPellet;
import Entidades.Estaticas.Velocidad;
import Entidades.Moviles.Blinky;
import Entidades.Moviles.Clyde;
import Entidades.Moviles.Enemigo;
import Entidades.Moviles.Inky;
import Entidades.Moviles.Pinky;
import Entidades.Moviles.Protagonista;
import Logica.Juego;

public class TemaB extends Tema{

	private Juego miJuego;
	
	public TemaB(Juego miJuego) {
		this.miJuego = miJuego;
	}
	
	@Override
	public Pared getPared() {
		Pared pared =new Pared("/imagenesB/ParedB.png");
		return pared;
	}

	@Override
	public Protagonista getProtagonista() {
		Protagonista protagonista;
		
		protagonista = new Protagonista(miJuego);
		protagonista.getGUI().setNormal("/imagenesB/barco_arriba.png", "/imagenesB/barco_abajo.png", "/imagenesB/barco_der.png", "/imagenesB/barco_izq.png");
		
		return protagonista;
	}

	@Override
	public List<Enemigo> getEnemigos() {
		List<Enemigo> lista;
		
		lista = new LinkedList<Enemigo>();
//		
//		lista.add(new Inky(null));
//		lista.add(new Blinky(null));
//		lista.add(new Pinky(null));
//		lista.add(new Clyde(null));
		return lista;
	}

	@Override
	public Bomba getBomba() {
		return new Bomba("/imagenesB/bomba.png");
	}

	@Override
	public Velocidad getVelocidad() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public PowerPellet getPowerPellet() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public PacDot getPacDot() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Fruta getFruta() {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public Blinky getBlinky() {
		// TODO Auto-generated method stub
		return null;
	}

}
