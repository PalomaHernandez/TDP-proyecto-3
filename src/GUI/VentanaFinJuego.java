package GUI;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class VentanaFinJuego extends JDialog{
	
	private JLabel lblPuntaje;
//	private VentanaGUI miVentana;
	
	public VentanaFinJuego(VentanaGUI miVentana) {
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		getContentPane().setLayout(null);
		
		setResizable(true);
		setEnabled(true);
		
		JLabel lblNewLabel = new JLabel("PUNTUACI\u00D3N:");
		lblNewLabel.setFont(new Font("Segoe UI Black", Font.PLAIN, 18));
		lblNewLabel.setBounds(76, 47, 138, 26);
		getContentPane().add(lblNewLabel);
		
		lblPuntaje = new JLabel("");
		lblPuntaje.setFont(new Font("Segoe UI Black", Font.PLAIN, 18));
		lblPuntaje.setBounds(224, 47, 46, 23);
		getContentPane().add(lblPuntaje);
		
		JLabel lblNewLabel_1 = new JLabel("\u00BFDesea jugar de nuevo?");
		lblNewLabel_1.setFont(new Font("Segoe UI Black", Font.PLAIN, 14));
		lblNewLabel_1.setBounds(128, 145, 181, 26);
		getContentPane().add(lblNewLabel_1);
		
		JButton btnSi = new JButton("SI");
		btnSi.setBounds(125, 194, 89, 23);
		getContentPane().add(btnSi);
		
		btnSi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				miVentana.cerrarJuego();
				miVentana.reiniciarJuego();
				dispose();
			}
		});
		
		JButton btnNo = new JButton("NO");
		btnNo.setBounds(220, 194, 89, 23);
		getContentPane().add(btnNo);
		
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
}
