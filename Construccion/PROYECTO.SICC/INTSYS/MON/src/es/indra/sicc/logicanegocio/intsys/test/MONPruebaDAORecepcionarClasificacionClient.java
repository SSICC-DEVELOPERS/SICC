package es.indra.sicc.logicanegocio.intsys.test;

import es.indra.sicc.dtos.intsys.DTOINTRecepcionarClasificacion;
import java.util.ArrayList;
import java.util.Vector;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.rmi.PortableRemoteObject;
import es.indra.sicc.logicanegocio.intsys.MONPruebaDAORecepcionarClasificacion;
import es.indra.sicc.logicanegocio.intsys.MONPruebaDAORecepcionarClasificacionHome;
import javax.naming.NamingException;
import java.util.Hashtable;
import es.indra.mare.common.mii.services.jdbcservice.RecordSet;

public class MONPruebaDAORecepcionarClasificacionClient 
{
    public static void main(String [] args)
    {
        MONPruebaDAORecepcionarClasificacionClient mONPruebaDAORecepcionarClasificacionClient = new MONPruebaDAORecepcionarClasificacionClient();
        try
        {
            Context context = getInitialContext();
            MONPruebaDAORecepcionarClasificacionHome mONPruebaDAORecepcionarClasificacionHome = (MONPruebaDAORecepcionarClasificacionHome)PortableRemoteObject.narrow(context.lookup("MONPruebaDAORecepcionarClasificacion"), MONPruebaDAORecepcionarClasificacionHome.class);
            MONPruebaDAORecepcionarClasificacion mONPruebaDAORecepcionarClasificacion;

            // Use one of the create() methods below to create a new instance
            mONPruebaDAORecepcionarClasificacion = mONPruebaDAORecepcionarClasificacionHome.create();

            // Call any of the Remote methods below to access the EJB
            //1°Prueba metodo obtenerTipoClasificacion
            DTOINTRecepcionarClasificacion dtoe = new DTOINTRecepcionarClasificacion();
            dtoe.setModoEjecucion(new Long(1));
            RecordSet rs = mONPruebaDAORecepcionarClasificacion.obtenerTipoClasificacion(dtoe);
            System.out.println("*** rs " + rs);
            
            //2° Prueba metodo obtenerPeriodo      
            String codPeriodo = new String("200607");
            Long oidPais = new Long(1);                    
            Long oid = mONPruebaDAORecepcionarClasificacion.obtenerPeriodo(codPeriodo, oidPais);
            System.out.println("*** oid " + oid);
            
            //3° Prueba metodo obtenerPais        
            String codPais = new String("PE");          
            Long pais = mONPruebaDAORecepcionarClasificacion.obtenerPais(codPais);
            System.out.println("*** pais " + pais);
            
            //4° Prueba metodo obtenerOIDTipoClasificacion
            java.lang.String codigoClasificacion = new String("01");
            java.lang.Long oidCliente = new Long(1);         
            Long oidTipo = mONPruebaDAORecepcionarClasificacion.obtenerOIDTipoClasificacion(codigoClasificacion, oidCliente);
            System.out.println("*** oidTipo " + oidTipo);
            
            //5° Prueba metodo obtenerModosEjecucion          
            RecordSet modos = mONPruebaDAORecepcionarClasificacion.obtenerModosEjecucion();
            System.out.println("*** modos " + modos);
            
            //6° Prueba metodo obtenerClientesClasificacion
            RecordSet clasifi = new RecordSet(); 
            Vector v = null;    
            clasifi.addColumn("OID_TIPO_CLAS");        
            v = new Vector();
            v.add(new Long(1));
            clasifi.addRow(v);
            
            ArrayList clientes = new ArrayList();
            Long oidClie = new Long(1);
            clientes.add(oidClie);
            String paisST = new String("1");                       
            RecordSet clientesClasi = mONPruebaDAORecepcionarClasificacion.obtenerClientesClasificacion(clasifi, clientes, paisST);
            
            //7° Prueba metodo obtenerClienteTipoSubTipo       
            String codigoCliente = new String("00000000001");
            String otroPais = new String("1");            
            RecordSet clienTipoSub = mONPruebaDAORecepcionarClasificacion.obtenerClienteTipoSubTipo(codigoCliente, otroPais);
            System.out.println("**** clienTipoSub " + clienTipoSub);
            
            //8° Prueba metodo obtenerClasificacion           
            Long oidTipoClasificacion = new Long(1);            
            Long clasi = mONPruebaDAORecepcionarClasificacion.obtenerClasificacion(oidTipoClasificacion);
            System.out.println("*** clasi " + clasi);
            
            //9° Prueba metodo eliminarClienteClasificacion           
            ArrayList clientes2 = new ArrayList();
            String codClien = new String("00000000001");
            clientes2.add(codClien);
            RecordSet clasificaciones = new RecordSet();
            Vector v2 = null;    
            clasificaciones.addColumn("OID_TIPO_CLAS");        
            v2 = new Vector();
            v2.add(new Long(1));
            clasificaciones.addRow(v);
           
            String pais3 = new String("1");
            mONPruebaDAORecepcionarClasificacion.eliminarClienteClasificacion(clientes2, clasificaciones, pais3);

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