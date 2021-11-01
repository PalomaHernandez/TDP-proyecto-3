package Logica;

import java.util.LinkedList;
import java.util.List;

import Entidades.Entidad;

public class Zona {

	private List<Entidad> lista;
	
	public Zona() {
		lista = new LinkedList<Entidad>();
	}
	
	public void addEntidad(Entidad e) {
		lista.add(e);
	}

	public boolean existePosLibre(int cordX, int cordY, int tamanoX, int tamanoY) {
		// TODO Auto-generated method stub
		return false;
	}

	public void removeEntidad(Entidad e) {
		lista.remove(e);
	}

}
