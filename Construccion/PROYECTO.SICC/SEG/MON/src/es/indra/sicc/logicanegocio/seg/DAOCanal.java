package es.indra.sicc.logicanegocio.seg;

import es.indra.belcorp.mso.GenDetaSiccData;
import es.indra.belcorp.mso.SegCanalData;
import es.indra.belcorp.mso.SegCanalViewData;
import es.indra.belcorp.mso.SegTipoPerioData;
import es.indra.mare.common.mgu.manager.Property;
import es.indra.mare.common.mii.MareMiiServiceNotFoundException;
import es.indra.mare.common.mii.services.jdbcservice.RecordSet;
import es.indra.sicc.util.BelcorpService;
import es.indra.sicc.util.CodigosError;
import es.indra.sicc.util.UtilidadesEJB;
import es.indra.sicc.util.UtilidadesError;
import es.indra.sicc.util.UtilidadesLog;
import java.math.BigDecimal;
import java.util.Vector;
import java.util.HashMap;
import java.util.Hashtable;
import es.indra.mare.common.exception.MareException;

public class DAOCanal 
{
    public DAOCanal()
    {
    }
    
     public Hashtable guardar(SegCanalData segCanal, Vector localizationLabels, HashMap userProperties) throws MareException
    {
        UtilidadesLog.info("DAOCanal.guardar(SegCanalData segCanal, Vector localizationLabels, HashMap userProperties): Entrada");
        RecordSet rs = null;
        BelcorpService bs = UtilidadesEJB.getBelcorpService();
        
        StringBuffer update = new StringBuffer();        
        RecordSet rsPK = null;
        StringBuffer query = new StringBuffer();      
        Long id = null;
        
        query.append(" SELECT SEG_CANA_SEQ.NEXTVAL FROM DUAL");         
        
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
        
        update.append(" INSERT INTO SEG_CANAL ( ");
        update.append("OID_CANA, "); 
        update.append("COD_CANA, "); 
        update.append("TIPE_OID_TIPO_PERI "); 
  
        update.append(" ) VALUES ( ");
        update.append(id + ", ");
        update.append(" '" + segCanal.getCodCana() + "', ");
        update.append(segCanal.getTipeOidTipoPeri().getId());
        
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
            updateInter.append(" 'SEG_CANAL', ");
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
    
        UtilidadesLog.info("DAOCanal.guardar(SegCanalData segCanal, Vector localizationLabels, HashMap userProperties): Salida");
        return primaryKey;
    }

    public void remove(Vector segCanalFrom) throws MareException
    {
        UtilidadesLog.info("DAOCanal.remove(Vector segCanalFrom): Entrada");
        RecordSet rs = null;
        BelcorpService bs = UtilidadesEJB.getBelcorpService();
        StringBuffer update = new StringBuffer();
        StringBuffer updateInter = new StringBuffer();
        
        int cant = segCanalFrom.size();
        SegCanalData segCanalData = null;
        String oids = "";
        
        for (int j = 0; j < cant; j++) {
            segCanalData = (SegCanalData)segCanalFrom.get(j);
             
            oids = oids + "," + segCanalData.getId();
        }
        
        update.append("delete SEG_CANAL ");
        update.append("where OID_CANA in ( " + oids.substring(1) + ") ");
        
        updateInter.append("delete GEN_I18N_SICC_COMUN ");
        updateInter.append(" where VAL_OID in ( " + oids.substring(1) + ") ");
        updateInter.append(" and ATTR_NUM_ATRI = 1 ");
        updateInter.append(" and ATTR_ENTI = 'SEG_CANAL' ");
        
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
        
        UtilidadesLog.info("DAOCanal.remove(Vector segCanalFrom): Salida");
    }
    
    public Vector query(SegCanalData segCanalFrom, SegCanalData segCanalTo, HashMap userProperties, Integer pageCount, Integer pageSize, Boolean applyStructuralSecurity) throws MareException
    {
        UtilidadesLog.info("DAOCanal.query(SegCanalData segCanalFrom, SegCanalData segCanalTo, HashMap userProperties, Integer pageCount, Integer pageSize): Entrada");
        
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
        
        if(applyStructuralSecurity.booleanValue()){
            
            Property userID = (Property)userProperties.get("userID");
    
            query.append(" SELECT OID_CANA, COD_CANA, i18n.VAL_I18N DESC_CANAL, ");
            query.append(" TIPE_OID_TIPO_PERI, i18n1.VAL_I18N DESC_TIPOPERI ");
            query.append(" FROM VCA_SEG_CANAL, v_gen_i18n_sicc i18n, v_gen_i18n_sicc i18n1 ");
            query.append(" WHERE OID_CANA = i18n.val_oid ");
            query.append(" AND i18n.attr_enti = 'SEG_CANAL' ");
            query.append(" AND i18n.attr_num_atri = 1 ");
            query.append(" AND i18n.idio_oid_idio = " + (String)idioma.getValue());
            query.append(" AND TIPE_OID_TIPO_PERI = i18n1.val_oid ");
            query.append(" AND i18n1.attr_enti = 'SEG_TIPO_PERIO' ");
            query.append(" AND i18n1.attr_num_atri = 1 ");
            query.append(" AND i18n1.idio_oid_idio = " + (String)idioma.getValue());
            query.append(" AND COD_USUA = '" + userID.getValue() + "' ");
        
        } else {
        
            query.append(" SELECT OID_CANA, COD_CANA, i18n.VAL_I18N DESC_CANAL, ");
            query.append(" TIPE_OID_TIPO_PERI, i18n1.VAL_I18N DESC_TIPOPERI ");
            query.append(" FROM SEG_CANAL, v_gen_i18n_sicc i18n, v_gen_i18n_sicc i18n1 ");
            query.append(" WHERE OID_CANA = i18n.val_oid ");
            query.append(" AND i18n.attr_enti = 'SEG_CANAL' ");
            query.append(" AND i18n.attr_num_atri = 1 ");
            query.append(" AND i18n.idio_oid_idio = " + (String)idioma.getValue());
            query.append(" AND TIPE_OID_TIPO_PERI = i18n1.val_oid ");
            query.append(" AND i18n1.attr_enti = 'SEG_TIPO_PERIO' ");
            query.append(" AND i18n1.attr_num_atri = 1 ");
            query.append(" AND i18n1.idio_oid_idio = " + (String)idioma.getValue());
            
        }        
        
        // Para la busqueda
        if(segCanalFrom.getCodCana()!= null){
            query.append(" and COD_CANA like '" + segCanalFrom.getCodCana() + "' ");
        }
        
        if(segCanalFrom.getDescripcion()!= null){
            query.append(" and i18n.VAL_I18N like '" + segCanalFrom.getDescripcion() + "' ");
        }
        
        if(segCanalFrom.getTipeOidTipoPeri()!= null){
            query.append(" and TIPE_OID_TIPO_PERI= " + segCanalFrom.getTipeOidTipoPeri().getId());
        }
        
        // Para el detalle
        if(segCanalFrom.getId()!= null){
            query.append(" and OID_CANA = " + segCanalFrom.getId());
        }

        try {
           rs = bs.dbService.executeStaticQuery(query.toString());
        } catch (Exception ex) {
          UtilidadesLog.error("ERROR ", ex);
          throw new MareException(ex, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS));
        }
        
        
        int cant = rs.getRowCount();
        Vector result = new Vector();
        
        SegCanalData segCanalData = null;
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
                segCanalData = new SegCanalData();
                
                segCanalData.setId(Long.valueOf(((BigDecimal)rs.getValueAt(i,"OID_CANA")).toString()));
                segCanalData.setCodCana((String)rs.getValueAt(i,"COD_CANA"));  
                segCanalData.setDescripcion((String)rs.getValueAt(i,"DESC_CANAL"));   
                
                segTipoPerioData = new SegTipoPerioData();
                segTipoPerioData.setId(Long.valueOf(((BigDecimal)rs.getValueAt(i,"TIPE_OID_TIPO_PERI")).toString()));
                segTipoPerioData.setDescripcion((String)rs.getValueAt(i,"DESC_TIPOPERI"));   
                segCanalData.setTipeOidTipoPeri(segTipoPerioData);
                
                result.add(segCanalData);
                
            } else {
               break;
            }
        }        
        
        UtilidadesLog.debug("result: " + result);
       
        UtilidadesLog.info("DAOCanal.query(SegCanalData segCanalFrom, SegCanalData segCanalTo, HashMap userProperties, Integer pageCount, Integer pageSize): Salida");
        return result;
      
    }
    
    public void update(SegCanalData segCanal, Vector localizationLabels) throws MareException
    {
        UtilidadesLog.info("DAOCanal.update(SegCanalData segCanal, Vector localizationLabels): Entrada");
       
        RecordSet rs = null;
        BelcorpService bs = UtilidadesEJB.getBelcorpService();
        
        // Borrar los registros internalizacion
        StringBuffer deleteInter = new StringBuffer();
        
        deleteInter.append("delete GEN_I18N_SICC_COMUN ");
        deleteInter.append(" where VAL_OID = " + segCanal.getId());
        deleteInter.append(" and ATTR_NUM_ATRI = 1 ");
        deleteInter.append(" and ATTR_ENTI = 'SEG_CANAL' ");
        
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
            updateInter.append(" 'SEG_CANAL', ");
            updateInter.append(" 1, ");            
            updateInter.append(genDetaSiccData.getIdioOidIdio().getId() + ", ");
            updateInter.append(" '" + genDetaSiccData.getDeta() + "', ");
            updateInter.append(segCanal.getId() + " )");   
        
            try {
                int cantRegActualizados = bs.dbService.executeUpdate(updateInter.toString());
            } catch (Exception ex) {
                ex.printStackTrace();
                throw new MareException(ex, UtilidadesError.armarCodigoError(
                                        CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS));
            }
        }
        
        UtilidadesLog.info("DAOCanal.update(SegCanalData segCanal, Vector localizationLabels): Salida");
    }
    
    public Vector query(SegCanalViewData segCanalViewFrom, SegCanalViewData segCanalViewTo, HashMap userProperties, Boolean applyStructuralSecurity) throws MareException
    {
      UtilidadesLog.info("DAOCanal.query(SegCanalViewData segCanalViewFrom, SegCanalViewData segCanalViewTo, HashMap userProperties): Entrada");
      
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

      if(applyStructuralSecurity.booleanValue()){
            
            Property userID = (Property)userProperties.get("userID");
    
            query.append(" SELECT OID_CANA, COD_CANA, i18n.VAL_I18N DESC_CANAL, ");
            query.append(" TIPE_OID_TIPO_PERI, i18n1.VAL_I18N DESC_TIPOPERI ");
            query.append(" FROM VCA_SEG_CANAL, v_gen_i18n_sicc i18n, v_gen_i18n_sicc i18n1 ");
            query.append(" WHERE OID_CANA = i18n.val_oid ");
            query.append(" AND i18n.attr_enti = 'SEG_CANAL' ");
            query.append(" AND i18n.attr_num_atri = 1 ");
            query.append(" AND i18n.idio_oid_idio = " + (String)idioma.getValue());
            query.append(" AND TIPE_OID_TIPO_PERI = i18n1.val_oid ");
            query.append(" AND i18n1.attr_enti = 'SEG_TIPO_PERIO' ");
            query.append(" AND i18n1.attr_num_atri = 1 ");
            query.append(" AND i18n1.idio_oid_idio = " + (String)idioma.getValue());
            query.append(" AND COD_USUA = '" + userID.getValue() + "' ");
        
        } else {
        
            query.append(" SELECT OID_CANA, COD_CANA, i18n.VAL_I18N DESC_CANAL, ");
            query.append(" TIPE_OID_TIPO_PERI, i18n1.VAL_I18N DESC_TIPOPERI ");
            query.append(" FROM SEG_CANAL, v_gen_i18n_sicc i18n, v_gen_i18n_sicc i18n1 ");
            query.append(" WHERE OID_CANA = i18n.val_oid ");
            query.append(" AND i18n.attr_enti = 'SEG_CANAL' ");
            query.append(" AND i18n.attr_num_atri = 1 ");
            query.append(" AND i18n.idio_oid_idio = " + (String)idioma.getValue());
            query.append(" AND TIPE_OID_TIPO_PERI = i18n1.val_oid ");
            query.append(" AND i18n1.attr_enti = 'SEG_TIPO_PERIO' ");
            query.append(" AND i18n1.attr_num_atri = 1 ");
            query.append(" AND i18n1.idio_oid_idio = " + (String)idioma.getValue());
            
        }        
        
        query.append(" ORDER BY DESC_CANAL ");

      try {
          rs = bs.dbService.executeStaticQuery(query.toString());
      } catch (Exception ex) {
          UtilidadesLog.error("ERROR ", ex);
          throw new MareException(ex, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS));
      }
      
      int cant = rs.getRowCount();
      
      SegCanalViewData segCanalViewData = null;
      SegTipoPerioData segTipoPerioData = null;
      
      for(int i=0; i < cant; i++){
          segCanalViewData = new SegCanalViewData();
                
          segCanalViewData.setId(Long.valueOf(((BigDecimal)rs.getValueAt(i,"OID_CANA")).toString()));
          segCanalViewData.setCodCana((String)rs.getValueAt(i,"COD_CANA"));  
          segCanalViewData.setDescripcion((String)rs.getValueAt(i,"DESC_CANAL"));   
        
          segTipoPerioData = new SegTipoPerioData();
          segTipoPerioData.setId(Long.valueOf(((BigDecimal)rs.getValueAt(i,"TIPE_OID_TIPO_PERI")).toString()));
          segTipoPerioData.setDescripcion((String)rs.getValueAt(i,"DESC_TIPOPERI"));   
          segCanalViewData.setTipeOidTipoPeri(segTipoPerioData);
          
          resultado.add(segCanalViewData);
      }
      
      UtilidadesLog.info("DAOCanal.query(SegCanalViewData segCanalViewFrom, SegCanalViewData segCanalViewTo, HashMap userProperties): Salida");
      
      return resultado;
    }

}