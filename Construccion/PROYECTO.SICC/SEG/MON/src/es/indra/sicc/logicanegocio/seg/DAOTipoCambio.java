package es.indra.sicc.logicanegocio.seg;

import es.indra.belcorp.mso.SegMonedData;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.Vector;
import es.indra.mare.common.exception.MareException;
import es.indra.belcorp.mso.SegTipoCambiData;
import java.util.Hashtable;
import es.indra.mare.common.mgu.manager.Property;
import es.indra.mare.common.mii.MareMiiServiceNotFoundException;
import es.indra.mare.common.mii.services.jdbcservice.RecordSet;
import es.indra.sicc.util.BelcorpService;
import es.indra.sicc.util.CodigosError;
import es.indra.sicc.util.UtilidadesEJB;
import es.indra.sicc.util.UtilidadesError;
import es.indra.sicc.util.UtilidadesLog;
import java.math.BigDecimal;
import java.sql.Date;

public class DAOTipoCambio 
{
    public DAOTipoCambio()
    {
    }
       
    public Hashtable guardar(SegTipoCambiData segTipoCambi) throws MareException
    {
        UtilidadesLog.info("DAOTipoCambio.guardar(SegTipoCambiData segTipoCambi): Entrada");
        RecordSet rs = null;
        BelcorpService bs = UtilidadesEJB.getBelcorpService();
        
        StringBuffer update = new StringBuffer();
        
        RecordSet rsPK = null;
        StringBuffer query = new StringBuffer();      
        Long id = null;
        
        query.append(" SELECT SEG_TICA_SEQ.NEXTVAL FROM DUAL");         
        
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
        
        
        SimpleDateFormat simpledateformat = new SimpleDateFormat("dd/MM/yyyy");

        String fechaDesde = simpledateformat.format(segTipoCambi.getFecDesd());
        String fechaHasta = simpledateformat.format(segTipoCambi.getFecHast());
        
        update.append(" INSERT INTO SEG_TIPO_CAMBI ( ");        
        update.append("OID_TIPO_CAMB, "); 
        update.append("MONE_OID_MON1, "); 
        update.append("MONE_OID_MON2, "); 
        update.append("VAL_TIPO_CAMB, "); 
        update.append("FEC_DESD, "); 
        update.append("FEC_HAST "); 
  
        update.append(" ) VALUES ( ");
        update.append(id + ", ");
        update.append(segTipoCambi.getMoneOidMon1().getId() + ", ");
        update.append(segTipoCambi.getMoneOidMon2().getId() + ", ");
        update.append(segTipoCambi.getValTipoCamb() + ", ");
        update.append(" TO_DATE('" + fechaDesde + "', 'DD/MM/YYYY'), ");
        update.append(" TO_DATE('" + fechaHasta + "', 'DD/MM/YYYY') ");
        
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
    
        UtilidadesLog.info("DAOTipoCambio.guardar(SegTipoCambiData segTipoCambi): Salida");
        return primaryKey;
    }
    
    public void remove(Vector segTipoCambiFrom) throws MareException
    {
        UtilidadesLog.info("DAOTipoCambio.remove(Vector segTipoCambiFrom): Entrada");
        RecordSet rs = null;
        BelcorpService bs = UtilidadesEJB.getBelcorpService();
        StringBuffer update = new StringBuffer();
        
        int cant = segTipoCambiFrom.size();
        SegTipoCambiData segTipoCambiData = null;
        String oids = "";
        
        for (int j = 0; j < cant; j++) {
            segTipoCambiData = (SegTipoCambiData)segTipoCambiFrom.get(j);
             
            oids = oids + "," + segTipoCambiData.getId();
        }
        
        update.append("delete SEG_TIPO_CAMBI ");
        update.append("where OID_TIPO_CAMB in ( " + oids.substring(1) + ") ");
        
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
        
        UtilidadesLog.info("DAOTipoCambio.remove(Vector segTipoCambiFrom): Salida");
    }
    
    public Vector query(SegTipoCambiData segTipoCambiFrom, SegTipoCambiData segTipoCambiTo, HashMap userProperties, Integer pageCount, Integer pageSize) throws MareException
    {
        UtilidadesLog.info("DAOTipoCambio.query(SegTipoCambiData segTipoCambiFrom, SegTipoCambiData segTipoCambiTo, HashMap userProperties, Integer pageCount, Integer pageSize): Entrada");
        
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
        
        query.append(" select OID_TIPO_CAMB, MONE_OID_MON1, i18n.VAL_I18N DESC_MONE, ");
        query.append(" MONE_OID_MON2, i18n1.VAL_I18N DESC_MONEC, ");
        query.append(" VAL_TIPO_CAMB, FEC_DESD, FEC_HAST ");
        query.append(" from SEG_TIPO_CAMBI, v_gen_i18n_sicc i18n, v_gen_i18n_sicc i18n1 ");        
        query.append(" WHERE  MONE_OID_MON1= i18n.val_oid ");        
        query.append(" and i18n.ATTR_ENTI = 'SEG_MONED' ");        
        query.append(" and i18n.ATTR_NUM_ATRI = 1 ");        
        query.append(" and i18n.IDIO_OID_IDIO = " + (String)idioma.getValue());     
        query.append(" and MONE_OID_MON2 = i18n1.val_oid ");        
        query.append(" and i18n1.ATTR_ENTI = 'SEG_MONED' ");        
        query.append(" and i18n1.ATTR_NUM_ATRI = 1 ");        
        query.append(" and i18n1.IDIO_OID_IDIO = " + (String)idioma.getValue());   
        
        // Para la busqueda
        if(segTipoCambiFrom.getMoneOidMon1()!= null){
            query.append(" and MONE_OID_MON1 = " + segTipoCambiFrom.getMoneOidMon1().getId());
        }
        
        if(segTipoCambiFrom.getMoneOidMon2()!= null){
            query.append(" and MONE_OID_MON2 =" + segTipoCambiFrom.getMoneOidMon2().getId());
        }
                
        if(segTipoCambiFrom.getFecDesd()!= null){
            SimpleDateFormat simpledateformat = new SimpleDateFormat("dd/MM/yyyy");
            String fechaDesde = simpledateformat.format(segTipoCambiFrom.getFecDesd());
            
            query.append(" and FEC_DESD = TO_DATE('" + fechaDesde + "', 'DD/MM/YYYY') ");
        }
        
        // Para el detalle
        if(segTipoCambiFrom.getId()!= null){
            query.append(" and OID_TIPO_CAMB = " + segTipoCambiFrom.getId());
        }

        try {
           rs = bs.dbService.executeStaticQuery(query.toString());
        } catch (Exception ex) {
          UtilidadesLog.error("ERROR ", ex);
          throw new MareException(ex, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS));
        }
        
        
        int cant = rs.getRowCount();
        Vector result = new Vector();
        SegTipoCambiData segTipoCambiData = null;
        SegMonedData segMonedData1 = null;
        SegMonedData segMonedData2 = null;
        
        int rsSaltar = (pageCount.intValue() - 1) * pageSize.intValue();
        int rsMostrar = ((pageSize.intValue() == Integer.MAX_VALUE) ? pageSize.intValue() : (pageSize.intValue() + 1)) + rsSaltar;
        
        UtilidadesLog.debug("rsSaltar: " + rsSaltar);
        UtilidadesLog.debug("rsMostrar: " + rsMostrar);
        
        for(int i=0; i < cant; i++){
        
            if(i < rsSaltar ) {
                continue;
            }
            
            if(i < rsMostrar){
                segTipoCambiData = new SegTipoCambiData();
                
                segTipoCambiData.setId(Long.valueOf(((BigDecimal)rs.getValueAt(i,"OID_TIPO_CAMB")).toString()));
                segTipoCambiData.setValTipoCamb(Double.valueOf(((BigDecimal)rs.getValueAt(i,"VAL_TIPO_CAMB")).toString()));  
                segTipoCambiData.setFecDesd((Date)rs.getValueAt(i,"FEC_DESD"));
                segTipoCambiData.setFecHast((Date)rs.getValueAt(i,"FEC_HAST"));
                
                segMonedData1 = new SegMonedData();
                segMonedData1.setId(Long.valueOf(((BigDecimal)rs.getValueAt(i,"MONE_OID_MON1")).toString()));   
                segMonedData1.setDescripcion((String)rs.getValueAt(i,"DESC_MONE")); 
                segTipoCambiData.setMoneOidMon1(segMonedData1);  
                
                segMonedData2 = new SegMonedData();
                segMonedData2.setId(Long.valueOf(((BigDecimal)rs.getValueAt(i,"MONE_OID_MON2")).toString()));   
                segMonedData2.setDescripcion((String)rs.getValueAt(i,"DESC_MONEC")); 
                segTipoCambiData.setMoneOidMon2(segMonedData2);  
                
                result.add(segTipoCambiData);
                
            } else {
               break;
            }
        }
       
        UtilidadesLog.info("DAOTipoCambio.query(SegTipoCambiData segTipoCambiFrom, SegTipoCambiData segTipoCambiTo, HashMap userProperties, Integer pageCount, Integer pageSize): Salida");
        return result;
    }
    
    public void update(SegTipoCambiData segTipoCambi) throws MareException
    {
        UtilidadesLog.info("DAOTipoCambio.update(SegTipoCambiData segTipoCambi): Entrada");
       
        RecordSet rs = null;
        BelcorpService bs = UtilidadesEJB.getBelcorpService();
        
        StringBuffer update = new StringBuffer();
        
        update.append("UPDATE SEG_TIPO_CAMBI SET ");
        update.append("VAL_TIPO_CAMB = " + segTipoCambi.getValTipoCamb());
        
        update.append(" WHERE OID_TIPO_CAMB= " + segTipoCambi.getId());   
        
        try {
            int cantRegActualizados = bs.dbService.executeUpdate(update.toString());
        } catch (Exception ex) {
            ex.printStackTrace();
            throw new MareException(ex, UtilidadesError.armarCodigoError(
                                    CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS));
        }
               
        UtilidadesLog.info("DAOTipoCambio.update(SegTipoCambiData segTipoCambi): Salida");
    }
}