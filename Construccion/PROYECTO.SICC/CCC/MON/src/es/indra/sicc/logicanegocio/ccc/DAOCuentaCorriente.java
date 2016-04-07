package es.indra.sicc.logicanegocio.ccc;

import es.indra.belcorp.mso.CccBancoData;
import es.indra.belcorp.mso.CccCuentContaData;
import es.indra.belcorp.mso.CccCuentCorriBancaData;
import es.indra.belcorp.mso.CccSucurData;
import es.indra.belcorp.mso.SegPaisViewData;
import es.indra.belcorp.mso.SegSocieData;
import es.indra.mare.common.exception.MareException;
import es.indra.mare.common.mgu.manager.Property;
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

public class DAOCuentaCorriente {
    public DAOCuentaCorriente() {
    }
    public Vector query(SegSocieData segSocieFrom, SegSocieData segSocieTo, HashMap userProperties)throws MareException
     {
         UtilidadesLog.info("DAOCuentaCorriente.query(SegSocieData segSocieFrom, SegSocieData segSocieTo, HashMap userProperties, Boolean applyStructuralSecurity): Entrada");
         RecordSet rs = new RecordSet();
         StringBuffer query = new StringBuffer();
         StringBuffer queryUser = new StringBuffer();
         BelcorpService bs;
         Vector resultado = new Vector();

         try {
             bs = BelcorpService.getInstance();
         } catch (MareMiiServiceNotFoundException e) {
             UtilidadesLog.error("ERROR ", e);
             throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_PEDIR_UN_SERVICIO_MARE));
         }

                    
               Property userID = (Property)userProperties.get("userID");
               query.append("   SELECT SEG_SOCIE.OID_SOCI, SEG_SOCIE.VAL_DENO ");
               query.append("                 FROM SEG_SOCIE   ");
               query.append("               WHERE SEG_SOCIE.OID_SOCI IN (SELECT OID_SOCI from VCA_SEG_SOCIE where COD_USUA=  '" + userID.getValue()+ "') ");
           try
           {
             rs = bs.dbService.executeStaticQuery(query.toString());
        
            }catch (Exception ex) {
              
                 throw new MareException(ex, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS));
           }
            if(!rs.esVacio())
           {
               for(int i = 0; i < rs.getRowCount(); i++)
               {
                      SegSocieData segSocie = new SegSocieData();
                      segSocie.setId(new Long(((BigDecimal)rs.getValueAt(i,"OID_SOCI")).toString()));
                      segSocie.setValDeno( (String)rs.getValueAt(i,"VAL_DENO"));
                      UtilidadesLog.info("DAOCuentaCorriente.query(SegSocieData segSocieFrom, SegSocieData segSocieTo, HashMap userProperties, Boolean applyStructuralSecurity): Salida");
                      resultado.add(segSocie);
                }        
            
            }
           UtilidadesLog.info("DAOCuentaCorriente.query(SegSocieData segSocieFrom, SegSocieData segSocieTo, HashMap userProperties, Boolean applyStructuralSecurity): Salida");
          return resultado;
        }
        public Vector query(CccCuentContaData cccCuentContaFrom, CccCuentContaData cccCuentContaTo, HashMap userProperties)throws MareException
            {
               UtilidadesLog.info("DAOCuentaCorriente.query(CccCuentContaData cccCuentContaFrom, CccCuentContaData cccCuentContaTo, HashMap userProperties): Entrada");
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
               try{
               query.append("  SELECT V_GEN_I18N_SICC.VAL_OID, V_GEN_I18N_SICC.VAL_I18N ");
               query.append("         FROM V_GEN_I18N_SICC, CCC_CUENT_CONTA ");
               query.append("         WHERE V_GEN_I18N_SICC.ATTR_ENTI = 'CCC_CUENT_CONTA'  ");
               query.append("               AND V_GEN_I18N_SICC.ATTR_NUM_ATRI = 1 ");
               query.append("               AND V_GEN_I18N_SICC.IDIO_OID_IDIO = 1 ");
               query.append("               AND V_GEN_I18N_SICC.VAL_OID = CCC_CUENT_CONTA.OID_CUEN_CONT ");
               query.append("               ORDER BY V_GEN_I18N_SICC.VAL_I18N ");
               }catch(Exception ex)
               {
                   ex.printStackTrace();
               }
               try
               {
                  rs = bs.dbService.executeStaticQuery(query.toString());
        
                }catch (Exception ex) {
              
                 throw new MareException(ex, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS));
                }
                 if(!rs.esVacio())
                  {
                    for(int i = 0; i < rs.getRowCount(); i++)
                    {  
                       try{
                       CccCuentContaData cccCuentConta = new CccCuentContaData();
                       cccCuentConta.setId( new Long(((BigDecimal)rs.getValueAt(i,"VAL_OID")).toString()));
                       cccCuentConta.setDescripcion((String)rs.getValueAt(i,"VAL_I18N"));
                       resultado.add(cccCuentConta);
                       }catch(Exception ex )
                       {
                          ex.printStackTrace();
                       }
                    }
                  }
                   UtilidadesLog.info("DAOCuentaCorriente.query(CccCuentContaData cccCuentContaFrom, CccCuentContaData cccCuentContaTo, HashMap userProperties): Salida");
                   return resultado;
        }
        public Vector query(CccBancoData cccBancoFrom, CccBancoData cccBancoTo, HashMap userProperties)throws MareException
        {
           UtilidadesLog.info("DAOCuentaCorriente.query(CccBancoData cccBancoFrom, CccBancoData cccBancoTo, HashMap userProperties): Entrada");
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
          query.append(" SELECT CCC_BANCO.OID_BANC, CCC_BANCO.DES_BANC  ");
          query.append("        FROM CCC_BANCO ");
          query.append("        ORDER BY CCC_BANCO.DES_BANC");
          try
          {
                 rs = bs.dbService.executeStaticQuery(query.toString());
        
           }catch (Exception ex) {
              
                 throw new MareException(ex, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS));
          }
          if(!rs.esVacio())
          {
             for(int i = 0; i < rs.getRowCount(); i++)
             {
                CccBancoData cccBanco = new CccBancoData();
                cccBanco.setId(new Long(((BigDecimal)rs.getValueAt(i,"OID_BANC")).toString()));
                cccBanco.setDesBanc((String)rs.getValueAt(i,"DES_BANC"));
                resultado.add(cccBanco);
             }
          } 
          UtilidadesLog.info("DAOCuentaCorriente.query(CccBancoData cccBancoFrom, CccBancoData cccBancoTo, HashMap userProperties): Salida");
          return resultado;
        }
        public Vector query(CccSucurData cccSucurFrom, CccSucurData cccSucurTo,  HashMap userProperties)throws MareException
        {
           UtilidadesLog.info("DAOCuentaCorriente.query(CccSucurData cccSucurFrom, CccSucurData cccSucurTo,  HashMap userProperties): Entrada");
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
          try{
          query.append("  SELECT CCC_SUCUR.OID_SUCU, CCC_SUCUR.COD_SUCU, CCC_BANCO.OID_BANC, CCC_BANCO.DES_BANC ");
          query.append("         FROM CCC_SUCUR, CCC_BANCO  ");
          query.append("         WHERE CCC_SUCUR.CBAN_OID_BANC = CCC_BANCO.OID_BANC ");
          query.append("               AND CCC_BANCO.OID_BANC = " + cccSucurFrom.getCbanOidBanc().getId());
          
          }catch(Exception ex)
          {
             ex.printStackTrace();
          }
          try
          {
                 rs = bs.dbService.executeStaticQuery(query.toString());
        
           }catch (Exception ex) {
              
                 throw new MareException(ex, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS));
          }
          if(!rs.esVacio())
          {
             for(int i = 0; i < rs.getRowCount(); i++)
             {
                 try{
                 CccSucurData cccSucur = new CccSucurData();
                 cccSucur.setId(new Long(((BigDecimal)rs.getValueAt(i,"OID_SUCU")).toString()));
                 cccSucur.setCodSucu((String)rs.getValueAt(i,"COD_SUCU"));
                 CccBancoData cccBancoFrom = new CccBancoData();
                 cccBancoFrom.setId(new Long(((BigDecimal)rs.getValueAt(i,"OID_BANC")).toString()));
                 cccBancoFrom.setDesBanc((String)rs.getValueAt(i,"DES_BANC"));
                 cccSucur.setCbanOidBanc(cccBancoFrom);
                 resultado.add(cccSucur);
                 }catch(Exception ex)
                 {
                    ex.printStackTrace();
                 }
             }
          }
           UtilidadesLog.info("DAOCuentaCorriente.query(CccSucurData cccSucurFrom, CccSucurData cccSucurTo,  HashMap userProperties): Salida");
           return resultado;
        }
     public Vector query(CccSucurData cccSucurFrom, CccSucurData cccSucurTo, HashMap userProperties, Boolean applyStructuralSecurity) throws MareException
     {
       UtilidadesLog.info("DAOCuentasCorrientes.query(CccSucurData cccSucurFrom, CccSucurData cccSucurTo, HashMap userProperties, Boolean applyStructuralSecurity): Entrada");
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
       query.append("  SELECT CCC_SUCUR.OID_SUCU, CCC_SUCUR.COD_SUCU ");
       query.append("         FROM CCC_SUCUR ");
       query.append("         WHERE CCC_SUCUR.CBAN_OID_BANC = " + cccSucurFrom.getCbanOidBanc().getId());
       try
       {
                 rs = bs.dbService.executeStaticQuery(query.toString());
        
           }catch (Exception ex) {
              
                 throw new MareException(ex, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS));
       }
       if(!rs.esVacio())
       {
         for(int i = 0; i < rs.getRowCount(); i++)
          {
              CccSucurData cccSucur = new CccSucurData();
              cccSucur.setId(new Long(((BigDecimal)rs.getValueAt(i,"OID_SUCU")).toString()));
              cccSucur.setCodSucu((String)rs.getValueAt(i,"COD_SUCU"));
              resultado.add(cccSucur);
           }
       }
       UtilidadesLog.info("DAOCuentasCorrientes.query(CccSucurData cccSucurFrom, CccSucurData cccSucurTo, HashMap userProperties, Boolean applyStructuralSecurity): Salida");
        return resultado;
     }
     public Hashtable guardarCuentaCorrient(CccCuentCorriBancaData cccCuentCorriBanca, Vector localizationLabels, HashMap userProperties)throws MareException
     {
         UtilidadesLog.info("DAOCuentasCorrientes.guardarCuentaCorrient(CccCuentCorriBancaData cccCuentCorriBanca, Vector localizationLabels, HashMap userProperties): Entrada");
         RecordSet rs = null;
         BelcorpService bs = UtilidadesEJB.getBelcorpService();     
         StringBuffer update = new StringBuffer();
         RecordSet rsPK = null;
         StringBuffer query = new StringBuffer();      
         Long id = null;
         query.append(" SELECT CCC_CCBA_SEQ.NEXTVAL FROM DUAL ");
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
         update.append("INSERT INTO CCC_CUENT_CORRI_BANCA (");
         update.append("              OID_CUEN_CORR_BANC   ");
         update.append("              , SOCI_OID_SOCI ");
         update.append("              , SUCU_OID_SUCU ");
         update.append("              , CUCO_OID_CC_PNTE ");
         update.append("              , CUCO_OID_CC_TESO ");
         update.append("              , COD_CC ");
         update.append("              , COD_CC_BANC ");
         update.append("              , DES_CC ");
         update.append("              , VAL_NUME_SWIF ");
         update.append("              , VAL_DIRE ");
         update.append("              , VAL_CONT ");
         update.append("              , VAL_TELE ");
         update.append("              , VAL_OBSE ");
         update.append("              , PAIS_OID_PAIS ");
         update.append("  ) VALUES (   ");
         update.append(id);
         update.append(" , " + cccCuentCorriBanca.getSociOidSoci().getId());
         update.append(" , " + cccCuentCorriBanca.getSucuOidSucu().getId());
         update.append(" , " + cccCuentCorriBanca.getCucoOidCcTeso().getId());
         update.append(" , " + cccCuentCorriBanca.getCucoOidCcPnte().getId());
         update.append(" , '" + cccCuentCorriBanca.getCodCc()+ "' ");
         update.append(" , '" + cccCuentCorriBanca.getCodCcBanc() + "' ");
         update.append(" , '" + cccCuentCorriBanca.getDesCc()+ "'");
         if(cccCuentCorriBanca.getValNumeSwif() != null)
         {
            update.append(" , '" + cccCuentCorriBanca.getValNumeSwif() + "' ");
         }else
         {
            update.append(" , NULL");
         }
         if(cccCuentCorriBanca.getValDire() != null)
         {
            update.append(" , '" + cccCuentCorriBanca.getValDire() + "' ");
         }else
         {
           update.append(" , NULL ");
         }
         if(cccCuentCorriBanca.getValCont() != null)
         {
            update.append(" , '" + cccCuentCorriBanca.getValCont() +"' ");
         }else
         {
            update.append(" , NULL ");
         }
         if(cccCuentCorriBanca.getValTele() != null)
         {
            update.append(" , '" + cccCuentCorriBanca.getValTele() +"' ");
         }else
         {
            update.append(" , NULL ");
         }
         if(cccCuentCorriBanca.getValObse() != null)
         {
            update.append(" , '" + cccCuentCorriBanca.getValObse() + "' ");
         }else
         {
            update.append(" , NULL");
         }
         if(cccCuentCorriBanca.getPaisOidPais() != null)
         {
           update.append(" , " + cccCuentCorriBanca.getPaisOidPais().getId());
         }
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
         UtilidadesLog.info("DAOCuentasCorrientes.guardarCuentaCorrient(CccCuentCorriBancaData cccCuentCorriBanca, Vector localizationLabels, HashMap userProperties): Salida");
         return primaryKey;
     }
     public Vector query(CccCuentCorriBancaData cccCuentCorriBancaFrom, CccCuentCorriBancaData cccCuentCorriBancaTo, HashMap userProperties, Integer pageCount, Integer pageSize)throws MareException
     {
       UtilidadesLog.info("DAOCuentasCorrientes.query(CccCuentCorriBancaData cccCuentCorriBancaFrom, CccCuentCorriBancaData cccCuentCorriBancaTo, HashMap userProperties, Integer pageCount, Integer pageSize): Entrada");
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
       query.append("  SELECT  CCC_CUENT_CORRI_BANCA.OID_CUEN_CORR_BANC, CCC_CUENT_CORRI_BANCA.COD_CC, ");
       
       query.append("          SEG_SOCIE.OID_SOCI, SEG_SOCIE.VAL_DENO, CCC_CUENT_CORRI_BANCA.DES_CC,  ");
       
       query.append("          V_GEN_I18N_SICC.VAL_I18N DESCUENTCONTATESO, V_GEN_I18N_SICC.VAL_OID OIDCUENTCONTATESO, ");
       
       query.append("          I18N.VAL_I18N DESCUENTCONTAPUENT, I18N.VAL_OID OIDCUENTCONTAPUENT,  ");
       
       query.append("          CCC_CUENT_CORRI_BANCA.COD_CC_BANC, CCC_SUCUR.OID_SUCU, CCC_SUCUR.COD_SUCU,  ");
       
       query.append("          SEG_PAIS.OID_PAIS, CCC_CUENT_CORRI_BANCA.VAL_CONT, CCC_CUENT_CORRI_BANCA.VAL_DIRE,  ");
       
       query.append("          CCC_CUENT_CORRI_BANCA.VAL_NUME_SWIF, CCC_CUENT_CORRI_BANCA.VAL_OBSE, ");
       
       query.append("          CCC_CUENT_CORRI_BANCA.VAL_TELE, CCC_BANCO.OID_BANC, CCC_BANCO.DES_BANC ");
       
       query.append("          FROM CCC_CUENT_CORRI_BANCA, SEG_SOCIE, V_GEN_I18N_SICC, ");
       query.append("               V_GEN_I18N_SICC I18N,  CCC_SUCUR, SEG_PAIS, CCC_CUENT_CONTA, ");
       query.append("               CCC_CUENT_CONTA CUENT2, CCC_BANCO ");
       
       query.append("               WHERE CCC_CUENT_CORRI_BANCA.CUCO_OID_CC_PNTE = CCC_CUENT_CONTA.OID_CUEN_CONT ");
       if(cccCuentCorriBancaFrom.getCucoOidCcTeso() != null)
       {
         query.append("                   AND CCC_CUENT_CONTA.OID_CUEN_CONT = " + cccCuentCorriBancaFrom.getCucoOidCcTeso().getId());
       }
       query.append("                     AND CCC_CUENT_CORRI_BANCA.CUCO_OID_CC_TESO = CUENT2.OID_CUEN_CONT  ");
       if(cccCuentCorriBancaFrom.getCucoOidCcPnte() != null)
       {
         query.append("                   AND CUENT2.OID_CUEN_CONT = " + cccCuentCorriBancaFrom.getCucoOidCcPnte().getId());
       }
       query.append("                     AND CCC_CUENT_CORRI_BANCA.PAIS_OID_PAIS = SEG_PAIS.OID_PAIS ");
       if(cccCuentCorriBancaFrom.getPaisOidPais() != null)
       {
         query.append("                   AND SEG_PAIS.OID_PAIS = " + cccCuentCorriBancaFrom.getPaisOidPais().getId());
       }
       query.append("                     AND CCC_CUENT_CORRI_BANCA.SOCI_OID_SOCI = SEG_SOCIE.OID_SOCI  ");
       if(cccCuentCorriBancaFrom.getSociOidSoci() != null)
       {
         query.append("                   AND SEG_SOCIE.OID_SOCI = " + cccCuentCorriBancaFrom.getSociOidSoci().getId()); 
       }
       query.append("                     AND CCC_CUENT_CORRI_BANCA.SUCU_OID_SUCU = CCC_SUCUR.OID_SUCU ");
       if(cccCuentCorriBancaFrom.getSucuOidSucu() != null)
       {
         query.append("                   AND CCC_SUCUR.OID_SUCU = " + cccCuentCorriBancaFrom.getSucuOidSucu().getId() );
       }
       if(cccCuentCorriBancaFrom.getCodCc() != null)
       {
         query.append("                   AND CCC_CUENT_CORRI_BANCA.COD_CC LIKE '" +  cccCuentCorriBancaFrom.getCodCc() + "' ");
       }
       if(cccCuentCorriBancaFrom.getDesCc() != null)
       {
         query.append("                   AND CCC_CUENT_CORRI_BANCA.DES_CC LIKE '" + cccCuentCorriBancaFrom.getDesCc() +"' ");
       }
       if(cccCuentCorriBancaFrom.getCodCcBanc() != null)
       {
         query.append("                   AND CCC_CUENT_CORRI_BANCA.COD_CC_BANC LIKE '" + cccCuentCorriBancaFrom.getCodCcBanc() + "'");
       }
       query.append("                     AND CCC_SUCUR.CBAN_OID_BANC = CCC_BANCO.OID_BANC ");
       query.append("                     AND V_GEN_I18N_SICC.ATTR_ENTI = 'CCC_CUENT_CONTA' ");
       query.append("                     AND V_GEN_I18N_SICC.ATTR_NUM_ATRI = 1 ");
       query.append("                     AND V_GEN_I18N_SICC.IDIO_OID_IDIO = 1 ");
       query.append("                     AND V_GEN_I18N_SICC.VAL_OID = CCC_CUENT_CONTA.OID_CUEN_CONT ");
       
       query.append("                     AND I18N.ATTR_ENTI = 'CCC_CUENT_CONTA' ");
       query.append("                     AND I18N.ATTR_NUM_ATRI = 1 ");
       query.append("                     AND I18N.IDIO_OID_IDIO = 1 ");
       query.append("                     AND I18N.VAL_OID = CUENT2.OID_CUEN_CONT ");
       if(cccCuentCorriBancaFrom.getId() != null )
       {
          query.append("                  AND CCC_CUENT_CORRI_BANCA.OID_CUEN_CORR_BANC = " + cccCuentCorriBancaFrom.getId());
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
        CccCuentCorriBancaData cccCuentCorriBanca = null;
        CccSucurData cccSucurFrom = null;
        CccBancoData cccBancoFrom = null;
        CccCuentContaData cccCuentContaFrom = null;
        CccCuentContaData cccCuentConta = null;
        SegSocieData segSocieFrom = null;
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
                 cccCuentCorriBanca = new CccCuentCorriBancaData();
                 cccCuentCorriBanca.setId( new Long(((BigDecimal)rs.getValueAt(i,"OID_CUEN_CORR_BANC")).toString()));
                 cccCuentCorriBanca.setCodCc((String)rs.getValueAt(i,"COD_CC"));
                 
                 segSocieFrom = new SegSocieData();
                 segSocieFrom.setId(new Long(((BigDecimal)rs.getValueAt(i,"OID_SOCI")).toString()));
                 segSocieFrom.setValDeno((String)rs.getValueAt(i,"VAL_DENO"));
                 cccCuentCorriBanca.setSociOidSoci(segSocieFrom);
                 
                 cccCuentCorriBanca.setDesCc((String)rs.getValueAt(i,"DES_CC"));
                 
                 cccCuentContaFrom = new CccCuentContaData();
                 cccCuentContaFrom.setId(new Long(((BigDecimal)rs.getValueAt(i,"OIDCUENTCONTATESO")).toString()));
                 cccCuentContaFrom.setDescripcion((String)rs.getValueAt(i,"DESCUENTCONTATESO"));
                 cccCuentCorriBanca.setCucoOidCcTeso(cccCuentContaFrom);
                 
                 cccCuentConta = new CccCuentContaData();
                 cccCuentConta.setId(new Long(((BigDecimal)rs.getValueAt(i,"OIDCUENTCONTAPUENT")).toString()));
                 cccCuentConta.setDescripcion((String)rs.getValueAt(i,"DESCUENTCONTAPUENT"));
                 cccCuentCorriBanca.setCucoOidCcPnte(cccCuentConta);
                 
                 cccCuentCorriBanca.setCodCcBanc((String)rs.getValueAt(i,"COD_CC_BANC"));
                 
                 cccBancoFrom = new CccBancoData();
                 cccBancoFrom.setId(new Long(((BigDecimal)rs.getValueAt(i,"OID_BANC")).toString()));
                 cccBancoFrom.setDesBanc((String)rs.getValueAt(i,"DES_BANC"));
                 
                 cccSucurFrom = new CccSucurData();
                 cccSucurFrom.setId(new Long(((BigDecimal)rs.getValueAt(i,"OID_SUCU")).toString()));
                 cccSucurFrom.setCodSucu((String)rs.getValueAt(i,"COD_SUCU"));
                 cccSucurFrom.setCbanOidBanc(cccBancoFrom);
                 cccCuentCorriBanca.setSucuOidSucu(cccSucurFrom);
                 
                 segPaisViewFrom = new SegPaisViewData();
                 segPaisViewFrom.setId(new Long(((BigDecimal)rs.getValueAt(i,"OID_PAIS")).toString()));
                 cccCuentCorriBanca.setPaisOidPais(segPaisViewFrom);
                 
                 cccCuentCorriBanca.setValCont((String)rs.getValueAt(i,"VAL_CONT"));
                 cccCuentCorriBanca.setValDire((String)rs.getValueAt(i,"VAL_DIRE"));
                 cccCuentCorriBanca.setValNumeSwif((String)rs.getValueAt(i,"VAL_NUME_SWIF"));
                 cccCuentCorriBanca.setValObse((String)rs.getValueAt(i,"VAL_OBSE"));
                 cccCuentCorriBanca.setValTele((String)rs.getValueAt(i,"VAL_TELE"));
                 
                 result.add(cccCuentCorriBanca);
                 
                            
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
           UtilidadesLog.info("DAOCuentasCorrientes.query(CccCuentCorriBancaData cccCuentCorriBancaFrom, CccCuentCorriBancaData cccCuentCorriBancaTo, HashMap userProperties, Integer pageCount, Integer pageSize): Salida");
           return result;                                                               
                 
     }
     public void update(CccCuentCorriBancaData cccCuentCorriBanca, Vector localizationLabels)throws MareException
     {
       UtilidadesLog.info("DAOCuentasCorrientes.query(CccCuentCorriBancaData cccCuentCorriBanca, Vector localizationLabels): Entrada");
       RecordSet rs = null;
       BelcorpService bs = UtilidadesEJB.getBelcorpService();
          
       StringBuffer update = new StringBuffer();
       update.append("   UPDATE CCC_CUENT_CORRI_BANCA SET ");
       update.append("           SOCI_OID_SOCI = " + cccCuentCorriBanca.getSociOidSoci().getId() );
       update.append("           ,  SUCU_OID_SUCU = " + cccCuentCorriBanca.getSucuOidSucu().getId());
       update.append("           ,  CUCO_OID_CC_PNTE = " + cccCuentCorriBanca.getCucoOidCcTeso().getId());
       update.append("           ,  CUCO_OID_CC_TESO = " + cccCuentCorriBanca.getCucoOidCcPnte().getId());
       update.append("           ,  COD_CC_BANC = '" + cccCuentCorriBanca.getCodCcBanc() +"'");
       update.append("           , DES_CC = '" + cccCuentCorriBanca.getDesCc() +"' ");
       if(cccCuentCorriBanca.getValNumeSwif() != null){
         update.append("           , VAL_NUME_SWIF = '" + cccCuentCorriBanca.getValNumeSwif() + "' ");
       }else
       {
         update.append("           ,  VAL_NUME_SWIF = NULL");
       }
       if(cccCuentCorriBanca.getValDire() != null)
       {
          update.append("          , VAL_DIRE = '" +cccCuentCorriBanca.getValDire() +"' ");
       }else
       {
         update.append("           , VAL_DIRE = NULL");
       }
       if(cccCuentCorriBanca.getValCont() != null)
       {
          update.append("          , VAL_CONT = '" + cccCuentCorriBanca.getValCont()+ "'"); 
       }else
       {
         update.append("           , VAL_CONT = NULL");
       }
       if(cccCuentCorriBanca.getValTele() != null)
       {
         update.append("           , VAL_TELE = '" + cccCuentCorriBanca.getValTele()+ "'");
       }else
       {
         update.append("           ,  VAL_TELE = NULL");
       }
       if(cccCuentCorriBanca.getValObse() != null)
       {
         update.append("           , VAL_OBSE = '" + cccCuentCorriBanca.getValObse() +"' ");
       }else
       {
         update.append("           , VAL_OBSE = NULL");
       }
       update.append("   where OID_CUEN_CORR_BANC = " + cccCuentCorriBanca.getId());
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
      UtilidadesLog.info("DAOCuentasCorrientes.query(CccCuentCorriBancaData cccCuentCorriBanca, Vector localizationLabels): Salida");
    }
    public void remove(Vector cccCuentaCorriente)throws MareException
    {
      UtilidadesLog.info("DOACuentasCorriente.remove(Vector cccCuentaCorriente): Entrada");
       RecordSet rs = null;
       BelcorpService bs = UtilidadesEJB.getBelcorpService();
       StringBuffer update = new StringBuffer();
       StringBuffer updateInter = new StringBuffer();
           
       int cant = cccCuentaCorriente.size();
       CccCuentCorriBancaData cccCuentCorriBanca = null;
       String oidCuentaCorriente = "";
       for (int j = 0; j < cant; j++) {
           cccCuentCorriBanca = (CccCuentCorriBancaData)cccCuentaCorriente.get(j);
            
           oidCuentaCorriente = oidCuentaCorriente + "," + cccCuentCorriBanca.getId();
       }
        update.append("delete CCC_CUENT_CORRI_BANCA ");
        update.append("where OID_CUEN_CORR_BANC in ( " + oidCuentaCorriente.substring(1) + ") ");
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
      UtilidadesLog.info("DOACuentasCorriente.remove(Vector cccCuentaCorriente): Salida"); 
    }
}
