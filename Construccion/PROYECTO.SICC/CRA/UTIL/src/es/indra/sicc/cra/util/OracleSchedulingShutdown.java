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
import com.evermind.server.OC4JShutdown;
import es.indra.sicc.util.UtilidadesLog;
import java.util.Hashtable;
import javax.naming.Context;

public class OracleSchedulingShutdown implements OC4JShutdown
{
    /**
     * This method is called before any applications have been deployed
     *
     * @param args - contains the parameters that have been specified for
     * this operation in the OC4J configuration file.
     * @param context - the JNDI context for the server.
     * @return An arbitrary string value
     */
    public String postUndeploy(Hashtable args, Context context) throws Exception 
    {
      UtilidadesLog.info("OracleSchedulingShutdown.postUndeploy(Hashtable args, Context context):Entrada");
      SchedulingActividades.shutdownScheduler();
      UtilidadesLog.info("OracleSchedulingShutdown.postUndeploy(Hashtable args, Context context):Salida");
      return null;
    }
    
    public String preUndeploy(Hashtable args, Context context) throws Exception 
    {
      return null;
    }

}