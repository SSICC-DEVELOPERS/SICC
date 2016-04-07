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
 
package es.indra.sicc.logicanegocio.fac;

import java.util.Vector;
//import java.io.ByteArrayOutputStream;

import es.indra.sicc.util.BelcorpService;
import es.indra.sicc.util.UtilidadesEJB;
import es.indra.sicc.util.CodigosError;
import es.indra.sicc.util.UtilidadesError;
import es.indra.sicc.util.DTOOID;
import es.indra.sicc.util.DTOBelcorp;
import es.indra.sicc.util.UtilidadesLog;

import es.indra.mare.common.mii.services.jdbcservice.RecordSet;
import es.indra.mare.common.exception.MareException;

public class DAOFacturacion  {
	private String usuario= null;

	public DAOFacturacion(String usuario) {
		this.usuario = usuario;
	}

	public RecordSet obtenerFormulariosTipoSolicitud(DTOOID dto) throws MareException {
		UtilidadesLog.info("DAOFacturacion.obtenerFormulariosTipoSolicitud(DTOOID dto): Entrada");

		Long oid = dto.getOid();

		// Parametros de la consulta
		Vector parametros = new Vector();
		
		// Se crea la consulta SQL
		StringBuffer consulta = new StringBuffer();
		consulta.append("	SELECT f.OID_FORM, f.COD_FORM, f.VAL_NOMB_FORM, f.IND_ACTI, ");
		consulta.append("	d.DES_TIPO_DOCU, f.IND_IMPR, t.NUM_ORDE_SECU,  t.OID_FORM_TIPO_SOLI ");
		consulta.append("	FROM FAC_FORMU f, FAC_FORMU_TIPO_SOLIC t, FAC_TIPO_DOCUM d ");
		consulta.append("	WHERE f.OID_FORM = t.FORS_OID_FORM (+)");
		consulta.append("	AND f.TIDO_OID_TIPO_DOCU = d.OID_TIPO_DOCU(+) ");
		consulta.append("	AND t.TSPA_OID_TIPO_SOLI_PAIS (+) = ? ");
		parametros.add(oid);
		
		// Se ejecuta la consulta 
		BelcorpService bs = UtilidadesEJB.getBelcorpService();
		RecordSet resultado = null;
		String codigoError = null;
		try {
			resultado = bs.dbService.executePreparedQuery(consulta.toString(), 
				parametros);
		} catch (Exception e) {
            codigoError = CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS;
			this.logError("obtenerFormulariosTipoSolicitud: Exception",e);
			this.logSql("obtenerFormulariosTipoSolicitud. SQL: ",consulta.toString(),
				parametros);
            throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));
		}
		
		UtilidadesLog.info("DAOFacturacion.obtenerFormulariosTipoSolicitud(DTOOID dto): Salida");
		return resultado;
	}

	public RecordSet obtenerTiposDocumentoLegal(DTOBelcorp dto) throws MareException {
		UtilidadesLog.info("DAOFacturacion.obtenerTiposDocumentoLegal(DTOBelcorp dto): Entrada");

		// Se crea la consulta SQL
		StringBuffer consulta = new StringBuffer();
		consulta.append("SELECT OID_TIPO_DOCU, DES_TIPO_DOCU ");
		consulta.append(" FROM FAC_TIPO_DOCUM ");
		consulta.append(" ORDER BY DES_TIPO_DOCU ");
		
		// Se ejecuta la consulta 
		BelcorpService bs = UtilidadesEJB.getBelcorpService();
		RecordSet resultado = null;
		String codigoError = null;
		try {
			resultado = bs.dbService.executeStaticQuery(consulta.toString()); 
		} catch (Exception e) {
            codigoError = CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS;
			this.logError("obtenerTiposDocumentoLegal: Exception",e);
			this.logSql("obtenerTiposDocumentoLegal. SQL: ",consulta.toString(),
				null);
            throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));
		}
		
		UtilidadesLog.info("DAOFacturacion.obtenerTiposDocumentoLegal(DTOBelcorp dto): Salida");
		return resultado;
	}

	/** 
     * Método para obtener los formularios
     * @return RecordSet el resultado de la consulta
     * @exception MareException 
     */
	//Incidencia 8989
	public RecordSet obtenerFormularios() throws MareException{
		UtilidadesLog.info("DAOFacturacion.obtenerFormularios(): Entrada");
		StringBuffer consulta = new StringBuffer();
		//SELECT
		consulta.append(" SELECT OID_FORM, VAL_NOMB_FORM ");
		//FROM
		consulta.append(" FROM FAC_FORMU ");
		//WHERE
		consulta.append(" WHERE IND_ACTI = 1 ");
        
		consulta.append("  ORDER BY UPPER(VAL_NOMB_FORM)        ");

		BelcorpService bs = UtilidadesEJB.getBelcorpService();
		RecordSet resultado = null;
		String codigoError = null;
		try {
			resultado = bs.dbService.executeStaticQuery(consulta.toString()); 
		} catch (Exception e) {
            codigoError = CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS;
			UtilidadesLog.error("obtenerFormularios: Exception",e);
			this.logSql("obtenerFormularios. SQL: ",consulta.toString(),
				null);
            throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));
		}
		UtilidadesLog.info("DAOFacturacion.obtenerFormularios(): Salida");

		return resultado;
	 }

	// Añadido Incidencia 11153 
	public RecordSet obtenerTiposCierre() throws MareException {
		UtilidadesLog.info("DAOFacturacion.obtenerTiposCierre(): Entrada");

		// Se crea la consulta SQL
		StringBuffer consulta = new StringBuffer();

		//"Accede a la tabla FAC_TIPOS_CIERR, y obtiene los campos OID_TIPO_CIER y COD_TIPO_CIER
		//de sus registros."
		
		consulta.append(" SELECT OID_TIPO_CIER, COD_TIPO_CIER ");
		consulta.append(" FROM FAC_TIPOS_CIERR ");
		
		// Se ejecuta la consulta 
		BelcorpService bs = UtilidadesEJB.getBelcorpService();
		RecordSet resultado = null;
		String codigoError = null;
		try {
			resultado = bs.dbService.executeStaticQuery(consulta.toString());
		} catch (Exception e) {
            codigoError = CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS;
			this.logError("obtenerTiposCierre: Exception",e);
			this.logSql("obtenerTiposCierre. SQL: ",consulta.toString(),null);
            throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));
		}
		
		UtilidadesLog.info("DAOFacturacion.obtenerTiposCierre(): Salida");
		return resultado;
	}
	 
	private void logError(String mensaje,Throwable e) {
        UtilidadesLog.info("DAOFacturacion.logError(String mensaje,Throwable e): Entrada");
		UtilidadesLog.error("*** Error Metodo "+mensaje+": "+ e.getMessage()+ " ***");
		this.logStackTrace(e);
        UtilidadesLog.info("DAOFacturacion.logError(String mensaje,Throwable e): Salida");
	}

	private void logStackTrace(Throwable e) {
        UtilidadesLog.info("DAOFacturacion.logStackTrace(Throwable e): Entrada");
		try {						
			UtilidadesLog.error(e);
            UtilidadesLog.info("DAOFacturacion.logStackTrace(Throwable e): Salida");
		} catch (Exception ex) {
			UtilidadesLog.error("Traza de la pila: "+ex.getMessage());
		}			
	}

	private void logSql(String metodo, String sql, Vector params){
        UtilidadesLog.info("DAOFacturacion.logSql(String metodo, String sql, Vector params): Entrada");
		UtilidadesLog.debug(metodo + sql);
		if (params!=null && params.size()>0) {
			String sParams="";
			for (int i=0; i<params.size();i++){
				sParams+="param "+ (i+1) + ": " + params.elementAt(i) + ", ";
			}
			UtilidadesLog.debug(metodo + sParams);
		}
        UtilidadesLog.info("DAOFacturacion.logSql(String metodo, String sql, Vector params): Salida");
	}	
}