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
 */
package es.indra.sicc.logicanegocio.cra;

import es.indra.mare.common.exception.MareException;
import es.indra.mare.common.mii.MareMiiServiceNotFoundException;
import es.indra.mare.common.mii.services.jdbcservice.RecordSet;
import es.indra.sicc.dtos.cra.ConstantesCRA;
import es.indra.sicc.util.BelcorpService;
import es.indra.sicc.util.CodigosError;
import es.indra.sicc.util.DTOOID;
import es.indra.sicc.util.DTOSalida;
import es.indra.sicc.util.UtilidadesError;

import es.indra.sicc.util.UtilidadesLog;
import java.sql.Date;
import java.text.SimpleDateFormat;

import java.util.Vector;
import java.sql.Timestamp;

import javax.ejb.EJBException;

import es.indra.sicc.util.UtilidadesPaginacion;
import es.indra.sicc.dtos.cal.DTOConsultarFechasCronograma;
import java.util.ArrayList;
import es.indra.sicc.logicanegocio.seg.ConstantesSEG;


public class DAOCronograma  {

  public DAOCronograma() {
  }

  public RecordSet obtieneCronogramaGrupoPMCP (Long pais, Long marca, Long canal, Long periodo) throws MareException {
        UtilidadesLog.info("DAOCronograma.obtieneCronogramaGrupoPMCP (Long pais, Long marca, Long canal, Long periodo):Entrada");
        StringBuffer query = new StringBuffer();

        query.append(" SELECT ");
        query.append(" crono.oid_cron_grup_zona as oid ");
        query.append(" FROM cra_crono_grupo_zona crono, cra_activ actividad ");
        query.append(" WHERE actividad.oid_acti = crono.cact_oid_acti ");
        query.append(" AND actividad.pais_oid_pais = "+pais+ " ");
        query.append(" AND actividad.marc_oid_marc = "+marca+ " ");
        query.append(" AND actividad.cana_oid_cana = "+canal+ " ");
        query.append(" AND crono.perd_oid_peri = "+periodo+ " ");

        RecordSet rs = new RecordSet();

        try {
            rs = (RecordSet) getBelcorpService().dbService.executeStaticQuery(query.toString());
        } catch (MareException me) {
            UtilidadesLog.error(me);
            throw me;
        } catch (Exception e) {
            UtilidadesLog.error(e);
            throw new MareException(e,UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS));
        }

        //if (rs.esVacio()) {
        //    throw new MareException(new Exception(),UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE));
        //}
        UtilidadesLog.info("DAOCronograma.obtieneCronogramaGrupoPMCP (Long pais, Long marca, Long canal, Long periodo):Salida");
        return rs;
  }

    /*
     * 
     * @cambio Se elimino la validacion tipoFacturacion != Mono, segun incidencia 15635.
     * @autor gdmarzi
     */
    public RecordSet obtieneTipoFacturacionMatriz (Long pais, Long marca, Long canal, Long idioma) throws MareException {
        UtilidadesLog.info("DAOCronograma.obtieneTipoFacturacionMatriz (Long pais, Long marca, Long canal, Long idioma):Entrada");
        StringBuffer query = new StringBuffer();

        query.append(" SELECT distinct ");
        query.append(" grupo.OID_CABE_GRUP_ZONA as oidGrupo, ");
        query.append(" ICabe.val_i18n as textoGrupo, ");
        query.append(" grupo.tifa_oid_tipo_fact as tipoFacturacion ");
        query.append(" FROM cra_cabec_grupo_zona grupo, cra_matri_dias matriz, ");
        query.append("            cra_activ activ, cra_clase_activ clase, v_gen_i18n_sicc ICabe ");
        query.append(" WHERE grupo.oid_cabe_grup_zona = matriz.cgzo_oid_cabe_grup_zona ");
        query.append(" AND activ.oid_acti = matriz.cact_oid_acti ");
        query.append(" AND clase.oid_clas_acti = activ.clac_oid_clas_acti ");
        query.append(" AND grupo.pais_oid_pais = "+pais+ " ");
        query.append(" AND grupo.marc_oid_marc = "+marca+ " ");
        query.append(" AND grupo.cana_oid_cana = "+canal+ " ");
        query.append(" AND clase.cod_clas_acti = '"+ConstantesCRA.CLAS_FAC+ "' ");
        query.append(" AND ICabe.attr_enti = 'CRA_CABEC_GRUPO_ZONA' ");
        query.append(" AND ICabe.idio_oid_idio = "+idioma+ " ");
        query.append(" AND ICabe.val_oid = grupo.OID_CABE_GRUP_ZONA ");
        query.append(" AND ICabe.attr_num_atri = 1 ");

        RecordSet rs = new RecordSet();

        try {
            rs = (RecordSet) getBelcorpService().dbService.executeStaticQuery(query.toString());
        } catch (MareException me) {
            UtilidadesLog.error(me);
            throw me;
        } catch (Exception e) {
            UtilidadesLog.error(e);
            throw new MareException(e,UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS));
        }

        if (rs.esVacio()) {
            throw new MareException(new Exception(),UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE));
        }
        UtilidadesLog.info("DAOCronograma.obtieneTipoFacturacionMatriz (Long pais, Long marca, Long canal, Long idioma):Salida");
        return rs;
    }


  /**
   *  Obtiene una lista con los oidCrono, oidAtividad y nombreTarea para el cronograma especificado.
   */
  public RecordSet obtieneCronogramaPMCP(Long pais, Long marca, Long canal, Long periodo) throws MareException {
        UtilidadesLog.info("DAOCronograma.obtieneCronogramaPMCP(Long pais, Long marca, Long canal, Long periodo):Entrada");
        StringBuffer query = new StringBuffer();

        query.append(" SELECT ");
        query.append(" crono.oid_cron as oid, crono.cact_oid_acti oidActiv, tarea.val_nomb_tare nombreTarea ");
        query.append(" FROM cra_crono crono, cra_activ actividad, cra_tarea tarea ");
        query.append(" WHERE actividad.oid_acti = crono.cact_oid_acti ");
        query.append(" AND crono.oid_cron = tarea.cron_oid_cron(+) ");
        query.append(" AND actividad.pais_oid_pais = "+pais+ " ");
        query.append(" AND actividad.marc_oid_marc = "+marca+ " ");
        query.append(" AND actividad.cana_oid_cana = "+canal+ " ");
        query.append(" AND crono.perd_oid_peri = "+periodo+ " ");

        RecordSet rs = new RecordSet();

        try {
            rs = (RecordSet) getBelcorpService().dbService.executeStaticQuery(query.toString());
        } catch (MareException me) {
            UtilidadesLog.error(me);
            throw me;
        } catch (Exception e) {
            UtilidadesLog.error(e);
            throw new MareException(e,UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS));
        }

        //if (rs.esVacio()) {
        //    throw new MareException(new Exception(),UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE));
        //}
        UtilidadesLog.info("DAOCronograma.obtieneCronogramaPMCP(Long pais, Long marca, Long canal, Long periodo):Salida");
        return rs;
  }

  public RecordSet obtieneCronograma (Long pais, Long marca, Long canal, Long periodo, Long grupo, 
                                                          Long subgerencia, Long region, Long zona, Long idioma) throws MareException {
        //idioma no está en diseño                                                          
        UtilidadesLog.info("DAOCronograma.obtieneCronograma (Long pais, Long marca, Long canal, Long periodo, Long grupo, "+
                                                          "Long subgerencia, Long region, Long zona, Long idioma):Entrada");
        StringBuffer query = new StringBuffer();

        query.append(" SELECT ");
        query.append(" crono.oid_cron as oid, ");
        query.append(" crono.perd_oid_peri as periodo, ");
        query.append(" crono.zscc_oid_secc as seccion, ");
        query.append(" crono.cact_oid_acti as actividad, ");
        query.append(" crono.cod_tipo_dias as tipodias, ");
        query.append(" crono.fec_inic as fechaini, ");
        query.append(" crono.fec_medi as fechamedia, ");
        query.append(" crono.fec_fina as fechafin, ");
        query.append(" crono.zzon_oid_zona as zona, ");
        query.append(" crono.tifa_oid_tipo_fact as tipofac, ");
        //Inc. 5635
        //query.append(" crono.cact_oid_acti_orig as actividadorigen, ");
        query.append(" crono.cod_vist_orig as actividadorigen, ");
        query.append(" crono.cod_vist as codvista, ");
        
        query.append(" crono.val_fec0 as fecha0, ");
        query.append(" act.cod_acti as codigo, ");
        query.append(" perio.fec_inic as fechainiperiodo, ");
        query.append(" perio.fec_fina as fechafinperiodo, ");
        query.append(" zona.des_zona as textozona, ");
        query.append(" IActi.val_i18n as textoactividad, ");
        query.append(" crono.ind_fija as indfija, ");
        query.append(" TO_CHAR(crono.fec_inic, 'HH24:mi:ss') AS HoraIni, ");
        query.append(" crono.NUM_DIAS_DESP, ");
        query.append(" crono.IND_PEND_ORIG, ");
        query.append(" crono.PERD_OID_PERI_REFE, ");
        query.append(" act.COD_TIPO_ACTI, ");
        query.append(" ( select cp.VAL_NOMB_PERI from cra_perio cp ");
        query.append("   where cp.OID_PERI = crono.PERD_OID_PERI_REFE) AS VAL_NOMB_PERI_REFE, ");
        query.append(" ( select orig.COD_ACTI from cra_activ act, cra_activ orig "); 
        query.append("   where act.OID_ACTI = crono.cact_oid_acti and act.CACT_OID_ACTI = orig.OID_ACTI ) AS COD_ACTIV_ORIG, ");
        query.append(" ( select PQ_APL_AUX.Valor_Gen_I18n_Sicc( " + ConstantesSEG.IDIOMA_DEFECTO + ", orig.OID_ACTI, 'CRA_ACTIV') ");
        query.append("   from cra_activ act, cra_activ orig where act.OID_ACTI = crono.cact_oid_acti and act.CACT_OID_ACTI = orig.OID_ACTI ) AS NOMB_ACTIV_ORIG ");

        query.append(" FROM cra_crono crono, cra_activ act, zon_regio region, zon_zona zona, ");
        query.append("            cra_detal_grupo_zona deta, cra_perio perio, v_gen_i18n_sicc IActi ");
        query.append(" WHERE act.oid_acti = crono.cact_oid_acti ");
        query.append(" AND region.oid_regi = zona.zorg_oid_regi ");
        query.append(" AND zona.oid_zona = crono.zzon_oid_zona ");
        query.append(" AND zona.oid_zona = deta.zzon_oid_zona ");
        query.append(" AND perio.oid_peri = crono.perd_oid_peri ");
        //Segun Incidencia 4386
        //query.append(" AND zona.oid_zona = seccion.zzon_oid_zona ");
        if (pais != null)
            query.append(" AND act.pais_oid_pais = "+pais+ " ");
        if (marca != null)
            query.append(" AND act.marc_oid_marc = "+marca+ " ");
        if (canal != null)
            query.append(" AND act.cana_oid_cana = "+canal+ " ");
        if (periodo != null)
            query.append(" AND crono.perd_oid_peri = "+periodo+ " ");
        if (grupo != null)
            query.append(" AND deta.cgzo_oid_cabe_grup_zona = "+grupo+ " ");
        if (subgerencia != null)
            query.append(" AND region.zsgv_oid_subg_vent = "+subgerencia+ " ");
        if (region != null)
            query.append(" AND region.oid_regi = "+region+ " ");
        if (zona != null)
            query.append(" AND zona.oid_zona = "+zona+ " ");
        query.append(" AND IActi.attr_enti = 'CRA_ACTIV' ");
        query.append(" AND IActi.idio_oid_idio = "+idioma+ " ");
        query.append(" AND IActi.val_oid = act.OID_ACTI ");
        query.append(" AND IActi.attr_num_atri = 1 ");
        
        RecordSet rs = new RecordSet();

        try {
            rs = (RecordSet) getBelcorpService().dbService.executeStaticQuery(query.toString());
        } catch (MareException me) {
            UtilidadesLog.error(me);
            throw me;
        } catch (Exception e) {
            UtilidadesLog.error(e);
            throw new MareException(e,UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS));
        }

        if (rs.esVacio()) {
            throw new MareException(new Exception(),UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE));
        }
        UtilidadesLog.info("DAOCronograma.obtieneCronograma (Long pais, Long marca, Long canal, Long periodo, Long grupo, "+
                                                          "Long subgerencia, Long region, Long zona, Long idioma):Salida");
        
        return rs;
  }

  public RecordSet obtieneZonasDeGrupo (Long grupo) throws MareException {
        UtilidadesLog.info("DAOCronograma.obtieneZonasDeGrupo (Long grupo):Entrada");
        
        StringBuffer query = new StringBuffer();

        query.append(" SELECT ");
        query.append(" zona.oid_zona as oid, ");
        query.append(" zona.des_zona as descripcion ");
        query.append(" FROM cra_detal_grupo_zona deta, zon_zona zona ");
        query.append(" WHERE zona.oid_zona = deta.zzon_oid_zona ");
        query.append(" AND deta.cgzo_oid_cabe_grup_zona = "+grupo+ " ");

        RecordSet rs = new RecordSet();

        try {
            rs = (RecordSet) getBelcorpService().dbService.executeStaticQuery(query.toString());
        } catch (MareException me) {
            UtilidadesLog.error(me);
            throw me;
        } catch (Exception e) {
            UtilidadesLog.error(e);
            throw new MareException(e,UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS));
        }

        if (rs.esVacio()) {
            throw new MareException(new Exception(),UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE));
        }
        UtilidadesLog.info("DAOCronograma.obtieneZonasDeGrupo (Long grupo):Salida");
        return rs;
  }

  public RecordSet obtieneTransaccionesActividad (Long actividad) throws MareException {
        UtilidadesLog.info("DAOCronograma.obtieneTransaccionesActividad (Long actividad):Entrada");
        StringBuffer query = new StringBuffer();

        query.append(" SELECT ");
        query.append(" TA.OID_TRAN_ACTI as oid, ");
        query.append(" TA.FEC_TRAN_ACTI as fecha, ");
        query.append(" T.COD_PROC as codigo, ");
        query.append(" T.VAL_EJEC as ejecutable, ");
        query.append(" T.VAL_PARA as parametros ");
        query.append(" FROM CRA_TRANS_ACTIV TA, CRA_TRANS T ");
        query.append(" WHERE TA.TRAN_OID_TRAN = T.OID_TRAN ");
        query.append(" AND TA.CACT_OID_ACTI = "+actividad+ " ");

        RecordSet rs = new RecordSet();

        try {
            rs = (RecordSet) getBelcorpService().dbService.executeStaticQuery(query.toString());
        } catch (MareException me) {
            UtilidadesLog.error(me);
            throw me;
        } catch (Exception e) {
            UtilidadesLog.error(e);
            throw new MareException(e,UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS));
        }

        //if (rs.esVacio()) {
        //    throw new MareException(new Exception(),UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE));
        //}
        UtilidadesLog.info("DAOCronograma.obtieneTransaccionesActividad (Long actividad):Salida");
        return rs;
  }

  public RecordSet obtieneMensajesPeriodo (Long periodo) throws MareException {
        UtilidadesLog.info("DAOCronograma.obtieneMensajesPeriodo (Long periodo):Entrada");
        StringBuffer query = new StringBuffer();

        query.append(" SELECT ");
        query.append(" CLIE_OID_CLIE as cliente, ");
        query.append(" FEC_MENS as fecha, ");
        query.append(" NUM_MENS as numero ");
        query.append(" FROM CRA_MENSA ");
        query.append(" WHERE PERD_OID_PERI = "+periodo+ " ");

        RecordSet rs = new RecordSet();

        try {
            rs = (RecordSet) getBelcorpService().dbService.executeStaticQuery(query.toString());
        } catch (MareException me) {
            UtilidadesLog.error(me);
            throw me;
        } catch (Exception e) {
            UtilidadesLog.error(e);
            throw new MareException(e,UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS));
        }

        //if (rs.esVacio()) {
        //    throw new MareException(new Exception(),UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE));
        //}
        UtilidadesLog.info("DAOCronograma.obtieneMensajesPeriodo (Long periodo):Salida");
        return rs;
  }

  public RecordSet obtieneZonasPorGrupo (Long grupo) throws MareException {
        UtilidadesLog.info("DAOCronograma.obtieneZonasPorGrupo (Long grupo):Entrada");
        StringBuffer query = new StringBuffer();

        query.append(" SELECT ");
        query.append(" zona.oid_zona as oid, ");
        query.append(" zona.des_zona as descripcion ");
        query.append(" FROM cra_detal_grupo_zona deta, zon_zona zona ");
        query.append(" WHERE zona.oid_zona = deta.zzon_oid_zona ");
        query.append(" AND deta.cgzo_oid_cabe_grup_zona = "+grupo+ " ");

        RecordSet rs = new RecordSet();

        try {
            rs = (RecordSet) getBelcorpService().dbService.executeStaticQuery(query.toString());
        } catch (MareException me) {
            UtilidadesLog.error(me);
            throw me;
        } catch (Exception e) {
            UtilidadesLog.error(e);
            throw new MareException(e,UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS));
        }

        if (rs.esVacio()) {
            throw new MareException(new Exception(),UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE));
        }
        UtilidadesLog.info("DAOCronograma.obtieneZonasPorGrupo (Long grupo):Salida");
        return rs;
  }


  private BelcorpService getBelcorpService() {
       try  {
            return BelcorpService.getInstance();
        } catch (MareMiiServiceNotFoundException mmsnfe)  {
            throw new EJBException( "MareMiiServiceNotFoundException: "
                        + mmsnfe.getMessage(), mmsnfe);
        } 
    }


    /**
     * Obtiene los registros de cronograma que tengan las siguientes condiciones de filtrado:
     * periodo, zona, actividad y cuya fecha inicio sea mayor o igual que la fecha del sistema. 
     * @autor gdmarzi del cambio: se modifico el ultimo filtro del where por la incidencia 11261.
     */
    public RecordSet obtieneCronogramaZPAFechaActual(Long zona, Long periodo,Long actividad) throws MareException  {
        UtilidadesLog.info("DAOCronograma.obtieneCronogramaZPAFechaActual(Long zona, Long periodo,Long actividad):Entrada");
        
        Vector parametros = new Vector();
        //Obtiene los registros de cronograma que tengan las siguientes condiciones de filtrado: periodo, zona, actividad y
        //cuya fecha final sea mayor o igual que la fecha del sistema.
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        java.sql.Date dia = new java.sql.Date( System.currentTimeMillis());
        String sDia = sdf.format(dia);
    
        StringBuffer query = new StringBuffer();
        query.append(" SELECT ");
        query.append(" crono.oid_cron as oid, ");
        query.append(" crono.perd_oid_peri as periodo, ");
        query.append(" crono.zscc_oid_secc as seccion, ");
        query.append(" crono.cact_oid_acti as actividad, ");
        query.append(" crono.cod_tipo_dias as tipodias, ");
        query.append(" crono.fec_inic as fechaini, ");
        query.append(" crono.fec_medi as fechamedia, ");
        query.append(" crono.fec_fina as fechafin, ");
        query.append(" crono.zzon_oid_zona as zona, ");
        query.append(" crono.tifa_oid_tipo_fact as tipofac, ");
        query.append(" crono.cod_vist_orig as actividadorigen, ");
        query.append(" crono.val_fec0 as fecha0, ");
        query.append(" crono.ind_fija as indfija ");
        query.append(" FROM cra_crono crono ");
        query.append(" WHERE 1=1 ");
        //Si el parámetro de cada condición es null no se añadirá esa condición de filtrado.
        if (periodo != null) {
            query.append(" AND crono.perd_oid_peri = ? " );
            parametros.add(periodo);
        }
        if (zona != null) {
            query.append("     AND crono.zzon_oid_zona = ? " );
            parametros.add(zona);
        }
        if (actividad != null) {
            query.append(" AND crono.cact_oid_acti = ? " );
            parametros.add(actividad);
        }
        query.append(" AND (crono.fec_inic >= TO_DATE('" + sDia +"','YYYY-MM-DD'))  ");
        query.append(" ORDER BY crono.fec_inic ");

        //ejecución de la consulta
        RecordSet rs = new RecordSet();
        try {
        rs = getBelcorpService().dbService.executePreparedQuery( query.toString(), parametros);
        } catch (MareException me) {
            UtilidadesLog.error(me);
            throw me;
        } catch (Exception e) {
            UtilidadesLog.error(e);
            throw new MareException(e,UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS) );
        }
        if (rs.esVacio()) {
            throw new MareException(new Exception(),UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE));
        }
        UtilidadesLog.info("DAOCronograma.obtieneCronogramaZPAFechaActual(Long zona, Long periodo,Long actividad):Salida");
        return rs;
    }


    //VER Incidencia 6036
    public RecordSet obtieneReferenciadas(Long actividadOrigen, Long idioma) throws MareException {
        UtilidadesLog.info("DAOCronograma.obtieneReferenciadas(Long actividadOrigen, Long idioma):Entrada");
        StringBuffer query = new StringBuffer();

        query.append(" SELECT ");
        query.append(" act.oid_acti oid, ");
        query.append(" act.cod_acti codigo, ");
        query.append(" IActi.val_i18n as nombre, ");
        query.append(" act.num_dias_desp dias, ");
        query.append(" act.ind_labo laborables ");
        query.append(" FROM cra_activ act, v_gen_i18n_sicc IActi ");
        query.append(" WHERE act.cact_oid_acti = "+actividadOrigen+ " ");
        query.append(" AND IActi.attr_enti = 'CRA_ACTIV' ");
        query.append(" AND IActi.idio_oid_idio = "+idioma+ " ");
        query.append(" AND IActi.val_oid = act.OID_ACTI ");
        query.append(" AND IActi.attr_num_atri = 1 ");

        RecordSet rs = new RecordSet();

        try {
            rs = (RecordSet) getBelcorpService().dbService.executeStaticQuery(query.toString());
        } catch (MareException me) {
            UtilidadesLog.error(me);
            throw me;
        } catch (Exception e) {
            UtilidadesLog.error(e);
            throw new MareException(e,UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS));
        }
        UtilidadesLog.info("DAOCronograma.obtieneReferenciadas(Long actividadOrigen, Long idioma):Salida");
        return rs;
      
    }

    //Incidencia 10038
    // Obtiene las actividades que se pueden incluir en un cronograma, es decir, aquellas que no se encuentren 
    //en el RecodSet recibido como parámetro 
    public RecordSet obtieneNuevasActividadesCronograma (Long oidPais, Long oidMarca, 
                                            Long oidCanal, RecordSet actividadesCronograma, Long idioma) throws MareException {
        UtilidadesLog.info("DAOCronograma.obtieneNuevasActividadesCronograma (Long oidPais, Long oidMarca," +
                                            "Long oidCanal, RecordSet actividadesCronograma, Long idioma):Entrada");
        StringBuffer query = new StringBuffer();

        query.append(" SELECT act.OID_ACTI, IActi.val_i18n as nombre, act.IND_LABO, act.COD_ACTI ");
        query.append(" FROM cra_activ act, v_gen_i18n_sicc IActi ");
        query.append(" WHERE act.PAIS_OID_PAIS = "+oidPais+ " ");
        query.append(" AND act.MARC_OID_MARC = "+oidMarca+ " ");
        query.append(" AND act.CANA_OID_CANA = "+oidCanal+ " ");
        query.append(" AND IActi.attr_enti = 'CRA_ACTIV' ");
        query.append(" AND IActi.idio_oid_idio = "+idioma+ " ");
        query.append(" AND IActi.val_oid = act.OID_ACTI ");
        query.append(" AND IActi.attr_num_atri = 1 ");
        if (actividadesCronograma != null && actividadesCronograma.getRowCount() > 0) { 
            query.append(" AND act.OID_ACTI NOT IN ( ");
            for (int i = 0; i < actividadesCronograma.getRowCount() - 1; i++) {
                query.append(actividadesCronograma.getValueAt(i,0) + ", ");
            }
            query.append(actividadesCronograma.getValueAt(actividadesCronograma.getRowCount() - 1,0) + ") ");
        }
        query.append(" ORDER BY 2 ");

        RecordSet rs = new RecordSet();

        try {
            rs = (RecordSet) getBelcorpService().dbService.executeStaticQuery(query.toString());
        } catch (MareException me) {
            UtilidadesLog.error(me);
            throw me;
        } catch (Exception e) {
            UtilidadesLog.error(e);
            throw new MareException(e,UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS));
        }
        UtilidadesLog.info("DAOCronograma.obtieneNuevasActividadesCronograma (Long oidPais, Long oidMarca," +
                                            "Long oidCanal, RecordSet actividadesCronograma, Long idioma):Salida");
        return rs;
    }
    
    public DTOSalida consultarFechasCronograma(DTOConsultarFechasCronograma dto) throws MareException {
      UtilidadesLog.info("DAOCronograma.consultarFechasCronograma(DTOConsultarFechasCronograma dto):Entrada");
    
      DTOSalida dtoSalida = new DTOSalida();
      StringBuffer query = new StringBuffer();
      RecordSet rs;

      query.append(" SELECT A.oid_cron as oid, ");   
      query.append(" D.val_i18n as tipoPeriodo, ");   
      query.append(" B.val_nomb_peri as periodo, ");   
      query.append(" E.cod_acti as codActividad, ");   
      query.append(" F.val_i18n as descActividad, ");   
      query.append(" A.fec_inic as fechaActividad ");         
      query.append(" FROM cra_crono A, ");
      query.append(" cra_perio B, ");   
      query.append(" seg_perio_corpo C, ");   
      query.append(" v_gen_i18n_sicc D, ");   
      query.append(" cra_activ E, ");   
      query.append(" v_gen_i18n_sicc F ");         
      query.append(" WHERE A.oid_cron > " + dto.getIndicadorSituacion() + " AND ");
      query.append(" A.perd_oid_peri = " + dto.getOidPeriodo() + " AND ");   
      query.append(" A.zzon_oid_zona = " + dto.getOidZona() + " AND ");   
      query.append(" B.oid_peri = A.perd_oid_peri AND ");   
      query.append(" C.oid_peri = B.peri_oid_peri AND ");   
      query.append(" D.attr_enti = 'SEG_TIPO_PERIO' AND  ");   
      query.append(" D.attr_num_atri = 1 AND ");   
      query.append(" D.idio_oid_idio = " + dto.getOidIdioma() + " AND ");         
      query.append(" D.val_oid = C.tipe_oid_tipo_peri AND ");   
      query.append(" E.oid_acti = A.cact_oid_acti AND  ");   
      query.append(" F.attr_enti = 'CRA_ACTIV' AND ");   
      query.append(" F.attr_num_atri = 1 AND ");   
      query.append(" F.idio_oid_idio = " + dto.getOidIdioma() + " AND ");   
      query.append(" F.val_oid = E.oid_acti ");   
      
      try {
        rs = BelcorpService.getInstance().dbService.executeStaticQuery(UtilidadesPaginacion.armarQueryPaginacion(query.toString(),dto));
      }
      catch (Exception e) {
        UtilidadesLog.error(e);
        throw new MareException(e,UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS));
      }
      
      if (rs.esVacio()) {
        throw new MareException(new Exception(),UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE));
      }
      dtoSalida.setResultado(rs);
      UtilidadesLog.info("DAOCronograma.consultarFechasCronograma(DTOConsultarFechasCronograma dto):Salida");
      return dtoSalida;          
    }

    public Timestamp obtenerMayorFechaFacturacion (DTOOID dto) throws MareException {
        UtilidadesLog.info("DAOCronograma.obtenerMayorFechaFacturacion (DTOOID dto):Entrada");
        Timestamp fecha = null;
        
        StringBuffer query = new StringBuffer();

        query.append(" SELECT MAX(CRA.FEC_INIC) FECHA ");
        query.append(" FROM CRA_CRONO CRA, ");
        query.append(" 	 ZON_ZONA ZON, ");
        query.append(" 	 CRA_ACTIV ACT, ");
        query.append(" 	 CRA_CLASE_ACTIV CLASE ");
        query.append(" WHERE CRA.ZZON_OID_ZONA = ZON.OID_ZONA ");
        query.append("   AND ACT.OID_ACTI = CRA.CACT_OID_ACTI ");
        query.append("   AND CLASE.OID_CLAS_ACTI = ACT.CLAC_OID_CLAS_ACTI ");
        query.append("   AND CLASE.COD_CLAS_ACTI = '" + ConstantesCRA.COD_CLASE_ACTIVIDAD_FACTURACION + "' ");
        query.append("   AND CRA.PERD_OID_PERI = " + dto.getOid() + " ");

        RecordSet rs = new RecordSet();

        try {
            rs = (RecordSet) getBelcorpService().dbService.executeStaticQuery(query.toString());
           
        } catch (MareException me) {
            UtilidadesLog.error(me);
            throw me;
        } catch (Exception e) {
            UtilidadesLog.error(e);
            throw new MareException(e,UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS));
        }
        if ((!rs.esVacio())&&(rs.getValueAt(0,0)!=null)){
            Date fec = (Date)rs.getValueAt(0,0);
            fecha = new Timestamp(fec.getTime());
        }
        UtilidadesLog.info("DAOCronograma.obtenerMayorFechaFacturacion (DTOOID dto):Salida");
        return fecha;
    }


    /**
     * El objetivo de este método es obtener los procesos asociados a una actividad, es decir,
     * los procesos que se deben invocar cuando la actividad se activa. 
     * Para Quartz.
     */
    public ArrayList obtenerProcesosAsociadosActividad(Long oidActividad) throws MareException {
        UtilidadesLog.info("DAOCronograma.obtenerProcesosAsociadosActividad(Long oidActividad):Entrada");
        // 1.-Se accede a la tabla TransaccionesPorActividad filtrando por el oid de la actividad,
        // para recuperar en Transaciones todos los registros asociados que no tengan el campo "ejecutable" a null.
        // Devolvemos un arrayList con los contenidos de la columna "VAL_PROG_EJEC", ordenados segun su oid. 
        StringBuffer query = new StringBuffer();
        RecordSet rs = new RecordSet();
        ArrayList programas = new ArrayList();

        query.append(" SELECT VAL_PROG_EJEC ");
        query.append(" FROM ");
        query.append("  CRA_TRANS, CRA_TRANS_ACTIV ");
        query.append(" WHERE ");
        query.append("  CRA_TRANS.OID_TRAN = CRA_TRANS_ACTIV.TRAN_OID_TRAN ");
        query.append("  AND VAL_PROG_EJEC IS NOT NULL ");
        query.append("  AND CRA_TRANS_ACTIV.CACT_OID_ACTI = " + oidActividad );

        try {
            rs = (RecordSet) getBelcorpService().dbService.executeStaticQuery(query.toString());
           
        } catch (MareException me) {
            UtilidadesLog.error(me);
            throw me;
        } catch (Exception e) {
            UtilidadesLog.error(e);
            throw new MareException(e,UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS));
        }
        
        // Armamos un arrayList con los programas a ajecutar sobre esta actividad
        for(int pos=0; pos < rs.getRowCount(); pos++) {
            String programaEjecutar = (String)rs.getValueAt(pos,"VAL_PROG_EJEC");
            programas.add(programaEjecutar);
        }
        UtilidadesLog.info("DAOCronograma.obtenerProcesosAsociadosActividad(Long oidActividad):Salida");
        return programas;
    }


}