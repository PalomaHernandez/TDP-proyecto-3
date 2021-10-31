package Fabrica;

import Logica.Nivel;

public interface Builder {

	public void reset();
	public void setPared(Tema tema,int x, int y);
	public void setProtagonista(Tema tema,int x, int y);
	public void setEnemigos(Tema tema,int x, int y);
	public void setFruta(Tema tema, int x, int y);
	public void setPowerPellet(Tema tema, int x, int y);
	public void setPacDot(Tema tema, int x, int y);
	public void setBomba(Tema tema, int x, int y);
	public void setVelocidad(Tema tema,int x, int y);
	public Nivel getResult();
}
