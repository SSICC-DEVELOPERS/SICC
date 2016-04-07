package es.indra.sicc.logicanegocio.cob;

import es.indra.belcorp.mso.CobEstadGrupoUsuarData;
import es.indra.belcorp.mso.CobGrupoUsuarCobraData;
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

public class DAOGrupoUsuariosCobranza {
    public DAOGrupoUsuariosCobranza() 
    {
    }
    
    public Vector query(CobEstadGrupoUsuarData cobEstadGrupoUsuarFrom, CobEstadGrupoUsuarData cobEstadGrupoUsuarTo, HashMap userProperties) throws MareException
        {   UtilidadesLog.info("DAOCobGrupoUsuariosCobranza.query(CobEstadGrupoUsuarData cobEstadGrupoUsuarFrom, CobEstadGrupoUsuarData cobEstadGrupoUsuarTo, HashMap userProperties):Entrada");
            
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
            
            query.append(" SELECT a.OID_ESTA_GRUP_USUA, a.COD_ESTA_GRUP_USUA, b.VAL_I18N ");
            query.append(" FROM COB_ESTAD_GRUPO_USUAR a, GEN_I18N_SICC_COMUN b ");
            query.append(" WHERE b.ATTR_ENTI = 'COB_ESTAD_GRUPO_USUAR' ");
            query.append(" AND B.ATTR_NUM_ATRI = 1 ");
            query.append(" AND B.IDIO_OID_IDIO = 1 ");
            query.append(" AND B.VAL_OID = A.OID_ESTA_GRUP_USUA");
        
            
            
            try {
                  rs = bs.dbService.executeStaticQuery(query.toString());
              } catch (Exception ex) {
                  UtilidadesLog.error("ERROR ", ex);
                  throw new MareException(ex, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS));
              }
            int cant = rs.getRowCount();
              
            
             CobEstadGrupoUsuarData cobEstadoGruUsu = null;
              
              for(int i=0; i < cant; i++){
                 
                  cobEstadoGruUsu  = new CobEstadGrupoUsuarData();
                  
                  cobEstadoGruUsu.setId(Long.valueOf(((BigDecimal)rs.getValueAt(i,"OID_ESTA_GRUP_USUA")).toString()));
                  cobEstadoGruUsu.setCodEstaGrupUsua((String)rs.getValueAt(i,"COD_ESTA_GRUP_USUA"));
                  cobEstadoGruUsu.setDescripcion((String)rs.getValueAt(i,"VAL_I18N"));
                 
                  
                  resultado.add(cobEstadoGruUsu);
              }
            UtilidadesLog.info("DAOCobGrupoUsuariosCobranza.query(CobEstadGrupoUsuarData cobEstadGrupoUsuarFrom, CobEstadGrupoUsuarData cobEstadGrupoUsuarTo, HashMap userProperties):Salida");
            return resultado;
        }
         public Vector query(CobGrupoUsuarCobraData cobGrupoUsuarCobraFrom, CobGrupoUsuarCobraData cobGrupoUsuarCobraTo, HashMap userProperties, Integer pageCount, Integer pageSize) throws MareException
        {   UtilidadesLog.info("DAOCobGrupoUsuariosCobranza.query(CobGrupoUsuarCobraData cobGrupoUsuarCobraFrom, CobGrupoUsuarCobraData cobGrupoUsuarCobraTo, HashMap userProperties, Integer pageCount, Integer pageSize):Entrada");
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
        
            query.append(" SELECT a.oid_grup_usua_cobr, a.cod_grup_usua, a.val_desc, a.fec_ulti_esta, ");
            query.append(" a.ind_usua_exte, a.val_turn_hora_entr, a.val_turn_hora_sali, ");
            query.append(" a.val_obse, b.oid_pais, c.oid_esta_grup_usua, d.val_i18n, a.COD_USUA ");
            query.append(" FROM cob_grupo_usuar_cobra a, seg_pais b, cob_estad_grupo_usuar c, gen_i18n_sicc_comun d");
            query.append(" WHERE a.pais_oid_pais = b.oid_pais ");
            query.append(" AND a.esgr_oid_esta_grup_usua = c.OID_ESTA_GRUP_USUA(+) ");
            if(cobGrupoUsuarCobraFrom.getEsgrOidEstaGrupUsua()!=null)
            {
                query.append(" AND c.OID_ESTA_GRUP_USUA = " + cobGrupoUsuarCobraFrom.getEsgrOidEstaGrupUsua().getId());
            }
            query.append(" AND d.attr_enti(+) = 'COB_ESTAD_GRUPO_USUAR'");
            query.append(" AND d.attr_num_atri(+) = 1");
            query.append(" AND d.idio_oid_idio(+) = 1");
            query.append(" AND d.val_oid(+) = c.oid_esta_grup_usua");
            
             if(cobGrupoUsuarCobraFrom.getId()!= null){
                query.append(" AND oid_grup_usua_cobr = " + cobGrupoUsuarCobraFrom.getId());
            }
             if(cobGrupoUsuarCobraFrom.getCodGrupUsua()!= null){
                query.append(" AND cod_grup_usua = " + cobGrupoUsuarCobraFrom.getCodGrupUsua());
            }
            if(cobGrupoUsuarCobraFrom.getValDesc()!= null)
            {
                query.append(" AND val_desc like '" + cobGrupoUsuarCobraFrom.getValDesc()+ "'" );
            }
            if(cobGrupoUsuarCobraFrom.getEsgrOidEstaGrupUsua()!= null)
            {
                query.append(" AND oid_esta_grup_usua = " + cobGrupoUsuarCobraFrom.getEsgrOidEstaGrupUsua().getId());
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
                            
            SegPaisViewData segPais = null;
            CobGrupoUsuarCobraData cobGrupoUs = null;
            CobEstadGrupoUsuarData cobEstGru = null;
            SimpleDateFormat simpledateformat = new SimpleDateFormat("dd/MM/yyyy");
            
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
                
                      
                      BigDecimal codGru, cobEsta, usuExt = null;
                      String turnoHoEn, turnoHoSal, obser = null;
                      cobGrupoUs = new  CobGrupoUsuarCobraData();
                      cobEstGru = new CobEstadGrupoUsuarData();
                      segPais = new SegPaisViewData();
                      Date fecha = null;
                      cobGrupoUs.setId(Long.valueOf(((BigDecimal)rs.getValueAt(i,"OID_GRUP_USUA_COBR")).toString()));                 
                      cobGrupoUs.setValDesc((String)rs.getValueAt(i,"VAL_DESC"));
                      cobGrupoUs.setCodUsua((String)rs.getValueAt(i,"COD_USUA"));
                      segPais.setId(Long.valueOf(((BigDecimal)rs.getValueAt(i,"OID_PAIS")).toString())); 
                      cobGrupoUs.setPaisOidPais(segPais);
                           
                          
                      fecha = (Date)rs.getValueAt(i,"FEC_ULTI_ESTA");
                          if(fecha!= null)
                          {
                            cobGrupoUs.setFecUltiEsta(Date.valueOf(fecha.toString()));
                          }
                      cobEsta = (BigDecimal)rs.getValueAt(i,"OID_ESTA_GRUP_USUA");
                        if(cobEsta != null)
                        {
                           cobEstGru.setId(Long.valueOf(cobEsta.toString()));
                           cobEstGru.setDescripcion(String.valueOf(cobEsta));
                           cobGrupoUs.setEsgrOidEstaGrupUsua(cobEstGru);
                        }
                        
                      codGru = (BigDecimal)rs.getValueAt(i,"COD_GRUP_USUA");
                       if(codGru != null)
                       {
                            
                           cobGrupoUs.setCodGrupUsua(Long.valueOf(codGru.toString()));
                       }
                      usuExt = (BigDecimal)rs.getValueAt(i,"IND_USUA_EXTE");
                      if(usuExt != null)
                      {
                           cobGrupoUs.setIndUsuaExte(Long.valueOf(usuExt.toString()));
                      }
                      
                      turnoHoEn = (String)rs.getValueAt(i,"VAL_TURN_HORA_ENTR");
                      if(turnoHoEn != null)
                      {
                           cobGrupoUs.setValTurnHoraEntr(String.valueOf(turnoHoEn));
                         
                      }
                     turnoHoSal = (String)rs.getValueAt(i,"VAL_TURN_HORA_SALI");
                      if(turnoHoSal != null)
                      {
                           cobGrupoUs.setValTurnHoraSali(String.valueOf(turnoHoSal));
                      }
                      obser = (String)rs.getValueAt(i,"VAL_OBSE");
                      if(obser != null)
                      {  
                           cobGrupoUs.setValObse(String.valueOf(obser));
                      }
                      
                                        
                                   
                      result.add(cobGrupoUs);
                      
                }catch(Exception ex)
                {
                  ex.printStackTrace();
                }
                } else {
                   break;
                }
                
        }
        
            UtilidadesLog.info("DAOCobGrupoUsuariosCobranza.query(CobGrupoUsuarCobraData cobGrupoUsuarCobraFrom, CobGrupoUsuarCobraData cobGrupoUsuarCobraTo, HashMap userProperties, Integer pageCount, Integer pageSize):Salida");
            return result;
        }
         public void remove(Vector entities) throws MareException
        {   UtilidadesLog.info("DAOCobGrupoUsuariosCobranza.remove(Vector entities):Entrada");
            RecordSet rs = null;
            BelcorpService bs = UtilidadesEJB.getBelcorpService();
            StringBuffer update = new StringBuffer();
            
            
            int cant = entities.size();
            CobGrupoUsuarCobraData cobGruUsuCob = null;
            String oids = "";
            
            for (int j = 0; j < cant; j++) {
               cobGruUsuCob = (CobGrupoUsuarCobraData)entities.get(j);
                 
                oids = oids + "," + cobGruUsuCob.getId();
            }
            
            update.append("DELETE COB_GRUPO_USUAR_COBRA ");
            update.append("WHERE OID_GRUP_USUA_COBR in ( " + oids.substring(1) + ") ");
            
                   
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
            
        
        
        
        
            UtilidadesLog.info("DAOCobGrupoUsuariosCobranza.remove(Vector entities):Salida");
        }
        public void update(CobGrupoUsuarCobraData cobGrupoUsuarCobra, Vector localizationLabels) throws MareException
        {   UtilidadesLog.info("DAOCobGrupoUsuariosCobranza.update(CobGrupoUsuarCobraData cobGrupoUsuarCobra, Vector localizationLabels):Entrada");
            RecordSet rs = null;
            BelcorpService bs = UtilidadesEJB.getBelcorpService();
            
            StringBuffer update = new StringBuffer();
            
              
            update.append(" UPDATE  COB_GRUPO_USUAR_COBRA SET ");
            update.append(" COD_USUA = '" + cobGrupoUsuarCobra.getCodUsua() + "',");
            update.append(" VAL_DESC = '"+ cobGrupoUsuarCobra.getValDesc() + "',");
            
           
            if(cobGrupoUsuarCobra.getFecUltiEsta()!= null)
            {
                SimpleDateFormat simpledateformat = new SimpleDateFormat("dd/MM/yyyy");       
                update.append(" FEC_ULTI_ESTA = TO_DATE('").append(simpledateformat.format(cobGrupoUsuarCobra.getFecUltiEsta())).append("','DD/MM/YYYY') ,");
             }
               else {
                update.append(" FEC_ULTI_ESTA = NULL," );
                } 
                
            if(cobGrupoUsuarCobra.getIndUsuaExte()!= null)
            {
                update.append(" IND_USUA_EXTE = " + cobGrupoUsuarCobra.getIndUsuaExte() + ",");
            }
            else
            {
                update.append(" IND_USUA_EXTE = NULL,");
            }
            if(cobGrupoUsuarCobra.getValTurnHoraEntr() != null)
            {
                update.append(" VAL_TURN_HORA_ENTR = '" + cobGrupoUsuarCobra.getValTurnHoraEntr() + "',");
            }
            else
            {
                update.append(" VAL_TURN_HORA_ENTR = NULL,");
            }
            if(cobGrupoUsuarCobra.getValTurnHoraSali() != null)
            {
                update.append(" VAL_TURN_HORA_SALI = '" + cobGrupoUsuarCobra.getValTurnHoraSali()+ "',");
            }
            else
            {
                update.append(" VAL_TURN_HORA_SALI = NULL,");
            }
            if(cobGrupoUsuarCobra.getValObse()!= null)
            {
                update.append(" VAL_OBSE = '" + cobGrupoUsuarCobra.getValObse() + "',");
            }
            else
            {
                update.append(" VAL_OBSE = NULL,");
            }
            if(cobGrupoUsuarCobra.getEsgrOidEstaGrupUsua()!= null)
            {
                update.append(" ESGR_OID_ESTA_GRUP_USUA = " + cobGrupoUsuarCobra.getEsgrOidEstaGrupUsua().getId());
            }
            else
            {
                update.append(" ESGR_OID_ESTA_GRUP_USUA = NULL");
            }
            
                update.append(" WHERE OID_GRUP_USUA_COBR = " + cobGrupoUsuarCobra.getId());
            
            try {
                int cantRegActualizados = bs.dbService.executeUpdate(update.toString());
            } catch (Exception ex) {
                ex.printStackTrace();
                throw new MareException(ex, UtilidadesError.armarCodigoError(
                                        CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS));
            }
        
                
        
            UtilidadesLog.info("DAOCobGrupoUsuariosCobranza.update(CobGrupoUsuarCobraData cobGrupoUsuarCobra, Vector localizationLabels):Salida");
        }
        public Hashtable guardar(CobGrupoUsuarCobraData cobGrupoUsuarCobra, Vector localizationLabels, HashMap userProperties) throws MareException
        {   UtilidadesLog.info("DAOCobGrupoUsuariosCobranza.guardar(CobGrupoUsuarCobraData cobGrupoUsuarCobra, Vector localizationLabels, HashMap userProperties):Entrada");
            RecordSet rs = null;
            BelcorpService bs = UtilidadesEJB.getBelcorpService();
            
            StringBuffer update = new StringBuffer();
            
            RecordSet rsPK = null;
            StringBuffer query = new StringBuffer();      
            Long id = null;
            
            query.append(" SELECT COB_GUCO_SEQ.NEXTVAL FROM DUAL");         
            
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
            update.append(" INSERT INTO COB_GRUPO_USUAR_COBRA ( ");
            update.append(" OID_GRUP_USUA_COBR, ");
            update.append(" COD_GRUP_USUA, ");
            update.append(" VAL_DESC,");
            update.append(" COD_USUA, ");
            update.append(" PAIS_OID_PAIS, ");
            update.append(" FEC_ULTI_ESTA, ");
            update.append(" IND_USUA_EXTE, ");
            update.append(" VAL_TURN_HORA_ENTR, ");
            update.append(" VAL_TURN_HORA_SALI, ");
            update.append(" VAL_OBSE, ");
            update.append(" ESGR_OID_ESTA_GRUP_USUA ");
            update.append(" ) VALUES ( ");
            update.append(id + ", ");
            update.append(cobGrupoUsuarCobra.getCodGrupUsua() + ", ");
            update.append("'" + cobGrupoUsuarCobra.getValDesc() + "', ");
            update.append("'" +cobGrupoUsuarCobra.getCodUsua() + "', ");
            update.append(cobGrupoUsuarCobra.getPaisOidPais().getId()); 
              
            if(cobGrupoUsuarCobra.getFecUltiEsta()!= null)
            { 
                    SimpleDateFormat simpledateformat = new SimpleDateFormat("dd/MM/yyyy");
                    
                    update.append(", TO_DATE('").append(simpledateformat.format(cobGrupoUsuarCobra.getFecUltiEsta())).append("','DD/MM/YYYY')");
            }
            else
            {
                  update.append(", NULL");
            }
            if(cobGrupoUsuarCobra.getIndUsuaExte()!= null)
            {
                  update.append("," + cobGrupoUsuarCobra.getIndUsuaExte());
            }
            else 
            {
                  update.append(", NULL");
            }
            if(cobGrupoUsuarCobra.getValTurnHoraEntr()!=null)
            {
                  update.append(",'" + cobGrupoUsuarCobra.getValTurnHoraEntr() + "'");
            }
            else
            {
                  update.append(", NULL");
            }
            if(cobGrupoUsuarCobra.getValTurnHoraSali()!= null)
            {
                  update.append(", '" + cobGrupoUsuarCobra.getValTurnHoraSali() + "'");
            }
            else
            {
                  update.append(", NULL");
            }
            if(cobGrupoUsuarCobra.getValObse()!= null)
            {
                  update.append(", '" + cobGrupoUsuarCobra.getValObse()+ "'");
            }
            else
            {
                  update.append(", NULL");
            }
            if(cobGrupoUsuarCobra.getEsgrOidEstaGrupUsua()!= null)
            {
                  update.append(", " + cobGrupoUsuarCobra.getEsgrOidEstaGrupUsua().getId());
            }
            else
            {
                  update.append(", NULL");
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
        
        
        
        
            UtilidadesLog.info("DAOCobGrupoUsuariosCobranza.guardar(CobGrupoUsuarCobraData cobGrupoUsuarCobra, Vector localizationLabels, HashMap userProperties):Salida");
            return primaryKey;
        }
        
    }

