package Fabrica;

import java.util.List;

import Entidades.Estaticas.Bomba;
import Entidades.Estaticas.Fruta;
import Entidades.Estaticas.PacDot;
import Entidades.Estaticas.Pared;
import Entidades.Estaticas.PowerPellet;
import Entidades.Estaticas.Velocidad;
import Entidades.Moviles.Protagonista;
import Entidades.Moviles.Enemigo;

public abstract class Tema {

	public abstract Pared getPared();
	public abstract Protagonista getProtagonista();
	public abstract List<Enemigo> getEnemigos();
	public abstract Bomba getBomba();
	public abstract Velocidad getVelocidad();
	public abstract PowerPellet getPowerPellet();
	public abstract PacDot getPacDot();
	public abstract Fruta getFruta();
	
}
