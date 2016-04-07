import es.indra.druida.DruidaConector;
import es.indra.mare.common.mii.services.jdbcservice.RecordSet;
import es.indra.mare.common.mln.MareBusinessID;
import es.indra.sicc.util.DTOOID;
import es.indra.sicc.util.DTOSalida;
import es.indra.sicc.util.UtilidadesBelcorp;
import es.indra.sicc.util.UtilidadesSession;
import java.io.IOException;
import java.sql.Date;
import java.text.DateFormat;
import es.indra.mare.common.exception.MareException;
import es.indra.mare.common.mgc.MareMGC;
import es.indra.mare.common.mii.MareMii;
import es.indra.mare.common.mii.MareMiiServiceNotFoundException;
import es.indra.mare.common.mii.MareTopic;
import java.text.SimpleDateFormat;
import java.util.Vector;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import es.indra.sicc.util.xml.XMLDocument;

import org.apache.commons.configuration.PropertiesConfiguration;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Text;

public class LPRegistroOnline extends LPSICCBase {
    private Long pais = null;
    private Long idioma = null;
    private String accion =null;
    
    private XMLDocument xml = null;
    private Document doc = null;
    
   public void inicio() throws Exception{
      pagina("contenido_registro_online");
    }

  public LPRegistroOnline() 
  {
    super();
  }
    public void ejecucion() throws Exception {
        this.setTrazaFichero();
        try{
            muestraPagina();
        }catch(Exception e){
            logStackTrace(e);
        }
    }

    private void muestraPagina() throws Exception{
      traza("*****muestraPagina(****************");
      pagina("contenido_registro_online");
      //asignarAtributo("VAR","fechaSistema", "valor","11/02/05");
      
      // splatas - 24/11/2005 - INC.21405
      getConfiguracionMenu("LPRegistroOnline","Registrar");
      asignarAtributoPagina("cod", "01021");
      
      String accion = conectorParametro("accion");
      String ip = UtilidadesBelcorp.getIPCliente(this);
      Long oidPais = UtilidadesSession.getPais(this);
      String user = UtilidadesSession.getIdUsuario(this);
      Long oidIdioma = UtilidadesSession.getIdioma(this);
      Long oidAcceso = UtilidadesSession.getAccesoPorDefecto(this);
      Long oidSubacceso = UtilidadesSession.getSubaccesoPorDefecto(this);
      Integer oidCanal = UtilidadesSession.getCanal(this);
      String belcenter = "true";
      String oidCliente = "";
      String oidTipoCliente = "";
      String oidTipoSolicitud = "";
      SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
      String fechaSistema = sdf.format(new java.util.Date());
	  String url = this.getURL(oidPais, oidIdioma);
	  String login = this.getPaginaLogin();
	  Byte longCodClie = this.obtenerLongitudCodigoCliente();
      
      if(accion != null && "callcenter".equalsIgnoreCase( accion )) {
        oidCliente = conectorParametro("oidCliente");
        oidTipoCliente = conectorParametro("oidTipoCliente");
        oidTipoSolicitud = conectorParametro("oidTipoSolicitud");	
        belcenter = "false";
      }
      
      traza("*****terminó de setear los valores****************");
      
      //traza("1");
      xml = new XMLDocument();
      //traza("2 " + xml);
      doc = xml.makeDocument("<DIV/>");
      //traza("3 " + doc);
      Element applet = this.getApplet();
      //traza("4 " + applet);
      applet.appendChild(this.getParam("oidPais", (oidPais == null ? "" : oidPais.toString())));
      applet.appendChild(this.getParam("fechaSistema",fechaSistema ));
      applet.appendChild(this.getParam("user", user));
      applet.appendChild(this.getParam("oidCliente", (oidCliente == null ? "" : oidCliente.toString())));
      applet.appendChild(this.getParam("oidTipoCliente", (oidTipoCliente == null ? "" : oidTipoCliente.toString())));
      applet.appendChild(this.getParam("oidTipoSolicitud", (oidTipoSolicitud == null ? "" : oidTipoSolicitud.toString())));
      applet.appendChild(this.getParam("belcenter", belcenter));
      applet.appendChild(this.getParam("oidIdioma", (oidIdioma == null ? "" : oidIdioma.toString())));
      applet.appendChild(this.getParam("ip", ip));
      applet.appendChild(this.getParam("oidAcceso", (oidAcceso == null ? "" : oidAcceso.toString())));
      applet.appendChild(this.getParam("oidSubacceso", (oidSubacceso == null ? "" : oidSubacceso.toString()) ));
      applet.appendChild(this.getParam("oidCanal", (oidCanal == null ? "" : oidCanal.toString())));
      applet.appendChild(this.getParam("url", (url == null ? "" : url.toString())));
	  applet.appendChild(this.getParam("login", (login == null ? "" : login)));
	  applet.appendChild(this.getParam("longitudCodigoCliente", (longCodClie == null ? "0" : longCodClie.toString())));

      DruidaConector con0 = new DruidaConector();         
      con0.setXML(applet);
         if (applet != null) {
           asignar("REJILLA","parametrosApplet",con0);
         }

    }
    
    
    private void logStackTrace(Throwable e) throws Exception {
        traza("Se produjo la excepcion: " + e.getMessage());

        ByteArrayOutputStream pila = new ByteArrayOutputStream();
        PrintStream out = new PrintStream(pila);

        if (e instanceof MareException) {
            MareException e2 = (MareException) e;
            traza("Es una mare Exception con codigo de error: " + e2.getCode());
        }

        e.printStackTrace(out);
        traza("stack Trace : " + pila.toString()); 
    }
    
    private Element getApplet() {        
        Element applet = doc.createElement("APPLET");
        applet.setAttribute("NAME","app1");
        applet.setAttribute("CODE","es.indra.sicc.ped.applet.RegistroOnlineApplet.class"); 
		applet.setAttribute("WIDTH","820");
        applet.setAttribute("HEIGHT","900");
        applet.setAttribute("ALT","No se pudo correr el applet");
        applet.setAttribute("MAYSCRIPT","MAYSCRIPT");
        applet.setAttribute("ALIGN","center");
        applet.setAttribute("ARCHIVE","../lib/appletSICC.jar, " +
            "../lib/jaws.jar, ../lib/mare.jar, ../lib/cmn-negocio.jar, ../lib/entidades-ped.jar, " +
            "../lib/Utilidades_Belcorp.jar, ../lib/entidades-bel.jar");
/*        applet.setAttribute("ARCHIVE","../lib/appletSICC.jar, " +
            "../lib/jaws.jar, ../lib/mare.jar, ../lib/cmn-negocio.jar, ../lib/entidades-ped.jar, " +
            "../lib/Utilidades_Belcorp.jar, ../lib/entidades-bel.jar, ../lib/commons-logging-1.1.jar");*/
        
        return applet;
    }
    
    private Element getParam(String nombre, String VALUE){
				Element param = doc.createElement("PARAM")   ;
				param.setAttribute("NAME",nombre);
				param.setAttribute("VALUE",VALUE);
				
				return param;
    }

	private String getURL(Long pais, Long idioma) throws Exception {
		MareMGC mgc;
        String salida;
        mgc = (MareMGC)MareMii.getService(new MareTopic("Configuration"));
        salida = (String)mgc.getProperty("nombre-servlet-applet");
        //traza("Salida getURL " + salida); 
		return salida;
	}
    
	public String getPaginaLogin() throws Exception {
		MareMGC mgc;
        String salida;
        mgc = (MareMGC)MareMii.getService(new MareTopic("Configuration"));
        salida = (String)mgc.getProperty("paginaLogin");
        //traza("Salida getPaginaLogin " + salida); 
		return salida;
	}
          
}
