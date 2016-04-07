package es.indra.sicc.logicanegocio.bel.test;

import es.indra.mare.common.exception.MareException;
import es.indra.sicc.dtos.bel.DTOControlAlmacen;
import es.indra.sicc.logicanegocio.bel.MONMantenimientoControlAlmacen;
import es.indra.sicc.logicanegocio.bel.MONMantenimientoControlAlmacenHome;
import es.indra.sicc.util.DTOOID;

import es.indra.sicc.util.DTOOIDs;
import es.indra.sicc.util.DTOSalida;
import java.util.Hashtable;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import javax.rmi.PortableRemoteObject;

public class MONMantenimientoControlAlmacenClient  {
    public static void main(String [] args) {
        MONMantenimientoControlAlmacenClient mONMantenimientoControlAlmacenClient = new MONMantenimientoControlAlmacenClient();
        try {
            Context context = getInitialContext();
            MONMantenimientoControlAlmacenHome mONMantenimientoControlAlmacenHome = (MONMantenimientoControlAlmacenHome)PortableRemoteObject.narrow(context.lookup("MONMantenimientoControlAlmacen"), MONMantenimientoControlAlmacenHome.class);
            MONMantenimientoControlAlmacen mONMantenimientoControlAlmacen;

            // Use one of the create() methods below to create a new instance
            mONMantenimientoControlAlmacen = mONMantenimientoControlAlmacenHome.create();

            // Call any of the Remote methods below to access the EJB
            /** PRUEBA 1 - al metodo "void actualizarControlAlmacen(DTOControlAlmacen dto)" */
            /*DTOControlAlmacen dtoCA = new DTOControlAlmacen();
            dtoCA.setOidPais(Long.valueOf("1"));
            dtoCA.setOidIdioma(Long.valueOf("1"));
            
            dtoCA.setOidControlAlmacen(Long.valueOf("1041"));
            dtoCA.setOidSubacceso(Long.valueOf("1"));
            dtoCA.setOidProducto(Long.valueOf("254"));
            dtoCA.setOidAlmacen(Long.valueOf("4"));
            dtoCA.setStockMinimo(Long.valueOf("500"));
            dtoCA.setStockMaximo(Long.valueOf("5000"));
            dtoCA.setStockReposicion(Long.valueOf("750"));
            char c = 'S';
            dtoCA.setActivado(new Character(c));
            
            mONMantenimientoControlAlmacen.actualizarControlAlmacen(dtoCA);*/
            /** FIN PRUEBA 1 */
            
            /** PRUEBA 2 - al metodo "DTOControlAlmacen obtenerControlAlmacen(DTOOID dto)" */
            DTOOID dtoOid = new DTOOID();
            dtoOid.setOid(Long.valueOf("1031"));
            DTOControlAlmacen controlObtenido = mONMantenimientoControlAlmacen.obtenerControlAlmacen(dtoOid);
            System.out.println(controlObtenido);
            /** FIN PRUEBA 2 */
            
            /** PRUEBA 3 - al metodo "DTOSalida buscarControlesAlmacen(DTOControlAlmacen dto)" */
            /*DTOControlAlmacen dtoCA2 = new DTOControlAlmacen();
            dtoCA2.setOidPais(Long.valueOf("1"));
            dtoCA2.setOidIdioma(Long.valueOf("1"));
            
            dtoCA2.setOidProducto(Long.valueOf("1016"));
            dtoCA2.setTamanioPagina(Integer.valueOf("10"));
            dtoCA2.setIndicadorSituacion(Integer.valueOf("0"));
            DTOSalida controles = mONMantenimientoControlAlmacen.buscarControlesAlmacen(dtoCA2);
            System.out.println(controles.getResultado());*/
            /** FIN PRUEBA 3 */
            
            /** PRUEBA 4 - al metodo "void eliminarControlAlmacen(DTOOIDs dto)" */
            /*DTOOIDs dtoOids = new DTOOIDs();
            Long oids[] = new Long[2];
            oids[0] = Long.valueOf("1031");
            oids[1] = Long.valueOf("1040");
            dtoOids.setOids(oids);
            mONMantenimientoControlAlmacen.eliminarControlAlmacen(dtoOids);*/
            /** FIN PRUEBA 4 */
            

        } catch(Throwable ex) {
            ex.printStackTrace();
            if (ex instanceof MareException) {
                System.out.println( ((MareException) ex).getOriginalCause() );
            }
        }
    }
    
    private static Context getInitialContext() throws NamingException
    {
        Hashtable env = new Hashtable();
        // Standalone OC4J connection details
        env.put(Context.INITIAL_CONTEXT_FACTORY, "com.evermind.server.rmi.RMIInitialContextFactory");
        //env.put(Context.SECURITY_PRINCIPAL, "PEPRUEBAS");
        //env.put(Context.SECURITY_CREDENTIALS, "belcorp");
        
        env.put(Context.SECURITY_PRINCIPAL, "admin");
        env.put(Context.SECURITY_CREDENTIALS, "belcorp");
        
        env.put(Context.PROVIDER_URL, "ormi://cdos0075:23791/mare");
        //env.put(Context.PROVIDER_URL, "ormi://cdos02ap:3104/sicc_server");

        return new InitialContext(env);
    }
}