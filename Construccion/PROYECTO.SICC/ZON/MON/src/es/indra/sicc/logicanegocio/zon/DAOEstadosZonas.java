package es.indra.sicc.logicanegocio.zon;

import es.indra.belcorp.mso.SegMarcaData;
import java.util.HashMap;
import java.util.Vector;
import es.indra.sicc.util.UtilidadesLog;
import es.indra.mare.common.exception.MareException;
import es.indra.mare.common.mii.MareMiiServiceNotFoundException;
import es.indra.mare.common.mii.services.jdbcservice.RecordSet;
import es.indra.sicc.util.BelcorpService;
import es.indra.sicc.util.UtilidadesError;
import es.indra.sicc.util.CodigosError;
import es.indra.mare.common.mgu.manager.Property;
import java.math.BigDecimal;
import java.util.Hashtable;
import es.indra.belcorp.mso.ZonEstadZonaData;
import es.indra.sicc.util.UtilidadesEJB;
import es.indra.belcorp.mso.GenDetaSiccData;

public class DAOEstadosZonas 
{
    public DAOEstadosZonas()
    {
    }
    
    public Vector query(SegMarcaData segMarcaFrom, SegMarcaData segMarcaTo, HashMap userProperties) throws MareException
    {
      UtilidadesLog.info("DAOEstadosZonas.query(SegMarcaData segMarcaFrom, SegMarcaData segMarcaTo, HashMap userProperties): Entrada");
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
      Property cosUsua = (Property)userProperties.get("userID");
      String usuario = (String)cosUsua.getValue();
      UtilidadesLog.debug("cosUsua: " + usuario);

      query.append(" SELECT OID_MARC, COD_MARC, DES_MARC from VCA_SEG_MARCA where COD_USUA = '");
      query.append(usuario);
      query.append("'");

      try {
          rs = bs.dbService.executeStaticQuery(query.toString());
      } catch (Exception ex) {
          UtilidadesLog.error("ERROR ", ex);
          throw new MareException(ex, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS));
      }      
      
      int cant = rs.getRowCount();
      SegMarcaData segMarcaData = null;
      for(int i=0; i < cant; i++){
          segMarcaData = new SegMarcaData();
          
          segMarcaData.setId(Long.valueOf(((BigDecimal)rs.getValueAt(i,"OID_MARC")).toString()));
          segMarcaData.setCodMarc((String)rs.getValueAt(i,"COD_MARC"));;
          segMarcaData.setDesMarc((String)rs.getValueAt(i,"DES_MARC"));;
          resultado.add(segMarcaData);
      }
      UtilidadesLog.info("DAOEstadosZonas.query(SegMarcaData segMarcaFrom, SegMarcaData segMarcaTo, HashMap userProperties): Salida");
      
      return resultado;
    }
    
    public Hashtable guardar(ZonEstadZonaData zonEstadZona, Vector localizationLabels, HashMap userProperties) throws MareException
    {
        UtilidadesLog.info("DAOEstadosZonas.guardar(ZonEstadZonaData zonEstadZona, Vector localizationLabels, HashMap userProperties): Entrada");
        RecordSet rs = null;
        BelcorpService bs = UtilidadesEJB.getBelcorpService();
        
        StringBuffer update = new StringBuffer();        
        RecordSet rsPK = null;
        StringBuffer query = new StringBuffer();      
        Long id = null;
        
        query.append(" SELECT ZON_ESZO_SEQ.NEXTVAL FROM DUAL");         
        
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
        update.append("INSERT INTO ZON_ESTAD_ZONA ( ");
        update.append("OID_ESTA_ZONA "); 
        
        if (zonEstadZona.getCodEstaZona()!=null)
            update.append(", COD_ESTA_ZONA");    
        if (zonEstadZona.getImpoVentMini()!=null)    
            update.append(", IMPO_VENT_MINI");
        if (zonEstadZona.getValoTiemMini()!=null)    
            update.append(", VALO_TIEM_MINI");
        if (zonEstadZona.getNumConsMin()!=null)    
            update.append(", NUM_CONS_MIN");
        if (zonEstadZona.getNumPediZona()!=null)        
            update.append(", NUM_PEDI_ZONA");
        if (zonEstadZona.getPaisOidPais().getId()!=null)            
            update.append(", PAIS_OID_PAIS");
        if (zonEstadZona.getMarcOidMarc().getId()!=null)                        
            update.append(", MARC_OID_MARC");
        if (zonEstadZona.getIndInic()!=null)                        
            update.append(", IND_INIC");
            
        update.append(" ) VALUES ( ");    
        update.append(id);
        if (zonEstadZona.getCodEstaZona()!=null)
            update.append(", '" + zonEstadZona.getCodEstaZona() + "'");    
        if (zonEstadZona.getImpoVentMini()!=null)
            update.append(", " + zonEstadZona.getImpoVentMini());    
        if (zonEstadZona.getValoTiemMini()!=null)    
            update.append(", " + zonEstadZona.getValoTiemMini());    
        if (zonEstadZona.getNumConsMin()!=null)    
            update.append(", " + zonEstadZona.getNumConsMin());    
        if (zonEstadZona.getNumPediZona()!=null)        
            update.append(", " + zonEstadZona.getNumPediZona());    
        if (zonEstadZona.getPaisOidPais().getId()!=null)                
            update.append(", " + zonEstadZona.getPaisOidPais().getId());
        if (zonEstadZona.getMarcOidMarc().getId()!=null)                        
            update.append(", " + zonEstadZona.getMarcOidMarc().getId());
        if (zonEstadZona.getIndInic()!=null)                        
            update.append(", " + zonEstadZona.getIndInic());
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
        // Internacionalización
        int cant = localizationLabels.size();
        GenDetaSiccData genDetaSiccData = null;
        RecordSet rsPKInter = null;
        StringBuffer queryInter = null;
        Long idInter = null;        
        StringBuffer updateInter = null;
        
        for(int i= 0; i< cant; i++){
            queryInter = new StringBuffer();             
            queryInter.append(" SELECT GEN_i18n_SEQ.NEXTVAL FROM DUAL");         
            
            try {
                rsPKInter = bs.dbService.executeStaticQuery(queryInter.toString());
                    
            } catch (Exception ex) {
                ex.printStackTrace();
                throw new MareException(ex, UtilidadesError.armarCodigoError(
                                        CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS));
            }
            
            if(rsPKInter != null && !rsPKInter.esVacio()) {
                idInter = Long.valueOf(((BigDecimal)rsPKInter.getValueAt(0,0)).toString());
            }      
            
            genDetaSiccData = (GenDetaSiccData)localizationLabels.get(i);
            updateInter = new StringBuffer();    
                
            updateInter.append(" INSERT INTO GEN_I18N_SICC_PAIS ( ");
            updateInter.append("OID_I18N, "); 
            updateInter.append("ATTR_ENTI, "); 
            updateInter.append("ATTR_NUM_ATRI, "); 
            updateInter.append("IDIO_OID_IDIO, "); 
            updateInter.append("VAL_I18N, ");                 
            updateInter.append("VAL_OID "); 
            updateInter.append(" ) VALUES ( ");
            updateInter.append(idInter + ", ");
            updateInter.append(" 'ZON_ESTAD_ZONA', ");
            updateInter.append(" 1, ");            
            updateInter.append(genDetaSiccData.getIdioOidIdio().getId() + ", ");
            updateInter.append(" '" + genDetaSiccData.getDeta() + "', ");
            updateInter.append(id + " )");     
                
            try {
                int cantRegActualizados = bs.dbService.executeUpdate(updateInter.toString());
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
        }
        Hashtable primaryKey = new Hashtable();
        primaryKey.put("id", id);     
        
        UtilidadesLog.info("DAOEstadosZonas.guardar(ZonEstadZonaData zonEstadZona, Vector localizationLabels, HashMap userProperties): Salida");
        return primaryKey;
    }
 
    public void update(ZonEstadZonaData zonEstadZona, Vector localizationLabels) throws MareException
    {
        UtilidadesLog.info("DAOEstadosZonas.update(ZonEstadZonaData zonEstadZona, Vector localizationLabels): Entrada");
        UtilidadesLog.info("zonEstadZona: " + zonEstadZona.getDescripcion());
        try{
            RecordSet rs = null;
            BelcorpService bs = UtilidadesEJB.getBelcorpService();
            
            int cant = localizationLabels.size();
            GenDetaSiccData genDetaSiccData = null;
            StringBuffer updateInter = null;
            
            updateInter = new StringBuffer();
            updateInter.append("DELETE GEN_I18N_SICC_PAIS ");
            updateInter.append(" where VAL_OID in ( " + zonEstadZona.getId().longValue() + ") ");
            updateInter.append(" and ATTR_NUM_ATRI = 1 ");
            updateInter.append(" and ATTR_ENTI = 'ZON_ESTAD_ZONA' ");
            try {
                int cantRegActualizados = bs.dbService.executeUpdate(updateInter.toString());
            } catch (Exception ex) {
                ex.printStackTrace();
                throw new MareException(ex, UtilidadesError.armarCodigoError(
                                        CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS));
            }

            for(int i= 0; i< cant; i++){                      
                genDetaSiccData = (GenDetaSiccData)localizationLabels.get(i);
                UtilidadesLog.info("genDetaSiccData: " + genDetaSiccData.getDeta());
                updateInter = new StringBuffer();
                updateInter.append(" INSERT INTO GEN_I18N_SICC_PAIS ( ");
                updateInter.append("OID_I18N, ");
                updateInter.append("ATTR_ENTI, "); 
                updateInter.append("ATTR_NUM_ATRI, "); 
                updateInter.append("IDIO_OID_IDIO, "); 
                updateInter.append("VAL_I18N, ");                 
                updateInter.append("VAL_OID "); 
                updateInter.append(" ) VALUES ( ");
                updateInter.append(" GEN_i18n_SEQ.NEXTVAL , ");                
                updateInter.append(" 'ZON_ESTAD_ZONA', ");
                updateInter.append(" 1, ");
                updateInter.append(genDetaSiccData.getIdioOidIdio().getId() + ", ");
                updateInter.append(" '" + genDetaSiccData.getDeta() + "', ");
                updateInter.append(zonEstadZona.getId().longValue() + " )");                
                try {
                    int cantRegActualizados = bs.dbService.executeUpdate(updateInter.toString());
                } catch (Exception ex) {
                    ex.printStackTrace();
                    throw new MareException(ex, UtilidadesError.armarCodigoError(
                                            CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS));
                }
            }
            StringBuffer update = new StringBuffer();        

            update.append("UPDATE ZON_ESTAD_ZONA SET ");                
            update.append("IND_INIC = " + zonEstadZona.getIndInic());
            update.append(", IMPO_VENT_MINI = " +  zonEstadZona.getImpoVentMini());
            update.append(", NUM_CONS_MIN = " + zonEstadZona.getNumConsMin());
            update.append(", NUM_PEDI_ZONA = " + zonEstadZona.getNumPediZona());
            update.append(", VALO_TIEM_MINI = " + zonEstadZona.getValoTiemMini());
            update.append(" WHERE OID_ESTA_ZONA = " + zonEstadZona.getId());
            
            try {
                int cantRegActualizados = bs.dbService.executeUpdate(update.toString());
            } catch (Exception ex) {
                ex.printStackTrace();
                throw new MareException(ex, UtilidadesError.armarCodigoError(
                                        CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS));
            }
        } catch (Exception ex) {
                ex.printStackTrace();
                throw new MareException(ex, UtilidadesError.armarCodigoError(
                                        CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS));
        }
        
        UtilidadesLog.info("DAOEstadosZonas.update(ZonEstadZonaData zonEstadZona, Vector localizationLabels): Salida");
    }

    public void remove(Vector zonEstadZonaOids) throws MareException
    {
        UtilidadesLog.info("DAOEstadosZonas.remove(Vector zonEstadZonaOids): Entrada");
        RecordSet rs = null;
        BelcorpService bs = UtilidadesEJB.getBelcorpService();
        StringBuffer update = new StringBuffer();
        StringBuffer updateInter = new StringBuffer();
        
        int cant = zonEstadZonaOids.size();
        ZonEstadZonaData zonEstadZonaData = null;
        String oids = "";
        
        for (int j = 0; j < cant; j++) {
            zonEstadZonaData = (ZonEstadZonaData)zonEstadZonaOids.get(j);
             
            oids = oids + "," + zonEstadZonaData.getId();
        }
        update.append("delete from ZON_ESTAD_ZONA ");
        update.append("where OID_ESTA_ZONA in ( " + oids.substring(1) + ") ");

        updateInter.append("delete from GEN_I18N_SICC_PAIS ");
        updateInter.append(" where VAL_OID in ( " + oids.substring(1) + ") ");
        updateInter.append(" and ATTR_NUM_ATRI = 1 ");
        updateInter.append(" and ATTR_ENTI = 'ZON_ESTAD_ZONA' ");
        try {
            int cantRegActualizados = bs.dbService.executeUpdate(update.toString());
            int cantRegActualizados1 = bs.dbService.executeUpdate(updateInter.toString());
            
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

        UtilidadesLog.info("DAOEstadosZonas.remove(Vector zonEstadZonaOids): Salida");
    }

    public Vector query(ZonEstadZonaData zonEstadZonaFrom, ZonEstadZonaData zonEstadZonaTo, HashMap userProperties, Integer pageCount, Integer pageSize) throws MareException
    {
        UtilidadesLog.info("DAOEstadosZonas.query(ZonEstadZonaData zonEstadZonaFrom, ZonEstadZonaData zonEstadZonaTo, HashMap userProperties, Integer pageCount, Integer pageSize): Entrada");
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
        Property idioma = (Property)userProperties.get("Idioma");
        
        query.append("SELECT ZEZ.OID_ESTA_ZONA, ZEZ.COD_ESTA_ZONA, ");
        query.append("SM.OID_MARC, SM.COD_MARC, SM.DES_MARC, ");
        query.append("i18n.VAL_I18N, ZEZ.IND_INIC, ZEZ.IMPO_VENT_MINI, ");
        query.append("ZEZ.NUM_CONS_MIN, ZEZ.NUM_PEDI_ZONA, VALO_TIEM_MINI ");
        query.append("FROM ZON_ESTAD_ZONA ZEZ, v_gen_i18n_sicc i18n, SEG_MARCA SM ");        
        query.append("WHERE MARC_OID_MARC = SM.OID_MARC ");
        query.append("AND OID_ESTA_ZONA = i18n.val_oid ");
        query.append("AND i18n.ATTR_ENTI = 'ZON_ESTAD_ZONA' ");
        query.append("AND i18n.ATTR_NUM_ATRI = 1 ");
        query.append("AND i18n.IDIO_OID_IDIO = " + (String)idioma.getValue());
        
        //si viene el oid, es una modificacion!
        if (zonEstadZonaFrom.getId()!=null)
            query.append(" AND ZEZ.OID_ESTA_ZONA = " + zonEstadZonaFrom.getId().longValue());
        
        if(zonEstadZonaFrom.getPaisOidPais()!=null)
            if(zonEstadZonaFrom.getPaisOidPais().getId()!= null){
                query.append(" AND ZEZ.PAIS_OID_PAIS = " + zonEstadZonaFrom.getPaisOidPais().getId().longValue());
            }
        
        if(zonEstadZonaFrom.getCodEstaZona()!= null){
            query.append(" AND ZEZ.COD_ESTA_ZONA = '" + zonEstadZonaFrom.getCodEstaZona() + "'");
        }

        if(zonEstadZonaFrom.getMarcOidMarc()!=null)
            if(zonEstadZonaFrom.getMarcOidMarc().getId()!= null){
                query.append(" AND ZEZ.MARC_OID_MARC = " + zonEstadZonaFrom.getMarcOidMarc().getId().longValue());
            }

        if(zonEstadZonaFrom.getDescripcion()!= null){
            query.append(" AND upper(i18n.val_i18n) LIKE '%" + zonEstadZonaFrom.getDescripcion().trim().toUpperCase() + "%'");
        }
        
        UtilidadesLog.debug("zonEstadZonaFrom.getIndInic(): " + zonEstadZonaFrom.getIndInic());
        
        if(zonEstadZonaFrom.getIndInic()!= null)
            query.append(" AND ZEZ.IND_INIC = " + zonEstadZonaFrom.getIndInic().trim());
        
        if(zonEstadZonaFrom.getImpoVentMini()!= null){
            query.append(" AND ZEZ.IMPO_VENT_MINI = " + zonEstadZonaFrom.getImpoVentMini());
        }
        
        if(zonEstadZonaFrom.getNumConsMin()!= null){
            query.append(" AND ZEZ.NUM_CONS_MIN = " + zonEstadZonaFrom.getNumConsMin().longValue());
        }

        if(zonEstadZonaFrom.getNumPediZona()!= null){
            query.append(" AND ZEZ.NUM_PEDI_ZONA = " + zonEstadZonaFrom.getNumPediZona().longValue());
        }
        
        if(zonEstadZonaFrom.getValoTiemMini()!= null){
            query.append(" AND ZEZ.VALO_TIEM_MINI = " + zonEstadZonaFrom.getValoTiemMini());
        }

        try {
           rs = bs.dbService.executeStaticQuery(query.toString());
        } catch (Exception ex) {
          UtilidadesLog.error("ERROR ", ex);
          throw new MareException(ex, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS));
        }        
        
        int cant = rs.getRowCount();
        Vector result = new Vector();
        
        ZonEstadZonaData zonEstadZonaData = null;
        SegMarcaData segMarcaData = null;
        int rsSaltar = (pageCount.intValue() - 1) * pageSize.intValue();
        int rsMostrar = ((pageSize.intValue() == Integer.MAX_VALUE) ? pageSize.intValue() : (pageSize.intValue() + 1)) + rsSaltar;
        
        UtilidadesLog.debug("rsSaltar: " + rsSaltar);
        UtilidadesLog.debug("rsMostrar: " + rsMostrar);
        
        for(int i=0; i < cant; i++){
        
            if(i < rsSaltar ) {
                continue;
            }
            if(i < rsMostrar){
                zonEstadZonaData = new ZonEstadZonaData();
                UtilidadesLog.debug("1");
                if (rs.getValueAt(i,"OID_ESTA_ZONA")!=null)
                    zonEstadZonaData.setId(Long.valueOf(((BigDecimal)rs.getValueAt(i,"OID_ESTA_ZONA")).toString()));
                UtilidadesLog.debug("2");    
                if (rs.getValueAt(i,"COD_ESTA_ZONA")!=null)    
                    zonEstadZonaData.setCodEstaZona((String)rs.getValueAt(i,"COD_ESTA_ZONA"));
                UtilidadesLog.debug("3");    
                
                segMarcaData = new SegMarcaData();
                if (rs.getValueAt(i,"OID_MARC")!=null)    
                    segMarcaData.setId(Long.valueOf(((BigDecimal)rs.getValueAt(i,"OID_MARC")).toString()));
                UtilidadesLog.debug("a");        
                if (rs.getValueAt(i,"COD_MARC")!=null)            
                    segMarcaData.setCodMarc((String)rs.getValueAt(i,"COD_MARC"));
                UtilidadesLog.debug("3b");        
                if (rs.getValueAt(i,"DES_MARC")!=null)
                    segMarcaData.setDesMarc((String)rs.getValueAt(i,"DES_MARC"));
                    
                UtilidadesLog.debug("segMarcaData: " + segMarcaData);        
                    
                zonEstadZonaData.setMarcOidMarc(segMarcaData);
                
                UtilidadesLog.debug("4");    
                if (rs.getValueAt(i,"VAL_I18N")!=null)        
                    zonEstadZonaData.setDescripcion((String)rs.getValueAt(i,"VAL_I18N"));
                if (rs.getValueAt(i,"IND_INIC")!=null){
                    UtilidadesLog.debug("IND_INIC: " + Long.valueOf(((BigDecimal)rs.getValueAt(i,"IND_INIC")).toString()).longValue());    
                    if (Long.valueOf(((BigDecimal)rs.getValueAt(i,"IND_INIC")).toString()).longValue()==1){
                        UtilidadesLog.debug("1!!");
                        zonEstadZonaData.setIndInic(new String("1"));
                    }else{
                        UtilidadesLog.debug("no 1!!");
                        zonEstadZonaData.setIndInic(new String("0"));
                    }
                }
                UtilidadesLog.debug("5");    
                if (rs.getValueAt(i,"IMPO_VENT_MINI")!=null)    
                    zonEstadZonaData.setImpoVentMini(Double.valueOf(((BigDecimal)rs.getValueAt(i,"IMPO_VENT_MINI")).toString()));
                UtilidadesLog.debug("6");                    
                if (rs.getValueAt(i,"NUM_CONS_MIN")!=null)
                    zonEstadZonaData.setNumConsMin(Long.valueOf(((BigDecimal)rs.getValueAt(i,"NUM_CONS_MIN")).toString()));
                UtilidadesLog.debug("7");                    
                if (rs.getValueAt(i,"NUM_PEDI_ZONA")!=null)
                    zonEstadZonaData.setNumPediZona(Long.valueOf(((BigDecimal)rs.getValueAt(i,"NUM_PEDI_ZONA")).toString()));
                UtilidadesLog.debug("8");                    
                if (rs.getValueAt(i,"VALO_TIEM_MINI")!=null)    
                    zonEstadZonaData.setValoTiemMini(Double.valueOf(((BigDecimal)rs.getValueAt(i,"VALO_TIEM_MINI")).toString())); 
                UtilidadesLog.debug("9");                     
                result.add(zonEstadZonaData);
            } else {
               break;
            }
        }
        UtilidadesLog.debug("result: " + result);
       
        UtilidadesLog.info("DAOEstadosZonas.query(ZonEstadZonaData zonEstadZonaFrom, ZonEstadZonaData zonEstadZonaTo, HashMap userProperties, Integer pageCount, Integer pageSize): Salida");
        return result;
    }

}