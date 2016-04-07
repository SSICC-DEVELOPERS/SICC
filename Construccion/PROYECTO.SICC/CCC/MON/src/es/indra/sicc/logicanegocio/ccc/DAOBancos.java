package es.indra.sicc.logicanegocio.ccc;

import es.indra.belcorp.mso.CccBancoData;
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

public class DAOBancos {
    public DAOBancos() {
    }
    public Hashtable guardarBancos(CccBancoData cccBanco, Vector localizationLabels, HashMap userProperties)throws MareException
     {
         UtilidadesLog.info("DAOBancos.guardarBancos(CccBancoData cccBanco, Vector localizationLabels, HashMap userProperties): Entrada");
       
         RecordSet rs = null;
         BelcorpService bs = UtilidadesEJB.getBelcorpService();     
         StringBuffer update = new StringBuffer();
         RecordSet rsPK = null;
         StringBuffer query = new StringBuffer();      
         Long id = null;
         query.append(" SELECT CCC_CBAN_SEQ.NEXTVAL FROM DUAL ");
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
         update.append(" INSERT INTO CCC_BANCO (  ");
         update.append("        OID_BANC ");
         update.append("        , PAIS_OID_PAIS ");
         update.append("        ,  COD_BANC ");
         update.append("        ,  COD_BRIO ");
         update.append("        , COD_SWIF_INFO");
         update.append("         , DES_BANC ");
         update.append("         , VAL_OBS_BANC ");
         update.append("   ) VALUES ( ");
         update.append(id);
         update.append(" , " + cccBanco.getPaisOidPais().getId());
         update.append(" , '" + cccBanco.getCodBanc() + "'");
         update.append(" , '" + cccBanco.getCodBrio() + "'");
         if(cccBanco.getCodSwifInfo() != null)
         {
         
              update.append(" , '" + cccBanco.getCodSwifInfo() + "'");
         }else
         {
              update.append("  , NULL ");
         }
         update.append(" , '" + cccBanco.getDesBanc() + "' ");
         if( cccBanco.getValObsBanc() != null)
         {
              update.append(" , '" + cccBanco.getValObsBanc() + "' ");
         }else
         {
              update.append(" , NULL "); 
         }
         update.append("      ) ");
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
         UtilidadesLog.info("DAOBancos.guardarBancos(CccBancoData cccBanco, Vector localizationLabels, HashMap userProperties): Salida");
         return primaryKey;
     }
     public Vector query(CccBancoData cccBancoFrom, CccBancoData cccBancoTo, HashMap userProperties, Integer pageCount, Integer pageSize)throws MareException
     {
        UtilidadesLog.info("DAOBancos.query(CccBancoData cccBancoFrom, CccBancoData cccBancoTo, HashMap userProperties, Integer pageCount, Integer pageSize): Entrada");
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
        query.append(" SELECT CCC_BANCO.OID_BANC, CCC_BANCO.COD_BANC, ");
        query.append("        CCC_BANCO.DES_BANC, CCC_BANCO.COD_BRIO, ");
        query.append("        CCC_BANCO.COD_SWIF_INFO, SEG_PAIS.OID_PAIS, CCC_BANCO.VAL_OBS_BANC ");
        query.append("        FROM CCC_BANCO, SEG_PAIS ");
        query.append("          WHERE CCC_BANCO.PAIS_OID_PAIS = SEG_PAIS.OID_PAIS ");
        if(cccBancoFrom.getPaisOidPais() != null)
        {
           query.append("             AND  SEG_PAIS.OID_PAIS = " + cccBancoFrom.getPaisOidPais().getId());
        }
        if(cccBancoFrom.getCodBanc() != null)
        {
          query.append("              AND CCC_BANCO.COD_BANC LIKE  '" + cccBancoFrom.getCodBanc() + "' ");
        }
        if(cccBancoFrom.getDesBanc() != null)
        {
          query.append("              AND CCC_BANCO.DES_BANC LIKE '" + cccBancoFrom.getDesBanc() + "' ");
        }
        if(cccBancoFrom.getCodBrio() != null)
        {
          query.append("              AND CCC_BANCO.COD_BRIO LIKE '" + cccBancoFrom.getCodBrio() + "' ");
        }
        if(cccBancoFrom.getCodSwifInfo() != null)
        {
           query.append("             AND CCC_BANCO.COD_SWIF_INFO LIKE '" + cccBancoFrom.getCodSwifInfo() + "' ");
        }
        if(cccBancoFrom.getId() != null)
        {
           query.append("            AND CCC_BANCO.OID_BANC = " + cccBancoFrom.getId());
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
            CccBancoData cccBanco = null;
            SegPaisViewData segPaisViewFrom = null; 
            String codswift = null;
            String valObser = null;
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
                      cccBanco = new CccBancoData();
                      cccBanco.setId(new Long(((BigDecimal)rs.getValueAt(i,"OID_BANC")).toString()));
                      cccBanco.setCodBanc((String)rs.getValueAt(i,"COD_BANC"));
                      cccBanco.setDesBanc((String)rs.getValueAt(i,"DES_BANC"));
                      cccBanco.setCodBrio((String)rs.getValueAt(i,"COD_BRIO"));
                      codswift = (String)rs.getValueAt(i,"COD_SWIF_INFO");
                      if(codswift != null)
                      {
                        cccBanco.setCodSwifInfo(codswift);
                      }
                       segPaisViewFrom = new SegPaisViewData();
                       segPaisViewFrom.setId( new Long(((BigDecimal)rs.getValueAt(i,"OID_PAIS")).toString()));
                       cccBanco.setPaisOidPais(segPaisViewFrom);
                       valObser = (String)rs.getValueAt(i,"VAL_OBS_BANC");
                       if(valObser != null){
                             cccBanco.setValObsBanc(valObser);
                       }      
                       result.add(cccBanco);
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
            UtilidadesLog.info("DAOBancos.query(CccBancoData cccBancoFrom, CccBancoData cccBancoTo, HashMap userProperties, Integer pageCount, Integer pageSize): Salida");
            return result; 
     }
     public void update(CccBancoData cccBanco, Vector localizationLabels)throws MareException
     {
       UtilidadesLog.info("DAOBancos.update(CccBancoData cccBanco, Vector localizationLabels): Entrada");
       RecordSet rs = null;
       BelcorpService bs = UtilidadesEJB.getBelcorpService();
          
       StringBuffer update = new StringBuffer();
       update.append(" UPDATE CCC_BANCO SET ");
       update.append("         COD_BRIO = '" + cccBanco.getCodBrio() +"'");
       if(cccBanco.getCodSwifInfo() != null){
           update.append("         , COD_SWIF_INFO = '" + cccBanco.getCodSwifInfo() + "' ");
       }else
       {
           update.append("          , COD_SWIF_INFO = NULL ");
       }
       update.append("              , DES_BANC = '" + cccBanco.getDesBanc() + "'");
       if(cccBanco.getValObsBanc() != null)
       {
          update.append("          ,  VAL_OBS_BANC = '" + cccBanco.getValObsBanc() + "' ");
       }else
       {
          update.append("           , VAL_OBS_BANC = NULL");
       }
       update.append("       where OID_BANC = " + cccBanco.getId());
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
       UtilidadesLog.info("DAOBancos.update(CccBancoData cccBanco, Vector localizationLabels): Salida"); 
     }
     public void remove(Vector cccBancos)throws MareException
     {
           UtilidadesLog.info("DAOBancos.remove(Vector cccBancos):Entrada");
           RecordSet rs = null;
           BelcorpService bs = UtilidadesEJB.getBelcorpService();
           StringBuffer update = new StringBuffer();
           StringBuffer updateInter = new StringBuffer();
           
           int cant = cccBancos.size();
           CccBancoData cccBanco = null;
           String oidBancos = "";
           for (int j = 0; j < cant; j++) {
               cccBanco = (CccBancoData)cccBancos.get(j);
                
               oidBancos = oidBancos + "," + cccBanco.getId();
           }
           update.append("delete CCC_BANCO  ");
           update.append("where OID_BANC in ( " + oidBancos.substring(1) + ") ");
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
           
         UtilidadesLog.info("DAOBancos.remove(Vector cccBancos): Salida");
     }
     
}
