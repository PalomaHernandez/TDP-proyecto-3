package GUI;

public class ParedGUI {

	private String representacion[];
	private String actual;
	
	public ParedGUI(String h0){
		representacion = new String[23];
		representacion[0] = h0;
		actual = h0;
	}
	
	public void setImagen(int imagen) {
		actual = representacion[imagen];
	}
	
	public void agregarImagenes(String h1, String h2, String v3, String v4, String v5, String c6, String c7, String c8, String c9, String c10, String c11, String c12, String c13, String c14, String c15, String c16, String c17, String v18, String v19, String h20, String h21, String libre ) {
		representacion[1] = h1;
		representacion[2] = h2;
		representacion[3] = v3;
		representacion[4] = v4;
		representacion[5] = v5;
		representacion[6] = c6;
		representacion[7] = c7;
		representacion[8] = c8;
		representacion[9] = c9;
		representacion[10] = c10;
		representacion[11] = c11;
		representacion[12] = c12;
		representacion[13] = c13;
		representacion[14] = c14;
		representacion[15] = c15;
		representacion[16] = c16;
		representacion[17] = c17;
		representacion[18] = v18;
		representacion[19] = v19;
		representacion[20] = h20;
		representacion[21] = h21;
		representacion[22] = libre;
	}
	
	public String getImagen() {
		return actual;
	}
	
}
