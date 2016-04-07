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

package es.indra.sicc.cmn.negocio.batch.util;

import es.indra.sicc.cmn.negocio.batch.MONBatchEJBLocal;
import es.indra.sicc.cmn.negocio.batch.MONBatchEJBLocalHome;
import es.indra.sicc.util.BelcorpService;
import es.indra.sicc.util.UtilidadesLog;
import java.rmi.RemoteException;

import java.util.Hashtable;
import javax.ejb.EJBException;
import javax.naming.Context;
import javax.naming.InitialContext;

import org.apache.commons.logging.Log;

import es.indra.mare.common.dto.IMareDTO;
import es.indra.mare.common.dto.MareDTO;
import es.indra.mare.common.exception.MareException;
import es.indra.mare.common.mii.MareMii;
import es.indra.mare.common.mii.MareTopic;
import es.indra.mare.common.mii.services.logging.LoggingService;
import es.indra.mare.common.mln.MareBusinessID;
import es.indra.mare.enterprise.mln.BusinessFacade;
import es.indra.mare.enterprise.mln.BusinessFacadeHome;
import es.indra.mare.enterprise.mln.BusinessFacadeLocal;
import es.indra.mare.enterprise.mln.BusinessFacadeLocalHome;
import org.apache.log4j.Logger;

/**
 * @author fcuenca
 *
 * To change the template for this generated type comment go to
 * Window>Preferences>Java>Code Generation>Code and Comments
 */
public class BatchUtil {
    private static UtilidadesLog logAux = new UtilidadesLog();
	//private static Log log;
	//private static MONBatch monBatch = null;
	
	public static MONBatchEJBLocal getMonBatch() throws MareException {
        //return new MONBatch();
        //modificado para obtener la interface local del MONBatchEJB
		MONBatchEJBLocal local = null;
		try{
			UtilidadesLog.debug("*** Se obtiene la referencia local ***");
			final InitialContext context = new InitialContext();
			MONBatchEJBLocalHome mon = (MONBatchEJBLocalHome)context.lookup("java:comp/env/ejb/local/MONBatchEJB");

			local = mon.create(); 
		}catch(Exception ex){
			UtilidadesLog.error("*** Error al obtener el MONBatchEJBLocal = "+ex);
		}
		UtilidadesLog.info("*** Despues de obtener la refencia local ***");
		return local;
	}
	 
    public static Log getLog() {
        try{
            return BelcorpService.getInstance().log;
        }catch (Exception e){
            e.printStackTrace();
            throw new RuntimeException("No se pudo obtener el objeto Log");
        }
    }
  
  public static BusinessFacadeLocal getLocalMLN() throws MareException {
	  BusinessFacadeLocal businessFacadeLocal = null;
	  
  	try {
      
      InitialContext context = new InitialContext();

	    String jndiName = ConfigFactory.getBatchConfig().getLocalBusinessFacade();
	    BusinessFacadeLocalHome mlnHome = (BusinessFacadeLocalHome)context.lookup(jndiName);
	    
	    businessFacadeLocal = mlnHome.create();
    } catch (Exception e) {
    	throw new MareException ("Error localizando el MLN local", e);
    }
    return businessFacadeLocal;
  }
  
  public static BusinessFacade getRemoteMLN() throws MareException {
		BusinessFacade businessFacade = null;
	  
	  try {
      Hashtable env = new Hashtable();
      env.put(Context.INITIAL_CONTEXT_FACTORY, "com.evermind.server.rmi.RMIInitialContextFactory");
      env.put(Context.SECURITY_PRINCIPAL, ConfigFactory.getBatchConfig().getUser());
      env.put(Context.SECURITY_CREDENTIALS, ConfigFactory.getBatchConfig().getPassword());
      env.put(Context.PROVIDER_URL, ConfigFactory.getBatchConfig().getUrl());
      InitialContext context = new InitialContext(env);

		  String jndiName = ConfigFactory.getBatchConfig().getBusinessFacade();
		  BusinessFacadeHome mlnHome = (BusinessFacadeHome)context.lookup(jndiName);
	    
		  businessFacade = mlnHome.create();
	  } catch (Exception e) {
		  throw new MareException ("Error localizando el MLN remoto", e);
	  }
	  return businessFacade;
	}
	
	public static MareDTO executeMLN(IMareDTO dto, MareBusinessID businessID ) throws RemoteException, EJBException, MareException {
	    if(logAux.isDebugEnabled()) { //sapaza -- cambio Optimizacion Logs -- 05/03/2010
                UtilidadesLog.debug("El BID a ejecutar es :"+ businessID.getBusinessID());		
                UtilidadesLog.debug("(SCS) el IMareDTO, es: " + dto);
                UtilidadesLog.debug("(SCS) el MareBusinessID, es: " + businessID);
            }    
        MareDTO dtos = (MareDTO) BatchUtil.getLocalMLN().execute(dto, businessID);
        //MareDTO dtos = (MareDTO) BatchUtil.getRemoteMLN().execute(dto, businessID);
        return dtos;
	}
	
	public static MareDTO executeMLN(IMareDTO dto, String businessID) throws RemoteException, EJBException, MareException {
		  return executeMLN(dto, new MareBusinessID(businessID));
	}
    public static void esperarHijos(String codProceso) throws InterruptedException, MareException {
		UtilidadesLog.info("**** BatchUtil.esperarHijos: Entrada ***");
		getMonBatch().esperarHijos(codProceso);
		UtilidadesLog.info("**** BatchUtil.esperarHijos: Salida ***");
	}
    
    public static void esperarHijosFacturacion(String codProceso) throws InterruptedException, MareException {
		UtilidadesLog.info("**** BatchUtil.esperarHijos: Entrada ***");
		getMonBatch().esperarHijosFacturacion(codProceso);
		UtilidadesLog.info("**** BatchUtil.esperarHijos: Salida ***");
	}

}
