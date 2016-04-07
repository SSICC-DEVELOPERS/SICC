package es.indra.sicc.logicanegocio.cob;

import es.indra.belcorp.mso.CobEtapaDeudaData;
import es.indra.belcorp.mso.CobUsuarCobraViewData;
import es.indra.belcorp.mso.CobUsuarEtapaCobraCabecData;
import es.indra.belcorp.mso.GenPrincipalsData;
import es.indra.belcorp.mso.GenUsersData;
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

public class DAOUsuEtapaCobraCabe {
    public DAOUsuEtapaCobraCabe() {
    }
    
    public Vector query(CobUsuarCobraViewData cobUsuarCobraViewFrom, CobUsuarCobraViewData cobUsuarCobraViewTo, HashMap userProperties) throws MareException
        {   UtilidadesLog.info("DAOUsuEtapaCobraCabe.query(CobUsuarCobraViewData cobUsuarCobraViewFrom, CobUsuarCobraViewData cobUsuarCobraViewTo, HashMap userProperties):Entrada");
            
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
           query.append(" SELECT  b.OID_USUA_COBR, c.IDUSER, d.NAME ");
           query.append(" FROM  cob_usuar_cobra b, users c, PRINCIPALS d ");
           query.append(" WHERE b.user_oid_usua_cobr = c.iduser ");
           query.append(" AND d.IDPRINCIPAL = b.USER_OID_USUA_COBR");
           
           
           
           try
           {
                  rs = bs.dbService.executeStaticQuery(query.toString());
         
            }catch (Exception ex) {
               
                  throw new MareException(ex, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS));
           }
           CobUsuarCobraViewData cobUsuCob = null;
           SegPaisViewData segPais = null;
           GenUsersData user = null;
           if(!rs.esVacio())
           {
              for(int i = 0; i < rs.getRowCount(); i++)
              {
                 cobUsuCob = new CobUsuarCobraViewData();
                 segPais = new SegPaisViewData();
                 user = new GenUsersData();
                 GenPrincipalsData dato = new GenPrincipalsData();
                 
                 cobUsuCob.setId(Long.valueOf(((BigDecimal)rs.getValueAt(i,"OID_USUA_COBR")).toString()));
                 user.setId(Long.valueOf(((BigDecimal)rs.getValueAt(i,"IDUSER")).toString()));
                 dato.setName((String)rs.getValueAt(i,"NAME"));
                 user.setMyid(dato);
                 cobUsuCob.setUserOidUsuaCobr(user);
                 
                 resultado.add(cobUsuCob);
              }
        
        
        UtilidadesLog.info("DAOUsuEtapaCobraCabe.query(CobUsuarCobraViewData cobUsuarCobraViewFrom, CobUsuarCobraViewData cobUsuarCobraViewTo, HashMap userProperties):Salida");
             
            }
            return resultado;
        }
        
         public Vector query(CobUsuarEtapaCobraCabecData cobUsuarEtapaCobraCabecFrom, CobUsuarEtapaCobraCabecData cobUsuarEtapaCobraCabecTo, HashMap userProperties, Integer pageCount, Integer pageSize) throws MareException
        {   UtilidadesLog.info("DAOUsuEtapaCobraCabe.query(CobUsuarEtapaCobraCabecData cobUsuarEtapaCobraCabecFrom, CobUsuarEtapaCobraCabecData cobUsuarEtapaCobraCabecTo, HashMap userProperties, Integer pageCount, Integer pageSize):Entrada");
            
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
        
            query.append(" SELECT a.oid_usua_etap_cobr, b.user_oid_usua_cobr, a.val_obse, ");
            query.append(" c.cod_etap_deud, c.val_desc, c.oid_etap_deud, b.oid_usua_cobr,");
            query.append(" d.iduser, e.NAME, f.OID_PAIS ");
            query.append(" FROM cob_usuar_etapa_cobra_cabec a,  ");
            query.append(" cob_usuar_cobra b,");
            query.append(" cob_etapa_deuda c,");
            query.append(" users d,");
            query.append(" principals e,");
            query.append(" SEG_PAIS f");
            query.append(" WHERE a.etde_oid_etap_deud = c.oid_etap_deud ");
            query.append(" AND a.usco_oid_usua_cobr = b.oid_usua_cobr");
            query.append(" AND b.user_oid_usua_cobr = d.iduser");
            query.append(" AND e.idprincipal = b.user_oid_usua_cobr");
            query.append(" and b.PAIS_OID_PAIS = f.OID_PAIS");
                            
             if(cobUsuarEtapaCobraCabecFrom.getId()!= null)
             {
                query.append(" AND OID_USUA_ETAP_COBR = " + cobUsuarEtapaCobraCabecFrom.getId());
             }
             if(cobUsuarEtapaCobraCabecFrom.getEtdeOidEtapDeud()!= null)
             {
                query.append(" AND OID_ETAP_DEUD = " + cobUsuarEtapaCobraCabecFrom.getEtdeOidEtapDeud().getId());
             }
            
            if(cobUsuarEtapaCobraCabecFrom.getUscoOidUsuaCobr()!= null)
            {
                query.append(" AND OID_USUA_COBR = " + cobUsuarEtapaCobraCabecFrom.getUscoOidUsuaCobr().getId());
            }
            if(cobUsuarEtapaCobraCabecFrom.getValObse()!=null)
            {
                query.append(" AND val_obse like '" + cobUsuarEtapaCobraCabecFrom.getValObse() + "'");
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
            
            CobUsuarEtapaCobraCabecData cobUsuarEtac = null;
            SegPaisViewData segPais = null;
            CobEtapaDeudaData cobEtapa = null;
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
                      cobUsuarEtac = new CobUsuarEtapaCobraCabecData();
                      segPais = new SegPaisViewData();
                      cobEtapa = new CobEtapaDeudaData();
                      cobUsuCobra = new CobUsuarCobraViewData();
                      genUser = new GenUsersData();
                      genPrin = new GenPrincipalsData();
                      String valObse = null;
                      
                      cobUsuarEtac.setId(Long.valueOf(((BigDecimal)rs.getValueAt(i,"OID_USUA_ETAP_COBR")).toString()));
                      cobEtapa.setId(Long.valueOf(((BigDecimal)rs.getValueAt(i,"OID_ETAP_DEUD")).toString()));
                      cobEtapa.setCodEtapDeud((String)rs.getValueAt(i,"COD_ETAP_DEUD"));
                      cobEtapa.setValDesc((String)rs.getValueAt(i,"VAL_DESC"));
                      segPais.setId(Long.valueOf(((BigDecimal)rs.getValueAt(i,"OID_PAIS")).toString()));
                      cobUsuCobra.setId(Long.valueOf(((BigDecimal)rs.getValueAt(i,"OID_USUA_COBR")).toString()));
                      genPrin.setId(Long.valueOf(((BigDecimal)rs.getValueAt(i,"USER_OID_USUA_COBR")).toString()));
                      genPrin.setName((String)rs.getValueAt(i,"NAME"));
                      genUser.setId(Long.valueOf(((BigDecimal)rs.getValueAt(i,"IDUSER")).toString()));
                      genUser.setMyid(genPrin);
                      cobUsuCobra.setUserOidUsuaCobr(genUser);
                      cobUsuarEtac.setEtdeOidEtapDeud(cobEtapa);
                      cobUsuarEtac.setUscoOidUsuaCobr(cobUsuCobra);
                      valObse = (String)rs.getValueAt(i,"VAL_OBSE");
                      if(valObse != null)
                      {
                           cobUsuarEtac.setValObse(String.valueOf(valObse));
                      }
                      
                      
                                        
                                        
                      result.add(cobUsuarEtac);
                }catch(Exception ex)
                {
                  ex.printStackTrace();
                }
                } else {
                   break;
                }
            }
        
            UtilidadesLog.info("DAOUsuEtapaCobraCabe.query(CobUsuarEtapaCobraCabecData cobUsuarEtapaCobraCabecFrom, CobUsuarEtapaCobraCabecData cobUsuarEtapaCobraCabecTo, HashMap userProperties, Integer pageCount, Integer pageSize):Salida");
            return result;
        }
        
        public void update(CobUsuarEtapaCobraCabecData cobUsuarEtapaCobraCabec, Vector localizationLabels) throws MareException
        {   UtilidadesLog.info("DAOUsuEtapaCobraCabe.update(CobUsuarEtapaCobraCabecData cobUsuarEtapaCobraCabec, Vector localizationLabels):Entrada");
            RecordSet rs = null;
            BelcorpService bs = UtilidadesEJB.getBelcorpService();
               
            StringBuffer update = new StringBuffer();
            update.append("   UPDATE COB_USUAR_ETAPA_COBRA_CABEC SET ");
            update.append("           VAL_OBSE = '" + cobUsuarEtapaCobraCabec.getValObse() + "'" );
            
           
            update.append("   where OID_USUA_ETAP_COBR = " + cobUsuarEtapaCobraCabec.getId());
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
            UtilidadesLog.info("DAOUsuEtapaCobraCabe.update(CobUsuarEtapaCobraCabecData cobUsuarEtapaCobraCabec, Vector localizationLabels):Salida");

        }
        
        public void remove(Vector entities) throws MareException
        {   UtilidadesLog.info("DAOUsuEtapaCobraCabe.remove(Vector entities):Entrada");
            RecordSet rs = null;
            BelcorpService bs = UtilidadesEJB.getBelcorpService();
            StringBuffer update = new StringBuffer();
            
            
            int cant = entities.size();
            CobUsuarEtapaCobraCabecData cobUsuaEtaCob = null;
            String oids = "";
            
            for (int j = 0; j < cant; j++) {
               cobUsuaEtaCob  = (CobUsuarEtapaCobraCabecData)entities.get(j);
                 
                oids = oids + "," + cobUsuaEtaCob.getId();
            }
            
            update.append("DELETE COB_USUAR_ETAPA_COBRA_CABEC ");
            update.append("WHERE OID_USUA_ETAP_COBR in ( " + oids.substring(1) + ") ");
            
                   
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
            UtilidadesLog.info("DAOUsuEtapaCobraCabe.remove(Vector entities):Salida");
        
        
            
        }
        
         public Hashtable guardar(CobUsuarEtapaCobraCabecData cobUsuarEtapaCobraCabec, Vector localizationLabels, HashMap userProperties) throws MareException
        {   UtilidadesLog.info("DAOUsuEtapaCobraCabe.guardar(CobUsuarEtapaCobraCabecData cobUsuarEtapaCobraCabec, Vector localizationLabels, HashMap userProperties):Entrada");
            RecordSet rs = null;
              BelcorpService bs = UtilidadesEJB.getBelcorpService();     
              StringBuffer update = new StringBuffer();
              RecordSet rsPK = null;
              StringBuffer query = new StringBuffer();      
              Long id = null;
              query.append(" SELECT COB_UECC_SEQ.NEXTVAL FROM DUAL ");
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
              update.append("INSERT INTO COB_USUAR_ETAPA_COBRA_CABEC (");
              update.append("              OID_USUA_ETAP_COBR  ");
              update.append("              , USCO_OID_USUA_COBR ");
              update.append("              , ETDE_OID_ETAP_DEUD ");
              update.append("              , VAL_OBSE ");
              update.append("  ) VALUES (   ");
              update.append(id);
              update.append(" , " + cobUsuarEtapaCobraCabec.getUscoOidUsuaCobr().getId());
              update.append(" , " +  cobUsuarEtapaCobraCabec.getEtdeOidEtapDeud().getId());
              update.append(" , '" + cobUsuarEtapaCobraCabec.getValObse() + "'");
              
              update.append("  )  ");
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
              UtilidadesLog.info("DAOUsuEtapaCobraCabe.guardar(CobUsuarEtapaCobraCabecData cobUsuarEtapaCobraCabec, Vector localizationLabels, HashMap userProperties):Salida");
              return primaryKey;
        }


}
