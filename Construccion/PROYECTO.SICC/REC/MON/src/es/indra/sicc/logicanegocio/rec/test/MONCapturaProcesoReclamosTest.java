package es.indra.sicc.logicanegocio.rec;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.rmi.PortableRemoteObject;
import es.indra.sicc.logicanegocio.rec.MONCapturaProcesoReclamos;
import es.indra.sicc.logicanegocio.rec.MONCapturaProcesoReclamosHome;
import javax.naming.NamingException;
import java.util.Hashtable;
import es.indra.sicc.dtos.rec.DTOAtencionReclamoREC;


public class MONCapturaProcesoReclamosTest  {
  public static void main(String [] args) {
    MONCapturaProcesoReclamosTest mONCapturaProcesoReclamosTest = new MONCapturaProcesoReclamosTest();
    try {
      Context context = getInitialContext();
      MONCapturaProcesoReclamosHome mONCapturaProcesoReclamosHome = (MONCapturaProcesoReclamosHome)PortableRemoteObject.narrow(context.lookup("MONCapturaProcesoReclamos"), MONCapturaProcesoReclamosHome.class);
      MONCapturaProcesoReclamos mONCapturaProcesoReclamos;
      mONCapturaProcesoReclamos = mONCapturaProcesoReclamosHome.create();

      // ***** Testeo de MONCapturaProcesosReclamos.generarSolicitudes() *****
      DTOAtencionReclamoREC dtoE = new DTOAtencionReclamoREC();
      dtoE.setNumAtencion(new Long(150000));
      dtoE.setOidPais(new Long(1));
      dtoE.setOidIdioma(new Long(1));
      mONCapturaProcesoReclamos.generarSolicitudes( dtoE );
      // ***** Fin Testeo de MONCapturaProcesosReclamos.generarSolicitudes() *****

    } catch(Throwable ex) {
      ex.printStackTrace();
    }
  }

  private static Context getInitialContext() throws NamingException {
    Hashtable env = new Hashtable();
    // Standalone OC4J connection details
    env.put(Context.INITIAL_CONTEXT_FACTORY, "com.evermind.server.rmi.RMIInitialContextFactory");
    env.put(Context.SECURITY_PRINCIPAL, "admin");
    env.put(Context.SECURITY_CREDENTIALS, "belcorp");
    env.put(Context.PROVIDER_URL, "ormi://CDOS0110/mare");

    return new InitialContext(env);
  }
}

