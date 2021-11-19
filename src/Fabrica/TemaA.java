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
		protagonista.getGUI().setAzul("/imagenesA/autoArribaAzul.png", "/imagenesA/autoAbajoAzul.png", "/imagenesA/autoDerechaAzul.png", "/imagenesA/autoIzquierdaAzul.png");
		protagonista.getGUI().setBomba("/imagenesA/autoArribaBomba.png", "/imagenesA/autoAbajoBomba.png", "/imagenesA/autoDerechaBomba.png", "/imagenesA/autoIzquierdaBomba.png");
		protagonista.getGUI().setVelocidad("/imagenesA/autoArribaVelocidad.png", "/imagenesA/autoAbajoVelocidad.png", "/imagenesA/autoDerechaVelocidad.png", "/imagenesA/autoIzquierdaVelocidad.png");
		return protagonista;
	}

	@Override
	public List<Enemigo> getEnemigos() {
		List<Enemigo> lista;
		
		lista = new LinkedList<Enemigo>();
		
		lista.add(getBlinky());
		lista.add(getInky());
		lista.add(getPinky());
		lista.add(getClyde());
		
		
		return lista;
	}
	
	@Override
	public Blinky getBlinky() {
		Blinky enemigo;
		enemigo=new Blinky("/imagenesA/blinkyAbajo.png");
		enemigo.getGUI().setNormal("/imagenesA/blinkyAbajo.png","/imagenesA/blinkyArriba.png","/imagenesA/blinkyIzquierda.png","/imagenesA/blinkyDerecha.png") ;
		enemigo.getGUI().setAzul("/imagenesA/policiaAbajoAzul.png", "/imagenesA/policiaArribaAzul.png", "/imagenesA/policiaIzquierdaAzul.png", "/imagenesA/policiaDerechaAzul.png");
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

	@Override
	public Inky getInky() {
		Inky enemigo;
		enemigo=new Inky("/imagenesA/inkyAbajo.png");
		enemigo.getGUI().setNormal("/imagenesA/inkyAbajo.png","/imagenesA/inkyArriba.png","/imagenesA/inkyIzquierda.png","/imagenesA/inkyDerecha.png") ;
		enemigo.getGUI().setAzul("/imagenesA/policiaAbajoAzul.png", "/imagenesA/policiaArribaAzul.png", "/imagenesA/policiaIzquierdaAzul.png", "/imagenesA/policiaDerechaAzul.png");
		return enemigo;
	}

	@Override
	public Pinky getPinky() {
		Pinky enemigo;
		enemigo=new Pinky("/imagenesA/pinkyAbajo.png");
		enemigo.getGUI().setNormal("/imagenesA/pinkyAbajo.png","/imagenesA/pinkyArriba.png","/imagenesA/pinkyIzquierda.png","/imagenesA/pinkyDerecha.png") ;
		enemigo.getGUI().setAzul("/imagenesA/policiaAbajoAzul.png", "/imagenesA/policiaArribaAzul.png", "/imagenesA/policiaIzquierdaAzul.png", "/imagenesA/policiaDerechaAzul.png");
		return enemigo;
	}

	@Override
	public Clyde getClyde() {
		Clyde enemigo;
		enemigo=new Clyde("/imagenesA/clydeAbajo.png");
		enemigo.getGUI().setNormal("/imagenesA/clydeAbajo.png","/imagenesA/clydeArriba.png","/imagenesA/clydeIzquierda.png","/imagenesA/clydeDerecha.png") ;
		enemigo.getGUI().setAzul("/imagenesA/policiaAbajoAzul.png", "/imagenesA/policiaArribaAzul.png", "/imagenesA/policiaIzquierdaAzul.png", "/imagenesA/policiaDerechaAzul.png");
		return enemigo;
	}

}
