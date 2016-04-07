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
 * @author: DMorello
 * 
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
import es.indra.sicc.dtos.inc.DTOMontoUnidades;
import es.indra.sicc.entidades.inc.ClienteFaltaConstanciaActividadLocalHome;
import es.indra.sicc.entidades.inc.ResultadosRankingLocal;
import es.indra.sicc.entidades.inc.ResultadosRankingLocalHome;
import es.indra.sicc.logicanegocio.mae.ConstantesMAE;
import es.indra.sicc.util.BelcorpService;
import es.indra.sicc.util.CodigosError;
import es.indra.sicc.util.DTOOIDs;
import es.indra.sicc.util.UtilidadesError;
import es.indra.sicc.util.UtilidadesLog;
import es.indra.sicc.logicanegocio.ped.ConstantesPED;

import java.math.BigDecimal;

import java.text.SimpleDateFormat;

import java.util.ArrayList;

import javax.persistence.NoResultException;
import javax.persistence.PersistenceException;


public class DAOBaseCalculo {
    private UtilidadesLog log = new UtilidadesLog();
    
    public DAOBaseCalculo() {
    }

    /**
     * Este metodo obtiene los oids de la entidad ResultadoRanking filtrando 
     * los registros por concurso y periodo pasado por parametro
     *
     * Sistema: Belcorp
     * Módulo:  INC
     * Fecha:   27/06/2005
     * @version 1.00
     * @autor   Diego Morello
     */
    public DTOOIDs obtenerResultadosRanking(Long oidConcurso,
        Long oidPeriodoCalculo) throws MareException {
        UtilidadesLog.info("DAOBaseCalculo.obtenerResultadosRanking(Long "
            +"oidConcurso, Long oidPeriodoCalculo):Entrada");

        DTOOIDs dtoOids = new DTOOIDs();
        RecordSet rs = new RecordSet();
        StringBuffer query = new StringBuffer();
        BelcorpService bs = null;

        try {
            bs = BelcorpService.getInstance();
        } catch (MareMiiServiceNotFoundException e) {
            UtilidadesLog.error("ERROR ", e);

            int error = UtilidadesError.armarCodigoError(
                CodigosError.ERROR_AL_PEDIR_UN_SERVICIO_MARE);
            throw new MareException(e, error);
        }

        // Armo la consulta
        query.append("SELECT irr.OID_RESU_RANK ");
        query.append("FROM INC_RESUL_RANKI irr ");
        query.append("WHERE irr.COPA_OID_PARA_GRAL = " + oidConcurso);
        query.append("      AND irr.PERD_OID_PERI = " + oidPeriodoCalculo);

        // Ejecuto la consulta
        try {
            rs = bs.dbService.executeStaticQuery(query.toString());
            UtilidadesLog.debug("resultado query: " + rs);
        } catch (Exception e) {
            UtilidadesLog.error("ERROR ", e);

            int error = UtilidadesError.armarCodigoError(
                CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS);
            throw new MareException(e, error);
        }

        // Coloco en el DTO los OIDs que devolvió la consulta
        int rows = rs.getRowCount();
        Long[] oids = new Long[rows];

        for (int i = 0; i < rows; i++) {
            BigDecimal bd = (BigDecimal) rs.getValueAt(i, "OID_RESU_RANK");
            Long oid = new Long(bd.longValue());
            oids[i] = oid;
        }

        dtoOids.setOids(oids);
        UtilidadesLog.info("DAOBaseCalculo.obtenerResultadosRanking(Long "
            +"oidConcurso, Long oidPeriodoCalculo):Salida");

        return dtoOids;
    }

    /**
     * Este metodo elimina de la entidad ResultadoRanking el registro
     * cuyo id es pasado por parametro (oidResultadoRanking)
     *
     * Sistema: Belcorp
     * Módulo:  INC
     * Fecha:   30/06/2005
     * @version 1.00
     * @autor   Diego Morello
     */
    public void eliminarResultadoRanking(Long oidResultRank)
        throws MareException {
        UtilidadesLog.info("DAOBaseCalculo.eliminarResultadoRanking(Long "
            +"oidResultRank):Entrada");

        try {
            ResultadosRankingLocalHome home = this.getResultadosRankingLocalHome();
            ResultadosRankingLocal resRank = home.findByPrimaryKey(oidResultRank);
            home.remove(resRank);
        } catch (PersistenceException fe) {
            UtilidadesLog.error("ERROR ", fe);

            int error = UtilidadesError.armarCodigoError(
                CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE);
            throw new MareException(fe, error);
        }

        UtilidadesLog.info("DAOBaseCalculo.eliminarResultadoRanking(Long "
            +"oidResultRank):Salida");
    }

    /**
     * Este metodo obtiene los concursos activos comprendidos entre
     * periodoDesde y periodoHasta. Ademas obtiene los clientes del concurso.
     *
     * Sistema: Belcorp
     * Módulo:  INC
     * Fecha:   28/06/205
     * @version 1.00
     * @autor   Diego Morello
     */
    public RecordSet obtenerClientesConcursosRanking(DTOFACProcesoCierre dtoE)
        throws MareException {
        UtilidadesLog.info(
            "DAOBaseCalculo.obtenerClientesConcursosRanking(DTOFACProcesoCierre"
                +" dtoE):Entrada");

        RecordSet rs = new RecordSet();
        StringBuffer query = new StringBuffer();
        BelcorpService bs = null;

        try {
            bs = BelcorpService.getInstance();
        } catch (MareMiiServiceNotFoundException e) {
            UtilidadesLog.error("ERROR ", e);

            int error = UtilidadesError.armarCodigoError(
                CodigosError.ERROR_AL_PEDIR_UN_SERVICIO_MARE);
            throw new MareException(e, error);
        }

        // vbongiov -- 22/09/2006 -- inc DBLG500000756
        query.append(" SELECT * FROM( ");
        
        query.append(" SELECT DISTINCT ");
        query.append(" 	   cpg.OID_PARA_GRAL, ");
        query.append(" 	   cli_con.CLIE_OID_CLIE,  ");
        query.append(" 	   unid_admin.OID_SUBG_VENT, ");
        query.append(" 	   unid_admin.OID_REGI,  ");
        query.append(" 	   unid_admin.OID_ZONA, ");
        query.append(" 	   unid_admin.OID_SECC, ");
        query.append(" 	   unid_admin.OID_TERR_ADMI, ");
        query.append(" 		 unid_admin.TERR_OID_TERR, ");
        query.append(" 	   cpr.FCAL_OID_FORM_CALC, ");
        query.append(" 	   cpg.BCAL_OID_BASE_CALC, ");
        query.append(" 	   cprank.TPRK_OID_TIPO_RANK,  ");
        query.append(" 	   cpg.DIRI_OID_DIRI,  ");
        // vbongiov -- 27/07/2006 -- inc DBLG500000937
        query.append(" 	   cpg.TEXI_OID_TIPO_EXIG, ");
        // vbongiov -- 22/09/2006 -- inc DBLG500000756
        query.append(" 	NULL TIPO_UNIDAD ");
        query.append(" FROM ");
        query.append(" 	   INC_CONCU_PARAM_GENER cpg,  ");
        query.append(" 	   INC_CONCU_PARAM_GEREN cpr,  ");
        query.append(" 	   INC_PARAM_RANKI cprank,  ");
        query.append(" 	   ( SELECT ");
        query.append(" 	       tc.CLIE_OID_CLIE, ");
        query.append(" 		   pc.COPA_OID_PARA_GRAL  ");
        query.append(" 	     FROM ");
        query.append(" 		   INC_CLASI_PARTI_CONCU pc,  ");
        query.append(" 		   INC_PARTI_CONCU_DETAL pd,  ");
        query.append(" 		   V_MAE_TIPIF_CLIEN tc  ");
        query.append(" 	     WHERE ");
        query.append("    pc.PACI_OID_PART_CONC_CABE =  ");
        query.append("  pd.PACI_OID_PART_CONC_CABE ");
        query.append(
            " 		   AND NVL(pd.TICL_OID_TIPO_CLIE,-1) = ");
        query.append(" DECODE(pd.TICL_OID_TIPO_CLIE, NULL, -1, ");
        query.append(" tc.TICL_OID_TIPO_CLIE) ");
        query.append(
            " 		   AND NVL(pd.SBTI_OID_SUBT_CLIE,-1) = ");
        query.append(" DECODE(pd.SBTI_OID_SUBT_CLIE, NULL, -1, ");
        query.append(" tc.SBTI_OID_SUBT_CLIE)  ");
        query.append(
            " 		   AND NVL(pd.TCCL_OID_TIPO_CLAS,-1) = ");
        query.append(" DECODE(pd.TCCL_OID_TIPO_CLAS, NULL, -1,  ");
        query.append(" tc.TCCL_OID_TIPO_CLASI)  ");
        query.append(
            " 		   AND NVL(pd.CLAS_OID_CLAS,-1) = ");
        query.append(" DECODE(pd.CLAS_OID_CLAS, NULL, -1, tc.CLAS_OID_CLAS) ");
        query.append(" 	   ) cli_con,  ");
        query.append(" 	   ( SELECT ");
        query.append(" 		   una.CLIE_OID_CLIE, ");
        query.append(" 		   sub.OID_SUBG_VENT, ");
        query.append(" 		   reg.OID_REGI, ");
        query.append(" 		   zon.OID_ZONA, ");
        query.append(" 		   sec.OID_SECC, ");
        query.append(" 		   terr.OID_TERR_ADMI, ");
        query.append(" 		   terr.TERR_OID_TERR ");
        query.append(" 	     FROM ");
        query.append(" 		   MAE_CLIEN_UNIDA_ADMIN una,  ");
        query.append(" 		   ZON_TERRI_ADMIN terr,  ");
        query.append(" 		   ZON_SECCI sec,  ");
        query.append(" 		   ZON_ZONA zon,  ");
        query.append(" 		   ZON_REGIO reg,  ");
        query.append(" 		   ZON_SUB_GEREN_VENTA sub  ");
        query.append(" 	     WHERE ");
        query.append(" 		   una.ZTAD_OID_TERR_ADMI = terr.OID_TERR_ADMI  ");
        query.append(" 		   AND terr.ZSCC_OID_SECC = sec.OID_SECC  ");
        query.append(" 		   AND sec.ZZON_OID_ZONA = zon.OID_ZONA  ");
        query.append(" 		   AND zon.ZORG_OID_REGI = reg.OID_REGI  ");
        query.append(" 		   AND reg.ZSGV_OID_SUBG_VENT =  ");
        query.append(" sub.OID_SUBG_VENT ");
        query.append(" 		   AND una.IND_ACTI = 1  ");
        query.append(" 		   AND una.FEC_ULTI_ACTU = ( SELECT ");
        query.append(" 				 MAX(una1.FEC_ULTI_ACTU)  ");
        query.append(" 				 FROM ");
        query.append(" 				 MAE_CLIEN_UNIDA_ADMIN una1  ");
        query.append(" 				 WHERE ");
        query.append(" 				 una1.CLIE_OID_CLIE = una.CLIE_OID_CLIE ");
        query.append(" 				)  ");
        query.append(" 	   ) unid_admin, ");
        query.append(" 	   CRA_PERIO pDesde, ");
        query.append(" 	   CRA_PERIO pHasta, ");
        query.append(" 	   CRA_PERIO peri ");
        query.append(" WHERE ");
        query.append(" 	   cpg.IND_RANK = 1  ");
        query.append(" 	   AND cpg.PAIS_OID_PAIS =  " + dtoE.getOidPais());
        query.append(" 	   AND cpg.MARC_OID_MARC =  " + dtoE.getMarca());
        query.append(" 	   AND cpg.CANA_OID_CANA =  " + dtoE.getCanal());
        query.append(" 	   AND cpg.OID_PARA_GRAL = cpr.COPA_OID_PARA_GRAL (+)  ");
        query.append(" 	   AND cpg.OID_PARA_GRAL = cprank.COPA_OID_PARA_GRAL (+)  ");
        query.append(" 	   AND cpg.IND_ACTI = 1  ");
        query.append(" 	   AND cpg.PERD_OID_PERI_DESD = pDesde.OID_PERI  ");
        query.append(" 	   AND cpg.PERD_OID_PERI_HAST = pHasta.OID_PERI  ");
        query.append(" 	   AND peri.OID_PERI = " + dtoE.getPeriodo());
        query.append(" 	   AND pDesde.FEC_INIC <= peri.FEC_INIC  ");
        query.append(" 	   AND pHasta.FEC_FINA >= peri.FEC_FINA  ");
        query.append(" 	   AND cpg.OID_PARA_GRAL = cli_con.COPA_OID_PARA_GRAL  ");
        query.append(" 	   AND cli_con.CLIE_OID_CLIE = unid_admin.CLIE_OID_CLIE  ");
        // vbongiov - 20/04/2006 - Inc DBLG500000590 y DBLG500000591
        query.append(" AND cprank.TPRK_OID_TIPO_RANK = " + ConstantesINC.TIPO_RANKING_EVOLUTIVO);
        
        // vbongiov -- 22/09/2006 -- inc DBLG500000756
        query.append(" AND CPG.DIRI_OID_DIRI = " + ConstantesINC.OID_DIRIGIDO_A_CONSULTORAS );
        query.append(" UNION ");
        query.append(" SELECT DISTINCT ");
        query.append(" 	cpg.OID_PARA_GRAL, ");
        query.append(" 	cli_con.CLIE_OID_CLIE, ");
        query.append(" 	unid_admin.OID_SUBG_VENT,  ");
        query.append(" 	unid_admin.OID_REGI, ");
        query.append(" 	unid_admin.OID_ZONA, ");
        query.append(" 	unid_admin.OID_SECC, ");
        query.append(" 	NULL OID_TERR_ADMI, ");
        query.append(" 	NULL TERR_OID_TERR, ");
        query.append(" 	cpr.FCAL_OID_FORM_CALC, ");
        query.append(" 	cpg.BCAL_OID_BASE_CALC, ");
        query.append(" 	cprank.TPRK_OID_TIPO_RANK,  ");
        query.append(" 	CPG.TEXI_OID_TIPO_EXIG, ");
        query.append(" 	cpg.DIRI_OID_DIRI, ");
        query.append(" 	UNID_ADMIN.TIPO_UNIDAD ");
        query.append(" FROM ");
        query.append(" 	INC_CONCU_PARAM_GENER cpg,  ");
        query.append(" 	INC_CONCU_PARAM_GEREN cpr,  ");
        query.append(" 	INC_PARAM_RANKI cprank,  ");
        query.append(" 	( SELECT ");
        query.append(" 		tc.CLIE_OID_CLIE, ");
        query.append(" 		COPA_OID_PARA_GRAL  ");
        query.append(" 	  FROM ");
        query.append(" 		INC_CLASI_PARTI_CONCU pc,  ");
        query.append(" 		INC_PARTI_CONCU_DETAL pd,  ");
        query.append(" 		V_MAE_TIPIF_CLIEN tc ");
        query.append(" 	  WHERE ");
        query.append(
            " 		pc.PACI_OID_PART_CONC_CABE = pd.PACI_OID_PART_CONC_CABE ");
        query.append(
            " 		AND NVL(pd.TICL_OID_TIPO_CLIE,-1) = ");
        query.append(" DECODE(pd.TICL_OID_TIPO_CLIE, NULL, -1, ");
        query.append(" tc.TICL_OID_TIPO_CLIE)  ");
        query.append(
            " 		AND NVL(pd.SBTI_OID_SUBT_CLIE,-1) = ");
        query.append(" DECODE(pd.SBTI_OID_SUBT_CLIE, NULL, -1, "); 
        query.append(" tc.SBTI_OID_SUBT_CLIE)  ");
        query.append(
            " 		AND NVL(pd.TCCL_OID_TIPO_CLAS,-1) = ");
        query.append(" DECODE(pd.TCCL_OID_TIPO_CLAS, NULL, -1, ");
        query.append(" tc.TCCL_OID_TIPO_CLASI)  ");
        query.append(
            " 		AND NVL(pd.CLAS_OID_CLAS,-1) = DECODE(pd.CLAS_OID_CLAS, ");
        query.append(" NULL, -1, tc.CLAS_OID_CLAS) ");
        query.append(" 	) cli_con,  ");
        query.append(" (SELECT SUB.OID_SUBG_VENT, NULL OID_REGI, NULL OID_ZONA, ");
        query.append(" NULL OID_SECC,NULL OID_TERR_ADMI, SUB.CLIE_OID_CLIE, ");
        query.append(" 'ConstantesUnidadAdministrativa.SUBGERENCIA' TIPO_UNIDAD ");            
        query.append(" FROM ZON_SUB_GEREN_VENTA SUB ");
        query.append(" WHERE SUB.CLIE_OID_CLIE IS NOT NULL ");
        query.append(" UNION ");
        query.append(" SELECT SUB.OID_SUBG_VENT, REG.OID_REGI, NULL OID_ZONA, ");
        query.append(" NULL OID_SECC, NULL OID_TERR_ADMI, REG.CLIE_OID_CLIE, ");
        query.append(" 'ConstantesUnidadAdministrativa.REGION' TIPO_UNIDAD ");  
        query.append(" FROM ZON_SUB_GEREN_VENTA SUB, ZON_REGIO REG ");
        query.append(" WHERE SUB.OID_SUBG_VENT = REG.ZSGV_OID_SUBG_VENT ");
        query.append(" AND REG.CLIE_OID_CLIE IS NOT NULL ");
        query.append(" UNION ");
        query.append(" SELECT SUB.OID_SUBG_VENT, REG.OID_REGI, ZON.OID_ZONA, ");
        query.append(" NULL OID_SECC, NULL OID_TERR_ADMI, ZON.CLIE_OID_CLIE, ");
        query.append(" 'ConstantesUnidadAdministrativa.ZONA' TIPO_UNIDAD ");  
        query.append(" FROM ZON_SUB_GEREN_VENTA SUB, ZON_REGIO REG, ZON_ZONA ZON ");
        query.append(" WHERE SUB.OID_SUBG_VENT = REG.ZSGV_OID_SUBG_VENT ");
        query.append(" AND REG.OID_REGI = ZON.ZORG_OID_REGI ");
        query.append(" AND ZON.CLIE_OID_CLIE IS NOT NULL ");
        query.append(" UNION ");
        query.append(" SELECT SUB.OID_SUBG_VENT, REG.OID_REGI, ZON.OID_ZONA, ");
        query.append(" SEC.OID_SECC, NULL OID_TERR_ADMI, SEC.CLIE_OID_CLIE, ");
        query.append(" 'ConstantesUnidadAdministrativa.SECCION' TIPO_UNIDAD ");  
        query.append(" FROM ZON_SUB_GEREN_VENTA SUB, ZON_REGIO REG, ZON_ZONA ZON, ZON_SECCI SEC ");
        query.append(" WHERE SUB.OID_SUBG_VENT = REG.ZSGV_OID_SUBG_VENT ");
        query.append(" AND REG.OID_REGI = ZON.ZORG_OID_REGI ");
        query.append(" AND ZON.OID_ZONA = SEC.ZZON_OID_ZONA ");
        query.append(" AND SEC.CLIE_OID_CLIE IS NOT NULL ");
        query.append(") UNID_ADMIN, ");     
        query.append(" 	   CRA_PERIO pDesde, ");
        query.append(" 	   CRA_PERIO pHasta, ");
        query.append(" 	   CRA_PERIO peri ");
        query.append(" WHERE ");
        query.append(" 	   cpg.IND_RANK = 1  ");
        query.append(" 	   AND cpg.PAIS_OID_PAIS =  " + dtoE.getOidPais());
        query.append(" 	   AND cpg.MARC_OID_MARC =  " + dtoE.getMarca());
        query.append(" 	   AND cpg.CANA_OID_CANA =  " + dtoE.getCanal());
        query.append(" 	   AND cpg.OID_PARA_GRAL = cpr.COPA_OID_PARA_GRAL (+)  ");
        query.append(" 	   AND cpg.OID_PARA_GRAL = cprank.COPA_OID_PARA_GRAL (+)  ");
        query.append(" 	   AND cpg.IND_ACTI = 1  ");
        query.append(" 	   AND cpg.PERD_OID_PERI_DESD = pDesde.OID_PERI  ");
        query.append(" 	   AND cpg.PERD_OID_PERI_HAST = pHasta.OID_PERI  ");
        query.append(" 	   AND peri.OID_PERI = " + dtoE.getPeriodo());
        query.append(" 	   AND pDesde.FEC_INIC <= peri.FEC_INIC  ");
        query.append(" 	   AND pHasta.FEC_FINA >= peri.FEC_FINA  ");
        query.append(" 	   AND cpg.OID_PARA_GRAL = cli_con.COPA_OID_PARA_GRAL  ");
        query.append(" 	   AND cli_con.CLIE_OID_CLIE = unid_admin.CLIE_OID_CLIE  ");
        query.append("     AND cprank.TPRK_OID_TIPO_RANK = " + ConstantesINC.TIPO_RANKING_EVOLUTIVO);        
        // vbongiov -- 22/09/2006 -- inc DBLG500000756
        query.append("    AND CPG.DIRI_OID_DIRI = " + ConstantesINC.OID_DIRIGIDO_A_GERENTE );
        query.append(" 	)  ORDER BY  OID_PARA_GRAL ");

        try {
            rs = bs.dbService.executeStaticQuery(query.toString());
            UtilidadesLog.debug("resultado query: " + rs);
        } catch (Exception e) {
            UtilidadesLog.error("ERROR ", e);

            int error = UtilidadesError.armarCodigoError(
                CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS);
            throw new MareException(e, error);
        }

        UtilidadesLog.info( "DAOBaseCalculo.obtenerClientesConcursosRanking( "
            +"DTOFACProcesoCierre dtoE):Salida");

        return rs;
    }

    /**
     * Este metodo obtiene algunos datos del concurso pasado por parametro
     * y ademas obtiene los clientes de este concurso
     *
     * Sistema: Belcorp
     * Módulo:  INC
     * Fecha:   28/06/205
     * @version 1.00
     * @autor   Diego Morello
     */
    public RecordSet obtenerClientesConcursosRanking(Long oidConcurso)
        throws MareException {
        UtilidadesLog.info("DAOBaseCalculo.obtenerClientesConcursosRanking("
            +"Long oidConcurso):Entrada");

        RecordSet rs = new RecordSet();
        StringBuffer query = new StringBuffer();
        BelcorpService bs = null;
        
        // vbongiov -- 22/09/2006 -- inc DBLG500000756
        DespacharPremiosHelper dao = new DespacharPremiosHelper();
        Concurso concurso = dao.obtenerConcurso(oidConcurso);

        try {
            bs = BelcorpService.getInstance();
        } catch (MareMiiServiceNotFoundException e) {
            UtilidadesLog.error("ERROR ", e);
            int error = UtilidadesError.armarCodigoError(
            CodigosError.ERROR_AL_PEDIR_UN_SERVICIO_MARE);
            throw new MareException(e, error);
        }
        
        // vbongiov -- 27/07/2006 -- inc DBLG500000937
        // vbongiov -- 22/09/2006 -- inc DBLG500000756
        if(concurso.getDirigidoA().equals(ConstantesINC.OID_DIRIGIDO_A_CONSULTORAS)){
        
            query.append(" SELECT CPG.OID_PARA_GRAL, ");
            query.append("        UNA.CLIE_OID_CLIE, ");
            query.append("        SUB.OID_SUBG_VENT,  ");
            query.append("        REG.OID_REGI, ");
            query.append("        ZON.OID_ZONA,  ");
            query.append("        SEC.OID_SECC, ");
            query.append("        TERR.OID_TERR_ADMI,  ");
            query.append("        TERR.TERR_OID_TERR,  ");
            query.append("        (SELECT CPR.FCAL_OID_FORM_CALC ");
            query.append("             FROM INC_CONCU_PARAM_GEREN CPR ");
            query.append("               WHERE CPR.COPA_OID_PARA_GRAL = CPG.OID_PARA_GRAL ");
            query.append("        ) FCAL_OID_FORM_CALC,  ");
            query.append("        CPG.BCAL_OID_BASE_CALC,  ");
            query.append("        CPG.DIRI_OID_DIRI,  ");
            query.append("        (SELECT CPRANK.TPRK_OID_TIPO_RANK ");
            query.append("               FROM  INC_PARAM_RANKI CPRANK  ");
            query.append("               WHERE CPRANK.COPA_OID_PARA_GRAL = CPG.OID_PARA_GRAL ");
            query.append("         ) TPRK_OID_TIPO_RANK, ");
            query.append("        CPG.TEXI_OID_TIPO_EXIG, ");
            query.append("        NULL TIPO_UNIDAD ");
            query.append(" FROM ZON_TERRI_ADMIN TERR, ");
            query.append("      ZON_SECCI SEC, ");
            query.append("      ZON_ZONA ZON, ");
            query.append("      ZON_REGIO REG, ");
            query.append("      ZON_SUB_GEREN_VENTA SUB, ");
            query.append("      INC_CONCU_PARAM_GENER CPG, ");
            query.append("      MAE_CLIEN_UNIDA_ADMIN UNA ");
            query.append(" WHERE CPG.OID_PARA_GRAL = " + oidConcurso);
            query.append(" AND UNA.CLIE_OID_CLIE IN (  ");
            query.append(" 	     SELECT DISTINCT TC.CLIE_OID_CLIE ");
            query.append(" 	     FROM INC_CLASI_PARTI_CONCU PC, ");
            query.append(" 		    INC_PARTI_CONCU_DETAL PD, ");
            query.append(" 		    V_MAE_TIPIF_CLIEN TC ");
            query.append(" 	     WHERE PC.COPA_OID_PARA_GRAL = " + oidConcurso);
            query.append(" 	     AND PC.PACI_OID_PART_CONC_CABE = PD.PACI_OID_PART_CONC_CABE ");
            query.append(" 	     AND PD.TICL_OID_TIPO_CLIE = TC.TICL_OID_TIPO_CLIE ");
            query.append(" 	     AND NVL (PD.SBTI_OID_SUBT_CLIE, -1) = DECODE (PD.SBTI_OID_SUBT_CLIE, NULL, -1, TC.SBTI_OID_SUBT_CLIE) ");
            query.append(" 	     AND NVL (PD.TCCL_OID_TIPO_CLAS, -1) = DECODE (PD.TCCL_OID_TIPO_CLAS, NULL, -1, TC.TCCL_OID_TIPO_CLASI) ");
            query.append(" 	     AND NVL (PD.CLAS_OID_CLAS, -1) = DECODE (PD.CLAS_OID_CLAS, NULL, -1, TC.CLAS_OID_CLAS) ");
            query.append(" 	     ) ");
            query.append(" AND UNA.IND_ACTI = 1 ");
            query.append(" AND UNA.ZTAD_OID_TERR_ADMI = TERR.OID_TERR_ADMI ");
            query.append(" AND TERR.ZSCC_OID_SECC = SEC.OID_SECC ");
            query.append(" AND SEC.ZZON_OID_ZONA = ZON.OID_ZONA ");
            query.append(" AND ZON.ZORG_OID_REGI = REG.OID_REGI ");
            query.append(" AND REG.ZSGV_OID_SUBG_VENT = SUB.OID_SUBG_VENT ");
            
        } else {
        
            query.append(" SELECT CPG.OID_PARA_GRAL, ");
            query.append(" UNID_ADMIN.CLIE_OID_CLIE, ");
            query.append(" UNID_ADMIN.OID_SUBG_VENT, ");
            query.append(" UNID_ADMIN.OID_REGI, ");
            query.append(" UNID_ADMIN.OID_ZONA, ");
            query.append(" UNID_ADMIN.OID_SECC, ");
            query.append(" UNID_ADMIN.OID_TERR_ADMI, ");
            query.append(" UNID_ADMIN.TERR_OID_TERR, ");
            query.append(" ( SELECT CPR.FCAL_OID_FORM_CALC ");
            query.append("   FROM INC_CONCU_PARAM_GEREN CPR ");
            query.append("   WHERE CPR.COPA_OID_PARA_GRAL = CPG.OID_PARA_GRAL ");
            query.append(" ) FCAL_OID_FORM_CALC, ");
            query.append(" CPG.BCAL_OID_BASE_CALC, ");
            query.append(" CPG.DIRI_OID_DIRI, ");
            query.append(" ( SELECT CPRANK.TPRK_OID_TIPO_RANK ");
            query.append("   FROM  INC_PARAM_RANKI CPRANK ");
            query.append("   WHERE CPRANK.COPA_OID_PARA_GRAL = CPG.OID_PARA_GRAL ");
            query.append(" ) TPRK_OID_TIPO_RANK, ");
            query.append(" CPG.TEXI_OID_TIPO_EXIG, ");
            query.append(" UNID_ADMIN.TIPO_UNIDAD ");
            query.append(" FROM INC_CONCU_PARAM_GENER CPG, ");
            query.append(" ( ");
            query.append("   SELECT SUB.OID_SUBG_VENT, ");
            query.append("   NULL OID_REGI, ");
            query.append("   NULL OID_ZONA, ");
            query.append("   NULL OID_SECC, ");
            query.append("   NULL OID_TERR_ADMI, ");
            query.append("   NULL TERR_OID_TERR, ");
            query.append("   SUB.CLIE_OID_CLIE, ");
            query.append("   'ConstantesUnidadAdministrativa.SUBGERENCIA' TIPO_UNIDAD ");
            query.append("   FROM ZON_SUB_GEREN_VENTA SUB ");
            query.append("   WHERE SUB.CLIE_OID_CLIE IS NOT NULL ");
            query.append("  UNION ");
            query.append(" 	 SELECT SUB.OID_SUBG_VENT, ");
            query.append(" 	 REG.OID_REGI, ");
            query.append(" 	 NULL OID_ZONA, ");
            query.append(" 	 NULL OID_SECC, ");
            query.append(" 	 NULL OID_TERR_ADMI, "); 
            query.append(" 	 NULL TERR_OID_TERR, ");
            query.append(" 	 REG.CLIE_OID_CLIE, ");
            query.append(" 	 'ConstantesUnidadAdministrativa.REGION' TIPO_UNIDAD ");
            query.append("   FROM ZON_SUB_GEREN_VENTA SUB, ");
            query.append("   ZON_REGIO REG ");
            query.append("   WHERE SUB.OID_SUBG_VENT = REG.ZSGV_OID_SUBG_VENT ");
            query.append("   AND REG.CLIE_OID_CLIE IS NOT NULL ");
            query.append("  UNION ");
            query.append("   SELECT SUB.OID_SUBG_VENT, ");
            query.append(" 	 REG.OID_REGI, ");
            query.append(" 	 ZON.OID_ZONA, ");
            query.append("   NULL OID_SECC, ");
            query.append(" 	 NULL OID_TERR_ADMI, ");
            query.append(" 	 NULL TERR_OID_TERR, ");
            query.append(" 	 ZON.CLIE_OID_CLIE, ");
            query.append(" 	 'ConstantesUnidadAdministrativa.ZONA' TIPO_UNIDAD ");
            query.append("   FROM ZON_SUB_GEREN_VENTA SUB, ");
            query.append(" 	 ZON_REGIO REG, ");
            query.append(" 	 ZON_ZONA ZON ");
            query.append("   WHERE SUB.OID_SUBG_VENT = REG.ZSGV_OID_SUBG_VENT ");
            query.append("   AND REG.OID_REGI = ZON.ZORG_OID_REGI ");
            query.append("   AND ZON.CLIE_OID_CLIE IS NOT NULL ");
            query.append("  UNION ");
            query.append("   SELECT SUB.OID_SUBG_VENT, ");
            query.append(" 	 REG.OID_REGI, ");
            query.append(" 	 ZON.OID_ZONA, ");
            query.append(" 	 SEC.OID_SECC, ");
            query.append(" 	 NULL OID_TERR_ADMI, ");
            query.append(" 	 NULL TERR_OID_TERR, ");
            query.append(" 	 SEC.CLIE_OID_CLIE, ");
            query.append(" 	 'ConstantesUnidadAdministrativa.SECCION' TIPO_UNIDAD ");
            query.append("   FROM ZON_SUB_GEREN_VENTA SUB, ");
            query.append(" 	 ZON_REGIO REG, ");
            query.append(" 	 ZON_ZONA ZON, ");
            query.append(" 	 ZON_SECCI SEC ");
            query.append("   WHERE SUB.OID_SUBG_VENT = REG.ZSGV_OID_SUBG_VENT ");
            query.append("   AND REG.OID_REGI = ZON.ZORG_OID_REGI ");
            query.append("   AND ZON.OID_ZONA = SEC.ZZON_OID_ZONA ");
            query.append("   AND SEC.CLIE_OID_CLIE IS NOT NULL ");
            query.append(" ) UNID_ADMIN ");
            query.append(" WHERE CPG.OID_PARA_GRAL = " + oidConcurso);
            query.append(" AND UNID_ADMIN.CLIE_OID_CLIE IN ( ");               
            query.append(" 	  SELECT DISTINCT TC.CLIE_OID_CLIE ");
            query.append(" 	  FROM INC_CLASI_PARTI_CONCU PC, ");
            query.append("    INC_PARTI_CONCU_DETAL PD, ");
            query.append(" 	  V_MAE_TIPIF_CLIEN TC ");
            query.append(" 	  WHERE PC.COPA_OID_PARA_GRAL = " + oidConcurso);
            query.append(" 	  AND PC.PACI_OID_PART_CONC_CABE = PD.PACI_OID_PART_CONC_CABE ");
            query.append(" 	  AND PD.TICL_OID_TIPO_CLIE = TC.TICL_OID_TIPO_CLIE ");
            query.append(" 	  AND NVL (PD.SBTI_OID_SUBT_CLIE, -1) = DECODE (PD.SBTI_OID_SUBT_CLIE, NULL, -1, TC.SBTI_OID_SUBT_CLIE) ");
            query.append(" 	  AND NVL (PD.TCCL_OID_TIPO_CLAS, -1) = DECODE (PD.TCCL_OID_TIPO_CLAS, NULL, -1, TC.TCCL_OID_TIPO_CLASI) ");
            query.append(" 	  AND NVL (PD.CLAS_OID_CLAS, -1) = DECODE (PD.CLAS_OID_CLAS, NULL, -1, TC.CLAS_OID_CLAS) ");
            query.append(" ) ");
        }
        
        
        try {
            rs = bs.dbService.executeStaticQuery(query.toString());
            UtilidadesLog.debug("resultado query: " + rs);
        } catch (Exception e) {
            UtilidadesLog.error("ERROR ", e);
            int error = UtilidadesError.armarCodigoError(
                CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS);
            throw new MareException(e, error);
        }

        UtilidadesLog.info(
            "DAOBaseCalculo.obtenerClientesConcursosRanking(Long oidConcurso) "
            +" :Salida");

        return rs;
    }

    /**
     * Este método recupera las consultoras que dentro de los periodos pasados
     * por parametro, pertencencen a las unidades administrativas pasadas 
     * tambien por parametro
     *
     * Sistema: Belcorp
     * Módulo:  INC
     * Fecha:   01/07/2005
     * @version 1.00
     * @autor   Sergio Saavedra
     */
    public RecordSet obtenerConsultoras(Periodo periodoDesde,
        Periodo periodoHasta, UnidadesAdministrativasGerenciadas uniAdmGer)
        throws MareException {
        UtilidadesLog.info("DAOBaseCalculo.obtenerConsultoras(Periodo "
            +"periodoDesde, Periodo periodoHasta, "
            +"UnidadesAdministrativasGerenciadas uniAdmGer):Entrada");

        RecordSet rs = new RecordSet();
        StringBuffer query = new StringBuffer();
        BelcorpService bs = null;

        try {
            bs = BelcorpService.getInstance();
        } catch (MareMiiServiceNotFoundException e) {
            UtilidadesLog.error("ERROR ", e);
            int error = UtilidadesError.armarCodigoError(
                CodigosError.ERROR_AL_PEDIR_UN_SERVICIO_MARE);
            throw new MareException(e, error);
        }

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String strFechaDesde = sdf.format(periodoDesde.getFechaDesde());
        String strFechaHasta = sdf.format(periodoHasta.getFechaHasta());

        query.append("SELECT unida.clie_oid_clie ");

        query.append("FROM mae_clien_unida_admin unida, ");
        query.append("cra_perio p1, ");
        query.append("cra_perio p2, ");
        query.append("zon_terri_admin terr, ");
        query.append("zon_secci sec, ");
        query.append("zon_zona zon, ");
        query.append("zon_regio reg, ");
        query.append("zon_sub_geren_venta sub, ");
        query.append("mae_clien_tipo_subti tip ");

        query.append("WHERE unida.ind_acti = 1 ");

        //-- Filtro de la unidad administrativa del cliente dentro de los 
        //periodos del concurso 
        query.append("AND unida.perd_oid_peri_ini = p1.oid_peri ");
        query.append("AND unida.perd_oid_peri_fin = p2.oid_peri(+) ");
        query.append("AND ( p2.fec_fina IS NULL OR p2.fec_fina >= TO_DATE('" +
            strFechaDesde + "', 'YYYY-MM-DD')) ");
        query.append("AND ( p1.fec_inic <= TO_DATE('" + strFechaHasta +
            "', 'YYYY-MM-DD')) ");

        // -- Filtros de Pais, Marca, Canal en Periodos 
        query.append("AND p1.pais_oid_pais = " +
            periodoDesde.getOidPais().longValue());
        query.append(" AND p1.marc_oid_marc = " +
            periodoDesde.getOidMarca().longValue());
        query.append(" AND p1.cana_oid_cana = " +
            periodoDesde.getOidCanal().longValue());
        query.append(" AND p2.pais_oid_pais(+) = " +
            periodoHasta.getOidPais().longValue());
        query.append(" AND p2.marc_oid_marc(+) = " +
            periodoHasta.getOidMarca().longValue());
        query.append(" AND p2.cana_oid_cana(+) = " +
            periodoHasta.getOidCanal().longValue());

        query.append(" AND unida.ztad_oid_terr_admi = terr.oid_terr_admi ");
        query.append("AND terr.zscc_oid_secc = sec.oid_secc ");
        query.append("AND sec.zzon_oid_zona = zon.oid_zona ");
        query.append("AND zon.zorg_oid_regi = reg.oid_regi ");
        query.append("AND reg.zsgv_oid_subg_vent = sub.oid_subg_vent ");

        if (uniAdmGer != null) {
            query.append("AND ( ");

            //-- zonificacion -- 
            if (uniAdmGer.getSubGerencias() != null) {
                query.append("sub.OID_SUBG_VENT " +
                    generoLike(uniAdmGer.getSubGerencias()));
            } else if (uniAdmGer.getRegiones() != null) {
                query.append("reg.OID_REGI " +
                    generoLike(uniAdmGer.getRegiones()));
            } else if (uniAdmGer.getZonas() != null) {
                query.append("zon.OID_ZONA " +
                    generoLike(uniAdmGer.getZonas()));
            } else if (uniAdmGer.getSecciones() != null) {
                query.append("sec.OID_SECC " +
                    generoLike(uniAdmGer.getSecciones()));
            }

            query.append(" ) ");
        }

        query.append(" AND tip.clie_oid_clie = unida.clie_oid_clie ");
        query.append(" AND tip.ind_ppal = 1 ");
        query.append(" AND tip.ticl_oid_tipo_clie = " +
            ConstantesMAE.OID_TIPO_CLIENTE_CONSULTORA.longValue());

        try {
            rs = bs.dbService.executeStaticQuery(query.toString());
            UtilidadesLog.debug("resultado query: " + rs);
        } catch (Exception e) {
            UtilidadesLog.error("ERROR ", e);
            int error = UtilidadesError.armarCodigoError(
                CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS);
            throw new MareException(e, error);
        }

        UtilidadesLog.info("DAOBaseCalculo.obtenerConsultoras(Periodo "
            +"periodoDesde, Periodo periodoHasta, "
            +"UnidadesAdministrativasGerenciadas uniAdmGer):Salida");

        return rs;
    }

    private String generoLike(ArrayList oids) throws MareException {
        UtilidadesLog.info("DAOBaseCalculo.generoLike(ArrayList oids): "
            + "Entrada");

        StringBuffer sClausula = new StringBuffer("");

        try {
            sClausula.append(" IN ( ");

            for (int i = 0; i < oids.size(); i++) {
                Long oid = (Long) oids.get(i);

                if (i != 0) {
                    sClausula.append(", ");
                }

                sClausula.append("" + oid);
            }

            sClausula.append(") ");
        } catch (Exception ex) {
            UtilidadesLog.error("ERROR ", ex);

            String sCodigoError = 
                CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS;
            throw new MareException(ex,
                UtilidadesError.armarCodigoError(sCodigoError));
        }

        UtilidadesLog.info("DAOBaseCalculo.generoLike(ArrayList oids):Salida");

        return sClausula.toString();
    }

    /**
     * recupera el total de monto y unidades acordes a los parametros 
     * recibidos.
     *
     * Sistema: Belcorp
     * Módulo:  INC
     * Fecha:   01/07/2005
     * @version 1.00
     * @autor   Sergio Saavedra
     */
    public DTOMontoUnidades obtenerMontoUnidadesRanking(Long oidCliente,
        Long oidConcurso, Periodo periodoDesde, Periodo periodoHasta,
        UnidadesAdministrativasGerenciadas unidadesAdmin)
        throws MareException {
        UtilidadesLog.info("DAOBaseCalculo.obtenerMontoUnidadesRanking(Long "
            +"oidCliente, Long oidConcurso, Periodo periodoDesde, Periodo "
            +"periodoHasta,UnidadesAdministrativasGerenciadas unidadesAdmin): "
            +" Entrada");
            
        // vbongiov -- 30/08/2006 -- DBLG500001055 y DBLG500001179   
        // Obtengo el concurso    
        FactoriaConcurso factoria= FactoriaConcurso.getFactoriaConcurso();
       
        DTOOIDs dtoOids = new DTOOIDs();
        Long[] oids = {oidConcurso};
        dtoOids.setOids(oids);
  
        ArrayList concursos = factoria.getConcursosPorOID(dtoOids);
        Concurso concurso = (Concurso) concursos.get(0);

        RecordSet rs = new RecordSet();
        StringBuffer query = new StringBuffer();
        BelcorpService bs = null;

        DTOMontoUnidades resu = new DTOMontoUnidades();

        try {
            bs = BelcorpService.getInstance();
        } catch (MareMiiServiceNotFoundException e) {
            UtilidadesLog.error("ERROR ", e);

            int error = UtilidadesError.armarCodigoError(
                CodigosError.ERROR_AL_PEDIR_UN_SERVICIO_MARE);
            throw new MareException(e, error);
        }

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String strFechaDesde = sdf.format(periodoDesde.getFechaDesde());
        String strFechaHasta = sdf.format(periodoHasta.getFechaHasta());

        query.append(" SELECT SUM(solConcPunt.IMP_MONT) AS Smonto, ");
        query.append(" SUM(solConcPunt.NUM_UNID) AS Sunidades ");
        query.append(" FROM INC_SOLIC_CONCU_PUNTA solConcPunt, ");
        query.append(" PED_SOLIC_CABEC solCab, ZON_TERRI_ADMIN terrAdmin, ");
        query.append(" CRA_PERIO periSolic ");

        if (unidadesAdmin != null) {
            query.append(" , ");
            query.append(" zon_secci sec, ");
            query.append(" zon_zona zon, ");
            query.append(" zon_regio reg, ");
            query.append(" zon_sub_geren_venta sub ");
        }
        
        // vbongiov -- 30/08/2006 -- DBLG500001055 y DBLG500001179     
        if (concurso.getIndAnulacion()){
            query.append(" , PED_SOLIC_CABEC CONSO  ");
        }

        query.append(
            " WHERE solConcPunt.SOCA_OID_SOLI_CABE = solCab.OID_SOLI_CABE ");
        query.append(
            " AND solCab.ZTAD_OID_TERR_ADMI = terrAdmin.OID_TERR_ADMI ");
        query.append(" AND solCab.PERD_OID_PERI = periSolic.OID_PERI ");
        query.append(" AND solCab.IND_OC = 1 ");
        query.append(" AND solConcPunt.COPA_OID_PARA_GRAL = " +
            oidConcurso.longValue());
        query.append(" AND solConcPunt.CLIE_OID_CLIE = " +
            oidCliente.longValue());
        query.append(" AND periSolic.FEC_INIC >= TO_DATE('" + strFechaDesde +
            "', 'YYYY-MM-DD') ");
        query.append(" AND periSolic.FEC_FINA <= TO_DATE('" + strFechaHasta +
            "', 'YYYY-MM-DD') ");

        //- Filtro de pais, marca y canal
        query.append(" AND periSolic.PAIS_OID_PAIS = " +
            periodoDesde.getOidPais().longValue());
        query.append("  AND periSolic.MARC_OID_MARC = " +
            periodoDesde.getOidMarca().longValue());
        query.append("  AND periSolic.CANA_OID_CANA = " +
            periodoDesde.getOidCanal().longValue());
            
        // vbongiov -- 30/08/2006 -- DBLG500001055 y DBLG500001179       
        // Verifica si el concurso acepta anulaciones
        if (concurso.getIndAnulacion()){
            query.append(" AND solCab.SOCA_OID_SOLI_CABE = CONSO.OID_SOLI_CABE(+) ");
            query.append(" AND NVL(CONSO.ESSO_OID_ESTA_SOLI, 1) <> " + ConstantesPED.ESTADO_SOLICITUD_ANULADO); 
        }

        // Modificado por Diego Morello - 08/07/2005
        if (unidadesAdmin != null) {
            query.append(" AND terrAdmin.zscc_oid_secc = sec.oid_secc ");
            query.append(" AND sec.zzon_oid_zona = zon.oid_zona ");
            query.append(" AND zon.zorg_oid_regi = reg.oid_regi ");
            query.append(" AND reg.zsgv_oid_subg_vent = sub.oid_subg_vent ");
        } // Fin modificación

        //- Filtro de unidades administrativas gerenciadas
        //-- zonificacion -- 
        if (unidadesAdmin != null) {
            query.append(" AND ( ");

            if (unidadesAdmin.getSubGerencias() != null) {
                query.append(" sub.OID_SUBG_VENT " +
                    generoLike(unidadesAdmin.getSubGerencias()));
            } else if (unidadesAdmin.getRegiones() != null) {
                query.append(" reg.OID_REGI " +
                    generoLike(unidadesAdmin.getRegiones()));
            } else if (unidadesAdmin.getZonas() != null) {
                query.append(" zon.OID_ZONA " +
                    generoLike(unidadesAdmin.getZonas()));
            } else if (unidadesAdmin.getSecciones() != null) {
                query.append(" sec.OID_SECC " +
                    generoLike(unidadesAdmin.getSecciones()));
            }

            query.append("  ) ");
        }

        query.append("  AND solCab.FEC_FACT IS NOT NULL ");
        query.append("  AND solCab.IND_OC = 1 ");
        query.append("  group by solConcPunt.COPA_OID_PARA_GRAL, ");
        query.append("  solConcPunt.CLIE_OID_CLIE");

        try {
            rs = bs.dbService.executeStaticQuery(query.toString());
            UtilidadesLog.info("resultado query: " + rs);
        } catch (Exception e) {
            UtilidadesLog.error("ERROR ", e);

            int error = UtilidadesError.armarCodigoError(
                CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS);
            throw new MareException(e, error);
        }

        Object o = null;

        if (!rs.esVacio()) {
            resu.setMonto(((o = rs.getValueAt(0, "SMONTO")) != null)
                ? new BigDecimal(((BigDecimal) o).toString()) : new BigDecimal(
                    0));
            resu.setUnidades(((o = rs.getValueAt(0, "SUNIDADES")) != null)
                ? new Long(((BigDecimal) o).toString()) : new Long(0));
        } else {
            resu.setMonto(new BigDecimal(0));
            resu.setUnidades(new Long(0));
        }

        UtilidadesLog.info("DAOBaseCalculo.obtenerMontoUnidadesRanking(Long " 
            +"oidCliente, Long oidConcurso, Periodo periodoDesde, Periodo "
            +"periodoHasta,UnidadesAdministrativasGerenciadas unidadesAdmin): "
            +"Salir");

        return resu;
    }

    /**
     * recupera el total de monto y unidades acordes a los parametros 
     * recibidos.
     *
     * Sistema: Belcorp
     * Módulo:  INC
     * Fecha:   04/07/2005
     * @version 1.00
     * Descripcion: Este metodo suma la cantidad de solicitudes que la 
     *              consultora pasada por parametro paso en el tiempo 
     *              comprendido entre los periodoDesde y periodoHasta 
     *              pasados por parametro. Ademas si el objeto uniAdmGer es 
     *              distinto de null hay que filtrar que las  solicitudes 
     *              pertenezcan a algunas de las unidades administrativas de 
     *              uniAdmGer.
     * @autor   Sergio Saavedra
     */
    public BigDecimal calcularNumeroPedidos(Long oidCliente,
        Periodo periodoDesde, Periodo periodoHasta,
        UnidadesAdministrativasGerenciadas uniAdmGer) throws MareException {
        UtilidadesLog.info("DAOBaseCalculo.calcularNumeroPedidos(Long "
            +" oidCliente, Periodo periodoDesde, Periodo periodoHasta, "
            +"UnidadesAdministrativasGerenciadas uniAdmGer):Entrada");

        RecordSet rs = new RecordSet();
        StringBuffer query = new StringBuffer();
        BelcorpService bs = null;

        DTOMontoUnidades resu = new DTOMontoUnidades();

        try {
            bs = BelcorpService.getInstance();
        } catch (MareMiiServiceNotFoundException e) {
            UtilidadesLog.error("ERROR ", e);

            int error = UtilidadesError.armarCodigoError(
                CodigosError.ERROR_AL_PEDIR_UN_SERVICIO_MARE);
            throw new MareException(e, error);
        }

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String strFechaDesde = sdf.format(periodoDesde.getFechaDesde());
        String strFechaHasta = sdf.format(periodoHasta.getFechaHasta());

        query.append("SELECT count(psc.oid_soli_cabe) count  ");
        query.append("FROM cra_perio p1, ");
        query.append("ped_solic_cabec psc ");

        if (uniAdmGer != null) {
            query.append(", zon_terri_admin terr, ");
            query.append("zon_secci sec, ");
            query.append("zon_zona zon, ");
            query.append("zon_regio reg, ");
            query.append("zon_sub_geren_venta sub ");
        }

        query.append("WHERE psc.clie_oid_clie = " + oidCliente.longValue());
        query.append(" AND psc.fec_fact is not null ");
        query.append(" AND psc.ind_oc = 1 ");

        //-- Filtros de solicitudes dentro de los periodos del concurso 
        query.append(" AND psc.perd_oid_peri = p1.oid_peri ");
        query.append(" AND p1.fec_inic >= TO_DATE('" + strFechaDesde +
            "', 'YYYY-MM-DD') ");
        query.append(" AND p1.fec_fina <= TO_DATE('" + strFechaHasta +
            "', 'YYYY-MM-DD') ");

        query.append(" AND p1.pais_oid_pais = " +
            periodoDesde.getOidPais().longValue());
        query.append(" AND p1.marc_oid_marc = " +
            periodoDesde.getOidMarca().longValue());
        query.append(" AND p1.cana_oid_cana = " +
            periodoDesde.getOidCanal().longValue());

        if (uniAdmGer != null) {
            query.append(" AND psc.ztad_oid_terr_admi = terr.oid_terr_admi ");
            query.append(" AND terr.zscc_oid_secc = sec.oid_secc ");
            query.append(" AND sec.zzon_oid_zona = zon.oid_zona ");
            query.append(" AND zon.zorg_oid_regi = reg.oid_regi ");
            query.append(" AND reg.zsgv_oid_subg_vent = sub.oid_subg_vent ");

            query.append(" AND ( ");

            //-- zonificacion -- 
            if (uniAdmGer.getSubGerencias() != null) {
                query.append("sub.OID_SUBG_VENT " +
                    generoLike(uniAdmGer.getSubGerencias()));
            } else if (uniAdmGer.getRegiones() != null) {
                query.append("reg.OID_REGI " +
                    generoLike(uniAdmGer.getRegiones()));
            } else if (uniAdmGer.getZonas() != null) {
                query.append("zon.OID_ZONA " +
                    generoLike(uniAdmGer.getZonas()));
            } else if (uniAdmGer.getSecciones() != null) {
                query.append("sec.OID_SECC " +
                    generoLike(uniAdmGer.getSecciones()));
            }

            query.append(" ) ");
        }

        try {
            rs = bs.dbService.executeStaticQuery(query.toString());
            UtilidadesLog.debug("resultado query: " + rs);
        } catch (Exception e) {
            UtilidadesLog.error("ERROR ", e);

            int error = UtilidadesError.armarCodigoError(
                CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS);
            throw new MareException(e, error);
        }

        Object o = rs.getValueAt(0, "count");
        UtilidadesLog.info("DAOBaseCalculo.calcularNumeroPedidos(Long "
          +"oidCliente, Periodo periodoDesde, Periodo periodoHasta, "
          +"UnidadesAdministrativasGerenciadas uniAdmGer):Salida");

        return new BigDecimal(((BigDecimal) o).toString());
    }

    /**
    * recupera el total de monto y unidades acordes a los parametros recibidos.
    *
    * Sistema: Belcorp
    * Módulo:  INC
    * Fecha:   04/07/2005
    * @version 1.00
    * Descripcion: Este metodo inserta en la entidad 
    *              ClienteFaltaConstanciaActividad los datos
    *              recividos por parametro
    * @autor   Sergio Saavedra
    */
    public void grabarClienteFaltaConstanciaActividad(Long oidCliente,
        Periodo periodo) throws MareException {
        UtilidadesLog.info("DAOBaseCalculo.grabarClienteFaltaConstancia"
          +"Actividad(Long oidCliente, Periodo periodo):Entrada");
          
        if(log.isDebugEnabled()) //sapaza -- cambio Optimizacion Logs -- 24/03/2010                          
          UtilidadesLog.debug("Empezo grabarClienteFaltaConstanciaActividad con" 
            +" Periodo: " + periodo + " y oidCliente: " + oidCliente);

        ClienteFaltaConstanciaActividadLocalHome home = null;

        try {
            home = this.getClienteFaltaConstanciaActividadLocalHome();
            home.findByUk(oidCliente, periodo.getOidPeriodo());
        } catch (NoResultException fe) {
            try {
                //si no esta, creo....
                home.create(periodo.getOidPeriodo(), oidCliente);
            } catch (PersistenceException ce) {
                UtilidadesLog.error("ERROR ", ce);
                throw new MareException(ce,
                    UtilidadesError.armarCodigoError(
                        CodigosError.ERROR_DE_CLAVE_DUPLICADA));
            }
        } catch (PersistenceException ce) {
            UtilidadesLog.error("ERROR ", ce);
            throw new MareException(ce, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS));
        }

        UtilidadesLog.debug("Termino grabarClienteFaltaConstanciaActividad ");
        UtilidadesLog.info("DAOBaseCalculo.grabarClienteFaltaConstancia "
          +"Actividad(Long oidCliente, Periodo periodo):Salida");
    }

    /**
    * Sistema: Belcorp
    * Módulo:  INC
    * Fecha:   04/07/2005
    * @version 1.00
    * Descripcion: Este metodo inserta o actualiza en la entidad 
    * ResultadoRanking los datos recividos por parametro
    *
    * @autor   Sergio Saavedra
    */
    public void grabarResultadosRanking(
        ClienteConcursoBaseCalculoRanking clieConcBaseCalcRank)
        throws MareException {
        UtilidadesLog.info("DAOBaseCalculo.grabarResultadosRanking( "
          +"ClienteConcursoBaseCalculoRanking clieConcBaseCalcRank):Entrada");

        try {
            ResultadosRankingLocalHome home = this.getResultadosRankingLocalHome();
            ResultadosRankingLocal resRank = 
              home.create(clieConcBaseCalcRank.getConcurso().getOidConcurso(),
                    clieConcBaseCalcRank.getPeriodoCalculo().getOidPeriodo(),
                    clieConcBaseCalcRank.getOidCliente(),
                    ConstantesINC.TIPO_RESULTADO_RANKING_ASPIRANTE);

            resRank.setMontoVentas((clieConcBaseCalcRank.getResultado()
                .getMontoVentas() != null)
                ? new Double(clieConcBaseCalcRank.getResultado()
                    .getMontoVentas().toString()) : null);
            resRank.setUnidadesVendidas(clieConcBaseCalcRank.getResultado()
                .getUnidadesVendidas());
            resRank.setNumeroPedidos(clieConcBaseCalcRank.getResultado()
                .getNumeroPedidos());
            resRank.setNumeroRecomendadas(clieConcBaseCalcRank.getResultado()
                .getNumeroRecomendadas());
                
            // Inc DBLG500000588    
            resRank.setDirigidoA(clieConcBaseCalcRank.getConcurso().getDirigidoA());
            resRank.setBaseCalculo(clieConcBaseCalcRank.getConcurso().getBaseCalculo());
            
            UtilidadesLog.info("DAOBaseCalculo.grabarResultadosRanking( "
              +"ClienteConcursoBaseCalculoRanking clieConcBaseCalcRank): "
              +"Salida");
        } catch (PersistenceException fe) {
            UtilidadesLog.error("ERROR ", fe);
            throw new MareException(fe,
                UtilidadesError.armarCodigoError(
                    CodigosError.ERROR_DE_CLAVE_DUPLICADA));
        } catch (Exception ex) {
            UtilidadesLog.error("ERROR ", ex);
            throw new MareException(ex,
                UtilidadesError.armarCodigoError(
                    CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS));
        }
    }

    /**
     *
     * Sistema: Belcorp
     * Módulo:  INC
     * Fecha:   05/07/2005
     * @version 1.00
     * Descripcion: Este metodo suma la cantidad recomendas de la consultora 
     * pasada por parametro que en el tiempo comprendido entre los periodoDesde
     * y periodoHasta hayan pasado al menos pedido. Ademas si el objeto 
     * uniAdmGer es distinto de null hay que filtrar que las solicitudes
     * pertenezcan a algunas de las unidades administrativas de uniAdmGer.
     * 
     * 
     * @autor   Sergio Saavedra
     */
    public BigDecimal calcularRecomendadas(Long oidCliente,
        Periodo periodoDesde, Periodo periodoHasta,
        UnidadesAdministrativasGerenciadas uniAdmGer) throws MareException {
        UtilidadesLog.info("DAOBaseCalculo.calcularRecomendadas(Long  "
          +"oidCliente, Periodo periodoDesde, Periodo periodoHasta, "
          +"UnidadesAdministrativasGerenciadas uniAdmGer):Salida");

        RecordSet rs = new RecordSet();
        StringBuffer query = new StringBuffer();
        BelcorpService bs = null;

        DTOMontoUnidades resu = new DTOMontoUnidades();

        try {
            bs = BelcorpService.getInstance();
        } catch (MareMiiServiceNotFoundException e) {
            UtilidadesLog.error("ERROR ", e);

            int error = UtilidadesError.armarCodigoError(
              CodigosError.ERROR_AL_PEDIR_UN_SERVICIO_MARE);
            throw new MareException(e, error);
        }

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String strFechaDesde = sdf.format(periodoDesde.getFechaDesde());
        String strFechaHasta = sdf.format(periodoHasta.getFechaHasta());

        query.append("SELECT COUNT (distinct cvin.CLIE_OID_CLIE_VNDO) count  ");
        query.append("FROM mae_clien_vincu cvin, ");
        query.append("mae_tipo_vincu tvin, ");
        query.append("cra_perio p1, ");
        query.append("ped_solic_cabec psc ");

        if (uniAdmGer != null) {
            query.append(", zon_terri_admin terr, ");
            query.append("zon_secci sec, ");
            query.append("zon_zona zon, ");
            query.append("zon_regio reg, ");
            query.append("zon_sub_geren_venta sub ");
        }

        query.append(" WHERE cvin.clie_oid_clie_vnte = " +
            oidCliente.longValue());
        query.append(" AND tvin.pais_oid_pais = " +
            periodoDesde.getOidPais().longValue());
        query.append(" AND tvin.ind_reco = 1 ");
        query.append(" AND cvin.tivc_oid_tipo_vinc = tvin.oid_tipo_vinc ");
        query.append(" AND cvin.fec_desd >= TO_DATE('" + strFechaDesde +
            "', 'YYYY-MM-DD') ");
        query.append(" AND cvin.fec_desd <= TO_DATE('" + strFechaHasta +
            "', 'YYYY-MM-DD') ");
        query.append(" AND psc.clie_oid_clie = cvin.clie_oid_clie_vndo  ");
        query.append(" AND psc.fec_fact is not null ");
        query.append(" AND psc.ind_oc = 1 ");

        //-- Filtros de solicitudes dentro de los periodos del concurso 
        query.append(" AND psc.perd_oid_peri = p1.oid_peri ");
        query.append(" AND p1.fec_inic >= TO_DATE('" + strFechaDesde +
            "', 'YYYY-MM-DD') ");
        query.append(" AND p1.fec_fina <= TO_DATE('" + strFechaHasta +
            "', 'YYYY-MM-DD') ");

        query.append(" AND p1.pais_oid_pais = " +
            periodoDesde.getOidPais().longValue());
        query.append(" AND p1.marc_oid_marc = " +
            periodoDesde.getOidMarca().longValue());
        query.append(" AND p1.cana_oid_cana = " +
            periodoDesde.getOidCanal().longValue());

        if (uniAdmGer != null) {
            query.append(" AND psc.ztad_oid_terr_admi = terr.oid_terr_admi ");
            query.append(" AND terr.zscc_oid_secc = sec.oid_secc ");
            query.append(" AND sec.zzon_oid_zona = zon.oid_zona ");
            query.append(" AND zon.zorg_oid_regi = reg.oid_regi ");
            query.append(" AND reg.zsgv_oid_subg_vent = sub.oid_subg_vent ");

            query.append(" AND ( ");

            //-- zonificacion -- 
            if (uniAdmGer.getSubGerencias() != null) {
                query.append("sub.OID_SUBG_VENT " +
                    generoLike(uniAdmGer.getSubGerencias()));
            } else if (uniAdmGer.getRegiones() != null) {
                query.append("reg.OID_REGI " +
                    generoLike(uniAdmGer.getRegiones()));
            } else if (uniAdmGer.getZonas() != null) {
                query.append("zon.OID_ZONA " +
                    generoLike(uniAdmGer.getZonas()));
            } else if (uniAdmGer.getSecciones() != null) {
                query.append("sec.OID_SECC " +
                    generoLike(uniAdmGer.getSecciones()));
            }

            query.append(" ) ");
        }

        try {
            rs = bs.dbService.executeStaticQuery(query.toString());
            UtilidadesLog.debug("resultado query: " + rs);
        } catch (Exception e) {
            UtilidadesLog.error("ERROR ", e);

            int error = UtilidadesError.armarCodigoError(
              CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS);
            throw new MareException(e, error);
        }

        Object o = rs.getValueAt(0, "count");
        UtilidadesLog.info("DAOBaseCalculo.calcularRecomendadas(Long "
          +"oidCliente, Periodo periodoDesde, Periodo periodoHasta, "
          +"UnidadesAdministrativasGerenciadas uniAdmGer):Salida");

        return new BigDecimal(((BigDecimal) o).toString());
    }
    
    
    public RecordSet obtenerSolicitudesFacturadas(Long oidCliente, Long oidPeriodoIni, Long oidPeriodoFin, Boolean indAnulacion,
                                                       Boolean indDevolucion) throws MareException {
                                                       
        UtilidadesLog.info("DAOBaseCalculo.obtenerSolicitudesFacturadas(Long oidCliente, Long oidPeriodoIni, Long oidPeriodoFin, Boolean indAnulacion Boolean indDevolucion):Entrada");
        //Se obtienen las solicitudes consolidadas para un cliente, que sean orden de compra, 
        //que sean o no anulaciones o devoluciones dependiendo de los indicadores de anulación 
        //y devolución de los parámetros de calificación del concurso         
        BelcorpService bs;
        RecordSet rs;
        String codigoError;
        boolean primerRegistro = true;

        StringBuffer query = new StringBuffer();

        //jrivas 13/7/2005
        //19754
        //query.append("SELECT A.OID_SOLI_CABE, A.CLIE_OID_CLIE ");
        query.append(" SELECT A.OID_SOLI_CABE, A.CLIE_OID_CLIE, A.ZZON_OID_ZONA, A.PERD_OID_PERI, ");
        query.append(" A.PAIS_OID_PAIS, B.MARC_OID_MARC,B.CANA_OID_CANA, A.IND_OC, SUB.ACCE_OID_ACCE ");
        query.append("FROM PED_SOLIC_CABEC A, CRA_PERIO INICIO, CRA_PERIO FIN, ");
        query.append("SEG_SUBAC SUB, ");
        query.append("CRA_PERIO B ");

        if (indAnulacion == null) {
            indAnulacion = Boolean.FALSE;
        }

        if (indDevolucion == null) {
            indDevolucion = Boolean.FALSE;
        }

        if (!indAnulacion.booleanValue() || !indDevolucion.booleanValue()) {
            query.append(" , PED_TIPO_SOLIC_PAIS C ");
            query.append(" , PED_TIPO_SOLIC D ");
        }

        query.append(" WHERE A.FEC_FACT IS NOT NULL ");
        
        if(oidCliente!=null) {
            query.append(" AND A.CLIE_OID_CLIE = " + oidCliente);
        }
        
        query.append(" AND A.SBAC_OID_SBAC = SUB.OID_SBAC ");
        query.append(" AND A.PERD_OID_PERI = B.OID_PERI ");
        query.append(" AND FIN.OID_PERI = " + oidPeriodoFin);
        query.append(" AND INICIO.OID_PERI = " + oidPeriodoIni);
        query.append(" AND B.FEC_INIC >= INICIO.FEC_INIC ");
        query.append(" AND B.FEC_FINA <= FIN.FEC_FINA ");
        query.append(" AND A.IND_OC = " + ConstantesINC.IND_ACTIVO);
        query.append(" AND A.IND_TS_NO_CONSO = " + ConstantesINC.IND_ACTIVO);

        if ((!indAnulacion.booleanValue()) || (!indDevolucion.booleanValue())) {
            query.append(" AND C.OID_TIPO_SOLI_PAIS = A.TSPA_OID_TIPO_SOLI_PAIS ");
        }

        if ((!indAnulacion.booleanValue()) || (!indDevolucion.booleanValue())) {
            query.append(" AND D.OID_TIPO_SOLI = C.TSOL_OID_TIPO_SOLI ");
        }

        if (!indAnulacion.booleanValue()) {
            query.append(" AND D.IND_ANUL = " + ConstantesINC.IND_INACTIVO);
        }

        if (!indDevolucion.booleanValue()) {
            query.append(" AND D.IND_DEVO = " + ConstantesINC.IND_INACTIVO);
        }

        try {
            bs = BelcorpService.getInstance();
            rs = bs.dbService.executeStaticQuery(query.toString());
        } catch (MareMiiServiceNotFoundException e) {
            UtilidadesLog.error("ERROR ", e);
            codigoError = CodigosError.ERROR_AL_PEDIR_UN_SERVICIO_MARE;
            UtilidadesLog.error(e); //ver si colocarlo 
            throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));
        } catch (Exception e) {
            UtilidadesLog.error("ERROR ", e);
            codigoError = CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS;
            throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));
        }

        if (rs.esVacio()) {            
            UtilidadesLog.info("DAOBaseCalculo.obtenerSolicitudesFacturadas(Long oidCliente, Long oidPeriodoIni, Long oidPeriodoFin, Boolean indAnulacion Boolean indDevolucion):Salida");
            return null;
        } else {
            UtilidadesLog.info("DAOBaseCalculo.obtenerSolicitudesFacturadas(Long oidCliente, Long oidPeriodoIni, Long oidPeriodoFin, Boolean indAnulacion Boolean indDevolucion):Salida");
            return rs;
        }
    }   
    
    private ClienteFaltaConstanciaActividadLocalHome getClienteFaltaConstanciaActividadLocalHome() {
            return new ClienteFaltaConstanciaActividadLocalHome();
    }

    private ResultadosRankingLocalHome getResultadosRankingLocalHome() {
            return new ResultadosRankingLocalHome();
    }

    
}
