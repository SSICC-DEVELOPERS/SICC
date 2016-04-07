package es.indra.sicc.logicanegocio.mae;
import es.indra.belcorp.mso.MaeTipoDirecData;
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


public class DAOTipoDireccion 
{
  public DAOTipoDireccion()
  {
  }
  /*
    MAE_TIPO_DIREC
    OID_TIPO_DIRE 
    COD_TIPO_DIRE 
   */
   public Hashtable insertar(MaeTipoDirecData maeTipoDirecData, Vector localizationLabels , HashMap userProperties) throws MareException{
  
      UtilidadesLog.info("DAOTipoDireccion.guardar(MaeTipoDirecData MaeTipoDirecData, Vector localizationLabels , HashMap userProperties): Entrada");
      RecordSet rs = null;
      BelcorpService bs = UtilidadesEJB.getBelcorpService();
      Long id = SecuenciadorOID.obtenerSiguienteValor("MAE_TIDC_SEQ");
      StringBuffer update = new StringBuffer();        
           
      update.append("INSERT INTO MAE_TIPO_DIREC ( ");
      update.append("OID_TIPO_DIRE "); 
      if (maeTipoDirecData.getCodTipoDire()!=null)
          update.append(", COD_TIPO_DIRE"); 
      update.append(" ) VALUES ( ");    
      update.append(id);
      if (maeTipoDirecData.getCodTipoDire()!=null)
          update.append(", '" + maeTipoDirecData.getCodTipoDire() + "'");    
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
          updateInter.append(" 'MAE_TIPO_DIREC', ");
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
      
      UtilidadesLog.info("DAOTipoDireccion.guardar(MaeTipoDirecData MaeTipoDirecData, Vector localizationLabels , HashMap userProperties): Salida");
      return primaryKey;
  }
  
 public Vector query(MaeTipoDirecData maeTipoClasiClienFrom, MaeTipoDirecData maeTipoClasiClienTo, HashMap userProperties, Integer pageCount, Integer pageSize) throws MareException 
 {

       UtilidadesLog.info("DAOTipoDireccion.query(MaeTipoDirecData maeTipoClasiClienFrom, MaeTipoDirecData maeTipoClasiClienTo, HashMap userProperties, Integer pageCount, Integer pageSize): Entrada");
        
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

        query.append(" SELECT OID_TIPO_DIRE, COD_TIPO_DIRE,  i18n.VAL_I18N ");
        query.append(" FROM MAE_TIPO_DIREC, v_gen_i18n_sicc i18n ");
        query.append(" WHERE OID_TIPO_DIRE = i18n.val_oid ");
        query.append(" and i18n.ATTR_ENTI = 'MAE_TIPO_DIREC' ");
        query.append(" and i18n.ATTR_NUM_ATRI = 1 ");
        query.append(" and i18n.IDIO_OID_IDIO = " + (String)idioma.getValue());
        
        // Para la busqueda
        if(maeTipoClasiClienFrom.getCodTipoDire()!= null){
            query.append(" and COD_TIPO_DIRE like '" + maeTipoClasiClienFrom.getCodTipoDire() + "' ");
        }
        
        if(maeTipoClasiClienFrom.getDescripcion()!= null){
            query.append(" and i18n.val_i18n like '" + maeTipoClasiClienFrom.getDescripcion() + "' ");
        }
        
        // Para el detalle
        if(maeTipoClasiClienFrom.getId()!= null){
            query.append(" and OID_TIPO_DIRE = " + maeTipoClasiClienFrom.getId());
        }

        try {
           rs = bs.dbService.executeStaticQuery(query.toString());
        } catch (Exception ex) {
          UtilidadesLog.error("ERROR ", ex);
          throw new MareException(ex, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS));
        }
        
        
        int cant = rs.getRowCount();
        Vector result = new Vector();
        
        MaeTipoDirecData maeTipoDirecData = null;
        
        
        int rsSaltar = (pageCount.intValue() - 1) * pageSize.intValue();
        int rsMostrar = ((pageSize.intValue() == Integer.MAX_VALUE) ? pageSize.intValue() : (pageSize.intValue() + 1)) + rsSaltar;
        
        UtilidadesLog.debug("rsSaltar: " + rsSaltar);
        UtilidadesLog.debug("rsMostrar: " + rsMostrar);
        
        for(int i=0; i < cant; i++){
        
            if(i < rsSaltar ) {
                continue;
            }
            
            if(i < rsMostrar){
                maeTipoDirecData = new MaeTipoDirecData();
                
                maeTipoDirecData.setId(Long.valueOf(((BigDecimal)rs.getValueAt(i,"OID_TIPO_DIRE")).toString()));
                maeTipoDirecData.setCodTipoDire((String)rs.getValueAt(i,"COD_TIPO_DIRE"));  
                maeTipoDirecData.setDescripcion((String)rs.getValueAt(i,"VAL_I18N"));  
                
                result.add(maeTipoDirecData);
                
            } else {
               break;
            }
        }
        
        UtilidadesLog.debug("result: " + result);
       
        UtilidadesLog.info("DAOTipoDireccion.query(MaeTipoDirecData maeTipoClasiClienFrom, MaeTipoDirecData maeTipoClasiClienTo, HashMap userProperties, Integer pageCount, Integer pageSize): Salida");
        return result;
   
 }
 public void remove(Vector maeTipoDirec ) throws MareException
 {
   
    UtilidadesLog.info("DAOTipoDireccion.remove(Vector maeTipoDirec): Entrada");
        RecordSet rs = null;
        BelcorpService bs = UtilidadesEJB.getBelcorpService();
        StringBuffer update = new StringBuffer();
        StringBuffer updateInter = new StringBuffer();
        
        int cant = maeTipoDirec.size();
        MaeTipoDirecData maeTipoDirecData = null;
        String oids = "";
        
        for (int j = 0; j < cant; j++) {
            maeTipoDirecData = (MaeTipoDirecData)maeTipoDirec.get(j);
             
            oids = oids + "," + maeTipoDirecData.getId();
        }
        
        update.append("delete MAE_TIPO_DIREC ");
        update.append("where OID_TIPO_DIRE in ( " + oids.substring(1) + ") ");
        
        updateInter.append("delete GEN_I18N_SICC_COMUN ");
        updateInter.append(" where VAL_OID in ( " + oids.substring(1) + ") ");
        updateInter.append(" and ATTR_NUM_ATRI = 1 ");
        updateInter.append(" and ATTR_ENTI = 'MAE_TIPO_DIREC' ");
        
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
        
        UtilidadesLog.info("DAOTipoDireccion.remove(Vector maeTipoDirec): Salida");
   
 }
 
 public void update(MaeTipoDirecData maeTipoDirecData, Vector localizationLabels) throws MareException 
 {
   
        UtilidadesLog.info("DAOTipoDireccion.update(MaeTipoDirecData MaeTipoDirecData, Vector localizationLabels): Entrada");
       
        RecordSet rs = null;
        BelcorpService bs = UtilidadesEJB.getBelcorpService();
        StringBuffer update = new StringBuffer();
        
        update.append("UPDATE MAE_TIPO_DIREC SET ");
        update.append(" COD_TIPO_DIRE = '" + maeTipoDirecData.getCodTipoDire()+"' ");
        
        update.append(" WHERE OID_TIPO_DIRE = " + maeTipoDirecData.getId());   
        
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
            updateInter.append(" where VAL_OID in ( " + maeTipoDirecData.getId() + ") ");
            updateInter.append(" and ATTR_NUM_ATRI = 1 ");
            updateInter.append(" and ATTR_ENTI = 'MAE_TIPO_DIREC' ");
            
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
              updateInter.append(" 'MAE_TIPO_DIREC', ");
              updateInter.append(" 1, ");            
              updateInter.append(genDetaSiccData.getIdioOidIdio().getId() + ", ");
              updateInter.append(" '" + genDetaSiccData.getDeta() + "', ");
              updateInter.append(maeTipoDirecData.getId() + " )");
              int cantReginsertados = bs.dbService.executeUpdate(updateInter.toString());
            }

        } catch (Exception ex) {
            ex.printStackTrace();
            throw new MareException(ex, UtilidadesError.armarCodigoError(
                                    CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS));
        }
        
        
        UtilidadesLog.info("DAOTipoDireccion.update(MaeTipoDirecData MaeTipoDirecData, Vector localizationLabels): Salida");
 }


  
}