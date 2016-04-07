package es.indra.sicc.logicanegocio.cob;

import es.indra.belcorp.mso.CobAccioCobraData;

import es.indra.belcorp.mso.CobSubtiAccioData;
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

public class DAOAccionesDeCobranza {
    public DAOAccionesDeCobranza() {
    }
    
    public Vector query(CobAccioCobraData cobAccioCobraFrom, CobAccioCobraData cobAccioCobraTo, HashMap userProperties, Integer pageCount, Integer pageSize) throws MareException
        {
           
            UtilidadesLog.info("DAOAccionDeCobranza.query(CobAccioCobraData cobAccioCobraFrom, CobAccioCobraData cobAccioCobraTo, HashMap userProperties, Integer pageCount, Integer pageSize): Entrada");
        
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
        
            query.append(" SELECT a.OID_ACCI_COBR, a.COD_ACCI_COBR, a.VAL_DESC, b.OID_SUBT_ACCI, c.OID_PAIS, ");
            query.append(" a.ind_fech_hora_segu, a.ind_fech_impo_comp, a.ind_fech_hora_nuev_segu, ");
            query.append(" a.ind_apor_prue, a.ind_desc_prue, a.ind_nume_docu_sopo,");
            query.append(" a.ind_tipo_docu_pago, a.ind_banc_sucu, a.ind_nuev_dire,");
            query.append(" a.ind_nuev_telf, a.ind_pasa_admi, a.ind_peti_bloq_admi,");
            query.append(" a.ind_peti_desb_admi, a.ind_acci_mens_reco, a.ind_obse, a.val_obse");
            query.append(" FROM cob_accio_cobra a, cob_subti_accio b, SEG_PAIS c ");
            query.append(" WHERE a.sacc_oid_subt_acci = b.oid_subt_acci AND a.pais_oid_pais = c.oid_pais ");
            
            
            if(cobAccioCobraFrom.getId()!= null)
            {
                query.append(" AND a.OID_ACCI_COBR = " + cobAccioCobraFrom.getId());
            }
            if (cobAccioCobraFrom.getCodAcciCobr()!= null)
            {
                 query.append(" AND a.COD_ACCI_COBR like '" + cobAccioCobraFrom.getCodAcciCobr() + "'");
            }
            if(cobAccioCobraFrom.getValDesc()!= null)
            {
                query.append(" AND a.VAL_DESC like '" + cobAccioCobraFrom.getValDesc() + "'");
            }
            if(cobAccioCobraFrom.getIndFechHoraSegu() != null)
            {
                 query.append(", AND ind_fech_hora_segu = " + cobAccioCobraFrom.getIndFechHoraSegu() );
            }
            if(cobAccioCobraFrom.getIndFechImpoComp()!= null)
            {
                 query.append(", AND ind_fech_impo_comp = " + cobAccioCobraFrom.getIndFechImpoComp() );
            }
            if(cobAccioCobraFrom.getIndFechHoraNuevSegu()!= null)
            {
                 query.append(", AND ind_fech_hora_nuev_segu = " + cobAccioCobraFrom.getIndFechHoraNuevSegu());
            }
            if(cobAccioCobraFrom.getIndAporPrue()!= null)
            {
                 query.append(", AND ind_apor_prue = " + cobAccioCobraFrom.getIndAporPrue());
            }
            if(cobAccioCobraFrom.getIndDescPrue()!= null)
            {
                 query.append(", AND ind_desc_prue = " + cobAccioCobraFrom.getIndDescPrue() );
            }
            if(cobAccioCobraFrom.getIndNumeDocuSopo()!= null)
            {
                 query.append(", AND ind_nume_docu_sopo = " + cobAccioCobraFrom.getIndNumeDocuSopo() );
            }
            if(cobAccioCobraFrom.getIndTipoDocuPago()!= null)
            {
                 query.append(", AND ind_tipo_docu_pago = " + cobAccioCobraFrom.getIndTipoDocuPago() );
            }
            
           if(cobAccioCobraFrom.getIndBancSucu()!= null)
           {
                 query.append(", AND ind_banc_sucu = " + cobAccioCobraFrom.getIndBancSucu());
           }
            if(cobAccioCobraFrom.getIndNuevDire()!= null)
            {
                 query.append(", AND ind_nuev_dire = " + cobAccioCobraFrom.getIndNuevDire());
            }
            if(cobAccioCobraFrom.getIndNuevTelf()!= null)
            {
                 query.append(", AND ind_nuev_telf = " + cobAccioCobraFrom.getIndNuevTelf());
            }
            if(cobAccioCobraFrom.getIndPasaAdmi()!= null)
            {
                 query.append(", AND ind_pasa_admi = " + cobAccioCobraFrom.getIndPasaAdmi());
            }
            
            if(cobAccioCobraFrom.getIndPetiBloqAdmi()!= null)
            {
                query.append(", AND ind_peti_bloq_admi = " + cobAccioCobraFrom.getIndPetiBloqAdmi());
            }
          
            if(cobAccioCobraFrom.getIndPetiDesbAdmi()!= null)
            {
                query.append(", AND ind_peti_desb_admi = " + cobAccioCobraFrom.getIndPetiDesbAdmi());
            }
          
            if(cobAccioCobraFrom.getIndAcciMensReco()!= null)
            {
                query.append(", AND ind_acci_mens_reco = " + cobAccioCobraFrom.getIndAcciMensReco());
            }
          
            if(cobAccioCobraFrom.getIndObse() != null)
            {
                query.append(", AND ind_obse = '" + cobAccioCobraFrom.getIndObse() + "'");
            }

            if(cobAccioCobraFrom.getValObse() != null)
            {
                query.append(", AND val_obse = '" + cobAccioCobraFrom.getValObse() + "'");
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
            
            CobAccioCobraData cobAccionCob = null;
            CobSubtiAccioData cobSubtiAcc = null;
            SegPaisViewData segPais = null;
            
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
                      cobAccionCob= new CobAccioCobraData();
                      cobSubtiAcc = new CobSubtiAccioData();
                      segPais = new SegPaisViewData();
                      BigDecimal fechaHoraSe = null;
                      BigDecimal fechimpocomp = null;
                      BigDecimal fechHoraNSegu, aporPrue, descPrue, numeDocuSopo, tipoDocuPago, bancSucu = null;
                      BigDecimal indNuevDire, nuevTelf, pasaAdmi, indPetiBloqAdmi = null;
                      BigDecimal petiDesbAdmi, acciMensReco, obse = null;
                      
                      String valObse;
                      
                      fechaHoraSe = (BigDecimal)rs.getValueAt(i,"IND_FECH_HORA_SEGU");
                        if(fechaHoraSe != null){
                            
                            cobAccionCob.setIndFechHoraSegu(Long.valueOf(fechaHoraSe.toString()));
                        }
                      
                      fechimpocomp = (BigDecimal)rs.getValueAt(i,"IND_FECH_IMPO_COMP");
                        if(fechimpocomp!= null)
                        {
                            cobAccionCob.setIndFechImpoComp(Long.valueOf(fechimpocomp.toString()));
                        }
                        
                       fechHoraNSegu = (BigDecimal)rs.getValueAt(i,"IND_FECH_HORA_NUEV_SEGU");
                        if( fechHoraNSegu!= null)
                        {
                            cobAccionCob.setIndFechHoraNuevSegu(Long.valueOf( fechHoraNSegu.toString()));
                        }
                      
                       aporPrue = (BigDecimal)rs.getValueAt(i,"IND_APOR_PRUE");
                        if( aporPrue!= null)
                        {
                            cobAccionCob.setIndAporPrue(Long.valueOf( aporPrue.toString()));
                        }
                        descPrue = (BigDecimal)rs.getValueAt(i,"IND_DESC_PRUE");
                         if( descPrue!= null)
                        {
                            cobAccionCob.setIndDescPrue(Long.valueOf( descPrue.toString()));
                        }
                        numeDocuSopo = (BigDecimal)rs.getValueAt(i,"IND_NUME_DOCU_SOPO");
                        
                         if( numeDocuSopo!= null)
                        {
                            cobAccionCob.setIndNumeDocuSopo(Long.valueOf( numeDocuSopo.toString()));
                        }
                        tipoDocuPago = (BigDecimal)rs.getValueAt(i,"IND_TIPO_DOCU_PAGO");
                         if( tipoDocuPago!= null)
                        {
                            cobAccionCob.setIndTipoDocuPago(Long.valueOf( tipoDocuPago.toString()));
                        }
                        bancSucu = (BigDecimal)rs.getValueAt(i,"IND_BANC_SUCU");
                        if( bancSucu!= null)
                        {
                            cobAccionCob.setIndBancSucu(Long.valueOf( bancSucu.toString()));
                        }
                        indNuevDire = (BigDecimal)rs.getValueAt(i,"IND_NUEV_DIRE");
                        if( indNuevDire!= null)
                        {
                            cobAccionCob.setIndNuevDire(Long.valueOf(indNuevDire.toString()));
                        }
                        nuevTelf = (BigDecimal)rs.getValueAt(i,"IND_NUEV_TELF");
                        
                        if(  nuevTelf!= null)
                        {
                            cobAccionCob.setIndNuevTelf(Long.valueOf(nuevTelf.toString()));
                        }
                        
                        pasaAdmi = (BigDecimal)rs.getValueAt(i,"IND_PASA_ADMI");
                        if( pasaAdmi!= null)
                        {
                            cobAccionCob.setIndPasaAdmi(Long.valueOf(pasaAdmi.toString()));
                        }
                        indPetiBloqAdmi = (BigDecimal)rs.getValueAt(i,"IND_PETI_BLOQ_ADMI");
                        if(indPetiBloqAdmi!= null)
                        {
                            cobAccionCob.setIndPetiBloqAdmi(Long.valueOf(indPetiBloqAdmi.toString()));
                        }
                        petiDesbAdmi = (BigDecimal)rs.getValueAt(i,"IND_PETI_DESB_ADMI");
                        if( petiDesbAdmi!= null)
                        {
                            cobAccionCob.setIndPetiDesbAdmi(Long.valueOf(petiDesbAdmi.toString()));
                        }
                        acciMensReco = (BigDecimal)rs.getValueAt(i,"IND_ACCI_MENS_RECO");
                        if( acciMensReco!= null)
                        {
                            cobAccionCob.setIndPasaAdmi(Long.valueOf(acciMensReco.toString()));
                        }
                        obse = (BigDecimal)rs.getValueAt(i,"IND_OBSE"); 
                         if( obse != null)
                        {
                            cobAccionCob.setIndObse(Long.valueOf(obse.toString()));
                        }
                        
                        valObse = (String)rs.getValueAt(i,"VAL_OBSE");
                        if( valObse != null)
                        {
                            cobAccionCob.setValObse(String.valueOf(valObse.toString()));
                        }
                        
                        
                      
                      
                      cobAccionCob.setId(Long.valueOf(((BigDecimal)rs.getValueAt(i,"OID_ACCI_COBR")).toString())); 
                      cobAccionCob.setCodAcciCobr((String)rs.getValueAt(i,"COD_ACCI_COBR"));
                      cobAccionCob.setValDesc((String)rs.getValueAt(i,"VAL_DESC"));
                      cobSubtiAcc.setId(Long.valueOf(((BigDecimal)rs.getValueAt(i,"OID_SUBT_ACCI")).toString()));
                      cobAccionCob.setSaccOidSubtAcci(cobSubtiAcc);
                      segPais.setId(Long.valueOf(((BigDecimal)rs.getValueAt(i,"OID_PAIS")).toString()));
                      cobAccionCob.setPaisOidPais(segPais);
                                       
                      result.add(cobAccionCob);
                      
                }catch(Exception ex)
                {
                  ex.printStackTrace();
                }
                } else {
                   break;
                }
            
                 
        }
        UtilidadesLog.info("DAOAccionDeCobranza.query(CobAccioCobraData cobAccioCobraFrom, CobAccioCobraData cobAccioCobraTo, HashMap userProperties, Integer pageCount, Integer pageSize): Salida");
           return result;
        }
       
        public Vector query(CobSubtiAccioData cobSubtiAccioFrom, CobSubtiAccioData cobSubtiAccioTo, HashMap userProperties) throws MareException
        {   UtilidadesLog.info("DAOAccionDeCobranza.query(CobSubtiAccioData cobSubtiAccioFrom, CobSubtiAccioData cobSubtiAccioTo, HashMap userProperties): Entrada");
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
        
        query.append(" SELECT  b.OID_SUBT_ACCI, b.COD_SUBT_ACCI  ");
        query.append(" FROM COB_SUBTI_ACCIO b  ");
        
        
        
        try {
              rs = bs.dbService.executeStaticQuery(query.toString());
          } catch (Exception ex) {
              UtilidadesLog.error("ERROR ", ex);
              throw new MareException(ex, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS));
          }
        int cant = rs.getRowCount();
          
        
         CobSubtiAccioData cobSubtiAccio = null;
          
          for(int i=0; i < cant; i++){
             
              cobSubtiAccio = new CobSubtiAccioData();
              
              cobSubtiAccio.setId(Long.valueOf(((BigDecimal)rs.getValueAt(i, "OID_SUBT_ACCI")).toString()));
              cobSubtiAccio.setCodSubtAcci((String)rs.getValueAt(i,"COD_SUBT_ACCI"));
             
              
              resultado.add(cobSubtiAccio);
          }
        
        
        UtilidadesLog.info("DAOAccionDeCobranza.query(CobSubtiAccioData cobSubtiAccioFrom, CobSubtiAccioData cobSubtiAccioTo, HashMap userProperties): Salida");
            return resultado;
        }
        
        public void update(CobAccioCobraData cobAccioCobra, Vector localizationLabels) throws MareException
        {UtilidadesLog.info("DAOAccionDeCobranza.update(CobAccioCobraData cobAccioCobra, Vector localizationLabels):Entrada");
        
        RecordSet rs = null;
            BelcorpService bs = UtilidadesEJB.getBelcorpService();
            
            StringBuffer update = new StringBuffer();
                    
            update.append(" UPDATE  COB_ACCIO_COBRA SET ");
            update.append(" VAL_DESC = '" + cobAccioCobra.getValDesc()+ "',");
            update.append(" SACC_OID_SUBT_ACCI = " + cobAccioCobra.getSaccOidSubtAcci().getId());
            if(cobAccioCobra.getIndFechHoraSegu() != null)
            {
                update.append(",  ind_fech_hora_segu = " + cobAccioCobra.getIndFechHoraSegu() );
            }
            if(cobAccioCobra.getIndFechImpoComp()!= null)
            {
                update.append(", ind_fech_impo_comp = " + cobAccioCobra.getIndFechImpoComp() );
            }
            if(cobAccioCobra.getIndFechHoraNuevSegu()!= null)
            {
                update.append(", ind_fech_hora_nuev_segu = " + cobAccioCobra.getIndFechHoraNuevSegu());
            }
            if(cobAccioCobra.getIndAporPrue()!= null)
            {
                update.append(", ind_apor_prue = " + cobAccioCobra.getIndAporPrue());
            }
            if(cobAccioCobra.getIndDescPrue()!= null)
            {
                update.append(", ind_desc_prue = " + cobAccioCobra.getIndDescPrue() );
            }
            if(cobAccioCobra.getIndNumeDocuSopo()!= null)
            {
                update.append(", ind_nume_docu_sopo = " + cobAccioCobra.getIndNumeDocuSopo() );
            }
            if(cobAccioCobra.getIndTipoDocuPago()!= null)
            {
                update.append(", ind_tipo_docu_pago = " + cobAccioCobra.getIndTipoDocuPago() );
            }
            
           if(cobAccioCobra.getIndBancSucu()!= null)
           {
                update.append(", ind_banc_sucu = " + cobAccioCobra.getIndBancSucu());
           }
            if(cobAccioCobra.getIndNuevDire()!= null)
            {
                update.append(",  ind_nuev_dire = " + cobAccioCobra.getIndNuevDire());
            }
            if(cobAccioCobra.getIndNuevTelf()!= null)
            {
                update.append(", ind_nuev_telf = " + cobAccioCobra.getIndNuevTelf());
            }
            if(cobAccioCobra.getIndPasaAdmi()!= null)
            {
                update.append(", ind_pasa_admi = " + cobAccioCobra.getIndPasaAdmi());
            }
            
            if(cobAccioCobra.getIndPetiBloqAdmi()!= null)
            {
                update.append(", ind_peti_bloq_admi = " + cobAccioCobra.getIndPetiBloqAdmi());
            }
          
            if(cobAccioCobra.getIndPetiDesbAdmi()!= null)
            {
                update.append(", ind_peti_desb_admi = " + cobAccioCobra.getIndPetiDesbAdmi());
            }
          
            if(cobAccioCobra.getIndAcciMensReco()!= null)
            {
                update.append(", ind_acci_mens_reco = " + cobAccioCobra.getIndAcciMensReco());
            }
          
            if(cobAccioCobra.getIndObse() != null)
            {
                update.append(", ind_obse = '" + cobAccioCobra.getIndObse() + "'");
            }

            if(cobAccioCobra.getValObse() != null)
            {
                update.append(", val_obse = '" + cobAccioCobra.getValObse() + "'");
            }
          
                update.append(" WHERE OID_ACCI_COBR =" + cobAccioCobra.getId());
            
            try {
                int cantRegActualizados = bs.dbService.executeUpdate(update.toString());
            } catch (Exception ex) {
                ex.printStackTrace();
                throw new MareException(ex, UtilidadesError.armarCodigoError(
                                        CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS));
            }
        
        
        UtilidadesLog.info("DAOAccionDeCobranza.update(CobAccioCobraData cobAccioCobra, Vector localizationLabels):Salida");
        }
         public Hashtable guardarAccion(CobAccioCobraData cobAccioCobra, Vector localizationLabels, HashMap userProperties) throws MareException
        { UtilidadesLog.info("DAOAccionDeCobranza.guardarAccion(CobAccioCobraData cobAccioCobra, Vector localizationLabels, HashMap userProperties):Entrada");
          
          RecordSet rs = null;
            BelcorpService bs = UtilidadesEJB.getBelcorpService();
            
            StringBuffer update = new StringBuffer();
            
            RecordSet rsPK = null;
            StringBuffer query = new StringBuffer();      
            Long id = null;
            
            query.append(" SELECT COB_ACCO_SEQ.NEXTVAL FROM DUAL");         
            
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
          update.append(" INSERT INTO COB_ACCIO_COBRA ( ");
          update.append(" OID_ACCI_COBR, ");
          update.append(" PAIS_OID_PAIS,");
          update.append(" COD_ACCI_COBR, ");
          update.append(" VAL_DESC, ");
          update.append(" SACC_OID_SUBT_ACCI, ");
          update.append(" ind_fech_hora_segu, ");
          update.append(" ind_fech_impo_comp,");
          update.append(" ind_fech_hora_nuev_segu,");
          update.append(" ind_apor_prue,");
          update.append(" ind_desc_prue, ");
          update.append(" ind_nume_docu_sopo,");
          update.append(" ind_tipo_docu_pago,");
          update.append(" ind_banc_sucu,");
          update.append(" ind_nuev_dire,");
          update.append(" ind_nuev_telf,");
          update.append(" ind_pasa_admi,");
          update.append(" ind_peti_bloq_admi,");
          update.append(" ind_peti_desb_admi,");
          update.append(" ind_acci_mens_reco,");
          update.append(" ind_obse,");
          update.append(" val_obse");
          update.append(" ) VALUES ( ");
          update.append(id + ", ");
          update.append(cobAccioCobra.getPaisOidPais().getId() + ",");
          update.append(" '" + cobAccioCobra.getCodAcciCobr() + "', ");
          update.append(" '" + cobAccioCobra.getValDesc() +  "',");
          update.append(cobAccioCobra.getSaccOidSubtAcci().getId());
          
          if(cobAccioCobra.getIndFechHoraSegu() != null)
            {
                update.append(", " + cobAccioCobra.getIndFechHoraSegu());
            }
            else {
              update.append(", NULL");
                  }
            
            if(cobAccioCobra.getIndFechImpoComp()!= null)
            {
                update.append(", " + cobAccioCobra.getIndFechImpoComp());
            }
            
            else {
              update.append(", NULL");
                  }
            
            if(cobAccioCobra.getIndFechHoraNuevSegu()!= null)
            {
                update.append(", " + cobAccioCobra.getIndFechHoraNuevSegu());
            }
            else {
              update.append(", NULL");
                  }
            if(cobAccioCobra.getIndAporPrue()!= null)
            {
                update.append(", " + cobAccioCobra.getIndAporPrue());
            }
            
            else {
              update.append(", NULL");
                  }
            
            if(cobAccioCobra.getIndDescPrue()!= null)
            {
                update.append(", " + cobAccioCobra.getIndDescPrue());
            }
            else {
              update.append(", NULL");
                  }
                  
            if(cobAccioCobra.getIndNumeDocuSopo()!= null)
            {
                update.append(", " + cobAccioCobra.getIndNumeDocuSopo());
            }
            else {
              update.append(", NULL");
                  }
                  
            if(cobAccioCobra.getIndTipoDocuPago()!= null)
            {
                update.append(", " + cobAccioCobra.getIndTipoDocuPago());
            }
            else {
              update.append(", NULL");
                  }
            
           if(cobAccioCobra.getIndBancSucu()!= null)
           {
                update.append(", " + cobAccioCobra.getIndBancSucu());
           }
           else {
              update.append(", NULL");
                  }
           
            if(cobAccioCobra.getIndNuevDire()!= null)
            {
                update.append(", " + cobAccioCobra.getIndNuevDire());
            }
            else {
              update.append(", NULL");
                  }
                  
            if(cobAccioCobra.getIndNuevTelf()!= null)
            {
                update.append(", " + cobAccioCobra.getIndNuevTelf());
            }
            else {
              update.append(", NULL");
                  }
                  
            if(cobAccioCobra.getIndPasaAdmi()!= null)
            {
                update.append(", " + cobAccioCobra.getIndPasaAdmi());
            }
            else {
              update.append(", NULL");
                  }
            
            if(cobAccioCobra.getIndPetiBloqAdmi()!= null)
            {
                update.append(", " + cobAccioCobra.getIndPetiBloqAdmi());
            }
            else {
              update.append(", NULL");
                  }
          
            if(cobAccioCobra.getIndPetiDesbAdmi()!= null)
            {
                update.append(", " + cobAccioCobra.getIndPetiDesbAdmi());
            }
            else {
              update.append(", NULL");
                  }
          
            if(cobAccioCobra.getIndAcciMensReco()!= null)
            {
                update.append(", " + cobAccioCobra.getIndAcciMensReco());
            }
            else {
              update.append(", NULL");
                  }
          
            if(cobAccioCobra.getIndObse() != null)
            {
                update.append(", '" + cobAccioCobra.getIndObse() + "'");
            }
            else {
              update.append(", NULL");
                  }

            if(cobAccioCobra.getValObse() != null)
            {
                update.append(", '" + cobAccioCobra.getValObse() + "'");
            }
            else {
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
          UtilidadesLog.info("DAOAccionDeCobranza.guardarAccion(CobAccioCobraData cobAccioCobra, Vector localizationLabels, HashMap userProperties):Salida");
          
          return primaryKey;
        
              
        }
         public void remove(Vector entities) throws MareException
        { UtilidadesLog.info("DAOAccionDeCobranza.remove(Vector entities): Entrada");
        
            RecordSet rs = null;
            BelcorpService bs = UtilidadesEJB.getBelcorpService();
            StringBuffer update = new StringBuffer();
            
            
            int cant = entities.size();
            CobAccioCobraData cobAccion = null;
            String oids = "";
            
            for (int j = 0; j < cant; j++) {
                cobAccion = (CobAccioCobraData)entities.get(j);
                 
                oids = oids + "," + cobAccion.getId();
            }
            
            update.append("delete COB_ACCIO_COBRA ");
            update.append("where OID_ACCI_COBR in ( " + oids.substring(1) + ") ");
            
                   
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
            
        
        UtilidadesLog.info("DAOAccionDeCobranza.remove(Vector entities): Salida");
        }

        
    }

