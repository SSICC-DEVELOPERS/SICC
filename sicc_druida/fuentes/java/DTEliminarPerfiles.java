//import DruidaTransactionComun;
import java.io.*;

import es.indra.druida.DruidaConector;
import es.indra.mare.common.mln.MareBusinessID;
import es.indra.sicc.dtos.men.DTOStrings;

import java.util.StringTokenizer;
import java.util.Vector;

public class DTEliminarPerfiles extends DruidaTransactionComun {
  private String parametros = null;
  private String BussID = null;

  public void ejecucion() throws Exception {
		/*Llamamos al metodo crearConectorResultado pasandole una cadena vacia si no
    capturamos ninguna excepcion o el resultado de llamar a
    obtenerMensajeError() pasandole la excepcion capturada*/
    
    try {      
      setTrazaFichero();
      traza("************ Entre a DTEliminarPerfiles");
      
      parametros = (String) getEntrada("parametros");
      BussID = (String) getEntrada("idBusiness");

      traza("************ parametros " + parametros);
      traza("************ BussID " + BussID);
  
    	StringTokenizer st1 = new StringTokenizer(parametros,"~");
      int cant = st1.countTokens();
      traza("************ cant " + cant);
      
      String[] array = new String[cant];

      int i = 0;      
      while(st1.hasMoreTokens()) {
        String elementoI = st1.nextToken();
        array[i] = elementoI;
        i++; 
			}

      DTOStrings dto = new DTOStrings();
      dto.setValor(array);
	  String usuario = (String)conectorParametroSesion("DruidaUsuario");
      String contrasenia = (String)conectorParametroSesion("DruidaPassword");
	  dto.setUsuario(usuario);
	  dto.setPassword(contrasenia);

      MareBusinessID businessID = new MareBusinessID(BussID);
      
      Vector parametros = new Vector();
      parametros.add(dto);
      parametros.add(businessID);

      traza("**************** Antes de conectar con ConectorEliminar");
      DruidaConector con = conectar("ConectorEliminar", parametros);
      traza("**************** Despues de conectar con ConectorEliminar");

      traza("**************** Antes de llamar a crearConectorResultado");
      DruidaConector conector = crearConectorResultado("");
      traza("**************** Despues de llamar a crearConectorResultado");
      setConector(conector);      
    }   
    catch(Exception ex) {
      String mensaje = obtenerMensajeError(ex);
      DruidaConector conector = crearConectorResultado(mensaje);     
      setConector(conector);
/*      DruidaConector conector = crearConectorResultado("hgfjhgfjhgfhgfjhgf7657865");
      setConector(conector);*/
      traza("Exception: " + ex );
 	  logStackTrace(ex);
    }
  }

  private void logStackTrace(Throwable e) {
     ByteArrayOutputStream os = new ByteArrayOutputStream();
          PrintStream ps = new PrintStream(os);

          e.printStackTrace(ps);
     try {
                  traza("Se produjo la excepcion: " 
                           + e.getMessage() 
                           + "\n" 
                           + "stackTrace = " 
                      + os.toString());
     }
     catch (Exception ex) {
         //traza ("Error en logStackTrace: " + ex.getMessage ());
                  e.printStackTrace ();
     }
   }
}