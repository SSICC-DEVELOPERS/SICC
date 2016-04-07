package es.indra.sicc.logicanegocio.mav;

import es.indra.mare.common.exception.MareException;
import es.indra.mare.common.mii.services.jdbcservice.RecordSet;

import es.indra.sicc.dtos.mav.DTOGenerarPagoIntercompanias;
import es.indra.sicc.util.BelcorpService;
import es.indra.sicc.util.CodigosError;
import es.indra.sicc.util.UtilidadesEJB;
import es.indra.sicc.util.UtilidadesError;

import es.indra.sicc.util.UtilidadesLog;
import java.rmi.RemoteException;

import java.sql.Timestamp;


public class DAOGenerarPagoIntercompanias {
    public DAOGenerarPagoIntercompanias() {}

    public RecordSet obtenerSolicitudesEnvioMAV(DTOGenerarPagoIntercompanias dto)
        throws MareException {
        UtilidadesLog.info("DAOGenerarPagoIntercompanias.obtenerSolicitudesEnvioMAV(DTOGenerarPagoIntercompanias dto):Entrada");
        BelcorpService bs;
        RecordSet resultado = new RecordSet();

        bs = UtilidadesEJB.getBelcorpService();

        StringBuffer query = new StringBuffer();

        try {
            bs = BelcorpService.getInstance();
            /*query.append(" select SE.OID_SOLI_ENVI, OD.VAL_CODI_VENT,");
            query.append(" E.CLIE_OID_CLIE, MAE.COD_CLIE,");
            query.append(" E.NUM_UNID, (E.NUM_UNID * E.VAL_PREC_STND) AS MONTO   ");
            query.append(" from MAV_SOLIC_ENVIO SE, MAV_ENVIO E, MAV_ACTIV A, PED_SOLIC_CABEC SC,");
            query.append(" PRE_MATRI_FACTU MF, PRE_OFERT_DETAL OD, MAE_CLIEN MAE ");
            query.append(" where  ");
            query.append(" SE.MENV_OID_ENVI = E.OID_ENVI and ");
            query.append(" A.OID_ACTI = E.ACTI_OID_ACTI and ");
            query.append(" SE.SOCA_OID_SOLI_CABE = SC.OID_SOLI_CABE and ");
            query.append(" MF.OID_MATR_FACT = E.MAFA_OID_MATR_FACT and ");
            query.append(" MF.OFDE_OID_DETA_OFER = OD.OID_DETA_OFER ");
            query.append(" and A.OID_ACTI = " + dto.getActividad());
            query.append(" and TRUNC(TO_DATE (substr('" + dto.getFechaDesde() + "', 1, 19), 'YYYY-MM-DD HH24:MI:SS')) < SC.FEC_CRON  ");
            query.append(" and TRUNC(TO_DATE (substr('" + dto.getFechaHasta() + "', 1, 19), 'YYYY-MM-DD HH24:MI:SS')) > SC.FEC_CRON ");
            query.append(" and MAE.OID_CLIE = E.CLIE_OID_CLIE ");
            query.append(" group by SE.OID_SOLI_ENVI, OD.VAL_CODI_VENT , E.NUM_UNID, E.VAL_PREC_STND, E.CLIE_OID_CLIE, MAE.COD_CLIE ");*/

            /* Modificado por ssantana, 11/05/2006, Inc. 23074*/
            query.append(" SELECT pre_ofert_detal.val_codi_vent, ");
            query.append(" SUM (mav_envio.num_unid) NUM_UNID, ");
            /*query.append(" SUM (mav_envio.val_prec_stnd * mav_envio.num_unid) AS monto ");*/
            query.append(" SUM(mav_envio.val_prec_stnd * mav_envio.num_unid) / SUM(mav_envio.num_unid) AS monto ");
            query.append(" FROM mav_envio, ");
            query.append(" pre_matri_factu, ");
            query.append(" pre_ofert_detal, ");
            query.append(" (SELECT mav_solic_envio.menv_oid_envi oidenvio ");
            query.append(" FROM mav_solic_envio, ped_solic_cabec, cra_perio ");
            query.append(" WHERE mav_solic_envio.soca_oid_soli_cabe = ped_solic_cabec.oid_soli_cabe ");
            
            /* Modificado por ssantana, 06/09/2006 - Fecha debe compararse con <= y >= */ 
            query.append(" AND ped_solic_cabec.fec_cron >= ");
            query.append("      TRUNC(TO_DATE(SUBSTR('" + dto.getFechaDesde() + "', 1, 19), 'YYYY-MM-DD HH24:MI:SS')) ");
            query.append(" AND ped_solic_cabec.fec_cron <= "); 
            query.append("      TRUNC(TO_DATE(SUBSTR('" + dto.getFechaHasta() + "', 1, 19), 'YYYY-MM-DD HH24:MI:SS'))  ");
            /* Modificado por ssantana, 06/09/2006 - Fecha debe compararse con <= y >= */             
            query.append(" AND ped_solic_cabec.perd_oid_peri = cra_perio.oid_peri ");
            query.append(" AND cra_perio.cana_oid_cana = " + dto.getCanal()  );
            query.append(" AND cra_perio.marc_oid_marc = " + dto.getMarca()+") envios ");
            query.append(" WHERE mav_envio.oid_envi = envios.oidenvio ");
            query.append(" AND mav_envio.mafa_oid_matr_fact = pre_matri_factu.oid_matr_fact ");
            query.append(" AND pre_matri_factu.ofde_oid_deta_ofer = pre_ofert_detal.oid_deta_ofer ");
            query.append(" AND mav_envio.acti_oid_acti = " + dto.getActividad());
            query.append(" GROUP BY pre_ofert_detal.val_codi_vent ");
            /* Fin Modificado por ssantana, 11/05/2006, Inc. 23074*/

            resultado = bs.dbService.executeStaticQuery(query.toString());
        } catch(RemoteException re) {
            throw new MareException(re, UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
        } catch(Exception e) {
            UtilidadesLog.error(e);
            throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS));
        }

        UtilidadesLog.info("DAOGenerarPagoIntercompanias.obtenerSolicitudesEnvioMAV(DTOGenerarPagoIntercompanias dto):Salida");
        return resultado;
    }

    public RecordSet obtenerPeriodosEntreFechas(Timestamp fechaInicio, Timestamp fechaFin)
        throws MareException {
        UtilidadesLog.info("DAOGenerarPagoIntercompanias.obtenerPeriodosEntreFechas(Timestamp fechaInicio, Timestamp fechaFin):Entrada");
        BelcorpService bs;
        RecordSet resultado = new RecordSet();

        bs = UtilidadesEJB.getBelcorpService();

        StringBuffer query = new StringBuffer();

        try {
            bs = BelcorpService.getInstance();
            query.append(" select OID_PERI from CRA_PERIO where ");
            query.append(" FEC_INIC <= ");
            query.append(" TRUNC(TO_DATE (substr('" + fechaInicio + "', 1, 19), 'YYYY-MM-DD HH24:MI:SS')) ");
            query.append(" and FEC_FINA >= ");
            query.append(" TRUNC(TO_DATE (substr('" + fechaFin + "', 1, 19), 'YYYY-MM-DD HH24:MI:SS')) ");

            resultado = bs.dbService.executeStaticQuery(query.toString());
        } catch(RemoteException re) {
            throw new MareException(re, UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
        } catch(Exception e) {
            UtilidadesLog.error(e);
            throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS));
        }

        UtilidadesLog.info("DAOGenerarPagoIntercompanias.obtenerPeriodosEntreFechas(Timestamp fechaInicio, Timestamp fechaFin):Salida");
        return resultado;
    }

    public static void main(String[] args) throws Exception {
        DAOGenerarPagoIntercompanias f = new DAOGenerarPagoIntercompanias();
        Timestamp a = new Timestamp(System.currentTimeMillis());
        DTOGenerarPagoIntercompanias fff = new DTOGenerarPagoIntercompanias();
        fff.setActividad(new Long(1));
        fff.setFechaDesde(a);
        fff.setFechaHasta(new Timestamp(System.currentTimeMillis()));
        f.obtenerSolicitudesEnvioMAV(fff);
    }
    
    
  /**
   * @author: ssantana, 03/07/2006
   * @return Long
   * @throws es.indra.mare.common.exception.MareException
   * @param  oidCliente
   */
    public Long obtieneTipoDocumentoPrincipalCliente(Long oidCliente) throws MareException {
        UtilidadesLog.info("DAOGenerarPagoIntercompanias.obtieneTipoDocumentoPrincipalCliente(Long oidCliente):Entrada");
        StringBuffer sqlQuery = new StringBuffer(""); 
        BelcorpService bs = BelcorpService.getInstance();
        RecordSet r = null;
        Long oidTipoDocumento = null;
        
        sqlQuery.append(" SELECT mae_clien_ident.tdoc_oid_tipo_docu ");
        sqlQuery.append(" FROM mae_clien_ident ");
        sqlQuery.append(" WHERE mae_clien_ident.clie_oid_clie = " + oidCliente);
        sqlQuery.append(" AND mae_clien_ident.val_iden_docu_prin = 1");
        
        try {
            r = bs.dbService.executeStaticQuery(sqlQuery.toString());
            UtilidadesLog.debug("r: " + r);
        } catch (Exception ex) {
            ex.printStackTrace();
            UtilidadesLog.error(ex);
            String sCodigosError = CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS;
            throw new MareException(ex, 
                                    UtilidadesError.armarCodigoError(sCodigosError));
        }
        
        /* Obtengo el Valor del tipo de Documento. */ 
        if ( !r.esVacio() ) {
           oidTipoDocumento = Long.valueOf(r.getValueAt(0,0).toString());
        }
        
        UtilidadesLog.info("DAOGenerarPagoIntercompanias.obtieneTipoDocumentoPrincipalCliente(Long oidCliente):Salida");
        return oidTipoDocumento;
    }
    
    
  /**
   * @author: ssantana, 03/07/2006
   * @throws es.indra.mare.common.exception.MareException
   * @return Long 
   * @param  oidCliente
   */
   public Long[] obtieneTipoSubtipoPrincipalCliente(Long oidCliente) 
                                                    throws MareException {
      UtilidadesLog.info("DAOGenerarPagoIntercompanias.obtieneTipoSubtipoPrincipalCliente(Long oidCliente):Entrada");
      StringBuffer sqlQuery = new StringBuffer(""); 
      BelcorpService bs = BelcorpService.getInstance();
      RecordSet r = null;
      Long[] arrayTipoSubtipo = null;
      
      sqlQuery.append(" SELECT mae_clien_tipo_subti.ticl_oid_tipo_clie, ");
      sqlQuery.append(" mae_clien_tipo_subti.sbti_oid_subt_clie ");
      sqlQuery.append(" FROM mae_clien_tipo_subti ");
      sqlQuery.append(" WHERE mae_clien_tipo_subti.ind_ppal = 1 ");
      sqlQuery.append(" AND mae_clien_tipo_subti.clie_oid_clie = " + oidCliente);
      
      try {
          r = bs.dbService.executeStaticQuery(sqlQuery.toString());
          UtilidadesLog.debug("r: " + r);
      } catch (Exception ex) {
          ex.printStackTrace();
          UtilidadesLog.error(ex);
          String sCodigosError = CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS;
          throw new MareException(ex, 
                                  UtilidadesError.armarCodigoError(sCodigosError));
      }
      
      /* Obtengo el Valor del tipo de Documento. */ 
      if (!r.esVacio()) {
         arrayTipoSubtipo = new Long[2];
         arrayTipoSubtipo[0] = Long.valueOf(r.getValueAt(0,0).toString());
         arrayTipoSubtipo[1] = Long.valueOf(r.getValueAt(0,1).toString());
      }
      
      UtilidadesLog.info("DAOGenerarPagoIntercompanias.obtieneTipoSubtipoPrincipalCliente(Long oidCliente):Salida");
      return arrayTipoSubtipo;
   }
   
   
  /**
   * @author: ssantana, 04/07/2006
   * @throws es.indra.mare.common.exception.MareException
   * @return 
   * @param oidCliente
   */
   public Long obtieneDireccionPPalCliente(Long oidCliente) 
                                                      throws MareException {
      UtilidadesLog.info("DAOGenerarPagoIntercompanias.obtieneDireccionPPalCliente(Long oidCliente):Entrada");
      StringBuffer sqlQuery = new StringBuffer("");
      BelcorpService bs = BelcorpService.getInstance();
      RecordSet r = null;
      Long oidRetorno = null;
      
      sqlQuery.append(" SELECT mae_clien_direc.oid_clie_dire ");
      sqlQuery.append(" FROM mae_clien_direc ");
      sqlQuery.append(" WHERE mae_clien_direc.clie_oid_clie = " + oidCliente);
      sqlQuery.append(" AND mae_clien_direc.ind_dire_ppal = 1 ");
      sqlQuery.append(" AND mae_clien_direc.ind_elim = 0 "); //agregado por Sapaza, incidencia V_MAE_08
      
      try {
          r = bs.dbService.executeStaticQuery(sqlQuery.toString());
          UtilidadesLog.debug("r: " + r);
      } catch (Exception ex) {
          ex.printStackTrace();
          UtilidadesLog.error(ex);
          String sCodigosError = CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS;
          throw new MareException(ex, 
                                  UtilidadesError.armarCodigoError(sCodigosError));
      }
      
      if (!r.esVacio()) {
          oidRetorno = Long.valueOf(r.getValueAt(0,0).toString());
      }
      
      UtilidadesLog.info("DAOGenerarPagoIntercompanias.obtieneDireccionPPalCliente(Long oidCliente):Salida");
      return oidRetorno;
     
   }
}