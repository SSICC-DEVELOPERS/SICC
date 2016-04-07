package es.indra.sicc.logicanegocio.cob;

import es.indra.belcorp.mso.CobArgumData;
import es.indra.belcorp.mso.CobGuionArgumCabecData;
import es.indra.belcorp.mso.CobGuionArgumDetalData;
import es.indra.belcorp.mso.CobValorArgumData;
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

public class DAOGuiaArgumenDetal {
    public DAOGuiaArgumenDetal() {
    }
    
    public Vector query(CobValorArgumData cobValorArgumFrom, CobValorArgumData cobValorArgumTo, HashMap userProperties) throws MareException
        {   UtilidadesLog.info("DAOCobGuiasArgumDetal.query(CobValorArgumData cobValorArgumFrom, CobValorArgumData cobValorArgumTo, HashMap userProperties):Entrada");
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
           try{
           
                  
               query.append("  SELECT a.OID_ARGU, a.COD_ARGU , b.OID_VALO_ARGU, b.VAL_DESC_VALO_ARGU, b.ARGU_OID_ARGU ");
               query.append("         FROM COB_ARGUM a, COB_VALOR_ARGUM b    ");
               query.append(" WHERE b.ARGU_OID_ARGU = a.OID_ARGU ");
               
               if(cobValorArgumFrom.getId()!= null)
               {
                   query.append("     AND a.OID_ARGU   = " + cobValorArgumFrom.getArguOidArgu().getId());
               }
               
               
               
           
                       
           
           }catch(Exception ex)
           {
              ex.printStackTrace();
           }
           try
           {
                  rs = bs.dbService.executeStaticQuery(query.toString());
         
            }catch (Exception ex) {
               
                  throw new MareException(ex, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS));
           }
           if(!rs.esVacio())
           {
              for(int i = 0; i < rs.getRowCount(); i++)
              {
                  try{
                  CobValorArgumData cobValor = new CobValorArgumData();
                  
                  BigDecimal oidValor = null;
                  
                  oidValor = (BigDecimal)rs.getValueAt(i,"OID_VALO_ARGU");
                  CobArgumData cobArgu = new CobArgumData();
                  
                  cobArgu.setId(new Long(((BigDecimal)rs.getValueAt(i,"OID_ARGU")).toString()));
                  cobArgu.setCodArgu((String)rs.getValueAt(i,"COD_ARGU"));
                  cobValor.setArguOidArgu(cobArgu);
                  
                  if(oidValor != null)
                  {
                      cobValor.setId(Long.valueOf(oidValor.toString()));
                      cobValor.setValDescValoArgu((String)rs.getValueAt(i,"VAL_DESC_VALO_ARGU"));
                      cobValor.setArguOidArgu(cobArgu);
                  }
               
                  
                 
                  resultado.add(cobValor);
                  
                  }catch(Exception ex)
                  {
                     ex.printStackTrace();
                  }
        
        
            UtilidadesLog.info("DAOCobGuiasArgumDetal.query(CobValorArgumData cobValorArgumFrom, CobValorArgumData cobValorArgumTo, HashMap userProperties):Entrada");
        
           
            }
             
           }
           return resultado;
        }
         public Vector query(CobGuionArgumCabecData cobGuionArgumCabecFrom, CobGuionArgumCabecData cobGuionArgumCabecTo, HashMap userProperties) throws MareException
        {   UtilidadesLog.info("DAOCobGuiasArgumDetal.query(CobGuionArgumCabecData cobGuionArgumCabecFrom, CobGuionArgumCabecData cobGuionArgumCabecTo, HashMap userProperties): Entrada");
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
           query.append(" SELECT a.oid_guio_argu_cabe, c.val_i18n, b.oid_pais ");
           query.append(" FROM cob_guion_argum_cabec a, gen_i18n_sicc_pais c, seg_pais b ");
           query.append(" WHERE a.pais_oid_pais = b.oid_pais ");
           query.append(" and c.ATTR_ENTI = 'COB_GUION_ARGUM_CABEC'");
           query.append(" AND c.ATTR_NUM_ATRI = 1");
           query.append(" AND c.IDIO_OID_IDIO = 1");
           query.append(" AND c.VAL_OID = a.OID_GUIO_ARGU_CABE");
           
           try
           {
                  rs = bs.dbService.executeStaticQuery(query.toString());
         
            }catch (Exception ex) {
               
                  throw new MareException(ex, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS));
           }
           if(!rs.esVacio())
           {
              for(int i = 0; i < rs.getRowCount(); i++)
              {
                 CobGuionArgumCabecData cobGuion = new CobGuionArgumCabecData();
                 cobGuion.setId(new Long(((BigDecimal)rs.getValueAt(i,"OID_GUIO_ARGU_CABE")).toString()));
                 cobGuion.setDescripcion((String)rs.getValueAt(i,"VAL_I18N"));
                 resultado.add(cobGuion);
              }
        
        
            UtilidadesLog.info("DAOCobGuiasArgumDetal.query(CobGuionArgumCabecData cobGuionArgumCabecFrom, CobGuionArgumCabecData cobGuionArgumCabecTo, HashMap userProperties): Salida");
            
            }
            return resultado;
        }
        
        public Vector query(CobArgumData cobArgumFrom, CobArgumData cobArgumTo, HashMap userProperties) throws MareException
        {   UtilidadesLog.info("DAOCobGuiasArgumDetal.query(CobArgumData cobArgumFrom, CobArgumData cobArgumTo, HashMap userProperties):Entrada");
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
           query.append(" SELECT  a.OID_ARGU, a.COD_ARGU, b.OID_PAIS ");
           query.append(" FROM  COB_ARGUM a, seg_pais b ");
           query.append(" WHERE a.PAIS_OID_PAIS = b.OID_PAIS ");
           
           
           
           try
           {
                  rs = bs.dbService.executeStaticQuery(query.toString());
         
            }catch (Exception ex) {
               
                  throw new MareException(ex, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS));
           }
           SegPaisViewData segPais = null;
           if(!rs.esVacio())
           {
              for(int i = 0; i < rs.getRowCount(); i++)
              {
                 CobArgumData cobArgu = new CobArgumData();
                 segPais = new SegPaisViewData();
                 cobArgu.setId(new Long(((BigDecimal)rs.getValueAt(i,"OID_ARGU")).toString()));
                 cobArgu.setCodArgu((String)rs.getValueAt(i,"COD_ARGU"));
                 segPais.setId(Long.valueOf(((BigDecimal)rs.getValueAt(i,"OID_PAIS")).toString()));
                 cobArgu.setPaisOidPais(segPais);
                 resultado.add(cobArgu);
              }
        
        
        
        
            UtilidadesLog.info("DAOCobGuiasArgumDetal.query(CobArgumData cobArgumFrom, CobArgumData cobArgumTo, HashMap userProperties):Entrada");
            
            }
            return resultado;
        }
        
        public Vector query(CobGuionArgumDetalData cobGuionArgumDetalFrom, CobGuionArgumDetalData cobGuionArgumDetalTo, HashMap userProperties, Integer pageCount, Integer pageSize) throws MareException
        {   UtilidadesLog.info("DAOCobGuiasArgumDetal.query(CobGuionArgumDetalData cobGuionArgumDetalFrom, CobGuionArgumDetalData cobGuionArgumDetalTo, HashMap userProperties, Integer pageCount, Integer pageSize):Entrada");
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
        
            query.append(" SELECT a.oid_guio_argu_deta, c.oid_guio_argu_cabe, d.val_i18n, b.oid_argu, b.COD_ARGU, ");
            query.append(" a.num_orde_argu, a.ind_acti_atri_obse, a.val_obse, e.OID_VALO_ARGU, e.VAL_DESC_VALO_ARGU  ");
            query.append(" FROM COB_GUION_ARGUM_DETAL a,  COB_ARGUM b, COB_GUION_ARGUM_CABEC c, GEN_I18N_SICC_PAIS d, cob_valor_argum e ");
            query.append(" WHERE a.gaca_oid_guio_argu_cabe = c.oid_guio_argu_cabe ");
            query.append(" and a.VAAR_OID_VALO_ARGU = e.OID_VALO_ARGU(+) ");
            if(cobGuionArgumDetalFrom.getVaarOidValoArgu()!=null)
            {
                query.append(" AND e.OID_VALO_ARGU = " + cobGuionArgumDetalFrom.getVaarOidValoArgu().getId());
            }
            query.append(" AND a.argu_oid_argu = b.oid_argu ");
            query.append(" AND d.attr_enti = 'COB_GUION_ARGUM_CABEC'");
            query.append(" AND d.attr_num_atri = 1");
            query.append(" AND d.idio_oid_idio = 1");
            query.append(" AND d.val_oid = c.oid_guio_argu_cabe");
            
            
             if(cobGuionArgumDetalFrom.getId()!= null){
                query.append(" AND OID_GUIO_ARGU_DETA = " + cobGuionArgumDetalFrom.getId());
            }
             if(cobGuionArgumDetalFrom.getArguOidArgu()!= null){
                query.append(" AND OID_ARGU = " + cobGuionArgumDetalFrom.getArguOidArgu().getId());
            }
            
            if(cobGuionArgumDetalFrom.getGacaOidGuioArguCabe()!= null){
                query.append(" AND OID_GUIO_ARGU_CABE = " + cobGuionArgumDetalFrom.getGacaOidGuioArguCabe().getId());
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
            
            CobGuionArgumDetalData cobGuionArgumDetal = null;
            CobArgumData cobArg = null;
            CobGuionArgumCabecData cobGuiArCabec = null;
            CobValorArgumData cobValorArg = null;
            
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
                      cobGuionArgumDetal= new CobGuionArgumDetalData();
                      String obse = null;
                      BigDecimal codArgu, valor = null;
                      cobArg = new CobArgumData();
                      cobGuiArCabec = new  CobGuionArgumCabecData();
                      cobValorArg = new CobValorArgumData();
                     
                      cobGuionArgumDetal.setId(Long.valueOf(((BigDecimal)rs.getValueAt(i,"OID_GUIO_ARGU_DETA")).toString())); 
                      cobGuionArgumDetal.setIndActiAtriObse(Long.valueOf(((BigDecimal)rs.getValueAt(i,"IND_ACTI_ATRI_OBSE")).toString()));
                      cobGuiArCabec.setId(Long.valueOf(((BigDecimal)rs.getValueAt(i,"OID_GUIO_ARGU_CABE")).toString())); 
                      cobGuiArCabec.setDescripcion((String)rs.getValueAt(i,"VAL_I18N"));
                      cobGuionArgumDetal.setGacaOidGuioArguCabe(cobGuiArCabec);
                      cobGuionArgumDetal.setNumOrdeArgu(Long.valueOf(((BigDecimal)rs.getValueAt(i,"NUM_ORDE_ARGU")).toString()));
                                                         
                      obse = (String)rs.getValueAt(i,"VAL_OBSE");
                      if(obse != null)
                      {
                            cobGuionArgumDetal.setValObse(String.valueOf(obse));
                         
                      }
                      
                      codArgu = (BigDecimal)rs.getValueAt(i,"OID_ARGU");
                        if(codArgu != null)
                        {
                           cobArg.setId(Long.valueOf(codArgu.toString()));
                           cobArg.setCodArgu((String)rs.getValueAt(i,"COD_ARGU"));
                           cobGuionArgumDetal.setArguOidArgu(cobArg);
                        }
                       
                        
                        valor = (BigDecimal)rs.getValueAt(i,"OID_VALO_ARGU");
                        if(valor != null)
                        {
                            cobValorArg.setId(Long.valueOf(valor.toString()));
                            cobValorArg.setValDescValoArgu((String)rs.getValueAt(i,"VAL_DESC_VALO_ARGU"));
                            cobValorArg.setArguOidArgu(cobArg);
                            cobGuionArgumDetal.setVaarOidValoArgu(cobValorArg);
                            
                        }
                                        
                      result.add(cobGuionArgumDetal);
                }catch(Exception ex)
                {
                  ex.printStackTrace();
                }
                } else {
                   break;
                }
            }
          UtilidadesLog.info("DAOCobGuiasArgumDetal.query(CobGuionArgumDetalData cobGuionArgumDetalFrom, CobGuionArgumDetalData cobGuionArgumDetalTo, HashMap userProperties, Integer pageCount, Integer pageSize):Salida");
            return result;
        }
        
        
         public void remove(Vector entities) throws MareException
        {   UtilidadesLog.info("DAOCobGuiasArgumDetal.remove(Vector entities):Entrada");
            RecordSet rs = null;
            BelcorpService bs = UtilidadesEJB.getBelcorpService();
            StringBuffer update = new StringBuffer();
            
            
            int cant = entities.size();
            CobGuionArgumDetalData cobGuionArg = null;
            String oids = "";
            
            for (int j = 0; j < cant; j++) {
               cobGuionArg = (CobGuionArgumDetalData)entities.get(j);
                 
                oids = oids + "," + cobGuionArg.getId();
            }
            
            update.append("DELETE COB_GUION_ARGUM_DETAL ");
            update.append("WHERE OID_GUIO_ARGU_DETA in ( " + oids.substring(1) + ") ");
            
                   
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
            
            UtilidadesLog.info("DAOCobGuiasArgumDetal.remove(Vector entities):Salida");
        }
        
        public Hashtable guardar(CobGuionArgumDetalData cobGuionArgumDetal, Vector localizationLabels, HashMap userProperties) throws MareException
            { UtilidadesLog.info("DAOCobGuiasArgumDetal.guardar(CobGuionArgumDetalData cobGuionArgumDetal, Vector localizationLabels, HashMap userProperties)): Entrada");
              RecordSet rs = null;
              BelcorpService bs = UtilidadesEJB.getBelcorpService();     
              StringBuffer update = new StringBuffer();
              RecordSet rsPK = null;
              StringBuffer query = new StringBuffer();      
              Long id = null;
              query.append(" SELECT COB_GADE_SEQ.NEXTVAL FROM DUAL ");
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
              update.append("INSERT INTO COB_GUION_ARGUM_DETAL (");
              update.append("              OID_GUIO_ARGU_DETA   ");
              update.append("              , GACA_OID_GUIO_ARGU_CABE ");
              update.append("              , NUM_ORDE_ARGU ");
              update.append("              , ARGU_OID_ARGU ");
              update.append("              , IND_ACTI_ATRI_OBSE ");
              update.append("              , VAL_OBSE ");
              update.append("              , VAAR_OID_VALO_ARGU ");
              update.append("  ) VALUES (   ");
              update.append(id);
              update.append(" , " + cobGuionArgumDetal.getGacaOidGuioArguCabe().getId());
              update.append(" , " + cobGuionArgumDetal.getNumOrdeArgu());
              update.append(" , " + cobGuionArgumDetal.getArguOidArgu().getId());
              update.append(" , " + cobGuionArgumDetal.getIndActiAtriObse());
             
                    
              if(cobGuionArgumDetal.getValObse() != null)
              {
                 update.append(" , '" + cobGuionArgumDetal.getValObse() + "' ");
              }else
              {
                 update.append(" , NULL");
              }
              if(cobGuionArgumDetal.getVaarOidValoArgu() != null)
              {
                 update.append(" , " + cobGuionArgumDetal.getVaarOidValoArgu().getId());
              }else
              {
                update.append(" , NULL ");
              }
              
              update.append("  )  ");
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
              UtilidadesLog.info("DAOCobGuiasArgumDetal.guardar(CobGuionArgumDetalData cobGuionArgumDetal, Vector localizationLabels, HashMap userProperties)): Salida");
              return primaryKey;
        }
        
        public void update(CobGuionArgumDetalData cobGuionArgumDetal, Vector localizationLabels) throws MareException
        {   UtilidadesLog.info("DAOCobGuiasArgumDetal.update(CobGuionArgumDetalData cobGuionArgumDetal, Vector localizationLabels):Entrada");
            
            RecordSet rs = null;
            BelcorpService bs = UtilidadesEJB.getBelcorpService();
               
            StringBuffer update = new StringBuffer();
            update.append("   UPDATE COB_GUION_ARGUM_DETAL SET ");
            update.append("           GACA_OID_GUIO_ARGU_CABE = " + cobGuionArgumDetal.getGacaOidGuioArguCabe().getId() );
            update.append("           ,  NUM_ORDE_ARGU = " + cobGuionArgumDetal.getNumOrdeArgu());
            update.append("           ,  ARGU_OID_ARGU = " + cobGuionArgumDetal.getArguOidArgu().getId());
            update.append("           ,  IND_ACTI_ATRI_OBSE = " + cobGuionArgumDetal.getIndActiAtriObse());
           
            if(cobGuionArgumDetal.getValObse() != null){
              update.append("           , VAL_OBSE = '" + cobGuionArgumDetal.getValObse() + "' ");
            }else
            {
              update.append("           ,  VAL_OBSE = NULL");
            }
            if(cobGuionArgumDetal.getVaarOidValoArgu() != null)
            {
               update.append("          , VAAR_OID_VALO_ARGU = " + cobGuionArgumDetal.getVaarOidValoArgu().getId());
            }else
            {
              update.append("           , VAAR_OID_VALO_ARGU = NULL");
            }
           
            update.append("   where OID_GUIO_ARGU_DETA = " + cobGuionArgumDetal.getId());
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
           
        UtilidadesLog.info("DAOCobGuiasArgumDetal.update(CobGuionArgumDetalData cobGuionArgumDetal, Vector localizationLabels):Salida");
        }
        
            
        }


