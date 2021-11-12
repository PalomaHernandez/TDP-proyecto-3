package Logica;

import java.awt.Rectangle;
import java.util.HashSet;
import java.util.List;

import Entidades.Entidad;
import Entidades.Moviles.Blinky;
import Entidades.Moviles.Enemigo;
import Entidades.Moviles.Movil;
import Entidades.Moviles.Protagonista;
import Fabrica.Builder;
import Fabrica.BuilderNivel;
import Fabrica.Director;
import GUI.VentanaGUI;
import Hilos.HiloMoverEnemigos;
import Visitors.Visitor;

public class Juego {

	private int puntaje;
	private VentanaGUI miVentana;
	private Director miDirector;
	private Nivel miNivel;
	private Protagonista miProtagonista;
	private Zona [][] matriz;
	private HiloMoverEnemigos hiloEnemigos;
	private Blinky blinky;
	
	public Juego(int tema, VentanaGUI ventana) {
		miDirector = new Director(tema, this);
		//hiloMover = new HiloMover(10);
		matriz = new Zona[7][7];
		for(int i = 0; i < 7 ; i++)
			for(int j = 0 ; j < 7 ; j++)
				matriz[i][j] = new Zona();
		miVentana = ventana;
		
		inicializarNivel1();
		agregarAZona();
		hiloEnemigos = new HiloMoverEnemigos(this, 70, null, null, blinky, null, miProtagonista);
		hiloEnemigos.start();
	}
	
	public Nivel getNivel() {
		return miNivel;
	}
	
	public Protagonista getProtagonista() {
		return miProtagonista;
	}
	
	public int getPuntaje() {
		return puntaje;
	}
	
	public void setPuntaje(int p) {
		puntaje=p;
		miVentana.actualizarPuntaje(puntaje);
	}
	
	private void agregarAZona() {
		Zona zona1;
		Zona zona2;
		Zona zona3;
		Zona zona4;
		zona1 = calcularZona(miProtagonista.getX(), miProtagonista.getY());
		zona2 = calcularZona(miProtagonista.getX() + miProtagonista.getTamano(), miProtagonista.getY());
		zona3 = calcularZona(miProtagonista.getX(), miProtagonista.getY() + miProtagonista.getTamano());
		zona4 = calcularZona(miProtagonista.getX() + miProtagonista.getTamano(), miProtagonista.getY() + miProtagonista.getTamano());
		
		zona1.addEntidad(miProtagonista);
		if(zona1 != zona2)
			zona2.addEntidad(miProtagonista);
		if(zona1 != zona3 && zona2 != zona3)
			zona3.addEntidad(miProtagonista);
		if(zona1 != zona4 && zona2 != zona4 && zona3 != zona4)
			zona4.addEntidad(miProtagonista);
		
		for(Entidad e : miNivel.getNivel()) {
			zona1 = calcularZona(e.getX(), e.getY());
			
			zona1.addEntidad(e);
		}
	}

	private void inicializarNivel1() {
		Builder constructorNivel1;
		
		constructorNivel1 = new BuilderNivel();
		
		miDirector.makeNivel1(constructorNivel1);
		
		miNivel = constructorNivel1.getResult();
		miProtagonista = miNivel.getProtagonista();
		blinky = miNivel.getBlinky();
		miVentana.inicializarNivel1(miNivel.getNivel(), miProtagonista, blinky);
	}

	public boolean colisionProtagonista(Protagonista p, List<Entidad> list, int posXFin, int posYFin) {
		//boolean libre = true;
		boolean esPared = false;
		
		HashSet<Entidad> listaSinRep = new HashSet<Entidad>();
		Rectangle entidad = new Rectangle(posXFin, posYFin, miProtagonista.getTamano(), miProtagonista.getTamano());
		
		for(Entidad e: list)
			listaSinRep.add(e);
		
		for(Entidad e : listaSinRep) {
			Rectangle entidad2 = new Rectangle(e.getX(), e.getY(), e.getTamano(), e.getTamano());
			if(entidad.intersects(entidad2)) {
				//System.out.println("Colision.");
				Visitor v1= miProtagonista.getVisitor();
				esPared = e.accept(v1, this);
				if(esPared)
					break;
			}
		}
		
		return esPared;
	}
	
	/*
	public boolean colisionProtagonista(Protagonista p, List<Entidad> list) {
		//boolean libre = true;
		int cordX=miProtagonista.getX();
		int cordY=miProtagonista.getY();
		int tamanoX=miProtagonista.getTamano();
		int tamanoY=miProtagonista.getTamano();
		boolean esPared = false;
		
		Rectangle entidad = new Rectangle(cordX, cordY, tamanoX, tamanoY);
		for(Entidad e : list) {
			Rectangle entidad2 = new Rectangle(e.getX(), e.getY(), e.getTamano(), e.getTamano());
			if(entidad.intersects(entidad2)) {
				//System.out.println("Colision.");
				Visitor v1= miProtagonista.getVisitor();
				esPared = e.esPared();
				e.accept(v1, this);
				if(esPared)
					break;
			}
		}
		
		return esPared;
	}
	*/
	public void moverDerAction() {
		boolean esPared = false;
		
		Zona zonaActualA;//(0,0)
		Zona zonaActualB;//(32,0)
		
		Zona zonaFinalA;
		Zona zonaFinalB;
		Zona zonaFinalC;
		Zona zonaFinalD;
	
		zonaActualA = calcularZona(miProtagonista.getX(), miProtagonista.getY());
		zonaActualB = calcularZona(miProtagonista.getX() + miProtagonista.getTamano(), miProtagonista.getY());
		
		zonaFinalA = calcularZona(miProtagonista.getX() + 4, miProtagonista.getY());
		zonaFinalB = calcularZona(miProtagonista.getX() + miProtagonista.getTamano() + 4, miProtagonista.getY());
		zonaFinalC = calcularZona(miProtagonista.getX() + 4, miProtagonista.getY() + miProtagonista.getTamano());
		zonaFinalD = calcularZona(miProtagonista.getX() + miProtagonista.getTamano() + 4, miProtagonista.getY() + miProtagonista.getTamano());
			
		
			esPared = colisionProtagonista(miProtagonista, zonaFinalA.getLista(), miProtagonista.getX() + 4, miProtagonista.getY());
		if(!esPared && zonaFinalA != zonaFinalB)
			esPared = colisionProtagonista(miProtagonista, zonaFinalB.getLista(), miProtagonista.getX() + 4, miProtagonista.getY());
		if(!esPared && zonaFinalA != zonaFinalC && zonaFinalB != zonaFinalC)
			esPared = colisionProtagonista(miProtagonista, zonaFinalC.getLista(), miProtagonista.getX() + 4, miProtagonista.getY());
		if(!esPared && zonaFinalA != zonaFinalD && zonaFinalB != zonaFinalD && zonaFinalC != zonaFinalD)
			esPared = colisionProtagonista(miProtagonista, zonaFinalD.getLista(), miProtagonista.getX() + 4, miProtagonista.getY());
		
		if(zonaFinalA != zonaActualA) {
			zonaActualA.removeEntidad(miProtagonista);
			zonaFinalA.addEntidad(miProtagonista);
		}
		if(zonaFinalB != zonaActualB) {
			zonaActualB.removeEntidad(miProtagonista);
			zonaFinalB.addEntidad(miProtagonista);
		}
		if(!esPared)
			miProtagonista.moverDerecha();
	}

	public void moverIzqAction() {
		boolean esPared=false;
		
		
		Zona zonaActualA;//(0,0)
		Zona zonaActualB;//(32,0)
		
		Zona zonaFinalA;
		Zona zonaFinalB;
		Zona zonaFinalC;
		Zona zonaFinalD;
		
		zonaActualA = calcularZona(miProtagonista.getX(), miProtagonista.getY());
		zonaActualB = calcularZona(miProtagonista.getX() + miProtagonista.getTamano(), miProtagonista.getY());
		
		zonaFinalA = calcularZona(miProtagonista.getX() - 4, miProtagonista.getY());
		zonaFinalB = calcularZona(miProtagonista.getX() + miProtagonista.getTamano() - 4, miProtagonista.getY());
		zonaFinalC = calcularZona(miProtagonista.getX() - 4, miProtagonista.getY() + miProtagonista.getTamano());
		zonaFinalD = calcularZona(miProtagonista.getX() + miProtagonista.getTamano() - 4, miProtagonista.getY() + miProtagonista.getTamano());
		
		
			esPared=colisionProtagonista(miProtagonista, zonaFinalA.getLista(),miProtagonista.getX() - 4, miProtagonista.getY());
		if(zonaFinalA != zonaFinalB)
			esPared=colisionProtagonista(miProtagonista, zonaFinalB.getLista(),miProtagonista.getX() - 4, miProtagonista.getY());
		if(zonaFinalA != zonaFinalC && zonaFinalB != zonaFinalC)
			esPared=colisionProtagonista(miProtagonista, zonaFinalC.getLista(),miProtagonista.getX() - 4, miProtagonista.getY());
		if(zonaFinalA != zonaFinalD && zonaFinalB != zonaFinalD && zonaFinalC != zonaFinalD)
			esPared=colisionProtagonista(miProtagonista, zonaFinalD.getLista(),miProtagonista.getX() - 4, miProtagonista.getY());
		
		if(zonaFinalA != zonaActualA) {
			zonaActualA.removeEntidad(miProtagonista);
			zonaFinalA.addEntidad(miProtagonista);
		}
		if(zonaFinalB != zonaActualB) {
			zonaActualB.removeEntidad(miProtagonista);
			zonaFinalB.addEntidad(miProtagonista);
		}
		if(!esPared)
			miProtagonista.moverIzquierda();
	}

	public void moverAbajoAction() {
		boolean esPared=false; 
		
		Zona zonaActualA;//(0,0)
		Zona zonaActualC;//(0,32)
		
		Zona zonaFinalA;
		Zona zonaFinalB;
		Zona zonaFinalC;
		Zona zonaFinalD;
		
		zonaActualA = calcularZona(miProtagonista.getX(), miProtagonista.getY());
		zonaActualC = calcularZona(miProtagonista.getX(), miProtagonista.getY() + miProtagonista.getTamano());
		
		zonaFinalA = calcularZona(miProtagonista.getX(), miProtagonista.getY() + 4);
		zonaFinalB = calcularZona(miProtagonista.getX() + miProtagonista.getTamano(), miProtagonista.getY() + 4);
		zonaFinalC = calcularZona(miProtagonista.getX(), miProtagonista.getY() + miProtagonista.getTamano() + 4);
		zonaFinalD = calcularZona(miProtagonista.getX() + miProtagonista.getTamano(), miProtagonista.getY() + miProtagonista.getTamano() + 4);

		
			esPared=colisionProtagonista(miProtagonista, zonaFinalA.getLista(), miProtagonista.getX(), miProtagonista.getY() + 4);
		if(zonaFinalA != zonaFinalB)
			esPared=colisionProtagonista(miProtagonista, zonaFinalB.getLista(), miProtagonista.getX(), miProtagonista.getY() + 4);
		if(zonaFinalA != zonaFinalC && zonaFinalB != zonaFinalC)
			esPared=colisionProtagonista(miProtagonista, zonaFinalC.getLista(),miProtagonista.getX(), miProtagonista.getY() + 4);
		if(zonaFinalA != zonaFinalD && zonaFinalB != zonaFinalD && zonaFinalC != zonaFinalD)
			esPared=colisionProtagonista(miProtagonista, zonaFinalD.getLista(), miProtagonista.getX(), miProtagonista.getY() + 4);
		
		if(zonaFinalA != zonaActualA) {
			zonaActualA.removeEntidad(miProtagonista);
			zonaFinalA.addEntidad(miProtagonista);
		}
		if(zonaFinalC != zonaActualC){
			zonaActualC.removeEntidad(miProtagonista);
			zonaFinalC.addEntidad(miProtagonista);
		}
		
		if(!esPared)
			miProtagonista.moverAbajo();
	}

	public void moverArribaAction() {
		boolean esPared=false; 
		
		Zona zonaActualA;//(0,0)
		Zona zonaActualC;//(0,32)
		
		Zona zonaFinalA;
		Zona zonaFinalB;
		Zona zonaFinalC;
		Zona zonaFinalD;
		
		zonaActualA = calcularZona(miProtagonista.getX(), miProtagonista.getY());
		zonaActualC = calcularZona(miProtagonista.getX(), miProtagonista.getY() + miProtagonista.getTamano());
		
		zonaFinalA = calcularZona(miProtagonista.getX(), miProtagonista.getY() - 4);
		zonaFinalB = calcularZona(miProtagonista.getX() + miProtagonista.getTamano(), miProtagonista.getY() - 4);
		zonaFinalC = calcularZona(miProtagonista.getX(), miProtagonista.getY() + miProtagonista.getTamano() - 4);
		zonaFinalD = calcularZona(miProtagonista.getX() + miProtagonista.getTamano(), miProtagonista.getY() + miProtagonista.getTamano() - 4);
		
		
			esPared=colisionProtagonista(miProtagonista, zonaFinalA.getLista(),miProtagonista.getX(), miProtagonista.getY() - 4);
		if(zonaFinalA != zonaFinalB)
			esPared=colisionProtagonista(miProtagonista, zonaFinalB.getLista(),  miProtagonista.getX(), miProtagonista.getY() - 4);
		if(zonaFinalA != zonaFinalC && zonaFinalB != zonaFinalC)
			esPared=colisionProtagonista(miProtagonista, zonaFinalC.getLista(), miProtagonista.getX(), miProtagonista.getY() - 4);
		if(zonaFinalA != zonaFinalD && zonaFinalB != zonaFinalD && zonaFinalC != zonaFinalD)
			esPared=colisionProtagonista(miProtagonista, zonaFinalD.getLista(),  miProtagonista.getX(), miProtagonista.getY() - 4);
		
		if(zonaFinalA != zonaActualA) {
			zonaActualA.removeEntidad(miProtagonista);
			zonaFinalA.addEntidad(miProtagonista);
		}
		if(zonaFinalC != zonaActualC){
			zonaActualC.removeEntidad(miProtagonista);
			zonaFinalC.addEntidad(miProtagonista);
		}
		if(!esPared)
			miProtagonista.moverArriba();
	}

	public Zona calcularZona(int cordX, int cordY) { //La zona se calcula con las coordenadas x e y, con el punto (0,0) de la entidad
		int i;
		int j;
		
		i = 0;
		j = 0;
		
		if(cordX <= 96) 
			i = 0;
		else if(cordX <= 192)
			i = 1;
		else if(cordX <= 288)
			i = 2;
		else if(cordX <= 384)
			i = 3;
		else if(cordX <= 480)
			i = 4;
		else if(cordX <= 576)
			i = 5;
		else if(cordX <= 678)
			i = 6;
		
		if(cordY <= 96) 
			j = 0;
		else if(cordY <= 192)
			j = 1;
		else if(cordY <= 288)
			j = 2;
		else if(cordY <= 384)
			j = 3;
		else if(cordY <= 480)
			j = 4;
		else if(cordY <= 576)
			j = 5;
		else if(cordY <= 678)
			j = 6;
		
		return matriz[i][j];
	}

	public boolean moverIzqEnem(Enemigo enemigo) {
		enemigo.moverIzquierda();
		return true;
	}

	public boolean moverAbajoEnem(Enemigo enemigo) {
		enemigo.moverAbajo();
		return true;
	}

	public boolean moverArribaEnem(Enemigo enemigo) {
		enemigo.moverArriba();
		return true;
	}

	public boolean moverDerEnem(Enemigo enemigo) {
		enemigo.moverDerecha();
		return true;
	}

	public void ponerAzul() {
		blinky.cambiarImagen(4);
		miProtagonista.cambiarImagen(4);
	}


}
