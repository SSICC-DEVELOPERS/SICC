package es.indra.sicc.logicanegocio.ped;

import es.indra.belcorp.mso.MaeNegocData;
import es.indra.belcorp.mso.PedUmbraFaltaData;
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

public class DAOUmbralFaltantes {
    public DAOUmbralFaltantes() {
    }
    public Hashtable guardarUmbralFaltantes(PedUmbraFaltaData pedUmbraFalta, Vector localizationLabels, HashMap userProperties)throws MareException
      {
        UtilidadesLog.info("DAOUmbralFaltantes.guardarUmbralFaltantes(PedUmbraFaltaData pedUmbraFalta, Vector localizationLabels, HashMap userProperties): Entrada ");
        RecordSet rs = null;
        BelcorpService bs = UtilidadesEJB.getBelcorpService();     
        StringBuffer update = new StringBuffer();
        StringBuffer updateInter = new StringBuffer();
        RecordSet rsPK = null;
        StringBuffer query = new StringBuffer();      
        Long id = null;
        query.append(" SELECT PED_UMFA_SEQ.NEXTVAL FROM DUAL ");
        
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
         update.append(" INSERT INTO PED_UMBRA_FALTA ( ");
         update.append("    OID_UMBR, ");
         update.append("    NEGO_OID_NEGO, ");
         update.append("    VAL_UMBR_FALT, ");
         update.append("    PAIS_OID_PAIS");
         update.append(" ) VALUES ( ");
         update.append( id);
         update.append(", " + pedUmbraFalta.getNegoOidNego().getId());
         update.append(" ," + pedUmbraFalta.getValUmbrFalt());
         update.append(", " + pedUmbraFalta.getPaisOidPais().getId() );
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
       UtilidadesLog.info("DAOUmbralFaltantes.guardarUmbralFaltantes(PedUmbraFaltaData pedUmbraFalta, Vector localizationLabels, HashMap userProperties): Salida ");    
       return primaryKey; 
      }
      public Vector query(PedUmbraFaltaData pedUmbraFaltaFrom, PedUmbraFaltaData pedUmbraFaltaTo, HashMap userProperties, Integer pageCount, Integer pageSize)throws MareException
      {
        UtilidadesLog.info("DAOUmbralFaltantes.query(PedUmbraFaltaData pedUmbraFaltaFrom, PedUmbraFaltaData pedUmbraFaltaTo, HashMap userProperties, Integer pageCount, Integer pageSize): Entrada");
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
        query.append(" SELECT PED_UMBRA_FALTA.OID_UMBR, I18N.VAL_I18N DESNEGOCION, ");
        query.append("        I18N.VAL_OID OIDNEGOCIO, PED_UMBRA_FALTA.VAL_UMBR_FALT, SEG_PAIS.OID_PAIS ");
        query.append("        FROM PED_UMBRA_FALTA, V_GEN_I18N_SICC I18N, MAE_NEGOC, SEG_PAIS  ");
        query.append("        WHERE PED_UMBRA_FALTA.NEGO_OID_NEGO = MAE_NEGOC.OID_NEGO ");
        if(pedUmbraFaltaFrom.getNegoOidNego() != null)
        {
          query.append(" AND MAE_NEGOC.OID_NEGO = " + pedUmbraFaltaFrom.getNegoOidNego().getId());
        }
        query.append(" AND PED_UMBRA_FALTA.PAIS_OID_PAIS = SEG_PAIS.OID_PAIS ");
        if(pedUmbraFaltaFrom.getPaisOidPais() != null)
        {
          query.append(" AND SEG_PAIS.OID_PAIS = " + pedUmbraFaltaFrom.getPaisOidPais().getId());
        }
        query.append(" AND I18N.ATTR_ENTI = 'MAE_NEGOC' ");
        query.append(" AND I18N.ATTR_NUM_ATRI = 1 ");
        query.append(" AND I18N.IDIO_OID_IDIO = 1 ");
        query.append(" AND I18N.VAL_OID = MAE_NEGOC.OID_NEGO ");
        if(pedUmbraFaltaFrom.getId() != null){
          query.append(" AND PED_UMBRA_FALTA.OID_UMBR = " + pedUmbraFaltaFrom.getId());
        }
        try {
               rs = bs.dbService.executeStaticQuery(query.toString());
        } catch (Exception ex) {
              UtilidadesLog.error("ERROR ", ex);
              throw new MareException(ex, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS));
        }
        int cant = rs.getRowCount();
        Vector result = new Vector();
        PedUmbraFaltaData pedUmbraFalta = null;    
        SegPaisViewData segPaisViewFrom = null; 
        MaeNegocData maeNegocFrom = null;
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
                    pedUmbraFalta = new PedUmbraFaltaData();
                    pedUmbraFalta.setId(new Long(((BigDecimal)rs.getValueAt(i,"OID_UMBR")).toString()));
                    maeNegocFrom = new MaeNegocData();
                    maeNegocFrom.setId(new Long(((BigDecimal)rs.getValueAt(i,"OIDNEGOCIO")).toString()));
                    maeNegocFrom.setDescripcion( (String) rs.getValueAt(i,"DESNEGOCION"));
                    pedUmbraFalta.setNegoOidNego(maeNegocFrom);
                    segPaisViewFrom = new SegPaisViewData();
                    segPaisViewFrom.setId(new Long(((BigDecimal)rs.getValueAt(i,"OID_PAIS")).toString()));
                    pedUmbraFalta.setPaisOidPais(segPaisViewFrom);
                    pedUmbraFalta.setValUmbrFalt(Double.valueOf(((BigDecimal)rs.getValueAt(i,"VAL_UMBR_FALT")).toString()));
                    result.add(pedUmbraFalta);
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
        UtilidadesLog.info("DAOUmbralFaltantes.query(PedUmbraFaltaData pedUmbraFaltaFrom, PedUmbraFaltaData pedUmbraFaltaTo, HashMap userProperties, Integer pageCount, Integer pageSize): Salida");
        return result;
      }
      public void update(PedUmbraFaltaData pedUmbraFalta, Vector localizationLabels)throws MareException
      {
        UtilidadesLog.info("DAOUmbralFaltantes.update(PedUmbraFaltaData pedUmbraFalta, Vector localizationLabels):Entrada ");
        RecordSet rs = null;
        BelcorpService bs = UtilidadesEJB.getBelcorpService();
        StringBuffer update = new StringBuffer();
        
        update.append("UPDATE PED_UMBRA_FALTA SET");
        update.append(" VAL_UMBR_FALT = " + pedUmbraFalta.getValUmbrFalt());
        update.append("WHERE OID_UMBR = " + pedUmbraFalta.getId());
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
        UtilidadesLog.info("DAOUmbralFaltantes.update(PedUmbraFaltaData pedUmbraFalta, Vector localizationLabels): Salida ");  
      }
      public void remove(Vector pedUmbraFaltaFrom)throws MareException
      {
         UtilidadesLog.info("DAOUmbralFaltantes.remove(Vector pedUmbralFaltaFrom): Entrada ");
         RecordSet rs = null;
         BelcorpService bs = UtilidadesEJB.getBelcorpService();
         StringBuffer update = new StringBuffer();
         int cant = pedUmbraFaltaFrom.size();
         PedUmbraFaltaData pedUmbraFalta = null;
         String oidUmbralFaltantes = "";
         for (int j = 0; j < cant; j++) {
                pedUmbraFalta = (PedUmbraFaltaData)pedUmbraFaltaFrom.get(j);
                 
                oidUmbralFaltantes = oidUmbralFaltantes + "," + pedUmbraFalta.getId();
         }
          update.append("delete PED_UMBRA_FALTA  ");
          update.append("where OID_UMBR in ( " + oidUmbralFaltantes.substring(1) + ") ");
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
       UtilidadesLog.info("DAOUmbralFaltantes.remove(Vector pedUmbralFaltaFrom): Salida "); 
      }}
