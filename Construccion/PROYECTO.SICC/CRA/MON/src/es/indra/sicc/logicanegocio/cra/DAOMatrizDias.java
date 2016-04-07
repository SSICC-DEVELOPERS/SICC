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

import es.indra.mare.common.mii.services.jdbcservice.RecordSet;
import es.indra.sicc.dtos.cra.DTOMatrizDias;
import es.indra.sicc.dtos.cra.DTOGrupoMatriz;
import es.indra.mare.common.exception.MareException;
import es.indra.mare.common.mii.MareMiiServiceNotFoundException;
import es.indra.sicc.util.BelcorpService;
import es.indra.sicc.util.CodigosError;
import es.indra.sicc.util.UtilidadesError;
import es.indra.sicc.util.UtilidadesLog;
import javax.ejb.EJBException;

public class DAOMatrizDias  {

  public DAOMatrizDias() {

  }

  public RecordSet obtieneMatrizPorPMCG (DTOMatrizDias dto) throws MareException {
        UtilidadesLog.info("DAOMatrizDias.obtieneMatrizPorPMCG (DTOMatrizDias dto):Entrada");
        StringBuffer query = new StringBuffer();

        query.append(" SELECT ");
        query.append(" matriz.oid_matr_dias as oid, ");
        query.append(" matriz.cgzo_oid_cabe_grup_zona as grupo, ");
        query.append(" matriz.cact_oid_acti as actividad, ");
        query.append(" matriz.num_dias_refe as dias, ");
        query.append(" matriz.num_dias_fina as diasFin, ");
        query.append(" matriz.num_dias_inte as diasIntervalo, ");
        query.append(" matriz.cact_oid_acti_orig as actividadOrigen, ");
        query.append(" ICabe.VAL_I18N as textoGrupo, ");
        query.append(" IActi.VAL_I18N as textoActividad, ");
        query.append(" seg_tipo_perio.num_dias as diasPeriodo, ");
        query.append(" actividad.cod_acti as codigoActividad, ");
        query.append(" actividad.clac_oid_clas_acti as claseActividad, ");
        query.append(" DECODE (actividad.cod_tipo_acti, ");
        query.append(" 0, 'Fija', ");
        query.append(" DECODE (actividad.cod_tipo_acti, ");
        query.append(" 1, 'con Origen', ");
        query.append(" 'Ref. Otra Camp.' ");
        query.append(" ) ");
        query.append(" ) AS desc_tipo, ");
        query.append(" matriz.NUM_CAMP_REFE as camp_despla, ");
        query.append(" (select iactiorig.VAL_I18N ");
        query.append(" from cra_activ origen, v_gen_i18n_sicc iactiorig ");
        query.append(" where origen.OID_ACTI = actividad.CACT_OID_ACTI ");
        query.append(" AND iactiorig.attr_enti = 'CRA_ACTIV' ");
        query.append(" AND iactiorig.idio_oid_idio = 1 ");
        query.append(" AND iactiorig.val_oid = origen.oid_acti ");
        query.append(" AND iactiorig.attr_num_atri = 1)  as nomactividadorigen ");
        query.append(" FROM cra_matri_dias matriz, cra_cabec_grupo_zona grupo,  ");
        query.append("            cra_activ actividad, seg_canal, seg_tipo_perio, ");
        query.append("            v_gen_i18n_sicc ICabe, v_gen_i18n_sicc IActi ");
        query.append(" WHERE grupo.oid_cabe_grup_zona = matriz.cgzo_oid_cabe_grup_zona ");
        query.append(" AND actividad.oid_acti = matriz.cact_oid_acti ");
        query.append(" AND grupo.pais_oid_pais = "+dto.getOidPais()+ " ");
        query.append(" AND grupo.marc_oid_marc = "+dto.getMarca()+ " ");
        query.append(" AND grupo.cana_oid_cana = "+dto.getCanal()+ " ");
        query.append(" AND seg_canal.oid_cana = grupo.cana_oid_cana ");
        query.append(" AND seg_tipo_perio.oid_tipo_peri = seg_canal.tipe_oid_tipo_peri  ");
        query.append(" AND ICabe.attr_enti = 'CRA_CABEC_GRUPO_ZONA' ");
        query.append(" AND ICabe.idio_oid_idio = "+dto.getOidIdioma()+ " ");
        query.append(" AND ICabe.val_oid = grupo.OID_CABE_GRUP_ZONA ");
        query.append(" AND ICabe.attr_num_atri = 1 ");
        query.append(" AND IActi.attr_enti = 'CRA_ACTIV' ");
        query.append(" AND IActi.idio_oid_idio = "+dto.getOidIdioma()+ " ");
        query.append(" AND IActi.val_oid = actividad.OID_ACTI ");
        query.append(" AND IActi.attr_num_atri = 1 ");
        if (dto.getGrupos().size() > 0)
            query.append(" AND (1=0 "); 
        for (int i = 0; i < dto.getGrupos().size(); i++) {
          DTOGrupoMatriz dtoG = (DTOGrupoMatriz) dto.getGrupos().get(i);
          query.append(" OR grupo.oid_cabe_grup_zona = "+dtoG.getGrupoZona()+" ");
        }
        if (dto.getGrupos().size() > 0)
            query.append(" )");
        query.append(" ORDER BY textoGrupo ");

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
        UtilidadesLog.info("DAOMatrizDias.obtieneMatrizPorPMCG (DTOMatrizDias dto):Salida");
        return rs;
  }


  /**
   * Obtiene actividad y su referencia.
   * Retorna oid, oidOrigen, diasDesplazamiento, nommbreActividad y codigoActividad.
   */
  public RecordSet obtieneActividadReferencia (Long act, Long idioma) throws MareException {
        UtilidadesLog.info("DAOMatrizDias.obtieneActividadReferencia (Long act, Long idioma):Entrada");
        StringBuffer query = new StringBuffer();

        query.append(" SELECT ");
        query.append(" actividad.oid_acti as oid, ");
        query.append(" actividad.cact_oid_acti as origen, ");
        query.append(" actividad.num_dias_desp as dias, ");
        query.append(" IActi.VAL_I18N as textoActividad, ");
        query.append(" actividad.cod_acti as codigoActividad, ");
        /*inicio enozigli 16/11/2007 COL-CRA-001*/
        query.append(" actividad.clac_oid_clas_acti as claseActividad, ");        
        query.append(" DECODE (actividad.cod_tipo_acti, ");
        query.append("  0, 'Fija', ");
        query.append("  DECODE (actividad.cod_tipo_acti, ");
        query.append("          1, 'con Origen', ");
        query.append("          'Ref. Otra Camp.' ");
        query.append("         ) ");
        query.append(" ) AS desc_tipo, ");
        query.append(" actividad.NUM_CAMP_REFE as camp_despla, ");
        query.append(" (select iactiorig.VAL_I18N ");
        query.append(" from cra_activ origen, v_gen_i18n_sicc iactiorig ");
        query.append(" where origen.OID_ACTI = actividad.CACT_OID_ACTI ");
        query.append(" AND iactiorig.attr_enti = 'CRA_ACTIV' ");
        query.append(" AND iactiorig.idio_oid_idio = "+idioma+" ");
        query.append(" AND iactiorig.val_oid = origen.oid_acti ");
        query.append(" AND iactiorig.attr_num_atri = 1)  as actividadorigen ");
        /*fin enozigli 16/11/2007 COL-CRA-001*/
        query.append(" FROM cra_activ actividad, v_gen_i18n_sicc IActi  ");
        query.append(" WHERE actividad.oid_acti = "+act+ " ");
        query.append(" AND IActi.attr_enti = 'CRA_ACTIV' ");
        query.append(" AND IActi.idio_oid_idio = "+idioma+" ");
        query.append(" AND IActi.val_oid = actividad.OID_ACTI ");
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
        UtilidadesLog.info("DAOMatrizDias.obtieneActividadReferencia (Long act, Long idioma):Salida");
        return rs;
    
  }


  public RecordSet obtieneGruposFueraMatriz (DTOMatrizDias dto) throws MareException {
        UtilidadesLog.info("DAOMatrizDias.obtieneGruposFueraMatriz (DTOMatrizDias dto):Salida");
        StringBuffer query = new StringBuffer();

        query.append(" SELECT ");
        query.append(" c.OID_CABE_GRUP_ZONA as oid, ");
        query.append(" (c.COD_GRUP || ' ' || ICabe.VAL_I18N) as descripcion ");
        query.append(" FROM cra_cabec_grupo_zona c, v_gen_i18n_sicc ICabe ");
        query.append(" WHERE NOT EXISTS (SELECT * ");
        query.append("                                   FROM cra_matri_dias m ");
        query.append("                                   WHERE m.CGZO_OID_CABE_GRUP_ZONA = c.OID_CABE_GRUP_ZONA) ");
        query.append(" AND ICabe.attr_enti = 'CRA_CABEC_GRUPO_ZONA' ");
        query.append(" AND ICabe.idio_oid_idio = "+dto.getOidIdioma()+ " ");
        query.append(" AND ICabe.val_oid = c.OID_CABE_GRUP_ZONA ");
        query.append(" AND ICabe.attr_num_atri = 1 ");
        query.append(" AND c.CANA_OID_CANA = "+dto.getCanal()+ " ");
        query.append(" AND c.MARC_OID_MARC = "+dto.getMarca()+ " ");
        query.append(" AND c.PAIS_OID_PAIS = "+dto.getOidPais()+ " ");
        query.append(" ORDER BY descripcion ");

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
        UtilidadesLog.info("DAOMatrizDias.obtieneGruposFueraMatriz (DTOMatrizDias dto):Salida");
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



}