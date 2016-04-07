/**
 * Copyright 2003 © por Indra Sistemas,S.A.. Todos los derechos reservados.
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
package es.indra.sicc.cra.util;

import com.evermind.server.OC4JStartup;

import es.indra.sicc.cmn.negocio.batch.MONBatch;
import es.indra.sicc.cmn.negocio.batch.MONBatchEJBLocal;
import es.indra.sicc.cmn.negocio.batch.util.BatchUtil;
import es.indra.sicc.cmn.negocio.interfaces.daemon.util.Util;
import es.indra.sicc.util.UtilidadesLog;
import java.util.Hashtable;

import javax.naming.Context;

  public class OracleSchedulingStartUp implements OC4JStartup
{ 
    /**
     * This method is called before any applications have been deployed
     *
     * @param args - contains the parameters that have been specified for
     * this operation in the OC4J configuration file.
     * @param context - the JNDI context for the server.
     * @return An arbitrary string value
     */
    public String preDeploy(Hashtable args, Context context) throws Exception 
    {
      return null;
    }
  
    /**
     * This method is called after any applications have been deployed.
     *
     * @param args - contains the parameters that have been specified for
     * this operation in the OC4J configuration file.
     * @param context - the JNDI context for the server.
     * @return An arbitrary string value
     */
    public String postDeploy(Hashtable args, Context context) throws Exception 
    {
        try{
            SchedulingActividades.getScheduler();
        } catch( Exception mex ){
            UtilidadesLog.error(mex);
        }

        return null;
    }
}
