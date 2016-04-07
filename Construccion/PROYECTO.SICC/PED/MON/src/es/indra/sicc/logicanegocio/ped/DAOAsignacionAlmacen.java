package es.indra.sicc.logicanegocio.ped;

import es.indra.belcorp.mso.BelAlmacData;
import es.indra.belcorp.mso.PedAsignAlmacData;
import es.indra.belcorp.mso.SegAccesData;
import es.indra.belcorp.mso.SegCanalViewData;
import es.indra.belcorp.mso.SegMarcaData;
import es.indra.belcorp.mso.SegPaisViewData;
import es.indra.belcorp.mso.SegSubacData;
import es.indra.mare.common.exception.MareException;
import es.indra.mare.common.mgu.manager.Property;
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

public class DAOAsignacionAlmacen {
    public DAOAsignacionAlmacen() {
    }
    public Vector query(BelAlmacData belAlmacFrom)throws MareException
     {
        UtilidadesLog.info("DAOAsignacionAlmacen.query(BelAlmacData belAlmacFrom): Entrada ");
        RecordSet rs = new RecordSet();
        StringBuffer query = new StringBuffer();
        Vector parametros = new Vector();
        BelcorpService bs;
        try{
                 bs = BelcorpService.getInstance();
           
             } catch(MareMiiServiceNotFoundException ex){
                   
                 throw new MareException(ex, UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_PEDIR_UN_SERVICIO_MARE));
             }
         query.append(" SELECT BEL_ALMAC.OID_ALMA, V_GEN_I18N_SICC.VAL_I18N");
         query.append(" FROM BEL_ALMAC, V_GEN_I18N_SICC ");
         query.append(" WHERE V_GEN_I18N_SICC.ATTR_ENTI = 'BEL_ALMAC' ");
         query.append(" AND V_GEN_I18N_SICC.IDIO_OID_IDIO = 1 ");
         query.append(" AND V_GEN_I18N_SICC.ATTR_NUM_ATRI = 1 ");
         query.append(" AND V_GEN_I18N_SICC.VAL_OID = BEL_ALMAC.OID_ALMA ");
         query.append(" ORDER BY V_GEN_I18N_SICC.VAL_I18N ");
         try{
             
                 rs = bs.dbService.executeStaticQuery(query.toString());
              
             } catch (Exception ex) {
              
                 throw new MareException(ex, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS));
             }
         if(!rs.esVacio())
         {
           for(int i= 0; i < rs.getRowCount(); i++){
             BelAlmacData salida = new  BelAlmacData();
             salida.setId(new Long(((BigDecimal) rs.getValueAt(i,"OID_ALMA")).toString()));
             salida.setDescripcion((String)rs.getValueAt(i,"VAL_I18N"));
             parametros.add(salida);
           }
         }
         
         UtilidadesLog.info("DAOAsignacionAlmacen.query(BelAlmacData belAlmacFrom): Salida");
             
         return parametros;  
     }
     public Vector query(SegCanalViewData segCanalViewFrom, SegCanalViewData segCanalViewTo, HashMap userProperties, String usuario) throws MareException
     {
       UtilidadesLog.info("DAOAsignacionAlmacenen.query(SegCanalViewData segCanalViewFrom, SegCanalViewData segCanalViewTo, HashMap userProperties): Entrada ");
       RecordSet rs = new RecordSet();
       StringBuffer query = new StringBuffer();
       StringBuffer queryUser = new StringBuffer();
       Vector parametros = new Vector();
       BelcorpService bs;      
      
       try{
            bs = BelcorpService.getInstance();
           
        } catch(MareMiiServiceNotFoundException ex){
                   
                 throw new MareException(ex, UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_PEDIR_UN_SERVICIO_MARE));
        }
        
        Property userID = (Property)userProperties.get("userID");
        query.append("SELECT V_GEN_I18N_SICC.VAL_OID, V_GEN_I18N_SICC.VAL_I18N ");
        query.append(" FROM  V_GEN_I18N_SICC");
        query.append(" WHERE V_GEN_I18N_SICC.ATTR_ENTI = 'SEG_CANAL' ");
        query.append(" AND V_GEN_I18N_SICC.IDIO_OID_IDIO = 1");
        query.append(" AND V_GEN_I18N_SICC.ATTR_NUM_ATRI = 1");
        query.append(" AND V_GEN_I18N_SICC.VAL_OID  IN (SELECT OID_CANA from VCA_SEG_CANAL where COD_USUA= '"+ userID.getValue()+"')" );
        try
        {
           rs = bs.dbService.executeStaticQuery(query.toString());
        
        }catch (Exception ex) {
                  ex.printStackTrace();
                 throw new MareException(ex, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS));
        }  
        if(!rs.esVacio())
        {
            for(int i= 0; i < rs.getRowCount(); i++){
              SegCanalViewData salida = new SegCanalViewData(); 
              salida.setId(new Long(((BigDecimal) rs.getValueAt(i,"VAL_OID")).toString()));
              salida.setDescripcion((String)rs.getValueAt(i, "VAL_I18N"));
              parametros.add(salida); 
            }
        }
        UtilidadesLog.info("DAOAsignacionAlmacenen.query(SegCanalViewData segCanalViewFrom, SegCanalViewData segCanalViewTo, HashMap userProperties): Salida ");
        return parametros;      
     }
     public Vector query(SegAccesData segAccesFrom, SegAccesData segAccesTo, HashMap userProperties, Boolean applyStructuralSecurity) throws MareException
     {
       UtilidadesLog.info("DAOAsignacionAlmacen.query(SegAccesData segAccesFrom, SegAccesData segAccesTo, HashMap userProperties): Entrada ");
       RecordSet rs = new RecordSet();
       StringBuffer query = new StringBuffer();
       StringBuffer queryUser = new StringBuffer();
       Vector parametros = new Vector();
       BelcorpService bs;  
       try
       {
           bs = BelcorpService.getInstance();
              
       }catch(Exception ex)
       {
          throw new MareException(ex, UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_PEDIR_UN_SERVICIO_MARE));
       }
        if(!applyStructuralSecurity.booleanValue())
           {
           query.append(" SELECT V_GEN_I18N_SICC.VAL_OID, V_GEN_I18N_SICC.VAL_I18N ");
           query.append(" FROM V_GEN_I18N_SICC, SEG_ACCES");
           query.append(" WHERE V_GEN_I18N_SICC.ATTR_ENTI = 'SEG_ACCES'");
           query.append(" AND V_GEN_I18N_SICC.ATTR_NUM_ATRI = 1");
           query.append(" AND V_GEN_I18N_SICC.IDIO_OID_IDIO = 1");
           query.append(" AND V_GEN_I18N_SICC.VAL_OID = SEG_ACCES.OID_ACCE " );
           query.append(" AND SEG_ACCES.CANA_OID_CANA = "+ segAccesFrom.getCanaOidCana().getId());
           }else
           {
             Property userID = (Property)userProperties.get("userID");
             query.append(" SELECT  DISTINCT V_GEN_I18N_SICC.VAL_OID, V_GEN_I18N_SICC.VAL_I18N");
             query.append(" FROM V_GEN_I18N_SICC, SEG_ACCES");
             query.append(" WHERE V_GEN_I18N_SICC.ATTR_ENTI = 'SEG_ACCES'");
             query.append(" AND V_GEN_I18N_SICC.ATTR_NUM_ATRI = 1");
             query.append(" AND V_GEN_I18N_SICC.IDIO_OID_IDIO = 1");
             query.append(" AND V_GEN_I18N_SICC.VAL_OID  IN (SELECT OID_ACCE from VCA_SEG_ACCES where COD_USUA= '" + userID.getValue() + "')");
             query.append("  AND SEG_ACCES.CANA_OID_CANA = "+ segAccesFrom.getCanaOidCana().getId());
             query.append("  AND V_GEN_I18N_SICC.VAL_OID =  SEG_ACCES.OID_ACCE");
           }
           
       try
        {
           rs = bs.dbService.executeStaticQuery(query.toString());
        
        }catch (Exception ex) {
              
                 throw new MareException(ex, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS));
        }
        if(!rs.esVacio())
        {
           try{
           for(int i= 0; i < rs.getRowCount(); i++){
             SegAccesData salida = new SegAccesData();          
             salida.setId(new Long(((BigDecimal)rs.getValueAt(i,"VAL_OID")).toString()));
             salida.setDescripcion((String)rs.getValueAt(i,"VAL_I18N"));          
             parametros.add(salida);
           }
           }catch(Exception ex)
           {
             ex.printStackTrace();
           }
        }
        UtilidadesLog.info("DAOAsignacionAlmacen.query(SegAccesData segAccesFrom, SegAccesData segAccesTo, HashMap userProperties): Entrada ");
        return parametros;
     }
     public Vector query(SegSubacData segSubacFrom, SegSubacData segSubacTo, HashMap userProperties, Boolean applyStructuralSecurity) throws MareException
     {
       UtilidadesLog.info("DAOAsignacionAlmacen.query(SegSubacData segSubacFrom, SegSubacData segSubacTo, HashMap userProperties): Entrada");
      RecordSet rs = new RecordSet();
         StringBuffer query = new StringBuffer();
         StringBuffer queryUser = new StringBuffer();
         BelcorpService bs;
         Vector resultado = new Vector();

         try {
             bs = BelcorpService.getInstance();
         } catch (MareMiiServiceNotFoundException e) {
             UtilidadesLog.error("ERROR ", e);
             throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_PEDIR_UN_SERVICIO_MARE));
         }

      
           if(!applyStructuralSecurity.booleanValue())
           {
               query.append(" SELECT V_GEN_I18N_SICC.VAL_OID,V_GEN_I18N_SICC.VAL_I18N");
               query.append(" FROM V_GEN_I18N_SICC, SEG_SUBAC");
               query.append(" WHERE V_GEN_I18N_SICC.ATTR_ENTI = 'SEG_SUBAC'");
               query.append(" AND V_GEN_I18N_SICC.ATTR_NUM_ATRI = 1");
               query.append(" AND V_GEN_I18N_SICC.IDIO_OID_IDIO = 1");
               query.append(" AND V_GEN_I18N_SICC.VAL_OID = SEG_SUBAC.OID_SBAC");
               query.append(" AND SEG_SUBAC.ACCE_OID_ACCE  =" + segSubacFrom.getAcceOidAcce().getId()) ;
           }else{
               Property userID = (Property)userProperties.get("userID");
               query.append(" SELECT DISTINCT V_GEN_I18N_SICC.VAL_OID,V_GEN_I18N_SICC.VAL_I18N");
               query.append(" FROM V_GEN_I18N_SICC, VCA_SEG_SUBAC ");
               query.append(" WHERE V_GEN_I18N_SICC.ATTR_ENTI = 'SEG_SUBAC'");
               query.append(" AND V_GEN_I18N_SICC.ATTR_NUM_ATRI = 1");
               query.append(" AND V_GEN_I18N_SICC.IDIO_OID_IDIO = 1");
               query.append(" AND V_GEN_I18N_SICC.VAL_OID  IN (SELECT OID_SBAC from VCA_SEG_SUBAC where COD_USUA= '"+ userID.getValue()+"')") ;
               query.append(" AND VCA_SEG_SUBAC.ACCE_OID_ACCE =" + segSubacFrom.getAcceOidAcce().getId());
               query.append(" AND V_GEN_I18N_SICC.VAL_OID = VCA_SEG_SUBAC.OID_SBAC");
           }
       try
        {
           rs = bs.dbService.executeStaticQuery(query.toString());
        
        }catch (Exception ex) {
              
                 throw new MareException(ex, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS));
        }
        if(!rs.esVacio())
        {
           for(int i = 0; i < rs.getRowCount(); i++)
           {
              SegSubacData salida = new SegSubacData();
              salida.setId(new Long(((BigDecimal) rs.getValueAt(i,"VAL_OID")).toString()));
              salida.setDescripcion((String)rs.getValueAt(i,"VAL_I18N"));
              resultado.add(salida);
           }        
        }
        UtilidadesLog.info("DAOAsignacionAlmacen.query(SegAccesData segAccesFrom, SegAccesData segAccesTo, HashMap userProperties): Salida");
       return resultado;
     }
     public Hashtable guardarAsignacionAlmacen(PedAsignAlmacData pedAsignAlmac, Vector localizationLabels, HashMap userProperties) throws MareException
     {
         UtilidadesLog.info("DAOAsignacionAlmacen.guardarAsignacionAlmacen(PedAsignAlmacData pedAsignAlmac, Vector localizationLabels, HashMap userProperties): Entrada "); 
         RecordSet rs = null;
         BelcorpService bs = UtilidadesEJB.getBelcorpService();     
         StringBuffer update = new StringBuffer();
         RecordSet rsPK = null;
         StringBuffer query = new StringBuffer();      
         Long id = null;
         query.append(" SELECT PED_ALMA_SEQ.NEXTVAL FROM DUAL ");
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
         update.append("INSERT INTO PED_ASIGN_ALMAC ( ");
         update.append(" OID_ASIG_ALMA,");
         update.append(" SBAC_OID_SBAC,");
         update.append(" MARC_OID_MARC,");
         update.append(" ALMC_OID_ALMA,");
         update.append(" PAIS_OID_PAIS");
         update.append(" ) VALUES ( ");
         update.append(id );
         update.append(", " + pedAsignAlmac.getSbacOidSbac().getId());
         update.append(", " + pedAsignAlmac.getMarcOidMarc().getId());
         update.append(", " + pedAsignAlmac.getAlmcOidAlma().getId());
         update.append(", " + pedAsignAlmac.getPaisOidPais().getId());
         update.append( " ) ");
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
         Hashtable primaryKey = new Hashtable();
         primaryKey.put("id", id);        
         UtilidadesLog.info("DAOAsignacionAlmacen.guardarAsignacionAlmacen(PedAsignAlmacData pedAsignAlmac, Vector localizationLabels, HashMap userProperties): Salida");
         return primaryKey;   
           
     }
     public Vector query(PedAsignAlmacData pedAsignAlmacFrom, PedAsignAlmacData pedAsignAlmacTo, HashMap userProperties,  Integer pageCount, Integer pageSize, String usuario)throws MareException
     {
       UtilidadesLog.info("DAOAsignacionAlmacen.query(PedAsignAlmacData pedAsignAlmacFrom, PedAsignAlmacData pedAsignAlmacTo, HashMap userProperties,  Integer pageCount, Integer pageSize): Entrada");    
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
                           
           UtilidadesLog.debug("query1");
           try{
           query.append(" SELECT PED_ASIGN_ALMAC.OID_ASIG_ALMA, SEG_MARCA.DES_MARC,   ");
           query.append(" SUBACCESO.VAL_I18N SUBACC, ALMACEN.VAL_I18N ALMACEN, SEG_MARCA.OID_MARC, ");
           query.append(" SUBACCESO.VAL_OID OIDSUB, ALMACEN.VAL_OID OIDALMAC, ");
           query.append("  pais.VAL_I18N DES, pais.VAL_OID OIDPAIS, ");
           query.append("  acceso.VAL_I18N DESACCESO, acceso.VAL_OID OIDACCESO,");
           query.append("  canal.VAL_I18N DESCANAL, canal.VAL_OID OIDCANAL");
           query.append("  FROM PED_ASIGN_ALMAC, V_GEN_I18N_SICC SUBACCESO,");
           query.append("       V_GEN_I18N_SICC ALMACEN, SEG_MARCA, BEL_ALMAC, SEG_SUBAC, ");
           query.append("       seg_pais, v_gen_i18n_sicc pais,  ");
           query.append("       seg_canal, seg_acces, v_gen_i18n_sicc acceso, v_gen_i18n_sicc canal");
           query.append(" WHERE PED_ASIGN_ALMAC.ALMC_OID_ALMA = BEL_ALMAC.OID_ALMA ");
           if(pedAsignAlmacFrom.getAlmcOidAlma() != null)
           {
             query.append(" AND BEL_ALMAC.OID_ALMA = "+ pedAsignAlmacFrom.getAlmcOidAlma().getId() );
           }
           query.append(" AND PED_ASIGN_ALMAC.SBAC_OID_SBAC = SEG_SUBAC.OID_SBAC ");
           if(pedAsignAlmacFrom.getSbacOidSbac() != null)
           {
             query.append("AND SEG_SUBAC.OID_SBAC = " + pedAsignAlmacFrom.getSbacOidSbac().getId());
           }
           query.append(" AND seg_subac.ACCE_OID_ACCE = seg_acces.OID_ACCE ");
           query.append(" AND seg_acces.CANA_OID_CANA = seg_canal.OID_CANA ");
           query.append(" AND PED_ASIGN_ALMAC.MARC_OID_MARC = SEG_MARCA.OID_MARC ");
           query.append(" AND PED_ASIGN_ALMAC.PAIS_OID_PAIS = SEG_PAIS.OID_PAIS");
           
           if(pedAsignAlmacFrom.getPaisOidPais() != null){
             UtilidadesLog.debug(" oidPais: " +pedAsignAlmacFrom.getPaisOidPais().getId() );
             query.append(" AND SEG_PAIS.OID_PAIS  = " + pedAsignAlmacFrom.getPaisOidPais().getId());
           }
           
           if(pedAsignAlmacFrom.getMarcOidMarc() != null){
             UtilidadesLog.debug(" oidMarca: " + pedAsignAlmacFrom.getMarcOidMarc().getId() );
           query.append(" AND SEG_MARCA.OID_MARC = " + pedAsignAlmacFrom.getMarcOidMarc().getId());   
           }
           
           query.append(" AND ALMACEN.ATTR_ENTI = 'BEL_ALMAC' ");
           query.append(" AND ALMACEN.IDIO_OID_IDIO = 1 ");
           query.append(" AND ALMACEN.ATTR_NUM_ATRI = 1 ");       
           query.append(" AND ALMACEN.VAL_OID = BEL_ALMAC.OID_ALMA");
           
           query.append(" AND SUBACCESO.ATTR_ENTI = 'SEG_SUBAC'");
           query.append(" AND SUBACCESO.IDIO_OID_IDIO = 1");
           query.append(" AND SUBACCESO.ATTR_NUM_ATRI = 1");                  
           query.append(" AND SUBACCESO.VAL_OID = SEG_SUBAC.OID_SBAC");
           
           query.append(" AND pais.attr_enti = 'SEG_PAIS' ");
           query.append(" AND pais.idio_oid_idio = 1 ");
           query.append(" AND pais.attr_num_atri = 1 ");
           query.append(" AND pais.val_oid = seg_pais.OID_PAIS");
           
           query.append(" AND acceso.attr_enti = 'SEG_ACCES' ");
           query.append(" AND acceso.idio_oid_idio = 1 ");
           query.append(" AND acceso.attr_num_atri = 1");         
           query.append(" AND acceso.val_oid = seg_acces.OID_ACCE ");
           
           query.append(" AND canal.attr_enti = 'SEG_CANAL' ");
           query.append(" AND canal.idio_oid_idio = 1 ");
           query.append(" AND canal.attr_num_atri = 1 ");                   
           query.append(" AND canal.val_oid = seg_canal.OID_CANA");
          
           if(pedAsignAlmacFrom.getId() != null)
           {
             query.append(" AND PED_ASIGN_ALMAC.OID_ASIG_ALMA = " + pedAsignAlmacFrom.getId());
           }
           }catch(Exception ex)
           {
             ex.printStackTrace();
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
            PedAsignAlmacData pedAsignAlmaFrom = null;
            SegMarcaData segMarcaFrom = null;
            SegSubacData segSubAcFrom = null;
            BelAlmacData belAlmacFrom = null;
            SegPaisViewData segPaisViewFrom = null; 
            SegAccesData segAccesFrom = null;
            SegCanalViewData segCanalViewData = null;
            BigDecimal oidMarca = null;
            BigDecimal oidSubacceso = null;
            BigDecimal oidAlmacen = null;
            BigDecimal oidPais = null;
            BigDecimal oidAcceso = null;
            BigDecimal oidCanal = null;
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
                     pedAsignAlmaFrom  = new PedAsignAlmacData();
                     pedAsignAlmaFrom.setId(new Long(((BigDecimal) rs.getValueAt(i,"OID_ASIG_ALMA")).toString()));
                     oidMarca = (BigDecimal)rs.getValueAt(i,"OID_MARC");
                     
                     segMarcaFrom = new SegMarcaData();
                     segMarcaFrom.setId(Long.valueOf(oidMarca.toString()));
                     segMarcaFrom.setDesMarc((String)rs.getValueAt(i,"DES_MARC"));
                    
                     pedAsignAlmaFrom.setMarcOidMarc(segMarcaFrom);
                     
                    
                     oidSubacceso = (BigDecimal)rs.getValueAt(i,"OIDSUB");
                    
                     segSubAcFrom = new SegSubacData();
                     segSubAcFrom.setId(Long.valueOf(oidSubacceso.toString()));
                     segSubAcFrom.setDescripcion((String)rs.getValueAt(i,"SUBACC"));
                     oidAcceso = (BigDecimal)rs.getValueAt(i, "OIDACCESO");
                     
                     segAccesFrom = new SegAccesData();
                     segAccesFrom.setId(Long.valueOf(oidAcceso.toString()));
                     segAccesFrom.setDescripcion((String)rs.getValueAt(i,"DESACCESO"));
                     oidCanal = (BigDecimal)rs.getValueAt(i,"OIDCANAL");
                     UtilidadesLog.debug("oid: " + oidCanal);
                     
                     segCanalViewData  = new SegCanalViewData();
                     segCanalViewData.setId(Long.valueOf(oidCanal.toString()));
                     segCanalViewData.setDescripcion((String)rs.getValueAt(i,"DESCANAL"));
                     segAccesFrom.setCanaOidCana(segCanalViewData);
                     segSubAcFrom.setAcceOidAcce(segAccesFrom);
                     
                     pedAsignAlmaFrom.setSbacOidSbac(segSubAcFrom);
                    
                     oidAlmacen = (BigDecimal)rs.getValueAt(i,"OIDALMAC");
                     UtilidadesLog.debug(" oid: " + oidAlmacen);               
                     belAlmacFrom = new BelAlmacData();
                     belAlmacFrom.setId(Long.valueOf(oidAlmacen.toString()));
                     belAlmacFrom.setDescripcion((String)rs.getValueAt(i,"ALMACEN"));
                     pedAsignAlmaFrom.setAlmcOidAlma(belAlmacFrom);
                    
                     oidPais = (BigDecimal)rs.getValueAt(i,"OIDPAIS");
                     
                     segPaisViewFrom = new SegPaisViewData();
                     segPaisViewFrom.setId(Long.valueOf(oidPais.toString()));
                     segPaisViewFrom.setDescripcion((String)rs.getValueAt(i, "DES"));
                     pedAsignAlmaFrom.setPaisOidPais(segPaisViewFrom);
                    
                     
                     UtilidadesLog.debug(" OID: " + oidAcceso);
                     
                    
                     
                     result.add(pedAsignAlmaFrom);
                 
                            
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
            UtilidadesLog.info("DAOAsignacionAlmacen.query(PedAsignAlmacData pedAsignAlmacFrom, PedAsignAlmacData pedAsignAlmacTo, HashMap userProperties,  Integer pageCount, Integer pageSize): Salida");
            return result; 
            
     }
     public Vector query(SegSubacData segSubacFrom, SegSubacData segSubacTo, HashMap userProperties) throws MareException
     {
       UtilidadesLog.info("DAOAsignacionAlmacen.query(SegSubacData segSubacFrom, SegSubacData segSubacTo, HashMap userProperties): Entrada");
       RecordSet rs = new RecordSet();
       StringBuffer query = new StringBuffer();
       Vector parametros = new Vector();
       BelcorpService bs;  
       try
       {
           bs = BelcorpService.getInstance();
              
       }catch(Exception ex)
       {
          throw new MareException(ex, UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_PEDIR_UN_SERVICIO_MARE));
       }
               query.append(" SELECT V_GEN_I18N_SICC.VAL_OID,V_GEN_I18N_SICC.VAL_I18N");
               query.append(" FROM V_GEN_I18N_SICC, SEG_SUBAC");
               query.append(" WHERE V_GEN_I18N_SICC.ATTR_ENTI = 'SEG_SUBAC'");
               query.append(" AND V_GEN_I18N_SICC.ATTR_NUM_ATRI = 1");
               query.append(" AND V_GEN_I18N_SICC.IDIO_OID_IDIO = 1");
               query.append(" AND V_GEN_I18N_SICC.VAL_OID = SEG_SUBAC.OID_SBAC");
               query.append(" AND SEG_SUBAC.ACCE_OID_ACCE  =" + segSubacFrom.getAcceOidAcce().getId()) ;
       try
        {
           rs = bs.dbService.executeStaticQuery(query.toString());
        
        }catch (Exception ex) {
                 ex.printStackTrace();
                 throw new MareException(ex, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS));
        }
        if(!rs.esVacio())
        {
           for(int i = 0; i < rs.getRowCount(); i++)
           {
              SegSubacData salida = new SegSubacData();
              salida.setId(new Long(((BigDecimal) rs.getValueAt(i,"VAL_OID")).toString()));
              salida.setDescripcion((String)rs.getValueAt(i,"VAL_I18N"));
              parametros.add(salida);
           }        
        }
        UtilidadesLog.info("DAOAsignacionAlmacen.query(SegAccesData segAccesFrom, SegAccesData segAccesTo, HashMap userProperties): Salida");
       return parametros;
     }
     public void remove(Vector pedAsignAlmacFrom ) throws MareException
     {
           UtilidadesLog.info("DAOAsignacionAlmacen.remove(Vector pedAsigAlmacFrom): Entrada");
           RecordSet rs = null;
           BelcorpService bs = UtilidadesEJB.getBelcorpService();
           StringBuffer update = new StringBuffer();
           StringBuffer updateInter = new StringBuffer();
           
           int cant = pedAsignAlmacFrom.size();
           PedAsignAlmacData pedFormuData = null;
           String oidAsignacionAlmacen = "";
           
           for (int j = 0; j < cant; j++) {
           pedFormuData = (PedAsignAlmacData)pedAsignAlmacFrom .get(j);
                
               oidAsignacionAlmacen = oidAsignacionAlmacen + "," + pedFormuData.getId();
           }
           update.append(" delete PED_ASIGN_ALMAC ");
           update.append("where OID_ASIG_ALMA in ( " + oidAsignacionAlmacen.substring(1) + ") ");
            try {
               int cantRegActualizados = bs.dbService.executeUpdate(update.toString());
            
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
           UtilidadesLog.info("DAOAsignacionAlmacen.remove(Vector pedAsigAlmacFrom): Entrada");
     }
     public Vector query(SegAccesData segAccesFrom, SegAccesData segAccesTo, HashMap userProperties)throws MareException
     {
       UtilidadesLog.info("DAOAsignacionAlmacen.query(SegAccesData segAccesFrom, SegAccesData segAccesTo, HashMap userProperties): Entrada ");
       RecordSet rs = new RecordSet();
       StringBuffer query = new StringBuffer();
       StringBuffer queryUser = new StringBuffer();
       Vector parametros = new Vector();
       BelcorpService bs;  
       try
       {
           bs = BelcorpService.getInstance();
              
       }catch(Exception ex)
       {
          throw new MareException(ex, UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_PEDIR_UN_SERVICIO_MARE));
       }
        
           query.append(" SELECT V_GEN_I18N_SICC.VAL_OID, V_GEN_I18N_SICC.VAL_I18N ");
           query.append(" FROM V_GEN_I18N_SICC, SEG_ACCES");
           query.append(" WHERE V_GEN_I18N_SICC.ATTR_ENTI = 'SEG_ACCES'");
           query.append(" AND V_GEN_I18N_SICC.ATTR_NUM_ATRI = 1");
           query.append(" AND V_GEN_I18N_SICC.IDIO_OID_IDIO = 1");
           query.append(" AND V_GEN_I18N_SICC.VAL_OID = SEG_ACCES.OID_ACCE " );
           query.append(" AND SEG_ACCES.CANA_OID_CANA = "+ segAccesFrom.getCanaOidCana().getId());
           
       try
        {
           rs = bs.dbService.executeStaticQuery(query.toString());
        
        }catch (Exception ex) {
              
                 throw new MareException(ex, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS));
        }
        if(!rs.esVacio())
        {
           try{
           for(int i= 0; i < rs.getRowCount(); i++){
             SegAccesData salida = new SegAccesData();          
             salida.setId(new Long(((BigDecimal)rs.getValueAt(i,"VAL_OID")).toString()));
             salida.setDescripcion((String)rs.getValueAt(i,"VAL_I18N"));          
             parametros.add(salida);
           }
           }catch(Exception ex)
           {
             ex.printStackTrace();
           }
        }
        UtilidadesLog.info("DAOAsignacionAlmacen.query(SegAccesData segAccesFrom, SegAccesData segAccesTo, HashMap userProperties): Entrada ");
        return parametros; 
     }
}
