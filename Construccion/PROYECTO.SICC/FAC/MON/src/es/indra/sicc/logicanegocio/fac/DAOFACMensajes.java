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

import es.indra.mare.common.exception.MareException;

import es.indra.mare.common.mii.services.jdbcservice.RecordSet;

import es.indra.sicc.util.BelcorpService;
import es.indra.sicc.util.CodigosError;
import es.indra.sicc.util.UtilidadesEJB;
import es.indra.sicc.util.UtilidadesError;
import es.indra.sicc.util.UtilidadesLog;

import java.math.BigDecimal;

import java.util.ArrayList;
import java.util.Vector;

import es.indra.sicc.dtos.fac.DTOFACCabeceraDocContable;
import es.indra.sicc.dtos.msg.DTOBuzonMensajes;

public class DAOFACMensajes  {

	public DAOFACMensajes() {
	}

    // CAMBIA EL DISEÑO DEL METODO POR INCIDENCIA 18507
	public ArrayList obtenerMensajes(DTOFACCabeceraDocContable cabeceraDC) throws MareException {
		UtilidadesLog.info("DAOFACMensajes.obtenerMensajes(DTOFACCabeceraDocContable cabeceraDC): Entrada");

		StringBuffer sql = new StringBuffer("");
		Vector parametros = new Vector();

		sql.append(" SELECT VAL_BUZO_MENS as OID ");
		sql.append(" FROM FAC_MENSA_FACTU MF ");
		sql.append(" WHERE DCCA_OID_CABE = ? "); 
		parametros.add(cabeceraDC.getOidCabeceraSolicitud());

		BelcorpService bs = UtilidadesEJB.getBelcorpService();
		RecordSet rs = null;
		String codigoError = null;
		try {
			rs = bs.dbService.executePreparedQuery(sql.toString(), parametros);
		} catch (Exception e) {
			codigoError = CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS;
			UtilidadesLog.error("obtenerMensajes: Exception",e);
			this.logSql("obtenerMensajes. SQL: ",sql.toString(), parametros);
			throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));
		}
		ArrayList salida = new ArrayList();
        int tamanyo = rs.getRowCount();        
		if (rs.esVacio()){
			UtilidadesLog.debug("****DAOFACMensajes.obtenerMensajes: No existen mensajes para el documento contable con oid = "+ cabeceraDC.getOidSolicitud());
		}

		for(int i=0; i<tamanyo; i++){
			DTOBuzonMensajes dtoBM = new DTOBuzonMensajes();
			dtoBM.setOid(new Long(((BigDecimal)rs.getValueAt(i,"OID")).longValue()));
			salida.add(dtoBM);
		}
		
		UtilidadesLog.info("DAOFACMensajes.obtenerMensajes(DTOFACCabeceraDocContable cabeceraDC): Salida");
		return salida;
	 }

    // METODO CAMBIADO POR INCIDENCIA 18507
	public void marcarMensajesBorrados(DTOFACCabeceraDocContable cabecera) throws MareException {
		UtilidadesLog.info("DAOFACMensajes.marcarMensajesBorrados(DTOFACCabeceraDocContable cabecera): Entrada");
        UtilidadesLog.debug("DTOCabecera: "+cabecera);

		 
		StringBuffer sql = new StringBuffer("");
		Vector parametros = new Vector();
	
        sql.append(" DELETE FROM FAC_MENSA_FACTU ");	
        sql.append(" WHERE DCCA_OID_CABE = ? ");
        parametros.add(cabecera.getOidCabeceraSolicitud());
        
        BelcorpService bs = null;
        bs = BelcorpService.getInstance();

        try{
            bs.dbService.executePreparedUpdate(sql.toString(), parametros);
        } catch(Exception e) {
            UtilidadesLog.error(" marcarMensajesBorrados:",e);
            this.logSql(" marcarMensajesBorrados. SQL: ",sql.toString(),parametros);
            throw new MareException(e, UtilidadesError.armarCodigoError(
                            CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS));
        }
		UtilidadesLog.info("DAOFACMensajes.marcarMensajesBorrados(DTOFACCabeceraDocContable cabecera): Salida");
	}

	private String convertirArrayToString(Long[] oids){
        UtilidadesLog.info("DAOFACMensajes.convertirArrayToString(Long[] oids): Entrada");
		String retorno = "";
		if((oids!=null)&&(oids.length!=0)){
				StringBuffer sentencia = new StringBuffer("");
				for(int i=0;i<oids.length;i++){
						UtilidadesLog.debug("\n array[ ]=" + oids[i]);
						if(oids[i]!=null){
								sentencia.append(" ?, ");
						}
				}
				//Quitamos la coma y el espacio del final
				if (sentencia.length() > 0)
					retorno= sentencia.substring(0,sentencia.length()-2);
				 
		}else{
            UtilidadesLog.info("DAOFACMensajes.convertirArrayToString(Long[] oids): Salida");
			return "";
		}
		UtilidadesLog.info("DAOFACMensajes.convertirArrayToString(Long[] oids): Salida");	
		return retorno;
	}
    public Long obtenerNumeroSecuencial() throws MareException{
        UtilidadesLog.info("DAOFACMensajes.obtenerNumeroSecuencial(): Entrada");
        StringBuffer sql = new StringBuffer("");

        sql.append("SELECT MAX(VAL_NUME_SECU) FROM FAC_MENSA_FACTU ");
        
        BelcorpService bs = UtilidadesEJB.getBelcorpService();
		RecordSet rs = null;
		String codigoError = null;
		try {
			rs = bs.dbService.executeStaticQuery(sql.toString());
		} catch (Exception e) {
			codigoError = CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS;
			UtilidadesLog.error("obtenerMensajes: Exception",e);
			this.logSql("obtenerMensajes. SQL: ",sql.toString(), null);
			throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));
		}
       
        UtilidadesLog.info("DAOFACMensajes.obtenerNumeroSecuencial(): Salida");
        
        if(rs.getValueAt(0,0) != null){
            Long numSecuencial = new Long( ((BigDecimal)rs.getValueAt(0,0)).longValue());
            return new Long(numSecuencial.longValue() + 1);
        }else{
            return new Long("1");
        } 
        
    }

	private void logSql(String metodo, String sql, Vector params){
        UtilidadesLog.info("DAOFACMensajes.logSql(String metodo, String sql, Vector params): Entrada");
		UtilidadesLog.debug(metodo + sql);
		if (params!=null && params.size()>0) {
			String sParams="";
			for (int i=0; i<params.size();i++){
				sParams+="param "+ (i+1) + ": " + params.elementAt(i) + ", ";
			}
			UtilidadesLog.debug(metodo + sParams);
		}
        UtilidadesLog.info("DAOFACMensajes.logSql(String metodo, String sql, Vector params): Salida");
	}
    
}