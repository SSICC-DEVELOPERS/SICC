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

import es.indra.sicc.util.UtilidadesEJB;
import es.indra.sicc.util.BelcorpService;
import java.util.Vector;
import es.indra.mare.common.mii.services.jdbcservice.RecordSet;
import es.indra.mare.common.exception.MareException;
import es.indra.sicc.util.CodigosError;
import es.indra.sicc.util.UtilidadesError;
import es.indra.sicc.util.UtilidadesLog;

import java.math.BigDecimal;

public class DAOProcesos  {

    public DAOProcesos() {
    }

    public Boolean obtenerIndicadorGeneraCC( Long tipoSolicitud, String proceso) throws MareException {

        UtilidadesLog.info("DAOProcesos.obtenerIndicadorGeneraCC( Long tipoSolicitud, String proceso): Entrada");
        //Se hace una selección de registros de la tabla PED_SECUE_PROCE: 
        
        StringBuffer consulta = new StringBuffer();
        Vector parametros = new Vector();

        consulta.append("select count(*) ");
        consulta.append(" from PED_SECUE_PROCE ");
        consulta.append(" where TSPA_OID_TIPO_SOLI_PAIS = ? ");
		parametros.add(tipoSolicitud);
		consulta.append("and PROC_OID_PROC in ( select OID_PROC from PED_PROCE where COD_PROC = ? ) "); 
        parametros.add(proceso);

        BelcorpService bs = UtilidadesEJB.getBelcorpService();
        RecordSet rs = null;
        String codigoError = null;
        try{
           rs =bs.dbService.executePreparedQuery(consulta.toString(),parametros);
        }catch (Exception e) {
            codigoError = CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS;
			UtilidadesLog.error("obtenerIndicadorGeneraCC: Exception",e);
			this.logSql("obtenerIndicadorGeneraCC. SQL: ",consulta.toString(),
				parametros);
            throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));

		}

        UtilidadesLog.info("DAOProcesos.obtenerIndicadorGeneraCC( Long tipoSolicitud, String proceso): Salida");
        if (((BigDecimal)rs.getValueAt(0,0)).longValue()!=0) {
			return new Boolean(true);
		}else {
			return new Boolean(false);
		}
      
    }

	 public Boolean comprobarProceso() throws MareException {

		UtilidadesLog.info("DAOProcesos.comprobarProceso(): Entrada");
		BelcorpService bs = UtilidadesEJB.getBelcorpService();
        RecordSet rs = null;
		String codigoError = null;
		StringBuffer consulta = new StringBuffer();
        
		consulta.append(" SELECT COUNT (*) ");
		consulta.append(" FROM PED_SECUE_PROCE SP, PED_TIPO_SOLIC_PAIS TSP ");
		consulta.append(" WHERE SP.TSPA_OID_TIPO_SOLI_PAIS = TSP.OID_TIPO_SOLI_PAIS ");

		try{
			rs= bs.dbService.executeStaticQuery(consulta.toString());
        }catch (Exception e) {
            codigoError = CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS;
			UtilidadesLog.error("comprobarProceso: Exception",e);
			this.logSql("comprobarProceso. SQL: ",consulta.toString(),
				null);
				
            throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));
		}

		UtilidadesLog.info("DAOProcesos.comprobarProceso(): Salida");
		if (((BigDecimal)rs.getValueAt(0,0)).longValue()!=0) {
			return new Boolean(true);
		}else {
			return new Boolean(false);
		}

		
	}
   
	private void logSql(String metodo, String sql, Vector params){
        UtilidadesLog.info("DAOProcesos.logSql(String metodo, String sql, Vector params): Entrada");
		UtilidadesLog.debug(metodo + sql);
		if (params!=null && params.size()>0) {
			String sParams="";
			for (int i=0; i<params.size();i++){
				sParams+="param "+ (i+1) + ": " + params.elementAt(i) + ", ";
			}
			UtilidadesLog.debug(metodo + sParams);
		}
        UtilidadesLog.info("DAOProcesos.logSql(String metodo, String sql, Vector params): Salida");
	}	
    
}