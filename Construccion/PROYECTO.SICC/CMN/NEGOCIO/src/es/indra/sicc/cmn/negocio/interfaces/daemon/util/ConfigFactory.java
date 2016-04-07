package es.indra.sicc.cmn.negocio.interfaces.daemon.util;

public class ConfigFactory {

  private static final INTDaemonConfig intDaemonConfig = new INTDaemonConfig();
  
  public static INTDaemonConfig getINTDaemonConfig () {
  	return intDaemonConfig; 
  }
  
}
