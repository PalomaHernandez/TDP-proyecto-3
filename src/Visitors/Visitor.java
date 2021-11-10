package Visitors;

import Entidades.Estaticas.*;
import Entidades.Moviles.Enemigo;
import Entidades.Moviles.Protagonista;
import Logica.Juego;
import Logica.Nivel;
import Logica.Zona;

public interface Visitor {

//	public void visitFantasma(Enemigo fantasma);
//	
//	public void visitProtagonista(Protagonista protagonista);
	
	public void visit(Pared pared);
	
	public void visit(Enemigo enemigo, Juego j);
	
	public void visit(Protagonista protagonista);
	
	public void visit(Bomba bomba, Juego j);
	
	public void visit(Velocidad velocidad, Juego j);
	
	public void visit(PowerPellet powerpellet, Juego j);
	
	public void visit(PacDot pacdot, Juego j);
	
	public void visit(Fruta fruta, Juego j);
	
}
