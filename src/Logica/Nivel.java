package Logica;

import java.util.LinkedList;
import java.util.List;

import Entidades.Entidad;
import Entidades.Moviles.Protagonista;

public class Nivel {
	
	private Protagonista protagonista;
	private List<Entidad> lista;

	public Nivel() {
		lista = new LinkedList<Entidad>();
	}
	
	public List<Entidad> getNivel(){
		return lista;
	}
	
	public void addEntidad(Entidad e) {
		lista.add(e);
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
