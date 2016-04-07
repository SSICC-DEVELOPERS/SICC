package es.indra.sicc.logicanegocio.mae;
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

public class DAOTipoCliente 
{
  public DAOTipoCliente()
  {
  }
/*  
  MAE_TIPO_CLIEN
  OID_TIPO_CLIE 
  COD_TIPO_CLIE 
  IND_EVAL_ESTA 
  IND_EMPL   */
  public Hashtable insertar(MaeTipoClienData maeTipoClienData, Vector localizationLabels , HashMap userProperties) throws MareException{
  
      UtilidadesLog.info("DAOTipoCliente.guardar(MaeTipoClienData MaeTipoClienData, Vector localizationLabels , HashMap userProperties): Entrada");
      RecordSet rs = null;
      BelcorpService bs = UtilidadesEJB.getBelcorpService();
      Long id = SecuenciadorOID.obtenerSiguienteValor("MAE_TICL_SEQ");
      StringBuffer update = new StringBuffer();        
           
      update.append("INSERT INTO MAE_TIPO_CLIEN  ( ");
      update.append("OID_TIPO_CLIE "); 
      if (maeTipoClienData.getIndEvalEsta()!=null)
          update.append(", IND_EVAL_ESTA"); 
      if (maeTipoClienData.getCodTipoClie()!=null)
          update.append(", COD_TIPO_CLIE"); 
      if (maeTipoClienData.getIndEmpl()!=null)
          update.append(", IND_EMPL"); 
      update.append(" ) VALUES ( ");    
      update.append(id);
      if (maeTipoClienData.getIndEvalEsta()!=null)
          update.append("," + maeTipoClienData.getIndEvalEsta());
      if (maeTipoClienData.getCodTipoClie()!=null)
          update.append(", '" + maeTipoClienData.getCodTipoClie() + "'");    
      if (maeTipoClienData.getIndEmpl()!=null)
          update.append("," + maeTipoClienData.getIndEmpl()); 
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
          updateInter.append(" 'MAE_TIPO_CLIEN', ");
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
      
      UtilidadesLog.info("DAOTipoCliente.guardar(MaeTipoClienData MaeTipoClienData, Vector localizationLabels , HashMap userProperties): Salida");
      return primaryKey;
  }
  
 public Vector query(MaeTipoClienData maeTipoClasiClienFrom, MaeTipoClienData maeTipoClasiClienTo, HashMap userProperties, Integer pageCount, Integer pageSize) throws MareException 
 {

       UtilidadesLog.info("DAOTipoCliente.query(MaeTipoClienData maeTipoClasiClienFrom, MaeTipoClienData maeTipoClasiClienTo, HashMap userProperties, Integer pageCount, Integer pageSize): Entrada");
        
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

        query.append(" SELECT OID_TIPO_CLIE, COD_TIPO_CLIE, IND_EVAL_ESTA, IND_EMPL, i18n.VAL_I18N ");
        query.append(" FROM MAE_TIPO_CLIEN , v_gen_i18n_sicc i18n ");
        query.append(" WHERE OID_TIPO_CLIE = i18n.val_oid ");
        query.append(" and i18n.ATTR_ENTI = 'MAE_TIPO_CLIEN' ");
        query.append(" and i18n.ATTR_NUM_ATRI = 1 ");
        query.append(" and i18n.IDIO_OID_IDIO = " + (String)idioma.getValue());
        
        // Para la busqueda
        if(maeTipoClasiClienFrom.getCodTipoClie()!= null){
            query.append(" and COD_TIPO_CLIE like '" + maeTipoClasiClienFrom.getCodTipoClie() + "' ");
        }
        
        if(maeTipoClasiClienFrom.getDescripcion()!= null){
            query.append(" and i18n.val_i18n like '" + maeTipoClasiClienFrom.getDescripcion() + "' ");
        }
        
        // Para el detalle
        if(maeTipoClasiClienFrom.getId()!= null){
            query.append(" and OID_TIPO_CLIE = " + maeTipoClasiClienFrom.getId());
        }

        if(maeTipoClasiClienFrom.getIndEmpl()!= null){
            query.append(" and IND_EMPL = " + maeTipoClasiClienFrom.getIndEmpl());
        }
        
        if(maeTipoClasiClienFrom.getIndEvalEsta()!= null){
            query.append(" and IND_EVAL_ESTA = " + maeTipoClasiClienFrom.getIndEvalEsta());
        }
        
        try {
           rs = bs.dbService.executeStaticQuery(query.toString());
        } catch (Exception ex) {
          UtilidadesLog.error("ERROR ", ex);
          throw new MareException(ex, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS));
        }
        
        
        int cant = rs.getRowCount();
        Vector result = new Vector();
        
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
                maeTipoClienData = new MaeTipoClienData();
                
                maeTipoClienData.setId(Long.valueOf(((BigDecimal)rs.getValueAt(i,"OID_TIPO_CLIE")).toString()));
                maeTipoClienData.setCodTipoClie((String)rs.getValueAt(i,"COD_TIPO_CLIE"));
                maeTipoClienData.setDescripcion((String)rs.getValueAt(i,"VAL_I18N"));
                if(rs.getValueAt(i,"IND_EMPL")!=null){
                  maeTipoClienData.setIndEmpl(Long.valueOf(((BigDecimal)rs.getValueAt(i,"IND_EMPL")).toString()));
                }
                maeTipoClienData.setIndEvalEsta(Long.valueOf(((BigDecimal)rs.getValueAt(i,"IND_EVAL_ESTA")).toString()));
                result.add(maeTipoClienData);
                
            } else {
               break;
            }
        }
        
        UtilidadesLog.debug("result: " + result);
       
        UtilidadesLog.info("DAOTipoCliente.query(MaeTipoClienData maeTipoClasiClienFrom, MaeTipoClienData maeTipoClasiClienTo, HashMap userProperties, Integer pageCount, Integer pageSize): Salida");
        return result;
   
 }
 public void remove(Vector maeTipoClasiClien ) throws MareException
 {
   
    UtilidadesLog.info("DAOTipoCliente.remove(Vector maeTipoClasiClien): Entrada");
        RecordSet rs = null;
        BelcorpService bs = UtilidadesEJB.getBelcorpService();
        StringBuffer update = new StringBuffer();
        StringBuffer updateInter = new StringBuffer();
        
        int cant = maeTipoClasiClien.size();
        MaeTipoClienData maeTipoClienData = null;
        String oids = "";
        
        for (int j = 0; j < cant; j++) {
            maeTipoClienData = (MaeTipoClienData)maeTipoClasiClien.get(j);
             
            oids = oids + "," + maeTipoClienData.getId();
        }
        
        update.append("delete MAE_TIPO_CLIEN  ");
        update.append("where OID_TIPO_CLIE in ( " + oids.substring(1) + ") ");
        
        updateInter.append("delete GEN_I18N_SICC_COMUN ");
        updateInter.append(" where VAL_OID in ( " + oids.substring(1) + ") ");
        updateInter.append(" and ATTR_NUM_ATRI = 1 ");
        updateInter.append(" and ATTR_ENTI = 'MAE_TIPO_CLIEN' ");
        
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
        
        UtilidadesLog.info("DAOTipoCliente.remove(Vector maeTipoClasiClien): Salida");
   
 }
 
 public void update(MaeTipoClienData maeTipoClienData, Vector localizationLabels) throws MareException 
 {
   
        UtilidadesLog.info("DAOTipoCliente.update(MaeTipoClienData MaeTipoClienData, Vector localizationLabels): Entrada");
       
        RecordSet rs = null;
        BelcorpService bs = UtilidadesEJB.getBelcorpService();
        StringBuffer update = new StringBuffer();
        
        update.append("UPDATE MAE_TIPO_CLIEN  SET ");
        update.append(" COD_TIPO_CLIE = '" + maeTipoClienData.getCodTipoClie()+"' ");
        
        if (maeTipoClienData.getIndEvalEsta() != null) {
            update.append(", IND_EVAL_ESTA = " + maeTipoClienData.getIndEvalEsta());
        } else {
            update.append(", IND_EVAL_ESTA = NULL ");
        }
        if (maeTipoClienData.getIndEmpl() != null) {
            update.append(", IND_EMPL = " + maeTipoClienData.getIndEmpl());
        } else {
            update.append(", IND_EMPL = NULL ");
        }
        
        update.append(" WHERE OID_TIPO_CLIE = " + maeTipoClienData.getId());   
        
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
            updateInter.append(" where VAL_OID in ( " + maeTipoClienData.getId() + ") ");
            updateInter.append(" and ATTR_NUM_ATRI = 1 ");
            updateInter.append(" and ATTR_ENTI = 'MAE_TIPO_CLIEN' ");
            
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
              updateInter.append(" 'MAE_TIPO_CLIEN', ");
              updateInter.append(" 1, ");            
              updateInter.append(genDetaSiccData.getIdioOidIdio().getId() + ", ");
              updateInter.append(" '" + genDetaSiccData.getDeta() + "', ");
              updateInter.append(maeTipoClienData.getId() + " )");
              int cantReginsertados = bs.dbService.executeUpdate(updateInter.toString());
            }

        } catch (Exception ex) {
            ex.printStackTrace();
            throw new MareException(ex, UtilidadesError.armarCodigoError(
                                    CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS));
        }
        
        
        UtilidadesLog.info("DAOTipoCliente.update(MaeTipoClienData MaeTipoClienData, Vector localizationLabels): Salida");
 }


}