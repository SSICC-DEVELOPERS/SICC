import es.indra.druida.DruidaConector;
import es.indra.mare.common.mln.MareBusinessID;
import es.indra.sicc.util.UtilidadesBelcorp;
import es.indra.sicc.util.UtilidadesSession;
import java.sql.Date;
import java.text.DateFormat;
import es.indra.mare.common.exception.MareException;
import org.apache.commons.configuration.PropertiesConfiguration;
import es.indra.mare.common.mgc.MareMGC;
import es.indra.mare.common.mii.MareMii;
import es.indra.mare.common.mii.MareMiiServiceNotFoundException;
import es.indra.mare.common.mii.MareTopic;
import java.text.SimpleDateFormat;
import java.util.Vector;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import es.indra.sicc.util.xml.XMLDocument;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Text;

public class LPActivarCobroVentaDirecta extends LPSICCBase {
    private Long pais = null;
    private Long idioma = null;
    private String accion =null;
    
    private XMLDocument xml = null;
    private Document doc = null;
    
   public void inicio() throws Exception{
      pagina("PGGestionCobrosDevoluciones");
    }

  public LPActivarCobroVentaDirecta() 
  {
    super();
  }   
    public void ejecucion() throws Exception {
    		this.rastreo();
        this.setTrazaFichero();
        this.asignarAtributoPagina( "cod", "0471" );
        this.getConfiguracionMenu("LPActivarCobroVentaDirecta");
        try{
            muestraPagina();
        }catch(Exception e){
            logStackTrace(e);
        }
    }

    private void muestraPagina() throws Exception{
      traza("*****muestraPagina PGGestionCobrosDevoluciones****************");
      //asignarAtributo("VAR","fechaSistema", "valor","11/02/05");
      String accion = conectorParametro("accion");
      Long oidPais = null;
      Long oidIdioma = null;
      String belcenter = "false";
      SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
      String fechaSistema = sdf.format(new java.util.Date());
      String user = null;
	  String url = this.getURL(oidPais, oidIdioma);
	  String ip = UtilidadesBelcorp.getIPCliente(this);
	  String login = this.getPaginaLogin();
	  Byte longCodClie = this.obtenerLongitudCodigoCliente();


      if("".equals(accion)|| accion==null) {
		oidPais = UtilidadesSession.getPais(this);      
		oidIdioma = UtilidadesSession.getIdioma(this);
		belcenter = "true";
		user = UtilidadesSession.getIdUsuario(this);
  		accion = "Cobro";
	  }
      
      traza("*****terminó de setear los valores****************");

      
	  asignarAtributo("VAR","accion", "valor", accion);

      xml = new XMLDocument();
      doc = xml.makeDocument("<DIV/>");
      Element applet = this.getApplet();
      applet.appendChild(this.getParam("oidPais", (oidPais == null ? "" : oidPais.toString())));
      applet.appendChild(this.getParam("fechaSistema",fechaSistema ));
      applet.appendChild(this.getParam("usuario", user));
      applet.appendChild(this.getParam("belcenter", belcenter));
      applet.appendChild(this.getParam("accion", accion));
      applet.appendChild(this.getParam("oidIdioma", (oidIdioma == null ? "" : oidIdioma.toString())));
	  applet.appendChild(this.getParam("url", (url == null ? "" : url.toString())));
	  applet.appendChild(this.getParam("ip", (ip == null ? "" : ip)));
	  applet.appendChild(this.getParam("login", (login == null ? "" : login)));
	  applet.appendChild(this.getParam("longitudCodigoCliente", (longCodClie == null ? "0" : longCodClie.toString())));
	
      DruidaConector con0 = new DruidaConector();         
      con0.setXML(applet);
         if (applet != null) {
           traza("PANTALLA ARMADA:---------");
           traza(con0.getXML());         
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
        applet.setAttribute("CODE","es.indra.sicc.bel.applet.GestorCobrosDevolucionesApplet.class"); 
				applet.setAttribute("WIDTH","710");
        applet.setAttribute("HEIGHT","480");
        applet.setAttribute("ALT","No se pudo correr el applet");
        applet.setAttribute("MAYSCRIPT","MAYSCRIPT");
        applet.setAttribute("ALIGN","center");
        applet.setAttribute("ARCHIVE","../lib/appletSICC.jar, " +
            "../lib/jaws.jar, ../lib/mare.jar, ../lib/cmn-negocio.jar, ../lib/entidades-ped.jar, " +
            "../lib/Utilidades_Belcorp.jar, ../lib/entidades-bel.jar");
        
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
