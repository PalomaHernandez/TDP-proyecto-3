package Logica;

import java.util.HashSet;

import Entidades.Entidad;

public class Zona {

	private HashSet<Entidad> lista;
	
	public Zona() {
		lista = new HashSet<Entidad>();
	}
	
	public void addEntidad(Entidad e) {
		lista.add(e);
	}
	
	public HashSet<Entidad> getLista() {
		return lista;
	}
	
	public void removeEntidad(Entidad e) {
		lista.remove(e);
	}

}
