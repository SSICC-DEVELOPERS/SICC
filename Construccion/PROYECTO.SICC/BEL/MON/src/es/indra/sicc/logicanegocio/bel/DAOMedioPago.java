package es.indra.sicc.logicanegocio.bel;
import es.indra.belcorp.mso.BelMedioPagoData;
import es.indra.belcorp.mso.BelTipoMedioPagoData;
import es.indra.belcorp.mso.GenDetaSiccData;
import es.indra.mare.common.exception.MareException;
import es.indra.mare.common.mgu.manager.Property;
import es.indra.mare.common.mii.MareMiiServiceNotFoundException;
import es.indra.mare.common.mii.services.jdbcservice.RecordSet;
import es.indra.sicc.util.BelcorpService;
import es.indra.sicc.util.CodigosError;
import es.indra.sicc.util.SecuenciadorOID;
import es.indra.sicc.util.UtilidadesEJB;
import es.indra.sicc.util.UtilidadesError;
import es.indra.sicc.util.UtilidadesLog;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Vector;

public class DAOMedioPago 
{
  public DAOMedioPago()
  {
  }
  
  public Hashtable insertar(BelMedioPagoData belMedioPagoData, Vector localizationLabels , HashMap userProperties) throws MareException{
  
      UtilidadesLog.info("DAOMedioPago.guardar(BelEstadMercaData belEstadMercaData, Vector vector , HashMap userProperties): Entrada");
      RecordSet rs = null;
      BelcorpService bs = UtilidadesEJB.getBelcorpService();
      Long id = SecuenciadorOID.obtenerSiguienteValor("BEL_MPAB_SEQ");
      StringBuffer update = new StringBuffer();        
           
      update.append("INSERT INTO BEL_MEDIO_PAGO ( ");
      update.append(" OID_MEDI_PAGO "); 
      if (belMedioPagoData.getPaisOidPais().getId()!=null)
          update.append(", PAIS_OID_PAIS"); 
      if (belMedioPagoData.getCodMediPago()!=null)
          update.append(", COD_MEDI_PAGO"); 
      if (belMedioPagoData.getCodMediPago()!=null)
          update.append(", TMEP_OID_TIPO_MEDI_PAGO ");           
      update.append(" ) VALUES ( ");    
      update.append(id);
      if (belMedioPagoData.getPaisOidPais()!=null)
          update.append("," + belMedioPagoData.getPaisOidPais().getId()); 
      if (belMedioPagoData.getCodMediPago()!=null)
          update.append(", '" + belMedioPagoData.getCodMediPago() + "'");
      if (belMedioPagoData.getTmepOidTipoMediPago()!=null)
          update.append("," + belMedioPagoData.getTmepOidTipoMediPago().getId());
       update.append(") ");    
          
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
      Long idInter = null;        
      StringBuffer updateInter = null;

      for(int i= 0; i< cant; i++){   
          
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
          updateInter.append(" GEN_i18n_SEQ.NEXTVAL , ");
          updateInter.append(" 'BEL_MEDIO_PAGO', ");
          updateInter.append(" 1, ");            
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
      
      UtilidadesLog.info("DAOMedioPago.guardar(BelEstadMercaData belEstadMercaData, Vector vector , HashMap userProperties): Salida");
      return primaryKey;
  }
  
 public Vector query(BelMedioPagoData belMedioPagoFrom, BelMedioPagoData belMedioPagoTo, HashMap userProperties, Integer pageCount, Integer pageSize) throws MareException 
 {

       UtilidadesLog.info("DAOMedioPago.query(BelEstadMercaData belEstadMercaData, BelEstadMercaData belEstadMercaData, HashMap userProperties, Integer pageCount, Integer pageSize): Entrada");
        
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
        
        Property idioma = (Property)userProperties.get("Idioma");

        query.append(" SELECT OID_MEDI_PAGO, COD_MEDI_PAGO, i18n.VAL_I18N, TMEP_OID_TIPO_MEDI_PAGO, ");
        query.append(" PQ_APL_AUX.VALOR_GEN_I18N_SICC("+(String)idioma.getValue()+",TMEP_OID_TIPO_MEDI_PAGO,'BEL_TIPO_MEDIO_PAGO') DES_TIPO_MEDI_PAGO ");
        query.append(" FROM BEL_MEDIO_PAGO, v_gen_i18n_sicc i18n ");
        query.append(" WHERE OID_MEDI_PAGO = i18n.val_oid ");
        query.append(" and i18n.ATTR_ENTI = 'BEL_MEDIO_PAGO' ");
        query.append(" and i18n.ATTR_NUM_ATRI = 1 ");
        query.append(" and i18n.IDIO_OID_IDIO = " + (String)idioma.getValue());
        
        // Para la busqueda
        if(belMedioPagoFrom.getCodMediPago()!= null){
            query.append(" and COD_MEDI_PAGO like '" + belMedioPagoFrom.getCodMediPago() + "' ");
        }
        
        if(belMedioPagoFrom.getDescripcion()!= null){
            query.append(" and i18n.val_i18n like '" + belMedioPagoFrom.getDescripcion() + "' ");
        }
        
        if(belMedioPagoFrom.getId()!= null){
            query.append(" and OID_MEDI_PAGO = " + belMedioPagoFrom.getId());
        }
        if(belMedioPagoFrom.getTmepOidTipoMediPago() != null){
            query.append(" and TMEP_OID_TIPO_MEDI_PAGO = " + belMedioPagoFrom.getTmepOidTipoMediPago().getId());
        }

        try {
           rs = bs.dbService.executeStaticQuery(query.toString());
        } catch (Exception ex) {
          UtilidadesLog.error("ERROR ", ex);
          throw new MareException(ex, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS));
        }
        
        
        int cant = rs.getRowCount();
        Vector result = new Vector();
        
        BelMedioPagoData belMedioPagoData = null;
        BelTipoMedioPagoData belTipoMedioPagoData = null;
        int rsSaltar = (pageCount.intValue() - 1) * pageSize.intValue();
        int rsMostrar = ((pageSize.intValue() == Integer.MAX_VALUE) ? pageSize.intValue() : (pageSize.intValue() + 1)) + rsSaltar;
        
        UtilidadesLog.debug("rsSaltar: " + rsSaltar);
        UtilidadesLog.debug("rsMostrar: " + rsMostrar);
        
        for(int i=0; i < cant; i++){
        
            if(i < rsSaltar ) {
                continue;
            }
            
            if(i < rsMostrar){
                belMedioPagoData = new BelMedioPagoData();
                belTipoMedioPagoData = new BelTipoMedioPagoData();
                belTipoMedioPagoData.setId(Long.valueOf(((BigDecimal)rs.getValueAt(i,"TMEP_OID_TIPO_MEDI_PAGO")).toString()));
                belTipoMedioPagoData.setDescripcion(rs.getValueAt(i,"DES_TIPO_MEDI_PAGO").toString());
                
                belMedioPagoData.setId(Long.valueOf(((BigDecimal)rs.getValueAt(i,"OID_MEDI_PAGO")).toString()));
                belMedioPagoData.setCodMediPago((String)rs.getValueAt(i,"COD_MEDI_PAGO"));  
                belMedioPagoData.setDescripcion((String)rs.getValueAt(i,"VAL_I18N"));  
                belMedioPagoData.setTmepOidTipoMediPago(belTipoMedioPagoData);
                
                result.add(belMedioPagoData);
                
            } else {
               break;
            }
        }
        
        UtilidadesLog.debug("result: " + result);
       
        UtilidadesLog.info("DAOMedioPago.query(BelEstadMercaData belEstadMercaData, BelEstadMercaData belEstadMercaData, HashMap userProperties, Integer pageCount, Integer pageSize): Salida");
        return result;
   
 }
 public void remove(Vector belMedioPago ) throws MareException
 {
   
    UtilidadesLog.info("DAOMedioPago.remove(Vector belEstadMerca): Entrada");
        RecordSet rs = null;
        BelcorpService bs = UtilidadesEJB.getBelcorpService();
        StringBuffer update = new StringBuffer();
        StringBuffer updateInter = new StringBuffer();
        
        int cant = belMedioPago.size();
        BelMedioPagoData belEstadMerca = null;
        String oids = "";
        
        for (int j = 0; j < cant; j++) {
            belEstadMerca = (BelMedioPagoData)belMedioPago.get(j);
             
            oids = oids + "," + belEstadMerca.getId();
        }
        
        update.append("delete BEL_MEDIO_PAGO ");
        update.append("where OID_MEDI_PAGO in ( " + oids.substring(1) + ") ");
        
        updateInter.append("delete GEN_I18N_SICC_COMUN ");
        updateInter.append(" where VAL_OID in ( " + oids.substring(1) + ") ");
        updateInter.append(" and ATTR_NUM_ATRI = 1 ");
        updateInter.append(" and ATTR_ENTI = 'BEL_MEDIO_PAGO' ");
        
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
        
        UtilidadesLog.info("DAOMedioPago.remove(Vector belEstadMerca): Salida");
   
 }
 
 public void update(BelMedioPagoData belMedioPagoData, Vector localizationLabels) throws MareException 
 {
   
        UtilidadesLog.info("DAOMedioPago.update(BelEstadMercaData belEstadMercaData, Vector localizationLabels): Entrada");
       
        RecordSet rs = null;
        BelcorpService bs = UtilidadesEJB.getBelcorpService();
        StringBuffer update = new StringBuffer();
        
        update.append("UPDATE BEL_MEDIO_PAGO SET ");
        update.append(" COD_MEDI_PAGO = '" + belMedioPagoData.getCodMediPago()+"' ");
        
        if (belMedioPagoData.getPaisOidPais() != null) {
            update.append(", PAIS_OID_PAIS = " + belMedioPagoData.getPaisOidPais().getId() );
        } else {
            update.append(", PAIS_OID_PAIS = NULL ");
        }
        if (belMedioPagoData.getTmepOidTipoMediPago() != null) {
            update.append(", TMEP_OID_TIPO_MEDI_PAGO = " + belMedioPagoData.getTmepOidTipoMediPago().getId() );
        } else {
            update.append(", TMEP_OID_TIPO_MEDI_PAGO = NULL ");
        }
        update.append(" WHERE OID_MEDI_PAGO = " + belMedioPagoData.getId());   
        
        try {
            int cantRegActualizados = bs.dbService.executeUpdate(update.toString());
        } catch (Exception ex) {
            ex.printStackTrace();
            throw new MareException(ex, UtilidadesError.armarCodigoError(
                                    CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS));
        }
        
        int cant = localizationLabels.size();
        GenDetaSiccData genDetaSiccData = null;
        StringBuffer updateInter = null;
        try {
            updateInter = new StringBuffer();
            updateInter.append("DELETE GEN_I18N_SICC_COMUN ");
            updateInter.append(" where VAL_OID in ( " + belMedioPagoData.getId() + ") ");
            updateInter.append(" and ATTR_NUM_ATRI = 1 ");
            updateInter.append(" and ATTR_ENTI = 'BEL_MEDIO_PAGO' ");
            
            int cantRegBorrados = bs.dbService.executeUpdate(updateInter.toString());
            
            for(int i= 0; i< cant; i++){                      
               
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
              updateInter.append(" GEN_i18n_SEQ.NEXTVAL , ");
              updateInter.append(" 'BEL_MEDIO_PAGO', ");
              updateInter.append(" 1, ");            
              updateInter.append(genDetaSiccData.getIdioOidIdio().getId() + ", ");
              updateInter.append(" '" + genDetaSiccData.getDeta() + "', ");
              updateInter.append(belMedioPagoData.getId() + " )");
              int cantReginsertados = bs.dbService.executeUpdate(updateInter.toString());
            }

        } catch (Exception ex) {
            ex.printStackTrace();
            throw new MareException(ex, UtilidadesError.armarCodigoError(
                                    CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS));
        }
           
        UtilidadesLog.info("DAOMedioPago.update(BelEstadMercaData belEstadMercaData, Vector localizationLabels): Salida");
 }
  
public Vector query(BelTipoMedioPagoData belTipoMedioPagoFrom, BelTipoMedioPagoData belTipoMedioPagoTo, HashMap userProperties) throws MareException 
{

      UtilidadesLog.info("DAOMedioPago.query(BelTipoMedioPagoData belTipoMedioPagoFrom, BelTipoMedioPagoData belTipoMedioPagoTo, HashMap userProperties): Entrada");
       
     
       RecordSet rs = new RecordSet();
       StringBuffer query = new StringBuffer();
       BelcorpService bs;
   
       try {
         bs = BelcorpService.getInstance();
       } catch (MareMiiServiceNotFoundException e) {
           UtilidadesLog.error("ERROR ", e);
           throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_PEDIR_UN_SERVICIO_MARE));
       }
       
       Property idioma = (Property)userProperties.get("Idioma");

       query.append(" SELECT OID_TIPO_MEDI_PAGO, ");
       query.append(" PQ_APL_AUX.VALOR_GEN_I18N_SICC("+(String)idioma.getValue()+",OID_TIPO_MEDI_PAGO,'BEL_TIPO_MEDIO_PAGO') DES_TIPO_MEDI_PAGO ");
       query.append(" FROM BEL_TIPO_MEDIO_PAGO ");
       
       // Para la busqueda
       
       if(belTipoMedioPagoFrom.getId()!= null){
           query.append(" where OID_TIPO_MEDI_PAGO = " + belTipoMedioPagoFrom.getId());
       }
       

       try {
          rs = bs.dbService.executeStaticQuery(query.toString());
       } catch (Exception ex) {
         UtilidadesLog.error("ERROR ", ex);
         throw new MareException(ex, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS));
       }
       
       
       int cant = rs.getRowCount();
       Vector result = new Vector();
       
       BelTipoMedioPagoData belTipoMedioPagoData = null;

       
       for(int i=0; i < cant; i++){
       
               
               belTipoMedioPagoData = new BelTipoMedioPagoData();
               belTipoMedioPagoData.setId(Long.valueOf(((BigDecimal)rs.getValueAt(i,"OID_TIPO_MEDI_PAGO")).toString()));
               belTipoMedioPagoData.setDescripcion(rs.getValueAt(i,"DES_TIPO_MEDI_PAGO").toString());
               
               
               result.add(belTipoMedioPagoData);
               
       }
       
       UtilidadesLog.debug("result: " + result);
      
       UtilidadesLog.info("DAOMedioPago.query(BelTipoMedioPagoData belTipoMedioPagoFrom, BelTipoMedioPagoData belTipoMedioPagoTo, HashMap userProperties): Salida");
       return result;
  
}
  
}