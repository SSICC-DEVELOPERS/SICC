package es.indra.sicc.logicanegocio.mae;

import es.indra.belcorp.mso.GenDetaSiccData;
import es.indra.belcorp.mso.MaeGenerData;
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

public class DAOGenerico {
    public DAOGenerico() {
    }
    public Vector query(MaeGenerData maeGenerFrom, MaeGenerData maeGenerTo, HashMap userProperties, Integer pageCount, Integer pageSize)throws MareException
      {
        UtilidadesLog.info("DAOGenerico.query(MaeGenerData maeGenerFrom, MaeGenerData maeGenerTo, HashMap userProperties, Integer pageCount, Integer pageSize): Entrada");
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
        query.append(" SELECT MAE_GENER.OID_GENE, MAE_GENER.COD_GENE, V_GEN_I18N_SICC.VAL_I18N, ");
        query.append("        MAE_GENER.PAIS_OID_PAIS ");
        query.append("        FROM MAE_GENER, SEG_PAIS, V_GEN_I18N_SICC");
        query.append("        WHERE MAE_GENER.PAIS_OID_PAIS = SEG_PAIS.OID_PAIS ");
        if(maeGenerFrom.getPaisOidPais() != null)
        {
              query.append("        AND SEG_PAIS.OID_PAIS = " + maeGenerFrom.getPaisOidPais().getId());
        }
        if(maeGenerFrom.getCodGene() != null)
        {
              query.append("         AND MAE_GENER.COD_GENE LIKE '" + maeGenerFrom.getCodGene() + "'");
        }
        query.append("              AND V_GEN_I18N_SICC.ATTR_ENTI = 'MAE_GENER' ");
        query.append("              AND V_GEN_I18N_SICC.ATTR_NUM_ATRI = 1 ");
        query.append("              AND V_GEN_I18N_SICC.IDIO_OID_IDIO = 1 ");
        query.append("              AND V_GEN_I18N_SICC.VAL_OID = MAE_GENER.OID_GENE ");
        if(maeGenerFrom.getDescripcion() != null)
        {
               query.append("        AND V_GEN_I18N_SICC.VAL_I18N LIKE '" + maeGenerFrom.getDescripcion() +"'"); 
        }
                            
        if(maeGenerFrom.getId() != null)
        {
               query.append("        AND MAE_GENER.OID_GENE = " + maeGenerFrom.getId());
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
        MaeGenerData maeGener = null;
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
                    maeGener = new MaeGenerData();
                    maeGener.setId(new Long(((BigDecimal)rs.getValueAt(i,"OID_GENE")).toString()));
                    maeGener.setDescripcion((String)rs.getValueAt(i,"VAL_I18N"));
                    maeGener.setCodGene((String)rs.getValueAt(i,"COD_GENE"));
                    segPaisViewFrom = new SegPaisViewData(); 
                    segPaisViewFrom.setId( new Long(((BigDecimal)rs.getValueAt(i,"PAIS_OID_PAIS")).toString()));
                    maeGener.setPaisOidPais(segPaisViewFrom);
                    result.add(maeGener);
                                         
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
             UtilidadesLog.info("DAOGenerico.query(MaeGenerData maeGenerFrom, MaeGenerData maeGenerTo, HashMap userProperties, Integer pageCount, Integer pageSize): Salida");
             return result;
      }
      public void update(MaeGenerData maeGener, Vector localizationLabels)throws MareException
      {
          UtilidadesLog.info("DAOGenerico.update(MaeGenerData maeGener, Vector localizationLabels): Entrada");
          RecordSet rs = null;
          BelcorpService bs = UtilidadesEJB.getBelcorpService();
            
          StringBuffer update = new StringBuffer();
          StringBuffer updateInter = null;
          StringBuffer deleteInter = new StringBuffer();
          StringBuffer queryInter = null;
        
          deleteInter.append(" delete GEN_I18N_SICC_PAIS ");
          deleteInter.append(" where VAL_OID = " + maeGener.getId());
          deleteInter.append(" and ATTR_NUM_ATRI = 1 ");
          deleteInter.append(" and ATTR_ENTI = 'MAE_GENER' ");
         
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
              updateInter.append(" 'MAE_GENER', ");
              updateInter.append(" 1, ");            
              updateInter.append(genDetaSiccData.getIdioOidIdio().getId() + ", ");
              updateInter.append(" '" + genDetaSiccData.getDeta() + "', ");
              updateInter.append(maeGener.getId() + " )");   
               
              try {
                  int cantRegActualizados = bs.dbService.executeUpdate(updateInter.toString());
              } catch (Exception ex) {
                   ex.printStackTrace();
                   throw new MareException(ex, UtilidadesError.armarCodigoError(
                                            CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS));
              }
              
          }
           UtilidadesLog.info("DAOGenerico.update(MaeGenerData maeGener, Vector localizationLabels): Salida");
      }
      public void remove(Vector maeGenerico)throws MareException
      {
         UtilidadesLog.info("DAOGenerico.remove(Vector maeGenerico): Entrada");
         RecordSet rs = null;
         BelcorpService bs = UtilidadesEJB.getBelcorpService();
         StringBuffer update = new StringBuffer();
         StringBuffer updateInter = new StringBuffer();
            
         int cant =maeGenerico.size();
         MaeGenerData maeGener= null;
         String oidGenerico = "";
         for (int j = 0; j < cant; j++) {
                maeGener = (MaeGenerData)maeGenerico.get(j);
                 
                oidGenerico = oidGenerico + "," + maeGener.getId();
         }
          update.append("delete MAE_GENER ");
          update.append("where OID_GENE in ( " + oidGenerico.substring(1) + ") ");
          
          updateInter.append("delete GEN_I18N_SICC_PAIS ");
          updateInter.append(" where VAL_OID in ( " + oidGenerico.substring(1) + ") ");
          updateInter.append(" and ATTR_NUM_ATRI = 1 ");
          updateInter.append(" and ATTR_ENTI = 'MAE_GENER' ");
          
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
          UtilidadesLog.info("DAOGenerico.remove(Vector maeGenerico): Salida");
      }
}
