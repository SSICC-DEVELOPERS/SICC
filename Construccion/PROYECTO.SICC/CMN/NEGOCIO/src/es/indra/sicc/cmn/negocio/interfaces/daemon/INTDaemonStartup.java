package es.indra.sicc.cmn.negocio.interfaces.daemon;

import es.indra.mare.common.exception.MareException;
import es.indra.sicc.cmn.negocio.interfaces.daemon.INTDaemon;
import es.indra.sicc.util.UtilidadesLog;
import java.util.Hashtable;
import javax.naming.Context;

public class INTDaemonStartup {

	private static INTDaemonStartup singleton = null;
	private static INTDaemon daemon = null;
	
	private INTDaemonStartup() throws MareException {
	}
	
	public static synchronized INTDaemonStartup getInstance() throws MareException {
		if( singleton == null ){
			singleton = new INTDaemonStartup();
    }
		return singleton;
	}

	public void start() throws MareException {
		if( daemon == null )
		{
      UtilidadesLog.debug("Se genera una instancia del demonio");
			daemon = new INTDaemon();
      daemon.run();
		}
    
	}
	
	public void stop() {
    UtilidadesLog.debug("Se va a parar el daemon");
		daemon.stop();
		daemon = null;
    singleton = null;
	}
}