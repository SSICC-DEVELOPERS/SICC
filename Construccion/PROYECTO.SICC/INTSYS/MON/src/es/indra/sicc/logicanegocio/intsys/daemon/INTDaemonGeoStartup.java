package es.indra.sicc.logicanegocio.intsys.daemon;

import es.indra.mare.common.exception.MareException;
import es.indra.sicc.util.UtilidadesLog;
import java.util.Hashtable;
import javax.naming.Context;
import es.indra.sicc.logicanegocio.intsys.daemon.GEODaemon;

public class INTDaemonGeoStartup {

	private static INTDaemonGeoStartup singleton = null;
	private static GEODaemon daemon = null;
	
	private INTDaemonGeoStartup() throws MareException {
	}
	
	public static synchronized INTDaemonGeoStartup getInstance() throws MareException {
		if( singleton == null ){
			singleton = new INTDaemonGeoStartup();
    }
		return singleton;
	}

	public void start() throws MareException {
		if( daemon == null )
		{
      UtilidadesLog.debug("Se genera una instancia del demonio");
			daemon = new GEODaemon();
      daemon.run();
		}
    
	}

}