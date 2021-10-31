package Fabrica;

public class Fabrica {
	
	private Tema temaA;
	private Tema temaB;

	public Fabrica() {
		temaA = new TemaA();
		temaB = new TemaB();
	}
	
	public Tema getTemaA() {
		return temaA;
	}
	
	public Tema getTemaB() {
		return temaB;
	}
}
