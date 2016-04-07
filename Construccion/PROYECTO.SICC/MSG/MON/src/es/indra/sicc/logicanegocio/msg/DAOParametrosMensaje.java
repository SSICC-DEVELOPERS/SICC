package es.indra.sicc.logicanegocio.msg;

import es.indra.belcorp.mso.MsgParamMensaData;

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
import java.util.Vector;

public class DAOParametrosMensaje {
    public DAOParametrosMensaje() {
    }
    
    public Vector query(MsgParamMensaData msgParamMensaFrom, MsgParamMensaData msgParamMensaTo, HashMap userProperties, Integer pageCount, Integer pageSize) throws MareException
       {
           UtilidadesLog.info("DAOMsgParamMensa.query(MsgParamMensaData msgParamMensaFrom, MsgParamMensaData msgParamMensaTo, HashMap userProperties, Integer pageCount, Integer pageSize):Entrada ");
       
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
           try{
       
           query.append(" SELECT p.OID_PARA_MENS, p.COD_DATO_VARI, s.OID_PAIS, p.DES_DATO_VARI, p.FEC_SIST ");
           query.append(" from MSG_PARAM_MENSA p, SEG_PAIS s ");
           query.append(" WHERE s.OID_PAIS = p.PAIS_OID_PAIS ");
           
           if(msgParamMensaFrom.getCodDatoVari()!= null){
               query.append(" AND COD_DATO_VARI like '" + msgParamMensaFrom.getCodDatoVari()+ "'");
           }
           if(msgParamMensaFrom.getId()!= null)
           {
               query.append(" AND OID_PARA_MENS = " + msgParamMensaFrom.getId());
           }
           
           }catch(Exception ex)
           {
             ex.printStackTrace();
           }
         try {
              rs = bs.dbService.executeStaticQuery(query.toString());
           } catch (Exception ex) {
             UtilidadesLog.error("ERROR ", ex);
             throw new MareException(ex, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS));
           }
           int cant = rs.getRowCount();
           Vector result = new Vector();
           
           MsgParamMensaData msgParamMensaData = null;
           SimpleDateFormat simpledateformat = new SimpleDateFormat("dd/MM/yyyy");
           
           
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
                     msgParamMensaData = new MsgParamMensaData();
                     segPaisViewFrom = new SegPaisViewData();
                     
                     
                    
                    
                    
                     msgParamMensaData.setId(Long.valueOf(((BigDecimal)rs.getValueAt(i,"OID_PARA_MENS")).toString())); 
                     msgParamMensaData.setCodDatoVari((String)rs.getValueAt(i,"COD_DATO_VARI"));
                     msgParamMensaData.setDesDatoVari((String)rs.getValueAt(i,"DES_DATO_VARI"));
                     try{
                     msgParamMensaData.setFecSist((Date)rs.getValueAt(i,"FEC_SIST"));
                     
                     }catch(Exception ex)
                     {
                         ex.printStackTrace();
                         
                     }
                     segPaisViewFrom.setId(Long.valueOf(((BigDecimal)rs.getValueAt(i,"OID_PAIS")).toString()));
                     msgParamMensaData.setPaisOidPais(segPaisViewFrom);
                     
                     result.add(msgParamMensaData);
               }catch(Exception ex)
               {
                 ex.printStackTrace();
                 UtilidadesLog.error("ERROR", ex);
               }
               } else {
                  break;
               }
           }
         
                     
       UtilidadesLog.info("DAOMsgParamMensa.query(MsgParamMensaData msgParamMensaFrom, MsgParamMensaData msgParamMensaTo, HashMap userProperties, Integer pageCount, Integer pageSize):Salida ");
           return result;
       }
       public void update(MsgParamMensaData msgParamMensa, Vector localizationLabels) throws MareException
       {
        UtilidadesLog.info("DAOMsgParamMensa.update(MsgParamMensaData msgParamMensa, Vector localizationLabels):Entrada ");
        
           RecordSet rs = null;
           BelcorpService bs = UtilidadesEJB.getBelcorpService();
           
           StringBuffer update = new StringBuffer();
           SimpleDateFormat simpledateformat = new SimpleDateFormat("dd/MM/yyyy");
           String fechaSis = simpledateformat.format(msgParamMensa.getFecSist());
           
           update.append("UPDATE MSG_PARAM_MENSA SET ");
           update.append(" DES_DATO_VARI = '" + msgParamMensa.getDesDatoVari() + "'");
           update.append(" , FEC_SIST = TO_DATE('" + fechaSis + "', 'DD/MM/YYYY') ");
           update.append(" WHERE OID_PARA_MENS= " + msgParamMensa.getId());   
           
           
           
           try {
               int cantRegActualizados = bs.dbService.executeUpdate(update.toString());
           } catch (Exception ex) {
               ex.printStackTrace();
               throw new MareException(ex, UtilidadesError.armarCodigoError(
                                       CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS));
           }
        
        
        UtilidadesLog.info("DAOMsgParamMensa.update(MsgParamMensaData msgParamMensa, Vector localizationLabels):Salida ");
       }
    }
  

