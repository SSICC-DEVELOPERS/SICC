package es.indra.sicc.logicanegocio.cob;
import es.indra.mare.common.exception.MareException;
import es.indra.mare.common.mii.MareMiiServiceNotFoundException;
import es.indra.mare.common.mii.services.jdbcservice.RecordSet;
import es.indra.sicc.dtos.cob.DTOEBuscarCobranzaExterna;
import es.indra.sicc.dtos.cob.DTOEBuscarConsultorasTelecobranza;
import es.indra.sicc.dtos.cob.DTOEBuscarHistoricoCobranza;
import es.indra.sicc.util.BelcorpService;
import es.indra.sicc.util.CodigosError;
import es.indra.sicc.util.DTOBelcorp;
import es.indra.sicc.util.DTOSalida;
import es.indra.sicc.util.UtilidadesError;
import es.indra.sicc.util.UtilidadesLog;
import es.indra.sicc.util.UtilidadesPaginacion;
import java.text.SimpleDateFormat;
import javax.ejb.SessionContext;

public class DAOConsultasTelecobranzas  {
    private SessionContext session;
    
    public DAOConsultasTelecobranzas() {
    }
    
     public DAOConsultasTelecobranzas(SessionContext session){
        this.session = session;
    }
    
    private BelcorpService getBelcorpService() throws MareException{
        
        try {
            BelcorpService bs = BelcorpService.getInstance();
			return bs;
        } catch (MareMiiServiceNotFoundException e) {
            throw new MareException(e,
                UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_PEDIR_UN_SERVICIO_MARE));
        }		
		
	}
    
    public DTOSalida buscarConsultorasPorCPago(DTOEBuscarConsultorasTelecobranza dto) throws MareException{    
    
        UtilidadesLog.info("DAOConsultasTelecobranzas.buscarConsultorasPorCPago(DTOEBuscarConsultorasTelecobranza dto): Entrada");
    
        RecordSet respuesta;
        StringBuffer query = new StringBuffer();
		
        BelcorpService bs = getBelcorpService();

        UtilidadesLog.debug("este es el dto: " + dto);
        UtilidadesLog.debug("este es el pais: " + dto.getOidPais());
        UtilidadesLog.debug("este es el idioma: " + dto.getOidIdioma());

		try{
			query.append("  SELECT gestion.oid_gest_cobr OID, cliente.cod_clie,  ");
			query.append("         cliente.val_ape1 || ' ' || cliente.val_ape2 || ', ' || cliente.val_nom1,  ");
			query.append("         compromiso.fec_pago, compromiso.imp_pago, compromiso.fec_segu_prev,  ");
            // SE CAMBIO EL ORDEN DE LOS CAMPOS
            // pperez 03/05/2005
            query.append("         banco.cod_banc, sucursal.cod_sucu, compromiso.val_obse  ");
			//query.append("         sucursal.cod_sucu, banco.cod_banc, compromiso.val_obse  ");
			query.append("    FROM COB_COMPR_PAGO compromiso,  ");
			query.append("         COB_GESTI_COBRA gestion,  ");
			query.append("         MAE_CLIEN cliente,  ");
			query.append("         MAE_CLIEN_DATOS_ADICI datos_adici,  ");
			query.append("         CCC_BANCO banco,  ");
			query.append("         CCC_SUCUR sucursal  ");
			query.append("   WHERE compromiso.geco_oid_gest_cobr = gestion.oid_gest_cobr  ");
			query.append("     AND gestion.clie_oid_clie = cliente.oid_clie  ");
			query.append("     AND cliente.oid_clie = datos_adici.clie_oid_clie  ");
            //  Modificado por HRCS - fecha 10/04/2007 - Se modifico por incidencia Sicc20070179
			query.append("     AND compromiso.sucu_oid_sucu = sucursal.oid_sucu(+)  ");
			query.append("     AND sucursal.cban_oid_banc = banco.oid_banc(+)  ");
			query.append("     AND cliente.pais_oid_pais = " + dto.getOidPais());
            
            if (dto.getFechaPago() != null)  {
                SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
                String fechaPago = sdf.format(dto.getFechaPago());
                query.append("     AND compromiso.fec_pago = TO_DATE('" + fechaPago + "','dd/MM/yyyy')  ");
            }
            
            if (dto.getCodigoCliente() != null && !dto.getCodigoCliente().equals(""))  {
                query.append("     AND cliente.cod_clie = '" + dto.getCodigoCliente() + "'  ");
            }
            
            String sqlPaginado = UtilidadesPaginacion.armarQueryPaginacion(query.toString(),dto);
            
            UtilidadesLog.debug("Despued de armar la paginacion..");
            
			respuesta = bs.dbService.executeStaticQuery(sqlPaginado);
            
            UtilidadesLog.debug("ya ejecuto!!");
        } catch (Exception e) {
            UtilidadesLog.error(e);
            throw new MareException(e,
                UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS));
        }

          if( respuesta.esVacio() ){
              UtilidadesLog.debug("************** No hay registros, se lanza la MareException");
              throw new MareException(new Exception(),UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE));
          }     

        DTOSalida dtoSalida = new DTOSalida(respuesta);
        
        UtilidadesLog.info("DAOConsultasTelecobranzas.buscarConsultorasPorCPago(DTOEBuscarConsultorasTelecobranza dto): Salida");
        
		return dtoSalida;
    }
    
    public DTOSalida buscarConsultorasPorTAccion(DTOEBuscarConsultorasTelecobranza dto) throws MareException{
    
        UtilidadesLog.info("DAOConsultasTelecobranzas.buscarConsultorasPorTAccion(DTOEBuscarConsultorasTelecobranza dto): Entrada");
    
        RecordSet respuesta;
        StringBuffer query = new StringBuffer();
		
        BelcorpService bs = getBelcorpService();

		try{


            
            query.append("     SELECT gestion.oid_gest_cobr OID, tradu_tipo_cargo.val_i18n tipo_cargo,    ");
            query.append("            periodo.val_nomb_peri periodo, etapa.val_desc etapa, cliente.cod_clie,    ");
           
            // vconte Incidencia :DBLG500000569 -incluir nombre1 y nombre 2 del cliente -
             query.append("           cliente.VAL_NOM1 ||' '|| cliente.VAL_NOM2 nombre,  "); 

            query.append("            cliente.val_ape1   ");
            query.append("            || ' '   ");
            query.append("            || cliente.val_ape2 apellido,   ");
            //query.append("            || ', '    ");
            //query.append("            || cliente.val_nom1 nombre_cliente,    ");
            //query.append("            cliente.VAL_APE1 apellido,");
            query.append("            gestion.acco_oid_acci_cobr, accion.cod_acci_cobr cod_accion,    ");
            query.append("            accion.val_desc accion, subti_accio.cod_subt_acci, gestion.fec_segu,    ");
            query.append("            gestion.val_hora_segu, gestion.ind_comp_pago    ");
            query.append("       FROM COB_GESTI_COBRA gestion,    ");
            query.append("            CRA_PERIO periodo,    ");
            query.append("            CCC_TIPO_CARGO_ABONO tipo_cargo,    ");
            query.append("            MAE_CLIEN cliente,    ");
            query.append("            gen_i18n_sicc tradu_tipo_cargo,    ");
            query.append("            COB_ETAPA_DEUDA etapa,    ");
            query.append("            COB_ACCIO_COBRA accion,    ");
            query.append("   		     COB_ETAPA_DEUDA_TIPO_CARGO etapatcarg,  ");
            query.append("            cob_subti_accio subti_accio    ");
            query.append("      WHERE gestion.EDTC_OID_ETAP_DEUD_TIPO_CARG =  etapatcarg.OID_ETAP_DEUD_TIPO_CARG     ");
            query.append("        AND etapatcarg.ETDE_OID_ETAP_DEUD = etapa.OID_ETAP_DEUD  ");
            query.append("   	  AND etapatcarg.TCAB_OID_TIPO_CARG_ABON = tipo_cargo.OID_TIPO_CARG_ABON  ");
            query.append("   	  AND gestion.clie_oid_clie = cliente.oid_clie    ");
            query.append("        AND tipo_cargo.oid_tipo_carg_abon = tradu_tipo_cargo.val_oid    ");
            query.append("        AND gestion.perd_oid_peri = periodo.oid_peri    ");
            query.append("        AND gestion.etde_oid_etapa_deuda = etapa.oid_etap_deud    ");
            query.append("        AND accion.sacc_oid_subt_acci = subti_accio.oid_subt_acci    ");
            query.append("        AND gestion.acco_oid_acci_cobr = accion.oid_acci_cobr    ");
            query.append("        AND tradu_tipo_cargo.attr_enti = 'CCC_TIPO_CARGO_ABONO'    ");
            query.append("        AND tradu_tipo_cargo.attr_num_atri = 1    ");
			            

            if (dto.getCodigoCliente() != null && !dto.getCodigoCliente().equals(""))
                query.append("     AND cliente.cod_clie = '" + dto.getCodigoCliente() + "'  ");
			
            if (dto.getAccionCobranza() != null)
                query.append("     AND gestion.acco_oid_acci_cobr = " + dto.getAccionCobranza());        
            
            query.append("     AND cliente.pais_oid_pais =  " + dto.getOidPais());
            
            String sqlPaginado = UtilidadesPaginacion.armarQueryPaginacion(query.toString(),dto);
			respuesta = bs.dbService.executeStaticQuery(sqlPaginado);
            
        } catch (Exception e) {
            throw new MareException(e,
                UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS));
        }

          if( respuesta.esVacio() ){
              UtilidadesLog.debug("************** No hay registros, se lanza la MareException");
              throw new MareException(new Exception(),UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE));
          }     

        DTOSalida dtoSalida = new DTOSalida(respuesta);
        
        UtilidadesLog.info("DAOConsultasTelecobranzas.buscarConsultorasPorTAccion(DTOEBuscarConsultorasTelecobranza dto): Salida");
        
		return dtoSalida;
    }
    /**
     * 
     * @date 
     * @throws es.indra.mare.common.exception.MareException
     * @return 
     * @param dto
     * modificaciones: 29/08/06 - [1] pperanzola: se cambia para mejorar la performance
     */
    public DTOSalida buscarConsultorasPorGestionPago(DTOEBuscarConsultorasTelecobranza dto) throws MareException{
    
        UtilidadesLog.info("DAOConsultasTelecobranzas.buscarConsultorasPorGestionPago(DTOEBuscarConsultorasTelecobranza dto): Entrada");
    
        RecordSet respuesta;
        StringBuffer query = new StringBuffer();
		
        BelcorpService bs = getBelcorpService();

      try{
        /* ///*[1]
        query.append("  SELECT asig.OID_ASIG_COBR OID, princip.NAME usuariocobranza, eta.COD_ETAP_DEUD,  ");
        query.append("  PQ_APL_AUX.Valor_Gen_I18n_Sicc("+dto.getOidIdioma()+",crono.tcab_oid_tipo_carg_abon,'CCC_TIPO_CARGO_ABONO'), ");
        query.append("  marca.DES_MARC , ");
        query.append(" PQ_APL_AUX.Valor_Gen_I18n_Sicc("+dto.getOidIdioma()+",peri.cana_oid_cana,'SEG_CANAL'), ");
        query.append("  periCorpo.COD_PERI, subger.DES_SUBG_VENT, reg.DES_REGI, zon.DES_ZONA,  ");
        query.append("  sec.DES_SECCI, terr.COD_TERR, cli.COD_CLIE,  ");
        query.append("  cli.VAL_NOM1 ||' '|| cli.VAL_NOM2 nombre, cli.VAL_APE1 ||' '|| cli.VAL_APE2 apellido,  ");
        query.append("  PQ_APL_AUX.Valor_Gen_I18n_Sicc("+dto.getOidIdioma()+",asig.esas_oid_esta_asig,'COB_ESTAD_ASIGN'), ");
        query.append(" asig.IMP_DEUD_ASIG,  crono.VAL_OBSE  ");        
        query.append("  FROM   COB_ASIGN_COBRA asig, COB_CRONO_COBRA crono,  ");
        query.append("  principals princip, users users, cob_usuar_cobra usuCob, ");
        query.append("  cob_etapa_deuda eta, "); 
        query.append("  seg_marca marca,  ");
        query.append("  seg_perio_corpo periCorpo, cra_perio peri,  ");
        query.append("  ZON_SUB_GEREN_VENTA subger, ZON_REGIO reg,ZON_ZONA zon,  ");
        query.append("  ZON_SECCI sec, ZON_TERRI terr, ZON_TERRI_ADMIN terrAdm,  ");
        query.append("  CCC_MOVIM_CUENT_CORRI ccc, MAE_CLIEN cli  ");        
        query.append("  WHERE  crono.OID_CRON_COBR = asig.CRCO_OID_CRON_COBR  ");
        query.append("  AND asig.PAIS_OID_PAIS = " + dto.getOidPais());
        query.append("  AND crono.USCO_OID_USUA_COBR = usuCob.OID_USUA_COBR ");
        query.append("  AND usuCob.USER_OID_USUA_COBR = users.IDUSER ");
        query.append("  AND users.IDUSER = princip.IDPRINCIPAL  ");
        query.append("  AND princip.NAME = '" + session.getCallerPrincipal().getName() + "' ");
        query.append("  AND crono.ETDE_OID_ETAP_DEUD = eta.OID_ETAP_DEUD  ");        
        query.append("  AND crono.PERD_OID_PERI = peri.OID_PERI ");
        query.append("  AND peri.PERI_OID_PERI = periCorpo.OID_PERI  ");
        query.append("  AND peri.MARC_OID_MARC = marca.OID_MARC  ");
        query.append("  AND crono.ZSGV_OID_SUBG_VENT = subger.OID_SUBG_VENT  ");
        query.append("  AND crono.ZZON_OID_ZONA = zon.OID_ZONA(+)  ");
        query.append("  AND crono.ZORG_OID_REGI = reg.OID_REGI(+)  ");
        query.append("  AND crono.ZSCC_OID_SECC = terrAdm.ZSCC_OID_SECC (+)  ");
        query.append("  AND terrAdm.TERR_OID_TERR (+) = crono.TERR_OID_TERR  ");
        query.append("  AND terrAdm.ZSCC_OID_SECC = sec.OID_SECC  ");
        query.append("  AND terrAdm.TERR_OID_TERR = terr.OID_TERR ");
        query.append("  AND asig.MVCC_OID_MOVI_CC = ccc.OID_MOVI_CC ");
        query.append("  AND ccc.CLIE_OID_CLIE = cli.OID_CLIE  ");      
        
        if(dto.getCodigoCliente()!=null){
          query.append("  AND cli.COD_CLIE ='" + dto.getCodigoCliente() + "' ");             
        }
        
        if(dto.getEstadoAsignacion()!=null){
          query.append("  AND asig.ESAS_OID_ESTA_ASIG = " + dto.getEstadoAsignacion());             
        }
        */
        
        
        query.append(" SELECT   asig.oid_asig_cobr OID, princip.NAME usuariocobranza,  ");
        query.append("   eta.cod_etap_deud,  ");
        query.append("   Pq_Apl_Aux.valor_gen_i18n_sicc ("+dto.getOidIdioma()+", crono.tcab_oid_tipo_carg_abon, 'CCC_TIPO_CARGO_ABONO' ), ");
        query.append("   marca.des_marc, ");
        query.append("   Pq_Apl_Aux.valor_gen_i18n_sicc ("+dto.getOidIdioma()+", peri.cana_oid_cana, 'SEG_CANAL'), ");
        query.append("   pericorpo.cod_peri, subger.des_subg_vent, ");
        query.append("   (SELECT reg.des_regi   FROM ZON_REGIO reg    WHERE crono.zorg_oid_regi = reg.oid_regi) des_regi, ");
        query.append("   (SELECT des_zona FROM ZON_ZONA WHERE oid_zona = crono.zzon_oid_zona) des_zona, ");
        query.append("   (SELECT sec.des_secci  FROM ZON_SECCI sec WHERE crono.zscc_oid_secc = sec.oid_secc) des_secci, ");
        query.append("   (SELECT terr.cod_terr FROM ZON_TERRI terr WHERE crono.terr_oid_terr = terr.oid_terr) cod_terr, ");
        query.append("   cli.cod_clie, ");
        query.append("   cli.val_nom1 || ' ' || cli.val_nom2 nombre, ");
        query.append("   cli.val_ape1 || ' ' || cli.val_ape2 apellido, ");
        query.append("   Pq_Apl_Aux.valor_gen_i18n_sicc ("+dto.getOidIdioma()+", asig.esas_oid_esta_asig, 'COB_ESTAD_ASIGN' ), ");
        query.append("   asig.imp_deud_asig, crono.val_obse ");
        query.append(" FROM COB_ASIGN_COBRA asig,  ");
        query.append("   COB_CRONO_COBRA crono, ");
        query.append("   principals princip, ");
        query.append("   users users, ");
        query.append("   COB_USUAR_COBRA usucob, ");
        query.append("   COB_ETAPA_DEUDA eta, ");
        query.append("   seg_marca marca, ");
        query.append("   seg_perio_corpo pericorpo, ");
        query.append("   CRA_PERIO peri, ");
        query.append("   ZON_SUB_GEREN_VENTA subger, ");
        query.append("   CCC_MOVIM_CUENT_CORRI ccc, ");
        query.append("   MAE_CLIEN cli ");
        query.append(" WHERE crono.oid_cron_cobr = asig.crco_oid_cron_cobr ");
        query.append("   AND asig.pais_oid_pais = " + dto.getOidPais());
        
         if(dto.getCodigoCliente()!=null){
          query.append("  AND cli.COD_CLIE ='" + dto.getCodigoCliente() + "' ");             
        }
        query.append("   AND crono.usco_oid_usua_cobr = usucob.oid_usua_cobr ");
        query.append("   AND crono.etde_oid_etap_deud = eta.oid_etap_deud ");
        query.append("   AND crono.perd_oid_peri = peri.oid_peri ");
        query.append("   AND crono.zsgv_oid_subg_vent = subger.oid_subg_vent ");
        query.append("   AND usucob.user_oid_usua_cobr = users.iduser ");
        query.append("   AND users.iduser = princip.idprincipal ");
        query.append("   AND princip.NAME = '" + session.getCallerPrincipal().getName() + "' ");
        query.append("   AND peri.peri_oid_peri = pericorpo.oid_peri ");
        query.append("   AND peri.marc_oid_marc = marca.oid_marc ");
        query.append("   AND asig.mvcc_oid_movi_cc = ccc.oid_movi_cc ");
        query.append("   AND ccc.clie_oid_clie = cli.oid_clie ");
        if(dto.getEstadoAsignacion()!=null){
          query.append("  AND asig.ESAS_OID_ESTA_ASIG = " + dto.getEstadoAsignacion());             
        }
        query.append(" ORDER BY OID ");
        //  [1] */      
        
        String sqlPaginado = UtilidadesPaginacion.armarQueryPaginacion(query.toString(),dto);
        respuesta = bs.dbService.executeStaticQuery(sqlPaginado);
            
      } catch (Exception e) {
          throw new MareException(e,
              UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS));
      }
      
      if( respuesta.esVacio() ){
          UtilidadesLog.debug("************** No hay registros, se lanza la MareException");
          throw new MareException(new Exception(),UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE));
      }     

      DTOSalida dtoSalida = new DTOSalida(respuesta);
      
        UtilidadesLog.info("DAOConsultasTelecobranzas.buscarConsultorasPorGestionPago(DTOEBuscarConsultorasTelecobranza dto): Salida");
      
      return dtoSalida;
    }
    public DTOSalida obtenerEstadosAsignacion(DTOBelcorp dto)  throws MareException{
    
        UtilidadesLog.info("DAOConsultasTelecobranzas.obtenerEstadosAsignacion(DTOBelcorp dto): Entrada");
    
        /* DAOConsultasTelecobranzas.obtenerEstadosAsignacion(dto : DTOBelcorp) : DTOSalida */ 
        /*Entrada: 
        - dto : DTOBelcorp 
        Proceso: 
        -> Hacer consulta JDBC sobre la tabla COB_ESTAD_ASIGN para 
            obtener los campos OID_ESTA_ASIG y VAL_DESC 
        -> Devolver RecordSet obtenido encapsulado en un DTOSalida */
        RecordSet respuesta;
        StringBuffer query = new StringBuffer();
		
        BelcorpService bs = getBelcorpService();

		try{

			query.append("  SELECT oid_esta_asig, v.val_i18n  ");
			query.append("    FROM cob_estad_asign cest, v_gen_i18n_sicc v  ");
			query.append("   WHERE v.attr_enti = 'COB_ESTAD_ASIGN'  ");
			query.append("     AND cest.oid_esta_asig = v.val_oid  ");
			query.append("     AND v.attr_num_atri = 1  ");
			query.append("     AND v.idio_oid_idio = " +  dto.getOidIdioma());
            query.append("     ORDER BY v.val_i18n");

			respuesta = bs.dbService.executeStaticQuery(query.toString());
            
        } catch (Exception e) {
            throw new MareException(e,
                UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS));
        }

        DTOSalida dtoSalida = new DTOSalida(respuesta);
        
        UtilidadesLog.info("DAOConsultasTelecobranzas.obtenerEstadosAsignacion(DTOBelcorp dto): Salida");
        
		return dtoSalida;

    }
    public DTOSalida buscarHistoricoCobranza(DTOEBuscarHistoricoCobranza dto)  throws MareException{

        UtilidadesLog.info("DAOConsultasTelecobranzas.buscarHistoricoCobranza(DTOEBuscarHistoricoCobranza dto): Entrada");

        RecordSet respuesta;
        StringBuffer query = new StringBuffer();
		
        BelcorpService bs = getBelcorpService();

		try{

			query.append("        select gestion.OID_GEST_COBR OID,  soci.VAL_DENO,  p.name, etapa.COD_ETAP_DEUD, segp.COD_PERI, maec.COD_CLIE,  ");
			query.append("               accion.COD_ACCI_COBR,     ");
			query.append("               gestion.fec_segu, gestion.val_hora_segu    ");
			query.append("          from cob_gesti_cobra gestion, cob_usuar_cobra usucob, principals p,     ");
			query.append("               COB_ETAPA_DEUDA etapa, SEG_PERIO_CORPO segp, MAE_CLIEN maec,     ");
			query.append("               COB_ACCIO_COBRA accion, CRA_PERIO, seg_socie soci    ");
			query.append("         where gestion.USCO_OID_USUA_COBR = usucob.OID_USUA_COBR    ");
			query.append("           and p.idprincipal = usucob.user_oid_usua_cobr    ");
			query.append("           and gestion.ETDE_OID_ETAPA_DEUDA = etapa.OID_ETAP_DEUD    ");
			query.append("           and cra_perio.PERI_OID_PERI  = segp.OID_PERI    ");
			query.append("           and gestion.CLIE_OID_CLIE = maec.OID_CLIE    ");
			query.append("           and gestion.ACCO_OID_ACCI_COBR = accion.OID_ACCI_COBR    ");
			query.append("           and  gestion.PERD_OID_PERI = CRA_PERIO.OID_PERI    ");
            query.append("           and gestion.SOCI_OID_SOCI = soci.OID_SOCI (+) ");
            query.append("           and CRA_PERIO.PAIS_OID_PAIS = " + dto.getOidPais());
            
            if (dto.getCodigoCliente() != null && !dto.getCodigoCliente().equals(""))
                query.append("           and  maec.COD_CLIE = '" + dto.getCodigoCliente() + "'    ");        
            
            if (dto.getPeriodo() != null)
                query.append("           and  gestion.PERD_OID_PERI = " + dto.getPeriodo());
            
            if (dto.getMarca() != null)
    			query.append("           and CRA_PERIO.MARC_OID_MARC = " + dto.getMarca());

            if (dto.getCanal() != null)
                query.append("           and CRA_PERIO.CANA_OID_CANA = " + dto.getCanal());
            
            String sqlPaginado = UtilidadesPaginacion.armarQueryPaginacion(query.toString(),dto);
			respuesta = bs.dbService.executeStaticQuery(sqlPaginado);
            
        } catch (Exception e) {
            UtilidadesLog.error(e);
            throw new MareException(e,
                UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS));
        }

        if( respuesta.esVacio() ){
            UtilidadesLog.debug("************** No hay registros, se lanza la MareException");
            throw new MareException(new Exception(),UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE));
        }     
        
        DTOSalida dtoSalida = new DTOSalida(respuesta);
        
        UtilidadesLog.info("DAOConsultasTelecobranzas.buscarHistoricoCobranza(DTOEBuscarHistoricoCobranza dto): Salida");
        
		return dtoSalida;
    }
    public DTOSalida buscarCobranzaExterna(DTOEBuscarCobranzaExterna dto) throws MareException {
        
        
        UtilidadesLog.info("DAOConsultasTelecobranzas.buscarCobranzaExterna(DTOEBuscarCobranzaExterna dto): Entrada");
    
        RecordSet respuesta;
        StringBuffer query = new StringBuffer();
		
        BelcorpService bs = getBelcorpService();

		try{

			query.append("   SELECT gestion.OID_GEST_COBR OID, segs.VAL_DENO, p.NAME, etapad.COD_ETAP_DEUD, segp.cod_peri, v.val_i18n, maec.cod_clie,   ");
			query.append("          maec.val_nom1 || ' ' || maec.val_nom2,   ");
			query.append("          maec.val_ape1 || ' ' || maec.val_ape2, accion.cod_acci_cobr,   ");
			query.append("          gestion.fec_segu, gestion.val_hora_segu   ");
			query.append("     FROM principals p,   ");
			query.append("          COB_ETAPA_DEUDA etapad,   ");
			query.append("          seg_perio_corpo segp,   ");
			query.append("          MAE_CLIEN maec,   ");
			query.append("          v_gen_i18n_sicc v,   ");
			query.append("          CCC_TIPO_CARGO_ABONO tipocargo2,   ");
			query.append("          COB_ETAPA_DEUDA_TIPO_CARGO tipocargo,   ");      
			query.append("          COB_ACCIO_COBRA accion,   ");
			query.append("          COB_GESTI_COBRA gestion,   ");
			query.append("   	    COB_USUAR_COBRA usuacobr,   ");
			//query.append("   	    COB_HISTO_ASIGN_COBRA hasign,   ");
			if (dto.getGrupoUsuarioCobranza() != null ){
              query.append("   	    cob_grupo_usuar_cobra grupo,   ");
			  query.append("   	    cob_usuar_grupo_usuar usuargrupo,   ");
			}
            query.append("   	    SEG_SOCIE segs,   ");
			query.append("   	    cra_perio crap   ");
			query.append("    WHERE gestion.etde_oid_etapa_deuda = etapad.oid_etap_deud   ");
			query.append("      AND crap.peri_oid_peri = segp.oid_peri   ");
			query.append("      AND crap.oid_peri = gestion.perd_oid_peri    ");
            query.append("      AND gestion.edtc_oid_etap_deud_tipo_carg = tipocargo.OID_ETAP_DEUD_TIPO_CARG   ");
            query.append("      and tipocargo2.OID_TIPO_CARG_ABON = tipocargo.tcab_oid_tipo_carg_abon   ");      
			query.append("      AND gestion.clie_oid_clie = maec.oid_clie   ");
			query.append("      AND gestion.acco_oid_acci_cobr = accion.oid_acci_cobr   ");
			query.append("      AND gestion.USCO_OID_USUA_COBR = usuacobr.OID_USUA_COBR   ");
			query.append("      AND p.IDPRINCIPAL = usuacobr.USER_OID_USUA_COBR   ");
			query.append("      AND tipocargo.TCAB_OID_TIPO_CARG_ABON = v.val_oid   ");
			query.append("      AND v.attr_enti = 'CCC_TIPO_CARGO_ABONO'   ");
			query.append("      AND v.attr_num_atri = 1   ");
			query.append("      AND v.idio_oid_idio =  " + dto.getOidIdioma());

			//query.append("      AND gestion.USCO_OID_USUA_COBR = hasign.USCO_OID_USUA_COBR   ");
			//query.append("      AND segs.OID_SOCI = hasign.SOCI_OID_SOCI   ");
			query.append("      and gestion.SOCI_OID_SOCI = segs.OID_SOCI   ");
			query.append("      and gestion.USCO_OID_USUA_COBR = usuacobr.OID_USUA_COBR   ");
            if (dto.getGrupoUsuarioCobranza() != null ){
			  query.append("      AND grupo.oid_grup_usua_cobr = usuargrupo.guco_oid_grup_usua_cobr  ");
			  query.append("      AND usuargrupo.usco_oid_usua_cobr = usuacobr.oid_usua_cobr  ");
            }
            
            query.append("      AND crap.pais_oid_pais = " + dto.getOidPais());

			if (dto.getCodigoCliente() != null && !dto.getCodigoCliente().equals(""))
                query.append("      AND maec.cod_clie = '" + dto.getCodigoCliente() + "'  ");

			if (dto.getUsuarioCobranza() != null)
                query.append("      AND gestion.usco_oid_usua_cobr = " + dto.getUsuarioCobranza());

            if (dto.getGrupoUsuarioCobranza() != null )
                query.append("      AND grupo.oid_grup_usua_cobr =  " + dto.getGrupoUsuarioCobranza());
			
            if (dto.getEtapasDeuda() != null) 
                query.append("      AND gestion.etde_oid_etapa_deuda IN (" + dto.getEtapasDeuda() + ")  ");
			
            if (dto.getTipoCargo() != null){
                query.append(" AND gestion.edtc_oid_etap_deud_tipo_carg IN (  ");
                query.append(" select OID_ETAP_DEUD_TIPO_CARG ");
                query.append(" from COB_ETAPA_DEUDA_TIPO_CARGO tipocargo2 ");
                query.append(" where tipocargo2.TCAB_OID_TIPO_CARG_ABON = " + dto.getTipoCargo());
                query.append(" AND tipocargo2.ETDE_OID_ETAP_DEUD IN  (" + dto.getEtapasDeuda() + "))  ");
            }
            
            if (dto.getPeriodo() != null)
                query.append("      AND gestion.perd_oid_peri =  " + dto.getPeriodo());
            
            if (dto.getMarca() != null)
                query.append("      AND crap.marc_oid_marc =  " + dto.getMarca());
            
            if (dto.getCanal() != null)
                query.append("      AND crap.cana_oid_cana = " + dto.getCanal());

            String sqlPaginado = UtilidadesPaginacion.armarQueryPaginacion(query.toString(),dto);
			respuesta = bs.dbService.executeStaticQuery(sqlPaginado);
            
        } catch (Exception e) {
            throw new MareException(e,
                UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS));
        }

        if( respuesta.esVacio() ){
            UtilidadesLog.debug("************** No hay registros, se lanza la MareException");
            throw new MareException(new Exception(),UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE));
        }     

        DTOSalida dtoSalida = new DTOSalida(respuesta);
        
        UtilidadesLog.info("DAOConsultasTelecobranzas.buscarCobranzaExterna(DTOEBuscarCobranzaExterna dto): Salida");
        
		return dtoSalida;
    }
}