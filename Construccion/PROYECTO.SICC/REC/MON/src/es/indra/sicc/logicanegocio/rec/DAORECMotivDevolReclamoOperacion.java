package es.indra.sicc.logicanegocio.rec;

import es.indra.belcorp.mso.RecMotivDevolData;
import es.indra.belcorp.mso.RecMotivDevolOperaData;
import es.indra.belcorp.mso.RecOperaViewData;
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

public class DAORECMotivDevolReclamoOperacion {
    public DAORECMotivDevolReclamoOperacion() {
    }
    public Vector query(RecOperaViewData recOperaViewFrom, RecOperaViewData recOperaViewTo, HashMap userProperties)throws MareException
      {
         UtilidadesLog.info("DAORECMotivDevolReclamoOperacion.query(RecOperaViewData recOperaViewFrom, RecOperaViewData recOperaViewTo, HashMap userProperties): Entrada");
         RecordSet rs = new RecordSet();
         StringBuffer query = new StringBuffer();
         Vector parametros = new Vector();
         BelcorpService bs;
         try{
                  bs = BelcorpService.getInstance();
            
              } catch(MareMiiServiceNotFoundException ex){
                    
                  throw new MareException(ex, UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_PEDIR_UN_SERVICIO_MARE));
              }
           query.append(" SELECT REC_OPERA.OID_OPER, REC_OPERA.VAL_DESC_LARG ");
           query.append("        FROM REC_OPERA ");
           query.append("        ORDER BY REC_OPERA.VAL_DESC_LARG  ");
           try{
              
                  rs = bs.dbService.executeStaticQuery(query.toString());
               
              } catch (Exception ex) {
               
                  throw new MareException(ex, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS));
              }
           if(!rs.esVacio())
           {
             for(int i= 0; i < rs.getRowCount(); i++){
                  RecOperaViewData recOperaView = new RecOperaViewData();
                  recOperaView.setId( new Long(((BigDecimal)rs.getValueAt(i,"OID_OPER")).toString()));
                  recOperaView.setValDescLarg((String)rs.getValueAt(i,"VAL_DESC_LARG"));
                  parametros.add(recOperaView);
             }
           }
          UtilidadesLog.info("DAORECMotivDevolReclamoOperacion.query(RecOperaViewData recOperaViewFrom, RecOperaViewData recOperaViewTo, HashMap userProperties): Salida");
          return parametros;
      }
      public Vector query(RecMotivDevolData  recMotivDevolFrom, RecMotivDevolData recMotivDevolTo, HashMap userProperties)throws MareException
      {
        UtilidadesLog.info("DAORECMotivDevolReclamoOperacion.query(RecMotivDevolData  recMotivDevolFrom, RecMotivDevolData recMotivDevolTo, HashMap userProperties): Entrada");
        RecordSet rs = new RecordSet();
        StringBuffer query = new StringBuffer();
        Vector parametros = new Vector();
        BelcorpService bs;
        try{
                  bs = BelcorpService.getInstance();
            
        } catch(MareMiiServiceNotFoundException ex){
                    
                 throw new MareException(ex, UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_PEDIR_UN_SERVICIO_MARE));
        }
        query.append(" SELECT V_GEN_I18N_SICC.VAL_I18N, V_GEN_I18N_SICC.VAL_OID ");
        query.append("        FROM V_GEN_I18N_SICC, REC_MOTIV_DEVOL ");
        query.append("              WHERE V_GEN_I18N_SICC.ATTR_ENTI = 'REC_MOTIV_DEVOL' ");
        query.append("              AND V_GEN_I18N_SICC.ATTR_NUM_ATRI = 1 ");
        query.append("              AND V_GEN_I18N_SICC.IDIO_OID_IDIO = 1 ");
        query.append("              AND V_GEN_I18N_SICC.VAL_OID = REC_MOTIV_DEVOL.OID_MOTI_DEVO ");
        query.append("              ORDER BY V_GEN_I18N_SICC.VAL_I18N ");
        try{
              
                  rs = bs.dbService.executeStaticQuery(query.toString());
               
        } catch (Exception ex) {
               
                  throw new MareException(ex, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS));
        }
        if(!rs.esVacio())
        {
           for(int i= 0; i < rs.getRowCount(); i++){
                  RecMotivDevolData  recMotivDevol = new RecMotivDevolData();
                  recMotivDevol.setId( new Long(((BigDecimal)rs.getValueAt(i,"VAL_OID")).toString()));
                  recMotivDevol.setDescripcion((String)rs.getValueAt(i,"VAL_I18N"));
                  parametros.add(recMotivDevol);
           }
        }
        UtilidadesLog.info("DAORECMotivDevolReclamoOperacion.query(RecMotivDevolData  recMotivDevolFrom, RecMotivDevolData recMotivDevolTo, HashMap userProperties): Salida");
        return parametros;
      }
      public Hashtable guardarMotivoDevolucionReclamo(RecMotivDevolOperaData recMotivDevolOpera, Vector localizationLabels, HashMap userProperties)throws MareException
      {
        UtilidadesLog.info("DAORECMotivDevolReclamoOperacion.guardarMotivoDevolucionReclamo(RecMotivDevolOperaData recMotivDevolOpera, Vector localizationLabels, HashMap userProperties): Entrada");
        RecordSet rs = null;
        BelcorpService bs = UtilidadesEJB.getBelcorpService();     
        StringBuffer update = new StringBuffer();
        StringBuffer updateInter = new StringBuffer();
        RecordSet rsPK = null;
        StringBuffer query = new StringBuffer();      
        Long id = null;
        query.append(" SELECT REC_MODO_SEQ.NEXTVAL FROM DUAL ");
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
        update.append("INSERT INTO REC_MOTIV_DEVOL_OPERA ( ");
        update.append("            OID_MOTI_DEVO_OPER  ");
        update.append("            , VAL_MARC_DEFE ");
        update.append("            , PAIS_OID_PAIS ");
        update.append("            , ROPE_OID_OPER ");
        update.append("            , MODV_OID_MOTI_DEVO ");
        update.append(" ) VALUES (  ");
        update.append(id);
        if(recMotivDevolOpera.getValMarcDefe().booleanValue() )
        {
          update.append(" ,  1 ");
        }else
        {
          update.append(" ,  0 ");
        }
        update.append(" , " + recMotivDevolOpera.getPaisOidPais().getId());
        update.append(" , " + recMotivDevolOpera.getRopeOidOper().getId());
        update.append(" , " + recMotivDevolOpera.getModvOidMotiDevo().getId());
        update.append("    )  ");
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
         UtilidadesLog.info("DAORECMotivDevolReclamoOperacion.guardarMotivoDevolucionReclamo(RecMotivDevolOperaData recMotivDevolOpera, Vector localizationLabels, HashMap userProperties): Salida");
         return primaryKey;
      }
      public Vector query(RecMotivDevolOperaData recMotivDevolOperaFrom, RecMotivDevolOperaData recMotivDevolOperaTo, HashMap userProperties, Integer pageCount, Integer pageSize)throws MareException
      {
        UtilidadesLog.info("DAORECMotivDevolReclamoOperacion.query(RecMotivDevolOperaData recMotivDevolOperaFrom, RecMotivDevolOperaData recMotivDevolOperaTo, HashMap userProperties, Integer pageCount, Integer pageSize): Entrada");
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
        }try{
        query.append("     SELECT  REC_MOTIV_DEVOL_OPERA.OID_MOTI_DEVO_OPER, ");
        query.append("             REC_OPERA.OID_OPER, REC_OPERA.VAL_DESC_LARG, ");
        query.append("             V_GEN_I18N_SICC.VAL_I18N, V_GEN_I18N_SICC.VAL_OID, ");
        query.append("             REC_MOTIV_DEVOL_OPERA.VAL_MARC_DEFE, SEG_PAIS.OID_PAIS ");
        query.append("             FROM  REC_MOTIV_DEVOL_OPERA, SEG_PAIS, ");
        query.append("                   REC_OPERA, REC_MOTIV_DEVOL, V_GEN_I18N_SICC  ");
        query.append("                   WHERE REC_MOTIV_DEVOL_OPERA.ROPE_OID_OPER = REC_OPERA.OID_OPER ");
        if(recMotivDevolOperaFrom.getRopeOidOper() != null)
        {
          query.append("                       AND REC_OPERA.OID_OPER = " + recMotivDevolOperaFrom.getRopeOidOper().getId());
        }
        query.append("                         AND REC_MOTIV_DEVOL_OPERA.MODV_OID_MOTI_DEVO = REC_MOTIV_DEVOL.OID_MOTI_DEVO ");
        if(recMotivDevolOperaFrom.getModvOidMotiDevo() != null)
        {
          query.append("                        AND REC_MOTIV_DEVOL.OID_MOTI_DEVO = " + recMotivDevolOperaFrom.getModvOidMotiDevo().getId());
        }
        query.append("                          AND REC_MOTIV_DEVOL_OPERA.PAIS_OID_PAIS = SEG_PAIS.OID_PAIS ");
        if(recMotivDevolOperaFrom.getPaisOidPais() != null)
        {
          query.append("                        AND SEG_PAIS.OID_PAIS = " + recMotivDevolOperaFrom.getPaisOidPais().getId());
        }
        
        if(recMotivDevolOperaFrom.getValMarcDefe() != null)
        {
           if(recMotivDevolOperaFrom.getValMarcDefe().booleanValue())
            {
              query.append("                     AND REC_MOTIV_DEVOL_OPERA.VAL_MARC_DEFE = 1 ");
            }else
            {
              query.append("                     AND REC_MOTIV_DEVOL_OPERA.VAL_MARC_DEFE = 0 ");
            }
        }
        query.append("                           AND V_GEN_I18N_SICC.ATTR_ENTI = 'REC_MOTIV_DEVOL' ");
        query.append("                           AND V_GEN_I18N_SICC.ATTR_NUM_ATRI = 1 ");
        query.append("                           AND V_GEN_I18N_SICC.IDIO_OID_IDIO = 1 ");
        query.append("                           AND V_GEN_I18N_SICC.VAL_OID = REC_MOTIV_DEVOL.OID_MOTI_DEVO  ");
        if(recMotivDevolOperaFrom.getId() != null)
        {
          query.append("                         AND  REC_MOTIV_DEVOL_OPERA.OID_MOTI_DEVO_OPER = " + recMotivDevolOperaFrom.getId());
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
        RecMotivDevolOperaData recMotivDevolOpera = null;
        RecMotivDevolData recMotivDevol = null;
        RecOperaViewData recOperaViewFrom = null;
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
                     recMotivDevolOpera = new  RecMotivDevolOperaData();
                     recMotivDevolOpera.setId(new Long(((BigDecimal)rs.getValueAt(i,"OID_MOTI_DEVO_OPER")).toString()));
                     if(((BigDecimal)rs.getValueAt(i, "VAL_MARC_DEFE")).equals(new BigDecimal("1")))
                     {
                          recMotivDevolOpera.setValMarcDefe(Boolean.TRUE);  
                     }else
                     {
                          recMotivDevolOpera.setValMarcDefe(Boolean.FALSE);  
                     }
                     recMotivDevol = new RecMotivDevolData();
                     recMotivDevol.setId(new Long(((BigDecimal)rs.getValueAt(i,"VAL_OID")).toString()));
                     recMotivDevol.setDescripcion((String)rs.getValueAt(i,"VAL_I18N"));
                     recMotivDevolOpera.setModvOidMotiDevo(recMotivDevol);
                     
                     recOperaViewFrom = new RecOperaViewData();
                     
                     recOperaViewFrom.setId( new Long(((BigDecimal)rs.getValueAt(i,"OID_OPER")).toString()));
                     recOperaViewFrom.setValDescLarg((String)rs.getValueAt(i,"VAL_DESC_LARG"));
                     recMotivDevolOpera.setRopeOidOper(recOperaViewFrom);
                     
                     segPaisViewFrom = new SegPaisViewData();
                     segPaisViewFrom.setId(new Long(((BigDecimal)rs.getValueAt(i,"OID_PAIS")).toString()));
                     recMotivDevolOpera.setPaisOidPais(segPaisViewFrom);
                     result.add(recMotivDevolOpera);
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
       UtilidadesLog.info("DAORECMotivDevolReclamoOperacion.query(RecMotivDevolOperaData recMotivDevolOperaFrom, RecMotivDevolOperaData recMotivDevolOperaTo, HashMap userProperties, Integer pageCount, Integer pageSize): Salida");              
       return result;              
      }
      public void update(RecMotivDevolOperaData recMotivDevolOpera, Vector localizationLabels) throws MareException
      {
          UtilidadesLog.info("DAORECMotivDevolReclamoOperacion.update(RecMotivDevolOperaData recMotivDevolOpera, Vector localizationLabels): Entrada");
          RecordSet rs = null;
          BelcorpService bs = UtilidadesEJB.getBelcorpService();
            
          StringBuffer update = new StringBuffer();
          update.append(" UPDATE REC_MOTIV_DEVOL_OPERA SET ");
          if(recMotivDevolOpera.getValMarcDefe().booleanValue())
            {
              update.append("       VAL_MARC_DEFE = 1 ");
            }else
            {
              update.append("       VAL_MARC_DEFE = 0 ");
            }
          update.append("where OID_MOTI_DEVO_OPER = " + recMotivDevolOpera.getId());
          try {
              int cantRegActualizados = bs.dbService.executeUpdate(update.toString());
                
          } catch (Exception ex) {
              ex.printStackTrace();
              throw new MareException(ex, UtilidadesError.armarCodigoError(
                                        CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS));
          }

            UtilidadesLog.info("DAORECMotivDevolReclamoOperacion.update(RecMotivDevolOperaData recMotivDevolOpera, Vector localizationLabels): Salida");   
        
      }
      public void remove(Vector recMotivoDevolucionRecla)throws MareException
      {
         UtilidadesLog.info("DAORECMotivDevolReclamoOperacion.remove(Vector recMotivoDevolucionRecla): Entrada");
         RecordSet rs = null;
         BelcorpService bs = UtilidadesEJB.getBelcorpService();
         StringBuffer update = new StringBuffer();
        
            
         int cant = recMotivoDevolucionRecla.size();
         RecMotivDevolOperaData recMotivDevolOpera = null;
         String oidMotivDevolReclaOpera = "";
         for (int j = 0; j < cant; j++) {
                recMotivDevolOpera = (RecMotivDevolOperaData)recMotivoDevolucionRecla.get(j);
                 
                oidMotivDevolReclaOpera = oidMotivDevolReclaOpera + "," + recMotivDevolOpera.getId();
         }
          update.append("delete REC_MOTIV_DEVOL_OPERA ");
          update.append("where OID_MOTI_DEVO_OPER in ( " + oidMotivDevolReclaOpera.substring(1) + ") ");
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
         UtilidadesLog.info("DAORECMotivDevolReclamoOperacion.remove(Vector recMotivoDevolucionRecla): Salida");
      }
}
