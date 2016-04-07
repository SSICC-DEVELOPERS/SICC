package es.indra.sicc.logicanegocio.ape;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.rmi.PortableRemoteObject;
import es.indra.sicc.logicanegocio.ape.MONSeleccionarAnaquel;
import es.indra.sicc.logicanegocio.ape.MONSeleccionarAnaquelHome;
import javax.naming.NamingException;
import java.util.Hashtable;
import es.indra.sicc.dtos.ape.DTOAsignacionProductoAnaquelBusqueda;

public class MONSeleccionarAnaquelClient  {
  public static void main(String [] args) {
    MONSeleccionarAnaquelClient mONSeleccionarAnaquelClient = new MONSeleccionarAnaquelClient();
    try {
      Context context = getInitialContext();
      MONSeleccionarAnaquelHome mONSeleccionarAnaquelHome = (MONSeleccionarAnaquelHome)PortableRemoteObject.narrow(context.lookup("MONSeleccionarAnaquel"), MONSeleccionarAnaquelHome.class);
      MONSeleccionarAnaquel mONSeleccionarAnaquel;

      // Use one of the create() methods below to create a new instance
      mONSeleccionarAnaquel = mONSeleccionarAnaquelHome.create();

      // Call any of the Remote methods below to access the EJB
      DTOAsignacionProductoAnaquelBusqueda dto = new DTOAsignacionProductoAnaquelBusqueda();
      
      dto.setOidPeriodo(new Long(1002));
      dto.setOidProducto(new Long(98));
      dto.setOidMapaCDCabecera(new Long(2));
      dto.setOidLinea(new Long(115));
      dto.setCodProducto(new String("343ouythruh"));
      dto.setUnidades(new Integer(15));
      dto.setIndFueraCajaBolsa(new Boolean(true));
      dto.setOidCD(new Long(1));
      dto.setOidConsolidado(new Long(52366));
      
      mONSeleccionarAnaquel.seleccionarAnaquel(dto);

    } catch(Throwable ex) {
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
    env.put(Context.PROVIDER_URL, "ormi://192.168.118.102:3101/sicc_server");
    return new InitialContext(env);
  }
  
}