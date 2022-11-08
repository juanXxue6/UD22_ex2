
package vista;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class VistaGestionVideos extends JFrame {

	
	private static final long serialVersionUID = 1L;
	public JLabel ltitle,ldirector,lcliente,letiqueta;
	public JTextField ttitle,tdirector;
	public JComboBox<String> cbcliente;
	public JButton bguarda,batras;
	
	public VistaGestionVideos() {
		getContentPane().setLayout(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 600, 600);
		
		letiqueta = new JLabel("Inserta los datos del video");
		letiqueta.setHorizontalAlignment(SwingConstants.CENTER);
		letiqueta.setBounds(155, 37, 137, 14);
		
		ltitle=new JLabel("Título:");
		ltitle.setLayout(null);
		ltitle.setBounds(27, 62, 30, 20);
		ttitle= new JTextField(100);
		ttitle.setLocation(67, 62);
		ttitle.setSize(344, 20);
		ttitle.setLayout(null);
		
		ldirector= new JLabel("Director:");
		ldirector.setLayout(null);
		ldirector.setBounds(15, 93, 42, 20);
		tdirector= new JTextField(100);
		tdirector.setLocation(67, 93);
		tdirector.setSize(344, 20);
		tdirector.setLayout(null);
		
		lcliente= new JLabel("Cliente:");
		lcliente.setBounds(17, 124, 40, 20);
		lcliente.setLayout(null);
		cbcliente= new JComboBox<String>();
		cbcliente.setBounds(67, 124,344, 20);
		cbcliente.setLayout(null);

		bguarda= new JButton("Guarda");
		bguarda.setBounds(175, 217, 86, 20);
		
		batras = new JButton("<");
		batras.setBounds(16, 253, 40, 40);

		getContentPane().add(letiqueta);
		
		getContentPane().add(ltitle);
		getContentPane().add(ttitle);
		
		getContentPane().add(ldirector);
		getContentPane().add(tdirector);
		
		getContentPane().add(lcliente);
		getContentPane().add(cbcliente);
		
		getContentPane().add(bguarda);
		
		getContentPane().add(batras);
		
	}
}
