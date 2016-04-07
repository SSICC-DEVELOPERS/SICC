package es.indra.sicc.logicanegocio.inc;

import es.indra.sicc.util.DTOSalida;
import es.indra.sicc.util.DTOBelcorp;
import es.indra.mare.common.exception.MareException;
import es.indra.mare.common.mii.services.jdbcservice.RecordSet;
import es.indra.sicc.util.UtilidadesError;
import es.indra.sicc.util.UtilidadesLog;
import es.indra.sicc.dtos.inc.DTOParticipantesDetalle;
import es.indra.sicc.util.BelcorpService;
import es.indra.mare.common.mii.MareMiiServiceNotFoundException;
import es.indra.sicc.util.CodigosError;
import es.indra.sicc.util.UtilidadesPaginacion;

public class DAOParticipantesDetalle {
    public DAOParticipantesDetalle()  { }
    
    /**
      * Sistema:     Belcorp
      * Modulo:      INC
      * Fecha:       18/07/2006
      * @version     1.0
      * @autor       Cristian Valenzuela
      */
    public DTOSalida obtenerGruposCliente(DTOBelcorp DTOE)
            throws MareException {
        UtilidadesLog.info("DAOParticipantesDetalle.obtenerGruposCliente(DTOBelcorp DTOE): Entrada");
        
        BelcorpService bs;
        RecordSet rs;
        String codigoError;
        StringBuffer query = new StringBuffer();
        DTOSalida dtoSalida = new DTOSalida();
        
        
        // SPLATAS - 09/01/2007 - Bloqueante: V-INC-27
        /*
        query.append(" SELECT IPCC.OID_PART_CONC_CABE, V.VAL_I18N,  ");
        query.append(" IPCC.DIRI_OID_DIRI ");
        query.append(" FROM INC_PARTI_CONCU_CABEC IPCC, V_GEN_I18N_SICC V  ");
        query.append(" WHERE IPCC.PAIS_OID_PAIS = " + DTOE.getOidPais());
        query.append(" AND V.VAL_OID = IPCC.OID_PART_CONC_CABE ");
        query.append(" AND V.IDIO_OID_IDIO = " + DTOE.getOidIdioma());
        query.append(" AND V.ATTR_NUM_ATRI = 1 ");
        query.append(" AND V.ATTR_ENTI LIKE 'INC_PARTI_CONCU_CABEC' ");
        query.append(" ORDER BY V.VAL_I18N ");
        */
        query.append(" SELECT IPCC.OID_PART_CONC_CABE, IPCC.DES_DESC VAL_I18N,  ");
        query.append(" IPCC.DIRI_OID_DIRI ");
        query.append(" FROM INC_PARTI_CONCU_CABEC IPCC ");
        query.append(" WHERE IPCC.PAIS_OID_PAIS = " + DTOE.getOidPais());
        query.append(" ORDER BY VAL_I18N ");
        

        try {
            bs = BelcorpService.getInstance();
            rs = bs.dbService.executeStaticQuery(query.toString());
        }
        catch (MareMiiServiceNotFoundException e) {
            UtilidadesLog.error("ERROR ", e);
            codigoError = CodigosError.ERROR_AL_PEDIR_UN_SERVICIO_MARE;
            throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));
        }
        catch (Exception e) {
            UtilidadesLog.error("ERROR ", e);
            codigoError = CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS;
            throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));
        }        
        
        dtoSalida.setResultado(rs);         
        UtilidadesLog.info("DAOParticipantesDetalle.obtenerGruposCliente(DTOBelcorp DTOE): Salida");    
        return dtoSalida;
    }
    
    /**
      * Sistema:     Belcorp
      * Modulo:      INC
      * Fecha:       21/07/2006
      * @version     1.0
      * @autor       Cristian Valenzuela
      */
    public DTOSalida buscarDetalle(DTOParticipantesDetalle DTOE)
            throws MareException {
        UtilidadesLog.info("DAOParticipantesDetalle.buscarDetalle(DTOParticipantesDetalle DTOE): Entrada");
        
        BelcorpService bs;
        RecordSet rs;
        String codigoError;
        StringBuffer query = new StringBuffer();
        DTOSalida dtoSalida = new DTOSalida();
        
        query.append(" SELECT IPCD.OID_PART_CONC_DETA AS OID, ");
		query.append(" IPCD.OID_PART_CONC_DETA AS OIDDETALLE, ");
		query.append(" (SELECT V1.VAL_I18N ");
		query.append(" FROM V_GEN_I18N_SICC V1 ");
		query.append(" WHERE V1.VAL_OID = IPCC.OID_PART_CONC_CABE ");
		query.append(" AND V1.ATTR_ENTI LIKE 'INC_PARTI_CONCU_CABEC' ");
        query.append(" AND V1.IDIO_OID_IDIO = " + DTOE.getOidIdioma());
        query.append(" AND V1.ATTR_NUM_ATRI = 1 ) AS GRUPOCLIENTES, ");
		query.append(" IPCC.DIRI_OID_DIRI AS IDCLASIFICACION, ");
		query.append(" (SELECT V2.VAL_I18N ");
		query.append(" FROM V_GEN_I18N_SICC V2 ");
		query.append(" WHERE V2.VAL_OID = IPCD.TICL_OID_TIPO_CLIE ");
		query.append(" AND V2.ATTR_ENTI LIKE 'MAE_TIPO_CLIEN' ");
		query.append(" AND V2.IDIO_OID_IDIO = " + DTOE.getOidIdioma());
		query.append(" AND V2.ATTR_NUM_ATRI = 1 ) AS TIPOCLIENTE, ");
		query.append(" (SELECT V3.VAL_I18N ");
		query.append(" FROM V_GEN_I18N_SICC V3 ");
		query.append(" WHERE V3.VAL_OID = IPCD.SBTI_OID_SUBT_CLIE ");
		query.append(" AND V3.ATTR_ENTI LIKE 'MAE_SUBTI_CLIEN' ");
		query.append(" AND V3.IDIO_OID_IDIO = " + DTOE.getOidIdioma());
		query.append(" AND V3.ATTR_NUM_ATRI = 1 ) AS SUBTIPOCLIENTE, ");
		query.append(" (SELECT V4.VAL_I18N ");
		query.append(" FROM V_GEN_I18N_SICC V4 ");
		query.append(" WHERE V4.VAL_OID = IPCD.TCCL_OID_TIPO_CLAS ");
		query.append(" AND V4.ATTR_ENTI LIKE 'MAE_TIPO_CLASI_CLIEN' ");
		query.append(" AND V4.IDIO_OID_IDIO = " + DTOE.getOidIdioma());
		query.append(" AND V4.ATTR_NUM_ATRI = 1 ) AS TIPOCLASIFICACION, ");
		query.append(" (SELECT V5.VAL_I18N ");
		query.append(" FROM V_GEN_I18N_SICC V5 ");
		query.append(" WHERE V5.VAL_OID = IPCD.CLAS_OID_CLAS ");
		query.append(" AND V5.ATTR_ENTI LIKE 'MAE_CLASI' ");
		query.append(" AND V5.IDIO_OID_IDIO = " + DTOE.getOidIdioma());
     	query.append(" AND V5.ATTR_NUM_ATRI = 1 ) AS CLASIFICACION, ");
		query.append(" IPCD.TICL_OID_TIPO_CLIE AS OIDTIPOCLIENTE, ");
		query.append(" IPCD.SBTI_OID_SUBT_CLIE AS OIDSUBTIPOCLIENTE, ");
		query.append(" IPCD.TCCL_OID_TIPO_CLAS AS OIDTIPOCLASIFICACION, ");
		query.append(" IPCD.CLAS_OID_CLAS AS OIDCLASIFICACION, ");
        query.append(" IPCC.OID_PART_CONC_CABE AS OIDCABECERA ");
    
    // gpineda - DBLG500000303
    query.append(", IPCD.DES_DESC AS DESCRIPCION ");
    
		query.append(" FROM INC_PARTI_CONCU_CABEC IPCC, ");
		query.append(" INC_PARTI_CONCU_DETAL IPCD, ");
		query.append(" MAE_TIPO_CLIEN MTC, ");
		query.append(" MAE_SUBTI_CLIEN MSC, ");
		query.append(" MAE_TIPO_CLASI_CLIEN MTCC, ");
		query.append(" MAE_CLASI MC ");
        query.append(" WHERE IPCC.PAIS_OID_PAIS = " + DTOE.getOidPais());
		
        if(DTOE.getOidCabecera()!=null) {
            query.append(" AND IPCD.PACI_OID_PART_CONC_CABE = " + DTOE.getOidCabecera());    
        }
        
        if(DTOE.getTipoCliente()!=null) {
            query.append(" AND IPCD.TICL_OID_TIPO_CLIE = " + DTOE.getTipoCliente());    
        }
        
        if(DTOE.getSubtipoCliente()!=null) {
            query.append(" AND IPCD.SBTI_OID_SUBT_CLIE = " + DTOE.getSubtipoCliente());    
        }
        
        if(DTOE.getTipoClasificacion()!=null) {
            query.append(" AND IPCD.TCCL_OID_TIPO_CLAS = " + DTOE.getTipoClasificacion());    
        }
        
        if(DTOE.getClasificacion()!=null) {
            query.append(" AND IPCD.CLAS_OID_CLAS = " + DTOE.getClasificacion());    
        }
        
        //DBLG500000303
        if(DTOE.getDescripcion() != null){
            query.append(" AND IPCD.DES_DESC LIKE '" + DTOE.getDescripcion() +"' ");    
        }
        
        query.append(" AND IPCD.PACI_OID_PART_CONC_CABE = IPCC.OID_PART_CONC_CABE ");
		query.append(" AND MTC.OID_TIPO_CLIE = IPCD.TICL_OID_TIPO_CLIE ");
		query.append(" AND MSC.OID_SUBT_CLIE(+) = IPCD.SBTI_OID_SUBT_CLIE ");
		query.append(" AND MTCC.OID_TIPO_CLAS(+) = IPCD.TCCL_OID_TIPO_CLAS ");
		query.append(" AND MC.OID_CLAS(+) = IPCD.CLAS_OID_CLAS ");
        
        String queryPaginada = 
        UtilidadesPaginacion.armarQueryPaginacion(query.toString(), DTOE);

        try {
            bs = BelcorpService.getInstance();
            rs = bs.dbService.executeStaticQuery(queryPaginada);
        }
        catch (MareMiiServiceNotFoundException e) {
            UtilidadesLog.error("ERROR ", e);
            codigoError = CodigosError.ERROR_AL_PEDIR_UN_SERVICIO_MARE;
            throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));
        }
        catch (Exception e) {
            UtilidadesLog.error("ERROR ", e);
            codigoError = CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS;
            throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));
        }        
        
        if(rs.esVacio()) {        
            codigoError = CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE;
            throw new MareException(new Exception(), UtilidadesError.armarCodigoError(codigoError));
        }
        
        dtoSalida.setResultado(rs);         
        UtilidadesLog.info("DAOParticipantesDetalle.buscarDetalle(DTOParticipantesDetalle DTOE): Salida");    
        return dtoSalida;      
    }
}