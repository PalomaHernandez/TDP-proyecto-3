package GUI;

import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Entidades.Entidad;
import Entidades.Moviles.Blinky;
import Logica.Juego;

import java.awt.Color;
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
	private Juego miJuego;
	private JLabel lblPuntaje;
	private int codigoAnterior = KeyEvent.VK_LEFT;
	private int codigoSiguiente = KeyEvent.VK_LEFT;
	private boolean puedeMover = true;
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
		e.setBounds(posXFin, posYFin, e.getWidth(), e.getHeight());
	}

	public void inicializarNivel1(List<Entidad> nivel, Entidad protagonista, Blinky blinky) {
		ImageIcon imagen;
		protagonista.setBounds(protagonista.getX(), protagonista.getY(), 32, 32);
		panel.add(protagonista);
		protagonista.setIcon(new ImageIcon(VentanaGUI.class.getResource(protagonista.getRepresentacion())));
		blinky.setBounds(blinky.getX(), blinky.getY(), 32, 32);
		panel.add(blinky);
		blinky.setIcon(new ImageIcon(VentanaGUI.class.getResource(blinky.getRepresentacion())));
		for(Entidad e : nivel) {
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
		
		/*
		int code = e.getKeyCode();
		switch(code) {
		case KeyEvent.VK_RIGHT:
			puedeMover = miJuego.moverDerAction();
			if(puedeMover)
				codigoAnterior = KeyEvent.VK_RIGHT;
			else 
				codigoSiguiente = KeyEvent.VK_RIGHT;
			break;
		case KeyEvent.VK_LEFT: 
			puedeMover = miJuego.moverIzqAction();
			if(puedeMover)
				codigoAnterior = KeyEvent.VK_LEFT;
			else 
				codigoSiguiente = KeyEvent.VK_LEFT;
			break;
		case KeyEvent.VK_DOWN:
			puedeMover = miJuego.moverAbajoAction();
			if(puedeMover)
				codigoAnterior = KeyEvent.VK_DOWN;
			else
				codigoSiguiente = KeyEvent.VK_DOWN;
			break;
		case KeyEvent.VK_UP:
			puedeMover = miJuego.moverArribaAction();
			if(puedeMover)
				codigoAnterior = KeyEvent.VK_UP;
			else 
				codigoSiguiente = KeyEvent.VK_UP;
			break;
		}
		if(!puedeMover) {
			switch(codigoAnterior) {
			case KeyEvent.VK_RIGHT:
				miJuego.moverDerAction();
				break;
			case KeyEvent.VK_LEFT:
				miJuego.moverIzqAction();
				break;
			case KeyEvent.VK_UP:
				miJuego.moverArribaAction();
				break;
			case KeyEvent.VK_DOWN:
				miJuego.moverAbajoAction();
				break;
			}
			
		}*/
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	public void actualizarPuntaje(int puntaje) {
		lblPuntaje.setText(""+puntaje);
	}
}
