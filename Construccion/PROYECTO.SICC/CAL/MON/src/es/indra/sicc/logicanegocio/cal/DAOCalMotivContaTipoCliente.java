package es.indra.sicc.logicanegocio.cal;

import es.indra.belcorp.mso.CalMotivContaData;
import es.indra.belcorp.mso.CalMotivTipoClienData;
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

public class DAOCalMotivContaTipoCliente {
    public DAOCalMotivContaTipoCliente() {
    }
    public Vector query(CalMotivContaData calMotivContaFrom, CalMotivContaData calMotivContaTo, HashMap userProperties)throws MareException
     {
        UtilidadesLog.info("DAOCalMotivContaTipoCliente.query(CalMotivContaData calMotivContaFrom, CalMotivContaData calMotivContaTo, HashMap userProperties): Entrada");
        RecordSet rs = new RecordSet();
        StringBuffer query = new StringBuffer();
        Vector parametros = new Vector();
        BelcorpService bs;
        try{
                 bs = BelcorpService.getInstance();
           
       } catch(MareMiiServiceNotFoundException ex){
                   
                 throw new MareException(ex, UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_PEDIR_UN_SERVICIO_MARE));
       }
       query.append("    SELECT V_GEN_I18N_SICC.VAL_OID, V_GEN_I18N_SICC.VAL_I18N ");
       query.append("           FROM V_GEN_I18N_SICC, CAL_MOTIV_CONTA ");
       query.append("                WHERE V_GEN_I18N_SICC.ATTR_ENTI = 'CAL_MOTIV_CONTA' ");
       query.append("                      AND V_GEN_I18N_SICC.ATTR_NUM_ATRI = 1 ");
       query.append("                      AND V_GEN_I18N_SICC.IDIO_OID_IDIO = 1 ");
       query.append("                      AND V_GEN_I18N_SICC.VAL_OID = CAL_MOTIV_CONTA.OID_MOTI_CONT ");
       try{
             
                 rs = bs.dbService.executeStaticQuery(query.toString());
              
       } catch (Exception ex) {
              
                 throw new MareException(ex, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS));
       }
       if(!rs.esVacio())
       {
           for(int i= 0; i < rs.getRowCount(); i++){
               CalMotivContaData calMotivConta = new CalMotivContaData();
               calMotivConta.setId( new Long(((BigDecimal)rs.getValueAt(i,"VAL_OID")).toString()));
               calMotivConta.setDescripcion((String)rs.getValueAt(i,"VAL_I18N"));
               parametros.add(calMotivConta);
           }
       }
        UtilidadesLog.info("DAOCalMotivContaTipoCliente.query(CalMotivContaData calMotivContaFrom, CalMotivContaData calMotivContaTo, HashMap userProperties): Salida");
        return parametros;
       
     }
     public Hashtable guardarMotivContaTipoClient(CalMotivTipoClienData calMotivTipoClien, Vector localizationLabels, HashMap userProperties) throws MareException
     {
         UtilidadesLog.info("DAOCalMotivContaTipoCliente.guardarMotivContaTipoCliente(CalMotivTipoClienData calMotivTipoClien, Vector localizationLabels, HashMap userProperties): Entrada");
         RecordSet rs = null;
         BelcorpService bs = UtilidadesEJB.getBelcorpService();     
         StringBuffer update = new StringBuffer();
         RecordSet rsPK = null;
         StringBuffer query = new StringBuffer();      
         Long id = null;
         query.append(" SELECT CAL_MOTC_SEQ.NEXTVAL FROM DUAL ");
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
         update.append("  INSERT INTO CAL_MOTIV_TIPO_CLIEN ( ");
         update.append("              OID_MOTI_TIPO_CLIE  ");
         update.append("              , TICL_OID_TIPO_CLIE ");
         update.append("              , MOCO_OID_MOTI_CONT ");
         update.append("              , PAIS_OID_PAIS ");
         update.append("   ) VALUES ( ");
         update.append(id);
         update.append(" , " + calMotivTipoClien.getTiclOidTipoClie().getId());
         update.append(" , " + calMotivTipoClien.getMocoOidMotiCont().getId());
         update.append(" ,  " + calMotivTipoClien.getPaisOidPais().getId());
         update.append("       ) ");
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
         UtilidadesLog.info("DAOCalMotivContaTipoCliente.guardarMotivContaTipoCliente(CalMotivTipoClienData calMotivTipoClien, Vector localizationLabels, HashMap userProperties): Salida");
         return primaryKey;
     }
     public Vector query(CalMotivTipoClienData calMotivTipoClienFrom, CalMotivTipoClienData calMotivTipoClienTo, HashMap userProperties, Integer pageCount, Integer pageSize)throws MareException
     {
        UtilidadesLog.info("DAOCalMotivContaTipoCliente.query(CalMotivTipoClienData calMotivTipoClienFrom, CalMotivTipoClienData calMotivTipoClienTo, HashMap userProperties, Integer pageCount, Integer pageSize): Entrada");
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
        query.append(" SELECT  CAL_MOTIV_TIPO_CLIEN.OID_MOTI_TIPO_CLIE, V_GEN_I18N_SICC.VAL_OID OIDMOTIV,  ");
        query.append("         V_GEN_I18N_SICC.VAL_I18N DESMOTIV, I18N.VAL_OID OIDTIPO,  ");
        query.append("         I18N.VAL_I18N DESTIPO, SEG_PAIS.OID_PAIS ");
        query.append("         FROM CAL_MOTIV_TIPO_CLIEN,  CAL_MOTIV_CONTA, ");
        query.append("              MAE_TIPO_CLIEN, V_GEN_I18N_SICC, V_GEN_I18N_SICC I18N, ");
        query.append("              SEG_PAIS ");
        query.append("              WHERE CAL_MOTIV_TIPO_CLIEN.MOCO_OID_MOTI_CONT = CAL_MOTIV_CONTA.OID_MOTI_CONT  ");
        if(calMotivTipoClienFrom.getMocoOidMotiCont() != null)
        {
          query.append("                 AND   CAL_MOTIV_CONTA.OID_MOTI_CONT = " + calMotivTipoClienFrom.getMocoOidMotiCont().getId());
        }
        query.append("                   AND CAL_MOTIV_TIPO_CLIEN.TICL_OID_TIPO_CLIE = MAE_TIPO_CLIEN.OID_TIPO_CLIE ");
        if(calMotivTipoClienFrom.getTiclOidTipoClie() != null)
        {
          query.append("                 AND MAE_TIPO_CLIEN.OID_TIPO_CLIE = " + calMotivTipoClienFrom.getTiclOidTipoClie().getId());
        }
        query.append("                   AND CAL_MOTIV_TIPO_CLIEN.PAIS_OID_PAIS = SEG_PAIS.OID_PAIS ");
        if(calMotivTipoClienFrom.getPaisOidPais() != null)
        {
          query.append("                 AND SEG_PAIS.OID_PAIS = " + calMotivTipoClienFrom.getPaisOidPais().getId());
        }
        query.append("                   AND V_GEN_I18N_SICC.ATTR_ENTI = 'CAL_MOTIV_CONTA'  ");
        query.append("                   AND V_GEN_I18N_SICC.ATTR_NUM_ATRI = 1 ");
        query.append("                   AND V_GEN_I18N_SICC.IDIO_OID_IDIO = 1 ");
        query.append("                   AND V_GEN_I18N_SICC.VAL_OID = CAL_MOTIV_CONTA.OID_MOTI_CONT ");
        
        query.append("                   AND I18N.ATTR_ENTI = 'MAE_TIPO_CLIEN' ");
        query.append("                   AND I18N.ATTR_NUM_ATRI = 1 ");
        query.append("                   AND I18N.IDIO_OID_IDIO = 1  ");
        query.append("                   AND I18N.VAL_OID = MAE_TIPO_CLIEN.OID_TIPO_CLIE ");
        if(calMotivTipoClienFrom.getId() != null)
        {
          query.append("                 AND CAL_MOTIV_TIPO_CLIEN.OID_MOTI_TIPO_CLIE = " + calMotivTipoClienFrom.getId());
        }
        query.append("                   ORDER BY V_GEN_I18N_SICC.VAL_OID ");
        
        try {
               
              rs = bs.dbService.executeStaticQuery(query.toString());
        } catch (Exception ex) {
           
             ex.printStackTrace();
             UtilidadesLog.error("ERROR ", ex);
             throw new MareException(ex, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS));
        }
        int cant = rs.getRowCount();
        Vector result = new Vector();
        CalMotivTipoClienData calMotivTipoClien = null;
        CalMotivContaData calMotivConta = null;
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
                      calMotivTipoClien = new CalMotivTipoClienData();
                      calMotivTipoClien.setId(new Long(((BigDecimal)rs.getValueAt(i,"OID_MOTI_TIPO_CLIE")).toString()));
                      calMotivConta = new CalMotivContaData(); 
                      calMotivConta.setId( new Long(((BigDecimal)rs.getValueAt(i,"OIDMOTIV")).toString()));
                      calMotivConta.setDescripcion((String)rs.getValueAt(i,"DESMOTIV"));
                      calMotivTipoClien.setMocoOidMotiCont(calMotivConta);
                      maeTipoClienFrom = new MaeTipoClienData();
                      maeTipoClienFrom.setId( new Long(((BigDecimal)rs.getValueAt(i,"OIDTIPO")).toString()));
                      maeTipoClienFrom.setDescripcion((String)rs.getValueAt(i,"DESTIPO"));
                      calMotivTipoClien.setTiclOidTipoClie(maeTipoClienFrom);
                      segPaisViewFrom = new SegPaisViewData();
                      segPaisViewFrom.setId( new Long(((BigDecimal)rs.getValueAt(i,"OID_PAIS")).toString()));
                      calMotivTipoClien.setPaisOidPais(segPaisViewFrom);
                      result.add(calMotivTipoClien);
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
           UtilidadesLog.info("DAOCalMotivContaTipoCliente.query(CalMotivTipoClienData calMotivTipoClienFrom, CalMotivTipoClienData calMotivTipoClienTo, HashMap userProperties, Integer pageCount, Integer pageSize): Salida");           
           return result; 
          
     }
    public void remove(Vector calMotivContaTipoCliente)throws MareException
    {
           UtilidadesLog.info("DAOCalMotivContaTipoCliente.remove(Vector calMotivContaTipoCliente): Entrada");
           RecordSet rs = null;
           BelcorpService bs = UtilidadesEJB.getBelcorpService();
           StringBuffer update = new StringBuffer();
           StringBuffer updateInter = new StringBuffer();
           
           int cant = calMotivContaTipoCliente.size();
          CalMotivTipoClienData calMotivTipoClien = null;
           String oidMotivCliente = "";
           
           for (int j = 0; j < cant; j++) {
           calMotivTipoClien = (CalMotivTipoClienData)calMotivContaTipoCliente.get(j);
                
               oidMotivCliente = oidMotivCliente + "," + calMotivTipoClien.getId();
           }
           update.append(" delete CAL_MOTIV_TIPO_CLIEN ");
           update.append("where OID_MOTI_TIPO_CLIE in ( " + oidMotivCliente.substring(1) + ") ");
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
           UtilidadesLog.info("DAOCalMotivContaTipoCliente.remove(Vector calMotivContaTipoCliente): Salida"); 
     }
}
