package es.indra.sicc.logicanegocio.cob;

import es.indra.belcorp.mso.CobArgumData;
import es.indra.belcorp.mso.CobValorArgumData;
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

public class DAOValorArgumento {
    public DAOValorArgumento() {
    }
    public Vector query(CobValorArgumData cobValorArgumFrom, CobValorArgumData cobValorArgumTo, HashMap userProperties, Integer pageCount, Integer pageSize) throws MareException
       {   UtilidadesLog.info("DAOCobValorArgumen.query(CobValorArgumData cobValorArgumFrom, CobValorArgumData cobValorArgumTo, HashMap userProperties, Integer pageCount, Integer pageSize):Entrada");
           
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
       
           query.append(" SELECT a.OID_VALO_ARGU, a.VAL_ARGU, a.VAL_DESC_VALO_ARGU, a.VAL_OBSE, b.OID_ARGU, b.COD_ARGU ");
           query.append(" FROM COB_VALOR_ARGUM a, COB_ARGUM b");
           query.append(" WHERE a.ARGU_OID_ARGU = b.OID_ARGU  ");
                                   
            if(cobValorArgumFrom.getId()!= null)
            {
               query.append(" AND OID_VALO_ARGU = " + cobValorArgumFrom.getId());
            }
            if(cobValorArgumFrom.getValArgu()!= null)
            {
               query.append(" AND VAL_ARGU like '" + cobValorArgumFrom.getValArgu() + "'");
            }
           
           if(cobValorArgumFrom.getValDescValoArgu()!= null)
           {
               query.append(" AND VAL_DESC_VALO_ARGU like '" + cobValorArgumFrom.getValDescValoArgu() + "'");
           }
           
           if(cobValorArgumFrom.getArguOidArgu()!= null)
           {
               query.append(" AND OID_ARGU = " + cobValorArgumFrom.getArguOidArgu().getId());
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
           
           CobValorArgumData cobValorArg = null;
           CobArgumData cobArgu = null;
          
           
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
                     
                     cobValorArg = new CobValorArgumData();
                     cobArgu = new CobArgumData();
                     String valObse = null;
                     
                     cobValorArg.setId(Long.valueOf(((BigDecimal)rs.getValueAt(i,"OID_VALO_ARGU")).toString()));
                     cobValorArg.setValArgu((String)rs.getValueAt(i,"VAL_ARGU"));
                     cobValorArg.setValDescValoArgu((String)rs.getValueAt(i,"VAL_DESC_VALO_ARGU"));
                     cobArgu.setId(Long.valueOf(((BigDecimal)rs.getValueAt(i,"OID_ARGU")).toString()));
                     cobArgu.setCodArgu((String)rs.getValueAt(i,"COD_ARGU"));
                     cobValorArg.setArguOidArgu(cobArgu);
                     valObse = (String)rs.getValueAt(i,"VAL_OBSE");
                     if(valObse != null)
                     {  
                          cobValorArg.setValObse(String.valueOf(valObse));
                     }
                     
                                                                             
                                       
                     result.add(cobValorArg);
                     
               }catch(Exception ex)
               {
                 ex.printStackTrace();
               }
               } else {
                  break;
               }
           }
       
       
           UtilidadesLog.info("DAOCobValorArgumen.query(CobValorArgumData cobValorArgumFrom, CobValorArgumData cobValorArgumTo, HashMap userProperties, Integer pageCount, Integer pageSize):Salida");
           return result;
       }
       
        public void update(CobValorArgumData cobValorArgum, Vector localizationLabels) throws MareException
       {   UtilidadesLog.info("DAOCobValorArgumen.update(CobValorArgumData cobValorArgum, Vector localizationLabels):Entrada");
           RecordSet rs = null;
           BelcorpService bs = UtilidadesEJB.getBelcorpService();
              
           StringBuffer update = new StringBuffer();
           update.append("   UPDATE COB_VALOR_ARGUM SET ");
           update.append("           VAL_ARGU = '" + cobValorArgum.getValArgu() + "',");
           update.append("           VAL_DESC_VALO_ARGU = '" + cobValorArgum.getValDescValoArgu() + "'");
           
           if(cobValorArgum.getValObse()!= null)
           {
               update.append(", VAL_OBSE = '" + cobValorArgum.getValObse() + "'");
           }
           else
           {
               update.append(", VAL_OBSE = NULL");
           }
           
          
           update.append("   where OID_VALO_ARGU = " + cobValorArgum.getId());
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
       
       
           UtilidadesLog.info("DAOCobValorArgumen.update(CobValorArgumData cobValorArgum, Vector localizationLabels):Salida");
       }
       
        public void remove(Vector entities) throws MareException
       {   UtilidadesLog.info("DAOCobValorArgumen.remove(Vector entities):Entrada");
       
           RecordSet rs = null;
           BelcorpService bs = UtilidadesEJB.getBelcorpService();
           StringBuffer update = new StringBuffer();
           
           
           int cant = entities.size();
           CobValorArgumData cobValorArg = null;
           String oids = "";
           
           for (int j = 0; j < cant; j++) {
              cobValorArg = (CobValorArgumData)entities.get(j);
                
               oids = oids + "," + cobValorArg.getId();
           }
           
           update.append("DELETE COB_VALOR_ARGUM ");
           update.append("WHERE OID_VALO_ARGU in ( " + oids.substring(1) + ") ");
           
                  
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
       
           UtilidadesLog.info("DAOCobValorArgumen.remove(Vector entities):Salida");
       }
       
       public Hashtable guardar(CobValorArgumData cobValorArgum, Vector localizationLabels, HashMap userProperties) throws MareException
       {   UtilidadesLog.info("DAOCobValorArgumen.guardar(CobValorArgumData cobValorArgum, Vector localizationLabels, HashMap userProperties):Entrada");
       
           RecordSet rs = null;
           BelcorpService bs = UtilidadesEJB.getBelcorpService();
           
           StringBuffer update = new StringBuffer();
           
           RecordSet rsPK = null;
           StringBuffer query = new StringBuffer();      
           Long id = null;
           
           query.append(" SELECT COB_VAAR_SEQ.NEXTVAL FROM DUAL");         
           
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
         update.append(" INSERT INTO COB_VALOR_ARGUM ( ");
         update.append(" OID_VALO_ARGU, ");
         update.append(" VAL_ARGU, ");
         update.append(" VAL_DESC_VALO_ARGU, ");
         update.append(" ARGU_OID_ARGU, ");
         update.append(" VAL_OBSE ");
         update.append(" ) VALUES ( ");
         update.append(id + ", ");
         update.append("'" + cobValorArgum.getValArgu() + "', ");
         update.append("'" + cobValorArgum.getValDescValoArgu() + "',");
         update.append(cobValorArgum.getArguOidArgu().getId());
         
         if(cobValorArgum.getValObse()!= null)
           {
                 update.append(",'" + cobValorArgum.getValObse() + "'");
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
          
          UtilidadesLog.info("DAOCobValorArgumen.guardar(CobValorArgumData cobValorArgum, Vector localizationLabels, HashMap userProperties):Salida"); 
           return primaryKey;
       }
       
        
    public Vector query(CobValorArgumData cobValorArgumFrom, CobValorArgumData cobValorArgumTo, HashMap userProperties, Boolean applyStructuralSecurity) throws MareException {
   {   UtilidadesLog.info("DAOCobValorArgumen.query(CobValorArgumData cobValorArgumFrom, CobValorArgumData cobValorArgumTo, HashMap userProperties, Boolean applyStructuralSecurity):Entrada");
       
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
   
           query.append(" SELECT a.OID_VALO_ARGU, a.VAL_ARGU, a.VAL_DESC_VALO_ARGU, a.VAL_OBSE, b.OID_ARGU, b.COD_ARGU ");
           query.append(" FROM COB_VALOR_ARGUM a, COB_ARGUM b");
           query.append(" WHERE a.ARGU_OID_ARGU = b.OID_ARGU  ");
                                   
            
           if(cobValorArgumFrom.getArguOidArgu()!= null)
           {
               query.append(" AND OID_ARGU = " + cobValorArgumFrom.getArguOidArgu().getId());
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
       
       CobValorArgumData cobValorArg = null;
       CobArgumData cobArgu = null;
       
       for(int i=0; i < cant; i++){
          
           try{
                 
                 cobValorArg = new CobValorArgumData();
                 cobArgu = new CobArgumData();
                 String valObse = null;
                 
                 cobValorArg.setId(Long.valueOf(((BigDecimal)rs.getValueAt(i,"OID_VALO_ARGU")).toString()));
                 cobValorArg.setValArgu((String)rs.getValueAt(i,"VAL_ARGU"));
                 cobValorArg.setValDescValoArgu((String)rs.getValueAt(i,"VAL_DESC_VALO_ARGU"));
                 cobArgu.setId(Long.valueOf(((BigDecimal)rs.getValueAt(i,"OID_ARGU")).toString()));
                 cobArgu.setCodArgu((String)rs.getValueAt(i,"COD_ARGU"));
                 cobValorArg.setArguOidArgu(cobArgu);
                 valObse = (String)rs.getValueAt(i,"VAL_OBSE");
                 if(valObse != null)
                 {  
                      cobValorArg.setValObse(String.valueOf(valObse));
                 }
                 
                                                                         
                                   
                 result.add(cobValorArg);
                 
           }catch(Exception ex)
           {
             ex.printStackTrace();
           }         
       }
   
       UtilidadesLog.info("DAOCobValorArgumen.query(CobValorArgumData cobValorArgumFrom, CobValorArgumData cobValorArgumTo, HashMap userProperties, Boolean applyStructuralSecurity):Salida");
       return result;
   }
}

}
