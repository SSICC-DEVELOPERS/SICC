package es.indra.sicc.logicanegocio.ccc;

import es.indra.belcorp.mso.CccTipoTransData;
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

public class DAOCccTipoTransaccion {
    public DAOCccTipoTransaccion() {
    }
    public Hashtable guardarTipoTransaccion(CccTipoTransData cccTipoTrans, Vector localizationLabels, HashMap userProperties)throws MareException
    {
      UtilidadesLog.info("DOACccTipoTransaccion.guardarTipoTransaccion(CccTipoTransData cccTipoTrans, Vector localizationLabels, HashMap userProperties): Entrada");
      RecordSet rs = null;
      BelcorpService bs = UtilidadesEJB.getBelcorpService();     
      StringBuffer update = new StringBuffer();
      StringBuffer updateInter = new StringBuffer();
      RecordSet rsPK = null;
      StringBuffer query = new StringBuffer();      
      Long id = null;
      query.append(" SELECT CCC_TTRA_SEQ.NEXTVAL FROM DUAL ");
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
       update.append(" INSERT INTO CCC_TIPO_TRANS( ");
       update.append("             OID_TIPO_TRAN ");
       update.append("             , PAIS_OID_PAIS ");
       update.append("             , COD_TIPO_TRAN ");
       update.append("             , COD_TIPO_TRAN_CHEQ ");
       update.append(" ) VALUES ( ");
       update.append(id);
       update.append(" , " + cccTipoTrans.getPaisOidPais().getId());
       update.append(" , '" + cccTipoTrans.getCodTipoTran() + "' ");
       update.append(" , '" + cccTipoTrans.getCodTipoTranCheq() + "' ");
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
              updateInter.append(" 'CCC_TIPO_TRANS', ");
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
        UtilidadesLog.info("DOACccTipoTransaccion.guardarTipoTransaccion(CccTipoTransData cccTipoTrans, Vector localizationLabels, HashMap userProperties): Salida"); 
        return primaryKey;
    }
    public Vector query(CccTipoTransData cccTipoTransFrom, CccTipoTransData cccTipoTransTo, HashMap userProperties, Integer pageCount, Integer pageSize )throws MareException
    {
      UtilidadesLog.info("DAOCccTipoTransaccion.query(CccTipoTransData cccTipoTransFrom, CccTipoTransData cccTipoTransTo, HashMap userProperties, Integer pageCount, Integer pageSize): Entrada");
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
      query.append("  SELECT  CCC_TIPO_TRANS.OID_TIPO_TRAN, V_GEN_I18N_SICC.VAL_I18N, CCC_TIPO_TRANS.COD_TIPO_TRAN,");
      query.append("          CCC_TIPO_TRANS.COD_TIPO_TRAN_CHEQ, SEG_PAIS.OID_PAIS ");
      query.append("          FROM CCC_TIPO_TRANS, SEG_PAIS, V_GEN_I18N_SICC  ");
      query.append("               WHERE CCC_TIPO_TRANS.PAIS_OID_PAIS = SEG_PAIS.OID_PAIS ");
      if(cccTipoTransFrom.getCodTipoTran() != null)
      {
          query.append("                 AND CCC_TIPO_TRANS.COD_TIPO_TRAN LIKE '" + cccTipoTransFrom.getCodTipoTran() + "'");
      }
      if(cccTipoTransFrom.getCodTipoTranCheq() != null)
      {
         query.append("                  AND CCC_TIPO_TRANS.COD_TIPO_TRAN_CHEQ = '" + cccTipoTransFrom.getCodTipoTranCheq() + "'");
      }
      query.append("                     AND V_GEN_I18N_SICC.ATTR_ENTI = 'CCC_TIPO_TRANS' ");
      query.append("                     AND V_GEN_I18N_SICC.ATTR_NUM_ATRI = 1 ");
      query.append("                     AND V_GEN_I18N_SICC.IDIO_OID_IDIO = 1 ");
      query.append("                     AND V_GEN_I18N_SICC.VAL_OID = CCC_TIPO_TRANS.OID_TIPO_TRAN  ");
      if(cccTipoTransFrom.getDescripcion() != null)
      {
        query.append("                    AND V_GEN_I18N_SICC.VAL_I18N LIKE '" + cccTipoTransFrom.getDescripcion() +"' ");
      }
      if(cccTipoTransFrom.getId() != null)
      {
        query.append("                     AND CCC_TIPO_TRANS.OID_TIPO_TRAN = " + cccTipoTransFrom.getId());
      }
      try {
             rs = bs.dbService.executeStaticQuery(query.toString());
      } catch (Exception ex) {
            UtilidadesLog.error("ERROR ", ex);
            throw new MareException(ex, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS));
     }
     int cant = rs.getRowCount();
     Vector result = new Vector();
     CccTipoTransData cccTipoTrans = null;
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
                    cccTipoTrans = new CccTipoTransData();
                    cccTipoTrans.setId( new Long(((BigDecimal)rs.getValueAt(i,"OID_TIPO_TRAN")).toString()));
                    cccTipoTrans.setCodTipoTran((String)rs.getValueAt(i,"COD_TIPO_TRAN"));
                    cccTipoTrans.setDescripcion((String)rs.getValueAt(i,"VAL_I18N"));
                    cccTipoTrans.setCodTipoTranCheq((String)rs.getValueAt(i,"COD_TIPO_TRAN_CHEQ"));
                    segPaisViewFrom = new SegPaisViewData();
                    segPaisViewFrom.setId(new Long(((BigDecimal)rs.getValueAt(i,"OID_PAIS")).toString()));
                    cccTipoTrans.setPaisOidPais(segPaisViewFrom);
                    result.add(cccTipoTrans);
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
          UtilidadesLog.info("DAOCccTipoTransaccion.query(CccTipoTransData cccTipoTransFrom, CccTipoTransData cccTipoTransTo, HashMap userProperties, Integer pageCount, Integer pageSize): Salida");
          return result;                
    }
    public void update(CccTipoTransData cccTipoTrans, Vector localizationLabels)throws MareException
    {
        UtilidadesLog.info("DAOCccTipoTransaccion.update(CccTipoTransData cccTipoTrans, Vector localizationLabels): Entrada");
        RecordSet rs = null;
        BelcorpService bs = UtilidadesEJB.getBelcorpService();
          
        StringBuffer update = new StringBuffer();
        StringBuffer updateInter = null;
        StringBuffer deleteInter = new StringBuffer();
        StringBuffer queryInter = null;
      
        deleteInter.append(" delete GEN_I18N_SICC_PAIS ");
        deleteInter.append(" where VAL_OID = " + cccTipoTrans.getId());
        deleteInter.append(" and ATTR_NUM_ATRI = 1 ");
        deleteInter.append(" and ATTR_ENTI = 'CCC_TIPO_TRANS' ");
       
        try {
              int cantRegActualizados1 = bs.dbService.executeUpdate(deleteInter.toString());
              
        } catch (Exception ex) {
              ex.printStackTrace();                      
              throw new MareException(ex, UtilidadesError.armarCodigoError(
                                  CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS)); 
        }
         update.append("UPDATE CCC_TIPO_TRANS SET ");
         update.append("          COD_TIPO_TRAN_CHEQ = '" + cccTipoTrans.getCodTipoTranCheq() + "'");
         update.append("      where  OID_TIPO_TRAN = " + cccTipoTrans.getId());
          try {
            int cantRegActualizados = bs.dbService.executeUpdate(update.toString());
              
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
           updateInter.append(" 'CCC_TIPO_TRANS', ");
           updateInter.append(" 1, ");            
           updateInter.append(genDetaSiccData.getIdioOidIdio().getId() + ", ");
           updateInter.append(" '" + genDetaSiccData.getDeta() + "', ");
           updateInter.append(cccTipoTrans.getId() + " )");   
             
           try {
                int cantRegActualizados = bs.dbService.executeUpdate(updateInter.toString());
           } catch (Exception ex) {
                 ex.printStackTrace();
                 throw new MareException(ex, UtilidadesError.armarCodigoError(
                                          CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS));
           }
            
       }
       UtilidadesLog.info("DAOCccTipoTransaccion.update(CccTipoTransData cccTipoTrans, Vector localizationLabels): Salida");
    }
    public void remove(Vector cccTipoTransaccion)throws MareException
    {
      UtilidadesLog.info("DAOCccTipoTransaccion.remove(Vector cccTipoTransaccion): Entrada");
      RecordSet rs = null;
      BelcorpService bs = UtilidadesEJB.getBelcorpService();
      StringBuffer update = new StringBuffer();
      StringBuffer updateInter = new StringBuffer();
      
      int cant = cccTipoTransaccion.size();
      CccTipoTransData cccTipoTrans = null;
      String oidTipoTransaccion = "";
      for (int j = 0; j < cant; j++) {
          cccTipoTrans = (CccTipoTransData)cccTipoTransaccion.get(j);
           
          oidTipoTransaccion = oidTipoTransaccion + "," + cccTipoTrans.getId();
      }
      update.append("delete CCC_TIPO_TRANS  ");
      update.append("where OID_TIPO_TRAN in ( " + oidTipoTransaccion.substring(1) + ") ");
      
      updateInter.append("delete GEN_I18N_SICC_PAIS ");
      updateInter.append(" where VAL_OID in ( " + oidTipoTransaccion.substring(1) + ") ");
      updateInter.append(" and ATTR_NUM_ATRI = 1 ");
      updateInter.append(" and ATTR_ENTI = 'CCC_TIPO_TRANS' ");
      
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
       UtilidadesLog.info("DAOCccTipoTransaccion.remove(Vector cccTipoTransaccion): Salida");
    }
}
