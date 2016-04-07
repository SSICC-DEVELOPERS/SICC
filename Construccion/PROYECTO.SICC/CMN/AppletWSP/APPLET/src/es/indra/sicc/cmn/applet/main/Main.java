package es.indra.sicc.cmn.applet.main;

import es.indra.sicc.dtos.prueba.DTOBuscarDatosCliente;
import es.indra.sicc.dtos.prueba.DTOCargaRegistroOnline;
import es.indra.sicc.dtos.prueba.DTODatosCliente;
import es.indra.sicc.dtos.prueba.DTOObtenerCargaInicial;
import es.indra.sicc.logicanegocio.prueba.MONRegistroOnline;
import es.indra.sicc.logicanegocio.prueba.MONRegistroOnlineHome;
import es.indra.sicc.util.prueba.Base64;

import es.indra.sicc.cmn.applet.util.Communicator;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.ObjectOutputStream;
import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.URLConnection;
import java.net.URLEncoder;
import java.util.Hashtable;

import javax.naming.Context;
import javax.naming.InitialContext;

import javax.rmi.PortableRemoteObject;

import java.net.*;
import java.io.*;

public class Main 
{
  public Main()
  {
  }
  
  public static void main(String []args) {
    Main main = new Main();
    DTOObtenerCargaInicial dtoCargaInicial = new DTOObtenerCargaInicial();
    dtoCargaInicial.setOidPais(new Long(1));
    dtoCargaInicial.setUser("usuario1");
    main.getDatosFromServlet("obtenerCargaInicial", 
                  "es.indra.sicc.dtos.prueba.DTOObtenerCargaInicial", 
                  dtoCargaInicial);
  }
  
   private Object getDatosFromServlet(String idBusiness, String nombreDTO, Object dto ) {
      Object object = null;
      
      /*try {
      this.lookupServidor();
      } catch(Exception e) {
        e.printStackTrace();
      }*/
      //Se serializa el objeto
      ByteArrayOutputStream baos = new ByteArrayOutputStream();
      try {
        ObjectOutputStream oos = new ObjectOutputStream(baos);
 
        oos.writeObject(dto);
        oos.flush();
      } catch (java.io.IOException e) {
        e.printStackTrace();
      }
      byte []serializedBytes = baos.toByteArray();
      // now you have the serialized bytes.
      
      serializedBytes = Base64.encode(serializedBytes);
      String serializedDto = new String(serializedBytes);
          
      //se arma el mensaje a ser enviado
      URLConnection urlConn = Communicator.createURLConnection("http://localhost:8080/pruebaAplet/appletPrueba");//http://cdos02ap:7777/sicc/servletPrueba");
      String content = "IDBusiness=" + idBusiness + "&DTOE=" + nombreDTO;
      content += "&DTOData=" + serializedDto;
      //content = URLEncoder.encode(content);
      //content = content.replaceAll(" ", "%20");
      Communicator com = new Communicator();
      com.postRequest(urlConn, content);
      byte[] response = com.receiveBinaryResponse(urlConn);

if(response == null || response.length == 0) {
  System.out.println("el response es null o 0: " +  response);      
} else {
      //se deserealiza la respuesta y se retorna el objeto
      //response = Base64.decode(response);
      
      ByteArrayInputStream bais = new ByteArrayInputStream(response);
      try {
System.out.println("antes del ois: ");    
        java.io.ObjectInputStream ois = new java.io.ObjectInputStream(bais);
System.out.println("antes del ois.read: ");    
       
        object = ois.readObject();
        
      } catch (java.io.IOException e) {
        e.printStackTrace();
      } catch (ClassNotFoundException e) {
        e.printStackTrace();
      }
}
      //this.getLocalAddress();
System.out.println("el object es: " + object);    
if (object instanceof DTOCargaRegistroOnline) 
{
System.out.println("es instancia " );      
}
      return object;
    }


      private MONRegistroOnline lookupServidor() throws Exception{
        Hashtable env = new Hashtable();
        // Standalone OC4J connection details
        env.put(Context.INITIAL_CONTEXT_FACTORY, "com.evermind.server.rmi.RMIInitialContextFactory");
        env.put(Context.SECURITY_PRINCIPAL, "admin");
        env.put(Context.SECURITY_CREDENTIALS, "belcorp");
        env.put(Context.PROVIDER_URL, "ormi://CDOS0035/mare");
        //env.put("dedicated.rmicontext", "false");
        
System.out.println("Antes de obtener el Contexto");
        Context context = new InitialContext(env);
        System.out.println("Obtuve el Contexto");
        Object o = context.lookup("MONRegistroOnline");
        //Object o = context.lookup("java:comp/env/MONTonto");
        MONRegistroOnlineHome mONRegistroOnlineHome = (
              MONRegistroOnlineHome)PortableRemoteObject.narrow(
                  o, MONRegistroOnlineHome.class);
        MONRegistroOnline mONRegistroOnline;
        System.out.println("Obteve la Interfaz");

        // Use one of the create() methods below to create a new instance
        mONRegistroOnline = mONRegistroOnlineHome.create();
        System.out.println("LLame al create");
      return mONRegistroOnline;
    }
}