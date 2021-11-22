package GUI;

import java.awt.GridLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.ImageIcon;
import javax.swing.JTextPane;
import java.awt.Font;

public class InstruccionesGUI extends JFrame{

	private static final long serialVersionUID = 1L;
	
	public InstruccionesGUI() {
		setBackground(Color.WHITE);
		setTitle("Instrucciones");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 500, 513);
		setResizable(false);
		getContentPane().setLayout(null);

		
		JLabel lblNewLabel_1 = new JLabel("Controles:");
		lblNewLabel_1.setFont(new Font("Bauhaus 93", Font.PLAIN, 15));
		lblNewLabel_1.setBounds(67, 273, 76, 28);
		getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("\u00BFC\u00F3mo jugar?");
		lblNewLabel_1_1.setFont(new Font("Bauhaus 93", Font.PLAIN, 15));
		lblNewLabel_1_1.setBounds(67, 90, 97, 28);
		getContentPane().add(lblNewLabel_1_1);
		
		JLabel lblNewLabel = new JLabel("El juego cuenta de un jugador, el cual debe comer todos los  ");
		lblNewLabel.setBounds(67, 119, 282, 19);
		getContentPane().add(lblNewLabel);
		
		JLabel lblElementosLlamadosPacdots = new JLabel("elementos llamados pac-dots para lograr as\u00ED avanzar de nivel");
		lblElementosLlamadosPacdots.setBounds(67, 141, 282, 19);
		getContentPane().add(lblElementosLlamadosPacdots);
		
		JLabel lblYGanarEl = new JLabel("y ganar el juego, superando el nivel 3.");
		lblYGanarEl.setBounds(67, 167, 282, 19);
		getContentPane().add(lblYGanarEl);
		
		JLabel lblYGanarEl_1 = new JLabel("");
		lblYGanarEl_1.setBounds(67, 194, 282, 19);
		getContentPane().add(lblYGanarEl_1);
		
		JLabel lblMoverseHaciaArriba = new JLabel("Moverse hacia arriba: Flecha arriba");
		lblMoverseHaciaArriba.setBounds(67, 302, 282, 19);
		getContentPane().add(lblMoverseHaciaArriba);
		
		JLabel lblMoverseHaciaAbajo = new JLabel("Moverse hacia abajo: Flecha abajo");
		lblMoverseHaciaAbajo.setBounds(67, 331, 282, 19);
		getContentPane().add(lblMoverseHaciaAbajo);
		
		JLabel lblMoverseHaciaLa = new JLabel("Moverse hacia la derecha: Flecha derecha");
		lblMoverseHaciaLa.setBounds(67, 360, 282, 19);
		getContentPane().add(lblMoverseHaciaLa);
		
		JLabel lblMoverseHaciaLa_1 = new JLabel("Moverse hacia la izquierda: Flecha izquierda");
		lblMoverseHaciaLa_1.setBounds(67, 389, 282, 19);
		getContentPane().add(lblMoverseHaciaLa_1);
		
		JLabel lblColocarBombaBarra = new JLabel("Colocar bomba: Barra espaciadora");
		lblColocarBombaBarra.setBounds(67, 418, 282, 19);
		getContentPane().add(lblColocarBombaBarra);
		
		JLabel lblDesactivarMusicaTecla = new JLabel("Desactivar musica: Tecla M");
		lblDesactivarMusicaTecla.setBounds(67, 447, 282, 19);
		getContentPane().add(lblDesactivarMusicaTecla);
		
		JLabel lblNewLabel10 = new JLabel(""); //Esta label siempre se crea a lo ultimo ya que es el fondo
		lblNewLabel10.setIcon(new ImageIcon(InstruccionesGUI.class.getResource("/imagenes/fondoInstruccion.png")));
		lblNewLabel10.setBounds(0, 0, 486, 463);
		getContentPane().add(lblNewLabel10);
		
		//falta agregar mas instrucciones
	}
}
