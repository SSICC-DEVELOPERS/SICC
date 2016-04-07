package es.indra.sicc.logicanegocio.cal;

import es.indra.belcorp.mso.CalAtribEstadContaData;
import es.indra.belcorp.mso.CalTipoEstadContaData;
import es.indra.belcorp.mso.GenDetaSiccData;

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

public class DAOCalAtrubutoEstadoContacotos {
    public DAOCalAtrubutoEstadoContacotos() {
    }
  
    public Vector query(CalTipoEstadContaData calTipoEstadContaFrom, CalTipoEstadContaData calTipoEstadContaTo, HashMap userProperties)throws MareException{
          UtilidadesLog.info("DAOCalAtributoEstadoContactos.query(CalTipoEstadContaData calTipoEstadContaFrom, CalTipoEstadContaData calTipoEstadContaTo, HashMap userProperties): Entrada");
          RecordSet rs = new RecordSet();
          StringBuffer query = new StringBuffer();
          Vector parametros = new Vector();
          BelcorpService bs;
          try{
                  bs = BelcorpService.getInstance();
            
          } catch(MareMiiServiceNotFoundException ex){
                    
                  throw new MareException(ex, UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_PEDIR_UN_SERVICIO_MARE));
          }
          query.append(" SELECT V_GEN_I18N_SICC.VAL_OID, V_GEN_I18N_SICC.VAL_I18N ");
          query.append("        FROM CAL_TIPO_ESTAD_CONTA, V_GEN_I18N_SICC  ");
          query.append("        WHERE V_GEN_I18N_SICC.ATTR_ENTI = 'CAL_TIPO_ESTAD_CONTA' ");
          query.append("              AND V_GEN_I18N_SICC.ATTR_NUM_ATRI = 1 ");
          query.append("              AND V_GEN_I18N_SICC.IDIO_OID_IDIO = 1  ");
          query.append("              AND V_GEN_I18N_SICC.VAL_OID = CAL_TIPO_ESTAD_CONTA.OID_TIPO_ESTA_CONT ");
          
          try{
              
                  rs = bs.dbService.executeStaticQuery(query.toString());
               
              } catch (Exception ex) {
               
                  throw new MareException(ex, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS));
              }
          if(!rs.esVacio())
          {
            for(int i= 0; i < rs.getRowCount(); i++){
                        CalTipoEstadContaData calTipoEstadConta = new CalTipoEstadContaData();
                        calTipoEstadConta.setId( new Long(((BigDecimal)rs.getValueAt(i,"VAL_OID")).toString()));
                        calTipoEstadConta.setDescripcion((String)rs.getValueAt(i,"VAL_I18N"));
                        parametros.add(calTipoEstadConta);
            }
          }
          UtilidadesLog.info("DAOCalAtributoEstadoContactos.query(CalTipoEstadContaData calTipoEstadContaFrom, CalTipoEstadContaData calTipoEstadContaTo, HashMap userProperties): Salida");
          return parametros;
      }
      public Hashtable guardarAtributosEstadoContactos(CalAtribEstadContaData calAtribEstadConta, Vector localizationLabels, HashMap userProperties)throws MareException
      {
        UtilidadesLog.info("DOACalAtributoEstadoContactos.guardarAtributoEstadoContactos(CalAtribEstadContaData calAtribEstadConta, Vector localizationLabels, HashMap userProperties): Entrada");
        RecordSet rs = null;
        BelcorpService bs = UtilidadesEJB.getBelcorpService();     
        StringBuffer update = new StringBuffer();
        StringBuffer updateInter = new StringBuffer();
        RecordSet rsPK = null;
        StringBuffer query = new StringBuffer();      
        Long id = null;
        query.append(" SELECT CAL_ATEC_SEQ.NEXTVAL FROM DUAL ");
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
        update.append(" INSERT INTO CAL_ATRIB_ESTAD_CONTA( ");
        update.append("              OID_ATRI_ESTA_CONT ");
        update.append("              , COD_ATRI ");
        update.append("              , TECO_OID_TIPO_ESTA_CONT  ");
        update.append(" ) VALUES ( ");
        update.append(id);
        update.append(" , '" + calAtribEstadConta.getCodAtri() +"'");
        update.append(" , " + calAtribEstadConta.getTecoOidTipoEstaCont().getId());
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
                    
                updateInter.append(" INSERT INTO GEN_I18N_SICC_COMUN ( ");
                updateInter.append("OID_I18N, "); 
                updateInter.append("ATTR_ENTI, "); 
                updateInter.append("ATTR_NUM_ATRI, "); 
                updateInter.append("IDIO_OID_IDIO, "); 
                updateInter.append("VAL_I18N, ");                 
                updateInter.append("VAL_OID "); 
                updateInter.append(" ) VALUES ( ");
                updateInter.append(idInter + ", ");
                updateInter.append(" 'CAL_ATRIB_ESTAD_CONTA', ");
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
          UtilidadesLog.info("DOACalAtributoEstadoContactos.guardarAtributoEstadoContactos(CalAtribEstadContaData calAtribEstadConta, Vector localizationLabels, HashMap userProperties): Salida");
          return primaryKey;
      }
      public Vector query(CalAtribEstadContaData calAtribEstadContaFrom, CalAtribEstadContaData calAtribEstadContaTo, HashMap userProperties, Integer pageCount, Integer pageSize)throws MareException
      {
        UtilidadesLog.info("DAOCalAtributoEstadoContactos.query(CalAtribEstadContaData calAtribEstadContaFrom, CalAtribEstadContaData calAtribEstadContaTo, HashMap userProperties, Integer pageCount, Integer pageSize): Entrada");
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
        query.append("  SELECT CAL_ATRIB_ESTAD_CONTA.OID_ATRI_ESTA_CONT, I18N.VAL_I18N DESTIPOESTA, ");
        query.append("         I18N.VAL_OID OIDTIPOESTA, CAL_ATRIB_ESTAD_CONTA.COD_ATRI, V_GEN_I18N_SICC.VAL_I18N DESATRIBESTADCONTA ");
        query.append("         FROM CAL_ATRIB_ESTAD_CONTA, V_GEN_I18N_SICC I18N, CAL_TIPO_ESTAD_CONTA, ");
        query.append("              V_GEN_I18N_SICC  ");
        query.append("              WHERE CAL_ATRIB_ESTAD_CONTA.TECO_OID_TIPO_ESTA_CONT = CAL_TIPO_ESTAD_CONTA.OID_TIPO_ESTA_CONT ");
        if(calAtribEstadContaFrom.getTecoOidTipoEstaCont() != null)
        {
          query.append("                  AND CAL_TIPO_ESTAD_CONTA.OID_TIPO_ESTA_CONT =  " + calAtribEstadContaFrom.getTecoOidTipoEstaCont().getId());
        }
        if(calAtribEstadContaFrom.getCodAtri() != null)
        {
          query.append("                  AND CAL_ATRIB_ESTAD_CONTA.COD_ATRI LIKE '" + calAtribEstadContaFrom.getCodAtri() + "'");
        }
        query.append("                    AND I18N.ATTR_ENTI = 'CAL_TIPO_ESTAD_CONTA' ");
        query.append("                    AND I18N.ATTR_NUM_ATRI = 1 ");
        query.append("                    AND I18N.IDIO_OID_IDIO = 1 ");
        query.append("                    AND I18N.VAL_OID = CAL_TIPO_ESTAD_CONTA.OID_TIPO_ESTA_CONT ");
        
        query.append("                    AND V_GEN_I18N_SICC.ATTR_ENTI = 'CAL_ATRIB_ESTAD_CONTA' ");
        query.append("                    AND V_GEN_I18N_SICC.ATTR_NUM_ATRI = 1 ");
        query.append("                    AND V_GEN_I18N_SICC.IDIO_OID_IDIO = 1 ");
        query.append("                    AND V_GEN_I18N_SICC.VAL_OID =  CAL_ATRIB_ESTAD_CONTA.OID_ATRI_ESTA_CONT ");
        if(calAtribEstadContaFrom.getDescripcion() != null)
        {
          query.append("                  AND V_GEN_I18N_SICC.VAL_I18N LIKE  '"+ calAtribEstadContaFrom.getDescripcion() + "'");
        }
        if(calAtribEstadContaFrom.getId() != null)
        {
          query.append("                  AND CAL_ATRIB_ESTAD_CONTA.OID_ATRI_ESTA_CONT = " + calAtribEstadContaFrom.getId());
        }
        try {
               rs = bs.dbService.executeStaticQuery(query.toString());
        } catch (Exception ex) {
              UtilidadesLog.error("ERROR ", ex);
              throw new MareException(ex, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS));
        }
        int cant = rs.getRowCount();
        Vector result = new Vector();
        CalAtribEstadContaData calAtribEstadConta = null;
        CalTipoEstadContaData calTipoEstadConta = null;
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
                    calAtribEstadConta = new CalAtribEstadContaData();
                    calAtribEstadConta.setId(new Long(((BigDecimal)rs.getValueAt(i,"OID_ATRI_ESTA_CONT")).toString()));
                    calTipoEstadConta = new CalTipoEstadContaData();
                    calTipoEstadConta.setId(new Long(((BigDecimal)rs.getValueAt(i,"OIDTIPOESTA")).toString()));
                    calTipoEstadConta.setDescripcion((String)rs.getValueAt(i,"DESTIPOESTA")); 
                    calAtribEstadConta.setTecoOidTipoEstaCont(calTipoEstadConta);
                    calAtribEstadConta.setCodAtri((String)rs.getValueAt(i,"COD_ATRI"));
                    calAtribEstadConta.setDescripcion((String)rs.getValueAt(i,"DESATRIBESTADCONTA"));
                    result.add(calAtribEstadConta);
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
            UtilidadesLog.info("DAOCalAtributoEstadoContactos.query(CalAtribEstadContaData calAtribEstadContaFrom, CalAtribEstadContaData calAtribEstadContaTo, HashMap userProperties, Integer pageCount, Integer pageSize): Salida");
            return result;
      }
      public void update(CalAtribEstadContaData calAtribEstadConta, Vector localizationLabels)throws MareException
      {
          UtilidadesLog.info("DAOCalAtributoEstadoContactos.update(CalAtribEstadContaData calAtribEstadConta, Vector localizationLabels): Entrada");
          RecordSet rs = null;
          BelcorpService bs = UtilidadesEJB.getBelcorpService();
            
          StringBuffer update = new StringBuffer();
          StringBuffer updateInter = null;
          StringBuffer deleteInter = new StringBuffer();
          StringBuffer queryInter = null;
        
          deleteInter.append(" delete GEN_I18N_SICC_COMUN ");
          deleteInter.append(" where VAL_OID = " + calAtribEstadConta.getId());
          deleteInter.append(" and ATTR_NUM_ATRI = 1 ");
          deleteInter.append(" and ATTR_ENTI = 'CAL_ATRIB_ESTAD_CONTA' ");
         
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
              updateInter.append(" INSERT INTO GEN_I18N_SICC_COMUN ( ");
              updateInter.append("OID_I18N, "); 
              updateInter.append("ATTR_ENTI, "); 
              updateInter.append("ATTR_NUM_ATRI, "); 
              updateInter.append("IDIO_OID_IDIO, "); 
              updateInter.append("VAL_I18N, ");                 
              updateInter.append("VAL_OID "); 
              updateInter.append(" ) VALUES ( ");
              updateInter.append(idInter + ", ");
              updateInter.append(" 'CAL_ATRIB_ESTAD_CONTA', ");
              updateInter.append(" 1, ");            
              updateInter.append(genDetaSiccData.getIdioOidIdio().getId() + ", ");
              updateInter.append(" '" + genDetaSiccData.getDeta() + "', ");
              updateInter.append(calAtribEstadConta.getId() + " )");   
               
              try {
                  int cantRegActualizados = bs.dbService.executeUpdate(updateInter.toString());
              } catch (Exception ex) {
                   ex.printStackTrace();
                   throw new MareException(ex, UtilidadesError.armarCodigoError(
                                            CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS));
              }
              
          }
          UtilidadesLog.info("DAOCalAtributoEstadoContactos.update(CalAtribEstadContaData calAtribEstadConta, Vector localizationLabels): Salida");
      }
      public void remove(Vector calAtributoEstadoContactos)throws MareException
      {
        UtilidadesLog.info("DAOCalAtributoEstadoContactos.remove(Vector calAtributoEstadoContactos): Entrada");
        RecordSet rs = null;
        BelcorpService bs = UtilidadesEJB.getBelcorpService();
        StringBuffer update = new StringBuffer();
        StringBuffer updateInter = new StringBuffer();
            
         int cant = calAtributoEstadoContactos.size();
         CalAtribEstadContaData calAtribEstadConta = null;
         String oidEstadConta = "";
         for (int j = 0; j < cant; j++) {
                calAtribEstadConta = (CalAtribEstadContaData)calAtributoEstadoContactos.get(j);
                 
                oidEstadConta = oidEstadConta + "," + calAtribEstadConta.getId();
         }
          update.append("delete CAL_ATRIB_ESTAD_CONTA ");
          update.append("where OID_ATRI_ESTA_CONT in ( " + oidEstadConta.substring(1) + ") ");
          
          updateInter.append("delete GEN_I18N_SICC_COMUN ");
          updateInter.append(" where VAL_OID in ( " + oidEstadConta.substring(1) + ") ");
          updateInter.append(" and ATTR_NUM_ATRI = 1 ");
          updateInter.append(" and ATTR_ENTI = 'CAL_ATRIB_ESTAD_CONTA' ");
          
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
         UtilidadesLog.info("DAOCalAtributoEstadoContactos.remove(Vector calAtributoEstadoContactos): Salida");
      }
}
