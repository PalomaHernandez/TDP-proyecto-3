package Hilos;

import java.applet.AudioClip;


@SuppressWarnings("deprecation")
public class HiloMusica extends Thread{

	private AudioClip sonido;
	
	public HiloMusica() {
	sonido = java.applet.Applet.newAudioClip(getClass().getResource("/Audio/musica.wav"));
	}
	
	public void run(){
		
			try {
				Thread.sleep(10); //ver como sincronizar con los movimientos del protagonista
				sonido.loop();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		
    }
	
	public void desactivar() {
		sonido.stop();
	}
}
