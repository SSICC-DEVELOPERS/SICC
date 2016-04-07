package es.indra.sicc.logicanegocio.car;

import es.indra.belcorp.mso.CarJerarData;
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

public class DAOJerarquias {
    public DAOJerarquias() {
    }
    
    public Vector query(CarJerarData carJerarFrom, CarJerarData carJerarTo, HashMap userProperties, Integer pageCount, Integer pageSize) throws MareException
        {UtilidadesLog.info("DAOCarJerarquias.query(CarJerarData carJerarFrom, CarJerarData carJerarTo, HashMap userProperties, Integer pageCount, Integer pageSize): Entrada");
        
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
        
            query.append(" SELECT  OID_JERA, COD_JERA, NUM_DIAS, VAL_PORC_LINE_CRED, VAL_PORC_MONT_MAXI ");
            query.append(" FROM  CAR_JERAR ");
            query.append(" WHERE 1 = 1");
            
             if(carJerarFrom.getId()!= null){
                query.append(" AND OID_JERA = " + carJerarFrom.getId());
            }
             if(carJerarFrom.getCodJera()!= null){
                query.append(" AND COD_JERA like '" + carJerarFrom.getCodJera() + "'");
            }
          
            if(carJerarFrom.getNumDias()!= null){
                query.append(" AND NUM_DIAS = " + carJerarFrom.getNumDias());
            }
            
            if(carJerarFrom.getValPorcLineCred()!= null){
                query.append(" AND VAL_PORC_LINE_CRED = " + carJerarFrom.getValPorcLineCred());
            }
                    
            if(carJerarFrom.getValPorcMontMaxi()!= null){
                query.append(" AND VAL_PORC_MONT_MAXI = " + carJerarFrom.getValPorcMontMaxi());
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
            
            CarJerarData carJerarquia = null;
            
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
                      carJerarquia= new CarJerarData();
                      
                      BigDecimal valMaxi = null;
                     
                     
                      carJerarquia.setId(Long.valueOf(((BigDecimal)rs.getValueAt(i,"OID_JERA")).toString())); 
                      carJerarquia.setCodJera((String)rs.getValueAt(i,"COD_JERA"));
                      carJerarquia.setNumDias(Long.valueOf(((BigDecimal)rs.getValueAt(i,"NUM_DIAS")).toString()));
                      carJerarquia.setValPorcLineCred(Double.valueOf(((BigDecimal)rs.getValueAt(i,"VAL_PORC_LINE_CRED")).toString()));
                      carJerarquia.setValPorcMontMaxi(Double.valueOf(((BigDecimal)rs.getValueAt(i,"VAL_PORC_MONT_MAXI")).toString()));      
                       
                                       
                      result.add(carJerarquia);
                }catch(Exception ex)
                {
                  ex.printStackTrace();
                }
                } else {
                   break;
                }
           
          UtilidadesLog.info("DAOCarJerarquias.query(CarJerarData carJerarFrom, CarJerarData carJerarTo, HashMap userProperties, Integer pageCount, Integer pageSize): Salida");
         
            
        }
           return result;
        }
        
        public Hashtable guardarJerarquias(CarJerarData carJerar, Vector localizationLabels, HashMap userProperties) throws MareException
        {UtilidadesLog.info("DAOCarJerarquias.guardarJerarquias(CarJerarData carJerar, Vector localizationLabels, HashMap userProperties ): Entrada");
            RecordSet rs = null;
            BelcorpService bs = UtilidadesEJB.getBelcorpService();
            
            StringBuffer update = new StringBuffer();
            
            RecordSet rsPK = null;
            StringBuffer query = new StringBuffer();      
            Long id = null;
            
            query.append(" SELECT CAR_JERA_SEQ.NEXTVAL FROM DUAL");         
            
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
          update.append(" INSERT INTO CAR_JERAR ( ");
          update.append(" OID_JERA, ");
          update.append(" COD_JERA, ");
          update.append(" NUM_DIAS,");
          update.append(" VAL_PORC_LINE_CRED, ");
          update.append(" VAL_PORC_MONT_MAXI ");
          update.append(" ) VALUES ( ");
          update.append(id + ", ");
          update.append(" '" + carJerar.getCodJera() + "', ");
          update.append(carJerar.getNumDias() + ", ");
          update.append(carJerar.getValPorcLineCred() + ", ");
          update.append(carJerar.getValPorcMontMaxi());
          
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
          UtilidadesLog.info("DAOCarJerarquias.guardarJerarquias(CarJerarData carJerar, Vector localizationLabels, HashMap userProperties ): Salida");
          
          return primaryKey;
        }
        
        public void remove(Vector entities) throws MareException
        {   UtilidadesLog.info("DAOCarJerarquias.remove(Vector carJerar): Entrada");
            RecordSet rs = null;
            BelcorpService bs = UtilidadesEJB.getBelcorpService();
            StringBuffer update = new StringBuffer();
            //StringBuffer updateInter = new StringBuffer();
            
            int cant = entities.size();
            CarJerarData carJerar = null;
            String oids = "";
            
            for (int j = 0; j < cant; j++) {
                carJerar = (CarJerarData)entities.get(j);
                 
                oids = oids + "," + carJerar.getId();
            }
            
            update.append("delete CAR_JERAR ");
            update.append("where OID_JERA in ( " + oids.substring(1) + ") ");
            
                   
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
            
                
        
        UtilidadesLog.info("DAOCarJerarquias.remove(Vector carJerar): Salida");
        }    
        
         public void update(CarJerarData carJerar, Vector localizationLabels) throws MareException
        {UtilidadesLog.info("DAOCarJerarquias.update(CarJerarData carJerar, Vector localizationLabels): Entrada");
        
            RecordSet rs = null;
            BelcorpService bs = UtilidadesEJB.getBelcorpService();
            
            StringBuffer update = new StringBuffer();
                    
            update.append(" UPDATE  CAR_JERAR SET ");
            update.append(" COD_JERA = '" + carJerar.getCodJera() + "',");
            update.append(" NUM_DIAS = " + carJerar.getNumDias() + ",");
            update.append(" VAL_PORC_LINE_CRED = " + carJerar.getValPorcLineCred() + ",");
            update.append(" VAL_PORC_MONT_MAXI = " + carJerar.getValPorcMontMaxi());
            update.append(" WHERE OID_JERA = " + carJerar.getId());
            
            try {
                int cantRegActualizados = bs.dbService.executeUpdate(update.toString());
            } catch (Exception ex) {
                ex.printStackTrace();
                throw new MareException(ex, UtilidadesError.armarCodigoError(
                                        CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS));
            }
          UtilidadesLog.info("DAOCarJerarquias.update(CarJerarData carJerar, Vector localizationLabels): Salida");
          
        }
}
