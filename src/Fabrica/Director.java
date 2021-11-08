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
		
		
		builder.setProtagonista(tema, 320, 544);
		crearPowerPellets1();
		crearBomba1();
		crearFruta1();
		crearVelocidad1();
		crearPacDots1();
		crearParedes1();
		
		/*crearEnemigos1();
		*/
		
		
	}
	
	private void crearVelocidad1() {
		builder.setVelocidad(tema, 326, 160);
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
		builder.setFruta(tema, 326, 384);
	}

	private void crearBomba1() {
		builder.setBomba(tema, 320, 448);
	}

	private void crearPacDots1() {
		builder.setPacDot(tema, 42, 64);
		builder.setPacDot(tema, 42, 96);
		builder.setPacDot(tema, 42, 128);
		builder.setPacDot(tema, 42, 192);
		builder.setPacDot(tema, 42, 224);
		builder.setPacDot(tema, 42, 256);
		builder.setPacDot(tema, 42, 288);
		
		for(int j = 352; j <= 576; j += 32) {
			builder.setPacDot(tema, 42, j);
		}
		
		builder.setPacDot(tema, 618, 64);
		builder.setPacDot(tema, 618, 96);
		builder.setPacDot(tema, 618, 128);
		builder.setPacDot(tema, 618, 192);
		builder.setPacDot(tema, 618, 224);
		builder.setPacDot(tema, 618, 256);
		builder.setPacDot(tema, 618, 288);
		
		for(int j = 352; j <= 576; j += 32) {
			builder.setPacDot(tema, 618, j);
		}
		
		builder.setPacDot(tema, 138, 64);
		builder.setPacDot(tema, 138, 96);
		builder.setPacDot(tema, 106, 96);
		builder.setPacDot(tema, 74, 96);
		builder.setPacDot(tema, 138, 64);
		
		builder.setPacDot(tema, 522, 64);
		builder.setPacDot(tema, 522, 96);
		builder.setPacDot(tema, 554, 96);
		builder.setPacDot(tema, 586, 96);
		builder.setPacDot(tema, 490, 128);
		builder.setPacDot(tema, 490, 160);
		builder.setPacDot(tema, 490, 192);
		builder.setPacDot(tema, 490, 224);
		builder.setPacDot(tema, 490, 256);
		builder.setPacDot(tema, 458, 256);
		builder.setPacDot(tema, 522, 256);
		builder.setPacDot(tema, 586, 256);
		
		builder.setPacDot(tema, 234, 576);
		builder.setPacDot(tema, 426, 576);
		
		builder.setPacDot(tema, 202, 416);
		builder.setPacDot(tema, 458, 416);
		
		builder.setPacDot(tema, 522, 448);
		builder.setPacDot(tema, 586, 448);
		builder.setPacDot(tema, 522, 320);
		builder.setPacDot(tema, 586, 320);
		
		builder.setPacDot(tema, 298, 480);
		builder.setPacDot(tema, 298, 512);
		builder.setPacDot(tema, 362, 480);
		builder.setPacDot(tema, 362, 512);
		
		builder.setPacDot(tema, 74, 320);
		builder.setPacDot(tema, 138, 320);
		builder.setPacDot(tema, 74, 256);
		builder.setPacDot(tema, 138, 256);
		builder.setPacDot(tema, 202, 256);
		
		builder.setPacDot(tema, 330, 192);
		builder.setPacDot(tema, 330, 224);

		
		for(int i = 266; i <= 394; i += 32) {
			builder.setPacDot(tema, i, 160);
		}
		
		for(int j = 256; j >= 128; j -= 32) {
			builder.setPacDot(tema, 170, j);
		}
		
		for(int i = 74; i < 170; i += 32) {
			builder.setPacDot(tema, i, 448);
		}
		
		for(int i = 266 ; i < 320 ; i += 32)
			builder.setPacDot(tema, i, 448);
		
		for(int i = 362; i < 426; i += 32) {
			builder.setPacDot(tema, i, 448);
		}
		
		for(int j = 512; j > 320; j -= 32) {
			builder.setPacDot(tema, 170, j);
		}
		
		for(int j = 512; j > 320; j -= 32) {
			builder.setPacDot(tema, 490, j);
		}
		
		for(int j = 416; j <= 512; j += 32) {
			builder.setPacDot(tema, 234, j);
		}
		
		for(int j = 64; j <= 224; j += 32) {
			builder.setPacDot(tema, 234, j);
		}
		
		for(int j = 416; j <= 512; j += 32) {
			builder.setPacDot(tema, 426, j);
		}
		
		for(int j = 64; j <= 224; j += 32) {
			builder.setPacDot(tema, 426, j);
		}
		
		for(int j = 256; j < 448; j += 32) {
			builder.setPacDot(tema, 106, j);
		}
		
		for(int j = 256; j <= 448; j += 32) {
			builder.setPacDot(tema, 554, j);
		}
		
		for(int i = 74; i < 330; i += 32) {
			builder.setPacDot(tema, i, 544);
		}
		
		for(int i = 362; i < 608; i += 32) {
			builder.setPacDot(tema, i, 544);
		}

		for(int i = 74; i < 608; i +=32) {
			builder.setPacDot(tema, i, 32);
		}
		
		for(int i = 74; i < 608; i += 32) {
			builder.setPacDot(tema, i, 608);
		}

	}

	private void crearEnemigos1() {
		builder.setEnemigos(tema, 320, 320);
	}

	private void crearParedes1() {
		
		builder.setPared(tema, 0, 0, 8);
		builder.setPared(tema, 640, 0, 11);
		for(int i = 32 ; i <= 608 ; i += 32) 
			builder.setPared(tema, i, 0, 2);
		
		builder.setPared(tema, 0, 640, 14);
		builder.setPared(tema, 640, 640, 17);
		
		for(int i = 32 ; i <= 608 ; i += 32) 
			builder.setPared(tema, i, 640, 1);
		
		for(int j = 32 ; j <= 608 ; j += 32)
			builder.setPared(tema, 0, j, 4);
		
		for(int j = 32 ; j <= 608 ; j += 32)
			builder.setPared(tema, 640, j, 5);
		
		builder.setPared(tema, 64, 64, 21);
		builder.setPared(tema, 96, 64, 20);
		builder.setPared(tema, 160, 64, 21);
		builder.setPared(tema, 192, 64, 9);
		builder.setPared(tema, 256, 64, 7);
		builder.setPared(tema, 288, 64, 1);
		builder.setPared(tema, 320, 64, 1);
		builder.setPared(tema, 352, 64, 1);
		builder.setPared(tema, 384, 64, 10);
		builder.setPared(tema, 448, 64, 6);
		builder.setPared(tema, 480, 64, 20);
		builder.setPared(tema, 544, 64, 21);
		builder.setPared(tema, 576, 64, 20);
	
		builder.setPared(tema, 192, 96, 3);
		builder.setPared(tema, 256, 96, 5);
		builder.setPared(tema, 288, 96, 22);
		builder.setPared(tema, 320, 96, 22);
		builder.setPared(tema, 352, 96, 22);
		builder.setPared(tema, 384, 96, 4);
		builder.setPared(tema, 448, 96, 3);
		
		builder.setPared(tema, 64, 128, 7);
		builder.setPared(tema, 96, 128, 1);
		builder.setPared(tema, 128, 128, 10);
		builder.setPared(tema, 192, 128, 3);
		builder.setPared(tema, 256, 128, 13);
		builder.setPared(tema, 288, 128, 2);
		builder.setPared(tema, 320, 128, 2);
		builder.setPared(tema, 352, 128, 2);
		builder.setPared(tema, 384, 128, 16);
		builder.setPared(tema, 448, 128, 3);
		builder.setPared(tema, 512, 128, 7);
		builder.setPared(tema, 544, 128, 1);
		builder.setPared(tema, 576, 128, 10);
		
		builder.setPared(tema, 64, 160, 5);
		builder.setPared(tema, 96, 160, 22);
		builder.setPared(tema, 128, 160, 4);
		builder.setPared(tema, 192, 160, 3);
		builder.setPared(tema, 448, 160, 3);
		builder.setPared(tema, 512, 160, 5);
		builder.setPared(tema, 544, 160, 22);
		builder.setPared(tema, 576, 160, 4);
		
		builder.setPared(tema, 64, 192, 5);
		builder.setPared(tema, 96, 192, 22);
		builder.setPared(tema, 128, 192, 4);
		builder.setPared(tema, 192, 192, 3);
		builder.setPared(tema, 256, 192, 7);
		builder.setPared(tema, 288, 192, 10);
		builder.setPared(tema, 352, 192, 7);
		builder.setPared(tema, 384, 192, 10);
		builder.setPared(tema, 448, 192, 3);
		builder.setPared(tema, 512, 192, 5);
		builder.setPared(tema, 544, 192, 22);
		builder.setPared(tema, 576, 192, 4);
		
		builder.setPared(tema, 64, 224, 13);
		builder.setPared(tema, 96, 224, 2);
		builder.setPared(tema, 128, 224, 16);
		builder.setPared(tema, 192, 224, 18);
		builder.setPared(tema, 256, 224, 13);
		builder.setPared(tema, 288, 224, 16);
		builder.setPared(tema, 352, 224, 13);
		builder.setPared(tema, 384, 224, 16);
		builder.setPared(tema, 448, 224, 18);
		builder.setPared(tema, 512, 224, 13);
		builder.setPared(tema, 544, 224, 2);
		builder.setPared(tema, 576, 224, 16);
		
		builder.setPared(tema, 64, 288, 23); //rotonda
		builder.setPared(tema, 128, 288, 21);
		builder.setPared(tema, 160, 288, 0);
		builder.setPared(tema, 192, 288, 9);
		builder.setPared(tema, 256, 288, 6);
		builder.setPared(tema, 288, 288, 20);
		builder.setPared(tema, 352, 288, 21);
		builder.setPared(tema, 384, 288, 9);
		builder.setPared(tema, 448, 288, 6);
		builder.setPared(tema, 480, 288, 0);
		builder.setPared(tema, 512, 288, 20);
		builder.setPared(tema, 576, 288, 23); //rotonda
		
		builder.setPared(tema, 192, 320, 3);
		builder.setPared(tema, 256, 320, 3);
		builder.setPared(tema, 384, 320, 3);
		builder.setPared(tema, 448, 320, 3);
		
		builder.setPared(tema, 64, 352, 19);
		builder.setPared(tema, 128, 352, 19);
		builder.setPared(tema, 192, 352, 3);
		builder.setPared(tema, 256, 352, 12);
		builder.setPared(tema, 288, 352, 0);
		builder.setPared(tema, 320, 352, 0);
		builder.setPared(tema, 352, 352, 0);
		builder.setPared(tema, 384, 352, 15);
		builder.setPared(tema, 448, 352, 3);
		builder.setPared(tema, 512, 352, 19);
		builder.setPared(tema, 576, 352, 19);
		
		builder.setPared(tema, 64, 384, 3);
		builder.setPared(tema, 128, 384, 3);
		builder.setPared(tema, 192, 384, 18);
		builder.setPared(tema, 448, 384, 18);
		builder.setPared(tema, 512, 384, 3);
		builder.setPared(tema, 576, 384, 3);
		
		builder.setPared(tema, 64, 416, 18);
		builder.setPared(tema, 128, 416, 18);
		builder.setPared(tema, 256, 416, 21);
		builder.setPared(tema, 288, 416, 0);
		builder.setPared(tema, 320, 416, 0);
		builder.setPared(tema, 352, 416, 0);
		builder.setPared(tema, 384, 416, 20);
		builder.setPared(tema, 512, 416, 18);
		builder.setPared(tema, 576, 416, 18);
		
		builder.setPared(tema, 192, 448, 19);
		builder.setPared(tema, 448, 448, 19);
		
		builder.setPared(tema, 64, 480, 7);
		builder.setPared(tema, 96, 480, 1);
		builder.setPared(tema, 128, 480, 10);
		builder.setPared(tema, 192, 480, 3);
		builder.setPared(tema, 256, 480, 19);
		builder.setPared(tema, 320, 480, 19);
		builder.setPared(tema, 384, 480, 19);
		builder.setPared(tema, 448, 480, 3);
		builder.setPared(tema, 512, 480, 7);
		builder.setPared(tema, 544, 480, 1);
		builder.setPared(tema, 576, 480, 10);
		
		builder.setPared(tema, 64, 512, 13);
		builder.setPared(tema, 96, 512, 2);
		builder.setPared(tema, 128, 512, 16);
		builder.setPared(tema, 192, 512, 18);
		builder.setPared(tema, 256, 512, 18);
		builder.setPared(tema, 320, 512, 18);
		builder.setPared(tema, 384, 512, 18);
		builder.setPared(tema, 448, 512, 18);
		builder.setPared(tema, 512, 512, 13);
		builder.setPared(tema, 544, 512, 2);
		builder.setPared(tema, 576, 512, 16);
		
		builder.setPared(tema, 64, 576, 21);
		builder.setPared(tema, 96, 576, 0);
		builder.setPared(tema, 128, 576, 0);
		builder.setPared(tema, 160, 576, 0);
		builder.setPared(tema, 192, 576, 20);
		builder.setPared(tema, 256, 576, 21);
		builder.setPared(tema, 288, 576, 0);
		builder.setPared(tema, 320, 576, 0);
		builder.setPared(tema, 352, 576, 0);
		builder.setPared(tema, 384, 576, 20);
		builder.setPared(tema, 448, 576, 21);
		builder.setPared(tema, 480, 576, 0);
		builder.setPared(tema, 512, 576, 0);
		builder.setPared(tema, 544, 576, 0);
		builder.setPared(tema, 576, 576, 20);
		
	}

	public void makeNivel2(Builder builder) {
		this.builder = builder;
		builder.reset();
		
		
		builder.setProtagonista(tema, 320, 480);
		
		crearPowerPellets2();
		crearBomba2();
		crearFruta2();
		
		crearVelocidad2();
		//crearEnemigos2();
		crearPacDots2();
		crearParedes2();//habria que cambiar la disposicion de las paredes para que se facilite la grafica
	
		
	}
	
	private void crearVelocidad2() {
		builder.setVelocidad(tema, 326, 96);
		
	}

	private void crearPowerPellets2() {
		builder.setPowerPellet(tema, 614, 100);
		builder.setPowerPellet(tema, 38, 100);
		
		builder.setPowerPellet(tema, 614, 544);
		builder.setPowerPellet(tema, 38, 544);
		
		builder.setPowerPellet(tema, 326, 32);
		builder.setPowerPellet(tema, 326, 608);
		
		
	}

	private void crearFruta2() {
		builder.setFruta(tema, 326, 352);
		
	}

	private void crearBomba2() {
		builder.setBomba(tema, 320, 544);
		
	}

	private void crearPacDots2() {
		for(int i = 32 ; i < 640 ; i +=32) {
			builder.setPacDot(tema, 42, i);
			builder.setPacDot(tema, 618, i);
		}

		builder.setPacDot(tema, 74, 32);
		builder.setPacDot(tema, 74, 224);
		builder.setPacDot(tema, 74, 448);
		builder.setPacDot(tema, 74, 608);
		
		builder.setPacDot(tema, 586, 32);
		builder.setPacDot(tema, 586, 224);
		builder.setPacDot(tema, 586, 448);
		builder.setPacDot(tema, 586, 608);
		

		builder.setPacDot(tema, 106, 32);
		builder.setPacDot(tema, 106, 608);
		
		builder.setPacDot(tema, 554, 32);
		builder.setPacDot(tema, 554, 608);
				
		
		for(int i = 96 ; i < 576 ; i += 32) {
			builder.setPacDot(tema, 106, i);
			builder.setPacDot(tema, 554, i);
		}
		
		builder.setPacDot(tema, 138, 32);
		builder.setPacDot(tema, 138, 64);
		builder.setPacDot(tema, 138, 96);
		builder.setPacDot(tema, 138, 224);
		builder.setPacDot(tema, 138, 448);
		builder.setPacDot(tema, 138, 544);
		builder.setPacDot(tema, 138, 576);
		builder.setPacDot(tema, 138, 608);
		
		builder.setPacDot(tema, 522, 32);
		builder.setPacDot(tema, 522, 64);
		builder.setPacDot(tema, 522, 96);
		builder.setPacDot(tema, 522, 224);
		builder.setPacDot(tema, 522, 352);
		builder.setPacDot(tema, 522, 448);
		builder.setPacDot(tema, 522, 544);
		builder.setPacDot(tema, 522, 576);
		builder.setPacDot(tema, 522, 608);

		builder.setPacDot(tema, 170, 32);
		builder.setPacDot(tema, 170, 96);
		builder.setPacDot(tema, 170, 224);
		builder.setPacDot(tema, 170, 352);
		builder.setPacDot(tema, 170, 448);
		builder.setPacDot(tema, 170, 544);
		builder.setPacDot(tema, 170, 608);

		builder.setPacDot(tema, 490, 32);
		builder.setPacDot(tema, 490, 96);
		builder.setPacDot(tema, 490, 224);
		builder.setPacDot(tema, 490, 352);
		builder.setPacDot(tema, 490, 448);
		builder.setPacDot(tema, 490, 544);
		builder.setPacDot(tema, 490, 608);
		
		for(int i = 32 ; i < 224 ; i +=32) {
			builder.setPacDot(tema, 202, i);
			builder.setPacDot(tema, 458, i);
		}
		
		for(int i = 384 ; i < 640 ; i += 32) {
			builder.setPacDot(tema, 202, i);
			builder.setPacDot(tema, 458, i);
		}
		
		builder.setPacDot(tema, 234, 32);
		builder.setPacDot(tema, 234, 96);
		builder.setPacDot(tema, 234, 160);
		builder.setPacDot(tema, 234, 480);
		builder.setPacDot(tema, 234, 544);
		builder.setPacDot(tema, 234, 608);
		
		builder.setPacDot(tema, 426, 32);
		builder.setPacDot(tema, 426, 96);
		builder.setPacDot(tema, 426, 160);
		builder.setPacDot(tema, 426, 480);
		builder.setPacDot(tema, 426, 544);
		builder.setPacDot(tema, 426, 608);
		
		builder.setPacDot(tema, 266, 32);
		builder.setPacDot(tema, 266, 96);
		builder.setPacDot(tema, 266, 160);
		builder.setPacDot(tema, 266, 192);
		builder.setPacDot(tema, 266, 416);
		builder.setPacDot(tema, 266, 448);
		builder.setPacDot(tema, 266, 480);
		builder.setPacDot(tema, 266, 544);
		builder.setPacDot(tema, 266, 608);
		
		builder.setPacDot(tema, 394, 32);
		builder.setPacDot(tema, 394, 96);
		builder.setPacDot(tema, 394, 160);
		builder.setPacDot(tema, 394, 192);
		builder.setPacDot(tema, 394, 416);
		builder.setPacDot(tema, 394, 448);
		builder.setPacDot(tema, 394, 480);
		builder.setPacDot(tema, 394, 544);
		builder.setPacDot(tema, 394, 608);
		
		builder.setPacDot(tema, 298, 32);
		builder.setPacDot(tema, 298, 96);
		builder.setPacDot(tema, 298, 160);
		builder.setPacDot(tema, 298, 416);
		builder.setPacDot(tema, 298, 480);
		builder.setPacDot(tema, 298, 544);
		builder.setPacDot(tema, 298, 608);
		
		builder.setPacDot(tema, 362, 32);
		builder.setPacDot(tema, 362, 96);
		builder.setPacDot(tema, 362, 160);
		builder.setPacDot(tema, 362, 416);
		builder.setPacDot(tema, 362, 480);
		builder.setPacDot(tema, 362, 544);
		builder.setPacDot(tema, 362, 608);
		
		builder.setPacDot(tema, 330, 32);
		builder.setPacDot(tema, 330, 96);
		builder.setPacDot(tema, 330, 160);
		builder.setPacDot(tema, 330, 192);
		builder.setPacDot(tema, 330, 416);
		builder.setPacDot(tema, 330, 544);
		builder.setPacDot(tema, 330, 608);
		
		
	}

	private void crearEnemigos2() {
		builder.setEnemigos(tema, 320, 320);
		
	}

	private void crearParedes2() {
		
		builder.setPared(tema, 0, 0, 8);
		builder.setPared(tema, 640, 0, 11);
		for(int i = 32 ; i <= 608 ; i += 32) 
			builder.setPared(tema, i, 0, 2);
		
		builder.setPared(tema, 0, 640, 14);
		builder.setPared(tema, 640, 640, 17);
		
		for(int i = 32 ; i <= 608 ; i += 32) 
			builder.setPared(tema, i, 640, 1);
		
		for(int j = 32 ; j <= 608 ; j += 32)
			builder.setPared(tema, 0, j, 4);
		
		for(int j = 32 ; j <= 608 ; j += 32)
			builder.setPared(tema, 640, j, 5);
		
		builder.setPared(tema, 64, 64, 6);
		builder.setPared(tema, 96, 64, 20);
		builder.setPared(tema, 160, 64, 23); //rotonda
		builder.setPared(tema, 224, 64, 21);
		builder.setPared(tema, 256, 64, 0);
		builder.setPared(tema, 288, 64, 0);
		builder.setPared(tema, 320, 64, 0);
		builder.setPared(tema, 352, 64, 0);
		builder.setPared(tema, 384, 64, 0);
		builder.setPared(tema, 416, 64, 20);
		builder.setPared(tema, 480, 64, 23); //rotonda
		builder.setPared(tema, 544, 64, 21);
		builder.setPared(tema, 576, 64, 9);
		
		builder.setPared(tema, 64, 96, 3);
		builder.setPared(tema, 576, 96, 3);
		
		builder.setPared(tema, 64, 128, 3);
		builder.setPared(tema, 128, 128, 7);
		builder.setPared(tema, 160, 128, 10);
		builder.setPared(tema, 224, 128, 21);
		builder.setPared(tema, 256, 128, 0);
		builder.setPared(tema, 288, 128, 0);
		builder.setPared(tema, 320, 128, 0);
		builder.setPared(tema, 352, 128, 0);
		builder.setPared(tema, 384, 128, 0);
		builder.setPared(tema, 416, 128, 20);
		builder.setPared(tema, 480, 128, 7);
		builder.setPared(tema, 512, 128, 10);
		builder.setPared(tema, 576, 128, 3);
		
		builder.setPared(tema, 64, 160, 3);
		builder.setPared(tema, 128, 160, 5);
		builder.setPared(tema, 160, 160, 4);
		builder.setPared(tema, 480, 160, 5);
		builder.setPared(tema, 512, 160, 4);
		builder.setPared(tema, 576, 160, 3);
		
		builder.setPared(tema, 64, 192, 18);
		builder.setPared(tema, 128, 192, 13);
		builder.setPared(tema, 160, 192, 16);
		builder.setPared(tema, 224, 192, 23);//rotonda
		builder.setPared(tema, 288, 192, 23);//rotonda
		builder.setPared(tema, 352, 192, 23);//rotonda 
		builder.setPared(tema, 416, 192, 23);//rotonda
		builder.setPared(tema, 480, 192, 13);
		builder.setPared(tema, 512, 192, 16);
		builder.setPared(tema, 576, 192, 18);
		
		
		builder.setPared(tema, 64, 256, 19);
		builder.setPared(tema, 128, 256, 7);
		builder.setPared(tema, 160, 256, 1);
		builder.setPared(tema, 192, 256, 10);
		builder.setPared(tema, 288, 256, 20);
		builder.setPared(tema, 256, 256, 6);
		builder.setPared(tema, 352, 256, 21);
		builder.setPared(tema, 384, 256, 9);
		builder.setPared(tema, 448, 256, 7);
		builder.setPared(tema, 480, 256, 1);
		builder.setPared(tema, 512, 256, 10);
		builder.setPared(tema, 576, 256, 19);
		
		builder.setPared(tema, 64, 288, 3);
		builder.setPared(tema, 128, 288, 5);
		builder.setPared(tema, 160, 288, 22);
		builder.setPared(tema, 192, 288, 4);
		builder.setPared(tema, 256, 288, 3);
		builder.setPared(tema, 384, 288, 3);
		builder.setPared(tema, 448, 288, 5);
		builder.setPared(tema, 480, 288, 22);
		builder.setPared(tema, 512, 288, 4);
		builder.setPared(tema, 576, 288, 3);
		
		builder.setPared(tema, 64, 320, 3);
		builder.setPared(tema, 128, 320, 13);
		builder.setPared(tema, 160, 320, 2);
		builder.setPared(tema, 192, 320, 16);
		builder.setPared(tema, 256, 320, 12);
		builder.setPared(tema, 288, 320, 0);
		builder.setPared(tema, 320, 320, 0);
		builder.setPared(tema, 352, 320, 0);
		builder.setPared(tema, 384, 320, 15);
		builder.setPared(tema, 448, 320, 13);
		builder.setPared(tema, 480, 320, 2);
		builder.setPared(tema, 512, 320, 16);
		builder.setPared(tema, 576, 320, 3);
		
		builder.setPared(tema, 64, 352, 3);
		builder.setPared(tema, 576, 352, 3);
		
		builder.setPared(tema, 64, 384, 3);
		builder.setPared(tema, 128, 384, 7);
		builder.setPared(tema, 160, 384, 10);
		builder.setPared(tema, 224, 384, 6);
		builder.setPared(tema, 256, 384, 0);
		builder.setPared(tema, 288, 384, 0);
		builder.setPared(tema, 320, 384, 0);
		builder.setPared(tema, 352, 384, 0);
		builder.setPared(tema, 384, 384, 0);
		builder.setPared(tema, 416, 384, 9);
		builder.setPared(tema, 480, 384, 7);
		builder.setPared(tema, 512, 384, 10);
		builder.setPared(tema, 576, 384, 3);
		
		builder.setPared(tema, 64, 416, 18);
		builder.setPared(tema, 128, 416, 13);
		builder.setPared(tema, 160, 416, 16);
		builder.setPared(tema, 224, 416, 3);
		builder.setPared(tema, 416, 416, 3);
		builder.setPared(tema, 480, 416, 13);
		builder.setPared(tema, 512, 416, 16);
		builder.setPared(tema, 576, 416, 18);
		
		builder.setPared(tema, 224, 448, 18);
		builder.setPared(tema, 288, 448, 21);
		builder.setPared(tema, 320, 448, 0);
		builder.setPared(tema, 352, 448, 20);
		builder.setPared(tema, 416, 448, 18);

		builder.setPared(tema, 64, 480, 19);
		builder.setPared(tema, 128, 480, 7);
		builder.setPared(tema, 160, 480, 10);
		builder.setPared(tema, 480, 480, 7);
		builder.setPared(tema, 512, 480, 10);
		builder.setPared(tema, 576, 480, 19);
		
		builder.setPared(tema, 64, 512, 3);
		builder.setPared(tema, 128, 512, 13);
		builder.setPared(tema, 160, 512, 16);
		builder.setPared(tema, 224, 512, 21);
		builder.setPared(tema, 256, 512, 0);
		builder.setPared(tema, 288, 512, 0);
		builder.setPared(tema, 320, 512, 0);
		builder.setPared(tema, 352, 512, 0);
		builder.setPared(tema, 384, 512, 0);
		builder.setPared(tema, 416, 512, 20);
		builder.setPared(tema, 480, 512, 13);
		builder.setPared(tema, 512, 512, 16);
		builder.setPared(tema, 576, 512, 3);
		
		builder.setPared(tema, 64, 544, 3);
		builder.setPared(tema, 576, 544, 3);
		
		builder.setPared(tema, 64, 576, 12);
		builder.setPared(tema, 96, 576, 20);
		builder.setPared(tema, 160, 576, 23);
		builder.setPared(tema, 224, 576, 21);
		builder.setPared(tema, 256, 576, 0);
		builder.setPared(tema, 288, 576, 0);
		builder.setPared(tema, 320, 576, 0);
		builder.setPared(tema, 352, 576, 0);
		builder.setPared(tema, 384, 576, 0);
		builder.setPared(tema, 416, 576, 20);
		builder.setPared(tema, 480, 576, 23);
		builder.setPared(tema, 544, 576, 21);
		builder.setPared(tema, 576, 576, 15);
		
		
	}

	public void makeNivel3(Builder builder) {
		this.builder = builder;
		builder.reset();
		
		
		builder.setProtagonista(tema, 320, 480);

		crearEnemigos3();
		crearPowerPellets3();
		crearBomba3();
		crearFruta3();
		crearVelocidad3();
		crearPacDots3();
		crearParedes3();
	}

	private void crearVelocidad3() {
		builder.setVelocidad(tema, 326, 96);
		
	}

	private void crearPowerPellets3() {
		builder.setPowerPellet(tema, 38, 32);
		builder.setPowerPellet(tema, 38, 608);
		

		builder.setPowerPellet(tema, 616, 32);
		builder.setPowerPellet(tema, 616, 608);
	}

	private void crearFruta3() {
		builder.setFruta(tema, 326, 384);
	}

	private void crearBomba3() {
		builder.setBomba(tema, 320, 544);
	}

	private void crearPacDots3() {
		for(int i = 32 ; i < 640 ; i+=32) {
			builder.setPacDot(tema, 42, i);
			builder.setPacDot(tema, 618, i);
		}
		
		builder.setPacDot(tema, 74, 32);
		builder.setPacDot(tema, 74, 160);
		builder.setPacDot(tema, 74, 320);
		builder.setPacDot(tema, 74, 480);
		builder.setPacDot(tema, 74, 608);
		
		builder.setPacDot(tema, 586, 32);
		builder.setPacDot(tema, 586, 160);
		builder.setPacDot(tema, 586, 320);
		builder.setPacDot(tema, 586, 480);
		builder.setPacDot(tema, 586, 608);
		
		for(int i = 32 ; i < 512 ; i += 32) {
			builder.setPacDot(tema, 106, i);
			builder.setPacDot(tema, 554, i);
		}
		
		builder.setPacDot(tema, 106, 544);
		builder.setPacDot(tema, 106, 576);
		builder.setPacDot(tema, 106, 608);
		
		builder.setPacDot(tema, 554, 544);
		builder.setPacDot(tema, 554, 576);
		builder.setPacDot(tema, 554, 608);

		builder.setPacDot(tema, 138, 32);
		builder.setPacDot(tema, 138, 224);
		builder.setPacDot(tema, 138, 384);
		builder.setPacDot(tema, 138, 544);
		builder.setPacDot(tema, 138, 608);

		builder.setPacDot(tema, 522, 32);
		builder.setPacDot(tema, 522, 224);
		builder.setPacDot(tema, 522, 384);
		builder.setPacDot(tema, 522, 544);
		builder.setPacDot(tema, 522, 608);
		
		for(int i = 32 ; i < 640 ; i += 32) {
			builder.setPacDot(tema, 170, i);
			builder.setPacDot(tema, 490, i);
		}
		
		builder.setPacDot(tema, 202, 32);
		builder.setPacDot(tema, 202, 96);
		builder.setPacDot(tema, 202, 384);
		builder.setPacDot(tema, 202, 608);

		builder.setPacDot(tema, 458, 32);
		builder.setPacDot(tema, 458, 96);
		builder.setPacDot(tema, 458, 384);
		builder.setPacDot(tema, 458, 608);
		
		builder.setPacDot(tema, 234, 32);
		builder.setPacDot(tema, 426, 32);
		
		for(int i = 96 ; i < 256 ; i += 32) {
			builder.setPacDot(tema, 234, i);
			builder.setPacDot(tema, 426, i);
		}
		
		for(int i = 480 ; i < 640 ; i += 32) {
			builder.setPacDot(tema, 234, i);
			builder.setPacDot(tema, 426, i);
		}
		
		builder.setPacDot(tema, 266, 32);
		builder.setPacDot(tema, 266, 96);
		builder.setPacDot(tema, 266, 416);
		builder.setPacDot(tema, 266, 448);
		builder.setPacDot(tema, 266, 480);
		builder.setPacDot(tema, 266, 608);

		builder.setPacDot(tema, 394, 32);
		builder.setPacDot(tema, 394, 96);
		builder.setPacDot(tema, 394, 416);
		builder.setPacDot(tema, 394, 448);
		builder.setPacDot(tema, 394, 480);
		builder.setPacDot(tema, 394, 608);
		
		builder.setPacDot(tema, 298, 32);
		builder.setPacDot(tema, 298, 96);
		builder.setPacDot(tema, 298, 480);
		builder.setPacDot(tema, 298, 544);
		builder.setPacDot(tema, 298, 576);
		builder.setPacDot(tema, 298, 608);
		
		builder.setPacDot(tema, 362, 32);
		builder.setPacDot(tema, 362, 96);
		builder.setPacDot(tema, 362, 480);
		builder.setPacDot(tema, 362, 544);
		builder.setPacDot(tema, 362, 576);
		builder.setPacDot(tema, 362, 608);
		
		builder.setPacDot(tema, 330, 32);
		builder.setPacDot(tema, 330, 64);
		builder.setPacDot(tema, 330, 96);
		builder.setPacDot(tema, 330, 608);
	}

	private void crearEnemigos3() {
		// TODO Auto-generated method stub
		
	}

	private void crearParedes3() {
	
		builder.setPared(tema, 0, 0, 8);
		builder.setPared(tema, 640, 0, 11);
		for(int i = 32 ; i <= 608 ; i += 32) 
			builder.setPared(tema, i, 0, 2);
		
		builder.setPared(tema, 0, 640, 14);
		builder.setPared(tema, 640, 640, 17);
		
		for(int i = 32 ; i <= 608 ; i += 32) 
			builder.setPared(tema, i, 640, 1);
		
		for(int j = 32 ; j <= 608 ; j += 32)
			builder.setPared(tema, 0, j, 4);
		
		for(int j = 32 ; j <= 608 ; j += 32)
			builder.setPared(tema, 640, j, 5);
		
		builder.setPared(tema, 64, 64, 19);
		builder.setPared(tema, 128, 64, 19);
		builder.setPared(tema, 192, 64, 21);
		builder.setPared(tema, 224, 64, 0);
		builder.setPared(tema, 256, 64, 0);
		builder.setPared(tema, 288, 64, 20);
		builder.setPared(tema, 352, 64, 21);
		builder.setPared(tema, 384, 64, 0);
		builder.setPared(tema, 416, 64, 0);
		builder.setPared(tema, 448, 64, 20);
		builder.setPared(tema, 512, 64, 19);
		builder.setPared(tema, 576, 64, 19);
		
		builder.setPared(tema, 64, 96, 3);
		builder.setPared(tema, 128, 96, 3);
		builder.setPared(tema, 512, 96, 3);
		builder.setPared(tema, 576, 96, 3);
		
		builder.setPared(tema, 64, 128, 18);
		builder.setPared(tema, 128, 128, 3);
		builder.setPared(tema, 192, 128, 19);
		builder.setPared(tema, 256, 128, 7);
		builder.setPared(tema, 288, 128, 1);
		builder.setPared(tema, 320, 128, 1);
		builder.setPared(tema, 352, 128, 1);
		builder.setPared(tema, 384, 128, 10);
		builder.setPared(tema, 448, 128, 19);
		builder.setPared(tema, 512, 128, 3);
		builder.setPared(tema, 576, 128, 18);
		
		builder.setPared(tema, 128, 160, 3);
		builder.setPared(tema, 192, 160, 3);
		builder.setPared(tema, 256, 160, 5);
		builder.setPared(tema, 288, 160, 22);
		builder.setPared(tema, 320, 160, 22);
		builder.setPared(tema, 352, 160, 22);
		builder.setPared(tema, 384, 160, 4);
		builder.setPared(tema, 448, 160, 3);
		builder.setPared(tema, 512, 160, 3);
		
		builder.setPared(tema, 64, 192, 19);
		builder.setPared(tema, 128, 192, 18);
		builder.setPared(tema, 192, 192, 3);
		builder.setPared(tema, 256, 192, 5);
		builder.setPared(tema, 288, 192, 22);
		builder.setPared(tema, 320, 192, 22);
		builder.setPared(tema, 352, 192, 22);
		builder.setPared(tema, 384, 192, 4);
		builder.setPared(tema, 448, 192, 3);
		builder.setPared(tema, 512, 192, 18);
		builder.setPared(tema, 576, 192, 19);
		
		builder.setPared(tema, 64, 224, 3);
		builder.setPared(tema, 192, 224, 3);
		builder.setPared(tema, 256, 224, 13);
		builder.setPared(tema, 288, 224, 2);
		builder.setPared(tema, 320, 224, 2);
		builder.setPared(tema, 352, 224, 2);
		builder.setPared(tema, 384, 224, 16);
		builder.setPared(tema, 448, 224, 3);
		builder.setPared(tema, 576, 224, 3);
		
		builder.setPared(tema, 64, 256, 3);
		builder.setPared(tema, 128, 256, 19);
		builder.setPared(tema, 192, 256, 3);
		builder.setPared(tema, 448, 256, 3);
		builder.setPared(tema, 512, 256, 19);
		builder.setPared(tema, 576, 256, 3);
		
		builder.setPared(tema, 64, 288, 18);
		builder.setPared(tema, 128, 288, 3);
		builder.setPared(tema, 192, 288, 3);
		builder.setPared(tema, 256, 288, 6);
		builder.setPared(tema, 288, 288, 20);
		builder.setPared(tema, 352, 288, 21);
		builder.setPared(tema, 384, 288, 9);
		builder.setPared(tema, 448, 288, 3);
		builder.setPared(tema, 512, 288, 3);
		builder.setPared(tema, 576, 288, 18);
		
		builder.setPared(tema, 128, 320, 3);
		builder.setPared(tema, 192, 320, 3);
		builder.setPared(tema, 256, 320, 3);
		builder.setPared(tema, 384, 320, 3);
		builder.setPared(tema, 448, 320, 3);
		builder.setPared(tema, 512, 320, 3);
		
		builder.setPared(tema, 64, 352, 19);
		builder.setPared(tema, 128, 352, 18);
		builder.setPared(tema, 192, 352, 18);
		builder.setPared(tema, 256, 352, 12);
		builder.setPared(tema, 288, 352, 0);
		builder.setPared(tema, 320, 352, 0);
		builder.setPared(tema, 352, 352, 0);
		builder.setPared(tema, 384, 352, 15);
		builder.setPared(tema, 448, 352, 18);
		builder.setPared(tema, 512, 352, 18);
		builder.setPared(tema, 576, 352, 19);
		
		builder.setPared(tema, 64, 384, 3);
		builder.setPared(tema, 576, 384, 3);
		
		builder.setPared(tema, 64, 416, 3);
		builder.setPared(tema, 128, 416, 19);
		builder.setPared(tema, 192, 416, 7);
		builder.setPared(tema, 224, 416, 10);
		builder.setPared(tema, 288, 416, 7);
		builder.setPared(tema, 320, 416, 1);
		builder.setPared(tema, 352, 416, 10);
		builder.setPared(tema, 416, 416, 7);
		builder.setPared(tema, 448, 416, 10);
		builder.setPared(tema, 512, 416, 19);
		builder.setPared(tema, 576, 416, 3);
		
		builder.setPared(tema, 64, 448, 18);
		builder.setPared(tema, 128, 448, 3);
		builder.setPared(tema, 192, 448, 13);
		builder.setPared(tema, 224, 448, 16);
		builder.setPared(tema, 288, 448, 13);
		builder.setPared(tema, 320, 448, 2);
		builder.setPared(tema, 352, 448, 16);
		builder.setPared(tema, 416, 448, 13);
		builder.setPared(tema, 448, 448, 16);
		builder.setPared(tema, 512, 448, 3);
		builder.setPared(tema, 576, 448, 18);
		
		builder.setPared(tema, 128, 480, 3);
		builder.setPared(tema, 512, 480, 3);
		
		builder.setPared(tema, 64, 512, 6);
		builder.setPared(tema, 96, 512, 0);
		builder.setPared(tema, 128, 512, 15);
		builder.setPared(tema, 192, 512, 19);
		builder.setPared(tema, 256, 512, 6);
		builder.setPared(tema, 288, 512, 0);
		builder.setPared(tema, 320, 512, 0);
		builder.setPared(tema, 352, 512, 0);
		builder.setPared(tema, 384, 512, 9);
		builder.setPared(tema, 448, 512, 19);
		builder.setPared(tema, 512, 512, 12);
		builder.setPared(tema, 544, 512, 0);
		builder.setPared(tema, 576, 512, 9);
		
		builder.setPared(tema, 64, 544, 3);
		builder.setPared(tema, 192, 544, 3);
		builder.setPared(tema, 256, 544, 3);
		builder.setPared(tema, 384, 544, 3);
		builder.setPared(tema, 448, 544, 3);
		builder.setPared(tema, 576, 544, 3);
		
		builder.setPared(tema, 64, 576, 18);
		builder.setPared(tema, 128, 576, 23);
		builder.setPared(tema, 192, 576, 18);
		builder.setPared(tema, 256, 576, 18);
		builder.setPared(tema, 320, 576, 23);
		builder.setPared(tema, 384, 576, 18);
		builder.setPared(tema, 448, 576, 18);
		builder.setPared(tema, 512, 576, 23);
		builder.setPared(tema, 576, 576, 18);
		
	}
}
