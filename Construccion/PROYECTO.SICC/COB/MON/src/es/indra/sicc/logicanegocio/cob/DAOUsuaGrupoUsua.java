package es.indra.sicc.logicanegocio.cob;

import es.indra.belcorp.mso.CobGrupoUsuarCobraData;
import es.indra.belcorp.mso.CobUsuarCobraViewData;
import es.indra.belcorp.mso.CobUsuarGrupoUsuarData;
import es.indra.belcorp.mso.GenPrincipalsData;
import es.indra.belcorp.mso.GenUsersData;
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

public class DAOUsuaGrupoUsua {
    public DAOUsuaGrupoUsua() {
    }
    public Vector query(CobGrupoUsuarCobraData cobGrupoUsuarCobraFrom, CobGrupoUsuarCobraData cobGrupoUsuarCobraTo, HashMap userProperties) throws MareException
        {   UtilidadesLog.info("DAOCobUsuaGrupoUsua.query(CobGrupoUsuarCobraData cobGrupoUsuarCobraFrom, CobGrupoUsuarCobraData cobGrupoUsuarCobraTo, HashMap userProperties):Entrada");
            RecordSet rs = new RecordSet();
            StringBuffer query = new StringBuffer();
            BelcorpService bs;
            Vector resultado = new Vector();
            try
            {
                bs = BelcorpService.getInstance();
                
            }catch (MareMiiServiceNotFoundException e)
            {
                UtilidadesLog.error("ERROR", e);
            throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_PEDIR_UN_SERVICIO_MARE));
            }
            
            query.append(" SELECT OID_GRUP_USUA_COBR, COD_GRUP_USUA, VAL_DESC ");
            query.append(" FROM COB_GRUPO_USUAR_COBRA ");
        
            try {
                  rs = bs.dbService.executeStaticQuery(query.toString());
              } catch (Exception ex) {
                  UtilidadesLog.error("ERROR ", ex);
                  throw new MareException(ex, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS));
              }
            int cant = rs.getRowCount();
              
            
             CobGrupoUsuarCobraData cobGrupo = null;
              
            for(int i=0; i < cant; i++){
                    
                cobGrupo = new CobGrupoUsuarCobraData();
                
                cobGrupo.setId(Long.valueOf(((BigDecimal)rs.getValueAt(i,"OID_GRUP_USUA_COBR")).toString()));
                cobGrupo.setCodGrupUsua(Long.valueOf(((BigDecimal)rs.getValueAt(i,"COD_GRUP_USUA")).toString()));
                cobGrupo.setValDesc((String)rs.getValueAt(i,"VAL_DESC"));
                
                resultado.add(cobGrupo);
            }
            
            UtilidadesLog.info("DAOCobUsuaGrupoUsua.query(CobGrupoUsuarCobraData cobGrupoUsuarCobraFrom, CobGrupoUsuarCobraData cobGrupoUsuarCobraTo, HashMap userProperties):Entrada");
            return resultado;
        }
        
        
        public Vector query(CobUsuarGrupoUsuarData cobUsuarGrupoUsuarFrom, CobUsuarGrupoUsuarData cobUsuarGrupoUsuarTo, HashMap userProperties, Integer pageCount, Integer pageSize) throws MareException
        {   UtilidadesLog.info("DAOCobUsuaGrupoUsua.query(CobUsuarGrupoUsuarData cobUsuarGrupoUsuarFrom, CobUsuarGrupoUsuarData cobUsuarGrupoUsuarTo, HashMap userProperties, Integer pageCount, Integer pageSize):Entrada");
        
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
        
            query.append(" SELECT a.oid_usua_grup_usua, b.oid_grup_usua_cobr, c.oid_usua_cobr, d.iduser, ");
            query.append(" e.NAME, b.val_desc, e.IDPRINCIPAL");
            query.append(" FROM cob_usuar_grupo_usuar a,  ");
            query.append(" cob_grupo_usuar_cobra b,");
            query.append(" cob_usuar_cobra c,");
            query.append(" users d,");
            query.append(" principals e");
            query.append(" WHERE a.guco_oid_grup_usua_cobr = b.oid_grup_usua_cobr ");
            query.append(" AND a.usco_oid_usua_cobr = c.oid_usua_cobr ");
            query.append(" AND c.user_oid_usua_cobr = d.iduser");
            query.append(" AND e.idprincipal = c.user_oid_usua_cobr");
                            
             if(cobUsuarGrupoUsuarFrom.getId()!= null)
             {
                query.append(" AND OID_USUA_GRUP_USUA = " + cobUsuarGrupoUsuarFrom.getId());
             }
             if(cobUsuarGrupoUsuarFrom.getGucoOidGrupUsuaCobr()!= null)
             {
                query.append(" AND OID_GRUP_USUA_COBR = " + cobUsuarGrupoUsuarFrom.getGucoOidGrupUsuaCobr().getId());
             }
            
            if(cobUsuarGrupoUsuarFrom.getUscoOidUsuaCobr()!= null)
            {
                query.append(" AND OID_USUA_COBR = " + cobUsuarGrupoUsuarFrom.getUscoOidUsuaCobr().getId());
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
            
            CobUsuarGrupoUsuarData cobUsuGrUsu = null;
            CobGrupoUsuarCobraData cobGruUsu = null;
            CobUsuarCobraViewData cobUsuCobra = null;
            GenUsersData genUser = null;
            GenPrincipalsData genPrin = null;
            
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
                      
                      cobUsuGrUsu = new CobUsuarGrupoUsuarData();
                      cobGruUsu = new CobGrupoUsuarCobraData();
                      cobUsuCobra = new CobUsuarCobraViewData();
                      genUser = new GenUsersData();
                      genPrin = new GenPrincipalsData();
                      
                      
                      
                      
                      cobGruUsu.setId(Long.valueOf(((BigDecimal)rs.getValueAt(i,"OID_GRUP_USUA_COBR")).toString()));
                      cobGruUsu.setValDesc((String)rs.getValueAt(i,"VAL_DESC"));
                                       
                      cobUsuCobra.setId(Long.valueOf(((BigDecimal)rs.getValueAt(i,"OID_USUA_COBR")).toString()));
                      genPrin.setId(Long.valueOf(((BigDecimal)rs.getValueAt(i,"IDPRINCIPAL")).toString()));
                      genPrin.setName((String)rs.getValueAt(i,"NAME"));
                      genUser.setId(Long.valueOf(((BigDecimal)rs.getValueAt(i,"IDUSER")).toString()));
                      genUser.setMyid(genPrin);
                      cobUsuCobra.setUserOidUsuaCobr(genUser);
                      
                      cobUsuGrUsu.setId(Long.valueOf(((BigDecimal)rs.getValueAt(i,"OID_USUA_GRUP_USUA")).toString()));
                      cobUsuGrUsu.setUscoOidUsuaCobr(cobUsuCobra);
                      cobUsuGrUsu.setGucoOidGrupUsuaCobr(cobGruUsu);
                      
                                                             
                                        
                      result.add(cobUsuGrUsu);
                      
                }catch(Exception ex)
                {
                  ex.printStackTrace();
                }
                } else {
                   break;
                }
            }
       
          
            UtilidadesLog.info("DAOCobUsuaGrupoUsua.query(CobUsuarGrupoUsuarData cobUsuarGrupoUsuarFrom, CobUsuarGrupoUsuarData cobUsuarGrupoUsuarTo, HashMap userProperties, Integer pageCount, Integer pageSize):Salida");
            return result;
        }
        
        public void update(CobUsuarGrupoUsuarData cobUsuarGrupoUsuar, Vector localizationLabels) throws MareException
        {   UtilidadesLog.info("DAOCobUsuaGrupoUsua.update(CobUsuarGrupoUsuarData cobUsuarGrupoUsuar, Vector localizationLabels):Entrada");
        
            RecordSet rs = null;
            BelcorpService bs = UtilidadesEJB.getBelcorpService();
               
            StringBuffer update = new StringBuffer();
            update.append("   UPDATE COB_USUAR_GRUPO_USUAR SET ");
            update.append("           USCO_OID_USUA_COBR = " + cobUsuarGrupoUsuar.getUscoOidUsuaCobr().getId() + ",");
            update.append("           GUCO_OID_GRUP_USUA_COBR = " + cobUsuarGrupoUsuar.getGucoOidGrupUsuaCobr().getId());
            
           
            update.append("   where OID_USUA_GRUP_USUA = " + cobUsuarGrupoUsuar.getId());
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
        
        
            UtilidadesLog.info("DAOCobUsuaGrupoUsua.update(CobUsuarGrupoUsuarData cobUsuarGrupoUsuar, Vector localizationLabels):Salida");
        }
        
        public void remove(Vector entities) throws MareException
        {   UtilidadesLog.info("DAOCobUsuaGrupoUsua.remove(Vector entities):Entrada");
            RecordSet rs = null;
            BelcorpService bs = UtilidadesEJB.getBelcorpService();
            StringBuffer update = new StringBuffer();
            
            
            int cant = entities.size();
            CobUsuarGrupoUsuarData cobUsuaGrupUsua = null;
            String oids = "";
            
            for (int j = 0; j < cant; j++) {
               cobUsuaGrupUsua  = (CobUsuarGrupoUsuarData)entities.get(j);
                 
                oids = oids + "," + cobUsuaGrupUsua.getId();
            }
            
            update.append("DELETE COB_USUAR_GRUPO_USUAR ");
            update.append("WHERE OID_USUA_GRUP_USUA in ( " + oids.substring(1) + ") ");
            
                   
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
        
        
        
            UtilidadesLog.info("DAOCobUsuaGrupoUsua.remove(Vector entities):Salida");
        }
        
        public Hashtable guardar(CobUsuarGrupoUsuarData cobUsuarGrupoUsuar, Vector localizationLabels, HashMap userProperties) throws MareException
        {   UtilidadesLog.info("DAOCobUsuaGrupoUsua.guardar(CobUsuarGrupoUsuarData cobUsuarGrupoUsuar, Vector localizationLabels, HashMap userProperties):Entrada");
            RecordSet rs = null;
            BelcorpService bs = UtilidadesEJB.getBelcorpService();
            
            StringBuffer update = new StringBuffer();
            
            RecordSet rsPK = null;
            StringBuffer query = new StringBuffer();      
            Long id = null;
            
            query.append(" SELECT COB_UGUC_SEQ.NEXTVAL FROM DUAL");         
            
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
          update.append(" INSERT INTO COB_USUAR_GRUPO_USUAR ( ");
          update.append(" OID_USUA_GRUP_USUA, ");
          update.append(" USCO_OID_USUA_COBR, ");
          update.append(" GUCO_OID_GRUP_USUA_COBR ");
          update.append(" ) VALUES ( ");
          update.append(id + ", ");
          update.append(cobUsuarGrupoUsuar.getUscoOidUsuaCobr().getId() + ", ");
          update.append(cobUsuarGrupoUsuar.getGucoOidGrupUsuaCobr().getId());
          
          
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
        
        
        
            UtilidadesLog.info("DAOCobUsuaGrupoUsua.guardar(CobUsuarGrupoUsuarData cobUsuarGrupoUsuar, Vector localizationLabels, HashMap userProperties):Salida");
            return primaryKey;
        }
    }
    

