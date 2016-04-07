package es.indra.sicc.logicanegocio.ccc;

import es.indra.belcorp.mso.CccCuentContaData;
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

public class DAOCuentaConta {
    public DAOCuentaConta() {
    }
    public Hashtable guardarCuentaContable(CccCuentContaData cccCuentConta, Vector localizationLabels, HashMap userProperties)throws MareException
     {
         UtilidadesLog.info("DAOCuentaContable.guardarCuentaContable(CccCuentContaData cccCuentConta, Vector localizationLabels, HashMap userProperties): Entrada");
         RecordSet rs = null;
         BelcorpService bs = UtilidadesEJB.getBelcorpService();     
         StringBuffer updateInter = null;
         StringBuffer update = new StringBuffer();
         RecordSet rsPK = null;
         StringBuffer query = new StringBuffer();      
         Long id = null;
         query.append(" SELECT CCC_CUCO_SEQ.NEXTVAL FROM DUAL ");
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
         update.append(" INSERT INTO CCC_CUENT_CONTA ( ");
         update.append("             OID_CUEN_CONT  ");
         update.append("             , PAIS_OID_PAIS ");
         update.append("             , COD_CUEN_CONT ");
         update.append("             , COD_CUEN_SAP ");
         update.append("             , VAL_OBSE ");
         update.append(" ) VALUES (   ");
         update.append(id);
         update.append(" ," + cccCuentConta.getPaisOidPais().getId());
         update.append(" , '" + cccCuentConta.getCodCuenCont()+ "' ");
         update.append(" , '" + cccCuentConta.getCodCuenSap() + "' ");
         if(cccCuentConta.getValObse() != null)
         {
            update.append(" , '" + cccCuentConta.getValObse() + "' ");
         }else
         {
             update.append(" , NULL ");
         }
         update.append("  ) ");
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
               updateInter.append(" 'CCC_CUENT_CONTA', ");
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
         UtilidadesLog.info("DAOCuentaContable.guardarCuentaContable(CccCuentContaData cccCuentConta, Vector localizationLabels, HashMap userProperties): Salida");
         return primaryKey;
     }
     public Vector query(CccCuentContaData cccCuentContaFrom, CccCuentContaData cccCuentContaTo, HashMap userProperties, Integer pageCount, Integer pageSize)throws MareException
     {
        UtilidadesLog.info("DAOCuentaContable.query(CccCuentContaData cccCuentContaFrom, CccCuentContaData cccCuentContaTo, HashMap userProperties, Integer pageCount, Integer pageSize): Entrada");
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
        query.append("  SELECT  CCC_CUENT_CONTA.OID_CUEN_CONT, CCC_CUENT_CONTA.COD_CUEN_CONT, ");
        query.append("          V_GEN_I18N_SICC.VAL_I18N, CCC_CUENT_CONTA.COD_CUEN_SAP, SEG_PAIS.OID_PAIS, ");
        query.append("          CCC_CUENT_CONTA.VAL_OBSE ");
        query.append("          FROM CCC_CUENT_CONTA, SEG_PAIS, V_GEN_I18N_SICC  ");
        query.append("          WHERE CCC_CUENT_CONTA.PAIS_OID_PAIS = SEG_PAIS.OID_PAIS  ");
        if(cccCuentContaFrom.getPaisOidPais() != null)
        {
           query.append("              AND SEG_PAIS.OID_PAIS = " + cccCuentContaFrom.getPaisOidPais().getId());
        }
        if(cccCuentContaFrom.getCodCuenCont() != null)
        {
           query.append("              AND CCC_CUENT_CONTA.COD_CUEN_CONT LIKE '" + cccCuentContaFrom.getCodCuenCont() + "' ");
        }
        if(cccCuentContaFrom.getCodCuenSap() != null)
        {
           query.append("              AND CCC_CUENT_CONTA.COD_CUEN_SAP LIKE '" + cccCuentContaFrom.getCodCuenSap() + "' ");
        }
        query.append("                 AND V_GEN_I18N_SICC.ATTR_ENTI = 'CCC_CUENT_CONTA' ");
        query.append("                 AND V_GEN_I18N_SICC.ATTR_NUM_ATRI = 1  ");
        query.append("                 AND V_GEN_I18N_SICC.IDIO_OID_IDIO = 1 ");
        query.append("                 AND V_GEN_I18N_SICC.VAL_OID = CCC_CUENT_CONTA.OID_CUEN_CONT  ");
        if(cccCuentContaFrom.getDescripcion() != null)
        {
           query.append("              AND V_GEN_I18N_SICC.VAL_I18N LIKE '" + cccCuentContaFrom.getDescripcion() + "'"); 
        }
        if(cccCuentContaFrom.getId() != null)
        {
           query.append("              AND CCC_CUENT_CONTA.OID_CUEN_CONT = " + cccCuentContaFrom.getId());
        }
        try {
              rs = bs.dbService.executeStaticQuery(query.toString());
        } catch (Exception ex) {
             UtilidadesLog.error("ERROR ", ex);
             throw new MareException(ex, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS));
        }
        int cant = rs.getRowCount();
        Vector result = new Vector();
        CccCuentContaData cccCuentConta = null;
        SegPaisViewData segPaisViewFrom = null; 
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
                     cccCuentConta = new CccCuentContaData(); 
                     cccCuentConta.setId(new Long(((BigDecimal)rs.getValueAt(i,"OID_CUEN_CONT")).toString()));
                     cccCuentConta.setCodCuenCont((String)rs.getValueAt(i,"COD_CUEN_CONT"));
                     cccCuentConta.setCodCuenSap((String)rs.getValueAt(i,"COD_CUEN_SAP"));
                     cccCuentConta.setDescripcion((String)rs.getValueAt(i,"VAL_I18N"));
                     cccCuentConta.setValObse((String)rs.getValueAt(i,"VAL_OBSE"));
                     segPaisViewFrom = new SegPaisViewData();
                     segPaisViewFrom.setId( new Long(((BigDecimal)rs.getValueAt(i,"OID_PAIS")).toString()));
                     cccCuentConta.setPaisOidPais(segPaisViewFrom);
                     result.add(cccCuentConta);
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
            UtilidadesLog.info("DAOCuentaContable.query(CccCuentContaData cccCuentContaFrom, CccCuentContaData cccCuentContaTo, HashMap userProperties, Integer pageCount, Integer pageSize): Salida");
            return result;
     }
     public void update(CccCuentContaData cccCuentConta, Vector localizationLabels)throws MareException
     {
        UtilidadesLog.info("DAOCuentaContable.update(CccCuentContaData cccCuentConta, Vector localizationLabels): Entrada");
        RecordSet rs = null;
        BelcorpService bs = UtilidadesEJB.getBelcorpService();
           
        StringBuffer update = new StringBuffer();
        StringBuffer updateInter = null;
        StringBuffer deleteInter = new StringBuffer();
        StringBuffer queryInter = null;
       
        deleteInter.append(" delete GEN_I18N_SICC_PAIS ");
        deleteInter.append(" where VAL_OID = " + cccCuentConta.getId());
        deleteInter.append(" and ATTR_NUM_ATRI = 1 ");
        deleteInter.append(" and ATTR_ENTI = 'CCC_CUENT_CONTA' ");
        
        try {
               int cantRegActualizados1 = bs.dbService.executeUpdate(deleteInter.toString());
               
        } catch (Exception ex) {
               ex.printStackTrace();                      
               throw new MareException(ex, UtilidadesError.armarCodigoError(
                                   CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS));           
        }
         update.append("UPDATE CCC_CUENT_CONTA SET ");
         update.append("        COD_CUEN_SAP = '" + cccCuentConta.getCodCuenSap() + "'");
         update.append("        , VAL_OBSE = '" + cccCuentConta.getValObse() + "'");
         update.append(" where OID_CUEN_CONT = " + cccCuentConta.getId());
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
            updateInter.append(" 'CCC_CUENT_CONTA', ");
            updateInter.append(" 1, ");            
            updateInter.append(genDetaSiccData.getIdioOidIdio().getId() + ", ");
            updateInter.append(" '" + genDetaSiccData.getDeta() + "', ");
            updateInter.append(cccCuentConta.getId() + " )");   
              
            try {
                 int cantRegActualizados = bs.dbService.executeUpdate(updateInter.toString());
            } catch (Exception ex) {
                  ex.printStackTrace();
                  throw new MareException(ex, UtilidadesError.armarCodigoError(
                                           CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS));
            }
             
        }
        UtilidadesLog.info("DAOCuentaContable.update(CccCuentContaData cccCuentConta, Vector localizationLabels): Salida");
     }
     public void remove(Vector cccCuentaContable)throws MareException
     {
           UtilidadesLog.info("DAOCuentaContable.remove(Vector cccCuentaContable): Entrada");
           RecordSet rs = null;
           BelcorpService bs = UtilidadesEJB.getBelcorpService();
           StringBuffer update = new StringBuffer();
           StringBuffer updateInter = new StringBuffer();
           
           int cant = cccCuentaContable.size();
           CccCuentContaData cccCuentConta = null;
           String oidCuentaContable = "";
           for (int j = 0; j < cant; j++) {
               cccCuentConta = (CccCuentContaData)cccCuentaContable.get(j);
                
               oidCuentaContable = oidCuentaContable + "," + cccCuentConta.getId();
           }
           update.append("delete CCC_CUENT_CONTA  ");
           update.append("where OID_CUEN_CONT in ( " + oidCuentaContable.substring(1) + ") ");
           
           updateInter.append("delete GEN_I18N_SICC_PAIS ");
           updateInter.append(" where VAL_OID in ( " + oidCuentaContable.substring(1) + ") ");
           updateInter.append(" and ATTR_NUM_ATRI = 1 ");
           updateInter.append(" and ATTR_ENTI = 'CCC_CUENT_CONTA' ");
           
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
           UtilidadesLog.info("DAOCuentaContable.remove(Vector cccCuentaContable): Salida");
     }
}
