package es.indra.sicc.cmn.negocio.auditoria.test;
import java.util.Hashtable;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.rmi.PortableRemoteObject;
import es.indra.sicc.cmn.negocio.auditoria.test.MONTest;
import es.indra.sicc.cmn.negocio.auditoria.test.MONTestHome;
import javax.naming.NamingException;
import es.indra.sicc.util.UtilidadesLog;

public class MONTestClient  {
  public static void main(String [] args) {
    MONTestClient mONTestClient = new MONTestClient();
    try {
      Context context = getInitialContext();
      MONTestHome mONTestHome = (MONTestHome)PortableRemoteObject.narrow(context.lookup("MONTest"), MONTestHome.class);
      MONTest mONTest;

      // Use one of the create() methods below to create a new instance
      mONTest = mONTestHome.create();
      mONTest.find(null);

    } catch(Throwable ex) {
      ex.printStackTrace();
    }
  }

  private static Context getInitialContext() throws NamingException {
    Hashtable env = new Hashtable();
    env.put(Context.INITIAL_CONTEXT_FACTORY, "com.evermind.server.rmi.RMIInitialContextFactory");
    env.put(Context.SECURITY_PRINCIPAL, "admin");
    env.put(Context.SECURITY_CREDENTIALS, "welcome");
    env.put(Context.PROVIDER_URL, "ormi://localhost:23891/current-workspace-app");

    return new InitialContext(env);
  }
}