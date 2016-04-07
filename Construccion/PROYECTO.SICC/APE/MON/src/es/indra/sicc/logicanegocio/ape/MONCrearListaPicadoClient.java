package es.indra.sicc.logicanegocio.ape;
import es.indra.sicc.dtos.fac.DTOFACCabeceraSolicitud;
import es.indra.sicc.dtos.fac.DTOFACConsolidado;
import es.indra.sicc.dtos.fac.DTOFACPosicionSolicitud;
import es.indra.sicc.logicanegocio.fac.MONFacturacion;
import es.indra.sicc.logicanegocio.fac.MONFacturacionHome;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.rmi.PortableRemoteObject;
import es.indra.sicc.logicanegocio.ape.MONCrearListaPicado;
import es.indra.sicc.logicanegocio.ape.MONCrearListaPicadoHome;
import javax.naming.NamingException;
import java.util.Hashtable;

public class MONCrearListaPicadoClient 
{
    public static void main(String [] args)
    {
        MONCrearListaPicadoClient mONCrearListaPicadoClient = new MONCrearListaPicadoClient();
        try
        {
            Context context = getInitialContext();
            MONCrearListaPicadoHome mONCrearListaPicadoHome = (MONCrearListaPicadoHome)PortableRemoteObject.narrow(context.lookup("MONCrearListaPicado"), MONCrearListaPicadoHome.class);
            MONCrearListaPicado mONCrearListaPicado;

            // Use one of the create() methods below to create a new instance
            mONCrearListaPicado = mONCrearListaPicadoHome.create();

            // Call any of the Remote methods below to access the EJB
            // mONCrearListaPicado.setSecuencia( java.lang.String secuencia );
            // mONCrearListaPicado.setLstProcesoFueraPedido( java.util.ArrayList lstProcesoFueraPedido );
            // mONCrearListaPicado.setListaPicadoCabecera( es.indra.sicc.dtos.ape.DTOListaPicadoCabecera listaPicadoCabecera );
            // mONCrearListaPicado.setDatosMapas( es.indra.sicc.dtos.ape.DTOMapas datosMapas );
            // mONCrearListaPicado.setDatosLinea( es.indra.sicc.dtos.ape.DTODatosLinea datosLinea );
            // mONCrearListaPicado.setConsolidado( es.indra.sicc.dtos.fac.DTOFACConsolidado consolidado );
            // mONCrearListaPicado.setConfiguracionCD( es.indra.sicc.dtos.ape.DTOConfiguracionCentroDistribucion configuracionCD );
            // mONCrearListaPicado.ordenarListaPicadoDetalle(  );
            // mONCrearListaPicado.obtenerListaProductos(  );
            // mONCrearListaPicado.grabarListaPicado(  );
            // mONCrearListaPicado.getSecuencia(  );
            // mONCrearListaPicado.getLstProcesoFueraPedido(  );
            // mONCrearListaPicado.getListaPicadoCabecera(  );
            // mONCrearListaPicado.getDatosMapas(  );
            // mONCrearListaPicado.getDatosLinea(  );
            // mONCrearListaPicado.getConsolidado(  );
            // mONCrearListaPicado.getConfiguracionCD(  );
            // mONCrearListaPicado.generarEtiquetas(  );
            // mONCrearListaPicado.crearSecuencia(  );
            
     // Generamos el parametro de entrada al metodo del MON
      // Nota: Revisiones:   1=L 2=C 3=A null
      System.out.println("Generando parametro de entrada...");
      DTOFACConsolidado consolidados = mONCrearListaPicadoClient.generarListaConsolidados();
      //new MONCrearListaPicadoClient().mostrarArrayDtos(consolidados);            
            
  

            System.out.println("Voy a llamar a crearListaPicado, el MON es " + mONCrearListaPicado);
            System.out.println("La clase del MON es: " + mONCrearListaPicado.getClass());
             mONCrearListaPicado.crearListaPicado(consolidados );
            // mONCrearListaPicado.calcularCubicaje(  );
            // mONCrearListaPicado.armarListaPicado(  );
            
            MONFacturacion monFact = ((MONFacturacionHome)PortableRemoteObject.narrow(context.lookup("MONFacturacion"), MONFacturacionHome.class)).create();
            Boolean online = Boolean.FALSE;
            Long oidPais = new Long(1);
            monFact.generarCodigosListasPicado(online, oidPais);
            monFact.generarNumerosEtiquetas(online, oidPais);

        }
        catch(Throwable ex)
        {
            ex.printStackTrace();
        }

    }

  
  private DTOFACConsolidado generarListaConsolidados () {
        
      DTOFACCabeceraSolicitud dtoFACCabecSoli01 = new DTOFACCabeceraSolicitud();
      dtoFACCabecSoli01.setOidCabeceraSolicitud(new Long(10380));
      dtoFACCabecSoli01.setPeriodo(new Long(174));
      dtoFACCabecSoli01.setAlmacen(new Long(3));
      dtoFACCabecSoli01.setTipoSolicitud(new Long(67));
      dtoFACCabecSoli01.setRegion(new Long(1171));
      dtoFACCabecSoli01.setUnidadesAtendidasTotal(new Integer(14));
      dtoFACCabecSoli01.setFechaFacturacion(new Date(2006,07,12));
      dtoFACCabecSoli01.setOidCliente(new Long(1545812));
      dtoFACCabecSoli01.setOidPais(new Long(1));
      dtoFACCabecSoli01.setZona(new Long(1262));
      
      DTOFACPosicionSolicitud dtoFACPosic01Soli01 = new DTOFACPosicionSolicitud();
      dtoFACPosic01Soli01.setOidPosicion(new Long(15458));
      dtoFACPosic01Soli01.setOidCabecera(new Long(10232));
      dtoFACPosic01Soli01.setCodigoProducto("210043017");
      dtoFACPosic01Soli01.setProducto(new Long(110263));
      dtoFACPosic01Soli01.setIndicadorDentroFueraCajaBolsa("C");
      dtoFACPosic01Soli01.setUnidadesAtendidas(new Integer(1));
      dtoFACPosic01Soli01.setPrecioTotalTL(new Float(0));
     
      DTOFACPosicionSolicitud dtoFACPosic02Soli01 = new DTOFACPosicionSolicitud();
      dtoFACPosic02Soli01.setOidPosicion(new Long(15459));      
      dtoFACPosic02Soli01.setOidCabecera(new Long(10232));
      dtoFACPosic02Soli01.setCodigoProducto("210043304");
      dtoFACPosic02Soli01.setProducto(new Long(109216));
      dtoFACPosic02Soli01.setIndicadorDentroFueraCajaBolsa("C");      
      dtoFACPosic02Soli01.setUnidadesAtendidas(new Integer(2));     
      dtoFACPosic02Soli01.setPrecioTotalTL(new Float(0));
      
      /*DTOFACPosicionSolicitud dtoFACPosic03Soli01 = new DTOFACPosicionSolicitud();
      dtoFACPosic03Soli01.setOidPosicion(new Long(15460));      
      dtoFACPosic03Soli01.setOidCabecera(new Long(10232));
      dtoFACPosic03Soli01.setCodigoProducto("210036388");
      dtoFACPosic03Soli01.setProducto(new Long(117707));
      dtoFACPosic03Soli01.setIndicadorDentroFueraCajaBolsa("true");
      dtoFACPosic03Soli01.setUnidadesAtendidas(new Integer(3));     
      dtoFACPosic03Soli01.setPrecioTotalTL(new Float(0));*/

      DTOFACPosicionSolicitud dtoFACPosic04Soli01 = new DTOFACPosicionSolicitud();
      dtoFACPosic04Soli01.setOidPosicion(new Long(15461));      
      dtoFACPosic04Soli01.setOidCabecera(new Long(10232));
      dtoFACPosic04Soli01.setCodigoProducto("200048393");
      dtoFACPosic04Soli01.setProducto(new Long(133346));
      dtoFACPosic04Soli01.setIndicadorDentroFueraCajaBolsa("C");      
      dtoFACPosic04Soli01.setUnidadesAtendidas(new Integer(4));
      dtoFACPosic04Soli01.setPrecioTotalTL(new Float(0));

      DTOFACPosicionSolicitud dtoFACPosic05Soli01 = new DTOFACPosicionSolicitud();
      dtoFACPosic05Soli01.setOidPosicion(new Long(15462));      
      dtoFACPosic05Soli01.setOidCabecera(new Long(10232));
      dtoFACPosic05Soli01.setCodigoProducto("210044379");
      dtoFACPosic05Soli01.setProducto(new Long(133347));
      dtoFACPosic05Soli01.setIndicadorDentroFueraCajaBolsa("F");
      dtoFACPosic05Soli01.setUnidadesAtendidas(new Integer(4));     
      dtoFACPosic05Soli01.setPrecioTotalTL(new Float(0));

      ArrayList listaPosiciones = new ArrayList();
      listaPosiciones.add(dtoFACPosic01Soli01);
      listaPosiciones.add(dtoFACPosic02Soli01);
      //listaPosiciones.add(dtoFACPosic03Soli01);
      listaPosiciones.add(dtoFACPosic04Soli01);
      listaPosiciones.add(dtoFACPosic05Soli01);
      
      Iterator it1 =  listaPosiciones.iterator();
      int i = 0;
        while(it1.hasNext()){
            DTOFACPosicionSolicitud dto = (DTOFACPosicionSolicitud) it1.next();
            i ++;
            System.out.println(i); 
        }
       
      DTOFACConsolidado dtoFACCons01 = new DTOFACConsolidado();
      dtoFACCons01.setDtoCabecera(dtoFACCabecSoli01);
      dtoFACCons01.setListaPosiciones(listaPosiciones);
      dtoFACCons01.setOidIdioma(new Long(1));
      
      return dtoFACCons01;
  }    

  
  private static Context getInitialContext() throws NamingException
  {
    Hashtable env = new Hashtable();
    // Standalone OC4J connection details
    env.put(Context.INITIAL_CONTEXT_FACTORY, "com.evermind.server.rmi.RMIInitialContextFactory");
    env.put(Context.SECURITY_PRINCIPAL, "admin");
    env.put(Context.SECURITY_CREDENTIALS, "belcorp");
    //env.put(Context.PROVIDER_URL, "ormi://192.168.118.102:3104/sicc_server");
    //env.put(Context.PROVIDER_URL, "ormi://192.168.119.182:3104/sicc_server");
    env.put(Context.PROVIDER_URL, "ormi://192.168.119.179:3104/sicc_server");
    //env.put(Context.PROVIDER_URL, "ormi://192.168.119.180:3104/sicc_server");

    return new InitialContext(env);
  }    

    
}