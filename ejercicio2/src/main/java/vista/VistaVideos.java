
package vista;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class VistaVideos extends JFrame {
	
	private static final long serialVersionUID = 1L;
	public JButton gestionaBD,muestraBD,batras;
	public JLabel escoge;
	
	public VistaVideos() {
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 600, 600);
		getContentPane().setLayout(null);
	
		
		escoge= new JLabel("Escoge una opción");
		escoge.setBounds(171, 75, 95, 20);
		gestionaBD= new JButton("Gestiona BD");
		gestionaBD.setBounds(87, 106, 95, 49);
		muestraBD= new JButton("Muestra BD");
		muestraBD.setBounds(256, 106, 95, 49);
		
		batras = new JButton("<");
		batras.setBounds(29, 271, 40, 40);

		
		getContentPane().add(escoge);
		getContentPane().add(gestionaBD);
		getContentPane().add(muestraBD);	
		getContentPane().add(batras);
		
	}
	
}

