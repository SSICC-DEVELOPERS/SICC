package es.indra.sicc.logicanegocio.mae;

import es.indra.belcorp.mso.MaeClaseTarjeData;
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

public class DAOClaseTarjeta {
    public DAOClaseTarjeta() {
    }
    public Hashtable guardarClaseTarjeta(MaeClaseTarjeData maeClaseTarje, Vector localizationLabels, HashMap userProperties)throws MareException
      {
        UtilidadesLog.info("DAOClaseTarjeta.guardarClaseTarjeta(MaeClaseTarjeData maeClaseTarje, Vector localizationLabels, HashMap userProperties): Entrada");
        RecordSet rs = null;
        BelcorpService bs = UtilidadesEJB.getBelcorpService();     
        StringBuffer update = new StringBuffer();
        StringBuffer updateInter = new StringBuffer();
        RecordSet rsPK = null;
        StringBuffer query = new StringBuffer();      
        Long id = null;
        query.append(" SELECT MAE_CLTA_SEQ.NEXTVAL FROM DUAL ");
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
         update.append(" INSERT INTO MAE_CLASE_TARJE ( ");
         update.append("  OID_CLAS_TARJ, ");
         update.append("  COD_CLAS_TARJ, ");
         update.append("  DES_CLAS_TARJ");
         update.append(" ) VALUES ( ");
         update.append(id);
         update.append(", '"+ maeClaseTarje.getCodClasTarj()+ "' ");
         update.append(" , '" + maeClaseTarje.getDesClasTarj() + "'");
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
          Hashtable primaryKey = new Hashtable();
          primaryKey.put("id", id); 
          UtilidadesLog.info("DAOClaseTarjeta.guardarClaseTarjeta(MaeClaseTarjeData maeClaseTarje, Vector localizationLabels, HashMap userProperties): salida");  
          return primaryKey; 
      }
      public Vector query(MaeClaseTarjeData maeClaseTarjeFrom, MaeClaseTarjeData maeClaseTarjeTo, HashMap userProperties, Integer pageCount, Integer pageSize)throws MareException
      {
        UtilidadesLog.info("DAOClaseTarjeta.query(MaeClaseTarjeData maeClaseTarjeFrom, MaeClaseTarjeData maeClaseTarjeTo, HashMap userProperties, Integer pageCount, Integer pageSize): Entrada");
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
        query.append(" SELECT MAE_CLASE_TARJE.OID_CLAS_TARJ, MAE_CLASE_TARJE.COD_CLAS_TARJ,");  
        query.append("        MAE_CLASE_TARJE.DES_CLAS_TARJ");
        query.append("        FROM MAE_CLASE_TARJE  ");
        query.append("  where 1 = 1");
        if(maeClaseTarjeFrom.getCodClasTarj() != null){
              query.append("  AND MAE_CLASE_TARJE.COD_CLAS_TARJ LIKE '" + maeClaseTarjeFrom.getCodClasTarj() + "'");
        }
        if(maeClaseTarjeFrom.getDesClasTarj() != null)
        {
            query.append(" AND MAE_CLASE_TARJE.DES_CLAS_TARJ LIKE '" + maeClaseTarjeFrom.getDesClasTarj()+ "'");
        }
        if(maeClaseTarjeFrom.getId() != null)
        {
          query.append(" AND MAE_CLASE_TARJE.OID_CLAS_TARJ = " + maeClaseTarjeFrom.getId());
        }
        try {
               rs = bs.dbService.executeStaticQuery(query.toString());
            } catch (Exception ex) {
              UtilidadesLog.error("ERROR ", ex);
              throw new MareException(ex, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS));
            }
             int cant = rs.getRowCount();
             Vector result = new Vector();
             MaeClaseTarjeData maeClaseTarje = null;
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
                       maeClaseTarje = new MaeClaseTarjeData();
                       maeClaseTarje.setId(new Long(((BigDecimal)rs.getValueAt(i,"OID_CLAS_TARJ")).toString()));
                       maeClaseTarje.setCodClasTarj((String)rs.getValueAt(i,"COD_CLAS_TARJ"));
                       maeClaseTarje.setDesClasTarj((String)rs.getValueAt(i,"DES_CLAS_TARJ"));
                       result.add(maeClaseTarje);
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
            UtilidadesLog.info("DAOClaseTarjeta.query(MaeClaseTarjeData maeClaseTarjeFrom, MaeClaseTarjeData maeClaseTarjeTo, HashMap userProperties, Integer pageCount, Integer pageSize): Entrada");
            return result; 
      }
      public void update(MaeClaseTarjeData maeClaseTarje, Vector localizationLabels)throws MareException
      {
        UtilidadesLog.info("DAOClaseTarjeta.upadate(MaeClaseTarjeData maeClaseTarje, Vector localizationLabels): Entrada ");
        RecordSet rs = null;
        BelcorpService bs = UtilidadesEJB.getBelcorpService();       
        StringBuffer update = new StringBuffer();
        update.append(" UPDATE MAE_CLASE_TARJE SET ");
        update.append("  DES_CLAS_TARJ = '" + maeClaseTarje.getDesClasTarj() +"'" );
        update.append("  where OID_CLAS_TARJ = " + maeClaseTarje.getId());
        try {
              int cantRegActualizados = bs.dbService.executeUpdate(update.toString());
                
          } catch (Exception ex) {
              ex.printStackTrace();
              throw new MareException(ex, UtilidadesError.armarCodigoError(
                                        CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS));
          }
        UtilidadesLog.info("DAOClaseTarjeta.upadate(MaeClaseTarjeData maeClaseTarje, Vector localizationLabels): Salida ");  
      }
      
      public void remove(Vector maeClaseTarjeta) throws MareException
      {
          UtilidadesLog.info("DAOClaseTarjeta.remove(Vector maeClaseTarjeta): Entrada");
          RecordSet rs = null;
          BelcorpService bs = UtilidadesEJB.getBelcorpService();
          StringBuffer update = new StringBuffer();
          int cant = maeClaseTarjeta.size();
         MaeClaseTarjeData maeClaseTarjeFrom = null;
         String oidClaseTarjeta = "";
         for (int j = 0; j < cant; j++) {
                maeClaseTarjeFrom = (MaeClaseTarjeData)maeClaseTarjeta.get(j);
                 
                oidClaseTarjeta = oidClaseTarjeta + "," + maeClaseTarjeFrom.getId();
         }
         update.append("delete MAE_CLASE_TARJE ");
         update.append("where OID_CLAS_TARJ in ( " + oidClaseTarjeta.substring(1) + ") ");
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
        UtilidadesLog.info("DAOClaseTarjeta.remove(Vector maeClaseTarjeta): Salida");
      }
}
