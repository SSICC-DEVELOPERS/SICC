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
import es.indra.sicc.dtos.cob.DTOBuscarClientesAsignados;
import es.indra.sicc.dtos.cob.DTOIdLote;
import es.indra.sicc.util.BelcorpService;
import es.indra.sicc.util.CodigosError;
import es.indra.sicc.util.DTOSalida;
import es.indra.mare.common.exception.MareException;
import es.indra.sicc.util.UtilidadesError;
import es.indra.sicc.util.DTOBelcorp;
import es.indra.sicc.util.DTOOID;
import javax.ejb.SessionContext;
import es.indra.sicc.logicanegocio.cob.ConstantesCOB;
import es.indra.sicc.cmn.negocio.ConstantesCMN;
import java.util.Vector;
import es.indra.sicc.util.UtilidadesLog;
import es.indra.sicc.util.UtilidadesEJB;


/**
 * Sistema:           Belcorp
 * Modulo:            DTO
 * Submódulo:           
 * Componente:        DAOSoporteCobranza
 * Fecha:             25/02/2005
 * Observaciones:     Componente construido de acuerdo a la especificación del
 *                    Modelo de Componentes SICC-DMCO-COB-201-324-N036
 *
 * @version           1.0
 * @autor             Gustavo De Marzi
 */
 
public class DAOSoporteCobranza {
  private SessionContext sessionContext;
  public DAOSoporteCobranza()  {
  }

  /** 
  * Obtiene los oids lotes para de histoticoMensages para un pais.
  * @param DTOBelcorp
  * @return DTOSalida
  * @exception MareException 
  * @author gdmarzi
  * @referencia SICC-DMCO-COB-201-324-N036 y DMCO-Incidencia 13658
  */
  public DTOSalida cargarIdLotes(DTOBelcorp dtoEntrada) throws MareException {
    UtilidadesLog.info("DAOSoporteCobranza.cargarIdLotes(DTOBelcorp dtoEntrada): Entrada");
  
      DTOSalida dtoSalida = new DTOSalida();
      BelcorpService belcorpService;
      RecordSet rsLotes;
      String codigoError;
      try {
          belcorpService = BelcorpService.getInstance();
      } catch (MareMiiServiceNotFoundException serviceNotFoundException) {
          codigoError = CodigosError.ERROR_AL_PEDIR_UN_SERVICIO_MARE;
          throw new MareException(serviceNotFoundException,
              UtilidadesError.armarCodigoError(codigoError));
      }
      StringBuffer stringBuffer = new StringBuffer();
      // -> Realizar la siguiente consulta JDBC:
     /* stringBuffer.append(" SELECT oid_hist_mens OID, cod_lote idLote ");
      stringBuffer.append(" FROM cob_histo_mensa histo, cra_perio perio ");
      stringBuffer.append(" WHERE histo.fec_entr_mens IS NULL ");
      stringBuffer.append("  AND histo.perd_oid_peri = perio.oid_peri ");
      stringBuffer.append("  AND perio.pais_oid_pais = " + dtoEntrada.getOidPais() );
        */
      //Incidencia BELC300014557   
       stringBuffer.append(" SELECT distinct cod_lote OID, cod_lote idLote  ");       
       stringBuffer.append(" FROM cob_histo_mensa histo, cra_perio perio ");
       stringBuffer.append(" WHERE histo.fec_entr_mens IS NULL ");
       stringBuffer.append(" AND histo.perd_oid_peri = perio.oid_peri ");
       stringBuffer.append(" AND perio.pais_oid_pais =  " + dtoEntrada.getOidPais() );
       
      //ejecutamos la consulta
      try {
          rsLotes = belcorpService.dbService.executeStaticQuery(stringBuffer.toString());
      } catch (Exception exception) {
          codigoError = CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS;
          throw new MareException(exception,
              UtilidadesError.armarCodigoError(codigoError));
      }

      if (rsLotes.esVacio()){
        throw new MareException(null, null,UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE));
      }  

      // ->Retornar el dtoSalida 
        dtoSalida.setResultado(rsLotes);
      
        UtilidadesLog.info("DAOSoporteCobranza.cargarIdLotes(DTOBelcorp dtoEntrada): Salida");
      
        return dtoSalida;
  }


  /** 
  * Obtiene todos los mensages no enviados para un oiLote de un pais.
  * @param DTOOID
  * @return DTOSalida
  * @exception MareException 
  * @author gdmarzi
  * @referencia SICC-DMCO-COB-201-324-N036 y DMCO-Incidencia 13658
  */
  public DTOSalida cargarMensajesLote(DTOOID dto) throws MareException {
    UtilidadesLog.info("DAOSoporteCobranza.cargarMensajesLote(DTOOID dto): Entrada");
  
      DTOSalida dtoSalida = new DTOSalida();
      BelcorpService belcorpService;
      RecordSet rsMensajes;
      String codigoError;
      try {
          belcorpService = BelcorpService.getInstance();
      } catch (MareMiiServiceNotFoundException serviceNotFoundException) {
          codigoError = CodigosError.ERROR_AL_PEDIR_UN_SERVICIO_MARE;
          throw new MareException(serviceNotFoundException,
              UtilidadesError.armarCodigoError(codigoError));
      }
      StringBuffer stringBuffer = new StringBuffer();
      // -> Realizar la siguiente consulta JDBC:
      stringBuffer.append(" SELECT mensaje.oid_hist_mens OID, ");
      stringBuffer.append("  etapa.cod_etap_deud etapadeuda, ");
      stringBuffer.append("  segperio.cod_peri codperiodo, ");
      stringBuffer.append("  cliente.COD_CLIE codCliente, ");
      stringBuffer.append("  mensaje.FEC_ENTR_MENS fechaentrega, ");
      stringBuffer.append("  mensaje.VAL_OBSE observaciones ");
      stringBuffer.append(" FROM cob_histo_mensa mensaje, ");
      stringBuffer.append("  cob_etapa_deuda etapa, ");
      stringBuffer.append("  seg_perio_corpo segperio, ");
      stringBuffer.append("  cra_perio craperio, ");
      stringBuffer.append("  mae_clien cliente, ");
      stringBuffer.append("  msg_buzon_mensa buzon ");
     // stringBuffer.append(" WHERE etapa.mens_oid_mens = mensaje.oid_hist_mens ");
     //Incidencia BELC300017273  - mamontie
      stringBuffer.append(" WHERE etapa.OID_ETAP_DEUD = mensaje.ETDE_OID_ETAP_DEUD  ");
      stringBuffer.append("  AND craperio.oid_peri = mensaje.perd_oid_peri ");
      stringBuffer.append("  AND craperio.peri_oid_peri = segperio.oid_peri ");
      stringBuffer.append("  AND mensaje.bume_oid_buzo_mens = buzon.oid_buzo_mens ");
      stringBuffer.append("  AND buzon.CLIE_OID_CLIE = cliente.OID_CLIE ");
      stringBuffer.append("  AND etapa.PAIS_OID_PAIS = " + dto.getOidPais() );
      // vbongiov --30/12/2008
      if(dto.getOid()!= null) {
        stringBuffer.append("  AND mensaje.cod_lote = " + dto.getOid() );
      }
      stringBuffer.append("  AND fec_entr_mens is NULL ");

      //ejecutamos la consulta
      try {
          rsMensajes = belcorpService.dbService.executeStaticQuery(stringBuffer.toString());
      } catch (Exception exception) {
          codigoError = CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS;
          throw new MareException(exception,
              UtilidadesError.armarCodigoError(codigoError));
      }
      // -> retornar el DTOSalida con el recorset
      dtoSalida.setResultado(rsMensajes);
      
    UtilidadesLog.info("DAOSoporteCobranza.cargarMensajesLote(DTOOID dto): Salida");
      
      return dtoSalida;
  }


 /** 
  * Obtiene todos los mensages no enviados para un oiLote de un pais.
  * @param DTOOID
  * @return DTOSalida
  * @exception MareException 
  * @author gdmarzi
  * @referencia SICC-DMCO-COB-201-324-N036 y DMCO-Incidencia 13658
  */
  public DTOSalida cargarEtapaPais(DTOBelcorp dto) throws MareException {
    UtilidadesLog.info("DAOSoporteCobranza.cargarEtapaPais(DTOBelcorp dto): Entrada");
  
  /*
   * -> Crear un DTOSalida    
    ->Se encapsula el recordset en el DTOSalida y se retorna el mismo. 
   * 
   * */
      DTOSalida dtoSalida = new DTOSalida();
      BelcorpService belcorpService;
      RecordSet rsMensajes;
      String codigoError;
      try {
          belcorpService = BelcorpService.getInstance();
      } catch (MareMiiServiceNotFoundException serviceNotFoundException) {
          codigoError = CodigosError.ERROR_AL_PEDIR_UN_SERVICIO_MARE;
          throw new MareException(serviceNotFoundException,
              UtilidadesError.armarCodigoError(codigoError));
      }
      StringBuffer stringBuffer = new StringBuffer();
      
      stringBuffer.append(" SELECT etapa.oid_etap_deud OID, etapa.val_desc descripcion ");
      stringBuffer.append(" FROM cob_etapa_deuda etapa ");
      stringBuffer.append(" WHERE etapa.pais_oid_pais = " + dto.getOidPais());
      stringBuffer.append(" order by  descripcion ");
  

      //ejecutamos la consulta
      try {
          rsMensajes = belcorpService.dbService.executeStaticQuery(stringBuffer.toString());
      } catch (Exception exception) {
          codigoError = CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS;
          throw new MareException(exception,
              UtilidadesError.armarCodigoError(codigoError));
      }
      // -> retornar el DTOSalida con el recorset
      dtoSalida.setResultado(rsMensajes);
      
    UtilidadesLog.info("DAOSoporteCobranza.cargarEtapaPais(DTOBelcorp dto): Salida");
      
      return dtoSalida;
  }
  
  /** 
  * Obtiene todos los mensages no enviados para un oiLote de un pais.
  * @param DTOBuscarClientesAsignados
  * @return DTOSalida
  * @exception MareException 
  * @author mamontie
  * @referencia SICC-DMCO-COB-201-324-N036
  */
  public DTOSalida buscarClientesAsignados(DTOBuscarClientesAsignados  dto) throws MareException {
    UtilidadesLog.info("DAOSoporteCobranza.buscarClientesAsignados(DTOBuscarClientesAsignados  dto): Entrada");
  
        /*
         * ->Crear un DTOSalida 
          Se realizará una consulta JDBC teniendo en cuenta los siguiente criterios
           Se necesita recuperar: Codigo de cliente, nombre (de la forma descripta mas adelante),
           importe, oidCliente OID           
          Agrupar por Cliente y obtener la suma de la deuda Asignada 
          
          Retornar DTOSalida con el recordset encapsulado 
       */
      DTOSalida dtoSalida = new DTOSalida();
      RecordSet rsMensajes;
      String codigoError;
    
      StringBuffer query = new StringBuffer();
      Vector parametros = new Vector();

        query.append(" SELECT  ");        
        query.append(" cli.oid_clie OID,");
        query.append(" a.OID_ASIG_COBR OIDASIGNACOB, ");
        query.append(" cli.cod_clie AS CODIGOCLIENTE, ");
        query.append(" cli.val_ape1 ");
        query.append(" || ' ' ");
        query.append(" || cli.val_ape2 ");
        query.append(" || ' ' ");
        query.append(" || cli.val_nom1 ");
        query.append(" || ' ' ");
        query.append(" || cli.val_nom2 AS NOMBRECONSULTORA, ");
        query.append(" cro.usco_oid_usua_cobr OIDUSUCOBRA, ");        
        //query.append(" SUM (a.imp_deud_asig) IMPORTE ");     
        query.append(" SUM (nvl(a.imp_deud_asig,0) - nvl(a.IMP_DEUD_CANC,0) ) IMPORTE "); 
        query.append(" FROM cob_crono_cobra cro, ");
        query.append(" cob_asign_cobra a, ");
        query.append(" cob_etapa_deuda e, ");
        query.append(" seg_canal c, ");
        query.append(" seg_marca m, ");
        query.append(" cra_perio p, ");
        query.append(" zon_sub_geren_venta sv, ");
        query.append(" zon_sub_geren_venta subge, ");
        //------------- Zonificacion Cliente -------------
        query.append(" zon_regio regi, ");
        query.append(" zon_zona zon, ");
        query.append(" zon_secci sexy, ");
        query.append(" zon_terri tt, ");
        query.append(" zon_terri_admin ta, ");
        query.append(" mae_clien cli, ");
        //query.append(" mae_clien_tipo_subti ts, ");
        query.append(" CCC_MOVIM_CUENT_CORRI movicc, ");
        query.append(" mae_clien_unida_admin ua  ");  
        //------------- Filtros Zonificacion Cronograma -------------
        
        if (dto.getRegionDesde()!= null)
        {
            query.append(" ,zon_regio r, ");
            query.append(" zon_regio rd ");
            if (dto.getRegionHasta()!= null)
                query.append(" ,zon_regio rh ");
        }
        
        if (dto.getZonaDesde()!= null)
        {
            query.append(" ,zon_zona z, ");
            query.append(" zon_zona zd ");
            if (dto.getZonaHasta()!= null)
            query.append(" ,zon_zona zh ");
        }
        
        if (dto.getSeccionDesde()!= null)      
        {
            query.append(" ,zon_secci s, ");
            query.append(" zon_secci sd ");
            if (dto.getSeccionHasta()!= null)      
                query.append(" ,zon_secci sh ");
        }
        
        if (dto.getTerritorioDesde()!= null)      
        {
            query.append(" ,zon_terri t ");
        }
        
        query.append(" WHERE cro.pais_oid_pais = ? ");
        parametros.add(dto.getOidPais());
        query.append(" AND cro.oid_cron_cobr = a.crco_oid_cron_cobr ");
        query.append(" AND a.esas_oid_esta_asig = ? ");
        parametros.add(ConstantesCOB.OID_ESTA_ASIG_ABIERTA);
        
        query.append(" AND cro.etde_oid_etap_deud = e.oid_etap_deud ");
        query.append(" AND cro.perd_oid_peri = p.oid_peri ");
        query.append(" AND p.cana_oid_cana = c.oid_cana ");
        query.append(" AND p.marc_oid_marc = m.oid_marc ");
        //query.append(" AND a.ctsu_oid_clie_tipo_subt = ts.oid_clie_tipo_subt ");
        //query.append(" AND ts.clie_oid_clie = cli.oid_clie ");
        query.append(" AND a.MVCC_OID_MOVI_CC = movicc.OID_MOVI_CC ");
        query.append(" AND movicc.CLIE_OID_CLIE = cli.oid_clie  ");
        query.append(" AND cro.zsgv_oid_subg_vent = sv.oid_subg_vent ");
        query.append(" AND ua.clie_oid_clie = cli.oid_clie ");
        query.append(" AND ua.ztad_oid_terr_admi = ta.oid_terr_admi ");
        query.append(" AND ta.zscc_oid_secc = sexy.oid_secc ");
        query.append(" and ta.TERR_OID_TERR = tt.OID_TERR ");
        query.append(" AND sexy.zzon_oid_zona = zon.oid_zona ");
        query.append(" AND zon.zorg_oid_regi = regi.oid_regi ");
        query.append(" AND regi.zsgv_oid_subg_vent = subge.oid_subg_vent ");
        query.append(" AND subge.oid_subg_vent = sv.oid_subg_vent ");
        
        query.append(" and subge.ind_acti = " + ConstantesCMN.VAL_TRUE);
        query.append(" and regi.ind_borr = " + ConstantesCMN.VAL_FALSE);
        query.append(" and regi.ind_acti = " + ConstantesCMN.VAL_TRUE);
        query.append(" and zon.ind_borr = " + ConstantesCMN.VAL_FALSE);
        query.append(" and zon.ind_acti = " + ConstantesCMN.VAL_TRUE);
        query.append(" and sexy.ind_borr = " + ConstantesCMN.VAL_FALSE);
        query.append(" and sexy.ind_acti = " + ConstantesCMN.VAL_TRUE);
        query.append(" and ua.ind_acti = " + ConstantesCMN.VAL_TRUE);
        query.append(" and tt.ind_borr = " + ConstantesCMN.VAL_FALSE);
        
        //----------------- Filtros de pantalla Obligatorios ------------------
        if (dto.getEtapa()!= null)
        {
            query.append(" AND e.oid_etap_deud = ? ");
            parametros.add(dto.getEtapa());
        }

        if (dto.getMarca()!= null)
        {
            query.append(" AND m.oid_marc = ? ");
            parametros.add(dto.getMarca());
        }        
        
        if (dto.getCanal()!= null)
        {
            query.append(" AND c.oid_cana = ? ");
            parametros.add(dto.getCanal());
        }
        
        if (dto.getPeriodo()!= null)
        {
            query.append(" AND p.oid_peri = ? ");
            parametros.add(dto.getPeriodo());
        }
        
        if (dto.getSubgerenciaVentas()!= null)
        {
            query.append(" AND sv.oid_subg_vent = ? ");
            parametros.add(dto.getSubgerenciaVentas());
        }
     	//------------ Filtros de zonificacion de cronograma --------------      
      
        if (dto.getRegionDesde()!= null)
        {
            query.append(" AND r.zsgv_oid_subg_vent = cro.zsgv_oid_subg_vent ");
            query.append(" and r.ind_borr = " + ConstantesCMN.VAL_FALSE);
            query.append(" and r.ind_acti = " + ConstantesCMN.VAL_TRUE);            
            query.append(" AND cro.zorg_oid_regi = r.oid_regi ");
            query.append(" AND rd.oid_regi = ?  ");                     //oid region desde por parametro
            parametros.add(dto.getRegionDesde());
            if (dto.getRegionHasta()!= null)
            {
                query.append(" AND rh.oid_regi = ? ");                    //oid region hasta por parametro
                parametros.add(dto.getRegionHasta());
                query.append(" AND r.cod_regi BETWEEN rd.cod_regi AND rh.cod_regi ");
                query.append(" and regi.COD_REGI BETWEEN rd.cod_regi AND rh.cod_regi ");
            }
            else{
                query.append(" AND r.cod_regi >= rd.cod_regi  ");
                query.append(" and regi.COD_REGI >= rd.cod_regi ");
            }
        }
        
        if (dto.getZonaDesde()!= null){
            query.append(" AND z.zorg_oid_regi = r.oid_regi ");
            query.append(" and z.ind_borr = " + ConstantesCMN.VAL_FALSE);
            query.append(" and z.ind_acti = " + ConstantesCMN.VAL_TRUE);
            query.append(" AND cro.zzon_oid_zona = z.oid_zona ");
            query.append(" AND zd.oid_zona = ? ");                        //oid zona desde por parametro
            parametros.add(dto.getZonaDesde());
            if (dto.getZonaHasta()!= null)
            {
                query.append(" AND zh.oid_zona = ? ");                       //oid zona hasta por parametro
                parametros.add(dto.getZonaHasta());
                query.append(" AND z.cod_zona BETWEEN zd.cod_zona AND zh.cod_zona ");
                query.append(" AND zon.COD_ZONA BETWEEN zd.cod_zona AND zh.cod_zona ");
            }
            else{
                query.append(" AND z.cod_zona >= zd.cod_zona ");
                query.append(" AND zon.COD_ZONA >= zd.cod_zona ");
            }
        }
        
        if (dto.getSeccionDesde()!= null){
            query.append(" and s.ind_borr = " + ConstantesCMN.VAL_FALSE);
            query.append(" and s.ind_acti = " + ConstantesCMN.VAL_TRUE);
            query.append(" AND sd.oid_secc = ? ");                    //oid seccion desde por parametro
            parametros.add(dto.getSeccionDesde());
            query.append(" AND cro.zscc_oid_secc = s.oid_secc ");
            if (dto.getSeccionHasta()!= null)
            {
                query.append(" AND sh.oid_secc = ? ");                   //oid seccion hasta por parametro
                parametros.add(dto.getSeccionHasta());
                query.append(" AND s.cod_secc BETWEEN sd.cod_secc AND sh.cod_secc ");
                query.append(" and sexy.COD_SECC BETWEEN sd.cod_secc AND sh.cod_secc ");
            }
            else{
                query.append(" AND s.cod_secc >= sd.cod_secc ");
                query.append(" and sexy.COD_SECC >= sd.cod_secc ");
            }
        }
        
        if (dto.getTerritorioDesde()!= null  && !dto.getTerritorioDesde().equals("")){
            query.append(" and t.ind_borr = " + ConstantesCMN.VAL_FALSE);
            query.append(" AND cro.terr_oid_terr = t.oid_terr ");
            if ( dto.getTerritorioHasta()!= null && !dto.getTerritorioHasta().equals("") )
            {
                query.append(" and t.COD_TERR between ?  and ? "); //codigo de territorios desde y hasta por parametro
                parametros.add(dto.getTerritorioDesde());
                parametros.add(dto.getTerritorioHasta());
                query.append(" and tt.COD_TERR between ? and ? "); //codigo de territorios desde y hasta por parametro
                parametros.add(dto.getTerritorioDesde());
                parametros.add(dto.getTerritorioHasta());
            }
            else
            {
                query.append(" and t.COD_TERR = ? "); //codigo de territorios desde y hasta por parametro
                parametros.add(dto.getTerritorioDesde());
                query.append(" and tt.COD_TERR = ? "); //codigo de territorios desde y hasta por parametro
                parametros.add(dto.getTerritorioDesde());
            }
        }
        
      query.append(" GROUP BY ");
      query.append(" a.OID_ASIG_COBR, ");
      query.append(" cli.oid_clie, ");
      query.append(" cli.cod_clie, ");
      query.append(" cli.val_ape1 || ' ' || cli.val_ape2 || ' ' || cli.val_nom1 || ' ' || cli.val_nom2, ");
      query.append(" cro.usco_oid_usua_cobr");
      query.append(" ORDER BY cli.cod_clie ");
     
       //ejecutamos la consulta
      try {
          BelcorpService bs = UtilidadesEJB.getBelcorpService();
          
          UtilidadesLog.debug(" QUERY A EJECUTAR: " + query);
          UtilidadesLog.debug("Parametros: " + parametros);
          //rsMensajes = belcorpService.dbService.executeStaticQuery(query.toString(), parametros);
          rsMensajes = bs.dbService.executePreparedQuery(query.toString(), parametros);
      } catch (Exception exception) {
          codigoError = CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS;
          throw new MareException(exception,
              UtilidadesError.armarCodigoError(codigoError));
      }
      
      
      if (rsMensajes.esVacio()){
        throw new MareException(null, null,UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE));
      }  
 
        UtilidadesLog.debug("rs>>>> " + rsMensajes.toString());     
      // -> retornar el DTOSalida con el recorset
      dtoSalida.setResultado(rsMensajes);
      
        UtilidadesLog.info("DAOSoporteCobranza.buscarClientesAsignados(DTOBuscarClientesAsignados  dto): Salida");
      
      return dtoSalida;
  }
  
    /** 
    * Obtiene todos los mensages no enviados para un oiLote de un pais.
    * @param DTOOID
    * @return DTOSalida
    * @exception MareException 
    * @author mamontie
    * @referencia SICC-DMCO-COB-201-324-N036
    */
    public DTOSalida listadoMensajesEmitidos(DTOIdLote dto) throws MareException {
        UtilidadesLog.info("DAOSoporteCobranza.listadoMensajesEmitidos(DTOIdLote dto): Entrada");
    
    /*
      Se obtienen de la entidad "HistoricoMensajes" (COB_HISTO_MENSA) todos los mensajes 
      correspondientes al código de lote recibido por parámetro, recuperando los siguientes campos. 
      IdLote toma de histórico de mensajes 
      CodigoCliente se obtiene haciendo un join con la entidad "BuzonMensajes" y con la entidad "ClienteDatosBasicos" (MAE_CLIEN) 
      Nombre y Apellidos: idem punto anterior 
      Dirección: Se obtiene la dirección haciendo un join con la entiadad "ClienteDireccion" (MAE) 
      y con la entidad "TipoVia" (SEG) y con "Via" (ZON) obteniedo la direccion de la forma tipovia + " " + nombre via + " " +numeroPrincipal 
      Nota: el indicador de direccion principal debe ser true 
      Pais: se obtiene de SEG_PAIS internacionalizado 
      Provincia 
      Codigo Postal 
      Nº Mensaje generado de la entidad "BuzonMensajes" es el numero secuencial 
      Fecha de emision 
      ->retornar el recordset encapsulado en el "dtoSalida" 
      NOTA: Esta consulta es paginada 
     * */
     DTOSalida dtoSalida = new DTOSalida();
      BelcorpService belcorpService;
      RecordSet rsMensajes;
      String codigoError;
      try {
          belcorpService = BelcorpService.getInstance();
      } catch (MareMiiServiceNotFoundException serviceNotFoundException) {
          codigoError = CodigosError.ERROR_AL_PEDIR_UN_SERVICIO_MARE;
          throw new MareException(serviceNotFoundException,
              UtilidadesError.armarCodigoError(codigoError));
      }
      StringBuffer stringBuffer = new StringBuffer();
      /*stringBuffer.append(" SELECT histMensa.OID_HIST_MENS OID,  ");
      stringBuffer.append(" histMensa.COD_LOTE, ");
      stringBuffer.append(" cliente.COD_CLIE, ");
      stringBuffer.append(" CONCAT(cliente.VAL_NOM1,CONCAT(' ',CONCAT(cliente.VAL_NOM2,CONCAT(' ',CONCAT(cliente.VAL_APE1,CONCAT(' ',cliente.VAL_APE2)))))) NOMBRE, ");       
      stringBuffer.append(" CONCAT(valI18N.VAL_I18N,CONCAT(' ',CONCAT(via.NOM_VIA,CONCAT(' ',direccion.NUM_PPAL)))) DIRECCION, ");
      stringBuffer.append(" valI18N1.VAL_I18N PAIS, ");
      stringBuffer.append(" direccion.VAL_COD_POST CODIGOPOSTAL, ");      
      stringBuffer.append(" mensaje.NUM_SECU NUMEROMSJ, ");
      stringBuffer.append(" histMensa.FEC_EMIS_MENS FECHAEMI ");
      stringBuffer.append(" FROM COB_HISTO_MENSA histMensa, ");
      stringBuffer.append(" MSG_BUZON_MENSA mensaje, ");
      stringBuffer.append(" MAE_CLIEN cliente, ");
      stringBuffer.append(" MAE_CLIEN_DIREC direccion, ");
      stringBuffer.append(" ZON_VIA via, ");
      stringBuffer.append(" SEG_TIPO_VIA tipoVia, ");
      stringBuffer.append(" GEN_I18N_SICC_COMUN valI18N, ");
      stringBuffer.append(" GEN_I18N_SICC_COMUN valI18N1 ");
      stringBuffer.append(" WHERE histMensa.BUME_OID_BUZO_MENS = mensaje.OID_BUZO_MENS ");
      stringBuffer.append(" AND cliente.OID_CLIE = mensaje.CLIE_OID_CLIE ");
      stringBuffer.append(" AND direccion.CLIE_OID_CLIE = cliente.OID_CLIE ");
      stringBuffer.append(" AND direccion.ZVIA_OID_VIA = via.OID_VIA ");
      stringBuffer.append(" AND tipoVia.OID_TIPO_VIA = via.TIVI_OID_TIPO_VIA ");
      stringBuffer.append(" AND direccion.IND_DIRE_PPAL = 1 ");
      stringBuffer.append(" AND valI18N.attr_num_atri = 1 ");
      stringBuffer.append(" AND valI18N.idio_oid_idio = 1 ");
      stringBuffer.append(" AND valI18N.ATTR_ENTI = 'SEG_TIPO_VIA' ");
      stringBuffer.append(" AND valI18N.VAL_OID = tipoVia.OID_TIPO_VIA  ");
      stringBuffer.append(" AND valI18N1.attr_num_atri = 1 ");
      stringBuffer.append(" AND valI18N1.idio_oid_idio = " + dto.getOidIdioma());
      stringBuffer.append(" AND valI18N1.ATTR_ENTI = 'SEG_PAIS' ");
      stringBuffer.append(" AND valI18N1.VAL_OID = via.PAIS_OID_PAIS ");
      stringBuffer.append(" AND histMensa.COD_LOTE =  " + dto.getOidLote());*/
      
      /*
      // Modificado por ssantana, 7/10/2005, cambio MAE-GCC-005
      stringBuffer.append(" SELECT histmensa.oid_hist_mens OID, histmensa.cod_lote, cliente.cod_clie, ");
      stringBuffer.append(" cliente.val_nom1 ");
      stringBuffer.append(" || ' ' ");
      stringBuffer.append(" || cliente.val_nom2 ");
      stringBuffer.append(" || ' ' ");
      stringBuffer.append(" || cliente.val_ape1 ");
      stringBuffer.append(" || ' ' ");
      stringBuffer.append(" || cliente.val_ape2 nombre, ");
      stringBuffer.append(" vali18n.val_i18n ");
      stringBuffer.append(" || ' ' ");
      stringBuffer.append(" || via.nom_via ");
      stringBuffer.append(" || ' ' ");
      stringBuffer.append(" || direccion.num_ppal ");
      stringBuffer.append(" || ' ' ");
      stringBuffer.append(" || direccion.val_obse direccion, ");
      stringBuffer.append(" vali18n1.val_i18n pais, direccion.val_cod_post codigopostal, ");
      stringBuffer.append(" mensaje.num_secu numeromsj, histmensa.fec_emis_mens fechaemi ");
      stringBuffer.append(" FROM cob_histo_mensa histmensa, ");
      stringBuffer.append(" msg_buzon_mensa mensaje, ");
      stringBuffer.append(" mae_clien cliente, ");
      stringBuffer.append(" mae_clien_direc direccion, ");
      stringBuffer.append(" zon_via via, ");
      stringBuffer.append(" seg_tipo_via tipovia, ");
      stringBuffer.append(" gen_i18n_sicc_comun vali18n, ");
      stringBuffer.append(" gen_i18n_sicc_comun vali18n1 ");
      stringBuffer.append(" WHERE histmensa.bume_oid_buzo_mens = mensaje.oid_buzo_mens ");
      stringBuffer.append(" AND cliente.oid_clie = mensaje.clie_oid_clie ");
      stringBuffer.append(" AND direccion.clie_oid_clie = cliente.oid_clie ");
      stringBuffer.append(" AND direccion.zvia_oid_via = via.oid_via ");
      stringBuffer.append(" AND tipovia.oid_tipo_via = via.tivi_oid_tipo_via ");
      stringBuffer.append(" AND direccion.ind_dire_ppal = 1 ");
      stringBuffer.append(" AND vali18n.attr_num_atri = 1 ");
      stringBuffer.append(" AND vali18n.idio_oid_idio = " + dto.getOidIdioma());
      stringBuffer.append(" AND vali18n.attr_enti = 'SEG_TIPO_VIA' ");
      stringBuffer.append(" AND vali18n.val_oid = tipovia.oid_tipo_via ");
      stringBuffer.append(" AND vali18n1.attr_num_atri = 1 ");
      stringBuffer.append(" AND vali18n1.idio_oid_idio = " + dto.getOidIdioma());
      stringBuffer.append(" AND vali18n1.attr_enti = 'SEG_PAIS' ");
      stringBuffer.append(" AND vali18n1.val_oid = via.pais_oid_pais ");
      stringBuffer.append(" AND histmensa.cod_lote = " + dto.getOidLote());*/
      // Fin modificado por ssantana, 7/10/2005, cambio MAE-GCC-005
      
      // gPineda - C-COB-006 - Debe tenerse en cuenta los cliente que 
      //                       no tengan FK a zon_via en la direccion
      stringBuffer.append(" SELECT histmensa.oid_hist_mens OID, histmensa.cod_lote, cliente.cod_clie, ");
      stringBuffer.append("           cliente.val_nom1 ");
      stringBuffer.append("        || ' ' ");
      stringBuffer.append("        || cliente.val_nom2 ");
      stringBuffer.append("        || ' ' ");
      stringBuffer.append("        || cliente.val_ape1 ");
      stringBuffer.append("        || ' ' ");
      stringBuffer.append("        || cliente.val_ape2 nombre, ");
      stringBuffer.append("           via.valtipovia ");
      stringBuffer.append("        || ' ' ");
      stringBuffer.append("        || via.nom_via ");
      stringBuffer.append("        || ' ' ");
      stringBuffer.append("        || direccion.num_ppal ");
      stringBuffer.append("        || ' ' ");
      stringBuffer.append("        || direccion.val_obse direccion, ");
      stringBuffer.append("        via.valpais pais, direccion.val_cod_post codigopostal, ");
      stringBuffer.append("        mensaje.num_secu numeromsj, histmensa.fec_emis_mens fechaemi ");
      stringBuffer.append("   FROM cob_histo_mensa histmensa, ");
      stringBuffer.append("        msg_buzon_mensa mensaje, ");
      stringBuffer.append("        mae_clien cliente, ");
      stringBuffer.append("        mae_clien_direc direccion, ");
      stringBuffer.append("        (SELECT zvia.oid_via, zvia.nom_via, vali18n.val_i18n valtipovia, ");
      stringBuffer.append("                vali18n1.val_i18n valpais ");
      stringBuffer.append("           FROM zon_via zvia, ");
      stringBuffer.append("                gen_i18n_sicc_comun vali18n, ");
      stringBuffer.append("                gen_i18n_sicc_comun vali18n1 ");
      stringBuffer.append("          WHERE vali18n.attr_num_atri = 1 ");
      stringBuffer.append("            AND vali18n.idio_oid_idio = " + dto.getOidIdioma());
      stringBuffer.append("            AND vali18n.attr_enti = 'SEG_TIPO_VIA' ");
      stringBuffer.append("            AND vali18n.val_oid = zvia.tivi_oid_tipo_via ");
      stringBuffer.append("            AND vali18n1.attr_num_atri = 1 ");
      stringBuffer.append("            AND vali18n1.idio_oid_idio = " + dto.getOidIdioma());
      stringBuffer.append("            AND vali18n1.attr_enti = 'SEG_PAIS' ");
      stringBuffer.append("            AND vali18n1.val_oid = zvia.pais_oid_pais) via ");
      stringBuffer.append("  WHERE histmensa.bume_oid_buzo_mens = mensaje.oid_buzo_mens ");
      stringBuffer.append("    AND cliente.oid_clie = mensaje.clie_oid_clie ");
      stringBuffer.append("    AND direccion.clie_oid_clie = cliente.oid_clie ");
      stringBuffer.append("    AND direccion.zvia_oid_via = via.oid_via(+) ");
      stringBuffer.append("    AND direccion.ind_dire_ppal = 1 ");
      stringBuffer.append("    AND direccion.ind_elim = 0 "); //agregado por Sapaza, incidencia V_MAE_08
      stringBuffer.append("    AND histmensa.cod_lote = " + dto.getOidLote());
     
      UtilidadesLog.debug("Query: " + stringBuffer.toString());
       //ejecutamos la consulta
      try {
          rsMensajes = belcorpService.dbService.executeStaticQuery(stringBuffer.toString());
      } catch (Exception exception) {
          codigoError = CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS;
          throw new MareException(exception,
              UtilidadesError.armarCodigoError(codigoError));
      }
      if(rsMensajes.esVacio()){
           throw new MareException(new Exception(),
           UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE)); 
      }
      // -> retornar el DTOSalida con el recorset
        dtoSalida.setResultado(rsMensajes);
      
        UtilidadesLog.info("DAOSoporteCobranza.listadoMensajesEmitidos(DTOIdLote dto): Salida");
      
        return dtoSalida;
    }
    
    /*private void logSql(String metodo, String sql, Vector params)
    {
		UtilidadesLog.info(metodo + sql);
		if (params!=null && params.size()>0) {
			String sParams="";
			for (int i=0; i<params.size();i++){
				sParams+="param "+ (i+1) + ": " + params.elementAt(i) + ", ";
			}
			UtilidadesLog.info(metodo + sParams);
		}
    }*/
    
    
    
    /** 
    * Obtiene todos los mensages no enviados para un oiLote de un pais.
    * @param DTOBelcorp
    * @return DTOSalida
    * @exception MareException 
    * @author mamontie
    * @referencia SICC-DMCO-COB-Incidencia15274
    */
    public DTOSalida cargarEtapasPaisMensaje(DTOBelcorp dto) throws MareException {
        UtilidadesLog.info("DAOSoporteCobranza.cargarEtapasPaisMensaje(DTOBelcorp dto): Entrada");
    
      /*-> Crear un DTOSalida 
        -> hace la siguiente consulta JDBC en la entidad EtapasDeuda (COB_ETAPA_DEUDA) 
        SELECT etapa.oid_etap_deud OID, 
        etapa.val_desc descetapa 
        FROM cob_etapa_deuda etapa 
        WHERE etapa.pais_oid_pais = dto.get (pais) 
        and mens_oid_mens != null 
        
        ->Se encapsula el recordset en el DTOSalida y se retorna el mismo */
    
          DTOSalida dts = new DTOSalida();
          BelcorpService belcorpService;
          RecordSet rs;
          String codigoError;
          try {
              belcorpService = BelcorpService.getInstance();
          } catch (MareMiiServiceNotFoundException serviceNotFoundException) {
              codigoError = CodigosError.ERROR_AL_PEDIR_UN_SERVICIO_MARE;
              throw new MareException(serviceNotFoundException,
                  UtilidadesError.armarCodigoError(codigoError));
          }
          
          StringBuffer stringBuffer = new StringBuffer();
          stringBuffer.append(" SELECT etapa.oid_etap_deud OID,  ");
          stringBuffer.append(" etapa.val_desc descetapa ");
          stringBuffer.append(" FROM cob_etapa_deuda etapa ");
          stringBuffer.append(" where etapa.pais_oid_pais = " + dto.getOidPais());
          stringBuffer.append(" and mens_oid_mens is not null ");
          stringBuffer.append(" order by descetapa ");
          
          try {
              rs = belcorpService.dbService.executeStaticQuery(stringBuffer.toString());
          } catch (Exception exception) {
              codigoError = CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS;
              throw new MareException(exception,
                  UtilidadesError.armarCodigoError(codigoError));
          }
            dts.setResultado(rs);
          
            UtilidadesLog.info("DAOSoporteCobranza.cargarEtapasPaisMensaje(DTOBelcorp dto): Salida");
          
            return dts;
    }
}