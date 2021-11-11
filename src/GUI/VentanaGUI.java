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
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.List;
import java.awt.Font;
import javax.swing.SwingConstants;

public class VentanaGUI extends JFrame implements KeyListener{

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
	private JLabel labelProtagonista;
	private JLabel lblPuntaje;
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
		this.setSize(750, 800);
		
		contentPane = new JPanel();
		contentPane.setBackground(Color.BLACK);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		panel = new JPanel();
		panel.setBackground(Color.GRAY);
		panel.setBounds(31, 38, 672, 672);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblScore = new JLabel("SCORE");
		lblScore.setFont(new Font("Segoe UI Black", Font.PLAIN, 18));
		lblScore.setForeground(Color.WHITE);
		lblScore.setBounds(42, 11, 69, 20);
		contentPane.add(lblScore);
		
		lblPuntaje = new JLabel("0");
		lblPuntaje.setFont(new Font("Segoe UI Black", Font.PLAIN, 18));
		lblPuntaje.setHorizontalAlignment(SwingConstants.LEFT);
		lblPuntaje.setForeground(Color.WHITE);
		lblPuntaje.setBounds(110, 13, 43, 17);
		contentPane.add(lblPuntaje);
		
		miJuego = new Juego(1, this);

		addKeyListener(this);
		
	}

	public void moverEntidad(int posX, int posY, int posXFin, int posYFin, Entidad e) {
		//labelProtagonista.move(posXFin, posYFin);
		e.setBounds(posXFin, posYFin, e.getWidth(), e.getHeight());
		//((JLabel)panel.getComponentAt(posX, posY)).move(posXFin, posYFin);;
		//((JLabel)panel.getComponentAt(posX, posY)).setBounds(posXFin, posYFin, 32, 32);
	}

	public void inicializarNivel1(List<Entidad> nivel, Entidad protagonista) {
		arregloLabel = new JLabel[nivel.size()];
		this.nivel = nivel;
		ImageIcon imagen;
		protagonista.setBounds(protagonista.getX(), protagonista.getY(), 32, 32);
		panel.add(protagonista);
		protagonista.setIcon(new ImageIcon(VentanaGUI.class.getResource(protagonista.getRepresentacion())));
		for(Entidad e : nivel) {
			//arregloLabel[i] = new JLabel();
			//arregloLabel[i].setBounds(e.getX(), e.getY(), 32, 32);
			e.setBounds(e.getX(), e.getY(), 32, 32);
			panel.add(e);
			imagen = new ImageIcon(VentanaGUI.class.getResource(e.getRepresentacion()));
			e.setIcon(imagen);
		}
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		int code = e.getKeyCode();
		
		switch(code) {
		case KeyEvent.VK_RIGHT:
			miJuego.moverDerAction();
			break;
		case KeyEvent.VK_LEFT: 
			miJuego.moverIzqAction();
			break;
		case KeyEvent.VK_DOWN:
			miJuego.moverAbajoAction();
			break;
		case KeyEvent.VK_UP:
			miJuego.moverArribaAction();
			break;
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	public void actualizarPuntaje(int puntaje) {
		lblPuntaje.setText(""+puntaje);
	}
}
