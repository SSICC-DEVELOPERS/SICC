package es.indra.sicc.logicanegocio.rec.test;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.rmi.PortableRemoteObject;
import es.indra.sicc.logicanegocio.rec.MONPruebaDAORecibirProductos;
import es.indra.sicc.logicanegocio.rec.MONPruebaDAORecibirProductosHome;
import javax.naming.NamingException;
import java.util.Hashtable;
import java.util.ArrayList;
import es.indra.sicc.dtos.rec.DTOLineasOperacion;
import es.indra.sicc.dtos.rec.DTOMovAlmac;

public class MONPruebaDAORecibirProductosClient 
{
    public static void main(String [] args)
    {
        MONPruebaDAORecibirProductosClient mONPruebaDAORecibirProductosClient = new MONPruebaDAORecibirProductosClient();
        try
        {
            Context context = getInitialContext();
            MONPruebaDAORecibirProductosHome mONPruebaDAORecibirProductosHome = (MONPruebaDAORecibirProductosHome)PortableRemoteObject.narrow(context.lookup("MONPruebaDAORecibirProductos"), MONPruebaDAORecibirProductosHome.class);
            MONPruebaDAORecibirProductos mONPruebaDAORecibirProductos;

            // Use one of the create() methods below to create a new instance
            mONPruebaDAORecibirProductos = mONPruebaDAORecibirProductosHome.create();
            ArrayList lineas = new ArrayList();
            DTOLineasOperacion dto = new DTOLineasOperacion();
            dto.setOidLineaOperacion(new Long(1));
            
            // Call any of the Remote methods below to access the EJB
            ArrayList resultado = mONPruebaDAORecibirProductos.obtenerAlmacenDeLinea(lineas);
            int cant = resultado.size();
            for(int i=0; i<cant; i++) {
                DTOMovAlmac dtoMovAlmacen = (DTOMovAlmac)resultado.get(i);
                System.out.println("**** dtoMovAlmacen " + dtoMovAlmacen);
            }

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