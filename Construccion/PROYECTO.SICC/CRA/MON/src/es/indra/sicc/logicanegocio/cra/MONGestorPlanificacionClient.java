package es.indra.sicc.logicanegocio.cra;
import es.indra.mare.enterprise.mln.BusinessFacade;
import java.sql.Timestamp;
import java.util.Hashtable;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.rmi.PortableRemoteObject;
import es.indra.sicc.logicanegocio.cra.MONGestorPlanificacion;
import es.indra.sicc.logicanegocio.cra.MONGestorPlanificacionHome;
import javax.naming.NamingException;
import es.indra.sicc.dtos.cra.DTODatosPlanificador;

public class MONGestorPlanificacionClient 
{
    public static void main(String [] args)
    {
        MONGestorPlanificacionClient mONGestorPlanificacionClient = new MONGestorPlanificacionClient();
        try
        {
            Context context = getInitialContext();
            MONGestorPlanificacionHome mONGestorPlanificacionHome = (MONGestorPlanificacionHome)PortableRemoteObject.narrow(context.lookup("MONGestorPlanificacion"), MONGestorPlanificacionHome.class);
            MONGestorPlanificacion mONGestorPlanificacion;

            // Use one of the create() methods below to create a new instance
            mONGestorPlanificacion = mONGestorPlanificacionHome.create();

            // Call any of the Remote methods below to access the EJB
            DTODatosPlanificador dtoDatosPlanificador = new DTODatosPlanificador();
            dtoDatosPlanificador.setPais(Long.valueOf("1"));
            dtoDatosPlanificador.setMarca(Long.valueOf("1"));
            dtoDatosPlanificador.setCanal(Long.valueOf("1"));
            dtoDatosPlanificador.setIdNegocio("CRAObtieneGruposFueraMatriz");
            dtoDatosPlanificador.setFechaEjecucion(new Timestamp(System.currentTimeMillis() + ((1000 * 30) * 1) ));
            System.out.println("dtoDatosPlanificador: " + dtoDatosPlanificador);
            mONGestorPlanificacion.crearTarea(dtoDatosPlanificador);

        }
        catch(Throwable ex)
        {
            ex.printStackTrace();
        }

    }


    private static Context getInitialContext() throws NamingException {
        Hashtable env = new Hashtable();
        env.put(Context.INITIAL_CONTEXT_FACTORY, "com.evermind.server.rmi.RMIInitialContextFactory");
        env.put(Context.SECURITY_PRINCIPAL, "admin");
        env.put(Context.SECURITY_CREDENTIALS, "welcome");
        env.put(Context.PROVIDER_URL,"ormi://localhost:23891/current-workspace-app");
        return new InitialContext(env);
    }
}