package es.indra.sicc.logicanegocio.fac;

import es.indra.mare.common.mii.MareMiiServiceNotFoundException;
import es.indra.mare.common.mii.services.jdbcservice.RecordSet;
import es.indra.sicc.util.BelcorpService;
import es.indra.sicc.util.CodigosError;
import es.indra.sicc.util.UtilidadesEJB;
import es.indra.sicc.util.UtilidadesError;
import es.indra.sicc.util.UtilidadesLog;
import java.math.BigDecimal;
import java.util.Vector;
import es.indra.belcorp.mso.FacTipoImpreData;
import es.indra.mare.common.exception.MareException;
import es.indra.belcorp.mso.FacImpreVirtuData;
import es.indra.sicc.util.UtilidadesBD;

import java.util.Hashtable;
import java.util.HashMap;

public class DAOImpresoraVirtual 
{
    public DAOImpresoraVirtual()
    {
    }
    
    public Vector query(FacTipoImpreData facTipoImpreFrom, FacTipoImpreData facTipoImpreTo, HashMap userProperties) throws MareException
    {
          UtilidadesLog.info("DAOImpresoraVirtual.query(FacTipoImpreData facTipoImpreFrom, FacTipoImpreData facTipoImpreTo, HashMap userProperties): Entrada");
          
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
    
          query.append(" SELECT OID_TIPO, VAL_NOMB_PRIN_SEND ");
          query.append(" FROM FAC_TIPO_IMPRE ");
          query.append(" ORDER BY VAL_NOMB_PRIN_SEND ");      
    
          try {
              rs = bs.dbService.executeStaticQuery(query.toString());
          } catch (Exception ex) {
              UtilidadesLog.error("ERROR ", ex);
              throw new MareException(ex, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS));
          }
          
          int cant = rs.getRowCount();
          
          FacTipoImpreData facTipoImpreData = null;
          
          for(int i=0; i < cant; i++){
              facTipoImpreData = new FacTipoImpreData();
              
              facTipoImpreData.setId(Long.valueOf(((BigDecimal)rs.getValueAt(i,"OID_TIPO")).toString()));
              facTipoImpreData.setValNombPrinSend((String)rs.getValueAt(i,"VAL_NOMB_PRIN_SEND"));
              
              resultado.add(facTipoImpreData);
          }
          
          UtilidadesLog.info("DAOImpresoraVirtual.query(FacTipoImpreData facTipoImpreFrom, FacTipoImpreData facTipoImpreTo, HashMap userProperties): Salida");
          
          return resultado;
    }

    public Hashtable guardar(FacImpreVirtuData facImpreVirtu) throws MareException
    {
        UtilidadesLog.info("DAOImpresoraVirtual.guardar(FacImpreVirtuData facImpreVirtu): Entrada");
        RecordSet rs = null;
        BelcorpService bs = UtilidadesEJB.getBelcorpService();
        
        StringBuffer update = new StringBuffer();
        
        RecordSet rsPK = null;
        StringBuffer query = new StringBuffer();      
        Long id = null;
        
        query.append(" SELECT FAC_IMVI_SEQ.NEXTVAL FROM DUAL");         
        
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
        
        update.append(" INSERT INTO FAC_IMPRE_VIRTU ( ");        
        update.append("OID_IMPR, "); 
        update.append("COD_IMPR, "); 
        update.append("DES_IMPR, "); 
        update.append("TIIM_OID_TIPO, "); 
        update.append("IND_ESTA_ACTI, "); 
        update.append("VAL_TAMA_BUFF, "); 
        update.append("NUM_SECU, "); 
        update.append("VAL_ATR1, "); 
        update.append("VAL_ATR2, "); 
        update.append("VAL_ATR3, "); 
        update.append("VAL_ATR4 "); 
  
        update.append(" ) VALUES ( ");
        update.append(id + ", ");
        update.append(" '" + facImpreVirtu.getCodImpr() + "', ");
        update.append(" '" + facImpreVirtu.getDesImpr() + "', ");
        update.append(facImpreVirtu.getTiimOidTipo().getId() + ", ");
        update.append(facImpreVirtu.getIndEstaActi() + ", ");
        update.append(facImpreVirtu.getValTamaBuff() + ", ");
        update.append(facImpreVirtu.getNumSecu());
        
        if (facImpreVirtu.getValAtr1() != null) {
            update.append(", '" + facImpreVirtu.getValAtr1() + "' ");
        } else {
            update.append(", NULL ");
        }
        
        if (facImpreVirtu.getValAtr2() != null) {
            update.append(", '" + facImpreVirtu.getValAtr2() + "' ");
        } else {
            update.append(", NULL ");
        }
        
        if (facImpreVirtu.getValAtr3() != null) {
            update.append(", '" + facImpreVirtu.getValAtr3() + "' ");
        } else {
            update.append(", NULL ");
        }
        
        if (facImpreVirtu.getValAtr4() != null) {
            update.append(", '" + facImpreVirtu.getValAtr4() + "' ");
        } else {
            update.append(", NULL ");
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
    
        UtilidadesLog.info("DAOImpresoraVirtual.guardar(FacImpreVirtuData facImpreVirtu): Salida");
        return primaryKey;
    }

    public Vector query(FacImpreVirtuData facImpreVirtuFrom, FacImpreVirtuData facImpreVirtuTo, HashMap userProperties, Integer pageCount, Integer pageSize) throws MareException
    {
        UtilidadesLog.info("DAOImpresoraVirtual.query(FacImpreVirtuData facImpreVirtuFrom, FacImpreVirtuData facImpreVirtuTo, HashMap userProperties, Integer pageCount, Integer pageSize): Entrada");
        
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

        query.append(" select OID_IMPR, COD_IMPR, DES_IMPR, TIIM_OID_TIPO, VAL_NOMB_PRIN_SEND, IND_ESTA_ACTI, ");
        query.append(" VAL_TAMA_BUFF, NUM_SECU, VAL_ATR1, VAL_ATR2,VAL_ATR3, VAL_ATR4  ");
        query.append(" from FAC_IMPRE_VIRTU, FAC_TIPO_IMPRE ");
        query.append(" where TIIM_OID_TIPO = OID_TIPO ");        
        
        // Para la busqueda
        if(facImpreVirtuFrom.getCodImpr()!= null){
            query.append(" and COD_IMPR = '" + facImpreVirtuFrom.getCodImpr() + "' ");
        }
        
        if(facImpreVirtuFrom.getDesImpr()!= null){
            query.append(" and DES_IMPR like '" + facImpreVirtuFrom.getDesImpr() + "' ");
        }
                
        if(facImpreVirtuFrom.getTiimOidTipo()!= null){
            query.append(" and TIIM_OID_TIPO = " + facImpreVirtuFrom.getTiimOidTipo().getId());
        }
        
        if(facImpreVirtuFrom.getIndEstaActi()!= null){
            query.append(" and IND_ESTA_ACTI = " + facImpreVirtuFrom.getIndEstaActi());
        }        
        
        if(facImpreVirtuFrom.getValAtr1()!= null){
            query.append(" and VAL_ATR1 like '" + facImpreVirtuFrom.getValAtr1() + "' ");
        }         
        
        // Para el detalle
        if(facImpreVirtuFrom.getId()!= null){
            query.append(" and OID_IMPR = " + facImpreVirtuFrom.getId());
        }

        try {
           rs = bs.dbService.executeStaticQuery(query.toString());
        } catch (Exception ex) {
          UtilidadesLog.error("ERROR ", ex);
          throw new MareException(ex, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS));
        }
        
        
        int cant = rs.getRowCount();
        Vector result = new Vector();
        FacImpreVirtuData facImpreVirtuData = null;
        FacTipoImpreData facTipoImpreData = null;
        
        int rsSaltar = (pageCount.intValue() - 1) * pageSize.intValue();
        int rsMostrar = ((pageSize.intValue() == Integer.MAX_VALUE) ? pageSize.intValue() : (pageSize.intValue() + 1)) + rsSaltar;
        
        UtilidadesLog.debug("rsSaltar: " + rsSaltar);
        UtilidadesLog.debug("rsMostrar: " + rsMostrar);
        
        for(int i=0; i < cant; i++){
        
            if(i < rsSaltar ) {
                continue;
            }
            
            if(i < rsMostrar){
                facImpreVirtuData = new FacImpreVirtuData();
                
                facImpreVirtuData.setId(Long.valueOf(((BigDecimal)rs.getValueAt(i,"OID_IMPR")).toString()));
                facImpreVirtuData.setCodImpr((String)rs.getValueAt(i,"COD_IMPR"));
                facImpreVirtuData.setDesImpr((String)rs.getValueAt(i,"DES_IMPR"));
                
                facTipoImpreData = new FacTipoImpreData();
                facTipoImpreData.setId(Long.valueOf(((BigDecimal)rs.getValueAt(i,"TIIM_OID_TIPO")).toString()));  
                facTipoImpreData.setValNombPrinSend((String)rs.getValueAt(i,"VAL_NOMB_PRIN_SEND"));        
                
                facImpreVirtuData.setTiimOidTipo(facTipoImpreData);          
                
                facImpreVirtuData.setIndEstaActi(Long.valueOf(((BigDecimal)rs.getValueAt(i,"IND_ESTA_ACTI")).toString()));
                facImpreVirtuData.setValTamaBuff(Long.valueOf(((BigDecimal)rs.getValueAt(i,"VAL_TAMA_BUFF")).toString()));
                facImpreVirtuData.setNumSecu(Long.valueOf(((BigDecimal)rs.getValueAt(i,"NUM_SECU")).toString()));
                
                if(rs.getValueAt(i,"VAL_ATR1")!= null){
                    facImpreVirtuData.setValAtr1((String)rs.getValueAt(i,"VAL_ATR1"));
                }
                
                if(rs.getValueAt(i,"VAL_ATR2")!= null){
                    facImpreVirtuData.setValAtr2((String)rs.getValueAt(i,"VAL_ATR2"));
                }
                
                if(rs.getValueAt(i,"VAL_ATR3")!= null){
                    facImpreVirtuData.setValAtr3((String)rs.getValueAt(i,"VAL_ATR3"));
                }
                
                if(rs.getValueAt(i,"VAL_ATR4")!= null){
                    facImpreVirtuData.setValAtr4((String)rs.getValueAt(i,"VAL_ATR4"));
                }
                
                result.add(facImpreVirtuData);
                
            } else {
               break;
            }
        }
        
        UtilidadesLog.debug("result: " + result);
       
        UtilidadesLog.info("DAOImpresoraVirtual.query(FacImpreVirtuData facImpreVirtuFrom, FacImpreVirtuData facImpreVirtuTo, HashMap userProperties, Integer pageCount, Integer pageSize): Salida");
        return result;
    }

    public void remove(Vector facImpreVirtuFrom) throws MareException
    {
        UtilidadesLog.info("DAOImpresoraVirtual.remove(Vector facImpreVirtuFrom): Entrada");
        RecordSet rs = null;
        BelcorpService bs = UtilidadesEJB.getBelcorpService();
        StringBuffer update = new StringBuffer();
        
        int cant = facImpreVirtuFrom.size();
        FacImpreVirtuData facImpreVirtuData = null;
        String oids = "";
        
        for (int j = 0; j < cant; j++) {
            facImpreVirtuData = (FacImpreVirtuData)facImpreVirtuFrom.get(j);
             
            oids = oids + "," + facImpreVirtuData.getId();
        }
        
        update.append("delete FAC_IMPRE_VIRTU ");
        update.append("where OID_IMPR in ( " + oids.substring(1) + ") ");
        
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
        
        UtilidadesLog.info("DAOImpresoraVirtual.remove(Vector facImpreVirtuFrom): Salida");
        
    }

    public void update(FacImpreVirtuData facImpreVirtu) throws MareException
    {
        UtilidadesLog.info("DAOImpresoraVirtual.update(FacImpreVirtuData facImpreVirtu): Entrada");
       
        RecordSet rs = null;
        BelcorpService bs = UtilidadesEJB.getBelcorpService();
        
        StringBuffer update = new StringBuffer();
        
        update.append("UPDATE FAC_IMPRE_VIRTU SET ");
        update.append("COD_IMPR = '" + facImpreVirtu.getCodImpr() + "', ");     
        update.append("DES_IMPR = '" + facImpreVirtu.getDesImpr() + "', ");  
        update.append("TIIM_OID_TIPO = " + facImpreVirtu.getTiimOidTipo().getId() + ", ");
        update.append("IND_ESTA_ACTI = " + facImpreVirtu.getIndEstaActi() + ", ");
        update.append("VAL_TAMA_BUFF = " + facImpreVirtu.getValTamaBuff() + ", ");
        update.append("NUM_SECU = " + facImpreVirtu.getNumSecu());
        
        if (facImpreVirtu.getValAtr1() != null) {
            update.append(", VAL_ATR1 = '" + facImpreVirtu.getValAtr1() + "' ");     
        } else {
            update.append(", VAL_ATR1 = NULL ");
        }
        
        if (facImpreVirtu.getValAtr2() != null) {
            update.append(", VAL_ATR2 = '" + facImpreVirtu.getValAtr2() + "' ");    
        } else {
            update.append(", VAL_ATR2 = NULL ");
        }
        
        if (facImpreVirtu.getValAtr3() != null) {
            update.append(", VAL_ATR3 = '" + facImpreVirtu.getValAtr3() + "' ");    
        } else {
            update.append(", VAL_ATR3 = NULL ");
        }
        
        if (facImpreVirtu.getValAtr4() != null) {
            update.append(", VAL_ATR4 = '" + facImpreVirtu.getValAtr4() + "' ");    
        } else {
            update.append(", VAL_ATR4 = NULL ");
        }        
        
        update.append(" WHERE OID_IMPR= " + facImpreVirtu.getId());   
        
        try {
            int cantRegActualizados = bs.dbService.executeUpdate(update.toString());
        } catch (Exception ex) {
            ex.printStackTrace();
            throw new MareException(ex, UtilidadesError.armarCodigoError(
                                    CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS));
        }
               
        UtilidadesLog.info("DAOImpresoraVirtual.update(FacImpreVirtuData facImpreVirtu): Salida");
        
    }
    
    
    /**
     * Cambio 20080765
     * Recupera el OID de la impresora virtual asociada al formulario cuya rutina de diseño
     * y subacceso son los recibidos por parametro.
     * Si no encuentra tal impresora, devuelve null
     * @param rutina
     * @param subacceso
     * @return OID de la impresora recuperada, null si no recupera ninguna
     * @throws MareException
     * @author dmorello
     * @since 21/08/2009
     */
    public Long obtenerImpresoraPorRutinaFormulario(String rutina, Long subacceso) throws MareException {
        UtilidadesLog.info("DAOImpresoraVirtual.obtenerImpresoraPorRutinaFormulario(String rutina, Long subacceso): Entrada");
        
        BelcorpService bs = UtilidadesEJB.getBelcorpService();
        StringBuffer query = new StringBuffer();
        Vector params = new Vector();
        
        query.append("SELECT asign.imvi_oid_impr");
        query.append("  FROM fac_formu formulario, fac_asign_impre asign");
        query.append(" WHERE formulario.val_ruti_dise_form = ?");
        params.add(rutina);
        query.append("   AND formulario.oid_form = asign.fors_oid_form");
        query.append("   AND asign.sbac_oid_sbac = ?");
        params.add(subacceso);
        
        RecordSet rs = null;
        try {
            rs = bs.dbService.executePreparedQuery(query.toString(), params);
        } catch (Exception e) {
            String error = CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS;
            throw new MareException(e, UtilidadesError.armarCodigoError(error));
        }
        
        Long oidImpresora = null;
        if (rs != null && !rs.esVacio()) {
            oidImpresora = Long.valueOf(UtilidadesBD.convertirALong(rs.getValueAt(0,0)));
        }
        
        UtilidadesLog.debug("oidImpresora: " + oidImpresora);
        
        UtilidadesLog.info("DAOImpresoraVirtual.obtenerImpresoraPorRutinaFormulario(String rutina, Long subacceso): Salida");
        return oidImpresora;
    }
}