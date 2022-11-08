
package vista;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class VistaMostrarVideos extends JFrame {
	private static final long serialVersionUID = 1L;
	public JTextField lresultado;
	public JScrollPane scroll;
	public JButton bmuestratodo,btitle,bdirector,bcliente,batras;
	
	public VistaMostrarVideos() {
		getContentPane().setLayout(null);
		

		setBounds(100, 100, 600, 600);
		
		lresultado=new JTextField("Resultados");
		lresultado.setEditable(false);
		lresultado.setHorizontalAlignment(SwingConstants.CENTER);
		lresultado.setBounds(10,11, 414,117);
		
		scroll= new JScrollPane(lresultado);
		scroll.setBounds(10,11, 414,117);
		
		bmuestratodo= new JButton("Muestra Todo");
		bmuestratodo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		bmuestratodo.setBounds(56, 139, 141, 50);
		
		btitle= new JButton("Muestra Titulos");
		btitle.setBounds(217, 139, 141, 50);
		
		bdirector= new JButton("Muestra Directores");
		bdirector.setBounds(217, 200, 141, 50);
		
		bcliente= new JButton("Muestra Cliente");
		bcliente.setBounds(56, 200, 141, 50);
	

		batras = new JButton("<");
		batras.setBounds(29, 271, 40, 40);

		getContentPane().add(scroll);
		getContentPane().add(bmuestratodo);
		getContentPane().add(btitle);
		getContentPane().add(bdirector);
		getContentPane().add(bcliente);
		getContentPane().add(batras);
		
	}

}
