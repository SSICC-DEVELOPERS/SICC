package es.indra.sicc.logicanegocio.ped;

import es.indra.sicc.cmn.negocio.ConstantesCMN;
import es.indra.sicc.util.SecuenciadorOID;
import es.indra.mare.common.exception.MareException;
import es.indra.mare.common.mii.MareMiiServiceNotFoundException;
import es.indra.mare.common.mii.services.jdbcservice.RecordSet;
import es.indra.sicc.dtos.pre.ConstantesPRE;
import es.indra.sicc.util.DTOOID;
import es.indra.sicc.logicanegocio.seg.ConstantesSEG;

import es.indra.sicc.util.BelcorpService;
import es.indra.sicc.util.CodigosError;
import es.indra.sicc.util.UtilidadesError;
import es.indra.sicc.util.UtilidadesLog;
import es.indra.sicc.logicanegocio.bel.ConstantesBEL;
import java.util.ArrayList;
import java.util.Vector;
import java.math.BigDecimal;

import es.indra.sicc.dtos.ped.DTOSolicitudValidacion;


public class DAOPosicion {
    private UtilidadesLog log = new UtilidadesLog();
    
    public DAOPosicion() {
    }

    private BelcorpService getBelcorpService() throws MareException {
        try {
            BelcorpService bs = BelcorpService.getInstance();
            return bs;
        } catch (MareMiiServiceNotFoundException e) {
            throw new MareException(e,
                  UtilidadesError.armarCodigoError(
                  CodigosError.ERROR_AL_PEDIR_UN_SERVICIO_MARE));
        }
    }

    public void actualizarEstado(Long oidPosicion, Long oidEstado)
                throws MareException {
        UtilidadesLog.info("DAOPosicion.actualizarEstado(Long oidPosicion, Long oidEstado): Entrada ");
        StringBuffer query = new StringBuffer();
        BelcorpService bs = getBelcorpService();
        try {
            //UtilidadesLog.debug("estoy en actualizarEstado, con: " + oidPosicion + " - " + oidEstado);
            
            query.append(" UPDATE PED_SOLIC_POSIC ");
            query.append(" SET ESPO_OID_ESTA_POSI= " + oidEstado);
            query.append(" WHERE OID_SOLI_POSI = " + oidPosicion);
            bs.dbService.executeUpdate(query.toString());
            UtilidadesLog.info("DAOPosicion.actualizarEstado(Long oidPosicion, Long oidEstado): Salida ");
        } catch (Exception e) {
            throw new MareException(e,
                UtilidadesError.armarCodigoError(
                    CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS));
        }
    }
    
    public String generarActualizarEstado(Long oidPosicion, Long oidEstado)
                throws MareException {
        UtilidadesLog.info("DAOPosicion.generarActualizarEstado(Long oidPosicion, Long oidEstado): Entrada ");
        StringBuffer query = new StringBuffer();
        //BelcorpService bs = getBelcorpService();
        try {
            //UtilidadesLog.debug("estoy en actualizarEstado, con: " + oidPosicion + " - " + oidEstado);
            
            query.append(" UPDATE PED_SOLIC_POSIC ");
            query.append(" SET ESPO_OID_ESTA_POSI=" + oidEstado);
            query.append(" WHERE OID_SOLI_POSI = " + oidPosicion);
            UtilidadesLog.info("DAOPosicion.generarActualizarEstado(Long oidPosicion, Long oidEstado): Salida ");
            return query.toString();
        } catch (Exception e) {
            throw new MareException(e,
                UtilidadesError.armarCodigoError(
                    CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS));
        }        
    }

    /**
     * Metodo que actualiza el estado y el numero de unidades comprometidas a CERO.
     * Agregado por HRCS - Incidencia Sicc20080568
     * @throws es.indra.mare.common.exception.MareException
     * @return 
     * @param oidEstado
     * @param oidPosicion
     */
    public String generarActualizarEstadoYNumCompr(Long oidPosicion, Long oidEstado) throws MareException {
        UtilidadesLog.info("DAOPosicion.generarActualizarEstadoYNumCompr(Long oidPosicion, Long oidEstado): Entrada ");
        StringBuffer query = new StringBuffer();
        try {
            query.append(" UPDATE PED_SOLIC_POSIC ");
            query.append(" SET ESPO_OID_ESTA_POSI=" + oidEstado);
            query.append(" , NUM_UNID_COMPR=0 ");   //  Agregado por Incidencia Sicc20080568 - Fecha 25/02/2008
            query.append(" WHERE OID_SOLI_POSI = " + oidPosicion);
            UtilidadesLog.info("DAOPosicion.generarActualizarEstadoYNumCompr(Long oidPosicion, Long oidEstado): Salida ");
            return query.toString();
        } catch (Exception e) {
            throw new MareException(e,
                UtilidadesError.armarCodigoError(
                    CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS));
        }        
    }
    
    public void actualizarPrecios(Long oidPosicion,
        BigDecimal precioContableLocal, BigDecimal precioCatalogoLocal,
        BigDecimal precioCatalgoDocumento, BigDecimal precioContableDocumento,
        Integer numDecimales) throws MareException {
        UtilidadesLog.info("DAOPosicion.actualizarPrecios(Long oidPosicion, BigDecimal precioContableLocal, BigDecimal precioCatalogoLocal, BigDecimal precioCatalgoDocumento, BigDecimal precioContableDocumento, Integer numDecimales): Entrada ");
        StringBuffer query = new StringBuffer();
        BelcorpService bs = getBelcorpService();

        try {
            query.append("UPDATE PED_SOLIC_POSIC ");
            query.append("SET ");
            query.append(
			" VAL_PREC_CATA_UNIT_LOCA= " + "ROUND(" + precioCatalogoLocal + "," + numDecimales+ "),");
            query.append(
                " VAL_PREC_CONT_UNIT_LOCA= ROUND(" + precioContableLocal + "," + numDecimales +"),");
            query.append(
                " VAL_PREC_CATA_UNIT_DOCU=ROUND(" + precioCatalgoDocumento + "," + numDecimales + "),");
            query.append(
                " VAL_PREC_CONTA_UNIT_DOCU=ROUND(" + precioContableDocumento + "," + numDecimales + ")");
            query.append("WHERE OID_SOLI_POSI= " + oidPosicion );
            bs.dbService.executeUpdate(query.toString());
            UtilidadesLog.info("DAOPosicion.actualizarPrecios(Long oidPosicion, BigDecimal precioContableLocal, BigDecimal precioCatalogoLocal, BigDecimal precioCatalgoDocumento, BigDecimal precioContableDocumento, Integer numDecimales): Salida ");
        } catch (Exception e) {
            throw new MareException(e,
                UtilidadesError.armarCodigoError(
                    CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS));
        }
    }
    
     public String generarActualizarPrecios(Long oidPosicion,
        BigDecimal precioContableLocal, BigDecimal precioCatalogoLocal,
        BigDecimal precioCatalgoDocumento, BigDecimal precioContableDocumento,
        Integer numDecimales) throws MareException {
        UtilidadesLog.info("DAOPosicion.generarActualizarPrecios(Long oidPosicion, BigDecimal precioContableLocal, BigDecimal precioCatalogoLocal, BigDecimal precioCatalgoDocumento, BigDecimal precioContableDocumento, Integer numDecimales): Entrada ");
        StringBuffer query = new StringBuffer();
        query.append("UPDATE PED_SOLIC_POSIC ");
        query.append("SET ");
        query.append(" VAL_PREC_CATA_UNIT_LOCA= " + "ROUND(" + precioCatalogoLocal + "," + numDecimales+ "),");
        query.append(" VAL_PREC_CONT_UNIT_LOCA= ROUND(" + precioContableLocal + "," + numDecimales +"),");
        query.append(" VAL_PREC_CATA_UNIT_DOCU=ROUND(" + precioCatalgoDocumento + "," + numDecimales + "),");
        query.append(" VAL_PREC_CONTA_UNIT_DOCU=ROUND(" + precioContableDocumento + "," + numDecimales + ")");
        query.append("WHERE OID_SOLI_POSI= " + oidPosicion );
        UtilidadesLog.info("DAOPosicion.generarActualizarPrecios(Long oidPosicion, BigDecimal precioContableLocal, BigDecimal precioCatalogoLocal, BigDecimal precioCatalgoDocumento, BigDecimal precioContableDocumento, Integer numDecimales): Salida ");
        return query.toString();
    }


    /**
     * Obtiene las posiciones para asignacion de stock.
     * @throws es.indra.mare.common.exception.MareException
     * @return RecordSet
     * @param oidPeriodo
     * @param oidSolicitud
     * @cambio incidencia 18878
     * @autor gdmarzi
     */
    public RecordSet obtenerPosicionesAsignacionStock(Long oidSolicitud, Long oidPeriodo, Long pais, Long almacen) throws MareException {
        UtilidadesLog.info("DAOPosicion.obtenerPosicionesAsignacionStock(Long oidSolicitud, Long oidPeriodo): Entrada ");
        BelcorpService bs;
        RecordSet respuesta;
        StringBuffer buf = new StringBuffer();
        String sqlWhere;
        
        try {
            bs = BelcorpService.getInstance();
        } catch (MareException e) {
            throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_PEDIR_UN_SERVICIO_MARE));
        }

        //agregado por Sapaza, incidencia SiCC-20070023
        Long idioma = ConstantesSEG.IDIOMA_DEFECTO;

        try {
            buf.append(" SELECT "); 
            buf.append("  A.oid_soli_posi oidposicion, "); 
            buf.append("  A.espo_oid_esta_posi estado, "); 
            buf.append("  A.cod_posi numeroposicion, "); 
            buf.append("  A.tpos_oid_tipo_posi tipoposicion, "); 
            buf.append("  A.stpo_oid_subt_posi subtipoposicion, "); 
            buf.append("  A.val_codi_vent venta, "); 
            buf.append("  A.prod_oid_prod producto, "); 
            buf.append("  NVL(A.num_unid_dema, 0) unidadesdemandadas, "); 
            buf.append("  NVL(A.num_unid_por_aten, 0) unidadesatender, "); 
            //buf.append("  NVL(A.num_unid_compr, 0) unidadescomprometidas, "); 
            buf.append("  0 unidadescomprometidas, "); 
            buf.append("  NVL(A.val_prec_neto_tota_docu, 0) netototaldocumento, "); 
            buf.append("  NVL(A.val_prec_cont_tota_docu, 0) contabletotaldocumento, "); 
            buf.append("  A.ind_ctrl_stoc controlstock, "); 
            buf.append("  B.tofe_oid_tipo_ofer tipooferta, "); 
            buf.append("  C.ind_desp_compl despachocompleto, "); 
            buf.append("  C.num_ofer numerooferta, "); 
            buf.append("  D.ties_oid_tipo_estr tipoestrategia, "); 
            buf.append("  H.ind_recu_auto recuperacionautomatica, "); 
            //<inicio>modificado por Sapaza, incidencia SiCC-20070023
            //buf.append("  I.des_cort descripcion, "); 
            buf.append(" PQ_APL_AUX.Valor_Gen_I18n_Sicc("+idioma+", I.oid_prod, 'MAE_PRODU') descripcion, ");
            //<fin>modificado por Sapaza, incidencia SiCC-20070023
 // Cambio por incidencia V_PED_19 alorenzo 25/01/2007
//            buf.append("  A.ofde_oid_deta_ofer detalleoferta, BS.VAL_SALD  "); 
            buf.append("  A.ofde_oid_deta_ofer detalleoferta, "); 
            buf.append("NVL((SELECT BS.VAL_SALD ");
            buf.append("FROM  BEL_STOCK BS, BEL_ESTAD_MERCA BEM ");
            buf.append("WHERE BS.ESME_OID_ESTA_MERC = BEM.OID_ESTA_MERC  ");
            buf.append("AND BEM.COD_ESTA = '"+ConstantesBEL.COD_EST_LIBRE_DISP+"'");
            buf.append("AND BEM.PAIS_OID_PAIS = "+pais); 
            buf.append("AND BS.ALMC_OID_ALMA =  "+almacen);
            buf.append("AND BS.PROD_OID_PROD = A.prod_oid_prod),0) VAL_SALD");
            //  Agregado por HRCS - Fecha 17/07/2007 - Cambio Sicc20070340
            buf.append(" , NVL (a.num_unid_dema_real, 0) unidemandareal ");
            buf.append(" FROM "); 
            buf.append("  ped_solic_posic A, "); 
            buf.append("  pre_ofert_detal B, "); 
            buf.append("  pre_ofert C, "); 
            buf.append("  pre_estra D, "); 
            buf.append("  pre_matri_factu F, "); 
            buf.append("  pre_matri_factu_cabec G, "); 
            buf.append("  pre_matri_recup H, mae_produ I "); 
// Cambio por incidencia V_PED_19 alorenzo 25/01/2007
//            buf.append("  mae_produ I, BEL_STOCK BS, BEL_ESTAD_MERCA BEM "); 
            buf.append(" WHERE "); 
            buf.append("  A.soca_oid_soli_cabe = " + oidSolicitud + " AND " );
            buf.append("  A.espo_oid_esta_posi <> " + ConstantesPED.ESTADO_POSICION_ANULADO + " AND ");     
            buf.append("  B.oid_deta_ofer (+) = A.ofde_oid_deta_ofer AND "); 
            buf.append("  C.oid_ofer (+) = B.ofer_oid_ofer AND "); 
            buf.append("  D.oid_estr (+) = C.coes_oid_estr AND "); 
            buf.append("  F.ofde_oid_deta_ofer (+) = B.oid_deta_ofer AND "); 
            buf.append("  G.oid_cabe (+) = F.mfca_oid_cabe AND "); 
            buf.append("  G.perd_oid_peri (+) = " + oidPeriodo + " AND ");  
            buf.append("  H.mafa_oid_cod_recu (+) = F.oid_matr_fact AND "); 
            buf.append("  I.oid_prod = A.prod_oid_prod "); 
// Cambio por incidencia V_PED_19 alorenzo 25/01/2007            
           /* buf.append("  AND BS.ESME_OID_ESTA_MERC = BEM.OID_ESTA_MERC "); 
            buf.append("  AND BEM.COD_ESTA = '"+ConstantesBEL.COD_EST_LIBRE_DISP+"'"); 
            buf.append("  AND BEM.PAIS_OID_PAIS = "+pais); 
            buf.append("  AND BS.ALMC_OID_ALMA = "+almacen); 
            buf.append("  AND BS.PROD_OID_PROD = A.prod_oid_prod ");*/
            buf.append(" ORDER BY "); 
            buf.append("   D.ties_oid_tipo_estr, C.num_ofer "); 
            respuesta = bs.dbService.executeStaticQuery(buf.toString());
        } catch (Exception e) {
            throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS));
        }
        UtilidadesLog.info("DAOPosicion.obtenerPosicionesAsignacionStock(Long oidSolicitud, Long oidPeriodo): Salida ");
        return respuesta;    
    }



  public void actualizarUnidadesComprometidas(Long oidPosicion, Long cantidad) throws MareException {
    UtilidadesLog.info("DAOPosicion.actualizarUnidadesComprometidas(Long oidPosicion, Long cantidad): Entrada ");
    StringBuffer query = new StringBuffer();
    BelcorpService bs = getBelcorpService();
    try {
      query.append(" UPDATE ped_solic_posic ");
      query.append(" SET num_unid_compr = " + cantidad);
      query.append( " WHERE oid_soli_posi =   " + oidPosicion );

      bs.dbService.executeUpdate(query.toString());
        UtilidadesLog.info("DAOPosicion.actualizarUnidadesComprometidas(Long oidPosicion, Long cantidad): Salida ");
    } catch (Exception e) {
      throw new MareException(e,UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS));
    }
  }

  public void revertirControlLiquidacion(Long oidSolicitud) throws MareException {
    UtilidadesLog.info("DAOPosicion.revertirControlLiquidacion(Long oidSolicitud): Entrada ");
    // Revierte el control de liquidación. 
    StringBuffer query = new StringBuffer();
    BelcorpService bs = getBelcorpService();
    try {
      query.append(" UPDATE ped_solic_posic ");
      query.append(" SET ind_ctrl_liqu = " + ConstantesCMN.VAL_FALSE + " ");
      query.append(" WHERE ");
      query.append(" soca_oid_soli_cabe = " + oidSolicitud + " AND ");
      query.append(" espo_oid_esta_posi <> " + ConstantesPED.ESTADO_POSICION_ANULADO + " AND ");
      query.append(" ind_ctrl_liqu = " + ConstantesCMN.VAL_TRUE + " ");
      
      bs.dbService.executeUpdate(query.toString());
        UtilidadesLog.info("DAOPosicion.revertirControlLiquidacion(Long oidSolicitud): Salida ");
    }
    catch (Exception e) {
      throw new MareException(e,UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS));
    }
  }

  public void revertirControlStock(Long oidSolicitud) throws MareException {
    UtilidadesLog.info("DAOPosicion.revertirControlStock(Long oidSolicitud): Entrada ");  
    // Revierte el control de stock. 
    StringBuffer query = new StringBuffer();
    BelcorpService bs = getBelcorpService();
    try {
      query.append(" UPDATE ped_solic_posic ");
      query.append(" SET ");
      query.append(" ind_ctrl_stoc = " + ConstantesCMN.VAL_FALSE + " , ");
      query.append(" num_unid_por_aten = num_unid_dema_real  ");
      query.append(" WHERE ");
      query.append(" soca_oid_soli_cabe = " + oidSolicitud + " AND ");
      query.append(" espo_oid_esta_posi <> " + ConstantesPED.ESTADO_POSICION_ANULADO + " AND ");
      query.append(" ind_ctrl_stoc = " + ConstantesCMN.VAL_TRUE + " ");
      
      bs.dbService.executeUpdate(query.toString());
        UtilidadesLog.info("DAOPosicion.revertirControlStock(Long oidSolicitud): Salida ");  
    }
    catch (Exception e) {
      throw new MareException(e,UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS));
    }
  }

  public void anularPosicion(Long oidPosicion) throws MareException{
    UtilidadesLog.info("DAOPosicion.anularPosicion(Long oidPosicion): Entrada ");
    StringBuffer query = new StringBuffer();
    BelcorpService bs = getBelcorpService();
    try {
      query.append(" UPDATE ped_solic_posic  ");
      query.append(" SET espo_oid_esta_posi = " + ConstantesPED.ESTADO_POSICION_ANULADO);
      query.append( " WHERE oid_soli_posi = " + oidPosicion );
      bs.dbService.executeUpdate(query.toString());
        UtilidadesLog.info("DAOPosicion.anularPosicion(Long oidPosicion): Salida ");
    }
    catch (Exception e) {
      throw new MareException(e,UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS));
    }    
  }

  public void activarRecuperacionObligatoria(Long oidPosicion) throws MareException {
    UtilidadesLog.info("DAOPosicion.activarRecuperacionObligatoria(Long oidPosicion): Entrada ");
    
    StringBuffer query = new StringBuffer();
    BelcorpService bs = getBelcorpService();
    try {
      query.append(" UPDATE ped_solic_posic  ");
      query.append(" SET ind_recu_obli = " + ConstantesCMN.VAL_TRUE );
      query.append( " WHERE oid_soli_posi = " + oidPosicion );
      bs.dbService.executeUpdate(query.toString());
        UtilidadesLog.info("DAOPosicion.activarRecuperacionObligatoria(Long oidPosicion): Salida ");
    }
    catch (Exception e) {
      throw new MareException(e,UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS));
    }    
  }

  public RecordSet insertarAlternativo(Long oidPosicion, Long oidPeriodo, String venta, Long producto) throws MareException{
    UtilidadesLog.info("DAOPosicion.insertarAlternativo(Long oidPosicion, Long oidPeriodo, String venta, Long producto): Entrada ");
    StringBuffer query = new StringBuffer();
    BelcorpService bs = getBelcorpService();
    Long oid;
    try {

		oid =SecuenciadorOID.obtenerSiguienteValor("PED_SOPO_SEQ");
      
      query.append("INSERT INTO PED_SOLIC_POSIC ");
      query.append("(oid_soli_posi, cod_posi, val_lote_prod, num_unid_dema, "); 
      query.append("num_unid_por_aten, val_tasa_impu, soca_oid_soli_cabe, "); 
      query.append("taim_oid_tasa_impu, tpos_oid_tipo_posi, prod_oid_prod, "); 
      query.append("fopa_oid_form_pago, ind_limi_vent, ind_ctrl_stoc, ind_ctrl_liqu, "); 
      query.append("val_prec_cata_unit_loca, val_prec_cont_unit_loca, "); 
      query.append("val_prec_cata_unit_docu, val_prec_conta_unit_docu, "); 
      query.append("val_prec_fact_unit_loca, val_prec_fact_unit_docu, "); 
      query.append("val_prec_sin_impu_unit_loca, val_prec_sin_impu_unit_docu, "); 
      query.append("val_prec_sin_impu_tota_docu, val_impo_desc_unit_loca, "); 
      query.append("val_impo_desc_unit_docu, val_prec_neto_unit_loca, "); 
      query.append("val_prec_neto_tota_docu, val_prec_neto_unit_docu, "); 
      query.append("val_prec_tota_tota_loca, val_prec_tota_tota_docu, val_impo_impu_unit_loca, "); 
      query.append("val_impo_impu_unit_docu, val_impo_desc_tota_docu, "); 
      query.append("val_impo_impu_tota_loca, val_impo_impu_tota_docu, "); 
      query.append("val_impo_desc_tota_loca, val_prec_tota_unit_loca, "); 
      query.append("val_prec_tota_unit_docu, val_prec_cont_tota_loca, "); 
      query.append("val_prec_cata_tota_loca, val_prec_cata_tota_docu, "); 
      query.append("val_prec_cont_tota_docu, val_porc_desc, "); 
      query.append("val_prec_cata_tota_loca_unid, num_unid_dema_real, num_unid_compr, "); 
      query.append("num_unid_camb, num_unid_vent, num_unid_aten, val_codi_vent_fict, "); 
      query.append("val_prec_fact_tota_loca, val_prec_fact_tota_docu, "); 
      query.append("val_prec_sin_impu_tota_loca, val_prec_neto_tota_loca, "); 
      query.append("ofde_oid_deta_ofer, espo_oid_esta_posi, "); 
      query.append("stpo_oid_subt_posi, ind_recu_obli, val_codi_vent) "); 
      query.append(" (SELECT " +oid +", "); 
      query.append(" (SELECT MAX(cod_posi) + 1 FROM ped_solic_posic ");
      query.append(" WHERE soca_oid_soli_cabe = (SELECT soca_oid_soli_cabe FROM ped_solic_posic ");
      query.append(" WHERE oid_soli_posi = "+ oidPosicion +" ) ), val_lote_prod, num_unid_dema,  ");
      query.append(" num_unid_por_aten, val_tasa_impu, soca_oid_soli_cabe, taim_oid_tasa_impu, "); 
      query.append( ConstantesPED.TIPO_POSICION_ALTERNATIVA+ " , "+ producto+ " , " + " fopa_oid_form_pago, ind_limi_vent, " ); 
      query.append(" ind_ctrl_stoc, ind_ctrl_liqu, val_prec_cata_unit_loca, val_prec_cont_unit_loca, "); 
      query.append("  val_prec_cata_unit_docu, val_prec_conta_unit_docu, val_prec_fact_unit_loca, val_prec_fact_unit_docu, "); 
      query.append(" val_prec_sin_impu_unit_loca, val_prec_sin_impu_unit_docu, val_prec_sin_impu_tota_docu, val_impo_desc_unit_loca, "); 
      query.append(" val_impo_desc_unit_docu, val_prec_neto_unit_loca, val_prec_neto_tota_docu, val_prec_neto_unit_docu, "); 
      query.append(" val_prec_tota_tota_loca, val_prec_tota_tota_docu, val_impo_impu_unit_loca, val_impo_impu_unit_docu, "); 
      query.append(" val_impo_desc_tota_docu, val_impo_impu_tota_loca, val_impo_impu_tota_docu, val_impo_desc_tota_loca, "); 
      query.append(" val_prec_tota_unit_loca, val_prec_tota_unit_docu, val_prec_cont_tota_loca, val_prec_cata_tota_loca, "); 
      query.append(" val_prec_cata_tota_docu, val_prec_cont_tota_docu, val_porc_desc, val_prec_cata_tota_loca_unid, "); 
      query.append(" num_unid_dema_real, num_unid_compr, num_unid_camb, num_unid_vent, "); 
      query.append(" num_unid_aten, val_codi_vent_fict, val_prec_fact_tota_loca, val_prec_fact_tota_docu, " ); 
      query.append(" val_prec_sin_impu_tota_loca, val_prec_neto_tota_loca, ofde_oid_deta_ofer, "); 
      query.append(" espo_oid_esta_posi, " + ConstantesPED.SUBTIPO_POSICION_ALTERNATIVA +" , " ); 
      query.append(" ind_recu_obli, " + venta ); 
      query.append("  FROM ped_solic_posic WHERE oid_soli_posi = " + oidPosicion+ " )"); 
      
      
      
      UtilidadesLog.debug(" query insertarAlternativo " + query.toString() );
      int h = bs.dbService.executeUpdate(query.toString());
      } 
      catch (Exception e) {
        throw new MareException(e,UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS));
      }
      RecordSet respuesta =new RecordSet();
      try {
        query = new StringBuffer();
        bs = getBelcorpService();
        query.append(" SELECT A.oid_soli_posi oidposicion, A.espo_oid_esta_posi estado, "); 
        query.append(" A.cod_posi numeroposicion, A.tpos_oid_tipo_posi tipoposicion, "); 
        //query.append(" A.stpo_oid_subt_posi subtipoposicion, A.val_codi_vent venta, A.val_codi_vent_fict ventaficticia, "); 
        
        //@ssaavedr, elimino la recuperacion del field ventaficticia, dado que en:  MONPEDValidacion.actualizarStock, esta
        //haciendo referencia directa a la pos. 6 para recuperar el oid de producto, pero en definitiva
        //se encuentra con el codigo fict. y estalla!
        
        query.append(" A.stpo_oid_subt_posi subtipoposicion, A.val_codi_vent venta, ");          
        query.append(" A.prod_oid_prod producto, NVL(A.num_unid_dema, 0) unidadesdemandadas, NVL(A.num_unid_por_aten, 0) unidadesatender, "); 
        query.append(" NVL(A.num_unid_compr, 0) unidadescomprometidas, NVL(A.val_prec_neto_tota_docu, 0) netototaldocumento, "); 
        query.append("  NVL(A.val_prec_cont_tota_docu, 0) contabletotaldocumento, NVL(A.val_prec_cata_unit_loca, 0) catalogounitariolocal, "); 
        query.append(" A.ind_ctrl_stoc controlstock, B.tofe_oid_tipo_ofer tipooferta, C.ind_desp_compl despachocompleto, "); 
        query.append(" C.num_ofer numerooferta, D.ties_oid_tipo_estr tipoestrategia, H.ind_recu_auto recuperacionautomatica, " );  
        query.append(" I.des_cort descripcion FROM ped_solic_posic A, pre_ofert_detal B, "); 
        query.append(" pre_ofert C, pre_estra D, pre_ofert_detal E, pre_matri_factu F, "); 
        query.append(" pre_matri_factu_cabec G, pre_matri_recup H, mae_produ I " ) ;
        query.append(" WHERE A.oid_soli_posi ="+ oid +" AND B.oid_deta_ofer (+) = A.ofde_oid_deta_ofer AND "); 
        query.append(" C.oid_ofer (+) = B.ofer_oid_ofer AND D.oid_estr (+) = C.coes_oid_estr AND "); 
        query.append("  E.val_codi_vent (+) = A.val_codi_vent AND F.ofde_oid_deta_ofer (+) = E.oid_deta_ofer AND "); 
        query.append(" G.oid_cabe (+) = F.mfca_oid_cabe AND G.perd_oid_peri (+) = "+ oidPeriodo +" AND "); 
        query.append(" H.mafa_oid_cod_ppal (+) = F.oid_matr_fact AND I.oid_prod = A.prod_oid_prod ");
        
      respuesta = bs.dbService.executeStaticQuery(query.toString());
      UtilidadesLog.debug("el alternativo es " + respuesta);
    } catch (Exception e) {
      throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS));
    }
    UtilidadesLog.info("DAOPosicion.insertarAlternativo(Long oidPosicion, Long oidPeriodo, String venta, Long producto): Salida ");
    return respuesta;    
  }
 
/**
	 * Obtiene las posiciones de una solicitud determinada que no estén anuladas. 
	 * @author Mario Bobadilla
	 * fecha 24/08/04

	 */

	 RecordSet obtenerPosicionesSolicitud(Long oidSolicitud) throws MareException{
        
        UtilidadesLog.info("DAOPosicion.obtenerPosicionesSolicitud(Long oidSolicitud): Entrada ");
		StringBuffer query = new StringBuffer();
        BelcorpService bs = getBelcorpService();
		RecordSet rs;
		try{
            query.append(" SELECT ");
			query.append(" oid_soli_posi posicion, ");
			query.append(" val_codi_vent venta, ");
			query.append(" NVL(num_unid_por_aten, 0) unidadesatender ");

			query.append(" FROM ped_solic_posic ");

			query.append(" WHERE ");
			query.append(" soca_oid_soli_cabe = " + oidSolicitud  + " AND ");
			query.append(" espo_oid_esta_posi <>  " + ConstantesPED.ESTADO_POSICION_ANULADO );

			rs = bs.dbService.executeStaticQuery(query.toString());
		}catch (Exception e) {
            if (e instanceof MareException) {
                UtilidadesLog.error("MareException: ",(MareException) e);
                throw (MareException) e;
            } else {
                UtilidadesLog.error("Exception ",e);
                throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS));
            }
	   }
         UtilidadesLog.info("DAOPosicion.obtenerPosicionesSolicitud(Long oidSolicitud): Salida ");
		 return rs;
	 }


void actualizarControlStock(Long oidPosicion, Long controlStock) throws MareException{

    UtilidadesLog.info("DAOPosicion.actualizarControlStock(Long oidPosicion, Long controlStock): Entrada ");
    StringBuffer query = new StringBuffer();
    BelcorpService bs = getBelcorpService();
    
    UtilidadesLog.debug("a actualizarControlStock, entro con: " + oidPosicion + " - " + controlStock);

		 try{
            query.append(" UPDATE ped_solic_posic ");

			query.append(" SET ");
			query.append(" num_unid_por_aten = " + controlStock);
			query.append(" , ind_ctrl_stoc = " + ConstantesCMN.VAL_TRUE );

			query.append(" WHERE oid_soli_posi = " +  oidPosicion);

			bs.dbService.executeUpdate(query.toString());
            UtilidadesLog.info("DAOPosicion.actualizarControlStock(Long oidPosicion, Long controlStock): Salida ");
		  }catch (Exception e) {
            
 
            if (e instanceof MareException) {
                UtilidadesLog.error("MareException: ",e);
                throw (MareException) e;
            } else {
                UtilidadesLog.error("Exception: ",e);
                throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS));
            }
	   }
	 }


  /**
	 * Obtiene las posiciones de una solicitud determinada que no estén anuladas 
   * y sean de un tipo determinado.
	 * @author Guido Pons
	 * fecha 26/08/04
	 */
  public RecordSet obtenerTipoPosicionesSolicitud(Long oidSolicitud) throws MareException {
     UtilidadesLog.info("DAOPosicion.obtenerTipoPosicionesSolicitud(Long oidSolicitud): Entrada ");
  	 try{
          StringBuffer query = new StringBuffer();
          BelcorpService bs = BelcorpService.getInstance();
          RecordSet rs;

        query.append("SELECT ");
        query.append("oid_soli_posi posicion, ");
        query.append("val_codi_vent venta ");
        query.append("FROM ped_solic_posic ");
        query.append("WHERE ");
        query.append("soca_oid_soli_cabe = " + oidSolicitud + " AND " );
        query.append("espo_oid_esta_posi <> " + ConstantesPED.ESTADO_POSICION_ANULADO);

          rs = bs.dbService.executeStaticQuery(query.toString());
        UtilidadesLog.info("DAOPosicion.obtenerTipoPosicionesSolicitud(Long oidSolicitud): Salida ");
          return rs;

     } catch (MareMiiServiceNotFoundException Me) {
         throw new MareException(Me, UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_PEDIR_UN_SERVICIO_MARE));
     }catch (Exception e) {
        throw new MareException(e,UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS));	  
     }
	}
 
  /**
   * Actualiza el control de liquidación en la posición de la solicitud. 
	 * @author Guido Pons
	 * fecha 26/08/04
	 */
  public void actualizarControlLiquidacion (Long oidPosicion) throws MareException {
        UtilidadesLog.info("DAOPosicion.actualizarControlLiquidacion (Long oidPosicion): Entrada ");
		try{

    		StringBuffer query = new StringBuffer();
        BelcorpService bs = BelcorpService.getInstance();

        query.append("UPDATE ped_solic_posic ");
    		query.append("SET ");
      	query.append("ind_ctrl_liqu = " + ConstantesCMN.VAL_TRUE);
  			query.append("WHERE oid_soli_posi = " + oidPosicion);

    		bs.dbService.executeUpdate(query.toString());
            UtilidadesLog.info("DAOPosicion.actualizarControlLiquidacion (Long oidPosicion): Salida ");

        } catch (MareMiiServiceNotFoundException Me) {
            throw new MareException(Me, UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_PEDIR_UN_SERVICIO_MARE));
        } catch (Exception e) {
            throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS));	   
        }
  }

        /**
     * Se ejecuta el siguiente query: UPDATE PED_SOLIC_POSIC SET PED_SOLIC_POSIC.NUM_UNID_POR_ATEN=PED_SOLIC_POSIC.NUM_UNID_DEMA,
     * PED_SOLIC_POSIC.NUM_UNID_DEMA_REAL=PED_SOLIC_POSIC.NUM_UNID_DEMA, PED_SOLIC_POSIC.IND_LIMI_VENT=0 WHERE
     * PED_SOLIC_POSIC.SOCA_OID_SOLI_CABE=? (oidSolicitud) AND
     * PED_SOLIC_POSIC.ESPO_OID_ESTA_POSI<>ConstantesPED:ESTADO_POSICION_ANULADO
     */
    public void revertirLimiteVenta(Long oidSolicitud) throws MareException {
        UtilidadesLog.info("DAOPosicion.revertirLimiteVenta(Long oidSolicitud): Entrada ");
        BelcorpService bs;
        StringBuffer query = new StringBuffer(); 
        try {
            bs = BelcorpService.getInstance();
        } catch (MareException e) {
            throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_PEDIR_UN_SERVICIO_MARE));
        }
        try {
            
            query.append(" UPDATE PED_SOLIC_POSIC SET PED_SOLIC_POSIC.NUM_UNID_POR_ATEN=PED_SOLIC_POSIC.NUM_UNID_DEMA, ");
            query.append(" PED_SOLIC_POSIC.NUM_UNID_DEMA_REAL=PED_SOLIC_POSIC.NUM_UNID_DEMA, ");
            query.append(" PED_SOLIC_POSIC.IND_LIMI_VENT=0 ");
            query.append(" WHERE PED_SOLIC_POSIC.SOCA_OID_SOLI_CABE= " + oidSolicitud.longValue());
            query.append(" AND PED_SOLIC_POSIC.ESPO_OID_ESTA_POSI <> " + ConstantesPED.ESTADO_POSICION_ANULADO );
            bs.dbService.executeUpdate(query.toString());
            UtilidadesLog.info("DAOPosicion.revertirLimiteVenta(Long oidSolicitud): Salida ");
        } catch (Exception exception) {
            throw new MareException(exception, UtilidadesError.armarCodigoError(
                CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS));
        }
    }

       /**
     * Actualiza en la tabla PED_SOLIC_POSIC el registro que corresponde con OID_SOLI_POSI= oidPosicion, para este registro actualiza: 
     * IND_LIMI_VENT=TRUE 
     * NUM_UNID_DEMA_REAL= UniDemReal 
     * NUM_UNID_POR_ATEN = UniAtender
     */
    public void actualizarLimiteVenta(Long lngOidPosicion, Long lngUniDemReal, Long lngUniAtender) throws MareException {
        UtilidadesLog.info("DAOPosicion.actualizarLimiteVenta(Long lngOidPosicion, Long lngUniDemReal, Long lngUniAtender): Entrada ");
        BelcorpService bs;
        StringBuffer query = new StringBuffer();
        try {
            bs = BelcorpService.getInstance();
        } catch (MareException e) {
            throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_PEDIR_UN_SERVICIO_MARE));
        }
        try {
            query.append(" UPDATE PED_SOLIC_POSIC SET IND_LIMI_VENT = 1, NUM_UNID_DEMA_REAL = " + lngUniDemReal.longValue() + ", NUM_UNID_POR_ATEN = " + lngUniAtender.longValue());
            query.append(" WHERE PED_SOLIC_POSIC.OID_SOLI_POSI = " + lngOidPosicion.longValue());
            bs.dbService.executeUpdate(query.toString());
            UtilidadesLog.info("DAOPosicion.actualizarLimiteVenta(Long lngOidPosicion, Long lngUniDemReal, Long lngUniAtender): Salida ");
        } catch (Exception exception) {
            throw new MareException(exception, UtilidadesError.armarCodigoError(
                CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS));
        }
    }
    
    public String generarActualizarLimiteVenta(Long lngOidPosicion, Long lngUniDemReal, Long lngUniAtender) throws MareException {
        BelcorpService bs;
        StringBuffer query = new StringBuffer();
        /*try {
            bs = BelcorpService.getInstance();
        } catch (MareException e) {
            throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_PEDIR_UN_SERVICIO_MARE));
        }*/
        try {
            query.append(" UPDATE PED_SOLIC_POSIC SET IND_LIMI_VENT = 1, NUM_UNID_DEMA_REAL = " + lngUniDemReal.longValue() + ", NUM_UNID_POR_ATEN = " + lngUniAtender.longValue());
            query.append(" WHERE PED_SOLIC_POSIC.OID_SOLI_POSI = " + lngOidPosicion.longValue());
            //bs.dbService.executeUpdate(query.toString());
            return query.toString();
            
        } catch (Exception exception) {
            throw new MareException(exception, UtilidadesError.armarCodigoError(
                CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS));
        }
    }


    /**
     * Obtiene las posiciones faltantes.
     * Se retornan las columnas: oidposicion, controlstock, unidadesdemandadas, 
     * unidadesatender, unidadescomprometidas, venta, ventaficticia, porcentajedescuento, 
     * descuentounitariodocumento, formapago, numeroposicion, periodo, detalleofertappal.
     * @autor gdmarzi
     */
    public RecordSet obtenerPosicionesFaltantes(DTOSolicitudValidacion dto) throws MareException  {
        UtilidadesLog.info("DAOPosicion.obtenerPosicionesFaltantes(DTOSolicitudValidacion dto): Entrada ");
        BelcorpService belcorpService;
        RecordSet rsPosicionesFaltantes;
        String codigoError;
        Vector parametros = new Vector();

        try {
            belcorpService = BelcorpService.getInstance();
        } catch (MareMiiServiceNotFoundException serviceNotFoundException) {
            codigoError = CodigosError.ERROR_AL_PEDIR_UN_SERVICIO_MARE;
            throw new MareException(serviceNotFoundException,
                UtilidadesError.armarCodigoError(codigoError));
        }

        StringBuffer stringBuffer = new StringBuffer();

        stringBuffer.append(" SELECT ");
        stringBuffer.append(" B.oid_soli_posi as oidposicion, ");
        stringBuffer.append(" B.ind_ctrl_stoc as controlstock, ");
        stringBuffer.append(" NVL(B.num_unid_dema, 0) as unidadesdemandadas, ");
        stringBuffer.append(" NVL(b.num_unid_dema_real, 0) as unidadesatender, ");
        stringBuffer.append(" NVL(B.num_unid_compr, 0) as unidadescomprometidas, ");
        stringBuffer.append(" B.val_codi_vent as venta, ");
        stringBuffer.append(" B.val_codi_vent_fict as ventaficticia, ");
        stringBuffer.append(" B.val_porc_desc as porcentajedescuento, ");
        stringBuffer.append(" B.val_impo_desc_unit_docu as descuentounitariodocumento, ");
        stringBuffer.append(" B.fopa_oid_form_pago as formapago, ");
        stringBuffer.append(" B.cod_posi as numeroposicion, ");
        stringBuffer.append(" A.perd_oid_peri as periodo, ");
        stringBuffer.append(" J.ofde_oid_deta_ofer as detalleofertappal, ");
        stringBuffer.append(" B.prod_oid_prod as producto, ");
        //pzerbino Incidencia BELC300024247 11/10/2006
        stringBuffer.append(" A.IND_PEDI_PRUE as indPedidoPrueba ");
        // [1] Agregado por Rafael Romero - 23/05/2007 - SiCC 20070261
        stringBuffer.append(" ,B.VAL_IMPO_DESC_UNIT_LOCA as descuentounitariolocal ");
        // [1] Fin agregar

        stringBuffer.append(" FROM ");
        stringBuffer.append(" ped_solic_cabec A, ");
        stringBuffer.append(" ped_solic_posic B, ");
        stringBuffer.append(" cra_perio C, ");
        stringBuffer.append(" ped_tipo_solic_pais D, ");
        stringBuffer.append(" ped_tipo_solic E, ");
        stringBuffer.append(" pre_ofert_detal F, ");
        stringBuffer.append(" pre_ofert G, ");
        stringBuffer.append(" pre_matri_factu H, ");
        stringBuffer.append(" pre_matri_recup I, ");
        stringBuffer.append(" pre_matri_factu J ");
        
        //sapaza -- PER-SiCC-2010-0119 -- 17/08/2010
        stringBuffer.append(" ,zon_zona k ");
        stringBuffer.append(" ,zon_regio l ");
        
        stringBuffer.append(" WHERE ");
        if (dto.getOidCliente() != null) {
            stringBuffer.append(" A.clie_oid_clie = ? AND ");
            parametros.add(dto.getOidCliente());
        }
        stringBuffer.append(" A.ind_oc = " + ConstantesCMN.VAL_TRUE + " AND ");
        if (dto.getOidSubAcceso() != null) {
            stringBuffer.append(" A.sbac_oid_sbac = ? AND ");
            parametros.add(dto.getOidSubAcceso());
        }
        stringBuffer.append(" C.oid_peri = A.perd_oid_peri AND ");
        stringBuffer.append(" C.pais_oid_pais = ? AND ");
        stringBuffer.append(" C.marc_oid_marc = ? AND ");
        stringBuffer.append(" C.cana_oid_cana = ? AND ");
        stringBuffer.append(" C.fec_inic < ");
        stringBuffer.append("   (SELECT fec_inic ");
        stringBuffer.append("    FROM cra_perio ");
        stringBuffer.append("    WHERE oid_peri = ?) AND ");
        stringBuffer.append(" D.oid_tipo_soli_pais = A.tspa_oid_tipo_soli_pais AND ");
        stringBuffer.append(" E.oid_tipo_soli = D.tsol_oid_tipo_soli AND ");
        stringBuffer.append(" E.ind_devo = " + ConstantesCMN.VAL_FALSE + " AND ");
        stringBuffer.append(" E.ind_anul = " + ConstantesCMN.VAL_FALSE + " AND ");
        stringBuffer.append(" B.soca_oid_soli_cabe = A.oid_soli_cabe AND ");

        //Modificado por Sapaza, fecha 02-10-2007, cambio Sicc20070429        
        //stringBuffer.append(" B.ind_recu_obli = " + ConstantesCMN.VAL_TRUE + " AND ");
        stringBuffer.append(" I.ind_recu_auto  = " + ConstantesCMN.VAL_TRUE + " AND ");
        stringBuffer.append(" B.NUM_UNID_DEMA_REAL > B.NUM_UNID_COMPR AND ");
        
        stringBuffer.append(" B.espo_oid_esta_posi <> " + ConstantesPED.ESTADO_POSICION_RECUPERACION + " AND ");
        stringBuffer.append(" B.espo_oid_esta_posi <> " + ConstantesPED.ESTADO_POSICION_ANULADO + " AND ");
        stringBuffer.append(" F.oid_deta_ofer = B.ofde_oid_deta_ofer AND ");
        stringBuffer.append(" G.oid_ofer = F.ofer_oid_ofer AND ");
        stringBuffer.append(" H.ofde_oid_deta_ofer = B.ofde_oid_deta_ofer AND ");
        stringBuffer.append(" H.mfca_oid_cabe = G.mfca_oid_cabe AND ");
        stringBuffer.append(" I.mafa_oid_cod_recu = H.oid_matr_fact AND ");
        stringBuffer.append(" J.oid_matr_fact = I.mafa_oid_cod_ppal ");
        
        //sapaza -- PER-SiCC-2010-0119 -- 17/08/2010
        stringBuffer.append(" AND a.ZZON_OID_ZONA=k.OID_ZONA ");
        stringBuffer.append(" AND k.ZORG_OID_REGI=l.OID_REGI ");
        stringBuffer.append(" AND decode(i.ZZON_OID_ZONA,null,k.OID_ZONA, i.ZZON_OID_ZONA) =k.OID_ZONA ");
        stringBuffer.append(" AND decode(i.ZORG_OID_REGI,null,l.OID_regi, i.ZORG_OID_REGI) =l.OID_REGI ");

        parametros.add(dto.getOidPais());
        parametros.add(dto.getOidMarca());
        parametros.add(dto.getOidCanal());
        parametros.add(dto.getOidPeriodo());

        //ejecutamos la consulta
        try {
            rsPosicionesFaltantes = belcorpService.dbService.executePreparedQuery(stringBuffer.toString(),
                    parametros);
        } catch(MareException me) {
            UtilidadesLog.error("MareException ",me);
            throw me;
        } catch (Exception e) {
            UtilidadesLog.error("Exception ",e);
            codigoError = CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS;
            throw new MareException(e,
                UtilidadesError.armarCodigoError(codigoError));
        }

        // Retorna con el RecordSet obtenido de la consulta
        UtilidadesLog.info("DAOPosicion.obtenerPosicionesFaltantes(DTOSolicitudValidacion dto): Salida ");
        return rsPosicionesFaltantes;
    }


    /**
     * Actualiza la posición faltante.
     * @autor gdmarzi
     */
    public void actualizaFaltante(Long oidPosicion) throws MareException {
        UtilidadesLog.info("DAOPosicion.actualizaFaltante(Long oidPosicion): Entrada ");
        StringBuffer query = new StringBuffer();    
        BelcorpService bs = getBelcorpService();
        String codigoError;
        
        try {
            query.append(" UPDATE ped_solic_posic ");
            query.append(" SET ");
            query.append(" espo_oid_esta_posi = " + ConstantesPED.ESTADO_POSICION_RECUPERACION + ", ");
            query.append(" ind_recu_obli = " + ConstantesCMN.VAL_FALSE );
            query.append(" WHERE oid_soli_posi = " + oidPosicion );

            bs.dbService.executeUpdate(query.toString());
            UtilidadesLog.info("DAOPosicion.actualizaFaltante(Long oidPosicion): Salida ");
        } catch(MareException me) {
            UtilidadesLog.error("MareException ",me);
            throw me;
        } catch(Exception e) {
            UtilidadesLog.error("Exception  ",e);
            throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS));
        }
    }


    /**
     * Obtiene las posiciones que se añadieron a la solicitud en recuperación obligatoria. 
     * @autor gdmarzi
     */
    public RecordSet obtenerPosicionesFaltantesReversion(Long oidSolicitud, Long oidTipoPosicion, Long oidSubtipoPosicion) throws MareException {
        UtilidadesLog.info("DAOPosicion.obtenerPosicionesFaltantesReversion(Long oidSolicitud, Long oidTipoPosicion, Long oidSubtipoPosicion): Entrada ");
        StringBuffer query = new StringBuffer();    
        BelcorpService bs = getBelcorpService();
        String codigoError;
        RecordSet rs;
        Vector parametros = new Vector();

        query.append(" SELECT  ");
        query.append("  oid_soli_posi oidposicion,  ");
        query.append("  val_codi_vent venta, ");
        query.append("  sopo_oid_soli_posi posicionrecuperacion  ");
        query.append(" FROM ped_solic_posic ");
        query.append(" WHERE ");
        query.append("  soca_oid_soli_cabe = " + oidSolicitud + " AND ");
        query.append("  tpos_oid_tipo_posi = " + oidTipoPosicion + " AND ");
        if (oidSubtipoPosicion != null) {
            query.append("  stpo_oid_subt_posi = " + oidSubtipoPosicion + " AND ");
        }
        query.append("  espo_oid_esta_posi <> " + ConstantesPED.ESTADO_POSICION_ANULADO );

        //ejecutamos la consulta
        try {
            rs = bs.dbService.executeStaticQuery(query.toString());
        } catch(MareException me) {
            UtilidadesLog.error("MareException ", me);
            throw me;
        } catch (Exception e) {
            UtilidadesLog.error("Exception ",e);
            codigoError = CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS;
            throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));
        }
        UtilidadesLog.info("DAOPosicion.obtenerPosicionesFaltantesReversion(Long oidSolicitud, Long oidTipoPosicion, Long oidSubtipoPosicion): Salida ");
        // Se retornan las columnas: oidposicion, venta, posicionrecuperacion
        return rs;
    }


    /**
     * Desmarca la posición faltante como recuperada. 
     * @autor gdmarzi
     */
    public void actualizaFaltanteReversion(Long oidPosicion) throws MareException {
        UtilidadesLog.info("DAOPosicion.actualizaFaltanteReversion(Long oidPosicion): Entrada ");
        StringBuffer query = new StringBuffer();    
        BelcorpService bs = getBelcorpService();
        String codigoError;
        
        try {
            query.append(" UPDATE ped_solic_posic ");
            query.append(" SET ");
            query.append(" espo_oid_esta_posi = " + ConstantesPED.ESTADO_POSICION_NO_ATENDIDA + ", ");
            query.append(" ind_recu_obli = " + ConstantesCMN.VAL_TRUE );
            query.append(" WHERE oid_soli_posi = " + oidPosicion );

            bs.dbService.executeUpdate(query.toString());
            UtilidadesLog.info("DAOPosicion.actualizaFaltanteReversion(Long oidPosicion): Salida ");
        } catch(MareException me) {
            UtilidadesLog.error("MareException",me);
            throw me;
        } catch(Exception e) {
            UtilidadesLog.error("Exception: ",e);
            throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS));
        }
    }


    /**
     * Elimina una posicion.
     * @autor gdmarzi
     */
    public void eliminarPosicion(Long oidPosicion) throws MareException {
        UtilidadesLog.info("DAOPosicion.eliminarPosicion(Long oidPosicion): Entrada ");
        StringBuffer query = new StringBuffer();    
        BelcorpService bs = getBelcorpService();
        String codigoError;
        
        try {
            query.append(" DELETE ped_solic_posic  ");
            query.append(" WHERE oid_soli_posi = " + oidPosicion );

            bs.dbService.executeUpdate(query.toString());
            UtilidadesLog.info("DAOPosicion.eliminarPosicion(Long oidPosicion): Salida ");
        } catch(MareException me) {
            UtilidadesLog.error("MareException: ",me);
            throw me;
        } catch(Exception e) {
            UtilidadesLog.error("Exception: ",e);
            throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_BORRADO_DE_DATOS));
        }
    }

    /**
     * Proceso 
     * ======== 
     * Se ejecuta la query: 
     * 
     * SELECT 
     * B.oid_soli_posi as oidposicion, 
     * H.ofde_oid_deta_ofer as detalleofertaanterior 
     * 
     * FROM 
     * ped_solic_posic B, 
     * pre_ofert_detal C, 
     * pre_ofert D, 
     * pre_estra E, 
     * pre_matri_factu F, 
     * pre_matri_recup G, 
     * pre_matri_factu H 
     * 
     * WHERE 
     * B.soca_oid_soli_cabe = oidSolicitud AND 
     * C.oid_deta_ofer = B.ofde_oid_deta_ofer AND 
     * D.oid_ofer = C.ofer_oid_ofer AND 
     * E.oid_estr = D.coes_oid_estr AND 
     * E.tipr_oid_tipo_prod = ConstantesPRE.RECUPERACION AND 
     * F.ofde_oid_deta_ofer = B.ofde_oid_deta_ofer AND 
     * F.mfca_oid_cabe = D.mfca_oid_cabe AND 
     * G.mafa_oid_cod_ppal = F.oid_matr_fact AND 
     * H.oid_matr_fact = G.mafa_oid_cod_recu 
     * 
     * Se retornan las columnas: 
     * oidposicion, 
     * detalleofertaanterior 
     */
    public RecordSet obtienerPosicionesRecuperacion(Long lngOidSolicitud) throws MareException {
        UtilidadesLog.info("DAOPosicion.obtienerPosicionesRecuperacion(Long lngOidSolicitud): Entrada ");
        BelcorpService bs;
        //StringBuffer query = new StringBuffer();
        try {
            bs = BelcorpService.getInstance();
        } catch (MareException e) {
            throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_PEDIR_UN_SERVICIO_MARE));
        }

        try {
            /*query.append(" SELECT B.oid_soli_posi as oidposicion, H.ofde_oid_deta_ofer as detalleofertaanterior ");
            query.append(" FROM ped_solic_posic B, pre_ofert_detal C, pre_ofert D, pre_estra E, pre_matri_factu F, ");
            query.append(" pre_matri_recup G, pre_matri_factu H ");
            query.append(" WHERE B.soca_oid_soli_cabe = " + lngOidSolicitud + " AND ");
            query.append(" C.oid_deta_ofer = B.ofde_oid_deta_ofer AND ");
            query.append(" D.oid_ofer = C.ofer_oid_ofer AND ");
            query.append(" E.oid_estr = D.coes_oid_estr AND ");
            query.append(" E.tipr_oid_tipo_prod = " + ConstantesPRE.RECUPERACION + " AND ");
            query.append(" F.ofde_oid_deta_ofer = B.ofde_oid_deta_ofer AND ");
            query.append(" F.mfca_oid_cabe = D.mfca_oid_cabe AND ");
            query.append(" G.mafa_oid_cod_ppal = F.oid_matr_fact AND ");
            query.append(" H.oid_matr_fact = G.mafa_oid_cod_recu ");*/

            RecordSet rs;
            ArrayList array = new ArrayList();
            array.add(lngOidSolicitud.toString());
            array.add(new Integer(ConstantesPRE.RECUPERACION).toString());
			
            //rs = (es.indra.mare.common.mii.services.jdbcservice.RecordSet) bs.dbService.executeStaticQuery(query.toString());			
            rs = (es.indra.mare.common.mii.services.jdbcservice.RecordSet) bs.dbService.executeProcedure("PQ_PLANI.PED_OBTENER_POSIC_RECUPERACION", array);			
            bs = null;
            UtilidadesLog.info("DAOPosicion.obtienerPosicionesRecuperacion(Long lngOidSolicitud): Salida ");
            return rs;
        } catch (Exception e) {
            if (e instanceof MareException) {
                UtilidadesLog.error("MareException: ",e);
                throw(MareException)e;
            } else {
                UtilidadesLog.error("Exception: ",e);
                throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS));
            }
        }
    }

    /**
     * Obtiene las posiciones de faltantes de un periodo anterior que corresponde con un detalle de oferta determinado. 
     * 
     * Proceso 
     * ======== 
     * Se ejecuta la query: 
     * 
     * SELECT 
     * B.oid_soli_posi as oidposicion, 
     * B.ind_ctrl_stoc as controlstock, 
     * NVL(B.num_unid_por_aten, 0) as unidadesatender, 
     * NVL(B.num_unid_compr, 0) as unidadescomprometidas, 
     * NVL(B.num_unid_dema, 0) as unidadesdemandadas 
     * 
     * FROM 
     * ped_solic_cabec A, 
     * ped_solic_posic B 
     * 
     * WHERE 
     * A.clie_oid_clie = oidCliente AND 
     * A.perd_oid_peri = oidPeriodo AND 
     * A.ind_oc = ConstantesCMN.VAL_TRUE AND 
     * B.soca_oid_soli_cabe = A.oid_soli_cabe AND 
     * B.ofde_oid_deta_ofer = oidDetalleOferta AND 
     * B.espo_oid_esta_posi <> ConstantesPED.ESTADO_POSICION_RECUPERACION AND 
     * B.espo_oid_esta_posi <> ConstantesPED.ESTADO_POSICION_ANULADO 
     * 
     * Se retornan las columnas: 
     * oidposicion, 
     * controlstock, 
     * unidadesatender, 
     * unidadescomprometidas, 
     * unidadesdemandadas 
     */
    public RecordSet obtienerPosicionesFaltantesVenta(Long lngOidCliente, Long lngOidPeriodo, Long lngOidDetalleVenta) throws MareException {
        
        UtilidadesLog.info("DAOPosicion.obtienerPosicionesFaltantesVenta(Long lngOidCliente, Long lngOidPeriodo, Long lngOidDetalleVenta): Entrada ");
		BelcorpService bs;
    	StringBuffer query = new StringBuffer();
        try {
            bs = BelcorpService.getInstance();
        } catch (MareException e) {
            throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_PEDIR_UN_SERVICIO_MARE));
        }

        try {
            query.append(" SELECT B.oid_soli_posi as oidposicion, ");
            query.append(" B.ind_ctrl_stoc as controlstock, ");
            query.append(" NVL(B.num_unid_por_aten, 0) as unidadesatender, ");
            query.append(" NVL(B.num_unid_compr, 0) as unidadescomprometidas, ");
            query.append(" NVL(B.num_unid_dema, 0) as unidadesdemandadas ");
			query.append(" FROM ped_solic_cabec A, ped_solic_posic B ");
			query.append(" WHERE A.clie_oid_clie = " + lngOidCliente + " AND ");
			query.append(" A.perd_oid_peri = " + lngOidPeriodo + " AND ");
			query.append(" A.ind_oc = " + ConstantesCMN.VAL_TRUE + " AND ");
			query.append(" B.soca_oid_soli_cabe = A.oid_soli_cabe AND ");
			query.append(" B.ofde_oid_deta_ofer = " + lngOidDetalleVenta + " AND ");
			query.append(" B.espo_oid_esta_posi <> " + ConstantesPED.ESTADO_POSICION_RECUPERACION + " AND ");
			query.append(" B.espo_oid_esta_posi <> " + ConstantesPED.ESTADO_POSICION_ANULADO);

			es.indra.mare.common.mii.services.jdbcservice.RecordSet rs;
            rs = (es.indra.mare.common.mii.services.jdbcservice.RecordSet) bs.dbService.executeStaticQuery(query.toString());
            bs = null;
            UtilidadesLog.info("DAOPosicion.obtienerPosicionesFaltantesVenta(Long lngOidCliente, Long lngOidPeriodo, Long lngOidDetalleVenta): Salida ");
			return rs;

        } catch (Exception e) {
            if (e instanceof MareException) {
                UtilidadesLog.error("MareException: ",e);
                throw(MareException)e;
            } else {
                UtilidadesLog.error("Exception: ",e);
                throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS));
            }
        }


    }

    /**
     * Actualiza una posición de recuperación para indicar la posición que recupera además del tipo y subtipo de la posición y el número de unidades por atender. 
     * 
     * Proceso 
     * ========= 
     * Se ejecuta la query: 
     * 
     * UPDATE ped_solic_posic 
     * 
     * SET  num_unid_dema_real = num_unid_por_aten,
     * num_unid_por_aten = faltantes, 
     * tpos_oid_tipo_posi = oidTipoPosicion, 
     * stpo_oid_subt_posi = oidSubtipoPosicion, 
     * sopo_oid_soli_posi = oidPosicionRecuperacion 
     * 
     * WHERE oid_soli_posi = oidPosicion 
     */
    public void actualizarPosicionRecuperacion(Long lngOidPosicion,
        										Integer iFaltantes,
                                                	Long lngOidTipoPosicion,
                                                    	Long lngOidSubTipoPosicion,
                                                        	Long lngOidPosicionRecuperacion)
	throws MareException {

        UtilidadesLog.info("DAOPosicion.actualizarPosicionRecuperacion(Long lngOidPosicion,	Integer iFaltantes, Long lngOidTipoPosicion, Long lngOidSubTipoPosicion, Long lngOidPosicionRecuperacion): Entrada ");
		BelcorpService bs;
        StringBuffer query = new StringBuffer();
        UtilidadesLog.debug("dentro de actualizarPosicionRecuperacion, recibo: " + 
                            lngOidPosicion + "-" + 
							iFaltantes + "-" +
                            lngOidTipoPosicion + "-" +
                            lngOidSubTipoPosicion + "-" +
                            lngOidPosicionRecuperacion);
        try {
            bs = BelcorpService.getInstance();
        } catch (MareException e) {
            throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_PEDIR_UN_SERVICIO_MARE));
        }

        try {
            query.append(" UPDATE ped_solic_posic ");
            // query.append(" SET num_unid_dema_real = num_unid_por_aten,  "); segun JF y yo (scs), esto esta mal!
            query.append(" SET num_unid_dema_real = " + iFaltantes + ", ");
            query.append(" num_unid_por_aten = " + iFaltantes + ", ");         //esta linea faltaba!!
            query.append(" tpos_oid_tipo_posi = " + lngOidTipoPosicion + ", ");
            query.append(" stpo_oid_subt_posi = " + lngOidSubTipoPosicion + ", ");
            query.append(" sopo_oid_soli_posi = " + lngOidPosicionRecuperacion);
			query.append(" WHERE oid_soli_posi = " + lngOidPosicion);

            bs.dbService.executeUpdate(query.toString());
            UtilidadesLog.info("DAOPosicion.actualizarPosicionRecuperacion(Long lngOidPosicion,	Integer iFaltantes, Long lngOidTipoPosicion, Long lngOidSubTipoPosicion, Long lngOidPosicionRecuperacion): Salida ");
        } catch (Exception exception) {
            throw new MareException(exception, UtilidadesError.armarCodigoError(
                CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS));
        }

    }

	    /**
     * Inserta una nueva posición de recuperación en la solicitud en base a una posición de recuperación ya existente. 
     * 
     * Proceso 
     * ======== 
     * Se crea la variable Long lOid. 
     * 
     * lOid = siguiente valor de la secuencia correspondiente. 
     * 
     * Se ejecuta la query: 
     * 
     * INSERT INTO ped_solic_posic 
     * (oid_soli_posi, cod_posi, 
     * val_lote_prod, num_unid_dema, 
     * num_unid_por_aten, val_tasa_impu, 
     * soca_oid_soli_cabe, taim_oid_tasa_impu, 
     * tpos_oid_tipo_posi, prod_oid_prod, 
     * fopa_oid_form_pago, ind_limi_vent, 
     * ind_ctrl_stoc, ind_ctrl_liqu, 
     * val_prec_cata_unit_loca, val_prec_cont_unit_loca, 
     * val_prec_cata_unit_docu, val_prec_conta_unit_docu, 
     * val_prec_fact_unit_loca, val_prec_fact_unit_docu, 
     * val_prec_sin_impu_unit_loca, val_prec_sin_impu_unit_docu, 
     * val_prec_sin_impu_tota_docu, val_impo_desc_unit_loca, 
     * val_impo_desc_unit_docu, val_prec_neto_unit_loca, 
     * val_prec_neto_tota_docu, val_prec_neto_unit_docu, 
     * val_prec_tota_tota_loca, val_prec_tota_tota_docu, 
     * val_impo_impu_unit_loca, val_impo_impu_unit_docu, 
     * val_impo_desc_tota_docu, val_impo_impu_tota_loca, 
     * val_impo_impu_tota_docu, val_impo_desc_tota_loca, 
     * val_prec_tota_unit_loca, val_prec_tota_unit_docu, 
     * val_prec_cont_tota_loca, val_prec_cata_tota_loca, 
     * val_prec_cata_tota_docu, val_prec_cont_tota_docu, 
     * val_porc_desc, val_prec_cata_tota_loca_unid, 
     * num_unid_dema_real, num_unid_compr, 
     * num_unid_camb, num_unid_vent, 
     * num_unid_aten, val_codi_vent_fict, 
     * val_prec_fact_tota_loca, val_prec_fact_tota_docu, 
     * val_prec_sin_impu_tota_loca, val_prec_neto_tota_loca, 
     * ofde_oid_deta_ofer, unmd_oid_unid_medi, 
     * espo_oid_esta_posi, stpo_oid_subt_posi, 
     * ind_recu_obli, val_codi_vent, 
     * sopo_oid_soli_posi) 
     * 
     * (SELECT 
     * lOid, 
     * (SELECT MAX(cod_posi) + 1 
     * FROM ped_solic_posic 
     * WHERE soca_oid_soli_cabe = 
     * (SELECT soca_oid_soli_cabe 
     * FROM ped_solic_posic 
     * WHERE oid_soli_posi = oidPosicion 
     * ) 
     * ), 
     * val_lote_prod, num_unid_dema, 
     * faltantes (entrada), val_tasa_impu, 
     * soca_oid_soli_cabe, taim_oid_tasa_impu, 
     * tpos_oid_tipo_posi, prod_oid_prod, 
     * fopa_oid_form_pago, ind_limi_vent, 
     * ind_ctrl_stoc, ind_ctrl_liqu, 
     * val_prec_cata_unit_loca, val_prec_cont_unit_loca, 
     * val_prec_cata_unit_docu, val_prec_conta_unit_docu, 
     * val_prec_fact_unit_loca, val_prec_fact_unit_docu, 
     * val_prec_sin_impu_unit_loca, val_prec_sin_impu_unit_docu, 
     * val_prec_sin_impu_tota_docu, val_impo_desc_unit_loca, 
     * val_impo_desc_unit_docu, val_prec_neto_unit_loca, 
     * val_prec_neto_tota_docu, val_prec_neto_unit_docu, 
     * val_prec_tota_tota_loca, val_prec_tota_tota_docu, 
     * val_impo_impu_unit_loca, val_impo_impu_unit_docu, 
     * val_impo_desc_tota_docu, val_impo_impu_tota_loca, 
     * val_impo_impu_tota_docu, val_impo_desc_tota_loca, 
     * val_prec_tota_unit_loca, val_prec_tota_unit_docu, 
     * val_prec_cont_tota_loca, val_prec_cata_tota_loca, 
     * val_prec_cata_tota_docu, val_prec_cont_tota_docu, 
     * val_porc_desc, val_prec_cata_tota_loca_unid, 
     * num_unid_dema_real, num_unid_compr, 
     * num_unid_camb, num_unid_vent, 
     * num_unid_aten, val_codi_vent_fict, 
     * val_prec_fact_tota_loca, val_prec_fact_tota_docu, 
     * val_prec_sin_impu_tota_loca, val_prec_neto_tota_loca, 
     * ofde_oid_deta_ofer, unmd_oid_unid_medi, 
     * espo_oid_esta_posi, stpo_oid_subt_posi, 
     * ind_recu_obli, val_codi_vent, 
     * sopo_oid_soli_posi 
     * FROM ped_solic_posic 
     * WHERE oid_soli_posi = oidPosicion) 
     */
    public void crearPosicionRecuperacion(Long lngOidPosicion, Integer iFaltantes, int cod_posi) throws MareException {

        UtilidadesLog.info("DAOPosicion.crearPosicionRecuperacion(Long lngOidPosicion, Integer iFaltantes): Entrada ");
        BelcorpService bs;
        StringBuffer query = new StringBuffer();
        Long oid;
        try {
            bs = BelcorpService.getInstance();
        } catch (MareException e) {
            throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_PEDIR_UN_SERVICIO_MARE));
        }
        try {
            
            oid =SecuenciadorOID.obtenerSiguienteValor("PED_SOPO_SEQ");
            UtilidadesLog.debug("dentro de crearPosicionRecuperacion, recibo: " + lngOidPosicion + " - " + iFaltantes);

			query.append(" INSERT INTO ped_solic_posic ");
			query.append(" (oid_soli_posi, cod_posi, ");
			query.append(" val_lote_prod, num_unid_dema, ");
			query.append(" num_unid_por_aten, val_tasa_impu, ");
			query.append(" soca_oid_soli_cabe, taim_oid_tasa_impu, ");
			query.append(" tpos_oid_tipo_posi, prod_oid_prod, ");
			query.append(" fopa_oid_form_pago, ind_limi_vent, ");
			query.append(" ind_ctrl_stoc, ind_ctrl_liqu, ");
			query.append(" val_prec_cata_unit_loca, val_prec_cont_unit_loca, ");
			query.append(" val_prec_cata_unit_docu, val_prec_conta_unit_docu, ");
			query.append(" val_prec_fact_unit_loca, val_prec_fact_unit_docu, ");
			query.append(" val_prec_sin_impu_unit_loca, val_prec_sin_impu_unit_docu, ");
			query.append(" val_prec_sin_impu_tota_docu, val_impo_desc_unit_loca, ");
			query.append(" val_impo_desc_unit_docu, val_prec_neto_unit_loca, ");
			query.append(" val_prec_neto_tota_docu, val_prec_neto_unit_docu, ");
			query.append(" val_prec_tota_tota_loca, val_prec_tota_tota_docu, ");
			query.append(" val_impo_impu_unit_loca, val_impo_impu_unit_docu, ");
			query.append(" val_impo_desc_tota_docu, val_impo_impu_tota_loca, ");
			query.append(" val_impo_impu_tota_docu, val_impo_desc_tota_loca, ");
			query.append(" val_prec_tota_unit_loca, val_prec_tota_unit_docu, ");
			query.append(" val_prec_cont_tota_loca, val_prec_cata_tota_loca, ");
			query.append(" val_prec_cata_tota_docu, val_prec_cont_tota_docu, ");
			query.append(" val_porc_desc, val_prec_cata_tota_loca_unid, ");
			query.append(" num_unid_dema_real, num_unid_compr, ");
			query.append(" num_unid_camb, num_unid_vent, ");
			query.append(" num_unid_aten, val_codi_vent_fict, ");
			query.append(" val_prec_fact_tota_loca, val_prec_fact_tota_docu, ");
			query.append(" val_prec_sin_impu_tota_loca, val_prec_neto_tota_loca, ");
			query.append(" ofde_oid_deta_ofer, ");
			query.append(" espo_oid_esta_posi, stpo_oid_subt_posi, ");
			query.append(" ind_recu_obli, val_codi_vent, ");
			query.append(" sopo_oid_soli_posi) ");
            query.append(" (SELECT " +oid +", ");
			query.append(" (SELECT MAX(cod_posi) + 1 ");
			query.append(" FROM ped_solic_posic ");
			query.append(" WHERE soca_oid_soli_cabe = ");
			query.append(" (SELECT soca_oid_soli_cabe ");
			query.append(" FROM ped_solic_posic ");
			query.append(" WHERE oid_soli_posi = " + lngOidPosicion);
			query.append(" ) ");
			query.append(" ), ");
			query.append(" val_lote_prod, num_unid_dema, ");
			query.append( iFaltantes + ", val_tasa_impu, ");
			query.append(" soca_oid_soli_cabe, taim_oid_tasa_impu, ");
			query.append(" tpos_oid_tipo_posi, prod_oid_prod, ");
			query.append(" fopa_oid_form_pago, ind_limi_vent, ");
			query.append(" ind_ctrl_stoc, ind_ctrl_liqu, ");
			query.append(" val_prec_cata_unit_loca, val_prec_cont_unit_loca, ");
			query.append(" val_prec_cata_unit_docu, val_prec_conta_unit_docu, ");
			query.append(" val_prec_fact_unit_loca, val_prec_fact_unit_docu, ");
			query.append(" val_prec_sin_impu_unit_loca, val_prec_sin_impu_unit_docu, ");
			query.append(" val_prec_sin_impu_tota_docu, val_impo_desc_unit_loca, ");
			query.append(" val_impo_desc_unit_docu, val_prec_neto_unit_loca, ");
			query.append(" val_prec_neto_tota_docu, val_prec_neto_unit_docu, ");
			query.append(" val_prec_tota_tota_loca, val_prec_tota_tota_docu, ");
			query.append(" val_impo_impu_unit_loca, val_impo_impu_unit_docu, ");
			query.append(" val_impo_desc_tota_docu, val_impo_impu_tota_loca, ");
			query.append(" val_impo_impu_tota_docu, val_impo_desc_tota_loca, ");
			query.append(" val_prec_tota_unit_loca, val_prec_tota_unit_docu, ");
			query.append(" val_prec_cont_tota_loca, val_prec_cata_tota_loca, ");
			query.append(" val_prec_cata_tota_docu, val_prec_cont_tota_docu, ");
			query.append(" val_porc_desc, val_prec_cata_tota_loca_unid, ");
			query.append(" num_unid_dema_real, num_unid_compr, ");
			query.append(" num_unid_camb, num_unid_vent, ");
			query.append(" num_unid_aten, val_codi_vent_fict, ");
			query.append(" val_prec_fact_tota_loca, val_prec_fact_tota_docu, ");
			query.append(" val_prec_sin_impu_tota_loca, val_prec_neto_tota_loca, ");
			query.append(" ofde_oid_deta_ofer, ");
			query.append(" espo_oid_esta_posi, stpo_oid_subt_posi, ");
			query.append(" ind_recu_obli, val_codi_vent, ");
			query.append(" sopo_oid_soli_posi ");
			query.append(" FROM ped_solic_posic ");
			query.append(" WHERE oid_soli_posi = " + lngOidPosicion + " )");
            
            UtilidadesLog.info(" query crearPosicionRecuperacion " + query.toString() );
            int h = bs.dbService.executeUpdate(query.toString());      
            
            UtilidadesLog.info("DAOPosicion.crearPosicionRecuperacion(Long lngOidPosicion, Integer iFaltantes): Salida ");
        } catch (Exception exception) {
            throw new MareException(exception, UtilidadesError.armarCodigoError(
                CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS));
        }

    }

		/**
		 * Obtiene las posiciones que se añadieron a la solicitud en recuperación voluntaria. 
		 * 
		 * Proceso 
		 * ======== 
		 * Se ejecuta la query: 
		 * 
		 * SELECT 
		 * oid_soli_posi oidposicion, 
		 * sopo_oid_soli_posi posicionrecuperacion, 
		 * ofde_oid_deta_ofer detalleoferta 
		 * 
		 * FROM ped_solic_posic 
		 * 
		 * WHERE 
		 * soca_oid_soli_cabe = oidSolicitud AND 
		 * tpos_oid_tipo_posi = oidTipoPosicion AND 
		 * stpo_oid_subt_posi = oidSubtipoPosicion AND 
		 * espo_oid_esta_posi <> ConstantesPED.ESTADO_POSICION_ANULADO 
		 * 
		 * ORDER BY ofde_oid_deta_ofer 
		 * 
		 * Se retornan las columnas: 
		 * oidposicion, 
		 * posicionrecuperacion, 
		 * detalleoferta 
		 */
		public RecordSet obtenerPosicionesReversionVoluntaria(Long lngOidSolicitud,
            															Long lngOidTipoPosicion,
                                                                        	Long lngOidSubtipoPosicion)
																			            throws MareException {
			UtilidadesLog.info("DAOPosicion.obtenerPosicionesReversionVoluntaria(Long lngOidSolicitud, Long lngOidTipoPosicion, Long lngOidSubtipoPosicion): Entrada ");
            BelcorpService bs;
			StringBuffer query = new StringBuffer();
			 try {
		    	 bs = BelcorpService.getInstance();
			 } catch (MareException e) {
			     throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_PEDIR_UN_SERVICIO_MARE));
			 }
		
			 try {

			    query.append(" SELECT oid_soli_posi oidposicion, ");
				query.append(" sopo_oid_soli_posi posicionrecuperacion, ");
			  	query.append(" ofde_oid_deta_ofer detalleoferta ");
				query.append(" FROM ped_solic_posic ");
				query.append(" WHERE soca_oid_soli_cabe = " + lngOidSolicitud + " AND ");
				query.append(" tpos_oid_tipo_posi = " + lngOidTipoPosicion + " AND ");
				query.append(" stpo_oid_subt_posi = " + lngOidSubtipoPosicion  + " AND ");
				query.append(" espo_oid_esta_posi <> " + ConstantesPED.ESTADO_POSICION_ANULADO);
				query.append(" ORDER BY ofde_oid_deta_ofer ");

				es.indra.mare.common.mii.services.jdbcservice.RecordSet rs;
			    rs = (es.indra.mare.common.mii.services.jdbcservice.RecordSet) bs.dbService.executeStaticQuery(query.toString());
		    	bs = null;
                UtilidadesLog.info("DAOPosicion.obtenerPosicionesReversionVoluntaria(Long lngOidSolicitud, Long lngOidTipoPosicion, Long lngOidSubtipoPosicion): Salida ");
				return rs;
		
			} catch (Exception e) {
				if (e instanceof MareException) {
                    UtilidadesLog.error("MareException: ",e);
    				throw(MareException)e;
				} else {
                    UtilidadesLog.error("Exception: ",e);
					throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS));
				}
			}

		}

        /**
         * Actualiza la posición de recuperación de la solicitud para revertir la Recuperación Voluntaria. 
         * 
         * Proceso 
         * ======== 
         * Se ejecuta la query: 
         * 
         * UPDATE ped_solic_posic 
         * 
         * SET 
         * num_unid_por_aten = num_unid_dema_real, 
         * tpos_oid_tipo_posi = NULL, 
         * stpo_oid_subt_posi = NULL, 
         * sopo_oid_soli_posi = NULL 
         * 
         * WHERE oid_soli_posi = oidPosicion 
         */
        public void actualizaReversionVoluntaria(Long lngOidPosicion) throws MareException {
            UtilidadesLog.info("DAOPosicion.actualizaReversionVoluntaria(Long lngOidPosicion): Entrada ");
	        StringBuffer query = new StringBuffer();
    	    BelcorpService bs = getBelcorpService();

        	try {
            	query.append(" UPDATE ped_solic_posic SET num_unid_por_aten = num_unid_dema_real, ");
            	query.append(" tpos_oid_tipo_posi = NULL, stpo_oid_subt_posi = NULL, sopo_oid_soli_posi = NULL ");
                query.append("  WHERE oid_soli_posi = " + lngOidPosicion);

        	    bs.dbService.executeUpdate(query.toString());
                UtilidadesLog.info("DAOPosicion.actualizaReversionVoluntaria(Long lngOidPosicion): Salida ");
	        } catch (Exception e) {
    	        throw new MareException(e,
        	        UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS));
	        }

        }


	 /**
		 * Autor: Paola Cabrera	
		 * Fecha: 24/11/2004
		 * Descripcion: Obtiene las posiciones faltantes en el mismo periodo
		 * N12B
		 * obtenerPosicionesFaltantesMismoPeriodo (DTOSolicitudValidacion dto)
	 **/
		 
		public RecordSet obtenerPosicionesFaltantesMismoPeriodo(DTOSolicitudValidacion dto) throws MareException  {
        UtilidadesLog.info("DAOPosicion.obtenerPosicionesFaltantesMismoPeriodo(DTOSolicitudValidacion dto): Entrada ");
        BelcorpService belcorpService;
        RecordSet rsPosicionesFaltantes;
        String codigoError;
        Vector parametros = new Vector();

        try {
            belcorpService = BelcorpService.getInstance();
        } catch (MareMiiServiceNotFoundException serviceNotFoundException) {
            codigoError = CodigosError.ERROR_AL_PEDIR_UN_SERVICIO_MARE;
            throw new MareException(serviceNotFoundException,
                UtilidadesError.armarCodigoError(codigoError));
        }

        StringBuffer stringBuffer = new StringBuffer();

        stringBuffer.append(" SELECT  ");
        stringBuffer.append(" B.oid_soli_posi as oidposicion, ");
        stringBuffer.append(" B.val_codi_vent as venta, ");
        stringBuffer.append(" B.ofde_oid_deta_ofer as detalleOferta, ");
        stringBuffer.append(" B.prod_oid_prod as producto, ");
        stringBuffer.append(" B.val_codi_vent_fict as ventaFicticia, ");
        stringBuffer.append(" NVL(B.num_unid_por_aten, 0) as unidadesAtender, ");
        stringBuffer.append(" NVL(B.num_unid_compr, 0) as unidadesComprometidas, ");
        stringBuffer.append(" B.val_prec_cata_unit_loca as precioCatalogoUnitarioLocal, ");
        stringBuffer.append(" B.val_prec_cont_unit_loca as precioContableUnitarioLocal,  ");
        stringBuffer.append(" B.VAL_PREC_CATA_UNIT_DOCU as precioCatalUnitarioDoc, ");
        stringBuffer.append(" B.VAL_PREC_CATA_UNIT_DOCU as precioContableUnitarioDoc, ");
        stringBuffer.append(" B.val_porc_desc as porcentajeDescuento, ");
        stringBuffer.append(" B.val_impo_desc_unit_docu as descuentoUnitarioDocumento, ");
        stringBuffer.append(" B.fopa_oid_form_pago as formaPago  ");
        stringBuffer.append(" FROM ");
        stringBuffer.append(" ped_solic_cabec A, ");
        stringBuffer.append(" ped_solic_posic B, ");
        stringBuffer.append(" ped_tipo_solic_pais D, ");
        stringBuffer.append(" ped_tipo_solic E ");        
        stringBuffer.append(" WHERE ");

        if (dto.getOidCliente() != null) {
            stringBuffer.append(" A.clie_oid_clie = " + dto.getOidCliente() + " AND " );
        }

        stringBuffer.append(" A.perd_oid_peri = " + dto.getOidPeriodo()); 
        stringBuffer.append(" AND A.ind_oc = " + ConstantesCMN.VAL_TRUE + " AND " );
        stringBuffer.append(" A.esso_oid_esta_soli = " + ConstantesPED.ESTADO_SOLICITUD_VALIDADO + " AND " );
        stringBuffer.append(" A.fec_fact IS NOT NULL AND ");
        stringBuffer.append(" D.oid_tipo_soli_pais = A.tspa_oid_tipo_soli_pais ");
        stringBuffer.append(" AND E.oid_tipo_soli = D.tsol_oid_tipo_soli  ");
        stringBuffer.append(" AND E.ind_devo = " + ConstantesCMN.VAL_FALSE + " AND " );
        stringBuffer.append(" E.ind_anul = " + ConstantesCMN.VAL_FALSE + " AND " );
        stringBuffer.append(" D.oid_tipo_soli_pais = A.tspa_oid_tipo_soli_pais AND ");
        stringBuffer.append(" E.oid_tipo_soli = D.tsol_oid_tipo_soli AND ");
        stringBuffer.append(" E.ind_devo = " + ConstantesCMN.VAL_FALSE + " AND ");
        stringBuffer.append(" E.ind_anul = " + ConstantesCMN.VAL_FALSE + " AND ");
        stringBuffer.append(" B.soca_oid_soli_cabe = A.oid_soli_cabe ");
        stringBuffer.append(" AND B.espo_oid_esta_posi  <> " + ConstantesPED.ESTADO_POSICION_RECUPERACION + " AND " );
        stringBuffer.append(" B.espo_oid_esta_posi <> " + ConstantesPED.ESTADO_POSICION_ANULADO + " AND " );
        stringBuffer.append(" NVL(B.num_unid_por_aten, 0) > NVL(B.num_unid_compr, 0) " );
        stringBuffer.append(" AND B.sopo_oid_soli_posi IS NULL "); 		
		
        //ejecutamos la consulta
        try {
            rsPosicionesFaltantes = belcorpService.dbService.executePreparedQuery(stringBuffer.toString(),
                    parametros);
        } catch(MareException me) {
            UtilidadesLog.error("MareException: ",me);
            throw me;
        } catch (Exception e) {
            UtilidadesLog.error("Exception: ",e);
            codigoError = CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS;
            throw new MareException(e,
                UtilidadesError.armarCodigoError(codigoError));
        }
        UtilidadesLog.info("DAOPosicion.obtenerPosicionesFaltantesMismoPeriodo(DTOSolicitudValidacion dto): Salida ");
        // Retorna con el RecordSet obtenido de la consulta
        return rsPosicionesFaltantes;
    }
	


	
    /**
     * Obtiene las posiciones que se añadieron a la solicitud en recuperación obligatoria. 
     * @autor paola cabrera ¿va?
     */
    public RecordSet obtenerPosicionesFaltantesReversion(Long oidSolicitud, Long oidTipoPosicion, Long oidSubtipoPosicion, String codigoVenta) throws MareException {
        UtilidadesLog.info("DAOPosicion.obtenerPosicionesFaltantesReversion(Long oidSolicitud, Long oidTipoPosicion, Long oidSubtipoPosicion, String codigoVenta): Entrada ");
        StringBuffer query = new StringBuffer();    
        BelcorpService bs = getBelcorpService();
        String codigoError;
        RecordSet rs;
        Vector parametros = new Vector();

        query.append(" SELECT  ");
        query.append(" p.oid_soli_posi oidposicion, ");
        query.append(" p.val_codi_vent venta, ");
        query.append(" p.sopo_oid_soli_posi posicionrecuperacion ");
        query.append(" FROM ped_solic_posic p ");
        query.append(" WHERE ");
        query.append(" p.soca_oid_soli_cabe = " + oidSolicitud + " AND ");
        query.append(" p.tpos_oid_tipo_posi = " + oidTipoPosicion + " AND ");
        if (oidSubtipoPosicion != null) {
            query.append(" stpo_oid_subt_posi = " + oidSubtipoPosicion + " AND ");
        }
        query.append(" espo_oid_esta_posi <> " + ConstantesPED.ESTADO_POSICION_ANULADO );

		if (codigoVenta != null) {
                query.append(" AND p.val_codi_vent = " + codigoVenta );
        }
		
        //ejecutamos la consulta
        try {
            rs = bs.dbService.executeStaticQuery(query.toString());
        } catch(MareException me) {
            UtilidadesLog.error("MareException: ",me);
            throw me;
        } catch (Exception e) {
            UtilidadesLog.error("Exception: ",e);
            codigoError = CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS;
            throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));
        }
        UtilidadesLog.info("DAOPosicion.obtenerPosicionesFaltantesReversion(Long oidSolicitud, Long oidTipoPosicion, Long oidSubtipoPosicion, String codigoVenta): Salida ");
        // Se retornan las columnas: oidposicion, venta, posicionrecuperacion
        return rs;
    }

	/***
	 * Obtiene las posiciones que se añadieron a la solicitud en 
	 * recuperación voluntaria. 
	 * 
	 * Paola Cabrera 
	 */

	public RecordSet obtenerPosicionesReversionVoluntaria(Long oidSolicitud, Long oidTipoPosicion, Long oidSubtipoPosicion, String codigoVenta)
																			            throws MareException {
            UtilidadesLog.info("DAOPosicion.obtenerPosicionesReversionVoluntaria(Long oidSolicitud, Long oidTipoPosicion, Long oidSubtipoPosicion, String codigoVenta): Entrada ");
			BelcorpService bs;
			StringBuffer query = new StringBuffer();
			 try {
		    	 bs = BelcorpService.getInstance();
			 } catch (MareException e) {
			     throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_PEDIR_UN_SERVICIO_MARE));
			 }
		
			 try {

			    query.append(" SELECT oid_soli_posi oidposicion, ");
				query.append(" sopo_oid_soli_posi posicionrecuperacion, ");
			  	query.append(" ofde_oid_deta_ofer detalleoferta  ");
				query.append(" FROM ped_solic_posic  ");
				query.append(" WHERE soca_oid_soli_cabe = " + oidSolicitud + " AND ");
				query.append(" tpos_oid_tipo_posi = " + oidTipoPosicion + " AND ");
				query.append(" stpo_oid_subt_posi = " + oidSubtipoPosicion  + " AND ");
				query.append(" espo_oid_esta_posi <> " + ConstantesPED.ESTADO_POSICION_ANULADO + " AND ");
				query.append(" val_codi_vent =  " + codigoVenta);
				
				query.append(" ORDER BY ofde_oid_deta_ofer ");

				es.indra.mare.common.mii.services.jdbcservice.RecordSet rs;
			    rs = (es.indra.mare.common.mii.services.jdbcservice.RecordSet) bs.dbService.executeStaticQuery(query.toString());
		    	bs = null;
                UtilidadesLog.info("DAOPosicion.obtenerPosicionesReversionVoluntaria(Long oidSolicitud, Long oidTipoPosicion, Long oidSubtipoPosicion, String codigoVenta): Salida ");
				return rs;
		
			} catch (Exception e) {
				if (e instanceof MareException) {
                    UtilidadesLog.error("MareException: ",e);
					throw(MareException)e;
				} else {
					UtilidadesLog.error("Exception: ",e);
					throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS));
				}
			}

		}
    
    
    public void actualizarPosicionVerificacion(Long oidPosicionSolicitud, String codigoVenta, Long unidadesDemandadas) throws MareException {

        UtilidadesLog.info("DAOPosicion.actualizarPosicionVerificacion(Long oidPosicionSolicitud, String codigoVenta, Long unidadesDemandadas): Entrada ");
        StringBuffer query = new StringBuffer();
        BelcorpService bs = getBelcorpService();

        try {
        
            query.append("   UPDATE ped_solic_posic   ");
            query.append("      SET val_codi_vent = '" + codigoVenta + "' ,   ");
            query.append("          num_unid_dema =   " + unidadesDemandadas);
            query.append("    WHERE oid_soli_posi =  " + oidPosicionSolicitud);
 
            bs.dbService.executeUpdate(query.toString());
            UtilidadesLog.info("DAOPosicion.actualizarPosicionVerificacion(Long oidPosicionSolicitud, String codigoVenta, Long unidadesDemandadas): Salida ");
        } catch (Exception e) {
            throw new MareException(e,
                UtilidadesError.armarCodigoError(
                    CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS));
        } 
    }


    public RecordSet consultarPosicionesModificacion(Long oidCabeceraSolicitud, Long idioma) throws MareException{
    
        UtilidadesLog.info("DAOPosicion.consultarPosicionesModificacion(Long oidCabeceraSolicitud, Long idioma): Entrada ");
        String codigoError;
        BelcorpService bs = getBelcorpService();
        StringBuffer buf = new StringBuffer();        
        RecordSet respuesta;
    
        try {
            buf.append("   SELECT sp.OID_SOLI_POSI, gen_tp.val_i18n tipo_posicion, gen_sbtp.val_i18n subtipo_posicion,   ");
            buf.append("          sp.cod_posi, sp.val_codi_vent codigo_venta,   ");
            buf.append("          dto.val_text_brev descripcion_corta, mp.cod_sap codigo_producto,   ");
            buf.append("          mp.des_cort descripcion_larga, sp.num_unid_vent unidades_venta, sp.num_unid_dema unidades_demandadas   ");
            buf.append("     FROM ped_solic_posic sp,   ");
            buf.append("          gen_i18n_sicc gen_tp,   ");
            buf.append("          gen_i18n_sicc gen_sbtp,   ");
            buf.append("          pre_ofert_detal dto,   ");
            buf.append("          mae_produ mp   ");
            buf.append("    WHERE sp.soca_oid_soli_cabe = " + oidCabeceraSolicitud);
            /* TIPO POSICION */
            buf.append("      AND sp.tpos_oid_tipo_posi = gen_tp.val_oid (+)  ");
            buf.append("      AND gen_tp.attr_enti (+) = 'PED_TIPO_POSIC'   ");
            buf.append("      AND gen_tp.IDIO_OID_IDIO (+) = " + idioma);
            /* SUBTIPO POSICION */
            buf.append("      AND sp.stpo_oid_subt_posi = gen_sbtp.val_oid (+)  ");
            buf.append("      AND gen_sbtp.attr_enti (+) = 'PED_SUBTI_POSIC'   ");
            buf.append("      AND gen_sbtp.IDIO_OID_IDIO (+) =  " + idioma);
            /* CODIGO VENTA / DESCRIPCION CORTA*/
            buf.append("      AND dto.oid_deta_ofer = sp.ofde_oid_deta_ofer   ");
            /* CODIGO PRODUCTO */
            buf.append("      AND mp.oid_prod = sp.prod_oid_prod   ");
            respuesta = bs.dbService.executeStaticQuery(buf.toString());
        
        } catch(Exception e) {
            codigoError = CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS;
            throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));
        }
        UtilidadesLog.info("DAOPosicion.consultarPosicionesModificacion(Long oidCabeceraSolicitud, Long idioma): Salida ");
        return respuesta;    

    }
    
    /**
     * Sistema:     Belcorp
     * Modulo:      PED
     * Fecha:       28/12/2004
     * @version     3.3
     * @autor       Maximiliano Dello Russo (grusso)
     * Descripcion  
     * @param DTOOID
     * @return RecordSet
     * @throws es.indra.mare.common.exception.MareException
     */
    public RecordSet consultarInformacionBasica(Long oidCabeceraSolicitud, Long idioma) throws MareException  {
        // NOTA
        // Queda pendiente la verificacion del parametro de entrada.  Ya que en 
        // la documentación figura que debe ser un long, pero de ser asi no se
        // tendria el oid del idioma.
        UtilidadesLog.info("DAOPosicion.consultarInformacionBasica(Long oidCabeceraSolicitud, Long idioma): Entrada ");
        String codigoError;
        BelcorpService bs = getBelcorpService();
        StringBuffer buf = new StringBuffer();        
        RecordSet respuesta;
         try {
            buf.append("SELECT sp.oid_soli_posi OID, ");
            buf.append("       (SELECT gen_tp.val_i18n ");
            buf.append("          FROM gen_i18n_sicc gen_tp ");
            buf.append("         WHERE sp.tpos_oid_tipo_posi = gen_tp.val_oid ");
            buf.append("           AND gen_tp.attr_enti = 'PED_TIPO_POSIC' ");
            buf.append("           AND gen_tp.attr_num_atri = 1 ");
            buf.append("           AND gen_tp.idio_oid_idio = " +  idioma + ") tipo_posicion, ");
            buf.append("       (SELECT gen_sbtp.val_i18n subtipo_posicion ");
            buf.append("          FROM gen_i18n_sicc gen_sbtp ");
            buf.append("         WHERE sp.stpo_oid_subt_posi = gen_sbtp.val_oid ");
            buf.append("           AND gen_sbtp.attr_enti = 'PED_SUBTI_POSIC' ");
            buf.append("           AND gen_sbtp.attr_num_atri = 1 ");
            buf.append("           AND gen_sbtp.idio_oid_idio = " +  idioma + ") subtipo_posicion, ");
            buf.append("       sp.cod_posi posicion ");
            buf.append("  FROM ped_solic_posic sp ");
            buf.append(" WHERE sp.soca_oid_soli_cabe = " + oidCabeceraSolicitud);            
            
            respuesta = bs.dbService.executeStaticQuery(buf.toString());
        } catch(Exception e) {
            codigoError = CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS;
            throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));
        }
        UtilidadesLog.info("DAOPosicion.consultarInformacionBasica(Long oidCabeceraSolicitud, Long idioma): Salida ");
        return respuesta;
    }
    
    /**
     * Sistema:     Belcorp
     * Modulo:      PED
     * Fecha:       28/12/2004
     * @version     3.3
     * @autor       Maximiliano Dello Russo (grusso)
     * Descripcion  
     * @param Long oidCabeceraSolicitud
     * @return RecordSet
     * @throws es.indra.mare.common.exception.MareException
     */
     
     
     /**
     * Se modifica por INC 20930
     * Modificado por: Paola Cabrera
     * Fecha: 27/09/2005
     */
    public RecordSet consultarInformacionProductos(Long oidCabeceraSolicitud) throws MareException{
        UtilidadesLog.info("DAOPosicion.consultarInformacionProductos(Long oidCabeceraSolicitud): Entrada ");
        String codigoError;
        BelcorpService bs = getBelcorpService();
        StringBuffer buf = new StringBuffer();        
        RecordSet respuesta;
        try {
            buf.append("SELECT sp.OID_SOLI_POSI OID, sp.val_codi_vent codigo_venta, ");
            buf.append("	   dto.val_text_brev descripcion_corta,");
            buf.append("       mp.cod_sap codigo_producto,");
            buf.append("	   mp.des_cort descripcion_larga");
            buf.append("  FROM ped_solic_posic sp,");
            buf.append("  	   pre_ofert_detal dto,");
            buf.append("	   mae_produ mp");
            buf.append(" WHERE sp.soca_oid_soli_cabe = " + oidCabeceraSolicitud.toString());
            buf.append("   AND dto.oid_deta_ofer(+) = sp.ofde_oid_deta_ofer");
            buf.append("   AND mp.oid_prod = sp.prod_oid_prod");
            respuesta = bs.dbService.executeStaticQuery(buf.toString());
        } catch(Exception e) {
            codigoError = CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS;
            throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));
        }
        UtilidadesLog.info("DAOPosicion.consultarInformacionProductos(Long oidCabeceraSolicitud): Salida ");
        return respuesta;
    }
    
    
    /**
     * Sistema:     Belcorp
     * Modulo:      PED
     * Fecha:       28/12/2004
     * @version     3.3
     * @autor       Maximiliano Dello Russo (grusso)
     * Descripcion  
     * @param Long oidCabeceraSolicitud
     * @return RecordSet
     * @throws es.indra.mare.common.exception.MareException
     */
    public RecordSet consultarInformacionCantidades(Long oidCabeceraSolicitud)throws MareException{
        UtilidadesLog.info("DAOPosicion.consultarInformacionCantidades(Long oidCabeceraSolicitud): Entrada ");
        String codigoError;
        BelcorpService bs = getBelcorpService();
        StringBuffer buf = new StringBuffer();        
        RecordSet respuesta;
        try {
            buf.append("SELECT sp.OID_SOLI_POSI OID, sp.num_unid_dema unidades_demandadas,");
            buf.append("	   sp.ind_limi_vent limite_venta,");
            buf.append("       sp.ind_ctrl_stoc control_stock,");
            buf.append("	   sp.ind_ctrl_liqu control_liquidacion,");
            buf.append("       sp.num_unid_por_aten unidades_por_atender,");
            buf.append("       sp.num_unid_compr unidades_comprometidas,   ");
            buf.append("       sp.num_unid_aten unidades_atendidas");
            buf.append("  FROM ped_solic_posic sp");
            buf.append(" WHERE sp.soca_oid_soli_cabe = " + oidCabeceraSolicitud.toString());
            respuesta = bs.dbService.executeStaticQuery(buf.toString());
        } catch(Exception e) {
            codigoError = CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS;
            throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));
        }
        UtilidadesLog.info("DAOPosicion.consultarInformacionCantidades(Long oidCabeceraSolicitud): Salida ");
        return respuesta;      
    }
    
    public RecordSet consultarInformacionEconomica(Long oidCabeceraSolicitud) throws MareException{
        UtilidadesLog.info("DAOPosicion.consultarInformacionEconomica(Long oidCabeceraSolicitud): Entrada ");
        String codigoError;
        BelcorpService bs = getBelcorpService();
        StringBuffer buf1 = new StringBuffer();        
        StringBuffer buf = new StringBuffer();        
        RecordSet respuesta;
        RecordSet respuesta1;
        try {

            buf1.append("  SELECT sc.mone_oid_mone   ");
            buf1.append("    FROM ped_solic_posic sp, ped_solic_cabec sc   ");
            buf1.append("   WHERE sp.soca_oid_soli_cabe =  " + oidCabeceraSolicitud);
            buf1.append("     AND sp.soca_oid_soli_cabe = sc.oid_soli_cabe   ");
            
            respuesta1 = bs.dbService.executeStaticQuery(buf1.toString());
            
            if (!respuesta1.esVacio())  {
                //se modifica el orden del select, quitando el campo precio_total_tX ya que no se espera
                //en la pantalla de informacion economica de la consulta de solicitudes.
                //por incidencia de Aceptacion (Gacevedo)
                buf.append("  SELECT sp.OID_SOLI_POSI OID, sp.val_prec_cata_unit_docu precio_catalogo_ud,    ");
                buf.append("         sp.val_prec_conta_unit_docu precio_contable_ud,   ");
                buf.append("         sp.val_prec_fact_unit_docu precio_factura_ud,   ");
                buf.append("         sp.val_prec_sin_impu_unit_docu precion_sin_impuesto_ud,   ");
                buf.append("         sp.val_impo_desc_unit_docu importe_descuento_ud,   ");
                buf.append("         sp.val_prec_neto_unit_docu precio_neto_ud,   ");
                buf.append("         sp.val_impo_impu_unit_docu importe_impuesto_ud,   ");
                //buf.append("         sp.val_prec_tota_tota_docu precio_total_td,   ");
                buf.append("         sp.val_prec_cata_tota_docu precio_catalogo_td,   ");
                buf.append("         sp.val_prec_cont_tota_docu precio_contable_td,   ");
                buf.append("         sp.val_prec_fact_tota_docu precio_factura_td,   ");
                buf.append("         sp.val_prec_sin_impu_tota_docu precion_sin_impuesto_td,   ");
                buf.append("         sp.val_impo_desc_tota_docu importe_decuento_td,   ");
                buf.append("         sp.val_prec_neto_tota_docu precio_neto_td,   ");
                buf.append("         sp.val_impo_impu_tota_docu importe_impuesto_td   ");
                buf.append("    FROM ped_solic_posic sp, ped_solic_cabec sc   ");
                buf.append("   WHERE sp.soca_oid_soli_cabe = " + oidCabeceraSolicitud);
                buf.append("     AND sp.soca_oid_soli_cabe = sc.oid_soli_cabe  ");
            } else {
            
                buf.append("  SELECT sp.OID_SOLI_POSI OID, sp.val_prec_cata_unit_loca precio_catalogo_ul,   ");
                buf.append("         sp.val_prec_cont_unit_loca precio_contable_ul,  ");
                buf.append("         sp.val_prec_fact_unit_loca precio_factura_ul,  ");
                buf.append("         sp.val_prec_sin_impu_unit_loca precion_sin_impuesto_ul,  ");
                buf.append("         sp.val_impo_desc_unit_loca importe_descuento_ul,  ");
                buf.append("         sp.val_prec_neto_unit_loca precio_neto_ul,  ");
                buf.append("         sp.val_impo_impu_unit_loca importe_impuesto_ul,  ");
                //buf.append("         sp.val_prec_tota_tota_loca precio_total_tl,  ");
                buf.append("         sp.val_prec_cata_tota_loca precio_catalogo_tl,  ");
                buf.append("         sp.val_prec_cont_tota_loca precio_contable_tl,  ");
                buf.append("         sp.val_prec_fact_tota_loca precio_factura_tl,  ");
                buf.append("         sp.val_prec_sin_impu_tota_loca precion_sin_impuesto_tl,  ");
                buf.append("         sp.val_impo_desc_tota_loca importe_decuento_tl,  ");
                buf.append("         sp.val_prec_neto_tota_loca precio_neto_tl,  ");
                buf.append("         sp.val_impo_impu_tota_loca importe_impuesto_tl  ");
                buf.append("    FROM ped_solic_posic sp, ped_solic_cabec sc  ");
                buf.append("   WHERE sp.soca_oid_soli_cabe =  "  + oidCabeceraSolicitud);
                buf.append("     AND sp.soca_oid_soli_cabe = sc.oid_soli_cabe  ");
            }

            respuesta = bs.dbService.executeStaticQuery(buf.toString());

        } catch(Exception e) {
            codigoError = CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS;
            throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));
        }
        UtilidadesLog.info("DAOPosicion.consultarInformacionEconomica(Long oidCabeceraSolicitud): Salida ");
        return respuesta;      
    
    }
    
  public RecordSet obtenerUnidadesAtendidasPorProducto(Long periodo, Long subacceso, Long producto) throws MareException {
    /**
     * Sistema:     Belcorp
     * Modulo:      PED
     * Fecha:       10/01/2005
     * @version     3.3
     * @autor       SCS
     * Descripcion  se crea metodo de acuerdo a inc.: 11947
     */  

    UtilidadesLog.info("DAOPosicion.obtenerUnidadesAtendidasPorProducto(Long periodo, Long subacceso, Long producto): Entrada ");     
    BelcorpService bs;
    RecordSet respuesta;
    StringBuffer buf = new StringBuffer();
    String sqlWhere;
    
    try {
      bs = BelcorpService.getInstance();
    } 
    catch (MareException e) 
    {
      throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_PEDIR_UN_SERVICIO_MARE));
    }
    try {
      
      buf.append(" SELECT sum(pd.NUM_UNID_ATEN) as UNIDADES_ATENDIDAS ");
      buf.append(" from PED_SOLIC_POSIC pd, PED_SOLIC_CABEC pc ");
      buf.append(" where pd.PROD_OID_PROD = " + producto.longValue());
      buf.append(" and pc.OID_SOLI_CABE = pd.SOCA_OID_SOLI_CABE");
      buf.append(" and pc.SBAC_OID_SBAC = " + subacceso.longValue());
      buf.append(" and pc.PERD_OID_PERI = " + periodo.longValue());
      buf.append(" and pc.IND_OC = '1'");
      buf.append(" and pc.IND_TS_NO_CONSO = '0'");
      respuesta = bs.dbService.executeStaticQuery(buf.toString());
    } 
    catch (Exception e) 
    {
      throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS));
    }
    UtilidadesLog.info("DAOPosicion.obtenerUnidadesAtendidasPorProducto(Long periodo, Long subacceso, Long producto): Salida ");     
    return respuesta;    
  }
   
    /*
     * CHANGELOG
     * ---------
     * 08/08/2007 - SICC 20070334 - Rafael Romero: Se modifica el metodo para recibir mas parametros
     * 13/09/2007 - SICC 20070334 - Rafael Romero
     * 24/06/2009 - SiCC 20090947 - dmorello: Para calcular importes descuento se VAL_PORC_DESC y no su complemento
     */
    public RecordSet insertarAlternativo(
            Long oidPosicion, 
            Long oidPeriodo, 
            Vector alternativo,
            Long pais,
            Long idioma,
            Long almacen
            ) throws MareException{
    UtilidadesLog.info("DAOPosicion.insertarAlternativo(Long oidPosicion, Long oidPeriodo, String venta, Long producto, Long oidDetalleOfertaAlter): Entrada ");
    StringBuffer query = new StringBuffer();
    BelcorpService bs = getBelcorpService();
    Long oid;
    try {

		oid =SecuenciadorOID.obtenerSiguienteValor("PED_SOPO_SEQ");
      
      query.append("INSERT INTO PED_SOLIC_POSIC ");
      query.append("(oid_soli_posi, cod_posi, val_lote_prod, num_unid_dema, "); 
      query.append("num_unid_por_aten, val_tasa_impu, soca_oid_soli_cabe, "); 
      query.append("taim_oid_tasa_impu, tpos_oid_tipo_posi, prod_oid_prod, "); 
      query.append("fopa_oid_form_pago, ind_limi_vent, ind_ctrl_stoc, ind_ctrl_liqu, "); 
      query.append("val_prec_cata_unit_loca, val_prec_cont_unit_loca, "); 
      query.append("val_prec_cata_unit_docu, val_prec_conta_unit_docu, "); 
      query.append("val_prec_fact_unit_loca, val_prec_fact_unit_docu, "); 
      query.append("val_prec_sin_impu_unit_loca, val_prec_sin_impu_unit_docu, "); 
      query.append("val_prec_sin_impu_tota_docu, val_impo_desc_unit_loca, "); 
      query.append("val_impo_desc_unit_docu, val_prec_neto_unit_loca, "); 
      query.append("val_prec_neto_tota_docu, val_prec_neto_unit_docu, "); 
      query.append("val_prec_tota_tota_loca, val_prec_tota_tota_docu, val_impo_impu_unit_loca, "); 
      query.append("val_impo_impu_unit_docu, val_impo_desc_tota_docu, "); 
      query.append("val_impo_impu_tota_loca, val_impo_impu_tota_docu, "); 
      query.append("val_impo_desc_tota_loca, val_prec_tota_unit_loca, "); 
      query.append("val_prec_tota_unit_docu, val_prec_cont_tota_loca, "); 
      query.append("val_prec_cata_tota_loca, val_prec_cata_tota_docu, "); 
      query.append("val_prec_cont_tota_docu, val_porc_desc, "); 
      query.append("val_prec_cata_tota_loca_unid, num_unid_dema_real, num_unid_compr, "); 
      query.append("num_unid_camb, num_unid_vent, num_unid_aten, val_codi_vent_fict, "); 
      query.append("val_prec_fact_tota_loca, val_prec_fact_tota_docu, "); 
      query.append("val_prec_sin_impu_tota_loca, val_prec_neto_tota_loca, "); 
      query.append("ofde_oid_deta_ofer, espo_oid_esta_posi, "); 
      query.append("stpo_oid_subt_posi, ind_recu_obli, val_codi_vent) "); 
      query.append(" (SELECT " +oid +", "); 
      query.append(" (SELECT MAX(cod_posi) + 1 FROM ped_solic_posic ");
      query.append(" WHERE soca_oid_soli_cabe = (SELECT soca_oid_soli_cabe FROM ped_solic_posic ");
      query.append(" WHERE oid_soli_posi = "+ oidPosicion +" ) ), val_lote_prod, num_unid_dema,  ");
      query.append(" (num_unid_por_aten / " + alternativo.get(11) + " ) * " + alternativo.get(12) + " , val_tasa_impu, soca_oid_soli_cabe, taim_oid_tasa_impu, "); 
      query.append( ConstantesPED.TIPO_POSICION_ALTERNATIVA+ " , "+ alternativo.get(1) /* prod_oid_prod */ + " , ");
      query.append(" fopa_oid_form_pago, ind_limi_vent, " ); 
      query.append(" ind_ctrl_stoc, ind_ctrl_liqu, " + alternativo.get(7) /*val_prec_cata_unit_loca*/ + ", "); 
      query.append( alternativo.get(8) /* val_prec_cont_unit_loca */ + ", ");
      query.append( alternativo.get(9) /* val_prec_cata_unit_docu */ + ", ");
      query.append( alternativo.get(10) /* val_prec_conta_unit_docu */ + ", ");
      query.append(" val_prec_fact_unit_loca, val_prec_fact_unit_docu, "); 
      query.append(" val_prec_sin_impu_unit_loca, val_prec_sin_impu_unit_docu, val_prec_sin_impu_tota_docu, ");
      query.append(" " + alternativo.get(7) + "* val_porc_desc/100, "); //val_impo_desc_unit_loca
      query.append(" " + alternativo.get(9) + "* val_porc_desc/100, "); //val_impo_desc_unit_docu
      query.append(" val_prec_neto_unit_loca, val_prec_neto_tota_docu, val_prec_neto_unit_docu, "); 
      query.append(" val_prec_tota_tota_loca, val_prec_tota_tota_docu, val_impo_impu_unit_loca, val_impo_impu_unit_docu, "); 
      query.append(" ((num_unid_por_aten / " + alternativo.get(11) + " ) * " + alternativo.get(12) + " ) * " + alternativo.get(9) + " * ( 1 - val_porc_desc/100 ), "); // val_impo_desc_tota_docu
      query.append(" val_impo_impu_tota_loca, val_impo_impu_tota_docu, ");
      query.append(" ((num_unid_por_aten / " + alternativo.get(11) + " ) * " + alternativo.get(12) + " ) * " + alternativo.get(7) + "* ( 1 - val_porc_desc/100 ), "); // val_impo_desc_tota_loca
      query.append(" val_prec_tota_unit_loca, val_prec_tota_unit_docu, val_prec_cont_tota_loca, val_prec_cata_tota_loca, "); 
      query.append(" val_prec_cata_tota_docu, val_prec_cont_tota_docu, val_porc_desc, val_prec_cata_tota_loca_unid, "); 
      query.append(" num_unid_dema_real, num_unid_compr, num_unid_camb, num_unid_vent, "); 
      query.append(" num_unid_aten, val_codi_vent_fict, val_prec_fact_tota_loca, val_prec_fact_tota_docu, " ); 
      query.append(" val_prec_sin_impu_tota_loca, val_prec_neto_tota_loca, " + alternativo.get(6).toString() + ", "); 
      query.append(" espo_oid_esta_posi, " + ConstantesPED.SUBTIPO_POSICION_ALTERNATIVA +" , " ); 
      query.append(" ind_recu_obli, " + alternativo.get(0).toString() ); 
      query.append("  FROM ped_solic_posic WHERE oid_soli_posi = " + oidPosicion+ " )"); 

      if(log.isDebugEnabled()) //sapaza -- cambio Optimizacion Logs -- 23/03/2010
        UtilidadesLog.debug(" query insertarAlternativo " + query.toString() );
        
      int h = bs.dbService.executeUpdate(query.toString());
      } 
      catch (Exception e) {
        throw new MareException(e,UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS));
      }
      RecordSet respuesta =new RecordSet();
      try {
        query = new StringBuffer();
        bs = getBelcorpService();
        query.append(" SELECT A.OID_SOLI_POSI OIDPOSICION, ");
        query.append("        A.ESPO_OID_ESTA_POSI ESTADO, "); 
        query.append("        A.COD_POSI NUMEROPOSICION, ");
        query.append("        A.TPOS_OID_TIPO_POSI TIPOPOSICION, "); 
        query.append("        A.STPO_OID_SUBT_POSI SUBTIPOPOSICION, ");
        query.append("        A.VAL_CODI_VENT VENTA, ");          
        query.append("        A.PROD_OID_PROD PRODUCTO, ");
        query.append("        NVL(A.NUM_UNID_DEMA, 0) UNIDADESDEMANDADAS, ");
        query.append("        NVL(A.NUM_UNID_POR_ATEN, 0) UNIDADESATENDER, "); 
        query.append("        NVL(A.NUM_UNID_COMPR, 0) UNIDADESCOMPROMETIDAS, ");
        query.append("        NVL(A.VAL_PREC_NETO_TOTA_DOCU, 0) NETOTOTALDOCUMENTO, "); 
        query.append("        NVL(A.VAL_PREC_CONT_TOTA_DOCU, 0) CONTABLETOTALDOCUMENTO, ");
        // Modificado por SICC20070334 - Rafael Romero - 13/08/2007
        // query.append("        NVL(A.VAL_PREC_CATA_UNIT_LOCA, 0) CATALOGOUNITARIOLOCAL, ");
        // Fin modificado SICC20070334
        query.append("        A.IND_CTRL_STOC CONTROLSTOCK, ");
        query.append("        B.TOFE_OID_TIPO_OFER TIPOOFERTA, ");
        query.append("        C.IND_DESP_COMPL DESPACHOCOMPLETO, "); 
        query.append("        C.NUM_OFER NUMEROOFERTA, ");
        query.append("        D.TIES_OID_TIPO_ESTR TIPOESTRATEGIA, ");
        query.append("        H.IND_RECU_AUTO RECUPERACIONAUTOMATICA, " );  
        // Agregado por SICC20070334 - Rafael Romero - 13/08/2007
        // Relacionadas: SiCC-20070023, V_PED_19, Sicc20070340
        // query.append("        I.DES_CORT DESCRIPCION ");
        query.append(" PQ_APL_AUX.Valor_Gen_I18n_Sicc("+idioma+", I.oid_prod, 'MAE_PRODU') descripcion, ");
        query.append("  A.ofde_oid_deta_ofer detalleoferta, "); 
        query.append("NVL((SELECT BS.VAL_SALD ");
        query.append("FROM  BEL_STOCK BS, BEL_ESTAD_MERCA BEM ");
        query.append("WHERE BS.ESME_OID_ESTA_MERC = BEM.OID_ESTA_MERC  ");
        query.append("AND BEM.COD_ESTA = '"+ConstantesBEL.COD_EST_LIBRE_DISP+"' ");
        query.append("AND BEM.PAIS_OID_PAIS = "+pais+" "); 
        query.append("AND BS.ALMC_OID_ALMA =  "+almacen+" ");
        query.append("AND BS.PROD_OID_PROD = A.prod_oid_prod),0) VAL_SALD ");
        query.append(" , NVL (a.num_unid_dema_real, 0) unidemandareal ");
        // Fin agregado por SICC20070334
        query.append(" FROM PED_SOLIC_POSIC A, ");
        query.append("      PRE_OFERT_DETAL B, "); 
        query.append("      PRE_OFERT C, ");
        query.append("      PRE_ESTRA D, ");
        //query.append("      PRE_OFERT_DETAL E, ");
        query.append("      PRE_MATRI_FACTU F, "); 
        query.append("      PRE_MATRI_FACTU_CABEC G, ");
        query.append("      PRE_MATRI_RECUP H, ");
        query.append("      MAE_PRODU I " ) ;
        query.append(" WHERE A.OID_SOLI_POSI = " + oid);
        query.append("   AND B.OID_DETA_OFER(+) = A.OFDE_OID_DETA_OFER "); 
        query.append("   AND C.OID_OFER(+) = B.OFER_OID_OFER ");
        query.append("   AND D.OID_ESTR(+) = C.COES_OID_ESTR ");
        // Modificado por SICC20070334 - Rafael Romero - 07/09/2007
        // query.append("   AND E.VAL_CODI_VENT(+) = A.VAL_CODI_VENT ");
        query.append("   AND F.OFDE_OID_DETA_OFER(+) = B.OID_DETA_OFER ");
        // Fin modificado SICC20070334
        query.append("   AND G.OID_CABE(+) = F.MFCA_OID_CABE ");
        query.append("   AND G.PERD_OID_PERI(+) = " + oidPeriodo);
        query.append("   AND H.MAFA_OID_COD_PPAL(+) = F.OID_MATR_FACT ");
        query.append("   AND I.OID_PROD = A.PROD_OID_PROD ");
        
      respuesta = bs.dbService.executeStaticQuery(query.toString());
      
      if(log.isDebugEnabled()) //sapaza -- cambio Optimizacion Logs -- 23/03/2010
        UtilidadesLog.debug("el alternativo es " + respuesta);
    } catch (Exception e) {
      throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS));
    }
    UtilidadesLog.info("DAOPosicion.insertarAlternativo(Long oidPosicion, Long oidPeriodo, String venta, Long producto, Long oidDetalleOfertaAlter): Salida ");
    return respuesta;    
  }  

    /**
     * Agregado por HRCS - Fecha 13/07/2007 - Cambio Sicc20070325
     * Metodo que actualiza el numero de unidades demandadas de la posicion
     * @param lngOidPosicion Oid de la posicion
     * @param lngUniDemReal Unidades Demandadas Real
     * @throws MareException Mare Excepcion
     */
    public String generarActualizarLimiteVenta2(Long lngOidPosicion, Long lngUniDemReal ) throws MareException {
        BelcorpService bs;
        StringBuffer query = new StringBuffer();
        try {
            query.append(" UPDATE PED_SOLIC_POSIC SET IND_LIMI_VENT = 1, NUM_UNID_DEMA_REAL = " + lngUniDemReal.longValue() );
            query.append(" WHERE PED_SOLIC_POSIC.OID_SOLI_POSI = " + lngOidPosicion.longValue());
            return query.toString();
            
        } catch (Exception exception) {
            throw new MareException(exception, UtilidadesError.armarCodigoError(
                CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS));
        }
    }  
}
