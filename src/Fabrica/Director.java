package Fabrica;

public class Director {
	
	private Builder builder;
	private Tema tema;
	private Fabrica miFabrica;
	
	public Director(int tema) {
		miFabrica = new Fabrica();
		if(tema == 1)
			this.tema = miFabrica.getTemaA();
		else
			this.tema = miFabrica.getTemaB();
		
	}
	
	public void makeNivel1(Builder builder) {//El juego envia un builder nivel1, 2 o 3 segun corresponda0
		this.builder = builder;
		builder.reset();
		
		crearParedes();
		
		//builder.setProtagonista(tema, 320, 544);
		/**
		crearEnemigos();
		crearPacDots();
		crearBomba();
		crearFruta();
		crearPowerPellets();
		crearVelocidad();
		**/
		
	}
	
	private void crearVelocidad() {
		builder.setVelocidad(tema, 320, 384);
	}

	private void crearPowerPellets() {
		builder.setPowerPellet(tema, 608, 32);
		builder.setPowerPellet(tema, 32, 32);
		
		builder.setPowerPellet(tema, 160, 96);
		builder.setPowerPellet(tema, 480, 96);
		
		builder.setPowerPellet(tema, 32, 160);
		builder.setPowerPellet(tema, 608, 160);
		
		builder.setPowerPellet(tema, 32, 320);
		builder.setPowerPellet(tema, 160, 320);
		builder.setPowerPellet(tema, 480, 320);
		builder.setPowerPellet(tema, 608, 320);
		
		builder.setPowerPellet(tema, 32, 608);
		builder.setPowerPellet(tema, 608, 608);
		
	}

	private void crearFruta() {
		builder.setFruta(tema, 320, 384);
	}

	private void crearBomba() {
		builder.setBomba(tema, 320, 384);
	}

	private void crearPacDots() {
		// TODO Auto-generated method stub
		
	}

	private void crearEnemigos() {
		builder.setEnemigos(tema, 320, 320);
	}

	private void crearParedes() {
		
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
		
		builder.setPared(tema, 64, 572);
		builder.setPared(tema, 96, 572);
		builder.setPared(tema, 128, 572);
		builder.setPared(tema, 160, 572);
		builder.setPared(tema, 192, 572);
		builder.setPared(tema, 256, 572);
		builder.setPared(tema, 288, 572);
		builder.setPared(tema, 320, 572);
		builder.setPared(tema, 352, 572);
		builder.setPared(tema, 384, 572);
		builder.setPared(tema, 448, 572);
		builder.setPared(tema, 480, 572);
		builder.setPared(tema, 512, 572);
		builder.setPared(tema, 544, 572);
		builder.setPared(tema, 576, 572);
		
	}

	public void makeNivel2(Builder builder) {
		this.builder = builder;
		
	}
	
	public void makeNivel3(Builder builder) {
		this.builder = builder;
		
	}
}
