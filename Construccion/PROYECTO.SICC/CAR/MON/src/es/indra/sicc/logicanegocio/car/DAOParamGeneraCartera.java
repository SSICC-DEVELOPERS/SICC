package es.indra.sicc.logicanegocio.car;

import es.indra.belcorp.mso.CarIndicNivelJerarData;
import es.indra.belcorp.mso.CarNivelRedonData;
import es.indra.belcorp.mso.CarParamGenerCarteData;
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

public class DAOParamGeneraCartera {
    public DAOParamGeneraCartera() {
    }
    public Vector query(CarNivelRedonData carNivelRedonFrom, CarNivelRedonData carNivelRedonTo, HashMap userProperties) throws MareException
        {   UtilidadesLog.info("DAOCarParamGenerCarter.query(CarNivelRedonData carNivelRedonFrom, CarNivelRedonData carNivelRedonTo, HashMap userProperties): Entrada");
          
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
        
            query.append(" SELECT c.OID_NIVE_REDO, b.val_i18n  ");
            query.append(" FROM CAR_NIVEL_REDON c, gen_i18n_sicc_comun b  ");
            query.append(" WHERE b.attr_enti = 'CAR_NIVEL_REDON' ");
            query.append(" AND b.attr_num_atri = 1");
            query.append(" AND b.idio_oid_idio = 1");
            query.append(" AND b.val_oid = c.OID_NIVE_REDO");
        
        
        
            try {
                rs = bs.dbService.executeStaticQuery(query.toString());
            } catch (Exception ex) {
                UtilidadesLog.error("ERROR ", ex);
                throw new MareException(ex, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS));
            }
            int cant = rs.getRowCount();
          
        
            CarNivelRedonData carNivelRedondeo = null;
          
            for(int i=0; i < cant; i++){
             
                carNivelRedondeo = new CarNivelRedonData();
              
                carNivelRedondeo.setId(Long.valueOf(((BigDecimal)rs.getValueAt(i, "OID_NIVE_REDO")).toString()));
                carNivelRedondeo.setDescripcion((String)rs.getValueAt(i,"VAL_I18N"));
             
                resultado.add(carNivelRedondeo);
             }
          
            UtilidadesLog.info("DAOCarCondiEvalNR.query(CarParamEvaluNrData carParamEvaluNrFrom, CarParamEvaluNrData carParamEvaluNrTo, HashMap userProperties): Salida");
          
            return resultado;
            }
            
        public Vector query(CarIndicNivelJerarData carIndicNivelJerarFrom, CarIndicNivelJerarData carIndicNivelJerarTo, HashMap userProperties) throws MareException
        {   
            UtilidadesLog.info("DAOCarParamGenerCarter.query(CarIndicNivelJerarData carIndicNivelJerarFrom, CarIndicNivelJerarData carIndicNivelJerarTo, HashMap userProperties): Entrada");
          
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
        
            query.append(" SELECT OID_INDI_NIVE_JERA, COD_INDI_NIVE_JERA  ");
            query.append(" FROM CAR_INDIC_NIVEL_JERAR   ");
            query.append(" WHERE 1 = 1");
              
        
            try {
                rs = bs.dbService.executeStaticQuery(query.toString());
            } catch (Exception ex) {
                UtilidadesLog.error("ERROR ", ex);
                throw new MareException(ex, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS));
            }
            int cant = rs.getRowCount();
          
        
            CarIndicNivelJerarData carIndiceNivelJerarquia = null;
          
            for(int i=0; i < cant; i++){
             
                carIndiceNivelJerarquia = new CarIndicNivelJerarData();
              
                carIndiceNivelJerarquia.setId(Long.valueOf(((BigDecimal)rs.getValueAt(i, "OID_INDI_NIVE_JERA")).toString()));
                carIndiceNivelJerarquia.setCodIndiNiveJera((String)rs.getValueAt(i,"COD_INDI_NIVE_JERA"));
             
                resultado.add(carIndiceNivelJerarquia);
             }
          
            UtilidadesLog.info("DAOCarCondiEvalNR.query(CarIndicNivelJerarData carIndicNivelJerarFrom, CarIndicNivelJerarData carIndicNivelJerarTo, HashMap userProperties): Salida");
          
            return resultado;
            }
            
         public Vector query(CarParamGenerCarteData carParamGenerCarteFrom, CarParamGenerCarteData carParamGenerCarteTo, HashMap userProperties, Integer pageCount, Integer pageSize) throws MareException
        {   UtilidadesLog.info("DAOCarParamGenerCarter.query(CarParamGenerCarteData carParamGenerCarteFrom, CarParamGenerCarteData carParamGenerCarteTo, HashMap userProperties, Integer pageCount, Integer pageSize):Entrada");
            
        
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
        
            query.append(" SELECT c.oid_indi_nive_jera, c.cod_indi_nive_jera, e.oid_nive_redo, ");
            query.append(" b.val_i18n, a.num_peri_anti, a.num_peri_nuev, a.oid_para_gene_cart, ");
            query.append(" d.oid_pais ");
            query.append(" FROM car_param_gener_carte a,");
            query.append(" gen_i18n_sicc_comun b,");
            query.append(" car_indic_nivel_jerar c, ");
            query.append(" seg_pais d,");
            query.append(" car_nivel_redon e");
            query.append(" WHERE c.oid_indi_nive_jera = a.inij_oid_indi_nive_jera ");
            query.append(" AND d.oid_pais = a.pais_oid_pais ");
            query.append(" AND e.oid_nive_redo = a.nire_oid_nive_redo");
            query.append(" AND b.attr_enti = 'CAR_NIVEL_REDON'");
            query.append(" AND b.attr_num_atri = 1");
            query.append(" AND b.idio_oid_idio = 1");
            query.append(" AND b.val_oid = a.nire_oid_nive_redo");
            
            
            
             if(carParamGenerCarteFrom.getId()!= null){
                query.append(" AND oid_para_gene_cart = " + carParamGenerCarteFrom.getId());
            }
             if(carParamGenerCarteFrom.getNireOidNiveRedo()!= null){
                query.append(" AND nire_oid_nive_redo = " + carParamGenerCarteFrom.getNireOidNiveRedo().getId());
            }
          
            if(carParamGenerCarteFrom.getInijOidIndiNiveJera()!= null){
                query.append(" AND inij_oid_indi_nive_jera = " + carParamGenerCarteFrom.getInijOidIndiNiveJera().getId());
            }
            
            if(carParamGenerCarteFrom.getNumPeriAnti()!= null){
                query.append(" and num_peri_anti = " + carParamGenerCarteFrom.getNumPeriAnti());
            }
                    
            if(carParamGenerCarteFrom.getNumPeriNuev()!= null){
                query.append(" and num_peri_nuev = " + carParamGenerCarteFrom.getNumPeriNuev());
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
            
            CarParamGenerCarteData carParamGeneraCarte = null;
            CarIndicNivelJerarData carIndicNivelJerar = null;
            CarNivelRedonData carNivelRedondeo = null;
            SegPaisViewData segPais = null;
            
            
            
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
                      carParamGeneraCarte = new CarParamGenerCarteData();
                      carIndicNivelJerar = new CarIndicNivelJerarData();
                      carNivelRedondeo = new CarNivelRedonData();
                      segPais = new SegPaisViewData();
                        
                     
                      carParamGeneraCarte.setId(Long.valueOf(((BigDecimal)rs.getValueAt(i,"OID_PARA_GENE_CART")).toString())); 
                      carParamGeneraCarte.setNumPeriAnti(Long.valueOf(((BigDecimal)rs.getValueAt(i,"NUM_PERI_ANTI")).toString()));
                      carParamGeneraCarte.setNumPeriNuev(Long.valueOf(((BigDecimal)rs.getValueAt(i,"NUM_PERI_NUEV")).toString()));
                      carIndicNivelJerar.setId(Long.valueOf(((BigDecimal)rs.getValueAt(i,"OID_INDI_NIVE_JERA")).toString()));
                      carIndicNivelJerar.setCodIndiNiveJera((String)rs.getValueAt(i,"COD_INDI_NIVE_JERA"));
                      carParamGeneraCarte.setInijOidIndiNiveJera(carIndicNivelJerar);
                      carNivelRedondeo.setId(Long.valueOf(((BigDecimal)rs.getValueAt(i,"OID_NIVE_REDO")).toString())); 
                      carNivelRedondeo.setDescripcion((String)rs.getValueAt(i,"VAL_I18N"));
                      carParamGeneraCarte.setNireOidNiveRedo(carNivelRedondeo);
                      segPais.setId(Long.valueOf(((BigDecimal)rs.getValueAt(i,"OID_PAIS")).toString()));
                      carParamGeneraCarte.setPaisOidPais(segPais);
                                        
                      result.add(carParamGeneraCarte);
                      
                }catch(Exception ex)
                {
                  ex.printStackTrace();
                }
                } else {
                   break;
                }
            }
          
          UtilidadesLog.info("DAOCarParamGenerCarter.query(CarParamGenerCarteData carParamGenerCarteFrom, CarParamGenerCarteData carParamGenerCarteTo, HashMap userProperties, Integer pageCount, Integer pageSize): Salida");
          return result;
            
        }
            public Hashtable guardar(CarParamGenerCarteData carParamGenerCarte, Vector localizationLabels, HashMap userProperties) throws MareException
        {   UtilidadesLog.info("DAOCarParamGenerCarter.guardar(CarParamGenerCarteData carParamGenerCarte, Vector localizationLabels, HashMap userProperties): Entrada");
            
            RecordSet rs = null;
            BelcorpService bs = UtilidadesEJB.getBelcorpService();
            
            StringBuffer update = new StringBuffer();
            
            RecordSet rsPK = null;
            StringBuffer query = new StringBuffer();      
            Long id = null;
            
            query.append(" SELECT CAR_PGCA_SEQ.NEXTVAL FROM DUAL");         
            
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
            
                    
          update.append(" INSERT INTO CAR_PARAM_GENER_CARTE ( ");
          update.append(" OID_PARA_GENE_CART, ");
          update.append(" INIJ_OID_INDI_NIVE_JERA, ");
          update.append(" NIRE_OID_NIVE_REDO,");
          update.append(" PAIS_OID_PAIS,");
          update.append(" NUM_PERI_ANTI, ");
          update.append(" NUM_PERI_NUEV");
          update.append(" ) VALUES ( ");
          update.append(id + ", ");
          update.append(carParamGenerCarte.getInijOidIndiNiveJera().getId() + ", ");
          update.append(carParamGenerCarte.getNireOidNiveRedo().getId() + ", ");
          update.append(carParamGenerCarte.getPaisOidPais().getId() + ", ");
          update.append(carParamGenerCarte.getNumPeriAnti() + ", ");
          update.append(carParamGenerCarte.getNumPeriNuev());
          
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
          UtilidadesLog.info("DAOCarParamGenerCarter.guardar(CarParamGenerCarteData carParamGenerCarte, Vector localizationLabels, HashMap userProperties):Salida");
          
          return primaryKey;
        }
        
            public void remove(Vector entities) throws MareException
        {   UtilidadesLog.info("DAOCarParamGenerCarter.remove(Vector entities):Entrada");
            RecordSet rs = null;
            BelcorpService bs = UtilidadesEJB.getBelcorpService();
            StringBuffer update = new StringBuffer();
            
            
            int cant = entities.size();
            CarParamGenerCarteData carParamGeneCarte = null;
            String oids = "";
            
            for (int j = 0; j < cant; j++) {
                carParamGeneCarte = (CarParamGenerCarteData)entities.get(j);
                 
                oids = oids + "," + carParamGeneCarte.getId();
            }
            
            update.append("delete CAR_PARAM_GENER_CARTE ");
            update.append("where OID_PARA_GENE_CART in ( " + oids.substring(1) + ") ");
            
                   
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
        
            UtilidadesLog.info("DAOCarParamGenerCarter.remove(Vector entities):Salida");
        }
        
        public void update(CarParamGenerCarteData carParamGenerCarte, Vector localizationLabels) throws MareException
        {
            UtilidadesLog.info("DAOCarParamGenerCarter.update(CarParamGenerCarteData carParamGenerCarte, Vector localizationLabels): Entrada");
        
            RecordSet rs = null;
            BelcorpService bs = UtilidadesEJB.getBelcorpService();
            
            StringBuffer update = new StringBuffer();
                    
            update.append(" UPDATE  CAR_PARAM_GENER_CARTE SET ");
            update.append(" INIJ_OID_INDI_NIVE_JERA = " + carParamGenerCarte.getInijOidIndiNiveJera().getId()+ ",");
            update.append(" NIRE_OID_NIVE_REDO = " + carParamGenerCarte.getNireOidNiveRedo().getId() + ",");
            update.append(" NUM_PERI_ANTI = " + carParamGenerCarte.getNumPeriAnti() + ",");
            update.append(" NUM_PERI_NUEV = " + carParamGenerCarte.getNumPeriNuev());
            update.append(" WHERE OID_PARA_GENE_CART =" + carParamGenerCarte.getId());
            
            try {
                int cantRegActualizados = bs.dbService.executeUpdate(update.toString());
            } catch (Exception ex) {
                ex.printStackTrace();
                throw new MareException(ex, UtilidadesError.armarCodigoError(
                                        CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS));
            }
          UtilidadesLog.info("DAOCarParamGenerCarter.update(CarParamGenerCarteData carParamGenerCarte, Vector localizationLabels):Salida");
          
        }
     }
           

