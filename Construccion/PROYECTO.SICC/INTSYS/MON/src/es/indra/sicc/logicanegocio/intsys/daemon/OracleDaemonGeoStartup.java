package es.indra.sicc.logicanegocio.intsys.daemon;
import com.evermind.server.OC4JStartup;

import es.indra.sicc.cmn.negocio.batch.MONBatch;
import es.indra.sicc.cmn.negocio.batch.MONBatchEJBLocal;
import es.indra.sicc.cmn.negocio.batch.util.BatchUtil;
import es.indra.sicc.cmn.negocio.interfaces.daemon.util.Util;
import es.indra.sicc.util.UtilidadesLog;
import java.util.Hashtable;

import javax.naming.Context;


public class OracleDaemonGeoStartup implements OC4JStartup
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
        UtilidadesLog.info("Se llamo al postdeploy");
        try{
            INTDaemonGeoStartup.getInstance().start();
        } catch( Exception mex ){
            UtilidadesLog.error("ERROR AL INICIALIZAR DAEMON del GEO");
            Util.getLog().error( "Error al arrancar GEOTDaemon", mex );
            mex.printStackTrace();
        }
        return null;
    }
}