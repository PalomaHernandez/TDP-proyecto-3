package Fabrica;

import Logica.Juego;

public class Director {
	
	private Builder builder;
	private Tema tema;
	private Fabrica miFabrica;
	
	public Director(int tema, Juego juego) {
		miFabrica = new Fabrica(juego);
		if(tema == 1)
			this.tema = miFabrica.getTemaA();
		else
			this.tema = miFabrica.getTemaB();
		
	}
	
	public void makeNivel1(Builder builder) {//El juego envia un builder nivel1, 2 o 3 segun corresponda0
		this.builder = builder;
		builder.reset();
		
		crearParedes1();
		
		builder.setProtagonista(tema, 320, 544);
		crearPowerPellets1();
		/**
		crearEnemigos1();
		crearPacDots1();
		crearBomba1();
		crearFruta1();
		crearVelocidad1();
		**/
		
	}
	
	private void crearVelocidad1() {
		builder.setVelocidad(tema, 320, 384);
	}

	private void crearPowerPellets1() {
		builder.setPowerPellet(tema, 614, 32);
		builder.setPowerPellet(tema, 38, 32);
		
		builder.setPowerPellet(tema, 166, 96);
		builder.setPowerPellet(tema, 486, 96);
		
		builder.setPowerPellet(tema, 38, 160);
		builder.setPowerPellet(tema, 614, 160);
		
		builder.setPowerPellet(tema, 38, 320);
		builder.setPowerPellet(tema, 166, 320);
		builder.setPowerPellet(tema, 486, 320);
		builder.setPowerPellet(tema, 614, 320);
		
		builder.setPowerPellet(tema, 38, 608);
		builder.setPowerPellet(tema, 614, 608);
		
	}

	private void crearFruta1() {
		builder.setFruta(tema, 320, 384);
	}

	private void crearBomba1() {
		builder.setBomba(tema, 320, 384);
	}

	private void crearPacDots1() {
		// TODO Auto-generated method stub
		
	}

	private void crearEnemigos1() {
		builder.setEnemigos(tema, 320, 320);
	}

	private void crearParedes1() {
		
		for(int i = 0 ; i <= 640 ; i += 32) 
			builder.setPared(tema, i, 0);
		
		for(int i = 0 ; i <= 640 ; i += 32) 
			builder.setPared(tema, i, 640);
		
		for(int j = 0 ; j <= 640 ; j += 32)
			builder.setPared(tema, 0, j);
		
		for(int j = 0 ; j <= 640 ; j += 32)
			builder.setPared(tema, 640, j);
		
		builder.setPared(tema, 64, 64);
		builder.setPared(tema, 96, 64);
		builder.setPared(tema, 160, 64);
		builder.setPared(tema, 192, 64);
		builder.setPared(tema, 256, 64);
		builder.setPared(tema, 288, 64);
		builder.setPared(tema, 320, 64);
		builder.setPared(tema, 352, 64);
		builder.setPared(tema, 384, 64);
		builder.setPared(tema, 448, 64);
		builder.setPared(tema, 480, 64);
		builder.setPared(tema, 544, 64);
		builder.setPared(tema, 576, 64);
	
		builder.setPared(tema, 192, 96);
		builder.setPared(tema, 256, 96);
		builder.setPared(tema, 288, 96);
		builder.setPared(tema, 320, 96);
		builder.setPared(tema, 352, 96);
		builder.setPared(tema, 384, 96);
		builder.setPared(tema, 448, 96);
		
		builder.setPared(tema, 64, 128);
		builder.setPared(tema, 96, 128);
		builder.setPared(tema, 128, 128);
		builder.setPared(tema, 192, 128);
		builder.setPared(tema, 256, 128);
		builder.setPared(tema, 288, 128);
		builder.setPared(tema, 320, 128);
		builder.setPared(tema, 352, 128);
		builder.setPared(tema, 384, 128);
		builder.setPared(tema, 448, 128);
		builder.setPared(tema, 512, 128);
		builder.setPared(tema, 544, 128);
		builder.setPared(tema, 576, 128);
		
		builder.setPared(tema, 64, 160);
		builder.setPared(tema, 96, 160);
		builder.setPared(tema, 128, 160);
		builder.setPared(tema, 192, 160);
		builder.setPared(tema, 448, 160);
		builder.setPared(tema, 512, 160);
		builder.setPared(tema, 544, 160);
		builder.setPared(tema, 576, 160);
		
		builder.setPared(tema, 64, 192);
		builder.setPared(tema, 96, 192);
		builder.setPared(tema, 128, 192);
		builder.setPared(tema, 192, 192);
		builder.setPared(tema, 256, 192);
		builder.setPared(tema, 288, 192);
		builder.setPared(tema, 352, 192);
		builder.setPared(tema, 384, 192);
		builder.setPared(tema, 448, 192);
		builder.setPared(tema, 512, 192);
		builder.setPared(tema, 544, 192);
		builder.setPared(tema, 576, 192);
		
		builder.setPared(tema, 64, 224);
		builder.setPared(tema, 96, 224);
		builder.setPared(tema, 128, 224);
		builder.setPared(tema, 192, 224);
		builder.setPared(tema, 256, 224);
		builder.setPared(tema, 288, 224);
		builder.setPared(tema, 352, 224);
		builder.setPared(tema, 384, 224);
		builder.setPared(tema, 448, 224);
		builder.setPared(tema, 512, 224);
		builder.setPared(tema, 544, 224);
		builder.setPared(tema, 576, 224);
		
		builder.setPared(tema, 64, 288);
		builder.setPared(tema, 128, 288);
		builder.setPared(tema, 160, 288);
		builder.setPared(tema, 192, 288);
		builder.setPared(tema, 256, 288);
		builder.setPared(tema, 288, 288);
		builder.setPared(tema, 352, 288);
		builder.setPared(tema, 384, 288);
		builder.setPared(tema, 448, 288);
		builder.setPared(tema, 480, 288);
		builder.setPared(tema, 512, 288);
		builder.setPared(tema, 576, 288);
		
		builder.setPared(tema, 192, 320);
		builder.setPared(tema, 256, 320);
		builder.setPared(tema, 384, 320);
		builder.setPared(tema, 448, 320);
		
		builder.setPared(tema, 64, 352);
		builder.setPared(tema, 128, 352);
		builder.setPared(tema, 192, 352);
		builder.setPared(tema, 256, 352);
		builder.setPared(tema, 288, 352);
		builder.setPared(tema, 320, 352);
		builder.setPared(tema, 352, 352);
		builder.setPared(tema, 384, 352);
		builder.setPared(tema, 448, 352);
		builder.setPared(tema, 512, 352);
		builder.setPared(tema, 576, 352);
		
		builder.setPared(tema, 64, 384);
		builder.setPared(tema, 128, 384);
		builder.setPared(tema, 192, 384);
		builder.setPared(tema, 448, 384);
		builder.setPared(tema, 512, 384);
		builder.setPared(tema, 576, 384);
		
		builder.setPared(tema, 64, 416);
		builder.setPared(tema, 128, 416);
		builder.setPared(tema, 256, 416);
		builder.setPared(tema, 288, 416);
		builder.setPared(tema, 320, 416);
		builder.setPared(tema, 352, 416);
		builder.setPared(tema, 384, 416);
		builder.setPared(tema, 512, 416);
		builder.setPared(tema, 576, 416);
		
		builder.setPared(tema, 192, 448);
		builder.setPared(tema, 448, 448);
		
		builder.setPared(tema, 64, 480);
		builder.setPared(tema, 96, 480);
		builder.setPared(tema, 128, 480);
		builder.setPared(tema, 192, 480);
		builder.setPared(tema, 256, 480);
		builder.setPared(tema, 320, 480);
		builder.setPared(tema, 384, 480);
		builder.setPared(tema, 448, 480);
		builder.setPared(tema, 512, 480);
		builder.setPared(tema, 544, 480);
		builder.setPared(tema, 576, 480);
		
		builder.setPared(tema, 64, 512);
		builder.setPared(tema, 96, 512);
		builder.setPared(tema, 128, 512);
		builder.setPared(tema, 192, 512);
		builder.setPared(tema, 256, 512);
		builder.setPared(tema, 320, 512);
		builder.setPared(tema, 384, 512);
		builder.setPared(tema, 448, 512);
		builder.setPared(tema, 512, 512);
		builder.setPared(tema, 544, 512);
		builder.setPared(tema, 576, 512);
		
		builder.setPared(tema, 64, 576);
		builder.setPared(tema, 96, 576);
		builder.setPared(tema, 128, 576);
		builder.setPared(tema, 160, 576);
		builder.setPared(tema, 192, 576);
		builder.setPared(tema, 256, 576);
		builder.setPared(tema, 288, 576);
		builder.setPared(tema, 320, 576);
		builder.setPared(tema, 352, 576);
		builder.setPared(tema, 384, 576);
		builder.setPared(tema, 448, 576);
		builder.setPared(tema, 480, 576);
		builder.setPared(tema, 512, 576);
		builder.setPared(tema, 544, 576);
		builder.setPared(tema, 576, 576);
		
	}

	public void makeNivel2(Builder builder) {
		this.builder = builder;
		builder.reset();
		
		crearParedes2();
		
		builder.setProtagonista(tema, 320, 480);
		
		crearEnemigos2();
		crearPacDots2();
		crearBomba2();
		crearFruta2();
		crearPowerPellets2();
		crearVelocidad();
		
	}
	
	private void crearVelocidad() {
		// TODO Auto-generated method stub
		
	}

	private void crearPowerPellets2() {
		// TODO Auto-generated method stub
		
	}

	private void crearFruta2() {
		// TODO Auto-generated method stub
		
	}

	private void crearBomba2() {
		// TODO Auto-generated method stub
		
	}

	private void crearPacDots2() {
		// TODO Auto-generated method stub
		
	}

	private void crearEnemigos2() {
		// TODO Auto-generated method stub
		
	}

	private void crearParedes2() {
		for(int i = 0 ; i <= 640 ; i += 32) 
			builder.setPared(tema, i, 0);
		
		for(int i = 0 ; i <= 640 ; i += 32) 
			builder.setPared(tema, i, 640);
		
		for(int j = 0 ; j <= 640 ; j += 32)
			builder.setPared(tema, 0, j);
		
		for(int j = 0 ; j <= 640 ; j += 32)
			builder.setPared(tema, 640, j);
		

		builder.setPared(tema, 160, 32);
		builder.setPared(tema, 480, 32);
		
		builder.setPared(tema, 64, 64);
		builder.setPared(tema, 96, 64);
		builder.setPared(tema, 160, 64);
		builder.setPared(tema, 224, 64);
		builder.setPared(tema, 256, 64);
		builder.setPared(tema, 288, 64);
		builder.setPared(tema, 320, 64);
		builder.setPared(tema, 352, 64);
		builder.setPared(tema, 384, 64);
		builder.setPared(tema, 416, 64);
		builder.setPared(tema, 480, 64);
		builder.setPared(tema, 544, 64);
		builder.setPared(tema, 576, 64);
		
		builder.setPared(tema, 64, 96);
		builder.setPared(tema, 576, 96);
		
		builder.setPared(tema, 64, 128);
		builder.setPared(tema, 128, 128);
		builder.setPared(tema, 160, 128);
		builder.setPared(tema, 224, 128);
		builder.setPared(tema, 256, 128);
		builder.setPared(tema, 288, 128);
		builder.setPared(tema, 320, 128);
		builder.setPared(tema, 352, 128);
		builder.setPared(tema, 384, 128);
		builder.setPared(tema, 416, 128);
		builder.setPared(tema, 480, 128);
		builder.setPared(tema, 512, 128);
		builder.setPared(tema, 576, 128);
		
		builder.setPared(tema, 64, 160);
		builder.setPared(tema, 128, 160);
		builder.setPared(tema, 160, 160);
		builder.setPared(tema, 480, 160);
		builder.setPared(tema, 512, 160);
		builder.setPared(tema, 576, 160);
		
		builder.setPared(tema, 64, 192);
		builder.setPared(tema, 224, 192);
		builder.setPared(tema, 288, 192);
		builder.setPared(tema, 352, 192);
		builder.setPared(tema, 416, 192);
		builder.setPared(tema, 576, 192);
		
		builder.setPared(tema, 128, 224);
		builder.setPared(tema, 160, 224);
		builder.setPared(tema, 480, 224);
		builder.setPared(tema, 512, 224);
		
		builder.setPared(tema, 64, 256);
		builder.setPared(tema, 224, 256);
		builder.setPared(tema, 256, 256);
		builder.setPared(tema, 288, 256);
		builder.setPared(tema, 352, 256);
		builder.setPared(tema, 384, 256);
		builder.setPared(tema, 416, 256);
		builder.setPared(tema, 576, 256);
		
		builder.setPared(tema, 64, 288);
		builder.setPared(tema, 128, 288);
		builder.setPared(tema, 160, 288);
		builder.setPared(tema, 224, 288);
		builder.setPared(tema, 256, 288);
		builder.setPared(tema, 384, 288);
		builder.setPared(tema, 416, 288);
		builder.setPared(tema, 480, 288);
		builder.setPared(tema, 512, 288);
		builder.setPared(tema, 576, 288);
		
		builder.setPared(tema, 64, 320);
		builder.setPared(tema, 160, 320);
		builder.setPared(tema, 224, 320);
		builder.setPared(tema, 256, 320);
		builder.setPared(tema, 288, 320);
		builder.setPared(tema, 320, 320);
		builder.setPared(tema, 352, 320);
		builder.setPared(tema, 384, 320);
		builder.setPared(tema, 416, 320);
		builder.setPared(tema, 480, 320);
		builder.setPared(tema, 576, 320);
		
		builder.setPared(tema, 64, 352);
		builder.setPared(tema, 128, 352);
		builder.setPared(tema, 160, 352);
		builder.setPared(tema, 480, 352);
		builder.setPared(tema, 512, 352);
		builder.setPared(tema, 576, 352);
		
		builder.setPared(tema, 64, 384);
		builder.setPared(tema, 224, 384);
		builder.setPared(tema, 256, 384);
		builder.setPared(tema, 288, 384);
		builder.setPared(tema, 320, 384);
		builder.setPared(tema, 352, 384);
		builder.setPared(tema, 384, 384);
		builder.setPared(tema, 416, 384);
		builder.setPared(tema, 576, 384);
		
		builder.setPared(tema, 64, 416);
		builder.setPared(tema, 128, 416);
		builder.setPared(tema, 160, 416);
		builder.setPared(tema, 224, 416);
		builder.setPared(tema, 416, 416);
		builder.setPared(tema, 480, 416);
		builder.setPared(tema, 512, 416);
		builder.setPared(tema, 576, 416);
		
		builder.setPared(tema, 224, 448);
		builder.setPared(tema, 288, 448);
		builder.setPared(tema, 320, 448);
		builder.setPared(tema, 352, 448);
		builder.setPared(tema, 416, 448);

		builder.setPared(tema, 64, 480);
		builder.setPared(tema, 128, 480);
		builder.setPared(tema, 160, 480);
		builder.setPared(tema, 480, 480);
		builder.setPared(tema, 512, 480);
		builder.setPared(tema, 576, 480);
		
		builder.setPared(tema, 64, 512);
		builder.setPared(tema, 128, 512);
		builder.setPared(tema, 160, 512);
		builder.setPared(tema, 224, 512);
		builder.setPared(tema, 256, 512);
		builder.setPared(tema, 288, 512);
		builder.setPared(tema, 320, 512);
		builder.setPared(tema, 352, 512);
		builder.setPared(tema, 384, 512);
		builder.setPared(tema, 416, 512);
		builder.setPared(tema, 480, 512);
		builder.setPared(tema, 512, 512);
		builder.setPared(tema, 576, 512);
		
		builder.setPared(tema, 64, 544);
		builder.setPared(tema, 576, 544);
		
		builder.setPared(tema, 64, 576);
		builder.setPared(tema, 96, 576);
		builder.setPared(tema, 160, 576);
		builder.setPared(tema, 224, 576);
		builder.setPared(tema, 256, 576);
		builder.setPared(tema, 288, 576);
		builder.setPared(tema, 320, 576);
		builder.setPared(tema, 352, 576);
		builder.setPared(tema, 384, 576);
		builder.setPared(tema, 416, 576);
		builder.setPared(tema, 480, 576);
		builder.setPared(tema, 544, 576);
		builder.setPared(tema, 576, 576);
		
		builder.setPared(tema, 160, 608);
		builder.setPared(tema, 480, 608);
		
		
		
		
		
	}

	public void makeNivel3(Builder builder) {
		this.builder = builder;
		builder.reset();
		
		crearParedes3();
		
		builder.setProtagonista(tema, 320, 480);
		
		crearEnemigos3();
		crearPacDots3();
		crearBomba3();
		crearFruta3();
		crearPowerPellets3();
		crearVelocidad3();
	}

	private void crearVelocidad3() {
		// TODO Auto-generated method stub
		
	}

	private void crearPowerPellets3() {
		// TODO Auto-generated method stub
		
	}

	private void crearFruta3() {
		// TODO Auto-generated method stub
		
	}

	private void crearBomba3() {
		// TODO Auto-generated method stub
		
	}

	private void crearPacDots3() {
		// TODO Auto-generated method stub
		
	}

	private void crearEnemigos3() {
		// TODO Auto-generated method stub
		
	}

	private void crearParedes3() {
		for(int i = 0 ; i <= 640 ; i += 32) 
			builder.setPared(tema, i, 0);
		
		for(int i = 0 ; i <= 640 ; i += 32) 
			builder.setPared(tema, i, 640);
		
		for(int j = 0 ; j <= 640 ; j += 32)
			builder.setPared(tema, 0, j);
		
		for(int j = 0 ; j <= 640 ; j += 32)
			builder.setPared(tema, 640, j);

		builder.setPared(tema, 128, 32);
		builder.setPared(tema, 512, 32);

		builder.setPared(tema, 64, 64);
		builder.setPared(tema, 128, 64);
		builder.setPared(tema, 192, 64);
		builder.setPared(tema, 224, 64);
		builder.setPared(tema, 256, 64);
		builder.setPared(tema, 288, 64);
		builder.setPared(tema, 352, 64);
		builder.setPared(tema, 384, 64);
		builder.setPared(tema, 416, 64);
		builder.setPared(tema, 448, 64);
		builder.setPared(tema, 512, 64);
		builder.setPared(tema, 576, 64);
		
		builder.setPared(tema, 64, 96);
		builder.setPared(tema, 128, 96);
		builder.setPared(tema, 512, 96);
		builder.setPared(tema, 576, 96);
		
		builder.setPared(tema, 64, 128);
		builder.setPared(tema, 128, 128);
		builder.setPared(tema, 192, 128);
		builder.setPared(tema, 256, 128);
		builder.setPared(tema, 288, 128);
		builder.setPared(tema, 320, 128);
		builder.setPared(tema, 352, 128);
		builder.setPared(tema, 384, 128);
		builder.setPared(tema, 448, 128);
		builder.setPared(tema, 512, 128);
		builder.setPared(tema, 576, 128);
		
		builder.setPared(tema, 128, 160);
		builder.setPared(tema, 192, 160);
		builder.setPared(tema, 256, 160);
		builder.setPared(tema, 288, 160);
		builder.setPared(tema, 320, 160);
		builder.setPared(tema, 352, 160);
		builder.setPared(tema, 384, 160);
		builder.setPared(tema, 448, 160);
		builder.setPared(tema, 512, 160);
		
		builder.setPared(tema, 64, 192);
		builder.setPared(tema, 128, 192);
		builder.setPared(tema, 192, 192);
		builder.setPared(tema, 256, 192);
		builder.setPared(tema, 288, 192);
		builder.setPared(tema, 320, 192);
		builder.setPared(tema, 352, 192);
		builder.setPared(tema, 384, 192);
		builder.setPared(tema, 448, 192);
		builder.setPared(tema, 512, 192);
		builder.setPared(tema, 576, 192);
		
		builder.setPared(tema, 64, 224);
		builder.setPared(tema, 192, 224);
		builder.setPared(tema, 256, 224);
		builder.setPared(tema, 288, 224);
		builder.setPared(tema, 320, 224);
		builder.setPared(tema, 352, 224);
		builder.setPared(tema, 384, 224);
		builder.setPared(tema, 448, 224);
		builder.setPared(tema, 576, 224);
		
		builder.setPared(tema, 64, 256);
		builder.setPared(tema, 128, 256);
		builder.setPared(tema, 192, 256);
		builder.setPared(tema, 448, 256);
		builder.setPared(tema, 512, 256);
		builder.setPared(tema, 576, 256);
		
		builder.setPared(tema, 64, 288);
		builder.setPared(tema, 128, 288);
		builder.setPared(tema, 192, 288);
		builder.setPared(tema, 256, 288);
		builder.setPared(tema, 288, 288);
		builder.setPared(tema, 352, 288);
		builder.setPared(tema, 384, 288);
		builder.setPared(tema, 448, 288);
		builder.setPared(tema, 512, 288);
		builder.setPared(tema, 576, 288);
		
		builder.setPared(tema, 128, 320);
		builder.setPared(tema, 192, 320);
		builder.setPared(tema, 256, 320);
		builder.setPared(tema, 384, 320);
		builder.setPared(tema, 448, 320);
		builder.setPared(tema, 512, 320);
		
		builder.setPared(tema, 64, 352);
		builder.setPared(tema, 128, 352);
		builder.setPared(tema, 192, 352);
		builder.setPared(tema, 256, 352);
		builder.setPared(tema, 288, 352);
		builder.setPared(tema, 320, 352);
		builder.setPared(tema, 352, 352);
		builder.setPared(tema, 384, 352);
		builder.setPared(tema, 448, 352);
		builder.setPared(tema, 512, 352);
		builder.setPared(tema, 576, 352);
		
		builder.setPared(tema, 64, 384);
		builder.setPared(tema, 576, 384);
		
		builder.setPared(tema, 64, 416);
		builder.setPared(tema, 128, 416);
		builder.setPared(tema, 192, 416);
		builder.setPared(tema, 224, 416);
		builder.setPared(tema, 288, 416);
		builder.setPared(tema, 320, 416);
		builder.setPared(tema, 352, 416);
		builder.setPared(tema, 416, 416);
		builder.setPared(tema, 448, 416);
		builder.setPared(tema, 512, 416);
		builder.setPared(tema, 576, 416);
		
		builder.setPared(tema, 64, 448);
		builder.setPared(tema, 128, 448);
		builder.setPared(tema, 192, 448);
		builder.setPared(tema, 224, 448);
		builder.setPared(tema, 288, 448);
		builder.setPared(tema, 320, 448);
		builder.setPared(tema, 352, 448);
		builder.setPared(tema, 416, 448);
		builder.setPared(tema, 448, 448);
		builder.setPared(tema, 512, 448);
		builder.setPared(tema, 576, 448);
		
		builder.setPared(tema, 128, 480);
		builder.setPared(tema, 192, 480);
		builder.setPared(tema, 448, 480);
		builder.setPared(tema, 512, 480);
		
		builder.setPared(tema, 64, 512);
		builder.setPared(tema, 96, 512);
		builder.setPared(tema, 128, 512);
		builder.setPared(tema, 192, 512);
		builder.setPared(tema, 256, 512);
		builder.setPared(tema, 288, 512);
		builder.setPared(tema, 320, 512);
		builder.setPared(tema, 352, 512);
		builder.setPared(tema, 384, 512);
		builder.setPared(tema, 448, 512);
		builder.setPared(tema, 512, 512);
		builder.setPared(tema, 544, 512);
		builder.setPared(tema, 576, 512);
		
		builder.setPared(tema, 64, 544);
		builder.setPared(tema, 192, 544);
		builder.setPared(tema, 256, 544);
		builder.setPared(tema, 384, 544);
		builder.setPared(tema, 448, 544);
		builder.setPared(tema, 576, 544);
		
		builder.setPared(tema, 64, 576);
		builder.setPared(tema, 128, 576);
		builder.setPared(tema, 192, 576);
		builder.setPared(tema, 320, 576);
		builder.setPared(tema, 448, 576);
		builder.setPared(tema, 512, 576);
		builder.setPared(tema, 576, 576);
		
		builder.setPared(tema, 128, 608);
		builder.setPared(tema, 256, 608);
		builder.setPared(tema, 384, 608);
		builder.setPared(tema, 512, 608);
		
	}
}
