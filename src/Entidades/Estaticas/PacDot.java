package Entidades.Estaticas;

import GUI.PacDotGUI;

public class PacDot extends Punto{

	private static final long serialVersionUID = 1L;
	private PacDotGUI miRepresentacion;
	
	public PacDot(String pacDot) {
		miRepresentacion = new PacDotGUI(pacDot);
		this.representacion = pacDot;
		tamano = 10;
	}

}
