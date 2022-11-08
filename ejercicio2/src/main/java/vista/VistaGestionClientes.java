
package vista;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class VistaGestionClientes extends JFrame {

	
	private static final long serialVersionUID = 1L;
	public JLabel lnombre,lapellido,ldireccion,ldni,lfecha;
	public JTextField tnombre,tapellido,tdireccion,tdni,tfecha;
	public JButton bguarda,batras;
	
	public VistaGestionClientes() {
		getContentPane().setLayout(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 600, 600);
		
		
		lnombre=new JLabel("Nombre:");
		lnombre.setLayout(null);
		lnombre.setBounds(16, 62, 395, 20);
		tnombre= new JTextField(100);
		tnombre.setLocation(67, 62);
		tnombre.setSize(344, 20);
		tnombre.setLayout(null);
		
		lapellido= new JLabel("Apellido:");
		lapellido.setLayout(null);
		lapellido.setBounds(16, 93, 395, 20);
		tapellido= new JTextField(100);
		tapellido.setLocation(67, 93);
		tapellido.setSize(344, 20);
		tapellido.setLayout(null);
		
		ldireccion= new JLabel("Dirección:");
		ldireccion.setBounds(10, 124, 401, 20);
		ldireccion.setLayout(null);
		tdireccion= new JTextField(100);
		tdireccion.setLocation(67, 124);
		tdireccion.setSize(344, 20);
		tdireccion.setLayout(null);
		
		ldni= new JLabel("Dni:");
		ldni.setBounds(38, 155, 373, 20);
		ldni.setLayout(null);
		tdni= new JTextField(100);
		tdni.setLocation(67, 155);
		tdni.setSize(344, 20);
		tdni.setLayout(null);
		
		lfecha= new JLabel("Fecha:");
		lfecha.setBounds(24, 186, 387, 20);
		lfecha.setLayout(null);
		tfecha= new JTextField(100);
		tfecha.setLocation(67, 186);
		tfecha.setSize(344, 20);
		tfecha.setLayout(null);
		
		getContentPane().add(lnombre);
		getContentPane().add(tnombre);
		
		getContentPane().add(lapellido);
		getContentPane().add(tapellido);
		
		getContentPane().add(ldireccion);
		getContentPane().add(tdireccion);
		
		getContentPane().add(ldni);
		getContentPane().add(tdni);
		
		getContentPane().add(lfecha);
		getContentPane().add(tfecha);
		
		JLabel lblNewLabel = new JLabel("Inserta los datos del cliente");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(155, 37, 137, 14);
		getContentPane().add(lblNewLabel);
		
		bguarda= new JButton("Guarda");
		bguarda.setBounds(175, 217, 86, 20);
		getContentPane().add(bguarda);
		
		batras = new JButton("<");
		batras.setBounds(16, 253, 40, 40);
		getContentPane().add(batras);
		
	}
}
