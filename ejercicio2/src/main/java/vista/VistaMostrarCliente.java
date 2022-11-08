
package vista;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.SwingConstants;
import javax.swing.JTextField;

public class VistaMostrarCliente extends JFrame {
	private static final long serialVersionUID = 1L;
	public JTextField lresultado;
	public JScrollPane scroll;
	public JButton bmuestratodo,bnombre,bapellido,bdireccion,bdni,bfecha,batras;
	
	public VistaMostrarCliente() {
		getContentPane().setLayout(null);
		

		setBounds(100, 100, 600, 600);
		
		lresultado=new JTextField("Resultados");
		lresultado.setEditable(false);
		lresultado.setHorizontalAlignment(SwingConstants.CENTER);
		lresultado.setBounds(10,11, 414,117);
		
		scroll= new JScrollPane(lresultado);
		scroll.setBounds(10,11, 414,117);
		
		bmuestratodo= new JButton("Muestra Todo");
		bmuestratodo.setBounds(29, 139, 117, 50);
		
		bnombre= new JButton("Muestra Nombres");
		bnombre.setBounds(156, 139, 117, 50);
		
		bapellido= new JButton("Muestra Apellidos");
		bapellido.setBounds(283, 139, 117, 50);
		
		bdni= new JButton("Muestra DNI");
		bdni.setBounds(108, 200, 117, 50);
		
		bfecha= new JButton("Muestra Fecha");
		bfecha.setBounds(235, 200, 117, 50);

		batras = new JButton("<");
		batras.setBounds(29, 271, 40, 40);

		getContentPane().add(scroll);
		getContentPane().add(bmuestratodo);
		getContentPane().add(bnombre);
		getContentPane().add(bapellido);
		getContentPane().add(bdni);
		getContentPane().add(bfecha);
		getContentPane().add(batras);
		
	}

}
