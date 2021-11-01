package GUI;

import java.awt.EventQueue;
import java.awt.Graphics;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Entidades.Entidad;
import Logica.Juego;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.util.List;

public class VentanaGUI extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JPanel panel;
	private Graphics graph;
	private Juego miJuego;
	private Entidad entidadActual;
	private List<Entidad> nivel;
	private JLabel[] arregloLabel;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaGUI frame = new VentanaGUI();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public VentanaGUI() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0, 0, 1000, 800);
		this.setSize(1000, 840);
		
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		panel = new JPanel();
		panel.setBackground(Color.BLACK);
		panel.setBounds(10, 10, 672, 672);
		contentPane.add(panel);
		panel.setLayout(null);
		
		miJuego = new Juego(1, this);
		
	}

	public void moverEntidad(int posX, int posY, int posXFin, int posYFin, String representacion) {
		
	}

	public void inicializarNivel(List<Entidad> nivel) {
		arregloLabel = new JLabel[nivel.size()];
		int i = 0;
		this.nivel = nivel;
		ImageIcon imagen;
		for(Entidad e : nivel) {
			arregloLabel[i] = new JLabel();
			arregloLabel[i].setBounds(e.getX(), e.getY(), 32, 32);
			panel.add(arregloLabel[i]);
			imagen = new ImageIcon(VentanaGUI.class.getResource(e.getRepresentacion()));
			arregloLabel[i].setIcon(imagen);
			i++;
		}
	}
}
