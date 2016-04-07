package es.indra.sicc.logicanegocio.mae;

import es.indra.belcorp.mso.GenDetaSiccData;
import es.indra.belcorp.mso.MaeCicloVidaData;
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

public class DAOCicloVida {
    public DAOCicloVida() {
    }
    public Hashtable guardarCicloVida(MaeCicloVidaData maeCicloVida, Vector localizationLabels, HashMap userProperties)throws MareException
      {
        UtilidadesLog.info("DAOCicloVida.guardarCicloVida(MaeCicloVidaData maeCicloVida, Vector localizationLabels, HashMap userProperties): Entrada");
        RecordSet rs = null;
        BelcorpService bs = UtilidadesEJB.getBelcorpService();     
        StringBuffer update = new StringBuffer();
        StringBuffer updateInter = new StringBuffer();
        RecordSet rsPK = null;
        StringBuffer query = new StringBuffer();      
        Long id = null;
        query.append(" SELECT MAE_TCLV_SEQ.NEXTVAL FROM DUAL ");
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
        update.append(" INSERT INTO MAE_CICLO_VIDA( ");
        update.append("   OID_CICL_VIDA, ");
        update.append("   PAIS_OID_PAIS,  ");
        update.append("   COD_CICL_VIDA  ");
        update.append(" ) VALUES ( ");
        update.append(id);
        update.append(" ," + maeCicloVida.getPaisOidPais().getId());
        update.append(" , '" + maeCicloVida.getCodCiclVida()+"'" );
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
         // Internacionalización
            int cant = localizationLabels.size();
            GenDetaSiccData genDetaSiccData = null;
            RecordSet rsPKInter = null;
            StringBuffer queryInter = null;
            Long idInter = null;        
            
            for(int i= 0; i< cant; i++){
                          
                queryInter = new StringBuffer();             
                queryInter.append(" SELECT GEN_i18n_SEQ.NEXTVAL FROM DUAL");         
                
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
                
                genDetaSiccData = (GenDetaSiccData)localizationLabels.get(i);
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
                updateInter.append(" 'MAE_CICLO_VIDA', ");
                updateInter.append(" 1, ");   
              //UtilidadesLog.debug(" oidPais: "+ genDetaSiccData.getIdioOidIdio().getId());
                updateInter.append(genDetaSiccData.getIdioOidIdio().getId() + ", ");
                updateInter.append(" '" + genDetaSiccData.getDeta() + "', ");
                updateInter.append(id + " )");  
                try {
                    int cantRegActualizados = bs.dbService.executeUpdate(updateInter.toString());
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
            }
            
          Hashtable primaryKey = new Hashtable();
          primaryKey.put("id", id); 
         UtilidadesLog.info("DAOCicloVida.guardarCicloVida(MaeCicloVidaData maeCicloVida, Vector localizationLabels, HashMap userProperties): Salida");
          return primaryKey; 
        
      }
      public Vector query(MaeCicloVidaData maeCicloVidaFrom, MaeCicloVidaData maeCicloVidaTo,  HashMap userProperties, Integer pageCount, Integer pageSize)throws MareException
      {
        UtilidadesLog.info("DAOCicloVida.query(MaeCicloVidaData maeCicloVidaFrom, MaeCicloVidaData maeCicloVidaTo,  HashMap userProperties, Integer pageCount, Integer pageSize): Entrada ");
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
        query.append("  SELECT MAE_CICLO_VIDA.OID_CICL_VIDA, MAE_CICLO_VIDA.COD_CICL_VIDA, ");
        query.append("         I18N.VAL_I18N, MAE_CICLO_VIDA.PAIS_OID_PAIS ");
        query.append("         FROM MAE_CICLO_VIDA, V_GEN_I18N_SICC I18N, SEG_PAIS ");
        query.append("         WHERE MAE_CICLO_VIDA.PAIS_OID_PAIS = SEG_PAIS.OID_PAIS ");
        if(maeCicloVidaFrom.getPaisOidPais() != null){
              query.append("      AND  SEG_PAIS.OID_PAIS = " + maeCicloVidaFrom.getPaisOidPais().getId());
        }
        if(maeCicloVidaFrom.getCodCiclVida() != null){
              query.append(" AND MAE_CICLO_VIDA.COD_CICL_VIDA LIKE '" + maeCicloVidaFrom.getCodCiclVida() + "'");
        }
        query.append("       AND I18N.ATTR_ENTI = 'MAE_CICLO_VIDA' ");
        query.append("       AND I18N.ATTR_NUM_ATRI = 1 ");
        query.append("       AND I18N.IDIO_OID_IDIO = 1 ");
        query.append("       AND I18N.VAL_OID = MAE_CICLO_VIDA.OID_CICL_VIDA ");
        if(maeCicloVidaFrom.getDescripcion() != null)
        {
            query.append(" AND I18N.VAL_I18N LIKE '" + maeCicloVidaFrom.getDescripcion()+ "'");
        }
        if(maeCicloVidaFrom.getId() != null){
            query.append(" AND MAE_CICLO_VIDA.OID_CICL_VIDA =" + maeCicloVidaFrom.getId());
        }
        query.append("   ORDER BY I18N.VAL_I18N DESC ");
        try {
               rs = bs.dbService.executeStaticQuery(query.toString());
            } catch (Exception ex) {
              UtilidadesLog.error("ERROR ", ex);
              throw new MareException(ex, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS));
            }
             int cant = rs.getRowCount();
             Vector result = new Vector();
             MaeCicloVidaData maeCicloVida = null;
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
                       maeCicloVida = new MaeCicloVidaData();
                       maeCicloVida.setId(new Long(((BigDecimal)rs.getValueAt(i,"OID_CICL_VIDA")).toString()));
                       maeCicloVida.setCodCiclVida((String)rs.getValueAt(i,"COD_CICL_VIDA"));
                       maeCicloVida.setDescripcion((String)rs.getValueAt(i,"VAL_I18N"));
                       segPaisViewFrom = new SegPaisViewData();
                       segPaisViewFrom.setId(new Long(((BigDecimal)rs.getValueAt(i,"PAIS_OID_PAIS")).toString()));
                       maeCicloVida.setPaisOidPais(segPaisViewFrom);
                       result.add(maeCicloVida);
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
            UtilidadesLog.info("DAOCicloVida.query(MaeCicloVidaData maeCicloVidaFrom, MaeCicloVidaData maeCicloVidaTo,  HashMap userProperties, Integer pageCount, Integer pageSize): Salida ");
            return result;
        }
        
        public void update(MaeCicloVidaData maeCicloVida, Vector localizationLabels)throws MareException
        {
          UtilidadesLog.info("DAOCicloVida.update(MaeCicloVidaData maeCicloVida, Vector localizationLabels):Entrada ");
          RecordSet rs = null;
          BelcorpService bs = UtilidadesEJB.getBelcorpService();
            
          StringBuffer update = new StringBuffer();
          StringBuffer updateInter = null;
          StringBuffer deleteInter = new StringBuffer();
          StringBuffer queryInter = null;
        
          deleteInter.append(" delete GEN_I18N_SICC_PAIS ");
          deleteInter.append(" where VAL_OID = " + maeCicloVida.getId());
          deleteInter.append(" and ATTR_NUM_ATRI = 1 ");
          deleteInter.append(" and ATTR_ENTI = 'MAE_CICLO_VIDA' ");
         
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
              updateInter.append(" 'MAE_CICLO_VIDA', ");
              updateInter.append(" 1, ");            
              updateInter.append(genDetaSiccData.getIdioOidIdio().getId() + ", ");
              updateInter.append(" '" + genDetaSiccData.getDeta() + "', ");
              updateInter.append(maeCicloVida.getId() + " )");   
               
              try {
                  int cantRegActualizados = bs.dbService.executeUpdate(updateInter.toString());
              } catch (Exception ex) {
                   ex.printStackTrace();
                   throw new MareException(ex, UtilidadesError.armarCodigoError(
                                            CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS));
              }
              
          }
        UtilidadesLog.info("DAOCicloVida.update(MaeCicloVidaData maeCicloVida, Vector localizationLabels): Salida ");  
      }
      public void remove(Vector maeCicloVida) throws MareException
      {
        UtilidadesLog.info("DAOCicloVida.remove(Vector maeCicloVida): Entrada");
        RecordSet rs = null;
        BelcorpService bs = UtilidadesEJB.getBelcorpService();
        StringBuffer update = new StringBuffer();
        StringBuffer updateInter = new StringBuffer();
            
         int cant = maeCicloVida.size();
         MaeCicloVidaData maeCicloVidaFrom = null;
         String oidCicloVida = "";
         for (int j = 0; j < cant; j++) {
                maeCicloVidaFrom = (MaeCicloVidaData)maeCicloVida.get(j);
                 
                oidCicloVida = oidCicloVida + "," + maeCicloVidaFrom.getId();
         }
          update.append("delete MAE_CICLO_VIDA ");
          update.append("where OID_CICL_VIDA in ( " + oidCicloVida.substring(1) + ") ");
          
          updateInter.append("delete GEN_I18N_SICC_PAIS ");
          updateInter.append(" where VAL_OID in ( " + oidCicloVida.substring(1) + ") ");
          updateInter.append(" and ATTR_NUM_ATRI = 1 ");
          updateInter.append(" and ATTR_ENTI = 'MAE_CICLO_VIDA' ");
          
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
        UtilidadesLog.info("DAOCicloVida.remove(Vector maeCicloVida): Salida"); 
      }
}
