package Launcher;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import GUI.InstruccionesGUI;
import GUI.VentanaGUI;
import java.awt.Color;
import javax.swing.JLabel;



public class Launcher extends JFrame{

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	InstruccionesGUI instrucciones = new InstruccionesGUI();;
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Launcher frame = new Launcher();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public Launcher() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 471, 445);
		contentPane = new JPanel();
		contentPane.setBackground(Color.BLACK);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		//setIconImage(Toolkit.getDefaultToolkit().getImage(VentanaGUI.class.getResource("")));
		setResizable(false);
		
		JButton btnTema1 = new JButton("Autos");
		btnTema1.setForeground(Color.BLACK);
		btnTema1.setBackground(Color.WHITE);
		btnTema1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				VentanaGUI frame = new VentanaGUI(1);
				frame.setVisible(true);
				dispose();
			}
		});
		btnTema1.setFont(new Font("Segoe UI Black", Font.PLAIN, 18));
		btnTema1.setBounds(155, 234, 146, 35);
		contentPane.add(btnTema1);
		
		JButton btnTema2 = new JButton("Barcos");
		btnTema2.setForeground(Color.BLACK);
		btnTema2.setBackground(Color.WHITE);
		btnTema2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				VentanaGUI frame = new VentanaGUI(2);
				frame.setVisible(true);
				dispose();
			}
		});
		btnTema2.setFont(new Font("Segoe UI Black", Font.PLAIN, 18));
		btnTema2.setBounds(155, 284, 146, 35);
		contentPane.add(btnTema2);
		
		JButton btnInstrucciones = new JButton("Cómo jugar");
		btnInstrucciones.setForeground(Color.BLACK);
		btnInstrucciones.setBackground(Color.WHITE);
		btnInstrucciones.setBounds(155, 336, 146, 35);
		
		btnInstrucciones.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				instrucciones.setVisible(true);
			}
		});
		
		btnInstrucciones.setFont(new Font("Segoe UI Black", Font.PLAIN, 18));
		
		contentPane.add(btnInstrucciones);
		
		JLabel lblNewLabel = new JLabel("Seleccionar tematica");
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setBounds(131, 191, 225, 26);
		lblNewLabel.setFont(new Font("Segoe UI Black", Font.PLAIN, 18));
		contentPane.add(lblNewLabel);
		
	}
}
