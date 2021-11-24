package Logica;

import java.awt.Rectangle;
import java.util.ConcurrentModificationException;
import java.util.HashSet;

import Entidades.Entidad;
import Entidades.Estaticas.Bomba;
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
import Hilos.HiloMusica;
import Visitors.Visitor;

public class Juego {

	private int puntaje;
	private VentanaGUI miVentana;
	private Director miDirector;
	private Nivel miNivel;
	private Protagonista miProtagonista;
	private int nivel;
	private Zona [][] matriz;
	private HiloMoverEnemigos hiloEnemigos;
	private Blinky blinky;
	private Clyde clyde;
	private Inky inky;
	private Pinky pinky;
	private HiloMoverProtagonista hiloProtagonista;
	private HiloMusica hiloMusica;
	private Bomba bomba;
	private int stepActual;
	private static final int rangoBomba = 64;

	public Juego(int tema, VentanaGUI ventana) {
		miDirector = new Director(tema, this);
		matriz = new Zona[7][7];

		stepActual = 70;
		miVentana = ventana;
		nivel = 1;
		inicializarNivel1();
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

	public void aumentarPuntaje(int p) {
		puntaje+=p;
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

	public void inicializarNivel1() {
		Builder constructorNivel;
		for(int i = 0; i < 7 ; i++)
			for(int j = 0 ; j < 7 ; j++)
				matriz[i][j] = new Zona();
		constructorNivel = new BuilderNivel();

		miDirector.makeNivel1(constructorNivel);

		miNivel = constructorNivel.getResult();
		miProtagonista = miNivel.getProtagonista();

		blinky = miNivel.getBlinky();
		clyde = miNivel.getClyde();
		pinky = miNivel.getPinky();
		inky = miNivel.getInky();

		miVentana.inicializarNivel(miNivel.getNivel(), miProtagonista, blinky, clyde, pinky, inky);

		agregarAZona();
		hiloEnemigos = new HiloMoverEnemigos(this, stepActual, clyde, inky, blinky, pinky, miProtagonista);
		hiloProtagonista = new HiloMoverProtagonista(30, this, miProtagonista);
		hiloMusica= new HiloMusica();
		puntaje = 0;
		hiloProtagonista.start();
		hiloEnemigos.start();;
	}

	private void inicializarNivel3() {
		Builder constructorNivel;

		hiloEnemigos.detener();
		hiloProtagonista.detener();

		for(int i = 0; i < 7 ; i++)
			for(int j = 0 ; j < 7 ; j++)
				matriz[i][j] = new Zona();
		constructorNivel = new BuilderNivel();

		miDirector.makeNivel3(constructorNivel);

		miNivel = constructorNivel.getResult();
		miProtagonista = miNivel.getProtagonista();
		blinky = miNivel.getBlinky();
		miVentana.limpiar();
		miVentana.inicializarNivel(miNivel.getNivel(), miProtagonista, blinky, clyde, pinky, inky);
		stepActual = 50;
		agregarAZona();
		hiloEnemigos = new HiloMoverEnemigos(this, stepActual, clyde, inky, blinky, pinky, miProtagonista);
		hiloProtagonista = new HiloMoverProtagonista(30, this, miProtagonista);
		hiloProtagonista.start();
		hiloEnemigos.start();
	}

	private void inicializarNivel2() {
		Builder constructorNivel;

		hiloEnemigos.detener();
		hiloProtagonista.detener();

		for(int i = 0; i < 7 ; i++)
			for(int j = 0 ; j < 7 ; j++)
				matriz[i][j] = new Zona();
		constructorNivel = new BuilderNivel();

		miDirector.makeNivel2(constructorNivel);

		miNivel = constructorNivel.getResult();
		miProtagonista = miNivel.getProtagonista();
		blinky = miNivel.getBlinky();

		miVentana.limpiar();
		miVentana.inicializarNivel(miNivel.getNivel(), miProtagonista, blinky, clyde, pinky, inky);
		stepActual = 60;
		agregarAZona();
		hiloEnemigos = new HiloMoverEnemigos(this, stepActual, clyde, inky, blinky, pinky, miProtagonista);
		hiloProtagonista = new HiloMoverProtagonista(30, this, miProtagonista);
		hiloProtagonista.start();
		hiloEnemigos.start();
	}

	public boolean colision(Movil movil, HashSet<Entidad> list, int posXFin, int posYFin) {
		boolean esPared = false;
		Visitor v1;
		Rectangle entidad2;
		HashSet<Entidad> listaSinRep = new HashSet<Entidad>();
		Rectangle entidad = new Rectangle(posXFin, posYFin, movil.getTamano(), movil.getTamano());


		try {
			for(Entidad e: list)
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
		}catch(ConcurrentModificationException exc) {
			
		}

		return esPared;
	}

	public synchronized void moverDerAction() {
		hiloProtagonista.movimiento(2);
	}

	public boolean moverDer(Movil movil) {
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

		if(!esPared)
			movil.moverDerecha();

		return !esPared;
	}

	public synchronized void moverIzqAction() {
		hiloProtagonista.movimiento(3);
	}

	public boolean moverIzq(Movil movil) {
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

		if(!esPared)
			movil.moverIzquierda();

		return !esPared;
	}

	public synchronized void moverAbajoAction() {
		hiloProtagonista.movimiento(0);

	}

	public boolean moverAbajo(Movil movil) {
		boolean esPared=false; 

		Zona zonaActualA;//(0,0)
		Zona zonaActualC;//(0,32)

		Zona zonaFinalA;
		Zona zonaFinalB;
		Zona zonaFinalC;
		Zona zonaFinalD;

		zonaActualA = calcularZona(movil.getX(), movil.getY());
		zonaActualC = calcularZona(movil.getX(), movil.getY() + movil.getTamano());

		zonaFinalA = calcularZona(movil.getX(), movil.getY() + 4);
		zonaFinalB = calcularZona(movil.getX() + movil.getTamano(), movil.getY() + 4);
		zonaFinalC = calcularZona(movil.getX(), movil.getY() + movil.getTamano() + 4);
		zonaFinalD = calcularZona(movil.getX() + movil.getTamano(), movil.getY() + movil.getTamano() + 4);


		esPared=colision(movil, zonaFinalA.getLista(), movil.getX(), movil.getY() + 4);
		if(!esPared && zonaFinalA != zonaFinalB)
			esPared=colision(movil, zonaFinalB.getLista(), movil.getX(), movil.getY() + 4);
		if(!esPared && zonaFinalA != zonaFinalC && zonaFinalB != zonaFinalC)
			esPared=colision(movil, zonaFinalC.getLista(),movil.getX(), movil.getY() + 4);
		if(!esPared && zonaFinalA != zonaFinalD && zonaFinalB != zonaFinalD && zonaFinalC != zonaFinalD)
			esPared=colision(movil, zonaFinalD.getLista(), movil.getX(), movil.getY() + 4);

		if(zonaFinalA != zonaActualA) {
			zonaActualA.removeEntidad(movil);
			zonaFinalA.addEntidad(movil);
		}
		if(zonaFinalC != zonaActualC){
			zonaActualC.removeEntidad(movil);
			zonaFinalC.addEntidad(movil);
		}

		if(!esPared)
			movil.moverAbajo();

		return !esPared;
	}

	public synchronized void moverArribaAction() {
		hiloProtagonista.movimiento(1);
	}

	public boolean moverArriba(Movil movil) {
		boolean esPared=false; 

		Zona zonaActualA;//(0,0)
		Zona zonaActualC;//(0,32)

		Zona zonaFinalA;
		Zona zonaFinalB;
		Zona zonaFinalC;
		Zona zonaFinalD;

		zonaActualA = calcularZona(movil.getX(), movil.getY());
		zonaActualC = calcularZona(movil.getX(), movil.getY() + movil.getTamano());

		zonaFinalA = calcularZona(movil.getX(), movil.getY() - 4);
		zonaFinalB = calcularZona(movil.getX() + movil.getTamano(), movil.getY() - 4);
		zonaFinalC = calcularZona(movil.getX(), movil.getY() + movil.getTamano() - 4);
		zonaFinalD = calcularZona(movil.getX() + movil.getTamano(), movil.getY() + movil.getTamano() - 4);


		esPared=colision(movil, zonaFinalA.getLista(),movil.getX(), movil.getY() - 4);
		if(!esPared && zonaFinalA != zonaFinalB)
			esPared=colision(movil, zonaFinalB.getLista(),  movil.getX(), movil.getY() - 4);
		if(!esPared && zonaFinalA != zonaFinalC && zonaFinalB != zonaFinalC)
			esPared=colision(movil, zonaFinalC.getLista(), movil.getX(), movil.getY() - 4);
		if(!esPared && zonaFinalA != zonaFinalD && zonaFinalB != zonaFinalD && zonaFinalC != zonaFinalD)
			esPared=colision(movil, zonaFinalD.getLista(),  movil.getX(), movil.getY() - 4);

		if(zonaFinalA != zonaActualA) {
			zonaActualA.removeEntidad(movil);
			zonaFinalA.addEntidad(movil);
		}
		if(zonaFinalC != zonaActualC){
			zonaActualC.removeEntidad(movil);
			zonaFinalC.addEntidad(movil);
		}
		if(!esPared)
			movil.moverArriba();
		return !esPared;
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

	public void activarPowerPellet() {
		miProtagonista.setEstadoBomba(false);
		miProtagonista.setEstadoVelocidad(false);
		blinky.setEstadoPowerPellet(true);
		inky.setEstadoPowerPellet(true);
		pinky.setEstadoPowerPellet(true);
		clyde.setEstadoPowerPellet(true);
		miProtagonista.setEstadoPowerPellet(true);
		hiloProtagonista.setPowerPellet();
	}

	public void activarBomba(Bomba bomba) {
		miProtagonista.setEstadoPowerPellet(false);
		miProtagonista.setEstadoVelocidad(false);
		miProtagonista.setEstadoBomba(true);
		this.bomba = bomba;
		hiloProtagonista.setBomba();
	}
	
	public void colocarBomba() {
		if(miProtagonista.getBomba()) {
			bomba.setX(miProtagonista.getX());
			bomba.setY(miProtagonista.getY());
			bomba.setVisible(true);
			miProtagonista.setEstadoBomba(false);
			hiloProtagonista.explosionBomba(bomba);
		}
	}
	
	public void explotarBomba() {
		bomba.explosion();
		if((pinky.getY() < bomba.getY() + rangoBomba && pinky.getY() > bomba.getY() - rangoBomba) && (pinky.getX() > bomba.getX() - rangoBomba && pinky.getX() < bomba.getX() + rangoBomba)) {
			reiniciarEnemigo(pinky);
		}
		if((inky.getY() < bomba.getY() + rangoBomba && inky.getY() > bomba.getY() - rangoBomba) && (inky.getX() > bomba.getX() - rangoBomba && inky.getX() < bomba.getX() + rangoBomba)) {
			reiniciarEnemigo(inky);
		}
		if((blinky.getY() < bomba.getY() + rangoBomba && blinky.getY() > bomba.getY() - rangoBomba) && (blinky.getX() > bomba.getX() - rangoBomba && blinky.getX() < bomba.getX() + rangoBomba)) {
			reiniciarEnemigo(blinky);
		}
		if((clyde.getY() < bomba.getY() + rangoBomba && clyde.getY() > bomba.getY() - rangoBomba) && (clyde.getX() > bomba.getX() - rangoBomba && clyde.getX() < bomba.getX() + rangoBomba)) {
			reiniciarEnemigo(clyde);
		}
		bomba.setVisible(false);
	}

	public void activarVelocidad() {
		miProtagonista.setEstadoPowerPellet(false);
		miProtagonista.setEstadoBomba(false);
		miProtagonista.setEstadoVelocidad(true);
		hiloProtagonista.setVelocidad();
	}

	public void desactivarBomba() {
		miProtagonista.setEstadoBomba(false);
	}

	public void desactivarPowerPellet() {
		miProtagonista.setEstadoPowerPellet(false);
		blinky.setEstadoPowerPellet(false);
		pinky.setEstadoPowerPellet(false);
		inky.setEstadoPowerPellet(false);
		clyde.setEstadoPowerPellet(false);
	}

	public void desactivarVelocidad() {
		miProtagonista.setEstadoVelocidad(false);
		hiloProtagonista.setStep(30);
	}

	public void eliminarProtagonista() {
		miVentana.eliminarVidas(miProtagonista.getVidas());
	}

	public void reiniciarEnemigo(Enemigo enemigo) {
		enemigo.setX(320);
		enemigo.setY(320);
	}

	public void reiniciarProtagonista() {
		miProtagonista.setX(320);
		miProtagonista.setY(544);
		hiloProtagonista.movimiento(3);
	}

	public Enemigo buscarEnemigo() {
		Enemigo enemigoAEliminar = null;
		Rectangle recClyde = new Rectangle(clyde.getX(), clyde.getY(), clyde.getTamano(), clyde.getTamano());
		Rectangle recBlinky = new Rectangle(blinky.getX(), blinky.getY(), blinky.getTamano(), blinky.getTamano());
		Rectangle recInky = new Rectangle(inky.getX(), inky.getY(), inky.getTamano(), inky.getTamano());
		Rectangle recPinky = new Rectangle(pinky.getX(), pinky.getY(), pinky.getTamano(), pinky.getTamano());
		Rectangle recProtagonista = new Rectangle(miProtagonista.getX()-2, miProtagonista.getY()-2, miProtagonista.getTamano()+4, miProtagonista.getTamano()+4);


		if(recClyde.intersects(recProtagonista)) {
			enemigoAEliminar = clyde;
		}
		if(recInky.intersects(recProtagonista)) {
			enemigoAEliminar = inky;
		}

		if(recBlinky.intersects(recProtagonista)) {
			enemigoAEliminar = blinky;
		}

		if(recPinky.intersects(recProtagonista)) {
			enemigoAEliminar = pinky;
		}

		return enemigoAEliminar;
	}

	public void avanzarNivel() {
		switch(nivel) {
		case 1:
			nivel++;
			reiniciarEnemigos();
			inicializarNivel2();
			break;
		case 2:
			nivel++;
			reiniciarEnemigos();
			inicializarNivel3();
			break;
		case 3:
			ganoElJuego();
			break;
		}
	}

	public void perdiElJuego() {
		hiloProtagonista.detener();
		hiloEnemigos.detener();
		hiloMusica.desactivar();
		miVentana.finJuego("Game-Over");
	}
	
	public void cerrarJuego() {
		hiloProtagonista.detener();
		hiloEnemigos.detener();
		hiloMusica.desactivar();
	}
	
	private void ganoElJuego() {
		hiloProtagonista.detener();
		hiloEnemigos.detener();
		hiloMusica.desactivar();
		miVentana.finJuego("Congratulations!");
	}

	public synchronized void setearSonido(boolean b) {
		if(b==true)
			hiloMusica.run();
		else
			hiloMusica.desactivar();
	}

	public void reiniciarEnemigos() {
		blinky.setPos(320, 320);
		inky.setPos(288, 320);
		clyde.setPos(352, 320);
		pinky.setPos(288, 320);

	}

}