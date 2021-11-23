package Entidades.Estaticas;

import javax.swing.ImageIcon;

import Entidades.Entidad;
import GUI.BombaGUI;
import GUI.VentanaGUI;
import Logica.Juego;
import Visitors.Visitor;

public class Bomba extends Entidad {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private BombaGUI miRepresentacion;
	
	public Bomba(String bomba) {
		miRepresentacion = new BombaGUI(bomba);
		this.representacion = bomba;
		tamano = 20;
	}

	@Override
	public boolean accept(Visitor v, Juego j) {
		v.visit(this, j);
		return false;
	}
	
	public void explosion() {
		miRepresentacion.cambiarImagen( "/imagenesA/explosion.png");
		this.setIcon(new ImageIcon(VentanaGUI.class.getResource(miRepresentacion.getImagen())));
	}
	
}
