package es.indra.sicc.logicanegocio.mae;

import es.indra.belcorp.mso.GenDetaSiccData;
import es.indra.belcorp.mso.MaeNegocData;
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
import java.util.Vector;

public class DAONegocio {
    public DAONegocio() {
    }
    public Vector query(MaeNegocData maeNegocFrom, MaeNegocData maeNegocTo, HashMap userProperties, Integer pageCount, Integer pageSize)throws MareException
      {
        UtilidadesLog.info("DAONegocio.query(MaeNegocData maeNegocFrom, MaeNegocData maeNegocTo, HashMap userProperties, Integer pageCount, Integer pageSize): Entrada");
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
        query.append("    SELECT MAE_NEGOC.OID_NEGO, MAE_NEGOC.COD_NEGO, ");
        query.append("           V_GEN_I18N_SICC.VAL_I18N DESNEGOCIO,  ");
        query.append("           SEG_PAIS.OID_PAIS ");
        query.append("           FROM MAE_NEGOC, V_GEN_I18N_SICC, SEG_PAIS ");
        query.append("           WHERE MAE_NEGOC.PAIS_OID_PAIS = SEG_PAIS.OID_PAIS ");
        if(maeNegocFrom.getPaisOidPais() != null)
        {
            query.append("             AND SEG_PAIS.OID_PAIS = " + maeNegocFrom.getPaisOidPais().getId());  
        }
        if(maeNegocFrom.getCodNego() != null)
        {
            query.append("             AND MAE_NEGOC.COD_NEGO LIKE '" + maeNegocFrom.getCodNego() + "' ");
        }
        query.append("                 AND V_GEN_I18N_SICC.ATTR_ENTI = 'MAE_NEGOC' ");
        query.append("                 AND V_GEN_I18N_SICC.ATTR_NUM_ATRI = 1 ");
        query.append("                 AND V_GEN_I18N_SICC.IDIO_OID_IDIO = 1 ");
        query.append("                 AND V_GEN_I18N_SICC.VAL_OID = MAE_NEGOC.OID_NEGO ");
        if(maeNegocFrom.getDescripcion() != null)
        {
            query.append("             AND  V_GEN_I18N_SICC.VAL_I18N LIKE '" + maeNegocFrom.getDescripcion() + "' "); 
        }
        if(maeNegocFrom.getId() != null)
        {
           query.append("              AND MAE_NEGOC.OID_NEGO = " + maeNegocFrom.getId());
        }
        try {
                
               rs = bs.dbService.executeStaticQuery(query.toString());
        } catch (Exception ex) {
            
              ex.printStackTrace();
              UtilidadesLog.error("ERROR ", ex);
              throw new MareException(ex, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS));
        }
        int cant = rs.getRowCount();
        Vector result = new Vector();
        MaeNegocData maeNegoc = null;
        SegPaisViewData segPaisViewFrom = null; 
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
                    maeNegoc = new  MaeNegocData(); 
                    maeNegoc.setId( new Long(((BigDecimal)rs.getValueAt(i,"OID_NEGO")).toString()));
                    maeNegoc.setCodNego( (String)rs.getValueAt(i,"COD_NEGO"));
                    maeNegoc.setDescripcion((String)rs.getValueAt(i,"DESNEGOCIO"));
                    segPaisViewFrom = new SegPaisViewData();
                    segPaisViewFrom.setId( new Long(((BigDecimal)rs.getValueAt(i,"OID_PAIS")).toString()));
                    maeNegoc.setPaisOidPais(segPaisViewFrom);
                    result.add(maeNegoc);
                }catch(Exception ex)
                {
                   ex.printStackTrace();
                   UtilidadesLog.error("ERROR ", ex);
                 }
                 }else
                 {
                  break;
                 }
            }    
             UtilidadesLog.debug("result: " + result);    
             UtilidadesLog.info("DAONegocio.query(MaeNegocData maeNegocFrom, MaeNegocData maeNegocTo, HashMap userProperties, Integer pageCount, Integer pageSize): Salida");
             return result;
      }
      public void update(MaeNegocData maeNegoc, Vector localizationLabels)throws MareException
      {
          UtilidadesLog.info("DAONegocio.update(MaeNegocData maeNegoc, Vector localizationLabels): Entrada" );
          RecordSet rs = null;
          BelcorpService bs = UtilidadesEJB.getBelcorpService();
            
          StringBuffer update = new StringBuffer();
          StringBuffer updateInter = null;
          StringBuffer deleteInter = new StringBuffer();
          StringBuffer queryInter = null;
        
          deleteInter.append(" delete GEN_I18N_SICC_PAIS ");
          deleteInter.append(" where VAL_OID = " + maeNegoc.getId());
          deleteInter.append(" and ATTR_NUM_ATRI = 1 ");
          deleteInter.append(" and ATTR_ENTI = 'MAE_NEGOC' ");
         
          try {
                int cantRegActualizados1 = bs.dbService.executeUpdate(deleteInter.toString());
                
          } catch (Exception ex) {
                ex.printStackTrace();                      
                throw new MareException(ex, UtilidadesError.armarCodigoError(
                                    CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS));           
          }
           int cant = localizationLabels.size();
           GenDetaSiccData genDetaSiccData = null;
           RecordSet rsPKInter = null;
           Long idInter = null;  
           for(int i = 0; i < cant; i++){
              queryInter = new StringBuffer();
              genDetaSiccData = (GenDetaSiccData)localizationLabels.get(i);                                         
              queryInter.append("SELECT GEN_i18n_SEQ.NEXTVAL FROM DUAL");      
              try {
                  rsPKInter = bs.dbService.executeStaticQuery(queryInter.toString());                
              } catch (Exception ex) {
                  ex.printStackTrace();
                  throw new MareException(ex, UtilidadesError.armarCodigoError(
                                            CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS));
              }
                
              if(rsPKInter != null && !rsPKInter.esVacio()) {
                   idInter = Long.valueOf(((BigDecimal)rsPKInter.getValueAt(0,0)).toString());
              }      
              updateInter = new StringBuffer(); 
              updateInter.append(" INSERT INTO GEN_I18N_SICC_PAIS ( ");
              updateInter.append("OID_I18N, "); 
              updateInter.append("ATTR_ENTI, "); 
              updateInter.append("ATTR_NUM_ATRI, "); 
              updateInter.append("IDIO_OID_IDIO, "); 
              updateInter.append("VAL_I18N, ");                 
              updateInter.append("VAL_OID "); 
              updateInter.append(" ) VALUES ( ");
              updateInter.append(idInter + ", ");
              updateInter.append(" 'MAE_NEGOC', ");
              updateInter.append(" 1, ");            
              updateInter.append(genDetaSiccData.getIdioOidIdio().getId() + ", ");
              updateInter.append(" '" + genDetaSiccData.getDeta() + "', ");
              updateInter.append(maeNegoc.getId() + " )");   
               
              try {
                  int cantRegActualizados = bs.dbService.executeUpdate(updateInter.toString());
              } catch (Exception ex) {
                   ex.printStackTrace();
                   throw new MareException(ex, UtilidadesError.armarCodigoError(
                                            CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS));
              }
              
          }
          UtilidadesLog.info("DAONegocio.update(MaeNegocData maeNegoc, Vector localizationLabels): Salida");
      }
      public void remove(Vector maeNegocio)throws MareException
      {
         UtilidadesLog.info("DAONegocio.remove(Vector maeNegocio): Entrada");
         RecordSet rs = null;
         BelcorpService bs = UtilidadesEJB.getBelcorpService();
         StringBuffer update = new StringBuffer();
         StringBuffer updateInter = new StringBuffer();
            
         int cant =maeNegocio.size();
         MaeNegocData maeNegoc = null;
         String oidNegocio = "";
         for (int j = 0; j < cant; j++) {
                maeNegoc = (MaeNegocData)maeNegocio.get(j);
                 
                oidNegocio = oidNegocio + "," + maeNegoc.getId();
         }
          update.append("delete MAE_NEGOC ");
          update.append("where OID_NEGO in ( " + oidNegocio.substring(1) + ") ");
          
          updateInter.append("delete GEN_I18N_SICC_PAIS ");
          updateInter.append(" where VAL_OID in ( " + oidNegocio.substring(1) + ") ");
          updateInter.append(" and ATTR_NUM_ATRI = 1 ");
          updateInter.append(" and ATTR_ENTI = 'MAE_NEGOC' ");
          
          try {
                int cantRegActualizados = bs.dbService.executeUpdate(update.toString());
                int cantRegActualizados1 = bs.dbService.executeUpdate(updateInter.toString());
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
         UtilidadesLog.info("DAONegocio.remove(Vector maeNegocio): Salida");
      }
}
