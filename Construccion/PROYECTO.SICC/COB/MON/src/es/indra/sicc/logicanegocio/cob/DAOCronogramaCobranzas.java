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
package es.indra.sicc.logicanegocio.cob;
import es.indra.mare.common.mii.MareMiiServiceNotFoundException;
import es.indra.sicc.util.BelcorpService;
import es.indra.sicc.util.CodigosError;
import es.indra.sicc.util.DTOBelcorp;
import es.indra.sicc.util.DTOSalida;
import es.indra.mare.common.exception.MareException;
import es.indra.mare.common.mii.services.jdbcservice.RecordSet;
import es.indra.sicc.dtos.cob.DTOEBuscarCronogramaCOBPeriodo;
import es.indra.sicc.util.DTOOID;
import es.indra.sicc.util.UtilidadesError;
import es.indra.sicc.util.UtilidadesLog;
import es.indra.sicc.util.UtilidadesPaginacion;

import java.math.BigDecimal;

import java.lang.StringBuffer;

public class DAOCronogramaCobranzas 
{
  public DAOCronogramaCobranzas()
  {
  }
  /** 
  * @author ssantana, 22/2/2005
  * @param DTOBelcorp dto
  * @return DTOSalida
  * @exception MareException 
  * @referencia SICC-DMCO-COB-201-324-N037
  */
  public DTOSalida consultarEtapasCobranza(DTOBelcorp dto) throws MareException{
  
    UtilidadesLog.info("DAOCronogramaCobranzas.consultarEtapasCobranza(DTOBelcorp dto): Entrada");
  
    DTOSalida dtoSalida = null;
    RecordSet r = null;
    BelcorpService bs = null;
    StringBuffer sqlQuery = new StringBuffer();
    
    sqlQuery.append(" SELECT oid_etap_deud, cod_etap_deud, val_desc, val_edad_inic, val_edad_fina ");
    sqlQuery.append(" FROM cob_etapa_deuda ");
    sqlQuery.append(" WHERE cob_etapa_deuda.pais_oid_pais = " + dto.getOidPais() );
    
    bs = BelcorpService.getInstance();
    
    try 
    {
      r = bs.dbService.executeStaticQuery( sqlQuery.toString() );
    } catch (Exception ex){
        UtilidadesLog.error(ex);
      
      String codigoError = CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS;
      throw new MareException( ex, UtilidadesError.armarCodigoError(codigoError) );
    }

    UtilidadesLog.debug("r: " + r);
    
    dtoSalida = new DTOSalida();
    dtoSalida.setResultado(r);
    
    UtilidadesLog.info("DAOCronogramaCobranzas.consultarEtapasCobranza(DTOBelcorp dto): Salida");
    
    return dtoSalida;
    
  }
  /** 
  * @author ssantana, 25/2/2005
  * @param Long pais, Long etapa, RecordSet zonas
  * @return RecordSet
  * @exception MareException 
  * @referencia SICC-DMCO-COB-201-324-N037
  */
  public RecordSet obtenerUsuariosEtapaCobranzaDetalle(Long pais, Long etapa, Long oidIdioma) throws MareException{
    UtilidadesLog.info("DAOCronogramaCobranzas.obtenerUsuariosEtapaCobranzaDetalle(Long pais, Long etapa, Long oidIdioma): Entrada");
  
    // Tapon - Codigo Tapon
    /*RecordSet r = new RecordSet();
    Vector v = new Vector();
    v.add("USU.OID_USUA_COBR USUARIO"); 
    v.add("EDTC.TCAB_OID_TIPO_CARG_ABON TIPO_CARGO");
    v.add("EDTC.ETDE_OID_ETAP_DEUD ETAPA_DEUDA");
    v.add("UECD.TERR_OID_TERR TERRITORIO");
    v.add("ED.VAL_EDAD_FINA EDAD_MAXIMA");
    v.add("ED.VAL_EDAD_INIC EDAD_MINIMA");
    
    r.setColumnCount(6);
    r.setColumnIdentifiers(v);
    r.setRowCount(1);
    
    r.setValueAt(new BigDecimal(1), 0, 0);    
    r.setValueAt(new BigDecimal(1), 0, 1);        
    r.setValueAt(new BigDecimal(1), 0, 2);        
    r.setValueAt(new BigDecimal(1), 0, 3);        
    r.setValueAt(new BigDecimal(10), 0, 4);    
    r.setValueAt(new BigDecimal(20), 0, 5);*/
    RecordSet r = new RecordSet();    
    try {
        StringBuffer sqlSelect = null;
        String sQuery = null;
        BelcorpService bs = BelcorpService.getInstance();
        
        sqlSelect = new StringBuffer("");

        sqlSelect.append(" SELECT usu.oid_usua_cobr usuario, edtc.tcab_oid_tipo_carg_abon tipo_cargo, ");
        sqlSelect.append(" edtc.etde_oid_etap_deud etapa_deuda, uecd.terr_oid_terr territorio, ");
        sqlSelect.append(" ed.val_edad_fina edad_maxima, ed.val_edad_inic edad_minima, ");
        sqlSelect.append(" v1.val_i18n desc_tipo_cargo, ed.cod_etap_deud cod_etapa_deuda, ");
        sqlSelect.append(" subgv.des_subg_vent, regio.des_regi, zona.des_zona, seccion.des_secci, ");
        sqlSelect.append(" territorio.COD_TERR, p.NAME, subgv.oid_subg_vent, regio.oid_regi, ");
        sqlSelect.append(" zona.oid_zona, seccion.oid_secc ");
        sqlSelect.append(" FROM cob_usuar_etapa_cobra_detal uecd, ");
        sqlSelect.append(" cob_usuar_cobra usu, ");
        sqlSelect.append(" cob_usuar_etapa_cobra_cabec uecc, ");
        sqlSelect.append(" cob_etapa_deuda_tipo_cargo edtc, ");
        sqlSelect.append(" cob_etapa_deuda ed, ");
        sqlSelect.append(" zon_secci seccion, ");
        sqlSelect.append(" zon_zona zona, ");
        sqlSelect.append(" v_gen_i18n_sicc v1, ");
        sqlSelect.append(" zon_terri territorio, ");
        sqlSelect.append(" zon_regio regio, ");
        sqlSelect.append(" zon_sub_geren_venta subgv, ");
        sqlSelect.append(" principals p ");
        sqlSelect.append(" WHERE uecd.uecc_oid_usua_etap_cobr = uecc.oid_usua_etap_cobr ");
        sqlSelect.append(" AND uecc.usco_oid_usua_cobr = usu.oid_usua_cobr ");
        sqlSelect.append(" AND uecd.EDTC_OID_ETAP_DEUD_TIPO_CARG = edtc.oid_etap_deud_tipo_carg ");
        sqlSelect.append(" AND uecc.ETDE_OID_ETAP_DEUD = " + etapa +" ");
        sqlSelect.append(" AND ed.OID_ETAP_DEUD = uecc.ETDE_OID_ETAP_DEUD ");
        sqlSelect.append(" AND usu.pais_oid_pais = " + pais + " ");
        sqlSelect.append(" AND territorio.OID_TERR(+) = uecd.TERR_OID_TERR ");
        sqlSelect.append(" AND seccion.OID_SECC(+) = uecd.ZSCC_OID_SECC ");
        sqlSelect.append(" AND zona.OID_ZONA(+) = uecd.ZZON_OID_ZONA ");
        sqlSelect.append(" AND regio.OID_REGI(+) = uecd.ZORG_OID_REGI ");
        sqlSelect.append(" AND subgv.OID_SUBG_VENT = uecd.ZSGV_OID_SUBG_VENT ");
        sqlSelect.append(" AND v1.attr_enti = 'CCC_TIPO_CARGO_ABONO' ");
        sqlSelect.append(" AND v1.attr_num_atri = 1 ");
        sqlSelect.append(" AND v1.val_oid = edtc.tcab_oid_tipo_carg_abon ");
        sqlSelect.append(" AND v1.idio_oid_idio = "+ oidIdioma +" ");
        sqlSelect.append(" AND usu.user_oid_usua_cobr = p.IDPRINCIPAL ");
           
        sQuery = sqlSelect.toString();
        
        r = bs.dbService.executeStaticQuery(sQuery);
        
        UtilidadesLog.debug("RecordSet: " + r);
        
        if (!r.esVacio()){
            UtilidadesLog.info("DAOCronogramaCobranzas.obtenerUsuariosEtapaCobranzaDetalle(Long pais, Long etapa, Long oidIdioma): Salida");
            return r;
        }
        
    } catch (Exception ex){
        UtilidadesLog.error(ex);
      
      String codigoError = CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS;
      throw new MareException(ex, UtilidadesError.armarCodigoError(codigoError) );
    }
    
    // Si llego aca, devuelve un new RecordSet() porque no encontro registros
    UtilidadesLog.debug(" No se encontraron registros");
    UtilidadesLog.info("DAOCronogramaCobranzas.obtenerUsuariosEtapaCobranzaDetalle(Long pais, Long etapa, Long oidIdioma): Salida");
    return r;
  }
  /** 
  * @Author ssantana, 24/2/2005
  * @param DTOEBuscarCronogramaCOBPeriodo dto
  * @return DTOSalida
  * @exception MareException 
  * @referencia SICC-DMCO-COB-201-324-N037
  */
  public DTOSalida buscarCronogramaCOBPeriodo(DTOEBuscarCronogramaCOBPeriodo dto) throws MareException{
    UtilidadesLog.info("DAOCronogramaCobranzas.buscarCronogramaCOBPeriodo(DTOEBuscarCronogramaCOBPeriodo dto): Entrada");
  
      StringBuffer sqlQuery = new StringBuffer("");
      String queryPaginada = null;
      RecordSet r = null;
      DTOSalida dtoSalida = null;
      BelcorpService bs = null;
     
/*      sqlQuery.append(" SELECT cob_crono_cobra.oid_cron_cobr OID, cob_crono_cobra.cod_cart, ");
      sqlQuery.append(" principals.NAME, cob_etapa_deuda.val_desc, v1.val_i18n tipocargoabono, ");
      sqlQuery.append(" seg_marca.des_marc, v2.val_i18n canal, cra_perio.val_nomb_peri, ");
      sqlQuery.append(" zon_sub_geren_venta.des_subg_vent, zon_regio.des_regi, ");
      sqlQuery.append(" zon_zona.des_zona, zon_secci.des_secci, cob_crono_cobra.fec_cier, ");
      sqlQuery.append(" cob_crono_cobra.fec_eval, cob_crono_cobra.fec_audi ");
      sqlQuery.append(" FROM cob_crono_cobra, ");
      sqlQuery.append(" cra_perio, ");
      sqlQuery.append(" seg_marca, ");
      sqlQuery.append(" seg_canal, ");
      sqlQuery.append(" cob_etapa_deuda, ");
      sqlQuery.append(" ccc_tipo_cargo_abono, ");
      sqlQuery.append(" cob_usuar_cobra, ");
      sqlQuery.append(" users, ");
      sqlQuery.append(" principals, ");
      sqlQuery.append(" zon_terri_admin, ");
      sqlQuery.append(" zon_terri, ");
      sqlQuery.append(" zon_secci, ");
      sqlQuery.append(" zon_zona, ");
      sqlQuery.append(" zon_regio, ");
      sqlQuery.append(" zon_sub_geren_venta, ");
      sqlQuery.append(" v_gen_i18n_sicc v1, ");
      sqlQuery.append(" v_gen_i18n_sicc v2 ");
      sqlQuery.append(" WHERE cob_crono_cobra.perd_oid_peri = cra_perio.oid_peri ");
      if (dto.getOidPais() != null)
        sqlQuery.append(" AND cra_perio.pais_oid_pais = " + dto.getOidPais());
        
      if (dto.getMarca() != null)
        sqlQuery.append(" AND cra_perio.marc_oid_marc = " + dto.getMarca());
      
      if (dto.getCanal() != null)
        sqlQuery.append(" AND cra_perio.cana_oid_cana = " + dto.getCanal());
        
      if (dto.getPeriodo() != null)
        sqlQuery.append(" AND cra_perio.oid_peri = " + dto.getPeriodo());
        
      sqlQuery.append(" AND cra_perio.marc_oid_marc = seg_marca.oid_marc ");
      sqlQuery.append(" AND cra_perio.cana_oid_cana = seg_canal.oid_cana ");
      sqlQuery.append(" AND cob_crono_cobra.etde_oid_etap_deud = cob_etapa_deuda.oid_etap_deud ");
      sqlQuery.append(" AND cob_crono_cobra.tcab_oid_tipo_carg_abon = ccc_tipo_cargo_abono.oid_tipo_carg_abon ");
      sqlQuery.append(" AND cob_crono_cobra.usco_oid_usua_cobr = cob_usuar_cobra.oid_usua_cobr  ");
      sqlQuery.append(" AND cob_usuar_cobra.user_oid_usua_cobr = users.iduser ");
      sqlQuery.append(" AND users.iduser = principals.idprincipal ");
      sqlQuery.append(" AND cob_crono_cobra.ztad_oid_terr_admi = zon_terri_admin.oid_terr_admi ");
      sqlQuery.append(" AND zon_terri_admin.terr_oid_terr = zon_terri.oid_terr ");
      sqlQuery.append(" AND zon_terri_admin.zscc_oid_secc = zon_secci.oid_secc ");
      sqlQuery.append(" AND zon_secci.zzon_oid_zona = zon_zona.oid_zona ");
      sqlQuery.append(" AND zon_zona.zorg_oid_regi = zon_regio.oid_regi ");
      sqlQuery.append(" AND zon_regio.zsgv_oid_subg_vent = zon_sub_geren_venta.oid_subg_vent ");
      sqlQuery.append(" AND v1.attr_enti = 'CCC_TIPO_CARGO_ABONO' ");
      sqlQuery.append(" AND v1.attr_num_atri = 1 ");
      sqlQuery.append(" AND v1.idio_oid_idio = " + dto.getOidIdioma());
      sqlQuery.append(" AND v1.val_oid = ccc_tipo_cargo_abono.oid_tipo_carg_abon ");
      sqlQuery.append(" AND v2.attr_enti = 'SEG_CANAL' ");
      sqlQuery.append(" AND v2.attr_num_atri = 1 ");
      sqlQuery.append(" AND v2.idio_oid_idio = " + dto.getOidIdioma());
      sqlQuery.append(" AND v2.val_oid = seg_canal.oid_cana ");*/
      
      
      // Modificado por ssantana, 4/3/2005 - Se cambia query por 
      // script en cob_crono_cobra que agregan campos de zonificacion
      // ---------------------------------------------------------------
      sqlQuery.append(" SELECT cob_crono_cobra.oid_cron_cobr OID, cob_crono_cobra.cod_cart, ");
      sqlQuery.append(" principals.NAME, cob_etapa_deuda.val_desc, v1.val_i18n tipocargoabono, ");
      sqlQuery.append(" seg_marca.des_marc, v2.val_i18n canal, cra_perio.val_nomb_peri, ");
      sqlQuery.append(" zon_sub_geren_venta.des_subg_vent, zon_regio.des_regi, ");
      sqlQuery.append(" zon_zona.des_zona, zon_secci.des_secci, zon_terri.cod_terr, ");
      sqlQuery.append(" cob_crono_cobra.fec_cier, cob_crono_cobra.fec_eval, ");
      sqlQuery.append(" cob_crono_cobra.fec_audi, ");
      
      // vconte incidencia  BELC300021453
      sqlQuery.append(" cob_etapa_deuda.VAL_EDAD_INIC ,");
      sqlQuery.append(" cob_etapa_deuda.VAL_EDAD_FINA , ");
      sqlQuery.append(" (cob_crono_cobra.fec_cier - cob_etapa_deuda.VAL_EDAD_FINA) FECHA_FACT ");
      
      sqlQuery.append(" FROM cob_crono_cobra, ");
      sqlQuery.append(" cra_perio, ");
      sqlQuery.append(" seg_marca, ");
      sqlQuery.append(" seg_canal, ");
      sqlQuery.append(" cob_etapa_deuda, ");
      sqlQuery.append(" ccc_tipo_cargo_abono, ");
      sqlQuery.append(" cob_usuar_cobra, ");
      sqlQuery.append(" users, ");
      sqlQuery.append(" principals, ");
      sqlQuery.append(" zon_terri, ");
      sqlQuery.append(" zon_secci, ");
      sqlQuery.append(" zon_zona, ");
      sqlQuery.append(" zon_regio, ");
      sqlQuery.append(" zon_sub_geren_venta, ");
      sqlQuery.append(" v_gen_i18n_sicc v1, ");
      sqlQuery.append(" v_gen_i18n_sicc v2 ");
      sqlQuery.append(" WHERE cob_crono_cobra.perd_oid_peri = cra_perio.oid_peri ");
      
      if (dto.getOidPais() != null)
        sqlQuery.append(" AND cra_perio.pais_oid_pais = " + dto.getOidPais());
        
      if (dto.getMarca() != null)
        sqlQuery.append(" AND cra_perio.marc_oid_marc = " + dto.getMarca());
      
      if (dto.getCanal() != null)
        sqlQuery.append(" AND cra_perio.cana_oid_cana = " + dto.getCanal());
        
      if (dto.getPeriodo() != null)
        sqlQuery.append(" AND cra_perio.oid_peri = " + dto.getPeriodo());

      sqlQuery.append(" AND cra_perio.marc_oid_marc = seg_marca.oid_marc ");
      sqlQuery.append(" AND cra_perio.cana_oid_cana = seg_canal.oid_cana ");
      sqlQuery.append(" AND cob_crono_cobra.etde_oid_etap_deud = cob_etapa_deuda.oid_etap_deud ");
      sqlQuery.append(" AND cob_crono_cobra.tcab_oid_tipo_carg_abon = ccc_tipo_cargo_abono.oid_tipo_carg_abon ");
      sqlQuery.append(" AND cob_crono_cobra.usco_oid_usua_cobr = cob_usuar_cobra.oid_usua_cobr ");
      sqlQuery.append(" AND cob_usuar_cobra.user_oid_usua_cobr = users.iduser ");
      sqlQuery.append(" AND users.iduser = principals.idprincipal ");
      sqlQuery.append(" AND cob_crono_cobra.zorg_oid_regi = zon_regio.oid_regi(+) ");
      sqlQuery.append(" AND cob_crono_cobra.zscc_oid_secc = zon_secci.oid_secc(+) ");
      sqlQuery.append(" AND cob_crono_cobra.zzon_oid_zona = zon_zona.oid_zona(+) ");
      sqlQuery.append(" AND cob_crono_cobra.zsgv_oid_subg_vent = zon_sub_geren_venta.oid_subg_vent ");
      sqlQuery.append(" AND cob_crono_cobra.terr_oid_terr = zon_terri.oid_terr(+) ");
      sqlQuery.append(" AND v1.attr_enti = 'CCC_TIPO_CARGO_ABONO' ");
      sqlQuery.append(" AND v1.attr_num_atri = 1 ");
      sqlQuery.append(" AND v1.idio_oid_idio = " + dto.getOidIdioma() );
      sqlQuery.append(" AND v1.val_oid = ccc_tipo_cargo_abono.oid_tipo_carg_abon ");
      sqlQuery.append(" AND v2.attr_enti = 'SEG_CANAL' ");
      sqlQuery.append(" AND v2.attr_num_atri = 1 ");
      sqlQuery.append(" AND v2.idio_oid_idio = " + dto.getOidIdioma() );
      sqlQuery.append(" AND v2.val_oid = seg_canal.oid_cana ORDER BY OID ASC ");
      
      
      bs = BelcorpService.getInstance();
      try {
         // Verifica si la consulta debe ser paginada.
         if (dto.getPaginado().booleanValue())
          queryPaginada = UtilidadesPaginacion.armarQueryPaginacion(sqlQuery.toString(), dto);
        else
          queryPaginada = sqlQuery.toString();
          
         r = bs.dbService.executeStaticQuery( queryPaginada );
      } catch (Exception ex){
        UtilidadesLog.error(ex);
         
         String codigoError = CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS;
         throw new MareException( ex, UtilidadesError.armarCodigoError(codigoError) );
      }
      
      UtilidadesLog.debug("RecordSet: " + r);
      
      if ( r.esVacio() )
      {
        String codigoError = CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE;
        throw new MareException("No hay registros", UtilidadesError.armarCodigoError(codigoError));
      }
      

      dtoSalida = new DTOSalida();
      dtoSalida.setResultado(r);
     
        UtilidadesLog.info("DAOCronogramaCobranzas.buscarCronogramaCOBPeriodo(DTOEBuscarCronogramaCOBPeriodo dto): Salida");
     
      return dtoSalida;
  }
  /** 
  * Metodo para cargar el combo de etapas de la pantalla de consulta de asignacion de cartera para periodo
  * @param DTOOID dto
  * @return DTOSalida
  * @exception MareException 
  * @author enozigli
  * @referencia SICC-DMCO-COB-201-324-N037 e Incidencia duda 13429
  */
  public DTOSalida obtenerEtapasUsuarioCOB(DTOOID dto) throws MareException{
  
    UtilidadesLog.info("DAOCronogramaCobranzas.obtenerEtapasUsuarioCOB(DTOOID dto): Entrada");
  
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

      //Incidencia duda 13429 enozigli 16/02/2005
      query.append(" SELECT etap.OID_ETAP_DEUD OID, etap.VAL_DESC "); 
      query.append(" FROM COB_ETAPA_DEUDA etap ");
      if (dto.getOid()!=null) {
          query.append(" , COB_USUAR_ETAPA_COBRA_CABEC etapcabe "); 
      }
      query.append(" WHERE etap.PAIS_OID_PAIS = "+dto.getOidPais()+" ");       
      if (dto.getOid()!=null) {
          query.append(" AND etapcabe.ETDE_OID_ETAP_DEUD = etap.OID_ETAP_DEUD "); 
          query.append(" AND etapcabe.USCO_OID_USUA_COBR = "+dto.getOid()+" "); 
      }
      
      query.append(" ORDER BY etap.VAL_DESC "); 

      try 
        {   rs = bs.dbService.executeStaticQuery(query.toString());
        }
       catch (Exception ex) 
       {   throw new MareException(ex, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS));
       }	
       dtoS.setResultado(rs);
       
        UtilidadesLog.info("DAOCronogramaCobranzas.obtenerEtapasUsuarioCOB(DTOOID dto): Salida");
       
       return dtoS;  
  }
  
  
  private String generaINZonas(RecordSet zonas) throws Exception{ 
  
    UtilidadesLog.info("DAOCronogramaCobranzas.generaINZonas(RecordSet zonas): Entrada");
  
     // Zonas siempre trae siempre al menos 1 registro. 
     StringBuffer sClausula = new StringBuffer("");
     
     sClausula.append(" IN ( ");
     
     for (int i = 0; i < zonas.getRowCount(); i++)
     {
        BigDecimal bigZona = (BigDecimal) zonas.getValueAt(i,0);
        long oidZona = bigZona.longValue();
        
        if (i != 0)
          sClausula.append(", ");
          
        sClausula.append(""+ oidZona);
     }
     
     sClausula.append(")");
     
    UtilidadesLog.info("DAOCronogramaCobranzas.generaINZonas(RecordSet zonas): Salida");
     
     return sClausula.toString();
  }
}