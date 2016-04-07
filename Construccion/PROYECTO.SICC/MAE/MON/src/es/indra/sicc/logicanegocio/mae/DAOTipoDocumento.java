package es.indra.sicc.logicanegocio.mae;
import es.indra.belcorp.mso.MaeTipoDocumData;
import es.indra.belcorp.mso.FacTipoDocumData;
import es.indra.belcorp.mso.GenDetaSiccData;
import es.indra.belcorp.mso.SegPaisViewData;
import es.indra.mare.common.exception.MareException;
import es.indra.mare.common.mgu.manager.Property;
import es.indra.mare.common.mii.MareMiiServiceNotFoundException;
import es.indra.mare.common.mii.services.jdbcservice.RecordSet;
import es.indra.sicc.util.BelcorpService;
import es.indra.sicc.util.CodigosError;
import es.indra.sicc.util.DTOBelcorp;
import es.indra.sicc.util.SecuenciadorOID;
import es.indra.sicc.util.UtilidadesEJB;
import es.indra.sicc.util.UtilidadesError;
import es.indra.sicc.util.UtilidadesLog;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Vector;
public class DAOTipoDocumento 
{
  public DAOTipoDocumento()
  {
  }
  /*
  MAE_TIPO_DOCUM
  OID_TIPO_DOCU 
  PAIS_OID_PAIS
  COD_TIPO_DOCU 
  VAL_SIGL 
  VAL_LONG 
  IND_OBLI 
  IND_DNI 
  IND_DOC_IDEN_FISC 
  TIDO_OID_TIPO_DOCU 
  */
  
  public Hashtable insertar(MaeTipoDocumData maeTipoDocumData, Vector localizationLabels , HashMap userProperties) throws MareException{
  
      UtilidadesLog.info("DAOTipoDocumento.guardar(MaeTipoDocumData maeTipoDocumData, Vector localizationLabels , HashMap userProperties): Entrada");
      RecordSet rs = null;
      BelcorpService bs = UtilidadesEJB.getBelcorpService();
      Long id = SecuenciadorOID.obtenerSiguienteValor("MAE_TDOC_SEQ");
      StringBuffer update = new StringBuffer();        

      update.append("INSERT INTO MAE_TIPO_DOCUM ( ");
      update.append("OID_TIPO_DOCU "); 
      if (maeTipoDocumData.getPaisOidPais()!=null)
          update.append(", PAIS_OID_PAIS"); 
      if (maeTipoDocumData.getCodTipoDocu()!=null)
          update.append(", COD_TIPO_DOCU"); 
      if (maeTipoDocumData.getValSigl()!=null)
          update.append(", VAL_SIGL"); 
      if (maeTipoDocumData.getValLong()!=null)
          update.append(", VAL_LONG"); 
      if (maeTipoDocumData.getIndObli()!=null)
          update.append(", IND_OBLI");           
      if (maeTipoDocumData.getIndDni()!=null)
          update.append(", IND_DNI");        
      if (maeTipoDocumData.getIndDocIdenFisc()!=null)
          update.append(", IND_DOC_IDEN_FISC");       
      if (maeTipoDocumData.getTidoOidTipoDocu()!=null)
          update.append(", TIDO_OID_TIPO_DOCU"); 
      
      update.append(" ) VALUES ( ");    
      update.append(id);
      if (maeTipoDocumData.getPaisOidPais()!=null)
          update.append(", " + maeTipoDocumData.getPaisOidPais().getId());    
      if (maeTipoDocumData.getCodTipoDocu()!=null)
          update.append(", '" + maeTipoDocumData.getCodTipoDocu() + "'");    
      if (maeTipoDocumData.getValSigl()!=null)
          update.append(", '" + maeTipoDocumData.getValSigl() + "'");    
      if (maeTipoDocumData.getValLong()!=null)
          update.append(", " + maeTipoDocumData.getValLong());    
      if (maeTipoDocumData.getIndObli()!=null)
          update.append(", '" + maeTipoDocumData.getIndObli() + "'");    
      if (maeTipoDocumData.getIndDni()!=null)
          update.append(", '" + maeTipoDocumData.getIndDni() + "'");    
      if (maeTipoDocumData.getIndDocIdenFisc()!=null)
          update.append(", '" + maeTipoDocumData.getIndDocIdenFisc() + "'");    
      if (maeTipoDocumData.getTidoOidTipoDocu()!=null)
          update.append(", " + maeTipoDocumData.getTidoOidTipoDocu().getId());    
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
      Long idInter = null;        
      StringBuffer updateInter = null;

      for(int i= 0; i< cant; i++){   
          
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
          updateInter.append(" GEN_i18n_SEQ.NEXTVAL , ");
          updateInter.append(" 'MAE_TIPO_DOCUM', ");
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
      
      UtilidadesLog.info("DAOTipoDocumento.guardar(MaeTipoDocumData maeTipoDocumData, Vector localizationLabels , HashMap userProperties): Salida");
      return primaryKey;
  }
  
 public Vector query(MaeTipoDocumData maeTipoDocumFrom, MaeTipoDocumData maeTipoDocumTo, HashMap userProperties, Integer pageCount, Integer pageSize) throws MareException 
 {

       UtilidadesLog.info("DAOTipoDocumento.query(MaeTipoDocumData maeTipoDocumFrom, MaeTipoDocumData maeTipoDocumTo, HashMap userProperties, Integer pageCount, Integer pageSize): Entrada");
        
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
        /*
        MAE_TIPO_DOCUM
        OID_TIPO_DOCU 
        COD_TIPO_DOCU 
        VAL_SIGL 
        VAL_LONG 
        IND_OBLI 
        IND_DNI 
        IND_DOC_IDEN_FISC 
        TIDO_OID_TIPO_DOCU 
        */  
        query.append(" SELECT m.OID_TIPO_DOCU, i18n.VAL_I18N , VAL_SIGL, VAL_LONG, m.COD_TIPO_DOCU, PAIS_OID_PAIS, COD_PAIS,");
        query.append(" IND_OBLI, IND_DNI, IND_DOC_IDEN_FISC, m.TIDO_OID_TIPO_DOCU, f.DES_TIPO_DOCU DES_TIPO_F , f.COD_TIPO_DOCU COD_TIPO_F ");
        query.append(" FROM MAE_TIPO_DOCUM m, v_gen_i18n_sicc i18n, FAC_TIPO_DOCUM f , SEG_PAIS ");        
        query.append(" WHERE m.OID_TIPO_DOCU = i18n.val_oid ");
        query.append(" and i18n.ATTR_ENTI = 'MAE_TIPO_DOCUM' ");
        query.append(" and i18n.ATTR_NUM_ATRI = 1 ");
        query.append(" and i18n.IDIO_OID_IDIO = " + (String)idioma.getValue());
        query.append(" and m.TIDO_OID_TIPO_DOCU = f.OID_TIPO_DOCU ");
        query.append(" and OID_PAIS = PAIS_OID_PAIS ");
        // Para la busqueda
        if(maeTipoDocumFrom.getId()!=null){
            query.append(" and m.OID_TIPO_DOCU = " +maeTipoDocumFrom.getId() );
        }
        
        if(maeTipoDocumFrom.getCodTipoDocu()!= null){
            query.append(" and m.COD_TIPO_DOCU like '" + maeTipoDocumFrom.getCodTipoDocu() + "' ");
        }

         if(maeTipoDocumFrom.getValSigl()!= null){
            query.append(" and VAL_SIGL like '" + maeTipoDocumFrom.getValSigl() + "' ");
        }
         if(maeTipoDocumFrom.getValLong() != null){
            query.append(" and VAL_LONG = " + maeTipoDocumFrom.getValLong()) ;
        }
        if(maeTipoDocumFrom.getIndObli() != null){
            query.append(" and IND_OBLI like '" + maeTipoDocumFrom.getIndObli() + "' ");
        }
        if(maeTipoDocumFrom.getIndDni() != null){
            query.append(" and IND_DNI like '" + maeTipoDocumFrom.getIndDni() + "' ");
        }
        if(maeTipoDocumFrom.getIndDocIdenFisc() != null){
            query.append(" and IND_DOC_IDEN_FISC like '" + maeTipoDocumFrom.getIndDocIdenFisc() + "' ");
        }
        if(maeTipoDocumFrom.getTidoOidTipoDocu() != null){
            query.append(" and m.TIDO_OID_TIPO_DOCU = " + maeTipoDocumFrom.getTidoOidTipoDocu().getId());
        }

        try {
           rs = bs.dbService.executeStaticQuery(query.toString());
        } catch (Exception ex) {
          UtilidadesLog.error("ERROR ", ex);
          throw new MareException(ex, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS));
        }
        
        
        int cant = rs.getRowCount();
        Vector result = new Vector();
        
        MaeTipoDocumData maeTipoDocumData = null;
        FacTipoDocumData facTipoDocumData =null;
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
                maeTipoDocumData = new MaeTipoDocumData();
                facTipoDocumData = new FacTipoDocumData();
                segPaisViewData = new SegPaisViewData();
                
                facTipoDocumData.setCodTipoDocu(rs.getValueAt(i,"COD_TIPO_F").toString());
                facTipoDocumData.setDesTipoDocu(rs.getValueAt(i,"DES_TIPO_F").toString());
                facTipoDocumData.setId(Long.valueOf(((BigDecimal)rs.getValueAt(i,"TIDO_OID_TIPO_DOCU")).toString()));
                maeTipoDocumData.setTidoOidTipoDocu(facTipoDocumData);
                
                segPaisViewData.setCodPais(rs.getValueAt(i,"COD_PAIS").toString());
                segPaisViewData.setId(Long.valueOf(((BigDecimal)rs.getValueAt(i,"PAIS_OID_PAIS")).toString()));
                maeTipoDocumData.setPaisOidPais(segPaisViewData);
                
                maeTipoDocumData.setDescripcion(rs.getValueAt(i,"VAL_I18N").toString());
                maeTipoDocumData.setId(Long.valueOf(((BigDecimal)rs.getValueAt(i,"OID_TIPO_DOCU")).toString()));
                maeTipoDocumData.setCodTipoDocu(rs.getValueAt(i,"COD_TIPO_DOCU").toString());  
                if(rs.getValueAt(i,"VAL_SIGL")!=null){
                  maeTipoDocumData.setValSigl(rs.getValueAt(i,"VAL_SIGL").toString());  
                }
                if(rs.getValueAt(i,"VAL_LONG")!=null){
                  maeTipoDocumData.setValLong(Long.valueOf(((BigDecimal)rs.getValueAt(i,"VAL_LONG")).toString()));  
                }
                maeTipoDocumData.setIndObli(rs.getValueAt(i,"IND_OBLI").toString());
                maeTipoDocumData.setIndDni(rs.getValueAt(i,"IND_DNI").toString());
                maeTipoDocumData.setIndDocIdenFisc(rs.getValueAt(i,"IND_DOC_IDEN_FISC").toString());
                
                
                result.add(maeTipoDocumData);
                
            } else {
               break;
            }
        }
        
        UtilidadesLog.debug("result: " + result);
       
        UtilidadesLog.info("DAOTipoDocumento.query(MaeTipoDocumData maeTipoDocumFrom, MaeTipoDocumData maeTipoDocumTo, HashMap userProperties, Integer pageCount, Integer pageSize): Salida");
        return result;
   
 }
 public void remove(Vector maeTipoDocum ) throws MareException
 {
   
    UtilidadesLog.info("DAOTipoDocumento.remove(Vector maeTipoDocum ): Entrada");
        RecordSet rs = null;
        BelcorpService bs = UtilidadesEJB.getBelcorpService();
        StringBuffer update = new StringBuffer();
        
        
        int cant = maeTipoDocum.size();
        MaeTipoDocumData maeTipoDocumData = null;
        String oids = "";
        
        for (int j = 0; j < cant; j++) {
            maeTipoDocumData = (MaeTipoDocumData)maeTipoDocum.get(j);
             
            oids = oids + "," + maeTipoDocumData.getId();
        }
        
        update.append("delete MAE_TIPO_DOCUM ");
        update.append("where OID_TIPO_DOCU in ( " + oids.substring(1) + ") ");
        
       
        
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
        
        UtilidadesLog.info("DAOTipoDocumento.remove(Vector maeTipoDocum ): Salida");
   
 }
 
 public void update(MaeTipoDocumData maeTipoDocumData, Vector localizationLabels) throws MareException 
 {
   
        UtilidadesLog.info("DAOTipoDocumento.update(MaeTipoDocumData maeTipoDocumData, Vector localizationLabels): Entrada");
       
        RecordSet rs = null;
        BelcorpService bs = UtilidadesEJB.getBelcorpService();
        StringBuffer update = new StringBuffer();
          /*
        MAE_TIPO_DOCUM
        OID_TIPO_DOCU 
        COD_TIPO_DOCU 
        VAL_SIGL 
        VAL_LONG 
        IND_OBLI 
        IND_DNI 
        IND_DOC_IDEN_FISC 
        TIDO_OID_TIPO_DOCU 
        */
        update.append("UPDATE MAE_TIPO_DOCUM SET ");
        update.append(" COD_TIPO_DOCU = '" + maeTipoDocumData.getCodTipoDocu()+"' ");
        if (maeTipoDocumData.getPaisOidPais() != null) {
            update.append(", PAIS_OID_PAIS = " + maeTipoDocumData.getPaisOidPais().getId() );
        }
        if (maeTipoDocumData.getValSigl() != null) {
            update.append(", VAL_SIGL = '" + maeTipoDocumData.getValSigl()+"' " );
        }
        if (maeTipoDocumData.getValLong() != null) {
            update.append(", VAL_LONG = " + maeTipoDocumData.getValLong() );
        }
        if (maeTipoDocumData.getIndObli() != null) {
            update.append(", IND_OBLI = '" + maeTipoDocumData.getIndObli()+"' " );
        }
        if (maeTipoDocumData.getIndDni() != null) {
            update.append(", IND_DNI = " + maeTipoDocumData.getIndDni() );
        }
        if (maeTipoDocumData.getIndDocIdenFisc() != null) {
            update.append(", IND_DOC_IDEN_FISC = '" + maeTipoDocumData.getIndDocIdenFisc()+"' " );
        }
        if (maeTipoDocumData.getTidoOidTipoDocu() != null) {
            update.append(", TIDO_OID_TIPO_DOCU = " + maeTipoDocumData.getTidoOidTipoDocu().getId());
        }
        update.append(" WHERE OID_TIPO_DOCU = " + maeTipoDocumData.getId());   
        
        try {
            int cantRegActualizados = bs.dbService.executeUpdate(update.toString());
        } catch (Exception ex) {
            ex.printStackTrace();
            throw new MareException(ex, UtilidadesError.armarCodigoError(
                                    CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS));
        }
            
        int cant = localizationLabels.size();
        GenDetaSiccData genDetaSiccData = null;
        StringBuffer updateInter = null;
        try {
            updateInter = new StringBuffer();
            updateInter.append("DELETE GEN_I18N_SICC_PAIS ");
            updateInter.append(" where VAL_OID in ( " + maeTipoDocumData.getId() + ") ");
            updateInter.append(" and ATTR_NUM_ATRI = 1 ");
            updateInter.append(" and ATTR_ENTI = 'MAE_TIPO_DOCUM' ");
            
            int cantRegBorrados = bs.dbService.executeUpdate(updateInter.toString());
            
            for(int i= 0; i< cant; i++){                      
               
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
              updateInter.append(" GEN_i18n_SEQ.NEXTVAL , ");
              updateInter.append(" 'MAE_TIPO_DOCUM', ");
              updateInter.append(" 1, ");            
              updateInter.append(genDetaSiccData.getIdioOidIdio().getId() + ", ");
              updateInter.append(" '" + genDetaSiccData.getDeta() + "', ");
              updateInter.append(maeTipoDocumData.getId() + " )");
              int cantReginsertados = bs.dbService.executeUpdate(updateInter.toString());
            }

        } catch (Exception ex) {
            ex.printStackTrace();
            throw new MareException(ex, UtilidadesError.armarCodigoError(
                                    CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS));
        }
     
               
        UtilidadesLog.info("DAOTipoDocumento.update(MaeTipoDocumData maeTipoDocumData, Vector localizationLabels): Salida");
 }
 
     /**
      * Obtiene la lista de Siglas de Tipos de Documento
      * 
      * RCR: PER-SiCC-2010-0487
      * Fecha:   16/08/2010
      * @autor   Sergio Apaza
      */         
    public RecordSet obtenerTiposDocumentoPorSigla(DTOBelcorp dto) throws MareException {
        UtilidadesLog.info(" DAOMAEConfiguracionClientes.obtenerTiposDocumentoPorSigla(DTOBelcorp): Entrada");

        BelcorpService bs;
        try {
          bs = BelcorpService.getInstance();
        } catch (MareMiiServiceNotFoundException e) {
            UtilidadesLog.error("ERROR ", e);
            throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_PEDIR_UN_SERVICIO_MARE));
        }

        StringBuffer query = new StringBuffer();
        query.append(" SELECT OID_TIPO_DOCU oid, VAL_SIGL descripcion");
        query.append("   FROM MAE_TIPO_DOCUM ");
        query.append("  ORDER BY 2 ");

        RecordSet rs;
        
        try {
            rs = (RecordSet) bs.dbService.executeStaticQuery(query.toString());
        } catch (MareException me) {
            throw me;
        } catch (Exception e) {
            throw new MareException("Error al obtener tipos de documentos por Sigla", e);
        }

        UtilidadesLog.info(" DAOMAEConfiguracionClientes.obtenerTiposDocumentoPorSigla(DTOBelcorp): Salida");
        return rs;
    }
    
}