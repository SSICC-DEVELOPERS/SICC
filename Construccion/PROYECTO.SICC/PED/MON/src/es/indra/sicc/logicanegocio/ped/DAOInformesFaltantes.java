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
 */

package es.indra.sicc.logicanegocio.ped;

import es.indra.mare.common.exception.MareException;
import es.indra.mare.common.mii.services.jdbcservice.RecordSet;
import es.indra.mare.common.mii.MareMiiServiceNotFoundException;
import es.indra.sicc.dtos.ped.DTOEInformeFaltantes;
import es.indra.sicc.dtos.ped.DTOInformeFaltantes;
import es.indra.sicc.dtos.ped.DTOCabeceraReporte;
import es.indra.sicc.dtos.ped.DTOMovimiento;
import es.indra.sicc.dtos.ped.DTOMovimientoAcumulado;
import es.indra.sicc.dtos.ped.DTOMovimientoDiario;
import es.indra.sicc.util.DTOBelcorp;
import es.indra.sicc.util.BelcorpService;
import es.indra.sicc.util.UtilidadesError;
import es.indra.sicc.util.CodigosError;
import es.indra.sicc.dtos.ped.ConstantesPedFaltantes;
import es.indra.sicc.logicanegocio.ped.ConstantesPED;
import es.indra.sicc.util.UtilidadesLog;
import java.math.BigDecimal;
import java.sql.Date;
import java.text.*;
import java.util.ArrayList;
import javax.ejb.SessionContext;

public class DAOInformesFaltantes  {
  private SessionContext ctx;

  public DAOInformesFaltantes(SessionContext context) {
    this.ctx = context; 
  }

  public DAOInformesFaltantes() {
  }

  /* Obtiene los reportes de faltantes del país dado en el dto. */
  public RecordSet obtieneReportes(DTOBelcorp dtoe) throws MareException {
        UtilidadesLog.debug("DAOInformesFaltantes.obtieneReportes(DTOBelcorp dtoe): Entrada ");
        
        BelcorpService bs;
        RecordSet rs;
        StringBuffer buf = new StringBuffer();
        try {
            bs = BelcorpService.getInstance();
        } catch(MareMiiServiceNotFoundException e) {
            throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_PEDIR_UN_SERVICIO_MARE));
        }
//Se modifico MCO x Incidencia 6445: se agregaro los campos:
//r.fec_ejec fechaejecucion, r.fec_apro fechaaprobacion, r.val_usua_apro usuarioaprobacion, r.perd_oid_peri periodo

        try { 
            buf.append("SELECT r.oid_repo_falt oid, r.val_lote_repo_falt lote, r.fec_ejec fechaejecucion, ");
            buf.append("r.fec_apro fechaaprobacion, r.val_usua_apro usuarioaprobacion ");
            buf.append("FROM ped_repor_falta r ");
            buf.append("WHERE r.pais_oid_pais = " + dtoe.getOidPais());
            rs = bs.dbService.executeStaticQuery(buf.toString());
        } catch(Exception e) {  
            UtilidadesLog.error("Exception: ",e);
            throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS));
        }
        UtilidadesLog.debug("  ");
        UtilidadesLog.info("DAOInformesFaltantes.obtieneReportes(DTOBelcorp dtoe): Salida ");
       return rs;         
    }

  /*  Obtiene los reportes de faltantes del país dado en el dto 
      y cuya fecha de aprobación esté a null
  */
  public RecordSet obtieneReportesNoAprovados(DTOBelcorp dtoe) throws MareException {
        UtilidadesLog.info("DAOInformesFaltantes.obtieneReportesNoAprovados(DTOBelcorp dtoe): Entrada ");
        BelcorpService bs;
        RecordSet rs;
        StringBuffer buf = new StringBuffer();
        try {
            bs = BelcorpService.getInstance();
        } catch(MareMiiServiceNotFoundException e) {
            throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_PEDIR_UN_SERVICIO_MARE));
        }
        try {
            buf.append("SELECT r.oid_repo_falt oid, r.val_lote_repo_falt lote ");
            buf.append("FROM ped_repor_falta r ");
            buf.append("where ((r.pais_oid_pais = " + dtoe.getOidPais() + ")");
            buf.append(" AND (r.fec_apro is null)) ");
            rs = bs.dbService.executeStaticQuery(buf.toString());
        } catch(Exception e) {
            UtilidadesLog.error("Exception: ",e);
            throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS));
        }
        UtilidadesLog.info("DAOInformesFaltantes.obtieneReportesNoAprovados(DTOBelcorp dtoe): Salida ");
        return rs;         
   }

    /*
      Obtiene los registros de SolicitudCabecera, filtrando por: 
    - pais = dto.pais 
    - Tipo Solicitud: Aquellos que tengan previsto el proceso Reporte Faltantes, en su Secuencia Procesos. Se recuperan de la entidad Secuencia procesos filtrando por País, Proceso = "P305" (Reporte Faltantes) 
    - Estado Solicitud: "Validado" 
    - Grupo Procesos: GP2 
    - Proceso Pedidos: el último de GP2 (debe corresponder con el que tenga la mayor secuencia para Grupo Procesos GP2. Se recupera de la entidad Secuencia procesos filtrando por País, Tipo Solicitud, Grupo Procesos GP2 y Máxima Secuencia) 
    - Lote Reporte Faltantes: dto.loteReporteFaltantes 
    - Fecha de prefacturación esté comprendida entre fechaIni y fechaFin 
  */
  public RecordSet obtieneSolicitudesFaltantes(DTOInformeFaltantes dtoe) throws MareException {
        UtilidadesLog.info("DAOInformesFaltantes.obtieneSolicitudesFaltantes(DTOInformeFaltantes dtoe): Entrada ");

        BelcorpService bs;
        RecordSet rs;
        StringBuffer buf = new StringBuffer();
        try {
            bs = BelcorpService.getInstance();
        } catch(MareMiiServiceNotFoundException e) {
            throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_PEDIR_UN_SERVICIO_MARE));
        }
        try {
            buf.append("SELECT ");
            buf.append("s.oid_soli_cabe oid, "); 
            buf.append("s.pais_oid_pais pais, "); 
            buf.append("i18nPais.VAL_I18N as txtpais, "); 
            buf.append("s.perd_oid_peri periodo, "); 
            buf.append("pe.val_nomb_peri txtperiodo, ");
            buf.append("a.cana_oid_cana canal, ");
            buf.append("i18nCanal.VAL_I18N  as txtcanal, "); 
            buf.append("m.oid_marc marca, ");
            buf.append("m.des_marc txtmarca, ");  
            buf.append("a.oid_acce acceso, "); 
            buf.append("i18nAcceso.VAL_I18N as txtacceso, "); 
            buf.append("u.uneg_oid_unid_nego unidadnegocio, "); 
            buf.append("i18nUNegocio.VAL_I18N as txtunidadnegocio, "); 
            buf.append("su.oid_sbac subacceso "); 
            buf.append("FROM "); 
            buf.append("ped_solic_cabec s, "); 
            buf.append("ped_tipo_solic_pais t, "); 
            buf.append("ped_secue_proce e, ");
            buf.append("ped_estad_solic es, "); 
            buf.append("ped_grupo_proce gp, ");
            buf.append("ped_proce p, "); 
            buf.append("seg_subac su, "); 
            buf.append("seg_acces a, "); 
            buf.append("seg_marca m, "); 
            buf.append("cra_perio pe, "); 
            buf.append("ped_solic_posic, "); 
            buf.append("mae_produ u, "); 
            buf.append("V_GEN_I18N_SICC i18nPais, "); 
            buf.append("V_GEN_I18N_SICC i18nCanal, ");
            buf.append("V_GEN_I18N_SICC i18nAcceso, ");
            buf.append("V_GEN_I18N_SICC i18nUNegocio ");
            buf.append("WHERE ( ");
            buf.append("(i18nPais.ATTR_ENTI = 'SEG_PAIS') ");
            buf.append("AND (i18nPais.ATTR_NUM_ATRI = 1) ");
            buf.append("AND (i18nPais.IDIO_OID_IDIO = " + dtoe.getOidIdioma() + ") ");  
            buf.append("AND (i18nPais.VAL_OID = s.pais_oid_pais) ");
            buf.append("AND (i18nCanal.ATTR_ENTI = 'SEG_CANAL') ");
            buf.append("AND (i18nCanal.ATTR_NUM_ATRI = 1) ");
            buf.append("AND (i18nCanal.IDIO_OID_IDIO = " + dtoe.getOidIdioma() + ") ");
            buf.append("AND (i18nCanal.VAL_OID = a.cana_oid_cana) "); 
            buf.append("AND (i18nAcceso.ATTR_ENTI = 'SEG_ACCES') ");
            buf.append("AND (i18nAcceso.ATTR_NUM_ATRI = 1) ");
            buf.append("AND (i18nAcceso.IDIO_OID_IDIO = " + dtoe.getOidIdioma() + ") ");
            buf.append("AND (i18nAcceso.VAL_OID = a.oid_acce) ");
            buf.append("AND (i18nUNegocio.ATTR_ENTI = 'MAE_UNIDA_NEGOC') ");
            buf.append("AND (i18nUNegocio.ATTR_NUM_ATRI = 1) ");
            buf.append("AND (i18nUNegocio.IDIO_OID_IDIO = " + dtoe.getOidIdioma() + ") ");
            buf.append("AND (i18nUNegocio.VAL_OID = u.uneg_oid_unid_nego) "); 
            buf.append("AND (t.oid_tipo_soli_pais = s.tspa_oid_tipo_soli_pais) ");
            buf.append("AND (t.oid_tipo_soli_pais = e.tspa_oid_tipo_soli_pais) "); 
            buf.append("AND (p.oid_proc = e.proc_oid_proc) "); 
            buf.append("AND (es.oid_esta_soli = s.esso_oid_esta_soli) "); 
            buf.append("AND (gp.oid_grup_proc = s.grpr_oid_grup_proc) "); 
            buf.append("AND (gp.oid_grup_proc = e.grpr_oid_grup_proc) "); 
            buf.append("AND (p.oid_proc = s.proc_oid_proc) "); 
            buf.append("AND (gp.oid_grup_proc = p.grpr_oid_grup_proc) "); 
            buf.append("AND (su.oid_sbac = s.sbac_oid_sbac) "); 
            buf.append("AND (a.oid_acce = su.acce_oid_acce) "); 
            buf.append("AND (a.oid_acce = pe.acce_oid_acce) "); 
            buf.append("AND (m.oid_marc = pe.marc_oid_marc) "); 
            buf.append("AND (pe.oid_peri = s.perd_oid_peri) "); 
            buf.append("AND (s.oid_soli_cabe = ped_solic_posic.soca_oid_soli_cabe) "); 
            buf.append("AND (pe.oid_peri = u.perd_oid_peri_inic) "); 
            buf.append("AND (pe.oid_peri = u.perd_oid_peri_fin) "); 
            buf.append("AND (u.oid_prod = ped_solic_posic.prod_oid_prod) "); 
            buf.append("AND (s.pais_oid_pais = " + dtoe.getOidPais() + ") ");
            buf.append("AND (es.cod_esta_soli = '" + ConstantesPedFaltantes.COD_EST_VALIDADO + "') ");  
            buf.append("AND (gp.cod_grup_proc = '" + ConstantesPedFaltantes.COD_GP2 + "') "); 
            buf.append("AND (p.cod_proc = '" + ConstantesPedFaltantes.COD_PROC_FALTANTES + "') "); 
            buf.append("AND (s.proc_oid_proc = ( "); 
            buf.append("SELECT p.oid_proc proceso ");
            buf.append("FROM ped_proce p, ");
            buf.append("ped_secue_proce s, ");
            buf.append("ped_grupo_proce g ");
            buf.append("WHERE ((p.oid_proc = s.proc_oid_proc) "); 
            buf.append("AND (g.oid_grup_proc = s.grpr_oid_grup_proc) "); 
            buf.append("AND (g.cod_grup_proc = '" + ConstantesPedFaltantes.COD_GP2 + "') "); 
            buf.append("AND (s.tspa_oid_tipo_soli_pais = t.oid_tipo_soli_pais) "); 
            buf.append("AND s.cod_secu = ");
            buf.append("(SELECT MAX(s.cod_secu) secuencia "); 
            buf.append("FROM ped_proce p, ");
            buf.append("ped_secue_proce s, ");
            buf.append("ped_grupo_proce g "); 
            buf.append("WHERE ((p.oid_proc = s.proc_oid_proc) "); 
            buf.append("AND (g.oid_grup_proc = s.grpr_oid_grup_proc) "); 
            buf.append("AND (g.cod_grup_proc = '" + ConstantesPedFaltantes.COD_GP2 + "') "); 
            buf.append("AND (s.tspa_oid_tipo_soli_pais = t.oid_tipo_soli_pais)) "); 
            buf.append(") ");
            buf.append(") ");
            buf.append(") ");
            buf.append(") ");
            buf.append("AND (s.val_lote_repo_falt = " + dtoe.getLoteReporteFaltantes() + ") "); 
            buf.append("AND (s.fec_prog_fact >= to_date ('" + dtoe.getFechaIni() + "','YYYY-MM-DD')) "); 
            if (dtoe.getFechaFin()!=null){
                buf.append("AND (s.fec_prog_fact <= to_date ('" + dtoe.getFechaFin() + "','YYYY-MM-DD')) ");
            }else{
                buf.append("AND (s.fec_prog_fact <= to_date ('" + dtoe.getFechaIni() + "','YYYY-MM-DD')) ");
            }
            buf.append(") ");
            rs = bs.dbService.executeStaticQuery(buf.toString());
        } catch(Exception e) {
            UtilidadesLog.error("Exception: ",e);
            throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS));
        }
        UtilidadesLog.info("DAOInformesFaltantes.obtieneSolicitudesFaltantes(DTOInformeFaltantes dtoe): Salida ");
       return rs;         
   }

  /**
  * @Autor: Emilio Noziglia
  * @Fecha : 15/07/2005
  * @Recibe: DTOInformeFaltantes dtoe (con pais e idioma), Long oidPeriodo
  * @Retorna: ArrayList de DTOs DTOMovimientoAcumulado 
  * @Descripción: obtienePosicionesAcumuladas
  * @Referencia: Incidencia BELC300015591 (y JFDelPeso)
  */ 
  public ArrayList obtienePosicionesAcumuladas(DTOInformeFaltantes dtoe, Long oidPeriodo) throws MareException {
        UtilidadesLog.info("DAOInformesFaltantes.obtienePosicionesAcumuladas(DTOInformeFaltantes dtoe, Long oidPeriodo): Entrada ");
        UtilidadesLog.debug("DTOInformeFaltantes: " + dtoe + " oidPeriodo: " + oidPeriodo);
        BelcorpService bs;
        RecordSet rs;
        ArrayList posicionesAcumuladas = null;
        StringBuffer buf = new StringBuffer();
        try {
            bs = BelcorpService.getInstance();
        } catch(MareMiiServiceNotFoundException e) {
            throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_PEDIR_UN_SERVICIO_MARE));
        }
        try {
            Long idioma = dtoe.getOidIdioma();  

            buf.append(" SELECT   posiciones_reporte_faltantes.pais_oid_pais, ");                  		             
                 buf.append(" posiciones_reporte_faltantes.cana_oid_cana, ");	             
                 buf.append(" posiciones_reporte_faltantes.marc_oid_marc, ");	             
                 buf.append(" posiciones_reporte_faltantes.perd_oid_peri, ");		             
                 buf.append(" posiciones_reporte_faltantes.acce_oid_acce, ");                 	             
                 buf.append(" posiciones_reporte_faltantes.uneg_oid_unid_nego, "); 		             
                 buf.append(" posiciones_reporte_faltantes.almc_oid_alma, ");		             
                 buf.append(" posiciones_reporte_faltantes.nego_oid_nego, "); 
                 /*Descripciones Pais Canal Marca Periodo Acceso Unidad de Negocio Almacen Negocio*/
                 //buf.append(" (SELECT I18N.VAL_I18N FROM V_GEN_I18N_SICC I18N WHERE I18N.ATTR_ENTI='SEG_PAIS' AND I18N.ATTR_NUM_ATRI=1 AND I18N.IDIO_OID_IDIO= "+idioma+" AND I18N.VAL_OID=posiciones_reporte_faltantes.pais_oid_pais) DESC_PAIS, ");
                 buf.append(" PQ_APL_AUX.Valor_Gen_I18n_Sicc("+idioma+", posiciones_reporte_faltantes.pais_oid_pais, 'SEG_PAIS')DESC_PAIS, ");
                 //buf.append(" (SELECT I18N.VAL_I18N FROM V_GEN_I18N_SICC I18N WHERE I18N.ATTR_ENTI='SEG_CANAL' AND I18N.ATTR_NUM_ATRI=1 AND I18N.IDIO_OID_IDIO= "+idioma+" AND I18N.VAL_OID=posiciones_reporte_faltantes.cana_oid_cana) DESC_CANAL, ");
                 buf.append(" PQ_APL_AUX.Valor_Gen_I18n_Sicc("+idioma+", posiciones_reporte_faltantes.cana_oid_cana, 'SEG_CANAL') DESC_CANAL, ");
                 buf.append(" (SELECT MARCA.DES_MARC FROM SEG_MARCA MARCA WHERE MARCA.OID_MARC=posiciones_reporte_faltantes.marc_oid_marc) DES_MARC, "); 
                 buf.append(" (SELECT PERIOD.VAL_NOMB_PERI FROM CRA_PERIO PERIOD WHERE PERIOD.OID_PERI=posiciones_reporte_faltantes.perd_oid_peri) DES_PERIO, "); 
                 //buf.append(" (SELECT I18N.VAL_I18N FROM V_GEN_I18N_SICC I18N WHERE I18N.ATTR_ENTI='SEG_ACCES' AND I18N.ATTR_NUM_ATRI=1 AND I18N.IDIO_OID_IDIO= "+idioma+" AND I18N.VAL_OID=posiciones_reporte_faltantes.acce_oid_acce) DESC_ACCES, "); 
                 buf.append(" PQ_APL_AUX.Valor_Gen_I18n_Sicc("+idioma+", posiciones_reporte_faltantes.acce_oid_acce, 'SEG_ACCES')DESC_ACCES, ");
                 //buf.append(" (SELECT I18N.VAL_I18N FROM V_GEN_I18N_SICC I18N WHERE I18N.ATTR_ENTI='MAE_UNIDA_NEGOC' AND I18N.ATTR_NUM_ATRI=1 AND I18N.IDIO_OID_IDIO= "+idioma+" AND I18N.VAL_OID=posiciones_reporte_faltantes.uneg_oid_unid_nego) DESC_UNEG, "); 
                 buf.append(" PQ_APL_AUX.Valor_Gen_I18n_Sicc("+idioma+", posiciones_reporte_faltantes.uneg_oid_unid_nego, 'MAE_UNIDA_NEGOC')DESC_UNEG, ");
                 //buf.append(" (SELECT I18N.VAL_I18N FROM V_GEN_I18N_SICC I18N WHERE I18N.ATTR_ENTI='BEL_ALMAC' AND I18N.ATTR_NUM_ATRI=1 AND I18N.IDIO_OID_IDIO= "+idioma+" AND I18N.VAL_OID=posiciones_reporte_faltantes.almc_oid_alma) DESC_ALMAC, "); 
                 buf.append(" PQ_APL_AUX.Valor_Gen_I18n_Sicc("+idioma+", posiciones_reporte_faltantes.almc_oid_alma, 'BEL_ALMAC') DESC_ALMAC, "); 
		         //buf.append(" (SELECT I18N.VAL_I18N FROM V_GEN_I18N_SICC I18N WHERE I18N.ATTR_ENTI='MAE_NEGOC' AND I18N.ATTR_NUM_ATRI=1 AND I18N.IDIO_OID_IDIO= "+idioma+" AND I18N.VAL_OID=posiciones_reporte_faltantes.nego_oid_nego) DESC_NEGOC, "); 
                 buf.append(" PQ_APL_AUX.Valor_Gen_I18n_Sicc("+idioma+", posiciones_reporte_faltantes.nego_oid_nego, 'MAE_NEGOC') DESC_NEGOC, ");
                 buf.append(" ind_ahorro_guia, "); 
                 buf.append(" posiciones_reporte_faltantes.prod_oid_prod, "); 
                 buf.append(" posiciones_reporte_faltantes.num_unid_por_aten, "); 
                 buf.append(" posiciones_reporte_faltantes.num_unid_comp, "); 
                 buf.append(" NVL (stock.val_sald, 0) stock, umbral.val_umbr_falt umbral_faltantes ");     
                 buf.append(" FROM (SELECT   s.pais_oid_pais, s.perd_oid_peri, perio.cana_oid_cana, "); 
                               buf.append(" perio.marc_oid_marc, sub.acce_oid_acce, "); 
                               buf.append(" prod.uneg_oid_unid_nego, s.almc_oid_alma, "); 
                               buf.append(" prod.nego_oid_nego, "); 
                               buf.append(" DECODE (cat.cod_cata, '"+ConstantesPedFaltantes.COD_CATALOGO_AHORRO+"', 1, 0) AS ind_ahorro_guia, "); 
                               buf.append(" pos.prod_oid_prod, SUM (pos.num_unid_por_aten) num_unid_por_aten, "); 
                               buf.append(" SUM (num_unid_compr) num_unid_comp "); 
                          buf.append(" FROM ped_solic_cabec s, "); 
                               buf.append(" cra_perio perio, "); 
                               buf.append(" seg_subac sub, "); 
                               buf.append(" ped_solic_posic pos, "); 
                               buf.append(" mae_produ prod, "); 
                               buf.append(" pre_ofert_detal pre, "); 
                               buf.append(" pre_catal cat "); 
                         buf.append(" WHERE ");                   
                           // -- SEVERIFICAN EL PAIS DE LAS SOLICITUDES
                           buf.append(" s.pais_oid_pais = "+dtoe.getOidPais()+" ");/*parametro*/
                           /* HAGO EL JOIN CON SUBACCESO PARA OBTENER EL ACCESO*/
                           buf.append(" AND sub.oid_sbac = s.sbac_oid_sbac ");
                           /* HAGO EL JOIN PARA OBTENER LAS POSICIONES*/
                           buf.append(" AND pos.soca_oid_soli_cabe = s.oid_soli_cabe ");
                           /* Se obtienen las solicitudes contenidas en el periodo recibido*/
                           buf.append(" AND s.perd_oid_peri = "+oidPeriodo+" ");               /*oidPeriodo /*parametro*/
                           /* DESCARTAMOS LAS SOLICITUDES ANULADAS*/
                           buf.append(" AND pos.espo_oid_esta_posi <> 2 ");                          
                           //-- HAGO EL JOIN PARA OBTENER LA MARCA Y EL CANAL
                           buf.append(" AND perio.oid_peri = s.perd_oid_peri ");
                           //--SE VERIFICA QUE TENGA FECHA DE FACTURACION
                           buf.append(" AND s.fec_fact IS NOT NULL ");
                           //-- SE VERIFICAN QUE LAS SOLICITUDES TENGAN EL PROCESO DE GENERACION DE FALTANTES PARAMETRIZADO
                           buf.append(" AND s.tspa_oid_tipo_soli_pais IN ( ");
                                  buf.append(" SELECT tsp.oid_tipo_soli_pais ");
                                    buf.append(" FROM ped_tipo_solic_pais tsp, ");
                                         buf.append(" ped_secue_proce sp, ");
                                         buf.append(" ped_proce pr ");
                                   buf.append(" WHERE sp.tspa_oid_tipo_soli_pais = tsp.oid_tipo_soli_pais ");
                                     buf.append(" AND sp.proc_oid_proc = pr.oid_proc ");
                                     buf.append(" AND pr.cod_proc = '"+ConstantesPedFaltantes.COD_PROC_FALTANTES+"') ");
                           /* HAGO EL JOIN CON MAE_PRODUCT PARA OBTENER UNIDADE DE NEGOCIO Y NEGOCIO*/
                           buf.append(" AND pos.prod_oid_prod = prod.oid_prod ");
                           /* HAGO EL JOIN CON DETALLE OFERTA Y CATALOGO PARA OBTENER EL CODIGO DEL CATALOGO*/
                           buf.append(" AND pre.oid_deta_ofer(+) = pos.ofde_oid_deta_ofer ");
                           buf.append(" AND pre.ocat_oid_catal = cat.oid_cata(+) ");
                      buf.append(" GROUP BY s.pais_oid_pais, ");
                               buf.append(" s.perd_oid_peri, ");
                               buf.append(" perio.cana_oid_cana, ");
                               buf.append(" perio.marc_oid_marc, ");
                               buf.append(" sub.acce_oid_acce, ");
                               buf.append(" prod.uneg_oid_unid_nego, ");                               
                               buf.append(" s.almc_oid_alma, ");
                               buf.append(" prod.nego_oid_nego, ");
                               buf.append(" DECODE (cat.cod_cata, '"+ConstantesPedFaltantes.COD_CATALOGO_AHORRO+"', 1, 0), ");
                               buf.append(" pos.prod_oid_prod) posiciones_reporte_faltantes, ");
                     buf.append(" (SELECT * from bel_stock s,bel_estad_merca where  cod_esta= '"+ConstantesPedFaltantes.COD_ESTA_LIBRE_DISPOS+"' AND s.esme_oid_esta_merc = oid_esta_merc) stock, ");
                     buf.append(" ped_umbra_falta umbral ");
               buf.append(" WHERE posiciones_reporte_faltantes.nego_oid_nego = umbral.nego_oid_nego(+) ");
                 buf.append(" AND stock.almc_oid_alma(+) = posiciones_reporte_faltantes.almc_oid_alma ");
                 buf.append(" AND stock.prod_oid_prod(+) = posiciones_reporte_faltantes.prod_oid_prod ");
            buf.append(" ORDER BY posiciones_reporte_faltantes.acce_oid_acce, ");
                     buf.append(" posiciones_reporte_faltantes.uneg_oid_unid_nego, ");
                     buf.append(" posiciones_reporte_faltantes.almc_oid_alma, ");
                     buf.append(" ind_ahorro_guia, ");
                     buf.append(" posiciones_reporte_faltantes.nego_oid_nego, ");                     
                     buf.append(" posiciones_reporte_faltantes.prod_oid_prod ");
		 

            rs = bs.dbService.executeStaticQuery(buf.toString());
            
            if (!rs.esVacio()) {
              posicionesAcumuladas = new ArrayList();
              for (int i=0;i<rs.getRowCount();i++){
                  DTOMovimientoAcumulado dtoMovAcum = new DTOMovimientoAcumulado();                
             
                   dtoMovAcum.setOidPais(BigToLong(rs.getValueAt(i,"PAIS_OID_PAIS")));                   
                   dtoMovAcum.setTxtPais((String)rs.getValueAt(i,"DESC_PAIS"));                   
                   dtoMovAcum.setCanal(BigToLong(rs.getValueAt(i,"CANA_OID_CANA")));                   
                   dtoMovAcum.setTxtCanal((String)rs.getValueAt(i,"DESC_CANAL"));
                   dtoMovAcum.setMarca(BigToLong(rs.getValueAt(i,"MARC_OID_MARC")));
                   dtoMovAcum.setTxtMarca((String)rs.getValueAt(i,"DES_MARC"));
                   dtoMovAcum.setPeriodo(BigToLong(rs.getValueAt(i,"PERD_OID_PERI")));
                   dtoMovAcum.setTxtPeriodo((String)rs.getValueAt(i,"DES_PERIO"));
                   dtoMovAcum.setAcceso(BigToLong(rs.getValueAt(i,"ACCE_OID_ACCE")));
                   dtoMovAcum.setTxtAcceso((String)rs.getValueAt(i,"DESC_ACCES"));
                   dtoMovAcum.setUnidadNegocio(BigToLong(rs.getValueAt(i,"UNEG_OID_UNID_NEGO")));
                   dtoMovAcum.setTxtUnidadNegocio((String)rs.getValueAt(i,"DESC_UNEG"));
                   dtoMovAcum.setAlmacen(BigToLong(rs.getValueAt(i,"ALMC_OID_ALMA")));
                   dtoMovAcum.setTxtAlmacen((String)rs.getValueAt(i,"DESC_ALMAC"));
                   dtoMovAcum.setNegocio(BigToLong(rs.getValueAt(i,"NEGO_OID_NEGO")));
                   dtoMovAcum.setTxtNegocio((String)rs.getValueAt(i,"DESC_NEGOC"));
                   dtoMovAcum.setIndAhorro(BigToBoolean(rs.getValueAt(i,"IND_AHORRO_GUIA")));                   
                   dtoMovAcum.setProducto(BigToLong(rs.getValueAt(i,"PROD_OID_PROD")));
                   dtoMovAcum.setUnidadesPorAtender(BigToLong(rs.getValueAt(i,"NUM_UNID_POR_ATEN")));
                   dtoMovAcum.setUnidadesComprometidas(BigToLong(rs.getValueAt(i,"NUM_UNID_COMP")));
                   dtoMovAcum.setStockDisponible(BigToLong(rs.getValueAt(i,"STOCK")));
                   dtoMovAcum.setUmbral(BigToDouble(rs.getValueAt(i,"UMBRAL_FALTANTES")));
                   dtoMovAcum.setOidIdioma(dtoe.getOidIdioma());
                   dtoMovAcum.setIndDiario(Boolean.FALSE); 
                   
                   dtoMovAcum.setFaltante(null);
                   dtoMovAcum.setPosicion(null);
                   dtoMovAcum.setUnidades(null);
                   
                   posicionesAcumuladas.add(dtoMovAcum);
              }
            }
        } catch(Exception e) {
            UtilidadesLog.error("Exception: ",e);
            throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS));
        }
        UtilidadesLog.debug("sale de obtienePosicionesAcumuladas con posicionesAcumuladas:"+posicionesAcumuladas);
        UtilidadesLog.info("DAOInformesFaltantes.obtienePosicionesAcumuladas(DTOInformeFaltantes dtoe, Long oidPeriodo): Salida ");
        return posicionesAcumuladas;         
  }

  /*Documentation
      Se recupera información de la entidad Solicitud (Posición), filtrando por: 
      - Solicitud Cabecera = dto.solicitud 
      - Estado Posición <> "Anulada" 
      - Unidad de Negocio = dto.unidadNegocio 
  */
  public RecordSet obtienePosicionesFaltantes(DTOCabeceraReporte dtoe) throws MareException {
  /*
  Incidencia 6376
  Se agrego un NVL al recoger los campos p.num_unid_por_aten y
  p.num_unid_compr para sustituir un posible valor nulo por un cero (NVL(p.num_unid_por_aten, 0) y
  NVL(p.num_unid_compr, 0) respectivamente) 
  */
        UtilidadesLog.info("DAOInformesFaltantes.obtienePosicionesFaltantes(DTOCabeceraReporte dtoe): Entrada ");
        BelcorpService bs;
        RecordSet rs;
        StringBuffer buf = new StringBuffer();
        try {
            bs = BelcorpService.getInstance();
        } catch(MareMiiServiceNotFoundException e) {
            throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_PEDIR_UN_SERVICIO_MARE));
        }
        try {
              buf.append("SELECT "); 
              buf.append("p.oid_soli_posi oid, "); 
              buf.append("s.almc_oid_alma almacen, "); 
              buf.append("i18nAlmacen.val_i18n  txtalmacen, "); 
              buf.append("pr.nego_oid_nego negocio, "); 
              buf.append("i18nNegocio.val_i18n  txtnegocio, "); 
              buf.append("NVL(p.num_unid_por_aten, 0) unidadesatender, "); 
              buf.append("pr.oid_prod producto, "); 
              buf.append("i18nProducto.val_i18n  txtproducto, "); 
              buf.append("NVL(p.num_unid_compr, 0) unidadescomprometidas, "); 
              buf.append("p.val_codi_vent_fict codigoventa "); 
              buf.append("FROM "); 
              buf.append("V_GEN_I18N_SICC i18nAlmacen, ");
              buf.append("V_GEN_I18N_SICC i18nNegocio, ");
              buf.append("V_GEN_I18N_SICC i18nProducto, ");
              buf.append("ped_solic_cabec s, "); 
              buf.append("ped_solic_posic p, "); 
              buf.append("ped_estad_posic ep, "); 
              buf.append("mae_produ pr "); 
              buf.append("WHERE ((i18nAlmacen.ATTR_ENTI = 'BEL_ALMAC') "); 
              buf.append("AND (i18nAlmacen.ATTR_NUM_ATRI = 1) ");
              buf.append("AND (i18nAlmacen.IDIO_OID_IDIO = " + dtoe.getOidIdioma() + ") ");  
              buf.append("AND (i18nAlmacen.VAL_OID = s.almc_oid_alma) "); 
              buf.append("AND (i18nNegocio.ATTR_ENTI = 'MAE_NEGOC') "); 
              buf.append("AND (i18nNegocio.ATTR_NUM_ATRI = 1) "); 
              buf.append("AND (i18nNegocio.IDIO_OID_IDIO = " + dtoe.getOidIdioma() + ") "); 
              buf.append("AND (i18nNegocio.VAL_OID = pr.nego_oid_nego) "); 
              buf.append("AND (i18nProducto.ATTR_ENTI = 'MAE_PRODU') "); 
              buf.append("AND (i18nProducto.ATTR_NUM_ATRI = 1) "); 
              buf.append("AND (i18nProducto.IDIO_OID_IDIO = " + dtoe.getOidIdioma() + ") "); 
              buf.append("AND (i18nProducto.VAL_OID = pr.oid_prod) "); 
              buf.append("AND (s.oid_soli_cabe = p.soca_oid_soli_cabe) "); 
              buf.append("AND (ep.oid_esta_posi = p.espo_oid_esta_posi) "); 
              buf.append("AND (pr.oid_prod = p.prod_oid_prod) "); 
              buf.append("AND (ep.cod_esta_posi <> '" + ConstantesPedFaltantes.COD_POSIC_ANULADA + "') "); 
              buf.append("AND (s.oid_soli_cabe = " + dtoe.getSolicitud()  + ") ");  
              buf.append("AND (pr.uneg_oid_unid_nego = " + dtoe.getUnidadNegocio()  + ") ");
              buf.append(") ");
              rs = bs.dbService.executeStaticQuery(buf.toString());
        } catch(Exception e) {
            UtilidadesLog.error("Exception: ",e);
            throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS));
        }
        UtilidadesLog.info("DAOInformesFaltantes.obtienePosicionesFaltantes(DTOCabeceraReporte dtoe): Salida ");
       return rs;         
  }

    /*
         Documentation
        Actualiza el lote de las solicitudes del país y lote antigüo dado dados. 
        Proceso: 
        ======= 
        Haciendo uso de DBService se realiza el siguiente UPDATE: 
        UPDATE own_peru.ped_solic_cabec 
        SET 
        ped_solic_cabec.val_lote_repo_falt = loteNuevo, 
        ped_solic_cabec.fec_repo_falt = fecha del sistema 
        WHERE 
        ((ped_solic_cabec.pais_oid_pais = pais) 
        AND (ped_solic_cabec.val_lote_repo_falt = lote) 
        ) 
     */
     //NRO INCIDENCIA 6370: Se debe usar UPDATE
     //Cambio por incidencia 18296
  public void actualizaLoteSolicitudes(Long pais, Long loteNuevo, java.sql.Date fechaIni, java.sql.Date fechaFin) throws MareException {
        UtilidadesLog.info("DAOInformesFaltantes.actualizaLoteSolicitudes(Long pais, Long loteNuevo, java.sql.Date fechaIni, java.sql.Date fechaFin): Entrada ");
        BelcorpService bs;
        RecordSet rs;
        String formatoFecha = new String("dd-MM-yyyy");
        UtilidadesLog.debug("Entra en actualizaLoteSolicitudes");
        StringBuffer buf = new StringBuffer();
        try {
            bs = BelcorpService.getInstance();
        } catch(MareMiiServiceNotFoundException e) {
            throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_PEDIR_UN_SERVICIO_MARE));
        }

        DateFormat f =  new SimpleDateFormat(formatoFecha);
        
        buf.append("UPDATE ped_solic_cabec sol "); 
        buf.append("SET sol.VAL_LOTE_REPO_FALT = " + loteNuevo + ", "); 
        buf.append("sol.fec_repo_falt = to_date('" + f.format(new Date(System.currentTimeMillis())) + "','DD-MM-YYYY') "); 
        buf.append("WHERE sol.oid_soli_cabe IN ( "); 
        buf.append("SELECT s.oid_soli_cabe "); 
        buf.append("FROM ped_solic_cabec s "); //--, cra_perio perio
        //-- SEVERIFICAN EL PAIS DE LAS SOLICITUDES
        buf.append("WHERE  s.pais_oid_pais = " + pais + " "); 
        //--SE VERIFICA LA FECHA PREVISTA DE FACTURACION
        buf.append("AND s.fec_prog_fact >= TO_DATE ('" + f.format(fechaIni) + "', 'DD-MM-YYYY') "); 
        if (fechaFin!=null) {
          buf.append("AND s.fec_prog_fact <= TO_DATE ('" + f.format(fechaFin) + "', 'DD-MM-YYYY') "); /*SI FechaFin es diferente de null*/
        }
        //-- SE VERIFICAN QUE LAS SOLICITUDES TENGAN EL PROCESO DE GENERACION DE FALTANTES P/ARAMETRIZADO
        buf.append("AND s.tspa_oid_tipo_soli_pais IN ( "); 
        buf.append("SELECT tsp.oid_tipo_soli_pais "); 
        buf.append("FROM ped_tipo_solic_pais tsp, "); 
        buf.append("ped_secue_proce sp, "); 
        buf.append("ped_proce pr "); 
        buf.append("WHERE sp.tspa_oid_tipo_soli_pais = tsp.oid_tipo_soli_pais "); 
        buf.append("AND sp.proc_oid_proc = pr.oid_proc "); 
        buf.append("AND pr.cod_proc = 'P305') "); //ConstantesPedFaltantes.COD_PROC_FALTANTES
        //-- SE VERIFICA QUE ESTE EN GP2
        buf.append("AND s.grpr_oid_grup_proc = "+ConstantesPED.GP2+" "); 
        //-- SE VERIFICA QUE NO ESTEN CONTENIDAS EN OTRO REPORTE DE FALTANTES
        buf.append("AND s.val_lote_repo_falt IS NULL "); 
        //-- SE VERIFICA QUE EL ESTATUS
        buf.append("AND s.esso_oid_esta_soli = "+ConstantesPED.ESTADO_SOLICITUD_VALIDADO+" ");/*1*/
        //-- SE VALIDA QUE SE ENCUENTRE EN EL ULTIMO PROCESO DE LA SECUENCIA DE GP2
        buf.append("AND s.proc_oid_proc = ");
        buf.append("(SELECT sp.proc_oid_proc ");
        buf.append("FROM ped_secue_proce sp ");
        buf.append("WHERE sp.grpr_oid_grup_proc = "+ConstantesPED.GP2+" ");
        buf.append("AND sp.tspa_oid_tipo_soli_pais = ");
        buf.append("s.tspa_oid_tipo_soli_pais ");
        buf.append("AND sp.cod_secu = ");
        buf.append("(SELECT MAX (sp.cod_secu) ");
        buf.append("FROM ped_secue_proce sp ");
        buf.append("WHERE sp.grpr_oid_grup_proc = "+ConstantesPED.GP2+" ");
        buf.append("AND sp.tspa_oid_tipo_soli_pais = s.tspa_oid_tipo_soli_pais))) ");
              
        int rowsAffected = 0;
        try{          
           rowsAffected = bs.dbService.executeUpdate(buf.toString());
           UtilidadesLog.debug("Cambios realizados: "+rowsAffected);
        }
        catch(Exception e){
          UtilidadesLog.error("Exception: ",e);
          throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS));              
        }   
        /*if (rowsAffected < 1)
           throw new MareException(new Exception(), UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS));*/
        UtilidadesLog.info("DAOInformesFaltantes.actualizaLoteSolicitudes(Long pais, Long loteNuevo, java.sql.Date fechaIni, java.sql.Date fechaFin): Entrada ");
 }  
  

      /*
      Actualiza las solicitudes cuyo estado es liberado o validado del país 
      y lote dados pasándolas a GP3 y P305. 
      */
  public void apruebaLoteSolicitudes(Long pais, Long lote) throws MareException {
        UtilidadesLog.info("DAOInformesFaltantes.apruebaLoteSolicitudes(Long pais, Long lote): Entrada ");
        BelcorpService bs;
        StringBuffer buf = new StringBuffer();
        try {
            bs = BelcorpService.getInstance();
        } catch (MareMiiServiceNotFoundException e) {
            throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_PEDIR_UN_SERVICIO_MARE));
        }

              buf.append("UPDATE ped_solic_cabec s "); 
              buf.append("SET ");

              buf.append("s.grpr_oid_grup_proc = " + ConstantesPED.GP3);

              buf.append(" ,s.proc_oid_proc = "); 
              buf.append("( ");
                buf.append("SELECT p.oid_proc ");
                buf.append("FROM ped_proce p ");
                buf.append("WHERE ( ");
                  buf.append("p.cod_proc = '" + ConstantesPedFaltantes.COD_PROC_FALTANTES + "') ");
                buf.append(") ");

              buf.append("WHERE ( ");
                buf.append("(s.pais_oid_pais = " + pais + ") ");
                buf.append("AND (s.val_lote_repo_falt = " + lote + ") ");
                buf.append("AND (s.esso_oid_esta_soli ");
                  buf.append("IN ( ");
                    buf.append("SELECT e.OID_ESTA_SOLI ");
                    buf.append("FROM ped_estad_solic e ");
                    buf.append("WHERE( ");
                      buf.append("e.cod_esta_soli ");
                      buf.append("IN ( '");
                        buf.append(ConstantesPedFaltantes.COD_EST_LIBERADO + "', '"  + ConstantesPedFaltantes.COD_EST_VALIDADO);
                      buf.append("')");
                    buf.append(")");
                  buf.append(")");
                buf.append(")");
              buf.append(")");

              try{
                int rowsAffected = bs.dbService.executeUpdate(buf.toString()); //descomentar
                //if (rowsAffected < 1)
                //  throw new MareException(new Exception(), UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS));
              }
              catch(Exception e){
                UtilidadesLog.error("Exception: ",e);
                throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS));              
              }
        UtilidadesLog.info("DAOInformesFaltantes.apruebaLoteSolicitudes(Long pais, Long lote): Salida ");
  }

    /*
    Actualiza las solicitudes del país y lote dados rellenando a null tanto el lote como la fecha de generación del reporte. 

    Proceso: 
    ======= 
    Haciendo uso de DBService se realiza el siguiente UPDATE: 

    UPDATE own_peru.ped_solic_cabec s 
    SET 
    ped_solic_cabec.val_lote_repo_falt = null, 
    ped_solic_cabec.fec_repo_falt = null 

    WHERE ( (s.pais_oid_pais = pais) 
    AND (s.val_lote_repo_falt = lote) 
    AND (s.esso_oid_esta_soli IN 
    ( 
    SELECT e.OID_ESTA_SOLI 
    FROM own_peru.ped_estad_solic e 
    WHERE(e.cod_esta_soli IN (ConstantesPedFaltantes.COD_EST_LIBERADO, ConstantesPedFaltantes.COD_EST_VALIDADO)) 
    ) 
    ) 
    ) 
     */
  public void deshaceLoteSolicitudes(Long pais, Long lote) throws MareException {
        UtilidadesLog.info("DAOInformesFaltantes.deshaceLoteSolicitudes(Long pais, Long lote): Entrada ");
          BelcorpService bs;
        StringBuffer buf = new StringBuffer();
        try {
            bs = BelcorpService.getInstance();
        } catch(MareMiiServiceNotFoundException e) {
            throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_PEDIR_UN_SERVICIO_MARE));
        }

              buf.append("UPDATE ped_solic_cabec s "); 
              buf.append("SET ");

              buf.append("s.val_lote_repo_falt = null, ");
              buf.append("s.fec_repo_falt = null ");
              buf.append("WHERE ( "); 
                buf.append("(s.pais_oid_pais = " + pais + ") "); 
                buf.append("AND (s.val_lote_repo_falt = " + lote + ") ");
                buf.append("AND (s.esso_oid_esta_soli ");
                  buf.append("IN ( ");
                    buf.append("SELECT e.OID_ESTA_SOLI ");
                    buf.append("FROM ped_estad_solic e ");
                    buf.append("WHERE( "); 
                      buf.append("e.cod_esta_soli "); 
                      buf.append("IN ( '");
                         buf.append(ConstantesPedFaltantes.COD_EST_LIBERADO + "', '" + ConstantesPedFaltantes.COD_EST_VALIDADO); 
                      buf.append("') ");
                    buf.append(") "); 
                  buf.append(") ");
                buf.append(") ");
              buf.append(") ");

              try{
                int rowsAffected = bs.dbService.executeUpdate(buf.toString());
                //if (rowsAffected < 1)
                //  throw new MareException(new Exception(), UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS));
              }
              catch(Exception e){
                UtilidadesLog.error("Exception: ",e);
                throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS));              
              }
        UtilidadesLog.info("DAOInformesFaltantes.deshaceLoteSolicitudes(Long pais, Long lote): Salida ");

  }

  public RecordSet obtieneReporteLote(Long oidLoteReporteFaltantes) throws MareException
  {
        UtilidadesLog.info("DAOInformesFaltantes.obtieneReporteLote(Long oidLoteReporteFaltantes): Entrada ");
        BelcorpService bs;
        RecordSet rs;
        StringBuffer buf = new StringBuffer();
        try {
            bs = BelcorpService.getInstance();
        } catch(MareMiiServiceNotFoundException e) {
            throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_PEDIR_UN_SERVICIO_MARE));
        }
        try {
            buf.append("SELECT r.oid_repo_falt oid, ");
            buf.append("r.val_lote_repo_falt lote, ");
            buf.append("r.fec_ejec fechaejecucion, ");
            buf.append("r.fec_apro fechaaprobacion, ");
            buf.append("r.val_usua_apro usuarioaprobacion ");
            //buf.append("r.perd_oid_peri periodo ");
            buf.append("FROM ");
            buf.append("ped_repor_falta r ");
            buf.append("WHERE ");
            buf.append("r.oid_repo_falt = " + oidLoteReporteFaltantes + " ");       

            rs = bs.dbService.executeStaticQuery(buf.toString());
        } catch(Exception e) {
            UtilidadesLog.error("Exception: ",e);
            throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS));
        }
        UtilidadesLog.info("DAOInformesFaltantes.obtieneReporteLote(Long oidLoteReporteFaltantes): Salida ");
        return rs;   
  }
    /**
    * @Autor: Emilio Noziglia
    * @Fecha : 18/07/2005
    * @Recibe: DTOInformeFaltantes dtoe
    * @Retorna: ArrayList de DTOs DTOMovimientoDiario
    * @Descripción: obtieneSolicitudesMovimientos
    * @Referencia: Incidencia BELC300015591 (y JFDelPeso)
    */   
    public ArrayList obtieneSolicitudesMovimientos(DTOInformeFaltantes dtoe) throws MareException {
        UtilidadesLog.info("DAOInformesFaltantes.obtieneSolicitudesMovimientos(DTOInformeFaltantes dtoe): Entrada ");
        UtilidadesLog.debug("DTOInformeFaltantes:"+dtoe);
        BelcorpService bs;
        RecordSet rs;
        ArrayList solicitudesMovimientos = null;
        StringBuffer buf = new StringBuffer();
        
        try {
            bs = BelcorpService.getInstance();
        }
        catch(MareMiiServiceNotFoundException e) {
            throw new MareException(e, 
            UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_PEDIR_UN_SERVICIO_MARE));
        }
        try {
            Long idioma = dtoe.getOidIdioma();

            buf.append(" SELECT   posiciones_reporte_faltantes.pais_oid_pais, ");
            buf.append(" posiciones_reporte_faltantes.cana_oid_cana, ");
            buf.append(" posiciones_reporte_faltantes.marc_oid_marc, ");
            buf.append(" posiciones_reporte_faltantes.perd_oid_peri, ");
            buf.append(" posiciones_reporte_faltantes.acce_oid_acce, ");
            buf.append(" posiciones_reporte_faltantes.uneg_oid_unid_nego, ");
            buf.append(" posiciones_reporte_faltantes.almc_oid_alma, ");
            buf.append(" posiciones_reporte_faltantes.nego_oid_nego, ");
            /*Descripciones*/
            buf.append(" (SELECT I18N.VAL_I18N FROM V_GEN_I18N_SICC I18N WHERE I18N.ATTR_ENTI='SEG_PAIS' AND I18N.ATTR_NUM_ATRI=1 AND I18N.IDIO_OID_IDIO= "+idioma+" AND I18N.VAL_OID=posiciones_reporte_faltantes.pais_oid_pais) DESC_PAIS, ");
            buf.append(" (SELECT I18N.VAL_I18N FROM V_GEN_I18N_SICC I18N WHERE I18N.ATTR_ENTI='SEG_CANAL' AND I18N.ATTR_NUM_ATRI=1 AND I18N.IDIO_OID_IDIO= "+idioma+" AND I18N.VAL_OID=posiciones_reporte_faltantes.cana_oid_cana) DESC_CANAL, ");
            buf.append(" (SELECT MARCA.DES_MARC FROM SEG_MARCA MARCA WHERE MARCA.OID_MARC=posiciones_reporte_faltantes.marc_oid_marc) DES_MARC, ");
            buf.append(" (SELECT PERIOD.VAL_NOMB_PERI FROM CRA_PERIO PERIOD WHERE PERIOD.OID_PERI=posiciones_reporte_faltantes.perd_oid_peri) DES_PERIO, ");
            buf.append(" (SELECT I18N.VAL_I18N FROM V_GEN_I18N_SICC I18N WHERE I18N.ATTR_ENTI='SEG_ACCES' AND I18N.ATTR_NUM_ATRI=1 AND I18N.IDIO_OID_IDIO= "+idioma+" AND I18N.VAL_OID=posiciones_reporte_faltantes.acce_oid_acce) DESC_ACCES, ");
            buf.append(" (SELECT I18N.VAL_I18N FROM V_GEN_I18N_SICC I18N WHERE I18N.ATTR_ENTI='MAE_UNIDA_NEGOC' AND I18N.ATTR_NUM_ATRI=1 AND I18N.IDIO_OID_IDIO= "+idioma+" AND I18N.VAL_OID=posiciones_reporte_faltantes.uneg_oid_unid_nego) DESC_UNEG, ");
            buf.append(" (SELECT I18N.VAL_I18N FROM V_GEN_I18N_SICC I18N WHERE I18N.ATTR_ENTI='BEL_ALMAC' AND I18N.ATTR_NUM_ATRI=1 AND I18N.IDIO_OID_IDIO= "+idioma+" AND I18N.VAL_OID=posiciones_reporte_faltantes.almc_oid_alma) DESC_ALMAC, ");
            buf.append(" (SELECT I18N.VAL_I18N FROM V_GEN_I18N_SICC I18N WHERE I18N.ATTR_ENTI='MAE_NEGOC' AND I18N.ATTR_NUM_ATRI=1 AND I18N.IDIO_OID_IDIO= "+idioma+" AND I18N.VAL_OID=posiciones_reporte_faltantes.nego_oid_nego) DESC_NEGOC, ");
            buf.append(" ind_ahorro_guia, ");                     
            buf.append(" posiciones_reporte_faltantes.prod_oid_prod, ");
            buf.append(" posiciones_reporte_faltantes.des_cort, ");
            buf.append(" posiciones_reporte_faltantes.num_unid_por_aten, ");
            buf.append(" NVL (stock.val_sald, 0) stock, umbral.val_umbr_falt umbral_faltantes ");
            buf.append(" FROM (SELECT   s.pais_oid_pais, s.perd_oid_peri, perio.cana_oid_cana, ");
            buf.append(" perio.marc_oid_marc, sub.acce_oid_acce, ");
            buf.append(" prod.uneg_oid_unid_nego, s.almc_oid_alma, ");
            buf.append(" prod.nego_oid_nego, ");
            buf.append(" DECODE (cat.cod_cata, '"+ConstantesPedFaltantes.COD_CATALOGO_AHORRO+"', 1, 0) AS ind_ahorro_guia, ");
            buf.append(" pos.prod_oid_prod, ");
            
            //Modificado por Cristian Valenzuela
            //Incidencia: V-PED-07
            //Fecha: 1/12/2006
            //Comentario: Ahora se usa la descripcion internacionalizada
            //buf.append(" prod.des_cort, ");
            buf.append(" GEN.val_i18n as des_cort, ");
            //FIN - Modificado por Cristian Valenzuela
            
            buf.append(" SUM (pos.num_unid_por_aten) num_unid_por_aten ");            
            buf.append(" FROM ped_solic_cabec s, ");
            buf.append(" cra_perio perio, ");
            buf.append(" seg_subac sub, ");
            buf.append(" ped_solic_posic pos, ");
            buf.append(" mae_produ prod, ");
            
            //Agregado por Cristian Valenzuela - V-PED-07
            buf.append(" V_GEN_I18N_SICC GEN, ");
            //FIN - Agregado por Cristian Valenzuela
            
            buf.append(" pre_ofert_detal pre, ");
            buf.append(" pre_catal cat ");
            buf.append(" WHERE ");
            //-- SEVERIFICAN EL PAIS DE LAS SOLICITUDES
            buf.append(" s.pais_oid_pais =  " + dtoe.getOidPais() + " ");
            /* HAGO EL JOIN CON SUBACCESO PARA OBTENER EL ACCESO*/
            buf.append(" AND sub.oid_sbac = s.sbac_oid_sbac ");
            /* HAGO EL JOIN PARA OBTENER LAS POSICIONES*/
            buf.append(" AND pos.soca_oid_soli_cabe = s.oid_soli_cabe ");
            /* DESCARTAMOS LAS SOLICITUDES ANULADAS*/
            buf.append(" AND pos.espo_oid_esta_posi <> 2 ");//2
            //-- HAGO EL JOIN PARA OBTENER LA MARCA Y EL CANAL
            buf.append(" AND perio.oid_peri = s.perd_oid_peri ");
            //--SE VERIFICA LA FECHA PREVISTA DE FACTURACION
            buf.append(" AND s.fec_prog_fact >= TO_DATE ('" + dtoe.getFechaIni() + "', 'YYYY-MM-DD') ");
            if (dtoe.getFechaFin()!=null){
              buf.append(" AND s.fec_prog_fact <= TO_DATE ('" + dtoe.getFechaFin() + "', 'YYYY-MM-DD') ");
            }
            else{
              buf.append(" AND s.fec_prog_fact <= TO_DATE ('" + dtoe.getFechaIni() + "', 'YYYY-MM-DD') ");
            }
            //-- SE VERIFICAN QUE LAS SOLICITUDES TENGAN EL PROCESO DE GENERACION DE FALTANTES PARAMETRIZADO
            buf.append(" AND s.tspa_oid_tipo_soli_pais IN ( ");
            buf.append(" SELECT tsp.oid_tipo_soli_pais ");
            buf.append(" FROM ped_tipo_solic_pais tsp, ");
            buf.append(" ped_secue_proce sp, ");
            buf.append(" ped_proce pr ");
            buf.append(" WHERE sp.tspa_oid_tipo_soli_pais = tsp.oid_tipo_soli_pais ");
            buf.append(" AND sp.proc_oid_proc = pr.oid_proc ");
            buf.append(" AND pr.cod_proc = '"+ConstantesPedFaltantes.COD_PROC_FALTANTES+"') ");
            //-- SE VERIFICA QUE ESTE EN GP2
            buf.append(" AND s.grpr_oid_grup_proc = "+ConstantesPED.GP2+" ");//2 - GP2
            //-- SE VERIFICA QUE NO ESTEN CONTENIDAS EN OTRO REPORTE DE FALTANTES
            if (dtoe.getLoteReporteFaltantes()==null) {
              buf.append(" AND s.val_lote_repo_falt IS NULL ");
            }
            else {
              //Esto es cuando se hace una consulta de un reporte ya generado
              buf.append(" AND s.val_lote_repo_falt = " + dtoe.getLoteReporteFaltantes() + " ");           
            } /*parametro: PUEDE SER UN VALOR O NULL*/			   
            //-- SE VERIFICA QUE EL ESTATUS
            buf.append(" AND s.esso_oid_esta_soli = "+ConstantesPED.ESTADO_SOLICITUD_VALIDADO+" ");//1
            //-- SE VALIDA QUE SE ENCUENTRE EN EL ULTIMO PROCESO DE LA SECUENCIA DE GP2
            buf.append(" AND s.proc_oid_proc = ");
            buf.append(" (SELECT sp.proc_oid_proc ");
            buf.append(" FROM ped_secue_proce sp ");
            buf.append(" WHERE sp.grpr_oid_grup_proc = "+ConstantesPED.GP2+" ");//2 - GP2
            buf.append(" AND sp.tspa_oid_tipo_soli_pais = s.tspa_oid_tipo_soli_pais ");
            buf.append(" AND sp.cod_secu = ");
            buf.append(" (SELECT MAX (sp.cod_secu) ");
            buf.append(" FROM ped_secue_proce sp ");
            buf.append(" WHERE sp.grpr_oid_grup_proc = "+ConstantesPED.GP2+" ");//2 - GP2
            buf.append(" AND sp.tspa_oid_tipo_soli_pais = s.tspa_oid_tipo_soli_pais)) ");
            /* HAGO EL JOIN CON MAE_PRODUCT PARA OBTENER UNIDADE DE NEGOCIO Y NEGOCIO*/
            buf.append(" AND pos.prod_oid_prod = prod.oid_prod ");
            /* HAGO EL JOIN CON DETALLE OFERTA Y CATALOGO PARA OBTENER EL CODIGO DEL CATALOGO*/
            
            //Agregado por Cristian Valenzuela
            buf.append(" AND GEN.ATTR_ENTI = 'MAE_PRODU' ");
            buf.append(" AND GEN.ATTR_NUM_ATRI = 1 ");
            buf.append(" AND GEN.IDIO_OID_IDIO = " + idioma);
            buf.append(" AND GEN.VAL_OID = PROD.OID_PROD ");
            //FIN - Agregado por Cristian Valenzuela            
            
            buf.append(" AND pre.oid_deta_ofer(+) = pos.ofde_oid_deta_ofer ");
            buf.append(" AND pre.ocat_oid_catal = cat.oid_cata(+) ");            
            buf.append(" GROUP BY s.pais_oid_pais, ");
            buf.append(" s.perd_oid_peri, ");
            buf.append(" perio.cana_oid_cana, ");
            buf.append(" perio.marc_oid_marc, ");
            buf.append(" sub.acce_oid_acce, ");
            buf.append(" prod.uneg_oid_unid_nego, ");
            buf.append(" s.almc_oid_alma, ");
            buf.append(" prod.nego_oid_nego, ");
            buf.append(" DECODE (cat.cod_cata, '"+ConstantesPedFaltantes.COD_CATALOGO_AHORRO+"', 1, 0), ");
            
            //Modificado por Cristian Valenzuela - V-PED-07
            buf.append(" pos.prod_oid_prod, ");
            buf.append(" GEN.val_i18n ");
            //buf.append(" prod.des_cort ");
            buf.append(" ) posiciones_reporte_faltantes, ");
            //FIN - Modificado por Cristian Valenzuela - V-PED-07            
            
            buf.append(" (SELECT * from bel_stock s,bel_estad_merca where  cod_esta= '"+ConstantesPedFaltantes.COD_ESTA_LIBRE_DISPOS+"' AND s.esme_oid_esta_merc = oid_esta_merc) stock, ");
            buf.append(" ped_umbra_falta umbral ");
            buf.append(" WHERE posiciones_reporte_faltantes.nego_oid_nego = umbral.nego_oid_nego(+) ");
            buf.append(" AND stock.almc_oid_alma(+) = posiciones_reporte_faltantes.almc_oid_alma ");
            buf.append(" AND stock.prod_oid_prod(+) = posiciones_reporte_faltantes.prod_oid_prod ");
            buf.append(" ORDER BY posiciones_reporte_faltantes.acce_oid_acce, ");
            buf.append(" posiciones_reporte_faltantes.uneg_oid_unid_nego, ");
            buf.append(" posiciones_reporte_faltantes.almc_oid_alma, ");
            buf.append(" ind_ahorro_guia, ");
            buf.append(" posiciones_reporte_faltantes.nego_oid_nego, ");                     
            buf.append(" posiciones_reporte_faltantes.prod_oid_prod ");

            rs = bs.dbService.executeStaticQuery(buf.toString());
        
            if (!rs.esVacio())    {
              solicitudesMovimientos = new ArrayList();
              for (int i=0;i<rs.getRowCount();i++){
                  DTOMovimientoDiario dtoMovDiario = new DTOMovimientoDiario();      
                  
                  Long uneg = BigToLong(rs.getValueAt(i,"UNEG_OID_UNID_NEGO"));
                  Long negoc = BigToLong(rs.getValueAt(i,"NEGO_OID_NEGO"));
                  Long almac = BigToLong(rs.getValueAt(i,"ALMC_OID_ALMA"));
             
                   dtoMovDiario.setOidPais(BigToLong(rs.getValueAt(i,"PAIS_OID_PAIS")));                   
                   dtoMovDiario.setTxtPais((String)rs.getValueAt(i,"DESC_PAIS"));                   
                   dtoMovDiario.setCanal(BigToLong(rs.getValueAt(i,"CANA_OID_CANA")));                   
                   dtoMovDiario.setTxtCanal((String)rs.getValueAt(i,"DESC_CANAL"));
                   dtoMovDiario.setMarca(BigToLong(rs.getValueAt(i,"MARC_OID_MARC")));
                   dtoMovDiario.setTxtMarca((String)rs.getValueAt(i,"DES_MARC"));
                   dtoMovDiario.setPeriodo(BigToLong(rs.getValueAt(i,"PERD_OID_PERI")));
                   dtoMovDiario.setTxtPeriodo((String)rs.getValueAt(i,"DES_PERIO"));
                   dtoMovDiario.setAcceso(BigToLong(rs.getValueAt(i,"ACCE_OID_ACCE")));
                   dtoMovDiario.setTxtAcceso((String)rs.getValueAt(i,"DESC_ACCES"));
                   if (uneg!=null){
                      dtoMovDiario.setUnidadNegocio(uneg);
                   } else {
                      dtoMovDiario.setUnidadNegocio(ConstantesPedFaltantes.VALOR_ALTERNATIVO);
                   }
                   dtoMovDiario.setTxtUnidadNegocio((String)rs.getValueAt(i,"DESC_UNEG"));
                   if (almac!=null){
                      dtoMovDiario.setAlmacen(almac);
                   } else {
                      dtoMovDiario.setAlmacen(ConstantesPedFaltantes.VALOR_ALTERNATIVO);
                   }
                   dtoMovDiario.setTxtAlmacen((String)rs.getValueAt(i,"DESC_ALMAC"));
                   if (negoc!=null){
                      dtoMovDiario.setNegocio(negoc);
                   } else {
                      dtoMovDiario.setNegocio(ConstantesPedFaltantes.VALOR_ALTERNATIVO);
                   }
                   dtoMovDiario.setTxtNegocio((String)rs.getValueAt(i,"DESC_NEGOC"));
                   dtoMovDiario.setIndAhorro(BigToBoolean(rs.getValueAt(i,"IND_AHORRO_GUIA")));                   
                   dtoMovDiario.setProducto(BigToLong(rs.getValueAt(i,"PROD_OID_PROD")));
                   dtoMovDiario.setStockDisponible(BigToLong(rs.getValueAt(i,"STOCK")));
                   dtoMovDiario.setUmbral(BigToDouble(rs.getValueAt(i,"UMBRAL_FALTANTES")));
                   dtoMovDiario.setOidIdioma(dtoe.getOidIdioma());                   
                   dtoMovDiario.setIndDiario(Boolean.TRUE);
                   dtoMovDiario.setDemanda(BigToLong(rs.getValueAt(i,"NUM_UNID_POR_ATEN")));
                   dtoMovDiario.setTxtProducto((String)rs.getValueAt(i,"DES_CORT"));
                   
                   dtoMovDiario.setFaltante(null);
                   dtoMovDiario.setPosicion(null);
                   dtoMovDiario.setUnidades(null);
                   
                   solicitudesMovimientos.add(dtoMovDiario);
              }             
            }
                
        }
        catch(Exception e) {
            UtilidadesLog.error("Exception: ",e);
            throw new MareException(e,
            UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS));
        }
       UtilidadesLog.debug(" sale de obtieneSolicitudesMovimientos con solicitudesMovimientos:"+ solicitudesMovimientos);
       UtilidadesLog.info("DAOInformesFaltantes.obtieneSolicitudesMovimientos(DTOInformeFaltantes dtoe): Salida ");
       return solicitudesMovimientos;         
   }
   
   //**************************************************************************************************

    private Double BigToDouble(Object num) {
        if (num != null) {
            return (new Double(((BigDecimal) num).doubleValue()));
        } else {
            return null;
        }
    }

    private Long BigToLong(Object num) {
        if (num != null) {
            return (new Long(((BigDecimal) num).longValue()));
        } else {
            return null;
        }
    }

    private Boolean BigToBoolean(Object num) {
        if (num != null) {
            return (((BigDecimal) num).longValue()>=1)?Boolean.TRUE:Boolean.FALSE;
        } else {
            return null;
        }
    }    
   //**************************************************************************************************
}