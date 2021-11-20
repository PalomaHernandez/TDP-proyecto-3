package GUI;

import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Entidades.Entidad;
import Entidades.Moviles.Blinky;
import Entidades.Moviles.Clyde;
import Entidades.Moviles.Inky;
import Entidades.Moviles.Pinky;
import Logica.Juego;
import java.awt.Color;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.HashSet;
import java.awt.Font;
import java.awt.Image;

import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.applet.AudioClip;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class VentanaGUI extends JFrame implements KeyListener{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JPanel panel;
	private Juego miJuego;
	private JLabel lblPuntaje;
	private JLabel lblVida1;
	private JLabel lblVida2;
	private JLabel lblVida3;
	private int puntaje;
	private boolean sonidoActivo;
	private VentanaFinJuego finJuego = new VentanaFinJuego(this);
	
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
		panel.setBounds(31, 51, 672, 672);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblScore = new JLabel("SCORE:");
		lblScore.setFont(new Font("Segoe UI Black", Font.PLAIN, 18));
		lblScore.setForeground(Color.WHITE);
		lblScore.setBounds(31, 20, 69, 20);
		contentPane.add(lblScore);
		
		lblPuntaje = new JLabel("0");
		lblPuntaje.setFont(new Font("Segoe UI Black", Font.PLAIN, 18));
		lblPuntaje.setHorizontalAlignment(SwingConstants.LEFT);
		lblPuntaje.setForeground(Color.WHITE);
		lblPuntaje.setBounds(102, 22, 150, 17);
		contentPane.add(lblPuntaje);
		
		lblVida1 = new JLabel("");
		lblVida1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblVida1.setForeground(Color.RED);
		lblVida1.setBounds(466, 11, 32, 32);
		contentPane.add(lblVida1);
		
		lblVida2 = new JLabel("");
		lblVida2.setForeground(Color.RED);
		lblVida2.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblVida2.setBounds(519, 11, 32, 32);
		contentPane.add(lblVida2);
		
		lblVida3 = new JLabel("");
		lblVida3.setForeground(Color.RED);
		lblVida3.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblVida3.setBounds(572, 11, 32, 32);
		contentPane.add(lblVida3);
		
		miJuego = new Juego(1, this);

		ImageIcon icon= new ImageIcon(getClass().getResource("/imagenesA/autoDerecha.png"));
		ImageIcon img= new ImageIcon(icon.getImage().getScaledInstance(lblVida1.getWidth(), lblVida1.getHeight(), Image.SCALE_SMOOTH));
		lblVida1.setIcon(img);
		lblVida2.setIcon(img);
		lblVida3.setIcon(img);
		
		
		JButton btnNewButton = new JButton("music");
		
		sonidoActivo=false;
		
//		btnNewButton.addMouseListener(new MouseAdapter() {
//			@Override
//			public void mouseClicked(MouseEvent e) {
//				
//				if(!sonidoActivo) {
//					sonidoActivo=true;
//					miJuego.setearSonido(true);
//					//cambiar imagen a activada
//				}
//				else {
//					sonidoActivo=false;
//					miJuego.setearSonido(false);
//					//cambiar imagen a desactivada
//				}
//			}
//		});
//
//		btnNewButton.setBounds(166, 22, 89, 23);
//		contentPane.add(btnNewButton);
		
		addKeyListener(this);
		
	}

	public void moverEntidad(int posX, int posY, int posXFin, int posYFin, Entidad e) {
		e.setBounds(posXFin, posYFin, e.getWidth(), e.getHeight());
	}

	public void inicializarNivel(HashSet<Entidad> nivel, Entidad protagonista, Blinky blinky, Clyde clyde, Pinky pinky, Inky inky) {
		ImageIcon imagen;
		
		protagonista.setBounds(protagonista.getX(), protagonista.getY(), 32, 32);
		panel.add(protagonista);
		protagonista.setIcon(new ImageIcon(VentanaGUI.class.getResource(protagonista.getRepresentacion())));
		
		blinky.setBounds(blinky.getX(), blinky.getY(), 32, 32);
		panel.add(blinky);
		blinky.setIcon(new ImageIcon(VentanaGUI.class.getResource(blinky.getRepresentacion())));
		
		pinky.setBounds(pinky.getX(), pinky.getY(), 32, 32);
		panel.add(pinky);
		pinky.setIcon(new ImageIcon(VentanaGUI.class.getResource(pinky.getRepresentacion())));
		
		clyde.setBounds(clyde.getX(), clyde.getY(), 32, 32);
		panel.add(clyde);
		clyde.setIcon(new ImageIcon(VentanaGUI.class.getResource(clyde.getRepresentacion())));
		
		inky.setBounds(inky.getX(), inky.getY(), 32, 32);
		panel.add(inky);
		inky.setIcon(new ImageIcon(VentanaGUI.class.getResource(inky.getRepresentacion())));
		for(Entidad e : nivel) {
			e.setBounds(e.getX(), e.getY(), 32, 32);
			panel.add(e);
			imagen = new ImageIcon(VentanaGUI.class.getResource(e.getRepresentacion()));
			e.setIcon(imagen);
		}
		
		reiniciarVidas();
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
		case KeyEvent.VK_SPACE:
			miJuego.colocarBomba();
			break;
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	public void actualizarPuntaje(int puntaje) {
		this.puntaje=puntaje;
		lblPuntaje.setText(""+puntaje);
	}

	public void eliminarVidas(int vidas) {
		switch(vidas) {
		case 1: lblVida1.setVisible(false);
		break;
		case 2: lblVida2.setVisible(false);
		break;
		case 3: lblVida3.setVisible(false);
		break;
		}
		
	}

	public void reiniciarVidas() {
		lblVida1.setVisible(true);
		lblVida2.setVisible(true);
		lblVida3.setVisible(true);
	}
	
	public void reiniciarJuego() {
		this.setVisible(true);
		limpiar();
		reiniciarVidas();
		miJuego= new Juego(1,this);
	}
	
	public void finJuego(String texto) {
		finJuego.setResultado(texto);
		finJuego.setVisible(true);
		finJuego.setPuntuacion(puntaje);
	}
	
	public void cerrarJuego() {
		miJuego.cerrarJuego();
	}

	public String getPuntaje() {
		return puntaje+"";
	}

	public void limpiar() {
		panel.removeAll();
		panel.repaint();
	}
	
	public boolean getSonido() {
		return sonidoActivo;
	}
}
