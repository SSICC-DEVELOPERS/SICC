package es.indra.sicc.logicanegocio.mae;

import es.indra.belcorp.mso.MaeSuperGenerData;
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

public class DAOSuperGenerico {
    public DAOSuperGenerico() {
    }
    public Vector query(MaeSuperGenerData maeSuperGenerFrom, MaeSuperGenerData maeSuperGenerTo, HashMap userProperties, Integer pageCount, Integer pageSize)throws MareException
     {
       UtilidadesLog.info("DAOSuperGenerico.query(MaeSuperGenerData maeSuperGenerFrom, MaeSuperGenerData maeSuperGenerTo, HashMap userProperties, Integer pageCount, Integer pageSize): Entrada");
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
       query.append(" SELECT MAE_SUPER_GENER.OID_SUPE_GENE, MAE_SUPER_GENER.COD_SUPE_GENE, ");
       query.append("        V_GEN_I18N_SICC.VAL_I18N, SEG_PAIS.OID_PAIS ");
       query.append("        FROM MAE_SUPER_GENER, V_GEN_I18N_SICC, SEG_PAIS  ");
       query.append("        WHERE MAE_SUPER_GENER.PAIS_OID_PAIS = SEG_PAIS.OID_PAIS ");
       if(maeSuperGenerFrom.getPaisOidPais() != null)
       {
          query.append("          AND  SEG_PAIS.OID_PAIS =  " + maeSuperGenerFrom.getPaisOidPais().getId());
       }
       if(maeSuperGenerFrom.getCodSupeGene() != null)
       {
          query.append("          AND MAE_SUPER_GENER.COD_SUPE_GENE LIKE '" + maeSuperGenerFrom.getCodSupeGene() + "' ");
       }
       query.append("             AND V_GEN_I18N_SICC.ATTR_ENTI = 'MAE_SUPER_GENER'  ");
       query.append("             AND V_GEN_I18N_SICC.ATTR_NUM_ATRI = 1");
       query.append("             AND V_GEN_I18N_SICC.IDIO_OID_IDIO = 1 ");
       query.append("             AND V_GEN_I18N_SICC.VAL_OID = MAE_SUPER_GENER.OID_SUPE_GENE ");
       if(maeSuperGenerFrom.getDescripcion() != null)
       {
          query.append("          AND V_GEN_I18N_SICC.VAL_I18N LIKE '" + maeSuperGenerFrom.getDescripcion() +"' ");
       }
       if(maeSuperGenerFrom.getId() != null)
       {
           query.append("         AND MAE_SUPER_GENER.OID_SUPE_GENE = " + maeSuperGenerFrom.getId());
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
       MaeSuperGenerData maeSuperGener = null;
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
                     maeSuperGener = new MaeSuperGenerData();
                     maeSuperGener.setId( new Long(((BigDecimal)rs.getValueAt(i,"OID_SUPE_GENE")).toString()));
                     maeSuperGener.setCodSupeGene( (String)rs.getValueAt(i,"COD_SUPE_GENE"));
                     maeSuperGener.setDescripcion( (String)rs.getValueAt(i,"VAL_I18N"));
                     segPaisViewFrom = new SegPaisViewData();
                     segPaisViewFrom.setId( new Long(((BigDecimal)rs.getValueAt(i,"OID_PAIS")).toString()));
                     maeSuperGener.setPaisOidPais(segPaisViewFrom);
                     result.add(maeSuperGener);
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
            UtilidadesLog.info("DAOSuperGenerico.query(MaeSuperGenerData maeSuperGenerFrom, MaeSuperGenerData maeSuperGenerTo, HashMap userProperties, Integer pageCount, Integer pageSize): Salida");
            return result;
     }
     public void remove(Vector maeSuperGenerico)throws MareException
     {
         UtilidadesLog.info("DAOSuperGenerico.remove(Vector maeSuperGenerico): Entrada");
         RecordSet rs = null;
         BelcorpService bs = UtilidadesEJB.getBelcorpService();
         StringBuffer update = new StringBuffer();
         StringBuffer updateInter = new StringBuffer();
           
         int cant =maeSuperGenerico.size();
         MaeSuperGenerData maeSuperGener = null;
         String oidSuperGener = "";
         for (int j = 0; j < cant; j++) {
               maeSuperGener = (MaeSuperGenerData)maeSuperGenerico.get(j);
                
               oidSuperGener = oidSuperGener + "," + maeSuperGener.getId();
         }
         update.append("delete MAE_SUPER_GENER ");
         update.append("where OID_SUPE_GENE in ( " + oidSuperGener.substring(1) + ") ");
         
         updateInter.append("delete GEN_I18N_SICC_PAIS ");
         updateInter.append(" where VAL_OID in ( " + oidSuperGener.substring(1) + ") ");
         updateInter.append(" and ATTR_NUM_ATRI = 1 ");
         updateInter.append(" and ATTR_ENTI = 'MAE_SUPER_GENER' ");
         
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
        UtilidadesLog.info("DAOSuperGenerico.remove(Vector maeSuperGenerico): Salida");
     }
}
