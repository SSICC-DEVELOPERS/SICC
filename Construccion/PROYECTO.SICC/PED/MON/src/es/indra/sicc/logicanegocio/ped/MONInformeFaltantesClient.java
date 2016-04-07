package es.indra.sicc.logicanegocio.ped;
import es.indra.sicc.dtos.ped.ConstantesPedFaltantes;
import es.indra.sicc.dtos.ped.DTOEInformeFaltantes;
import java.sql.Date;
import java.text.SimpleDateFormat;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.rmi.PortableRemoteObject;
import es.indra.sicc.logicanegocio.ped.MONInformeFaltantes;
import es.indra.sicc.logicanegocio.ped.MONInformeFaltantesHome;
import javax.naming.NamingException;
import java.util.Hashtable;

public class MONInformeFaltantesClient 
{
  public static void main(String [] args)
  {
    MONInformeFaltantesClient mONInformeFaltantesClient = new MONInformeFaltantesClient();
    try
    {
      Context context = getInitialContext();
      MONInformeFaltantesHome mONInformeFaltantesHome = (MONInformeFaltantesHome)PortableRemoteObject.narrow(context.lookup("MONInformeFaltantes"), MONInformeFaltantesHome.class);
      MONInformeFaltantes mONInformeFaltantes;

      // Use one of the create() methods below to create a new instance
      mONInformeFaltantes = mONInformeFaltantesHome.create();

      // Call any of the Remote methods below to access the EJB
      // mONInformeFaltantes.obtieneControl(  );
      DTOEInformeFaltantes dtoe = new DTOEInformeFaltantes();
      dtoe.setOperacion(ConstantesPedFaltantes.OP_GENERA);
      dtoe.setOidIdioma(new Long(1));
      dtoe.setOidPais(new Long(1));
      SimpleDateFormat df= new SimpleDateFormat("dd-MM-yyyy");
      dtoe.setFechaInicio(new java.sql.Date(df.parse("21-12-2004").getTime()));
       mONInformeFaltantes.ejecuta(  dtoe );
      // mONInformeFaltantes.cargaValidarFaltantes( es.indra.sicc.util.DTOBelcorp dto );

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
    env.put(Context.SECURITY_CREDENTIALS, "welcome");
    env.put(Context.PROVIDER_URL, "ormi://localhost:23891/current-workspace-app");

    return new InitialContext(env);
  }
}