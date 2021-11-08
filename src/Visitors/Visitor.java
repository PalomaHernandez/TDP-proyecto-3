package Visitors;

import Entidades.Estaticas.*;
import Entidades.Moviles.Enemigo;
import Entidades.Moviles.Protagonista;

public interface Visitor {

//	public void visitFantasma(Enemigo fantasma);
//	
//	public void visitProtagonista(Protagonista protagonista);
	
	public void visit(Enemigo enemigo);
	
	public void visit(Protagonista protagonista);
	
	public void visit(Bomba bomba);
	
	public void visit(Velocidad velocidad);
	
	public void visit(PowerPellet powerpellet);
	
	public void visit(PacDot pacdot);
	
	public void visit(Fruta fruta);
	
}
