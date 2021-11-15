package Logica;

import java.awt.Rectangle;
import java.util.HashSet;
import java.util.List;

import Entidades.Entidad;
import Entidades.Moviles.Blinky;
import Entidades.Moviles.Clyde;
import Entidades.Moviles.Enemigo;
import Entidades.Moviles.Inky;
import Entidades.Moviles.Movil;
import Entidades.Moviles.Pinky;
import Entidades.Moviles.Protagonista;
import Fabrica.Builder;
import Fabrica.BuilderNivel;
import Fabrica.Director;
import GUI.VentanaGUI;
import Hilos.HiloMoverEnemigos;
import Hilos.HiloMoverProtagonista;
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
	private Clyde clyde;
	private Inky inky;
	private Pinky pinky;
	private HiloMoverProtagonista hiloProtagonista;
	
	public Juego(int tema, VentanaGUI ventana) {
		miDirector = new Director(tema, this);
		matriz = new Zona[7][7];
		for(int i = 0; i < 7 ; i++)
			for(int j = 0 ; j < 7 ; j++)
				matriz[i][j] = new Zona();
		miVentana = ventana;
		
		inicializarNivel1();
		agregarAZona();
		hiloEnemigos = new HiloMoverEnemigos(this, 70, null, null, blinky, null, miProtagonista);
		hiloProtagonista = new HiloMoverProtagonista(30, this, miProtagonista);
		hiloProtagonista.start();
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

	public boolean colision(Movil movil, HashSet<Entidad> list, int posXFin, int posYFin) {
		boolean esPared = false;
		Visitor v1;
		Rectangle entidad2;
		HashSet<Entidad> listaSinRep = new HashSet<Entidad>();
		Rectangle entidad = new Rectangle(posXFin, posYFin, movil.getTamano(), movil.getTamano());
		
		for(Entidad e: list)//Arreglar esto
			listaSinRep.add(e);
		
		for(Entidad e : listaSinRep) {
			entidad2 = new Rectangle(e.getX(), e.getY(), e.getTamano(), e.getTamano());
			if(entidad.intersects(entidad2)) {
				v1= movil.getVisitor();
				esPared = e.accept(v1, this);
				if(esPared)
					break;
			}
		}
		
		return esPared;
	}
	
	public synchronized boolean moverDerAction() {
		boolean esPared;
		
		esPared = moverDer(miProtagonista);
		if(!esPared) {
			miProtagonista.moverDerecha();
			hiloProtagonista.movimiento(2);
		}
		return !esPared;
	}
	
	private boolean moverDer(Movil movil) {
		boolean esPared = false;
		
		Zona zonaActualA;//(0,0)
		Zona zonaActualB;//(32,0)
		
		Zona zonaFinalA;
		Zona zonaFinalB;
		Zona zonaFinalC;
		Zona zonaFinalD;
	
		zonaActualA = calcularZona(movil.getX(), movil.getY());
		zonaActualB = calcularZona(movil.getX() + movil.getTamano(), movil.getY());
		
		zonaFinalA = calcularZona(movil.getX() + 4, movil.getY());
		zonaFinalB = calcularZona(movil.getX() + movil.getTamano() + 4, movil.getY());
		zonaFinalC = calcularZona(movil.getX() + 4, movil.getY() + movil.getTamano());
		zonaFinalD = calcularZona(movil.getX() + movil.getTamano() + 4, movil.getY() + movil.getTamano());
			
		
		esPared = colision(movil, zonaFinalA.getLista(), movil.getX() + 4, movil.getY());
		if(!esPared && zonaFinalA != zonaFinalB)
			esPared = colision(movil, zonaFinalB.getLista(), movil.getX() + 4, movil.getY());
		if(!esPared && zonaFinalA != zonaFinalC && zonaFinalB != zonaFinalC)
			esPared = colision(movil, zonaFinalC.getLista(), movil.getX() + 4, movil.getY());
		if(!esPared && zonaFinalA != zonaFinalD && zonaFinalB != zonaFinalD && zonaFinalC != zonaFinalD)
			esPared = colision(movil, zonaFinalD.getLista(), movil.getX() + 4, movil.getY());
		
		if(zonaFinalA != zonaActualA) {
			zonaActualA.removeEntidad(movil);
			zonaFinalA.addEntidad(movil);
		}
		if(zonaFinalB != zonaActualB) {
			zonaActualB.removeEntidad(movil);
			zonaFinalB.addEntidad(movil);
		}
		return esPared;
	}

	public synchronized boolean moverIzqAction() {
		boolean esPared;
		
		esPared = moverIzq(miProtagonista);
		if(!esPared) {
			miProtagonista.moverIzquierda();
			hiloProtagonista.movimiento(3);
		}
		return !esPared;
	}
	
	private boolean moverIzq(Movil movil) {
		boolean esPared=false;
		
		
		Zona zonaActualA;//(0,0)
		Zona zonaActualB;//(32,0)
		
		Zona zonaFinalA;
		Zona zonaFinalB;
		Zona zonaFinalC;
		Zona zonaFinalD;
		
		zonaActualA = calcularZona(movil.getX(), movil.getY());
		zonaActualB = calcularZona(movil.getX() + movil.getTamano(), movil.getY());
		
		zonaFinalA = calcularZona(movil.getX() - 4, movil.getY());
		zonaFinalB = calcularZona(movil.getX() + movil.getTamano() - 4, movil.getY());
		zonaFinalC = calcularZona(movil.getX() - 4, movil.getY() + movil.getTamano());
		zonaFinalD = calcularZona(movil.getX() + movil.getTamano() - 4, movil.getY() + movil.getTamano());
		
		
		esPared=colision(movil, zonaFinalA.getLista(),movil.getX() - 4, movil.getY());
		if(!esPared && zonaFinalA != zonaFinalB)
			esPared=colision(movil, zonaFinalB.getLista(),movil.getX() - 4, movil.getY());
		if(!esPared && zonaFinalA != zonaFinalC && zonaFinalB != zonaFinalC)
			esPared=colision(movil, zonaFinalC.getLista(),movil.getX() - 4, movil.getY());
		if(!esPared && zonaFinalA != zonaFinalD && zonaFinalB != zonaFinalD && zonaFinalC != zonaFinalD)
			esPared=colision(movil, zonaFinalD.getLista(),movil.getX() - 4, movil.getY());
		
		if(zonaFinalA != zonaActualA) {
			zonaActualA.removeEntidad(movil);
			zonaFinalA.addEntidad(movil);
		}
		if(zonaFinalB != zonaActualB) {
			zonaActualB.removeEntidad(movil);
			zonaFinalB.addEntidad(movil);
		}
		return esPared;
	}

	public synchronized boolean moverAbajoAction() {
		boolean esPared;
		
		esPared = moverAbajo(miProtagonista);
		if(!esPared) {
			miProtagonista.moverAbajo();
			hiloProtagonista.movimiento(0);
		}
		return !esPared;
	}
	
	private boolean moverAbajo(Movil movil) {
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

		
		esPared=colision(movil, zonaFinalA.getLista(), miProtagonista.getX(), miProtagonista.getY() + 4);
		if(!esPared && zonaFinalA != zonaFinalB)
			esPared=colision(movil, zonaFinalB.getLista(), miProtagonista.getX(), miProtagonista.getY() + 4);
		if(!esPared && zonaFinalA != zonaFinalC && zonaFinalB != zonaFinalC)
			esPared=colision(movil, zonaFinalC.getLista(),miProtagonista.getX(), miProtagonista.getY() + 4);
		if(!esPared && zonaFinalA != zonaFinalD && zonaFinalB != zonaFinalD && zonaFinalC != zonaFinalD)
			esPared=colision(movil, zonaFinalD.getLista(), miProtagonista.getX(), miProtagonista.getY() + 4);
		
		if(zonaFinalA != zonaActualA) {
			zonaActualA.removeEntidad(miProtagonista);
			zonaFinalA.addEntidad(miProtagonista);
		}
		if(zonaFinalC != zonaActualC){
			zonaActualC.removeEntidad(miProtagonista);
			zonaFinalC.addEntidad(miProtagonista);
		}
		
		return esPared;
	}

	public synchronized boolean moverArribaAction() {
		boolean esPared;
		
		esPared = moverArriba(miProtagonista);
		
		if(!esPared) {
			miProtagonista.moverArriba();
			hiloProtagonista.movimiento(1);
		}
		return !esPared;
	}
	
	private boolean moverArriba(Movil movil) {
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
		
		
			esPared=colision(movil, zonaFinalA.getLista(),miProtagonista.getX(), miProtagonista.getY() - 4);
		if(!esPared && zonaFinalA != zonaFinalB)
			esPared=colision(movil, zonaFinalB.getLista(),  miProtagonista.getX(), miProtagonista.getY() - 4);
		if(!esPared && zonaFinalA != zonaFinalC && zonaFinalB != zonaFinalC)
			esPared=colision(movil, zonaFinalC.getLista(), miProtagonista.getX(), miProtagonista.getY() - 4);
		if(!esPared && zonaFinalA != zonaFinalD && zonaFinalB != zonaFinalD && zonaFinalC != zonaFinalD)
			esPared=colision(movil, zonaFinalD.getLista(),  miProtagonista.getX(), miProtagonista.getY() - 4);
		
		if(zonaFinalA != zonaActualA) {
			zonaActualA.removeEntidad(miProtagonista);
			zonaFinalA.addEntidad(miProtagonista);
		}
		if(zonaFinalC != zonaActualC){
			zonaActualC.removeEntidad(miProtagonista);
			zonaFinalC.addEntidad(miProtagonista);
		}
		return esPared;
	}

	public Zona calcularZona(int cordX, int cordY) {
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
		else if(cordX < 672)
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
		else if(cordY < 672)
			j = 6;
		
		return matriz[i][j];
	}

	public boolean moverIzqEnem(Enemigo enemigo) {
		boolean esPared;
		
		esPared = moverIzq(enemigo);
		if(!esPared)
			enemigo.moverIzquierda();
		
		return !esPared;
	}

	public boolean moverAbajoEnem(Enemigo enemigo) {
		boolean esPared;
		
		esPared = moverAbajo(enemigo);
		if(!esPared)
			enemigo.moverAbajo();
		
		return !esPared;
	}

	public boolean moverArribaEnem(Enemigo enemigo) {
		boolean esPared;
		
		esPared = moverArriba(enemigo);
		if(!esPared)
			enemigo.moverArriba();
		
		return !esPared;
	}

	public boolean moverDerEnem(Enemigo enemigo) {
		boolean esPared;
		
		esPared = moverDer(enemigo);
		if(!esPared)
			enemigo.moverDerecha();
		
		return !esPared;
	}

	public void activarPowerPellet() {
		blinky.setEstado(4); //es responsabilidad del enemigo cambiar sus imagenes
		//pinky.setEstado(2);
		//inky.setEstado(2);
		//clyde.setEstado(2);
		miProtagonista.setEstadoPowerPellet(true);
		//blinky.setEstadoPowerPellet(true);
		hiloProtagonista.setPowerPellet();
		//hiloEnemigos.setPowerPellet();
	}
	
	public void activarBomba() {
		miProtagonista.setEstadoBomba(true);
		hiloProtagonista.setBomba();
	}

	public void activarVelocidad() {
		miProtagonista.setEstadoVelocidad(true);
		hiloProtagonista.setVelocidad();
	}

	public void desactivarBomba() {
		miProtagonista.setEstadoBomba(false);
	}

	public void desactivarPowerPellet() {
		miProtagonista.setEstadoPowerPellet(false);
		blinky.setEstado(1);
		//pinky.setEstado(0);
		//inky.setEstado(0);
		//clyde.setEstado(0);
	}

	public void desactivarVelocidad() {
		miProtagonista.setEstadoVelocidad(false);
		hiloProtagonista.setStep(30);
	}

	public void eliminarProtagonista() {
		miVentana.eliminarVidas(miProtagonista.getVidas());
		
	}

	public void finalizarJuego() {
		miVentana.cerrarJuego();
		hiloProtagonista.detener();
		hiloEnemigos.detener();
		
	}

	public void reiniciarEnemigos(Enemigo enemigo) {
		enemigo.setX(320);
		enemigo.setY(320);
	}
	

	public void reiniciarProtagonista() {
		miProtagonista.setX(320);
		miProtagonista.setY(544);
		//ver como acomodar la rotacion del protagonista
		}
	
}
