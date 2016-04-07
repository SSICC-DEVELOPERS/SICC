package es.indra.sicc.logicanegocio.intsys.daemon;

import com.evermind.server.OC4JShutdown;
import java.util.Hashtable;
import javax.naming.Context;
import es.indra.sicc.util.UtilidadesLog;

public class OracleDaemonGeoShutdown implements OC4JShutdown
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
      UtilidadesLog.debug("Se llamo al postUndeploy");
//      INTDaemonGeoStartup.getInstance().stop();
      UtilidadesLog.debug("Se detuvo el demonio del Geo");
      return null;
    }
    
    public String preUndeploy(Hashtable args, Context context) throws Exception 
    {
      UtilidadesLog.debug("Se llamo al preUndeploy");
      
      return null;
    }

}
