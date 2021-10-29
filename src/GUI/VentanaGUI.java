package GUI;

import java.awt.EventQueue;
import java.awt.Graphics;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import java.awt.GridLayout;

public class VentanaGUI extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JPanel panel;
	private Graphics graph;
	
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
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1000, 800);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		panel = new JPanel();
		panel.setBackground(Color.BLACK);
		panel.setForeground(Color.BLACK);
		panel.setBounds(10, 10, 768, 768);
		contentPane.add(panel);
		graph = panel.getGraphics();
		
	}

	public void moverEntidad(int posX, int posY, int posXFin, int posYFin, MovilGUI representacion) {
		
		graph.drawImage((new ImageIcon(representacion.getImagen())).getImage(), posXFin, posYFin, panel);
		panel.update(graph);
	}
}
