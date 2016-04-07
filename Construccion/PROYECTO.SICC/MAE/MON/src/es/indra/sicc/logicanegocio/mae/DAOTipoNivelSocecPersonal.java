package es.indra.sicc.logicanegocio.mae;
import es.indra.belcorp.mso.MaeTipoNivelSocecPersoData;
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



public class DAOTipoNivelSocecPersonal 
{
  public DAOTipoNivelSocecPersonal()
  {
  }
  /*
   MAE_TIPO_NIVEL_SOCEC_PERSO
    OID_NSEP 
    COD_NSEP 
    PAIS_OID_PAIS 
   */
   public Hashtable insertar(MaeTipoNivelSocecPersoData maeTipoNivelSocecPersoData, Vector localizationLabels , HashMap userProperties) throws MareException{
  
      UtilidadesLog.info("DAOTipoNivelSocecPersonal.guardar(MaeTipoNivelSocecPersoData maeTipoNivelSocecPersoData, Vector localizationLabels , HashMap userProperties): Entrada");
      RecordSet rs = null;
      BelcorpService bs = UtilidadesEJB.getBelcorpService();
      Long id = SecuenciadorOID.obtenerSiguienteValor("MAE_NSEP_SEQ");
      StringBuffer update = new StringBuffer();        
           
      update.append("INSERT INTO MAE_TIPO_NIVEL_SOCEC_PERSO ( ");
      update.append("OID_NSEP "); 
      if (maeTipoNivelSocecPersoData.getPaisOidPais().getId()!=null)
          update.append(", PAIS_OID_PAIS"); 
      if (maeTipoNivelSocecPersoData.getCodNsep()!=null)
          update.append(", COD_NSEP"); 
      update.append(" ) VALUES ( ");    
      update.append(id);
      if (maeTipoNivelSocecPersoData.getPaisOidPais()!=null)
          update.append("," + maeTipoNivelSocecPersoData.getPaisOidPais().getId()); 
      if (maeTipoNivelSocecPersoData.getCodNsep()!=null)
          update.append(", '" + maeTipoNivelSocecPersoData.getCodNsep() + "'");    
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
          updateInter.append(" 'MAE_TIPO_NIVEL_SOCEC_PERSO', ");
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
      
      UtilidadesLog.info("DAOTipoNivelSocecPersonal.guardar(MaeTipoNivelSocecPersoData maeTipoNivelSocecPersoData, Vector localizationLabels , HashMap userProperties): Salida");
      return primaryKey;
  }
  
 public Vector query(MaeTipoNivelSocecPersoData maeTipoNivelSocecPersFrom, MaeTipoNivelSocecPersoData maeTipoNivelSocecPersTo, HashMap userProperties, Integer pageCount, Integer pageSize) throws MareException 
 {

       UtilidadesLog.info("DAOTipoNivelSocecPersonal.query(MaeTipoNivelSocecPersoData maeTipoNivelSocecPersFrom, MaeTipoNivelSocecPersoData maeTipoNivelSocecPersTo, HashMap userProperties, Integer pageCount, Integer pageSize): Entrada");
        
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

        query.append(" SELECT OID_NSEP, COD_NSEP, i18n.VAL_I18N ");
        query.append(" FROM MAE_TIPO_NIVEL_SOCEC_PERSO, v_gen_i18n_sicc i18n ");
        query.append(" WHERE OID_NSEP = i18n.val_oid ");
        query.append(" and i18n.ATTR_ENTI = 'MAE_TIPO_NIVEL_SOCEC_PERSO' ");
        query.append(" and i18n.ATTR_NUM_ATRI = 1 ");
        query.append(" and i18n.IDIO_OID_IDIO = " + (String)idioma.getValue());
        
        // Para la busqueda
        if(maeTipoNivelSocecPersFrom.getCodNsep()!= null){
            query.append(" and COD_NSEP like '" + maeTipoNivelSocecPersFrom.getCodNsep() + "' ");
        }
        
        if(maeTipoNivelSocecPersFrom.getDescripcion()!= null){
            query.append(" and i18n.val_i18n like '" + maeTipoNivelSocecPersFrom.getDescripcion() + "' ");
        }
        
        // Para el detalle
        if(maeTipoNivelSocecPersFrom.getId()!= null){
            query.append(" and OID_NSEP = " + maeTipoNivelSocecPersFrom.getId());
        }

        try {
           rs = bs.dbService.executeStaticQuery(query.toString());
        } catch (Exception ex) {
          UtilidadesLog.error("ERROR ", ex);
          throw new MareException(ex, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS));
        }
        
        
        int cant = rs.getRowCount();
        Vector result = new Vector();
        
        MaeTipoNivelSocecPersoData maeTipoNivelSocecPersoData = null;
        
        int rsSaltar = (pageCount.intValue() - 1) * pageSize.intValue();
        int rsMostrar = ((pageSize.intValue() == Integer.MAX_VALUE) ? pageSize.intValue() : (pageSize.intValue() + 1)) + rsSaltar;
        
        UtilidadesLog.debug("rsSaltar: " + rsSaltar);
        UtilidadesLog.debug("rsMostrar: " + rsMostrar);
        
        for(int i=0; i < cant; i++){
        
            if(i < rsSaltar ) {
                continue;
            }
            
            if(i < rsMostrar){
                maeTipoNivelSocecPersoData = new MaeTipoNivelSocecPersoData();
                
                maeTipoNivelSocecPersoData.setId(Long.valueOf(((BigDecimal)rs.getValueAt(i,"OID_NSEP")).toString()));
                maeTipoNivelSocecPersoData.setCodNsep((String)rs.getValueAt(i,"COD_NSEP"));  
                maeTipoNivelSocecPersoData.setDescripcion((String)rs.getValueAt(i,"VAL_I18N"));  
                
                result.add(maeTipoNivelSocecPersoData);
                
            } else {
               break;
            }
        }
        
        UtilidadesLog.debug("result: " + result);
       
        UtilidadesLog.info("DAOTipoNivelSocecPersonal.query(MaeTipoNivelSocecPersoData maeTipoNivelSocecPersFrom, MaeTipoNivelSocecPersoData maeTipoNivelSocecPersTo, HashMap userProperties, Integer pageCount, Integer pageSize): Salida");
        return result;
   
 }
 public void remove(Vector maeTipoNivelSocecPers ) throws MareException
 {
   
    UtilidadesLog.info("DAOTipoNivelSocecPersonal.remove(Vector belEstadMerca): Entrada");
        RecordSet rs = null;
        BelcorpService bs = UtilidadesEJB.getBelcorpService();
        StringBuffer update = new StringBuffer();
        StringBuffer updateInter = new StringBuffer();
        
        int cant = maeTipoNivelSocecPers.size();
        MaeTipoNivelSocecPersoData maeTipoNivelSocecPersoData = null;
        String oids = "";
        
        for (int j = 0; j < cant; j++) {
            maeTipoNivelSocecPersoData = (MaeTipoNivelSocecPersoData)maeTipoNivelSocecPers.get(j);
             
            oids = oids + "," + maeTipoNivelSocecPersoData.getId();
        }
        
        update.append("delete MAE_TIPO_NIVEL_SOCEC_PERSO ");
        update.append("where OID_NSEP in ( " + oids.substring(1) + ") ");
        
        updateInter.append("delete GEN_I18N_SICC_PAIS ");
        updateInter.append(" where VAL_OID in ( " + oids.substring(1) + ") ");
        updateInter.append(" and ATTR_NUM_ATRI = 1 ");
        updateInter.append(" and ATTR_ENTI = 'MAE_TIPO_NIVEL_SOCEC_PERSO' ");
        
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
        
        UtilidadesLog.info("DAOTipoNivelSocecPersonal.remove(Vector belEstadMerca): Salida");
   
 }
 
 public void update(MaeTipoNivelSocecPersoData maeTipoNivelSocecPersoData, Vector localizationLabels) throws MareException 
 {
   
        UtilidadesLog.info("DAOTipoNivelSocecPersonal.update(MaeTipoNivelSocecPersoData maeTipoNivelSocecPersoData, Vector localizationLabels): Entrada");
       
        RecordSet rs = null;
        BelcorpService bs = UtilidadesEJB.getBelcorpService();
        StringBuffer update = new StringBuffer();
        
        update.append("UPDATE MAE_TIPO_NIVEL_SOCEC_PERSO SET ");
        update.append(" COD_NSEP = '" + maeTipoNivelSocecPersoData.getCodNsep()+"' ");
        
        if (maeTipoNivelSocecPersoData.getPaisOidPais() != null) {
            update.append(", PAIS_OID_PAIS = " + maeTipoNivelSocecPersoData.getPaisOidPais().getId() );
        } else {
            update.append(", PAIS_OID_PAIS = NULL ");
        }
        
        update.append(" WHERE OID_NSEP = " + maeTipoNivelSocecPersoData.getId());   
        
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
            updateInter.append(" where VAL_OID in ( " + maeTipoNivelSocecPersoData.getId() + ") ");
            updateInter.append(" and ATTR_NUM_ATRI = 1 ");
            updateInter.append(" and ATTR_ENTI = 'MAE_TIPO_NIVEL_SOCEC_PERSO' ");
            
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
              updateInter.append(" 'MAE_TIPO_NIVEL_SOCEC_PERSO', ");
              updateInter.append(" 1, ");            
              updateInter.append(genDetaSiccData.getIdioOidIdio().getId() + ", ");
              updateInter.append(" '" + genDetaSiccData.getDeta() + "', ");
              updateInter.append(maeTipoNivelSocecPersoData.getId() + " )");
              int cantReginsertados = bs.dbService.executeUpdate(updateInter.toString());
            }

        } catch (Exception ex) {
            ex.printStackTrace();
            throw new MareException(ex, UtilidadesError.armarCodigoError(
                                    CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS));
        }
        
        
        UtilidadesLog.info("DAOTipoNivelSocecPersonal.update(MaeTipoNivelSocecPersoData maeTipoNivelSocecPersoData, Vector localizationLabels): Salida");
 }
  
}