/*
 * Copyright 2002 © por Indra Sistemas,S.A.. Todos los derechos reservados.
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

package es.indra.sicc.cmn.negocio.batch;

import es.indra.sicc.util.SecuenciadorOID;
import java.net.InetAddress;
import java.util.Date;

import es.indra.mare.common.dto.IMareDTO;
import es.indra.mare.common.dto.MareDTO;
import es.indra.mare.common.mln.MareBusinessID;
import java.util.Random;


/**
 * @author fcuenca
 *
 * To change the template for this generated type comment go to
 * Window>Preferences>Java>Code Generation>Code and Comments
 */
public class DTOBatch extends MareDTO {
  
  private static final String IDONLINE_PROPERTY  = "IDOnline";
  private static final String DTOONLINE_PROPERTY = "DTOOnline";
  private static final String PROCESSID_PROPERTY = "ProcessID";
  private static final String USER_PROPERTY      = "User";
  
  // sapaza -- PER-SiCC-2010-0242 -- 09/07/2010
  private static final int ANCHO_CODIGO_PROCESO = 50;
  
  public DTOBatch(String nombre, MareBusinessID IDOnline, IMareDTO DTOOnline) {
  	super();
  	addProperty(IDONLINE_PROPERTY,IDOnline);
  	addProperty(DTOONLINE_PROPERTY, DTOOnline);
    String address = null;
    /*try{
    address = InetAddress.getLocalHost().getHostAddress();
    }catch (Exception e){
        throw new RuntimeException("NO SE PUDO ENCOLAR");
    }*/
    Long secuencia = null;
    try{
        secuencia = SecuenciadorOID.obtenerSiguienteValor("GEN_PROC_SEQ");
    }catch (Exception e){
        throw new RuntimeException("NO SE PUDO ENCOLAR");
    }
  	//long timeStamp = (new Date()).getTime();   

  	// sapaza -- PER-SiCC-2010-0242 -- 09/07/2010    
        String nombreSecuencia = obtenerNombreSecuencia(nombre, secuencia.toString());
    	addProperty(PROCESSID_PROPERTY, nombreSecuencia);
  }
  
  public DTOBatch(String nombre, MareBusinessID IDOnline, IMareDTO DTOOnline, String user) {
  	this(nombre, IDOnline, DTOOnline);
  	addProperty(USER_PROPERTY, user);
  }

  public MareBusinessID getIDOnline(){ return (MareBusinessID)getProperty(IDONLINE_PROPERTY);	}
  public IMareDTO getDTOOnline(){ return (IMareDTO)getProperty(DTOONLINE_PROPERTY); }
  public String getProcessID() { return getString(PROCESSID_PROPERTY); }
  public String getUser() { return getString(USER_PROPERTY);	}
  public void setUser(String user) { addProperty(USER_PROPERTY, user); }
  
    // sapaza -- PER-SiCC-2010-0242 -- 09/07/2010
    private String obtenerNombreSecuencia(String nombre, String secuencia) {
      int longitudSecuencia = secuencia.length();
      String nombreSecuencia = nombre + "_" + secuencia;

      if(nombre.length() + longitudSecuencia + 1 > ANCHO_CODIGO_PROCESO) {
          int diferencia = (nombre.length() + longitudSecuencia + 1) - ANCHO_CODIGO_PROCESO;
          nombreSecuencia = nombre.substring(0, nombre.length() - diferencia) + "_" + secuencia;
      }   
      
      return nombreSecuencia;
    }
    
}
