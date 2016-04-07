package es.indra.sicc.logicanegocio.mae;

import es.indra.belcorp.mso.MaeCriteBusquData;
import es.indra.belcorp.mso.PedAtribEspecData;
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

import java.util.HashMap;
import java.util.Hashtable;
import java.util.Vector;

public class DAOCriterioBusqueda {
    public DAOCriterioBusqueda() {
    }
    public Vector query(PedAtribEspecData pedAtribEspecFrom, PedAtribEspecData pedAtribEspecTo, HashMap userProperties)throws MareException
      {
        UtilidadesLog.info("DAOCriterioBusqueda.query(PedAtribEspecData pedAtribEspecFrom, PedAtribEspecData pedAtribEspecTo, HashMap userProperties): Entrada");  
        RecordSet rs = new RecordSet();
        StringBuffer query = new StringBuffer();
        Vector parametros = new Vector();
        BelcorpService bs;
        try{
                bs = BelcorpService.getInstance();
            
        } catch(MareMiiServiceNotFoundException ex){
                    
                throw new MareException(ex, UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_PEDIR_UN_SERVICIO_MARE));
        }
        query.append(" SELECT PED_ATRIB_ESPEC.OID_ATRI_ESPE, PED_ATRIB_ESPEC.DES_ATRI ");
        query.append("          FROM PED_ATRIB_ESPEC ");
        query.append("          ORDER BY PED_ATRIB_ESPEC.DES_ATRI  ");
        
        try{         
                 rs = bs.dbService.executeStaticQuery(query.toString());
               
        } catch (Exception ex) {
                ex.printStackTrace();
                throw new MareException(ex, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS));
        }
         if(!rs.esVacio())
         {
           for(int i= 0; i < rs.getRowCount(); i++){
                  PedAtribEspecData pedAtribEspec = new PedAtribEspecData();
                  pedAtribEspec.setId(new Long(((BigDecimal)rs.getValueAt(i,"OID_ATRI_ESPE")).toString()));
                  pedAtribEspec.setDesAtri((String)rs.getValueAt(i,"DES_ATRI"));
                  parametros.add(pedAtribEspec);
           }
         }  
         UtilidadesLog.info("DAOCriterioBusqueda.query(PedAtribEspecData pedAtribEspecFrom, PedAtribEspecData pedAtribEspecTo, HashMap userProperties): Salida");    
         return parametros; 
       }
       public Hashtable guardarCriterioBusqueda(MaeCriteBusquData maeCriteBusqu, Vector localizationLabels, HashMap userProperties)throws MareException
       {
          UtilidadesLog.info("DAOCriterioBusqueda.guardarCriterioBusqueda(MaeCriteBusquData maeCriteBusqu, Vector localizationLabels, HashMap userProperties) :Entrada ");
          RecordSet rs = null;
          BelcorpService bs = UtilidadesEJB.getBelcorpService();     
          StringBuffer update = new StringBuffer();
          StringBuffer updateInter = new StringBuffer();
          RecordSet rsPK = null;
          StringBuffer query = new StringBuffer();      
          Long id = null;
          query.append(" SELECT MAE_CRBU_SEQ.NEXTVAL FROM DUAL ");
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
          update.append(" INSERT INTO MAE_CRITE_BUSQU( ");
          update.append("     OID_CRIT_BUSQ,  ");
          update.append("     PAIS_OID_PAIS, ");
          update.append("     ATRE_OID_ATRI_ESP1, ");
          update.append("     ATRE_OID_ATRI_ESP2 ");
          update.append(" ) VALUES ( ");
          update.append(id);
          update.append(" , " + maeCriteBusqu.getPaisOidPais().getId());
          update.append(" , " + maeCriteBusqu.getAtreOidAtriEsp1().getId());
          update.append(" , " + maeCriteBusqu.getAtreOidAtriEsp2().getId());
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
           UtilidadesLog.info("DAOCriterioBusqueda.guardarCriterioBusqueda(MaeCriteBusquData maeCriteBusqu, Vector localizationLabels, HashMap userProperties) :Salida");
           return primaryKey; 
       }
       public Vector query(MaeCriteBusquData maeCriteBusquFrom, MaeCriteBusquData maeCriteBusquTo, HashMap userProperties, Integer pageCount, Integer pageSize)throws MareException
       {
          UtilidadesLog.info("DAOCriterioBusqueda.query(MaeCriteBusquData maeCriteBusquFrom, MaeCriteBusquData maeCriteBusquTo, HashMap userProperties, Integer pageCount, Integer pageSize): Entrada");
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
          query.append(" SELECT MAE_CRITE_BUSQU.OID_CRIT_BUSQ, ATRIB.DES_ATRI DESTRI2, ATRIB.OID_ATRI_ESPE OIDATRIBU2, PED_ATRIB_ESPEC.DES_ATRI DESATRIBU1, ");
          query.append("        PED_ATRIB_ESPEC.OID_ATRI_ESPE OIDATRIBU1,  ");
          query.append("        SEG_PAIS.OID_PAIS ");
          query.append("        FROM PED_ATRIB_ESPEC ATRIB, MAE_CRITE_BUSQU, ");
          query.append("             PED_ATRIB_ESPEC, SEG_PAIS ");
          query.append("             WHERE MAE_CRITE_BUSQU.ATRE_OID_ATRI_ESP1 = PED_ATRIB_ESPEC.OID_ATRI_ESPE  ");
          if(maeCriteBusquFrom.getAtreOidAtriEsp1() != null)
          {
              query.append("               AND PED_ATRIB_ESPEC.OID_ATRI_ESPE = " + maeCriteBusquFrom.getAtreOidAtriEsp1().getId());  
          }
          query.append("                   AND MAE_CRITE_BUSQU.ATRE_OID_ATRI_ESP2 = ATRIB.OID_ATRI_ESPE ");
          if(maeCriteBusquFrom.getAtreOidAtriEsp2()  != null)
          {
             query.append("                AND ATRIB.OID_ATRI_ESPE = " + maeCriteBusquFrom.getAtreOidAtriEsp2().getId());
          }
          query.append("                   AND MAE_CRITE_BUSQU.PAIS_OID_PAIS = SEG_PAIS.OID_PAIS ");
          if(maeCriteBusquFrom.getPaisOidPais() != null)
          {
             query.append("                AND SEG_PAIS.OID_PAIS =" + maeCriteBusquFrom.getPaisOidPais().getId());
          }
          if(maeCriteBusquFrom.getId() != null)
          {
             query.append("                AND MAE_CRITE_BUSQU.OID_CRIT_BUSQ = " + maeCriteBusquFrom.getId());
          }
           try {
               rs = bs.dbService.executeStaticQuery(query.toString());
            } catch (Exception ex) {
              UtilidadesLog.error("ERROR ", ex);
              throw new MareException(ex, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS));
            }
             int cant = rs.getRowCount();
             Vector result = new Vector();
             MaeCriteBusquData maeCriteBusqu = null;
             PedAtribEspecData pedAtribEspec1 = null;
             PedAtribEspecData pedAtribEspec2 = null;
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
                          maeCriteBusqu = new MaeCriteBusquData();
                          UtilidadesLog.debug("oid: " +((BigDecimal)rs.getValueAt(i,"OID_CRIT_BUSQ")).toString());
                          maeCriteBusqu.setId(new Long(((BigDecimal)rs.getValueAt(i,"OID_CRIT_BUSQ")).toString()));
                          
                          pedAtribEspec1 = new PedAtribEspecData();                      
                          UtilidadesLog.debug("oid1: "+ ((BigDecimal)rs.getValueAt(i,"OIDATRIBU1")).toString());
                          pedAtribEspec1.setId(new Long(((BigDecimal)rs.getValueAt(i,"OIDATRIBU1")).toString()));
                          pedAtribEspec1.setDesAtri((String)rs.getValueAt(i,"DESATRIBU1"));
                          maeCriteBusqu.setAtreOidAtriEsp1(pedAtribEspec1);
                          
                          pedAtribEspec2 = new PedAtribEspecData();
                          UtilidadesLog.info("oid2: " + ((BigDecimal)rs.getValueAt(i,"OIDATRIBU2")).toString());
                          pedAtribEspec2.setId(new Long (((BigDecimal)rs.getValueAt(i,"OIDATRIBU2")).toString()));
                          
                          pedAtribEspec2.setDesAtri((String)rs.getValueAt(i,"DESTRI2"));
                          maeCriteBusqu.setAtreOidAtriEsp2(pedAtribEspec2);
                          
                          segPaisViewFrom = new SegPaisViewData();
                          UtilidadesLog.debug("oidPais: " + ((BigDecimal)rs.getValueAt(i,"OID_PAIS")).toString());
                          segPaisViewFrom.setId(new Long(((BigDecimal)rs.getValueAt(i,"OID_PAIS")).toString()));
                          maeCriteBusqu.setPaisOidPais(segPaisViewFrom);
                          result.add(maeCriteBusqu);
                        
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
            UtilidadesLog.info("DAOCriterioBusqueda.query(MaeCriteBusquData maeCriteBusquFrom, MaeCriteBusquData maeCriteBusquTo, HashMap userProperties, Integer pageCount, Integer pageSize): Salida");                                       
            return result;
       }
       public void update(MaeCriteBusquData maeCriteBusqu, Vector localizationLabels)throws MareException
       {
          UtilidadesLog.info("DAOCriterioBusqueda.update(MaeCriteBusquData maeCriteBusqu, Vector localizationLabels): Entrada");
          RecordSet rs = null;
          BelcorpService bs = UtilidadesEJB.getBelcorpService();      
          StringBuffer update = new StringBuffer();
          
          update.append(" UPDATE MAE_CRITE_BUSQU SET ");
          update.append("  ATRE_OID_ATRI_ESP1 = " + maeCriteBusqu.getAtreOidAtriEsp1().getId());
          update.append("  , ATRE_OID_ATRI_ESP2 = " + maeCriteBusqu.getAtreOidAtriEsp2().getId());
          update.append("   where  OID_CRIT_BUSQ = " + maeCriteBusqu.getId());
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
         UtilidadesLog.info("DAOCriterioBusqueda.update(MaeCriteBusquData maeCriteBusqu, Vector localizationLabels): Salida");
       }
       public void remove(Vector maeCriteBus)throws MareException
       {
         UtilidadesLog.info("DAOCriterioBusqueda.remove(Vector maeCriteBus): Entrada");
         RecordSet rs = null;
         BelcorpService bs = UtilidadesEJB.getBelcorpService();
         StringBuffer update = new StringBuffer();
         StringBuffer updateInter = new StringBuffer();
            
         int cant = maeCriteBus.size();
         MaeCriteBusquData maeCriteBusqu = null;
         String oidCriteBusqu = "";
         for (int j = 0; j < cant; j++) {
                maeCriteBusqu = (MaeCriteBusquData)maeCriteBus.get(j);
                 
                oidCriteBusqu = oidCriteBusqu + "," + maeCriteBusqu.getId();
          }
          update.append("delete MAE_CRITE_BUSQU  ");
          update.append(" where  OID_CRIT_BUSQ in ( " + oidCriteBusqu.substring(1) + ") ");
          
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
          UtilidadesLog.info("DAOCriterioBusqueda.remove(Vector maeCriteBus): Salida");   
       }
}
