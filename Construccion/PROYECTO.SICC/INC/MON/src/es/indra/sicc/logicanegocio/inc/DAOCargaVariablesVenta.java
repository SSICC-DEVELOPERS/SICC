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
 *  @author: Carlos Leal
 *  
 * @NOTA: Modificado por revision de Auditoria
 * @autor: Paola Cabrera
 * @fecha: 20/09/2005 
 * 
 */
package es.indra.sicc.logicanegocio.inc;

import es.indra.mare.common.exception.MareException;
import es.indra.mare.common.mii.MareMiiServiceNotFoundException;
import es.indra.mare.common.mii.services.jdbcservice.RecordSet;

import es.indra.sicc.dtos.fac.DTOFACProcesoCierre;
import es.indra.sicc.dtos.inc.DTOETramitarCierre;
import es.indra.sicc.dtos.inc.DTOResultadoConcursoVariablesVenta;
import es.indra.sicc.entidades.inc.CandidataGanadoraLocal;
import es.indra.sicc.entidades.inc.CandidataGanadoraLocalHome;
import es.indra.sicc.entidades.inc.MetasVentaProyectadaRegionLocal;
import es.indra.sicc.entidades.inc.MetasVentaProyectadaRegionLocalHome;
import es.indra.sicc.entidades.inc.MetasVentaProyectadaSubgerenciaVentaLocal;
import es.indra.sicc.entidades.inc.MetasVentaProyectadaSubgerenciaVentaLocalHome;
import es.indra.sicc.entidades.inc.MetasVentaProyectadaZonaLocal;
import es.indra.sicc.entidades.inc.MetasVentaProyectadaZonaLocalHome;
import es.indra.sicc.entidades.inc.ResultadosVentaProyectadaRegioLocal;
import es.indra.sicc.entidades.inc.ResultadosVentaProyectadaRegioLocalHome;
import es.indra.sicc.entidades.inc.ResultadosVentaProyectadaSubgeLocal;
import es.indra.sicc.entidades.inc.ResultadosVentaProyectadaSubgeLocalHome;
import es.indra.sicc.entidades.inc.ResultadosVentaProyectadaZonaLocal;
import es.indra.sicc.entidades.inc.ResultadosVentaProyectadaZonaLocalHome;
import es.indra.sicc.logicanegocio.cal.ConstantesCAL;
import es.indra.sicc.logicanegocio.inc.ConstantesINC;
import es.indra.sicc.logicanegocio.mae.ConstantesMAE;
import es.indra.sicc.util.BelcorpService;
import es.indra.sicc.util.CodigosError;
import es.indra.sicc.util.UtilidadesError;
import es.indra.sicc.util.UtilidadesLog;

import java.math.BigDecimal;

import java.sql.Date;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

import javax.persistence.NoResultException;
import javax.persistence.PersistenceException;


public class DAOCargaVariablesVenta {
    /**
    * @throws es.indra.mare.common.exception.MareException
    * @return
    * @param dtoe
    * @version 1.00 08/06/2005
    * @author: Carlos Leal
    *
    * Descripcion: obtiene los gerentes y concursos relacionados junto con los
    * totales de monto y unidades para un periodo.
    */
    public RecordSet obtenerGerentesConcursos(DTOFACProcesoCierre dtoe)
        throws MareException {
        UtilidadesLog.info("DAOCargaVariablesVenta.obtenerGerentesConcursos"
            +"(DTOFACProcesoCierre dtoe):Entrada");

        RecordSet rs = new RecordSet();
        StringBuffer query = new StringBuffer();
        BelcorpService bs;

        try {
            bs = BelcorpService.getInstance();
        } catch (MareMiiServiceNotFoundException ex) {
            UtilidadesLog.error("ERROR ", ex);
            throw new MareException(ex,
                UtilidadesError.armarCodigoError(
                    CodigosError.ERROR_AL_PEDIR_UN_SERVICIO_MARE));
        }

        query.append(" SELECT OID_PARA_GRAL, CLIE_OID_CLIE, OID_SUBG_VENT, ");
        query.append(" OID_REGI, OID_ZONA, OID_SECC, OID_TERR_ADMI, VAL_AMBI_GEOG_COMP FROM (");
        query.append(" SELECT distinct cPG.OID_PARA_GRAL, ");
        query.append(" CLI_CON.CLIE_OID_CLIE, UNID_ADMIN.OID_SUBG_VENT, ");
        query.append(
            "UNID_ADMIN.OID_REGI, UNID_ADMIN.OID_ZONA,UNID_ADMIN.OID_SECC, ");
        query.append("UNID_ADMIN.OID_TERR_ADMI, IPC.VAL_AMBI_GEOG_COMP ");
        query.append("FROM INC_CONCU_PARAM_GENER CPG, INC_PLANT_CONCU IPC, ");
        query.append("INC_CONCU_PARAM_GEREN CPR, ");
        query.append(" cra_perio cp1, cra_perio cp2, cra_perio cp3, ");
        query.append("( SELECT TIC.CLIE_OID_CLIE, COPA_OID_PARA_GRAL ");
        query.append("FROM INC_CLASI_PARTI_CONCU PAC, ");
        query.append("INC_PARTI_CONCU_DETAL PAD, ");
        query.append("V_MAE_TIPIF_CLIEN TIC ");
        query.append(
            "WHERE PAC.PACI_OID_PART_CONC_CABE = PAD.PACI_OID_PART_CONC_CABE ");
        query.append(" AND NVL(PAD.TICL_OID_TIPO_CLIE,-1) = ");
        query.append(" DECODE(PAD.TICL_OID_TIPO_CLIE, NULL, -1, ");
        query.append(" TIC.TICL_OID_TIPO_CLIE) ");
        query.append(" AND NVL(PAD.SBTI_OID_SUBT_CLIE,-1) = ");
        query.append(" DECODE(PAD.SBTI_OID_SUBT_CLIE, NULL, -1, ");
        query.append(" TIC.SBTI_OID_SUBT_CLIE) ");
        query.append(" AND NVL(PAD.TCCL_OID_TIPO_CLAS,-1) = ");
        query.append(" DECODE(PAD.TCCL_OID_TIPO_CLAS, NULL, -1, ");
        query.append(" TIC.TCCL_OID_TIPO_CLASI) ");
        query.append(" AND NVL(PAD.CLAS_OID_CLAS,-1) = ");
        query.append(" DECODE(PAD.CLAS_OID_CLAS, NULL, -1, ");
        query.append(" TIC.CLAS_OID_CLAS)) CLI_CON, ");
        // vbongiov -- 6/04/2006 - inc 22684
        query.append(" (SELECT SUB.OID_SUBG_VENT, NULL OID_REGI, NULL OID_ZONA, ");
        query.append(" NULL OID_SECC,NULL OID_TERR_ADMI, SUB.CLIE_OID_CLIE ");
        query.append(" FROM ZON_SUB_GEREN_VENTA SUB ");
        query.append(" WHERE SUB.CLIE_OID_CLIE IS NOT NULL ");
        query.append(" UNION ");
        query.append(" SELECT SUB.OID_SUBG_VENT, REG.OID_REGI, NULL OID_ZONA, ");
        query.append(" NULL OID_SECC, NULL OID_TERR_ADMI, REG.CLIE_OID_CLIE ");
        query.append(" FROM ZON_SUB_GEREN_VENTA SUB, ZON_REGIO REG ");
        query.append(" WHERE SUB.OID_SUBG_VENT = REG.ZSGV_OID_SUBG_VENT ");
        query.append(" AND REG.CLIE_OID_CLIE IS NOT NULL ");
        query.append(" UNION ");
        query.append(" SELECT SUB.OID_SUBG_VENT, REG.OID_REGI, ZON.OID_ZONA, ");
        query.append(" NULL OID_SECC, NULL OID_TERR_ADMI, ZON.CLIE_OID_CLIE ");
        query.append(" FROM ZON_SUB_GEREN_VENTA SUB, ZON_REGIO REG, ZON_ZONA ZON ");
        query.append(" WHERE SUB.OID_SUBG_VENT = REG.ZSGV_OID_SUBG_VENT ");
        query.append(" AND REG.OID_REGI = ZON.ZORG_OID_REGI ");
        query.append(" AND ZON.CLIE_OID_CLIE IS NOT NULL ");
        query.append(" UNION ");
        query.append(" SELECT SUB.OID_SUBG_VENT, REG.OID_REGI, ZON.OID_ZONA,  ");
        query.append(" SEC.OID_SECC, NULL OID_TERR_ADMI, SEC.CLIE_OID_CLIE  ");
        query.append(" FROM ZON_SUB_GEREN_VENTA SUB, ZON_REGIO REG, ZON_ZONA ZON, ZON_SECCI SEC ");
        query.append(" WHERE SUB.OID_SUBG_VENT = REG.ZSGV_OID_SUBG_VENT ");
        query.append(" AND REG.OID_REGI = ZON.ZORG_OID_REGI ");
        query.append(" AND ZON.OID_ZONA = SEC.ZZON_OID_ZONA ");
        query.append(" AND SEC.CLIE_OID_CLIE IS NOT NULL ");
        query.append(") UNID_ADMIN ");
        query.append("WHERE CPG.OID_PARA_GRAL = CPR.COPA_OID_PARA_GRAL ");
        query.append("AND CPG.IND_ACTI = 1 ");
        query.append("AND CPG.PLC2_OID_PLAN_CONC = IPC.OID_PLAN_CONC ");
        query.append("AND IPC.VAL_PART  = 0 AND ");

        query.append(" cp1.oid_peri = CPG.PERD_OID_PERI_DESD  AND ");
        query.append(" cp2.oid_peri = CPG.PERD_OID_PERI_HAST  AND ");
        query.append(" cp1.FEC_INIC <= cp3.FEC_INIC AND ");
        query.append(" cp2.FEC_FINA >= cp3.FEC_FINA AND ");
        query.append(" cp3.oid_peri = " + dtoe.getPeriodo());

        query.append("AND CPG.DIRI_OID_DIRI = " + ConstantesINC.TIPO_GERENTE);
        query.append("AND CPR.FCAL_OID_FORM_CALC = " +
            ConstantesINC.OID_FORMA_CALC_VARIABLES_VTA);
        query.append("AND CPR.COPA_OID_PARA_GRAL = CLI_CON.COPA_OID_PARA_GRAL ");
        query.append("AND CLI_CON.CLIE_OID_CLIE = UNID_ADMIN.CLIE_OID_CLIE ");

        query.append("UNION ");

        query.append(" SELECT distinct CPG.OID_PARA_GRAL, CLI_CON.OID_CLIE, ");
        query.append(" UNID_ADMIN.OID_SUBG_VENT, ");
        query.append( "UNID_ADMIN.OID_REGI, UNID_ADMIN.OID_ZONA, ");
        query.append(" UNID_ADMIN.OID_SECC, ");
        query.append(" UNID_ADMIN.OID_TERR_ADMI, IPC.VAL_AMBI_GEOG_COMP ");
        query.append(" FROM INC_PLANT_CONCU IPC, INC_CONCU_PARAM_GENER CPG, ");
        query.append(" INC_CONCU_PARAM_GEREN CPR, ");
        query.append("cra_perio cp1, cra_perio cp2, cra_perio cp3, ");

        query.append("(  SELECT a.OID_CLIE ");
        query.append( "   FROM MAE_CLIEN a, MAE_CLIEN_TIPO_SUBTI c, ");
        query.append(" MAE_CLIEN_DATOS_ADICI adic ");
        query.append("   WHERE  c.TICL_OID_TIPO_CLIE = " +
            ConstantesMAE.OID_TIPO_CLIENTE_GERENTE);
        query.append("   AND a.OID_CLIE = c.CLIE_OID_CLIE ");
        query.append("   AND adic.CLIE_OID_CLIE = a.OID_CLIE ");
        query.append("   AND a.PAIS_OID_PAIS = " + dtoe.getOidPais());
        query.append("   AND adic.IND_ACTI =" + ConstantesCAL.ACTIVO +
            " ) CLI_CON, ");
        // vbongiov -- 6/04/2006 - inc 22684
        query.append(" (SELECT SUB.OID_SUBG_VENT, NULL OID_REGI, NULL OID_ZONA, ");
        query.append(" NULL OID_SECC,NULL OID_TERR_ADMI, SUB.CLIE_OID_CLIE ");
        query.append(" FROM ZON_SUB_GEREN_VENTA SUB ");
        query.append(" WHERE SUB.CLIE_OID_CLIE IS NOT NULL ");
        query.append(" UNION ");
        query.append(" SELECT SUB.OID_SUBG_VENT, REG.OID_REGI, NULL OID_ZONA, ");
        query.append(" NULL OID_SECC, NULL OID_TERR_ADMI, REG.CLIE_OID_CLIE ");
        query.append(" FROM ZON_SUB_GEREN_VENTA SUB, ZON_REGIO REG ");
        query.append(" WHERE SUB.OID_SUBG_VENT = REG.ZSGV_OID_SUBG_VENT ");
        query.append(" AND REG.CLIE_OID_CLIE IS NOT NULL ");
        query.append(" UNION ");
        query.append(" SELECT SUB.OID_SUBG_VENT, REG.OID_REGI, ZON.OID_ZONA, ");
        query.append(" NULL OID_SECC, NULL OID_TERR_ADMI, ZON.CLIE_OID_CLIE ");
        query.append(" FROM ZON_SUB_GEREN_VENTA SUB, ZON_REGIO REG, ZON_ZONA ZON ");
        query.append(" WHERE SUB.OID_SUBG_VENT = REG.ZSGV_OID_SUBG_VENT ");
        query.append(" AND REG.OID_REGI = ZON.ZORG_OID_REGI ");
        query.append(" AND ZON.CLIE_OID_CLIE IS NOT NULL ");
        query.append(" UNION ");
        query.append(" SELECT SUB.OID_SUBG_VENT, REG.OID_REGI, ZON.OID_ZONA,  ");
        query.append(" SEC.OID_SECC, NULL OID_TERR_ADMI, SEC.CLIE_OID_CLIE  ");
        query.append(" FROM ZON_SUB_GEREN_VENTA SUB, ZON_REGIO REG, ZON_ZONA ZON, ZON_SECCI SEC ");
        query.append(" WHERE SUB.OID_SUBG_VENT = REG.ZSGV_OID_SUBG_VENT ");
        query.append(" AND REG.OID_REGI = ZON.ZORG_OID_REGI ");
        query.append(" AND ZON.OID_ZONA = SEC.ZZON_OID_ZONA ");
        query.append(" AND SEC.CLIE_OID_CLIE IS NOT NULL ");
        query.append(") UNID_ADMIN ");
        query.append("WHERE   CPG.OID_PARA_GRAL = CPR.COPA_OID_PARA_GRAL ");
        query.append("AND CPG.IND_ACTI =" + ConstantesCAL.ACTIVO);
        query.append("AND CPG.PLC2_OID_PLAN_CONC = IPC.OID_PLAN_CONC  ");
        query.append("AND IPC.VAL_PART  = 1 AND ");
        query.append(" cp1.oid_peri = CPG.PERD_OID_PERI_DESD  AND ");
        query.append(" cp2.oid_peri = CPG.PERD_OID_PERI_HAST  AND ");
        query.append(" cp1.FEC_INIC <= cp3.FEC_INIC AND ");
        query.append(" cp2.FEC_FINA >= cp3.FEC_FINA AND ");
        query.append(" cp3.oid_peri = " + dtoe.getPeriodo());

        query.append("AND CPG.DIRI_OID_DIRI = " + ConstantesINC.TIPO_GERENTE);
        query.append("AND CPR.FCAL_OID_FORM_CALC = " +
            ConstantesINC.OID_FORMA_CALC_VARIABLES_VTA);
        query.append("AND CLI_CON.OID_CLIE = UNID_ADMIN.CLIE_OID_CLIE ");
        query.append(" ) ORDER BY CLIE_OID_CLIE, OID_PARA_GRAL ");

        try {
            rs = bs.dbService.executeStaticQuery(query.toString());
            UtilidadesLog.debug("****rs: " + rs);
        } catch (Exception ex) {
            UtilidadesLog.error("ERROR ", ex);
            throw new MareException(ex,
                UtilidadesError.armarCodigoError(
                    CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS));
        }

        UtilidadesLog.info("DAOCargaVariablesVenta.obtenerGerentesConcursos "
            +"(DTOFACProcesoCierre dtoe):Salida");

        return rs;
    }

    /**
    * @throws es.indra.mare.common.exception.MareException
    * @return HashMap
    * @param Periodo periodoCierre
    * @version 1.00 08/06/2005
    * @author: Carlos Leal
    * Descripcion: recupera los concursos de variables de venta dirigidos a 
    * gerentes.
    */
    public HashMap recuperarConcursosVariablesVenta(Periodo periodoCierre)
        throws MareException {
        UtilidadesLog.info("DAOCargaVariablesVenta.recuperarConcursosVariable"
            +"sVenta(Periodo periodoCierre):Entrada");

        RecordSet rs = new RecordSet();
        StringBuffer query = new StringBuffer();
        BelcorpService bs;
        HashMap hashConcursos = new HashMap();
        BigDecimal ind = null;

        try {
            bs = BelcorpService.getInstance();
        } catch (MareMiiServiceNotFoundException ex) {
            UtilidadesLog.error("ERROR ", ex);
            throw new MareException(ex,
                UtilidadesError.armarCodigoError(
                    CodigosError.ERROR_AL_PEDIR_UN_SERVICIO_MARE));
        }

        query.append(
            "SELECT CPG.OID_PARA_GRAL, CVG.IND_ACVA,CVG.IND_INGR,CVG.IND_REIN, ");
        query.append(" CVG.IND_EGRE, CVG.IND_ENTR, CVG.IND_RECI, CVG.IND_CAPI, ");
        query.append(" CVG.IND_ACTI_FINA, ");
        query.append(" CVG.IND_ADAD, CVG.IND_NUME_PEDI, ");
        query.append(" CVG.IND_PREC_PROM_UNIT, CVG.IND_PROM_VENT_PEDI, ");
        query.append(" CVG.IND_PROM_UNID_PEDI, CVG.IND_PROM_ORDE_PEDI, ");
        query.append(" CVG.IND_RETE,CVG.IND_VENT_ESTA, ");
        query.append(" CVG.VAL_ROTA, ");
        query.append(" CAL.TIDM_OID_TIPO_DETE_META, CPG.PERD_OID_PERI_DESD, ");
        query.append(" CPG.PERD_OID_PERI_HAST, ");
        query.append(" CPG.PAIS_OID_PAIS, CPG.MARC_OID_MARC, ");
        query.append(" CPG.CANA_OID_CANA, PLC.IND_PROD_EXIG ");
        query.append("FROM INC_CONCU_PARAM_GENER CPG, ");
        query.append(" INC_CONCU_PARAM_GEREN CPR, ");
        query.append("INC_CONCU_VARIA_VENTA_GEREN CVG, ");
        query.append("INC_PARAM_CALIF CAL, ");
        query.append("INC_PLANT_CONCU PLC, ");
        query.append(" cra_perio cp1, cra_perio cp2, cra_perio cp3 ");
        query.append("WHERE CPG.OID_PARA_GRAL = CPR.COPA_OID_PARA_GRAL ");
        query.append(" AND CPG.IND_ACTI = 1 AND ");

        query.append(" cp1.oid_peri = CPG.PERD_OID_PERI_DESD  AND ");
        query.append(" cp2.oid_peri = CPG.PERD_OID_PERI_HAST  AND ");
        query.append(" cp1.FEC_INIC <= cp3.FEC_INIC AND ");
        query.append(" cp2.FEC_FINA >= cp3.FEC_FINA AND ");
        query.append(" cp3.oid_peri = " + periodoCierre.getOidPeriodo());

        /* query.append(" AND ( SELECT cp3.oid_peri ");
         query.append(" FROM  cra_perio cp1, cra_perio cp2, cra_perio cp3 ");
         query.append(" WHERE cp1.oid_peri = CPG.PERD_OID_PERI_DESD  AND ");
         query.append(" cp2.oid_peri = CPG.PERD_OID_PERI_HAST  AND ");
         query.append(" cp1.FEC_INIC <= cp3.FEC_INIC AND ");
         query.append(" cp2.FEC_FINA > cp3.FEC_FINA AND ");
         query.append(" cp3.oid_peri = " + periodoCierre.getOidPeriodo());
         query.append(" ) = " + periodoCierre.getOidPeriodo());*/
        query.append(" AND CPG.DIRI_OID_DIRI = " + ConstantesINC.TIPO_GERENTE);
        query.append(" AND CPR.FCAL_OID_FORM_CALC = " +
            ConstantesINC.OID_FORMA_CALC_VARIABLES_VTA);
        query.append(" AND CPG.OID_PARA_GRAL = CVG.COPA_OID_PARA_GRAL ");
        query.append(" AND CPG.OID_PARA_GRAL = CAL.COPA_OID_PARA_GRAL ");
        query.append(" AND CPG.PLC2_OID_PLAN_CONC = PLC.OID_PLAN_CONC ");

        try {
            rs = bs.dbService.executeStaticQuery(query.toString());
            UtilidadesLog.debug("****rs: " + rs);
        } catch (Exception ex) {
            UtilidadesLog.error("ERROR ", ex);
            throw new MareException(ex,
                UtilidadesError.armarCodigoError(
                    CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS));
        }

        if (rs != null) {
            for (int i = 0; i < rs.getRowCount(); i++) {
                ConcursoVariablesVenta conc = new ConcursoVariablesVenta();
                conc.setOidConcurso(new Long(
                        ((BigDecimal) rs.getValueAt(i, "OID_PARA_GRAL"))
                            .longValue()));

                ind = (BigDecimal) rs.getValueAt(i, "IND_ACVA");

                if (ind != null) {
                    conc.setActivas((ind.longValue() == 1) 
                        ? new Boolean(true) : new Boolean(false));
                }

                ind = (BigDecimal) rs.getValueAt(i, "IND_INGR");

                if (ind != null) {
                    conc.setIngreso((ind.longValue() == 1) ? new Boolean(true)
                        : new Boolean(false));
                }

                ind = (BigDecimal) rs.getValueAt(i, "IND_REIN");

                if (ind != null) {
                    conc.setReingreso((ind.longValue() == 1)
                        ? new Boolean(true) : new Boolean(false));
                }

                ind = (BigDecimal) rs.getValueAt(i, "IND_EGRE");

                if (ind != null) {
                    conc.setEgresos((ind.longValue() == 1) ? new Boolean(true)
                        : new Boolean(false));
                }

                ind = (BigDecimal) rs.getValueAt(i, "IND_ENTR");

                if (ind != null) {
                    conc.setEntregadas((ind.longValue() == 1)
                        ? new Boolean(true) : new Boolean(false));
                }

                ind = (BigDecimal) rs.getValueAt(i, "IND_RECI");

                if (ind != null) {
                    conc.setRecibidas((ind.longValue() == 1)
                        ? new Boolean(true) : new Boolean(false));
                }

                ind = (BigDecimal) rs.getValueAt(i, "IND_CAPI");

                if (ind != null) {
                    conc.setCapitalizacion((ind.longValue() == 1)
                        ? new Boolean(true) : new Boolean(false));
                }

                ind = (BigDecimal) rs.getValueAt(i, "IND_ACTI_FINA");

                if (ind != null) {
                    conc.setActivasFinales((ind.longValue() == 1)
                        ? new Boolean(true) : new Boolean(false));
                }

                ind = (BigDecimal) rs.getValueAt(i, "IND_ADAD");

                if (ind != null) {
                    conc.setActividad((ind.longValue() == 1)
                        ? new Boolean(true) : new Boolean(false));
                }

                ind = (BigDecimal) rs.getValueAt(i, "IND_NUME_PEDI");

                if (ind != null) {
                    conc.setNumeroPedidos((ind.longValue() == 1)
                        ? new Boolean(true) : new Boolean(false));
                }

                ind = (BigDecimal) rs.getValueAt(i, "IND_PREC_PROM_UNIT");

                if (ind != null) {
                    conc.setPrecioPromedioUnitario((ind.longValue() == 1)
                        ? new Boolean(true) : new Boolean(false));
                }

                ind = (BigDecimal) rs.getValueAt(i, "IND_PROM_VENT_PEDI");

                if (ind != null) {
                    conc.setPromedioVentaPedido((ind.longValue() == 1)
                        ? new Boolean(true) : new Boolean(false));
                }

                ind = (BigDecimal) rs.getValueAt(i, "IND_PROM_UNID_PEDI");

                if (ind != null) {
                    conc.setPromedioUnidadesPedido((ind.longValue() == 1)
                        ? new Boolean(true) : new Boolean(false));
                }

                ind = (BigDecimal) rs.getValueAt(i, "IND_PROM_ORDE_PEDI");

                if (ind != null) {
                    conc.setPromedioOrdenesPedido((ind.longValue() == 1)
                        ? new Boolean(true) : new Boolean(false));
                }

                ind = (BigDecimal) rs.getValueAt(i, "IND_RETE");

                if (ind != null) {
                    conc.setRetencion((ind.longValue() == 1)
                        ? new Boolean(true) : new Boolean(false));
                }

                ind = (BigDecimal) rs.getValueAt(i, "IND_VENT_ESTA");

                if (ind != null) {
                    conc.setVentaEstadisticable((ind.longValue() == 1)
                        ? new Boolean(true) : new Boolean(false));
                }

                ind = (BigDecimal) rs.getValueAt(i, "VAL_ROTA");

                if (ind != null) {
                    conc.setRotacion((ind.longValue() == 1) ? new Boolean(true)
                        : new Boolean(false));
                }

                ind = (BigDecimal) rs.getValueAt(i, "TIDM_OID_TIPO_DETE_META");

                if (ind != null) {
                    conc.setOidTipoDeterminacionMeta(new Long(ind.longValue()));
                }

                ind = (BigDecimal) rs.getValueAt(i, "IND_PROD_EXIG");

                if (ind != null) {
                    conc.setIndProductosExigidos((ind.longValue() == 1)
                        ? new Boolean(true) : new Boolean(false));
                }

                DTOETramitarCierre dtoTram;

                dtoTram = new DTOETramitarCierre();

                dtoTram.setOidPais(new Long(
                        ((BigDecimal) rs.getValueAt(i, "PAIS_OID_PAIS"))
                            .longValue()));
                dtoTram.setOidMarca(new Long(
                        ((BigDecimal) rs.getValueAt(i, "MARC_OID_MARC"))
                            .longValue()));
                dtoTram.setOidCanal(new Long(
                        ((BigDecimal) rs.getValueAt(i, "CANA_OID_CANA"))
                            .longValue()));
                dtoTram.setOidPeriodo(new Long(
                        ((BigDecimal) rs.getValueAt(i, "PERD_OID_PERI_DESD"))
                            .longValue()));

                DAOClientePremiacion daoClientePremiacion = 
                    new DAOClientePremiacion();
                conc.setPeriodoDesde(daoClientePremiacion.obtenerPeriodo(
                        dtoTram));

                dtoTram = new DTOETramitarCierre();

                dtoTram.setOidPais(new Long(
                        ((BigDecimal) rs.getValueAt(i, "PAIS_OID_PAIS"))
                            .longValue()));
                dtoTram.setOidMarca(new Long(
                        ((BigDecimal) rs.getValueAt(i, "MARC_OID_MARC"))
                            .longValue()));
                dtoTram.setOidCanal(new Long(
                        ((BigDecimal) rs.getValueAt(i, "CANA_OID_CANA"))
                            .longValue()));
                dtoTram.setOidPeriodo(new Long(
                        ((BigDecimal) rs.getValueAt(i, "PERD_OID_PERI_HAST"))
                            .longValue()));

                conc.setPeriodoHasta(daoClientePremiacion.obtenerPeriodo(
                        dtoTram));

                hashConcursos.put(conc.getOidConcurso(), conc);
            }

            recuperarAmbitosGeograficos(hashConcursos, periodoCierre);
            recuperarAccesos(hashConcursos, periodoCierre);
            recuperarPeriodosDeControl(hashConcursos, periodoCierre);
        }

        UtilidadesLog.info("DAOCargaVariablesVenta.recuperarConcursosVariabl"
            +"esVenta(Periodo periodoCierre):Salida");

        return hashConcursos;
    }

    /**
    * @throws es.indra.mare.common.exception.MareException
    * @return
    * @param HashMap hashConcursos, Periodo periodoCierre
    * @version 1.00 09/06/2005
    * @author: Carlos Leal
    * Descripcion: recupera los ambitos geograficos para los concursos de 
    * variable de venta.
    */
    public void recuperarAmbitosGeograficos(HashMap hashConcursos,
        Periodo periodoCierre) throws MareException {
        UtilidadesLog.info("DAOCargaVariablesVenta.recuperarAmbitosGeograficos"
            +"(HashMap hashConcursos, Periodo periodoCierre):Entrada");

        RecordSet rs = new RecordSet();
        StringBuffer query = new StringBuffer();
        BelcorpService bs;
        AmbitoGeografico ambitoGeografico;
        ArrayList arrAmbitos;
        ConcursoVariablesVenta concuVarVenta;

        try {
            bs = BelcorpService.getInstance();
        } catch (MareMiiServiceNotFoundException ex) {
            UtilidadesLog.error("ERROR ", ex);
            throw new MareException(ex,
                UtilidadesError.armarCodigoError(
                    CodigosError.ERROR_AL_PEDIR_UN_SERVICIO_MARE));
        }

        query.append(" SELECT CPG.OID_PARA_GRAL, AMB.ZSGV_OID_SUBG_VENT, ");
        query.append(" AMB.ZORG_OID_REGI, AMB.ZZON_OID_ZONA, ");
        query.append(" AMB.ZSCC_OID_SECC, AMB.TERR_OID_TERR ");
        query.append(" FROM INC_AMBIT_GEOGR AMB, INC_CONCU_PARAM_GENER CPG, ");
        query.append(" INC_CONCU_PARAM_GEREN CPR, ");
        query.append(" cra_perio cp1, cra_perio cp2, cra_perio cp3 ");
        query.append(" WHERE AMB.COPA_OID_PARA_GRAL = CPG.OID_PARA_GRAL AND ");
        query.append(" CPG.OID_PARA_GRAL = CPR.COPA_OID_PARA_GRAL   AND ");
        query.append(" CPG.IND_ACTI = 1 AND ");

        query.append(" cp1.oid_peri = CPG.PERD_OID_PERI_DESD  AND ");
        query.append(" cp2.oid_peri = CPG.PERD_OID_PERI_HAST  AND ");
        query.append(" cp1.FEC_INIC <= cp3.FEC_INIC AND ");
        query.append(" cp2.FEC_FINA >= cp3.FEC_FINA AND ");
        query.append(" cp3.oid_peri = " + periodoCierre.getOidPeriodo());

        query.append(" AND CPG.DIRI_OID_DIRI = " + ConstantesINC.TIPO_GERENTE);
        query.append(" AND CPR.FCAL_OID_FORM_CALC = " +
            ConstantesINC.OID_FORMA_CALC_VARIABLES_VTA);
        query.append(" ORDER BY CPG.OID_PARA_GRAL ");

        try {
            rs = bs.dbService.executeStaticQuery(query.toString());
            UtilidadesLog.debug("****rs: " + rs);
        } catch (Exception ex) {
            UtilidadesLog.error("ERROR ", ex);
            throw new MareException(ex,
                UtilidadesError.armarCodigoError(
                    CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS));
        }

        int i= 0;
        while (i < rs.getRowCount()){
    
            Long oidParaGral = new Long(((BigDecimal) rs.getValueAt(i,
                        "OID_PARA_GRAL")).longValue());
            UtilidadesLog.debug("OID_PARA_GRAL: " + oidParaGral);

            concuVarVenta = (ConcursoVariablesVenta) 
                hashConcursos.get(oidParaGral);

            if (concuVarVenta != null) {
                arrAmbitos = new ArrayList();
                UtilidadesLog.debug("i: " + i);

                Long oidTmp = new Long(((BigDecimal) rs.getValueAt(i,
                            "OID_PARA_GRAL")).longValue());
                UtilidadesLog.debug("oidTmp: " + oidTmp);

                while ((i < rs.getRowCount()) &&
                        oidParaGral.equals(
                            new Long(((BigDecimal) 
                                rs.getValueAt(i, "OID_PARA_GRAL"))
                                    .longValue()))) {
                                    
                    ambitoGeografico = new AmbitoGeografico();

                    Long oidSubg = new Long(((BigDecimal) rs.getValueAt(i,
                                "ZSGV_OID_SUBG_VENT")).longValue());
                    ambitoGeografico.setOidSubgerencia(oidSubg);

                    BigDecimal oidRegion = ((BigDecimal) rs.getValueAt(i,
                            "ZORG_OID_REGI"));

                    if (oidRegion != null) {
                        ambitoGeografico.setOidRegion(new Long(
                                oidRegion.longValue()));
                    }

                    BigDecimal oidSeccion = ((BigDecimal) rs.getValueAt(i,
                            "ZSCC_OID_SECC"));

                    if (oidSeccion != null) {
                        ambitoGeografico.setOidSeccion(new Long(
                                oidSeccion.longValue()));
                    }

                    BigDecimal oidTerritorio = ((BigDecimal) rs.getValueAt(i,
                            "TERR_OID_TERR"));

                    if (oidTerritorio != null) {
                        ambitoGeografico.setOidTerritorio(new Long(
                                oidTerritorio.longValue()));
                    }

                    BigDecimal oidZona = ((BigDecimal) rs.getValueAt(i,
                            "ZZON_OID_ZONA"));

                    if (oidZona != null) {
                        ambitoGeografico.setOidZona(new Long(
                                oidZona.longValue()));
                    }

                    arrAmbitos.add(ambitoGeografico);
                    i++;
                }

                concuVarVenta.setAmbitosGerograficos(arrAmbitos);
                hashConcursos.put(oidParaGral, concuVarVenta);
            } else { //INC-88 jrivas 18/4/2006
                i++;
            }
        }

        UtilidadesLog.info("DAOCargaVariablesVenta.recuperarAmbitosGeograficos"
            +"(HashMap hashConcursos, Periodo periodoCierre):Salida");
    }

    /**
    * @throws es.indra.mare.common.exception.MareException
    * @return
    * @param HashMap hashConcursos, Periodo periodoCierre
    * @version 1.00 09/06/2005
    * @author: Carlos Leal
    * Descripcion: recuperar los accesos para los concursos del hash pasado
    * por parametro.
    */
    public void recuperarAccesos(HashMap hashConcursos, Periodo periodoCierre)
        throws MareException {
        UtilidadesLog.info("DAOCargaVariablesVenta.recuperarAccesos(HashMap"
            +"hashConcursos, Periodo periodoCierre):Entrada");

        RecordSet rs = new RecordSet();
        StringBuffer query = new StringBuffer();
        BelcorpService bs;
        Long[] arr;
        ConcursoVariablesVenta concuVarVenta;

        try {
            bs = BelcorpService.getInstance();
        } catch (MareMiiServiceNotFoundException ex) {
            UtilidadesLog.error("ERROR ", ex);
            throw new MareException(ex,
                UtilidadesError.armarCodigoError(
                    CodigosError.ERROR_AL_PEDIR_UN_SERVICIO_MARE));
        }

        query.append(" SELECT CPG.OID_PARA_GRAL , ACC.ACCE_OID_ACCE ");
        query.append(" FROM INC_ACCES_CONCU ACC, ");
        query.append(" INC_CONCU_PARAM_GENER CPG, INC_CONCU_PARAM_GEREN CPR, ");
        query.append(" cra_perio cp1, cra_perio cp2, cra_perio cp3 ");
        query.append(" WHERE ACC.COPA_OID_PARA_GRAL = CPG.OID_PARA_GRAL ");
        query.append(" AND CPG.OID_PARA_GRAL = CPR.COPA_OID_PARA_GRAL ");
        query.append(" AND CPG.IND_ACTI = 1 AND ");

        query.append(" cp1.oid_peri = CPG.PERD_OID_PERI_DESD  AND ");
        query.append(" cp2.oid_peri = CPG.PERD_OID_PERI_HAST  AND ");
        query.append(" cp1.FEC_INIC <= cp3.FEC_INIC AND ");
        query.append(" cp2.FEC_FINA >= cp3.FEC_FINA AND ");
        query.append(" cp3.oid_peri = " + periodoCierre.getOidPeriodo());

        query.append(" AND CPG.DIRI_OID_DIRI = " + ConstantesINC.TIPO_GERENTE);
        query.append(" AND CPR.FCAL_OID_FORM_CALC = " +
            ConstantesINC.OID_FORMA_CALC_VARIABLES_VTA);
        query.append(" ORDER BY CPG.OID_PARA_GRAL");

        try {
            rs = bs.dbService.executeStaticQuery(query.toString());
            UtilidadesLog.debug("****rs: " + rs);
        } catch (Exception ex) {
            UtilidadesLog.error("ERROR ", ex);
            throw new MareException(ex,
                UtilidadesError.armarCodigoError(
                    CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS));
        }

        for (int i = 0; i < rs.getRowCount(); i++) {
            Long oidParaGral = new Long(((BigDecimal) rs.getValueAt(i,
                        "OID_PARA_GRAL")).longValue());

            concuVarVenta = (ConcursoVariablesVenta) 
                hashConcursos.get(oidParaGral);

            if (concuVarVenta != null) {
                arr = new Long[rs.getRowCount()];

                while ((i < rs.getRowCount()) &&
                        oidParaGral.equals(
                            new Long(((BigDecimal) 
                                rs.getValueAt(i, "OID_PARA_GRAL"))
                                    .longValue()))) {
                    arr[i] = new Long(((BigDecimal) rs.getValueAt(i,
                                "ACCE_OID_ACCE")).longValue());
                    i++;
                }

                concuVarVenta.setOidAccesos(arr);
                hashConcursos.put(oidParaGral, concuVarVenta);
            }
        }

        UtilidadesLog.info("DAOCargaVariablesVenta.recuperarAccesos(HashMap "
            +"hashConcursos, Periodo periodoCierre):Salida");
    }

    /**
    * @throws es.indra.mare.common.exception.MareException
    * @return
    * @param HashMap hashConcursos, Periodo periodoCierre
    * @version 1.00 09/06/2005
    * @author: Carlos Leal
    * Descripcion: recupera los periodos de control para los concursos 
    * recibidos por parametro.
    */
    public void recuperarPeriodosDeControl(HashMap hashConcursos,
        Periodo periodoCierre) throws MareException {
        UtilidadesLog.info("DAOCargaVariablesVenta.recuperarPeriodosDeControl"
            +"(HashMap hashConcursos, Periodo periodoCierre):Entrada");

        RecordSet rs = new RecordSet();
        StringBuffer query = new StringBuffer();
        BelcorpService bs;
        ConcursoVariablesVenta concuVarVenta;
        ArrayList arrPeriodos;
        Periodo periodo;

        try {
            bs = BelcorpService.getInstance();
        } catch (MareMiiServiceNotFoundException ex) {
            UtilidadesLog.error("ERROR ", ex);
            throw new MareException(ex,
                UtilidadesError.armarCodigoError(
                    CodigosError.ERROR_AL_PEDIR_UN_SERVICIO_MARE));
        }

        query.append("SELECT CPG.OID_PARA_GRAL,PAM.PERD_OID_PERI, ");
        query.append(" PER.FEC_INIC, PER.FEC_FINA, ");
        query.append(" CRP.COD_PERI, PER.PAIS_OID_PAIS, PER.MARC_OID_MARC,");
        query.append(" PER.CANA_OID_CANA ");
        query.append(" FROM INC_CONCU_PARAM_GENER CPG, ");
        query.append(" INC_CONCU_PARAM_GEREN CPR, ");
        query.append("INC_PARAM_GENER_PREMI PRE, INC_PARAM_NIVEL_PREMI PNI, ");
        query.append("INC_PREMI_MONET PMO, INC_PAGO_MONET PAM, ");
        query.append("CRA_PERIO PER, SEG_PERIO_CORPO CRP, ");
        query.append(" cra_perio cp1, cra_perio cp2, cra_perio cp3 ");
        query.append("WHERE CPG.OID_PARA_GRAL = CPR.COPA_OID_PARA_GRAL ");
        query.append("AND CPG.IND_ACTI = 1 AND ");

        query.append(" cp1.oid_peri = CPG.PERD_OID_PERI_DESD  AND ");
        query.append(" cp2.oid_peri = CPG.PERD_OID_PERI_HAST  AND ");
        query.append(" cp1.FEC_INIC <= cp3.FEC_INIC AND ");
        query.append(" cp2.FEC_FINA >= cp3.FEC_FINA AND ");
        query.append(" cp3.oid_peri = " + periodoCierre.getOidPeriodo());

        /*query.append(" AND ( SELECT cp3.oid_peri ");
        query.append(" FROM  cra_perio cp1, cra_perio cp2, cra_perio cp3 ");
        query.append(" WHERE cp1.oid_peri = CPG.PERD_OID_PERI_DESD  AND ");
        query.append(" cp2.oid_peri = CPG.PERD_OID_PERI_HAST  AND ");
        query.append(" cp1.FEC_INIC <= cp3.FEC_INIC AND ");
        query.append(" cp2.FEC_FINA > cp3.FEC_FINA AND ");
        query.append(" cp3.oid_peri = " + periodoCierre.getOidPeriodo());
        query.append(" ) = " + periodoCierre.getOidPeriodo());*/
        query.append(" AND CPG.DIRI_OID_DIRI = " + ConstantesINC.TIPO_GERENTE);
        query.append(" AND CPR.FCAL_OID_FORM_CALC = " +
            ConstantesINC.OID_FORMA_CALC_VARIABLES_VTA);
        query.append(" AND CPG.OID_PARA_GRAL = PRE.COPA_OID_PARA_GRAL ");
        query.append(
            " AND PRE.OID_PARA_GENE_PREM = PNI.PAGP_OID_PARA_GENE_PREM  ");
        query.append(
            " AND PNI.OID_PARA_NIVE_PREM = PMO.PANP_OID_PARA_NIVE_PREM  ");
        query.append(" AND PMO.OID_PREM_MONE = PAM.PRMO_OID_PREM_MONE  ");
        query.append(" AND PAM.PERD_OID_PERI = PER.OID_PERI  ");
        query.append(" AND PER.PERI_OID_PERI = CRP.OID_PERI  ");
        query.append(" ORDER BY CPG.OID_PARA_GRAL, PER.FEC_INIC ");

        try {
            rs = bs.dbService.executeStaticQuery(query.toString());
            UtilidadesLog.debug("****rs: " + rs);
        } catch (Exception ex) {
            UtilidadesLog.error("ERROR ", ex);
            throw new MareException(ex,
                UtilidadesError.armarCodigoError(
                    CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS));
        }

        if (rs.esVacio()) {
            arrPeriodos = new ArrayList();

            Set keys = hashConcursos.keySet();
            Iterator iter = keys.iterator();
            Long concurso = null;

            while (iter.hasNext()) {
                concurso = (Long) iter.next();
                concuVarVenta = (ConcursoVariablesVenta) 
                    hashConcursos.get(concurso);
                concuVarVenta.setPeriodosControl(arrPeriodos);
                hashConcursos.put(concurso, concuVarVenta);
            }
        } else {
            for (int i = 0; i < rs.getRowCount(); i++) {
                Long oidParaGral = new Long(((BigDecimal) rs.getValueAt(i,
                            "OID_PARA_GRAL")).longValue());

                concuVarVenta = (ConcursoVariablesVenta) 
                    hashConcursos.get(oidParaGral);
                    
                UtilidadesLog.debug("concuVarVenta: " + concuVarVenta);                    

                if (concuVarVenta != null) {
                    arrPeriodos = new ArrayList();

                    while ((i < rs.getRowCount()) &&
                            oidParaGral.equals(
                                new Long(
                                    ((BigDecimal) rs.getValueAt(i,
                                        "OID_PARA_GRAL")).longValue()))) {
                        periodo = new Periodo();

                        //PAM.PERD_OID_PERI,
                        periodo.setOidPeriodo(new Long(((BigDecimal)
                            rs.getValueAt(i, "PERD_OID_PERI")).longValue()));

                        //PER.FEC_INIC, 
                        periodo.setFechaDesde((Date) 
                            rs.getValueAt(i, "FEC_INIC"));

                        //PER.FEC_FINA, 
                        periodo.setFechaHasta((Date)
                            rs.getValueAt(i, "FEC_FINA"));

                        //CRP.COD_PERI, 
                        periodo.setCodperiodo((String)
                            rs.getValueAt(i, "COD_PERI"));

                        //PER.PAIS_OID_PAIS, 
                        periodo.setOidPais(new Long(((BigDecimal) 
                            rs.getValueAt(i, "PERD_OID_PERI")).longValue()));

                        //PER.MARC_OID_MARC, 
                        periodo.setOidMarca(new Long(((BigDecimal) 
                            rs.getValueAt(i, "MARC_OID_MARC")).longValue()));

                        //PER.CANA_OID_CANA
                        periodo.setOidCanal(new Long(((BigDecimal) 
                            rs.getValueAt(i, "CANA_OID_CANA")).longValue()));
                            
                        arrPeriodos.add(periodo);
                        i++;
                    }

                    concuVarVenta.setPeriodosControl(arrPeriodos);
                    hashConcursos.put(oidParaGral, concuVarVenta);
                }
            }
        }

        UtilidadesLog.info("DAOCargaVariablesVenta.recuperarPeriodosDeControl"
            +"(HashMap hashConcursos, Periodo periodoCierre):Salida");
    }

    /**
    * @throws es.indra.mare.common.exception.MareException
    * @return Periodo
    * @param Periodo periodo
    * @version 1.00 13/06/2005
    * @author: Carlos Leal
    * Descripción: Recupera el último periodo del ejercio anterior al periodo 
    * pasado como parametro
    */
    public Periodo obtenerUltimoPeriodoEjercicioAnterior(Periodo periodo)
        throws MareException {
        UtilidadesLog.info("DAOCargaVariablesVenta.obtenerUltimoPeriodoEjerci"
            +"cioAnterior(Periodo periodo):Entrada");

        Periodo periodoResultado = new Periodo();
        String fechaString = periodo.getFechaDesde().toString();
        String anio = fechaString.substring(0, 4);
        int anioAnterior = Long.valueOf(anio).intValue() - 1;
        RecordSet rs = new RecordSet();
        BelcorpService bs;
        StringBuffer query = new StringBuffer();

        try {
            bs = BelcorpService.getInstance();
        } catch (MareMiiServiceNotFoundException ex) {
            UtilidadesLog.error("ERROR ", ex);
            throw new MareException(ex,
                UtilidadesError.armarCodigoError(
                    CodigosError.ERROR_AL_PEDIR_UN_SERVICIO_MARE));
        }

        query.append("select * ");
        query.append("from cra_perio cp, seg_perio_corpo pc ");
        query.append("where cp.peri_oid_peri = pc.oid_peri ");
        query.append("and pc.VAL_ANIO = " + anioAnterior);
        query.append("and cp.PAIS_OID_PAIS = " + periodo.getOidPais());
        query.append("and cp.MARC_OID_MARC = " + periodo.getOidMarca());
        query.append("and cp.CANA_OID_CANA = " + periodo.getOidCanal());
        query.append("order by cp.fec_inic desc ");

        try {
            rs = bs.dbService.executeStaticQuery(query.toString());
            UtilidadesLog.debug("****rs: " + rs);
        } catch (Exception ex) {
            UtilidadesLog.error("ERROR ", ex);
            throw new MareException(ex,
                UtilidadesError.armarCodigoError(
                    CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS));
        }

        periodoResultado.setCodperiodo((String) rs.getValueAt(0, "COD_PERI"));
        periodoResultado.setFechaDesde((Date) rs.getValueAt(0, "FEC_INIC"));
        periodoResultado.setFechaHasta((Date) rs.getValueAt(0, "FEC_FINA"));
        periodoResultado.setOidCanal(new Long(
                ((BigDecimal) rs.getValueAt(0, "CANA_OID_CANA")).longValue()));
        periodoResultado.setOidMarca(new Long(
                ((BigDecimal) rs.getValueAt(0, "MARC_OID_MARC")).longValue()));
        periodoResultado.setOidPais(new Long(
                ((BigDecimal) rs.getValueAt(0, "PAIS_OID_PAIS")).longValue()));
        periodoResultado.setOidPeriodo(new Long(
                ((BigDecimal) rs.getValueAt(0, "OID_PERI")).longValue()));

        UtilidadesLog.info("DAOCargaVariablesVenta.obtenerUltimoPeriodoEjerci"
            +"cioAnterior(Periodo periodo):Salida");

        return periodoResultado;
    }

    /**
    * @throws es.indra.mare.common.exception.MareException
    * @return
    * @version 1.00 14/06/2005
    * @author: Carlos Leal
    * Descripcion: guarda un registro por el gerente considerado candidato 
    * ganador.
    */
    public void guardarCandidatoGanador(InfoGerentesConcursos infoGerConc,
        DTOResultadoConcursoVariablesVenta dtoRes,
        GerenteVariablesVenta gerVarVta) throws MareException {
        UtilidadesLog.info("DAOCargaVariablesVenta.guardarCandidatoGanador"
            +"(InfoGerentesConcursos infoGerConc, DTOResultadoConcursoVariabl"
            +"esVenta dtoRes, GerenteVariablesVenta gerVarVta):Entrada");

        /*
         * 1.- Invocar al método findByUK de la entidad INC:CandidataGanadora 
         * (candGan) pasandole por parametro infoGerConc.getConcurso
         * (dtoRes.oidConcurso).oidConcurso, gerVarVta.oidGerente y 
         * infoGerConc.periodoCierre.oidPeriodo.
           1.1.- Si encuentra un registro terminar el método.
           1.2.- Si no encuentra ningun registro continuar con el siguiente
           punto.
           2.- Hacer un create de la entidad INC:CandidataGanadora (candGan) 
           completando sus atributos como se detalla a continuacion:
           candGan.concurso 
                    = infoGerConc.getConcurso(dtoRes.oidConcurso).oidConcurso
           candGan.ganadora = gerVarVta.oidGerente
           * candGan.periodo = infoGerConc.periodoCierre.oidPeriodo
           * candGan.metasSuperadas = true
           * candGan.requisitosPremiacionSuperados = false
         */
        
        UtilidadesLog.debug("COPA_OID_PARA_GRAL:  " + infoGerConc.getConcurso(dtoRes.getOidConcurso()).getOidConcurso());
        UtilidadesLog.debug("CLIE_OID_CLIE:  " + gerVarVta.getOidGerente());
        UtilidadesLog.debug("infoGerConc.getPeriodoCierre().getOidPeriodo():  " + infoGerConc.getPeriodoCierre().getOidPeriodo()); 
        try {
            CandidataGanadoraLocalHome candidataGanadoraLocalHome = this.getCandidataGanadoraLocalHome();
            CandidataGanadoraLocal candidataGanadoraLocal = null;

            candidataGanadoraLocal = candidataGanadoraLocalHome.findByUK(infoGerConc.getConcurso(
                    dtoRes.getOidConcurso()).getOidConcurso(),
                    gerVarVta.getOidGerente(),
                    infoGerConc.getPeriodoCierre().getOidPeriodo());
                    
            UtilidadesLog.debug("encontro candidataGanadora");
                    
        } catch (NoResultException fex) {
            UtilidadesLog.debug(fex);
            UtilidadesLog.debug("No encontro candidataGanadora, la crea");
            
            UtilidadesLog.debug("VAL_REQU_PREM_SUPE:  " + new Boolean(false));
            UtilidadesLog.debug("COPA_OID_PARA_GRAL:  " + infoGerConc.getConcurso(dtoRes.getOidConcurso()).getOidConcurso());
            UtilidadesLog.debug("CLIE_OID_CLIE:  " + gerVarVta.getOidGerente());
            UtilidadesLog.debug("infoGerConc.getPeriodoCierre().getOidPeriodo():  " + infoGerConc.getPeriodoCierre().getOidPeriodo()); 

            try {
                CandidataGanadoraLocalHome candidataGanadoraLocalHome =  this.getCandidataGanadoraLocalHome();
                candidataGanadoraLocalHome.create(new Boolean(true),
                                                    new Boolean(false),
                                                    infoGerConc.getPeriodoCierre().getOidPeriodo(),
                                                    infoGerConc.getConcurso(dtoRes.getOidConcurso())
                                                               .getOidConcurso(), gerVarVta.getOidGerente());
            } catch (PersistenceException cex) {
                UtilidadesLog.error("ERROR ", cex);
                throw new MareException(cex,
                    UtilidadesError.armarCodigoError(
                        CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS));
            }
        } catch (PersistenceException ce) {
            UtilidadesLog.error("ERROR ", ce);
            throw new MareException(ce, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS));
        }

        UtilidadesLog.info("DAOCargaVariablesVenta.guardarCandidatoGanador("
            +"InfoGerentesConcursos infoGerConc, DTOResultadoConcursoVariables"
            +"Venta dtoRes, GerenteVariablesVenta gerVarVta):Salida");
    }

    /**
    * @throws es.indra.mare.common.exception.MareException
    * @return
    * @version 1.00 14/06/2005
    * @author: Carlos Leal
    * Descripcion: guarda el calculo de resultados para un gerente.
    * Modificado: Cristian Valenzuela - 25/8/2005
    */
    public void guardarResultadosGerente(InfoGerentesConcursos infoGerConc,
        DTOResultadoConcursoVariablesVenta dtoRes,
        GerenteVariablesVenta gerVarVta) throws MareException {
        UtilidadesLog.info("DAOCargaVariablesVenta.guardarResultadosGerente("
            +"InfoGerentesConcursos infoGerConc, "
            +" DTOResultadoConcursoVariablesVenta dtoRes,"
            +" GerenteVariablesVenta gerVarVta):Entrada");

        ConcursoVariablesVenta concurso;

        concurso = infoGerConc.getConcurso(dtoRes.getOidConcurso());

        //SUBGERENCIA
        if (gerVarVta.getUnidadesGerenciadas().getSubGerencias() != null) {
            UtilidadesLog.debug("******** Entro por SUBGERENCIA");

            MetasVentaProyectadaSubgerenciaVentaLocalHome 
                mtasVtaPdaSciaVtaLcalHome = this.getMetasVentaProyectadaSubgerenciaVentaLocalHome();
                        
            MetasVentaProyectadaSubgerenciaVentaLocal mtasVtaPdaSubLocal = null;

            try {
                mtasVtaPdaSubLocal =
                    mtasVtaPdaSciaVtaLcalHome.findByUk(infoGerConc
                        .getPeriodoCierre().getOidPeriodo(),
                        gerVarVta.getOidGerente(), concurso.getOidConcurso(),
                        (Long) gerVarVta.getUnidadesGerenciadas()
                        .getUnidadesGerenciadas().get(0));

                ResultadosVentaProyectadaSubgeLocalHome 
                    resVtaPdaSubgLocalHome = this.getResultadosVentaProyectadaSubgeLocalHome();
                        
                ResultadosVentaProyectadaSubgeLocal resVtaPdaSubgLocal = null;

                resVtaPdaSubgLocal = resVtaPdaSubgLocalHome.create(
                        gerVarVta.getResultadosVariables().getActivasIniciales(),
                        gerVarVta.getResultadosVariables().getActivasFinales(),
                        gerVarVta.getResultadosVariables().getIngresos(),
                        gerVarVta.getResultadosVariables().getReingresos(),
                        gerVarVta.getResultadosVariables().getEgresos(),
                        gerVarVta.getResultadosVariables().getNumeroOrdenes(),
                        dtoRes.getNumeroPedidos(),
                        dtoRes.getTotalVentaNetaEstadisticable(),
                        mtasVtaPdaSubLocal.getOid(),
                        mtasVtaPdaSubLocal.getPeriodoCalculado());
                resVtaPdaSubgLocal.setActividad(new BigDecimal(
                        dtoRes.getPorcentajeActividad().doubleValue()));

                resVtaPdaSubgLocal.setCapitalizacion(new BigDecimal(
                        gerVarVta.getResultadosVariables().getCapitalizacion()
                                 .toString()));
                resVtaPdaSubgLocal.setNumeroClientes(gerVarVta
                    .getResultadosVariables().getNumeroClientes());
                resVtaPdaSubgLocal.setPrecioPromedioUnitario(dtoRes
                    .getPrecioPromedioUnitario());
                resVtaPdaSubgLocal.setPromedioOrdenesPedido(new BigDecimal(
                        dtoRes.getPromedioOrdenesPedidos().doubleValue()));
                resVtaPdaSubgLocal.setPromedioUnidadesPedido(new BigDecimal(
                        dtoRes.getPromedioUnidadesPedidos().doubleValue()));
                resVtaPdaSubgLocal.setPromedioVentaPedido(dtoRes
                    .getPromedioVentaPedidos());
                resVtaPdaSubgLocal.setRetencion(new BigDecimal(gerVarVta.getResultadosVariables().getPorcentajeRetencion().toString()));
                resVtaPdaSubgLocal.setUnidadesVendidas(new Integer(dtoRes.getTotalUnidadesVendidas().intValue()));

                resVtaPdaSubgLocal.setRotacion(gerVarVta
                    .getResultadosVariables().getRotacion());
                resVtaPdaSubgLocal.setEntregadas(gerVarVta
                    .getResultadosVariables().getEntregadas());
                    
                resVtaPdaSubgLocal.setRecibidas(gerVarVta
                    .getResultadosVariables().getRecibidas());
                resVtaPdaSubgLocalHome.merge(resVtaPdaSubgLocal);
            } catch (NoResultException fex) {
                
            } catch (PersistenceException cex) {
                UtilidadesLog.error("ERROR ", cex);
                throw new MareException(cex,
                    UtilidadesError.armarCodigoError(
                        CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS));
            }
        }

        //REGIONES
        if (gerVarVta.getUnidadesGerenciadas().getRegiones() != null) {
            UtilidadesLog.debug("******** Entro por REGIONES");

            MetasVentaProyectadaRegionLocalHome mtasVtaPdaRegLocalHome =  this.getMetasVentaProyectadaRegionLocalHome();
            MetasVentaProyectadaRegionLocal mtasVtaPdaRegLocal = null;

            try {
                mtasVtaPdaRegLocal = mtasVtaPdaRegLocalHome.findByUk(
                    infoGerConc.getPeriodoCierre().getOidPeriodo(),
                        gerVarVta.getOidGerente(), concurso.getOidConcurso(),
                        (Long) gerVarVta.getUnidadesGerenciadas()
                        .getUnidadesGerenciadas().get(0));

                ResultadosVentaProyectadaRegioLocalHome 
                    resVtaPdaRegioLocalHome = this.getResultadosVentaProyectadaRegioLocalHome();
                ResultadosVentaProyectadaRegioLocal resVtaPdaRegioLocal = null;

                resVtaPdaRegioLocal = resVtaPdaRegioLocalHome.create(
                        gerVarVta.getResultadosVariables()
                        .getActivasIniciales(),
                        gerVarVta.getResultadosVariables().getActivasFinales(),
                        gerVarVta.getResultadosVariables().getIngresos(),
                        gerVarVta.getResultadosVariables().getReingresos(),
                        gerVarVta.getResultadosVariables().getEgresos(),
                        gerVarVta.getResultadosVariables().getNumeroOrdenes(),
                        dtoRes.getNumeroPedidos(),
                        new Integer(dtoRes.getTotalUnidadesVendidas()
                            .intValue()),
                        gerVarVta.getResultadosVariables().getNumeroClientes(),
                        dtoRes.getTotalVentaNetaEstadisticable(),
                        mtasVtaPdaRegLocal.getOid(),
                        mtasVtaPdaRegLocal.getPeriodoCalculado());

                resVtaPdaRegioLocal.setActividad(new Integer(
                        dtoRes.getPorcentajeActividad().intValue()));
                resVtaPdaRegioLocal.setCapitalizacion(new Integer(
                        gerVarVta.getResultadosVariables().getCapitalizacion()
                                 .toString()));
                resVtaPdaRegioLocal.setPrecioPromedioUnitario(dtoRes
                    .getPrecioPromedioUnitario());
                resVtaPdaRegioLocal.setPromedioOrdenesPedido(new BigDecimal(
                        dtoRes.getPromedioOrdenesPedidos().doubleValue()));
                resVtaPdaRegioLocal.setPromedioUnidadesPedido(new BigDecimal(
                        dtoRes.getPromedioUnidadesPedidos().doubleValue()));
                resVtaPdaRegioLocal.setPromedioVentaPedido(dtoRes
                    .getPromedioVentaPedidos());
                resVtaPdaRegioLocal.setRetencion(new BigDecimal(gerVarVta.getResultadosVariables().getPorcentajeRetencion().toString()));
                resVtaPdaRegioLocal.setRotacion(gerVarVta
                    .getResultadosVariables().getRotacion());
                resVtaPdaRegioLocal.setEntregadas(gerVarVta
                    .getResultadosVariables().getEntregadas());
                resVtaPdaRegioLocal.setRecibidas(gerVarVta
                    .getResultadosVariables().getRecibidas());
                resVtaPdaRegioLocalHome.merge(resVtaPdaRegioLocal);
            } catch (NoResultException fex) {
                
            } catch (PersistenceException cex) {
                UtilidadesLog.error("ERROR ", cex);
                throw new MareException(cex,
                    UtilidadesError.armarCodigoError(
                        CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS));
            }
        }

        //ZONAS
        if (gerVarVta.getUnidadesGerenciadas().getZonas() != null) {
            UtilidadesLog.debug("******** Entro por ZONAS");

            MetasVentaProyectadaZonaLocalHome mtasVtaPdaLocalHome = this.getMetasVentaProyectadaZonaLocalHome();
            MetasVentaProyectadaZonaLocal mtasVtaPdaZonLocal = null;

            try {
                UtilidadesLog.debug("infoGerConc.getPeriodoCierre().getOidPeriodo(): " + infoGerConc.getPeriodoCierre().getOidPeriodo());
                UtilidadesLog.debug("gerVarVta.getOidGerente(): " + gerVarVta.getOidGerente());
                UtilidadesLog.debug("concurso.getOidConcurso(): " + concurso.getOidConcurso());
                UtilidadesLog.debug("(Long) gerVarVta.getUnidadesGerenciadas().getUnidadesGerenciadas().get(0): " + (Long) gerVarVta.getUnidadesGerenciadas()
                        .getUnidadesGerenciadas().get(0));
                
                
                mtasVtaPdaZonLocal = mtasVtaPdaLocalHome.findByUk(
                    infoGerConc.getPeriodoCierre().getOidPeriodo(),
                        gerVarVta.getOidGerente(), concurso.getOidConcurso(),
                        (Long) gerVarVta.getUnidadesGerenciadas()
                        .getUnidadesGerenciadas().get(0));

                ResultadosVentaProyectadaZonaLocalHome resVtaPdaZonaLocalHome = this.getResultadosVentaProyectadaZonaLocalHome();
                ResultadosVentaProyectadaZonaLocal resVtaPdaZonaLocal = null;

                /*
                 *(Long anioComercial,  //INC 19292 Puse new Long(1) para que 
                 * compile, habria que cambiarlo!!!
                 * Integer activasIniciales,
                 * Integer activasFinales,
                 * Integer ingresos,
                 * Integer reingresos,
                 * Integer egresos,
                 * Integer numeroOrdenes,
                 * Integer numeroPedidos,
                 * Integer unidadesVendidas,
                 * Integer numeroClientes,
                 * BigDecimal ventaNetaEstadisticable,
                 * Long meta,
                 * Long periodoCalculado)
                 */
                resVtaPdaZonaLocal = resVtaPdaZonaLocalHome.create(
                    gerVarVta.getResultadosVariables().getActivasIniciales(),
                        gerVarVta.getResultadosVariables().getActivasFinales(),
                        gerVarVta.getResultadosVariables().getIngresos(),
                        gerVarVta.getResultadosVariables().getReingresos(),
                        gerVarVta.getResultadosVariables().getEgresos(),
                        gerVarVta.getResultadosVariables().getNumeroOrdenes(),
                        dtoRes.getNumeroPedidos(),
                        new Integer(dtoRes.getTotalUnidadesVendidas()
                            .intValue()),
                        gerVarVta.getResultadosVariables().getNumeroClientes(),
                        dtoRes.getTotalVentaNetaEstadisticable(),
                        mtasVtaPdaZonLocal.getOid(),
                        mtasVtaPdaZonLocal.getPeriodoCalculado());

                resVtaPdaZonaLocal.setActividad(new BigDecimal(
                        dtoRes.getPorcentajeActividad().doubleValue()));
                resVtaPdaZonaLocal.setCapitalizacion(new BigDecimal(
                        gerVarVta.getResultadosVariables().getCapitalizacion()
                                 .toString()));
                resVtaPdaZonaLocal.setPrecioPromedioUnitario(dtoRes
                    .getPrecioPromedioUnitario());
                resVtaPdaZonaLocal.setPromedioOrdenesPedido(new BigDecimal(
                        dtoRes.getPromedioOrdenesPedidos().doubleValue()));
                resVtaPdaZonaLocal.setPromedioUnidadesPedido(new BigDecimal(
                        dtoRes.getPromedioUnidadesPedidos().doubleValue()));
                resVtaPdaZonaLocal.setPromedioVentaPedidos(dtoRes
                    .getPromedioVentaPedidos());
                resVtaPdaZonaLocal.setRetencion(new BigDecimal(gerVarVta.getResultadosVariables().getPorcentajeRetencion().toString()));

                resVtaPdaZonaLocal.setRotacion(gerVarVta
                    .getResultadosVariables().getRotacion());
                resVtaPdaZonaLocal.setEntregadas(gerVarVta
                    .getResultadosVariables().getEntregadas());
                resVtaPdaZonaLocal.setRecibidas(gerVarVta
                    .getResultadosVariables().getRecibidas());
                resVtaPdaZonaLocalHome.merge(resVtaPdaZonaLocal);
            } catch (NoResultException fex) {
                
            } catch (PersistenceException cex) {
                UtilidadesLog.error("ERROR ", cex);
                throw new MareException(cex,
                    UtilidadesError.armarCodigoError(
                        CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS));
            }
        }
        
        // Gerente procesado
        gerVarVta.setProcesado(true);

        UtilidadesLog.info("DAOCargaVariablesVenta.guardarResultadosGerente("
            +"InfoGerentesConcursos infoGerConc, "
            +"DTOResultadoConcursoVariablesVenta dtoRes, GerenteVariablesVenta"
            +"gerVarVta):Salida");
    }
    
    private CandidataGanadoraLocalHome getCandidataGanadoraLocalHome() {
            return new CandidataGanadoraLocalHome();
    }
    
    private MetasVentaProyectadaRegionLocalHome getMetasVentaProyectadaRegionLocalHome() {
            return new MetasVentaProyectadaRegionLocalHome();
    }
    
    private MetasVentaProyectadaZonaLocalHome getMetasVentaProyectadaZonaLocalHome() {
            return new MetasVentaProyectadaZonaLocalHome();
    }
    
    private MetasVentaProyectadaSubgerenciaVentaLocalHome getMetasVentaProyectadaSubgerenciaVentaLocalHome() {
            return new MetasVentaProyectadaSubgerenciaVentaLocalHome();
    }

    private ResultadosVentaProyectadaSubgeLocalHome getResultadosVentaProyectadaSubgeLocalHome() {
            return new ResultadosVentaProyectadaSubgeLocalHome();
    }

    private ResultadosVentaProyectadaRegioLocalHome getResultadosVentaProyectadaRegioLocalHome() {
            return new ResultadosVentaProyectadaRegioLocalHome();
    }

    private ResultadosVentaProyectadaZonaLocalHome getResultadosVentaProyectadaZonaLocalHome() {
            return new ResultadosVentaProyectadaZonaLocalHome();
    }

    
}
    
