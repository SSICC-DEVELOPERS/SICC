package es.indra.sicc.logicanegocio.com;


import es.indra.belcorp.mso.ComTipoClienComisCabecData;
import es.indra.belcorp.mso.GenDetaSiccData;
import es.indra.belcorp.mso.SegPaisViewData;
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

public class DAOParametrosTipoClienteCabecera {
    public DAOParametrosTipoClienteCabecera() {
    }
    
    public Vector query(ComTipoClienComisCabecData comTipoClienComisCabecFrom, 
                        ComTipoClienComisCabecData comTipoClienComisCabecTo, 
                        HashMap userProperties, Integer pageCount, Integer pageSize) throws MareException 
                        
    {   UtilidadesLog.info("DAOParametrosTipoClienteCabecera.query(ComTipoClienComisCabecData comTipoClienComisCabecFrom, ComTipoClienComisCabecData comTipoClienComisCabecTo, HashMap userProperties, Integer pageCount, Integer pageSize):Entrada");
        
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
            
                query.append(" SELECT a.OID_TIPO_CLIE_COMI_CABE, a.COD_SUBC, a.COD_CLAS, b.OID_PAIS, c.VAL_I18N ");
                query.append(" FROM COM_TIPO_CLIEN_COMIS_CABEC a, seg_pais b, V_GEN_I18N_SICC c ");
                query.append(" where a.PAIS_OID_PAIS = b.OID_PAIS");
                query.append(" AND c.ATTR_ENTI = 'COM_TIPO_CLIEN_COMIS_CABEC' ");
                query.append(" and c.ATTR_NUM_ATRI = 1");
                query.append(" and c.IDIO_OID_IDIO = 1");
                query.append(" and c.VAL_OID = a.OID_TIPO_CLIE_COMI_CABE");
                
                 if(comTipoClienComisCabecFrom.getId()!= null){
                    query.append(" AND OID_TIPO_CLIE_COMI_CABE = " + comTipoClienComisCabecFrom.getId());
                }
                 if(comTipoClienComisCabecFrom.getCodSubc()!= null){
                    query.append(" AND COD_SUBC = " + comTipoClienComisCabecFrom.getCodSubc());
                }
              
                if(comTipoClienComisCabecFrom.getDescripcion()!= null){
                    query.append(" AND c.VAL_I18N like '" + comTipoClienComisCabecFrom.getDescripcion() + "'");
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
                
                ComTipoClienComisCabecData comTipoClien = null;
                SegPaisViewData segPais = null;
                
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
                          comTipoClien = new ComTipoClienComisCabecData();
                          segPais = new SegPaisViewData();
                          
                          comTipoClien.setId(Long.valueOf(((BigDecimal)rs.getValueAt(i,"OID_TIPO_CLIE_COMI_CABE")).toString())); 
                          comTipoClien.setCodClas((String)rs.getValueAt(i,"COD_CLAS"));
                          comTipoClien.setDescripcion((String)rs.getValueAt(i,"VAL_I18N"));
                          comTipoClien.setCodSubc(Long.valueOf(((BigDecimal)rs.getValueAt(i,"COD_SUBC")).toString()));
                          segPais.setId(Long.valueOf(((BigDecimal)rs.getValueAt(i,"OID_PAIS")).toString()));   
                          comTipoClien.setPaisOidPais(segPais);
                          result.add(comTipoClien);
                    }catch(Exception ex)
                    {
                      ex.printStackTrace();
                    }
                    } else {
                       break;
                    }
                
                     
            }                
    
        UtilidadesLog.info("DAOParametrosTipoClienteCabecera.query(ComTipoClienComisCabecData comTipoClienComisCabecFrom, ComTipoClienComisCabecData comTipoClienComisCabecTo, HashMap userProperties, Integer pageCount, Integer pageSize):Salida");
    
    
    return result;
    }
    public void update(ComTipoClienComisCabecData comTipoClienComisCabec, 
                       Vector localizationLabels) throws MareException 
    {UtilidadesLog.info("DAOParametrosTipoClienteCabecera.update(ComTipoClienComisCabecData comTipoClienComisCabec, Vector localizationLabels):Entrada");
    
        RecordSet rs = null;
                BelcorpService bs = UtilidadesEJB.getBelcorpService();
                
                // Borrar los registros internalizacion
                StringBuffer deleteInter = new StringBuffer();
                
                deleteInter.append("delete GEN_I18N_SICC_PAIS ");
                deleteInter.append(" where VAL_OID = " + comTipoClienComisCabec.getId());
                deleteInter.append(" and ATTR_NUM_ATRI = 1 ");
                deleteInter.append(" and ATTR_ENTI = 'COM_TIPO_CLIEN_COMIS_CABEC'");
                
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
                    queryInter.append(" SELECT GEN_I18N_SEQ.NEXTVAL FROM DUAL");         
                    
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
                        
                    updateInter.append(" INSERT INTO GEN_I18N_SICC_PAIS ( ");
                    updateInter.append("OID_I18N, "); 
                    updateInter.append("ATTR_ENTI, "); 
                    updateInter.append("ATTR_NUM_ATRI, "); 
                    updateInter.append("IDIO_OID_IDIO, "); 
                    updateInter.append("VAL_I18N, ");                 
                    updateInter.append("VAL_OID "); 
                    updateInter.append(" ) VALUES ( ");
                    updateInter.append(idInter + ", ");
                    updateInter.append(" 'COM_TIPO_CLIEN_COMIS_CABEC', ");
                    updateInter.append(" 1, ");            
                    updateInter.append(genDetaSiccData.getIdioOidIdio().getId() + ", ");
                    updateInter.append(" '" + genDetaSiccData.getDeta() + "', ");
                    updateInter.append(comTipoClienComisCabec.getId() + " )");   
                
                    try {
                        int cantRegActualizados = bs.dbService.executeUpdate(updateInter.toString());
                    } catch (Exception ex) {
                        ex.printStackTrace();
                        throw new MareException(ex, UtilidadesError.armarCodigoError(
                                                CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS));
                    }
                }
                StringBuffer update = new StringBuffer();
                
                update.append("UPDATE COM_TIPO_CLIEN_COMIS_CABEC SET ");
                update.append(" COD_SUBC = " + comTipoClienComisCabec.getCodSubc());
                update.append(" WHERE OID_TIPO_CLIE_COMI_CABE = " + comTipoClienComisCabec.getId());   
                
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
        UtilidadesLog.info("DAOParametrosTipoClienteCabecera.update(ComTipoClienComisCabecData comTipoClienComisCabec, Vector localizationLabels):Salida");                
    }
    
    public void remove(Vector entities) throws MareException 
    {   UtilidadesLog.info("DAOParametrosTipoClienteCabecera.remove(Vector entities):Entrada");
    
        BelcorpService bs = UtilidadesEJB.getBelcorpService();
                StringBuffer update = new StringBuffer();
                StringBuffer updateInter = new StringBuffer();
                
                int cant = entities.size();
                ComTipoClienComisCabecData comTipoClienCabec = null;
                String oids = "";
                
                for (int j = 0; j < cant; j++) {
                    comTipoClienCabec = (ComTipoClienComisCabecData)entities.get(j);
                     
                    oids = oids + "," + comTipoClienCabec.getId();
                }
                
                update.append("delete COM_TIPO_CLIEN_COMIS_CABEC ");
                update.append("where OID_TIPO_CLIE_COMI_CABE in ( " + oids.substring(1) + ") ");
                
                updateInter.append("delete GEN_I18N_SICC_PAIS ");
                updateInter.append(" where VAL_OID in ( " + oids.substring(1) + ") ");
                updateInter.append(" and ATTR_NUM_ATRI = 1 ");
                updateInter.append(" and ATTR_ENTI = 'COM_TIPO_CLIEN_COMIS_CABEC' ");
                
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
        UtilidadesLog.info("DAOParametrosTipoClienteCabecera.remove(Vector entities):Salida");
        
    }
    
    public Hashtable guardar(ComTipoClienComisCabecData comTipoClienComisCabec, 
                             Vector localizationLabels, HashMap userProperties) throws MareException 
    {   UtilidadesLog.info("DAOParametrosTipoClienteCabecera.guardar(ComTipoClienComisCabecData comTipoClienComisCabec, Vector localizationLabels, HashMap userProperties):Entrada");
    
        RecordSet rs = null;
                BelcorpService bs = UtilidadesEJB.getBelcorpService();
                
                StringBuffer update = new StringBuffer();
                
                RecordSet rsPK = null;
                StringBuffer query = new StringBuffer();      
                Long id = null;
                
                query.append(" SELECT COM_TCCC_SEQ.NEXTVAL FROM DUAL");         
                
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
              update.append(" INSERT INTO COM_TIPO_CLIEN_COMIS_CABEC ( ");
              update.append(" OID_TIPO_CLIE_COMI_CABE, ");
              update.append(" COD_CLAS, ");
              update.append(" COD_SUBC, ");
              update.append(" PAIS_OID_PAIS ");
              update.append(" ) VALUES ( ");
              update.append(id + ", ");
              update.append(" '" + comTipoClienComisCabec.getCodClas() + "', ");
              update.append(comTipoClienComisCabec.getCodSubc() + ",");
              update.append(comTipoClienComisCabec.getPaisOidPais().getId());
                    
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
                    queryInter.append(" SELECT GEN_I18N_SEQ.NEXTVAL FROM DUAL");         
                    
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
                        

                    updateInter.append(" INSERT INTO GEN_I18N_SICC_PAIS ( ");
                    updateInter.append("OID_I18N, "); 
                    updateInter.append("ATTR_ENTI, "); 
                    updateInter.append("ATTR_NUM_ATRI, "); 
                    updateInter.append("IDIO_OID_IDIO, "); 
                    updateInter.append("VAL_I18N, ");                 
                    updateInter.append("VAL_OID "); 
                    updateInter.append(" ) VALUES ( ");
                    updateInter.append(idInter + ", ");
                    updateInter.append(" 'COM_TIPO_CLIEN_COMIS_CABEC', ");
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
            
        UtilidadesLog.info("DAOParametrosTipoClienteCabecera.guardar(ComTipoClienComisCabecData comTipoClienComisCabec, Vector localizationLabels, HashMap userProperties):Salida");
    return primaryKey;
    }
}
