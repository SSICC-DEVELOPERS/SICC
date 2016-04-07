/**
 * Copyright 2003 © por Indra Sistemas,S.A.. Todos los derechos reservados.
 * Avda. de Bruselas, 35
 * Parque Empresarial Arroyo de la Vega
 * 28108 Alcobendas, Madrid
 * España
 *
 * Privado y Confidencial.
 * La información contenida en este documento es propiedad de Indra sistemas.
 * Para uso exclusivo de e69mpleados autorizados no permitiéndose
 * la distribución de este código sin permiso expreso.
 */
package es.indra.sicc.logicanegocio.cob;
import es.indra.mare.common.mii.MareMiiServiceNotFoundException;
import es.indra.mare.common.mii.services.jdbcservice.RecordSet;
import es.indra.sicc.dtos.cob.DTOActualizacionCartera;
import es.indra.sicc.entidades.mae.ClienteComunicacionLocal;
import es.indra.sicc.entidades.mae.ClienteComunicacionLocalHome;
import es.indra.sicc.util.BelcorpService;
import es.indra.sicc.util.CodigosError;
import es.indra.sicc.util.DTOSalida;
import es.indra.mare.common.exception.MareException;
import es.indra.sicc.dtos.cob.DTOConsultarAsignacionCartera;
import es.indra.sicc.util.UtilidadesError;
import es.indra.sicc.util.UtilidadesLog;
import es.indra.sicc.util.UtilidadesPaginacion;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import es.indra.sicc.dtos.cob.DTOEBuscarEtapas;
import es.indra.sicc.dtos.cob.DTOCronogramaCobranza;
import es.indra.sicc.dtos.cob.DTOConsultarResumenAsignacion;
import es.indra.sicc.cmn.negocio.comun.DTOComunes.DTOOIDPaginado;
import javax.ejb.SessionContext;
import es.indra.sicc.logicanegocio.ccc.CCCConstantes;
import es.indra.sicc.dtos.ccc.DTOEtapasDeCobranzas;
import es.indra.sicc.logicanegocio.mae.ConstantesMAE;

import javax.persistence.NoResultException;
import javax.persistence.PersistenceException;


public class DAOAsignacionCarteraPeriodo 
{
  SessionContext ctx = null;
  public DAOAsignacionCarteraPeriodo()
  {
  }
  public void setSessionContext(SessionContext ctx)
  {
    this.ctx = ctx;
  }  
  public DAOAsignacionCarteraPeriodo(SessionContext ctx)
  {
    this.setSessionContext(ctx);
  }  
  /** 
  * Metodo para obtener los detalles de cobranza
  * @param DTOOIDPaginado dto
  * @return DTOSalida
  * @exception MareException 
  * @author enozigli
  * @referencia SICC-DMCO-COB-201-324-N037
  */
  public DTOSalida detalleCobranza(DTOOIDPaginado dto) throws MareException{
      UtilidadesLog.info("DAOAsignacionCarteraPeriodo.detalleCobranza(DTOOIDPaginado dto): Entrada");
      
      UtilidadesLog.info("- DTOOIDPaginado: " + dto);
      DTOSalida dtoS = new DTOSalida();
      RecordSet rs = new RecordSet();
      StringBuffer query = new StringBuffer();
      BelcorpService bs;
      try{   
         bs = BelcorpService.getInstance();
      }
      catch(MareMiiServiceNotFoundException ex) {   
         throw new MareException(ex, UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_PEDIR_UN_SERVICIO_MARE));
      }      
      
      // Modificado by ssantana, 30/8/2005, (COB-4 PERU) 
      query.append(" SELECT * ");
      query.append(" FROM (SELECT ROWNUM OID, x.* ");
      query.append(" FROM ( ");
      
      query.append(" SELECT pr.NAME usuariocobranza, "); 
      query.append(" etap.cod_etap_deud cod_etapa, tipocargo.cod_tipo_carg_abon, ");
      query.append(" marc.des_marc, v1.val_i18n iCanal, peri.val_nomb_peri desc_peri, ");
      query.append(" subge.des_subg_vent desc_sbgvtas, regio.des_regi desc_region, ");
      query.append(" zona.des_zona desc_zona, sexy.des_secci desc_seccion, ");
      query.append(" cliente.cod_clie cod_cliente, v2.val_i18n iEstadoAsign, ");
      query.append(" SUM (cac.imp_deud_asig) deuda_asignada, ");
      query.append(" SUM (cac.imp_deud_canc) deuda_cancelada, ");
      query.append(" cac.fec_asig fecha_asignacion ");
      query.append(" FROM cob_usuar_cobra uscob, ");
      query.append(" cob_crono_cobra crono, ");
      query.append(" cob_asign_cobra cac, ");
      query.append(" cob_etapa_deuda etap, ");
      query.append(" ccc_tipo_cargo_abono tipocargo, ");
      query.append(" cra_perio peri, ");
      query.append(" seg_marca marc, ");
      query.append(" principals pr, ");
      query.append(" users us, ");
      query.append(" cob_estad_asign estad, ");
      query.append(" zon_terri_admin terriadmin, ");
      query.append(" zon_sub_geren_venta subge, ");
      query.append(" zon_regio regio, ");
      query.append(" zon_secci sexy, ");
      query.append(" zon_zona zona, ");
      query.append(" mae_clien cliente, ");
      query.append(" ccc_movim_cuent_corri movicc, ");
      query.append(" cob_etapa_deuda_tipo_cargo cedtc, ");
      query.append(" v_gen_i18n_sicc v1, ");
      query.append(" v_gen_i18n_sicc v2 ");
      query.append(" WHERE crono.oid_cron_cobr = " + dto.getOid());
      query.append(" AND cac.crco_oid_cron_cobr = crono.oid_cron_cobr ");
      query.append(" AND crono.pais_oid_pais = " + dto.getOidPais());
      query.append(" AND crono.usco_oid_usua_cobr = uscob.oid_usua_cobr ");
      query.append(" AND uscob.user_oid_usua_cobr = us.iduser ");
      query.append(" AND us.iduser = pr.idprincipal ");
      query.append(" AND etap.oid_etap_deud = crono.etde_oid_etap_deud ");
      query.append(" AND crono.tcab_oid_tipo_carg_abon = cedtc.tcab_oid_tipo_carg_abon ");
      query.append(" AND etap.pais_oid_pais = " + dto.getOidPais());
      query.append(" AND cedtc.tcab_oid_tipo_carg_abon = tipocargo.oid_tipo_carg_abon ");
      query.append(" AND cedtc.etde_oid_etap_deud = etap.oid_etap_deud ");
      query.append(" AND etap.pais_oid_pais = " + dto.getOidPais());
      query.append(" AND tipocargo.pais_oid_pais = " + dto.getOidPais());
      query.append(" AND peri.oid_peri = crono.perd_oid_peri ");
      query.append(" AND marc.oid_marc = peri.marc_oid_marc ");
      query.append(" AND terriadmin.zscc_oid_secc = sexy.oid_secc ");
      query.append(" AND sexy.zzon_oid_zona = zona.oid_zona ");
      query.append(" AND zona.zorg_oid_regi = regio.oid_regi ");
      query.append(" AND regio.zsgv_oid_subg_vent = subge.oid_subg_vent ");
      query.append(" AND estad.oid_esta_asig = cac.esas_oid_esta_asig ");
      
      // Se filtra por Estado Asignacion "Abierta" segun indica el DECU.-
      query.append(" AND cac.esas_oid_esta_asig = " + ConstantesCOB.OID_ESTA_ASIG_ABIERTA);
      
      query.append(" AND movicc.oid_movi_cc = cac.mvcc_oid_movi_cc ");
      query.append(" AND movicc.marc_oid_marc = marc.oid_marc ");
      query.append(" AND movicc.perd_oid_peri = peri.oid_peri ");
      query.append(" AND cliente.oid_clie = movicc.clie_oid_clie ");
      query.append(" AND movicc.ztad_oid_terr_admi = terriadmin.oid_terr_admi ");
      query.append(" AND movicc.zorg_oid_regi = regio.oid_regi ");
      query.append(" AND movicc.zscc_oid_secc = sexy.oid_secc ");
      query.append(" AND movicc.zsgv_oid_subg_vent = subge.oid_subg_vent ");
      query.append(" AND v1.attr_enti = 'SEG_CANAL' ");
      query.append(" AND v1.attr_num_atri = 1 ");
      query.append(" AND v1.idio_oid_idio = " + dto.getOidIdioma());
      query.append(" AND v1.val_oid = peri.cana_oid_cana ");
      query.append(" AND v2.attr_enti = 'COB_ESTAD_ASIGN' ");
      query.append(" AND v2.attr_num_atri = 1 ");
      query.append(" AND v2.idio_oid_idio = " + dto.getOidIdioma());
      query.append(" AND v2.val_oid = estad.oid_esta_asig ");
      query.append(" GROUP BY ");
      query.append(" pr.NAME, ");
      query.append(" etap.cod_etap_deud, ");
      query.append(" tipocargo.cod_tipo_carg_abon, ");
      query.append(" marc.des_marc, ");
      query.append(" v1.val_i18n, ");
      query.append(" peri.val_nomb_peri, ");
      query.append(" subge.des_subg_vent, ");
      query.append(" regio.des_regi, ");
      query.append(" zona.des_zona, ");
      query.append(" sexy.des_secci, ");
      query.append(" cliente.cod_clie, ");
      query.append(" v2.val_i18n, ");
      /*query.append(" cac.imp_deud_asig, ");
      query.append(" cac.imp_deud_canc, ");*/
      query.append(" cac.fec_asig ");

      query.append(") x) ");
      query.append(" WHERE ROWNUM <= " + dto.getTamanioPagina() ); 
      query.append(" AND OID > " + dto.getIndicadorSituacion() );
      // Fin Modificacion by ssantana, 30/8/2005, (COB-4 PERU) 
      
       try {   
            //rs = bs.dbService.executeStaticQuery(UtilidadesPaginacion.armarQueryPaginacion(query.toString(),dto));
           rs = bs.dbService.executeStaticQuery(query.toString());
       }catch (Exception ex) {   
            throw new MareException(ex, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS));
       }	
       UtilidadesLog.info("rs: " + rs);
       if (rs.esVacio())  {
          throw new MareException(new Exception(), UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE));                
       }
      
      dtoS.setResultado(rs);
      
      UtilidadesLog.info("DAOAsignacionCarteraPeriodo.detalleCobranza(DTOOIDPaginado dto): Salida");
      
      return dtoS;  
  }
  /** 
  * Metodo para
  * @param DTOConsultarAsignacionCartera dto
  * @return DTOSalida
  * @exception MareException 
  * @author enozigli
  * @referencia SICC-DMCO-COB-201-324-N037 e incidencia 13432
  */
  public DTOSalida consultarAsignacionCartera(DTOConsultarAsignacionCartera dto) throws MareException{
  
      UtilidadesLog.info("DAOAsignacionCarteraPeriodo.consultarAsignacionCartera(DTOConsultarAsignacionCartera dto): Entrada");
  
      DTOSalida dtoS = new DTOSalida();
      RecordSet rs = new RecordSet();
      StringBuffer query = new StringBuffer();
      BelcorpService bs;
      SimpleDateFormat simpledateformat = new SimpleDateFormat("dd-MM-yyyy");
      try
      {   bs = BelcorpService.getInstance();
      }
      catch(MareMiiServiceNotFoundException ex)
      {   throw new MareException(ex, UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_PEDIR_UN_SERVICIO_MARE));
      }      
       
      query.append(" SELECT crono.oid_cron_cobr OID, pr.NAME usuariocobranza, etapa.cod_etap_deud cod_etapa, marca.des_marc desc_marca,  "); 
      query.append(" (SELECT I18N.VAL_I18N FROM V_GEN_I18N_SICC I18N WHERE I18N.ATTR_ENTI='SEG_CANAL' AND I18N.ATTR_NUM_ATRI=1 AND I18N.IDIO_OID_IDIO= "+dto.getOidIdioma()+" AND I18N.VAL_OID=crperio.cana_oid_cana) desc_canal, ");
      query.append(" peri.COD_PERI desc_peri,crono.FEC_ASIG fechaasignacion  "); //inc. 14673
      query.append(" FROM cob_usuar_cobra uscob,  "); 
      query.append(" cob_crono_cobra crono,  "); 
      query.append(" principals pr,  "); 
      query.append(" users us,  "); 
      query.append(" cob_etapa_deuda etapa,  "); 
      query.append(" cra_perio crperio,  "); 
      query.append(" seg_marca marca,  "); 
      query.append(" seg_canal canal,  "); 
      query.append(" seg_perio_corpo peri  ");//inc. 14673
      query.append(" WHERE crono.usco_oid_usua_cobr = uscob.oid_usua_cobr  "); 
      query.append(" AND uscob.user_oid_usua_cobr = us.iduser  "); 
      query.append(" AND us.iduser = pr.idprincipal  "); 
      query.append(" AND etapa.oid_etap_deud = crono.etde_oid_etap_deud  "); 
      query.append(" AND crperio.PERI_OID_PERI = peri.OID_PERI "); //inc. 14673
      if (dto.getOidEtapa()!=null){
        query.append(" AND etapa.oid_etap_deud = "+dto.getOidEtapa()+" "); 
      }
      if (dto.getOidMarca()!=null){
        query.append(" AND marca.oid_marc = "+dto.getOidMarca()+" "); 
      }
      query.append(" AND marca.oid_marc = crperio.marc_oid_marc  "); 
      if (dto.getOidCanal()!=null){
        query.append(" AND canal.oid_cana = "+dto.getOidCanal()+" "); 
      }
      query.append(" AND canal.oid_cana = crperio.cana_oid_cana  ");                 
      query.append(" AND crperio.oid_peri = crono.perd_oid_peri ");
      if (dto.getOidPeriodo()!=null){
        query.append(" AND crperio.oid_peri = "+dto.getOidPeriodo()+" "); 
      }
      if (dto.getFechaAsignacion()!=null){
        String fechaAsign = simpledateformat.format(dto.getFechaAsignacion());
        query.append(" and crono.FEC_ASIG = TO_DATE( '" + fechaAsign + "', 'DD-MM-YYYY') ");  
      }      
      // Agregado por ssantana, 17/5/2005
      query.append(" AND crono.fec_asig IS NOT NULL ");

       try 
        {   rs = bs.dbService.executeStaticQuery(UtilidadesPaginacion.armarQueryPaginacion(query.toString(),dto));

        }
       catch (Exception ex) 
       {   throw new MareException(ex, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS));
       }	
        if (rs.esVacio())
        {
           throw new MareException(new Exception(), UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE));
        }       
       dtoS.setResultado(rs);
       
      UtilidadesLog.info("DAOAsignacionCarteraPeriodo.consultarAsignacionCartera(DTOConsultarAsignacionCartera dto): Salida");
       
       return dtoS;  
  }
  /** 
  * Metodo para
  * @param DTOEBuscarEtapas dto
  * @return DTOSalida
  * @exception MareException 
  * @author 
  * @referencia SICC-DMCO-COB-201-324-N037
  */
  public DTOSalida listadoEtapas(DTOEBuscarEtapas dto) throws MareException{
  
      UtilidadesLog.info("DAOAsignacionCarteraPeriodo.listadoEtapas(DTOEBuscarEtapas dto): Entrada");
  
  
      DTOSalida dtoS = new DTOSalida();
      RecordSet rs = new RecordSet();
      StringBuffer query = new StringBuffer();
      BelcorpService bs;
      SimpleDateFormat simpledateformat = new SimpleDateFormat("dd-MM-yyyy");
      try
      {   bs = BelcorpService.getInstance();
      }
      catch(MareMiiServiceNotFoundException ex)
      {   throw new MareException(ex, UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_PEDIR_UN_SERVICIO_MARE));
      }      

      query.append(" SELECT crono.COD_CART KEY, crono.COD_CART idCartera, ");
      query.append(" pr.NAME usuCob, ");
      query.append(" etap.VAL_DESC etapa, ");
      query.append(" i18n.VAL_I18N tipoCargo, "); 
      query.append(" marca.DES_MARC marca, "); 
      query.append(" i18nCana.VAL_I18N canal, "); 
      query.append(" craperi.VAL_NOMB_PERI, "); 
      query.append(" subge.DES_SUBG_VENT subgerencia, "); 
      query.append(" regi.DES_REGI region, "); 
      query.append(" zon.DES_ZONA zona, "); 
      query.append(" sexy.DES_SECCI seccion, "); 
      query.append(" terri.COD_TERR territorio, "); 
      query.append(" crono.FEC_CIER fechaCierre, "); 
      //estos campos en la lista donde se mostraran van ocultos 
      query.append(" crono.OID_CRON_COBR oidCronograma, ");
      query.append(" crono.USCO_OID_USUA_COBR oidUsuarioCob, "); 
      query.append(" crono.ETDE_OID_ETAP_DEUD oidEtapa, ");
      query.append(" crono.TCAB_OID_TIPO_CARG_ABON oidTipoCargoAbono, ");
      query.append(" craperi.MARC_OID_MARC oidMarca, "); 
      query.append(" craperi.CANA_OID_CANA oidCanal, "); 
      query.append(" crono.PERD_OID_PERI oidPeriodo, "); 
      query.append(" crono.ZSGV_OID_SUBG_VENT oidSubgerenciaVentas, "); 
      query.append(" crono.ZORG_OID_REGI oidRegion, "); 
      query.append(" crono.ZZON_OID_ZONA oidZona, "); 
      query.append(" crono.ZSCC_OID_SECC oidSeccion, "); 
      query.append(" crono.TERR_OID_TERR oidTerritorio "); 
      query.append(" FROM cob_crono_cobra crono, "); 
      query.append(" cob_etapa_deuda etap, "); 
      query.append(" cra_perio craperi, "); 
      query.append(" seg_marca marca, "); 
      query.append(" seg_canal canal, "); 
      query.append(" cob_usuar_cobra usu, "); 
      query.append(" principals pr, "); 
      query.append(" users us, "); 
      query.append(" v_gen_i18n_sicc i18n, ");
      query.append(" v_gen_i18n_sicc i18nCana, ");  
      query.append(" ZON_SUB_GEREN_VENTA subge, "); 
      query.append(" ZON_REGIO regi, "); 
      query.append(" ZON_ZONA zon, "); 
      query.append(" ZON_SECCI sexy, "); 
      query.append(" ZON_TERRI terri ");
      query.append(" where crono.ETDE_OID_ETAP_DEUD = etap.OID_ETAP_DEUD "); 
      query.append(" and crono.PAIS_OID_PAIS = "+dto.getOidPais()+" ");
      query.append(" and crono.PERD_OID_PERI = "+dto.getPeriodo()+" ");
      query.append(" and craperi.OID_PERI = crono.PERD_OID_PERI "); 
      query.append(" and craperi.MARC_OID_MARC = "+dto.getMarca()+" ");
      query.append(" and craperi.CANA_OID_CANA = "+dto.getCanal()+" ");
      query.append(" and marca.OID_MARC = craperi.MARC_OID_MARC "); 
      query.append(" and canal.OID_CANA = craperi.CANA_OID_CANA "); 
      query.append(" and crono.USCO_OID_USUA_COBR = usu.OID_USUA_COBR "); 
      query.append(" and usu.USER_OID_USUA_COBR = us.IDUSER "); 
      query.append(" and us.IDUSER = pr.IDPRINCIPAL "); 
      //tipo cargo abono es internacionalizable 
      query.append(" and i18n.ATTR_ENTI = 'CCC_TIPO_CARGO_ABONO' "); 
      query.append(" and i18n.IDIO_OID_IDIO = "+dto.getOidIdioma()+" ");
      query.append(" and i18n.ATTR_NUM_ATRI = 1 "); 
      query.append(" and i18n.VAL_OID = crono.TCAB_OID_TIPO_CARG_ABON ");
      //el canal es internacionalizable 
      query.append(" and i18nCana.ATTR_ENTI = 'SEG_CANAL' "); 
      query.append(" and i18nCana.IDIO_OID_IDIO = "+dto.getOidIdioma()+" ");
      query.append(" and i18nCana.ATTR_NUM_ATRI = 1 "); 
      query.append(" and i18nCana.VAL_OID = canal.OID_CANA ");
      query.append(" and crono.TERR_OID_TERR = terri.OID_TERR(+) ");
      query.append(" and crono.ZSCC_OID_SECC = sexy.OID_SECC(+) ");
      query.append(" and crono.ZZON_OID_ZONA = zon.OID_ZONA(+) ");
      query.append(" and crono.ZORG_OID_REGI = regi.OID_REGI(+) ");
      query.append(" and crono.ZSGV_OID_SUBG_VENT = subge.OID_SUBG_VENT "); 
      //String fechaSys = simpledateformat.format(new Date(System.currentTimeMillis()));      
      //query.append(" and crono.FEC_CIER <= TO_DATE('"+fechaSys+"','DD-MM-YYYY') ");
      query.append(" and crono.FEC_ASIG is null "); 
      query.append(" ORDER BY idCartera, subgerencia, region, zona, seccion, territorio ");

       try 
        {   rs = bs.dbService.executeStaticQuery(query.toString());
        }
       catch (Exception ex) 
       {   throw new MareException(ex, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS));
       }	
       
        if( rs.esVacio() ){
            UtilidadesLog.debug("************** No hay registros, se lanza la MareException");          
            throw new MareException(new Exception(),UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE));
        }     
       
       dtoS.setResultado(rs);
       
        UtilidadesLog.info("DAOAsignacionCarteraPeriodo.listadoEtapas(DTOEBuscarEtapas dto): Salida");
       
       return dtoS;  
  }
  /** 
  * Metodo para
  * @param Long oidTipoCOmunicacion, Long oidCliente
  * @return Boolean
  * @exception MareException 
  * @author 
  * @referencia SICC-DMCO-COB-201-324-N037
  */
  public Boolean validarTelefono(Long oidTipoCOmunicacion, Long oidCliente) throws MareException{
  
        UtilidadesLog.info("DAOAsignacionCarteraPeriodo.validarTelefono(Long oidTipoCOmunicacion, Long oidCliente): Entrada");
  
    try{
        UtilidadesLog.info( "oidTipoCOmunicacion " + oidTipoCOmunicacion  ); 
       UtilidadesLog.info( "oidCliente " + oidCliente ); 
       ClienteComunicacionLocalHome cclh = new ClienteComunicacionLocalHome();
       ClienteComunicacionLocal ccl = cclh.findByUK(oidCliente, oidTipoCOmunicacion);
        UtilidadesLog.info("DAOAsignacionCarteraPeriodo.validarTelefono(Long oidTipoCOmunicacion, Long oidCliente): Salida");
       
       return Boolean.TRUE;       
    } catch (NoResultException e) {
        UtilidadesLog.info("NoResultException  FALSE"); 
        UtilidadesLog.info("DAOAsignacionCarteraPeriodo.validarTelefono(Long oidTipoCOmunicacion, Long oidCliente): Salida");
      return Boolean.FALSE;      
    } catch (PersistenceException e) {
        UtilidadesLog.error("ERROR: ", e);
        throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS));
    }
  }
  /** 
  * Metodo para obtener el oid de usuario especial del pais si existe 
  * @param Long oidpais
  * @return Long oid usuario si existe sino null
  * @exception MareException 
  * @author enozigli 28/02/2005
  * @referencia SICC-DMCO-COB-201-324-N037
  */
  public Long buscarUsuarioEspecial(Long oidPais) throws MareException{
  
    UtilidadesLog.info("DAOAsignacionCarteraPeriodo.buscarUsuarioEspecial(Long oidPais): Entrada");
  
      Long oidUsuarioEspecial = null;
      RecordSet rs = new RecordSet();
      StringBuffer query = new StringBuffer();
      BelcorpService bs;
      try
      {   bs = BelcorpService.getInstance();
      }
      catch(MareMiiServiceNotFoundException ex)
      {   throw new MareException(ex, UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_PEDIR_UN_SERVICIO_MARE));
      }      

      query.append(" SELECT cuc.OID_USUA_COBR OID");
      query.append(" FROM COB_USUAR_COBRA cuc ");
      query.append(" WHERE cuc.IND_USUA_SUPE = 1 ");//1 porque es boolean (true = 1)
      query.append(" AND cuc.PAIS_OID_PAIS = "+oidPais+" ");     

       try 
        {   rs = bs.dbService.executeStaticQuery(query.toString());
            if (rs.esVacio()) { return null; }
            else {
              oidUsuarioEspecial = BigToLong(rs.getValueAt(0,"OID"));
            }
        }
       catch (Exception ex){  
            UtilidadesLog.error(ex);
            throw new MareException(ex, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS));
       }
       
        UtilidadesLog.info("DAOAsignacionCarteraPeriodo.buscarUsuarioEspecial(Long oidPais): Salida");
       
       return oidUsuarioEspecial;  
  }
  /** 
  * Metodo para
  * @param DTOActualizacionCartera dto
  * @return RecordSet
  * @exception MareException 
  * @author 
  * @referencia SICC-DMCO-COB-201-324-N037
  */
  public RecordSet buscarAsignacionCobranza(DTOActualizacionCartera dto) throws MareException{
  
    UtilidadesLog.info("DAOAsignacionCarteraPeriodo.buscarAsignacionCobranza(DTOActualizacionCartera dto): Entrada");
  
      RecordSet rs = new RecordSet();
      StringBuffer query = new StringBuffer();
      BelcorpService bs;
      try
      {   bs = BelcorpService.getInstance();
      }
      catch(MareMiiServiceNotFoundException ex){   
          UtilidadesLog.error(ex);
          throw new MareException(ex, UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_PEDIR_UN_SERVICIO_MARE));
      }      
      query.append("  SELECT asi.OID_ASIG_COBR ");
      query.append("  FROM COB_ASIGN_COBRA asi ");
      query.append("  WHERE asi.HICC_OID_HIST_COMI_COBR IS NULL ");
      query.append("  AND asi.MVCC_OID_MOVI_CC = "+dto.getOidCuota()+" ");
      try 
        {   rs = bs.dbService.executeStaticQuery(query.toString());  }
       catch (Exception ex){   
           UtilidadesLog.error(ex);
           throw new MareException(ex, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS));
       }
       
        UtilidadesLog.info("DAOAsignacionCarteraPeriodo.buscarAsignacionCobranza(DTOActualizacionCartera dto): Salida");
       
       return rs;  
  }
  /** 
  * Metodo para
  * @param DTOCronogramaCobranza dto, Long idCartera
  * @return void
  * @exception MareException 
  * @author 
  * @referencia SICC-DMCO-COB-201-324-N037
  */
  public void asignarCobranza(DTOCronogramaCobranza dto, Long idCartera) throws MareException
  {
  }
  /** 
  * Metodo para
  * @param DTOConsultarResumenAsignacion dto
  * @return DTOSalida
  * @exception MareException 
  * @author 
  * @referencia SICC-DMCO-COB-201-324-N037
  */
   public DTOSalida consultarResumenAsignacion(DTOConsultarResumenAsignacion dto) throws MareException{
   
        UtilidadesLog.info("DAOAsignacionCarteraPeriodo.consultarResumenAsignacion(DTOConsultarResumenAsignacion dto): Entrada");
  
      DTOSalida dtoS = new DTOSalida();
      RecordSet rs = new RecordSet();
      StringBuffer query = new StringBuffer();
      BelcorpService bs;
      SimpleDateFormat simpledateformat = new SimpleDateFormat("dd-MM-yyyy");
      try
      {   bs = BelcorpService.getInstance();
      }
      catch(MareMiiServiceNotFoundException ex){   
          UtilidadesLog.error(ex);
          throw new MareException(ex, UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_PEDIR_UN_SERVICIO_MARE));
      }      
       
      query.append("  SELECT usucob.oid_usua_cobr OID, princ.NAME codigousuario,  etapa.cod_etap_deud codigoetapa, ");
      query.append("  marca.des_marc marca, i18n.val_i18n desc_canal, " );
      query.append("  segperi.cod_peri periodo,");
      query.append("  Count(distinct regi.OID_REGI) Regiones, Count (distinct zon.OID_ZONA), " );
      query.append("  Count (distinct client.OID_CLIE), SUM (asigna.imp_deud_asig) as deudaAsignada " );
      query.append("  FROM v_gen_i18n_sicc i18n, cob_crono_cobra crono, cob_asign_cobra asigna, ");
      query.append("  mae_clien client, cob_usuar_cobra usucob,principals princ, users users, cob_etapa_deuda etapa, ");
	    query.append("  seg_marca marca,seg_canal canal, cra_perio craperi, seg_perio_corpo segperi, ccc_movim_cuent_corri movicc, ");
	    query.append("  zon_terri_admin terriadmin, zon_secci sexy, zon_zona zon, zon_regio regi ");
      
      query.append("  WHERE crono.oid_cron_cobr = asigna.crco_oid_cron_cobr ");
      
      if (dto.getOidPais() != null){
          query.append(" AND usucob.pais_oid_pais = " + dto.getOidPais());              
          query.append(" AND client.PAIS_OID_PAIS = " + dto.getOidPais());              
      
      }
      
      if (dto.getOidUsuarioCobranza() != null){
          query.append(" AND usucob.oid_usua_cobr = " + dto.getOidUsuarioCobranza());
          query.append(" AND crono.usco_oid_usua_cobr = " + dto.getOidUsuarioCobranza());
          //query.append(" AND princ.idprincipal = " + dto.getOidUsuarioCobranza()); lo comente porque no esta bien y ademas creo que no es necesario
         
      }
     
      
      if (dto.getCodigoCliente() != null){
          query.append(" AND client.cod_clie = '" + dto.getCodigoCliente()+"' " );
      }
      

      if (dto.getOidIdioma() != null){
            query.append(" AND i18n.idio_oid_idio = " + dto.getOidIdioma() );
      }
      
      query.append(" AND crono.usco_oid_usua_cobr = usucob.oid_usua_cobr ");
      query.append(" AND movicc.OID_MOVI_CC = asigna.MVCC_OID_MOVI_CC ");
      query.append(" AND movicc.MARC_OID_MARC = marca.OID_MARC ");
      query.append(" AND users.iduser = princ.idprincipal ");
      query.append(" AND usucob.USER_OID_USUA_COBR = users.IDUSER "); 
      query.append(" AND i18n.attr_enti = 'SEG_CANAL' ");
      query.append(" AND i18n.val_oid = craperi.cana_oid_cana ");
      query.append(" AND client.oid_clie = movicc.clie_oid_clie ");
      //query.append(" AND movicc.oid_movi_cc = asigna.mvcc_oid_movi_cc ");
      query.append(" AND crono.etde_oid_etap_deud = etapa.oid_etap_deud "); 
      query.append(" AND movicc.perd_oid_peri = craperi.oid_peri ");
      query.append(" AND craperi.peri_oid_peri = segperi.oid_peri ");
      query.append(" AND craperi.cana_oid_cana = canal.oid_cana ");
      //query.append(" AND client.OID_CLIE = clienAdmin.CLIE_OID_CLIE "); 
      //query.append(" AND clienAdmin.ZTAD_OID_TERR_ADMI = terriadmin.oid_terr_admi ");
      //query.append(" AND clienAdmin.IND_ACTI = 1 ");
      query.append(" AND movicc.ZTAD_OID_TERR_ADMI = terriadmin.OID_TERR_ADMI ");
      query.append(" AND terriadmin.zscc_oid_secc = sexy.oid_secc ");
      query.append(" AND sexy.zzon_oid_zona = zon.oid_zona ");
      query.append(" AND zon.zorg_oid_regi = regi.oid_regi "); 
      
      query.append(" AND asigna.ESAS_OID_ESTA_ASIG = " + ConstantesCOB.OID_ESTA_ASIG_ABIERTA );
            
      query.append(" GROUP BY usucob.oid_usua_cobr,princ.NAME, etapa.cod_etap_deud,  " );
      query.append(" marca.des_marc,i18n.val_i18n,segperi.cod_peri " );
      
      
      try 
        {   rs = bs.dbService.executeStaticQuery(UtilidadesPaginacion.armarQueryPaginacion(query.toString(),dto));
        }
       catch (Exception ex){
           UtilidadesLog.error(ex);
           throw new MareException(ex, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS));
       }
        if (rs.esVacio())
        {
           throw new MareException(new Exception(), UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE));
        }           
        dtoS.setResultado(rs);
       
        UtilidadesLog.info("DAOAsignacionCarteraPeriodo.consultarResumenAsignacion(DTOConsultarResumenAsignacion dto): Salida");
       
        return dtoS;  
    }

  /** 
  * Metodo de apoyo que transforma un BigDecimal a Long
  * @param Object num
  * @return Long
  * @exception 
  * @author enozigli
  * @referencia 
  */  
  private Long BigToLong(Object num) {
    if (num != null) {
        return (new Long(((BigDecimal) num).longValue()));
    } else {
        return null;
    }
  }  
  
  /**
   * @author: ssantana, 13/9/2005, por inc. PERU COB-04
   * @throws es.indra.mare.common.exception.MareException
   * @return Long
   * @param Long oidUsuarioEspecial
   * @param Long oidEtapaDeuda
   * @descripcion: Retorna el Oid de Usuario supervisor
   *  en caso de existir un Cronograma de Cobranzas de este mismo.
   *
   */
  public Long verificarUsuarioEspecial(Long oidEtapaDeuda, Long oidUsuarioEspecial) throws MareException {
  
    UtilidadesLog.info("DAOAsignacionCarteraPeriodo.verificarUsuarioEspecial(Long oidEtapaDeuda, Long oidUsuarioEspecial):Entrada");
    BelcorpService bs = BelcorpService.getInstance();
    RecordSet r = null;
    BigDecimal bigBuffer = null;
    Long oidRetorno = null;
    StringBuffer sqlQuery = new StringBuffer("");
    
    sqlQuery.append(" SELECT cob_crono_cobra.oid_cron_cobr ");
    sqlQuery.append(" FROM cob_crono_cobra, cob_etapa_deuda ");
    sqlQuery.append(" WHERE cob_etapa_deuda.oid_etap_deud = " + oidEtapaDeuda);
    sqlQuery.append(" AND cob_crono_cobra.etde_oid_etap_deud = cob_etapa_deuda.oid_etap_deud ");
    sqlQuery.append(" AND cob_crono_cobra.usco_oid_usua_cobr = " + oidUsuarioEspecial);
    
    try {
      r = bs.dbService.executeStaticQuery(sqlQuery.toString());
      UtilidadesLog.debug("r: " + r);
    } catch (Exception ex) {
       UtilidadesLog.error(ex);
       String sCodigoError = CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS;
       throw new MareException(ex, UtilidadesError.armarCodigoError(sCodigoError));
    }
    
    if ( !r.esVacio() ) {
      bigBuffer = (BigDecimal) r.getValueAt(0,0);
      oidRetorno = new Long(bigBuffer.longValue());
    }
    
    UtilidadesLog.info("DAOAsignacionCarteraPeriodo.verificarUsuarioEspecial(Long oidEtapaDeuda, Long oidUsuarioEspecial):Salida");
    return oidRetorno;
    
  }  
  
  
  /**
   * 
   * @return RecordSet 
   * @throws es.indra.mare.common.exception.MareException
   * @author: ssantana, 14/9/2005, por inc. COB-04
   * @param Long oidCliente
   */
  public RecordSet recuperarEtapasCliente(Long oidCliente) throws MareException {
    UtilidadesLog.info("DAOAsignacionCarteraPeriodo.recuperarEtapasCliente(Long oidCliente):Entrada");
    RecordSet r = null;
    BelcorpService bs = BelcorpService.getInstance();
    BigDecimal bigBuffer = null;
    Long oidRetorno = null;
    
    StringBuffer sqlQuery = new StringBuffer("");
    sqlQuery.append(" SELECT   eta.oid_etap_deud oids, eta.val_edad_inic ");
    sqlQuery.append(" FROM cob_etapa_deuda eta ");
    sqlQuery.append(" WHERE eta.oid_etap_deud IN ( ");
    sqlQuery.append(" SELECT cron.etde_oid_etap_deud ");
    sqlQuery.append(" FROM cob_crono_cobra cron ");
    sqlQuery.append(" WHERE cron.oid_cron_cobr IN ( ");
    sqlQuery.append(" SELECT asi.crco_oid_cron_cobr ");
    sqlQuery.append(" FROM cob_asign_cobra asi ");
    sqlQuery.append(" WHERE asi.esas_oid_esta_asig = " + ConstantesCOB.OID_ESTA_ASIG_ABIERTA);
    sqlQuery.append(" AND asi.mvcc_oid_movi_cc IN ( ");
    sqlQuery.append(" SELECT cuot.oid_movi_cc ");
    sqlQuery.append(" FROM ccc_movim_cuent_corri cuot ");
    sqlQuery.append(" WHERE cuot.clie_oid_clie = " + oidCliente + "))) ");
    sqlQuery.append(" ORDER BY eta.val_edad_inic ");
    
    try { 
       r = bs.dbService.executeStaticQuery(sqlQuery.toString());
       UtilidadesLog.debug("r: " + r);
    } catch (Exception ex) {
       UtilidadesLog.error(ex);
       String sCodigoError = CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS;
       throw new MareException(ex, UtilidadesError.armarCodigoError(sCodigoError));
    }
    UtilidadesLog.info("DAOAsignacionCarteraPeriodo.recuperarEtapasCliente(Long oidCliente):Salida");
    return r;
    
  }
  
  /**
   * @author: ssantana, 14/9/2005, por inc. COB-04
   * @throws es.indra.mare.common.exception.MareException
   * @return RecordSet
   * @param Long[] oidEtapas
   * @param Long oidCliente
   */
  public RecordSet recuperarCuotasEtapasCliente(Long oidCliente, Long[] oidEtapas) throws MareException {
    UtilidadesLog.info("DAOAsignacionCarteraPeriodo.recuperarEtapasCliente(Long oidCliente):Entrada");
    BelcorpService bs = BelcorpService.getInstance();
    RecordSet r = null;
    BigDecimal bigBuffer = null;
    
    String clausulaIN = this.includeIN("eta.OID_ETAP_DEUD", oidEtapas);
    
    StringBuffer sqlQuery = new StringBuffer("");
    sqlQuery.append(" SELECT eta.VAL_EDAD_INIC, cuot.oid_movi_cc,cron.OID_CRON_COBR, ");
    sqlQuery.append(" asi.OID_ASIG_COBR ");
    sqlQuery.append(" FROM ccc_movim_cuent_corri cuot, ");
    sqlQuery.append(" cob_asign_cobra asi, ");
    sqlQuery.append(" cob_crono_cobra cron, ");
    sqlQuery.append(" cob_etapa_deuda eta ");
    sqlQuery.append(" WHERE ");
    sqlQuery.append(" cuot.clie_oid_clie = " + oidCliente + " and ");
    sqlQuery.append(" asi.MVCC_OID_MOVI_CC = cuot.OID_MOVI_CC ");
    sqlQuery.append(" and asi.CRCO_OID_CRON_COBR = cron.OID_CRON_COBR ");
    sqlQuery.append(" and cron.ETDE_OID_ETAP_DEUD = eta.OID_ETAP_DEUD ");
    sqlQuery.append(" and " + clausulaIN);
    
    try { 
      r = bs.dbService.executeStaticQuery(sqlQuery.toString());
      UtilidadesLog.debug("r: " + r);
    } catch (Exception ex) {
       UtilidadesLog.error(ex);
       String sCodigoError = CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS;
       throw new MareException(ex, UtilidadesError.armarCodigoError(sCodigoError));
    }
    
    UtilidadesLog.info("DAOAsignacionCarteraPeriodo.recuperarEtapasCliente(Long oidCliente):Salida");
    return r;
    
 }
   
   
  private String includeIN(String tabla, Long[] oids) {
      UtilidadesLog.info("DAOAsignacionCarteraPeriodo.includeIN(String tabla, Long[] oids):Entrada");
      Long[] aux = oids;
      StringBuffer aux2 = new StringBuffer();

      if(aux != null) {
          int canti = aux.length - 1;

          if(canti > -1) {
              aux2.append(tabla + " in (");

              for(int i = 0; i < canti; i++)
                  aux2.append(aux[i] + ", ");

              aux2.append(aux[canti] + ")");
          }
      }
      UtilidadesLog.info("DAOAsignacionCarteraPeriodo.includeIN(String tabla, Long[] oids):Salida");
      return aux2.toString();
  }
  
  
  /**
   * @author: ssantana, 14/9/2005, por inc. COB-04
   * @throws es.indra.mare.common.exception.MareException
   * @return Boolean
   * @param Long oidEtapaDeuda
   * @param Long  oidMovimientoCCC
   */
  public Boolean validarAsignacionExistente(Long oidMovimientoCCC, Long oidEtapaDeuda) throws MareException {
    UtilidadesLog.info("DAOAsignacionCateraPeriodo.validarAsignacionExistente(Long oidMovimientoCCC, Long oidEtapaDeuda):Entrada");
    BelcorpService bs = BelcorpService.getInstance();
    RecordSet r = null;
    BigDecimal bigBuffer = null;
    Boolean bFlagRetorno = null;

    StringBuffer sqlQuery = new StringBuffer("");

    sqlQuery.append(" SELECT COUNT (asi.oid_asig_cobr) ");
    sqlQuery.append(" FROM cob_asign_cobra asi, cob_crono_cobra cron, cob_etapa_deuda eta ");
    sqlQuery.append(" WHERE asi.mvcc_oid_movi_cc = " + oidMovimientoCCC);
    sqlQuery.append(" AND asi.crco_oid_cron_cobr = cron.oid_cron_cobr ");
    sqlQuery.append(" AND cron.etde_oid_etap_deud = eta.oid_etap_deud ");
    sqlQuery.append(" AND eta.oid_etap_deud = " + oidEtapaDeuda);
    
    try {
       r = bs.dbService.executeStaticQuery(sqlQuery.toString());
    } catch (Exception ex) {
       UtilidadesLog.error(ex);
       String sCodigoError = CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS;
       throw new MareException(ex, UtilidadesError.armarCodigoError(sCodigoError));
    }
    
    bigBuffer = (BigDecimal)r.getValueAt(0,0);
    
    if (bigBuffer.longValue() > 0 ) {
      bFlagRetorno = Boolean.TRUE;
    } else {
      bFlagRetorno = Boolean.FALSE;
    }
    
    UtilidadesLog.info("DAOAsignacionCateraPeriodo.validarAsignacionExistente(Long oidMovimientoCCC, Long oidEtapaDeuda):Salida");
    return bFlagRetorno;
    
  }
  
  /**
   * @Author: Hugo Mansi 18/10/2005
   * @throws es.indra.mare.common.exception.MareException
   * @return DTOSalida
   * @param DTOEtapasDeCobranzas dto
   * @descripcion: Este metodo se creo para poder recuperar aquellas deudas total del cliente, superiores a los importes 
   * minimos y maximos de la etapa. El mètodo es similar al descripto en DAOInterfaceModulos de CCC 
   * consultarClientesDeudaVencidaUA pero haciendo el sumatorio del importePendiente del cliente y tomando solo aquellos
   * que no estan en el rango de importes de la etapa.
   */
    public DTOSalida recuperarClienteDeudasASupervisor(DTOEtapasDeCobranzas dto) throws MareException {
      
      UtilidadesLog.info("DAOAsignacionCartera.recuperarClienteDeudasASupervisor(DTOEtapasDeCobranzas dto): Entrada");
      RecordSet r = new RecordSet();
      DTOSalida dtoSalida = new DTOSalida();
      String query = null;
      
      StringBuffer sqlSelect = new StringBuffer("");
      StringBuffer sqlFrom = new StringBuffer("");
      StringBuffer sqlWhere = new StringBuffer("");
      
// -------------------------------------------------------------------------------------
      sqlSelect.append(" select cliente, sumaImporte from ");
      sqlSelect.append(" cob_etapa_deuda eta, ");
      sqlSelect.append(" mae_clien_comun comun, ");
      sqlSelect.append(" mae_tipo_comun tipoComun, ");
      sqlSelect.append(" (select oidcliente cliente, sum(importependiente) sumaImporte ");
      sqlSelect.append(" from ( ");
      sqlSelect.append(" SELECT maec.cod_clie codigocliente, ");
      sqlSelect.append(" canal.cod_cana canal, ");
      sqlSelect.append(" acces.cod_acce acceso, ");
      sqlSelect.append(" subacc.cod_sbac subacceso, ");
      sqlSelect.append(" movicc.num_iden_cuot numeroindentificadorcuota, ");
      sqlSelect.append(" movicc.val_ejer_cuot ejerciciocuota, ");
      sqlSelect.append(" movicc.num_orde_cuot numeroordencuota, ");
      sqlSelect.append(" movicc.tcab_oid_tcab_ulti tipocargoabono, ");
      sqlSelect.append(" socie.val_deno empresa, ");
      sqlSelect.append(" movicc.IMP_MOVI importe, ");
      sqlSelect.append(" movicc.imp_movi_cuen importe, ");
      sqlSelect.append(" movicc.imp_pend importependiente, ");
      sqlSelect.append(" maec.oid_clie oidcliente, ");
      sqlSelect.append(" movicc.oid_movi_cc oidCuota, ");
      sqlSelect.append(" socie.OID_SOCI oidSociedad, ");
      sqlSelect.append(" maeclisubt.OID_CLIE_TIPO_SUBT oidClienteTipoSubtipo ");
      
      sqlFrom.append(" FROM ccc_movim_cuent_corri movicc, ");
      sqlFrom.append(" mae_clien maec, ");
      sqlFrom.append(" MAE_CLIEN_TIPO_SUBTI maeclisubt, ");
      sqlFrom.append(" seg_canal canal,  ");
      sqlFrom.append(" cra_perio peri,  ");
      sqlFrom.append(" seg_acces acces,  ");
      sqlFrom.append(" seg_subac subacc, ");
      sqlFrom.append(" ccc_tipo_cargo_abono tipocab, ");
      sqlFrom.append(" seg_socie socie,  ");
      sqlFrom.append(" ( SELECT marcata.masi_oid_marc_sali oidmarcasi ");
      sqlFrom.append("   FROM ccc_marca_tipo_abono marcata, ");
      sqlFrom.append("   ccc_tipo_abono_subpr tipoab, ");
      sqlFrom.append("   ccc_subpr subpro, ");
      sqlFrom.append("   ccc_proce proce ");
      sqlFrom.append("   WHERE marcata.tasp_oid_tipo_abon_subp = tipoab.oid_tipo_abon_subp ");
      sqlFrom.append("   AND tipoab.subp_oid_subp = subpro.oid_subp ");
      sqlFrom.append("   AND subpro.ccpr_oid_proc = proce.oid_proc ");
      sqlFrom.append("   AND subpro.cod_subp = " + CCCConstantes.SUBPROCESO_CONSULTA_DEUDA);
      sqlFrom.append("   AND proce.cod_proc = '" + CCCConstantes.PROCESO_CON001 + "' ");
      sqlFrom.append("   AND marcata.ind_entr_sali = 'E' ) marcasitu ");

      sqlWhere.append(" WHERE movicc.clie_oid_clie = maec.oid_clie ");
      if (dto.getOidSubgerenciaVentas() != null) {
         sqlWhere.append(" AND zonsubge.oid_subg_vent = " + dto.getOidSubgerenciaVentas() );
	     sqlWhere.append(" and movicc.ZSGV_OID_SUBG_VENT = zonsubge.OID_SUBG_VENT ");
	     sqlFrom.append(" ,zon_sub_geren_venta zonsubge  ");
 	     if (dto.getOidRegion() != null)  {
           sqlWhere.append(" AND zonregion.oid_regi = " + dto.getOidRegion() ); 
           sqlWhere.append(" AND zonsubge.oid_subg_vent = zonregion.ZSGV_OID_SUBG_VENT ");
           sqlWhere.append(" and movicc.ZORG_OID_REGI = zonregion.oid_regi ");
	       sqlFrom.append(" ,zon_regio zonregion  ");
	       if (dto.getOidZona() != null) {
	         sqlWhere.append(" AND zonzona.oid_zona = " + dto.getOidZona() );
             sqlWhere.append(" AND zonzona.ZORG_OID_REGI = zonregion.oid_regi ");  
             sqlFrom.append(" ,zon_zona zonzona  ");
		     if (dto.getOidSeccion() != null){
               sqlWhere.append(" AND zonsecc.oid_secc = " + dto.getOidSeccion() );
               sqlWhere.append(" AND zonzona.oid_zona = zonsecc.ZZON_OID_ZONA ");       
		       sqlWhere.append(" and movicc.ZSCC_OID_SECC = zonsecc.oid_secc ");
    		   sqlFrom.append(" ,zon_secci zonsecc ");
			   if (dto.getOidTerritorio() != null)  {
                 sqlWhere.append(" AND zonterri.oid_terr = " + dto.getOidTerritorio() ); 
                 sqlWhere.append(" AND zonterri.oid_terr = zonterriadm.TERR_OID_TERR "); 
                 sqlWhere.append(" AND zonsecc.oid_secc = zonterriadm.ZSCC_OID_SECC "); 	                  	   
		         sqlWhere.append(" and movicc.ZTAD_OID_TERR_ADMI = zonterriadm.OID_TERR_ADMI ");
                 sqlFrom.append(" ,zon_terri_admin zonterriadm "); 
			     sqlFrom.append(" ,zon_terri zonterri ");
			   }
  		     } 
	       }
         }
       }

      sqlWhere.append(" AND peri.OID_PERI = " + dto.getOidPeriodoOrigen() );
      sqlWhere.append(" AND peri.oid_peri = movicc.perd_oid_peri ");
      sqlWhere.append(" AND canal.oid_cana = peri.cana_oid_cana ");
      
      if (dto.getOidCanal() != null) {
         sqlWhere.append(" AND canal.oid_cana = " + dto.getOidCanal() );
      }      
      
      sqlWhere.append(" AND subacc.acce_oid_acce = acces.oid_acce ");
      sqlWhere.append(" AND subacc.OID_SBAC = movicc.SBAC_OID_SBAC ");
   
      if (dto.getOidTipoCargoAbono() != null) {
         sqlWhere.append(" AND tipocab.oid_tipo_carg_abon = movicc.tcab_oid_tcab_crea ");
         sqlWhere.append(" AND tipocab.OID_TIPO_CARG_ABON = " + dto.getOidTipoCargoAbono());
      }

      sqlWhere.append(" AND movicc.masi_oid_marc_situ = marcasitu.oidmarcasi ");
      sqlWhere.append(" AND movicc.SOCI_OID_SOCI = socie.OID_SOCI ");
      sqlWhere.append(" AND maec.oid_clie = maeclisubt.clie_oid_clie "); 
      sqlWhere.append(" AND movicc.TICL_OID_TIPO_CLIE = maeclisubt.TICL_OID_TIPO_CLIE ");

      sqlWhere.append(" AND movicc.OID_MOVI_CC NOT IN( ");
      sqlWhere.append(" SELECT  cac.MVCC_OID_MOVI_CC "); 
      sqlWhere.append(" FROM COB_ASIGN_COBRA cac, COB_CRONO_COBRA crono "); 
      sqlWhere.append(" WHERE cac.CRCO_OID_CRON_COBR = crono.OID_CRON_COBR ");
      sqlWhere.append(" AND crono.ETDE_OID_ETAP_DEUD = "+dto.getOidEtapa()+" ");
      sqlWhere.append(" ) ");
      
      sqlWhere.append(" AND " + dto.getEdadInicial() + " > 0");
      sqlWhere.append(" AND (SYSDATE - movicc.FEC_VENC) between ");
      sqlWhere.append( dto.getEdadInicial() + " AND " + dto.getEdadFinal() );
      sqlWhere.append(" AND " + dto.getImporteDesde() + " > 0 ");
      sqlWhere.append(" ) group by oidcliente ");
      sqlWhere.append(" order by oidcliente ) ");
      sqlWhere.append(" where comun.CLIE_OID_CLIE(+) = cliente ");
      sqlWhere.append(" AND tipoComun.OID_TIPO_COMU(+) = comun.TICM_OID_TIPO_COMU ");
      sqlWhere.append(" AND eta.OID_ETAP_DEUD = " + dto.getOidEtapa());
      sqlWhere.append(" AND (sumaImporte  not between " + dto.getImporteDesde() + " AND " + dto.getImporteHasta());
      sqlWhere.append(" OR (IND_TELF = 1 AND (OID_CLIE_COMU is null OR COD_TIPO_COMU != '"+ ConstantesMAE.TIPO_COMUNICACION_TFNO_STRING + "')))");
       
      BelcorpService bs = BelcorpService.getInstance();
      query = sqlSelect.toString() + sqlFrom.toString() + sqlWhere.toString();
      
      try {
         r = bs.dbService.executeStaticQuery(query);
      } catch (Exception ex) {
        ex.printStackTrace();
        String codigoError = CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS;
        throw new MareException(ex, UtilidadesError.armarCodigoError(codigoError));
      }
      UtilidadesLog.debug("r: " + r);
      dtoSalida.setResultado(r);
      UtilidadesLog.info("DAOAsignacionCartera.recuperarClienteDeudasASupervisor(DTOEtapasDeCobranzas dto): Salida");
      return dtoSalida;
    }
  
    /**
   * @Author: scs 05/11/2007
   * @descripcion: Verifica exist. en el sist. de un us. Supervisor
   */
    public Long verifExistUsSup(long oidPais) throws MareException {
       UtilidadesLog.info("DAOAsignacionCartera.verifExistUsSup(long oidPais): Entrada");
       RecordSet r = new RecordSet();
       StringBuffer query = new StringBuffer();
       BelcorpService bs;
       Long resu = null;
       
       try {
          bs = BelcorpService.getInstance();
       }
       catch (MareMiiServiceNotFoundException e) {
          UtilidadesLog.error("ERROR ", e);
          throw new MareException(e, 
          UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_PEDIR_UN_SERVICIO_MARE));
       }
       
       query.append("SELECT OID_USUA_COBR AS usuario FROM ");
       query.append("COB_USUAR_COBRA cuc, cob_estad_usuar ceu ");
       query.append("WHERE cuc.ESUS_OID_ESTA_USUA = ceu.OID_ESTA_USUA ");
       query.append("AND ceu.COD_ESTA_USUA = 'A' ");
       query.append("AND cuc.IND_USUA_SUPE = 1 ");
       query.append("AND cuc.PAIS_OID_PAIS = " + oidPais);
 
       try {
          r = bs.dbService.executeStaticQuery(query.toString());
       }
       catch (Exception ex) {
          UtilidadesLog.error("ERROR ", ex);
          throw new MareException(ex,
          UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS));
       }
      
       UtilidadesLog.debug("rs: " + r);
       
       resu = this.bigDecimalToLong(r.getValueAt(0, "USUARIO"));
       return resu;
    }

    private Long bigDecimalToLong(Object numero) {
        if (numero != null) {
            return new Long(((BigDecimal) numero).longValue());
        } else {
            return null;
        }
    }    
   
}