package es.indra.sicc.cmn.negocio.integracion;

import es.indra.mare.common.exception.MareException;
import es.indra.mare.common.mii.services.jdbcservice.RecordSet;
import es.indra.sicc.util.BelcorpService;
import es.indra.sicc.util.CodigosError;
import es.indra.sicc.util.UtilidadesError;
import es.indra.sicc.util.UtilidadesLog;

import java.util.ArrayList;


/**
 * Clase DAO que realiza consultas necesarias en la integracion de SICC - SSICC
 * 
 * @author <a href="mailto:sapaza@belcorp.biz">Sergio Apaza</a>
 */
public class DAOIntegracionSICC {

    public DAOIntegracionSICC() {
    }

    public void obtenerOidsBasicos(DTOEntradaSICC dto) throws MareException {
        UtilidadesLog.info("DAOIntegracionSICC.obtenerOidsBasicos(DTOEntradaSICC dto): Entrada ");
        
        if(dto.getCodigoPais()==null || dto.getCodigoPais().length()==0)
            throw new MareException("ERROR, NO SE ENCONTRO CODIGO PAIS");

        if(dto.getCodigoIsoIdioma()==null || dto.getCodigoIsoIdioma().length()==0)
            throw new MareException("ERROR, NO SE ENCONTRO CODIGO ISO IDIOMA");

        if(dto.getCodigoUsuario()==null || dto.getCodigoUsuario().length()==0)
            throw new MareException("ERROR, NO SE ENCONTRO CODIGO DE USUARIO");
        
        //obtenemos el oidPais
        StringBuffer query = new StringBuffer();
        query.append(" SELECT OID_PAIS ");
        query.append("   FROM SEG_PAIS ");
        query.append("  WHERE COD_PAIS = '" + dto.getCodigoPais() + "'"); 
        
        //ejecución de la consulta
        RecordSet rs = new RecordSet();
        try {
            rs = BelcorpService.getInstance().dbService.executeStaticQuery(query.toString());
        } catch (MareException me) {
            throw me;
        } catch (Exception e) {
            throw new MareException(e,UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS) );
        }
        dto.setOidPais(new Long(rs.getValueAt(0,0).toString()));

        //obtenemos el oidIdioma
        query = new StringBuffer();
        query.append(" SELECT OID_IDIO ");
        query.append("   FROM SEG_IDIOM ");
        query.append("  WHERE COD_ISO_IDIO = '" + dto.getCodigoIsoIdioma() + "'"); 
        
        //ejecución de la consulta
        rs = new RecordSet();
        try {
            rs = BelcorpService.getInstance().dbService.executeStaticQuery(query.toString());
        } catch (MareException me) {
            throw me;
        } catch (Exception e) {
            throw new MareException(e,UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS) );
        }
        dto.setOidIdioma(new Long(rs.getValueAt(0,0).toString()));
        
        //obtenemos el oidPeriodo
        if(dto.getCodigoPeriodo()!=null && dto.getCodigoPeriodo().length()>0) {
            query = new StringBuffer();
            query.append(" SELECT per.OID_PERI ");
            query.append("   FROM CRA_PERIO per, SEG_PERIO_CORPO cor ");
            query.append("  WHERE per.PERI_OID_PERI = cor.OID_PERI ");
            query.append("    AND cor.COD_PERI = '" + dto.getCodigoPeriodo() + "'");
            
            //ejecución de la consulta
            rs = new RecordSet();
            try {
                rs = BelcorpService.getInstance().dbService.executeStaticQuery(query.toString());
            } catch (MareException me) {
                throw me;
            } catch (Exception e) {
                throw new MareException(e,UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS) );
            }
            dto.setOidPeriodo(new Long(rs.getValueAt(0,0).toString()));
        }
        
        UtilidadesLog.info("DAOIntegracionSICC.obtenerOidsBasicos(DTOEntradaSICC dto): Salida ");
    }  
    
    public Long obtenerOidMarca(String codigoMarca) throws MareException {
        UtilidadesLog.info("DAOIntegracionSICC.obtenerOidMarca(String codigoMarca): Entrada ");
        Long oidMarca = null;
        
        if(codigoMarca==null || codigoMarca.length()==0)
            throw new MareException("ERROR, NO SE ENCONTRO CODIGO MARCA");

        //obtenemos el oidMarca
        StringBuffer query = new StringBuffer();
        query.append(" SELECT OID_MARC ");
        query.append("   FROM SEG_MARCA ");
        query.append("  WHERE COD_MARC = '" + codigoMarca + "'"); 
        
        //ejecución de la consulta
        RecordSet rs = new RecordSet();
        try {
            rs = BelcorpService.getInstance().dbService.executeStaticQuery(query.toString());
            oidMarca = new Long(rs.getValueAt(0,0).toString());
        } catch (MareException me) {
            throw me;
        } catch (Exception e) {
            throw new MareException(e,UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS) );
        }
        
        UtilidadesLog.info("DAOIntegracionSICC.obtenerOidMarca(String codigoMarca): Salida ");
        return oidMarca;
    }  
    
    public Long obtenerOidCanal(String codigoCanal) throws MareException {
        UtilidadesLog.info("DAOIntegracionSICC.obtenerOidCanal(String codigoCanal): Entrada ");
        Long oidCanal = null;
        
        if(codigoCanal==null || codigoCanal.length()==0)
            throw new MareException("ERROR, NO SE ENCONTRO CODIGO CANAL");

        //obtenemos el oidMarca
        StringBuffer query = new StringBuffer();
        query.append(" SELECT OID_CANA ");
        query.append("   FROM SEG_CANAL ");
        query.append("  WHERE COD_CANA = '" + codigoCanal + "'"); 
        
        //ejecución de la consulta
        RecordSet rs = new RecordSet();
        try {
            rs = BelcorpService.getInstance().dbService.executeStaticQuery(query.toString());
            oidCanal = new Long(rs.getValueAt(0,0).toString());
        } catch (MareException me) {
            throw me;
        } catch (Exception e) {
            throw new MareException(e,UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS) );
        }
        
        UtilidadesLog.info("DAOIntegracionSICC.obtenerOidCanal(String codigoCanal): Salida ");
        return oidCanal;
    }

    public Long obtenerOidTipoCierre(String codigoTipoCierre) throws MareException {
        UtilidadesLog.info("DAOIntegracionSICC.obtenerOidTipoCierre(String codigoTipoCierre): Entrada ");
        Long oidTipoCierre = null;
        
        if(codigoTipoCierre==null || codigoTipoCierre.length()==0)
            throw new MareException("ERROR, NO SE ENCONTRO CODIGO TIPO CIERRE");

        //obtenemos el oidMarca
        StringBuffer query = new StringBuffer();
        query.append(" SELECT OID_TIPO_CIER ");
        query.append("   FROM FAC_TIPOS_CIERR ");
        query.append("  WHERE COD_TIPO_CIER = '" + codigoTipoCierre + "'"); 
        
        //ejecución de la consulta
        RecordSet rs = new RecordSet();
        try {
            rs = BelcorpService.getInstance().dbService.executeStaticQuery(query.toString());
            oidTipoCierre = new Long(rs.getValueAt(0,0).toString());
        } catch (MareException me) {
            throw me;
        } catch (Exception e) {
            throw new MareException(e,UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS) );
        }
        
        UtilidadesLog.info("DAOIntegracionSICC.obtenerOidTipoCierre(String codigoTipoCierre): Salida ");
        return oidTipoCierre;
    }  

    public ArrayList obtenerOidsTiposSolicitudesOC() throws MareException {
        UtilidadesLog.info("DAOIntegracionSICC.obtenerOidsTiposSolicitudesOC(): Entrada ");
        ArrayList lista = new ArrayList();
        
        //obtenemos los oids Tipo Solicitud O/C
        StringBuffer query = new StringBuffer();
        query.append(" SELECT tsp.OID_TIPO_SOLI_PAIS ");
        query.append("   FROM PED_TIPO_SOLIC_PAIS tsp, PED_TIPO_SOLIC ts ");
        query.append("  WHERE tsp.TSOL_OID_TIPO_SOLI = ts.OID_TIPO_SOLI "); 
        query.append("    AND ts.COD_TIPO_SOLI = 'SOC' "); 
        
        //ejecución de la consulta
        RecordSet rs = new RecordSet();
        try {
            rs = BelcorpService.getInstance().dbService.executeStaticQuery(query.toString());
        } catch (MareException me) {
            throw me;
        } catch (Exception e) {
            throw new MareException(e,UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS) );
        }
        
        for(int i=0; i<rs.getRowCount(); i++) {
            lista.add(new Long(rs.getValueAt(i,0).toString()));
        }
                
        UtilidadesLog.info("DAOIntegracionSICC.obtenerOidsTiposSolicitudesOC(): Salida ");
        return lista;
    }  
    
}
