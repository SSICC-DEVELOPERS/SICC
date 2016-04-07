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

import es.indra.sicc.dtos.fac.DTODatosCupones;
import es.indra.sicc.dtos.fac.DTODatosDocMensajes;
import es.indra.sicc.dtos.fac.DTODatosTipoFormulario;
import es.indra.sicc.dtos.fac.DTOFACCabeceraSolicitud;

import es.indra.sicc.util.BelcorpService;
import es.indra.sicc.util.CodigosError;
import es.indra.sicc.util.DTOSalida;
import es.indra.sicc.util.UtilidadesBD;
import es.indra.sicc.util.UtilidadesEJB;
import es.indra.sicc.util.UtilidadesError;
import es.indra.sicc.util.UtilidadesLog;

import java.text.SimpleDateFormat;

//import java.io.ByteArrayOutputStream;

import java.math.BigDecimal;

import java.util.ArrayList;
import java.util.Date;
import java.util.Vector;


public class DAOGestionDocumentos {

	private String usuario = null; //ver incidencia 9003    

	public DAOGestionDocumentos() {
		
    }
		
    public DAOGestionDocumentos(String usuario) {
		this.usuario = usuario;
    }

    public DTOSalida obtenerSolicitudes(DTODatosDocMensajes dtoEntrada)
        throws MareException {
        UtilidadesLog.info("DAOGestionDocumentos.obtenerSolicitudes(DTODatosDocMensajes dtoEntrada): Entrada");

		// Parametros de la consulta
        Vector parametros = new Vector();

        // Se crea la consulta SQL
        StringBuffer sql = new StringBuffer();
	
        sql.append("SELECT * FROM (SELECT ROWNUM as linea,    xxx.* FROM (");		
        sql.append(" SELECT ");
        sql.append(" SC.OID_SOLI_CABE OID,                                                                                                                                        ");
        sql.append(" CLI.COD_CLIE AS CODIGOCLIENTE,                                                                                                                              ");	                                                                            
        sql.append(" CLI.VAL_NOM1 || ' ' || CLI.VAL_APE1 AS NOMBRE_APELLIDO,                                                                           ");
        sql.append(" (SELECT IDIO.val_i18n FROM V_GEN_I18N_SICC IDIO WHERE ");
        sql.append(" IDIO.attr_enti = 'SEG_CANAL' AND IDIO.idio_oid_idio = ? AND ");
        sql.append(" IDIO.val_oid = AC.CANA_OID_CANA ) AS CANAL, ");
        parametros.add(dtoEntrada.getOidIdioma());

        sql.append(" (SELECT IDIO.val_i18n FROM V_GEN_I18N_SICC IDIO WHERE ");
        sql.append(" IDIO.attr_enti = 'SEG_ACCES' AND IDIO.idio_oid_idio = ? AND ");
        sql.append(" IDIO.val_oid = AC.OID_ACCE ) AS ACCESO, ");
        parametros.add(dtoEntrada.getOidIdioma());

        sql.append(" (SELECT IDIO.val_i18n FROM V_GEN_I18N_SICC IDIO WHERE ");
        sql.append(" IDIO.attr_enti = 'SEG_SUBAC' AND IDIO.idio_oid_idio = ? AND ");
        sql.append(" IDIO.val_oid = SC.SBAC_OID_SBAC ) AS SUBACCESO, ");
        parametros.add(dtoEntrada.getOidIdioma());
        
        sql.append(" DECODE(SC.SOCA_OID_SOLI_CABE,NULL,NULL,(SELECT VAL_NUME_SOLI FROM PED_SOLIC_CABEC SCA WHERE SCA.OID_SOLI_CABE = SC.SOCA_OID_SOLI_CABE) ) as NUMEROCONSOLIDADO,  ");
        sql.append(" P.VAL_NOMB_PERI AS PERIODO,  ");
        sql.append(" SC.FEC_FACT AS FECHAFACTURACION, SC.PAIS_OID_PAIS AS PAIS ");
		sql.append(" FROM	");
        sql.append(" PED_SOLIC_CABEC SC, MAE_CLIEN CLI, VCA_SEG_ACCES AC, VCA_SEG_SUBAC SUB, CRA_PERIO P                                                                                                         ");
        sql.append(" WHERE	");
        sql.append(" AC.OID_ACCE = SUB.ACCE_OID_ACCE  ");
        sql.append(" AND SUB.OID_SBAC = SC.SBAC_OID_SBAC  ");
        sql.append(" AND P.OID_PERI = SC.PERD_OID_PERI "); 
        sql.append(" AND CLI.OID_CLIE = SC.CLIE_OID_CLIE "); 
		
        sql.append(" AND SUB.COD_USUA = ?  ");
		parametros.add(this.usuario);

        sql.append(" AND AC.COD_USUA = ?  ");
		parametros.add(this.usuario);

		if (dtoEntrada.getOidPais() != null){
			sql.append(" AND SC.PAIS_OID_PAIS  = ?   ");
			parametros.add(dtoEntrada.getOidPais());
		}
		if (dtoEntrada.getCodCliente() != null){
			sql.append(" AND CLI.COD_CLIE  = ?  ");
			parametros.add(dtoEntrada.getCodCliente());
		}
		if (dtoEntrada.getTipoSolicitud() != null){
			sql.append(" AND SC.TSPA_OID_TIPO_SOLI_PAIS =?  ");
			parametros.add(dtoEntrada.getTipoSolicitud());
		}
		if (dtoEntrada.getCanal() != null){
			sql.append(" AND AC.CANA_OID_CANA = ? ");
			parametros.add(dtoEntrada.getCanal());
		}
		if (dtoEntrada.getAcceso() != null){
			sql.append(" AND AC.OID_ACCE = ?  ");
			parametros.add(dtoEntrada.getAcceso());
		}
		if (dtoEntrada.getSubAcceso() != null){
			sql.append(" AND SC.SBAC_OID_SBAC = ? ");
			parametros.add(dtoEntrada.getSubAcceso());
		}
		if (( dtoEntrada.getNumeroConsolidadoDesde() != null)
			&&(dtoEntrada.getNumeroConsolidadoHasta() != null)){
				sql.append(" AND   SC.VAL_NUME_SOLI >= ? ");
				sql.append(" AND   SC.VAL_NUME_SOLI <= ? ");
				parametros.add(dtoEntrada.getNumeroConsolidadoDesde());
				parametros.add(dtoEntrada.getNumeroConsolidadoHasta());
		}
		if (( dtoEntrada.getFechaFacturacionDesde() != null)
			&&(dtoEntrada.getFechaFacturacionHasta() != null)){
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			java.sql.Date fechDesde =  new java.sql.Date(dtoEntrada.getFechaFacturacionDesde().getTime());
			java.sql.Date fechHasta =  new java.sql.Date(dtoEntrada.getFechaFacturacionHasta().getTime());
			String fechaDesde = sdf.format(fechDesde); 
			String fechaHasta = sdf.format(fechHasta);
			sql.append(" AND  SC.FEC_FACT >= TO_DATE( ? ,'YYYY-MM-DD')	");
			sql.append(" AND  SC.FEC_FACT <= TO_DATE( ? ,'YYYY-MM-DD')	");
			parametros.add(fechaDesde);
			parametros.add(fechaHasta);
		}
		sql.append(" ORDER BY PAIS,CANAL,ACCESO,SUBACCESO,NUMEROCONSOLIDADO  ");
        
		sql.append(") xxx ) WHERE linea > " + dtoEntrada.getIndicadorSituacion() + " AND ROWNUM <= " + dtoEntrada.getTamanioPagina() );

    	//String consulta = UtilidadesPaginacion.armarQueryPaginacion(sql.toString(),dtoEntrada);
		//consulta += " ORDER BY PAIS,CANAL,ACCESO,SUBACCESO,NUMEROCONSOLIDADO  ";
		
		// Se ejecuta la consulta 
        BelcorpService bs = UtilidadesEJB.getBelcorpService();
        RecordSet rs = null;
        String codigoError = null;

        try {
            rs = bs.dbService.executePreparedQuery(sql.toString(), parametros);
        } catch (Exception e) {
            codigoError = CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS;
            this.logError("obtenerSolicitudes: Exception", e);
            this.logSql("obtenerSolicitudes. SQL: ",
                sql.toString(), parametros);
            throw new MareException(e,
                UtilidadesError.armarCodigoError(codigoError));
        }

    if (rs.esVacio()) {
        //GEN-0007 --> 005
        UtilidadesLog.debug("****obtenerSolicitudes: no hay datos ");				
              codigoError = CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE;
              throw new MareException(new Exception(), UtilidadesError.armarCodigoError(codigoError));
    }
		DTOSalida dtoSalida = new DTOSalida();
		dtoSalida.setResultado(rs);
        UtilidadesLog.info("DAOGestionDocumentos.obtenerSolicitudes(DTODatosDocMensajes dtoEntrada): Salida");

        return dtoSalida;
    }

    public ArrayList obtenerCabecerasDeUnConsolidado(Long oidConsolidado)
        throws MareException {
        UtilidadesLog.info("DAOGestionDocumentos.obtenerCabecerasDeUnConsolidado(Long oidConsolidado): Entrada");
        // Parametros de la consulta
        Vector parametros = new Vector();

        // Se crea la consulta SQL
        StringBuffer sql = new StringBuffer();

        sql.append(" SELECT ");
        sql.append(" SC.ACFI_OID_ACCE_FISI as ACCESOFISICO, ");
        sql.append(" SC.ALMC_OID_ALMA as ALMACEN, ");
        sql.append(" SC.CLSO_OID_CLAS_SOLI as CLASESOLICITUD, ");
        sql.append(" SC.CLAS_OID_CLAS_FLET as CLASIFICACION, ");
        sql.append(" SC.CLIE_OID_CLIE as OIDCLIENTE, ");
        sql.append(" SC.CLIE_OID_CONS_ASOC as CONSULTORAASOCIADA, ");
        sql.append(" SC.TCCL_OID_TCCL_FLET as TIPOCLASIFICACION, ");
        sql.append(" SC.ESSO_OID_ESTA_SOLI as ESTADO, ");
        sql.append(" SC.CLIE_OID_CLIE_DEST as DESTINATARIO, ");
        sql.append(" SC.FEC_CRON as FECHA, ");
        sql.append(" SC.FEC_FACT as FECHAFACTURACION, ");
        sql.append(" SC.FEC_PROG_FACT as FECHAPREVISTAFACTURACION, ");
        sql.append(" SC.FOPA_OID_FORM_PAGO as FORMAPAGO, ");
        sql.append(" SC.GRPR_OID_GRUP_PROC as GRUPOPROCESOS, ");
        sql.append(" SC.IND_APLI_MANU as INDICADORAPLICACIONMANUAL, ");
        sql.append(" SC.IND_ESTA as INDICADORESTADISTICABLE, ");
        sql.append(" SC.IND_EXEN_FLET as INDICADOREXENTOFLETE, ");
        sql.append(" SC.IND_GENE_CC as INDICADORGENERACUENTACORRIENTE, ");
        sql.append(" SC.IND_IMPR as INDICADORIMPRESION, ");
        sql.append(" SC.TAIM_OID_TASA_IMPU as INDICADORIMPUESTOSFLETE, ");
        sql.append(" SC.IND_OC as INDICADORORDENCOMPRA, ");
        sql.append(" SC.IND_PEDI_PRUE as INDICADORPEDIDOPRUEBA, ");
        sql.append(" SC.IND_PERM_UNIO_SOL as PERMITEUNIONSOLICITUDES, ");
        sql.append(" SC.IND_TS_NO_CONSO as INDICADORTSNOCONSOLIDADO, ");
        sql.append(" SC.INRE_OID_INDI_REVI as INDICADORREVISION, ");  //pperez Incidencia BELC300023071

        //marca -> se saca de la relación con CRA_PERIO a través del campo PERD_OID_PERI de la tabla PED_SOLIC_CABEC 
        sql.append(" P.MARC_OID_MARC as MARCA, ");
        sql.append(" SC.MODU_OID_MODU as MODULO, ");
        sql.append(" SC.MONE_OID_MONE as MONEDA, ");
        sql.append(" SC.NUM_CLIEN as NUMEROCLIENTES, ");

        // numeroConsolidado -> si SOCA_OID_SOLI_CABE <> null, 
        //se accede por OID_SOLI_CABE = SOCA_OID_SOLI_CABE y se 
        //obtiene el campo VAL_NUME_SOLI
        sql.append(
            " DECODE(SC.SOCA_OID_SOLI_CABE,NULL,NULL,(SELECT VAL_NUME_SOLI FROM PED_SOLIC_CABEC SCA WHERE SCA.OID_SOLI_CABE = SC.SOCA_OID_SOLI_CABE) ) as NUMEROCONSOLIDADO, ");
        sql.append(" SC.NUM_DOCU_ORIG as NUMERODOCUMENTOORIGEN, ");
        sql.append(" SC.NUM_PREM as NUMEROPREMIO, ");

        //numeroSecuenciaFacturacionDiaria -> se accede a la tabla PED_SOLIC_CABE_SECUE
        //usando OID_SOLI_CABE, y se obtiene NUM_SECU_FACT_DIAR 
        sql.append(" SCS.NUM_SECU_FACT_DIAR as NUMEROSECUENCIAFACTDIARIA, ");

        //numeroSecuenciaZonaRuta -> se accede a la tabla PED_SOLIC_CABE_SECUE 
        //usando OID_SOLI_CABE, y se obtiene NUM_SECU_ZONA_RUTA 
        sql.append(" SCS.NUM_SECU_ZONA_RUTA as numeroSecuenciaZonaRuta, ");
        sql.append(" SC.OID_SOLI_CABE as OIDCABECERASOLICITUD, ");
        sql.append(" SC.SOCA_OID_SOLI_CABE as OIDCONSOLIDADO, ");
        sql.append(" SC.CLDI_OID_CLIE_DIRE as OIDDIRECCIONCLIENTE, ");
        sql.append(" SC.CLIE_OID_CLIE_PAGA as OIDPAGADORFACTURA, ");
        sql.append(" SC.OPER_OID_OPER as OPERACION, ");
        sql.append(" SC.PAIS_OID_PAIS as PAIS, ");
        sql.append(" SC.PERD_OID_PERI as PERIODO, ");
        sql.append(" SC.PROC_OID_PROC as PROCESO, ");
        sql.append(" SC.VAL_PREC_NETO_TOTA_LOCA as PRECIOTOTALTOTALLOCAL, ");
        sql.append(" SC.VAL_PREC_NETO_TOTA_DOCU as PRECIOTOTALTOTALDOCUMENTO, ");
        sql.append(" SC.VAL_PUNT_EMIS as PUNTOEMISION, ");
        sql.append(" SC.CLIE_OID_CLIE_RECE_FACT as RECEPTORFACTURA, ");

        //region -> se accede a la tabla ZON_ZONA usando ZZON_OID_ZONA y se obtiene ZORG_OID_REGI, 
        sql.append(" Z.ZORG_OID_REGI as region, ");

        //seccion -> se accede a la tabla ZON_TERRI_ADMI usando ZTAD_OID_TERR_ADMI, y se obtiene OID_SECC, 
        sql.append(
            " (SELECT ZSCC_OID_SECC FROM ZON_TERRI_ADMIN TA WHERE TA.OID_TERR_ADMI = SC.ZTAD_OID_TERR_ADMI) as seccion, ");

        //secuenciaRutaTerritorio -> se accede a la tabla PED_SOLIC_CABE_SECUE 
        //usando OID_SOLI_CABE, y se obtiene VAL_SECU_RUTA_TERR 
        sql.append(" SCS.VAL_SECU_RUTA_TERR as secuenciaRutaTerritorio, ");

        sql.append(" SC.SBAC_OID_SBAC as SUBACCESO, ");
        sql.append(" SC.SBTI_OID_SUBT_CLIE as SUBTIPOCLIENTE, ");
        sql.append(" SC.ZTAD_OID_TERR_ADMI as TERRITORIOCLIENTE, ");
        sql.append(" SC.SOCA_OID_DOCU_REFE as OIDDOCUMENTOREFERENCIA, ");
        sql.append(" SC.SOCI_OID_SOCI as SOCIEDAD, ");
        sql.append(" SC.TDOC_OID_TIPO_DOCU as TIPODOCUMENTO, ");
        sql.append(" SC.TIDO_OID_TIPO_DOCU as TIPODOCUMENTOLEGAL, ");
        sql.append(" SC.TERR_OID_TERR as TERRITORIO, ");
        sql.append(" SC.TICL_OID_TIPO_CLIE as TIPOCLIENTE, ");
        sql.append(" SC.TIDS_OID_TIPO_DESP as TIPODESPACHO, ");
        sql.append(" SC.TSPA_OID_TIPO_SOLI_PAIS as TIPOSOLICITUD, ");
        sql.append(
            " SC.TSPA_OID_TIPO_SOLI_PAIS_CONS as TIPOSOLICITUDCONSOLIDADO, ");
        sql.append(" SC.VAL_BASE_FLET_DOCU as BASEFLETEDOCUMENTO, ");
        sql.append(" SC.VAL_BASE_FLET_LOCA as BASEFLETELOCAL, ");
        sql.append(" SC.VAL_GLOS_OBSE as OBSERVACIONES, ");
        sql.append(" SC.VAL_IMPO_DESC_1_TOTA_DOCU as IMPORTEDESCUENTO1TD, ");
        sql.append(" SC.VAL_IMPO_DESC_1_TOTA_LOCA as IMPORTEDESCUENTO1TL, ");
        sql.append(" SC.VAL_IMPO_DESC_3_TOTA_DOCU as IMPORTEDESCUENTO3TD, ");
        sql.append(" SC.VAL_IMPO_DESC_3_TOTA_LOCA as IMPORTEDESCUENTO3TL, ");
        sql.append(" SC.VAL_IMPO_DESC_TOTA_DOCU as IMPORTEDESCUENTOTD, ");
        sql.append(" SC.VAL_IMPO_DESC_TOTA_LOCA as IMPORTEDESCUENTOTL, ");
        sql.append(" SC.VAL_IMPO_FLET_DOCU as IMPORTEFLETEDOCUMENTO, ");
        sql.append(" SC.VAL_IMPO_FLET_LOCA as IMPORTEFLETELOCAL, ");
        sql.append(
            " SC.VAL_IMPO_FLET_SIN_IMPU_TOTA as IMPORTEFLETESIMPUESTOSTL, ");
        sql.append(
            " SC.VAL_IMPO_FLET_SIN_IMPU_DOCU as IMPORTEFLETESINIMPUESTOSTD, ");
        sql.append(" SC.VAL_IMPO_FLET_TOTA_DOCU as IMPORTEFLETETOTALDOCUMENTO, ");
        sql.append(" SC.VAL_IMPO_FLET_TOTA_LOCA as IMPORTEFLETETOTALLOCAL, ");
        sql.append(" SC.VAL_NUME_SOLI as NUMEROSOLICITUD, ");
        sql.append(" SC.VAL_OTRO_RECA_DOCU as OTROSRECARGOSDOCUMENTO, ");
        sql.append(" SC.VAL_OTRO_RECA_LOCA as OTROSRECARGOSLOCAL, ");
        sql.append(" SC.VAL_PREC_CONT_TOTA_LOCA as PRECIOCONTABLETOTALLOCAL, ");
        sql.append(" SC.VAL_RECA_FLET_DOCU as RECARGOFLETEDOCUMENTO, ");
        sql.append(" SC.VAL_RECA_FLET_LOCA as RECARGOFLETELOCAL, ");
        sql.append(" SC.VAL_TIPO_CAMB as TIPOCAMBIO, ");
        sql.append(" SC.VAL_TOTA_FLET_DOCU as TOTALFLETEDOCUMENTO, ");
        sql.append(" SC.VAL_TOTA_FLET_LOCA as TOTALFLETELOCAL, ");
        sql.append(" SC.VAL_TOTA_PAGA_DOCU as TOTALAPAGARDOCUMENTO, ");
        sql.append(" SC.VAL_TOTA_PAGA_LOCA as TOTALAPAGARLOCAL, ");
        sql.append(" SC.VAL_USUA as USUARIO, ");
        sql.append(" SC.ZZON_OID_ZONA as ZONA, ");
        sql.append(" SC.VEPO_OID_VALO_ESTR_GEOP as UBIGEO, ");
        sql.append(" SC.NUM_DOCU_CONT_INTE as NUMERODOCUMENTOCONTABLEINTERNO, ");

        sql.append("             CASE WHEN (SC.MONE_OID_MONE IS NULL) THEN "); 
        sql.append("               (  ");
        sql.append("               SELECT NUM_DECI ");                     
        sql.append("               FROM SEG_PAIS PAIS, SEG_MONED MON ");                     
        sql.append("               WHERE PAIS.MONE_OID_MONE = MON.OID_MONE ");                     
        sql.append("                 AND PAIS.OID_PAIS = SC.PAIS_OID_PAIS ");                     
        sql.append("               ) "); 
        sql.append("             ELSE "); 
        sql.append("               (  ");
        sql.append("               SELECT NUM_DECI ");                     
        sql.append("               FROM SEG_MONED MON ");                     
        sql.append("               WHERE MON.OID_MONE = SC.MONE_OID_MONE ");                            
        sql.append("               ) "); 
        sql.append("             END NUM_DECI "); 

        sql.append(" FROM PED_SOLIC_CABEC SC left join PED_SOLIC_CABEC_SECUE SCS on (SCS.SOCA_OID_SOLI_CABE = SC.OID_SOLI_CABE), CRA_PERIO P, ZON_ZONA Z");
        sql.append(" WHERE SC.SOCA_OID_SOLI_CABE = ? ");
       sql.append(" AND P.OID_PERI = SC.PERD_OID_PERI ");
       sql.append(" AND Z.OID_ZONA = SC.ZZON_OID_ZONA ");

        parametros.add(oidConsolidado);

        // Se ejecuta la consulta 
        BelcorpService bs = UtilidadesEJB.getBelcorpService();
        RecordSet rs = null;
        String codigoError = null;

        try {
            rs = bs.dbService.executePreparedQuery(sql.toString(), parametros);
        } catch (Exception e) {
            codigoError = CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS;
            this.logError("obtenerCabecerasDeUnConsolidado: Exception", e);
            this.logSql("obtenerCabecerasDeUnConsolidado. SQL: ",
                sql.toString(), parametros);
            throw new MareException(e,
                UtilidadesError.armarCodigoError(codigoError));
        }
        
        UtilidadesLog.debug("rs = " + rs);

        ArrayList listaDtos = new ArrayList();

        if (!rs.esVacio()) {
            for (int i = 0; i < rs.getRowCount(); i++) {
                DTOFACCabeceraSolicitud dtoCabSolic = new DTOFACCabeceraSolicitud();

                if (rs.getValueAt(i, "ACCESOFISICO") != null) {
                    Long accesoFisico = new Long(((BigDecimal) rs.getValueAt(
                                i, "ACCESOFISICO")).longValue());
                    dtoCabSolic.setAccesoFisico(accesoFisico);
                }

                if (rs.getValueAt(i, "ALMACEN") != null) {
                    Long almacen = new Long(((BigDecimal) rs.getValueAt(i,
                                "ALMACEN")).longValue());
                    dtoCabSolic.setAlmacen(almacen);
                }

                if (rs.getValueAt(i, "CLASESOLICITUD") != null) {
                    Long claseSolicitud = new Long(((BigDecimal) rs.getValueAt(
                                i, "CLASESOLICITUD")).longValue());
                    dtoCabSolic.setClaseSolicitud(claseSolicitud);
                }

                if (rs.getValueAt(i, "CLASIFICACION") != null) {
                    Long clasificacion = new Long(((BigDecimal) rs.getValueAt(
                                i, "CLASIFICACION")).longValue());
                    dtoCabSolic.setClasificacion(clasificacion);
                }

                if (rs.getValueAt(i, "OIDCLIENTE") != null) {
                    Long oidCliente = new Long(((BigDecimal) rs.getValueAt(i,
                                "OIDCLIENTE")).longValue());
                    dtoCabSolic.setOidCliente(oidCliente);
                }

                if (rs.getValueAt(i, "CONSULTORAASOCIADA") != null) {
                    Long consultoraAsociada = new Long(((BigDecimal) rs.getValueAt(
                                i, "CONSULTORAASOCIADA")).longValue());
                    dtoCabSolic.setConsultoraAsociada(consultoraAsociada);
                }

                if (rs.getValueAt(i, "TIPOCLASIFICACION") != null) {
                    Long tipoClasificacion = new Long(((BigDecimal) rs.getValueAt(
                                i, "TIPOCLASIFICACION")).longValue());
                    dtoCabSolic.setTipoClasificacion(tipoClasificacion);
                }

                if (rs.getValueAt(i, "ESTADO") != null) {
                    Long estado = new Long(((BigDecimal) rs.getValueAt(i,
                                "ESTADO")).longValue());
                    dtoCabSolic.setFormaPago(estado);
                }

                if (rs.getValueAt(i, "DESTINATARIO") != null) {
                    Long destinatario = new Long(((BigDecimal) rs.getValueAt(
                                i, "DESTINATARIO")).longValue());
                    dtoCabSolic.setDestinatario(destinatario);
                }

                if (rs.getValueAt(i, "FECHA") != null) {
                    Date fecha = (Date) rs.getValueAt(i, "FECHA");
                    dtoCabSolic.setFecha(fecha);
                }

                if (rs.getValueAt(i, "FECHAFACTURACION") != null) {
                    Date fechaFact = (Date) rs.getValueAt(i, "FECHAFACTURACION");
                    dtoCabSolic.setFecha(fechaFact);
                }

                if (rs.getValueAt(i, "FECHAPREVISTAFACTURACION") != null) {
                    Date fechaPrevistaFacturacion = (Date) rs.getValueAt(i,
                            "FECHAPREVISTAFACTURACION");
                    dtoCabSolic.setFechaPrevistaFacturacion(fechaPrevistaFacturacion);
                }

                if (rs.getValueAt(i, "FORMAPAGO") != null) {
                    Long formaPago = new Long(((BigDecimal) rs.getValueAt(i,
                                "FORMAPAGO")).longValue());
                    dtoCabSolic.setFormaPago(formaPago);
                }

                if (rs.getValueAt(i, "GRUPOPROCESOS") != null) {
                    Long grupoProcesos = new Long(((BigDecimal) rs.getValueAt(
                                i, "GRUPOPROCESOS")).longValue());
                    dtoCabSolic.setGrupoProcesos(grupoProcesos);
                }

                Boolean indicadorAM;

                if (rs.getValueAt(i, "INDICADORAPLICACIONMANUAL") != null) {
                    indicadorAM = new Boolean((((BigDecimal) rs.getValueAt(i,
                                "INDICADORAPLICACIONMANUAL")).intValue() == 1)
                            ? true : false);
                    dtoCabSolic.setIndicadorAplicacionManual(indicadorAM);
                }

                Boolean indicadorE;

                if (rs.getValueAt(i, "INDICADORESTADISTICABLE") != null) {
                    indicadorE = new Boolean((((BigDecimal) rs.getValueAt(i,
                                "INDICADORESTADISTICABLE")).intValue() == 1)
                            ? true : false);
                    dtoCabSolic.setIndicadorEstadisticable(indicadorE);
                }

                Boolean indicadorExento;

                if (rs.getValueAt(i, "INDICADOREXENTOFLETE") != null) {
                    indicadorExento = new Boolean((((BigDecimal) rs.getValueAt(
                                i, "INDICADOREXENTOFLETE")).intValue() == 1)
                            ? true : false);
                    dtoCabSolic.setIndicadorExentoFlete(indicadorExento);
                }

                Boolean indicadorCuenta;

                if (rs.getValueAt(i, "INDICADORGENERACUENTACORRIENTE") != null) {
                    indicadorCuenta = new Boolean((((BigDecimal) rs.getValueAt(
                                i, "INDICADORGENERACUENTACORRIENTE")).intValue() == 1)
                            ? true : false);
                    dtoCabSolic.setIndicadorGeneraCuentaCorriente(indicadorCuenta);
                }

                Boolean indicadorImpresion;

                if (rs.getValueAt(i, "INDICADORIMPRESION") != null) {
                    indicadorImpresion = new Boolean((((BigDecimal) rs.getValueAt(
                                i, "INDICADORIMPRESION")).intValue() == 1)
                            ? true : false);
                    dtoCabSolic.setIndicadorImpresion(indicadorImpresion);
                }

                if (rs.getValueAt(i, "INDICADORIMPUESTOSFLETE") != null) {
                    Long indicadorImpuestosFlete = new Long(((BigDecimal) rs.getValueAt(
                                i, "INDICADORIMPUESTOSFLETE")).longValue());
                    dtoCabSolic.setIndicadorImpuestosFlete(indicadorImpuestosFlete);
                }

                Boolean indOrdenCompra;

                if (rs.getValueAt(i, "INDICADORORDENCOMPRA") != null) {
                    indOrdenCompra = new Boolean((((BigDecimal) rs.getValueAt(
                                i, "INDICADORORDENCOMPRA")).intValue() == 1)
                            ? true : false);
                    dtoCabSolic.setIndicadorOrdenCompra(indOrdenCompra);
                }

                Boolean indPedidoPrueba;

                if (rs.getValueAt(i, "INDICADORPEDIDOPRUEBA") != null) {
                    indPedidoPrueba = new Boolean((((BigDecimal) rs.getValueAt(
                                i, "INDICADORPEDIDOPRUEBA")).intValue() == 1)
                            ? true : false);
                    dtoCabSolic.setIndicadorPedidoPrueba(indPedidoPrueba);
                }

                Boolean permiteUnionS;

                if (rs.getValueAt(i, "PERMITEUNIONSOLICITUDES") != null) {
                    permiteUnionS = new Boolean((((BigDecimal) rs.getValueAt(
                                0, "PERMITEUNIONSOLICITUDES")).intValue() == 1)
                            ? true : false);
                    dtoCabSolic.setPermiteUnionSolicitudes(permiteUnionS);
                }

                Boolean indicadorNoConso;

                if (rs.getValueAt(i, "INDICADORTSNOCONSOLIDADO") != null) {
                    indicadorNoConso = new Boolean((((BigDecimal) rs.getValueAt(
                                i, "INDICADORTSNOCONSOLIDADO")).intValue() == 1)
                            ? true : false);
                    dtoCabSolic.setIndTSNoConsolidado(indicadorNoConso);
                }

                if (rs.getValueAt(i, "INDICADORREVISION") != null) {
                    Long indRevision = new Long(((BigDecimal) rs.getValueAt(i,
                                "INDICADORREVISION")).longValue());
                    dtoCabSolic.setIndicadorRevision(indRevision);
                }

                if (rs.getValueAt(i, "MARCA") != null) {
                    Long marca = new Long(((BigDecimal) rs.getValueAt(i, "MARCA")).longValue());
                    dtoCabSolic.setMarca(marca);
                }

                if (rs.getValueAt(i, "MODULO") != null) {
                    Long modulo = new Long(((BigDecimal) rs.getValueAt(i,
                                "MODULO")).longValue());
                    dtoCabSolic.setModulo(modulo);
                }

                if (rs.getValueAt(i, "MONEDA") != null) {
                    Long moneda = new Long(((BigDecimal) rs.getValueAt(i,
                                "MONEDA")).longValue());
                    dtoCabSolic.setMoneda(moneda);
                }

                if (rs.getValueAt(i, "NUMEROCLIENTES") != null) {
                    Integer numCLientes = new Integer(((BigDecimal) rs.getValueAt(
                                i, "NUMEROCLIENTES")).intValue());
                    dtoCabSolic.setNumeroClientes(numCLientes);
                }

                if (rs.getValueAt(i, "NUMEROCONSOLIDADO") != null) {
                    Long numeroConsolidado = new Long(rs.getValueAt(i,
                                "NUMEROCONSOLIDADO").toString());
                    dtoCabSolic.setNumeroConsolidado(numeroConsolidado);
                }

                if (rs.getValueAt(i, "NUMERODOCUMENTOORIGEN") != null) {
                    Long numDocOrigen = new Long(((BigDecimal) rs.getValueAt(
                                i, "NUMERODOCUMENTOORIGEN")).longValue());
                    dtoCabSolic.setNumeroDocumentoOrigen(numDocOrigen);
                }

                if (rs.getValueAt(i, "NUMEROPREMIO") != null) {
                    Integer numPrenio = new Integer(((BigDecimal) rs.getValueAt(
                                i, "NUMEROPREMIO")).intValue());
                    dtoCabSolic.setNumeroPremio(numPrenio);
                }

                if (rs.getValueAt(i, "NUMEROSECUENCIAFACTDIARIA") != null) {
                    Integer numSecuFactDiaria = new Integer(((BigDecimal) rs.getValueAt(
                                i, "NUMEROSECUENCIAFACTDIARIA")).intValue());
                    dtoCabSolic.setNumeroSecuenciaFacturacionDiaria(numSecuFactDiaria);
                }

                if (rs.getValueAt(i, "NUMEROSECUENCIAZONARUTA") != null) {
                    Integer numSecuZonaRuta = new Integer(((BigDecimal) rs.getValueAt(
                                i, "NUMEROSECUENCIAZONARUTA")).intValue());
                    dtoCabSolic.setNumeroSecuenciaZonaRuta(numSecuZonaRuta);
                }

                if (rs.getValueAt(i, "OIDCABECERASOLICITUD") != null) {
                    Long oidCabeceraSolicitud = new Long(((BigDecimal) rs.getValueAt(
                                i, "OIDCABECERASOLICITUD")).longValue());
                    dtoCabSolic.setOidCabeceraSolicitud(oidCabeceraSolicitud);
                }

                if (rs.getValueAt(i, "OIDCONSOLIDADO") != null) {
                    Long oidCon = new Long(((BigDecimal) rs.getValueAt(i,
                                "OIDCONSOLIDADO")).longValue());
                    dtoCabSolic.setOidConsolidado(oidCon);
                }

                if (rs.getValueAt(i, "OIDDIRECCIONCLIENTE") != null) {
                    Long oidDireccionCliente = new Long(((BigDecimal) rs.getValueAt(
                                i, "OIDDIRECCIONCLIENTE")).longValue());
                    dtoCabSolic.setOidDireccionCliente(oidDireccionCliente);
                }

                if (rs.getValueAt(i, "OIDPAGADORFACTURA") != null) {
                    Long oidPagadorFactura = new Long(((BigDecimal) rs.getValueAt(
                                i, "OIDPAGADORFACTURA")).longValue());
                    dtoCabSolic.setOidPagadorFactura(oidPagadorFactura);
                }

                if (rs.getValueAt(i, "OPERACION") != null) {
                    Long operacion = new Long(((BigDecimal) rs.getValueAt(i,
                                "OPERACION")).longValue());
                    dtoCabSolic.setOperacion(operacion);
                }

                if (rs.getValueAt(i, "PAIS") != null) {
                    Long pais = new Long(((BigDecimal) rs.getValueAt(i, "PAIS")).longValue());
                    dtoCabSolic.setOidPais(pais);
                }

                if (rs.getValueAt(i, "PERIODO") != null) {
                    Long periodo = new Long(((BigDecimal) rs.getValueAt(i,
                                "PERIODO")).longValue());
                    dtoCabSolic.setPeriodo(periodo);
                }

                if (rs.getValueAt(i, "PROCESO") != null) {
                    Long proceso = new Long(((BigDecimal) rs.getValueAt(i,
                                "PROCESO")).longValue());
                    dtoCabSolic.setProceso(proceso);
                }

                if (rs.getValueAt(i, "PRECIOTOTALTOTALLOCAL") != null) {
                    Float precioTotalTotalLocal = new Float(((BigDecimal) rs.getValueAt(
                                i, "PRECIOTOTALTOTALLOCAL")).floatValue());
                    dtoCabSolic.setPrecioTotalTotalLocal(precioTotalTotalLocal);
                }

                if (rs.getValueAt(i, "PRECIOTOTALTOTALDOCUMENTO") != null) {
                    Float precioTotalTotalDocumento = new Float(((BigDecimal) rs.getValueAt(
                                i, "PRECIOTOTALTOTALDOCUMENTO")).floatValue());
                    dtoCabSolic.setPrecioTotalTotalDocumento(precioTotalTotalDocumento);
                }

                if (rs.getValueAt(i, "PUNTOEMISION") != null) {
                    String puntoEmision = rs.getValueAt(i, "PUNTOEMISION")
                                            .toString();
                    dtoCabSolic.setPuntoEmision(puntoEmision);
                }

                if (rs.getValueAt(i, "RECEPTORFACTURA") != null) {
                    Long receptorFactura = new Long(((BigDecimal) rs.getValueAt(
                                i, "RECEPTORFACTURA")).longValue());
                    dtoCabSolic.setReceptorFactura(receptorFactura);
                }

                if (rs.getValueAt(i, "REGION") != null) {
                    Long region = new Long(((BigDecimal) rs.getValueAt(i,
                                "REGION")).longValue());
                    dtoCabSolic.setRegion(region);
                }

                if (rs.getValueAt(i, "SECCION") != null) {
                    Long seccion = new Long(((BigDecimal) rs.getValueAt(i,
                                "SECCION")).longValue());
                    dtoCabSolic.setSeccion(seccion);
                }

                if (rs.getValueAt(i, "SECUENCIARUTATERRITORIO") != null) {
                    String secuenciaRutaTerritorio = rs.getValueAt(i,
                            "SECUENCIARUTATERRITORIO").toString();
                    dtoCabSolic.setSecuenciaRutaTerritorio(secuenciaRutaTerritorio);
                }

                if (rs.getValueAt(i, "SUBACCESO") != null) {
                    Long subacceso = new Long(((BigDecimal) rs.getValueAt(i,
                                "SUBACCESO")).longValue());
                    dtoCabSolic.setSubacceso(subacceso);
                }

                if (rs.getValueAt(i, "SUBTIPOCLIENTE") != null) {
                    Long subTipoCliente = new Long(((BigDecimal) rs.getValueAt(
                                i, "SUBTIPOCLIENTE")).longValue());
                    dtoCabSolic.setSubtipoCliente(subTipoCliente);
                }

                if (rs.getValueAt(i, "TERRITORIOCLIENTE") != null) {
                    Long territorioCliente = new Long(((BigDecimal) rs.getValueAt(
                                i, "TERRITORIOCLIENTE")).longValue());
                    dtoCabSolic.setTerritorioCliente(territorioCliente);
                }

                if (rs.getValueAt(i, "OIDDOCUMENTOREFERENCIA") != null) {
                    Long oidDocumentoReferencia = new Long(((BigDecimal) rs.getValueAt(
                                i, "OIDDOCUMENTOREFERENCIA")).longValue());
                    dtoCabSolic.setOidDocumentoReferencia(oidDocumentoReferencia);
                }

                if (rs.getValueAt(i, "SOCIEDAD") != null) {
                    Long sociedad = new Long(((BigDecimal) rs.getValueAt(i,
                                "SOCIEDAD")).longValue());
                    dtoCabSolic.setSociedad(sociedad);
                }

                if (rs.getValueAt(i, "TIPODOCUMENTO") != null) {
                    Long tipoDocumento = new Long(((BigDecimal) rs.getValueAt(
                                i, "TIPODOCUMENTO")).longValue());
                    dtoCabSolic.setTipoDocumento(tipoDocumento);
                }

                if (rs.getValueAt(i, "TIPODOCUMENTOLEGAL") != null) {
                    Long tipoDocumentoLegal = new Long(((BigDecimal) rs.getValueAt(
                                i, "TIPODOCUMENTOLEGAL")).longValue());
                    dtoCabSolic.setTipoDocumentoLegal(tipoDocumentoLegal);
                }

                if (rs.getValueAt(i, "TERRITORIO") != null) {
                    Long territorio = new Long(((BigDecimal) rs.getValueAt(i,
                                "TERRITORIO")).longValue());
                    dtoCabSolic.setTerritorio(territorio);
                }

                if (rs.getValueAt(i, "TIPOCLIENTE") != null) {
                    Long tipoCliente = new Long(((BigDecimal) rs.getValueAt(i,
                                "TIPOCLIENTE")).longValue());
                    dtoCabSolic.setTipoCliente(tipoCliente);
                }

                if (rs.getValueAt(i, "TIPODESPACHO") != null) {
                    Long tipoDespacho = new Long(((BigDecimal) rs.getValueAt(
                                i, "TIPODESPACHO")).longValue());
                    dtoCabSolic.setTipoDespacho(tipoDespacho);
                }

                if (rs.getValueAt(i, "TIPOSOLICITUD") != null) {
                    Long tipoSolicitud = new Long(((BigDecimal) rs.getValueAt(
                                i, "TIPOSOLICITUD")).longValue());
                    dtoCabSolic.setTipoSolicitud(tipoSolicitud);
                }

                if (rs.getValueAt(i, "TIPOSOLICITUDCONSOLIDADO") != null) {
                    Long tipoSolicConso = new Long(((BigDecimal) rs.getValueAt(
                                i, "TIPOSOLICITUDCONSOLIDADO")).longValue());
                    dtoCabSolic.setTipoSolicitudConsolidado(tipoSolicConso);
                }

                if (rs.getValueAt(i, "BASEFLETEDOCUMENTO") != null) {
                    Float baseFleteDoc = new Float(((BigDecimal) rs.getValueAt(
                                i, "BASEFLETEDOCUMENTO")).floatValue());
                    dtoCabSolic.setBaseFleteDocumento(baseFleteDoc);
                }

                if (rs.getValueAt(i, "BASEFLETELOCAL") != null) {
                    Float baseFleteLocal = new Float(((BigDecimal) rs.getValueAt(
                                i, "BASEFLETELOCAL")).floatValue());
                    dtoCabSolic.setBaseFleteLocal(baseFleteLocal);
                }

                if (rs.getValueAt(i, "OBSERVACIONES") != null) {
                    String observ = rs.getValueAt(i, "OBSERVACIONES").toString();
                    dtoCabSolic.setObservaciones(observ);
                }

                if (rs.getValueAt(i, "IMPORTEDESCUENTO1TD") != null) {
                    Float imDes1TipDoc1 = new Float(((BigDecimal) rs.getValueAt(
                                i, "IMPORTEDESCUENTO1TD")).floatValue());
                    dtoCabSolic.setImporteDescuento1TotalDocumento(imDes1TipDoc1);
                }

                if (rs.getValueAt(i, "IMPORTEDESCUENTO1TL") != null) {
                    Float imDes1TipLocal1 = new Float(((BigDecimal) rs.getValueAt(
                                i, "IMPORTEDESCUENTO1TL")).floatValue());
                    dtoCabSolic.setImporteDescuento1TotalLocal(imDes1TipLocal1);
                }

                if (rs.getValueAt(i, "IMPORTEDESCUENTO3TD") != null) {
                    Float imDes1TipDoc3 = new Float(((BigDecimal) rs.getValueAt(
                                i, "IMPORTEDESCUENTO3TD")).floatValue());
                    dtoCabSolic.setImporteDescuento3TotalDocumento(imDes1TipDoc3);
                }

                if (rs.getValueAt(i, "IMPORTEDESCUENTO3TL") != null) {
                    Float imDes1TipDoc3Local = new Float(((BigDecimal) rs.getValueAt(
                                i, "IMPORTEDESCUENTO3TL")).floatValue());
                    dtoCabSolic.setImporteDescuento3TotalLocal(imDes1TipDoc3Local);
                }

                if (rs.getValueAt(i, "IMPORTEDESCUENTOTD") != null) {
                    Float imDes1TotDoc = new Float(((BigDecimal) rs.getValueAt(
                                i, "IMPORTEDESCUENTOTD")).floatValue());
                    dtoCabSolic.setImporteDescuentoTotalDocumento(imDes1TotDoc);
                }

                if (rs.getValueAt(i, "IMPORTEDESCUENTOTL") != null) {
                    Float imDes1TotLocal = new Float(((BigDecimal) rs.getValueAt(
                                i, "IMPORTEDESCUENTOTL")).floatValue());
                    dtoCabSolic.setImporteDescuentoTotalLocal(imDes1TotLocal);
                }

                if (rs.getValueAt(i, "IMPORTEFLETEDOCUMENTO") != null) {
                    Float imFleteDoc = new Float(((BigDecimal) rs.getValueAt(
                                i, "IMPORTEFLETEDOCUMENTO")).floatValue());
                    dtoCabSolic.setImporteFleteDocumento(imFleteDoc);
                }

                if (rs.getValueAt(i, "IMPORTEFLETELOCAL") != null) {
                    Float imFleteLocal = new Float(((BigDecimal) rs.getValueAt(
                                i, "IMPORTEFLETELOCAL")).floatValue());
                    dtoCabSolic.setImporteFleteLocal(imFleteLocal);
                }

                if (rs.getValueAt(i, "IMPORTEFLETESIMPUESTOSTL") != null) {
                    Float imFleteTotalDoc = new Float(((BigDecimal) rs.getValueAt(
                                i, "IMPORTEFLETESIMPUESTOSTL")).floatValue());
                    dtoCabSolic.setImporteFleteTotalDocumento(imFleteTotalDoc);
                }

                if (rs.getValueAt(i, "IMPORTEFLETESINIMPUESTOSTD") != null) {
                    Float imFleteTotalLocal = new Float(((BigDecimal) rs.getValueAt(
                                i, "IMPORTEFLETESINIMPUESTOSTD")).floatValue());
                    dtoCabSolic.setImporteFleteTotalLocal(imFleteTotalLocal);
                }

                if (rs.getValueAt(i, "IMPORTEFLETETOTALDOCUMENTO") != null) {
                    Float imFleteTotalDoc = new Float(((BigDecimal) rs.getValueAt(
                                i, "IMPORTEFLETETOTALDOCUMENTO")).floatValue());
                    dtoCabSolic.setImporteFleteTotalDocumento(imFleteTotalDoc);
                }

                if (rs.getValueAt(i, "IMPORTEFLETETOTALLOCAL") != null) {
                    Float imFleteTotalLocal = new Float(((BigDecimal) rs.getValueAt(
                                i, "IMPORTEFLETETOTALLOCAL")).floatValue());
                    dtoCabSolic.setImporteFleteTotalLocal(imFleteTotalLocal);
                }

                if (rs.getValueAt(i, "NUMEROSOLICITUD") != null) {
                    Long numeroSolic = new Long(((BigDecimal) rs.getValueAt(i,
                                "NUMEROSOLICITUD")).longValue());
                    dtoCabSolic.setNumeroSolicitud(numeroSolic);
                }

                if (rs.getValueAt(i, "OTROSRECARGOSDOCUMENTO") != null) {
                    Float otrosCargosDoc = new Float(((BigDecimal) rs.getValueAt(
                                i, "OTROSRECARGOSDOCUMENTO")).floatValue());
                    dtoCabSolic.setOtrosRecargosDocumento(otrosCargosDoc);
                }

                if (rs.getValueAt(i, "OTROSRECARGOSLOCAL") != null) {
                    Float otrosRecargosLocal = new Float(((BigDecimal) rs.getValueAt(
                                i, "OTROSRECARGOSLOCAL")).floatValue());
                    dtoCabSolic.setOtrosRecargosLocal(otrosRecargosLocal);
                }

                if (rs.getValueAt(i, "PRECIOCONTABLETOTALLOCAL") != null) {
                    Float precioContableTotLocal = new Float(((BigDecimal) rs.getValueAt(
                                i, "PRECIOCONTABLETOTALLOCAL")).floatValue());
                    dtoCabSolic.setPrecioContableTotalLocal(precioContableTotLocal);
                }

                if (rs.getValueAt(i, "RECARGOFLETEDOCUMENTO") != null) {
                    Float recargoFleteDoc = new Float(((BigDecimal) rs.getValueAt(
                                i, "RECARGOFLETEDOCUMENTO")).floatValue());
                    dtoCabSolic.setRecargoFleteDocumento(recargoFleteDoc);
                }

                if (rs.getValueAt(i, "RECARGOFLETELOCAL") != null) {
                    Float recargoFleteLocal = new Float(((BigDecimal) rs.getValueAt(
                                i, "RECARGOFLETELOCAL")).floatValue());
                    dtoCabSolic.setRecargoFleteLocal(recargoFleteLocal);
                }

                if (rs.getValueAt(i, "TIPOCAMBIO") != null) {
                    BigDecimal tipoCambio = (BigDecimal) rs.getValueAt(i,
                            "TIPOCAMBIO");
                    dtoCabSolic.setTipoCambio(tipoCambio);
                }

                if (rs.getValueAt(i, "TOTALFLETEDOCUMENTO") != null) {
                    Float totalFleteDoc = new Float(((BigDecimal) rs.getValueAt(
                                i, "TOTALFLETEDOCUMENTO")).floatValue());
                    dtoCabSolic.setTotalFleteDocumento(totalFleteDoc);
                }

                if (rs.getValueAt(i, "TOTALFLETELOCAL") != null) {
                    Float totalFleteLocal = new Float(((BigDecimal) rs.getValueAt(
                                i, "TOTALFLETELOCAL")).floatValue());
                    dtoCabSolic.setTotalFleteLocal(totalFleteLocal);
                }

                if (rs.getValueAt(i, "TOTALAPAGARDOCUMENTO") != null) {
                    Float totAPagarDoc = new Float(((BigDecimal) rs.getValueAt(
                                i, "TOTALAPAGARDOCUMENTO")).floatValue());
                    dtoCabSolic.setTotalAPagarDocumento(totAPagarDoc);
                }

                if (rs.getValueAt(i, "TOTALAPAGARLOCAL") != null) {
                    Float totAPagarLocal = new Float(((BigDecimal) rs.getValueAt(
                                i, "TOTALAPAGARLOCAL")).floatValue());
                    dtoCabSolic.setTotalAPagarLocal(totAPagarLocal);
                }

                if (rs.getValueAt(i, "USUARIO") != null) {
                    String usuario = rs.getValueAt(i, "USUARIO").toString();
                    dtoCabSolic.setUsuario(usuario);
                }

                if (rs.getValueAt(i, "ZONA") != null) {
                    Long zona = new Long(((BigDecimal) rs.getValueAt(i, "ZONA")).longValue());
                    dtoCabSolic.setZona(zona);
                }

                if (rs.getValueAt(i, "UBIGEO") != null) {
                    Long ubigeo = new Long(((BigDecimal) rs.getValueAt(i,
                                "UBIGEO")).longValue());
                    dtoCabSolic.setDestinatario(ubigeo);
                }

                if (rs.getValueAt(i, "NUMERODOCUMENTOCONTABLEINTERNO") != null) {
                    Long numeroDocConInt = new Long(((BigDecimal) rs.getValueAt(
                                i, "NUMERODOCUMENTOCONTABLEINTERNO")).longValue());
                    dtoCabSolic.setDestinatario(numeroDocConInt);
                }
                dtoCabSolic.setNumeroDecimalesRedondeo(UtilidadesBD.convertirAInteger(rs.getValueAt(i, "NUM_DECI")));
                if (dtoCabSolic.getNumeroDecimalesRedondeo() == null) {
                    dtoCabSolic.setNumeroDecimalesRedondeo(new Integer(0));
                }
                
                listaDtos.add(dtoCabSolic);
            }
             //for
        }
         //if rs.vacio

        UtilidadesLog.debug("listaDtos a devolver: " + listaDtos);
        UtilidadesLog.info("DAOGestionDocumentos.obtenerCabecerasDeUnConsolidado(Long oidConsolidado): Salida");
        return listaDtos;
    }

    // consulta modificada por la BELC300011917 y la BELC300016098
    public ArrayList obtenerFormulariosUltimasNoticias(
        Long oidSoliCabe, Long subacceso) throws MareException {
        UtilidadesLog.info("DAOGestionDocumentos.obtenerFormulariosUltimasNoticias(Long oidSoliCabe, Long subacceso): Entrada");
        // Parametros de la consulta
        Vector parametros = new Vector();

        // Se crea la consulta SQL
        StringBuffer sql = new StringBuffer();


        sql.append(" SELECT A.OID_FORM, E.IMVI_OID_IMPR, A.VAL_RUTI_DISE_FORM ");
        sql.append(" FROM FAC_FORMU A, ");
        sql.append(" FAC_FORMU_TIPO_SOLIC B, ");
        sql.append(" FAC_TIPO_FORMU C, PED_SOLIC_CABEC D, FAC_ASIGN_IMPRE E ");
        sql.append(" WHERE B.TSPA_OID_TIPO_SOLI_PAIS = D.TSPA_OID_TIPO_SOLI_PAIS "); 
        sql.append(" AND D.OID_SOLI_CABE = ? ");
        parametros.add(oidSoliCabe);

        sql.append(" AND A.OID_FORM = B.FORS_OID_FORM ");
        sql.append(" AND A.IND_IMPR = 1 ");
        sql.append(" AND C.OID_TIPO_FORM = A.TIFO_OID_TIPO_FORM ");
        sql.append(" AND C.COD_TIPO_FORM = 'U' ");
        sql.append(" AND E.SBAC_OID_SBAC= ? ");
        parametros.add(subacceso);
        sql.append(" AND E.FORS_OID_FORM=A.OID_FORM ");

        sql.append(" ORDER BY B.NUM_ORDE_SECU  ");
        
/*        sql.append(" SELECT A.OID_FORM, A.IMVI_OID_IMPR, A.VAL_RUTI_DISE_FORM ");
        sql.append(" FROM FAC_FORMU A, ");
        sql.append(" FAC_FORMU_TIPO_SOLIC B, ");
        sql.append(" FAC_TIPO_FORMU C, PED_SOLIC_CABEC D ");
        sql.append(" WHERE D.OID_SOLI_CABE = ? AND B.TSPA_OID_TIPO_SOLI_PAIS = D.TSPA_OID_TIPO_SOLI_PAIS "); //BELC300011917
        parametros.add(oidSoliCabe);

        sql.append(" AND A.OID_FORM = B.FORS_OID_FORM ");
        sql.append(" AND A.IND_IMPR = 1 ");
        sql.append(" AND C.OID_TIPO_FORM = A.TIFO_OID_TIPO_FORM ");
        sql.append(" AND C.COD_TIPO_FORM = 'U' ");
        sql.append(" ORDER BY B.NUM_ORDE_SECU  ");
*/
        // Se ejecuta la consulta 
        BelcorpService bs = UtilidadesEJB.getBelcorpService();
        RecordSet rs = null;
        String codigoError = null;

        try {
            rs = bs.dbService.executePreparedQuery(sql.toString(), parametros);
        } catch (Exception e) {
            codigoError = CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS;
            this.logError("obtenerFormulariosUltimasNoticias: Exception", e);
            this.logSql("obtenerFormulariosUltimasNoticias. SQL: ",
                sql.toString(), parametros);
            throw new MareException(e,
                UtilidadesError.armarCodigoError(codigoError));
        }

        ArrayList listaDtos = new ArrayList();

        if (!rs.esVacio()) {
            for (int i = 0; i < rs.getRowCount(); i++) {
                DTODatosTipoFormulario dtoDTF = new DTODatosTipoFormulario();

                if (rs.getValueAt(i, "OID_FORM") != null) {
                    Long oidFormulario = new Long(((BigDecimal) rs.getValueAt(
                                i, "OID_FORM")).longValue());
                    dtoDTF.setOidFormulario(oidFormulario);
                }

                if (rs.getValueAt(i, "IMVI_OID_IMPR") != null) {
                    Long impresora = new Long(((BigDecimal) rs.getValueAt(i,
                                "IMVI_OID_IMPR")).longValue());
                    dtoDTF.setIdImpresoraVirtual(impresora);
                }

                if (rs.getValueAt(i, "VAL_RUTI_DISE_FORM") != null) {
                    String rutina = rs.getValueAt(i, "VAL_RUTI_DISE_FORM")
                                      .toString();
                    dtoDTF.setRutinaDiseñoFormulario(rutina);
                }

                listaDtos.add(dtoDTF);
            }
             //for
        }
         //if rs.vacio

        UtilidadesLog.info("DAOGestionDocumentos.obtenerFormulariosUltimasNoticias(Long oidSoliCabe, Long subacceso): Salida");
        return listaDtos;
    }
    
    // consulta modificada por la BELC300011917 y la BELC300016098
    public ArrayList obtenerFormulariosCartaConsultoras(
        Long oidSoliCabe, Long subacceso) throws MareException {
        UtilidadesLog.info("DAOGestionDocumentos.obtenerFormulariosCartaConsultoras(Long oidSoliCabe, Long subacceso): Entrada");
        // Parametros de la consulta
        Vector parametros = new Vector();

        // Se crea la consulta SQL
        StringBuffer sql = new StringBuffer();

        sql.append(" SELECT A.OID_FORM, E.IMVI_OID_IMPR, A.VAL_RUTI_DISE_FORM ");
        sql.append(" FROM FAC_FORMU A, ");
        sql.append(" FAC_FORMU_TIPO_SOLIC B, ");
        sql.append(" FAC_TIPO_FORMU C, PED_SOLIC_CABEC D, ");
        sql.append(" FAC_ASIGN_IMPRE E ");
        sql.append(" WHERE B.TSPA_OID_TIPO_SOLI_PAIS = D.TSPA_OID_TIPO_SOLI_PAIS "); 
        sql.append(" AND D.OID_SOLI_CABE = ? ");
        parametros.add(oidSoliCabe);

        sql.append(" AND A.OID_FORM = B.FORS_OID_FORM ");
        sql.append(" AND A.IND_IMPR = 1 ");
        sql.append(" AND C.OID_TIPO_FORM = A.TIFO_OID_TIPO_FORM ");
        sql.append(" AND C.COD_TIPO_FORM = 'C' ");
        sql.append(" AND E.SBAC_OID_SBAC= ? ");
        parametros.add(subacceso);
        sql.append(" AND E.FORS_OID_FORM=A.OID_FORM ");

        sql.append(" ORDER BY B.NUM_ORDE_SECU ");
        
        /* sql.append(" SELECT A.OID_FORM, A.IMVI_OID_IMPR, A.VAL_RUTI_DISE_FORM ");
        sql.append(" FROM FAC_FORMU A, ");
        sql.append(" FAC_FORMU_TIPO_SOLIC B, ");
        sql.append(" FAC_TIPO_FORMU C, PED_SOLIC_CABEC D ");
        sql.append(" WHERE D.OID_SOLI_CABE = ? AND B.TSPA_OID_TIPO_SOLI_PAIS = D.TSPA_OID_TIPO_SOLI_PAIS "); //BELC300011917
        parametros.add(oidSoliCabe);

        sql.append(" AND A.OID_FORM = B.FORS_OID_FORM ");
        sql.append(" AND A.IND_IMPR = 1 ");
        sql.append(" AND C.OID_TIPO_FORM = A.TIFO_OID_TIPO_FORM ");
        sql.append(" AND C.COD_TIPO_FORM = 'C' ");
        sql.append(" ORDER BY B.NUM_ORDE_SECU ");*/

        // Se ejecuta la consulta 
        BelcorpService bs = UtilidadesEJB.getBelcorpService();
        RecordSet rs = null;
        String codigoError = null;

        try {
            rs = bs.dbService.executePreparedQuery(sql.toString(), parametros);
        } catch (Exception e) {
            codigoError = CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS;
            this.logError("obtenerFormulariosCartaConsultoras: Exception", e);
            this.logSql("obtenerFormulariosCartaConsultoras. SQL: ",
                sql.toString(), parametros);
            throw new MareException(e,
                UtilidadesError.armarCodigoError(codigoError));
        }

        ArrayList listaDtos = new ArrayList();

        if (!rs.esVacio()) {
            for (int i = 0; i < rs.getRowCount(); i++) {
                DTODatosTipoFormulario dtoDTF = new DTODatosTipoFormulario();

                if (rs.getValueAt(i, "OID_FORM") != null) {
                    Long oidFormulario = new Long(((BigDecimal) rs.getValueAt(
                                i, "OID_FORM")).longValue());
                    dtoDTF.setOidFormulario(oidFormulario);
                }

                if (rs.getValueAt(i, "IMVI_OID_IMPR") != null) {
                    Long impresora = new Long(((BigDecimal) rs.getValueAt(i,
                                "IMVI_OID_IMPR")).longValue());
                    dtoDTF.setIdImpresoraVirtual(impresora);
                }

                if (rs.getValueAt(i, "VAL_RUTI_DISE_FORM") != null) {
                    String rutina = rs.getValueAt(i, "VAL_RUTI_DISE_FORM")
                                      .toString();
                    dtoDTF.setRutinaDiseñoFormulario(rutina);
                }

                listaDtos.add(dtoDTF);
            }
             //for
        }
         //if rs.vacio      

        UtilidadesLog.info("DAOGestionDocumentos.obtenerFormulariosCartaConsultoras(Long oidSoliCabe, Long subacceso): Salida");
        return listaDtos;
    }

    // consulta modificada por la BELC300011917 y la BELC300016098
    public ArrayList obtenerFormulariosBoletaDespacho(Long oidSoliCabe, Long subacceso)
        throws MareException {
        UtilidadesLog.info("DAOGestionDocumentos.obtenerFormulariosBoletaDespacho(Long oidSoliCabe, Long subacceso): Entrada");
        // Parametros de la consulta
        Vector parametros = new Vector();

        // Se crea la consulta SQL
        StringBuffer sql = new StringBuffer();

        sql.append(" SELECT A.OID_FORM, E.IMVI_OID_IMPR, A.VAL_RUTI_DISE_FORM ");
        sql.append(" FROM FAC_FORMU A, ");
        sql.append(" FAC_FORMU_TIPO_SOLIC B, ");
        sql.append(" FAC_TIPO_FORMU C, PED_SOLIC_CABEC D, FAC_ASIGN_IMPRE E ");
        sql.append(" WHERE B.TSPA_OID_TIPO_SOLI_PAIS = D.TSPA_OID_TIPO_SOLI_PAIS "); //BELC300011917
        sql.append(" AND D.OID_SOLI_CABE = ? ");
        parametros.add(oidSoliCabe);

        sql.append(" AND A.OID_FORM = B.FORS_OID_FORM ");
        sql.append(" AND A.IND_IMPR = 1 ");
        sql.append(" AND C.OID_TIPO_FORM = A.TIFO_OID_TIPO_FORM ");
        sql.append(" AND C.COD_TIPO_FORM = 'B' ");

        sql.append(" AND E.SBAC_OID_SBAC= ? ");
        parametros.add(subacceso);
        sql.append(" AND E.FORS_OID_FORM=A.OID_FORM ");

        sql.append(" ORDER BY B.NUM_ORDE_SECU ");
        
        /*sql.append(" SELECT A.OID_FORM, A.IMVI_OID_IMPR, A.VAL_RUTI_DISE_FORM ");
        sql.append(" FROM FAC_FORMU A, ");
        sql.append(" FAC_FORMU_TIPO_SOLIC B, ");
        sql.append(" FAC_TIPO_FORMU C, PED_SOLIC_CABEC D");
        sql.append(" WHERE D.OID_SOLI_CABE = ? AND B.TSPA_OID_TIPO_SOLI_PAIS = D.TSPA_OID_TIPO_SOLI_PAIS "); //BELC300011917
        parametros.add(oidSoliCabe);

        sql.append(" AND A.OID_FORM = B.FORS_OID_FORM ");
        sql.append(" AND A.IND_IMPR = 1 ");
        sql.append(" AND C.OID_TIPO_FORM = A.TIFO_OID_TIPO_FORM ");
        sql.append(" AND C.COD_TIPO_FORM = 'B' ");
        sql.append(" ORDER BY B.NUM_ORDE_SECU ");*/

        // Se ejecuta la consulta 
        BelcorpService bs = UtilidadesEJB.getBelcorpService();
        RecordSet rs = null;
        String codigoError = null;

        try {
            rs = bs.dbService.executePreparedQuery(sql.toString(), parametros);
        } catch (Exception e) {
            codigoError = CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS;
            this.logError("obtenerFormulariosBoletaDespacho: Exception", e);
            this.logSql("obtenerFormulariosBoletaDespacho. SQL: ",
                sql.toString(), parametros);
            throw new MareException(e,
                UtilidadesError.armarCodigoError(codigoError));
        }

        ArrayList listaDtos = new ArrayList();

        if (!rs.esVacio()) {
            for (int i = 0; i < rs.getRowCount(); i++) {
                DTODatosTipoFormulario dtoDTF = new DTODatosTipoFormulario();

                if (rs.getValueAt(i, "OID_FORM") != null) {
                    Long oidFormulario = new Long(((BigDecimal) rs.getValueAt(
                                i, "OID_FORM")).longValue());
                    dtoDTF.setOidFormulario(oidFormulario);
                }

                if (rs.getValueAt(i, "IMVI_OID_IMPR") != null) {
                    Long impresora = new Long(((BigDecimal) rs.getValueAt(i,
                                "IMVI_OID_IMPR")).longValue());
                    dtoDTF.setIdImpresoraVirtual(impresora);
                }

                if (rs.getValueAt(i, "VAL_RUTI_DISE_FORM") != null) {
                    String rutina = rs.getValueAt(i, "VAL_RUTI_DISE_FORM")
                                      .toString();
                    dtoDTF.setRutinaDiseñoFormulario(rutina);
                }

                listaDtos.add(dtoDTF);
            }
             //for
        }
         //if rs.vacio      

        UtilidadesLog.info("DAOGestionDocumentos.obtenerFormulariosBoletaDespacho(Long oidSoliCabe, Long subacceso): Salida");
        return listaDtos;
    }

    public DTOSalida obtenerSolicitudesCupon(DTODatosCupones dtoEntrada)
        throws MareException {
        UtilidadesLog.info("DAOGestionDocumentos.obtenerSolicitudesCupon(DTODatosCupones dtoEntrada): Entrada");

		// Parametros de la consulta
        Vector parametros = new Vector();

        // Se crea la consulta SQL
        StringBuffer sql = new StringBuffer();
	
		
        /*
         * DBLG500000515 - dmorello, 11/05/2006: Se agrega la recuperación del total de líneas
         * (considerando todas las páginas posibles) en la columna TOTAL
         */
        sql.append("SELECT * FROM (SELECT ROWNUM as linea,    xxx.*, ");
        sql.append(" COUNT(*) OVER ( ) AS TOTAL"); // Total de líneas a paginar
        sql.append(" FROM (");		
        /* Fin DBLG500000515 dmorello 11/05/2006 */
        sql.append("	SELECT ");
        /*
         * DBLG500000515 - dmorello - 06/06/2006: Se toma el OID de la solicitud y no el del consolidado
         */
        //sql.append("	SC.SOCA_OID_SOLI_CABE OID, ");
        sql.append(" SC.OID_SOLI_CABE OID, ");
        sql.append("	CLI.COD_CLIE AS CODIGOCLIENTE, ");
        sql.append("	CLI.VAL_NOM1 || ' ' || CLI.VAL_APE1 AS NOMBRE_APELLIDO, ");
       sql.append(" (SELECT IDIO.val_i18n FROM V_GEN_I18N_SICC IDIO WHERE ");
        sql.append(" IDIO.attr_enti = 'SEG_CANAL' AND IDIO.idio_oid_idio = ? AND ");
        sql.append(" IDIO.val_oid = AC.CANA_OID_CANA ) AS CANAL, ");
        parametros.add(dtoEntrada.getOidIdioma());

        sql.append(" (SELECT IDIO.val_i18n FROM V_GEN_I18N_SICC IDIO WHERE ");
        sql.append(" IDIO.attr_enti = 'SEG_ACCES' AND IDIO.idio_oid_idio = ? AND ");
        sql.append(" IDIO.val_oid = AC.OID_ACCE ) AS ACCESO, ");
        parametros.add(dtoEntrada.getOidIdioma());

        sql.append(" (SELECT IDIO.val_i18n FROM V_GEN_I18N_SICC IDIO WHERE ");
        sql.append(" IDIO.attr_enti = 'SEG_SUBAC' AND IDIO.idio_oid_idio = ? AND ");
        sql.append(" IDIO.val_oid = SC.SBAC_OID_SBAC ) AS SUBACCESO, ");
        parametros.add(dtoEntrada.getOidIdioma());        
        
        // dmorello, 11/08/2006: Directamente se toma el num de solicitud
        // de SC, ya que se usa el filtro SC.IND_TS_NO_CONSO = 0
        //sql.append("	DECODE(SC.SOCA_OID_SOLI_CABE,NULL,NULL,(SELECT VAL_NUME_SOLI FROM PED_SOLIC_CABEC SCA WHERE SCA.OID_SOLI_CABE = SC.SOCA_OID_SOLI_CABE) ) as NUMEROCONSOLIDADO,  ");
        sql.append("  SC.VAL_NUME_SOLI AS NUMEROCONSOLIDADO, ");
        sql.append("	P.VAL_NOMB_PERI AS PERIODO,  ");
        sql.append("	SC.FEC_FACT AS FECHAFACTURACION,  ");
		sql.append("	SC.VAL_TOTA_PAGA_LOCA AS TOTALPAGAR, SC.PAIS_OID_PAIS AS PAIS");
		sql.append("	FROM	");
        sql.append("	PED_SOLIC_CABEC SC, MAE_CLIEN CLI, VCA_SEG_ACCES AC, VCA_SEG_SUBAC SUB, CRA_PERIO P, ZON_REGIO R, ZON_ZONA Z, ZON_TERRI T                                                                                                      ");
        sql.append("	WHERE	");
        sql.append("	AC.OID_ACCE = SUB.ACCE_OID_ACCE  ");
        sql.append("	AND SUB.OID_SBAC = SC.SBAC_OID_SBAC  ");
        sql.append("	AND P.OID_PERI = SC.PERD_OID_PERI "); 
        sql.append("	AND CLI.OID_CLIE = SC.CLIE_OID_CLIE "); 

        sql.append("	AND Z.OID_ZONA = SC.ZZON_OID_ZONA  "); 
        sql.append("	AND T.OID_TERR = SC.TERR_OID_TERR  "); 
        sql.append("	AND Z.ZORG_OID_REGI = R.OID_REGI  ");
        // dmorello, 26/07/2006: Deben levantarse CONSOLIDADOS
        //sql.append("	AND sc.IND_TS_NO_CONSO = 1  ");        
        sql.append("	AND sc.IND_TS_NO_CONSO = 0  ");
    
        sql.append("	AND SUB.COD_USUA = ?  ");
		parametros.add(this.usuario);

        sql.append("	AND AC.COD_USUA = ?  ");
		parametros.add(this.usuario);

		if (dtoEntrada.getOidPais() != null){
			sql.append("	AND SC.PAIS_OID_PAIS  = ?   ");
			parametros.add(dtoEntrada.getOidPais());
		}
		if (dtoEntrada.getCodCliente() != null){
			sql.append("	AND CLI.COD_CLIE  in (" + dtoEntrada.getCodCliente() + ")  ");
		}
		
		if (dtoEntrada.getMarca() != null){
		
		 //marca -> se saca de la relación con CRA_PERIO a través del campo PERD_OID_PERI de la tabla PED_SOLIC_CABEC 
		sql.append("	AND P.MARC_OID_MARC = ?			");
			parametros.add(dtoEntrada.getMarca());
        }    		
		
		if (dtoEntrada.getCanal() != null){
			sql.append("	AND AC.CANA_OID_CANA = ? ");
			parametros.add(dtoEntrada.getCanal());
		}

		if (dtoEntrada.getPeriodo()	!= null){
			sql.append(" AND SC.PERD_OID_PERI = ?");
			parametros.add(dtoEntrada.getPeriodo());
		}
		
		if ( dtoEntrada.getFechaFacturacion() != null){
			
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			java.sql.Date fechFact =  new java.sql.Date(dtoEntrada.getFechaFacturacion().getTime());		
			String fechaFacturacion = sdf.format(fechFact);
			sql.append("	AND	SC.FEC_FACT = TO_DATE( ? ,'YYYY-MM-DD')	");
			parametros.add(fechaFacturacion);		
		}

		if (( dtoEntrada.getRegionDesde() != null)&& (dtoEntrada.getRegionHasta() != null)){
			 //region -> se accede a la tabla ZON_ZONA usando ZZON_OID_ZONA y se obtiene ZORG_OID_REGI, 
			sql.append("	AND	R.COD_REGI >= ? ");		
			sql.append("	AND	R.COD_REGI  <= ? ");		
			parametros.add(dtoEntrada.getRegionDesde());
			parametros.add(dtoEntrada.getRegionHasta());
		}

		if (( dtoEntrada.getZonaDesde() != null)&& (dtoEntrada.getZonaHasta() != null)){
			sql.append("	AND	 Z.COD_ZONA >= ? ");
			sql.append("	AND	 Z.COD_ZONA <= ? ");
			parametros.add(dtoEntrada.getZonaDesde());
			parametros.add(dtoEntrada.getZonaHasta());
		}

		if (( dtoEntrada.getSeccionDesde() != null)&& (dtoEntrada.getSeccionHasta() != null)){
			//seccion -> se accede a la tabla ZON_TERRI_ADMI usando ZTAD_OID_TERR_ADMI, y se obtiene OID_SECC, 
			sql.append("	AND	 (SELECT COD_SECC FROM ZON_SECCI S, ZON_TERRI_ADMIN TA WHERE TA.OID_TERR_ADMI = SC.ZTAD_OID_TERR_ADMI AND TA.ZSCC_OID_SECC = S.OID_SECC) >= ? ");		
			sql.append("	AND	 (SELECT COD_SECC FROM ZON_SECCI S, ZON_TERRI_ADMIN TA WHERE TA.OID_TERR_ADMI = SC.ZTAD_OID_TERR_ADMI AND TA.ZSCC_OID_SECC = S.OID_SECC) <= ? ");		
			parametros.add(dtoEntrada.getSeccionDesde());
			parametros.add(dtoEntrada.getSeccionHasta());
		}

		if (( dtoEntrada.getTerritorioDesde() != null)&& (dtoEntrada.getTerritorioHasta() != null)){
			sql.append("	AND	 T.COD_TERR >= ? ");
			sql.append("	AND	 T.COD_TERR <= ? ");		
			parametros.add(dtoEntrada.getTerritorioDesde());
			parametros.add(dtoEntrada.getTerritorioHasta());
		}
		
		sql.append("	ORDER BY PAIS,CANAL,ACCESO,SUBACCESO,NUMEROCONSOLIDADO  ");
    	//String consulta = UtilidadesPaginacion.armarQueryPaginacion(sql.toString(),dtoEntrada);
		//consulta += " ORDER BY PAIS,CANAL,ACCESO,SUBACCESO,NUMEROCONSOLIDADO ";

		sql.append(") xxx ) WHERE linea > " + dtoEntrada.getIndicadorSituacion() + " AND ROWNUM <= " + dtoEntrada.getTamanioPagina() );

		
		// Se ejecuta la consulta 
        BelcorpService bs = UtilidadesEJB.getBelcorpService();
        RecordSet rs = null;
        String codigoError = null;

        try {
            rs = bs.dbService.executePreparedQuery(sql.toString(), parametros);
        } catch (Exception e) {
            codigoError = CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS;
            this.logError("obtenerSolicitudesCupon: Exception", e);
            this.logSql("obtenerSolicitudesCupon. SQL: ",
                sql.toString(), parametros);
            throw new MareException(e,
                UtilidadesError.armarCodigoError(codigoError));
        }
        
    UtilidadesLog.debug("rs: " + rs);

    if (rs.esVacio()) {
        //GEN-0007 --> 005
        UtilidadesLog.debug("****obtenerSolicitudes: no hay datos ");				
              codigoError = CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE;
              throw new MareException(new Exception(), UtilidadesError.armarCodigoError(codigoError));
    }
		DTOSalida dtoSalida = new DTOSalida();
		dtoSalida.setResultado(rs);
       		
        UtilidadesLog.info("DAOGestionDocumentos.obtenerSolicitudesCupon(DTODatosCupones dtoEntrada): Salida");

        return dtoSalida;
    }

    // consulta modificada por la BELC300011917 y la BELC300016098
    public ArrayList obtenerFormulariosCuponReemplazo(Long oidSoliCabe, Long subacceso)
        throws MareException {

        UtilidadesLog.info("DAOGestionDocumentos.obtenerFormulariosCuponReemplazo(Long oidSoliCabe, Long subacceso): Entrada"); 

        // Parametros de la consulta
        Vector parametros = new Vector();

        // Se crea la consulta SQL
        StringBuffer sql = new StringBuffer();

        sql.append(" SELECT A.OID_FORM, E.IMVI_OID_IMPR, A.VAL_RUTI_DISE_FORM ");
        sql.append(" FROM FAC_FORMU A, ");
        sql.append(" FAC_FORMU_TIPO_SOLIC B, ");
        sql.append(" FAC_TIPO_FORMU C, PED_SOLIC_CABEC D, FAC_ASIGN_IMPRE E ");
        sql.append(" WHERE B.TSPA_OID_TIPO_SOLI_PAIS = D.TSPA_OID_TIPO_SOLI_PAIS "); 
        sql.append(" AND D.OID_SOLI_CABE = ? ");
        parametros.add(oidSoliCabe);

        sql.append(" AND A.OID_FORM = B.FORS_OID_FORM ");
        sql.append(" AND A.IND_IMPR = 1 ");
        sql.append(" AND C.OID_TIPO_FORM = A.TIFO_OID_TIPO_FORM ");
        sql.append(" AND C.COD_TIPO_FORM = 'P' ");

        sql.append(" AND E.SBAC_OID_SBAC= ? ");
        parametros.add(subacceso);
        sql.append(" AND E.FORS_OID_FORM=A.OID_FORM ");

        sql.append(" ORDER BY B.NUM_ORDE_SECU ");  
        
        /*sql.append(" SELECT A.OID_FORM, A.IMVI_OID_IMPR, A.VAL_RUTI_DISE_FORM ");
        sql.append(" FROM FAC_FORMU A, ");
        sql.append(" FAC_FORMU_TIPO_SOLIC B, ");
        sql.append(" FAC_TIPO_FORMU C, PED_SOLIC_CABEC D ");
        sql.append(" WHERE D.OID_SOLI_CABE = ? AND B.TSPA_OID_TIPO_SOLI_PAIS = D.TSPA_OID_TIPO_SOLI_PAIS "); //BELC300011917
        parametros.add(oidSoliCabe);

        sql.append(" AND A.OID_FORM = B.FORS_OID_FORM ");
        sql.append(" AND A.IND_IMPR = 1 ");
        sql.append(" AND C.OID_TIPO_FORM = A.TIFO_OID_TIPO_FORM ");
        sql.append(" AND C.COD_TIPO_FORM = 'P' ");
        sql.append(" ORDER BY B.NUM_ORDE_SECU ");*/

        // Se ejecuta la consulta 
        BelcorpService bs = UtilidadesEJB.getBelcorpService();
        RecordSet rs = null;
        String codigoError = null;

        try {
            rs = bs.dbService.executePreparedQuery(sql.toString(), parametros);
        } catch (Exception e) {
            codigoError = CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS;
            this.logError("obtenerFormulariosCuponReemplazo: Exception", e);
            this.logSql("obtenerFormulariosCuponReemplazo. SQL: ",
                sql.toString(), parametros);
            throw new MareException(e,
                UtilidadesError.armarCodigoError(codigoError));
        }
        
        UtilidadesLog.debug("rs = " + rs);

        ArrayList listaDtos = new ArrayList();

        if (!rs.esVacio()) {
            for (int i = 0; i < rs.getRowCount(); i++) {
                DTODatosTipoFormulario dtoDTF = new DTODatosTipoFormulario();

                if (rs.getValueAt(i, "OID_FORM") != null) {
                    Long oidFormulario = new Long(((BigDecimal) rs.getValueAt(
                                i, "OID_FORM")).longValue());
                    dtoDTF.setOidFormulario(oidFormulario);
                }

                if (rs.getValueAt(i, "IMVI_OID_IMPR") != null) {
                    Long impresora = new Long(((BigDecimal) rs.getValueAt(i,
                                "IMVI_OID_IMPR")).longValue());
                    dtoDTF.setIdImpresoraVirtual(impresora);
                }

                if (rs.getValueAt(i, "VAL_RUTI_DISE_FORM") != null) {
                    String rutina = rs.getValueAt(i, "VAL_RUTI_DISE_FORM")
                                      .toString();
                    dtoDTF.setRutinaDiseñoFormulario(rutina);
                }

                listaDtos.add(dtoDTF);
            }
             //for
        }
         //if rs.vacio      

        
        UtilidadesLog.debug("listaDtos a devolver: " + listaDtos);
        
        UtilidadesLog.info("DAOGestionDocumentos.obtenerFormulariosCuponReemplazo(Long oidSoliCabe, Long subacceso): Salida"); 

        return listaDtos;
    }

    private void logError(String mensaje, Throwable e) {
        UtilidadesLog.info("DAOGestionDocumentos.logError(String mensaje, Throwable e): Entrada"); 
        UtilidadesLog.error("*** Error Metodo " + mensaje + ": " +
            e.getMessage() + " ***");
        this.logStackTrace(e);
        UtilidadesLog.info("DAOGestionDocumentos.logError(String mensaje, Throwable e): Salida"); 
    }

    private void logStackTrace(Throwable e) {
        UtilidadesLog.info("DAOGestionDocumentos.logStackTrace(Throwable e): Entrada"); 
        try {
            UtilidadesLog.error(e);
        } catch (Exception ex) {
            UtilidadesLog.error("Traza de la pila: " + ex.getMessage());
        }
        UtilidadesLog.info("DAOGestionDocumentos.logStackTrace(Throwable e): Salida"); 
    }

    private void logSql(String metodo, String sql, Vector params) {
        UtilidadesLog.info("DAOGestionDocumentos.logSql(String metodo, String sql, Vector params): Entrada");
        UtilidadesLog.debug(metodo + sql);

        if ((params != null) && (params.size() > 0)) {
            String sParams = "";

            for (int i = 0; i < params.size(); i++) {
                sParams += ("param " + (i + 1) + ": " + params.elementAt(i) +
                ", ");
            }

            UtilidadesLog.debug(metodo + sParams);
        }
        UtilidadesLog.info("DAOGestionDocumentos.logSql(String metodo, String sql, Vector params): Salida");
    }
   
}
