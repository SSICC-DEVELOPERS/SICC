package es.indra.sicc.logicanegocio.ped;
import es.indra.sicc.dtos.ped.DTOArranqueGP;
import es.indra.sicc.dtos.ped.DTOParametroMonitor;
import es.indra.sicc.dtos.ped.DTOSecuenciaSolicitudes;
import es.indra.sicc.dtos.ped.DTOSolicitudValidacion;
import java.util.ArrayList;
import java.util.Date;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.rmi.PortableRemoteObject;
import es.indra.sicc.logicanegocio.ped.MONSecuenciaProcesos;
import es.indra.sicc.logicanegocio.ped.MONSecuenciaProcesosHome;
import javax.naming.NamingException;
import java.util.Hashtable;

public class MONSecuenciaProcesosClient 
{
  public static void main(String [] args)
  {
    MONSecuenciaProcesosClient mONSecuenciaProcesosClient = new MONSecuenciaProcesosClient();
    try
    {
      Context context = getInitialContext();
      MONSecuenciaProcesosHome mONSecuenciaProcesosHome = (MONSecuenciaProcesosHome)PortableRemoteObject.narrow(context.lookup("MONSecuenciaProcesos"), MONSecuenciaProcesosHome.class);
      MONSecuenciaProcesos mONSecuenciaProcesos;

      // Use one of the create() methods below to create a new instance
      mONSecuenciaProcesos = mONSecuenciaProcesosHome.create();

      DTOArranqueGP dto = new DTOArranqueGP();
      DTOSolicitudValidacion dtoS = new DTOSolicitudValidacion();
      dtoS.setOidSolicitud(new Long(1976));
      dtoS.setOidMarca(new Long(1));
      dtoS.setOidIdioma(new Long(1));
      dtoS.setOidPais(new Long(1));
      dtoS.setOidCanal(new Long(1));
      dtoS.setOidPeriodo(new Long(57));
      dtoS.setOidMoneda(null);
      dtoS.setOidTipoSolPais(new Long(1521));
      dtoS.setOidCliente(new Long(1847));
      dtoS.setOidSubAcceso(new Long(8));
      dtoS.setIndSimulacion(Boolean.FALSE);
      dtoS.setIndOrdenCompra(Boolean.FALSE);
      dtoS.setIndPedGTZona(Boolean.TRUE);
      dtoS.setZona(new Long(1));
      dtoS.setUbigeo(new Long(38));
      dtoS.setOidModulo(new Long(1));
      dtoS.setProceso(null);
      dtoS.setNumDecimales(new Integer(2));
      dtoS.setTipoCambio(null);
      dtoS.setOidAcceso(new Long(1));
      dtoS.setNumSolicitud("500001070");
      dtoS.setIndUnionSolicitud(Boolean.TRUE);
      dtoS.setOrden(null);
      dtoS.setOrdenMonitor(null);
      

      ArrayList l = new ArrayList();
      l.add(dtoS);
      dto.setListaSolicitudes(l);
      DTOParametroMonitor dtoS2  = new DTOParametroMonitor();
      dtoS2.setOidGrupoProceso(new Long(5));
      dtoS2.setFechaFacturacion(new Date(System.currentTimeMillis()));
      dtoS2.setModoFacturacion("R");
      dtoS2.setIDProc(null);
      ArrayList l2 = new ArrayList();
      DTOSecuenciaSolicitudes dtoSec = new DTOSecuenciaSolicitudes();
      dtoSec.setOidZona(new Long(1));
      dtoSec.setOidTipoSolicitud(new Long(1521));
      dtoSec.setSecuencia(new Long(1));
      dtoSec.setOidPais(new Long(1));
      dtoSec.setOidIdioma(new Long(1));
      l2.add(dtoSec);
      dtoS2.setSecuencia(l2);
      dtoS2.setOidIdioma(new Long(1));
      dtoS2.setOidPais(new Long(1));
      dto.setParametros(dtoS2);
      dto.setOidIdioma(new Long(1));
      dto.setOidPais(new Long(1));
/*
secuencia:[DTO:
oidZona:13
oidTipoSolicitud:1478
secuencia:1
*/


      
      //mONSecuenciaProcesos.arrancarFacturacion( dto );



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