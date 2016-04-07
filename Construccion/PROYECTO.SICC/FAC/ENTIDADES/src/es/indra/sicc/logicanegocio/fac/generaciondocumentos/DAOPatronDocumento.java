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

package es.indra.sicc.logicanegocio.fac.generaciondocumentos;

import es.indra.mare.common.exception.MareException;

import es.indra.sicc.util.UtilidadesLog;
import java.util.Vector;

import es.indra.sicc.util.BelcorpService;


import es.indra.sicc.util.CodigosError;
import es.indra.sicc.util.UtilidadesEJB;
import es.indra.sicc.util.UtilidadesError;

import es.indra.mare.common.mii.services.jdbcservice.RecordSet; 

import java.math.BigDecimal;

public class DAOPatronDocumento  {
	public DAOPatronDocumento() {
	}
//Incidencia BELC300011368
//Ahora hay que pasarle también el periodo, y por lo tanto hay que modificar la llamada que se hace a este método
//desde el método generarDocFactura del MONSICCImpresion.

	public Long consultarPatronDocumento (Long oidForm, Long oidperiodo) throws MareException {
		UtilidadesLog.info("DAOPatronDocumento.consultarPatronDocumento (Long oidForm, Long oidperiodo): Entrada"); 
    
		Vector parametros = new Vector();
        BelcorpService bs = UtilidadesEJB.getBelcorpService();
		StringBuffer consulta = new StringBuffer("");
		
		consulta.append(" SELECT A.OID_PATR FROM MSG_PATRO A WHERE A.FORS_OID_FORM = ? ");
		consulta.append(" AND A.IND_PATR_PERI = 0 ");
		consulta.append(" UNION SELECT A.OID_PATR FROM MSG_PATRO A, ");//--esto es fijo, y hay que dejarlo así
		consulta.append(" MSG_PATRO_PERIO B, cra_perio c WHERE A.FORS_OID_FORM =  ? ");
		consulta.append(" AND A.IND_PATR_PERI = 1 ");// --esto es fijo, y hay que dejarlo así
		consulta.append(" AND A.OID_PATR = B.PATR_OID_PATR ");
    consulta.append(" AND c.PERI_OID_PERI =  b.peri_oid_peri ");
		consulta.append(" AND c.oid_peri = ? ");
		parametros.add(oidForm);
		parametros.add(oidForm);
		parametros.add(oidperiodo);
		
		String codigoError = null;
		RecordSet rs = new RecordSet();
		try {
            rs = bs.dbService.executePreparedQuery(consulta.toString(), parametros);
        } catch (Exception e) {
            codigoError = CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS;
            this.logError("consultarPatronDocumento: Exception", e);
            this.logSql("consultarPatronDocumento. SQL: ", consulta.toString(), parametros);
            throw new MareException(e,
                UtilidadesError.armarCodigoError(codigoError));
        }
		Long resultado = null;
		if (!rs.esVacio()){
			  resultado = new Long(((BigDecimal) rs.getValueAt(0, 0)).intValue());
		}
		UtilidadesLog.info("DAOPatronDocumento.consultarPatronDocumento (Long oidForm, Long oidperiodo): Salida"); 
		return resultado;
	}
	
	private void logError(String mensaje, Throwable e) {
        UtilidadesLog.error("*** Error Metodo " + mensaje + ": " +
            e.getMessage());
        this.logStackTrace(e);
    }

    private void logSql(String metodo, String sql, Vector params) {
        UtilidadesLog.info("DAOPatronDocumento.logSql(String metodo, String sql, Vector params): Entrada"); 
        UtilidadesLog.debug(metodo + sql);

        if ((params != null) && (params.size() > 0)) {
            String sParams = "";

            for (int i = 0; i < params.size(); i++) {
                sParams += ("param " + (i + 1) + ": " + params.elementAt(i) +
                ", ");
            }

            UtilidadesLog.debug(metodo + sParams);
        }
        UtilidadesLog.info("DAOPatronDocumento.logSql(String metodo, String sql, Vector params): Entrada"); 
    }

    private void logStackTrace(Throwable e) {
        try {
            UtilidadesLog.error("ERROR",e);
        } catch (Exception ex) {
            UtilidadesLog.error("Traza de la pila: " + ex.getMessage());
        }
    }


}