package es.indra.sicc.logicanegocio.pre.test;
import es.indra.mare.common.mii.services.jdbcservice.RecordSet;
import es.indra.sicc.logicanegocio.pre.MONMantenimientoMF;
import es.indra.sicc.logicanegocio.pre.MONMantenimientoMFHome;
import es.indra.sicc.util.DTOBelcorp;
import es.indra.sicc.util.DTOSalida;

import java.util.Hashtable;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import javax.rmi.PortableRemoteObject;
/**
 * 
 * @date 
 * @author pperanzola
 */
public class ClubPrivPREConsultasClient
{
    /**
     * 
     * @date 
     */
    public ClubPrivPREConsultasClient()
    {
    }
    public static void main (String [] args) throws Exception{
        ClubPrivPREConsultasClientAux clubPrivAux = new ClubPrivPREConsultasClientAux();
        MONMantenimientoMF monMF = clubPrivAux.getPREConsultas().create();
        DTOBelcorp dto = new DTOBelcorp();
        dto.setOidPais(new Long (1));
        DTOSalida dtos = new DTOSalida();
        dtos = monMF.obtenerVariantes(dto);
        RecordSet rsResultado = dtos.getResultado();
        
    }
}    
class ClubPrivPREConsultasClientAux  {
    public ClubPrivPREConsultasClientAux(){}
    
     public MONMantenimientoMFHome getPREConsultas() throws NamingException {
        Context context = getInitialContext();
        MONMantenimientoMFHome mp = (MONMantenimientoMFHome)PortableRemoteObject.narrow(context.lookup("MONMantenimientoMF"), MONMantenimientoMFHome.class);
        return mp;
        
    }
    
    public  Context getInitialContext() throws NamingException  {
        Hashtable env = new Hashtable();
        env.put(Context.INITIAL_CONTEXT_FACTORY, "com.evermind.server.rmi.RMIInitialContextFactory");
        env.put(Context.SECURITY_PRINCIPAL, "PRUEBAS");
        env.put(Context.SECURITY_CREDENTIALS, "belcorp");
        env.put(Context.PROVIDER_URL, "ormi://cdos02ap:3104/sicc_server");

        return new InitialContext(env);
    }
    

}