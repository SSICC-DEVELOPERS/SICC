package es.indra.sicc.logicanegocio.seg;

import es.indra.belcorp.mso.GenDetaSiccData;
import es.indra.belcorp.mso.SegMonedData;
import java.util.HashMap;
import java.util.Vector;
import es.indra.mare.common.exception.MareException;
import es.indra.belcorp.mso.BelFormaPagoTaponData;
import es.indra.belcorp.mso.SegPaisData;
import es.indra.belcorp.mso.SegPaisViewData;

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

public class DAOPais 
{
    public DAOPais()
    {
    }
    
    public Vector query(BelFormaPagoTaponData belFormaPagoTaponFrom, BelFormaPagoTaponData belFormaPagoTaponTo, HashMap userProperties) throws MareException
    {
      UtilidadesLog.info("DAOPais.query(BelFormaPagoTaponData belFormaPagoTaponFrom, BelFormaPagoTaponData belFormaPagoTaponTo, HashMap userProperties): Entrada");
      
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

      query.append(" SELECT OID_FORM_PAGO, COD_FORM_PAGO, ");
      query.append(" i18n.VAL_I18N ");
      query.append(" FROM BEL_FORMA_PAGO, v_gen_i18n_sicc i18n ");
      query.append(" WHERE OID_FORM_PAGO = i18n.val_oid ");
      query.append(" and i18n.ATTR_ENTI = 'BEL_FORMA_PAGO' ");
      query.append(" and i18n.ATTR_NUM_ATRI = 1 ");
      query.append(" and i18n.IDIO_OID_IDIO = " + (String)idioma.getValue()); 
      query.append(" ORDER BY i18n.VAL_I18N " ); 

      try {
          rs = bs.dbService.executeStaticQuery(query.toString());
      } catch (Exception ex) {
          UtilidadesLog.error("ERROR ", ex);
          throw new MareException(ex, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS));
      }
      
      int cant = rs.getRowCount();
      
      BelFormaPagoTaponData belFormaPagoTaponData = null;
      
      for(int i=0; i < cant; i++){
          belFormaPagoTaponData = new BelFormaPagoTaponData();
                
         belFormaPagoTaponData.setId(Long.valueOf(((BigDecimal)rs.getValueAt(i,"OID_FORM_PAGO")).toString()));
         belFormaPagoTaponData.setCodFormPago((String)rs.getValueAt(i,"COD_FORM_PAGO"));  
         belFormaPagoTaponData.setDescripcion((String)rs.getValueAt(i,"VAL_I18N")); 
        
         resultado.add(belFormaPagoTaponData);
      }
      
      UtilidadesLog.info("DAOPais.query(BelFormaPagoTaponData belFormaPagoTaponFrom, BelFormaPagoTaponData belFormaPagoTaponTo, HashMap userProperties): Salida");
      
      return resultado;
    }
    
    public Hashtable guardar(SegPaisData segPais, Vector localizationLabels, HashMap userProperties) throws MareException
    {
        UtilidadesLog.info("DAOPais.guardar(SegPaisData segPais, Vector localizationLabels, HashMap userProperties): Entrada");
        RecordSet rs = null;
        BelcorpService bs = UtilidadesEJB.getBelcorpService();
        
        StringBuffer update = new StringBuffer();        
        RecordSet rsPK = null;
        StringBuffer query = new StringBuffer();      
        Long id = null;
        
        query.append(" SELECT SEG_PAIS_SEQ.NEXTVAL FROM DUAL");         
        
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
        
        update.append(" INSERT INTO SEG_PAIS ( ");
        update.append("OID_PAIS, "); 
        update.append("COD_PAIS, "); 
        update.append("MONE_OID_MONE, "); 
        update.append("VAL_IDEN, "); 
        update.append("VAL_PROG_EJEC, "); 
        update.append("VAL_PORC_ALAR, "); 
        update.append("NUM_DIAS_MORA, "); 
        update.append("IND_SALD_UNIC, "); 
        update.append("IND_INTE_GIS, "); 
        update.append("IND_COMP_AUTO, "); 
        update.append("IND_TRAT_ACUM_DESC, "); 
        update.append("VAL_TIEM_REZO, "); 
        update.append("VAL_CONF_SECU_CCC, "); 
        update.append("NUM_LIMI_DIFE_PAGO, "); 
        update.append("VAL_MAXI_DIFE_ANLS_COMB, "); 
        update.append("NUM_DIAS_FACT, "); 
        update.append("NUM_POSI_NUME_CLIE, "); 
        update.append("IND_EMIS_VENC, "); 
        update.append("VAL_FORM_FECH, "); 
        update.append("VAL_SEPA_MILE, "); 
        update.append("VAL_SEPA_DECI, "); 
        update.append("NUM_PERI_EGRE, "); 
        update.append("NUM_PERI_RETI, "); 
        update.append("VAL_URL, "); 
        update.append("IND_FLET_ZONA_UBIG, "); 
        update.append("VAL_INDI_SECU_MONI, "); 
        update.append("IND_IMPU_INCL, "); 
        update.append("MONE_OID_MONE_ALT, "); 
        update.append("FOPA_OID_FORM_PAGO, "); 
        update.append("VAL_COMP_TELE, "); 
        update.append("IND_SECU, "); 
        update.append("IND_BALA_AREA_CHEQ "); 
  
        update.append(" ) VALUES ( ");
        update.append(id + ", ");
        update.append(" '" + segPais.getCodPais() + "', ");
        update.append(segPais.getMoneOidMone().getId() + ", ");
        update.append(" '" + segPais.getValIden() + "', ");
        update.append(" '" + segPais.getValProgEjec() + "', ");
        update.append(segPais.getValPorcAlar() + ", ");
        update.append(segPais.getNumDiasMora() + ", ");
        update.append(segPais.getIndSaldUnic() + ", ");
        update.append(" '" + segPais.getIndInteGis() + "', ");
        update.append(segPais.getIndCompAuto() + ", ");
        update.append(segPais.getIndTratAcumDesc() + ", ");
        update.append(segPais.getValTiemRezo() + ", ");
        update.append(" '" + segPais.getValConfSecuCcc() + "', ");
        update.append(segPais.getNumLimiDifePago() + ", ");
        update.append(segPais.getValMaxiDifeAnlsComb() + ", ");
        update.append(segPais.getNumDiasFact() + ", ");
        update.append(segPais.getNumPosiNumeClie() + ", ");
        update.append(segPais.getIndEmisVenc() + ", ");        
        update.append(" '" + segPais.getValFormFech() + "', ");
        update.append(" '" + segPais.getValSepaMile() + "', ");
        update.append(" '" + segPais.getValSepaDeci() + "', ");
        update.append(segPais.getNumPeriEgre() + ", ");
        update.append(segPais.getNumPeriReti() + ", ");
        update.append(" '" + segPais.getValUrl() + "', ");
        update.append(" '" + segPais.getIndFletZonaUbig() + "', ");
        update.append(" '" + segPais.getValIndiSecuMoni() + "', ");
        update.append(segPais.getIndImpuIncl());
        
        
        if (segPais.getMoneOidMoneAlt() != null) {
            update.append(", " + segPais.getMoneOidMoneAlt().getId());
        } else {
            update.append(", NULL ");
        }
        
        if (segPais.getFopaOidFormPago() != null) {
            update.append(", " + segPais.getFopaOidFormPago().getId());
        } else {
            update.append(", NULL ");
        }
        
        if (segPais.getValCompTele() != null) {
            update.append(", '" + segPais.getValCompTele() + "' ");
        } else {
            update.append(", NULL ");
        }
        
        if (segPais.getIndSecu() != null) {
            update.append(", '" + segPais.getIndSecu() + "' ");
        } else {
            update.append(", NULL ");
        }
        
        if (segPais.getIndBalaAreaCheq() != null) {
            update.append(", '" + segPais.getIndBalaAreaCheq() + "' ");
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
                
            updateInter.append(" INSERT INTO GEN_I18N_SICC_COMUN ( ");
            updateInter.append("OID_I18N, "); 
            updateInter.append("ATTR_ENTI, "); 
            updateInter.append("ATTR_NUM_ATRI, "); 
            updateInter.append("IDIO_OID_IDIO, "); 
            updateInter.append("VAL_I18N, ");                 
            updateInter.append("VAL_OID "); 
            updateInter.append(" ) VALUES ( ");
            updateInter.append(idInter + ", ");
            updateInter.append(" 'SEG_PAIS', ");
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
    
        UtilidadesLog.info("DAOPais.guardar(SegPaisData segPais, Vector localizationLabels, HashMap userProperties): Salida");
        return primaryKey;
    }
    
    public Vector query(SegPaisData segPaisFrom, SegPaisData segPaisTo, HashMap userProperties, Integer pageCount, Integer pageSize, boolean applyStructuralSecurity) throws MareException
    {
        UtilidadesLog.info("DAOPais.query(SegPaisData segPaisFrom, SegPaisData segPaisTo, HashMap userProperties, Integer pageCount, Integer pageSize, boolean applyStructuralSecurity): Entrada");
        
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
        
        if(!applyStructuralSecurity){
      
          query.append(" select OID_PAIS,  COD_PAIS,  MONE_OID_MONE,  VAL_IDEN,  VAL_PROG_EJEC, ");
          query.append(" VAL_PORC_ALAR,  NUM_DIAS_MORA,  IND_SALD_UNIC,  IND_INTE_GIS , ");
          query.append(" IND_COMP_AUTO,  IND_TRAT_ACUM_DESC,  VAL_TIEM_REZO,  VAL_CONF_SECU_CCC, ");
          query.append(" NUM_LIMI_DIFE_PAGO,  VAL_MAXI_DIFE_ANLS_COMB,  NUM_DIAS_FACT ,  NUM_POSI_NUME_CLIE, ");
          query.append(" IND_EMIS_VENC,  VAL_FORM_FECH,  VAL_SEPA_MILE,  VAL_SEPA_DECI,  NUM_PERI_EGRE, ");
          query.append(" NUM_PERI_RETI,  VAL_URL,  IND_FLET_ZONA_UBIG,  VAL_INDI_SECU_MONI,  IND_IMPU_INCL, ");
          query.append(" MONE_OID_MONE_ALT,   FOPA_OID_FORM_PAGO,  VAL_COMP_TELE,  IND_SECU,  IND_BALA_AREA_CHEQ, ");
          query.append(" i18n.val_i18n DESC_PAIS, i18n1.val_i18n DESC_MONE ");
          query.append(" from SEG_PAIS pais, v_gen_i18n_sicc i18n, v_gen_i18n_sicc i18n1 ");
          query.append(" WHERE OID_PAIS = i18n.val_oid ");
          query.append(" and i18n.ATTR_ENTI = 'SEG_PAIS' ");
          query.append(" and i18n.ATTR_NUM_ATRI = 1 ");
          query.append(" and i18n.IDIO_OID_IDIO = " + (String)idioma.getValue());
          query.append(" and i18n1.ATTR_ENTI = 'SEG_MONED' ");
          query.append(" and i18n1.ATTR_NUM_ATRI = 1 ");
          query.append(" and i18n1.IDIO_OID_IDIO = " + (String)idioma.getValue());
          query.append(" and mone_oid_mone = i18n1.val_oid ");
          
          
        } else {
      
          Property userID = (Property)userProperties.get("userID");
      
          query.append(" select OID_PAIS,  COD_PAIS,  MONE_OID_MONE,  VAL_IDEN,  VAL_PROG_EJEC, ");
          query.append(" VAL_PORC_ALAR,  NUM_DIAS_MORA,  IND_SALD_UNIC,  IND_INTE_GIS , ");
          query.append(" IND_COMP_AUTO,  IND_TRAT_ACUM_DESC,  VAL_TIEM_REZO,  VAL_CONF_SECU_CCC, ");
          query.append(" NUM_LIMI_DIFE_PAGO,  VAL_MAXI_DIFE_ANLS_COMB,  NUM_DIAS_FACT ,  NUM_POSI_NUME_CLIE, ");
          query.append(" IND_EMIS_VENC,  VAL_FORM_FECH,  VAL_SEPA_MILE,  VAL_SEPA_DECI,  NUM_PERI_EGRE, ");
          query.append(" NUM_PERI_RETI,  VAL_URL,  IND_FLET_ZONA_UBIG,  VAL_INDI_SECU_MONI, ");
          query.append(" IND_IMPU_INCL, ");
          query.append(" MONE_OID_MONE_ALT,   FOPA_OID_FORM_PAGO,  VAL_COMP_TELE,  IND_SECU,  IND_BALA_AREA_CHEQ, ");
          query.append(" i18n.val_i18n DESC_PAIS, i18n1.val_i18n DESC_MONE ");
          query.append(" from VCA_SEG_PAIS pais, v_gen_i18n_sicc i18n, v_gen_i18n_sicc i18n1 ");
          query.append(" where COD_USUA = '" + userID.getValue() + "' ");
          query.append(" and OID_PAIS = i18n.val_oid ");
          query.append(" and i18n.ATTR_ENTI = 'SEG_PAIS' ");
          query.append(" and i18n.ATTR_NUM_ATRI = 1 ");
          query.append(" and i18n.IDIO_OID_IDIO = " + (String)idioma.getValue());
          query.append(" and i18n1.ATTR_ENTI = 'SEG_MONED' ");
          query.append(" and i18n1.ATTR_NUM_ATRI = 1 ");
          query.append(" and i18n1.IDIO_OID_IDIO = " + (String)idioma.getValue());
          query.append(" and mone_oid_mone = i18n1.val_oid ");
        }
        
        // Para la busqueda
        if(segPaisFrom.getCodPais()!= null){
            query.append(" and COD_PAIS like '" + segPaisFrom.getCodPais() + "' ");
        }
        
        if(segPaisFrom.getMoneOidMone()!= null){
            query.append(" and MONE_OID_MONE = " + segPaisFrom.getMoneOidMone().getId());
        }
        
        // Para el detalle
        if(segPaisFrom.getId()!= null){
            query.append(" and OID_PAIS = " + segPaisFrom.getId());
        }

        try {
           rs = bs.dbService.executeStaticQuery(query.toString());
        } catch (Exception ex) {
          UtilidadesLog.error("ERROR ", ex);
          throw new MareException(ex, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS));
        }
        
        
        int cant = rs.getRowCount();
        Vector result = new Vector();
        
        SegPaisData segPaisData = null;
        SegMonedData segMonedData = null;
        SegMonedData segMonedDataAlt = null;
        BelFormaPagoTaponData belFormaPagoTaponData = null;
        
        int rsSaltar = (pageCount.intValue() - 1) * pageSize.intValue();
        int rsMostrar = ((pageSize.intValue() == Integer.MAX_VALUE) ? pageSize.intValue() : (pageSize.intValue() + 1)) + rsSaltar;
        
        UtilidadesLog.debug("rsSaltar: " + rsSaltar);
        UtilidadesLog.debug("rsMostrar: " + rsMostrar);
        
        for(int i=0; i < cant; i++){
        
            if(i < rsSaltar ) {
                continue;
            }
            
            if(i < rsMostrar){
                  segPaisData = new SegPaisData();
          
                  segPaisData.setId(Long.valueOf(((BigDecimal)rs.getValueAt(i,"OID_PAIS")).toString()));
                  
                  segPaisData.setCodPais((String)rs.getValueAt(i,"COD_PAIS"));
                  
                  segMonedData = new SegMonedData();
                  segMonedData.setId(Long.valueOf(((BigDecimal)rs.getValueAt(i,"MONE_OID_MONE")).toString()));   
                  segMonedData.setDescripcion((String)rs.getValueAt(i,"DESC_MONE"));    
                  segPaisData.setMoneOidMone(segMonedData);
                  
                  segPaisData.setValIden((String)rs.getValueAt(i,"VAL_IDEN"));
                  segPaisData.setValProgEjec((String)rs.getValueAt(i,"VAL_PROG_EJEC"));
                  
                  segPaisData.setValPorcAlar(Double.valueOf(((BigDecimal)rs.getValueAt(i,"VAL_PORC_ALAR")).toString()));
                  segPaisData.setNumDiasMora(Long.valueOf(((BigDecimal)rs.getValueAt(i,"NUM_DIAS_MORA")).toString()));    
                  segPaisData.setIndSaldUnic(((BigDecimal)rs.getValueAt(i,"IND_SALD_UNIC")).toString());
                  segPaisData.setIndInteGis((String)rs.getValueAt(i,"IND_INTE_GIS"));
                            
                  segPaisData.setIndCompAuto(((BigDecimal)rs.getValueAt(i,"IND_COMP_AUTO")).toString());    
                  segPaisData.setIndTratAcumDesc(((BigDecimal)rs.getValueAt(i,"IND_TRAT_ACUM_DESC")).toString());    
                  segPaisData.setValTiemRezo(Long.valueOf(((BigDecimal)rs.getValueAt(i,"VAL_TIEM_REZO")).toString()));    
                  
                  segPaisData.setValConfSecuCcc((String)rs.getValueAt(i,"VAL_CONF_SECU_CCC"));          
                  segPaisData.setNumLimiDifePago(Double.valueOf(((BigDecimal)rs.getValueAt(i,"NUM_LIMI_DIFE_PAGO")).toString()));
                  segPaisData.setValMaxiDifeAnlsComb(Double.valueOf(((BigDecimal)rs.getValueAt(i,"VAL_MAXI_DIFE_ANLS_COMB")).toString()));
                  segPaisData.setNumDiasFact(Long.valueOf(((BigDecimal)rs.getValueAt(i,"NUM_DIAS_FACT")).toString()));    
                  segPaisData.setNumPosiNumeClie(Long.valueOf(((BigDecimal)rs.getValueAt(i,"NUM_POSI_NUME_CLIE")).toString()));  
                  
                  segPaisData.setIndEmisVenc(((BigDecimal)rs.getValueAt(i,"IND_EMIS_VENC")).toString());    
                  segPaisData.setValFormFech((String)rs.getValueAt(i,"VAL_FORM_FECH"));
                  segPaisData.setValSepaMile((String)rs.getValueAt(i,"VAL_SEPA_MILE"));
                  segPaisData.setValSepaDeci((String)rs.getValueAt(i,"VAL_SEPA_DECI"));
                  
                  segPaisData.setNumPeriEgre(Long.valueOf(((BigDecimal)rs.getValueAt(i,"NUM_PERI_EGRE")).toString()));    
                  segPaisData.setNumPeriReti(Long.valueOf(((BigDecimal)rs.getValueAt(i,"NUM_PERI_RETI")).toString()));           
                  segPaisData.setValUrl((String)rs.getValueAt(i,"VAL_URL"));
                  segPaisData.setIndFletZonaUbig((String)rs.getValueAt(i,"IND_FLET_ZONA_UBIG"));
                  segPaisData.setValIndiSecuMoni((String)rs.getValueAt(i,"VAL_INDI_SECU_MONI"));
                  segPaisData.setIndImpuIncl(Long.valueOf(((BigDecimal)rs.getValueAt(i,"IND_IMPU_INCL")).toString()));  
                  segPaisData.setDescripcion((String)rs.getValueAt(i,"DESC_PAIS"));                    
                  
                  if((BigDecimal)rs.getValueAt(i,"MONE_OID_MONE_ALT")!=null){
                      segMonedDataAlt = new SegMonedData();
                      segMonedDataAlt.setId(Long.valueOf(((BigDecimal)rs.getValueAt(i,"MONE_OID_MONE_ALT")).toString()));          
                      segPaisData.setMoneOidMoneAlt(segMonedDataAlt);
                  }
                  
                  if((BigDecimal)rs.getValueAt(i,"FOPA_OID_FORM_PAGO")!=null){
                      belFormaPagoTaponData = new BelFormaPagoTaponData();
                      belFormaPagoTaponData.setId(Long.valueOf(((BigDecimal)rs.getValueAt(i,"FOPA_OID_FORM_PAGO")).toString()));          
                      segPaisData.setFopaOidFormPago(belFormaPagoTaponData);
                  }
                  
                  if((String)rs.getValueAt(i,"VAL_COMP_TELE")!= null){
                      segPaisData.setValCompTele((String)rs.getValueAt(i,"VAL_COMP_TELE"));
                  }
                  
                  if((String)rs.getValueAt(i,"IND_SECU")!= null){
                      segPaisData.setIndSecu((String)rs.getValueAt(i,"IND_SECU"));
                  }
                  
                  if((String)rs.getValueAt(i,"IND_BALA_AREA_CHEQ")!= null){
                      segPaisData.setIndBalaAreaCheq((String)rs.getValueAt(i,"IND_BALA_AREA_CHEQ"));
                  }
                  
                  result.add(segPaisData);
                
            } else {
               break;
            }
        }
        
        UtilidadesLog.debug("result: " + result);
       
        UtilidadesLog.info("DAOPais.query(SegPaisData segPaisFrom, SegPaisData segPaisTo, HashMap userProperties, Integer pageCount, Integer pageSize, boolean applyStructuralSecurity): Salida");
        return result;
        
    }
    
    public void remove(Vector segPaisFrom) throws MareException
    {
        UtilidadesLog.info("DAOPais.remove(Vector segPaisFrom): Entrada");
        RecordSet rs = null;
        BelcorpService bs = UtilidadesEJB.getBelcorpService();
        StringBuffer update = new StringBuffer();
        StringBuffer updateInter = new StringBuffer();
        
        int cant = segPaisFrom.size();
        SegPaisData segPaisData = null;
        String oids = "";
        
        for (int j = 0; j < cant; j++) {
            segPaisData = (SegPaisData)segPaisFrom.get(j);
             
            oids = oids + "," + segPaisData.getId();
        }
        
        update.append("delete SEG_PAIS ");
        update.append("where OID_PAIS in ( " + oids.substring(1) + ") ");
        
        updateInter.append("delete GEN_I18N_SICC_COMUN ");
        updateInter.append(" where VAL_OID in ( " + oids.substring(1) + ") ");
        updateInter.append(" and ATTR_NUM_ATRI = 1 ");
        updateInter.append(" and ATTR_ENTI = 'SEG_PAIS' ");
        
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
        
        UtilidadesLog.info("DAOPais.remove(Vector segPaisFrom): Salida");
    }
    
    public void update(SegPaisData segPais, Vector localizationLabels) throws MareException
    {
        UtilidadesLog.info("DAOPais.update(SegPaisData segPais, Vector localizationLabels): Entrada");
       
        RecordSet rs = null;
        BelcorpService bs = UtilidadesEJB.getBelcorpService();
        StringBuffer update = new StringBuffer();
        
        update.append("UPDATE SEG_PAIS SET ");
        update.append(" MONE_OID_MONE = " + segPais.getMoneOidMone().getId() + ", ");
        update.append(" VAL_IDEN = '" + segPais.getValIden() + "', ");
        update.append(" VAL_PROG_EJEC = '" + segPais.getValProgEjec() + "', ");
        update.append(" VAL_PORC_ALAR = " + segPais.getValPorcAlar() + ", ");
        update.append(" NUM_DIAS_MORA = " + segPais.getNumDiasMora() + ", ");
        update.append(" IND_SALD_UNIC = " + segPais.getIndSaldUnic() + ", ");
        update.append(" IND_INTE_GIS = '" + segPais.getIndInteGis() + "', ");
        update.append(" IND_COMP_AUTO = " + segPais.getIndCompAuto() + ", ");
        update.append(" IND_TRAT_ACUM_DESC = " + segPais.getIndTratAcumDesc() + ", ");
        update.append(" VAL_TIEM_REZO = " + segPais.getValTiemRezo() + ", ");
        update.append(" VAL_CONF_SECU_CCC = '" + segPais.getValConfSecuCcc() + "', ");
        update.append(" NUM_LIMI_DIFE_PAGO = " + segPais.getNumLimiDifePago() + ", ");
        update.append(" VAL_MAXI_DIFE_ANLS_COMB = " + segPais.getValMaxiDifeAnlsComb() + ", ");
        update.append(" NUM_DIAS_FACT = " + segPais.getNumDiasFact() + ", ");
        update.append(" NUM_POSI_NUME_CLIE = " + segPais.getNumPosiNumeClie() + ", ");
        update.append(" IND_EMIS_VENC = " + segPais.getIndEmisVenc() + ", ");
        update.append(" VAL_FORM_FECH = '" + segPais.getValFormFech() + "', ");
        update.append(" VAL_SEPA_MILE = '" + segPais.getValSepaMile() + "', ");
        update.append(" VAL_SEPA_DECI = '" + segPais.getValSepaDeci() + "', ");
        update.append(" NUM_PERI_EGRE = " + segPais.getNumPeriEgre() + ", ");
        update.append(" NUM_PERI_RETI = " + segPais.getNumPeriReti() + ", ");
        update.append(" VAL_URL = '" + segPais.getValUrl() + "', ");
        update.append(" IND_FLET_ZONA_UBIG = '" + segPais.getIndFletZonaUbig() + "', ");
        update.append(" VAL_INDI_SECU_MONI = '" + segPais.getValIndiSecuMoni() + "', ");
        update.append(" IND_IMPU_INCL = " + segPais.getIndImpuIncl());
        
        
        if (segPais.getMoneOidMoneAlt() != null) {
            update.append(", MONE_OID_MONE_ALT = " + segPais.getMoneOidMoneAlt().getId());
        } else {
            update.append(", MONE_OID_MONE_ALT = NULL ");
        }
        
        if (segPais.getFopaOidFormPago() != null) {
            update.append(", FOPA_OID_FORM_PAGO = " + segPais.getFopaOidFormPago().getId());
        } else {
            update.append(", FOPA_OID_FORM_PAGO = NULL ");
        }
        
        if (segPais.getValCompTele() != null) {
            update.append(", VAL_COMP_TELE = '" + segPais.getValCompTele() + "' ");
        } else {
            update.append(", VAL_COMP_TELE = NULL ");
        }
        
        if (segPais.getIndSecu() != null) {
            update.append(", IND_SECU = '" + segPais.getIndSecu() + "' ");
        } else {
            update.append(", IND_SECU = NULL ");
        }
        
        if (segPais.getIndBalaAreaCheq() != null) {
            update.append(", IND_BALA_AREA_CHEQ = '" + segPais.getIndBalaAreaCheq() + "' ");
        } else {
            update.append(", IND_BALA_AREA_CHEQ = NULL ");
        }
                
        update.append(" WHERE OID_PAIS = " + segPais.getId());   
        
        try {
            int cantRegActualizados = bs.dbService.executeUpdate(update.toString());
        } catch (Exception ex) {
            ex.printStackTrace();
            throw new MareException(ex, UtilidadesError.armarCodigoError(
                                    CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS));
        }
        
        // Borrar los registros internalizacion
        StringBuffer deleteInter = new StringBuffer();
        
        deleteInter.append("delete GEN_I18N_SICC_COMUN ");
        deleteInter.append(" where VAL_OID = " + segPais.getId());
        deleteInter.append(" and ATTR_NUM_ATRI = 1 ");
        deleteInter.append(" and ATTR_ENTI = 'SEG_PAIS' ");
        
        try {
            int cantRegActualizados1 = bs.dbService.executeUpdate(deleteInter.toString());
            
        } catch (Exception ex) {
            ex.printStackTrace();            
           
            throw new MareException(ex, UtilidadesError.armarCodigoError(
                                CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS));           
        }
        
        
        int cant = localizationLabels.size();
        GenDetaSiccData genDetaSiccData = null;
        RecordSet rsPKInter = null;
        StringBuffer queryInter = null;
        Long idInter = null;      
        StringBuffer updateInter = null;
        
        for(int i= 0; i< cant; i++){                      
           
            genDetaSiccData = (GenDetaSiccData)localizationLabels.get(i);
        
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
            
            updateInter = new StringBuffer();    
                
            updateInter.append(" INSERT INTO GEN_I18N_SICC_COMUN ( ");
            updateInter.append("OID_I18N, "); 
            updateInter.append("ATTR_ENTI, "); 
            updateInter.append("ATTR_NUM_ATRI, "); 
            updateInter.append("IDIO_OID_IDIO, "); 
            updateInter.append("VAL_I18N, ");                 
            updateInter.append("VAL_OID "); 
            updateInter.append(" ) VALUES ( ");
            updateInter.append(idInter + ", ");
            updateInter.append(" 'SEG_PAIS', ");
            updateInter.append(" 1, ");            
            updateInter.append(genDetaSiccData.getIdioOidIdio().getId() + ", ");
            updateInter.append(" '" + genDetaSiccData.getDeta() + "', ");
            updateInter.append(segPais.getId() + " )");   
        
            try {
                int cantRegActualizados = bs.dbService.executeUpdate(updateInter.toString());
            } catch (Exception ex) {
                ex.printStackTrace();
                throw new MareException(ex, UtilidadesError.armarCodigoError(
                                        CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS));
            }
        }
               
        UtilidadesLog.info("DAOPais.update(SegPaisData segPais, Vector localizationLabels): Salida");
    }
    
    public Vector query(SegPaisViewData segPaisViewFrom, SegPaisViewData segPaisViewTo, HashMap userProperties) throws MareException
    {
      UtilidadesLog.info("DAOPais.query(SegPaisViewData segPaisViewFrom, SegPaisViewData segPaisViewTo, HashMap userProperties): Entrada");
      
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
      Long loidPais = (Long)userProperties.get("loidPais");

      query.append(" select VAL_OID, VAL_I18N ");
      query.append(" from v_gen_i18n_sicc ");
      query.append(" where attr_enti = 'SEG_PAIS' ");      
      query.append(" and idio_oid_idio = " + (String)idioma.getValue());
      query.append(" and val_oid = " + loidPais);
      query.append(" and attr_num_atri = 1 ");
      query.append(" order by val_i18n   ");

      try {
          rs = bs.dbService.executeStaticQuery(query.toString());
      } catch (Exception ex) {
          UtilidadesLog.error("ERROR ", ex);
          throw new MareException(ex, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS));
      }
      
      int cant = rs.getRowCount();
      
      SegPaisViewData segPaisViewData = null;
      
      for(int i=0; i < cant; i++){
          segPaisViewData = new SegPaisViewData();
          
          segPaisViewData.setId(Long.valueOf(((BigDecimal)rs.getValueAt(i,"VAL_OID")).toString()));
          segPaisViewData.setDescripcion((String)rs.getValueAt(i,"VAL_I18N"));
          
          resultado.add(segPaisViewData);
      }
      
      UtilidadesLog.info("DAOPais.query(SegPaisViewData segPaisViewFrom, SegPaisViewData segPaisViewTo, HashMap userProperties): Salida");
     
      return resultado;
    }
        
    public Vector query(SegPaisViewData segPaisViewFrom, SegPaisViewData segPaisViewTo, HashMap userProperties, Boolean applyStructuralSecurity) throws MareException
    {
      UtilidadesLog.info("DAOPais.query(SegPaisViewData segPaisViewFrom, SegPaisViewData segPaisViewTo, HashMap userProperties, Boolean applyStructuralSecurity): Entrada");

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

      if(!applyStructuralSecurity.booleanValue()){
      
          query.append(" select OID_PAIS,  COD_PAIS,  MONE_OID_MONE,  VAL_IDEN,  VAL_PROG_EJEC, ");
          query.append(" VAL_PORC_ALAR,  NUM_DIAS_MORA,  IND_SALD_UNIC,  IND_INTE_GIS , ");
          query.append(" IND_COMP_AUTO,  IND_TRAT_ACUM_DESC,  VAL_TIEM_REZO,  VAL_CONF_SECU_CCC, ");
          query.append(" NUM_LIMI_DIFE_PAGO,  VAL_MAXI_DIFE_ANLS_COMB,  NUM_DIAS_FACT ,  NUM_POSI_NUME_CLIE, ");
          query.append(" IND_EMIS_VENC,  VAL_FORM_FECH,  VAL_SEPA_MILE,  VAL_SEPA_DECI,  NUM_PERI_EGRE, ");
          query.append(" NUM_PERI_RETI,  VAL_URL,  IND_FLET_ZONA_UBIG,  VAL_INDI_SECU_MONI,  IND_IMPU_INCL, ");
          query.append(" MONE_OID_MONE_ALT,   FOPA_OID_FORM_PAGO,  VAL_COMP_TELE,  IND_SECU,  IND_BALA_AREA_CHEQ ");
          query.append(" from SEG_PAIS ");
          
      } else {
      
          Property userID = (Property)userProperties.get("userID");
      
          query.append(" select OID_PAIS,  COD_PAIS,  MONE_OID_MONE,  VAL_IDEN,  VAL_PROG_EJEC, ");
          query.append(" VAL_PORC_ALAR,  NUM_DIAS_MORA,  IND_SALD_UNIC,  IND_INTE_GIS , ");
          query.append(" IND_COMP_AUTO,  IND_TRAT_ACUM_DESC,  VAL_TIEM_REZO,  VAL_CONF_SECU_CCC, ");
          query.append(" NUM_LIMI_DIFE_PAGO,  VAL_MAXI_DIFE_ANLS_COMB,  NUM_DIAS_FACT ,  NUM_POSI_NUME_CLIE, ");
          query.append(" IND_EMIS_VENC,  VAL_FORM_FECH,  VAL_SEPA_MILE,  VAL_SEPA_DECI,  NUM_PERI_EGRE, ");
          query.append(" NUM_PERI_RETI,  VAL_URL,  IND_FLET_ZONA_UBIG,  VAL_INDI_SECU_MONI, ");
          query.append(" IND_IMPU_INCL, ");
          query.append(" MONE_OID_MONE_ALT,   FOPA_OID_FORM_PAGO,  VAL_COMP_TELE,  IND_SECU,  IND_BALA_AREA_CHEQ ");
          query.append(" from VCA_SEG_PAIS ");
          query.append(" where COD_USUA = '" + userID.getValue() + "' ");
      }
      

      try {
          rs = bs.dbService.executeStaticQuery(query.toString());
      } catch (Exception ex) {
          UtilidadesLog.error("ERROR ", ex);
          throw new MareException(ex, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS));
      }
      
      int cant = rs.getRowCount();
      
      SegPaisViewData segPaisViewData = null;
      SegMonedData segMonedData = null;
      SegMonedData segMonedDataAlt = null;
      BelFormaPagoTaponData belFormaPagoTaponData = null;
      
      for(int i=0; i < cant; i++){
          segPaisViewData = new SegPaisViewData();
          
          segPaisViewData.setId(Long.valueOf(((BigDecimal)rs.getValueAt(i,"OID_PAIS")).toString()));
          
          segPaisViewData.setCodPais((String)rs.getValueAt(i,"COD_PAIS"));
          
          segMonedData = new SegMonedData();
          segMonedData.setId(Long.valueOf(((BigDecimal)rs.getValueAt(i,"MONE_OID_MONE")).toString()));          
          segPaisViewData.setMoneOidMone(segMonedData);
          
          segPaisViewData.setValIden((String)rs.getValueAt(i,"VAL_IDEN"));
          segPaisViewData.setValProgEjec((String)rs.getValueAt(i,"VAL_PROG_EJEC"));
          
          segPaisViewData.setValPorcAlar(Double.valueOf(((BigDecimal)rs.getValueAt(i,"VAL_PORC_ALAR")).toString()));
          segPaisViewData.setNumDiasMora(Long.valueOf(((BigDecimal)rs.getValueAt(i,"NUM_DIAS_MORA")).toString()));    
          segPaisViewData.setIndSaldUnic(((BigDecimal)rs.getValueAt(i,"IND_SALD_UNIC")).toString());
          segPaisViewData.setIndInteGis((String)rs.getValueAt(i,"IND_INTE_GIS"));
                    
          segPaisViewData.setIndCompAuto(((BigDecimal)rs.getValueAt(i,"IND_COMP_AUTO")).toString());    
          segPaisViewData.setIndTratAcumDesc(((BigDecimal)rs.getValueAt(i,"IND_TRAT_ACUM_DESC")).toString());    
          segPaisViewData.setValTiemRezo(Long.valueOf(((BigDecimal)rs.getValueAt(i,"VAL_TIEM_REZO")).toString()));    
          
          segPaisViewData.setValConfSecuCcc((String)rs.getValueAt(i,"VAL_CONF_SECU_CCC"));          
          segPaisViewData.setNumLimiDifePago(Double.valueOf(((BigDecimal)rs.getValueAt(i,"NUM_LIMI_DIFE_PAGO")).toString()));
          segPaisViewData.setValMaxiDifeAnlsComb(Double.valueOf(((BigDecimal)rs.getValueAt(i,"VAL_MAXI_DIFE_ANLS_COMB")).toString()));
          segPaisViewData.setNumDiasFact(Long.valueOf(((BigDecimal)rs.getValueAt(i,"NUM_DIAS_FACT")).toString()));    
          segPaisViewData.setNumPosiNumeClie(Long.valueOf(((BigDecimal)rs.getValueAt(i,"NUM_POSI_NUME_CLIE")).toString()));  
          
          segPaisViewData.setIndEmisVenc(((BigDecimal)rs.getValueAt(i,"IND_EMIS_VENC")).toString());    
          segPaisViewData.setValFormFech((String)rs.getValueAt(i,"VAL_FORM_FECH"));
          segPaisViewData.setValSepaMile((String)rs.getValueAt(i,"VAL_SEPA_MILE"));
          segPaisViewData.setValSepaDeci((String)rs.getValueAt(i,"VAL_SEPA_DECI"));
          
          segPaisViewData.setNumPeriEgre(Long.valueOf(((BigDecimal)rs.getValueAt(i,"NUM_PERI_EGRE")).toString()));    
          segPaisViewData.setNumPeriReti(Long.valueOf(((BigDecimal)rs.getValueAt(i,"NUM_PERI_RETI")).toString()));           
          segPaisViewData.setValUrl((String)rs.getValueAt(i,"VAL_URL"));
          segPaisViewData.setIndFletZonaUbig((String)rs.getValueAt(i,"IND_FLET_ZONA_UBIG"));
          segPaisViewData.setValIndiSecuMoni((String)rs.getValueAt(i,"VAL_INDI_SECU_MONI"));
          
          // el campo IND_IMPU_INCL no se encuentra en SegPaisViewData
          
          
          if((BigDecimal)rs.getValueAt(i,"MONE_OID_MONE_ALT")!=null){
              segMonedDataAlt = new SegMonedData();
              segMonedDataAlt.setId(Long.valueOf(((BigDecimal)rs.getValueAt(i,"MONE_OID_MONE_ALT")).toString()));          
              segPaisViewData.setMoneOidMone(segMonedDataAlt);
          }
          
          if((BigDecimal)rs.getValueAt(i,"FOPA_OID_FORM_PAGO")!=null){
              belFormaPagoTaponData = new BelFormaPagoTaponData();
              belFormaPagoTaponData.setId(Long.valueOf(((BigDecimal)rs.getValueAt(i,"FOPA_OID_FORM_PAGO")).toString()));          
              segPaisViewData.setFopaOidFormPago(belFormaPagoTaponData);
          }
          
          if((String)rs.getValueAt(i,"VAL_COMP_TELE")!= null){
              segPaisViewData.setValCompTele((String)rs.getValueAt(i,"VAL_COMP_TELE"));
          }
          
          if((String)rs.getValueAt(i,"IND_SECU")!= null){
              segPaisViewData.setIndSecu((String)rs.getValueAt(i,"IND_SECU"));
          }
          
          if((String)rs.getValueAt(i,"IND_BALA_AREA_CHEQ")!= null){
              segPaisViewData.setIndBalaAreaCheq((String)rs.getValueAt(i,"IND_BALA_AREA_CHEQ"));
          }
          
          resultado.add(segPaisViewData);
      }
      
      UtilidadesLog.info("DAOPais.query(SegPaisViewData segPaisViewFrom, SegPaisViewData segPaisViewTo, HashMap userProperties, Boolean applyStructuralSecurity): Salida");
      
      return resultado;
        
    }    
}