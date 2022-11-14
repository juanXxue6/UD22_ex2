package controllers;

import java.awt.EventQueue;
import java.awt.HeadlessException;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import modelos.Db_model;
import vista.VistaCliente;
import vista.VistaGeneral;
import vista.VistaGestionClientes;
import vista.VistaGestionVideos;
import vista.VistaMostrarCliente;
import vista.VistaMostrarVideos;
import vista.VistaVideos;

public class Controlador implements ActionListener {

	private Db_model modelo;
	
	ResultSet resultSet;
	String query;
	private String subQueryWhere = "";
	private String sbQuerySelect = "";

	private VistaCliente vc;
	private VistaGeneral vg ;
	private VistaGestionClientes vgc;
	private VistaGestionVideos vgv;
	private VistaMostrarCliente vmc;
	private VistaMostrarVideos vmv;
	private VistaVideos vv;
	
	String[] datosClientes = new String[5];
	String[] camposClientes = {"nombre","apellido","direccion","dni","fecha"};
	
	String[] datosVideos = new String[3];
	String[] camposVideos = {"title","director","cli_id"};
	
	
	boolean isInsertAlredy = false;
	public Controlador(Db_model modelo, VistaCliente vc, VistaGeneral vg, VistaGestionClientes vgc,
			VistaGestionVideos vgv, VistaMostrarCliente vmc, VistaMostrarVideos vmv, VistaVideos vv) {
		this.modelo = modelo;
		this.vc = vc;
		this.vg = vg;
		this.vgc = vgc;
		this.vgv = vgv;
		this.vmc = vmc;
		this.vmv = vmv;
		this.vv = vv;
		
		iniciarServicios();
		
		
	}

	private void iniciarServicios() {
		
		vv.batras.addActionListener(this);
		vv.gestionaBD.addActionListener(this);
		vv.muestraBD.addActionListener(this);
		
		vc.batras.addActionListener(this);
		vc.gestionaBD.addActionListener(this);
		vc.muestraBD.addActionListener(this);
		
		vmc.bapellido.addActionListener(this);
		vmc.batras.addActionListener(this);
		//vmc.bdireccion.addActionListener(this);
		vmc.bdni.addActionListener(this);
		vmc.bfecha.addActionListener(this);
		vmc.bmuestratodo.addActionListener(this);
		vmc.bnombre.addActionListener(this);
		
		vmv.batras.addActionListener(this);
		vmv.bcliente.addActionListener(this);
		vmv.bdirector.addActionListener(this);
		vmv.bmuestratodo.addActionListener(this);
		vmv.btitle.addActionListener(this);
		
		vg.bclientes.addActionListener(this);
		vg.bvideos.addActionListener(this);
		vg.bInsertarVideo.addActionListener(this);
		vg.bInsetarCliente.addActionListener(this);
		
		vgv.batras.addActionListener(this);
		vgv.bguarda.addActionListener(this);
		
		vgc.batras.addActionListener(this);
		vgc.bguarda.addActionListener(this);
		
		
		modelo.startConnection();
		modelo.useDB("ud22_2");	
	}
		
	public void iniciarVistaGestionVideo() {
		vgv.setTitle("Vista gestion video");
		vgv.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		vgv.setLocationRelativeTo(null);
		vgv.setVisible(true);	
	}
	public void iniciarVistaGestionCliente() {
		vgc.setTitle("Vista gestion cliente");
		vgc.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		vgc.setLocationRelativeTo(null);
		vgc.setVisible(true);	
	}	
	public void iniciarVistaGeneral() {
		vg.setTitle("Vista general");
		vg.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		vg.setLocationRelativeTo(null);
		vg.setVisible(true);	
	}
	public void iniciarVistaMostrarVideo() {
		vmv.setTitle("Vista mostrar video");
		vmv.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		vmv.setLocationRelativeTo(null);
		vmv.setVisible(true);	
	}
	public void iniciarVistaMostrarCliente() {
		vmc.setTitle("Vista mostrar cliente");
		vmc.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		vmc.setLocationRelativeTo(null);
		vmc.setVisible(true);	
	}	
	public void iniciarVistaCliente() {
		vc.setTitle("Vista cliente");
		vc.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		vc.setLocationRelativeTo(null);
		vc.setVisible(true);	
	}	
	public void iniciarVistaVideo() {
		vv.setTitle("Vista video");
		vv.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		vv.setLocationRelativeTo(null);
		vv.setVisible(true);		
	}
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
				
		if(vv.batras == e.getSource() || vc.batras == e.getSource() ||vmc.batras == e.getSource() ||vmv.batras == e.getSource() ||
				vgv.batras == e.getSource() ||vgc.batras == e.getSource() ) {
			iniciarVistaGeneral();
		}
		
		else if (vmv.bmuestratodo == e.getSource()) {
			showData(null,null,"videos",vmv.lresultado);
		}
		
		
		else if (vmc.bmuestratodo == e.getSource()) {
			showData(null,null,"cliente",vmc.lresultado);
		}
			
		
		else if(vmc.bnombre == e.getSource()) {		
			showData(camposClientes[0],null,"cliente",vmc.lresultado);
		} 
		
		
		else if(vmc.bapellido == e.getSource()) {
			showData(camposClientes[1],null,"cliente",vmc.lresultado);	
			
		} else if(vmc.bdireccion == e.getSource()) {
			showData(camposClientes[2],null,"cliente",vmc.lresultado);
		
		}else if(vmc.bdni == e.getSource()) {		
			showData(camposClientes[3],null,"cliente",vmc.lresultado);
		}
		else if(vmc.bfecha == e.getSource()) {
			showData(camposClientes[4],null,"cliente",vmc.lresultado);
		}
		
		

		else if(vmv.btitle == e.getSource()) {			
			showData(camposVideos[0],null,"videos",vmv.lresultado);
		} 	
		else if(vmv.bdirector == e.getSource()) {
			showData(camposVideos[1],null,"videos",vmv.lresultado);	
			
		} else if(vmv.bcliente == e.getSource()) {
			showData(camposVideos[2],null,"videos",vmv.lresultado);
		}
			
		
		
		else if(vg.bclientes == e.getSource()) {
			iniciarVistaMostrarCliente();
		}
		
		else if(vg.bvideos == e.getSource()) {
			iniciarVistaMostrarVideo();
		}
		
		else if(vg.bInsertarVideo == e.getSource()) {
			llenarComboBoxVideos();
			iniciarVistaGestionVideo();
		}
		
		else if(vg.bInsetarCliente == e.getSource()) {
			iniciarVistaGestionCliente();
		}

		
		else if(vgc.bguarda == e.getSource()) {
			
			System.out.println("kakaka");
			
			
			datosClientes[0] = vgc.tnombre.getText();
			datosClientes[1] = vgc.tapellido.getText();
			datosClientes[2] = vgc.tdireccion.getText();
			datosClientes[3] = vgc.tdni.getText();
			datosClientes[4] = null;
			

			subQueryWhere = " where " +  camposClientes[3] +  " = " + datosClientes[3];
			resultSet = modelo.getData("cliente", "dni", subQueryWhere);
			

			try {
				isInsertAlredy = resultSet.next();
				System.out.println(isInsertAlredy);
			} catch (SQLException e2) {
				// TODO Auto-generated catch block
				e2.printStackTrace();
			}
			
				try {
					if(!isInsertAlredy) {
						try {
							//System.out.println(exist.next());
							query = "INSERT INTO cliente" +  " (nombre,apellido,direccion,dni,fecha) VALUES ( "
									+ "'" + datosClientes[0] + "'" + ", "
									+ "'" + datosClientes[1] + "'" + ", "
									+ "'" + datosClientes[2] + "'" + ", "
									+ "'" + datosClientes[3] + "'" + ", "
									+ "" + datosClientes[4] + "" + " ) ";
							
						modelo.insertData(query,"cliente");
						JOptionPane.showMessageDialog(null, "Datos insertados correctamente");
						}catch (Exception ex) {
							JOptionPane.showMessageDialog(null,"error al insertar:\n " + ex, "error de insercion", JOptionPane.ERROR_MESSAGE, null);
						}
					}
					else {
						try {

							query = "Update cliente "  +
									"set "  + camposClientes[0] + " = '" + datosClientes[0] +"' , " +
									camposClientes[1] + " = '" + datosClientes[1] +"' , " +
									camposClientes[2] + " = '" + datosClientes[2] +"' , " +
									camposClientes[3] + " = '" + datosClientes[3] +"' , " +
									camposClientes[4] + " = " + datosClientes[4] +"  " 
									+ " where " + camposClientes[3] + " = " + datosClientes[3] + ";";
							
							
							JOptionPane.showMessageDialog(null, "Datos actualizados correctamente");
						} catch (Exception ex) {
							JOptionPane.showMessageDialog(null,"error al actualizar:\n  " + ex, "error de insercion", JOptionPane.ERROR_MESSAGE, null);

						}

					}
				} catch (HeadlessException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			
			
			iniciarVistaGeneral();
					
	
		}
		
	else if(vgv.bguarda == e.getSource()) {
				
				System.out.println("kakaka");
				
				
				datosVideos[0] = vgv.ttitle.getText();
				datosVideos[1] = vgv.tdirector.getText();
				datosVideos[2] = selectIdFromDni((String) vgv.cbcliente.getSelectedItem());

				
	
				subQueryWhere = " where " +  camposVideos[0] +  " = '" + datosVideos[0] + "'";
				resultSet = modelo.getData("videos", "director", subQueryWhere);
				
	
				try {
					isInsertAlredy = resultSet.next();
					System.out.println(isInsertAlredy);
				} catch (SQLException e2) {
					// TODO Auto-generated catch block
					e2.printStackTrace();
				}
				
					try {
						if(!isInsertAlredy) {
							try {
								//System.out.println(exist.next());
								query = "INSERT INTO videos" +  " (title,director,cli_id) VALUES ( "
										+ "'" + datosVideos[0] + "'" + ", "
										+ "'" + datosVideos[1] + "'" + ", "
										+ "" + datosVideos[2] + "" + " ) ";
								
							modelo.insertData(query,"videos");
							JOptionPane.showMessageDialog(null, "Datos insertados correctamente");
							}catch (Exception ex) {
								JOptionPane.showMessageDialog(null,"error al insertar:\n " + ex, "error de insercion", JOptionPane.ERROR_MESSAGE, null);
							}
						}
						else {
							try {
	
								query = "Update videos "  +
										"set "  + camposVideos[0] + " = '" + datosVideos[0] +"' , " +
										camposVideos[1] + " = '" + datosVideos[1] +"' , " +
										camposVideos[2] + " = '" + datosVideos[2] +"' , " +
										" where " + camposVideos[1] + " = " + datosVideos[1] + ";";
								
								
								JOptionPane.showMessageDialog(null, "Datos actualizados correctamente");
							} catch (Exception ex) {
								JOptionPane.showMessageDialog(null,"error al actualizar:\n  " + ex, "error de insercion", JOptionPane.ERROR_MESSAGE, null);
	
							}
	
						}
					} catch (HeadlessException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				
				
				iniciarVistaGeneral();
						
		
			}
			
		
	}
	
	
	private void showData(String subConsultaSelect, String subConsultaWhere, String tabla,JTextField textField) {
		try {
			String enseñarLbl = "";
			
		resultSet = modelo.getData(tabla, subConsultaSelect, subConsultaWhere);
		System.out.println(resultSet.next());
		ResultSetMetaData rsmd = resultSet.getMetaData();			
		int columnsNumber = rsmd.getColumnCount();
		while (resultSet.next()) {
		    for (int i = 1; i <= columnsNumber; i++) {
		        if (i > 1) System.out.print(" | ");
		        String columnValue = resultSet.getString(i);
		        System.out.print(rsmd.getColumnName(i) + ": " + columnValue);
		        enseñarLbl += rsmd.getColumnName(i) + ": " + columnValue + " | ";
		        
		        
		    }
	        enseñarLbl += "\n";
		    System.out.println("");
		}
		textField.setText(enseñarLbl);
		}catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

	}
	
	
	private void llenarComboBoxVideos() {
		int i = 0;
		resultSet = modelo.getData("cliente", "dni",null);	
		try {
			while(resultSet.next()) {
				vgv.cbcliente.addItem(resultSet.getString(1));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	private String selectIdFromDni(String comboBoxOption) {
		String result = "";
		subQueryWhere = " where dni = " + comboBoxOption;
		resultSet = modelo.getData("cliente", "id", subQueryWhere);	
		try {
			while(resultSet.next()) {
				result = resultSet.getString(1);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("ID: " + result);
		return result;
	}
	
}
