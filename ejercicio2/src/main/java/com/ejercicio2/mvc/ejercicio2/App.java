package com.ejercicio2.mvc.ejercicio2;

import controllers.Controlador;
import modelos.Db_model;
import vista.VistaCliente;
import vista.VistaGeneral;
import vista.VistaGestionClientes;
import vista.VistaGestionVideos;
import vista.VistaMostrarCliente;
import vista.VistaMostrarVideos;
import vista.VistaVideos;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
    	Db_model model = new Db_model("jdbc:mysql://192.168.1.190:3306","remote","Saraysofia2010*");
    	
    	
    	VistaCliente vc = new VistaCliente();
    	VistaGeneral vg = new VistaGeneral();
    	VistaGestionClientes vgc = new VistaGestionClientes();
    	VistaGestionVideos vgv = new VistaGestionVideos();
    	VistaMostrarCliente vmc = new VistaMostrarCliente();
    	VistaMostrarVideos vmv = new VistaMostrarVideos();
    	VistaVideos vv = new VistaVideos();
    	
    	Controlador controller = new Controlador(model, vc, vg, vgc, vgv, vmc, vmv, vv);
    	controller.iniciarVistaGeneral();
    }
}
