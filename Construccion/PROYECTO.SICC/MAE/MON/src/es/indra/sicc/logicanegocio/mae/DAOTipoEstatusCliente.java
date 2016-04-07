package es.indra.sicc.logicanegocio.mae;
import es.indra.belcorp.mso.MaeTipoEstatClienData;
import es.indra.belcorp.mso.SegMarcaData;
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

public class DAOTipoEstatusCliente 
{
  public DAOTipoEstatusCliente()
  {
  }
  /*MAE_TIPO_ESTAT_CLIEN                    
    OID_TIPO_ESTA 
    COD_TIPO_ESTA 
    MARC_OID_MARC */
  public Hashtable insertar(MaeTipoEstatClienData maeTipoEstatClienData, Vector localizationLabels , HashMap userProperties) throws MareException{
  
      UtilidadesLog.info("DAOTipoEstatusCliente.guardar(MaeTipoEstatClienData MaeTipoEstatClienData, Vector localizationLabels , HashMap userProperties): Entrada");
      RecordSet rs = null;
      BelcorpService bs = UtilidadesEJB.getBelcorpService();
      Long id = SecuenciadorOID.obtenerSiguienteValor("MAE_TESC_SEQ");
      StringBuffer update = new StringBuffer();        
           
      update.append("INSERT INTO MAE_TIPO_ESTAT_CLIEN ( ");
      update.append("OID_TIPO_ESTA "); 
      if (maeTipoEstatClienData.getCodTipoEsta()!=null)
          update.append(", COD_TIPO_ESTA"); 
      if (maeTipoEstatClienData.getMarcOidMarc()!=null)
      update.append(", MARC_OID_MARC"); 
      update.append(" ) VALUES ( ");    
      update.append(id);
      if (maeTipoEstatClienData.getCodTipoEsta()!=null)
          update.append(", '" + maeTipoEstatClienData.getCodTipoEsta() + "'");    
      if (maeTipoEstatClienData.getMarcOidMarc()!=null)
      update.append(", " + maeTipoEstatClienData.getMarcOidMarc().getId());    
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
          updateInter.append(" 'MAE_TIPO_ESTAT_CLIEN', ");
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
      
      UtilidadesLog.info("DAOTipoEstatusCliente.guardar(MaeTipoEstatClienData MaeTipoEstatClienData, Vector localizationLabels , HashMap userProperties): Salida");
      return primaryKey;
  }
  
 public Vector query(MaeTipoEstatClienData maeTipoEstatClienFrom, MaeTipoEstatClienData maeTipoEstatClienTo, HashMap userProperties, Integer pageCount, Integer pageSize) throws MareException 
 {

       UtilidadesLog.info("DAOTipoEstatusCliente.query(MaeTipoEstatClienData maeTipoEstatClienFrom, MaeTipoEstatClienData maeTipoEstatClienTo, HashMap userProperties, Integer pageCount, Integer pageSize): Entrada");
        
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
  /*MAE_TIPO_ESTAT_CLIEN                    
    OID_TIPO_ESTA 
    COD_TIPO_ESTA 
    MARC_OID_MARC */
        query.append(" SELECT OID_TIPO_ESTA, COD_TIPO_ESTA,  i18n.VAL_I18N, MARC_OID_MARC, m.COD_MARC , m.DES_MARC ");
        query.append(" FROM MAE_TIPO_ESTAT_CLIEN, v_gen_i18n_sicc i18n, SEG_MARCA m ");
        query.append(" WHERE OID_TIPO_ESTA = i18n.val_oid ");
        query.append(" and i18n.ATTR_ENTI = 'MAE_TIPO_ESTAT_CLIEN' ");
        query.append(" and i18n.ATTR_NUM_ATRI = 1 ");
        query.append(" and i18n.IDIO_OID_IDIO = " + (String)idioma.getValue());
        query.append(" and OID_MARC = MARC_OID_MARC ");        
        
        // Para la busqueda
        if(maeTipoEstatClienFrom.getCodTipoEsta()!= null){
            query.append(" and COD_TIPO_ESTA like '" + maeTipoEstatClienFrom.getCodTipoEsta() + "' ");
        }
        
        if(maeTipoEstatClienFrom.getDescripcion()!= null){
            query.append(" and i18n.val_i18n like '" + maeTipoEstatClienFrom.getDescripcion() + "' ");
        }
        
        // Para el detalle
        if(maeTipoEstatClienFrom.getId()!= null){
            query.append(" and OID_TIPO_ESTA = " + maeTipoEstatClienFrom.getId());
        }
        if(maeTipoEstatClienFrom.getMarcOidMarc()!= null){
            query.append(" and MARC_OID_MARC = " + maeTipoEstatClienFrom.getMarcOidMarc().getId());
        }

        try {
           rs = bs.dbService.executeStaticQuery(query.toString());
        } catch (Exception ex) {
          UtilidadesLog.error("ERROR ", ex);
          throw new MareException(ex, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS));
        }
        
        
        int cant = rs.getRowCount();
        Vector result = new Vector();
        
        MaeTipoEstatClienData maeTipoEstatClienData = null;
        SegMarcaData segMarcaData = null;
        
        int rsSaltar = (pageCount.intValue() - 1) * pageSize.intValue();
        int rsMostrar = ((pageSize.intValue() == Integer.MAX_VALUE) ? pageSize.intValue() : (pageSize.intValue() + 1)) + rsSaltar;
        
        UtilidadesLog.debug("rsSaltar: " + rsSaltar);
        UtilidadesLog.debug("rsMostrar: " + rsMostrar);
        
        for(int i=0; i < cant; i++){
        
            if(i < rsSaltar ) {
                continue;
            }
            
            if(i < rsMostrar){
                maeTipoEstatClienData = new MaeTipoEstatClienData();
                segMarcaData = new SegMarcaData();
                
                segMarcaData.setId(Long.valueOf(((BigDecimal)rs.getValueAt(i,"MARC_OID_MARC")).toString()));
                segMarcaData.setDesMarc(rs.getValueAt(i,"DES_MARC").toString());
                segMarcaData.setCodMarc(rs.getValueAt(i,"COD_MARC").toString());
                maeTipoEstatClienData.setId(Long.valueOf(((BigDecimal)rs.getValueAt(i,"OID_TIPO_ESTA")).toString()));
                maeTipoEstatClienData.setCodTipoEsta((String)rs.getValueAt(i,"COD_TIPO_ESTA"));  
                maeTipoEstatClienData.setDescripcion((String)rs.getValueAt(i,"VAL_I18N"));  
                maeTipoEstatClienData.setMarcOidMarc(segMarcaData);
                
                result.add(maeTipoEstatClienData);
                
            } else {
               break;
            }
        }
        
        UtilidadesLog.debug("result: " + result);
       
        UtilidadesLog.info("DAOTipoEstatusCliente.query(MaeTipoEstatClienData maeTipoEstatClienFrom, MaeTipoEstatClienData maeTipoEstatClienTo, HashMap userProperties, Integer pageCount, Integer pageSize): Salida");
        return result;
   
 }
 public void remove(Vector maeTipoEstatClien ) throws MareException
 {
   
    UtilidadesLog.info("DAOTipoEstatusCliente.remove(Vector maeTipoEstatClien): Entrada");
        RecordSet rs = null;
        BelcorpService bs = UtilidadesEJB.getBelcorpService();
        StringBuffer update = new StringBuffer();
        StringBuffer updateInter = new StringBuffer();
        
        int cant = maeTipoEstatClien.size();
        MaeTipoEstatClienData maeTipoEstatClienData = null;
        String oids = "";
        
        for (int j = 0; j < cant; j++) {
            maeTipoEstatClienData = (MaeTipoEstatClienData)maeTipoEstatClien.get(j);
             
            oids = oids + "," + maeTipoEstatClienData.getId();
        }
        
        update.append("delete MAE_TIPO_ESTAT_CLIEN ");
        update.append("where OID_TIPO_ESTA in ( " + oids.substring(1) + ") ");
        
        updateInter.append("delete GEN_I18N_SICC_COMUN ");
        updateInter.append(" where VAL_OID in ( " + oids.substring(1) + ") ");
        updateInter.append(" and ATTR_NUM_ATRI = 1 ");
        updateInter.append(" and ATTR_ENTI = 'MAE_TIPO_ESTAT_CLIEN' ");
        
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
        
        UtilidadesLog.info("DAOTipoEstatusCliente.remove(Vector maeTipoEstatClien): Salida");
   
 }
 
 public void update(MaeTipoEstatClienData maeTipoEstatClienData, Vector localizationLabels) throws MareException 
 {
   
        UtilidadesLog.info("DAOTipoEstatusCliente.update(MaeTipoEstatClienData MaeTipoEstatClienData, Vector localizationLabels): Entrada");
       
        RecordSet rs = null;
        BelcorpService bs = UtilidadesEJB.getBelcorpService();
        StringBuffer update = new StringBuffer();
        
        update.append("UPDATE MAE_TIPO_ESTAT_CLIEN SET ");
        update.append(" COD_TIPO_ESTA = '" + maeTipoEstatClienData.getCodTipoEsta()+"' ");
        update.append(", MARC_OID_MARC = " + maeTipoEstatClienData.getMarcOidMarc().getId());
        update.append("  WHERE OID_TIPO_ESTA = " + maeTipoEstatClienData.getId());   
        
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
            updateInter.append(" where VAL_OID in ( " + maeTipoEstatClienData.getId() + ") ");
            updateInter.append(" and ATTR_NUM_ATRI = 1 ");
            updateInter.append(" and ATTR_ENTI = 'MAE_TIPO_ESTAT_CLIEN' ");
            
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
              updateInter.append(" 'MAE_TIPO_ESTAT_CLIEN', ");
              updateInter.append(" 1, ");            
              updateInter.append(genDetaSiccData.getIdioOidIdio().getId() + ", ");
              updateInter.append(" '" + genDetaSiccData.getDeta() + "', ");
              updateInter.append(maeTipoEstatClienData.getId() + " )");
              int cantReginsertados = bs.dbService.executeUpdate(updateInter.toString());
            }

        } catch (Exception ex) {
            ex.printStackTrace();
            throw new MareException(ex, UtilidadesError.armarCodigoError(
                                    CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS));
        }
        
        
        UtilidadesLog.info("DAOTipoEstatusCliente.update(MaeTipoEstatClienData MaeTipoEstatClienData, Vector localizationLabels): Salida");
 }


 
  
}