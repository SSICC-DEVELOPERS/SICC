package es.indra.sicc.logicanegocio.msg;
import es.indra.sicc.dtos.msg.DTOSeleccionMensajes;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.rmi.PortableRemoteObject;
import es.indra.sicc.logicanegocio.msg.MONImpresionMensajes;
import es.indra.sicc.logicanegocio.msg.MONImpresionMensajesHome;
import javax.naming.NamingException;
import java.util.Hashtable;

public class MONImpresionMensajesClient 
{
  public static void main(String [] args)
  {
    MONImpresionMensajesClient mONImpresionMensajesClient = new MONImpresionMensajesClient();
    try
    {
      Context context = getInitialContext();
      MONImpresionMensajesHome mONImpresionMensajesHome = (MONImpresionMensajesHome)PortableRemoteObject.narrow(context.lookup("MONImpresionMensajes"), MONImpresionMensajesHome.class);
      MONImpresionMensajes mONImpresionMensajes;

      // Use one of the create() methods below to create a new instance
      mONImpresionMensajes = mONImpresionMensajesHome.create();

      // Call any of the Remote methods below to access the EJB
      DTOSeleccionMensajes DTOE = new DTOSeleccionMensajes();
      DTOE.setCodigoCliente("00000000001");
      DTOE.setOidPatron(new Long(1168));
      DTOE.setOidIdioma(new Long(1));
      DTOE.setOidPais(new Long(1));
      DTOE.setOidPeriodo(new Long(72));
      
      mONImpresionMensajes.simularMensajes(  DTOE);
      // mONImpresionMensajes.obtenerUACliente( java.lang.Long oidCliente );
      // mONImpresionMensajes.obtenerTipificacionCliente( es.indra.sicc.util.DTOOID DTOE );
      // mONImpresionMensajes.obtenerRestoMensajes( es.indra.sicc.dtos.msg.DTOMensajeImpresion[] DTOE );
      // mONImpresionMensajes.obtenerMensajesG2( es.indra.sicc.dtos.msg.DTOMensajeImpresion[] DTOE );
      // mONImpresionMensajes.obtenerMarcasCliente( java.lang.Long oidCliente );
      // mONImpresionMensajes.obtenerClientes( es.indra.sicc.dtos.msg.DTOMensajeImpresion[] DTOE );
      // mONImpresionMensajes.imprimirMensajesFacturacion( es.indra.sicc.dtos.fac.DTOFACConsolidado DTOConsolidado );
      // mONImpresionMensajes.imprimirMensajesDesdeEditor( es.indra.sicc.dtos.msg.DTOSeleccionMensajes DTOE );
      // mONImpresionMensajes.existeOrdenCompra( es.indra.sicc.dtos.fac.DTOFACConsolidado DTOE );
      // mONImpresionMensajes.existeCodigoVenta( es.indra.sicc.dtos.fac.DTOFACConsolidado DTOE, java.lang.Long oidMensaje );
      // mONImpresionMensajes.crearDTOMensajesFinal( java.lang.Integer i, es.indra.sicc.util.DTOOIDs dtoClientes, es.indra.sicc.dtos.msg.DTOMensajeImpresion[] DTOMensa, es.indra.sicc.dtos.msg.DTOMensajeImpresion[] dtoMensaG2 );
      // mONImpresionMensajes.consultarMensajesPorConsultora( es.indra.sicc.dtos.msg.DTOSeleccionMensajes DTOE );
      // mONImpresionMensajes.actualizarMensajesFacturacion( es.indra.sicc.dtos.msg.DTOImpresion[] DTOE, java.lang.Long numeroLote );

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
    env.put(Context.SECURITY_CREDENTIALS, "welcome");
    env.put(Context.PROVIDER_URL, "ormi://localhost:23891/current-workspace-app");

    return new InitialContext(env);
  }
}