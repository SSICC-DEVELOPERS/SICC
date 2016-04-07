package es.indra.sicc.logicanegocio.mae;
import es.indra.belcorp.mso.MaeTipoPerfiPsicoData;
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
public class DAOTipoPerfilPsico 
{
  public DAOTipoPerfilPsico()
  {
  }
  /*MAE_TIPO_PERFI_PSICO
OID_TIPO_PERF_PSIC 
COD_TIPO_PERF_PSIC */
   public Hashtable insertar(MaeTipoPerfiPsicoData maeTipoPerfiPsicoData, Vector localizationLabels , HashMap userProperties) throws MareException{
  
      UtilidadesLog.info("DAOTipoPerfilPsico.guardar(MaeTipoPerfiPsicoData MaeTipoPerfiPsicoData, Vector localizationLabels , HashMap userProperties): Entrada");
      RecordSet rs = null;
      BelcorpService bs = UtilidadesEJB.getBelcorpService();
      Long id = SecuenciadorOID.obtenerSiguienteValor("MAE_TPSP_SEQ");
      StringBuffer update = new StringBuffer();        
           
      update.append("INSERT INTO MAE_TIPO_PERFI_PSICO ( ");
      update.append("OID_TIPO_PERF_PSIC  "); 
      if (maeTipoPerfiPsicoData.getCodTipoPerfPsic()!=null)
          update.append(", COD_TIPO_PERF_PSIC"); 
      update.append(" ) VALUES ( ");    
      update.append(id);
      if (maeTipoPerfiPsicoData.getCodTipoPerfPsic()!=null)
          update.append(", '" + maeTipoPerfiPsicoData.getCodTipoPerfPsic() + "'");    
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
          updateInter.append(" 'MAE_TIPO_PERFI_PSICO', ");
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
      
      UtilidadesLog.info("DAOTipoPerfilPsico.guardar(MaeTipoPerfiPsicoData MaeTipoPerfiPsicoData, Vector localizationLabels , HashMap userProperties): Salida");
      return primaryKey;
  }
  
 public Vector query(MaeTipoPerfiPsicoData maeTipoPerfiPsicoFrom, MaeTipoPerfiPsicoData maeTipoPerfiPsicoTo, HashMap userProperties, Integer pageCount, Integer pageSize) throws MareException 
 {

       UtilidadesLog.info("DAOTipoPerfilPsico.query(MaeTipoPerfiPsicoData maeTipoPerfiPsicoFrom, MaeTipoPerfiPsicoData maeTipoPerfiPsicoTo, HashMap userProperties, Integer pageCount, Integer pageSize): Entrada");
        
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

        query.append(" SELECT OID_TIPO_PERF_PSIC , COD_TIPO_PERF_PSIC,  i18n.VAL_I18N ");
        query.append(" FROM MAE_TIPO_PERFI_PSICO, v_gen_i18n_sicc i18n ");
        query.append(" WHERE OID_TIPO_PERF_PSIC  = i18n.val_oid ");
        query.append(" and i18n.ATTR_ENTI = 'MAE_TIPO_PERFI_PSICO' ");
        query.append(" and i18n.ATTR_NUM_ATRI = 1 ");
        query.append(" and i18n.IDIO_OID_IDIO = " + (String)idioma.getValue());
        
        // Para la busqueda
        if(maeTipoPerfiPsicoFrom.getCodTipoPerfPsic()!= null){
            query.append(" and COD_TIPO_PERF_PSIC like '" + maeTipoPerfiPsicoFrom.getCodTipoPerfPsic() + "' ");
        }
        
        if(maeTipoPerfiPsicoFrom.getDescripcion()!= null){
            query.append(" and i18n.val_i18n like '" + maeTipoPerfiPsicoFrom.getDescripcion() + "' ");
        }
        
        // Para el detalle
        if(maeTipoPerfiPsicoFrom.getId()!= null){
            query.append(" and OID_TIPO_PERF_PSIC  = " + maeTipoPerfiPsicoFrom.getId());
        }

        try {
           rs = bs.dbService.executeStaticQuery(query.toString());
        } catch (Exception ex) {
          UtilidadesLog.error("ERROR ", ex);
          throw new MareException(ex, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS));
        }
        
        
        int cant = rs.getRowCount();
        Vector result = new Vector();
        
        MaeTipoPerfiPsicoData maeTipoPerfiPsicoData = null;
        
        
        int rsSaltar = (pageCount.intValue() - 1) * pageSize.intValue();
        int rsMostrar = ((pageSize.intValue() == Integer.MAX_VALUE) ? pageSize.intValue() : (pageSize.intValue() + 1)) + rsSaltar;
        
        UtilidadesLog.debug("rsSaltar: " + rsSaltar);
        UtilidadesLog.debug("rsMostrar: " + rsMostrar);
        
        for(int i=0; i < cant; i++){
        
            if(i < rsSaltar ) {
                continue;
            }
            
            if(i < rsMostrar){
                maeTipoPerfiPsicoData = new MaeTipoPerfiPsicoData();
                
                maeTipoPerfiPsicoData.setId(Long.valueOf(((BigDecimal)rs.getValueAt(i,"OID_TIPO_PERF_PSIC")).toString()));
                maeTipoPerfiPsicoData.setCodTipoPerfPsic((String)rs.getValueAt(i,"COD_TIPO_PERF_PSIC"));  
                maeTipoPerfiPsicoData.setDescripcion((String)rs.getValueAt(i,"VAL_I18N"));  
                
                result.add(maeTipoPerfiPsicoData);
                
            } else {
               break;
            }
        }
        
        UtilidadesLog.debug("result: " + result);
       
        UtilidadesLog.info("DAOTipoPerfilPsico.query(MaeTipoPerfiPsicoData maeTipoPerfiPsicoFrom, MaeTipoPerfiPsicoData maeTipoPerfiPsicoTo, HashMap userProperties, Integer pageCount, Integer pageSize): Salida");
        return result;
   
 }
 public void remove(Vector maeTipoPerfiPsico ) throws MareException
 {
   
    UtilidadesLog.info("DAOTipoPerfilPsico.remove(Vector maeTipoPerfiPsico): Entrada");
        RecordSet rs = null;
        BelcorpService bs = UtilidadesEJB.getBelcorpService();
        StringBuffer update = new StringBuffer();
        StringBuffer updateInter = new StringBuffer();
        
        int cant = maeTipoPerfiPsico.size();
        MaeTipoPerfiPsicoData maeTipoPerfiPsicoData = null;
        String oids = "";
        
        for (int j = 0; j < cant; j++) {
            maeTipoPerfiPsicoData = (MaeTipoPerfiPsicoData)maeTipoPerfiPsico.get(j);
             
            oids = oids + "," + maeTipoPerfiPsicoData.getId();
        }
        
        update.append("delete MAE_TIPO_PERFI_PSICO ");
        update.append("where OID_TIPO_PERF_PSIC  in ( " + oids.substring(1) + ") ");
        
        updateInter.append("delete GEN_I18N_SICC_COMUN ");
        updateInter.append(" where VAL_OID in ( " + oids.substring(1) + ") ");
        updateInter.append(" and ATTR_NUM_ATRI = 1 ");
        updateInter.append(" and ATTR_ENTI = 'MAE_TIPO_PERFI_PSICO' ");
        
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
        
        UtilidadesLog.info("DAOTipoPerfilPsico.remove(Vector maeTipoPerfiPsico): Salida");
   
 }
 
 public void update(MaeTipoPerfiPsicoData maeTipoPerfiPsicoData, Vector localizationLabels) throws MareException 
 {
   
        UtilidadesLog.info("DAOTipoPerfilPsico.update(MaeTipoPerfiPsicoData MaeTipoPerfiPsicoData, Vector localizationLabels): Entrada");
       
        RecordSet rs = null;
        BelcorpService bs = UtilidadesEJB.getBelcorpService();
        StringBuffer update = new StringBuffer();
        
        update.append("UPDATE MAE_TIPO_PERFI_PSICO SET ");
        update.append(" COD_TIPO_PERF_PSIC = '" + maeTipoPerfiPsicoData.getCodTipoPerfPsic()+"' ");
        
        update.append(" WHERE OID_TIPO_PERF_PSIC  = " + maeTipoPerfiPsicoData.getId());   
        
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
            updateInter.append(" where VAL_OID in ( " + maeTipoPerfiPsicoData.getId() + ") ");
            updateInter.append(" and ATTR_NUM_ATRI = 1 ");
            updateInter.append(" and ATTR_ENTI = 'MAE_TIPO_PERFI_PSICO' ");
            
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
              updateInter.append(" 'MAE_TIPO_PERFI_PSICO', ");
              updateInter.append(" 1, ");            
              updateInter.append(genDetaSiccData.getIdioOidIdio().getId() + ", ");
              updateInter.append(" '" + genDetaSiccData.getDeta() + "', ");
              updateInter.append(maeTipoPerfiPsicoData.getId() + " )");
              int cantReginsertados = bs.dbService.executeUpdate(updateInter.toString());
            }

        } catch (Exception ex) {
            ex.printStackTrace();
            throw new MareException(ex, UtilidadesError.armarCodigoError(
                                    CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS));
        }
        
        
        UtilidadesLog.info("DAOTipoPerfilPsico.update(MaeTipoPerfiPsicoData MaeTipoPerfiPsicoData, Vector localizationLabels): Salida");
 }

  
}