package es.indra.sicc.logicanegocio.inc;

import es.indra.mare.common.exception.MareException;
import es.indra.mare.common.mii.services.jdbcservice.RecordSet;
import es.indra.sicc.dtos.inc.DTOReemplazoArticuloLote;
import es.indra.sicc.dtos.pre.DTOEBuscarProductos;
import es.indra.sicc.logicanegocio.mae.ConstantesMAE;
import es.indra.sicc.logicanegocio.seg.ConstantesSEG;
import es.indra.sicc.util.BelcorpService;
import es.indra.sicc.util.CodigosError;
import es.indra.sicc.util.DTOBelcorp;
import es.indra.sicc.util.DTOOID;
import es.indra.sicc.util.DTOSalida;
import es.indra.sicc.util.UtilidadesEJB;
import es.indra.sicc.util.UtilidadesError;
import es.indra.sicc.util.UtilidadesLog;

import java.math.BigDecimal;

import java.text.SimpleDateFormat;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Vector;


public class DAORemplazoPremios {
    public DAORemplazoPremios() {
    }
    public DTOSalida obtenerConcursosNumeroNombre(DTOBelcorp dtoe) throws MareException{
        UtilidadesLog.info("DAORemplazoPremio.obtenerConcursosNumeroNombre(DTOBelcorp dtoe): Entrada");
        
        StringBuffer query = new StringBuffer();
        
        query.append(" select  distinct INC_CONCU_PARAM_GENER.OID_PARA_GRAL,  INC_CONCU_PARAM_GENER.NUM_CONC ||'-'|| INC_CONCU_PARAM_GENER.VAL_NOMB ");
        query.append("      from INC_CONCU_PARAM_GENER, ");
        query.append("                INC_VERSI_CONCU, ");
        query.append("                INC_PARAM_GENER_PREMI, ");
        query.append("                INC_PARAM_NIVEL_PREMI  ");
        query.append("                where INC_VERSI_CONCU.VICO_OID_VIGE_CONC = 1  ");
        query.append("                       AND INC_VERSI_CONCU.COPA_OID_PARA_GRAL =  ");
        query.append("                       INC_CONCU_PARAM_GENER.OID_PARA_GRAL  ");
        query.append("                       AND INC_CONCU_PARAM_GENER.IND_ACTI = 1   ");
        query.append("                       AND INC_PARAM_GENER_PREMI.COPA_OID_PARA_GRAL = ");
        query.append("                            INC_CONCU_PARAM_GENER.OID_PARA_GRAL");
        query.append("                       AND INC_PARAM_NIVEL_PREMI.PAGP_OID_PARA_GENE_PREM =   ");
        query.append("                        INC_PARAM_GENER_PREMI.OID_PARA_GENE_PREM ");
        query.append("                       AND INC_PARAM_NIVEL_PREMI.TPRE_OID_TIPO_PREM = 2 ");
        query.append("                       order by  inc_concu_param_gener.num_conc ");
        query.append("                          || '-' ");
        query.append("                          || inc_concu_param_gener.val_nomb ");
        
        BelcorpService bs = UtilidadesEJB.getBelcorpService();
        RecordSet rs = null;
        try {
              rs = bs.dbService.executeStaticQuery(query.toString());
        } catch (Exception e) {
              UtilidadesLog.error("DAORemplazoPremio.obtenerConcursosNumeroNombre(DTOBelcorp dtoe): Exception",e);
              throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS));              
        }
        if (rs.esVacio()){
              UtilidadesLog.debug("DAORemplazoPremio.obtenerConcursosNumeroNombre(DTOBelcorp dtoe): no hay datos ");                           
              throw new MareException(new Exception(),UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE));              
        }
        UtilidadesLog.debug("DAORemplazoPremio.obtenerConcursosNumeroNombre(DTOBelcorp dtoe): Se han obtenido: [" + rs.getRowCount() + "] registro(s)");
        DTOSalida dtoSalida = new DTOSalida();
        dtoSalida.setResultado(rs);
        UtilidadesLog.debug("DAORemplazoPremio.obtenerConcursosNumeroNombre(DTOBelcorp dtoe): Salida");
        return dtoSalida;        

    }
    public DTOSalida buscarPremiosConcurso(DTOOID dtoe) throws MareException{
            UtilidadesLog.info("DAORemplazoPremios.buscarPremioConcurso(DTOBelcorp dtoe): Entrada");
            StringBuffer query = new StringBuffer(); 
            query.append("  select  INC_ARTIC_LOTE.OID_ARTI_LOTE OID, INC_PARAM_NIVEL_PREMI.NUM_NIVE, ");
            query.append("  INC_LOTE_PREMI_ARTIC.NUM_PREM, ");
            query.append("  MAE_PRODU.COD_SAP, ");
            query.append("  V_GEN_I18N_SICC.VAL_I18N,  ");
            query.append("  INC_ARTIC_LOTE.NUM_UNID,  ");
            query.append("  INC_ARTIC_LOTE.OID_ARTI_LOTE, ");
            query.append("  INC_ARTIC_LOTE.COD_VENT_FICT ");
            query.append("  FROM INC_PARAM_NIVEL_PREMI,  ");
            query.append("       MAE_PRODU, ");
            query.append("       INC_LOTE_PREMI_ARTIC, ");
            query.append("       INC_ARTIC_LOTE,   ");
            query.append("       INC_PREMI_ARTIC, ");
            query.append("       V_GEN_I18N_SICC,   ");
            query.append("       INC_PARAM_GENER_PREMI, ");
            query.append("       INC_CONCU_PARAM_GENER ");
            query.append("       WHERE INC_ARTIC_LOTE.LOPA_OID_LOTE_PREM_ARTI =  ");
            query.append("             INC_LOTE_PREMI_ARTIC.OID_LOTE_PREM_ARTI  ");
            query.append("         AND INC_ARTIC_LOTE.PROD_OID_PROD = MAE_PRODU.OID_PROD  ");
            query.append("         AND INC_LOTE_PREMI_ARTIC.PRAR_OID_PREM_ARTI =    ");
            query.append("             INC_PREMI_ARTIC.OID_PREM_ARTI ");
            query.append("         AND INC_PREMI_ARTIC.PANP_OID_PARA_NIVE_PREM = ");
            query.append("             INC_PARAM_NIVEL_PREMI.OID_PARA_NIVE_PREM ");
            query.append("         AND INC_PARAM_NIVEL_PREMI.PAGP_OID_PARA_GENE_PREM =    ");
            query.append("             INC_PARAM_GENER_PREMI.OID_PARA_GENE_PREM  ");
            query.append("         AND INC_PARAM_GENER_PREMI.COPA_OID_PARA_GRAL =   ");
            query.append("             INC_CONCU_PARAM_GENER.OID_PARA_GRAL ");
            if(dtoe.getOid() != null){
                query.append("         AND INC_CONCU_PARAM_GENER.OID_PARA_GRAL = " + dtoe.getOid());
            }
            query.append("        AND V_GEN_I18N_SICC.ATTR_NUM_ATRI = 1  ");
            query.append("        AND V_GEN_I18N_SICC.IDIO_OID_IDIO = 1 ");
            query.append("        AND V_GEN_I18N_SICC.ATTR_ENTI = 'MAE_PRODU' ");
            query.append("        AND V_GEN_I18N_SICC.VAL_OID = MAE_PRODU.OID_PROD  ");
            query.append("        ORDER BY INC_PARAM_NIVEL_PREMI.NUM_NIVE, INC_LOTE_PREMI_ARTIC.NUM_PREM, ");
            query.append("                 MAE_PRODU.COD_SAP ");
            
            BelcorpService bs = UtilidadesEJB.getBelcorpService();
            RecordSet rs = null;
            try {
                  rs = bs.dbService.executeStaticQuery(query.toString());
            } catch (Exception e) {
                  UtilidadesLog.error("DAORemplazoPremio.obtenerConcursosNumeroNombre(DTOBelcorp dtoe): Exception",e);
                  throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS));              
            }           
            UtilidadesLog.debug("DAORemplazoPremio.obtenerConcursosNumeroNombre(DTOBelcorp dtoe): Se han obtenido: [" + rs.getRowCount() + "] registro(s)");
            DTOSalida dtoSalida = new DTOSalida();
            dtoSalida.setResultado(rs);
            UtilidadesLog.debug("DAORemplazoPremio.obtenerConcursosNumeroNombre(DTOBelcorp dtoe): Salida");
            return dtoSalida;      
    }
    public DTOSalida obtenerCriterioDeReemplazo(DTOBelcorp dtoe) throws MareException{
         
           UtilidadesLog.info("DAORemplazoPremio.obtenerCriterioDeReemplazo(DTOBelcorp dtoe): Entrada");
           StringBuffer query = new StringBuffer(); 
           query.append(" SELECT INC_CRITE_REEMP.OID_CRIT_REEM OID, ");
           query.append("       INC_CRITE_REEMP.DES_CRIT_REEM ");
           query.append("       FROM INC_CRITE_REEMP ");
           BelcorpService bs = UtilidadesEJB.getBelcorpService();
           RecordSet rs = null;
            try {
                  rs = bs.dbService.executeStaticQuery(query.toString());
            } catch (Exception e) {
                  UtilidadesLog.error("DAORemplazoPremio.obtenerConcursosNumeroNombre(DTOBelcorp dtoe): Exception",e);
                  throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS));              
            }
            if (rs.esVacio()){
                  UtilidadesLog.debug("DAORemplazoPremio.obtenerConcursosNumeroNombre(DTOBelcorp dtoe): no hay datos ");                           
                  throw new MareException(new Exception(),UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE));              
            }
            UtilidadesLog.debug("DAORemplazoPremio.obtenerConcursosNumeroNombre(DTOBelcorp dtoe): Se han obtenido: [" + rs.getRowCount() + "] registro(s)");
            DTOSalida dtoSalida = new DTOSalida();
            dtoSalida.setResultado(rs);
            UtilidadesLog.info("DAORemplazoPremio.obtenerCriterioDeReemplazo(DTOBelcorp dtoe): Salida");
            return dtoSalida;      
    }
    public DTOSalida obtenerReeplazo(DTOOID  dtoe) throws MareException{
            
            UtilidadesLog.info("DAORemplazoPremio.obtenerReemplazo(DTOBelcorp dtoe): Entrada");
            StringBuffer query = new StringBuffer();
            query.append("  SELECT  INC_REEMP_ARTIC_LOTE.OID_REEM_ARTI_LOTE OID, ");
            query.append("          REEMPLAZADO.COD_SAP REEMPLAZADO, reemplazo.oid_prod, REEMPLAZO.COD_SAP REEMPLAZO,  ");
            query.append("          V_GEN_I18N_SICC.VAL_I18N DESCRIPCION, INC_REEMP_ARTIC_LOTE.NUM_UNID , INC_REEMP_ARTIC_LOTE.COD_VENT_FICT, ");
            query.append("          INC_CRITE_REEMP.OID_CRIT_REEM, INC_CRITE_REEMP.DES_CRIT_REEM,  ");
            query.append("          INC_REEMP_ARTIC_LOTE.VAL_CRIT_REEM, INC_REEMP_ARTIC_LOTE.NUM_ORDE,  ");
            query.append("          DECODE(inc_reemp_artic_lote.ind_acti, 1, 'SI', 0, 'NO'), inc_reemp_artic_lote.oid_reem_arti_lote  ");
            
            // sapaza -- PER-SiCC-2012-0019 -- 07/03/2012
            query.append("          ,INC_FN_OBTIE_POSIC_REEMP(inc_concu_param_gener.oid_para_gral, INC_REEMP_ARTIC_LOTE.COD_VENT_FICT) VAL_POSI_REEM  ");
            
            query.append("         FROM INC_REEMP_ARTIC_LOTE,  ");
            query.append("              MAE_PRODU REEMPLAZADO ,  ");
            query.append("              MAE_PRODU REEMPLAZO,  ");
            query.append("              V_GEN_I18N_SICC, ");
            query.append("              INC_ARTIC_LOTE,   ");
            query.append("              INC_CRITE_REEMP,  ");
            query.append("              inc_param_nivel_premi,   ");
            query.append("              inc_premi_artic, ");
            query.append("              inc_lote_premi_artic, ");
            query.append("              inc_param_gener_premi, ");
            query.append("              inc_concu_param_gener ");
            
            query.append("         WHERE  INC_REEMP_ARTIC_LOTE.ARLO_OID_ARTI_LOTE =   ");
            query.append("                    INC_ARTIC_LOTE.OID_ARTI_LOTE  ");
            query.append("               AND  INC_ARTIC_LOTE.PROD_OID_PROD = ");
            query.append("                    REEMPLAZADO.OID_PROD  ");
            query.append("               AND inc_reemp_artic_lote.prod_oid_prod =  ");
            query.append("                    reemplazo.oid_prod   ");
            query.append("               AND INC_REEMP_ARTIC_LOTE.CTRE_OID_CRIT_REEM =  ");
            query.append("                   INC_CRITE_REEMP.OID_CRIT_REEM   ");
            query.append("               AND  V_GEN_I18N_SICC.ATTR_NUM_ATRI = 1 ");
            query.append("               AND  V_GEN_I18N_SICC.IDIO_OID_IDIO = 1  ");
            query.append("               AND  V_GEN_I18N_SICC.ATTR_ENTI = 'MAE_PRODU' ");
            query.append("               AND  V_GEN_I18N_SICC.VAL_OID = REEMPLAZO.OID_PROD ");
            query.append("               AND inc_artic_lote.lopa_oid_lote_prem_arti =  ");
            query.append("                   inc_lote_premi_artic.oid_lote_prem_arti");
            query.append("              AND inc_lote_premi_artic.prar_oid_prem_arti =    ");
            query.append("                  inc_premi_artic.oid_prem_arti   ");
            query.append("              AND inc_premi_artic.panp_oid_para_nive_prem =   ");
            query.append("                  inc_param_nivel_premi.oid_para_nive_prem  ");
            query.append("              AND inc_param_nivel_premi.pagp_oid_para_gene_prem = ");
            query.append("                  inc_param_gener_premi.oid_para_gene_prem  ");
            query.append("              AND inc_param_gener_premi.copa_oid_para_gral =  ");
            query.append("                  inc_concu_param_gener.oid_para_gral ");
            if(dtoe.getOid() != null){
                    query.append("      AND inc_concu_param_gener.oid_para_gral =  " + dtoe.getOid());
            }
            query.append("    ORDER BY  reemplazado.cod_sap, reemplazo.cod_sap, inc_reemp_artic_lote.num_orde   ");
            BelcorpService bs = UtilidadesEJB.getBelcorpService();
             RecordSet rs = null;
             String w = new String();
            
             try {
                   rs = bs.dbService.executeStaticQuery(query.toString());
             } catch (Exception e) {
                   UtilidadesLog.error("DAORemplazoPremio.obtenerConcursosNumeroNombre(DTOBelcorp dtoe): Exception",e);
                   throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS));              
            }
            
             UtilidadesLog.debug("DAORemplazoPremio.obtenerConcursosNumeroNombre(DTOBelcorp dtoe): Se han obtenido: [" + rs.getRowCount() + "] registro(s)");
             DTOSalida dtoSalida = new DTOSalida();
             dtoSalida.setResultado(rs);
             UtilidadesLog.info("DAORemplazoPremio.obtenerReemplazo(DTOBelcorp dtoe): Salida");
            return dtoSalida;      
    
    
    }
    public RecordSet codigoVentaFicticio() throws MareException{
            UtilidadesLog.info("DAORemplazoPremio.codigoVentaFicticio(DTOReemplazoArticuloLote dtoe): Entrada");
            StringBuffer query = new StringBuffer();
            query.append("  SELECT INC_CONTA_PREMI_ARTIC.NUM_RANGO_DESDE,  ");
            query.append("  INC_CONTA_PREMI_ARTIC.NUM_RANGO_HASTA,    ");
            query.append("  INC_CONTA_PREMI_ARTIC.VAL_ULTIM_CONTA ");
            query.append("  FROM INC_CONTA_PREMI_ARTIC  ");            
            BelcorpService bs = UtilidadesEJB.getBelcorpService();
            RecordSet rs = null;
            try {
                   rs = bs.dbService.executeStaticQuery(query.toString());
            } catch (Exception e) {
                   UtilidadesLog.error("DAORemplazoPremio.codigoVentaFicticio(DTOReemplazoArticuloLote dtoe): Exception",e);
                   throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS));              
            }
            if (rs.esVacio()){
                   UtilidadesLog.debug("DAORemplazoPremio.codigoVentaFicticio(DTOReemplazoArticuloLote dtoe): no hay datos ");                           
                   throw new MareException(new Exception(),UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE));              
            }
            UtilidadesLog.debug("DAORemplazoPremio.codigoVentaFicticio(DTOReemplazoArticuloLote dtoe): Se han obtenido: [" + rs.getRowCount() + "] registro(s)");                      
            
            UtilidadesLog.info("DAORemplazoPremio.codigoVentaFicticio(DTOReemplazoArticuloLote dtoe): Salida");
            return rs;
    }
    public void guardarRemplazoRegion(DTOReemplazoArticuloLote dtoe) throws MareException{
            UtilidadesLog.info("DAORemplazoPremio.guardarRemplazoRegionZona(DTOReemplazoArticuloLote dtoe): Entrada");
            RecordSet rs = null;
            BelcorpService bs = UtilidadesEJB.getBelcorpService();
                   
            StringBuffer update = new StringBuffer();
                   
            RecordSet rsPK = null;
            StringBuffer query = new StringBuffer();      
            Long id = null;
            
                 update.append(" BEGIN");         
                for(int i = 0; i < dtoe.getOidRegion().size(); i ++){   
             
                 update.append(" INSERT INTO INC_REEMP_REGIO_ZONA ( ");
                 update.append(" OID_REEM_REGI_ZONA, ");
                 update.append(" RARL_OID_REEM_ARTI_LOTE, ");
                 update.append(" ZORG_OID_REGI, ");
                 update.append(" ZZON_OID_ZONA ");
                 update.append(" ) VALUES ( ");
                 update.append("INC_RRZO_SEQ.NEXTVAL, ");
                 update.append( dtoe.getOidReemArtiLote()+ ", ");                      
                 update.append( dtoe.getOidRegion().get(i) + ", ");
                 update.append(" NULL ); " );
                }
                update.append("END; ");
                 
                  
                 
                 
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
                                    
                  
                  
            UtilidadesLog.info("DAORemplazoPremio.guardarRemplazoRegionZona(DTOReemplazoArticuloLote dtoe): Salida");
        
    }
    public void guardarRemplazoZona(DTOReemplazoArticuloLote dtoe) throws MareException{
            UtilidadesLog.info("DAORemplazoPremio.guardarRemplazoZona(DTOReemplazoArticuloLote dtoe): Entrada");
            RecordSet rs = null;
            BelcorpService bs = UtilidadesEJB.getBelcorpService();
                   
            StringBuffer update = new StringBuffer();
                   
            RecordSet rsPK = null;
            StringBuffer query = new StringBuffer();      
            Long id = null;
            
                 update.append(" BEGIN");         
                for(int i = 0; i < dtoe.getOidZona().size(); i ++){   
             
                 update.append(" INSERT INTO INC_REEMP_REGIO_ZONA ( ");
                 update.append(" OID_REEM_REGI_ZONA, ");
                 update.append(" RARL_OID_REEM_ARTI_LOTE, ");
                 update.append(" ZORG_OID_REGI, ");
                 update.append(" ZZON_OID_ZONA ");
                 update.append(" ) VALUES ( ");
                 update.append("INC_RRZO_SEQ.NEXTVAL, ");                 
                 update.append( dtoe.getOidReemArtiLote()+ ", ");                      
                 update.append("  NULL,   " );
                 update.append( dtoe.getOidZona().get(i) + "); ");
                
                }
                update.append(" END;");                        
                        
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
                                    
                  
                  
            UtilidadesLog.info("DAORemplazoPremio.guardarRemplazoZona(DTOReemplazoArticuloLote dtoe): Salida");
        
    }
public DTOSalida bolsaPendiente(DTOReemplazoArticuloLote dtoe) throws MareException{
         UtilidadesLog.info("DAORemplazoPremio.bolsaPendiente(): Entrada");
         StringBuffer query = new StringBuffer();
         query.append(" select  inc_reemp_artic_lote.OID_REEM_ARTI_LOTE OID");
         query.append("         ");
         query.append("        FROM inc_reemp_artic_lote,  ");        
         query.append("             inc_bolsa_falta, ");
         query.append("             mae_produ, ");
         query.append("             inc_reemp_regio_zona, ");
         if(dtoe.getOidRegion() != null){
            query.append("             zon_regio,  ");        
         }
         if(dtoe.getOidZona() != null){
            query.append("             zon_zona, ");
         }
         query.append("             ped_solic_posic ");
         
         query.append("        WHERE inc_reemp_artic_lote.prod_oid_prod = mae_produ.OID_PROD");
         query.append("                AND mae_produ.OID_PROD =   "+ dtoe.getProdOidProd());
         query.append("                AND mae_produ.oid_prod = ped_solic_posic.prod_oid_prod  ");
         query.append("                AND inc_bolsa_falta.sopo_oid_soli_posi = ped_solic_posic.oid_soli_posi ");
         query.append("                AND inc_reemp_artic_lote.ind_acti = 1");
         query.append("                AND inc_bolsa_falta.fec_solu IS NULL  ");
         query.append("                AND inc_reemp_artic_lote.oid_reem_arti_lote = inc_reemp_regio_zona.rarl_oid_reem_arti_lote  ");                  
         StringBuffer sa = new StringBuffer();
         if(dtoe.getOidRegion() != null){
                query.append("                and inc_reemp_regio_zona.ZORG_OID_REGI = zon_regio.OID_REGI ");
                query.append("         and zon_regio.OID_REGI IN(  ");
                for(int i = 0; i < dtoe.getOidRegion().size(); i++){
                    sa.append("," + dtoe.getOidRegion().get(i) );                    
                }
                query.append(sa.toString().substring(1));
                query.append(" ) ");
         }
         
         StringBuffer s = new StringBuffer();
         if(dtoe.getOidZona() != null){
               query.append("                and inc_reemp_regio_zona.ZZON_OID_ZONA = zon_zona.OID_ZONA ");    
               query.append(" and zon_zona.OID_ZONA IN ( ");
                for(int i = 0; i < dtoe.getOidZona().size(); i++){
                    s.append(","+  dtoe.getOidZona().get(i));
                }
                query.append( s.toString().substring(1));
                query.append(" ) ");
         }
         BelcorpService bs = UtilidadesEJB.getBelcorpService();
         RecordSet rs = null;
         try {
               rs = bs.dbService.executeStaticQuery(query.toString());
         } catch (Exception e) {
               UtilidadesLog.error("DAORemplazoPremio.bolsaPendiente(): Exception",e);
               throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS));              
         }         
         UtilidadesLog.debug("DAORemplazoPremio.bolsaPendiente(): Se han obtenido: [" + rs.getRowCount() + "] registro(s)");                      
         DTOSalida dtoSalida = new DTOSalida();
         dtoSalida.setResultado(rs);
         UtilidadesLog.info("DAORemplazoPremio.bolsaPendiente(): Salida");
         return dtoSalida;         
    }
    public void carrarBolsaFaltante(RecordSet rs) throws MareException{
        UtilidadesLog.info("DAORemplazoPremio.cerrarBolsaFaltante(RecordSet rs): Entrada");
        StringBuffer update = new StringBuffer();
        update.append(" BEGIN ");
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        Date date = new Date(System.currentTimeMillis());
        
        for(int i = 0; i< rs.getRowCount(); i ++ ){
            String producto = rs.getValueAt(i, "COD_VENT_FICT").toString() + " - " + rs.getValueAt(i, "COD_SAP").toString();
            update.append(" UPDATE INC_BOLSA_FALTA ");
            update.append(" SET FEC_SOLU = " );
            update.append(" TO_DATE('").append(sdf.format(date)).append("','DD/MM/YYYY') ");
            update.append("   , VAL_OBSE = 'Reemplazo por codigo " + producto + "'");
            update.append(" where OID_BOLS_FALT = "+ ((BigDecimal)rs.getValueAt(i, "OID_BOLS_FALT")).toString() + "; ");
        }
        update.append(" END; ");
        BelcorpService bs = UtilidadesEJB.getBelcorpService();
        RecordSet rs2 = null;
      
        try {
            int cantRegActualizados  = bs.dbService.executeUpdate(update.toString());
        } catch (Exception e) {
              UtilidadesLog.error("DAORemplazoPremio.carrarBolsaFaltante(): Exception",e);
              throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS));              
        }
        
        
         UtilidadesLog.info("DAORemplazoPremio.cerrarBolsaFaltante(RecordSet rs): Salida");
    }
    public RecordSet valoresSolicitud(Boolean inicio, DTOReemplazoArticuloLote dtoe) throws MareException{
            UtilidadesLog.info("DAORemplazoPremio.valoresSolicitud: Entrada");
            
            BelcorpService bs = UtilidadesEJB.getBelcorpService();
            
            // sapaza -- Cambio PER-SiCC-2010-0289  -- 04/05/2010 
            RecordSet rsAux = null;
            StringBuffer queryAux = new StringBuffer();           
            queryAux.append(" SELECT (SELECT OID_OPER FROM BEL_OPERA WHERE COD_OPER='INC020') OID_20, ");
            queryAux.append("        (SELECT OID_OPER FROM BEL_OPERA WHERE COD_OPER='INC030') OID_30, ");
            
            // sapaza -- Cambio PER-SiCC-2011-0274  -- 15/04/2011
            queryAux.append("        (SELECT OID_OPER FROM BEL_OPERA WHERE COD_OPER='INC050') OID_50 ");
            
            queryAux.append(" FROM DUAL ");
            
            try{
                  rsAux = bs.dbService.executeStaticQuery(queryAux.toString());  
            }catch(Exception e){
                UtilidadesLog.error("DAORemplazoPremio.valoresSolicitud(): queryAux Exception",e);
                throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS));              
            }
            String oidINC020 = ((BigDecimal)rsAux.getValueAt(0,"OID_20")).toString();
            String oidINC030 = ((BigDecimal)rsAux.getValueAt(0,"OID_30")).toString();
            
            // sapaza -- Cambio PER-SiCC-2011-0274  -- 15/04/2011
            String oidINC050 = ((BigDecimal)rsAux.getValueAt(0,"OID_50")).toString(); 
            
            StringBuffer query = new StringBuffer();           
            if(inicio.booleanValue()){ 
                RecordSet rsInicio = new RecordSet();                   
                rsInicio.addColumn("CONTADOR");
                Vector vInicio = new Vector();
                vInicio.add("1");
                rsInicio.addRow(vInicio);  
                
                return rsInicio;
            }

            query.append(" SELECT * FROM ( ");
            
            query.append(" SELECT bol.oid_bols_falt, pais.oid_tipo_soli_pais, tiposolic.oid_tipo_soli, ");
            query.append(" cab.ticl_oid_tipo_clie, tipoproce.tpos_oid_tipo_posi, ");
            query.append(" tipoproce.stpo_oid_subt_posi, cab.clie_oid_clie, ");
            query.append(" tiposolic.marc_oid_marc, acceso.cana_oid_cana, acceso.oid_acce, ");
            query.append(" concu.oid_para_gral, concu.num_conc, concu.num_vers, cab.num_prem, ");
            query.append(" artlo.cod_vent_fict, artlo.imp_prec_publ, artlo.num_unid, ");
            query.append(" opera.oid_oper, pos.oid_soli_posi, lote.prod_oid_prod original, artlo.prod_oid_prod reemplazo, produ.cod_sap, ");
            query.append(" bol.num_unid_falt, artlo.ind_acti, ");
            
            // sapaza -- VEN-SiCC-2012-0100 -- 23/08/2012
            query.append(" artlo.oid_reem_arti_lote, ");
            
                query.append(" artlo.num_orde orden_1,  ");
                query.append("   (SELECT MIN (artlo1.num_orde) ");
                query.append("        FROM inc_reemp_artic_lote artlo1, ");
                query.append("                                            inc_artic_lote lote3, ");
                query.append("                                            ped_solic_posic pos1, ");
                query.append("                                            ped_solic_cabec cab1,  ");
                query.append("                                            ped_tipo_solic_pais pais1,  ");
                query.append("                                            ped_tipo_solic tiposolic1,  ");
                query.append("                                            ped_tipo_solic_proce tipoproce1,   ");
                query.append("                                            bel_opera opera1,  ");
                query.append("                                            (SELECT *  ");
                query.append("                                               FROM inc_bolsa_falta  ");
                query.append("                                               WHERE fec_solu IS NULL) bol1,  ");
                query.append("                                            seg_acces acceso1,   ");
                query.append("                                            inc_concu_param_gener concu1,   ");
                query.append("                                            mae_produ produ1,  ");
                query.append("                                            inc_reemp_regio_zona rerezo1 ");
                query.append("                                            WHERE artlo1.arlo_oid_arti_lote = lote3.oid_arti_lote   ");
                query.append("                                              AND pos1.prod_oid_prod = lote3.prod_oid_prod ");
                query.append("                                              AND bol1.sopo_oid_soli_posi = pos1.oid_soli_posi     ");
                query.append("                                              AND pos1.soca_oid_soli_cabe = cab1.oid_soli_cabe  ");
                query.append("                                              AND cab1.tspa_oid_tipo_soli_pais = pais1.oid_tipo_soli_pais  ");
                query.append("                                              AND pais1.tsol_oid_tipo_soli = tiposolic1.oid_tipo_soli ");
                query.append("                                              AND tipoproce1.tspa_oid_tipo_soli_pais =  pais1.oid_tipo_soli_pais ");
                query.append("                                              AND tipoproce1.oper_oid_oper = opera1.oid_oper ");
                query.append("                                              AND opera1.oid_oper in (" + oidINC020 + ", " + oidINC030 + ", " + oidINC050 +  ") ");
                query.append("                                              AND tiposolic1.acce_oid_acce = acceso1.oid_acce    ");
                query.append("                                              AND cab1.copa_oid_para_gene = concu1.oid_para_gral   ");
                query.append("                                              AND concu1.oid_para_gral =  " + dtoe.getOidConcurso());
                query.append("                                              AND artlo1.prod_oid_prod = produ1.oid_prod    ");                    
                query.append("                                              AND lote3.oid_arti_lote = lote.oid_arti_lote    ");
                query.append("                                              AND rerezo1.rarl_oid_reem_arti_lote = artlo1.oid_reem_arti_lote                                   ");
                query.append("                                              AND ((SELECT COUNT (*)   ");
                query.append("                                                      FROM zon_zona zon  ");
                query.append("                                                     WHERE  zon.oid_zona = cab.zzon_oid_zona   ");
                query.append("                                                       AND zon.oid_zona = NVL (rerezo1.zzon_oid_zona, zon.oid_zona)  ");
                query.append("                                                       AND zon.zorg_oid_regi = NVL (rerezo1.zorg_oid_regi, zon.zorg_oid_regi)) >= 1  ");
                query.append("    ))  orden_2");
            
            query.append(" FROM inc_reemp_artic_lote artlo, ");
            query.append(" inc_artic_lote lote, ");
            query.append(" ped_solic_posic pos, ");
            query.append(" ped_solic_cabec cab, ");
            query.append(" ped_tipo_solic_pais pais, ");
            query.append(" ped_tipo_solic tiposolic, ");
            query.append(" ped_tipo_solic_proce tipoproce, ");
            query.append(" bel_opera opera, ");
            query.append(" (select * from inc_bolsa_falta where fec_solu IS NULL) bol, ");
            query.append(" seg_acces acceso, ");
            query.append(" inc_concu_param_gener concu, ");
            query.append(" mae_produ produ, ");
            query.append(" inc_reemp_regio_zona rerezo ");
            query.append(" WHERE artlo.arlo_oid_arti_lote = lote.oid_arti_lote ");
            query.append(" AND pos.prod_oid_prod = lote.prod_oid_prod ");
            
            // sapaza -- Cambio PER-SiCC-2010-0306  -- 12/05/2010 
            query.append("  AND pos.val_codi_vent_fict = lote.cod_vent_fict ");
            
            query.append(" AND bol.sopo_oid_soli_posi = pos.oid_soli_posi ");
            query.append(" AND artlo.ind_acti = 1 ");
            query.append(" AND pos.soca_oid_soli_cabe = cab.oid_soli_cabe ");
            query.append(" AND cab.tspa_oid_tipo_soli_pais = pais.oid_tipo_soli_pais ");
            query.append(" AND pais.tsol_oid_tipo_soli = tiposolic.oid_tipo_soli ");
            query.append(" AND tipoproce.tspa_oid_tipo_soli_pais = pais.oid_tipo_soli_pais ");
            query.append(" AND tipoproce.oper_oid_oper = opera.oid_oper ");
            
            // sapaza -- Cambio PER-SiCC-2010-0289  -- 04/05/2010 
            query.append(" AND opera.oid_oper in (" + oidINC020 + ", " + oidINC030 + ", " + oidINC050 +  ") ");
            
            query.append(" AND tiposolic.acce_oid_acce = acceso.oid_acce ");
            query.append(" AND cab.copa_oid_para_gene = concu.oid_para_gral ");
            query.append(" AND concu.oid_para_gral =  " + dtoe.getOidConcurso());
            query.append(" AND artlo.prod_oid_prod = produ.oid_prod ");
            /*query.append(" AND artlo.num_orde =  ");
                    query.append("   (SELECT MIN (artlo1.num_orde) ");
                    query.append("        FROM inc_reemp_artic_lote artlo1, ");
                    query.append("                                            inc_artic_lote lote3, ");
                    query.append("                                            ped_solic_posic pos1, ");
                    query.append("                                            ped_solic_cabec cab1,  ");
                    query.append("                                            ped_tipo_solic_pais pais1,  ");
                    query.append("                                            ped_tipo_solic tiposolic1,  ");
                    query.append("                                            ped_tipo_solic_proce tipoproce1,   ");
                    query.append("                                            bel_opera opera1,  ");
                    query.append("                                            (SELECT *  ");
                    query.append("                                               FROM inc_bolsa_falta  ");
                    query.append("                                               WHERE fec_solu IS NULL) bol1,  ");
                    query.append("                                            seg_acces acceso1,   ");
                    query.append("                                            inc_concu_param_gener concu1,   ");
                    query.append("                                            mae_produ produ1,  ");
                    query.append("                                            inc_reemp_regio_zona rerezo1 ");
                    
                    query.append("                                            WHERE artlo1.arlo_oid_arti_lote = lote3.oid_arti_lote   ");
                    query.append("                                                   AND pos1.prod_oid_prod = lote3.prod_oid_prod ");
                    query.append("                                                   AND bol1.sopo_oid_soli_posi = pos1.oid_soli_posi     ");
                    query.append("                                                   AND pos1.soca_oid_soli_cabe = cab1.oid_soli_cabe  ");
                    query.append("                                                   AND cab1.tspa_oid_tipo_soli_pais = pais1.oid_tipo_soli_pais  ");
                    query.append("                                                   AND pais1.tsol_oid_tipo_soli = tiposolic1.oid_tipo_soli ");
                    query.append("                                                   AND tipoproce1.tspa_oid_tipo_soli_pais =  pais1.oid_tipo_soli_pais ");
                    query.append("                                                   AND tipoproce1.oper_oid_oper = opera1.oid_oper ");

                    // sapaza -- Cambio PER-SiCC-2010-0289  -- 04/05/2010 
                    query.append("                                                   AND opera1.oid_oper in (" + oidINC020 + ", " + oidINC030 + ", " + oidINC050 +  ") ");
                    
                    query.append("                                                   AND tiposolic1.acce_oid_acce = acceso1.oid_acce    ");
                    query.append("                                                   AND cab1.copa_oid_para_gene = concu1.oid_para_gral   ");
                    query.append("                                                   AND concu1.oid_para_gral =  " + dtoe.getOidConcurso());
                    query.append("                                                   AND artlo1.prod_oid_prod = produ1.oid_prod    ");                    
        
        // sapaza -- Cambio PER-SiCC-2010-0306  -- 12/05/2010                 
        query.append("                                                                 AND lote3.oid_arti_lote = lote.oid_arti_lote    ");                
        
        query.append("                                                               AND rerezo1.rarl_oid_reem_arti_lote = artlo1.oid_reem_arti_lote                                   ");
        query.append("                                                               AND ((SELECT COUNT (*)   ");
        query.append("                                                                            FROM zon_zona zon  ");
          query.append("                                                                             WHERE  zon.oid_zona = cab.zzon_oid_zona   ");  
        query.append("                                                                            AND zon.oid_zona = NVL (rerezo1.zzon_oid_zona, zon.oid_zona)  ");
        query.append("                                                                            AND zon.zorg_oid_regi = NVL (rerezo1.zorg_oid_regi, zon.zorg_oid_regi)) >= 1  ");
        query.append("                                                                             ))  ");*/
            
            query.append(" AND rerezo.rarl_oid_reem_arti_lote = artlo.oid_reem_arti_lote ");
            query.append(" AND (( ");
            query.append("        SELECT count(*)   ");
            query.append("            FROM zon_zona zon "); // si
            query.append("                   WHERE zon.oid_zona = cab.zzon_oid_zona  ");
            query.append("                       AND zon.oid_zona = NVL (rerezo.zzon_oid_zona, zon.oid_zona) ");// si
            query.append("                       AND zon.zorg_oid_regi = NVL (rerezo.zorg_oid_regi,zon.zorg_oid_regi)   "); // si
            query.append("    ) >= 1 ) ");
            
            query.append(" UNION ");            
            
            query.append(" SELECT bol.oid_bols_falt, pais.oid_tipo_soli_pais, tiposolic.oid_tipo_soli, ");
            query.append(" cab.ticl_oid_tipo_clie, tipoproce.tpos_oid_tipo_posi, ");
            query.append(" tipoproce.stpo_oid_subt_posi, cab.clie_oid_clie, ");
            query.append(" tiposolic.marc_oid_marc, acceso.cana_oid_cana, acceso.oid_acce, ");
            query.append(" concu.oid_para_gral, concu.num_conc, concu.num_vers, cab.num_prem, ");
            query.append(" artlo.cod_vent_fict, artlo.imp_prec_publ, artlo.num_unid, ");
            query.append(" opera.oid_oper, pos.oid_soli_posi, lote.prod_oid_prod original, artlo.prod_oid_prod reemplazo, produ.cod_sap, ");
            query.append(" bol.num_unid_falt, artlo.ind_acti, ");
            
            // sapaza -- VEN-SiCC-2012-0100 -- 23/08/2012
            query.append(" artlo.oid_reem_arti_lote, ");
        
            query.append(" artlo.num_orde orden_1, ");
            query.append("   (SELECT MIN (artlo1.num_orde) ");
            query.append("        FROM inc_reemp_artic_lote artlo1, ");
            query.append("                                            inc_artic_lote lote3, ");
            query.append("                                            ped_solic_posic pos1, ");
            query.append("                                            ped_solic_cabec cab1,  ");
            query.append("                                            ped_tipo_solic_pais pais1,  ");
            query.append("                                            ped_tipo_solic tiposolic1,  ");
            query.append("                                            ped_tipo_solic_proce tipoproce1,   ");
            query.append("                                            bel_opera opera1,  ");
            query.append("                                            (SELECT *  ");
            query.append("                                               FROM inc_bolsa_falta  ");
            query.append("                                               WHERE fec_solu IS NULL) bol1,  ");
            query.append("                                            seg_acces acceso1,   ");
            query.append("                                            inc_concu_param_gener concu1,   ");
            query.append("                                            mae_produ produ1  ");
            query.append("                                            WHERE artlo1.arlo_oid_arti_lote = lote3.oid_arti_lote   ");
            query.append("                                              AND pos1.prod_oid_prod = lote3.prod_oid_prod ");
            query.append("                                              AND bol1.sopo_oid_soli_posi = pos1.oid_soli_posi     ");
            query.append("                                              AND pos1.soca_oid_soli_cabe = cab1.oid_soli_cabe  ");
            query.append("                                              AND cab1.tspa_oid_tipo_soli_pais = pais1.oid_tipo_soli_pais  ");
            query.append("                                              AND pais1.tsol_oid_tipo_soli = tiposolic1.oid_tipo_soli ");
            query.append("                                              AND tipoproce1.tspa_oid_tipo_soli_pais = pais1.oid_tipo_soli_pais ");
            query.append("                                              AND tipoproce1.oper_oid_oper = opera1.oid_oper ");
            query.append("                                              AND opera1.oid_oper in (" + oidINC020 + ", " + oidINC030 + ", " + oidINC050 +  ") ");
            query.append("                                              AND tiposolic1.acce_oid_acce = acceso1.oid_acce    ");
            query.append("                                              AND cab1.copa_oid_para_gene = concu1.oid_para_gral   ");
            query.append("                                              AND concu1.oid_para_gral =  " + dtoe.getOidConcurso());
            query.append("                                              AND artlo1.prod_oid_prod = produ1.oid_prod    ");
            query.append("                                              AND lote3.oid_arti_lote = lote.oid_arti_lote    ");                
            query.append("   ) orden_2 ");

            
            query.append(" FROM inc_reemp_artic_lote artlo, ");
            query.append(" inc_artic_lote lote, ");
            query.append(" ped_solic_posic pos, ");
            query.append(" ped_solic_cabec cab, ");
            query.append(" ped_tipo_solic_pais pais, ");
            query.append(" ped_tipo_solic tiposolic, ");
            query.append(" ped_tipo_solic_proce tipoproce, ");
            query.append(" bel_opera opera, ");
            query.append("  (select * from inc_bolsa_falta where fec_solu IS NULL) bol, ");
            query.append(" seg_acces acceso, ");
            query.append(" inc_concu_param_gener concu, ");
            query.append(" mae_produ produ ");
            query.append(" WHERE artlo.arlo_oid_arti_lote = lote.oid_arti_lote ");
            query.append(" AND pos.prod_oid_prod = lote.prod_oid_prod ");
            
            // sapaza -- Cambio PER-SiCC-2010-0306  -- 12/05/2010 
            query.append("  AND pos.val_codi_vent_fict = lote.cod_vent_fict ");

            query.append(" AND bol.sopo_oid_soli_posi = pos.oid_soli_posi ");
            query.append(" AND artlo.ind_acti = 1 ");
            query.append(" AND pos.soca_oid_soli_cabe = cab.oid_soli_cabe ");
            query.append(" AND cab.tspa_oid_tipo_soli_pais = pais.oid_tipo_soli_pais ");
            query.append(" AND pais.tsol_oid_tipo_soli = tiposolic.oid_tipo_soli ");
            query.append(" AND tipoproce.tspa_oid_tipo_soli_pais = pais.oid_tipo_soli_pais ");
            query.append(" AND tipoproce.oper_oid_oper = opera.oid_oper ");

            // sapaza -- Cambio PER-SiCC-2010-0289  -- 04/05/2010 
            query.append(" AND opera.oid_oper in (" + oidINC020 + ", " + oidINC030 + ", " + oidINC050 +  ") ");
            
            query.append(" AND tiposolic.acce_oid_acce = acceso.oid_acce ");
            query.append(" AND cab.copa_oid_para_gene = concu.oid_para_gral ");
            query.append(" AND concu.oid_para_gral = " + dtoe.getOidConcurso());
            query.append(" AND artlo.prod_oid_prod = produ.oid_prod ");
            /*query.append(" AND artlo.num_orde =  ");
                                             query.append("   (SELECT MIN (artlo1.num_orde) ");
                                              query.append("        FROM inc_reemp_artic_lote artlo1, ");
                query.append("                                            inc_artic_lote lote3, ");
                query.append("                                            ped_solic_posic pos1, ");
                query.append("                                            ped_solic_cabec cab1,  ");
                query.append("                                            ped_tipo_solic_pais pais1,  ");
                query.append("                                            ped_tipo_solic tiposolic1,  ");
                query.append("                                            ped_tipo_solic_proce tipoproce1,   ");
                query.append("                                            bel_opera opera1,  ");
                query.append("                                            (SELECT *  ");
                query.append("                                               FROM inc_bolsa_falta  ");
                query.append("                                               WHERE fec_solu IS NULL) bol1,  ");
                query.append("                                            seg_acces acceso1,   ");
                query.append("                                            inc_concu_param_gener concu1,   ");
                query.append("                                            mae_produ produ1  ");
                
                query.append("                                            WHERE artlo1.arlo_oid_arti_lote = lote3.oid_arti_lote   ");
                query.append("                                                   AND pos1.prod_oid_prod = lote3.prod_oid_prod ");
                query.append("                                                   AND bol1.sopo_oid_soli_posi = pos1.oid_soli_posi     ");
                query.append("                                                   AND pos1.soca_oid_soli_cabe = cab1.oid_soli_cabe  ");
                query.append("                                                   AND cab1.tspa_oid_tipo_soli_pais = pais1.oid_tipo_soli_pais  ");
                query.append("                                                   AND pais1.tsol_oid_tipo_soli = tiposolic1.oid_tipo_soli ");
                query.append("                                                   AND tipoproce1.tspa_oid_tipo_soli_pais = pais1.oid_tipo_soli_pais ");
                query.append("                                                   AND tipoproce1.oper_oid_oper = opera1.oid_oper ");
                
                // sapaza -- Cambio PER-SiCC-2010-0289  -- 04/05/2010 
                query.append("                                                   AND opera1.oid_oper in (" + oidINC020 + ", " + oidINC030 + ", " + oidINC050 +  ") ");
                
                query.append("                                                   AND tiposolic1.acce_oid_acce = acceso1.oid_acce    ");
                query.append("                                                   AND cab1.copa_oid_para_gene = concu1.oid_para_gral   ");
                query.append("                                                   AND concu1.oid_para_gral =  " + dtoe.getOidConcurso());
                query.append("                                                   AND artlo1.prod_oid_prod = produ1.oid_prod    ");
                query.append("                                                                                                  ");
                
                // sapaza -- Cambio PER-SiCC-2010-0306  -- 12/05/2010             
                query.append("                                                                 AND lote3.oid_arti_lote = lote.oid_arti_lote    ");                
                query.append("                                                       ) ");*/
        
            query.append(" AND NOT EXISTS (SELECT 1   ");
            query.append(" FROM inc_reemp_regio_zona reemrz   ");
            query.append(" where reemrz.RARL_OID_REEM_ARTI_LOTE = artlo.OID_REEM_ARTI_LOTE)   ");
            
            query.append(") WHERE orden_1 = orden_2 ");
            
            RecordSet rs = null;
            
            try{
                  rs = bs.dbService.executeStaticQuery(query.toString());  
            }catch(Exception e){
                UtilidadesLog.error("DAORemplazoPremio.valoresSolicitud(): Exception",e);
                throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS));              
            }
         
                 return rs;
         
    
    }
    public DTOSalida recuperaDatosFaltantes(DTOReemplazoArticuloLote dtoe) throws MareException{
        UtilidadesLog.info("DAORemplazoPremio.recuperaDatosFaltantes(DTOReemplazoArticuloLote dtoe): Entrada");
        StringBuffer query = new StringBuffer();
        query.append("  select inc_reemp_artic_lote.oid_reem_arti_lote OID, ");
        query.append("  inc_reemp_artic_lote.IND_CENT_DIST_GARA, ");
        query.append("  inc_reemp_artic_lote.CESE_OID_CESE_GARA,   ");
        query.append("  inc_reemp_artic_lote.NUM_MESE_GARA,  ");
        query.append("  inc_reemp_artic_lote.VAL_OBSE_CENT_DIST,  ");
        query.append("  inc_reemp_artic_lote.IMP_PREC_PUBL, ");
        query.append("  inc_reemp_artic_lote.IND_DESP, ");
        query.append("  inc_reemp_artic_lote.IND_TIPO_ENTR_PREM,  ");
        query.append("  inc_reemp_artic_lote.CESE_OID_CESE_ENTR, ");
        query.append("  inc_reemp_artic_lote.IND_COMU, ");
        query.append("  INC_LOTE_PREMI_ARTIC.NUM_PREM,  ");        
        query.append("  mae_produ.COD_SAP,  ");
        query.append("  v_gen_i18n_sicc.VAL_I18N,  ");
        query.append("  INC_REEMP_REGIO_ZONA.ZORG_OID_REGI,  ");
        query.append("  INC_REEMP_REGIO_ZONA.ZZON_OID_ZONA,  ");
        query.append("  inc_reemp_artic_lote.ARLO_OID_ARTI_LOTE ");
        query.append("   from inc_reemp_artic_lote, ");
        query.append("        INC_REEMP_REGIO_ZONA,   ");
        query.append("        INC_LOTE_PREMI_ARTIC, ");
        query.append("        inc_artic_lote, ");
        query.append("        mae_produ,  ");
        query.append("        v_gen_i18n_sicc  ");
        query.append("        where inc_reemp_regio_zona.RARL_OID_REEM_ARTI_LOTE (+)= inc_reemp_artic_lote.OID_REEM_ARTI_LOTE    ");
        query.append("              and   inc_reemp_artic_lote.OID_REEM_ARTI_LOTE =  " + dtoe.getOidReemArtiLote());
        query.append("              and inc_reemp_artic_lote.ARLO_OID_ARTI_LOTE = inc_artic_lote.OID_ARTI_LOTE       ");
        query.append("              and inc_artic_lote.LOPA_OID_LOTE_PREM_ARTI = INC_LOTE_PREMI_ARTIC.OID_LOTE_PREM_ARTI   ");
        query.append("              and inc_artic_lote.PROD_OID_PROD = mae_produ.OID_PROD  ");
        query.append("              and v_gen_i18n_sicc.ATTR_NUM_ATRI = 1     ");
        query.append("              and v_gen_i18n_sicc.IDIO_OID_IDIO = 1   ");
        query.append("              and v_gen_i18n_sicc.ATTR_ENTI = 'MAE_PRODU' ");
        query.append("              and v_gen_i18n_sicc.VAL_OID = mae_produ.OID_PROD     ");
        
        
        
        
        BelcorpService bs = UtilidadesEJB.getBelcorpService();
        
        RecordSet rs = null;
        
        try{
              rs = bs.dbService.executeStaticQuery(query.toString());  
        }catch(Exception e){
            UtilidadesLog.error("DAORemplazoPremio.valoresSolicitud(): Exception",e);
            throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS));              
        }
        DTOSalida dtoSalida = new DTOSalida();
        dtoSalida.setResultado(rs);
        UtilidadesLog.info("DAORemplazoPremio.recuperaDatosFaltantes(DTOReemplazoArticuloLote dtoe): Salida");
        return dtoSalida;
    }
    public void actualizaRegion(DTOReemplazoArticuloLote dtoe)throws MareException{
        UtilidadesLog.info("DAOReemplazoPremio.actualizarRegion(DTOReemplazoArticuloLote dtoe): Entrada");
        StringBuffer update = new StringBuffer();     
        StringBuffer remove = new StringBuffer();
        BelcorpService bs = UtilidadesEJB.getBelcorpService();
        remove.append("DELETE INC_REEMP_REGIO_ZONA ");
        remove.append(" WHERE RARL_OID_REEM_ARTI_LOTE = " + dtoe.getOidReemArtiLote() );
        try{
            int cantidad = bs.dbService.executeUpdate(remove.toString());
        }catch(Exception e){
            e.printStackTrace();
            if(e.toString().indexOf("ORA-00001")!= -1) {
                     throw new MareException(e, UtilidadesError.armarCodigoError(
                                         CodigosError.ERROR_DE_CLAVE_DUPLICADA));
             } else {
                     throw new MareException(e, UtilidadesError.armarCodigoError(
                                         CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS));
              }
        }
        
        update.append(" BEGIN");         
        for(int i = 0; i < dtoe.getOidRegion().size(); i ++){
            if(!dtoe.getOidRegion().get(i).equals("")){
                update.append(" INSERT INTO INC_REEMP_REGIO_ZONA ( ");
                update.append(" OID_REEM_REGI_ZONA, ");
                update.append(" RARL_OID_REEM_ARTI_LOTE, ");
                update.append(" ZORG_OID_REGI, ");
                update.append(" ZZON_OID_ZONA ");
                update.append(" ) VALUES ( ");
                update.append("INC_RRZO_SEQ.NEXTVAL, ");
                update.append( dtoe.getOidReemArtiLote()+ ", ");      
                update.append( dtoe.getOidRegion().get(i) + ", ");                            
                update.append(" NULL ); " );
            }
        }
        update.append("END; ");
                              
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
                          
        UtilidadesLog.info("DAOReemplazoPremio.actualizarRegion(DTOReemplazoArticuloLote dtoe): Salida");
    }
    public void actualizarZonas(DTOReemplazoArticuloLote dtoe)throws MareException{
        UtilidadesLog.info("DAOReemplazoPremio.actualizarZona(DTOReemplazoArticuloLote dtoe): Entrada");
        StringBuffer update = new StringBuffer();     
        StringBuffer remove = new StringBuffer();
        BelcorpService bs = UtilidadesEJB.getBelcorpService();
        remove.append("DELETE INC_REEMP_REGIO_ZONA ");
        remove.append(" WHERE RARL_OID_REEM_ARTI_LOTE = " + dtoe.getOidReemArtiLote() );
        try{
            int cantidad = bs.dbService.executeUpdate(remove.toString());
        }catch(Exception e){
            e.printStackTrace();
            if(e.toString().indexOf("ORA-00001")!= -1) {
                     throw new MareException(e, UtilidadesError.armarCodigoError(
                                         CodigosError.ERROR_DE_CLAVE_DUPLICADA));
             } else {
                     throw new MareException(e, UtilidadesError.armarCodigoError(
                                         CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS));
              }
        }        
        update.append(" BEGIN");         
        for(int i = 0; i < dtoe.getOidZona().size(); i ++){
            if(!dtoe.getOidZona().get(i).equals("")){
                    update.append(" INSERT INTO INC_REEMP_REGIO_ZONA ( ");
                    update.append(" OID_REEM_REGI_ZONA, ");
                    update.append(" RARL_OID_REEM_ARTI_LOTE, ");
                    update.append(" ZORG_OID_REGI, ");
                    update.append(" ZZON_OID_ZONA ");
                    update.append(" ) VALUES ( ");
                    update.append("INC_RRZO_SEQ.NEXTVAL, "); 
                    update.append( dtoe.getOidReemArtiLote()+ ", ");                      
                    update.append("  NULL,   " );
                    update.append( dtoe.getOidZona().get(i) + "); ");
                   
            }      
        
        }
        update.append(" END;");                 
                
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
        UtilidadesLog.info("DAOReemplazoPremio.actualizarZona(DTOReemplazoArticuloLote dtoe): Salida");
    }
    public void eliminarRegionZona(ArrayList oids) throws MareException{
        UtilidadesLog.info("DAOReemplazoPremio.EliminarRegionZona(DTOReemplazoArticuloLote dtoe): Entrada");
        RecordSet rs = null;
        BelcorpService bs = UtilidadesEJB.getBelcorpService();
        StringBuffer update = new StringBuffer();
        StringBuffer updateInter = new StringBuffer();
        DTOReemplazoArticuloLote dtoe = new DTOReemplazoArticuloLote();
        int cantidad = oids.size();
        String oidReemplazoArticuloLote="";
        for(int i= 0; i < cantidad; i++){
            dtoe.setOidReemArtiLote(Long.valueOf(oids.get(i).toString()));
            oidReemplazoArticuloLote = oidReemplazoArticuloLote + "," + dtoe.getOidReemArtiLote(); 
        }
        
        update.append("delete from INC_REEMP_REGIO_ZONA ");
        update.append("where RARL_OID_REEM_ARTI_LOTE in (" + oidReemplazoArticuloLote.substring(1)+ ")");

         try {
                       int cantRegActualizados = bs.dbService.executeUpdate(update.toString());
         
                       
         }catch(Exception ex){
                       ex.printStackTrace();
                       
                        if(ex.toString().indexOf("ORA-02292")!= -1) {
                           throw new MareException(ex, UtilidadesError.armarCodigoError(
                                               CodigosError.ERROR_DE_BORRADO_DE_DATOS));
                        } else {
                           throw new MareException(ex, UtilidadesError.armarCodigoError(
                                               CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS));
                        }            
        }        
        UtilidadesLog.info("DAOReemplazoPremio.EliminarRegionZona(DTOReemplazoArticuloLote dtoe): Salida");
    }
    public DTOSalida obtenerProducto(DTOEBuscarProductos dtoe) throws MareException{
            UtilidadesLog.info("DAOReemplazoPremio.obtenerProducto(DTOEBuscarProductos dtoe): Entrada");
             RecordSet rs = new RecordSet();
             StringBuffer query = new StringBuffer();
              
             BelcorpService bs;
             DTOSalida dtoSalida = new DTOSalida();               
               try{
                   bs = BelcorpService.getInstance();
               
               } catch(Exception e ){                       
                   throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_PEDIR_UN_SERVICIO_MARE));
               }
               
                query.append(" SELECT  MAE_PRODU.OID_PROD, I18N.VAL_I18N DES_CORT ");
                query.append("       FROM GEN_I18N_SICC I18N, MAE_PRODU  ");
                query.append("            WHERE I18N.ATTR_ENTI = 'MAE_PRODU' ");
                query.append("                  AND I18N.IDIO_OID_IDIO = 1  ");
                query.append("                  AND I18N.ATTR_NUM_ATRI = 1 ");
                query.append("                  AND I18N.VAL_OID = MAE_PRODU.OID_PROD ");
                query.append("                  AND MAE_PRODU.COD_SAP =  '" + dtoe.getCodSAP() + "'");
               
               try{
                   rs = bs.dbService.executeStaticQuery(query.toString());
                  
               } catch (Exception ex) {
                  
                     throw new MareException(ex, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS));
               }
                if( !rs.esVacio() )
                   {
                       dtoSalida.setResultado(rs);       
                       UtilidadesLog.info("DAOReemplazoPremio.obtenerProducto(DTOEBuscarProductos dtoe): salida");
                       return dtoSalida;                
                   }else
                   {
                      throw new MareException(null, null, UtilidadesError.armarCodigoError(ConstantesSEG.MODULO_INT + ErroresDeNegocio.REC_0010));
                   }
             
           
           
    }
    public RecordSet obtenerZona(DTOReemplazoArticuloLote dtoe)throws MareException{
        UtilidadesLog.info("DAOReemplazoPremio.obtenerZona(DTOReemplazoArticuloLote dtoe): Entrada");
        StringBuffer query = new StringBuffer();
        query.append(" select INC_REEMP_REGIO_ZONA.ZZON_OID_ZONA ");
        query.append("  from INC_REEMP_REGIO_ZONA ");
        query.append("   where INC_REEMP_REGIO_ZONA.RARL_OID_REEM_ARTI_LOTE =  " + dtoe.getOidReemArtiLote());
       
        BelcorpService bs = UtilidadesEJB.getBelcorpService();
        
        RecordSet rs = null;
        
        try{
              rs = bs.dbService.executeStaticQuery(query.toString());  
        }catch(Exception e){
            UtilidadesLog.error("DAORemplazoPremio.valoresSolicitud(): Exception",e);
            throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS));              
        }
        UtilidadesLog.info("DAOReemplazoPremio.obtenerZona(DTOReemplazoArticuloLote dtoe): salida");
        return rs;
        
    }
    public void eliminarZonaRegion(DTOReemplazoArticuloLote dtoe) throws MareException{
        StringBuffer remove = new StringBuffer();
        BelcorpService bs = UtilidadesEJB.getBelcorpService();
        remove.append("DELETE INC_REEMP_REGIO_ZONA ");
        remove.append(" WHERE RARL_OID_REEM_ARTI_LOTE = " + dtoe.getOidReemArtiLote() );
        try{
            int cantidad = bs.dbService.executeUpdate(remove.toString());
        }catch(Exception e){
            e.printStackTrace();
            if(e.toString().indexOf("ORA-00001")!= -1) {
                     throw new MareException(e, UtilidadesError.armarCodigoError(
                                         CodigosError.ERROR_DE_CLAVE_DUPLICADA));
             } else {
                     throw new MareException(e, UtilidadesError.armarCodigoError(
                                         CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS));
              }
        }        
        
    }
    public RecordSet obtenerRegion(DTOReemplazoArticuloLote dtoe) throws MareException{
        UtilidadesLog.info("DAOReemplazoPremio.obtenerZona(DTOReemplazoArticuloLote dtoe): Entrada");
        StringBuffer query = new StringBuffer();
        query.append(" select INC_REEMP_REGIO_ZONA.ZORG_OID_REGI  ");
        query.append("  from INC_REEMP_REGIO_ZONA ");
        query.append("        where INC_REEMP_REGIO_ZONA.RARL_OID_REEM_ARTI_LOTE =  " + dtoe.getOidReemArtiLote());
        
        BelcorpService bs = UtilidadesEJB.getBelcorpService();
        
        RecordSet rs = null;
        
        try{
              rs = bs.dbService.executeStaticQuery(query.toString());  
        }catch(Exception e){
            UtilidadesLog.error("DAORemplazoPremio.valoresSolicitud(): Exception",e);
            throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS));              
        }
        UtilidadesLog.info("DAOReemplazoPremio.obtenerZona(DTOReemplazoArticuloLote dtoe): salida");
        return rs;
    }
    
    public RecordSet valoresSolicitudModificar(Boolean inicio, DTOReemplazoArticuloLote dtoe) throws MareException{
            UtilidadesLog.info("DAORemplazoPremio.valoresSolicitud: Entrada");
            
            BelcorpService bs = UtilidadesEJB.getBelcorpService();
            
            // sapaza -- Cambio PER-SiCC-2010-0289  -- 04/05/2010 
            RecordSet rsAux = null;
            StringBuffer queryAux = new StringBuffer();           
            queryAux.append(" SELECT (SELECT OID_OPER FROM BEL_OPERA WHERE COD_OPER='INC020') OID_20, ");
            queryAux.append("        (SELECT OID_OPER FROM BEL_OPERA WHERE COD_OPER='INC030') OID_30, ");
            
            // sapaza -- Cambio PER-SiCC-2011-0274  -- 15/04/2011
            queryAux.append("        (SELECT OID_OPER FROM BEL_OPERA WHERE COD_OPER='INC050') OID_50 ");
            
            queryAux.append(" FROM DUAL ");
            
            try{
                  rsAux = bs.dbService.executeStaticQuery(queryAux.toString());  
            }catch(Exception e){
                UtilidadesLog.error("DAORemplazoPremio.valoresSolicitud(): queryAux Exception",e);
                throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS));              
            }
            String oidINC020 = ((BigDecimal)rsAux.getValueAt(0,"OID_20")).toString();
            String oidINC030 = ((BigDecimal)rsAux.getValueAt(0,"OID_30")).toString();
            
            // sapaza -- Cambio PER-SiCC-2011-0274  -- 15/04/2011
            String oidINC050 = ((BigDecimal)rsAux.getValueAt(0,"OID_50")).toString();
        
            StringBuffer query = new StringBuffer();           
            if(inicio.booleanValue()){ 
                RecordSet rsInicio = new RecordSet();                   
                rsInicio.addColumn("CONTADOR");
                Vector vInicio = new Vector();
                vInicio.add("1");
                rsInicio.addRow(vInicio);  
                
                return rsInicio;
            }
            
            query.append(" SELECT * FROM ( ");
        
            query.append(" SELECT bol.oid_bols_falt, pais.oid_tipo_soli_pais, tiposolic.oid_tipo_soli, ");
            query.append(" cab.ticl_oid_tipo_clie, tipoproce.tpos_oid_tipo_posi, ");
            query.append(" tipoproce.stpo_oid_subt_posi, cab.clie_oid_clie, ");
            query.append(" tiposolic.marc_oid_marc, acceso.cana_oid_cana, acceso.oid_acce, ");
            query.append(" concu.oid_para_gral, concu.num_conc, concu.num_vers, cab.num_prem, ");
            query.append(" lote.cod_vent_fict, artlo.imp_prec_publ, artlo.num_unid, ");
            query.append(" opera.oid_oper, pos.oid_soli_posi, artlo.prod_oid_prod reemplazo, produ.cod_sap, ");
            query.append(" bol.num_unid_falt, artlo.ind_acti, lote.prod_oid_prod original, ");
            
            query.append(" artlo.num_orde orden_1, ");
            query.append("   (SELECT MIN (artlo1.num_orde) ");
            query.append("        FROM inc_reemp_artic_lote artlo1, ");
            query.append("                                            ped_solic_posic pos1, ");
            query.append("                                            ped_solic_cabec cab1,  ");
            query.append("                                            ped_tipo_solic_pais pais1,  ");
            query.append("                                            ped_tipo_solic tiposolic1,  ");
            query.append("                                            ped_tipo_solic_proce tipoproce1,   ");
            query.append("                                            bel_opera opera1,  ");
            query.append("                                            (SELECT *  ");
            query.append("                                               FROM inc_bolsa_falta  ");
            query.append("                                               WHERE fec_solu IS NULL) bol1,  ");
            query.append("                                            seg_acces acceso1,   ");
            query.append("                                            inc_concu_param_gener concu1,   ");
            query.append("                                            mae_produ produ1,  ");
            query.append("                                            inc_reemp_regio_zona rerezo1 ");
            query.append("                                            WHERE   artlo1.ind_acti = 0  ");
            query.append("                                                   AND pos1.prod_oid_prod = artlo1.prod_oid_prod ");
            query.append("                                                   AND bol1.sopo_oid_soli_posi = pos1.oid_soli_posi     ");
            query.append("                                                   AND pos1.soca_oid_soli_cabe = cab1.oid_soli_cabe  ");
            query.append("                                                   AND cab1.tspa_oid_tipo_soli_pais = pais1.oid_tipo_soli_pais  ");
            query.append("                                                   AND pais1.tsol_oid_tipo_soli = tiposolic1.oid_tipo_soli ");
            query.append("                                                   AND tipoproce1.tspa_oid_tipo_soli_pais =  pais1.oid_tipo_soli_pais ");
            query.append("                                                   AND tipoproce1.oper_oid_oper = opera1.oid_oper ");
            query.append("                                                   AND opera1.oid_oper in (" + oidINC020 + ", " + oidINC030 + ", " + oidINC050 +  ") ");
            query.append("                                                   AND tiposolic1.acce_oid_acce = acceso1.oid_acce    ");
            query.append("                                                   AND cab1.copa_oid_para_gene = concu1.oid_para_gral   ");
            query.append("                                                   AND concu1.oid_para_gral =  " + dtoe.getOidConcurso());
            query.append("                                                   AND artlo1.prod_oid_prod = produ1.oid_prod    ");                    
            query.append("                                                               AND artlo1.prod_oid_prod = artlo.prod_oid_prod    ");
            query.append("                                                               AND rerezo1.rarl_oid_reem_arti_lote = artlo1.oid_reem_arti_lote                                   ");
            query.append("                                                               AND ((SELECT COUNT (*)   ");
            query.append("                                                                            FROM zon_zona zon  ");
            query.append("                                                                             WHERE  zon.oid_zona = cab.zzon_oid_zona   ");
            query.append("                                                                            AND zon.oid_zona = NVL (rerezo1.zzon_oid_zona, zon.oid_zona)  ");
            query.append("                                                                            AND zon.zorg_oid_regi = NVL (rerezo1.zorg_oid_regi, zon.zorg_oid_regi)) >= 1  ");
            query.append("         )) orden_2  ");
            
            query.append(" FROM inc_reemp_artic_lote artlo, ");
            query.append(" inc_artic_lote lote, ");
            query.append(" ped_solic_posic pos, ");
            query.append(" ped_solic_cabec cab, ");
            query.append(" ped_tipo_solic_pais pais, ");
            query.append(" ped_tipo_solic tiposolic, ");
            query.append(" ped_tipo_solic_proce tipoproce, ");
            query.append(" bel_opera opera, ");
            query.append(" (select * from inc_bolsa_falta where fec_solu IS NULL) bol, ");
            query.append(" seg_acces acceso, ");
            query.append(" inc_concu_param_gener concu, ");
            query.append(" mae_produ produ, ");
            query.append(" inc_reemp_regio_zona rerezo ");
            
            query.append(" WHERE artlo.ind_acti = 0 ");
            query.append(" AND ARTLO.ARLO_OID_ARTI_LOTE = LOTE.OID_ARTI_LOTE ");
            query.append(" AND pos.prod_oid_prod = artlo.prod_oid_prod ");
            query.append(" AND bol.sopo_oid_soli_posi = pos.oid_soli_posi ");
            query.append(" AND pos.soca_oid_soli_cabe = cab.oid_soli_cabe ");
            query.append(" AND cab.tspa_oid_tipo_soli_pais = pais.oid_tipo_soli_pais ");
            query.append(" AND pais.tsol_oid_tipo_soli = tiposolic.oid_tipo_soli ");
            query.append(" AND tipoproce.tspa_oid_tipo_soli_pais = pais.oid_tipo_soli_pais ");
            query.append(" AND tipoproce.oper_oid_oper = opera.oid_oper ");
            
            // sapaza -- Cambio PER-SiCC-2010-0289  -- 04/05/2010 
            query.append(" AND opera.oid_oper in (" + oidINC020 + ", " + oidINC030 + ", " + oidINC050 +  ") ");
            
            query.append(" AND tiposolic.acce_oid_acce = acceso.oid_acce ");
            query.append(" AND cab.copa_oid_para_gene = concu.oid_para_gral ");
            query.append(" AND concu.oid_para_gral =  " + dtoe.getOidConcurso());
            query.append(" AND artlo.prod_oid_prod = produ.oid_prod ");
           /* query.append(" AND artlo.num_orde =  ");
                                 query.append("   (SELECT MIN (artlo1.num_orde) ");
                                 query.append("        FROM inc_reemp_artic_lote artlo1, ");
                    query.append("                                            ped_solic_posic pos1, ");
                    query.append("                                            ped_solic_cabec cab1,  ");
                    query.append("                                            ped_tipo_solic_pais pais1,  ");
                    query.append("                                            ped_tipo_solic tiposolic1,  ");
                    query.append("                                            ped_tipo_solic_proce tipoproce1,   ");
                    query.append("                                            bel_opera opera1,  ");
                    query.append("                                            (SELECT *  ");
                    query.append("                                               FROM inc_bolsa_falta  ");
                    query.append("                                               WHERE fec_solu IS NULL) bol1,  ");
                    query.append("                                            seg_acces acceso1,   ");
                    query.append("                                            inc_concu_param_gener concu1,   ");
                    query.append("                                            mae_produ produ1,  ");
                    query.append("                                            inc_reemp_regio_zona rerezo1 ");
                    
                    query.append("                                            WHERE   artlo1.ind_acti = 0  ");
                    query.append("                                                   AND pos1.prod_oid_prod = artlo1.prod_oid_prod ");
                    query.append("                                                   AND bol1.sopo_oid_soli_posi = pos1.oid_soli_posi     ");
                    
                    query.append("                                                   AND pos1.soca_oid_soli_cabe = cab1.oid_soli_cabe  ");
                    query.append("                                                   AND cab1.tspa_oid_tipo_soli_pais = pais1.oid_tipo_soli_pais  ");
                    query.append("                                                   AND pais1.tsol_oid_tipo_soli = tiposolic1.oid_tipo_soli ");
                    query.append("                                                   AND tipoproce1.tspa_oid_tipo_soli_pais =  pais1.oid_tipo_soli_pais ");
                    query.append("                                                   AND tipoproce1.oper_oid_oper = opera1.oid_oper ");
                    
                    // sapaza -- Cambio PER-SiCC-2010-0289  -- 04/05/2010 
                    query.append("                                                   AND opera1.oid_oper in (" + oidINC020 + ", " + oidINC030 + ", " + oidINC050 +  ") ");
                    
                    query.append("                                                   AND tiposolic1.acce_oid_acce = acceso1.oid_acce    ");
                    query.append("                                                   AND cab1.copa_oid_para_gene = concu1.oid_para_gral   ");
                    query.append("                                                   AND concu1.oid_para_gral =  " + dtoe.getOidConcurso());
                    query.append("                                                   AND artlo1.prod_oid_prod = produ1.oid_prod    ");                    
        query.append("                                                               AND artlo1.prod_oid_prod = artlo.prod_oid_prod    ");
        query.append("                                                               AND rerezo1.rarl_oid_reem_arti_lote = artlo1.oid_reem_arti_lote                                   ");
        query.append("                                                               AND ((SELECT COUNT (*)   ");
        query.append("                                                                            FROM zon_zona zon  ");
          query.append("                                                                             WHERE  zon.oid_zona = cab.zzon_oid_zona   ");  
        query.append("                                                                            AND zon.oid_zona = NVL (rerezo1.zzon_oid_zona, zon.oid_zona)  ");
        query.append("                                                                            AND zon.zorg_oid_regi = NVL (rerezo1.zorg_oid_regi, zon.zorg_oid_regi)) >= 1  ");
        query.append("                                                                             ))  ");*/
            
            query.append(" AND rerezo.rarl_oid_reem_arti_lote = artlo.oid_reem_arti_lote ");
            query.append(" AND (( ");
            query.append("        SELECT count(*)   ");
            query.append("            FROM zon_zona zon "); // si
            query.append("                   WHERE zon.oid_zona = cab.zzon_oid_zona  ");
            query.append("                       AND zon.oid_zona = NVL (rerezo.zzon_oid_zona, zon.oid_zona) ");// si
            query.append("                       AND zon.zorg_oid_regi = NVL (rerezo.zorg_oid_regi,zon.zorg_oid_regi)   "); // si
            query.append("    ) >= 1 ) ");

            query.append(" UNION ");            
            
            query.append(" SELECT bol.oid_bols_falt, pais.oid_tipo_soli_pais, tiposolic.oid_tipo_soli, ");
            query.append(" cab.ticl_oid_tipo_clie, tipoproce.tpos_oid_tipo_posi, ");
            query.append(" tipoproce.stpo_oid_subt_posi, cab.clie_oid_clie, ");
            query.append(" tiposolic.marc_oid_marc, acceso.cana_oid_cana, acceso.oid_acce, ");
            query.append(" concu.oid_para_gral, concu.num_conc, concu.num_vers, cab.num_prem, ");
            query.append(" lote.cod_vent_fict, artlo.imp_prec_publ, artlo.num_unid, ");
            query.append(" opera.oid_oper, pos.oid_soli_posi, artlo.prod_oid_prod, produ.cod_sap, ");
            query.append(" bol.num_unid_falt,  artlo.ind_acti, LOTE.PROD_OID_PROD original, ");
            
            query.append(" artlo.num_orde orden_1, ");
            query.append("   (SELECT MIN (artlo1.num_orde) ");
            query.append("        FROM inc_reemp_artic_lote artlo1, ");
            query.append("                                            ped_solic_posic pos1, ");
            query.append("                                            ped_solic_cabec cab1,  ");
            query.append("                                            ped_tipo_solic_pais pais1,  ");
            query.append("                                            ped_tipo_solic tiposolic1,  ");
            query.append("                                            ped_tipo_solic_proce tipoproce1,   ");
            query.append("                                            bel_opera opera1,  ");
            query.append("                                            (SELECT *  ");
            query.append("                                               FROM inc_bolsa_falta  ");
            query.append("                                               WHERE fec_solu IS NULL) bol1,  ");
            query.append("                                            seg_acces acceso1,   ");
            query.append("                                            inc_concu_param_gener concu1,   ");
            query.append("                                            mae_produ produ1  ");
            query.append("                                            WHERE   artlo1.ind_acti = 0 ");
            query.append("                                                   AND pos1.prod_oid_prod = artlo1.prod_oid_prod ");
            query.append("                                                   AND bol1.sopo_oid_soli_posi = pos1.oid_soli_posi     ");                
            query.append("                                                   AND pos1.soca_oid_soli_cabe = cab1.oid_soli_cabe  ");
            query.append("                                                   AND cab1.tspa_oid_tipo_soli_pais = pais1.oid_tipo_soli_pais  ");
            query.append("                                                   AND pais1.tsol_oid_tipo_soli = tiposolic1.oid_tipo_soli ");
            query.append("                                                   AND tipoproce1.tspa_oid_tipo_soli_pais = pais1.oid_tipo_soli_pais ");
            query.append("                                                   AND tipoproce1.oper_oid_oper = opera1.oid_oper ");
            query.append("                                                   AND opera1.oid_oper in (" + oidINC020 + ", " + oidINC030 + ", " + oidINC050 +  ") ");
            query.append("                                                   AND tiposolic1.acce_oid_acce = acceso1.oid_acce    ");
            query.append("                                                   AND cab1.copa_oid_para_gene = concu1.oid_para_gral   ");
            query.append("                                                   AND concu1.oid_para_gral =  " + dtoe.getOidConcurso());
            query.append("                                                   AND artlo1.prod_oid_prod = produ1.oid_prod    ");
            query.append("                                                   AND artlo1.prod_oid_prod = artlo.prod_oid_prod    ");
            query.append("   ) orden_2 ");
            
            query.append(" FROM inc_reemp_artic_lote artlo, ");
            query.append(" inc_artic_lote lote, ");
            query.append(" ped_solic_posic pos, ");
            query.append(" ped_solic_cabec cab, ");
            query.append(" ped_tipo_solic_pais pais, ");
            query.append(" ped_tipo_solic tiposolic, ");
            query.append(" ped_tipo_solic_proce tipoproce, ");
            query.append(" bel_opera opera, ");
            query.append("  (select * from inc_bolsa_falta where fec_solu IS NULL) bol, ");
            query.append(" seg_acces acceso, ");
            query.append(" inc_concu_param_gener concu, ");
            query.append(" mae_produ produ ");
            query.append(" WHERE artlo.ind_acti = 0 ");
            query.append(" AND ARTLO.ARLO_OID_ARTI_LOTE = LOTE.OID_ARTI_LOTE ");
            query.append(" AND pos.prod_oid_prod = artlo.prod_oid_prod ");
            query.append(" AND bol.sopo_oid_soli_posi = pos.oid_soli_posi ");
            query.append(" AND pos.soca_oid_soli_cabe = cab.oid_soli_cabe ");
            query.append(" AND cab.tspa_oid_tipo_soli_pais = pais.oid_tipo_soli_pais ");
            query.append(" AND pais.tsol_oid_tipo_soli = tiposolic.oid_tipo_soli ");
            query.append(" AND tipoproce.tspa_oid_tipo_soli_pais = pais.oid_tipo_soli_pais ");
            query.append(" AND tipoproce.oper_oid_oper = opera.oid_oper ");
            
            // sapaza -- Cambio PER-SiCC-2010-0289  -- 04/05/2010 
            query.append(" AND opera.oid_oper in (" + oidINC020 + ", " + oidINC030 + ", " + oidINC050 +  ") ");
            
            query.append(" AND tiposolic.acce_oid_acce = acceso.oid_acce ");
            query.append(" AND cab.copa_oid_para_gene = concu.oid_para_gral ");
            query.append(" AND concu.oid_para_gral = " + dtoe.getOidConcurso());
            query.append(" AND artlo.prod_oid_prod = produ.oid_prod ");
            /*query.append(" AND artlo.num_orde =  ");
                                             query.append("   (SELECT MIN (artlo1.num_orde) ");
                                              query.append("        FROM inc_reemp_artic_lote artlo1, ");
                query.append("                                            ped_solic_posic pos1, ");
                query.append("                                            ped_solic_cabec cab1,  ");
                query.append("                                            ped_tipo_solic_pais pais1,  ");
                query.append("                                            ped_tipo_solic tiposolic1,  ");
                query.append("                                            ped_tipo_solic_proce tipoproce1,   ");
                query.append("                                            bel_opera opera1,  ");
                query.append("                                            (SELECT *  ");
                query.append("                                               FROM inc_bolsa_falta  ");
                query.append("                                               WHERE fec_solu IS NULL) bol1,  ");
                query.append("                                            seg_acces acceso1,   ");
                query.append("                                            inc_concu_param_gener concu1,   ");
                query.append("                                            mae_produ produ1  ");
                
                query.append("                                            WHERE   artlo1.ind_acti = 0 ");
                query.append("                                                   AND pos1.prod_oid_prod = artlo1.prod_oid_prod ");
                query.append("                                                   AND bol1.sopo_oid_soli_posi = pos1.oid_soli_posi     ");                
                query.append("                                                   AND pos1.soca_oid_soli_cabe = cab1.oid_soli_cabe  ");
                query.append("                                                   AND cab1.tspa_oid_tipo_soli_pais = pais1.oid_tipo_soli_pais  ");
                query.append("                                                   AND pais1.tsol_oid_tipo_soli = tiposolic1.oid_tipo_soli ");
                query.append("                                                   AND tipoproce1.tspa_oid_tipo_soli_pais = pais1.oid_tipo_soli_pais ");
                query.append("                                                   AND tipoproce1.oper_oid_oper = opera1.oid_oper ");
                
                // sapaza -- Cambio PER-SiCC-2010-0289  -- 04/05/2010 
                query.append("                                                   AND opera1.oid_oper in (" + oidINC020 + ", " + oidINC030 + ", " + oidINC050 +  ") ");
                
                query.append("                                                   AND tiposolic1.acce_oid_acce = acceso1.oid_acce    ");
                query.append("                                                   AND cab1.copa_oid_para_gene = concu1.oid_para_gral   ");
                query.append("                                                   AND concu1.oid_para_gral =  " + dtoe.getOidConcurso());
                query.append("                                                   AND artlo1.prod_oid_prod = produ1.oid_prod    ");
                query.append("                                                   AND artlo1.prod_oid_prod = artlo.prod_oid_prod    ");
                query.append("                                                       ) ");*/
        
            query.append(" AND NOT EXISTS (SELECT 1   ");
            query.append(" FROM inc_reemp_regio_zona reemrz   ");
            query.append(" where reemrz.RARL_OID_REEM_ARTI_LOTE = artlo.OID_REEM_ARTI_LOTE)   ");
            
            query.append(") WHERE orden_1 = orden_2 ");
           
            RecordSet rs = null;
            
            try{
                  rs = bs.dbService.executeStaticQuery(query.toString());  
            }catch(Exception e){
                UtilidadesLog.error("DAORemplazoPremio.valoresSolicitud(): Exception",e);
                throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS));              
            }
         
                 return rs;
         
    
    }
    
    /**
    * Fecha de Creacion: 16/04/2010
    * Autor: Sergio Apaza
    * RCR: PER-SiCC-2010-0213
    * Comentario: este metodo retorna un objeto de la clase  Map con los datos de tipo de solicitud, tipo y subtipo de posicion.  
    */
    public Map obtenerTipoSubtipoSolicitud(String codigoOperacion, Long oidPais) throws MareException {
        UtilidadesLog.info("DAORemplazoPremios.obtenerTipoSubtipoSolicitud(String codigoOperacion, Long oidPais):Entrada");

        BelcorpService bs;
        RecordSet resultado = null;
        String codigoError;
        StringBuffer query = new StringBuffer();
        Map tipoSolicitudPosicion = new HashMap();

        try {
            bs = BelcorpService.getInstance();

            query.append(" SELECT OPER.OID_OPER, ");
            query.append(" TSOP.OID_TIPO_SOLI_PAIS, ");
            query.append(" TPOS_OID_TIPO_POSI, ");
            query.append(" STPO_OID_SUBT_POSI,");
            query.append(" TSPR.PROD_OID_PROD, ACCE.OID_ACCE, TSOLI.SBAC_OID_SBAC ");
            query.append(" FROM PED_TIPO_SOLIC_PROCE TSPR, PED_TIPO_SOLIC_PAIS TSOP,");
            query.append(" PED_TIPO_SOLIC TSOLI, SEG_ACCES ACCE, BEL_OPERA OPER ");
            query.append(" WHERE TSPR.TSPA_OID_TIPO_SOLI_PAIS =  ");
            query.append("  TSOP.OID_TIPO_SOLI_PAIS");
            query.append(" AND TSOP.TSOL_OID_TIPO_SOLI = TSOLI.OID_TIPO_SOLI");
            query.append(" AND TSOP.PAIS_OID_PAIS = " + oidPais);
            query.append(" AND TSPR.OPER_OID_OPER = OPER.OID_OPER ");
            query.append(" AND OPER.COD_OPER = '" + codigoOperacion + "'");
            query.append(" AND TSOLI.TICL_OID_TIPO_CLIE = " + ConstantesMAE.OID_TIPO_CLIENTE_CONSULTORA);
            query.append(" AND TSOLI.ACCE_OID_ACCE = ACCE.OID_ACCE");
          
            resultado = bs.dbService.executeStaticQuery(query.toString());
            
            if (resultado != null && !resultado.esVacio()) {
                tipoSolicitudPosicion.put("oidOperacion", new Long(
                        ((BigDecimal) resultado.getValueAt(0, "OID_OPER")).longValue()));
            
                tipoSolicitudPosicion.put("tipoSolicitud", new Long(
                        ((BigDecimal) resultado.getValueAt(0, "OID_TIPO_SOLI_PAIS")).longValue()));
            
                if (resultado.getValueAt(0, "TPOS_OID_TIPO_POSI") != null) {
                    tipoSolicitudPosicion.put("tipoPosicion", new Long(
                            ((BigDecimal) resultado.getValueAt(0, "TPOS_OID_TIPO_POSI")).longValue()));
                }
            
                if (resultado.getValueAt(0, "STPO_OID_SUBT_POSI") != null) {
                    tipoSolicitudPosicion.put("subtipoPosicion", new Long(
                            ((BigDecimal) resultado.getValueAt(0, "STPO_OID_SUBT_POSI")).longValue()));
                }
            
                if (resultado.getValueAt(0, "PROD_OID_PROD") != null) {
                    tipoSolicitudPosicion.put("producto", new Long(
                            ((BigDecimal) resultado.getValueAt(0, "PROD_OID_PROD")).longValue()));
                }

                tipoSolicitudPosicion.put("acceso", new Long(
                        ((BigDecimal) resultado.getValueAt(0, "OID_ACCE")).longValue()));
            
                if (resultado.getValueAt(0, "SBAC_OID_SBAC") != null) {
                    tipoSolicitudPosicion.put("subacceso", new Long(
                            ((BigDecimal) resultado.getValueAt(0, "SBAC_OID_SBAC")).longValue()));
                }
            }
            
        } catch (Exception e) {
            UtilidadesLog.error("ERROR ", e);
            codigoError = CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS;
            throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));
        }

        UtilidadesLog.info("DAORemplazoPremios.obtenerTipoSubtipoSolicitud(String codigoOperacion, Long oidPais):Salida");
        
        return tipoSolicitudPosicion;
    }

    // sapaza -- PER-SICC-2011-0303 -- 18/05/2011
    public DTOSalida obtenerPendientesBolsaFaltantes(DTOOID  dtoe) throws MareException{
        UtilidadesLog.info("DAORemplazoPremio.obtenerPendientesBolsaFaltantes(DTOOID  dtoe): Entrada");
        StringBuffer query = new StringBuffer();

        query.append("  SELECT bf.OID_BOLS_FALT, ");
        query.append("         mae.COD_CLIE, ");
        query.append("         mae.VAL_NOM1, ");
        query.append("         mae.VAL_APE1,  ");
        query.append("         p.COD_SAP, ");
        query.append("         pq_apl_aux.Valor_Gen_I18n_Sicc(" + dtoe.getOidIdioma() + ", p.OID_PROD, 'MAE_PRODU') DES_PROD, ");
        query.append("         sc.NUM_PREM, ");
        query.append("         bf.NUM_UNID_FALT, ");
        query.append("         bf.VAL_OBSE, ");
        query.append("         TO_CHAR(bf.FEC_ALTA, 'dd/MM/yyyy') as FEC_MODI ");
        
        query.append("         FROM INC_BOLSA_FALTA       bf,  ");
        query.append("              PED_SOLIC_POSIC       sp,  ");
        query.append("              PED_SOLIC_CABEC       sc,  ");
        query.append("              MAE_PRODU             p, ");
        query.append("              INC_CONCU_PARAM_GENER concu,  ");
        query.append("              MAE_CLIEN             mae ");
        
        query.append("         WHERE sc.COPA_OID_PARA_GENE = OID_PARA_GRAL ");
        query.append("           AND bf.SOPO_OID_SOLI_POSI = sp.OID_SOLI_POSI  ");
        query.append("           AND sp.SOCA_OID_SOLI_CABE = sc.OID_SOLI_CABE ");
        query.append("           AND sp.PROD_OID_PROD = p.OID_PROD ");
        query.append("           AND bf.FEC_SOLU IS NULL  ");
        query.append("           AND sc.CLIE_OID_CLIE = mae.OID_CLIE ");
        query.append("           AND concu.OID_PARA_GRAL = " + dtoe.getOid());
        query.append("      ORDER BY p.COD_SAP, mae.COD_CLIE ");
        BelcorpService bs = UtilidadesEJB.getBelcorpService();
        RecordSet rs = null;
        String w = new String();
        
        try {
            rs = bs.dbService.executeStaticQuery(query.toString());
        } catch (Exception e) {
             UtilidadesLog.error("DAORemplazoPremio.obtenerPendientesBolsaFaltantes(DTOOID  dtoe): Exception",e);
             throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS));              
        }
        
        UtilidadesLog.debug("DAORemplazoPremio.obtenerPendientesBolsaFaltantes(DTOOID  dtoe): Se han obtenido: [" + rs.getRowCount() + "] registro(s)");
        DTOSalida dtoSalida = new DTOSalida();
        dtoSalida.setResultado(rs);
        UtilidadesLog.info("DAORemplazoPremio.obtenerPendientesBolsaFaltantes(DTOOID  dtoe): Salida");
         
        return dtoSalida;      
    }
    
    // sapaza -- PER-SiCC-2011-0752 -- 29/09/2011
    public boolean validaEjecucionProcesoBatch(String procesoBatch) throws MareException {
      UtilidadesLog.info("DAORemplazoPremio.validaEjecucionProcesoBatch(DTOInfoMonitor dtoin, String sFechaControl): Entrada");
      StringBuffer query = new StringBuffer();

      query.append("SELECT COUNT(1) ");
      query.append("FROM GEN_PROCE_BATCH ");
      query.append("WHERE COD_PROC LIKE '" + procesoBatch  + "%' "); 
      query.append("  AND FEC_FIN IS NULL "); 
      
      BelcorpService bs = UtilidadesEJB.getBelcorpService();
      RecordSet rs = null;
      try {
        rs = bs.dbService.executeStaticQuery(query.toString());
      } catch (Exception e) {
        UtilidadesLog.error("DAORemplazoPremio.obtenerPendientesBolsaFaltantes(DTOOID  dtoe): Exception",e);
        throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS));              
      } 
      
      BigDecimal bd = (BigDecimal)rs.getValueAt(0, 0);

      if( bd.intValue() > 0 ){
        UtilidadesLog.info("DAORemplazoPremio.validaEjecucionProcesoBatch(String procesoBatch): Salida ");
        return true;
      } else{
        UtilidadesLog.info("DAORemplazoPremio.validaEjecucionProcesoBatch(String procesoBatch): Salida ");
        return false;
      }            
      
    }    
    
    // sapaza -- VEN-SiCC-2012-0100 -- 23/08/2012
    public void actualizarUsuarioReemplazos(Map oidReemplazos, String usuarioReemplazo) throws MareException{
        UtilidadesLog.info("DAORemplazoPremio.actualizarUsuarioReemplazos(Map oidReemplazos): Entrada");
        StringBuffer update = new StringBuffer();
        update.append(" BEGIN ");
        
        Iterator it = oidReemplazos.keySet().iterator();
        while(it.hasNext()) {
            String oidReemplazo = (String)it.next();
            
            update.append(" UPDATE INC_REEMP_ARTIC_LOTE ");
            update.append("    SET VAL_USUA = '" + usuarioReemplazo + "'");
            update.append("  WHERE OID_REEM_ARTI_LOTE = "+ oidReemplazo + "; ");
        }
        update.append(" END; ");
        BelcorpService bs = UtilidadesEJB.getBelcorpService();
      
        try {
            bs.dbService.executeUpdate(update.toString());
        } catch (Exception e) {
              UtilidadesLog.error("DAORemplazoPremio.carrarBolsaFaltante(): Exception",e);
              throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS));              
        }
        
        UtilidadesLog.info("DAORemplazoPremio.actualizarUsuarioReemplazos(Map oidReemplazos): Salida");
    }
    
}
