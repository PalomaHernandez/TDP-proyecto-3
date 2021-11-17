package Hilos;

import java.applet.AudioClip;

import Logica.Juego;

public class HiloMusica extends Thread{

	private Juego miJuego;
	private AudioClip sonido;
	private boolean activo;
	
	public HiloMusica(Juego miJuego) {
	this.miJuego=miJuego;	
	sonido = java.applet.Applet.newAudioClip(getClass().getResource("/Audio/musica.wav"));
	activo=true;
	}
	
	public void run(){
		while(activo) {
			activarSonido();
		}
    }

	public void activarSonido() {
		sonido.play();
	}
}
