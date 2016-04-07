package es.indra.sicc.logicanegocio.mae;

import es.indra.belcorp.mso.GenDetaSiccData;
import es.indra.belcorp.mso.MaeEstatClienData;
import es.indra.belcorp.mso.MaeEstatClienViewData;
import es.indra.belcorp.mso.MaeTipoEstatClienViewData;
import es.indra.mare.common.exception.MareException;
import es.indra.mare.common.mii.MareMiiServiceNotFoundException;
import es.indra.mare.common.mii.services.jdbcservice.RecordSet;
import es.indra.sicc.util.BelcorpService;
import es.indra.sicc.util.CodigosError;
import es.indra.sicc.util.UtilidadesEJB;
import es.indra.sicc.util.UtilidadesError;
import es.indra.sicc.util.UtilidadesLog;

import java.math.BigDecimal;

import java.sql.Date;

import java.text.SimpleDateFormat;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.Vector;

public class DAOEstatusClien {
    public DAOEstatusClien() {
    }
    public Vector query(MaeTipoEstatClienViewData maeTipoEstatClienViewFrom, MaeTipoEstatClienViewData maeTipoEstatClienViewTo, HashMap userProperties)throws MareException
      {
        UtilidadesLog.info("DAOEstatusCliente.query(MaeTipoEstatClienViewData maeTipoEstatClienViewFrom, MaeTipoEstatClienViewData maeTipoEstatClienViewTo, HashMap userProperties): Entrada");
        RecordSet rs = new RecordSet();
        StringBuffer query = new StringBuffer();
        Vector parametros = new Vector();
        BelcorpService bs;
        try{
                bs = BelcorpService.getInstance();
            
        } catch(MareMiiServiceNotFoundException ex){
                    
               throw new MareException(ex, UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_PEDIR_UN_SERVICIO_MARE));
        }
        query.append(" SELECT MAE_TIPO_ESTAT_CLIEN.OID_TIPO_ESTA, MAE_TIPO_ESTAT_CLIEN.COD_TIPO_ESTA ");
        query.append(" FROM MAE_TIPO_ESTAT_CLIEN ");
        try{
              
                  rs = bs.dbService.executeStaticQuery(query.toString());
               
              } catch (Exception ex) {
               
                  throw new MareException(ex, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS));
              }
          if(!rs.esVacio())
          {
            for(int i= 0; i < rs.getRowCount(); i++){
                  MaeTipoEstatClienViewData maeTipoEstatClienView = new MaeTipoEstatClienViewData();
                  maeTipoEstatClienView.setId(new Long(((BigDecimal)rs.getValueAt(i,"OID_TIPO_ESTA")).toString()));
                  maeTipoEstatClienView.setCodTipoEsta((String)rs.getValueAt(i,"COD_TIPO_ESTA"));
                  parametros.add(maeTipoEstatClienView);
            }
          }
          UtilidadesLog.info("DAOEstatusCliente.query(MaeTipoEstatClienViewData maeTipoEstatClienViewFrom, MaeTipoEstatClienViewData maeTipoEstatClienViewTo, HashMap userProperties): Salida");
          return parametros;  
      }
      public Vector query(MaeTipoEstatClienViewData maeTipoEstatClienViewFrom, MaeTipoEstatClienViewData maeTipoEstatClienViewTo, HashMap userProperties, Boolean applyStructuralSecurity)throws MareException
      {
        UtilidadesLog.info("DAOEstatusCliente.query(MaeTipoEstatClienViewData maeTipoEstatClienViewFrom, MaeTipoEstatClienViewData maeTipoEstatClienViewTo, HashMap userProperties, Boolean applyStructuralSecurity): Entrada");
        RecordSet rs = new RecordSet();
        StringBuffer query = new StringBuffer();
        StringBuffer queryUser = new StringBuffer();
        Vector parametros = new Vector();
        BelcorpService bs;  
        try
        {
            bs = BelcorpService.getInstance();
               
        }catch(Exception ex)
        {
           throw new MareException(ex, UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_PEDIR_UN_SERVICIO_MARE));
        }
         
        query.append(" SELECT MAE_TIPO_ESTAT_CLIEN.OID_TIPO_ESTA, MAE_TIPO_ESTAT_CLIEN.COD_TIPO_ESTA ");
        query.append(" FROM MAE_TIPO_ESTAT_CLIEN ");
        try{
              
                rs = bs.dbService.executeStaticQuery(query.toString());
               
         } catch (Exception ex) {
              
                 throw new MareException(ex, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS));
         }
          if(!rs.esVacio())
          {
            for(int i= 0; i < rs.getRowCount(); i++){
                  MaeTipoEstatClienViewData maeTipoEstatClienView = new MaeTipoEstatClienViewData();
                  maeTipoEstatClienView.setId(new Long(((BigDecimal)rs.getValueAt(i,"OID_TIPO_ESTA")).toString()));
                  maeTipoEstatClienView.setCodTipoEsta((String)rs.getValueAt(i,"COD_TIPO_ESTA"));
                  parametros.add(maeTipoEstatClienView);
            }
          }
          UtilidadesLog.info("DAOEstatusCliente.query(MaeTipoEstatClienViewData maeTipoEstatClienViewFrom, MaeTipoEstatClienViewData maeTipoEstatClienViewTo, HashMap userProperties, Boolean applyStructuralSecurity): Salida");
          return parametros;      
      }
      public Vector query(MaeEstatClienViewData maeEstatClienViewFrom, MaeEstatClienViewData maeEstatClienViewTo, HashMap userProperties)throws MareException
      {
        UtilidadesLog.info("DAOEstatusCliente.query(MaeEstatClienViewData maeEstatClienViewFrom, MaeEstatClienViewData maeEstatClienViewTo, HashMap userProperties): Entrada");
        RecordSet rs = new RecordSet();
        StringBuffer query = new StringBuffer();
        StringBuffer queryUser = new StringBuffer();
        Vector parametros = new Vector();
        BelcorpService bs;  
        try
        {
            bs = BelcorpService.getInstance();
               
        }catch(Exception ex)
        {
           throw new MareException(ex, UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_PEDIR_UN_SERVICIO_MARE));
        }
        query.append(" SELECT ESTA1.OID_ESTA_CLIE, I18N.VAL_I18N ");
        query.append("       FROM GEN_I18N_SICC_COMUN I18N, MAE_ESTAT_CLIEN ESTA1 ");
        query.append("       WHERE I18N.ATTR_ENTI = 'MAE_ESTAT_CLIEN'  ");
        query.append("             AND I18N.ATTR_NUM_ATRI = 1 ");
        query.append("             AND I18N.IDIO_OID_IDIO = 1 ");
        query.append("             AND I18N.VAL_OID = ESTA1.OID_ESTA_CLIE ");
        query.append("             order by I18N.VAL_I18N ");
        try{
              
                rs = bs.dbService.executeStaticQuery(query.toString());
               
         } catch (Exception ex) {
              
                 throw new MareException(ex, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS));
         }
          if(!rs.esVacio())
          {
            for(int i= 0; i < rs.getRowCount(); i++){
                MaeEstatClienViewData maeEstatClienView = new MaeEstatClienViewData();
                maeEstatClienView.setId(new Long(((BigDecimal)rs.getValueAt(i,"OID_ESTA_CLIE")).toString()));
                maeEstatClienView.setDescripcion((String)rs.getValueAt(i,"VAL_I18N"));
                parametros.add(maeEstatClienView);
            }
          }
          UtilidadesLog.info("DAOEstatusCliente.query(MaeEstatClienViewData maeEstatClienViewFrom, MaeEstatClienViewData maeEstatClienViewTo, HashMap userProperties): Salida");
          return parametros;      
      }
      public Hashtable guardarEstatusCliente(MaeEstatClienData maeEstatClien, Vector localizationLabels, HashMap userProperties)throws MareException
      {
        UtilidadesLog.info("DAOEstatusCliente.guardarEstatusCliente(MaeEstatClienData maeEstatClien, Vector localizationLabels, HashMap userProperties): Entrada");
        RecordSet rs = null;
        BelcorpService bs = UtilidadesEJB.getBelcorpService();     
        StringBuffer update = new StringBuffer();
        StringBuffer updateInter = new StringBuffer();
        RecordSet rsPK = null;
        StringBuffer query = new StringBuffer();      
        Long id = null;
        query.append(" SELECT MAE_ESTA_SEQ.NEXTVAL FROM DUAL ");
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
        update.append(" INSERT INTO MAE_ESTAT_CLIEN ( ");
        update.append("  OID_ESTA_CLIE, ");
        update.append("  COD_ESTA_CLIE, ");
        update.append("  TESC_OID_TIPO_ESTA, ");
        update.append("  ESTA_OID_ESTA_CLIE,");
        update.append("  FEC_ULTI_ACTU ");
        update.append(" ) VALUES ( ");
        update.append(id);
        update.append(" ,'" + maeEstatClien.getCodEstaClie() +"'" );
        update.append(" ," + maeEstatClien.getTescOidTipoEsta().getId());
        if(maeEstatClien.getEstaOidEstaClie() != null){
            update.append(" ," + maeEstatClien.getEstaOidEstaClie().getId());
        }else{
              update.append(" , NULL");
        }      
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        Date date = new Date(System.currentTimeMillis());
        update.append(",  TO_DATE('").append(sdf.format(date)).append("','DD/MM/YYYY HH24:MI:SS') ");
        update.append( " ) ");
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
                updateInter.append(" 'MAE_ESTAT_CLIEN', ");
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
         UtilidadesLog.info("DAOEstatusCliente.guardarEstatusCliente(MaeEstatClienData maeEstatClien, Vector localizationLabels, HashMap userProperties): Salida");
         return primaryKey; 
      }
      public Vector query(MaeEstatClienData maeEstatClienFrom, MaeEstatClienData maeEstatClienTo, HashMap userProperties, Integer pageCount, Integer pageSize)throws MareException
      {
         UtilidadesLog.info("DAOEstatusCliente.query(MaeEstatClienData maeEstatClienFrom, MaeEstatClienData maeEstatClienTo, HashMap userProperties, Integer pageCount, Integer pageSize): Entrada");
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
         query.append("  SELECT MAE_ESTAT_CLIEN.OID_ESTA_CLIE, MAE_TIPO_ESTAT_CLIEN.COD_TIPO_ESTA, MAE_ESTAT_CLIEN.COD_ESTA_CLIE, ");
         query.append("         MAE_TIPO_ESTAT_CLIEN.OID_TIPO_ESTA, V_GEN_I18N_SICC.VAL_I18N DESCRIPCION, ");
         query.append("         I18N.VAL_I18N, I18N.VAL_OID  ");
         query.append("         FROM  MAE_ESTAT_CLIEN, MAE_TIPO_ESTAT_CLIEN,  ");
         query.append("               MAE_ESTAT_CLIEN ESTAT, V_GEN_I18N_SICC,  ");
         query.append("               V_GEN_I18N_SICC I18N ");
         query.append("         WHERE MAE_ESTAT_CLIEN.ESTA_OID_ESTA_CLIE = ESTAT.OID_ESTA_CLIE (+) ");
         query.append("               AND MAE_ESTAT_CLIEN.TESC_OID_TIPO_ESTA = MAE_TIPO_ESTAT_CLIEN.OID_TIPO_ESTA ");
         if(maeEstatClienFrom.getTescOidTipoEsta() != null)
         {
            query.append("            AND MAE_TIPO_ESTAT_CLIEN.OID_TIPO_ESTA = " + maeEstatClienFrom.getTescOidTipoEsta().getId());
         }
         if(maeEstatClienFrom.getCodEstaClie() != null)
         {
           query.append("            AND  MAE_ESTAT_CLIEN.COD_ESTA_CLIE LIKE '" + maeEstatClienFrom.getCodEstaClie() + "'");
         }
         query.append("              AND V_GEN_I18N_SICC.ATTR_ENTI = 'MAE_ESTAT_CLIEN' ");
         query.append("              AND V_GEN_I18N_SICC.ATTR_NUM_ATRI = 1 ");
         query.append("              AND V_GEN_I18N_SICC.IDIO_OID_IDIO = 1 ");
         query.append("              AND V_GEN_I18N_SICC.VAL_OID = MAE_ESTAT_CLIEN.OID_ESTA_CLIE ");
         if(maeEstatClienFrom.getDescripcion() != null)
         {
            query.append("           AND V_GEN_I18N_SICC.VAL_I18N LIKE '" + maeEstatClienFrom.getDescripcion() + "'");
         }
         
         query.append("              AND I18N.ATTR_ENTI (+)= 'MAE_ESTAT_CLIEN' ");
         query.append("              AND I18N.ATTR_NUM_ATRI (+)= 1 ");
         query.append("              AND I18N.IDIO_OID_IDIO (+)= 1  ");
         query.append("              AND I18N.VAL_OID (+)= ESTAT.OID_ESTA_CLIE ");
         if(maeEstatClienFrom.getEstaOidEstaClie() != null)
         {
           query.append(" AND ESTAT.OID_ESTA_CLIE = " + maeEstatClienFrom.getEstaOidEstaClie().getId());
         }
         if(maeEstatClienFrom.getId() != null)
         {
            query.append("           AND MAE_ESTAT_CLIEN.OID_ESTA_CLIE = " + maeEstatClienFrom.getId());
         }
         query.append("              ORDER BY MAE_ESTAT_CLIEN.COD_ESTA_CLIE ");
         
         try {
               rs = bs.dbService.executeStaticQuery(query.toString());
         } catch (Exception ex) {
              UtilidadesLog.error("ERROR ", ex);
              throw new MareException(ex, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS));
         }
             int cant = rs.getRowCount();
             Vector result = new Vector();
             MaeEstatClienData maeEstatClien = null; 
             MaeEstatClienData maeEstatClien2 = null;
             MaeEstatClienViewData maeEstatClienViewFrom = null;
             MaeTipoEstatClienViewData maeTipoEstatClienViewFrom = null; 
             BigDecimal oidEstaClien = null; 
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
                        maeEstatClien = new MaeEstatClienData();
                        maeEstatClien.setId(new Long(((BigDecimal)rs.getValueAt(i,"OID_ESTA_CLIE")).toString()));
                        maeEstatClien.setCodEstaClie((String)rs.getValueAt(i,"COD_ESTA_CLIE"));
                        oidEstaClien = (BigDecimal)rs.getValueAt(i,"VAL_OID");
                      
                        if(oidEstaClien != null)
                        {
                          
                        
                            maeEstatClienViewFrom = new MaeEstatClienViewData();
                            maeEstatClienViewFrom.setId(Long.valueOf(oidEstaClien.toString()));
                            maeEstatClienViewFrom.setDescripcion((String)rs.getValueAt(i,"VAL_I18N"));
                            maeEstatClien.setEstaOidEstaClie(maeEstatClienViewFrom);
                        }
                        maeEstatClien.setDescripcion((String)rs.getValueAt(i,"DESCRIPCION"));
                        maeTipoEstatClienViewFrom =  new MaeTipoEstatClienViewData();
                        maeTipoEstatClienViewFrom.setId(new Long(((BigDecimal)rs.getValueAt(i,"OID_TIPO_ESTA")).toString()));
                        maeTipoEstatClienViewFrom.setCodTipoEsta((String)rs.getValueAt(i,"COD_TIPO_ESTA"));
                        maeEstatClien.setTescOidTipoEsta(maeTipoEstatClienViewFrom);
                        result.add(maeEstatClien);
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
            UtilidadesLog.info("DAOEstatusCliente.query(MaeEstatClienData maeEstatClienFrom, MaeEstatClienData maeEstatClienTo, HashMap userProperties, Integer pageCount, Integer pageSize): Salida");
            return result;
      }
     public void update(MaeEstatClienData maeEstatClien, Vector localizationLabels)throws MareException
     {
        UtilidadesLog.info("DAOEstatusCliente.update(MaeEstatClienData maeEstatClien, Vector localizationLabels): Entrada ");
        RecordSet rs = null;
        BelcorpService bs = UtilidadesEJB.getBelcorpService();
            
        StringBuffer update = new StringBuffer();
        StringBuffer updateInter = null;
        StringBuffer deleteInter = new StringBuffer();
        StringBuffer queryInter = null;
        
        deleteInter.append(" delete GEN_I18N_SICC_COMUN ");
        deleteInter.append(" where VAL_OID = " + maeEstatClien.getId());
        deleteInter.append(" and ATTR_NUM_ATRI = 1 ");
        deleteInter.append(" and ATTR_ENTI = 'MAE_ESTAT_CLIEN' ");
        try {
              int cantRegActualizados1 = bs.dbService.executeUpdate(deleteInter.toString());
                
          } catch (Exception ex) {
                ex.printStackTrace();                      
                throw new MareException(ex, UtilidadesError.armarCodigoError(
                          CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS));           
          }
        update.append(" UPDATE MAE_ESTAT_CLIEN SET ");
        if(maeEstatClien.getEstaOidEstaClie() != null){
            update.append("        ESTA_OID_ESTA_CLIE = "+ maeEstatClien.getEstaOidEstaClie().getId());
        }else
        {
            update.append("        ESTA_OID_ESTA_CLIE = NULL  ");
        }
        update.append("        where OID_ESTA_CLIE = " + maeEstatClien.getId());
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
             updateInter.append(" INSERT INTO GEN_I18N_SICC_COMUN ( ");
             updateInter.append("OID_I18N, "); 
             updateInter.append("ATTR_ENTI, "); 
             updateInter.append("ATTR_NUM_ATRI, "); 
             updateInter.append("IDIO_OID_IDIO, "); 
             updateInter.append("VAL_I18N, ");                 
             updateInter.append("VAL_OID "); 
             updateInter.append(" ) VALUES ( ");
             updateInter.append(idInter + ", ");
             updateInter.append(" 'MAE_ESTAT_CLIEN', ");
             updateInter.append(" 1, ");            
             updateInter.append(genDetaSiccData.getIdioOidIdio().getId() + ", ");
             updateInter.append(" '" + genDetaSiccData.getDeta() + "', ");
             updateInter.append(maeEstatClien.getId() + " )");   
               
             try {
                  int cantRegActualizados = bs.dbService.executeUpdate(updateInter.toString());
             } catch (Exception ex) {
                   ex.printStackTrace();
                   throw new MareException(ex, UtilidadesError.armarCodigoError(
                                            CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS));
             }
              
         }
         UtilidadesLog.info("DAOEstatusCliente.update(MaeEstatClienData maeEstatClien, Vector localizationLabels): Salida ");
     }
     public void remove(Vector maeEstatCliente)throws MareException
     {
            UtilidadesLog.info("DAOEstatusCliente.remove(Vector maeEstatCliente):Entrada ");
            RecordSet rs = null;
            BelcorpService bs = UtilidadesEJB.getBelcorpService();
            StringBuffer update = new StringBuffer();
            StringBuffer updateInter = new StringBuffer();
            
            int cant = maeEstatCliente.size();
            MaeEstatClienData maeEstatClien = null;
            String oidEstatusCliente = "";
            for (int j = 0; j < cant; j++) {
                maeEstatClien = (MaeEstatClienData)maeEstatCliente.get(j);
                 
                oidEstatusCliente = oidEstatusCliente + "," + maeEstatClien.getId();
            }
            update.append("delete MAE_ESTAT_CLIEN   ");
            update.append("where OID_ESTA_CLIE in ( " + oidEstatusCliente.substring(1) + ") ");
            
            updateInter.append("delete GEN_I18N_SICC_COMUN ");
            updateInter.append(" where VAL_OID in ( " + oidEstatusCliente.substring(1) + ") ");
            updateInter.append(" and ATTR_NUM_ATRI = 1 ");
            updateInter.append(" and ATTR_ENTI = 'MAE_ESTAT_CLIEN' ");
            
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
                 UtilidadesLog.info("DAOEstatusCliente.remove(Vector maeEstatCliente): Salida ");

     }
}
