package Logica;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

import Entidades.Entidad;
import Entidades.Moviles.Blinky;
import Entidades.Moviles.Clyde;
import Entidades.Moviles.Enemigo;
import Entidades.Moviles.Inky;
import Entidades.Moviles.Pinky;
import Entidades.Moviles.Protagonista;

public class Nivel {
	
	private Protagonista protagonista;
	private Clyde clyde;
	private Blinky blinky;
	private Inky inky;
	private Pinky pinky;
	private HashSet<Entidad> lista;
	private List<Enemigo> listaEnemigos;
	private int cantPuntos;
	
	public Nivel() {
		lista = new HashSet<Entidad>();
	}
	
	public void setCantPuntos(int puntos) {
		cantPuntos = puntos;
	}
	
	public int getCantPuntos() {
		return cantPuntos;
	}
	
	public void restarPunto() {
		cantPuntos--;
	}
	
	public HashSet<Entidad> getNivel(){
		return lista;
	}
	
	public void addEntidad(Entidad e) {
		lista.add(e);
	}
	
	public void eliminarEntidad(Entidad e) {
		lista.remove(e);
	}
	
	public void addEnemigo(Enemigo e) {
		listaEnemigos.add(e);
	}
	
	public void eliminarEnemigo(Enemigo e) {
		listaEnemigos.remove(e);
	}
	
	public List<Enemigo> getEnemigos(){
		return listaEnemigos;
	}

	public void limpiar() {
		if(!lista.isEmpty())
			lista.clear();
	}

	public void setProtagonista(Protagonista protagonista) {
		this.protagonista = protagonista;
	}
	
	public Protagonista getProtagonista() {
		return this.protagonista;
	}
	
	public void setClyde(Clyde clyde) {
		this.clyde = clyde;
	}
	
	public Clyde getClyde() {
		return this.clyde;
	}
	
	public void setPinky(Pinky pinky) {
		this.pinky = pinky;
	}
	
	public Pinky getPinky() {
		return this.pinky;
	}
	
	public void setBlinky(Blinky blinky) {
		this.blinky = blinky;
	}
	
	public Blinky getBlinky() {
		return this.blinky;
	}
	
	public void setInky(Inky inky) {
		this.inky = inky;
	}
	
	public Inky getInky() {
		return this.inky;
	}
}
