package Logica;

import Entidades.Entidad;

public class Grilla {

	private Zona matriz[][];
	
	public Grilla() {
		
		matriz = new Zona[7][7];
		
		for(int i = 0; i < 7 ; i++)
			for(int j = 0 ; j < 7 ; j++)
				matriz[i][j] = new Zona();
	}
	
	public void ocupar(int tamanoX, int tamanoY, Entidad e) {
		Zona zona = calcularZona(e.getX(), e.getY());
		
		if(existePosLibre(zona, e.getX(), e.getY(), tamanoX, tamanoY))
			zona.addEntidad(e.getX(), e.getY(), tamanoX, tamanoY);
	}
	
	private Zona calcularZona(int cordX, int cordY) { //La zona se calcula con las coordenadas x e y, con el punto (0,0) de la entidad
		int i;
		int j;
		
		i = 0;
		j = 0;
		
		if(cordX < 96) 
			i = 0;
		else if(cordX < 192)
			i = 1;
		else if(cordX < 288)
			i = 2;
		else if(cordX < 384)
			i = 3;
		else if(cordX < 480)
			i = 4;
		else if(cordX < 576)
			i = 5;
		else if(cordX < 678)
			i = 6;
		
		if(cordY < 96) 
			j = 0;
		else if(cordY < 192)
			j = 1;
		else if(cordY < 288)
			j = 2;
		else if(cordY < 384)
			j = 3;
		else if(cordY < 480)
			j = 4;
		else if(cordY < 576)
			j = 5;
		else if(cordY < 678)
			j = 6;
		
		return matriz[i][j];
	}

	public void desocupar(Entidad e) {
		Zona zona = calcularZona(e.getX(), e.getY());
		
		zona.removeEntidad(e);
		
	}
	
	public boolean existePosLibre(Zona zona, int cordX, int cordY, int tamanoX, int tamanoY) {
		return zona.existePosLibre(cordX, cordY, tamanoX, tamanoY);
	}
	
}
