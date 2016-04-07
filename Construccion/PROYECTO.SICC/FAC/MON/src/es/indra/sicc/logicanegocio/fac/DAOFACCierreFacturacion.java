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

import java.util.Vector;
import java.util.Date;
import java.util.ArrayList;

import es.indra.sicc.dtos.fac.DTOFACProcesoCierre;
import es.indra.sicc.dtos.fac.DTOFACCierreFacturacion;

import es.indra.sicc.logicanegocio.fac.ConstantesFAC;

import java.text.SimpleDateFormat;

public class DAOFACCierreFacturacion  {
	public DAOFACCierreFacturacion() {
	}


	public ArrayList obtenerProcesosCierre(Long pais, Long tipoCierre) throws MareException{
		UtilidadesLog.info("DAOFACCierreFacturacion.obtenerProcesosCierre(Long pais, Long tipoCierre): Entrada");
		Vector parametros = new Vector();
		// Se crea la consulta SQL
		StringBuffer consulta = new StringBuffer();
        
        // Cambio de la consulta INCIDENCIA 12953

        consulta.append(" SELECT ");
        consulta.append(" PC.OID_PROC_CIER OID, ");
        consulta.append(" PC.PAIS_OID_PAIS PAIS, ");
        consulta.append(" PC.TCIE_OID_TIPO_CIER TIPOCIERRE, ");
        consulta.append(" TRA.COD_PROC PROCESO, ");
        consulta.append(" PC.NUM_ORDE_EJEC NUMERO, ");
        consulta.append(" TRA.VAL_PROG_EJEC PROGRAMA, ");
        consulta.append(" PC.PRCI_OID_PROC_CIER PRECEDENCIA");
        consulta.append(" FROM  ");
        consulta.append(" FAC_PROCE_CIERR PC, ");
        consulta.append(" CRA_TRANS TRA ");
        consulta.append(" WHERE  ");
        consulta.append(" PC.PAIS_OID_PAIS = ? AND ");
        parametros.add(pais);
        consulta.append(" PC.TCIE_OID_TIPO_CIER = ? AND ");
		parametros.add(tipoCierre);
        consulta.append(" PC.TRAN_OID_TRAN = TRA.OID_TRAN ");
        consulta.append(" ORDER BY PRECEDENCIA ASC NULLS FIRST ");
	
		BelcorpService bs = UtilidadesEJB.getBelcorpService();
		RecordSet resultado = null;
		String codigoError = null;
		try {
			resultado = bs.dbService.executePreparedQuery(consulta.toString(), 
				parametros);
		} catch (Exception e) {
            codigoError = CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS;
			UtilidadesLog.error(" obtenerProcesosCierre: Exception",e);
			this.logSql(" obtenerProcesosCierre. SQL: ",consulta.toString(),
				parametros);
            throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));
		}

		/*
			Con cada registro obtenido de la consulta SQL se construye un 
			objeto DTOFACProcesoCierre, y se retorna la lista completa.
		*/
		
		ArrayList retorno = new ArrayList();
		DTOFACProcesoCierre dtoProcesoCierre = null;
		Object valProg = null;
		for(int i=0; i<resultado.getRowCount(); i++){

			dtoProcesoCierre = new DTOFACProcesoCierre();
			dtoProcesoCierre.setOid(new Long(((BigDecimal)resultado.getValueAt(i,"OID")).longValue()));
			dtoProcesoCierre.setOidPais(new Long(((BigDecimal)resultado.getValueAt(i,"PAIS")).longValue()));
			dtoProcesoCierre.setProceso(resultado.getValueAt(i,"PROCESO").toString());
			dtoProcesoCierre.setNumeroOrdenEjecucion(new Integer(((BigDecimal)resultado.getValueAt(i,"NUMERO")).intValue()));
			valProg = resultado.getValueAt(i,"PROGRAMA");
			if (valProg!=null){
				dtoProcesoCierre.setPrograma(resultado.getValueAt(i,"PROGRAMA").toString());
			}
			dtoProcesoCierre.setTipoCierre(new Long(((BigDecimal)resultado.getValueAt(i,"TIPOCIERRE")).longValue()));
            if (resultado.getValueAt(i,"PRECEDENCIA")!=null){
                dtoProcesoCierre.setOidProcesoPrecedencia(new Long(((BigDecimal)resultado.getValueAt(i,"PRECEDENCIA")).longValue()));
            }
			retorno.add(dtoProcesoCierre);
		}
						
		UtilidadesLog.info("DAOFACCierreFacturacion.obtenerProcesosCierre(Long pais, Long tipoCierre): Salida");
		return retorno;
	}


  /**
   * El orden de ejecucion de los procesos de cierre de region esta determinado por num_orde_ejec.
   */
	public ArrayList obtenerProcesosCierreRegion(Long pais, Long tipoCierre) throws MareException{
      UtilidadesLog.info("DAOFACCierreFacturacion.obtenerProcesosCierreRegion(Long pais, Long tipoCierre): Entrada");
      Vector parametros = new Vector();
      StringBuffer consulta = new StringBuffer();
      
      consulta.append(" SELECT ");
      consulta.append(" PC.OID_PROC_CIER OID, ");
      consulta.append(" PC.PAIS_OID_PAIS PAIS, ");
      consulta.append(" PC.TCIE_OID_TIPO_CIER TIPOCIERRE, ");
      consulta.append(" TRA.COD_PROC PROCESO, ");
      consulta.append(" PC.NUM_ORDE_EJEC NUMERO, ");
      consulta.append(" TRA.VAL_PROG_EJEC PROGRAMA, ");
      consulta.append(" PC.PRCI_OID_PROC_CIER PRECEDENCIA");
      consulta.append(" FROM  ");
      consulta.append(" FAC_PROCE_CIERR PC, ");
      consulta.append(" CRA_TRANS TRA ");
      consulta.append(" WHERE  ");
      consulta.append(" PC.PAIS_OID_PAIS = ? AND ");
      parametros.add(pais);
      consulta.append(" PC.TCIE_OID_TIPO_CIER = ? AND ");
      parametros.add(tipoCierre);
      consulta.append(" PC.TRAN_OID_TRAN = TRA.OID_TRAN ");
      consulta.append(" ORDER BY PC.NUM_ORDE_EJEC ASC ");
      
      BelcorpService bs = UtilidadesEJB.getBelcorpService();
      RecordSet resultado = null;
      String codigoError = null;
      try {
          resultado = bs.dbService.executePreparedQuery(consulta.toString(), parametros);
      } catch (Exception e) {
          codigoError = CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS;
          UtilidadesLog.error(" obtenerProcesosCierre: Exception",e);
          this.logSql(" obtenerProcesosCierre. SQL: ",consulta.toString(), parametros);
          throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));
      }
      
      /*
      Con cada registro obtenido de la consulta SQL se construye un 
      objeto DTOFACProcesoCierre, y se retorna la lista completa.
      */
      ArrayList retorno = new ArrayList();
      DTOFACProcesoCierre dtoProcesoCierre = null;
      Object valProg = null;
      for(int i=0; i<resultado.getRowCount(); i++){
          dtoProcesoCierre = new DTOFACProcesoCierre();
          dtoProcesoCierre.setOid(new Long(((BigDecimal)resultado.getValueAt(i,"OID")).longValue()));
          dtoProcesoCierre.setOidPais(new Long(((BigDecimal)resultado.getValueAt(i,"PAIS")).longValue()));
          dtoProcesoCierre.setProceso(resultado.getValueAt(i,"PROCESO").toString());
          dtoProcesoCierre.setNumeroOrdenEjecucion(new Integer(((BigDecimal)resultado.getValueAt(i,"NUMERO")).intValue()));
          valProg = resultado.getValueAt(i,"PROGRAMA");
          if (valProg!=null){
              dtoProcesoCierre.setPrograma(resultado.getValueAt(i,"PROGRAMA").toString());
          }
          dtoProcesoCierre.setTipoCierre(new Long(((BigDecimal)resultado.getValueAt(i,"TIPOCIERRE")).longValue()));
          if (resultado.getValueAt(i,"PRECEDENCIA")!=null){
              dtoProcesoCierre.setOidProcesoPrecedencia(new Long(((BigDecimal)resultado.getValueAt(i,"PRECEDENCIA")).longValue()));
          }
          retorno.add(dtoProcesoCierre);
      }
          
      UtilidadesLog.info("DAOFACCierreFacturacion.obtenerProcesosCierreRegion(Long pais, Long tipoCierre): Salida");
      return retorno;
	}


	public Integer obtenerNumeroControlCierres(DTOFACCierreFacturacion dtoe) throws MareException{
		UtilidadesLog.info("DAOFACCierreFacturacion.obtenerNumeroControlCierres(DTOFACCierreFacturacion dtoe): Entrada");
		Vector parametros = new Vector();
		// Se crea la consulta SQL
		StringBuffer consulta = new StringBuffer();
		// Cambiado Incidencia 11494
		if(dtoe.getCodigoTipoCierre().equals(ConstantesFAC.TIPO_CIERRE_PERIODO)){
			consulta.append(" SELECT COUNT(*)  ");
			consulta.append(" FROM FAC_CONTR_CIERR  ");	
			consulta.append(" WHERE  ");
			consulta.append(" PAIS_OID_PAIS = ? AND  ");
			parametros.add(dtoe.getOidPais());
			consulta.append(" PERD_OID_PERI = ?  ");			
			parametros.add(dtoe.getPeriodo());

			//Modificado por incidencia: BELC300011138
			consulta.append(" AND TCIE_OID_TIPO_CIER = ? ");
			parametros.add(dtoe.getTipoCierre());
		}else{
			// Cambiado Incidencia 11494		
			if(dtoe.getCodigoTipoCierre().equals(ConstantesFAC.TIPO_CIERRE_REGION)){
				consulta.append(" SELECT COUNT(*) ");
				consulta.append(" FROM FAC_CONTR_CIERR ");
				consulta.append(" WHERE ");
				consulta.append(" PAIS_OID_PAIS = ? AND ");
				parametros.add(dtoe.getOidPais());
				consulta.append(" ? IN (SELECT CP.MARC_OID_MARC ");
				parametros.add(dtoe.getMarca());
				consulta.append(" FROM CRA_PERIO CP, SEG_MARCA SM ");
				consulta.append(" WHERE CP.MARC_OID_MARC = SM.OID_MARC ) AND ");
				consulta.append(" ? IN (SELECT CP.CANA_OID_CANA ");
				parametros.add(dtoe.getCanal());
				consulta.append(" FROM CRA_PERIO CP, SEG_CANAL SC ");
				consulta.append(" WHERE CP.CANA_OID_CANA = SC.OID_CANA )  ");
				
				String oids = this.convertirArrayToString(dtoe.getRegiones().getOids());
				consulta.append(" AND  ZORG_OID_REGI  IN ( " + oids + " ) ");
				for (int i = 0; i < dtoe.getRegiones().getOids().length; i++){
					if(dtoe.getRegiones().getOids()[i]!=null){
						parametros.add(dtoe.getRegiones().getOids()[i]);
					}
				}				

				consulta.append(" AND TCIE_OID_TIPO_CIER = ? ");
				parametros.add(dtoe.getTipoCierre());
        consulta.append(" AND perd_oid_peri = ? ");
        parametros.add(dtoe.getPeriodo());
			}else{
				// Cambiado Incidencia 11494			
				if(dtoe.getCodigoTipoCierre().equals(ConstantesFAC.TIPO_CIERRE_ZONA)){
					consulta.append(" SELECT COUNT(*) ");
					consulta.append(" FROM FAC_CONTR_CIERR ");
					consulta.append(" WHERE ");
					consulta.append(" PAIS_OID_PAIS = ? AND ");
					parametros.add(dtoe.getOidPais());
					consulta.append(" ? IN (SELECT CP.MARC_OID_MARC ");
					parametros.add(dtoe.getMarca());
					consulta.append(" FROM CRA_PERIO CP, SEG_MARCA SM ");
					consulta.append(" WHERE CP.MARC_OID_MARC = SM.OID_MARC ) AND ");
					consulta.append(" ? IN (SELECT CP.CANA_OID_CANA ");
					parametros.add(dtoe.getCanal());
					consulta.append(" FROM CRA_PERIO CP, SEG_CANAL SC ");
					consulta.append(" WHERE CP.CANA_OID_CANA = SC.OID_CANA ) AND ");

					String oids = this.convertirArrayToString(dtoe.getZonas().getOids());
					consulta.append(" ZZON_OID_ZONA IN ( " + oids + " ) ");
					for (int i = 0; i < dtoe.getZonas().getOids().length; i++){
						if (dtoe.getZonas().getOids()[i] != null) {
							parametros.add(dtoe.getZonas().getOids()[i]);
						}
					}				

					consulta.append(" AND TCIE_OID_TIPO_CIER = ? ");
					parametros.add(dtoe.getTipoCierre());
          consulta.append(" AND perd_oid_peri = ? ");
          parametros.add(dtoe.getPeriodo());
				}
			}
		}
	
		BelcorpService bs = UtilidadesEJB.getBelcorpService();
		RecordSet resultado = null;
		String codigoError = null;
		try {
			resultado = bs.dbService.executePreparedQuery(consulta.toString(), 
				parametros);
		} catch (Exception e) {
            codigoError = CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS;
			UtilidadesLog.error(" obtenerNumeroControlCierres: Exception",e);
			this.logSql(" obtenerNumeroControlCierres. SQL: ",consulta.toString(),
				parametros);
            throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));
		}
        
		Integer numero = new Integer(((BigDecimal)resultado.getValueAt(0,0)).intValue());
		if(numero == null){
            numero = new Integer(0);
        }
		UtilidadesLog.info("DAOFACCierreFacturacion.obtenerNumeroControlCierres(DTOFACCierreFacturacion dtoe): Salida");
		return numero;
	}

  
  /**
   * Método creado para el cambio MAE-014 que incluye un CU nuevo para reasignar
   * estatus en lote a los clientes que pasaron pedido fuera de fecha (despues
   * del cierre de region). Ver Inc. BELC300024259
   * @throws es.indra.mare.common.exception.MareException
   * @return ArrayList con los oids recuperados
   * @param dtoe
   */
  public ArrayList obtenerControlCierreRegionPorPeriodo(DTOFACCierreFacturacion dtoe) throws MareException {
      UtilidadesLog.info("DAOFACCierreFacturacion.obtenerControlCierreRegionPorPeriodo(DTOFACCierreFacturacion dtoe): Entrada");
      UtilidadesLog.debug(" parametros en dtoe_ " + dtoe);
      StringBuffer consulta = new StringBuffer();
      RecordSet resultado = null;
      ArrayList retorno = new ArrayList();
      
      consulta.append(" SELECT DISTINCT ZORG_OID_REGI ");
      consulta.append("   FROM FAC_CONTR_CIERR cierre, ");
      consulta.append("        ZON_REGIO reg ");
      consulta.append("  WHERE cierre.PAIS_OID_PAIS = " + dtoe.getOidPais() );
      consulta.append("        AND cierre.TCIE_OID_TIPO_CIER = " + dtoe.getTipoCierre() );  // Cierre por Region es oid '1' 
      consulta.append("        AND cierre.PERD_OID_PERI = " + dtoe.getPeriodo() );
      consulta.append("        AND cierre.ZORG_OID_REGI = reg.OID_REGI ");
      consulta.append("        AND reg.MARC_OID_MARC = " + dtoe.getMarca() );
      consulta.append("        AND reg.CANA_OID_CANA = " + dtoe.getCanal() );
      
      try {
          resultado = BelcorpService.getInstance().dbService.executeStaticQuery(consulta.toString());
      } catch (Exception e) {
          UtilidadesLog.error(" Exception al ejecutar consulta en BBDD: " + e.getMessage());
          throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS));
      }
      UtilidadesLog.debug("   resultado_ " + resultado);
      
		  int cantRegistros = resultado.getRowCount();
      Long oidRegion = null;
		  
      for (int i = 0; i < cantRegistros; i++) {
          oidRegion = new Long(((BigDecimal)resultado.getValueAt(i,"ZORG_OID_REGI")).longValue());
			    retorno.add(oidRegion);
		  }
      UtilidadesLog.debug("   retorno_ " + retorno);
      UtilidadesLog.info("DAOFACCierreFacturacion.obtenerControlCierreRegionPorPeriodo(DTOFACCierreFacturacion dtoe): Salida");
      return retorno;
  }

	private void logSql(String metodo, String sql, Vector params){
        UtilidadesLog.info("DAOFACCierreFacturacion.logSql(String metodo, String sql, Vector params): Entrada");
		UtilidadesLog.debug(metodo + sql);
		if (params!=null && params.size()>0) {
			String sParams="";
			for (int i=0; i<params.size();i++){
				sParams+="param "+ (i+1) + ": " + params.elementAt(i) + ", ";
			}
			UtilidadesLog.debug(metodo + sParams);
		}
        UtilidadesLog.info("DAOFACCierreFacturacion.logSql(String metodo, String sql, Vector params): Salida");
	}	

	private String convertirArrayToString(Long[] oids){
        UtilidadesLog.info("DAOFACCierreFacturacion.convertirArrayToString(Long[] oids): Entrada");
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
			return "";
		}
        UtilidadesLog.info("DAOFACCierreFacturacion.convertirArrayToString(Long[] oids): Salida");			
		return retorno;
	}

	private String convertirFecha(Date fecha) {
        UtilidadesLog.info("DAOFACCierreFacturacion.convertirFecha(Date fecha): Entrada");
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		java.sql.Date fechaDesde = new java.sql.Date(fecha.getTime());
		String sFechaDesde = sdf.format(fechaDesde);                                                          
        UtilidadesLog.info("DAOFACCierreFacturacion.convertirFecha(Date fecha): Salida");
		return sFechaDesde;
	}	
 
    // sapaza -- PER-SiCC-2011-0594 -- 18/08/2011      
    public String obtenerValorParametroPais(Long oidPais, String codigoModulo, String codigoParametro) throws MareException {
        UtilidadesLog.info("DAOFACCierreFacturacion.obtenerValorParametroPais(Long oidPais, String codigoModulo, String codigoParametro): Entrada");
                      
        StringBuffer consulta = new StringBuffer();

        consulta.append(" SELECT pp.val_para  ");
        consulta.append("   FROM bas_param_pais pp, bas_pais bp, seg_pais sp  ");
        consulta.append("  WHERE sp.cod_pais = bp.cod_pais  ");
        consulta.append("    AND sp.oid_pais =  " + oidPais.toString());
        consulta.append("    AND pp.cod_pais = bp.cod_pais  ");
        consulta.append("    AND pp.cod_sist = '" + codigoModulo + "'");
        consulta.append("    AND pp.cod_para = '" + codigoParametro + "'");
        consulta.append("    AND pp.ind_acti =  '1' ");
        
        BelcorpService bs = BelcorpService.getInstance();
        RecordSet rs = null;

        try {        
            rs = bs.dbService.executeStaticQuery(consulta.toString());
        } catch (Exception e) {
            UtilidadesLog.error(" obtenerIndicadorEquivalencias: Exception", e);
            throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS));
        } 

        if (rs != null && !rs.esVacio()) {                 
            return (String)rs.getValueAt(0,0);        
        }

        UtilidadesLog.info("DAOFACCierreFacturacion.obtenerValorParametroPais(Long oidPais, String codigoModulo, String codigoParametro): Salida");

        return null;
    }
    
}