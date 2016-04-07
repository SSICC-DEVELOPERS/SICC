package es.indra.sicc.logicanegocio.zon;
import es.indra.sicc.dtos.zon.DTOFicheroDisp;
import es.indra.sicc.util.DTOBelcorp;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.rmi.PortableRemoteObject;
import es.indra.sicc.logicanegocio.zon.MONUnidadAdmInterfaceGIS;
import es.indra.sicc.logicanegocio.zon.MONUnidadAdmInterfaceGISHome;
import javax.naming.NamingException;
import java.util.Hashtable;

public class MONUnidadAdmInterfaceGISClient 
{
  public static void main(String [] args)
  {
    MONUnidadAdmInterfaceGISClient mONUnidadAdmInterfaceGISClient = new MONUnidadAdmInterfaceGISClient();
    try
    {
      Context context = getInitialContext();
      MONUnidadAdmInterfaceGISHome mONUnidadAdmInterfaceGISHome = (MONUnidadAdmInterfaceGISHome)PortableRemoteObject.narrow(context.lookup("MONUnidadAdmInterfaceGIS"), MONUnidadAdmInterfaceGISHome.class);
      MONUnidadAdmInterfaceGIS mONUnidadAdmInterfaceGIS;

      // Use one of the create() methods below to create a new instance
      mONUnidadAdmInterfaceGIS = mONUnidadAdmInterfaceGISHome.create();

      // Call any of the Remote methods below to access the EJB
      // mONUnidadAdmInterfaceGIS.validarCabecera( java.lang.Object datos, java.lang.String typeProc, java.lang.String filePath, java.lang.String fileName );
      DTOFicheroDisp datos = new DTOFicheroDisp();
      datos.setDescripcion("nada");
      datos.setNombreFichero("CREARUA_3.txt");
      datos.setPathFichero("/home/oracle/OraHome1/sicc/druida/tmp/");
      DTOBelcorp dto = new DTOBelcorp();
      dto.setOidIdioma(new Long(1));
      dto.setOidPais(new Long(1));
      datos.setDatos(dto);
      datos.setPrograma("algo");
      datos.setIpCliente("127.0.0.1");
      datos.setOidIdioma(new Long(1));
      datos.setOidPais(new Long(1));
      datos.setTypeProc("ZONProcesarFicheroCrearUA");
      System.out.println(mONUnidadAdmInterfaceGIS.procesarsinc(  datos ));
      // mONUnidadAdmInterfaceGIS.procesarEliminarUA( java.lang.Long iDProc, java.lang.String filePath, java.lang.String typeProc );
      // mONUnidadAdmInterfaceGIS.procesarCrearUA( java.lang.Long iDProc, java.lang.String filePath, java.lang.String typeProc );
      // mONUnidadAdmInterfaceGIS.obtenerResultado( java.lang.Long iDproc );
      // mONUnidadAdmInterfaceGIS.ficherosDisponibles( java.lang.String typeProc );

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
    env.put(Context.PROVIDER_URL, "ormi://192.168.119.180:3104/sicc_server");

    return new InitialContext(env);
  }
}