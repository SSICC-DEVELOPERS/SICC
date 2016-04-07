package es.indra.sicc.logicanegocio.prueba;
import es.indra.sicc.dtos.prueba.DTOCargaRegistroOnline;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.rmi.PortableRemoteObject;
import es.indra.sicc.logicanegocio.prueba.MONRegistroOnline;
import es.indra.sicc.logicanegocio.prueba.MONRegistroOnlineHome;
import javax.naming.NamingException;
import java.util.Hashtable;

public class MONRegistroOnlineClient 
{
  public static void main(String [] args)
  {
    MONRegistroOnlineClient mONRegistroOnlineClient = new MONRegistroOnlineClient();
    try
    {
      Context context = getInitialContext();
      MONRegistroOnlineHome mONRegistroOnlineHome = (MONRegistroOnlineHome)PortableRemoteObject.narrow(context.lookup("MONRegistroOnline"), MONRegistroOnlineHome.class);
      MONRegistroOnline mONRegistroOnline;

      // Use one of the create() methods below to create a new instance
      mONRegistroOnline = mONRegistroOnlineHome.create();

      // Call any of the Remote methods below to access the EJB
      // mONRegistroOnline.validarCabecera(  );
       DTOCargaRegistroOnline dtoR = mONRegistroOnline.obtenerCargaInicial( new Long(1), "a" );
       System.out.println("Periodos: "+dtoR.getPeriodos()[0].getDesc());
       
      // mONRegistroOnline.buscarDatosCliente( java.lang.String codCliente, java.lang.Long oidPais );

    }
    catch(Throwable ex)
    {
      ex.printStackTrace();
    }

  }

  private static Context getInitialContext() throws NamingException
  {
    Hashtable env = new Hashtable();
    // Standalone OC4J connection details
    env.put(Context.INITIAL_CONTEXT_FACTORY, "com.evermind.server.rmi.RMIInitialContextFactory");
    env.put(Context.SECURITY_PRINCIPAL, "admin");
    env.put(Context.SECURITY_CREDENTIALS, "belcorp");
    env.put(Context.PROVIDER_URL, "ormi://CDOS0035/mare");

    return new InitialContext(env);
  }
}