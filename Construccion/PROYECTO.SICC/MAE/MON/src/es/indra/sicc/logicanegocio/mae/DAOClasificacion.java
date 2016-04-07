package es.indra.sicc.logicanegocio.mae;

import es.indra.belcorp.mso.GenDetaSiccData;
import es.indra.belcorp.mso.MaeClasiData;
import es.indra.belcorp.mso.MaeSubtiClienData;
import es.indra.belcorp.mso.MaeTipoClasiClienData;
import es.indra.belcorp.mso.MaeTipoClienData;
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

public class DAOClasificacion {
    public DAOClasificacion() {
    }
    public Vector query(MaeTipoClienData maeTipoClienFrom, MaeTipoClienData maeTipoClienTo, HashMap userProperties)throws MareException
      {
        UtilidadesLog.info("DAOClasificacion.query(MaeTipoClienData maeTipoClienFrom, MaeTipoClienData maeTipoClienTo, HashMap userProperties): Entrada");
        RecordSet rs = new RecordSet();
        StringBuffer query = new StringBuffer();
        Vector parametros = new Vector();
        BelcorpService bs;
        try{
                bs = BelcorpService.getInstance();
            
        } catch(MareMiiServiceNotFoundException ex){
                    
                throw new MareException(ex, UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_PEDIR_UN_SERVICIO_MARE));
        }
        try{
        query.append(" SELECT I18N.VAL_OID, I18N.VAL_I18N ");
        query.append("    FROM V_GEN_I18N_SICC I18N, MAE_TIPO_CLIEN ");
        query.append("    WHERE I18N.ATTR_ENTI = 'MAE_TIPO_CLIEN' ");
        query.append("    AND I18N.ATTR_NUM_ATRI = 1 ");
        query.append("    AND I18N.IDIO_OID_IDIO = 1 ");
        query.append("    AND I18N.VAL_OID = MAE_TIPO_CLIEN.OID_TIPO_CLIE ");
        if(maeTipoClienFrom.getId() != null)
        {
          query.append(" AND MAE_TIPO_CLIEN.OID_TIPO_CLIE = " + maeTipoClienFrom.getId());
        }
        query.append("    ORDER BY I18N.VAL_I18N  ");
        }catch(Exception ex)
        {
          ex.printStackTrace();
        }
        try{         
                 rs = bs.dbService.executeStaticQuery(query.toString());
               
        } catch (Exception ex) {
                ex.printStackTrace();
                throw new MareException(ex, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS));
        }
          if(!rs.esVacio())
          {
            for(int i= 0; i < rs.getRowCount(); i++){
            MaeTipoClienData maeTipoClien = new MaeTipoClienData();
            maeTipoClien.setId(new Long(((BigDecimal)rs.getValueAt(i,"VAL_OID")).toString()));
            maeTipoClien.setDescripcion((String) rs.getValueAt(i,"VAL_I18N"));
            
            parametros.add(maeTipoClien);
           }
         }

         UtilidadesLog.info("DAOClasificacion.query(MaeTipoClienData maeTipoClienFrom, MaeTipoClienData maeTipoClienTo, HashMap userProperties): Salida");
         return parametros;
      }
      public Vector query(MaeSubtiClienData maeSubtiClienFrom, MaeSubtiClienData maeSubtiClienTo, HashMap userProperties)throws MareException
      {
        UtilidadesLog.info("DAOClasificacion.query(MaeSubtiClienData maeSubtiClienFrom, MaeSubtiClienData maeSubtiClienTo, HashMap userProperties): Entrada");
        RecordSet rs = new RecordSet();
        StringBuffer query = new StringBuffer();
        Vector parametros = new Vector();
        BelcorpService bs;
        try{
                bs = BelcorpService.getInstance();
            
        } catch(MareMiiServiceNotFoundException ex){
                    
                throw new MareException(ex, UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_PEDIR_UN_SERVICIO_MARE));
        }
        try{
        query.append(" SELECT I18N.VAL_OID, I18N.VAL_I18N, MAE_TIPO_CLIEN.OID_TIPO_CLIE ");
        query.append("  FROM V_GEN_I18N_SICC I18N,  MAE_SUBTI_CLIEN,  MAE_TIPO_CLIEN ");
        query.append("  WHERE  MAE_SUBTI_CLIEN.TICL_OID_TIPO_CLIE = MAE_TIPO_CLIEN.OID_TIPO_CLIE");
        query.append("  AND I18N.ATTR_ENTI = 'MAE_SUBTI_CLIEN' ");
        query.append("  AND I18N.ATTR_NUM_ATRI = 1 ");
        query.append("  AND I18N.IDIO_OID_IDIO = 1 ");
        query.append("  AND I18N.VAL_OID = MAE_SUBTI_CLIEN.OID_SUBT_CLIE ");
        if(maeSubtiClienFrom.getId() != null)
        {
          query.append(" AND MAE_SUBTI_CLIEN.OID_SUBT_CLIE = " + maeSubtiClienFrom.getId());
        }
        if(maeSubtiClienFrom.getTiclOidTipoClie() != null)
        {
           query.append(" AND MAE_TIPO_CLIEN.OID_TIPO_CLIE =" + maeSubtiClienFrom.getTiclOidTipoClie().getId());
        }
        }catch(Exception ex)
        {
          ex.printStackTrace();
        }
        try{         
                 rs = bs.dbService.executeStaticQuery(query.toString());
               
        } catch (Exception ex) {
               ex.printStackTrace();
                throw new MareException(ex, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS));
        }
          if(!rs.esVacio())
          {
            for(int i= 0; i < rs.getRowCount(); i++){
                MaeSubtiClienData maeSubtiClien = new MaeSubtiClienData();
                maeSubtiClien.setId(new Long(((BigDecimal)rs.getValueAt(i,"VAL_OID")).toString()));
                maeSubtiClien.setDescripcion((String)rs.getValueAt(i,"VAL_I18N"));
                MaeTipoClienData maeTipoClienFrom = new MaeTipoClienData();
                maeTipoClienFrom.setId(new Long(((BigDecimal)rs.getValueAt(i,"OID_TIPO_CLIE")).toString()));
                maeSubtiClien.setTiclOidTipoClie(maeTipoClienFrom);
                parametros.add(maeSubtiClien);
            }
          }
          UtilidadesLog.info("DAOClasificacion.query(MaeSubtiClienData maeSubtiClienFrom, MaeSubtiClienData maeSubtiClienTo, HashMap userProperties): Salida");
          return parametros;
      }
      public Vector query(MaeSubtiClienData maeSubtiClienFrom, MaeSubtiClienData maeSubtiClienTo, HashMap userProperties, Boolean applyStructuralSecurity)throws MareException
      {
        UtilidadesLog.info("DAOClasificacion.query(MaeSubtiClienData maeSubtiClienFrom, MaeSubtiClienData maeSubtiClienTo, HashMap userProperties, Boolean applyStructuralSecurity):Entrada");
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
         if(!applyStructuralSecurity.booleanValue())
            {
              query.append(" SELECT I18N.VAL_OID, I18N.VAL_I18N, MAE_TIPO_CLIEN.OID_TIPO_CLIE ");
              query.append("  FROM V_GEN_I18N_SICC I18N,  MAE_SUBTI_CLIEN, MAE_TIPO_CLIEN  ");
              query.append("  WHERE  MAE_SUBTI_CLIEN.TICL_OID_TIPO_CLIE = MAE_TIPO_CLIEN.OID_TIPO_CLIE");
              if(maeSubtiClienFrom.getTiclOidTipoClie() != null)
              {
                   query.append(" AND MAE_TIPO_CLIEN.OID_TIPO_CLIE =" + maeSubtiClienFrom.getTiclOidTipoClie().getId());
              }if(maeSubtiClienFrom.getId() != null)
              {
                   query.append(" AND MAE_SUBTI_CLIEN.OID_SUBT_CLIE = " + maeSubtiClienFrom.getId() ); 
              }          
              query.append("  AND I18N.ATTR_ENTI = 'MAE_SUBTI_CLIEN' ");
              query.append("  AND I18N.ATTR_NUM_ATRI = 1 ");
              query.append("  AND I18N.IDIO_OID_IDIO = 1 ");
              query.append("  AND I18N.VAL_OID = MAE_SUBTI_CLIEN.OID_SUBT_CLIE ");
            }else
            {
              query.append(" SELECT I18N.VAL_OID, I18N.VAL_I18N, MAE_TIPO_CLIEN.OID_TIPO_CLIE ");
              query.append("  FROM V_GEN_I18N_SICC I18N,  MAE_SUBTI_CLIEN, MAE_TIPO_CLIEN  ");
              query.append("  WHERE  MAE_SUBTI_CLIEN.TICL_OID_TIPO_CLIE = MAE_TIPO_CLIEN.OID_TIPO_CLIE");
              if(maeSubtiClienFrom.getTiclOidTipoClie() != null)
              {
                   query.append(" AND MAE_TIPO_CLIEN.OID_TIPO_CLIE =" + maeSubtiClienFrom.getTiclOidTipoClie().getId());
              }if(maeSubtiClienFrom.getId() != null)
              {
                   query.append(" AND MAE_SUBTI_CLIEN.OID_SUBT_CLIE = " + maeSubtiClienFrom.getId() ); 
              }          
              query.append("  AND I18N.ATTR_ENTI = 'MAE_SUBTI_CLIEN' ");
              query.append("  AND I18N.ATTR_NUM_ATRI = 1 ");
              query.append("  AND I18N.IDIO_OID_IDIO = 1 ");
              query.append("  AND I18N.VAL_OID = MAE_SUBTI_CLIEN.OID_SUBT_CLIE ");
            }
            try
              {
                rs = bs.dbService.executeStaticQuery(query.toString());
         
               }catch (Exception ex) {
               
                  throw new MareException(ex, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS));
             }
            if(!rs.esVacio())
            {
                for(int i= 0; i < rs.getRowCount(); i++){
                    MaeSubtiClienData maeSubtiClien = new MaeSubtiClienData();
                    maeSubtiClien.setId(new Long(((BigDecimal)rs.getValueAt(i,"VAL_OID")).toString()));
                    maeSubtiClien.setDescripcion((String)rs.getValueAt(i,"VAL_I18N"));
                    MaeTipoClienData maeTipoClienFrom = new MaeTipoClienData();
                    maeTipoClienFrom.setId(new Long(((BigDecimal)rs.getValueAt(i,"OID_TIPO_CLIE")).toString()));
                    maeSubtiClien.setTiclOidTipoClie(maeTipoClienFrom);
                    parametros.add(maeSubtiClien);
                }
            }
              UtilidadesLog.info("DAOClasificacion.query(MaeSubtiClienData maeSubtiClienFrom, MaeSubtiClienData maeSubtiClienTo, HashMap userProperties, Boolean applyStructuralSecurity): Salida");
             return parametros;
      }
      public Vector query(MaeTipoClasiClienData maeTipoClasiClienFrom, MaeTipoClasiClienData maeTipoClasiClienTo, HashMap userProperties, Boolean  applyStructuralSecurity)throws MareException
      {
        UtilidadesLog.info("DAOClasificacion.query(MaeTipoClasiClienData maeTipoClasiClienFrom, MaeTipoClasiClienData maeTipoClasiClienTo, HashMap userProperties, Boolean  applyStructuralSecurity):Entrada ");
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
         if(!applyStructuralSecurity.booleanValue())
         {
              query.append("  SELECT I18N.VAL_OID, I18N.VAL_I18N ");
              query.append("  FROM V_GEN_I18N_SICC I18N,  MAE_TIPO_CLASI_CLIEN ");
              query.append("    WHERE  ");
              query.append("         MAE_TIPO_CLASI_CLIEN.SBTI_OID_SUBT_CLIE = " + maeTipoClasiClienFrom.getSbtiOidSubtClie().getId());
              query.append("         AND I18N.ATTR_ENTI (+)= 'MAE_TIPO_CLASI_CLIEN' ");
              query.append("         AND I18N.ATTR_NUM_ATRI (+)= 1 ");
              query.append("         AND I18N.IDIO_OID_IDIO (+)= 1  ");
              query.append("         AND I18N.VAL_OID (+)= MAE_TIPO_CLASI_CLIEN.OID_TIPO_CLAS ");
         }else
         {
              query.append("  SELECT I18N.VAL_OID, I18N.VAL_I18N ");
              query.append("  FROM V_GEN_I18N_SICC I18N,  MAE_TIPO_CLASI_CLIEN ");
              query.append("    WHERE  ");
              query.append("         MAE_TIPO_CLASI_CLIEN.SBTI_OID_SUBT_CLIE = " + maeTipoClasiClienFrom.getSbtiOidSubtClie().getId());
              query.append("         AND I18N.ATTR_ENTI (+)= 'MAE_TIPO_CLASI_CLIEN' ");
              query.append("         AND I18N.ATTR_NUM_ATRI (+)= 1 ");
              query.append("         AND I18N.IDIO_OID_IDIO (+)= 1  ");
              query.append("         AND I18N.VAL_OID (+)= MAE_TIPO_CLASI_CLIEN.OID_TIPO_CLAS ");
         }
          try
             {
                 rs = bs.dbService.executeStaticQuery(query.toString());
         
              }catch (Exception ex) {
               
                 throw new MareException(ex, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS));
              }
            if(!rs.esVacio())
            {
                for(int i= 0; i < rs.getRowCount(); i++){
                      MaeTipoClasiClienData maeTipoClasiClien = new MaeTipoClasiClienData();
                      maeTipoClasiClien.setId(new Long(((BigDecimal)rs.getValueAt(i,"VAL_OID")).toString()));
                      maeTipoClasiClien.setDescripcion((String)rs.getValueAt(i,"VAL_I18N"));
                      parametros.add(maeTipoClasiClien);
                }
            }
            UtilidadesLog.info("DAOClasificacion.query(MaeTipoClasiClienData maeTipoClasiClienFrom, MaeTipoClasiClienData maeTipoClasiClienTo, HashMap userProperties, Boolean  applyStructuralSecurity):Salida ");
            return parametros;
      }
      
      public Hashtable guardarClasificacion(MaeClasiData maeClasi, Vector localizationLabels, HashMap userProperties)throws MareException
      {
        UtilidadesLog.info("DAOClasificacion.guardarClasificacion(MaeClasiData maeClasi, Vector localizationLabels, HashMap userProperties): Entrada ");
        RecordSet rs = null;
        BelcorpService bs = UtilidadesEJB.getBelcorpService();     
        StringBuffer update = new StringBuffer();
        StringBuffer updateInter = new StringBuffer();
        RecordSet rsPK = null;
        StringBuffer query = new StringBuffer();      
        Long id = null;
        query.append(" SELECT MAE_TCCL_SEQ.NEXTVAL FROM DUAL ");
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
        update.append(" INSERT INTO MAE_CLASI( ");
        update.append("       OID_CLAS, ");
        update.append("       TCCL_OID_TIPO_CLAS, ");
        update.append("       COD_CLAS ");
        update.append(" ) VALUES ( ");
        update.append(id);
        update.append(" ," + maeClasi.getTcclOidTipoClas().getId());
        update.append(" ,'" + maeClasi.getCodClas()+ "' ");
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
                updateInter.append(" 'MAE_CLASI', ");
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
          UtilidadesLog.info("DAOClasificacion.guardarClasificacion(MaeClasiData maeClasi, Vector localizationLabels, HashMap userProperties): Entrada ");
          return primaryKey; 
      }
      public Vector query(MaeClasiData maeClasiFrom, MaeClasiData maeClasiTo, HashMap userProperties, Integer pageCount, Integer pageSize)throws MareException
      {
        UtilidadesLog.info("DAOClasificacion.query(MaeClasiData maeClasiFrom, MaeClasiData maeClasiTo, HashMap userProperties, Integer pageCount, Integer pageSize) : Entrada ");
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
        query.append(" SELECT MAE_CLASI.OID_CLAS, V_GEN_I18N_SICC.VAL_I18N DESCRIPCION, V_GEN_I18N_SICC.VAL_OID OIDTIPOCLASI, ");
        query.append("        MAE_CLASI.COD_CLAS, I18N.VAL_I18N DESCLASIFICACION, I18N2.VAL_I18N DESSUBTI, I18N2.VAL_OID OIDSUBTI, ");
        query.append("        I18N3.VAL_I18N DESTIPO, I18N3.VAL_OID OIDTIPO "); 
        query.append("        FROM MAE_CLASI, V_GEN_I18N_SICC, MAE_TIPO_CLASI_CLIEN, V_GEN_I18N_SICC I18N,  ");
        query.append("             MAE_SUBTI_CLIEN, V_GEN_I18N_SICC I18N2, ");
        query.append("             V_GEN_I18N_SICC I18N3, MAE_TIPO_CLIEN  ");
        query.append("        WHERE  MAE_CLASI.TCCL_OID_TIPO_CLAS = MAE_TIPO_CLASI_CLIEN.OID_TIPO_CLAS  ");
        if(maeClasiFrom.getTcclOidTipoClas() != null){
                query.append("        AND MAE_TIPO_CLASI_CLIEN.OID_TIPO_CLAS = " + maeClasiFrom.getTcclOidTipoClas().getId());
        }
        query.append("                AND MAE_TIPO_CLASI_CLIEN.SBTI_OID_SUBT_CLIE = MAE_SUBTI_CLIEN.OID_SUBT_CLIE  ");
        query.append("                AND MAE_SUBTI_CLIEN.TICL_OID_TIPO_CLIE = MAE_TIPO_CLIEN.OID_TIPO_CLIE  ");
        if(maeClasiFrom.getCodClas() != null)
        {
                query.append("        AND MAE_CLASI.COD_CLAS LIKE  '" + maeClasiFrom.getCodClas() + "' ");
        }
        query.append("                AND V_GEN_I18N_SICC.ATTR_ENTI = 'MAE_TIPO_CLASI_CLIEN' ");
        query.append("                AND V_GEN_I18N_SICC.ATTR_NUM_ATRI = 1  ");
        query.append("                AND V_GEN_I18N_SICC.IDIO_OID_IDIO = 1  ");
        query.append("                AND V_GEN_I18N_SICC.VAL_OID = MAE_TIPO_CLASI_CLIEN.OID_TIPO_CLAS  ");
        query.append("                AND I18N.ATTR_ENTI = 'MAE_CLASI' ");
        query.append("                AND I18N.ATTR_NUM_ATRI = 1 ");
        query.append("                AND I18N.IDIO_OID_IDIO = 1 ");
        query.append("                AND I18N.VAL_OID = MAE_CLASI.OID_CLAS ");
        query.append("                AND I18N3.ATTR_ENTI (+)= 'MAE_TIPO_CLIEN'  ");
        query.append("                AND I18N3.ATTR_NUM_ATRI (+)= 1  ");
        query.append("                AND I18N3.IDIO_OID_IDIO (+)= 1  ");
        query.append("                AND I18N3.VAL_OID (+)= MAE_TIPO_CLIEN.OID_TIPO_CLIE ");
        if(maeClasiFrom.getDescripcion() != null)
        {
                  query.append("      AND I18N.VAL_I18N LIKE '" + maeClasiFrom.getDescripcion() + "' ");
        }
        query.append("                AND I18N2.ATTR_ENTI (+)= 'MAE_SUBTI_CLIEN' ");
        query.append("                AND I18N2.ATTR_NUM_ATRI (+)= 1  ");
        query.append("                AND I18N2.IDIO_OID_IDIO (+)= 1 ");
        query.append("                AND I18N2.VAL_OID (+)= MAE_SUBTI_CLIEN.OID_SUBT_CLIE ");
        if(maeClasiFrom.getId() != null)
        {
                  query.append("     AND MAE_CLASI.OID_CLAS = " + maeClasiFrom.getId());
        }
        try {
               rs = bs.dbService.executeStaticQuery(query.toString());
            } catch (Exception ex) {
              UtilidadesLog.error("ERROR ", ex);
              throw new MareException(ex, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS));
            }
             int cant = rs.getRowCount();
             Vector result = new Vector();
             MaeClasiData maeClasi = null;
             MaeTipoClasiClienData maeTipoClasiClienFrom = null;
             MaeSubtiClienData maeSubtiClienFrom = null; 
             MaeTipoClienData maeTipoClienFrom = null;
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
                        maeClasi = new MaeClasiData();
                        maeClasi.setId( new Long(((BigDecimal)rs.getValueAt(i, "OID_CLAS")).toString()));
                        maeTipoClienFrom = new MaeTipoClienData();
                        maeTipoClienFrom.setId(new Long(((BigDecimal)rs.getValueAt(i,"OIDTIPO")).toString()));
                        maeTipoClienFrom.setDescripcion((String)rs.getValueAt(i,"DESTIPO"));
                        
                        maeSubtiClienFrom = new MaeSubtiClienData();                    
                        maeSubtiClienFrom.setTiclOidTipoClie(maeTipoClienFrom);
                        maeSubtiClienFrom.setId(new Long(((BigDecimal)rs.getValueAt(i,"OIDSUBTI")).toString()));
                        maeSubtiClienFrom.setDescripcion((String)rs.getValueAt(i,"DESSUBTI"));
                        
                        maeTipoClasiClienFrom = new MaeTipoClasiClienData();
                        maeTipoClasiClienFrom.setSbtiOidSubtClie(maeSubtiClienFrom);
                        maeTipoClasiClienFrom.setId(new Long(((BigDecimal)rs.getValueAt(i,"OIDTIPOCLASI")).toString())); 
                        maeTipoClasiClienFrom.setDescripcion((String)rs.getValueAt(i,"DESCRIPCION"));                    
                        maeClasi.setTcclOidTipoClas(maeTipoClasiClienFrom);
                        maeClasi.setCodClas((String)rs.getValueAt(i,"COD_CLAS"));
                        maeClasi.setDescripcion((String)rs.getValueAt(i,"DESCLASIFICACION"));
                        result.add(maeClasi);
                        
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
            UtilidadesLog.info("DAOClasificacion.query(MaeClasiData maeClasiFrom, MaeClasiData maeClasiTo, HashMap userProperties, Integer pageCount, Integer pageSize) : Salida ");    
            return result;
      }
      public Vector query(MaeTipoClasiClienData maeTipoClasiClienFrom, MaeTipoClasiClienData maeTipoClasiClienTo, HashMap userProperties)throws MareException
      {
        UtilidadesLog.info("DAOClasificacion.query(MaeTipoClasiClienData maeTipoClasiClienFrom, MaeTipoClasiClienData maeTipoClasiClienTo, HashMap userProperties):Entrada ");
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
            try{
              query.append("  SELECT I18N.VAL_OID, I18N.VAL_I18N, MAE_SUBTI_CLIEN.OID_SUBT_CLIE, MAE_TIPO_CLIEN.OID_TIPO_CLIE ");
              query.append("  FROM V_GEN_I18N_SICC I18N,  MAE_TIPO_CLASI_CLIEN, MAE_SUBTI_CLIEN,  MAE_TIPO_CLIEN ");
              query.append("    WHERE   MAE_TIPO_CLASI_CLIEN.SBTI_OID_SUBT_CLIE = MAE_SUBTI_CLIEN.OID_SUBT_CLIE ");
              if(maeTipoClasiClienFrom.getId() != null)
              {
                 query.append(" and mae_tipo_clasi_clien.OID_TIPO_CLAS = " + maeTipoClasiClienFrom.getId());
              }
              if(maeTipoClasiClienFrom.getSbtiOidSubtClie() != null)
              {
                query.append(" and MAE_SUBTI_CLIEN.OID_SUBT_CLIE = " + maeTipoClasiClienFrom.getSbtiOidSubtClie().getId());
              }
              query.append("         AND MAE_SUBTI_CLIEN.TICL_OID_TIPO_CLIE = MAE_TIPO_CLIEN.OID_TIPO_CLIE  ");
              
              query.append("         AND  I18N.ATTR_ENTI (+)= 'MAE_TIPO_CLASI_CLIEN' ");
              query.append("         AND I18N.ATTR_NUM_ATRI (+)= 1 ");
              query.append("         AND I18N.IDIO_OID_IDIO (+)= 1  ");
              query.append("         AND I18N.VAL_OID (+)= MAE_TIPO_CLASI_CLIEN.OID_TIPO_CLAS ");
             
            }catch(Exception ex)
            {
               ex.printStackTrace();
            }
            try
             {
                 rs = bs.dbService.executeStaticQuery(query.toString());
         
              }catch (Exception ex) {
                 ex.printStackTrace();
                 throw new MareException(ex, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS));
              }
            if(!rs.esVacio())
            {
                for(int i= 0; i < rs.getRowCount(); i++){
                      MaeTipoClasiClienData maeTipoClasiClien = new MaeTipoClasiClienData();
                      maeTipoClasiClien.setId(new Long(((BigDecimal)rs.getValueAt(i,"VAL_OID")).toString()));
                      maeTipoClasiClien.setDescripcion((String)rs.getValueAt(i,"VAL_I18N"));
                      MaeSubtiClienData maeSubtiClienFrom = new MaeSubtiClienData();
                      maeSubtiClienFrom.setId(new Long(((BigDecimal)rs.getValueAt(i,"OID_SUBT_CLIE")).toString()));
                      MaeTipoClienData maeTipoClienFrom = new MaeTipoClienData();
                      maeTipoClienFrom.setId( new Long(((BigDecimal)rs.getValueAt(i,"OID_TIPO_CLIE")).toString()));
                      maeSubtiClienFrom.setTiclOidTipoClie(maeTipoClienFrom);
                      maeTipoClasiClien.setSbtiOidSubtClie(maeSubtiClienFrom);
                      parametros.add(maeTipoClasiClien);
                }
            }
            UtilidadesLog.info("DAOClasificacion.query(MaeTipoClasiClienData maeTipoClasiClienFrom, MaeTipoClasiClienData maeTipoClasiClienTo, HashMap userProperties, Boolean  applyStructuralSecurity):Salida ");
            return parametros;   
      }
      public void update(MaeClasiData maeClasi, Vector localizationLabels)throws MareException
      {
        UtilidadesLog.info("DAOClasificacion.update(MaeClasiData maeClasi, Vector localizationLabels): Entrada");
        RecordSet rs = null;
          BelcorpService bs = UtilidadesEJB.getBelcorpService();
            
          StringBuffer update = new StringBuffer();
          StringBuffer updateInter = null;
          StringBuffer deleteInter = new StringBuffer();
          StringBuffer queryInter = null;
        
          deleteInter.append(" delete GEN_I18N_SICC_COMUN ");
          deleteInter.append(" where VAL_OID = " + maeClasi.getId());
          deleteInter.append(" and ATTR_NUM_ATRI = 1 ");
          deleteInter.append(" and ATTR_ENTI = 'MAE_CLASI' ");
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
              updateInter.append(" 'MAE_CLASI', ");
              updateInter.append(" 1, ");            
              updateInter.append(genDetaSiccData.getIdioOidIdio().getId() + ", ");
              updateInter.append(" '" + genDetaSiccData.getDeta() + "', ");
              updateInter.append(maeClasi.getId() + " )");   
               
              try {
                  int cantRegActualizados = bs.dbService.executeUpdate(updateInter.toString());
              } catch (Exception ex) {
                   if(ex.toString().indexOf("ORA-00001")!= -1) {
                        throw new MareException(ex, UtilidadesError.armarCodigoError(
                                            CodigosError.ERROR_DE_CLAVE_DUPLICADA));
                    } else {
                        throw new MareException(ex, UtilidadesError.armarCodigoError(
                                            CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS));
                    }
              }
              
          }
          UtilidadesLog.info("DAOClasificacion.update(MaeClasiData maeClasi, Vector localizationLabels): Salida");
      }
      public void remove(Vector maeClasifi)throws MareException
      {
        UtilidadesLog.info("DAOClasificacion.remove(Vector maeClasifi): Entrada ");
        RecordSet rs = null;
        BelcorpService bs = UtilidadesEJB.getBelcorpService();
        StringBuffer update = new StringBuffer();
        StringBuffer updateInter = new StringBuffer();
            
         int cant = maeClasifi.size();
        MaeClasiData  maeClasiFrom = null;
         String oidClasi = "";
         for (int j = 0; j < cant; j++) {
                maeClasiFrom = (MaeClasiData)maeClasifi.get(j);
                 
                oidClasi = oidClasi + "," + maeClasiFrom.getId();
         }
         update.append("delete MAE_CLASI ");
         update.append("where OID_CLAS in ( " + oidClasi.substring(1) + ") ");
          
         updateInter.append("delete GEN_I18N_SICC_COMUN ");
         updateInter.append(" where VAL_OID in ( " + oidClasi.substring(1) + ") ");
         updateInter.append(" and ATTR_NUM_ATRI = 1 ");
         updateInter.append(" and ATTR_ENTI = 'MAE_CLASI' ");
          
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
         UtilidadesLog.info("DAOClasificacion.remove(Vector maeClasifi): Salida ");
      }
}
