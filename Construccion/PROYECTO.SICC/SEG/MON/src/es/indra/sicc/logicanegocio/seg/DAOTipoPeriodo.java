package es.indra.sicc.logicanegocio.seg;

import es.indra.belcorp.mso.SegTipoPerioData;
import java.util.Vector;
import java.util.HashMap;
import java.util.Hashtable;
import es.indra.mare.common.exception.MareException;
import es.indra.belcorp.mso.GenDetaSiccData;
import es.indra.mare.common.mgu.manager.Property;
import es.indra.mare.common.mii.MareMiiServiceNotFoundException;
import es.indra.mare.common.mii.services.jdbcservice.RecordSet;
import es.indra.sicc.util.BelcorpService;
import es.indra.sicc.util.CodigosError;
import es.indra.sicc.util.UtilidadesEJB;
import es.indra.sicc.util.UtilidadesError;
import es.indra.sicc.util.UtilidadesLog;
import java.math.BigDecimal;

public class DAOTipoPeriodo 
{
    public DAOTipoPeriodo()
    {
    }
    
    public Hashtable guardar(SegTipoPerioData segTipoPerio, Vector localizationLabels, HashMap userProperties) throws MareException
    {
        UtilidadesLog.info("DAOTipoPeriodo.guardar(SegTipoPerioData segTipoPeri, Vector localizationLabels, HashMap userProperties): Entrada");
        RecordSet rs = null;
        BelcorpService bs = UtilidadesEJB.getBelcorpService();
        
        StringBuffer update = new StringBuffer();        
        RecordSet rsPK = null;
        StringBuffer query = new StringBuffer();      
        Long id = null;
        
        query.append(" SELECT SEG_TIPE_SEQ.NEXTVAL FROM DUAL");         
        
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
        
        update.append(" INSERT INTO SEG_TIPO_PERIO ( ");
        update.append("OID_TIPO_PERI, "); 
        update.append("COD_TIPO_PERI, "); 
        update.append("NUM_DIAS, "); 
        update.append("NUM_PERI_ANIO "); 
  
        update.append(" ) VALUES ( ");
        update.append(id + ", ");
        update.append(" '" + segTipoPerio.getCodTipoPeri() + "', ");
        update.append(segTipoPerio.getNumDias() + ", ");
        update.append(segTipoPerio.getNumPeriAnio());
        
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
            updateInter.append(" 'SEG_TIPO_PERIO', ");
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
    
        UtilidadesLog.info("DAOTipoPeriodo.guardar(SegTipoPerioData segTipoPeri, Vector localizationLabels, HashMap userProperties): Salida");
        return primaryKey;
    }
    
    public void remove(Vector segTipoPerioFrom) throws MareException
    {
        UtilidadesLog.info("DAOTipoPeriodo.remove(Vector segTipoPerioFrom): Entrada");
        RecordSet rs = null;
        BelcorpService bs = UtilidadesEJB.getBelcorpService();
        StringBuffer update = new StringBuffer();
        StringBuffer updateInter = new StringBuffer();
        
        int cant = segTipoPerioFrom.size();
        SegTipoPerioData segTipoPerioData = null;
        String oids = "";
        
        for (int j = 0; j < cant; j++) {
            segTipoPerioData = (SegTipoPerioData)segTipoPerioFrom.get(j);
             
            oids = oids + "," + segTipoPerioData.getId();
        }
        
        update.append("delete SEG_TIPO_PERIO ");
        update.append("where OID_TIPO_PERI in ( " + oids.substring(1) + ") ");
        
        updateInter.append("delete GEN_I18N_SICC_COMUN ");
        updateInter.append(" where VAL_OID in ( " + oids.substring(1) + ") ");
        updateInter.append(" and ATTR_NUM_ATRI = 1 ");
        updateInter.append(" and ATTR_ENTI = 'SEG_TIPO_PERIO' ");
        
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
        
        UtilidadesLog.info("DAOTipoPeriodo.remove(Vector segTipoPerioFrom): Salida");
    }
    
    public Vector query(SegTipoPerioData segTipoPerioFrom, SegTipoPerioData segTipoPerioTo, HashMap userProperties, Integer pageCount, Integer pageSize) throws MareException
    {
        UtilidadesLog.info("DAOTipoPeriodo.query(SegTipoPerioData segTipoPerioFrom, SegTipoPerioData segTipoPerioTo, HashMap userProperties, Integer pageCount, Integer pageSize): Entrada");
        
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

        query.append(" SELECT OID_TIPO_PERI, COD_TIPO_PERI, ");
        query.append(" NUM_DIAS, NUM_PERI_ANIO, i18n.val_i18n  ");
        query.append(" FROM SEG_TIPO_PERIO, v_gen_i18n_sicc i18n ");
        query.append(" WHERE OID_TIPO_PERI = i18n.val_oid ");
        query.append(" and i18n.ATTR_ENTI = 'SEG_TIPO_PERIO' ");
        query.append(" and i18n.ATTR_NUM_ATRI = 1 ");
        query.append(" and i18n.IDIO_OID_IDIO = " + (String)idioma.getValue());
        
        
        // Para la busqueda
        if(segTipoPerioFrom.getCodTipoPeri()!= null){
            query.append(" and COD_TIPO_PERI like '" + segTipoPerioFrom.getCodTipoPeri() + "' ");
        }
        
        if(segTipoPerioFrom.getDescripcion()!= null){
            query.append(" and i18n.val_i18n like '" + segTipoPerioFrom.getDescripcion() + "' ");
        }
        
        // Para el detalle
        if(segTipoPerioFrom.getId()!= null){
            query.append(" and OID_TIPO_PERI = " + segTipoPerioFrom.getId());
        }

        try {
           rs = bs.dbService.executeStaticQuery(query.toString());
        } catch (Exception ex) {
          UtilidadesLog.error("ERROR ", ex);
          throw new MareException(ex, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS));
        }
        
        
        int cant = rs.getRowCount();
        Vector result = new Vector();
        
        SegTipoPerioData segTipoPerioData = null;
        
        int rsSaltar = (pageCount.intValue() - 1) * pageSize.intValue();
        int rsMostrar = ((pageSize.intValue() == Integer.MAX_VALUE) ? pageSize.intValue() : (pageSize.intValue() + 1)) + rsSaltar;
        
        UtilidadesLog.debug("rsSaltar: " + rsSaltar);
        UtilidadesLog.debug("rsMostrar: " + rsMostrar);
        
        for(int i=0; i < cant; i++){
        
            if(i < rsSaltar ) {
                continue;
            }
            
            if(i < rsMostrar){
                segTipoPerioData = new SegTipoPerioData();
                
                segTipoPerioData.setId(Long.valueOf(((BigDecimal)rs.getValueAt(i,"OID_TIPO_PERI")).toString()));
                segTipoPerioData.setCodTipoPeri((String)rs.getValueAt(i,"COD_TIPO_PERI"));  
                segTipoPerioData.setNumDias(Long.valueOf(((BigDecimal)rs.getValueAt(i,"NUM_DIAS")).toString()));
                segTipoPerioData.setNumPeriAnio(Long.valueOf(((BigDecimal)rs.getValueAt(i,"NUM_PERI_ANIO")).toString()));
                segTipoPerioData.setDescripcion((String)rs.getValueAt(i,"VAL_I18N"));                
                
                result.add(segTipoPerioData);
                
            } else {
               break;
            }
        }
        
        UtilidadesLog.debug("result: " + result);
       
        UtilidadesLog.info("DAOTipoPeriodo.query(SegTipoPerioData segTipoPerioFrom, SegTipoPerioData segTipoPerioTo, HashMap userProperties, Integer pageCount, Integer pageSize): Salida");
        return result;
    }
    
    public void update(SegTipoPerioData segTipoPerio, Vector localizationLabels) throws MareException
    {
        UtilidadesLog.info("DAOTipoPeriodo.update(egTipoPerioData segTipoPerio, Vector localizationLabels): Entrada");
       
        RecordSet rs = null;
        BelcorpService bs = UtilidadesEJB.getBelcorpService();
        StringBuffer update = new StringBuffer();
        
        update.append("UPDATE SEG_TIPO_PERIO SET ");
        update.append(" NUM_DIAS = " + segTipoPerio.getNumDias() + ", ");
        update.append(" NUM_PERI_ANIO = " + segTipoPerio.getNumPeriAnio());
        update.append(" WHERE OID_TIPO_PERI = " + segTipoPerio.getId());   
        
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
        deleteInter.append(" where VAL_OID = " + segTipoPerio.getId());
        deleteInter.append(" and ATTR_NUM_ATRI = 1 ");
        deleteInter.append(" and ATTR_ENTI = 'SEG_TIPO_PERIO' ");
        
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
            updateInter.append(" 'SEG_TIPO_PERIO', ");
            updateInter.append(" 1, ");            
            updateInter.append(genDetaSiccData.getIdioOidIdio().getId() + ", ");
            updateInter.append(" '" + genDetaSiccData.getDeta() + "', ");
            updateInter.append(segTipoPerio.getId() + " )");   
        
            try {
                int cantRegActualizados = bs.dbService.executeUpdate(updateInter.toString());
            } catch (Exception ex) {
                ex.printStackTrace();
                throw new MareException(ex, UtilidadesError.armarCodigoError(
                                        CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS));
            }
        }
               
        UtilidadesLog.info("DAOTipoPeriodo.update(egTipoPerioData segTipoPerio, Vector localizationLabels): Salida");
    }
    
    public Vector query(SegTipoPerioData segTipoPerioFrom, SegTipoPerioData segTipoPerioTo, HashMap userProperties) throws MareException
    {
      UtilidadesLog.info("DAOTipoPeriodo.query(SegTipoPerioData segTipoPerioFrom, SegTipoPerioData segTipoPerioTo, HashMap userProperties): Entrada");
      
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

      query.append(" SELECT OID_TIPO_PERI, COD_TIPO_PERI, ");
      query.append(" NUM_DIAS, NUM_PERI_ANIO, i18n.val_i18n  ");
      query.append(" FROM SEG_TIPO_PERIO, v_gen_i18n_sicc i18n ");
      query.append(" WHERE OID_TIPO_PERI = i18n.val_oid ");
      query.append(" and i18n.ATTR_ENTI = 'SEG_TIPO_PERIO' ");
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
      
      SegTipoPerioData segTipoPerioData = null;
      
      for(int i=0; i < cant; i++){
          segTipoPerioData = new SegTipoPerioData();
                
          segTipoPerioData.setId(Long.valueOf(((BigDecimal)rs.getValueAt(i,"OID_TIPO_PERI")).toString()));
          segTipoPerioData.setCodTipoPeri((String)rs.getValueAt(i,"COD_TIPO_PERI"));  
          segTipoPerioData.setNumDias(Long.valueOf(((BigDecimal)rs.getValueAt(i,"NUM_DIAS")).toString()));
          segTipoPerioData.setNumPeriAnio(Long.valueOf(((BigDecimal)rs.getValueAt(i,"NUM_PERI_ANIO")).toString()));
          segTipoPerioData.setDescripcion((String)rs.getValueAt(i,"VAL_I18N"));                
                
          resultado.add(segTipoPerioData);
      }
      
      UtilidadesLog.info("DAOTipoPeriodo.query(SegTipoPerioData segTipoPerioFrom, SegTipoPerioData segTipoPerioTo, HashMap userProperties): Salida");
      
      return resultado;
    }
    
    public Vector query(SegTipoPerioData segTipoPerioFrom, SegTipoPerioData segTipoPerioTo, HashMap userProperties, Boolean applyStructuralSecurity) throws MareException
    {
        UtilidadesLog.info("DAOCanal.query(SegTipoPerioData segTipoPerioFrom, SegTipoPerioData segTipoPerioTo, HashMap userProperties): Entrada");
      
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

      query.append(" SELECT OID_TIPO_PERI, COD_TIPO_PERI, ");
      query.append(" NUM_DIAS, NUM_PERI_ANIO, i18n.val_i18n  ");
      query.append(" FROM SEG_TIPO_PERIO, v_gen_i18n_sicc i18n ");
      query.append(" WHERE OID_TIPO_PERI = i18n.val_oid ");
      query.append(" and i18n.ATTR_ENTI = 'SEG_TIPO_PERIO' ");
      query.append(" and i18n.ATTR_NUM_ATRI = 1 ");
      query.append(" and i18n.IDIO_OID_IDIO = " + (String)idioma.getValue());
      query.append(" ORDER BY i18n.val_i18n ");

      try {
          rs = bs.dbService.executeStaticQuery(query.toString());
      } catch (Exception ex) {
          UtilidadesLog.error("ERROR ", ex);
          throw new MareException(ex, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS));
      }
      
      int cant = rs.getRowCount();
      
      SegTipoPerioData segTipoPerioData = null;
      
      for(int i=0; i < cant; i++){
          segTipoPerioData = new SegTipoPerioData();
                
          segTipoPerioData.setId(Long.valueOf(((BigDecimal)rs.getValueAt(i,"OID_TIPO_PERI")).toString()));
          segTipoPerioData.setCodTipoPeri((String)rs.getValueAt(i,"COD_TIPO_PERI"));  
          segTipoPerioData.setNumDias(Long.valueOf(((BigDecimal)rs.getValueAt(i,"NUM_DIAS")).toString()));
          segTipoPerioData.setNumPeriAnio(Long.valueOf(((BigDecimal)rs.getValueAt(i,"NUM_PERI_ANIO")).toString()));
          segTipoPerioData.setDescripcion((String)rs.getValueAt(i,"VAL_I18N"));   
          
          resultado.add(segTipoPerioData);
      }
      
      UtilidadesLog.info("DAOCanal.query(SegTipoPerioData segTipoPerioFrom, SegTipoPerioData segTipoPerioTo, HashMap userProperties): Salida");
      
      return resultado;
        
    }
}