package Fabrica;

import Logica.Nivel;

public class BuilderNivel implements Builder{

	private Nivel miNivel;
	
	public BuilderNivel() {
		miNivel = new Nivel();
	}
	
	@Override
	public void reset() {
		miNivel.limpiar();
	}

	@Override
	public void setPared(Tema tema,int x, int y) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setProtagonista(Tema tema,int x, int y) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setEnemigos(Tema tema, int x, int y) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setFruta(Tema tema, int x, int y) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setPowerPellet(Tema tema, int x, int y) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setPacDot(Tema tema, int x, int y) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setBomba(Tema tema,int x, int y) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setVelocidad(Tema tema,int x, int y) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Nivel getResult() {
		// TODO Auto-generated method stub
		return null;
	}

}
