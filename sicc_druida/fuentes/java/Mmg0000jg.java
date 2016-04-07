/*
    Descripcion: Servlet de la aplicacion
    INDRA/CAR/siccdesa
    $Id: Mmg0000jg.java,v 1.1 2009/12/03 18:42:59 pecbazalar Exp $
*/

import es.indra.druida.DruidaServlet;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintStream;
import java.io.FileWriter;
import java.util.Date;


public class Mmg0000jg extends DruidaServlet {
	
	public Mmg0000jg() { };

         protected void inicio() throws Exception 
			 {

				  // Definicion del servlet
				  setServlet(getClass().getName());

				  // Definicion del path de las trazas
				  setTrazas(getClass().getName(), "/belcorpmmg/druida/logs");

				  // Definición del parser
				  setParser("jaxpv11");

				  // Asignacion de las variables para realizar el lookup del EJB
				  propiedad("EJB.CONTEXT");
				  propiedad("EJB.URL");
				  propiedad("EJB.USER");
				  propiedad("EJB.PASSWORD");
				  propiedad("EJB.CLASSES");

				  asignarPropiedades("Propiedades","druida.cfg");
				 
				  // Lectura de los XML de disco (Solo desarrollo)
				  setPropiedad("WEBSERVER","iplanet");
				  setPropiedad("XML","GUI","/belcorpmmg/druida/xml/gui");
				  setPropiedad("XML","DAT","/belcorpmmg/druida/xml/dat");
			}
}
