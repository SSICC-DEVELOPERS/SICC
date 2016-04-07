 package es.indra.sicc.logicanegocio.mae;

import es.indra.belcorp.mso.GenDetaSiccData;
import es.indra.belcorp.mso.MaeEncueNseData;
import es.indra.belcorp.mso.SegMarcaData;
import es.indra.belcorp.mso.SegPaisViewData;
import es.indra.mare.common.exception.MareException;
import es.indra.mare.common.mii.MareMiiServiceNotFoundException;
import es.indra.mare.common.mii.services.jdbcservice.RecordSet;
import es.indra.sicc.dtos.mae.DTOTipoEncuesta;
import es.indra.sicc.util.BelcorpService;
import es.indra.sicc.util.CodigosError;
import es.indra.sicc.util.DTOOIDs;
import es.indra.sicc.util.DTOSalida;
import es.indra.sicc.util.UtilidadesEJB;
import es.indra.sicc.util.UtilidadesError;
import es.indra.sicc.util.UtilidadesLog;

import es.indra.sicc.util.UtilidadesPaginacion;

import java.math.BigDecimal;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.Vector;

public class DAOEncuestaNSE {
    public DAOEncuestaNSE() {
    }
    public Hashtable guardarEncuestaNSE(MaeEncueNseData maeEncueNse, Vector localizationLabels, HashMap userProperties)throws MareException
     {
          UtilidadesLog.info("DAOEncuestaNSE.guardarEncuestaNSE(MaeEncueNseData maeEncueNse, Vector localizationLabels, HashMap userProperties): Entrada");
          RecordSet rs = null;
          BelcorpService bs = UtilidadesEJB.getBelcorpService();     
          StringBuffer updateInter = null;
          StringBuffer update = new StringBuffer();
          RecordSet rsPK = null;
          StringBuffer query = new StringBuffer();      
          Long id = null;
          query.append(" SELECT MAE_ENSE_SEQ.NEXTVAL FROM DUAL ");
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
          update.append(" INSERT INTO MAE_ENCUE_NSE ( ");
          update.append("   OID_ENCU, ");
          update.append("    PAIS_OID_PAIS, ");
          update.append("    COD_TIPO_ENCU,  ");
          update.append("     MARC_OID_MARC ");
          update.append(" ) VALUES ( ");
          update.append(id);
          update.append(" ," + maeEncueNse.getPaisOidPais().getId());
          update.append(" ,'" + maeEncueNse.getCodTipoEncu().toUpperCase()+ "' ");
          update.append(" ," + maeEncueNse.getMarcOidMarc().getId());
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
                    
                updateInter.append(" INSERT INTO GEN_I18N_SICC_PAIS ( ");
                updateInter.append("OID_I18N, "); 
                updateInter.append("ATTR_ENTI, "); 
                updateInter.append("ATTR_NUM_ATRI, "); 
                updateInter.append("IDIO_OID_IDIO, "); 
                updateInter.append("VAL_I18N, ");                 
                updateInter.append("VAL_OID "); 
                updateInter.append(" ) VALUES ( ");
                updateInter.append(idInter + ", ");
                updateInter.append(" 'MAE_ENCUE_NSE', ");
                updateInter.append(" 1, ");   
              //UtilidadesLog.debug(" oidPais: "+ genDetaSiccData.getIdioOidIdio().getId());
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
          UtilidadesLog.info("DAOEncuestaNSE.guardarEncuestaNSE(MaeEncueNseData maeEncueNse, Vector localizationLabels, HashMap userProperties): Salida");
         return primaryKey; 
     }
     public Vector query(MaeEncueNseData maeEncueNseFrom, MaeEncueNseData maeEncueNseTo, HashMap userProperties, Integer pageCount, Integer pageSize )throws MareException
     {
        UtilidadesLog.info("DAOEncuestaNSE.query(MaeEncueNseData maeEncueNseFrom, MaeEncueNseData maeEncueNseTo, HashMap userProperties, Integer pageCount, Integer pageSize ): Entrada");
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
        query.append(" SELECT MAE_ENCUE_NSE.OID_ENCU, MAE_ENCUE_NSE.COD_TIPO_ENCU, ");
        query.append("        V_GEN_I18N_SICC.VAL_I18N, SEG_MARCA.DES_MARC, SEG_MARCA.OID_MARC, SEG_PAIS.OID_PAIS  ");
        query.append("        FROM  MAE_ENCUE_NSE, SEG_MARCA, SEG_PAIS, V_GEN_I18N_SICC ");
        query.append("        WHERE MAE_ENCUE_NSE.MARC_OID_MARC = SEG_MARCA.OID_MARC  ");
        if(maeEncueNseFrom.getMarcOidMarc() != null){
            query.append("         AND SEG_MARCA.OID_MARC = " + maeEncueNseFrom.getMarcOidMarc().getId());
        }
        query.append(" AND MAE_ENCUE_NSE.PAIS_OID_PAIS = SEG_PAIS.OID_PAIS ");
        if(maeEncueNseFrom.getPaisOidPais() != null)
        {
            query.append(" AND SEG_PAIS.OID_PAIS = " + maeEncueNseFrom.getPaisOidPais().getId());
        }
        if(maeEncueNseFrom.getCodTipoEncu() != null ){
            query.append(" AND MAE_ENCUE_NSE.COD_TIPO_ENCU LIKE  '" + maeEncueNseFrom.getCodTipoEncu()+ "' ");
        }
        query.append(" AND V_GEN_I18N_SICC.ATTR_ENTI = 'MAE_ENCUE_NSE' ");
        query.append(" AND V_GEN_I18N_SICC.ATTR_NUM_ATRI = 1");
        query.append(" AND V_GEN_I18N_SICC.IDIO_OID_IDIO = 1 ");
        query.append(" AND V_GEN_I18N_SICC.VAL_OID = MAE_ENCUE_NSE.OID_ENCU ");
        if(maeEncueNseFrom.getDescripcion() != null)
        {
          query.append(" AND V_GEN_I18N_SICC.VAL_I18N LIKE '" + maeEncueNseFrom.getDescripcion() + "' ");
        }
        if(maeEncueNseFrom.getId() != null)
        {
          query.append(" AND MAE_ENCUE_NSE.OID_ENCU =" + maeEncueNseFrom.getId());
          
        }
         try {
               rs = bs.dbService.executeStaticQuery(query.toString());
            } catch (Exception ex) {
              UtilidadesLog.error("ERROR ", ex);
              throw new MareException(ex, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS));
            }
             int cant = rs.getRowCount();
             Vector result = new Vector();
             MaeEncueNseData maeEncueNse = null;
             SegPaisViewData segPaisViewFrom = null; 
             SegMarcaData segMarcaFrom = null;
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
                    maeEncueNse = new MaeEncueNseData();
                    maeEncueNse.setId(new Long(((BigDecimal)rs.getValueAt(i,"OID_ENCU")).toString()));
                    maeEncueNse.setDescripcion((String)rs.getValueAt(i,"VAL_I18N"));
                    maeEncueNse.setCodTipoEncu((String)rs.getValueAt(i,"COD_TIPO_ENCU"));
                    segMarcaFrom = new SegMarcaData();       
                    segMarcaFrom.setId(new Long(((BigDecimal)rs.getValueAt(i,"OID_MARC")).toString()));
                    segMarcaFrom.setDesMarc((String)rs.getValueAt(i,"DES_MARC"));
                    
                    maeEncueNse.setMarcOidMarc(segMarcaFrom);
                    segPaisViewFrom = new SegPaisViewData();
                    segPaisViewFrom.setId(new Long(((BigDecimal)rs.getValueAt(i,"OID_PAIS")).toString()));
                    maeEncueNse.setPaisOidPais(segPaisViewFrom);
                      result.add(maeEncueNse);
                }catch(Exception ex)
                {
                   ex.printStackTrace();
                   UtilidadesLog.error("ERROR ", ex);
                }
                }else
                {
                  break;
                }
            }
             UtilidadesLog.debug("result: " + result);
             UtilidadesLog.info("DAOEncuestaNSE.query(MaeEncueNseData maeEncueNseFrom, MaeEncueNseData maeEncueNseTo, HashMap userProperties, Integer pageCount, Integer pageSize ): Salida");
             return result; 
     }
     public void update(MaeEncueNseData maeEncueNse, Vector localizationLabels)throws MareException
     {
       UtilidadesLog.info("DAOEncuestaNse.update(MaeEncueNseData maeEncueNse, Vector localizationLabels): Entrada");
       RecordSet rs = null;
       BelcorpService bs = UtilidadesEJB.getBelcorpService();
            
         StringBuffer update = new StringBuffer();
         StringBuffer updateInter = null;
         StringBuffer deleteInter = new StringBuffer();
         StringBuffer queryInter = null;
        
         deleteInter.append(" delete GEN_I18N_SICC_PAIS");
         deleteInter.append(" where VAL_OID = " + maeEncueNse.getId());
         deleteInter.append(" and ATTR_NUM_ATRI = 1 ");
         deleteInter.append(" and ATTR_ENTI = 'MAE_ENCUE_NSE' ");
         
         try {
                int cantRegActualizados1 = bs.dbService.executeUpdate(deleteInter.toString());
                
         } catch (Exception ex) {
                ex.printStackTrace();                      
                throw new MareException(ex, UtilidadesError.armarCodigoError(
                                    CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS));           
         }
         update.append("UPDATE MAE_ENCUE_NSE SET ");
         update.append(" MARC_OID_MARC = " + maeEncueNse.getMarcOidMarc().getId());
         update.append(" WHERE OID_ENCU = " + maeEncueNse.getId());
          try {
              int cantRegActualizados = bs.dbService.executeUpdate(update.toString());
                
         } catch (Exception ex) {
              ex.printStackTrace();
              throw new MareException(ex, UtilidadesError.armarCodigoError(
                                        CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS));
         }
         int cant = localizationLabels.size();
         GenDetaSiccData genDetaSiccData = null;
         RecordSet rsPKInter = null;
         Long idInter = null;  
         for(int i = 0; i < cant; i++){
             queryInter = new StringBuffer();
             genDetaSiccData = (GenDetaSiccData)localizationLabels.get(i);                                         
             queryInter.append("SELECT GEN_i18n_SEQ.NEXTVAL FROM DUAL");      
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
             updateInter.append(" 'MAE_ENCUE_NSE', ");
             updateInter.append(" 1, ");            
             updateInter.append(genDetaSiccData.getIdioOidIdio().getId() + ", ");
             updateInter.append(" '" + genDetaSiccData.getDeta() + "', ");
             updateInter.append(maeEncueNse.getId() + " )");   
               
             try {
                  int cantRegActualizados = bs.dbService.executeUpdate(updateInter.toString());
             } catch (Exception ex) {
                   ex.printStackTrace();
                   throw new MareException(ex, UtilidadesError.armarCodigoError(
                                            CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS));
             }
              
         }
          UtilidadesLog.info("DAOEncuestaNse.update(MaeEncueNseData maeEncueNse, Vector localizationLabels): Salida ");
     
     }
     
    public void remove(DTOOIDs dto)throws MareException
     {
       UtilidadesLog.info("DAOEncuestaNSE.remove(Vector encueNse): Entrda");
       RecordSet rs = null;
       BelcorpService bs = UtilidadesEJB.getBelcorpService();
       StringBuffer update = new StringBuffer();
       StringBuffer updateInter = new StringBuffer();
            
       String oidEncuestaNse = "";     
       for(int i=0; i<dto.getOids().length; i++){   
              oidEncuestaNse = oidEncuestaNse + "," + dto.getOids()[i]; 
       }
       update.append("delete MAE_ENCUE_NSE ");
       update.append("where OID_ENCU in ( " + oidEncuestaNse.substring(1) + ") ");
       
       updateInter.append("delete GEN_I18N_SICC_PAIS ");
       updateInter.append(" where VAL_OID in ( " + oidEncuestaNse.substring(1) + ") ");
       updateInter.append(" and ATTR_NUM_ATRI = 1 ");
       updateInter.append(" and ATTR_ENTI = 'MAE_ENCUE_NSE' ");
            
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
       UtilidadesLog.info("DAOEncuestaNSE.remove(Vector encueNse): Salida");

       
      }
      
    public DTOSalida buscarEncuestasNSE(DTOTipoEncuesta dtoe)throws MareException
     {
           UtilidadesLog.info("DAOEncuestaNSE.buscarEncuestaNSE(DTOTipoEncuesta dtoe): Entrada");
           RecordSet rs = new RecordSet();
           StringBuffer query = new StringBuffer();
           StringBuffer queryPaginado = new StringBuffer();
           BelcorpService bs;
           DTOSalida dtoSalida = new DTOSalida();
           String codigoError;
           
           try
           {
                bs = BelcorpService.getInstance();
           }catch(MareMiiServiceNotFoundException ex)
           {
              throw new MareException(ex, UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_PEDIR_UN_SERVICIO_MARE));
           }
           
             query.append(" SELECT MAE_ENCUE_NSE.OID_ENCU as OID, MAE_ENCUE_NSE.COD_TIPO_ENCU, ");
             query.append("        V_GEN_I18N_SICC.VAL_I18N, SEG_MARCA.DES_MARC, SEG_MARCA.OID_MARC, SEG_PAIS.OID_PAIS  ");
             query.append("        FROM  MAE_ENCUE_NSE, SEG_MARCA, SEG_PAIS, V_GEN_I18N_SICC ");
             query.append("        WHERE MAE_ENCUE_NSE.MARC_OID_MARC = SEG_MARCA.OID_MARC  ");
             if(dtoe.getOidMarca() != null){
                 query.append("         AND SEG_MARCA.OID_MARC = " + dtoe.getOidMarca());
             }
             query.append(" AND MAE_ENCUE_NSE.PAIS_OID_PAIS = SEG_PAIS.OID_PAIS ");
             if(dtoe.getOidPais() != null)
             {
                 query.append(" AND SEG_PAIS.OID_PAIS = " + dtoe.getOidPais());
             }
             if(dtoe.getCodTipoEncuesta() != null ){
                 query.append(" AND MAE_ENCUE_NSE.COD_TIPO_ENCU LIKE  '" + dtoe.getCodTipoEncuesta()+ "' ");
             }
             query.append(" AND V_GEN_I18N_SICC.ATTR_ENTI = 'MAE_ENCUE_NSE' ");
             query.append(" AND V_GEN_I18N_SICC.ATTR_NUM_ATRI = 1");
             query.append(" AND V_GEN_I18N_SICC.IDIO_OID_IDIO = 1 ");
             query.append(" AND V_GEN_I18N_SICC.VAL_OID = MAE_ENCUE_NSE.OID_ENCU ");
             if(dtoe.getDescripcion() != null)
             {
               query.append(" AND V_GEN_I18N_SICC.VAL_I18N LIKE '" + dtoe.getDescripcion() + "' ");
             }
             if(dtoe.getOidEncuesta() != null)
             {
               query.append(" AND MAE_ENCUE_NSE.OID_ENCU =" + dtoe.getOidEncuesta());
               
             }
             String sqlPaginacion = null;  
             sqlPaginacion = UtilidadesPaginacion.armarQueryPaginacion(query.toString(),dtoe);
             try {
                  rs = bs.dbService.executeStaticQuery(sqlPaginacion.toString());
             } catch (Exception e) {
                 e.printStackTrace();
                 codigoError = CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS;
                 UtilidadesLog.error("buscarRegistroVentas: Exception",e);      
                 throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));
                
             }
             dtoSalida.setResultado(rs);
             UtilidadesLog.info("DAOEncuestaNSE.buscarEncuestaNSE(DTOTipoEncuesta dtoe): Entrada");
             return dtoSalida;
         
       } 
           
           
     }

    

