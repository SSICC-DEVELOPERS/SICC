package es.indra.sicc.logicanegocio.ccc;

import es.indra.belcorp.mso.CccMarcaSituaData;
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

public class DAOCccMarcaSituacion {
    public DAOCccMarcaSituacion() {
    }
    public Hashtable guardarMarcaSituacion(CccMarcaSituaData cccMarcaSitua, Vector localizationLabels, HashMap userProperties)throws MareException
     {
       UtilidadesLog.info("DAOCccMarcaSituacion.guardarMarcaSituacion(CccMarcaSituaData cccMarcaSitua, Vector localizationLabels, HashMap userProperties): Entrada");
       RecordSet rs = null;
       BelcorpService bs = UtilidadesEJB.getBelcorpService();     
       StringBuffer update = new StringBuffer();
       StringBuffer updateInter = new StringBuffer();
       RecordSet rsPK = null;
       StringBuffer query = new StringBuffer();      
       Long id = null;
       query.append(" SELECT CCC_MASI_SEQ.NEXTVAL FROM DUAL ");
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
       update.append(" INSERT INTO CCC_MARCA_SITUA( ");
       update.append("             OID_MARC_SITU ");
       update.append("             ,PAIS_OID_PAIS ");
       update.append("             , COD_MARC_SITU ");
       update.append("             , VAL_OBSE ");
       update.append("             , IND_CUEN_CAST ");
       update.append(" ) VALUES ( ");
       update.append(id);
       update.append(" , " + cccMarcaSitua.getPaisOidPais().getId());
       update.append(" , '" + cccMarcaSitua.getCodMarcSitu()+ "'");
       if(cccMarcaSitua.getValObse() != null)
       {
          update.append(" , '" + cccMarcaSitua.getValObse() +"' ");  
       }else
       {
         update.append(" , NULL");
       }    
       update.append(" , '" + cccMarcaSitua.getIndCuenCast() + "'");
       update.append("    )  ");
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
               updateInter.append(" 'CCC_MARCA_SITUA', ");
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
         UtilidadesLog.info("DAOCccMarcaSituacion.guardarMarcaSituacion(CccMarcaSituaData cccMarcaSitua, Vector localizationLabels, HashMap userProperties): Entrada");
         return primaryKey;
     }
     public Vector query(CccMarcaSituaData cccMarcaSituaFrom, CccMarcaSituaData cccMarcaSituaTo, HashMap userProperties, Integer pageCount, Integer pageSize)throws MareException
     {
        UtilidadesLog.info("DAOCccMarcaSituacion.guardarMarcaSituacion(CccMarcaSituaData cccMarcaSituaFrom, CccMarcaSituaData cccMarcaSituaTo, HashMap userProperties, Integer pageCount, Integer pageSize): Entrada");
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
         query.append("   SELECT CCC_MARCA_SITUA.OID_MARC_SITU, CCC_MARCA_SITUA.COD_MARC_SITU,  ");
         query.append("           V_GEN_I18N_SICC.VAL_I18N, CCC_MARCA_SITUA.IND_CUEN_CAST, SEG_PAIS.OID_PAIS, CCC_MARCA_SITUA.VAL_OBSE ");
         query.append("           FROM CCC_MARCA_SITUA, V_GEN_I18N_SICC, SEG_PAIS  ");
         query.append("           WHERE CCC_MARCA_SITUA.PAIS_OID_PAIS = SEG_PAIS.OID_PAIS  ");
         if(cccMarcaSituaFrom.getPaisOidPais() != null)
         {
            query.append("               AND SEG_PAIS.OID_PAIS = " + cccMarcaSituaFrom.getPaisOidPais().getId());
         }
         if(cccMarcaSituaFrom.getCodMarcSitu() != null)
         {
            query.append("               AND  CCC_MARCA_SITUA.COD_MARC_SITU LIKE '" + cccMarcaSituaFrom.getCodMarcSitu() +"'");  
         }
         if(cccMarcaSituaFrom.getIndCuenCast() != null)
         {
             query.append("              AND CCC_MARCA_SITUA.IND_CUEN_CAST = '" + cccMarcaSituaFrom.getIndCuenCast() + "'");
         }
         query.append("                  AND V_GEN_I18N_SICC.ATTR_ENTI = 'CCC_MARCA_SITUA' ");
         query.append("                  AND V_GEN_I18N_SICC.ATTR_NUM_ATRI = 1 ");
         query.append("                  AND V_GEN_I18N_SICC.IDIO_OID_IDIO = 1 ");
         query.append("                  AND V_GEN_I18N_SICC.VAL_OID = CCC_MARCA_SITUA.OID_MARC_SITU ");
         if(cccMarcaSituaFrom.getDescripcion() != null)
         {
             query.append("              AND V_GEN_I18N_SICC.VAL_I18N LIKE '" + cccMarcaSituaFrom.getDescripcion() + "'");
         }
         if(cccMarcaSituaFrom.getId() != null)
         {
             query.append("              AND CCC_MARCA_SITUA.OID_MARC_SITU = " + cccMarcaSituaFrom.getId());
         }
         try {
               
              rs = bs.dbService.executeStaticQuery(query.toString());
         } catch (Exception ex) {
           
             ex.printStackTrace();
             UtilidadesLog.error("ERROR ", ex);
             throw new MareException(ex, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS));
         }
         int cant = rs.getRowCount();
         Vector result = new Vector();
         CccMarcaSituaData cccMarcaSitua = null;
         SegPaisViewData segPaisViewFrom = null; 
         String obser = null;
         
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
                   cccMarcaSitua = new CccMarcaSituaData();
                   cccMarcaSitua.setId(new Long(((BigDecimal)rs.getValueAt(i,"OID_MARC_SITU")).toString()));
                   cccMarcaSitua.setCodMarcSitu((String)rs.getValueAt(i,"COD_MARC_SITU"));
                   cccMarcaSitua.setDescripcion((String)rs.getValueAt(i,"VAL_I18N"));
                   if(((BigDecimal)rs.getValueAt(i, "IND_CUEN_CAST")).equals(new BigDecimal("1")))
                   {
                          cccMarcaSitua.setIndCuenCast("1");
                   }else
                   {
                          cccMarcaSitua.setIndCuenCast("0");
                   }
                   obser = (String)rs.getValueAt(i,"VAL_OBSE");
                   if(obser != null)
                   {
                       cccMarcaSitua.setValObse(obser);
                   }
                   segPaisViewFrom = new SegPaisViewData();
                   segPaisViewFrom.setId(new Long(((BigDecimal)rs.getValueAt(i,"OID_PAIS")).toString()));
                   cccMarcaSitua.setPaisOidPais(segPaisViewFrom);
                   result.add(cccMarcaSitua);
                 
                            
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
           UtilidadesLog.info("DAOCccMarcaSituacion.guardarMarcaSituacion(CccMarcaSituaData cccMarcaSituaFrom, CccMarcaSituaData cccMarcaSituaTo, HashMap userProperties, Integer pageCount, Integer pageSize): Salida");
           return result;
     }
     public void update(CccMarcaSituaData cccMarcaSitua, Vector localizationLabels)throws MareException
     {
        UtilidadesLog.info("DAOCccMarcaSituacion.update(CccMarcaSituaData cccMarcaSitua, Vector localizationLabels): Entrada");
        RecordSet rs = null;
        BelcorpService bs = UtilidadesEJB.getBelcorpService();
           
        StringBuffer update = new StringBuffer();
        StringBuffer updateInter = null;
        StringBuffer deleteInter = new StringBuffer();
        StringBuffer queryInter = null;
       
        deleteInter.append(" delete GEN_I18N_SICC_PAIS ");
        deleteInter.append(" where VAL_OID = " + cccMarcaSitua.getId());
        deleteInter.append(" and ATTR_NUM_ATRI = 1 ");
        deleteInter.append(" and ATTR_ENTI = 'CCC_MARCA_SITUA' ");
        
        try {
               int cantRegActualizados1 = bs.dbService.executeUpdate(deleteInter.toString());
               
        } catch (Exception ex) {
               ex.printStackTrace();                      
               throw new MareException(ex, UtilidadesError.armarCodigoError(
                                   CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS));           
        }
        update.append("UPDATE CCC_MARCA_SITUA SET ");
        update.append("        IND_CUEN_CAST = '" + cccMarcaSitua.getIndCuenCast()+ "'");
        if(cccMarcaSitua.getValObse() != null)
        {
          update.append("     , VAL_OBSE = '" + cccMarcaSitua.getValObse() +"'");
        }else
        {
          update.append("     , VAL_OBSE = NULL");
        }
        update.append(" where  OID_MARC_SITU = " + cccMarcaSitua.getId());
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
            updateInter.append(" 'CCC_MARCA_SITUA', ");
            updateInter.append(" 1, ");            
            updateInter.append(genDetaSiccData.getIdioOidIdio().getId() + ", ");
            updateInter.append(" '" + genDetaSiccData.getDeta() + "', ");
            updateInter.append(cccMarcaSitua.getId() + " )");   
              
            try {
                 int cantRegActualizados = bs.dbService.executeUpdate(updateInter.toString());
            } catch (Exception ex) {
                  ex.printStackTrace();
                  throw new MareException(ex, UtilidadesError.armarCodigoError(
                                           CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS));
            }
             
        }
        UtilidadesLog.info("DAOCccMarcaSituacion.update(CccMarcaSituaData cccMarcaSitua, Vector localizationLabels): Salida");
     }
     public void remove(Vector cccMarcaSituacion)throws MareException
     {
       UtilidadesLog.info("DAOCccMarcaSituacion.remove(Vector cccMarcaSituacion): Entrada");
       RecordSet rs = null;
       BelcorpService bs = UtilidadesEJB.getBelcorpService();
       StringBuffer update = new StringBuffer();
       StringBuffer updateInter = new StringBuffer();
       
       int cant = cccMarcaSituacion.size();
       CccMarcaSituaData cccMarcaSitua = null;
       String oidMarcaSituacion = "";
       for (int j = 0; j < cant; j++) {
           cccMarcaSitua = (CccMarcaSituaData)cccMarcaSituacion.get(j);
            
           oidMarcaSituacion = oidMarcaSituacion + "," + cccMarcaSitua.getId();
       }
       update.append("delete CCC_MARCA_SITUA  ");
       update.append("where OID_MARC_SITU in ( " + oidMarcaSituacion.substring(1) + ") ");
       
       updateInter.append("delete GEN_I18N_SICC_PAIS ");
       updateInter.append(" where VAL_OID in ( " + oidMarcaSituacion.substring(1) + ") ");
       updateInter.append(" and ATTR_NUM_ATRI = 1 ");
       updateInter.append(" and ATTR_ENTI = 'CCC_MARCA_SITUA' ");
       
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
       UtilidadesLog.info("DAOCccMarcaSituacion.remove(Vector cccMarcaSituacion): Salida");
     }
}
