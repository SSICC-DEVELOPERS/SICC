package es.indra.sicc.logicanegocio.mae;

import es.indra.belcorp.mso.MaeParamClienData;
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

public class DAOTipoAsignacionCodigo {
    public DAOTipoAsignacionCodigo() {
    }
    public Hashtable guardarTipoAsignacionCodigo(MaeParamClienData maeParamClien, Vector localizationLabels, HashMap userProperties)throws MareException
     {
         UtilidadesLog.info("DAOTipoAsignacionCodigo.guardarTipoAsignacionCodigo(MaeParamClienData maeParamClien, Vector localizationLabels, HashMap userProperties): Entrada");
         RecordSet rs = null;
         BelcorpService bs = UtilidadesEJB.getBelcorpService();     
         StringBuffer update = new StringBuffer();
         RecordSet rsPK = null;
         StringBuffer query = new StringBuffer();      
         Long id = null;
         query.append(" SELECT MAE_PACL_SEQ.NEXTVAL FROM DUAL ");
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
         update.append(" INSERT INTO MAE_PARAM_CLIEN (");
         update.append("         OID_PARA_CLIE ");
         update.append("         , PAIS_OID_PAIS ");
         update.append("         , COD_TIPO_ASIG ");
         update.append(" ) VALUES ( ");
         update.append(id);
         update.append(" , " + maeParamClien.getPaisOidPais().getId());
         update.append(" , '" + maeParamClien.getCodTipoAsig() + "' ");
         update.append("     ) ");
       
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
         UtilidadesLog.info("DAOTipoAsignacionCodigo.guardarTipoAsignacionCodigo(MaeParamClienData maeParamClien, Vector localizationLabels, HashMap userProperties): Salida");
         return primaryKey;
     }
     public Vector query(MaeParamClienData maeParamClienFrom, MaeParamClienData maeParamClienTo, HashMap userProperties, Integer pageCount, Integer pageSize)throws MareException
     {
           UtilidadesLog.info("DAOTipoAsignacionCodigo.query(MaeParamClienData maeParamClienFrom, MaeParamClienData maeParamClienTo, HashMap userProperties, Integer pageCount, Integer pageSize): Entrada");
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
          query.append("   SELECT MAE_PARAM_CLIEN.OID_PARA_CLIE, MAE_PARAM_CLIEN.COD_TIPO_ASIG, SEG_PAIS.OID_PAIS ");
          query.append("          FROM MAE_PARAM_CLIEN, SEG_PAIS ");
          query.append("          WHERE MAE_PARAM_CLIEN.PAIS_OID_PAIS = SEG_PAIS.OID_PAIS     ");
          if(maeParamClienFrom.getPaisOidPais() != null)
          {
          
                  query.append("   AND    SEG_PAIS.OID_PAIS = " + maeParamClienFrom.getPaisOidPais().getId());
          }
          if(maeParamClienFrom.getId() != null)
          {
                  query.append("   AND MAE_PARAM_CLIEN.OID_PARA_CLIE =  " + maeParamClienFrom.getId());
          }
          try {
              rs = bs.dbService.executeStaticQuery(query.toString());
           } catch (Exception ex) {
             UtilidadesLog.error("ERROR ", ex);
             throw new MareException(ex, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS));
           }
            int cant = rs.getRowCount();
            Vector result = new Vector();
            MaeParamClienData maeParamClien = null;
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
                   maeParamClien = new MaeParamClienData();
                   maeParamClien.setId( new Long(((BigDecimal)rs.getValueAt(i,"OID_PARA_CLIE")).toString()));
                   maeParamClien.setCodTipoAsig((String)rs.getValueAt(i,"COD_TIPO_ASIG"));
                   segPaisViewFrom = new SegPaisViewData();
                   segPaisViewFrom.setId( new Long(((BigDecimal)rs.getValueAt(i,"OID_PAIS")).toString()));
                   maeParamClien.setPaisOidPais(segPaisViewFrom);
                   result.add(maeParamClien);
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
            UtilidadesLog.info("DAOTipoAsignacionCodigo.query(MaeParamClienData maeParamClienFrom, MaeParamClienData maeParamClienTo, HashMap userProperties, Integer pageCount, Integer pageSize): Salida");
            return result;
     }
}
