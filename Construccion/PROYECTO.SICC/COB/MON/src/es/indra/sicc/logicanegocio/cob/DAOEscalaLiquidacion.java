package es.indra.sicc.logicanegocio.cob;

import es.indra.belcorp.mso.CobEscalLiquiData;
import es.indra.belcorp.mso.CobMetodLiquiViewData;
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

public class DAOEscalaLiquidacion {
    public DAOEscalaLiquidacion() 
    {
    }
    
    public Vector query(CobEscalLiquiData cobEscalLiquiFrom, CobEscalLiquiData cobEscalLiquiTo, HashMap userProperties, Integer pageCount, Integer pageSize) throws MareException
        {   UtilidadesLog.info("DAOCobEscalaLiquidacion.query(CobEscalLiquiData cobEscalLiquiFrom, CobEscalLiquiData cobEscalLiquiTo, HashMap userProperties, Integer pageCount, Integer pageSize):Entrada");
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
        
            query.append(" SELECT a.oid_esca_liqu_cobr, a.num_orde_esca, a.imp_rang_desd_impo, ");
            query.append(" a.imp_rang_hast_impo, a.val_rang_desd_porc, a.val_rang_hast_porc, ");
            query.append(" a.imp_comi_porc, a.imp_comi_impo, a.val_obse, b.oid_meto_liqu_cobr, ");
            query.append("  b.val_desc_meto_liqu ");
            query.append(" FROM cob_escal_liqui a, cob_metod_liqui b ");
            query.append(" WHERE a.melc_oid_meto_liqu_cobr = b.oid_meto_liqu_cobr ");
            
             if(cobEscalLiquiFrom.getId()!= null){
                query.append(" AND oid_esca_liqu_cobr = " + cobEscalLiquiFrom.getId());
            }
             if(cobEscalLiquiFrom.getNumOrdeEsca()!= null){
                query.append(" AND num_orde_esca = " + cobEscalLiquiFrom.getNumOrdeEsca());
            }
          
            if(cobEscalLiquiFrom.getMelcOidMetoLiquCobr()!= null){
                query.append(" AND oid_meto_liqu_cobr = " + cobEscalLiquiFrom.getMelcOidMetoLiquCobr().getId());
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
            
            CobEscalLiquiData cobEscLiqui = null;
            CobMetodLiquiViewData cobMetL = null;
           
            
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
                      cobEscLiqui= new CobEscalLiquiData();
                      cobMetL= new CobMetodLiquiViewData();
                      BigDecimal impComiImp, impComiPorc, impRangDImpo, impoRangHImpo, valRangD, valRangH = null;
                      String valObse = null; 
                                       
                      cobEscLiqui.setId(Long.valueOf(((BigDecimal)rs.getValueAt(i,"OID_ESCA_LIQU_COBR")).toString())); 
                      impComiImp = (BigDecimal)rs.getValueAt(i,"IMP_COMI_IMPO");
                        if(impComiImp != null){
                            
                            cobEscLiqui.setImpComiImpo(Double.valueOf(impComiImp.toString()));
                        }
                      impComiPorc =(BigDecimal)rs.getValueAt(i,"IMP_COMI_PORC");
                        if(impComiPorc != null)
                        {
                            cobEscLiqui.setImpComiPorc(Double.valueOf(impComiPorc.toString()));
                        }
                      impRangDImpo = (BigDecimal)rs.getValueAt(i,"IMP_RANG_DESD_IMPO");
                        if(impRangDImpo != null)
                        {
                            cobEscLiqui.setImpRangDesdImpo(Double.valueOf(impRangDImpo.toString()));
                        }
                        impoRangHImpo = (BigDecimal)rs.getValueAt(i,"IMP_RANG_HAST_IMPO");
                        if(impoRangHImpo!= null)
                        {
                          cobEscLiqui.setImpRangHastImpo(Double.valueOf(impoRangHImpo.toString()));
                        }
                      valRangD = (BigDecimal)rs.getValueAt(i,"VAL_RANG_DESD_PORC");
                        if(valRangD!= null)
                      {
                          cobEscLiqui.setValRangDesdPorc(Double.valueOf(valRangD.toString()));
                      }
                      valRangH = (BigDecimal)rs.getValueAt(i,"VAL_RANG_HAST_PORC");
                        if(valRangH != null)
                        {
                            cobEscLiqui.setValRangHastPorc(Double.valueOf(valRangH.toString()));
                        }
                       valObse = (String)rs.getValueAt(i,"VAL_OBSE");
                       if(valObse != null)
                       {
                          cobEscLiqui.setValObse((String.valueOf(valObse.toString())));
                        }
                      cobEscLiqui.setNumOrdeEsca(Long.valueOf(((BigDecimal)rs.getValueAt(i,"NUM_ORDE_ESCA")).toString()));
                      cobMetL.setId(Long.valueOf(((BigDecimal)rs.getValueAt(i,"OID_METO_LIQU_COBR")).toString()));
                      cobMetL.setValDescMetoLiqu((String)rs.getValueAt(i,"VAL_DESC_METO_LIQU"));
                      cobEscLiqui.setMelcOidMetoLiquCobr(cobMetL);
                      
                      
                      
                      result.add(cobEscLiqui);
                      
                }catch(Exception ex)
                {
                  ex.printStackTrace();
                }
                } else {
                   break;
                }
           
            }
         UtilidadesLog.info("DAOCobEscalaLiquidacion.query(CobEscalLiquiData cobEscalLiquiFrom, CobEscalLiquiData cobEscalLiquiTo, HashMap userProperties, Integer pageCount, Integer pageSize):Salida");
            return result;
        
        }
         public Vector query(CobMetodLiquiViewData cobMetodLiquiViewFrom, CobMetodLiquiViewData cobMetodLiquiViewTo, HashMap userProperties) throws MareException
        {   UtilidadesLog.info("DAOCobEscalaLiquidacion.query(CobMetodLiquiViewData cobMetodLiquiViewFrom, CobMetodLiquiViewData cobMetodLiquiViewTo, HashMap userProperties):Entrada");
            
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
        
        query.append(" SELECT OID_METO_LIQU_COBR, VAL_DESC_METO_LIQU ");
        query.append(" FROM COB_METOD_LIQUI  ");
        
        
        
        try {
              rs = bs.dbService.executeStaticQuery(query.toString());
          } catch (Exception ex) {
              UtilidadesLog.error("ERROR ", ex);
              throw new MareException(ex, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS));
          }
        int cant = rs.getRowCount();
          
        
         CobMetodLiquiViewData cobMetoLiqui = null;
          
          for(int i=0; i < cant; i++){
             
              cobMetoLiqui  = new CobMetodLiquiViewData();
              
              cobMetoLiqui.setId(Long.valueOf(((BigDecimal)rs.getValueAt(i, "OID_METO_LIQU_COBR")).toString()));
              cobMetoLiqui.setValDescMetoLiqu((String)rs.getValueAt(i,"VAL_DESC_METO_LIQU"));
             
              
              resultado.add(cobMetoLiqui);
          }
        
        
            UtilidadesLog.info("DAOCobEscalaLiquidacion.query(CobMetodLiquiViewData cobMetodLiquiViewFrom, CobMetodLiquiViewData cobMetodLiquiViewTo, HashMap userProperties):Salida");
            return resultado;
        }
        
        public void update(CobEscalLiquiData cobEscalLiqui, Vector localizationLabels) throws MareException
        {   UtilidadesLog.info("DAOCobEscalaLiquidacion.update(CobEscalLiquiData cobEscalLiqui, Vector localizationLabels):Entrada");
            
             RecordSet rs = null;
            BelcorpService bs = UtilidadesEJB.getBelcorpService();
            
            StringBuffer update = new StringBuffer();
                    
            update.append(" UPDATE  COB_ESCAL_LIQUI SET ");
            update.append(" IMP_COMI_IMPO = " + cobEscalLiqui.getImpComiImpo() + ",");
            update.append(" IMP_COMI_PORC =  "+ cobEscalLiqui.getImpComiPorc() + ",");
            
           
            if(cobEscalLiqui.getImpRangDesdImpo()!= null)
            {
                update.append(" IMP_RANG_DESD_IMPO = " + cobEscalLiqui.getImpRangDesdImpo() + ",");
            }
               else {
                update.append(" IMP_RANG_DESD_IMPO = NULL," );} 
                
            if(cobEscalLiqui.getImpRangHastImpo()!= null)
            {
                update.append(" IMP_RANG_HAST_IMPO = " + cobEscalLiqui.getImpRangHastImpo() + ",");
            }
            else
            {
                update.append(" IMP_RANG_HAST_IMPO = NULL,");
            }
            if(cobEscalLiqui.getValRangDesdPorc() != null)
            {
                update.append(" VAL_RANG_DESD_PORC = " + cobEscalLiqui.getValRangDesdPorc() + ",");
            }
            else
            {
                update.append(" VAL_RANG_DESD_PORC = NULL,");
            }
            if(cobEscalLiqui.getValRangHastPorc()!= null)
            {
                update.append(" VAL_RANG_HAST_PORC = " + cobEscalLiqui.getValRangHastPorc() + ",");
            }
            else
            {
                update.append(" VAL_RANG_HAST_PORC = NULL,");
            }
            if(cobEscalLiqui.getValObse()!= null)
            {
                update.append( " VAL_OBSE = '" + cobEscalLiqui.getValObse() + "'");
            }
            else
            {
                update.append(" VAL_OBSE = NULL");
            }
           
                update.append(" WHERE OID_ESCA_LIQU_COBR = " + cobEscalLiqui.getId());
            
            try {
                int cantRegActualizados = bs.dbService.executeUpdate(update.toString());
            } catch (Exception ex) {
                ex.printStackTrace();
                throw new MareException(ex, UtilidadesError.armarCodigoError(
                                        CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS));
            }
        
        
        
        
            UtilidadesLog.info("DAOCobEscalaLiquidacion.update(CobEscalLiquiData cobEscalLiqui, Vector localizationLabels):Salida");
        
    }
     public void remove(Vector entities) throws MareException
        {   UtilidadesLog.info("DAOCobEscalaLiquidacion.remove(Vector entities):Entrada");
            RecordSet rs = null;
            BelcorpService bs = UtilidadesEJB.getBelcorpService();
            StringBuffer update = new StringBuffer();
            
            
            int cant = entities.size();
            CobEscalLiquiData cobEscaLiq = null;
            String oids = "";
            
            for (int j = 0; j < cant; j++) {
                cobEscaLiq = (CobEscalLiquiData)entities.get(j);
                 
                oids = oids + "," + cobEscaLiq.getId();
            }
            
            update.append("delete COB_ESCAL_LIQUI ");
            update.append("where OID_ESCA_LIQU_COBR in ( " + oids.substring(1) + ") ");
            
                   
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
            
            
            UtilidadesLog.info("DAOCobEscalaLiquidacion.remove(Vector entities):Salida");
        }

        public Hashtable guardarEscaLiqui(CobEscalLiquiData cobEscalLiqui, Vector localizationLabels, HashMap userProperties) throws MareException
        {   UtilidadesLog.info("DAOCobEscalaLiquidacion.guardarEscaLiqui(CobEscalLiquiData cobEscalLiqui, Vector localizationLabels, HashMap userProperties):Entrada");
            RecordSet rs = null;
            BelcorpService bs = UtilidadesEJB.getBelcorpService();
            
            StringBuffer update = new StringBuffer();
            
            RecordSet rsPK = null;
            StringBuffer query = new StringBuffer();      
            Long id = null;
            
            query.append(" SELECT COB_ESLI_SEQ.NEXTVAL FROM DUAL");         
            
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
          update.append(" INSERT INTO COB_ESCAL_LIQUI ( ");
          update.append(" OID_ESCA_LIQU_COBR, ");
          update.append(" NUM_ORDE_ESCA, ");
          update.append(" IMP_COMI_PORC,");
          update.append(" IMP_COMI_IMPO, ");
          update.append(" MELC_OID_METO_LIQU_COBR, ");
          update.append(" IMP_RANG_DESD_IMPO, ");
          update.append(" IMP_RANG_HAST_IMPO, ");
          update.append(" VAL_RANG_DESD_PORC, ");
          update.append(" VAL_RANG_HAST_PORC, ");
          update.append(" VAL_OBSE ");
          update.append(" ) VALUES ( ");
          update.append(id + ", ");
          update.append(cobEscalLiqui.getNumOrdeEsca() + ", ");
          update.append(cobEscalLiqui.getImpComiPorc() + ", ");
          update.append(cobEscalLiqui.getImpComiImpo() + ", ");
          update.append(cobEscalLiqui.getMelcOidMetoLiquCobr().getId());
          
            if(cobEscalLiqui.getImpRangDesdImpo()!= null)
            {
              update.append("," + cobEscalLiqui.getImpRangDesdImpo());
            }
            else 
            {
              update.append(", NULL");
            }
            if(cobEscalLiqui.getImpRangHastImpo()!=null)
            {
              update.append("," + cobEscalLiqui.getImpRangHastImpo());
            }
            else
            {
              update.append(", NULL");
            }
            if(cobEscalLiqui.getValRangDesdPorc()!= null)
            {
              update.append("," + cobEscalLiqui.getValRangDesdPorc());
            }
            else
            {
              update.append(", NULL");
            }
            if(cobEscalLiqui.getValRangHastPorc()!= null)
            {
              update.append("," + cobEscalLiqui.getValRangHastPorc());
            }
            else
            {
              update.append(", NULL");
            }
            if(cobEscalLiqui.getValObse()!= null)
            {
              update.append(", '" + cobEscalLiqui.getValObse() + "'");
            }
            else
            {
              update.append(", NULL");
            }
          
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
        
            UtilidadesLog.info("DAOCobEscalaLiquidacion.guardarEscaLiqui(CobEscalLiquiData cobEscalLiqui, Vector localizationLabels, HashMap userProperties):Salida");
            return primaryKey;
        }

    }
    

