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
import es.indra.sicc.util.DTOBelcorp;
import es.indra.sicc.util.DTOSalida;
import es.indra.sicc.util.UtilidadesEJB;
import es.indra.sicc.util.UtilidadesError;
import es.indra.sicc.util.UtilidadesLog;

import java.math.BigDecimal;

import java.util.Vector;
import java.util.Date;

import java.text.SimpleDateFormat;

public class DAOFAC  {
	public DAOFAC() {
	}

	public Integer obtenerTiposOfertaExcluidos (Long pais, Long tipoOferta, 
		java.util.Date fecha) throws MareException{
		//ver incidencia 10088
		UtilidadesLog.info("DAOFAC.obtenerTiposOfertaExcluidos (Long pais, Long tipoOferta, java.util.Date fecha): Entrada");

		Vector parametros = new Vector();
		// Se crea la consulta SQL
		StringBuffer consulta = new StringBuffer();

		consulta.append(" SELECT COUNT(*) FROM FAC_TIPO_OFERT_EXCLU TOE, ");
		consulta.append(" PRE_TIPO_OFERT TOF ");
		consulta.append(" WHERE TOE.TOFE_OID_TIPO_OFER = TOF.OID_TIPO_OFER ");
		consulta.append(" AND TOE.PAIS_OID_PAIS = ? ");
		parametros.add(pais);
		if(tipoOferta!=null){
			consulta.append(" AND TOE.TOFE_OID_TIPO_OFER = ? ");
			parametros.add(tipoOferta);
		}else{
			consulta.append(" AND TOE.TOFE_OID_TIPO_OFER IS NULL ");
		}
		consulta.append(" AND TOE.FEC_DESD <= TO_DATE( ? ,'YYYY-MM-DD') ");
		parametros.add(convertirFecha(fecha)); //incidencia BELC300008518 la select solo devolverá 0 o 1 registros
		consulta.append(" AND TOE.FEC_HAST >= TO_DATE( ? ,'YYYY-MM-DD') ");
		parametros.add(convertirFecha(fecha)); 

		
		BelcorpService bs = UtilidadesEJB.getBelcorpService();
		RecordSet resultado = null;
		String codigoError = null;
		try {
			resultado = bs.dbService.executePreparedQuery(consulta.toString(), 
				parametros);
		} catch (Exception e) {
            codigoError = CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS;
			UtilidadesLog.error(" obtenerTiposOfertaExcluidos: Exception",e);
			this.logSql(" obtenerTiposOfertaExcluidos. SQL: ",consulta.toString(),
				parametros);
            throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));
		}
		//Retorna el número de registros obtenido con la sentencia SQL.
		
		Integer numRegistros = new Integer(((BigDecimal)resultado.getValueAt(0,0)).intValue());
        UtilidadesLog.debug("registros obtenidos = "+numRegistros);
		UtilidadesLog.info("DAOFAC.obtenerTiposOfertaExcluidos (Long pais, Long tipoOferta, java.util.Date fecha): Salida");
		return numRegistros;
	}
	// Eliminado por BELC300008735 
	/*public DTOFACProducto obtenerDatosProducto (Long pais, String codigoSAP) throws MareException {

		UtilidadesLog.debug("*** Método obtenerDatosProducto: Entrada ");

		Vector parametros = new Vector();
		// Se crea la consulta SQL
		StringBuffer consulta = new StringBuffer();
		consulta.append(" SELECT DES_CORT, COD_IND_DENT_CAJA, MAPR_OID_MARC_PROD, ");
		consulta.append(" NEGO_OID_NEGO, UNEG_OID_UNID_NEGO, VAL_GRUP_ARTI ");
		consulta.append(" FROM MAE_PRODU ");
		consulta.append(" WHERE PAIS_OID_PAIS = ? ");
		parametros.add(pais);
		consulta.append(" AND COD_SAP =  ? ");
		parametros.add(codigoSAP);

		BelcorpService bs = UtilidadesEJB.getBelcorpService();
		RecordSet resultado = null;
		String codigoError = null;
		try {
			resultado = bs.dbService.executePreparedQuery(consulta.toString(), 
				parametros);
		} catch (Exception e) {
            codigoError = CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS;
			UtilidadesLog.error(" obtenerDatosProducto: Exception",e);
			this.logSql(" obtenerDatosProducto. SQL: ",consulta.toString(),
				parametros);
            throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));
		}

		DTOFACProducto dtoS = new DTOFACProducto();
		dtoS.setDescripcionSAP(resultado.getValueAt(0,"DES_CORT").toString());
		dtoS.setGrupoProductos(resultado.getValueAt(0,"VAL_GRUP_ARTI").toString());
		dtoS.setIndicadorDentroFueraCaja(resultado.getValueAt(0,"COD_IND_DENT_CAJA").toString());
        dtoS.setMarca(new Long(((BigDecimal)resultado.getValueAt(0,"MAPR_OID_MARC_PROD")).longValue()) );
		dtoS.setNegocio(new Long(((BigDecimal)resultado.getValueAt(0,"NEGO_OID_NEGO")).longValue()) );
		dtoS.setUnidadNegocio(new Long( ((BigDecimal)resultado.getValueAt(0,"UNEG_OID_UNID_NEGO")).longValue() ) );

		UtilidadesLog.debug("*** Método obtenerDatosProducto: Entrada ");
		//Con el registro obtenido crea y retorna un objeto DTOFACProducto.
		return dtoS;
	}
 */
	/*eliminado por la incidencia 10153
	 * public DTOFACMatriz obtenerDatosMatriz (Long pais, Long marca, Long canal, Long periodo,
			Long acceso, Long subacceso) throws MareException {

		UtilidadesLog.debug("*** Método obtenerDatosMatriz: Entrada ");

		Vector parametros = new Vector();
		// Se crea la consulta SQL
		StringBuffer consulta = new StringBuffer();
		consulta.append(" SELECT  POD.OCAT_OID_CATAL VAR_CATALOGO, POD.NUM_PAGI_CATA VAR_PAGINA ");
		consulta.append(" FROM PRE_MATRI_FACTU PMF, PRE_OFERT_DETAL POD, PRE_OFERT PO, ");
		consulta.append(" PRE_MATRI_FACTU_CABEC PMFC, CRA_PERIO CP "); 
		consulta.append(" WHERE CP.PAIS_OID_PAIS = ? ");
		parametros.add(pais);
		consulta.append(" AND CP.CANA_OID_CANA = ? ");
		parametros.add(canal);
		consulta.append(" AND CP.MARC_OID_MARC = ? ");
		parametros.add(marca);
		consulta.append(" AND CP.ACCE_OID_ACCE = ? ");
		parametros.add(acceso);
		consulta.append(" AND PO.SBAC_OID_SBAC = ? ");
		parametros.add(subacceso);
		consulta.append(" AND PMFC.PERD_OID_PERI =  ? ");
		parametros.add(periodo);
		consulta.append(" AND CP.OID_PERI = PMFC.PERD_OID_PERI ");
		consulta.append(" AND PMFC.OID_CABE = PMF.MFCA_OID_CABE ");
		consulta.append(" AND PMF.OFDE_OID_DETA_OFER = POD.OID_DETA_OFER ");
		consulta.append(" AND PO.OID_OFER = POD.OFER_OID_OFER ");


		BelcorpService bs = UtilidadesEJB.getBelcorpService();
		RecordSet resultado = null;
		String codigoError = null;
		try {
			resultado = bs.dbService.executePreparedQuery(consulta.toString(), 
				parametros);
		} catch (Exception e) {
            codigoError = CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS;
			UtilidadesLog.error(" obtenerDatosMatriz: Exception",e);
			this.logSql(" obtenerDatosMatriz. SQL: ",consulta.toString(),
				parametros);
            throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));
		}

		DTOFACMatriz dtoS = new DTOFACMatriz();
		dtoS.setCatalogo(new Long( ((BigDecimal)resultado.getValueAt(0,"VAR_CATALOGO")).longValue()) );
		dtoS.setPagina(new Integer( ((BigDecimal)resultado.getValueAt(0,"VAR_PAGINA")).intValue()) );
		
		UtilidadesLog.debug("*** Método obtenerDatosMatriz: Entrada ");
		//Con el registro obtenido se crea y se retorna un objeto DTOFACMatriz.
		return dtoS;			
	}*/



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

	private String convertirFecha(Date fecha) {
        UtilidadesLog.info("DAOFAC.convertirFecha(Date fecha): Entrada");
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		java.sql.Date fechaDesde = new java.sql.Date(fecha.getTime());
		String sFechaDesde = sdf.format(fechaDesde);                                                          
        UtilidadesLog.info("DAOFAC.convertirFecha(Date fecha): Salida");
		return sFechaDesde;
	}
  
  public DTOSalida obtenerNivel(DTOBelcorp dto) throws MareException{
    UtilidadesLog.info("DAOFAC.obtenerNivel(DTOBelcorp dto): Entrada");
    StringBuffer query = new StringBuffer();
    RecordSet rs = new RecordSet(); 
    DTOSalida dtos = new DTOSalida();
    BelcorpService bs = UtilidadesEJB.getBelcorpService();
    
    query.append(" select nivel.OID_NIVE_SEGM, nivel.VAL_DESC ");
    query.append(" from DTR_NIVEL_SEGME nivel ");
    query.append(" order by 2 ");
        
     try {
         rs = (RecordSet) bs.dbService.executeStaticQuery(query.toString());
        if(!rs.esVacio()){
            dtos.setResultado(rs);}
     }catch (Exception e) {
         throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS));
     }   
     UtilidadesLog.info("DAOFAC.obtenerNivel(DTOBelcorp dto): Salida");
     return dtos;   
  
  }
}
