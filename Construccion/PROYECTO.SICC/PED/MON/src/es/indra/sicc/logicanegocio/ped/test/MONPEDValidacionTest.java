package es.indra.sicc.logicanegocio.ped.test;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.rmi.PortableRemoteObject;
import es.indra.sicc.logicanegocio.ped.MONPEDValidacion;
import es.indra.sicc.logicanegocio.ped.MONPEDValidacionHome;
import javax.naming.NamingException;
import java.util.Hashtable;
import es.indra.sicc.dtos.ped.DTOSolicitudValidacion;

public class MONPEDValidacionTest  {
  public static void main(String [] args) {
    MONPEDValidacionTest mONPEDValidacionTest = new MONPEDValidacionTest();
    try {
      Context context = getInitialContext();
      MONPEDValidacionHome mONPEDValidacionHome = (MONPEDValidacionHome)PortableRemoteObject.narrow(context.lookup("MONPEDValidacion"), MONPEDValidacionHome.class);
      MONPEDValidacion mONPEDValidacion;

      // Use one of the create() methods below to create a new instance
      mONPEDValidacion = mONPEDValidacionHome.create();

      // ***** Testeo de MONPEDValidacion.validarAsignacionStock() *****
      DTOSolicitudValidacion dto = new DTOSolicitudValidacion();
      dto.setOidSolicitud(new Long(1473));
      mONPEDValidacion.validarAsignacionStock(dto);
      // ***** Fin testeo de MONPEDValidacion.validarAsignacionStock() *****
      
      
      // ***** Testeo de MONPEDValidacion.revertirAsignacionStock() *****
      dto = new DTOSolicitudValidacion();
      dto.setOidSolicitud(new Long(1473));
      mONPEDValidacion.revertirAsignacionStock(dto);
      // ***** Fin Testeo de MONPEDValidacion.revertirAsignacionStock() *****

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
    env.put(Context.PROVIDER_URL, "ormi://CDOS0035mon-ped");

    return new InitialContext(env);
  }
}