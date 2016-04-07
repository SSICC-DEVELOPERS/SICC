package es.indra.sicc.logicanegocio.bel;
import es.indra.belcorp.mso.BelTipoMovimCajaData;
import es.indra.belcorp.mso.GenDetaSiccData;
import es.indra.mare.common.exception.MareException;
import es.indra.mare.common.mgu.manager.Property;
import es.indra.mare.common.mii.MareMiiServiceNotFoundException;
import es.indra.mare.common.mii.services.jdbcservice.RecordSet;
import es.indra.sicc.util.BelcorpService;
import es.indra.sicc.util.CodigosError;
import es.indra.sicc.util.SecuenciadorOID;
import es.indra.sicc.util.UtilidadesEJB;
import es.indra.sicc.util.UtilidadesError;
import es.indra.sicc.util.UtilidadesLog;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Vector;


public class DAOTipoMovimientoCaja 
{
  public DAOTipoMovimientoCaja()
  {
  }
  
   public Hashtable insertar(BelTipoMovimCajaData belTipoMovimCajaData, Vector localizationLabels , HashMap userProperties) throws MareException{
  
      UtilidadesLog.info("DAOTipoMovimientoCaja.guardar(BelTipoMovimCajaData belTipoMovimCajaData, Vector localizationLabels , HashMap userProperties): Entrada");
      RecordSet rs = null;
      BelcorpService bs = UtilidadesEJB.getBelcorpService();
      Long id = SecuenciadorOID.obtenerSiguienteValor("BEL_TMVC_SEQ");
      StringBuffer update = new StringBuffer();        

      update.append("INSERT INTO BEL_TIPO_MOVIM_CAJA ( ");
      update.append("OID_TIPO_MOVI_CAJA "); 
      if (belTipoMovimCajaData.getDesTipoMoviCaja()!=null)
          update.append(", DES_TIPO_MOVI_CAJA"); 
      if (belTipoMovimCajaData.getCodCaja()!=null)
          update.append(", COD_CAJA"); 
      if (belTipoMovimCajaData.getValSign()!=null)
          update.append(", VAL_SIGN"); 
      if (belTipoMovimCajaData.getIndAuto()!=null)
          update.append(", IND_AUTO"); 
      update.append(" ) VALUES ( ");    
      update.append(id);
      if (belTipoMovimCajaData.getDesTipoMoviCaja()!=null)
          update.append(", '" + belTipoMovimCajaData.getDesTipoMoviCaja() + "'");
      if (belTipoMovimCajaData.getCodCaja()!=null)
          update.append(", '" + belTipoMovimCajaData.getCodCaja() + "'");    
      if (belTipoMovimCajaData.getValSign()!=null)
          update.append(", '" + belTipoMovimCajaData.getValSign() + "'");    
      if (belTipoMovimCajaData.getIndAuto()!=null)
          update.append(", '" + belTipoMovimCajaData.getIndAuto() + "'");    
       update.append(") ");    
          
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
      
      UtilidadesLog.info("DAOTipoMovimientoCaja.guardar(BelTipoMovimCajaData belTipoMovimCajaData, Vector localizationLabels , HashMap userProperties): Salida");
      return primaryKey;
  }
  
 public Vector query(BelTipoMovimCajaData belTipoMovimCajaFrom, BelTipoMovimCajaData belTipoMovimCajaTo, HashMap userProperties, Integer pageCount, Integer pageSize) throws MareException 
 {

       UtilidadesLog.info("DAOTipoMovimientoCaja.query(BelTipoMovimCajaData belTipoMovimCajaFrom, BelTipoMovimCajaData belTipoMovimCajaTo, HashMap userProperties, Integer pageCount, Integer pageSize): Entrada");
        
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
        
        
        query.append(" SELECT OID_TIPO_MOVI_CAJA, DES_TIPO_MOVI_CAJA, VAL_SIGN, IND_AUTO, COD_CAJA  ");
        query.append(" FROM BEL_TIPO_MOVIM_CAJA ");
        query.append(" WHERE 1 = 1 ");
        // Para la busqueda
        if(belTipoMovimCajaFrom.getId()!=null){
            query.append(" and OID_TIPO_MOVI_CAJA = " +belTipoMovimCajaFrom.getId() );
        }
        
        if(belTipoMovimCajaFrom.getCodCaja()!= null){
            query.append(" and COD_CAJA like '" + belTipoMovimCajaFrom.getCodCaja() + "' ");
        }
        
        if(belTipoMovimCajaFrom.getDesTipoMoviCaja()!= null){
            query.append(" and DES_TIPO_MOVI_CAJA like '" + belTipoMovimCajaFrom.getDesTipoMoviCaja() + "' ");
        }
        
         if(belTipoMovimCajaFrom.getValSign()!= null){
            query.append(" and VAL_SIGN like '" + belTipoMovimCajaFrom.getValSign() + "' ");
        }
         if(belTipoMovimCajaFrom.getIndAuto() != null){
            query.append(" and IND_AUTO like '" + belTipoMovimCajaFrom.getIndAuto() + "' ");
        }

        try {
           rs = bs.dbService.executeStaticQuery(query.toString());
        } catch (Exception ex) {
          UtilidadesLog.error("ERROR ", ex);
          throw new MareException(ex, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS));
        }
        
        
        int cant = rs.getRowCount();
        Vector result = new Vector();
        
        BelTipoMovimCajaData belTipoMovimCajaData = null;
        
        int rsSaltar = (pageCount.intValue() - 1) * pageSize.intValue();
        int rsMostrar = ((pageSize.intValue() == Integer.MAX_VALUE) ? pageSize.intValue() : (pageSize.intValue() + 1)) + rsSaltar;
        
        UtilidadesLog.debug("rsSaltar: " + rsSaltar);
        UtilidadesLog.debug("rsMostrar: " + rsMostrar);
        
        for(int i=0; i < cant; i++){
        
            if(i < rsSaltar ) {
                continue;
            }
            
            if(i < rsMostrar){
                belTipoMovimCajaData = new BelTipoMovimCajaData();
                
                belTipoMovimCajaData.setId(Long.valueOf(((BigDecimal)rs.getValueAt(i,"OID_TIPO_MOVI_CAJA")).toString()));
                belTipoMovimCajaData.setDesTipoMoviCaja((String)rs.getValueAt(i,"DES_TIPO_MOVI_CAJA"));  
                belTipoMovimCajaData.setValSign((String)rs.getValueAt(i,"VAL_SIGN"));  
                belTipoMovimCajaData.setIndAuto((String)rs.getValueAt(i,"IND_AUTO"));  
                belTipoMovimCajaData.setCodCaja((String)rs.getValueAt(i,"COD_CAJA"));  
                
                result.add(belTipoMovimCajaData);
                
            } else {
               break;
            }
        }
        
        UtilidadesLog.debug("result: " + result);
       
        UtilidadesLog.info("DAOTipoMovimientoCaja.query(BelTipoMovimCajaData belTipoMovimCajaFrom, BelTipoMovimCajaData belTipoMovimCajaTo, HashMap userProperties, Integer pageCount, Integer pageSize): Salida");
        return result;
   
 }
 public void remove(Vector belTipoMovimCaja ) throws MareException
 {
   
    UtilidadesLog.info("DAOTipoMovimientoCaja.remove(Vector belTipoMovimCaja ): Entrada");
        RecordSet rs = null;
        BelcorpService bs = UtilidadesEJB.getBelcorpService();
        StringBuffer update = new StringBuffer();
        
        
        int cant = belTipoMovimCaja.size();
        BelTipoMovimCajaData belEstadMerca = null;
        String oids = "";
        
        for (int j = 0; j < cant; j++) {
            belEstadMerca = (BelTipoMovimCajaData)belTipoMovimCaja.get(j);
             
            oids = oids + "," + belEstadMerca.getId();
        }
        
        update.append("delete BEL_TIPO_MOVIM_CAJA ");
        update.append("where OID_TIPO_MOVI_CAJA in ( " + oids.substring(1) + ") ");
        
       
        
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
        
        UtilidadesLog.info("DAOTipoMovimientoCaja.remove(Vector belTipoMovimCaja ): Salida");
   
 }
 
 public void update(BelTipoMovimCajaData belTipoMovimCajaData, Vector localizationLabels) throws MareException 
 {
   
        UtilidadesLog.info("DAOTipoMovimientoCaja.update(BelTipoMovimCajaData belTipoMovimCajaData, Vector localizationLabels): Entrada");
       
        RecordSet rs = null;
        BelcorpService bs = UtilidadesEJB.getBelcorpService();
        StringBuffer update = new StringBuffer();
        
        update.append("UPDATE BEL_TIPO_MOVIM_CAJA SET ");
        update.append(" COD_CAJA = '" + belTipoMovimCajaData.getCodCaja()+"' ");
        
        if (belTipoMovimCajaData.getValSign() != null) {
            update.append(", VAL_SIGN = '" + belTipoMovimCajaData.getValSign()+"' " );
        }
        if (belTipoMovimCajaData.getIndAuto() != null) {
            update.append(", IND_AUTO = '" + belTipoMovimCajaData.getIndAuto()+"' " );
        }
        if (belTipoMovimCajaData.getDesTipoMoviCaja() != null) {
            update.append(", DES_TIPO_MOVI_CAJA = '" + belTipoMovimCajaData.getDesTipoMoviCaja()+"' " );
        }
        
        
        update.append(" WHERE OID_TIPO_MOVI_CAJA = " + belTipoMovimCajaData.getId());   
        
        try {
            int cantRegActualizados = bs.dbService.executeUpdate(update.toString());
        } catch (Exception ex) {
            ex.printStackTrace();
            throw new MareException(ex, UtilidadesError.armarCodigoError(
                                    CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS));
        }
        
     
               
        UtilidadesLog.info("DAOTipoMovimientoCaja.update(BelTipoMovimCajaData belTipoMovimCajaData, Vector localizationLabels): Salida");
 }
  
}