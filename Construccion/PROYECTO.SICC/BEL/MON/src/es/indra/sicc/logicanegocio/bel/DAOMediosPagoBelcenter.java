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

import es.indra.sicc.util.DTOOID;
import es.indra.sicc.util.UtilidadesLog;
import java.util.Vector;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import es.indra.sicc.util.DTOSalida;
import es.indra.sicc.util.BelcorpService;
import es.indra.sicc.util.UtilidadesEJB;
import es.indra.sicc.util.CodigosError;
import es.indra.sicc.util.UtilidadesError;
import es.indra.sicc.util.UtilidadesPaginacion;

import es.indra.sicc.dtos.bel.DTOEBuscarMediosPagoBelcenter;

import es.indra.mare.common.mii.services.jdbcservice.RecordSet;
import es.indra.mare.common.mii.services.logging.LoggingService;
import es.indra.mare.common.mii.MareMii;
import es.indra.mare.common.mii.MareTopic;
import es.indra.mare.common.exception.MareException;


public class DAOMediosPagoBelcenter  {
	private String usuario = null;
	
	public DAOMediosPagoBelcenter(String usuario) {
		this.usuario = usuario;
	}

	public DTOSalida buscarMediosPagoBelcenter(DTOEBuscarMediosPagoBelcenter dto) 
		throws MareException {
		UtilidadesLog.info("DAOMediosPagoBelcenter.buscarMediosPagoBelcenter(DTOEBuscarMediosPagoBelcenter dto):Entrada");

		Long idioma = dto.getOidIdioma();

		// Parametros de la consulta
		Vector parametros = new Vector();
		
		// Se crea la consulta SQL
		StringBuffer consulta = new StringBuffer();
		consulta.append("SELECT OID_MEDI_PAGO_BELC OID, ");

		// Subselect para obtener la descripcion del canal
		consulta.append("(SELECT idio.VAL_I18N FROM V_GEN_I18N_SICC idio ");
		consulta.append("WHERE idio.ATTR_ENTI = 'SEG_CANAL' ");
		consulta.append("AND idio.IDIO_OID_IDIO = ? ");
		consulta.append("AND idio.VAL_OID = a.CANA_OID_CANA ) AS DES_CANAL, ");
		parametros.add(idioma);

		// Subselect para obtener la descripcion del acceso
		consulta.append("(SELECT idio.VAL_I18N FROM V_GEN_I18N_SICC idio ");
		consulta.append("WHERE idio.ATTR_ENTI = 'SEG_ACCES' ");
		consulta.append("AND idio.IDIO_OID_IDIO = ? ");
		consulta.append("AND idio.VAL_OID = s.ACCE_OID_ACCE ) AS DES_ACCESO, ");
		parametros.add(idioma);
		
		// Subselect para obtener la descripcion del subacceso
		consulta.append("(SELECT idio.VAL_I18N FROM V_GEN_I18N_SICC idio ");
		consulta.append("WHERE idio.ATTR_ENTI = 'SEG_SUBAC' ");
		consulta.append("AND idio.IDIO_OID_IDIO = ? ");
		consulta.append("AND idio.VAL_OID = m.SBAC_OID_SBAC) AS DES_SUBAC, ");
		parametros.add(idioma);

		consulta.append("COD_MEDI_PAGO, ");

		// Subselect para obtener la descripcion del medio de pago
		consulta.append("(SELECT idio.VAL_I18N FROM V_GEN_I18N_SICC idio ");
		consulta.append("WHERE idio.ATTR_ENTI = 'BEL_MEDIO_PAGO' ");
		consulta.append("AND idio.IDIO_OID_IDIO = ? ");
		consulta.append("AND idio.VAL_OID = m.MPAB_OID_MEDI_PAGO) AS DES_MEDI_PAGO, ");
		parametros.add(idioma);

		consulta.append("(SELECT idio.VAL_I18N FROM V_GEN_I18N_SICC idio ");
		consulta.append("WHERE idio.ATTR_ENTI = 'BEL_TIPO_MEDIO_PAGO' ");
		consulta.append("AND idio.IDIO_OID_IDIO = ? ");
		consulta.append("AND idio.VAL_OID = t.oid_tipo_medi_pago) AS DES_TIPO_MEDIO_PAGO ");
		parametros.add(idioma);		
		
		consulta.append("FROM BEL_MEDIO_PAGO_BELCE m, VCA_SEG_SUBAC s, ");
		consulta.append("VCA_SEG_ACCES a, VCA_SEG_CANAL c, ");
		consulta.append("BEL_MEDIO_PAGO mp, BEL_TIPO_MEDIO_PAGO t ");
		if(dto.getDescripcion() != null) { 
			consulta.append(", V_GEN_I18N_SICC i ");		
		}
		consulta.append("WHERE m.SBAC_OID_SBAC = s.OID_SBAC ");
		consulta.append("AND s.ACCE_OID_ACCE = a.OID_ACCE ");
		consulta.append("AND a.CANA_OID_CANA = c.OID_CANA ");
		consulta.append("AND m.MPAB_OID_MEDI_PAGO = mp.OID_MEDI_PAGO ");
		consulta.append("AND mp.TMEP_OID_TIPO_MEDI_PAGO = t.OID_TIPO_MEDI_PAGO ");
		consulta.append("AND c.COD_USUA = ? ");
		parametros.add(this.usuario);
		consulta.append("AND s.COD_USUA = ? ");
		parametros.add(this.usuario);
		consulta.append("AND a.COD_USUA = ? ");
		parametros.add(this.usuario);

		if (dto.getOidAcceso() != null) { 
			consulta.append(" AND a.OID_ACCE = ? "); 
			parametros.add(dto.getOidAcceso());
		}

		if (dto.getOidCanal() != null) { 
			consulta.append(" AND c.OID_CANA = ? "); 
			parametros.add(dto.getOidCanal());
		}

		if (dto.getOidSubacceso() != null) { 
			consulta.append(" AND m.SBAC_OID_SBAC = ? "); 
			parametros.add(dto.getOidSubacceso());
		}

		if (dto.getCodigoMedioPago() != null) { 
			consulta.append(" AND mp.COD_MEDI_PAGO LIKE ? "); 
			parametros.add(dto.getCodigoMedioPago());
		}

		if (dto.getOidTipoMedioPago() != null) { 
			consulta.append(" AND t.OID_TIPO_MEDI_PAGO = ? "); 
			parametros.add(dto.getOidTipoMedioPago());
		}

		if(dto.getDescripcion() != null) { 
			consulta.append(" AND i.VAL_OID = mp.OID_MEDI_PAGO ");
			consulta.append(" AND i.IDIO_OID_IDIO = ? ");
			parametros.add(dto.getOidIdioma());
			consulta.append(" AND i.ATTR_NUM_ATRI = 1 ");
			consulta.append(" AND i.ATTR_ENTI = 'BEL_MEDIO_PAGO'");
			consulta.append(" AND i.VAL_I18N LIKE ?");		
			parametros.add(dto.getDescripcion());
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
			this.logError("buscarMediosPagoBelcenter: Exception",e);
			this.logSql("buscarMediosPagoBelcenter. SQL: ",sql,parametros);
            throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));
		}

		DTOSalida dtoSalida = null;
		if (resultado != null) {
			dtoSalida = new DTOSalida(resultado);
		} else {
			dtoSalida = new DTOSalida(new RecordSet());
		}
				
		UtilidadesLog.info("DAOMediosPagoBelcenter.buscarMediosPagoBelcenter(DTOEBuscarMediosPagoBelcenter dto):Salida");
		return dtoSalida;
	}

	public RecordSet consultarMediosPagoBelcenter(Long subacceso) throws MareException {
		UtilidadesLog.info("DAOMediosPagoBelcenter.consultarMediosPagoBelcenter(Long subacceso):Entrada");

		// Parametros de la consulta
		Vector parametros = new Vector();
		
		// Se crea la consulta SQL
		StringBuffer consulta = new StringBuffer();
		consulta.append("SELECT m.MPAB_OID_MEDI_PAGO ");
		consulta.append("FROM BEL_MEDIO_PAGO_BELCE m, VCA_SEG_SUBAC s ");
		consulta.append("WHERE m.SBAC_OID_SBAC = s.OID_SBAC ");
		consulta.append("AND s.COD_USUA = ? ");
		parametros.add(usuario);
		consulta.append("AND m.SBAC_OID_SBAC = ? "); 
		parametros.add(subacceso);
		
		// Se ejecuta la consulta 
		BelcorpService bs = UtilidadesEJB.getBelcorpService();
		RecordSet resultado = null;
		String codigoError = null;
		try {
			resultado = bs.dbService.executePreparedQuery(consulta.toString(), 
				parametros);
		} catch (Exception e) {
            codigoError = CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS;
			this.logError("buscarMediosPagoBelcenter: Exception",e);
			this.logSql("buscarMediosPagoBelcenter. SQL: ",consulta.toString(),
				parametros);
            throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));
		}

		if (resultado == null) {
			resultado = new RecordSet();
		}
		
		UtilidadesLog.info("DAOMediosPagoBelcenter.consultarMediosPagoBelcenter(Long subacceso):Salida");
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
			//UtilidadesLog.error(pila.toString());
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
  
      /**
   * @author pperanzola
   * @date 28/02/2005
   * @throws es.indra.mare.common.exception.MareException
   * @return RecordSet
   * @param dto
   * Obtiene los medios de pago filtrando por el subacceso (valido para el usuario) 
   */
   /**
   * Autor: Cortaberria
   * Fecha: 06/05/2004¡5
   * Se aplican cambios especificados en la incidencia BELC300017543
   */
    public RecordSet obtenerMediosPagoSubacceso(DTOOID dtoe) throws MareException{
        UtilidadesLog.info("DAOMediosPagoBelcenter.obtenerMediosPagoSubacceso(DTOOID dtoe):Entrada");    
        StringBuffer qry  = new StringBuffer();
        RecordSet rs = null;
        
        qry.append("SELECT ");
        qry.append(" MPB.OID_MEDI_PAGO_BELC OID_MEDIO_PAGO,");
        qry.append(" GMP.VAL_I18N MEDIO_PAGO,  ");
        qry.append(" MP.TMEP_OID_TIPO_MEDI_PAGO TIPO_MEDIO_PAGO ");
        
        qry.append(" FROM");
        qry.append(" BEL_MEDIO_PAGO_BELCE MPB,BEL_MEDIO_PAGO MP,  ");
        qry.append(" GEN_I18N_SICC_COMUN GMP, VCA_SEG_SUBAC VSB  ");
        
        qry.append(" WHERE");
        qry.append(" GMP.VAL_OID = MPB.MPAB_OID_MEDI_PAGO AND ");
        qry.append(" GMP.ATTR_ENTI = 'BEL_MEDIO_PAGO' AND ");
        qry.append(" GMP.ATTR_NUM_ATRI = 1 AND ");
        qry.append(" GMP.IDIO_OID_IDIO = " + dtoe.getOidIdioma() + " AND ");
        qry.append(" MPB.MPAB_OID_MEDI_PAGO = MP.OID_MEDI_PAGO AND ");
        // SUBACCESO        
        qry.append(" TO_CHAR(MPB.SBAC_OID_SBAC) = '" + dtoe.getOid() + "' AND ");  //a raiz del error -> invalid number
        qry.append(" VSB.OID_SBAC = MPB.SBAC_OID_SBAC AND ");
        qry.append(" VSB.COD_USUA = '" + this.usuario  + "' AND");
        qry.append(" MPB.MPAB_OID_MEDI_PAGO = MP.OID_MEDI_PAGO AND ");
        qry.append(" MP.PAIS_OID_PAIS = ").append(dtoe.getOidPais());
        qry.append(" ORDER BY ");
        qry.append(" MP.TMEP_OID_TIPO_MEDI_PAGO ");
        
        try {
            rs = BelcorpService.getInstance().dbService.executeStaticQuery(qry.toString());
        }
        catch (Exception e) {
            UtilidadesLog.debug(e);
            throw new MareException(e,UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS));
        }
        if (rs.esVacio()) {
            UtilidadesLog.debug("obtenerMediosPagoSubacceso -> Recordset vacio...");
            throw new MareException(new Exception(),UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE));
        }
        UtilidadesLog.info("DAOMediosPagoBelcenter.obtenerMediosPagoSubacceso(DTOOID dtoe):Salida");
        return rs;
    }
}