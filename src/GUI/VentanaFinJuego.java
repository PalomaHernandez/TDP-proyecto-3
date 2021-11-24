package GUI;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.SwingConstants;
import java.awt.Color;

public class VentanaFinJuego extends JDialog{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JLabel lblPuntaje;
	private JLabel lblResultado;
//	private VentanaGUI miVentana;
	
	public VentanaFinJuego(VentanaGUI miVentana) {
		getContentPane().setBackground(Color.ORANGE);
		getContentPane().setLayout(null);
		setBounds(100, 100, 470, 300);
		setIconImage(Toolkit.getDefaultToolkit().getImage(VentanaFinJuego.class.getResource("/imagenes/logo-sirena.png")));
		setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
		
		setResizable(false);
		setEnabled(true);
		
		JLabel lblNewLabel = new JLabel("PUNTUACI\u00D3N:");
		lblNewLabel.setFont(new Font("Segoe UI Black", Font.PLAIN, 18));
		lblNewLabel.setBounds(126, 108, 138, 26);
		getContentPane().add(lblNewLabel);
		
		lblPuntaje = new JLabel("");
		lblPuntaje.setHorizontalAlignment(SwingConstants.LEFT);
		lblPuntaje.setFont(new Font("Segoe UI Black", Font.PLAIN, 18));
		lblPuntaje.setBounds(265, 108, 138, 26);
		getContentPane().add(lblPuntaje);
		
		JLabel lblNewLabel_1 = new JLabel("\u00BFDesea jugar de nuevo?");
		lblNewLabel_1.setFont(new Font("Segoe UI Black", Font.PLAIN, 14));
		lblNewLabel_1.setBounds(136, 146, 181, 26);
		getContentPane().add(lblNewLabel_1);
		
		JButton btnSi = new JButton("SI");
		btnSi.setFont(new Font("Segoe UI Black", Font.PLAIN, 11));
		btnSi.setBounds(125, 194, 89, 23);
		getContentPane().add(btnSi);
		
		btnSi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				miVentana.reiniciarJuego();
				setVisible(false);
			}
		});
		
		JButton btnNo = new JButton("NO");
		btnNo.setFont(new Font("Segoe UI Black", Font.PLAIN, 11));
		btnNo.setBounds(220, 194, 89, 23);
		getContentPane().add(btnNo);
		
		lblResultado = new JLabel("");
		lblResultado.setFont(new Font("Segoe UI Black", Font.PLAIN, 22));
		lblResultado.setHorizontalAlignment(SwingConstants.CENTER);
		lblResultado.setBounds(86, 37, 267, 46);
		getContentPane().add(lblResultado);
		
		btnNo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				miVentana.cerrarJuego();
				dispose();
			}
		});

	
}
	public void setPuntuacion(int puntaje) {
		lblPuntaje.setText(""+puntaje);
	}
	
	public void setResultado(String texto) {
		lblResultado.setText(texto);
	}
}
