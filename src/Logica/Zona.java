package Logica;

import java.awt.Rectangle;
import java.util.LinkedList;
import java.util.List;

import Entidades.Entidad;
import Visitors.Visitor;
import Visitors.VisitorProtagonista;

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
			if(entidad.intersects(entidad2)) {
				System.out.println("Colision.");
				//Visitor v1= new VisitorProtagonista();
				//e.accept(v1);
			}
		}
		return libre;
	}

	public void removeEntidad(Entidad e) {
		lista.remove(e);
	}

}
