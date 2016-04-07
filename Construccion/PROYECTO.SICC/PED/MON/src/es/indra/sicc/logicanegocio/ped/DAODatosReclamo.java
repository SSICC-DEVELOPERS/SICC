/**
 * Copyright 2005 © por Indra Sistemas,S.A.. Todos los derechos reservados.
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
 *
 * @author: Emilio Noziglia
 * Fecha: 15/10/2005
 * 
 */

package es.indra.sicc.logicanegocio.ped;

import es.indra.mare.common.mii.services.jdbcservice.RecordSet;
import es.indra.mare.common.exception.MareException;
import es.indra.sicc.util.BelcorpService;
import es.indra.sicc.util.CodigosError;
import es.indra.sicc.util.UtilidadesError;
import es.indra.sicc.util.UtilidadesLog;
import es.indra.sicc.logicanegocio.seg.ConstantesSEG;
import java.util.ArrayList;



public class DAODatosReclamo  {
  private UtilidadesLog log = new UtilidadesLog();
    
  public DAODatosReclamo() {
  }
   
  
  /**
   * @author Emilio Noziglia
   * @since 15/10/2005
   * @param Long oidPais
   * @param Long oidSolicitud
   * @return RecordSet 
   * @throws MareException
   * @reference UBEL004
   */    
  public RecordSet obtenerDatosCliente(Long oidSolicitud, Long oidPais)
    throws MareException {
    UtilidadesLog.info("DAODatosReclamo.obtenerDatosCliente(Long oidSolicitud, "
                      + "Long oidPais:Entrada");
    RecordSet rRetorno = null;
    StringBuffer sqlQuery = new StringBuffer("");
    Long idioma = ConstantesSEG.IDIOMA_DEFECTO;

    //gPineda - 26/01/2007 - DBLG700000310
/*    sqlQuery.append(" SELECT mae_clien.cod_clie, PQ_APL_AUX.Valor_Gen_I18n_Sicc( "+idioma );
    sqlQuery.append("      ,spc.OID_PERI,'SEG_PERIO_CORPO')  peri1 , ");
    sqlQuery.append("      ped_solic_cabec_original.soca_oid_docu_refe,  ");
    sqlQuery.append("         PQ_APL_AUX.Valor_Gen_I18n_Sicc( "+idioma);
    sqlQuery.append("      ,spc2.OID_PERI,'SEG_PERIO_CORPO')  peri2 , mae_clien.val_nom1,  "); */
    sqlQuery.append(" SELECT mae_clien.cod_clie, " );
    sqlQuery.append("      spc.COD_PERI peri1 , ");
    sqlQuery.append("      ped_solic_cabec_original.soca_oid_docu_refe,  ");
    sqlQuery.append("      spc2.COD_PERI peri2 , mae_clien.val_nom1,  "); 
    
    sqlQuery.append("      mae_clien.val_nom2, mae_clien.val_ape1, mae_clien.val_ape2  ");
    sqlQuery.append("      FROM ped_solic_cabec ped_solic_cabec_original,  ");
    sqlQuery.append("      ped_solic_cabec ped_solic_cabec_buffer,  ");
    sqlQuery.append("      mae_clien , ");
    sqlQuery.append(" 		 cra_perio cp, ");
    sqlQuery.append(" 		 seg_perio_corpo spc, ");
    sqlQuery.append(" 		 cra_perio cp2, ");
    sqlQuery.append(" 		 seg_perio_corpo spc2 ");
    sqlQuery.append("      WHERE ped_solic_cabec_original.clie_oid_clie = mae_clien.oid_clie  ");
    sqlQuery.append("      AND ped_solic_cabec_original.soca_oid_docu_refe =   ");
    sqlQuery.append("                         ped_solic_cabec_buffer.oid_soli_cabe  ");
    sqlQuery.append("      AND ped_solic_cabec_original.oid_soli_cabe = " + oidSolicitud);
    sqlQuery.append("      AND mae_clien.pais_oid_pais = "+ oidPais);
    sqlQuery.append(" 	   AND   ped_solic_cabec_buffer.PERD_OID_PERI = cp.oid_peri ");
    sqlQuery.append("      AND cp.peri_oid_peri = spc.OID_PERI ");
    sqlQuery.append("      AND   ped_solic_cabec_original.perd_oid_peri = cp2.oid_peri ");
    sqlQuery.append("      AND cp2.peri_oid_peri = spc2.OID_PERI ");

    
    try { 
       BelcorpService bs = BelcorpService.getInstance();
       rRetorno = bs.dbService.executeStaticQuery(sqlQuery.toString());
    } catch (Exception ex) {
       UtilidadesLog.error(ex);
       String sCodigoError = CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS;
       throw new MareException(ex, UtilidadesError.armarCodigoError(sCodigoError));
    }
    
    if(log.isDebugEnabled()) //sapaza -- cambio Optimizacion Logs -- 23/03/2010                
      UtilidadesLog.debug("rRetorno: " + rRetorno);
      
    UtilidadesLog.info("DAODatosReclamo.obtenerDatosCliente(Long oidSolicitud, Long oidPais)"
                       + ":Salida");
    return rRetorno;
    
  }
  
  
  /**
   * @author Emilio Noziglia
   * @since 15/10/2005
   * @param String codigoVenta
   * @param Long subacceso
   * @param Long acceso
   * @param Long canal
   * @param Long pais
   * @param Long oid
   * @return RecordSet 
   * @throws MareException
   * @reference UBEL004
   * @cambio jpbosnja- Se cambio el metodo para que no traiga las internacionalizaciones 
   * por performance
   * @cambio Se comenta el procedure para solucionar la bloqueante REC-03
   * @cambio Se vuelve a poner el procedure modificado
   */  
  public RecordSet obtenerDatosMensaje(Long oid, 
                                       Long pais, 
                                       Long subacceso,
                                       Long acceso, 
                                       Long canal, 
                                       String codigoVenta,
                                       String oidsProducto) throws MareException {
      UtilidadesLog.info("DAODatosReclamo.obtenerDatosMensaje(Long oid, "+
                                      " Long pais, "+
                                      " Long subacceso,"+
                                      " Long acceso, "+
                                      " Long canal, "+
                                      " String codigoVenta ):Entrada");
                                       
      RecordSet rRetorno = null;
      Long idioma = ConstantesSEG.IDIOMA_DEFECTO;
      
      /*UtilidadesLog.info("MAD Solicitud : " + oid);
      UtilidadesLog.info("MAD Pais : " + pais);
      UtilidadesLog.info("MAD Canal : " + canal);
      UtilidadesLog.info("MAD Acceso : " + acceso);
      UtilidadesLog.info("MAD Subacceso : " + subacceso);
      UtilidadesLog.info("MAD Codigoventa : " + codigoVenta);
      
      StringBuffer sqlQuery = new StringBuffer("");
      
      sqlQuery.append("  SELECT ped_solic_cabec.val_nume_soli, rec_cabec_recla.num_aten, ");
      sqlQuery.append("               rec_opera_recla.num_secu_oper, ");
      sqlQuery.append("               rec_linea_opera_recla.num_unid_recl, rec_opera.cod_oper, ");
      sqlQuery.append("               rec_motiv_recha_desbl.cod_rech_desb, ");
      sqlQuery.append("               rec_estad_opera.cod_esta_oper, rec_preci.cod_prec, ");
      sqlQuery.append("               msg_mensa.cod_mens, PQ_APL_AUX.Valor_Gen_I18n_Sicc( "+idioma+" ,rec_opera.OID_OPER,'REC_OPERA') descrip , ");
      sqlQuery.append("               pre_ofert_detal.val_codi_vent, ");
      sqlQuery.append("               rec_tipos_opera.val_info_ebel_noti ");
      sqlQuery.append("          FROM ped_solic_cabec, ");
      sqlQuery.append("               rec_solic_opera, ");
      sqlQuery.append("               seg_subac, ");
      sqlQuery.append("               seg_acces, ");
      sqlQuery.append("               seg_canal, ");
      sqlQuery.append("               rec_cabec_recla, ");
      sqlQuery.append("               rec_opera_recla, ");
      sqlQuery.append("               rec_linea_opera_recla, ");
      sqlQuery.append("               pre_matri_factu, ");
      sqlQuery.append("               pre_ofert_detal, ");
      sqlQuery.append("               rec_tipos_opera, ");
      sqlQuery.append("               rec_opera, ");
      sqlQuery.append("               msg_mensa, ");
      sqlQuery.append("               rec_preci, ");
      sqlQuery.append("               rec_motiv_recha_desbl, ");
      sqlQuery.append("               rec_estad_opera ");
      sqlQuery.append("         WHERE ped_solic_cabec.oid_soli_cabe = " + oid );
      sqlQuery.append("           AND rec_solic_opera.opre_oid_oper_recl = ");
      sqlQuery.append("                                                   rec_opera_recla.oid_oper_recl ");
      sqlQuery.append("           AND ped_solic_cabec.oid_soli_cabe = ");
      sqlQuery.append("                                              rec_solic_opera.soca_oid_soli_cabe ");
      sqlQuery.append("           AND ped_solic_cabec.pais_oid_pais = "+ pais);
      sqlQuery.append("           AND ped_solic_cabec.sbac_oid_sbac = "+ subacceso);
      sqlQuery.append("           AND ped_solic_cabec.sbac_oid_sbac = seg_subac.oid_sbac ");
      sqlQuery.append("           AND seg_subac.acce_oid_acce = seg_acces.oid_acce ");
      sqlQuery.append("           AND seg_acces.oid_acce = "+acceso);
      sqlQuery.append("           AND seg_acces.cana_oid_cana = "+canal);
      sqlQuery.append("           AND seg_acces.cana_oid_cana = seg_canal.oid_cana ");
      sqlQuery.append("           AND rec_cabec_recla.oid_cabe_recl = ");
      sqlQuery.append("                                              rec_opera_recla.care_oid_cabe_recl ");
      sqlQuery.append("           AND rec_solic_opera.tspa_oid_tipo_soli_pais = ");
      sqlQuery.append("                                   rec_linea_opera_recla.tspa_oid_tipo_soli_pais ");
      sqlQuery.append("           AND rec_opera_recla.oid_oper_recl = ");
      sqlQuery.append("                                        rec_linea_opera_recla.opre_oid_oper_recl ");
      sqlQuery.append("           AND rec_linea_opera_recla.mafa_oid_matr_fact = ");
      sqlQuery.append("                                                   pre_matri_factu.oid_matr_fact ");
      sqlQuery.append("           AND pre_matri_factu.ofde_oid_deta_ofer = ");
      sqlQuery.append("                                                   pre_ofert_detal.oid_deta_ofer ");
      sqlQuery.append("           AND pre_ofert_detal.val_codi_vent IN ("+ codigoVenta +") ");
      sqlQuery.append("           AND rec_opera_recla.tiop_oid_tipo_oper = ");
      sqlQuery.append("                                                   rec_tipos_opera.oid_tipo_oper ");
      sqlQuery.append("           AND rec_tipos_opera.rope_oid_oper = rec_opera.oid_oper ");
      sqlQuery.append("           AND rec_opera.mens_oid_mens = msg_mensa.oid_mens ");
      sqlQuery.append("           AND rec_opera.peci_oid_peci = rec_preci.oid_prec ");
      sqlQuery.append("           AND rec_opera_recla.mrdb_oid_moti_rech_desb = rec_motiv_recha_desbl.oid_moti_rech_desb(+) ");
      sqlQuery.append("           AND rec_opera_recla.esop_oid_esta_oper = ");
      sqlQuery.append("                                                   rec_estad_opera.oid_esta_oper ");*/
      
      /*ArrayList parametros = new ArrayList();
      parametros.add(oid.toString());
      parametros.add(pais.toString());
      parametros.add(subacceso.toString());
      parametros.add(acceso.toString());
      parametros.add(canal.toString());
      parametros.add(codigoVenta.toString().equals("")?oidsProducto.toString():codigoVenta.toString());
      */
      try {
         BelcorpService bs = BelcorpService.getInstance();
         
         /* Se Modifica por Incidencia Bloqueante FAC-007 alorenzo*/
         if(codigoVenta.equals("")){
            //rRetorno = bs.dbService.executeProcedure("PQ_PLANI.PED_OBTENER_DAT_MEN_PREM",parametros);
            StringBuffer buf = new StringBuffer();
            buf.append("select * from table(CAST(PED_OBT_DAT_MENS_PREMIO_TABLA(");
            buf.append(oid + ",");
            buf.append(pais + ",");
            buf.append(subacceso + ",");
            buf.append(acceso + ",");
            buf.append(canal + ",");
            buf.append(idioma);
            buf.append(") as OBJ_DAT_MEN_PRE_TABLE))");            
            rRetorno = bs.dbService.executeStaticQuery(buf.toString());
         }else{
            //rRetorno = bs.dbService.executeProcedure("PQ_PLANI.PED_OBTENER_DATOS_MENSAJES",parametros);
            StringBuffer buf = new StringBuffer();
            buf.append("select * from table(CAST(PED_OBT_DATOS_MENS_TABLA(");
            buf.append(oid + ",");
            buf.append(pais + ",");
            buf.append(subacceso + ",");
            buf.append(acceso + ",");
            buf.append(canal + ",");
            buf.append(idioma);
            buf.append(") as OBJ_PED_OBT_DATOS_MEN_TABLE))");    
            rRetorno = bs.dbService.executeStaticQuery(buf.toString());
         }
      } catch (Exception ex) {
         UtilidadesLog.error(ex);
         String sCodigoError = CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS;
         throw new MareException(ex, UtilidadesError.armarCodigoError(sCodigoError));
      }
      
/*    se reemplaza, por la REC-19  mdolce-pperez
      try {
         BelcorpService bs = BelcorpService.getInstance();
         //rRetorno = bs.dbService.executeStaticQuery(sqlQuery.toString());
         rRetorno = bs.dbService.executeProcedure("PQ_PLANI.PED_OBTENER_DATOS_MENSAJES",parametros);
      } catch (Exception ex) {
         UtilidadesLog.error(ex);
         String sCodigoError = CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS;
         throw new MareException(ex, UtilidadesError.armarCodigoError(sCodigoError));
      }*/
     
      if(log.isDebugEnabled()) //sapaza -- cambio Optimizacion Logs -- 23/03/2010                
        UtilidadesLog.debug("rRetorno: " + rRetorno);
        
      UtilidadesLog.info("DAODatosReclamo.obtenerDatosMensaje(Long oid, "+
                                      " Long pais, "+
                                      " Long subacceso,"+
                                      " Long acceso, "+
                                      " Long canal, "+
                                      " String codigoVenta ):Salida");
      return rRetorno;                                         
  }

}