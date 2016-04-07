package es.indra.sicc.logicanegocio.cob;
import es.indra.mare.common.exception.MareException;
import es.indra.mare.common.mii.services.jdbcservice.RecordSet;
import es.indra.sicc.dtos.cob.DTOUsuarEtapaCobraDetal;
import es.indra.sicc.util.BelcorpService;
import es.indra.sicc.util.CodigosError;
import es.indra.sicc.util.DTOBelcorp;
import es.indra.sicc.util.DTOOID;
import es.indra.sicc.util.DTOSalida;
import es.indra.sicc.util.UtilidadesEJB;
import es.indra.sicc.util.UtilidadesError;
import es.indra.sicc.util.UtilidadesLog;
import java.math.BigDecimal;

  /**
   * 29/04/2005
   * @author mdolce
   */
 
  public class DAOAsignacionUsuarioCronograma  {
      /** 
      * Metodo para recuperar un usuario de cabecera
      * @param DTOBelcorp dto
      * @return DTOSalida
      * @exception MareException 
      * @author mdolce
      * @referencia SICC-DMCO-COM-N015-UnOficial-p2
      */
     public DTOSalida recuperarUsuariosCabecera(DTOBelcorp dto) throws MareException {
     
        UtilidadesLog.info("DAOAsignacionUsuarioCronogramarecuperarUsuariosCabecera(DTOBelcorp dto).: Entrada");
     
       BelcorpService bs;
       RecordSet resultado = new RecordSet();
       DTOSalida dtoS = new DTOSalida();
       bs = UtilidadesEJB.getBelcorpService();
  
       StringBuffer query = new StringBuffer();
       
  
       try {
          bs = BelcorpService.getInstance();
    
          query.append(" SELECT DISTINCT cabeusu.usco_oid_usua_cobr OID, p.NAME ");
          query.append(" FROM principals p, users u, cob_usuar_cobra cobusu, cob_usuar_etapa_cobra_cabec cabeusu ");
          query.append(" WHERE p.idprincipal = u.iduser ");
          query.append(" AND u.iduser = cobusu.user_oid_usua_cobr ");
          query.append(" AND cabeusu.usco_oid_usua_cobr = cobusu.oid_usua_cobr ");
          query.append(" ORDER BY UPPER (p.NAME) ");
             
          resultado = bs.dbService.executeStaticQuery(query.toString());
             
            
       }
       catch(Exception e) {
            UtilidadesLog.error(e);
            throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS));
       }
  
       if (!resultado.esVacio()){
          dtoS.setResultado(resultado);
       }else{
            throw new MareException(null, null, 
              UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE));
       }        

        UtilidadesLog.info("DAOAsignacionUsuarioCronograma.recuperarUsuariosCabecera(DTOBelcorp dto): Salida");

       return dtoS;
    
    }
    
     /** 
      * Metodo para recuperar los tipos de cargo
      * @param DTOBelcorp dto
      * @return DTOSalida
      * @exception MareException 
      * @author mdolce
      * @referencia SICC-DMCO-COM-N015-UnOficial-p2
      */
    public DTOSalida recuperarTiposCargo(DTOBelcorp dto) throws MareException {
    
        UtilidadesLog.info("DAOAsignacionUsuarioCronograma.recuperarTiposCargo(DTOBelcorp dto): Entrada");
    
       BelcorpService bs;
       RecordSet resultado = new RecordSet();
       DTOSalida dtoS = new DTOSalida();
       bs = UtilidadesEJB.getBelcorpService();
  
       StringBuffer query = new StringBuffer();
       
  
       try {
          bs = BelcorpService.getInstance();
    
          query.append(" SELECT   edtc.oid_etap_deud_tipo_carg, tca.COD_TIPO_CARG_ABON ");//inc. 1814 gPineda 02/06/2006
          query.append("FROM cob_etapa_deuda_tipo_cargo edtc, ccc_tipo_cargo_abono tca ");
          query.append("WHERE edtc.TCAB_OID_TIPO_CARG_ABON = tca.oid_tipo_carg_abon ");//inc. 18184
          query.append("ORDER BY UPPER (tca.cod_tipo_carg_abon) ");
             
          resultado = bs.dbService.executeStaticQuery(query.toString());
             
            
       }
       catch(Exception e) {
            UtilidadesLog.error(e);
            throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS));
       }
  
       if (!resultado.esVacio()){
          dtoS.setResultado(resultado);
       }else{
            throw new MareException(null, null, 
              UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE));
       }        

        UtilidadesLog.info("DAOAsignacionUsuarioCronograma.recuperarTiposCargo(DTOBelcorp dto): Salida");

       return dtoS;
    }
    
     /** 
      * Metodo para recargar el combo de etapas de deuda
      * @param DTOOID dto
      * @return DTOSalida
      * @exception MareException 
      * @author mdolce
      * @referencia SICC-DMCO-COM-N015-UnOficial-p2
      */
  
    public DTOSalida recargaEtapaDeuda(DTOOID dtoOid) throws MareException {
    
        UtilidadesLog.info("DAOAsignacionUsuarioCronograma.recargaEtapaDeuda(DTOOID dtoOid): Entrada");
    
       BelcorpService bs;
       RecordSet resultado = new RecordSet();
       DTOSalida dtoS = new DTOSalida();
       bs = UtilidadesEJB.getBelcorpService();
  
       StringBuffer query = new StringBuffer();
       
  
       try {
          bs = BelcorpService.getInstance();
    
          query.append(" SELECT   ed.OID_ETAP_DEUD, ed.cod_etap_deud ");
          query.append(" FROM cob_usuar_etapa_cobra_cabec uecc, cob_etapa_deuda ed ");
          query.append(" WHERE uecc.etde_oid_etap_deud = ed.oid_etap_deud ");
          query.append(" AND uecc.USCO_OID_USUA_COBR = " + dtoOid.getOid());
          query.append(" ORDER BY UPPER (ed.oid_etap_deud) ");
             
          resultado = bs.dbService.executeStaticQuery(query.toString());
             
            
       }
       catch(Exception e) {
            UtilidadesLog.error(e);
            throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS));
       }
  
       if (!resultado.esVacio()){
          dtoS.setResultado(resultado);
       }else{
            throw new MareException(null, null, 
              UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE));
       }        

        UtilidadesLog.info("DAOAsignacionUsuarioCronograma.recargaEtapaDeuda(DTOOID dtoOid): Salida");

       return dtoS;
    }
    
    /** 
      * Metodo para  recuperar los metodos de las liquidaciones
      * @param DTOBelcorp dto
      * @return DTOSalida
      * @exception MareException 
      * @author mdolce
      * @referencia SICC-DMCO-COM-N015-UnOficial-p2
      */
  
    public DTOSalida recuperarLiquidacion(DTOBelcorp dto) throws MareException {
    
        UtilidadesLog.info("DAOAsignacionUsuarioCronograma.recuperarLiquidacion(DTOBelcorp dto): Entrada");
    
       BelcorpService bs;
       RecordSet resultado = new RecordSet();
       DTOSalida dtoS = new DTOSalida();
       bs = UtilidadesEJB.getBelcorpService();
  
       StringBuffer query = new StringBuffer();
       
  
       try {
          bs = BelcorpService.getInstance();
    
          query.append(" SELECT DISTINCT ml.oid_meto_liqu_cobr, ml.cod_meto_liqu ");
          query.append(" FROM cob_metod_liqui ml ");
          
          // ********  Agregado por splatas - 06/07/2005    ******** //
          query.append(" WHERE ml.PAIS_OID_PAIS = " + dto.getOidPais());
          // ******************************************************* //
          
          query.append(" ORDER BY UPPER (ml.cod_meto_liqu) ");
             
          resultado = bs.dbService.executeStaticQuery(query.toString());
             
            
       }
       catch(Exception e) {
            UtilidadesLog.error(e);
            throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS));
       }
  
       if (!resultado.esVacio()){
          dtoS.setResultado(resultado);
       }else{
            throw new MareException(null, null, 
              UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE));
       }        

        UtilidadesLog.info("DAOAsignacionUsuarioCronograma.recuperarLiquidacion(DTOBelcorp dto): Salida");

       return dtoS;
    }
    
      /** 
      * Metodo para  recuperar la guia argumental
      * @param DTOBelcorp dto
      * @return DTOSalida
      * @exception MareException 
      * @author mdolce
      * @referencia SICC-DMCO-COM-N015-UnOficial-p2
      */
    
    public DTOSalida recuperarGuiaArgumental(DTOBelcorp dto) throws MareException {
    
        UtilidadesLog.info("DAOAsignacionUsuarioCronograma.recuperarGuiaArgumental(DTOBelcorp dto): Entrada");
    
       BelcorpService bs;
       RecordSet resultado = new RecordSet();
       DTOSalida dtoS = new DTOSalida();
       bs = UtilidadesEJB.getBelcorpService();
  
       StringBuffer query = new StringBuffer();
       
  
       try {
          bs = BelcorpService.getInstance();
    
          query.append(" SELECT DISTINCT gac.oid_guio_argu_cabe, gac.cod_guia_argu ");
          query.append("  FROM cob_guion_argum_cabec gac ");
          
          // ********  Agregado por splatas - 06/07/2005    ******** //
          query.append(" WHERE gac.PAIS_OID_PAIS = " + dto.getOidPais());
          // ******************************************************* //
          
          query.append(" ORDER BY UPPER (gac.cod_guia_argu) ");
             
          resultado = bs.dbService.executeStaticQuery(query.toString());
                 
       }
       catch(Exception e) {
            UtilidadesLog.error(e);
            throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS));
       }
  
       if (!resultado.esVacio()){
          dtoS.setResultado(resultado);
       }else{
            throw new MareException(null, null, 
              UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE));
       }        

        UtilidadesLog.info("DAOAsignacionUsuarioCronograma.recuperarGuiaArgumental(DTOBelcorp dto): Salida");

       return dtoS;
    }
    
      /** 
      * Metodo para  buscar los usuarios de la misma zona
      * @param DTOUsuarEtapaCobraDetal dto
      * @return Boolean
      * @exception MareException 
      * @author mdolce
      * @referencia SICC-DMCO-COM-N015-UnOficial-p2
      * modificaciones: 07/07/2005 - BELC300019761  - pperanzola
      */
   
    public Boolean buscarUsuariosMismaZona(DTOUsuarEtapaCobraDetal dto) throws MareException {
    
        UtilidadesLog.info("DAOAsignacionUsuarioCronograma.buscarUsuariosMismaZona(DTOUsuarEtapaCobraDetal dto): Entrada");
    
      BelcorpService bs;
       RecordSet resultado = new RecordSet();
       DTOSalida dtoS = new DTOSalida();
       bs = UtilidadesEJB.getBelcorpService();
       boolean blnAnd;
       blnAnd = false;
  
       StringBuffer query = new StringBuffer();
       
  
       try {
          bs = BelcorpService.getInstance();
    
          query.append(" SELECT count (*) ");
          query.append(" FROM COB_USUAR_ETAPA_COBRA_DETAL deta  ");
          query.append(" , COB_USUAR_ETAPA_COBRA_CABEC cabec  ");
          query.append(" WHERE ");
          
          if(dto.getOidTerritorio() != null){
             query.append(" deta.TERR_OID_TERR = " + dto.getOidTerritorio());
             query.append(" and deta.ZSCC_OID_SECC = " + dto.getOidSeccion());
             blnAnd = true;
          }else{
             if(dto.getOidSeccion() != null){
                query.append(" deta.ZSCC_OID_SECC  = " + dto.getOidSeccion());
                blnAnd = true;
             }else{
                 if(dto.getOidZona() != null){
                    query.append(" deta.ZZON_OID_ZONA  = " + dto.getOidZona());
                    blnAnd = true;
                 }else{
                    if(dto.getOidRegion() != null){
                       query.append(" deta.ZORG_OID_REGI = " + dto.getOidRegion());
                       blnAnd = true;
                    }else{
                       query.append(" deta.ZSGV_OID_SUBG_VENT = " + dto.getOidSubgeVentas());
                       blnAnd = true;
                    }
                 }
             }
          }
          if (blnAnd){
              query.append(" AND  ");  
          }
          UtilidadesLog.info( ">>>>>>>>>>>>>>>> buscarUsuariosMismaZona: OidEtapaDeuda :" + dto.getOidEtapaDeudaTCarg());
          query.append(" cabec.ETDE_OID_ETAP_DEUD = " + dto.getOidEtapaDeudaTCarg()); 
          query.append(" AND  deta.UECC_OID_USUA_ETAP_COBR  =  cabec.OID_USUA_ETAP_COBR "); 
             
          resultado = bs.dbService.executeStaticQuery(query.toString());
                 
       }
       catch(Exception e) {
            UtilidadesLog.error(e);
            throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS));
       }
       
        UtilidadesLog.info("DAOAsignacionUsuarioCronograma.buscarUsuariosMismaZona(DTOUsuarEtapaCobraDetal dto): Salida");
       
       if (resultado.esVacio()) {
          return new Boolean(false);
       } else {
          BigDecimal totalResultado = (BigDecimal) resultado.getValueAt(0,0); //obtengo el resultado del conteo
          
          if (totalResultado !=null &&  totalResultado.longValue() == 0){
                return new Boolean (false);
          }else{
                return new Boolean(true);
          }
       }

    }
    
      /** 
      * Metodo para  buscar los usuarios del cornograma cobranza detalle
      * @param DTOUsuarEtapaCobraDetal dto
      * @return DTOSalida
      * @exception MareException 
      * @author mdolce
      * @referencia SICC-DMCO-COM-N015-UnOficial-p2
      *  modificaciones: 24/06/2005 - Incidencias COB-03 - pperanzola 
      */
    
    public DTOSalida consultarUsuariosCronogramaCobranzaDetalle (DTOUsuarEtapaCobraDetal dto) throws MareException {
    
        UtilidadesLog.info("DAOAsignacionUsuarioCronograma.consultarUsuariosCronogramaCobranzaDetalle (DTOUsuarEtapaCobraDetal dto): Entrada");
    
       BelcorpService bs;
       RecordSet resultado = new RecordSet();
       DTOSalida dtoS = new DTOSalida();
       bs = UtilidadesEJB.getBelcorpService();
  
       StringBuffer query = new StringBuffer();
       
  
       try {
          bs = BelcorpService.getInstance();
    
          query.append(" SELECT " );
              query.append(" cobrod.oid_usua_etap_cobr_deta AS OID, p.NAME AS nombreusuariodecobranzas, deuda.cod_etap_deud, ");
              //query.append(" cargo.val_desc, marca.des_marc AS descripcion_marca, desccanal.val_i18n AS descripcion_canal, subger.des_subg_vent, ");
              query.append(" i1.val_i18n AS val_desc, marca.des_marc AS descripcion_marca, desccanal.val_i18n AS descripcion_canal, subger.des_subg_vent, ");
              query.append(" region.des_regi, zona.des_zona, seccion.des_secci, territorio.cod_terr ");
          query.append(" FROM ");
              query.append(" cob_usuar_etapa_cobra_detal cobrod, cob_usuar_etapa_cobra_cabec cobroc, ");
              query.append(" cob_etapa_deuda deuda, cob_usuar_cobra usuariocobranza, principals p, ");
              query.append(" users us, ccc_tipo_cargo_abono abono, cob_etapa_deuda_tipo_cargo cargo, ");
              query.append(" seg_marca marca, zon_sub_geren_venta subger, zon_regio region, ");
              query.append(" zon_zona zona, zon_secci seccion, zon_terri territorio, gen_i18n_sicc_comun desccanal, gen_i18n_sicc_pais i1 ");
          query.append(" WHERE ");
              query.append(" cobrod.uecc_oid_usua_etap_cobr = cobroc.oid_usua_etap_cobr ");
              query.append(" AND cobroc.etde_oid_etap_deud = deuda.oid_etap_deud ");
              query.append(" AND cobroc.usco_oid_usua_cobr = usuariocobranza.oid_usua_cobr ");
              query.append(" AND usuariocobranza.user_oid_usua_cobr = p.idprincipal ");
              query.append(" AND p.idprincipal = us.iduser ");
              query.append(" AND cobrod.edtc_oid_etap_deud_tipo_carg = cargo.oid_etap_deud_tipo_carg ");
              query.append(" AND cargo.tcab_oid_tipo_carg_abon = abono.oid_tipo_carg_abon ");
              query.append(" AND cobrod.zorg_oid_regi = region.oid_regi(+) ");
              query.append(" AND cobrod.zsgv_oid_subg_vent = subger.oid_subg_vent ");
              query.append(" AND cobrod.zzon_oid_zona = zona.oid_zona(+)");
              query.append(" AND cobrod.zscc_oid_secc = seccion.oid_secc(+)");
              query.append(" AND cobrod.terr_oid_terr = territorio.oid_terr(+)");
              query.append(" AND subger.marc_oid_marc = marca.oid_marc ");
              query.append(" AND desccanal.attr_enti = 'SEG_CANAL' ");
              query.append(" AND desccanal.idio_oid_idio = " + dto.getOidIdioma());
              query.append(" AND desccanal.val_oid = subger.cana_oid_cana ");
              query.append(" AND i1.attr_enti = 'CCC_TIPO_CARGO_ABONO' ");
              query.append(" AND i1.idio_oid_idio = "+ dto.getOidIdioma());
              query.append(" AND i1.val_oid =  abono.OID_TIPO_CARG_ABON ");
   
	   
          if(dto.getOidUsuarioEtapCobra() != null){
             query.append(" and cobroc.USCO_OID_USUA_COBR = " +  dto.getOidUsuarioEtapCobra());
          }
          
          if(dto.getOidEtapaDeudaTCarg() != null){
             query.append(" AND cobroc.ETDE_OID_ETAP_DEUD = " + dto.getOidEtapaDeudaTCarg()); 
          }

          if(dto.getOidTipoCargo() != null){
             query.append(" AND cobrod.EDTC_OID_ETAP_DEUD_TIPO_CARG = " + dto.getOidTipoCargo());
          }
             
          resultado = bs.dbService.executeStaticQuery(query.toString());
                 
       }
       catch(Exception e) {
            UtilidadesLog.error(e);
            throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS));
       }
  
       if (!resultado.esVacio()){
          dtoS.setResultado(resultado);
       }else{
            throw new MareException(null, null, 
              UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE));
       }        

        UtilidadesLog.info("DAOAsignacionUsuarioCronograma.consultarUsuariosCronogramaCobranzaDetalle (DTOUsuarEtapaCobraDetal dto): Salida");

       return dtoS;   
    }
    
        /** 
      * Metodo para  recuperar el oid de la cabecera
      * @param Long usuarCobra, Long etapaDeuda
      * @return Long oidCabecera
      * @exception MareException 
      * @author mdolce
      * @referencia SICC-DMCO-COM-N015-UnOficial-p2
      */
    
    public Long recuperaOidCabecera(Long usuarCobra, Long etapaDeuda) throws MareException {
    
        UtilidadesLog.info("DAOAsignacionUsuarioCronograma.recuperaOidCabecera(Long usuarCobra, Long etapaDeuda): Entrada");
    
       BelcorpService bs;
       RecordSet resultado = new RecordSet();
       Long oidCabecera = null;
       bs = UtilidadesEJB.getBelcorpService();
  
       StringBuffer query = new StringBuffer();
       
  
       try {
          bs = BelcorpService.getInstance();
    
          query.append(" select cabecera.OID_USUA_ETAP_COBR ");
          query.append(" from   COB_USUAR_ETAPA_COBRA_CABEC cabecera ");
          query.append(" where  cabecera.USCO_OID_USUA_COBR = " + usuarCobra);
          query.append(" and    cabecera.ETDE_OID_ETAP_DEUD = " + etapaDeuda);
             
          resultado = bs.dbService.executeStaticQuery(query.toString());
                 
       }
       catch(Exception e) {
            UtilidadesLog.error(e);
            throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS));
       }
  
       if (!resultado.esVacio()){
           oidCabecera =  new Long(((BigDecimal) resultado.getValueAt(0,0)).longValue());
       }else{
            throw new MareException(null, null, 
              UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE));
       }
       
       UtilidadesLog.debug("salio del dao con este resultado " + oidCabecera);
       
        UtilidadesLog.info("DAOAsignacionUsuarioCronograma.recuperaOidCabecera(Long usuarCobra, Long etapaDeuda): Salida");
       
       return oidCabecera;
    }
    
    /** 
      * Metodo para recuperar los tipos de cargo por etapa deuda, recibiendo como parametro el oidEtapaDeuda
      * @param DTOOID dto
      * @return DTOSalida
      * @exception MareException 
      * @author mamontie
      * @referencia Incidencia Peru
      * modificaciones: 24/06/2005 - Incidencias COB-03 - pperanzola 
      */
    public DTOSalida recuperarTiposCargoPorEtapa(es.indra.sicc.util.DTOOID dto) throws MareException {
    
        UtilidadesLog.info("DAOAsignacionUsuarioCronograma.recuperarTiposCargoPorEtapa(es.indra.sicc.util.DTOOID dto): Entrada");
    
       BelcorpService bs;
       RecordSet resultado = new RecordSet();
       DTOSalida dtoS = new DTOSalida();
       bs = UtilidadesEJB.getBelcorpService();
  
       StringBuffer query = new StringBuffer();
  
       try {
          bs = BelcorpService.getInstance();

          //query.append(" select distinct tca.OID_TIPO_CARG_ABON OID, gen.VAL_I18N DESCRIPCION ");
          query.append(" select distinct edc.OID_ETAP_DEUD_TIPO_CARG OID, gen.VAL_I18N DESCRIPCION   ");
          query.append(" from COB_ETAPA_DEUDA ed, COB_ETAPA_DEUDA_TIPO_CARGO edc, CCC_TIPO_CARGO_ABONO tca  ");
          query.append(" ,GEN_I18N_SICC_PAIS gen  ");
          query.append(" where ed.OID_ETAP_DEUD = edc.ETDE_OID_ETAP_DEUD  ");
          query.append(" and edc.TCAB_OID_TIPO_CARG_ABON = tca.OID_TIPO_CARG_ABON  ");
          query.append(" and ed.OID_ETAP_DEUD = " + dto.getOid() );
          query.append(" and gen.ATTR_ENTI='CCC_TIPO_CARGO_ABONO' ");
          query.append(" and gen.ATTR_NUM_ATRI='1' ");
          query.append(" and gen.VAL_OID=tca.OID_TIPO_CARG_ABON  ");
          query.append(" and gen.IDIO_OID_IDIO = " + dto.getOidIdioma());
          
          // ********  Agregado por splatas - 06/07/2005    ******** //
          query.append(" and tca.pais_oid_pais = " + dto.getOidPais());
          // ******************************************************* //
          
          query.append(" order by gen.VAL_I18N ");
          
          resultado = bs.dbService.executeStaticQuery(query.toString());
            
       }
       catch(Exception e) {
            UtilidadesLog.error(e);
            throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS));
       }
  
       if (!resultado.esVacio()){
          dtoS.setResultado(resultado);
       }else{
            throw new MareException(null, null, 
              UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE));
       }        

        UtilidadesLog.info("DAOAsignacionUsuarioCronograma.recuperarTiposCargoPorEtapa(es.indra.sicc.util.DTOOID dto): Salida");

       return dtoS;
    }
}
