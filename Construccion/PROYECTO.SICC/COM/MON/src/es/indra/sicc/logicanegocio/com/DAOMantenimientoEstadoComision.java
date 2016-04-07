package es.indra.sicc.logicanegocio.com;

import es.indra.belcorp.mso.ComEstadComisData;
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
import java.util.Vector;

public class DAOMantenimientoEstadoComision {

    public DAOMantenimientoEstadoComision() {
    }
    
    
    public Vector query(ComEstadComisData comEstadComisFrom, 
                        ComEstadComisData comEstadComisTo, 
                        HashMap userProperties, Integer pageCount, Integer pageSize) throws MareException
    {
        UtilidadesLog.info("DAOMantenimientoEstadoComision.query(ComEstadComisData comEstadComisFrom, ComEstadComisData comEstadComisTo, HashMap userProperties, Integer pageCount, Integer pageSize):Entrada");
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
            
                query.append(" SELECT a.OID_ESTA_COMI, a.COD_ESTA_COMI, b.VAL_I18N ");
                query.append(" FROM COM_ESTAD_COMIS a, GEN_I18N_SICC_COMUN b ");
                query.append(" WHERE b.ATTR_ENTI = 'COM_ESTAD_COMIS'");
                query.append(" AND b.ATTR_NUM_ATRI = 1 ");
                query.append(" and b.IDIO_OID_IDIO = 1");
                query.append(" And a.OID_ESTA_COMI = b.VAL_OID");
                
                 if(comEstadComisFrom.getId()!= null){
                    query.append(" AND OID_ESTA_COMI = " + comEstadComisFrom.getId());
                }
                 if(comEstadComisFrom.getCodEstaComi()!= null){
                    query.append(" AND COD_ESTA_COMI like '" + comEstadComisFrom.getCodEstaComi() + "'");
                }
              
                if(comEstadComisFrom.getDescripcion()!= null){
                    query.append(" AND b.VAL_I18N like '" + comEstadComisFrom.getDescripcion() + "'");
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
                
                ComEstadComisData comEstaComis = null;
                
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
                          comEstaComis = new ComEstadComisData();
                          
                          comEstaComis.setId(Long.valueOf(((BigDecimal)rs.getValueAt(i,"OID_ESTA_COMI")).toString())); 
                          comEstaComis.setCodEstaComi((String)rs.getValueAt(i,"COD_ESTA_COMI"));
                          comEstaComis.setDescripcion((String)rs.getValueAt(i,"VAL_I18N"));
                                           
                          result.add(comEstaComis);
                    }catch(Exception ex)
                    {
                      ex.printStackTrace();
                    }
                    } else {
                       break;
                    }
                
                     
            }                   
                        
        UtilidadesLog.info("DAOMantenimientoEstadoComision.query(ComEstadComisData comEstadComisFrom, ComEstadComisData comEstadComisTo, HashMap userProperties, Integer pageCount, Integer pageSize):Salida");        
                        return result;
    }
    
    public void update(ComEstadComisData comEstadComis, 
                       Vector localizationLabels) throws MareException
    {
        UtilidadesLog.info("DAOMantenimientoEstadoComision.update(ComEstadComisData comEstadComis, Vector localizationLabels):Entrada");
        
        RecordSet rs = null;
                BelcorpService bs = UtilidadesEJB.getBelcorpService();
                
                // Borrar los registros internalizacion
                StringBuffer deleteInter = new StringBuffer();
                
                deleteInter.append("delete GEN_I18N_SICC_COMUN ");
                deleteInter.append(" where VAL_OID = " + comEstadComis.getId());
                deleteInter.append(" and ATTR_NUM_ATRI = 1 ");
                deleteInter.append(" and ATTR_ENTI = 'COM_ESTAD_COMIS' ");
                
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
                    queryInter.append(" SELECT GEN_I18C_SEQ.NEXTVAL FROM DUAL" );         
                    
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
                    updateInter.append(" 'COM_ESTAD_COMIS', ");
                    updateInter.append(" 1, ");            
                    updateInter.append(genDetaSiccData.getIdioOidIdio().getId() + ", ");
                    updateInter.append(" '" + genDetaSiccData.getDeta() + "', ");
                    updateInter.append(comEstadComis.getId() + " )");   
                
                    try {
                        int cantRegActualizados = bs.dbService.executeUpdate(updateInter.toString());
                    } catch (Exception ex) {
                        ex.printStackTrace();
                        throw new MareException(ex, UtilidadesError.armarCodigoError(
                                                CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS));
                    }
                }
                StringBuffer update = new StringBuffer();
                
                update.append("UPDATE COM_ESTAD_COMIS SET ");
                update.append(" COD_ESTA_COMI = '" + comEstadComis.getCodEstaComi() + "'");
                update.append(" WHERE OID_ESTA_COMI = " + comEstadComis.getId());   
                
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
        
        
        
        UtilidadesLog.info("DAOMantenimientoEstadoComision.update(ComEstadComisData comEstadComis, Vector localizationLabels):Salida");
    
    }
}
