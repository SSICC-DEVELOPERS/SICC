package es.indra.sicc.logicanegocio.intsys;



import es.indra.belcorp.mso.IntAccesBuzonIvrznData;
import es.indra.belcorp.mso.SegCanalViewData;
import es.indra.belcorp.mso.SegMarcaData;
import es.indra.belcorp.mso.ZonRegioView2Data;
import es.indra.belcorp.mso.ZonZonaView2Data;
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

public class DAOINTAccesBuzonIvrZn {
    public DAOINTAccesBuzonIvrZn() {
    }
    
    public Vector query(ZonZonaView2Data zonZonaView2From, 
                        ZonZonaView2Data zonZonaView2To, HashMap userProperties) throws MareException {
        UtilidadesLog.info("DAOINTAccesBuzonIvrZn.query(ZonZonaView2Data zonZonaView2From, ZonZonaView2Data zonZonaView2To, HashMap userProperties):Entrada");
            
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
                    
                    query.append(" SELECT a.OID_ZONA, a.COD_ZONA, b.OID_CANA, c.OID_MARC ");
                    query.append(" FROM ZON_ZONA a,  SEG_CANAL b, SEG_MARCA c   ");
                    query.append(" where a.CANA_OID_CANA = b.OID_CANA");
                    query.append(" and a.MARC_OID_MARC = c.OID_MARC ");
                    query.append(" and b.OID_CANA =" + zonZonaView2From.getCanaOidCana().getId());
                    
                
                    
                    
                    try {
                          rs = bs.dbService.executeStaticQuery(query.toString());
                      } catch (Exception ex) {
                          UtilidadesLog.error("ERROR ", ex);
                          throw new MareException(ex, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS));
                      }
                    int cant = rs.getRowCount();
                      
                    
                     ZonZonaView2Data zonZonaView2 = null;
                     SegCanalViewData segCanal = null; 
                     SegMarcaData segMarca = null;
                      for(int i=0; i < cant; i++){
                         
                          zonZonaView2  = new ZonZonaView2Data();
                          segCanal = new SegCanalViewData();
                          segMarca = new SegMarcaData();
                          
                          zonZonaView2.setId(Long.valueOf(((BigDecimal)rs.getValueAt(i,"OID_ZONA")).toString()));
                          zonZonaView2.setCodZona((String)rs.getValueAt(i,"COD_ZONA"));
                          segCanal.setId(Long.valueOf(((BigDecimal)rs.getValueAt(i,"OID_CANA")).toString()));
                          segMarca.setId(Long.valueOf(((BigDecimal)rs.getValueAt(i,"OID_MARC")).toString()));
                          zonZonaView2.setCanaOidCana(segCanal);
                          zonZonaView2.setMarcOidMarc(segMarca);
                          
                          resultado.add(zonZonaView2);
                      }
                    UtilidadesLog.info("DAOINTAccesBuzonIvrZn.query(ZonZonaView2Data zonZonaView2From, ZonZonaView2Data zonZonaView2To, HashMap userProperties):Salida");
                    return resultado;
          
    }
    
    
    public Vector query(IntAccesBuzonIvrznData intAccesBuzonIvrznFrom, 
                        IntAccesBuzonIvrznData intAccesBuzonIvrznTo, 
                        HashMap userProperties, Integer pageCount, Integer pageSize) throws MareException {
                        
        UtilidadesLog.info("DAOINTAccesBuzonIvrZn.query(IntAccesBuzonIvrznData intAccesBuzonIvrznFrom,IntAccesBuzonIvrznData intAccesBuzonIvrznTo," +
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
                   
                       query.append(" SELECT a.OID_ACCE_BUZO_IVRZ, a.COD_ACCE_BUZO_IVRZ, b.OID_ZONA, b.COD_ZONA, ");
                       query.append(" c.oid_cana, d.oid_marc ");
                       query.append(" FROM INT_ACCES_BUZON_IVRZN a, ZON_ZONA b, seg_canal c, seg_marca d ");
                       query.append(" WHERE a.ZZON_OID_ZONA = b.OID_ZONA");
                       query.append(" AND b.cana_oid_cana = c.oid_cana ");
                       query.append(" AND b.marc_oid_marc = d.oid_marc ");
                       
                       if(intAccesBuzonIvrznFrom.getId()!=null)
                       {
                           query.append(" AND OID_ACCE_BUZO_IVRZ = " + intAccesBuzonIvrznFrom.getId());
                       }
                       
                       if(intAccesBuzonIvrznFrom.getCodAcceBuzoIvrz()!= null)
                       {
                           query.append(" AND COD_ACCE_BUZO_IVRZ = '" + intAccesBuzonIvrznFrom.getCodAcceBuzoIvrz() + "'");
                       }
                       if(intAccesBuzonIvrznFrom.getZzonOidZona()!= null)
                       {
                           query.append(" AND OID_ZONA = " + intAccesBuzonIvrznFrom.getZzonOidZona().getId());
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
                                       
                        IntAccesBuzonIvrznData intAccesBuzonZn = null;
                        ZonZonaView2Data  zonzona2 = null;
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
                           
                                intAccesBuzonZn = new IntAccesBuzonIvrznData();
                                zonzona2 = new ZonZonaView2Data();
                                segCanal = new SegCanalViewData();
                                segMarca = new SegMarcaData(); 
                                
                                 intAccesBuzonZn.setId(Long.valueOf(((BigDecimal)rs.getValueAt(i,"OID_ACCE_BUZO_IVRZ")).toString()));                 
                                 intAccesBuzonZn.setCodAcceBuzoIvrz((String)rs.getValueAt(i,"COD_ACCE_BUZO_IVRZ"));
                                 zonzona2.setId(Long.valueOf(((BigDecimal)rs.getValueAt(i,"OID_ZONA")).toString()));
                                 zonzona2.setCodZona((String)rs.getValueAt(i,"COD_ZONA"));
                                 segCanal.setId(Long.valueOf(((BigDecimal)rs.getValueAt(i,"OID_CANA")).toString()));
                                 segMarca.setId(Long.valueOf(((BigDecimal)rs.getValueAt(i,"OID_MARC")).toString()));
                                 zonzona2.setCanaOidCana(segCanal);
                                 zonzona2.setMarcOidMarc(segMarca);
                                 intAccesBuzonZn.setZzonOidZona(zonzona2);
                                 
                                       
                                              
                                 result.add(intAccesBuzonZn);
                                 
                           }catch(Exception ex)
                           {
                             ex.printStackTrace();
                           }
                           } else {
                              break;
                           }
                           
                   }
            
                UtilidadesLog.info("DAOINTAccesBuzonIvrZn.query(IntAccesBuzonIvrznData intAccesBuzonIvrznFrom,IntAccesBuzonIvrznData intAccesBuzonIvrznTo," +
                                              " HashMap userProperties, Integer pageCount, Integer pageSize):Salida");    
            return result;
            }
                    
    public void remove(Vector entities) throws MareException 
    
    {UtilidadesLog.info("DAOINTAccesBuzonIvrZn.remove(Vector entities):Entrada");
        RecordSet rs = null;
        BelcorpService bs = UtilidadesEJB.getBelcorpService();
        StringBuffer update = new StringBuffer();
        
        
        int cant = entities.size();
        IntAccesBuzonIvrznData intAccesBuzonZn = null;
        String oids = "";
        
        for (int j = 0; j < cant; j++) {
           intAccesBuzonZn= (IntAccesBuzonIvrznData)entities.get(j);
             
            oids = oids + "," + intAccesBuzonZn.getId();
        }
        
        update.append("DELETE INT_ACCES_BUZON_IVRZN ");
        update.append("WHERE OID_ACCE_BUZO_IVRZ in ( " + oids.substring(1) + ") ");
        
               
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
        
        
        UtilidadesLog.info("DAOINTAccesBuzonIvrZn.remove(Vector entities):Salida");
    
    
    
    }                  
    public void update(IntAccesBuzonIvrznData intAccesBuzonIvrzn, 
                       Vector localizationLabels) throws MareException 
    {UtilidadesLog.info("DAOINTAccesBuzonIvrZn.update(IntAccesBuzonIvrznData intAccesBuzonIvrzn, \n" + 
    "                       Vector localizationLabels):Entrada");
        
        RecordSet rs = null;
        BelcorpService bs = UtilidadesEJB.getBelcorpService();
        
        StringBuffer update = new StringBuffer();
        
          
        update.append(" UPDATE  INT_ACCES_BUZON_IVRZN SET ");
        update.append(" COD_ACCE_BUZO_IVRZ = '" + intAccesBuzonIvrzn.getCodAcceBuzoIvrz() + "',");
        update.append(" ZZON_OID_ZONA = "+ intAccesBuzonIvrzn.getZzonOidZona().getId());
                       
        update.append(" WHERE OID_ACCE_BUZO_IVRZ = " + intAccesBuzonIvrzn.getId());
        
        try {
            int cantRegActualizados = bs.dbService.executeUpdate(update.toString());
        } catch (Exception ex) {
            ex.printStackTrace();
            throw new MareException(ex, UtilidadesError.armarCodigoError(
                                    CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS));
        }
      
        UtilidadesLog.info("DAOINTAccesBuzonIvrZn.update(IntAccesBuzonIvrznData intAccesBuzonIvrzn, \n" + 
            "                       Vector localizationLabels):Salida");
    }
    
    public Hashtable guardar(IntAccesBuzonIvrznData intAccesBuzonIvrzn, 
                             Vector localizationLabels, HashMap userProperties) throws MareException 
                             
    {UtilidadesLog.info("DAOINTAccesBuzonIvrZn.guardar((IntAccesBuzonIvrznData intAccesBuzonIvrzn, \n" + 
    "                             Vector localizationLabels, HashMap userProperties):Entrada");
    
        RecordSet rs = null;
        BelcorpService bs = UtilidadesEJB.getBelcorpService();
              
        StringBuffer update = new StringBuffer();
                                
        RecordSet rsPK = null;
        StringBuffer query = new StringBuffer();      
        Long id = null;
                                
        query.append(" SELECT INT_IBZN_SEQ.NEXTVAL FROM DUAL");
                                
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
           update.append(" INSERT INTO INT_ACCES_BUZON_IVRZN ( ");
           update.append(" OID_ACCE_BUZO_IVRZ, ");
           update.append(" COD_ACCE_BUZO_IVRZ, ");
           update.append(" ZZON_OID_ZONA");
           update.append(" ) VALUES ( ");
           update.append(id + ", ");
           update.append("'" + intAccesBuzonIvrzn.getCodAcceBuzoIvrz() + "', ");
           update.append(intAccesBuzonIvrzn.getZzonOidZona().getId());
                          
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
        
    
    
    
    
        UtilidadesLog.info("DAOINTAccesBuzonIvrZn.guardar((IntAccesBuzonIvrznData intAccesBuzonIvrzn, \n" + 
            "                             Vector localizationLabels, HashMap userProperties):Salida");
    return primaryKey;
    }
    public Vector query(ZonZonaView2Data zonZonaView2From, 
                        ZonZonaView2Data zonZonaView2To, 
                        HashMap userProperties, Boolean applyStructuralSecurity) throws MareException{
    
    
        UtilidadesLog.info("DAOINTAccesBuzonIvrZn.query(ZonZonaView2Data zonZonaView2From, ZonZonaView2Data zonZonaView2To,  HashMap userProperties, Boolean applyStructuralSecurity):Entrada");
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
                    query.append(" SELECT a.OID_ZONA, a.COD_ZONA, b.OID_CANA, c.OID_MARC ");
                    query.append(" FROM ZON_ZONA a,  SEG_CANAL b, SEG_MARCA c   ");
                    query.append(" where a.CANA_OID_CANA = b.OID_CANA");
                    query.append(" and a.MARC_OID_MARC = c.OID_MARC ");
                    if(zonZonaView2From.getCanaOidCana()!=null){
                    query.append(" and b.OID_CANA =" + zonZonaView2From.getCanaOidCana().getId());    
                     }
                     
                                                   
                     
                     
                     try {
                           rs = bs.dbService.executeStaticQuery(query.toString());
                             } catch (Exception ex) {
                               UtilidadesLog.error("ERROR ", ex);
                               throw new MareException(ex, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS));
                                }
                      int cant = rs.getRowCount();
                                                  
                                                
                     ZonZonaView2Data zonZonaView2 = null;
                     SegCanalViewData segCanal = null; 
                     SegMarcaData segMarca = null;
                     for(int i=0; i < cant; i++){
                                                     
                        zonZonaView2  = new ZonZonaView2Data();
                        segCanal = new SegCanalViewData();
                        segMarca = new SegMarcaData();
                                                      
                        zonZonaView2.setId(Long.valueOf(((BigDecimal)rs.getValueAt(i,"OID_ZONA")).toString()));
                        zonZonaView2.setCodZona((String)rs.getValueAt(i,"COD_ZONA"));
                        segCanal.setId(Long.valueOf(((BigDecimal)rs.getValueAt(i,"OID_CANA")).toString()));
                        segMarca.setId(Long.valueOf(((BigDecimal)rs.getValueAt(i,"OID_MARC")).toString()));
                        zonZonaView2.setCanaOidCana(segCanal);
                        zonZonaView2.setMarcOidMarc(segMarca);
                                                      
                         resultado.add(zonZonaView2);
                         }

                                               
                               
                                   UtilidadesLog.info("DAOINTAccesBuzonIvrZn.query(ZonZonaView2Data zonZonaView2From, ZonZonaView2Data zonZonaView2To,  HashMap userProperties, Boolean applyStructuralSecurity):Salida");
                  return resultado;
          }
     }
   
    

