//package es.indra.sicc.servlets.prueba;

import es.indra.mare.common.dto.IMareDTO;
import es.indra.mare.common.dto.MareDTO;
import es.indra.mare.common.exception.MareException;
import es.indra.mare.common.mgc.MareMGC;
import es.indra.mare.common.mii.MareMii;
import es.indra.mare.common.mii.MareTopic;
import es.indra.mare.common.mln.MareBusinessID;
import es.indra.mare.enterprise.mln.BusinessFacade;
import es.indra.mare.enterprise.mln.BusinessFacadeHome;
import es.indra.sicc.comunapplet.dtos.applet.DTOException;
import es.indra.sicc.comunapplet.dtos.applet.DTOSessionExpired;
import es.indra.sicc.util.BelcorpError;
import es.indra.sicc.util.DTOError;
import es.indra.sicc.util.UtilidadesLog;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;

import java.util.Enumeration;
import java.util.Hashtable;
import java.util.StringTokenizer;

import java.util.Vector;
import javax.naming.Context;
import javax.naming.InitialContext;

import javax.rmi.PortableRemoteObject;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.configuration.Configuration;
import org.apache.commons.configuration.PropertiesConfiguration;
//import es.indra.sicc.util.UtilidadesError;
//import es.indra.sicc.util.ped.applet.Base64;
//import es.indra.sicc.util.ped.applet.MONCaller;

public class ServletApplet extends HttpServlet {
  private BusinessFacade businessFacade = null;
  
  public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        UtilidadesLog.debug("La accion GET no es valida!!!");
        PrintWriter pw = response.getWriter();
        pw.print("La accion GET no es valida!!!");
    }
    
  public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
                    this.doRequest(request, response);
	}
    
  private void doRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    IMareDTO dtoS = null;
    
    //Valida la sesion
    //Si no hay sesion redirecciona a la pagina de logueo de sicc
    if( request.getSession(false) == null ){
      UtilidadesLog.debug("Session invalida");
      //response.sendRedirect("http://cdos02ap:7777/sicc/inicio2.html");
      //response.sendRedirect(response.encodeRedirectURL("http://cdos02ap:7777/sicc/servlet/sicc0000jg?ON=ObjetoCanal"));
      dtoS = new DTOSessionExpired();
    } else {
      DataInputStream inputFromApplet = null;
      PrintWriter out = null;
      BufferedReader inTest = null;
      String idBusiness = null;
      String dtoeNombre = null;
      String dtoDataString = null;
      try {  
          // get an input stream from the applet
          inputFromApplet = new DataInputStream(request.getInputStream());
        
          // read the serialized student data from applet        
          byte[]b = new byte[512*1024];
          int object = inputFromApplet.read(b);
          
          inputFromApplet.close();
          String stringRecibido = new String(b);
          StringTokenizer st = new StringTokenizer(stringRecibido, "&-&");
          
          while(st.hasMoreTokens()) {
            String auxToken = st.nextToken();
            //UtilidadesLog.debug("TOKEN: "+auxToken);
            String aux = auxToken.substring(0,auxToken.indexOf("="));
  
            if ("IDBusiness".equals(aux)) {
              idBusiness = auxToken.substring(auxToken.indexOf("=") + 1);
            } else if ("DTOE".equals(aux)) {
              dtoeNombre = auxToken.substring(auxToken.indexOf("=") + 1);
            } else if ("DTOData".equals(aux)) {
              dtoDataString = auxToken.substring(auxToken.indexOf("=") + 1);
            }          
          }
          
      }
      catch(Exception e) {
          UtilidadesLog.debug("Pincha al obtener datos por socket");
          UtilidadesLog.error("ERROR",e);
      }	
      
        UtilidadesLog.debug("idBusiness: "  + idBusiness);
        UtilidadesLog.debug("dtoeNombre: "  + dtoeNombre);
        //UtilidadesLog.debug("dtoDataString: "  + dtoDataString);

        byte[] dtoDataBytes = null;
        try {
          if (dtoDataString != null) {
            dtoDataBytes = new sun.misc.BASE64Decoder().decodeBuffer(dtoDataString);
          }
        } catch (Throwable t) 
        {
          UtilidadesLog.debug(t);
        }
  
        ByteArrayInputStream bais = new ByteArrayInputStream(dtoDataBytes);
        MareDTO abstractDto = null;
        
        try {
          java.io.ObjectInputStream ois = new java.io.ObjectInputStream(bais);
          abstractDto = (MareDTO)Class.forName(dtoeNombre).newInstance();
          abstractDto = (MareDTO) ois.readObject();
        } catch (java.io.IOException e) {
          UtilidadesLog.debug("Pincha al crear el dto");
          UtilidadesLog.error("ERROR",e);
        } catch (ClassNotFoundException e) {
          UtilidadesLog.debug("Pincha al crear el dto2");
          UtilidadesLog.error("ERROR",e);
        } catch (Exception e) {
          UtilidadesLog.debug("Pincha al crear el dto3");
          UtilidadesLog.error("ERROR",e);
        }
        
        try {
          String user = (String)request.getSession().getAttribute("DruidaUsuario");
          String password = (String)request.getSession().getAttribute("DruidaPassword");
          dtoS = ejecutarBusnessId((MareDTO)abstractDto,idBusiness, user, password);
        } catch(Throwable e) {
          UtilidadesLog.error("ERROR",e);
          DTOException dtoE = new DTOException();
          BelcorpError b = new BelcorpError();
          DTOError dto = null;
          try {
            dto = b.obtenerError(e);
          } catch (Throwable t) {
            UtilidadesLog.debug(t);  
          }
          //dtoE.setException((MareException)e);
          if (e instanceof MareException) {
            dtoE.setCodigo(((MareException)e).getCode());
          } else {
              dtoE.setCodigo(0);
          }
          UtilidadesLog.debug("Descripcion del error: " + dto.getDescripcionError());
          UtilidadesLog.debug("Codigo del error: " + dtoE.getCodigo());
          dtoE.setDescripcion(dto.getDescripcionError());
          dtoS = dtoE;
        }
      }
      
      UtilidadesLog.debug("se va a crearel ByteArray: " + dtoS);
      response.setContentType("application/x-www-form-urlencoded"); 
      
      ByteArrayOutputStream baos = new ByteArrayOutputStream();
      try {
        ObjectOutputStream oos = new ObjectOutputStream(baos);
 
        oos.writeObject(dtoS);
        oos.flush();
      } catch (java.io.IOException e) {
        UtilidadesLog.debug("ERROR",e);
      }
      
      response.getOutputStream().write(baos.toByteArray());
  }    
  
    private IMareDTO ejecutarBusnessId(MareDTO dto, String businessID, String user, String password) throws Exception {
        if (this.businessFacade == null) {
          this.businessFacade = this.lookupServidor(user, password);
        }
        MareBusinessID id = new MareBusinessID(businessID);
        IMareDTO dtoS  = this.businessFacade.execute(dto, id);
        return dtoS;
    }
    
    private BusinessFacade lookupServidor(String user, String password) throws Exception{
        Hashtable env = new Hashtable();
        
        Configuration conf = MareMii.getServiceConfiguration(MareMii.SERVICE_MGU);
        String providerUrl = conf.getString("provider");
        UtilidadesLog.debug("Obtuve el contexto " + providerUrl);
        
        env.put(Context.INITIAL_CONTEXT_FACTORY, "com.evermind.server.rmi.RMIInitialContextFactory");
        env.put(Context.SECURITY_PRINCIPAL, user);
        env.put(Context.SECURITY_CREDENTIALS, password);
        env.put(Context.PROVIDER_URL, providerUrl);

/*      if (user == null){
            //env.put(Context.SECURITY_PRINCIPAL, conf.getProperty("principal"));
             env.put(Context.SECURITY_PRINCIPAL, prin);
        }else{
            env.put(Context.SECURITY_PRINCIPAL, user);
        }
        if (password == null){
            //env.put(Context.SECURITY_CREDENTIALS, conf.getProperty("credential"));
             env.put(Context.SECURITY_CREDENTIALS, pass);
        }else{
            env.put(Context.SECURITY_CREDENTIALS, password);
        }

        env.put(Context.PROVIDER_URL, providerUrl);*/
        
        Context context = new InitialContext(env);
        UtilidadesLog.debug("Obtuve el contexto");
        BusinessFacadeHome businessFacadeHome = (BusinessFacadeHome)PortableRemoteObject.narrow(context.lookup("mare.mln.BusinessFacade"), BusinessFacadeHome.class);
        BusinessFacade businessFacade;

        // Use one of the create() methods below to create a new instance
        businessFacade = businessFacadeHome.create();
        return businessFacade;
    }

}