package es.indra.sicc.logicanegocio.bel;

import java.util.Vector;

import es.indra.sicc.util.UtilidadesLog;

import es.indra.sicc.dtos.bel.DTOBusquedaParametrosBEL;
import es.indra.sicc.cmn.negocio.auditoria.DTOSiccPaginacion;

import es.indra.sicc.util.DTOSalida;
import es.indra.sicc.util.BelcorpService;
import es.indra.sicc.util.UtilidadesEJB;
import es.indra.sicc.util.CodigosError;
import es.indra.sicc.util.UtilidadesError;
import es.indra.sicc.util.UtilidadesPaginacion;

import es.indra.mare.common.mii.services.jdbcservice.RecordSet;

import es.indra.mare.common.exception.MareException;

public class DAOMantenimientoParametrosBel {
    public DTOSalida obtenerParametrosBEL(DTOBusquedaParametrosBEL dto) throws MareException {
        UtilidadesLog.info("DAOMantenimientoParamentrosBel.obtenerParametrosBEL(DTOBusquedaParametrosBEL dto): Entrada");

        DTOSalida dtoSalida = new DTOSalida(new RecordSet());
        RecordSet rs = null;
        StringBuffer query = new StringBuffer();
        Vector parameters = new Vector();
        BelcorpService bs = UtilidadesEJB.getBelcorpService();
        String errorCode = null;
        Long language = dto.getOidIdioma();
        Long country = dto.getOidPais();

        query.append("SELECT parametro.oid_para OID, canal.COD_CANA, acceso.COD_ACCE, subacceso.COD_SBAC, " +
            "parametro.VAL_DIRE, parametro.VAL_TFNO, parametro.VAL_MONT_MAXI_DIFE, " +
            "parametro.VAL_LIMI_EFEC_CAJA, parametro.NUM_CAJA, parametro.VAL_NOMB_LOCA, " +
            "parametro.VAL_TIEMP_REPO, parametro.VAL_FACT_LOCA, parametro.VAL_USUA, " +
            "parametro.NUM_MAXI_PROD, parametro.VAL_ALER_STOC, ");

    	// Movimiento Stock en Tránsito (descripción i18n TipoMovimientoAlmacen)
        query.append("(SELECT idioma.VAL_I18N FROM V_GEN_I18N_SICC idioma " +
            "WHERE idioma.ATTR_ENTI = 'BEL_TIPO_MOVIM_ALMAC' " +
        	"AND idioma.ATTR_NUM_ATRI = 1 " +
            "AND idioma.IDIO_OID_IDIO = ? " +
            "AND idioma.VAL_OID = parametro.TMAL_OID_STOC_TRAN) AS stockTransito, ");
        parameters.add(language);

        // Movimiento Confirmar Stock (descripción i18n TipoMovimientoAlmacen)
        query.append("(SELECT idioma.VAL_I18N FROM V_GEN_I18N_SICC idioma " +
            "WHERE idioma.ATTR_ENTI = 'BEL_TIPO_MOVIM_ALMAC' " +
        	"AND idioma.ATTR_NUM_ATRI = 1 " +
            "AND idioma.IDIO_OID_IDIO = ? " +
            "AND idioma.VAL_OID = parametro.TMAL_OID_CONF_STOC) AS confirmarStock, ");
        parameters.add(language);
        
        // Movimiento Regularización (descripción i18n TipoMovimientoAlmacen)
        query.append("(SELECT idioma.VAL_I18N FROM V_GEN_I18N_SICC idioma " +
            "WHERE idioma.ATTR_ENTI = 'BEL_TIPO_MOVIM_ALMAC' " +
            "AND idioma.ATTR_NUM_ATRI = 1 " +
            "AND idioma.IDIO_OID_IDIO = ? " +
            "AND idioma.VAL_OID = parametro.TMAL_OID_REGU) AS regularizacion, ");
        parameters.add(language);
        
        // Movimiento Regularización SAP (descripción i18n TipoMovimientoAlmacen)
        query.append("(SELECT idioma.VAL_I18N FROM V_GEN_I18N_SICC idioma " +
            "WHERE idioma.ATTR_ENTI = 'BEL_TIPO_MOVIM_ALMAC' " +
        	"AND idioma.ATTR_NUM_ATRI = 1 " +
            "AND idioma.IDIO_OID_IDIO = ? " +
            "AND idioma.VAL_OID = parametro.TMAL_OID_REGU_SAP) AS regularizacionSAP, ");
        parameters.add(language);
        
        // Movimiento Devolver Stock de Existencias (descripción i18n TipoMovimientoAlmacen)
        query.append("(SELECT idioma.VAL_I18N FROM V_GEN_I18N_SICC idioma " +
            "WHERE idioma.ATTR_ENTI = 'BEL_TIPO_MOVIM_ALMAC' " +
        	"AND idioma.ATTR_NUM_ATRI = 1 " +
            "AND idioma.IDIO_OID_IDIO = ? " +
            "AND idioma.VAL_OID = parametro.TMAL_OID_DEVO_STOC) AS devolverStock, ");
        parameters.add(language);
        
        // Movimiento Petición de Existencias (descripción i18n TipoMovimientoAlmacen)
        query.append("(SELECT idioma.VAL_I18N FROM V_GEN_I18N_SICC idioma " +
            "WHERE idioma.ATTR_ENTI = 'BEL_TIPO_MOVIM_ALMAC' " +
        	"AND idioma.ATTR_NUM_ATRI = 1 " +
            "AND idioma.IDIO_OID_IDIO = ? " +
            "AND idioma.VAL_OID = parametro.TMAL_OID_PETI_EXIS) AS peticion, ");
        parameters.add(language);
        
        // Movimiento Confirmar Stock en Tránsito (descripción i18n TipoMovimientoAlmacen)
        query.append("(SELECT idioma.VAL_I18N FROM V_GEN_I18N_SICC idioma " +
            "WHERE idioma.ATTR_ENTI = 'BEL_TIPO_MOVIM_ALMAC' " +
        	"AND idioma.ATTR_NUM_ATRI = 1 " +
            "AND idioma.IDIO_OID_IDIO = ? " +
            "AND idioma.VAL_OID = parametro.TMAL_OID_CONF_STOC_TRAN) AS confirmarStockTransito, ");
        parameters.add(language);
        
        // Movimiento Stock Devolución (descripción i18n TipoMovimientoAlmacen)
        query.append("(SELECT idioma.VAL_I18N FROM V_GEN_I18N_SICC idioma " +
            "WHERE idioma.ATTR_ENTI = 'BEL_TIPO_MOVIM_ALMAC' " +
        	"AND idioma.ATTR_NUM_ATRI = 1 " +
            "AND idioma.IDIO_OID_IDIO = ? " +
            "AND idioma.VAL_OID = parametro.TMAL_OID_STOC_DEVO) AS stockDevolucion, ");
        parameters.add(language);
        
        // Tipo de Movimiento Cobrar (descripción i18n TipoMovimientoCaja)
        query.append("(SELECT idioma.VAL_I18N FROM V_GEN_I18N_SICC idioma " +
            "WHERE idioma.ATTR_ENTI = 'BEL_TIPO_MOVIM_CAJA' " +
        	"AND idioma.ATTR_NUM_ATRI = 1 " +
            "AND idioma.IDIO_OID_IDIO = ? " +
            "AND idioma.VAL_OID = parametro.TMVC_OID_COBR) AS cobrar, oid_Clie,");
        parameters.add(language);
        
        //query.append("cliente.OID_CLIE, cuentaCorriente.OID_CUEN_CORR_BANC, ");
        query.append(" cuentaCorriente.OID_CUEN_CORR_BANC, ");

        // Tipo de Movimiento Cierre (descripción i18n TipoMovimientoCaja)
        query.append("(SELECT idioma.VAL_I18N FROM V_GEN_I18N_SICC idioma " +
            "WHERE idioma.ATTR_ENTI = 'BEL_TIPO_MOVIM_CAJA' " +
        	"AND idioma.ATTR_NUM_ATRI = 1 " +
            "AND idioma.IDIO_OID_IDIO = ? " +
            "AND idioma.VAL_OID = parametro.TMVC_OID_CIER) AS cierre, ");
        parameters.add(language);
        
        query.append("empresa.VAL_DENO, ");

        // Tipo de Transacción (descripción i18n TiposTransaccion)
        query.append("(SELECT idioma.VAL_I18N FROM V_GEN_I18N_SICC idioma " +
            "WHERE idioma.ATTR_ENTI = 'CCC_TIPO_TRANS' " +
            "AND idioma.ATTR_NUM_ATRI = 1 " +
            "AND idioma.IDIO_OID_IDIO = ? " +
            "AND idioma.VAL_OID = tipoTransaccion.OID_TIPO_TRAN) AS tipoTransaccion, ");
        parameters.add(language);
        
        query.append("canal.OID_CANA, acceso.OID_ACCE, " +
            "subacceso.OID_SBAC, parametro.PAIS_OID_PAIS,  cliente.COD_CLIE ");

        query.append("FROM BEL_PARAM_BELCE parametro, SEG_ACCES acceso, SEG_SUBAC subacceso, " +
            "MAE_CLIEN cliente, SEG_SOCIE empresa, CCC_CUENT_CORRI_BANCA cuentaCorriente, " +
            "CCC_TIPO_TRANS tipoTransaccion, SEG_CANAL canal ");

        query.append("WHERE parametro.PAIS_OID_PAIS = ? " +
            "AND parametro.SBAC_OID_SBAC = subacceso.OID_SBAC " +
            "AND subacceso.ACCE_OID_ACCE = acceso.OID_ACCE " +
            "AND acceso.CANA_OID_CANA = canal.OID_CANA " +
            "AND parametro.CLIE_OID_CLIE = cliente.OID_CLIE " +
            "AND parametro.SOCI_OID_SOCI = empresa.OID_SOCI " +
            "AND parametro.CCBA_OID_CUEN_CORR_BANC = cuentaCorriente.OID_CUEN_CORR_BANC " +
            "AND parametro.TTRA_OID_TIPO_TRAN = tipoTransaccion.OID_TIPO_TRAN ");
        parameters.add(country);

        Object canal = dto.getCanal();
        
        if (canal != null) {
            query.append("AND canal.OID_CANA = ? ");
            parameters.add(canal);

            Object acceso = dto.getAcceso();
            
            if (acceso != null) {
                query.append("AND acceso.OID_ACCE = ? ");
                parameters.add(acceso);

                Object subacceso = dto.getSubacceso();
                
                if (subacceso != null) {
                    query.append("AND subacceso.OID_SBAC = ? ");
                    parameters.add(subacceso);
                }
            }            
        }
        
		String sql = UtilidadesPaginacion.armarQueryPaginacion(query.toString(), dto);

        try {
            rs = bs.dbService.executePreparedQuery(sql, parameters);
        } catch(Exception e) {
            errorCode = CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS;

			logError("obtenerParametrosBEL. Exception: ", e);
			logSql("obtenerParametrosBEL. SQL: ", sql, parameters);

            throw new MareException(e, UtilidadesError.armarCodigoError(errorCode));
        }

        if (rs != null) {
			dtoSalida = new DTOSalida(rs);
		}

        UtilidadesLog.info("DAOMantenimientoParamentrosBel.obtenerParametrosBEL(DTOBusquedaParametrosBEL dto): Salida");

        return dtoSalida;
    }
    
    private void logError(String mensaje,Throwable e) {
		UtilidadesLog.error("*** Error método " + mensaje + ": " + e.getMessage() + " ***");
		UtilidadesLog.error(e);
	}
    
    private void logSql(String metodo, String sql, Vector parameters){
		UtilidadesLog.debug(metodo + sql);
        
		if (parameters != null && parameters.size() > 0) {
			String parametersValues = "";
			
            for (int i=0; i<parameters.size();i++){
				parametersValues += "parámetro " + (i + 1) + ": " + parameters.elementAt(i) + ", ";
			}

			UtilidadesLog.debug(metodo + parametersValues);
		}
	}
}