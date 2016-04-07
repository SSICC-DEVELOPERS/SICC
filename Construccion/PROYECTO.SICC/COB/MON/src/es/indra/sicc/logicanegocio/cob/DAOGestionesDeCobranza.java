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
 * la distribución de este código sin permiso expreso.buscarGestionesDeCobranzaTC
 */
package es.indra.sicc.logicanegocio.cob;
import es.indra.mare.common.mii.MareMiiServiceNotFoundException;
import es.indra.sicc.dtos.cob.DTOGestionDeCobranza;
import es.indra.sicc.dtos.cob.DTOUsuariosPerfil;
import es.indra.sicc.logicanegocio.mae.ConstantesMAE;
import es.indra.sicc.util.BelcorpService;
import es.indra.sicc.util.CodigosError;
import es.indra.sicc.util.DTOBelcorp;
import es.indra.sicc.util.DTOSalida;
import es.indra.mare.common.exception.MareException;
import es.indra.mare.common.mii.services.jdbcservice.RecordSet;
import es.indra.sicc.util.DTOOID;
import es.indra.sicc.util.UtilidadesEJB;
import es.indra.sicc.util.UtilidadesError;
import es.indra.sicc.dtos.cob.DTOBuscarGestionesDeCobranza;
import es.indra.sicc.util.UtilidadesLog;
import es.indra.sicc.util.UtilidadesPaginacion;
import es.indra.sicc.cmn.negocio.auditoria.DTOSiccPaginacion;
import es.indra.sicc.dtos.cob.DTOEBuscarCompromisosPago;
import es.indra.sicc.cmn.negocio.ConstantesCMN;
import java.math.BigDecimal;
import es.indra.sicc.dtos.cob.DTOUsuariosCobComboPerfil;
import javax.ejb.SessionContext;

public class DAOGestionesDeCobranza 
{
  private SessionContext session;
  
  public DAOGestionesDeCobranza()
  {
  }
  
   public DAOGestionesDeCobranza(SessionContext session){
        this.session = session;
   }
    
  /** 
  * Metodo para cargar los combos de usuario de los CU Reasignar
  * @param DTOBelcorp dto
  * @return DTOSalida
  * @exception MareException 
  * @author enozigli
  * @referencia SICC-DMCO-COB-201-324-N037
  */
  public DTOSalida obtenerUsuariosCobCombo(DTOBelcorp dto) throws MareException{

    UtilidadesLog.info("DAOGestionesDeCobranza.obtenerUsuariosCobCombo(DTOBelcorp dto): Entrada");
  
      DTOSalida dtoS = new DTOSalida();
      RecordSet rs = new RecordSet();
      StringBuffer query = new StringBuffer();
      BelcorpService bs;
      try
      {   bs = BelcorpService.getInstance();
      }
      catch(MareMiiServiceNotFoundException ex)
      {   throw new MareException(ex, UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_PEDIR_UN_SERVICIO_MARE));
      }

      query.append(" SELECT "); 
      query.append(" UCO.OID_USUA_COBR OID, "); 
      query.append(" P.name CODIGO "); 
      query.append(" FROM "); 
      query.append(" Principals P, "); 
      query.append(" USERS U, "); 
      query.append(" COB_USUAR_COBRA UCO ");
      query.append(" , COB_ESTAD_USUAR EU "); //debe usarse
      query.append(" WHERE "); 
      query.append(" U.IDUSER = P.IDPRINCIPAL AND "); 
      query.append(" UCO.USER_OID_USUA_COBR = U.IDUSER "); 
      /*Esta constante pretende ser un oid y es 1, diferente a lo real
       * query.append(" UCO.ESUS_OID_ESTA_USUA = "+ConstantesCOB.ESTADO_USUARIO_ACTIVO+" ");//ConstantesCOB.ESTADO_USUARIO_ACTIVO */
      query.append(" AND uco.esus_oid_esta_usua = eu.OID_ESTA_USUA ");
      query.append(" and eu.COD_ESTA_USUA = 'A' ");
      query.append(" AND UCO.PAIS_OID_PAIS = "+dto.getOidPais()+" ");
      query.append(" ORDER BY CODIGO"); 

       try 
        {   rs = bs.dbService.executeStaticQuery(query.toString());
        }
       catch (Exception ex) 
       {   throw new MareException(ex, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS));
       }	
       dtoS.setResultado(rs);
       
        UtilidadesLog.info("DAOGestionesDeCobranza.obtenerUsuariosCobCombo(DTOBelcorp dto): Salida");
       
       return dtoS;  
  }
  /** 
  * Metodo de consulta de datos de gestion de cobranza a travez del oid
  * @param DTOOID dto
  * @return DTOSalida
  * @exception MareException 
  * @author enozigli
  * @referencia SICC-DMCO-COB-201-324-N037 e inc. 13249
  */
  public DTOSalida detalleGestion(DTOOID dto) throws MareException{
  
    UtilidadesLog.info("DAOGestionesDeCobranza.detalleGestion(DTOOID dto): Entrada");
  
      DTOSalida dtoS = new DTOSalida();
      RecordSet rs = new RecordSet();
      StringBuffer query = new StringBuffer();
      BelcorpService bs;
      try
      {   bs = BelcorpService.getInstance();
      }
      catch(MareMiiServiceNotFoundException ex)
      {   throw new MareException(ex, UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_PEDIR_UN_SERVICIO_MARE));
      }
      /* (1): gPineda - 01/02/2007 - V-COB-009 */
      query.append(" SELECT princip.NAME usuariocobranza, ");
      query.append(" eta.val_desc etapa, ");
      //query.append(" tipocargo.cod_tipo_carg_abon tipocargo, marca.des_marc marca, "); (1)
      query.append(" deudatipocargo.cod_tipo_carg_abon tipocargo, ");
      //vbongiov -- 30/12/2008
      query.append(" marca.COD_MARC marca, ");
      query.append(" canal.cod_cana canal, ");
      query.append(" periodo.cod_peri periodo, ");
      query.append(" subge.des_subg_vent subgerenciaventas, regio.des_regi region, ");
      query.append(" zona.des_zona zona, ");
      query.append(" sexy.des_secci seccion, ");
      query.append(" terri.cod_terr territorio, ");
      query.append(" cliente.cod_clie codigocliente, ");
      query.append(" cliente.val_nom1 nombre, ");
      query.append(" (cliente.val_ape1 ||', '|| cliente.val_ape2) apellidos, ");      
      query.append(" accion.val_desc accion, ");
      query.append(" gestcob.fec_segu fechaseguimiento, ");
      query.append(" gestcob.val_hora_segu horaseguimiento, ");
      query.append(" comprpago.cod_comp_pago compromisopago, ");
      query.append(" gestcob.fec_repr fechareprogramacion, ");
      query.append(" gestcob.val_hora_repr horareprogramacion, ");
      query.append(" gestcob.ind_apor_prue aportaprueba, ");
      query.append(" gestcob.val_desc_prue descripcionprueba, ");
      query.append(" gestcob.num_docu_sopo numerodocsoporte, ");
      query.append(" internac.VAL_I18N tipodocumentopago, ");
      query.append(" banco.DES_BANC Banco, ");
      query.append(" sucursal.COD_SUCU Sucursal, ");
      query.append(" gestcob.VAL_NUEV_DIRE nuevadireccion, ");
      query.append(" gestcob.VAL_NUEV_TELF nuevotelefono, ");
      query.append(" gestcob.IND_PASA_ADMI pasaadministrador, ");
      query.append(" gestcob.IND_PETI_BLOQ peticionbloqueo, ");
      query.append(" gestcob.IND_PETI_DESB peticiondesbloqueo, ");
      query.append(" gestcob.IND_VISA_ADMI visadoadministrador, ");
      query.append(" gestcob.IND_MARC_COMI_CALC marcacomisioncalc, ");
      query.append(" gestcob.VAL_OBSE observaciones, ");
      query.append(" motivoincob.VAL_DESC_MOTI_COBR motivonocobro, ");
      //Se agregaron los siguientes campos para que cuadre con el dto a devolver en el mongestioncobranza.detallegestion
      //enozigli 16/02/2005
      query.append(" gestcob.ACCO_OID_ACCI_COBR oidaccion, ");
      query.append(" gestcob.SUCU_OID_SUCU oidsucursal, ");
      query.append(" subge.oid_subg_vent oidsubgerenciaventas, ");
      query.append(" marca.oid_marc oidmarca, ");
      query.append(" canal.oid_cana oidcanal, ");
      query.append(" craperi.oid_peri oidperiodo, ");
      query.append(" eta.oid_etap_deud oidetapa, ");
      query.append(" gestcob.clie_oid_clie oidcliente, ");
      query.append(" sexy.zzon_oid_zona oidzona, ");
      query.append(" clienua.ztad_oid_terr_admi oidterritorio, ");
      query.append(" zona.zorg_oid_regi oidregion, ");
      query.append(" terriadmin.zscc_oid_secc oidseccion, ");
      query.append(" usuacob.oid_usua_cobr oidusuariocobranza, ");
      query.append(" comprpago.OID_COMP_PAGO oidcompromisopago, ");
      query.append(" motivoincob.OID_MOTI_COBR oidmotivonocobro, ");
      query.append(" internac.VAL_OID oidtipodocumentopago ");
      //--------------------------------------------------------------------
      query.append(" FROM principals princip, ");
      query.append(" users users, ");
      query.append(" cob_gesti_cobra gestcob, ");
      query.append(" cob_usuar_cobra usuacob, ");
      query.append(" cob_etapa_deuda eta, ");
      //query.append(" ccc_tipo_cargo_abono tipocargo, "); (1)
      query.append(" seg_marca marca, ");
      query.append(" seg_canal canal, ");
      query.append(" seg_perio_corpo periodo, ");
      query.append(" cra_perio craperi, ");
      query.append(" zon_terri_admin terriadmin, ");
      query.append(" zon_terri terri, ");
      query.append(" zon_sub_geren_venta subge, ");
      query.append(" zon_regio regio, ");
      query.append(" zon_secci sexy, ");
      query.append(" zon_zona zona, ");
      query.append(" mae_clien_unida_admin clienua, ");
      query.append(" mae_clien cliente, ");
      query.append(" cob_accio_cobra accion, ");
      query.append(" cob_compr_pago comprpago, ");
      query.append(" bel_medio_pago mediopago, ");
      query.append(" bel_tipo_medio_pago tipopago, ");
      query.append(" V_GEN_I18N_SICC internac, ");
      query.append(" ccc_sucur sucursal, ");
      query.append(" ccc_banco banco, ");
      query.append(" COB_MOTIV_INCOB motivoincob, ");
      //query.append(" COB_ETAPA_DEUDA_TIPO_CARGO deudatipocargo ");(1)
      query.append("  (select * from COB_ETAPA_DEUDA_TIPO_CARGO etapTip, ");
 	  query.append("    		ccc_tipo_cargo_abono tipoCar ");
 	  query.append(" 		where etapTip.TCAB_OID_TIPO_CARG_ABON = tipoCar.OID_TIPO_CARG_ABON (+) ");
	  query.append(" 		  and tipoCar.PAIS_OID_PAIS = "+ dto.getOidPais() +" ) deudatipocargo ");
      query.append(" WHERE gestcob.oid_gest_cobr = "+dto.getOid()+" ");
      //usuarioCobranza
      query.append(" AND users.iduser = princip.idprincipal ");
      query.append(" AND gestcob.usco_oid_usua_cobr = usuacob.oid_usua_cobr ");
      query.append(" AND usuacob.user_oid_usua_cobr = users.iduser ");
      query.append(" AND usuacob.pais_oid_pais = "+dto.getOidPais()+" ");
      //etapaDeuda
      query.append(" AND gestcob.etde_oid_etapa_deuda = eta.oid_etap_deud ");
      query.append(" AND eta.pais_oid_pais = "+dto.getOidPais()+" ");
      //Tipo de cargo
//      query.append(" AND gestcob.tcab_oid_tipo_carg_abon = tipocargo.oid_tipo_carg_abon ");
      query.append(" AND gestcob.EDTC_OID_ETAP_DEUD_TIPO_CARG = deudatipocargo.OID_ETAP_DEUD_TIPO_CARG (+)"); //(1) Se agrega left join
      //query.append(" AND tipocargo.OID_TIPO_CARG_ABON = deudatipocargo.TCAB_OID_TIPO_CARG_ABON "); (1)
      //query.append(" AND tipocargo.pais_oid_pais = "+dto.getOidPais()+" "); (1)
      //Marca, Canal, Perido
      query.append(" AND gestcob.perd_oid_peri = craperi.oid_peri ");
      query.append(" AND craperi.marc_oid_marc = marca.oid_marc ");
      query.append(" AND craperi.cana_oid_cana = canal.oid_cana ");
      query.append(" AND craperi.peri_oid_peri = periodo.oid_peri ");
      query.append(" AND craperi.pais_oid_pais = "+dto.getOidPais()+" ");
      //Zonificación y Cliente
      query.append(" AND gestcob.clie_oid_clie = cliente.oid_clie ");
      query.append(" AND cliente.oid_clie = clienua.clie_oid_clie ");
      query.append(" AND clienua.ztad_oid_terr_admi = terriadmin.oid_terr_admi ");
      query.append(" AND terriadmin.zscc_oid_secc = sexy.oid_secc ");
      query.append(" AND sexy.zzon_oid_zona = zona.oid_zona ");
      query.append(" AND zona.zorg_oid_regi = regio.oid_regi ");
      query.append(" AND regio.zsgv_oid_subg_vent = subge.oid_subg_vent ");
      query.append(" AND terriadmin.pais_oid_pais = "+dto.getOidPais()+" ");
      //Accion
      query.append(" AND gestcob.acco_oid_acci_cobr = accion.oid_acci_cobr ");
      query.append(" AND accion.pais_oid_pais = "+dto.getOidPais()+" ");
      //CompromisoPago
      query.append(" AND gestcob.oid_gest_cobr = comprpago.geco_oid_gest_cobr(+) ");
      //Tipo documento pago es internacionalizable
      //Modificado 15/11/2005
      //Hugo Mansi. Se agrego (+) para recuperar aun cuando los valores sean null
      query.append(" and gestcob.MPAB_OID_MEDI_PAGO = mediopago.OID_MEDI_PAGO (+) ");
      query.append(" AND mediopago.TMEP_OID_TIPO_MEDI_PAGO = tipopago.OID_TIPO_MEDI_PAGO (+) ");
      query.append(" and mediopago.OID_MEDI_PAGO = internac.VAL_OID (+) ");
      query.append(" and internac.ATTR_NUM_ATRI (+) = 1 ");
      query.append(" and internac.IDIO_OID_IDIO (+) = " + dto.getOidIdioma() + " ");
      query.append(" and internac.ATTR_ENTI (+) = 'BEL_MEDIO_PAGO' ");
	  //query.append(" and internac.VAL_OID = tipopago.OID_TIPO_MEDI_PAGO ");
      //Banco y Sucursal
      query.append(" and gestcob.SUCU_OID_SUCU = sucursal.OID_SUCU (+) ");
      query.append(" and sucursal.CBAN_OID_BANC = banco.OID_BANC (+) ");
      query.append(" and banco.PAIS_OID_PAIS (+) = "+dto.getOidPais()+" ");
      //Motivo incobrable
      query.append(" and motivoincob.OID_MOTI_COBR (+) = gestcob.MONO_OID_MOTI_COBR ");
      query.append(" and motivoincob.PAIS_OID_PAIS (+) = "+dto.getOidPais()+" ");
      
    /*Se agregan los siguientes joins para evitar duplicidad en los registros*/
        query.append(" AND clienua.ind_acti = " + ConstantesCMN.VAL_TRUE);
        query.append(" AND terriadmin.oid_terr_admi = clienua.ztad_oid_terr_admi ");
        query.append(" AND terriadmin.ind_borr = " + ConstantesCMN.VAL_FALSE);
        query.append(" AND terri.oid_terr = terriadmin.terr_oid_terr ");
        query.append(" AND terri.ind_borr = " + ConstantesCMN.VAL_FALSE);
        query.append(" AND sexy.oid_secc = terriadmin.zscc_oid_secc ");
        query.append(" AND sexy.ind_borr = " + ConstantesCMN.VAL_FALSE);
        query.append(" AND sexy.ind_acti = " + ConstantesCMN.VAL_TRUE);
        query.append(" AND zona.oid_zona = sexy.zzon_oid_zona ");
        query.append(" AND zona.ind_borr = " + ConstantesCMN.VAL_FALSE);
        query.append(" AND zona.ind_acti = " + ConstantesCMN.VAL_TRUE);
        query.append(" AND regio.oid_regi = zona.zorg_oid_regi ");
        query.append(" AND regio.ind_borr = " + ConstantesCMN.VAL_FALSE);
        query.append(" AND regio.ind_acti = " + ConstantesCMN.VAL_TRUE);
        query.append(" AND subge.oid_subg_vent = regio.zsgv_oid_subg_vent ");
        query.append(" AND subge.ind_borr = " + ConstantesCMN.VAL_FALSE);
        query.append(" AND subge.ind_acti = " + ConstantesCMN.VAL_TRUE);
        query.append(" AND clienua.ZTAD_OID_TERR_ADMI = terriadmin.OID_TERR_ADMI ");
        query.append(" AND terriadmin.TERR_OID_TERR = terri.OID_TERR ");

      UtilidadesLog.debug("QUERY detalleGestion: " + query);

       try 
        {   rs = bs.dbService.executeStaticQuery(query.toString());
        }
       catch (Exception ex) 
       {   throw new MareException(ex, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS));
       }
       
       if (rs.esVacio())  {
            UtilidadesLog.debug("esta vacio");
            throw new MareException(new Exception(),UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE));                    
       }
       
       dtoS.setResultado(rs);
       
        UtilidadesLog.info("DAOGestionesDeCobranza.detalleGestion(DTOOID dto): Salida");
       
       return dtoS;   
  }
  /** 
  * Metodo para cargar los combos de usuario de los CU Reasignar
  * @param DTOOID dto
  * @return DTOSalida
  * @exception MareException 
  * @author enozigli
  * @referencia SICC-DMCO-COB-201-324-N037
  */
  public DTOSalida obtenerUsuariosCobComboMenos1(DTOOID dto) throws MareException{
  
    UtilidadesLog.info("DAOGestionesDeCobranza.obtenerUsuariosCobComboMenos1(DTOOID dto): Entrada");
  
      DTOSalida dtoS = new DTOSalida();
      RecordSet rs = new RecordSet();
      StringBuffer query = new StringBuffer();
      BelcorpService bs;
      try
      {   bs = BelcorpService.getInstance();
      }
      catch(MareMiiServiceNotFoundException ex)
      {   throw new MareException(ex, UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_PEDIR_UN_SERVICIO_MARE));
      }
      
      query.append(" SELECT ");
      query.append(" UCO.OID_USUA_COBR OID, ");
      query.append(" P.name CODIGO ");
      query.append(" FROM "); 
      query.append(" Principals P, "); 
      query.append(" USERS U, "); 
      query.append(" COB_USUAR_COBRA UCO ");
      query.append(" ,COB_ESTAD_USUAR EU ");
      query.append(" WHERE "); 
      query.append(" U.IDUSER = P.IDPRINCIPAL "); 
      query.append(" AND UCO.USER_OID_USUA_COBR = U.IDUSER  ");
      query.append(" AND uco.esus_oid_esta_usua = eu.OID_ESTA_USUA ");
      query.append(" AND eu.COD_ESTA_USUA = 'A' ");
      //    Modificado por HRCS - Fecha 25/04/2007 - Incidencia Sicc20070231
      query.append(" AND UCO.PAIS_OID_PAIS = "+dto.getOidPais()+" "); 
      query.append(" AND UCO.OID_USUA_COBR <> "+dto.getOid()+" ");
      query.append(" ORDER BY LOWER(codigo) ");

       try 
        {   rs = bs.dbService.executeStaticQuery(query.toString());
        }
       catch (Exception ex) 
       {   throw new MareException(ex, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS));
       }	
       dtoS.setResultado(rs);
       
        UtilidadesLog.info("DAOGestionesDeCobranza.obtenerUsuariosCobComboMenos1(DTOOID dto): Salida");
       
       return dtoS;   
  }
  /** 
  * Metodo para
  * @param DTOBuscarGestionesDeCobranza dto
  * @return DTOSalida
  * @exception MareException 
  * @author 
  * @referencia SICC-DMCO-COB-201-324-N037
  */
  public DTOSalida buscarGestionesDeCobranzaSB(DTOBuscarGestionesDeCobranza dto) throws MareException{
  
    UtilidadesLog.info("DAOGestionesDeCobranza.buscarGestionesDeCobranzaSB(DTOBuscarGestionesDeCobranza dto): Entrada");
  
      DTOSalida dtoS = new DTOSalida();
      RecordSet rs = new RecordSet();
      StringBuffer query = new StringBuffer();
      BelcorpService bs;
      StringBuffer queryPaginado = new StringBuffer();
      
      try
      {   bs = BelcorpService.getInstance();
      }
      catch(MareMiiServiceNotFoundException ex){   
          UtilidadesLog.error(ex);
          throw new MareException(ex, UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_PEDIR_UN_SERVICIO_MARE));
      }      
      
       query.append(" SELECT	 COB_GESTI_COBRA.OID_GEST_COBR oid, "); // (Oid de gestión de cobranza) 
       query.append(" COB_ETAPA_DEUDA.COD_ETAP_DEUD, "); //(Código de etapa) 
       query.append(" CRA_PERIO.VAL_NOMB_PERI, ");// (Código de periodo)
       query.append(" MAE_CLIEN.COD_CLIE cliente, ");//(Código de cliente)
       query.append(" MAE_CLIEN.VAL_APE1 ||','|| MAE_CLIEN.VAL_NOM1 nombre, ");//(Nombre de cliente ó consultora, con formato "apellido, nombre") 
       query.append(" COB_ACCIO_COBRA.COD_ACCI_COBR accion, ");// (Acción) 
       query.append(" COB_GESTI_COBRA.IND_PETI_BLOQ, ");// (Petición de bloqueo financiero)
       query.append(" COB_GESTI_COBRA.IND_PETI_DESB, ");// (Petición de desbloqueo financiero)	
       
       query.append("  (CASE WHEN COB_GESTI_COBRA.IND_PETI_BLOQ = 1 ");
			 query.append(" 		   THEN PQ_APL_AUX.VALOR_GEN_I18N_SICC ("+dto.getOidIdioma()+", ");
       query.append("             COB_GESTI_COBRA.TIBQ_OID_TIPO_BLOQ, ");
       query.append("             'MAE_TIPO_BLOQU' )  ");
			 query.append("          	  ELSE ''  ");
			 query.append("    		  END ) TIPOBLOQU, ");
              
       query.append(" COB_GESTI_COBRA.TIBQ_OID_TIPO_BLOQ, MAE_CLIEN.OID_CLIE ");
       query.append(" FROM COB_GESTI_COBRA,COB_ACCIO_COBRA,MAE_CLIEN,COB_ETAPA_DEUDA,CRA_PERIO, ");
       query.append(" COB_ETAPA_DEUDA_TIPO_CARGO ");
       query.append(" WHERE	((COB_GESTI_COBRA.IND_PETI_BLOQ = 1) OR (COB_GESTI_COBRA.IND_PETI_DESB = 1)) ");
       query.append(" AND  (COB_GESTI_COBRA.IND_VISA_ADMI = 0 OR COB_GESTI_COBRA.IND_VISA_ADMI IS NULL) " );
       // vbongiov -- 16/01/2009
       query.append(" AND  COB_GESTI_COBRA.IND_PASA_ADMI = 1 ");
       query.append(" AND  COB_GESTI_COBRA.PERD_OID_PERI = CRA_PERIO.OID_PERI " );
       query.append(" AND  COB_GESTI_COBRA.ETDE_OID_ETAPA_DEUDA = COB_ETAPA_DEUDA.OID_ETAP_DEUD " );
       query.append(" AND  COB_GESTI_COBRA.CLIE_OID_CLIE = MAE_CLIEN.OID_CLIE " );
       query.append(" AND  COB_GESTI_COBRA.ACCO_OID_ACCI_COBR = COB_ACCIO_COBRA.OID_ACCI_COBR " );

      if (dto.getOidPais() != null){
          query.append(" AND CRA_PERIO.PAIS_OID_PAIS = " + dto.getOidPais());              
      }
      
      if (dto.getUsuarioCobranzas() != null){
          query.append(" AND COB_GESTI_COBRA.USCO_OID_USUA_COBR = " + dto.getUsuarioCobranzas());              
      }

      if (dto.getMarca() != null){
          query.append(" AND CRA_PERIO.MARC_OID_MARC = " + dto.getMarca()); 
      }
      
      if (dto.getCanal() != null){
          query.append(" AND CRA_PERIO.CANA_OID_CANA = " + dto.getCanal()); 
      }
      
      if (dto.getTipoCargo() != null){
          //query.append(" AND COB_GESTI_COBRA.TCAB_OID_TIPO_CARG_ABON =  " + dto.getTipoCargo()); 
          query.append(" AND COB_GESTI_COBRA.EDTC_OID_ETAP_DEUD_TIPO_CARG =  " + dto.getTipoCargo());
      }
      
      UtilidadesLog.debug("codigo de cliente>>>>> " + dto.getCodCliente());
      UtilidadesLog.debug("codigo de cliente **** " + dto.getOidCliente());
      
       if (dto.getCodCliente() != null){
          query.append(" AND UPPER(mae_clien.COD_CLIE) LIKE '" +  dto.getCodCliente().toUpperCase()+ "' ");
      }
      
      // gPineda - 07/02/2007 - V-COB-013 - Se agrega el "(+)"
      query.append(" AND COB_GESTI_COBRA.EDTC_OID_ETAP_DEUD_TIPO_CARG = COB_ETAPA_DEUDA_TIPO_CARGO.OID_ETAP_DEUD_TIPO_CARG(+) ");
      
        if (dto.getTipoCargo() != null){          
          query.append(" AND COB_ETAPA_DEUDA_TIPO_CARGO.TCAB_OID_TIPO_CARG_ABON =  " + dto.getTipoCargo());
      }
       // ------incidencia  BELC300022865  -------
       if (dto.getPeriodo() != null){ 
            query.append("AND  CRA_PERIO.OID_PERI =  " + dto.getPeriodo());
       }
       
      // vbongiov -- 27/05/2008 
      query.append("ORDER BY FEC_SEGU ");       
       
      queryPaginado.append(" SELECT	oid, "); 
      queryPaginado.append(" COD_ETAP_DEUD, "); 
      queryPaginado.append(" VAL_NOMB_PERI, ");
      queryPaginado.append(" cliente, ");
      queryPaginado.append(" nombre, ");
      queryPaginado.append(" accion, ");
      queryPaginado.append(" IND_PETI_BLOQ, ");
      queryPaginado.append(" IND_PETI_DESB, ");
	  queryPaginado.append(" TIPOBLOQU, ");
      queryPaginado.append(" TIBQ_OID_TIPO_BLOQ, OID_CLIE ");
      queryPaginado.append(" FROM ( ");
      queryPaginado.append("     SELECT ROWNUM AS linea, queryPrincipal.* ");
      queryPaginado.append("     FROM (  ");
      queryPaginado.append(query.toString());
      queryPaginado.append("     )  queryPrincipal ");
              
      queryPaginado.append(" ) WHERE ROWNUM <= " + dto.getTamanioPagina() + " AND linea > " + dto.getIndicadorSituacion());

            
      try 
        {  
        rs = bs.dbService.executeStaticQuery(queryPaginado.toString());
        }
       catch (Exception ex){
            UtilidadesLog.error(ex); 
            throw new MareException(ex, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS));
       }	
       
       
       if (rs.esVacio())  {
            UtilidadesLog.debug("esta vacio");
            throw new MareException(new Exception(),UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE));                    
       }
	   
        dtoS.setResultado(rs);
        
        UtilidadesLog.debug("rs>>>> " + rs.toString());
        UtilidadesLog.info("DAOGestionesDeCobranza.buscarGestionesDeCobranzaSB(DTOBuscarGestionesDeCobranza dto): Salida");
       
       return dtoS;  
    }

  /** 
  * Metodo para
  * @param DTOBuscarGestionesDeCobranza dto
  * @return DTOSalida
  * @exception MareException 
  * @author 
  * @referencia SICC-DMCO-COB-201-324-N037
  */
  public DTOSalida buscarGestionesDeCobranzaPG(DTOBuscarGestionesDeCobranza dto) throws MareException {
  
    UtilidadesLog.info("DAOGestionesDeCobranza.buscarGestionesDeCobranzaPG(DTOBuscarGestionesDeCobranza dto): Entrada");
  
      DTOSalida dtoS = new DTOSalida();
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
       
      query.append("  SELECT  COB_GESTI_COBRA.OID_GEST_COBR oid, ");
      query.append("  COB_ETAPA_DEUDA.VAL_DESC etapa, ");
      query.append("  CRA_PERIO.VAL_NOMB_PERI periodo,  ");
      query.append("  MAE_CLIEN.COD_CLIE cliente, ");
      query.append("  COB_ACCIO_COBRA.COD_ACCI_COBR accion, ");
      query.append("  COB_GESTI_COBRA.FEC_SEGU fechaSeguimiento, ");
      query.append("  COB_GESTI_COBRA.VAL_HORA_SEGU horaSeguimiento, ");
	  query.append("  COB_GESTI_COBRA.FEC_GEST fechaGestion ");
      query.append("  FROM  COB_GESTI_COBRA,COB_ETAPA_DEUDA, CRA_PERIO, MAE_CLIEN, COB_ACCIO_COBRA, ");
	  query.append("  ZON_SUB_GEREN_VENTA,ZON_REGIO,ZON_ZONA,ZON_SECCI, ");
      query.append("  zon_terri, ZON_TERRI_ADMIN,MAE_CLIEN_UNIDA_ADMIN ");
      
      query.append("  WHERE COB_GESTI_COBRA.IND_PASA_ADMI = 1 "); 
      query.append("  AND (COB_GESTI_COBRA.IND_VISA_ADMI = 0 OR COB_GESTI_COBRA.IND_VISA_ADMI IS NULL) "); 
      query.append("  AND COB_GESTI_COBRA.PERD_OID_PERI = CRA_PERIO.OID_PERI "); 
      query.append("  AND COB_GESTI_COBRA.ETDE_OID_ETAPA_DEUDA = COB_ETAPA_DEUDA.OID_ETAP_DEUD "); 
      query.append("  AND COB_GESTI_COBRA.CLIE_OID_CLIE = MAE_CLIEN.OID_CLIE "); 
      query.append("  AND COB_GESTI_COBRA.ACCO_OID_ACCI_COBR = COB_ACCIO_COBRA.OID_ACCI_COBR "); 
      query.append("  AND MAE_CLIEN.OID_CLIE = MAE_CLIEN_UNIDA_ADMIN.CLIE_OID_CLIE "); 
      query.append("  AND MAE_CLIEN_UNIDA_ADMIN.ZTAD_OID_TERR_ADMI = ZON_TERRI_ADMIN.OID_TERR_ADMI "); 
      query.append("  AND ZON_TERRI_ADMIN.ZSCC_OID_SECC = ZON_SECCI.OID_SECC "); 
      query.append("  AND ZON_SECCI.ZZON_OID_ZONA = ZON_ZONA.OID_ZONA "); 
      query.append("  AND ZON_ZONA.ZORG_OID_REGI = ZON_REGIO.OID_REGI "); 
      query.append("  AND ZON_REGIO.ZSGV_OID_SUBG_VENT = ZON_SUB_GEREN_VENTA.OID_SUBG_VENT ");
      
      if (dto.getOidPais() != null){
          query.append(" AND CRA_PERIO.PAIS_OID_PAIS = " + dto.getOidPais());              
      }
      
      if (dto.getUsuarioCobranzas() != null){
          query.append(" AND COB_GESTI_COBRA.USCO_OID_USUA_COBR = " + dto.getUsuarioCobranzas());              
      }

      if (dto.getCodigoCliente() != null){
          query.append(" AND  MAE_CLIEN.COD_CLIE =  " + dto.getCodigoCliente());
      }
      
      if (dto.getMarca() != null){
          query.append(" AND  CRA_PERIO.MARC_OID_MARC = " + dto.getMarca()); 
      }
      
      if (dto.getCanal() != null){
          query.append(" AND   CRA_PERIO.CANA_OID_CANA = " + dto.getCanal()); 
      }
      
      if (dto.getPeriodo() != null){
          query.append(" AND  CRA_PERIO.OID_PERI = " + dto.getPeriodo()); 
      }
      
      if (dto.getSubgerenciaVentas() != null){
          query.append(" AND ZON_SUB_GEREN_VENTA.OID_SUBG_VENT = " + dto.getSubgerenciaVentas()); 
      }
      
      if (dto.getRegion() != null){
          query.append(" AND ZON_REGIO.OID_REGI = " + dto.getRegion()); 
      }
      
      if (dto.getZona() != null){
          query.append(" AND   ZON_ZONA.OID_ZONA =  " + dto.getZona()); 
      }
      
      if (dto.getSeccion() != null){
          query.append(" AND   ZON_SECCI.OID_SECC =  " + dto.getSeccion()); 
      }
      
      if (dto.getTerritorio() != null){
          query.append(" AND ZON_TERRI_ADMIN.TERR_OID_TERR =  " + dto.getTerritorio()); 
      }
      
      
query.append(" AND mae_clien_unida_admin.ind_acti = " + ConstantesCMN.VAL_TRUE);
query.append(" AND ZON_TERRI_ADMIN.oid_terr_admi = mae_clien_unida_admin.ZTAD_OID_TERR_ADMI ");
query.append(" AND ZON_TERRI_ADMIN.ind_borr = " + ConstantesCMN.VAL_FALSE);
query.append(" AND zon_terri.oid_terr = ZON_TERRI_ADMIN.terr_oid_terr ");
query.append(" AND zon_terri.ind_borr = " + ConstantesCMN.VAL_FALSE);
query.append(" AND ZON_SECCI.oid_secc = ZON_TERRI_ADMIN.zscc_oid_secc ");
query.append(" AND ZON_SECCI.ind_borr = " + ConstantesCMN.VAL_FALSE);
query.append(" AND ZON_SECCI.ind_acti = " + ConstantesCMN.VAL_TRUE);
query.append(" AND ZON_ZONA.oid_zona = ZON_SECCI.zzon_oid_zona ");
query.append(" AND ZON_ZONA.ind_borr = " + ConstantesCMN.VAL_FALSE);
query.append(" AND ZON_ZONA.ind_acti = " + ConstantesCMN.VAL_TRUE);
query.append(" AND ZON_REGIO.oid_regi = ZON_ZONA.zorg_oid_regi ");
query.append(" AND ZON_REGIO.ind_borr = " + ConstantesCMN.VAL_FALSE);
query.append(" AND ZON_REGIO.ind_acti = " + ConstantesCMN.VAL_TRUE);
query.append(" AND ZON_SUB_GEREN_VENTA.oid_subg_vent = ZON_REGIO.zsgv_oid_subg_vent ");
query.append(" AND ZON_SUB_GEREN_VENTA.ind_borr = " + ConstantesCMN.VAL_FALSE);
query.append(" AND ZON_SUB_GEREN_VENTA.ind_acti = " + ConstantesCMN.VAL_TRUE);

      
      
      try 
        {   rs = bs.dbService.executeStaticQuery(UtilidadesPaginacion.armarQueryPaginacion(query.toString(),dto));
        }
       catch (Exception ex){
           UtilidadesLog.error(ex);
           throw new MareException(ex, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS));
       }
       
       if (rs.esVacio())  {
            UtilidadesLog.debug("esta vacio");
            throw new MareException(new Exception(),UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE));                    
       }
       
       dtoS.setResultado(rs);
       
        UtilidadesLog.info("DAOGestionesDeCobranza.buscarGestionesDeCobranzaPG(DTOBuscarGestionesDeCobranza dto): Salida");
       
       return dtoS;  
    }

    /** 
    * Metodo 
    * @param DTOOID dto
    * @return DTOSalida
    * @exception MareException 
    * @author Cargain
    * @referencia SICC-DMCO-COB-201-324-N036
    */
  
    public DTOSalida compromisoPago(DTOEBuscarCompromisosPago dto) throws MareException{
    
    UtilidadesLog.info("DAOGestionesDeCobranza.compromisoPago(DTOEBuscarCompromisosPago dto): Entrada");
    
//-> Crear un DTOSalida 
//->Realizar la siguiente consulta JDBC (paginada) 

//select axion.COD_ACCI_COBR accion, 
//axion.VAL_DESC descripcipnaccion, 
//subaxion.COD_SUBT_ACCI subtipoaccion, 
//cmpa.COD_COMP_PAGO compromisopago, 
//cliente.COD_CLIE codigoCliente, 
//cmpa.FEC_PAGO fechapago, 
//cmpa.IMP_PAGO importepago, 
//cmpa.FEC_SEGU_PREV fechaseguimiento, 
//banco.DES_BANC banco, 
//sucursal.COD_SUCU sucursal, 
//cmpa.VAL_OBSE 
//from cob_compr_pago cmpa, 
//cob_accio_cobra axion, 
//COB_SUBTI_ACCIO subaxion, 
//COB_GESTI_COBRA gestcob, 
//mae_clien cliente, 
//ccc_sucur sucursal, 
//ccc_banco banco 
///where gestcob.OID_GEST_COBR = dto.get(oidGestionCobranza) 
//and gestcob.OID_GEST_COBR = cmpa.GECO_OID_GEST_COBR 
//and ACCO_OID_ACCI_COBR = axion.OID_ACCI_COBR 
//and axion.SACC_OID_SUBT_ACCI = subaxion.OID_SUBT_ACCI 
//and cliente.OID_CLIE = gestcob.CLIE_OID_CLIE 
//and cliente.PAIS_OID_PAIS = dto.get(pais) 
//and banco.OID_BANC = sucursal.CBAN_OID_BANC 
//and cmpa.SUCU_OID_SUCU = sucursal.OID_SUCU 
//and banco.PAIS_OID_PAIS = dto.get(pais) 

//->Encapsular el recordset en el DTOSalida 
//->Retornar el DTOSalida

        DTOSalida dtoS = new DTOSalida();
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
                
        query.append(" SELECT axion.cod_acci_cobr,  ");
        query.append(" axion.val_desc, ");
        query.append(" subaxion.cod_subt_acci,  ");
        query.append(" cmpa.cod_comp_pago, ");
        query.append(" cliente.cod_clie,  ");
        query.append(" cmpa.fec_pago,  ");
        query.append(" cmpa.imp_pago, ");
        query.append(" cmpa.fec_segu_prev,  ");
        query.append(" banco.des_banc,  ");
        query.append(" sucursal.cod_sucu, ");
        query.append(" cmpa.VAL_OBSE  ");
        query.append(" FROM ");
        query.append(" ccc_banco banco, ");
        query.append(" ccc_sucur sucursal, ");
        query.append(" ccc_sucur sucursal2, ");
        query.append(" mae_clien cliente, ");
        query.append(" cob_accio_cobra axion, ");
        query.append(" cob_compr_pago cmpa, ");
        query.append(" cob_gesti_cobra gestcob, ");
        query.append(" cob_subti_accio subaxion ");
        query.append(" WHERE (  ");
        //  Modificado por HRCS - fecha 12/04/2007 - Se modifico por incidencia Sicc20070179
        query.append(" (banco.oid_banc(+) = sucursal.cban_oid_banc) ");
        query.append(" AND (sucursal.oid_sucu(+) = cmpa.sucu_oid_sucu) ");
        query.append(" AND (sucursal2.oid_sucu(+) = gestcob.sucu_oid_sucu) ");
        query.append(" AND (cliente.oid_clie = gestcob.clie_oid_clie) ");
        query.append(" AND (axion.oid_acci_cobr = gestcob.acco_oid_acci_cobr) ");
        query.append(" AND (gestcob.oid_gest_cobr = cmpa.geco_oid_gest_cobr) ");
        query.append(" AND (subaxion.oid_subt_acci = axion.sacc_oid_subt_acci) ");
        query.append(" AND (cliente.PAIS_OID_PAIS = "+ dto.getOidPais() +" ) ");
        query.append(" AND (gestcob.OID_GEST_COBR = " + dto.getOidGestionCobranza()  +  ") ");
        query.append(" AND (banco.PAIS_OID_PAIS(+) = "+ dto.getOidPais());
        query.append(" )) ");
    
        UtilidadesLog.debug("Query:  " + query.toString());
      try 
        {   
            rs = bs.dbService.executeStaticQuery(UtilidadesPaginacion.armarQueryPaginacion(query.toString(),
                new DTOSiccPaginacion()));
        }
       catch (Exception ex) {
            UtilidadesLog.error(ex);
            throw new MareException(ex, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS));
       }	
       
       
       if (rs.esVacio())  {
              UtilidadesLog.debug("esta vacio");
               throw new MareException(new Exception(),UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE));                    
       }
	   
       dtoS.setResultado(rs);
       
        UtilidadesLog.info("DAOGestionesDeCobranza.compromisoPago(DTOEBuscarCompromisosPago dto): Salida");
       
       return dtoS; 
  }
  
  /**
	 * Sistema:     Belcorp
	 * Modulo:      COB
	 * Fecha:       08/03/2005
	 * @version     1.0
	 * @autor       Viviana Bongiovanni
	 */
  public DTOSalida obtenerMotivosNoCobro(DTOBelcorp dto) throws MareException {
  
        UtilidadesLog.info("DAOGestionesDeCobranza.obtenerMotivosNoCobro(DTOBelcorp dto): Entrada");
  
        BelcorpService bs;
        RecordSet respuesta = new RecordSet();
        StringBuffer buf = new StringBuffer();

        try {
            bs = BelcorpService.getInstance();
        } catch (MareMiiServiceNotFoundException e) {
            throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_PEDIR_UN_SERVICIO_MARE));
        }

        try {
            buf.append(" SELECT OID_MOTI_COBR, VAL_DESC_MOTI_COBR ");
            buf.append(" FROM COB_MOTIV_INCOB ");
            buf.append(" WHERE PAIS_OID_PAIS = " + dto.getOidPais());
            buf.append(" ORDER BY COD_MOTI_COBR ");
            
            respuesta = bs.dbService.executeStaticQuery(buf.toString());
                        
        } catch (Exception e) {
            throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS));
        }

        UtilidadesLog.info("DAOGestionesDeCobranza.obtenerMotivosNoCobro(DTOBelcorp dto): Salida");

        return new DTOSalida(respuesta);
  }
       
  /** 
  * Genera el mensaje
  * @param DTOGestionDeCobranza
  * @return void
  * @exception MareException 
  * @author mamontie
  * @referencia SICC-DMCO-COM-202-334-N036
  */
  
   public void crearGestion(DTOGestionDeCobranza dto) throws MareException {
   
   
   }
  
  
  public Long recuperarUsuario (DTOUsuariosPerfil  dto) throws MareException {
  
    UtilidadesLog.info("DAOGestionesDeCobranza.recuperarUsuario (DTOUsuariosPerfil  dto): Entrada");
  
     DTOSalida dtoSalida = new DTOSalida();
     BelcorpService belcorpService;
     RecordSet rs;
     String codigoError;
     BigDecimal oid;
     try {
          belcorpService = BelcorpService.getInstance();
      } catch (MareMiiServiceNotFoundException serviceNotFoundException) {
          codigoError = CodigosError.ERROR_AL_PEDIR_UN_SERVICIO_MARE;
          throw new MareException(serviceNotFoundException,
              UtilidadesError.armarCodigoError(codigoError));
      }
      StringBuffer stringBuffer = new StringBuffer();
      stringBuffer.append(" SELECT cobusu.oid_usua_cobr OID ");
      stringBuffer.append(" FROM principals p, users u, cob_usuar_cobra cobusu ");
      stringBuffer.append(" WHERE p.idprincipal = u.iduser ");
      stringBuffer.append(" AND u.iduser = cobusu.user_oid_usua_cobr  ");
      stringBuffer.append(" AND p.NAME = '" + dto.getLoginUsuario() + "' ");
      stringBuffer.append(" AND cobusu.PAIS_OID_PAIS = " + dto.getOidPais());
   
      //ejecutamos la consulta
      try {
          rs = belcorpService.dbService.executeStaticQuery(stringBuffer.toString());
      } catch (Exception exception) {
          codigoError = CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS;
          throw new MareException(exception,
              UtilidadesError.armarCodigoError(codigoError));
      }
      
      if ( rs.esVacio() != true )
      {
        oid = (BigDecimal)rs.getValueAt(0, 0);
      }
      else
      {
          return null;
      }
      
      
        UtilidadesLog.info("DAOGestionesDeCobranza.recuperarUsuario (DTOUsuariosPerfil  dto): Salida");
      
      return new Long(oid.longValue());
   
   }
   
   /**
	 * Sistema:     Belcorp
	 * Modulo:      COB
	 * Fecha:       10/03/2005
	 * @version     1.0
	 * @autor       Viviana Bongiovanni
	 */
  public DTOSalida buscarGestionesDeCobranzaTC(DTOBuscarGestionesDeCobranza dto) throws MareException {
  
        UtilidadesLog.info("DAOGestionesDeCobranza.buscarGestionesDeCobranzaTC(DTOBuscarGestionesDeCobranza dto): Entrada");
  
        BelcorpService bs;
        RecordSet respuesta = new RecordSet();
        StringBuffer buf = new StringBuffer();

        try {
            bs = BelcorpService.getInstance();
        } catch (MareMiiServiceNotFoundException e) {
            throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_PEDIR_UN_SERVICIO_MARE));
        }

        try {
            buf.append(" SELECT gest.OID_GEST_COBR OID, acc.COD_ACCI_COBR, ");
            buf.append(" acc.VAL_DESC, subAcc.COD_SUBT_ACCI, ");
            buf.append(" gest.FEC_SEGU, gest.VAL_HORA_SEGU, ");
            buf.append(" gest.FEC_REPR, gest.VAL_HORA_REPR, ");
            buf.append(" incob.VAL_DESC_MOTI_COBR ");
            buf.append(" FROM COB_GESTI_COBRA gest, MAE_CLIEN cli, ");
            buf.append(" COB_ACCIO_COBRA acc,  COB_SUBTI_ACCIO subAcc, ");
            buf.append(" COB_MOTIV_INCOB incob ");
            buf.append(" WHERE gest.CLIE_OID_CLIE = cli.OID_CLIE " );
            
            /* gPineda - V-COB-009 - 31/01/2007
            SimpleDateFormat formatter = new SimpleDateFormat ("dd-MM-yyyy");
            Timestamp date = new Timestamp(System.currentTimeMillis());
            
            buf.append(" AND FEC_GEST = TO_DATE('" + formatter.format(date) + "', 'DD-MM-YYYY')" );*/
            
            if(dto.getPeriodo()!=null)
                buf.append(" AND gest.PERD_OID_PERI = " + dto.getPeriodo());
                
            if(dto.getEtapaDeuda()!=null)
                buf.append(" AND gest.ETDE_OID_ETAPA_DEUDA = " + dto.getEtapaDeuda());
                
            if(dto.getOidPais()!=null)
                buf.append(" AND cli.PAIS_OID_PAIS = " + dto.getOidPais());
                
            if(dto.getCodCliente()!=null)
                buf.append(" AND cli.COD_CLIE = '" + dto.getCodCliente() +"' ");
            /////////////////////////////////////////////////////
            //Modificacion: Se agrego por incidencia COB05 Perú//
            //Hugo Mansi - 16/11/2005                          //
            /////////////////////////////////////////////////////
            buf.append(" AND gest.ACCO_OID_ACCI_COBR = acc.OID_ACCI_COBR ");
            buf.append(" AND acc.SACC_OID_SUBT_ACCI =  subacc.OID_SUBT_ACCI ");
            buf.append(" AND gest.MONO_OID_MOTI_COBR = incob.OID_MOTI_COBR (+) ");  
            /////////////////////////////////////////////////////
            
            // gPineda - V-COB-009 - 01/02/2007
            buf.append(" ORDER BY gest.FEC_GEST DESC, gest.OID_GEST_COBR DESC ");
            
            respuesta = BelcorpService.getInstance().dbService.executeStaticQuery(UtilidadesPaginacion.armarQueryPaginacion(buf.toString(), dto));
                        
        } catch (Exception e) {
            throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS));
        }
        
        if( respuesta.esVacio() ){
          UtilidadesLog.debug("************** No hay registros, se lanza la MareException");          
          throw new MareException(new Exception(),UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE));
        }  

        UtilidadesLog.info("DAOGestionesDeCobranza.buscarGestionesDeCobranzaTC(DTOBuscarGestionesDeCobranza dto): Salida");

        return new DTOSalida(respuesta);
  }
  
  /**
	 * Sistema:     Belcorp
	 * Modulo:      COB
	 * Fecha:       18/03/2005
	 * @version     1.0
	 * @autor       Viviana Bongiovanni
	 */
  public DTOUsuariosCobComboPerfil obtenerUsuariosCobComboPerfil(DTOUsuariosPerfil dtoEntrada) throws MareException {
  
    UtilidadesLog.info("DAOGestionesDeCobranza.obtenerUsuariosCobComboPerfil(DTOUsuariosPerfil dtoEntrada): Entrada");
  
      BelcorpService bs;
      RecordSet rs = new RecordSet();
      StringBuffer buf = new StringBuffer();
      DTOUsuariosCobComboPerfil respuesta = new DTOUsuariosCobComboPerfil();
      
      // Obtiene el OID_USUA_COBR
      dtoEntrada.setLoginUsuario(session.getCallerPrincipal().getName());    
      Long oidUsuario = this.recuperarUsuario(dtoEntrada);
      
      // Obtiene el perfil
      int perfil = this.recuperarPerfil(oidUsuario); 
      
      respuesta.setTipoUsuario(new Long(perfil));
      
      // Obtengo los usuarios
      try {
          bs = BelcorpService.getInstance();
      } catch (MareMiiServiceNotFoundException e) {
          throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_PEDIR_UN_SERVICIO_MARE));
      }
      
      
      /*Modifico Hugo Mansi en Perú por incidencia Perú
       * Fecha: 23/11/2005
       * Se modificaron las consultas pues lo correcto es recuperar los usuarios de la siguiente manera:
       * Si el usuario es solo un gestor, entonces se recupera a el mismo
       * Si el usuario es supervisor, se recuperan solo aquellos usuarios de cobranzas asignados a el supervisor logueado
       * Si el usuario es jefe podra ver a todos los usuarios de cobranzas
       * */
      DTOUsuariosPerfil dtoUP = new DTOUsuariosPerfil();
      dtoUP.setLoginUsuario(dtoEntrada.getLoginUsuario());
      dtoUP.setOidPais(dtoEntrada.getOidPais());
      
      DAOCobranzaExterna miDao = new DAOCobranzaExterna();
      DTOSalida dtoUsuID = miDao.recuperarUsuarioMasID(dtoUP);
      RecordSet rsUP = dtoUsuID.getResultado();
      Long idUser = new Long (((BigDecimal)rsUP.getValueAt(0,1)).longValue());
      
      if(perfil==0){
        // Usuario común (gestor)
        buf.append(" SELECT cobusu.oid_usua_cobr OID, p.NAME ");
        buf.append(" FROM principals p, users u, cob_usuar_cobra cobusu ");
        buf.append(" WHERE p.idprincipal = u.iduser ");
        buf.append(" AND u.iduser = cobusu.user_oid_usua_cobr ");
        buf.append(" AND cobusu.USER_OID_USUA_COBR = " + idUser);
        buf.append(" AND cobusu.PAIS_OID_PAIS = " + dtoEntrada.getOidPais());
        buf.append(" ORDER BY 2" );
        
      } else if(perfil==1){
        // Usuario Supervisor
        buf.append(" SELECT usu.oid_usua_cobr OID, p2.NAME  ");
        buf.append(" FROM cob_usuar_cobra usu, users u2, principals p2   ");        
        buf.append(" WHERE p2.idprincipal = u2.iduser ");
        buf.append(" AND u2.iduser = usu1.user_oid_usua_cobr ");
        buf.append(" AND usu.USER_OID_USUA_SUPE = " + idUser);
        buf.append(" AND usu.PAIS_OID_PAIS = " + dtoEntrada.getOidPais());
        
        buf.append(" ORDER BY 2" );
        
      } else if(perfil==2){
        // Usuario Jefe
        buf.append(" SELECT usu.oid_usua_cobr OID, p2.NAME  ");
        buf.append(" FROM cob_usuar_cobra usu, users u2, principals p2 ");        
        buf.append(" WHERE p2.idprincipal = u2.iduser ");
        buf.append(" AND u2.iduser = usu.user_oid_usua_cobr ");
        buf.append(" AND usu.PAIS_OID_PAIS = " + dtoEntrada.getOidPais());
        buf.append(" ORDER BY 2" );
      }           
      
      try {
          rs = bs.dbService.executeStaticQuery(buf.toString());
      } catch (Exception exception) {
          throw new MareException(exception,
              UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS));
      }
            
      respuesta.setUsuarios(rs);  
  
    UtilidadesLog.info("DAOGestionesDeCobranza.obtenerUsuariosCobComboPerfil(DTOUsuariosPerfil dtoEntrada): Salida");
  
      return respuesta;
  }
    
  /**
	 * Sistema:     Belcorp
	 * Modulo:      COB
	 * Fecha:       18/03/2005
	 * @version     1.0
	 * @autor       Viviana Bongiovanni
	 */
  private int recuperarPerfil(Long oidUsuario) throws MareException {
  
    UtilidadesLog.info("DAOGestionesDeCobranza.recuperarPerfil(Long oidUsuario): Entrada");
  
     DTOSalida dtoSalida = new DTOSalida();
     BelcorpService belcorpService;
     RecordSet rs;
     String codigoError;
     StringBuffer stringBuffer = new StringBuffer();
     int supervisor;
     int jefe;
     int perfil;
     
     try {
          belcorpService = BelcorpService.getInstance();
      } catch (MareMiiServiceNotFoundException serviceNotFoundException) {
          codigoError = CodigosError.ERROR_AL_PEDIR_UN_SERVICIO_MARE;
          throw new MareException(serviceNotFoundException,
              UtilidadesError.armarCodigoError(codigoError));
      }
      
      stringBuffer.append(" SELECT cobUsu.IND_USUA_SUPE supervisor, cobUsu.IND_JEFE_COBR jefe  ");
      stringBuffer.append(" FROM cob_usuar_cobra cobusu ");
      stringBuffer.append(" WHERE cobUsu.OID_USUA_COBR = " + oidUsuario );
   
      //ejecutamos la consulta
      try {
          rs = belcorpService.dbService.executeStaticQuery(stringBuffer.toString());
      } catch (Exception exception) {
          codigoError = CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS;
          throw new MareException(exception,
              UtilidadesError.armarCodigoError(codigoError));
      }
      
      supervisor = ((BigDecimal)rs.getValueAt(0, 0)).intValue();
      jefe = ((BigDecimal)rs.getValueAt(0, 1)).intValue();
      
      // Obtiene el perfil
      //Se agrega por incidencia Peru, el usuario puede ser jefe y supervisor, para el caso
      //debe reconocerse el perfil de mayor jerarquia (JEFE)
      //Hugo Mansi
      //23/11/2005
      if (supervisor == 1 && jefe == 1){
        perfil=2;
        UtilidadesLog.info("DAOGestionesDeCobranza.recuperarPerfil(Long oidUsuario): Salida");
        return perfil;
      }  
      if(supervisor==1)
        perfil=1;
      else if(jefe==1)
        perfil=2;
      else
        perfil=0;
      
        UtilidadesLog.info("DAOGestionesDeCobranza.recuperarPerfil(Long oidUsuario): Salida");
      
      return perfil;
   }
   
   public RecordSet obtenerTiposBloqueo(Long idioma ,String usuario) throws MareException {
		
        UtilidadesLog.info("DAOGestionesDeCobranza.obtenerTiposBloqueo(Long idioma ,String usuario): Entrada");

		StringBuffer consulta = new StringBuffer();
		consulta.append(" SELECT TB.OID_TIPO_BLOQ OID, "); 
		consulta.append("        PQ_APL_AUX.VALOR_GEN_I18N_SICC ("+idioma+", TB.OID_TIPO_BLOQ, 'MAE_TIPO_BLOQU') AS DES "); 
		consulta.append("   FROM MAE_TIPO_BLOQU TB, MAE_USUAR_BLOQU UB , MAE_VALOR_USUAR_BLOQU VUB, MAE_VALOR_ACCIO_BLOQU VAB ,PRINCIPALS P "); 
        // vongiov -- 28/05/2008
		consulta.append("  WHERE nvl(TB.IND_BLOQ_FINA,0) = 0 "); 
		consulta.append("    AND UB.TIBQ_OID_TIPO_BLOQ = TB.OID_TIPO_BLOQ "); 
		consulta.append("    AND VUB.OID_VALO_USUA_BLOQ = UB.MVUB_OID_VALO_USUA_BLOQ "); 
		consulta.append("    AND (VUB.COD_VALO_BLOQ = '"+ConstantesMAE.COD_VALOR_USUARIO_BLOQUEAR +"' OR VUB.COD_VALO_BLOQ = '"+ConstantesMAE.COD_VALOR_USUARIO_AMBOS+"')  "); 
		consulta.append("    AND TB.MAAB_OID_VALO_ACCI_BLOQ = VAB.OID_VALO_ACCI_BLOQ "); 
		consulta.append("    AND (VAB.COD_VALO_BLOQ = '"+ConstantesMAE.COD_VALOR_ACCION_AMBOS+"' OR VAB.COD_VALO_BLOQ = '"+ConstantesMAE.COD_VALOR_ACCION_MANUAL+"') "); 
		consulta.append("    AND UB.USER_OID_USER = P.IDPRINCIPAL "); 
		consulta.append("    AND P.NAME = '"+usuario+"' "); 
    
		BelcorpService bs = UtilidadesEJB.getBelcorpService();
		RecordSet rs = null;
		String codigoError = null;
		try {
			rs = bs.dbService.executeStaticQuery(consulta.toString());
		} catch (Exception e) {
            codigoError = CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS;
			            throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));
		}


		UtilidadesLog.info("DAOGestionesDeCobranza.obtenerTiposBloqueo(Long idioma ,String usuario): Salida");
		return rs;
	}
  
     public RecordSet obtenerTiposBloqueoCliente(DTOOID dto, String usuario) throws MareException {
		
        UtilidadesLog.info("DAOGestionesDeCobranza.obtenerTiposBloqueoCliente(DTOOID dto,String usuario): Entrada");

		StringBuffer consulta = new StringBuffer();
  	consulta.append(" SELECT CB.TIBQ_OID_TIPO_BLOQ OID, ");
    consulta.append(" PQ_APL_AUX.VALOR_GEN_I18N_SICC ("+dto.getOidIdioma()+" , TB.OID_TIPO_BLOQ, 'MAE_TIPO_BLOQU') AS DES, ");
    consulta.append(" TB.IND_BLOQ_FINA, CB.VAL_MOTI_BLOQ, CB.OBS_BLOQ " );
		consulta.append(" FROM MAE_CLIEN_BLOQU CB, MAE_TIPO_BLOQU TB " );
		consulta.append(" WHERE CB.TIBQ_OID_TIPO_BLOQ = TB.OID_TIPO_BLOQ " );
		consulta.append(" AND CB.FEC_DESB IS NULL " );
		consulta.append(" AND CB.CLIE_OID_CLIE = "+dto.getOid());
		consulta.append(" ORDER BY CB.FEC_BLOQ DESC ");
    
		BelcorpService bs = UtilidadesEJB.getBelcorpService();
		RecordSet rs = null;
		String codigoError = null;
		try {
			rs = bs.dbService.executeStaticQuery(consulta.toString());
		} catch (Exception e) {
            codigoError = CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS;
			            throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));
		}
    
		UtilidadesLog.info("DAOGestionesDeCobranza.obtenerTiposBloqueoCliente(DTOOID dto, String usuario): Salida");
		return rs;
	}
  
}
