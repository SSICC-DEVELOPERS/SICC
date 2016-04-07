package es.indra.sicc.logicanegocio.intsys;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.rmi.PortableRemoteObject;
import es.indra.sicc.logicanegocio.intsys.MONINTRET;
import es.indra.sicc.logicanegocio.intsys.MONINTRETHome;
import javax.naming.NamingException;

import java.util.Hashtable;
import es.indra.sicc.dtos.intsys.DTOINT;

public class MONINTRETClient 
{
    public static void main(String [] args)
    {
        MONINTRETClient mONINTRETClient = new MONINTRETClient();
        try
        {


            // Call any of the Remote methods below to access the EJB
            // mONINTRET.recepcionarReclamosCalypso( es.indra.sicc.dtos.intsys.DTOINT dto );
            // mONINTRET.recepcionarReclamosCabecera( es.indra.sicc.dtos.intsys.DTOINT dto );
            // mONINTRET.recepcionarOperacionReclamo( es.indra.sicc.dtos.intsys.DTOINT dto );
            // mONINTRET.recepcionarLineaOperacionReclamo( es.indra.sicc.dtos.intsys.DTOINT dto );
            
            recepcionarReclamosCalypso();
            //recepcionarReclamosCabecera();
            //recepcionarOperacionReclamo();

        }
        catch(Throwable ex)
        {
            ex.printStackTrace();
        }

    }

    private static void recepcionarReclamosCalypso() throws Exception{
            Context context = getInitialContext();
            MONINTRETHome mONINTRETHome = (MONINTRETHome)PortableRemoteObject.narrow(context.lookup("MONINTRET"), MONINTRETHome.class);
            MONINTRET mONINTRET;

            // Use one of the create() methods below to create a new instance
            mONINTRET = mONINTRETHome.create();    
            
            DTOINT doEnt = new DTOINT();
            
            doEnt.setNumeroLote(new Long("200601060000"));
            doEnt.setOidPais(new Long(1));
            doEnt.setDescripcionLote(new String("descripcion lote 2"));
            doEnt.setObservaciones(new String("observaciones 2"));
            doEnt.setOidIdioma(new Long(1));
            
            mONINTRET.recepcionarReclamosCalypso(doEnt);
    }
    
    private static void recepcionarOperacionReclamo() throws Exception{
            Context context = getInitialContext();
            MONINTRETHome mONINTRETHome = (MONINTRETHome)PortableRemoteObject.narrow(context.lookup("MONINTRET"), MONINTRETHome.class);
            MONINTRET mONINTRET;

            // Use one of the create() methods below to create a new instance
            mONINTRET = mONINTRETHome.create();    
            
            DTOINT doEnt = new DTOINT();
            
            doEnt.setNumeroLote(new Long("200601060000"));
            doEnt.setOidPais(new Long(1));
            doEnt.setDescripcionLote(new String("descripcion lote 2"));
            doEnt.setObservaciones(new String("observaciones 2"));
            doEnt.setOidIdioma(new Long(1));
            
            mONINTRET.recepcionarOperacionReclamo(doEnt);
    }
    
    private static void recepcionarReclamosCabecera() throws Exception{
            Context context = getInitialContext();
            MONINTRETHome mONINTRETHome = (MONINTRETHome)PortableRemoteObject.narrow(context.lookup("MONINTRET"), MONINTRETHome.class);
            MONINTRET mONINTRET;

            // Use one of the create() methods below to create a new instance
            mONINTRET = mONINTRETHome.create();    
            
            DTOINT doEnt = new DTOINT();
            
            doEnt.setNumeroLote(new Long("200601050000"));
            doEnt.setOidPais(new Long(1));
            doEnt.setDescripcionLote(new String("descripcion lote 1"));
            doEnt.setObservaciones(new String("observaciones 1"));
            doEnt.setOidIdioma(new Long(1));
            
            mONINTRET.recepcionarReclamosCabecera(doEnt);
    }

    private static Context getInitialContext() throws NamingException
    {
        Hashtable env = new Hashtable();
        // Standalone OC4J connection details
        env.put(Context.INITIAL_CONTEXT_FACTORY, "com.evermind.server.rmi.RMIInitialContextFactory");
        env.put(Context.SECURITY_PRINCIPAL, "PEPRUEBAS");
        env.put(Context.SECURITY_CREDENTIALS, "belcorp");
        
        //env.put(Context.SECURITY_PRINCIPAL, "admin");
        //env.put(Context.SECURITY_CREDENTIALS, "belcorp");
        
        //env.put(Context.PROVIDER_URL, "ormi://cdos0075:23791/mare");
        env.put(Context.PROVIDER_URL, "ormi://cdos02ap:3104/sicc_server");

        return new InitialContext(env);
    }
    
}