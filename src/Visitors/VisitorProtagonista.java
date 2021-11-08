package Visitors;

import Entidades.Estaticas.Bomba;
import Entidades.Estaticas.Fruta;
import Entidades.Estaticas.PacDot;
import Entidades.Estaticas.PowerPellet;
import Entidades.Estaticas.Velocidad;
import Entidades.Moviles.Enemigo;
import Entidades.Moviles.Protagonista;
import Logica.Zona;

public class VisitorProtagonista implements Visitor{

	@Override
	public void visit(Enemigo enemigo) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void visit(Protagonista protagonista) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void visit(Bomba bomba) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void visit(Velocidad velocidad) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void visit(PowerPellet powerpellet) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void visit(PacDot pacdot) {
		pacdot.setCantPuntos(pacdot.getCantPuntos()-1);
		Zona z=pacdot.getZona();
		//z.removeEntidad(pacdot);
		//pacdot.setVisible(false);
	}

	@Override
	public void visit(Fruta fruta) {
		// TODO Auto-generated method stub
		
	}

//	@Override
//	public void visitFantasma(Enemigo fantasma) {
//		// TODO Auto-generated method stub
//		
//	}
//
//	@Override
//	public void visitProtagonista(Protagonista protagonista) {
//		// TODO Auto-generated method stub
//		
//	}

}
