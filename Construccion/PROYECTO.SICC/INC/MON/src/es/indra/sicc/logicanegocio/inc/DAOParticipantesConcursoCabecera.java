package es.indra.sicc.logicanegocio.inc;

import es.indra.belcorp.mso.IncPartiConcuCabecData;
import es.indra.mare.common.mgu.manager.Property;
import es.indra.mare.common.mii.MareMiiServiceNotFoundException;
import es.indra.mare.common.mii.services.jdbcservice.RecordSet;
import es.indra.sicc.util.BelcorpService;
import es.indra.sicc.util.CodigosError;
import es.indra.sicc.util.UtilidadesEJB;
import es.indra.sicc.util.UtilidadesError;
import es.indra.sicc.util.UtilidadesLog;
import java.math.BigDecimal;
import java.util.Vector;
import java.util.HashMap;
import java.util.Hashtable;
import es.indra.mare.common.exception.MareException;
import es.indra.belcorp.mso.IncDirigData;
import es.indra.belcorp.mso.SegPaisViewData;

public class DAOParticipantesConcursoCabecera 
{
    public DAOParticipantesConcursoCabecera()
    {
    }
    
    public Vector query(IncDirigData incDirigFrom, IncDirigData incDirigTo, HashMap userProperties) throws MareException
    {
      UtilidadesLog.info("DAOParticipantesConcursoCabecera.query(IncDirigData incDirigFrom, IncDirigData incDirigTo, HashMap userProperties): Entrada");
      
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
      
      Property idioma = (Property)userProperties.get("Idioma");

      query.append(" select VAL_OID, VAL_I18N ");
      query.append(" from v_gen_i18n_sicc ");
      query.append(" where attr_enti = 'INC_DIRIG' ");      
      query.append(" and idio_oid_idio = " + (String)idioma.getValue());
      query.append(" and attr_num_atri = 1 ");
      query.append(" order by val_i18n   ");

      try {
          rs = bs.dbService.executeStaticQuery(query.toString());
      } catch (Exception ex) {
          UtilidadesLog.error("ERROR ", ex);
          throw new MareException(ex, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS));
      }
      
      int cant = rs.getRowCount();
      
      IncDirigData incDirigData = null;
      
      for(int i=0; i < cant; i++){
          incDirigData = new IncDirigData();
          
          incDirigData.setId(Long.valueOf(((BigDecimal)rs.getValueAt(i,"VAL_OID")).toString()));
          incDirigData.setDescripcion((String)rs.getValueAt(i,"VAL_I18N"));
          
          resultado.add(incDirigData);
      }
      
      UtilidadesLog.info("DAOParticipantesConcursoCabecera.query(IncDirigData incDirigFrom, IncDirigData incDirigTo, HashMap userProperties): Salida");
      
      return resultado;
    }
    
    public Hashtable guardar(IncPartiConcuCabecData incPartiConcuCabec, HashMap userProperties) throws MareException
    {
        UtilidadesLog.info("DAOParticipantesConcursoCabecera.guardar(IncPartiConcuCabecData incPartiConcuCabec, HashMap userProperties): Entrada");
        RecordSet rs = null;
        BelcorpService bs = UtilidadesEJB.getBelcorpService();
        
        StringBuffer update = new StringBuffer();
        
        RecordSet rsPK = null;
        StringBuffer query = new StringBuffer();      
        Long id = null;
        
        query.append(" SELECT INC_PACI_SEQ.NEXTVAL FROM DUAL");         
        
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
        
        update.append(" INSERT INTO INC_PARTI_CONCU_CABEC ( ");
        update.append("OID_PART_CONC_CABE, "); 
        update.append("VAL_GRUP_CLIE, "); 
        update.append("PAIS_OID_PAIS, "); 
        update.append("DIRI_OID_DIRI, "); 
        update.append("DES_DESC "); 
        
        update.append(" ) VALUES ( ");
        update.append(id + ", ");
        update.append(id + ", ");
        update.append(incPartiConcuCabec.getPaisOidPais().getId() + ", ");
        update.append(incPartiConcuCabec.getDiriOidDiri().getId() + ", ");
        update.append(" '" + incPartiConcuCabec.getDesDesc() + "' ");
        
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
    
        UtilidadesLog.info("DAOParticipantesConcursoCabecera.guardar(IncPartiConcuCabecData incPartiConcuCabec, HashMap userProperties): Salida");
        return primaryKey;
    }
    
    public void remove(Vector incPartiConcuCabecFrom) throws MareException
    {
        UtilidadesLog.info("DAOParticipantesConcursoCabecera.remove(Vector incPartiConcuCabecFrom): Entrada");
        RecordSet rs = null;
        BelcorpService bs = UtilidadesEJB.getBelcorpService();
        StringBuffer update = new StringBuffer();
        
        int cant = incPartiConcuCabecFrom.size();
        IncPartiConcuCabecData incPartiConcuCabecData = null;
        String oids = "";
        
        for (int j = 0; j < cant; j++) {
            incPartiConcuCabecData = (IncPartiConcuCabecData)incPartiConcuCabecFrom.get(j);
             
            oids = oids + "," + incPartiConcuCabecData.getId();
        }
        
        update.append("delete INC_PARTI_CONCU_CABEC ");
        update.append("where OID_PART_CONC_CABE in ( " + oids.substring(1) + ") ");
        
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
        
        UtilidadesLog.info("DAOParticipantesConcursoCabecera.remove(Vector incPartiConcuCabecFrom): Salida");
        
    }
    
    public Vector query(IncPartiConcuCabecData incPartiConcuCabecFrom, IncPartiConcuCabecData incPartiConcuCabecTo, HashMap userProperties, Integer pageCount, Integer pageSize) throws MareException
    {
        UtilidadesLog.info("DAOParticipantesConcursoCabecera.query(IncPartiConcuCabecData incPartiConcuCabecFrom, IncPartiConcuCabecData incPartiConcuCabecTo, HashMap userProperties, Integer pageCount, Integer pageSize): Entrada");
        
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

        query.append(" select cab.OID_PART_CONC_CABE, cab.DIRI_OID_DIRI, VAL_I18N, ");
        query.append(" cab.PAIS_OID_PAIS, cab.VAL_GRUP_CLIE, cab.DES_DESC ");
        query.append(" from INC_PARTI_CONCU_CABEC cab, v_gen_i18n_sicc ");
        query.append(" where cab.DIRI_OID_DIRI =  VAL_OID ");
        query.append(" and attr_enti = 'INC_DIRIG' ");
        query.append(" and idio_oid_idio = 1  ");
        query.append(" and attr_num_atri = 1 ");
        
        // Para la busqueda
        if(incPartiConcuCabecFrom.getValGrupClie()!= null){
            query.append(" and cab.VAL_GRUP_CLIE = " + incPartiConcuCabecFrom.getValGrupClie());
        }
        
        if(incPartiConcuCabecFrom.getDiriOidDiri()!= null){
            query.append(" and cab.DIRI_OID_DIRI = " + incPartiConcuCabecFrom.getDiriOidDiri().getId());
        }        
        
        if(incPartiConcuCabecFrom.getDesDesc()!= null){
            query.append(" and cab.DES_DESC like '" + incPartiConcuCabecFrom.getDesDesc() + "' " );
        }
                
        // Para el detalle
        if(incPartiConcuCabecFrom.getId()!= null){
            query.append(" and OID_PART_CONC_CABE = " + incPartiConcuCabecFrom.getId());
        }

        try {
           rs = bs.dbService.executeStaticQuery(query.toString());
        } catch (Exception ex) {
          UtilidadesLog.error("ERROR ", ex);
          throw new MareException(ex, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS));
        }
        
        
        int cant = rs.getRowCount();
        Vector result = new Vector();
        IncPartiConcuCabecData incPartiConcuCabecData = null;
        IncDirigData incDirigData = null;
        SegPaisViewData segPaisViewData = null;
        
        int rsSaltar = (pageCount.intValue() - 1) * pageSize.intValue();
        int rsMostrar = ((pageSize.intValue() == Integer.MAX_VALUE) ? pageSize.intValue() : (pageSize.intValue() + 1)) + rsSaltar;
        
        UtilidadesLog.debug("rsSaltar: " + rsSaltar);
        UtilidadesLog.debug("rsMostrar: " + rsMostrar);
        
        for(int i=0; i < cant; i++){
        
            if(i < rsSaltar ) {
                continue;
            }
            
            if(i < rsMostrar){
                incPartiConcuCabecData = new IncPartiConcuCabecData();
                
                incPartiConcuCabecData.setId(Long.valueOf(((BigDecimal)rs.getValueAt(i,"OID_PART_CONC_CABE")).toString()));
                incPartiConcuCabecData.setValGrupClie(Long.valueOf(((BigDecimal)rs.getValueAt(i,"VAL_GRUP_CLIE")).toString()));  
                incPartiConcuCabecData.setDesDesc((String)rs.getValueAt(i,"DES_DESC"));
                
                incDirigData = new IncDirigData();
                incDirigData.setId(Long.valueOf(((BigDecimal)rs.getValueAt(i,"DIRI_OID_DIRI")).toString()));           
                incDirigData.setDescripcion((String)rs.getValueAt(i,"VAL_I18N"));
                incPartiConcuCabecData.setDiriOidDiri(incDirigData); 
                
                segPaisViewData = new SegPaisViewData();
                segPaisViewData.setId(Long.valueOf(((BigDecimal)rs.getValueAt(i,"PAIS_OID_PAIS")).toString()));   
                incPartiConcuCabecData.setPaisOidPais(segPaisViewData); 
                                
                result.add(incPartiConcuCabecData);
                
            } else {
               break;
            }
        }
        
        UtilidadesLog.debug("result: " + result);
       
        UtilidadesLog.info("DAOParticipantesConcursoCabecera.query(IncPartiConcuCabecData incPartiConcuCabecFrom, IncPartiConcuCabecData incPartiConcuCabecTo, HashMap userProperties, Integer pageCount, Integer pageSize): Salida");
        return result;
    }
    
    public void update(IncPartiConcuCabecData incPartiConcuCabec) throws MareException
    {
        UtilidadesLog.info("DAOParticipantesConcursoCabecera.update(IncPartiConcuCabecData incPartiConcuCabec): Entrada");
       
        RecordSet rs = null;
        BelcorpService bs = UtilidadesEJB.getBelcorpService();
        
        StringBuffer update = new StringBuffer();
        
        update.append("UPDATE INC_PARTI_CONCU_CABEC SET ");
        update.append("PAIS_OID_PAIS = " + incPartiConcuCabec.getPaisOidPais().getId() + ", ");
        update.append("DIRI_OID_DIRI = " + incPartiConcuCabec.getDiriOidDiri().getId() + ", "); 
        update.append("DES_DESC = '" + incPartiConcuCabec.getDesDesc() + "' ");
        
        update.append(" WHERE OID_PART_CONC_CABE = " + incPartiConcuCabec.getId());   
        
        try {
            int cantRegActualizados = bs.dbService.executeUpdate(update.toString());
        } catch (Exception ex) {
            ex.printStackTrace();
            throw new MareException(ex, UtilidadesError.armarCodigoError(
                                    CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS));
        }
               
        UtilidadesLog.info("DAOParticipantesConcursoCabecera.update(IncPartiConcuCabecData incPartiConcuCabec): Salida");
    }
    
}