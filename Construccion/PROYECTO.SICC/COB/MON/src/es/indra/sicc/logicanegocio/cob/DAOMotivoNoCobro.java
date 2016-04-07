package es.indra.sicc.logicanegocio.cob;

import es.indra.belcorp.mso.CobMotivIncobData;
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

public class DAOMotivoNoCobro {
    public DAOMotivoNoCobro() {
    }
    
    public Vector query(CobMotivIncobData cobMotivIncobFrom, CobMotivIncobData cobMotivIncobTo, HashMap userProperties, Integer pageCount, Integer pageSize) throws MareException
        {   UtilidadesLog.info("DAOCobMotivoNoCobro.query(CobMotivIncobData cobMotivIncobFrom, CobMotivIncobData cobMotivIncobTo, HashMap userProperties, Integer pageCount, Integer pageSize):Entrada");
            
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
        
            query.append(" SELECT a.OID_MOTI_COBR, a.COD_MOTI_COBR, a.VAL_DESC_MOTI_COBR, b.OID_PAIS ");
            query.append(" FROM COB_MOTIV_INCOB a, SEG_PAIS b  ");
            query.append(" WHERE a.PAIS_OID_PAIS = b.OID_PAIS ");
                            
             if(cobMotivIncobFrom.getId()!= null){
                query.append(" AND OID_MOTI_COBR = " + cobMotivIncobFrom.getId());
            }
             if(cobMotivIncobFrom.getCodMotiCobr()!= null){
                query.append(" AND COD_MOTI_COBR like '" + cobMotivIncobFrom.getCodMotiCobr() + "'");
            }
            
            if(cobMotivIncobFrom.getValDescMotiCobr()!= null){
                query.append(" AND VAL_DESC_MOTI_COBR like '" + cobMotivIncobFrom.getValDescMotiCobr() + "'");
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
            
            CobMotivIncobData cobMotivInc = null;
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
                      cobMotivInc = new CobMotivIncobData();
                      segPais = new SegPaisViewData();
                      
                      cobMotivInc.setId(Long.valueOf(((BigDecimal)rs.getValueAt(i,"OID_MOTI_COBR")).toString()));
                      cobMotivInc.setCodMotiCobr((String)rs.getValueAt(i,"COD_MOTI_COBR"));
                      cobMotivInc.setValDescMotiCobr((String)rs.getValueAt(i,"VAL_DESC_MOTI_COBR"));
                      segPais.setId(Long.valueOf(((BigDecimal)rs.getValueAt(i,"OID_PAIS")).toString()));
                      cobMotivInc.setPaisOidPais(segPais);
                                        
                                        
                      result.add(cobMotivInc);
                }catch(Exception ex)
                {
                  ex.printStackTrace();
                }
                } else {
                   break;
                }
            }
        
            UtilidadesLog.info("DAOCobMotivoNoCobro.query(CobMotivIncobData cobMotivIncobFrom, CobMotivIncobData cobMotivIncobTo, HashMap userProperties, Integer pageCount, Integer pageSize):Salida");
            return result;
        
        
        }
         public Hashtable guardarMotivIncob(CobMotivIncobData cobMotivIncob, Vector localizationLabels, HashMap userProperties) throws MareException
        {   UtilidadesLog.info("DAOCobMotivoNoCobro.guardarMotivIncob(CobMotivIncobData cobMotivIncob, Vector localizationLabels, HashMap userProperties):Entrada");
            RecordSet rs = null;
              BelcorpService bs = UtilidadesEJB.getBelcorpService();     
              StringBuffer update = new StringBuffer();
              RecordSet rsPK = null;
              StringBuffer query = new StringBuffer();      
              Long id = null;
              query.append(" SELECT COB_MONO_SEQ.NEXTVAL FROM DUAL ");
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
              update.append("INSERT INTO COB_MOTIV_INCOB (");
              update.append("              OID_MOTI_COBR   ");
              update.append("              , COD_MOTI_COBR ");
              update.append("              , VAL_DESC_MOTI_COBR ");
              update.append("              , PAIS_OID_PAIS ");
              update.append("  ) VALUES (   ");
              update.append(id);
              update.append(" , '" + cobMotivIncob.getCodMotiCobr()+ "'");
              update.append(" , '" + cobMotivIncob.getValDescMotiCobr() + "'");
              update.append(" , " + cobMotivIncob.getPaisOidPais().getId());
              
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
              UtilidadesLog.info("DAOCobMotivoNoCobro.guardarMotivIncob(CobMotivIncobData cobMotivIncob, Vector localizationLabels, HashMap userProperties):Salida");
              return primaryKey;
        }
         public void update(CobMotivIncobData cobMotivIncob, Vector localizationLabels) throws MareException
        {   UtilidadesLog.info("DAOCobMotivoNoCobro.update(CobMotivIncobData cobMotivIncob, Vector localizationLabels):Entrada");
        
             RecordSet rs = null;
            BelcorpService bs = UtilidadesEJB.getBelcorpService();
               
            StringBuffer update = new StringBuffer();
            update.append("   UPDATE COB_MOTIV_INCOB SET ");
            update.append("           VAL_DESC_MOTI_COBR = '" + cobMotivIncob.getValDescMotiCobr() + "'" );
            
           
            update.append("   where OID_MOTI_COBR = " + cobMotivIncob.getId());
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
        
        
        
            UtilidadesLog.info("DAOCobMotivoNoCobro.update(CobMotivIncobData cobMotivIncob, Vector localizationLabels):Salida");
        }
        
         
           public void remove(Vector entities) throws MareException
        {   UtilidadesLog.info("DAOCobMotivoNoCobro.remove(Vector entities):Entrada");
            RecordSet rs = null;
            BelcorpService bs = UtilidadesEJB.getBelcorpService();
            StringBuffer update = new StringBuffer();
            
            
            int cant = entities.size();
            CobMotivIncobData cobMotivIn = null;
            String oids = "";
            
            for (int j = 0; j < cant; j++) {
               cobMotivIn  = (CobMotivIncobData)entities.get(j);
                 
                oids = oids + "," + cobMotivIn.getId();
            }
            
            update.append("DELETE COB_MOTIV_INCOB ");
            update.append("WHERE OID_MOTI_COBR in ( " + oids.substring(1) + ") ");
            
                   
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
            
        
        
            UtilidadesLog.info("DAOCobMotivoNoCobro.remove(Vector entities):Salida");
        } 
        
    
}
