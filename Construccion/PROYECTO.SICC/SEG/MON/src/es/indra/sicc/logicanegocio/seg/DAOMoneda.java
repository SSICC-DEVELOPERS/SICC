package es.indra.sicc.logicanegocio.seg;

import es.indra.belcorp.mso.SegMonedData;
import es.indra.mare.common.mgu.manager.Property;
import es.indra.mare.common.mii.MareMiiServiceNotFoundException;
import es.indra.mare.common.mii.services.jdbcservice.RecordSet;
import es.indra.sicc.util.BelcorpService;
import es.indra.sicc.util.CodigosError;
import es.indra.sicc.util.UtilidadesEJB;
import es.indra.sicc.util.UtilidadesError;
import es.indra.sicc.util.UtilidadesLog;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Vector;
import es.indra.mare.common.exception.MareException;
import es.indra.belcorp.mso.GenDetaSiccData;
import java.util.Hashtable;

public class DAOMoneda 
{
    public DAOMoneda()
    {
    }
    
    public Hashtable guardar(SegMonedData segMoned, Vector localizationLabels, HashMap userProperties) throws MareException
    {
        UtilidadesLog.info("DAOMoneda.guardar(SegMonedData segMoned, Vector localizationLabels, HashMap userProperties): Entrada");
        RecordSet rs = null;
        BelcorpService bs = UtilidadesEJB.getBelcorpService();
        
        StringBuffer update = new StringBuffer();        
        RecordSet rsPK = null;
        StringBuffer query = new StringBuffer();      
        Long id = null;
        
        query.append(" SELECT SEG_MONE_SEQ.NEXTVAL FROM DUAL");         
        
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
        
        update.append(" INSERT INTO SEG_MONED ( ");
        update.append("OID_MONE, "); 
        update.append("COD_MONE, "); 
        update.append("NUM_DECI, "); 
        update.append("VAL_SIMB_MONE, "); 
        update.append("VAL_NOMB_CORT_MONE "); 
  
        update.append(" ) VALUES ( ");
        update.append(id + ", ");
        update.append(" '" + segMoned.getCodMone() + "', ");
        update.append(segMoned.getNumDeci());
        
        if (segMoned.getValSimbMone() != null) {
            update.append(", '" + segMoned.getValSimbMone() + "' ");
        } else {
            update.append(", NULL ");
        }
        
        if (segMoned.getValNombCortMone() != null) {
            update.append(", '" + segMoned.getValNombCortMone() + "' ");
        } else {
            update.append(", NULL ");
        }
                
        update.append(" ) ");
        
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
        StringBuffer queryInter = null;
        Long idInter = null;        
        StringBuffer updateInter = null;
        
        for(int i= 0; i< cant; i++){
                      
            queryInter = new StringBuffer();             
            queryInter.append(" SELECT GEN_i18n_SEQ.NEXTVAL FROM DUAL");         
            
            try {
                rsPKInter = bs.dbService.executeStaticQuery(queryInter.toString());
                    
            } catch (Exception ex) {
                ex.printStackTrace();
                throw new MareException(ex, UtilidadesError.armarCodigoError(
                                        CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS));
            }
            
            if(rsPKInter != null && !rsPKInter.esVacio()) {
                idInter = Long.valueOf(((BigDecimal)rsPKInter.getValueAt(0,0)).toString());
            }      
            
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
            updateInter.append(idInter + ", ");
            updateInter.append(" 'SEG_MONED', ");
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
    
        UtilidadesLog.info("DAOMoneda.guardar(SegMonedData segMoned, Vector localizationLabels, HashMap userProperties): Salida");
        return primaryKey;
    }
    
    public void remove(Vector segMonedFrom) throws MareException
    {
        UtilidadesLog.info("DAOMoneda.remove(Vector segMonedFrom): Entrada");
        RecordSet rs = null;
        BelcorpService bs = UtilidadesEJB.getBelcorpService();
        StringBuffer update = new StringBuffer();
        StringBuffer updateInter = new StringBuffer();
        
        int cant = segMonedFrom.size();
        SegMonedData segMonedData = null;
        String oids = "";
        
        for (int j = 0; j < cant; j++) {
            segMonedData = (SegMonedData)segMonedFrom.get(j);
             
            oids = oids + "," + segMonedData.getId();
        }
        
        update.append("delete SEG_MONED ");
        update.append("where OID_MONE in ( " + oids.substring(1) + ") ");
        
        updateInter.append("delete GEN_I18N_SICC_COMUN ");
        updateInter.append(" where VAL_OID in ( " + oids.substring(1) + ") ");
        updateInter.append(" and ATTR_NUM_ATRI = 1 ");
        updateInter.append(" and ATTR_ENTI = 'SEG_MONED' ");
        
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
        
        UtilidadesLog.info("DAOMoneda.remove(Vector segMonedFrom): Salida");
    }
    
    public Vector query(SegMonedData segMonedFrom, SegMonedData segMonedTo, HashMap userProperties, Integer pageCount, Integer pageSize) throws MareException
    {
        UtilidadesLog.info("DAOMoneda.query(SegMonedData segMonedFrom, SegMonedData segMonedTo, HashMap userProperties, Integer pageCount, Integer pageSize): Entrada");
        
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

        query.append(" SELECT OID_MONE, COD_MONE, NUM_DECI, ");
        query.append(" VAL_SIMB_MONE, VAL_NOMB_CORT_MONE, i18n.VAL_I18N ");
        query.append(" FROM SEG_MONED, v_gen_i18n_sicc i18n ");
        query.append(" WHERE OID_MONE = i18n.val_oid ");
        query.append(" and i18n.ATTR_ENTI = 'SEG_MONED' ");
        query.append(" and i18n.ATTR_NUM_ATRI = 1 ");
        query.append(" and i18n.IDIO_OID_IDIO = " + (String)idioma.getValue());
        
        // Para la busqueda
        if(segMonedFrom.getCodMone()!= null){
            query.append(" and COD_MONE like '" + segMonedFrom.getCodMone() + "' ");
        }
        
        if(segMonedFrom.getDescripcion()!= null){
            query.append(" and i18n.val_i18n like '" + segMonedFrom.getDescripcion() + "' ");
        }
        
        // Para el detalle
        if(segMonedFrom.getId()!= null){
            query.append(" and OID_MONE = " + segMonedFrom.getId());
        }

        try {
           rs = bs.dbService.executeStaticQuery(query.toString());
        } catch (Exception ex) {
          UtilidadesLog.error("ERROR ", ex);
          throw new MareException(ex, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS));
        }
        
        
        int cant = rs.getRowCount();
        Vector result = new Vector();
        
        SegMonedData segMonedData = null;
        
        int rsSaltar = (pageCount.intValue() - 1) * pageSize.intValue();
        int rsMostrar = ((pageSize.intValue() == Integer.MAX_VALUE) ? pageSize.intValue() : (pageSize.intValue() + 1)) + rsSaltar;
        
        UtilidadesLog.debug("rsSaltar: " + rsSaltar);
        UtilidadesLog.debug("rsMostrar: " + rsMostrar);
        
        for(int i=0; i < cant; i++){
        
            if(i < rsSaltar ) {
                continue;
            }
            
            if(i < rsMostrar){
                segMonedData = new SegMonedData();
                
                segMonedData.setId(Long.valueOf(((BigDecimal)rs.getValueAt(i,"OID_MONE")).toString()));
                segMonedData.setCodMone((String)rs.getValueAt(i,"COD_MONE"));  
                segMonedData.setNumDeci(Long.valueOf(((BigDecimal)rs.getValueAt(i,"NUM_DECI")).toString()));
                segMonedData.setDescripcion((String)rs.getValueAt(i,"VAL_I18N"));  
                
                if((String)rs.getValueAt(i,"VAL_SIMB_MONE")!= null){
                    segMonedData.setValSimbMone((String)rs.getValueAt(i,"VAL_SIMB_MONE"));    
                }
                
                if((String)rs.getValueAt(i,"VAL_NOMB_CORT_MONE")!= null){
                    segMonedData.setValNombCortMone((String)rs.getValueAt(i,"VAL_NOMB_CORT_MONE"));    
                }   
                
                result.add(segMonedData);
                
            } else {
               break;
            }
        }
        
        UtilidadesLog.debug("result: " + result);
       
        UtilidadesLog.info("DAOMoneda.query(SegMonedData segMonedFrom, SegMonedData segMonedTo, HashMap userProperties, Integer pageCount, Integer pageSize): Salida");
        return result;
    }
    
    public void update(SegMonedData segMoned, Vector localizationLabels) throws MareException
    {
        UtilidadesLog.info("DAOMoneda.update(SegMonedData segMoned, Vector localizationLabels): Entrada");
       
        RecordSet rs = null;
        BelcorpService bs = UtilidadesEJB.getBelcorpService();
        StringBuffer update = new StringBuffer();
        
        update.append("UPDATE SEG_MONED SET ");
        update.append(" NUM_DECI = " + segMoned.getNumDeci());
        
        if (segMoned.getValSimbMone() != null) {
            update.append(", VAL_SIMB_MONE = '" + segMoned.getValSimbMone() + "' ");
        } else {
            update.append(", VAL_SIMB_MONE = NULL ");
        }
        
        if (segMoned.getValNombCortMone() != null) {
            update.append(", VAL_NOMB_CORT_MONE = '" + segMoned.getValNombCortMone() + "' ");
        } else {
            update.append(", VAL_NOMB_CORT_MONE = NULL ");
        }
        
        update.append(" WHERE OID_MONE = " + segMoned.getId());   
        
        try {
            int cantRegActualizados = bs.dbService.executeUpdate(update.toString());
        } catch (Exception ex) {
            ex.printStackTrace();
            throw new MareException(ex, UtilidadesError.armarCodigoError(
                                    CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS));
        }
                
        // Borrar los registros internalizacion
        StringBuffer deleteInter = new StringBuffer();
        
        deleteInter.append("delete GEN_I18N_SICC_COMUN ");
        deleteInter.append(" where VAL_OID = " + segMoned.getId());
        deleteInter.append(" and ATTR_NUM_ATRI = 1 ");
        deleteInter.append(" and ATTR_ENTI = 'SEG_MONED' ");
        
        try {
            int cantRegActualizados1 = bs.dbService.executeUpdate(deleteInter.toString());
            
        } catch (Exception ex) {
            ex.printStackTrace();            
           
            throw new MareException(ex, UtilidadesError.armarCodigoError(
                                CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS));           
        }
        
        
        int cant = localizationLabels.size();
        GenDetaSiccData genDetaSiccData = null;
        RecordSet rsPKInter = null;
        StringBuffer queryInter = null;
        Long idInter = null;      
        StringBuffer updateInter = null;
        
        for(int i= 0; i< cant; i++){                      
           
            genDetaSiccData = (GenDetaSiccData)localizationLabels.get(i);
        
            queryInter = new StringBuffer();             
            queryInter.append(" SELECT GEN_i18n_SEQ.NEXTVAL FROM DUAL");         
            
            try {
                rsPKInter = bs.dbService.executeStaticQuery(queryInter.toString());
                    
            } catch (Exception ex) {
                ex.printStackTrace();
                throw new MareException(ex, UtilidadesError.armarCodigoError(
                                        CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS));
            }
            
            if(rsPKInter != null && !rsPKInter.esVacio()) {
                idInter = Long.valueOf(((BigDecimal)rsPKInter.getValueAt(0,0)).toString());
            }      
            
            updateInter = new StringBuffer();    
                
            updateInter.append(" INSERT INTO GEN_I18N_SICC_COMUN ( ");
            updateInter.append("OID_I18N, "); 
            updateInter.append("ATTR_ENTI, "); 
            updateInter.append("ATTR_NUM_ATRI, "); 
            updateInter.append("IDIO_OID_IDIO, "); 
            updateInter.append("VAL_I18N, ");                 
            updateInter.append("VAL_OID "); 
            updateInter.append(" ) VALUES ( ");
            updateInter.append(idInter + ", ");
            updateInter.append(" 'SEG_MONED', ");
            updateInter.append(" 1, ");            
            updateInter.append(genDetaSiccData.getIdioOidIdio().getId() + ", ");
            updateInter.append(" '" + genDetaSiccData.getDeta() + "', ");
            updateInter.append(segMoned.getId() + " )");   
        
            try {
                int cantRegActualizados = bs.dbService.executeUpdate(updateInter.toString());
            } catch (Exception ex) {
                ex.printStackTrace();
                throw new MareException(ex, UtilidadesError.armarCodigoError(
                                        CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS));
            }
        }
               
        UtilidadesLog.info("DAOMoneda.update(SegMonedData segMoned, Vector localizationLabels): Salida");
    }
    
    public Vector query(SegMonedData SegMonedFrom, SegMonedData SegMonedTo, HashMap userProperties) throws MareException
    {
      UtilidadesLog.info("DAOMoneda.query(SegMonedData SegMonedFrom, SegMonedData SegMonedTo, HashMap userProperties): Entrada");
      
      RecordSet rs = new RecordSet();
      StringBuffer query = new StringBuffer();
      BelcorpService bs;
      Vector resultado = new Vector();

      try {
          bs = BelcorpService.getInstance();
      } catch (MareMiiServiceNotFoundException e) {
          UtilidadesLog.error("ERROR ", e);
          throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_PEDIR_UN_SERVICIO_MARE));
      }

      Property idioma = (Property)userProperties.get("Idioma");

      query.append(" SELECT OID_MONE, COD_MONE, NUM_DECI, ");
      query.append(" VAL_SIMB_MONE, VAL_NOMB_CORT_MONE, i18n.VAL_I18N ");
      query.append(" FROM SEG_MONED, v_gen_i18n_sicc i18n ");
      query.append(" WHERE OID_MONE = i18n.val_oid ");
      query.append(" and i18n.ATTR_ENTI = 'SEG_MONED' ");
      query.append(" and i18n.ATTR_NUM_ATRI = 1 ");
      query.append(" and i18n.IDIO_OID_IDIO = " + (String)idioma.getValue());
      query.append(" ORDER BY i18n.VAL_I18N " ); 

      try {
          rs = bs.dbService.executeStaticQuery(query.toString());
      } catch (Exception ex) {
          UtilidadesLog.error("ERROR ", ex);
          throw new MareException(ex, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS));
      }
      
      int cant = rs.getRowCount();
      
      SegMonedData segMonedData = null;
      
      for(int i=0; i < cant; i++){
          segMonedData = new SegMonedData();
                
          segMonedData.setId(Long.valueOf(((BigDecimal)rs.getValueAt(i,"OID_MONE")).toString()));
          segMonedData.setCodMone((String)rs.getValueAt(i,"COD_MONE"));  
          segMonedData.setNumDeci(Long.valueOf(((BigDecimal)rs.getValueAt(i,"NUM_DECI")).toString()));
          segMonedData.setDescripcion((String)rs.getValueAt(i,"VAL_I18N"));  
        
          if((String)rs.getValueAt(i,"VAL_SIMB_MONE")!= null){
            segMonedData.setValSimbMone((String)rs.getValueAt(i,"VAL_SIMB_MONE"));    
          }
        
          if((String)rs.getValueAt(i,"VAL_NOMB_CORT_MONE")!= null){
            segMonedData.setValNombCortMone((String)rs.getValueAt(i,"VAL_NOMB_CORT_MONE"));    
          }      
                
          resultado.add(segMonedData);
      }
      
      UtilidadesLog.info("DAOMoneda.query(SegMonedData SegMonedFrom, SegMonedData SegMonedTo, HashMap userProperties): Salida");
      
      return resultado;
    }
}