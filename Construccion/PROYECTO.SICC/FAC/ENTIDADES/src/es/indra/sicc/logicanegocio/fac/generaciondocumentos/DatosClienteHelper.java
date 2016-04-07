package es.indra.sicc.logicanegocio.fac.generaciondocumentos;
import es.indra.mare.common.exception.MareException;
import es.indra.mare.common.mii.services.jdbcservice.RecordSet;
import es.indra.sicc.dtos.fac.DTOSolicitudClienteHelper;
import es.indra.sicc.dtos.fac.DTOUnidAdimClienteHelper;
import es.indra.sicc.dtos.mae.DTOCliente;
import es.indra.sicc.dtos.mae.DTOComunicacion;
import es.indra.sicc.dtos.mae.DTOCrearClienteBasico;
import es.indra.sicc.dtos.mae.DTODireccion;
import es.indra.sicc.logicanegocio.mae.DAOMAEMaestroClientes;
import es.indra.sicc.logicanegocio.seg.ConstantesSEG;
import es.indra.sicc.util.BelcorpService;
import es.indra.sicc.util.CodigosError;
import es.indra.sicc.util.DTOOID;
import es.indra.sicc.util.UtilidadesEJB;
import es.indra.sicc.util.UtilidadesError;
import es.indra.sicc.util.UtilidadesLog;

import java.math.BigDecimal;
import java.util.Vector;

//creado por la incidencia 21174
public class DatosClienteHelper 
{
    public DatosClienteHelper()
    {
    }
    
    public DTOClienteSolicitud obtenerDatosCliente (Long oidSolicitud, String usuario) throws MareException {
        try{
            UtilidadesLog.info("DatosClienteHelper.obtenerDatosCliente(Long oidSolicitud, String usuario): Entada");

            DTOSolicitudClienteHelper dtoSolCliente = (DTOSolicitudClienteHelper)this.obtenerSolicitud(oidSolicitud);
            
            UtilidadesLog.debug("Datos Cliente Helper. El usuario es: "+usuario);
            DAOMAEMaestroClientes daoMAEMaestroClientes = new DAOMAEMaestroClientes(usuario);
            Long oidIdioma = ConstantesSEG.IDIOMA_DEFECTO;
            DTOOID dtoOid = new DTOOID();
            dtoOid.setOid(dtoSolCliente.getOidCliente());
            dtoOid.setOidPais(dtoSolCliente.getOidPais());
            dtoOid.setOidIdioma(oidIdioma);
            DTOCliente dtoCliente = daoMAEMaestroClientes.obtenerClienteBatch(dtoOid);
            DTOClienteSolicitud dtoClienteSolicitud = new DTOClienteSolicitud();
            dtoClienteSolicitud.setCodigoCliente(dtoCliente.getBase().getCodigoCliente());
            String nombre1 = ((DTOCrearClienteBasico)dtoCliente.getBase()).getNombre1();
            String nombre2 = ((DTOCrearClienteBasico)dtoCliente.getBase()).getNombre2();
            String apellido1 = ((DTOCrearClienteBasico)dtoCliente.getBase()).getApellido1();
            String apellido2 = ((DTOCrearClienteBasico)dtoCliente.getBase()).getApellido2();
            if (nombre1==null){
                nombre1 = "";
            }
            if (nombre2==null){
                nombre2 = "";
            }
            if (apellido1==null){
                apellido1 = "";
            }
            if (apellido2==null){
                apellido2 = "";
            }
            dtoClienteSolicitud.setNombre(apellido1 + " " +apellido2 +", " + nombre1 + " " + nombre2);;
            
            DTODireccion direccionTemp [] = null;
            DTODireccion direccion = null;
            String descTipoVia="";
        
            direccionTemp = ((DTOCrearClienteBasico)dtoCliente.getBase()).getDirecciones();
            RecordSet rsTipoVia=null;
            for(int i= 0; i < direccionTemp.length; i++){
                if(direccionTemp[i].getEsDireccionPrincipal() != null && direccionTemp[i].getEsDireccionPrincipal().booleanValue()){
                    direccion = direccionTemp[i];
                    i = direccionTemp.length;
                    rsTipoVia = this.obtenerTipoVia(direccion.getTipoVia());
                    if (rsTipoVia.esVacio()){
                        UtilidadesLog.error("DatosClienteHelper.obtenerDatosCliente: Error al obtener el tipo de via");
                        throw new MareException(new Exception(),UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS));
                    }
                    descTipoVia = (rsTipoVia.getValueAt(0,"ABREVIATURA").toString());
                }
            }
            dtoClienteSolicitud.setDescripcionVia(descTipoVia);
            dtoClienteSolicitud.setNombreVia(direccion.getNombreVia());
            dtoClienteSolicitud.setNumero(direccion.getNumeroPrincipal());
            dtoClienteSolicitud.setObservaciones(direccion.getObservaciones());
        
            DAODocuContable dao=new DAODocuContable();
            String ubigeo = "";
            if(dtoSolCliente.getOidUbigeo()!=null){
                ubigeo = dao.obtenerDescripcionUBIGEO(dtoSolCliente.getOidUbigeo());
            }
            dtoClienteSolicitud.setDescripcionUbigeo(ubigeo);
            
            DTOComunicacion comunicacionTemp [] = null;
            comunicacionTemp = dtoCliente.getComunicaciones();
            
            DTOComunicacion comunicacion = null;
            RecordSet rsComunicacion=null;
            String tipoComunicacion;
            for(int i= 0; i < comunicacionTemp.length; i++){
                rsComunicacion = this.obtenerTipoComunicacion(comunicacionTemp[i].getTipoComunicacion());
                if (rsComunicacion.esVacio()){
                    UtilidadesLog.error("DatosClienteHelper.obtenerDatosCliente: Error al obtener el tipo de comunicacion");
                    throw new MareException(new Exception(),UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS));
                }
                tipoComunicacion = (rsComunicacion.getValueAt(0,"CODIGO").toString());
                if (tipoComunicacion.equals("TF")) {
                    comunicacion=comunicacionTemp[i];
                }
            }
            
            if (comunicacion!=null) {
                dtoClienteSolicitud.setTelefono(comunicacion.getTextoComunicacion());
            }
            
            DTOUnidAdimClienteHelper dtoUnidAdimCliente;
            dtoUnidAdimCliente = (DTOUnidAdimClienteHelper)this.obtenerCodigosUnidadAdministrativa(dtoSolCliente.getOidTerritorio());
            
            dtoClienteSolicitud.setCodRegion(dtoUnidAdimCliente.getCodigoRegion());
            dtoClienteSolicitud.setCodZona(dtoUnidAdimCliente.getCodigoZona());
            dtoClienteSolicitud.setCodSeccion(dtoUnidAdimCliente.getCodigoSeccion());
            dtoClienteSolicitud.setCodTerritorio(dtoUnidAdimCliente.getCodigoTerritorio());
            
            UtilidadesLog.info("DatosClienteHelper.obtenerDatosCliente(Long oidSolicitud, String usuario): Salida");
            return dtoClienteSolicitud;
        }catch(Exception e){
            UtilidadesLog.error("ERROR en datosClienteHelper",e);
            if (e instanceof MareException){
                throw (MareException)e;
            }
            throw new MareException(e);
        }
    }
    
    private DTOSolicitudClienteHelper obtenerSolicitud (Long oidSolicitud) throws MareException {
        UtilidadesLog.info("OrdenDeCompraSimplificada.obtenerSolicitud(Long oidSolicitud): Entada");
        Vector parametros = new Vector();
        StringBuffer query = new StringBuffer();
        query.append(" SELECT PSC.CLIE_OID_CLIE CLIENTE, ");
        query.append(" PSC.ZTAD_OID_TERR_ADMI TERRITORIO, ");
        query.append(" PSC.VEPO_OID_VALO_ESTR_GEOP UBIGEO, ");
        query.append(" PSC.PAIS_OID_PAIS PAIS ");
        query.append(" FROM PED_SOLIC_CABEC PSC ");
        query.append(" WHERE ");
        query.append(" PSC.OID_SOLI_CABE = ? ");
        parametros.add(oidSolicitud);
        
        RecordSet rs = new RecordSet();
        BelcorpService bs = UtilidadesEJB.getBelcorpService();

        try {
            rs = bs.dbService.executePreparedQuery(query.toString(), parametros);
        } catch (Exception e) {
            String codigoError = CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS;
            UtilidadesLog.error("OrdenDeCompraSimplificada.obtenerSolicitud: Exception",e);
            throw new MareException(e,
                UtilidadesError.armarCodigoError(codigoError));
        }
        
        DTOSolicitudClienteHelper dtoSolCliente = new DTOSolicitudClienteHelper();
        if (rs.esVacio()) {
           UtilidadesLog.error("DatosClienteHelper.obtenerDatosCliente: Error al obtener la solicitud");
           throw new MareException(new Exception(),UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS));
        } else {
           dtoSolCliente.setOidPais(this.bigDecimalToLong(rs.getValueAt(0,"PAIS")));
           dtoSolCliente.setOidCliente(this.bigDecimalToLong(rs.getValueAt(0,"CLIENTE")));
           dtoSolCliente.setOidUbigeo(this.bigDecimalToLong(rs.getValueAt(0,"UBIGEO")));
           dtoSolCliente.setOidTerritorio(this.bigDecimalToLong(rs.getValueAt(0,"TERRITORIO")));
        }
        
        UtilidadesLog.info("OrdenDeCompraSimplificada.obtenerSolicitud(Long oidSolicitud): Salida");
        return dtoSolCliente;
    }
    
    private RecordSet obtenerTipoVia (Long oidTipoVia) throws MareException 
    {
        UtilidadesLog.info("OrdenDeCompraSimplificada.obtenerTipoVia(Long oidTipoVia): Entada");
        Vector parametros = new Vector();
        StringBuffer query = new StringBuffer();
        query.append(" SELECT via.OID_TIPO_VIA OIDVIA, ");
        query.append(" via.COD_TIPO_VIA CODIGOVIA, ");
        query.append(" via.DES_ABRV_TIPO_VIA ABREVIATURA ");
        query.append(" FROM SEG_TIPO_VIA via ");
        query.append(" WHERE via.OID_TIPO_VIA = ? ");
        parametros.add(oidTipoVia);
        RecordSet rs = new RecordSet();
        BelcorpService bs = UtilidadesEJB.getBelcorpService();
        try {
            rs = bs.dbService.executePreparedQuery(query.toString(), parametros);
        } catch (Exception e) {
            String codigoError = CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS;
            UtilidadesLog.error("OrdenDeCompraSimplificada.obtenerTipoVia: Exception",e);
            throw new MareException(e,
                UtilidadesError.armarCodigoError(codigoError));
        }
        UtilidadesLog.info("OrdenDeCompraSimplificada.obtenerTipoVia(Long oidTipoVia): Salida");
        return rs;
    }
    
    private RecordSet obtenerTipoComunicacion (Long oidTipoComunicacion) throws MareException 
    {
        UtilidadesLog.info("OrdenDeCompraSimplificada.obtenerTipoComunicacion(Long oidTipoComunicacion): Entada");
        Vector parametros = new Vector();
        StringBuffer query = new StringBuffer();
        query.append(" SELECT com.OID_TIPO_COMU OIDCOMUNICACION, ");
        query.append(" com.COD_TIPO_COMU CODIGO ");
        query.append(" FROM MAE_TIPO_COMUN com ");
        query.append(" WHERE com.OID_TIPO_COMU = ? ");
        parametros.add(oidTipoComunicacion);
        RecordSet rs = new RecordSet();
        BelcorpService bs = UtilidadesEJB.getBelcorpService();
        try {
            rs = bs.dbService.executePreparedQuery(query.toString(), parametros);
        } catch (Exception e) {
            String codigoError = CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS;
            UtilidadesLog.error("OrdenDeCompraSimplificada.obtenerTipoComunicacion: Exception",e);
            throw new MareException(e,
                UtilidadesError.armarCodigoError(codigoError));
        }
        UtilidadesLog.info("OrdenDeCompraSimplificada.obtenerTipoComunicacion(Long oidTipoComunicacion): Salida");
        return rs;
    }
   
   private Long bigDecimalToLong(Object numero) {    
    if (numero != null) {
      return new Long(((BigDecimal) numero).longValue());
    } else {
      return null;
    }
  }
  
   private String objectToString(Object ob) {    
    if (ob != null) {
      return ob.toString();
    } else {
      return new String(" ");
    }
  }
  
   private Boolean bigDecimalToBoolean(Object indicador) {    
        if (indicador != null) {
            if (((BigDecimal) indicador).intValue() == 1)  { 
                return Boolean.TRUE;
            } else {
                return Boolean.FALSE;           
            }           
        } else {
            return Boolean.FALSE;
        }
    }
    
   private RecordSet executeQuery(String query) throws MareException {
    UtilidadesLog.info("DatosClienteHelper.executeQuery(String query): Entrada");
    RecordSet rs = null;
    
    try {
      BelcorpService belcorpService = BelcorpService.getInstance();
      rs = belcorpService.dbService.executeStaticQuery( query );
    } catch ( Exception ex ) {
      throw new MareException(ex,UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS ));
    }       
    UtilidadesLog.info("DatosClienteHelper.executeQuery(String query): Salida");  
    return rs;
  }

    private DTOUnidAdimClienteHelper obtenerCodigosUnidadAdministrativa(Long oidTerritorioAdministrativo) throws MareException {
        UtilidadesLog.info("DatosClienteHelper.obtenerCodigosUnidadAdministrativa(Long oidTerritorioAdministrativo): Entada");
        DTOUnidAdimClienteHelper dtoUnidAminCliente = null;
        StringBuffer query = new StringBuffer();
        query.append(" SELECT REG.COD_REGI COD_REGION, ");
        query.append("        ZON.COD_ZONA COD_ZONA, ");
        query.append("        SEC.COD_SECC COD_SECCION, "); 
        query.append("        TER.COD_TERR COD_TERRITORIO ");
        query.append(" FROM ZON_TERRI_ADMIN TAD, ");
        query.append("      ZON_TERRI TER, ");
        query.append("      ZON_ZONA ZON, ");
        query.append("      ZON_REGIO REG, "); 
        query.append("      ZON_SECCI SEC ");
        query.append(" WHERE TAD.OID_TERR_ADMI = " + oidTerritorioAdministrativo);
        query.append("   AND TAD.TERR_OID_TERR = TER.OID_TERR ");
        query.append("   AND TAD.ZSCC_OID_SECC = SEC.OID_SECC ");
        query.append("   AND SEC.ZZON_OID_ZONA = ZON.OID_ZONA ");
        query.append("   AND ZON.ZORG_OID_REGI = REG.OID_REGI ");
        
        RecordSet rs;
        
        rs = this.executeQuery(query.toString());                

        DTOSolicitudClienteHelper dtoSolCliente = new DTOSolicitudClienteHelper();
        if (rs.esVacio()) {
           UtilidadesLog.error("DatosClienteHelper.obtenerCodigosUnidadAdministrativa: Error al obtener la Unidad Administrativa");
           throw new MareException(new Exception(),UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS));
        } else {
           dtoUnidAminCliente = new DTOUnidAdimClienteHelper();  
           dtoUnidAminCliente.setCodigoRegion(this.objectToString(rs.getValueAt(0, "COD_REGION")));
           dtoUnidAminCliente.setCodigoZona(this.objectToString(rs.getValueAt(0, "COD_ZONA")));
           dtoUnidAminCliente.setCodigoSeccion(this.objectToString(rs.getValueAt(0, "COD_SECCION")));
           dtoUnidAminCliente.setCodigoTerritorio(this.objectToString(rs.getValueAt(0, "COD_TERRITORIO")));           
        }
        
        UtilidadesLog.info("DatosClienteHelper.obtenerCodigosUnidadAdministrativa(Long oidTerritorioAdministrativo): Salida");
        return dtoUnidAminCliente;
    }

 
}