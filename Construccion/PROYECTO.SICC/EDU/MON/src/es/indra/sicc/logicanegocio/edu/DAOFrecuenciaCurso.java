package es.indra.sicc.logicanegocio.edu;

import es.indra.belcorp.mso.EduFrecuCursoData;
import es.indra.belcorp.mso.GenDetaSiccData;
import es.indra.mare.common.exception.MareException;

import es.indra.mare.common.mii.MareMiiServiceNotFoundException;
import es.indra.mare.common.mii.services.jdbcservice.RecordSet;
import es.indra.sicc.util.BelcorpService;
import es.indra.sicc.util.CodigosError;
import es.indra.sicc.util.UtilidadesEJB;
import es.indra.sicc.util.UtilidadesError;

import es.indra.sicc.util.UtilidadesLog;

import java.math.BigDecimal;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.Vector;

public class DAOFrecuenciaCurso {
    public DAOFrecuenciaCurso() {
    }
    
    public Vector query(EduFrecuCursoData eduFrecuCursoFrom, EduFrecuCursoData eduFrecuCursoTo, HashMap userProperties, Integer pageCount, Integer pageSize) throws MareException
        {   UtilidadesLog.info("DAOFrecuenciaCurso.query(EduFrecuCursoData eduFrecuCursoFrom, EduFrecuCursoData eduFrecuCursoTo, HashMap userProperties, Integer pageCount, Integer pageSize):Entrada");
        
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
                    try{
                
                    query.append(" SELECT a.OID_FREC, a.COD_FREC, b.VAL_I18N ");
                    query.append(" FROM EDU_FRECU_CURSO a, GEN_I18N_SICC_COMUN b ");
                    query.append(" WHERE b.ATTR_ENTI = 'EDU_FRECU_CURSO'");
                    query.append(" and b.ATTR_NUM_ATRI = 1 ");
                    query.append(" and b.IDIO_OID_IDIO = 1");
                    query.append(" and b.VAL_OID = a.OID_FREC");
                    
                    
                     if(eduFrecuCursoFrom.getId()!= null){
                        query.append(" AND OID_FREC = " + eduFrecuCursoFrom.getId());
                    }
                     if(eduFrecuCursoFrom.getCodFrec()!= null){
                        query.append(" AND COD_FREC = " + eduFrecuCursoFrom.getCodFrec());
                    }
                  
                    if(eduFrecuCursoFrom.getDescripcion()!= null){
                        query.append(" AND b.VAL_I18N like '" + eduFrecuCursoFrom.getDescripcion() + "'");
                    }
                    
                    
                    }catch(Exception ex)
                    {
                      ex.printStackTrace();
                    }
                  try {
                       rs = bs.dbService.executeStaticQuery(query.toString());
                    } catch (Exception ex) {
                      UtilidadesLog.error("ERROR ", ex);
                      throw new MareException(ex, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS));
                    }
                    
                    
                    int cant = rs.getRowCount();
                    Vector result = new Vector();
                    
                    EduFrecuCursoData eduFrecuCurso = null;
                    
                    
                    int rsSaltar = (pageCount.intValue() - 1) * pageSize.intValue();
                    int rsMostrar = ((pageSize.intValue() == Integer.MAX_VALUE) ? pageSize.intValue() : (pageSize.intValue() + 1)) + rsSaltar;
                    
                    UtilidadesLog.debug("rsSaltar: " + rsSaltar);
                    UtilidadesLog.debug("rsMostrar: " + rsMostrar);
                    
                    for(int i=0; i < cant; i++){
                    
                        if(i < rsSaltar ) {
                            continue;
                        }
                        
                        if(i < rsMostrar){
                        try{
                              eduFrecuCurso = new EduFrecuCursoData();
                             
                              
                              eduFrecuCurso.setId(Long.valueOf(((BigDecimal)rs.getValueAt(i,"OID_FREC")).toString())); 
                              eduFrecuCurso.setCodFrec(Long.valueOf(((BigDecimal)rs.getValueAt(i,"COD_FREC")).toString()));
                              eduFrecuCurso.setDescripcion((String)rs.getValueAt(i,"VAL_I18N"));
                              
                              result.add(eduFrecuCurso);
                        }catch(Exception ex)
                        {
                          ex.printStackTrace();
                        }
                        } else {
                           break;
                        }
                    
                         
                }                
        
        
        
            UtilidadesLog.info("DAOFrecuenciaCurso.query(EduFrecuCursoData eduFrecuCursoFrom, EduFrecuCursoData eduFrecuCursoTo, HashMap userProperties, Integer pageCount, Integer pageSize):Salida");
        
            return result;
        }
        
         public void remove(Vector entities) throws MareException
        {   UtilidadesLog.info("DAOFrecuenciaCurso.remove((Vector entities):Entrada");
            BelcorpService bs = UtilidadesEJB.getBelcorpService();
                    StringBuffer update = new StringBuffer();
                    StringBuffer updateInter = new StringBuffer();
                    
                    int cant = entities.size();
                    EduFrecuCursoData eduFrecuCurso = null;
                    String oids = "";
                    
                    for (int j = 0; j < cant; j++) {
                        eduFrecuCurso = (EduFrecuCursoData)entities.get(j);
                         
                        oids = oids + "," + eduFrecuCurso.getId();
                    }
                    
                    update.append("delete EDU_FRECU_CURSO ");
                    update.append("where OID_FREC in ( " + oids.substring(1) + ") ");
                    
                    updateInter.append("delete GEN_I18N_SICC_COMUN ");
                    updateInter.append(" where VAL_OID in ( " + oids.substring(1) + ") ");
                    updateInter.append(" and ATTR_NUM_ATRI = 1 ");
                    updateInter.append(" and ATTR_ENTI = 'EDU_FRECU_CURSO' ");
                    
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

            
            UtilidadesLog.info("DAOFrecuenciaCurso.remove((Vector entities):Salida");
        }
        
         public void update(EduFrecuCursoData eduFrecuCurso, Vector localizationLabels) throws MareException
        {   UtilidadesLog.info("DAOFrecuenciaCurso.update(EduFrecuCursoData eduFrecuCurso, Vector localizationLabels):Entrada");
            
            RecordSet rs = null;
                    BelcorpService bs = UtilidadesEJB.getBelcorpService();
                    
                    // Borrar los registros internalizacion
                    StringBuffer deleteInter = new StringBuffer();
                    
                    deleteInter.append("delete GEN_I18N_SICC_COMUN ");
                    deleteInter.append(" where VAL_OID = " + eduFrecuCurso.getId());
                    deleteInter.append(" and ATTR_NUM_ATRI = 1 ");
                    deleteInter.append(" and ATTR_ENTI = 'EDU_FRECU_CURSO' ");
                    
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
                        queryInter.append(" SELECT GEN_I18C_SEQ.NEXTVAL FROM DUAL");         
                        
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
                        updateInter.append(" 'EDU_FRECU_CURSO', ");
                        updateInter.append(" 1, ");            
                        updateInter.append(genDetaSiccData.getIdioOidIdio().getId() + ", ");
                        updateInter.append(" '" + genDetaSiccData.getDeta() + "', ");
                        updateInter.append(eduFrecuCurso.getId() + " )");   
                    
                        try {
                            int cantRegActualizados = bs.dbService.executeUpdate(updateInter.toString());
                        } catch (Exception ex) {
                            ex.printStackTrace();
                            throw new MareException(ex, UtilidadesError.armarCodigoError(
                                                    CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS));
                        }
                    }
                    StringBuffer update = new StringBuffer();
                    
                    update.append("UPDATE EDU_FRECU_CURSO SET ");
                    update.append(" COD_FREC = " + eduFrecuCurso.getCodFrec());
                    update.append(" WHERE OID_FREC = " + eduFrecuCurso.getId());   
                    
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
        
             UtilidadesLog.info("DAOFrecuenciaCurso.update(EduFrecuCursoData eduFrecuCurso, Vector localizationLabels):Salida");
        }
        
        public Hashtable guardar(EduFrecuCursoData eduFrecuCurso, Vector localizationLabels, HashMap userProperties) throws MareException
        {   UtilidadesLog.info("DAOFrecuenciaCurso.guardar(EduFrecuCursoData eduFrecuCurso, Vector localizationLabels, HashMap userProperties):Entrada");
             RecordSet rs = null;
                    BelcorpService bs = UtilidadesEJB.getBelcorpService();
                    
                    StringBuffer update = new StringBuffer();
                    
                    RecordSet rsPK = null;
                    StringBuffer query = new StringBuffer();      
                    Long id = null;
                    
                    query.append(" SELECT EDU_FRCU_SEQ.NEXTVAL FROM DUAL");         
                    
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
                  update.append(" INSERT INTO EDU_FRECU_CURSO ( ");
                  update.append(" OID_FREC, ");
                  update.append(" COD_FREC ");
                  update.append(" ) VALUES ( ");
                  update.append(id + ", ");
                  update.append(eduFrecuCurso.getCodFrec());
                  
                        
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
                        queryInter.append(" SELECT GEN_I18C_SEQ.NEXTVAL FROM DUAL");         
                        
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
                        updateInter.append(" 'EDU_FRECU_CURSO', ");
                        updateInter.append(" 1, ");            
                        updateInter.append(genDetaSiccData.getIdioOidIdio().getId() + ", ");
                        updateInter.append(" '" + genDetaSiccData.getDeta() + "', ");
                        updateInter.append(id);    
                        updateInter.append(")");
                            
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
           
        
        
        
        
            UtilidadesLog.info("DAOFrecuenciaCurso.guardar(EduFrecuCursoData eduFrecuCurso, Vector localizationLabels, HashMap userProperties):Salida");
            return primaryKey;
        }
    }
    
    

