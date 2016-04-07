package es.indra.sicc.logicanegocio.ccc;

import es.indra.belcorp.mso.CccBancoData;
import es.indra.belcorp.mso.CccSucurData;
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

public class DAOCccSucur {
    public DAOCccSucur() {
    }
    public Hashtable guardarSucursales(CccSucurData cccSucur, Vector localizationLabels, HashMap userProperties)throws MareException
     {
       UtilidadesLog.info("DAOCccSucur.guardarSucursales(CccSucurData cccSucur, Vector localizationLabels, HashMap userProperties): Entrada");
       RecordSet rs = null;
       BelcorpService bs = UtilidadesEJB.getBelcorpService();     
       StringBuffer update = new StringBuffer();
       RecordSet rsPK = null;
       StringBuffer query = new StringBuffer();      
       Long id = null;
       query.append(" SELECT CCC_SUCU_SEQ.NEXTVAL FROM DUAL ");
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
        update.append("INSERT INTO CCC_SUCUR ( ");
        update.append("            OID_SUCU ");
        update.append("            , CBAN_OID_BANC ");
        update.append("            , COD_SUCU ");
        update.append("            , VAL_DIRE ");
        update.append("            , VAL_CONT ");
        update.append("            , VAL_TFNO ");
        update.append("            , VAL_OBSE ");
        update.append("            , VAL_CIUD ");
        update.append("            , VAL_DEPA ");
        update.append("            , VAL_DIST ");
        update.append(" ) VALUES ( ");
        update.append(id);
        update.append(" , " + cccSucur.getCbanOidBanc().getId());
        update.append(" , '" + cccSucur.getCodSucu() + "' ");
        update.append(" , '" + cccSucur.getValDire() + "' ");
        if(cccSucur.getValCont() != null)
        {
          update.append(" , '" + cccSucur.getValCont() + "' ");
        }else
        {
          update.append(" , NULL ");
        }
        if(cccSucur.getValTfno() != null)
        {
          update.append(" , '" + cccSucur.getValTfno() + "'");
        }else
        {
          update.append(" , NULL");
        }
        if(cccSucur.getValObse() != null)
        {
          update.append(" , '" + cccSucur.getValObse() + "' ");
        }else
        {
          update.append(" , NULL");
        }
        if(cccSucur.getValCiud() != null)
        {
          update.append(" , '" + cccSucur.getValCiud() +"' ");
        }else
        {
          update.append(" , NULL");
        }
        if(cccSucur.getValDepa() != null)
        {
          update.append(" , '" + cccSucur.getValDepa() + "' ");
        }else
        {
          update.append(" ,NULL ");
        }
        if(cccSucur.getValDist() != null)
        {
          update.append(" , '" + cccSucur.getValDist() + "' ");
        }else
        {
          update.append(" , NULL ");
        }
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
         UtilidadesLog.info("DAOCccSucur.guardarSucursales(CccSucurData cccSucur, Vector localizationLabels, HashMap userProperties): Salida");
         return primaryKey;
     } 
     public Vector query(CccSucurData cccSucurFrom, CccSucurData cccSucurTo, HashMap userProperties, Integer pageCount, Integer pageSize )throws MareException
     {
       UtilidadesLog.info("DAOCccSucur.query(CccSucurData cccSucurFrom, CccSucurData cccSucurTo, HashMap userProperties, Integer pageCount, Integer pageSize ): Entrada");
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
       query.append("   SELECT CCC_SUCUR.OID_SUCU, CCC_BANCO.OID_BANC, CCC_BANCO.DES_BANC, ");
       query.append("          CCC_SUCUR.COD_SUCU, CCC_SUCUR.VAL_DIRE, CCC_SUCUR.VAL_CIUD,  ");
       query.append("          CCC_SUCUR.VAL_CONT, CCC_SUCUR.VAL_DEPA, CCC_SUCUR.VAL_DIST, ");
       query.append("          CCC_SUCUR.VAL_OBSE, CCC_SUCUR.VAL_TFNO ");
       query.append("          FROM CCC_SUCUR, CCC_BANCO ");
       query.append("          WHERE CCC_SUCUR.CBAN_OID_BANC = CCC_BANCO.OID_BANC ");
       if(cccSucurFrom.getCbanOidBanc() != null)
       {
         query.append("                AND CCC_BANCO.OID_BANC = " + cccSucurFrom.getCbanOidBanc().getId());  
       }
       if(cccSucurFrom.getCodSucu() != null)
       {
         query.append("                AND CCC_SUCUR.COD_SUCU LIKE  '" + cccSucurFrom.getCodSucu() + "' ");
       }
       if(cccSucurFrom.getId() != null)
       {
         query.append("                AND CCC_SUCUR.OID_SUCU = " + cccSucurFrom.getId());
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
       CccSucurData cccSucur = null;
       CccBancoData cccBanco = null;
       String ciudad = null;
       String cont = null;
       String dpto = null;
       String dist = null;
       String obser = null;
       String tel = null;
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
                   cccSucur = new CccSucurData();
                   cccSucur.setId(new Long(((BigDecimal)rs.getValueAt(i,"OID_SUCU")).toString()));
                   cccBanco = new CccBancoData();            
                   cccBanco.setId(new Long(((BigDecimal)rs.getValueAt(i,"OID_BANC")).toString()));
                   cccBanco.setDesBanc((String)rs.getValueAt(i,"DES_BANC"));
                   cccSucur.setCbanOidBanc(cccBanco);
                   cccSucur.setCodSucu((String)rs.getValueAt(i,"COD_SUCU"));
                   cccSucur.setValDire((String)rs.getValueAt(i,"VAL_DIRE"));
                   ciudad = (String)rs.getValueAt(i,"VAL_CIUD");
                   if(ciudad != null)
                   {
                     cccSucur.setValCiud(ciudad);
                   }
                   cont = (String)rs.getValueAt(i,"VAL_CONT");
                   if(cont != null)
                   {
                     cccSucur.setValCont(cont);
                   }
                   dpto = (String)rs.getValueAt(i,"VAL_DEPA");
                   if(dpto != null)
                   {
                     cccSucur.setValDepa(dpto);
                   }
                   dist = (String)rs.getValueAt(i,"VAL_DIST");
                   if(dist != null)
                   {
                     cccSucur.setValDist(dist);
                   }
                   obser = (String)rs.getValueAt(i,"VAL_OBSE");
                   if(obser != null)
                   {
                     cccSucur.setValObse( obser );
                   }
                   tel = (String)rs.getValueAt(i,"VAL_TFNO");
                   if(tel != null)
                   {
                     cccSucur.setValTfno( tel );
                   }
                      result.add(cccSucur);
                 
                            
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
          UtilidadesLog.info("DAOCccSucur.query(CccSucurData cccSucurFrom, CccSucurData cccSucurTo, HashMap userProperties, Integer pageCount, Integer pageSize ): Salida");
          return result;
                   
     } 
     public void update(CccSucurData cccSucur, Vector localizationLabels)throws MareException
     {
       UtilidadesLog.info("DAOCccSucur.update(CccSucurData cccSucur, Vector localizationLabels): Entrada");
       RecordSet rs = null;
       BelcorpService bs = UtilidadesEJB.getBelcorpService();
           
       StringBuffer update = new StringBuffer();
       update.append("  UPDATE CCC_SUCUR SET ");
       update.append("    VAL_DIRE = '" + cccSucur.getValDire() + "'");
       if(cccSucur.getValCiud() != null)
       {
         update.append(" , VAL_CIUD = '" + cccSucur.getValCiud() + "'");
       }else
       {
         update.append(" , VAL_CIUD = NULL");
       }
       if(cccSucur.getValCont() != null)
       {
         update.append("  , VAL_CONT = '" + cccSucur.getValCont() +  "'");
       }else
       {
         update.append("  , VAL_CONT = NULL ");
       }
       if(cccSucur.getValDepa() != null)
       {
         update.append(", VAL_DEPA = '" +cccSucur.getValDepa() +"'");
       }else
       {
         update.append(" , VAL_DEPA = NULL ");
       }
       if(cccSucur.getValDist() != null)
       {
         update.append(" , VAL_DIST = '" + cccSucur.getValDist() +"' ");
       }else
       {
         update.append("  , VAL_DIST = NULL");
       }
       if(cccSucur.getValObse() != null)
       {
         update.append(" , VAL_OBSE = '" + cccSucur.getValObse() +"'");
       }else
       {
         update.append(" , VAL_OBSE = NULL ");
       }
       if(cccSucur.getValTfno() != null)
       {
          update.append("  , VAL_TFNO = '" + cccSucur.getValTfno() +"'");
       }else
       {
         update.append("   , VAL_TFNO = NULL");
       }
       
       update.append("where OID_SUCU = " + cccSucur.getId());
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
      UtilidadesLog.info("DAOCccSucur.update(CccSucurData cccSucur, Vector localizationLabels): Salida"); 
     }
     public void remove(Vector cccSucursales)throws MareException
     {
       UtilidadesLog.info("DAOCccSucur.remove(Vector cccSucursales): Entrada");
       RecordSet rs = null;
       BelcorpService bs = UtilidadesEJB.getBelcorpService();
       StringBuffer update = new StringBuffer();
       StringBuffer updateInter = new StringBuffer();
       
       int cant = cccSucursales.size();
       CccSucurData cccSucur = null;
       String oidSucursales = "";
       for (int j = 0; j < cant; j++) {
           cccSucur = (CccSucurData)cccSucursales.get(j);
            
           oidSucursales = oidSucursales + "," + cccSucur.getId();
       }
       update.append("delete CCC_SUCUR  ");
       update.append("where OID_SUCU in ( " + oidSucursales.substring(1) + ") ");
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
       
     }
}
