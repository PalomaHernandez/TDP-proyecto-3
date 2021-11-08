package Logica;

import java.awt.Rectangle;
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
		boolean libre = true;
	
		Rectangle entidad = new Rectangle(cordX, cordY, tamanoX, tamanoY);
		for(Entidad e : lista) {
			Rectangle entidad2 = new Rectangle(e.getX(), e.getY(), e.getTamano(), e.getTamano());
			if(entidad.intersects(entidad2) && !entidad.equals(entidad2)) {
				System.out.println("Colision.");
			}
		}
		return libre;
	}

	public void removeEntidad(Entidad e) {
		lista.remove(e);
	}

}
