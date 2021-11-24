package GUI;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Color;
import java.awt.Font;
import java.awt.Toolkit;

public class InstruccionesGUI extends JFrame{

	private static final long serialVersionUID = 1L;
	
	public InstruccionesGUI() {
		getContentPane().setBackground(Color.BLACK);
		setBackground(Color.WHITE);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 509, 513);
		setIconImage(Toolkit.getDefaultToolkit().getImage(InstruccionesGUI.class.getResource("/imagenes/logo-sirena.png")));
		setResizable(false);
		getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setBounds(0, 0, 503, 484);
		lblNewLabel.setIcon(new ImageIcon(InstruccionesGUI.class.getResource("/imagenes/instrucciones.png")));
		getContentPane().add(lblNewLabel);
	}
}
