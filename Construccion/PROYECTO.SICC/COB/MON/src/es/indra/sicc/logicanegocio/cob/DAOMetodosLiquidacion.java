package es.indra.sicc.logicanegocio.cob;

import es.indra.belcorp.mso.CobBaseEscalData;
import es.indra.belcorp.mso.CobMetodLiquiData;

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

public class DAOMetodosLiquidacion {
    public DAOMetodosLiquidacion() {
    }
    
    public Vector query(CobBaseEscalData cobBaseEscalFrom, CobBaseEscalData cobBaseEscalTo, HashMap userProperties) throws MareException
        {   UtilidadesLog.info("DAOMetodosLiquidacion.query(CobBaseEscalData cobBaseEscalFrom, CobBaseEscalData cobBaseEscalTo, HashMap userProperties): Entrada");
            
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
           query.append(" SELECT a.OID_BASE_ESCA, a.COD_BASE_ESCA, b.VAL_I18N ");
           query.append(" FROM COB_BASE_ESCAL a, GEN_I18N_SICC_COMUN b ");
           query.append(" WHERE b.ATTR_ENTI = 'COB_BASE_ESCAL' ");
           query.append(" and b.ATTR_NUM_ATRI = 1");
           query.append(" AND b.IDIO_OID_IDIO = 1");
           query.append(" AND b.VAL_OID = a.OID_BASE_ESCA");
           
           try
           {
                  rs = bs.dbService.executeStaticQuery(query.toString());
         
            }catch (Exception ex) {
               
                  throw new MareException(ex, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS));
           }
           
           CobBaseEscalData cobBaseEscala = null;
           if(!rs.esVacio())
           {
              for(int i = 0; i < rs.getRowCount(); i++)
              {
                 cobBaseEscala = new CobBaseEscalData();
                 
                 cobBaseEscala.setId(Long.valueOf(((BigDecimal)rs.getValueAt(i,"OID_BASE_ESCA")).toString()));
                 cobBaseEscala.setCodBaseEsca((String)rs.getValueAt(i,"COD_BASE_ESCA"));
                 cobBaseEscala.setDescripcion((String)rs.getValueAt(i,"VAL_I18N"));
                 
                 resultado.add(cobBaseEscala);
              }
        
        
           }
            UtilidadesLog.info("DAOMetodosLiquidacion.query(CobBaseEscalData cobBaseEscalFrom, CobBaseEscalData cobBaseEscalTo, HashMap userProperties): Salida");
            return resultado;
        
        } 
        
         public Vector query(CobMetodLiquiData cobMetodLiquiFrom, CobMetodLiquiData cobMetodLiquiTo, HashMap userProperties, Integer pageCount, Integer pageSize) throws MareException
        {   UtilidadesLog.info("DAOMetodosLiquidacion.query(CobMetodLiquiData cobMetodLiquiFrom, CobMetodLiquiData cobMetodLiquiTo, HashMap userProperties, Integer pageCount, Integer pageSize):Entrada");
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
        
            query.append(" SELECT a.oid_meto_liqu_cobr, a.cod_meto_liqu, a.ind_liqu,  b.OID_BASE_ESCA,");
            query.append(" a.ind_liqu_grup_usua, d.oid_pais, a.val_desc_meto_liqu, a.val_obse, c.val_i18n ");
            query.append(" FROM cob_metod_liqui a, cob_base_escal b, gen_i18n_sicc_comun c, seg_pais d ");
            query.append(" WHERE a.pais_oid_pais = d.oid_pais");
            query.append(" AND a.baes_oid_base_esca = b.oid_base_esca");
            query.append(" AND c.attr_enti = 'COB_BASE_ESCAL'");
            query.append(" AND c.attr_num_atri = 1");
            query.append(" AND c.idio_oid_idio = 1");
            query.append(" AND c.val_oid = b.oid_base_esca");
            
            
             if(cobMetodLiquiFrom.getId()!= null){
                query.append(" AND oid_meto_liqu_cobr = " + cobMetodLiquiFrom.getId());
            }
             if(cobMetodLiquiFrom.getCodMetoLiqu()!= null){
                query.append(" AND cod_meto_liqu like '" + cobMetodLiquiFrom.getCodMetoLiqu() + "'");
            }
            if(cobMetodLiquiFrom.getValDescMetoLiqu()!= null){
                query.append(" AND val_desc_meto_liqu like '" + cobMetodLiquiFrom.getValDescMetoLiqu() + "' ");
            }
            if(cobMetodLiquiFrom.getValObse()!= null){
                query.append(" AND VAL_OBSE like '" + cobMetodLiquiFrom.getValObse() + "' ");
            }
            if(cobMetodLiquiFrom.getBaesOidBaseEsca()!= null)
            {
                query.append(" AND  b.OID_BASE_ESCA = " + cobMetodLiquiFrom.getBaesOidBaseEsca().getId());
            }
            if(cobMetodLiquiFrom.getIndLiqu()!= null)
            {
                query.append(" AND ind_liqu = " + cobMetodLiquiFrom.getIndLiqu());
            }
            
            if(cobMetodLiquiFrom.getIndLiquGrupUsua()!=null)
            {
                query.append(" AND ind_liqu_grup_usua = " + cobMetodLiquiFrom.getIndLiquGrupUsua());
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
            
            CobMetodLiquiData cobMetoLiqui = null;
            SegPaisViewData segPais = null;
            CobBaseEscalData cobBase = null;
            
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
                      cobMetoLiqui = new CobMetodLiquiData();
                       segPais = new SegPaisViewData();
                       cobBase = new CobBaseEscalData();
                       String obse = null;
                      
                     
                     
                     
                      cobMetoLiqui.setId(Long.valueOf(((BigDecimal)rs.getValueAt(i,"OID_METO_LIQU_COBR")).toString())); 
                      cobMetoLiqui.setCodMetoLiqu((String)rs.getValueAt(i,"COD_METO_LIQU"));
                      cobMetoLiqui.setIndLiqu(Long.valueOf(((BigDecimal)rs.getValueAt(i,"IND_LIQU")).toString()));
                      cobMetoLiqui.setIndLiquGrupUsua(Long.valueOf(((BigDecimal)rs.getValueAt(i,"IND_LIQU_GRUP_USUA")).toString()));
                      cobMetoLiqui.setValDescMetoLiqu((String)rs.getValueAt(i,"VAL_DESC_METO_LIQU"));
                      cobBase.setId(Long.valueOf(((BigDecimal)rs.getValueAt(i,"OID_BASE_ESCA")).toString()));
                      cobBase.setDescripcion((String)rs.getValueAt(i,"VAL_I18N"));
                      cobMetoLiqui.setBaesOidBaseEsca(cobBase);
                      segPais.setId(Long.valueOf(((BigDecimal)rs.getValueAt(i,"OID_PAIS")).toString())); 
                      cobMetoLiqui.setPaisOidPais(segPais);
                      obse = (String)rs.getValueAt(i,"VAL_OBSE");
                      if(obse != null)
                      {
                           cobMetoLiqui.setValObse(String.valueOf(obse));
                         
                      }
                                        
                      result.add(cobMetoLiqui);
                }catch(Exception ex)
                {
                  ex.printStackTrace();
                }
                } else {
                   break;
                }
            }
          
        UtilidadesLog.info("DAOMetodosLiquidacion.query(CobMetodLiquiData cobMetodLiquiFrom, CobMetodLiquiData cobMetodLiquiTo, HashMap userProperties, Integer pageCount, Integer pageSize):Salida");
        
            return result;
        }
           
        public Hashtable guardarMetodoLiq(CobMetodLiquiData cobMetodLiqui, Vector localizationLabels, HashMap userProperties) throws MareException
        {   UtilidadesLog.info("DAOMetodosLiquidacion.guardarMetodoLiq(CobMetodLiquiData cobMetodLiqui, Vector localizationLabels, HashMap userProperties): Entrada");
              RecordSet rs = null;
              BelcorpService bs = UtilidadesEJB.getBelcorpService();     
              StringBuffer update = new StringBuffer();
              RecordSet rsPK = null;
              StringBuffer query = new StringBuffer();      
              Long id = null;
              query.append(" SELECT COB_MELC_SEQ.NEXTVAL FROM DUAL ");
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
              update.append("INSERT INTO COB_METOD_LIQUI (");
              update.append("              OID_METO_LIQU_COBR   ");
              update.append("              , COD_METO_LIQU ");
              update.append("              , VAL_DESC_METO_LIQU ");
              update.append("              , IND_LIQU ");
              update.append("              , IND_LIQU_GRUP_USUA ");
              update.append("              , PAIS_OID_PAIS ");
              update.append("              , BAES_OID_BASE_ESCA ");
              update.append("              , VAL_OBSE ");
              update.append("  ) VALUES (   ");
              update.append(id);
              update.append(" , '" + cobMetodLiqui.getCodMetoLiqu() + "'");
              update.append(" , '" + cobMetodLiqui.getValDescMetoLiqu() + "'" );
              update.append(" , " + cobMetodLiqui.getIndLiqu());
              update.append(" , " + cobMetodLiqui.getIndLiquGrupUsua());
              update.append(" , " + cobMetodLiqui.getPaisOidPais().getId());
              update.append(" , " + cobMetodLiqui.getBaesOidBaseEsca().getId());
             
                    
              if(cobMetodLiqui.getValObse() != null)
              {
                 update.append(" , '" + cobMetodLiqui.getValObse() + "' ");
              }else
              {
                 update.append(" , NULL");
              }
              
              
              update.append("  )  ");
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
              UtilidadesLog.info("DAOMetodosLiquidacion.guardarMetodoLiq(CobMetodLiquiData cobMetodLiqui, Vector localizationLabels, HashMap userProperties): Salida");
              return primaryKey;
        }
        
        public void update(CobMetodLiquiData cobMetodLiqui, Vector localizationLabels) throws MareException
        {   UtilidadesLog.info("DAOMetodosLiquidacion.update(CobMetodLiquiData cobMetodLiqui, Vector localizationLabels):Entrada");
        
             RecordSet rs = null;
            BelcorpService bs = UtilidadesEJB.getBelcorpService();
               
            StringBuffer update = new StringBuffer();
            update.append("   UPDATE COB_METOD_LIQUI SET ");
            update.append("           VAL_DESC_METO_LIQU = '" + cobMetodLiqui.getValDescMetoLiqu() + "'" );
            update.append("           ,  IND_LIQU = " + cobMetodLiqui.getIndLiqu());
            update.append("           ,  IND_LIQU_GRUP_USUA = " + cobMetodLiqui.getIndLiquGrupUsua());
            update.append("           ,  PAIS_OID_PAIS = " + cobMetodLiqui.getPaisOidPais().getId());
            update.append("           ,  BAES_OID_BASE_ESCA = " + cobMetodLiqui.getBaesOidBaseEsca().getId() );
           
            if(cobMetodLiqui.getValObse() != null){
              update.append("           , VAL_OBSE = '" + cobMetodLiqui.getValObse() + "' ");
            }else
            {
              update.append("           ,  VAL_OBSE = NULL");
            }
            
           
            update.append("   where OID_METO_LIQU_COBR = " + cobMetodLiqui.getId());
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
             
        
            UtilidadesLog.info("DAOMetodosLiquidacion.update(CobMetodLiquiData cobMetodLiqui, Vector localizationLabels):Salida");
        }        
        public void remove(Vector entities) throws MareException
        {   UtilidadesLog.info("DAOMetodosLiquidacion.remove(Vector entities):Entrada");
            RecordSet rs = null;
            BelcorpService bs = UtilidadesEJB.getBelcorpService();
            StringBuffer update = new StringBuffer();
            
            
            int cant = entities.size();
            CobMetodLiquiData cobMetodoLiq = null;
            String oids = "";
            
            for (int j = 0; j < cant; j++) {
               cobMetodoLiq = (CobMetodLiquiData)entities.get(j);
                 
                oids = oids + "," + cobMetodoLiq.getId();
            }
            
            update.append("DELETE COB_METOD_LIQUI ");
            update.append("WHERE OID_METO_LIQU_COBR in ( " + oids.substring(1) + ") ");
            
                   
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
            
            
             UtilidadesLog.info("DAOMetodosLiquidacion.remove(Vector entities):Salida");
        }    
 }
       

