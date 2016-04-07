package es.indra.sicc.logicanegocio.fac;

import es.indra.belcorp.mso.FacParamFactuData;
import es.indra.belcorp.mso.SegPaisViewData;
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

public class DAOParametrosFacturacion 
{
    public DAOParametrosFacturacion()
    {
    }
    
    public Hashtable guardar(FacParamFactuData facParamFactu) throws MareException
    {
        UtilidadesLog.info("DAOParametrosFacturacion.guardar(FacParamFactuData facParamFactu): Entrada");
        RecordSet rs = null;
        BelcorpService bs = UtilidadesEJB.getBelcorpService();
        
        StringBuffer update = new StringBuffer();
        
        RecordSet rsPK = null;
        StringBuffer query = new StringBuffer();      
        Long id = null;
        
        query.append(" SELECT FAC_PAFA_SEQ.NEXTVAL FROM DUAL");         
        
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
        
        update.append(" INSERT INTO FAC_PARAM_FACTU ( ");
        update.append("OID_PARA, "); 
        update.append("PAIS_OID_PAIS, "); 
        update.append("NUM_MAXI_CAMP_PRD, "); 
        update.append("NUM_MAXI_PEDI_PROY, "); 
        update.append("IND_DOCU_MONO_PAGI, "); 
        update.append("IND_TIPO_PROY_REGI, "); 
        update.append("IND_MOST_VENC_CUPO, "); 
        
        update.append("VAL_MONT_LIMI_UIT, "); 
        update.append("IND_CHEQ_CLIE_NUEV, "); 
        update.append("COD_MODA_DIST, "); 
        update.append("IND_PREC_CONT "); 
       
        update.append(" ) VALUES ( ");
        update.append(id + ", ");
        update.append(facParamFactu.getPaisOidPais().getId() + ", ");
        update.append(facParamFactu.getNumMaxiCampPrd() + ", ");
        update.append(facParamFactu.getNumMaxiPediProy() + ", ");
        update.append(facParamFactu.getIndDocuMonoPagi() + ", ");
        update.append(facParamFactu.getIndTipoProyRegi() + ", ");
        update.append(facParamFactu.getIndMostVencCupo());
        
        if (facParamFactu.getValMontLimiUit() != null) {
            update.append(", " + facParamFactu.getValMontLimiUit());
        } else {
            update.append(", NULL ");
        }
        
        if (facParamFactu.getIndCheqClieNuev() != null) {
            update.append(", " + facParamFactu.getIndCheqClieNuev());
        } else {
            update.append(", NULL ");
        }
        
        if (facParamFactu.getCodModaDist() != null) {
            update.append(", '" + facParamFactu.getCodModaDist() + "' ");
        } else {
            update.append(", NULL ");
        }
        
        // No se trata en el MMG el mantenimiento del campo IND_PREC_CONT
        update.append(" , NULL) ");
        
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
    
        UtilidadesLog.info("DAOParametrosFacturacion.guardar(FacParamFactuData facParamFactu): Salida");
        return primaryKey;
    }
    
    public void remove(Vector facParamFactuFrom) throws MareException
    {
        UtilidadesLog.info("DAOParametrosFacturacion.remove(Vector facParamFactuFrom): Entrada");
        RecordSet rs = null;
        BelcorpService bs = UtilidadesEJB.getBelcorpService();
        StringBuffer update = new StringBuffer();
        
        int cant = facParamFactuFrom.size();
        FacParamFactuData facParamFactuData = null;
        String oids = "";
        
        for (int j = 0; j < cant; j++) {
            facParamFactuData = (FacParamFactuData)facParamFactuFrom.get(j);
             
            oids = oids + "," + facParamFactuData.getId();
        }
        
        update.append("delete FAC_PARAM_FACTU ");
        update.append("where OID_PARA in ( " + oids.substring(1) + ") ");
        
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
        
        UtilidadesLog.info("DAOParametrosFacturacion.remove(Vector facParamFactuFrom): Salida");
    }
    
    public Vector query(FacParamFactuData facParamFactuFrom, FacParamFactuData facParamFactuTo, HashMap userProperties, Integer pageCount, Integer pageSize) throws MareException
    {
        UtilidadesLog.info("DAOParametrosFacturacion.query(FacParamFactuData facParamFactuFrom, FacParamFactuData facParamFactuTo, HashMap userProperties, Integer pageCount, Integer pageSize): Entrada");
       
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

        query.append(" select OID_PARA, PAIS_OID_PAIS, NUM_MAXI_CAMP_PRD, ");
        query.append(" NUM_MAXI_PEDI_PROY, IND_DOCU_MONO_PAGI, ");
        query.append(" IND_TIPO_PROY_REGI, IND_MOST_VENC_CUPO, ");
        query.append(" VAL_MONT_LIMI_UIT, IND_CHEQ_CLIE_NUEV, ");
        query.append(" COD_MODA_DIST, IND_PREC_CONT  ");
        query.append(" from FAC_PARAM_FACTU   ");
                
        if(facParamFactuFrom.getId()!= null){
            query.append(" where 1= 1 ");       
        } else {
            query.append(" where PAIS_OID_PAIS = " + facParamFactuFrom.getPaisOidPais().getId());     
        }        
        
        // Para la busqueda       
        if(facParamFactuFrom.getNumMaxiCampPrd()!= null){
            query.append(" and NUM_MAXI_CAMP_PRD = " + facParamFactuFrom.getNumMaxiCampPrd());
        }
        
        if(facParamFactuFrom.getNumMaxiPediProy()!= null){
            query.append(" and NUM_MAXI_PEDI_PROY = " + facParamFactuFrom.getNumMaxiPediProy());
        }
        
        if(facParamFactuFrom.getIndDocuMonoPagi()!= null){
            query.append(" and IND_DOCU_MONO_PAGI = " + facParamFactuFrom.getIndDocuMonoPagi());
        }
        
        if(facParamFactuFrom.getIndTipoProyRegi()!= null){
            query.append(" and IND_TIPO_PROY_REGI = " + facParamFactuFrom.getIndTipoProyRegi());
        }
        
        if(facParamFactuFrom.getIndMostVencCupo()!= null){
            query.append(" and  IND_MOST_VENC_CUPO = " + facParamFactuFrom.getIndMostVencCupo());
        }
        
        if(facParamFactuFrom.getValMontLimiUit()!= null){
            query.append(" and VAL_MONT_LIMI_UIT = " + facParamFactuFrom.getValMontLimiUit());
        }
        
        if(facParamFactuFrom.getCodModaDist()!= null){
            query.append(" and COD_MODA_DIST like '" + facParamFactuFrom.getCodModaDist() + "' ");
        }
        
        // Para el detalle
        if(facParamFactuFrom.getId()!= null){
            query.append(" and OID_PARA = " + facParamFactuFrom.getId());
        }
        
        
        try {
           rs = bs.dbService.executeStaticQuery(query.toString());
        } catch (Exception ex) {
          UtilidadesLog.error("ERROR ", ex);
          throw new MareException(ex, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS));
        }
        
        
        int cant = rs.getRowCount();
        Vector result = new Vector();
        FacParamFactuData facParamFactuData = null;
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
                facParamFactuData = new FacParamFactuData();
                
                facParamFactuData.setId(Long.valueOf(((BigDecimal)rs.getValueAt(i,"OID_PARA")).toString()));
                facParamFactuData.setNumMaxiCampPrd(Long.valueOf(((BigDecimal)rs.getValueAt(i,"NUM_MAXI_CAMP_PRD")).toString()));
                facParamFactuData.setNumMaxiPediProy(Long.valueOf(((BigDecimal)rs.getValueAt(i,"NUM_MAXI_PEDI_PROY")).toString()));
                facParamFactuData.setIndDocuMonoPagi(Long.valueOf(((BigDecimal)rs.getValueAt(i,"IND_DOCU_MONO_PAGI")).toString()));
                facParamFactuData.setIndTipoProyRegi(Long.valueOf(((BigDecimal)rs.getValueAt(i,"IND_TIPO_PROY_REGI")).toString()));
                facParamFactuData.setIndMostVencCupo(Long.valueOf(((BigDecimal)rs.getValueAt(i,"IND_MOST_VENC_CUPO")).toString()));
                                
                segPaisViewData = new SegPaisViewData();
                segPaisViewData.setId(Long.valueOf(((BigDecimal)rs.getValueAt(i,"PAIS_OID_PAIS")).toString()));           
                facParamFactuData.setPaisOidPais(segPaisViewData);                 
                
                     
                if((BigDecimal)rs.getValueAt(i,"VAL_MONT_LIMI_UIT") != null){
                    facParamFactuData.setValMontLimiUit(Long.valueOf(((BigDecimal)rs.getValueAt(i,"VAL_MONT_LIMI_UIT")).toString()));
                }
                
                if((BigDecimal)rs.getValueAt(i,"IND_CHEQ_CLIE_NUEV") != null){
                    facParamFactuData.setIndCheqClieNuev(Long.valueOf(((BigDecimal)rs.getValueAt(i,"IND_CHEQ_CLIE_NUEV")).toString()));
                }
                
                if((String)rs.getValueAt(i,"COD_MODA_DIST") != null){
                    facParamFactuData.setCodModaDist((String)rs.getValueAt(i,"COD_MODA_DIST"));
                }
                
               // El campo IND_PREC_CONT no esta contemplado en el MMG
               
               
                result.add(facParamFactuData);
                
            } else {
               break;
            }
        }
        
        UtilidadesLog.debug("result: " + result);
       
        UtilidadesLog.info("DAOParametrosFacturacion.query(FacParamFactuData facParamFactuFrom, FacParamFactuData facParamFactuTo, HashMap userProperties, Integer pageCount, Integer pageSize): Salida");
        return result;
        
    }
    
    public void update(FacParamFactuData facParamFactu) throws MareException
    {
        UtilidadesLog.info("DAOParametrosFacturacion.update(FacParamFactuData facParamFactu): Entrada");
       
        RecordSet rs = null;
        BelcorpService bs = UtilidadesEJB.getBelcorpService();
        
        StringBuffer update = new StringBuffer();
        
        update.append("UPDATE FAC_PARAM_FACTU SET ");
        update.append("NUM_MAXI_CAMP_PRD = " + facParamFactu.getNumMaxiCampPrd() + ", ");
        update.append("NUM_MAXI_PEDI_PROY = " + facParamFactu.getNumMaxiPediProy() + ", ");
        update.append("IND_DOCU_MONO_PAGI = " + facParamFactu.getIndDocuMonoPagi() + ", ");
        update.append("IND_TIPO_PROY_REGI = " + facParamFactu.getIndTipoProyRegi() + ", ");
        update.append("IND_MOST_VENC_CUPO = " + facParamFactu.getIndMostVencCupo());
        
        if (facParamFactu.getValMontLimiUit() != null) {
            update.append(", VAL_MONT_LIMI_UIT = " + facParamFactu.getValMontLimiUit());
        } else {
            update.append(", VAL_MONT_LIMI_UIT = NULL ");
        }
        
        if (facParamFactu.getIndCheqClieNuev() != null) {
            update.append(", IND_CHEQ_CLIE_NUEV = " + facParamFactu.getIndCheqClieNuev());
        } else {
            update.append(", IND_CHEQ_CLIE_NUEV = NULL ");
        }
        
        if (facParamFactu.getCodModaDist() != null) {
            update.append(", COD_MODA_DIST = '" + facParamFactu.getCodModaDist() + "' ");
        } else {
            update.append(", COD_MODA_DIST = NULL ");
        }
        
        // El campo IND_PREC_CONT no esta contemplado en el MMG
        
        update.append(" WHERE OID_PARA = " + facParamFactu.getId());   
        
        try {
            int cantRegActualizados = bs.dbService.executeUpdate(update.toString());
        } catch (Exception ex) {
            ex.printStackTrace();
            throw new MareException(ex, UtilidadesError.armarCodigoError(
                                    CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS));
        }
               
        UtilidadesLog.info("DAOParametrosFacturacion.update(FacParamFactuData facParamFactu): Salida");
    }
}