package es.indra.sicc.logicanegocio.bel;
import es.indra.belcorp.mso.BelEstadMercaData;
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

public class DAOEstadosMercaderia 
{
  public DAOEstadosMercaderia()
  {
  }
  
  public Hashtable insertar(BelEstadMercaData belEstadMercaData, Vector localizationLabels , HashMap userProperties) throws MareException{
  
      UtilidadesLog.info("DAOEstadosMercaderia.guardar(BelEstadMercaData belEstadMercaData, Vector vector , HashMap userProperties): Entrada");
      RecordSet rs = null;
      BelcorpService bs = UtilidadesEJB.getBelcorpService();
      Long id = SecuenciadorOID.obtenerSiguienteValor("BEL_ESME_SEQ");
      StringBuffer update = new StringBuffer();        
           
      update.append("INSERT INTO BEL_ESTAD_MERCA ( ");
      update.append("OID_ESTA_MERC "); 
      if (belEstadMercaData.getPaisOidPais().getId()!=null)
          update.append(", PAIS_OID_PAIS"); 
      if (belEstadMercaData.getCodEsta()!=null)
          update.append(", COD_ESTA"); 
      update.append(" ) VALUES ( ");    
      update.append(id);
      if (belEstadMercaData.getPaisOidPais()!=null)
          update.append("," + belEstadMercaData.getPaisOidPais().getId()); 
      if (belEstadMercaData.getCodEsta()!=null)
          update.append(", '" + belEstadMercaData.getCodEsta() + "'");    
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
              
          updateInter.append(" INSERT INTO GEN_I18N_SICC_PAIS ( ");
          updateInter.append("OID_I18N, "); 
          updateInter.append("ATTR_ENTI, "); 
          updateInter.append("ATTR_NUM_ATRI, "); 
          updateInter.append("IDIO_OID_IDIO, "); 
          updateInter.append("VAL_I18N, ");                 
          updateInter.append("VAL_OID "); 
          updateInter.append(" ) VALUES ( ");
          updateInter.append(" GEN_i18n_SEQ.NEXTVAL , ");
          updateInter.append(" 'BEL_ESTAD_MERCA', ");
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
      
      UtilidadesLog.info("DAOEstadosMercaderia.guardar(BelEstadMercaData belEstadMercaData, Vector vector , HashMap userProperties): Salida");
      return primaryKey;
  }
  
 public Vector query(BelEstadMercaData belEstadMercaFrom, BelEstadMercaData belEstadMercaTo, HashMap userProperties, Integer pageCount, Integer pageSize) throws MareException 
 {

       UtilidadesLog.info("DAOEstadosMercaderia.query(BelEstadMercaData belEstadMercaData, BelEstadMercaData belEstadMercaData, HashMap userProperties, Integer pageCount, Integer pageSize): Entrada");
        
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

        query.append(" SELECT OID_ESTA_MERC, COD_ESTA, i18n.VAL_I18N ");
        query.append(" FROM BEL_ESTAD_MERCA, v_gen_i18n_sicc i18n ");
        query.append(" WHERE OID_ESTA_MERC = i18n.val_oid ");
        query.append(" and i18n.ATTR_ENTI = 'BEL_ESTAD_MERCA' ");
        query.append(" and i18n.ATTR_NUM_ATRI = 1 ");
        query.append(" and i18n.IDIO_OID_IDIO = " + (String)idioma.getValue());
        
        // Para la busqueda
        if(belEstadMercaFrom.getCodEsta()!= null){
            query.append(" and COD_ESTA like '" + belEstadMercaFrom.getCodEsta() + "' ");
        }
        
        if(belEstadMercaFrom.getDescripcion()!= null){
            query.append(" and i18n.val_i18n like '" + belEstadMercaFrom.getDescripcion() + "' ");
        }
        
        // Para el detalle
        if(belEstadMercaFrom.getId()!= null){
            query.append(" and OID_ESTA_MERC = " + belEstadMercaFrom.getId());
        }

        try {
           rs = bs.dbService.executeStaticQuery(query.toString());
        } catch (Exception ex) {
          UtilidadesLog.error("ERROR ", ex);
          throw new MareException(ex, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS));
        }
        
        
        int cant = rs.getRowCount();
        Vector result = new Vector();
        
        BelEstadMercaData belEstadMercaData = null;
        
        int rsSaltar = (pageCount.intValue() - 1) * pageSize.intValue();
        int rsMostrar = ((pageSize.intValue() == Integer.MAX_VALUE) ? pageSize.intValue() : (pageSize.intValue() + 1)) + rsSaltar;
        
        UtilidadesLog.debug("rsSaltar: " + rsSaltar);
        UtilidadesLog.debug("rsMostrar: " + rsMostrar);
        
        for(int i=0; i < cant; i++){
        
            if(i < rsSaltar ) {
                continue;
            }
            
            if(i < rsMostrar){
                belEstadMercaData = new BelEstadMercaData();
                
                belEstadMercaData.setId(Long.valueOf(((BigDecimal)rs.getValueAt(i,"OID_ESTA_MERC")).toString()));
                belEstadMercaData.setCodEsta((String)rs.getValueAt(i,"COD_ESTA"));  
                belEstadMercaData.setDescripcion((String)rs.getValueAt(i,"VAL_I18N"));  
                
                result.add(belEstadMercaData);
                
            } else {
               break;
            }
        }
        
        UtilidadesLog.debug("result: " + result);
       
        UtilidadesLog.info("DAOEstadosMercaderia.query(BelEstadMercaData belEstadMercaData, BelEstadMercaData belEstadMercaData, HashMap userProperties, Integer pageCount, Integer pageSize): Salida");
        return result;
   
 }
 public void remove(Vector belEstadMercaFrom ) throws MareException
 {
   
    UtilidadesLog.info("DAOEstadosMercaderia.remove(Vector belEstadMerca): Entrada");
        RecordSet rs = null;
        BelcorpService bs = UtilidadesEJB.getBelcorpService();
        StringBuffer update = new StringBuffer();
        StringBuffer updateInter = new StringBuffer();
        
        int cant = belEstadMercaFrom.size();
        BelEstadMercaData belEstadMerca = null;
        String oids = "";
        
        for (int j = 0; j < cant; j++) {
            belEstadMerca = (BelEstadMercaData)belEstadMercaFrom.get(j);
             
            oids = oids + "," + belEstadMerca.getId();
        }
        
        update.append("delete BEL_ESTAD_MERCA ");
        update.append("where OID_ESTA_MERC in ( " + oids.substring(1) + ") ");
        
        updateInter.append("delete GEN_I18N_SICC_PAIS ");
        updateInter.append(" where VAL_OID in ( " + oids.substring(1) + ") ");
        updateInter.append(" and ATTR_NUM_ATRI = 1 ");
        updateInter.append(" and ATTR_ENTI = 'BEL_ESTAD_MERCA' ");
        
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
        
        UtilidadesLog.info("DAOEstadosMercaderia.remove(Vector belEstadMerca): Salida");
   
 }
 
 public void update(BelEstadMercaData belEstadMercaData, Vector localizationLabels) throws MareException 
 {
   
        UtilidadesLog.info("DAOEstadosMercaderia.update(BelEstadMercaData belEstadMercaData, Vector localizationLabels): Entrada");
       
        RecordSet rs = null;
        BelcorpService bs = UtilidadesEJB.getBelcorpService();
        StringBuffer update = new StringBuffer();
        
        update.append("UPDATE BEL_ESTAD_MERCA SET ");
        update.append(" COD_ESTA = '" + belEstadMercaData.getCodEsta()+"' ");
        
        if (belEstadMercaData.getPaisOidPais() != null) {
            update.append(", PAIS_OID_PAIS = " + belEstadMercaData.getPaisOidPais().getId() );
        } else {
            update.append(", PAIS_OID_PAIS = NULL ");
        }
        
        update.append(" WHERE OID_ESTA_MERC = " + belEstadMercaData.getId());   
        
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
            updateInter.append("DELETE GEN_I18N_SICC_PAIS ");
            updateInter.append(" where VAL_OID in ( " + belEstadMercaData.getId() + ") ");
            updateInter.append(" and ATTR_NUM_ATRI = 1 ");
            updateInter.append(" and ATTR_ENTI = 'BEL_ESTAD_MERCA' ");
            
            int cantRegBorrados = bs.dbService.executeUpdate(updateInter.toString());
            
            for(int i= 0; i< cant; i++){                      
               
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
              updateInter.append(" GEN_i18n_SEQ.NEXTVAL , ");
              updateInter.append(" 'BEL_ESTAD_MERCA', ");
              updateInter.append(" 1, ");            
              updateInter.append(genDetaSiccData.getIdioOidIdio().getId() + ", ");
              updateInter.append(" '" + genDetaSiccData.getDeta() + "', ");
              updateInter.append(belEstadMercaData.getId() + " )");
              int cantReginsertados = bs.dbService.executeUpdate(updateInter.toString());
            }

        } catch (Exception ex) {
            ex.printStackTrace();
            throw new MareException(ex, UtilidadesError.armarCodigoError(
                                    CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS));
        }
        
        
               
        UtilidadesLog.info("DAOEstadosMercaderia.update(BelEstadMercaData belEstadMercaData, Vector localizationLabels): Salida");
 }
 
}