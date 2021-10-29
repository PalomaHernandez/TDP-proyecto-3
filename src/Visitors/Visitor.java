package Visitors;

import Entidades.Moviles.Enemigo;
import Entidades.Moviles.Protagonista;

public interface Visitor {

	public void visitFantasma(Enemigo fantasma);
	
	public void visitProtagonista(Protagonista protagonista);
	
}
