package es.indra.sicc.logicanegocio.ape;

import es.indra.sicc.dtos.ape.DTODatosTextoVariable;
import es.indra.mare.common.mii.MareMiiServiceNotFoundException;
import es.indra.sicc.logicanegocio.seg.ConstantesSEG;
import es.indra.sicc.util.CodigosError;
import es.indra.sicc.util.UtilidadesError;
import es.indra.sicc.util.UtilidadesLog;
import es.indra.sicc.util.DTOSalida;
import es.indra.mare.common.exception.MareException;
import es.indra.mare.common.mii.services.jdbcservice.RecordSet;
import es.indra.sicc.util.BelcorpService;
import es.indra.sicc.util.UtilidadesPaginacion;

public class DAOConfiguracionTextoVariable {
    public DAOConfiguracionTextoVariable()   {   }
    
    /** 
   * Autor: Cristian Valenzuela
   * Fecha: 26/1/2007
   */
    public DTOSalida consultarConfiguarcionTextoVariable (DTODatosTextoVariable dto) 
        throws MareException {             
        UtilidadesLog.info("DAOConfiguracionTextoVariable.consultarConfiguarcionTextoVariable"+
        "(DTODatosTextoVariable dto): Entrada");
        
        DTOSalida dtoSalida = new DTOSalida();
        BelcorpService bs;
        RecordSet rs;
        String codigoError;
        StringBuffer query = new StringBuffer();
        
        query.append(" SELECT TEXTO.OID_CONF_TEXT_VARI AS OID, ");
        query.append(" (SELECT VAL_I18N ");
        query.append(" FROM V_GEN_I18N_SICC V1 ");
        query.append(" WHERE V1.VAL_OID = TEXTO.TICL_OID_TIPO_CLIE ");
        query.append(" AND V1.ATTR_ENTI = 'MAE_TIPO_CLIEN' ");
        query.append(" AND V1.IDIO_OID_IDIO = " + dto.getOidIdioma());
        query.append(" AND V1.ATTR_NUM_ATRI = 1 ");
        query.append(" ) AS TIPOCLIENTE, ");
        query.append(" (SELECT VAL_I18N ");
        query.append(" FROM V_GEN_I18N_SICC V2 ");
        query.append(" WHERE V2.VAL_OID = TEXTO.SBTI_OID_SUBT_CLIE ");
        query.append(" AND V2.ATTR_ENTI = 'MAE_SUBTI_CLIEN' ");
        query.append(" AND V2.IDIO_OID_IDIO = " + dto.getOidIdioma());
        query.append(" AND V2.ATTR_NUM_ATRI = 1 ");
        query.append(" ) AS SUBTIPOCLIENTE, ");
        query.append(" (SELECT VAL_I18N ");
        query.append(" FROM V_GEN_I18N_SICC V3 ");
        query.append(" WHERE V3.VAL_OID = TEXTO.TCCL_OID_TIPO_CLAS ");
        query.append(" AND V3.ATTR_ENTI = 'MAE_TIPO_CLASI_CLIEN' ");
        query.append(" AND V3.IDIO_OID_IDIO = " + dto.getOidIdioma());
        query.append(" AND V3.ATTR_NUM_ATRI = 1 ");
        query.append(" ) AS TIPOCLASIFICACION, ");
        query.append(" (SELECT VAL_I18N ");
        query.append(" FROM V_GEN_I18N_SICC V4 ");
        query.append(" WHERE V4.VAL_OID = TEXTO.CLAS_OID_CLAS ");
        query.append(" AND V4.ATTR_ENTI = 'MAE_CLASI' ");
        query.append(" AND V4.IDIO_OID_IDIO = " + dto.getOidIdioma());
        query.append(" AND V4.ATTR_NUM_ATRI = 1 ");
        query.append(" ) AS CLASIFICACION, ");
        query.append(" TEXTO.VAL_TEXT_VARI AS TEXTOVARIABLE, ");
        query.append(" TIPO.OID_TIPO_CLIE AS OIDTIPOCLIENTE, ");
        query.append(" SUBTIPO.OID_SUBT_CLIE AS OIDSUBTIPOCLIENTE, ");
        query.append(" TIPOCLASIFICACION.OID_TIPO_CLAS AS OIDTIPOCLASIFICACION, ");
        query.append(" CLASIFICACION.OID_CLAS AS OIDCLASIFICACION ");
        query.append(" FROM APE_CONFI_TEXTO_VARIA TEXTO, ");
        query.append(" MAE_TIPO_CLIEN TIPO, ");
        query.append(" MAE_SUBTI_CLIEN SUBTIPO, ");
        query.append(" MAE_TIPO_CLASI_CLIEN TIPOCLASIFICACION, ");
        query.append(" MAE_CLASI CLASIFICACION ");
        query.append(" WHERE TIPO.OID_TIPO_CLIE = TEXTO.TICL_OID_TIPO_CLIE ");
        query.append(" AND SUBTIPO.OID_SUBT_CLIE(+) = TEXTO.SBTI_OID_SUBT_CLIE ");
        query.append(" AND TIPOCLASIFICACION.OID_TIPO_CLAS(+) = TEXTO.TCCL_OID_TIPO_CLAS ");
        query.append(" AND CLASIFICACION.OID_CLAS(+) = TEXTO.CLAS_OID_CLAS ");
        
        if(dto.getOidTipoCliente()!=null) {
            query.append(" AND TEXTO.TICL_OID_TIPO_CLIE = " + dto.getOidTipoCliente());    
        }
        
        if(dto.getOidSubtipoCliente()!=null){
            query.append(" AND TEXTO.SBTI_OID_SUBT_CLIE = " + dto.getOidSubtipoCliente());    
        }
        
        if(dto.getOidTipoClasificacion()!=null) {
            query.append(" AND TEXTO.TCCL_OID_TIPO_CLAS = " + dto.getOidTipoClasificacion());    
        }
        
        if(dto.getOidClasificacion()!=null) {
            query.append(" AND TEXTO.CLAS_OID_CLAS = " + dto.getOidClasificacion());    
        }     
        
        String queryPaginada = UtilidadesPaginacion.armarQueryPaginacion(query.toString(), dto);
        
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

        if ((rs == null) || rs.esVacio()) {
            throw new MareException(null, null, 
            UtilidadesError.armarCodigoError(ConstantesSEG.MODULO_APE +
            ErroresDeNegocio.APE_0027));
        }  
        
        UtilidadesLog.info("DAOConfiguracionTextoVariable.consultarConfiguarcionTextoVariable"+
        "(DTODatosTextoVariable dto): Salida");
        
        dtoSalida.setResultado(rs);
        return dtoSalida;    
    }
}