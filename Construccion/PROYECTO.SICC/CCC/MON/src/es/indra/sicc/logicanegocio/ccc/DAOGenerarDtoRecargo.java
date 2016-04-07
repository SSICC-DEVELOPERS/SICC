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
package es.indra.sicc.logicanegocio.ccc;

import es.indra.mare.common.exception.MareException;
import es.indra.mare.common.mii.services.jdbcservice.RecordSet;
import es.indra.sicc.cmn.negocio.ConstantesCMN;
import es.indra.sicc.dtos.ccc.DTOBuscarCuotasDtoRecargo;
import es.indra.sicc.dtos.ccc.DTOBuscarTipoSolicitudProceso;
import es.indra.sicc.logicanegocio.ccc.CCCConstantes;
import es.indra.sicc.util.BelcorpService;
import es.indra.sicc.util.CodigosError;
import es.indra.sicc.util.DTOSalida;
import es.indra.sicc.util.UtilidadesEJB;
import es.indra.sicc.util.UtilidadesError;
import es.indra.sicc.util.UtilidadesLog;
import java.math.BigDecimal;

import java.text.SimpleDateFormat;

import java.util.Vector;


public class DAOGenerarDtoRecargo {
    public DAOGenerarDtoRecargo() {
    }

    public DTOSalida buscarCuotasDtoRecargo(DTOBuscarCuotasDtoRecargo dtoE)
        throws MareException {
        
        UtilidadesLog.info("DAOGenerarDtoRecargo.buscarCuotasDtoRecargo(DTOBuscarCuotasDtoRecargo dtoE): Entrada");
        
        UtilidadesLog.debug("dtoE: " + dtoE);
                
        //vbongiov -- SiCC 20080760 -- 30/09/2008
        //dtoE.setCodigoSubproceso("1");
		
		StringBuffer consulta = new StringBuffer();
		Vector parametros = new Vector();
		boolean existe1 = false;
		boolean existe2 = false;
		Vector seleccion1 = new Vector();
		Vector seleccion2 = new Vector();	
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		if(dtoE.getSeleccionados()!=null) {
			for(int i = 0;i < dtoE.getSeleccionados().length;i++){
				if(dtoE.getSeleccionados()[i].getEntidad()!=null){
					if(dtoE.getSeleccionados()[i].getEntidad().intValue() == 1){
						seleccion1.add(dtoE.getSeleccionados()[i].getOid());
						existe1 = true;
					}
					if(dtoE.getSeleccionados()[i].getEntidad().intValue() == 2){
						seleccion2.add(dtoE.getSeleccionados()[i].getOid());			
						existe2 = true;
					}	
				}
			}
		}
		consulta.append(" (SELECT DISTINCT A.oid_movi_cc as oid, ");
		consulta.append(" A.clie_oid_clie as oidCliente, ");
		consulta.append(" A.ticl_oid_tipo_clie as oidTipoCliente, ");	
		consulta.append(" A.sbac_oid_sbac as oidSubacceso, ");
		consulta.append(" A.num_iden_cuot as numeroCuota, ");
		consulta.append(" A.val_ejer_cuot as ejercicioCuota, "); 
		consulta.append(" A.num_orde_cuot as ordenCuota, ");
		consulta.append(" A.val_ulti_nume_hist as numeroHistoria, ");
		consulta.append(" A.val_refe_nume_docu_exte as referenciaExterna, ");
		consulta.append(" A.fec_docu as fechaDocumento, ");
		consulta.append(" A.fec_venc as fechaVencimiento, ");
		consulta.append(" A.fec_ulti_movi as fechaLiquidacion, ");
    
    // splatas - DBLG500000606 - 01/06/2006
    //se modif. por inc: DBLG500000771
		//consulta.append(" trunc(A.fec_venc - A.fec_ulti_movi) as diasCalculados, ");
    
    consulta.append(" ABS(TRUNC(A.fec_venc - A.fec_ulti_movi)) as diasCalculados, ");
    
		consulta.append(" A.imp_movi as importeNominal, ");
		consulta.append(" A.imp_movi_cuen as importePago, ");
        //modificado por incidencia 19190
        consulta.append(" DECODE( ? , ");//dtoE.codigoSubproceso
		parametros.add(dtoE.getCodigoSubproceso());
		consulta.append(" ? , ");//CCCConstantes.SUBPROCESO_DESCUENTO
	  parametros.add(CCCConstantes.SUBPROCESO_DESCUENTO);		
    consulta.append(" ((A.imp_movi_cuen * ? * (A.fec_venc - ");//dtoE.tipoInteres
	    parametros.add(dtoE.getTipoInteres());			
		consulta.append(" ? - A.fec_ulti_movi)) ");//dtoE.diasCadencia 
	    parametros.add(dtoE.getDiasCadencia());			
		consulta.append(" / 36000) + ? , ");//dtoE.importeFijo *
	    parametros.add(dtoE.getImporteFijo());			
		//consulta.append(" ((A.imp_movi_cuen * ? * (A.fec_venc + ");//dtoE.tipoInteres
        consulta.append(" ((A.imp_movi_cuen * ? * (A.fec_ulti_movi + ");//dtoE.tipoInteres
	    parametros.add(dtoE.getTipoInteres());			
		consulta.append(" ? - A.fec_venc)) / 36000) ");//dtoE.diasCadencia *
	    parametros.add(dtoE.getDiasCadencia());				
		consulta.append(" + ?) as importeDto, ");//dtoE.importeFijo
	    parametros.add(dtoE.getImporteFijo());			
		consulta.append(" 1 as entidad ");

		
		consulta.append(" FROM ");
		consulta.append(" ccc_movim_cuent_corri A, ");
		consulta.append(" seg_subac B, "); 
		consulta.append(" seg_acces C "); 

		consulta.append(" WHERE ");
		consulta.append(" (A.soci_oid_soci = ? AND ");//dtoE.oidEmpresa
	    parametros.add(dtoE.getOidEmpresa());	
		if( dtoE.getOidClienteDesde()!=null && dtoE.getOidClienteHasta()!= null){

			consulta.append(" A.clie_oid_clie BETWEEN ? AND ");//dtoE.oidClienteDesde
		    parametros.add(dtoE.getOidClienteDesde());	
			consulta.append(" ? AND ");//dtoE.oidClienteHasta
			parametros.add(dtoE.getOidClienteHasta());			
			
		}
		if(dtoE.getFechaDocDesde()!= null){
			java.sql.Date fechaDocDesde = new java.sql.Date(dtoE.getFechaDocDesde().getTime());
			String sFechaDocDesde = sdf.format(fechaDocDesde);
			consulta.append(" A.fec_docu >= TO_DATE( ? ,'YYYY-MM-DD')  AND ");//dtoE.fecDocDesde
			parametros.add(sFechaDocDesde);	
		}
		if(dtoE.getFechaDocHasta()!= null){	
			java.sql.Date fechaDocHasta = new java.sql.Date(dtoE.getFechaDocHasta().getTime());
			String sFechaDocHasta= sdf.format(fechaDocHasta);
			consulta.append(" A.fec_docu <= TO_DATE( ? ,'YYYY-MM-DD')  AND ");//dtoE.fecDocHasta
			parametros.add(sFechaDocHasta);				
		}
		if(dtoE.getFechaVtoDesde()!= null){		
			java.sql.Date fechaVtoDesde = new java.sql.Date(dtoE.getFechaVtoDesde().getTime());
			String sFechaVtoDesde= sdf.format(fechaVtoDesde);
			consulta.append(" A.fec_venc >= TO_DATE( ? ,'YYYY-MM-DD') AND ");//dtoE.fecVtoDesde
			parametros.add(sFechaVtoDesde);				
		}
		if(dtoE.getFechaVtoHasta()!= null){		
			java.sql.Date fechaVtoHasta = new java.sql.Date(dtoE.getFechaVtoHasta().getTime());
			String sFechaVtoHasta= sdf.format(fechaVtoHasta);
			consulta.append(" A.fec_venc <= TO_DATE( ? ,'YYYY-MM-DD') AND ");//dtoE.fecVtoHasta
			parametros.add(sFechaVtoHasta);				
		}
		if(dtoE.getOidSubacceso()!= null){		
			consulta.append(" A.sbac_oid_sbac = ? AND ");//dtoE.oidSubacceso
			parametros.add(dtoE.getOidSubacceso());				
		}
		consulta.append(" B.oid_sbac = A.sbac_oid_sbac AND ");
		if(dtoE.getOidAcceso()!= null){				
			consulta.append(" B.acce_oid_acce = ? AND ");//dtoE.oidAcceso 
			parametros.add(dtoE.getOidAcceso());				
		}
		consulta.append(" C.oid_acce = B.acce_oid_acce AND ");
		if(dtoE.getOidCanal()!= null){				
			consulta.append(" C.cana_oid_cana = ? AND ");//dtoE.oidCanal
			parametros.add(dtoE.getOidCanal());				
		}	
		consulta.append(" (A.ind_dto_carg_apli IS NULL OR A.ind_dto_carg_apli <> ? )AND");//ConstantesCMN.VAL_TRUE
		parametros.add(ConstantesCMN.VAL_TRUE);			
		//consulta.append(" NVL(A.imp_pago, 0) <> 0 AND ");
        consulta.append(" NVL(A.imp_paga, 0) <> 0 AND ");
		consulta.append(" A.masi_oid_marc_situ IN ( ");
		
		consulta.append(" SELECT E.masi_oid_marc_sali ");
		
		consulta.append(" FROM ");
		consulta.append(" ccc_tipo_abono_subpr D, ");
		consulta.append(" ccc_marca_tipo_abono E ");

		consulta.append(" WHERE ");
		consulta.append(" D.subp_oid_subp = ? AND ");//dtoE.oidSubproceso
		parametros.add(dtoE.getOidSubproceso());
		
		consulta.append(" E.tasp_oid_tipo_abon_subp = D.oid_tipo_abon_subp AND ");
		consulta.append(" E.IND_ENTR_SALI LIKE 'E') AND ");

		if( dtoE.getCodigoSubproceso().equals(CCCConstantes.SUBPROCESO_DESCUENTO)){
			consulta.append(" A.fec_ulti_movi BETWEEN A.fec_venc - ? ");//dtoE.diasCorte
			parametros.add(dtoE.getDiasCorte());			
			consulta.append(" AND A.fec_venc - ? ");//dtoE.diasCadencia
			parametros.add(dtoE.getDiasCadencia());			
		}else{
			consulta.append(" A.fec_ulti_movi BETWEEN A.fec_venc + ? ");//dtoE.diasCadencia
			parametros.add(dtoE.getDiasCadencia());					
			consulta.append(" AND A.fec_venc + ? ");//dtoE.diasCorte
			parametros.add(dtoE.getDiasCorte());				
		} 
		consulta.append(" ) ");
		if(existe1 == true){
			consulta.append(" OR ");
			consulta.append(" (A.oid_movi_cc IN ( ");
			for(int j = 0; j < (seleccion1.size() - 1);j++){
				consulta.append(" ?, ");			
				parametros.add(seleccion1.get(j));	
			}
			consulta.append(" ? ");	
			parametros.add(seleccion1.get(seleccion1.size() - 1));
			consulta.append(" )AND ");//(los oids de dtoE.seleccionados que tengan dtoE.seleccionados(i).entidad == 1)
			consulta.append(" B.oid_sbac = A.sbac_oid_sbac AND "); 
			consulta.append(" C.oid_acce = B.acce_oid_acce) ");
		}
		consulta.append(" ) ");
		
		consulta.append(" UNION ");

		consulta.append(" (SELECT ");
		consulta.append(" DISTINCT A.oid_hist_movi as oid, ");
		consulta.append(" A.clie_oid_clie as oidCliente, ");
		consulta.append(" A.ticl_oid_tipo_clie as oidTipoCliente, ");
		consulta.append(" B.sbac_oid_sbac as oidSubacceso, ");
		consulta.append(" B.num_iden_cuot as numeroCuota, ");
		consulta.append(" B.val_ejer_cuot as ejercicioCuota, "); 
		consulta.append(" B.num_orde_cuot as ordenCuota, ");
		consulta.append(" A.num_hist as numeroHistoria, ");
		consulta.append(" A.val_refe_nume_docu_exte as referenciaExterna, ");
		consulta.append(" A.fec_docu as fechaDocumento, ");
		consulta.append(" A.fec_venc as fechaVencimiento, ");
		consulta.append(" A.fec_movi as fechaLiquidacion, ");
		
    // splatas - DBLG500000606 - 01/06/2006
    //consulta.append(" trunc(A.fec_venc - A.fec_movi) as diasCalculados, ");
    //se modif. por inc: DBLG500000771
    consulta.append(" ABS(TRUNC(A.fec_venc - A.fec_movi)) as diasCalculados, ");
    
		consulta.append(" A.imp as importeNominal, ");
		consulta.append(" A.imp_movi as importePago, ");
        //modificado por incidencia 19190
		consulta.append(" DECODE( ? , ");//dtoE.codigoSubproceso
		parametros.add(dtoE.getOidSubproceso());		
		consulta.append(" ? , ");//CCCConstantes.SUBPROCESO_DESCUENTO
		parametros.add(CCCConstantes.SUBPROCESO_DESCUENTO);				
		consulta.append(" ((A.imp_movi * ? * ");//dtoE.tipoInteres
		parametros.add(dtoE.getTipoInteres());		
		consulta.append(" (A.fec_venc - ? - ");//dtoE.diasCadencia
		parametros.add(dtoE.getDiasCadencia());		
		consulta.append(" A.fec_movi)) / 36000) + ? , ");//dtoE.importeFijo *
		parametros.add(dtoE.getImporteFijo());		
		consulta.append(" ((A.imp_movi * ? * ");//dtoE.tipoInteres
		parametros.add(dtoE.getTipoInteres());
		//consulta.append(" (A.fec_venc + ? - ");//dtoE.diasCadencia
        consulta.append(" (A.fec_movi + ? - ");//dtoE.diasCadencia
		parametros.add(dtoE.getDiasCadencia());		
		consulta.append(" A.fec_venc)) / 36000) + ? ) as importeDto, ");//dtoE.importeFijo
		parametros.add(dtoE.getImporteFijo());		
		consulta.append(" 2 as entidad ");

		consulta.append(" FROM ");
		consulta.append(" ccc_histo_movim_cc A, ");
		consulta.append(" ccc_movim_cuent_corri B, ");
		consulta.append(" seg_subac C, ");
		consulta.append(" seg_acces D ");

		consulta.append(" WHERE ");
		consulta.append(" (B.oid_movi_cc = A.mvcc_oid_movi_cc AND ");
		consulta.append(" B.soci_oid_soci = ? AND ");//dtoE.oidEmpresa
		parametros.add(dtoE.getOidEmpresa());
		if( dtoE.getOidClienteDesde()!=null && dtoE.getOidClienteHasta()!= null){

			consulta.append(" A.clie_oid_clie BETWEEN ? AND ");//dtoE.oidClienteDesde
		    parametros.add(dtoE.getOidClienteDesde());	
			consulta.append(" ? AND ");//dtoE.oidClienteHasta
			parametros.add(dtoE.getOidClienteHasta());			
			
		}
		if(dtoE.getFechaDocDesde()!= null){
			java.sql.Date fechaDocDesde2 = new java.sql.Date(dtoE.getFechaDocDesde().getTime());
			String sFechaDocDesde2 = sdf.format(fechaDocDesde2);
			consulta.append(" A.fec_docu >= TO_DATE( ? ,'YYYY-MM-DD')  AND ");//dtoE.fecDocDesde
			parametros.add(sFechaDocDesde2);	
		}
		if(dtoE.getFechaDocHasta()!= null){	
			java.sql.Date fechaDocHasta2 = new java.sql.Date(dtoE.getFechaDocHasta().getTime());
			String sFechaDocHasta2 = sdf.format(fechaDocHasta2);
			consulta.append(" A.fec_docu <= TO_DATE( ? ,'YYYY-MM-DD')  AND ");//dtoE.fecDocHasta
			parametros.add(sFechaDocHasta2);				
		}
		if(dtoE.getFechaVtoDesde()!= null){		
			java.sql.Date fechaVtoDesde2 = new java.sql.Date(dtoE.getFechaVtoDesde().getTime());
			String sFechaVtoDesde2 = sdf.format(fechaVtoDesde2);
			consulta.append(" A.fec_venc >= TO_DATE( ? ,'YYYY-MM-DD') AND ");//dtoE.fecVtoDesde
			parametros.add(sFechaVtoDesde2);				
		}
		if(dtoE.getFechaVtoHasta()!= null){	
			java.sql.Date fechaVtoHasta2 = new java.sql.Date(dtoE.getFechaVtoHasta().getTime());
			String sFechaVtoHasta2 = sdf.format(fechaVtoHasta2);
			consulta.append(" A.fec_venc <= TO_DATE( ? ,'YYYY-MM-DD') AND ");//dtoE.fecVtoHasta
			parametros.add(sFechaVtoHasta2);				
		}
		if(dtoE.getOidSubacceso()!= null){
			consulta.append(" B.sbac_oid_sbac = ? AND ");//dtoE.oidSubacceso
			parametros.add(dtoE.getOidSubacceso());		
		}
		consulta.append(" C.oid_sbac = B.sbac_oid_sbac AND ");
		if(dtoE.getOidAcceso()!=null){
			consulta.append(" C.acce_oid_acce = ? AND ");
			parametros.add(dtoE.getOidAcceso());
		}
		consulta.append(" D.oid_acce = C.acce_oid_acce AND ");
		if(dtoE.getOidCanal()!=null){
			consulta.append(" D.cana_oid_cana = ? AND ");
			parametros.add(dtoE.getOidCanal());
		}
                
                //vbongiov -- SiCC 20080760 -- 30/09/2008
                //consulta.append(" A.ind_desc_carg_apli <> ? AND ");//ConstantesCMN.VAL_TRUE        
                consulta.append(" (A.ind_desc_carg_apli IS NULL OR A.ind_desc_carg_apli <> ? )AND");//ConstantesCMN.VAL_TRUE
                
		parametros.add(ConstantesCMN.VAL_TRUE);
		//consulta.append(" NVL(A.imp_pago, 0) <> 0 AND ");
        consulta.append(" NVL(A.imp_paga, 0) <> 0 AND ");
		consulta.append(" A.masi_oid_marc_situ IN ( ");
		
		consulta.append(" SELECT F.masi_oid_marc_sali ");
		
		consulta.append(" FROM ");
		consulta.append(" ccc_tipo_abono_subpr E, ");
		consulta.append(" ccc_marca_tipo_abono F ");
		consulta.append(" WHERE ");
		consulta.append(" E.subp_oid_subp =  ? AND ");//dtoE.oidSubproceso 
		parametros.add(dtoE.getOidSubproceso());				
		consulta.append(" F.tasp_oid_tipo_abon_subp = E.oid_tipo_abon_subp AND ");
		consulta.append(" F.IND_ENTR_SALI LIKE 'E') AND ");

		if ( dtoE.getCodigoSubproceso().equals(CCCConstantes.SUBPROCESO_DESCUENTO)) {
			consulta.append(" A.fec_movi BETWEEN A.fec_venc - ? ");//dtoE.diasCorte
			parametros.add(dtoE.getDiasCorte());
			consulta.append(" AND A.fec_venc - ? ");//dtoE.diasCadencia
			parametros.add(dtoE.getDiasCadencia());
		} else {
			consulta.append(" A.fec_movi BETWEEN A.fec_venc + ? ");//dtoE.diasCadencia
			parametros.add(dtoE.getDiasCadencia());
			consulta.append(" AND A.fec_venc + ? ");//dtoE.diasCorte
			parametros.add(dtoE.getDiasCorte());
		}
		
		consulta.append(" ) ");

		if (existe2 == true) {
			consulta.append(" OR ");
			consulta.append(" (A.oid_hist_movi IN ( ");//(los oids de dtoE.seleccionados que tengan dtoE.seleccionados(i).entidad == 2) AND 
			for(int k = 0; k < (seleccion2.size() - 1);k++){
				consulta.append(" ?, ");		
				parametros.add(seleccion2.get(k));					
			}
			consulta.append(" ? ");	
			parametros.add(seleccion2.get(seleccion2.size() - 1));			
			consulta.append(" ) AND ");
			consulta.append(" B.oid_movi_cc = A.mvcc_oid_movi_cc AND ");
			consulta.append(" C.oid_sbac = B.sbac_oid_sbac AND ");
			consulta.append(" D.oid_acce = C.acce_oid_acce) ");
		}
		consulta.append(" ) ");

		String codigoError = null;
        BelcorpService bs = UtilidadesEJB.getBelcorpService();
		RecordSet resultado = new RecordSet();
		
        try {
            resultado = bs.dbService.executePreparedQuery(consulta.toString(),
                    parametros);
		UtilidadesLog.debug("*** consulta = "+consulta);
		UtilidadesLog.debug("*** parametros = "+parametros);
		UtilidadesLog.debug("*** resultado = "+resultado);
        } catch (Exception e) {
            codigoError = CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS;
            this.logError("buscarCuotasDtoRecargo: Exception", e);
            this.logSql("buscarCuotasDtoRecargo. SQL: ", consulta.toString(),
                parametros);
            throw new MareException(e,
                UtilidadesError.armarCodigoError(codigoError));
        }
        if (resultado.esVacio()) {
			UtilidadesLog.debug("buscarCuotasDtoRecargo: no hay datos ");				
            codigoError = CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE;
            throw new MareException(new Exception(),
                UtilidadesError.armarCodigoError(codigoError));
        }
		DTOSalida salida = new DTOSalida();
		salida.setResultado(resultado);

        UtilidadesLog.info("DAOGenerarDtoRecargo.buscarCuotasDtoRecargo(DTOBuscarCuotasDtoRecargo dtoE): Salida");		
        return salida;
    }

	public void actualizarCuotasDtoRecargo(RecordSet resultado) throws MareException{
	
        UtilidadesLog.info("DAOGenerarDtoRecargo.actualizarCuotasDtoRecargo(RecordSet resultado): Entrada");

		StringBuffer consulta1 = new StringBuffer();
		Vector parametros1 = new Vector();
		StringBuffer consulta2 = new StringBuffer();
		Vector parametros2 = new Vector();				
		Vector seleccion1 = new Vector();
		Vector seleccion2 = new Vector();
        UtilidadesLog.debug("ENTRADA:RecordSet resultado = "+resultado);
		//Obtenemos oids de resultado que tengan resultado(i).entidad == 1 y
		//oids de resultado que tengan resultado(i).entidad == 1 y
		for (int i=0; i < resultado.getRowCount(); i++) {
            UtilidadesLog.debug("antes if, vuelta nº: "+i);
            if((new Integer(((BigDecimal)resultado.getValueAt(i,"ENTIDAD")).intValue())).intValue()==1){
                UtilidadesLog.debug("dentro if");
				seleccion1.add(new Long(((BigDecimal)resultado.getValueAt(i,"OID")).longValue()));
				
			}
			UtilidadesLog.debug("Seleccion1 = "+seleccion1);
			if((new Integer(((BigDecimal)resultado.getValueAt(i,"ENTIDAD")).intValue())).intValue()==2){
                UtilidadesLog.debug("dentro segundo if");
				seleccion2.add(new Long(((BigDecimal)resultado.getValueAt(i,"OID")).longValue()));				
			}			
			UtilidadesLog.debug("Seleccion2 = " + seleccion2);
		}

		BelcorpService bs = null;
		String codigoError = null;
        UtilidadesLog.debug("Seleccion1.size() = "+seleccion1.size());
        UtilidadesLog.debug("Seleccion2.size() = "+seleccion2.size());
        //Primera consulta. Solo la realizamos si hay almenos un elemento
		if(seleccion1.size()>0) {
			consulta1.append(" UPDATE ccc_movim_cuent_corri ");
			consulta1.append(" SET ind_dto_carg_apli = ? ");//ConstantesCMN.VAL_TRUE 
			parametros1.add(ConstantesCMN.VAL_TRUE);
			consulta1.append(" WHERE oid_movi_cc IN ( ");//oids de resultado que tengan resultado(i).entidad == 1) 
			for(int j = 0; j < seleccion1.size();j++){
				consulta1.append(" ?, ");		
				parametros1.add(seleccion1.get(j));					
			}
			// Borramos la última coma 
			consulta1.deleteCharAt(consulta1.length()-2);
			consulta1.append(" )");
            UtilidadesLog.debug("consulta 1 = "+consulta1);
			bs = UtilidadesEJB.getBelcorpService();
			try{
				bs.dbService.executePreparedUpdate(consulta1.toString(),
					parametros1);
			} catch (Exception e) {
				codigoError = CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS;
				UtilidadesLog.error("actualizarCuotasDtoRecargo: Exception", e);
				this.logSql("actualizarCuotasDtoRecargo. SQL: ",
					consulta1.toString(), parametros1);
				throw new MareException(e,
					UtilidadesError.armarCodigoError(codigoError));
            }
		}

		//Segunda consulta. Solo la realizamos si hay almenos un elemento
		if(seleccion2.size()>0) {
			consulta2.append(" UPDATE ccc_histo_movim_cc ");
			consulta2.append(" SET ind_desc_carg_apli = ? ");//ConstantesCMN.VAL_TRUE 
			parametros2.add(ConstantesCMN.VAL_TRUE);		
			consulta2.append(" WHERE oid_hist_movi IN ( ");//oids de resultado que tengan resultado(i).entidad == 1) 
			for(int j = 0; j < seleccion2.size(); j++){
				consulta2.append(" ?, ");		
				parametros2.add(seleccion2.get(j));					
			}
			// Borramos la última coma
			consulta2.deleteCharAt(consulta2.length()-2);
			consulta2.append(" )");
            UtilidadesLog.debug("consulta 2 = "+consulta2);
			bs = UtilidadesEJB.getBelcorpService();
			try {
				bs.dbService.executePreparedUpdate(consulta2.toString(),
					parametros2);
			} catch (Exception e) {
				codigoError = CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS;
				UtilidadesLog.error("actualizarCuotasDtoRecargo: Exception", e);
				this.logSql("actualizarCuotasDtoRecargo. SQL: ",
					consulta1.toString(), parametros2);
				throw new MareException(e,
					UtilidadesError.armarCodigoError(codigoError));
            }
		}		
        UtilidadesLog.info("DAOGenerarDtoRecargo.actualizarCuotasDtoRecargo(RecordSet resultado): Salida");
	}
    public DTOSalida obtenerTipoSolicitudProceso(
        DTOBuscarTipoSolicitudProceso dto) throws MareException {
        
        UtilidadesLog.info("DAOGenerarDtoRecargo.obtenerTipoSolicitudProceso(DTOBuscarTipoSolicitudProceso dto): Entrada");

        DTOSalida resultado = new DTOSalida();
        RecordSet rs = null;
        Vector parametros = new Vector();
        StringBuffer consulta = new StringBuffer();

        consulta.append(" SELECT  ");
        consulta.append(" t.MARC_OID_MARC as oidMarca, ");
        consulta.append(" tacce.CANA_OID_CANA as oidCanal, "); //Incidencia 12191
        consulta.append(" t.ACCE_OID_ACCE as oidAcceso, ");
        consulta.append(" t.SBAC_OID_SBAC as oidSubacceso, ");
        consulta.append(" tproc.TSPA_OID_TIPO_SOLI_PAIS as oidTipoSolicitudPais, ");
        consulta.append(" tproc.TPOS_OID_TIPO_POSI as oidTipoPosicion, ");
        consulta.append(" tproc.STPO_OID_SUBT_POSI as oidSubtipoPosicion, ");
        consulta.append(" tproc.PROD_OID_PROD as oidProducto ");
		
        consulta.append(" FROM PED_TIPO_SOLIC_PROCE tproc,  ");
        consulta.append(" PED_TIPO_SOLIC_PAIS tpais, ");
        consulta.append(" PED_TIPO_SOLIC t, ");
        consulta.append(" SEG_ACCES tacce "); // Incidencia 12191

        consulta.append(" WHERE ");

        //joins 
        consulta.append(
            " tproc.TSPA_OID_TIPO_SOLI_PAIS = tpais.OID_TIPO_SOLI_PAIS AND  ");
        consulta.append(" tpais.TSOL_OID_TIPO_SOLI = t.OID_TIPO_SOLI AND  ");
        consulta.append(" tacce.OID_ACCE = t.ACCE_OID_ACCE  "); //Incidencia 12191

        //criterios (si alguno es null no condiciona) 
        if (dto.getOidPais() != null) {
            consulta.append(" AND tpais.PAIS_OID_PAIS = ? "); //dto.pais
            parametros.add(dto.getOidPais());
        }

        if (dto.getOperacion() != null) {
            consulta.append(" AND tproc.OPER_OID_OPER  = ? "); //dto.operacion
            parametros.add(dto.getOperacion());
        }

        if (dto.getOidTipoCliente() != null) {
            consulta.append(" AND t.TICL_OID_TIPO_CLIE = ? "); //dto.tipoCliente 
            parametros.add(dto.getOidTipoCliente());
        }

        if (dto.getOidSubacceso() != null) {
            consulta.append(" AND (t.SBAC_OID_SBAC = ? "); //dto.subacceso 
            parametros.add(dto.getOidSubacceso());
            consulta.append(" OR t.SBAC_OID_SBAC IS NULL) "); 
        }

        consulta.append(" AND tproc.PROD_OID_PROD IS NOT NULL ");

        String codigoError = null;
        BelcorpService bs = UtilidadesEJB.getBelcorpService();

        try {
            rs = bs.dbService.executePreparedQuery(consulta.toString(),
                    parametros);
        } catch (Exception e) {
            codigoError = CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS;
            this.logError("buscarCuotasDtoRecargo: Exception", e);
            this.logSql("buscarCuotasDtoRecargo. SQL: ", consulta.toString(),
                parametros);
            throw new MareException(e,
                UtilidadesError.armarCodigoError(codigoError));
        }

        resultado.setResultado(rs);
        UtilidadesLog.info("DAOGenerarDtoRecargo.obtenerTipoSolicitudProceso(DTOBuscarTipoSolicitudProceso dto): Salida");
        return resultado;
    }

   /* ELIMINADO POR INCIDENCIA 10254
		public DTONumero obtenerSiguienteNumeroDtoRecargo(DTOBelcorp dto)
        throws MareException {}
*/
  /*
   * 08/08/2006, @ssaavedr; se saca para afuera el round en el calculo del campo: importedto, en ambos select's
   * */
	public  DTOSalida buscarCuotasInsertar(DTOBuscarCuotasDtoRecargo dtoE) throws MareException{

		UtilidadesLog.info("DAOGenerarDtoRecargo.buscarCuotasInsertar(DTOBuscarCuotasDtoRecargo dtoE): Entrada");

		StringBuffer consulta = new StringBuffer();
		Vector parametros = new Vector();
		
		consulta.append (" (SELECT ");
		consulta.append (" oid_movi_cc as oid, ");
		//consulta.append (" dtoE.codigoCliente as codigoCliente, ");
		consulta.append (" ? as codigoCliente, ");
		parametros.add (dtoE.getCodigoCliente());
		consulta.append (" num_iden_cuot as numeroCuota, ");
		consulta.append (" val_ejer_cuot as ejercicioCuota, ");
		consulta.append (" num_orde_cuot as ordenCuota, ");
		consulta.append (" val_ulti_nume_hist as numeroHistoria, ");
		consulta.append (" val_refe_nume_docu_exte as referenciaExterna, ");
		consulta.append (" fec_docu as fechaDocumento, ");
		consulta.append (" fec_venc as fechaVencimiento, ");
		consulta.append (" fec_ulti_movi as fechaLiquidacion, ");
		
        // splatas - DBLG500000606 - 01/06/2006
        //se modif. por inc: DBLG500000771
        //consulta.append (" trunc(fec_venc - fec_ulti_movi) as diasCalculados, ");
        consulta.append (" ABS(TRUNC(fec_venc - fec_ulti_movi)) as diasCalculados, ");
		
        consulta.append (" (imp_movi - imp_movi_cuen) as importeNominal, ");
		consulta.append (" imp_movi_cuen as importePago, ");
		//consulta.append (" DECODE( ? , ");//dtoE.codigoSubproceso
        consulta.append (" round(DECODE( ? , ");//dtoE.codigoSubproceso
		parametros.add(dtoE.getCodigoSubproceso());
		consulta.append (" ? , ");//CCCConstantes.SUBPROCESO_DESCUENTO
		parametros.add(CCCConstantes.SUBPROCESO_DESCUENTO);		
    
        // splatas - DBLG500000606 - 01/06/2006
		//consulta.append (" round((((imp_movi_cuen * ? * ");//dtoE.tipoInteres
        consulta.append (" (((imp_movi_cuen * ? * ");//dtoE.tipoInteres
		
        parametros.add(dtoE.getTipoInteres());
		consulta.append (" (fec_venc - ? - fec_ulti_movi))");//dtoE.diasCadencia
		parametros.add(dtoE.getDiasCadencia());		
		//consulta.append (" / 36000) - ?), 2) , ");//dtoE.importeFijo
        consulta.append (" / 36000) - ?) , ");//dtoE.importeFijo
		parametros.add(dtoE.getImporteFijo());		
		//consulta.append (" round((((imp_movi_cuen * ? * ");//dtoE.tipoInteres
        consulta.append (" (((imp_movi_cuen * ? * ");//dtoE.tipoInteres
		parametros.add(dtoE.getTipoInteres());		
		consulta.append (" (fec_ulti_movi +  ? - fec_venc)) ");//dtoE.diasCadencia
		parametros.add(dtoE.getDiasCadencia());		
		//consulta.append (" / 36000) + ?), 2) ) as importeDto, ");//dtoE.importeFijo
        consulta.append (" / 36000) + ?) ),2) as importeDto, ");//dtoE.importeFijo
		parametros.add(dtoE.getImporteFijo());		
		consulta.append (" 1 as entidad ");

		consulta.append (" FROM ");
		consulta.append (" ccc_movim_cuent_corri ");

		consulta.append (" WHERE ");
		consulta.append (" soci_oid_soci = ? AND ");//dtoE.oidEmpresa
		parametros.add(dtoE.getOidEmpresa());			
		consulta.append (" clie_oid_clie = ? AND ");//dtoE.oidCliente
		parametros.add(dtoE.getOidCliente());			
		
        //--Se modifica por resolucion de inc BELC300021710
        //-- Paola Cabrera
        //-- 15/11/2005        
        //consulta.append (" ind_dto_carg_apli <> ? AND ");//ConstantesCMN.VAL_TRUE         
        consulta.append (" ind_dto_carg_apli is null or ind_dto_carg_apli<> ? AND ");
        parametros.add(ConstantesCMN.VAL_TRUE);	          
        //consulta.append (" NVL(imp_pago, 0) <> 0 AND "); --> Se elimina                                                                        
        //--Fin modificacion  inc BELC300021710 				
		
		consulta.append (" masi_oid_marc_situ IN ( ");

		consulta.append (" SELECT B.masi_oid_marc_sali ");

		consulta.append (" FROM ");
		consulta.append (" ccc_tipo_abono_subpr A, ");
		consulta.append (" ccc_marca_tipo_abono B ");

		consulta.append (" WHERE ");
		consulta.append (" A.subp_oid_subp = ? AND ");//dtoE.oidSubproceso
		parametros.add(dtoE.getOidSubproceso());				
		consulta.append (" B.tasp_oid_tipo_abon_subp = A.oid_tipo_abon_subp AND ");
		consulta.append (" B.IND_ENTR_SALI LIKE 'E') AND ");

		if( dtoE.getCodigoSubproceso().equals(CCCConstantes.SUBPROCESO_DESCUENTO)){
			consulta.append (" fec_ulti_movi BETWEEN fec_venc - ? ");//dtoE.diasCorte
			parametros.add(dtoE.getDiasCorte());
			consulta.append (" AND fec_venc - ? ");//dtoE.diasCadencia
			parametros.add(dtoE.getDiasCadencia());				
		}else{ 
			consulta.append (" fec_ulti_movi BETWEEN fec_venc + ? ");//dtoE.diasCadencia
			parametros.add(dtoE.getDiasCadencia());					
			consulta.append (" AND fec_venc + ? ");//dtoE.diasCorte
			parametros.add(dtoE.getDiasCorte());			
		}
 
		consulta.append (" ) ");

		consulta.append (" UNION ");

		consulta.append (" (SELECT ");
		consulta.append (" A.oid_hist_movi as oid, ");
		//consulta.append (" dtoE.codigoCliente as codigoCliente, ");
		consulta.append (" ? as codigoCliente, ");
		parametros.add (dtoE.getCodigoCliente());
		consulta.append (" B.num_iden_cuot as numeroCuota, ");
		consulta.append (" B.val_ejer_cuot as ejercicioCuota, ");
		consulta.append (" B.num_orde_cuot as ordenCuota, ");
		consulta.append (" A.num_hist as numeroHistoria, ");
		consulta.append (" A.val_refe_nume_docu_exte as referenciaExterna, ");
		consulta.append (" A.fec_docu as fechaDocumento, ");
		consulta.append (" A.fec_venc as fechaVencimiento, ");
		consulta.append (" A.fec_movi as fechaLiquidacion, ");
		
         // splatas - DBLG500000606 - 01/06/2006
        //consulta.append (" trunc(A.fec_venc - A.fec_movi) as diasCalculados, ");
        //se modif. por inc: DBLG500000771
        consulta.append (" ABS(TRUNC(A.fec_venc - A.fec_movi)) as diasCalculados, ");
        
		consulta.append (" (A.imp - A.imp_movi) as importeNominal, ");
    
		consulta.append (" A.imp_movi as importePago, ");
		consulta.append (" round(DECODE( ? , ");//dtoE.codigoSubproceso,
		parametros.add(dtoE.getCodigoSubproceso());			
		consulta.append (" ? , ");//CCCConstantes.SUBPROCESO_DESCUENTO
		parametros.add(CCCConstantes.SUBPROCESO_DESCUENTO);	
		
        // splatas - DBLG500000606 - 01/06/2006
        //consulta.append (" round((((A.imp_movi * ? * ");//dtoE.tipoInteres
        consulta.append (" (((A.imp_movi * ? * ");//dtoE.tipoInteres
		
        parametros.add(dtoE.getTipoInteres());			
		consulta.append (" (A.fec_venc - ? - A.fec_movi)) ");//dtoE.diasCadencia
		parametros.add(dtoE.getDiasCadencia());	
		//consulta.append (" / 36000) - ?), 2) , ");//dtoE.importeFijo
        consulta.append (" / 36000) - ?) , ");//dtoE.importeFijo
		parametros.add(dtoE.getImporteFijo());	
    
        // splatas - DBLG500000606 - 01/06/2006
		//consulta.append (" round((((A.imp_movi * ? * ");//dtoE.tipoInteres 
        consulta.append (" (((A.imp_movi * ? * ");//dtoE.tipoInteres 
    
		parametros.add(dtoE.getTipoInteres());			
		consulta.append (" (A.fec_movi + ? - A.fec_venc)) ");//dtoE.diasCadencia
		parametros.add(dtoE.getDiasCadencia());			
		//consulta.append (" / 36000) + ?), 2) ) as importeDto, ");//dtoE.importeFijo
        consulta.append (" / 36000) + ?) ),2) as importeDto, ");//dtoE.importeFijo
		parametros.add(dtoE.getImporteFijo());	
		consulta.append (" 2 as entidad ");

		consulta.append (" FROM ");
		consulta.append (" ccc_histo_movim_cc A, ");
		consulta.append (" ccc_movim_cuent_corri B ");

		consulta.append (" WHERE ");
		consulta.append (" B.oid_movi_cc = A.mvcc_oid_movi_cc AND ");
		consulta.append (" B.soci_oid_soci = ? AND ");
		parametros.add (dtoE.getOidEmpresa());
		consulta.append (" A.clie_oid_clie = ? AND ");
		parametros.add (dtoE.getOidCliente());
		
        
        //--Se modifica por resolucion de inc BELC300021710
        //-- Paola Cabrera
        //-- 15/11/2005        
        //consulta.append (" ind_dto_carg_apli <> ? AND ");//ConstantesCMN.VAL_TRUE         
        consulta.append (" ind_dto_carg_apli is null or ind_dto_carg_apli<> ? AND ");
        parametros.add(ConstantesCMN.VAL_TRUE);	          
        //consulta.append (" NVL(imp_pago, 0) <> 0 AND "); --> Se elimina                                                                        
        //--Fin modificacion  inc BELC300021710   
        
        
		consulta.append (" A.masi_oid_marc_situ IN ( ");
		consulta.append (" SELECT D.masi_oid_marc_sali ");
		consulta.append (" FROM ");
		consulta.append (" ccc_tipo_abono_subpr C, ");
		consulta.append (" ccc_marca_tipo_abono D ");
		consulta.append (" WHERE ");
		consulta.append (" C.subp_oid_subp = ? AND ");//dtoE.oidSubproceso
		parametros.add(dtoE.getOidSubproceso());			
		consulta.append (" D.tasp_oid_tipo_abon_subp = C.oid_tipo_abon_subp AND ");
		consulta.append (" D.IND_ENTR_SALI LIKE 'E') AND ");

		if( dtoE.getCodigoSubproceso().equals(CCCConstantes.SUBPROCESO_DESCUENTO)){
			consulta.append (" A.fec_movi BETWEEN A.fec_venc - ? ");//dtoE.diasCorte
			parametros.add(dtoE.getDiasCorte());		
			consulta.append (" AND A.fec_venc - ? ");//dtoE.diasCadencia 
			parametros.add(dtoE.getDiasCadencia());			
		}else{
			consulta.append (" A.fec_movi BETWEEN A.fec_venc + ? ");//dtoE.diasCadencia 
			parametros.add(dtoE.getDiasCadencia());			
			consulta.append (" AND A.fec_venc + ? ");//dtoE.diasCorte 
			parametros.add(dtoE.getDiasCorte());		
		}
		
		consulta.append (" ) "); 
    
        UtilidadesLog.debug("la consulta es: " + consulta.toString());
	
		String codigoError = null;
        BelcorpService bs = UtilidadesEJB.getBelcorpService();
		RecordSet resultado = new RecordSet();
		
        try {
            resultado = bs.dbService.executePreparedQuery(consulta.toString(),
                    parametros);
        } catch (Exception e) {
            codigoError = CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS;
            this.logError("buscarCuotasInsertar: Exception", e);
            this.logSql("buscarCuotasInsertar. SQL: ", consulta.toString(),
                parametros);
            throw new MareException(e,
                UtilidadesError.armarCodigoError(codigoError));
        }
        if (resultado.esVacio()) {
			UtilidadesLog.debug("buscarCuotasInsertar: no hay datos ");				
            codigoError = CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE;
            throw new MareException(new Exception(),
                UtilidadesError.armarCodigoError(codigoError));
        }

		DTOSalida salida = new DTOSalida();
		salida.setResultado(resultado);
		
		UtilidadesLog.info("DAOGenerarDtoRecargo.buscarCuotasInsertar(DTOBuscarCuotasDtoRecargo dtoE): Salida");
		return salida;
	}

    private void logStackTrace(Throwable e) {
        try {
            UtilidadesLog.error(e);
        } catch (Exception ex) {
            UtilidadesLog.error("Traza de la pila: " + ex.getMessage());
        }
    }

    private void logError(String mensaje, Throwable e) {
        UtilidadesLog.error("*** Error Metodo " + mensaje + ": " +
            e.getMessage());
        this.logStackTrace(e);
    }

    private void logSql(String metodo, String sql, Vector params) {
        
        UtilidadesLog.debug(metodo + sql);
        if ((params != null) && (params.size() > 0)) {
            String sParams = "";
            for (int i = 0; i < params.size(); i++) {
                sParams += ("param " + (i + 1) + ": " + params.elementAt(i) +
                ", ");
            }
            UtilidadesLog.debug(metodo + sParams);
        }
    }
}
