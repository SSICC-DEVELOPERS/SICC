package es.indra.sicc.logicanegocio.cob;

import es.indra.belcorp.mso.CobGuionArgumCabecData;
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

public class DAOGuiaArgumenCabec {
    public DAOGuiaArgumenCabec() 
    {
    }
    
    public Vector query(CobGuionArgumCabecData cobGuionArgumCabecFrom, CobGuionArgumCabecData cobGuionArgumCabecTo, HashMap userProperties, Integer pageCount, Integer pageSize) throws MareException
       {UtilidadesLog.info("DAOCobGuiasArgumCabec.query(CobGuionArgumCabecData cobGuionArgumCabecFrom, CobGuionArgumCabecData cobGuionArgumCabecTo, HashMap userProperties, Integer pageCount, Integer pageSize):Entrada");
       
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
       
           query.append(" SELECT a.OID_GUIO_ARGU_CABE, a.COD_GUIA_ARGU, b.OID_PAIS, c.VAL_I18N, a.VAL_OBSE ");
           query.append(" FROM COB_GUION_ARGUM_CABEC a, SEG_PAIS b, GEN_I18N_SICC_PAIS c ");
           query.append(" WHERE a.PAIS_OID_PAIS = b.OID_PAIS ");
           query.append(" AND c.ATTR_ENTI = 'COB_GUION_ARGUM_CABEC'");
           query.append(" AND c.ATTR_NUM_ATRI = 1");
           query.append(" AND c.IDIO_OID_IDIO = 1");
           query.append(" AND c.VAL_OID = a.OID_GUIO_ARGU_CABE");
           
           
            if(cobGuionArgumCabecFrom.getId()!= null){
               query.append(" AND OID_GUIO_ARGU_CABE = " + cobGuionArgumCabecFrom.getId());
           }
            if(cobGuionArgumCabecFrom.getCodGuiaArgu()!= null){
               query.append(" AND COD_GUIA_ARGU like '" + cobGuionArgumCabecFrom.getCodGuiaArgu() + "'");
           }
           if(cobGuionArgumCabecFrom.getDescripcion()!= null){
               query.append(" AND VAL_I18N like '" + cobGuionArgumCabecFrom.getDescripcion() + "' ");
           }
           if(cobGuionArgumCabecFrom.getValObse()!= null){
               query.append(" AND VAL_OBSE like '" + cobGuionArgumCabecFrom.getValObse() + "' ");
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
           
           CobGuionArgumCabecData cobGuionArgumCabec = null;
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
                     cobGuionArgumCabec= new CobGuionArgumCabecData();
                      segPais = new SegPaisViewData();
                      String obse = null;
                     
                    
                    
                    
                     cobGuionArgumCabec.setId(Long.valueOf(((BigDecimal)rs.getValueAt(i,"OID_GUIO_ARGU_CABE")).toString())); 
                     cobGuionArgumCabec.setCodGuiaArgu((String)rs.getValueAt(i,"COD_GUIA_ARGU"));
                     cobGuionArgumCabec.setDescripcion((String)rs.getValueAt(i,"VAL_I18N"));
                     segPais.setId(Long.valueOf(((BigDecimal)rs.getValueAt(i,"OID_PAIS")).toString())); 
                     cobGuionArgumCabec.setPaisOidPais(segPais);
                     obse = (String)rs.getValueAt(i,"VAL_OBSE");
                     if(obse != null)
                     {
                          cobGuionArgumCabec.setValObse(String.valueOf(obse));
                        
                     }
                                       
                     result.add(cobGuionArgumCabec);
               }catch(Exception ex)
               {
                 ex.printStackTrace();
               }
               } else {
                  break;
               }
           }
         
       UtilidadesLog.info("DAOCobGuiasArgumCabec.query(CobGuionArgumCabecData cobGuionArgumCabecFrom, CobGuionArgumCabecData cobGuionArgumCabecTo, HashMap userProperties, Integer pageCount, Integer pageSize):Salida");
       
           return result;
       }
        public void update(CobGuionArgumCabecData cobGuionArgumCabec, Vector localizationLabels) throws MareException
       {   UtilidadesLog.info("DAOCobGuiasArgumCabec.update(CobGuionArgumCabecData cobGuionArgumCabec, Vector localizationLabels):Entrada");
           RecordSet rs = null;
           BelcorpService bs = UtilidadesEJB.getBelcorpService();
           
           // Borrar los registros internalizacion
           StringBuffer deleteInter = new StringBuffer();
           
           deleteInter.append(" delete GEN_I18N_SICC_PAIS ");
           deleteInter.append(" where VAL_OID = " + cobGuionArgumCabec.getId());
           deleteInter.append(" and ATTR_NUM_ATRI = 1 ");
           deleteInter.append(" and ATTR_ENTI = 'COB_GUION_ARGUM_CABEC' ");
           
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
               updateInter.append(" 'COB_GUION_ARGUM_CABEC', ");
               updateInter.append(" 1, ");            
               updateInter.append(genDetaSiccData.getIdioOidIdio().getId() + ", ");
               updateInter.append(" '" + genDetaSiccData.getDeta() + "', ");
               updateInter.append(cobGuionArgumCabec.getId() + " )");   
           
               try {
                   int cantRegActualizados = bs.dbService.executeUpdate(updateInter.toString());
               } catch (Exception ex) {
                   ex.printStackTrace();
                   throw new MareException(ex, UtilidadesError.armarCodigoError(
                                           CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS));
               }
           }
           StringBuffer update = new StringBuffer();
           
           update.append("UPDATE COB_GUION_ARGUM_CABEC SET ");
           if(cobGuionArgumCabec.getValObse()!= null)
           {
               update.append(" VAL_OBSE = '" + cobGuionArgumCabec.getValObse() + "'");
           }
           else
           {
               update.append(" VAL_OBSE = NULL");
           }
          
           update.append(" WHERE OID_GUIO_ARGU_CABE = " + cobGuionArgumCabec.getId());   
           
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
       
      
           UtilidadesLog.info("DAOCobGuiasArgumCabec.update(CobGuionArgumCabecData cobGuionArgumCabec, Vector localizationLabels):Salida");
           
       }
        public void remove(Vector entities) throws MareException
       {   UtilidadesLog.info("DAOCobGuiasArgumCabec.remove(Vector entities):Entrada");
           RecordSet rs = null;
           BelcorpService bs = UtilidadesEJB.getBelcorpService();
           StringBuffer update = new StringBuffer();
           StringBuffer updateInter = new StringBuffer();
           
           int cant = entities.size();
           CobGuionArgumCabecData cobGuiaArgCabec = null;
           String oids = "";
           
           for (int j = 0; j < cant; j++) {
               cobGuiaArgCabec = (CobGuionArgumCabecData)entities.get(j);
                
               oids = oids + "," + cobGuiaArgCabec.getId();
           }
           
           update.append("delete COB_GUION_ARGUM_CABEC ");
           update.append("where OID_GUIO_ARGU_CABE in ( " + oids.substring(1) + ") ");
           
           updateInter.append("delete GEN_I18N_SICC_PAIS ");
           updateInter.append(" where VAL_OID in ( " + oids.substring(1) + ") ");
           updateInter.append(" and ATTR_NUM_ATRI = 1 ");
           updateInter.append(" and ATTR_ENTI = 'COB_GUION_ARGUM_CABEC' ");
           
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
           
         
           UtilidadesLog.info("DAOCobGuiasArgumCabec.remove(Vector entities):Salida");
       }
       public Hashtable guardar(CobGuionArgumCabecData cobGuionArgumCabec, Vector localizationLabels, HashMap userProperties) throws MareException
       {   UtilidadesLog.info("DAOCobGuiasArgumCabec.guardar(CobGuionArgumCabecData cobGuionArgumCabec, Vector localizationLabels, HashMap userProperties):Entrada");
           RecordSet rs = null;
           BelcorpService bs = UtilidadesEJB.getBelcorpService();
           
           StringBuffer update = new StringBuffer();        
           RecordSet rsPK = null;
           StringBuffer query = new StringBuffer();      
           Long id = null;
           
           query.append(" SELECT COB_GACA_SEQ.NEXTVAL FROM DUAL");         
           
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
           
           update.append(" INSERT INTO COB_GUION_ARGUM_CABEC ( ");
           update.append("OID_GUIO_ARGU_CABE, "); 
           update.append("COD_GUIA_ARGU, "); 
           update.append("PAIS_OID_PAIS, "); 
           update.append("VAL_OBSE ");
           update.append(" ) VALUES ( ");
           update.append(id + ", ");
           update.append("'" + cobGuionArgumCabec.getCodGuiaArgu() + "', ");
           update.append(cobGuionArgumCabec.getPaisOidPais().getId());
           
           if(cobGuionArgumCabec.getValObse()!= null)
           {
               update.append(",'" +  cobGuionArgumCabec.getValObse() + "'");
           }
           else
           {
               update.append(", NULL");
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
                   
               updateInter.append(" INSERT INTO GEN_I18N_SICC_PAIS ( ");
               updateInter.append("OID_I18N, "); 
               updateInter.append("ATTR_ENTI, "); 
               updateInter.append("ATTR_NUM_ATRI, "); 
               updateInter.append("IDIO_OID_IDIO, "); 
               updateInter.append("VAL_I18N, ");                 
               updateInter.append("VAL_OID "); 
               updateInter.append(" ) VALUES ( ");
               updateInter.append(idInter + ", ");
               updateInter.append(" 'COB_GUION_ARGUM_CABEC', ");
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
       
       
       UtilidadesLog.info("DAOCobGuiasArgumCabec.guardar(CobGuionArgumCabecData cobGuionArgumCabec, Vector localizationLabels, HashMap userProperties):Salida");
           return primaryKey;
       }
       
    }

