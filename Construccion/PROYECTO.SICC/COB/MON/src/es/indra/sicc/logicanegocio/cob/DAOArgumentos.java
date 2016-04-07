package es.indra.sicc.logicanegocio.cob;

import es.indra.belcorp.mso.CobArgumData;
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

public class DAOArgumentos {
    public DAOArgumentos() {
    }
    
    public Vector query(CobArgumData cobArgumFrom, CobArgumData cobArgumTo, HashMap userProperties, Integer pageCount, Integer pageSize) throws MareException
        {  
            UtilidadesLog.info("DAOArgumentos.query(CobArgumData cobArgumFrom, CobArgumData cobArgumTo, HashMap userProperties, Integer pageCount, Integer pageSize):Entrada");
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
        
            query.append(" SELECT a.OID_ARGU, a.COD_ARGU, a.VAL_DESC, a.VAL_OBSE, b.OID_PAIS ");
            query.append(" FROM COB_ARGUM a, SEG_PAIS b ");
            query.append(" where a.PAIS_OID_PAIS = b.OID_PAIS");
            
             if(cobArgumFrom.getId()!= null){
                query.append(" AND OID_ARGU = " + cobArgumFrom.getId());
            }
             if(cobArgumFrom.getCodArgu()!= null){
                query.append(" AND COD_ARGU like '" + cobArgumFrom.getCodArgu() + "'");
            }
          
            if(cobArgumFrom.getValDesc()!= null){
                query.append(" AND VAL_DESC like '" + cobArgumFrom.getValDesc()+ "'");
            }
            
                           
            if(cobArgumFrom.getValObse()!= null){
                query.append(" AND VAL_OBSE like' " + cobArgumFrom.getValObse() + "'");
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
            
            CobArgumData cobArg = null;
            SegPaisViewData segPais = null;
            String  valObse = null;
            
            
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
                      cobArg = new CobArgumData();
                      segPais = new SegPaisViewData();
                                       
                      cobArg.setId(Long.valueOf(((BigDecimal)rs.getValueAt(i,"OID_ARGU")).toString())); 
                      cobArg.setCodArgu((String)rs.getValueAt(i,"COD_ARGU"));
                      cobArg.setValDesc((String)rs.getValueAt(i,"VAL_DESC"));
                      segPais.setId(Long.valueOf(((BigDecimal)rs.getValueAt(i,"OID_PAIS")).toString()));
                      cobArg.setPaisOidPais(segPais);
                      
                      valObse = (String)rs.getValueAt(i,"VAL_OBSE");
                      if(valObse !=null)
                      {
                          cobArg.setValObse(String.valueOf(valObse));
                      }
                      result.add(cobArg);
                }catch(Exception ex)
                {
                  ex.printStackTrace();
                }
                } else {
                   break;
                }
           
        
        
        
            UtilidadesLog.info("DAOArgumentos.query(CobArgumData cobArgumFrom, CobArgumData cobArgumTo, HashMap userProperties, Integer pageCount, Integer pageSize):Salida");
            
        }
        return result;
    }

     public void update(CobArgumData cobArgum, Vector localizationLabels) throws MareException
        {UtilidadesLog.info("DAOArgumentos.update(CobArgumData cobArgum, Vector localizationLabels):Entrada");
            RecordSet rs = null;
            BelcorpService bs = UtilidadesEJB.getBelcorpService();
            
            StringBuffer update = new StringBuffer();
                    
            update.append(" UPDATE  COB_ARGUM SET ");
            update.append(" VAL_DESC = '" + cobArgum.getValDesc() + "',");
           
            if(cobArgum.getValObse()!= null)
            {
              update.append(" VAL_OBSE = '" + cobArgum.getValObse() + "'");
            }
            else {
                update.append(" VAL_OBSE = NULL" );} 
           
            update.append(" WHERE OID_ARGU = " + cobArgum.getId());
            
            try {
                int cantRegActualizados = bs.dbService.executeUpdate(update.toString());
            } catch (Exception ex) {
                ex.printStackTrace();
                throw new MareException(ex, UtilidadesError.armarCodigoError(
                                        CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS));
            }
        
        
        
        UtilidadesLog.info("DAOArgumentos.update(CobArgumData cobArgum, Vector localizationLabels):Salida");
        }
        
        
        public void remove(Vector entities) throws MareException
        {   UtilidadesLog.info("DAOArgumentos.remove(Vector entities):Entrada");
                RecordSet rs = null;
            BelcorpService bs = UtilidadesEJB.getBelcorpService();
            StringBuffer update = new StringBuffer();
            
            int cant = entities.size();
            CobArgumData cobArgum = null;
            String oids = "";
            
            for (int j = 0; j < cant; j++) {
                cobArgum = (CobArgumData)entities.get(j);
                 
                oids = oids + "," + cobArgum.getId();
            }
            
            update.append("delete COB_ARGUM ");
            update.append("where OID_ARGU in ( " + oids.substring(1) + ") ");
            
                   
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
            
        
        
            UtilidadesLog.info("DAOArgumentos.remove(Vector entities):Salida");
        }
         public Hashtable guardarArgumentos(CobArgumData cobArgum, Vector localizationLabels, HashMap userProperties) throws MareException
        {   UtilidadesLog.info("DAOArgumentos.guardarArgumentos(CobArgumData cobArgum, Vector localizationLabels, HashMap userProperties):Entrada");
            RecordSet rs = null;
            BelcorpService bs = UtilidadesEJB.getBelcorpService();
            
            StringBuffer update = new StringBuffer();
            
            RecordSet rsPK = null;
            StringBuffer query = new StringBuffer();      
            Long id = null;
            
            query.append(" SELECT COB_ARGU_SEQ.NEXTVAL FROM DUAL");         
            
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
          update.append(" INSERT INTO COB_ARGUM ( ");
          update.append(" OID_ARGU, ");
          update.append(" COD_ARGU, ");
          update.append(" VAL_DESC,");
          update.append(" VAL_OBSE, ");
          update.append(" PAIS_OID_PAIS ");
          update.append(" ) VALUES ( ");
          update.append(id + ", ");
          update.append(" '" + cobArgum.getCodArgu() + "', ");
          update.append(" '" + cobArgum.getValDesc() + "', ");
          if(cobArgum.getValObse()!= null)
          {
              update.append(" '" + cobArgum.getValObse() + "', ");
          }
          else {
             update.append(" NULL," );} 
          update.append(cobArgum.getPaisOidPais().getId());
          
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
         
           UtilidadesLog.info("DAOArgumentos.guardarArgumentos(CobArgumData cobArgum, Vector localizationLabels, HashMap userProperties):Salida");
          return primaryKey;
        }
        
        
           
            
    }
    

