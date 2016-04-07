package es.indra.sicc.logicanegocio.intsys.test;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.rmi.PortableRemoteObject;
import es.indra.sicc.logicanegocio.intsys.MONINTCPR;
import es.indra.sicc.logicanegocio.intsys.MONINTCPRHome;
import javax.naming.NamingException;
import java.util.Hashtable;
import es.indra.sicc.util.DTOSalida;

public class MONINTCPRClient 
{
    public static void main(String [] args)
    {
        MONINTCPRClient mONINTCPRClient = new MONINTCPRClient();
        try
        {
            Context context = getInitialContext();
            MONINTCPRHome mONINTCPRHome = (MONINTCPRHome)PortableRemoteObject.narrow(context.lookup("MONINTCPR"), MONINTCPRHome.class);
            MONINTCPR mONINTCPR;

            // Use one of the create() methods below to create a new instance
            mONINTCPR = mONINTCPRHome.create();

            // Call any of the Remote methods below to access the EJB
            //1°Prueba metodo recepcionarClasificacion
            es.indra.sicc.dtos.intsys.DTOINTRecepcionarClasificacion dto = new es.indra.sicc.dtos.intsys.DTOINTRecepcionarClasificacion();
            dto.setModoEjecucion(new Long(1));		
            dto.setNumeroLote(new Long(1));
		    dto.setDescripcionLote(new String("descripcionLote"));
		    dto.setObservaciones(new String("observaciones"));
            dto.setPais(new String("1"));
            dto.setIdioma(new String("1"));
            mONINTCPR.recepcionarClasificacion(dto);            
            
            //2° Prueba metodo cargarPantalla
            es.indra.sicc.util.DTOBelcorp dtoe = new es.indra.sicc.util.DTOBelcorp();            
            DTOSalida dtoSalida = mONINTCPR.cargarPantalla(dtoe);
            System.out.println("***** dtoSalida " + dtoSalida);

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
        env.put(Context.PROVIDER_URL, "ormi://cdos0070/mare");

        return new InitialContext(env);
    }
}