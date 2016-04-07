package es.indra.sicc.logicanegocio.rec;
import es.indra.mare.common.exception.MareException;
import es.indra.mare.common.mii.services.jdbcservice.RecordSet;
import es.indra.sicc.cmn.negocio.auditoria.DTOSiccPaginacion;
import es.indra.sicc.cmn.negocio.comun.DTOComunes.DTOOIDPaginado;
import es.indra.sicc.dtos.rec.DTOConsultarCabeceraReclamo;
import es.indra.sicc.util.BelcorpService;
import es.indra.sicc.util.CodigosError;
import es.indra.sicc.util.DTOString;
import es.indra.sicc.util.UtilidadesEJB;
import es.indra.sicc.util.UtilidadesError;
import es.indra.sicc.util.UtilidadesLog;
import java.math.BigDecimal;
import java.util.Vector;

public class DAOInformesReclamos 
{
    public DAOInformesReclamos()
    {
    }
    
    public DTOConsultarCabeceraReclamo consultarCabeceraReclamo(DTOString dtoe) throws MareException {
        UtilidadesLog.info("DAOInformesReclamos.consultarCabeceraReclamo(DTOString):Entrada");
        UtilidadesLog.debug("DTOEntrada: "+dtoe);
        
        /* Con el objeto obtenido, se devuelve un objeto del tipo DTOConsultarCabeceraReclamo con los siguientes campos: 
         * - oidCliente = Cliente.oid 
         * - codCliente = Cliente.codCliente 
         * - nombre = Concatenamos los campos: Cliente.nombre1, Cliente.nombre2, Cliente.apellido1, Cliente.apellido2 
         * - zona = Zona.descripcion 
         * - estadoCliente = EstatusCliente.descripcion (internacionalizable)
         */
        StringBuffer consulta = new StringBuffer();
        Vector parametros = new Vector();
        String codigoError = null;
        RecordSet resultado = null;
        String oidCliente = null;
        String oidZona = "";  
        String[] res = dtoe.getCadena().split("/"); 
        oidCliente = res[0];
        if(res.length > 1){
             oidZona = res[1];
        }
        UtilidadesLog.debug("eddy77");
        UtilidadesLog.debug(" oidCliente: " + oidCliente + " oidZona: " + oidZona);
        //SELECT Añadido Distinct por incidencia BELC300015954
        consulta.append("SELECT DISTINCT C.OID_CLIE OID, ");
        consulta.append(" C.COD_CLIE CODIGOCLIENTE, ");
        consulta.append(" C.VAL_NOM1 NOMBRE1, ");
        consulta.append(" C.VAL_NOM2 NOMBRE2, ");
        consulta.append(" C.VAL_APE1 APELLIDO1, ");
        consulta.append(" C.VAL_APE2 APELLIDO2, ");
        consulta.append(" Z.DES_ZONA DESCRIPCIONZONA, ");
        consulta.append(" (SELECT idio.VAL_I18N  FROM V_GEN_I18N_SICC idio ");
        consulta.append("  WHERE idio.ATTR_ENTI = 'MAE_ESTAT_CLIEN'  AND idio.IDIO_OID_IDIO = ? ");
        parametros.add(dtoe.getOidIdioma());
        consulta.append(" AND idio.VAL_OID = EC.OID_ESTA_CLIE) ESTADOCLIENTE ");
        //FROM
        consulta.append("FROM REC_CABEC_RECLA cr, ");
        consulta.append(" MAE_CLIEN c, ");
        consulta.append(" MAE_CLIEN_DATOS_ADICI da, ");
        consulta.append(" MAE_ESTAT_CLIEN ec, ");
        consulta.append(" ZON_TERRI_ADMIN ta, ");
        consulta.append(" ZON_SECCI s, ");
        consulta.append(" ZON_ZONA z ");
        //WHERE
        consulta.append("WHERE CR.CLIE_OID_CLIE = C.OID_CLIE ");
        consulta.append(" AND C.OID_CLIE = DA.CLIE_OID_CLIE ");
        consulta.append(" AND DA.ESTA_OID_ESTA_CLIE = EC.OID_ESTA_CLIE ");
        consulta.append(" AND CR.ZTAD_OID_TERR_ADMI = TA.OID_TERR_ADMI ");
        consulta.append(" AND TA.ZSCC_OID_SECC = S.OID_SECC ");
        consulta.append(" AND S.ZZON_OID_ZONA = Z.OID_ZONA ");
        if (!oidCliente.equals("")){
            consulta.append(" AND C.COD_CLIE = '" + oidCliente + "'");
            
        }
        if(!oidZona.equals("")){
            consulta.append(" AND Z.OID_ZONA = " + oidZona);
        }
        
        //añadido por incidencia BELC300015954
        consulta.append(" AND C.PAIS_OID_PAIS = ?");
        parametros.add(dtoe.getOidPais());
       
        BelcorpService bs = UtilidadesEJB.getBelcorpService();
        
        try {                                             
            UtilidadesLog.debug("query  " + consulta.toString());
            resultado = bs.dbService.executePreparedQuery(consulta.toString(), parametros);
            UtilidadesLog.debug("Resultado del RecordSet:" + resultado);
        } catch (Exception e) {                                                
            codigoError = CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS;
            UtilidadesLog.error("*** DAOInformesReclamos.consultarReclamosCliente: Exception",e);
            throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));
        }
        
        if (resultado.esVacio()) {                                                                               
            UtilidadesLog.debug("****DAOInformesReclamos.consultarReclamosCliente: No hay datos ");				
            throw new MareException(new Exception(), UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE));           
        }
        
        
        /* Con el objeto obtenido, se devuelve un objeto del tipo DTOConsultarCabeceraReclamo con los siguientes campos: 
         * - oidCliente = Cliente.oid 
         * - codCliente = Cliente.codCliente 
         * - nombre = Concatenamos los campos: Cliente.nombre1, Cliente.nombre2, Cliente.apellido1, Cliente.apellido2 
         * - zona = Zona.descripcion 
         * - estadoCliente = EstatusCliente.descripcion (internacionalizable) 
         */
        DTOConsultarCabeceraReclamo dtoSalida = new DTOConsultarCabeceraReclamo();
        if (resultado.getValueAt(0,"OID")!=null){
            dtoSalida.setOidCliente(new Long(((BigDecimal)resultado.getValueAt(0,"OID")).longValue()));
        }
        if (resultado.getValueAt(0,"CODIGOCLIENTE")!=null){
            dtoSalida.setCodCliente((String)resultado.getValueAt(0,"CODIGOCLIENTE"));
        }
        String nombre="";
        if (resultado.getValueAt(0,"NOMBRE1")!=null){
            nombre = (String)resultado.getValueAt(0,"NOMBRE1") + " ";
        }
        if (resultado.getValueAt(0,"NOMBRE2")!=null){
            nombre = nombre + (String)resultado.getValueAt(0,"NOMBRE2") + " ";
        }
        if (resultado.getValueAt(0,"APELLIDO1")!=null){
            nombre = nombre + (String)resultado.getValueAt(0,"APELLIDO1") + " ";
        }
        if (resultado.getValueAt(0,"APELLIDO2")!=null){
            nombre = nombre + (String)resultado.getValueAt(0,"APELLIDO2");
        }
        dtoSalida.setNombre(nombre.trim());
        if (resultado.getValueAt(0,"DESCRIPCIONZONA")!=null){
            dtoSalida.setZona((String)resultado.getValueAt(0,"DESCRIPCIONZONA"));
        }
        if (resultado.getValueAt(0,"ESTADOCLIENTE")!=null){
            dtoSalida.setEstadoCliente((String)resultado.getValueAt(0,"ESTADOCLIENTE"));
        }
        UtilidadesLog.info("DAOInformesReclamos.consultarCabeceraReclamo(DTOString):Salida");
        return dtoSalida;
    }
    
    /**
     * @modified mmaidana
     * @date 03/11/2005
     * Se modifico query para que muestre la descripcion del estado de reclamo
     * y no su OID (Inc. BELC300021328).
     * */
    public RecordSet consultarReclamosCliente(DTOOIDPaginado dtoe) throws MareException {
        UtilidadesLog.info("DAOInformesReclamos.consultarReclamosCliente(DTOOIDPaginado):Entrada");
        
        UtilidadesLog.debug("DTOEntrada: "+dtoe);
        
        StringBuffer consulta = new StringBuffer();
        Vector parametros = new Vector();
        String codigoError = null;
        RecordSet resultado = null;
/*
        
        consulta.append(" SELECT cr.oid_cabe_recl OID, sc.val_nume_soli numerosolicitud, cr.NUM_RECL numeroreclamo,  ");
        consulta.append("       pq_apl_aux.Valor_Gen_I18n_Sicc(? , er.oid_esta_recl ,'REC_ESTAD_RECLA') estadoreclamo, ");
        consulta.append("       cr.num_tota_envi totalenvia, cr.num_tota_devu totaldevuelve, cr.imp_sald_paga saldopaga ");
        consulta.append("  FROM rec_cabec_recla cr, ");
        consulta.append("       ped_solic_cabec sc, ");
        consulta.append("       rec_estad_recla er ");
        consulta.append(" WHERE cr.soca_oid_soli_cabe = sc.oid_soli_cabe ");
        consulta.append("   AND cr.esre_oid_esta_recl = er.oid_esta_recl ");
        consulta.append("   AND cr.clie_oid_clie = ? ");
        parametros.add(dtoe.getOidIdioma());
        parametros.add(dtoe.getOid());*/
        
        
        consulta.append(" SELECT   CR.OID_CABE_RECL OID, ");
        consulta.append("          SC.VAL_NUME_SOLI NUMEROSOLICITUD, ");
        consulta.append("          CR.NUM_RECL NUMERORECLAMO, ");
        consulta.append("          PQ_APL_AUX.VALOR_GEN_I18N_SICC( ? , ER.OID_ESTA_RECL,'REC_ESTAD_RECLA') ESTADORECLAMO, ");
        parametros.add(dtoe.getOidIdioma());
        consulta.append("          CR.NUM_TOTA_ENVI TOTALENVIA, ");
        consulta.append("          CR.NUM_TOTA_DEVU TOTALDEVUELVE, ");
        consulta.append("          CR.IMP_SALD_PAGA SALDOPAGA, ");
        consulta.append("          CR.FEC_INGR , ");
        consulta.append("          PE.VAL_NOMB_PERI PERIREGI, ");
        consulta.append("          PE2.VAL_NOMB_PERI PERIREFE, ");
        
        consulta.append("          (SELECT SUM (PSP.VAL_PREC_TOTA_TOTA_LOCA) ");
        consulta.append("          FROM REC_SOLIC_OPERA RSO, ");
        consulta.append("          PED_SOLIC_POSIC PSP, ");
        consulta.append("          REC_OPERA_RECLA ROR, ");
        consulta.append("          REC_LINEA_OPERA_RECLA LOR, ");
        consulta.append("          PED_SOLIC_CABEC PSC, ");
        consulta.append("          PED_TIPO_SOLIC_PAIS PTSP, ");
        consulta.append("          PED_TIPO_SOLIC PTS ");
        consulta.append("          WHERE RSO.SOCA_OID_SOLI_CABE = PSP.SOCA_OID_SOLI_CABE ");
        consulta.append("            AND RSO.OPRE_OID_OPER_RECL = ROR.OID_OPER_RECL ");
        consulta.append("            AND ROR.CARE_OID_CABE_RECL = CR.OID_CABE_RECL ");
        consulta.append("            AND PSC.OID_SOLI_CABE = PSP.SOCA_OID_SOLI_CABE ");
        consulta.append("            AND lor.PROD_OID_PROD = psp.PROD_OID_PROD ");
        consulta.append("            AND PSC.TSPA_OID_TIPO_SOLI_PAIS = PTSP.OID_TIPO_SOLI_PAIS ");
        consulta.append("            AND PTSP.TSOL_OID_TIPO_SOLI = PTS.OID_TIPO_SOLI ");
        consulta.append("            AND LOR.OPRE_OID_OPER_RECL = ROR.OID_OPER_RECL ");
        consulta.append("            AND LOR.TIMO_OID_TIPO_MOVI = "+ ConstantesREC.TIPO_MOVIMIENTO_ENVIA );
        consulta.append("            AND PTS.IND_SOLI_NEGA = "+ ConstantesREC.IND_SOLICITUD_NEGATIVA_FALSE );
        consulta.append("            AND PSC.FEC_FACT IS NOT NULL) TOTALCARGO, ");
        consulta.append("          (  (SELECT SUM (PSP.VAL_PREC_TOTA_TOTA_LOCA) ");
        consulta.append("                FROM REC_SOLIC_OPERA RSO, ");
        consulta.append("                     PED_SOLIC_POSIC PSP, ");
        consulta.append("                     REC_OPERA_RECLA ROR, ");
        consulta.append("                     REC_LINEA_OPERA_RECLA LOR, ");
        consulta.append("                     PED_SOLIC_CABEC PSC, ");
        consulta.append("                     PED_TIPO_SOLIC_PAIS PTSP, ");
        consulta.append("                     PED_TIPO_SOLIC PTS ");
        consulta.append("               WHERE RSO.SOCA_OID_SOLI_CABE = PSP.SOCA_OID_SOLI_CABE ");
        consulta.append("                 AND RSO.OPRE_OID_OPER_RECL = ROR.OID_OPER_RECL ");
        consulta.append("                 AND ROR.CARE_OID_CABE_RECL = CR.OID_CABE_RECL ");
        consulta.append("                 AND PSC.OID_SOLI_CABE = PSP.SOCA_OID_SOLI_CABE ");
        consulta.append("                 AND lor.PROD_OID_PROD = psp.PROD_OID_PROD ");
        consulta.append("                 AND PSC.TSPA_OID_TIPO_SOLI_PAIS = PTSP.OID_TIPO_SOLI_PAIS ");
        consulta.append("                 AND PTSP.TSOL_OID_TIPO_SOLI = PTS.OID_TIPO_SOLI ");
        consulta.append("                 AND LOR.OPRE_OID_OPER_RECL = ROR.OID_OPER_RECL ");
        consulta.append("                 AND LOR.TIMO_OID_TIPO_MOVI = "+ConstantesREC.TIPO_MOVIMIENTO_ENVIA);
        consulta.append("                 AND PTS.IND_SOLI_NEGA = "+ ConstantesREC.IND_SOLICITUD_NEGATIVA_FALSE );
        consulta.append("                 AND PSC.FEC_FACT IS NOT NULL) - CR.NUM_TOTA_DEVU) TOTALATENDIDO ");
        
        consulta.append("     FROM REC_CABEC_RECLA CR, ");
        consulta.append("          CRA_PERIO PE, ");
        consulta.append("          CRA_PERIO PE2, ");
        consulta.append("          PED_SOLIC_CABEC SC, ");
        consulta.append("          REC_ESTAD_RECLA ER ");
        consulta.append("    WHERE CR.SOCA_OID_SOLI_CABE = SC.OID_SOLI_CABE ");
        consulta.append("          AND CR.ESRE_OID_ESTA_RECL = ER.OID_ESTA_RECL ");
        consulta.append("          AND CR.CLIE_OID_CLIE = ? ");
        parametros.add(dtoe.getOid());
        consulta.append("          AND PE.OID_PERI = CR.PERD_OID_PERI_RECL ");
        consulta.append("          AND PE2.OID_PERI = CR.PERD_OID_PERI_DOCU_REFE  ");
        consulta.append(" ORDER BY SC.VAL_NUME_SOLI");
         
        
        BelcorpService bs = UtilidadesEJB.getBelcorpService();
        
        String sqlPaginada = this.armarQueryPaginacionEspecial(consulta.toString(), dtoe);
        try {                                                                  
            resultado = bs.dbService.executePreparedQuery(sqlPaginada, parametros);
            UtilidadesLog.debug("Resultado del RecordSet:" + resultado);
        } catch (Exception e) {                                                
            codigoError = CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS;      
            UtilidadesLog.error("*** DAOInformesReclamos.consultarReclamosCliente: Exception",e);
            throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));
        }     
        
        if (resultado.esVacio()) {                                                                               
            UtilidadesLog.debug("****DAOInformesReclamos.consultarReclamosCliente: No hay datos ");				
            throw new MareException(new Exception(), UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE));           
        }

        
        UtilidadesLog.info("DAOInformesReclamos.consultarReclamosCliente(DTOOIDPaginado):Salida");
        return resultado;
    }
    
    public RecordSet consultarDetalleReclamo (DTOOIDPaginado dtoe) throws MareException {
        UtilidadesLog.info("DAOInformesReclamos.consultarDetalleReclamo (DTOOIDPaginado):Entrada");

        UtilidadesLog.info("DTOEntrada: "+dtoe);
        
        StringBuffer consulta = new StringBuffer();
        Vector parametros = new Vector();
        String codigoError = null;
        RecordSet resultado = null;
        
        //SELECT
        consulta.append("SELECT LOR.OID_LINE_OPER_RECL OID, ");
        consulta.append("OP.COD_OPER CODIGOOPERACION, ");
        consulta.append(" PQ_APL_AUX.VALOR_GEN_I18N_SICC( ? , TOP.OID_TIPO_OPER,'REC_TIPOS_OPERA') OPERACION, ");        
        parametros.add(dtoe.getOidIdioma());
        consulta.append(" OPR.NUM_SECU_OPER NUMSECUENCIALOPERACION, ");
        consulta.append(" LOR.NUM_LINE NUMEROLINEA, ");
        consulta.append("  PQ_APL_AUX.VALOR_GEN_I18N_SICC( ? , TMV.OID_TIPO_MOVI, 'REC_TIPO_MOVIM') TIPOMOVIMIENTO, ");        
        parametros.add(dtoe.getOidIdioma());
        consulta.append(" SC.VAL_NUME_SOLI NUMEROSOLICITUD, ");
        //consulta.append(" OD.VAL_CODI_VENT CODIGOVENTA, "); CAMBIO REC-004
        consulta.append(" NVL (OD.VAL_CODI_VENT, AL.COD_VENT_FICT) CODIGOVENTA, ");
        consulta.append(" PRO.COD_SAP CODIGOSAP, ");
        consulta.append("  PQ_APL_AUX.VALOR_GEN_I18N_SICC( ? , PRO.OID_PROD, 'MAE_PRODU') DESCRIPCIONCORTA, ");        
        parametros.add(dtoe.getOidIdioma());
        
        consulta.append(" DECODE(TMV.OID_TIPO_MOVI,"+ConstantesREC.TIPO_MOVIMIENTO_ENVIA );
        consulta.append(        ", ABS (NVL (PSP.NUM_UNID_POR_ATEN, '')),LOR.NUM_UNID_RECL) NUMEROUNIDADESRECLAMADAS, "); 
        consulta.append(" DECODE(TMV.OID_TIPO_MOVI,"+ConstantesREC.TIPO_MOVIMIENTO_ENVIA );
        consulta.append("       , NVL (PSP.VAL_PREC_CATA_UNIT_LOCA, ''), LOR.VAL_PREC) PRECIO, "); 
        consulta.append(" DECODE(TMV.OID_TIPO_MOVI,"+ConstantesREC.TIPO_MOVIMIENTO_ENVIA );
        consulta.append("       , NVL (PSP.VAL_PREC_CONT_UNIT_LOCA, ''),LOR.VAL_PREC_CONT) PRECIOCONTABLE, "); 
        consulta.append(" DECODE(TMV.OID_TIPO_MOVI,"+ConstantesREC.TIPO_MOVIMIENTO_ENVIA );
        consulta.append("       , NVL (PSP.VAL_PREC_FACT_UNIT_LOCA, ''),0) PRECIOFACTURA, "); 
        consulta.append(" DECODE(TMV.OID_TIPO_MOVI,"+ConstantesREC.TIPO_MOVIMIENTO_ENVIA );
        consulta.append("       , NVL (ABS(PSP.NUM_UNID_POR_ATEN) * PSP.VAL_PREC_FACT_UNIT_LOCA,''),0) IMPORTECARGORECLAMADO, "); 
        consulta.append(" DECODE(TMV.OID_TIPO_MOVI,"+ConstantesREC.TIPO_MOVIMIENTO_ENVIA );
        consulta.append("       , NVL (ABS(PSP.NUM_UNID_ATEN) * PSP.VAL_PREC_FACT_UNIT_LOCA,''),0) IMPORTECARGOREALIZADO, "); 

        consulta.append(" LOR.IMP_ABON IMPORTEABONO, ");
        consulta.append(" LOR.NUM_UNID_DEVU UNIDADESDEVUELTAS, ");
        consulta.append(" LOR.IND_ESTA INDICADORESTADO, ");
        //descripcion de MOTIVO DE DEVOLUCION
        consulta.append(" PQ_APL_AUX.VALOR_GEN_I18N_SICC( ? , MD.OID_MOTI_DEVO, 'REC_MOTIV_DEVOL') MOTIVODEVOLUCION, ");
        parametros.add(dtoe.getOidIdioma());
        
        //REC-004
        consulta.append(" CPG.NUM_CONC NUMCONCURSO,  ");
        consulta.append(" PN.NUM_NIVE NUMNIVEL, ");
        consulta.append(" LPA.NUM_PREM NUMPREMIO, ");
        //REC-004
        consulta.append(" PSC.GRPR_OID_GRUP_PROC GP, ");
        consulta.append(" DECODE (tmv.oid_tipo_movi, "+ ConstantesREC.TIPO_MOVIMIENTO_ENVIA );
        consulta.append(", NVL (  psp.num_unid_aten,'' ),0 ) UNIDADESATENDIDAS ");
        //FROM
        consulta.append(" FROM REC_OPERA_RECLA opr, ");
        consulta.append(" REC_TIPOS_OPERA top, ");
        consulta.append(" REC_OPERA op, ");
        consulta.append(" REC_LINEA_OPERA_RECLA lor, ");
        consulta.append(" REC_TIPO_MOVIM tmv, ");
        consulta.append(" PED_SOLIC_CABEC sc, ");
        consulta.append(" PRE_MATRI_FACTU mf, ");
        consulta.append(" PRE_OFERT_DETAL od, ");
        consulta.append(" MAE_PRODU pro, ");
        consulta.append(" REC_MOTIV_DEVOL md, ");
        consulta.append(" REC_SOLIC_OPERA RSO, ");
        consulta.append(" PED_SOLIC_CABEC PSC, ");
        consulta.append(" PED_SOLIC_POSIC psp, ");
        //REC-004
        consulta.append(" inc_concu_param_gener cpg, ");
        consulta.append(" inc_param_nivel_premi pn, ");
        consulta.append(" inc_artic_lote al, ");
        consulta.append(" inc_lote_premi_artic lpa ");
        //REC-004
        //WHERE
        consulta.append(" WHERE OPR.TIOP_OID_TIPO_OPER = TOP.OID_TIPO_OPER ");
        consulta.append(" AND TOP.ROPE_OID_OPER = OP.OID_OPER ");
        consulta.append(" AND OPR.OID_OPER_RECL = LOR.OPRE_OID_OPER_RECL (+) ");
        consulta.append(" AND OPR.SOCA_OID_SOLI_CABE = SC.OID_SOLI_CABE ");
        consulta.append(" AND LOR.TIMO_OID_TIPO_MOVI = TMV.OID_TIPO_MOVI (+) ");
        consulta.append(" AND LOR.MAFA_OID_MATR_FACT = MF.OID_MATR_FACT (+) ");
        consulta.append(" AND MF.OFDE_OID_DETA_OFER = OD.OID_DETA_OFER (+) ");
        consulta.append(" AND LOR.PROD_OID_PROD = PRO.OID_PROD (+) ");
        consulta.append(" AND LOR.MODV_OID_MOTI_DEVO = MD.OID_MOTI_DEVO (+) ");
        consulta.append(" AND OPR.CARE_OID_CABE_RECL = ? ");
        parametros.add(dtoe.getOid());
        //REC-004
        consulta.append(" AND lor.COPA_OID_PARA_GRAL = cpg.OID_PARA_GRAL(+) ");
        consulta.append(" AND lor.PANP_OID_PARA_NIVE_PREM = pn.OID_PARA_NIVE_PREM(+) ");
        consulta.append(" AND lor.LOPA_OID_LOTE_PREM_ARTI = lpa.OID_LOTE_PREM_ARTI(+) ");
        
        //modificado por Sapaza - fecha 15/01/2008 - incidencia SiCC20080543        
        //consulta.append(" AND pro.OID_PROD = al.PROD_OID_PROD(+) ");
        consulta.append(" AND lor.prod_oid_prod = al.prod_oid_prod(+) ");
        consulta.append(" AND lor.lopa_oid_lote_prem_arti = al.lopa_oid_lote_prem_arti(+) ");
        consulta.append(" AND PSC.OID_SOLI_CABE = RSO.SOCA_OID_SOLI_CABE ");
				consulta.append("	AND opr.OID_OPER_RECL = RSO.OPRE_OID_OPER_RECL ");
        consulta.append("	AND LOR.TSPA_OID_TIPO_SOLI_PAIS = RSO.TSPA_OID_TIPO_SOLI_PAIS(+) "); 
        consulta.append("	AND psp.SOCA_OID_SOLI_CABE = psc.OID_SOLI_CABE(+) ");
        consulta.append(" AND lor.PROD_OID_PROD = psp.PROD_OID_PROD ");
        
        //REC-004
        BelcorpService bs = UtilidadesEJB.getBelcorpService();
        
        String sqlPaginada = this.armarQueryPaginacionEspecial(consulta.toString(), dtoe);
        try {                                                                  
            resultado = bs.dbService.executePreparedQuery(sqlPaginada, parametros);
            UtilidadesLog.debug("Resultado del RecordSet:" + resultado);
        } catch (Exception e) {                                                
            codigoError = CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS;      
            UtilidadesLog.error("*** DAOInformesReclamos.consultarReclamosCliente: Exception",e);
            throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));
        }     
        
        if (resultado.esVacio()) {                                                                               
            UtilidadesLog.debug("****DAOInformesReclamos.consultarReclamosCliente: No hay datos ");				
            throw new MareException(new Exception(), UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE));           
        }
        
        UtilidadesLog.info("DAOInformesReclamos.consultarDetalleReclamo (DTOOIDPaginado):Salida");
        return resultado;
    }
    
 private String armarQueryPaginacionEspecial(String consultaOri, DTOSiccPaginacion dto) {
      UtilidadesLog.info("DAOInformesReclamos.armarQueryPaginacionEspecial(String consultaOri, DTOSiccPaginacion dto):Entrada");
      
      Long ultLineaPresentada = dto.getIndicadorSituacion();
      Integer cantidadLineas = dto.getTamanioPagina();

      if ((ultLineaPresentada == null) || (cantidadLineas == null)) {
         return consultaOri;
      } else {
          StringBuffer salida = new StringBuffer();

         if ((consultaOri.toUpperCase().indexOf(" OID,") == -1) &&
                (consultaOri.toUpperCase().indexOf(" OID ") == -1)) {
            throw new RuntimeException("Necesita tener un campo llamado OID");
         }

         salida.append("SELECT * FROM ( SELECT X.*, ");
         salida.append("CASE WHEN (("+ cantidadLineas + " -  COUNT(*)  OVER (PARTITION BY 1)) < 0) THEN 0 ELSE 1 END SICC_ES_ULTIMA_PAGINA ");
         salida.append("FROM (" + consultaOri + " )  X  WHERE ROWNUM <= " +(cantidadLineas.intValue()+1)+ "  AND OID > " +ultLineaPresentada+ ") Y ");
         salida.append(" WHERE ROWNUM <= " + cantidadLineas);
         salida.append(" and OID > " + ultLineaPresentada);

         UtilidadesLog.info("DAOInformesReclamos.armarQueryPaginacionEspecial(String consultaOri, DTOSiccPaginacion dto):Salida");
         return salida.toString();
      }
  } 
}