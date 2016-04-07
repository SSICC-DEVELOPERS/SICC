package es.indra.sicc.logicanegocio.pre.test;
import es.indra.sicc.cmn.negocio.auditoria.DTOAuditableSICC;
import es.indra.sicc.dtos.pre.DTOCabecCatal;
import es.indra.sicc.logicanegocio.pre.MONMantenimientoMF;
import es.indra.sicc.logicanegocio.pre.MONMantenimientoMFHome;

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
public class MONMantenimientoMFCliente 
{
    /**
     * 
     * @date 
     */
    public MONMantenimientoMFCliente()  {
    
    }
    
    public static void main(String [] args)  {
        MONMantenimientoMFClienteAux monMantenimientoMFAux = new MONMantenimientoMFClienteAux();
        try        {
            monMantenimientoMFAux.CrearMF();
        }
        catch(Exception ex) {
            System.out.println("salio por error");
            ex.printStackTrace();
        }
    }
    
}
class MONMantenimientoMFClienteAux extends DTOAuditableSICC  {
    public MONMantenimientoMFClienteAux(){}
    
    public void CrearMF() throws Exception{
        Context context = getInitialContext();
        MONMantenimientoMFHome monMF = (MONMantenimientoMFHome)PortableRemoteObject.narrow(context.lookup("MONMantenimientoMF"), MONMantenimientoMFHome.class);
        MONMantenimientoMF monMFLocal;
        monMFLocal= monMF.create();
        DTOCabecCatal dto = new DTOCabecCatal();
        
        //DATOS PARA LA PRUEBA CON ID 1 para CDDBEL-UBEL001-VIU-002 (Diseño y Ejecución de Pruebas Unitarias)
        dto.setOidCabecera(new Long (1042));
        dto.setOidCatalogo(new Long (6));

        /*  DATOS PARA LA PRUEBA CON ID 2 para CDDBEL-UBEL001-VIU-002 (Diseño y Ejecución de Pruebas Unitarias)
         *  descomentarlo para ejecutar esta prueba 
         *  
            dto.setOidCabecera(new Long (1042));
            dto.setOidCatalogo(null);
        */
        
        monMFLocal.crearMF(dto);

        
    }
     public static  Context getInitialContext() throws NamingException  {
        Hashtable env = new Hashtable();
        env.put(Context.INITIAL_CONTEXT_FACTORY, "com.evermind.server.rmi.RMIInitialContextFactory");
        env.put(Context.SECURITY_PRINCIPAL, "admin");
        env.put(Context.SECURITY_CREDENTIALS, "welcome");
        env.put(Context.PROVIDER_URL, "ormi://cdos02ap:3104/sicc_server");

        return new InitialContext(env);
    }
    
    
}
