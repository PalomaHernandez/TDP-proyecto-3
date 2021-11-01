package Fabrica;

import java.util.List;

import Entidades.Estaticas.Bomba;
import Entidades.Estaticas.Fruta;
import Entidades.Estaticas.PacDot;
import Entidades.Estaticas.Pared;
import Entidades.Estaticas.PowerPellet;
import Entidades.Estaticas.Velocidad;
import Entidades.Moviles.Enemigo;
import Entidades.Moviles.Protagonista;
import Logica.Juego;

public class TemaB extends Tema{

	private Juego miJuego;
	
	public TemaB(Juego miJuego) {
		this.miJuego = miJuego;
	}
	
	@Override
	public Pared getPared() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Protagonista getProtagonista() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Enemigo> getEnemigos() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Bomba getBomba() {
		// TODO Auto-generated method stub
		return null;
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

}
