package es.indra.sicc.logicanegocio.intsys;

import es.indra.belcorp.mso.IntAccesBuzonIvrrgData;
import es.indra.belcorp.mso.SegCanalViewData;
import es.indra.belcorp.mso.SegMarcaData;
import es.indra.belcorp.mso.ZonRegioView2Data;
import es.indra.mare.common.exception.MareException;

import es.indra.mare.common.mgu.manager.Property;
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

public class DAOINTAccesBuzonIvrRg {
    public DAOINTAccesBuzonIvrRg() {
    }
    
    
    public Vector query(ZonRegioView2Data zonRegioView2From, 
                        ZonRegioView2Data zonRegioView2To, HashMap userProperties) throws MareException 
    {UtilidadesLog.info("DAOINTAccesBuzonIvrRg.query(ZonRegioView2Data zonRegioView2From, ZonRegioView2Data zonRegioView2To, HashMap userProperties):Entrada");
    
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
            
            query.append(" SELECT a.OID_REGI, a.COD_REGI, b.OID_CANA, c.OID_MARC ");
            query.append(" FROM ZON_REGIO a,  SEG_CANAL b, SEG_MARCA c  ");
            query.append(" where a.CANA_OID_CANA = b.OID_CANA");
            query.append(" and a.MARC_OID_MARC = c.OID_MARC ");
            query.append(" and b.OID_CANA =" + zonRegioView2From.getCanaOidCana().getId());
            
        
            
            
            try {
                  rs = bs.dbService.executeStaticQuery(query.toString());
              } catch (Exception ex) {
                  UtilidadesLog.error("ERROR ", ex);
                  throw new MareException(ex, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS));
              }
            int cant = rs.getRowCount();
              
            
             ZonRegioView2Data zonRegioView2 = null;
             SegCanalViewData segCanal = null; 
             SegMarcaData segMarca = null;
              for(int i=0; i < cant; i++){
                 
                  zonRegioView2  = new ZonRegioView2Data();
                  segCanal = new SegCanalViewData();
                  segMarca = new SegMarcaData();
                  
                  zonRegioView2.setId(Long.valueOf(((BigDecimal)rs.getValueAt(i,"OID_REGI")).toString()));
                  zonRegioView2.setCodRegi((String)rs.getValueAt(i,"COD_REGI"));
                  segCanal.setId(Long.valueOf(((BigDecimal)rs.getValueAt(i,"OID_CANA")).toString()));
                  segMarca.setId(Long.valueOf(((BigDecimal)rs.getValueAt(i,"OID_MARC")).toString()));
                  zonRegioView2.setCanaOidCana(segCanal);
                  zonRegioView2.setMarcOidMarc(segMarca);
                  
                  resultado.add(zonRegioView2);
              }
            UtilidadesLog.info("DAOINTAccesBuzonIvrRg.query(ZonRegioView2Data zonRegioView2From, ZonRegioView2Data zonRegioView2To, HashMap userProperties):Salida");
            return resultado;
            
         }   
         
    public Vector query(IntAccesBuzonIvrrgData intAccesBuzonIvrrgFrom, 
                        IntAccesBuzonIvrrgData intAccesBuzonIvrrgTo, 
                        HashMap userProperties, Integer pageCount, Integer pageSize) throws MareException 
      
    {   UtilidadesLog.info("DAOINTAccesBuzonIvrRg.query(IntAccesBuzonIvrrgData intAccesBuzonIvrrgFrom,IntAccesBuzonIvrrgData intAccesBuzonIvrrgTo," +
                              " HashMap userProperties, Integer pageCount, Integer pageSize):Entrada");
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
           
               query.append(" SELECT a.OID_ACCE_BUZO_IVRR, a.COD_ACCE_BUZO_IVRR, b.OID_REGI, b.COD_REGI, c.OID_CANA, d.OID_MARC, d.DES_MARC ");
               query.append(" FROM INT_ACCES_BUZON_IVRRG a, ZON_REGIO b,  SEG_CANAL c, seg_marca d ");
               query.append(" WHERE a.ZORG_OID_REGI = b.OID_REGI ");
               query.append(" AND b.CANA_OID_CANA = c.OID_CANA");
               query.append(" and b.MARC_OID_MARC = d.OID_MARC ");
               
               if(intAccesBuzonIvrrgFrom.getId()!=null)
               {
                   query.append(" AND OID_ACCE_BUZO_IVRR = " + intAccesBuzonIvrrgFrom.getId());
               }
               
               if(intAccesBuzonIvrrgFrom.getCodAcceBuzoIvrr()!= null)
               {
                   query.append(" AND COD_ACCE_BUZO_IVRR = '" + intAccesBuzonIvrrgFrom.getCodAcceBuzoIvrr() + "'");
               }
               if(intAccesBuzonIvrrgFrom.getZorgOidRegi()!= null)
               {
                   query.append(" AND OID_REGI = " + intAccesBuzonIvrrgFrom.getZorgOidRegi().getId());
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
                               
                IntAccesBuzonIvrrgData intAccesBuzon = null;
                ZonRegioView2Data  zonregio2 = null;
                SegCanalViewData segCanal = null;
                SegMarcaData segMarca = null;
                
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
                   
                        intAccesBuzon = new IntAccesBuzonIvrrgData();
                        zonregio2 = new ZonRegioView2Data();
                        segCanal = new SegCanalViewData();
                        segMarca = new SegMarcaData(); 
                         intAccesBuzon.setId(Long.valueOf(((BigDecimal)rs.getValueAt(i,"OID_ACCE_BUZO_IVRR")).toString()));                 
                         intAccesBuzon.setCodAcceBuzoIvrr((String)rs.getValueAt(i,"COD_ACCE_BUZO_IVRR"));
                         zonregio2.setId(Long.valueOf(((BigDecimal)rs.getValueAt(i,"OID_REGI")).toString()));
                         zonregio2.setCodRegi((String)rs.getValueAt(i,"COD_REGI"));
                         segCanal.setId(Long.valueOf(((BigDecimal)rs.getValueAt(i,"OID_CANA")).toString()));
                         segMarca.setId(Long.valueOf(((BigDecimal)rs.getValueAt(i,"OID_MARC")).toString()));
                         segMarca.setDesMarc((String)rs.getValueAt(i,"DES_MARC"));
                         zonregio2.setCanaOidCana(segCanal);
                         zonregio2.setMarcOidMarc(segMarca);
                         intAccesBuzon.setZorgOidRegi(zonregio2);
                         
                               
                                      
                         result.add(intAccesBuzon);
                         
                   }catch(Exception ex)
                   {
                     ex.printStackTrace();
                   }
                   } else {
                      break;
                   }
                   
           }
    
        UtilidadesLog.info("DAOINTAccesBuzonIvrRg.query(IntAccesBuzonIvrrgData intAccesBuzonIvrrgFrom,IntAccesBuzonIvrrgData intAccesBuzonIvrrgTo," +
                                      " HashMap userProperties, Integer pageCount, Integer pageSize):Salida");    
    return result;
    }
    public Vector query(ZonRegioView2Data zonRegioView2From, 
                        ZonRegioView2Data zonRegioView2To, 
                        HashMap userProperties, Boolean applyStructuralSecurity) throws MareException 
    {   UtilidadesLog.info("DAOINTAccesBuzonIvrRg.query(ZonRegioView2Data zonRegioView2From, ZonRegioView2Data zonRegioView2To, HashMap userProperties, Boolean applyStructuralSecurity):Entrada");
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
                       
                //if(!applyStructuralSecurity.booleanValue()) {
                    query.append(" SELECT a.OID_REGI, a.COD_REGI, b.OID_CANA, c.OID_MARC ");
                    query.append(" FROM ZON_REGIO a,  SEG_CANAL b, SEG_MARCA c  ");
                    query.append(" where a.CANA_OID_CANA = b.OID_CANA");
                    query.append(" and a.MARC_OID_MARC = c.OID_MARC ");
                    if(zonRegioView2From.getCanaOidCana()!=null){
                        query.append(" and b.OID_CANA =" + zonRegioView2From.getCanaOidCana().getId());    
                    }
                    
                /*}
                else{
                    Property userID = (Property)userProperties.get("userID");
                    
                    query.append(" SELECT ZON_REGIO.OID_REGI, ZON_REGIO.COD_REGI, SEG_CANAL.OID_CANA, SEG_MARCA.OID_MARC");
                    query.append(" FROM ZON_REGIO, SEG_CANAL, SEG_MARCA");
                    query.append(" WHERE ZON_REGIO.CANA_OID_CANA = SEG_CANAL.OID_CANA");
                    query.append(" AND ZON_REGIO.MARC_OID_MARC = SEG_MARCA.OID_MARC");
                    query.append(" AND  ZON_REGIO.OID_REGI IN (SELECT OID_REGI from ");
                    query.append(" VCA_ZON_REGIO where COD_USUA =  '" + userID.getValue() + "')");
                    /* query.append("  AND SEG_ACCES.CANA_OID_CANA = "+ segAccesFrom.getCanaOidCana().getId());

                     query.append("  AND V_GEN_I18N_SICC.VAL_OID =  SEG_ACCES.OID_ACCE");

                            }*/
                     try {
                           rs = bs.dbService.executeStaticQuery(query.toString());
                       } catch (Exception ex) {
                           UtilidadesLog.error("ERROR ", ex);
                           throw new MareException(ex, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS));
                       }
                     int cant = rs.getRowCount();
                       
                     
                      ZonRegioView2Data zonRegioView2 = null;
                      SegCanalViewData segCanal = null; 
                      SegMarcaData segMarca = null;
                       for(int i=0; i < cant; i++){
                          
                           zonRegioView2  = new ZonRegioView2Data();
                           segCanal = new SegCanalViewData();
                           segMarca = new SegMarcaData();
                           
                           zonRegioView2.setId(Long.valueOf(((BigDecimal)rs.getValueAt(i,"OID_REGI")).toString()));
                           zonRegioView2.setCodRegi((String)rs.getValueAt(i,"COD_REGI"));
                           segCanal.setId(Long.valueOf(((BigDecimal)rs.getValueAt(i,"OID_CANA")).toString()));
                           segMarca.setId(Long.valueOf(((BigDecimal)rs.getValueAt(i,"OID_MARC")).toString()));
                           zonRegioView2.setCanaOidCana(segCanal);
                           zonRegioView2.setMarcOidMarc(segMarca);
                           
                           resultado.add(zonRegioView2);
                       }

                    
    
        UtilidadesLog.info("DAOINTAccesBuzonIvrRg.query(ZonRegioView2Data zonRegioView2From, ZonRegioView2Data zonRegioView2To, HashMap userProperties, Boolean applyStructuralSecurity): Salida");
        return resultado;
    }
     
    public void update(IntAccesBuzonIvrrgData intAccesBuzonIvrrg, 
                       Vector localizationLabels) throws MareException 
    {UtilidadesLog.info("DAOINTAccesBuzonIvrRg.update(IntAccesBuzonIvrrgData intAccesBuzonIvrrg, Vector localizationLabels):Entrada");
                RecordSet rs = null;
                BelcorpService bs = UtilidadesEJB.getBelcorpService();
                
                StringBuffer update = new StringBuffer();
                
                  
                update.append(" UPDATE  INT_ACCES_BUZON_IVRRG SET ");
                update.append(" COD_ACCE_BUZO_IVRR = '" + intAccesBuzonIvrrg.getCodAcceBuzoIvrr() + "',");
                update.append(" ZORG_OID_REGI = "+ intAccesBuzonIvrrg.getZorgOidRegi().getId());
                               
                update.append(" WHERE OID_ACCE_BUZO_IVRR = " + intAccesBuzonIvrrg.getId());
                
                try {
                    int cantRegActualizados = bs.dbService.executeUpdate(update.toString());
                } catch (Exception ex) {
                    ex.printStackTrace();
                    throw new MareException(ex, UtilidadesError.armarCodigoError(
                                            CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS));
                }
            
    
    UtilidadesLog.info("DAOINTAccesBuzonIvrRg.update(IntAccesBuzonIvrrgData intAccesBuzonIvrrg, Vector localizationLabels):Salida");
    }    
    public void remove(Vector entities) throws MareException {
        UtilidadesLog.info("DAOINTAccesBuzonIvrRg.remove(Vector entities):Entrada");   
                RecordSet rs = null;
                BelcorpService bs = UtilidadesEJB.getBelcorpService();
                StringBuffer update = new StringBuffer();
                
                
                int cant = entities.size();
                IntAccesBuzonIvrrgData intAccesBuzon = null;
                String oids = "";
                
                for (int j = 0; j < cant; j++) {
                   intAccesBuzon = (IntAccesBuzonIvrrgData)entities.get(j);
                     
                    oids = oids + "," + intAccesBuzon.getId();
                }
                
                update.append("DELETE INT_ACCES_BUZON_IVRRG ");
                update.append("WHERE OID_ACCE_BUZO_IVRR in ( " + oids.substring(1) + ") ");
                
                       
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
        
        
        UtilidadesLog.info("DAOINTAccesBuzonIvrRg.remove(Vector entities):Salida");
    
    }
    public Hashtable guardar(IntAccesBuzonIvrrgData intAccesBuzonIvrrg, 
                             Vector localizationLabels, HashMap userProperties) throws MareException {
        UtilidadesLog.info("DAOINTAccesBuzonIvrRg.guardar(IntAccesBuzonIvrrgData intAccesBuzonIvrrgVector localizationLabels, HashMap userProperties):Entrada");
                 RecordSet rs = null;
                 BelcorpService bs = UtilidadesEJB.getBelcorpService();
                       
                 StringBuffer update = new StringBuffer();
                                         
                 RecordSet rsPK = null;
                 StringBuffer query = new StringBuffer();      
                 Long id = null;
                                         
                query.append(" SELECT INT_IBRG_SEQ.NEXTVAL FROM DUAL");         
                                         
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
                    update.append(" INSERT INTO INT_ACCES_BUZON_IVRRG ( ");
                    update.append(" OID_ACCE_BUZO_IVRR, ");
                    update.append(" COD_ACCE_BUZO_IVRR, ");
                    update.append(" ZORG_OID_REGI");
                    update.append(" ) VALUES ( ");
                    update.append(id + ", ");
                    update.append("'" + intAccesBuzonIvrrg.getCodAcceBuzoIvrr() + "', ");
                    update.append(intAccesBuzonIvrrg.getZorgOidRegi().getId());
                                   
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
        
        UtilidadesLog.info("DAOINTAccesBuzonIvrRg.guardar(IntAccesBuzonIvrrgData intAccesBuzonIvrrgVector localizationLabels, HashMap userProperties):Salida");
    return primaryKey;
    }
}
