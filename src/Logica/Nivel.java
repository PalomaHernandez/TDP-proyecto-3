package Logica;

import java.util.LinkedList;
import java.util.List;

import Entidades.Entidad;
import Entidades.Moviles.Enemigo;
import Entidades.Moviles.Protagonista;

public class Nivel {
	
	private Protagonista protagonista;
	private List<Entidad> lista;
	private List<Enemigo> listaEnemigos;

	public Nivel() {
		lista = new LinkedList<Entidad>();
	}
	
	public List<Entidad> getNivel(){
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
}
