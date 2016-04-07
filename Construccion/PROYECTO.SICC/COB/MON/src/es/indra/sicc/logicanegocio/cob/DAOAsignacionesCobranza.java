package es.indra.sicc.logicanegocio.cob;

import es.indra.sicc.util.DTOBelcorp;
import es.indra.sicc.util.DTOSalida;
import es.indra.mare.common.exception.MareException;
import es.indra.sicc.dtos.cob.DTOAsignacionesCobranza;
import es.indra.sicc.util.BelcorpService;
import es.indra.sicc.util.CodigosError;
import es.indra.sicc.util.DTOString;
import es.indra.sicc.util.UtilidadesError;
import es.indra.mare.common.mii.services.jdbcservice.RecordSet;
import es.indra.mare.common.mii.MareMiiServiceNotFoundException;
import es.indra.sicc.logicanegocio.cob.ConstantesCOB;
import es.indra.sicc.util.UtilidadesLog;
import java.math.BigDecimal;
import javax.ejb.SessionContext;
import java.util.Calendar;

public class DAOAsignacionesCobranza 
{
  private SessionContext session;
  
  public DAOAsignacionesCobranza()
  {
  }
  
  public DAOAsignacionesCobranza(SessionContext session){
        this.session = session;
    }
  
  /**
	 * Sistema:     Belcorp
	 * Modulo:      COB
	 * Fecha:       10/03/2005
	 * @version     1.0
	 * @autor       Viviana Bongiovanni
	 */
  public DTOSalida obtenerCriteriosOrdenacionTC(DTOBelcorp dto) throws MareException {
  
        UtilidadesLog.info("DAOAsignacionesCobranza.obtenerCriteriosOrdenacionTC(DTOBelcorp dto): Entrada");
  
        BelcorpService bs;
        RecordSet respuesta = new RecordSet();
        StringBuffer buf = new StringBuffer();

        try {
            bs = BelcorpService.getInstance();
        } catch (MareMiiServiceNotFoundException e) {
            throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_PEDIR_UN_SERVICIO_MARE));
        }

        try {
            buf.append(" SELECT OID_CRIT_ORDE, VAL_DESC_CRIT_ORDE  ");           
            buf.append(" FROM COB_CRITE_ORDEN ");            
            buf.append(" ORDER BY VAL_DESC_CRIT_ORDE ");

            respuesta = bs.dbService.executeStaticQuery(buf.toString());
            
        } catch (Exception e) {
            throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS));
        }

        UtilidadesLog.info("DAOAsignacionesCobranza.obtenerCriteriosOrdenacionTC(DTOBelcorp dto): Salida");

        return new DTOSalida(respuesta);
  }

 /**
	 * Sistema:     Belcorp
	 * Modulo:      COB
	 * Fecha:       10/03/2005
	 * @version     1.0
	 * @autor       Viviana Bongiovanni
     * 30/06/06 - [1] pperanzola - se  hacen modificaciones para mejorar la performance
	 */
  public DTOSalida buscarAsignacionesCobranzaTC(DTOAsignacionesCobranza dto) throws MareException {  
  
        UtilidadesLog.info("DAOAsignacionesCobranza.buscarAsignacionesCobranzaTC(DTOAsignacionesCobranza dto): Entrada");
  
        BelcorpService bs;
        RecordSet respuesta = new RecordSet();
        StringBuffer buf = new StringBuffer();
        StringBuffer queryPaginado = new StringBuffer();
        StringBuffer queryNoPaginado = new StringBuffer();
        
        try {
            bs = BelcorpService.getInstance();
        } catch (MareMiiServiceNotFoundException e) {
            throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_PEDIR_UN_SERVICIO_MARE));
        }
        
        try {            
            buf.append(" DECODE(COUNT(asig.OID_ASIG_COBR),1,'verde.gif',2,'Azul.gif','Rojo.gif') cantAsigCob, ");
            buf.append(" eta.VAL_DESC, ");
            buf.append(" cli.COD_CLIE,  cli.VAL_APE1 ||' '|| cli.VAL_APE2 ||' '||cli.VAL_NOM1 ||' '|| cli.VAL_NOM2 descCliente, ");
            buf.append(" cliComun1.VAL_TEXT_COMU Tel1, '' Tel2, ");
            //[1]buf.append(" i18n1.VAL_I18N descTipoAbono, marca.DES_MARC ,i18n2.VAL_I18N descCanal, ");
            buf.append(" Pq_Apl_Aux.Valor_Gen_I18n_Sicc("+ dto.getOidIdioma() +", crono.tcab_oid_tipo_carg_abon, 'CCC_TIPO_CARGO_ABONO') desctipoabono, ");
            //[1] buf.append(" marca.DES_MARC ,i18n2.VAL_I18N descCanal, ");
            buf.append(" marca.DES_MARC , ");
            buf.append(" Pq_Apl_Aux.Valor_Gen_I18n_Sicc("+ dto.getOidIdioma() +", peri.cana_oid_cana, 'SEG_CANAL') desccanal, ");
            buf.append(" peri.VAL_NOMB_PERI, subger.DES_SUBG_VENT, reg.DES_REGI, zon.DES_ZONA,  ");
            buf.append(" sec.DES_SECCI, terr.COD_TERR, ");
            buf.append(" SUM(NVL(asig.IMP_DEUD_ASIG, 0)) DEUDA_ASIG, asig.FEC_ASIG, ");            
            buf.append(" asig.IMP_DEUD_ASIG, SUM(NVL(asig.IMP_DEUD_CANC, 0)) DEUD_CANCEL, ");
            buf.append(" Pq_Apl_Aux.Valor_Gen_I18n_Sicc("+ dto.getOidIdioma() +", asig.esas_oid_esta_asig, 'COB_ESTAD_ASIGN') descesta, ");
            buf.append(" eta.OID_ETAP_DEUD, peri.OID_PERI ");
            buf.append(" ,crono.USCO_OID_USUA_COBR, cuota.TCAB_OID_TCAB_ULTI, cli.OID_CLIE, ");
            buf.append(" reg.OID_REGI, zon.OID_ZONA ");
            
            /* inicio modificado ciglesias incidencia zon.OID_ZONA*/
            buf.append(" ,peri.marc_oid_marc oidMarca, peri.CANA_OID_CANA oidCanal  ");
                // gPineda - V-COB-006 - 25/01/2007
                //buf.append(" , cedtc.oid_etap_deud_tipo_carg ");
            /* fin modificado ciglesias incidencia zon.OID_ZONA*/
            
            
            buf.append(" FROM   COB_ASIGN_COBRA asig, COB_CRONO_COBRA crono, ");
            // gPineda - V-COB-006 - 25/01/2007
            //buf.append(" cob_etapa_deuda_tipo_cargo cedtc, ");
            buf.append(" MAE_CLIEN cli, CCC_MOVIM_CUENT_CORRI cuota, ");
            buf.append(" ( SELECT cliComun.CLIE_OID_CLIE , cliComun.VAL_TEXT_COMU ");
            buf.append("   FROM MAE_CLIEN_COMUN cliComun, MAE_TIPO_COMUN tipoComu ");
            buf.append("   WHERE cliComun.TICM_OID_TIPO_COMU = tipoComu.OID_TIPO_COMU ");
            buf.append("   AND tipoComu.COD_TIPO_COMU = 'TF' ");
            buf.append("   AND cliComun.IND_COMU_PPAL = 1 ) cliComun1, ");
            //[1] buf.append(" v_GEN_I18N_SICC i18n1, ");
            //[1] buf.append(" seg_marca marca,  v_GEN_I18N_SICC i18n2, cra_perio peri, ");
            buf.append(" seg_marca marca,  cra_perio peri, ");
            buf.append(" ZON_SUB_GEREN_VENTA subger, ZON_REGIO reg,ZON_ZONA zon, ");

//Por Incidencia 23510 - Inicio
//            buf.append(" ZON_SECCI sec, ZON_TERRI terr, ZON_TERRI_ADMIN terrAdm, v_GEN_I18N_SICC i18n3, ");
            //[1] buf.append(" ZON_SECCI sec, ZON_TERRI terr, v_GEN_I18N_SICC i18n3, ");
            buf.append(" ZON_SECCI sec, ZON_TERRI terr, ");
//Por Incidencia 23510 - Fin
            
            buf.append(" principals princip, users users, cob_usuar_cobra usuCob, cob_etapa_deuda eta ");
            
            if((dto.getTipoCliente()!=null) || (dto.getSubtipoCliente()!=null))  
                buf.append(" , MAE_CLIEN_TIPO_SUBTI cliTipoSubTipo ");
            
            if(dto.getOrdenacion()!=null && dto.getOrdenacion().intValue()==ConstantesCOB.OID_CRI_ORD_ETAPA_DEUDA)
              buf.append(" , COB_ORDEN_ETAPA_DEUDA ordenEtapa1, COB_ORDEN_ETAPA_DEUDA ordenEtapa2, COB_ORDEN_ETAPA_DEUDA ordenEtapa3 ");
              
            if(dto.getOrdenacion()!=null && dto.getOrdenacion().intValue()==ConstantesCOB.OID_CRI_ORD_MAYOR_RIESGO)
              buf.append(" , MAE_CLIEN_DATOS_ADICI datosAdic ");
            
            buf.append(" WHERE  crono.OID_CRON_COBR = asig.CRCO_OID_CRON_COBR ");
            buf.append(" AND asig.PAIS_OID_PAIS =  " +  dto.getOidPais());
            buf.append(" AND asig.MVCC_OID_MOVI_CC = cuota.OID_MOVI_CC  ");
            buf.append(" AND cuota.CLIE_OID_CLIE = cli.OID_CLIE ");
            // gPineda - V-COB-006 - 25/01/2007
            //buf.append(" AND cedtc.tcab_oid_tipo_carg_abon = crono.tcab_oid_tipo_carg_abon ");
            
            if(dto.getOrdenacion()!=null && dto.getOrdenacion().intValue()==ConstantesCOB.OID_CRI_ORD_MAYOR_RIESGO)
              buf.append(" AND cli.OID_CLIE = datosAdic.CLIE_OID_CLIE ");
            
            if((dto.getTipoCliente()!=null) || (dto.getSubtipoCliente()!=null))  
                buf.append(" AND cli.OID_CLIE = cliTipoSubTipo.CLIE_OID_CLIE ");
            
            if(dto.getTipoCliente()!=null)
              buf.append(" AND cliTipoSubTipo.TICL_OID_TIPO_CLIE = " + dto.getTipoCliente()); 
              
            if(dto.getSubtipoCliente()!=null)
              buf.append(" AND cliTipoSubTipo.SBTI_OID_SUBT_CLIE = " + dto.getSubtipoCliente());  
            
            if(dto.getCodigoCliente()!=null)
              buf.append(" AND cli.COD_CLIE = '" + dto.getCodigoCliente() + "' ");  
           
            buf.append(" AND cliComun1.CLIE_OID_CLIE (+) = cli.OID_CLIE ");           
            /* [1]
            buf.append(" AND i18n1.idio_oid_idio (+) = " + dto.getOidIdioma());
            buf.append(" AND i18n1.attr_enti (+) = 'CCC_TIPO_CARGO_ABONO' ");
            buf.append(" AND i18n1.val_oid (+) = crono.TCAB_OID_TIPO_CARG_ABON ");*/
            buf.append(" AND crono.PERD_OID_PERI = peri.OID_PERI ");
            
            if(dto.getPeriodo()!=null)
              buf.append(" AND peri.OID_PERI = " + dto.getPeriodo());
              
            buf.append(" AND peri.MARC_OID_MARC = marca.OID_MARC ");
            
            if(dto.getMarca()!=null)
              buf.append(" AND marca.OID_MARC = " + dto.getMarca());
            
            /* [1]
            buf.append(" AND i18n2.attr_num_atri (+) = 1 ");
            buf.append(" AND i18n2.idio_oid_idio (+) = " + dto.getOidIdioma());
            buf.append(" AND i18n2.attr_enti (+) = 'SEG_CANAL' ");
            buf.append(" AND i18n2.val_oid (+) = peri.CANA_OID_CANA ");*/
            
            if(dto.getCanal()!=null)
              buf.append(" AND peri.CANA_OID_CANA = " + dto.getCanal());  
            
            buf.append(" AND crono.ZSGV_OID_SUBG_VENT = subger.OID_SUBG_VENT ");
            
            if(dto.getSubgerencia()!=null)
              buf.append(" AND subger.OID_SUBG_VENT = " + dto.getSubgerencia());
              
            buf.append(" AND crono.ZZON_OID_ZONA = zon.OID_ZONA(+) ");
            
            if(dto.getZona()!=null)
              buf.append(" AND zon.OID_ZONA = " + dto.getZona());  
              
            buf.append(" AND crono.ZORG_OID_REGI = reg.OID_REGI(+) ");
            
            if(dto.getRegion()!=null)
              buf.append(" AND reg.OID_REGI= " + dto.getRegion());
              
//Por Incidencia 23510 - Inicio
//            buf.append(" AND crono.ZSCC_OID_SECC = terrAdm.ZSCC_OID_SECC (+) ");
//            buf.append(" AND terrAdm.TERR_OID_TERR (+) = crono.TERR_OID_TERR ");
//            buf.append(" AND terrAdm.ZSCC_OID_SECC = sec.OID_SECC(+) ");
            buf.append(" AND crono.ZSCC_OID_SECC = sec.OID_SECC(+) ");
            buf.append(" AND crono.TERR_OID_TERR = terr.OID_TERR(+) ");
//Por Incidencia 23510 - Fin
            
            if(dto.getSeccion()!=null)
              buf.append(" AND sec.OID_SECC = " + dto.getSeccion());  
            
//Por Incidencia 23510 - Inicio
//            buf.append(" AND terrAdm.TERR_OID_TERR = terr.OID_TERR(+) ");
//Por Incidencia 23510 - Inicio
            
            if(dto.getTerritorio()!=null)
              buf.append(" AND terr.COD_TERR = '" + dto.getTerritorio() + "' ");
              
           /* [1]
            buf.append(" AND i18n3.attr_num_atri (+) = 1 ");
            buf.append(" AND i18n3.idio_oid_idio (+) = " + dto.getOidIdioma());
            buf.append(" AND i18n3.attr_enti(+) = 'COB_ESTAD_ASIGN' ");
            buf.append(" AND i18n3.val_oid (+) = asig.ESAS_OID_ESTA_ASIG ");*/
            
            buf.append(" AND asig.ESAS_OID_ESTA_ASIG = " + ConstantesCOB.OID_ESTA_ASIG_ABIERTA);               
            buf.append(" AND crono.USCO_OID_USUA_COBR = usuCob.OID_USUA_COBR ");
            buf.append(" and usuCob.USER_OID_USUA_COBR = users.IDUSER ");
            buf.append(" AND users.IDUSER = princip.IDPRINCIPAL ");
            buf.append(" AND princip.NAME = '" + session.getCallerPrincipal().getName() + "' ");
            buf.append(" AND crono.ETDE_OID_ETAP_DEUD = eta.OID_ETAP_DEUD ");
            
            if(dto.getEtapaDeuda()!=null)
              buf.append(" AND eta.OID_ETAP_DEUD = " + dto.getEtapaDeuda());
              
            if(dto.getOrdenacion()!=null && dto.getOrdenacion().intValue()==ConstantesCOB.OID_CRI_ORD_ETAPA_DEUDA) {
              buf.append(" AND eta.ORED_OID_ETAP_DEU1 = ordenEtapa1.OID_ORDE_ETAP_DEUD ");
              buf.append(" AND eta.ORED_OID_ETAP_DEU2 = ordenEtapa2.OID_ORDE_ETAP_DEUD(+) ");
              buf.append(" AND eta.ORED_OID_ETAP_DEU3 = ordenEtapa3.OID_ORDE_ETAP_DEUD(+) ");
              
            }
            
            buf.append(" GROUP BY princip.NAME, eta.VAL_DESC,cli.COD_CLIE, ");
            buf.append(" cli.VAL_APE1 ||' '|| cli.VAL_APE2 ||' '||cli.VAL_NOM1 ||' '|| cli.VAL_NOM2, ");
            buf.append(" cliComun1.VAL_TEXT_COMU, 'Tel2', Pq_Apl_Aux.Valor_Gen_I18n_Sicc("+ dto.getOidIdioma() +", crono.tcab_oid_tipo_carg_abon, 'CCC_TIPO_CARGO_ABONO'), ");//[1] buf.append(" cliComun1.VAL_TEXT_COMU, 'Tel2', i18n1.VAL_I18N, marca.DES_MARC ,i18n2.VAL_I18N, ");
            buf.append(" marca.DES_MARC ,Pq_Apl_Aux.Valor_Gen_I18n_Sicc("+ dto.getOidIdioma() +", peri.cana_oid_cana, 'SEG_CANAL'), ");
            buf.append(" peri.VAL_NOMB_PERI, subger.DES_SUBG_VENT, reg.DES_REGI, zon.DES_ZONA, ");
            buf.append(" sec.DES_SECCI, terr.COD_TERR,asig.FEC_ASIG, asig.IMP_DEUD_ASIG, Pq_Apl_Aux.Valor_Gen_I18n_Sicc("+ dto.getOidIdioma() +", asig.esas_oid_esta_asig, 'COB_ESTAD_ASIGN'),  ");
            buf.append(" eta.OID_ETAP_DEUD, peri.OID_PERI ");
            buf.append(" ,crono.USCO_OID_USUA_COBR, cuota.TCAB_OID_TCAB_ULTI, cli.OID_CLIE, ");
            buf.append(" reg.OID_REGI, zon.OID_ZONA ");
            buf.append(" ,peri.marc_oid_marc,peri.cana_oid_cana, ");
            // gPineda - V-COB-006 - 25/01/2007
            //buf.append(" cedtc.oid_etap_deud_tipo_carg");
            buf.append(" cuota.TCAB_OID_TCAB_CREA ");
            
            
            // Se agrega la ordenación
            if(dto.getOrdenacion()!=null){
              if(dto.getOrdenacion().intValue()==ConstantesCOB.OID_CRI_ORD_CONS_NUEVAS) {
                // Agrega un campo al group by
                buf.append(" , peri.FEC_INIC ");
                buf.append(" ORDER BY peri.FEC_INIC DESC ");
              } else if(dto.getOrdenacion().intValue()==ConstantesCOB.OID_CRI_ORD_CONS_INCID) {
                buf.append(" ORDER BY COUNT(asig.OID_ASIG_COBR) ");
              } else if(dto.getOrdenacion().intValue()==ConstantesCOB.OID_CRI_ORD_MAYOR_RIESGO) {
                 buf.append(" , datosAdic.NIRI_OID_NIVE_RIES ");
                 buf.append(" ORDER BY datosAdic.NIRI_OID_NIVE_RIES ");
              } else if(dto.getOrdenacion().intValue()==ConstantesCOB.OID_CRI_ORD_ETAPA_DEUDA) {
                 buf.append(" , ordenEtapa1.COD_ORDE_ETAP_DEUD ,ordenEtapa2.COD_ORDE_ETAP_DEUD ,ordenEtapa3.COD_ORDE_ETAP_DEUD  ");
                 buf.append(" ORDER BY ordenEtapa1.COD_ORDE_ETAP_DEUD DESC,ordenEtapa2.COD_ORDE_ETAP_DEUD DESC,ordenEtapa3.COD_ORDE_ETAP_DEUD DESC ");
              } 
            } 
            
            
            // Se agrega la paginación
            if(dto.getPaginado().booleanValue()) {
            
              queryPaginado.append(" SELECT * FROM ( ");
              queryPaginado.append("     SELECT ROWNUM AS linea, queryPrincipal.* ");
              queryPaginado.append("     FROM ( SELECT  ");
              queryPaginado.append(buf.toString());
              queryPaginado.append("     )  queryPrincipal ");
              
              if(dto.getOrdenacion()==null)
                queryPaginado.append(" ORDER BY linea ");
                
              queryPaginado.append(" ) WHERE ROWNUM <= " + dto.getTamanioPagina() + " AND linea > " + dto.getIndicadorSituacion());
            
              respuesta = BelcorpService.getInstance().dbService.executeStaticQuery(queryPaginado.toString());
              
            } else if(!dto.getPaginado().booleanValue()) {
              queryNoPaginado.append(" SELECT MIN(asig.OID_ASIG_COBR) OID, ");
              queryNoPaginado.append(buf.toString());
              
              if(dto.getOrdenacion()==null)
                queryNoPaginado.append(" ORDER BY OID ");
                
              respuesta = bs.dbService.executeStaticQuery(queryNoPaginado.toString());
            }
            
        } catch (Exception e) {
            throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS));
        }        
        
        
        if( respuesta.esVacio() ){
          UtilidadesLog.debug("************** No hay registros, se lanza la MareException");          
          throw new MareException(new Exception(),UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE));
        }  
        
        
        // Obtengo los datos de Telefono 2
        StringBuffer queryTel2 = new StringBuffer();
        RecordSet rsTel2 = new RecordSet();
        String codCliente = null;
        String codClienteTel2 = null;
        String tel2 = "";
        
        try {            
            queryTel2.append(" SELECT cli.COD_CLIE , cliComun.VAL_TEXT_COMU ");
            queryTel2.append(" FROM MAE_CLIEN cli, MAE_CLIEN_COMUN cliComun, MAE_TIPO_COMUN tipoComu ");            
            queryTel2.append(" WHERE cliComun.CLIE_OID_CLIE = cli.OID_CLIE ");
            queryTel2.append(" AND cliComun.TICM_OID_TIPO_COMU = tipoComu.OID_TIPO_COMU ");
            queryTel2.append(" AND tipoComu.COD_TIPO_COMU = 'TF' ");
            queryTel2.append(" AND cliComun.IND_COMU_PPAL = 0	 ");
            queryTel2.append(" ORDER BY cliComun.CLIE_OID_CLIE, cliComun.OID_CLIE_COMU ");
            
            rsTel2 = bs.dbService.executeStaticQuery(queryTel2.toString());            
            
        } catch (Exception e) {
            throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS));
        }        
        
        
        // Adiciono Tel2 al RecordSet principal        
        if(!respuesta.esVacio() && !rsTel2.esVacio()){
            // Recorro el query principal
            for( int i=0; i<respuesta.getRowCount(); i++ ){
                tel2 = "";
                codCliente = respuesta.getValueAt(i, "COD_CLIE").toString();
                
                UtilidadesLog.debug("codCliente: " + codCliente);
                UtilidadesLog.debug("codCliente iii: " + respuesta.getValueAt(i,3).toString());
                
                for( int j=0; j<rsTel2.getRowCount(); j++ ){
                    codClienteTel2 = rsTel2.getValueAt(j, "COD_CLIE").toString();
                  
                    if(codCliente.equals(codClienteTel2)){
                      tel2 = tel2 + rsTel2.getValueAt(j, "VAL_TEXT_COMU").toString() + " ";
                    }                  
                }
                
                respuesta.setValueAt(tel2, i, 6);
            }
        }

        UtilidadesLog.info("DAOAsignacionesCobranza.buscarAsignacionesCobranzaTC(DTOAsignacionesCobranza dto): Salida");

        return new DTOSalida(respuesta);
  /*
        RecordSet rs = new RecordSet();
          
        rs.addColumn("1");        
        rs.addColumn("2");
        rs.addColumn("3");
        rs.addColumn("4");
        rs.addColumn("5");
        rs.addColumn("6");
        rs.addColumn("7");
        rs.addColumn("8");
        rs.addColumn("9");
        rs.addColumn("10");
        rs.addColumn("11");
        rs.addColumn("12");
        rs.addColumn("13");
        rs.addColumn("14");        
        rs.addColumn("15");
        rs.addColumn("16");
        rs.addColumn("17");
        rs.addColumn("18");
        rs.addColumn("19");
        rs.addColumn("20");
        rs.addColumn("21");
        rs.addColumn("22");
        rs.addColumn("23");
              
        rs.addRow(new Object[] {new String("1069"), new String("Rojo.gif"),new String("Etapa"),new String("00000000001"),
        new String("Prueba"),new String("Tel1: 9876"),new String("Tel 2: 8722"),new String("Tipo cargo"),
        new String("Marca"),new String("Canal"),new String("Periodo"),new String("Subg"),new String("Region"),new String("zona"),
        new String("Seccion"),new String("Territorio"),new BigDecimal(1000), new String("01/03/2005"),new BigDecimal(100), new BigDecimal(400),new String("Estado"),
        new BigDecimal(1), new BigDecimal(42)});
                
        return new DTOSalida(rs);
        */
      
                  
  }
  /**
     * 
     * @date 18/09/2006 
     * @throws es.indra.mare.common.exception.MareException
     * @return 
     * @param dto
     */
  public DTOSalida buscarAsignacionesCobranzaTC2(DTOAsignacionesCobranza dto) throws MareException {  
        UtilidadesLog.info("DAOAsignacionesCobranza.buscarAsignacionesCobranzaTC2(DTOAsignacionesCobranza dto): Entrada");
  
        BelcorpService bs;
        RecordSet respuesta = new RecordSet();
        StringBuffer buf = new StringBuffer();
        StringBuffer queryPaginado = new StringBuffer();
        StringBuffer queryNoPaginado = new StringBuffer();
        
        try {
            bs = BelcorpService.getInstance();
        } catch (MareMiiServiceNotFoundException e) {
            throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_PEDIR_UN_SERVICIO_MARE));
        }
        
        try {        
            buf.append(" DECODE (COUNT (asig.oid_asig_cobr), 1, 'verde.gif',   2, 'Azul.gif',  'Rojo.gif' ) cantasigcob  ");
            buf.append(" , cli.cod_clie ");
            buf.append("  ,  cli.val_ape1  || ' '   || cli.val_ape2   || ' '    || cli.val_nom1     || ' '   || cli.val_nom2 desccliente ");
            buf.append(" ,  (SELECT val_text_comu ");
            buf.append("     FROM MAE_CLIEN_COMUN clicomun, ");
            buf.append("     MAE_TIPO_COMUN  tipocomu ");
            buf.append("     WHERE clicomun.ticm_oid_tipo_comu =  tipocomu.oid_tipo_comu ");
            buf.append("     AND tipocomu.cod_tipo_comu = 'TF'");
            buf.append("     AND clicomun.ind_comu_ppal = 1 ");
            buf.append("     AND clicomun.clie_oid_clie = cli.oid_clie) AS TEL1 ");
            buf.append(" , '' tel2 ");
            buf.append(" ,(SUM (NVL (asig.imp_deud_asig, 0)) - SUM (NVL (asig.imp_deud_canc, 0))) AS IMP_PENDIENTE ");
            buf.append(" ,PQ_APL_COB.num_gestiones(cuota.clie_oid_clie, asig.FEC_ASIG) AS NUM_GESTIONES ");
            buf.append(" ,PQ_APL_COB.ult_gestion(cuota.clie_oid_clie, asig.FEC_ASIG) AS ULTIMA_GESTION ");
            buf.append(" ,peri.val_nomb_peri ");
            // Modificado por Rafael Romero - SiCC20070219 - 04/05/2007
            buf.append(" ,eta.val_desc desc_etapa ");
            buf.append(" ,(SELECT des_zona FROM ZON_ZONA zon WHERE zsecc.zzon_oid_zona = zon.oid_zona) des_zona  ");
            buf.append(" ,(SELECT des_secci FROM  ZON_SECCI sec WHERE ztadmin.zscc_oid_secc = sec.oid_secc ) des_secci ");
            buf.append(" ,(SELECT terr.cod_terr FROM ZON_TERRI terr WHERE ztadmin.terr_oid_terr = terr.oid_terr) cod_terr ");
            // Fin Modificado
            buf.append(" ,SUM (NVL (asig.imp_deud_asig, 0)) deuda_asig ");
            buf.append(" ,asig.IMP_ORIG_DEUD deuda_orig ");
            // buf.append(" ,asig.imp_deud_asig ");
            buf.append(" ,SUM (NVL (asig.imp_deud_canc, 0)) deud_cancel ");
            buf.append(" ,(SELECT des_subg_vent  FROM  ZON_SUB_GEREN_VENTA subger WHERE crono.zsgv_oid_subg_vent = subger.oid_subg_vent) des_subg_vent ");
            buf.append(" ,(SELECT des_regi FROM ZON_REGIO reg WHERE  crono.zorg_oid_regi = reg.oid_regi) des_regi ");
            buf.append(" , Pq_Apl_Aux.valor_gen_i18n_sicc  ("+ dto.getOidIdioma() +", crono.tcab_oid_tipo_carg_abon, 'CCC_TIPO_CARGO_ABONO'  ) desctipoabono ");
            buf.append(" ,(SELECT mrca.des_marc FROM seg_marca mrca WHERE mrca.oid_marc = peri.marc_oid_marc) AS des_marca");
            /*
            buf.append(" ,(SELECT des_marc FROM seg_marca WHERE oid_marc = " );
            if(dto.getMarca()!=null){
                buf.append( dto.getMarca());
            } else {
                buf.append(" peri.marc_oid_marc ");
            }
            buf.append( ") des_marca ");
            */
            buf.append(" ,Pq_Apl_Aux.valor_gen_i18n_sicc   ("+ dto.getOidIdioma() +",    peri.cana_oid_cana,  'SEG_CANAL'   ) desccanal ");
            buf.append(" ,asig.fec_asig ");
            buf.append(" ,Pq_Apl_Aux.valor_gen_i18n_sicc   ("+ dto.getOidIdioma() +",  asig.esas_oid_esta_asig,  'COB_ESTAD_ASIGN'  ) descesta ");

            buf.append(" ,eta.oid_etap_deud ");
            buf.append(" ,peri.oid_peri ");
            buf.append(" ,crono.usco_oid_usua_cobr ");
            buf.append(" ,cuota.tcab_oid_tcab_ulti ");
            buf.append(" ,cli.oid_clie ");
            buf.append(" ,crono.zorg_oid_regi ");
            buf.append(" ,crono.zzon_oid_zona ");
            /* inicio modificado ciglesias incidencia zon.OID_ZONA*/
            buf.append(" ,peri.marc_oid_marc oidMarca ");
            buf.append(" ,peri.CANA_OID_CANA oidCanal ");
            // gPineda - V-COB006 - 25/01/2007
            buf.append(" , asig.tcab_oid_tipo_carg_abon oidTipoCargo ");
            /* fin modificado ciglesias incidencia zon.OID_ZONA */
            buf.append(" FROM COB_ASIGN_COBRA asig, ");
            // gPineda - V-COB006 - 25/01/2007
            // buf.append(" cob_etapa_deuda_tipo_cargo cedtc, ");
            buf.append(" COB_CRONO_COBRA crono, ");
            buf.append(" MAE_CLIEN cli, ");
            // Agregado por Rafael Romero - SiCC 20070219 - 04/05/2007
            buf.append(" MAE_CLIEN_UNIDA_ADMIN clieua,  ");
            buf.append(" ZON_TERRI_ADMIN ztadmin, ");
            buf.append(" ZON_SECCI zsecc, ");
            // Fin Agregado
            buf.append(" CCC_MOVIM_CUENT_CORRI cuota, ");
            buf.append(" CRA_PERIO peri, ");
            buf.append(" principals princip, ");
            buf.append(" users users, ");
            buf.append(" COB_USUAR_COBRA usucob, ");
            buf.append(" COB_ETAPA_DEUDA eta ");
            if((dto.getTipoCliente()!=null) || (dto.getSubtipoCliente()!=null)){  
                buf.append(" , MAE_CLIEN_TIPO_SUBTI cliTipoSubTipo ");
            }
            if(dto.getOrdenacion()!=null && dto.getOrdenacion().intValue()==ConstantesCOB.OID_CRI_ORD_ETAPA_DEUDA){
              buf.append(" , COB_ORDEN_ETAPA_DEUDA ordenEtapa1, COB_ORDEN_ETAPA_DEUDA ordenEtapa2, COB_ORDEN_ETAPA_DEUDA ordenEtapa3 ");
            }
            if(dto.getOrdenacion()!=null && dto.getOrdenacion().intValue()==ConstantesCOB.OID_CRI_ORD_MAYOR_RIESGO){
              buf.append(" , MAE_CLIEN_DATOS_ADICI datosAdic ");
            }
            if(dto.getOrdenacion()!=null && dto.getOrdenacion().intValue()==ConstantesCOB.OID_CRI_ORD_LLAMADA_DEL_DIA){
                buf.append(" , (SELECT ");
                buf.append("      CASE WHEN (reprog.clie_oid_clie IS NULL ) THEN comunicdiapref.clie_oid_clie ELSE reprog.clie_oid_clie END clie_oid_clie, ");
                buf.append("      reprog.fec_repr, comunicdiapref.fec_hora_desd, comunicdiapref.fec_hora_hast ");
                buf.append("    FROM ");
                buf.append("      ( SELECT DISTINCT gest.clie_oid_clie, gest.fec_repr ");
                buf.append("        FROM cob_gesti_cobra gest ");
                buf.append("        WHERE TRUNC (gest.fec_repr) = TRUNC (SYSDATE) ");
                if (dto.getPeriodo() != null) {
                    buf.append("        AND gest.perd_oid_peri = " + dto.getPeriodo() );
                }
                if (dto.getEtapaDeuda() != null) {
                    buf.append("       AND gest.etde_oid_etapa_deuda = " + dto.getEtapaDeuda() );
                }
                buf.append("      ) reprog ");
                buf.append("      FULL OUTER JOIN ");
                buf.append("      ( SELECT comunic.clie_oid_clie, comunic.fec_hora_desd, comunic.fec_hora_hast ");
                buf.append("        FROM mae_clien_comun comunic, mae_tipo_comun tipocomunic ");
                buf.append("        WHERE comunic.ind_comu_ppal = 1 ");
                buf.append("        AND comunic.ticm_oid_tipo_comu = tipocomunic.oid_tipo_comu ");
                buf.append("        AND tipocomunic.cod_tipo_comu = 'TF' ");
                buf.append("        AND comunic.val_dia_comu = 'S' ");
                buf.append("       ) comunicdiapref ");
                buf.append("      ON reprog.clie_oid_clie = comunicdiapref.clie_oid_clie ");
                buf.append("   ) llamadasdia ");
            }
            buf.append(" WHERE crono.oid_cron_cobr = asig.crco_oid_cron_cobr ");
            buf.append(" AND asig.pais_oid_pais = " + dto.getOidPais());
            buf.append(" AND asig.mvcc_oid_movi_cc = cuota.oid_movi_cc ");
            // Agregado por Rafael Romero - Incidencia SiCC 20070178 (03/04/2007)
            buf.append(" AND asig.IMP_DEUD_ASIG != asig.IMP_DEUD_CANC ");
            // Fin agregar
            //buf.append(" AND cedtc.tcab_oid_tipo_carg_abon = crono.tcab_oid_tipo_carg_abon ");
            buf.append(" AND cuota.clie_oid_clie = cli.oid_clie ");
            // Agregado por Rafael Romero - SiCC 2007019 - 04/05/2007
            buf.append(" AND clieua.CLIE_OID_CLIE = cuota.clie_oid_clie AND clieua.IND_ACTI = 1 ");
            buf.append(" AND ztadmin.OID_TERR_ADMI = clieua.ZTAD_OID_TERR_ADMI (+) ");
            buf.append(" AND zsecc.OID_SECC = ztadmin.ZSCC_OID_SECC(+) ");
            // Fin Agregado por Rafael Romero - 04/05/2007
            buf.append(" AND crono.perd_oid_peri = peri.oid_peri ");
            // Comentado por Rafael Romero - Incidencia SiCC 20070178 (04/04/2007)
            // buf.append(" AND asig.ESAS_OID_ESTA_ASIG = " + ConstantesCOB.OID_ESTA_ASIG_ABIERTA);
            // Fin Comentar
            buf.append(" AND crono.usco_oid_usua_cobr = usucob.oid_usua_cobr ");
            buf.append(" AND usucob.user_oid_usua_cobr = users.iduser ");
            buf.append(" AND users.iduser = princip.idprincipal ");
            buf.append(" AND princip.NAME = '" + session.getCallerPrincipal().getName() + "' ");
            buf.append(" AND crono.etde_oid_etap_deud = eta.oid_etap_deud ");
            if(dto.getPeriodo()!=null){
              buf.append(" AND peri.OID_PERI = " + dto.getPeriodo());
            }

            if(dto.getCanal()!=null){
              buf.append(" AND peri.CANA_OID_CANA = " + dto.getCanal());  
            }
            if(dto.getMarca()!=null)
              buf.append(" AND peri.marc_oid_marc = " + dto.getMarca());
            
              
            if(dto.getEtapaDeuda()!=null){
              buf.append(" AND eta.OID_ETAP_DEUD = " + dto.getEtapaDeuda());
            }
            if(dto.getOrdenacion()!=null && dto.getOrdenacion().intValue()==ConstantesCOB.OID_CRI_ORD_MAYOR_RIESGO)
              buf.append(" AND cli.OID_CLIE = datosAdic.CLIE_OID_CLIE ");
            
            if((dto.getTipoCliente()!=null) || (dto.getSubtipoCliente()!=null))  
                buf.append(" AND cli.OID_CLIE = cliTipoSubTipo.CLIE_OID_CLIE ");
            
            if(dto.getTipoCliente()!=null)
              buf.append(" AND cliTipoSubTipo.TICL_OID_TIPO_CLIE = " + dto.getTipoCliente()); 
              
            if(dto.getSubtipoCliente()!=null)
              buf.append(" AND cliTipoSubTipo.SBTI_OID_SUBT_CLIE = " + dto.getSubtipoCliente());  
            
            if(dto.getCodigoCliente()!=null)
              buf.append(" AND cli.COD_CLIE = '" + dto.getCodigoCliente() + "' ");  
            
            if(dto.getSubgerencia()!=null){
              buf.append(" AND crono.zsgv_oid_subg_vent = " + dto.getSubgerencia());
            }
            if(dto.getZona()!=null){
              buf.append(" AND crono.zzon_oid_zona = " + dto.getZona());  
            }
            if(dto.getRegion()!=null){
              buf.append(" AND crono.zorg_OID_REGI= " + dto.getRegion());
            }
            if(dto.getSeccion()!=null){
              buf.append(" AND crono.zscc_oid_secc = " + dto.getSeccion());  
            }

            if(dto.getOrdenacion()!=null) {
                if (dto.getOrdenacion().intValue()==ConstantesCOB.OID_CRI_ORD_ETAPA_DEUDA) {
                    buf.append(" AND eta.ORED_OID_ETAP_DEU1 = ordenEtapa1.OID_ORDE_ETAP_DEUD ");
                    buf.append(" AND eta.ORED_OID_ETAP_DEU2 = ordenEtapa2.OID_ORDE_ETAP_DEUD(+) ");
                    buf.append(" AND eta.ORED_OID_ETAP_DEU3 = ordenEtapa3.OID_ORDE_ETAP_DEUD(+) ");
                } else if (dto.getOrdenacion().intValue()==ConstantesCOB.OID_CRI_ORD_LLAMADA_DEL_DIA) {
                    buf.append(" AND cli.oid_clie = llamadasdia.clie_oid_clie ");
                }
            }
            buf.append(" GROUP BY princip.NAME, ");
            buf.append(" cli.cod_clie, ");
            buf.append(" cli.val_ape1   || ' '  || cli.val_ape2      || ' '        || cli.val_nom1    || ' '  || cli.val_nom2, ");
            buf.append("  'TEL1' ,    ");
            buf.append("  'Tel2',  ");
            buf.append("  pq_apl_cob.num_gestiones(cuota.clie_oid_clie,asig.fec_asig),  ");
            buf.append("  pq_apl_cob.ult_gestion(cuota.clie_oid_clie,asig.fec_asig),  ");
            buf.append("  crono.tcab_oid_tipo_carg_abon, 'desctipoabono', ");
            if(dto.getMarca()!=null){
                buf.append( " " );
            } else {
                buf.append(" peri.marc_oid_marc, ");
            }
            buf.append(" 'des_marc', ");
            buf.append(" peri.cana_oid_cana,'desccanal' , ");
            buf.append(" peri.val_nomb_peri, ");
            buf.append(" eta.val_desc, ");
            buf.append(" crono.zsgv_oid_subg_vent , 'des_subg_vent', ");
//            buf.append(" 'des_regi', ");
            buf.append(" zsecc.zzon_oid_zona,  ");
            buf.append(" crono.zscc_oid_secc, ztadmin.zscc_oid_secc, ");
            buf.append(" ztadmin.terr_oid_terr, ");
            buf.append(" crono.terr_oid_terr, ");
            buf.append(" asig.fec_asig, ");
            buf.append(" asig.imp_deud_asig, ");
            buf.append(" asig.esas_oid_esta_asig, 'descesta', ");
            buf.append(" eta.oid_etap_deud, ");
            buf.append(" peri.oid_peri, ");
            buf.append(" crono.usco_oid_usua_cobr, ");
            buf.append(" cuota.tcab_oid_tcab_ulti, ");
            buf.append(" cli.oid_clie, ");
            buf.append(" crono.zorg_oid_regi , ");
            buf.append(" crono.zzon_oid_zona ");
            buf.append(" ,peri.marc_oid_marc,peri.cana_oid_cana ");
            buf.append(" ,asig.imp_orig_deud ");
            buf.append(" ,asig.TCAB_OID_TIPO_CARG_ABON ");
            // V-COB006 - gPineda - 25/01/2007
            //buf.append(" cedtc.oid_etap_deud_tipo_carg");
            buf.append(" ,cuota.TCAB_OID_TCAB_CREA ");
            
            
            // Se agrega la ordenación
            if(dto.getOrdenacion()!=null){
              if(dto.getOrdenacion().intValue()==ConstantesCOB.OID_CRI_ORD_CONS_NUEVAS) {
                // Agrega un campo al group by
                buf.append(" , peri.FEC_INIC ");
                buf.append(" ORDER BY peri.FEC_INIC DESC ");
              } else if(dto.getOrdenacion().intValue()==ConstantesCOB.OID_CRI_ORD_CONS_INCID) {
                buf.append(" ORDER BY COUNT(asig.OID_ASIG_COBR) ");
              } else if(dto.getOrdenacion().intValue()==ConstantesCOB.OID_CRI_ORD_MAYOR_RIESGO) {
                 buf.append(" , datosAdic.NIRI_OID_NIVE_RIES ");
                 buf.append(" ORDER BY datosAdic.NIRI_OID_NIVE_RIES ");
              } else if(dto.getOrdenacion().intValue()==ConstantesCOB.OID_CRI_ORD_ETAPA_DEUDA) {
                 buf.append(" , ordenEtapa1.COD_ORDE_ETAP_DEUD ,ordenEtapa2.COD_ORDE_ETAP_DEUD ,ordenEtapa3.COD_ORDE_ETAP_DEUD  ");
                 buf.append(" ORDER BY ordenEtapa1.COD_ORDE_ETAP_DEUD DESC,ordenEtapa2.COD_ORDE_ETAP_DEUD DESC,ordenEtapa3.COD_ORDE_ETAP_DEUD DESC ");
              } else if (dto.getOrdenacion().intValue()==ConstantesCOB.OID_CRI_ORD_LLAMADA_DEL_DIA) {
                 buf.append(" , llamadasdia.fec_repr, llamadasdia.fec_hora_desd, llamadasdia.fec_hora_hast ");
                 buf.append(" ORDER BY llamadasdia.fec_repr, llamadasdia.fec_hora_desd, llamadasdia.fec_hora_hast ");
              } else if (dto.getOrdenacion().intValue()==ConstantesCOB.OID_CRI_ORD_MAYOR_SALDO_PEND) {
                 buf.append(" ORDER BY SUM (NVL (asig.imp_deud_asig, 0)) - SUM (NVL (asig.imp_deud_canc, 0)) DESC ");
              }
            } 
            
            
            // Se agrega la paginación
            if(dto.getPaginado().booleanValue()) {
            
              queryPaginado.append(" SELECT * FROM ( ");
              queryPaginado.append("     SELECT ROWNUM AS linea, queryPrincipal.* ");
              queryPaginado.append("     FROM ( SELECT  ");
              queryPaginado.append(buf.toString());
              queryPaginado.append("     )  queryPrincipal ");
              
              if(dto.getOrdenacion()==null)
                queryPaginado.append(" ORDER BY linea ");
                
              queryPaginado.append(" ) WHERE ROWNUM <= " + dto.getTamanioPagina() + " AND linea > " + dto.getIndicadorSituacion());
            
              respuesta = BelcorpService.getInstance().dbService.executeStaticQuery(queryPaginado.toString());
              
            } else if(!dto.getPaginado().booleanValue()) {
              queryNoPaginado.append(" SELECT MIN(asig.OID_ASIG_COBR) OID, ");
              queryNoPaginado.append(buf.toString());
              
              if(dto.getOrdenacion()==null)
                queryNoPaginado.append(" ORDER BY OID ");
                
              respuesta = bs.dbService.executeStaticQuery(queryNoPaginado.toString());
            }
            
        } catch (Exception e) {
            throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS));
        }        
        
        
        if( respuesta.esVacio() ){
          UtilidadesLog.debug("************** No hay registros, se lanza la MareException");          
          throw new MareException(new Exception(),UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE));
        }  
        
        
        // Obtengo los datos de Telefono 2
        StringBuffer queryTel2 = new StringBuffer();
        RecordSet rsTel2 = new RecordSet();
        String codCliente = null;
        String codClienteTel2 = null;
        String tel2 = "";
        
        try {            
            queryTel2.append(" SELECT cli.COD_CLIE , cliComun.VAL_TEXT_COMU ");
            queryTel2.append(" FROM MAE_CLIEN cli, MAE_CLIEN_COMUN cliComun, MAE_TIPO_COMUN tipoComu ");            
            queryTel2.append(" WHERE cliComun.CLIE_OID_CLIE = cli.OID_CLIE ");
            queryTel2.append(" AND cliComun.TICM_OID_TIPO_COMU = tipoComu.OID_TIPO_COMU ");
            queryTel2.append(" AND tipoComu.COD_TIPO_COMU = 'TF' ");
            queryTel2.append(" AND cliComun.IND_COMU_PPAL = 0	 ");
            queryTel2.append(" ORDER BY cliComun.CLIE_OID_CLIE, cliComun.OID_CLIE_COMU ");
            
            rsTel2 = bs.dbService.executeStaticQuery(queryTel2.toString());            
            
        } catch (Exception e) {
            throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS));
        }        
        
        
        // Adiciono Tel2 al RecordSet principal        
        if(!respuesta.esVacio() && !rsTel2.esVacio()){
            // Recorro el query principal
            for( int i=0; i<respuesta.getRowCount(); i++ ){
                tel2 = "";
                codCliente = respuesta.getValueAt(i, "COD_CLIE").toString();
                
                UtilidadesLog.debug("codCliente: " + codCliente);
                UtilidadesLog.debug("codCliente iii: " + respuesta.getValueAt(i,3).toString());
                
                for( int j=0; j<rsTel2.getRowCount(); j++ ){
                    codClienteTel2 = rsTel2.getValueAt(j, "COD_CLIE").toString();
                  
                    if(codCliente.equals(codClienteTel2)){
                      tel2 = tel2 + rsTel2.getValueAt(j, "VAL_TEXT_COMU").toString() + " ";
                    }                  
                }
                
                respuesta.setValueAt(tel2, i, 5);
            }
        }

        UtilidadesLog.info("DAOAsignacionesCobranza.buscarAsignacionesCobranzaTC2(DTOAsignacionesCobranza dto): Salida");

        return new DTOSalida(respuesta);
  }


    /**
   * Retorna un identificador para el dia de semana del dia de hoy.
   * @autor gdmarzi
   */
    private String obtenerDiaDeLaSemana() throws MareException {
        String diaSemanaStr = new String();
        Calendar cal = Calendar.getInstance();
        UtilidadesLog.debug("hoy: " + cal.getTime() + " dia de semana: " + cal.get(Calendar.DAY_OF_WEEK) );
        int dia = cal.get(Calendar.DAY_OF_WEEK);
        if (dia == cal.SUNDAY) { 
            diaSemanaStr = "D";
        } else if (dia == cal.MONDAY) {
            diaSemanaStr = "L";
        } else if (dia == cal.TUESDAY) {
            diaSemanaStr = "M";
        } else if (dia == cal.WEDNESDAY) { 
            diaSemanaStr = "I";
        } else if (dia == cal.THURSDAY) {
            diaSemanaStr = "J";
        } else if (dia == cal.FRIDAY) {
            diaSemanaStr = "V";
        } else if (dia == cal.SATURDAY) { 
            diaSemanaStr = "S";
        }
        return diaSemanaStr;      
    }
    DTOString obtenerTotalesAsignacionesCobranzaTC(DTOAsignacionesCobranza dto) throws MareException{
        UtilidadesLog.debug("DAOAsignacionesCobranza.obtenerTotalesAsignacionesCobranzaTC(): entrada");
        DTOString retorno = null;
 
        BelcorpService bs;
        RecordSet respuesta = new RecordSet();
        StringBuffer buf = new StringBuffer();
        
        try {
            bs = BelcorpService.getInstance();
        } catch (MareMiiServiceNotFoundException e) {
            throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_PEDIR_UN_SERVICIO_MARE));
        }
        
        try {        
            buf.append("SELECT COUNT(*) AS CANTIDAD, ");
            buf.append(" NVL( SUM(asig.imp_deud_asig - asig.imp_deud_canc), 0) DEUD_PEND ");
            buf.append(" FROM COB_ASIGN_COBRA asig, ");
            buf.append(" COB_CRONO_COBRA crono, ");
            buf.append(" MAE_CLIEN cli, ");
            buf.append(" MAE_CLIEN_UNIDA_ADMIN clieua,  ");
            buf.append(" ZON_TERRI_ADMIN ztadmin, ");
            buf.append(" ZON_SECCI zsecc, ");
            buf.append(" CCC_MOVIM_CUENT_CORRI cuota, ");
            buf.append(" CRA_PERIO peri, ");
            buf.append(" principals princip, ");
            buf.append(" users users, ");
            buf.append(" COB_USUAR_COBRA usucob, ");
            buf.append(" COB_ETAPA_DEUDA eta ");
            if((dto.getTipoCliente()!=null) || (dto.getSubtipoCliente()!=null)){  
                buf.append(" , MAE_CLIEN_TIPO_SUBTI cliTipoSubTipo ");
            }
            /*
            if(dto.getOrdenacion()!=null && dto.getOrdenacion().intValue()==ConstantesCOB.OID_CRI_ORD_ETAPA_DEUDA){
              buf.append(" , COB_ORDEN_ETAPA_DEUDA ordenEtapa1, COB_ORDEN_ETAPA_DEUDA ordenEtapa2, COB_ORDEN_ETAPA_DEUDA ordenEtapa3 ");
            }
            if(dto.getOrdenacion()!=null && dto.getOrdenacion().intValue()==ConstantesCOB.OID_CRI_ORD_MAYOR_RIESGO){
              buf.append(" , MAE_CLIEN_DATOS_ADICI datosAdic ");
            }
            if(dto.getOrdenacion()!=null && dto.getOrdenacion().intValue()==ConstantesCOB.OID_CRI_ORD_LLAMADA_DEL_DIA){
                buf.append(" , (SELECT ");
                buf.append("      CASE WHEN (reprog.clie_oid_clie IS NULL ) THEN comunicdiapref.clie_oid_clie ELSE reprog.clie_oid_clie END clie_oid_clie, ");
                buf.append("      reprog.fec_repr, comunicdiapref.fec_hora_desd, comunicdiapref.fec_hora_hast ");
                buf.append("    FROM ");
                buf.append("      ( SELECT DISTINCT gest.clie_oid_clie, gest.fec_repr ");
                buf.append("        FROM cob_gesti_cobra gest ");
                buf.append("        WHERE TRUNC (gest.fec_repr) = TRUNC (SYSDATE) ");
                if (dto.getPeriodo() != null) {
                    buf.append("        AND gest.perd_oid_peri = " + dto.getPeriodo() );
                }
                if (dto.getEtapaDeuda() != null) {
                    buf.append("       AND gest.etde_oid_etapa_deuda = " + dto.getEtapaDeuda() );
                }
                buf.append("      ) reprog ");
                buf.append("      FULL OUTER JOIN ");
                buf.append("      ( SELECT comunic.clie_oid_clie, comunic.fec_hora_desd, comunic.fec_hora_hast ");
                buf.append("        FROM mae_clien_comun comunic, mae_tipo_comun tipocomunic ");
                buf.append("        WHERE comunic.ind_comu_ppal = 1 ");
                buf.append("        AND comunic.ticm_oid_tipo_comu = tipocomunic.oid_tipo_comu ");
                buf.append("        AND tipocomunic.cod_tipo_comu = 'TF' ");
                buf.append("        AND comunic.val_dia_comu = 'S' ");
                buf.append("       ) comunicdiapref ");
                buf.append("      ON reprog.clie_oid_clie = comunicdiapref.clie_oid_clie ");
                buf.append("   ) llamadasdia ");
            }
            */
            buf.append(" WHERE crono.oid_cron_cobr = asig.crco_oid_cron_cobr ");
            buf.append(" AND asig.pais_oid_pais = " + dto.getOidPais());
            buf.append(" AND asig.mvcc_oid_movi_cc = cuota.oid_movi_cc ");
            buf.append(" AND asig.IMP_DEUD_ASIG != asig.IMP_DEUD_CANC ");
            buf.append(" AND cuota.clie_oid_clie = cli.oid_clie ");
            buf.append(" AND clieua.CLIE_OID_CLIE = cuota.clie_oid_clie AND clieua.IND_ACTI = 1 ");
            buf.append(" AND ztadmin.OID_TERR_ADMI = clieua.ZTAD_OID_TERR_ADMI (+) ");
            buf.append(" AND zsecc.OID_SECC = ztadmin.ZSCC_OID_SECC(+) ");
            buf.append(" AND crono.perd_oid_peri = peri.oid_peri ");
            buf.append(" AND crono.usco_oid_usua_cobr = usucob.oid_usua_cobr ");
            buf.append(" AND usucob.user_oid_usua_cobr = users.iduser ");
            buf.append(" AND users.iduser = princip.idprincipal ");
            buf.append(" AND princip.NAME = '" + session.getCallerPrincipal().getName() + "' ");
            buf.append(" AND crono.etde_oid_etap_deud = eta.oid_etap_deud ");
            if(dto.getPeriodo()!=null){
              buf.append(" AND peri.OID_PERI = " + dto.getPeriodo());
            }
            if(dto.getCanal()!=null){
              buf.append(" AND peri.CANA_OID_CANA = " + dto.getCanal());  
            }
            if(dto.getMarca()!=null)
              buf.append(" AND peri.marc_oid_marc = " + dto.getMarca());
            if(dto.getEtapaDeuda()!=null){
              buf.append(" AND eta.OID_ETAP_DEUD = " + dto.getEtapaDeuda());
            }
            //if(dto.getOrdenacion()!=null && dto.getOrdenacion().intValue()==ConstantesCOB.OID_CRI_ORD_MAYOR_RIESGO)
            //  buf.append(" AND cli.OID_CLIE = datosAdic.CLIE_OID_CLIE ");
            if((dto.getTipoCliente()!=null) || (dto.getSubtipoCliente()!=null))  
                buf.append(" AND cli.OID_CLIE = cliTipoSubTipo.CLIE_OID_CLIE ");
            if(dto.getTipoCliente()!=null)
              buf.append(" AND cliTipoSubTipo.TICL_OID_TIPO_CLIE = " + dto.getTipoCliente()); 
            if(dto.getSubtipoCliente()!=null)
              buf.append(" AND cliTipoSubTipo.SBTI_OID_SUBT_CLIE = " + dto.getSubtipoCliente());  
            if(dto.getCodigoCliente()!=null)
              buf.append(" AND cli.COD_CLIE = '" + dto.getCodigoCliente() + "' ");  
            if(dto.getSubgerencia()!=null){
              buf.append(" AND crono.zsgv_oid_subg_vent = " + dto.getSubgerencia());
            }
            if(dto.getZona()!=null){
              buf.append(" AND crono.zzon_oid_zona = " + dto.getZona());  
            }
            if(dto.getRegion()!=null){
              buf.append(" AND crono.zorg_OID_REGI= " + dto.getRegion());
            }
            if(dto.getSeccion()!=null){
              buf.append(" AND crono.zscc_oid_secc = " + dto.getSeccion());  
            }

            /*
            if(dto.getOrdenacion()!=null) {
                if (dto.getOrdenacion().intValue()==ConstantesCOB.OID_CRI_ORD_ETAPA_DEUDA) {
                    buf.append(" AND eta.ORED_OID_ETAP_DEU1 = ordenEtapa1.OID_ORDE_ETAP_DEUD ");
                    buf.append(" AND eta.ORED_OID_ETAP_DEU2 = ordenEtapa2.OID_ORDE_ETAP_DEUD(+) ");
                    buf.append(" AND eta.ORED_OID_ETAP_DEU3 = ordenEtapa3.OID_ORDE_ETAP_DEUD(+) ");
                } else if (dto.getOrdenacion().intValue()==ConstantesCOB.OID_CRI_ORD_LLAMADA_DEL_DIA) {
                    buf.append(" AND cli.oid_clie = llamadasdia.clie_oid_clie ");
                }
            }
            */
            /*
            buf.append(" GROUP BY princip.NAME, ");
            buf.append(" eta.val_desc, ");
            buf.append(" cli.cod_clie, ");
            buf.append(" cli.val_ape1   || ' '  || cli.val_ape2      || ' '        || cli.val_nom1    || ' '  || cli.val_nom2, ");
            buf.append("  'TEL1' ,    ");
            buf.append("  'Tel2',  ");
            buf.append("  crono.tcab_oid_tipo_carg_abon, 'desctipoabono', ");
            if(dto.getMarca()!=null){
                buf.append( " " );
            } else {
                buf.append(" peri.marc_oid_marc, ");
            }
            buf.append(" 'des_marc', ");
            buf.append(" peri.cana_oid_cana,'desccanal' , ");
            buf.append(" peri.val_nomb_peri, ");
            buf.append(" crono.zsgv_oid_subg_vent , 'des_subg_vent', ");
            buf.append(" 'des_regi', ");
            buf.append(" 'des_zona',  ");
            buf.append(" crono.zscc_oid_secc ,'des_secci', ");
            buf.append(" 'cod_terr', ");
            buf.append(" crono.terr_oid_terr, ");
            buf.append(" asig.fec_asig, ");
            buf.append(" asig.imp_deud_asig, ");
            buf.append(" asig.esas_oid_esta_asig, 'descesta', ");
            buf.append(" eta.oid_etap_deud, ");
            buf.append(" peri.oid_peri, ");
            buf.append(" crono.usco_oid_usua_cobr, ");
            buf.append(" cuota.tcab_oid_tcab_ulti, ");
            buf.append(" cli.oid_clie, ");
            buf.append(" crono.zorg_oid_regi , ");
            buf.append(" crono.zzon_oid_zona ");
            buf.append(" ,peri.marc_oid_marc,peri.cana_oid_cana ");
            buf.append(" ,cuota.TCAB_OID_TCAB_CREA ");
            if(dto.getOrdenacion()!=null){
              if(dto.getOrdenacion().intValue()==ConstantesCOB.OID_CRI_ORD_CONS_NUEVAS) {
                buf.append(" , peri.FEC_INIC ");
                buf.append(" ORDER BY peri.FEC_INIC DESC ");
              } else if(dto.getOrdenacion().intValue()==ConstantesCOB.OID_CRI_ORD_CONS_INCID) {
                buf.append(" ORDER BY COUNT(asig.OID_ASIG_COBR) ");
              } else if(dto.getOrdenacion().intValue()==ConstantesCOB.OID_CRI_ORD_MAYOR_RIESGO) {
                 buf.append(" , datosAdic.NIRI_OID_NIVE_RIES ");
                 buf.append(" ORDER BY datosAdic.NIRI_OID_NIVE_RIES ");
              } else if(dto.getOrdenacion().intValue()==ConstantesCOB.OID_CRI_ORD_ETAPA_DEUDA) {
                 buf.append(" , ordenEtapa1.COD_ORDE_ETAP_DEUD ,ordenEtapa2.COD_ORDE_ETAP_DEUD ,ordenEtapa3.COD_ORDE_ETAP_DEUD  ");
                 buf.append(" ORDER BY ordenEtapa1.COD_ORDE_ETAP_DEUD DESC,ordenEtapa2.COD_ORDE_ETAP_DEUD DESC,ordenEtapa3.COD_ORDE_ETAP_DEUD DESC ");
              } else if (dto.getOrdenacion().intValue()==ConstantesCOB.OID_CRI_ORD_LLAMADA_DEL_DIA) {
                 buf.append(" , llamadasdia.fec_repr, llamadasdia.fec_hora_desd, llamadasdia.fec_hora_hast ");
                 buf.append(" ORDER BY llamadasdia.fec_repr, llamadasdia.fec_hora_desd, llamadasdia.fec_hora_hast ");
              } else if (dto.getOrdenacion().intValue()==ConstantesCOB.OID_CRI_ORD_MAYOR_SALDO_PEND) {
                 buf.append(" ORDER BY SUM (NVL (asig.imp_deud_asig, 0)) - SUM (NVL (asig.imp_deud_canc, 0)) ");
              }
            } 
            */
            
            respuesta = BelcorpService.getInstance().dbService.executeStaticQuery(buf.toString());
            
        } catch (Exception e) {
            throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS));
        }        
        
        if(respuesta!=null&&!respuesta.esVacio()){
            retorno = new DTOString();
            retorno.setCadena((BigDecimal)respuesta.getValueAt(0,0)+"|"+(BigDecimal)respuesta.getValueAt(0,1));
        }else{
            UtilidadesLog.info("DAOAsignacionesCobranza.obtenerTotalesAsignacionesCobranzaTC() : No se ha podido obtener totales Asignaciones Cobranza");
        }
        
        UtilidadesLog.debug("DAOAsignacionesCobranza.obtenerTotalesAsignacionesCobranzaTC(): retorno="+retorno.getCadena());
        UtilidadesLog.debug("DAOAsignacionesCobranza.obtenerTotalesAsignacionesCobranzaTC(): salida");
        return retorno;
    }
}