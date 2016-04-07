package es.indra.sicc.logicanegocio.cob;

import es.indra.belcorp.mso.CobEtapaDeudaData;

import es.indra.belcorp.mso.CobGuionArgumCabecViewData;
import es.indra.belcorp.mso.CobMetodLiquiViewData;
import es.indra.belcorp.mso.CobOrdenEtapaDeudaData;
import es.indra.belcorp.mso.CobTipoBalanData;
import es.indra.belcorp.mso.MsgMensaData;
import es.indra.belcorp.mso.SegPaisViewData;
import es.indra.mare.common.exception.MareException;

import es.indra.mare.common.mii.MareMiiServiceNotFoundException;
import es.indra.mare.common.mii.services.jdbcservice.RecordSet;
import es.indra.sicc.util.BelcorpService;
import es.indra.sicc.util.CodigosError;
import es.indra.sicc.util.UtilidadesEJB;
import es.indra.sicc.util.UtilidadesError;
import es.indra.sicc.util.UtilidadesLog;

import java.math.BigDecimal;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.Vector;

public class DAOEtapasDeDeuda {
    public DAOEtapasDeDeuda() {
    }
    
    public Vector query(CobEtapaDeudaData cobEtapaDeudaFrom, CobEtapaDeudaData cobEtapaDeudaTo, HashMap userProperties, Integer pageCount, Integer pageSize) throws MareException 
        {   UtilidadesLog.info("DAOCobEtapasDeuda.query(CobEtapaDeudaData cobEtapaDeudaFrom, CobEtapaDeudaData cobEtapaDeudaTo, HashMap userProperties, Integer pageCount, Integer pageSize):Entrada");
            
        
            if(pageCount == null)
            {
                pageCount = new Integer(1);
            }
            if(pageSize == null)
            {
                pageSize = new Integer(0x7fffffff);
            }
            
            RecordSet rs = new RecordSet();
            StringBuffer query = new StringBuffer();
            BelcorpService bs;
        
            try {
              bs = BelcorpService.getInstance();
            } catch (MareMiiServiceNotFoundException e) {
                UtilidadesLog.error("ERROR ", e);
                throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_PEDIR_UN_SERVICIO_MARE));
            }
            try{
        
            query.append(" SELECT a.oid_etap_deud, a.cod_etap_deud, a.VAL_DESC, a.val_edad_inic, ");
            query.append(" a.val_edad_fina, a.gaca_oid_guio_argu_cabe, a.imp_desd, a.imp_hast, ");
            query.append(" a.ind_excl, a.ind_telf, a.melc_oid_meto_liqu_cobr, a.mens_oid_mens,");
            query.append(" a.num_dias_grac_comp_pago, c.oid_orde_etap_deud, a.ored_oid_etap_deu2, ");
            query.append(" a.ored_oid_etap_deu3, b.oid_pais, a.tbal_oid_tipo_bala, a.val_porc_incu ");
            query.append(" FROM cob_etapa_deuda a, seg_pais b, cob_orden_etapa_deuda c");
            query.append(" WHERE a.pais_oid_pais = b.oid_pais ");
            query.append(" AND a.ored_oid_etap_deu1 = c.oid_orde_etap_deud ");
            
             if(cobEtapaDeudaFrom.getId()!= null){
                query.append(" AND oid_etap_deud = " + cobEtapaDeudaFrom.getId());
            }
             if(cobEtapaDeudaFrom.getValEdadInic()!= null){
                query.append(" AND val_edad_inic = " + cobEtapaDeudaFrom.getValEdadInic());
            }
            if(cobEtapaDeudaFrom.getValEdadFina()!= null)
            {
                query.append(" AND val_edad_fina = " + cobEtapaDeudaFrom.getValEdadFina() );
            }
            if(cobEtapaDeudaFrom.getCodEtapDeud()!= null)
            {
                query.append(" AND cod_etap_deud like '" + cobEtapaDeudaFrom.getCodEtapDeud() + "'");
            }
          
            if(cobEtapaDeudaFrom.getValDesc()!= null){
                query.append(" AND val_desc like '" + cobEtapaDeudaFrom.getValDesc() + "'");
            }
           
            
            }catch(Exception ex)
            {
              ex.printStackTrace();
            }
          try {
               rs = bs.dbService.executeStaticQuery(query.toString());
            } catch (Exception ex) {
              UtilidadesLog.error("ERROR ", ex);
              throw new MareException(ex, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS));
            }
            
            
            int cant = rs.getRowCount();
            Vector result = new Vector();
            CobEtapaDeudaData cobEtapasD = null;
            CobOrdenEtapaDeudaData cobOrden = null;
            CobOrdenEtapaDeudaData oidEtapDeu2 = null;
            CobOrdenEtapaDeudaData oidEtapDeu3 = null;
            MsgMensaData msg = null;
            CobMetodLiquiViewData cobMet = null;
            CobTipoBalanData cobTipo = null;
            SegPaisViewData segPais = null;
            CobGuionArgumCabecViewData guioArgu = null;
            //CarNivelRiesgData carNivelRiesgo = null;
            
            int rsSaltar = (pageCount.intValue() - 1) * pageSize.intValue();
            int rsMostrar = ((pageSize.intValue() == Integer.MAX_VALUE) ? pageSize.intValue() : (pageSize.intValue() + 1)) + rsSaltar;
            
            UtilidadesLog.debug("rsSaltar: " + rsSaltar);
            UtilidadesLog.debug("rsMostrar: " + rsMostrar);
            
            for(int i=0; i < cant; i++){
            
                if(i < rsSaltar ) {
                    continue;
                }
                
                if(i < rsMostrar){
                try{
                
                      cobEtapasD = new CobEtapaDeudaData();
                      BigDecimal indExcl, msg1, cobMet1, cobTipo1, guioArgu1, oidEtapDe2, oidEtapDe3 = null;
                      cobOrden = new CobOrdenEtapaDeudaData();
                      oidEtapDeu2 = new CobOrdenEtapaDeudaData();
                      oidEtapDeu3 = new CobOrdenEtapaDeudaData();
                      cobMet = new CobMetodLiquiViewData();
                      cobTipo = new CobTipoBalanData();
                      segPais = new SegPaisViewData();
                      msg = new MsgMensaData();
                      guioArgu = new CobGuionArgumCabecViewData();
        
                      
                                 
                      
                      
                      cobEtapasD.setId(Long.valueOf(((BigDecimal)rs.getValueAt(i,"OID_ETAP_DEUD")).toString())); 
                      cobEtapasD.setValEdadInic(Long.valueOf(((BigDecimal)rs.getValueAt(i,"VAL_EDAD_INIC")).toString()));
                      cobEtapasD.setValEdadFina(Long.valueOf(((BigDecimal)rs.getValueAt(i,"VAL_EDAD_FINA")).toString()));
                      cobEtapasD.setValDesc((String)rs.getValueAt(i,"VAL_DESC"));
                      cobEtapasD.setCodEtapDeud((String)rs.getValueAt(i,"COD_ETAP_DEUD"));
                      cobEtapasD.setImpDesd(Double.valueOf(((BigDecimal)rs.getValueAt(i,"IMP_DESD")).toString()));
                      cobEtapasD.setImpHast(Double.valueOf(((BigDecimal)rs.getValueAt(i,"IMP_HAST")).toString()));
                      cobEtapasD.setIndTelf(Long.valueOf(((BigDecimal)rs.getValueAt(i,"IND_TELF")).toString())); 
                      cobEtapasD.setNumDiasGracCompPago(Long.valueOf(((BigDecimal)rs.getValueAt(i,"NUM_DIAS_GRAC_COMP_PAGO")).toString()));
                      cobEtapasD.setValPorcIncu(Double.valueOf(((BigDecimal)rs.getValueAt(i,"VAL_PORC_INCU")).toString()));
                      cobOrden.setId(Long.valueOf(((BigDecimal)rs.getValueAt(i,"OID_ORDE_ETAP_DEUD")).toString()));
                      cobEtapasD.setOredOidEtapDeu1(cobOrden);
                      segPais.setId(Long.valueOf(((BigDecimal)rs.getValueAt(i,"OID_PAIS")).toString()));
                      cobEtapasD.setPaisOidPais(segPais);
                      indExcl = (BigDecimal)rs.getValueAt(i,"IND_EXCL");
                      if(indExcl != null)
                      {
                            cobEtapasD.setIndExcl(Long.valueOf(indExcl.toString()));
                      }
                      msg1 = (BigDecimal)rs.getValueAt(i,"MENS_OID_MENS");
                      if(msg1 != null)
                      {
                           msg.setId(Long.valueOf(msg1.toString()));
                           msg.setDesMens(String.valueOf(msg1));
                           cobEtapasD.setMensOidMens(msg);
                      }
                      cobMet1 = (BigDecimal)rs.getValueAt(i,"MELC_OID_METO_LIQU_COBR");
                       if(cobMet1 != null)
                       {
                           cobMet.setId(Long.valueOf(cobMet1.toString())); 
                           cobEtapasD.setMelcOidMetoLiquCobr(cobMet);
                       }
                      cobTipo1 = (BigDecimal)rs.getValueAt(i,"TBAL_OID_TIPO_BALA");
                      if(cobTipo1 != null)
                      {
                            cobTipo.setId(Long.valueOf(cobTipo1.toString()));
                          cobEtapasD.setTbalOidTipoBala(cobTipo);
                      }
                      guioArgu1 = (BigDecimal)rs.getValueAt(i,"GACA_OID_GUIO_ARGU_CABE");
                      if(guioArgu1 != null)
                      {
                          guioArgu.setId(Long.valueOf(guioArgu1.toString()));
                          cobEtapasD.setGacaOidGuioArguCabe(guioArgu);
                      }
                     oidEtapDe2 = (BigDecimal)rs.getValueAt(i,"ORED_OID_ETAP_DEU2");
                      if(oidEtapDe2 != null)
                      {
                            oidEtapDeu2.setId(Long.valueOf(oidEtapDe2.toString()));
                          cobEtapasD.setOredOidEtapDeu2(oidEtapDeu2);
                      }
                      oidEtapDe3 = (BigDecimal)rs.getValueAt(i,"ORED_OID_ETAP_DEU3");
                      if(oidEtapDe3 != null)
                      {
                            oidEtapDeu3.setId(Long.valueOf(oidEtapDe3.toString()));                  
                          cobEtapasD.setOredOidEtapDeu3(oidEtapDeu3);
                      }
                      
                                        
                                   
                      result.add(cobEtapasD);
                      
                }catch(Exception ex)
                {
                  ex.printStackTrace();
                }
                } else {
                   break;
                }
                
        }
        
        UtilidadesLog.info("DAOCobEtapasDeuda.query(CobEtapaDeudaData cobEtapaDeudaFrom, CobEtapaDeudaData cobEtapaDeudaTo, HashMap userProperties, Integer pageCount, Integer pageSize): Salida");   
            return result;
        }
        
        public Vector query(CobOrdenEtapaDeudaData cobOrdenEtapaDeudaFrom, CobOrdenEtapaDeudaData cobOrdenEtapaDeudaTo, HashMap userProperties) throws MareException
        {   UtilidadesLog.info("DAOCobEtapasDeuda.query(CobOrdenEtapaDeudaData cobOrdenEtapaDeudaFrom, CobOrdenEtapaDeudaData cobOrdenEtapaDeudaTo, HashMap userProperties):Entrada");
        
            RecordSet rs = new RecordSet();
            StringBuffer query = new StringBuffer();
            BelcorpService bs;
            Vector resultado = new Vector();
            
        try {
              bs = BelcorpService.getInstance();
          } catch (MareMiiServiceNotFoundException e) {
              UtilidadesLog.error("ERROR ", e);
              throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_PEDIR_UN_SERVICIO_MARE));
        }
        
        query.append(" SELECT a.oid_orde_etap_deud, a.cod_orde_etap_deud, b.val_i18n, b.val_oid ");
        query.append(" FROM cob_orden_etapa_deuda a, gen_i18n_sicc_comun b ");
        query.append(" WHERE b.attr_enti = 'COB_ORDEN_ETAPA_DEUDA' ");
        query.append(" AND b.attr_num_atri = 1 ");
        query.append(" AND b.idio_oid_idio = 1 ");
        query.append(" AND b.val_oid = a.oid_orde_etap_deud");
        
        
        
        try {
              rs = bs.dbService.executeStaticQuery(query.toString());
          } catch (Exception ex) {
              UtilidadesLog.error("ERROR ", ex);
              throw new MareException(ex, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS));
          }
        int cant = rs.getRowCount();
          
        
         CobOrdenEtapaDeudaData cobOrdenEta = null;
          
          for(int i=0; i < cant; i++){
             
              cobOrdenEta  = new CobOrdenEtapaDeudaData();
              
              cobOrdenEta.setId(Long.valueOf(((BigDecimal)rs.getValueAt(i,"OID_ORDE_ETAP_DEUD")).toString()));
              cobOrdenEta.setCodOrdeEtapDeud((String)rs.getValueAt(i,"COD_ORDE_ETAP_DEUD"));
              cobOrdenEta.setDescripcion((String)rs.getValueAt(i,"VAL_I18N"));
             
              
              resultado.add(cobOrdenEta);
          }
        
        
            UtilidadesLog.info("DAOCobEtapasDeuda.query(CobOrdenEtapaDeudaData cobOrdenEtapaDeudaFrom, CobOrdenEtapaDeudaData cobOrdenEtapaDeudaTo, HashMap userProperties):Salida");
            return resultado;
        }
            
         public Vector query(MsgMensaData msgMensaFrom, MsgMensaData msgMensaTo, HashMap userProperties) throws MareException
        {   UtilidadesLog.info("DAOCobEtapasDeuda.query(MsgMensaData msgMensaFrom, MsgMensaData msgMensaTo, HashMap userProperties):Entrada");
        
            RecordSet rs = new RecordSet();
            StringBuffer query = new StringBuffer();
            BelcorpService bs;
            Vector resultado = new Vector();
            
        try {
              bs = BelcorpService.getInstance();
          } catch (MareMiiServiceNotFoundException e) {
              UtilidadesLog.error("ERROR ", e);
              throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_PEDIR_UN_SERVICIO_MARE));
        }
        
        query.append(" SELECT OID_MENS, DES_MENS ");
        query.append(" FROM MSG_MENSA ");
        
          
        try {
              rs = bs.dbService.executeStaticQuery(query.toString());
          } catch (Exception ex) {
              UtilidadesLog.error("ERROR ", ex);
              throw new MareException(ex, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS));
          }
        int cant = rs.getRowCount();
          
        
        MsgMensaData msgMensa = null;
          
          for(int i=0; i < cant; i++){
             
              msgMensa  = new MsgMensaData();
              
              msgMensa.setId(Long.valueOf(((BigDecimal)rs.getValueAt(i,"OID_MENS")).toString()));
              msgMensa.setDesMens((String)rs.getValueAt(i,"DES_MENS"));
              
             
              
              resultado.add(msgMensa);
          }
        
        
            UtilidadesLog.info("DAOCobEtapasDeuda.query(MsgMensaData msgMensaFrom, MsgMensaData msgMensaTo, HashMap userProperties):Salida");
            return resultado;
        }
        
        public Vector query(CobTipoBalanData cobTipoBalanFrom, CobTipoBalanData cobTipoBalanTo, HashMap userProperties) throws MareException
        {   UtilidadesLog.info("DAOCobEtapasDeuda.query(CobTipoBalanData cobTipoBalanFrom, CobTipoBalanData cobTipoBalanTo, HashMap userProperties):Entrada");
            
            RecordSet rs = new RecordSet();
            StringBuffer query = new StringBuffer();
            BelcorpService bs;
            Vector resultado = new Vector();
            
        try {
              bs = BelcorpService.getInstance();
          } catch (MareMiiServiceNotFoundException e) {
              UtilidadesLog.error("ERROR ", e);
              throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_PEDIR_UN_SERVICIO_MARE));
        }
        
        query.append(" SELECT b.OID_TIPO_BALA, b.COD_TIPO_BALA, c.VAL_I18N ");
        query.append(" FROM COB_TIPO_BALAN b, GEN_I18N_SICC_COMUN c ");
        query.append(" WHERE C.ATTR_ENTI = 'COB_TIPO_BALAN'");
        query.append(" AND c.ATTR_NUM_ATRI = 1 ");
        query.append(" AND c.IDIO_OID_IDIO = 1 ");
        query.append(" AND c.VAL_OID = b.OID_TIPO_BALA ");
        


        try {
              rs = bs.dbService.executeStaticQuery(query.toString());
          } catch (Exception ex) {
              UtilidadesLog.error("ERROR ", ex);
              throw new MareException(ex, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS));
          }
        int cant = rs.getRowCount();
          
        
        CobTipoBalanData cobTipoBalan = null;
          
          for(int i=0; i < cant; i++){
             
              cobTipoBalan  = new CobTipoBalanData();
              
              cobTipoBalan.setId(Long.valueOf(((BigDecimal)rs.getValueAt(i,"OID_TIPO_BALA")).toString()));
              cobTipoBalan.setCodTipoBala((String)rs.getValueAt(i,"COD_TIPO_BALA"));
              cobTipoBalan.setDescripcion((String)rs.getValueAt(i,"VAL_I18N"));
             
              
              resultado.add(cobTipoBalan);
          }
        
             UtilidadesLog.info("DAOCobEtapasDeuda.query(CobTipoBalanData cobTipoBalanFrom, CobTipoBalanData cobTipoBalanTo, HashMap userProperties):Salida");
            
            return resultado;
        }
          public Vector query(CobGuionArgumCabecViewData cobGuionArgumCabecViewFrom, CobGuionArgumCabecViewData cobGuionArgumCabecViewTo, HashMap userProperties) throws MareException
        {   UtilidadesLog.info("DAOCobEtapasDeuda.query(CobGuionArgumCabecViewData cobGuionArgumCabecViewFrom, CobGuionArgumCabecViewData cobGuionArgumCabecViewTo, HashMap userProperties):Entrada");
        
             RecordSet rs = new RecordSet();
            StringBuffer query = new StringBuffer();
            BelcorpService bs;
            Vector resultado = new Vector();
            
        try {
              bs = BelcorpService.getInstance();
          } catch (MareMiiServiceNotFoundException e) {
              UtilidadesLog.error("ERROR ", e);
              throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_PEDIR_UN_SERVICIO_MARE));
        }
        
        query.append(" SELECT a.oid_guio_argu_cabe, a.cod_guia_argu, c.OID_PAIS, a.val_obse, ");
        query.append(" b.val_i18n ");
        query.append(" FROM cob_guion_argum_cabec a, gen_i18n_sicc_pais b, SEG_PAIS c");
        query.append(" WHERE b.attr_enti = 'COB_GUION_ARGUM_CABEC'");
        query.append(" AND b.attr_num_atri = 1 ");
        query.append(" AND b.idio_oid_idio = 1 ");
        query.append(" AND b.VAL_OID = a.OID_GUIO_ARGU_CABE ");
        query.append(" and c.OID_PAIS = a.PAIS_OID_PAIS");
        


        try {
              rs = bs.dbService.executeStaticQuery(query.toString());
          } catch (Exception ex) {
              UtilidadesLog.error("ERROR ", ex);
              throw new MareException(ex, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS));
          }
        int cant = rs.getRowCount();
          
        SegPaisViewData segPais = null;
        CobGuionArgumCabecViewData cobGuion = null;
          
          for(int i=0; i < cant; i++){
             
              cobGuion   = new CobGuionArgumCabecViewData();
              segPais = new SegPaisViewData();
              
              cobGuion.setId(Long.valueOf(((BigDecimal)rs.getValueAt(i,"OID_GUIO_ARGU_CABE")).toString()));
              cobGuion.setCodGuiaArgu((String)rs.getValueAt(i,"COD_GUIA_ARGU"));
              cobGuion.setDescripcion((String)rs.getValueAt(i,"VAL_I18N"));
              cobGuion.setValObse((String)rs.getValueAt(i,"VAL_OBSE"));
              segPais.setId(Long.valueOf(((BigDecimal)rs.getValueAt(i,"OID_PAIS")).toString()));
              cobGuion.setPaisOidPais(segPais);
              
              resultado.add(cobGuion);
          }
        
        
            UtilidadesLog.info("DAOCobEtapasDeuda.query(CobGuionArgumCabecViewData cobGuionArgumCabecViewFrom, CobGuionArgumCabecViewData cobGuionArgumCabecViewTo, HashMap userProperties):Entrada");
            return resultado;
        }
        
         public void remove(Vector entities) throws MareException
        {   UtilidadesLog.info("DAOCobEtapasDeuda.remove(Vector entities):Entrada");
            
            RecordSet rs = null;
            BelcorpService bs = UtilidadesEJB.getBelcorpService();
            StringBuffer update = new StringBuffer();
            
            
            int cant = entities.size();
            CobEtapaDeudaData cobEtaDeu = null;
            String oids = "";
            
            for (int j = 0; j < cant; j++) {
                cobEtaDeu = (CobEtapaDeudaData)entities.get(j);
                 
                oids = oids + "," + cobEtaDeu.getId();
            }
            
            update.append("delete cob_etapa_deuda ");
            update.append("where OID_ETAP_DEUD in ( " + oids.substring(1) + ") ");
            
                   
            try {
                int cantRegActualizados = bs.dbService.executeUpdate(update.toString());
               
                
            } catch (Exception ex) {
                ex.printStackTrace();
                
                if(ex.toString().indexOf("ORA-02292")!= -1) {
                    throw new MareException(ex, UtilidadesError.armarCodigoError(
                                        CodigosError.ERROR_DE_BORRADO_DE_DATOS));
                } else {
                    throw new MareException(ex, UtilidadesError.armarCodigoError(
                                        CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS));
                }            
            }
            
        
            UtilidadesLog.info("DAOCobEtapasDeuda.remove(Vector entities):Salida");
        }
        public void update(CobEtapaDeudaData cobEtapaDeuda, Vector localizationLabels) throws MareException
        {   UtilidadesLog.info("DAOCobEtapasDeuda.update(CobEtapaDeudaData cobEtapaDeuda, Vector localizationLabels):Entrada");
        
             RecordSet rs = null;
            BelcorpService bs = UtilidadesEJB.getBelcorpService();
            
            StringBuffer update = new StringBuffer();
                    
            update.append(" UPDATE  COB_ETAPA_DEUDA SET ");
            update.append(" cod_etap_deud = '" + cobEtapaDeuda.getCodEtapDeud() + "',");
            update.append(" VAL_DESC = '"+ cobEtapaDeuda.getValDesc() + "',");
            update.append(" val_edad_inic = " + cobEtapaDeuda.getValEdadInic() + ",");
            update.append(" val_edad_fina = " + cobEtapaDeuda.getValEdadFina() + ",");
            update.append(" ind_telf = " + cobEtapaDeuda.getIndTelf() + ",");
            update.append(" imp_desd = " + cobEtapaDeuda.getImpDesd() + ",");
            update.append(" imp_hast = " + cobEtapaDeuda.getImpHast() + ",");
            update.append(" num_dias_grac_comp_pago = " + cobEtapaDeuda.getNumDiasGracCompPago() + ",");
            update.append(" val_porc_incu = " + cobEtapaDeuda.getValPorcIncu() + ",");
            update.append(" ored_oid_etap_deu1 = " + cobEtapaDeuda.getOredOidEtapDeu1().getId() + ",");
            
           
            if(cobEtapaDeuda.getIndExcl()!= null)
            {
                update.append(" ind_excl = " + cobEtapaDeuda.getIndExcl() + ",");
            }
               else {
                update.append(" ind_excl = NULL," );
                } 
                
            if(cobEtapaDeuda.getMensOidMens()!= null)
            {
                update.append(" mens_oid_mens = " + cobEtapaDeuda.getMensOidMens().getId() + ",");
            }
            else
            {
                update.append(" mens_oid_mens = NULL,");
            }
            if(cobEtapaDeuda.getMelcOidMetoLiquCobr() != null)
            {
                update.append(" melc_oid_meto_liqu_cobr = " + cobEtapaDeuda.getMelcOidMetoLiquCobr().getId() + ",");
            }
            else
            {
                update.append(" melc_oid_meto_liqu_cobr = NULL,");
            }
            if(cobEtapaDeuda.getTbalOidTipoBala()!= null)
            {
                update.append(" tbal_oid_tipo_bala = " + cobEtapaDeuda.getTbalOidTipoBala().getId() + ",");
            }
            else
            {
                update.append(" tbal_oid_tipo_bala = NULL,");
            }
            if(cobEtapaDeuda.getGacaOidGuioArguCabe()!= null)
            {
                update.append( " gaca_oid_guio_argu_cabe = " + cobEtapaDeuda.getGacaOidGuioArguCabe().getId() + ",");
            }
            else
            {
                update.append(" gaca_oid_guio_argu_cabe = NULL,");
            }
            if(cobEtapaDeuda.getOredOidEtapDeu2()!= null)
            {
                update.append(" ored_oid_etap_deu2 = "  +  cobEtapaDeuda.getOredOidEtapDeu2().getId() + ",");
              
            }
            else
            {
                update.append(" ored_oid_etap_deu2 = NULL,");
            }
            if(cobEtapaDeuda.getOredOidEtapDeu3()!= null)
            {
                update.append(" ored_oid_etap_deu3 = " + cobEtapaDeuda.getOredOidEtapDeu3().getId());
            }
            else
            {
                update.append(" ored_oid_etap_deu3 = NULL");
            }
            
                update.append(" WHERE OID_ETAP_DEUD = " + cobEtapaDeuda.getId());
            
            try {
                int cantRegActualizados = bs.dbService.executeUpdate(update.toString());
            } catch (Exception ex) {
                ex.printStackTrace();
                throw new MareException(ex, UtilidadesError.armarCodigoError(
                                        CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS));
            }
        
        
        UtilidadesLog.info("DAOCobEtapasDeuda.update(CobEtapaDeudaData cobEtapaDeuda, Vector localizationLabels):Salida");
        
        }
         public Hashtable guardar(CobEtapaDeudaData cobEtapaDeuda, Vector localizationLabels, HashMap userProperties) throws MareException
        {   UtilidadesLog.info("DAOCobEtapasDeuda.guardar(CobEtapaDeudaData cobEtapaDeuda, Vector localizationLabels, HashMap userProperties):Entrada");
            RecordSet rs = null;
            BelcorpService bs = UtilidadesEJB.getBelcorpService();
            
            StringBuffer update = new StringBuffer();
            
            RecordSet rsPK = null;
            StringBuffer query = new StringBuffer();      
            Long id = null;
            
            query.append(" SELECT COB_ETDE_SEQ.NEXTVAL FROM DUAL");         
            
            try {
                rsPK = bs.dbService.executeStaticQuery(query.toString());
                    
            } catch (Exception ex) {
                ex.printStackTrace();
                throw new MareException(ex, UtilidadesError.armarCodigoError(
                                        CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS));
            }
            
            if(rsPK != null && !rsPK.esVacio()) {
                id = Long.valueOf(((BigDecimal)rsPK.getValueAt(0,0)).toString());
            }        
          update.append(" INSERT INTO COB_ETAPA_DEUDA ( ");
          update.append(" OID_ETAP_DEUD, ");
          update.append(" cod_etap_deud, ");
          update.append(" VAL_DESC,");
          update.append(" val_edad_inic, ");
          update.append(" val_edad_fina, ");
          update.append(" ind_telf, ");
          update.append(" imp_desd, ");
          update.append(" imp_hast, ");
          update.append(" num_dias_grac_comp_pago, ");
          update.append(" val_porc_incu, ");
          update.append(" ored_oid_etap_deu1, ");
          update.append(" ind_excl,");
          update.append(" mens_oid_mens,");
          update.append(" melc_oid_meto_liqu_cobr,");
          update.append(" tbal_oid_tipo_bala,");
          update.append(" gaca_oid_guio_argu_cabe,");
          update.append(" pais_oid_pais,");
          update.append(" ored_oid_etap_deu2,");
          update.append(" ored_oid_etap_deu3");
          update.append(" ) VALUES ( ");
          update.append(id + ", ");
          update.append("'" + cobEtapaDeuda.getCodEtapDeud() + "', ");
          update.append("'" + cobEtapaDeuda.getValDesc() + "', ");
          update.append(cobEtapaDeuda.getValEdadInic() + ", ");
          update.append(cobEtapaDeuda.getValEdadFina() + ",");
          update.append(cobEtapaDeuda.getIndTelf() + "," );
          update.append(cobEtapaDeuda.getImpDesd() + ",");
          update.append(cobEtapaDeuda.getImpHast() + ",");
          update.append(cobEtapaDeuda.getNumDiasGracCompPago() + ",");
          update.append(cobEtapaDeuda.getValPorcIncu() + ",");
          update.append(cobEtapaDeuda.getOredOidEtapDeu1().getId());
          
          
            if(cobEtapaDeuda.getIndExcl()!= null)
            {
              update.append("," + cobEtapaDeuda.getIndExcl());
            }
            else 
            {
              update.append(", NULL");
            }
            if(cobEtapaDeuda.getMensOidMens()!=null)
            {
              update.append("," + cobEtapaDeuda.getMensOidMens().getId());
            }
            else
            {
              update.append(", NULL");
            }
            if(cobEtapaDeuda.getMelcOidMetoLiquCobr()!= null)
            {
              update.append("," + cobEtapaDeuda.getMelcOidMetoLiquCobr().getId());
            }
            else
            {
              update.append(", NULL");
            }
            if(cobEtapaDeuda.getTbalOidTipoBala()!= null)
            {
              update.append("," + cobEtapaDeuda.getTbalOidTipoBala().getId());
            }
            else
            {
              update.append(", NULL");
            }
            if(cobEtapaDeuda.getGacaOidGuioArguCabe()!= null)
            {
              update.append(", " + cobEtapaDeuda.getGacaOidGuioArguCabe().getId());
            }
            else
            {
              update.append(", NULL");
            }
            if(cobEtapaDeuda.getPaisOidPais()!=null)
            {
                update.append(", " + cobEtapaDeuda.getPaisOidPais().getId());
            }
            else
            {
                update.append(", NULL");
            }
           
            if(cobEtapaDeuda.getOredOidEtapDeu2()!= null)
            {
              update.append(", " + cobEtapaDeuda.getOredOidEtapDeu2().getId());
            }
            else
            {
              update.append(", NULL");
            }
              if(cobEtapaDeuda.getOredOidEtapDeu3()!= null)
            {
              update.append(", " + cobEtapaDeuda.getOredOidEtapDeu3().getId());
            }
            else
            {
              update.append(", NULL");
            }
          
          
           update.append(" ) ");
          
          
           try {
                int cantRegActualizados = bs.dbService.executeUpdate(update.toString());
            } catch (Exception ex) {
                ex.printStackTrace();
                
                if(ex.toString().indexOf("ORA-00001")!= -1) {
                    throw new MareException(ex, UtilidadesError.armarCodigoError(
                                        CodigosError.ERROR_DE_CLAVE_DUPLICADA));
                } else {
                    throw new MareException(ex, UtilidadesError.armarCodigoError(
                                        CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS));
                }
            }
            
            Hashtable primaryKey = new Hashtable();
            primaryKey.put("id", id);
        
        
            UtilidadesLog.info("DAOCobEtapasDeuda.guardar(CobEtapaDeudaData cobEtapaDeuda, Vector localizationLabels, HashMap userProperties):Salida");
            return primaryKey;
        }
        
        
    }

