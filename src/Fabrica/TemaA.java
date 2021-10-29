package Fabrica;

import java.util.LinkedList;
import java.util.List;

import Entidades.Estaticas.Bomba;
import Entidades.Estaticas.BombaA;
import Entidades.Estaticas.Fruta;
import Entidades.Estaticas.FrutaA;
import Entidades.Estaticas.PacDot;
import Entidades.Estaticas.PacDotA;
import Entidades.Estaticas.Pared;
import Entidades.Estaticas.ParedA;
import Entidades.Estaticas.PowerPellet;
import Entidades.Estaticas.PowerPelletA;
import Entidades.Estaticas.Velocidad;
import Entidades.Estaticas.VelocidadA;
import Entidades.Moviles.BlinkyA;
import Entidades.Moviles.ClydeA;
import Entidades.Moviles.Enemigo;
import Entidades.Moviles.InkyA;
import Entidades.Moviles.PinkyA;
import Entidades.Moviles.Protagonista;
import Entidades.Moviles.ProtagonistaA;

public class TemaA extends Tema{

	@Override
	public Pared getPared() {
		return new ParedA();
	}

	@Override
	public Protagonista getProtagonista() {
		return new ProtagonistaA();
	}

	@Override
	public List<Enemigo> getEnemigos() {
		List<Enemigo> lista;
		
		lista = new LinkedList<Enemigo>();
		
		lista.add(new InkyA());
		lista.add(new BlinkyA());
		lista.add(new PinkyA());
		lista.add(new ClydeA());
		return lista;
	}

	@Override
	public Bomba getBomba() {
		return new BombaA();
	}

	@Override
	public Velocidad getVelocidad() {
		return new VelocidadA();
	}

	@Override
	public PowerPellet getPowerPellet() {
		return new PowerPelletA();
	}

	@Override
	public PacDot getPacDot() {
		return new PacDotA();
	}

	@Override
	public Fruta getFruta() {
		return new FrutaA();
	}

}
