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
		Pared pared =new Pared("/imagenesA/ParedAuto/h0.png");
		pared.getRepre().agregarImagenes("/imagenesA/ParedAuto/h1.png", "/imagenesA/ParedAuto/h2.png", "/imagenesA/ParedAuto/v3.png", "/imagenesA/ParedAuto/v4.png", "/imagenesA/ParedAuto/v5.png", "/imagenesA/ParedAuto/c6.png", "/imagenesA/ParedAuto/c7.png", "/imagenesA/ParedAuto/c8.png", "/imagenesA/ParedAuto/c9.png", "/imagenesA/ParedAuto/c10.png", "/imagenesA/ParedAuto/c11.png", "/imagenesA/ParedAuto/c12.png", "/imagenesA/ParedAuto/c13.png", "/imagenesA/ParedAuto/c14.png", "/imagenesA/ParedAuto/c15.png", "/imagenesA/ParedAuto/c16.png", "/imagenesA/ParedAuto/c17.png", "/imagenesA/ParedAuto/v18.png", "/imagenesA/ParedAuto/v19.png", "/imagenesA/ParedAuto/h20.png", "/imagenesA/ParedAuto/h21.png", "/imagenesA/ParedAuto/cesped.png", "/imagenesA/ParedAuto/rotonda.png");
		return pared;
	}

	@Override
	public Protagonista getProtagonista() {
		Protagonista protagonista;
		
		protagonista = new Protagonista(miJuego);
		protagonista.getGUI().setNormal("/imagenesA/autoArriba.png", "/imagenesA/autoAbajo.png", "/imagenesA/autoDerecha.png", "/imagenesA/autoIzquierda.png");
		
		return protagonista;
	}

	@Override
	public List<Enemigo> getEnemigos() {
		List<Enemigo> lista;
		
		lista = new LinkedList<Enemigo>();
		
		lista.add(new Blinky("/imagenesA/PoliciaAbajo.png","/imagenesA/PoliciaArriba.png","/imagenesA/PoliciaIzquierda.png","/imagenesA/PoliciaDerecha.png","/imagenesA/PoliciaAbajo.png" ));
		lista.add(new Inky("/imagenesA/PoliciaAbajo.png","/imagenesA/PoliciaArriba.png","/imagenesA/PoliciaIzquierda.png","/imagenesA/PoliciaDerecha.png","/imagenesA/PoliciaAbajo.png" ));
		lista.add(new Pinky("/imagenesA/PoliciaAbajo.png","/imagenesA/PoliciaArriba.png","/imagenesA/PoliciaIzquierda.png","/imagenesA/PoliciaDerecha.png","/imagenesA/PoliciaAbajo.png" ));
		lista.add(new Clyde("/imagenesA/PoliciaAbajo.png","/imagenesA/PoliciaArriba.png","/imagenesA/PoliciaIzquierda.png","/imagenesA/PoliciaDerecha.png","/imagenesA/PoliciaAbajo.png" ));
		
		
		return lista;
	}

	public Enemigo getEnemigo() {
		Enemigo enemigo;
		enemigo=new Enemigo("/imagenesA/policiaAbajo.png","/imagenesA/policiaArriba.png","/imagenesA/policiaIzquierda.png","/imagenesA/policiaDerecha.png","/imagenesA/policiaAbajo.png" );
		return enemigo;
	}
	
	@Override
	public Bomba getBomba() {
		return new Bomba("/imagenesA/bomba.png");
	}

	@Override
	public Velocidad getVelocidad() {
		return new Velocidad("/imagenesA/velocidad.png");
	}

	@Override
	public PowerPellet getPowerPellet() {
		return new PowerPellet("/imagenesA/bidon.png");
	}

	@Override
	public PacDot getPacDot() {
		return new PacDot("/imagenesA/rueda.png");
	}

	@Override
	public Fruta getFruta() {
		return new Fruta("/imagenesA/herramienta.png");
	}

}
