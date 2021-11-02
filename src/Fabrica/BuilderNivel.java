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
import Logica.Nivel;

public class BuilderNivel implements Builder{

	private Nivel miNivel;
	
	public BuilderNivel() {
		miNivel = new Nivel();
	}
	
	@Override
	public void reset() {
		miNivel.limpiar();
	}

	@Override
	public void setPared(Tema tema,int x, int y) {
		Pared pared;
		
		pared = tema.getPared();
		pared.setX(x);
		pared.setY(y);
		miNivel.addEntidad(pared);
	}

	@Override
	public void setProtagonista(Tema tema,int x, int y) {
		Protagonista protagonista;
		
		protagonista = tema.getProtagonista();
		protagonista.setX(x);
		protagonista.setY(y);
		miNivel.setProtagonista(protagonista);
		miNivel.addEntidad(protagonista);
	}

	@Override
	public void setEnemigos(Tema tema, int x, int y) {//Recibe la posicion de la casa
		List<Enemigo> lista;

		lista = tema.getEnemigos();
		
		for(Enemigo e : lista) {
			e.setX(x);
			e.setY(y);
			miNivel.addEntidad(e);
		}
		
	}

	@Override
	public void setFruta(Tema tema, int x, int y) {
		Fruta fruta;
		
		fruta = tema.getFruta();
		fruta.setX(x);
		fruta.setY(y);
		miNivel.addEntidad(fruta);
	}

	@Override
	public void setPowerPellet(Tema tema, int x, int y) {
		PowerPellet powerP;
		
		powerP = tema.getPowerPellet();
		powerP.setX(x);
		powerP.setY(y);
		miNivel.addEntidad(powerP);
	}

	@Override
	public void setPacDot(Tema tema, int x, int y) {
		PacDot pacD;
		
		pacD = tema.getPacDot();
		pacD.setX(x);
		pacD.setY(y);
		miNivel.addEntidad(pacD);
	}

	@Override
	public void setBomba(Tema tema,int x, int y) {
		Bomba bomba;
		
		bomba = tema.getBomba();
		bomba.setX(x);
		bomba.setY(y);
		miNivel.addEntidad(bomba);
	}

	@Override
	public void setVelocidad(Tema tema,int x, int y) {
		Velocidad velocidad;
		
		velocidad = tema.getVelocidad();
		velocidad.setX(x);
		velocidad.setY(y);
		miNivel.addEntidad(velocidad);
	}

	@Override
	public Nivel getResult() {
		return miNivel;
	}

}