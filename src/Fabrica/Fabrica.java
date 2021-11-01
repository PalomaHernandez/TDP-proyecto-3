package Fabrica;

import Logica.Juego;

public class Fabrica {
	
	private Tema temaA;
	private Tema temaB;
	private Juego miJuego;
	
	public Fabrica(Juego miJuego) {
		this.miJuego = miJuego;
		temaA = new TemaA(miJuego);
		temaB = new TemaB(miJuego);
	}
	
	public Tema getTemaA() {
		return temaA;
	}
	
	public Tema getTemaB() {
		return temaB;
	}
}
