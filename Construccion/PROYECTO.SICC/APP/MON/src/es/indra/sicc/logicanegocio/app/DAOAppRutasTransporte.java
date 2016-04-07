package es.indra.sicc.logicanegocio.app;

import es.indra.belcorp.mso.AppRutasTransData;
import es.indra.belcorp.mso.GenDetaSiccData;
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

public class DAOAppRutasTransporte {
    public DAOAppRutasTransporte() {
    }
    public Hashtable guaradarRutasTransporte(AppRutasTransData appRutasTrans, Vector localizationLabels, HashMap userProperties)throws MareException
    {
      UtilidadesLog.info("DAOAppRutasTransporte.guardarRutasTransporte(AppRutasTransData appRutasTrans, Vector localizationLabels, HashMap userProperties): Entrada");
      RecordSet rs = null;
      BelcorpService bs = UtilidadesEJB.getBelcorpService();     
      StringBuffer update = new StringBuffer();
      StringBuffer updateInter = new StringBuffer();
      RecordSet rsPK = null;
      StringBuffer query = new StringBuffer();      
      Long id = null;
      query.append(" SELECT APP_RUTR_SEQ.NEXTVAL FROM DUAL ");
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
      update.append("INSERT INTO APP_RUTAS_TRANS ( ");
      update.append("            OID_RUTA_TRAN   ");
      update.append("            , PAIS_OID_PAIS ");
      update.append("            , COD_RUTA ");
      update.append("            , VAL_OBSE ");
      update.append("            , NUM_SECU ");
      update.append("            ) VALUES (  ");
      update.append(id);
      update.append(" , "+ appRutasTrans.getPaisOidPais().getId());
      update.append(", '" + appRutasTrans.getCodRuta() + "'");
      if(appRutasTrans.getValObse() != null)
      {
        update.append(" , '" + appRutasTrans.getValObse() + "'");
      }else
      {
        update.append(" , NULL");
      }
      update.append(" , " + appRutasTrans.getNumSecu());
      update.append("    ) ");
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
              updateInter.append(" 'APP_RUTAS_TRANS', ");
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
        UtilidadesLog.info("DAOAppRutasTransporte.guardarRutasTransporte(AppRutasTransData appRutasTrans, Vector localizationLabels, HashMap userProperties): Entrada");
        return primaryKey;
    }
    public Vector query(AppRutasTransData appRutasTransFrom, AppRutasTransData appRutasTransTo, HashMap userProperties, Integer pageCount, Integer pageSize )throws MareException
    {
      UtilidadesLog.info("DAOAppRutasTransporte.query(AppRutasTransData appRutasTransFrom, AppRutasTransData appRutasTransTo, HashMap userProperties, Integer pageCount, Integer pageSize): Entrada");
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
      query.append("SELECT  APP_RUTAS_TRANS.OID_RUTA_TRAN, APP_RUTAS_TRANS.COD_RUTA, ");
      query.append("        V_GEN_I18N_SICC.VAL_I18N, APP_RUTAS_TRANS.NUM_SECU,  ");
      query.append("        APP_RUTAS_TRANS.VAL_OBSE, SEG_PAIS.OID_PAIS ");
      query.append("        FROM APP_RUTAS_TRANS, V_GEN_I18N_SICC, SEG_PAIS ");
      query.append("        WHERE APP_RUTAS_TRANS.PAIS_OID_PAIS = SEG_PAIS.OID_PAIS ");
      if(appRutasTransFrom.getPaisOidPais() != null)
      {
        query.append("            AND SEG_PAIS.OID_PAIS = " + appRutasTransFrom.getPaisOidPais().getId());
      }
      if(appRutasTransFrom.getCodRuta() != null)
      {
        query.append("             AND APP_RUTAS_TRANS.COD_RUTA LIKE '" + appRutasTransFrom.getCodRuta() + "'");
        
      }
      if(appRutasTransFrom.getNumSecu() != null)
      {
        query.append("             AND APP_RUTAS_TRANS.NUM_SECU  = " + appRutasTransFrom.getNumSecu() );
      }
      query.append("               AND V_GEN_I18N_SICC.ATTR_ENTI = 'APP_RUTAS_TRANS' ");
      query.append("               AND V_GEN_I18N_SICC.ATTR_NUM_ATRI = 1 ");
      query.append("               AND V_GEN_I18N_SICC.IDIO_OID_IDIO = 1 ");
      query.append("               AND V_GEN_I18N_SICC.VAL_OID = APP_RUTAS_TRANS.OID_RUTA_TRAN ");
      if(appRutasTransFrom.getDescripcion() != null)
      {
        query.append("             AND V_GEN_I18N_SICC.VAL_I18N LIKE '" + appRutasTransFrom.getDescripcion() + "'");
      }
      if(appRutasTransFrom.getId() != null)
      {
        query.append("              AND APP_RUTAS_TRANS.OID_RUTA_TRAN = " + appRutasTransFrom.getId());
      }
       try {
             rs = bs.dbService.executeStaticQuery(query.toString());
      } catch (Exception ex) {
            UtilidadesLog.error("ERROR ", ex);
            throw new MareException(ex, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS));
      }
      int cant = rs.getRowCount();
      Vector result = new Vector();
      AppRutasTransData appRutasTrans = null;
      SegPaisViewData segPaisViewFrom = null;
      String valObse = null;
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
                  appRutasTrans = new AppRutasTransData();
                  appRutasTrans.setId(new Long(((BigDecimal)rs.getValueAt(i,"OID_RUTA_TRAN")).toString()));
                  appRutasTrans.setCodRuta((String)rs.getValueAt(i,"COD_RUTA"));
                  appRutasTrans.setDescripcion((String)rs.getValueAt(i,"VAL_I18N"));
                  appRutasTrans.setNumSecu(new Long(((BigDecimal)rs.getValueAt(i,"NUM_SECU")).toString()));
                  valObse = (String)rs.getValueAt(i,"VAL_OBSE");
                  if(valObse != null)
                  {
                    appRutasTrans.setValObse(valObse);
                  }
                     segPaisViewFrom = new SegPaisViewData();
                     segPaisViewFrom.setId( new Long(((BigDecimal)rs.getValueAt(i,"OID_PAIS")).toString()));
                     appRutasTrans.setPaisOidPais(segPaisViewFrom);
                     result.add(appRutasTrans);
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
          UtilidadesLog.info("DAOAppRutasTransporte.query(AppRutasTransData appRutasTransFrom, AppRutasTransData appRutasTransTo, HashMap userProperties, Integer pageCount, Integer pageSize): Salida");
          return result;
    }
    public void update(AppRutasTransData  appRutasTrans, Vector localizationLabels)throws MareException
    {
        UtilidadesLog.info("DAOAppRutasTransporte.update(AppRutasTransData  appRutasTrans, Vector localizationLabels): Entrada");
        RecordSet rs = null;
        BelcorpService bs = UtilidadesEJB.getBelcorpService();
          
        StringBuffer update = new StringBuffer();
        StringBuffer updateInter = null;
        StringBuffer deleteInter = new StringBuffer();
        StringBuffer queryInter = null;
      
        deleteInter.append(" delete GEN_I18N_SICC_PAIS ");
        deleteInter.append(" where VAL_OID = " + appRutasTrans.getId());
        deleteInter.append(" and ATTR_NUM_ATRI = 1 ");
        deleteInter.append(" and ATTR_ENTI = 'APP_RUTAS_TRANS' ");
       
        try {
              int cantRegActualizados1 = bs.dbService.executeUpdate(deleteInter.toString());
              
        } catch (Exception ex) {
              ex.printStackTrace();                      
              throw new MareException(ex, UtilidadesError.armarCodigoError(
                                  CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS));           
        }
        update.append("UPDATE APP_RUTAS_TRANS SET ");
        update.append("       NUM_SECU = " + appRutasTrans.getNumSecu());
        if(appRutasTrans.getValObse() != null)
        {
           update.append("     , VAL_OBSE = '" + appRutasTrans.getValObse() + "'");
        }else
        {
           update.append("     , VAL_OBSE = NULL");
        }
        update.append(" where OID_RUTA_TRAN = " + appRutasTrans.getId());
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
           updateInter.append(" 'APP_RUTAS_TRANS', ");
           updateInter.append(" 1, ");            
           updateInter.append(genDetaSiccData.getIdioOidIdio().getId() + ", ");
           updateInter.append(" '" + genDetaSiccData.getDeta() + "', ");
           updateInter.append(appRutasTrans.getId() + " )");   
             
           try {
                int cantRegActualizados = bs.dbService.executeUpdate(updateInter.toString());
           } catch (Exception ex) {
                 ex.printStackTrace();
                 throw new MareException(ex, UtilidadesError.armarCodigoError(
                                          CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS));
           }
            
       }
       UtilidadesLog.info("DAOAppRutasTransporte.update(AppRutasTransData  appRutasTrans, Vector localizationLabels): Salida");
    }
    public void remove(Vector appRutasTransporte)throws MareException
    {
      UtilidadesLog.info("DAOAppRutasTransporte.remove(Vector appRutasTransporte): Entrada");
      RecordSet rs = null;
      BelcorpService bs = UtilidadesEJB.getBelcorpService();
      StringBuffer update = new StringBuffer();
      StringBuffer updateInter = new StringBuffer();
      
      int cant = appRutasTransporte.size();
      AppRutasTransData  appRutasTrans = null;
      String oidRutasTransporte = "";
      for (int j = 0; j < cant; j++) {
          appRutasTrans = (AppRutasTransData)appRutasTransporte.get(j);
           
          oidRutasTransporte = oidRutasTransporte + "," + appRutasTrans.getId();
      }
      update.append("delete APP_RUTAS_TRANS  ");
      update.append("where OID_RUTA_TRAN in ( " + oidRutasTransporte.substring(1) + ") ");
      
      updateInter.append("delete GEN_I18N_SICC_PAIS ");
      updateInter.append(" where VAL_OID in ( " + oidRutasTransporte.substring(1) + ") ");
      updateInter.append(" and ATTR_NUM_ATRI = 1 ");
      updateInter.append(" and ATTR_ENTI = 'APP_RUTAS_TRANS' ");
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
      UtilidadesLog.info("DAOAppRutasTransporte.remove(Vector appRutasTransporte): Salida");
      
    }
}
