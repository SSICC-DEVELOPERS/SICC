/**
 * Copyright 2003 © por Indra Sistemas,S.A.. Todos los derechos reservados.
 * Avda. de Bruselas, 35
 * Parque Empresarial Arroyo de la Vega
 * 28108 Alcobendas, Madrid
 * España
 *
 * Privado y Confidencial.
 * La información contenida en este documento es propiedad de Indra sistemas.
 * Para uso exclusivo de empleados autorizados no permitiéndose
 * la distribución de este código sin permiso expreso.
 *
 * @author: Dante Castiglione
 * Fecha: 2005/03/15
 * NOTA: LOS BLOQUES DE CODIGO ESTAN DENTRO DE UN PAR DE LLAVES { }
 * PARA QUE NO SE MEZCLE EL SCOPE DE LOS ATRIBUTOS LOCALES.
 *
 * @author: Gustavo Viñales
 * Fecha: 2005/04/19
 * 
 * @NOTA: Modificado por revision de Auditoria
 * @autor: Paola Cabrera
 * @fecha: 21/09/2005 
 */
package es.indra.sicc.logicanegocio.inc;

import es.indra.mare.common.exception.MareException;
import es.indra.mare.common.mii.MareMiiServiceNotFoundException;
import es.indra.mare.common.mii.services.jdbcservice.RecordSet;

import es.indra.sicc.dtos.inc.DTOEConcursoClientePeriodo;
import es.indra.sicc.dtos.inc.DTOESolicitud;
import es.indra.sicc.dtos.inc.DTOPuntajeProductosExigidos;
import es.indra.sicc.entidades.inc.ProductosLocalHome;
import es.indra.sicc.util.BelcorpService;
import es.indra.sicc.util.CodigosError;
import es.indra.sicc.util.Cronometrador;
import es.indra.sicc.util.DTOOID;
import es.indra.sicc.util.DTOOIDs;
import es.indra.sicc.util.UtilidadesError;
import es.indra.sicc.util.UtilidadesLog;

import java.math.BigDecimal;

import java.sql.Date;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;


public class DAOConcursos {

    public DAOConcursos() {
    }

    /**
     * este metodo retorna los concursos que aplican al proceso de solicitudes
     * de incentivos
     */
    public ArrayList obtenerConcursos() throws MareException {
        UtilidadesLog.info("DAOConcursos.obtenerConcursos():Entrada");

        ArrayList concursosObjetivos = obtenerConcursosObjetivos();
        Iterator concursos = concursosObjetivos.iterator();
        DAOConcursoPremiacion daoC = new DAOConcursoPremiacion();
        DAOConcursos dao = new DAOConcursos();

        while (concursos.hasNext()) {
            Concurso concurso = (Concurso) concursos.next();

            obtenerTipificacionesClientesParticipantes(concurso);
            obtenerEstatusVentaConsultoras(concurso);
            obtenerEstatusFuturoClientes(concurso);
            obtenerCronograma(concurso);
            obtenerExigenciasMinimas(concurso);
            obtenerParametrosNivelPremiacion(concurso);
            obtenerAccesos(concurso);
            obtenerAmbitosGeograficos(concurso);
            obtenerListaProductos(concurso);
            obtenerProductos(concurso);

            daoC.obtenerParametrosGeneralesPremiacion(concurso);
            daoC.obtenerRequisitosPremiacion(concurso);
            daoC.obtenerTipoCursosExigidos(concurso);
            daoC.obtenerProductosExigidos(concurso);
            daoC.obtenerTiposMonto(concurso);
            dao.recuperarVariablesVentaRankingConcurso(concurso);
            // vbongiov 22/9/2005 inc 20940
            this.obtenerPeriodosVigenciaMultinivel(concurso);
            
            //jrivas 25/1/2007 Cambio Dupla Cyzone
            obtenerTipificacionesClientesCalificacion(concurso);
            
            // vbongiov -- Cambio 20080811 -- 26/08/2009
            obtenerParametrosSorteo(concurso);
        }

        UtilidadesLog.info("DAOConcursos.obtenerConcursos():Salida");

        return concursosObjetivos;
    }

    /**
     * @Modificado: Emilio Noziglia
     * @Fecha: 15/06/2005
     * @Referencia: Incidencias BELC300018836 y BELC300019006 (Validado por 
     * Diego Rodriguez)
     * @Recibe: void
     * @Retorna: ArrayList
     * @Descripcion: Este metodo retorna un ArrayList de objetos del tipo
     * Concurso.
     */
    private ArrayList obtenerConcursosObjetivos() throws MareException {
        UtilidadesLog.info("DAOConcursos.obtenerConcursosObjetivos():Entrada");

        BelcorpService bs;
        RecordSet respuesta;
        RecordSet rProdVal;
        RecordSet rProdExc;
        String codigoError;
        StringBuffer query = new StringBuffer();
        StringBuffer queryProdVal = null;
        StringBuffer queryProdExc = null;

        // sapaza -- PER-SiCC-2014-0753 -- 08/09/2014
        String periodoProceso = obtenerPeriodoProceso();
        UtilidadesLog.debug("periodoProceso : " + periodoProceso);

        try {
            bs = BelcorpService.getInstance();
        } catch (MareMiiServiceNotFoundException e) {
            UtilidadesLog.error("ERROR ", e);
            codigoError = CodigosError.ERROR_AL_PEDIR_UN_SERVICIO_MARE;
            throw new MareException(e,
                UtilidadesError.armarCodigoError(codigoError));
        }

        try {
            query.append(" SELECT ");
            query.append(" A.OID_PARA_GRAL, ");
            query.append(" A.NUM_CONC, ");
            
            // sapaza -- PER-SiCC-2013-0744 -- 02/07/2013 
            query.append(" (CASE WHEN (SELECT COUNT(1) FROM INC_CLASI_PARTI_CONCU ");
            query.append("           WHERE COPA_OID_PARA_GRAL = A.OID_PARA_GRAL)> 0 ");
            query.append("     THEN 0 ELSE 1 END) VAL_PART, ");
            //query.append(" C.VAL_PART, ");
            
            query.append(" A.TEXI_OID_TIPO_EXIG, ");
            query.append(" B.TREQ_OID_TIPO_REQU, ");
            query.append(" A.VAL_FALT_NANU, ");
            query.append(" NVL(D.TVEN_OID_TIPO_VENT, N.TVEN_OID_TIPO_VENT ) ");
            query.append(" as TVEN_OID_TIPO_VENT, ");
            query.append(" E.VAL_FACT_CONV, ");
            query.append(" E.NUM_PUNT_ASIG, ");
            query.append(" A.BCAL_OID_BASE_CALC, ");
            
            // sapaza -- PER-SiCC-2013-0744 -- 02/07/2013 
            query.append(" (CASE WHEN (SELECT COUNT(1) FROM INC_PRODU_EXIGI ");
            query.append("            WHERE PRDU_OID_PROD = C.OID_PROD)> 0 ");
            query.append("     THEN 1 ELSE 0 END) IND_PROD_EXIG, ");
            
            query.append(" (CASE WHEN (SELECT COUNT(1) FROM INC_PRODU_BONIF ");
            query.append("            WHERE PRDU_OID_PROD = C.OID_PROD)> 0 ");
            query.append("     THEN 1 ELSE 0 END) IND_PROD_BONI, ");
            
            query.append(" (CASE WHEN (SELECT COUNT(1) FROM INC_PRODU_VALID ");
            query.append("            WHERE PRDU_OID_PROD = C.OID_PROD)> 0 ");
            query.append("     THEN 0 ELSE 1 END) IND_PROD_VALI, ");
            
            query.append(" (CASE WHEN (SELECT COUNT(1) FROM INC_PRODU_EXCLU ");
            query.append("            WHERE PRDU_OID_PROD = C.OID_PROD)> 0 ");
            query.append("     THEN 1 ELSE 0 END) IND_PROD_EXCL, ");

            //query.append(" C.IND_PROD_EXIG, ");
            //query.append(" C.IND_PROD_BONI, ");
            //query.append(" C.IND_PROD_VALI, ");
            //query.append(" C.IND_PROD_EXCL, ");
            
            query.append(" 0 IND_MULT, ");
            
            // sapaza -- PER-SiCC-2013-0744 -- 02/07/2013 
            query.append(" (CASE WHEN (SELECT COUNT(1) FROM INC_PARAM_CALIF ");
            query.append("           WHERE COPA_OID_PARA_GRAL = A.OID_PARA_GRAL)> 0 ");
            query.append("     THEN 1 ELSE 0 END) VAL_FASE_CALI, ");
            //query.append(" C.VAL_FASE_CALI, ");
            
            query.append(" A.DIRI_OID_DIRI, ");
            query.append(" 0 IND_PROG_NUEV, ");
            query.append(" A.PAIS_OID_PAIS as A_PAIS_OID_PAIS, ");
            query.append(" A.MARC_OID_MARC as A_MARC_OID_MARC, ");
            query.append(" A.CANA_OID_CANA as A_CANA_OID_CANA, ");
            
            // sapaza -- PER-SiCC-2013-0744 -- 02/07/2013 
            query.append(" (CASE WHEN (SELECT COUNT(1) FROM INC_AMBIT_GEOGR ");
            query.append("           WHERE COPA_OID_PARA_GRAL = A.OID_PARA_GRAL)> 0 ");
            query.append("     THEN 0 ELSE 1 END) VAL_AMBI_GEOG_COMP, ");
            //query.append(" C.VAL_AMBI_GEOG_COMP, ");
            
            query.append(" A.IND_ANUL, ");
            query.append(" A.IND_DEVO, ");
            query.append(
                " NVL(NVL(D.VAL_PERI_EVAL, N.VAL_PERI_EVAL) , NUM_PEDI_EVAL) VAL_PERI_EVAL, ");

            //jrivas 21/7/2005
            //INC 20044
            //query.append(" V.NUM_PEDI, ");
            query.append(" F.NUM_PERI, ");
            query.append(" D.IMP_MONT_MINI_PEDI, ");
            query.append(" D.NUM_UNID_MINI_PEDI, ");

            // periodo de despacho
            query.append(" F.PERD_OID_PERI, ");
            query.append(" L.COD_PERI as L_COD_PERI, ");
            query.append(" K.FEC_INIC as K_FEC_INIC, ");
            query.append(" K.FEC_FINA as K_FEC_FINA, ");
            query.append(" K.CANA_OID_CANA as K_CANA_OID_CANA, ");
            query.append(" K.MARC_OID_MARC as K_MARC_OID_MARC, ");
            query.append(" K.PAIS_OID_PAIS as K_PAIS_OID_PAIS, ");
            query.append(" K.OID_PERI as K_OID_PERI, ");

            // periodo desde
            query.append(" A.PERD_OID_PERI_DESD, ");
            query.append(" H.COD_PERI as H_COD_PERI, ");
            query.append(" G.FEC_INIC as G_FEC_INIC, ");
            query.append(" G.FEC_FINA as G_FEC_FINA, ");
            query.append(" G.CANA_OID_CANA as G_CANA_OID_CANA, ");
            query.append(" G.MARC_OID_MARC as G_MARC_OID_MARC, ");
            query.append(" G.PAIS_OID_PAIS as G_PAIS_OID_PAIS, ");
            query.append(" G.OID_PERI as G_OID_PERI, ");

            // periodo hasta
            query.append(" A.PERD_OID_PERI_HAST, ");
            query.append(" J.COD_PERI as J_COD_PERI, ");
            query.append(" I.FEC_INIC as I_FEC_INIC, ");
            query.append(" I.FEC_FINA as I_FEC_FINA, ");
            query.append(" I.CANA_OID_CANA as I_CANA_OID_CANA, ");
            query.append(" I.MARC_OID_MARC as I_MARC_OID_MARC, ");
            query.append(" I.PAIS_OID_PAIS as I_PAIS_OID_PAIS, ");
            query.append(" I.OID_PERI as I_OID_PERI, ");

            // multinivel
            query.append(" M.NUM_PERI_PARA_CALC, ");
            query.append(" M.NUM_PERI_SOBR_CALC, ");
            query.append(" M.CPRE_OID_CALC_PREM, ");
            query.append(" M.VAL_PORC_SOBR_VENT, ");
            query.append(" M.IMP_MONT_MINI_MADR, ");
            query.append(" M.NUM_UNID_MINI_MADR, ");
            query.append(" M.NUM_PEDI_MINI_MADR, ");
            query.append(" M.IMP_MONT_MINI_PEDI_HIJA, ");
            query.append(" M.IMP_MONT_MINI_PEDI_POR_HIJA, ");
            query.append(" M.NUM_UNID_MINI_HIJA, ");
            query.append(" M.NUM_UNID_MINI_PEDI_HIJA, ");
            query.append(" M.NUM_PEDI_MINI_HIJA, ");
            query.append(" M.IMP_MONT_MINI_RED, ");
            query.append(" M.NUM_UNID_MINI_RED, ");
            query.append(" M.NUM_PEDI_MINI_RED, ");

            // concurso parametros gerente
            //jrivas 22/8/2005
            //inc 20672
            query.append(
                "  NVL(D.IND_RECO_EFEC, N.VAL_RECO_EFEC) VAL_RECO_EFEC, ");

            query.append(" N.FCAL_OID_FORM_CALC, ");
            query.append(" A.IND_RANK, ");

            //Agregado jrivas 28/7/2005 inc 20276
            query.append(" E.IND_ACTI, ");
            query.append(" E.IND_CONS, ");
            
            //INC-46 jrivas 28/3/2006
            query.append(" F.VAL_HAST_NIVE, ");
            
            //INC-114 vbongiov - 7/06/2006
            query.append(" rank.TPRK_OID_TIPO_RANK, ");

            // BELC300024408 - gPineda - 02/11/2006
            query.append(" rank.AGRA_OID_AGRU_RANK ,");

            // sapaza -- PER-SiCC-2013-0875 -- 13/08/2013
            query.append(" NVL (d.PERD_OID_PERI_INIC_EVAL, a.PERD_OID_PERI_DESD) PERIODOINICIALVINC , ");
            
            //gPineda BELC300024320
            query.append(" dPremi.IND_COMU_DESP_AUTO, "); 
            
            //jrivas 30/1/2007 Cambio Dupla Cyzone
            query.append(" A.IND_DUPL_CYZO, "); 
            
            //jrivas SiCC 20070242  28/5/07
            query.append(" A.VAL_NOMB, "); 
            
            // vbongiov -- Cambio 20080809 -- 7/04/2009
            query.append(" A.IND_NO_GENE_PUNT "); 
            
            //jrivas 21/8/2008 20080580
            query.append(" , D.IND_GENE_PUNT_A_RECO, D.COPA_CONC_PUNT_RECO ");    
            
            // vbongiov -- Cambio 20090942 -- 28/07/2009
            query.append(" , A.CCON_OID_CLAS_CONC ");  
            
            // vbongiov -- Cambio 20080811 -- 26/08/2009
            query.append(" , 0 IND_SORT ");  

            // sapaza -- PER-SiCC-2010-0479 -- 25/08/2010
            query.append(" , E.VAL_TEXT_RANK ");  
            
            // sapaza -- PER-SiCC-2013-0044 -- 28/01/2013
            query.append(" , D.IND_TIPO_EVAL_MONT ");  
            
            // sapaza -- PER-SiCC-2013-0608 -- 03/06/2013
            query.append(" ,F.PERD_OID_PERI_INIC, "); 
            query.append(" N1.COD_PERI as N_COD_PERI, ");
            query.append(" M1.FEC_INIC as M_FEC_INIC, ");
            query.append(" M1.FEC_FINA as M_FEC_FINA, ");
            query.append(" M1.CANA_OID_CANA as M_CANA_OID_CANA, ");
            query.append(" M1.MARC_OID_MARC as M_MARC_OID_MARC, ");
            query.append(" M1.PAIS_OID_PAIS as M_PAIS_OID_PAIS, ");
            query.append(" M1.OID_PERI as M_OID_PERI ");
            
             // sapaza -- PER-SiCC-2013-0875 -- 19/08/2013
            query.append(" ,V.IND_DESP_CAMP_PUNT "); 
            
            // sapaza -- PER-SiCC-2015-0063 -- 16/02/2015
            query.append(" ,E.IND_EXIG_CAMP_ANTE ");

            // tablas
            query.append(" FROM INC_CONCU_PARAM_GENER A, ");
            query.append(" INC_PROGR_NUEVA            B, ");
            query.append(" INC_REQUI_PREMI            V, ");
            query.append(" INC_CONCU_PARAM_GEREN      N, ");
            query.append(" INC_MULTI                  M, ");
            
            // sapaza -- PER-SiCC-2013-0744 -- 02/07/2013
            query.append(" INC_PRODU                  C, ");
            //query.append(" INC_PLANT_CONCU            C, ");
            
            query.append(" INC_CONCU_PARAM_CONSU      D, ");
            query.append(" INC_OBTEN_PUNTO            E, ");
            query.append(" INC_PARAM_GENER_PREMI      F, ");
            query.append(" CRA_PERIO                  G, ");
            query.append(" SEG_PERIO_CORPO            H, ");
            query.append(" CRA_PERIO                  I, ");
            query.append(" SEG_PERIO_CORPO            J, ");
            query.append(" CRA_PERIO                  K, ");
            query.append(" SEG_PERIO_CORPO            L, ");
            
            // sapaza -- PER-SiCC-2013-0608 -- 03/06/2013
            query.append(" CRA_PERIO                  M1, ");
            query.append(" SEG_PERIO_CORPO            N1, ");
            
            query.append(" INC_PARAM_RANKI            rank, ");

            query.append(" INC_DESPA_PREMI            dPremi ");
            
            // condiciones
            query.append(" WHERE A.IND_ACTI         != 0 ");
            query.append(
                " AND A.OID_PARA_GRAL       = B.COPA_OID_PARA_GRAL(+) ");
            query.append(
                " AND A.OID_PARA_GRAL       = V.COPA_OID_PARA_GRAL(+) ");
                
            // sapaza -- PER-SiCC-2013-0744 -- 02/07/2013                
            query.append(" AND A.OID_PARA_GRAL  = C.COPA_OID_PARA_GRAL(+) ");
            //query.append(" AND A.PLC2_OID_PLAN_CONC  = C.OID_PLAN_CONC(+) ");
            
            query.append(
                " AND A.OID_PARA_GRAL       = D.COPA_OID_PARA_GRAL(+) ");
            query.append(
                " AND A.OID_PARA_GRAL       = E.COPA_OID_PARA_GRAL(+) ");
            query.append(
                " AND A.OID_PARA_GRAL       = F.COPA_OID_PARA_GRAL(+) ");
            query.append(
                " AND A.OID_PARA_GRAL       = M.COPA_OID_PARA_GRAL(+) ");
            query.append(
                " AND A.OID_PARA_GRAL       = N.COPA_OID_PARA_GRAL(+) ");
            query.append(" AND A.PERD_OID_PERI_DESD  = G.OID_PERI(+) ");
            query.append(" AND G.PERI_OID_PERI       = H.OID_PERI(+) ");
            query.append(" AND A.PERD_OID_PERI_HAST  = I.OID_PERI(+) ");
            query.append(" AND I.PERI_OID_PERI       = J.OID_PERI(+) ");
            query.append(" AND F.PERD_OID_PERI       = K.OID_PERI(+) ");
            query.append(" AND K.PERI_OID_PERI       = L.OID_PERI(+) ");
            
            // sapaza -- PER-SiCC-2013-0608 -- 03/06/2013
            query.append(" AND F.PERD_OID_PERI_INIC  = M1.OID_PERI(+) ");
            query.append(" AND M1.PERI_OID_PERI       = N1.OID_PERI(+) ");
            
            query.append(" AND A.OID_PARA_GRAL       = rank.COPA_OID_PARA_GRAL(+) ");    
            
            query.append(" AND A.OID_PARA_GRAL       = dPremi.COPA_OID_PARA_GRAL(+) ");
            
            respuesta = bs.dbService.executeStaticQuery(query.toString());
            UtilidadesLog.debug("obtenerConcursosObjetivos respuesta" +
                respuesta);
        } catch (Exception e) {
            UtilidadesLog.error("ERROR ", e);
            codigoError = CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS;
            throw new MareException(e,
                UtilidadesError.armarCodigoError(codigoError));
        }

        if (respuesta.esVacio()) {
            UtilidadesLog.info(
                "DAOConcursos.obtenerConcursosObjetivos():Salida");

            return new ArrayList();
        } else {
            ArrayList output = new ArrayList();

            for (int i = 0; i < respuesta.getRowCount(); i++) {
                queryProdVal = new StringBuffer();
                queryProdExc = new StringBuffer();

                Concurso concurso = new Concurso();
                
                // sapaza -- PER-SiCC-2014-0753 -- 10/09/2014
                concurso.setPeriodoProceso(periodoProceso);
                
                concurso.setOidConcurso(new Long(
                        ((BigDecimal) respuesta.getValueAt(i, "OID_PARA_GRAL"))
                            .longValue()));
                concurso.setNumeroConcurso((String) respuesta.getValueAt(i,
                        "NUM_CONC"));
                        
                //jrivas SiCC 20070242  28/5/07                        
                concurso.setNombreConcurso((String) respuesta.getValueAt(i, "VAL_NOMB"));
                        
                //jrivas 30/1/2007 Cambio Dupla Cyzone
                BigDecimal indDuplaCyzone = (BigDecimal) respuesta.getValueAt(i,
                        "IND_DUPL_CYZO");
                concurso.setIndDuplaCyzone((indDuplaCyzone != null)
                    ? (indDuplaCyzone.intValue() == 1) : false);
                    
                    
                // vbongiov -- Cambio 20080809 -- 7/04/2009
                BigDecimal indNoGeneraPunt = (BigDecimal) respuesta.getValueAt(i,
                        "IND_NO_GENE_PUNT");
                concurso.setIndNoGeneraPunt((indNoGeneraPunt != null)
                    ? (indNoGeneraPunt.intValue() == 1) : false);

                //Agregado jrivas 28/7/2005 inc 20276
                BigDecimal indActividad = (BigDecimal) respuesta.getValueAt(i,
                        "IND_ACTI");
                concurso.setIndActividad((indActividad != null)
                    ? (indActividad.intValue() == 1) : false);
                    
                //jrivas 21/8/2008 20080580
                BigDecimal indGenreaPuntajeRecda = (BigDecimal) respuesta.getValueAt(i, "IND_GENE_PUNT_A_RECO");
                concurso.setIndGeneraPuntajeRecda((indGenreaPuntajeRecda != null)
                    ? (indGenreaPuntajeRecda.intValue() == 1) : false);
                BigDecimal concursoPuntajeRecda = (BigDecimal) respuesta.getValueAt(i, "COPA_CONC_PUNT_RECO");
                concurso.setConcursoPuntajeRecda((concursoPuntajeRecda != null)
                    ? new Long(concursoPuntajeRecda.longValue()) : new Long(0));                
                
                if (concursoPuntajeRecda != null) {
                    StringBuffer queryAux = new StringBuffer();
                    RecordSet rsAux = new RecordSet();

                    queryAux.append(" SELECT VAL_FACT_CONV, ");
                    queryAux.append(" NUM_PUNT_ASIG ");
                    queryAux.append(" FROM INC_OBTEN_PUNTO ");
                    queryAux.append(" WHERE COPA_OID_PARA_GRAL = " + concursoPuntajeRecda);

                    try {
                        rsAux = bs.dbService.executeStaticQuery(queryAux.toString());
                        UtilidadesLog.debug(" rsAux " + rsAux);
                    } catch (Exception e) {
                        UtilidadesLog.error("ERROR ", e);
                        throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS));
                    }
                    BigDecimal factorConcuRecda = (BigDecimal) rsAux.getValueAt(0, "VAL_FACT_CONV");
                    concurso.setFactorConversionConcursoRedca((factorConcuRecda != null) ? new Double(factorConcuRecda.longValue()) : new Double(1));
                
                    BigDecimal puntoAsignarConcuRecda = (BigDecimal) rsAux.getValueAt(0, "NUM_PUNT_ASIG");
                    concurso.setPuntosAsignarConcuRedca((puntoAsignarConcuRecda != null) ? new Double(puntoAsignarConcuRecda.longValue()) : new Double(1));
                    
                }                    

                
                //INC-46 jrivas 28/3/2006
                BigDecimal hastaNivel = (BigDecimal) respuesta.getValueAt(i ,"VAL_HAST_NIVE");
                concurso.setHastaNivelPremiacion((hastaNivel != null)
                    ? new Long(hastaNivel.longValue()) : new Long(0));                
                
                BigDecimal indConstancia = (BigDecimal) respuesta.getValueAt(i,
                        "IND_CONS");
                concurso.setIndConstancia((indConstancia != null)
                    ? (indConstancia.intValue() == 1) : false);

                // periodo desde
                Long periodoDesdeDB = new Long(((BigDecimal) 
                    respuesta.getValueAt(i, "PERD_OID_PERI_DESD"))
                        .longValue());

                Periodo periodoDesde = new Periodo();
                if (periodoDesdeDB != null) {
                    periodoDesde.setCodperiodo((String) respuesta.getValueAt(
                            i, "H_COD_PERI"));
                    periodoDesde.setFechaDesde((Date) respuesta.getValueAt(i,
                            "G_FEC_INIC"));
                    periodoDesde.setFechaHasta((Date) respuesta.getValueAt(i,
                            "G_FEC_FINA"));
                    periodoDesde.setOidCanal(new Long(
                            ((BigDecimal) respuesta.getValueAt(i,
                                "G_CANA_OID_CANA")).longValue()));
                    periodoDesde.setOidMarca(new Long(
                            ((BigDecimal) respuesta.getValueAt(i,
                                "G_MARC_OID_MARC")).longValue()));
                    periodoDesde.setOidPais(new Long(
                            ((BigDecimal) respuesta.getValueAt(i,
                                "G_PAIS_OID_PAIS")).longValue()));
                    periodoDesde.setOidPeriodo(new Long(((BigDecimal) 
                        respuesta.getValueAt(i, "G_OID_PERI")).longValue()));
                    concurso.setPeriodoDesde(periodoDesde);
                }

                // periodo hasta
                Long periodoHastaDB = new Long(((BigDecimal) 
                    respuesta.getValueAt(i, "PERD_OID_PERI_HAST"))
                        .longValue());

                Periodo periodoHasta = new Periodo();
                if (periodoHastaDB != null) {
                    periodoHasta.setCodperiodo((String) respuesta.getValueAt(
                            i, "J_COD_PERI"));
                    periodoHasta.setFechaDesde((Date) respuesta.getValueAt(i,
                            "I_FEC_INIC"));
                    periodoHasta.setFechaHasta((Date) respuesta.getValueAt(i,
                            "I_FEC_FINA"));
                    periodoHasta.setOidCanal(new Long(
                            ((BigDecimal) respuesta.getValueAt(i,
                                "I_CANA_OID_CANA")).longValue()));
                    periodoHasta.setOidMarca(new Long(
                            ((BigDecimal) respuesta.getValueAt(i,
                                "I_MARC_OID_MARC")).longValue()));
                    periodoHasta.setOidPais(new Long(
                            ((BigDecimal) respuesta.getValueAt(i,
                                "I_PAIS_OID_PAIS")).longValue()));
                    periodoHasta.setOidPeriodo(new Long(((BigDecimal) 
                        respuesta.getValueAt(i, "I_OID_PERI")).longValue()));
                    concurso.setPeriodoHasta(periodoHasta);
                }

                BigDecimal participacion = (BigDecimal) respuesta.getValueAt(i,
                        "VAL_PART");

                if (participacion == null) {
                    concurso.setParticipacionParticipantesCompleta(false);
                } else {
                    if (participacion.doubleValue() > 0) {
                        concurso.setParticipacionParticipantesCompleta(true);
                    } else {
                        concurso.setParticipacionParticipantesCompleta(false);
                    }
                }

                BigDecimal oidTipoExigencia = (BigDecimal) 
                    respuesta.getValueAt(i, "TEXI_OID_TIPO_EXIG");
                concurso.setOidTipoExigencia((oidTipoExigencia != null)
                    ? new Long(oidTipoExigencia.longValue()) : null);

                BigDecimal faltantes = (BigDecimal) respuesta.getValueAt(i,
                        "VAL_FALT_NANU");

                if (faltantes == null) {
                    concurso.setIndFaltantesAnunciados(false);
                } else {
                    if (faltantes.doubleValue() > 0) {
                        concurso.setIndFaltantesAnunciados(true);
                    } else {
                        concurso.setIndFaltantesAnunciados(false);
                    }
                }

                // Viviana Bongiovanni -- INC97 -- 17/05/2006
                concurso.setDirigidoA(new Long(
                        ((BigDecimal) respuesta.getValueAt(i, "DIRI_OID_DIRI"))
                            .longValue()));
                            
                if(ConstantesINC.TIPO_CONSULTORA.equals(concurso.getDirigidoA())){
                    concurso.setFormaCalculo(ConstantesINC.OID_FORMA_CALC_BASE_CALC);
                } else {
                    concurso.setFormaCalculo(BigToLong(respuesta.getValueAt(i,
                                "FCAL_OID_FORM_CALC")));
                }
                
                if (!ConstantesINC.OID_FORMA_CALC_VARIABLES_VTA.equals(
                            concurso.getFormaCalculo())) {
                    BigDecimal oidBaseCalculo = (BigDecimal) 
                        respuesta.getValueAt(i,"BCAL_OID_BASE_CALC");
                    concurso.setBaseCalculo((oidBaseCalculo != null)
                        ? new Long(oidBaseCalculo.longValue()) : null);
                } else {
                    // Forma de calculo: Variable de Venta
                    concurso.setBaseCalculo(ConstantesINC
                        .OID_BASE_CALCULO_MONTO);
                }

                if (!ConstantesINC.OID_FORMA_CALC_VARIABLES_VTA.equals(concurso.getFormaCalculo())) {
                
                    if(ConstantesINC.OID_BASE_CALCULO_MONTO.equals(concurso.getBaseCalculo())) {
                        BigDecimal oidTipoVenta = (BigDecimal) respuesta.getValueAt(i,"TVEN_OID_TIPO_VENT");
                        concurso.setTipoVenta((oidTipoVenta != null)? new Long(oidTipoVenta.longValue()): null);
                    } else {
                        concurso.setTipoVenta(ConstantesINC.TIPO_VENTA_CATALOGO);
                    }
                    
                } else {
                    // Forma de calculo: Variable de Venta
                    concurso.setTipoVenta(ConstantesINC.TIPO_VENTA_CATALOGO);
                }

                BigDecimal factor = (BigDecimal) respuesta.getValueAt(i,
                        "VAL_FACT_CONV");
                concurso.setFactorConversion((factor != null)
                    ? new Double(factor.longValue()) : new Double(1));

                BigDecimal puntoAsignar = (BigDecimal) respuesta.getValueAt(i,
                        "NUM_PUNT_ASIG");
                concurso.setPuntosAsignar((puntoAsignar != null)
                    ? new Double(puntoAsignar.longValue()) : new Double(1));

                
                BigDecimal indProductosExigidos = (BigDecimal) 
                    respuesta.getValueAt(i, "IND_PROD_EXIG");

                if (indProductosExigidos == null) {
                    concurso.setIndProductosExigidos(false);
                } else {
                    if (indProductosExigidos.doubleValue() > 0) {
                        concurso.setIndProductosExigidos(true);
                    } else {
                        concurso.setIndProductosExigidos(false);
                    }
                }

                BigDecimal indProductosBonificados = (BigDecimal) 
                    respuesta.getValueAt(i,"IND_PROD_BONI");

                if (indProductosBonificados == null) {
                    concurso.setIndProductosBonificados(false);
                } else {
                    if (indProductosBonificados.doubleValue() > 0) {
                        concurso.setIndProductosBonificados(true);
                    } else {
                        concurso.setIndProductosBonificados(false);
                    }
                }
                
                // vbongiov -- Cambio 20090942 -- 28/07/2009
                BigDecimal oidClasificacionConcurso = (BigDecimal)respuesta.getValueAt(i,"CCON_OID_CLAS_CONC");
                     
                concurso.setOidClasificacionConcurso((oidClasificacionConcurso!= null)? Long.valueOf(oidClasificacionConcurso.toString()):null);

                // sapaza -- PER-SiCC-2010-0479 -- 25/08/2010
                concurso.setTextoRanking((String) respuesta.getValueAt(i, "VAL_TEXT_RANK"));

                // sapaza -- PER-SiCC-2013-0044 -- 28/01/2013
                BigDecimal indTipoEvaluacion = (BigDecimal) respuesta.getValueAt(i, "IND_TIPO_EVAL_MONT");
                if(indTipoEvaluacion != null) {
                    concurso.setIndTipoEvaluacion(indTipoEvaluacion.longValue());
                } else {
                    concurso.setIndTipoEvaluacion(null);
                }
                
                 // sapaza -- PER-SiCC-2013-0875 -- 19/08/2013
                BigDecimal indDespachoPremio = (BigDecimal) respuesta.getValueAt(i, "IND_DESP_CAMP_PUNT");
                if(indDespachoPremio != null) {
                    concurso.setIndDespachoPremio(indDespachoPremio.longValue());
                } else {
                    concurso.setIndDespachoPremio(null);
                }
                
                // sapaza -- PER-SiCC-2015-0063 -- 16/02/2015
                String indExigCampAnte = (String) 
                    respuesta.getValueAt(i,"IND_EXIG_CAMP_ANTE");

                if (indExigCampAnte == null) {
                    concurso.setIndExigCampAnte(false);
                } else {
                    if (Integer.parseInt(indExigCampAnte) > 0) {
                        concurso.setIndExigCampAnte(true);
                    } else {
                        concurso.setIndExigCampAnte(false);
                    }
                }
                
                // Inc 20653
                // Viviana Bongiovanni
                BigDecimal indRanking = (BigDecimal) respuesta.getValueAt(i,
                        "IND_RANK");

                if (indRanking.intValue() == 0) {
                    // Concurso 
                    BigDecimal indProductosValidosCompletos = (BigDecimal) 
                        respuesta.getValueAt(i,"IND_PROD_VALI");

                    if (indProductosValidosCompletos == null) {
                        concurso.setIndProductosValidosCompletos(false);
                    } else {
                        if (indProductosValidosCompletos.doubleValue() > 0) {
                            concurso.setIndProductosValidosCompletos(true);
                        } else {
                            concurso.setIndProductosValidosCompletos(false);
                        }
                    }

                    BigDecimal indProductosExcluidos = (BigDecimal)
                        respuesta.getValueAt(i, "IND_PROD_EXCL");

                    if (indProductosExcluidos == null) {
                        concurso.setIndProductosExcluidos(false);
                    } else {
                        if (indProductosExcluidos.doubleValue() > 0) {
                            concurso.setIndProductosExcluidos(true);
                        } else {
                            concurso.setIndProductosExcluidos(false);
                        }
                    }
                    
                    // BELC300024320 - gPineda - 13/10/06
                    BigDecimal comunicacionDespachoAutomatico = (BigDecimal)
                        respuesta.getValueAt(i, "IND_COMU_DESP_AUTO");
                    if( comunicacionDespachoAutomatico != null 
                          && comunicacionDespachoAutomatico.intValue() == 1)
                    {
                      concurso.setComunicacionDespachoAutomatico( true );
                    }else{
                      concurso.setComunicacionDespachoAutomatico( false );
                    }
                    
                    
                } else {
                    // Concurso de Ranking
                    
                    BigDecimal tipoRanking = (BigDecimal)respuesta.getValueAt(i,"TPRK_OID_TIPO_RANK");
                    concurso.setTipoRanking((tipoRanking != null)? new Long(tipoRanking.longValue()): null);
                    
                    //BELC300024408 - gPineda - 02/11/2006
                    BigDecimal nivelAgrupamiento = (BigDecimal)respuesta.getValueAt(i,"AGRA_OID_AGRU_RANK");
                    concurso.setNivelAgrupacionRanking( nivelAgrupamiento!=null? new Long(nivelAgrupamiento.longValue()):null);
                    
                    try {
                        // Productos validos
                        queryProdVal.append("SELECT COUNT(1) cantProdVal");
                        queryProdVal.append(" FROM INC_PRODU prod, ");
                        queryProdVal.append(" INC_PRODU_VALID prodVal ");
                        queryProdVal.append(" WHERE prod.COPA_OID_PARA_GRAL = "
                            + concurso.getOidConcurso());
                        queryProdVal.append(" AND prodVal.PRDU_OID_PROD = ");
                        queryProdVal.append(" prod.OID_PROD ");

                        rProdVal = bs.dbService.executeStaticQuery(
                            queryProdVal.toString());
                        UtilidadesLog.debug(
                            "obtenerConcursosObjetivos rProdVal" + rProdVal);

                        BigDecimal cantProdVal = (BigDecimal) 
                            respuesta.getValueAt(i,"cantProdVal");

                        if (cantProdVal.intValue() > 0) {
                            concurso.setIndProductosValidosCompletos(false);
                        } else {
                            concurso.setIndProductosValidosCompletos(true);
                        }

                        // Productos excluidos
                        queryProdExc.append("SELECT COUNT(1) cantProdExc");
                        queryProdExc.append(
                            " FROM INC_PRODU prod, INC_PRODU_EXCLU prodExc ");
                        queryProdExc.append(" WHERE prod.COPA_OID_PARA_GRAL = " 
                            + concurso.getOidConcurso());
                        queryProdExc.append(
                            " AND prodExc.PRDU_OID_PROD = prod.OID_PROD ");

                        rProdExc = bs.dbService.executeStaticQuery(
                            queryProdExc.toString());
                        UtilidadesLog.debug(
                            "obtenerConcursosObjetivos rProdExc" + rProdExc);

                        BigDecimal cantProdExc = (BigDecimal) 
                            respuesta.getValueAt(i, "cantProdExc");

                        if (cantProdExc.intValue() > 0) {
                            concurso.setIndProductosExcluidos(true);
                        } else {
                            concurso.setIndProductosExcluidos(false);
                        }
                    } catch (Exception e) {
                        UtilidadesLog.error("ERROR ", e);
                        codigoError = CodigosError
                            .ERROR_DE_LECTURA_EN_BASE_DE_DATOS;
                        throw new MareException(e,
                            UtilidadesError.armarCodigoError(codigoError));
                    }
                }

                BigDecimal indMultiNivel = (BigDecimal) respuesta.getValueAt(i,
                        "IND_MULT");

                if (indMultiNivel == null) {
                    concurso.setMultiNivel(false);
                } else {
                    if (indMultiNivel.doubleValue() > 0) {
                        concurso.setMultiNivel(true);
                    } else {
                        concurso.setMultiNivel(false);
                    }
                }

                BigDecimal programaNuevas = (BigDecimal) 
                    respuesta.getValueAt(i, "IND_PROG_NUEV");

                if (programaNuevas == null) {
                    concurso.setProgramaNuevas(false);
                } else {
                    if (programaNuevas.doubleValue() > 0) {
                        concurso.setProgramaNuevas(true);
                    } else {
                        concurso.setProgramaNuevas(false);
                    }
                }

                {
                    BigDecimal montoMinimoPedido = (BigDecimal) 
                        respuesta.getValueAt(i, "IMP_MONT_MINI_PEDI");
                    concurso.setMontoMinimoPedido((montoMinimoPedido != null)
                        ? montoMinimoPedido : new BigDecimal(0));
                    UtilidadesLog.debug("concurso.getMontoMinimoPedido: " +
                        concurso.getMontoMinimoPedido());
                }

                {
                    BigDecimal unidadesMinimasPedido = (BigDecimal) 
                        respuesta.getValueAt(i, "NUM_UNID_MINI_PEDI");
                    concurso.setUnidadesMinimasPedido((
                        unidadesMinimasPedido != null)
                        ? new Long(unidadesMinimasPedido.longValue())
                        : new Long(0));
                }

                //periodo de despacho
                BigDecimal periodoDeDespachoDB = (BigDecimal) 
                    respuesta.getValueAt(i,"PERD_OID_PERI");

                if (periodoDeDespachoDB != null) {
                    Periodo periodoDeDespacho = new Periodo();
                    periodoDeDespacho.setCodperiodo((String) 
                        respuesta.getValueAt(i, "L_COD_PERI"));
                    periodoDeDespacho.setFechaDesde((Date) 
                    respuesta.getValueAt(i, "K_FEC_INIC"));
                    periodoDeDespacho.setFechaHasta((Date) 
                    respuesta.getValueAt(i, "K_FEC_FINA"));
                    periodoDeDespacho.setOidCanal(new Long(
                            ((BigDecimal) respuesta.getValueAt(i,
                                "K_CANA_OID_CANA")).longValue()));
                    periodoDeDespacho.setOidMarca(new Long(
                            ((BigDecimal) respuesta.getValueAt(i,
                                "K_MARC_OID_MARC")).longValue()));
                    periodoDeDespacho.setOidPais(new Long(
                            ((BigDecimal) respuesta.getValueAt(i,
                                "K_PAIS_OID_PAIS")).longValue()));
                    periodoDeDespacho.setOidPeriodo(new Long(
                            ((BigDecimal) 
                                respuesta.getValueAt(i, "K_OID_PERI"))
                                .longValue()));
                    concurso.setPeriodoDeDespacho(periodoDeDespacho);
                }
                
                // sapaza -- PER-SiCC-2013-0608 -- 03/06/2013
                BigDecimal periodoInicioDeDespachoDB = (BigDecimal) 
                    respuesta.getValueAt(i,"PERD_OID_PERI_INIC");

                if (periodoInicioDeDespachoDB != null) {
                    Periodo periodoInicioDeDespacho = new Periodo();
                    periodoInicioDeDespacho.setCodperiodo((String) 
                        respuesta.getValueAt(i, "N_COD_PERI"));
                    periodoInicioDeDespacho.setFechaDesde((Date) 
                    respuesta.getValueAt(i, "M_FEC_INIC"));
                    periodoInicioDeDespacho.setFechaHasta((Date) 
                    respuesta.getValueAt(i, "M_FEC_FINA"));
                    periodoInicioDeDespacho.setOidCanal(new Long(
                            ((BigDecimal) respuesta.getValueAt(i,
                                "M_CANA_OID_CANA")).longValue()));
                    periodoInicioDeDespacho.setOidMarca(new Long(
                            ((BigDecimal) respuesta.getValueAt(i,
                                "M_MARC_OID_MARC")).longValue()));
                    periodoInicioDeDespacho.setOidPais(new Long(
                            ((BigDecimal) respuesta.getValueAt(i,
                                "M_PAIS_OID_PAIS")).longValue()));
                    periodoInicioDeDespacho.setOidPeriodo(new Long(
                            ((BigDecimal) 
                                respuesta.getValueAt(i, "M_OID_PERI"))
                                .longValue()));
                    concurso.setPeriodoInicioDeDespacho(periodoInicioDeDespacho);
                }

                concurso.setOidPais(new Long(((BigDecimal)
                    respuesta.getValueAt(i, "A_PAIS_OID_PAIS"))
                        .longValue()));
                concurso.setOidMarca(new Long(((BigDecimal) 
                    respuesta.getValueAt(i, "A_MARC_OID_MARC"))
                        .longValue()));
                concurso.setOidCanal(new Long(((BigDecimal) 
                    respuesta.getValueAt(i, "A_CANA_OID_CANA")).longValue()));

                BigDecimal indAmbitoGeograficoCompleto = (BigDecimal) 
                    respuesta.getValueAt(i, "VAL_AMBI_GEOG_COMP");

                if (indAmbitoGeograficoCompleto == null) {
                    concurso.setIndAmbitoGeograficoCompleto(false);
                } else {
                    if (indAmbitoGeograficoCompleto.doubleValue() > 0) {
                        concurso.setIndAmbitoGeograficoCompleto(true);
                    } else {
                        concurso.setIndAmbitoGeograficoCompleto(false);
                    }
                }
                
                // vbongiov -- Cambio 20080811 -- 26/08/2009
                BigDecimal indSorteo = (BigDecimal) 
                     respuesta.getValueAt(i, "IND_SORT");

                if (indSorteo == null) {
                     concurso.setIndSorteo(false);
                } else {
                     if (indSorteo.doubleValue() > 0) {
                         concurso.setIndSorteo(true);
                     } else {
                         concurso.setIndSorteo(false);
                     }
                }

                BigDecimal indAnulacion = (BigDecimal) respuesta.getValueAt(i,
                        "IND_ANUL");

                if (indAnulacion == null) {
                    concurso.setIndAnulacion(false);
                } else {
                    if (indAnulacion.doubleValue() > 0) {
                        concurso.setIndAnulacion(true);
                    } else {
                        concurso.setIndAnulacion(false);
                    }
                }

                BigDecimal indDevolucion = (BigDecimal) respuesta.getValueAt(i,
                        "IND_DEVO");

                if (indDevolucion == null) {
                    concurso.setIndDevolucion(false);
                } else {
                    if (indDevolucion.doubleValue() > 0) {
                        concurso.setIndDevolucion(true);
                    } else {
                        concurso.setIndDevolucion(false);
                    }
                }

                //agregado enozigli 16/05/2005                
                BigDecimal faseCalificacion = (BigDecimal) 
                    respuesta.getValueAt(i, "VAL_FASE_CALI");

                if (faseCalificacion == null) {
                    concurso.setFaseCalificacion(false);
                } else {
                    if (faseCalificacion.doubleValue() > 0) {
                        concurso.setFaseCalificacion(true);
                    } else {
                        concurso.setFaseCalificacion(false);
                    }
                }

                BigDecimal recomendacionEfectiva = 
                    (BigDecimal) respuesta.getValueAt(i, "VAL_RECO_EFEC");

                if (recomendacionEfectiva != null) {
                    if (recomendacionEfectiva.doubleValue() > 0) {
                        concurso.setRecomendacionEfectivaGerente(true);
                    } else {
                        concurso.setRecomendacionEfectivaGerente(false);
                    }
                } else {
                    concurso.setRecomendacionEfectivaGerente(false);
                }

                concurso.setPeriodosEsperaParaCalculo(BigToInteger(
                     respuesta.getValueAt(i, "NUM_PERI_PARA_CALC")));
                concurso.setPeriodosEsperaSobreCalculo(BigToInteger(
                     respuesta.getValueAt(i, "NUM_PERI_SOBR_CALC")));
                concurso.setCalculoPremio(BigToLong(respuesta.getValueAt(i,
                    "CPRE_OID_CALC_PREM")));

                concurso.setPorcentajeSobreVenta((respuesta.getValueAt(i,
                    "VAL_PORC_SOBR_VENT") != null) ? (BigDecimal)
                        respuesta.getValueAt(i, "VAL_PORC_SOBR_VENT")
                            : new BigDecimal(0));
                concurso.setMontoMinimoMadre((respuesta.getValueAt(i,
                    "IMP_MONT_MINI_MADR") != null) ? (BigDecimal) 
                        respuesta.getValueAt(i, "IMP_MONT_MINI_MADR")
                            : new BigDecimal(0));
                concurso.setUnidadesMinimasMadre((respuesta.getValueAt(i,
                    "NUM_UNID_MINI_MADR") != null)? new Integer(
                        ((BigDecimal) respuesta.getValueAt(i,
                            "NUM_UNID_MINI_MADR")).intValue()) :
                                new Integer(0));
                concurso.setNumPedidoMinimoMadre((respuesta.getValueAt(i,
                    "NUM_PEDI_MINI_MADR") != null) ? new Integer(
                        ((BigDecimal) respuesta.getValueAt(i,
                            "NUM_PEDI_MINI_MADR")).intValue()) : 
                                new Integer(0));
                concurso.setMontoMinimoHija((respuesta.getValueAt(i,
                     "IMP_MONT_MINI_PEDI_POR_HIJA") != null)
                        ? (BigDecimal) respuesta.getValueAt(i,
                            "IMP_MONT_MINI_PEDI_POR_HIJA") : 
                                new BigDecimal(0));
                concurso.setUnidadesMinimasHija((respuesta.getValueAt(i,
                        "NUM_UNID_MINI_HIJA") != null)
                        ? new Integer(((BigDecimal) respuesta.getValueAt(i,
                            "NUM_UNID_MINI_HIJA")).intValue()) : 
                                new Integer(0));
                concurso.setNumPedidoMinimoHija((respuesta.getValueAt(i,
                        "NUM_PEDI_MINI_HIJA") != null)
                            ? new Integer(((BigDecimal) respuesta.getValueAt(i,
                                "NUM_PEDI_MINI_HIJA")).intValue()) : 
                                    new Integer(0));
                concurso.setMontoMinimoRed((respuesta.getValueAt(i,
                        "IMP_MONT_MINI_RED") != null)
                    ? (BigDecimal) respuesta.getValueAt(i, "IMP_MONT_MINI_RED")
                    : new BigDecimal(0));
                concurso.setUnidadesMinimasRed((respuesta.getValueAt(i,
                        "NUM_UNID_MINI_RED") != null)
                    ? new Integer(((BigDecimal) respuesta.getValueAt(i,
                        "NUM_UNID_MINI_RED")).intValue()) : new Integer(0));
                concurso.setNumPedidoMinimoRed((respuesta.getValueAt(i,
                        "NUM_PEDI_MINI_RED") != null)
                    ? new Integer(((BigDecimal) respuesta.getValueAt(i,
                         "NUM_PEDI_MINI_RED")).intValue()) : new Integer(0));

                //fin agregado enozigli 16/05/2005 
                // agregado por Viviana Bongiovanni 13/07/2005
                if (indRanking == null) {
                    concurso.setIndRanking(false);
                } else {
                    if (indRanking.doubleValue() > 0) {
                        concurso.setIndRanking(true);
                    } else {
                        concurso.setIndRanking(false);
                    }
                }

                // ultimo periodo a evaluar
                int periodosAEvaluarmenos1;
                int periodoDesdeNueva;
                BigDecimal periodosAEvaluar = (BigDecimal) respuesta.getValueAt(i,
                        "VAL_PERI_EVAL");
                
                //jrivas 8/9/2006 Inc. Aceptacion (F3 Inc. 5)
                BigDecimal oidPeridoInicialVinculacion = (BigDecimal) respuesta.getValueAt(i,
                        "PERIODOINICIALVINC");                
                        
                UtilidadesLog.debug("periodosAEvaluar:  " + periodosAEvaluar);
                UtilidadesLog.debug("PERIODOINICIALVINC:  " + oidPeridoInicialVinculacion);

                if (periodosAEvaluar != null) {
                    //jrivas 8/9/2006 Inc. Aceptacion (F3 Inc. 5)
                    concurso.setNumeroPeriodosAEvaluar(new Long(periodosAEvaluar.longValue()));

                    periodosAEvaluarmenos1 = periodosAEvaluar.intValue() - 1;
                    periodoDesdeNueva = periodosAEvaluar.intValue();
                    UtilidadesLog.debug("periodosAEvaluarmenos1 " + periodosAEvaluarmenos1);

                    StringBuffer query2 = new StringBuffer();
                    RecordSet rs2 = new RecordSet();

                    query2.append(" SELECT p.oid_peri OIDPERIODOFIN, ");
                    query2.append(" p.fec_inic FECHAINIPERIODOFIN, ");
                    query2.append(" p.fec_fina FECHAFINPERIODOFIN, ");
                    query2.append(" pc.cod_peri CODIGOPERIODOFIN, ");
                    query2.append(" p.pais_oid_pais PAISPERIODOFIN, ");
                    query2.append(" p.marc_oid_marc MARCAPERIODOFIN, ");
                    query2.append(" p.cana_oid_cana CANALPERIODOFIN");
                    query2.append(" FROM cra_perio pent, cra_perio p, ");
                    query2.append(" seg_perio_corpo pc ");
                    query2.append(" WHERE pent.oid_peri = ").append(
                        periodoHastaDB);
                    query2.append(" AND p.fec_inic >= pent.fec_inic ");
                    query2.append(" AND pc.oid_peri = p.peri_oid_peri ");
                    query2.append(" AND p.pais_oid_pais =  ");
                    query2.append(" pent.pais_oid_pais ");
                    query2.append(" AND p.marc_oid_marc =  ");
                    query2.append(" pent.marc_oid_marc ");
                    query2.append(" AND p.cana_oid_cana =  ");
                    query2.append(" pent.cana_oid_cana ");
                    query2.append(
                        " ORDER BY p.fec_inic, pc.cod_peri, p.fec_fina ");
                        
                    StringBuffer query3 = new StringBuffer();
                    RecordSet rs3 = new RecordSet();

                    query3.append(" SELECT p.oid_peri OIDPERIODOFIN, ");
                    query3.append(" p.fec_inic FECHAINIPERIODOFIN, ");
                    query3.append(" p.fec_fina FECHAFINPERIODOFIN, ");
                    query3.append(" pc.cod_peri CODIGOPERIODOFIN, ");
                    query3.append(" p.pais_oid_pais PAISPERIODOFIN, ");
                    query3.append(" p.marc_oid_marc MARCAPERIODOFIN, ");
                    query3.append(" p.cana_oid_cana CANALPERIODOFIN");
                    query3.append(" FROM cra_perio pent, cra_perio p, ");
                    query3.append(" seg_perio_corpo pc ");
                    query3.append(" WHERE pent.oid_peri = ").append(
                        periodoDesdeDB);
                    query3.append(" AND p.fec_inic >= pent.fec_inic ");
                    query3.append(" AND pc.oid_peri = p.peri_oid_peri ");
                    query3.append(" AND p.pais_oid_pais =  ");
                    query3.append(" pent.pais_oid_pais ");
                    query3.append(" AND p.marc_oid_marc =  ");
                    query3.append(" pent.marc_oid_marc ");
                    query3.append(" AND p.cana_oid_cana =  ");
                    query3.append(" pent.cana_oid_cana ");
                    query3.append(
                        " ORDER BY p.fec_inic, pc.cod_peri, p.fec_fina ");

                    //jrivas 8/9/2006 Inc. Aceptacion (F3 Inc. 5)
                    //------------------------------------------------------
                    if (oidPeridoInicialVinculacion != null) {
                        StringBuffer query4 = new StringBuffer();
                        RecordSet rs4 = new RecordSet();
    
                        query4.append(" SELECT p.oid_peri OIDPERIODOFIN, ");
                        query4.append(" p.fec_inic FECHAINIPERIODOFIN, ");
                        query4.append(" p.fec_fina FECHAFINPERIODOFIN, ");
                        query4.append(" pc.cod_peri CODIGOPERIODOFIN, ");
                        query4.append(" p.pais_oid_pais PAISPERIODOFIN, ");
                        query4.append(" p.marc_oid_marc MARCAPERIODOFIN, ");
                        query4.append(" p.cana_oid_cana CANALPERIODOFIN");
                        query4.append(" FROM cra_perio pent, cra_perio p, ");
                        query4.append(" seg_perio_corpo pc ");
                        query4.append(" WHERE pent.oid_peri = ").append(
                            oidPeridoInicialVinculacion);
                        query4.append(" AND p.fec_inic >= pent.fec_inic ");
                        query4.append(" AND pc.oid_peri = p.peri_oid_peri ");
                        query4.append(" AND p.pais_oid_pais =  ");
                        query4.append(" pent.pais_oid_pais ");
                        query4.append(" AND p.marc_oid_marc =  ");
                        query4.append(" pent.marc_oid_marc ");
                        query4.append(" AND p.cana_oid_cana =  ");
                        query4.append(" pent.cana_oid_cana ");
                        query4.append(
                            " ORDER BY p.fec_inic, pc.cod_peri, p.fec_fina ");
                        try {
                            rs4 = bs.dbService.executeStaticQuery(query4.toString());
                            UtilidadesLog.debug("******* rs4 " + rs4);
                            
                        } catch (Exception e) {
                            UtilidadesLog.error("ERROR ", e);
                            throw new MareException(e,
                                UtilidadesError.armarCodigoError(
                                    CodigosError
                                        .ERROR_DE_LECTURA_EN_BASE_DE_DATOS));
                        }

                        if (!rs4.esVacio() && (rs4.existeFila(periodoDesdeNueva))){
                            UtilidadesLog.debug("Existe fila periodoFinalEvaluacion");

                            Periodo periodoInicialVinculacion = new Periodo();
                            Periodo periodoFinalEvaluacion = new Periodo();                            

                            periodoInicialVinculacion.setCodperiodo((String) 
                                rs4.getValueAt(0, "CODIGOPERIODOFIN"));
                            periodoInicialVinculacion.setFechaDesde((Date) 
                            rs4.getValueAt(0, "FECHAINIPERIODOFIN"));
                            periodoInicialVinculacion.setFechaHasta((Date) 
                            rs4.getValueAt(0, "FECHAFINPERIODOFIN"));
                            periodoInicialVinculacion.setOidCanal(new Long(
                                    ((BigDecimal) rs4.getValueAt(0,
                                        "CANALPERIODOFIN")).longValue()));
                            periodoInicialVinculacion.setOidMarca(new Long(
                                    ((BigDecimal) rs4.getValueAt(0,
                                        "MARCAPERIODOFIN")).longValue()));
                            periodoInicialVinculacion.setOidPais(new Long(
                                    ((BigDecimal) rs4.getValueAt(0,
                                        "PAISPERIODOFIN")).longValue()));
                            periodoInicialVinculacion.setOidPeriodo(new Long(
                                    ((BigDecimal) 
                                        rs4.getValueAt(0, "OIDPERIODOFIN"))
                                        .longValue()));
                            concurso.setPeriodoInicialEvaluacion(periodoInicialVinculacion);
    
                            // datos del ultimo periodo a evaluar
                            BigDecimal bdOidPerEva = (BigDecimal) 
                                rs4.getValueAt(periodoDesdeNueva,"OIDPERIODOFIN");
                            Date fechaInicioPerEva = (Date)
                                rs4.getValueAt(periodoDesdeNueva,
                                    "FECHAINIPERIODOFIN");
                            Date fechaFinPerEva = (Date) 
                                rs4.getValueAt(periodoDesdeNueva,
                                    "FECHAFINPERIODOFIN");
                            String codigoPerEva = (String) 
                                rs4.getValueAt(periodoDesdeNueva,
                                    "CODIGOPERIODOFIN");
                            BigDecimal paisPerEva = (BigDecimal) 
                                rs4.getValueAt(periodoDesdeNueva, "PAISPERIODOFIN");
                            BigDecimal marcaPerEva = (BigDecimal) 
                                rs4.getValueAt(periodoDesdeNueva,"MARCAPERIODOFIN");
                            BigDecimal canalPerEva = (BigDecimal)rs4.getValueAt(
                                periodoDesdeNueva, "CANALPERIODOFIN");
    
                            //Seteo de valores para periodo fin
                            periodoFinalEvaluacion.setOidPeriodo(new Long(
                                    bdOidPerEva.longValue()));
                            periodoFinalEvaluacion.setFechaDesde(fechaInicioPerEva);
                            periodoFinalEvaluacion.setFechaHasta(fechaFinPerEva);
                            periodoFinalEvaluacion.setCodperiodo(codigoPerEva);
                            periodoFinalEvaluacion.setOidPais(new Long(
                                    paisPerEva.longValue()));
                            periodoFinalEvaluacion.setOidMarca(new Long(
                                    marcaPerEva.longValue()));
                            periodoFinalEvaluacion.setOidCanal(new Long(
                                    canalPerEva.longValue()));
    
                            concurso.setPeriodoFinalEvaluacion(periodoFinalEvaluacion);
                        } else {
                            UtilidadesLog.debug("no Existe fila periodoFinalEvaluacion");
                            concurso.setPeriodoInicialEvaluacion(null);
                            concurso.setPeriodoFinalEvaluacion(null);
                        }
                    }
                    //------------------------------------------------------    

                    try {
                        rs2 = bs.dbService.executeStaticQuery(query2.toString());
                        UtilidadesLog.debug("******* rs2 " + rs2);
                        
                        rs3 = bs.dbService.executeStaticQuery(query3.toString());
                        UtilidadesLog.debug("******* rs3 " + rs3);
                        
                    } catch (Exception e) {
                        UtilidadesLog.error("ERROR ", e);
                        throw new MareException(e,
                            UtilidadesError.armarCodigoError(
                                CodigosError
                                    .ERROR_DE_LECTURA_EN_BASE_DE_DATOS));
                    }

                    if (!rs2.esVacio() && (rs2.existeFila(periodosAEvaluarmenos1))){
                        UtilidadesLog.debug("Existe fila");

                        Periodo ultimoPeriodoEvaluar = new Periodo();

                        // datos del ultimo periodo a evaluar
                        BigDecimal bdOidPerEva = (BigDecimal) 
                            rs2.getValueAt(periodosAEvaluarmenos1,"OIDPERIODOFIN");
                        Date fechaInicioPerEva = (Date)
                            rs2.getValueAt(periodosAEvaluarmenos1,
                                "FECHAINIPERIODOFIN");
                        Date fechaFinPerEva = (Date) 
                            rs2.getValueAt(periodosAEvaluarmenos1,
                                "FECHAFINPERIODOFIN");
                        String codigoPerEva = (String) 
                            rs2.getValueAt(periodosAEvaluarmenos1,
                                "CODIGOPERIODOFIN");
                        BigDecimal paisPerEva = (BigDecimal) 
                            rs2.getValueAt(periodosAEvaluarmenos1, "PAISPERIODOFIN");
                        BigDecimal marcaPerEva = (BigDecimal) 
                            rs2.getValueAt(periodosAEvaluarmenos1,"MARCAPERIODOFIN");
                        BigDecimal canalPerEva = (BigDecimal)rs2.getValueAt(
                            periodosAEvaluarmenos1, "CANALPERIODOFIN");

                        //Seteo de valores para periodo fin
                        ultimoPeriodoEvaluar.setOidPeriodo(new Long(
                                bdOidPerEva.longValue()));
                        ultimoPeriodoEvaluar.setFechaDesde(fechaInicioPerEva);
                        ultimoPeriodoEvaluar.setFechaHasta(fechaFinPerEva);
                        ultimoPeriodoEvaluar.setCodperiodo(codigoPerEva);
                        ultimoPeriodoEvaluar.setOidPais(new Long(
                                paisPerEva.longValue()));
                        ultimoPeriodoEvaluar.setOidMarca(new Long(
                                marcaPerEva.longValue()));
                        ultimoPeriodoEvaluar.setOidCanal(new Long(
                                canalPerEva.longValue()));

                        concurso.setUltimoPeridoEvaluar(ultimoPeriodoEvaluar);
                    } else {
                        UtilidadesLog.debug("no Existe fila");
                        concurso.setUltimoPeridoEvaluar(periodoHasta);
                    }

                    if (!rs3.esVacio() && (rs3.existeFila(periodoDesdeNueva))){
                        UtilidadesLog.debug("Existe fila 2");

                        Periodo periodoDesdeN = new Periodo();

                        // datos del ultimo periodo a evaluar
                        BigDecimal bdOidPerEva = (BigDecimal) 
                            rs3.getValueAt(periodoDesdeNueva,"OIDPERIODOFIN");
                        Date fechaInicioPerEva = (Date)
                            rs3.getValueAt(periodoDesdeNueva,
                                "FECHAINIPERIODOFIN");
                        Date fechaFinPerEva = (Date) 
                            rs3.getValueAt(periodoDesdeNueva,
                                "FECHAFINPERIODOFIN");
                        String codigoPerEva = (String) 
                            rs3.getValueAt(periodoDesdeNueva,
                                "CODIGOPERIODOFIN");
                        BigDecimal paisPerEva = (BigDecimal) 
                            rs3.getValueAt(periodoDesdeNueva, "PAISPERIODOFIN");
                        BigDecimal marcaPerEva = (BigDecimal) 
                            rs3.getValueAt(periodoDesdeNueva,"MARCAPERIODOFIN");
                        BigDecimal canalPerEva = (BigDecimal)rs3.getValueAt(
                            periodoDesdeNueva, "CANALPERIODOFIN");

                        //Seteo de valores para periodo fin
                        periodoDesdeN.setOidPeriodo(new Long(
                                bdOidPerEva.longValue()));
                        periodoDesdeN.setFechaDesde(fechaInicioPerEva);
                        periodoDesdeN.setFechaHasta(fechaFinPerEva);
                        periodoDesdeN.setCodperiodo(codigoPerEva);
                        periodoDesdeN.setOidPais(new Long(
                                paisPerEva.longValue()));
                        periodoDesdeN.setOidMarca(new Long(
                                marcaPerEva.longValue()));
                        periodoDesdeN.setOidCanal(new Long(
                                canalPerEva.longValue()));

                        concurso.setPeriodoDesdeNueva(periodoDesdeN);
                    } else {
                        UtilidadesLog.debug("no Existe fila 2");
                        concurso.setPeriodoDesdeNueva(periodoDesde);
                    }
                } else {
                    concurso.setUltimoPeridoEvaluar(periodoHasta);
                    concurso.setPeriodoDesdeNueva(periodoDesde);
                }

                //SELECT APARTE - considerar null
                //ultimoPeriodoPremiacion: Se carga desde 
                // INC:RequisitosPremiacion.numeroPeriodos
                //(se obtiene sumando al periodoHasta del concurso 
                //este valor y se obtiene el periodo que corresponda)
                //haciendo un join con INC:ConcursoParametrosGenerales por 
                //oidConcurso 
                //Luego se deben consultar las entidades de periodos
                //de manera que se pueda crear un objeto de la clase Periodo. 
                int ultimoPeriodo;

                //jrivas 21/7/2005
                //INC 20044
                //BigDecimal periodo = (BigDecimal) respuesta.getValueAt(i,
                //"NUM_PEDI");
                BigDecimal periodo = (BigDecimal) respuesta.getValueAt(i,
                        "NUM_PERI");

                if (periodo != null) {
                    ultimoPeriodo = periodo.intValue();

                    StringBuffer query4 = new StringBuffer();
                    RecordSet rs4 = new RecordSet();
                    //BelcorpService belcorpService3 = null;

                    query4.append(" SELECT p.oid_peri OIDPERIODOFIN, ");
                    query4.append(" p.fec_inic FECHAINIPERIODOFIN, ");
                    query4.append(" p.fec_fina FECHAFINPERIODOFIN, ");
                    query4.append(" pc.cod_peri CODIGOPERIODOFIN, ");
                    query4.append(" p.pais_oid_pais PAISPERIODOFIN, ");
                    query4.append(" p.marc_oid_marc MARCAPERIODOFIN, ");
                    query4.append(" p.cana_oid_cana CANALPERIODOFIN");
                    query4.append(" FROM cra_perio pent, cra_perio p,  ");
                    query4.append(" seg_perio_corpo pc ");
                    query4.append(" WHERE pent.oid_peri = ").append(
                        periodoHastaDB);
                    query4.append(" AND p.fec_inic >= pent.fec_inic ");
                    query4.append(" AND pc.oid_peri = p.peri_oid_peri ");
                    query4.append(" AND p.pais_oid_pais =  ");
                    query4.append(" pent.pais_oid_pais ");
                    query4.append(" AND p.marc_oid_marc =  ");
                    query4.append(" pent.marc_oid_marc ");
                    query4.append(" AND p.cana_oid_cana =  ");
                    query4.append(" pent.cana_oid_cana ");
                    query4.append(
                        " ORDER BY p.fec_inic, pc.cod_peri, p.fec_fina ");
                        
                    try {
                        rs4 = bs.dbService.executeStaticQuery(query4.toString());
                        UtilidadesLog.debug(" rs4 " + rs4);
                    } catch (Exception e) {
                        UtilidadesLog.error("ERROR ", e);
                        throw new MareException(e,
                            UtilidadesError.armarCodigoError(
                                CodigosError
                                    .ERROR_DE_LECTURA_EN_BASE_DE_DATOS));
                    }

                    if (!rs4.esVacio() &&
                            (rs4.getRowCount() >= (ultimoPeriodo + 1))) {
                        Periodo ultimoPeriodoPremiacion = new Periodo();

                        // datos del ultimo periodo premiacion
                        BigDecimal bdOidPerPre = (BigDecimal) 
                            rs4.getValueAt(ultimoPeriodo,"OIDPERIODOFIN");
                        Date fechaInicioPerPre = (Date) 
                            rs4.getValueAt(ultimoPeriodo,"FECHAINIPERIODOFIN");
                        Date fechaFinPerPre = (Date) 
                            rs4.getValueAt(ultimoPeriodo,"FECHAFINPERIODOFIN");
                        String codigoPerPre = (String) 
                            rs4.getValueAt(ultimoPeriodo,"CODIGOPERIODOFIN");
                        BigDecimal paisPerPre = (BigDecimal) 
                            rs4.getValueAt(ultimoPeriodo,"PAISPERIODOFIN");
                        BigDecimal marcaPerPre = (BigDecimal) 
                            rs4.getValueAt(ultimoPeriodo, "MARCAPERIODOFIN");
                        BigDecimal canalPerPre = (BigDecimal)
                            rs4.getValueAt(ultimoPeriodo,"CANALPERIODOFIN");

                        //Seteo de valores para periodo fin
                        ultimoPeriodoPremiacion.setOidPeriodo(new Long(
                                bdOidPerPre.longValue()));
                        ultimoPeriodoPremiacion.setFechaDesde(
                            fechaInicioPerPre);
                        ultimoPeriodoPremiacion.setFechaHasta(fechaFinPerPre);
                        ultimoPeriodoPremiacion.setCodperiodo(codigoPerPre);
                        ultimoPeriodoPremiacion.setOidPais(new Long(
                                paisPerPre.longValue()));
                        ultimoPeriodoPremiacion.setOidMarca(new Long(
                                marcaPerPre.longValue()));
                        ultimoPeriodoPremiacion.setOidCanal(new Long(
                                canalPerPre.longValue()));

                        concurso.setUltimoPeriodoPremiacion(
                            ultimoPeriodoPremiacion);
                    } else {
                        concurso.setUltimoPeriodoPremiacion(periodoDesde);
                    }
                } else {
                    concurso.setUltimoPeriodoPremiacion(periodoDesde);
                }

                output.add(concurso);
            }

            UtilidadesLog.info("DAOConcursos.obtenerConcursosObjetivos():S"
                +"alida");

            return output;
        }
    }

    /**
     * @Autor: Emilio Noziglia
     * @Fecha : 15/06/2005
     * @Recibe: Object
     * @Retorna: Integer
     * @Descripción: transforma BigDecimal a Integer o null si no viene nada.
     */
    private Integer BigToInteger(Object num) {
        if (num != null) {
            return (new Integer(((BigDecimal) num).intValue()));
        } else {
            return null;
        }
    }

    /**
     * @Autor: Emilio Noziglia
     * @Fecha : 15/06/2005
     * @Recibe: Object
     * @Retorna: Long
     * @Descripción: transforma BigDecimal a Long o null si no viene nada.
     */
    private Long BigToLong(Object num) {
        if (num != null) {
            return (new Long(((BigDecimal) num).longValue()));
        } else {
            return null;
        }
    }

    /**
     * este metodo asigna las tipificaciones de clientes que participan
     * en el concurso pasado por parametro.
     */
    private void obtenerTipificacionesClientesParticipantes(Concurso concurso)
        throws MareException {
        UtilidadesLog.info(
            "DAOConcursos.obtenerTipificacionesClientesParticipantes(Concurso"
                +"concurso):Entrada");

        BelcorpService bs;
        RecordSet respuesta;
        String codigoError;
        StringBuffer query = new StringBuffer();

        try {
            bs = BelcorpService.getInstance();
        } catch (MareMiiServiceNotFoundException e) {
            UtilidadesLog.error("ERROR ", e);
            codigoError = CodigosError.ERROR_AL_PEDIR_UN_SERVICIO_MARE;
            throw new MareException(e,
                UtilidadesError.armarCodigoError(codigoError));
        }

        try {
            query.append(" SELECT ");
            query.append(" PARD.TICL_OID_TIPO_CLIE, ");
            query.append(" PARD.SBTI_OID_SUBT_CLIE, ");
            query.append(" PARD.TCCL_OID_TIPO_CLAS, ");
            query.append(" PARD.CLAS_OID_CLAS ");
            
            //sapaza -- PER-SiCC-2011-0677 -- 10/11/2010  
            query.append(" ,NVL(CLA.IND_EXCL, 0) IND_EXCL ");
            
            query.append(" FROM ");
            query.append(" INC_CLASI_PARTI_CONCU CLA, ");
            query.append(" INC_PARTI_CONCU_CABEC PARC, ");
            query.append(" INC_PARTI_CONCU_DETAL PARD ");
            query.append(" WHERE ");
            query.append(
                " CLA.PACI_OID_PART_CONC_CABE = PARC.OID_PART_CONC_CABE ");
            query.append(" AND PARC.OID_PART_CONC_CABE =  ");
            query.append(" PARD.PACI_OID_PART_CONC_CABE ");
            query.append(" AND CLA.COPA_OID_PARA_GRAL = ").append(
                concurso.getOidConcurso());
            
            //jrivas 27/2/2006 DBLG500000450
            /*query.append(" AND PARC.DIRI_OID_DIRI = ").append(
                //ConstantesINC.TIPO_CONSULTORA);*/
            /*query.append(" AND PARC.PAIS_OID_PAIS = ").append(
                concurso.getOidPais());*/
                
            respuesta = bs.dbService.executeStaticQuery(query.toString());
        } catch (Exception e) {
            UtilidadesLog.error("ERROR ", e);
            codigoError = CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS;
            throw new MareException(e,
                UtilidadesError.armarCodigoError(codigoError));
        }
        
        UtilidadesLog.info("respuesta: " + respuesta);

        if (respuesta.esVacio()) {
            concurso.setTipificacionesClientesParticipantes(null);
        } else {
            TipificacionCliente[] tipificaciones = 
                new TipificacionCliente[respuesta.getRowCount()];

            for (int i = 0; i < respuesta.getRowCount(); i++) {
                tipificaciones[i] = new TipificacionCliente();
                tipificaciones[i].setOidTipoCliente(new Long(
                        ((BigDecimal) respuesta.getValueAt(i,
                            "TICL_OID_TIPO_CLIE")).longValue()));

                {
                    BigDecimal subtipoCliente = (BigDecimal) 
                        respuesta.getValueAt(i, "SBTI_OID_SUBT_CLIE");
                    tipificaciones[i].setOidSubTipoCliente((
                            subtipoCliente != null)
                        ? new Long(subtipoCliente.longValue()) : null);
                }

                {
                    BigDecimal tipoClasificacionCliente = (BigDecimal) 
                        respuesta.getValueAt(i,"TCCL_OID_TIPO_CLAS");
                    tipificaciones[i].setOidTipoClasificacionCliente((
                        tipoClasificacionCliente != null)
                        ? new Long(tipoClasificacionCliente.longValue())
                            : null);
                }

                {
                    BigDecimal clasificacionCliente = (BigDecimal) 
                        respuesta.getValueAt(i,"CLAS_OID_CLAS");
                    tipificaciones[i].setOidClasificacionCliente((
                        clasificacionCliente != null)? new Long(
                            clasificacionCliente.longValue()) : null);
                }
                
                // sapaza -- PER-SiCC-2013-0825 -- 30/07/2013
                Integer indExclusion = BigToInteger(respuesta.getValueAt(i,"IND_EXCL"));
                if(indExclusion == 1)
                    tipificaciones[i].setIndExclusion(true);
                else
                    tipificaciones[i].setIndExclusion(false);
            }

            concurso.setTipificacionesClientesParticipantes(tipificaciones);
        }

        UtilidadesLog.info("DAOConcursos.obtenerTipificacionesClientesParticip"
            +"antes(Concurso concurso):Salida");
    }

    /**
     * este metodo obtiene los estatus de venta de las consultoras
     * participantes en el concurso recibido por parametro.
     */
    private void obtenerEstatusVentaConsultoras(Concurso concurso)
        throws MareException {
        UtilidadesLog.info("DAOConcursos.obtenerEstatusVentaConsultoras(Concu"
            +"rso concurso):Entrada");

        BelcorpService bs;
        RecordSet respuesta;
        String codigoError;
        StringBuffer query = new StringBuffer();

        try {
            bs = BelcorpService.getInstance();
        } catch (MareMiiServiceNotFoundException e) {
            UtilidadesLog.error("ERROR ", e);
            codigoError = CodigosError.ERROR_AL_PEDIR_UN_SERVICIO_MARE;
            throw new MareException(e,
                UtilidadesError.armarCodigoError(codigoError));
        }

        try {
            query.append(" SELECT a.copa_oid_para_gral, ");
            query.append("a.oid_esta_vent, ");
            query.append("a.esta_oid_esta_clie,  ");
            query.append("b.oid_esta_clie,  ");
            query.append("a.perd_oid_peri_hast, ");

            query.append("c.oid_peri as c_oid_peri, ");
            query.append("c.fec_inic as c_fec_inic, ");
            query.append("c.fec_fina as c_fec_fina, ");
            query.append("c.cana_oid_cana as c_cana_oid_cana, ");
            query.append("c.marc_oid_marc as c_marc_oid_marc, ");
            query.append("c.pais_oid_pais as c_pais_oid_pais, ");
            query.append("d.cod_peri as d_cod_peri, ");
            query.append("e.oid_peri as e_oid_peri, ");
            query.append("e.fec_inic as e_fec_inic, ");
            query.append("e.fec_fina as e_fec_fina, ");
            query.append("e.cana_oid_cana as e_cana_oid_cana, ");
            query.append("e.marc_oid_marc as e_marc_oid_marc, ");
            query.append("e.pais_oid_pais as e_pais_oid_pais, ");
            query.append("f.cod_peri as f_cod_peri ");

            query.append("FROM inc_estat_venta_consu a, ");
            query.append(" mae_estat_clien           b, ");
            query.append(" cra_perio                 c, ");
            query.append(" seg_perio_corpo           d, ");
            query.append(" cra_perio                 e, ");
            query.append(" seg_perio_corpo           f ");
            query.append(" WHERE a.copa_oid_para_gral = ").append(
                concurso.getOidConcurso());
            query.append(
                " AND a.esta_oid_esta_clie   = b.esta_oid_esta_clie(+) ");
            query.append(" AND a.perd_oid_peri_desd   = c.oid_peri ");
            query.append(" AND c.peri_oid_peri        = d.oid_peri ");
            query.append(" AND a.perd_oid_peri_hast   = e.oid_peri(+) ");
            query.append(" AND e.peri_oid_peri        = f.oid_peri(+) ");
            respuesta = bs.dbService.executeStaticQuery(query.toString());
            UtilidadesLog.debug(" obtenerEstatusVentaConsultoras respuesta " +
                respuesta);
        } catch (Exception e) {
            UtilidadesLog.error("ERROR ", e);
            codigoError = CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS;
            throw new MareException(e,
                UtilidadesError.armarCodigoError(codigoError));
        }

        if (respuesta.esVacio()) {
            concurso.setEstatusVentaConsultoras(null);
        } else {
            EstatusVentaConsultoras[] estatus = new EstatusVentaConsultoras[
                respuesta.getRowCount()];

            for (int i = 0; i < respuesta.getRowCount(); i++) {
                estatus[i] = new EstatusVentaConsultoras();
                estatus[i].setOidEstatusCliente(new Long(
                        ((BigDecimal) respuesta.getValueAt(i,
                            "ESTA_OID_ESTA_CLIE")).longValue()));
                estatus[i].setOidEstatusAnterior((respuesta.getValueAt(i,
                        "OID_ESTA_CLIE") == null) ? null
                                                  : new Long(
                        ((BigDecimal) respuesta.getValueAt(i, "OID_ESTA_CLIE"))
                            .longValue()));

                Periodo periodoDesde = new Periodo();
                periodoDesde.setCodperiodo((String) respuesta.getValueAt(i,
                        "D_COD_PERI"));
                periodoDesde.setFechaDesde((Date) respuesta.getValueAt(i,
                        "C_FEC_INIC"));
                periodoDesde.setFechaHasta((Date) respuesta.getValueAt(i,
                        "C_FEC_FINA"));
                periodoDesde.setOidCanal(new Long(
                        ((BigDecimal) respuesta.getValueAt(i, 
                            "C_CANA_OID_CANA")).longValue()));
                periodoDesde.setOidMarca(new Long(
                        ((BigDecimal) respuesta.getValueAt(i, 
                            "C_MARC_OID_MARC")).longValue()));
                periodoDesde.setOidPais(new Long(
                        ((BigDecimal) respuesta.getValueAt(i, 
                            "C_PAIS_OID_PAIS")).longValue()));
                periodoDesde.setOidPeriodo(new Long(
                        ((BigDecimal) respuesta.getValueAt(i, 
                            "C_OID_PERI")).longValue()));
                estatus[i].setPeriodoDesde(periodoDesde);

                Long periodoHastaDB = new Long(((BigDecimal) 
                    respuesta.getValueAt(i, "PERD_OID_PERI_HAST"))
                        .longValue());

                if (periodoHastaDB != null) {
                    Periodo periodoHasta = new Periodo();
                    periodoHasta.setCodperiodo((String) 
                        respuesta.getValueAt(i, "F_COD_PERI"));
                    periodoHasta.setFechaDesde((Date) 
                        respuesta.getValueAt(i,"E_FEC_INIC"));
                    periodoHasta.setFechaHasta((Date) 
                        respuesta.getValueAt(i,"E_FEC_FINA"));
                    periodoHasta.setOidCanal(new Long(
                            ((BigDecimal) respuesta.getValueAt(i,
                                "E_CANA_OID_CANA")).longValue()));
                    periodoHasta.setOidMarca(new Long(
                            ((BigDecimal) respuesta.getValueAt(i,
                                "E_MARC_OID_MARC")).longValue()));
                    periodoHasta.setOidPais(new Long(
                            ((BigDecimal) respuesta.getValueAt(i,
                                "E_PAIS_OID_PAIS")).longValue()));
                    periodoHasta.setOidPeriodo(new Long(
                            ((BigDecimal) 
                                respuesta.getValueAt(i, "E_OID_PERI"))
                                    .longValue()));
                    estatus[i].setPeriodoHasta(periodoHasta);
                } else {
                    estatus[i].setPeriodoHasta(periodoDesde);
                }

                UtilidadesLog.debug(
                    "Estatus Venta historico[i].getOidEstatusAnterior " +
                    estatus[i].getOidEstatusAnterior());
                UtilidadesLog.debug(
                    "Venta historico[i].getOidEstatusCliente " +
                    estatus[i].getOidEstatusCliente());
                UtilidadesLog.debug(
                    "Venta historico[i].getPeriodoDesde " +
                    estatus[i].getPeriodoDesde().getOidPeriodo());
                UtilidadesLog.debug(
                    "Venta historico[i].getPeriodoHasta " +
                    estatus[i].getPeriodoHasta().getOidPeriodo());
            }

            concurso.setEstatusVentaConsultoras(estatus);
        }

        UtilidadesLog.info("DAOConcursos.obtenerEstatusVentaConsultoras(Concur"
            +"so concurso):Salida");
    }

    /**
     * este recupera el estatus futuro de los clientes.
     */
    private void obtenerEstatusFuturoClientes(Concurso concurso)
        throws MareException {
        UtilidadesLog.info("DAOConcursos.obtenerEstatusFuturoClientes(Concurso"
            +"concurso) :Entrada");

        BelcorpService bs;
        RecordSet respuesta;
        String codigoError;
        StringBuffer query = new StringBuffer();

        try {
            bs = BelcorpService.getInstance();
        } catch (MareMiiServiceNotFoundException e) {
            UtilidadesLog.error("ERROR ", e);
            codigoError = CodigosError.ERROR_AL_PEDIR_UN_SERVICIO_MARE;
            throw new MareException(e,
                UtilidadesError.armarCodigoError(codigoError));
        }

        try {
            query.append(" SELECT OID_ESTA_CLIE, ESTA_OID_ESTA_CLIE ");
            query.append(" FROM MAE_ESTAT_CLIEN ");
            respuesta = bs.dbService.executeStaticQuery(query.toString());
        } catch (Exception e) {
            UtilidadesLog.error("ERROR ", e);
            codigoError = CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS;
            throw new MareException(e,
                UtilidadesError.armarCodigoError(codigoError));
        }

        if (respuesta.esVacio()) {
            concurso.setEstatusFuturoClientes(null);
        } else {
            HashMap output = new HashMap();

            for (int i = 0; i < respuesta.getRowCount(); i++) {
                EstatusFuturoClientes status = new EstatusFuturoClientes();
                status.setOidEstatusCliente(new Long(
                        ((BigDecimal) respuesta.getValueAt(i, "OID_ESTA_CLIE"))
                            .longValue()));

                {
                    BigDecimal oidEstatusFuturo = (BigDecimal) 
                        respuesta.getValueAt(i,"ESTA_OID_ESTA_CLIE");
                    status.setOidEstatusFuturo((oidEstatusFuturo != null)
                        ? new Long(oidEstatusFuturo.longValue()) : null);
                }

                output.put(status.getOidEstatusCliente(), status);
            }

            concurso.setEstatusFuturoClientes(output);
        }

        UtilidadesLog.info("DAOConcursos.obtenerEstatusFuturoClientes(Concurso"
            +" concurso:Salida");
    }

    /**
     * este metodo recupera el cronograma del concurso recibido por parametro.
     */
    private void obtenerCronograma(Concurso concurso) throws MareException {
        UtilidadesLog.info("DAOConcursos.obtenerCronograma(Concurso "
            +"concurso):Entrada");

        BelcorpService bs;
        RecordSet respuesta;
        String codigoError;
        StringBuffer query = new StringBuffer();

        try {
            bs = BelcorpService.getInstance();
        } catch (MareMiiServiceNotFoundException e) {
            UtilidadesLog.error("ERROR ", e);
            codigoError = CodigosError.ERROR_AL_PEDIR_UN_SERVICIO_MARE;
            throw new MareException(e,
                UtilidadesError.armarCodigoError(codigoError));
        }

        //INC-77 jrivas 27/3/2006
        //El cronograma se usa ahgora tambien para validar estatusConsultoras.
        Periodo menorPeriodoEstatus = concurso.getPeriodoDesde();
        //INC-131 Para recomendacion se usa el Ultimo Periodo Evaluar
        Periodo mayorPeriodoEstatus = concurso.getUltimoPeridoEvaluar();
        EstatusVentaConsultoras[] estatus =  concurso.getEstatusVentaConsultoras();
        if (estatus != null) {
            for (int i = 0 ; i < estatus.length; i++) {
                if (estatus[i].getPeriodoDesde().menorQue(menorPeriodoEstatus)) {
                    menorPeriodoEstatus = estatus[i].getPeriodoDesde();    
                }
                if (estatus[i].getPeriodoHasta().mayorQue(mayorPeriodoEstatus)) {
                    mayorPeriodoEstatus = estatus[i].getPeriodoHasta();    
                }
            }
        }

        try {
            query.append(" SELECT DISTINCT ");
            query.append(" B.OID_PERI, ");
            query.append(" B.FEC_INIC, ");
            query.append(" B.FEC_FINA, ");
            query.append(" B.PAIS_OID_PAIS, ");
            query.append(" B.MARC_OID_MARC, ");
            query.append(" B.CANA_OID_CANA, ");
            query.append(" A.COD_PERI "); // sapaza -- PER-SiCC-2011-0207 -- 13/04/2011

            query.append(" FROM ");
            query.append(" SEG_PERIO_CORPO A, ");
            query.append(" CRA_PERIO B, ");
            query.append(" CRA_PERIO C, ");
            query.append(" CRA_PERIO D ");
            query.append(" WHERE ");
            query.append(" A.OID_PERI = B.PERI_OID_PERI ");
            query.append(" AND B.PAIS_OID_PAIS = ").append(
                concurso.getOidPais());
            query.append(" AND B.CANA_OID_CANA = ").append(
                concurso.getOidCanal());
            query.append(" AND B.MARC_OID_MARC = ").append(
                concurso.getOidMarca());
            query.append(" AND C.OID_PERI = ").append(
                menorPeriodoEstatus.getOidPeriodo());
                
            query.append(" AND D.OID_PERI = ").append(
                mayorPeriodoEstatus.getOidPeriodo());
            query.append(" AND B.FEC_INIC >= C.FEC_INIC ");
            query.append(" AND B.FEC_FINA <= D.FEC_FINA ");
            query.append(" ORDER BY B.FEC_INIC ");
            respuesta = bs.dbService.executeStaticQuery(query.toString());
            UtilidadesLog.debug("obtenerCronograma obtenido: " + respuesta);
        } catch (Exception e) {
            UtilidadesLog.error("ERROR ", e);
            codigoError = CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS;
            throw new MareException(e,
                UtilidadesError.armarCodigoError(codigoError));
        }

        if (respuesta.esVacio()) {
            concurso.setCronograma(null);
        } else {
            ArrayList cronograma = new ArrayList();

            for (int i = 0; i < respuesta.getRowCount(); i++) {
                Periodo periodo = new Periodo();
                periodo.setOidPeriodo(new Long(
                        ((BigDecimal) respuesta.getValueAt(i, "OID_PERI"))
                            .longValue()));
                periodo.setFechaDesde((Date) 
                    respuesta.getValueAt(i, "FEC_INIC"));
                periodo.setFechaHasta((Date)
                    respuesta.getValueAt(i, "FEC_FINA"));
                periodo.setOidPais(new Long(
                        ((BigDecimal) respuesta.getValueAt(i, "PAIS_OID_PAIS"))
                            .longValue()));
                periodo.setOidCanal(new Long(
                        ((BigDecimal) respuesta.getValueAt(i, "CANA_OID_CANA"))
                            .longValue()));
                periodo.setOidMarca(new Long(
                        ((BigDecimal) respuesta.getValueAt(i, "MARC_OID_MARC"))
                            .longValue()));
                periodo.setCodperiodo((String) respuesta.getValueAt(i,
                        "COD_PERI")); // sapaza -- PER-SiCC-2011-0207 -- 13/04/2011
                cronograma.add(periodo);
            }

            concurso.setCronograma(cronograma);
        }

        UtilidadesLog.info("DAOConcursos.obtenerCronograma(Concurso concurso):"
            +"Salida");
    }

    /**
     * este metodo recupera las exigencias minimas por cantidad de periodos 
     * para el concurso.
     */
    private void obtenerExigenciasMinimas(Concurso concurso)
        throws MareException {
        UtilidadesLog.info("DAOConcursos.obtenerExigenciasMinimas(Concurso "
            +"concurso):Entrada");

        BelcorpService bs;
        RecordSet respuesta;
        String codigoError;
        StringBuffer query = new StringBuffer();

        try {
            bs = BelcorpService.getInstance();
        } catch (MareMiiServiceNotFoundException e) {
            UtilidadesLog.error("ERROR ", e);
            codigoError = CodigosError.ERROR_AL_PEDIR_UN_SERVICIO_MARE;
            throw new MareException(e,
                UtilidadesError.armarCodigoError(codigoError));
        }

        try {
            query.append(" SELECT DISTINCT ");
            query.append(" A.NUM_PEDI_EVAL, ");
            query.append(" A.TREQ_OID_TIPO_REQU, ");
            query.append(" A.NUM_PEDI_PREM, ");
            query.append(" B.NUM_PEDI, ");
            query.append(" B.VAL_EXIG_MINI, ");
            query.append(" B.PANP_OID_PARA_NIVE_PREM ");
            query.append(" FROM ");
            query.append(" INC_PROGR_NUEVA       A, ");
            query.append(" INC_REQUI_PROGR_NUEVA B ");
            query.append(" WHERE A.OID_PROG_NUEV = B.PRNU_OID_PROG_NUEV ");
            query.append(" AND A.COPA_OID_PARA_GRAL = ").append(
                concurso.getOidConcurso());
            respuesta = bs.dbService.executeStaticQuery(query.toString());
        } catch (Exception e) {
            UtilidadesLog.error("ERROR ", e);
            codigoError = CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS;
            throw new MareException(e,
                UtilidadesError.armarCodigoError(codigoError));
        }

        if (respuesta.esVacio()) {
            concurso.setRequisitosProgramaNuevas(null);
        } else {
            RequisitosProgramaNuevas[] requisitos = 
                new RequisitosProgramaNuevas[respuesta.getRowCount()];

            for (int i = 0; i < respuesta.getRowCount(); i++) {
                requisitos[i] = new RequisitosProgramaNuevas();
                requisitos[i].setNumeroPeriodosEvaluar(new Long(
                        ((BigDecimal) respuesta.getValueAt(i, "NUM_PEDI_EVAL"))
                            .longValue()));
                requisitos[i].setExigenciaMinima((BigDecimal) 
                    respuesta.getValueAt(i, "VAL_EXIG_MINI"));
                requisitos[i].setOidTipoRequisito(new Long(
                        ((BigDecimal) respuesta.getValueAt(i,
                            "TREQ_OID_TIPO_REQU")).longValue()));

                {
                    BigDecimal oidNivelPremiacion = (BigDecimal) 
                        respuesta.getValueAt(i,"PANP_OID_PARA_NIVE_PREM");
                    requisitos[i].setNivelPremiacion((
                        oidNivelPremiacion != null)
                        ? new Long(oidNivelPremiacion.longValue()) : null);
                }

                requisitos[i].setNumeroPedidosAPremiar(new Long(
                        ((BigDecimal) respuesta.getValueAt(i, "NUM_PEDI_PREM"))
                            .longValue()));
                requisitos[i].setNumeroPedido(new Long(
                        ((BigDecimal) respuesta.getValueAt(i, "NUM_PEDI"))
                            .longValue()));
            }

            concurso.setRequisitosProgramaNuevas(requisitos);
        }

        UtilidadesLog.info("DAOConcursos.obtenerExigenciasMinimas(Concurso "
            +"concurso):Salida");
    }

    /**
     * este metodo obtiene los parametros para determinar el nivel de
     * premiacion para el concurso.
     */
    private void obtenerParametrosNivelPremiacion(Concurso concurso)
        throws MareException {
        UtilidadesLog.info("DAOConcursos.obtenerParametrosNivelPremiacion(Conc"
            +"urso concurso):Entrada");

        BelcorpService bs;
        RecordSet respuesta;
        String codigoError;
        StringBuffer query = new StringBuffer();

        try {
            bs = BelcorpService.getInstance();
        } catch (MareMiiServiceNotFoundException e) {
            UtilidadesLog.error("ERROR ", e);
            codigoError = CodigosError.ERROR_AL_PEDIR_UN_SERVICIO_MARE;
            throw new MareException(e,
                UtilidadesError.armarCodigoError(codigoError));
        }

        try {
            query.append(" SELECT DISTINCT ");
            query.append(" A.NUM_NIVE, ");
            query.append(" B.NUM_PERI ");
            query.append(" FROM ");
            query.append(" INC_PARAM_NIVEL_PREMI A, ");
            query.append(" INC_PARAM_GENER_PREMI B ");
            query.append(
                " WHERE A.PAGP_OID_PARA_GENE_PREM = B.OID_PARA_GENE_PREM ");
            query.append(" AND B.COPA_OID_PARA_GRAL = ").append(
                concurso.getOidConcurso());
            respuesta = bs.dbService.executeStaticQuery(query.toString());
        } catch (Exception e) {
            UtilidadesLog.error("ERROR ", e);
            codigoError = CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS;
            throw new MareException(e,
                UtilidadesError.armarCodigoError(codigoError));
        }

        if (respuesta.esVacio()) {
            concurso.setParametrosNivelPremiacion(null);
        } else {
            ParametrosNivelPremiacion[] parametros = 
                new ParametrosNivelPremiacion[respuesta.getRowCount()];

            for (int i = 0; i < respuesta.getRowCount(); i++) {
                parametros[i] = new ParametrosNivelPremiacion();
                parametros[i].setNumeroNivel(new Long(
                        ((BigDecimal) respuesta.getValueAt(i, "NUM_NIVE"))
                            .longValue()));

                {
                    BigDecimal numeroPedidos = (BigDecimal) 
                        respuesta.getValueAt(i, "NUM_PERI");
                    parametros[i].setNumeroPedidos((numeroPedidos != null)
                        ? new Long(numeroPedidos.longValue()) : new Long(0));
                }
            }

            concurso.setParametrosNivelPremiacion(parametros);
        }

        UtilidadesLog.info("DAOConcursos.obtenerParametrosNivelPremiacion("
            +"Concurso concurso):Salida");
    }

    /**
     * este metodo recupera los accesos para un concurso.
     */
    private void obtenerAccesos(Concurso concurso) throws MareException {
        UtilidadesLog.info("DAOConcursos.obtenerAccesos(Concurso concurso):"
            +"Entrada");

        BelcorpService bs;
        RecordSet respuesta;
        String codigoError;
        StringBuffer query = new StringBuffer();

        try {
            bs = BelcorpService.getInstance();
        } catch (MareMiiServiceNotFoundException e) {
            UtilidadesLog.error("ERROR ", e);
            codigoError = CodigosError.ERROR_AL_PEDIR_UN_SERVICIO_MARE;
            throw new MareException(e,
                UtilidadesError.armarCodigoError(codigoError));
        }

        try {
            query.append(" SELECT ACCE_OID_ACCE ");
            query.append(" FROM INC_ACCES_CONCU ");
            query.append(" WHERE COPA_OID_PARA_GRAL = " +
                concurso.getOidConcurso());
            respuesta = bs.dbService.executeStaticQuery(query.toString());
        } catch (Exception e) {
            UtilidadesLog.error("ERROR ", e);
            codigoError = CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS;
            throw new MareException(e,
                UtilidadesError.armarCodigoError(codigoError));
        }

        if (respuesta.esVacio()) {
            concurso.setOidAccesos(null);
        } else {
            Long[] ids = new Long[respuesta.getRowCount()];

            for (int i = 0; i < respuesta.getRowCount(); i++) {
                ids[i] = new Long(((BigDecimal) respuesta.getValueAt(i,
                            "ACCE_OID_ACCE")).longValue());
            }

            concurso.setOidAccesos(ids);
        }

        UtilidadesLog.info("DAOConcursos.obtenerAccesos(Concurso concurso)"
            +":Salida");
    }

    /**
     * este metodo recupera los ambitos geograficos para un concurso.
     */
    private void obtenerAmbitosGeograficos(Concurso concurso)
        throws MareException {
        UtilidadesLog.info("DAOConcursos.obtenerAmbitosGeograficos(Concurso "
            +"concurso):Entrada");

        BelcorpService bs;
        RecordSet respuesta;
        String codigoError;
        StringBuffer query = new StringBuffer();

        try {
            bs = BelcorpService.getInstance();
        } catch (MareMiiServiceNotFoundException e) {
            UtilidadesLog.error("ERROR ", e);
            codigoError = CodigosError.ERROR_AL_PEDIR_UN_SERVICIO_MARE;
            throw new MareException(e,
                UtilidadesError.armarCodigoError(codigoError));
        }

        try {
            query.append(" SELECT OID_AMBITO_GEOGRAFICO, ");
            query.append(" ZSCC_OID_SECC, ");
            query.append(" ZORG_OID_REGI, ");
            query.append(" ZSGV_OID_SUBG_VENT, ");
            query.append(" TERR_OID_TERR, ");
            query.append(" ZZON_OID_ZONA ");
            query.append(" FROM INC_AMBIT_GEOGR ");
            query.append(" WHERE COPA_OID_PARA_GRAL = " +
                concurso.getOidConcurso());
            respuesta = bs.dbService.executeStaticQuery(query.toString());
        } catch (Exception e) {
            UtilidadesLog.error("ERROR ", e);
            codigoError = CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS;
            throw new MareException(e,
                UtilidadesError.armarCodigoError(codigoError));
        }

        AmbitoGeografico[] ambitos;

        if (respuesta.esVacio()) {
            concurso.setAmbitosGeograficos(null);
        } else {
            ambitos = new AmbitoGeografico[respuesta.getRowCount()];

            for (int i = 0; i < respuesta.getRowCount(); i++) {
                ambitos[i] = new AmbitoGeografico();

                {
                    BigDecimal oidSeccion = (BigDecimal) 
                        respuesta.getValueAt(i,"ZSCC_OID_SECC");
                    ambitos[i].setOidSeccion((oidSeccion != null)
                        ? new Long(oidSeccion.longValue()) : null);
                }

                {
                    BigDecimal oidRegion = (BigDecimal) 
                        respuesta.getValueAt(i, "ZORG_OID_REGI");
                    ambitos[i].setOidRegion((oidRegion != null)
                        ? new Long(oidRegion.longValue()) : null);
                }

                {
                    BigDecimal oidSubgerencia = (BigDecimal) 
                        respuesta.getValueAt(i, "ZSGV_OID_SUBG_VENT");
                    ambitos[i].setOidSubgerencia((oidSubgerencia != null)
                        ? new Long(oidSubgerencia.longValue()) : null);
                }

                {
                    BigDecimal oidTerritorio = (BigDecimal)
                        respuesta.getValueAt(i, "TERR_OID_TERR");
                    ambitos[i].setOidTerritorio((oidTerritorio != null)
                        ? new Long(oidTerritorio.longValue()) : null);
                }

                {
                    BigDecimal oidZona = (BigDecimal) 
                        respuesta.getValueAt(i,"ZZON_OID_ZONA");
                    ambitos[i].setOidZona((oidZona != null)
                        ? new Long(oidZona.longValue()) : null);
                }
            }

            concurso.setAmbitosGeograficos(ambitos);
        }

        UtilidadesLog.info("DAOConcursos.obtenerAmbitosGeograficos(Concurso "
            +"concurso):Salida");
    }

    /**
     * Este método carga inicialmente las cuatro listas de productos del 
     * concurso.
     */
    private void obtenerListaProductos(Concurso concurso)
        throws MareException {
        UtilidadesLog.info("DAOConcursos.obtenerListaProductos(Concurso "
            +"concurso):Entrada");

        // Instancio los objetos
        ListaProductos productosBonificados = new ListaProductos();
        ListaProductos productosExcluidos = new ListaProductos();
        ListaProductos productosExigidos = new ListaProductos();
        ListaProductos productosValidos = new ListaProductos();

        //Obtener el registro de la entidad INC_PRODU por OID de concurso
        /*try {
            ProductosLocalHome productosHome = this.getProductosLocalHome();
                
            ProductosLocal productos = 
                productosHome.findByUK(concurso.getOidConcurso());
            productosBonificados.setComunicacion(
                productos.getComunicacionBonificados().booleanValue());
            productosBonificados.setMensaje(productos.getMensajeBonificados());
            productosExcluidos.setComunicacion(
                productos.getComunicacionExcluidos().booleanValue());
            productosExcluidos.setMensaje(productos.getMensajeExcluidos());
            productosExigidos.setComunicacion(
                productos.getComunicacionExigidos().booleanValue());
            productosExigidos.setMensaje(productos.getMensajeExigidos());
            productosValidos.setComunicacion(
                productos.getComunicacionValidos().booleanValue());
            productosValidos.setMensaje(productos.getMensajeValidos());
            
        } catch (NoResultException fe) {
            UtilidadesLog.debug("no hay ProductosLocal");
            //UtilidadesLog.debug(fe);
         } catch (PersistenceException ce) {
             UtilidadesLog.error("ERROR ", ce);
             throw new MareException(ce,UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS));
        } catch (Exception ex) {
            UtilidadesLog.debug("no hay ProductosLocal");
            //UtilidadesLog.debug(ex);
        }*/

        BelcorpService bs;
        RecordSet respuesta;
        String codigoError;
        StringBuffer query = new StringBuffer();
        
        try {
            bs = BelcorpService.getInstance();
        } catch (MareMiiServiceNotFoundException e) {
            UtilidadesLog.error("ERROR ", e);
            codigoError = CodigosError.ERROR_AL_PEDIR_UN_SERVICIO_MARE;
            throw new MareException(e,
                 UtilidadesError.armarCodigoError(codigoError));
        }
             
        try {
            query.append(" SELECT VAL_COMU_VALI, ");
            query.append(" VAL_MENS_VALI, ");
            query.append(" VAL_COMU_EXIG, ");
            query.append(" VAL_MENS_EXIG, ");
            query.append(" VAL_COMU_EXCL, ");
            query.append(" VAL_MENS_EXCL, ");
            query.append(" VAL_COMU_BONI, ");
            query.append(" VAL_MENS_BONI ");
            query.append(" FROM INC_PRODU ");
            query.append(" WHERE COPA_OID_PARA_GRAL = " +
            concurso.getOidConcurso());
         
            respuesta = bs.dbService.executeStaticQuery(query.toString());
        } catch (Exception e) {
            UtilidadesLog.error("ERROR ", e);
            codigoError = CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS;
            throw new MareException(e,
            UtilidadesError.armarCodigoError(codigoError));
        }
        
        if (!respuesta.esVacio()) {
            BigDecimal indComunicacionVali = (BigDecimal) respuesta.getValueAt(0, "VAL_COMU_VALI");

            if (indComunicacionVali == null) {
                productosValidos.setComunicacion(false);
            } else {
                if (indComunicacionVali.doubleValue() > 0) {
                    productosValidos.setComunicacion(true);
                } else {
                    productosValidos.setComunicacion(false);
                }
            }
            productosValidos.setMensaje((String) respuesta.getValueAt(0, "VAL_MENS_VALI"));
            
            BigDecimal indComunicacionExig = (BigDecimal) respuesta.getValueAt(0, "VAL_COMU_EXIG");

            if (indComunicacionExig == null) {
                productosExigidos.setComunicacion(false);
            } else {
                if (indComunicacionExig.doubleValue() > 0) {
                    productosExigidos.setComunicacion(true);
                } else {
                    productosExigidos.setComunicacion(false);
                }
            }
            productosExigidos.setMensaje((String) respuesta.getValueAt(0, "VAL_MENS_EXIG"));
            
            BigDecimal indComunicacionExcl = (BigDecimal) respuesta.getValueAt(0, "VAL_COMU_EXCL");

            if (indComunicacionExcl == null) {
                productosExcluidos.setComunicacion(false);
            } else {
                if (indComunicacionExcl.doubleValue() > 0) {
                    productosExcluidos.setComunicacion(true);
                } else {
                    productosExcluidos.setComunicacion(false);
                }
            }
            productosExcluidos.setMensaje((String) respuesta.getValueAt(0, "VAL_MENS_EXCL"));
            
            BigDecimal indComunicacionBoni = (BigDecimal) respuesta.getValueAt(0, "VAL_COMU_BONI");

            if (indComunicacionBoni == null) {
                productosBonificados.setComunicacion(false);
            } else {
                if (indComunicacionBoni.doubleValue() > 0) {
                    productosBonificados.setComunicacion(true);
                } else {
                    productosBonificados.setComunicacion(false);
                }
            }
            productosBonificados.setMensaje((String) respuesta.getValueAt(0, "VAL_MENS_BONI"));
            
        }
             
        concurso.setProductosBonificados(productosBonificados);
        concurso.setProductosExcluidos(productosExcluidos);
        concurso.setProductosExigidos(productosExigidos);
        concurso.setProductosValidos(productosValidos);
        
        UtilidadesLog.info("DAOConcursos.obtenerListaProductos(Concurso "
            +"concurso):Salida");
    }

    /**
     * Este método carga los arreglos de productos de las cuatro listas
     * de productos del concurso (bonificados,exigidos, excluidos y validos).
     *
     * Los objetos creados se tratan de una forma bastante particular,
     * esto es intencional para que el codigo sea legible.
     */
    private void obtenerProductos(Concurso concurso) throws MareException {
        UtilidadesLog.info("DAOConcursos.obtenerProductos(Concurso concurso)"
            +":Entrada");

        BelcorpService bs;
        RecordSet respuesta;
        String codigoError;
        StringBuffer query = new StringBuffer();

        try {
            bs = BelcorpService.getInstance();
        } catch (MareMiiServiceNotFoundException e) {
            UtilidadesLog.error("ERROR ", e);
            codigoError = CodigosError.ERROR_AL_PEDIR_UN_SERVICIO_MARE;
            throw new MareException(e,
                UtilidadesError.armarCodigoError(codigoError));
        }

        try {
            // PRODUCTOS BONIFICADOS
            query.append(" SELECT 1 TABLA, ");
            query.append(" CIVI_OID_CICL_VIDA, GENE_OID_GENE, MAPR_OID_MARC_PROD, ");
            query.append(" NEGO_OID_NEGO, PRDU_OID_PROD, PROD_OID_PROD, ");
            query.append(" OID_PROD_BONI, TOFE_OID_TIPO_OFER, UNEG_OID_UNID_NEGO, ");
            query.append(" PERD_OID_PERI_DESD, PERD_OID_PERI_HAST,  ");
            query.append(" SGEN_OID_SUPE_GENE, ");
            query.append(" NUM_PUNT_UNID,  ");
            query.append(" NULL NUM_PUNT_EXIG, VAL_FACT_MULT, ");
            query.append(" NULL NUM_UNID_EXIG, NULL IMP_MONT_EXIG, ");
            query.append(" PED.FEC_INIC as PED_FEC_INIC,  ");
            query.append(" PED.FEC_FINA as PED_FEC_FINA, ");
            query.append(" PED.MARC_OID_MARC as PED_MARC_OID_MARC, ");
            query.append(" PED.CANA_OID_CANA as PED_CANA_OID_CANA,  ");
            query.append(" PED.PAIS_OID_PAIS as PED_PAIS_OID_PAIS, ");
            query.append(" PCD.COD_PERI as PCD_COD_PERI, ");
            query.append(" PEH.FEC_INIC as PEH_FEC_INIC,  ");
            query.append(" PEH.FEC_FINA as PEH_FEC_FINA, ");
            query.append(" PEH.MARC_OID_MARC as PEH_MARC_OID_MARC, ");
            query.append(" PEH.CANA_OID_CANA as PEH_CANA_OID_CANA, ");
            query.append(" PEH.PAIS_OID_PAIS as PEH_PAIS_OID_PAIS, ");
            query.append(" PCH.COD_PERI as PCH_COD_PERI");
            //jrivas 20090807 17/4/2009 20090915
            query.append(" , 'T' AS IND_AGRUP");
            query.append(" , OFDE_OID_DETA_OFER "); // sapaza -- COL-SiCC-2013-0030 -- 28/11/2013 
            query.append(" FROM INC_PRODU_BONIF PB , ");
            query.append(" INC_PRODU            PR , ");
            query.append(" CRA_PERIO            PED, ");
            query.append(" SEG_PERIO_CORPO      PCD, ");
            query.append(" CRA_PERIO            PEH, ");
            query.append(" SEG_PERIO_CORPO      PCH ");
            query.append(" WHERE PR.COPA_OID_PARA_GRAL = " + concurso.getOidConcurso());
            query.append(" AND PB.PRDU_OID_PROD        = PR.OID_PROD ");
            query.append(" AND PB.PERD_OID_PERI_DESD   = PED.OID_PERI ");
            query.append(" AND PED.PERI_OID_PERI       = PCD.OID_PERI ");
            query.append(" AND PB.PERD_OID_PERI_HAST   = PEH.OID_PERI ");
            query.append(" AND PEH.PERI_OID_PERI       = PCH.OID_PERI ");

            query.append(" UNION ");

            // PRODUCTOS EXCLUIDOS
            query.append(" SELECT 2, ");
            query.append(" CIVI_OID_CICL_VIDA, GENE_OID_GENE, MAPR_OID_MARC_PROD, ");
            query.append(" NEGO_OID_NEGO, PRDU_OID_PROD, PROD_OID_PROD, ");
            query.append(" OID_PROD_EXCL, TOFE_OID_TIPO_OFER, UNEG_OID_UNID_NEGO, ");
            query.append(" PERD_OID_PERI_DESD, PERD_OID_PERI_HAST,  ");
            query.append(" SGEN_OID_SUPE_GENE, ");
            query.append(" NULL, NULL, NULL, NULL, NULL, ");
            query.append(" PED.FEC_INIC as PED_FEC_INIC,  ");
            query.append(" PED.FEC_FINA as PED_FEC_FINA, ");
            query.append(" PED.MARC_OID_MARC, PED.CANA_OID_CANA, ");
            query.append(" PED.PAIS_OID_PAIS, ");
            query.append(" PCD.COD_PERI as PCD_COD_PERI, ");
            query.append(" PEH.FEC_INIC as PEH_FEC_INIC,  ");
            query.append(" PEH.FEC_FINA as PEH_FEC_FINA, ");
            query.append(" PEH.MARC_OID_MARC, PEH.CANA_OID_CANA, PEH.PAIS_OID_PAIS, ");
            query.append(" PCH.COD_PERI as PCH_COD_PERI ");
            //jrivas 20090807 17/4/2009 20090915
            query.append(" , 'T' AS IND_AGRUP");
            query.append(" , OFDE_OID_DETA_OFER "); // sapaza -- COL-SiCC-2013-0030 -- 28/11/2013 
            query.append(" FROM INC_PRODU_EXCLU PB , ");
            query.append(" INC_PRODU            PR , ");
            query.append(" CRA_PERIO            PED, ");
            query.append(" SEG_PERIO_CORPO      PCD, ");
            query.append(" CRA_PERIO            PEH, ");
            query.append(" SEG_PERIO_CORPO      PCH ");
            query.append(" WHERE PR.COPA_OID_PARA_GRAL = " + concurso.getOidConcurso());
            query.append(" AND PB.PRDU_OID_PROD        = PR.OID_PROD ");
            query.append(" AND PB.PERD_OID_PERI_DESD   = PED.OID_PERI(+) ");
            query.append(" AND PED.PERI_OID_PERI       = PCD.OID_PERI(+) ");
            query.append(" AND PB.PERD_OID_PERI_HAST   = PEH.OID_PERI(+) ");
            query.append(" AND PEH.PERI_OID_PERI       = PCH.OID_PERI(+) ");

            query.append(" UNION ");

            // PRODUCTOS EXIGIDOS
            query.append(" SELECT 3, ");
            query.append(" CIVI_OID_CICL_VIDA, GENE_OID_GENE, MAPR_OID_MARC_PROD, ");
            query.append(" NEGO_OID_NEGO, PRDU_OID_PROD, PROD_OID_PROD, ");
            query.append(" OID_PROD_EXIG, TOFE_OID_TIPO_OFER, UNEG_OID_UNID_NEGO, ");
            query.append(" PERD_OID_PERI_DESD, PERD_OID_PERI_HAST, ");
            query.append(" NULL, NULL, NUM_PUNT_EXIG, NULL, ");
            query.append(" NUM_UNID_EXIG, IMP_MONT_EXIG, ");
            query.append(" PED.FEC_INIC as PED_FEC_INIC,  ");
            query.append(" PED.FEC_FINA as PED_FEC_FINA, ");
            query.append(" PED.MARC_OID_MARC as PED_MARC_OID_MARC,  ");
            query.append(" PED.CANA_OID_CANA as PED_CANA_OID_CANA,  ");
            query.append(" PED.PAIS_OID_PAIS as PED_PAIS_OID_PAIS, ");
            query.append(" PCD.COD_PERI as PCD_COD_PERI, ");
            query.append(" PEH.FEC_INIC as PEH_FEC_INIC,  ");
            query.append(" PEH.FEC_FINA as PEH_FEC_FINA, ");
            query.append(" PEH.MARC_OID_MARC as PEH_MARC_OID_MARC,  ");
            query.append(" PEH.CANA_OID_CANA as PEH_CANA_OID_CANA,  ");
            query.append(" PEH.PAIS_OID_PAIS as PEH_PAIS_OID_PAIS, ");
            query.append(" PCH.COD_PERI as PCH_COD_PERI ");
            //jrivas 20090807 17/4/2009 20090915
            query.append(" , NVL(IND_AGRUP, 'T') AS IND_AGRUP");
            query.append(" , OFDE_OID_DETA_OFER "); // sapaza -- COL-SiCC-2013-0030 -- 28/11/2013 
            query.append(" FROM INC_PRODU_EXIGI PB , ");
            query.append(" INC_PRODU            PR , ");
            query.append(" CRA_PERIO            PED, ");
            query.append(" SEG_PERIO_CORPO      PCD, ");
            query.append(" CRA_PERIO            PEH, ");
            query.append(" SEG_PERIO_CORPO      PCH ");
            query.append(" WHERE PR.COPA_OID_PARA_GRAL = " + concurso.getOidConcurso());
            query.append(" AND PB.PRDU_OID_PROD        = PR.OID_PROD ");
            query.append(" AND PB.PERD_OID_PERI_DESD   = PED.OID_PERI ");
            query.append(" AND PED.PERI_OID_PERI       = PCD.OID_PERI ");
            query.append(" AND PB.PERD_OID_PERI_HAST   = PEH.OID_PERI ");
            query.append(" AND PEH.PERI_OID_PERI       = PCH.OID_PERI ");

            query.append(" UNION ");

            // PRODUCTOS VALIDOS
            query.append(" SELECT 4, ");
            query.append(" CIVI_OID_CICL_VIDA, GENE_OID_GENE, MAPR_OID_MARC_PROD, ");
            query.append(" NEGO_OID_NEGO, PRDU_OID_PROD, PROD_OID_PROD, ");
            query.append(" OID_PROD_VALI, TOFE_OID_TIPO_OFER, UNEG_OID_UNID_NEGO, ");
            query.append(" NULL, NULL, SGEN_OID_SUPE_GENE, ");
            query.append(" NULL, NULL, NULL, NULL, NULL, ");
            query.append(" NULL, NULL, NULL, NULL, NULL, NULL, ");
            query.append(" NULL, NULL, NULL, NULL, NULL, NULL ");
            //jrivas 20090807 17/4/2009 20090915 
            query.append(" , 'T' AS IND_AGRUP");
            query.append(" , OFDE_OID_DETA_OFER "); // sapaza -- COL-SiCC-2013-0030 -- 28/11/2013 
            query.append(" FROM INC_PRODU_VALID PB , ");
            query.append(" INC_PRODU            PR ");
            query.append(" WHERE PR.COPA_OID_PARA_GRAL = " + concurso.getOidConcurso());
            query.append(" AND PB.PRDU_OID_PROD        = PR.OID_PROD ");
            
            respuesta = bs.dbService.executeStaticQuery(query.toString());
        } catch (Exception e) {
            UtilidadesLog.error("ERROR ", e);
            codigoError = CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS;
            throw new MareException(e,
                UtilidadesError.armarCodigoError(codigoError));
        }

        if (respuesta.esVacio()) {
            concurso.getProductosBonificados().setProductos(new ArrayList());
            concurso.getProductosExcluidos().setProductos(new ArrayList());
            concurso.getProductosExigidos().setProductos(new ArrayList());
            concurso.getProductosValidos().setProductos(new ArrayList());
        } else {
            ArrayList productosBonificados = new ArrayList();
            ArrayList productosExcluidos = new ArrayList();
            ArrayList productosExigidos = new ArrayList();
            ArrayList productosValidos = new ArrayList();

            for (int i = 0; i < respuesta.getRowCount(); i++) {
                PrdBloque producto = null;

                BigDecimal marcaProducto = (BigDecimal) respuesta.getValueAt(i,
                        "MAPR_OID_MARC_PROD");
                BigDecimal oidProducto = (BigDecimal) respuesta.getValueAt(i,
                        "PROD_OID_PROD");
                BigDecimal oidTipoOferta = (BigDecimal) respuesta.getValueAt(i,
                        "TOFE_OID_TIPO_OFER");
                        
                // sapaza -- COL-SiCC-2013-0030 -- 28/11/2013        
                BigDecimal oidDetalleOferta = (BigDecimal) respuesta.getValueAt(i,
                        "OFDE_OID_DETA_OFER");
                        
                int tipoProducto;

                if (oidDetalleOferta != null) {
                    producto = new PrdBloqueCUV();
                    tipoProducto = 4;
                } else {
                    if (marcaProducto != null) {
                        producto = new PrdBloqueNegocio();
                        tipoProducto = 1;
                    } else {
                        if (oidProducto != null) {
                            producto = new PrdBloqueProducto();
                            tipoProducto = 2;
                        } else {
                            if ((oidTipoOferta != null) && (oidProducto == null)){
                                producto = new PrdBloqueOferta();
                                tipoProducto = 3;
                            } else {
                                tipoProducto = 0;
                            }
                        }
                    }
                }    

                if (tipoProducto != 0) {
                    int tabla = ((BigDecimal) respuesta.getValueAt(i, "TABLA"))
                        .intValue();

                    // setear atributos para todos los tipos de objetos
                    if (tabla == 1) {
                        producto.setOidProductoExigido(new Long(
                                ((BigDecimal) respuesta.getValueAt(i,
                                    "OID_PROD_BONI")).longValue()));
                    }

                    if (tabla == 2) {
                        producto.setOidProductoExigido(new Long(
                                ((BigDecimal) respuesta.getValueAt(i,
                                    "OID_PROD_BONI")).longValue()));
                    }

                    if (tabla == 3) {
                        producto.setOidProductoExigido(new Long(
                                ((BigDecimal) respuesta.getValueAt(i,
                                    "OID_PROD_BONI")).longValue()));
                    }

                    if (tabla == 4) {
                        producto.setOidProductoExigido(new Long(
                                ((BigDecimal) respuesta.getValueAt(i,
                                    "OID_PROD_BONI")).longValue()));
                    }

                    {
                        BigDecimal puntosUnidad = (BigDecimal) 
                            respuesta.getValueAt(i,"NUM_PUNT_UNID");
                        producto.setPuntosUnidad((puntosUnidad != null)
                            ? new Double(puntosUnidad.doubleValue())
                            // BELC300024301 - gPineda - 04/10/06
                            //: new Double(1));
                            : new Double(0));
                    }

                    {
                        BigDecimal puntosExigidos = (BigDecimal) 
                            respuesta.getValueAt(i,"NUM_PUNT_EXIG");
                        producto.setPuntosExigidos((puntosExigidos != null)
                            ? new Double(puntosExigidos.doubleValue())
                            : new Double(0));
                    }

                    {
                        BigDecimal factorMultiplicador = (BigDecimal) 
                            respuesta.getValueAt(i,"VAL_FACT_MULT");
                        producto.setFactorMultiplicador((
                            factorMultiplicador != null)
                            ? new Double(factorMultiplicador.doubleValue())
                            // BELC300024301 - gPineda - 04/10/06
                            //: new Double(1));
                            : new Double(0));
                    }

                    {
                        BigDecimal unidadesExigidas = (BigDecimal) 
                        respuesta.getValueAt(i,"NUM_UNID_EXIG");
                        producto.setUnidadesExigidas((unidadesExigidas != null)
                            ? new Long(unidadesExigidas.longValue()) : new Long(
                                0));
                    }

                    {
                        BigDecimal montoExigido = (BigDecimal) 
                        respuesta.getValueAt(i,"IMP_MONT_EXIG");
                        producto.setMontoExigido((montoExigido != null)
                            ? montoExigido : new BigDecimal(0));
                    }

                    // periodo desde
                    Periodo periodoDesde = null;

                    {
                        BigDecimal oidPeriodoD = (BigDecimal)
                            respuesta.getValueAt(i, "PERD_OID_PERI_DESD");

                        if (oidPeriodoD != null) {
                            periodoDesde = new Periodo();
                            periodoDesde.setOidPeriodo(new Long(
                                    oidPeriodoD.longValue()));
                            periodoDesde.setFechaDesde((Date) 
                                respuesta.getValueAt(i, "PED_FEC_INIC"));
                            periodoDesde.setFechaHasta((Date) 
                                respuesta.getValueAt(i, "PED_FEC_FINA"));
                            periodoDesde.setOidMarca(new Long(
                                    ((BigDecimal) respuesta.getValueAt(i,
                                        "PED_MARC_OID_MARC")).longValue()));
                            periodoDesde.setOidCanal(new Long(
                                    ((BigDecimal) respuesta.getValueAt(i,
                                        "PED_CANA_OID_CANA")).longValue()));
                            periodoDesde.setOidPais(new Long(
                                    ((BigDecimal) respuesta.getValueAt(i,
                                        "PED_PAIS_OID_PAIS")).longValue()));
                            periodoDesde.setCodperiodo((String) 
                                respuesta.getValueAt(i, "PCD_COD_PERI"));
                        }
                    }
                    producto.setPeriodoDesde(periodoDesde);
                    
                    // periodo hasta
                    Periodo periodoHasta = null;

                    {
                        BigDecimal oidPeriodoH = (BigDecimal) 
                            respuesta.getValueAt(i,"PERD_OID_PERI_HAST");

                        if (oidPeriodoH != null) {
                            periodoHasta = new Periodo();
                            periodoHasta.setOidPeriodo(new Long(
                                    oidPeriodoH.longValue()));
                            periodoHasta.setFechaDesde((Date) respuesta.getValueAt(
                                    i, "PEH_FEC_INIC"));
                            periodoHasta.setFechaHasta((Date) respuesta.getValueAt(
                                    i, "PEH_FEC_FINA"));
                            periodoHasta.setOidMarca(new Long(
                                    ((BigDecimal) respuesta.getValueAt(i,
                                        "PEH_MARC_OID_MARC")).longValue()));
                            periodoHasta.setOidCanal(new Long(
                                    ((BigDecimal) respuesta.getValueAt(i,
                                        "PEH_CANA_OID_CANA")).longValue()));
                            periodoHasta.setOidPais(new Long(
                                    ((BigDecimal) respuesta.getValueAt(i,
                                        "PEH_PAIS_OID_PAIS")).longValue()));
                            periodoHasta.setCodperiodo((String) respuesta.getValueAt(
                                    i, "PCH_COD_PERI"));
                        }
                    }
                    producto.setPeriodoHasta(periodoHasta);

                    if (tipoProducto == 1) {
                        // setear atributos para objetos del tipo prd bloque 
                        //negocio
                        PrdBloqueNegocio prdBloqueNegocio = (PrdBloqueNegocio)
                            producto;

                        {
                            BigDecimal oidGenerico = (BigDecimal) 
                                respuesta.getValueAt(i,"GENE_OID_GENE");
                            prdBloqueNegocio.setOidGenerico((oidGenerico 
                                != null)
                                ? new Long(oidGenerico.longValue()) : null);
                        }

                        {
                            BigDecimal oidMarcaProducto = (BigDecimal)
                                respuesta.getValueAt(i,"MAPR_OID_MARC_PROD");
                            prdBloqueNegocio.setOidMarcaProducto((
                                oidMarcaProducto != null)
                                ? new Long(oidMarcaProducto.longValue()) 
                                    : null);
                        }

                        {
                            BigDecimal oidNegocio = (BigDecimal) 
                                respuesta.getValueAt(i,"NEGO_OID_NEGO");
                            prdBloqueNegocio.setOidNegocio((oidNegocio != null)
                                ? new Long(oidNegocio.longValue()) : null);
                        }

                        {
                            BigDecimal oidUnidadNegocio = (BigDecimal) 
                                respuesta.getValueAt(i,"UNEG_OID_UNID_NEGO");
                            prdBloqueNegocio.setOidUnidadNegocio((
                                oidUnidadNegocio != null)? new Long(
                                    oidUnidadNegocio.longValue()) : null);
                        }

                        {
                            BigDecimal oidSuperGenerico = (BigDecimal) 
                                respuesta.getValueAt(i,"SGEN_OID_SUPE_GENE");
                            prdBloqueNegocio.setOidSuperGenerico((
                                oidSuperGenerico != null)? new Long(
                                    oidSuperGenerico.longValue()) : null);
                        }

                        producto = prdBloqueNegocio;
                    }

                    if (tipoProducto == 2) {
                        // setear atributos para objetos del tipo prd 
                        //bloque producto
                        PrdBloqueProducto prdBloqueProducto = 
                            (PrdBloqueProducto) producto;

                        {
                            BigDecimal oidProductoLocal = (BigDecimal) 
                                respuesta.getValueAt(i,"PROD_OID_PROD");
                            prdBloqueProducto.setOidProducto((
                                oidProductoLocal != null)? new Long(
                                    oidProductoLocal.longValue()) : null);
                        }

                        {
                            BigDecimal oidCicloVida = (BigDecimal) 
                                respuesta.getValueAt(i,"CIVI_OID_CICL_VIDA");
                            prdBloqueProducto.setOidCicloVida((
                                oidCicloVida != null)? new Long(oidCicloVida
                                    .longValue()) : null);
                        }

                        {
                            BigDecimal oidTipoOferta0 = (BigDecimal) 
                                respuesta.getValueAt(i,"TOFE_OID_TIPO_OFER");
                            prdBloqueProducto.setOidTipoOferta((oidTipoOferta0 
                                != null) ? new Long(oidTipoOferta0.longValue())
                                    : null);
                        }
                        
                        //jrivas 20090807 17/4/2009
                        String indAgrup = respuesta.getValueAt(i,"IND_AGRUP").toString();
                        prdBloqueProducto.setIndAgrupacion(indAgrup);

                        producto = prdBloqueProducto;
                    }

                    if (tipoProducto == 3) {
                        // setear atributos para objetos del tipo prd bloque 
                        //oferta
                        PrdBloqueOferta prdBloqueOferta = (PrdBloqueOferta) 
                            producto;

                        {
                            BigDecimal oidCicloVida = (BigDecimal) 
                                respuesta.getValueAt(i,"CIVI_OID_CICL_VIDA");
                            prdBloqueOferta.setOidCicloVida((oidCicloVida 
                                != null) ? new Long(oidCicloVida.longValue())
                                    : null);
                        }

                        {
                            BigDecimal oidTipoOferta1 = (BigDecimal) 
                                respuesta.getValueAt(i,"TOFE_OID_TIPO_OFER");
                            prdBloqueOferta.setOidTipoOferta((oidTipoOferta1 
                                != null) ? new Long(oidTipoOferta1.longValue())
                                    : null);
                        }

                        producto = prdBloqueOferta;
                    }
                    
                    if (tipoProducto == 4) {
                        // setear atributos para objetos del tipo prd bloque 
                        //CUV
                        PrdBloqueCUV prdBloqueCUV = (PrdBloqueCUV)producto;

                        {
                            prdBloqueCUV.setOidDetalleOferta((oidDetalleOferta 
                                != null) ? new Long(oidDetalleOferta.longValue())
                                    : null);
                        }

                        producto = prdBloqueCUV;
                    }

                    if (tabla == 1) {
                        productosBonificados.add(producto);
                    }

                    if (tabla == 2) {
                        productosExcluidos.add(producto);
                    }

                    if (tabla == 3) {
                        productosExigidos.add(producto);
                    }

                    if (tabla == 4) {
                        productosValidos.add(producto);
                    }
                }
            }

            concurso.getProductosBonificados().setProductos(
                productosBonificados);
            concurso.getProductosExcluidos().setProductos(productosExcluidos);
            concurso.getProductosExigidos().setProductos(productosExigidos);
            concurso.getProductosValidos().setProductos(productosValidos);
        }

        UtilidadesLog.info("DAOConcursos.obtenerProductos(Concurso concurso):"
            +"Salida");
    }

    /**
     * Obtiene una lista de OIDs de la entidad SolicitudConcursoMensajes
     * filtrando por OID de solicitud
     */
    public DTOOIDs obtenerMensajes(DTOESolicitud dtoe)
        throws MareException {
        UtilidadesLog.info("DAOConcursos.obtenerMensajes(DTOESolicitud dtoe)"
            +":Salida");

        BelcorpService bs;
        RecordSet respuesta;
        String codigoError;
        StringBuffer query = new StringBuffer();

        try {
            bs = BelcorpService.getInstance();
        } catch (MareMiiServiceNotFoundException e) {
            UtilidadesLog.error("ERROR ", e);
            codigoError = CodigosError.ERROR_AL_PEDIR_UN_SERVICIO_MARE;
            throw new MareException(e,
                UtilidadesError.armarCodigoError(codigoError));
        }

        try {
            query.append(" SELECT OID_SOLI_CONC_MENS ");
            query.append(" FROM INC_SOLIC_CONCU_MENSA ");
            query.append(" WHERE SOCA_OID_SOLI_CABE = " +
                dtoe.getOidSolicitud());
            respuesta = bs.dbService.executeStaticQuery(query.toString());
        } catch (Exception e) {
            UtilidadesLog.error("ERROR ", e);
            codigoError = CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS;
            throw new MareException(e,
                UtilidadesError.armarCodigoError(codigoError));
        }

        DTOOIDs output = new DTOOIDs();
        Long[] ids = new Long[respuesta.getRowCount()];

        for (int i = 0; i < respuesta.getRowCount(); i++) {
            ids[i] = new Long(((BigDecimal) respuesta.getValueAt(i,
                        "OID_SOLI_CONC_MENS")).longValue());
        }

        output.setOids(ids);
        UtilidadesLog.info("DAOConcursos.obtenerMensajes(DTOESolicitud dtoe):"
            +"Salida");

        return output;
    }

    /**
     * Obtiene una lista de OIDs de la entidad SolicitudConcursoRecomendadas
     * filtrando por OID de solicitud
     */
    public DTOOIDs obtenerRecomendadas(DTOESolicitud dtoe)
        throws MareException {
        UtilidadesLog.info("DAOConcursos.btenerRecomendadas(DTOESolicitud dtoe)"
            +":Entrada");

        BelcorpService bs;
        RecordSet respuesta;
        String codigoError;
        StringBuffer query = new StringBuffer();

        try {
            bs = BelcorpService.getInstance();
        } catch (MareMiiServiceNotFoundException e) {
            UtilidadesLog.error("ERROR ", e);
            codigoError = CodigosError.ERROR_AL_PEDIR_UN_SERVICIO_MARE;
            throw new MareException(e,
                UtilidadesError.armarCodigoError(codigoError));
        }

        try {
            query.append(" SELECT OID_SOLI_CONC_RECO ");
            query.append(" FROM INC_SOLIC_CONCU_RECOM ");
            query.append(" WHERE SOCA_OID_SOLI_CABE = " +
                dtoe.getOidSolicitud());
            respuesta = bs.dbService.executeStaticQuery(query.toString());
        } catch (Exception e) {
            UtilidadesLog.error("ERROR ", e);
            codigoError = CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS;
            throw new MareException(e,
                UtilidadesError.armarCodigoError(codigoError));
        }

        DTOOIDs output = new DTOOIDs();
        Long[] ids = new Long[respuesta.getRowCount()];

        for (int i = 0; i < respuesta.getRowCount(); i++) {
            ids[i] = new Long(((BigDecimal) respuesta.getValueAt(i,
                        "OID_SOLI_CONC_RECO")).longValue());
        }

        output.setOids(ids);
        UtilidadesLog.info("DAOConcursos.btenerRecomendadas(DTOESolicitud "
            +"dtoe):Salida");

        return output;
    }

    /**
     * obtener la sumatoria de montosPedido, unidadesPedido, puntosPedido
     */
    public DTOPuntajeProductosExigidos obtenerSumatoriaProductosExigidos(
        long oidConcurso, long oidSolicitud) throws MareException {
        UtilidadesLog.info("DAOConcursos.obtenerSumatoriaProductosExigidos("
            +"long oidConcurso, long oidSolicitud):Entrada");

        BelcorpService bs;
        RecordSet respuesta;
        String codigoError;
        StringBuffer query = new StringBuffer();

        try {
            bs = BelcorpService.getInstance();
        } catch (MareMiiServiceNotFoundException e) {
            UtilidadesLog.error("ERROR ", e);
            codigoError = CodigosError.ERROR_AL_PEDIR_UN_SERVICIO_MARE;
            throw new MareException(e,
                UtilidadesError.armarCodigoError(codigoError));
        }

        try {
            query.append(" SELECT OID_PUNT_PROD_EXIG, ");
            query.append(" IMP_MONT, ");
            query.append(" NUM_UNID, ");
            query.append(" NUM_PUNT ");
            query.append(" FROM INC_PUNTA_PRODU_EXIGI ");
            query.append(" WHERE COPA_OID_PARA_GRAL = " + oidConcurso);
            query.append(" AND SOCA_OID_SOLI_CABE   = " + oidSolicitud);
            respuesta = bs.dbService.executeStaticQuery(query.toString());
        } catch (Exception e) {
            UtilidadesLog.error("ERROR ", e);
            codigoError = CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS;
            throw new MareException(e,
                UtilidadesError.armarCodigoError(codigoError));
        }

        if (respuesta.esVacio()) {
            UtilidadesLog.info("DAOConcursos.obtenerSumatoriaProductosExigidos"
                +"(long oidConcurso, long oidSolicitud):Salida");

            return null;
        } else {
            DTOPuntajeProductosExigidos output = 
                new DTOPuntajeProductosExigidos();
            output.setMontoPedidos(new BigDecimal(0));
            output.setUnidadesPedido(new Long(0));
            output.setPuntosPedido(new Long(0));

            for (int i = 0; i < respuesta.getRowCount(); i++) {
                output.setMontoPedidos(output.getMontoPedidos().add(
                    (BigDecimal) respuesta.getValueAt(i, "IMP_MONT")));

                Long sumUnidades = new Long(output.getUnidadesPedido()
                                                  .longValue() +
                        ((BigDecimal) respuesta.getValueAt(i, "NUM_UNID"))
                            .longValue());
                output.setUnidadesPedido(sumUnidades);

                Long sumPuntos = new Long(output.getPuntosPedido().longValue() 
                    + ((BigDecimal) respuesta.getValueAt(i, "NUM_PUNT"))
                        .longValue());
                output.setPuntosPedido(sumPuntos);
            }

            UtilidadesLog.info("DAOConcursos.obtenerSumatoriaProductosExigidos"
                +"(long oidConcurso, long oidSolicitud):Salida");

            return output;
        }
    }

    /**
     * Obtener los OIDs de la entidad PuntajeProductosExigidos
     * filtrando por OID de solicitud y concurso
     */
    public DTOOIDs obtenerProductosExigidos(long oidConcurso, 
        long oidSolicitud) throws MareException {
        UtilidadesLog.info("DAOConcursos.obtenerProductosExigidos(long oidConc"
            +"urso, long oidSolicitud):Entrada");

        BelcorpService bs;
        RecordSet respuesta;
        String codigoError;
        StringBuffer query = new StringBuffer();

        try {
            bs = BelcorpService.getInstance();
        } catch (MareMiiServiceNotFoundException e) {
            UtilidadesLog.error("ERROR ", e);
            codigoError = CodigosError.ERROR_AL_PEDIR_UN_SERVICIO_MARE;
            throw new MareException(e,
                UtilidadesError.armarCodigoError(codigoError));
        }

        try {
            query.append(" SELECT OID_PUNT_PROD_EXIG ");
            query.append(" FROM INC_PUNTA_PRODU_EXIGI ");
            query.append(" WHERE COPA_OID_PARA_GRAL = " + oidConcurso);
            query.append(" AND SOCA_OID_SOLI_CABE   = " + oidSolicitud);
            respuesta = bs.dbService.executeStaticQuery(query.toString());
        } catch (Exception e) {
            UtilidadesLog.error("ERROR ", e);
            codigoError = CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS;
            throw new MareException(e,
                UtilidadesError.armarCodigoError(codigoError));
        }

        if (respuesta.esVacio()) {
            UtilidadesLog.info("DAOConcursos.obtenerProductosExigidos(long oid"
                +"Concurso, long oidSolicitud):Salida");

            return null;
        } else {
            DTOOIDs output = new DTOOIDs();
            Long[] ids = new Long[respuesta.getRowCount()];

            for (int i = 0; i < respuesta.getRowCount(); i++) {
                ids[i] = new Long(((BigDecimal) respuesta.getValueAt(i,
                            "OID_PUNT_PROD_EXIG")).longValue());
            }

            output.setOids(ids);
            UtilidadesLog.info("DAOConcursos.obtenerProductosExigidos(long oid"
                +"Concurso, long oidSolicitud):Salida");

            return output;
        }
    }

    /**
     * Retorna el OID de la Entidad CalculoProductosExigidos
     * filtrando por OID de cliente, concurso y periodo.
     */
    public DTOOID obtenerCalculoProductosExigidos(Long oidConcurso,
        Long oidCliente, Long oidPeriodo) throws MareException {
        UtilidadesLog.info( "DAOConcursos.obtenerCalculoProductosExigidos(Long "
            +"oidConcurso, Long oidCliente, Long oidPeriodo):Entrada");

        BelcorpService bs;
        RecordSet respuesta;
        String codigoError;
        StringBuffer query = new StringBuffer();

        try {
            bs = BelcorpService.getInstance();
        } catch (MareMiiServiceNotFoundException e) {
            UtilidadesLog.error("ERROR ", e);
            codigoError = CodigosError.ERROR_AL_PEDIR_UN_SERVICIO_MARE;
            throw new MareException(e,
                UtilidadesError.armarCodigoError(codigoError));
        }

        try {
            query.append(" SELECT OID_CALC_PROD_EXIG ");
            query.append(" FROM INC_CALCU_PRODU_EXIGI, ");
            query.append(" INC_PRODU_EXIGI, ");
            query.append(" INC_PRODU ");
            query.append(" WHERE PRE2_OID_PROD_EXIG = OID_PROD_EXIG ");
            query.append(" AND   PRDU_OID_PROD      = OID_PROD ");
            query.append(" AND COPA_OID_PARA_GRAL = " +
                oidConcurso);
            query.append(" AND CLIE_OID_CLIE      = " + 
                oidCliente);
            query.append(" AND PERD_OID_PERI      = " + 
                oidPeriodo);
            respuesta = bs.dbService.executeStaticQuery(query.toString());
        } catch (Exception e) {
            UtilidadesLog.error("ERROR ", e);
            codigoError = CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS;
            throw new MareException(e,
                UtilidadesError.armarCodigoError(codigoError));
        }

        if (respuesta.esVacio()) {
            UtilidadesLog.info("DAOConcursos.obtenerCalculoProductosExigidos("
                +"Long oidConcurso, Long oidCliente, Long oidPeriodo):Salida");

            return null;
        } else {
            DTOOID output = new DTOOID();
            output.setOid(new Long(((BigDecimal) 
                respuesta.getValueAt(0, "OID_CALC_PROD_EXIG")).longValue()));
            UtilidadesLog.info("DAOConcursos.obtenerCalculoProductosExigidos("
                +"Long oidConcurso, Long oidCliente, Long oidPeriodo):Salida");

            return output;
        }
    }

    /**
     * Recupera el OID de la entidad CuentaCorrientePuntos
     * filtrando por OID de concurso, periodo y cliente.
     */
    public DTOOID obtenerCuentaCorriente(DTOEConcursoClientePeriodo dtoe)
        throws MareException {
        UtilidadesLog.info("DAOConcursos.obtenerCuentaCorriente(DTOEConcurso"
            +"ClientePeriodo dtoe):Entrada");

        BelcorpService bs;
        RecordSet respuesta;
        String codigoError;
        StringBuffer query = new StringBuffer();

        try {
            bs = BelcorpService.getInstance();
        } catch (MareMiiServiceNotFoundException e) {
            UtilidadesLog.error("ERROR ", e);
            codigoError = CodigosError.ERROR_AL_PEDIR_UN_SERVICIO_MARE;
            throw new MareException(e,
                UtilidadesError.armarCodigoError(codigoError));
        }

        try {
            query.append(" SELECT OID_CUEN_CORR_PUNT ");
            query.append(" FROM INC_CUENT_CORRI_PUNTO ");
            query.append(" WHERE COPA_OID_PARA_GRAL = " +
                dtoe.getOidConcurso());
            query.append(" AND PERD_OID_PERI        = " +
                dtoe.getOidPeriodo());
            query.append(" AND CLIE_OID_CLIE        = " +
                dtoe.getOidCliente());
            respuesta = bs.dbService.executeStaticQuery(query.toString());
        } catch (Exception e) {
            UtilidadesLog.error("ERROR ", e);
            codigoError = CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS;
            throw new MareException(e,
                UtilidadesError.armarCodigoError(codigoError));
        }

        if (respuesta.esVacio()) {
            UtilidadesLog.info("DAOConcursos.obtenerCuentaCorriente(DTOEConcur"
                +"soClientePeriodo dtoe):Salida");

            return null;
        } else {
            DTOOID output = new DTOOID();
            output.setOid(new Long(((BigDecimal) 
                respuesta.getValueAt(0, "OID_CUEN_CORR_PUNT")).longValue()));
            UtilidadesLog.info("DAOConcursos.obtenerCuentaCorriente(DTOEConcur"
                +"soClientePeriodo dtoe):Salida");

            return output;
        }
    }

    /**
     * Retorna la cantidad de registros que cumplen con la condición
     * de igual con el cliente y periodo recibidos por parámetro (ignorar 
     * el atributo concurso)
     */
    public int contarCuentasCorrientes(DTOEConcursoClientePeriodo dtoe)
        throws MareException {
        UtilidadesLog.info("DAOConcursos.contarCuentasCorrientes(DTOEConcursoC"
            +"lientePeriodo dtoe):Entrada");

        BelcorpService bs;
        RecordSet respuesta;
        String codigoError;
        StringBuffer query = new StringBuffer();

        try {
            bs = BelcorpService.getInstance();
        } catch (MareMiiServiceNotFoundException e) {
            UtilidadesLog.error("ERROR ", e);
            codigoError = CodigosError.ERROR_AL_PEDIR_UN_SERVICIO_MARE;
            throw new MareException(e,
                UtilidadesError.armarCodigoError(codigoError));
        }

        try {
            query.append(" SELECT OID_CUEN_CORR_PUNT ");
            query.append(" FROM INC_CUENT_CORRI_PUNTO ");
            query.append(" WHERE CLIE_OID_CLIE = " +
                dtoe.getOidCliente());
            query.append(" AND   PERD_OID_PERI = " +
                dtoe.getOidPeriodo());
            respuesta = bs.dbService.executeStaticQuery(query.toString());
        } catch (Exception e) {
            UtilidadesLog.error("ERROR ", e);
            codigoError = CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS;
            throw new MareException(e,
                UtilidadesError.armarCodigoError(codigoError));
        }

        if (respuesta.esVacio()) {
            UtilidadesLog.info("DAOConcursos.contarCuentasCorrientes(DTOEConcu"
                +"rsoClientePeriodo dtoe):Salida");

            return 0;
        } else {
            UtilidadesLog.info("DAOConcursos.contarCuentasCorrientes(DTOEConcu"
                +"rsoClientePeriodo dtoe):Salida");

            return respuesta.getRowCount();
        }
    }

    /**
     * Obtiene el OID de la entidad CantidataGanadoras
     * filtrando por OID de concurso, cliente, periodo
     */
    public DTOOID obtenerCandidataGanadora(DTOEConcursoClientePeriodo dtoe)
        throws MareException {
        UtilidadesLog.info("DAOConcursos.obtenerCandidataGanadora(DTOEConcurso"
            +"ClientePeriodo dtoe):Entrada");

        BelcorpService bs;
        RecordSet respuesta;
        String codigoError;
        StringBuffer query = new StringBuffer();

        try {
            bs = BelcorpService.getInstance();
        } catch (MareMiiServiceNotFoundException e) {
            UtilidadesLog.error("ERROR ", e);
            codigoError = CodigosError.ERROR_AL_PEDIR_UN_SERVICIO_MARE;
            throw new MareException(e,
                UtilidadesError.armarCodigoError(codigoError));
        }

        try {
            query.append(" SELECT OID_CAND_GANA ");
            query.append(" FROM INC_CANDI_GANAD ");
            query.append(" WHERE COPA_OID_PARA_GRAL = " +
                dtoe.getOidConcurso());
            query.append(" AND CLIE_OID_CLIE        = " +
                dtoe.getOidCliente());
            query.append(" AND PERD_OID_PERI        = " +
                dtoe.getOidPeriodo());
            respuesta = bs.dbService.executeStaticQuery(query.toString());
        } catch (Exception e) {
            UtilidadesLog.error("ERROR ", e);
            codigoError = CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS;
            throw new MareException(e,
                UtilidadesError.armarCodigoError(codigoError));
        }

        if (respuesta.esVacio()) {
            UtilidadesLog.info("DAOConcursos.obtenerCandidataGanadora(DTOEConc"
                +"rsoClientePeriodo dtoe):Salida");

            return null;
        } else {
            DTOOID output = new DTOOID();
            output.setOid(new Long(((BigDecimal) 
                respuesta.getValueAt(0, "OID_CAND_GANA")).longValue()));
            UtilidadesLog.info("DAOConcursos.obtenerCandidataGanadora(DTOECon"
                +"cursoClientePeriodo dtoe):Salida");

            return output;
        }
    }

    /**
     * Retorna la cantidad de registros que cumplen con la condicion
     * de igualdad por OID de cliente y periodo (ignorar el parametro concurso)
     */
    public int contarCandidataGanadoras(DTOEConcursoClientePeriodo dtoe)
        throws MareException {
        UtilidadesLog.info("DAOConcursos.contarCandidataGanadoras(DTOEConcurso"
            +"ClientePeriodo dtoe):Entrada");

        BelcorpService bs;
        RecordSet respuesta;
        String codigoError;
        StringBuffer query = new StringBuffer();

        try {
            bs = BelcorpService.getInstance();
        } catch (MareMiiServiceNotFoundException e) {
            UtilidadesLog.error("ERROR ", e);
            codigoError = CodigosError.ERROR_AL_PEDIR_UN_SERVICIO_MARE;
            throw new MareException(e,
                UtilidadesError.armarCodigoError(codigoError));
        }

        try {
            query.append(" SELECT OID_CAND_GANA ");
            query.append(" FROM INC_CANDI_GANAD ");
            query.append(" WHERE CLIE_OID_CLIE = " +
                dtoe.getOidCliente());
            query.append(" AND PERD_OID_PERI   = " +
                dtoe.getOidPeriodo());
            respuesta = bs.dbService.executeStaticQuery(query.toString());
        } catch (Exception e) {
            UtilidadesLog.error("ERROR ", e);
            codigoError = CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS;
            throw new MareException(e,
                UtilidadesError.armarCodigoError(codigoError));
        }

        if (respuesta.esVacio()) {
            UtilidadesLog.info("DAOConcursos.contarCandidataGanadoras(DTOEConc"
                +"ursoClientePeriodo dtoe):Salida");

            return 0;
        } else {
            UtilidadesLog.info("DAOConcursos.contarCandidataGanadoras(DTOEConc"
                +"ursoClientePeriodo dtoe):Salida");

            return respuesta.getRowCount();
        }
    }

    /**
     * @autor Noziglia C.
     * @throws MareException
     * @param Periodo periodo, Long periodosPasados
     * @return Periodo
     * @documentation
     *
       Ejecutamos la siguiente consulta:
       SELECT B.oid_peri oid, B.FEC_INIC, B.FEC_FINA, B.PAIS_OID_PAIS,
       B.MARC_OID_MARC, B.CANA_OID_CANA , C.COD_PERI
       FROM
       cra_perio A,
       cra_perio B,
       SEG_PERIO_CORPO C
       WHERE
       A.oid_peri = "periodo.oidPeriodo" AND
       B.pais_oid_pais = A.pais_oid_pais AND
       B.marc_oid_marc = A.marc_oid_marc AND
       B.cana_oid_cana = A.cana_oid_cana AND
       B.fec_inic > A.fec_inic AND
       C.OID_PERI=B.OID_PERI AND
       ROWNUM <= "periodosPasados"
       ORDER BY B.fec_inic DESC

       Nos fijamos en el primer registro que nos devuelve y
       con sus datos componemos una instancia de un objetoPeriodo y lo
       devolvemos.
     * @date 08/06/05
     * @cambio inncidencia
     * @descripcion si periodosPasados es cero retorna el mismo periodo 
     * original.
     * @autor gdmarzi
     */
    public Periodo obtenerPeriodoDespuesDe(Periodo periodo, 
        Long periodosPasados) throws MareException {
        UtilidadesLog.info("DAOConcursos.obtenerPeriodoDespuesDe(Periodo peri"
            +"odo, Long periodosPasados):Entrada");

        BelcorpService bs;
        RecordSet rs;
        StringBuffer buf = new StringBuffer();

        try {
            bs = BelcorpService.getInstance();
        } catch (MareMiiServiceNotFoundException e) {
            UtilidadesLog.error("ERROR ", e);
            throw new MareException(e,
                UtilidadesError.armarCodigoError(
                    CodigosError.ERROR_AL_PEDIR_UN_SERVICIO_MARE));
        }

        try {
            buf.append("SELECT B.oid_peri OID_PERI, B.FEC_INIC, B.FEC_FINA, ");
            buf.append("B.PAIS_OID_PAIS,B.MARC_OID_MARC, B.CANA_OID_CANA ,  ");
            buf.append("C.COD_PERI ");
            buf.append("FROM cra_perio A, cra_perio B, SEG_PERIO_CORPO C ");
            buf.append("WHERE A.oid_peri = ").append(periodo.getOidPeriodo())
               .append(" AND ");
            buf.append("B.pais_oid_pais = A.pais_oid_pais AND ");
            buf.append("B.marc_oid_marc = A.marc_oid_marc AND ");
            buf.append("B.cana_oid_cana = A.cana_oid_cana AND ");
            buf.append("B.fec_inic > A.fec_inic AND ");
            buf.append("C.OID_PERI=B.OID_PERI AND ");
            buf.append("ROWNUM <= ").append(periodosPasados);
            buf.append(" ORDER BY B.fec_inic DESC ");

            rs = bs.dbService.executeStaticQuery(buf.toString());

            if (!rs.esVacio()) {
                Periodo periodoObtenido = new Periodo();
                periodoObtenido.setOidPeriodo(Long.valueOf(
                        rs.getValueAt(0, "OID_PERI").toString()));
                periodoObtenido.setFechaDesde((Date) 
                    rs.getValueAt(0, "FEC_INIC"));
                periodoObtenido.setFechaHasta((Date) 
                    rs.getValueAt(0, "FEC_FINA"));
                periodoObtenido.setOidPais(Long.valueOf(
                        rs.getValueAt(0, "PAIS_OID_PAIS").toString()));
                periodoObtenido.setOidMarca(Long.valueOf(
                        rs.getValueAt(0, "MARC_OID_MARC").toString()));
                periodoObtenido.setOidCanal(Long.valueOf(
                        rs.getValueAt(0, "CANA_OID_CANA").toString()));
                periodoObtenido.setCodperiodo(rs.getValueAt(0, "COD_PERI")
                                                .toString());
                UtilidadesLog.info("DAOConcursos.obtenerPeriodoDespuesDe(Perio"
                    +"do periodo, Long periodosPasados):Salida");

                return periodoObtenido;
            } else {
                UtilidadesLog.info("DAOConcursos.obtenerPeriodoDespuesDe(Perio"
                    +"do periodo, Long periodosPasados):Salida");

                return periodo;
            }
        } catch (Exception e) {
            UtilidadesLog.error("ERROR ", e);
            throw new MareException(e,
                UtilidadesError.armarCodigoError(
                    CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS));
        }
    }

    /**
     * @autor Noziglia C.
     * @throws MareException
     * @param Long oidPeriodo, Long periodosPasados
     * @return Periodo
     * @documentation
     * Ejecutamos la siguiente consulta:
        
        SELECT B.oid_peri oid, B.FEC_INIC, B.FEC_FINA,
        B.PAIS_OID_PAIS,B.MARC_OID_MARC, B.CANA_OID_CANA , C.COD_PERI
        FROM
        cra_perio A,
        cra_perio B,
        SEG_PERIO_CORPO C
        WHERE
        A.oid_peri = "oidPeriodo" AND
        B.pais_oid_pais = A.pais_oid_pais AND
        B.marc_oid_marc = A.marc_oid_marc AND
        B.cana_oid_cana = A.cana_oid_cana AND
        B.fec_inic < A.fec_inic AND
        C.OID_PERI=B.OID_PERI

        ORDER BY B.fec_inic desc

        Nos fijamos en el N registro que nos devuelve y con sus datos 
        componemos una instancia de un objetoPeriodo y lo devolvemos.
        N = periododsPasados
     *
     * @date 08/06/05
     * @aambio Incidencia 20801
     * @autor gdmarzi
     */
    public Periodo obtenerPeriodoAntesDe(Long oidPeriodo, Long periodosPasados)
        throws MareException {
        UtilidadesLog.info("DAOConcursos.obtenerPeriodoAntesDe(Long oidPeriodo"
            +", Long periodosPasados):Entrada");

        BelcorpService bs;
        RecordSet rs;
        StringBuffer buf = new StringBuffer();

        try {
            bs = BelcorpService.getInstance();
        } catch (MareMiiServiceNotFoundException e) {
            UtilidadesLog.error("ERROR ", e);
            throw new MareException(e,
                UtilidadesError.armarCodigoError(
                    CodigosError.ERROR_AL_PEDIR_UN_SERVICIO_MARE));
        }

        try {
            buf.append("SELECT * FROM ( "); // sapaza -- PER-SiCC-2010-0479 -- 25/08/2010
            
            buf.append("SELECT B.OID_PERI, B.FEC_INIC, B.FEC_FINA, ");
            buf.append("B.PAIS_OID_PAIS, ");
            buf.append("B.MARC_OID_MARC, B.CANA_OID_CANA , C.COD_PERI  ");
            buf.append("FROM cra_perio A, cra_perio B, SEG_PERIO_CORPO C  ");
            buf.append("WHERE A.oid_peri = ").append(oidPeriodo)
                .append(" AND ");
            buf.append("B.pais_oid_pais = A.pais_oid_pais AND ");
            buf.append("B.marc_oid_marc = A.marc_oid_marc AND ");
            buf.append("B.cana_oid_cana = A.cana_oid_cana AND ");
            buf.append("B.fec_inic <= A.fec_inic AND ");
            buf.append("C.OID_PERI = B.PERI_OID_PERI ");
            buf.append("ORDER BY B.fec_inic DESC ");
            
            // sapaza -- PER-SiCC-2010-0479 -- 25/08/2010
            buf.append(") WHERE ROWNUM < " + (periodosPasados.intValue() + 2));

            rs = bs.dbService.executeStaticQuery(buf.toString());

            if ((rs == null) || rs.esVacio()) {
                UtilidadesLog.info("DAOConcursos.obtenerPeriodoAntesDe(Long "
                    +"oidPeriodo, Long periodosPasados):Salida");

                return null;
            } else {
                Periodo periodo = new Periodo();
                periodo.setOidPeriodo(Long.valueOf(rs.getValueAt(
                            periodosPasados.intValue(), "OID_PERI")
                                .toString()));
                periodo.setFechaDesde((Date) rs.getValueAt(
                        periodosPasados.intValue(), "FEC_INIC"));
                periodo.setFechaHasta((Date) rs.getValueAt(
                        periodosPasados.intValue(), "FEC_FINA"));
                periodo.setOidPais(Long.valueOf(rs.getValueAt(
                            periodosPasados.intValue(), "PAIS_OID_PAIS")
                                                  .toString()));
                periodo.setOidMarca(Long.valueOf(rs.getValueAt(
                            periodosPasados.intValue(), "MARC_OID_MARC")
                                                   .toString()));
                periodo.setOidCanal(Long.valueOf(rs.getValueAt(
                            periodosPasados.intValue(), "CANA_OID_CANA")
                                                   .toString()));
                periodo.setCodperiodo(rs.getValueAt(
                        periodosPasados.intValue(), "COD_PERI").toString());
                UtilidadesLog.info("DAOConcursos.obtenerPeriodoAntesDe(Long "
                    +"oidPeriodo, Long periodosPasados):Salida");

                return periodo;
            }
        } catch (Exception e) {
            UtilidadesLog.error("ERROR ", e);
            throw new MareException(e,
                UtilidadesError.armarCodigoError(
                    CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS));
        }
    }

    /**
     * Este metodo obtiene los registros de INC_VARIA_VENTA_RANKI_CONCU
     * correspondientes al concurso pasado por parametro.
     *
     * Sistema: Belcorp
     * Módulo:  INC
     * Fecha:   13/07/2005
     * @version 1.00
     * @autor   Diego Morello
     */
    public HashMap recuperarVariablesVentaRankingConcurso(Concurso concurso)
        throws MareException {
        UtilidadesLog.info("DAOConcursos.recuperarVariablesVentaRankingConcu"
            +"rso(Concurso concurso):Entrada");

        HashMap map = new HashMap();

        RecordSet rs = new RecordSet();
        StringBuffer query = new StringBuffer();
        BelcorpService bs = null;

        try {
            bs = BelcorpService.getInstance();
        } catch (MareMiiServiceNotFoundException e) {
            UtilidadesLog.error("ERROR ", e);
            int error = UtilidadesError.armarCodigoError(CodigosError
                .ERROR_AL_PEDIR_UN_SERVICIO_MARE);
            throw new MareException(e, error);
        }

        query.append(" SELECT ");
        query.append("   var.IVVR_OID_VARI_VENT_RANK, ");
        query.append("   var.NUM_APLI, ");
        query.append("   var.VAL_PESO, ");
        query.append("   var.VAL_DIVI, ");
        query.append("   var.NUM_DIAS_COBR ");
        query.append(" FROM ");
        query.append("   INC_VARIA_VENTA_RANKI_CONCU var ");
        query.append(" WHERE ");
        query.append("   var.COPA_OID_PARA_GRAL = " +
            concurso.getOidConcurso());

        try {
            rs = bs.dbService.executeStaticQuery(query.toString());
        } catch (Exception e) {
            UtilidadesLog.error("ERROR ", e);
            int error = UtilidadesError.armarCodigoError(CodigosError
                .ERROR_DE_ACCESO_A_BASE_DE_DATOS);
            throw new MareException(e, error);
        }

        int rows = rs.getRowCount();

        for (int i = 0; i < rows; i++) {
            Integer key = new Integer(((BigDecimal) rs.getValueAt(i,
                        "OID_VARI_VENT_RANK_CONC")).intValue());
            VariableVentaRanking value = new VariableVentaRanking();

            Integer peso = new Integer(((BigDecimal) 
                rs.getValueAt(i, "VAL_PESO")).intValue());
            Integer divisor = new Integer(((BigDecimal) rs.getValueAt(i,
                        "VAL_DIVI")).intValue());
            Integer numDiasCobr;
            BigDecimal decNumDiasCobr = (BigDecimal) rs.getValueAt(i,
                    "NUM_DIAS_COBR");
            numDiasCobr = (decNumDiasCobr != null)
                ? new Integer(decNumDiasCobr.intValue()) : new Integer(0);

            Boolean aplicable;

            if (((BigDecimal) rs.getValueAt(i, "NUM_APLI")).intValue() != 0){
                aplicable = Boolean.TRUE;
            } else {
                aplicable = Boolean.FALSE;
            }

            value.setPeso(peso);
            value.setDivisor(divisor);
            value.setNumeroDiasCobranza(numDiasCobr);
            value.setAplicable(aplicable);

            map.put(key, value);
        }

        concurso.setVariablesVentaConcursoRanking(map);
        UtilidadesLog.info("DAOConcursos.recuperarVariablesVentaRankingConcur"
            +"so(Concurso concurso):Salida");

        return map;
    }

    /**
     * Este metodo obtiene los oids de INC_PEDID_CONCU_RECOM
     * para la reversion
     *
     * Sistema: Belcorp
     * Módulo:  INC
     * Fecha:   1/09/2005
     * @version 1.00
     * @autor   Julián Rivas
     */
    public DTOOIDs obtenerPedidoConcursoRecomendada(Long recomendado,
        Long concurso, Long periodo, Long recomendante, Long gerente)
        throws MareException {
        UtilidadesLog.info("DAOConcursos.obtenerPedidoConcursoRecomendada(Long"
            +"recomendado, Long concurso, Long periodo, Long recomendante, "
            +"Long gerente):Entrada");

        BelcorpService bs;
        RecordSet respuesta;
        String codigoError;
        StringBuffer query = new StringBuffer();

        try {
            bs = BelcorpService.getInstance();
        } catch (MareMiiServiceNotFoundException e) {
            UtilidadesLog.error("ERROR ", e);
            codigoError = CodigosError.ERROR_AL_PEDIR_UN_SERVICIO_MARE;
            throw new MareException(e,
                UtilidadesError.armarCodigoError(codigoError));
        }

        try {
            query.append(" SELECT OID_PEDI_CONC_RECO ");
            query.append(" FROM INC_PEDID_CONCU_RECOM PCR, ");
            query.append(" INC_CLIEN_RECTE RTE ");

            if (recomendado != null) {
                query.append(", INC_CLIEN_RECDO RDO ");
            }

            query.append(" WHERE PCR.CLR3_OID_CLIE_RETE = RTE.OID_CLIE_RETE ");
            query.append(" AND PCR.COPA_OID_PARA_GRAL = " + concurso);
            query.append(" AND PCR.PERD_OID_PERI = " + periodo);
            query.append(" AND RTE.CLIE_OID_CLIE = " + recomendante);

            if (gerente != null) {
                query.append(" AND PCR.CLIE_OID_CLIE = " + gerente);
            }

            if (gerente == null) {
                query.append(" AND PCR.CLIE_OID_CLIE IS NULL ");
            }

            if (recomendado != null) {
                query.append(" AND RDO.CLIE_OID_CLIE = " + recomendado);
                query.append(" AND PCR.CLRE_OID_CLIE_REDO =  ");
                query.append(" RDO.OID_CLIE_REDO ");
                query.append(" AND RTE.OID_CLIE_RETE =  ");
                query.append(" RDO.CLR3_OID_CLIE_RETE ");
            }

            if (recomendado == null) {
                query.append(" AND PCR.CLRE_OID_CLIE_REDO IS NULL ");
            }

            respuesta = bs.dbService.executeStaticQuery(query.toString());
            UtilidadesLog.debug("obtenerPedidoConcursoRecomendada respuesta " +
                respuesta);
        } catch (Exception e) {
            UtilidadesLog.error("ERROR ", e);
            codigoError = CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS;
            throw new MareException(e,
                UtilidadesError.armarCodigoError(codigoError));
        }

        DTOOIDs output = new DTOOIDs();
        Long[] ids = new Long[respuesta.getRowCount()];

        for (int i = 0; i < respuesta.getRowCount(); i++) {
            ids[i] = new Long(((BigDecimal) respuesta.getValueAt(i,
                        "OID_PEDI_CONC_RECO")).longValue());
        }

        output.setOids(ids);

        UtilidadesLog.info("DAOConcursos.obtenerPedidoConcursoRecomendada(Long"
            +"recomendado, Long concurso, Long periodo, Long recomendante, "
            +"Long gerente):Salida");

        return output;
    }
    
    /**
     * Sistema: Belcorp
     * Módulo:  INC
     * Fecha:   22/09/2005
     * @version 1.00
     * @autor   Viviana Bongiovanni
     */
  public void obtenerPeriodosVigenciaMultinivel(Concurso concurso) throws MareException {
      UtilidadesLog.info(" DAOConcursos.obtenerPeriodosVigenciaMultinivel(Concurso concurso):Entrada");
      UtilidadesLog.debug("Entre con oidConcurso: " + concurso.getOidConcurso());
    
      StringBuffer query = new StringBuffer();
      RecordSet rs = new RecordSet();
      BelcorpService belcorpService = null;
    
      query.append(" SELECT mul.PERD_OID_PERI_DESD, mul.PERD_OID_PERI ");
      query.append(" FROM INC_MULTI mul  ");
      query.append(" WHERE mul.COPA_OID_PARA_GRAL = " + concurso.getOidConcurso());
    
      try {
          rs = belcorpService.getInstance().dbService.executeStaticQuery(query.toString());
      } catch (Exception e) {
          UtilidadesLog.error("ERROR ", e);
          throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS));
      }
      
      UtilidadesLog.debug("resultado: " + rs);
      
      if(!rs.esVacio()){
          DAOClientePremiacion dao = new DAOClientePremiacion();
          
          Long oidPeriodoDesde = Long.valueOf(((BigDecimal)rs.getValueAt(0, "PERD_OID_PERI_DESD")).toString());
          Periodo periodoDesde = dao.obtenerPeriodo(oidPeriodoDesde,0);
          
          UtilidadesLog.debug("periodoDesde: " + periodoDesde.getOidPeriodo());
          concurso.setPeriodoDesdeMultinivel(periodoDesde);
          
          Long oidPeriodoHasta = Long.valueOf(((BigDecimal)rs.getValueAt(0, "PERD_OID_PERI")).toString());
          Periodo periodoHasta = dao.obtenerPeriodo(oidPeriodoHasta,0);
          
          UtilidadesLog.debug("periodoHasta: " + periodoHasta.getOidPeriodo());
          concurso.setPeriodoHastaMultinivel(periodoHasta);
      }
     
      UtilidadesLog.info("DAOConcursos.obtenerPeriodosVigenciaMultinivel(Concurso concurso):Salida");
  }
  
    /**
     * @throws es.indra.mare.common.exception.MareException
     * @return 
     * @param oidPais
     * jrivas inc. 22126 17/12/2005
     */
    public ArrayList obtenerConcursosMontoUnidades(Long oidPais) throws MareException {
        UtilidadesLog.info("DAOConcursos.obtenerConcursosMontoUnidades():Entrada");
        Cronometrador.startTransaction("DAOConcursos.obtenerConcursosMontoUnidades");
        FactoriaConcurso factoria = FactoriaConcurso.getFactoriaConcurso();
        ArrayList arrConcursos = factoria.getConcursos(oidPais);
        ArrayList arrConcBuscados = new ArrayList();
    
        String periodoProceso = "";
    
        Iterator it = arrConcursos.iterator();
        Concurso concurso;
        while (it.hasNext()) {
            concurso = (Concurso) it.next();
            
            String periodoDesde = "";
            String periodoHasta = "";
            
            if(concurso.getPeriodoDesde()!=null)
                periodoDesde = concurso.getPeriodoDesde().getCodperiodo();
            if(concurso.getPeriodoHasta()!=null)
                periodoHasta = concurso.getPeriodoHasta().getCodperiodo();
            
            // vbongiov -- Cambio 20080809 -- 7/04/2009
            if ((ConstantesINC.OID_BASE_CALCULO_MONTO.equals(concurso.getBaseCalculo()) ||
                ConstantesINC.OID_BASE_CALCULO_UNIDADES.equals(concurso.getBaseCalculo())) &&
                !concurso.getProgramaNuevas() && !concurso.getIndRanking() && !concurso.getIndNoGeneraPunt() &&
                
                // sapaza -- PER-SiCC-2014-0753 -- 10/09/2014
                (concurso.getPeriodoProceso().compareTo(periodoDesde)>=0) &&
                (concurso.getIndActividad() || concurso.getIndConstancia() || concurso.getPeriodoProceso().compareTo(periodoHasta)<=0) &&
                
                 concurso.getDirigidoA().equals(ConstantesINC.OID_DIRIGIDO_A_CONSULTORAS)  && 
                 !concurso.getMultiNivel()) {
                    arrConcBuscados.add(concurso);
                }
        }
        
        UtilidadesLog.info("DAOConcursos.obtenerConcursosMontoUnidades():Salida");
        Cronometrador.endTransaction("DAOConcursos.obtenerConcursosMontoUnidades");
        return arrConcBuscados;
    }
    
    /**
     * @throws es.indra.mare.common.exception.MareException
     * @return 
     * @param oidPais
     * jrivas inc. 22126 17/12/2005
     */
    public ArrayList obtenerConcursosProgramaNuevas(Long oidPais) throws MareException {
        UtilidadesLog.info("DAOConcursos.obtenerConcursosProgramaNuevas():Entrada");

        FactoriaConcurso factoria = FactoriaConcurso.getFactoriaConcurso();
        ArrayList arrConcursos = factoria.getConcursos(oidPais);
        ArrayList arrConcBuscados = new ArrayList();
    
        Iterator it = arrConcursos.iterator();
        Concurso concurso;
        while (it.hasNext()) {
            concurso = (Concurso) it.next();
            if (ConstantesINC.OID_BASE_CALCULO_NPEDIDOS.equals(concurso.getBaseCalculo()) &&
                 concurso.getProgramaNuevas() && !concurso.getIndRanking() &&
                 concurso.getDirigidoA().equals(ConstantesINC.OID_DIRIGIDO_A_CONSULTORAS)  && 
                 !concurso.getMultiNivel()) {
                    arrConcBuscados.add(concurso);
                }
        }

        UtilidadesLog.info("DAOConcursos.obtenerConcursosProgramaNuevas():Salida");
        return arrConcBuscados;
    }
    
    /**
     * @throws es.indra.mare.common.exception.MareException
     * @return 
     * @param oidPais
     * jrivas inc. 22126 17/12/2005
     */
    public ArrayList obtenerConcursosNumeroPedidos(Long oidPais) throws MareException {
        UtilidadesLog.info("DAOConcursos.obtenerConcursosNumeroPedidos():Entrada");

        FactoriaConcurso factoria = FactoriaConcurso.getFactoriaConcurso();
        ArrayList arrConcursos = factoria.getConcursos(oidPais);
        ArrayList arrConcBuscados = new ArrayList();
    
        Iterator it = arrConcursos.iterator();
        Concurso concurso;
        while (it.hasNext()) {
            concurso = (Concurso) it.next();
            if (ConstantesINC.OID_BASE_CALCULO_NPEDIDOS.equals(concurso.getBaseCalculo()) &&
                 !concurso.getProgramaNuevas() && !concurso.getIndRanking() &&
                 concurso.getDirigidoA().equals(ConstantesINC.OID_DIRIGIDO_A_CONSULTORAS)  && 
                 !concurso.getMultiNivel()) {
                    arrConcBuscados.add(concurso);
                }
        }

        UtilidadesLog.info("DAOConcursos.obtenerConcursosNumeroPedidos():Salida");
        return arrConcBuscados;
    }
    
    /**
     * @throws es.indra.mare.common.exception.MareException
     * @return 
     * @param oidPais
     * jrivas inc. 22126 17/12/2005
     */
    public ArrayList obtenerConcursosRecomendacion(Long oidPais) throws MareException {
        UtilidadesLog.info("DAOConcursos.obtenerConcursosRecomendacion():Entrada");

        FactoriaConcurso factoria = FactoriaConcurso.getFactoriaConcurso();
        ArrayList arrConcursos = factoria.getConcursos(oidPais);
        ArrayList arrConcBuscados = new ArrayList();
        
        Iterator it = arrConcursos.iterator();
        Concurso concurso;
        while (it.hasNext()) {
            concurso = (Concurso) it.next();
            if (ConstantesINC.OID_BASE_CALCULO_RECOMENDADAS.equals(concurso.getBaseCalculo()) &&
                 !concurso.getProgramaNuevas() && !concurso.getIndRanking() &&
                 concurso.getDirigidoA().equals(ConstantesINC.OID_DIRIGIDO_A_CONSULTORAS)  && 
                 !concurso.getMultiNivel()) {
                    arrConcBuscados.add(concurso);
                }
        }

        UtilidadesLog.info("DAOConcursos.obtenerConcursosRecomendacion():Salida");
        return arrConcBuscados;
    }  
    
    /**
     * @throws es.indra.mare.common.exception.MareException
     * @return 
     * @param oidPaisobtenerListaProductos
     * vbongiov 13/03/2006 -- INC46 y INC60
     */
    public ArrayList obtenerConcursosCierre(Long oidPais) throws MareException {
        UtilidadesLog.info("DAOConcursos.obtenerConcursosCierre(Long oidPais):Entrada");

        FactoriaConcurso factoria = FactoriaConcurso.getFactoriaConcurso();
        ArrayList arrConcursos = factoria.getConcursos(oidPais);
        ArrayList arrConcBuscados = new ArrayList();
    
        Iterator it = arrConcursos.iterator();
        Concurso concurso;
        while (it.hasNext()) {
            concurso = (Concurso) it.next();
            // INC 114 - vbongiov - 7/06/2006
            if (((concurso.getDirigidoA().equals(ConstantesINC.OID_DIRIGIDO_A_GERENTE) || concurso.getMultiNivel()) && 
                 !concurso.getProgramaNuevas() && !concurso.getIndRanking()) ||
                     (concurso.getIndRanking() && ((concurso.getDirigidoA().equals(ConstantesINC.OID_DIRIGIDO_A_GERENTE) &&
                      ConstantesINC.OID_FORMA_CALC_VARIABLES_VTA.equals(concurso.getFormaCalculo())) ||
                      ConstantesINC.TIPO_RANKING_EVOLUTIVO.equals(concurso.getTipoRanking()))))  {
                    arrConcBuscados.add(concurso);
                }
        }

        UtilidadesLog.info("DAOConcursos.obtenerConcursosCierre(Long oidPais):Salida");
        return arrConcBuscados;
    }
    
    //jrivas 25/1/2007 Cambio Dupla Cyzone
    private void obtenerTipificacionesClientesCalificacion(Concurso concurso)
        throws MareException {
        UtilidadesLog.info(
            "DAOConcursos.obtenerTipificacionesClientesCalificacion(Concurso"
                +"concurso):Entrada");

        BelcorpService bs;
        RecordSet respuesta;
        String codigoError;
        StringBuffer query = new StringBuffer();

        try {
            bs = BelcorpService.getInstance();
        } catch (MareMiiServiceNotFoundException e) {
            UtilidadesLog.error("ERROR ", e);
            codigoError = CodigosError.ERROR_AL_PEDIR_UN_SERVICIO_MARE;
            throw new MareException(e,
                UtilidadesError.armarCodigoError(codigoError));
        }

        try {
            query.append(" SELECT ");
            query.append(" PARD.TICL_OID_TIPO_CLIE, ");
            query.append(" PARD.SBTI_OID_SUBT_CLIE, ");
            query.append(" PARD.TCCL_OID_TIPO_CLAS, ");
            query.append(" PARD.CLAS_OID_CLAS ");
            query.append(" FROM ");
            query.append(" INC_CLASI_PARTI_CALIF CLA, ");
            query.append(" INC_PARTI_CONCU_CABEC PARC, ");
            query.append(" INC_PARTI_CONCU_DETAL PARD ");
            query.append(" WHERE ");
            query.append(
                " CLA.PACI_OID_PART_CONC_CABE = PARC.OID_PART_CONC_CABE ");
            query.append(" AND PARC.OID_PART_CONC_CABE =  ");
            query.append(" PARD.PACI_OID_PART_CONC_CABE ");
            query.append(" AND CLA.COPA_OID_PARA_GRAL = ").append(
                concurso.getOidConcurso());
            
            respuesta = bs.dbService.executeStaticQuery(query.toString());
        } catch (Exception e) {
            UtilidadesLog.error("ERROR ", e);
            codigoError = CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS;
            throw new MareException(e,
                UtilidadesError.armarCodigoError(codigoError));
        }

        if (respuesta.esVacio()) {
            // vbongiov -- 20090851 -- 3/04/2009
            concurso.setTipificacionesClientesCalificacion(null);
        } else {
            TipificacionCliente[] tipificaciones = 
                new TipificacionCliente[respuesta.getRowCount()];

            for (int i = 0; i < respuesta.getRowCount(); i++) {
                tipificaciones[i] = new TipificacionCliente();
                tipificaciones[i].setOidTipoCliente(new Long(
                        ((BigDecimal) respuesta.getValueAt(i,
                            "TICL_OID_TIPO_CLIE")).longValue()));

                {
                    BigDecimal subtipoCliente = (BigDecimal) 
                        respuesta.getValueAt(i, "SBTI_OID_SUBT_CLIE");
                    tipificaciones[i].setOidSubTipoCliente((
                            subtipoCliente != null)
                        ? new Long(subtipoCliente.longValue()) : null);
                }

                {
                    BigDecimal tipoClasificacionCliente = (BigDecimal) 
                        respuesta.getValueAt(i,"TCCL_OID_TIPO_CLAS");
                    tipificaciones[i].setOidTipoClasificacionCliente((
                        tipoClasificacionCliente != null)
                        ? new Long(tipoClasificacionCliente.longValue())
                            : null);
                }

                {
                    BigDecimal clasificacionCliente = (BigDecimal) 
                        respuesta.getValueAt(i,"CLAS_OID_CLAS");
                    tipificaciones[i].setOidClasificacionCliente((
                        clasificacionCliente != null)? new Long(
                            clasificacionCliente.longValue()) : null);
                }
            }

            concurso.setTipificacionesClientesCalificacion(tipificaciones);
        }

        UtilidadesLog.info("DAOConcursos.obtenerTipificacionesClientesCalificacion"
            +"antes(Concurso concurso):Salida");
    }    
    
    private ProductosLocalHome getProductosLocalHome() {
            return new ProductosLocalHome();
    }
    
    // vbongiov -- Cambio 20080811 -- 26/08/2009
    private void obtenerParametrosSorteo(Concurso concurso) throws MareException {
        UtilidadesLog.info("DAOConcursos.obtenerParametrosSorteo(Concurso concurso):Entrada");

        BelcorpService bs;
        RecordSet respuesta;
        String codigoError;
        StringBuffer query = new StringBuffer();

        try {
            bs = BelcorpService.getInstance();
        } catch (MareMiiServiceNotFoundException e) {
            UtilidadesLog.error("ERROR ", e);
            codigoError = CodigosError.ERROR_AL_PEDIR_UN_SERVICIO_MARE;
            throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));
        }

        try {
        
            query.append(" SELECT sor.NUM_ASIG, prod.DES_CORT ");
            query.append(" FROM INC_PREMI_SORTE sor, INC_PARAM_NIVEL_PREMI niv, ");
            query.append(" INC_PARAM_GENER_PREMI prem, MAE_PRODU prod ");
            query.append(" WHERE sor.PANP_OID_PARA_NIVE_PREM = niv.OID_PARA_NIVE_PREM ");
            query.append(" AND niv.PAGP_OID_PARA_GENE_PREM = prem.OID_PARA_GENE_PREM ");
            query.append(" AND prem.COPA_OID_PARA_GRAL = " + concurso.getOidConcurso());
            query.append(" AND sor.PROD_OID_PROD = prod.OID_PROD ");
                
            respuesta = bs.dbService.executeStaticQuery(query.toString());            
            
        } catch (Exception e) {
            UtilidadesLog.error("ERROR ", e);
            codigoError = CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS;
            throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));
        }

        if (!respuesta.esVacio()) {       
        
            concurso.setCantidadNumerosAOtorgar(new Integer(((BigDecimal) respuesta.getValueAt(0, "NUM_ASIG")).intValue()));
            concurso.setDescProducto((String) respuesta.getValueAt(0, "DES_CORT"));   
        }

        UtilidadesLog.info("DAOConcursos.obtenerParametrosSorteo(Concurso concurso):Salida");
    }

    
    /**
     * Obtenemos el codigo de Periodo a partir del OidPeriodo de CRA_PERIO
     *
     * @date 30/06/2010
     * @cambio PER-SiCC-2010-0399
     * @autor Sergio Apaza
     */
    public String obtenerCodigoPeriodo(Long oidPeriodo) throws MareException {
        UtilidadesLog.info("DAOConcursos.obtenerCodigoPeriodo(Long oidPeriodo):Entrada");

        BelcorpService bs;
        RecordSet rs;
        StringBuffer buf = new StringBuffer();

        try {
            bs = BelcorpService.getInstance();
        } catch (MareMiiServiceNotFoundException e) {
            UtilidadesLog.error("ERROR ", e);
            throw new MareException(e,
                UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_PEDIR_UN_SERVICIO_MARE));
        }

        try {
            buf.append("SELECT C.COD_PERI  ");
            buf.append("FROM cra_perio A, SEG_PERIO_CORPO C  ");
            buf.append("WHERE A.oid_peri = ").append(oidPeriodo);
            buf.append("  AND C.OID_PERI = A.PERI_OID_PERI ");

            rs = bs.dbService.executeStaticQuery(buf.toString());

            String codigoPeriodo = rs.getValueAt(0, "COD_PERI").toString();
            UtilidadesLog.info("DAOConcursos.obtenerCodigoPeriodo(Long oidPeriodo):Salida");

            return codigoPeriodo;
        } catch (Exception e) {
            UtilidadesLog.error("ERROR ", e);
            throw new MareException(e,
                UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS));
        }
    }
    
    // sapaza -- PER-SiCC-2013-0044 -- 28/01/2013
    public Integer calcularCantidadPeriodos(Long oidPeriodoInicio, Long oidPeriodoFin) throws MareException {
        UtilidadesLog.info("DAOConcursos.calcularCantidadPeriodos(Long oidPeriodoInicio, Long oidPeriodoFin):Entrada");

        BelcorpService bs;
        RecordSet rs;
        StringBuffer buf = new StringBuffer();

        try {
            bs = BelcorpService.getInstance();
        } catch (MareMiiServiceNotFoundException e) {
            UtilidadesLog.error("ERROR ", e);
            throw new MareException(e,
                UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_PEDIR_UN_SERVICIO_MARE));
        }
        
        try {
            buf.append("SELECT COUNT(1) ");
            buf.append("  FROM CRA_PERIO P1,   ");
            buf.append("       SEG_PERIO_CORPO C1, ");
            buf.append("       CRA_PERIO P2, ");
            buf.append("       SEG_PERIO_CORPO C2, ");
            buf.append("       CRA_PERIO P3, ");
            buf.append("       SEG_PERIO_CORPO C3 ");
            buf.append("  WHERE P1.OID_PERI = " + oidPeriodoInicio);
            buf.append("    AND P2.OID_PERI = " + oidPeriodoFin);
            buf.append("    AND P1.PERI_OID_PERI = C1.OID_PERI ");
            buf.append("    AND P2.PERI_OID_PERI = C2.OID_PERI ");
            buf.append("    AND P3.PERI_OID_PERI = C3.OID_PERI ");
            buf.append("    AND C3.COD_PERI >= C1.COD_PERI ");
            buf.append("    AND C3.COD_PERI <= C2.COD_PERI ");

            rs = bs.dbService.executeStaticQuery(buf.toString());

            Integer resultado = ((BigDecimal)rs.getValueAt(0, 0)).intValue();
            UtilidadesLog.info("DAOConcursos.calcularCantidadPeriodos(Long oidPeriodoInicio, Long oidPeriodoFin):Salida");

            return resultado;
        } catch (Exception e) {
            UtilidadesLog.error("ERROR ", e);
            throw new MareException(e,
                UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS));
        }
    }
    
    // sapaza -- PER-SiCC-2014-0753 -- 08/09/2014  
    public String obtenerPeriodoProceso() throws MareException {
        UtilidadesLog.info("DAOConcursos.obtenerPeriodoProceso(): Entrada ");

        BelcorpService bs;
        RecordSet rs;
        StringBuffer query = new StringBuffer();

        try {
            bs = BelcorpService.getInstance();
        } catch (MareMiiServiceNotFoundException e) {
            UtilidadesLog.error("ERROR ", e);
            throw new MareException(e,
                UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_PEDIR_UN_SERVICIO_MARE));
        }
        
        try {
            query.append(" SELECT CTRL.COD_PERI ");
            query.append("   FROM BAS_CTRL_FACT CTRL ");
            query.append("  WHERE CTRL.sta_camp = 0 ");
            query.append("    AND CTRL.ind_camp_act = 1 ");

            rs = bs.dbService.executeStaticQuery(query.toString());

            String codigoPeriodo = rs.getValueAt(0, 0).toString();
            UtilidadesLog.info("DAOConcursos.obtenerPeriodoProceso(): Salida ");

            return codigoPeriodo;
        } catch (Exception e) {
            UtilidadesLog.error("ERROR ", e);
            throw new MareException(e,
                UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS));
        }
        
    }  
    
}
