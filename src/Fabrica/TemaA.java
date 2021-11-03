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

public class TemaA extends Tema{

	private Juego miJuego;
	
	public TemaA(Juego miJuego) {
		this.miJuego = miJuego;
	}
	
	@Override
	public Pared getPared() {
		return new Pared("/imagenes/pared.png");
	}

	@Override
	public Protagonista getProtagonista() {
		Protagonista protagonista;
		
		protagonista = new Protagonista(miJuego);
		protagonista.getGUI().setNormal("/imagenes/autoArriba.png", "/imagenes/autoAbajo.png", "/imagenes/autoDerecha.png", "/imagenes/autoIzquierda.png");
		
		return protagonista;
	}

	@Override
	public List<Enemigo> getEnemigos() {
		List<Enemigo> lista;
		
		lista = new LinkedList<Enemigo>();
		
		lista.add(new Inky(null));
		lista.add(new Blinky(null));
		lista.add(new Pinky(null));
		lista.add(new Clyde(null));
		return lista;
	}

	@Override
	public Bomba getBomba() {
		return new Bomba("/imagenes/bomba.png");
	}

	@Override
	public Velocidad getVelocidad() {
		return new Velocidad("/imagenes/velocidad.png");
	}

	@Override
	public PowerPellet getPowerPellet() {
		return new PowerPellet("/imagenes/bidon.png");
	}

	@Override
	public PacDot getPacDot() {
		return new PacDot();
	}

	@Override
	public Fruta getFruta() {
		return new Fruta("/imagenes/herramienta.png");
	}

}
