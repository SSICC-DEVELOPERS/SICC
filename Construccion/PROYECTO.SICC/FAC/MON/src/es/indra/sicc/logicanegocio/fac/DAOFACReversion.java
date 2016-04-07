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

import es.indra.sicc.dtos.fac.DTOFACSecuenciaProcesos;
import es.indra.sicc.util.BelcorpService;
import es.indra.sicc.util.CodigosError;
import es.indra.sicc.util.UtilidadesEJB;
import es.indra.sicc.util.UtilidadesError;
import es.indra.sicc.util.UtilidadesLog;
import es.indra.sicc.util.UtilidadesPaginacion;
import es.indra.sicc.util.DTOOIDs;
import es.indra.sicc.util.DTOSalida;

import es.indra.sicc.dtos.fac.DTOFACCabeceraDocContable;
import es.indra.sicc.dtos.fac.DTOFACCabeceraSolicitud;
import es.indra.sicc.dtos.fac.DTOFACProcesoCierre;
import es.indra.sicc.dtos.ped.DTOSolicitudValidacion;
import es.indra.sicc.dtos.fac.DTOFACConsultaFacturas;

import java.util.Vector;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Date;

import java.text.SimpleDateFormat;

import java.math.BigDecimal;

public class DAOFACReversion  {

	private String usuario = null;

	public DAOFACReversion(String usuario) {
		this.usuario = usuario;
	}

	public DAOFACReversion() {
	}

	public void anularRegistroUnicoVentas (DTOFACCabeceraDocContable cabeceraDC) throws MareException {
        UtilidadesLog.info("DAOFACReversion.anularRegistroUnicoVentas (DTOFACCabeceraDocContable cabeceraDC): Entrada");
		StringBuffer sql = new StringBuffer("");
		Vector parametros = new Vector();

		sql.append(" UPDATE FAC_REGIS_UNICO_VENTA ");
		sql.append(" SET IND_ESTA = 1,  ");
        sql.append(" DCCA_OID_CABE = null ");
        
        sql.append(" WHERE DCCA_OID_CABE = ?  ");
        parametros.add(cabeceraDC.getOidCabeceraSolicitud());
        
        /* Se cambian los criterios 
		if (cabeceraDC.getSociedad()!=null){
			sql.append(" WHERE SOCI_OID_SOCI = ?  "); //cabeceraDC.sociedad
			parametros.add(cabeceraDC.getSociedad());			
		}else{
			sql.append(" WHERE SOCI_OID_SOCI IS NULL  "); //NULO		
		}

		if (cabeceraDC.getSubacceso()!=null){
			sql.append(" AND SBAC_OID_SBAC = ? "); //cabeceraDC.subacceso
			parametros.add(cabeceraDC.getSubacceso());
		}else{
			sql.append(" AND SBAC_OID_SBAC IS NULL "); //nULO			
		}

		if (cabeceraDC.getEjercicioDocumentoContableInterno()!=null){
			sql.append(" AND VAL_EJER_DOCU_INTE = ? ");//cabeceraDC.ejercicioDocumentoContableInterno
			parametros.add(cabeceraDC.getEjercicioDocumentoContableInterno());
		}else{
			sql.append(" AND VAL_EJER_DOCU_INTE IS NULL "); //nULO
		}

		if (cabeceraDC.getNumeroDocumentoInterno()!=null){
			sql.append(" AND NUM_DOCU_CONT_INTE = ? ");//cabeceraDC.numeroDocumentoInterno
			parametros.add(cabeceraDC.getNumeroDocumentoInterno());
		}else{
			sql.append(" AND NUM_DOCU_CONT_INTE IS NULL "); //nULO
		}*/
        
        

		BelcorpService bs = UtilidadesEJB.getBelcorpService();
		String codigoError = null;
		try {
			bs.dbService.executePreparedUpdate(sql.toString(), parametros);
		} catch (Exception e) {
			codigoError = CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS;
			UtilidadesLog.error("anularRegistroUnicoVentas: Exception",e);
			this.logSql("anularRegistroUnicoVentas. SQL: ",sql.toString(), parametros);
			throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));
		}
				
		UtilidadesLog.info("DAOFACReversion.anularRegistroUnicoVentas (DTOFACCabeceraDocContable cabeceraDC): Salida");
	}

	public void eliminarPosicionesDocumentoContable (DTOFACCabeceraDocContable cabeceraDC) throws MareException {
		UtilidadesLog.info("DAOFACReversion.eliminarPosicionesDocumentoContable (DTOFACCabeceraDocContable cabeceraDC): Entrada");
		// Elimina los registros de posición correspondientes a una cabecera 
		// de documento contable 

		StringBuffer sql = new StringBuffer("");
		Vector parametros = new Vector();

		sql.append(" DELETE ");
		sql.append(" FROM FAC_DOCUM_CONTA_LINEA "); // modificado por incidencia 17582
		sql.append(" WHERE DCCA_OID_CABE = ? "); //cabeceraDC.oidSolicitud
		parametros.add(cabeceraDC.getOidCabeceraSolicitud());

		BelcorpService bs = UtilidadesEJB.getBelcorpService();
		String codigoError = null;
		
		try {
			bs.dbService.executePreparedUpdate(sql.toString(), parametros);
		} catch (Exception e) {
			codigoError = CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS;
			UtilidadesLog.error("eliminarPosicionesDocumentoContable: Exception",e);
			this.logSql("eliminarPosicionesDocumentoContable. SQL: ",sql.toString(), parametros);
			throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));
		}
				
		UtilidadesLog.info("DAOFACReversion.eliminarPosicionesDocumentoContable (DTOFACCabeceraDocContable cabeceraDC): Salida");
	}

	public void actualizarPosicionesOrigen (ArrayList listaCabeceras) throws MareException {
		// Actualiza en BD los registros de posición correspondientes a las cabeceras de solicitud que recibe como 
		// parámetro, debido a un proceso de reversión de facturación. La solicitudes que recibe corresponden a un 
		// mismo consolidado. 

		UtilidadesLog.info("DAOFACReversion.actualizarPosicionesOrigen (ArrayList listaCabeceras): Entrada");

		Iterator iteCabec = null; 
		DTOFACCabeceraSolicitud dtoCabec = null;

		StringBuffer oids = new StringBuffer("");
		String listaOIDs = "";

		if(listaCabeceras.size()>0){
			iteCabec = listaCabeceras.iterator();
			while(iteCabec.hasNext()){
				dtoCabec = (DTOFACCabeceraSolicitud)iteCabec.next();
				oids.append(dtoCabec.getOidCabeceraSolicitud()+", ");
			}
			listaOIDs = oids.substring(0,oids.length()-2);		
		
			StringBuffer sql = new StringBuffer("");
			Vector parametros = new Vector();

			sql.append(" update PED_SOLIC_POSIC ");
			sql.append(" set NUM_CONS = null,  ");
			sql.append(" VAL_EJER_DOCU_CONT_INTE = null, ");
			sql.append(" NUM_DOCU_CONT_INTE = null, ");
			sql.append(" NUM_UNID_ATEN = 0 ");
			sql.append(" where SOCA_OID_SOLI_CABE in ("+listaOIDs+" )");
	
			BelcorpService bs = UtilidadesEJB.getBelcorpService();
			String codigoError = null;
			try {
				bs.dbService.executePreparedUpdate(sql.toString(), parametros);
			} catch (Exception e) {
				codigoError = CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS;
				UtilidadesLog.error("actualizarPosicionesOrigen: Exception",e);
				this.logSql("actualizarPosicionesOrigen. SQL: ",sql.toString(), parametros);
				throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));
			}
		}
		UtilidadesLog.info("DAOFACReversion.actualizarPosicionesOrigen (ArrayList listaCabeceras): Salida");
	}
	//eliminado por incidencia BELC300011141
	//public ArrayList obtenerMensajesFAC  (DTOFACCabeceraDocContable cabeceraDC) throws MareException {

	//incidencia BELC300011181
	public void eliminarConsolidado (DTOSolicitudValidacion  consolidado) throws MareException {
		UtilidadesLog.info("DAOFACReversion.eliminarConsolidado (DTOSolicitudValidacion  consolidado): Entrada");
		// Borra un registro de cabecera de solicitud correspondiente a un consolidado, 
		// debido a un proceso de reversión 
		StringBuffer sql = new StringBuffer("");
		Vector parametros = new Vector();

        String codigoError = null;
		BelcorpService bs = UtilidadesEJB.getBelcorpService();
		try {

            //INCIDENCIA BLOQUEANTE FAC-10 V3.5 (Gacevedo)
            //El constraint OWN_PERU.MVCC_SOCA_FK no permite borrar ped_solic_cabec
            //por lo que se setea a null el campo en ccc_movim_cuent_corri
            sql.append(" UPDATE CCC_MOVIM_CUENT_CORRI SET SOCA_OID_SOLI_CABE = NULL ");
            sql.append(" WHERE SOCA_OID_SOLI_CABE = "+consolidado.getOidSolicitud());
            sql.append(" AND EXISTS(SELECT * FROM ped_solic_cabec p WHERE p.OID_SOLI_CABE = "+consolidado.getOidSolicitud());
            sql.append("  AND p.IND_TS_NO_CONSO=0)");
            
            bs.dbService.executeUpdate(sql.toString());
            
            sql = new StringBuffer();
            sql.append(" DELETE ");
            sql.append(" FROM PED_SOLIC_CABEC ");
            sql.append(" WHERE OID_SOLI_CABE = ? "); //consolidado.oidCabeceraSolicitud
            parametros.add(consolidado.getOidSolicitud());
            
			bs.dbService.executePreparedUpdate(sql.toString(), parametros);
		} catch (Exception e) {
			codigoError = CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS;
			UtilidadesLog.error("eliminarConsolidado: Exception",e);
			this.logSql("eliminarConsolidado. SQL: ",sql.toString(), parametros);
			throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));
		}
		
		UtilidadesLog.info("DAOFACReversion.eliminarConsolidado (DTOSolicitudValidacion  consolidado): Salida");
	}

	public void eliminarAcumuladoImpuestos (DTOFACCabeceraSolicitud cabecera) throws MareException {
		UtilidadesLog.info("DAOFACReversion.eliminarAcumuladoImpuestos (DTOFACCabeceraSolicitud cabecera): Entrada");
		// Borra de BD los registros de impuestos acumulados correspondientes a un consolidado o a un 
		//documento contable

		StringBuffer sql = new StringBuffer("");
		Vector parametros = new Vector();
		
		if (cabecera instanceof DTOFACCabeceraDocContable) { 
			sql.append(" DELETE ");
			sql.append(" FROM FAC_DOCUM_CONTA_ACUMU_IMPUE ");
			sql.append(" WHERE DCCA_OID_CABE = ? "); //cabeceraDC.oidSolicitud
			parametros.add(cabecera.getOidCabeceraSolicitud());
		} else {
			sql.append(" DELETE ");
			sql.append(" FROM PED_SOLIC_ACUMU_IMPUE  ");
			sql.append(" WHERE SOCA_OID_SOLI_CABE = ? "); //cabeceraDC.oidCabeceraSolicitud
			parametros.add(cabecera.getOidCabeceraSolicitud());
		}
		
		BelcorpService bs = UtilidadesEJB.getBelcorpService();
		String codigoError = null;
		try {
			bs.dbService.executePreparedUpdate(sql.toString(), parametros);
		} catch (Exception e) {
			codigoError = CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS;
			UtilidadesLog.error("eliminarAcumuladoImpuestos: Exception",e);
			this.logSql("eliminarAcumuladoImpuestos. SQL: ",sql.toString(), parametros);
			throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));
		}
		
		UtilidadesLog.info("DAOFACReversion.eliminarAcumuladoImpuestos (DTOFACCabeceraSolicitud cabecera): Salida");
	}

	public ArrayList obtenerSolicitudesOrigen (DTOSolicitudValidacion consolidado) throws MareException {
		UtilidadesLog.info("DAOFACReversion.obtenerSolicitudesOrigen (DTOSolicitudValidacion consolidado): Entrada");
		
		StringBuffer sql = new StringBuffer("");
		Vector parametros = new Vector();

		sql.append(" select ACFI_OID_ACCE_FISI as ACCESOFISICO,  ");
		sql.append(" ALMC_OID_ALMA as ALMACEN,  ");
		sql.append(" CLSO_OID_CLAS_SOLI as CLASESOLICITUD, ");
		sql.append(" CLAS_OID_CLAS_FLET as CLASIFICACION, ");
		sql.append(" CLIE_OID_CLIE as OIDCLIENTE, ");
		sql.append(" CLIE_OID_CONS_ASOC as CONSULTORAASOCIADA, ");
		sql.append(" TCCL_OID_TCCL_FLET as TIPOCLASIFICACION,  ");
		sql.append(" ESSO_OID_ESTA_SOLI as ESTADO, ");
		sql.append(" CLIE_OID_CLIE_DEST as DESTINATARIO, ");
		sql.append(" FEC_CRON as FECHA, ");
		sql.append(" FEC_FACT as FECHAFACTURACION,  ");
		sql.append(" FEC_PROG_FACT as FECHAPREVISTAFACTURACION,  ");
		sql.append(" FOPA_OID_FORM_PAGO as FORMAPAGO, ");
		sql.append(" GRPR_OID_GRUP_PROC as GRUPOPROCESOS,  ");
		sql.append(" IND_APLI_MANU as INDICADORAPLICACIONMANUAL, ");
		sql.append(" IND_ESTA as INDICADORESTADISTICABLE, ");
		sql.append(" IND_EXEN_FLET as INDIDCADOREXENTOFLETE,  ");
		sql.append(" IND_GENE_CC as INDICADORGENERACUENTACORRIENTE, ");
		sql.append(" IND_IMPR as INDICADORIMPRESION, ");
		sql.append(" TAIM_OID_TASA_IMPU as INDICADORIMPUESTOSFLETE,  ");
		sql.append(" IND_OC as INDICADORORDENCOMPRA, ");
		sql.append(" IND_PEDI_PRUE as INDICADORPEDIDOPRUEBA,  ");
		sql.append(" IND_PERM_UNIO_SOL as PERMITEUNIONSOLICITUDES, ");
		sql.append(" IND_TS_NO_CONSO as INDICADORTSNOCONSOLIDADO, ");
		sql.append(" INRE_OID_INDI_REVI as INDICADORREVISION,  ");  //pperez Incidencia BELC300023071

		//marca -> se saca de la relación con CRA_PERIO a través del campo PERD_OID_PERI de la tabla PED_SOLIC_CABEC
		sql.append(" (select MARC_OID_MARC from CRA_PERIO where OID_PERI = PERD_OID_PERI) as MARCA, ");
		sql.append(" MODU_OID_MODU as MODULO,  ");
		sql.append(" MONE_OID_MONE as MONEDA, ");
		sql.append(" NUM_CLIEN as NUMEROCLIENTES,  ");
		//numeroConsolidado -> si SOCA_OID_SOLI_CABE <> null, se accede por OID_SOLI_CABE = SOCA_OID_SOLI_CABE y se 
        //obtiene el campo VAL_NUME_SOLI 
		sql.append(" DECODE(SC.SOCA_OID_SOLI_CABE,NULL,NULL,(SELECT VAL_NUME_SOLI FROM PED_SOLIC_CABEC SCA WHERE SCA.OID_SOLI_CABE = SC.SOCA_OID_SOLI_CABE) ) as NUMEROCONSOLIDADO, ");
		sql.append(" NUM_DOCU_ORIG as NUMERODOCUMENTOORIGEN, ");
		sql.append(" NUM_PREM as NUMEROPREMIO, ");
		//numeroSecuenciaFacturacionDiaria -> se accede a la tabla PED_SOLIC_CABE_SECUE usando OID_SOLI_CABE, y se 
		//obtiene NUM_SECU_FACT_DIAR
		sql.append(" (select NUM_SECU_FACT_DIAR from PED_SOLIC_CABEC_SECUE where SOCA_OID_SOLI_CABE = OID_SOLI_CABE) as NUMEROSECUENCIAFACDIARIA, ");
		//numeroSecuenciaZonaRuta -> se accede a la tabla PED_SOLIC_CABE_SECUE usando OID_SOLI_CABE, y se 
		//obtiene NUM_SECU_ZONA_RUTA
		sql.append(" (select NUM_SECU_ZONA_RUTA from  PED_SOLIC_CABEC_SECUE where SOCA_OID_SOLI_CABE = OID_SOLI_CABE) as NUMEROSECUENCIAZONARUTA, ");
		sql.append(" OID_SOLI_CABE as OIDCABECERASOLICITUD,  ");
		sql.append(" SOCA_OID_SOLI_CABE as OIDCONSOLIDADO,  ");
		sql.append(" CLDI_OID_CLIE_DIRE as OIDDIRECCIONCLIENTE, ");
		sql.append(" CLIE_OID_CLIE_PAGA as OIDPAGADORFACTURA, ");
		sql.append(" OPER_OID_OPER as OPERACION, ");
		sql.append(" PAIS_OID_PAIS as PAIS, ");
		sql.append(" PERD_OID_PERI as PERIODO,  ");
		sql.append(" PROC_OID_PROC as PROCESO,  ");
		sql.append(" VAL_PREC_NETO_TOTA_LOCA as PRECIOTOTALTOTALLOCAL,  ");
		sql.append(" VAL_PREC_NETO_TOTA_DOCU as PRECIOTOTALTOTALDOCUMENTO,  ");
		sql.append(" VAL_PUNT_EMIS as PUNTOEMISION,  ");
		sql.append(" CLIE_OID_CLIE_RECE_FACT as RECEPTORFACTURA,  ");
		//region -> se accede a la tabla ZON_ZONA usando ZZON_OID_ZONA y se obtiene ZORG_OID_REGI, 
		sql.append(" ( select zorg_oid_regi from zon_zona where oid_zona = ZZON_OID_ZONA ) as REGION, ");
		//seccion -> se accede a la tabla ZON_TERRI_ADMI usando ZTAD_OID_TERR_ADMI, y se obtiene OID_SECC,
		sql.append(" ( select ZSCC_OID_SECC from ZON_TERRI_ADMIN where oid_terr_admi = ZTAD_OID_TERR_ADMI ) as SECCION, ");
		//secuenciaRutaTerritorio -> se accede a la tabla PED_SOLIC_CABE_SECUE usando OID_SOLI_CABE, y se 
		//obtiene VAL_SECU_RUTA_TERR 
		sql.append(" ( select VAL_SECU_RUTA_TERR from PED_SOLIC_CABEC_SECUE where SOCA_OID_SOLI_CABE = OID_SOLI_CABE )as SECUENCIARUTATERRITORIO, ");
		sql.append(" SBAC_OID_SBAC as SUBACCESO, ");
		sql.append(" SBTI_OID_SUBT_CLIE as SUBTIPOCLIENTE,  ");
		sql.append(" ZTAD_OID_TERR_ADMI as TERRITORIOCLIENTE, ");
		sql.append(" SOCA_OID_DOCU_REFE as OIDDOCUMENTOREFERENCIA, ");
		sql.append(" SOCI_OID_SOCI as SOCIEDAD,  ");
		sql.append(" TDOC_OID_TIPO_DOCU as TIPODOCUMENTO, ");
		sql.append(" TIDO_OID_TIPO_DOCU as TIPODOCUMENTOLEGAL, ");
		sql.append(" TERR_OID_TERR as TERRITORIO, ");
		sql.append(" TICL_OID_TIPO_CLIE as TIPOCLIENTE, ");
		sql.append(" TIDS_OID_TIPO_DESP as TIPODESPACHO, ");
		sql.append(" TSPA_OID_TIPO_SOLI_PAIS as TIPOSOLICITUD, ");
		sql.append(" TSPA_OID_TIPO_SOLI_PAIS_CONS as TIPOSOLICITUDCONSOLIDADO,  ");
		sql.append(" VAL_BASE_FLET_DOCU as BASEFLETEDOCUMENTO,  ");
		sql.append(" VAL_BASE_FLET_LOCA as BASEFLETELOCAL, ");
		sql.append(" VAL_GLOS_OBSE as OBSERVACIONES, ");
		sql.append(" VAL_IMPO_DESC_1_TOTA_DOCU as IMPORTEDES1TD,  ");
		sql.append(" VAL_IMPO_DESC_1_TOTA_LOCA as IMPORTEDES1TL,  ");
		sql.append(" VAL_IMPO_DESC_3_TOTA_DOCU as IMPORTEDES3TD,  ");
		sql.append(" VAL_IMPO_DESC_3_TOTA_LOCA as IMPORTEDES3TL,  ");
		sql.append(" VAL_IMPO_DESC_TOTA_DOCU as IMPORTEDESTD,  ");
		sql.append(" VAL_IMPO_DESC_TOTA_LOCA as IMPORTEDESTL, ");
		sql.append(" VAL_IMPO_FLET_DOCU as IMPORTEFLETEDOCUMENTO, ");
		sql.append(" VAL_IMPO_FLET_LOCA as IMPORTEFLETELOCAL,  ");
		sql.append(" VAL_IMPO_FLET_SIN_IMPU_TOTA as IMPORTEFLETESINIMPUESTOSTL, ");
		sql.append(" VAL_IMPO_FLET_SIN_IMPU_DOCU as IMPORTEFLETESINIMPUESTOSTD, ");
		sql.append(" VAL_IMPO_FLET_TOTA_DOCU as IMPORTEFLETETOTALDOCUMENTO,  ");
		sql.append(" VAL_IMPO_FLET_TOTA_LOCA as IMPORTEFLETETOTALLOCAL,  ");
		sql.append(" VAL_NUME_SOLI as NUMEROSOLICITUD,  ");
		sql.append(" VAL_OTRO_RECA_DOCU as OTROSRECARGOSDOCUMENTO,  ");
		sql.append(" VAL_OTRO_RECA_LOCA as OTROSRECARGOSLOCAL,  ");
		sql.append(" VAL_PREC_CONT_TOTA_LOCA as PRECIOCONTABLETOTALLOCAL,  ");
		sql.append(" VAL_RECA_FLET_DOCU as RECARGOFLETEDOCUMENTO,  ");
		sql.append(" VAL_RECA_FLET_LOCA as RECARGOFLETELOCAL,  ");
		sql.append(" VAL_TIPO_CAMB as TIPOCAMBIO,  ");
		sql.append(" VAL_TOTA_FLET_DOCU as TOTALFLETEDOCUMENTO,  ");
		sql.append(" VAL_TOTA_FLET_LOCA as TOTALFLETELOCAL,  ");
		sql.append(" VAL_TOTA_PAGA_DOCU as TOTALAPAGARDOCUMENTO,  ");
		sql.append(" VAL_TOTA_PAGA_LOCA as TOTALAPAGARLOCAL,  ");
		sql.append(" VAL_USUA as USUARIO,  ");
		sql.append(" ZZON_OID_ZONA as ZONA,  ");
		sql.append(" VEPO_OID_VALO_ESTR_GEOP as UBIGEO,  ");
		sql.append(" NUM_DOCU_CONT_INTE as NUMERODOCUMENTOCONTABLEINTERNO  ");
		sql.append(" from PED_SOLIC_CABEC SC ");
		sql.append(" where SOCA_OID_SOLI_CABE = ? "); //consolidado.oidCabeceraSolicitud 
		parametros.add(consolidado.getOidSolicitud());

		BelcorpService bs = null;
		bs = BelcorpService.getInstance();

		RecordSet rs = null;

		// Obtenemos todos los registros
		try{
			rs = bs.dbService.executePreparedQuery(sql.toString(),parametros);
		} catch(Exception e) {
			UtilidadesLog.error(" obtenerSolicitudesOrigen:",e);
			this.logSql(" obtenerSolicitudesOrigen. SQL: ",sql.toString(),parametros);
			throw new MareException(e, UtilidadesError.armarCodigoError(
							CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS));
		}

		int tamanyo = rs.getRowCount();
		ArrayList salida = new ArrayList(tamanyo);
        DTOFACCabeceraSolicitud  dto =  null;
		for(int i=0; i<tamanyo; i++){
			
			dto = new DTOFACCabeceraSolicitud();			                                      
			                                 
			if(rs.getValueAt(i,"ACCESOFISICO")!=null){
				dto.setAccesoFisico(new Long(((BigDecimal)rs.getValueAt(i,"ACCESOFISICO")).longValue()));
			}

			if(rs.getValueAt(i,"ALMACEN")!=null){
				dto.setAlmacen(new Long(((BigDecimal)rs.getValueAt(i,"ALMACEN")).longValue()));
			}

			if(rs.getValueAt(i,"CLASESOLICITUD")!=null){
				dto.setClaseSolicitud(new Long(((BigDecimal)rs.getValueAt(i,"CLASESOLICITUD")).longValue()));
			}
			if(rs.getValueAt(i,"CLASIFICACION")!=null){
				dto.setClasificacion(new Long(((BigDecimal)rs.getValueAt(i,"CLASIFICACION")).longValue()));
			}
			if(rs.getValueAt(i,"OIDCLIENTE")!=null){
				dto.setOidCliente(new Long(((BigDecimal)rs.getValueAt(i,"OIDCLIENTE")).longValue()));
			}           
			if(rs.getValueAt(i,"CONSULTORAASOCIADA")!=null){
				dto.setConsultoraAsociada(new Long(((BigDecimal)rs.getValueAt(i,"CONSULTORAASOCIADA")).longValue()));
			}
			if(rs.getValueAt(i,"TIPOCLASIFICACION")!=null){
				dto.setTipoClasificacion(new Long(((BigDecimal)rs.getValueAt(i,"TIPOCLASIFICACION")).longValue()));
			}
			if(rs.getValueAt(i,"ESTADO")!=null){
				dto.setEstado(new Long(((BigDecimal)rs.getValueAt(i,"ESTADO")).longValue()));
			}
			if(rs.getValueAt(i,"DESTINATARIO")!=null){
				dto.setDestinatario(new Long(((BigDecimal)rs.getValueAt(i,"DESTINATARIO")).longValue()));
			}
			if(rs.getValueAt(i,"FECHA") != null){
				dto.setFecha((Date)rs.getValueAt(i,"FECHA"));
			}
			if(rs.getValueAt(i,"FECHAFACTURACION") != null){
				dto.setFechaFacturacion((Date)rs.getValueAt(i,"FECHAFACTURACION"));
			}
			if(rs.getValueAt(i,"FECHAPREVISTAFACTURACION") != null){
				dto.setFechaPrevistaFacturacion((Date)rs.getValueAt(i,"FECHAPREVISTAFACTURACION"));
			}
			if(rs.getValueAt(i,"FORMAPAGO")!=null){
				dto.setFormaPago(new Long(((BigDecimal)rs.getValueAt(i,"FORMAPAGO")).longValue()));
			}
			if(rs.getValueAt(i,"GRUPOPROCESOS")!=null){		
				dto.setGrupoProcesos(new Long(((BigDecimal)rs.getValueAt(i,"GRUPOPROCESOS")).longValue()));
			}
			if(rs.getValueAt(i,"INDICADORAPLICACIONMANUAL")!=null){
				dto.setIndicadorAplicacionManual(new Boolean(((BigDecimal)rs.getValueAt(i, 
											"INDICADORAPLICACIONMANUAL")).intValue() == 1 ? true : false));
			}
			if(rs.getValueAt(i,"INDICADORESTADISTICABLE")!=null){	
				dto.setIndicadorEstadisticable(new Boolean(((BigDecimal)rs.getValueAt(i, 
										"INDICADORESTADISTICABLE")).intValue() == 1 ? true : false));
			}
			if(rs.getValueAt(i,"INDICADOREXENTOFLETE")!=null){
					dto.setIndicadorExentoFlete(new Boolean(((BigDecimal)rs.getValueAt(i, 
										"INDICADOREXENTOFLETE")).intValue() == 1 ? true : false));
			}             
							
			if(rs.getValueAt(i,"INDICADORGENERACUENTACORRIENTE")!=null){
				dto.setIndicadorGeneraCuentaCorriente(new Boolean(((BigDecimal)rs.getValueAt(i, 
										"INDICADORGENERACUENTACORRIENTE")).intValue() == 1 ? true : false));
			}
				
			if(rs.getValueAt(i,"INDICADORIMPRESION")!=null){
				dto.setIndicadorImpresion(new Boolean(((BigDecimal)rs.getValueAt(i, 
										"INDICADORIMPRESION")).intValue() == 1 ? true : false));
			}
			
			if(rs.getValueAt(i,"INDICADORIMPUESTOSFLETE")!=null){
				dto.setIndicadorImpuestosFlete(new Long(((BigDecimal)rs.getValueAt(i, 
										"INDICADORIMPUESTOSFLETE")).longValue()));
			}
			if(rs.getValueAt(i,"INDICADORORDENCOMPRA")!=null){
				dto.setIndicadorOrdenCompra(new Boolean(((BigDecimal)rs.getValueAt(i, 
										"INDICADORORDENCOMPRA")).intValue() == 1 ? true : false));
			}
				
			if(rs.getValueAt(i,"INDICADORPEDIDOPRUEBA")!=null){
				dto.setIndicadorPedidoPrueba(new Boolean(((BigDecimal)rs.getValueAt(i, 
										"INDICADORPEDIDOPRUEBA")).intValue() == 1 ? true : false));
			}
				
			if(rs.getValueAt(i,"PERMITEUNIONSOLICITUDES")!=null){
				dto.setPermiteUnionSolicitudes(new Boolean(((BigDecimal)rs.getValueAt(i, 
											"PERMITEUNIONSOLICITUDES")).intValue() == 1 ? true : false));
			}
			if(rs.getValueAt(i,"INDICADORTSNOCONSOLIDADO")!=null){
				dto.setIndTSNoConsolidado(new Boolean(((BigDecimal)rs.getValueAt(i, 
									"INDICADORTSNOCONSOLIDADO")).intValue() == 1 ? true : false));
			}
			if (rs.getValueAt(i,"INDICADORREVISION")!=null) {
				dto.setIndicadorRevision(new Long(((BigDecimal)rs.getValueAt(i,"INDICADORREVISION")).longValue()));
			}
                                                                                                                 		
			if(rs.getValueAt(i,"MARCA")!=null){
				dto.setMarca(new Long(((BigDecimal)rs.getValueAt(i,"MARCA")).longValue()));
			}
			if(rs.getValueAt(i,"MODULO")!=null){
				dto.setModulo(new Long(((BigDecimal)rs.getValueAt(i,"MODULO")).longValue()));
			}
			if(rs.getValueAt(i,"MONEDA")!=null){
				dto.setMoneda(new Long(((BigDecimal)rs.getValueAt(i,"MONEDA")).longValue()));
			}
			if(rs.getValueAt(i,"NUMEROCLIENTES")!=null){
				dto.setNumeroClientes(new Integer(((BigDecimal)rs.getValueAt(i,"NUMEROCLIENTES")).intValue()));
			}
			if(rs.getValueAt(i,"NUMEROCONSOLIDADO")!=null){
				dto.setNumeroConsolidado(new Long(rs.getValueAt(i,"NUMEROCONSOLIDADO").toString()));
			}
			if(rs.getValueAt(i,"NUMERODOCUMENTOORIGEN")!=null){
				dto.setNumeroDocumentoOrigen(new Long(((BigDecimal)rs.getValueAt(i,"NUMERODOCUMENTOORIGEN")).longValue()));
			}
			if(rs.getValueAt(i,"NUMEROPREMIO")!=null){
				dto.setNumeroPremio(new Integer(((BigDecimal)rs.getValueAt(i,"NUMEROPREMIO")).intValue()));
			}
			if(rs.getValueAt(i,"NUMEROSECUENCIAFACDIARIA")!=null){     
				dto.setNumeroSecuenciaFacturacionDiaria(new Integer(((BigDecimal)rs.getValueAt(i,"NUMEROSECUENCIAFACDIARIA")).intValue()));
			}
			if(rs.getValueAt(i,"NUMEROSECUENCIAZONARUTA")!=null){     
				dto.setNumeroSecuenciaZonaRuta(new Integer(((BigDecimal)rs.getValueAt(i,"NUMEROSECUENCIAZONARUTA")).intValue()));
			}
			if(rs.getValueAt(i,"OIDCABECERASOLICITUD")!=null){
				dto.setOidCabeceraSolicitud(new Long(((BigDecimal)rs.getValueAt(i,"OIDCABECERASOLICITUD")).longValue()));
			}
			if(rs.getValueAt(i,"OIDCONSOLIDADO")!=null){
				dto.setOidConsolidado(new Long(((BigDecimal)rs.getValueAt(i,"OIDCONSOLIDADO")).longValue()));
			}
			if(rs.getValueAt(i,"OIDDIRECCIONCLIENTE")!=null){
				dto.setOidDireccionCliente(new Long(((BigDecimal)rs.getValueAt(i,"OIDDIRECCIONCLIENTE")).longValue()));
			}
			if(rs.getValueAt(i,"OIDPAGADORFACTURA")!=null){
				dto.setOidPagadorFactura(new Long(((BigDecimal)rs.getValueAt(i,"OIDPAGADORFACTURA")).longValue()));
			}
			if(rs.getValueAt(i,"OPERACION")!=null){
				dto.setOperacion(new Long(((BigDecimal)rs.getValueAt(i,"OPERACION")).longValue()));
			}                          
		                                                                          		
			if(rs.getValueAt(i,"PAIS")!=null){
				dto.setOidPais(new Long(((BigDecimal)rs.getValueAt(i,"PAIS")).longValue()));
			}
			if(rs.getValueAt(i,"PERIODO")!=null){
				dto.setPeriodo(new Long(((BigDecimal)rs.getValueAt(i,"PERIODO")).longValue()));
			}
			if(rs.getValueAt(i,"PROCESO")!=null){
				dto.setProceso(new Long(((BigDecimal)rs.getValueAt(i,"PROCESO")).longValue()));
			}
			if(rs.getValueAt(i,"PRECIOTOTALTOTALLOCAL")!=null){
				dto.setPrecioTotalTotalLocal(new Float(((BigDecimal)rs.getValueAt(i,"PRECIOTOTALTOTALLOCAL")).floatValue()));
			}
			if(rs.getValueAt(i,"PRECIOTOTALTOTALDOCUMENTO")!=null){
				dto.setPrecioTotalTotalDocumento(new Float(((BigDecimal)rs.getValueAt(i,"PRECIOTOTALTOTALDOCUMENTO")).floatValue()));
			}
			if(rs.getValueAt(i,"PUNTOEMISION")!=null){
				dto.setPuntoEmision(rs.getValueAt(i,"PUNTOEMISION").toString());
			}
			if(rs.getValueAt(i,"RECEPTORFACTURA")!=null){
				dto.setReceptorFactura(new Long(((BigDecimal)rs.getValueAt(i,"RECEPTORFACTURA")).longValue()));
			}
			if(rs.getValueAt(i,"REGION")!=null){
				dto.setRegion(new Long(((BigDecimal)rs.getValueAt(i,"REGION")).longValue()));
			}
			if(rs.getValueAt(i,"SECCION")!=null){
				dto.setSeccion(new Long(((BigDecimal)rs.getValueAt(i,"SECCION")).longValue()));
			}
			if(rs.getValueAt(i,"SECUENCIARUTATERRITORIO")!=null){
				dto.setSecuenciaRutaTerritorio(rs.getValueAt(i,"SECUENCIARUTATERRITORIO").toString());
			}
                                               
			if(rs.getValueAt(i,"SUBACCESO")!=null){
				dto.setSubacceso(new Long(((BigDecimal)rs.getValueAt(i,"SUBACCESO")).longValue()));
			}
			if(rs.getValueAt(i,"SUBTIPOCLIENTE")!=null){
				dto.setSubtipoCliente(new Long(((BigDecimal)rs.getValueAt(i,"SUBTIPOCLIENTE")).longValue()));
			}
			if(rs.getValueAt(i,"TERRITORIOCLIENTE")!=null){
				dto.setTerritorioCliente(new Long(((BigDecimal)rs.getValueAt(i,"TERRITORIOCLIENTE")).longValue()));
			}
			if(rs.getValueAt(i,"OIDDOCUMENTOREFERENCIA")!=null){
				dto.setOidDocumentoReferencia(new Long(((BigDecimal)rs.getValueAt(i,"OIDDOCUMENTOREFERENCIA")).longValue()));
			}
			if(rs.getValueAt(i,"SOCIEDAD")!=null){
				dto.setSociedad(new Long(((BigDecimal)rs.getValueAt(i,"SOCIEDAD")).longValue()));
			}
			if(rs.getValueAt(i,"TIPODOCUMENTO")!=null){
				dto.setTipoDocumento(new Long(((BigDecimal)rs.getValueAt(i,"TIPODOCUMENTO")).longValue()));
			}
			if(rs.getValueAt(i,"TIPODOCUMENTOLEGAL")!=null){
				dto.setTipoDocumentoLegal(new Long(((BigDecimal)rs.getValueAt(i,"TIPODOCUMENTOLEGAL")).longValue()));
			}
   
			if(rs.getValueAt(i,"TERRITORIO")!=null){
				dto.setTerritorio(new Long(((BigDecimal)rs.getValueAt(i,"TERRITORIO")).longValue()));
			}
			if(rs.getValueAt(i,"TIPOCLIENTE")!=null){
				dto.setTipoCliente(new Long(((BigDecimal)rs.getValueAt(i,"TIPOCLIENTE")).longValue()));
			}
			if(rs.getValueAt(i,"TIPODESPACHO")!=null){
				dto.setTipoDespacho(new Long(((BigDecimal)rs.getValueAt(i,"TIPODESPACHO")).longValue()));
			}
			if(rs.getValueAt(i,"TIPOSOLICITUD")!=null){
				dto.setTipoSolicitud(new Long(((BigDecimal)rs.getValueAt(i,"TIPOSOLICITUD")).longValue()));
			}
			if(rs.getValueAt(i,"TIPOSOLICITUDCONSOLIDADO")!=null){
				dto.setTipoSolicitudConsolidado(new Long(((BigDecimal)rs.getValueAt(i,"TIPOSOLICITUDCONSOLIDADO")).longValue()));
			}
			if(rs.getValueAt(i,"BASEFLETEDOCUMENTO")!=null){
				dto.setBaseFleteDocumento(new Float(((BigDecimal)rs.getValueAt(i,"BASEFLETEDOCUMENTO")).floatValue()));
			}
			if(rs.getValueAt(i,"BASEFLETELOCAL")!=null){
				dto.setBaseFleteLocal(new Float(((BigDecimal)rs.getValueAt(i,"BASEFLETELOCAL")).floatValue()));
			}
			if(rs.getValueAt(i,"OBSERVACIONES")!=null){
				dto.setObservaciones(rs.getValueAt(i,"OBSERVACIONES").toString());
			}

			if(rs.getValueAt(i,"IMPORTEDES1TD")!=null){
				dto.setImporteDescuento1TotalDocumento(new Float(((BigDecimal)rs.getValueAt(i,"IMPORTEDES1TD")).floatValue()));
			}
			if(rs.getValueAt(i,"IMPORTEDES1TL")!=null){
				dto.setImporteDescuento1TotalLocal(new Float(((BigDecimal)rs.getValueAt(i,"IMPORTEDES1TL")).floatValue()));
			}
			if(rs.getValueAt(i,"IMPORTEDES3TD")!=null){
				dto.setImporteDescuento3TotalDocumento(new Float(((BigDecimal)rs.getValueAt(i,"IMPORTEDES3TD")).floatValue()));
			}
			if(rs.getValueAt(i,"IMPORTEDES3TL")!=null){
				dto.setImporteDescuento3TotalLocal(new Float(((BigDecimal)rs.getValueAt(i,"IMPORTEDES3TL")).floatValue()));
			}
			if(rs.getValueAt(i,"IMPORTEDESTD")!=null){
				dto.setImporteDescuentoTotalDocumento(new Float(((BigDecimal)rs.getValueAt(i,"IMPORTEDESTD")).floatValue()));
			}
			if(rs.getValueAt(i,"IMPORTEDESTL")!=null){
				dto.setImporteDescuentoTotalLocal(new Float(((BigDecimal)rs.getValueAt(i,"IMPORTEDESTL")).floatValue()));
			}

			if(rs.getValueAt(i,"IMPORTEFLETEDOCUMENTO")!=null){
				dto.setImporteFleteDocumento(new Float(((BigDecimal)rs.getValueAt(i,"IMPORTEFLETEDOCUMENTO")).floatValue()));
			}
			if(rs.getValueAt(i,"IMPORTEFLETELOCAL")!=null){
				dto.setImporteFleteLocal(new Float(((BigDecimal)rs.getValueAt(i,"IMPORTEFLETELOCAL")).floatValue()));
			}
			if(rs.getValueAt(i,"IMPORTEFLETESINIMPUESTOSTL")!=null){
				dto.setImporteFleteSinImpuestosTotalLocal(new Float(((BigDecimal)rs.getValueAt(i,"IMPORTEFLETESINIMPUESTOSTL")).floatValue()));
			}
			if(rs.getValueAt(i,"IMPORTEFLETESINIMPUESTOSTD")!=null){
				dto.setImporteFleteSinImpuestosTotalDocumento(new Float(((BigDecimal)rs.getValueAt(i,"IMPORTEFLETESINIMPUESTOSTD")).floatValue()));
			}
			if(rs.getValueAt(i,"IMPORTEFLETETOTALDOCUMENTO")!=null){
				dto.setImporteFleteTotalDocumento(new Float(((BigDecimal)rs.getValueAt(i,"IMPORTEFLETETOTALDOCUMENTO")).floatValue()));
			}
			if(rs.getValueAt(i,"IMPORTEFLETETOTALLOCAL")!=null){
				dto.setImporteFleteTotalLocal(new Float(((BigDecimal)rs.getValueAt(i,"IMPORTEFLETETOTALLOCAL")).floatValue()));
			}
			if(rs.getValueAt(i,"NUMEROSOLICITUD")!=null){
				dto.setNumeroSolicitud(new Long(((BigDecimal)rs.getValueAt(i,"NUMEROSOLICITUD")).longValue()));
			}
   
			if(rs.getValueAt(i,"OTROSRECARGOSDOCUMENTO")!=null){
				dto.setOtrosRecargosDocumento(new Float(((BigDecimal)rs.getValueAt(i,"OTROSRECARGOSDOCUMENTO")).floatValue()));
			}
			if(rs.getValueAt(i,"OTROSRECARGOSLOCAL")!=null){
				dto.setOtrosRecargosLocal(new Float(((BigDecimal)rs.getValueAt(i,"OTROSRECARGOSLOCAL")).floatValue()));
			}
			if(rs.getValueAt(i,"PRECIOCONTABLETOTALLOCAL")!=null){
				dto.setPrecioContableTotalLocal(new Float(((BigDecimal)rs.getValueAt(i,"PRECIOCONTABLETOTALLOCAL")).floatValue()));
			}
			if(rs.getValueAt(i,"RECARGOFLETEDOCUMENTO")!=null){
				dto.setRecargoFleteDocumento(new Float(((BigDecimal)rs.getValueAt(i,"RECARGOFLETEDOCUMENTO")).floatValue()));
			}
			if(rs.getValueAt(i,"RECARGOFLETELOCAL")!=null){
				dto.setRecargoFleteLocal(new Float(((BigDecimal)rs.getValueAt(i,"RECARGOFLETELOCAL")).floatValue()));
			}
			if(rs.getValueAt(i,"TIPOCAMBIO")!=null){
				dto.setTipoCambio((BigDecimal)rs.getValueAt(i,"TIPOCAMBIO"));
			}

			if(rs.getValueAt(i,"TOTALFLETEDOCUMENTO")!=null){
				dto.setTotalFleteDocumento(new Float(((BigDecimal)rs.getValueAt(i,"TOTALFLETEDOCUMENTO")).floatValue()));
			}

			if(rs.getValueAt(i,"TOTALFLETELOCAL")!=null){
				dto.setTotalFleteLocal(new Float(((BigDecimal)rs.getValueAt(i,"TOTALFLETELOCAL")).floatValue()));
			}
			if(rs.getValueAt(i,"TOTALAPAGARDOCUMENTO")!=null){
				dto.setTotalAPagarDocumento(new Float(((BigDecimal)rs.getValueAt(i,"TOTALAPAGARDOCUMENTO")).floatValue()));
			}
			if(rs.getValueAt(i,"TOTALAPAGARLOCAL")!=null){
				dto.setTotalAPagarLocal(new Float(((BigDecimal)rs.getValueAt(i,"TOTALAPAGARLOCAL")).floatValue()));
			}
			if(rs.getValueAt(i,"USUARIO")!=null){
				dto.setUsuario( rs.getValueAt(i,"USUARIO").toString());
			}
			if(rs.getValueAt(i,"ZONA")!=null){
				dto.setZona(new Long(((BigDecimal)rs.getValueAt(i,"ZONA")).longValue()));
			}
			if(rs.getValueAt(i,"UBIGEO")!=null){
				dto.setUbigeo(new Long(((BigDecimal)rs.getValueAt(i,"UBIGEO")).longValue()));
			}            
		
			if(rs.getValueAt(i,"NUMERODOCUMENTOCONTABLEINTERNO")!=null){
				dto.setNumeroDocumentoContableInterno(new Long(((BigDecimal)rs.getValueAt(i,"NUMERODOCUMENTOCONTABLEINTERNO")).longValue()));
			}        
			salida.add(dto);
		}
		
		UtilidadesLog.info("DAOFACReversion.obtenerSolicitudesOrigen (DTOSolicitudValidacion consolidado): Salida");
		return salida;
	}

    // ************ Modificado ***************
	public void actualizarSolicitudesOrigen (DTOSolicitudValidacion consolidado, String grupoReversion, Long grupoProcesos,ArrayList secuenciaProcesosGP4 ) throws MareException {
		UtilidadesLog.info("DAOFACReversion.actualizarSolicitudesOrigen (DTOSolicitudValidacion consolidado, String grupoReversion, Long grupoProcesos,ArrayList secuenciaProcesosGP4 ): Entrada");
		// Actualiza las cabeceras de solicitud origen correspondientes a un consolidado
					
		StringBuffer sql = new StringBuffer("");
		Vector parametros = new Vector();

        /* 
         * CAMBIO X MAIL A JUAN FRANCISCO
         * En vez de actualizar se elimina el registro para
         * poder despues eliminar el consolidado
         * 
         */
         
        sql.append(" DELETE ");
        sql.append(" FROM PED_SOLIC_CABEC_SECUE "); 
        sql.append(" WHERE SOCA_OID_SOLI_CABE = ? ");
        parametros.add(consolidado.getOidSolicitud());
    

        /*
        // se actualiza la secuencia asociada al consolidado
        sql.append(" UPDATE PED_SOLIC_CABEC_SECUE ");
		sql.append(" SET RUTR_OID_RUTA_TRAN = null, ");
		sql.append(" NUM_SECU_FACT_DIAR = null, ");
		sql.append(" VAL_SECU_RUTA_TERR = null, ");
		sql.append(" NUM_SECU_ZONA_RUTA = null ");
		sql.append(" WHERE SOCA_OID_SOLI_CABE = ? ");
        parametros.add(consolidado.getOidSolicitud());
        */
        
        
        BelcorpService bs = UtilidadesEJB.getBelcorpService();
		String codigoError = null;

		try{
			bs.dbService.executePreparedUpdate(sql.toString(),parametros);
		} catch(Exception e) {
			UtilidadesLog.error(" actualizarSolicitudesOrigen:",e);
			this.logSql(" actualizarSolicitudesOrigen. SQL: ",sql.toString(),parametros);
			throw new MareException(e, UtilidadesError.armarCodigoError(
							CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS));
		}

        sql = new StringBuffer("");
		parametros = new Vector();

        sql.append(" SELECT OID_SOLI_CABE OID, TSPA_OID_TIPO_SOLI_PAIS TIPOSOLICITUD ");
        sql.append(" FROM PED_SOLIC_CABEC ");
        sql.append(" WHERE ");
        sql.append(" SOCA_OID_SOLI_CABE = ? ");
        parametros.add(consolidado.getOidSolicitud());
        sql.append(" ORDER BY TSPA_OID_TIPO_SOLI_PAIS ");

        RecordSet rs = null;
		
		try {
			rs = bs.dbService.executePreparedQuery(sql.toString(),parametros);
		} catch (Exception e) {
		    codigoError = CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS;
			UtilidadesLog.error("actualizarSolicitudesOrigen: Exception",e);
            this.logSql(" actualizarSolicitudesOrigen. SQL: ",sql.toString(),parametros);
		    throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));
		}
        //Gacevedo: Si no trae registros, explota como loco, lo cambio
        Long tipoSolActual = new Long("0");//new Long( ((BigDecimal)rs.getValueAt(0,"TIPOSOLICITUD")).longValue());
        //Long oid = new Long( ((BigDecimal)rs.getValueAt(0,"OID")).longValue());
        //listaSolicitudes.add(oid);
        ArrayList listaSolicitudes = new ArrayList();
        Long tipoSoli = null;
        
        //for(int i=0; i<rs.getRowCount();i++){
        int i  = 0;
        int numRegs = rs.getRowCount();
        while (i<numRegs){
                listaSolicitudes.clear();
                tipoSolActual = new Long( ((BigDecimal)rs.getValueAt(i,"TIPOSOLICITUD")).longValue());                
                UtilidadesLog.debug("Se cambia el tipo de solicitud: "+tipoSolActual);
                //listaSolicitudes.add( new Long( ((BigDecimal)rs.getValueAt(i,"OID")).longValue()));    
                UtilidadesLog.debug("Valor de i: "+i);
                while (i<rs.getRowCount()){
                    tipoSoli = new Long( ((BigDecimal)rs.getValueAt(i,"TIPOSOLICITUD")).longValue());
                    UtilidadesLog.debug("Tipo Solicitud:" +tipoSoli);
                    UtilidadesLog.debug("Tipo Solicitud Anterior:" +tipoSolActual);

                    if (tipoSoli.longValue()==tipoSolActual.longValue()){
                        Long oid = new Long( ((BigDecimal)rs.getValueAt(i,"OID")).longValue());
                        UtilidadesLog.debug("Inserta el oid: "+oid+" en la lista de solicitudes");                        
                        listaSolicitudes.add(oid);       
                    }else{
                        UtilidadesLog.debug("Se hace el break -  Se ha encontrado un nuevo tipo sol");
                        break;
                    }
                    i++;
                    UtilidadesLog.debug("Valor de i: "+i);
                }
            
            
            UtilidadesLog.debug("listaSolicitudes"+listaSolicitudes);
            
            // se obtiene el proceso a utilizar en la actualizacion

            Iterator iteraSecuenciaProcesos = secuenciaProcesosGP4.iterator();
            DTOFACSecuenciaProcesos dtoFACSecuenciaProcesos = null;
            ArrayList listaProcesos = new ArrayList();
			while(iteraSecuenciaProcesos.hasNext()){
				dtoFACSecuenciaProcesos = (DTOFACSecuenciaProcesos)iteraSecuenciaProcesos.next();
				if(dtoFACSecuenciaProcesos.getTipoSolicitud().equals(tipoSolActual) ){
					listaProcesos.add(dtoFACSecuenciaProcesos);
				}
			}
            UtilidadesLog.debug("ListaProcesos"+listaProcesos);
            
            //  - De los objetos DTOFACSecuenciaProcesos contenidos en 'listaProcesos', se selecciona el que tiene el valor  
            // mayor en el campo 'secuencia'; de él se coge el atributo 'oidProceso', y se carga en la variable 'oidProceso':
            // Long oidProceso = listaProcesos( secuencia mayor ).oidProceso      
            DTOFACSecuenciaProcesos [] listaProcesosArray2 = (DTOFACSecuenciaProcesos [] )listaProcesos.toArray(new DTOFACSecuenciaProcesos [listaProcesos.size()]); 
			DTOFACSecuenciaProcesos dtoFACSecuenciaProcesosMax = null;
			
            UtilidadesLog.debug("ListaProcesosArray2"+listaProcesosArray2);
			for (int j = 0; j < listaProcesosArray2.length; j++) {
				int secuencia = listaProcesosArray2[j].getSecuencia().intValue();
				if( dtoFACSecuenciaProcesosMax == null || dtoFACSecuenciaProcesosMax.getSecuencia().intValue() < secuencia) {
					dtoFACSecuenciaProcesosMax = listaProcesosArray2[j];
				}
			}   
			UtilidadesLog.debug("dtoFACSecuenciaProcesosMax"+dtoFACSecuenciaProcesosMax);
			Long oidProceso = null;
			if (dtoFACSecuenciaProcesosMax != null)
				oidProceso = dtoFACSecuenciaProcesosMax.getOidProceso();
            
            
            //se actualizan los registros de cabecera de las solicitudes origen:
            String lista =this.convertirArrayToString(listaSolicitudes);
            sql = new StringBuffer("");
            parametros = new Vector();

            sql.append(" UPDATE PED_SOLIC_CABEC ");
            sql.append(" SET SOCA_OID_SOLI_CABE = null, ");
            sql.append(" FEC_FACT = null, ");
            sql.append(" IND_GENE_CC = null, ");
            sql.append(" IND_APLI_MANU = null, ");

            if (grupoReversion==null){
                sql.append(" VAL_GRUP_REVE = null, ");                 
            }else{
                sql.append(" VAL_GRUP_REVE = ?, ");
                parametros.add(grupoReversion);
            }             
            
            sql.append(" GRPR_OID_GRUP_PROC = ?, ");
            parametros.add(grupoProcesos);
            sql.append(" PROC_OID_PROC = ? ");
            parametros.add(oidProceso);
            sql.append(" WHERE OID_SOLI_CABE IN (" +lista+ ")" );
            
            for(int k=0;k< listaSolicitudes.size();k++){
                if(listaSolicitudes.get(k)!=null){
                //si es distinto de null lo pasamos a vector de la select.
                    parametros.add(listaSolicitudes.get(k));
                }
            }
    
            try{
                bs.dbService.executePreparedUpdate(sql.toString(),parametros);
            } catch(Exception e) {
                UtilidadesLog.error(" actualizarSolicitudesOrigen:",e);
                this.logSql(" actualizarSolicitudesOrigen. SQL: ",sql.toString(),parametros);
                throw new MareException(e, UtilidadesError.armarCodigoError(
                                CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS));
            }
        }
    	UtilidadesLog.info("DAOFACReversion.actualizarSolicitudesOrigen (DTOSolicitudValidacion consolidado, String grupoReversion, Long grupoProcesos,ArrayList secuenciaProcesosGP4 ): Salida");
	}
	
	public void anularFacturas (DTOOIDs cabecerasDC) throws MareException {
		UtilidadesLog.info("DAOFACReversion.anularFacturas (DTOOIDs cabecerasDC): Entrada");

		StringBuffer sql = new StringBuffer("");
		Vector parametros = new Vector();

		sql.append(" UPDATE FAC_DOCUM_CONTA_CABEC   ");
		sql.append(" SET VAL_SERI_DOCU_LEGA = null, ");
		sql.append(" NUM_DOCU_LEGA = null  ");
		String oids = this.convertirArrayToString(cabecerasDC.getOids());
		sql.append(" WHERE OID_CABE IN ( " + oids + " ) ");

		for (int i = 0; i < cabecerasDC.getOids().length; i++){
			if(cabecerasDC.getOids()[i]!=null){
				parametros.add(cabecerasDC.getOids()[i]);
			}
		}				

		BelcorpService bs = UtilidadesEJB.getBelcorpService();
		String codigoError = null;
		try {
			bs.dbService.executePreparedUpdate(sql.toString(), parametros);
		} catch (Exception e) {
			codigoError = CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS;
			UtilidadesLog.error("anularFacturas: Exception",e);
			this.logSql("anularFacturas. SQL: ",sql.toString(), parametros);
			throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));
		}
				
		UtilidadesLog.info("DAOFACReversion.anularFacturas (DTOOIDs cabecerasDC): Salida");
	}

	//añadido por incidencia 11571
	public DTOSalida consultarFacturas (DTOFACConsultaFacturas dtoE) throws MareException {
		UtilidadesLog.info("DAOFACReversion.consultarFacturas (DTOFACConsultaFacturas dtoE): Entrada");

		StringBuffer sql = new StringBuffer("");
		Vector parametros = new Vector();

		sql.append(" SELECT  DC.OID_CABE OID, ");
		sql.append(" TD.COD_TIPO_DOCU TIPODOCUMENTOLEGAL, ");
		sql.append(" CL.COD_CLIE CODIGOCLIENTE, ");
		sql.append(" CL.VAL_NOM1 || ' ' || CL.VAL_NOM2 || ' ' || CL.VAL_APE1 || ' ' || CL.VAL_APE2 NOMBRE_APELLIDOS, ");
		
    /*  Se cambia el codigo de canal acceso y subacceso por su descripcion internacionalizada
     * por incidencia: BELC300011746
     * 
    sql.append(" CA.COD_CANA CANAL, ");
		sql.append(" ACCE.COD_ACCE ACCESO, ");
		sql.append(" SA.COD_SBAC SUBACCESO, ");
    */
    //BELC300011746
    sql.append(" (SELECT v.VAL_I18N FROM V_GEN_I18N_SICC v ");    
		sql.append(" WHERE v.VAL_OID = CA.OID_CANA AND ");
		sql.append("      v.IDIO_OID_IDIO = ? AND v.ATTR_NUM_ATRI = 1 AND  ");
		sql.append("      v.ATTR_ENTI = 'SEG_CANAL') AS CANAL, ");
		parametros.add(dtoE.getOidIdioma());     

    //BELC300011746
    sql.append(" (SELECT v.VAL_I18N FROM V_GEN_I18N_SICC v ");    
		sql.append(" WHERE v.VAL_OID = ACCE.OID_ACCE AND ");
		sql.append("      v.IDIO_OID_IDIO = ? AND v.ATTR_NUM_ATRI = 1 AND  ");
		sql.append("      v.ATTR_ENTI = 'SEG_ACCES') AS ACCESO, ");
		parametros.add(dtoE.getOidIdioma());     
    
    //BELC300011746
    sql.append(" (SELECT v.VAL_I18N FROM V_GEN_I18N_SICC v     ");
		sql.append("WHERE v.VAL_OID = SA.OID_SBAC AND ");
		sql.append("      v.IDIO_OID_IDIO = ? AND v.ATTR_NUM_ATRI = 1 AND  ");
		sql.append("      v.ATTR_ENTI = 'SEG_SUBAC') AS SUBACCESO, ");
		parametros.add(dtoE.getOidIdioma());     
  
    
		sql.append(" SC.VAL_NUME_SOLI NUMEROCONSOLIDADO, ");
		sql.append(" DC.VAL_EJER_DOCU_INTE EJERCICIO, ");
		sql.append(" DC.NUM_DOCU_CONT_INTE NUMERODOCUMENTOINTERNO, ");
		sql.append(" DC.VAL_SERI_DOCU_LEGA NUMEROSERIEDOCUMENTOLEGAL, ");
		sql.append(" DC.NUM_DOCU_LEGA DOCUMENTOLEGAL, ");
		sql.append(" DC.FEC_FACT FECHAFACTURACION, ");
		sql.append(" DC.FEC_EMIS FECHAPROCESO ");
		sql.append(" FROM FAC_DOCUM_CONTA_CABEC DC, ");
		sql.append(" FAC_FORMU FO, ");
		sql.append(" PED_SOLIC_CABEC SC, ");
		sql.append(" VCA_SEG_SUBAC SA, ");
		sql.append(" VCA_SEG_ACCES ACCE, ");
		sql.append(" VCA_SEG_CANAL CA, ");
		sql.append(" VCA_SEG_SOCIE SO, ");
		sql.append(" FAC_TIPO_DOCUM TD, ");
		sql.append(" MAE_CLIEN CL, ");
		sql.append(" MAE_CLIEN_DIREC DI ");
		sql.append(" WHERE DC.PAIS_OID_PAIS = ? "); //dtoE.pais
		parametros.add(dtoE.getOidPais());
		sql.append(" AND FO.OID_FORM = DC.FORS_OID_FORM ");
		sql.append(" AND DC.SOCA_OID_SOLI_CABE = SC.OID_SOLI_CABE ");
		sql.append(" AND TD.OID_TIPO_DOCU = DC.TIDO_OID_TIPO_DOCU ");
		sql.append(" AND DC.SOCI_OID_SOCI = SO.OID_SOCI ");
		sql.append(" AND DC.SBAC_OID_SBAC = SA.OID_SBAC  ");
		sql.append(" AND SA.ACCE_OID_ACCE= ACCE.OID_ACCE ");
		sql.append(" AND ACCE.CANA_OID_CANA = CA.OID_CANA ");
		sql.append(" AND SO.COD_USUA = ? "); //this.usuario
		parametros.add(this.usuario);
		sql.append(" AND SA.COD_USUA = ? "); //this.usuario
		parametros.add(this.usuario);
		sql.append(" AND ACCE.COD_USUA = ? ");
		parametros.add(this.usuario);
		sql.append(" AND CA.COD_USUA = ? ");
		parametros.add(this.usuario);
		sql.append(" AND DC.CLDI_OID_CLIE_DIRE = DI.OID_CLIE_DIRE ");
		sql.append(" AND DI.CLIE_OID_CLIE = CL.OID_CLIE ");
		//sql.append(" AND DC.NUM_DOCU_LEGA IS NOT NULL "); COMENTADO INCIDENCIA 11571

		if(dtoE.getCodigoCliente() != null){
			sql.append(" AND CL.COD_CLIE LIKE ? ");
			parametros.add(dtoE.getCodigoCliente());
		}
		if(dtoE.getTipoDocumentoContable() != null ){
			sql.append("AND TD.OID_TIPO_DOCU = ? ");
			parametros.add(dtoE.getTipoDocumentoContable());
		}
		if(dtoE.getEjercicio() != null){
			sql.append(" AND DC.VAL_EJER_DOCU_INTE = ? ");
			parametros.add(dtoE.getEjercicio());
		}
		if(dtoE.getRangoDesdeDocumentoInterno() != null){
			sql.append(" AND DC.NUM_DOCU_CONT_INTE >= ? ");
			parametros.add(dtoE.getRangoDesdeDocumentoInterno());
		}
		if(dtoE.getRangoHastaDocumentoInterno() != null){
			sql.append(" AND DC.NUM_DOCU_CONT_INTE <= ? ");
			parametros.add(dtoE.getRangoHastaDocumentoInterno());
		}
		if(dtoE.getSerieDocumentoLegal() != null){
			sql.append(" AND DC.VAL_SERI_DOCU_LEGA = ? ");
			parametros.add(dtoE.getSerieDocumentoLegal());
		}
		if(dtoE.getRangoDesdeDocumentoLegal() != null){
			sql.append(" AND DC.NUM_DOCU_LEGA >= ? ");
			parametros.add(dtoE.getRangoDesdeDocumentoLegal());
		}
		if(dtoE.getRangoHastaDocumentoLegal() != null){
			sql.append(" AND DC.NUM_DOCU_LEGA <= ? ");
			parametros.add(dtoE.getRangoHastaDocumentoLegal());
		}
		if(dtoE.getSubacceso() != null){
			sql.append(" AND DC.SBAC_OID_SBAC = ? ");
			parametros.add(dtoE.getSubacceso());
		}
		if(dtoE.getCanal() != null){
			sql.append(" AND ACCE.CANA_OID_CANA = ? ");
			parametros.add(dtoE.getCanal());
		}
		if(dtoE.getAcceso() != null){
			sql.append(" AND ACCE.OID_ACCE = ? ");
			parametros.add(dtoE.getAcceso());
		}
		if(dtoE.getNumeroConsolidadoDesde() != null || dtoE.getNumeroConsolidadoHasta() != null){
			sql.append(" AND  DC.OID_CABE in ( ");
			sql.append(" SELECT DC.OID_CABE ");
			sql.append(" FROM PED_SOLIC_CABEC SC,FAC_DOCUM_CONTA_CABEC DC ");
			sql.append(" WHERE DC.SOCA_OID_SOLI_CABE=SC.OID_SOLI_CABE ");
			if(dtoE.getNumeroConsolidadoDesde() != null){
				sql.append(" AND SC.VAL_NUME_SOLI >= ? ");
				parametros.add(dtoE.getNumeroConsolidadoDesde());
			}
			if(dtoE.getNumeroConsolidadoHasta() != null){
				sql.append(" AND SC.VAL_NUME_SOLI <= ? ");
				parametros.add(dtoE.getNumeroConsolidadoHasta());
			}
			sql.append(" ) ");
		}

		if(dtoE.getFechaFacturacionDesde() != null ){
			sql.append(" AND DC.FEC_FACT >= TO_DATE( ? ,'YYYY-MM-DD') ");
			parametros.add(convertirFecha(dtoE.getFechaFacturacionDesde()));
		}
		if(dtoE.getFechaFacturacionHasta() != null ){
			sql.append(" AND DC.FEC_FACT <= TO_DATE( ? ,'YYYY-MM-DD') ");
			parametros.add(convertirFecha(dtoE.getFechaFacturacionHasta()));
		}
		if(dtoE.getFechaProcesoDesde() != null ){
			sql.append(" AND TO_DATE(TO_CHAR(DC.FEC_EMIS,'YYYY-MM-DD'), 'YYYY-MM-DD') >= TO_DATE( ? ,'YYYY-MM-DD') ");
			parametros.add(convertirFecha(dtoE.getFechaProcesoDesde()));
		}
		if(dtoE.getFechaProcesoHasta() != null ){
			sql.append(" AND TO_DATE(TO_CHAR(DC.FEC_EMIS,'YYYY-MM-DD'), 'YYYY-MM-DD') <= TO_DATE( ? ,'YYYY-MM-DD') ");
			parametros.add(convertirFecha(dtoE.getFechaProcesoHasta()));
		}
		sql.append(" ORDER BY DC.PAIS_OID_PAIS, ");
		sql.append(" FO.OID_FORM, ");
		sql.append(" ACCE.CANA_OID_CANA, ");
		sql.append(" ACCE.OID_ACCE, ");
		sql.append(" SA.COD_SBAC, ");
		sql.append(" DC.VAL_EJER_DOCU_INTE, ");
		sql.append(" DC.NUM_DOCU_CONT_INTE ");

		String sqlPaginacion = UtilidadesPaginacion.armarQueryPaginacion(sql.toString(),dtoE);

		BelcorpService bs = UtilidadesEJB.getBelcorpService();
		RecordSet rs = null;
		String codigoError = null;
		try {
			this.logSql("DAOFACReversion.consultarFacturas. SQL: ",sqlPaginacion, parametros);
			rs = bs.dbService.executePreparedQuery(sqlPaginacion,parametros);
		} catch (Exception e) {
		    codigoError = CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS;
			UtilidadesLog.error("DAOFACReversion.consultarFacturas: Exception",e);
		    throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));
		}
		if (rs.esVacio()){
			UtilidadesLog.debug("****DAOFACReversion.consultarFacturas: No hay datos ");
			throw new MareException(new Exception(),                                                            
                UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE));
		}
		DTOSalida dtoS = new DTOSalida();
		dtoS.setResultado(rs);
		
		UtilidadesLog.info("DAOFACReversion.consultarFacturas (DTOFACConsultaFacturas dtoE): Salida");
		return dtoS;
	}


	public void anularRUV (DTOOIDs cabecerasDC) throws MareException {
		UtilidadesLog.info("DAOFACReversion.anularRUV (DTOOIDs cabecerasDC): Entrada");

		StringBuffer sql = new StringBuffer("");
		Vector parametros = new Vector();

		sql.append(" UPDATE FAC_REGIS_UNICO_VENTA ");
		sql.append(" SET IND_ESTA = ? ");
		parametros.add(Boolean.TRUE);
		String oids = this.convertirArrayToString(cabecerasDC.getOids());
		sql.append(" WHERE DCCA_OID_CABE IN ( " + oids + " ) ");

		for (int i = 0; i < cabecerasDC.getOids().length; i++){
			if(cabecerasDC.getOids()[i]!=null){
				parametros.add(cabecerasDC.getOids()[i]);
			}
		}				

		BelcorpService bs = UtilidadesEJB.getBelcorpService();
		String codigoError = null;
		try {
			bs.dbService.executePreparedUpdate(sql.toString(), parametros);
		} catch (Exception e) {
			codigoError = CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS;
			UtilidadesLog.error("anularRUV: Exception",e);
			this.logSql("anularRUV. SQL: ",sql.toString(), parametros);
			throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));
		}
				
		UtilidadesLog.info("DAOFACReversion.anularRUV (DTOOIDs cabecerasDC): Salida");
	}


	// ESTE METODO ESTA TAMBIEN EN DAOFACCierreFacturacion
	public ArrayList obtenerProcesosCierre(Long pais, Long tipoCierre) throws MareException{
		UtilidadesLog.info("DAOFACReversion.obtenerProcesosCierre(Long pais, Long tipoCierre): Entrada");

		Vector parametros = new Vector();
		// Se crea la consulta SQL
		StringBuffer consulta = new StringBuffer();
		consulta.append(" SELECT * FROM FAC_PROCE_CIERR ");
		consulta.append(" WHERE "); 
		consulta.append(" PAIS_OID_PAIS = ? AND ");
		parametros.add(pais);
		consulta.append(" TCIE_OID_TIPO_CIER = ? ");
		parametros.add(tipoCierre);
		consulta.append(" ORDER BY NUM_ORDE_EJEC ");
	
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

		/*
			Con cada registro obtenido de la consulta SQL se construye un 
			objeto DTOFACProcesoCierre, y se retorna la lista completa.
		*/
		
		ArrayList retorno = new ArrayList();
		DTOFACProcesoCierre dtoProcesoCierre = null;
		Object valProg = null;
		for(int i=0; i<resultado.getRowCount(); i++){

			dtoProcesoCierre = new DTOFACProcesoCierre();
			dtoProcesoCierre.setOid(new Long(((BigDecimal)resultado.getValueAt(i,"OID_PROC_CIER")).longValue()));
			dtoProcesoCierre.setOidPais(new Long(((BigDecimal)resultado.getValueAt(i,"PAIS_OID_PAIS")).longValue()));
			dtoProcesoCierre.setProceso(resultado.getValueAt(i,"VAL_PROC").toString());
			dtoProcesoCierre.setNumeroOrdenEjecucion(new Integer(((BigDecimal)resultado.getValueAt(i,"NUM_ORDE_EJEC")).intValue()));
			valProg = resultado.getValueAt(i,"VAL_PROG");
			if (valProg!=null){
				dtoProcesoCierre.setPrograma(resultado.getValueAt(i,"VAL_PROG").toString());
			}
			dtoProcesoCierre.setTipoCierre(new Long(((BigDecimal)resultado.getValueAt(i,"TCIE_OID_TIPO_CIER")).longValue()));
			retorno.add(dtoProcesoCierre);
		}
						
		UtilidadesLog.info("DAOFACReversion.obtenerProcesosCierre(Long pais, Long tipoCierre): Salida");
		return retorno;
	}

	private String convertirArrayToString(Long[] oids){
        UtilidadesLog.info("DAOFACReversion.convertirArrayToString(Long[] oids): Entrada");
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
            UtilidadesLog.info("DAOFACReversion.convertirArrayToString(Long[] oids): Salida");
			return "";
		}
		UtilidadesLog.info("DAOFACReversion.convertirArrayToString(Long[] oids): Salida");	
		return retorno;
	}

	private String convertirFecha(Date fecha) {
        UtilidadesLog.info("DAOFACReversion.convertirFecha(Date fecha): Entrada");	 
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		java.sql.Date fechaDesde = new java.sql.Date(fecha.getTime());
		String sFechaDesde = sdf.format(fechaDesde);                                                          
        UtilidadesLog.info("DAOFACReversion.convertirFecha(Date fecha): Salida");	 
		return sFechaDesde;
	}

	private String convertirFecha2(Date fecha) {
        UtilidadesLog.info("DAOFACReversion.convertirFecha(Date fecha): Entrada");	 
		SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
		java.sql.Date fechaDesde = new java.sql.Date(fecha.getTime());
		String sFechaDesde = sdf.format(fechaDesde);                                                          
        UtilidadesLog.info("DAOFACReversion.convertirFecha(Date fecha): Salida");	 
		return sFechaDesde;
	}
    
	private void logSql(String metodo, String sql, Vector params){
        UtilidadesLog.info("DAOFACReversion.logSql(String metodo, String sql, Vector params): Entrada");	 
		UtilidadesLog.debug(metodo + sql);
		if (params!=null && params.size()>0) {
			String sParams="";
			for (int i=0; i<params.size();i++){
				sParams+="param "+ (i+1) + ": " + params.elementAt(i) + ", ";
			}
			UtilidadesLog.debug(metodo + sParams);
		}
        UtilidadesLog.info("DAOFACReversion.logSql(String metodo, String sql, Vector params): Salida");	 
	}

    private  String convertirArrayToString(ArrayList array){
        UtilidadesLog.info("DAOFACReversion.convertirArrayToString(ArrayList array): Entrada");	 
		String retorno = "";
        if((array!=null)&&(array.size()!=0)){
			
            StringBuffer sentencia = new StringBuffer("");
            for(int i=0;i<array.size();i++){
                UtilidadesLog.debug("\n array[ ]=" + array.get(i));
                if(array.get(i)!=null){
                    sentencia.append(" ?, ");
                }
            }
            //Quitamos la coma y el espacio del final
            retorno= sentencia.substring(0,sentencia.length()-2);
            UtilidadesLog.debug(retorno); 
        }else{
            UtilidadesLog.info("DAOFACReversion.convertirArrayToString(ArrayList array): Salida");	 
			return "";
		}
        UtilidadesLog.info("DAOFACReversion.convertirArrayToString(ArrayList array): Salida");	 
		return retorno;
	}//metodo



    // METODO CREADO POR INCIDENCIA BELC300018467 
	public void eliminarSeguimientoPedidos (DTOFACCabeceraSolicitud cabecera) throws MareException {
		UtilidadesLog.info("DAOFACReversion.eliminarSeguimientoPedidos (DTOFACCabeceraSolicitud cabecera): Entrada");	 

		StringBuffer sql = new StringBuffer("");
		Vector parametros = new Vector();
        
        // Se actualizan las solicitudes a las cuales se le habia asociado el consolidado
        sql.append(" UPDATE  PED_SEGUI_PEDID ");
        sql.append(" SET SOCA_OID_CONS = null ");
        sql.append(" WHERE SOCA_OID_CONS = ? ");
        parametros.add(cabecera.getOidCabeceraSolicitud());
        sql.append(" AND SOCA_OID_SOLI_CABE IS NOT null ");

		BelcorpService bs = UtilidadesEJB.getBelcorpService();
		String codigoError = null;
		try {
			bs.dbService.executePreparedUpdate(sql.toString(), parametros);
		} catch (Exception e) {
			codigoError = CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS;
			UtilidadesLog.error("eliminarSeguimientoPedidos: Exception",e);
			this.logSql("eliminarSeguimientoPedidos. SQL: ",sql.toString(), parametros);
			throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));
		}

		sql = new StringBuffer("");
		parametros = new Vector();

		sql.append(" DELETE ");
		sql.append(" FROM PED_SEGUI_PEDID ");        
		sql.append(" WHERE SOCA_OID_CONS = ? ");
        parametros.add(cabecera.getOidCabeceraSolicitud());
        sql.append(" AND SOCA_OID_SOLI_CABE IS null ");
        
		bs = UtilidadesEJB.getBelcorpService();
		try {
			bs.dbService.executePreparedUpdate(sql.toString(), parametros);
		} catch (Exception e) {
			codigoError = CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS;
			UtilidadesLog.error("eliminarSeguimientoPedidos: Exception",e);
			this.logSql("eliminarSeguimientoPedidos. SQL: ",sql.toString(), parametros);
			throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));
		}
				
		UtilidadesLog.info("DAOFACReversion.eliminarSeguimientoPedidos (DTOFACCabeceraSolicitud cabecera): Salida");	 
	}
    
    private static String SELECTSOLICCABECACUM = "SELECT OID_ACUM, VAL_ACUM_GP4, VAL_ACUM_GP5 FROM PED_SOLIC_CABEC_ACUM WHERE TSPA_OID_TIPO_SOLI_PAIS = ? AND  ZZON_OID_ZONA = ? AND  SBAC_OID_SBAC = ? AND  FEC_PROC = TRUNC(TO_DATE(?,'dd/MM/yyyy')) ";

	public void actualizoAcumSolOrigen(ArrayList solContenidas) throws MareException {
		UtilidadesLog.info("DAOFACReversion.actualizoAcumSolOrigen(ArrayList solContenidas): Entrada");
        try{
            BelcorpService bs = BelcorpService.getInstance();
            SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");
            for (int i = 0; i < solContenidas.size(); i++){
                DTOFACCabeceraSolicitud dto = (DTOFACCabeceraSolicitud)solContenidas.get(i);
                Vector vec = new Vector();
                vec.add(dto.getTipoSolicitud());
                vec.add(dto.getZona());
                vec.add(dto.getSubacceso());
                vec.add(df.format(dto.getFechaPrevistaFacturacion()));
                RecordSet rc = bs.dbService.executePreparedQuery(SELECTSOLICCABECACUM, vec);
                if (rc.esVacio()){
                    throw new MareException("No puede no existir datos en PED_SOLIC_CABEC_ACUM");
                }
                long gp4 = Long.valueOf(rc.getValueAt(0,"VAL_ACUM_GP4").toString()).longValue();
                long gp5 = Long.valueOf(rc.getValueAt(0,"VAL_ACUM_GP5").toString()).longValue();
                StringBuffer sb1 = new StringBuffer("UPDATE PED_SOLIC_CABEC_ACUM SET VAL_ACUM_GP4 = ");
                sb1.append((gp4+1));
                sb1.append(" , VAL_ACUM_GP5= ");
                sb1.append((gp5-1));
                sb1.append("  WHERE OID_ACUM = ");
                sb1.append(rc.getValueAt(0,"OID_ACUM").toString());
                bs.dbService.executeUpdate(sb1.toString());
                
            }
        }catch(Exception e){
            UtilidadesLog.error("Error",e);
            if (e instanceof MareException) throw (MareException)e;                        
            throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS));
        }
        
        UtilidadesLog.info("DAOFACReversion.actualizoAcumSolOrigen(ArrayList solContenidas): Salida");
    }

    public void actualizoAcumConsolidado (Long subAcceso, Long tipoSoliPais, Date fecProg, Long oidZona) throws MareException {
        UtilidadesLog.info("DAOFACReversion.actualizoAcumConsolidado (Long subAcceso, Long tipoSoliPais, Date fecProg, Long oidZona): Entrada");	 
        StringBuffer sql = new StringBuffer("");
        
        sql.append("select VAL_ACUM_GP5 from PED_SOLIC_CABEC_ACUM ");
        sql.append("WHERE SBAC_OID_SBAC = " + subAcceso.longValue());
        sql.append(" AND TSPA_OID_TIPO_SOLI_PAIS = " + tipoSoliPais.longValue());
        sql.append(" AND FEC_PROC = TO_DATE('" + convertirFecha2(fecProg) + "','DD-MM-YYYY') ");
        sql.append(" AND ZZON_OID_ZONA = " + oidZona.longValue());
        sql.append(" FOR UPDATE ");
 
        BelcorpService bs = null;
        bs = BelcorpService.getInstance();
    
        RecordSet rs = null;
            int acumuladoActual = 0;
    
        try{
          rs = bs.dbService.executeStaticQuery(sql.toString());
        } catch(Exception e) {
          UtilidadesLog.error(" actualizoAcumConsolidado (consulta):",e);
          throw new MareException(e, UtilidadesError.armarCodigoError(
                  CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS));
        }
        
        UtilidadesLog.debug("obtengo: " + rs);

        if (!(rs.getRowCount()>0)){
            UtilidadesLog.info("error grave, no se hallo el registro para el consolidado!");
        } else {
            if(rs.getValueAt(0,"VAL_ACUM_GP5")!=null){
                acumuladoActual = ((BigDecimal)rs.getValueAt(0,"VAL_ACUM_GP5")).intValue();
                //OK, si acumuladoActual es mayor q' 1 se resta (-1), sino; desapararezco record
                if (acumuladoActual>1){
                    int nuevoAcumulado = (((BigDecimal)rs.getValueAt(0,"VAL_ACUM_GP5")).intValue() - 1);       
                    //updateo el valor del acumulado gp5
                    sql = new StringBuffer("");    
                    sql.append(" UPDATE PED_SOLIC_CABEC_ACUM ");
                    sql.append(" SET VAL_ACUM_GP5 = " + nuevoAcumulado); 
                    sql.append("WHERE SBAC_OID_SBAC = " + subAcceso.longValue());
                    sql.append(" AND TSPA_OID_TIPO_SOLI_PAIS = " + tipoSoliPais.longValue());
                    sql.append(" AND FEC_PROC = TO_DATE('" + convertirFecha2(fecProg) + "','DD-MM-YYYY') ");
                    sql.append(" AND ZZON_OID_ZONA = " + oidZona.longValue());
                    
                    try {
                        bs.dbService.executeUpdate(sql.toString());
                    } catch (Exception e) {
                        UtilidadesLog.error("actualizoAcumConsolidado: Exception",e);
                        throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS));
                    }
                } else {
                    //asumo que es = a 1
                    sql = new StringBuffer("");    
                    sql.append(" DELETE ");
                    sql.append(" FROM PED_SOLIC_CABEC_ACUM "); 
                    sql.append("WHERE SBAC_OID_SBAC = " + subAcceso.longValue());
                    sql.append(" AND TSPA_OID_TIPO_SOLI_PAIS = " + tipoSoliPais.longValue());
                    sql.append(" AND FEC_PROC = TO_DATE('" + convertirFecha2(fecProg) + "','DD-MM-YYYY') ");
                    sql.append(" AND ZZON_OID_ZONA = " + oidZona.longValue());
                    try {
                        bs.dbService.executeUpdate(sql.toString());
                    } catch (Exception e) {
                        UtilidadesLog.error("actualizoAcumConsolidado: Exception",e);
                        throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS));
                    }
                }
            }
        }        
        UtilidadesLog.info("DAOFACReversion.actualizoAcumConsolidado (Long subAcceso, Long tipoSoliPais, Date fecProg, Long oidZona): Salida");	 
    }
	
}