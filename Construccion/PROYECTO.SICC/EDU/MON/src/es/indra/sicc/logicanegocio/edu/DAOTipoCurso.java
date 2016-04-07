package es.indra.sicc.logicanegocio.edu;

import es.indra.belcorp.mso.EduTipoCursoData;
import es.indra.belcorp.mso.GenDetaSiccData;
import es.indra.belcorp.mso.SegMarcaData;
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

public class DAOTipoCurso {
    public DAOTipoCurso() {
    }
    public Vector query(EduTipoCursoData eduTipoCursoFrom, EduTipoCursoData eduTipoCursoTo, HashMap userProperties, Integer pageCount, Integer pageSize) throws MareException
        {   UtilidadesLog.info("DAOTipoCurso.query(EduTipoCursoData eduTipoCursoFrom, EduTipoCursoData eduTipoCursoTo, HashMap userProperties, Integer pageCount, Integer pageSize):SC:::Entrada");
        
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
                
                    query.append(" SELECT a.OID_TIPO_CURS, a.COD_TIPO_CURS, b.OID_MARC, c.VAL_I18N, b.DES_MARC ");
                    query.append(" FROM EDU_TIPO_CURSO a, SEG_MARCA b, GEN_I18N_SICC_COMUN c ");
                    query.append(" WHERE a.MARC_OID_MARC = b.OID_MARC");
                    query.append(" AND c.ATTR_ENTI = 'EDU_TIPO_CURSO' ");
                    query.append(" and c.ATTR_NUM_ATRI = 1");
                    query.append(" and c.IDIO_OID_IDIO = 1");
                    query.append(" and c.VAL_OID = a.OID_TIPO_CURS ");
                    
                    
                     if(eduTipoCursoFrom.getId()!= null){
                        query.append(" AND OID_TIPO_CURS = " + eduTipoCursoFrom.getId());
                    }
                     if(eduTipoCursoFrom.getCodTipoCurs()!= null){
                        query.append(" AND COD_TIPO_CURS = " + eduTipoCursoFrom.getCodTipoCurs());
                    }
                  
                    if(eduTipoCursoFrom.getDescripcion()!= null){
                        query.append(" AND VAL_I18N like '" + eduTipoCursoFrom.getDescripcion() + "'");
                    }
                    if(eduTipoCursoFrom.getMarcOidMarc()!= null)
                    {
                        query.append(" AND OID_MARC = " + eduTipoCursoFrom.getMarcOidMarc().getId());
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
                    
                    EduTipoCursoData eduTipoCurso = null;
                    SegMarcaData segMarca = null;
                    
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
                              eduTipoCurso = new EduTipoCursoData();
                              segMarca = new SegMarcaData();
                              
                              eduTipoCurso.setId(Long.valueOf(((BigDecimal)rs.getValueAt(i,"OID_TIPO_CURS")).toString())); 
                              eduTipoCurso.setCodTipoCurs(Long.valueOf(((BigDecimal)rs.getValueAt(i,"COD_TIPO_CURS")).toString()));
                              eduTipoCurso.setDescripcion((String)rs.getValueAt(i,"VAL_I18N"));
                              segMarca.setId(Long.valueOf(((BigDecimal)rs.getValueAt(i,"OID_MARC")).toString()));
                              segMarca.setDesMarc((String)rs.getValueAt(i,"DES_MARC"));
                              eduTipoCurso.setMarcOidMarc(segMarca);
                              
                              result.add(eduTipoCurso);
                        }catch(Exception ex)
                        {
                          ex.printStackTrace();
                        }
                        } else {
                           break;
                        }
                   
                }                
        
            UtilidadesLog.info("DAOTipoCurso.query(EduTipoCursoData eduTipoCursoFrom, EduTipoCursoData eduTipoCursoTo, HashMap userProperties, Integer pageCount, Integer pageSize):Salida");   
            
            
            return result;
        }
        
         public void remove(Vector entities) throws MareException
        {   UtilidadesLog.info("DAOEduTipoCurso.remove(Vector entities)SC:Entrada");
            BelcorpService bs = UtilidadesEJB.getBelcorpService();
                    StringBuffer update = new StringBuffer();
                    StringBuffer updateInter = new StringBuffer();
                    
                    int cant = entities.size();
                    EduTipoCursoData eduTipoCurso = null;
                    String oids = "";
                    
                    for (int j = 0; j < cant; j++) {
                        eduTipoCurso = (EduTipoCursoData)entities.get(j);
                         
                        oids = oids + "," + eduTipoCurso.getId();
                    }
                    
                    update.append("delete EDU_TIPO_CURSO ");
                    update.append("where OID_TIPO_CURS in ( " + oids.substring(1) + ") ");
                    
                    updateInter.append("delete GEN_I18N_SICC_COMUN ");
                    updateInter.append(" where VAL_OID in ( " + oids.substring(1) + ") ");
                    updateInter.append(" and ATTR_NUM_ATRI = 1 ");
                    updateInter.append(" and ATTR_ENTI = 'EDU_TIPO_CURSO' ");
                    
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

            
        
        
        
             UtilidadesLog.info("DAOTipoCurso.remove(Vector entities):Salida");
        }
        
        public void update(EduTipoCursoData eduTipoCurso, Vector localizationLabels) throws MareException
        {   UtilidadesLog.info("DAOEduTipoCurso.update(EduTipoCursoData eduTipoCurso, Vector localizationLabels):SC: Entrada");
            RecordSet rs = null;
                    BelcorpService bs = UtilidadesEJB.getBelcorpService();
                    
                    // Borrar los registros internalizacion
                    StringBuffer deleteInter = new StringBuffer();
                    
                    deleteInter.append("delete GEN_I18N_SICC_COMUN ");
                    deleteInter.append(" where VAL_OID = " + eduTipoCurso.getId());
                    deleteInter.append(" and ATTR_NUM_ATRI = 1 ");
                    deleteInter.append(" and ATTR_ENTI = 'EDU_TIPO_CURSO' ");
                    
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
                        updateInter.append(" 'EDU_TIPO_CURSO', ");
                        updateInter.append(" 1, ");            
                        updateInter.append(genDetaSiccData.getIdioOidIdio().getId() + ", ");
                        updateInter.append(" '" + genDetaSiccData.getDeta() + "', ");
                        updateInter.append(eduTipoCurso.getId() + " )");   
                    
                        try {
                            int cantRegActualizados = bs.dbService.executeUpdate(updateInter.toString());
                        } catch (Exception ex) {
                            ex.printStackTrace();
                            throw new MareException(ex, UtilidadesError.armarCodigoError(
                                                    CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS));
                        }
                    }
                    StringBuffer update = new StringBuffer();
                    
                    update.append("UPDATE EDU_TIPO_CURSO SET ");
                    update.append(" COD_TIPO_CURS = " + eduTipoCurso.getCodTipoCurs());
                    update.append(" WHERE OID_TIPO_CURS = " + eduTipoCurso.getId());   
                    
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
        
        
        
            UtilidadesLog.info("DAOTipoCurso.update(EduTipoCursoData eduTipoCurso, Vector localizationLabels):Salida");
        
        
        }
         public Hashtable guardar(EduTipoCursoData eduTipoCurso, Vector localizationLabels, HashMap userProperties) throws MareException
        {   UtilidadesLog.info("DAOEduTipoCurso.guardar(EduTipoCursoData eduTipoCurso, Vector localizationLabels, HashMap userProperties):SC: Entrada"); 
            RecordSet rs = null;
                    BelcorpService bs = UtilidadesEJB.getBelcorpService();
                    
                    StringBuffer update = new StringBuffer();
                    
                    RecordSet rsPK = null;
                    StringBuffer query = new StringBuffer();      
                    Long id = null;
                    
                    query.append(" SELECT EDU_TICU_SEQ.NEXTVAL FROM DUAL");         
                    
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
                  update.append(" INSERT INTO EDU_TIPO_CURSO ( ");
                  update.append(" OID_TIPO_CURS, ");
                  update.append(" MARC_OID_MARC, ");
                  update.append(" COD_TIPO_CURS ");
                  update.append(" ) VALUES ( ");
                  update.append(id + ", ");
                  update.append(eduTipoCurso.getMarcOidMarc().getId() + ",");
                  update.append(eduTipoCurso.getCodTipoCurs());
                        
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
                        updateInter.append(" 'EDU_TIPO_CURSO', ");
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
           
        
            UtilidadesLog.info("DAOTipoCurso.guardar(EduTipoCursoData eduTipoCurso, Vector localizationLabels, HashMap userProperties):Salida");
            return primaryKey;
        }
    }
    
    

