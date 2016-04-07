package es.indra.sicc.logicanegocio.mae;

import es.indra.belcorp.mso.MaeClasiViewData;
import es.indra.belcorp.mso.MaeExencFleteData;
import es.indra.belcorp.mso.MaeSubtiClienViewData;
import es.indra.belcorp.mso.MaeTipoClasiClienViewData;
import es.indra.belcorp.mso.MaeTipoClienData;
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

public class DAOExencionFlete {
    public DAOExencionFlete() {
    }
    public Vector query(MaeSubtiClienViewData maeSubtiClienViewFrom, MaeSubtiClienViewData maeSubtiClienViewTo, HashMap userProperties)throws MareException
     {
        UtilidadesLog.info("DAOExencionFlete.query(MaeSubtiClienViewData maeSubtiClienViewFrom, MaeSubtiClienViewData maeSubtiClienViewTo, HashMap userProperties): Entrada ");
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
        query.append("        FROM V_GEN_I18N_SICC, MAE_SUBTI_CLIEN ");
        query.append("        WHERE V_GEN_I18N_SICC.ATTR_ENTI = 'MAE_SUBTI_CLIEN' ");
        query.append("           AND V_GEN_I18N_SICC.ATTR_NUM_ATRI = 1 ");
        query.append("           AND V_GEN_I18N_SICC.IDIO_OID_IDIO = 1  ");
        query.append("           AND V_GEN_I18N_SICC.VAL_OID = MAE_SUBTI_CLIEN.OID_SUBT_CLIE   ");
        query.append("           ORDER BY V_GEN_I18N_SICC.VAL_I18N");
        try{
             
                 rs = bs.dbService.executeStaticQuery(query.toString());
              
             } catch (Exception ex) {
              
                 throw new MareException(ex, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS));
             }
         if(!rs.esVacio())
         {
           for(int i= 0; i < rs.getRowCount(); i++){
                 MaeSubtiClienViewData maeSubtiClienView = new MaeSubtiClienViewData();
                 maeSubtiClienView.setId(new Long(((BigDecimal)rs.getValueAt(i,"VAL_OID")).toString()));
                 maeSubtiClienView.setDescripcion((String)rs.getValueAt(i,"VAL_I18N"));
                 parametros.add(maeSubtiClienView);
           }
         }
        UtilidadesLog.info("DAOExencionFlete.query(MaeSubtiClienViewData maeSubtiClienViewFrom, MaeSubtiClienViewData maeSubtiClienViewTo, HashMap userProperties): Salida ");
        return parametros;    
             
     }
     public Vector query(MaeTipoClasiClienViewData maeTipoClasiClienViewFrom, MaeTipoClasiClienViewData maeTipoClasiClienViewTo, HashMap userProperties)throws MareException
     {
       UtilidadesLog.info("DAOExencionFlete.query(MaeTipoClasiClienViewData maeTipoClasiClienViewFrom, MaeTipoClasiClienViewData maeTipoClasiClienViewTo, HashMap userProperties): Entrada");
       RecordSet rs = new RecordSet();
       StringBuffer query = new StringBuffer();
       Vector parametros = new Vector();
       BelcorpService bs;
       try{
                 bs = BelcorpService.getInstance();
           
       } catch(MareMiiServiceNotFoundException ex){
                   
                 throw new MareException(ex, UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_PEDIR_UN_SERVICIO_MARE));
       }
       query.append("  SELECT V_GEN_I18N_SICC.VAL_OID, V_GEN_I18N_SICC.VAL_I18N ");
       query.append("         FROM V_GEN_I18N_SICC, MAE_TIPO_CLASI_CLIEN  ");
       query.append("              WHERE V_GEN_I18N_SICC.ATTR_ENTI = 'MAE_TIPO_CLASI_CLIEN' ");
       query.append("              AND V_GEN_I18N_SICC.ATTR_NUM_ATRI = 1  ");
       query.append("              AND V_GEN_I18N_SICC.IDIO_OID_IDIO = 1 ");
       query.append("              AND V_GEN_I18N_SICC.VAL_OID = MAE_TIPO_CLASI_CLIEN.OID_TIPO_CLAS ");
       query.append("              ORDER BY V_GEN_I18N_SICC.VAL_I18N ");

       try{
             
                rs = bs.dbService.executeStaticQuery(query.toString());
              
        } catch (Exception ex) {
              
                 throw new MareException(ex, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS));
        }
        if(!rs.esVacio())
        {
           for(int i= 0; i < rs.getRowCount(); i++){
                 MaeTipoClasiClienViewData maeTipoClasiClienView = new MaeTipoClasiClienViewData();
                 maeTipoClasiClienView.setId(new Long(((BigDecimal)rs.getValueAt(i,"VAL_OID")).toString()));
                 maeTipoClasiClienView.setDescripcion((String)rs.getValueAt(i,"VAL_I18N"));
                 parametros.add(maeTipoClasiClienView);
           }
        }
        UtilidadesLog.info("DAOExencionFlete.query(MaeTipoClasiClienViewData maeTipoClasiClienViewFrom, MaeTipoClasiClienViewData maeTipoClasiClienViewTo, HashMap userProperties): Salida"); 
        return parametros;
     }
     public Vector query(MaeClasiViewData maeClasiViewFrom, MaeClasiViewData maeClasiViewTo, HashMap userProperties)throws MareException
     {
         UtilidadesLog.info("DAOExencionFlete.query(MaeClasiViewData maeClasiViewFrom, MaeClasiViewData maeClasiViewTo, HashMap userProperties): Entrada");
         RecordSet rs = new RecordSet();
         StringBuffer query = new StringBuffer();
         Vector parametros = new Vector();
         BelcorpService bs;
         try{
                 bs = BelcorpService.getInstance();
           
         } catch(MareMiiServiceNotFoundException ex){
                   
                 throw new MareException(ex, UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_PEDIR_UN_SERVICIO_MARE));
         }
         query.append("  SELECT V_GEN_I18N_SICC.VAL_OID, V_GEN_I18N_SICC.VAL_I18N ");
         query.append("   FROM V_GEN_I18N_SICC, MAE_CLASI ");
         query.append("       WHERE V_GEN_I18N_SICC.ATTR_ENTI = 'MAE_CLASI' ");
         query.append("              AND V_GEN_I18N_SICC.ATTR_NUM_ATRI = 1 ");
         query.append("              AND V_GEN_I18N_SICC.IDIO_OID_IDIO = 1 ");
         query.append("              AND V_GEN_I18N_SICC.VAL_OID = MAE_CLASI.OID_CLAS ");
         query.append("       ORDER BY V_GEN_I18N_SICC.VAL_I18N  ");
         try{
             
                rs = bs.dbService.executeStaticQuery(query.toString());
              
          } catch (Exception ex) {
              
                 throw new MareException(ex, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS));
          }
          if(!rs.esVacio())
          {
              for(int i= 0; i < rs.getRowCount(); i++){
                   MaeClasiViewData maeClasiView = new MaeClasiViewData();
                   maeClasiView.setId(new Long(((BigDecimal)rs.getValueAt(i,"VAL_OID")).toString()));
                   maeClasiView.setDescripcion((String)rs.getValueAt(i,"VAL_I18N"));
                   parametros.add(maeClasiView);
              }
          }
          UtilidadesLog.info("DAOExencionFlete.query(MaeClasiViewData maeClasiViewFrom, MaeClasiViewData maeClasiViewTo, HashMap userProperties): Salida");
          return parametros;
     }
     public Hashtable guardarExencionFlete(MaeExencFleteData maeExencFlete, Vector localizationLabels, HashMap userProperties )throws MareException
     {
         UtilidadesLog.info("DAOExencionFlete.guardarExcencionFlete(MaeExencFleteData maeExencFlete, Vector localizationLabels, HashMap userProperties): Entrada");
         RecordSet rs = null;
         BelcorpService bs = UtilidadesEJB.getBelcorpService();     
         StringBuffer update = new StringBuffer();
         RecordSet rsPK = null;
         StringBuffer query = new StringBuffer();      
         Long id = null;
         query.append(" SELECT MAE_EXFL_SEQ.NEXTVAL FROM DUAL ");
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
         update.append(" INSERT INTO MAE_EXENC_FLETE ( ");
         update.append("       OID_EXEN_FLET, ");
         update.append("       PAIS_OID_PAIS,  ");
         update.append("       CLAS_OID_CLAS, ");
         update.append("       IND_EXEN_FLET, ");
         update.append("       SBTI_OID_SUBT_CLIE, ");
         update.append("       TICL_OID_TIPO_CLIE,  ");
         update.append("       TCCL_OID_TIPO_CLAS ");
         update.append("  ) VALUES (");
         update.append(id);
         update.append(" , " + maeExencFlete.getPaisOidPais().getId());
         if(maeExencFlete.getClasOidClas() != null){
              update.append(" , " + maeExencFlete.getClasOidClas().getId());
         }else
         {
           update.append(" , NULL ");
         }
         update.append(" , " + maeExencFlete.getIndExenFlet());
         if(maeExencFlete.getSbtiOidSubtClie() != null)
         {
           update.append(" , " + maeExencFlete.getSbtiOidSubtClie().getId());
         }else
         {
             update.append(", NULL ");
         }
         if(maeExencFlete.getTiclOidTipoClie() != null)
         {
             update.append(" , " + maeExencFlete.getTiclOidTipoClie().getId());
         }else
         {
             update.append(" , NULL");
         }
         if(maeExencFlete.getTcclOidTipoClas() != null)
         {
            update.append(" , " + maeExencFlete.getTcclOidTipoClas().getId());
         }else
         {
           update.append(" , NULL");
         }
         update.append("   ) ");
        
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
         UtilidadesLog.info("DAOExencionFlete.guardarExcencionFlete(MaeExencFleteData maeExencFlete, Vector localizationLabels, HashMap userProperties): Salida");
         return primaryKey;   
     }
     public Vector query(MaeExencFleteData maeExencFleteFrom, MaeExencFleteData maeExencFleteTo, HashMap userProperties, Integer pageCount, Integer pageSize)throws MareException
     {
         UtilidadesLog.info("DAOExencionFlete.query(MaeExencFleteData maeExencFleteFrom, MaeExencFleteData maeExencFleteTo, HashMap userProperties, Integer pageCount, Integer pageSize): Entrada");
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
         query.append("  SELECT MAE_EXENC_FLETE.OID_EXEN_FLET, V_GEN_I18N_SICC.VAL_I18N DESTIPOCLIENTE, V_GEN_I18N_SICC.VAL_OID OIDTIPOCLIENTE, ");
         query.append("         I18N2.VAL_I18N DESSUBTI, I18N2.VAL_OID OIDSUBTI, I18N3.VAL_I18N DESTIPOCLASI, I18N3.VAL_OID OIDTIPOCLASI, ");
         query.append("         I18N4.VAL_I18N DESCLASI, I18N4.VAL_OID OIDCLASI, MAE_EXENC_FLETE.IND_EXEN_FLET, SEG_PAIS.OID_PAIS ");
         
         query.append("         FROM  MAE_EXENC_FLETE, V_GEN_I18N_SICC, MAE_TIPO_CLIEN, V_GEN_I18N_SICC I18N2,  ");
         query.append("               MAE_SUBTI_CLIEN, MAE_TIPO_CLASI_CLIEN, V_GEN_I18N_SICC I18N3, V_GEN_I18N_SICC I18N4, ");
         query.append("               MAE_CLASI, SEG_PAIS ");
         
         query.append("         WHERE MAE_EXENC_FLETE.TICL_OID_TIPO_CLIE = MAE_TIPO_CLIEN.OID_TIPO_CLIE (+)  ");
         if(maeExencFleteFrom.getTiclOidTipoClie() != null)
         {
               query.append("         AND MAE_TIPO_CLIEN.OID_TIPO_CLIE = " + maeExencFleteFrom.getTiclOidTipoClie().getId());
         }
         query.append("               AND MAE_EXENC_FLETE.SBTI_OID_SUBT_CLIE = MAE_SUBTI_CLIEN.OID_SUBT_CLIE (+) ");
         if(maeExencFleteFrom.getSbtiOidSubtClie() != null)
         {
               query.append("         AND MAE_SUBTI_CLIEN.OID_SUBT_CLIE = " + maeExencFleteFrom.getSbtiOidSubtClie().getId());
         }
         query.append("               AND MAE_EXENC_FLETE.TCCL_OID_TIPO_CLAS = MAE_TIPO_CLASI_CLIEN.OID_TIPO_CLAS (+) ");
         if(maeExencFleteFrom.getTcclOidTipoClas() != null)
         {
               query.append("         AND MAE_TIPO_CLASI_CLIEN.OID_TIPO_CLAS = " + maeExencFleteFrom.getTcclOidTipoClas().getId());
         }
         query.append("               AND MAE_EXENC_FLETE.CLAS_OID_CLAS = MAE_CLASI.OID_CLAS(+) ");
         if(maeExencFleteFrom.getClasOidClas() != null)
         {
             query.append("           AND MAE_CLASI.OID_CLAS =  " + maeExencFleteFrom.getClasOidClas().getId());
         }
         query.append("               AND MAE_EXENC_FLETE.PAIS_OID_PAIS = SEG_PAIS.OID_PAIS (+) ");
         if(maeExencFleteFrom.getPaisOidPais() != null)
         {
             query.append("          AND  SEG_PAIS.OID_PAIS = "  + maeExencFleteFrom.getPaisOidPais().getId());
         }
         if(maeExencFleteFrom.getIndExenFlet() != null)
         {
             query.append("           AND MAE_EXENC_FLETE.IND_EXEN_FLET = " + maeExencFleteFrom.getIndExenFlet());
         }
         query.append("               AND V_GEN_I18N_SICC.ATTR_ENTI (+)= 'MAE_TIPO_CLIEN' ");
         query.append("               AND V_GEN_I18N_SICC.ATTR_NUM_ATRI (+)= 1 ");
         query.append("               AND V_GEN_I18N_SICC.IDIO_OID_IDIO (+)= 1  ");
         query.append("               AND V_GEN_I18N_SICC.VAL_OID (+)= MAE_TIPO_CLIEN.OID_TIPO_CLIE ");
         
         query.append("               AND I18N2.ATTR_ENTI (+)= 'MAE_SUBTI_CLIEN' ");
         query.append("               AND I18N2.ATTR_NUM_ATRI (+)= 1 ");
         query.append("               AND I18N2.IDIO_OID_IDIO (+)= 1 ");
         query.append("               AND I18N2.VAL_OID (+)= MAE_SUBTI_CLIEN.OID_SUBT_CLIE ");
         
         query.append("               AND I18N3.ATTR_ENTI (+)= 'MAE_TIPO_CLASI_CLIEN' ");
         query.append("               AND I18N3.ATTR_NUM_ATRI (+)= 1 ");
         query.append("               AND I18N3.IDIO_OID_IDIO (+)= 1 ");
         query.append("               AND I18N3.VAL_OID (+)= MAE_TIPO_CLASI_CLIEN.OID_TIPO_CLAS ");
         
         query.append("               AND I18N4.ATTR_ENTI (+)= 'MAE_CLASI' ");
         query.append("               AND I18N4.ATTR_NUM_ATRI (+)= 1 ");
         query.append("               AND I18N4.IDIO_OID_IDIO (+)= 1 ");
         query.append("               AND I18N4.VAL_OID (+)= MAE_CLASI.OID_CLAS ");
         if(maeExencFleteFrom.getId() != null)
         {
            query.append("            AND MAE_EXENC_FLETE.OID_EXEN_FLET = " + maeExencFleteFrom.getId());
         }
         query.append("  ORDER BY MAE_EXENC_FLETE.OID_EXEN_FLET ");
         try {
               
              rs = bs.dbService.executeStaticQuery(query.toString());
           } catch (Exception ex) {
           
             ex.printStackTrace();
             UtilidadesLog.error("ERROR ", ex);
             throw new MareException(ex, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS));
           }
            int cant = rs.getRowCount();
            Vector result = new Vector();
            MaeExencFleteData maeExencFlete = null;
            MaeSubtiClienViewData maeSubtiClienViewFrom = null;
            BigDecimal oidSubtipo = null;
            MaeTipoClasiClienViewData maeTipoClasiClienViewFrom = null;
            BigDecimal oidTipoClasificacion = null;
            MaeClasiViewData maeClasiViewFrom = null;
            BigDecimal oidClasi = null;
            MaeTipoClienData maeTipoClienFrom = null;
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
                         maeExencFlete = new   MaeExencFleteData();
                         maeExencFlete.setId( new Long(((BigDecimal)rs.getValueAt(i,"OID_EXEN_FLET")).toString()));
                         
                         maeTipoClienFrom = new  MaeTipoClienData();
                         maeTipoClienFrom.setId(new Long(((BigDecimal)rs.getValueAt(i,"OIDTIPOCLIENTE")).toString()));
                         maeTipoClienFrom.setDescripcion((String)rs.getValueAt(i,"DESTIPOCLIENTE"));
                         maeExencFlete.setTiclOidTipoClie(maeTipoClienFrom);
                         
                         oidSubtipo = ((BigDecimal)rs.getValueAt(i,"OIDSUBTI"));
                         if(oidSubtipo != null ){
                        
                             maeSubtiClienViewFrom = new MaeSubtiClienViewData();
                             maeSubtiClienViewFrom.setId(Long.valueOf(oidSubtipo.toString()));
                             maeSubtiClienViewFrom.setDescripcion((String)rs.getValueAt(i,"DESSUBTI"));
                             maeExencFlete.setSbtiOidSubtClie(maeSubtiClienViewFrom);
                        
                         }
                         oidTipoClasificacion = ((BigDecimal)rs.getValueAt(i,"OIDTIPOCLASI"));
                         if(oidTipoClasificacion != null){
                          
                             maeTipoClasiClienViewFrom = new MaeTipoClasiClienViewData();
                             maeTipoClasiClienViewFrom.setId(Long.valueOf(oidTipoClasificacion.toString()));
                             maeTipoClasiClienViewFrom.setDescripcion((String)rs.getValueAt(i,"DESTIPOCLASI"));
                             maeExencFlete.setTcclOidTipoClas(maeTipoClasiClienViewFrom);
                         }
                         oidClasi = ((BigDecimal)rs.getValueAt(i,"OIDCLASI"));
                         if(oidClasi != null){
                             maeClasiViewFrom = new  MaeClasiViewData();
                             maeClasiViewFrom.setId(Long.valueOf(oidClasi.toString()));
                             maeClasiViewFrom.setDescripcion((String)rs.getValueAt(i,"DESCLASI"));
                             maeExencFlete.setClasOidClas(maeClasiViewFrom);
                         }
                         maeExencFlete.setIndExenFlet(((BigDecimal)rs.getValueAt(i,"IND_EXEN_FLET")).toString());
                         
                         segPaisViewFrom = new SegPaisViewData();
                         segPaisViewFrom.setId(new Long(((BigDecimal)rs.getValueAt(i,"OID_PAIS")).toString()));
                         maeExencFlete.setPaisOidPais(segPaisViewFrom);
                         result.add(maeExencFlete);
                         
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
           UtilidadesLog.info("DAOExencionFlete.query(MaeExencFleteData maeExencFleteFrom, MaeExencFleteData maeExencFleteTo, HashMap userProperties, Integer pageCount, Integer pageSize): Salida");
           return result; 
            
            
     }
     public void update(MaeExencFleteData maeExencFlete, Vector localizationLabels)throws MareException
     {
       UtilidadesLog.info("DAOExencionFlete.update(MaeExencFleteData maeExencFlete, Vector localizationLabels): Entrada");
        RecordSet rs = null;
        BelcorpService bs = UtilidadesEJB.getBelcorpService();
        StringBuffer update = new StringBuffer();
        try{
        update.append(" UPDATE MAE_EXENC_FLETE SET ");
        if(maeExencFlete.getClasOidClas() != null){
             update.append("           CLAS_OID_CLAS = " + maeExencFlete.getClasOidClas().getId());
        }else
        {
           update.append("              CLAS_OID_CLAS = NULL ");
        }
        update.append("         , IND_EXEN_FLET = " + maeExencFlete.getIndExenFlet());
        update.append("      where OID_EXEN_FLET = " + maeExencFlete.getId());
        }catch(Exception ex)
        {
          ex.printStackTrace();
        }
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
       UtilidadesLog.info("DAOExencionFlete.update(MaeExencFleteData maeExencFlete, Vector localizationLabels): Salida");   
     }
     public void remove(Vector maeExencFlete)throws MareException
     {
        UtilidadesLog.info("DAOExencionFlete.remove(Vector maeExencFlete): Entrada ");
        RecordSet rs = null;
        BelcorpService bs = UtilidadesEJB.getBelcorpService();
        StringBuffer update = new StringBuffer();
      
           
           int cant = maeExencFlete.size();
           MaeExencFleteData maeExencFl = null;
           String oidExencionFlete = "";
           
           for (int j = 0; j < cant; j++) {
               maeExencFl = (MaeExencFleteData)maeExencFlete.get(j);
                
               oidExencionFlete = oidExencionFlete + "," + maeExencFl.getId();
           }
           
           update.append("delete MAE_EXENC_FLETE  ");
           update.append("where  OID_EXEN_FLET in ( " + oidExencionFlete.substring(1) + ") ");
           
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
        UtilidadesLog.info("DAOExencionFlete.remove(Vector maeExencFlete): Salida ");         
           
     }
}
