package es.indra.sicc.logicanegocio.bel.test;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.rmi.PortableRemoteObject;
import es.indra.sicc.logicanegocio.bel.MONGenerarMovimientoAlmacen;
import es.indra.sicc.logicanegocio.bel.MONGenerarMovimientoAlmacenHome;
import javax.naming.NamingException;
import java.util.Hashtable;

public class MONGenerarMovimientoAlmacenClient 
{
    public static void main(String [] args)
    {
        MONGenerarMovimientoAlmacenClient mONGenerarMovimientoAlmacenClient = new MONGenerarMovimientoAlmacenClient();
        try
        {
            Context context = getInitialContext();
            MONGenerarMovimientoAlmacenHome mONGenerarMovimientoAlmacenHome = (MONGenerarMovimientoAlmacenHome)PortableRemoteObject.narrow(context.lookup("MONGenerarMovimientoAlmacen"), MONGenerarMovimientoAlmacenHome.class);
            MONGenerarMovimientoAlmacen mONGenerarMovimientoAlmacen;

            // Use one of the create() methods below to create a new instance
            mONGenerarMovimientoAlmacen = mONGenerarMovimientoAlmacenHome.create();

            // Call any of the Remote methods below to access the EJB
            // mONGenerarMovimientoAlmacen.reversionMovimientoAlmacen( es.indra.sicc.dtos.bel.DTOReversionMovimiento dto );
            int posicion = 1;
            mONGenerarMovimientoAlmacen.grabarMovimientoDetallePrueba(posicion);
            // mONGenerarMovimientoAlmacen.grabarMovimientoAlmacenYStock( es.indra.sicc.dtos.bel.DTOMovimientoAlmacen dto );

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