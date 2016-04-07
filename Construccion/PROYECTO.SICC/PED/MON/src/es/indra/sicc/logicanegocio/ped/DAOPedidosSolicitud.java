package es.indra.sicc.logicanegocio.ped;

import es.indra.sicc.logicanegocio.rec.ConstantesREC;
import es.indra.sicc.util.BelcorpService;
import es.indra.mare.common.mii.services.jdbcservice.RecordSet;
import es.indra.sicc.util.DTOBelcorp;
import es.indra.sicc.util.DTOOID;
import es.indra.sicc.util.DTOSalida;
import es.indra.sicc.util.UtilidadesEJB;
import es.indra.sicc.util.UtilidadesError;
import es.indra.sicc.util.CodigosError;
import es.indra.mare.common.exception.MareException;
import es.indra.sicc.util.UtilidadesLog;
import java.math.BigDecimal;

/*
 * 16-06-2005 - rgiorgi: inc. 19219.
 * */
public class DAOPedidosSolicitud {
  
  public Boolean obtieneNroSolicitudesCompra(Long cliente, Long periodo, 
        Boolean esFacturada) throws es.indra.mare.common.exception.MareException{
    UtilidadesLog.info("DAOPedidosSolicitud.obtieneNroSolicitudesCompra(Long cliente, Long periodo, Boolean esFacturada): Entrada ");
    Boolean bRetorno = null;
    BelcorpService belcorpService;
    RecordSet rs;

    StringBuffer query = new StringBuffer();
    /*query.append( "SELECT COUNT(*) FROM PED_SOLIC_CABEC" );
    query.append( " WHERE IND_OC = 1 AND" );

    if( periodo != null ){
      query.append( " PERD_OID_PERI = " + periodo.toString() + " AND" );
    }
    if( cliente != null ){
      query.append( " CLIE_OID_CLIE = " + cliente.toString() + " AND" );
    }
    if( esFacturada != null && esFacturada.booleanValue() ){
      query.append( " FEC_FACT IS NOT null" );
    } else{
      query.append( " FEC_FACT IS null" );
    }*/
    
    /* MAE-014 ver DT en Inc.BELC300024259 - inicio */
    query.append( " SELECT COUNT(*) " );
    query.append( "   FROM PED_SOLIC_CABEC s, " );
    query.append( "        PED_TIPO_SOLIC_PAIS  tipoSolPais, " );
    query.append( "        PED_TIPO_SOLIC tipoSol " );
    query.append( "  WHERE s.IND_OC = 1 " );
    if ( periodo != null ) {
        query.append( "    AND s.PERD_OID_PERI = " + periodo.toString() );
    }
    if ( cliente != null ) {
        query.append( "    AND s.CLIE_OID_CLIE = " + cliente.toString() );
    }
    if ( esFacturada != null && esFacturada.booleanValue() ) {
        query.append( "    AND s.FEC_FACT IS NOT null " );
    } else {
        query.append( "    AND s.FEC_FACT IS null " );
    }
    query.append( "    AND ((s.IND_PEDI_PRUE is null) OR (s.IND_PEDI_PRUE = 0)) " );
    query.append( "    AND s.TSPA_OID_TIPO_SOLI_PAIS = tipoSolPais.OID_TIPO_SOLI_PAIS " );
    query.append( "    AND tipoSolPais.TSOL_OID_TIPO_SOLI = tipoSol.OID_TIPO_SOLI " );
    query.append( "    AND tipoSol.IND_DEVO  = 0 " );
    query.append( "    AND tipoSol.IND_ANUL  = 0 " );
    query.append( "    AND s.IND_TS_NO_CONSO = 1 " );
    /* MAE-014 ver DT en Inc.BELC300024259 - fin */

    try{
      belcorpService = BelcorpService.getInstance();
    } catch(Exception e){
      throw new MareException(e,UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_PEDIR_UN_SERVICIO_MARE));
    }

    try{
      rs = belcorpService.dbService.executeStaticQuery(query.toString());
    } catch( Exception e ){
      throw new MareException(e,UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS));
    }

    if( rs == null ){
      UtilidadesLog.info("DAOPedidosSolicitud.obtieneNroSolicitudesCompra(Long cliente, Long periodo, Boolean esFacturada): Salida ");
      return Boolean.FALSE;
    }

    BigDecimal bd = (BigDecimal)rs.getValueAt(0, 0);

    if( bd.intValue() > 0 ){
      UtilidadesLog.info("DAOPedidosSolicitud.obtieneNroSolicitudesCompra(Long cliente, Long periodo, Boolean esFacturada): Salida ");
      return Boolean.TRUE;
    } else{
      UtilidadesLog.info("DAOPedidosSolicitud.obtieneNroSolicitudesCompra(Long cliente, Long periodo, Boolean esFacturada): Salida ");
      return Boolean.FALSE;
    }
  }
  
  
  /*
   * Marta Aurora Montiel - 22/03/05
   * Incidencia BELC300014706
   * */
   public DTOSalida obtenerPosicionesReclamo(Long oid) throws MareException{
        UtilidadesLog.info("DAOPedidosSolicitud.obtenerPosicionesReclamo(Long oid): Entrada ");
        
        StringBuffer query = new StringBuffer();
        RecordSet rs;
        query.append(" SELECT  ");
        query.append("  SP.VAL_CODI_VENT CODIGO_VENTA, ");
        query.append("  SP.NUM_UNID_ATEN UNIDADES_ATENDIDAS, ");      
        query.append("  SP.PROD_OID_PROD OID_PRODUCTO ");      
        query.append(" FROM ");      
        query.append("  PED_SOLIC_CABEC SC, ");      
        query.append("  PED_SOLIC_POSIC SP ");      
        query.append(" WHERE ");  
        query.append("  SC.SOCA_OID_SOLI_CABE = " + oid + " AND ");  
        query.append("  SP.SOCA_OID_SOLI_CABE = SC.OID_SOLI_CABE ");  
        
        BelcorpService bs = UtilidadesEJB.getBelcorpService();
        
        try {
          rs = (RecordSet) bs.dbService.executeStaticQuery(query.toString());
        } catch (MareException me) {
          throw me;
        } catch (Exception e) {
          throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS));
        }
        DTOSalida dts = new DTOSalida();
        dts.setResultado(rs);
        UtilidadesLog.info("DAOPedidosSolicitud.obtenerPosicionesReclamo(Long oid): Salida ");
        return(dts);         
    }  


/*
 * Operation RecordSet obtenerIndicadoresRevision (), in Class DAOPedidosSolicitud

Documentation
// Obtiene los indicadores de revision 

Accede a la tabla PED_INDIC_REVIS y obtiene: 
- OID_INDI_REVI 
- descripcion (Internacionalizable) 

Devuleve RecordSet con el resultado

 * */
 
 
 /*
   * Marta Aurora Montiel - 22/03/05
   * Incidencia BELC300014706
   * */
public DTOSalida obtenerIndicadoresRevision(DTOBelcorp dto) throws MareException{
        UtilidadesLog.info("DAOPedidosSolicitud.obtenerIndicadoresRevision(DTOBelcorp dto): Entrada ");
        // Obtiene los indicadores de revision 
        StringBuffer query = new StringBuffer();
        RecordSet rs;
        
       // vbongiov -- Cambio 20080756 -- 29/04/2009
        query.append(" SELECT  revis.OID_INDI_REVI, tipoRev.VAL_DESC_TIPO_INDI_REVI ");
        query.append(" FROM PED_INDIC_REVIS revis , PED_TIPO_INDIC_REVIS tipoRev ");
        query.append(" WHERE revis.TIRV_OID_TIPO_INDI_REVI = tipoRev.OID_TIPO_INDI_REVI ");
        query.append(" AND revis.COD_INDI_REVI IN ('" + ConstantesREC.COD_TIPO_REVISION_A + "', '" + ConstantesREC.COD_TIPO_REVISION_B + 
                                                    "', '" + ConstantesREC.COD_TIPO_REVISION_C + "') ");
        query.append(" ORDER BY tipoRev.VAL_DESC_TIPO_INDI_REVI ");        
        
        BelcorpService bs = UtilidadesEJB.getBelcorpService();
        
        try {
          rs = (RecordSet) bs.dbService.executeStaticQuery(query.toString());
        }
        catch (MareException me) {
          throw me;
        }
        catch (Exception e) {
          throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS));
        }
        DTOSalida dts = new DTOSalida();
        dts.setResultado(rs);
        UtilidadesLog.info("DAOPedidosSolicitud.obtenerIndicadoresRevision(DTOBelcorp dto): Salida ");
        return(dts);  
   }

    /*
     * 16-06-2005 - rgiorgi: inc. 19219.
     * 22-06-2005 - rgiorgi: inc. 19348.
     * 16-11-2005 - mamontie inc. 21766.
     * */
   public RecordSet obtenerPosicionesReclamoAnulacion(DTOOID dtoOID) 
    throws MareException {
      UtilidadesLog.info("DAOPedidosSolicitud.obtenerPosicionesReclamoAnulacion(DTOOID dtoOID): Entrada ");
      StringBuffer query = new StringBuffer();
      RecordSet rs;

      query.append(" SELECT ROWNUM, ROWNUM, '" +ConstantesREC.MOVIMIENTO_DEVUELVE + "' tipomovimiento, ");
      //query.append(" pre_ofert_detal.val_codi_vent, ");   //  Comentado 31/07/2007
      query.append(" NVL (ped_solic_posic.val_codi_vent,ped_solic_posic.VAL_CODI_VENT_FICT) val_codi_vent, ");  //  Fecha 31/07/2007
      // Modificado por SiCC20070487 - Rafael Romero - 23/10/2007
      
      query.append(" pq_apl_aux.valor_gen_i18n_sicc ("+ dtoOID.getOidIdioma() +", mae_produ.oid_prod, 'MAE_PRODU') des_cort, ");
      query.append(" ped_solic_posic.num_unid_aten, ");
      // Fin modificado SiCC20070487
      query.append("(CASE ");
      query.append("              WHEN ped_solic_posic.val_prec_cont_unit_loca <> 0 ");
      query.append("                 THEN 0 ");
      query.append("              ELSE ped_solic_posic.val_prec_fact_unit_loca ");
      query.append("              END  ) val_prec_fact_unit_loca , ");
      query.append(" '0' importecargo, ");
  
      query.append(" ((CASE WHEN ped_solic_posic.val_prec_cont_unit_LOCA <> 0  ");
	    query.append(" 		  THEN 0 ");
      query.append("		  ELSE ped_solic_posic.val_prec_fact_unit_loca  ");
	    query.append(" 		  END) * ped_solic_posic.num_unid_aten ) importeabono, ");
      query.append(" mae_produ.cod_sap,   '' motivodevolucion,  ");
      
      query.append(" ped_solic_posic.num_unid_aten, '' montoperdida, ");
      query.append(" (select DECODE (ped_solic_cabec.mone_oid_mone, ");
		  query.append(" NULL, (ped_solic_cabec.val_tota_paga_loca * -1), ");
	    query.append(" (ped_solic_cabec.val_tota_paga_docu * -1 ) ) ");
  	  query.append(" from ped_solic_cabec ");
 		  query.append(" where  ped_solic_cabec.oid_soli_cabe = "+ dtoOID.getOid()) ;
      query.append(" ) , ");
            
      query.append(" '" + ConstantesREC.TIPO_MOVIMIENTO_DEVUELVE  + "' oidtipomovimiento, ");
      query.append(" pre_tipo_ofert.oid_tipo_ofer, ");
      query.append(" pre_matri_factu.OID_MATR_FACT, mae_produ.oid_prod, ");
      query.append(" NULL oidmotivodevolucion, ");
      query.append(" ped_solic_posic.VAL_IMPO_DESC_UNIT_LOCA, ");
      query.append(" ped_solic_posic.VAL_PREC_CATA_UNIT_LOCA precioperdida, ");
      query.append(" ped_solic_posic.OID_SOLI_POSI ");
      //    Agregado 31/07/2007
      query.append(" , ped_solic_cabec.COPA_OID_PARA_GENE, ");
      query.append(" (SELECT pnp.OID_PARA_NIVE_PREM ");
      query.append("  FROM ");
      query.append("   INC_CONCU_PARAM_GENER cpg, ");
      query.append("   INC_PARAM_GENER_PREMI pgp, ");
      query.append("   INC_PARAM_NIVEL_PREMI pnp, ");
      query.append("   INC_PREMI_ARTIC pa, ");
      query.append("   inc_lote_premi_artic lpa, ");
      query.append("   inc_artic_lote al ");
      query.append("  WHERE cpg.OID_PARA_GRAL = ped_solic_cabec.COPA_OID_PARA_GENE ");
      query.append("    and cpg.OID_PARA_GRAL = pgp.COPA_OID_PARA_GRAL ");
      query.append("    and pgp.OID_PARA_GENE_PREM = pnp.PAGP_OID_PARA_GENE_PREM ");
      query.append("    and pnp.OID_PARA_NIVE_PREM = pa.PANP_OID_PARA_NIVE_PREM ");
      query.append("    and pa.OID_PREM_ARTI = lpa.PRAR_OID_PREM_ARTI ");
      query.append("    and lpa.OID_LOTE_PREM_ARTI = al.LOPA_OID_LOTE_PREM_ARTI ");
      query.append("    and al.COD_VENT_FICT = ped_solic_posic.VAL_CODI_VENT_FICT ");
      query.append(" ) OID_PARA_NIVE_PREM, ");
      query.append(" (SELECT lpa.OID_LOTE_PREM_ARTI ");
      query.append("  FROM ");
      query.append("   INC_CONCU_PARAM_GENER cpg, ");
      query.append("   INC_PARAM_GENER_PREMI pgp, ");
      query.append("   INC_PARAM_NIVEL_PREMI pnp, ");
      query.append("   INC_PREMI_ARTIC pa, ");
      query.append("   inc_lote_premi_artic lpa, ");
      query.append("   inc_artic_lote al ");
      query.append("  WHERE cpg.OID_PARA_GRAL = ped_solic_cabec.COPA_OID_PARA_GENE ");
      query.append("    and cpg.OID_PARA_GRAL = pgp.COPA_OID_PARA_GRAL ");
      query.append("    and pgp.OID_PARA_GENE_PREM = pnp.PAGP_OID_PARA_GENE_PREM ");
      query.append("    and pnp.OID_PARA_NIVE_PREM = pa.PANP_OID_PARA_NIVE_PREM ");
      query.append("    and pa.OID_PREM_ARTI = lpa.PRAR_OID_PREM_ARTI ");
      query.append("    and lpa.OID_LOTE_PREM_ARTI = al.LOPA_OID_LOTE_PREM_ARTI ");
      query.append("    and al.COD_VENT_FICT = ped_solic_posic.VAL_CODI_VENT_FICT ");
      query.append(" ) OID_LOTE_PREM_ARTI, ");      
      //    Fin 31/07/2007
      query.append("   ped_solic_posic.VAL_PREC_CONT_UNIT_LOCA AS PRECIOCONTALOGOUNITARIODOC ");     

      query.append(" FROM ped_solic_cabec, ");
      query.append(" ped_solic_posic, ");
      query.append(" mae_produ, ");
      query.append(" pre_ofert_detal, ");
      query.append(" pre_tipo_ofert, ");
      query.append(" pre_matri_factu ");
      query.append(" WHERE ped_solic_cabec.oid_soli_cabe = ped_solic_posic.soca_oid_soli_cabe ");
      query.append(" AND ped_solic_cabec.soca_oid_soli_cabe = " + dtoOID.getOid() );
      query.append(" AND mae_produ.oid_prod = ped_solic_posic.prod_oid_prod ");

      query.append(" AND ped_solic_posic.ofde_oid_deta_ofer = pre_ofert_detal.oid_deta_ofer(+) ");
      query.append(" AND pre_ofert_detal.oid_deta_ofer = pre_matri_factu.ofde_oid_deta_ofer(+) ");
      query.append(" AND pre_ofert_detal.tofe_oid_tipo_ofer = pre_tipo_ofert.oid_tipo_ofer(+)");
 
      
      BelcorpService bs = UtilidadesEJB.getBelcorpService();
      
      try {
        rs = (RecordSet) bs.dbService.executeStaticQuery(query.toString());
      }
      catch (MareException me) {
        throw me;
      }
      catch (Exception e) {
        throw new MareException(e, 
          UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS));
      }
      UtilidadesLog.info("DAOPedidosSolicitud.obtenerPosicionesReclamoAnulacion(DTOOID dtoOID): Salida ");
      return rs;  
   }
}
