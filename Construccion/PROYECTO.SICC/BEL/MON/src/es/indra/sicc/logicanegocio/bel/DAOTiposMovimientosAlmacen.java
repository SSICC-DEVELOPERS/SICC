/**
 * Copyright 2004 © por Indra Sistemas,S.A.. Todos los derechos reservados.
 * Avda. de Bruselas, 35
 * Parque Empresarial Arroyo de la Vega
 * 28108 Alcobendas, Madrid
 * España
 *
 * Privado y Confidencial.
 * La información contenida en este documento es propiedad de Indra sistemas.
 * Para uso exclusivo de empleados autorizados no permitiéndose
 * la distribución de este código sin permiso expreso.
 */
 
package es.indra.sicc.logicanegocio.bel;

import es.indra.sicc.util.UtilidadesLog;
import java.util.Vector;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import es.indra.sicc.util.BelcorpService;
import es.indra.sicc.util.UtilidadesEJB;
import es.indra.sicc.util.CodigosError;
import es.indra.sicc.util.UtilidadesError;
import es.indra.sicc.util.UtilidadesPaginacion;
import es.indra.sicc.util.DTOSalida;
import es.indra.sicc.util.DTOOID;
import es.indra.sicc.util.DTOBelcorp;

import es.indra.sicc.dtos.bel.DTOEBuscarTiposMovimientosAlmacen;

import es.indra.mare.common.mii.services.jdbcservice.RecordSet;
import es.indra.mare.common.mii.services.logging.LoggingService;
import es.indra.mare.common.mii.MareMii;
import es.indra.mare.common.mii.MareTopic;
import es.indra.mare.common.exception.MareException;


public class DAOTiposMovimientosAlmacen  {
	
	public DAOTiposMovimientosAlmacen() {
	}

	public DTOSalida buscarTiposMovimientosAlmacen(DTOEBuscarTiposMovimientosAlmacen dto)
		throws MareException {
    UtilidadesLog.info("DAOTiposMovimientosAlmacen.buscarTiposMovimientosAlmacen(DTOEBuscarTiposMovimientosAlmacen dto):Entrada");
    
		// Se obtienen los datos del DTO
		String codigo = dto.getCodigo();
		String descripcion = dto.getDescripcion();
		Long pais = dto.getOidPais();
		Long idioma = dto.getOidIdioma();

		// Parametros de la consulta
		Vector parametros = new Vector();
		
		// Se crea la consulta SQL
		StringBuffer consulta = new StringBuffer();
		consulta.append("SELECT t.OID_TIPO_MOVI_ALMA OID, t.COD_TIPO_MOVI, ");

		// Subselect para obtener la descripcion del tipo de movimiento
		consulta.append("(SELECT idio.VAL_I18N FROM V_GEN_I18N_SICC idio ");
		consulta.append("WHERE idio.ATTR_ENTI = 'BEL_TIPO_MOVIM_ALMAC' ");
		consulta.append("AND idio.IDIO_OID_IDIO = ? ");
		consulta.append("AND idio.VAL_OID = t.OID_TIPO_MOVI_ALMA) AS DES_TIPO_MOVI ");
		parametros.add(idioma);

		consulta.append("FROM BEL_TIPO_MOVIM_ALMAC t ");
		consulta.append("WHERE t.PAIS_OID_PAIS = ? ");
		parametros.add(pais);

		if (codigo != null) {
			consulta.append("AND t.COD_TIPO_MOVI LIKE ? ");
			parametros.add(codigo);
		}
		if(descripcion!=null){
			consulta.append("AND (SELECT idio.VAL_I18N FROM V_GEN_I18N_SICC idio ");
			consulta.append("WHERE idio.ATTR_ENTI = 'BEL_TIPO_MOVIM_ALMAC' ");
			consulta.append("AND idio.IDIO_OID_IDIO = ? ");
			parametros.add(idioma);
			consulta.append("AND idio.VAL_OID = t.OID_TIPO_MOVI_ALMA) LIKE ? ");			
			parametros.add(descripcion);			
		}
		// La consulta debe ser paginada
		String sql = UtilidadesPaginacion.armarQueryPaginacion(consulta.toString(),dto);
		
		// Se ejecuta la consulta 
		BelcorpService bs = UtilidadesEJB.getBelcorpService();
		RecordSet resultado = null;
		String codigoError = null;
		try {
			resultado = bs.dbService.executePreparedQuery(sql,parametros);
		} catch (Exception e) {
            codigoError = CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS;
			this.logError("buscarTiposMovimientosAlmacen: Exception",e);
			this.logSql("buscarTiposMovimientosAlmacen. SQL: ",sql,parametros);
            throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));
		}

		DTOSalida dtoSalida = null;
		if (resultado != null) {
			dtoSalida = new DTOSalida(resultado);
		} else {
			dtoSalida = new DTOSalida(new RecordSet());
		}
		
		UtilidadesLog.info("DAOTiposMovimientosAlmacen.buscarTiposMovimientosAlmacen(DTOEBuscarTiposMovimientosAlmacen dto):Salida");
		return dtoSalida;
	}

	public RecordSet consultarTipoMovimientoAlmacen(DTOOID dto) throws MareException {
		UtilidadesLog.info("DAOTiposMovimientosAlmacen.consultarTipoMovimientoAlmacen(DTOOID dto):Entrada");

		Long oid = dto.getOid();
		Long idioma = dto.getOidIdioma();

		// Parametros de la consulta
		Vector parametros = new Vector();
		
		// Se crea la consulta SQL
		StringBuffer consulta = new StringBuffer();
    
    consulta.append(" SELECT TMA.OID_TIPO_MOVI_ALMA, ");
		consulta.append("        TMA.PAIS_OID_PAIS, ");
		consulta.append("        TMA.COD_TIPO_MOVI, ");
		consulta.append("        PQ_APL_AUX.Valor_Gen_I18n_Sicc(" + idioma + ",TMA.OID_TIPO_MOVI_ALMA,'BEL_TIPO_MOVIM_ALMAC') DES_TIPO_MOVI, ");
		consulta.append("        TMA.COD_MOVI_SAP, ");
		consulta.append("        TMA.COD_OPER_1, ");
		consulta.append("        TMA.COD_OPER_2, ");
		consulta.append("        TMA.IND_MOVI_ENTR_ALMA, ");
    consulta.append("        TMA.IND_MANT_MOVI, ");
		consulta.append("        TMA.IND_SAP, ");
		consulta.append("        TMA.ESME_OID_ESTA_MERC_1, ");
    consulta.append("        TMA.ESME_OID_ESTA_MERC_2, ");
 		consulta.append("        PQ_APL_AUX.Valor_Gen_I18n_Sicc(" + idioma + ",TMA.ESME_OID_ESTA_MERC_1,'BEL_ESTAD_MERCA') DES_ESTA_MERC_1, ");
		consulta.append("        PQ_APL_AUX.Valor_Gen_I18n_Sicc(" + idioma + ",TMA.ESME_OID_ESTA_MERC_2,'BEL_ESTAD_MERCA') DES_ESTA_MERC_2 ");
	  consulta.append(" FROM BEL_TIPO_MOVIM_ALMAC TMA, ");
		consulta.append("      BEL_ESTAD_MERCA BEM1, ");
		consulta.append("      BEL_ESTAD_MERCA BEM2 ");
	  consulta.append(" WHERE TMA.ESME_OID_ESTA_MERC_1 = BEM1.OID_ESTA_MERC(+) ");
		consulta.append("   AND TMA.ESME_OID_ESTA_MERC_2 = BEM2.OID_ESTA_MERC(+) ");
		consulta.append("   AND TMA.OID_TIPO_MOVI_ALMA = " + oid);    
    
    /* Modificacion por Performance alorenzo 16/08/2006  */
		/*
    consulta.append(" SELECT t.OID_TIPO_MOVI_ALMA, t.PAIS_OID_PAIS, t.COD_TIPO_MOVI, ");

		// Subselect para obtener la descripcion del tipo de movimiento
		consulta.append(" (SELECT idio.VAL_I18N FROM V_GEN_I18N_SICC idio ");
		consulta.append(" WHERE idio.ATTR_ENTI = 'BEL_TIPO_MOVIM_ALMAC' ");
		consulta.append(" AND idio.IDIO_OID_IDIO = " + idioma);
		consulta.append(" AND idio.VAL_OID = t.OID_TIPO_MOVI_ALMA) AS DES_TIPO_MOVI, ");

		consulta.append(" t.COD_MOVI_SAP, t.COD_OPER_1, t.COD_OPER_2, t.IND_MOVI_ENTR_ALMA, ");
		consulta.append(" t.IND_MANT_MOVI, t.IND_SAP, t.ESME_OID_ESTA_MERC_1, ");
		consulta.append(" t.ESME_OID_ESTA_MERC_2, ");

		// Subselect para obtener la descripcion del estado de mercancia 1
		consulta.append(" (SELECT idio.VAL_I18N FROM V_GEN_I18N_SICC idio ");
		consulta.append(" WHERE idio.ATTR_ENTI = 'BEL_ESTAD_MERCA' ");
		consulta.append(" AND idio.IDIO_OID_IDIO = " + idioma);
		consulta.append(" AND idio.VAL_OID = t.ESME_OID_ESTA_MERC_1) AS DES_ESTA_MERC_1, ");

		// Subselect para obtener la descripcion del estado de mercancia 2
		consulta.append("(SELECT idio.VAL_I18N FROM V_GEN_I18N_SICC idio ");
		consulta.append("WHERE idio.ATTR_ENTI = 'BEL_ESTAD_MERCA' ");
		consulta.append("AND idio.IDIO_OID_IDIO = " + idioma);
		consulta.append("AND idio.VAL_OID = t.ESME_OID_ESTA_MERC_2) AS DES_ESTA_MERC_2 ");

		consulta.append(" FROM (BEL_TIPO_MOVIM_ALMAC t LEFT JOIN BEL_ESTAD_MERCA e ON (t.ESME_OID_ESTA_MERC_1 = e.OID_ESTA_MERC)");
		consulta.append(" LEFT JOIN BEL_ESTAD_MERCA e2 ON (t.ESME_OID_ESTA_MERC_2 = e2.OID_ESTA_MERC)) ");
		consulta.append(" WHERE t.OID_TIPO_MOVI_ALMA = " + oid);
    */
		
		// Se ejecuta la consulta 
		BelcorpService bs = UtilidadesEJB.getBelcorpService();
		RecordSet resultado = null;
		String codigoError = null;
		try {
			resultado = bs.dbService.executeStaticQuery(consulta.toString());
		} catch (Exception e) {
            codigoError = CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS;
			this.logError("consultarTipoMovimientoAlmacen: Exception",e);
			this.logSql("consultarTipoMovimientoAlmacen. SQL: ",consulta.toString(),
				parametros);
            throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));
		}

		if (resultado == null) {
			resultado = new RecordSet();
		}
		
		UtilidadesLog.info("DAOTiposMovimientosAlmacen.consultarTipoMovimientoAlmacen(DTOOID dto):Salida");
		return resultado;
	}
    
    public RecordSet obtenerTiposMovimientosIndicadorSAP (DTOBelcorp dto) throws MareException {
    	UtilidadesLog.info("DAOTiposMovimientosAlmacen.obtenerTiposMovimientosIndicadorSAP(DTOBelcorp dto):Entrada");
        Long pais = dto.getOidPais();
		Long idioma = dto.getOidIdioma();

		// Parametros de la consulta
		Vector parametros = new Vector();
		
		// Se crea la consulta SQL
		StringBuffer consulta = new StringBuffer();
		consulta.append("SELECT t.OID_TIPO_MOVI_ALMA, ");

		// Subselect para obtener la descripcion del tipo de movimiento
		consulta.append("(SELECT idio.VAL_I18N FROM V_GEN_I18N_SICC idio ");
		consulta.append("WHERE idio.ATTR_ENTI = 'BEL_TIPO_MOVIM_ALMAC' ");
		consulta.append("AND idio.IDIO_OID_IDIO = ? ");
		consulta.append("AND idio.VAL_OID = t.OID_TIPO_MOVI_ALMA) AS DES_TIPO_MOVI ");
		parametros.add(idioma);
		
		consulta.append("FROM BEL_TIPO_MOVIM_ALMAC t ");
		consulta.append("WHERE t.PAIS_OID_PAIS = ? ");
        consulta.append(" AND t.IND_SAP = 1 ");
		consulta.append(" ORDER BY DES_TIPO_MOVI");
		parametros.add(pais);

		// Se ejecuta la consulta 
		BelcorpService bs = UtilidadesEJB.getBelcorpService();
		RecordSet resultado = null;
		String codigoError = null;
		try {
			resultado = bs.dbService.executePreparedQuery(consulta.toString(), 
				parametros);
		}
        catch (Exception e) {
            codigoError = CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS;			
            throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));
		}

		if (resultado == null) {
			resultado = new RecordSet();
		}
        
        UtilidadesLog.info("DAOTiposMovimientosAlmacen.obtenerTiposMovimientosIndicadorSAP(DTOBelcorp dto):Salida");    
        return resultado;               
    }

	public RecordSet obtenerTiposMovimientosAlmacen(DTOBelcorp dto) throws MareException {
		UtilidadesLog.info("DAOTiposMovimientosAlmacen.obtenerTiposMovimientosAlmacen(DTOBelcorp dto):Entrada");

		Long pais = dto.getOidPais();
		Long idioma = dto.getOidIdioma();

		// Parametros de la consulta
		Vector parametros = new Vector();
		
		// Se crea la consulta SQL
		StringBuffer consulta = new StringBuffer();
		consulta.append("SELECT t.OID_TIPO_MOVI_ALMA, ");

		// Subselect para obtener la descripcion del tipo de movimiento
		consulta.append("(SELECT idio.VAL_I18N FROM V_GEN_I18N_SICC idio ");
		consulta.append("WHERE idio.ATTR_ENTI = 'BEL_TIPO_MOVIM_ALMAC' ");
		consulta.append("AND idio.IDIO_OID_IDIO = ? ");
		consulta.append("AND idio.VAL_OID = t.OID_TIPO_MOVI_ALMA) AS DES_TIPO_MOVI ");
		parametros.add(idioma);
		
		consulta.append("FROM BEL_TIPO_MOVIM_ALMAC t ");
		consulta.append("WHERE t.PAIS_OID_PAIS = ? ");
		consulta.append(" ORDER BY DES_TIPO_MOVI");
		parametros.add(pais);

		// Se ejecuta la consulta 
		BelcorpService bs = UtilidadesEJB.getBelcorpService();
		RecordSet resultado = null;
		String codigoError = null;
		try {
			resultado = bs.dbService.executePreparedQuery(consulta.toString(), 
				parametros);
		} catch (Exception e) {
            codigoError = CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS;
			this.logError("obtenerTiposMovimientosAlmacen: Exception",e);
			this.logSql("obtenerTiposMovimientosAlmacen. SQL: ",consulta.toString(),
				parametros);
            throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));
		}

		if (resultado == null) {
			resultado = new RecordSet();
		}
		
		UtilidadesLog.info("DAOTiposMovimientosAlmacen.obtenerTiposMovimientosAlmacen(DTOBelcorp dto):Salida");
		return resultado;
	}

	private void logError(String mensaje,Throwable e) {
		UtilidadesLog.error("*** Error Metodo "+mensaje+": "+ e.getMessage()+ " ***");
		UtilidadesLog.error(e);
	}

	private void logStackTrace(Throwable e) {
		try {						
			ByteArrayOutputStream pila = new ByteArrayOutputStream();
			PrintStream out = new PrintStream(pila);
			/*e.printStackTrace(out);
			UtilidadesLog.error(pila.toString());*/
      UtilidadesLog.error(e);
		} catch (Exception ex) {
			UtilidadesLog.error("Traza de la pila: "+ex.getMessage());
		}			
	}

	private void logSql(String metodo, String sql, Vector params){
		UtilidadesLog.debug(metodo + sql);
		if (params!=null && params.size()>0) {
			String sParams="";
			for (int i=0; i<params.size();i++){
				sParams+="param "+ (i+1) + ": " + params.elementAt(i) + ", ";
			}
			UtilidadesLog.debug(metodo + sParams);
		}
	}	
}