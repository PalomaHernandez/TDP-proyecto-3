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
		Pared pared =new Pared("/imagenesB/pared/h0.png");
		pared.getRepre().agregarImagenes("/imagenesB/pared/h1.png", "/imagenesB/pared/h2.png", "/imagenesB/pared/v3.png", "/imagenesB/pared/v4.png", "/imagenesB/pared/v5.png", "/imagenesB/pared/c6.png", "/imagenesB/pared/c7.png", "/imagenesB/pared/c8.png", "/imagenesB/pared/c9.png", "/imagenesB/pared/c10.png", "/imagenesB/pared/c11.png", "/imagenesB/pared/c12.png", "/imagenesB/pared/c13.png", "/imagenesB/pared/c14.png", "/imagenesB/pared/c15.png", "/imagenesB/pared/c16.png", "/imagenesB/pared/c17.png", "/imagenesB/pared/v18.png", "/imagenesB/pared/v19.png", "/imagenesB/pared/h20.png", "/imagenesB/pared/h21.png", "/imagenesB/pared/cesped.png", "/imagenesB/pared/rotonda.png");
		return pared;
	}

	@Override
	public Protagonista getProtagonista() {
		Protagonista protagonista;
		
		protagonista = new Protagonista(miJuego);
		protagonista.getGUI().setNormal("/imagenesB/barco_arriba.png", "/imagenesB/barco_abajo.png", "/imagenesB/barco_der.png", "/imagenesB/barco_izq.png");
		protagonista.getGUI().setAzul("/imagenesB/barcoAzul_arriba.png", "/imagenesB/barcoAzul_abajo.png", "/imagenesB/barcoAzul_derecha.png", "/imagenesB/barcoAzul_izquierda.png");
		protagonista.getGUI().setBomba("/imagenesB/barcoBomba_arriba.png", "/imagenesB/barcoBomba_abajo.png", "/imagenesB/barcoBomba_derecha.png", "/imagenesB/barcoBomba_izquierda.png");
		protagonista.getGUI().setAzul("/imagenesB/barcoVelocidad_arriba.png", "/imagenesB/barcoVelocidad_abajo.png", "/imagenesB/barcoVelocidad_derecha.png", "/imagenesB/barcoVelocidad_izquierda.png");
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
	public Bomba getBomba() {
		return new Bomba("/imagenesB/bomba.png");
	}

	@Override
	public Velocidad getVelocidad() {
		return new Velocidad("/imagenesB/barril.png");
	}

	@Override
	public PowerPellet getPowerPellet() {
		return new PowerPellet("/imagenesB/cofre.png");
	}

	@Override
	public PacDot getPacDot() {
		return new PacDot("/imagenesB/pacdotB.png");
	}

	@Override
	public Blinky getBlinky() {
		Blinky enemigo;
		enemigo=new Blinky("/imagenesB/blinky_abajo.png");
		enemigo.getGUI().setNormal("/imagenesB/blinky_abajo.png","/imagenesB/blinky_arriba.png","/imagenesB/blinky_izquierda.png","/imagenesB/blinky_derecha.png") ;
		enemigo.getGUI().setAzul("/imagenesB/barcoPoliciaAzul_abajo.png", "/imagenesB/barcoPoliciaAzul_arriba.png", "/imagenesB/barcoPoliciaAzul_izquierda.png", "/imagenesB/barcoPoliciaAzul_derecha.png");
		return enemigo;
	}

	@Override
	public Inky getInky() {
		Inky enemigo;
		enemigo=new Inky("/imagenesB/inky_abajo.png");
		enemigo.getGUI().setNormal("/imagenesB/inky_abajo.png","/imagenesB/inky_arriba.png","/imagenesB/inky_izquierda.png","/imagenesB/inky_derecha.png") ;
		enemigo.getGUI().setAzul("/imagenesB/barcoPoliciaAzul_abajo.png", "/imagenesB/barcoPoliciaAzul_arriba.png", "/imagenesB/barcoPoliciaAzul_izquierda.png", "/imagenesB/barcoPoliciaAzul_derecha.png");
		return enemigo;
	}

	@Override
	public Pinky getPinky() {
		Pinky enemigo;
		enemigo=new Pinky("/imagenesB/pinky_abajo.png");
		enemigo.getGUI().setNormal("/imagenesB/pinky_abajo.png","/imagenesB/pinky_arriba.png","/imagenesB/pinky_izquierda.png","/imagenesB/pinky_derecha.png") ;
		enemigo.getGUI().setAzul("/imagenesB/barcoPoliciaAzul_abajo.png", "/imagenesB/barcoPoliciaAzul_arriba.png", "/imagenesB/barcoPoliciaAzul_izquierda.png", "/imagenesB/barcoPoliciaAzul_derecha.png");
		return enemigo;
	}

	@Override
	public Clyde getClyde() {
		Clyde enemigo;
		enemigo=new Clyde("/imagenesB/clyde_abajo.png");
		enemigo.getGUI().setNormal("/imagenesB/clyde_abajo.png","/imagenesB/clyde_arriba.png","/imagenesB/clyde_izquierda.png","/imagenesB/clyde_derecha.png") ;
		enemigo.getGUI().setAzul("/imagenesB/barcoPoliciaAzul_abajo.png", "/imagenesB/barcoPoliciaAzul_arriba.png", "/imagenesB/barcoPoliciaAzul_izquierda.png", "/imagenesB/barcoPoliciaAzul_derecha.png");
		return enemigo;
	}

	@Override
	public Fruta getFruta1() {
		return new Fruta("/imagenesB/Fruta1B.png");
	}

	@Override
	public Fruta getFruta2() {
		return new Fruta("/imagenesB/Fruta2B.png");
	}

	@Override
	public Fruta getFruta3() {
		return new Fruta("/imagenesB/Fruta3B.png");
	}

}
