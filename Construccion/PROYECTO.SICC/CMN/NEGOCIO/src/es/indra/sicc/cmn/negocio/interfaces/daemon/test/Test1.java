package es.indra.sicc.cmn.negocio.interfaces.daemon.test;

import es.indra.sicc.cmn.negocio.interfaces.daemon.util.*;
import es.indra.mare.common.exception.MareException;
import es.indra.sicc.util.UtilidadesLog;

public class Test1 
{
  public Test1()
  {
  }

  /**
   * 
   * @param args
   */
  public static void main(String[] args)
  {
    Test1 test1 = new Test1();
    
    String prop = null;
    int port = 0;
    String dbPath = null;
    String intFile = null;
    
    try
    {
      dbPath = ConfigFactory.getINTDaemonConfig().getDBURL();
      intFile = ConfigFactory.getINTDaemonConfig().getInterfacesConfigFile();
    } catch( MareException mex )
    {
      mex.printStackTrace();
    }
    UtilidadesLog.debug(String.valueOf(port));
    UtilidadesLog.debug(dbPath);
    UtilidadesLog.debug(intFile);
  }
}