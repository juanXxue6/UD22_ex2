
package vista;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class VistaGeneral extends JFrame {
	
	private static final long serialVersionUID = 1L;
	public JButton bvideos,bclientes,bInsetarCliente,bInsertarVideo;
	public JLabel escoge;
	
	public VistaGeneral() {
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 600, 600);
		getContentPane().setLayout(null);
	
		
		escoge= new JLabel("Escoge una opción");
		escoge.setBounds(171, 75, 95, 20);
		
		bvideos= new JButton("Videos");
		bvideos.setBounds(87, 106, 95, 49);
		bclientes= new JButton("Clientes");
		bclientes.setBounds(256, 106, 95, 49);
		
		bInsetarCliente= new JButton("Insertar Cliente");
		bInsetarCliente.setBounds(87, 220, 95, 49);
		
		bInsertarVideo= new JButton("Insertar Video");
		bInsertarVideo.setBounds(256, 220, 95, 49);

		
		getContentPane().add(escoge);
		getContentPane().add(bvideos);
		getContentPane().add(bclientes);	
		getContentPane().add(bInsertarVideo);	
		getContentPane().add(bInsetarCliente);	
		
	}
	
}

