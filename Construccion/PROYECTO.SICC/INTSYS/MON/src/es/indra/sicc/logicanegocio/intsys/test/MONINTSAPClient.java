package es.indra.sicc.logicanegocio.intsys.test;

import java.util.ArrayList;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.rmi.PortableRemoteObject;
import es.indra.sicc.logicanegocio.intsys.MONINTSAP;
import es.indra.sicc.logicanegocio.intsys.MONINTSAPHome;
import javax.naming.NamingException;
import java.util.Hashtable;

public class MONINTSAPClient 
{
    public static void main(String [] args)
    {
        MONINTSAPClient mONINTSAPClient = new MONINTSAPClient();
        try
        {
            Context context = getInitialContext();
            MONINTSAPHome mONINTSAPHome = (MONINTSAPHome)PortableRemoteObject.narrow(context.lookup("MONINTSAP"), MONINTSAPHome.class);
            MONINTSAP mONINTSAP;

            // Use one of the create() methods below to create a new instance
            mONINTSAP = mONINTSAPHome.create();

            // Call any of the Remote methods below to access the EJB
            // mONINTSAP.recepcionarSupergenerico( es.indra.sicc.util.DTOOID pais );
            // mONINTSAP.recepcionarStocksDiarios( es.indra.sicc.util.DTOOID dto );
            // mONINTSAP.recepcionarProductos( es.indra.sicc.util.DTOOID dto );
            // mONINTSAP.recepcionarNegocio( es.indra.sicc.util.DTOOID pais );
            // mONINTSAP.recepcionarGenerico( es.indra.sicc.util.DTOOID pais );
            // mONINTSAP.recepcionarDescripcionProductosIdioma( es.indra.sicc.util.DTOOID pais );
            // mONINTSAP.generarEntradaSAP( es.indra.sicc.util.DTOOID dto );
            es.indra.sicc.dtos.intsys.DTOINTEnviarMovimientos dtoe = new es.indra.sicc.dtos.intsys.DTOINTEnviarMovimientos();
            dtoe.setOidPais(new Long(1));
            dtoe.setObservaciones(new String("observaciones"));
            dtoe.setNumeroLote(new String("0001"));
            dtoe.setCanal(new Long(1));
            dtoe.setAcceso(new Long(1));
            ArrayList lista = new ArrayList();
            Long sub = new Long(1);
            lista.add(sub);
            dtoe.setSubaccesos(lista);
            
            ArrayList lista2 = new ArrayList();            
            Long tipo = new Long(1);
            lista2.add(tipo);            
            dtoe.setTipoMovimientos(lista2);
            mONINTSAP.enviarMovimientosAlmacenDiarios(dtoe);

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