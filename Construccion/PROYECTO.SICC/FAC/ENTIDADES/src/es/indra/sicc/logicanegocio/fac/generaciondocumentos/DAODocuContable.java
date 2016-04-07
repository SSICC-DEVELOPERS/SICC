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

import es.indra.mare.common.mii.MareMiiServiceNotFoundException;
import es.indra.mare.common.mii.services.jdbcservice.RecordSet;

import es.indra.sicc.dtos.fac.DTODatosBoletaRecojo;
import es.indra.sicc.dtos.fac.DTODatosDetalleBoletaEntregaColombia;
import es.indra.sicc.dtos.fac.DTODatosProgramasIncentivos;
import es.indra.sicc.dtos.fac.DTOFACCabeceraSolicitud;
import es.indra.sicc.dtos.fac.DTOVencimientosCC;
import es.indra.sicc.logicanegocio.ped.ConstantesPED;
import es.indra.sicc.util.BelcorpService;
import es.indra.sicc.util.CodigosError;
import es.indra.sicc.util.RecuperadorIdiomaDefectoServidor;
import es.indra.sicc.util.UtilidadesEJB;
import es.indra.sicc.util.UtilidadesError;
import es.indra.sicc.util.UtilidadesLog;
import es.indra.sicc.util.UtilidadesBD;

import es.indra.sicc.logicanegocio.mae.ConstantesMAE;

import java.text.SimpleDateFormat;
import java.util.Vector;

import javax.ejb.EJBException;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Iterator;

import java.sql.Date;

import java.util.HashMap;

public class DAODocuContable {
    public DAODocuContable() {
    }

    public DTODocLegal obtenerDatosVisualizacion(Long oidDocumento, Long subacceso, Long idioma)
        throws MareException {
        
        try 
        {
        /*1.- Creamos un DTODocLegal.
        2.- Creamos un DTOFACDocumentoContable y se lo añadimos al DTODocLegal
        3.- Creamos un DTOFACDocumentoContableCabecera, lo añadimos al DTOFACDocumentocontable
                //y lo rellenamos con el resultado de la siguiente consulta: */
        UtilidadesLog.info("DAODocuContable.obtenerDatosVisualizacion(Long oidDocumento, Long subacceso): Entrada"); 
        
        DTODocLegal dtoDocLegal = new DTODocLegal();
        DTOFACDocumentoContable dtoFACDocumentoContable = new DTOFACDocumentoContable();
        DTOFACDocumentoContableCabecera dtoFACDocumentoContableCabecera = new DTOFACDocumentoContableCabecera();

        Vector parametros = new Vector();
        StringBuffer query = new StringBuffer();

        query.append("SELECT A.VAL_APE1, A.VAL_APE2, A.VAL_NOM1, ");
        query.append("A.VAL_NOM2, A.VAL_PREC_CATA_TOTA_LOCA, ");
        query.append("A.VAL_PREC_CONT_TOTA_LOCA, A.IMP_DESC_TOTA_LOCA, ");
        query.append("A.IMP_FLET_TOTA_LOCA, ");
        query.append("A.IMP_FLET_IMPU_TOTA_LOCA, ");
        query.append("A.VAL_TOTA_PAGA_LOCA, A.NUM_UNID_ATEN_TOTA, ");
        query.append("A.VAL_NUME_IDEN_FISC, A.VAL_PREC_CATA_IMPU, ");
        query.append("A.VAL_PREC_CONT_IMPU, A.NUM_DOCU_CONT_INTE, ");
        query.append("A.IMP_IMPU_TOTA_LOCA, A.NUM_DOCU_ORIG, ");
        query.append("A.SOCA_OID_SOLI_CABE, ");
        query.append(" A.VAL_OBSE, "); // @eiraola - INC. DBLG500000514 faltaba campo "Glosa"
        query.append("A.FEC_FACT, A.NUM_DOCU_ORIG, ");
        query.append("A.VAL_DIRE_COMP,  ");
        query.append("A.VAL_NUME_IDEN_NNAL, ");
        query.append(" A.IMP_DES1_TOTA_LOCA, ");
        query.append(" A.IMP_DES1_SIN_IMPU_TOTA, A.IMP_DES3_TOTAL_LOCA, ");
        query.append(" A.IMP_DES3_SIN_IMPU_TOTA, ");        
        query.append("D.VAL_NUME_SOLI, D.TSPA_OID_TIPO_SOLI_PAIS, ");
        query.append("E.VAL_RUTI_DISE_FORM,"); // E.IMVI_OID_IMPR, se ha eliminado de BD
        query.append("F.COD_PERI, ");
        query.append("G.VAL_NOMB_PERI, ");
        query.append("H.COD_TERR, ");
        query.append("I.COD_ZONA, ");
        query.append("J.COD_CLIE, ");
        query.append("K.VAL_NOMB_CORT_MONE, ");
        query.append("L.NUM_SECU_FACT_DIAR, ");
        query.append("M.VAL_TEXT_COMU, ");
        query.append("D.VEPO_OID_VALO_ESTR_GEOP, ");
        query.append("O.VAL_IDEN_FISC, ");
        query.append("W.VAL_NUME_SOLI NUMEROSOLI, ");
        query.append("FF.COD_PERI COD_PERI_REFE, ");
        query.append(" i18n.VAL_I18N DTS ");
        
        if(subacceso!=null) {
            query.append(", N.IMVI_OID_IMPR ");
        }
        query.append(" , Z.OID_VALO_ESTR_GEOP ");
        query.append(" , A.PAIS_OID_PAIS ");
        query.append(" , CASE WHEN ( ");
        query.append("    SELECT count(*) ");
        query.append("      FROM fac_formu_perce fp ");
        query.append("     WHERE fp.pais_oid_pais = a.pais_oid_pais ");
        query.append("       AND fp.fors_oid_form = e.oid_form ");
        query.append("       AND fp.val_ruti_prog_ejec = e.val_ruti_dise_form) > 0 ");
        query.append(" THEN ");
        query.append("    (SELECT val_tasa_impu ");
        query.append("       FROM ped_tasa_impue ");
        query.append("      WHERE val_indi_impu = ? ");
        parametros.add(ConstantesPED.INDICADOR_IMPUESTO_PERCEPCION);
        query.append("        AND pais_oid_pais = a.pais_oid_pais) ");
        query.append(" ELSE 0 ");
        query.append(" END ");
        query.append("    AS tasa_perc ");
        query.append(" , (SELECT count(*) ");
	    query.append("    FROM fac_formu_perce fp, fac_formu formu ");
	 	query.append("   WHERE fp.pais_oid_pais = a.pais_oid_pais ");
		query.append("     AND fp.fors_oid_form = formu.oid_form ");
		query.append("     AND formu.oid_form = a.fors_oid_form) CONTA_IMPRE_PERCEP, ");
        query.append("         LPAD(SUBSTR(D.VAL_NUME_SOLI, 2, 10), 8, 0) COD_BARRAS ");
        query.append("         , A.VAL_TELE_FIJO TELEF_FIJO "); 
        query.append("         , A.VAL_TELE_CELU TELEF_CEL ");   
        query.append("         , A.VAL_BARR "); 
        query.append("           ,RTRIM((SELECT DES_GEOG ");		 
        query.append("            FROM ZON_VALOR_ESTRU_GEOPO ");
        query.append("            WHERE ORDE_1 = SUBSTR(B.COD_UNID_GEOG, 0, 6) ");
        query.append("              AND ORDE_2 IS NULL)) DEPARTAMENTO ");
        query.append("           ,(SELECT DES_GEOG ");		 
        query.append("            FROM ZON_VALOR_ESTRU_GEOPO ");
        query.append("            WHERE ORDE_1 = SUBSTR(B.COD_UNID_GEOG, 0, 6) ");
        query.append("              AND ORDE_2 = SUBSTR(B.COD_UNID_GEOG, 7, 6) ");
        query.append("              AND ORDE_3 IS NULL) MUNICIPIO, ");    
        query.append("             J.SAL_DEUD_ANTE, "); 
        query.append("             CASE WHEN (A.MONE_OID_MONE IS NULL) THEN "); 
        query.append("               (  ");
        query.append("               SELECT NUM_DECI ");                     
        query.append("               FROM SEG_PAIS PAIS, SEG_MONED MON ");                     
        query.append("               WHERE PAIS.MONE_OID_MONE = MON.OID_MONE ");                     
        query.append("                 AND PAIS.OID_PAIS = A.PAIS_OID_PAIS ");                     
        query.append("               ) "); 
        query.append("             ELSE "); 
        query.append("               (  ");
        query.append("               SELECT NUM_DECI ");                     
        query.append("               FROM SEG_MONED MON ");                     
        query.append("               WHERE MON.OID_MONE = A.MONE_OID_MONE ");                            
        query.append("               ) "); 
        query.append("             END NUM_DECI "); 
        query.append(" ,(SELECT NUM_DIAS_CUPO_CRUC ");
        query.append(" FROM SEG_PARAM_INTER_PAIS ");
        query.append(" WHERE PAIS_OID_PAIS = A.PAIS_OID_PAIS) DIAS_CRUCE, ");        
        query.append("        A.VAL_SERI_DOCU_LEGA as A_VAL_SERI_DOCU_LEGA, "); 
        query.append("        A.NUM_DOCU_LEGA as A_NUM_DOCU_LEGA, ");
        query.append("        D.CLIE_OID_CLIE as A_CLIE_OID_CLIE, ");
        query.append("        A.PAIS_OID_PAIS as A_PAIS_OID_PAIS, ");
        query.append(" (SELECT COD_REGI FROM ZON_REGIO WHERE OID_REGI = I.ZORG_OID_REGI and IND_ACTI = 1 and IND_BORR = 0) COD_REGI, ");
        query.append(" (SELECT COD_SECC FROM ZON_SECCI SEC, ZON_TERRI_ADMIN ZTA WHERE SEC.OID_SECC = ZTA.ZSCC_OID_SECC AND ZTA.TERR_OID_TERR = H.OID_TERR and sec.IND_ACTI = 1 and sec.IND_BORR = 0 and zta.IND_BORR = 0 ) COD_SECC, ");
        query.append(" A.PERD_OID_PERI ");
        query.append("FROM FAC_DOCUM_CONTA_CABEC A, ");
        query.append("PED_SOLIC_CABEC D, ");
        query.append("FAC_FORMU E, ");
        query.append("SEG_PERIO_CORPO F, ");
        query.append("SEG_PERIO_CORPO FF, ");
        query.append("CRA_PERIO G, ");
        query.append("CRA_PERIO GG, ");
        query.append("ZON_TERRI H, ");
        query.append("ZON_ZONA I, ");
        query.append("MAE_CLIEN J, ");
        query.append("SEG_MONED K, ");
        query.append("PED_SOLIC_CABEC_SECUE L, ");
        query.append("MAE_CLIEN_COMUN M, ");
        query.append("V_GEN_I18N_SICC i18n, ");
        query.append("PED_TIPO_SOLIC_PAIS tsp,");
        query.append("PED_SOLIC_CABEC W ");
        if(subacceso!=null) {
            query.append(" , FAC_ASIGN_IMPRE N ");
        }
        query.append(", SEG_SOCIE O ");
        query.append(" , ZON_VALOR_ESTRU_GEOPO Z ");
        query.append(" , MAE_CLIEN_DIREC B, ZON_TERRI T ");
        query.append("WHERE A.OID_CABE = ? ");
        parametros.add(oidDocumento);
        query.append("AND D.OID_SOLI_CABE=A.SOCA_OID_SOLI_CABE ");
        query.append("AND E.OID_FORM=A.FORS_OID_FORM ");
        query.append("AND F.OID_PERI=G.PERI_OID_PERI ");
        query.append("AND G.OID_PERI=A.PERD_OID_PERI ");
        query.append("AND H.OID_TERR=A.TERR_OID_TERR ");
        query.append("AND I.OID_ZONA=A.ZZON_OID_ZONA ");
        query.append("AND J.OID_CLIE=D.CLIE_OID_CLIE_RECE_FACT ");
        query.append("AND K.OID_MONE(+)=A.MONE_OID_MONE ");
        query.append("AND L.SOCA_OID_SOLI_CABE(+)=D.OID_SOLI_CABE ");
        query.append("AND M.CLIE_OID_CLIE(+)=D.CLIE_OID_CLIE ");
        query.append("AND M.TICM_OID_TIPO_COMU(+) = ? ");
    	parametros.add(ConstantesMAE.TIPO_COMUNICACION_TFNO);
        if(subacceso!=null) {
            query.append(" AND N.FORS_OID_FORM=E.OID_FORM ");
            query.append(" AND N.SBAC_OID_SBAC= ? ");
            parametros.add(subacceso);
		}
        query.append("AND O.PAIS_OID_PAIS=A.PAIS_OID_PAIS ");
        query.append("AND O.OID_SOCI=A.SOCI_OID_SOCI ");
        query.append("AND D.OID_SOLI_CABE=A.SOCA_OID_SOLI_CABE ");
        query.append("AND W.OID_SOLI_CABE(+)=D.SOCA_OID_DOCU_REFE ");
        query.append("AND FF.OID_PERI(+) = GG.PERI_OID_PERI ");
        query.append("AND GG.OID_PERI(+) = W.PERD_OID_PERI ");
        query.append(" AND T.VEPO_OID_VALO_ESTR_GEOP = Z.OID_VALO_ESTR_GEOP ");
        query.append(" AND B.OID_CLIE_DIRE=A.CLDI_OID_CLIE_DIRE ");
        query.append(" AND T.OID_TERR=B.TERR_OID_TERR ");
        query.append(" AND M.IND_COMU_PPAL(+) = 1 ");
        query.append(" AND d.tspa_oid_tipo_soli_pais = tsp.oid_tipo_soli_pais ");
        query.append(" AND i18n.val_oid = tsp.tsol_oid_tipo_soli ");
        query.append(" AND i18n.ATTR_ENTI = 'PED_TIPO_SOLIC' ");
        query.append(" AND i18n.IDIO_OID_IDIO = " + idioma);
        query.append(" AND i18n.ATTR_NUM_ATRI = 1 ");

        RecordSet rs = new RecordSet();
        BelcorpService bs = UtilidadesEJB.getBelcorpService();

        try {
            rs = bs.dbService.executePreparedQuery(query.toString(), parametros);
        } catch (Exception e) {
            String codigoError = CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS;
            this.logError("obtenerDatosVisualizacion: Exception", e);
            this.logSql("obtenerDatosVisualizacion.SQL: ", query.toString(),
                parametros);
            throw new MareException(e,
                UtilidadesError.armarCodigoError(codigoError));
        }
        if(rs.esVacio()) {
            String error = CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE;
            UtilidadesLog.debug("DAODocuContable.obtenerDatosVisualizacion:No se encontraron datos");
            throw new MareException(new Exception(), 
                                        UtilidadesError.armarCodigoError(error));
        } else {
            

            UtilidadesLog.debug("*** DAODocuContable.obtenerDatosVisualizacion subacceso = "+subacceso);
            if(subacceso != null) {
                UtilidadesLog.debug("*** DAODocuContable.obtenerDatosVisualizacion Indice de impresión = "+rs.getValueAt(0,"IMVI_OID_IMPR"));
                dtoFACDocumentoContableCabecera.setTipoDocumento(new Long(((BigDecimal)rs.getValueAt(0,"IMVI_OID_IMPR")).longValue()));
            }

            // BELC300014206
            dtoFACDocumentoContableCabecera.setCodigoBarras(UtilidadesBD.convertirAString(rs.getValueAt(0, "COD_BARRAS")));
            dtoFACDocumentoContableCabecera.setSerieDocumentoLegal(UtilidadesBD.convertirAString(rs.getValueAt(0, "A_VAL_SERI_DOCU_LEGA")));
            dtoFACDocumentoContableCabecera.setNumeroDocumentoLegal(UtilidadesBD.convertirALong(rs.getValueAt(0, "A_NUM_DOCU_LEGA")));
            dtoFACDocumentoContableCabecera.setTelefonoFijo(UtilidadesBD.convertirAString(rs.getValueAt(0, "TELEF_FIJO")));
            dtoFACDocumentoContableCabecera.setTelefonoCelular(UtilidadesBD.convertirAString(rs.getValueAt(0, "TELEF_CEL")));
            dtoFACDocumentoContableCabecera.setBarrio(UtilidadesBD.convertirAString(rs.getValueAt(0, "VAL_BARR")));            
            dtoFACDocumentoContableCabecera.setOidPais(UtilidadesBD.convertirALong(rs.getValueAt(0, "A_PAIS_OID_PAIS")));
            dtoFACDocumentoContableCabecera.setMunicipio(UtilidadesBD.convertirAString(rs.getValueAt(0, "MUNICIPIO")));
            dtoFACDocumentoContableCabecera.setDepartamento(UtilidadesBD.convertirAString(rs.getValueAt(0, "DEPARTAMENTO")));
            dtoFACDocumentoContableCabecera.setSaldoAnterior(UtilidadesBD.convertirAFloat(rs.getValueAt(0, "SAL_DEUD_ANTE")));
            if (dtoFACDocumentoContableCabecera.getSaldoAnterior() == null) {
               dtoFACDocumentoContableCabecera.setSaldoAnterior(new Float(0)); 
            }
            dtoFACDocumentoContableCabecera.setOidCliente(UtilidadesBD.convertirALong(rs.getValueAt(0, "A_CLIE_OID_CLIE")));
            dtoFACDocumentoContableCabecera.setNumeroDecimales(UtilidadesBD.convertirAInteger(rs.getValueAt(0, "NUM_DECI")));
            dtoFACDocumentoContableCabecera.setDiasCruce(UtilidadesBD.convertirALong(rs.getValueAt(0, "DIAS_CRUCE")));        
            dtoFACDocumentoContableCabecera.setCodRegion(UtilidadesBD.convertirAString(rs.getValueAt(0, "COD_REGI")));        
            dtoFACDocumentoContableCabecera.setCodSeccion(UtilidadesBD.convertirAString(rs.getValueAt(0, "COD_SECC")));        

            
            
			dtoFACDocumentoContableCabecera.setApellido1(rs.getValueAt(0,"VAL_APE1")!=null?rs.getValueAt(0,"VAL_APE1").toString():"");
			dtoFACDocumentoContableCabecera.setApellido2(rs.getValueAt(0,"VAL_APE2")!=null?rs.getValueAt(0,"VAL_APE2").toString():"");
			dtoFACDocumentoContableCabecera.setNombre1(rs.getValueAt(0,"VAL_NOM1")!=null?rs.getValueAt(0,"VAL_NOM1").toString():"");
			dtoFACDocumentoContableCabecera.setNombre2(rs.getValueAt(0,"VAL_NOM2")!=null?rs.getValueAt(0,"VAL_NOM2").toString():"");
                                          
            UtilidadesLog.debug("*** SCS DTS, es: " + rs.getValueAt(0,"DTS").toString());
                                                    
            dtoFACDocumentoContableCabecera.setDescripTipoSolicitud(rs.getValueAt(0,"DTS")!=null?rs.getValueAt(0,"DTS").toString():"");
            if(rs.getValueAt(0, "COD_CLIE")!=null) {
                dtoFACDocumentoContableCabecera.setCodCliente(rs.getValueAt(0,"COD_CLIE").toString());
            }
            if(rs.getValueAt(0, "OID_VALO_ESTR_GEOP")!=null) {
                dtoFACDocumentoContableCabecera.setOidUbigeo(new Long(((BigDecimal)rs.getValueAt(0, "OID_VALO_ESTR_GEOP")).longValue()));
            }
            
            if(rs.getValueAt(0, "VAL_NUME_IDEN_FISC")!=null) {
                dtoFACDocumentoContableCabecera.setNumIdentificacionFiscal(rs.getValueAt(0, "VAL_NUME_IDEN_FISC").toString());
            }
            
            if (rs.getValueAt(0, "VAL_NUME_IDEN_NNAL")!=null) {
                dtoFACDocumentoContableCabecera.setDNI(rs.getValueAt(0,"VAL_NUME_IDEN_NNAL").toString());
            }
            
            if (rs.getValueAt(0, "IMP_DES1_TOTA_LOCA")!=null) {
                dtoFACDocumentoContableCabecera.setImpDesc1TotLocal(new Float(((BigDecimal)rs.getValueAt(0,"IMP_DES1_TOTA_LOCA")).floatValue()));
            }
            
            if (rs.getValueAt(0, "IMP_DES1_SIN_IMPU_TOTA")!=null) {
                dtoFACDocumentoContableCabecera.setImpDesc1SinImpTotLocal(new Float(((BigDecimal)rs.getValueAt(0,"IMP_DES1_SIN_IMPU_TOTA")).floatValue()));
            }
            
            if (rs.getValueAt(0, "IMP_DES3_TOTAL_LOCA")!=null) {
                dtoFACDocumentoContableCabecera.setImpDesc3TotalLocal(new Float(((BigDecimal)rs.getValueAt(0,"IMP_DES3_TOTAL_LOCA")).floatValue()));
            }
            
            if (rs.getValueAt(0, "IMP_DES3_SIN_IMPU_TOTA")!=null) {
                dtoFACDocumentoContableCabecera.setImpDesc3SinImpTotalLocal(new Float(((BigDecimal)rs.getValueAt(0,"IMP_DES3_SIN_IMPU_TOTA")).floatValue()));
            }
            
            if(rs.getValueAt(0, "VAL_IDEN_FISC")!=null) {
                dtoFACDocumentoContableCabecera.setIdFiscalSociedadVentas(rs.getValueAt(0, "VAL_IDEN_FISC").toString());
            }
        
			if (rs.getValueAt(0,"VAL_PREC_CATA_TOTA_LOCA")!= null){
				dtoFACDocumentoContableCabecera.setPrecioCataTotaLocal(new Float(((BigDecimal)rs.getValueAt(0,"VAL_PREC_CATA_TOTA_LOCA")).floatValue()));
			}
			
			if (rs.getValueAt(0,"VAL_PREC_CONT_TOTA_LOCA")!= null){
				dtoFACDocumentoContableCabecera.setPrecioContTotaLocal(new Float(((BigDecimal)rs.getValueAt(0,"VAL_PREC_CONT_TOTA_LOCA")).floatValue()));
			}
			
			if (rs.getValueAt(0,"IMP_DESC_TOTA_LOCA")!= null){
				dtoFACDocumentoContableCabecera.setImporteDescuentoTotaLocal(new Float(((BigDecimal)rs.getValueAt(0,"IMP_DESC_TOTA_LOCA")).floatValue()));
			}
            
            if (rs.getValueAt(0,"IMP_FLET_TOTA_LOCA")!=null) {
                dtoFACDocumentoContableCabecera.setImporteFleteTotalLocal(new Float(((BigDecimal)rs.getValueAt(0,"IMP_FLET_TOTA_LOCA")).floatValue()));
            }
			
			if (rs.getValueAt(0,"IMP_FLET_IMPU_TOTA_LOCA")!= null) {
				dtoFACDocumentoContableCabecera.setImporteFleteSinImpuestosTotalLocal(new Float(((BigDecimal)rs.getValueAt(0,"IMP_FLET_IMPU_TOTA_LOCA")).floatValue()));
			}
			if (rs.getValueAt(0,"VAL_TOTA_PAGA_LOCA")!= null) {
				dtoFACDocumentoContableCabecera.setTotalAPagarLocal(new Float(((BigDecimal)rs.getValueAt(0,"VAL_TOTA_PAGA_LOCA")).floatValue()));
			}

			if (rs.getValueAt(0,"NUM_UNID_ATEN_TOTA")!= null) {
				dtoFACDocumentoContableCabecera.setNumUnidadesAtendidas(new Integer(((BigDecimal)rs.getValueAt(0,"NUM_UNID_ATEN_TOTA")).intValue()));
			}
			
			if (rs.getValueAt(0,"VAL_PREC_CATA_IMPU")!= null) {
				dtoFACDocumentoContableCabecera.setPrecioCatSinImpTotLoc(new Float(((BigDecimal)rs.getValueAt(0,"VAL_PREC_CATA_IMPU")).floatValue()));
			}
		
			if (rs.getValueAt(0,"VAL_PREC_CONT_IMPU")!= null) {
                dtoFACDocumentoContableCabecera.setPrecioContSinImpTotLoc(new Float(((BigDecimal)rs.getValueAt(0,"VAL_PREC_CONT_IMPU")).floatValue()));
			}
        
			dtoFACDocumentoContableCabecera.setNumDocContableInterno(new Integer(((BigDecimal)rs.getValueAt(0,"NUM_DOCU_CONT_INTE")).intValue()));

			if (rs.getValueAt(0,"IMP_IMPU_TOTA_LOCA")!= null){
				dtoFACDocumentoContableCabecera.setImporteImpuestosTotalLocal(new Float(((BigDecimal)rs.getValueAt(0,"IMP_IMPU_TOTA_LOCA")).floatValue()));
			}

			if (rs.getValueAt(0,"NUM_DOCU_ORIG")!= null){
				dtoFACDocumentoContableCabecera.setNumeroDocOrigen(new Long(((BigDecimal)rs.getValueAt(0,"NUM_DOCU_ORIG")).longValue()));
			}
			dtoFACDocumentoContableCabecera.setOidCabeceraSolicitud(new Long(((BigDecimal)rs.getValueAt(0,"SOCA_OID_SOLI_CABE")).longValue()));


			dtoFACDocumentoContableCabecera.setFechaFacturacion(new Date(((Date)rs.getValueAt(0,"FEC_FACT")).getTime()));

			if (rs.getValueAt(0,"VAL_OBSE")!= null){
				dtoFACDocumentoContableCabecera.setGlosa((rs.getValueAt(0,"VAL_OBSE")).toString());
			}
            
			if (rs.getValueAt(0,"VAL_NUME_SOLI")!= null){
              dtoFACDocumentoContableCabecera.setNumeroSolicitud(new Long(((BigDecimal)rs.getValueAt(0,"VAL_NUME_SOLI")).longValue()));
              dtoFACDocumentoContableCabecera.setNumConsolidado(new Long(((BigDecimal)rs.getValueAt(0,"VAL_NUME_SOLI")).longValue()));
			}
            
            if (rs.getValueAt(0,"NUMEROSOLI")!= null) {
               dtoFACDocumentoContableCabecera.setNumDocReferencia(rs.getValueAt(0,"NUMEROSOLI").toString());
			}

			dtoFACDocumentoContableCabecera.setPais(new Long(((BigDecimal)rs.getValueAt(0,"TSPA_OID_TIPO_SOLI_PAIS")).longValue()));
            
            String valRutiDise = rs.getValueAt(0,"VAL_RUTI_DISE_FORM").toString();
            UtilidadesLog.debug(">>>>>>>>>>DAODocuContable valRutiDise es:" + valRutiDise);
            dtoFACDocumentoContableCabecera.setRutinaDiseñoFormulario(valRutiDise);
        
			dtoFACDocumentoContableCabecera.setCodPeriodo(rs.getValueAt(0,"COD_PERI").toString());
            
            if (rs.getValueAt(0,"COD_PERI_REFE")!= null){
                dtoFACDocumentoContableCabecera.setCodPeriodoRefe(rs.getValueAt(0,"COD_PERI_REFE").toString());
            }
  
			dtoFACDocumentoContableCabecera.setNombrePeriodo(rs.getValueAt(0,"VAL_NOMB_PERI").toString());
			dtoFACDocumentoContableCabecera.setCodTerritorio(rs.getValueAt(0,"COD_TERR").toString());
			dtoFACDocumentoContableCabecera.setCodZona(rs.getValueAt(0,"COD_ZONA").toString());	 
	
			if (rs.getValueAt(0,"VAL_NOMB_CORT_MONE")!= null){
				dtoFACDocumentoContableCabecera.setMoneda(((rs.getValueAt(0,"VAL_NOMB_CORT_MONE")).toString()));
			}
			if (rs.getValueAt(0,"NUM_SECU_FACT_DIAR")!= null){
				dtoFACDocumentoContableCabecera.setNumeroSecuenciaFacturacionDiaria(new Integer(((BigDecimal)rs.getValueAt(0,"NUM_SECU_FACT_DIAR")).intValue()));
			}

			if (rs.getValueAt(0,"VAL_TEXT_COMU")!= null){
				dtoFACDocumentoContableCabecera.setTelefono(((rs.getValueAt(0,"VAL_TEXT_COMU")).toString()));
			}
            
            if (rs.getValueAt(0,"VAL_DIRE_COMP")!=null) {
                dtoFACDocumentoContableCabecera.setNombreVia(rs.getValueAt(0,"VAL_DIRE_COMP").toString());
            }
            
            dtoDocLegal.setOidPais(new Long(rs.getValueAt(0, "PAIS_OID_PAIS").toString()));

			dtoFACDocumentoContable.setCabecera(dtoFACDocumentoContableCabecera);
      
            /* dmorello, 07/11/2006: se coloca en TRUE para que el código interno se complete al reimprimir */
            dtoDocLegal.setIndOnline(Boolean.TRUE);
      
            if (rs.getValueAt(0, "TASA_PERC")!=null){
                dtoFACDocumentoContableCabecera.setTasaImpuestoPercepcion(new Float(rs.getValueAt(0, "TASA_PERC").toString()));
            }
            boolean imprimirPercepcion = ! rs.getValueAt(0,"CONTA_IMPRE_PERCEP").toString().equals("0");
            dtoFACDocumentoContableCabecera.setIndImprimirPercepcion( new Boolean(imprimirPercepcion) );
            UtilidadesLog.debug("El Indicador de Imprimir Percepcion queda asi: " + dtoFACDocumentoContableCabecera.getIndImprimirPercepcion());
            dtoFACDocumentoContableCabecera.setOidPeriodo(UtilidadesBD.convertirALong(rs.getValueAt(0, "PERD_OID_PERI")));
		}

        //4.- Ahora hacemos la siguiente consulta: 
        StringBuffer query2 = new StringBuffer();
        Vector parametros2 = new Vector();

        query2.append(" SELECT A.VAL_PREC_CATA_UNIT_LOCA, ");
        query2.append(" A.VAL_PREC_CONT_UNIT_LOCA,A.VAL_PREC_SIN_IMPU_UNIT, ");
        query2.append(" A.VAL_PREC_SIN_IMPU_TOTA_LOCA, ");
        query2.append(" A.VAL_PREC_FACT_UNIT_LOCA,A.VAL_PREC_FACT_TOTA_LOCA, ");
        query2.append(" A.VAL_PREC_CATA_TOTA_LOCA,");
        query2.append(" A.VAL_PREC_CONT_UNIT_LOCA, ");
        query2.append(" A.IND_NO_IMPR,A.NUM_UNID_ATEN, ");
        query2.append(" A.IND_DENT_FUER_CAJA_BOLS, PQ_APL_AUX.Valor_Gen_I18n_Sicc( "+idioma+", C.OID_PROD, 'MAE_PRODU' ) DES_CORT , C.COD_SAP, ");
        query2.append(" D.VAL_CODI_VENT,  ");
        query2.append(" A.VAL_PREC_CONT_TOTA_LOCA, ");
        query2.append(" A.VAL_PREC_NETO_UNIT_LOCA, ");
        query2.append(" A.VAL_PREC_NETO_TOTA_LOCA ");
        query2.append(" , case when (psc.SOCA_OID_DOCU_REFE is not null) then ");
   		query2.append(" ( ");
		query2.append("  select corpo3.cod_peri ");
		query2.append("  from ped_solic_cabec soli, cra_perio perio3, seg_perio_corpo corpo3 ");
		query2.append("  where soli.oid_soli_cabe = psc.SOCA_OID_DOCU_REFE ");
		query2.append("    and soli.perd_oid_peri = perio3.oid_peri  ");
 		query2.append("    and perio3.peri_oid_peri = corpo3.oid_peri ");
		query2.append(" ) ");
        query2.append(" else null ");
        query2.append(" end PERIREF, ");
	    query2.append(" psc2.val_nume_soli SOLIREF, ");
        query2.append(" D.VAL_CODI_VENT_FICT, ");
        query2.append(" D.NUM_UNID_COMPR, ");
        query2.append(" D.FOPA_OID_FORM_PAGO, ");  
        query2.append(" A.VAL_PORC_DESC as B_VAL_PORC_DESC, ");
        query2.append(" A.IMP_DESC_TOTA_LOCA as B_IMP_DESC_TOTA_LOCA ");
        query2.append(" FROM FAC_DOCUM_CONTA_LINEA A, FAC_DOCUM_CONTA_CABEC B,");
        query2.append(" MAE_PRODU C, PED_SOLIC_POSIC D ");
        query2.append(" , ped_solic_cabec psc ");
	    query2.append(" , ped_solic_cabec psc2 ");
        query2.append(" WHERE A.DCCA_OID_CABE= ? ");
        parametros2.add(oidDocumento);
        query2.append(" AND A.DCCA_OID_CABE= B.OID_CABE ");
        query2.append(" AND C.OID_PROD=A.PROD_OID_PROD ");
        query2.append(" AND D.OID_SOLI_POSI=A.SOPO_OID_SOLI_POSI ");
        query2.append(" AND d.soca_oid_soli_cabe = psc.oid_soli_cabe  ");
        query2.append(" AND psc.soca_oid_docu_refe = psc2.oid_soli_cabe(+) ");

		
        RecordSet rs1 = new RecordSet();

        try {
            rs1 = bs.dbService.executePreparedQuery(query2.toString(), parametros2);
        } catch (Exception e) {
            String codigoError = CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS;
            this.logError("obtenerDatosVisualizacion2: Exception", e);
            this.logSql("obtenerDatosVisualizacion2.SQL: ", query2.toString(),
                parametros);
            throw new MareException(e,
                UtilidadesError.armarCodigoError(codigoError));
        }
        //4.1.- Por cada registro recuperado crear un DTOFACDocumentoContableDetalle y rellenarlo con los datos de cada registro. 

		DTOFACDocumentoContableDetalle dtoFACDocumentoContableDetalle = null;
		ArrayList array = new ArrayList();
		if(!rs1.esVacio()){
			
			for (int i=0;i<rs1.getRowCount();i++){
				dtoFACDocumentoContableDetalle = new DTOFACDocumentoContableDetalle();

                dtoFACDocumentoContableDetalle.setCodigoVentaFicticio(UtilidadesBD.convertirALong(rs1.getValueAt(i, "VAL_CODI_VENT_FICT")));  
                dtoFACDocumentoContableDetalle.setPorcentajeDescuento(UtilidadesBD.convertirAFloat(rs1.getValueAt(i, "B_VAL_PORC_DESC")));
                dtoFACDocumentoContableDetalle.setImporteDescTotaLocal(UtilidadesBD.convertirAFloat(rs1.getValueAt(i, "B_IMP_DESC_TOTA_LOCA")));
                dtoFACDocumentoContableDetalle.setUnidadesSolicitadas(UtilidadesBD.convertirALong(rs1.getValueAt(i, "NUM_UNID_COMPR")));
                dtoFACDocumentoContableDetalle.setOidFormaPago(UtilidadesBD.convertirALong(rs1.getValueAt(i, "FOPA_OID_FORM_PAGO")));


				if (rs1.getValueAt(i,"VAL_PREC_CATA_UNIT_LOCA")!= null){
					dtoFACDocumentoContableDetalle.setPrecioCatalUnitLocal(new Float(((BigDecimal)rs1.getValueAt(i,"VAL_PREC_CATA_UNIT_LOCA")).floatValue()));
				}
				if (rs1.getValueAt(i,"VAL_PREC_CONT_UNIT_LOCA")!= null){
				dtoFACDocumentoContableDetalle.setPrecioContUnitLocal(new Float(((BigDecimal)rs1.getValueAt(i,"VAL_PREC_CONT_UNIT_LOCA")).floatValue()));
				}

				if (rs1.getValueAt(i,"VAL_PREC_SIN_IMPU_UNIT")!= null){
				dtoFACDocumentoContableDetalle.setPrecioSinImpuUnitLocal(new Float(((BigDecimal)rs1.getValueAt(i,"VAL_PREC_SIN_IMPU_UNIT")).floatValue()));
				}

				if (rs1.getValueAt(i,"VAL_PREC_SIN_IMPU_TOTA_LOCA")!= null){
				dtoFACDocumentoContableDetalle.setPrecioSinImpuTotalLocal(new Float(((BigDecimal)rs1.getValueAt(i,"VAL_PREC_SIN_IMPU_TOTA_LOCA")).floatValue()));
				}

				if (rs1.getValueAt(i,"VAL_PREC_FACT_UNIT_LOCA")!= null){
				dtoFACDocumentoContableDetalle.setPrecioFactUnitLocal(new Float(((BigDecimal)rs1.getValueAt(i,"VAL_PREC_FACT_UNIT_LOCA")).floatValue()));
				}

				if (rs1.getValueAt(i,"VAL_PREC_FACT_TOTA_LOCA")!= null){
				dtoFACDocumentoContableDetalle.setPrecioFactTotalLocal(new Float(((BigDecimal)rs1.getValueAt(i,"VAL_PREC_FACT_TOTA_LOCA")).floatValue()));
				}
 
				if (rs1.getValueAt(i,"VAL_PREC_CATA_TOTA_LOCA")!= null){
				dtoFACDocumentoContableDetalle.setPrecioCatalTotLocal(new Float(((BigDecimal)rs1.getValueAt(i,"VAL_PREC_CATA_TOTA_LOCA")).floatValue()));
				}
 	
				if (rs1.getValueAt(i,"VAL_PREC_CONT_TOTA_LOCA")!= null){
                dtoFACDocumentoContableDetalle.setPrecioContTotLocal(new Float(((BigDecimal)rs1.getValueAt(i,"VAL_PREC_CONT_TOTA_LOCA")).floatValue()));
				}
 	
				if (rs1.getValueAt(i,"IND_NO_IMPR")!= null){
					if(((BigDecimal)rs1.getValueAt(i,"IND_NO_IMPR")).intValue()==1){
						dtoFACDocumentoContableDetalle.setNoImprimible(true);
					}
					else{
						dtoFACDocumentoContableDetalle.setNoImprimible(false);
					}
				}
				dtoFACDocumentoContableDetalle.setUnidadesAtendidas(new Long(((BigDecimal)rs1.getValueAt(i,"NUM_UNID_ATEN")).longValue()));
				if (rs1.getValueAt(i,"IND_DENT_FUER_CAJA_BOLS")!= null){	
					dtoFACDocumentoContableDetalle.setIndicadorDentroFueraCajaBolsa((rs1.getValueAt(i,"IND_DENT_FUER_CAJA_BOLS")).toString());
				}

				if (rs1.getValueAt(i,"DES_CORT")!= null){	
					dtoFACDocumentoContableDetalle.setDescripcionProd((rs1.getValueAt(i,"DES_CORT")).toString());
				}
				dtoFACDocumentoContableDetalle.setCodigoProducto((rs1.getValueAt(i,"COD_SAP")).toString());
			
				if (rs1.getValueAt(i,"VAL_CODI_VENT")!= null){	
					dtoFACDocumentoContableDetalle.setCodigoVenta((rs1.getValueAt(i,"VAL_CODI_VENT")).toString());
				}
                
                //Añadido por incidencia 21757
                if (rs1.getValueAt(i,"VAL_PREC_NETO_UNIT_LOCA")!= null){
					dtoFACDocumentoContableDetalle.setPrecioNetoUnitarioLocal(new Float(((BigDecimal)rs1.getValueAt(i,"VAL_PREC_NETO_UNIT_LOCA")).floatValue()));
				}
                
                //Añadido por incidencia 21757
                if (rs1.getValueAt(i,"VAL_PREC_NETO_TOTA_LOCA")!= null){
					dtoFACDocumentoContableDetalle.setPrecioNetoTotalLocal(new Float(((BigDecimal)rs1.getValueAt(i,"VAL_PREC_NETO_TOTA_LOCA")).floatValue()));
				}
                
                //  Agregado por HRCS - Fecha 07/06/2007 - Cambio Sicc20070274
                if (rs1.getValueAt(i,"PERIREF")!=null) {
                    dtoFACDocumentoContableDetalle.setCodPeriodo( rs1.getValueAt(i,"PERIREF").toString() );
                }
                else {  //  El periodo de la Solicitud no llega nulo
                    dtoFACDocumentoContableDetalle.setCodPeriodo( dtoFACDocumentoContableCabecera.getCodPeriodo() );
                }
        
				array.add(dtoFACDocumentoContableDetalle);
			}
		}
		
		dtoFACDocumentoContable.setDetalle(array);
        dtoDocLegal.añadirPagina(dtoFACDocumentoContable);
		UtilidadesLog.info("DAODocuContable.obtenerDatosVisualizacion(Long oidDocumento, Long subacceso): Salida"); 
        //5.- Devolver el objeto DTODocLegal*/
        return dtoDocLegal;
        
        
        } catch (Exception e) {
            UtilidadesLog.error("en: ",e);
            UtilidadesLog.error(e);
            String codigoError = CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS;
            this.logError("SCS: Exception", e);
            throw new MareException(e,
                UtilidadesError.armarCodigoError(codigoError));
        }
        
    }

    /**
     * CHANGELOG
     * ---------
     * dmorello, 09/06/2009 - Cambio 20090922 - Se recupera IMP_IMPU_PROD_NACI
     */
    public RecordSet obtenerDatosDocumentos(DTOFACCabeceraSolicitud entrada) throws MareException {
        UtilidadesLog.info("DAODocuContable.obtenerDatosDocumentos(DTOFACCabeceraSolicitud entrada): Entrada"); 

        StringBuffer query = new StringBuffer();
        
        Long idiomaPorDefecto = entrada.getOidIdioma();
        if (idiomaPorDefecto == null){
            idiomaPorDefecto= RecuperadorIdiomaDefectoServidor.getIdiomaDefectoServidor(); 
        }
        
       /*query.append(" SELECT DCC.OID_CABE as A_OID_CABE, ");
       query.append("        DCC.PAIS_OID_PAIS as A_PAIS_OID_PAIS, ");
       query.append("        DCC.SOCI_OID_SOCI as A_SOCI_OID_SOCI, ");
       query.append("        DCC.SBAC_OID_SBAC as A_SBAC_OID_SBAC, ");
       query.append("        DCC.TIDO_OID_TIPO_DOCU as A_TIDO_OID_TIPO_DOCU, ");
       query.append("        DCC.VAL_EJER_DOCU_INTE as A_VAL_EJER_DOCU_INTE, ");
       query.append("        DCC.NUM_DOCU_CONT_INTE as A_NUM_DOCU_CONT_INTE, ");
       query.append("        DCC.VAL_ESTA as A_VAL_ESTA, ");
       query.append("        DCC.FEC_EMIS as A_FEC_EMIS, ");
       query.append("        DCC.VAL_PUNT_EMIS as A_VAL_PUNT_EMIS, ");
       query.append("        DCC.FEC_FACT as A_FEC_FACT, ");
       query.append("        DCC.VAL_SERI_DOCU_LEGA as A_VAL_SERI_DOCU_LEGA, ");
       query.append("        DCC.NUM_DOCU_LEGA as A_NUM_DOCU_LEGA, ");
       query.append("        DCC.VAL_NUME_IDEN_FISC as A_VAL_NUME_IDEN_FISC, ");
       query.append("        DCC.VAL_NUME_IDEN_NNAL as A_VAL_NUME_IDEN_NNAL, ");
       query.append("        DCC.VAL_OBSE as A_VAL_OBSE, ");
       query.append("        DCC.NUM_ABON as A_NUM_ABON, ");
       query.append("        DCC.VAL_NOM1 as A_VAL_NOM1, ");
       query.append("        DCC.VAL_NOM2 as A_VAL_NOM2, ");
       query.append("        DCC.VAL_APE1 as A_VAL_APE1, ");
       query.append("        DCC.VAL_APE2 as A_VAL_APE2, ");
       query.append("        DCC.ZORG_OID_REGI as A_ZORG_OID_REGI, ");
       query.append("        DCC.ZSGV_OID_SUBG_VENT as A_ZSGV_OID_SUBG_VENT, ");
       query.append("        DCC.ZZON_OID_ZONA as A_ZZON_OID_ZONA, ");
       query.append("        DCC.TERR_OID_TERR as A_TERR_OID_TERR, ");
       query.append("        DCC.CLDI_OID_CLIE_DIRE as A_CLDI_OID_CLIE_DIRE, ");
       query.append("        DCC.PERD_OID_PERI as A_PERD_OID_PERI, ");
       query.append("        DCC.FOPA_OID_FORM_PAGO as A_FOPA_OID_FORM_PAGO, ");
       query.append("        DCC.SOCA_OID_SOLI_CABE as A_SOCA_OID_SOLI_CABE, ");
       query.append("        DCC.FORS_OID_FORM as A_FORS_OID_FORM, ");
       query.append("        DCC.ZSCC_OID_SECC as A_ZSCC_OID_SECC, ");
       query.append("        DCC.MONE_OID_MONE as A_MONE_OID_MONE, ");
       query.append("        DCC.IMP_FLET_TOTA_LOCA as A_IMP_FLET_TOTA_LOCA, ");
       query.append("        DCC.IMP_FLET_IMPU_TOTA_LOCA as A_IMP_FLET_IMPU_TOTA_LOCA, ");
       query.append("        DCC.VAL_TIPO_DIRE as A_VAL_TIPO_DIRE, ");
       query.append("        DCC.NUM_DOCU_ORIG as A_NUM_DOCU_ORIG, ");
       query.append("        DCC.VAL_ALMA as A_VAL_ALMA, ");
       query.append("        DCC.VAL_TIPO_CAMB as A_VAL_TIPO_CAMB, ");
       query.append("        DCC.IND_IMPR as A_IND_IMPR, ");
       query.append("        DCC.IMP_DES3_TOTAL_LOCA as A_IMP_DES3_TOTAL_LOCA, ");
       query.append("        DCC.IMP_DES3_SIN_IMPU_TOTA as A_IMP_DES3_SIN_IMPU_TOTA,         ");
       query.append("        DCC.IMP_FLET_TOTA_DOCU as A_IMP_FLET_TOTA_DOCU, ");
       query.append("        DCC.IMP_DES3_TOTA_DOCU as A_IMP_DES3_TOTA_DOCU, ");
       query.append("        DCC.VAL_PREC_CATA_IMPU as A_VAL_PREC_CATA_IMPU, ");
       query.append("        DCC.VAL_PREC_CONT_IMPU as A_VAL_PREC_CONT_IMPU, ");
       query.append("        DCC.VAL_PREC_CATA_TOTA_LOCA_UNID as A_VAL_PREC_CATA_TOTA_LOCA_UNID, ");
       query.append("        DCC.VAL_PREC_CATA_TOTA_LOCA as A_VAL_PREC_CATA_TOTA_LOCA, ");
       query.append("        DCC.VAL_PREC_CONT_TOTA_LOCA as A_VAL_PREC_CONT_TOTA_LOCA, ");
       query.append("        DCC.IMP_DES1_TOTA_LOCA as A_IMP_DES1_TOTA_LOCA, ");
       query.append("        DCC.IMP_DES1_IMPU as A_IMP_DES1_IMPU, ");
       query.append("        DCC.VAL_PREC_FACT_TOTA_LOCA as A_VAL_PREC_FACT_TOTA_LOCA, ");
       query.append("        DCC.VAL_PREC_TOTA_TOTA_LOCA as A_VAL_PREC_TOTA_TOTA_LOCA, ");
       query.append("        DCC.IMP_DES3_IMPU as A_IMP_DES3_IMPU, ");
       query.append("        DCC.IMP_DESC_TOTA_LOCA as A_IMP_DESC_TOTA_LOCA, ");
       query.append("        DCC.VAL_PREC_NETO_TOTA_LOCA as A_VAL_PREC_NETO_TOTA_LOCA, ");
       query.append("        DCC.IMP_IMPU_TOTA_LOCA as A_IMP_IMPU_TOTA_LOCA, ");
       query.append("        DCC.VAL_TOTA_PAGA_LOCA as A_VAL_TOTA_PAGA_LOCA, ");
       query.append("        DCC.VAL_TOTA_PAGA_DOCU as A_VAL_TOTA_PAGA_DOCU, ");
       query.append("        DCC.IMP_REDO_LOCA as A_IMP_REDO_LOCA, ");
       query.append("        DCC.IMP_REDO_CONS_LOCA as A_IMP_REDO_CONS_LOCA, ");
       query.append("        DCC.NUM_UNID_ATEN_TOTA as A_NUM_UNID_ATEN_TOTA, ");
       query.append("        DCC.VAL_PREC_CATA_TOTA_DOCU as A_VAL_PREC_CATA_TOTA_DOCU, ");
       query.append("        DCC.VAL_PREC_CATA_SIN_IMPU_TOTA as A_VAL_PREC_CATA_SIN_IMPU_TOTA, ");
       query.append("        DCC.VAL_PREC_CONT_TOTA_DOCU as A_VAL_PREC_CONT_TOTA_DOCU, ");
       query.append("        DCC.VAL_PREC_CONT_SIN_IMPU_TOTA as A_VAL_PREC_CONT_SIN_IMPU_TOTA, ");
       query.append("        DCC.IMP_DES1_TOTA_DOCU as A_IMP_DES1_TOTA_DOCU, ");
       query.append("        DCC.IMP_DES1_SIN_IMPU_TOTA as A_IMP_DES1_SIN_IMPU_TOTA, ");
       query.append("        DCC.IMP_DES3_SIN_IMPU_TOTA as A_IMP_DES3_SIN_IMPU_TOTA, ");
       query.append("        DCC.IMP_DESC_TOTA_DOCU as A_IMP_DESC_TOTA_DOCU, ");
       query.append("        DCC.VAL_PREC_FACT_TOTA_DOCU as A_VAL_PREC_FACT_TOTA_DOCU, ");
       query.append("        DCC.IMP_IMPU_TOTA_DOCU as A_IMP_IMPU_TOTA_DOCU, ");
       query.append("        DCC.VAL_PREC_TOTA_TOTA_DOCU as A_VAL_PREC_TOTA_TOTA_DOCU, ");
       query.append("        DCC.VAL_PREC_NETO_TOTA_DOCU as A_VAL_PREC_NETO_TOTA_DOCU, ");
       query.append("        DCC.IMP_FLET_SIN_IMPU_TOTA_DOCU as A_IMP_FLET_SIN_IMPU_TOTA_DOCU, ");
       query.append("        DCC.IMP_REDO_CONS_DOCU as A_IMP_REDO_CONS_DOCU, ");
       query.append("        DCC.IMP_REDO_DOCU as A_IMP_REDO_DOCU, ");
       query.append("        DCC.NUM_LOTE_CONT as A_NUM_LOTE_CONT, ");
       query.append("        DCC.FEC_CONT as A_FEC_CONT, ");
       query.append("        DCC.VAL_DIRE_COMP as A_VAL_DIRE_COMP, ");
       query.append("        DCC.VAL_NOMB_VIA as A_VAL_NOMB_VIA, ");
       query.append("        DCL.SOPO_OID_SOLI_POSI as B_SOPO_OID_SOLI_POSI, ");
       query.append("        DCL.PROD_OID_PROD as B_PROD_OID_PROD, ");
       query.append("        DCL.MONE_OID_MONE as B_MONE_OID_MONE, ");
       query.append("        DCL.VAL_PREC_TOTA_TOTA_DOCU as B_VAL_PREC_TOTA_TOTA_DOCU, ");
       query.append("        DCL.VAL_PREC_NETO_TOTA_DOCU as B_VAL_PREC_NETO_TOTA_DOCU, ");
       query.append("        DCL.IMP_IMPU_TOTA_DOCU as B_IMP_IMPU_TOTA_DOCU, ");
       query.append("        DCL.IMP_DESC_SIN_IMPU_TOTA_DOCU as B_IMP_DESC_SIN_IMPU_TOTA_DOCU, ");
       query.append("        DCL.IMP_DESC_TOTA_DOCU as B_IMP_DESC_TOTA_DOCU, ");
       query.append("        DCL.VAL_PREC_FACT_TOTA_DOCU as B_VAL_PREC_FACT_TOTA_DOCU, ");
       query.append("        DCL.VAL_PREC_CATA_TOTA_DOCU as B_VAL_PREC_CATA_TOTA_DOCU, ");
       query.append("        DCL.VAL_PREC_CONT_TOTA_DOCU as B_VAL_PREC_CONT_TOTA_DOCU, ");
       query.append("        DCL.VAL_PREC_TOTA_UNIT_DOCU as B_VAL_PREC_TOTA_UNIT_DOCU, ");
       query.append("        DCL.IMP_IMPU_UNIT_DOCU as B_IMP_IMPU_UNIT_DOCU, ");
       query.append("        DCL.VAL_PREC_NETO_UNIT_DOCU as B_VAL_PREC_NETO_UNIT_DOCU, ");
       query.append("        DCL.IMP_DESC_SIN_IMPU_UNIT_DOCU as B_IMP_DESC_SIN_IMPU_UNIT_DOCU, ");
       query.append("        DCL.IMP_DESC_UNIT_DOCU as B_IMP_DESC_UNIT_DOCU, ");
       query.append("        DCL.VAL_PORC_DESC as B_VAL_PORC_DESC, ");
       query.append("        DCL.VAL_PREC_SIN_IMPU_UNIT_DOCU as B_VAL_PREC_SIN_IMPU_UNIT_DOCU, ");
       query.append("        DCL.VAL_PREC_FACT_UNIT_DOCU as B_VAL_PREC_FACT_UNIT_DOCU, ");
       query.append("        DCL.VAL_PREC_CONT_UNIT_DOCU as B_VAL_PREC_CONT_UNIT_DOCU, ");
       query.append("        DCL.VAL_PREC_CATA_UNIT_DOCU as B_VAL_PREC_CATA_UNIT_DOCU, ");
       query.append("        DCL.VAL_PREC_TOTA_TOTA_LOCA as B_VAL_PREC_TOTA_TOTA_LOCA, ");
       query.append("        DCL.IMP_IMPU_TOTA_LOCA as B_IMP_IMPU_TOTA_LOCA, ");
       query.append("        DCL.VAL_PREC_NETO_TOTA_LOCA as B_VAL_PREC_NETO_TOTA_LOCA, ");
       query.append("        DCL.IMP_DESC_SIN_IMPU_TOTA_LOCA as B_IMP_DESC_SIN_IMPU_TOTA_LOCA, ");
       query.append("        DCL.IMP_DESC_TOTA_LOCA as B_IMP_DESC_TOTA_LOCA, ");
       query.append("        DCL.VAL_PREC_SIN_IMPU_TOTA_LOCA as B_VAL_PREC_SIN_IMPU_TOTA_LOCA, ");
       query.append("        DCL.VAL_PREC_FACT_TOTA_LOCA as B_VAL_PREC_FACT_TOTA_LOCA, ");
       query.append("        DCL.VAL_PREC_CATA_LOCA_UNID_DEMA as B_VAL_PREC_CATA_LOCA_UNID_DEMA, ");
       query.append("        DCL.VAL_PREC_CATA_TOTA_LOCA as B_VAL_PREC_CATA_TOTA_LOCA, ");
       query.append("        DCL.VAL_PREC_CONT_TOTA_LOCA as B_VAL_PREC_CONT_TOTA_LOCA, ");
       query.append("        DCL.VAL_PREC_TOTA_UNIT_LOCA as B_VAL_PREC_TOTA_UNIT_LOCA, ");
       query.append("        DCL.IMP_IMPU_UNIT_LOCA as B_IMP_IMPU_UNIT_LOCA, ");
       query.append("        DCL.VAL_PREC_NETO_UNIT_LOCA as B_VAL_PREC_NETO_UNIT_LOCA, ");
       query.append("        DCL.IMP_DESC_SIN_IMPU_UNIT as B_IMP_DESC_SIN_IMPU_UNIT, ");
       query.append("        DCL.IMP_DESC_UNIT_LOCA as B_IMP_DESC_UNIT_LOCA, ");
       query.append("        DCL.VAL_PREC_SIN_IMPU_UNIT as B_VAL_PREC_SIN_IMPU_UNIT, ");
       query.append("        DCL.VAL_PREC_FACT_UNIT_LOCA as B_VAL_PREC_FACT_UNIT_LOCA, ");
       query.append("        DCL.VAL_PREC_CONT_UNIT_LOCA as B_VAL_PREC_CONT_UNIT_LOCA, ");
       query.append("        DCL.VAL_PREC_CATA_UNIT_LOCA as B_VAL_PREC_CATA_UNIT_LOCA, ");
       query.append("        DCL.VAL_PREC_SIN_IMPU_TOTA_DOCU as B_VAL_PREC_SIN_IMPU_TOTA_DOCU, ");
       query.append("        DCL.NUM_PAGI as B_NUM_PAGI, ");
       query.append("        DCL.IND_DENT_FUER_CAJA_BOLS as B_IND_DENT_FUER_CAJA_BOLS, ");
       query.append("        DCL.NUM_LINEA as B_NUM_LINEA, ");
       query.append("        DCL.NUM_UNID_ATEN as B_NUM_UNID_ATEN, ");
       query.append("        DCL.IND_NO_IMPR as B_IND_NO_IMPR, ");
       query.append("        DCL.VAL_CATA as B_VAL_CATA, ");
       query.append("        DCL.OID as B_OID, ");
       query.append("        DCL.DCCA_OID_CABE as B_DCCA_OID_CABE, ");
       query.append("        MCD.IND_DIRE_PPAL, ");
       query.append("        PERIO1.VAL_NOMB_PERI, ");
       query.append("        SOCIE.VAL_IDEN_FISC, ");
       query.append("        CASE WHEN ((SELECT COUNT(*) ");
       query.append("            FROM MAV_PARAM_GEREN_ZONA PGZ ");
       query.append("            WHERE PGZ.SBTI_OID_SUBT_CLIE = PSC1.SBTI_OID_SUBT_CLIE) >= 1) THEN ");
       query.append("               ' ' ");
       query.append("        ELSE	");  
       query.append("              TO_CHAR(TERRI1.COD_TERR) ");
       query.append("        END COD_TERR, ");
       query.append("        CASE WHEN ((SELECT COUNT(*) ");
       query.append("               FROM MAV_PARAM_GEREN_ZONA PGZ ");
       query.append("               WHERE PGZ.SBTI_OID_SUBT_CLIE = PSC1.SBTI_OID_SUBT_CLIE) >= 1) THEN ");
       query.append("                   (SELECT ZON1.COD_ZONA ");
       query.append("                    FROM ZON_ZONA ZON1 ");
       query.append("                    WHERE ZON1.CLIE_OID_CLIE = PSC1.CLIE_OID_CLIE ");
       query.append("                      AND ZON1.IND_ACTI = 1 ");
       query.append("                      AND ZON1.IND_BORR <> 1 ");
       query.append("                   )	   ");
       query.append("         ELSE ");
       query.append("               ZON.COD_ZONA ");
       query.append("         END COD_ZONA, ");
       query.append("         COMUNI.VAL_TEXT_COMU, ");
       query.append("         TCOM.COD_TIPO_COMU, ");
       query.append("         MP.COD_SAP,  ");
       query.append("         FORMU.VAL_RUTI_DISE_FORM, ");
       query.append("         CORPO1.COD_PERI, ");
       query.append("         MONE.VAL_NOMB_CORT_MONE, ");
       query.append("         PQ_APL_AUX.Valor_Gen_I18n_Sicc(" + idiomaPorDefecto + ", MP.OID_PROD, 'MAE_PRODU' )  DES_CORT,  ");
       query.append("         PSP.VAL_CODI_VENT, ");
       query.append("         TERRI2.COD_TERR, ");
       query.append("         MC.COD_CLIE,  ");
       query.append("         CASE WHEN (SUBSTR(MCD.COD_UNID_GEOG,19,6) IS NULL) THEN ");
       query.append("           ( SELECT VEG.OID_VALO_ESTR_GEOP ");
       query.append("             FROM ZON_VALOR_ESTRU_GEOPO VEG ");
       query.append("             WHERE VEG.ORDE_1 = SUBSTR(MCD.COD_UNID_GEOG,0,6) ");
       query.append("               AND VEG.ORDE_2 = SUBSTR(MCD.COD_UNID_GEOG,7,6) ");
       query.append("               AND VEG.ORDE_3 = SUBSTR(MCD.COD_UNID_GEOG,13,6) ");
       query.append("               AND VEG.ORDE_4 IS NULL ) ");
       query.append("          ELSE  ");
       query.append("           ( SELECT VEG.OID_VALO_ESTR_GEOP ");
       query.append("             FROM ZON_VALOR_ESTRU_GEOPO VEG ");
       query.append("             WHERE VEG.ORDE_1 = SUBSTR(MCD.COD_UNID_GEOG,0,6) ");
       query.append("               AND VEG.ORDE_2 = SUBSTR(MCD.COD_UNID_GEOG,7,6) ");
       query.append("               AND VEG.ORDE_3 = SUBSTR(MCD.COD_UNID_GEOG,13,6) ");
       query.append("               AND VEG.ORDE_4 = SUBSTR(MCD.COD_UNID_GEOG,19,6)) ");
       query.append("           END OID_VALO_ESTR_GEOP,   ");
       query.append("         PQ_APL_AUX.Valor_Gen_I18n_Sicc(" + idiomaPorDefecto + ", TSP.TSOL_OID_TIPO_SOLI, 'PED_TIPO_SOLIC') DTS ");
       query.append("         , case when (psc3.SOCA_OID_DOCU_REFE is not null) then ");
       query.append("         	( ");
       query.append("            select corpo3.cod_peri ");
       query.append("              from ped_solic_cabec soli, cra_perio perio3, seg_perio_corpo corpo3 ");
       query.append("             where soli.oid_soli_cabe = psc3.SOCA_OID_DOCU_REFE ");
       query.append("               and soli.perd_oid_peri = perio3.oid_peri  ");
       query.append("               and perio3.peri_oid_peri = corpo3.oid_peri ");
       query.append("           ) ");
       query.append("           else null ");
       query.append("         end PERIREF, ");
       query.append("         psc4.val_nume_soli SOLIREF ");
       // Agregado por Cambio FAC-003 ------ AL 
       query.append("         ,PSC3.ICTP_OID_TIPO_PROG, ");
       query.append("         (SELECT COD_TIPO_PROG FROM INC_CONCU_TIPO_PROG WHERE OID_TIPO_PROG = PSC3.ICTP_OID_TIPO_PROG) COD_TIPO_PROG, ");
       query.append("         CASE WHEN ((SELECT COD_TIPO_PROG FROM INC_CONCU_TIPO_PROG WHERE OID_TIPO_PROG = DCC.ICTP_OID_TIPO_PROG) = 'B' ) THEN ");
       query.append("           (SELECT 'C' || SUBSTR(SPC.COD_PERI, 5) ||'/'|| SPC.VAL_ANIO FROM INC_CONCU_PARAM_GENER CPG, CRA_PERIO PER, SEG_PERIO_CORPO SPC WHERE CPG.OID_PARA_GRAL = PSC3.COPA_OID_PARA_GENE AND PER.OID_PERI = CPG.PERD_OID_PERI_DESD AND PER.PERI_OID_PERI = SPC.OID_PERI) ");                                                                
       query.append("         END PERI_INI_CONCU,  ");
       query.append("         CASE WHEN ((SELECT COD_TIPO_PROG FROM INC_CONCU_TIPO_PROG WHERE OID_TIPO_PROG = DCC.ICTP_OID_TIPO_PROG) = 'B' ) THEN ");
       query.append("           (SELECT 'C' || SUBSTR(SPC.COD_PERI, 5) ||'/'|| SPC.VAL_ANIO FROM INC_CONCU_PARAM_GENER CPG, CRA_PERIO PER, SEG_PERIO_CORPO SPC WHERE CPG.OID_PARA_GRAL = PSC3.COPA_OID_PARA_GENE AND PER.OID_PERI = CPG.PERD_OID_PERI_HAST AND PER.PERI_OID_PERI = SPC.OID_PERI) ");                                         
       query.append("         END PERI_FIN_CONCU,  ");
       query.append("         CASE WHEN ((SELECT COD_TIPO_PROG FROM INC_CONCU_TIPO_PROG WHERE OID_TIPO_PROG = DCC.ICTP_OID_TIPO_PROG) = 'B' ) THEN ");
       query.append("           (SELECT NUM_CONC FROM INC_CONCU_PARAM_GENER WHERE OID_PARA_GRAL = PSC3.COPA_OID_PARA_GENE) ");                                
       query.append("         END NUM_CONCU  ");
       // Agregado por Cambio FAC-003 ------ AL 
       // Agregado por Cambio FAC-001 ------ AL 
       query.append("         ,PSP.VAL_CODI_VENT_FICT ");
       query.append("         ,LPAD(SUBSTR(PSC1.VAL_NUME_SOLI, 2, 10), 8, 0) COD_BARRAS ");
       query.append("         , DCC.VAL_TELE_FIJO TELEF_FIJO "); 
       query.append("         , DCC.VAL_TELE_CELU TELEF_CEL ");   
       query.append("         , DCC.VAL_BARR "); 
       query.append("           ,RTRIM((SELECT DES_GEOG ");		 
       query.append("            FROM ZON_VALOR_ESTRU_GEOPO ");
       query.append("            WHERE ORDE_1 = SUBSTR(MCD.COD_UNID_GEOG, 0, 6) ");
       query.append("              AND ORDE_2 IS NULL)) DEPARTAMENTO ");
       query.append("           ,(SELECT DES_GEOG ");		 
       query.append("            FROM ZON_VALOR_ESTRU_GEOPO ");
       query.append("            WHERE ORDE_1 = SUBSTR(MCD.COD_UNID_GEOG, 0, 6) ");
       query.append("              AND ORDE_2 = SUBSTR(MCD.COD_UNID_GEOG, 7, 6) ");
       query.append("              AND ORDE_3 IS NULL) MUNICIPIO ");    
       query.append("           ,CASE WHEN ((SELECT COD_ESTA_CLIE FROM MAE_ESTAT_CLIEN MEC WHERE MEC.OID_ESTA_CLIE = DAT.ESTA_OID_ESTA_CLIE) IN ('01', '07')) THEN ");
       query.append("           	   		'* PRIMER PEDIDO *' ");
        query.append("            ELSE ");
       query.append("              (SELECT VAL_TEXT_VARI ");
       query.append("              FROM ");
       query.append("           	(SELECT CTV.VAL_TEXT_VARI ");
       query.append("             	 FROM APE_CONFI_TEXTO_VARIA CTV, ");
       query.append("           	     ( ");
       query.append("           		  SELECT MTS.TICL_OID_TIPO_CLIE, ");
       query.append("           		  	     MTS.SBTI_OID_SUBT_CLIE, ");
       query.append("           				 MCC.CLAS_OID_CLAS, ");
       query.append("           				 MCC.TCCL_OID_TIPO_CLASI ");
       query.append("           		  FROM MAE_CLIEN_TIPO_SUBTI MTS, ");
       query.append("           		  	   MAE_CLIEN_CLASI MCC ");
       query.append("           		  WHERE MCC.CTSU_OID_CLIE_TIPO_SUBT = MTS.OID_CLIE_TIPO_SUBT ");       
       query.append("           		    AND MTS.CLIE_OID_CLIE = " + entrada.getReceptorFactura());
       query.append("           		) CLIEN ");
       query.append("           	 WHERE CTV.TICL_OID_TIPO_CLIE = CLIEN.TICL_OID_TIPO_CLIE ");
       query.append("           	   AND (CTV.SBTI_OID_SUBT_CLIE = CLIEN.SBTI_OID_SUBT_CLIE OR CTV.SBTI_OID_SUBT_CLIE IS NULL) ");
       query.append("           	   AND (CTV.CLAS_OID_CLAS = CLIEN.CLAS_OID_CLAS OR CTV.CLAS_OID_CLAS IS NULL) ");
       query.append("           	   AND (CTV.TCCL_OID_TIPO_CLAS = CLIEN.TCCL_OID_TIPO_CLASI OR CTV.TCCL_OID_TIPO_CLAS IS NULL) ");
       query.append("           	   ORDER BY CTV.TICL_OID_TIPO_CLIE, ");
       query.append("           	   	   CTV.SBTI_OID_SUBT_CLIE, ");
       query.append("           	   	   CTV.TCCL_OID_TIPO_CLAS, ");
       query.append("           	   	   CTV.CLAS_OID_CLAS ");
       query.append("           	    ) WHERE ROWNUM = 1) ");
       query.append("             END PRI_PED, ");
       query.append("             PSP.NUM_UNID_COMPR, ");
       query.append("             PSP.FOPA_OID_FORM_PAGO, ");  
       query.append("             MC.SAL_DEUD_ANTE, "); 
       query.append("             CASE WHEN (DCC.MONE_OID_MONE IS NULL) THEN "); 
       query.append("               (  ");
       query.append("               SELECT NUM_DECI ");                     
       query.append("               FROM SEG_PAIS PAIS, SEG_MONED MON ");                     
       query.append("               WHERE PAIS.MONE_OID_MONE = MON.OID_MONE ");                     
       query.append("                 AND PAIS.OID_PAIS = DCC.PAIS_OID_PAIS ");                     
       query.append("               ) "); 
       query.append("             ELSE "); 
       query.append("               (  ");
       query.append("               SELECT NUM_DECI ");                     
       query.append("               FROM SEG_MONED MON ");                     
       query.append("               WHERE MON.OID_MONE = DCC.MONE_OID_MONE ");                            
       query.append("               ) "); 
       query.append("             END NUM_DECI "); 
       // Agregado por Cambio FAC-001 ------ AL 
       // Agregado por Cambio FAC-003-COL ------ AL        
       query.append(" ,(SELECT NUM_DIAS_CUPO_CRUC ");
       query.append(" FROM SEG_PARAM_INTER_PAIS ");
       query.append(" WHERE PAIS_OID_PAIS = DCC.PAIS_OID_PAIS ");
       query.append("   AND IND_APLI_CUPO_TRES = 1) DIAS_CRUCE, ");
       query.append(" (SELECT COD_REGI FROM ZON_REGIO WHERE OID_REGI = ZON.ZORG_OID_REGI) COD_REGI, ");
       query.append(" (SELECT COD_SECC FROM ZON_SECCI SEC, ZON_TERRI_ADMIN ZTA WHERE SEC.OID_SECC = ZTA.ZSCC_OID_SECC AND ZTA.TERR_OID_TERR = TERRI1.OID_TERR AND ZTA.IND_BORR <> 1 AND SEC.IND_ACTI = 1) COD_SECC ");
       query.append(" ,DCC.VAL_IMPO_IVA_ASUM_EMPR ");
       // Agregado por Cambio FAC-003-COL ------ AL              
       query.append(" ,DCL.IMP_IMPU_TOTA_PROD_NACI ");
       query.append(" FROM FAC_DOCUM_CONTA_CABEC DCC, ");
       query.append("     FAC_DOCUM_CONTA_LINEA DCL, ");
       query.append("     CRA_PERIO PERIO1, ");
       query.append("     MAE_CLIEN_DIREC MCD, "); 
       query.append("     SEG_SOCIE SOCIE, ");
       query.append("     ZON_TERRI TERRI1, ");
       query.append("     ZON_ZONA ZON, ");
       query.append("     MAE_CLIEN_COMUN COMUNI,  ");
       query.append("     MAE_TIPO_COMUN TCOM, ");
       query.append("     MAE_PRODU MP, ");
       query.append("     FAC_FORMU FORMU, ");
       query.append("     SEG_PERIO_CORPO CORPO1, ");
       query.append("     SEG_MONED MONE, ");
       query.append("     PED_SOLIC_POSIC PSP, ");
       query.append("     ZON_TERRI TERRI2, ");
       query.append("     MAE_CLIEN MC, ");
       query.append("     PED_SOLIC_CABEC PSC1, ");
       query.append("     ped_solic_cabec psc3,	");
       query.append("     ped_solic_cabec psc4, ");       
       query.append("     PED_TIPO_SOLIC_PAIS TSP ");
       // Agregado por Cambio FAC-001 ------ AL        
       query.append("     , MAE_CLIEN_DATOS_ADICI DAT ");       
       // Agregado por Cambio FAC-001 ------ AL 
       query.append(" WHERE DCC.OID_CABE = DCL.DCCA_OID_CABE  ");
       query.append("  AND (DCC.IND_IMPR <> 1 OR DCC.IND_IMPR IS NULL)  ");
       query.append("  AND DCC.SOCA_OID_SOLI_CABE = " + entrada.getOidCabeceraSolicitud());         
       query.append("  AND DCC.PERD_OID_PERI = PERIO1.OID_PERI ");  
       query.append("  AND TERRI2.OID_TERR = MCD.TERR_OID_TERR ");
       query.append("  AND MCD.OID_CLIE_DIRE = DCC.CLDI_OID_CLIE_DIRE  ");
       query.append("  AND SOCIE.OID_SOCI = DCC.SOCI_OID_SOCI  ");
       query.append("  AND TERRI1.OID_TERR = DCC.TERR_OID_TERR  ");
       query.append("  AND ZON.OID_ZONA = DCC.ZZON_OID_ZONA  ");
       query.append("  AND MC.OID_CLIE = " + entrada.getReceptorFactura());       
       query.append("  AND COMUNI.CLIE_OID_CLIE(+) = MC.OID_CLIE  ");
       query.append("  AND TCOM.OID_TIPO_COMU(+) = COMUNI.TICM_OID_TIPO_COMU  ");
       query.append("  AND COMUNI.IND_COMU_PPAL(+) = 1 ");
       query.append("  AND MP.OID_PROD = DCL.PROD_OID_PROD ");  
       query.append("  AND FORMU.OID_FORM = DCC.FORS_OID_FORM "); 
       query.append("  AND DCC.PERD_OID_PERI = PERIO1.OID_PERI  ");
       query.append("  AND CORPO1.OID_PERI = PERIO1.PERI_OID_PERI  ");
       query.append("  AND PSP.NUM_UNID_ATEN <> 0 ");
       query.append("  AND PSP.OID_SOLI_POSI = DCL.SOPO_OID_SOLI_POSI  ");
       query.append("  AND MONE.OID_MONE(+) = DCC.MONE_OID_MONE ");
       query.append("  AND PSC1.OID_SOLI_CABE = DCC.SOCA_OID_SOLI_CABE ");
       query.append("  AND PSC1.TSPA_OID_TIPO_SOLI_PAIS = TSP.OID_TIPO_SOLI_PAIS ");
       query.append("  AND psp.soca_oid_soli_cabe = psc3.oid_soli_cabe ");
       query.append("  AND psc3.soca_oid_docu_refe = psc4.oid_soli_cabe(+) ");
       // Agregado por Cambio FAC-001 ------ AL 
       query.append("  AND DAT.CLIE_OID_CLIE = MC.OID_CLIE ");             
       // Agregado por Cambio FAC-001 ------ AL 
       query.append(" ORDER BY DCC.OID_CABE, ");
       query.append("          DCL.NUM_LINEA   ");*/

       RecordSet rs = new RecordSet();
        try {
            //sapaza -- cambio Optimizacion Querys GP5 -- 21/03/2011
            Vector params = new Vector();
            params.add(entrada.getReceptorFactura()); //oidReceptor
            params.add(entrada.getOidCabeceraSolicitud()); //oidSolicitud
            params.add(idiomaPorDefecto); //oidIdioma
            rs = UtilidadesBD.executeProcedureCursor("FAC_PKG_PROCE.FAC_PR_OBTIE_DOCUM_CONTA", params);
            //rs = getBelcorpService().dbService.executeStaticQuery(query.toString());
        } catch (MareException me) {
            throw me;
        } catch (Exception e) {
            throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS));
        }

        UtilidadesLog.info("DAODocuContable.obtenerDatosDocumentos(DTOFACCabeceraSolicitud entrada): Salida"); 
        return rs;
    }

    /**
     * Modificado por la BELC300011750
     * Modificado por HRCS - Fecha 19/06/2007 - Cambio Sicc2007296
     * @throws es.indra.mare.common.exception.MareException
     * @return RecordSet
     * @param mostrarVencimientos
     * @param entrada
     */
    public RecordSet obtenerDatosCCC(DTOFACCabeceraSolicitud entrada, boolean mostrarVencimientos)
        throws MareException {
        StringBuffer query = new StringBuffer();

        UtilidadesLog.info("DAODocuContable.obtenerDatosCCC(DTOFACCabeceraSolicitud entrada): Entrada"); 
        
        query.append(" SELECT A.FEC_MOVI, C.VAL_INDI_CONS, ");
        query.append(" F.FEC_VENC FECHAVENC, CLI.FEC_ULTI_GENE_CUPO ULTICUPO, ");
        query.append(" E.VAL_NOMB_PERI, F.NUM_IDEN_CUOT, H.COD_PROC, A.IMP as IMP_PAGA, F.VAL_EJER_CUOT as VAL_EJER_CUOT, ");
        query.append(" (SELECT idio.VAL_I18N FROM V_GEN_I18N_SICC idio ");
        query.append(" WHERE idio.ATTR_ENTI = 'CCC_TIPO_CARGO_ABONO' ");
        
        Long idiomaPorDefecto = entrada.getOidIdioma();
        if (idiomaPorDefecto == null){
            idiomaPorDefecto= RecuperadorIdiomaDefectoServidor.getIdiomaDefectoServidor(); 
        }
        query.append(" AND idio.IDIO_OID_IDIO = "+idiomaPorDefecto);
        
        query.append(" AND idio.VAL_OID = B.TCAB_OID_TCAB) AS DES_TIPO_CARGO_ABONO ");
        query.append(" , f.soca_oid_soli_cabe CONSOLIDADO ");
        //  Agregado por HRCS - Fecha 10/07/2007 - Cambio Sicc20070318
		query.append(" , a.fec_pago_banc ");
		query.append(" , g.fec_valo ");
		query.append(" , g.fec_docu ");
        //  Agregado por HRCS - Fecha 07/08/2007 - Cambio Sicc20070357
		query.append(" , CASE ");
		query.append("    WHEN (a.fec_pago_banc is not null) THEN a.fec_pago_banc ");
		query.append("    WHEN (a.fec_movi is not null) THEN a.fec_movi ");
		query.append("    WHEN (g.fec_valo is not null) THEN g.fec_valo ");
		query.append("    ELSE g.fec_docu ");
		query.append("  END fecha_operacion	");
        query.append("FROM CCC_DETAL_CARGO_ABONO_DIREC A,  ");
        query.append("CCC_TIPO_ABONO_SUBPR B,  ");
        query.append("CCC_SUBPR C,  ");
        query.append("CRA_PERIO E,  ");
        query.append("CCC_MOVIM_CUENT_CORRI F, ");
        query.append("CCC_PROCE H, ");
        query.append("MAE_CLIEN CLI ");
        //  Agregado por HRCS - Fecha 10/07/2007 - Cambio Sicc20070318
		query.append(" , ccc_cabec_carga_abono_direc g ");
        // Modificado por la BELC300011750
        query.append("WHERE A.TASP_OID_TIPO_ABON_SUBP=B.OID_TIPO_ABON_SUBP ");
        if (mostrarVencimientos){
            query.append(" AND ((A.FEC_CREA >= CLI.FEC_ULTI_GENE_CUPO) or ( F.FEC_VENC > SYSDATE)) ");
        }else{
            query.append(" AND (A.FEC_CREA >= CLI.FEC_ULTI_GENE_CUPO) ");
        }
        query.append(" AND CLI.OID_CLIE = "+entrada.getOidCliente());
        query.append(" AND A.CLIE_OID_CLIE = CLI.OID_CLIE ");
        query.append(" AND a.fec_movi <= e.fec_fina ");
        query.append(" AND B.SUBP_OID_SUBP=C.OID_SUBP ");
        query.append(" AND C.val_indi_cons <> 'N' ");
        query.append(" AND E.OID_PERI="+entrada.getPeriodo());
        query.append(" AND A.MVCC_OID_MOVI_CC = F.OID_MOVI_CC(+) ");
        query.append(" AND H.OID_PROC=C.CCPR_OID_PROC ");
        //  Agregado por HRCS - Fecha 10/07/2007 - Cambio Sicc20070318
        query.append(" AND a.ccad_oid_cabe_carg = g.oid_cabe_carg ");
        //añadido por incidencia 19552
        //query.append(" ORDER BY F.FEC_VENC NULLS FIRST, A.FEC_MOVI ");
        //  Modificado por HRCS - Fecha 07/08/2007 - Cambio Sicc20070357
        query.append(" ORDER BY fecha_operacion ");

        RecordSet rs = new RecordSet();

        try {
            rs = getBelcorpService().dbService.executeStaticQuery(query.toString());
        } catch (MareException me) {
            throw me;
        } catch (Exception e) {
            throw new MareException(e,
                UtilidadesError.armarCodigoError(
                    CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS));
        }

        UtilidadesLog.info("DAODocuContable.obtenerDatosCCC(DTOFACCabeceraSolicitud entrada): Salida"); 

        return rs;
    }
    
    public void actualizarFechaGeneracionCuponCliente (java.util.Date fecha, Long oidCliente) throws Exception{
        StringBuffer query = new StringBuffer("UPDATE MAE_CLIEN SET FEC_ULTI_GENE_CUPO = SYSDATE");
        query.append(" WHERE OID_CLIE = "+oidCliente);
        try{
            getBelcorpService().dbService.executeUpdate(query.toString());
        } catch (MareException me) {
            throw me;
        } catch (Exception e) {
            UtilidadesLog.error("ERROR",e);
            throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS));
        }      
    }

    public String obtenerIdentificacionFiscal(Long oidLine)
        throws MareException {
        UtilidadesLog.info("DAODocuContable.obtenerIdentificacionFiscal(Long oidLine): Entrada"); 
        
        StringBuffer query = new StringBuffer();

        query.append("SELECT A.VAL_IDEN_FISC");
        query.append("FROM SEG_SOCIE A, FAC_DOCUM_CONTA_CABEC B");
        query.append(
            "WHERE A.OID_SOCI=B.SOCI_OID_SOCI AND A.PAIS_OID_PAIS=B.PAIS_OID_PAIS ");
        query.append("AND B.SOCA_OID_SOLI_CABE=" + oidLine.longValue() + " ");

        RecordSet rs = new RecordSet();

        try {
            rs = getBelcorpService().dbService.executeStaticQuery(query.toString());
        } catch (MareException me) {
            throw me;
        } catch (Exception e) {
            throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS));
        }

        UtilidadesLog.info("DAODocuContable.obtenerIdentificacionFiscal(Long oidLine): Salida"); 

        return (String) rs.getValueAt(0, 0);
    }

    public String obtenerDescripcionUBIGEO(Long oidUbigeo) throws MareException {
        UtilidadesLog.info("DAODocuContable.obtenerDescripcionUBIGEO(Long oidUbigeo): Entrada"); 
        
        StringBuffer query = new StringBuffer();

        query.append(" SELECT ");
		query.append("  (select des_geog from zon_valor_estru_geopo ");
        query.append("   where pais_oid_pais = ubigeo.pais_oid_pais and orde_1 = ubigeo.orde_1 and orde_2 is null) des_geog, ");
		query.append("  (select des_geog from zon_valor_estru_geopo ");
        query.append("   where pais_oid_pais = ubigeo.pais_oid_pais and orde_1 = ubigeo.orde_1 and orde_2 = ubigeo.orde_2 and orde_3 is null) des_geog_1, ");
		query.append("  (select des_geog from zon_valor_estru_geopo ");
        query.append("   where pais_oid_pais = ubigeo.pais_oid_pais and orde_1 = ubigeo.orde_1 and orde_2 = ubigeo.orde_2 and orde_3 = ubigeo.orde_3 and orde_4 is null) des_geog_2, ");
		query.append("  (select des_geog from zon_valor_estru_geopo ");
        query.append("   where pais_oid_pais = ubigeo.pais_oid_pais and orde_1 = ubigeo.orde_1 and orde_2 = ubigeo.orde_2 and orde_3 = ubigeo.orde_3 and orde_4 = ubigeo.orde_4 and orde_5 is null) des_geog_3 ");
		query.append(" FROM ");
		query.append(" (SELECT zn.orde_1, zn.orde_2, zn.orde_3, zn.orde_4, zn.pais_oid_pais ");
		query.append("  FROM zon_valor_estru_geopo zn ");
		query.append("  WHERE zn.oid_valo_estr_geop=" + oidUbigeo.longValue() + ") ubigeo ");
        RecordSet rs = new RecordSet();

        try {
            rs = getBelcorpService().dbService.executeStaticQuery(query.toString());
        } catch (MareException me) {
            throw me;
        } catch (Exception e) {
            throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS));
        }

        String descripcion = "";

        if(!rs.esVacio()){
            if ((rs.getValueAt(0, 0) != null) && (rs.getValueAt(0, 1) != null) && (rs.getValueAt(0, 2) != null) &&
                    (rs.getValueAt(0, 3) != null)) {
                descripcion = (String) rs.getValueAt(0, 3) + "/" +
                    (String) rs.getValueAt(0, 2) + "/" +
                    (String) rs.getValueAt(0, 1)+ "/" +
                    (String) rs.getValueAt(0, 0);
            }
            else if ((rs.getValueAt(0, 0) != null) && (rs.getValueAt(0, 1) != null) && (rs.getValueAt(0, 2) != null) &&
                    (rs.getValueAt(0, 3) == null)) {
                descripcion = (String) rs.getValueAt(0, 2) + "/" +
                    (String) rs.getValueAt(0, 1)+ "/" +
                    (String) rs.getValueAt(0, 0);
            }
            else if ((rs.getValueAt(0, 0) != null) && (rs.getValueAt(0, 1) != null) && (rs.getValueAt(0, 2) == null) &&
                    (rs.getValueAt(0, 3) == null)) {
                descripcion = (String) rs.getValueAt(0, 1)+ "/" +
                    (String) rs.getValueAt(0, 0);
            }
            else if ((rs.getValueAt(0, 0) != null) && (rs.getValueAt(0, 1) == null) && (rs.getValueAt(0, 2) == null) &&
                    (rs.getValueAt(0, 3) == null)) {
                descripcion = (String) rs.getValueAt(0, 0);
            }
        }

        UtilidadesLog.info("DAODocuContable.obtenerDescripcionUBIGEO(Long oidUbigeo): Salida"); 

        return descripcion;
    }

  /**
   * CHANGELOG
   * ---------
   * dmorello, 23/06/2009 - Cambio 20090900
   *   - Se recupera el campo SEG_PARAM_INTER_PAIS.IND_IMPR_PROD_FUER_CAJA_BOLS
   */
  public RecordSet obtenerDatosDocumentosNoLegales(DTOFACCabeceraSolicitud entrada) throws MareException {

        UtilidadesLog.info("DAODocuContable.obtenerDatosDocumentosNoLegales(DTOFACCabeceraSolicitud entrada): Entrada"); 
        
        /*StringBuffer query = new StringBuffer();
        Vector parametros = new Vector();
  
        query.append(" SELECT C.NUM_PPAL, C.VAL_NOMB_VIA, D.DES_ABRV_TIPO_VIA, "); 
        query.append(" E.COD_ZONA,I.COD_SECC, J.COD_TERR , F.VAL_APE1, ");
        query.append(" F.VAL_APE2, F.VAL_NOM1, F.VAL_NOM2, G.VAL_NOMB_PERI, ");
        query.append(" H.VAL_TEXT_COMU, R.COD_REGI, S.COD_PERI,P.NUM_UNID_ATEN_TOTA, ");
        query.append(" F.COD_CLIE, G.OID_PERI, E.OID_ZONA ");
        query.append(",PIP.IND_IMPR_PROD_FUER_CAJA_BOLS ");
        query.append(" FROM MAE_CLIEN_DIREC C, SEG_TIPO_VIA D, ZON_ZONA E,");
        query.append(" MAE_CLIEN F,CRA_PERIO G, MAE_CLIEN_COMUN H,  ");
        query.append(" ZON_SECCI I, ZON_TERRI J, ZON_REGIO R,  ");
        query.append(" SEG_PERIO_CORPO S, PED_SOLIC_CABEC P ");
        query.append(",SEG_PARAM_INTER_PAIS PIP ");
        query.append(" WHERE  C.OID_CLIE_DIRE = P.CLDI_OID_CLIE_DIRE(+)");
        query.append(" AND P.OID_SOLI_CABE= ? ");
        parametros.add(entrada.getOidCabeceraSolicitud());
        query.append(" AND C.TIVI_OID_TIPO_VIA= D.OID_TIPO_VIA  ");
        query.append(" AND E.OID_ZONA= ? ");
        parametros.add(entrada.getZona());
        query.append(" AND F.OID_CLIE= ?  ");
        parametros.add(entrada.getReceptorFactura());
        query.append(" AND G.OID_PERI= ? ");
        parametros.add(entrada.getPeriodo());
        query.append(" AND H.CLIE_OID_CLIE (+) = F.OID_CLIE ");
        query.append(" AND H.TICM_OID_TIPO_COMU (+) = ? ");
        parametros.add(ConstantesMAE.TIPO_COMUNICACION_TFNO);
        query.append(" AND I.OID_SECC= ? ");
        parametros.add(entrada.getSeccion());
        query.append(" AND J.OID_TERR= ? ");
        parametros.add(entrada.getTerritorio());
        query.append(" AND R.OID_REGI= ? ");
        parametros.add(entrada.getRegion());
        query.append(" AND s.OID_PERI = g.PERI_OID_PERI ");
        query.append(" AND P.PAIS_OID_PAIS = PIP.PAIS_OID_PAIS (+)");*/

        RecordSet rs = new RecordSet();

        try {
            //sapaza -- cambio Optimizacion Querys GP5 -- 21/03/2011
            Vector params = new Vector();
            params.add(entrada.getOidCabeceraSolicitud());
            params.add(entrada.getReceptorFactura());
            params.add(entrada.getPeriodo()); 
            params.add(entrada.getRegion());            
            params.add(entrada.getZona());             
            params.add(entrada.getSeccion());
            params.add(entrada.getTerritorio()); 

            rs = UtilidadesBD.executeProcedureCursor("FAC_PKG_PROCE.FAC_PR_OBTIE_DOCUM_NOLEG", params);
            //rs = getBelcorpService().dbService.executePreparedQuery(query.toString(),parametros);
        } catch (MareException me) {
            throw me;
        } catch (Exception e) {
            throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS));
        }

        UtilidadesLog.info("DAODocuContable.obtenerDatosDocumentosNoLegales(DTOFACCabeceraSolicitud entrada): Salida");

        return rs;
    }

    public RecordSet obteneDatosDocumentoLegal(Long idDocumentoLegal) throws MareException {
        UtilidadesLog.info("DAODocuContable.obteneDatosDocumentoLegal(Long idDocumentoLegal): Entrada");
        
        StringBuffer query = new StringBuffer();

        query.append(" SELECT A.*, B.*, F.NUM_PPAL, F.IND_DIRE_PPAL, F.VAL_NOMB_VIA, G.DES_ABRV_TIPO_VIA, C.VAL_NOMB_PERI ");
        query.append(" ,I.VAL_IDEN_FISC, J.COD_TERR, K.COD_ZONA, M.VAL_TEXT_COMU, O.COD_SAP, P.VAL_RUTI_DISE_FORM  ");
        query.append(" ,Q.COD_PERI, R.VAL_NOMB_CORT_MONE, O.DES_CORT, S.VAL_CODI_VENT, N.COD_TIPO_COMU   ");
        query.append(" FROM FAC_DOCUM_CONTA_CABEC A,  ");
        query.append(" FAC_DOCUM_CONTA_LINEA B,  ");
        query.append(" CRA_PERIO C,  ");
        query.append(" MAE_CLIEN_DIREC F, ");
        query.append(" SEG_TIPO_VIA G,  ");
        query.append(" SEG_SOCIE I,  ");
        query.append(" ZON_TERRI J,  ");
        query.append(" ZON_ZONA K,  ");
        query.append(" MAE_CLIEN_COMUN M,  ");
        query.append(" MAE_TIPO_COMUN N, ");
        query.append(" MAE_PRODU O,  ");
        query.append(" FAC_FORMU P,  ");
        query.append(" SEG_PERIO_CORPO Q, ");
        query.append(" SEG_MONED R,  ");
        query.append(" PED_SOLIC_POSIC S,  ");
        query.append(" PED_SOLIC_CABEC T ");
		query.append(" WHERE A.OID_CABE="+idDocumentoLegal);
        query.append(" AND A.OID_CABE = B.DCCA_OID_CABE  ");
        query.append(" AND A.SOCA_OID_SOLI_CABE= T.OID_SOLI_CABE ");
        query.append(" AND F.OID_CLIE_DIRE = A.CLDI_OID_CLIE_DIRE  ");
        query.append(" AND F.TIVI_OID_TIPO_VIA=G.OID_TIPO_VIA  ");
        query.append(" AND A.PERD_OID_PERI= C.OID_PERI ");
        query.append(" AND I.OID_SOCI=A.SOCI_OID_SOCI  ");
        query.append(" AND J.OID_TERR=A.TERR_OID_TERR  ");
        query.append(" AND K.OID_ZONA=A.ZZON_OID_ZONA  ");
        query.append(" and S.NUM_UNID_ATEN <> 0 ");
        query.append(" AND M.CLIE_OID_CLIE=T.CLIE_OID_CLIE  ");
        query.append(" AND N.OID_TIPO_COMU= M.TICM_OID_TIPO_COMU  ");
        query.append(" AND O.OID_PROD=B.PROD_OID_PROD  ");
        query.append(" AND P.OID_FORM=A.FORS_OID_FORM  ");
        query.append(" AND M.IND_COMU_PPAL(+) = 1  ");
        query.append(" AND Q.OID_PERI=C.OID_PERI  ");
        query.append(" AND R.OID_MONE=A.MONE_OID_MONE  ");
        query.append(" AND S.OID_SOLI_POSI=B.SOPO_OID_SOLI_POSI  ");

        query.append(" ORDER BY A.OID_CABE, B.NUM_LINEA ");

        RecordSet rs = new RecordSet();

        try {
            rs = getBelcorpService().dbService.executeStaticQuery(query.toString());
        } catch (MareException me) {
            throw me;
        } catch (Exception e) {
            throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS));
        }

        UtilidadesLog.info("DAODocuContable.obteneDatosDocumentoLegal(Long idDocumentoLegal): Salida");

        return rs;
    }

    public void marcarComoImpresos(Long oidCabSolicitud) throws MareException {
        
        UtilidadesLog.info("DAODocuContable.marcarComoImpresos(Long oidCabSolicitud): Entrada");
        
        StringBuffer query = new StringBuffer();

        query.append(" UPDATE FAC_DOCUM_CONTA_CABEC A ");
        query.append(" SET A.IND_IMPR=1 ");
        query.append(" WHERE A.SOCA_OID_SOLI_CABE=" + oidCabSolicitud.longValue());
        query.append(" AND A.IND_IMPR<>1 ");

        try {
            getBelcorpService().dbService.executePreparedUpdate(query.toString(),
                new Vector());
        } catch (MareException me) {
            throw me;
        } catch (Exception e) {
            throw new MareException(e,
                UtilidadesError.armarCodigoError(
                    CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS));
        }
        UtilidadesLog.info("DAODocuContable.marcarComoImpresos(Long oidCabSolicitud): Salida");
        
    }
    
    public RecordSet obtenerOidUbigeoClienteReceptor (Long oidClienteReceptor, Long oidConsolidado) throws MareException
    {
        UtilidadesLog.info("***DAODocuContable.obtenerOidUbigeoClienteReceptor (Long oidClienteReceptor, Long oidConsolidado) Entrada");
        
        StringBuffer query = new StringBuffer();
        Vector parametros = new Vector();
        query.append(" SELECT T.VEPO_OID_VALO_ESTR_GEOP ");
        query.append(" FROM ");
        query.append(" MAE_CLIEN_DIREC C, ZON_TERRI T, ");
        query.append(" PED_SOLIC_CABEC P ");
        query.append(" WHERE ");
        query.append(" P.CLIE_OID_CLIE_RECE_FACT=C.CLIE_OID_CLIE ");
        query.append(" AND C.IND_ELIM = 0 "); //agregado por Sapaza, incidencia V_MAE_08
        query.append(" AND T.OID_TERR = C.TERR_OID_TERR ");
        query.append(" AND P.CLIE_OID_CLIE_RECE_FACT = ? ");
        parametros.add(oidClienteReceptor);
        query.append(" AND P.OID_SOLI_CABE = ? ");
        parametros.add(oidConsolidado);

        RecordSet rs = new RecordSet();

        try {
            rs = getBelcorpService().dbService.executePreparedQuery(query.toString(),parametros);
        } catch (MareException me) {
            throw me;
        } catch (Exception e) {
            throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS));
        }

        UtilidadesLog.info("***DAODocuContable.obteneDatosDocumentoLegal (Long oidClienteReceptor, Long oidConsolidado) Salida");

        return rs;
    }
    
    //añadido por incidencia 21179 y modificado por 21774
    public RecordSet obtenerCodigosUnidadesAdministrativas(Long oidTerritorioAdministrativo) throws MareException 
    {
        UtilidadesLog.info("***DAODocuContable.obtenerCodigosUnidadesAdministrativas (Long oidTerritorioAdministrativo) Entrada");
        StringBuffer query = new StringBuffer();
        Vector parametros = new Vector();
        query.append(" SELECT reg.COD_REGI COD_REGION, zon.COD_ZONA COD_ZONA, ");
        query.append(" sec.COD_SECC COD_SECCION, ter.COD_TERR COD_TERRITORIO ");
        query.append(" FROM ZON_TERRI_ADMIN tad, ZON_TERRI ter, ");
        query.append(" ZON_ZONA zon, ZON_REGIO reg, ZON_SECCI sec ");
        query.append(" WHERE tad.OID_TERR_ADMI = ? ");
        parametros.add(oidTerritorioAdministrativo);
        query.append(" AND tad.TERR_OID_TERR = ter.OID_TERR ");
        query.append(" AND tad.ZSCC_OID_SECC = sec.OID_SECC ");
        query.append(" AND sec.ZZON_OID_ZONA = zon.OID_ZONA ");
        query.append(" AND zon.ZORG_OID_REGI = reg.OID_REGI ");
        
        RecordSet rs = new RecordSet();
        
        try {
            rs = getBelcorpService().dbService.executePreparedQuery(query.toString(),parametros);
        } catch (MareException me) {
            throw me;
        } catch (Exception e) {
            throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS));
        }
        
        UtilidadesLog.info("***DAODocuContable.obtenerCodigosUnidadesAdministrativas (Long oidTerritorioAdministrativo) Salida");
        return rs;
    }

    private BelcorpService getBelcorpService() {
        UtilidadesLog.info("DAODocuContable.getBelcorpService(): Entrada");    
        try {
            UtilidadesLog.info("DAODocuContable.getBelcorpService(): Salida"); 
            return BelcorpService.getInstance();
        } catch (MareMiiServiceNotFoundException mmsnfe) {
            throw new EJBException("MareMiiServiceNotFoundException: " + mmsnfe.getMessage(), mmsnfe);
        }
    }

    private void logError(String mensaje, Throwable e) {
        UtilidadesLog.error("*** Error Metodo " + mensaje + ": " + e.getMessage());
        this.logStackTrace(e);
    }

    private void logSql(String metodo, String sql, Vector params) {
        UtilidadesLog.info("DAODocuContable.logSql(String metodo, String sql, Vector params): Entrada");    
        UtilidadesLog.debug(metodo + sql);

        if ((params != null) && (params.size() > 0)) {
            String sParams = "";

            for (int i = 0; i < params.size(); i++) {
                sParams += ("param " + (i + 1) + ": " + params.elementAt(i) +
                ", ");
            }

            UtilidadesLog.debug(metodo + sParams);
        }
        UtilidadesLog.info("DAODocuContable.logSql(String metodo, String sql, Vector params): Salida");    
    }

    private void logStackTrace(Throwable e) {
        try {
            UtilidadesLog.error("ERROR",e);
        } catch (Exception ex) {
            UtilidadesLog.error("Traza de la pila: " + ex.getMessage());
        }
    }

    /**
     * Obtiene la tasa de percepcion que debe imprimirse en Boleta de Venta y
     * Factura 1. Construido por cambio SICC-GCC-FAC-002.
     * @throws es.indra.mare.common.exception.MareException
     * @return Tasa de percepcion
     * @param  pais
     * @author dmorello
     * @date   17/10/2006
     */
    public Float obtenerImpuestoPercepcion(Long pais) throws MareException {
        UtilidadesLog.info("DAODocuContable.obtenerImpuestoPercepcion(Long pais): Entrada");
        
        RecordSet rs = null;
        BelcorpService bs = UtilidadesEJB.getBelcorpService();
        
        StringBuffer query = new StringBuffer();
        query.append(" SELECT VAL_TASA_IMPU ");
        query.append(" FROM PED_TASA_IMPUE ");
        query.append(" WHERE VAL_INDI_IMPU = '" + ConstantesPED.INDICADOR_IMPUESTO_PERCEPCION + '\'');
        query.append(" AND PAIS_OID_PAIS =  " + pais);
        
        try {
            rs = bs.dbService.executeStaticQuery(query.toString());
        } catch (Exception e) {
            throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS));
        }
        
        UtilidadesLog.debug("rs: " + rs);
        
        UtilidadesLog.info("DAODocuContable.obtenerImpuestoPercepcion(Long pais): Salida");
        if (rs.esVacio()) {
            return new Float(0);
        } else {
            // Habiendo filtrado por UK (pais, indicador) hay solo un elemento.
            return new Float(rs.getValueAt(0,0).toString());
        }
    }

    /**
     * Devuelve TRUE si, para el formulario que recibe en los parametros,
     * corresponde imprimir la percepcion y el nuevo total del documento
     * @param pais
     * @param rutina
     * @author dmorello
     * @date   18/10/2006
     */
    public Boolean verificarImpresionPercepcion(String rutina, Long pais) throws MareException {
        UtilidadesLog.info("DAODocuContable.verificarImpresionPercepcion(String rutina, Long pais): Entrada");
        
        RecordSet rs = null;
        BelcorpService bs = UtilidadesEJB.getBelcorpService();

        StringBuffer query = new StringBuffer();
        
        query.append(" SELECT count(1) ");
        query.append(" FROM fac_formu_perce fp, fac_formu formu ");
        query.append(" WHERE fp.pais_oid_pais = ").append(pais);
        query.append("   AND fp.fors_oid_form = formu.oid_form ");
        query.append("   AND fp.val_ruti_prog_ejec = '").append(rutina).append('\'');
        query.append("   AND formu.val_ruti_dise_form = '").append(rutina).append('\'');
        
        try {
            rs = bs.dbService.executeStaticQuery(query.toString());
        } catch (Exception e) {
            throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS));
        }
        
        UtilidadesLog.debug("rs: " + rs);
        
        boolean imprimirPercepcion = ! rs.getValueAt(0,0).toString().equals("0");
        UtilidadesLog.debug("imprimirPercepcion: " + imprimirPercepcion);
        
        UtilidadesLog.info("DAODocuContable.verificarImpresionPercepcion(String rutina, Long pais): Entrada");
        return new Boolean(imprimirPercepcion);
    }

/* Creado por incidencia V_FAC_25 alorenzo 26/01/2007*/
   public Boolean verificarImpresionPercepcion(Long oidFormulario, Long pais) throws MareException {
        UtilidadesLog.info("DAODocuContable.verificarImpresionPercepcion(String rutina, Long pais): Entrada");
        
        RecordSet rs = null;
        BelcorpService bs = UtilidadesEJB.getBelcorpService();

        StringBuffer query = new StringBuffer();
        
        query.append(" SELECT count(*) ");
        query.append(" FROM fac_formu_perce fp, fac_formu formu ");
        query.append(" WHERE fp.pais_oid_pais = ").append(pais);
        query.append("   AND fp.fors_oid_form = formu.oid_form ");
        query.append("   AND formu.oid_form = ").append(oidFormulario);
        
        try {
            rs = bs.dbService.executeStaticQuery(query.toString());
        } catch (Exception e) {
            throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS));
        }
        
        UtilidadesLog.debug("rs: " + rs);
        
        boolean imprimirPercepcion = ! rs.getValueAt(0,0).toString().equals("0");
        UtilidadesLog.debug("imprimirPercepcion: " + imprimirPercepcion);
        
        UtilidadesLog.info("DAODocuContable.verificarImpresionPercepcion(String rutina, Long pais): Entrada");
        return new Boolean(imprimirPercepcion);
    }

   public HashMap recuperarDatosPremios(ArrayList arraySoliTipoC) throws MareException {
      StringBuffer query = new StringBuffer();
        
      query.append("SELECT PSC.OID_SOLI_CABE, ");
      query.append("       CPG.NUM_CONC, ");
      query.append("       CPG.VAL_NOMB, ");
      query.append("       CTP.IMP_TIPO_PROG, ");
      query.append("       ( ");
      query.append("  SELECT MCI.NUM_DOCU_IDEN ");
      query.append("  FROM MAE_CLIEN_IDENT MCI, ");
      query.append("       MAE_TIPO_DOCUM MTD ");
      query.append("  WHERE MCI.CLIE_OID_CLIE = PSC.CLIE_OID_CLIE ");
      query.append("    AND MCI.VAL_IDEN_DOCU_PRIN = 1 ");
      query.append("    AND MTD.OID_TIPO_DOCU = MCI.TDOC_OID_TIPO_DOCU ");
      query.append("    AND MTD.COD_TIPO_DOCU = '01' ");
      query.append(" ) NUM_DOCU ");
      query.append("FROM PED_SOLIC_CABEC PSC, ");
      query.append("     INC_CONCU_PARAM_GENER CPG, ");
      query.append("     INC_CONCU_TIPO_PROG CTP ");
      query.append("WHERE PSC.COPA_OID_PARA_GENE = CPG.OID_PARA_GRAL ");
      query.append("  AND PSC.ICTP_OID_TIPO_PROG = CTP.OID_TIPO_PROG ");
      query.append("  AND PSC.OID_SOLI_CABE IN (");
      
      int sizeArray = arraySoliTipoC.size();
      for (int i = 0; i < sizeArray; i++) {
        if (i == 0) {
          query.append(arraySoliTipoC.get(i));
        } else {
          query.append("," + arraySoliTipoC.get(i));
        }
      }
      query.append(")");
      
      RecordSet rs = null;
      
      HashMap hashDatosPremios = new HashMap();
      
      BelcorpService bs = UtilidadesEJB.getBelcorpService();
      try {
            rs = bs.dbService.executeStaticQuery(query.toString());
        } catch (Exception e) {
            throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS));
        }
    
      if (rs != null && !rs.esVacio()) {
        int sizeRS = rs.getRowCount();
        for (int i = 0; i < sizeRS; i++) {
          DTODatosProgramasIncentivos dtoDatos = new DTODatosProgramasIncentivos();
          dtoDatos.setNumeroConcurso(rs.getValueAt(i, "NUM_CONC")!=null?rs.getValueAt(i, "NUM_CONC").toString():"");
          dtoDatos.setNombreConcurso(rs.getValueAt(i, "VAL_NOMB")!=null?rs.getValueAt(i, "VAL_NOMB").toString():"");
          dtoDatos.setImporteTipoPrograma(this.bigDecimalToFloat(rs.getValueAt(i, "IMP_TIPO_PROG")));
          dtoDatos.setOidSolicitudCabecera(this.bigDecimalToLong(rs.getValueAt(i, "OID_SOLI_CABE")));
          dtoDatos.setDNI(rs.getValueAt(i, "NUM_DOCU")!=null?rs.getValueAt(i, "NUM_DOCU").toString():"");
          hashDatosPremios.put(dtoDatos.getOidSolicitudCabecera(), dtoDatos);
        }
      }
      return hashDatosPremios;
    }
    
    private Long bigDecimalToLong(Object numero) {
     if (numero != null) {
       return new Long(((BigDecimal) numero).longValue());
     } else {
       return null;
     }
  }

   private Float bigDecimalToFloat(Object numero) {
        if (numero != null) {
            return new Float(((BigDecimal) numero).floatValue());
        } else {
            return new Float(0);
        }
   }
   
     /* Agregado por Cambio FAC-001 ------ AL */
     public HashMap obtenerDatosCatalogo(ArrayList arrayCodigosVenta, Long oidSolicitudCabecera, Long oidIdioma) throws MareException {
        UtilidadesLog.info("DAODocuContable.obtenerDatosCatalogo(ArrayList arrayCodigosVenta, Long oidSolicitudCabecera, Long oidIdioma): Entrada");         
        StringBuffer query = new StringBuffer();     
       
        if (oidIdioma == null) {
            oidIdioma = RecuperadorIdiomaDefectoServidor.getIdiomaDefectoServidor(); 
        }
        
       query.append(" SELECT POD.VAL_CODI_VENT, ");
	   query.append("  	     CASE WHEN (POD.CNDP_OID_COND_PROM IS NULL OR PCP.COD_COND_PROM = '00') THEN ");
       query.append("		   '0-' || TO_CHAR(PC.COD_CATA) ");		
       query.append("		 ELSE");
	   query.append("          '1-' || PCP.COD_COND_PROM ");  
       query.append("		 END COD_AGRUP, ");
       query.append("		 CASE WHEN (POD.CNDP_OID_COND_PROM IS NULL OR PCP.COD_COND_PROM = '00') THEN ");
       query.append("		    TO_CHAR(PC.COD_CATA) ");		 
       query.append("		 ELSE ");
       query.append("			PCP.COD_COND_PROM ");
       query.append("		 END CODIGO,	");		 		    
       query.append("		 CASE WHEN (POD.CNDP_OID_COND_PROM IS NULL OR PCP.COD_COND_PROM = '00') THEN ");
       query.append("		    PC.DES_CATA ");
       query.append("		 ELSE ");
       query.append("		    PQ_APL_AUX.Valor_Gen_I18n_Sicc(" + oidIdioma + ", PCP.OID_COND_PROM, 'PRE_CONDI_PROMO')  ");
       query.append("		 END DESCRIP  ");  
       query.append(" FROM FAC_DOCUM_CONTA_CABEC DCC, ");
       query.append("  	   PRE_OFERT_DETAL POD, ");
       query.append("	   PRE_OFERT PO, ");
       query.append("	   PRE_MATRI_FACTU_CABEC PMFC, ");
       query.append("	   PRE_CATAL PC, ");
       query.append("	   PRE_CONDI_PROMO PCP  ");
       query.append(" WHERE PMFC.PERD_OID_PERI = DCC.PERD_OID_PERI ");
       query.append("   AND PO.MFCA_OID_CABE = PMFC.OID_CABE ");
       query.append("   AND PO.OID_OFER = POD.OFER_OID_OFER ");
       query.append("   AND POD.OCAT_OID_CATAL = PC.OID_CATA ");
       query.append("   AND POD.CNDP_OID_COND_PROM = PCP.OID_COND_PROM(+) ");
       query.append("   AND DCC.SOCA_OID_SOLI_CABE = " + oidSolicitudCabecera );       
       query.append(this.generarFiltroCodigosVenta(arrayCodigosVenta).toString());
				 
       RecordSet rs = null;       
       rs = UtilidadesBD.executeQuery(query.toString());

       UtilidadesLog.info("DAODocuContable.obtenerDatosCatalogo(ArrayList arrayCodigosVenta, Long oidSolicitudCabecera, Long oidIdioma): Salida"); 
       return this.generarHashXCodigosVenta(rs);
    }

 
    private StringBuffer generarFiltroCodigosVenta(ArrayList arrayCodigosVenta) {
      StringBuffer query = new StringBuffer();
      Iterator it = arrayCodigosVenta.iterator();
      int count = 0;
      String codigosVenta = "";        

      query.append("  AND (");
      while (it.hasNext()) {
        if (count == 0) {
          codigosVenta = "'" + it.next().toString() + "'";
        } else { 
          codigosVenta += ",'" + it.next().toString() + "'";
        }
        if (count == 999)  {
           query.append(" POD.VAL_CODI_VENT IN (" + codigosVenta.toString() + ") ");                     
           if (it.hasNext()){
              query.append("  OR ");
           }                    
           count = 0;
           codigosVenta = "";
        } else {
           if (!it.hasNext()){
              query.append(" POD.VAL_CODI_VENT IN (" + codigosVenta.toString() + ") ");        
           }                    
           count++;            
        } 
        if (!it.hasNext()){              
          query.append(")");
        }
      }
      return query;
    } 
    
    private HashMap generarHashXCodigosVenta(RecordSet rs) {
      HashMap hashCatalogos = new HashMap();
      DTOAgrupaCatalogos dtoCata;
      if (rs != null && !rs.esVacio()) {
        int rsSize = rs.getRowCount();
        for (int i = 0; i < rsSize; i++) {
          dtoCata = new DTOAgrupaCatalogos();
          dtoCata.setCodigoAgrupacion(UtilidadesBD.convertirAString(rs.getValueAt(i, "COD_AGRUP")));
          dtoCata.setCodigo(UtilidadesBD.convertirAString(rs.getValueAt(i, "CODIGO")));
          dtoCata.setDescripcion(UtilidadesBD.convertirAString(rs.getValueAt(i, "DESCRIP")));
          hashCatalogos.put(UtilidadesBD.convertirAString(rs.getValueAt(i, "VAL_CODI_VENT")), dtoCata);
        }
      }
      return hashCatalogos;
    }  
    
     public Float obtenerAbonosSPV(Long oidCliente, Long oidPeriodo) throws MareException {
       UtilidadesLog.info("DAODocuContable.obtenerAbonosSPV(Long oidCliente, Long oidPeriodo): Entrada"); 
       StringBuffer query = new StringBuffer();     
               
       query.append(" SELECT NVL(SUM(IMP_MOVI), 0) ABONOSPV ");
       query.append(" FROM CCC_MOVIM_CUENT_CORRI MCC, ");
       query.append("      CCC_SUBPR CS, ");
	   query.append("      CCC_PROCE CP ");
       query.append(" WHERE CP.COD_PROC = 'CCC001' ");
       query.append("   AND CP.OID_PROC = CS.CCPR_OID_PROC ");
       query.append("   AND MCC.SUBP_OID_SUBP_CREA = CS.OID_SUBP ");
       query.append("   AND MCC.IMP_MOVI < 0 "); 
       query.append("   AND MCC.CLIE_OID_CLIE = " + oidCliente);
       query.append("   AND MCC.PERD_OID_PERI = " + oidPeriodo);
  
       RecordSet rs = null;
       rs = UtilidadesBD.executeQuery(query.toString());

       UtilidadesLog.info("DAODocuContable.obtenerAbonosSPV(Long oidCliente, Long oidPeriodo): Salida"); 
       return this.asignarAbonoSPV(rs);
    }
    
    private Float asignarAbonoSPV(RecordSet rs) {
      Float abonoSPV = new Float(0);      
      if (rs != null && !rs.esVacio()) {
          abonoSPV = UtilidadesBD.convertirAFloat(rs.getValueAt(0, "ABONOSPV"));        
      }
      return abonoSPV;
    }  

    public Date obtenerFechaVencimiento (Long oidSolicitud) throws MareException {
       UtilidadesLog.info("DAODocuContable.obtenerFechaVencimiento(Long oidSolicitud): Entrada"); 
       StringBuffer query = new StringBuffer();     
               
       query.append(" SELECT MIN(MCC.FEC_VENC) FEC_VENC ");
	   query.append(" FROM CCC_MOVIM_CUENT_CORRI MCC ");
	   query.append(" WHERE MCC.SOCA_OID_SOLI_CABE = " + oidSolicitud);
  
       RecordSet rs = null;
       rs = UtilidadesBD.executeQuery(query.toString());

       UtilidadesLog.info("DAODocuContable.obtenerFechaVencimiento(Long oidSolicitud): Salida"); 
       return this.asignarFechaVencimiento(rs);
    }
    
    private Date asignarFechaVencimiento(RecordSet rs) {
      Date fechaVencimiento = null;      
      if (rs != null && !rs.esVacio()) {
          if (rs.getValueAt(0, "FEC_VENC") != null) {
            fechaVencimiento = (Date)rs.getValueAt(0, "FEC_VENC");
          }         
      }
      return fechaVencimiento;
    }  


    /**
     * CHANGELOG
     * ---------
     * 21/08/2009 - dmorello, Cambio 20080765
     * - El parametro de entrada pasa a ser un OID de consolidado de boletas de recojo
     * - Se modifica la query para buscar las posiciones a partir de dicho OID
     */
    public HashMap validarPosicionesImprimiblesBR(Long oidBoletaRecojoConsolidado)  throws MareException {
       UtilidadesLog.info("DAODocuContable.validarPosicionesImprimiblesBR(Long oidCabecera): Entrada"); 
       StringBuffer query = new StringBuffer();     
               
        query.append("SELECT DISTINCT pos.oid_soli_posi");
        query.append("  FROM rec_bolet_recoj boleta");
        query.append("     , rec_cabec_recla cabrec");
        query.append("     , ped_solic_cabec sol");
        query.append("     , ped_tipo_solic_pais tsp");
        query.append("     , ped_tipo_solic ts");
        query.append("     , ped_solic_posic pos");
        query.append(" WHERE boleta.bore_oid_bole_reco = ").append(oidBoletaRecojoConsolidado);
        query.append("   AND boleta.care_oid_cabe_recl = cabrec.oid_cabe_recl");
        query.append("   AND cabrec.soca_oid_soli_cabe = sol.soca_oid_docu_refe");
        query.append("   AND sol.ind_ts_no_conso = 1");
        query.append("   AND sol.tspa_oid_tipo_soli_pais = tsp.oid_tipo_soli_pais");
        query.append("   AND tsp.tsol_oid_tipo_soli = ts.oid_tipo_soli");
        query.append("   AND ts.ind_soli_nega = 1");
        query.append("   AND SOL.OID_SOLI_CABE = POS.SOCA_OID_SOLI_CABE");
        query.append("   AND pos.val_codi_vent NOT IN (");
        query.append("          SELECT pod.val_codi_vent");
        query.append("            FROM rec_produ_no_recog pnr");
        query.append("               , pre_ofert_detal pod");
        query.append("               , ped_solic_cabec psc");
        query.append("           WHERE pnr.ofde_oid_deta_ofer = pod.oid_deta_ofer");
        query.append("             AND psc.perd_oid_peri = pnr.perd_oid_peri");
        query.append("             AND psc.oid_soli_cabe = pos.soca_oid_soli_cabe)");
        query.append("   AND TO_CHAR (pos.val_codi_vent_fict) NOT IN (");
        query.append("          SELECT ail.cod_vent_fict");
        query.append("            FROM rec_produ_no_recog pnr");
        query.append("               , inc_artic_lote ail");
        query.append("               , ped_solic_cabec psc");
        query.append("           WHERE pnr.arlo_oid_arti_lote = ail.oid_arti_lote");
        query.append("             AND psc.perd_oid_peri = pnr.perd_oid_peri");
        query.append("             AND psc.oid_soli_cabe = pos.soca_oid_soli_cabe)");
		
       RecordSet rs = null;
       rs = UtilidadesBD.executeQuery(query.toString());

       UtilidadesLog.info("DAODocuContable.validarPosicionesImprimiblesBR(Long oidCabecera): Salida"); 
       return this.asignarPosiciones(rs);
    }
    
    private HashMap asignarPosiciones(RecordSet rs) {
      HashMap hashPosiciones = new HashMap();
      if (rs != null && !rs.esVacio()) {
        int rsSize = rs.getRowCount();
        for (int i = 0; i < rsSize; i++) {
          hashPosiciones.put(UtilidadesBD.convertirALong(rs.getValueAt(i, "OID_SOLI_POSI")), "");
        }
      }
      return hashPosiciones;
    }  
 
    public Float obtenerSaldoCC(Long oidCliente, String fechaPago, Long oidPais) throws MareException {
       UtilidadesLog.info("DAODocuContable.obtenerSaldoCC(Long oidCliente, String fechaPago, Long oidPais): Entrada"); 
       StringBuffer query = new StringBuffer();     
               
       query.append(" SELECT NVL(DATOS.IMP_PEND, 0) - NVL((SELECT SUM(B.IMP_SALD_PEND) ");
	   query.append("					FROM CCC_MOVIM_BANCA B ");
       query.append("				    WHERE B.CLIE_OID_CLIE = DATOS.CLIE_OID_CLIE  ");
	   query.append("                     AND B.IMP_SALD_PEND <> 0 ");
       query.append("						),0)  AS SALDO	");
       query.append(" FROM( ");
       query.append(" SELECT SUM(NVL(MCC.IMP_PEND, 0)) IMP_PEND, ");
       query.append("        MCC.CLIE_OID_CLIE ");
       query.append(" FROM CCC_MOVIM_CUENT_CORRI MCC ");
       query.append(" WHERE MCC.CLIE_OID_CLIE = " + oidCliente);
       query.append("   AND MCC.FEC_VENC >= TO_DATE('01/01/2000', 'DD/MM/YYYY') ");
       query.append("   AND MCC.FEC_VENC <= TO_DATE('" + fechaPago +"', 'DD/MM/YYYY') "); 
       query.append("   AND MCC.IMP_MOVI <> MCC.IMP_PAGA ");
       query.append("   AND MCC.MASI_OID_MARC_SITU IN  ");
       query.append(" (SELECT U.OID_MARC_SITU ");
       query.append("  FROM CCC_MARCA_SITUA U, ");
       query.append("       CCC_MARCA_TIPO_ABONO M, ");
       query.append("       CCC_TIPO_ABONO_SUBPR T, ");
       query.append("       CCC_SUBPR S, ");
       query.append("       CCC_PROCE P ");
       query.append(" WHERE U.OID_MARC_SITU = M.MASI_OID_MARC_SALI ");
       query.append("   AND M.TASP_OID_TIPO_ABON_SUBP = T.OID_TIPO_ABON_SUBP ");
       query.append("   AND T.SUBP_OID_SUBP = S.OID_SUBP ");
       query.append("   AND S.CCPR_OID_PROC = P.OID_PROC ");
       query.append("   AND S.COD_SUBP = 1 ");
       query.append("   AND P.COD_PROC = 'CON001' ");
       query.append("   AND U.PAIS_OID_PAIS = " + oidPais);
       query.append("   AND M.IND_ENTR_SALI LIKE 'E') ");       
       query.append(" GROUP BY MCC.CLIE_OID_CLIE ");       
       query.append(" ) DATOS ");
  
       RecordSet rs = null;
       rs = UtilidadesBD.executeQuery(query.toString());

       UtilidadesLog.info("DAODocuContable.obtenerSaldoCC(Long oidCliente, String fechaPago, Long oidPais): Salida"); 
       return this.asignarSaldoCC(rs);
    }
    
    private Float asignarSaldoCC(RecordSet rs) {
      Float saldoCC = new Float(0);      
      if (rs != null && !rs.esVacio()) {
          saldoCC = UtilidadesBD.convertirAFloat(rs.getValueAt(0, "SALDO"));     
      }
      return saldoCC;
    }  

    public Long obtenerNumeroCuponPago () throws MareException {
       UtilidadesLog.info("DAODocuContable.obtenerTipoIva(Long oidCabecera): Entrada"); 
       StringBuffer query = new StringBuffer();     
               
       query.append("SELECT FAC_SNCP_SEQ.NEXTVAL NUM_CUP FROM DUAL ");
	
       RecordSet rs = null;
       rs = UtilidadesBD.executeQuery(query.toString());

       UtilidadesLog.info("DAODocuContable.obtenerTipoIva(Long oidCabecera): Salida"); 
       return this.asignarNumeroCuponPago(rs);
    }
    
    private Long asignarNumeroCuponPago(RecordSet rs) {
      Long numeroCuponPago = new Long(0);      
      if (rs != null && !rs.esVacio()) {
          numeroCuponPago = UtilidadesBD.convertirALong(rs.getValueAt(0, "NUM_CUP"));        
      }
      return numeroCuponPago;
    }  

    public DTODatosBoletaRecojo recuperarDatosCabeceraRecojo (Long oidSolicitudCabecera, Long oidTipoSolicitud) throws MareException {
       UtilidadesLog.info("DAODocuContable.recuperarDatosCabeceraRecojo(Long oidSolicitudCabecera, Long oidTipoSolicitud): Entrada");
       StringBuffer query = new StringBuffer();     

       Long oidIdiomaPorDefecto = RecuperadorIdiomaDefectoServidor.getIdiomaDefectoServidor(); 
               
       query.append("SELECT RBR.NUM_BOLE NUM_BOLE, ");
       query.append(" 		PQ_APL_AUX.Valor_Gen_I18n_Sicc(" + oidIdiomaPorDefecto + ", RBR.NURE_OID_NUME_RECO, 'REC_NUMER_RECOJ') DESC_RECOJ, ");
       query.append("       RO.COD_OPER, ");
       query.append("		RCR.NUM_RECL, ");
       query.append("       ( ");
       query.append("       SELECT REG.COD_REGI || '-' || ZON.COD_ZONA || '-' || SEC.COD_SECC || '-' || TER.COD_TERR  ");
       query.append("       FROM PED_SOLIC_CABEC PSC, ");
       query.append("            ZON_REGIO REG, ");
       query.append("            ZON_ZONA ZON, ");
       query.append("            ZON_SECCI SEC, ");
       query.append("            ZON_TERRI_ADMIN ZTA, ");
       query.append("            ZON_TERRI TER ");
       query.append("       WHERE TER.OID_TERR = ZTA.TERR_OID_TERR "); 
       query.append("         AND SEC.OID_SECC = ZTA.ZSCC_OID_SECC ");
       query.append("         AND ZON.OID_ZONA = SEC.ZZON_OID_ZONA ");
       query.append("         AND REG.OID_REGI = ZON.ZORG_OID_REGI ");
       query.append("         AND PSC.TERR_OID_TERR = TER.OID_TERR ");
       query.append("         AND PSC.OID_SOLI_CABE = RSO.SOCA_OID_SOLI_CABE ");
       query.append("        )  COD_TERRIT  ");  
       query.append(" FROM REC_BOLET_RECOJ RBR, ");
       query.append("      REC_SOLIC_OPERA RSO, ");
       query.append("      REC_OPERA_RECLA ROR, ");       
       query.append("      REC_TIPOS_OPERA RTO, ");
       query.append("      REC_OPERA RO, ");
       query.append("      REC_CABEC_RECLA RCR  ");
       query.append(" WHERE RSO.OPRE_OID_OPER_RECL = ROR.OID_OPER_RECL  ");
       query.append("   AND ROR.CARE_OID_CABE_RECL = RBR.CARE_OID_CABE_RECL ");       
       query.append("   AND RO.OID_OPER = RTO.ROPE_OID_OPER ");
       query.append("   AND RTO.OID_TIPO_OPER = ROR.TIOP_OID_TIPO_OPER ");
       query.append("   AND RCR.OID_CABE_RECL = RBR.CARE_OID_CABE_RECL ");
       query.append("   AND RSO.SOCA_OID_SOLI_CABE = " + oidSolicitudCabecera);
       query.append("   AND RSO.TSPA_OID_TIPO_SOLI_PAIS = " + oidTipoSolicitud);	  
  
       RecordSet rs = null;       
       rs = UtilidadesBD.executeQuery(query.toString());       
  
       UtilidadesLog.info("DAODocuContable.recuperarDatosCabeceraRecojo(Long oidSolicitudCabecera, Long oidTipoSolicitud): Salida");
       return this.asignarDatosBoletaRecojo(rs);
    }
    
    private DTODatosBoletaRecojo asignarDatosBoletaRecojo (RecordSet rs) {
      DTODatosBoletaRecojo dtoDatosBoletaRecojo = new DTODatosBoletaRecojo(); 
      //UtilidadesLog.warn("RS ---> recuperarDatosCabeceraRecojo" + rs);
      if (rs != null && !rs.esVacio()) {
        dtoDatosBoletaRecojo.setNumeroBoleta((String)UtilidadesBD.convertirAString(rs.getValueAt(0, "NUM_BOLE")));
        dtoDatosBoletaRecojo.setDescripcionRecojo((String)UtilidadesBD.convertirAString(rs.getValueAt(0, "DESC_RECOJ")));
        dtoDatosBoletaRecojo.setCodigoOperacion((String)UtilidadesBD.convertirAString(rs.getValueAt(0, "COD_OPER")));
        dtoDatosBoletaRecojo.setNumeroReclamo((Long)UtilidadesBD.convertirALong(rs.getValueAt(0, "NUM_RECL")));
        dtoDatosBoletaRecojo.setCodigoTerritorial((String)UtilidadesBD.convertirAString(rs.getValueAt(0, "COD_TERRIT")));
      }
      UtilidadesLog.debug("*** dtoDatosBoletaRecojo: " + dtoDatosBoletaRecojo);
      return dtoDatosBoletaRecojo;  
    }
    
    public ArrayList recuperarDatosDetalleBoletaEntregaColombia(Long oidSolicitudCabecera) throws MareException {
       UtilidadesLog.info("DAODocuContable.recuperarDatosDetalleBoletaEntregaColombia(Long oidSolicitudCabecera): Entrada");
       StringBuffer query = new StringBuffer();     

       Long oidIdiomaPorDefecto = RecuperadorIdiomaDefectoServidor.getIdiomaDefectoServidor(); 
               
       query.append("SELECT * ");	   
       query.append(" FROM ");
       query.append(" ( ");
       query.append(" ( ");
       query.append(" SELECT 0 IND_AGRUP, ");
       query.append("      MOD.COD_MODU, ");
       query.append("	   MP.COD_SAP, ");
       query.append("	   PQ_APL_AUX.Valor_Gen_I18n_Sicc( " + oidIdiomaPorDefecto + ", MP.OID_PROD, 'MAE_PRODU') DESC_PROD, ");
       query.append("	   MOD.VAL_DESC_BE_COLO, ");
       query.append("  	   SUM(NVL(PSP.NUM_UNID_ATEN, 0)) UNID_DP ");
       query.append(" FROM PED_SOLIC_CABEC PSC, ");
       query.append("	  PED_SOLIC_POSIC PSP, ");
       query.append("	  SEG_MODUL MOD, ");
       query.append("	  MAE_PRODU MP ");
       query.append(" WHERE PSP.SOCA_OID_SOLI_CABE = PSC.OID_SOLI_CABE  ");
       query.append("  AND PSP.ESPO_OID_ESTA_POSI <> 2 ");
       query.append("  AND PSP.IND_DENT_FUER_CAJA_BOLS = 'C' ");
       query.append("  AND PSC.IND_OC <> 1 ");
       query.append("  AND MOD.OID_MODU = PSC.MODU_OID_MODU ");
       query.append("  AND MP.OID_PROD = PSP.PROD_OID_PROD  ");
       query.append("  AND MP.IND_PROD_SERV <> 1 ");
       query.append("  AND PSP.NUM_UNID_ATEN > 0 ");
       query.append("  AND PSC.SOCA_OID_SOLI_CABE = " + oidSolicitudCabecera);
       query.append(" GROUP BY COD_MODU, COD_SAP, MP.OID_PROD, VAL_DESC_BE_COLO ");
       query.append(" ) ");
       query.append(" UNION ALL ");
       query.append(" ( ");
       query.append(" SELECT 1 IND_AGRUP, ");
	   query.append("      MOD.COD_MODU, "); 
       query.append("	   MP.COD_SAP, ");
       query.append("	   PQ_APL_AUX.Valor_Gen_I18n_Sicc(" + oidIdiomaPorDefecto + ", MP.OID_PROD, 'MAE_PRODU') DESC_PROD, ");
       query.append("	   MOD.VAL_DESC_BE_COLO, ");
       query.append("  	   SUM(NVL(PSP.NUM_UNID_ATEN, 0)) UNID_DP ");
       query.append(" FROM PED_SOLIC_CABEC PSC, ");
       query.append("	  PED_SOLIC_POSIC PSP, ");
       query.append("	  SEG_MODUL MOD, ");
       query.append("	  MAE_PRODU MP ");
       query.append(" WHERE PSP.SOCA_OID_SOLI_CABE = PSC.OID_SOLI_CABE  ");
       query.append("  AND PSP.ESPO_OID_ESTA_POSI <> 2 ");
       query.append("  AND PSP.IND_DENT_FUER_CAJA_BOLS IN ('F', 'B') ");
       query.append("  AND MOD.OID_MODU = PSC.MODU_OID_MODU ");
       query.append("  AND MP.OID_PROD = PSP.PROD_OID_PROD   ");
       query.append("  AND MP.IND_PROD_SERV <> 1 ");
       query.append("  AND PSP.NUM_UNID_ATEN > 0 ");
       query.append("  AND PSC.SOCA_OID_SOLI_CABE = " + oidSolicitudCabecera);
       query.append(" GROUP BY COD_MODU, COD_SAP, MP.OID_PROD, VAL_DESC_BE_COLO ");
       query.append(" ) ");
       query.append(" ) ");
       query.append(" ORDER BY IND_AGRUP, COD_MODU, COD_SAP, DESC_PROD, VAL_DESC_BE_COLO  "); 
  
       RecordSet rs = null;       
       rs = UtilidadesBD.executeQuery(query.toString());       
  
       UtilidadesLog.info("DAODocuContable.recuperarDatosDetalleBoletaEntregaColombia(Long oidSolicitudCabecera): Salida");
       return this.asignarDatosDetalleBoletaEntregaColombia(rs);
  
    }
    
    private ArrayList asignarDatosDetalleBoletaEntregaColombia (RecordSet rs) {
      ArrayList arrayDetalles = new ArrayList();
      if (rs != null && !rs.esVacio()) {
        int rsCount = rs.getRowCount();
        for (int i = 0; i < rsCount; i++) {
            DTODatosDetalleBoletaEntregaColombia dtoDatosDetalle = new DTODatosDetalleBoletaEntregaColombia();  
            dtoDatosDetalle.setIndicadorAgrupacion((Long)UtilidadesBD.convertirALong(rs.getValueAt(i, "IND_AGRUP")));
            dtoDatosDetalle.setUnidades((Long)UtilidadesBD.convertirALong(rs.getValueAt(i, "UNID_DP")));
            dtoDatosDetalle.setDescProducto((String)UtilidadesBD.convertirAString(rs.getValueAt(i, "DESC_PROD")));
            dtoDatosDetalle.setDescModulo((String)UtilidadesBD.convertirAString(rs.getValueAt(i, "VAL_DESC_BE_COLO")));      
            arrayDetalles.add(dtoDatosDetalle);
        }
      }
      return arrayDetalles;  
    }

    public Long recuperarUnidadesFacturadasBoletaEntregaColombia(Long oidSolicitudCabecera) throws MareException {
       UtilidadesLog.info("DAODocuContable.recuperarUnidadesFacturadasBoletaEntregaColombia(Long oidSolicitudCabecera): Entrada");
       StringBuffer query = new StringBuffer();     

       query.append("SELECT SUM(PSP.NUM_UNID_ATEN) UNID_ENTR ");
       query.append(" FROM PED_SOLIC_POSIC PSP, ");
       query.append(" 	   PED_SOLIC_CABEC PSC, ");
       query.append("      MAE_PRODU MP ");
       query.append(" WHERE PSP.SOCA_OID_SOLI_CABE = PSC.OID_SOLI_CABE  ");
       query.append("  AND PSP.ESPO_OID_ESTA_POSI <> 2 ");
       query.append("  AND MP.OID_PROD = PSP.PROD_OID_PROD ");
       query.append("  AND MP.IND_PROD_SERV <> 1 ");
       query.append("  AND PSC.SOCA_OID_SOLI_CABE = " + oidSolicitudCabecera);
  
       RecordSet rs = null;       
       rs = UtilidadesBD.executeQuery(query.toString());       
  
       UtilidadesLog.info("DAODocuContable.recuperarUnidadesFacturadasBoletaEntregaColombia(Long oidSolicitudCabecera): Salida");
       return this.asignarUnidadesFacturadasBoletaEntregaColombia(rs);
  
    }
    
    private Long asignarUnidadesFacturadasBoletaEntregaColombia (RecordSet rs) {
      Long unidadesFacturadas = new Long(0);
      if (rs != null && !rs.esVacio()) {
         unidadesFacturadas = UtilidadesBD.convertirALong(rs.getValueAt(0, "UNID_ENTR"));
      }
      return unidadesFacturadas;  
    }
  
      public Float obtenerSaldoCCDetalleFactura(Long oidCliente, String fechaPago, Long oidPais, int dias) throws MareException {
       UtilidadesLog.info("DAODocuContable.obtenerSaldoCCDetalleFactura(Long oidCliente, String fechaPago, Long oidPais, int dias): Entrada"); 
       StringBuffer query = new StringBuffer();     
               
       query.append(" SELECT NVL(DATOS.IMP_PEND, 0) - NVL((SELECT SUM(B.IMP_SALD_PEND) ");
	   query.append("					FROM CCC_MOVIM_BANCA B ");
       query.append("				    WHERE B.CLIE_OID_CLIE = DATOS.CLIE_OID_CLIE  ");
	   query.append("                     AND B.IMP_SALD_PEND <> 0 ");
       query.append("						),0)  AS SALDO	");
       query.append(" FROM( ");
       query.append(" SELECT SUM(NVL(MCC.IMP_PEND, 0)) IMP_PEND, ");
       query.append("        MCC.CLIE_OID_CLIE ");
       query.append(" FROM CCC_MOVIM_CUENT_CORRI MCC ");
       query.append(" WHERE MCC.CLIE_OID_CLIE = " + oidCliente);
       query.append("   AND MCC.FEC_VENC >= (TO_DATE('" + fechaPago +"', 'DD/MM/YYYY')) +" + dias); 
       query.append("   AND MCC.IMP_MOVI <> MCC.IMP_PAGA ");
       query.append("   AND MCC.MASI_OID_MARC_SITU IN  ");
       query.append(" (SELECT U.OID_MARC_SITU ");
       query.append("  FROM CCC_MARCA_SITUA U, ");
       query.append("       CCC_MARCA_TIPO_ABONO M, ");
       query.append("       CCC_TIPO_ABONO_SUBPR T, ");
       query.append("       CCC_SUBPR S, ");
       query.append("       CCC_PROCE P ");
       query.append(" WHERE U.OID_MARC_SITU = M.MASI_OID_MARC_SALI ");
       query.append("   AND M.TASP_OID_TIPO_ABON_SUBP = T.OID_TIPO_ABON_SUBP ");
       query.append("   AND T.SUBP_OID_SUBP = S.OID_SUBP ");
       query.append("   AND S.CCPR_OID_PROC = P.OID_PROC ");
       query.append("   AND S.COD_SUBP = 1 ");
       query.append("   AND P.COD_PROC = 'CON001' ");
       query.append("   AND U.PAIS_OID_PAIS = " + oidPais);
       query.append("   AND M.IND_ENTR_SALI LIKE 'E') ");
       query.append("   GROUP BY MCC.CLIE_OID_CLIE  ");
       query.append(" ) DATOS ");
  
       RecordSet rs = null;
       rs = UtilidadesBD.executeQuery(query.toString());

       UtilidadesLog.info("DAODocuContable.obtenerSaldoCCDetalleFactura(Long oidCliente, String fechaPago, Long oidPais, int dias): Salida"); 
       return this.asignarSaldoCCDetalleFactura(rs);
    }
    
    private Float asignarSaldoCCDetalleFactura(RecordSet rs) {
      Float saldoCC = new Float(0);      
      if (rs != null && !rs.esVacio()) {
          saldoCC = UtilidadesBD.convertirAFloat(rs.getValueAt(0, "SALDO"));     
      }
      return saldoCC;
    }


    public ArrayList obtenerVencimientosCC(Long oidCliente, String fechaPago, Long oidPais) throws MareException {
       UtilidadesLog.info("DAODocuContable.obtenerVencimientosCC(Long oidCliente, String fechaPago, Long oidPais): Entrada"); 
       StringBuffer query = new StringBuffer();     
               
       query.append(" SELECT SPC.COD_PERI, ");
       query.append(" 	   MCC.NUM_IDEN_CUOT, ");
       query.append(" 	   MCC.NUM_ORDE_CUOT, ");
       query.append(" 	   MCC.FEC_VENC, ");
       query.append(" 	   MCC.IMP_PEND ");
       query.append(" FROM CCC_MOVIM_CUENT_CORRI MCC, ");
       query.append(" 	 CRA_PERIO PER, ");
       query.append(" 	 SEG_PERIO_CORPO SPC  ");
       query.append(" WHERE MCC.CLIE_OID_CLIE = " + oidCliente);
       query.append("   AND MCC.FEC_VENC > TO_DATE('" + fechaPago +"', 'DD/MM/YYYY') "); 
       query.append("   AND MCC.IMP_PEND <> 0  ");
       query.append("   AND MCC.PERD_OID_PERI = PER.OID_PERI ");
       query.append("   AND PER.PERI_OID_PERI = SPC.OID_PERI  "); 
       query.append("   AND MCC.MASI_OID_MARC_SITU IN ");
       query.append(" 	(SELECT U.OID_MARC_SITU "); 
       query.append(" 	 FROM CCC_MARCA_SITUA U, ");
       query.append(" 	      CCC_MARCA_TIPO_ABONO M, ");
       query.append(" 	      CCC_TIPO_ABONO_SUBPR T, ");
       query.append(" 	      CCC_SUBPR S, ");
       query.append(" 	      CCC_PROCE P ");
       query.append(" 	WHERE U.OID_MARC_SITU = M.MASI_OID_MARC_SALI ");
       query.append(" 	  AND M.TASP_OID_TIPO_ABON_SUBP = T.OID_TIPO_ABON_SUBP ");
       query.append(" 	  AND T.SUBP_OID_SUBP = S.OID_SUBP ");
       query.append(" 	  AND S.CCPR_OID_PROC = P.OID_PROC ");
       query.append(" 	  AND S.COD_SUBP = 1 ");
       query.append(" 	  AND P.COD_PROC = 'CON001' ");
       query.append(" 	  AND U.PAIS_OID_PAIS = " + oidPais);
       query.append(" 	  AND M.IND_ENTR_SALI LIKE 'E') ");
       query.append(" ORDER BY MCC.FEC_VENC  ");

       RecordSet rs = null;
       rs = UtilidadesBD.executeQuery(query.toString());

       UtilidadesLog.info("DAODocuContable.obtenerVencimientosCC(Long oidCliente, String fechaPago, Long oidPais): Salida"); 
       return this.asignarVencimientosCC(rs);
    }
    
    private ArrayList asignarVencimientosCC(RecordSet rs) {
      ArrayList arrayVencimientos = new ArrayList();      
      if (rs != null && !rs.esVacio()) {
          int cantRows = rs.getRowCount();
          for (int i = 0; i < cantRows; i++) {
            DTOVencimientosCC dtoVencimientosCC = new DTOVencimientosCC();
            dtoVencimientosCC.setCodigoPeriodo(UtilidadesBD.convertirAString(rs.getValueAt(i, "COD_PERI")));
            dtoVencimientosCC.setNumeroIdentificadorCuota(UtilidadesBD.convertirALong(rs.getValueAt(i, "NUM_IDEN_CUOT")));
            dtoVencimientosCC.setNumeroOrdenCuota(UtilidadesBD.convertirALong(rs.getValueAt(i, "NUM_ORDE_CUOT")));
            dtoVencimientosCC.setFechaVencimiento((Date)rs.getValueAt(i, "FEC_VENC"));
            dtoVencimientosCC.setImportePendiente(UtilidadesBD.convertirAFloat(rs.getValueAt(i, "IMP_PEND")));
            arrayVencimientos.add(dtoVencimientosCC);
          }
      }
      return arrayVencimientos;
    }
    
    
    public Float obtenerCopiasOCS(Long oidPais, Long oidSolicitudCabecera) throws MareException {
       UtilidadesLog.info("DAODocuContable.obtenerSaldoCCDetalleFactura(Long oidPais, Long oidSolicitudCabecera): Entrada"); 
       StringBuffer query = new StringBuffer();     
               
       query.append(" SELECT SUM(PSP.NUM_UNID_ATEN) UNID_ATEN ");
       query.append(" FROM SEG_PARAM_INTER_PAIS PIP, ");
       query.append(" 	 PED_SOLIC_POSIC PSP, ");
       query.append(" 	 PED_SOLIC_CABEC PSC ");
       query.append(" WHERE PIP.PAIS_OID_PAIS = " + oidPais);
       query.append("   AND PIP.VAL_CODI_VENT_OC IS NOT NULL ");
       query.append("   AND PSC.SOCA_OID_SOLI_CABE = " + oidSolicitudCabecera);
       query.append("   AND PSC.OID_SOLI_CABE = PSP.SOCA_OID_SOLI_CABE  ");
       query.append("   AND PSP.VAL_CODI_VENT = PIP.VAL_CODI_VENT_OC  ");

       RecordSet rs = null;
       rs = UtilidadesBD.executeQuery(query.toString());

       UtilidadesLog.info("DAODocuContable.obtenerSaldoCCDetalleFactura(Long oidPais, Long oidSolicitudCabecera): Salida"); 
       return this.asignarCopiasOCS(rs);
    }
    
    private Float asignarCopiasOCS(RecordSet rs) {
      Float copiasOCS = new Float(1);      
      if (rs != null && !rs.esVacio()) {
          Float copiasAux = UtilidadesBD.convertirAFloat(rs.getValueAt(0, "UNID_ATEN"));
          if (copiasAux != null) {
            copiasOCS = new Float(copiasOCS.floatValue() + copiasAux.floatValue());     
          }
      }
      return copiasOCS;
    }

    public Date obtenerFechaFacturacionCampañaSiguiente (Long oidPeriodo, Long oidZona) throws MareException {
       UtilidadesLog.info("DAODocuContable.obtenerFechaFacturacionCampañaSiguiente(Long oidPeriodo, Long oidZona): Entrada"); 
       StringBuffer query = new StringBuffer();     
               
       query.append("SELECT CRO.FEC_INIC ");
       query.append(" FROM CRA_CRONO CRO, ");
	   query.append("      CRA_ACTIV CA ");
       query.append(" WHERE CA.OID_ACTI = CRO.CACT_OID_ACTI ");
       query.append("   AND CA.COD_ACTI = 'FA' ");
       query.append("   AND CRO.PERD_OID_PERI = ( ");
	   query.append("          SELECT PER.OID_PERI ");
	   query.append("          FROM ");
	   query.append("              (SELECT PER_BUS.OID_PERI ");
	   query.append("               FROM CRA_PERIO PER_BUS, ");
	   query.append("                   (SELECT PER.FEC_INIC, ");
	   query.append("                           PER.PAIS_OID_PAIS, ");
       query.append("							PER.MARC_OID_MARC, ");
       query.append("							PER.CANA_OID_CANA ");
       query.append("					FROM CRA_PERIO PER ");
       query.append("					WHERE PER.OID_PERI = " + oidPeriodo + ") PER_REF ");
       query.append("				WHERE PER_BUS.PAIS_OID_PAIS = PER_REF.PAIS_OID_PAIS  ");
       query.append("				  AND PER_BUS.MARC_OID_MARC = PER_REF.MARC_OID_MARC ");
       query.append("				  AND PER_BUS.CANA_OID_CANA = PER_REF.CANA_OID_CANA ");
       query.append("				  AND PER_BUS.FEC_INIC > PER_REF.FEC_INIC ");
       query.append("				ORDER BY PER_BUS.FEC_INIC  "); 
       query.append("				) PER ");
       query.append("	    WHERE ROWNUM = 1 ) ");  	 
       query.append("  AND CRO.ZZON_OID_ZONA = " + oidZona);		
       query.append(" ORDER BY CRO.FEC_INIC ");  		 	  

  
       RecordSet rs = null;
       rs = UtilidadesBD.executeQuery(query.toString());

       UtilidadesLog.info("DAODocuContable.obtenerFechaFacturacionCampañaSiguiente(Long oidPeriodo, Long oidZona): Salida"); 
       return this.asignarFechaFacturacionCampañaSiguiente(rs);
    }
    
    private Date asignarFechaFacturacionCampañaSiguiente(RecordSet rs) {
      Date fechaFacturacionCampañaSiguiente = null;      
      if (rs != null && !rs.esVacio()) {
          if (rs.getValueAt(0, "FEC_INIC") != null) {
            fechaFacturacionCampañaSiguiente = (Date)rs.getValueAt(0, "FEC_INIC");
          }         
      }
      return fechaFacturacionCampañaSiguiente;
    }  
    
     public String obtenerCodigoVentaSPV (Long oidPais) throws MareException {
       UtilidadesLog.info("DAODocuContable.obtenerCodigoVentaSPV(Long oidPais): Entrada"); 
       StringBuffer query = new StringBuffer();     
               
       query.append("SELECT PIP.VAL_CODI_VENT_SPV ");
       query.append("FROM SEG_PARAM_INTER_PAIS PIP ");
       query.append("WHERE PIP.PAIS_OID_PAIS = ").append(oidPais);	 	  
  
       RecordSet rs = null;
       rs = UtilidadesBD.executeQuery(query.toString());

       UtilidadesLog.info("DAODocuContable.obtenerCodigoVentaSPV(Long oidPais): Salida"); 
       return this.asignarCodigoVentaSPV(rs);
    }
    
    private String asignarCodigoVentaSPV(RecordSet rs) {
      String codigoVentaSPV = null;      
      if (rs != null && !rs.esVacio()) {          
         codigoVentaSPV = UtilidadesBD.convertirAString(rs.getValueAt(0, "VAL_CODI_VENT_SPV"));          
      }
      return codigoVentaSPV;
    }
/* Agregado por Cambio FAC-001 ------ AL */

/* Agregado por Cambio FAC-003-COL ------ AL */
   public Float obtenerSaldoCupon3(Long oidCliente, Long oidPais, Long oidPeriodo, Long oidSolicitudCabecera, Boolean indReimpresion, Boolean indUpdate) throws MareException {
       UtilidadesLog.info("DAODocuContable.obtenerSaldoCupon3(Long oidCliente, Long oidPais, Long oidPeriodo, Long oidSolicitudCabecera, Boolean indReimpresion, Boolean indUpdate): Entrada"); 
       StringBuffer query = new StringBuffer();     
               
       query.append(" SELECT CTD.OID_DETA_CUPO_TRAM_DEPU, ");
       query.append(" 	     SUM(CTD.IMP_DETA) OVER (PARTITION BY 1) SUMA ");
       query.append(" FROM CCC_DETAL_CUPON_TRAMI_DEPUR CTD, ");
       query.append(" 	   CCC_CUPON_TRAMI_DEPUR CTC, ");
       query.append(" 	   CCC_SITUA_CUPON CSC  ");
       query.append(" WHERE CTC.OID_CUPO_TRAM_DEPU = CTD.CTDE_OID_CUPO_TRAM_DEPU ");
       query.append("   AND CTC.PERD_OID_PERI = " + oidPeriodo);
       query.append("   AND CTC.PAIS_OID_PAIS = " + oidPais);
       query.append("   AND CTD.CLIE_OID_CLIE = " + oidCliente);       
       query.append("   AND CTD.SICU_OID_SITU_CUPO = CSC.OID_SITU_CUPO ");
       query.append("   AND CSC.COD_SITU_CUPO = 'T' ");
       if (indReimpresion != null && indReimpresion.booleanValue()) {
          query.append("   AND CTD.SOCA_OID_SOLI_CABE = " + oidSolicitudCabecera);          
       } else {
          query.append("   AND CTD.SOCA_OID_SOLI_CABE IS NULL  ");
       }

       RecordSet rs = null;
       rs = UtilidadesBD.executeQuery(query.toString());

       UtilidadesLog.info("DAODocuContable.obtenerSaldoCupon3(Long oidCliente, Long oidPais, Long oidPeriodo, Long oidSolicitudCabecera, Boolean indReimpresion, Boolean indUpdate): Salida"); 
       return this.asignarSaldoCupon3(rs, indUpdate, oidSolicitudCabecera);
    }
    
    private Float asignarSaldoCupon3(RecordSet rs, Boolean indUpdate, Long oidSolicitudCabecera) throws MareException {
      Float saldoCupon3 = new Float(0);      
      if (rs != null && !rs.esVacio()) {
          saldoCupon3 = UtilidadesBD.convertirAFloat(rs.getValueAt(0, "SUMA"));
          if (indUpdate != null && indUpdate.booleanValue()) {
              StringBuffer query = new StringBuffer();
              int totRows = rs.getRowCount();          
              for (int i = 0; i < totRows; i++){
                query.append("UPDATE CCC_DETAL_CUPON_TRAMI_DEPUR SET SOCA_OID_SOLI_CABE = " + oidSolicitudCabecera);
                query.append(" WHERE OID_DETA_CUPO_TRAM_DEPU = " + UtilidadesBD.convertirALong(rs.getValueAt(i, "OID_DETA_CUPO_TRAM_DEPU")));
                query.append(";");
              }
              try {        
                BelcorpService bs = UtilidadesEJB.getBelcorpService();                
                bs.dbService.executeProcedure("PQ_PLANI.EXECUTOR", query.toString());
              } catch (Exception e) {
                String codigoError = CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS;
                throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));
              }
          }          
      }
      return saldoCupon3;
    }
    
     public void actualizarSaldoAnterior(Float saldoActual, Long oidCliente) throws MareException {
        UtilidadesLog.info("DAODocuContable.actualizarSaldoAnterior(Float saldoActual, Long oidCliente): Entrada"); 
        StringBuffer query = new StringBuffer();
        query.append("UPDATE MAE_CLIEN SET SAL_DEUD_ANTE = ").append(saldoActual).append(" WHERE OID_CLIE = ").append(oidCliente).append(";");        
        try {        
          BelcorpService bs = UtilidadesEJB.getBelcorpService();
          bs.dbService.executeProcedure("PQ_PLANI.EXECUTOR", query.toString());
        } catch (Exception e) {
          String codigoError = CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS;
          throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));
        }
        UtilidadesLog.info("DAODocuContable.actualizarSaldoAnterior(Float saldoActual, Long oidCliente): Salida"); 
     }
    /* Agregado por Cambio FAC-003-COL ------ AL */

   public String obtenerTagPrimerPedido(Long oidCliente) throws MareException {
       UtilidadesLog.info("DAODocuContable.obtenerTagPrimerPedido(Long oidCliente): Entrada"); 
       StringBuffer query = new StringBuffer();     
               
       query.append("SELECT CASE WHEN ((SELECT COD_ESTA_CLIE FROM MAE_ESTAT_CLIEN MEC WHERE MEC.OID_ESTA_CLIE = DAT.ESTA_OID_ESTA_CLIE) = '02') THEN ");
       query.append("           	   		'* PRIMER PEDIDO *' ");
	   query.append("            ELSE ");
       query.append("              (SELECT VAL_TEXT_VARI ");
       query.append("              FROM ");
       query.append("           	(SELECT CTV.VAL_TEXT_VARI ");
       query.append("             	 FROM APE_CONFI_TEXTO_VARIA CTV, ");
       query.append("           	     ( ");
       query.append("           		  SELECT MTS.TICL_OID_TIPO_CLIE, ");
       query.append("           		  	     MTS.SBTI_OID_SUBT_CLIE, ");
       query.append("           				 MCC.CLAS_OID_CLAS, ");
       query.append("           				 MCC.TCCL_OID_TIPO_CLASI ");
       query.append("           		  FROM MAE_CLIEN_TIPO_SUBTI MTS, ");
       query.append("           		  	   MAE_CLIEN_CLASI MCC ");
       query.append("           		  WHERE MCC.CTSU_OID_CLIE_TIPO_SUBT = MTS.OID_CLIE_TIPO_SUBT ");
       query.append("           		    AND MTS.CLIE_OID_CLIE = ").append(oidCliente);
       query.append("           		) CLIEN ");
       query.append("           	 WHERE CTV.TICL_OID_TIPO_CLIE = CLIEN.TICL_OID_TIPO_CLIE ");
       query.append("           	   AND (CTV.SBTI_OID_SUBT_CLIE = CLIEN.SBTI_OID_SUBT_CLIE OR CTV.SBTI_OID_SUBT_CLIE IS NULL) ");
       query.append("           	   AND (CTV.CLAS_OID_CLAS = CLIEN.CLAS_OID_CLAS OR CTV.CLAS_OID_CLAS IS NULL) ");
       query.append("           	   AND (CTV.TCCL_OID_TIPO_CLAS = CLIEN.TCCL_OID_TIPO_CLASI OR CTV.TCCL_OID_TIPO_CLAS IS NULL) ");
       query.append("           	   ORDER BY CTV.TICL_OID_TIPO_CLIE, ");
       query.append("           	   	   CTV.SBTI_OID_SUBT_CLIE, ");
       query.append("           	   	   CTV.TCCL_OID_TIPO_CLAS, ");
       query.append("           	   	   CTV.CLAS_OID_CLAS ");
       query.append("           	    ) WHERE ROWNUM = 1) ");
       query.append("             END PRI_PED ");
       query.append("FROM MAE_CLIEN_DATOS_ADICI DAT ");
       query.append("WHERE DAT.CLIE_OID_CLIE = ").append(oidCliente);


       RecordSet rs = null;
       rs = UtilidadesBD.executeQuery(query.toString());

       UtilidadesLog.info("DAODocuContable.obtenerTagPrimerPedido(Long oidCliente): Salida"); 
       return this.asignarTagPrimerPedido(rs);
    }
    
    private String asignarTagPrimerPedido(RecordSet rs) throws MareException {
      String tagPrimerPedido = new String("");      
      if (rs != null && !rs.esVacio()) {
          tagPrimerPedido = UtilidadesBD.convertirAString(rs.getValueAt(0, "PRI_PED"));
      }
      return tagPrimerPedido;
    }
    
    public HashMap obtenerDatosCatalogoFacturas(ArrayList arrayCodigosVenta, Long oidSolicitudCabecera) throws MareException {
       UtilidadesLog.info("DAODocuContable.obtenerDatosCatalogoFacturas(ArrayList arrayCodigosVenta, Long oidSolicitudCabecera): Entrada");         
       StringBuffer query = new StringBuffer();     
       
       query.append(" SELECT POD.VAL_CODI_VENT, ");	   
       query.append("		 '0-' || TO_CHAR(PC.COD_CATA) COD_AGRUP, ");		       
       query.append("		 TO_CHAR(PC.COD_CATA) CODIGO, ");		 
       query.append("		 PC.DES_CATA DESCRIP ");
       query.append(" FROM FAC_DOCUM_CONTA_CABEC DCC, ");
       query.append("  	   PRE_OFERT_DETAL POD, ");
       query.append("	   PRE_OFERT PO, ");
       query.append("	   PRE_MATRI_FACTU_CABEC PMFC, ");
       query.append("	   PRE_CATAL PC, ");
       query.append("	   PRE_CONDI_PROMO PCP  ");
       query.append(" WHERE PMFC.PERD_OID_PERI = DCC.PERD_OID_PERI ");
       query.append("   AND PO.MFCA_OID_CABE = PMFC.OID_CABE ");
       query.append("   AND PO.OID_OFER = POD.OFER_OID_OFER ");
       query.append("   AND POD.OCAT_OID_CATAL = PC.OID_CATA ");
       query.append("   AND POD.CNDP_OID_COND_PROM = PCP.OID_COND_PROM(+) ");
       query.append("   AND (POD.CNDP_OID_COND_PROM IS NULL OR PCP.COD_COND_PROM = '00') ");
       query.append("   AND DCC.SOCA_OID_SOLI_CABE = " + oidSolicitudCabecera );       
       query.append(this.generarFiltroCodigosVenta(arrayCodigosVenta).toString());
				 
       RecordSet rs = null;       
       rs = UtilidadesBD.executeQuery(query.toString());

       UtilidadesLog.info("DAODocuContable.obtenerDatosCatalogoFacturas(ArrayList arrayCodigosVenta, Long oidSolicitudCabecera): Salida"); 
       return this.generarHashXCodigosVenta(rs);
    }

    public Integer obtenerReclamosAnteriores(Long oidCliente, java.util.Date fechaFacturacion) throws MareException {
       UtilidadesLog.info("DAODocuContable.obtenerReclamosAnteriores(Long oidCliente, Date fechaFacturacion): Entrada");         
       StringBuffer query = new StringBuffer();     
       SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd"); 
       Date fechaFact = new java.sql.Date(fechaFacturacion.getTime()); 
	   String sFechaFact = sdf.format(fechaFact);  
       
       query.append("SELECT COUNT(*) NUM_RECLA ");
       query.append("FROM PED_SOLIC_CABEC PSC ");
       query.append("WHERE PSC.MODU_OID_MODU = 15  ");
       query.append("  AND PSC.CLIE_OID_CLIE = ").append(oidCliente);
       query.append("  AND PSC.FEC_FACT > (   ");
       query.append("   SELECT MAX(FEC_FACT) FEC_FACT ");
       query.append("   FROM PED_SOLIC_CABEC PSC ");
       query.append("   WHERE PSC.IND_OC = 1 ");
       query.append("     AND PSC.CLIE_OID_CLIE = ").append(oidCliente);
       query.append("     AND PSC.MODU_OID_MODU <> 15 ");
       query.append("     AND PSC.FEC_FACT < TO_DATE('").append(sFechaFact).append("', 'YYYY-MM-DD')) ");
				 
       RecordSet rs = null;       
       rs = UtilidadesBD.executeQuery(query.toString());

       UtilidadesLog.info("DAODocuContable.obtenerReclamosAnteriores(Long oidCliente, Date fechaFacturacion): Salida"); 
       return this.asignarReclamosAnteriores(rs);
    }
 
    private Integer asignarReclamosAnteriores(RecordSet rs) {
      Integer reclamosAnteriores = new Integer(0);      
      if (rs != null && !rs.esVacio()) {
          Integer reclamosAnterioresAux = UtilidadesBD.convertirAInteger(rs.getValueAt(0, "NUM_RECLA"));
          if (reclamosAnterioresAux != null && reclamosAnterioresAux.intValue() != 0) {
            reclamosAnteriores = new Integer(1);  
          }
      }
      return reclamosAnteriores;
    }

  public RecordSet obtenerDatosReimpresionBoletaEntrega(Long oidSolicitud, Long oidCliente) throws MareException {
       UtilidadesLog.info("DAODocuContable.obtenerDatosReimpresionBoletaEntrega(Long oidSolicitud, Long oidCliente): Entrada");         
       StringBuffer query = new StringBuffer();     
       
       query.append("SELECT DCC.VAL_SERI_DOCU_LEGA, ");
       query.append("       DCC.NUM_DOCU_LEGA, ");
       query.append("       DCC.VAL_TELE_FIJO TELEF_FIJO,  ");
       query.append("       DCC.VAL_TELE_CELU TELEF_CEL,    ");
       query.append("       DCC.VAL_BARR,  ");
       query.append("       RTRIM((SELECT DES_GEOG          ");
       query.append("            FROM ZON_VALOR_ESTRU_GEOPO ");
       query.append("            WHERE ORDE_1 = SUBSTR(MCD.COD_UNID_GEOG, 0, 6) ");
       query.append("              AND ORDE_2 IS NULL)) DEPARTAMENTO, ");
       query.append("       (SELECT DES_GEOG          ");
       query.append("            FROM ZON_VALOR_ESTRU_GEOPO ");
       query.append("            WHERE ORDE_1 = SUBSTR(MCD.COD_UNID_GEOG, 0, 6) ");
       query.append("              AND ORDE_2 = SUBSTR(MCD.COD_UNID_GEOG, 7, 6) ");
       query.append("              AND ORDE_3 IS NULL) MUNICIPIO, ");
       query.append("        CASE WHEN ((SELECT COD_ESTA_CLIE FROM MAE_ESTAT_CLIEN MEC WHERE MEC.OID_ESTA_CLIE = DAT.ESTA_OID_ESTA_CLIE) IN ('01', '07')) THEN  ");
       query.append("                          '* PRIMER PEDIDO *'  ");
       query.append("          ELSE  ");
       query.append("              (SELECT VAL_TEXT_VARI  ");
       query.append("              FROM  ");
       query.append("               (SELECT CTV.VAL_TEXT_VARI  ");
       query.append("                  FROM APE_CONFI_TEXTO_VARIA CTV,  ");
       query.append("                    (  ");
       query.append("                     SELECT MTS.TICL_OID_TIPO_CLIE,  ");
       query.append("                              MTS.SBTI_OID_SUBT_CLIE,  ");
       query.append("                            MCC.CLAS_OID_CLAS,  ");
       query.append("                            MCC.TCCL_OID_TIPO_CLASI  ");
       query.append("                     FROM MAE_CLIEN_TIPO_SUBTI MTS,  ");
       query.append("                            MAE_CLIEN_CLASI MCC  ");
       query.append("                     WHERE MCC.CTSU_OID_CLIE_TIPO_SUBT = MTS.OID_CLIE_TIPO_SUBT  ");
       query.append("                       AND MTS.CLIE_OID_CLIE = ").append(oidCliente);
       query.append("                   ) CLIEN  ");
       query.append("                WHERE CTV.TICL_OID_TIPO_CLIE = CLIEN.TICL_OID_TIPO_CLIE  ");
       query.append("           	   AND (CTV.SBTI_OID_SUBT_CLIE = CLIEN.SBTI_OID_SUBT_CLIE OR CTV.SBTI_OID_SUBT_CLIE IS NULL)  ");
       query.append("           	   AND (CTV.CLAS_OID_CLAS = CLIEN.CLAS_OID_CLAS OR CTV.CLAS_OID_CLAS IS NULL)  ");
       query.append("           	   AND (CTV.TCCL_OID_TIPO_CLAS = CLIEN.TCCL_OID_TIPO_CLASI OR CTV.TCCL_OID_TIPO_CLAS IS NULL)  ");
       query.append("           	   ORDER BY CTV.TICL_OID_TIPO_CLIE,  ");
       query.append("           	   	   CTV.SBTI_OID_SUBT_CLIE,  ");
       query.append("           	   	   CTV.TCCL_OID_TIPO_CLAS,  ");
       query.append("           	   	   CTV.CLAS_OID_CLAS  ");
       query.append("           	    ) WHERE ROWNUM = 1)  ");
       query.append("             END PRI_PED,  ");
       query.append("  OBTENER_FECHA_ENTREGA(PSC.ZZON_OID_ZONA, PSC.PERD_OID_PERI, PSC.PAIS_OID_PAIS, PSC.FEC_FACT) FECHAENTREGA ");
       query.append("FROM FAC_DOCUM_CONTA_CABEC DCC, ");
       query.append("     MAE_CLIEN_DIREC MCD, ");
       query.append("     MAE_CLIEN_DATOS_ADICI DAT, ");
       query.append("     PED_SOLIC_CABEC PSC  ");
       query.append("WHERE DCC.SOCA_OID_SOLI_CABE = PSC.OID_SOLI_CABE ");
       query.append("  AND MCD.OID_CLIE_DIRE = DCC.CLDI_OID_CLIE_DIRE ");
       query.append("  AND DAT.CLIE_OID_CLIE = PSC.CLIE_OID_CLIE ");
       query.append("  AND DCC.SOCA_OID_SOLI_CABE = ").append(oidSolicitud);
				 
       RecordSet rs = null;       
       rs = UtilidadesBD.executeQuery(query.toString());

       UtilidadesLog.info("DAODocuContable.obtenerDatosReimpresionBoletaEntrega(Long oidSolicitud, Long oidCliente): Salida"); 
       return rs;
  }

    // sapaza -- PER-SiCC-2010-0140 -- 28/02/2011
    public Integer obtenerTotalChequeos(Long numeroSolicitud, String codigoPeriodo) throws MareException {
       UtilidadesLog.info("DAODocuContable.obtenerTotalChequeos(Long numeroSolicitud, String codigoPeriodo): Entrada");         
       StringBuffer query = new StringBuffer();     
       
       query.append(" SELECT COUNT(1) ");
       query.append("   FROM PED_PEDID_CHEQU ");
       query.append("  WHERE VAL_NUME_SOLI = " + numeroSolicitud);
       query.append("    AND COD_PERI = '" + codigoPeriodo +  "'");
       query.append("    AND COD_TIPO_CHEQ = 'L' ");
                                 
       RecordSet rs = UtilidadesBD.executeQuery(query.toString());
       
       Integer totalChequeos = new Integer(0);      
       if (rs != null && !rs.esVacio()) {
         totalChequeos = UtilidadesBD.convertirAInteger(rs.getValueAt(0, 0));
       }

       UtilidadesLog.info("DAODocuContable.obtenerTotalChequeos(Long numeroSolicitud, String codigoPeriodo): Salida");         
       return totalChequeos;
    }
    
}
