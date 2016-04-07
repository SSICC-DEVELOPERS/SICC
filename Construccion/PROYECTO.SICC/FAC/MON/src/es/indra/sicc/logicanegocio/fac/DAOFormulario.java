package es.indra.sicc.logicanegocio.fac;

import es.indra.belcorp.mso.FacTecnoImpreData;
import es.indra.mare.common.mii.MareMiiServiceNotFoundException;
import es.indra.mare.common.mii.services.jdbcservice.RecordSet;
import es.indra.sicc.util.BelcorpService;
import es.indra.sicc.util.CodigosError;
import es.indra.sicc.util.UtilidadesEJB;
import es.indra.sicc.util.UtilidadesError;
import es.indra.sicc.util.UtilidadesLog;
import java.util.HashMap;
import java.util.Vector;
import es.indra.mare.common.exception.MareException;
import es.indra.belcorp.mso.FacDestiImpreData;
import es.indra.belcorp.mso.FacTipoFormuData;
import es.indra.belcorp.mso.FacTipoDocumData;
import java.math.BigDecimal;
import es.indra.belcorp.mso.FacFormuData;
import java.util.Hashtable;

public class DAOFormulario 
{
    public DAOFormulario()
    {
    }
    
    public Vector query(FacTecnoImpreData facTecnoImpreFrom, FacTecnoImpreData facTecnoImpreTo, HashMap userProperties) throws MareException
    {
      UtilidadesLog.info("DAOFormulario.query(FacTecnoImpreData facTecnoImpreFrom, FacTecnoImpreData facTecnoImpreTo, HashMap userProperties): Entrada");
      
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

      query.append(" SELECT OID_TECN, DES_TECN ");
      query.append(" FROM FAC_TECNO_IMPRE ");
      query.append(" ORDER BY DES_TECN ");      

      try {
          rs = bs.dbService.executeStaticQuery(query.toString());
      } catch (Exception ex) {
          UtilidadesLog.error("ERROR ", ex);
          throw new MareException(ex, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS));
      }
      
      int cant = rs.getRowCount();
      
      FacTecnoImpreData facTecnoImpreData = null;
      
      for(int i=0; i < cant; i++){
          facTecnoImpreData = new FacTecnoImpreData();
          
          facTecnoImpreData.setId(Long.valueOf(((BigDecimal)rs.getValueAt(i,"OID_TECN")).toString()));
          facTecnoImpreData.setDesTecn((String)rs.getValueAt(i,"DES_TECN"));
          
          resultado.add(facTecnoImpreData);
      }
      
      UtilidadesLog.info("DAOFormulario.query(FacTecnoImpreData facTecnoImpreFrom, FacTecnoImpreData facTecnoImpreTo, HashMap userProperties): Salida");
      
      return resultado;
      
    }

    public Vector query(FacDestiImpreData facDestiImpreFrom, FacDestiImpreData facDestiImpreTo, HashMap userProperties) throws MareException
    {
      UtilidadesLog.info("DAOFormulario.query(FacDestiImpreData facDestiImpreFrom, FacDestiImpreData facDestiImpreTo, HashMap userProperties): Entrada");
      
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

      query.append(" SELECT OID_DEST, DES_DEST ");
      query.append(" FROM FAC_DESTI_IMPRE ");
      query.append(" ORDER BY DES_DEST ");      

      try {
          rs = bs.dbService.executeStaticQuery(query.toString());
      } catch (Exception ex) {
          UtilidadesLog.error("ERROR ", ex);
          throw new MareException(ex, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS));
      }
      
      int cant = rs.getRowCount();
      
      FacDestiImpreData facDestiImpreData = null;
      
      for(int i=0; i < cant; i++){
          facDestiImpreData = new FacDestiImpreData();
          
          facDestiImpreData.setId(Long.valueOf(((BigDecimal)rs.getValueAt(i,"OID_DEST")).toString()));
          facDestiImpreData.setDesDest((String)rs.getValueAt(i,"DES_DEST"));
          
          resultado.add(facDestiImpreData);
      }
      
      UtilidadesLog.info("DAOFormulario.query(FacDestiImpreData facDestiImpreFrom, FacDestiImpreData facDestiImpreTo, HashMap userProperties): Salida");
      
      return resultado;
    }

    public Vector query(FacTipoFormuData facTipoFormuFrom, FacTipoFormuData facTipoFormuTo, HashMap userProperties) throws MareException
    {
      UtilidadesLog.info("DAOFormulario.query(FacTipoFormuData facTipoFormuFrom, FacTipoFormuData facTipoFormuTo, HashMap userProperties): Entrada");
      
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

      query.append(" SELECT OID_TIPO_FORM, VAL_DESC ");
      query.append(" FROM FAC_TIPO_FORMU ");
      query.append(" ORDER BY VAL_DESC ");      

      try {
          rs = bs.dbService.executeStaticQuery(query.toString());
      } catch (Exception ex) {
          UtilidadesLog.error("ERROR ", ex);
          throw new MareException(ex, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS));
      }
      
      int cant = rs.getRowCount();
      
      FacTipoFormuData facTipoFormuData = null;
      
      for(int i=0; i < cant; i++){
          facTipoFormuData = new FacTipoFormuData();
          
          facTipoFormuData.setId(Long.valueOf(((BigDecimal)rs.getValueAt(i,"OID_TIPO_FORM")).toString()));
          facTipoFormuData.setValDesc((String)rs.getValueAt(i,"VAL_DESC"));
          
          resultado.add(facTipoFormuData);
      }
      
      UtilidadesLog.info("DAOFormulario.query(FacTipoFormuData facTipoFormuFrom, FacTipoFormuData facTipoFormuTo, HashMap userProperties): Salida");
      
      return resultado;
    }

    public Vector query(FacTipoDocumData facTipoDocumFrom, FacTipoDocumData facTipoFormuTo, HashMap userProperties) throws MareException
    {
      UtilidadesLog.info("DAOFormulario.query(FacTipoDocumData facTipoDocumFrom, FacTipoDocumData facTipoFormuTo, HashMap userProperties): Entrada");
      
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

      query.append(" SELECT OID_TIPO_DOCU, DES_TIPO_DOCU ");
      query.append(" FROM FAC_TIPO_DOCUM ");
      query.append(" ORDER BY DES_TIPO_DOCU ");      

      try {
          rs = bs.dbService.executeStaticQuery(query.toString());
      } catch (Exception ex) {
          UtilidadesLog.error("ERROR ", ex);
          throw new MareException(ex, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS));
      }
      
      int cant = rs.getRowCount();
      
      FacTipoDocumData facTipoDocumData = null;
      
      for(int i=0; i < cant; i++){
          facTipoDocumData = new FacTipoDocumData();
          
          facTipoDocumData.setId(Long.valueOf(((BigDecimal)rs.getValueAt(i,"OID_TIPO_DOCU")).toString()));
          facTipoDocumData.setDesTipoDocu((String)rs.getValueAt(i,"DES_TIPO_DOCU"));
          
          resultado.add(facTipoDocumData);
      }
      
      UtilidadesLog.info("DAOFormulario.query(FacTipoDocumData facTipoDocumFrom, FacTipoDocumData facTipoFormuTo, HashMap userProperties): Salida");
      
      return resultado;

    }
    
    public Hashtable guardarFormulario(FacFormuData facFormu) throws MareException
    {
        UtilidadesLog.info("DAOFormulario.guardarFormulario(FacFormuData facFormu): Entrada");
        RecordSet rs = null;
        BelcorpService bs = UtilidadesEJB.getBelcorpService();
        
        StringBuffer update = new StringBuffer();
        
        RecordSet rsPK = null;
        StringBuffer query = new StringBuffer();      
        Long id = null;
        
        query.append(" SELECT FAC_FORS_SEQ.NEXTVAL FROM DUAL");         
        
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
        
        update.append(" INSERT INTO FAC_FORMU ( ");
        update.append("OID_FORM, "); 
        update.append("COD_FORM, "); 
        update.append("NUM_LINE, "); 
        update.append("VAL_TAMA_FORM, "); 
        update.append("VAL_RUTI_DISE_FORM, "); 
        update.append("IND_IMPR, "); 
        update.append("IND_PREI, "); 
        update.append("IND_SPOO_INDI, "); 
        update.append("TEIM_OID_TECN, "); 
        update.append("VAL_NOMB_FORM, "); 
        update.append("IND_ACTI, "); 
        update.append("IND_NUM_OFIC, "); 
        update.append("NUM_LINE_SALT_PAGI, "); 
        update.append("DEIM_OID_DEST_IMPR, "); 
        update.append("TIDO_OID_TIPO_DOCU, "); 
        update.append("TIFO_OID_TIPO_FORM "); 
  
        update.append(" ) VALUES ( ");
        update.append(id + ", ");
        update.append(" '" + facFormu.getCodForm() + "', ");
        update.append(facFormu.getNumLine() + ", ");
        update.append(" '" +facFormu.getValTamaForm() + "', ");
        update.append(" '" + facFormu.getValRutiDiseForm() + "', ");
        update.append(facFormu.getIndImpr() + ", ");
        update.append(facFormu.getIndPrei() + ", ");
        update.append(facFormu.getIndSpooIndi() + ", ");
        update.append(facFormu.getTeimOidTecn().getId() + ", ");
        update.append(" '" + facFormu.getValNombForm() + "', ");
        update.append(facFormu.getIndActi() + ", ");
        update.append(facFormu.getIndNumOfic() + ", ");
        update.append(facFormu.getNumLineSaltPagi() + ", ");        
        update.append(facFormu.getDeimOidDestImpr().getId());        
        
        if (facFormu.getTidoOidTipoDocu() != null) {
            update.append(", " + facFormu.getTidoOidTipoDocu().getId());
        } else {
            update.append(", NULL ");
        }
        
        if (facFormu.getTifoOidTipoForm() != null) {
            update.append(", " + facFormu.getTifoOidTipoForm().getId());
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
    
        UtilidadesLog.info("DAOFormulario.guardarFormulario(FacFormuData facFormu): Salida");
        return primaryKey;
    }
    
    public Vector query(FacFormuData facFormuFrom, FacFormuData facFormuTo, HashMap userProperties, Integer pageCount, Integer pageSize) throws MareException
    {
        UtilidadesLog.info("DAOFormulario.query(FacFormuData facFormuFrom, FacFormuData facFormuTo, HashMap userProperties, Integer pageCount, Integer pageSize): Entrada");
        
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

        query.append(" SELECT formu.OID_FORM, formu.COD_FORM, formu.NUM_LINE,  ");
        query.append(" formu.VAL_TAMA_FORM, formu.VAL_RUTI_DISE_FORM, ");
        query.append(" formu.IND_IMPR, formu.IND_PREI, formu.IND_SPOO_INDI,  ");
        query.append(" formu.TEIM_OID_TECN, formu.VAL_NOMB_FORM, formu.IND_ACTI,  ");
        query.append(" formu.IND_NUM_OFIC, formu.NUM_LINE_SALT_PAGI,  ");
        query.append(" formu.TIDO_OID_TIPO_DOCU, tipodocu.DES_TIPO_DOCU,  ");
        query.append(" formu.DEIM_OID_DEST_IMPR, formu.TIFO_OID_TIPO_FORM ");
        query.append(" from FAC_FORMU formu, FAC_TIPO_DOCUM tipoDocu ");
        query.append(" where tipoDocu.OID_TIPO_DOCU(+) = formu.TIDO_OID_TIPO_DOCU ");
        
        // Para la busqueda
        if(facFormuFrom.getCodForm()!= null){
            query.append(" and formu.COD_form = '" + facFormuFrom.getCodForm() + "' ");
        }
        
        if(facFormuFrom.getIndImpr()!= null){
            query.append(" and formu.IND_IMPR = " + facFormuFrom.getIndImpr());
        }
        
        if(facFormuFrom.getValNombForm()!= null){
            query.append(" and formu.VAL_NOMB_FORM like '" + facFormuFrom.getValNombForm() + "' " );
        }
        
        if(facFormuFrom.getIndActi()!= null){
            query.append(" and formu.IND_ACTI = " + facFormuFrom.getIndActi());
        }
        
        if(facFormuFrom.getTidoOidTipoDocu()!= null){
            query.append(" and formu.TIDO_OID_TIPO_DOCU = " + facFormuFrom.getTidoOidTipoDocu().getId());
        }     
        
        // Para el detalle
        if(facFormuFrom.getId()!= null){
            query.append(" and formu.OID_FORM = " + facFormuFrom.getId());
        }

        try {
           rs = bs.dbService.executeStaticQuery(query.toString());
        } catch (Exception ex) {
          UtilidadesLog.error("ERROR ", ex);
          throw new MareException(ex, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS));
        }
        
        
        int cant = rs.getRowCount();
        Vector result = new Vector();
        FacFormuData facFormuData = null;
        FacTipoDocumData facTipoDocumData = null;
        BigDecimal oidTipoDocu = null;
        BigDecimal oidTipoForm = null;
        FacTecnoImpreData facTecnoImpreData = null;
        FacDestiImpreData facDestiImpreData = null;
        FacTipoFormuData facTipoFormuData = null;
        
        int rsSaltar = (pageCount.intValue() - 1) * pageSize.intValue();
        int rsMostrar = ((pageSize.intValue() == Integer.MAX_VALUE) ? pageSize.intValue() : (pageSize.intValue() + 1)) + rsSaltar;
        
        UtilidadesLog.debug("rsSaltar: " + rsSaltar);
        UtilidadesLog.debug("rsMostrar: " + rsMostrar);
        
        for(int i=0; i < cant; i++){
        
            if(i < rsSaltar ) {
                continue;
            }
            
            if(i < rsMostrar){
                facFormuData = new FacFormuData();
                
                facFormuData.setId(Long.valueOf(((BigDecimal)rs.getValueAt(i,"OID_FORM")).toString()));
                facFormuData.setCodForm((String)rs.getValueAt(i,"COD_FORM"));
                facFormuData.setNumLine(Long.valueOf(((BigDecimal)rs.getValueAt(i,"NUM_LINE")).toString()));
                facFormuData.setValTamaForm((String)rs.getValueAt(i,"VAL_TAMA_FORM"));
                facFormuData.setValRutiDiseForm((String)rs.getValueAt(i,"VAL_RUTI_DISE_FORM"));
                facFormuData.setIndImpr(((BigDecimal)rs.getValueAt(i,"IND_IMPR")).toString());
                facFormuData.setIndPrei(Long.valueOf(((BigDecimal)rs.getValueAt(i,"IND_PREI")).toString()));
                facFormuData.setIndSpooIndi(Long.valueOf(((BigDecimal)rs.getValueAt(i,"IND_SPOO_INDI")).toString()));
                
                facTecnoImpreData = new FacTecnoImpreData();
                facTecnoImpreData.setId(Long.valueOf(((BigDecimal)rs.getValueAt(i,"TEIM_OID_TECN")).toString()));           
                facFormuData.setTeimOidTecn(facTecnoImpreData);                 
                
                facFormuData.setValNombForm((String)rs.getValueAt(i,"VAL_NOMB_FORM"));
                facFormuData.setIndActi(((BigDecimal)rs.getValueAt(i,"IND_ACTI")).toString());
                facFormuData.setIndNumOfic(((BigDecimal)rs.getValueAt(i,"IND_NUM_OFIC")).toString());
                facFormuData.setNumLineSaltPagi(Long.valueOf(((BigDecimal)rs.getValueAt(i,"NUM_LINE_SALT_PAGI")).toString()));
                
                facDestiImpreData = new FacDestiImpreData();
                facDestiImpreData.setId(Long.valueOf(((BigDecimal)rs.getValueAt(i,"DEIM_OID_DEST_IMPR")).toString()));        
                facFormuData.setDeimOidDestImpr(facDestiImpreData);  
                
                oidTipoDocu = (BigDecimal)rs.getValueAt(i,"TIDO_OID_TIPO_DOCU");                
                if(oidTipoDocu != null){
                    facTipoDocumData = new FacTipoDocumData();
                    
                    facTipoDocumData.setId(Long.valueOf(oidTipoDocu.toString())); 
                    facTipoDocumData.setDesTipoDocu((String)rs.getValueAt(i,"DES_TIPO_DOCU"));                
                    facFormuData.setTidoOidTipoDocu(facTipoDocumData);                
                }
                
                oidTipoForm = (BigDecimal)rs.getValueAt(i,"TIFO_OID_TIPO_FORM");                
                if(oidTipoForm != null){
                    facTipoFormuData = new FacTipoFormuData();
                    
                    facTipoFormuData.setId(Long.valueOf(oidTipoForm.toString()));                 
                    facFormuData.setTifoOidTipoForm(facTipoFormuData);                
                }
                
                result.add(facFormuData);
                
            } else {
               break;
            }
        }
        
        UtilidadesLog.debug("result: " + result);
       
        UtilidadesLog.info("DAOFormulario.query(FacFormuData facFormuFrom, FacFormuData facFormuTo, HashMap userProperties, Integer pageCount, Integer pageSize): Salida");
        return result;
    }
    
    public void remove(Vector facFormuFrom) throws MareException
    {
        UtilidadesLog.info("DAOFormulario.remove(Vector facFormuFrom): Entrada");
        RecordSet rs = null;
        BelcorpService bs = UtilidadesEJB.getBelcorpService();
        StringBuffer update = new StringBuffer();
        
        int cant = facFormuFrom.size();
        FacFormuData facFormuData = null;
        String oidFormularios = "";
        
        for (int j = 0; j < cant; j++) {
            facFormuData = (FacFormuData)facFormuFrom.get(j);
             
            oidFormularios = oidFormularios + "," + facFormuData.getId();
        }
        
        update.append("delete FAC_FORMU formu ");
        update.append("where formu.OID_FORM in ( " + oidFormularios.substring(1) + ") ");
        
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
        
        UtilidadesLog.info("DAOFormulario.remove(Vector facFormuFrom): Salida");
    }
    
    public void update(FacFormuData facFormu) throws MareException
    {
        UtilidadesLog.info("DAOFormulario.update(FacFormuData facFormu): Entrada");
       
        RecordSet rs = null;
        BelcorpService bs = UtilidadesEJB.getBelcorpService();
        
        StringBuffer update = new StringBuffer();
        
        update.append("UPDATE FAC_FORMU SET ");
        update.append("COD_FORM = '" + facFormu.getCodForm() + "', ");
        update.append("NUM_LINE = " + facFormu.getNumLine() + ", ");
        update.append("VAL_TAMA_FORM = '" + facFormu.getValTamaForm() + "', ");
        update.append("VAL_RUTI_DISE_FORM = '" + facFormu.getValRutiDiseForm() + "', ");
        update.append("IND_IMPR = " + facFormu.getIndImpr() + ", ");
        update.append("IND_PREI = " + facFormu.getIndPrei() + ", ");
        update.append("IND_SPOO_INDI = " + facFormu.getIndSpooIndi() + ", ");
        update.append("TEIM_OID_TECN = " + facFormu.getTeimOidTecn().getId() + ", ");
        update.append("VAL_NOMB_FORM = '" + facFormu.getValNombForm() + "', ");
        update.append("IND_ACTI = " + facFormu.getIndActi() + ", ");
        update.append("IND_NUM_OFIC = " + facFormu.getIndNumOfic() + ", ");
        update.append("NUM_LINE_SALT_PAGI = " + facFormu.getNumLineSaltPagi() + ", ");
        update.append("DEIM_OID_DEST_IMPR = " + facFormu.getDeimOidDestImpr().getId());               
        
        if (facFormu.getTidoOidTipoDocu() != null) {
            update.append(", TIDO_OID_TIPO_DOCU = " + facFormu.getTidoOidTipoDocu().getId());
        } else {
            update.append(", TIDO_OID_TIPO_DOCU = NULL ");
        }
        
        if (facFormu.getTifoOidTipoForm() != null) {
            update.append(", TIFO_OID_TIPO_FORM = " + facFormu.getTifoOidTipoForm().getId());
        } else {
            update.append(", TIFO_OID_TIPO_FORM = NULL ");
        }        
        
        update.append(" WHERE OID_form= " + facFormu.getId());   
        
        try {
            int cantRegActualizados = bs.dbService.executeUpdate(update.toString());
        } catch (Exception ex) {
            ex.printStackTrace();
            throw new MareException(ex, UtilidadesError.armarCodigoError(
                                    CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS));
        }
               
        UtilidadesLog.info("DAOFormulario.update(FacFormuData facFormu): Salida");
    }
}