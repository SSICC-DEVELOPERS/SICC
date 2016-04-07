package es.indra.sicc.logicanegocio.ccc;

import es.indra.belcorp.mso.CccProceData;
import es.indra.belcorp.mso.CccSubprData;
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
import java.util.Vector;

public class DAOCccProceSubproce {
    public DAOCccProceSubproce() {
    }
    public Vector query(CccProceData cccProceFrom, CccProceData cccProceTo, HashMap userProperties, Integer pageCount, Integer pageSize )throws MareException
     {
       UtilidadesLog.info("DAOCccProceSubproce.query(CccProceData cccProceFrom, CccProceData cccProceTo, HashMap userProperties, Integer pageCount, Integer pageSize): Entrada");
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
       query.append("  SELECT CCC_PROCE.OID_PROC, CCC_PROCE.COD_PROC, ");
       query.append("         CCC_PROCE.DES_PROC, SEG_PAIS.OID_PAIS,  ");
       query.append("         CCC_PROCE.VAL_OBSE, CCC_PROCE.IND_CV_DIRE ");
       query.append("         FROM CCC_PROCE, SEG_PAIS  ");
       query.append("         WHERE CCC_PROCE.PAIS_OID_PAIS = SEG_PAIS.OID_PAIS ");
       if(cccProceFrom.getCodProc() != null)
       {
          query.append("            AND CCC_PROCE.COD_PROC LIKE  '" + cccProceFrom.getCodProc() + "' ");
       }
       if(cccProceFrom.getDesProc() != null)
       {
         query.append("             AND CCC_PROCE.DES_PROC LIKE '" + cccProceFrom.getDesProc() +"' ");
       }
       if(cccProceFrom.getId() != null)
       {
         query.append("              AND CCC_PROCE.OID_PROC = " + cccProceFrom.getId());
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
      CccProceData cccProce = null;
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
                    cccProce = new CccProceData();
                    cccProce.setId(new Long(((BigDecimal)rs.getValueAt(i,"OID_PROC")).toString()));
                    cccProce.setCodProc((String)rs.getValueAt(i,"COD_PROC"));
                    cccProce.setDesProc((String)rs.getValueAt(i,"DES_PROC"));
                    segPaisViewFrom = new SegPaisViewData();
                    segPaisViewFrom.setId(new Long(((BigDecimal)rs.getValueAt(i,"OID_PAIS")).toString()));
                    cccProce.setPaisOidPais(segPaisViewFrom);
                    obser = (String)rs.getValueAt(i,"VAL_OBSE");
                    UtilidadesLog.debug("Obser: " + obser );
                    if(obser != null)
                    {
                       UtilidadesLog.info("Entra al" + obser);
                       cccProceFrom.setValObse(obser);
                    }
                    if(((BigDecimal)rs.getValueAt(i,"IND_CV_DIRE")).equals(new BigDecimal("1")))
                    {
                         UtilidadesLog.info("Entra");
                         cccProce.setIndCvDire(Boolean.TRUE.TRUE);
                    }else
                    {
                         cccProce.setIndCvDire(Boolean.FALSE.FALSE);
                    }
                    
                    result.add(cccProce);
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
           UtilidadesLog.info("DAOCccProceSubproce.query(CccProceData cccProceFrom, CccProceData cccProceTo, HashMap userProperties, Integer pageCount, Integer pageSize): Salida");          
           return result;           
     }
     public Vector query(CccProceData cccProceFrom, CccProceData cccProceTo, HashMap userProperties)throws MareException
     {
        UtilidadesLog.info("DAOCccProceSubproce.query(CccProceData cccProceFrom, CccProceData cccProceTo, HashMap userProperties): Entrada ");
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
        query.append(" SELECT CCC_PROCE.OID_PROC, CCC_PROCE.DES_PROC ");
        query.append("        FROM CCC_PROCE ");
        try{
             
               rs = bs.dbService.executeStaticQuery(query.toString());
              
        } catch (Exception ex) {
              
             throw new MareException(ex, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS));
        }
         if(!rs.esVacio())
         {
           for(int i= 0; i < rs.getRowCount(); i++){
                 CccProceData cccProce = new CccProceData();
                 cccProce.setId( new Long(((BigDecimal)rs.getValueAt(i,"OID_PROC")).toString()));
                 cccProce.setDesProc((String)rs.getValueAt(i,"DES_PROC"));
                 resultado.add(cccProce);
           }
         }  
        UtilidadesLog.info("DAOCccProceSubproce.query(CccProceData cccProceFrom, CccProceData cccProceTo, HashMap userProperties): Salida "); 
        return resultado;  
    }
    public Vector query(CccSubprData cccSubprFrom, CccSubprData cccSubprTo, HashMap userProperties, Integer pageCount, Integer pageSize) throws MareException
    {
       UtilidadesLog.info("DAOCccProceSubproce.query(CccSubprData cccSubprFrom, CccSubprData cccSubprTo, HashMap userProperties, Integer pageCount, Integer pageSize): Entrada");
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
       query.append("  SELECT CCC_SUBPR.OID_SUBP, CCC_PROCE.DES_PROC, CCC_PROCE.OID_PROC, ");
       query.append("         CCC_SUBPR.COD_SUBP, CCC_SUBPR.DES_SUBP, CCC_SUBPR.VAL_INDI_GEST_MARC, ");
       query.append("         CCC_SUBPR.VAL_INDI_ACTU_CUOT, CCC_SUBPR.VAL_INDI_TIPO_ABON,  ");
       query.append("         CCC_SUBPR.VAL_INDI_CONS, CCC_SUBPR.VAL_OBSE ");
       query.append("         FROM CCC_SUBPR, CCC_PROCE ");
       query.append("              WHERE CCC_SUBPR.CCPR_OID_PROC = CCC_PROCE.OID_PROC  ");
       if(cccSubprFrom.getCcprOidProc() != null)
       {
           query.append("                AND CCC_PROCE.OID_PROC = " + cccSubprFrom.getCcprOidProc().getId());  
       }
       if(cccSubprFrom.getCodSubp() != null)
       {
           query.append("               AND CCC_SUBPR.COD_SUBP = " + cccSubprFrom.getCodSubp());
       }
       if(cccSubprFrom.getId() != null)
       {
           query.append("              AND CCC_SUBPR.OID_SUBP = " + cccSubprFrom.getId());
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
      CccSubprData cccSubpr = null;
      CccProceData cccProce = null;
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
                       cccSubpr = new CccSubprData() ;
                       cccSubpr.setId(new Long(((BigDecimal)rs.getValueAt(i,"OID_SUBP")).toString()));
                       cccProce = new  CccProceData(); 
                       cccProce.setId( new Long(((BigDecimal)rs.getValueAt(i,"OID_PROC")).toString()));
                       cccProce.setDesProc((String)rs.getValueAt(i,"DES_PROC"));
                       cccSubpr.setCcprOidProc(cccProce);
                       cccSubpr.setCodSubp(new Long(((BigDecimal)rs.getValueAt(i,"COD_SUBP")).toString()));
                       cccSubpr.setDesSubp((String)rs.getValueAt(i,"DES_SUBP"));
                       if(((BigDecimal)rs.getValueAt(i,"VAL_INDI_GEST_MARC")).equals(new BigDecimal("1")))
                       {
                           cccSubpr.setValIndiGestMarc(Boolean.TRUE);  
                       }else
                       {
                          cccSubpr.setValIndiGestMarc(Boolean.FALSE);
                       }
                       if(((BigDecimal)rs.getValueAt(i,"VAL_INDI_ACTU_CUOT")).equals(new BigDecimal("1")))
                       {
                         cccSubpr.setValIndiActuCuot(Boolean.TRUE);  
                       }else
                       {
                         cccSubpr.setValIndiActuCuot(Boolean.FALSE);
                       }
                       if(((BigDecimal)rs.getValueAt(i,"VAL_INDI_TIPO_ABON")).equals(new BigDecimal("1")))
                       {
                         cccSubpr.setValIndiTipoAbon(Boolean.TRUE);  
                       }else
                       {
                         cccSubpr.setValIndiTipoAbon(Boolean.FALSE);
                       }
                       cccSubpr.setValIndiCons((String)rs.getValueAt(i,"VAL_INDI_CONS"));
                       obser = (String)rs.getValueAt(i,"VAL_OBSE");
                       if(obser != null)
                       {
                         cccSubpr.setValObse(obser);
                       }
                         result.add(cccSubpr);
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
           UtilidadesLog.info("DAOCccProceSubproce.query(CccSubprData cccSubprFrom, CccSubprData cccSubprTo, HashMap userProperties, Integer pageCount, Integer pageSize): Salida");
           return result;            
                       
                       
        }
        public void update(CccSubprData cccSubpr, Vector localizationLabels)throws MareException
        {
          UtilidadesLog.info("DAOCccProceSubproce.update(CccSubpr cccSubpr, Vector localizationLabels): Entrada");
          RecordSet rs = null;
          BelcorpService bs = UtilidadesEJB.getBelcorpService();
           
          StringBuffer update = new StringBuffer();
          update.append("    UPDATE CCC_SUBPR SET ");
          update.append("            VAL_INDI_CONS = '" + cccSubpr.getValIndiCons() +"'");
          if(cccSubpr.getValIndiGestMarc().booleanValue())
          {
              update.append("        ,VAL_INDI_GEST_MARC = 1");
          }else
          {
              update.append("        ,VAL_INDI_GEST_MARC = 0");
          }
          if(cccSubpr.getValIndiActuCuot().booleanValue())
          {
            update.append("          , VAL_INDI_ACTU_CUOT = 1");
          }else
          {
            update.append("          , VAL_INDI_ACTU_CUOT = 0 ");
          }
         if(cccSubpr.getValIndiTipoAbon().booleanValue())
         {
           update.append("            , VAL_INDI_TIPO_ABON = 1");
         }else
         {
           update.append("            , VAL_INDI_TIPO_ABON = 0");
         }
         if(cccSubpr.getValObse() != null)
         {
           update.append("            , VAL_OBSE = '" + cccSubpr.getValObse() + "'");
         }
         update.append(" where OID_SUBP = " + cccSubpr.getId());
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
        UtilidadesLog.info("DAOCccProceSubproce.update(CccSubpr cccSubpr, Vector localizationLabels): Salida");  
      }
}
