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
import es.indra.mare.common.exception.MareException;
import es.indra.mare.common.mii.MareMiiServiceNotFoundException;
import es.indra.mare.common.mii.services.jdbcservice.RecordSet;
import es.indra.sicc.dtos.cob.DTOConsultarLiquidacionComisionesCobranza;
import es.indra.sicc.util.BelcorpService;
import es.indra.sicc.util.CodigosError;
import es.indra.sicc.util.DTOSalida;
import es.indra.sicc.util.UtilidadesError;
import es.indra.sicc.util.UtilidadesLog;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import javax.ejb.SessionContext;
/**
 * 
 * @date 17/03/2005
 * @author pperanzola
 */
public class DAOLiquidacionCobranza  {
    SessionContext ctx = null;
    public DAOLiquidacionCobranza() {
    }
    
    public DAOLiquidacionCobranza(SessionContext ctx)
    {
      this.ctx= ctx;
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
   /**
   * @author pperanzola
   * @date 17/03/2005
   * @throws es.indra.mare.common.exception.MareException
   * @return 
   * @param dtoEntrada
   * 
   */
    public DTOSalida listadoLiquidaciones(DTOConsultarLiquidacionComisionesCobranza dtoEntrada) throws MareException{
    
        UtilidadesLog.info("DAOLiquidacionCobranza.listadoLiquidaciones(DTOConsultarLiquidacionComisionesCobranza dtoEntrada): Entrada");
    
        RecordSet respuesta;
        RecordSet rs;
        StringBuffer query = new StringBuffer();
        String usuario = ctx.getCallerPrincipal().getName();
        BelcorpService bs = getBelcorpService();
        Long usrIndJefeCobr;
        Long usrIndSupervCobr;
        
        Long oidUsuaCobr;
        Long subQryOidUsuaCobr;
        //Agregados por Hugo Mansi
        //21/12/2005
        
        Long subQryOidUsuaSuperPR=new Long("0");
        Long subQryOidUsuaCobrPR;
        //fin agregados
        
     
    /* Este query es para averiguar el oid del usuario registrado y saber si es jefe de cobranza o no.
     * */
		try{
      query.append("   SELECT cuc.oid_usua_cobr, ");
      query.append("   cuc.IND_JEFE_COBR, ");
      query.append("   cuc.IND_USUA_SUPE, "); 
      query.append("   cuc.USER_OID_USUA_COBR, ");  
	  query.append("   cuc.USER_OID_USUA_RESP, ");
      query.append("   cuc.USER_OID_USUA_SUPE ");
      query.append("   FROM cob_usuar_cobra cuc, principals pr " );
      query.append("   WHERE cuc.user_oid_usua_cobr = pr.idprincipal  " );
      query.append("   AND pr.NAME = '"+ usuario +"' " );

      rs = bs.dbService.executeStaticQuery(query.toString());    
      
      if (rs.esVacio()) {
        UtilidadesLog.info("No es usuario de cobranzas");
        throw new MareException(new Exception(),UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE));
      }
      
      //subQryOidUsuaCobr = new Long( ((BigDecimal) rs.getValueAt(0,"oid_usua_cobr")).longValue());
      usrIndJefeCobr = new Long( ((BigDecimal) rs.getValueAt(0,"IND_JEFE_COBR")).longValue()); 
     
     //Agregado por Hugo Mansi
      //21/12/2005
     //recupero los oid de usuarios segón principals
      //subQryOidUsuaJefePR = new Long( ((BigDecimal) rs.getValueAt(0,"USER_OID_USUA_RESP")).longValue());
      if(rs.getValueAt(0,"USER_OID_USUA_SUPE")!=null){
        subQryOidUsuaSuperPR = new Long( rs.getValueAt(0,"USER_OID_USUA_SUPE").toString());     
      }
      subQryOidUsuaCobrPR = new Long(rs.getValueAt(0,"USER_OID_USUA_COBR").toString()); 
      usrIndSupervCobr = new Long(rs.getValueAt(0,"IND_USUA_SUPE").toString()); 
     //fin agregado 
      
      oidUsuaCobr = dtoEntrada.getUsuarioCobranza();
      query =  null;
      query = new StringBuffer(); 
        
        //se hizo la query nuevamente, ya que la anterior era cualquier cosa
        //y jamas traia nada.
        query.append(" SELECT rownum OID, rs.* from (SELECT '' sociedad, prn.NAME usuariocobranza, ");
		query.append(" etap.val_desc etapa, cperio.val_nomb_peri periodo, ");
		query.append(" pq_apl_aux.valor_gen_i18n_sicc(").append(dtoEntrada.getOidIdioma().toString()).
                append(", crono.tcab_oid_tipo_carg_abon,'CCC_TIPO_CARGO_ABONO') tipocargo, ");
		query.append(" subger.des_subg_vent subgerenciaventas, regio.des_regi region, ");
		query.append(" zon.des_zona zona, sexi.des_secci seccion, ");
		query.append(" terri.cod_terr territorio, smarc.des_marc marca, ");
		query.append(" pq_apl_aux.valor_gen_i18n_sicc (").append(dtoEntrada.getOidIdioma().toString()).
                append(", cana.oid_cana, 'SEG_CANAL') canal, ");
		query.append(" '' codigoCliente, com.imp_deud_asig importedeudaasig, ");
		query.append(" crono.fec_asig fechaasig, com.imp_deud_recu importedeudarec, ");
		query.append(" com.imp_comi_calc importecomisioncalc ");
        query.append(" FROM cob_histo_comis_cobra com, cob_usuar_cobra cus, ");
        query.append(" users usr, principals prn, ");
        query.append(" cob_etapa_deuda etap,  cra_perio cperio, ");
        query.append(" (SELECT   MAX (cac.oid_asig_cobr), cac.hicc_oid_hist_comi_cobr, ");
        query.append(" cac.crco_oid_cron_cobr FROM cob_asign_cobra cac ");
        query.append(" GROUP BY cac.hicc_oid_hist_comi_cobr, cac.crco_oid_cron_cobr ");
        query.append(" HAVING cac.hicc_oid_hist_comi_cobr IS NOT NULL) asign,  cob_crono_cobra crono, ");
        query.append(" zon_regio regio,    zon_zona zon,     zon_sub_geren_venta subger, zon_secci sexi, ");
        query.append(" zon_terri terri,  seg_marca smarc,  seg_canal cana ");
        query.append(" WHERE com.usco_oid_usua_cobr = cus.oid_usua_cobr ");
        query.append(" AND cus.user_oid_usua_cobr = usr.iduser ");
        query.append(" AND usr.iduser = prn.idprincipal ");
        query.append(" AND com.etde_oid_etap_deud = etap.oid_etap_deud ");
        query.append(" AND com.perd_oid_peri = cperio.oid_peri ");
        query.append(" AND cperio.marc_oid_marc = smarc.oid_marc ");
        query.append(" AND cperio.cana_oid_cana = cana.oid_cana ");
        query.append(" AND com.oid_hist_comi_cobr = asign.hicc_oid_hist_comi_cobr ");
        query.append(" AND asign.crco_oid_cron_cobr = crono.oid_cron_cobr ");
        query.append(" AND crono.zorg_oid_regi = regio.oid_regi(+) ");
        query.append(" AND crono.zzon_oid_zona = zon.oid_zona(+) ");
        query.append(" AND crono.zsgv_oid_subg_vent = subger.oid_subg_vent(+) ");
        query.append(" AND crono.zscc_oid_secc = sexi.oid_secc(+) ");
        query.append(" AND crono.terr_oid_terr = terri.oid_terr(+) ");
        if (dtoEntrada.getUsuarioCobranza()!=null) {
            query.append(" AND com.usco_oid_usua_cobr = ").append(dtoEntrada.getUsuarioCobranza());
        }else{
            if (usrIndJefeCobr.equals(new Long(1))){
               
            }else if (usrIndSupervCobr.equals(new Long(1))){
              query.append("  AND cus.USER_OID_USUA_SUPE  = " + subQryOidUsuaSuperPR);   
            }else {
                   query.append("  AND cus.USER_OID_USUA_COBR  = " + subQryOidUsuaCobrPR);
            }
        }
        if (dtoEntrada.getEtapa()!=null){
            query.append(" AND etap.oid_etap_deud = ").append(dtoEntrada.getEtapa());
        }
        if(dtoEntrada.getPeriodo()!=null){
            query.append(" AND com.perd_oid_peri = ").append(dtoEntrada.getPeriodo());
        }
        if(dtoEntrada.getOidPais()!=null){
            query.append(" AND cus.pais_oid_pais = ").append(dtoEntrada.getOidPais());
        }
        if(dtoEntrada.getMarca()!=null){
            query.append(" and cperio.MARC_OID_MARC = ").append(dtoEntrada.getMarca());
        }
        if(dtoEntrada.getCanal()!=null){
            query.append(" AND cperio.CANA_OID_CANA = ").append(dtoEntrada.getCanal());    
        }
        if(dtoEntrada.getFechaAsignacion()!=null){
          SimpleDateFormat sdf = new SimpleDateFormat ("dd-MM-yyyy");
          query.append(" AND crono.fec_asig = to_date('" + sdf.format(dtoEntrada.getFechaAsignacion())+ "','DD-MM-YYYY')");
        }
        query.append(" ORDER BY prn.NAME,cperio.val_nomb_peri, ");
        query.append(" etap.val_desc , subger.des_subg_vent, ");
        query.append(" regio.des_regi, zon.des_zona, sexi.des_secci, ");
		query.append(" terri.cod_terr )rs ");
          
        respuesta = bs.dbService.executeStaticQuery(query.toString());
        //vconte - Se lanza una  Mare Exception  para el caso en que no existe usuario. 
        } catch (MareException mareExc) {
             throw  mareExc;
        } catch (Exception e) {
            throw new MareException(e,
                UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS));
        }

      if (respuesta.esVacio()) {
        throw new MareException(new Exception(),UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE));
      }

        DTOSalida dtoSalida = new DTOSalida(respuesta);
        
        UtilidadesLog.info("DAOLiquidacionCobranza.listadoLiquidaciones(DTOConsultarLiquidacionComisionesCobranza dtoEntrada): Salida");
        
		return dtoSalida;
    }
}