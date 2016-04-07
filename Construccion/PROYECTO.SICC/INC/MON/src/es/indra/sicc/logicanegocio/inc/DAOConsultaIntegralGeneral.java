package es.indra.sicc.logicanegocio.inc;

import es.indra.mare.common.exception.MareException;
import es.indra.mare.common.mii.services.jdbcservice.RecordSet;
import es.indra.sicc.logicanegocio.seg.ConstantesSEG;
import es.indra.sicc.dtos.inc.DTOCabeceraConsultaIntegral;
import es.indra.sicc.util.DTOSalida;
import es.indra.sicc.util.BelcorpService;
import es.indra.sicc.util.CodigosError;
import es.indra.sicc.util.UtilidadesError;
import es.indra.sicc.util.UtilidadesLog;
import java.math.BigDecimal;
import es.indra.sicc.logicanegocio.inc.ErroresDeNegocio;
import es.indra.mare.common.mii.MareMiiServiceNotFoundException;
import java.util.ArrayList;

public class DAOConsultaIntegralGeneral {
    public DAOConsultaIntegralGeneral() { }

	/**
    * Sistema:     Belcorp
    * Modulo:      INC
    * Fecha:       25/11/2005
    * @version     1.0
    * @autor       Cristian Valenzuela
    */

	public void obtenerDatosCliente(DTOCabeceraConsultaIntegral dto) 
		throws MareException{       
		UtilidadesLog.info("DAOConsultaIntegralGeneral.obtenerDatosCliente(DTOCabeceraConsultaIntegral dto): Entrada");
		StringBuffer sb1 = new StringBuffer();
		
		sb1.append(" SELECT MAEC.OID_CLIE,  ");
		sb1.append(" MAEC.VAL_NOM1||' '||MAEC.VAL_NOM2||' '||MAEC.VAL_APE1||' '||MAEC.VAL_APE2 NOMBRES_APELLIDOS  ");
		sb1.append(" FROM MAE_CLIEN MAEC  ");
		sb1.append(" WHERE MAEC.COD_CLIE = '" + dto.getCodigoCliente() + "'");

		RecordSet rs = new RecordSet();
	    BelcorpService belcorpService;    
		 
		try {
			belcorpService = BelcorpService.getInstance();
			rs = belcorpService.dbService.executeStaticQuery(sb1.toString());
	    }
		catch (Exception e) {
			UtilidadesLog.error("ERROR ", e);
	        throw new MareException(e, 
		    UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS));
	    }

		if(!rs.esVacio()) {			
			String nomApeTemp = (String)rs.getValueAt(0, "NOMBRES_APELLIDOS");
			BigDecimal oidClienTemp = (BigDecimal)rs.getValueAt(0, "OID_CLIE");

			if(nomApeTemp!=null) dto.setNombreApellidos(nomApeTemp);
			if(oidClienTemp!=null) dto.setOidCliente(new Long(oidClienTemp.longValue()));
		}
		else {
			throw new MareException(null, new Exception(), 
			UtilidadesError.armarCodigoError(ConstantesSEG.MODULO_MAE, "", 
			es.indra.sicc.logicanegocio.mae.ErroresDeNegocio.MAE_0024));
		}
        
		UtilidadesLog.info("DAOConsultaIntegralGeneral.obtenerDatosCliente(DTOCabeceraConsultaIntegral dto): Salida");
	}

	/**
    * Sistema:     Belcorp
    * Modulo:      INC
    * Fecha:       25/11/2005
    * @version     1.0
    * @autor       Cristian Valenzuela
    */

	public void obtenerDatosConcurso(DTOCabeceraConsultaIntegral dto) 
		throws MareException{       
		UtilidadesLog.info("DAOConsultaIntegralGeneral.obtenerDatosConcurso(DTOCabeceraConsultaIntegral dto): Entrada");
		StringBuffer sb1 = new StringBuffer();

		sb1.append(" SELECT CPG.OID_PARA_GRAL, CPG.VAL_NOMB, PERINI.OID_PERI OID_PER_INI,  ");
		sb1.append(" CORINI.COD_PERI COD_PER_INI,PERFIN.OID_PERI OID_PER_FIN,  ");
		sb1.append(" CORFIN.COD_PERI COD_PER_FIN, PLA.VAL_FASE_CALI, CPG.BCAL_OID_BASE_CALC,  ");
		sb1.append(" PLA.IND_MULT  ");
		sb1.append(" FROM INC_CONCU_PARAM_GENER CPG,  ");
		sb1.append(" CRA_PERIO PERINI,  ");
		sb1.append(" SEG_PERIO_CORPO CORINI,  ");
		sb1.append(" CRA_PERIO PERFIN,  ");
		sb1.append(" SEG_PERIO_CORPO CORFIN,  ");
		sb1.append(" INC_PLANT_CONCU PLA  ");
		sb1.append(" WHERE CPG.PERD_OID_PERI_DESD = PERINI.OID_PERI  ");
		sb1.append(" AND CPG.PERD_OID_PERI_HAST = PERFIN.OID_PERI  ");
		sb1.append(" AND PERINI.PERI_OID_PERI = CORINI.OID_PERI  ");
		sb1.append(" AND PERFIN.PERI_OID_PERI = CORFIN.OID_PERI  ");
		sb1.append(" AND CPG.PLC2_OID_PLAN_CONC = PLA.OID_PLAN_CONC  ");
		sb1.append(" AND CPG.NUM_CONC = '" + dto.getNumeroConcurso() + "'");

		RecordSet rs = new RecordSet();
	    BelcorpService belcorpService;    
		 
		try {
			belcorpService = BelcorpService.getInstance();
			rs = belcorpService.dbService.executeStaticQuery(sb1.toString());
	    }
		catch (Exception e) {
			UtilidadesLog.error("ERROR ", e);
	        throw new MareException(e, 
		    UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS));
	    }

		if(!rs.esVacio()) {			
			BigDecimal oidConcurso = (BigDecimal)rs.getValueAt(0, "OID_PARA_GRAL");
			String nombre = (String)rs.getValueAt(0, "VAL_NOMB");
			BigDecimal oidPeriodoIni = (BigDecimal)rs.getValueAt(0, "OID_PER_INI");
			String codPeriodoIni = (String)rs.getValueAt(0, "COD_PER_INI");
			BigDecimal oidPeriodoFin = (BigDecimal)rs.getValueAt(0, "OID_PER_FIN");
			String codPeriodoFin = (String)rs.getValueAt(0, "COD_PER_FIN");
			BigDecimal faseCalificacion = (BigDecimal)rs.getValueAt(0, "VAL_FASE_CALI");
			BigDecimal oidBaseCalculo = (BigDecimal)rs.getValueAt(0, "BCAL_OID_BASE_CALC");
			BigDecimal multinivel = (BigDecimal)rs.getValueAt(0, "IND_MULT");

			if(oidConcurso!=null) dto.setOidConcurso(new Long(oidConcurso.longValue()));
			if(nombre!=null) dto.setNombreConcurso(nombre);
			if(oidPeriodoIni!=null) dto.setOidPeriodoInicial(new Long(oidPeriodoIni.longValue()));
			if(codPeriodoIni!=null) dto.setPeriodoInicial(codPeriodoIni);
			if(oidPeriodoFin!=null) dto.setOidPeriodoFinal(new Long(oidPeriodoFin.longValue()));
			if(codPeriodoFin!=null) dto.setPeriodoFinal(codPeriodoFin);

			if(faseCalificacion!=null) {
				if(faseCalificacion.longValue()==1) 
					dto.setFaseCalificacion(new Boolean(true));
				else 
					dto.setFaseCalificacion(new Boolean(false));
			}

			if(oidBaseCalculo!=null) dto.setOidBaseCalculo(new Long(oidBaseCalculo.longValue()));	
			
		    if(multinivel!=null) {
				if(multinivel.longValue()==1) 
					dto.setMultinivel(new Boolean(true));
				else
					dto.setMultinivel(new Boolean(false));
			}			
		}
		else {
			throw new MareException(null, new Exception(), 
			UtilidadesError.armarCodigoError(ConstantesSEG.MODULO_INC, "", 
			ErroresDeNegocio.INC_0020));
		}
        
		UtilidadesLog.info("DAOConsultaIntegralGeneral.obtenerDatosConcurso(DTOCabeceraConsultaIntegral dto): Salida");
	}
    
    /**
     * 
     * @date 20/09/2006
     * @throws es.indra.mare.common.exception.MareException
     * @return 
     * @param dto
     * @author pperanzola
     */
     public DTOSalida obtenerConcursosBusquedaGeneral_perf(DTOCabeceraConsultaIntegral dto)
         throws MareException
     {
         UtilidadesLog.info("DAOConsultaIntegralGeneral.obtenerConcursosBusquedaGeneral_perf(DTOCabeceraConsultaIntegral dto): Entrada");
         CadenaFiltro cadFiltroLocal = new CadenaFiltro();
         GestorConsultasIntegrales gestor = new GestorConsultasIntegrales();
         DTOSalida dtoSalida = new DTOSalida();
         StringBuffer sb1 = new StringBuffer();
         
             UtilidadesLog.info("DTOCabeceraConsultaIntegral: " + dto);
             //Agregado por Cristian Valenzuela - 21/06/2006
             sb1.append(gestor.getQueryInicioPaginado());    
             //Fin - Agregado por Cristian Valenzuela - 21/06/2006
             sb1.append(" SELECT DISTINCT cpg.oid_para_gral ");
             sb1.append(" ,cpg.num_conc ");
             sb1.append(" ,cpg.val_nomb ");
             sb1.append(" ,perini.oid_peri oid_peri_ini ");
             sb1.append(" ,(SELECT cod_peri FROM seg_perio_corpo corini WHERE perini.peri_oid_peri = corini.oid_peri AND perini.pais_oid_pais =" + dto.getOidPais() + ") cod_peri_ini ");
             sb1.append(" ,perfin.oid_peri oid_peri_fin  ");
             sb1.append(" ,(SELECT cod_peri FROM seg_perio_corpo corfin WHERE  perfin.peri_oid_peri = corfin.oid_peri AND perfin.pais_oid_pais ="  + dto.getOidPais() + ")cod_peri_fin ");
             sb1.append(" ,(SELECT des_marc FROM seg_marca mar WHERE cpg.marc_oid_marc = mar.oid_marc) des_marc ");
             sb1.append("  ,pla.val_fase_cali ");
             sb1.append("  ,cpg.bcal_oid_base_calc, ");
             sb1.append(" pla.ind_mult, ");
             sb1.append(" DECODE   (veco.vico_oid_vige_conc, 3, ");
             sb1.append("           Pq_Apl_Aux.Valor_Gen_I18n_Sicc(" + dto.getOidIdioma() + ", 1,  'INC_VIGEN_CONCU'), ");
             sb1.append("           Pq_Apl_Aux.Valor_Gen_I18n_Sicc(" + dto.getOidIdioma() + ", veco.vico_oid_vige_conc,  'INC_VIGEN_CONCU') ");
             sb1.append("          ) estado_concurso, ");
             sb1.append(" cpg.plc2_oid_plan_conc, ");
             // vbongiov -- INC 014 -- 20/10/2008
             sb1.append(" CASE WHEN prem.PERD_OID_PERI IS NOT NULL then ");
             sb1.append(" (SELECT pcor.cod_peri FROM seg_perio_corpo pcor, cra_perio per ");
             sb1.append(" WHERE pcor.oid_peri = per.peri_oid_peri  AND per.oid_peri =prem.PERD_OID_PERI) else ");
             sb1.append(" (CASE WHEN (cpg.BCAL_OID_BASE_CALC = 4 and cons.IND_PREM_CAMP_EFEC = 1) ");
             sb1.append(" then  (SELECT pcor.cod_peri FROM seg_perio_corpo pcor, cra_perio per ");
             sb1.append(" WHERE pcor.oid_peri = per.peri_oid_peri  AND per.oid_peri =cons.PERD_OID_PERI_INIC_EVAL) ELSE '' end) end CAMP_INCICIO_DESP, ");
             sb1.append(" CASE WHEN prem.PERD_OID_PERI IS NOT NULL then ");
             sb1.append(" (SELECT pcor.cod_peri FROM seg_perio_corpo pcor, cra_perio per ");
             sb1.append(" WHERE pcor.oid_peri = per.peri_oid_peri  AND per.oid_peri = prem.PERD_OID_PERI) else ");
             sb1.append(" (CASE WHEN (cpg.BCAL_OID_BASE_CALC = 4 and cons.IND_PREM_CAMP_EFEC = 0) ");
             sb1.append(" then 'BUSCAR' ELSE '' end) end CAMP_FIN_DESP, ");
             sb1.append(" CASE WHEN prem.PERD_OID_PERI IS NOT NULL then 'BUSCAR_PRE' else ");
             sb1.append(" (CASE WHEN (cpg.BCAL_OID_BASE_CALC = 4 and cons.IND_PREM_CAMP_EFEC = 0) ");
             sb1.append(" then 'BUSCAR' ELSE '' end) end CAMP_MAX_REC, ");
             sb1.append(" cpg.PERD_OID_PERI_HAST, ");
             sb1.append(" cons.VAL_PERI_EVAL, ");
             sb1.append(" prem.PERD_OID_PERI, ");
             sb1.append(" rec_prem.VAL_NUME_PERI_PARA_RECL ");
             sb1.append(" FROM ");
             sb1.append("  (SELECT copa_oid_para_gral FROM INC_SOLIC_CONCU_PUNTA scp WHERE scp.clie_oid_clie = " + dto.getOidCliente() + " ");
             sb1.append(" AND scp.clie_oid_clie_gere IS NULL  ");
             // vbongiov -- 18/10/2006 -- DBLG500001231
             sb1.append(" UNION  ");
             sb1.append("  SELECT copa_oid_para_gral FROM INC_DESCA des WHERE des.clie_oid_clie = " + dto.getOidCliente() + " ");
             sb1.append("  ) scp,  ");
             sb1.append(" INC_CONCU_PARAM_GENER cpg ");
             sb1.append("  ,CRA_PERIO perini ");
             sb1.append("  ,CRA_PERIO perfin ");
             sb1.append("  ,inc_plant_concu pla ");
             sb1.append("  ,INC_VERSI_CONCU veco ");
             sb1.append("  ,INC_PARAM_GENER_PREMI prem ");
             sb1.append("  ,INC_CONCU_PARAM_CONSU cons ");
             sb1.append("  ,INC_RECLA_PREMI rec_prem ");
             sb1.append(" WHERE scp.copa_oid_para_gral = cpg.oid_para_gral ");
             sb1.append(" AND cpg.perd_oid_peri_desd = perini.oid_peri ");
             sb1.append(" AND cpg.perd_oid_peri_hast = perfin.oid_peri ");
             sb1.append(" AND cpg.plc2_oid_plan_conc = pla.oid_plan_conc(+) ");
             sb1.append(" AND veco.copa_oid_para_gral(+) =    cpg.oid_para_gral ");
             sb1.append(" AND (  veco.vico_oid_vige_conc(+) <> 4 AND veco.vico_oid_vige_conc(+) <> 5 ) ");
             sb1.append(" and cpg.OID_PARA_GRAL = prem.COPA_OID_PARA_GRAL ");
             sb1.append(" and cpg.OID_PARA_GRAL = cons.COPA_OID_PARA_GRAL(+) ");
             sb1.append(" and rec_prem.PAIS_OID_PAIS = perini.PAIS_OID_PAIS ");
             sb1.append(" and rec_prem.MARC_OID_MARC = perini.MARC_OID_MARC ");
             sb1.append(" and rec_prem.CANA_OID_CANA = perini.CANA_OID_CANA ");
             cadFiltroLocal.concatenar(sb1);
             if(dto.getNumeroConcurso() != null)
             {
                 cadFiltroLocal.concatenar(new StringBuffer(" AND CPG.NUM_CONC <= ? "));
                 cadFiltroLocal.concatenarParametro(dto.getNumeroConcurso());
             }
             if(dto.getOidTipoConcurso() != null)
             {
                 cadFiltroLocal.concatenar(new StringBuffer(" AND cpg.COIV_OID_CONC_IVR = ? "));
                 cadFiltroLocal.concatenarParametro(dto.getOidTipoConcurso());
             }
             if(dto.getOidEstadoConcurso() != null)
             {
                 cadFiltroLocal.concatenar(new StringBuffer(" AND veco.vico_oid_vige_conc = ? "));
                 cadFiltroLocal.concatenarParametro(dto.getOidEstadoConcurso());
             }
             cadFiltroLocal.concatenar(gestor.getCadenaFiltroUnidadAdmin(dto));
             cadFiltroLocal.concatenar(new StringBuffer(" ORDER BY ESTADO_CONCURSO DESC, CPG.NUM_CONC DESC "));
             cadFiltroLocal.concatenar(new StringBuffer(gestor.getQueryFinPaginado(dto)));
             RecordSet rs = new RecordSet();
             ArrayList campFinDespacho = new ArrayList();
             ArrayList campMaxReclamo = new ArrayList();
             try
             {
                 BelcorpService belcorpService = BelcorpService.getInstance();
                 rs = belcorpService.dbService.executePreparedQuery(cadFiltroLocal.getCadena().toString(), cadFiltroLocal.getParamFiltro());
             }
             catch(Exception e)
             {
                 UtilidadesLog.error("ERROR ", e);
                 throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS));
             }
             if(rs.esVacio())
             {
                 String codigoError = CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE;
                 throw new MareException(new Exception(), UtilidadesError.armarCodigoError(codigoError));
             }
             
            try{
                 int cant = rs.getRowCount();
                 for(int i = 0; i < cant; i++)
                 {
                     if("BUSCAR".equals((String)rs.getValueAt(i, "CAMP_FIN_DESP")) && (BigDecimal)rs.getValueAt(i, "PERD_OID_PERI_HAST") != null && (BigDecimal)rs.getValueAt(i, "VAL_PERI_EVAL") != null)
                     {
                         campFinDespacho = obtenerPeriodoMasDelta(Long.valueOf(((BigDecimal)rs.getValueAt(i, "PERD_OID_PERI_HAST")).toString()), Long.valueOf(((BigDecimal)rs.getValueAt(i, "VAL_PERI_EVAL")).toString()).intValue());
                         
                         if(campFinDespacho.size()!=0){
                             rs.setValueAt((String)campFinDespacho.get(1), i, 15);
                         }else {
                             rs.setValueAt("", i, 15);
                         }
                         
                         campMaxReclamo = obtenerPeriodoMasDelta((Long)campFinDespacho.get(0), Long.valueOf(((BigDecimal)rs.getValueAt(i, "VAL_NUME_PERI_PARA_RECL")).toString()).intValue());
                         
                         if(campMaxReclamo.size()!=0){
                             rs.setValueAt((String)campMaxReclamo.get(1), i, 16);
                         }else {
                             rs.setValueAt("", i, 16);
                         }
                         
                         continue;
                     }
                     if("BUSCAR_PRE".equals((String)rs.getValueAt(i, "CAMP_MAX_REC")))
                     {
                         campMaxReclamo = obtenerPeriodoMasDelta(Long.valueOf(((BigDecimal)rs.getValueAt(i, "PERD_OID_PERI")).toString()), Long.valueOf(((BigDecimal)rs.getValueAt(i, "VAL_NUME_PERI_PARA_RECL")).toString()).intValue());
                         
                         if(campMaxReclamo.size()!=0){
                             rs.setValueAt((String)campMaxReclamo.get(1), i, 16);
                         } else {
                             rs.setValueAt("", i, 16);
                         }                        
                     }
                 }
     
                 UtilidadesLog.debug("rs: " + rs);
                 dtoSalida.setResultado(rs);
                 
             } catch(Exception e) {
                 e.printStackTrace();
                 throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS));
             }
             UtilidadesLog.info("DAOConsultaIntegralGeneral.obtenerConcursosBusquedaGeneral_perf(DTOCabeceraConsultaIntegral dto): Salida");
             return dtoSalida;
     }
     
     // vbongiov -- INC 014 -- 20/10/2008
     public ArrayList obtenerPeriodoMasDelta(Long oidPeriodo, int delta)
         throws MareException
     {
         UtilidadesLog.info("DAOConsultaIntegralGeneral.obtenerPeriodoMasDelta(Long oidPeriodo, int delta):Entrada");
         RecordSet respuesta = new RecordSet();
         StringBuffer query = new StringBuffer();
         ArrayList periodoMasDelta = new ArrayList();
         BelcorpService bs;
         try
         {
             bs = BelcorpService.getInstance();
         }
         catch(MareMiiServiceNotFoundException e)
         {
             UtilidadesLog.error(e);
             throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_PEDIR_UN_SERVICIO_MARE));
         }
         try
         {
             query.append(" SELECT B.OID_PERI, pcor.COD_PERI");
             query.append(" FROM cra_perio A, cra_perio B, seg_perio_corpo pcor ");
             query.append(" WHERE A.oid_peri = " + oidPeriodo);
             query.append(" AND B.pais_oid_pais = A.pais_oid_pais ");
             query.append(" AND B.marc_oid_marc = A.marc_oid_marc ");
             query.append(" AND B.cana_oid_cana = A.cana_oid_cana ");
             query.append(" AND B.fec_inic >= A.fec_inic ");
             query.append(" AND pcor.oid_peri = B.peri_oid_peri ");
             query.append(" ORDER BY B.fec_inic ");
             respuesta = bs.dbService.executeStaticQuery(query.toString());
         }
         catch(Exception e)
         {
             UtilidadesLog.error(e);
             throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS));
         }
         int cant = respuesta.getRowCount();
         for(int i = 0; i < cant; i++)
         {
             if(i == delta)
             {
                 periodoMasDelta.add(Long.valueOf(((BigDecimal)respuesta.getValueAt(i, "OID_PERI")).toString()));
                 periodoMasDelta.add((String)respuesta.getValueAt(i, "COD_PERI"));
                 UtilidadesLog.info("DAOConsultaIntegralGeneral.obtenerPeriodoMasDelta(Long oidPeriodo, int delta):Salida");
                 return periodoMasDelta;
             }
         }

         return periodoMasDelta;
     }
     
     // vbongiov -- INC 014 -- 20/10/2008
     public RecordSet consultarDetallePremiosAsociadosNivel(DTOCabeceraConsultaIntegral dtoe)
         throws MareException
     {
         UtilidadesLog.info("DAOConsultaIntegralGeneral.consultarDetallePremiosAsociadosNivel(DTOBelcorp DTOE):Entrada");
         StringBuffer query = new StringBuffer();
         RecordSet rs = new RecordSet();
         BelcorpService belcorpService = null;
         query.append(" SELECT * FROM ( ");
         query.append(" SELECT  PNP.OID_PARA_NIVE_PREM, PNP.NUM_NIVE, ");         
         query.append(" DECODE(PGP.TPRM_OID_TIPO_PION," + ConstantesINC.TIPO_PREMIACION_BOLSA_PREMIOS + ", PNP.NUM_CANT_FIJA_PUNT, " + ConstantesINC.TIPO_PREMIACION_POR_NIVELES + ",PNP.NUM_CANT_INIC_PUNT) PUNTOS_EXIGIDOS, ");
         query.append(" i18n.VAL_I18N TIPO_PREMIO, LPA.NUM_PREM, MPR.COD_SAP, ARL.COD_VENT_FICT, i18n1.VAL_I18N DES_CORT, ");
         query.append(" (PRA.NUM_UNID * ARL.NUM_UNID) NUM_UNIDADES, SERVE.DES_CENT_SERV DESC_SERVE,  ");
         query.append(" SERVG.DES_CENT_SERV DESC_SERVG, PGP.IND_PREM_ELEC ");
         query.append(" FROM INC_PARAM_NIVEL_PREMI PNP,  ");
         query.append(" INC_PARAM_GENER_PREMI PGP, ");
         query.append(" INC_PREMI_ARTIC PRA, ");
         query.append(" INC_LOTE_PREMI_ARTIC LPA, ");
         query.append(" INC_ARTIC_LOTE ARL, ");
         query.append(" MAE_PRODU MPR, ");
         query.append(" INC_CENTR_SERVI SERVE, ");
         query.append(" INC_CENTR_SERVI SERVG, ");
         query.append(" v_gen_i18n_sicc i18n, ");
         query.append(" v_gen_i18n_sicc i18n1 ");
         query.append(" WHERE PNP.PAGP_OID_PARA_GENE_PREM = PGP.OID_PARA_GENE_PREM  ");
         query.append(" AND PGP.COPA_OID_PARA_GRAL = " + dtoe.getOidConcurso());
         query.append(" AND PNP.OID_PARA_NIVE_PREM = PRA.PANP_OID_PARA_NIVE_PREM  ");
         query.append(" AND PRA.OID_PREM_ARTI = LPA.PRAR_OID_PREM_ARTI  ");
         query.append(" AND ARL.LOPA_OID_LOTE_PREM_ARTI = LPA.OID_LOTE_PREM_ARTI  ");
         query.append(" AND ARL.PROD_OID_PROD = MPR.OID_PROD  ");
         query.append(" AND SERVE.OID_CENT_SERV(+) = ARL.CESE_OID_CESE_ENTR ");
         query.append(" AND SERVG.OID_CENT_SERV(+) = ARL.CESE_OID_CESE_GARA");
         query.append(" AND PNP.TPRE_OID_TIPO_PREM  = i18n.VAL_OID  ");
         query.append(" AND i18n.idio_oid_idio = " + dtoe.getOidIdioma());
         query.append(" AND i18n.attr_num_atri = 1 ");
         query.append(" AND i18n.attr_enti = 'INC_TIPO_PREMI' ");
         query.append(" AND MPR.OID_PROD = i18n1.VAL_OID  ");
         query.append(" AND i18n1.idio_oid_idio = " + dtoe.getOidIdioma());
         query.append(" AND i18n1.attr_num_atri = 1 ");
         query.append(" AND i18n1.attr_enti = 'MAE_PRODU' ");
         query.append(" UNION ");
         query.append(" SELECT  PNP.OID_PARA_NIVE_PREM, PNP.NUM_NIVE, ");
         query.append(" DECODE(PGP.TPRM_OID_TIPO_PION," + ConstantesINC.TIPO_PREMIACION_BOLSA_PREMIOS + ", PNP.NUM_CANT_FIJA_PUNT, " + ConstantesINC.TIPO_PREMIACION_POR_NIVELES + ",PNP.NUM_CANT_INIC_PUNT) PUNTOS_EXIGIDOS, ");
         query.append(" i18n.VAL_I18N TIPO_PREMIO, IPM.NUM_PREM, NULL COD_SAP,  NULL COD_VENT_FICT, NULL DES_CORT, ");
         query.append(" NULL NUM_UNIDADES, NULL DESC_SERVE,  ");
         query.append(" NULL DESC_SERVG, PGP.IND_PREM_ELEC ");
         query.append(" FROM INC_PARAM_NIVEL_PREMI PNP, ");
         query.append(" INC_PARAM_GENER_PREMI PGP, ");
         query.append(" INC_PREMI_MONET IPM,  ");
         query.append(" v_gen_i18n_sicc i18n ");
         query.append(" WHERE PNP.PAGP_OID_PARA_GENE_PREM = PGP.OID_PARA_GENE_PREM  ");
         query.append(" AND PGP.COPA_OID_PARA_GRAL = " + dtoe.getOidConcurso());
         query.append(" AND PNP.OID_PARA_NIVE_PREM = IPM.PANP_OID_PARA_NIVE_PREM ");
         query.append(" AND PNP.TPRE_OID_TIPO_PREM  = i18n.VAL_OID  ");
         query.append(" AND i18n.idio_oid_idio = " + dtoe.getOidIdioma());
         query.append(" AND i18n.attr_num_atri = 1   ");
         query.append(" AND i18n.attr_enti = 'INC_TIPO_PREMI' ");
         query.append(" UNION ");
         query.append(" SELECT  PNP.OID_PARA_NIVE_PREM, PNP.NUM_NIVE, ");
         query.append(" DECODE(PGP.TPRM_OID_TIPO_PION," + ConstantesINC.TIPO_PREMIACION_BOLSA_PREMIOS + ", PNP.NUM_CANT_FIJA_PUNT, " + ConstantesINC.TIPO_PREMIACION_POR_NIVELES + ",PNP.NUM_CANT_INIC_PUNT) PUNTOS_EXIGIDOS, ");
         query.append(" i18n.VAL_I18N TIPO_PREMIO, IPP.NUM_PREM, NULL COD_SAP,  NULL COD_VENT_FICT, NULL DES_CORT, ");
         query.append(" NULL NUM_UNIDADES, NULL DESC_SERVE,  ");
         query.append(" NULL DESC_SERVG, PGP.IND_PREM_ELEC ");
         query.append(" FROM INC_PARAM_NIVEL_PREMI PNP,  ");
         query.append(" INC_PARAM_GENER_PREMI PGP, ");
         query.append(" INC_PREMI_PUNTO IPP,  ");
         query.append(" v_gen_i18n_sicc i18n  ");
         query.append(" WHERE PNP.PAGP_OID_PARA_GENE_PREM = PGP.OID_PARA_GENE_PREM  ");
         query.append(" AND PGP.COPA_OID_PARA_GRAL = " + dtoe.getOidConcurso());
         query.append(" AND PNP.OID_PARA_NIVE_PREM = IPP.PANP_OID_PARA_NIVE_PREM ");
         query.append(" AND PNP.TPRE_OID_TIPO_PREM  = i18n.VAL_OID  ");
         query.append(" AND i18n.idio_oid_idio = " + dtoe.getOidIdioma());
         query.append(" AND i18n.attr_num_atri = 1 ");
         query.append(" AND i18n.attr_enti = 'INC_TIPO_PREMI' ");
         query.append(" UNION ");
         query.append(" SELECT  PNP.OID_PARA_NIVE_PREM, PNP.NUM_NIVE, ");
         query.append(" DECODE(PGP.TPRM_OID_TIPO_PION," + ConstantesINC.TIPO_PREMIACION_BOLSA_PREMIOS + ", PNP.NUM_CANT_FIJA_PUNT, " + ConstantesINC.TIPO_PREMIACION_POR_NIVELES + ",PNP.NUM_CANT_INIC_PUNT) PUNTOS_EXIGIDOS, ");
         query.append(" i18n.VAL_I18N TIPO_PREMIO, IPD.NUM_PREM, NULL COD_SAP,  NULL COD_VENT_FICT, NULL DES_CORT, ");
         query.append(" NULL NUM_UNIDADES, NULL DESC_SERVE,  ");
         query.append(" NULL DESC_SERVG, PGP.IND_PREM_ELEC ");
         query.append(" FROM INC_PARAM_NIVEL_PREMI PNP,  ");
         query.append(" INC_PARAM_GENER_PREMI PGP, ");
         query.append(" INC_PREMI_DESCU IPD, ");
         query.append(" v_gen_i18n_sicc i18n ");
         query.append(" WHERE PNP.PAGP_OID_PARA_GENE_PREM = PGP.OID_PARA_GENE_PREM  ");
         query.append(" AND PGP.COPA_OID_PARA_GRAL = " + dtoe.getOidConcurso());
         query.append(" AND PNP.OID_PARA_NIVE_PREM = IPD.OID_PARA_NIVE_PREM ");
         query.append(" AND PNP.TPRE_OID_TIPO_PREM  = i18n.VAL_OID  ");
         query.append(" AND i18n.idio_oid_idio = " + dtoe.getOidIdioma());
         query.append(" AND i18n.attr_num_atri = 1 ");
         query.append(" AND i18n.attr_enti = 'INC_TIPO_PREMI' ) ");
         query.append(" ORDER BY  NUM_NIVE, NUM_PREM, COD_SAP  ");
                 
         try
         {
             rs = BelcorpService.getInstance().dbService.executeStaticQuery(query.toString());
         }
         catch(MareException me)
         {
             UtilidadesLog.error("ERROR ", me);
             throw me;
         }
         catch(Exception e)
         {
             UtilidadesLog.error("ERROR ", e);
             throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));

         }
         UtilidadesLog.info("DAOConsultaIntegralGeneral.consultarDetallePremiosAsociadosNivel(DTOBelcorp DTOE):Salida");
         return rs;
     }


	/**
    * Sistema:     Belcorp
    * Modulo:      INC
    * Fecha:       25/11/2005
    * @version     1.0
    * @autor       Cristian Valenzuela
    * Modificado:  Cristian Valenzuela
    * Fecha:       25/05/2006
    * Incidencia:  DBLG500000315
    * Modificado:  Cristian Valenzuela
    * Fecha:       21/06/2006
    * Comentario:  Se modifica la consulta para que sea paginada
    */

	public DTOSalida obtenerConcursosBusquedaGeneral(DTOCabeceraConsultaIntegral dto) 
		throws MareException{       
		UtilidadesLog.info("DAOConsultaIntegralGeneral.obtenerConcursosBusquedaGeneral(DTOCabeceraConsultaIntegral dto): Entrada");
		CadenaFiltro cadFiltroLocal = new CadenaFiltro();
		GestorConsultasIntegrales gestor = new GestorConsultasIntegrales();
		DTOSalida dtoSalida = new DTOSalida();
		StringBuffer sb1 = new StringBuffer();
    
        //Agregado por Cristian Valenzuela - 21/06/2006
		sb1.append(gestor.getQueryInicioPaginado());    
        //Fin - Agregado por Cristian Valenzuela - 21/06/2006
        sb1.append(" SELECT DISTINCT CPG.OID_PARA_GRAL,CPG.NUM_CONC,CPG.VAL_NOMB, PERINI.OID_PERI OID_PERI_INI,  ");
		sb1.append(" CORINI.COD_PERI COD_PERI_INI,PERFIN.OID_PERI OID_PERI_FIN, CORFIN.COD_PERI COD_PERI_FIN,  ");
		sb1.append(" MAR.DES_MARC,PLA.VAL_FASE_CALI, CPG.BCAL_OID_BASE_CALC,PLA.IND_MULT,  ");    
        sb1.append(" DECODE(VECO.VICO_OID_VIGE_CONC,3,( SELECT VIS.val_i18n DESC_VC  ");
        sb1.append(" FROM v_gen_i18n_sicc VIS ");
        sb1.append(" WHERE VIS.attr_enti = 'INC_VIGEN_CONCU'  ");
        sb1.append(" AND VIS.attr_num_atri = 1  ");
        sb1.append(" AND VIS.idio_oid_idio = ? ");
        sb1.append(" AND VIS.val_oid = 1),VISTA.val_i18n) ESTADO_CONCURSO, ");    
        sb1.append(" CPG.PLC2_OID_PLAN_CONC ");
		sb1.append(" FROM INC_SOLIC_CONCU_PUNTA SCP,  ");
		sb1.append(" INC_CONCU_PARAM_GENER CPG,  ");
		sb1.append(" CRA_PERIO PERINI,  ");
		sb1.append(" SEG_PERIO_CORPO CORINI,  ");
		sb1.append(" CRA_PERIO PERFIN,  ");
		sb1.append(" SEG_PERIO_CORPO CORFIN,  ");
		sb1.append(" SEG_MARCA MAR,  ");
		sb1.append(" INC_PLANT_CONCU PLA,  ");
        sb1.append(" INC_VERSI_CONCU VECO, ");
        sb1.append(" v_gen_i18n_sicc VISTA ");    
		sb1.append(" WHERE SCP.COPA_OID_PARA_GRAL = CPG.OID_PARA_GRAL  ");
		sb1.append(" AND CPG.PERD_OID_PERI_DESD = PERINI.OID_PERI  ");
		sb1.append(" AND CPG.PERD_OID_PERI_HAST = PERFIN.OID_PERI  ");
		sb1.append(" AND PERINI.PERI_OID_PERI = CORINI.OID_PERI  ");
		sb1.append(" AND PERFIN.PERI_OID_PERI = CORFIN.OID_PERI  ");
		sb1.append(" AND CPG.MARC_OID_MARC = MAR.OID_MARC  ");		
		sb1.append(" AND CPG.PLC2_OID_PLAN_CONC = PLA.OID_PLAN_CONC  ");    
		sb1.append(" AND SCP.CLIE_OID_CLIE = ? "); 
        sb1.append(" AND SCP.CLIE_OID_CLIE_GERE is null ");
        sb1.append(" AND VECO.COPA_OID_PARA_GRAL(+) = CPG.OID_PARA_GRAL  ");
        sb1.append(" AND VISTA.attr_enti (+) = 'INC_VIGEN_CONCU'  ");
        sb1.append(" AND VISTA.attr_num_atri (+) = 1  ");
        sb1.append(" AND VISTA.idio_oid_idio (+)= ?  ");
        sb1.append(" AND VISTA.val_oid (+)= VECO.VICO_OID_VIGE_CONC ");
        sb1.append(" AND (VECO.VICO_OID_VIGE_CONC <> 4 AND VECO.VICO_OID_VIGE_CONC <> 5) ");    
          
        cadFiltroLocal.concatenar(sb1);
        cadFiltroLocal.concatenarParametro(dto.getOidIdioma());    
        cadFiltroLocal.concatenarParametro(dto.getOidCliente());        
        cadFiltroLocal.concatenarParametro(dto.getOidIdioma());    
        
        if(dto.getNumeroConcurso()!=null) {
            cadFiltroLocal.concatenar(new StringBuffer(" AND CPG.NUM_CONC <= ? "));            
            cadFiltroLocal.concatenarParametro(dto.getNumeroConcurso());        
        }		
		
		cadFiltroLocal.concatenar(gestor.getCadenaFiltroUnidadAdmin(dto));
		cadFiltroLocal.concatenar(new StringBuffer(" ORDER BY ESTADO_CONCURSO DESC, CPG.NUM_CONC DESC "));
        //Agregado por Cristian Valenzuela - 21/06/2006
        cadFiltroLocal.concatenar(new StringBuffer(gestor.getQueryFinPaginado(dto)));    
        //Fin - Agregado por Cristian Valenzuela - 21/06/2006    

		RecordSet rs = new RecordSet();
        BelcorpService belcorpService;    
		 
		try {
			belcorpService = BelcorpService.getInstance();
			rs = belcorpService.dbService.executePreparedQuery(cadFiltroLocal.getCadena().toString(),
			cadFiltroLocal.getParamFiltro());
        }
		catch (Exception e) {
            UtilidadesLog.error("ERROR ", e);
            throw new MareException(e, 
            UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS));
        }
        
        if(rs.esVacio()) {
            String codigoError = CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE;
            throw new MareException(new Exception(), UtilidadesError.armarCodigoError(codigoError));            
        }

		dtoSalida.setResultado(rs);        
		UtilidadesLog.info("DAOConsultaIntegralGeneral.obtenerConcursosBusquedaGeneral(DTOCabeceraConsultaIntegral dto): Salida");
		return dtoSalida;
	}

	/**
    * Sistema:     Belcorp
    * Modulo:      INC
    * Fecha:       25/11/2005
    * @version     1.0
    * @autor       Cristian Valenzuela
    */

	public RecordSet consultarDetallePremiosProcesadosGral(DTOCabeceraConsultaIntegral dto) 
		throws MareException{       
		UtilidadesLog.info("DAOConsultaIntegralGeneral.consultarDetallePremiosProcesadosGral(DTOCabeceraConsultaIntegral dto): Entrada");
		GestorConsultasIntegrales gestor = new GestorConsultasIntegrales();
		CadenaFiltro cadFiltroLocal = new CadenaFiltro();

		cadFiltroLocal = gestor.getQueryPremiosProceGral(dto);

		RecordSet rs = new RecordSet();
	    BelcorpService belcorpService;    
		 
		try {
			belcorpService = BelcorpService.getInstance();
			rs = belcorpService.dbService.executePreparedQuery(cadFiltroLocal.getCadena().toString(),
				cadFiltroLocal.getParamFiltro());
	    }
		catch (Exception e) {
			UtilidadesLog.error("ERROR ", e);
	        throw new MareException(e, 
		    UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS));
	    }

		UtilidadesLog.info("DAOConsultaIntegralGeneral.consultarDetallePremiosProcesadosGral(DTOCabeceraConsultaIntegral dto): Salida");
		return rs;
	}
}