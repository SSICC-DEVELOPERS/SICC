package es.indra.sicc.logicanegocio.ped.applet;

import es.indra.sicc.cmn.negocio.interfaces.comun.InterfacesException;
import es.indra.sicc.logicanegocio.seg.ConstantesSEG;
import es.indra.sicc.util.UtilidadesLog;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import java.util.Hashtable;

public class MONRegistroOnlineClient 
{
  public static void main(String [] args)
  {
    MONRegistroOnlineClient mONRegistroOnlineClient = new MONRegistroOnlineClient();
    try
    {
      //Context context = getInitialContext();
      //MONRegistroOnlineHome mONRegistroOnlineHome = (MONRegistroOnlineHome)PortableRemoteObject.narrow(context.lookup("MONRegistroOnline"), MONRegistroOnlineHome.class);
     // BusinessFacadeHome businessFacadeHome = (BusinessFacadeHome)PortableRemoteObject.narrow(context.lookup("mare.mln.BusinessFacade"), BusinessFacadeHome.class);
      //MONRegistroOnline mONRegistroOnline;
      //BusinessFacade businessFacade;
      // Use one of the create() methods below to create a new instance
      //mONRegistroOnline = mONRegistroOnlineHome.create();
      //businessFacade = businessFacadeHome.create();

      // Call any of the Remote methods below to access the EJB
      // mONRegistroOnline.validarCodigoVenta( es.indra.sicc.dtos.ped.applet.DTOInfoProducto DTOInfoProducto );
      // mONRegistroOnline.validarCodigoProducto( es.indra.sicc.dtos.ped.applet.DTOInfoProducto DTOInfoProducto );
      // mONRegistroOnline.revertirAlmacen( es.indra.sicc.dtos.ped.applet.DTORevertirPosicionRegistro dtoe );
      // mONRegistroOnline.reservarAlmacen( es.indra.sicc.dtos.ped.applet.DTOGenerarPosicionRegistro dtoe );
      // mONRegistroOnline.obtenerTipoOferta( es.indra.sicc.dtos.ped.DTOCabeceraSolicitud cabeceraSolicitud, java.lang.String cv );
      // mONRegistroOnline.obtenerSolicitudesAnteriores( es.indra.sicc.util.DTOOID dtoOid );
      // mONRegistroOnline.obtenerInfoGestionStock( es.indra.sicc.dtos.ped.applet.DTOInfoProducto DTOInfoProducto );
      // mONRegistroOnline.obtenerFlete( es.indra.sicc.dtos.ped.applet.DTOPresentarFlete dtoe );
      // mONRegistroOnline.obtenerCargaInicial( es.indra.sicc.dtos.ped.applet.DTOCargaRegistroOnline dtoOut );
      // mONRegistroOnline.obtenerCargaBusquedaProductos( es.indra.sicc.util.DTOBelcorp dtoe );
      // mONRegistroOnline.grabarSolicitud( es.indra.sicc.dtos.ped.DTOCabeceraSolicitud DTOCabeceraSolicitud );
      // mONRegistroOnline.generarPosicion( es.indra.sicc.dtos.ped.applet.DTOGenerarPosicionRegistro dtoe );
      // mONRegistroOnline.crearDTOMovimientoAlmacenDetalle( es.indra.sicc.dtos.ped.DTOCabeceraSolicitud cabeceraSolicitud, es.indra.sicc.dtos.ped.DTOPosicionSolicitud posicionSolicitud, java.lang.Long cantidadReservar, java.lang.String movimiento );
      // mONRegistroOnline.crearDTOMovimientoAlmacen( es.indra.sicc.dtos.ped.DTOCabeceraSolicitud cabeceraSolicitud, es.indra.sicc.dtos.ped.DTOPosicionSolicitud posicionSolicitud, java.lang.Boolean noGenerarCabecera, java.lang.Long cantidadReservar );
      // mONRegistroOnline.buscarProductosRegistro( es.indra.sicc.dtos.ped.applet.DTOBuscarProductosRegistro dtoe );
      // mONRegistroOnline.buscarProductosAlternativos( es.indra.sicc.dtos.ped.applet.DTOInfoProducto DTOE );
      
      /*DTOCargaRegistroOnline dtoe =  new DTOCargaRegistroOnline();
      dtoe.setBelcenter(Boolean.FALSE);
      dtoe.setOidCanal(new Long(1));
      dtoe.setIP("127.0.0.1");
      dtoe.setOidPais(new Long(1));
      dtoe.setOidIdioma(new Long(1));
      dtoe.setOidAcceso(new Long(1));
      dtoe.setOidSubAcceso(new Long(8));
      dtoe.setIpCliente("127.0.0.1");*/
      /*DTODatosCliente DTOE = new DTODatosCliente();
      DTOE.setCodCliente("00000000001");
      DTOE.setOidPais(new Long(1));
      DTOE.setOidIdioma(new Long(1));*/
      /*DTOGenerarPosicionRegistro dtoe = new DTOGenerarPosicionRegistro();
      DTOCabeceraSolicitud dtoC = new DTOCabeceraSolicitud();
      
      dtoe.setCabeceraSolicitud(dtoC);*/
      /*DTOInfoProducto dtoe = new DTOInfoProducto();
      dtoe.setCodigoProducto("200007727-N003");
      dtoe.setCodigoVenta("0001006");
      dtoe.setOidCliente(new Long(1376));
      dtoe.setOidProducto(new Long(76));
      dtoe.setOidPais(new Long(1));
      dtoe.setOidIdioma(new Long(1));
      dtoe.setOidMarca(new Long(1));
      dtoe.setPeriodo(new Long(57));
      dtoe.setOidZona(new Long(1));
      dtoe.setAcceso(new Long(1));
      dtoe.setSubacceso(new Long(8));
      dtoe.setIpCliente("127.0.0.1");*/
      
      
/*	<PARAM NAME="fechaSistema" VALUE="09/12/2004"/>*/

	//<PARAM NAME="oidTipoCliente" VALUE="1"/>
	//<PARAM NAME="oidTipoSolicitud" VALUE="1389"/>
	//<PARAM NAME="belcenter" VALUE="false"/>
	//<PARAM NAME="oidCanal" VALUE="1"/>
      //DTOCabeceraSolicitud dtoe = new DTOCabeceraSolicitud();
      //mONRegistroOnline.buscarDatosCliente( DTOE );
      /*DTOOID dtoe = new DTOOID();
      dtoe.setOidIdioma(new Long(1));
      dtoe.setOidPais(new Long(1));
      dtoe.setOid(new Long(1376));*/
     /* DTOBuscarProductosRegistro dtoe = new DTOBuscarProductosRegistro();
      dtoe.setOidIdioma(new Long(1));
      dtoe.setOidPais(new Long(1));
      MareBusinessID id = new MareBusinessID("PEDBuscarProductosRegistro");
      UtilidadesLog.debug(businessFacade.execute(dtoe, id));*/
      UtilidadesLog.debug(parsearBigDecimal("0,99  ","0",2));
    }
    catch(Throwable ex)
    {
      UtilidadesLog.debug(ex);
    }
  }
  
  protected static BigDecimal parsearBigDecimal( String strBigDecimal, String relleno, int decimales )
	throws InterfacesException {
	
	BigDecimal bigDecimal;

    // Eliminamos los caracteres de relleno de la parte izquierda
    StringBuffer buffer = new StringBuffer( strBigDecimal.trim() );
    while( buffer.length() > 0 && buffer.substring(0,1).equals(relleno) )
      buffer.delete(0,1);
    int coma = buffer.indexOf(",");
    if (coma>-1){
        buffer.replace(coma,coma+1,".");
    }  
    String str = buffer.toString();

    try {
      bigDecimal = new BigDecimal( str );
    } catch( NumberFormatException ex ) {
      UtilidadesLog.debug(ex);
      throw new InterfacesException( 
        "Formato de número decimal incorrecto: " + strBigDecimal, ex );
    }
    
    double divisor = Math.pow( 10, decimales );

    return new BigDecimal( bigDecimal.doubleValue() / divisor );
	}
  
  private static void pruebaDAO(){
      StringBuffer buf = new StringBuffer();
      Long pais = new Long (1);
      Long subacceso = new Long (1);
      Long idioma = new Long (1);
      Boolean belcenter = Boolean.TRUE;
    
      buf.append("SELECT TSP.OID_TIPO_SOLI_PAIS OID_TSP, GEN_TS.VAL_I18N TIPO_SOLICITUD, ");
      buf.append("M.OID_MARC OID_MARCA, M.DES_MARC MARCA, C.OID_CANA OID_CANAL, GEN_C.VAL_I18N CANAL, "); 
      buf.append("AC.OID_ACCE OID_ACCESO, GEN_AC.VAL_I18N ACCESO, TS.SBAC_OID_SBAC OID_SUBACCESO, ");
      buf.append("GEN_SAC.VAL_I18N SUBACCESO, TSP.MONE_OID_MONE OID_MONEDA, GEN_MO.VAL_I18N MONEDA, ");
      buf.append("TS.TICL_OID_TIPO_CLIE TIPO_CLIENTE, P.OID_PERI OID_PERIODO, P.VAL_NOMB_PERI PERIODO, TSP.IND_RESE_STOC RESERVA_STOCK ");
      
      buf.append(" FROM PED_TIPO_SOLIC_PAIS TSP, GEN_I18N_SICC GEN_TS, SEG_MARCA M, PED_TIPO_SOLIC TS, ");
      buf.append(" GEN_I18N_SICC GEN_C, SEG_CANAL C, SEG_ACCES AC, GEN_I18N_SICC GEN_AC, GEN_I18N_SICC GEN_SAC, ");
      buf.append(" GEN_I18N_SICC GEN_MO, PED_CLASE_SOLIC CS, CRA_PERIO P ");
      
      buf.append("WHERE GEN_TS.VAL_OID = TSP.TSOL_OID_TIPO_SOLI AND GEN_TS.IDIO_OID_IDIO = " + idioma + " AND GEN_TS.ATTR_ENTI = 'PED_TIPO_SOLIC' AND ");
      /* PAIS = RECIBIDO */ 
      buf.append("TSP.PAIS_OID_PAIS = " + pais + " AND ");
      
      if(belcenter != null && belcenter.booleanValue()) {
          buf.append("TS.ACCE_OID_ACCE = AC.OID_ACCE AND ");
          buf.append("( AC.COD_ACCE = '" + ConstantesSEG.ACCESO_BELCENTER + "' OR AC.COD_ACCE = '" + ConstantesSEG.ACCESO_CALLCENTER +"' ) AND ");
          buf.append("TSP.TSOL_OID_TIPO_SOLI = TS.OID_TIPO_SOLI AND TS.CLSO_OID_CLAS_SOLI = CS.OID_CLAS_SOLI AND CS.IND_ORDE_COMP = 1 AND ");
          buf.append("TS.ACCE_OID_ACCE = AC.OID_ACCE AND AC.CANA_OID_CANA =  C.OID_CANA AND C.COD_CANA = '" + ConstantesSEG.COD_CANAL_VD + "' AND  ");
          if (subacceso != null){
              buf.append("TS.SBAC_OID_SBAC = " + subacceso + " AND ");
          }
      }
      
      /* MARCA */ 
      buf.append(" TSP.TSOL_OID_TIPO_SOLI = TS.OID_TIPO_SOLI AND TS.MARC_OID_MARC = M.OID_MARC AND ");
      /* CANAL */ 
      buf.append(" TS.ACCE_OID_ACCE = AC.OID_ACCE AND AC.CANA_OID_CANA = C.OID_CANA AND GEN_C.VAL_OID = C.OID_CANA AND GEN_C.IDIO_OID_IDIO = " + idioma + " AND GEN_C.ATTR_ENTI = 'SEG_CANAL' AND ");
      /* ACCESO */ 
      buf.append(" TS.ACCE_OID_ACCE = AC.OID_ACCE AND GEN_AC.VAL_OID = AC.OID_ACCE AND GEN_AC.IDIO_OID_IDIO = " + idioma + " AND GEN_AC.ATTR_ENTI = 'SEG_ACCES' AND ");
      /* SUBACCESO */
      buf.append(" GEN_SAC.VAL_OID = TS.SBAC_OID_SBAC AND GEN_SAC.IDIO_OID_IDIO = " + idioma + " AND GEN_SAC.ATTR_ENTI = 'SEG_SUBAC' AND ");
      /* MONEDA */ 
      buf.append(" GEN_MO.VAL_OID = TSP.MONE_OID_MONE AND GEN_MO.IDIO_OID_IDIO = " + idioma + " AND GEN_MO.ATTR_ENTI = 'SEG_MONED' ");  
      /* PERIODO */
      SimpleDateFormat dt = new SimpleDateFormat("dd-MM-yyyy");
      buf.append(" AND P.FEC_INIC < to_date('"+dt.format(new Date(System.currentTimeMillis()))+"','DD-MM-YYYY') ");
      buf.append(" AND P.FEC_FINA > to_date('"+dt.format(new Date(System.currentTimeMillis()))+"','DD-MM-YYYY') ");
      buf.append(" AND P.PAIS_OID_PAIS = TSP.PAIS_OID_PAIS ");
      buf.append(" AND P.MARC_OID_MARC = TS.MARC_OID_MARC ");
      buf.append(" AND TS.ACCE_OID_ACCE = AC.OID_ACCE ");
      buf.append(" AND P.CANA_OID_CANA = AC.CANA_OID_CANA ");

      /*AGREGADO POR jquiroga para que tenga sentido el metodo MONRegistroOnline.crearDTOTiposSolicitud() */
      buf.append(" Order by OID_TSP");
      UtilidadesLog.debug(buf.toString());
  }

  
  private static Context getInitialContext() throws NamingException
  {
    // Get InitialContext for Embedded OC4J.
    // The embedded server must be running for lookups to succeed.
    Hashtable env = new Hashtable();
    // Standalone OC4J connection details
    env.put(Context.INITIAL_CONTEXT_FACTORY, "com.evermind.server.rmi.RMIInitialContextFactory");
    env.put(Context.SECURITY_PRINCIPAL, "admin");
    env.put(Context.SECURITY_CREDENTIALS, "welcome");
    env.put(Context.PROVIDER_URL, "ormi://localhost:23891/current-workspace-app");
    return new InitialContext(env);
  }  
}