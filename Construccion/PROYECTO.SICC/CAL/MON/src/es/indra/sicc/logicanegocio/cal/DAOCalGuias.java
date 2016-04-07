package es.indra.sicc.logicanegocio.cal;

import es.indra.belcorp.mso.CalGuiasData;
import es.indra.belcorp.mso.SegDeptoEmpreData;
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

import java.sql.Date;

import java.text.SimpleDateFormat;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.Vector;

public class DAOCalGuias {
    public DAOCalGuias() {
    }
    public Vector query(SegDeptoEmpreData segDeptoEmpreFrom,  SegDeptoEmpreData segDeptoEmpreTo, HashMap userProperties)throws MareException
     {
        UtilidadesLog.info("DAOCalGuias.query(SegDeptoEmpreData segDeptoEmpreFrom,  SegDeptoEmpreData segDeptoEmpreTo, HashMap userProperties): Entrada");
        RecordSet rs = new RecordSet();
        StringBuffer query = new StringBuffer();
        Vector parametros = new Vector();
        BelcorpService bs;
        try{
                 bs = BelcorpService.getInstance();
           
        } catch(MareMiiServiceNotFoundException ex){
                   
                 throw new MareException(ex, UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_PEDIR_UN_SERVICIO_MARE));
        }
        query.append(" SELECT SEG_DEPTO_EMPRE.OID_DEPA, SEG_DEPTO_EMPRE.DES_CORT_DPTO ");
        query.append("        FROM SEG_DEPTO_EMPRE  ");
        query.append("        ORDER BY SEG_DEPTO_EMPRE.DES_CORT_DPTO ");
        try{
             
                 rs = bs.dbService.executeStaticQuery(query.toString());
              
        } catch (Exception ex) {
              
                 throw new MareException(ex, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS));
        }
        if(!rs.esVacio())
        {
           for(int i= 0; i < rs.getRowCount(); i++){
                 SegDeptoEmpreData segDeptoEmpre = new SegDeptoEmpreData();
                 segDeptoEmpre.setId(new Long(((BigDecimal)rs.getValueAt(i,"OID_DEPA")).toString()));
                 segDeptoEmpre.setDesCortDpto((String)rs.getValueAt(i,"DES_CORT_DPTO"));
                 parametros.add(segDeptoEmpre);
           }
        }
        UtilidadesLog.info("DAOCalGuias.query(SegDeptoEmpreData segDeptoEmpreFrom,  SegDeptoEmpreData segDeptoEmpreTo, HashMap userProperties): Salida");
        return parametros;
       }
       public Hashtable guardarGuias(CalGuiasData calGuias, Vector localizationLabels, HashMap userProperties )throws MareException
       {
         UtilidadesLog.info("DAOCalGuias.guardarGuias(CalGuiasData calGuias, Vector localizationLabels, HashMap userProperties ): Entrada");
         RecordSet rs = null;
         BelcorpService bs = UtilidadesEJB.getBelcorpService();     
         StringBuffer update = new StringBuffer();
         RecordSet rsPK = null;
         StringBuffer query = new StringBuffer();      
         Long id = null;
         query.append(" SELECT CAL_GUIA_SEQ.NEXTVAL FROM DUAL ");
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
         update.append("INSERT INTO CAL_GUIAS ( ");
         update.append("            OID_GUIA ");
         update.append("            , COD_GUIA ");
         update.append("            , VAL_TITU ");
         update.append("            , FEC_INIC_VALI ");
         update.append("            , FEC_FIN_VALI ");
         update.append("            , VAL_DESC_GUIA ");
         update.append("            , PAIS_OID_PAIS ");
         update.append("            , DPTE_OID_DEPA ");
         update.append(" ) VALUES ( ");
         update.append(id );
         update.append(" , '" + calGuias.getCodGuia() + "'");
         update.append(" , '" + calGuias.getValTitu() +"'");
         SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
         
         update.append(" , TO_DATE('").append(sdf.format(calGuias.getFecInicVali())).append("','DD/MM/YYYY') ");
         update.append(" , TO_DATE('").append(sdf.format(calGuias.getFecFinVali())).append("','DD/MM/YYYY')");
         update.append(" , '" + calGuias.getValDescGuia() + "'");
         update.append(" , " + calGuias.getPaisOidPais().getId());
         update.append(" , " + calGuias.getDpteOidDepa().getId());
         update.append("          ) ");
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
         UtilidadesLog.info("DAOCalGuias.guardarGuias(CalGuiasData calGuias, Vector localizationLabels, HashMap userProperties ): Entrada");
         return primaryKey;
       }
       public Vector query(CalGuiasData calGuiasFrom, CalGuiasData calGuiasTo, HashMap userProperties, Integer pageCount, Integer pageSize)throws MareException
       {
           UtilidadesLog.info("DAOCalGuias.query(CalGuiasData calGuiasFrom, CalGuiasData calGuiasTo, HashMap userProperties, Integer pageCount, Integer pageSize): Entrada");
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
           query.append("      SELECT CAL_GUIAS.OID_GUIA, CAL_GUIAS.COD_GUIA, ");
           query.append("             SEG_DEPTO_EMPRE.OID_DEPA, SEG_DEPTO_EMPRE.DES_CORT_DPTO, ");
           query.append("             CAL_GUIAS.VAL_TITU, CAL_GUIAS.FEC_INIC_VALI, CAL_GUIAS.FEC_FIN_VALI, ");
           query.append("             CAL_GUIAS.VAL_DESC_GUIA, SEG_PAIS.OID_PAIS ");
           query.append("             FROM CAL_GUIAS, SEG_DEPTO_EMPRE, SEG_PAIS  ");
           query.append("             WHERE CAL_GUIAS.PAIS_OID_PAIS = SEG_PAIS.OID_PAIS ");
           if(calGuiasFrom.getPaisOidPais() != null)
           {
             query.append("                 AND SEG_PAIS.OID_PAIS = " + calGuiasFrom.getPaisOidPais().getId());
           }
           query.append("                   AND CAL_GUIAS.DPTE_OID_DEPA = SEG_DEPTO_EMPRE.OID_DEPA  ");
           if(calGuiasFrom.getDpteOidDepa() != null)
           {
             query.append("                 AND  SEG_DEPTO_EMPRE.OID_DEPA = " + calGuiasFrom.getDpteOidDepa().getId());
           }
           if(calGuiasFrom.getCodGuia() != null)
           {
             query.append("                 AND CAL_GUIAS.COD_GUIA LIKE  '" + calGuiasFrom.getCodGuia() + "' ");
           }
           if(calGuiasFrom.getValTitu() != null)
           {
             query.append("                  AND CAL_GUIAS.VAL_TITU LIKE  '" + calGuiasFrom.getValTitu() + "'");
             
           }
           if(calGuiasFrom.getFecInicVali() != null)
           {
             SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
             query.append("                  AND CAL_GUIAS.FEC_INIC_VALI = TO_DATE('").append(sdf.format(calGuiasFrom.getFecInicVali())).append("','DD/MM/YYYY') ");
           }
           if(calGuiasFrom.getFecFinVali() != null)
           {
             SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
             query.append("                  AND CAL_GUIAS.FEC_FIN_VALI =  TO_DATE('").append(sdf.format(calGuiasFrom.getFecFinVali())).append("','DD/MM/YYYY') ");
           }
           if(calGuiasFrom.getValDescGuia() != null)
           {
             query.append("                  AND CAL_GUIAS.VAL_DESC_GUIA LIKE '" + calGuiasFrom.getValDescGuia() + "'");
           }
           if(calGuiasFrom.getId() != null)
           {
             query.append("                   AND CAL_GUIAS.OID_GUIA = " + calGuiasFrom.getId() );
           }
           try {
               
              rs = bs.dbService.executeStaticQuery(query.toString());
           } catch (Exception ex) {
           
             ex.printStackTrace();
             UtilidadesLog.error("ERROR ", ex);
             throw new MareException(ex, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS));
           }
            int cant = rs.getRowCount();
            Vector result = new Vector();
            CalGuiasData calGuias = null;
            SegDeptoEmpreData segDeptoEmpreFrom = null;
            SegPaisViewData segPaisViewFrom = null; 
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
                      calGuias = new  CalGuiasData();
                      calGuias.setId(new Long(((BigDecimal)rs.getValueAt(i,"OID_GUIA")).toString()));
                      calGuias.setCodGuia((String)rs.getValueAt(i,"COD_GUIA"));
                      segDeptoEmpreFrom = new SegDeptoEmpreData();
                      segDeptoEmpreFrom.setId(new Long(((BigDecimal)rs.getValueAt(i,"OID_DEPA")).toString()));
                      segDeptoEmpreFrom.setDesCortDpto((String)rs.getValueAt(i,"DES_CORT_DPTO"));
                      calGuias.setDpteOidDepa(segDeptoEmpreFrom);
                      calGuias.setValTitu((String)rs.getValueAt(i,"VAL_TITU"));
                      calGuias.setFecInicVali((Date)rs.getValueAt(i,"FEC_INIC_VALI"));
                      calGuias.setFecFinVali((Date)rs.getValueAt(i,"FEC_FIN_VALI"));
                      calGuias.setValDescGuia((String)rs.getValueAt(i,"VAL_DESC_GUIA"));
                      segPaisViewFrom = new SegPaisViewData();
                      segPaisViewFrom.setId(new Long(((BigDecimal)rs.getValueAt(i,"OID_PAIS")).toString()));
                      calGuias.setPaisOidPais(segPaisViewFrom);
                      result.add(calGuias);
               }catch(Exception ex)
               {
                  ex.printStackTrace();
                  UtilidadesLog.error("ERROR ", ex);
               }
               }else
               {
                 break;
               }
           }    
            UtilidadesLog.debug("result: " + result);
            UtilidadesLog.info("DAOCalGuias.query(CalGuiasData calGuiasFrom, CalGuiasData calGuiasTo, HashMap userProperties, Integer pageCount, Integer pageSize): Salida");
            return result;
          
       }
       public void update(CalGuiasData calGuias, Vector localizationLabels)throws MareException
       { 
           UtilidadesLog.info("DAOCalGuias.update(CalGuiasData calGuias, Vector localizationLabels): Entrada");
           RecordSet rs = null;
           BelcorpService bs = UtilidadesEJB.getBelcorpService();
              
           StringBuffer update = new StringBuffer();
           update.append(" UPDATE CAL_GUIAS SET ");
           update.append("            COD_GUIA  = '" + calGuias.getCodGuia() + "'");
           update.append("            , VAL_TITU = '" + calGuias.getValTitu() + "'");
           SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
           update.append("            , FEC_INIC_VALI = TO_DATE('").append(sdf.format(calGuias.getFecInicVali())).append("','DD/MM/YYYY') ");
           update.append("            , FEC_FIN_VALI  = TO_DATE('").append(sdf.format(calGuias.getFecFinVali())).append("','DD/MM/YYYY') ");
           update.append("            , VAL_DESC_GUIA = '" + calGuias.getValDescGuia() +"'");    
           update.append("            , DPTE_OID_DEPA = " + calGuias.getDpteOidDepa().getId());
           update.append("            where   OID_GUIA = " + calGuias.getId());
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
         UtilidadesLog.info("DAOCalGuias.update(CalGuiasData calGuias, Vector localizationLabels): Salida");  
       }
       public void remove(Vector calGuias) throws MareException
       {
           UtilidadesLog.info("DAOCalGuias.remove(Vector calGuias): Entrada");
           RecordSet rs = null;
           BelcorpService bs = UtilidadesEJB.getBelcorpService();
           StringBuffer update = new StringBuffer();
           StringBuffer updateInter = new StringBuffer();
           
           int cant = calGuias.size();
           CalGuiasData calGuiasFrom = null;
           String oidGuias = "";
           for (int j = 0; j < cant; j++) {
               calGuiasFrom = (CalGuiasData)calGuias.get(j);
                
               oidGuias = oidGuias + "," + calGuiasFrom.getId();
           }
           update.append("delete CAL_GUIAS  ");
           update.append("where OID_GUIA in ( " + oidGuias.substring(1) + ") ");
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
           UtilidadesLog.info("DAOCalGuias.remove(Vector calGuias): Salida");
       }
    
}
