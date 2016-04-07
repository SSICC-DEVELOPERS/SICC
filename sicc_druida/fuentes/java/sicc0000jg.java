/*
    Descripcion: Servlet de la aplicacion
    INDRA/CAR/siccdesa
    $Id: sicc0000jg.java,v 1.1 2009/12/03 18:35:47 pecbazalar Exp $
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

import es.indra.druida.Contexto;

import es.indra.sicc.util.IVariablesSesion;

public class sicc0000jg extends DruidaServlet {

      /**
       * Constructor.
       */
      public sicc0000jg() {
      };

      protected void inicio() throws Exception {

      // Definicion del servlet
      setServlet(getClass().getName());


      // Definici?n del parser
      setParser("jaxpv11");

      // Asignacion de las variables para realizar el lookup del EJB
      propiedad("EJB.CONTEXT");
      propiedad("EJB.URL");
      propiedad("EJB.USER");
      propiedad("EJB.PASSWORD");
      propiedad("EJB.CLASSES");
	  propiedad("ESCAPA.ENTIDAD");
	  propiedad("ACCESOS");
	  propiedad("PAG.SIZE");
	  
	  // acceso al OC4J optimizado
	  propiedad("EJB.SESION");

	  // acceso a la variable temporal TMP.UPLOAD2
	  propiedad("TMP.UPLOAD2");

      asignarPropiedades("Propiedades","druida.cfg");
         
      // Lectura de los XML de disco (Solo desarrollo)
      setPropiedad("WEBSERVER","iplanet");
      setPropiedad("XML","GUI","");
      setPropiedad("XML","DAT","");

	  // carga variables mare
	  // Esto debe configurarse en cada puerto o servidor de aplicaciones.
	  // System.setProperty("MareConfigurationRoot", "/var/opt/siccdesa/mare/mare-conf");
	   
	  // Fichero de navegaci?n
	  // El archivo debe estar en el classpath
	  setNavegacion( Contexto.getPropiedad("ACCESOS"));
    }


		 protected synchronized String getPerfil(HttpServletRequest req) throws Exception {
                  
                  // guardamos idFuncion
                  String idFuncion = req.getParameter("idFuncion");
                  if (idFuncion != null) {
                           conectorParametroSesion("idFuncion", idFuncion, req);
                  }

                  // guardamos la variable del idioma
                  String strSiccIdioma = req.getParameter( "cdosIdioma" );
                  if ( strSiccIdioma != null ) {
                           conectorParametroSesion("cdosIdioma", strSiccIdioma, req);
                  }

                  // LP actual
                  String lp = getObjetoNegocio(false, req);

                  // guardamos el ON
                  String fromMenu = req.getParameter( "fromMenu" );
                  if ( ( fromMenu != null ) && (lp != null ) && ( fromMenu.equals("true") ) ) {
                           conectorParametroSesion("gLPVolver", lp, req);
                  }


                  System.out.println("ON="+lp);

                  setONRedir(lp, req);
                  
                  
                  if (lp == null) {
                           setONRedir( "LPTimeout", req);
                           // setONRedir("LPIdentificarUsuario", req);
                  } else {
                           if( 
                                    ( conectorParametroSesion(IVariablesSesion.MARE_CREDENTIALS, req) == null) && 
                                    ( !lp.equals("LPIdentificarUsuario") ) 
                                    && (!lp.equals("Druida")) && ( (lp.indexOf("LPPantallaError")) == -1 )
                           ) 
                           {
							        setONRedir( "LPTimeout", req);
                                    // setONRedir("LPIdentificarUsuario", req);
                           }
                  }

                  // devolvemos la salida
                  return "acceso";
         }
         

}




