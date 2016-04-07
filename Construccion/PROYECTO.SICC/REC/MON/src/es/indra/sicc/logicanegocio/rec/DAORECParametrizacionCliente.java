package es.indra.sicc.logicanegocio.rec;

import es.indra.belcorp.mso.MaeTipoClienData;
import es.indra.belcorp.mso.RecParamNmperData;
import es.indra.belcorp.mso.RecPreciPerdiData;
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

public class DAORECParametrizacionCliente {
    public DAORECParametrizacionCliente() {
    }
    public Vector query(RecPreciPerdiData recPreciPerdiFrom, RecPreciPerdiData recPreciPerdiTo, HashMap userProperties)throws MareException
     {
        UtilidadesLog.info("DAORECParametrizacionCliente.query(RecPreciPerdiData recPreciPerdiFrom, RecPreciPerdiData recPreciPerdiTo, HashMap userProperties): Entrada ");
        RecordSet rs = new RecordSet();
        StringBuffer query = new StringBuffer();
        Vector parametros = new Vector();
        BelcorpService bs;
        try{
                 bs = BelcorpService.getInstance();
           
        } catch(MareMiiServiceNotFoundException ex){
                   
               throw new MareException(ex, UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_PEDIR_UN_SERVICIO_MARE));
        }
        query.append("SELECT REC_PRECI_PERDI.OID_PREC_PERD, REC_PRECI_PERDI.COD_PREC_PERD ");
        query.append("        FROM REC_PRECI_PERDI ");
        try{
             
                 rs = bs.dbService.executeStaticQuery(query.toString());
              
        } catch (Exception ex) {
              
                 throw new MareException(ex, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS));
        }
        if(!rs.esVacio())
        {
           for(int i= 0; i < rs.getRowCount(); i++){
                       RecPreciPerdiData recPreciPerdi = new RecPreciPerdiData();
                       recPreciPerdi.setId(new Long(((BigDecimal)rs.getValueAt(i,"OID_PREC_PERD")).toString()));
                       recPreciPerdi.setCodPrecPerd((String)rs.getValueAt(i,"COD_PREC_PERD"));
                       parametros.add(recPreciPerdi);
                       
           }
        }
        UtilidadesLog.info("DAORECParametrizacionCliente.query(RecPreciPerdiData recPreciPerdiFrom, RecPreciPerdiData recPreciPerdiTo, HashMap userProperties): Salida ");
        return parametros;
     }
     public Hashtable guardarParametrizacionCliente(RecParamNmperData recParamNmper , Vector localizationLabels, HashMap userProperties)throws MareException
     {
         UtilidadesLog.info("DAORECParametrizacionCliente.guardarParametrizacionCliente(RecParamNmperData recParamNmper , Vector localizationLabels, HashMap userProperties): Entrada");
         RecordSet rs = null;
         BelcorpService bs = UtilidadesEJB.getBelcorpService();     
         StringBuffer update = new StringBuffer();
         RecordSet rsPK = null;
         StringBuffer query = new StringBuffer();      
         Long id = null;
         query.append(" SELECT REC_PNTC_SEQ.NEXTVAL FROM DUAL ");
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
         update.append("INSERT INTO REC_PARAM_NMPER ( ");
         update.append("            OID_PARA  ");
         update.append("            , IND_PARA_MODI ");
         update.append("            , PAIS_OID_PAIS ");
         update.append("            , PPER_OID_PREC_PERD ");
         update.append("            , TICL_OID_TIPO_CLIE ");
         update.append("            , VAL_PORC_RECA");
         update.append("   )   VALUES ( ");
         update.append(id);
         if(recParamNmper.getIndParaModi() != null)
         {
           update.append("  ," + recParamNmper.getIndParaModi());
         }else
         {
           update.append("  , NULL");
         }
         update.append(" , " + recParamNmper.getPaisOidPais().getId());
         update.append(" , " + recParamNmper.getPperOidPrecPerd().getId());
         update.append(" , " + recParamNmper.getTiclOidTipoClie().getId());
         update.append(" , " + recParamNmper.getValPorcReca());
         update.append("      )  ");
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
         UtilidadesLog.info("DAORECParametrizacionCliente.guardarParametrizacionCliente(RecParamNmperData recParamNmper , Vector localizationLabels, HashMap userProperties): Salida");
         return primaryKey;
     }
     public Vector query(RecParamNmperData recParamNmperFrom, RecParamNmperData recParamNmperTo, HashMap userProperties, Integer pageCount, Integer pageSize)throws MareException
     {
          UtilidadesLog.info("DAORECParametrizacionCliente.query(RecParamNmperData recParamNmperFrom, RecParamNmperData recParamNmperTo, HashMap userProperties, Integer pageCount, Integer pageSize): Entrada");
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
          query.append("  SELECT  REC_PARAM_NMPER.OID_PARA, V_GEN_I18N_SICC.VAL_OID OIDCLIENTE, ");
          query.append("          V_GEN_I18N_SICC.VAL_I18N DESCLIENTE,  ");
          query.append("          REC_PRECI_PERDI.OID_PREC_PERD, REC_PRECI_PERDI.COD_PREC_PERD, ");
          query.append("          REC_PARAM_NMPER.VAL_PORC_RECA, REC_PARAM_NMPER.IND_PARA_MODI, ");
          query.append("          SEG_PAIS.OID_PAIS ");
          query.append("          FROM REC_PARAM_NMPER, V_GEN_I18N_SICC, REC_PRECI_PERDI, MAE_TIPO_CLIEN,  ");
          query.append("               SEG_PAIS ");
          query.append("               WHERE REC_PARAM_NMPER.PAIS_OID_PAIS = SEG_PAIS.OID_PAIS ");
          if(recParamNmperFrom.getPaisOidPais() != null)
          {
            query.append("                   AND SEG_PAIS.OID_PAIS = " + recParamNmperFrom.getPaisOidPais().getId());
          }
          query.append("                     AND REC_PARAM_NMPER.PPER_OID_PREC_PERD = REC_PRECI_PERDI.OID_PREC_PERD ");
          if(recParamNmperFrom.getPperOidPrecPerd() != null)
          {
            query.append("                   AND REC_PRECI_PERDI.OID_PREC_PERD =  " + recParamNmperFrom.getPperOidPrecPerd().getId() );
          }
          query.append("                     AND REC_PARAM_NMPER.TICL_OID_TIPO_CLIE = MAE_TIPO_CLIEN.OID_TIPO_CLIE ");
          if(recParamNmperFrom.getTiclOidTipoClie() != null)
          {
            query.append("                   AND MAE_TIPO_CLIEN.OID_TIPO_CLIE =  " + recParamNmperFrom.getTiclOidTipoClie().getId());
          }
          if(recParamNmperFrom.getValPorcReca() != null)
          {
            query.append("                   AND REC_PARAM_NMPER.VAL_PORC_RECA =  " + recParamNmperFrom.getValPorcReca());
          }
          if(recParamNmperFrom.getIndParaModi() !=null)
          {
            query.append("                   AND REC_PARAM_NMPER.IND_PARA_MODI = " + recParamNmperFrom.getIndParaModi());
          }
          if(recParamNmperFrom.getId() != null)
          {
            query.append("                   AND REC_PARAM_NMPER.OID_PARA = " + recParamNmperFrom.getId());
          }
          query.append("                     AND V_GEN_I18N_SICC.ATTR_ENTI = 'MAE_TIPO_CLIEN' ");
          query.append("                     AND V_GEN_I18N_SICC.ATTR_NUM_ATRI = 1  ");
          query.append("                     AND V_GEN_I18N_SICC.IDIO_OID_IDIO = 1  ");
          query.append("                     AND V_GEN_I18N_SICC.VAL_OID = MAE_TIPO_CLIEN.OID_TIPO_CLIE  ");
          
          try {
               
              rs = bs.dbService.executeStaticQuery(query.toString());
          } catch (Exception ex) {
           
             ex.printStackTrace();
             UtilidadesLog.error("ERROR ", ex);
             throw new MareException(ex, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS));
           }
           int cant = rs.getRowCount();
           Vector result = new Vector();
           RecParamNmperData recParamNmper = null;
           RecPreciPerdiData recPreciPerdi = null;
           SegPaisViewData segPaisViewFrom = null;
           MaeTipoClienData maeTipoClienFrom = null;
           BigDecimal modificable = null;
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
                    recParamNmper = new RecParamNmperData();
                    recParamNmper.setId(new Long(((BigDecimal)rs.getValueAt(i,"OID_PARA")).toString()));
                    modificable = (BigDecimal)rs.getValueAt(i,"IND_PARA_MODI");
                    if(modificable != null){
                             recParamNmper.setIndParaModi(Long.valueOf( modificable.toString()));
                    }
                    segPaisViewFrom = new SegPaisViewData();
                    segPaisViewFrom.setId(new Long(((BigDecimal)rs.getValueAt(i,"OID_PAIS")).toString()));
                    recParamNmper.setPaisOidPais(segPaisViewFrom);
                    
                    recPreciPerdi = new RecPreciPerdiData();
                    recPreciPerdi.setId(new Long(((BigDecimal)rs.getValueAt(i,"OID_PREC_PERD")).toString()));
                    recPreciPerdi.setCodPrecPerd((String)rs.getValueAt(i,"COD_PREC_PERD"));
                    recParamNmper.setPperOidPrecPerd(recPreciPerdi);
                    
                    maeTipoClienFrom = new MaeTipoClienData();
                    maeTipoClienFrom.setId(new Long(((BigDecimal)rs.getValueAt(i,"OIDCLIENTE")).toString()));
                    maeTipoClienFrom.setDescripcion((String)rs.getValueAt(i,"DESCLIENTE"));
                    recParamNmper.setTiclOidTipoClie(maeTipoClienFrom);
                    recParamNmper.setValPorcReca(Double.valueOf(((BigDecimal)rs.getValueAt(i,"VAL_PORC_RECA")).toString()));
                    result.add(recParamNmper);
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
           UtilidadesLog.info("DAORECParametrizacionCliente.query(RecParamNmperData recParamNmperFrom, RecParamNmperData recParamNmperTo, HashMap userProperties, Integer pageCount, Integer pageSize): Salida");
           return result;
           
     }
     public void update(RecParamNmperData recParamNmper, Vector localizationLabels)throws MareException
     {
       UtilidadesLog.info("DAORECParametrizacionCliente.update(RecParamNmperData recParamNmper, Vector localizationLabels): Entrada");
       RecordSet rs = null;
       BelcorpService bs = UtilidadesEJB.getBelcorpService();
           
       StringBuffer update = new StringBuffer();
       update.append("UPDATE REC_PARAM_NMPER SET ");
       update.append("        PPER_OID_PREC_PERD  = " + recParamNmper.getPperOidPrecPerd().getId());
       update.append("       , VAL_PORC_RECA = " + recParamNmper.getValPorcReca() );
       if(recParamNmper.getIndParaModi() != null)
       {
         update.append("     , IND_PARA_MODI = " + recParamNmper.getIndParaModi() );
       }else
       {
         update.append("     , IND_PARA_MODI =  NULL ");
       }
       update.append("   where OID_PARA = " + recParamNmper.getId());
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
        UtilidadesLog.info("DAORECParametrizacionCliente.update(RecParamNmperData recParamNmper, Vector localizationLabels): Salida");
     }
     public void remove(Vector recParamNm)throws MareException
     {
       UtilidadesLog.info("DAORECParametrizacionCliente.remove(Vector recParamNm): Entrada");
       RecordSet rs = null;
       BelcorpService bs = UtilidadesEJB.getBelcorpService();
       StringBuffer update = new StringBuffer();
       
       
       int cant = recParamNm.size();
       RecParamNmperData recParamNmper = null;
       String oidParamertizacionCliente = "";
       for (int j = 0; j < cant; j++) {
           recParamNmper = (RecParamNmperData)recParamNm.get(j);
            
           oidParamertizacionCliente = oidParamertizacionCliente + "," + recParamNmper.getId();
       }
       update.append("delete REC_PARAM_NMPER  ");
       update.append("where OID_PARA in ( " + oidParamertizacionCliente.substring(1) + ") ");
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
       
       UtilidadesLog.info("DAORECParametrizacionCliente.remove(Vector recParamNm): Salida");
     }
}
