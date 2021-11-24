package Fabrica;

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
import Logica.Nivel;

public class BuilderNivel implements Builder{

	private Nivel miNivel;
	private int cantPuntos;
	
	public BuilderNivel() {
		miNivel = new Nivel();
	}
	
	@Override
	public void reset() {
		miNivel.limpiar();
	}

	@Override
	public void setPared(Tema tema,int x, int y, int repre) {
		Pared pared;
		
		pared = tema.getPared();
		pared.setImagen(repre);
		pared.setPos(x, y);
		miNivel.addEntidad(pared);
	}

	@Override
	public void setProtagonista(Tema tema,int x, int y) {
		Protagonista protagonista;
		
		protagonista = tema.getProtagonista();
		protagonista.setPos(x, y);
		miNivel.setProtagonista(protagonista);
	}

	@Override
	public void setEnemigos(Tema tema, int x, int y) {//Recibe la posicion de la casa
		List<Enemigo> lista;

		lista = tema.getEnemigos();
		for(Enemigo e : lista) {
			e.setPos(x, y);
			miNivel.addEntidad(e);
		}
		
	}
	
	public void setCantPuntos() {
		miNivel.setCantPuntos(cantPuntos);
	}

	public void setBlinky(Tema tema, int x, int y) {
		Blinky enemigo;
		enemigo= tema.getBlinky();
		enemigo.setPos(x, y);
		miNivel.setBlinky(enemigo);
	}
	
	@Override
	public void setFruta(Tema tema, int x, int y, int i) {
		Fruta fruta= null;
		
		switch(i) {
		case 1: 
			fruta=tema.getFruta1();
			miNivel.setValorFruta(100);
			break;
		case 2: 
			fruta=tema.getFruta2();
			miNivel.setValorFruta(250);
			break;
		case 3: 
			fruta=tema.getFruta3();
			miNivel.setValorFruta(500);
			break;
		}
	
		fruta.setPos(x, y);
		miNivel.addEntidad(fruta);
	}

	@Override
	public void setPowerPellet(Tema tema, int x, int y) {
		PowerPellet powerP;
		
		powerP = tema.getPowerPellet();
		
		powerP.setPos(x, y);
		miNivel.addEntidad(powerP);
		cantPuntos++;
	}

	@Override
	public void setPacDot(Tema tema, int x, int y) {
		PacDot pacD;
		
		pacD = tema.getPacDot();
		
		pacD.setPos(x, y);
		miNivel.addEntidad(pacD);
		cantPuntos++;
	}

	
	@Override
	public void setBomba(Tema tema,int x, int y) {
		Bomba bomba;
		
		bomba = tema.getBomba();
		
		bomba.setPos(x, y);
		miNivel.addEntidad(bomba);
	}

	@Override
	public void setVelocidad(Tema tema,int x, int y) {
		Velocidad velocidad;
		
		velocidad = tema.getVelocidad();
		
		velocidad.setPos(x, y);
		miNivel.addEntidad(velocidad);
	}

	@Override
	public Nivel getResult() {
		return miNivel;
	}

	@Override
	public void setInky(Tema tema, int i, int j) {
		Inky enemigo;
		enemigo= tema.getInky();
		enemigo.setPos(i, j);
		miNivel.setInky(enemigo);
	}

	@Override
	public void setPinky(Tema tema, int i, int j) {
		Pinky enemigo;
		enemigo= tema.getPinky();
		enemigo.setPos(i, j);
		miNivel.setPinky(enemigo);
	}

	@Override
	public void setClyde(Tema tema, int i, int j) {
		Clyde enemigo;
		enemigo= tema.getClyde();
		enemigo.setPos(i, j);
		miNivel.setClyde(enemigo);
	}

}
