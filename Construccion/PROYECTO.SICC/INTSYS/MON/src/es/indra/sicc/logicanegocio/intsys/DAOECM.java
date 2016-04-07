package es.indra.sicc.logicanegocio.intsys;
import es.indra.mare.common.exception.MareException;
import es.indra.mare.common.mii.services.jdbcservice.RecordSet;

import es.indra.sicc.cmn.negocio.interfaces.IGestorInterfaces;

import es.indra.sicc.dtos.cra.ConstantesCRA;

import es.indra.sicc.dtos.cra.DTOPeriodo;

import es.indra.sicc.dtos.intsys.DTOECMRecibir;
import es.indra.sicc.dtos.intsys.DTOINT;

import es.indra.sicc.dtos.zon.DTOUnidadAdministrativa;
import es.indra.sicc.logicanegocio.inc.ConstantesINC;
import es.indra.sicc.util.BelcorpService;
import es.indra.sicc.util.CodigosError;
import es.indra.sicc.util.UtilidadesEJB;
import es.indra.sicc.util.UtilidadesError;
import es.indra.sicc.util.UtilidadesLog;

import es.indra.sicc.logicanegocio.bel.ConstantesBEL;
import es.indra.sicc.logicanegocio.mae.ConstantesMAE;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Vector;

public class DAOECM 
{
    public DAOECM()
    {
    }
    public RecordSet obtenerRecepcionVentas(DTOINT dtoe) throws MareException {
        UtilidadesLog.info("DAOECM.obtenerRecepcionVentas(DTOINT dtoe): Entrada");
        /* Se quieren obtener registros de INT:RecepcionVentasAsociadas para el numeroLote 
         * y codigoInterfaz recibidos en el interfaz, 
         * y con importeAbonoConsultora > 0 */ 
        StringBuffer consulta = new StringBuffer();
        Vector parametros = new Vector();
        
        consulta.append("SELECT RV.CLIE_OID_CLIE CLIENTE,");
        consulta.append(" CL.PAIS_OID_PAIS PAIS,"); //modificado por incidencia BELC300014911
        consulta.append(" RV.MARC_OID_MARC MARCA,");
        consulta.append(" RV.CANA_OID_CANA CANAL,");
        consulta.append(" RV.FEC_ORDE_INTE FECHA,");
        consulta.append(" RV.IMP_ABON_CONS IMPORTEABONOCONSULTORA,");
        consulta.append(" cl.COD_CLIE CODIGOCLIENTE,");
        consulta.append(" RV.SOCI_OID_SOCI SOCIEDAD");
        //FROM
        consulta.append(" FROM INT_RECEP_VENTA_ASOCI rv,");
        consulta.append("      MAE_CLIEN cl"); //añadido por incidencia BELC300014911
        //WHERE
        consulta.append(" WHERE RV.CLIE_OID_CLIE = CL.OID_CLIE");
        consulta.append(" AND RV.NUM_LOTE = ? ");//numero lote 
        parametros.add(dtoe.getNumeroLote());
        consulta.append(" AND RV.COD_INTE = ? ");//codigo Interfaz
        parametros.add(IGestorInterfaces.COD_INTERFAZ_ECM1);
        consulta.append(" AND RV.IMP_ABON_CONS > 0");
        
        BelcorpService bs = UtilidadesEJB.getBelcorpService();
        RecordSet rs = null;
        String codigoError = null;
        try{
            rs =bs.dbService.executePreparedQuery(consulta.toString(),parametros);
        }catch (Exception e){
            codigoError = CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS;
            UtilidadesLog.error(" buscarRegistrosDesc: Exception",e);
            this.logSql(" buscarRegistrosDesc. SQL: ",consulta.toString(),parametros);
            throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));
        }
        UtilidadesLog.info("DAOECM.obtenerRecepcionVentas(DTOINT dtoe): Salida");
        return rs;
    }
    
    public RecordSet obtenerTipoSolicitud(Long pais, Long marca, Long canal, Long sociedad) throws MareException {
        UtilidadesLog.info("DAOECM.obtenerTipoSolicitud(Long pais, Long marca, Long canal, Long sociedad): Entrada");
        /*Se quieren obtener datos de PED:TiposSolicitudProceso 
         * para pais, marca, canal y sociedad recibidos, 
         * y con operacion = "INT161" y tipoCliente = "Consultora" 
        */
        
        StringBuffer consulta = new StringBuffer();
        Vector parametros = new Vector();
        consulta.append("SELECT sp.OID_TIPO_SOLI_PAIS TIPOSOLICITUD,");
        consulta.append(" pr.TPOS_OID_TIPO_POSI TIPOPOSICION,");
        consulta.append(" pr.STPO_OID_SUBT_POSI SUBTIPOPOSICION,");
        consulta.append(" pr.PROD_OID_PROD PRODUCTO,");
        consulta.append(" ts.ACCE_OID_ACCE ACCESO,");
        consulta.append(" ts.SBAC_OID_SBAC SUBACCESO");
        //FROM
        consulta.append(" FROM PED_TIPO_SOLIC_PROCE pr,");
        consulta.append(" PED_TIPO_SOLIC ts,");
        consulta.append(" PED_TIPO_SOLIC_PAIS sp,");
        consulta.append(" SEG_ACCES ac");
        //WHERE
        consulta.append(" WHERE pr.tspa_oid_tipo_soli_pais = sp.oid_tipo_soli_pais");
        consulta.append(" AND ts.oid_tipo_soli = sp.tsol_oid_tipo_soli");
        consulta.append(" AND ts.acce_oid_acce = ac.oid_acce");
        consulta.append(" AND sp.PAIS_OID_PAIS = ?"); //pais
        parametros.add(pais);
        consulta.append(" AND pr.OPER_OID_OPER = ?"); //ConstantesBel.INT161=>32
        parametros.add(ConstantesBEL.INT161); 
        consulta.append(" AND ts.MARC_OID_MARC = ?"); //marca
        parametros.add(marca);
        consulta.append(" AND ac.CANA_OID_CANA = ?"); //canal
        parametros.add(canal);
        consulta.append(" AND ts.TICL_OID_TIPO_CLIE = ?"); //ConstantesMAE.TIPO_CLIENTE_CONSULTORA => 2
        parametros.add(ConstantesMAE.TIPO_CLIENTE_CONSULTORA);
        consulta.append(" AND sp.SOCI_OID_SOCI = ?"); //sociedad
        parametros.add(sociedad);
        
        BelcorpService bs = UtilidadesEJB.getBelcorpService();
        RecordSet rs = null;
        String codigoError = null;
        try{
            rs =bs.dbService.executePreparedQuery(consulta.toString(),parametros);
        }catch (Exception e){
            codigoError = CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS;
            UtilidadesLog.error(" buscarRegistrosDesc: Exception",e);
            this.logSql(" buscarRegistrosDesc. SQL: ",consulta.toString(),parametros);
            throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));
        }
        UtilidadesLog.info("DAOECM.obtenerTipoSolicitud(Long pais, Long marca, Long canal, Long sociedad): Salida");
        return rs;
    }

    public RecordSet obtenerFechasEstatus(Long concurso) throws MareException {
        UtilidadesLog.info("DAOECM.obtenerFechasEstatus(Long concurso): Entrada");
        /* Se quiere consultar Estado de Venta para el concurso recibido */ 

        StringBuffer consulta = new StringBuffer();
        Vector parametros = new Vector();
        
        consulta.append("SELECT ");
        consulta.append(" cp1.FEC_INIC FECHAINIDESDE,");
        consulta.append(" cp2.FEC_FINA FECHAFINHASTA,");
        //consulta.append(" ev.ESTA_OID_ESTA_CLIE ESTATUS,");
        // La siguiente linea se modifico por inc. 22780 - sbonanno 16/03/2006
        // consulta.append(" ec.OID_ESTA_CLIE ESTATUSFUTURO");
        // consulta.append(" ec.ESTA_OID_ESTA_CLIE ESTATUSFUTURO");
        
        
        //Modificado en base a la incidencia ECM-5
        //que deja sin efecto el cambio de la incidencia 22780 (Gacevedo)
        consulta.append(" EV.ESTA_OID_ESTA_CLIE ESTATUS, ");
        consulta.append(" EC.OID_ESTA_CLIE ESTATUSFUTURO ");
        //FIN Modificacion ecm-5
        consulta.append(" FROM INC_ESTAT_VENTA_CONSU ev, CRA_PERIO cp1,");
        consulta.append(" CRA_PERIO cp2 , MAE_ESTAT_CLIEN ec, INC_CONCU_PARAM_GENER pg");
        consulta.append(" WHERE ev.COPA_OID_PARA_GRAL = ? ");
        parametros.add(concurso);
        // La siguiente linea se modifico por inc. 22780 - sbonanno 16/03/2006
        // consulta.append(" AND ev.ESTA_OID_ESTA_CLIE = ec.ESTA_OID_ESTA_CLIE ");// para el estado Futuro
        // consulta.append(" AND ev.ESTA_OID_ESTA_CLIE = ec.OID_ESTA_CLIE ");
        
        //Modificado en base a la incidencia ECM-5
        //que deja sin efecto el cambio de la incidencia 22780 (Gacevedo)
        consulta.append(" AND ev.ESTA_OID_ESTA_CLIE = ec.ESTA_OID_ESTA_CLIE ");
        //FIN Modificacion ecm-5
        consulta.append(" AND pg.OID_PARA_GRAL = ev.COPA_OID_PARA_GRAL ");
		consulta.append(" AND ev.perd_oid_peri_desd = cp1.oid_peri AND ev.perd_oid_peri_hast = cp2.oid_peri ");
        
        BelcorpService bs = UtilidadesEJB.getBelcorpService();
        RecordSet rs = null;
        String codigoError = null;
        try{
            rs =bs.dbService.executePreparedQuery(consulta.toString(),parametros);
        }catch (Exception e){
            codigoError = CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS;
            UtilidadesLog.error(" obtenerFechasEstatus: Exception",e);
            this.logSql(" obtenerFechasEstatus. SQL: ",consulta.toString(),parametros);
            throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));
        }
        UtilidadesLog.info("DAOECM.obtenerFechasEstatus(Long concurso): Salida");
        return rs;
    }
    
    public RecordSet obtenerHistoricoEstatus (Long estado, Long concurso, Long cliente, Date fecIni, Date fecFin) throws MareException {
        UtilidadesLog.info("DAOECM.obtenerHistoricoEstatus(Long estado, Long concurso, Long cliente, Date fecIni, Date fecFin): Entrada");
        /* Se quiere consultar Estado de Venta para el concurso recibido */ 

        StringBuffer consulta = new StringBuffer();
        //Vector parametros = new Vector();

        /*consulta.append("SELECT DISTINCT he.OID_HIST_ESTA ");
        consulta.append(" FROM MAE_CLIEN_HISTO_ESTAT he, CRA_PERIO cp1, CRA_PERIO cp2 , INC_CONCU_PARAM_GENER co ");
        consulta.append(" WHERE co.OID_PARA_GRAL = ? ");
        parametros.add(concurso);
        consulta.append(" AND he.ESTA_OID_ESTA_CLIE = ? ");
        parametros.add(estado);        
        consulta.append(" AND he.CLIE_OID_CLIE = ? ");
        parametros.add(cliente);        
        consulta.append(" AND cp1.pais_oid_pais = cp2.pais_oid_pais AND cp1.marc_oid_marc = cp2.marc_oid_marc AND cp1.cana_oid_cana = cp2.cana_oid_cana  ");
        consulta.append(" AND he.perd_oid_peri = cp1.oid_peri AND he.perd_oid_peri_peri_fin = cp2.oid_peri ");
		consulta.append(" AND cp2.marc_oid_marc = co.marc_oid_marc AND cp2.pais_oid_pais = co.pais_oid_pais AND cp2.cana_oid_cana = co.cana_oid_cana ");

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        if (fecIni!=null){
            java.sql.Date fechaIni = new java.sql.Date(fecIni.getTime());
            String sFechaIni = sdf.format(fechaIni);   
            consulta.append(" AND cp1.FEC_INIC <=  TO_DATE( ? ,'YYYY-MM-DD') ");             
            parametros.add(sFechaIni);
        }
        if (fecFin!=null){
            java.sql.Date fechaFin = new java.sql.Date(fecFin.getTime());
            String sFechaFin = sdf.format(fechaFin);   
            consulta.append(" AND cp2.FEC_FINA >  TO_DATE( ? ,'YYYY-MM-DD') ");               
            parametros.add(sFechaFin);
        }
        */
            
        consulta.append("select * from (select case when perd_oid_peri_peri_fin is null then ");
        consulta.append("(select he.oid_hist_esta ");
        consulta.append(" from mae_clien_histo_estat he, ");
        consulta.append(" cra_perio cp1, ");
        consulta.append(" inc_concu_param_gener co ");
        consulta.append(" WHERE co.oid_para_gral = "+concurso.toString());
        
        //modificado por Sapaza, fecha 09-10-2007, incidencia Sicc20070466
        //consulta.append(" AND he.esta_oid_esta_clie = "+estado.toString());
        //consulta.append(" AND he.clie_oid_clie = "+cliente.toString());
        consulta.append(" AND he.oid_hist_esta = he1.oid_hist_esta ");
        
        consulta.append(" AND cp1.pais_oid_pais = co.pais_oid_pais ");
        consulta.append(" AND cp1.marc_oid_marc = co.marc_oid_marc ");
        consulta.append(" AND cp1.cana_oid_cana = co.cana_oid_cana ");
        consulta.append(" AND he.perd_oid_peri = cp1.oid_peri ");
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        if (fecIni!=null){
            java.sql.Date fechaIni = new java.sql.Date(fecIni.getTime());
            String sFechaIni = sdf.format(fechaIni);   
            consulta.append(" AND cp1.FEC_INIC <=  TO_DATE( '"+sFechaIni+"' ,'YYYY-MM-DD') ");
        }
        consulta.append(" )else( ");
        consulta.append(" select he.oid_hist_esta ");
        consulta.append(" from mae_clien_histo_estat he, ");
        consulta.append(" cra_perio cp1, ");
        consulta.append(" cra_perio cp2, ");
        consulta.append(" inc_concu_param_gener co ");
        consulta.append(" WHERE co.oid_para_gral = "+concurso.toString());
        
        //modificado por Sapaza, fecha 09-10-2007, incidencia Sicc20070466
        //consulta.append(" AND he.esta_oid_esta_clie = "+estado.toString());
        //consulta.append(" AND he.clie_oid_clie = "+cliente.toString());
        consulta.append(" AND he.oid_hist_esta = he1.oid_hist_esta ");
        
        consulta.append(" AND cp1.pais_oid_pais = co.pais_oid_pais ");
        consulta.append(" AND cp1.marc_oid_marc = co.marc_oid_marc ");
        consulta.append(" AND cp1.cana_oid_cana = co.cana_oid_cana ");
        if (fecIni!=null){
            java.sql.Date fechaIni = new java.sql.Date(fecIni.getTime());
            String sFechaIni = sdf.format(fechaIni);   
            consulta.append(" AND cp1.FEC_INIC <=  TO_DATE( '"+sFechaIni+"' ,'YYYY-MM-DD') ");             
        }
        consulta.append(" AND he.perd_oid_peri = cp1.oid_peri ");
        consulta.append(" AND he.perd_oid_peri_peri_fin = cp2.oid_peri ");
        consulta.append(" AND cp2.marc_oid_marc = co.marc_oid_marc ");
        consulta.append(" AND cp2.pais_oid_pais = co.pais_oid_pais ");
        consulta.append(" AND cp2.cana_oid_cana = co.cana_oid_cana ");
        //Aqui lo que se hace es evaluar que la fecha de facturacion se
        //encuentre en el rango demarcado por el periodo inicio y el periodo fin
        //Si no se indica la fecha fin, se utiliza la fecha inicio para
        //compararla con la fecha final del periodo final. (Gacevedo)
        if (fecFin!=null){
            java.sql.Date fechaFin = new java.sql.Date(fecFin.getTime());
            String sFechaFin = sdf.format(fechaFin);   
            consulta.append(" AND cp2.FEC_FINA >=  TO_DATE( '"+sFechaFin+"' ,'YYYY-MM-DD') ");
        }else {
            if(fecIni!=null){
                java.sql.Date fechaIni = new java.sql.Date(fecIni.getTime());
                String sFechaIni = sdf.format(fechaIni);   
                consulta.append(" AND cp2.FEC_FINA >=  TO_DATE( '"+sFechaIni+"' ,'YYYY-MM-DD') ");
            }
        }
        consulta.append(" ) end oid_hist_esta  ");
        consulta.append(" from mae_clien_histo_estat he1 ");
        consulta.append(" where he1.esta_oid_esta_clie = "+estado.toString());
        consulta.append(" AND he1.clie_oid_clie = "+cliente.toString()+" ) where oid_hist_esta is not null");
        
        
        //BelcorpService bs = UtilidadesEJB.getBelcorpService();
        RecordSet rs = null;
        String codigoError = null;
        try{
            rs =BelcorpService.getInstance().dbService.executeStaticQuery(consulta.toString());
        }catch (Exception e){
            codigoError = CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS;
            UtilidadesLog.error(" obtenerFechasEstatus: Exception",e);
            //this.logSql(" obtenerFechasEstatus. SQL: ",consulta.toString(),parametros);
            throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));
        }
        UtilidadesLog.info("DAOECM.obtenerHistoricoEstatus(Long estado, Long concurso, Long cliente, Date fecIni, Date fecFin): Salida");
        return rs;
    }
    

     public RecordSet obtenerIdentificacionCliente(Long oidPais, Long oidTipoDocumento, String numDocIdentidad) throws MareException
     {
         UtilidadesLog.info("DAOECM.obtenerIdentificacionCliente(Long oidPais, Long oidTipoDocumento, String numDocIdentidad): Entrada");         
         StringBuffer consulta = new StringBuffer();
         Vector parametros = new Vector();
         consulta.append(" SELECT ci.NUM_DOCU_IDEN, ci.CLIE_OID_CLIE, mc.COD_CLIE ");   //  Modificado HRCS - 06/09/2007 - Cambio Sicc20070385
         consulta.append(" FROM MAE_CLIEN_IDENT ci, MAE_CLIEN mc ");
         consulta.append(" WHERE mc.OID_CLIE=ci.CLIE_OID_CLIE ");
         consulta.append(" AND mc.PAIS_OID_PAIS = ? ");
         parametros.add(oidPais);
         consulta.append(" AND ci.TDOC_OID_TIPO_DOCU = ? ");
         parametros.add(oidTipoDocumento);
         consulta.append(" AND ci.NUM_DOCU_IDEN = ? ");
         parametros.add(numDocIdentidad);
         
         BelcorpService bs = UtilidadesEJB.getBelcorpService();
         RecordSet rs = null;
         String codigoError = null;
         try{
           rs =bs.dbService.executePreparedQuery(consulta.toString(),parametros);
         }catch (Exception e) {
            codigoError = CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS;
           	UtilidadesLog.error(" obtenerIdentificacionCliente: Exception",e);
            this.logSql(" obtenerIdentificacionCliente. SQL: ",consulta.toString(),parametros);
            throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));
         }//catch
         
         UtilidadesLog.info("DAOECM.obtenerIdentificacionCliente(Long oidPais, Long oidTipoDocumento, String numDocIdentidad): Salida");
         return rs;
     }    


     public RecordSet obtenerClientesNovedad (Date fechaActuacion, Long pais) throws MareException
     {        
        UtilidadesLog.info("DAOECM.obtenerClientesNovedad(Date fechaActuacion, Long pais): Entrada");
        StringBuffer consulta = new StringBuffer();
        Vector parametros = new Vector();
        
        consulta.append(" SELECT mc.COD_CLIE CODIGOCLIENTE, pa.COD_PAIS CODIGOPAIS, ");
        consulta.append(" mc.VAL_APE1 APELLIDOPATERNO, mc.VAL_APE2 APELLIDOMATERNO,mc.VAL_APEL_CASA APELLIDOCASADA, ");
        consulta.append(" mc.VAL_NOM1 NOMBREPRIMERO, mc.VAL_NOM2 NOMBRESEGUNDO, mc.COD_SEXO SEXO ");
        
        consulta.append(" FROM MAE_CLIEN mc, SEG_PAIS pa, MAE_CLIEN_TIPO_SUBTI ct ");
        consulta.append(" WHERE mc.PAIS_OID_PAIS = pa.OID_PAIS ");
        consulta.append(" AND ct.clie_oid_clie = mc.oid_clie ");
        consulta.append(" AND mc.PAIS_OID_PAIS = ? ");
        parametros.add(pais);
        consulta.append(" AND ct.TICL_OID_TIPO_CLIE = ? ");
        parametros.add(ConstantesMAE.TIPO_CLIENTE_CONSULTORA);
         
        //SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        
        if (fechaActuacion!=null){//Incidencia 14638 CORREGIDO
            
            //consulta.append(" AND mc.FEC_ULTI_ACTU >  TO_DATE( ? ,'YYYY-MM-DD') ");  
            consulta.append(" AND mc.FEC_ULTI_ACTU > TO_DATE(?,'YYYY-MM-DD HH24:MI:SS')");  
            parametros.add(formateaFechaTimestamp(fechaActuacion));
            UtilidadesLog.info("fechaActuacion----- " + fechaActuacion);    
        }
        
        BelcorpService bs = UtilidadesEJB.getBelcorpService();
        RecordSet rs = null;
        String codigoError = null;
        try{
           rs =bs.dbService.executePreparedQuery(consulta.toString(),parametros);
        }catch (Exception e) {
            codigoError = CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS;
           	UtilidadesLog.error(" obtenerClientesNovedad: Exception",e);
            this.logSql(" obtenerClientesNovedad. SQL: ",consulta.toString(),parametros);
            throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));
         }//catch
        
        UtilidadesLog.info("DAOECM.obtenerClientesNovedad(Date fechaActuacion, Long pais): Salida");
        return rs;
     }

     public RecordSet obtenerClienteMarcaNovedad (Date fechaActuacion, Long pais) throws MareException 
     {
         UtilidadesLog.info("DAOECM.obtenerClienteMarcaNovedad(Date fechaActuacion, Long pais): Entrada");
         
         StringBuffer consulta = new StringBuffer();
         Vector parametros = new Vector();
         
         consulta.append(" SELECT mc.COD_CLIE CODIGOCLIENTE, pa.COD_PAIS CODIGOPAIS, ma.COD_MARC CODIGOMARCA ");
         consulta.append(" FROM MAE_CLIEN mc, SEG_PAIS pa,  ");
         consulta.append(" MAE_CLIEN_TIPO_SUBTI ct, MAE_CLIEN_MARCA cm, SEG_MARCA ma ");
         consulta.append(" WHERE mc.OID_CLIE = ct.CLIE_OID_CLIE ");
         consulta.append(" AND mc.OID_CLIE = cm.CLIE_OID_CLIE ");
         consulta.append(" AND mc.PAIS_OID_PAIS = pa.OID_PAIS ");
         consulta.append(" AND cm.MARC_OID_MARC = ma.OID_MARC");
         //mc.PAIS_OID_PAIS = pais recibido 
         consulta.append(" AND mc.PAIS_OID_PAIS = ? ");
         parametros.add(pais);
        
        if (fechaActuacion!=null){
            //revisar este campo abierta incidencia 14638
            consulta.append(" AND ct.TICL_OID_TIPO_CLIE  = ? ");
            parametros.add(ConstantesMAE.OID_TIPO_CLIENTE_CONSULTORA);

            //consulta.append(" AND cm.FEC_ULTI_ACTU >  TO_DATE( ? ,'YYYY-MM-DD') ");  
            consulta.append(" AND mc.FEC_ULTI_ACTU > TO_DATE(?,'YYYY-MM-DD HH24:MI:SS')");  
            parametros.add(formateaFechaTimestamp(fechaActuacion));
        }
         
         BelcorpService bs = UtilidadesEJB.getBelcorpService();
        RecordSet rs = null;
        String codigoError = null;
        try{
           rs =bs.dbService.executePreparedQuery(consulta.toString(),parametros);
        }catch (Exception e) {
            codigoError = CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS;
           	UtilidadesLog.error(" obtenerClientesNovedad: Exception",e);
            this.logSql(" obtenerClientesNovedad. SQL: ",consulta.toString(),parametros);
            throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));
         }//catch
        
        UtilidadesLog.info("DAOECM.obtenerClienteMarcaNovedad(Date fechaActuacion, Long pais): Salida");
        return rs;
     }

     public RecordSet traducirCodigoCliente (Long codigoAntiguo) throws MareException 
     {
         UtilidadesLog.info("DAOECM.traducirCodigoCliente(Long codigoAntiguo): Entrada");
         StringBuffer consulta = new StringBuffer();
         Vector parametros = new Vector();
         consulta.append(" SELECT mc.COD_CLIE ");
         consulta.append(" FROM MAE_CLIEN mc, MAE_CODIG_CLIEN_ANTER ca ");
         consulta.append(" WHERE ca.CLIE_OID_CLIE_NUEV = mc.OID_CLIE ");
         consulta.append(" AND ca.COD_CLIE_ANTI = ? ");
         //BELC300018120
         parametros.add(codigoAntiguo + "");
         
         BelcorpService bs = UtilidadesEJB.getBelcorpService();
         RecordSet rs = null;
         String codigoError = null;
         try{
           rs =bs.dbService.executePreparedQuery(consulta.toString(),parametros);
         }catch (Exception e) {
            codigoError = CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS;
           	UtilidadesLog.error(" traducirCodigoCliente: Exception",e);
            this.logSql(" traducirCodigoCliente. SQL: ",consulta.toString(),parametros);
            throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));
         }//catch
         
         UtilidadesLog.info("DAOECM.traducirCodigoCliente(Long codigoAntiguo): Salida");
         return rs;
     }

    //Poner incidencias  sobre esta linea //ae.COD_ATRI = atributo recibido 
    public RecordSet obtenerValorDefectoObligatorio (Long pais, Long subtipoCliente, String codigo) throws MareException {
        UtilidadesLog.info("DAOECM.obtenerValorDefectoObligatorio(Long pais, Long subtipoCliente, String codigo): Entrada");
        
		StringBuffer query = new StringBuffer();
        Vector parametros = new Vector();
        query.append(" SELECT cc.VAL_DEFE VALORDEFECTO, cc.IND_OBLI OBLIGATORIO ");
        query.append(" FROM MAE_CONFI_CAMPO cc , PED_ATRIB_ESPEC ae ");
        query.append(" WHERE cc.ATRE_OID_ATRI_ESPE = ae.oid_atri_espe");
		query.append(" AND cc.PAIS_OID_PAIS = ? ");
        parametros.add(pais);
        query.append(" AND cc.sbti_oid_subt_clie = ? "); 
        parametros.add(subtipoCliente);
        query.append(" AND ae.COD_ATRI = ? "); //Incidencia 14627 CORREGIDA
		parametros.add(codigo);
        
        BelcorpService bs = UtilidadesEJB.getBelcorpService();
		RecordSet resultado = null;
		String codigoError = null;
        
        try {
			resultado = bs.dbService.executePreparedQuery(query.toString(), parametros);
            UtilidadesLog.debug("Resultado del RecordSet:" + resultado);
            //this.logSql("obtenerValorDefectoObligatorio", query.toString(), parametros);
		} catch (Exception e) {
			UtilidadesLog.error("obtenerValorDefectoObligatorio: ",e);
            codigoError = CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS;
            throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));
		}
        UtilidadesLog.info("DAOECM.obtenerValorDefectoObligatorio(Long pais, Long subtipoCliente, String codigo): Salida");
        return resultado;
	
        
    }
   /**
    * Modificado: SICC-GCC-MAE-005 - Cleal
    *  Se cambia el tipo del parametro numeroPrincipal de la firma.Debe quedar String
    */
    public RecordSet obtenerTerritorioPorVia (Long oidTipoVia, String nombreVia, 
        String numeroPrincipal, Long oidPais) throws MareException {
        UtilidadesLog.info("DAOECM.obtenerTerritorioPorVia(Long oidTipoVia, String nombreVia, String numeroPrincipal, Long oidPais): Entrada");
        //SICC-GCC-MAE-005 - Cleal
        StringBuffer query = new StringBuffer();
        Vector parametros = new Vector();

        query.append(" SELECT vs.TERR_OID_TERR ");
        query.append(" FROM ZON_VIA_SEGME vs ");
        query.append(" WHERE vs.VIA_OID_VIA = ");
        query.append(" (SELECT zv.OID_VIA ");
        query.append(" FROM ZON_VIA zv");  
        query.append(" WHERE zv.NOM_VIA = ? ");
        parametros.add(nombreVia);
        query.append(" AND zv.TIVI_OID_TIPO_VIA = ? ");
        parametros.add(oidTipoVia);
        query.append(" AND zv.PAIS_OID_PAIS = ? ");
        parametros.add(oidPais);
		query.append(" AND ROWNUM = 1 )");
        query.append(" AND vs.NUM_INIC_SEGM <= ? ");
        parametros.add(numeroPrincipal);
		query.append(" AND vs.NUM_FIN_SEGM > ? ");
		parametros.add(numeroPrincipal);
               
        BelcorpService bs = UtilidadesEJB.getBelcorpService();
		RecordSet resultado = null;
		String codigoError = null;
        
        try {
			resultado = bs.dbService.executePreparedQuery(query.toString(), parametros);
            UtilidadesLog.debug("Resultado del RecordSet:" + resultado);
            this.logSql("obtenerTerritorioPorVia", query.toString(), parametros);
		} catch (Exception e) {
			UtilidadesLog.error("obtenerTerritorioPorVia: ",e);
            codigoError = CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS;
            throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));
		}
        UtilidadesLog.info("DAOECM.obtenerTerritorioPorVia(Long oidTipoVia, String nombreVia, String numeroPrincipal, Long oidPais): Salida");
        return resultado;
 

    }
   
    public RecordSet obtenerClientePrimerContactoNovedad (Date fechaActuacion, Long pais) throws MareException{
        UtilidadesLog.info("DAOECM.obtenerClientePrimerContactoNovedad(Date fechaActuacion, Long pais): Entrada");
        
        StringBuffer consulta = new StringBuffer("");
        Vector parametros = new Vector();
        
        consulta.append(" SELECT mc.COD_CLIE CODIGOCLIENTE, pa.COD_PAIS CODIGOPAIS, ");
        consulta.append(" pc.COD_TIPO_CONT CODIGOTIPOCONTACTO, pc.FEC_CONT FECHACONTACTO ");
        consulta.append(" FROM MAE_CLIEN mc , SEG_PAIS pa , MAE_CLIEN_TIPO_SUBTI ct , MAE_CLIEN_PRIME_CONTA pc ");
        consulta.append(" WHERE pa.OID_PAIS = mc.PAIS_OID_PAIS ");
        consulta.append(" AND mc.OID_CLIE = pc.CLIE_OID_CLIE ");
        consulta.append(" AND mc.PAIS_OID_PAIS = ? ");//pais recibido
        parametros.add(pais);

        if(fechaActuacion!=null){
            consulta.append(" AND mc.OID_CLIE = ct.CLIE_OID_CLIE ");
            consulta.append(" AND ct.TICL_OID_TIPO_CLIE = ? ");//ConstantesMAE.OID_TIPO_CLIENTE_CONSULTORA
            parametros.add(ConstantesMAE.OID_TIPO_CLIENTE_CONSULTORA);
			
            //Incidencia 14638
            //consulta.append(" AND pc.FEC_ULTI_ACTU > TO_DATE(?, 'YYYY-MM-DD') "); //fechaActuacion recibida            
            consulta.append(" AND mc.FEC_ULTI_ACTU > TO_DATE(?,'YYYY-MM-DD HH24:MI:SS')");  
            parametros.add(formateaFechaTimestamp(fechaActuacion));
        }
        
        RecordSet rs = null;
        BelcorpService bs = UtilidadesEJB.getBelcorpService();
        
        try {
            rs = bs.dbService.executePreparedQuery(consulta.toString(), parametros);
        } catch (Exception e) {
            String codigoError = CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS;
            UtilidadesLog.error(" obtenerClientePrimerContactoNovedad: Exception",e);
            this.logSql(" obtenerClientePrimerContactoNovedad. SQL: ",consulta.toString(),parametros);
            throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));
        }
        
        UtilidadesLog.info("DAOECM.obtenerClientePrimerContactoNovedad(Date fechaActuacion, Long pais): Salida");
        return rs;
    }   
     public RecordSet obtenerClientesAdicionalesNovedad(Date fechaActuacion, Long pais) throws MareException{
        UtilidadesLog.info("DAOECM.obtenerClientesAdicionalesNovedad(Date fechaActuacion, Long pais): Entrada");

        //Documentation
        /* Se quiere consultar la entidad de MAE ClienteDatosAdicionales y obtener registros en los que haya habido alguna actualizacion posterior a */ 
        /* la fechaActuacion (ultima fecha de ejecución del interfaz) recibida como parametro, y para el pais activo */ 
        
        Vector parametros = new Vector();
        // Se crea la consulta SQL
        StringBuffer consulta = new StringBuffer();
        
        consulta.append("SELECT  MC.COD_CLIE CODIGOCLIENTE, PA.COD_PAIS CODIGOPAIS, CA.FEC_NACI FECHANACIMIENTO,  ");
        consulta.append(" PA.COD_PAIS NACIONALIDAD, EC.COD_ESTA_CIVI ESTADOCIVIL, CA.VAL_PROF PROFESION, ");
        consulta.append(" CA.VAL_OCUP OCUPACION, CA.VAL_CENT_TRAB CENTROTRABAJO, CA.VAL_CARG_DESE CARGO, ");
        consulta.append(" NE.COD_NIVE_ESTU NIVELESTUDIOS, CA.VAL_CENT_ESTU CENTROESTUDIOS,CA.NUM_HIJO NUMEROHIJOS ");
        
        consulta.append(" FROM MAE_CLIEN MC, SEG_PAIS PA, MAE_CLIEN_DATOS_ADICI CA, MAE_ESTAD_CIVIL EC, MAE_NIVEL_ESTUD NE, MAE_CLIEN_TIPO_SUBTI CT ");
        
        consulta.append(" WHERE MC.PAIS_OID_PAIS = ? ");
        parametros.add(pais);
         
        consulta.append(" AND CA.CLIE_OID_CLIE = MC.OID_CLIE ");
        consulta.append(" AND NE.PAIS_OID_PAIS = MC.PAIS_OID_PAIS ");
        consulta.append(" AND CT.CLIE_OID_CLIE = MC.OID_CLIE ");
        consulta.append(" AND MC.PAIS_OID_PAIS = PA.OID_PAIS ");
        consulta.append(" AND CA.ESCV_OID_ESTA_CIVI = EC.OID_ESTA_CIVI ");
        consulta.append(" AND CA.NIED_OID_NIVE_ESTU = NE.OID_NIVE_ESTU ");
          
        if(fechaActuacion != null){
            consulta.append(" AND CT.TICL_OID_TIPO_CLIE = ? ");
            parametros.add(ConstantesMAE.OID_TIPO_CLIENTE_CONSULTORA);
            
            //consulta.append(" AND (CA.FEC_ULTI_ACTU > TO_DATE( ? ,'YYYY-MM-DD')) ");
            consulta.append(" AND mc.FEC_ULTI_ACTU > TO_DATE(?,'YYYY-MM-DD HH24:MI:SS')");  
            parametros.add(formateaFechaTimestamp(fechaActuacion));
        }
    
        // Se ejecuta la consulta 
		BelcorpService bs = UtilidadesEJB.getBelcorpService();
		RecordSet resultado = null;
		String codigoError = null;
		try {
			resultado = bs.dbService.executePreparedQuery(consulta.toString(), 
				parametros);
		} catch (Exception e) {
            codigoError = CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS;
			UtilidadesLog.error("DAOECM.obtenerClientesAdicionalesNovedad: Exception",e);
			this.logSql("DAOECM.obtenerClientesAdicionalesNovedad. SQL: ",consulta.toString(),
				parametros);
            throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));
		}
		
		UtilidadesLog.info("DAOECM.obtenerClientesAdicionalesNovedad(Date fechaActuacion, Long pais): Salida");
		return resultado;
	}
    
    public RecordSet obtenerTipoClienteNovedad(Date fechaActuacion, Long pais) throws MareException{

        //Documentation
        /* Se quiere consultar la entidad de MAE ClienteTipoSubtipo y obtener registros en los que haya habido alguna actualizacion posterior a */ 
        /* la fechaActuacion (ultima fecha de ejecución del interfaz) recibida como parametro, y para el pais activo */ 
        UtilidadesLog.info("DAOECM.obtenerTipoClienteNovedad(Date fechaActuacion, Long pais): Entrada");
        Vector parametros = new Vector();
        // Se crea la consulta SQL
        StringBuffer consulta = new StringBuffer();
        
        consulta.append(" SELECT MC.COD_CLIE CODIGOCLIENTE, PA.COD_PAIS CODIGOPAIS, ");
        consulta.append(" TC.COD_TIPO_CLIE TIPOCLIENTE, SC.COD_SUBT_CLIE SUBTIPOCLIENTE "); 
        
        consulta.append(" FROM MAE_CLIEN MC, SEG_PAIS PA, MAE_CLIEN_TIPO_SUBTI CT, MAE_TIPO_CLIEN TC, ");
        consulta.append(" MAE_SUBTI_CLIEN SC ");
        
        consulta.append(" WHERE MC.PAIS_OID_PAIS = ? ");
        parametros.add(pais);
        
        consulta.append(" AND CT.CLIE_OID_CLIE = MC.OID_CLIE ");
        consulta.append(" AND CT.TICL_OID_TIPO_CLIE = TC.OID_TIPO_CLIE ");
        consulta.append(" AND CT.SBTI_OID_SUBT_CLIE = SC.OID_SUBT_CLIE ");
        consulta.append(" AND MC.PAIS_OID_PAIS = PA.OID_PAIS ");
        consulta.append(" AND SC.TICL_OID_TIPO_CLIE = TC.OID_TIPO_CLIE ");
           
        if(fechaActuacion != null){
            consulta.append(" AND CT.TICL_OID_TIPO_CLIE = ? ");
            parametros.add(ConstantesMAE.OID_TIPO_CLIENTE_CONSULTORA);

//          consulta.append(" AND (CT.FEC_ULTI_ACTU > TO_DATE( ? ,'YYYY-MM-DD')) ");
            consulta.append(" AND mc.FEC_ULTI_ACTU > TO_DATE(?,'YYYY-MM-DD HH24:MI:SS')");  
            parametros.add(formateaFechaTimestamp(fechaActuacion));
        }
        
        // Se ejecuta la consulta 
		BelcorpService bs = UtilidadesEJB.getBelcorpService();
		RecordSet resultado = null;
		String codigoError = null;
		try {
			resultado = bs.dbService.executePreparedQuery(consulta.toString(), 
				parametros);
		} catch (Exception e) {
            codigoError = CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS;
			UtilidadesLog.error("DAOECM.obtenerTipoClienteNovedad: Exception",e);
			this.logSql("DAOECM.obtenerTipoClienteNovedad. SQL: ",consulta.toString(),
				parametros);
            throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));
		}
        UtilidadesLog.info("DAOECM.obtenerTipoClienteNovedad(Date fechaActuacion, Long pais): Salida");
		return resultado;
        
    }
    
    public RecordSet obtenerClienteVinculosNovedad(Date fechaActuacion, Long pais) throws MareException{
        UtilidadesLog.info("DAOECM.obtenerClienteVinculosNovedad(Date fechaActuacion, Long pais): Entrada");

        //Documentation
        /* Se quiere consultar la entidad de MAE ClienteVinculo y obtener registros en los que haya habido alguna actualizacion posterior a */ 
        /* la fechaActuacion (ultima fecha de ejecución del interfaz) recibida como parametro, y para el pais activo */ 
        UtilidadesLog.debug("*** Método DAOECM.obtenerClienteVinculosNovedad: Entrada ***");
        Vector parametros = new Vector();
        // Se crea la consulta SQL
        StringBuffer consulta = new StringBuffer();
        
        consulta.append(" SELECT MC.COD_CLIE CODIGOCLIENTE, PA.COD_PAIS CODIGOPAIS, ");
        consulta.append(" TV.COD_TIPO_VINC CODIGOTIPOVINCULO, MC.COD_CLIE CODIGOCLIENTEVINCULO, "); // (join a traves de CLIE_OID_CLIE_VNDO) 
        consulta.append(" FEC_DESD FECHADESDE, FEC_HAST FECHAHASTA, IND_VINC_PPAL INDVINCULOPRINCIPAL "); 
        
        consulta.append(" FROM MAE_CLIEN MC, SEG_PAIS PA, MAE_CLIEN_TIPO_SUBTI CT,MAE_CLIEN_VINCU CV, ");
        consulta.append(" MAE_TIPO_VINCU TV  ");
        
        consulta.append(" WHERE MC.PAIS_OID_PAIS = ?");
        parametros.add(pais);
       
        consulta.append(" AND CT.CLIE_OID_CLIE = MC.OID_CLIE ");
        //consulta.append(" AND CV.CLIE_OID_CLIE_VNTE = MC.OID_CLIE ");
        consulta.append(" AND CV.CLIE_OID_CLIE_VNDO = MC.OID_CLIE ");
        consulta.append(" AND CV.TIVC_OID_TIPO_VINC = TV.OID_TIPO_VINC ");
        consulta.append(" AND MC.PAIS_OID_PAIS = PA.OID_PAIS ");
           
        if(fechaActuacion != null){
            consulta.append(" AND CT.TICL_OID_TIPO_CLIE = ? ");
            parametros.add(ConstantesMAE.OID_TIPO_CLIENTE_CONSULTORA);

            //consulta.append(" AND (CT.FEC_ULTI_ACTU > TO_DATE( ? ,'YYYY-MM-DD')) ");
            consulta.append(" AND mc.FEC_ULTI_ACTU > TO_DATE(?,'YYYY-MM-DD HH24:MI:SS')");  
            parametros.add(formateaFechaTimestamp(fechaActuacion));
        }
        
        // Se ejecuta la consulta 
		BelcorpService bs = UtilidadesEJB.getBelcorpService();
		RecordSet resultado = null;
		String codigoError = null;
		try {
			resultado = bs.dbService.executePreparedQuery(consulta.toString(), 
				parametros);
		} catch (Exception e) {
            codigoError = CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS;
			UtilidadesLog.error("DAOECM.obtenerClienteVinculosNovedad: Exception",e);
			this.logSql("DAOECM.obtenerClienteVinculosNovedad. SQL: ",consulta.toString(),
				parametros);
            throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));
		}
        UtilidadesLog.info("DAOECM.obtenerClienteVinculosNovedad(Date fechaActuacion, Long pais): Salida");
		return resultado;    
        
    }
    
    public RecordSet obtenerFechaUltimaEjecucion (Long pais, String codInterfaz) throws MareException{

        //Documentation
        /* Se quiere obtener la máxima fecha de ejecución de la interfaz ECM-3 */ 
        UtilidadesLog.info("DAOECM.obtenerFechaUltimaEjecucion(Long pais, String codInterfaz): Entrada");
        Vector parametros = new Vector();
        // Se crea la consulta SQL
        StringBuffer consulta = new StringBuffer();
        
        consulta.append(" SELECT HL.FEC_FIN_PROC ULTIMAFECHA ");
        consulta.append(" FROM INT_HISTO_LOTES HL ");
        consulta.append(" WHERE HL.COD_INTE =  ? "); //codInterfaz 
        parametros.add(codInterfaz);
        consulta.append(" AND  HL.PAIS_OID_PAIS = ? "); //pais 
        parametros.add(pais);
        consulta.append(" ORDER BY HL.FEC_FIN_PROC DESC ");
        
        // Se ejecuta la consulta 
		BelcorpService bs = UtilidadesEJB.getBelcorpService();
		RecordSet resultado = null;
		String codigoError = null;
		try {
			resultado = bs.dbService.executePreparedQuery(consulta.toString(), 
				parametros);
		} catch (Exception e) {
            codigoError = CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS;
			UtilidadesLog.error("DAOECM.obtenerFechaUltimaEjecucion: Exception",e);
			this.logSql("DAOECM.obtenerFechaUltimaEjecucion. SQL: ",consulta.toString(),
				parametros);
            throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));
		}
        UtilidadesLog.info("DAOECM.obtenerFechaUltimaEjecucion(Long pais, String codInterfaz): Salida");
		return resultado;    
    }
             
    public RecordSet obtenerTipoParticipante(Long cliente,Long concurso) throws MareException{
        UtilidadesLog.info("DAOECM.obtenerTipoParticipante(Long cliente): Entrada");
        //Documentation
        /* Se quiere consultar INC:ParticipantesConcursoDetalle para el cliente recibido */ 
        Vector parametros = new Vector();
        // Se crea la consulta SQL
        StringBuffer consulta = new StringBuffer();
        
        consulta.append(" SELECT PC.OID_PART_CONC_DETA OIDPARTICIPANTE "); 
        consulta.append(" FROM INC_PARTI_CONCU_DETAL PC,  V_MAE_TIPIF_CLIEN VC,INC_CLASI_PARTI_CONCU icpc,INC_PARTI_CONCU_CABEC ipcc ");        
        consulta.append(" WHERE VC.CLIE_OID_CLIE = ? ");
        parametros.add(cliente);
        consulta.append(" AND icpc.COPA_OID_PARA_GRAL =  ? ");
        parametros.add(concurso);
		consulta.append(" AND icpc.PACI_OID_PART_CONC_CABE = ipcc.OID_PART_CONC_CABE AND ipcc.OID_PART_CONC_CABE = pc.PACI_OID_PART_CONC_CABE ");
        consulta.append(" AND (PC.TICL_OID_TIPO_CLIE IS NULL OR PC.TICL_OID_TIPO_CLIE = VC.TICL_OID_TIPO_CLIE) ");
        consulta.append(" AND (PC.SBTI_OID_SUBT_CLIE IS NULL OR PC.SBTI_OID_SUBT_CLIE = VC.SBTI_OID_SUBT_CLIE) ");
        consulta.append(" AND (PC.TCCL_OID_TIPO_CLAS IS NULL OR PC.TCCL_OID_TIPO_CLAS = VC.TCCL_OID_TIPO_CLASI) ");
        consulta.append(" AND (PC.CLAS_OID_CLAS IS NULL OR PC.CLAS_OID_CLAS = VC.CLAS_OID_CLAS) ");
        
        // Se ejecuta la consulta 
		BelcorpService bs = UtilidadesEJB.getBelcorpService();
		RecordSet resultado = null;
		String codigoError = null;
		try {
			resultado = bs.dbService.executePreparedQuery(consulta.toString(), 
				parametros);
		} catch (Exception e) {
            codigoError = CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS;
			UtilidadesLog.error("DAOECM.obtenerTipoParticipante: Exception",e);
			this.logSql("DAOECM.obtenerTipoParticipante. SQL: ",consulta.toString(),
				parametros);
            throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));
		}
        UtilidadesLog.info("DAOECM.obtenerTipoParticipante(Long cliente): Salida");
		return resultado;    
    }
    
    public RecordSet obtenerProximaFechaFacturacion(Long concurso, Long oidZona) throws MareException{
        UtilidadesLog.info("DAOECM.obtenerProximaFechaFacturacion(Long concurso, Long oidZona): Entrada");
        //Documentation
        /* Se quiere consultar CRA:Cronograma para el concurso y zona recibidos */ 
        
        Vector parametros = new Vector();
        // Se crea la consulta SQLs
        StringBuffer consulta = new StringBuffer();
        
        consulta.append(" SELECT CR.PERD_OID_PERI PERIODO, CR.FEC_INIC FECHAINICIO, CR.FEC_FINA FECHAFINAL ");
        consulta.append(" FROM CRA_CRONO CR, INC_CONCU_PARAM_GENER CO, SEG_PAIS PA, CRA_ACTIV AC, CRA_PERIO CP, CRA_CLASE_ACTIV CL ");
       
        consulta.append(" WHERE CO.OID_PARA_GRAL =  ? "); //concurso
        parametros.add(concurso);
        consulta.append(" AND PA.OID_PAIS = CO.PAIS_OID_PAIS ");
        consulta.append(" AND CP.PAIS_OID_PAIS = CO.PAIS_OID_PAIS ");
        consulta.append(" AND CP.MARC_OID_MARC = CO.MARC_OID_MARC "); 
        consulta.append(" AND CP.CANA_OID_CANA = CO.CANA_OID_CANA ");
        consulta.append(" AND CR.ZZON_OID_ZONA = ? "); //oidZona 
        parametros.add(oidZona);
        consulta.append(" AND AC.CLAC_OID_CLAS_ACTI = CL.OID_CLAS_ACTI ");
        consulta.append(" AND CL.COD_CLAS_ACTI = ? "); //ConstantesCRA.COD_CLASE_ACTIVIDAD_FACTURACION
        parametros.add(ConstantesCRA.COD_CLASE_ACTIVIDAD_FACTURACION);      
        consulta.append(" AND CR.CACT_OID_ACTI = AC.OID_ACTI ");
        consulta.append(" AND CR.PERD_OID_PERI = CP.OID_PERI ");
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date fechaActual = new Date(System.currentTimeMillis());
        String sFecha = sdf.format(fechaActual);
        consulta.append(" AND (CR.FEC_INIC - PA.NUM_DIAS_FACT <= TO_DATE( ? ,'YYYY-MM-DD')) "); 
        parametros.add(sFecha);
        consulta.append(" AND (CR.FEC_INIC + PA.NUM_DIAS_FACT > TO_DATE( ? ,'YYYY-MM-DD')) ");
        parametros.add(sFecha);
        //- cr.FEC_INIC - pa.NUM_DIAS_FACT<= fecha actual < cr.FEC_INIC+ pa.NUM_DIAS_FACT 
        
        consulta.append(" ORDER BY CR.FEC_INIC ASC "); 
       
        // Se ejecuta la consulta 
		BelcorpService bs = UtilidadesEJB.getBelcorpService();
		RecordSet resultado = null;
		String codigoError = null;
		try {
			resultado = bs.dbService.executePreparedQuery(consulta.toString(), 
				parametros);
		} catch (Exception e) {
            codigoError = CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS;
			UtilidadesLog.error("DAOECM.obtenerProximaFechaFacturacion: Exception",e);
			this.logSql("DAOECM.obtenerProximaFechaFacturacion. SQL: ",consulta.toString(),
				parametros);
            throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));
		}
        UtilidadesLog.info("DAOECM.obtenerProximaFechaFacturacion(Long concurso, Long oidZona): Salida");
		return resultado; 
    } 
  
  /**
   * Recupera los concursos que se encuentran activos, vigentes y que son dirigidos
   * a Consultoras, a partir de una fecha que se pasa como parametro.
   * Modificaciones:
   *  - 27/06/2006 eiraola DBLG400001109 Ya no se filtra por oidPeriodo sino por
   *    la fecha directamente para evitar problemas de solapamientos.
   */
  public RecordSet obtenerConcursos(DTOPeriodo dto) throws MareException {
      UtilidadesLog.info("DAOECM.obtenerConcursos(DTOPeriodo dto): Entrada");

      StringBuffer consulta = new StringBuffer();
      Vector parametros = new Vector();


      consulta.append(" SELECT CO.OID_PARA_GRAL CONCURSO, ");
      consulta.append("        CO.NUM_CONC NUMCONCURSO, ");
      consulta.append("        PLA.VAL_AMBI_GEOG_COMP AMBITOGEOCOMP, ");        // Se agrega por Inc. BELC300022779  06/04/2006  alorenzo
      consulta.append("        PLA.VAL_PART PARTICIPANTESCOMPLETO ");           // Se agrega por Inc. BELC300022779  06/04/2006  alorenzo
      consulta.append("   FROM INC_CONCU_PARAM_GENER CO, ");
      consulta.append("        CRA_PERIO PERD, ");
      consulta.append("        CRA_PERIO PERH, "); 
      //consulta.append("        CRA_PERIO PER, ");                             // Se elimina por DBLG400001109 27/06/2006 eiraola
      consulta.append("        INC_PLANT_CONCU PLA, ");                         // Se agrega por Inc. BELC300022779  06/04/2006  alorenzo
      consulta.append("        INC_VERSI_CONCU VC ");                           // Se agrega por DBLG400001109 27/06/2006 eiraola
      consulta.append("  WHERE CO.PAIS_OID_PAIS = ? ");
      parametros.add(dto.getPais());

      if(dto.getMarca() != null){
          consulta.append("    AND CO.MARC_OID_MARC = ? ");
          parametros.add(dto.getMarca());
      }
      if(dto.getCanal() != null){
          consulta.append("    AND CO.CANA_OID_CANA = ? ");
          parametros.add(dto.getCanal());
      }
      consulta.append("        AND CO.PERD_OID_PERI_DESD = PERD.OID_PERI ");
      consulta.append("        AND CO.PERD_OID_PERI_HAST = PERH.OID_PERI ");
      
      if (dto.getFechaInicio() != null) {                                          // Se agrega por DBLG400001109 27/06/2006 eiraola
          SimpleDateFormat formatoFecha = new SimpleDateFormat("yyyy-MM-dd");      // Se agrega por DBLG400001109 27/06/2006 eiraola
          String sFechaInicio = formatoFecha.format(dto.getFechaInicio());         // Se agrega por DBLG400001109 27/06/2006 eiraola
          UtilidadesLog.debug("sql.Date fechaInicio_" + dto.getFechaInicio() + "    String sfechaInicio_" + sFechaInicio);
          
          consulta.append("    AND PERD.FEC_INIC <= TO_DATE( ? , 'YYYY-MM-DD') "); // Se agrega por DBLG400001109 27/06/2006 eiraola
          parametros.add(sFechaInicio);                                            // Se agrega por DBLG400001109 27/06/2006 eiraola
          consulta.append("    AND PERH.FEC_FINA >= TO_DATE( ? , 'YYYY-MM-DD') "); // Se agrega por DBLG400001109 27/06/2006 eiraola
          parametros.add(sFechaInicio);                                            // Se agrega por DBLG400001109 27/06/2006 eiraola
      }
      /*if(dto.getOidPeriodoCorporativo() != null){
          consulta.append("    AND PER.OID_PERI = ? ");
          parametros.add(dto.getOidPeriodoCorporativo());
      }
      consulta.append("        AND PERD.FEC_INIC <= PER.FEC_INIC ");
      consulta.append("        AND PERH.FEC_FINA >= PER.FEC_FINA ");*/
      consulta.append("        AND CO.IND_ACTI = 1 ");
      consulta.append("        AND CO.DIRI_OID_DIRI = ? ");
      parametros.add(ConstantesINC.OID_DIRIGIDO_A_CONSULTORAS);

      consulta.append("        AND CO.BCAL_OID_BASE_CALC = ? ");
      parametros.add(ConstantesINC.OID_BASE_CALCULO_MONTO);
      
      // vbongiov -- Cambio 20080809 -- 7/04/2009
      consulta.append("        AND (CO.IND_NO_GENE_PUNT = 0 OR CO.IND_NO_GENE_PUNT IS NULL) ");

      consulta.append("        AND PLA.OID_PLAN_CONC(+) = CO.PLC2_OID_PLAN_CONC ");  // Se agrega por Inc. BELC300022779  06/04/2006  alorenzo
      
      consulta.append("        AND CO.OID_PARA_GRAL = VC.COPA_OID_PARA_GRAL_ORIG "); // Se agrega por DBLG400001109 27/06/2006 eiraola
      consulta.append("        AND (VC.VICO_OID_VIGE_CONC = ? ");                    // Se agrega por DBLG400001109 27/06/2006 eiraola
      parametros.add(ConstantesINC.OID_VIG_CONCU_VIGENTE);     // 1                  // Se agrega por DBLG400001109 27/06/2006 eiraola
      consulta.append("             OR VC.VICO_OID_VIGE_CONC = ? ) ");               // Se agrega por DBLG400001109 27/06/2006 eiraola
      parametros.add(ConstantesINC.OID_VIG_CONCU_EN_PROCESO);  // 3                  // Se agrega por DBLG400001109 27/06/2006 eiraola

         
      BelcorpService bs = UtilidadesEJB.getBelcorpService();

      RecordSet rs = null;

      String codigoError = null;

      try {

          rs =bs.dbService.executePreparedQuery(consulta.toString(),parametros);

      } catch (Exception e) {

          codigoError = CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS;

          UtilidadesLog.error(" obtenerConcursos: Exception",e);

          this.logSql(" obtenerConcursos. SQL: ",consulta.toString(),parametros);

          throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));

      } //catch

      UtilidadesLog.debug("Cantidad de registros recuperados: " + rs.getRowCount());
      UtilidadesLog.info("DAOECM.obtenerConcursos(DTOPeriodo dto): Salida");
      
      return rs;

  }
	 
	 public RecordSet obtenerRecepcionVentasTodas(DTOINT dto) throws MareException {


         UtilidadesLog.info("DAOECM.obtenerRecepcionVentasTodas(DTOINT dto): Entrada");

         

         StringBuffer consulta = new StringBuffer();

         Vector parametros = new Vector();

         consulta.append(" SELECT rv.OID_RECE_VENT_ASOC OID, ");

		//Incidencia 14650 CORREGIDA
        consulta.append(" mc.PAIS_OID_PAIS PAIS, ");      // poner incidencia, esta columna no existe en tabla INT_RECEP_VENTA_ASOCI

        consulta.append(" rv.MARC_OID_MARC MARCA, ");

        consulta.append(" rv.CANA_OID_CANA CANAL, ");

        consulta.append(" rv.FEC_ORDE_INTE FECHA, ");

        consulta.append(" rv.CLIE_OID_CLIE CLIENTE ");

        consulta.append(" FROM INT_RECEP_VENTA_ASOCI rv,");
        consulta.append(" MAE_CLIEN mc ");

         consulta.append(" WHERE  rv.NUM_LOTE = ? ");

         parametros.add(dto.getNumeroLote());
		 consulta.append(" AND rv.clie_oid_clie = mc.oid_clie ");

         consulta.append(" AND rv.COD_INTE = ? ");

         parametros.add(IGestorInterfaces.COD_INTERFAZ_ECM1);

         

         BelcorpService bs = UtilidadesEJB.getBelcorpService();

         RecordSet rs = null;

         String codigoError = null;

         try{

           rs =bs.dbService.executePreparedQuery(consulta.toString(),parametros);

         }catch (Exception e) {

            codigoError = CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS;

           UtilidadesLog.error(" obtenerRecepcionVentasTodas: Exception",e);

            this.logSql(" obtenerRecepcionVentasTodas. SQL: ",consulta.toString(),parametros);

            throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));

         }//catch

         UtilidadesLog.info("DAOECM.obtenerRecepcionVentasTodas(DTOINT dto): Salida");

         return rs;

     }

	public RecordSet obtenerClienteIdentificacionNovedad (Date fechaActuacion, Long pais) throws MareException{
        UtilidadesLog.info("DAOECM.obtenerClienteIdentificacionNovedad(Date fechaActuacion, Long pais): Entrada");
        
        StringBuffer sql = new StringBuffer();
        Vector parametros = new Vector();
        sql.append(" SELECT mc.COD_CLIE as CODIGOCLIENTE, ");
        sql.append(" pa.COD_PAIS as CODIGOPAIS, ");
        sql.append(" td.COD_TIPO_DOCU as TIPODOCUMENTO, ");
        sql.append(" ci.NUM_DOCU_IDEN as NUMERODOCUMENTO ");
        //FROM
        sql.append(" FROM MAE_CLIEN mc , SEG_PAIS pa , ");
        sql.append(" MAE_CLIEN_TIPO_SUBTI ct , MAE_CLIEN_IDENT ci , ");
        sql.append(" MAE_TIPO_DOCUM td ");
        //WHERE
        sql.append(" WHERE mc.PAIS_OID_PAIS = pa.OID_PAIS ");
        sql.append(" AND mc.PAIS_OID_PAIS = ? ");
        parametros.add(pais);
        sql.append(" AND ci.CLIE_OID_CLIE = mc.OID_CLIE ");
        sql.append(" AND ct.CLIE_OID_CLIE = mc.OID_CLIE ");
        sql.append(" AND ci.TDOC_OID_TIPO_DOCU = td.OID_TIPO_DOCU ");
        sql.append(" AND td.PAIS_OID_PAIS = pa.OID_PAIS ");
         

        if (fechaActuacion != null){
            sql.append(" AND ct.TICL_OID_TIPO_CLIE = ? ");
            parametros.add(ConstantesMAE.OID_TIPO_CLIENTE_CONSULTORA);
            //Incidencia BELC300014642
            //sql.append(" AND ci.FEC_ULTI_ACTU > TO_DATE( ? ,'YYYY-MM-DD') ");
            sql.append(" AND mc.FEC_ULTI_ACTU > TO_DATE(?,'YYYY-MM-DD HH24:MI:SS')");  
            parametros.add(formateaFechaTimestamp(fechaActuacion));

        }

        RecordSet rs = null;
        BelcorpService bs = BelcorpService.getInstance();
        try{
            rs = bs.dbService.executePreparedQuery(sql.toString(), parametros);
        }catch(Exception e){
            String error = CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS;
            throw new MareException(e, UtilidadesError.armarCodigoError(error));
        }
        
        UtilidadesLog.info("DAOECM.obtenerClienteIdentificacionNovedad(Date fechaActuacion, Long pais): Salida");
        return rs;
    }
	/**
     * 
     * Modificado: SICC-GCC-MAE-005 - Cleal
     * Se modifica la asignacion del nombreVia
     */
	public RecordSet obtenerClienteDireccionNovedad (Date fechaActuacion, Long pais) throws MareException{
        UtilidadesLog.info("DAOECM.obtenerClienteDireccionNovedad(Date fechaActuacion, Long pais): Entrada");
        
        StringBuffer sql = new StringBuffer();
        Vector parametros = new Vector();
        
        //SELECT
        sql.append("SELECT mc.COD_CLIE AS CODIGOCLIENTE, ");
        sql.append(" pa.COD_PAIS  AS CODIGOPAIS, ");
        sql.append(" tv.COD_TIPO_VIA AS TIPOVIA, ");
        /*//SICC-GCC-MAE-005 - Cleal
         * nombreVia = cd.VAL_NOMB_VIA  
         * Si cd.VAL_NOMB_VIA es nulo, se obtiene 
         * el valor ZVIA_OID_VIA, y con este valor (si no es nulo), se accede a ‘ZON Vías’
         * para obtener el nombre de la vía
         */
        //sql.append(" cd.VAL_NOMB_VIA AS NOMBREVIA, ");
        sql.append(" NVL(cd.VAL_NOMB_VIA, vi.NOM_VIA) AS NOMBREVIA, ");
        sql.append(" cd.NUM_PPAL AS NUMEROPRINCIPAL, ");
        sql.append(" cd.TERR_OID_TERR as TERRITORIO ");
        //FROM
        sql.append(" FROM MAE_CLIEN mc , SEG_PAIS pa , ");
        sql.append(" MAE_CLIEN_TIPO_SUBTI ct , MAE_CLIEN_DIREC cd , ");
        sql.append(" SEG_TIPO_VIA tv, ");
        sql.append(" ZON_VIA vi ");
        //WHERE 
        sql.append(" WHERE mc.PAIS_OID_PAIS = pa.OID_PAIS ");
        sql.append(" AND ct.CLIE_OID_CLIE = mc.OID_CLIE ");
        sql.append(" AND cd.CLIE_OID_CLIE = mc.OID_CLIE ");
        sql.append(" AND cd.ZVIA_OID_VIA = vi.OID_VIA");
        sql.append(" AND cd.TIVI_OID_TIPO_VIA = tv.OID_TIPO_VIA ");
        sql.append(" AND cd.IND_ELIM = 0 "); //agregado por Sapaza, incidencia V_MAE_08
        
        sql.append(" AND mc.PAIS_OID_PAIS = ? ");
        parametros.add(pais);
        
        if (fechaActuacion != null){
            sql.append(" AND ct.TICL_OID_TIPO_CLIE = ? ");
            parametros.add(ConstantesMAE.OID_TIPO_CLIENTE_CONSULTORA);
            //INCIDENCIA BELC300014645
            //sql.append(" AND cd.FEC_ULTI_ACTU > TO_DATE( ? ,'YYYY-MM-DD') ");
            sql.append(" AND mc.FEC_ULTI_ACTU > TO_DATE(?,'YYYY-MM-DD HH24:MI:SS')");  
            parametros.add(formateaFechaTimestamp(fechaActuacion));
        }

        RecordSet rs = null;
        BelcorpService bs = BelcorpService.getInstance();
        try{
            rs = bs.dbService.executePreparedQuery(sql.toString(), parametros);
        }catch(Exception e){
            String error = CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS;
            throw new MareException(e, UtilidadesError.armarCodigoError(error));
        }

        UtilidadesLog.info("DAOECM.obtenerClienteDireccionNovedad(Date fechaActuacion, Long pais): Salida");
        return rs;
    }
	
	public RecordSet obtenerClienteClasificacionNovedad (Date fechaActuacion, Long pais) throws MareException{
        UtilidadesLog.info("DAOECM.obtenerClienteClasificacionNovedad(Date fechaActuacion, Long pais): Entrada");
        
        StringBuffer sql = new StringBuffer();
        Vector parametros = new Vector();
        //SELECT
        sql.append(" SELECT mc.COD_CLIE AS CODIGOCLIENTE, ");
        sql.append(" pa.COD_PAIS AS CODIGOPAIS, ");
        sql.append(" tc.COD_TIPO_CLAS AS TIPOCLASIFICACION, ");
        sql.append(" cl.COD_CLAS AS CLASIFICACION ");
        //FROM
        sql.append(" FROM MAE_CLIEN mc , SEG_PAIS pa , ");
        sql.append(" MAE_CLIEN_TIPO_SUBTI ct , MAE_CLIEN_CLASI cc , ");
        sql.append(" MAE_CLASI cl , MAE_TIPO_CLASI_CLIEN tc ");
        //WHERE 
        sql.append(" WHERE mc.PAIS_OID_PAIS = pa.OID_PAIS ");
        sql.append(" AND ct.CLIE_OID_CLIE = mc.OID_CLIE ");
        sql.append(" AND cc.CLAS_OID_CLAS = cl.OID_CLAS ");
        sql.append(" AND cc.CTSU_OID_CLIE_TIPO_SUBT = ct.OID_CLIE_TIPO_SUBT ");
        sql.append(" AND cc.TCCL_OID_TIPO_CLASI = tc.OID_TIPO_CLAS ");
        
        sql.append(" AND mc.PAIS_OID_PAIS = ? ");
        parametros.add(pais);
        
        if (fechaActuacion != null){
            sql.append(" AND ct.TICL_OID_TIPO_CLIE = ? ");
            parametros.add(ConstantesMAE.OID_TIPO_CLIENTE_CONSULTORA);
            //INCIDENCIA BELC300014646
            //sql.append(" AND cc.FEC_ULTI_ACTU > TO_DATE( ? ,'YYYY-MM-DD') ");
            sql.append(" AND mc.FEC_ULTI_ACTU > TO_DATE(?,'YYYY-MM-DD HH24:MI:SS')");  
            parametros.add(formateaFechaTimestamp(fechaActuacion));
        }

        RecordSet rs = null;
        BelcorpService bs = BelcorpService.getInstance();
        try{
            rs = bs.dbService.executePreparedQuery(sql.toString(), parametros);
        }catch(Exception e){
            String error = CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS;
            throw new MareException(e, UtilidadesError.armarCodigoError(error));
        }
        
        UtilidadesLog.info("DAOECM.obtenerClienteClasificacionNovedad(Date fechaActuacion, Long pais): Salida");
        return rs;
    }
    
    public RecordSet obtenerDescalificacion (Long cliente, Long concurso) throws MareException{
        UtilidadesLog.info("DAOECM.obtenerDescalificacion(Long cliente, Long concurso): Entrada");
        
        StringBuffer sql = new StringBuffer();
        Vector parametros = new Vector();
        
        sql.append("SELECT id.OID_DESC AS OIDDESCALIFICACION ");
        sql.append(" FROM INC_DESCA id ");
        sql.append(" WHERE id.CLIE_OID_CLIE = ? ");
        parametros.add(cliente);
        sql.append(" AND id.COPA_OID_PARA_GRAL = ? ");
        parametros.add(concurso);
        
        RecordSet rs = null;
        BelcorpService bs = BelcorpService.getInstance();
        try{
            rs = bs.dbService.executePreparedQuery(sql.toString(), parametros);
        }catch(Exception e){
            String error = CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS;
            throw new MareException(e, UtilidadesError.armarCodigoError(error));
        }
        
        UtilidadesLog.info("DAOECM.obtenerDescalificacion(Long cliente, Long concurso): Salida");
        return rs;
    }
    
    /**
     * 
     * @throws es.indra.mare.common.exception.MareException
     * @return 
     * @param concurso
     * @param dto
     */
    public RecordSet obtenerConcursoPorUA (DTOUnidadAdministrativa dto, Long concurso) throws MareException{

        UtilidadesLog.info("DAOECM.obtenerConcursoPorUA(DTOUnidadAdministrativa dto, Long concurso): Entrada");
        StringBuffer sql = new StringBuffer();
        Vector parametros = new Vector();
        
        sql.append(" SELECT ag.OID_AMBITO_GEOGRAFICO AS OIDAMBITO ");
        sql.append(" FROM INC_AMBIT_GEOGR ag ");
        sql.append(" WHERE ag.COPA_OID_PARA_GRAL = ? ");
        parametros.add(concurso);
        sql.append(" AND (ag.TERR_OID_TERR = ? ");
        parametros.add(dto.getOidTerritorio());
        sql.append(" OR ag.TERR_OID_TERR IS NULL) ");
        sql.append(" AND (ag.ZSCC_OID_SECC = ? ");
        parametros.add(dto.getOidSeccion());
        sql.append(" OR ag.ZSCC_OID_SECC IS NULL) ");
        sql.append(" AND ");
        sql.append(" (ag.ZZON_OID_ZONA = ? ");
        parametros.add(dto.getOidZona());
        sql.append(" OR ag.ZZON_OID_ZONA IS NULL) ");
        sql.append(" AND (ag.ZORG_OID_REGI = ? ");
        parametros.add(dto.getOidRegion());
        sql.append(" OR ag.ZORG_OID_REGI IS NULL) ");
        sql.append(" AND (ag.ZSGV_OID_SUBG_VENT = ? ");
        parametros.add(dto.getOidSGV());
        sql.append(" OR ag.ZSGV_OID_SUBG_VENT IS NULL) ");

        RecordSet rs = null;
        BelcorpService bs = BelcorpService.getInstance();
        try{
            rs = bs.dbService.executePreparedQuery(sql.toString(), parametros);
        }catch(Exception e){
            String error = CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS;
            throw new MareException(e, UtilidadesError.armarCodigoError(error));
        }

        UtilidadesLog.info("DAOECM.obtenerConcursoPorUA(DTOUnidadAdministrativa dto, Long concurso): Salida");
        return rs;
    }
    
	public RecordSet obtenerClienteAnterioresNovedad (Date fechaActuacion, Long pais) throws MareException{
		UtilidadesLog.info("DAOECM.obtenerClienteAnterioresNovedad(Date fechaActuacion, Long pais): Entrada");
		
		StringBuffer sql = new StringBuffer();
        Vector parametros = new Vector();
		// Incidencia 15018 falta añadir el canal CORREGIDO
		sql.append("SELECT mc.cod_clie  CODIGOCLIENTE, pa.cod_pais CODIGOPAIS, ");
		sql.append("(SELECT p.cod_pais ");
		sql.append("FROM SEG_PAIS p ");
		sql.append("WHERE p.oid_pais = an.pais_oid_pais) AS CODIGOPAISANTIGUO, ");
		sql.append("an.cod_clie_anti CODIGOCLIENTEANTIGUO ");
		sql.append(" FROM MAE_CLIEN mc , SEG_PAIS pa , MAE_CLIEN_TIPO_SUBTI ct , MAE_CODIG_CLIEN_ANTER an ");
		sql.append(" WHERE mc.OID_CLIE = an.CLIE_OID_CLIE_NUEV AND mc.pais_oid_pais = pa.oid_pais AND ct.clie_oid_clie = mc.oid_clie ");
		sql.append(" AND mc.PAIS_OID_PAIS = ? ");
		parametros.add(pais);
		
		if (fechaActuacion != null){
            sql.append(" AND ct.TICL_OID_TIPO_CLIE = ? ");
            parametros.add(ConstantesMAE.OID_TIPO_CLIENTE_CONSULTORA);
            //sql.append(" AND an.FEC_ULTI_ACTU > TO_DATE( ? ,'YYYY-MM-DD') ");
            sql.append(" AND mc.FEC_ULTI_ACTU > TO_DATE(?,'YYYY-MM-DD HH24:MI:SS')");  
            parametros.add(formateaFechaTimestamp(fechaActuacion));

        }
		
		RecordSet rs = null;
        BelcorpService bs = BelcorpService.getInstance();
        try{
            rs = bs.dbService.executePreparedQuery(sql.toString(), parametros);
        }catch(Exception e){
            String error = CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS;
            throw new MareException(e, UtilidadesError.armarCodigoError(error));
        }
		
		UtilidadesLog.info("DAOECM.obtenerClienteAnterioresNovedad(Date fechaActuacion, Long pais): Salida");
		return rs;
	}
	
	public RecordSet obtenerClienteComunicacionNovedad (Date fechaActuacion, Long pais) throws MareException{
		UtilidadesLog.info("DAOECM.obtenerClienteComunicacionNovedad((Date fechaActuacion, Long pais): Entrada");
		
		StringBuffer sql = new StringBuffer();
        Vector parametros = new Vector();
		
		sql.append("SELECT mc.cod_clie CODIGOCLIENTE, pa.cod_pais CODIGOPAIS, tc.cod_tipo_comu CODIGOTIPOCOMUNICACION, co.val_text_comu TEXTOMEDIOCOMUNICACION ");
		sql.append(" FROM MAE_CLIEN mc , SEG_PAIS pa , MAE_CLIEN_TIPO_SUBTI ct , MAE_CLIEN_COMUN co , MAE_TIPO_COMUN tc ");
		sql.append(" WHERE mc.oid_clie = ct.clie_oid_clie AND mc.oid_clie = co.clie_oid_clie AND mc.pais_oid_pais = pa.oid_pais ");
		sql.append(" AND tc.oid_tipo_comu = co.ticm_oid_tipo_comu AND mc.pais_oid_pais = ? ");
		parametros.add(pais);
		
		if (fechaActuacion != null){
            sql.append(" AND ct.TICL_OID_TIPO_CLIE = ? ");
            parametros.add(ConstantesMAE.OID_TIPO_CLIENTE_CONSULTORA);
            //sql.append(" AND co.FEC_ULTI_ACTU > TO_DATE( ? ,'YYYY-MM-DD') ");
            sql.append(" AND mc.FEC_ULTI_ACTU > TO_DATE(?,'YYYY-MM-DD HH24:MI:SS')");  
            parametros.add(formateaFechaTimestamp(fechaActuacion));
        }
		
		
		RecordSet rs = null;
        BelcorpService bs = BelcorpService.getInstance();
        try{
            rs = bs.dbService.executePreparedQuery(sql.toString(), parametros);
        }catch(Exception e){
            String error = CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS;
            throw new MareException(e, UtilidadesError.armarCodigoError(error));
        }
		
		UtilidadesLog.info("DAOECM.obtenerClienteComunicacionNovedad((Date fechaActuacion, Long pais): Salida");
		return rs;
	}
	
    private String formateaFechaTimestamp(Date fecha){
        UtilidadesLog.info("DAOECM.formateaFechaTimestamp(Date fecha): Entrada");
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        java.sql.Date fechaDesde = new java.sql.Date(fecha.getTime());
        UtilidadesLog.info("DAOECM.formateaFechaTimestamp(Date fecha): Salida");
        return sdf.format(fechaDesde); 
    }

    private void logSql(String metodo, String sql, Vector params){
		UtilidadesLog.debug(metodo + sql);
		if (params!=null && params.size()>0) {
			String sParams="";
			for (int i=0; i<params.size();i++){
				sParams+="param "+ (i+1) + ": " + params.elementAt(i) + ", ";
			}
			UtilidadesLog.debug(metodo + sParams);
		}
	}    
    
    public RecordSet obtenerDatosCompletosClientesNovedad( DTOECMRecibir dtoe, Date fechaActuacion ) 
            throws MareException{
        UtilidadesLog.info("DAOECM.obtenerDatosCompletosClientesNovedad(): Entrada");
        RecordSet rs = new RecordSet();
        StringBuffer query = new StringBuffer();
        Vector parametros = new Vector();
        String fechaActuacionFormat = null;
        if ( fechaActuacion != null ){
            fechaActuacionFormat = formateaFechaTimestamp( fechaActuacion );
        }
        
        query.append(" SELECT  ");
        query.append(" 	MC.COD_CLIE                                   CODIGOCLIENTE,  ");
        query.append(" 	PA.COD_PAIS                                   CODIGOPAIS, ");
        query.append(" 	MC.VAL_APE1                                   APELLIDOPATERNO,  ");
        query.append(" 	MC.VAL_APE2                                   APELLIDOMATERNO, ");
        query.append(" 	MC.VAL_APEL_CASA                              APELLIDOCASADA, ");
        query.append(" 	MC.VAL_NOM1                                   NOMBREPRIMERO,  ");
        query.append(" 	MC.VAL_NOM2                                   NOMBRESEGUNDO,  ");
        query.append(" 	MC.COD_SEXO                                   SEXO, ");
        query.append(" 	CA.FEC_NACI                                   FECHANACIMIENTO, ");
        query.append(" 	PA.COD_PAIS                                   NACIONALIDAD,  ");
        query.append(" 	EC.COD_ESTA_CIVI                              ESTADOCIVIL,  ");
        query.append(" 	CA.VAL_PROF                                   PROFESION, ");
        query.append(" 	CA.VAL_OCUP                                   OCUPACION,  ");
        query.append(" 	CA.VAL_CENT_TRAB                              CENTROTRABAJO,  ");
        query.append(" 	CA.VAL_CARG_DESE                              CARGO,  ");
        query.append(" 	NE.COD_NIVE_ESTU                              NIVELESTUDIOS,  ");
        query.append(" 	CA.VAL_CENT_ESTU                              CENTROESTUDIOS, ");
        query.append(" 	CA.NUM_HIJO                                   NUMEROHIJOS, ");
        query.append(" 	TC1.COD_TIPO_CLIE                             TIPOCLIENTE,  ");
        query.append(" 	SC.COD_SUBT_CLIE                              SUBTIPOCLIENTE, ");
        
        query.append(" 	DECODE(TDO.COD_TIPO_DOCU, '01', TDO.COD_TIPO_DOCU, ");
        query.append("  NVL((SELECT TD.COD_TIPO_DOCU FROM MAE_CLIEN_IDENT CI, MAE_TIPO_DOCUM TD ");
        query.append("  WHERE MC.OID_CLIE = CI.CLIE_OID_CLIE ");
        query.append("  AND TD.OID_TIPO_DOCU = CI.TDOC_OID_TIPO_DOCU ");
        query.append("  AND TD.COD_TIPO_DOCU = '01' ),TDO.COD_TIPO_DOCU)) TIPODOCUMENTO, ");
        
        query.append("  DECODE(TDO.COD_TIPO_DOCU, '01', CID.NUM_DOCU_IDEN, ");
        query.append("  NVL((SELECT CI.NUM_DOCU_IDEN FROM MAE_CLIEN_IDENT CI, MAE_TIPO_DOCUM TD ");
		query.append("  WHERE MC.OID_CLIE = CI.CLIE_OID_CLIE ");
        query.append("  AND TD.OID_TIPO_DOCU = CI.TDOC_OID_TIPO_DOCU ");
        query.append("  AND TD.COD_TIPO_DOCU = '01' ),CID.NUM_DOCU_IDEN)) NUMERODOCUMENTO, ");
                                
        query.append(" 	TV.COD_TIPO_VIA                               TIPOVIA,  ");
        query.append(" 	NVL(CD.VAL_NOMB_VIA, VI.NOM_VIA)              NOMBREVIA,  ");
        query.append(" 	CD.NUM_PPAL                                   NUMEROPRINCIPAL,  ");
        query.append(" 	CD.COD_UNID_GEOG                              UBIGEO, ");
        query.append(" 	MA.COD_MARC                                   CODIGOMARCA, ");

        query.append(" 	PC.COD_TIPO_CONT                              CODIGOTIPOCONTACTO,  ");
        query.append(" 	PC.FEC_CONT                                   FECHACONTACTO, ");
        query.append(" 	TC2.COD_TIPO_COMU                             CODIGOTIPOCOMUNICACION,  ");
        query.append(" 	CO.VAL_TEXT_COMU                              TEXTOMEDIOCOMUNICACION, ");
        query.append(" 	TV2.COD_TIPO_VINC                             CODIGOTIPOVINCULO,  ");
                
        query.append(" 	(  ");
	    query.append(" 	SELECT  ");
		query.append(" 	   M.COD_CLIE  ");
		query.append(" 	FROM  ");
		query.append(" 	   MAE_CLIEN M  ");
		query.append(" 	WHERE  ");
		query.append(" 	M.OID_CLIE = CV.CLIE_OID_CLIE_VNTE  ");	
	    query.append(" 	)	   			  					          CODIGOCLIENTEVINCULO,  ");

        query.append(" 	CV.FEC_DESD                                   FECHADESDE, ");
        query.append(" 	CV.FEC_HAST                                   FECHAHASTA, ");
        query.append(" 	CV.IND_VINC_PPAL                              INDVINCULOPRINCIPAL, ");
        query.append(" 	EC1.COD_ESTA_CLIE                             ESTATUS ");
        query.append(" FROM  ");

        query.append(" MAE_CLIEN             MC, "); 	
        query.append(" MAE_CLIEN_COMUN       CO, "); 	
        query.append(" MAE_CLIEN_DATOS_ADICI CA, ");  	
        query.append(" MAE_CLIEN_DIREC       CD, "); 	
        query.append(" MAE_CLIEN_IDENT       CID,");	 	
        query.append(" MAE_CLIEN_MARCA       CM, ");  	
        query.append(" MAE_CLIEN_PRIME_CONTA PC, "); 	
        query.append(" MAE_CLIEN_TIPO_SUBTI  CT, "); 	
        query.append(" MAE_CLIEN_VINCU       CV, ");  	
        query.append(" MAE_CODIG_CLIEN_ANTER AN, "); 	
        query.append(" MAE_ESTAD_CIVIL       EC, ");  	
        query.append(" MAE_NIVEL_ESTUD       NE, "); 	
        query.append(" MAE_SUBTI_CLIEN       SC, ");
        query.append(" MAE_TIPO_CLIEN        TC1,"); 
        query.append(" MAE_TIPO_COMUN        TC2,"); 
        query.append(" MAE_TIPO_DOCUM        TDO,");
        query.append(" MAE_TIPO_VINCU        TV2,");
        query.append(" SEG_MARCA             MA, "); 	
        query.append(" SEG_PAIS              PA, "); 	
        query.append(" SEG_TIPO_VIA          TV, "); 	
        query.append(" ZON_VIA               VI, ");
        query.append(" MAE_ESTAT_CLIEN       EC1 "); 


        query.append(" WHERE  ");
        query.append("         MC.PAIS_OID_PAIS           = ? ");
        parametros.add( dtoe.getOidPais() );
        if(fechaActuacion != null){
        query.append("     AND ( ");
        query.append("           MC.FEC_ULTI_ACTU  > TO_DATE( ? ,'YYYY-MM-DD HH24:MI:SS') OR ");
        parametros.add( fechaActuacionFormat );
        query.append("           CO.FEC_ULTI_ACTU  > TO_DATE( ? ,'YYYY-MM-DD HH24:MI:SS') OR ");
        parametros.add( fechaActuacionFormat );
        query.append("           CA.FEC_ULTI_ACTU  > TO_DATE( ? ,'YYYY-MM-DD HH24:MI:SS') OR ");
        parametros.add( fechaActuacionFormat );
        query.append("           CD.FEC_ULTI_ACTU  > TO_DATE( ? ,'YYYY-MM-DD HH24:MI:SS') OR ");
        parametros.add( fechaActuacionFormat );
        query.append("           CID.FEC_ULTI_ACTU > TO_DATE( ? ,'YYYY-MM-DD HH24:MI:SS') OR ");
        parametros.add( fechaActuacionFormat );
        query.append("           CM.FEC_ULTI_ACTU  > TO_DATE( ? ,'YYYY-MM-DD HH24:MI:SS') OR ");
        parametros.add( fechaActuacionFormat );
        query.append("           PC.FEC_ULTI_ACTU  > TO_DATE( ? ,'YYYY-MM-DD HH24:MI:SS') OR ");
        parametros.add( fechaActuacionFormat );
        query.append("           CT.FEC_ULTI_ACTU  > TO_DATE( ? ,'YYYY-MM-DD HH24:MI:SS') OR ");
        parametros.add( fechaActuacionFormat );
        query.append("           CV.FEC_ULTI_ACTU  > TO_DATE( ? ,'YYYY-MM-DD HH24:MI:SS') ");
        parametros.add( fechaActuacionFormat );
        query.append("         ) ");
        }
        query.append("     AND CT.TICL_OID_TIPO_CLIE      = ? ");
        parametros.add( ConstantesMAE.OID_TIPO_CLIENTE_CONSULTORA );
        
        query.append(" AND MC.PAIS_OID_PAIS = PA.OID_PAIS                ");
        query.append(" AND MC.OID_CLIE = CT.CLIE_OID_CLIE                ");
        query.append(" AND MC.OID_CLIE = CA.CLIE_OID_CLIE(+)             ");
        query.append(" AND CA.NIED_OID_NIVE_ESTU = NE.OID_NIVE_ESTU(+)   ");     
        query.append(" AND CA.ESCV_OID_ESTA_CIVI = EC.OID_ESTA_CIVI(+)   ");     
        query.append(" AND CA.IND_ACTI = 1                               ");
        query.append(" AND CA.ESTA_OID_ESTA_CLIE = EC1.OID_ESTA_CLIE     ");   
        
        query.append("     AND EC1.COD_ESTA_CLIE         <> ? ");
        parametros.add( ConstantesMAE.ESTATUS_REGISTRADO );
        query.append("     AND EC1.COD_ESTA_CLIE         <> ? ");
        parametros.add( ConstantesMAE.ESTATUS_RETIRADO );

        query.append(" AND MC.OID_CLIE = CID.CLIE_OID_CLIE                 ");
        query.append(" AND CID.VAL_IDEN_DOCU_PRIN = 1                      ");
        query.append(" AND TDO.OID_TIPO_DOCU (+) = CID.TDOC_OID_TIPO_DOCU  ");            
        query.append(" AND CT.TICL_OID_TIPO_CLIE = TC1.OID_TIPO_CLIE(+)    ");    
        query.append(" AND CT.SBTI_OID_SUBT_CLIE = SC.OID_SUBT_CLIE        ");
        query.append(" AND TC1.OID_TIPO_CLIE = SC.TICL_OID_TIPO_CLIE(+)    ");    

        query.append("     AND ( ");
        query.append("      SC.COD_SUBT_CLIE          = ? ");
        parametros.add( ConstantesMAE.CODIGO_CONSULTORA_TIPO_NEGOCIO );
        query.append("      OR ");
        query.append("      SC.COD_SUBT_CLIE          = ? ");
        parametros.add( ConstantesMAE.CODIGO_CONSULTORA_TIPO_OFICINA );
        query.append("     ) ");

        query.append(" AND MC.OID_CLIE = CD.CLIE_OID_CLIE(+)               ");
        query.append(" AND CD.IND_ELIM = 0                                 ");
        query.append(" AND CD.IND_DIRE_PPAL = 1                            ");
        query.append(" AND CD.ZVIA_OID_VIA = VI.OID_VIA(+)                 ");
        query.append(" AND CD.TIVI_OID_TIPO_VIA = TV.OID_TIPO_VIA(+)       "); 
        query.append(" AND MC.OID_CLIE = CM.CLIE_OID_CLIE(+)               ");
        query.append(" AND CM.MARC_OID_MARC = MA.OID_MARC(+)               ");
        query.append(" AND MC.OID_CLIE = AN.CLIE_OID_CLIE_NUEV(+)          ");
        query.append(" AND MC.OID_CLIE = CO.CLIE_OID_CLIE(+)               ");
        query.append(" AND CO.TICM_OID_TIPO_COMU = TC2.OID_TIPO_COMU(+)    ");    
        query.append(" AND CO.IND_COMU_PPAL (+) = 1                        ");
        query.append(" AND MC.OID_CLIE = PC.CLIE_OID_CLIE(+)               ");
        query.append(" AND MC.OID_CLIE = CV.CLIE_OID_CLIE_VNDO(+)          ");
        query.append(" AND CV.TIVC_OID_TIPO_VINC = TV2.OID_TIPO_VINC(+)    ");    
        query.append(" AND CV.IND_VINC_PPAL (+) = 1                        ");
        
        try{
            rs = BelcorpService.getInstance().dbService.executePreparedQuery(query.toString(), parametros);
        }catch(Exception e){
            throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS));
        }
        UtilidadesLog.info("DAOECM.obtenerDatosCompletosClientesNovedad(): Salida");
        return rs;
    }

    /**
     * Agregado por HRCS - Fecha 10/09/2007 - Cambio Sicc20070385
     * @throws es.indra.mare.common.exception.MareException
     * @return 
     * @param descripcion
     * @param idioma
     * @param entidad
     */
    public Long obtenerOidDeDescripcion(String entidad, Long idioma, String descripcion) throws MareException{

        UtilidadesLog.info("DAOECM.obtenerOidDeDescripcion(String entidad, Long idioma, Long descripcion): Entrada");
        StringBuffer sql = new StringBuffer();
        Vector parametros = new Vector();
        
        sql.append(" select val_oid from v_gen_i18n_sicc ");
        sql.append(" where attr_enti like '"+entidad+"'");
        sql.append(" and idio_oid_idio = "+ idioma);
        sql.append(" and val_i18n='"+descripcion+"'");

        RecordSet rs = null;
        BelcorpService bs = BelcorpService.getInstance();
        try{
            rs = bs.dbService.executePreparedQuery(sql.toString(), parametros);
        }catch(Exception e){
            String error = CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS;
            throw new MareException(e, UtilidadesError.armarCodigoError(error));
        }
        
        Long r = null;
        if (!rs.esVacio())   {
            if (rs.getValueAt(0,0)!=null)
                r = new Long( ((java.math.BigDecimal)rs.getValueAt(0,0)).longValue() );
        }
        UtilidadesLog.info("DAOECM.obtenerOidDeDescripcion(String entidad, Long idioma, Long descripcion): Salida");
        return r;
    }
    
    /**
     * Agregado por HRCS - Fecha 10/09/2007 - Cambio Sicc20070385
     * @throws es.indra.mare.common.exception.MareException
     * @return 
     * @param oidCliente
     */
    public Long obtenerOidTipoSubtiParaContacto(Long oidCliente) throws MareException{

        UtilidadesLog.info("DAOECM.obtenerOidTipoSubtiParaContacto(Long oidCliente): Entrada");
        StringBuffer sql = new StringBuffer();
        Vector parametros = new Vector();
        
        sql.append(" select 1 as orden, oid_clie_tipo_subt ");
        sql.append(" from mae_clien_tipo_subti ");
        sql.append(" where clie_oid_clie="+oidCliente);
        sql.append(" and ind_ppal = " + ConstantesINT.INDICADOR_ACTIVO);
        sql.append(" UNION ");
        sql.append(" select 2 as orden, oid_clie_tipo_subt ");
        sql.append(" from mae_clien_tipo_subti ");
        sql.append(" where clie_oid_clie="+oidCliente);
        sql.append(" and ticl_oid_tipo_clie=(select oid_tipo_clie from mae_tipo_clien where cod_tipo_clie='"+ConstantesMAE.TIPO_CLIENTE_CONSULTORA+"') ");
        sql.append(" and (sbti_oid_subt_clie in (select oid_subt_clie from mae_subti_clien where ticl_oid_tipo_clie=");
        sql.append("     (select oid_tipo_clie from mae_tipo_clien where cod_tipo_clie='"+ConstantesMAE.TIPO_CLIENTE_CONSULTORA+"') and cod_subt_clie in ('"+ConstantesMAE.CODIGO_CONSULTORA_TIPO_NEGOCIO+"','"+ConstantesMAE.CODIGO_CONSULTORA_TIPO_OFICINA+"')) ) ");
        sql.append(" UNION ");
        sql.append(" select 3 as orden, oid_clie_tipo_subt ");
        sql.append(" from mae_clien_tipo_subti ");
        sql.append(" where clie_oid_clie=(select oid_clie from mae_clien where cod_clie like '%MIGRACION%') ");
        sql.append(" order by orden ");

        RecordSet rs = null;
        BelcorpService bs = BelcorpService.getInstance();
        try{
            rs = bs.dbService.executePreparedQuery(sql.toString(), parametros);
        }catch(Exception e){
            String error = CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS;
            throw new MareException(e, UtilidadesError.armarCodigoError(error));
        }
        
        Long r = null;
        if (!rs.esVacio())   {
            for(int i=0;i<rs.getRowCount();i++)   {
                if (rs.getValueAt(i,1)!=null)   {
                    r = new Long( ((java.math.BigDecimal)rs.getValueAt(i,1)).longValue() );
                    UtilidadesLog.info("Encontrando en fila ("+i+") con OID-TIPO-SUBTI: " + r);
                    break;
                }
            }
        }
        UtilidadesLog.info("DAOECM.obtenerOidTipoSubtiParaContacto(Long oidCliente): Salida");
        return r;
    }
    
    /**
     * Agregado por HRCS - Fecha 15/08/2007 - Cambio Sicc20070361
     * Metodo que busca si existe un vinculo Dupla Cyzone activo
     * @throws es.indra.mare.common.exception.MareException
     * @return Oid del Cliente Vinculo
     * @param fecha
     * @param cliente
     */
    public Long buscarClienteVinculoRecomendante(Long cliente, Date fecha ) throws MareException {
        Long oid = null;
        RecordSet rs = null;
        SimpleDateFormat formatter = new SimpleDateFormat ("dd/MM/yyyy");
        StringBuffer query = new StringBuffer();
        query.append(" SELECT oid_clie_vinc ");
        query.append(" FROM mae_clien_vincu ");
        query.append(" WHERE tivc_oid_tipo_vinc=(select oid_tipo_vinc from mae_tipo_vincu where cod_tipo_vinc='"+ConstantesMAE.COD_TIPO_VINCULO_RECOMENDANTE+"')");
        query.append(" AND clie_oid_clie_vndo = " + cliente);
        query.append(" AND fec_desd <= to_date('"+formatter.format(fecha)+"', 'dd/mm/yyyy') ");
        query.append(" AND fec_hast >= to_date('"+formatter.format(fecha)+"', 'dd/mm/yyyy') ");

        try {
            rs = BelcorpService.getInstance().dbService.executeStaticQuery(query.toString());
        } catch (Exception exception) {
            UtilidadesLog.error(exception);
            throw new MareException(exception, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS));
        }
        
        if (rs!=null && !rs.esVacio())  {
            oid = new Long( ((BigDecimal)rs.getValueAt(0,0)).longValue() );
            UtilidadesLog.debug("Oid MAE_CLIEN_VINCU: "+oid );
        }
        return oid;
    }
    
    /**
     * Nuevo metodo que obtiene el OID del Tipo de Direccion
     * Agregado por HRCS - Fecha 11/09/2007 - Cambio Sicc20070385
     * @throws es.indra.mare.common.exception.MareException
     * @return 
     * @param codigoTipoDireccion
     */
    public Long obtenerOidTipoDireccion(String codigoTipoDireccion) throws MareException{

        UtilidadesLog.info("DAOECM.obtenerOidTipoDireccion(String codigoTipoDireccion): Entrada");
        StringBuffer sql = new StringBuffer();
        Vector parametros = new Vector();
        sql.append(" select oid_tipo_dire from mae_tipo_direc where cod_tipo_dire='"+codigoTipoDireccion+"'");

        RecordSet rs = null;
        BelcorpService bs = BelcorpService.getInstance();
        try{
            rs = bs.dbService.executePreparedQuery(sql.toString(), parametros);
        }catch(Exception e){
            String error = CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS;
            throw new MareException(e, UtilidadesError.armarCodigoError(error));
        }
        
        Long r = null;
        if (rs!=null && !rs.esVacio())   {
            if (rs.getValueAt(0,0)!=null)   {
                r = new Long( ((java.math.BigDecimal)rs.getValueAt(0,0)).longValue() );
            }
        }
        UtilidadesLog.info("DAOECM.obtenerOidTipoDireccion(String codigoTipoDireccion): Salida");
        return r;
    }

    /**
     * Agregado por HRCS - Fecha 12/09/2007 - Cambio Sicc20070385
     * @throws es.indra.mare.common.exception.MareException
     * @param oidClienteDireccion
     */
    public void eliminarDireccionCliente(Long oidClienteDireccion) throws MareException{

        UtilidadesLog.info("DAOECM.eliminarDireccionCliente(Long oidClienteDireccion): Entrada");
        StringBuffer sql = new StringBuffer();
        Vector parametros = new Vector();
        //  Eliminando la direccion para el cliente
        sql.append("UPDATE mae_clien_direc SET ind_elim="+ConstantesINT.INDICADOR_ACTIVO+" WHERE oid_clie_dire=" + oidClienteDireccion );

        BelcorpService bs = BelcorpService.getInstance();
        try{
            bs.dbService.executePreparedUpdate(sql.toString(), parametros);
        }catch(Exception e){
            String error = CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS;
            throw new MareException(e, UtilidadesError.armarCodigoError(error));
        }
        UtilidadesLog.info("DAOECM.eliminarDireccionCliente(Long oidClienteDireccion): Salida");
    }
    
    public Long obtenerOidClienteComunicacionPrincipal(Long oidCliente) throws MareException{

        UtilidadesLog.info("DAOECM.obtenerOidClienteComunicacionPrincipal(Long oidCliente): Entrada");
        StringBuffer sql = new StringBuffer();
        Vector parametros = new Vector();
        sql.append("select oid_clie_comu from mae_clien_comun where clie_oid_clie="+oidCliente+" and ind_comu_ppal="+ConstantesINT.INDICADOR_ACTIVO);

        RecordSet rs = null;
        BelcorpService bs = BelcorpService.getInstance();
        try{
            rs = bs.dbService.executePreparedQuery(sql.toString(), parametros);
        }catch(Exception e){
            String error = CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS;
            throw new MareException(e, UtilidadesError.armarCodigoError(error));
        }
        
        Long r = null;
        if (rs!=null && !rs.esVacio())   {
            if (rs.getValueAt(0,0)!=null)   {
                r = new Long( ((java.math.BigDecimal)rs.getValueAt(0,0)).longValue() );
            }
        }
        UtilidadesLog.info("DAOECM.obtenerOidClienteComunicacionPrincipal(Long oidCliente): Salida");
        return r;
    }


  /*
   * 
   * Metodo creado por SICC20070528 - Rafael Romero - 19/12/2007
   * 
   */
    public boolean existenUAsPorConcurso (Long concurso) throws MareException{
        boolean retorno = true;

        UtilidadesLog.info("DAOECM.obtenerConcursoPorUA(DTOUnidadAdministrativa dto, Long concurso): Entrada");
        StringBuffer sql = new StringBuffer();
        Vector parametros = new Vector();
        
        sql.append(" SELECT ag.OID_AMBITO_GEOGRAFICO AS OIDAMBITO ");
        sql.append(" FROM INC_AMBIT_GEOGR ag ");
        sql.append(" WHERE ag.COPA_OID_PARA_GRAL = ? ");
        parametros.add(concurso);

        BelcorpService bs = BelcorpService.getInstance();
        try{
            RecordSet rs = bs.dbService.executePreparedQuery(sql.toString(), parametros);
            
            if(rs.esVacio()) retorno = false;
            
        }catch(Exception e){
            String error = CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS;
            throw new MareException(e, UtilidadesError.armarCodigoError(error));
        }

        UtilidadesLog.info("DAOECM.obtenerConcursoPorUA(DTOUnidadAdministrativa dto, Long concurso): Salida");
        return retorno;
    }

}