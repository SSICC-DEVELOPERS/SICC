/**
 * Copyright 2003 ® por Indra Sistemas,S.A.. Todos los derechos reservados.
 * Avda. de Bruselas, 35
 * Parque Empresarial Arroyo de la Vega
 * 28108 Alcobendas, Madrid
 * España
 *
 * Privado y Confidencial.
 * La información contenida en este documento es propiedad de Indra sistemas.
 * Para uso exclusivo de empleados autorizados no permitiéndose
 * la distribución de este código sin permiso expreso.
 */
package es.indra.sicc.util;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

// -------------------------------------------------------------------------------
// ssantana
import java.net.Authenticator;
import java.net.URL;
import java.net.URLConnection;
import java.net.MalformedURLException;

import java.io.InputStreamReader;

import es.indra.mare.common.mgc.MareMGC;
import es.indra.mare.common.mii.MareMii;
import es.indra.mare.common.mii.MareMiiServiceNotFoundException;
import es.indra.mare.common.exception.MareException;

import es.indra.mare.common.mii.MareTopic;
import es.indra.mare.common.mii.services.MareServiceException;
import es.indra.mare.common.mii.services.jdbcservice.RecordSet;
import es.indra.mare.common.mii.services.logging.LoggingService;
import es.indra.sicc.util.BelcorpAuthenticator;

import org.apache.commons.configuration.PropertiesConfiguration;
// ------------------------------------------------------------------------------


public class UtilidadesFiles {
   public static void copiarArchivo(String origen, String destino)
      throws FileNotFoundException, IOException {
      FileWriter fw = null;
      FileReader fr = null;
      BufferedReader br = null;
      BufferedWriter bw = null;
      File source = null;

      fr = new FileReader(origen);
      fw = new FileWriter(destino);
      br = new BufferedReader(fr);
      bw = new BufferedWriter(fw);

      /* Determine the size of the buffer to allocate */
      source = new File(origen);

      int fileLength = (int) source.length();

      char[] charBuff = new char[fileLength];

      while (br.read(charBuff, 0, fileLength) != -1)
         bw.write(charBuff, 0, fileLength);

      if (br != null) {
         br.close();
      }

      if (bw != null) {
         bw.close();
      }
   }


    /* abrirFichero: abre el fichero y lo devuelve como BufferedReader
     * 
     */
    public static BufferedReader abrirFichero(String fichero) throws MareException
    {
	 
        BufferedReader b = null;
        String ctxLog = "MONCargarListaClientes ";
        final String APPLICATION_PROP = "application.properties";
        String ficheroPath = null;
        String user = null;
        String password = null;
        String fileFullPath = null;

        MareMGC mgc = null;
        // vbongiov -- 28/10/2008
        mgc  = (MareMGC)MareMii.getService(new MareTopic(MareMii.SERVICE_MGC));
    
        ficheroPath = (String) mgc.getProperty("application.uploadURL");          
        user = (String) mgc.getProperty("application.uploadURL.user");          
        password = (String) mgc.getProperty("application.uploadURL.password");   
        UtilidadesLog.debug("user: " + user);
        UtilidadesLog.debug("password: " + password);
    
        UtilidadesLog.debug("ficheroPath: " + ficheroPath);
          
        if (ficheroPath==null || ficheroPath.equals("")) {
          ficheroPath="";
        }
        

        Authenticator.setDefault(new BelcorpAuthenticator(user, password));

        UtilidadesLog.debug(ficheroPath + fichero);

        fileFullPath = ficheroPath + fichero;
        try {
            UtilidadesLog.debug(" - abrirFichero(" + fileFullPath + ")");   

            UtilidadesLog.debug("1");
            URL url = new URL(fileFullPath);

            UtilidadesLog.debug("2");
            URLConnection con = url.openConnection();
            UtilidadesLog.debug("3");
            con.connect();
            UtilidadesLog.debug("4");

            b = new BufferedReader(new InputStreamReader(con.getInputStream()));
            
            UtilidadesLog.debug("Ready...? " + b.ready());
            /*
            if ( !b.ready() ) {
              throw new IOException("Not ready...");
            }*/

            UtilidadesLog.debug("5");
        } catch (FileNotFoundException ex) {
            UtilidadesLog.error(ex);        
            UtilidadesLog.debug(" ==== FILE NOT FOUND EXCEPTION ===== ");
            String codigo = CodigosError.ERROR_ARCHIVO_NO_ENCONTRADO;
            //throw new MareException("Error al abrir el fichero "+fileFullPath, ex, 120070006);
            throw new MareException(ex, UtilidadesError.armarCodigoError(codigo));
        } catch (java.net.MalformedURLException mfe) {  
            UtilidadesLog.error(mfe);        
            UtilidadesLog.debug(" ==== ERROR EN LA URL  ===== " + fileFullPath);
            String codigo = CodigosError.ERROR_ARCHIVO_NO_ENCONTRADO;            
            //throw new MareException("Error al abrir el fichero "+fileFullPath, mfe, 120070006);
            throw new MareException(mfe, UtilidadesError.armarCodigoError(codigo));
        } catch (java.io.IOException ioe) {
            UtilidadesLog.error(ioe);
            UtilidadesLog.debug(" ==== ERROR DE IO ===== " + fileFullPath);
            String codigo = CodigosError.ERROR_DE_LECTURA_DE_ARCHIVO;            
            throw new MareException(ioe, UtilidadesError.armarCodigoError(codigo));
        }
  
        return b;
 
    }  
}
