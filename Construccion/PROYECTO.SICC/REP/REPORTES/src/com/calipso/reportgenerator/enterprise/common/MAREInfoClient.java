package com.calipso.reportgenerator.enterprise.common;
import es.indra.sicc.rep.dtos.DTOReporte;
import java.util.HashMap;
import java.util.Hashtable;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

public class MAREInfoClient 
{
  public static void main(String [] args)
  {
    MAREInfoClient mAREInfoClient = new MAREInfoClient();
    try
    {
      Context context = getInitialContext();
      /*MAREInfoHome mAREInfoHome = (MAREInfoHome)PortableRemoteObject.narrow(context.lookup("MAREInfo"), MAREInfoHome.class);
      MAREInfo mAREInfo;

      // Use one of the create() methods below to create a new instance
      mAREInfo = mAREInfoHome.create();*/
      DTOReporte dto = new DTOReporte();
      dto.setIdReporte("RD_REP-027");
      dto.setParametros(new HashMap());

      // Call any of the Remote methods below to access the EJB
       //System.out.println(mAREInfo.ejecutarReporte( dto ));
       MAREInfoBean bean = new MAREInfoBean();
       bean.ejecutarReporte(dto);

    }
    catch(Throwable ex)
    {
      ex.printStackTrace();
    }

  }

  private static Context getInitialContext() throws NamingException
  {
    // Get InitialContext for Embedded OC4J.
    // The embedded server must be running for lookups to succeed.
    Hashtable env = new Hashtable();
    // Standalone OC4J connection details
    env.put(Context.INITIAL_CONTEXT_FACTORY, "com.evermind.server.rmi.RMIInitialContextFactory");
    env.put(Context.SECURITY_PRINCIPAL, "admin");
    env.put(Context.SECURITY_CREDENTIALS, "welcome");
    env.put(Context.PROVIDER_URL, "ormi://localhost:23891/current-workspace-app");
    return new InitialContext(env);
  }
}