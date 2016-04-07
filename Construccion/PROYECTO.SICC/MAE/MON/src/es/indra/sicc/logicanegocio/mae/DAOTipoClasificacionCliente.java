package es.indra.sicc.logicanegocio.mae;
import es.indra.belcorp.mso.MaeTipoClasiClienData;
import es.indra.belcorp.mso.MaeSubtiClienData;
import es.indra.belcorp.mso.MaeTipoClienData;
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


public class DAOTipoClasificacionCliente 
{
  public DAOTipoClasificacionCliente()
  {
  }

  public Hashtable insertar(MaeTipoClasiClienData maeTipoClasiClienData, Vector localizationLabels , HashMap userProperties) throws MareException{
  
      UtilidadesLog.info("DAOTipoClasificacionCliente.guardar(MaeTipoClasiClienData maeTipoClasiClienData, Vector localizationLabels , HashMap userProperties): Entrada");
      RecordSet rs = null;
      BelcorpService bs = UtilidadesEJB.getBelcorpService();
      Long id = SecuenciadorOID.obtenerSiguienteValor("MAE_TCCL_SEQ");
      StringBuffer update = new StringBuffer();        
           
      update.append("INSERT INTO MAE_TIPO_CLASI_CLIEN ( ");
      update.append("OID_TIPO_CLAS "); 
      if (maeTipoClasiClienData.getSbtiOidSubtClie()!=null)
          update.append(", SBTI_OID_SUBT_CLIE"); 
      if (maeTipoClasiClienData.getCodTipoClas()!=null)
          update.append(", COD_TIPO_CLAS"); 
      update.append(" ) VALUES ( ");    
      update.append(id);
      if (maeTipoClasiClienData.getSbtiOidSubtClie()!=null)
          update.append("," + maeTipoClasiClienData.getSbtiOidSubtClie().getId()); 
      if (maeTipoClasiClienData.getCodTipoClas()!=null)
          update.append(", '" + maeTipoClasiClienData.getCodTipoClas() + "'");    
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
          updateInter.append(" 'MAE_TIPO_CLASI_CLIEN', ");
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
      
      UtilidadesLog.info("DAOTipoClasificacionCliente.guardar(MaeTipoClasiClienData maeTipoClasiClienData, Vector localizationLabels , HashMap userProperties): Salida");
      return primaryKey;
  }
  
 public Vector query(MaeTipoClasiClienData maeTipoClasiClienFrom, MaeTipoClasiClienData maeTipoClasiClienTo, HashMap userProperties, Integer pageCount, Integer pageSize) throws MareException 
 {

       UtilidadesLog.info("DAOTipoClasificacionCliente.query(MaeTipoClasiClienData maeTipoClasiClienFrom, MaeTipoClasiClienData maeTipoClasiClienTo, HashMap userProperties, Integer pageCount, Integer pageSize): Entrada");
        
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

        query.append(" SELECT OID_TIPO_CLAS, COD_TIPO_CLAS, SBTI_OID_SUBT_CLIE, i18n.VAL_I18N, ");
        query.append("       PQ_APL_AUX.VALOR_GEN_I18N_SICC("+idioma.getValue().toString() +",SBTI_OID_SUBT_CLIE,'MAE_SUBTI_CLIEN')");
        query.append("       DESC_SUBTI, MAE_SUBTI_CLIEN.COD_SUBT_CLIE , MAE_SUBTI_CLIEN.TICL_OID_TIPO_CLIE, COD_TIPO_CLIE ,");
        query.append("       PQ_APL_AUX.VALOR_GEN_I18N_SICC("+idioma.getValue().toString() +",OID_TIPO_CLIE,'MAE_TIPO_CLIEN') DESC_TIPO");
        query.append(" FROM MAE_TIPO_CLASI_CLIEN, v_gen_i18n_sicc i18n , MAE_SUBTI_CLIEN, MAE_TIPO_CLIEN ");
        query.append(" WHERE OID_TIPO_CLAS = i18n.val_oid ");
        query.append(" AND MAE_SUBTI_CLIEN.OID_SUBT_CLIE = mae_tipo_clasi_clien.SBTI_OID_SUBT_CLIE ");
        query.append(" and i18n.ATTR_ENTI = 'MAE_TIPO_CLASI_CLIEN' ");
        query.append(" and i18n.ATTR_NUM_ATRI = 1 ");
        query.append(" and i18n.IDIO_OID_IDIO = " + (String)idioma.getValue());
        query.append(" and OID_TIPO_CLIE = TICL_OID_TIPO_CLIE ");
        // Para la busqueda
        if(maeTipoClasiClienFrom.getCodTipoClas()!= null){
            query.append(" and COD_TIPO_CLAS like '" + maeTipoClasiClienFrom.getCodTipoClas() + "' ");
        }
        
        if(maeTipoClasiClienFrom.getDescripcion()!= null){
            query.append(" and i18n.val_i18n like '" + maeTipoClasiClienFrom.getDescripcion() + "' ");
        }
        
        // Para el detalle
        if(maeTipoClasiClienFrom.getId()!= null){
            query.append(" and OID_TIPO_CLAS = " + maeTipoClasiClienFrom.getId());
        }
        
        if(maeTipoClasiClienFrom.getSbtiOidSubtClie()!= null){
            query.append(" and SBTI_OID_SUBT_CLIE = " + maeTipoClasiClienFrom.getSbtiOidSubtClie().getId());
        }

        if(maeTipoClasiClienFrom.getSbtiOidSubtClie()!= null){
          if(maeTipoClasiClienFrom.getSbtiOidSubtClie().getTiclOidTipoClie()!= null){
              query.append(" and TICL_OID_TIPO_CLIE = " + maeTipoClasiClienFrom.getSbtiOidSubtClie().getTiclOidTipoClie().getId());
          } 
        }         
         
        
        
        

        try {
           rs = bs.dbService.executeStaticQuery(query.toString());
        } catch (Exception ex) {
          UtilidadesLog.error("ERROR ", ex);
          throw new MareException(ex, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS));
        }
        
        
        int cant = rs.getRowCount();
        Vector result = new Vector();
        
        MaeTipoClasiClienData maeTipoClasiClienData = null;
        MaeSubtiClienData maeSubtiClienData  = null;
        MaeTipoClienData maeTipoClienData = null;
        
        int rsSaltar = (pageCount.intValue() - 1) * pageSize.intValue();
        int rsMostrar = ((pageSize.intValue() == Integer.MAX_VALUE) ? pageSize.intValue() : (pageSize.intValue() + 1)) + rsSaltar;
        
        UtilidadesLog.debug("rsSaltar: " + rsSaltar);
        UtilidadesLog.debug("rsMostrar: " + rsMostrar);
        
        for(int i=0; i < cant; i++){
        
            if(i < rsSaltar ) {
                continue;
            }
            
            if(i < rsMostrar){
                maeTipoClasiClienData = new MaeTipoClasiClienData();
                maeSubtiClienData = new MaeSubtiClienData();
                maeTipoClienData = new MaeTipoClienData();
                
                maeTipoClienData.setId(Long.valueOf(((BigDecimal)rs.getValueAt(i,"TICL_OID_TIPO_CLIE")).toString()));
                maeTipoClienData.setCodTipoClie((String)rs.getValueAt(i,"COD_TIPO_CLIE"));
                maeTipoClienData.setDescripcion((String)rs.getValueAt(i,"DESC_TIPO"));
                
                maeSubtiClienData.setId(Long.valueOf(((BigDecimal)rs.getValueAt(i,"SBTI_OID_SUBT_CLIE")).toString()));
                maeSubtiClienData.setCodSubtClie((String)rs.getValueAt(i,"COD_SUBT_CLIE"));
                maeSubtiClienData.setDescripcion((String)rs.getValueAt(i,"DESC_SUBTI"));
                maeSubtiClienData.setTiclOidTipoClie(maeTipoClienData);
                
                maeTipoClasiClienData.setId(Long.valueOf(((BigDecimal)rs.getValueAt(i,"OID_TIPO_CLAS")).toString()));
                maeTipoClasiClienData.setCodTipoClas((String)rs.getValueAt(i,"COD_TIPO_CLAS"));  
                maeTipoClasiClienData.setDescripcion((String)rs.getValueAt(i,"VAL_I18N"));  
                maeTipoClasiClienData.setSbtiOidSubtClie(maeSubtiClienData);
                result.add(maeTipoClasiClienData);
                
            } else {
               break;
            }
        }
        
        UtilidadesLog.debug("result: " + result);
       
        UtilidadesLog.info("DAOTipoClasificacionCliente.query(MaeTipoClasiClienData maeTipoClasiClienFrom, MaeTipoClasiClienData maeTipoClasiClienTo, HashMap userProperties, Integer pageCount, Integer pageSize): Salida");
        return result;
   
 }
 public void remove(Vector maeTipoClasiClien ) throws MareException
 {
   
    UtilidadesLog.info("DAOTipoClasificacionCliente.remove(Vector maeTipoClasiClien): Entrada");
        RecordSet rs = null;
        BelcorpService bs = UtilidadesEJB.getBelcorpService();
        StringBuffer update = new StringBuffer();
        StringBuffer updateInter = new StringBuffer();
        
        int cant = maeTipoClasiClien.size();
        MaeTipoClasiClienData maeTipoClasiClienData = null;
        String oids = "";
        
        for (int j = 0; j < cant; j++) {
            maeTipoClasiClienData = (MaeTipoClasiClienData)maeTipoClasiClien.get(j);
             
            oids = oids + "," + maeTipoClasiClienData.getId();
        }
        
        update.append("delete MAE_TIPO_CLASI_CLIEN ");
        update.append("where OID_TIPO_CLAS in ( " + oids.substring(1) + ") ");
        
        updateInter.append("delete GEN_I18N_SICC_COMUN ");
        updateInter.append(" where VAL_OID in ( " + oids.substring(1) + ") ");
        updateInter.append(" and ATTR_NUM_ATRI = 1 ");
        updateInter.append(" and ATTR_ENTI = 'MAE_TIPO_CLASI_CLIEN' ");
        
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
        
        UtilidadesLog.info("DAOTipoClasificacionCliente.remove(Vector maeTipoClasiClien): Salida");
   
 }
 
 public void update(MaeTipoClasiClienData maeTipoClasiClienData, Vector localizationLabels) throws MareException 
 {
   
        UtilidadesLog.info("DAOTipoClasificacionCliente.update(MaeTipoClasiClienData maeTipoClasiClienData, Vector localizationLabels): Entrada");
       
        RecordSet rs = null;
        BelcorpService bs = UtilidadesEJB.getBelcorpService();
        StringBuffer update = new StringBuffer();
        
        update.append("UPDATE MAE_TIPO_CLASI_CLIEN SET ");
        update.append(" COD_TIPO_CLAS = '" + maeTipoClasiClienData.getCodTipoClas()+"' ");
        
        if (maeTipoClasiClienData.getSbtiOidSubtClie() != null) {
            update.append(", SBTI_OID_SUBT_CLIE = " + maeTipoClasiClienData.getSbtiOidSubtClie().getId() );
        } else {
            update.append(", SBTI_OID_SUBT_CLIE = NULL ");
        }
        
        update.append(" WHERE OID_TIPO_CLAS = " + maeTipoClasiClienData.getId());   
        
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
            updateInter.append(" where VAL_OID in ( " + maeTipoClasiClienData.getId() + ") ");
            updateInter.append(" and ATTR_NUM_ATRI = 1 ");
            updateInter.append(" and ATTR_ENTI = 'MAE_TIPO_CLASI_CLIEN' ");
            
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
              updateInter.append(" 'MAE_TIPO_CLASI_CLIEN', ");
              updateInter.append(" 1, ");            
              updateInter.append(genDetaSiccData.getIdioOidIdio().getId() + ", ");
              updateInter.append(" '" + genDetaSiccData.getDeta() + "', ");
              updateInter.append(maeTipoClasiClienData.getId() + " )");
              int cantReginsertados = bs.dbService.executeUpdate(updateInter.toString());
            }

        } catch (Exception ex) {
            ex.printStackTrace();
            throw new MareException(ex, UtilidadesError.armarCodigoError(
                                    CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS));
        }
        
        
        UtilidadesLog.info("DAOTipoClasificacionCliente.update(MaeTipoClasiClienData maeTipoClasiClienData, Vector localizationLabels): Salida");
 }
  
}