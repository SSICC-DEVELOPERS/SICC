/**
 * Copyright 2002 © por Indra Sistemas,S.A.. Todos los derechos reservados.
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
import es.indra.sicc.dtos.ccc.DTOBuscarReclamos;
import es.indra.sicc.dtos.ccc.DTOReclamo;
import es.indra.sicc.dtos.ccc.DTONumeroReclamo;

import es.indra.sicc.logicanegocio.seg.MONMantenimientoSEG;
import es.indra.sicc.logicanegocio.seg.MONMantenimientoSEGHome;
import es.indra.sicc.util.BelcorpService;
import es.indra.sicc.util.CodigosError;
import es.indra.sicc.util.DTOOID;
import es.indra.sicc.util.DTOSalida;
import es.indra.sicc.util.DTOBelcorp;
import es.indra.sicc.util.UtilidadesEJB;
import es.indra.sicc.util.UtilidadesError;
import es.indra.sicc.util.UtilidadesLog;
import es.indra.sicc.util.UtilidadesPaginacion;


import java.math.BigDecimal;

import java.text.SimpleDateFormat;


import java.sql.Date;

import java.util.Calendar;
import java.util.Vector;

public class DAORegularizacion  {
	private String usuario;
	public DAORegularizacion(String usuario) {
		this.usuario = usuario;
	}
	public DTOSalida buscarReclamos(DTOBuscarReclamos dto) throws MareException {
		
        UtilidadesLog.info("DAORegularizacion.buscarReclamos(DTOBuscarReclamos dto): Entrada");
		UtilidadesLog.debug("dtoBuscarREeclamos = " +dto);

		StringBuffer consulta = new StringBuffer();
		Vector parametros = new Vector();
		
		consulta.append(" SELECT");
		consulta.append(" rec.OID_RECE_RECL OID ,");
		consulta.append(" rec.NUM_RECE,");
		consulta.append(" rec.VAL_ANIO,");
		consulta.append(" rec.VAL_PERI_MES,");
		
		consulta.append(" (SELECT v.VAL_I18N FROM V_GEN_I18N_SICC v");
		consulta.append(" WHERE v.VAL_OID=rec.SIRE_OID_SITU_RECL");
		consulta.append(" AND v.IDIO_OID_IDIO = ?");
		parametros.add(dto.getOidIdioma());
		consulta.append(" AND v.ATTR_NUM_ATRI = 1");
		consulta.append(" AND v.ATTR_ENTI = 'CCC_SITUA_RECLA') AS DESC_SITUA_RECLA,");
		
		
		//consulta.append("  banc.COD_BANC,");//atencion Cambios
		consulta.append("  banc.DES_BANC,");
		consulta.append("  suc.COD_SUCU,");//ccb.COD_CC_BANC,");
		consulta.append("  ccb.DES_CC,");
		consulta.append("  cli.COD_CLIE,");
		consulta.append("  rec.FEC_DOCU,");
		consulta.append("  rec.IMP_RECL,");
        consulta.append("  rec.SIRE_OID_SITU_RECL");
		
		consulta.append(" FROM");
		consulta.append(" CCC_RECEP_RECLA rec,");
		consulta.append(" CCC_CUENT_CORRI_BANCA ccb,");
		consulta.append(" CCC_SUCUR suc,");
		consulta.append(" CCC_BANCO banc,");
		consulta.append(" MAE_CLIEN cli,");
		consulta.append(" CCC_SITUA_RECLA situ");

		consulta.append(" WHERE");

		consulta.append(" rec.CCBA_OID_CC_BANC_RECA = ccb.OID_CUEN_CORR_BANC (+)");
		consulta.append(" AND ccb.SUCU_OID_SUCU = suc.OID_SUCU (+)");
		consulta.append(" AND rec.CLIE_OID_CONS_RECL = cli.OID_CLIE");
		consulta.append(" AND rec.SIRE_OID_SITU_RECL = situ.OID_SITU_RECL");
		consulta.append(" AND suc.CBAN_OID_BANC=banc.OID_BANC (+)");
		

		
		//Ahora ponemos las restricciones a la consulta, si un campo en el dto es null quitamos la restriccion correspondiente. 
		if(dto.getNumeroIdentificacion()!=null){ 
			consulta.append(" AND rec.NUM_RECE =? ");
			parametros.add(dto.getNumeroIdentificacion());
		}
		
		if(dto.getAnio()!=null){ //dto.anyo
			consulta.append(" AND rec.VAL_ANIO =? "); 
			parametros.add(dto.getAnio());
		}
		if(dto.getMes()!=null){ //dto.periodoMes
			consulta.append(" AND rec.VAL_PERI_MES =? ");
			parametros.add(dto.getMes());
		}
		
        //consulta.append(" AND suc.CBAN_OID_BANC = 3");
        //consulta.append(" AND rec.SUCU_OID_SUCU = 3");
        //consulta.append(" AND rec.CCBA_OID_CC_BANC_RECA = 2");
        //consulta.append(" AND rec.CLIE_OID_CONS_RECL = 198	
		
		
		if(dto.getOidBanco()!=null){ //dto.bancoRecaudacion 
			consulta.append(" AND suc.CBAN_OID_BANC =? ");
			parametros.add(dto.getOidBanco());
		}
		if(dto.getOidSucursal()!=null){ //dto.sucursal
			consulta.append(" AND suc.OID_SUCU =? ");
			parametros.add(dto.getOidSucursal());
		}
		if(dto.getOidCuentaCorriente()!=null){ //dto.cuentaCorriente
			consulta.append(" AND rec.CCBA_OID_CC_BANC_RECA =? ");
			parametros.add(dto.getOidCuentaCorriente());
		}
		if(dto.getOidClienteReclamante()!=null){ //dto.codigoCliente
			consulta.append(" AND rec.CLIE_OID_CONS_RECL =? ");
			parametros.add(dto.getOidClienteReclamante());
		}
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
           /*
                 anteriormente:
                 if(dto.getFechaDocumento()!=null){ //dto.fechaDocumento
                            consulta.append(" AND rec.FEC_DOCU=? ");
                            parametros.add(new Date(dto.getFechaDocumento().getTime()));
                        }
                
                 * */

		if(dto.getFechaDocumento()!=null){ //dto.fechaDocumento
			java.sql.Date fechaDesde = new java.sql.Date(dto.getFechaDocumento().getTime());
			String sFechaDesde = sdf.format(fechaDesde);  
			consulta.append(" AND (rec.FEC_DOCU = TO_DATE( ? ,'YYYY-MM-DD') ) "); 
			parametros.add(sFechaDesde);
		}
		if(dto.getOidSituacion()!=null){ //dto.situacion
			consulta.append(" AND rec.SIRE_OID_SITU_RECL =? ");
			parametros.add(dto.getOidSituacion());
		}
		if(dto.getUsuarioGestorReclamoPrevisto()!=null){ //dto.usuarioGestorPrevisto
			consulta.append(" AND rec.VAL_USUA_GEST_PREV =? ");
			parametros.add(dto.getUsuarioGestorReclamoPrevisto());
		}
		if(dto.getUsuarioGestorReclamoReal()!=null){ //dto.usuarioGestorReal
			consulta.append(" AND rec.VAL_USUA_GEST_REAL =? ");
			parametros.add(dto.getUsuarioGestorReclamoReal());
		}
		if(dto.getUsuarioSolicitante()!=null){ //dto.usuarioSolicitante
			consulta.append(" AND rec.VAL_USUA_SOLI =? ");
			parametros.add(dto.getUsuarioSolicitante());
		}
		UtilidadesLog.debug("[cs] dto = " +dto);
		// Se ejecuta la consulta 
		BelcorpService bs = UtilidadesEJB.getBelcorpService();
		RecordSet resultado = null;
		String codigoError = null;
		String sqlPaginada = UtilidadesPaginacion.armarQueryPaginacion(consulta.toString(),dto);
		UtilidadesLog.debug("[cs]= " + sqlPaginada);
		try {
			resultado = bs.dbService.executePreparedQuery(sqlPaginada, parametros);
				UtilidadesLog.debug("[cs]= " +parametros);
		} catch (Exception e) {
			this.logStackTrace(e);
			this.loguearSql("buscarReclamos",consulta.toString(),parametros);
            codigoError = CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS;
            throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));
		}
		UtilidadesLog.debug("recordSet = " + resultado);
		DTOSalida dtoSalida = new DTOSalida(resultado);
		UtilidadesLog.info("DAORegularizacion.buscarReclamos(DTOBuscarReclamos dto): Salida");
		return dtoSalida;				
	}
	
	public DTOReclamo obtenerReclamo(DTOOID oid) throws MareException { //pendiente Incidencia 3253
		
        UtilidadesLog.info("DAORegularizacion.obtenerReclamo(DTOOID oid): Entrada");
        //falta BELC300008849
	    StringBuffer consulta = new StringBuffer();
		Vector parametros = new Vector();		
		consulta.append(" SELECT  DISTINCT r.VAL_ANIO, ");
		consulta.append(" r.VAL_PERI_MES, ");
		consulta.append(" r.NUM_RECE, ");
		consulta.append(" b.DES_BANC AS DESC_BANCO, ");
		consulta.append(" s.COD_SUCU ,  ");
		consulta.append(" c.DES_CC AS DESC_CCB, ");
		consulta.append(" b.OID_BANC, ");

		consulta.append(" r.MPAB_OID_MEDI_PAGO,  ");//requiere descripcion CCC_RECEP_RECLA y oid
        consulta.append(" (SELECT    v.VAL_I18N FROM V_GEN_I18N_SICC v ");
        consulta.append("   WHERE v.VAL_OID=r.MPAB_OID_MEDI_PAGO ");
        consulta.append("   		AND   v.IDIO_OID_IDIO =?");
		parametros.add(oid.getOidIdioma());
        consulta.append("      AND   v.ATTR_NUM_ATRI = 1 ");
        consulta.append("      AND   v.ATTR_ENTI = 'BEL_MEDIO_PAGO') AS DESC_MEDIO_PAGO, "); 

		consulta.append(" cli.COD_CLIE, ");
		consulta.append(" cli.OID_CLIE, ");
		
		consulta.append(" r.FEC_DOCU, ");
		consulta.append(" r.SIRE_OID_SITU_RECL, ");
        consulta.append(" (SELECT    v.VAL_I18N FROM V_GEN_I18N_SICC v ");
        consulta.append("   WHERE v.VAL_OID=r.SIRE_OID_SITU_RECL ");
        consulta.append("   		AND   v.IDIO_OID_IDIO =?");
		parametros.add(oid.getOidIdioma());
        consulta.append("      AND   v.ATTR_NUM_ATRI = 1 ");
        consulta.append("      AND   v.ATTR_ENTI = 'CCC_SITUA_RECLA') AS DESC_SITUACION, ");    


		consulta.append(" r.VAL_USUA_GEST_PREV, ");
		consulta.append(" r.VAL_USUA_GEST_REAL, ");
		consulta.append(" r.VAL_USUA_SOLI, ");
		consulta.append(" r.OID_RECE_RECL, ");

		consulta.append(" r.CANA_OID_CANA, "); //requiere descripcion 
        consulta.append(" (SELECT    v.VAL_I18N FROM V_GEN_I18N_SICC v ");
        consulta.append("   WHERE v.VAL_OID=r.CANA_OID_CANA ");
        consulta.append("   		AND   v.IDIO_OID_IDIO =?");
		parametros.add(oid.getOidIdioma());
        consulta.append("      AND   v.ATTR_NUM_ATRI = 1 ");
        consulta.append("      AND   v.ATTR_ENTI = 'SEG_CANAL') AS DESC_CANAL, ");  

		consulta.append(" r.ACCE_OID_ACCE, "); //requiere descripcion SEG_ACCES
        consulta.append(" (SELECT    v.VAL_I18N FROM V_GEN_I18N_SICC v ");
        consulta.append("   WHERE v.VAL_OID=r.ACCE_OID_ACCE ");
        consulta.append("   		AND   v.IDIO_OID_IDIO =?");
		parametros.add(oid.getOidIdioma());
        consulta.append("      AND   v.ATTR_NUM_ATRI = 1 ");
        consulta.append("      AND   v.ATTR_ENTI = 'SEG_ACCES') AS DESC_ACCE, ");  

		consulta.append(" r.SBAC_OID_SBAC, ");//requiere descripcion VCA_SEG_SUBAC y el oid
        consulta.append(" (SELECT    v.VAL_I18N FROM V_GEN_I18N_SICC v ");
        consulta.append("   WHERE v.VAL_OID=r.SBAC_OID_SBAC ");
        consulta.append("   		AND   v.IDIO_OID_IDIO =?");
		parametros.add(oid.getOidIdioma());
        consulta.append("      AND   v.ATTR_NUM_ATRI = 1 ");
        consulta.append("      AND   v.ATTR_ENTI = 'SEG_SUBAC') AS DESC_SUB_ACCESO, "); 

		consulta.append(" r.IMP_RECL, ");
		consulta.append(" r.VAL_OBSE_CLIE_RECL, ");

		consulta.append(" r.PERI_OID_PERI_RECL, ");		
        consulta.append(" (SELECT    v.VAL_I18N FROM V_GEN_I18N_SICC v ");
        consulta.append("   WHERE v.VAL_OID=r.PERI_OID_PERI_RECL ");
        consulta.append("   		AND   v.IDIO_OID_IDIO =?");
		parametros.add(oid.getOidIdioma());
        consulta.append("      AND   v.ATTR_NUM_ATRI = 1 ");
        consulta.append("      AND   v.ATTR_ENTI = 'SEG_PERIO_CORPO') AS DESC_PERIODO_RECLAMACION, ");      		
		
		consulta.append(" r.MOID_MOTI_RECH_DESB, ");
        consulta.append(" (SELECT    v.VAL_I18N FROM V_GEN_I18N_SICC v ");
        consulta.append("   WHERE v.VAL_OID=r.MOID_MOTI_RECH_DESB ");
        consulta.append("   		AND   v.IDIO_OID_IDIO =?");
		parametros.add(oid.getOidIdioma());
        consulta.append("      AND   v.ATTR_NUM_ATRI = 1 ");
        consulta.append("      AND   v.ATTR_ENTI = 'REC_MOTIV_RECHA_DESBL') AS DESC_MOTIVO_RECHAZO, ");      		
					
		consulta.append(" mov.NUM_IDEN_CUOT, ");
		consulta.append(" mov.VAL_EJER_CUOT, ");
		consulta.append(" mov.NUM_ORDE_CUOT, ");
		consulta.append(" cab.NUM_CABE, ");
		consulta.append(" cab.ANIO, ");
		consulta.append(" cab.VAL_PERI_MES AS VAL_PERI_MES_ABONO_DIRECTO, ");
		consulta.append(" r.VAL_OBSE_AREA_RECL,  ");
		//consulta.append(" r.VAL_OBSE_CLIE_RECL,  ");
		consulta.append(" r.VAL_OBSE_RECL, ");
		consulta.append(" r.FEC_RESO_PREV,  ");
		consulta.append(" r.FEC_RESO_REAL,  ");
		consulta.append(" r.VAL_FICH_DOCU_ADJU, "); 
		
		consulta.append(" e.OID_SOCI,  ");
       
		consulta.append(" c.OID_CUEN_CORR_BANC, ");
		consulta.append(" s.OID_SUCU, ");
		
		consulta.append(" e.VAL_DENO AS DESC_SOCIEDAD, ");
		consulta.append(" r.FEC_VALO ");
		consulta.append(" FROM (((((CCC_RECEP_RECLA r LEFT JOIN CCC_MOVIM_CUENT_CORRI mov ON (r.MVCC_OID_MOVI_CC = mov.OID_MOVI_CC)) ");
		consulta.append(" LEFT JOIN CCC_CUENT_CORRI_BANCA c ON (r.CCBA_OID_CC_BANC_RECA = c.OID_CUEN_CORR_BANC))  ");
		consulta.append(" LEFT JOIN CCC_CABEC_CARGA_ABONO_DIREC cab ON ( r.CCAD_OID_CABE_CARG = cab.OID_CABE_CARG))  ");
		consulta.append(" LEFT JOIN CCC_SUCUR s ON (c.SUCU_OID_SUCU = s.OID_SUCU))  ");
		consulta.append(" LEFT JOIN CCC_BANCO b ON (s.CBAN_OID_BANC = b.OID_BANC))  ");
		consulta.append(" , MAE_CLIEN cli, VCA_SEG_SOCIE e  ");
		consulta.append(" WHERE r.clie_oid_cons_recl= cli.OID_CLIE  ");
		consulta.append(" AND r.SOCI_OID_SOCI = e.OID_SOCI  ");
		consulta.append(" AND e.PAIS_OID_PAIS = ?  ");
		parametros.add(oid.getOidPais());
		consulta.append(" AND e.COD_USUA = ? ");
		parametros.add(this.usuario);		
		consulta.append(" AND r.OID_RECE_RECL = ? ");
		parametros.add(oid.getOid());
		
		BelcorpService bs = UtilidadesEJB.getBelcorpService();
		RecordSet resultado = null;
		String codigoError = null;
		try {
			resultado = bs.dbService.executePreparedQuery(consulta.toString(), 
				parametros);
		} catch (Exception e) {
			this.logStackTrace(e);
			this.loguearSql("obtenerReclamo",consulta.toString(),parametros);
            codigoError = CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS;
            throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));
		}
		DTOReclamo dtoReclamo =null;
	try{
		if(!resultado.esVacio()){
			dtoReclamo=new DTOReclamo();	
			if(resultado.getValueAt(0,"VAL_ANIO")!=null){
				dtoReclamo.setAnio(resultado.getValueAt(0,"VAL_ANIO").toString());
			}
			if(resultado.getValueAt(0,"ACCE_OID_ACCE")!=null){
				dtoReclamo.setOidAcceso(new Long(((BigDecimal)resultado.getValueAt(0,"ACCE_OID_ACCE")).longValue()));
			}
			if(resultado.getValueAt(0,"ANIO")!=null){
				dtoReclamo.setAnioCargoAbono(resultado.getValueAt(0,"ANIO").toString());
			}
			if(resultado.getValueAt(0,"CANA_OID_CANA")!=null){
				dtoReclamo.setOidCanal(new Long(((BigDecimal)resultado.getValueAt(0,"CANA_OID_CANA")).longValue()));
			}
			//BELC300008849
/*			if(resultado.getValueAt(0,"DESC_ACCE")!=null){ 
				dtoReclamo.setDescAcceso(resultado.getValueAt(0,"DESC_ACCE").toString());
			}	
			if(resultado.getValueAt(0,"DESC_BANCO")!=null){ 
				dtoReclamo.setDescBancoRecaudacion(resultado.getValueAt(0,"DESC_BANCO").toString());
			}
			if(resultado.getValueAt(0,"DESC_CANAL")!=null){ 
				dtoReclamo.setDescCanal(resultado.getValueAt(0,"DESC_CANAL").toString());
			}
			if(resultado.getValueAt(0,"DESC_CCB")!=null){ 
				dtoReclamo.setDescCuentaCorriente(resultado.getValueAt(0,"DESC_CCB").toString());
			}
			if(resultado.getValueAt(0,"DESC_MEDIO_PAGO")!=null){ 
				dtoReclamo.setDescMedioPago(resultado.getValueAt(0,"DESC_MEDIO_PAGO").toString());
			}
			if(resultado.getValueAt(0,"DESC_MOTIVO_RECHAZO")!=null){ 
				dtoReclamo.setDescMotivoRechazo(resultado.getValueAt(0,"DESC_MOTIVO_RECHAZO").toString());
			}
			if(resultado.getValueAt(0,"DESC_PERIODO_RECLAMACION")!=null){ 
				dtoReclamo.setDescPeriodoReclamante(resultado.getValueAt(0,"DESC_PERIODO_RECLAMACION").toString());
			}
			if(resultado.getValueAt(0,"DESC_SITUACION")!=null){
				dtoReclamo.setDescSituacion(resultado.getValueAt(0,"DESC_SITUACION").toString());
			}
			if(resultado.getValueAt(0,"DESC_SUB_ACCESO")!=null){ 
				dtoReclamo.setDescSubacceso(resultado.getValueAt(0,"DESC_SUB_ACCESO").toString());
			}
		
			if(resultado.getValueAt(0,"DESC_SUCURSAL")!=null){ 
				dtoReclamo.setDescSucursal(resultado.getValueAt(0,"DESC_SUCURSAL").toString());
			}
				*/

			if(resultado.getValueAt(0,"VAL_EJER_CUOT")!=null){ 
				dtoReclamo.setEjercicioCuota(resultado.getValueAt(0,"VAL_EJER_CUOT").toString());
			}
			if(resultado.getValueAt(0,"OID_SOCI")!=null){ //Incidencia 3337
				dtoReclamo.setOidEmpresa(new Long(((BigDecimal)resultado.getValueAt(0,"OID_SOCI")).longValue()));
			}
		//	if(resultado.getValueAt(0,"DESC_SOCIEDAD")!=null){
		//		dtoReclamo.setEmpresaDesc(resultado.getValueAt(0,"DESC_SOCIEDAD").toString());
		//	}
			if(resultado.getValueAt(0,"FEC_RESO_PREV")!=null){
				dtoReclamo.setFechaResolucionPrevista((Date)resultado.getValueAt(0,"FEC_RESO_PREV"));
			}
			if(resultado.getValueAt(0,"FEC_RESO_REAL")!=null){
				dtoReclamo.setFechaResolucionReal((Date)resultado.getValueAt(0,"FEC_RESO_REAL"));
			}
			if(resultado.getValueAt(0,"VAL_FICH_DOCU_ADJU")!=null){
				dtoReclamo.setFicheroDocumentoAdjunto(resultado.getValueAt(0,"VAL_FICH_DOCU_ADJU").toString());
			}
			if(resultado.getValueAt(0,"IMP_RECL")!=null){
				dtoReclamo.setImporteReclamado((BigDecimal)resultado.getValueAt(0,"IMP_RECL"));
			}
			if(resultado.getValueAt(0,"MPAB_OID_MEDI_PAGO")!=null){
				dtoReclamo.setOidMedioPago(new Long(((BigDecimal)resultado.getValueAt(0,"MPAB_OID_MEDI_PAGO")).longValue()));
			}
			if(resultado.getValueAt(0,"MOID_MOTI_RECH_DESB")!=null){
				dtoReclamo.setOidMotivoRechazoDesbloqueo(new Long(((BigDecimal)resultado.getValueAt(0,"MOID_MOTI_RECH_DESB")).longValue()));
			}
			if(resultado.getValueAt(0,"NUM_CABE")!=null){
				dtoReclamo.setNumeroCargoAbono(new Integer(resultado.getValueAt(0,"NUM_CABE").toString()));
			}
			if(resultado.getValueAt(0,"NUM_IDEN_CUOT")!=null){
				dtoReclamo.setNumeroIdentificadorCuota(new Integer(((BigDecimal)resultado.getValueAt(0,"NUM_IDEN_CUOT")).intValue()));
			}
			if(resultado.getValueAt(0,"NUM_ORDE_CUOT")!=null){
				dtoReclamo.setNumeroOrdenCuota(new Integer(((BigDecimal)resultado.getValueAt(0,"NUM_ORDE_CUOT")).intValue()));
			}
			//if(resultado.getValueAt(0,"VAL_NUME_SERI_CUOT")!=null){
			//	dtoReclamo.setNumeroSerieCuota(resultado.getValueAt(0,"VAL_NUME_SERI_CUOT").toString());
			//}
			if(resultado.getValueAt(0,"VAL_OBSE_AREA_RECL")!=null){
				dtoReclamo.setObservacionesAreaReclamos(resultado.getValueAt(0,"VAL_OBSE_AREA_RECL").toString());
			}
			if(resultado.getValueAt(0,"VAL_OBSE_CLIE_RECL")!=null){
				dtoReclamo.setObservacionesClienteReclamante(resultado.getValueAt(0,"VAL_OBSE_CLIE_RECL").toString());
			}
			if(resultado.getValueAt(0,"VAL_OBSE_RECL")!=null){
				dtoReclamo.setObservacionesResolucionReclamos(resultado.getValueAt(0,"VAL_OBSE_RECL").toString());
			}
			dtoReclamo.setOid(oid.getOid());
			dtoReclamo.setOidIdioma(oid.getOidIdioma());
			dtoReclamo.setOidPais(oid.getOidPais());

			if(resultado.getValueAt(0,"VAL_PERI_MES_ABONO_DIRECTO")!=null){
				dtoReclamo.setMesCargoAbono(resultado.getValueAt(0,"VAL_PERI_MES_ABONO_DIRECTO").toString());
			}
			if(resultado.getValueAt(0,"PERI_OID_PERI_RECL")!=null){
				dtoReclamo.setOidPeriodoReclamante(new Long(((BigDecimal)resultado.getValueAt(0,"PERI_OID_PERI_RECL")).longValue()));
			}
			if(resultado.getValueAt(0,"SBAC_OID_SBAC")!=null){
				dtoReclamo.setOidSubacceso(new Long(((BigDecimal)resultado.getValueAt(0,"SBAC_OID_SBAC")).longValue()));
			}
			
			//campos Heredados
			if(resultado.getValueAt(0,"OID_BANC")!=null){ //Incidencia 3339
				dtoReclamo.setOidBanco(new Long(((BigDecimal)resultado.getValueAt(0,"OID_BANC")).longValue()));
			}
			if(resultado.getValueAt(0,"COD_CLIE")!=null){
				dtoReclamo.setCodigoClienteReclamante(resultado.getValueAt(0,"COD_CLIE").toString());
			}
			if(resultado.getValueAt(0,"OID_CUEN_CORR_BANC")!=null){
				dtoReclamo.setOidCuentaCorriente(new Long(((BigDecimal)resultado.getValueAt(0,"OID_CUEN_CORR_BANC")).longValue()));
			}
			if(resultado.getValueAt(0,"FEC_DOCU")!=null){
				dtoReclamo.setFechaDocumento((Date)resultado.getValueAt(0,"FEC_DOCU"));
			}
			if(resultado.getValueAt(0,"NUM_RECE")!=null){//Incidencia 3339
				dtoReclamo.setNumeroIdentificacion(new Integer(((BigDecimal)resultado.getValueAt(0,"NUM_RECE")).intValue()));
			}
			if(resultado.getValueAt(0,"VAL_PERI_MES")!=null){
				dtoReclamo.setMes(resultado.getValueAt(0,"VAL_PERI_MES").toString());
			}
			if(resultado.getValueAt(0,"SIRE_OID_SITU_RECL")!=null){
				dtoReclamo.setOidSituacion(new Long(((BigDecimal)resultado.getValueAt(0,"SIRE_OID_SITU_RECL")).longValue()));
			}
			if(resultado.getValueAt(0,"OID_SUCU")!=null){
				dtoReclamo.setOidSucursal(new Long(((BigDecimal)resultado.getValueAt(0,"OID_SUCU")).longValue()));
			}
			if(resultado.getValueAt(0,"VAL_USUA_GEST_PREV")!=null){
				dtoReclamo.setUsuarioGestorReclamoPrevisto(resultado.getValueAt(0,"VAL_USUA_GEST_PREV").toString());
			}
			if(resultado.getValueAt(0,"VAL_USUA_GEST_REAL")!=null){
				dtoReclamo.setUsuarioGestorReclamoReal(resultado.getValueAt(0,"VAL_USUA_GEST_REAL").toString());
			}
			if(resultado.getValueAt(0,"VAL_USUA_SOLI")!=null){
				dtoReclamo.setUsuarioSolicitante(resultado.getValueAt(0,"VAL_USUA_SOLI").toString());
			}
			if(resultado.getValueAt(0,"FEC_VALO")!=null){
				dtoReclamo.setFechaValor((Date)resultado.getValueAt(0,"FEC_VALO"));
			}
		}
	}catch(Exception ex){
			this.logStackTrace( ex);
			     throw new MareException(ex);
			}
		UtilidadesLog.info("DAORegularizacion.obtenerReclamo(DTOOID oid): Salida");
		return dtoReclamo;				
	}

	// BELC300004544   //BELC300008981
	public DTONumeroReclamo obtenerSiguienteNumero(Long pais, Long idioma) throws MareException {
		
        UtilidadesLog.info("DAORegularizacion.obtenerSiguienteNumero(Long pais, Long idioma): Entrada");
		/*
		 * Obtiene el siguinte secuencial de depuración para el país indicado,
		 * dependiendo de la configuración para dicho pais.
                    Llamamos al método recuperarPais de IServicioSEG pasandole un DTOBelcorp con el pais 
                    y el idioma recibidos por parametros. Del recordset que obtenemos 
                    (que debe contener sólo una fila) 
                    nos quedamos con el campo VAL_CONF_SECU_CCC 
                    y lo metemos en la siguiente variable char tipoSecuencial
		 */
         
		RecordSet resultado = null;
		Integer siguiente = null;
		String codigoError = null;
		StringBuffer consulta = new StringBuffer();
		Vector parametros = new Vector();			
		try {
			consulta.append("");
			// Se ejecuta la consulta 
			MONMantenimientoSEG mantenimientoSEG = this.getIServicioSEG();
			DTOOID dtoOid=new DTOOID();
			dtoOid.setOid(pais);
			dtoOid.setOidIdioma(idioma);	
			UtilidadesLog.debug("El pais es =" + pais + ",idioma=" + idioma);
			DTOSalida dtoSalida = mantenimientoSEG.recuperarPais(dtoOid);
			RecordSet resultadoPais=dtoSalida.getResultado();
			char configuracion = resultadoPais.getValueAt(0, "VAL_CONF_SECU_CCC").toString().charAt(0);
			Calendar cal = Calendar.getInstance();
			cal.setTime(new Date(System.currentTimeMillis()));
			String anyo = (String.valueOf(cal.get(Calendar.YEAR))).substring(2);				
			String mes = String.valueOf(cal.get(Calendar.MONTH));
			if (mes.length() < 2){
				mes="0"+mes;
			}
			if(configuracion=='U'){
				consulta.append(" SELECT MAX(NUM_RECE) ");
				consulta.append(" FROM CCC_RECEP_RECLA ccc,SEG_SOCIE seg ");
				consulta.append(" WHERE SEG.OID_SOCI=ccc.SOCI_OID_SOCI ");
				consulta.append(" AND seg.PAIS_OID_PAIS =? "); 
				parametros.add(pais);
			
			}else if(configuracion=='A'){
				consulta.append(" SELECT MAX(NUM_RECE) ");
				consulta.append(" FROM CCC_RECEP_RECLA CCC,SEG_SOCIE SEG ");
				consulta.append(" GROUP BY VAL_ANIO, PAIS_OID_PAIS, OID_SOCI, SOCI_OID_SOCI ");//ojo aqui que estas ulñtimas no vienen en el diseño.
				consulta.append(" HAVING SEG.PAIS_OID_PAIS = ? "); //incidencia 3278
				parametros.add(pais);		
				consulta.append(" AND CCC.VAL_ANIO = ? ");
				parametros.add(anyo);
     			consulta.append(" AND SEG.OID_SOCI=CCC.SOCI_OID_SOCI ");
			}else if(configuracion=='M'){
				consulta.append(" SELECT MAX(NUM_RECE) ");
				consulta.append(" FROM CCC_RECEP_RECLA CCC,SEG_SOCIE SEG ");
				consulta.append(" GROUP BY VAL_ANIO, VAL_PERI_MES,OID_SOCI,SOCI_OID_SOCI,PAIS_OID_PAIS ");
				consulta.append(" HAVING SEG.PAIS_OID_PAIS = ? "); //incidencia 3278
				parametros.add(pais);		
				consulta.append(" AND CCC.VAL_ANIO = ? ");
				parametros.add(anyo);
				consulta.append(" AND CCC.VAL_PERI_MES = ? ");
				parametros.add(mes);
				consulta.append(" AND SEG.OID_SOCI=CCC.SOCI_OID_SOCI ");
			}
			BelcorpService bs = UtilidadesEJB.getBelcorpService();		
			resultado = bs.dbService.executePreparedQuery(consulta.toString(),parametros);
		} catch (Exception e) {
			this.logStackTrace(e);
			this.loguearSql("obtenerSiguienteNumero",consulta.toString(),parametros);
            codigoError = CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS;
            throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));
		}
	   DTONumeroReclamo dtoN= new DTONumeroReclamo();
       if (resultado != null) {
			dtoN.setOidPais(pais);
			dtoN.setOidIdioma(idioma);			
			UtilidadesLog.debug("resultado != null");
			if (!resultado.esVacio()) {
					    UtilidadesLog.debug("!resultado.esVacio");
						if(resultado.getValueAt(0,0) != null){
							siguiente = new Integer(((BigDecimal)resultado.getValueAt(0,0)).intValue()+1);
							dtoN.setNumeroIdentificacion(siguiente);//BELC300008981
							UtilidadesLog.debug("resultado.getValueAt(0,0) != null-->siguiente "+siguiente );
						}else{	
							UtilidadesLog.debug("resultado.getValueAt(0,0) == null");
							dtoN.setNumeroIdentificacion(new Integer("1"));		
						}
			} else {
					UtilidadesLog.debug("resultado.esVacio");
					dtoN.setNumeroIdentificacion(new Integer("1"));
			}
	
	   }
		UtilidadesLog.debug("[SEBAS]getNumeroIdentificacion = " + dtoN.getNumeroIdentificacion());
		UtilidadesLog.info("DAORegularizacion.obtenerSiguienteNumero(Long pais, Long idioma): Salida");
		return dtoN;				
	}
	
	public DTOSalida obtenerSituacionesReclamo(DTOBelcorp dto) throws MareException { 
       /*					Nº Incidencia:   BELC300008840 
                 *  DTOSalida obtenerSituacionesReclamo (), in Class DAORegularizacion
                Hacemos un JOIN de la tabla CCC_SITUA_RECLA con la tabla 
                de internacionalización y obtenemos el OID y la descripción internacionalizada de 
                todos los registros.
            * */
		UtilidadesLog.info("DAORegularizacion.obtenerSituacionesReclamo(DTOBelcorp dto): Entrada");
		StringBuffer sql=new StringBuffer();
		Vector	parametros = new Vector();

		sql.append(" SELECT sit.OID_SITU_RECL,");                                       
                                                                                
		sql.append(" (SELECT v.VAL_I18N FROM V_GEN_I18N_SICC v ");                      
		sql.append(" WHERE v.VAL_OID=sit.OID_SITU_RECL ");                              
		sql.append(" AND v.IDIO_OID_IDIO = ? ");                                        
		parametros.add(dto.getOidIdioma());						                                           
		sql.append(" AND v.ATTR_NUM_ATRI = 1 ");                                        
		sql.append(" AND v.ATTR_ENTI = 'CCC_SITUA_RECLA') AS DESC_SITUA_RECLA ");       
                                                                                
		sql.append(" FROM ");                                                           
		sql.append(" CCC_SITUA_RECLA sit ");

		RecordSet resultado = null;
		String codigoError = null;
		//Nº Incidencia:   BELC300008840 
        try{
            BelcorpService bs = UtilidadesEJB.getBelcorpService();		
            resultado = bs.dbService.executePreparedQuery(sql.toString(),parametros);
        } catch (Exception e) {
                this.logStackTrace(e);
                this.loguearSql("obtenerSiguienteNumero", sql.toString(),parametros);
                codigoError = CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS;
                throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));
		}
		DTOSalida dtoSalida = new DTOSalida();
		dtoSalida.setResultado(resultado);
        UtilidadesLog.info("DAORegularizacion.obtenerSituacionesReclamo(DTOBelcorp dto): Salida");
		return dtoSalida;
	}//metodo
    
    
    
    private MONMantenimientoSEG getIServicioSEG() throws MareException {
		
        UtilidadesLog.info("DAORegularizacion.getIServicioSEG(): Entrada");
        // Se obtiene el interfaz home
        MONMantenimientoSEGHome home = (MONMantenimientoSEGHome)UtilidadesEJB.getHome(
            "MONMantenimientoSEG", MONMantenimientoSEGHome.class);
            
        // Se obtiene el interfaz remoto
        MONMantenimientoSEG ejb = null;
        try {
            ejb = home.create();
        } catch (Exception e) {
            String codigoError = CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB;
			this.logStackTrace(e);
            throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));
        } 
        UtilidadesLog.info("DAORegularizacion.getIServicioSEG(): Salida");
        return ejb;
    }	

	private void logStackTrace(Throwable e) {
		try{
			UtilidadesLog.error(e);
		}catch(Exception ex){
			UtilidadesLog.error("Eror Logeando Pila: "+ex.getMessage());
		}
	}

	
	private void loguearSql(String metodo, String sql, Vector params){
		UtilidadesLog.debug(metodo + sql);
		if (params!=null && params.size()>0){
			String sParams="";
			for (int i=0; i<params.size();i++){
				sParams+="param "+ (i+1) + ": " + params.elementAt(i) + ", ";
			}
			UtilidadesLog.debug(metodo + sParams);
		}		
	}	
}
