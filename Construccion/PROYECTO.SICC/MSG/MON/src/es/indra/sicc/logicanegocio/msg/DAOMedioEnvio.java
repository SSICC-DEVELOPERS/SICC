package es.indra.sicc.logicanegocio.msg;

import es.indra.belcorp.mso.MsgMedioEnvioData;
import es.indra.belcorp.mso.MsgMedioEnvioPaisData;
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

public class DAOMedioEnvio {
    public DAOMedioEnvio() {
    }
    
    public Vector query(MsgMedioEnvioData msgMedioEnvioFrom, MsgMedioEnvioData msgMedioEnvioTo, HashMap userProperties) throws MareException
        {
             UtilidadesLog.info("DAOMediosEnvio(MsgMedioEnvioData msgMedioEnvioFrom, MsgMedioEnvioData msgMedioEnvioTo, HashMap userProperties ): Entrada");
          
          RecordSet rs = new RecordSet();
          StringBuffer query = new StringBuffer();
          BelcorpService bs;
          Vector resultado = new Vector();
            
        try {
              bs = BelcorpService.getInstance();
          } catch (MareMiiServiceNotFoundException e) {
              UtilidadesLog.error("ERROR ", e);
              throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_PEDIR_UN_SERVICIO_MARE));
        }
        
        query.append(" SELECT   oid_medi_envi , des_medi_envi  ");
        query.append(" FROM msg_medio_envio  ");
        
        
        
        try {
              rs = bs.dbService.executeStaticQuery(query.toString());
          } catch (Exception ex) {
              UtilidadesLog.error("ERROR ", ex);
              throw new MareException(ex, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS));
          }
        int cant = rs.getRowCount();
          
         MsgMedioEnvioData msgMedioEnvioData = null;
          
          for(int i=0; i < cant; i++){
              msgMedioEnvioData = new MsgMedioEnvioData();
              
              msgMedioEnvioData.setId(Long.valueOf(((BigDecimal)rs.getValueAt(i,"OID_MEDI_ENVI")).toString()));
              msgMedioEnvioData.setDesMediEnvi((String)rs.getValueAt(i,"DES_MEDI_ENVI"));
              
              resultado.add(msgMedioEnvioData);
          }
          
          UtilidadesLog.info("DAOMediosEnvio.query(MsgMedioEnvioData msgMedioEnvioFrom, MsgMedioEnvioData msgMedioEnvioTo, HashMap userProperties): Salida");
          
        return resultado;
        }

        public Hashtable guardarMedioEnvio(MsgMedioEnvioPaisData msgMedioEnvioPais, Vector localizationLabels, HashMap userProperties)throws MareException
        {UtilidadesLog.info("DAOguardarMedioEnvio(MsgMedioEnvioPaisData msgMedioEnvioPais, Vector localizationLabels, HashMap userProperties ): Entrada");
          RecordSet rs = null;
            BelcorpService bs = UtilidadesEJB.getBelcorpService();
            
            StringBuffer update = new StringBuffer();
            
            RecordSet rsPK = null;
            StringBuffer query = new StringBuffer();      
            Long id = null;
            
            query.append(" SELECT MSG_MEEP_SEQ.NEXTVAL FROM DUAL");         
            
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
          update.append(" INSERT INTO MSG_MEDIO_ENVIO_PAIS ( ");
          update.append(" OID_MEDI_ENVI_PAIS, ");
          update.append(" PAIS_OID_PAIS, ");
          update.append(" MEEN_OID_MEDI_ENVI,");
          update.append(" COD_ESTA ");
          update.append(" ) VALUES ( ");
          update.append(id + ", ");
          update.append(msgMedioEnvioPais.getPaisOidPais().getId() + ", ");
          update.append(msgMedioEnvioPais.getMeenOidMediEnvi().getId() + ", ");
          update.append(" '" + msgMedioEnvioPais.getCodEsta() + "' ");
          
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
          UtilidadesLog.info("DAOguardarMedioEnvio(MsgMedioEnvioPaisData msgMedioEnvioPais, Vector localizationLabels, HashMap userProperties ): Salida");
          
          return primaryKey;
        }
        
        
        public Vector query(MsgMedioEnvioPaisData msgMedioEnvioPaisFrom, MsgMedioEnvioPaisData msgMedioEnvioPaisTo, HashMap userProperties, Integer pageCount, Integer pageSize) throws MareException
        {UtilidadesLog.info("DAOMedioEnvio.query(MsgMedioEnvioPaisData msgMedioEnvioPaisFrom, MsgMedioEnvioPaisData msgMedioEnvioPaisTo, HashMap userProperties, Integer pageCount, Integer pageSize):Entrada ");
        
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
            query.append(" SELECT m.OID_MEDI_ENVI_PAIS, m.pais_oid_pais, e.des_medi_envi, e.oid_medi_envi, m.cod_esta,");
            query.append(" V_gen_i18n_sicc.VAL_OID oidPais, V_gen_i18n_sicc.VAL_I18N DESPAIS");
            query.append(" FROM msg_medio_envio_pais m, msg_medio_envio e, seg_pais s, V_gen_i18n_sicc ");
            query.append(" WHERE m.pais_oid_pais = s.oid_pais ");
            query.append(" AND e.oid_medi_envi = m.meen_oid_medi_envi");
            query.append(" AND V_gen_i18n_sicc.ATTR_ENTI = 'SEG_PAIS' ");
            query.append(" AND V_gen_i18n_sicc.ATTR_NUM_ATRI = 1");
            query.append(" AND V_gen_i18n_sicc.IDIO_OID_IDIO = 1");
            query.append(" AND V_gen_i18n_sicc.VAL_OID = S.OID_PAIS");
            
            if(msgMedioEnvioPaisFrom.getPaisOidPais()!= null){
                query.append(" AND s.OID_PAIS = " + msgMedioEnvioPaisFrom.getPaisOidPais().getId() );
            }
            
            if(msgMedioEnvioPaisFrom.getMeenOidMediEnvi() != null){
                query.append(" and e.OID_MEDI_ENVI = " + msgMedioEnvioPaisFrom.getMeenOidMediEnvi().getId());
            }
            if(msgMedioEnvioPaisFrom.getId()!= null)
            {
              query.append(" AND m.OID_MEDI_ENVI_PAIS = " + msgMedioEnvioPaisFrom.getId());
            }
            }
            catch(Exception ex)
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
            
            MsgMedioEnvioPaisData msgMedioEnvioPaisData = null;
            MsgMedioEnvioData msgMedioEnvioData = null;
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
                      msgMedioEnvioData = new MsgMedioEnvioData();
                       segPaisViewFrom = new SegPaisViewData();
                     msgMedioEnvioPaisData = new MsgMedioEnvioPaisData();
                     
                     
                      msgMedioEnvioData.setId(Long.valueOf(((BigDecimal)rs.getValueAt(i,"OID_MEDI_ENVI")).toString())); 
                      msgMedioEnvioData.setDesMediEnvi((String)rs.getValueAt(i,"DES_MEDI_ENVI"));
                      msgMedioEnvioPaisData.setMeenOidMediEnvi(msgMedioEnvioData);
                      msgMedioEnvioPaisData.setCodEsta((String)rs.getValueAt(i, "COD_ESTA"));
                      segPaisViewFrom.setId(Long.valueOf(((BigDecimal)rs.getValueAt(i,"PAIS_OID_PAIS")).toString()));
                      segPaisViewFrom.setDescripcion((String)rs.getValueAt(i, "DESPAIS"));
                      msgMedioEnvioPaisData.setPaisOidPais(segPaisViewFrom);
                      msgMedioEnvioPaisData.setId(new Long(((BigDecimal)rs.getValueAt(i, "OID_MEDI_ENVI_PAIS")).toString()));
                      
                      result.add(msgMedioEnvioPaisData);
                }catch(Exception ex)
                {
                  ex.printStackTrace();
                }
                } else {
                   break;
                }
            }
          
          UtilidadesLog.info("DAOMedioEnvio.query(MsgMedioEnvioPaisData msgMedioEnvioPaisFrom, MsgMedioEnvioPaisData msgMedioEnvioPaisTo, HashMap userProperties, Integer pageCount, Integer pageSize):Salida ");
          return result;
          
        }
        public void update(MsgMedioEnvioPaisData msgMedioEnvioPais, Vector localizationLabels) throws MareException
        {
          UtilidadesLog.info("DAOMedioEnvio.update(MsgMedioEnvioPaisData msgMedioEnvioPais, Vector localizationLabels):Entrada ");
            RecordSet rs = null;
            BelcorpService bs = UtilidadesEJB.getBelcorpService();
            
            StringBuffer update = new StringBuffer();
            
            MsgMedioEnvioData msg = new MsgMedioEnvioData();
            update.append(" UPDATE  msg_medio_envio_pais M SET ");
            update.append(" M.COD_ESTA ='" + msgMedioEnvioPais.getCodEsta()+"'");
            update.append(" WHERE M.OID_MEDI_ENVI_PAIS =" + msgMedioEnvioPais.getId());
            
            try {
                int cantRegActualizados = bs.dbService.executeUpdate(update.toString());
            } catch (Exception ex) {
                ex.printStackTrace();
                throw new MareException(ex, UtilidadesError.armarCodigoError(
                                        CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS));
            }
          
                     
          UtilidadesLog.info("DAOMedioEnvio.update(MsgMedioEnvioPaisData msgMedioEnvioPais, Vector localizationLabels):Salida ");
        }
        
        public void remove(Vector entities) throws MareException
        {
          UtilidadesLog.info("DAOMedioEnvio.remove(Vector entities): Entrada");
            RecordSet rs = null;
            BelcorpService bs = UtilidadesEJB.getBelcorpService();
            StringBuffer update = new StringBuffer();
            //StringBuffer updateInter = new StringBuffer();
            
            int cant = entities.size();
            MsgMedioEnvioPaisData msgMedioEnvioPaisData = null;
            String oids = "";
            
            for (int j = 0; j < cant; j++) {
                msgMedioEnvioPaisData = (MsgMedioEnvioPaisData)entities.get(j);
                 
                oids = oids + "," + msgMedioEnvioPaisData.getId();
            }
            
            update.append("delete MSG_MEDIO_ENVIO_PAIS ");
            update.append("where OID_MEDI_ENVI_PAIS in ( " + oids.substring(1) + ") ");
            
                   
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
            
            UtilidadesLog.info("DAOMedioEnvio.remove(Vector entities): Salida");
        }
        
        }


