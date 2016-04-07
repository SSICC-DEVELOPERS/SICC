/**
 * Copyright 2004 © por Indra Sistemas,S.A.. Todos los derechos reservados.
 * Avda. de Bruselas, 35
 * Parque Empresarial Arroyo de la Vega
 * 28108 Alcobendas, Madrid
 * España
 *
 * Privado y Confidencial.
 * La información contenida en este documento es propiedad de Indra sistemas.
 * Para uso exclusivo de empleados autorizados no permitiéndose
 * la distribución de este código sin permiso expreso.
 */

package es.indra.sicc.logicanegocio.fac;

import es.indra.mare.common.exception.MareException;
import es.indra.mare.common.mii.MareMii;
import es.indra.mare.common.mii.MareMiiServiceNotFoundException;
import es.indra.mare.common.mii.MareTopic;
import es.indra.mare.common.mii.services.jdbcservice.RecordSet;
import es.indra.mare.common.mii.services.logging.LoggingService;
import es.indra.sicc.dtos.fac.DTOFACCabeceraSolicitud;
import es.indra.sicc.dtos.fac.DTOFACConsolidado;
import es.indra.sicc.dtos.fac.DTOFACPosicionSolicitud;
import es.indra.sicc.dtos.fac.DTOFleteFAC;
import es.indra.sicc.logicanegocio.bel.ConstantesBEL;
import es.indra.sicc.logicanegocio.ped.ConstantesPED;
import es.indra.sicc.logicanegocio.seg.ConstantesSEG;
import es.indra.sicc.util.BelcorpService;
import es.indra.sicc.util.CodigosError;
import es.indra.sicc.util.SecuenciadorOID;
import es.indra.sicc.util.UtilidadesEJB;
import es.indra.sicc.util.UtilidadesError;
import es.indra.sicc.util.UtilidadesLog;
import es.indra.sicc.util.RecuperadorIdiomaDefectoServidor;

import java.math.BigDecimal;

import java.text.SimpleDateFormat;

import java.util.ArrayList;
import java.util.Date;
import java.util.Vector;

import org.apache.commons.logging.Log;

public class DAOSolicitudCabecera  {
    private UtilidadesLog log = new UtilidadesLog();
    
    public DAOSolicitudCabecera() {
    }

	/*
	 * rgiorgi - 23-08-2005: incidencia Peru FAC-01. Se cambia el IND_OC
	 * */
public ArrayList obtenerSolicitudesNoPrevistas (ArrayList dtoe, Date fechaFacturacion, Long oidGP)  throws MareException { 

                UtilidadesLog.info("DAOSolicitudCabecera.obtenerSolicitudesNoPrevistas (ArrayList dtoe, Date fechaFacturacion, Long oidGP): Entrada");
        // Obtiene de BD las solicitudes que no han sido enviadas por el monitor, pero que 
        // también han de ser consolidadas 
         //- crea una lista temporal: ArrayList listaTemporal 

                
                /* 
                StringBuffer oids = new StringBuffer(""); 
                String solicitudString = ""; 
                Iterator itDtoe = dtoe.iterator(); 
                while(itDtoe.hasNext()){ 
                        DTOFACCabeceraSolicitud dtoCS = (DTOFACCabeceraSolicitud)itDtoe.next(); 
                        oids.append(dtoCS.getOidCabeceraSolicitud()+", "); 
                } 
                solicitudString = oids.substring(0,oids.length()-2); 
                */         
        ArrayList listaTemporal = new ArrayList(); 
        //- recupera los registros de BD: 

                Vector parametros = new Vector(); 
                StringBuffer sql=new StringBuffer(); 

                ArrayList aux = new ArrayList(); 
                for (int j=0;j<dtoe.size();j++){ 
                        aux.add(((DTOFACCabeceraSolicitud)dtoe.get(j)).getOidCabeceraSolicitud()); 
                } 
                //String niapa = this.convertirArrayToString(aux); 

                sql.append(" SELECT "); 
                sql.append(" SC.ACFI_OID_ACCE_FISI as ACCESOFISICO, "); 
                sql.append(" SC.ALMC_OID_ALMA as ALMACEN, "); 
                sql.append(" SC.CLSO_OID_CLAS_SOLI as CLASESOLICITUD, "); 
                sql.append(" SC.CLAS_OID_CLAS_FLET as CLASIFICACION, "); 
                sql.append(" SC.CLIE_OID_CLIE as OIDCLIENTE, "); 
                sql.append(" SC.CLIE_OID_CONS_ASOC as CONSULTORAASOCIADA, "); 
                sql.append(" SC.TCCL_OID_TCCL_FLET as TIPOCLASIFICACION, "); 
                sql.append(" SC.ESSO_OID_ESTA_SOLI as ESTADO, "); 
                sql.append(" SC.CLIE_OID_CLIE_DEST as DESTINATARIO, "); 
                sql.append(" SC.FEC_CRON as FECHA, "); 
                sql.append(" SC.FEC_FACT as FECHAFACTURACION, "); 
                sql.append(" SC.FEC_PROG_FACT as FECHAPREVISTAFACTURACION, "); 
                sql.append(" SC.FOPA_OID_FORM_PAGO as FORMAPAGO, "); 
                sql.append(" SC.GRPR_OID_GRUP_PROC as GRUPOPROCESOS, "); 
                sql.append(" SC.IND_APLI_MANU as INDICADORAPLICACIONMANUAL, "); 
                sql.append(" SC.IND_ESTA as INDICADORESTADISTICABLE, "); 
                sql.append(" SC.IND_EXEN_FLET as INDICADOREXENTOFLETE, "); 
                sql.append(" SC.IND_GENE_CC as INDICADORGENERACUENTACORRIENTE, "); 
                sql.append(" SC.IND_IMPR as INDICADORIMPRESION, "); 
                sql.append(" SC.TAIM_OID_TASA_IMPU as INDICADORIMPUESTOSFLETE, "); 
                sql.append(" SC.IND_OC as INDICADORORDENCOMPRA, "); 
                sql.append(" SC.IND_PEDI_PRUE as INDICADORPEDIDOPRUEBA, "); 
                sql.append(" SC.IND_PERM_UNIO_SOL as PERMITEUNIONSOLICITUDES, "); 
                sql.append(" SC.IND_TS_NO_CONSO as INDICADORTSNOCONSOLIDADO, "); 
                sql.append(" SC.INRE_OID_INDI_REVI as INDICADORREVISION, ");  //pperez Incidencia BELC300023071
                //marca -> se saca de la relación con CRA_PERIO a través del campo PERD_OID_PERI de la tabla PED_SOLIC_CABEC 
                //sql.append(" (SELECT MARC_OID_MARC FROM CRA_PERIO P WHERE P.OID_PERI = SC.PERD_OID_PERI) as marca, "); 
                // incidencia 10061: Se sustituye por 
                sql.append(" P.MARC_OID_MARC as MARCA, "); 

                sql.append(" SC.MODU_OID_MODU as MODULO, "); 
                sql.append(" SC.MONE_OID_MONE as MONEDA, "); 
                sql.append(" SC.NUM_CLIEN as NUMEROCLIENTES, "); 
                // numeroConsolidado -> si SOCA_OID_SOLI_CABE <> null, se accede por OID_SOLI_CABE = SOCA_OID_SOLI_CABE y se 
                //obtiene el campo VAL_NUME_SOLI 
                //incidencia 10061: Se sustituye por: 
                sql.append(" DECODE(SC.SOCA_OID_SOLI_CABE,NULL,NULL,(SELECT VAL_NUME_SOLI FROM PED_SOLIC_CABEC SCA WHERE SCA.OID_SOLI_CABE = SC.SOCA_OID_SOLI_CABE) ) as NUMEROCONSOLIDADO, "); 
                sql.append(" SC.NUM_DOCU_ORIG as NUMERODOCUMENTOORIGEN, "); 
                sql.append(" SC.NUM_PREM as NUMEROPREMIO, "); 
                //numeroSecuenciaFacturacionDiaria -> se accede a la tabla PED_SOLIC_CABE_SECUE usando OID_SOLI_CABE, y se 
                //obtiene NUM_SECU_FACT_DIAR 
                //sql.append(" (SELECT NUM_SECU_FACT_DIAR FROM PED_SOLIC_CABEC_SECUE SCS WHERE SCS.SOCA_OID_SOLI_CABE = SC.OID_SOLI_CABE ) as numeroSecuenciaFactDiaria, "); 
                //incidencia 10061: Se sustituye por: 
                sql.append(" SCS.NUM_SECU_FACT_DIAR as NUMEROSECUENCIAFACTDIARIA, "); 
                //numeroSecuenciaZonaRuta -> se accede a la tabla PED_SOLIC_CABE_SECUE usando OID_SOLI_CABE, y se 
                //obtiene NUM_SECU_ZONA_RUTA 
                //sql.append(" (SELECT NUM_SECU_ZONA_RUTA FROM PED_SOLIC_CABEC_SECUE SCS WHERE SCS.SOCA_OID_SOLI_CABE = SC.OID_SOLI_CABE ) as numeroSecuenciaZonaRuta, "); 
                //incidencia 10061: Se sustituye por : 
                sql.append(" SCS.NUM_SECU_ZONA_RUTA as NUMEROSECUENCIAZONARUTA, "); 
                
                sql.append(" SC.OID_SOLI_CABE as OIDCABECERASOLICITUD, "); 
                sql.append(" SC.SOCA_OID_SOLI_CABE as OIDCONSOLIDADO, "); 
                sql.append(" SC.CLDI_OID_CLIE_DIRE as OIDDIRECCIONCLIENTE, "); 
                sql.append(" SC.CLIE_OID_CLIE_PAGA as OIDPAGADORFACTURA, "); 
                sql.append(" SC.OPER_OID_OPER as OPERACION, "); 
                sql.append(" SC.PAIS_OID_PAIS as PAIS, "); 
                sql.append(" SC.PERD_OID_PERI as PERIODO, "); 
                sql.append(" SC.PROC_OID_PROC as PROCESO, "); 
                sql.append(" SC.VAL_PREC_NETO_TOTA_LOCA as PRECIOTOTALTOTALLOCAL, "); 
                sql.append(" SC.VAL_PREC_NETO_TOTA_DOCU as PRECIOTOTALTOTALDOCUMENTO, "); 
                sql.append(" SC.VAL_PUNT_EMIS as PUNTOEMISION, "); 
                sql.append(" SC.CLIE_OID_CLIE_RECE_FACT as RECEPTORFACTURA, "); 
                // --oidSubgVentas -> se accede a la tabla ZON_REGIO y se toma el campo ZSGV_OID_SUBG_VENT 
        //    REG.ZSGV_OID_SUBG_VENT as oidSubgVentas, 
                sql.append(" (SELECT REG.ZSGV_OID_SUBG_VENT FROM ZON_REGIO REG , ZON_ZONA Z WHERE Z.OID_ZONA = SC.ZZON_OID_ZONA AND Z.ZORG_OID_REGI = REG.OID_REGI ) as OIDSUBGVENTAS, "); 
                //region -> se accede a la tabla ZON_ZONA usando ZZON_OID_ZONA y se obtiene ZORG_OID_REGI, 
                //sql.append(" (SELECT ZORG_OID_REGI FROM ZON_ZONA Z WHERE Z.OID_ZONA = SC.ZZON_OID_ZONA) as region, "); 
                // incidencia 10061.Se sustituye por: 
                sql.append(" Z.ZORG_OID_REGI as REGION, "); 
                
                //seccion -> se accede a la tabla ZON_TERRI_ADMI usando ZTAD_OID_TERR_ADMI, y se obtiene OID_SECC, 
                //sql.append(" (SELECT ZSCC_OID_SECC FROM ZON_TERRI_ADMIN TA WHERE TA.OID_TERR_ADMI = SC.ZTAD_OID_TERR_ADMI) as seccion, "); 
                //incidencia 10061.Se sustituye por: 
                sql.append(" TA.ZSCC_OID_SECC as SECCION, "); 
                
                //secuenciaRutaTerritorio -> se accede a la tabla PED_SOLIC_CABE_SECUE usando OID_SOLI_CABE, y se 
                //obtiene VAL_SECU_RUTA_TERR 
                //sql.append(" (SELECT VAL_SECU_RUTA_TERR FROM PED_SOLIC_CABEC_SECUE SCS WHERE SCS.SOCA_OID_SOLI_CABE = SC.OID_SOLI_CABE ) as secuenciaRutaTerritorio, "); 
                //incidencia 10061. Se sustituye por: 
                sql.append(" SCS.VAL_SECU_RUTA_TERR as SECUENCIARUTATERRITORIO, "); 
                
                sql.append(" SC.SBAC_OID_SBAC as SUBACCESO, "); 
                sql.append(" SC.SBTI_OID_SUBT_CLIE as SUBTIPOCLIENTE, "); 
                sql.append(" SC.ZTAD_OID_TERR_ADMI as TERRITORIOCLIENTE, "); 
                sql.append(" SC.SOCA_OID_DOCU_REFE as OIDDOCUMENTOREFERENCIA, "); 
                sql.append(" SC.SOCI_OID_SOCI as SOCIEDAD, "); 
                sql.append(" SC.TDOC_OID_TIPO_DOCU as TIPODOCUMENTO, "); 
                sql.append(" SC.TIDO_OID_TIPO_DOCU as TIPODOCUMENTOLEGAL, "); 
                sql.append(" SC.TERR_OID_TERR as TERRITORIO, "); 
                sql.append(" SC.TICL_OID_TIPO_CLIE as TIPOCLIENTE, "); 
                sql.append(" SC.TIDS_OID_TIPO_DESP as TIPODESPACHO, "); 
                sql.append(" SC.TSPA_OID_TIPO_SOLI_PAIS as TIPOSOLICITUD, "); 
                sql.append(" SC.TSPA_OID_TIPO_SOLI_PAIS_CONS as TIPOSOLICITUDCONSOLIDADO, "); 
                sql.append(" SC.VAL_BASE_FLET_DOCU as BASEFLETEDOCUMENTO, "); 
                sql.append(" SC.VAL_BASE_FLET_LOCA as BASEFLETELOCAL, "); 
                sql.append(" SC.VAL_GLOS_OBSE as OBSERVACIONES, "); 
                sql.append(" SC.VAL_IMPO_DESC_1_TOTA_DOCU as IMPORTEDESCUENTO1TD, "); 
                sql.append(" SC.VAL_IMPO_DESC_1_TOTA_LOCA as IMPORTEDESCUENTO1TL, "); 
                sql.append(" SC.VAL_IMPO_DESC_3_TOTA_DOCU as IMPORTEDESCUENTO3TD, "); 
                sql.append(" SC.VAL_IMPO_DESC_3_TOTA_LOCA as IMPORTEDESCUENTO3TL, "); 
                sql.append(" SC.VAL_IMPO_DESC_TOTA_DOCU as IMPORTEDESCUENTOTD, "); 
                sql.append(" SC.VAL_IMPO_DESC_TOTA_LOCA as IMPORTEDESCUENTOTL, "); 
                sql.append(" SC.VAL_IMPO_FLET_DOCU as IMPORTEFLETEDOCUMENTO, "); 
                sql.append(" SC.VAL_IMPO_FLET_LOCA as IMPORTEFLETELOCAL, "); 
                sql.append(" SC.VAL_IMPO_FLET_SIN_IMPU_TOTA as IMPORTEFLETESIMPUESTOSTL, "); 
                sql.append(" SC.VAL_IMPO_FLET_SIN_IMPU_DOCU as IMPORTEFLETESINIMPUESTOSTD, "); 
                sql.append(" SC.VAL_IMPO_FLET_TOTA_DOCU as IMPORTEFLETETD, "); 
                sql.append(" SC.VAL_IMPO_FLET_TOTA_LOCA as IMPORTEFLETETL, "); 
                sql.append(" SC.VAL_NUME_SOLI as NUMEROSOLICITUD, "); 
                sql.append(" SC.VAL_OTRO_RECA_DOCU as OTROSRECARGOSDOCUMENTO, "); 
                sql.append(" SC.VAL_OTRO_RECA_LOCA as OTROSRECARGOSLOCAL, "); 
                sql.append(" SC.VAL_PREC_CONT_TOTA_LOCA as PRECIOCONTABLETL, "); 
                sql.append(" SC.VAL_RECA_FLET_DOCU as RECARGOFLETEDOCUMENTO, "); 
                sql.append(" SC.VAL_RECA_FLET_LOCA as RECARGOFLETELOCAL, "); 
                sql.append(" SC.VAL_TIPO_CAMB as TIPOCAMBIO, "); 
                sql.append(" SC.VAL_TOTA_FLET_DOCU as TOTALFLETEDOCUMENTO, "); 
                sql.append(" SC.VAL_TOTA_FLET_LOCA as TOTALFLETELOCAL, "); 
                sql.append(" SC.VAL_TOTA_PAGA_DOCU as TOTALAPAGARDOCUMENTO, "); 
                sql.append(" SC.VAL_TOTA_PAGA_LOCA as TOTALAPAGARLOCAL, "); 
                sql.append(" SC.VAL_USUA as USUARIO, "); 
                sql.append(" SC.ZZON_OID_ZONA as ZONA, "); 
                sql.append(" P.CANA_OID_CANA as CANAL, "); 
                sql.append(" SC.VEPO_OID_VALO_ESTR_GEOP as UBIGEO "); // añadido por incidencia 10301 

                sql.append(" FROM PED_SOLIC_CABEC SC,  "); 
                
    //sql.append(" SEG_SUBAC SA,  "); 
                //jrivas 12/09/2005 Estaba usando el subacceso para traer el acceso, esta mal ya que lo tengo en el Tipo Solic 
    sql.append(" PED_TIPO_SOLIC_PAIS tsp, PED_TIPO_SOLIC ts,  ");     
    sql.append(" CRA_PERIO P, "); 
                sql.append(" PED_SOLIC_CABEC_SECUE SCS, ZON_ZONA Z, ZON_TERRI_ADMIN TA, "); 
                
                //jrivas 12/09/2005 
    sql.append(" (SELECT DISTINCT SC2.PERD_OID_PERI,  SC2.CLIE_OID_CLIE, "); 
    sql.append(" ts2.ACCE_OID_ACCE FROM PED_SOLIC_CABEC SC2, PED_TIPO_SOLIC_PAIS tsp2, PED_TIPO_SOLIC ts2 "); 
    sql.append(" WHERE SC2.TSPA_OID_TIPO_SOLI_PAIS = tsp2.OID_TIPO_SOLI_PAIS "); 
    sql.append(" AND tsp2.TSOL_OID_TIPO_SOLI = ts2.OID_TIPO_SOLI "); 
    //sql.append(" AND SC2.OID_SOLI_CABE IN ("+niapa+")) xx "); 
    int x = 0;
    int y = 0;
    sql.append(" AND (  ");
    boolean cerre = false;
    while (x < aux.size()){
        if (y == 0){
            if (x != 0){
                sql.append(" OR ");
            }
            sql.append(" SC2.OID_SOLI_CABE in ( ");
        }
        if (y < 999){
            sql.append(aux.get(x)).append(" ,");
            y++;
            cerre = false;
        }else{
            y = 0;
            cerre = true;
            sql.append(aux.get(x)).append(" ) ");
        }
        x++;        
        if (x == aux.size() && !cerre){
            sql.deleteCharAt(sql.length()-1);
            sql.append(" ) ");	
        }
    }
		sql.append(" )) xx");	
    //sql.append(" (SELECT DISTINCT SC2.PERD_OID_PERI, SC2.CLIE_OID_CLIE, "); 
                //sql.append(" SA2.ACCE_OID_ACCE FROM PED_SOLIC_CABEC SC2, SEG_SUBAC SA2 "); 
                //sql.append(" WHERE SC2.SBAC_OID_SBAC = SA2.OID_SBAC "); 
                //sql.append(" AND SC2.OID_SOLI_CABE IN ("+niapa+")) xx "); 

                /*for(int i=0;i< dtoe.size();i++){ 
                        if(dtoe.get(i)!=null){ 
                                parametros.add(aux.get(i)); 
                        } 
                } */
                
        
                sql.append(" WHERE P.OID_PERI = SC.PERD_OID_PERI "); 
                
    //jrivas 12/09/2005 
    sql.append(" AND SC.TSPA_OID_TIPO_SOLI_PAIS = tsp.OID_TIPO_SOLI_PAIS "); 
    sql.append(" AND tsp.TSOL_OID_TIPO_SOLI = ts.OID_TIPO_SOLI "); 
    //sql.append(" AND SC.SBAC_OID_SBAC = SA.OID_SBAC "); 
                
    sql.append(" AND SCS.SOCA_OID_SOLI_CABE (+)= SC.OID_SOLI_CABE "); 
                sql.append(" AND Z.OID_ZONA = SC.ZZON_OID_ZONA "); 
                sql.append(" AND TA.OID_TERR_ADMI = SC.ZTAD_OID_TERR_ADMI "); 
                sql.append(" AND FEC_FACT IS NULL "); 
                sql.append(" AND IND_OC = 0 "); 

                //  AND (FEC_PROG_FACT >= /*fechaFacturacion*/ or FEC_PROG_FACT is null) 
                if(fechaFacturacion != null){ 
                        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd"); 
                        java.sql.Date fecha =  new java.sql.Date(fechaFacturacion.getTime()); 
                        String sFecha = sdf.format(fecha);                                                           
                        sql.append(" AND (SC.FEC_PROG_FACT  >=  TO_DATE( ? ,'YYYY-MM-DD')   "); 
                        sql.append(" OR SC.FEC_PROG_FACT IS NULL)  "); 
                        parametros.add(sFecha); 
                } 
                //  AND GRPR_OID_GRUP_PROC = /*oidGP*/ 
                if(oidGP != null){ 
                        sql.append(" AND SC.GRPR_OID_GRUP_PROC = ? "); 
                        parametros.add(oidGP); 
                } 
                sql.append(" AND SC.PERD_OID_PERI = xx.PERD_OID_PERI "); 
                sql.append(" AND SC.CLIE_OID_CLIE = xx.CLIE_OID_CLIE "); 
                
    //jrivas 12/09/2005     
    //sql.append(" AND SA.ACCE_OID_ACCE = xx.ACCE_OID_ACCE "); 
    sql.append(" AND ts.ACCE_OID_ACCE = xx.ACCE_OID_ACCE "); 

                //sql.append(" AND SC.OID_SOLI_CABE NOT IN ("+niapa+" ) "); 
                /*x = 0;
                y = 0;
                sql.append(" AND (  ");
                cerre = false;
                while (x < aux.size()){
                    if (y == 0){
                        if (x != 0){
                            sql.append(" OR ");
                        }
                        sql.append(" SC.OID_SOLI_CABE in ( ");
                    }
                    if (y < 999){
                        sql.append(aux.get(x)).append(" ,");
                        y++;
                        cerre = false;
                    }else{
                        y = 0;
                        cerre = true;
                        sql.append(aux.get(x)).append(" ) ");
                    }
                    x++;        
                    if (x == aux.size() && !cerre){
                        sql.deleteCharAt(sql.length()-1);
                        sql.append(" ) ");	
                    }
                }
                sql.append(" )");	*/

                /*for(int i=0;i< dtoe.size();i++){ 
                        if(dtoe.get(i)!=null){ 
                                parametros.add(aux.get(i)); 
                        } 
                } */
                
                /* 
                - con cada registro recuperado crea un objeto DTOFACCabeceraSolicitud, y lo añade a listaTemporal 

                - retornar listaTemporal 
                */ 

            BelcorpService bs = UtilidadesEJB.getBelcorpService(); 
                RecordSet rs = null; 
                String codigoError = null; 
                try { 
                        rs = bs.dbService.executePreparedQuery(sql.toString(), parametros); 
                } catch (Exception e) { 
                        codigoError = CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS; 
                        UtilidadesLog.error("obtenerSolicitudesNoPrevistas: Exception",e); 
                        this.logSql("obtenerSolicitudesNoPrevistas. SQL: ",sql.toString(), parametros); 
                        throw new MareException(e, UtilidadesError.armarCodigoError(codigoError)); 
                } 

                ArrayList listaDtos=new ArrayList(); 
                        
        if(!rs.esVacio()){ 
                        Vector vector=new Vector(); 
                        for(int i=0;i<rs.getRowCount();i++){ 
                                DTOFACCabeceraSolicitud        dtoCabSolic= new DTOFACCabeceraSolicitud(); 
                                //****** añadido incidencia 10301 
                                if(rs.getValueAt(i,"UBIGEO")!=null){ 
                                        Long ubigeo = new Long(((BigDecimal)rs.getValueAt(i,"UBIGEO")).longValue()); 
                                        dtoCabSolic.setUbigeo(ubigeo); 
                                } 
                                // ********** 
                                if(rs.getValueAt(i,"CANAL")!=null){ 
                                        Long canal = new Long(((BigDecimal)rs.getValueAt(i,"CANAL")).longValue()); 
                                        dtoCabSolic.setCanal(canal); 
                                } 
                                if(rs.getValueAt(i,"ACCESOFISICO")!=null){ 
                                        Long accesoFisico = new Long(((BigDecimal)rs.getValueAt(i,"ACCESOFISICO")).longValue()); 
                                        dtoCabSolic.setAccesoFisico(accesoFisico); 
                                } 
                                if(rs.getValueAt(i,"ALMACEN")!=null){ 
                                        Long almacen = new Long(((BigDecimal)rs.getValueAt(i,"ALMACEN")).longValue()); 
                                        dtoCabSolic.setAlmacen(almacen); 
                                } 
                                if(rs.getValueAt(i,"CLASESOLICITUD")!=null){ 
                                        Long claseSolicitud = new Long(((BigDecimal)rs.getValueAt(i,"CLASESOLICITUD")).longValue()); 
                                        dtoCabSolic.setClaseSolicitud(claseSolicitud); 
                                } 
                                if(rs.getValueAt(i,"CLASIFICACION")!=null){ 
                                                Long clasificacion = new Long(((BigDecimal)rs.getValueAt(i,"CLASIFICACION")).longValue()); 
                                                dtoCabSolic.setClasificacion(clasificacion); 
                                } 
                                if(rs.getValueAt(i,"OIDCLIENTE")!=null){ 
                                                Long oidCliente = new Long(((BigDecimal)rs.getValueAt(i,"OIDCLIENTE")).longValue()); 
                                                dtoCabSolic.setOidCliente(oidCliente); 
                                } 
                                if(rs.getValueAt(i,"CONSULTORAASOCIADA")!=null){ 
                                        Long consultoraAsociada = new Long(((BigDecimal)rs.getValueAt(i,"CONSULTORAASOCIADA")).longValue()); 
                                        dtoCabSolic.setConsultoraAsociada(consultoraAsociada); 
                                } 
                                if(rs.getValueAt(i,"TIPOCLASIFICACION")!=null){ 
                                        Long tipoClasificacion = new Long(((BigDecimal)rs.getValueAt(i,"TIPOCLASIFICACION")).longValue()); 
                                        dtoCabSolic.setTipoClasificacion(tipoClasificacion); 
                                } 
                                if(rs.getValueAt(i,"ESTADO")!=null){ 
                                        Long estado = new Long(((BigDecimal)rs.getValueAt(i,"ESTADO")).longValue()); 
                                        dtoCabSolic.setEstado(estado); 
                                } 
                                if(rs.getValueAt(i,"DESTINATARIO")!=null){ 
                                        Long destinatario=new Long(((BigDecimal)rs.getValueAt(i,"DESTINATARIO")).longValue()); 
                                        dtoCabSolic.setDestinatario(destinatario); 
                                } 
                                if(rs.getValueAt(i,"FECHA") != null){ 
                                        Date fecha = (Date)rs.getValueAt(i,"FECHA"); 
                                        dtoCabSolic.setFecha(fecha); 
                                } 
                                if(rs.getValueAt(i,"FECHAFACTURACION") != null){ 
                                        Date fechaFact = (Date)rs.getValueAt(i,"FECHAFACTURACION"); 
                                        dtoCabSolic.setFecha(fechaFact); 
                                } 
                                if(rs.getValueAt(i,"FECHAPREVISTAFACTURACION") != null){ 
                                        Date fechaPrevistaFacturacion = (Date)rs.getValueAt(i,"FECHAPREVISTAFACTURACION"); 
                                        dtoCabSolic.setFechaPrevistaFacturacion(fechaPrevistaFacturacion); 
                                } 
                                if(rs.getValueAt(i,"FORMAPAGO")!=null){ 
                                        Long formaPago = new Long(((BigDecimal)rs.getValueAt(i,"FORMAPAGO")).longValue()); 
                                        dtoCabSolic.setFormaPago(formaPago); 
                                } 
                                if(rs.getValueAt(i,"GRUPOPROCESOS")!=null){ 
                                        Long grupoProcesos = new Long(((BigDecimal)rs.getValueAt(i,"GRUPOPROCESOS")).longValue()); 
                                        dtoCabSolic.setGrupoProcesos(grupoProcesos); 
                                } 
                                Boolean indicadorAM; 
                                if(rs.getValueAt(i,"INDICADORAPLICACIONMANUAL")!=null){ 
                                        indicadorAM = new Boolean(((BigDecimal)rs.getValueAt(i, 
                                                                                "INDICADORAPLICACIONMANUAL")).intValue() == 1 ? true : false);         
                                        dtoCabSolic.setIndicadorAplicacionManual(indicadorAM); 
                                } 
                                Boolean indicadorE; 
                                if(rs.getValueAt(i,"INDICADORESTADISTICABLE")!=null){ 
                                        indicadorE=new Boolean(((BigDecimal)rs.getValueAt(i, 
                                                                        "INDICADORESTADISTICABLE")).intValue() == 1 ? true : false);         
                                        dtoCabSolic.setIndicadorEstadisticable(indicadorE); 
                                } 
                                Boolean indicadorExento; 
                                if(rs.getValueAt(i,"INDICADOREXENTOFLETE")!=null){ 
                                        indicadorExento=new Boolean(((BigDecimal)rs.getValueAt(i, 
                                                                        "INDICADOREXENTOFLETE")).intValue() == 1 ? true : false);                 
                                        dtoCabSolic.setIndicadorExentoFlete(indicadorExento); 
                                } 
                                Boolean indicadorCuenta; 
                                if(rs.getValueAt(i,"INDICADORGENERACUENTACORRIENTE")!=null){ 
                                        indicadorCuenta=new Boolean(((BigDecimal)rs.getValueAt(i, 
                                                                        "INDICADORGENERACUENTACORRIENTE")).intValue() == 1 ? true : false);                                         
                                        dtoCabSolic.setIndicadorGeneraCuentaCorriente(indicadorCuenta); 
                                } 
                                Boolean indicadorImpresion; 
                                if(rs.getValueAt(i,"INDICADORIMPRESION")!=null){ 
                                        indicadorImpresion=new Boolean(((BigDecimal)rs.getValueAt(i, 
                                                                        "INDICADORIMPRESION")).intValue() == 1 ? true : false);                                         
                                        dtoCabSolic.setIndicadorImpresion(indicadorImpresion); 
                                } 
                        
                                if(rs.getValueAt(i,"INDICADORIMPUESTOSFLETE")!=null){ 
                                         Long indicadorImpuestosFlete = new Long(((BigDecimal)rs.getValueAt(i, 
                                                                        "INDICADORIMPUESTOSFLETE")).longValue());                                         
                                        dtoCabSolic.setIndicadorImpuestosFlete(indicadorImpuestosFlete); 
                                } 
                                Boolean indOrdenCompra; 
                                if(rs.getValueAt(i,"INDICADORORDENCOMPRA")!=null){ 
                                        indOrdenCompra=new Boolean(((BigDecimal)rs.getValueAt(i, 
                                                                        "INDICADORORDENCOMPRA")).intValue() == 1 ? true : false); 
                                        dtoCabSolic.setIndicadorOrdenCompra(indOrdenCompra); 
                                } 
                                Boolean indPedidoPrueba; 
                                if(rs.getValueAt(i,"INDICADORPEDIDOPRUEBA")!=null){ 
                                        indPedidoPrueba=new Boolean(((BigDecimal)rs.getValueAt(i, 
                                                                        "INDICADORPEDIDOPRUEBA")).intValue() == 1 ? true : false); 
                                        dtoCabSolic.setIndicadorPedidoPrueba(indPedidoPrueba); 
                                } 
                                Boolean permiteUnionS; 
                                if(rs.getValueAt(i,"PERMITEUNIONSOLICITUDES")!=null){ 
                                        permiteUnionS=new Boolean(((BigDecimal)rs.getValueAt(0, 
                                                                                "PERMITEUNIONSOLICITUDES")).intValue() == 1 ? true : false); 
                                        dtoCabSolic.setPermiteUnionSolicitudes(permiteUnionS); 
                                } 

                                Boolean indicadorNoConso; 
                                if(rs.getValueAt(i,"INDICADORTSNOCONSOLIDADO")!=null){ 
                                        indicadorNoConso=new Boolean(((BigDecimal)rs.getValueAt(i, 
                                                                "INDICADORTSNOCONSOLIDADO")).intValue() == 1 ? true : false); 
                                        dtoCabSolic.setIndTSNoConsolidado(indicadorNoConso); 
                                } 
                                if (rs.getValueAt(i,"INDICADORREVISION")!=null) { 
                                        Long indRevision=new Long(((BigDecimal)rs.getValueAt(i,"INDICADORREVISION")).longValue()); 
                                        dtoCabSolic.setIndicadorRevision(indRevision); 
                                } 
                                if(rs.getValueAt(i,"MARCA")!=null){ 
                                        Long marca = new Long(((BigDecimal)rs.getValueAt(i,"MARCA")).longValue()); 
                                        dtoCabSolic.setMarca(marca); 
                                } 
                                if(rs.getValueAt(i,"MODULO")!=null){ 
                                        Long modulo = new Long(((BigDecimal)rs.getValueAt(i,"MODULO")).longValue()); 
                                        dtoCabSolic.setModulo(modulo); 
                                } 
                                if(rs.getValueAt(i,"MONEDA")!=null){ 
                                        Long moneda=new Long(((BigDecimal)rs.getValueAt(i,"MONEDA")).longValue()); 
                                        dtoCabSolic.setMoneda(moneda); 
                                } 
                                if(rs.getValueAt(i,"NUMEROCLIENTES")!=null){ 
                                        Integer numCLientes=new Integer(((BigDecimal)rs.getValueAt(i,"NUMEROCLIENTES")).intValue()); 
                                        dtoCabSolic.setNumeroClientes(numCLientes); 
                                } 
                                if(rs.getValueAt(i,"NUMEROCONSOLIDADO")!=null){ 
                                        Long numeroConsolidado=new Long(rs.getValueAt(i,"NUMEROCONSOLIDADO").toString()); 
                                        dtoCabSolic.setNumeroConsolidado(numeroConsolidado); 
                                } 
                                if(rs.getValueAt(i,"NUMERODOCUMENTOORIGEN")!=null){ 
                                        Long numDocOrigen=new Long(((BigDecimal)rs.getValueAt(i,"NUMERODOCUMENTOORIGEN")).longValue()); 
                                        dtoCabSolic.setNumeroDocumentoOrigen(numDocOrigen); 
                                } 
                                if(rs.getValueAt(i,"NUMEROPREMIO")!=null){ 
                                        Integer numPrenio=new Integer(((BigDecimal)rs.getValueAt(i,"NUMEROPREMIO")).intValue()); 
                                        dtoCabSolic.setNumeroPremio(numPrenio); 
                                } 
                                if(rs.getValueAt(i,"NUMEROSECUENCIAFACTDIARIA")!=null){     
                                        Integer numSecuFactDiaria=new Integer(((BigDecimal)rs.getValueAt(i,"NUMEROSECUENCIAFACTDIARIA")).intValue()); 
                                        dtoCabSolic.setNumeroSecuenciaFacturacionDiaria(numSecuFactDiaria); 
                                } 
                                if(rs.getValueAt(i,"NUMEROSECUENCIAZONARUTA")!=null){     
                                        Integer numSecuZonaRuta=new Integer(((BigDecimal)rs.getValueAt(i,"NUMEROSECUENCIAZONARUTA")).intValue()); 
                                        dtoCabSolic.setNumeroSecuenciaZonaRuta(numSecuZonaRuta); 
                                } 
                                if(rs.getValueAt(i,"OIDCABECERASOLICITUD")!=null){ 
                                        Long oidCabeceraSolicitud=new Long(((BigDecimal)rs.getValueAt(i,"OIDCABECERASOLICITUD")).longValue()); 
                                        dtoCabSolic.setOidCabeceraSolicitud(oidCabeceraSolicitud); 
                                } 
                                if(rs.getValueAt(i,"OIDCONSOLIDADO")!=null){ 
                                        Long oidConsolidado=new Long(((BigDecimal)rs.getValueAt(i,"OIDCONSOLIDADO")).longValue()); 
                                        dtoCabSolic.setOidConsolidado(oidConsolidado); 
                                } 
                                if(rs.getValueAt(i,"OIDDIRECCIONCLIENTE")!=null){ 
                                        Long oidDireccionCliente=new Long(((BigDecimal)rs.getValueAt(i,"OIDDIRECCIONCLIENTE")).longValue()); 
                                        dtoCabSolic.setOidDireccionCliente(oidDireccionCliente); 
                                } 
                                if(rs.getValueAt(i,"OIDPAGADORFACTURA")!=null){ 
                                        Long oidPagadorFactura=new Long(((BigDecimal)rs.getValueAt(i,"OIDPAGADORFACTURA")).longValue()); 
                                        dtoCabSolic.setOidPagadorFactura(oidPagadorFactura); 
                                } 
                                if(rs.getValueAt(i,"OPERACION")!=null){ 
                                        Long operacion=new Long(((BigDecimal)rs.getValueAt(i,"OPERACION")).longValue()); 
                                        dtoCabSolic.setOperacion(operacion); 
                                } 
                                if(rs.getValueAt(i,"PAIS")!=null){ 
                                        Long pais=new Long(((BigDecimal)rs.getValueAt(i,"PAIS")).longValue()); 
                                        dtoCabSolic.setOidPais(pais); 
                                } 
                                if(rs.getValueAt(i,"PERIODO")!=null){ 
                                        Long periodo=new Long(((BigDecimal)rs.getValueAt(i,"PERIODO")).longValue()); 
                                        dtoCabSolic.setPeriodo(periodo); 
                                } 
                                if(rs.getValueAt(i,"PROCESO")!=null){ 
                                        Long proceso=new Long(((BigDecimal)rs.getValueAt(i,"PROCESO")).longValue()); 
                                        dtoCabSolic.setProceso(proceso); 
                                } 
                                if(rs.getValueAt(i,"PRECIOTOTALTOTALLOCAL")!=null){ 
                                        Float precioTotalTotalLocal = new Float(((BigDecimal)rs.getValueAt(i,"PRECIOTOTALTOTALLOCAL")).floatValue()); 
                                        dtoCabSolic.setPrecioTotalTotalLocal(precioTotalTotalLocal); 
                                } 
                                if(rs.getValueAt(i,"PRECIOTOTALTOTALDOCUMENTO")!=null){ 
                                        Float precioTotalTotalDocumento=new Float(((BigDecimal)rs.getValueAt(i,"PRECIOTOTALTOTALDOCUMENTO")).floatValue()); 
                                        dtoCabSolic.setPrecioTotalTotalDocumento(precioTotalTotalDocumento); 
                                } 
                                if(rs.getValueAt(i,"PUNTOEMISION")!=null){ 
                                        String puntoEmision = rs.getValueAt(i,"PUNTOEMISION").toString(); 
                                        dtoCabSolic.setPuntoEmision(puntoEmision); 
                                } 
                                if(rs.getValueAt(i,"RECEPTORFACTURA")!=null){ 
                                        Long receptorFactura=new Long(((BigDecimal)rs.getValueAt(i,"RECEPTORFACTURA")).longValue()); 
                                        dtoCabSolic.setReceptorFactura(receptorFactura); 
                                } 
                                if(rs.getValueAt(i,"OIDSUBGVENTAS")!=null){ 
                                        Long oidSubGVentas = new Long(((BigDecimal)rs.getValueAt(i,"OIDSUBGVENTAS")).longValue()); 
                                        dtoCabSolic.setOidSubgVentas(oidSubGVentas); 
                                } 
                                if(rs.getValueAt(i,"REGION")!=null){ 
                                        Long region=new Long(((BigDecimal)rs.getValueAt(i,"REGION")).longValue()); 
                                        dtoCabSolic.setRegion(region); 
                                } 
                                if(rs.getValueAt(i,"SECCION")!=null){ 
                                        Long seccion=new Long(((BigDecimal)rs.getValueAt(i,"SECCION")).longValue()); 
                                        dtoCabSolic.setSeccion(seccion); 
                                } 
                                if(rs.getValueAt(i,"SECUENCIARUTATERRITORIO")!=null){ 
                                        String secuenciaRutaTerritorio = rs.getValueAt(i,"SECUENCIARUTATERRITORIO").toString(); 
                                        dtoCabSolic.setSecuenciaRutaTerritorio(secuenciaRutaTerritorio); 
                                } 
                                if(rs.getValueAt(i,"SUBACCESO")!=null){ 
                                        Long subacceso = new Long(((BigDecimal)rs.getValueAt(i,"SUBACCESO")).longValue()); 
                                        dtoCabSolic.setSubacceso(subacceso); 
                                } 
                                if(rs.getValueAt(i,"SUBTIPOCLIENTE")!=null){ 
                                        Long subTipoCliente = new Long(((BigDecimal)rs.getValueAt(i,"SUBTIPOCLIENTE")).longValue()); 
                                        dtoCabSolic.setSubtipoCliente(subTipoCliente); 
                                } 
                                if(rs.getValueAt(i,"TERRITORIOCLIENTE")!=null){ 
                                        Long territorioCliente=new Long(((BigDecimal)rs.getValueAt(i,"TERRITORIOCLIENTE")).longValue()); 
                                        dtoCabSolic.setTerritorioCliente(territorioCliente); 
                                } 
                                if(rs.getValueAt(i,"OIDDOCUMENTOREFERENCIA")!=null){ 
                                        Long oidDocumentoReferencia=new Long(((BigDecimal)rs.getValueAt(i,"OIDDOCUMENTOREFERENCIA")).longValue()); 
                                        dtoCabSolic.setOidDocumentoReferencia(oidDocumentoReferencia); 
                                } 
                                if(rs.getValueAt(i,"SOCIEDAD")!=null){ 
                                        Long sociedad=new Long(((BigDecimal)rs.getValueAt(i,"SOCIEDAD")).longValue()); 
                                        dtoCabSolic.setSociedad(sociedad); 
                                } 
                                if(rs.getValueAt(i,"TIPODOCUMENTO")!=null){ 
                                        Long tipoDocumento=new Long(((BigDecimal)rs.getValueAt(i,"TIPODOCUMENTO")).longValue()); 
                                        dtoCabSolic.setTipoDocumento(tipoDocumento); 
                                } 
                                if(rs.getValueAt(i,"TIPODOCUMENTOLEGAL")!=null){ 
                                        Long tipoDocumentoLegal=new Long(((BigDecimal)rs.getValueAt(i,"TIPODOCUMENTOLEGAL")).longValue()); 
                                        dtoCabSolic.setTipoDocumentoLegal(tipoDocumentoLegal); 
                                } 
                                if(rs.getValueAt(i,"TERRITORIO")!=null){ 
                                        Long territorio=new Long(((BigDecimal)rs.getValueAt(i,"TERRITORIO")).longValue()); 
                                        dtoCabSolic.setTerritorio(territorio); 
                                } 
                                if(rs.getValueAt(i,"TIPOCLIENTE")!=null){ 
                                                Long tipoCliente=new Long(((BigDecimal)rs.getValueAt(i,"TIPOCLIENTE")).longValue()); 
                                                dtoCabSolic.setTipoCliente(tipoCliente); 
                                } 
                                if(rs.getValueAt(i,"TIPODESPACHO")!=null){ 
                                                Long tipoDespacho=new Long(((BigDecimal)rs.getValueAt(i,"TIPODESPACHO")).longValue()); 
                                                dtoCabSolic.setTipoDespacho(tipoDespacho); 
                                } 
                                if(rs.getValueAt(i,"TIPOSOLICITUD")!=null){ 
                                                Long tipoSolicitud=new Long(((BigDecimal)rs.getValueAt(i,"TIPOSOLICITUD")).longValue()); 
                                                dtoCabSolic.setTipoSolicitud(tipoSolicitud); 
                                } 
                                if(rs.getValueAt(i,"TIPOSOLICITUDCONSOLIDADO")!=null){ 
                                                Long tipoSolicConso=new Long(((BigDecimal)rs.getValueAt(i,"TIPOSOLICITUDCONSOLIDADO")).longValue()); 
                                                dtoCabSolic.setTipoSolicitudConsolidado(tipoSolicConso); 
                                } 
                                if(rs.getValueAt(i,"BASEFLETEDOCUMENTO")!=null){ 
                                                Float baseFleteDoc=new Float(((BigDecimal)rs.getValueAt(i,"BASEFLETEDOCUMENTO")).floatValue()); 
                                                dtoCabSolic.setBaseFleteDocumento(baseFleteDoc); 
                                } 
                                if(rs.getValueAt(i,"BASEFLETELOCAL")!=null){ 
                                                Float baseFleteLocal=new Float(((BigDecimal)rs.getValueAt(i,"BASEFLETELOCAL")).floatValue()); 
                                                dtoCabSolic.setBaseFleteLocal(baseFleteLocal); 
                                } 
                                if(rs.getValueAt(i,"OBSERVACIONES")!=null){ 
                                                String observ=rs.getValueAt(i,"OBSERVACIONES").toString(); 
                                                dtoCabSolic.setObservaciones(observ); 
                                } 
                                if(rs.getValueAt(i,"IMPORTEDESCUENTO1TD")!=null){ 
                                                Float imDes1TipDoc1=new Float(((BigDecimal)rs.getValueAt(i,"IMPORTEDESCUENTO1TD")).floatValue()); 
                                                dtoCabSolic.setImporteDescuento1TotalDocumento(imDes1TipDoc1); 
                                } 
                                if(rs.getValueAt(i,"IMPORTEDESCUENTO1TL")!=null){ 
                                                Float imDes1TipLocal1=new Float(((BigDecimal)rs.getValueAt(i,"IMPORTEDESCUENTO1TL")).floatValue());                                                 
                        dtoCabSolic.setImporteDescuento1TotalLocal(imDes1TipLocal1); 
                                } 
                                if(rs.getValueAt(i,"IMPORTEDESCUENTO3TD")!=null){ 
                                                Float imDes1TipDoc3=new Float(((BigDecimal)rs.getValueAt(i,"IMPORTEDESCUENTO3TD")).floatValue()); 
                                                dtoCabSolic.setImporteDescuento3TotalDocumento(imDes1TipDoc3); 
                                } 
                                if(rs.getValueAt(i,"IMPORTEDESCUENTO3TL")!=null){ 
                                                Float imDes1TipDoc3Local=new Float(((BigDecimal)rs.getValueAt(i,"IMPORTEDESCUENTO3TL")).floatValue()); 
                                                dtoCabSolic.setImporteDescuento3TotalLocal(imDes1TipDoc3Local); 
                                } 
                                if(rs.getValueAt(i,"IMPORTEDESCUENTOTD")!=null){ 
                                                Float imDes1TotDoc=new Float(((BigDecimal)rs.getValueAt(i,"IMPORTEDESCUENTOTD")).floatValue()); 
                                                dtoCabSolic.setImporteDescuentoTotalDocumento(imDes1TotDoc); 
                                } 
                                if(rs.getValueAt(i,"IMPORTEDESCUENTOTL")!=null){ 
                                                Float imDes1TotLocal=new Float(((BigDecimal)rs.getValueAt(i,"IMPORTEDESCUENTOTL")).floatValue()); 
                                                dtoCabSolic.setImporteDescuentoTotalLocal(imDes1TotLocal); 
                                } 

                                if(rs.getValueAt(i,"IMPORTEFLETEDOCUMENTO")!=null){ 
                                                Float imFleteDoc=new Float(((BigDecimal)rs.getValueAt(i,"IMPORTEFLETEDOCUMENTO")).floatValue()); 
                                                dtoCabSolic.setImporteFleteDocumento(imFleteDoc); 
                                } 
                                if(rs.getValueAt(i,"IMPORTEFLETELOCAL")!=null){ 
                                        Float imFleteLocal=new Float(((BigDecimal)rs.getValueAt(i,"IMPORTEFLETELOCAL")).floatValue()); 
                                                dtoCabSolic.setImporteFleteLocal(imFleteLocal); 
                                } 
                                if(rs.getValueAt(i,"IMPORTEFLETESIMPUESTOSTL")!=null){ 
                                                Float imFleteSinImpueTotalLocal=new Float(((BigDecimal)rs.getValueAt(i,"IMPORTEFLETESIMPUESTOSTL")).floatValue()); 
                                                dtoCabSolic.setImporteFleteSinImpuestosTotalLocal(imFleteSinImpueTotalLocal); 
                                } 
                                if(rs.getValueAt(i,"IMPORTEFLETESINIMPUESTOSTD")!=null){ 
                                                Float imFleteSinImpueTotalDoc=new Float(((BigDecimal)rs.getValueAt(i,"IMPORTEFLETESINIMPUESTOSTD")).floatValue()); 
                                                dtoCabSolic.setImporteFleteTotalLocal(imFleteSinImpueTotalDoc); 
                                } 
                                if(rs.getValueAt(i,"IMPORTEFLETETD")!=null){ 
                                                Float imFleteTotalDoc=new Float(((BigDecimal)rs.getValueAt(i,"IMPORTEFLETETD")).floatValue()); 
                                                dtoCabSolic.setImporteFleteTotalDocumento(imFleteTotalDoc); 
                                } 
                                if(rs.getValueAt(i,"IMPORTEFLETETL")!=null){ 
                                                Float imFleteTotalLocal=new Float(((BigDecimal)rs.getValueAt(i,"IMPORTEFLETETL")).floatValue()); 
                                                dtoCabSolic.setImporteFleteTotalLocal(imFleteTotalLocal); 
                                } 
                                if(rs.getValueAt(i,"NUMEROSOLICITUD")!=null){ 
                                                Long numeroSolic=new Long(((BigDecimal)rs.getValueAt(i,"NUMEROSOLICITUD")).longValue()); 
                                                dtoCabSolic.setNumeroSolicitud(numeroSolic); 
                                } 
                                if(rs.getValueAt(i,"OTROSRECARGOSDOCUMENTO")!=null){ 
                                                Float otrosCargosDoc=new Float(((BigDecimal)rs.getValueAt(i,"OTROSRECARGOSDOCUMENTO")).floatValue()); 
                                                dtoCabSolic.setOtrosRecargosDocumento(otrosCargosDoc); 
                                } 
                                if(rs.getValueAt(i,"OTROSRECARGOSLOCAL")!=null){ 
                                                Float otrosRecargosLocal=new Float(((BigDecimal)rs.getValueAt(i,"OTROSRECARGOSLOCAL")).floatValue()); 
                                                dtoCabSolic.setOtrosRecargosLocal(otrosRecargosLocal); 
                                } 
                                if(rs.getValueAt(i,"PRECIOCONTABLETL")!=null){ 
                                                Float precioContableTotLocal=new Float(((BigDecimal)rs.getValueAt(i,"PRECIOCONTABLETL")).floatValue()); 
                                                dtoCabSolic.setPrecioContableTotalLocal(precioContableTotLocal); 
                                } 
                                if(rs.getValueAt(i,"RECARGOFLETEDOCUMENTO")!=null){ 
                                                Float recargoFleteDoc=new Float(((BigDecimal)rs.getValueAt(i,"RECARGOFLETEDOCUMENTO")).floatValue()); 
                                                dtoCabSolic.setRecargoFleteDocumento(recargoFleteDoc); 
                                } 
                                if(rs.getValueAt(i,"RECARGOFLETELOCAL")!=null){ 
                                                Float recargoFleteLocal=new Float(((BigDecimal)rs.getValueAt(i,"RECARGOFLETELOCAL")).floatValue()); 
                                                dtoCabSolic.setRecargoFleteLocal(recargoFleteLocal); 
                                } 
                                if(rs.getValueAt(i,"TIPOCAMBIO")!=null){ 
                                                BigDecimal tipoCambio=(BigDecimal)rs.getValueAt(i,"TIPOCAMBIO"); 
                                                dtoCabSolic.setTipoCambio(tipoCambio); 
                                } 

                                if(rs.getValueAt(i,"TOTALFLETEDOCUMENTO")!=null){ 
                                                Float totalFleteDoc=new Float(((BigDecimal)rs.getValueAt(i,"TOTALFLETEDOCUMENTO")).floatValue()); 
                                                dtoCabSolic.setTotalFleteDocumento(totalFleteDoc); 
                                } 

                                if(rs.getValueAt(i,"TOTALFLETELOCAL")!=null){ 
                                                Float totalFleteLocal=new Float(((BigDecimal)rs.getValueAt(i,"TOTALFLETELOCAL")).floatValue()); 
                                                dtoCabSolic.setTotalFleteLocal(totalFleteLocal); 
                                } 
                                if(rs.getValueAt(i,"TOTALAPAGARDOCUMENTO")!=null){ 
                                        Float totAPagarDoc=new Float(((BigDecimal)rs.getValueAt(i,"TOTALAPAGARDOCUMENTO")).floatValue()); 
                                                dtoCabSolic.setTotalAPagarDocumento(totAPagarDoc); 
                                } 
                                if(rs.getValueAt(i,"TOTALAPAGARLOCAL")!=null){ 
                                                Float totAPagarLocal=new Float(((BigDecimal)rs.getValueAt(i,"TOTALAPAGARLOCAL")).floatValue()); 
                                                dtoCabSolic.setTotalAPagarLocal(totAPagarLocal); 
                                } 
                                if(rs.getValueAt(i,"USUARIO")!=null){ 
                                                String usuario = rs.getValueAt(i,"USUARIO").toString(); 
                                                dtoCabSolic.setUsuario(usuario); 
                                } 
                                if(rs.getValueAt(i,"ZONA")!=null){ 
                                                Long zona=new Long(((BigDecimal)rs.getValueAt(i,"ZONA")).longValue()); 
                                                dtoCabSolic.setZona(zona); 
                                } 
                                
                                        
                                listaDtos.add(dtoCabSolic);         
                        }        //for 
                }//if rs.vacio 
                
                UtilidadesLog.info("DAOSolicitudCabecera.obtenerSolicitudesNoPrevistas (ArrayList dtoe, Date fechaFacturacion, Long oidGP): Salida");
                return listaDtos; 
        }//metodo   
    
	public DTOFleteFAC obtenerDatosFlete (ArrayList listaOIDSolicitud)  throws MareException{
          	UtilidadesLog.info("DAOSolicitudCabecera.obtenerDatosFlete (ArrayList listaOIDSolicitud): Entrada");

			Vector parametros = new Vector();
		
			StringBuffer sql=new StringBuffer();

			String listaFinal =this.convertirArrayToString(listaOIDSolicitud); 


			sql.append(" SELECT");
			sql.append(" IND_EXEN_FLET,");
			sql.append(" VAL_BASE_FLET_LOCA,");
			sql.append(" VAL_IMPO_FLET_LOCA,");
			sql.append(" VAL_RECA_FLET_LOCA,");
			sql.append(" VAL_OTRO_RECA_LOCA,");
			sql.append(" VAL_TOTA_FLET_LOCA,");
			sql.append(" VAL_IMPO_FLET_TOTA_LOCA,");
			sql.append(" VAL_BASE_FLET_DOCU,");
			sql.append(" VAL_IMPO_FLET_DOCU,");
			sql.append(" VAL_RECA_FLET_DOCU,");
			sql.append(" VAL_OTRO_RECA_DOCU,");
			sql.append(" VAL_IMPO_FLET_DOCU,");
			sql.append(" VAL_IMPO_FLET_TOTA_DOCU");

			sql.append(" FROM");
			sql.append(" PED_SOLIC_CABEC");
			sql.append(" WHERE" );
			sql.append(" oid_soli_cabe IN ("+listaFinal+ ") "); 

			if(listaFinal==""){
				UtilidadesLog.error(" ERROR******EL arrayList es NULL o esta Vacío ********" );
				}

			for(int i=0;i< listaOIDSolicitud.size();i++){
				if(listaOIDSolicitud.get(i)!=null){
					//si es distinto de null lo pasamos a vector de la select.
					parametros.add(listaOIDSolicitud.get(i));
				}
			}


			
			sql.append(" AND VAL_IMPO_FLET_LOCA IN ( SELECT MAX(VAL_IMPO_FLET_LOCA)" );
			sql.append(" FROM PED_SOLIC_CABEC ");
			sql.append(" WHERE oid_soli_cabe");
			sql.append(" IN ("+listaFinal+") ");
			sql.append(" )" );
			if(listaFinal==""){
				UtilidadesLog.error(" ERROR******EL arrayList es NULL o esta Vacío ********" );
				}

			for(int i=0;i< listaOIDSolicitud.size();i++){
				if(listaOIDSolicitud.get(i)!=null){
					//si es distinto de null lo pasamos a vector de la select.
					parametros.add(listaOIDSolicitud.get(i));
				}
			}
			

			BelcorpService bs = UtilidadesEJB.getBelcorpService();
			RecordSet rs = null;
			String codigoError = null;
			try {
				rs = bs.dbService.executePreparedQuery(sql.toString(), parametros);
			} catch (Exception e) {
				codigoError = CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS;
				UtilidadesLog.error("consultaAptasCursoRealizado: Exception",e);
				this.logSql("consultaAptasCursoRealizado. SQL: ",sql.toString(), parametros);
				throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));
			}
		DTOFleteFAC dtoFleteFAC=dtoFleteFAC= new DTOFleteFAC();
		if(!rs.esVacio()){
		
	/*private Boolean exentoFlete;
	private Float baseFleteLocal; 
	private Float importeFleteLocal;
	private Float recargoFleteLocal;
	private Float otrosRecargosLocal;
	private Float totalFleteLocal;
	*/
				Boolean indExentoFlete;
				if(rs.getValueAt(0,"IND_EXEN_FLET")!=null){
						indExentoFlete=new Boolean(((BigDecimal)rs.getValueAt(0, 
										"IND_EXEN_FLET")).intValue() == 1 ? true : false);
						
						dtoFleteFAC.setExentoFlete(indExentoFlete);
				}	
				if(rs.getValueAt(0,"VAL_BASE_FLET_LOCA")!=null){
						Float baseFleteLocal=new Float(((BigDecimal)rs.getValueAt(0,"VAL_BASE_FLET_LOCA")).floatValue());
						dtoFleteFAC.setBaseFleteLocal(baseFleteLocal);
				}
				if(rs.getValueAt(0,"VAL_IMPO_FLET_LOCA")!=null){
						Float importeFleteLocal=new Float(((BigDecimal)rs.getValueAt(0,"VAL_IMPO_FLET_LOCA")).floatValue());
						dtoFleteFAC.setImporteFleteLocal(importeFleteLocal);
				}
				if(rs.getValueAt(0,"VAL_RECA_FLET_LOCA")!=null){
						Float recargoFleteLocal=new Float(((BigDecimal)rs.getValueAt(0,"VAL_RECA_FLET_LOCA")).floatValue());
						dtoFleteFAC.setRecargoFleteLocal(recargoFleteLocal);
				}
				if(rs.getValueAt(0,"VAL_OTRO_RECA_LOCA")!=null){
						Float otrosRecargosLocal=new Float(((BigDecimal)rs.getValueAt(0,"VAL_OTRO_RECA_LOCA")).floatValue());
						dtoFleteFAC.setOtrosRecargosLocal(otrosRecargosLocal);
				}
				if(rs.getValueAt(0,"VAL_TOTA_FLET_LOCA")!=null){
						Float otrosRecargosLocal=new Float(((BigDecimal)rs.getValueAt(0,"VAL_TOTA_FLET_LOCA")).floatValue());
						dtoFleteFAC.setOtrosRecargosLocal(otrosRecargosLocal);
				}
/*	
	private Float importeFleteTotalLocal;
	private Float baseFleteDocumento;
	private Float importeFleteDocumento;
	private Float recargoFleteDocumento;
	private Float otrosRecargosDocumento;
	private Float totalFleteDocumento;
	private Float importeFleteTotalDocumento;

	*/
			if(rs.getValueAt(0,"VAL_IMPO_FLET_TOTA_LOCA")!=null){
						Float importeFleteTotalLocal =new Float(((BigDecimal)rs.getValueAt(0,"VAL_IMPO_FLET_TOTA_LOCA")).floatValue());
						dtoFleteFAC.setImporteFleteTotalLocal(importeFleteTotalLocal);
				}
				if(rs.getValueAt(0,"VAL_BASE_FLET_DOCU")!=null){
						Float baseFleteDocumento =new Float(((BigDecimal)rs.getValueAt(0,"VAL_BASE_FLET_DOCU")).floatValue());
						dtoFleteFAC.setBaseFleteDocumento(baseFleteDocumento);
				}
				if(rs.getValueAt(0,"VAL_RECA_FLET_DOCU")!=null){
						Float recargoFleteDocumento=new Float(((BigDecimal)rs.getValueAt(0,"VAL_RECA_FLET_DOCU")).floatValue());
						dtoFleteFAC.setRecargoFleteDocumento(recargoFleteDocumento);
				}
				if(rs.getValueAt(0,"VAL_OTRO_RECA_DOCU")!=null){
						Float otrosRecargosDocumento =new Float(((BigDecimal)rs.getValueAt(0,"VAL_OTRO_RECA_DOCU")).floatValue());
						dtoFleteFAC.setOtrosRecargosDocumento(otrosRecargosDocumento);
				}

				if(rs.getValueAt(0,"VAL_TOTA_FLET_DOCU")!=null){
						Float totalFleteDocumento =new Float(((BigDecimal)rs.getValueAt(0,"VAL_TOTA_FLET_DOCU")).floatValue());
						dtoFleteFAC.setTotalFleteDocumento(totalFleteDocumento);
				}
				if(rs.getValueAt(0,"VAL_IMPO_FLET_TOTA_DOCU")!=null){
						Float importeFleteTotalDocumento =new Float(((BigDecimal)rs.getValueAt(0,"VAL_IMPO_FLET_TOTA_DOCU")).floatValue());
						dtoFleteFAC.setImporteFleteTotalDocumento(importeFleteTotalDocumento);
				}
					
		
		}//if
		
		UtilidadesLog.info("DAOSolicitudCabecera.obtenerDatosFlete (ArrayList listaOIDSolicitud): Salida");

        return dtoFleteFAC;                                                       

	}//metodo
    
   /**
    * Sistema:     Belcorp
    * Modulo:      FAC
    * Fecha:       11/10/2005
    * @version     1.0
    * @autor       Cristian Valenzuela
    */   

	public ArrayList obtenerPosicionesCabeceras (ArrayList listaOIDs) throws MareException {
			UtilidadesLog.info("DAOSolicitudCabecera.obtenerPosicionesCabeceras (ArrayList listaOIDs, Long oidIdioma): Entrada");
            
			ArrayList listaDtos=new ArrayList();
			Vector parametros = new Vector();
			StringBuffer sql=new StringBuffer();

			String listaFinal = this.convertirArrayToString(listaOIDs);  
            Long oidIdioma = (Long)RecuperadorIdiomaDefectoServidor.getIdiomaDefectoServidor(); 

			sql.append(" SELECT ");
			sql.append(" (SELECT OCAT_OID_CATAL FROM PRE_OFERT_DETAL pre  ");
			sql.append(" WHERE ped.ofde_oid_deta_ofer = pre.oid_deta_ofer) as catalogo, ");
			sql.append(" ped.VAL_CODI_VENT as codigoVenta, ");
      sql.append(" (SELECT mae.DES_CORT FROM MAE_PRODU mae WHERE ped.prod_oid_prod = mae.OID_PROD) as descripcionSAP, ");
			sql.append(" ped.VAL_IMPO_DES_SIN_IMP_TOTA_DOCU as importeDescuentoSinImpuestosTD, ");
			sql.append(" ped.VAL_IMPO_DES_SIN_IMP_TOTA as importeDescuentoSinImpuestosTL, ");
			sql.append(" ped.VAL_IMPO_DES_SIN_IMP_UNIT_LOCA as importeDescuentoSinImpuestosUL, ");
			sql.append(" ped.VAL_IMPO_DES_SIN_IMP_UNIT_DOCU as importeDescuentoSinImpuestosUD, ");
			sql.append(" ped.VAL_IMPO_DESC_TOTA_DOCU as importeDescuentoTD, ");
			sql.append(" ped.VAL_IMPO_DESC_TOTA_LOCA as importeDescuentoTL, ");
			sql.append(" ped.VAL_IMPO_DESC_UNIT_DOCU as importeDescuentoUD, ");
			sql.append(" ped.VAL_IMPO_DESC_UNIT_LOCA as importeDescuentoUL, ");
			sql.append(" ped.VAL_IMPO_IMPU_TOTA_DOCU as importeImpuestoTD, ");
			sql.append(" ped.VAL_IMPO_IMPU_TOTA_LOCA as importeImpuestoTL, ");
			sql.append(" ped.VAL_IMPO_IMPU_UNIT_DOCU as importeImpuestoUD, ");
			sql.append(" ped.VAL_IMPO_IMPU_UNIT_LOCA as importeImpuestoUL, ");
			sql.append(" ped.IND_DENT_FUER_CAJA_BOLS as indicadorDentroFueraCajaBolsa, ");
			sql.append(" ped.TAIM_OID_TASA_IMPU as indicadorImpuestos, ");
			sql.append(" ped.IND_NO_IMPR as indicadorNoImprimible, ");
			sql.append(" (SELECT neg.NEGO_OID_NEGO FROM MAE_PRODU neg WHERE ped.prod_oid_prod = neg.oid_prod) as negocioProducto, ");//INCIDENCIA: 10094
			sql.append(" ped.NUM_CONS as numeroConsolidado, ");
			sql.append(" ped.COD_POSI as numeroPosicion, ");
			sql.append(" ped.SOCA_OID_SOLI_CABE as oidCabecera, ");
			sql.append(" ped.FOPA_OID_FORM_PAGO as oidFormaPago, ");
			sql.append(" ped.OID_SOLI_POSI as oidPosicion, ");
			sql.append(" (SELECT ofe.NUM_PAGI_CATA FROM PRE_OFERT_DETAL ofe WHERE ped.OFDE_OID_DETA_OFER=ofe.OID_DETA_OFER) as pagina, ");
			sql.append(" ped.VAL_PREC_CATA_TOTA_DOCU as precioCatalogoTD, ");
			sql.append(" ped.VAL_PREC_CATA_TOTA_LOCA_UNID as preCatalTLUnidadesDemandaReal, ");
			sql.append(" ped.VAL_PREC_CATA_TOTA_LOCA as precioCatalogoTL, ");
			sql.append(" ped.VAL_PREC_CATA_UNIT_DOCU as precioCatalogoUD, ");
			sql.append(" ped.VAL_PREC_CATA_UNIT_LOCA as precioCatalogoUL, ");
			sql.append(" ped.VAL_PREC_SIN_IMPU_UNIT_DOCU as precioContableSinImpuestosUD, ");
			sql.append(" ped.VAL_PREC_SIN_IMPU_UNIT_LOCA as precioContableSinImpuestosUL, ");
			sql.append(" ped.VAL_PREC_CONT_TOTA_DOCU as precioContableTD, ");
			sql.append(" ped.VAL_PREC_CONT_TOTA_LOCA as precioContableTL, ");
			sql.append(" ped.VAL_PREC_CONTA_UNIT_DOCU as precioContableUD, ");
			sql.append(" ped.VAL_PREC_CONT_UNIT_LOCA as precioContableUL, ");
			sql.append(" ped.VAL_PREC_FACT_TOTA_DOCU as precioFacturaTD, ");
			sql.append(" ped.VAL_PREC_FACT_TOTA_LOCA as precioFacturaTL, ");
			sql.append(" ped.VAL_PREC_FACT_UNIT_DOCU as precioFacturaUD, ");
			sql.append(" ped.VAL_PREC_FACT_UNIT_LOCA as precioFacturaUL, ");
			sql.append(" ped.VAL_PREC_NETO_TOTA_DOCU as precioNetoTD, ");
			sql.append(" ped.VAL_PREC_NETO_TOTA_LOCA as precioNetoTL, ");
			sql.append(" ped.VAL_PREC_NETO_UNIT_DOCU as precioNetoUD, ");
			sql.append(" ped.VAL_PREC_NETO_UNIT_LOCA as precioNetoUL, ");
			sql.append(" ped.VAL_PREC_SIN_IMPU_TOTA_DOCU as precioSinImpuestosTD, ");
			sql.append(" ped.VAL_PREC_SIN_IMPU_TOTA_LOCA as precioSinImpuestosTL, ");
			sql.append(" ped.VAL_PREC_SIN_IMPU_UNIT_DOCU as precioSinImpuestosUD, ");
			sql.append(" ped.VAL_PREC_SIN_IMPU_UNIT_LOCA as precioSinImpuestosUL, ");
			sql.append(" ped.VAL_PREC_TOTA_TOTA_DOCU as precioTotalTD, ");
			sql.append(" ped.VAL_PREC_TOTA_TOTA_LOCA as precioTotalTL, ");
			sql.append(" ped.VAL_PREC_TOTA_UNIT_DOCU as precioTotalUD, ");
			sql.append(" ped.VAL_PREC_TOTA_UNIT_LOCA as precioTotalUL, ");
			sql.append(" ped.PROD_OID_PROD as producto, ");            
			sql.append(" (SELECT tas.VAL_TASA_IMPU FROM PED_TASA_IMPUE tas WHERE ped.TAIM_OID_TASA_IMPU = tas.OID_TASA_IMPU) as tasaImpuesto, ");
			sql.append(" (SELECT ofer.TOFE_OID_TIPO_OFER FROM PRE_OFERT_DETAL ofer WHERE ped.OFDE_OID_DETA_OFER=ofer.OID_DETA_OFER) as tipoOferta, ");//INCIDENCIA: 10094
			sql.append(" ped.NUM_UNID_ATEN as unidadesAtendidas, ");
			sql.append(" ped.NUM_UNID_COMPR as unidadesComprometidas, ");
			sql.append(" ped.NUM_UNID_DEMA_REAL as unidadesDemandaReal, ");
			sql.append(" ped.NUM_UNID_POR_ATEN as unidadesPorAtender, ");
			sql.append(" (SELECT sol.PAIS_OID_PAIS FROM PED_SOLIC_CABEC sol WHERE ped.SOCA_OID_SOLI_CABE = sol.OID_SOLI_CABE) as pais, ");
			sql.append(" (SELECT sol.FEC_CRON FROM PED_SOLIC_CABEC sol WHERE ped.SOCA_OID_SOLI_CABE = sol.OID_SOLI_CABE) as fecha, ");
			sql.append(" ped.VAL_PORC_DESC as porcentajeDescuento, ");
			sql.append(" (SELECT TOF.COD_TIPO_OFER FROM PRE_TIPO_OFERT TOF, PRE_OFERT_DETAL OD ");
      sql.append(" WHERE TOF.OID_TIPO_OFER = OD.TOFE_OID_TIPO_OFER  AND OD.OID_DETA_OFER = ped.OFDE_OID_DETA_OFER) codigoTipoOferta, ");
      sql.append(" ped.ESPO_OID_ESTA_POSI as estado, ");
      sql.append(" ped.TPOS_OID_TIPO_POSI as tipoPosicion, ");
			sql.append(" ped.STPO_OID_SUBT_POSI as subtipoPosicion ");
            sql.append(" , ped.ofde_oid_deta_ofer OIDDETAOFER ");   // HRCS - Fecha 12/07/2007 - Incidencia Sicc20070353
            sql.append(" , PQ_APL_AUX.Valor_Gen_I18n_Sicc(" + oidIdioma + ", ped.prod_oid_prod,'MAE_PRODU') DESC_PROD_I18N");
			sql.append(" FROM PED_SOLIC_POSIC ped ");
			sql.append(" WHERE  SOCA_OID_SOLI_CABE IN( " + listaFinal +")"); 

			for(int i=0;i<listaOIDs.size();i++){
				if(listaOIDs.get(i)!=null){
					parametros.add(listaOIDs.get(i));
				}
			}			
			

			BelcorpService bs = UtilidadesEJB.getBelcorpService();
			RecordSet rs = null;
			String codigoError = null;
			try {
				rs = bs.dbService.executePreparedQuery(sql.toString(), parametros);
			} catch (Exception e) {
				codigoError = CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS;
				UtilidadesLog.error("obtenerPosicionesCabeceras: Exception",e);
				this.logSql("obtenerPosicionesCabeceras. SQL: ",sql.toString(), parametros);
				throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));
			}

		UtilidadesLog.debug("rs = " + rs);
        
		if(!rs.esVacio()){
			Vector vector=new Vector();
			for(int i=0;i<rs.getRowCount();i++){
				DTOFACPosicionSolicitud dtoPS= new DTOFACPosicionSolicitud();

				//Catalogo
				if (rs.getValueAt(i,0)!=null) {
					dtoPS.setCatalogo(new Integer(((BigDecimal)rs.getValueAt(i,0)).intValue()));
				}
				//CodigoVenta
				if (rs.getValueAt(i,1)!=null) {
					dtoPS.setCodigoVenta(rs.getValueAt(i,1).toString());
				}
				//Descripcion SAP
				if (rs.getValueAt(i,2)!=null) {
					dtoPS.setDescripcionSAP(rs.getValueAt(i,2).toString());
				}
				//importeDescuentoSinImpuestosTD
				if (rs.getValueAt(i,3)!=null) {
					dtoPS.setImporteDescuentoSinImpuestosTD(new Float(((BigDecimal)rs.getValueAt(i,3)).floatValue()));
				}
				//importeDescuentoSinImpuestosTL
				if (rs.getValueAt(i,4)!=null) {
					dtoPS.setImporteDescuentoSinImpuestosTL(new Float(((BigDecimal)rs.getValueAt(i,4)).floatValue()));
				}
				//importeDescuentoSinImpuestosUL
				if (rs.getValueAt(i,5)!=null) {
					dtoPS.setImporteDescuentoSinImpuestosUL(new Float(((BigDecimal)rs.getValueAt(i,5)).floatValue()));
				}
				//importeDescuentoSinImpuestosUD
				if (rs.getValueAt(i,6)!=null) {
					dtoPS.setImporteDescuentoSinImpuestosUD(new Float(((BigDecimal)rs.getValueAt(i,6)).floatValue()));
				}
				//importeDescuentoTD
				if (rs.getValueAt(i,7)!=null) {
					dtoPS.setImporteDescuentoTD(new Float(((BigDecimal)rs.getValueAt(i,7)).floatValue()));
				}
				//importeDescuentoTL
				if (rs.getValueAt(i,8)!=null) {
					dtoPS.setImporteDescuentoTL(new Float(((BigDecimal)rs.getValueAt(i,8)).floatValue()));
				}
				//importeDescuentoUD
				if (rs.getValueAt(i,9)!=null) {
					dtoPS.setImporteDescuentoUD(new Float(((BigDecimal)rs.getValueAt(i,9)).floatValue()));
				}else{
                    dtoPS.setImporteDescuentoUD(new Float("0"));
                }
				//importeDescuentoUL
				if (rs.getValueAt(i,10)!=null) {
					dtoPS.setImporteDescuentoUL(new Float(((BigDecimal)rs.getValueAt(i,10)).floatValue()));
				}else{
                    dtoPS.setImporteDescuentoUL(new Float("0"));
                }
				//importeImpuestoTD
				if (rs.getValueAt(i,11)!=null) {
					dtoPS.setImporteImpuestoTD(new Float(((BigDecimal)rs.getValueAt(i,11)).floatValue()));
				}
				//importeImpuestoTL
				if (rs.getValueAt(i,12)!=null) {
					dtoPS.setImporteImpuestoTL(new Float(((BigDecimal)rs.getValueAt(i,12)).floatValue()));
				}
				//importeImpuestoUD
				if (rs.getValueAt(i,13)!=null) {
					dtoPS.setImporteImpuestoUD(new Float(((BigDecimal)rs.getValueAt(i,13)).floatValue()));
				}
				//importeImpuestoUL
				if (rs.getValueAt(i,14)!=null) {
					dtoPS.setImporteImpuestoUL(new Float(((BigDecimal)rs.getValueAt(i,14)).floatValue()));
				}

				//indicadorDentroFueraCajaBolsa
				if (rs.getValueAt(i,15)!=null) {
					dtoPS.setIndicadorDentroFueraCajaBolsa(rs.getValueAt(i,15).toString());
				}
				//IndicadorImpuestos
				if(rs.getValueAt(i,16)!=null){
					// se cambia a Long por el diseño SICC-DMCO-FAC-201-364-N005-2 y por incidencia 9187
					dtoPS.setIndicadorImpuestos(new Long(((BigDecimal)rs.getValueAt(i,16)).longValue()));
				}

				//IndicadorNoImprimible
				if(rs.getValueAt(i,17)!=null){
					if (((BigDecimal)rs.getValueAt(i,17)).intValue()==0){
						dtoPS.setIndicadorNoImprimible(new Boolean(false));						
					}else{
						dtoPS.setIndicadorNoImprimible(new Boolean(true));						
					}
				}else{ //si es nulo, se considera como false
                    dtoPS.setIndicadorNoImprimible(new Boolean(false));	    
                }

				//negocioProducto
				if(rs.getValueAt(i,18)!=null){
					dtoPS.setNegocioProducto(new Long(((BigDecimal)rs.getValueAt(i,18)).longValue()));
				}
				//NumeroConsolidado
				if(rs.getValueAt(i,19)!=null){
					dtoPS.setNumeroConsolidado(new Long(((BigDecimal)rs.getValueAt(i,19)).longValue()));
				}
				//numeroPosicion
				if(rs.getValueAt(i,20)!=null){
					dtoPS.setNumeroPosicion(new Integer(((BigDecimal)rs.getValueAt(i,20)).intValue()));
				}
				//oidCabecera
				if(rs.getValueAt(i,21)!=null){
					dtoPS.setOidCabecera(new Long(((BigDecimal)rs.getValueAt(i,21)).longValue()));
				}
				//oidFormaPago
				if(rs.getValueAt(i,22)!=null){
					dtoPS.setOidFormaPago(new Long(((BigDecimal)rs.getValueAt(i,22)).longValue()));
				}
				//oidPosicion
				if(rs.getValueAt(i,23)!=null){
					dtoPS.setOidPosicion(new Long(((BigDecimal)rs.getValueAt(i,23)).longValue()));
				}

				//pagina
				if(rs.getValueAt(i,24)!=null){
					dtoPS.setPagina(new Integer(((BigDecimal)rs.getValueAt(i,24)).intValue()));
				}
				//PrecioCatalogoTD
				if(rs.getValueAt(i,25)!=null){
					dtoPS.setPrecioCatalogoTD(new Float(((BigDecimal)rs.getValueAt(i,25)).floatValue()));
				}
				//PrecioCatalogoTLUnidadesDemandaReal
				if(rs.getValueAt(i,26)!=null){
					dtoPS.setPrecioCatalogoTLUnidadesDemandaReal(new Float(((BigDecimal)rs.getValueAt(i,26)).floatValue()));
				}
				//PrecioCatalogoTL
				if(rs.getValueAt(i,27)!=null){
					dtoPS.setPrecioCatalogoTL(new Float(((BigDecimal)rs.getValueAt(i,27)).floatValue()));
				}
				//PrecioCatalogoUD
				if(rs.getValueAt(i,28)!=null){
					dtoPS.setPrecioCatalogoUD(new Float(((BigDecimal)rs.getValueAt(i,28)).floatValue()));
				}
				//PrecioCatalogoUL
				if(rs.getValueAt(i,29)!=null){
					dtoPS.setPrecioCatalogoUL(new Float(((BigDecimal)rs.getValueAt(i,29)).floatValue()));
				}
				//PrecioContableSinImpuestosUD
				if(rs.getValueAt(i,30)!=null){
					dtoPS.setPrecioContableSinImpuestosUD(new Float(((BigDecimal)rs.getValueAt(i,30)).floatValue()));
				}
				//PrecioContableSinImpuestosUL
				if(rs.getValueAt(i,31)!=null){
					dtoPS.setPrecioContableSinImpuestosUL(new Float(((BigDecimal)rs.getValueAt(i,31)).floatValue()));
				}

				//PrecioContableTD
				if(rs.getValueAt(i,32)!=null){
					dtoPS.setPrecioContableTD(new Float(((BigDecimal)rs.getValueAt(i,32)).floatValue()));
				}
				//PrecioContableTL
				if(rs.getValueAt(i,33)!=null){
					dtoPS.setPrecioContableTL(new Float(((BigDecimal)rs.getValueAt(i,33)).floatValue()));
				}
				//PrecioContableUD
				if(rs.getValueAt(i,34)!=null){
					dtoPS.setPrecioContableUD(new Float(((BigDecimal)rs.getValueAt(i,34)).floatValue()));
				}
				//PrecioContableUL
				if(rs.getValueAt(i,35)!=null){
					dtoPS.setPrecioContableUL(new Float(((BigDecimal)rs.getValueAt(i,35)).floatValue()));
				}
				//PrecioFacturaTD
				if(rs.getValueAt(i,36)!=null){
					dtoPS.setPrecioFacturaTD(new Float(((BigDecimal)rs.getValueAt(i,36)).floatValue()));
				}
				//PrecioFacturaTL
				if(rs.getValueAt(i,37)!=null){
					dtoPS.setPrecioFacturaTL(new Float(((BigDecimal)rs.getValueAt(i,37)).floatValue()));
				}
				//PrecioFacturaUD
				if(rs.getValueAt(i,38)!=null){
					dtoPS.setPrecioFacturaUD(new Float(((BigDecimal)rs.getValueAt(i,38)).floatValue()));
				}
				//PrecioFacturaUL
				if(rs.getValueAt(i,39)!=null){
					dtoPS.setPrecioFacturaUL(new Float(((BigDecimal)rs.getValueAt(i,39)).floatValue()));
				}
				//PrecioNetoTD
				if(rs.getValueAt(i,40)!=null){
					dtoPS.setPrecioNetoTD(new Float(((BigDecimal)rs.getValueAt(i,40)).floatValue()));
				}
				//PrecioNetoTL
				if(rs.getValueAt(i,41)!=null){
					dtoPS.setPrecioNetoTL(new Float(((BigDecimal)rs.getValueAt(i,41)).floatValue()));
				}
				//PrecioNetoUD
				if(rs.getValueAt(i,42)!=null){
					dtoPS.setPrecioNetoUD(new Float(((BigDecimal)rs.getValueAt(i,42)).floatValue()));
				}
				//PrecioNetoUL
				if(rs.getValueAt(i,43)!=null){
					dtoPS.setPrecioNetoUL(new Float(((BigDecimal)rs.getValueAt(i,43)).floatValue()));
				}

				//PrecioSinImpuestosTD
				if(rs.getValueAt(i,44)!=null){
					dtoPS.setPrecioSinImpuestosTD(new Float(((BigDecimal)rs.getValueAt(i,44)).floatValue()));
				}
				//PrecioSinImpuestosTL
				if(rs.getValueAt(i,45)!=null){
					dtoPS.setPrecioSinImpuestosTL(new Float(((BigDecimal)rs.getValueAt(i,45)).floatValue()));
				}
				//PrecioSinImpuestosUD
				if(rs.getValueAt(i,46)!=null){
					dtoPS.setPrecioSinImpuestosUD(new Float(((BigDecimal)rs.getValueAt(i,46)).floatValue()));
				}
				//PrecioSinImpuestosUL
				if(rs.getValueAt(i,47)!=null){
					dtoPS.setPrecioSinImpuestosUL(new Float(((BigDecimal)rs.getValueAt(i,47)).floatValue()));
				}

				//precioTotalTD
				if(rs.getValueAt(i,48)!=null){
					dtoPS.setPrecioTotalTD(new Float(((BigDecimal)rs.getValueAt(i,48)).floatValue()));
				}
				//precioTotalTL
				if(rs.getValueAt(i,49)!=null){
					dtoPS.setPrecioTotalTL(new Float(((BigDecimal)rs.getValueAt(i,49)).floatValue()));
				}
				//precioTotalUD
				if(rs.getValueAt(i,50)!=null){
					dtoPS.setPrecioTotalUD(new Float(((BigDecimal)rs.getValueAt(i,50)).floatValue()));
				}
				//precioTotalUL
				if(rs.getValueAt(i,51)!=null){
					dtoPS.setPrecioTotalUL(new Float(((BigDecimal)rs.getValueAt(i,51)).floatValue()));
				}
				//producto
				if(rs.getValueAt(i,52)!=null){
					dtoPS.setProducto(new Long(((BigDecimal)rs.getValueAt(i,52)).longValue()));
				}

				//tasaImpuesto
				if(rs.getValueAt(i,53)!=null){
					dtoPS.setTasaImpuesto(new Float(((BigDecimal)rs.getValueAt(i,53)).floatValue()));
				}
				//tipoOferta
				if(rs.getValueAt(i,54)!=null){
					dtoPS.setTipoOferta(new Long(((BigDecimal)rs.getValueAt(i,54)).longValue()));
				}

				//UnidadesAtendidas
				if(rs.getValueAt(i,55)!=null){
					dtoPS.setUnidadesAtendidas(new Integer(((BigDecimal)rs.getValueAt(i,55)).intValue()));
				}
				//UnidadesComprometidas
				if(rs.getValueAt(i,56)!=null){
					dtoPS.setUnidadesComprometidas(new Integer(((BigDecimal)rs.getValueAt(i,56)).intValue()));
				}else{
                    dtoPS.setUnidadesComprometidas(new Integer("0"));    
                }
				//UnidadesDemandaReal
				if(rs.getValueAt(i,57)!=null){
					dtoPS.setUnidadesDemandaReal(new Integer(((BigDecimal)rs.getValueAt(i,57)).intValue()));
				}
				//UnidadesPorAtender
				if(rs.getValueAt(i,58)!=null){
					dtoPS.setUnidadesPorAtender(new Integer(((BigDecimal)rs.getValueAt(i,58)).intValue()));
				}
				//pais
				if(rs.getValueAt(i,59)!=null){
					dtoPS.setOidPais(new Long(((BigDecimal)rs.getValueAt(i,59)).longValue()));
				}
				//fecha
				if(rs.getValueAt(i,60)!=null){
					dtoPS.setFecha(new Date(((java.sql.Date)rs.getValueAt(i,60)).getTime()));
				}
				//porcentajeDescuento
                if(rs.getValueAt(i,61)!=null){
					dtoPS.setPorcentajeDescuento(new Float(((BigDecimal)rs.getValueAt(i,61)).floatValue()));
				}
                // añadido incidencia 15873
                //codigoTipoOferta
                if(rs.getValueAt(i,62)!=null){
					dtoPS.setCodigoTipoOferta(rs.getValueAt(i,62).toString());
				}
                
                if(rs.getValueAt(i,63)!=null){
                    dtoPS.setEstado(new Long(((BigDecimal)rs.getValueAt(i,63)).longValue()));
                }
                
                if(rs.getValueAt(i,64)!=null) {                    
                    dtoPS.setOidTipoPosicion(new Long(((BigDecimal)rs.getValueAt(i,64)).longValue()));                 
                }
                
                if(rs.getValueAt(i,65)!=null) {
                    dtoPS.setOidSubtipoPosicion(new Long(((BigDecimal)rs.getValueAt(i,65)).longValue()));
                }
                
                //  Agregado por HRCS - Fecha 12/07/2007 - Incidencia Sicc20070353
                //  Oid Detalle Oferta
                if(rs.getValueAt(i,66)!=null) {
                    dtoPS.setOidDetaOferta(new Long(((BigDecimal)rs.getValueAt(i,66)).longValue()));
                }
                
                if(rs.getValueAt(i, 67) != null) {
                    dtoPS.setDecripcionSAPI18N(rs.getValueAt(i, 67).toString());
                } else {
                    dtoPS.setDecripcionSAPI18N(new String(""));
                }           
                
				listaDtos.add(dtoPS);//guardamos el DTO en el array list
			}//for
					
		}//if(rs.esvacio)	
		UtilidadesLog.info("DAOSolicitudCabecera.obtenerPosicionesCabeceras (ArrayList listaOIDs, Long oidIdioma): Salida");

        return listaDtos;
			

	}//metodo


	public ArrayList obtenerCabecerasSolicitud (ArrayList listaOIDs) throws MareException {

		UtilidadesLog.info("DAOSolicitudCabecera.obtenerCabecerasSolicitud (ArrayList listaOIDs): Entrada");
			
		ArrayList listaDtos=new ArrayList();
		Vector parametros = new Vector();
		StringBuffer sql=new StringBuffer();

		//String listaFinal =this.convertirArrayToString(listaOIDs); 

		sql.append(" SELECT ");
		sql.append(" SC.ACFI_OID_ACCE_FISI as ACCESOFISICO, ");
		sql.append(" SC.ALMC_OID_ALMA as ALMACEN, ");
		sql.append(" SC.CLSO_OID_CLAS_SOLI as CLASESOLICITUD, ");
		sql.append(" SC.CLAS_OID_CLAS_FLET as CLASIFICACION, ");
		sql.append(" SC.CLIE_OID_CLIE as OIDCLIENTE, ");
		sql.append(" SC.CLIE_OID_CONS_ASOC as CONSULTORAASOCIADA, ");
		sql.append(" SC.TCCL_OID_TCCL_FLET as TIPOCLASIFICACION, ");
		sql.append(" SC.ESSO_OID_ESTA_SOLI as ESTADO, ");
		sql.append(" SC.CLIE_OID_CLIE_DEST as DESTINATARIO, ");
		sql.append(" SC.FEC_CRON as FECHA, ");
		sql.append(" SC.FEC_FACT as FECHAFACTURACION, ");
		sql.append(" SC.FEC_PROG_FACT as FECHAPREVISTAFACTURACION, ");
		sql.append(" SC.FOPA_OID_FORM_PAGO as FORMAPAGO, ");
		sql.append(" SC.GRPR_OID_GRUP_PROC as GRUPOPROCESOS, ");
		sql.append(" SC.IND_APLI_MANU as INDICADORAPLICACIONMANUAL, ");
		sql.append(" SC.IND_ESTA as INDICADORESTADISTICABLE, ");
		sql.append(" SC.IND_EXEN_FLET as INDICADOREXENTOFLETE, ");
		sql.append(" SC.IND_GENE_CC as INDICADORGENERACUENTACORRIENTE, ");
		sql.append(" SC.IND_IMPR as INDICADORIMPRESION, ");
		sql.append(" SC.TAIM_OID_TASA_IMPU as INDICADORIMPUESTOSFLETE, ");
		sql.append(" SC.IND_OC as INDICADORORDENCOMPRA, ");
		sql.append(" SC.IND_PEDI_PRUE as INDICADORPEDIDOPRUEBA, ");
		sql.append(" SC.IND_PERM_UNIO_SOL as PERMITEUNIONSOLICITUDES, ");
		sql.append(" SC.IND_TS_NO_CONSO as INDICADORTSNOCONSOLIDADO, ");
		sql.append(" SC.INRE_OID_INDI_REVI as INDICADORREVISION, ");  //pperez Incidencia BELC300023071
		//marca -> se saca de la relación con CRA_PERIO a través del campo PERD_OID_PERI de la tabla PED_SOLIC_CABEC 
		//sql.append(" (SELECT MARC_OID_MARC FROM CRA_PERIO P WHERE P.OID_PERI = SC.PERD_OID_PERI) as marca, ");
		// Se sustituye por 
		sql.append(" P.MARC_OID_MARC as MARCA, ");

		sql.append(" SC.MODU_OID_MODU as MODULO, ");
		sql.append(" SC.MONE_OID_MONE as MONEDA, ");
		sql.append(" SC.NUM_CLIEN as NUMEROCLIENTES, ");
		// numeroConsolidado -> si SOCA_OID_SOLI_CABE <> null, se accede por OID_SOLI_CABE = SOCA_OID_SOLI_CABE y se 
		//obtiene el campo VAL_NUME_SOLI 
		sql.append(" DECODE(SC.SOCA_OID_SOLI_CABE,NULL,NULL,(SELECT VAL_NUME_SOLI FROM PED_SOLIC_CABEC SCA WHERE SCA.OID_SOLI_CABE = SC.SOCA_OID_SOLI_CABE) ) as NUMEROCONSOLIDADO, ");
		sql.append(" SC.NUM_DOCU_ORIG as NUMERODOCUMENTOORIGEN, ");
		sql.append(" SC.NUM_PREM as NUMEROPREMIO, ");
		//numeroSecuenciaFacturacionDiaria -> se accede a la tabla PED_SOLIC_CABE_SECUE usando OID_SOLI_CABE, y se 
		//obtiene NUM_SECU_FACT_DIAR 
		//sql.append(" (SELECT NUM_SECU_FACT_DIAR FROM PED_SOLIC_CABEC_SECUE SCS WHERE SCS.SOCA_OID_SOLI_CABE = SC.OID_SOLI_CABE ) as numeroSecuenciaFactDiaria, ");
		// Se sustituye por:
		sql.append(" SCS.NUM_SECU_FACT_DIAR as NUMEROSECUENCIAFACTDIARIA, ");
		//numeroSecuenciaZonaRuta -> se accede a la tabla PED_SOLIC_CABE_SECUE usando OID_SOLI_CABE, y se 
		//obtiene NUM_SECU_ZONA_RUTA 
		//sql.append(" (SELECT NUM_SECU_ZONA_RUTA FROM PED_SOLIC_CABEC_SECUE SCS WHERE SCS.SOCA_OID_SOLI_CABE = SC.OID_SOLI_CABE ) as numeroSecuenciaZonaRuta, ");
		//Se sustituye por :
		sql.append(" SCS.NUM_SECU_ZONA_RUTA as NUMEROSECUENCIAZONARUTA, ");
		
		sql.append(" SC.OID_SOLI_CABE as OIDCABECERASOLICITUD, ");
		sql.append(" SC.SOCA_OID_SOLI_CABE as OIDCONSOLIDADO, ");
		sql.append(" SC.CLDI_OID_CLIE_DIRE as OIDDIRECCIONCLIENTE, ");
		sql.append(" SC.CLIE_OID_CLIE_PAGA as OIDPAGADORFACTURA, ");
		sql.append(" SC.OPER_OID_OPER as OPERACION, ");
		sql.append(" SC.PAIS_OID_PAIS as PAIS, ");
		sql.append(" SC.PERD_OID_PERI as PERIODO, ");
		sql.append(" SC.PROC_OID_PROC as PROCESO, ");
		sql.append(" SC.VAL_PREC_NETO_TOTA_LOCA as PRECIOTOTALTOTALLOCAL, ");
		sql.append(" SC.VAL_PREC_NETO_TOTA_DOCU as PRECIOTOTALTOTALDOCUMENTO, ");
		sql.append(" SC.VAL_PUNT_EMIS as PUNTOEMISION, ");
		sql.append(" SC.CLIE_OID_CLIE_RECE_FACT as RECEPTORFACTURA, ");
		//oidSubgVentas -> se hace la JOIN ZON_ZONA->ZON_REGIO y se coge el campo ZSGV_OID_SUBG_VENT
		sql.append(" (SELECT ZSGV_OID_SUBG_VENT FROM ZON_REGIO REG , ZON_ZONA Z  WHERE Z.OID_ZONA = SC.ZZON_OID_ZONA AND Z.ZORG_OID_REGI = REG.OID_REGI) as OIDSUBGVENTAS, ");

		//region -> se accede a la tabla ZON_ZONA usando ZZON_OID_ZONA y se obtiene ZORG_OID_REGI, 
		//sql.append(" (SELECT ZORG_OID_REGI FROM ZON_ZONA Z WHERE Z.OID_ZONA = SC.ZZON_OID_ZONA) as region, ");
		// Se sustituye por:
		sql.append(" Z.ZORG_OID_REGI as REGION, ");
		
		//seccion -> se accede a la tabla ZON_TERRI_ADMI usando ZTAD_OID_TERR_ADMI, y se obtiene OID_SECC, 
		//sql.append(" (SELECT ZSCC_OID_SECC FROM ZON_TERRI_ADMIN TA WHERE TA.OID_TERR_ADMI = SC.ZTAD_OID_TERR_ADMI) as seccion, ");
		// Se sustituye por:
		sql.append(" TA.ZSCC_OID_SECC as SECCION, ");
		
		//secuenciaRutaTerritorio -> se accede a la tabla PED_SOLIC_CABE_SECUE usando OID_SOLI_CABE, y se 
		//obtiene VAL_SECU_RUTA_TERR 
		//sql.append(" (SELECT VAL_SECU_RUTA_TERR FROM PED_SOLIC_CABEC_SECUE SCS WHERE SCS.SOCA_OID_SOLI_CABE = SC.OID_SOLI_CABE ) as secuenciaRutaTerritorio, ");
		// Se sustituye por:
		sql.append(" SCS.VAL_SECU_RUTA_TERR as SECUENCIARUTATERRITORIO, ");
		
		sql.append(" SC.SBAC_OID_SBAC as SUBACCESO, ");
		sql.append(" SC.SBTI_OID_SUBT_CLIE as SUBTIPOCLIENTE, ");
		sql.append(" SC.ZTAD_OID_TERR_ADMI as TERRITORIOCLIENTE, ");
		sql.append(" SC.SOCA_OID_DOCU_REFE as OIDDOCUMENTOREFERENCIA, ");
		sql.append(" SC.SOCI_OID_SOCI as SOCIEDAD, ");
		sql.append(" SC.TDOC_OID_TIPO_DOCU as TIPODOCUMENTO, ");
		sql.append(" SC.TIDO_OID_TIPO_DOCU as TIPODOCUMENTOLEGAL, ");
		sql.append(" SC.TERR_OID_TERR as TERRITORIO, ");
		sql.append(" SC.TICL_OID_TIPO_CLIE as TIPOCLIENTE, ");
		sql.append(" SC.TIDS_OID_TIPO_DESP as TIPODESPACHO, ");
		sql.append(" SC.TSPA_OID_TIPO_SOLI_PAIS as TIPOSOLICITUD, ");
		sql.append(" SC.TSPA_OID_TIPO_SOLI_PAIS_CONS as TIPOSOLICITUDCONSOLIDADO, ");
		sql.append(" SC.VAL_BASE_FLET_DOCU as BASEFLETEDOCUMENTO, ");
		sql.append(" SC.VAL_BASE_FLET_LOCA as BASEFLETELOCAL, ");
		sql.append(" SC.VAL_GLOS_OBSE as OBSERVACIONES, ");
		sql.append(" SC.VAL_IMPO_DESC_1_TOTA_DOCU as IMPORTEDESCUENTO1TD, ");
		sql.append(" SC.VAL_IMPO_DESC_1_TOTA_LOCA as IMPORTEDESCUENTO1TL, ");
		sql.append(" SC.VAL_IMPO_DESC_3_TOTA_DOCU as IMPORTEDESCUENTO3TD, ");
		sql.append(" SC.VAL_IMPO_DESC_3_TOTA_LOCA as IMPORTEDESCUENTO3TL, ");
		sql.append(" SC.VAL_IMPO_DESC_TOTA_DOCU as IMPORTEDESCUENTOTD, ");
		sql.append(" SC.VAL_IMPO_DESC_TOTA_LOCA as IMPORTEDESCUENTOTL, ");
		sql.append(" SC.VAL_IMPO_FLET_DOCU as IMPORTEFLETEDOCUMENTO, ");
		sql.append(" SC.VAL_IMPO_FLET_LOCA as IMPORTEFLETELOCAL, ");
		sql.append(" SC.VAL_IMPO_FLET_SIN_IMPU_TOTA as IMPORTEFLETESIMPUESTOSTL, ");
		sql.append(" SC.VAL_IMPO_FLET_SIN_IMPU_DOCU as IMPORTEFLETESINIMPUESTOSTD, ");
		sql.append(" SC.VAL_IMPO_FLET_TOTA_DOCU as IMPORTEFLETETD, ");
		sql.append(" SC.VAL_IMPO_FLET_TOTA_LOCA as IMPORTEFLETETL, ");
		sql.append(" SC.VAL_NUME_SOLI as NUMEROSOLICITUD, ");
		sql.append(" SC.VAL_OTRO_RECA_DOCU as OTROSRECARGOSDOCUMENTO, ");
		sql.append(" SC.VAL_OTRO_RECA_LOCA as OTROSRECARGOSLOCAL, ");
		sql.append(" SC.VAL_PREC_CONT_TOTA_LOCA as PRECIOCONTABLETL, ");
		sql.append(" SC.VAL_RECA_FLET_DOCU as RECARGOFLETEDOCUMENTO, ");
		sql.append(" SC.VAL_RECA_FLET_LOCA as RECARGOFLETELOCAL, ");
		sql.append(" SC.VAL_TIPO_CAMB as TIPOCAMBIO, ");
		sql.append(" SC.VAL_TOTA_FLET_DOCU as TOTALFLETEDOCUMENTO, ");
		sql.append(" SC.VAL_TOTA_FLET_LOCA as TOTALFLETELOCAL, ");
		sql.append(" SC.VAL_TOTA_PAGA_DOCU as TOTALAPAGARDOCUMENTO, ");
		sql.append(" SC.VAL_TOTA_PAGA_LOCA as TOTALAPAGARLOCAL, ");
		sql.append(" SC.VAL_USUA as USUARIO, ");
		sql.append(" SC.ZZON_OID_ZONA as ZONA, ");
		sql.append(" P.CANA_OID_CANA as CANAL, "); // añadido
		sql.append(" SC.VEPO_OID_VALO_ESTR_GEOP as UBIGEO, "); // añadido por incidencia 10301
		sql.append(" SC.NUM_DOCU_CONT_INTE as NUMERODOCUMENTOCONTABLEINTERNO, "); //cambios paquete n21(FAC)
        sql.append(" SA.ACCE_OID_ACCE as ACCESO "); //añadido

		sql.append(" FROM PED_SOLIC_CABEC SC, SEG_SUBAC SA, CRA_PERIO P, ");
		sql.append(" PED_SOLIC_CABEC_SECUE SCS, ZON_ZONA Z, ZON_TERRI_ADMIN TA ");
	
		sql.append(" WHERE P.OID_PERI = SC.PERD_OID_PERI ");
		sql.append(" AND SC.SBAC_OID_SBAC = SA.OID_SBAC ");
		sql.append(" AND SCS.SOCA_OID_SOLI_CABE (+)= SC.OID_SOLI_CABE ");
		sql.append(" AND Z.OID_ZONA = SC.ZZON_OID_ZONA ");
		sql.append(" AND TA.OID_TERR_ADMI (+)= SC.ZTAD_OID_TERR_ADMI ");
		int x = 0;
    int y = 0;
    sql.append(" AND (  ");
    boolean cerre = false;
    int size = listaOIDs.size();
    while (x < size){
        if (y == 0){
            if (x != 0){
                sql.append(" OR ");
            }
            sql.append(" SC.OID_SOLI_CABE in ( ");
        }
        if (y < 999){
            Long oidSolicitud = (Long) listaOIDs.get(x);
            sql.append(oidSolicitud).append(" ,");
            y++;
            cerre = false;
        }else{
            y = 0;
            cerre = true;
            Long oidSolicitud = (Long) listaOIDs.get(x);
            sql.append(oidSolicitud).append(" ) ");
        }
        x++;        
        if (x == size && !cerre){
            sql.deleteCharAt(sql.length()-1);
            sql.append(" ) ");	
        }
    }
		sql.append(" ) ");

		
		BelcorpService bs = UtilidadesEJB.getBelcorpService();
		RecordSet rs = null;
		String codigoError = null;
		try {
			rs = bs.dbService.executePreparedQuery(sql.toString(), parametros);
		} catch (Exception e) {
			codigoError = CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS;
			UtilidadesLog.error("obtenerCabecerasSolicitud: Exception",e);
			this.logSql("obtenerCabecerasSolicitud. SQL: ",sql.toString(), parametros);
			throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));
		}
        UtilidadesLog.debug("rs = " + rs);
        
		DTOFACCabeceraSolicitud dtoCabSolic=null;
		if(!rs.esVacio()){
			Vector vector=new Vector();
      size = rs.getRowCount();
			for(int i=0;i<size;i++){
				dtoCabSolic= new DTOFACCabeceraSolicitud();
				//****** añadido incidencia 10301
				if(rs.getValueAt(i,"UBIGEO")!=null){
					Long ubigeo = new Long(((BigDecimal)rs.getValueAt(i,"UBIGEO")).longValue());
					dtoCabSolic.setUbigeo(ubigeo);
				}
				// **********
                //*********** añadido para el metodo MONProcesosFacturacion.continuarFacturacion
                if(rs.getValueAt(i,"ACCESO")!=null){
					Long acceso = new Long(((BigDecimal)rs.getValueAt(i,"ACCESO")).longValue());
					dtoCabSolic.setAcceso(acceso);
				}
                // ********************************
				if(rs.getValueAt(i,"CANAL")!=null){
					Long canal = new Long(((BigDecimal)rs.getValueAt(i,"CANAL")).longValue());
					dtoCabSolic.setCanal(canal);
				}
				if(rs.getValueAt(i,"ACCESOFISICO")!=null){
					Long accesoFisico = new Long(((BigDecimal)rs.getValueAt(i,"ACCESOFISICO")).longValue());
					dtoCabSolic.setAccesoFisico(accesoFisico);
				}
				if(rs.getValueAt(i,"NUMERODOCUMENTOCONTABLEINTERNO")!=null){
					dtoCabSolic.setNumeroDocumentoContableInterno(new Long(((BigDecimal)rs.getValueAt(i,"NUMERODOCUMENTOCONTABLEINTERNO")).longValue()));
				}
				if(rs.getValueAt(i,"ALMACEN")!=null){
					Long almacen = new Long(((BigDecimal)rs.getValueAt(i,"ALMACEN")).longValue());
					dtoCabSolic.setAlmacen(almacen);
				}
				if(rs.getValueAt(i,"CLASESOLICITUD")!=null){
					Long claseSolicitud = new Long(((BigDecimal)rs.getValueAt(i,"CLASESOLICITUD")).longValue());
					dtoCabSolic.setClaseSolicitud(claseSolicitud);
				}
				if(rs.getValueAt(i,"CLASIFICACION")!=null){
						Long clasificacion = new Long(((BigDecimal)rs.getValueAt(i,"CLASIFICACION")).longValue());
						dtoCabSolic.setClasificacion(clasificacion);
				}
				if(rs.getValueAt(i,"OIDCLIENTE")!=null){
						Long oidCliente = new Long(((BigDecimal)rs.getValueAt(i,"OIDCLIENTE")).longValue());
						dtoCabSolic.setOidCliente(oidCliente);
				}
				if(rs.getValueAt(i,"CONSULTORAASOCIADA")!=null){
					Long consultoraAsociada = new Long(((BigDecimal)rs.getValueAt(i,"CONSULTORAASOCIADA")).longValue());
					dtoCabSolic.setConsultoraAsociada(consultoraAsociada);
				}
				if(rs.getValueAt(i,"TIPOCLASIFICACION")!=null){
					Long tipoClasificacion = new Long(((BigDecimal)rs.getValueAt(i,"TIPOCLASIFICACION")).longValue());
					dtoCabSolic.setTipoClasificacion(tipoClasificacion);
				}
				if(rs.getValueAt(i,"ESTADO")!=null){
					Long estado = new Long(((BigDecimal)rs.getValueAt(i,"ESTADO")).longValue());
					dtoCabSolic.setEstado(estado);
				}
				if(rs.getValueAt(i,"DESTINATARIO")!=null){
					Long destinatario=new Long(((BigDecimal)rs.getValueAt(i,"DESTINATARIO")).longValue());
					dtoCabSolic.setDestinatario(destinatario);
				}
				if(rs.getValueAt(i,"FECHA") != null){
					Date fecha = (Date)rs.getValueAt(i,"FECHA");
					dtoCabSolic.setFecha(fecha);
				}
				if(rs.getValueAt(i,"FECHAFACTURACION") != null){
					Date fechaFact = (Date)rs.getValueAt(i,"FECHAFACTURACION");
					dtoCabSolic.setFechaFacturacion(fechaFact);
				}
				if(rs.getValueAt(i,"FECHAPREVISTAFACTURACION") != null){
					Date fechaPrevistaFacturacion = (Date)rs.getValueAt(i,"FECHAPREVISTAFACTURACION");
					dtoCabSolic.setFechaPrevistaFacturacion(fechaPrevistaFacturacion);
				}
				if(rs.getValueAt(i,"FORMAPAGO")!=null){
					Long formaPago = new Long(((BigDecimal)rs.getValueAt(i,"FORMAPAGO")).longValue());
					dtoCabSolic.setFormaPago(formaPago);
				}
				if(rs.getValueAt(i,"GRUPOPROCESOS")!=null){
					Long grupoProcesos = new Long(((BigDecimal)rs.getValueAt(i,"GRUPOPROCESOS")).longValue());
					dtoCabSolic.setGrupoProcesos(grupoProcesos);
				}
				Boolean indicadorAM;
				if(rs.getValueAt(i,"INDICADORAPLICACIONMANUAL")!=null){
					indicadorAM = new Boolean(((BigDecimal)rs.getValueAt(i, 
										"INDICADORAPLICACIONMANUAL")).intValue() == 1 ? true : false);	
					dtoCabSolic.setIndicadorAplicacionManual(indicadorAM);
				}
				Boolean indicadorE;
				if(rs.getValueAt(i,"INDICADORESTADISTICABLE")!=null){
					indicadorE=new Boolean(((BigDecimal)rs.getValueAt(i, 
									"INDICADORESTADISTICABLE")).intValue() == 1 ? true : false);	
					dtoCabSolic.setIndicadorEstadisticable(indicadorE);
				}
				Boolean indicadorExento;
				if(rs.getValueAt(i,"INDICADOREXENTOFLETE")!=null){
					indicadorExento=new Boolean(((BigDecimal)rs.getValueAt(i, 
									"INDICADOREXENTOFLETE")).intValue() == 1 ? true : false);		
					dtoCabSolic.setIndicadorExentoFlete(indicadorExento);
				}
				Boolean indicadorCuenta;
				if(rs.getValueAt(i,"INDICADORGENERACUENTACORRIENTE")!=null){
					indicadorCuenta=new Boolean(((BigDecimal)rs.getValueAt(i, 
									"INDICADORGENERACUENTACORRIENTE")).intValue() == 1 ? true : false);					
					dtoCabSolic.setIndicadorGeneraCuentaCorriente(indicadorCuenta);
				}
				Boolean indicadorImpresion;
				if(rs.getValueAt(i,"INDICADORIMPRESION")!=null){
					indicadorImpresion=new Boolean(((BigDecimal)rs.getValueAt(i, 
									"INDICADORIMPRESION")).intValue() == 1 ? true : false);					
					dtoCabSolic.setIndicadorImpresion(indicadorImpresion);
				}
			
				if(rs.getValueAt(i,"INDICADORIMPUESTOSFLETE")!=null){
					 Long indicadorImpuestosFlete = new Long(((BigDecimal)rs.getValueAt(i, 
									"INDICADORIMPUESTOSFLETE")).longValue());					
					dtoCabSolic.setIndicadorImpuestosFlete(indicadorImpuestosFlete);
				}
				Boolean indOrdenCompra;
				if(rs.getValueAt(i,"INDICADORORDENCOMPRA")!=null){
					indOrdenCompra=new Boolean(((BigDecimal)rs.getValueAt(i, 
									"INDICADORORDENCOMPRA")).intValue() == 1 ? true : false);
					dtoCabSolic.setIndicadorOrdenCompra(indOrdenCompra);
				}
				Boolean indPedidoPrueba;
				if(rs.getValueAt(i,"INDICADORPEDIDOPRUEBA")!=null){
					indPedidoPrueba=new Boolean(((BigDecimal)rs.getValueAt(i, 
									"INDICADORPEDIDOPRUEBA")).intValue() == 1 ? true : false);
					dtoCabSolic.setIndicadorPedidoPrueba(indPedidoPrueba);
				}
				Boolean permiteUnionS;
				if(rs.getValueAt(i,"PERMITEUNIONSOLICITUDES")!=null){
					permiteUnionS=new Boolean(((BigDecimal)rs.getValueAt(0, 
										"PERMITEUNIONSOLICITUDES")).intValue() == 1 ? true : false);
					dtoCabSolic.setPermiteUnionSolicitudes(permiteUnionS);
				}

				Boolean indicadorNoConso;
				if(rs.getValueAt(i,"INDICADORTSNOCONSOLIDADO")!=null){
					indicadorNoConso=new Boolean(((BigDecimal)rs.getValueAt(i, 
								"INDICADORTSNOCONSOLIDADO")).intValue() == 1 ? true : false);
					dtoCabSolic.setIndTSNoConsolidado(indicadorNoConso);
				}
				if (rs.getValueAt(i,"INDICADORREVISION")!=null) {
					Long indRevision=new Long(((BigDecimal)rs.getValueAt(i,"INDICADORREVISION")).longValue());
					dtoCabSolic.setIndicadorRevision(indRevision);
				}
				if(rs.getValueAt(i,"MARCA")!=null){
					Long marca = new Long(((BigDecimal)rs.getValueAt(i,"MARCA")).longValue());
					dtoCabSolic.setMarca(marca);
				}
				if(rs.getValueAt(i,"MODULO")!=null){
					Long modulo = new Long(((BigDecimal)rs.getValueAt(i,"MODULO")).longValue());
					dtoCabSolic.setModulo(modulo);
				}
				if(rs.getValueAt(i,"MONEDA")!=null){
					Long moneda=new Long(((BigDecimal)rs.getValueAt(i,"MONEDA")).longValue());
					dtoCabSolic.setMoneda(moneda);
				}
				if(rs.getValueAt(i,"NUMEROCLIENTES")!=null){
					Integer numCLientes=new Integer(((BigDecimal)rs.getValueAt(i,"NUMEROCLIENTES")).intValue());
					dtoCabSolic.setNumeroClientes(numCLientes);
				}
				if(rs.getValueAt(i,"NUMEROCONSOLIDADO")!=null){
					Long numeroConsolidado=new Long(rs.getValueAt(i,"NUMEROCONSOLIDADO").toString());
					dtoCabSolic.setNumeroConsolidado(numeroConsolidado);
				}
				if(rs.getValueAt(i,"NUMERODOCUMENTOORIGEN")!=null){
					Long numDocOrigen=new Long(((BigDecimal)rs.getValueAt(i,"NUMERODOCUMENTOORIGEN")).longValue());
					dtoCabSolic.setNumeroDocumentoOrigen(numDocOrigen);
				}
				if(rs.getValueAt(i,"NUMEROPREMIO")!=null){
					Integer numPrenio=new Integer(((BigDecimal)rs.getValueAt(i,"NUMEROPREMIO")).intValue());
					dtoCabSolic.setNumeroPremio(numPrenio);
				}
				if(rs.getValueAt(i,"NUMEROSECUENCIAFACTDIARIA")!=null){     
					Integer numSecuFactDiaria=new Integer(((BigDecimal)rs.getValueAt(i,"NUMEROSECUENCIAFACTDIARIA")).intValue());
					dtoCabSolic.setNumeroSecuenciaFacturacionDiaria(numSecuFactDiaria);
				}
				if(rs.getValueAt(i,"NUMEROSECUENCIAZONARUTA")!=null){     
					Integer numSecuZonaRuta=new Integer(((BigDecimal)rs.getValueAt(i,"NUMEROSECUENCIAZONARUTA")).intValue());
					dtoCabSolic.setNumeroSecuenciaZonaRuta(numSecuZonaRuta);
				}
				if(rs.getValueAt(i,"OIDCABECERASOLICITUD")!=null){
					Long oidCabeceraSolicitud=new Long(((BigDecimal)rs.getValueAt(i,"OIDCABECERASOLICITUD")).longValue());
					dtoCabSolic.setOidCabeceraSolicitud(oidCabeceraSolicitud);
				}
				if(rs.getValueAt(i,"OIDCONSOLIDADO")!=null){
					Long oidConsolidado=new Long(((BigDecimal)rs.getValueAt(i,"OIDCONSOLIDADO")).longValue());
					dtoCabSolic.setOidConsolidado(oidConsolidado);
				}
				if(rs.getValueAt(i,"OIDDIRECCIONCLIENTE")!=null){
					Long oidDireccionCliente=new Long(((BigDecimal)rs.getValueAt(i,"OIDDIRECCIONCLIENTE")).longValue());
					dtoCabSolic.setOidDireccionCliente(oidDireccionCliente);
				}
				if(rs.getValueAt(i,"OIDPAGADORFACTURA")!=null){
					Long oidPagadorFactura=new Long(((BigDecimal)rs.getValueAt(i,"OIDPAGADORFACTURA")).longValue());
					dtoCabSolic.setOidPagadorFactura(oidPagadorFactura);
				}
				
				if(rs.getValueAt(i,"OPERACION")!=null){
					Long operacion=new Long(((BigDecimal)rs.getValueAt(i,"OPERACION")).longValue());
					dtoCabSolic.setOperacion(operacion);
				}
				if(rs.getValueAt(i,"PAIS")!=null){
					Long pais=new Long(((BigDecimal)rs.getValueAt(i,"PAIS")).longValue());
					dtoCabSolic.setOidPais(pais);
				}
				if(rs.getValueAt(i,"PERIODO")!=null){
					Long periodo=new Long(((BigDecimal)rs.getValueAt(i,"PERIODO")).longValue());
					dtoCabSolic.setPeriodo(periodo);
				}
				if(rs.getValueAt(i,"PROCESO")!=null){
					Long proceso=new Long(((BigDecimal)rs.getValueAt(i,"PROCESO")).longValue());
					dtoCabSolic.setProceso(proceso);
				}
				if(rs.getValueAt(i,"PRECIOTOTALTOTALLOCAL")!=null){
					Float precioTotalTotalLocal = new Float(((BigDecimal)rs.getValueAt(i,"PRECIOTOTALTOTALLOCAL")).floatValue());
					dtoCabSolic.setPrecioTotalTotalLocal(precioTotalTotalLocal);
				}
				if(rs.getValueAt(i,"PRECIOTOTALTOTALDOCUMENTO")!=null){
					Float precioTotalTotalDocumento=new Float(((BigDecimal)rs.getValueAt(i,"PRECIOTOTALTOTALDOCUMENTO")).floatValue());
					dtoCabSolic.setPrecioTotalTotalDocumento(precioTotalTotalDocumento);
				}
				if(rs.getValueAt(i,"PUNTOEMISION")!=null){
					String puntoEmision = rs.getValueAt(i,"PUNTOEMISION").toString();
					dtoCabSolic.setPuntoEmision(puntoEmision);
				}
				if(rs.getValueAt(i,"RECEPTORFACTURA")!=null){
					Long receptorFactura=new Long(((BigDecimal)rs.getValueAt(i,"RECEPTORFACTURA")).longValue());
					dtoCabSolic.setReceptorFactura(receptorFactura);
				}
				if(rs.getValueAt(i,"OIDSUBGVENTAS")!= null){
					Long oidSubgVentas = new Long (((BigDecimal)rs.getValueAt(i,"OIDSUBGVENTAS")).longValue());
					dtoCabSolic.setOidSubgVentas(oidSubgVentas);
				}
				if(rs.getValueAt(i,"REGION")!=null){
					Long region=new Long(((BigDecimal)rs.getValueAt(i,"REGION")).longValue());
					dtoCabSolic.setRegion(region);
				}
				if(rs.getValueAt(i,"SECCION")!=null){
					Long seccion=new Long(((BigDecimal)rs.getValueAt(i,"SECCION")).longValue());
					dtoCabSolic.setSeccion(seccion);
				}
				if(rs.getValueAt(i,"SECUENCIARUTATERRITORIO")!=null){
					String secuenciaRutaTerritorio = rs.getValueAt(i,"SECUENCIARUTATERRITORIO").toString();
					dtoCabSolic.setSecuenciaRutaTerritorio(secuenciaRutaTerritorio);
				}
				if(rs.getValueAt(i,"SUBACCESO")!=null){
					Long subacceso = new Long(((BigDecimal)rs.getValueAt(i,"SUBACCESO")).longValue());
					dtoCabSolic.setSubacceso(subacceso);
				}
				if(rs.getValueAt(i,"SUBTIPOCLIENTE")!=null){
					Long subTipoCliente = new Long(((BigDecimal)rs.getValueAt(i,"SUBTIPOCLIENTE")).longValue());
					dtoCabSolic.setSubtipoCliente(subTipoCliente);
				}
				if(rs.getValueAt(i,"TERRITORIOCLIENTE")!=null){
					Long territorioCliente=new Long(((BigDecimal)rs.getValueAt(i,"TERRITORIOCLIENTE")).longValue());
					dtoCabSolic.setTerritorioCliente(territorioCliente);
				}
				if(rs.getValueAt(i,"OIDDOCUMENTOREFERENCIA")!=null){
					Long oidDocumentoReferencia=new Long(((BigDecimal)rs.getValueAt(i,"OIDDOCUMENTOREFERENCIA")).longValue());
					dtoCabSolic.setOidDocumentoReferencia(oidDocumentoReferencia);
				}
				if(rs.getValueAt(i,"SOCIEDAD")!=null){
					Long sociedad=new Long(((BigDecimal)rs.getValueAt(i,"SOCIEDAD")).longValue());
					dtoCabSolic.setSociedad(sociedad);
				}
				if(rs.getValueAt(i,"TIPODOCUMENTO")!=null){
					Long tipoDocumento=new Long(((BigDecimal)rs.getValueAt(i,"TIPODOCUMENTO")).longValue());
					dtoCabSolic.setTipoDocumento(tipoDocumento);
				}
				if(rs.getValueAt(i,"TIPODOCUMENTOLEGAL")!=null){
					Long tipoDocumentoLegal=new Long(((BigDecimal)rs.getValueAt(i,"TIPODOCUMENTOLEGAL")).longValue());
					dtoCabSolic.setTipoDocumentoLegal(tipoDocumentoLegal);
				}
				if(rs.getValueAt(i,"TERRITORIO")!=null){
					Long territorio=new Long(((BigDecimal)rs.getValueAt(i,"TERRITORIO")).longValue());
					dtoCabSolic.setTerritorio(territorio);
				}
				if(rs.getValueAt(i,"TIPOCLIENTE")!=null){
						Long tipoCliente=new Long(((BigDecimal)rs.getValueAt(i,"TIPOCLIENTE")).longValue());
						dtoCabSolic.setTipoCliente(tipoCliente);
				}
				if(rs.getValueAt(i,"TIPODESPACHO")!=null){
						Long tipoDespacho=new Long(((BigDecimal)rs.getValueAt(i,"TIPODESPACHO")).longValue());
						dtoCabSolic.setTipoDespacho(tipoDespacho);
				}
				if(rs.getValueAt(i,"TIPOSOLICITUD")!=null){
						Long tipoSolicitud=new Long(((BigDecimal)rs.getValueAt(i,"TIPOSOLICITUD")).longValue());
						dtoCabSolic.setTipoSolicitud(tipoSolicitud);
				}
				if(rs.getValueAt(i,"TIPOSOLICITUDCONSOLIDADO")!=null){
						Long tipoSolicConso=new Long(((BigDecimal)rs.getValueAt(i,"TIPOSOLICITUDCONSOLIDADO")).longValue());
						dtoCabSolic.setTipoSolicitudConsolidado(tipoSolicConso);
				}
				if(rs.getValueAt(i,"BASEFLETEDOCUMENTO")!=null){
						Float baseFleteDoc=new Float(((BigDecimal)rs.getValueAt(i,"BASEFLETEDOCUMENTO")).floatValue());
						dtoCabSolic.setBaseFleteDocumento(baseFleteDoc);
				}
				if(rs.getValueAt(i,"BASEFLETELOCAL")!=null){
						Float baseFleteLocal=new Float(((BigDecimal)rs.getValueAt(i,"BASEFLETELOCAL")).floatValue());
						dtoCabSolic.setBaseFleteLocal(baseFleteLocal);
				}
				if(rs.getValueAt(i,"OBSERVACIONES")!=null){
						String observ=rs.getValueAt(i,"OBSERVACIONES").toString();
						dtoCabSolic.setObservaciones(observ);
				}
				if(rs.getValueAt(i,"IMPORTEDESCUENTO1TD")!=null){
						Float imDes1TipDoc1=new Float(((BigDecimal)rs.getValueAt(i,"IMPORTEDESCUENTO1TD")).floatValue());
						dtoCabSolic.setImporteDescuento1TotalDocumento(imDes1TipDoc1);
				}
				if(rs.getValueAt(i,"IMPORTEDESCUENTO1TL")!=null){
						Float imDes1TipLocal1=new Float(((BigDecimal)rs.getValueAt(i,"IMPORTEDESCUENTO1TL")).floatValue());						dtoCabSolic.setImporteDescuento1TotalLocal(imDes1TipLocal1);
				}
				if(rs.getValueAt(i,"IMPORTEDESCUENTO3TD")!=null){
						Float imDes1TipDoc3=new Float(((BigDecimal)rs.getValueAt(i,"IMPORTEDESCUENTO3TD")).floatValue());
						dtoCabSolic.setImporteDescuento3TotalDocumento(imDes1TipDoc3);
				}
				if(rs.getValueAt(i,"IMPORTEDESCUENTO3TL")!=null){
						Float imDes1TipDoc3Local=new Float(((BigDecimal)rs.getValueAt(i,"IMPORTEDESCUENTO3TL")).floatValue());
						dtoCabSolic.setImporteDescuento3TotalLocal(imDes1TipDoc3Local);
				}
				if(rs.getValueAt(i,"IMPORTEDESCUENTOTD")!=null){
						Float imDes1TotDoc=new Float(((BigDecimal)rs.getValueAt(i,"IMPORTEDESCUENTOTD")).floatValue());
						dtoCabSolic.setImporteDescuentoTotalDocumento(imDes1TotDoc);
				}
				if(rs.getValueAt(i,"IMPORTEDESCUENTOTL")!=null){
						Float imDes1TotLocal=new Float(((BigDecimal)rs.getValueAt(i,"IMPORTEDESCUENTOTL")).floatValue());
						dtoCabSolic.setImporteDescuentoTotalLocal(imDes1TotLocal);
				}

				if(rs.getValueAt(i,"IMPORTEFLETEDOCUMENTO")!=null){
						Float imFleteDoc=new Float(((BigDecimal)rs.getValueAt(i,"IMPORTEFLETEDOCUMENTO")).floatValue());
						dtoCabSolic.setImporteFleteDocumento(imFleteDoc);
				}
				if(rs.getValueAt(i,"IMPORTEFLETELOCAL")!=null){
					Float imFleteLocal=new Float(((BigDecimal)rs.getValueAt(i,"IMPORTEFLETELOCAL")).floatValue());
						dtoCabSolic.setImporteFleteLocal(imFleteLocal);
				}
				if(rs.getValueAt(i,"IMPORTEFLETESIMPUESTOSTL")!=null){
						Float imFleteTotalLocal=new Float(((BigDecimal)rs.getValueAt(i,"IMPORTEFLETESIMPUESTOSTL")).floatValue());
						dtoCabSolic.setImporteFleteSinImpuestosTotalLocal(imFleteTotalLocal);
				}
				if(rs.getValueAt(i,"IMPORTEFLETESINIMPUESTOSTD")!=null){
						Float imFleteTotalDoc=new Float(((BigDecimal)rs.getValueAt(i,"IMPORTEFLETESINIMPUESTOSTD")).floatValue());
						dtoCabSolic.setImporteFleteSinImpuestosTotalDocumento(imFleteTotalDoc);
				}
				if(rs.getValueAt(i,"IMPORTEFLETETD")!=null){
						Float imFleteTotalDoc=new Float(((BigDecimal)rs.getValueAt(i,"IMPORTEFLETETD")).floatValue());
						dtoCabSolic.setImporteFleteTotalDocumento(imFleteTotalDoc);
				}
				if(rs.getValueAt(i,"IMPORTEFLETETL")!=null){
						Float imFleteTotalLocal=new Float(((BigDecimal)rs.getValueAt(i,"IMPORTEFLETETL")).floatValue());
						dtoCabSolic.setImporteFleteTotalLocal(imFleteTotalLocal);
				}
				if(rs.getValueAt(i,"NUMEROSOLICITUD")!=null){
						Long numeroSolic=new Long(((BigDecimal)rs.getValueAt(i,"NUMEROSOLICITUD")).longValue());
						dtoCabSolic.setNumeroSolicitud(numeroSolic);
				}
				if(rs.getValueAt(i,"OTROSRECARGOSDOCUMENTO")!=null){
						Float otrosCargosDoc=new Float(((BigDecimal)rs.getValueAt(i,"OTROSRECARGOSDOCUMENTO")).floatValue());
						dtoCabSolic.setOtrosRecargosDocumento(otrosCargosDoc);
				}
				if(rs.getValueAt(i,"OTROSRECARGOSLOCAL")!=null){
						Float otrosRecargosLocal=new Float(((BigDecimal)rs.getValueAt(i,"OTROSRECARGOSLOCAL")).floatValue());
						dtoCabSolic.setOtrosRecargosLocal(otrosRecargosLocal);
				}
				if(rs.getValueAt(i,"PRECIOCONTABLETL")!=null){
						Float precioContableTotLocal=new Float(((BigDecimal)rs.getValueAt(i,"PRECIOCONTABLETL")).floatValue());
						dtoCabSolic.setPrecioContableTotalLocal(precioContableTotLocal);
				}
				if(rs.getValueAt(i,"RECARGOFLETEDOCUMENTO")!=null){
						Float recargoFleteDoc=new Float(((BigDecimal)rs.getValueAt(i,"RECARGOFLETEDOCUMENTO")).floatValue());
						dtoCabSolic.setRecargoFleteDocumento(recargoFleteDoc);
				}
				if(rs.getValueAt(i,"RECARGOFLETELOCAL")!=null){
						Float recargoFleteLocal=new Float(((BigDecimal)rs.getValueAt(i,"RECARGOFLETELOCAL")).floatValue());
						dtoCabSolic.setRecargoFleteLocal(recargoFleteLocal);
				}
				if(rs.getValueAt(i,"TIPOCAMBIO")!=null){
						BigDecimal tipoCambio=(BigDecimal)rs.getValueAt(i,"TIPOCAMBIO");
						dtoCabSolic.setTipoCambio(tipoCambio);
				}

				if(rs.getValueAt(i,"TOTALFLETEDOCUMENTO")!=null){
						Float totalFleteDoc=new Float(((BigDecimal)rs.getValueAt(i,"TOTALFLETEDOCUMENTO")).floatValue());
						dtoCabSolic.setTotalFleteDocumento(totalFleteDoc);
				}

				if(rs.getValueAt(i,"TOTALFLETELOCAL")!=null){
						Float totalFleteLocal=new Float(((BigDecimal)rs.getValueAt(i,"TOTALFLETELOCAL")).floatValue());
						dtoCabSolic.setTotalFleteLocal(totalFleteLocal);
				}
				if(rs.getValueAt(i,"TOTALAPAGARDOCUMENTO")!=null){
					Float totAPagarDoc=new Float(((BigDecimal)rs.getValueAt(i,"TOTALAPAGARDOCUMENTO")).floatValue());
						dtoCabSolic.setTotalAPagarDocumento(totAPagarDoc);
				}
				if(rs.getValueAt(i,"TOTALAPAGARLOCAL")!=null){
						Float totAPagarLocal=new Float(((BigDecimal)rs.getValueAt(i,"TOTALAPAGARLOCAL")).floatValue());
						dtoCabSolic.setTotalAPagarLocal(totAPagarLocal);
				}
				if(rs.getValueAt(i,"USUARIO")!=null){
						String usuario = rs.getValueAt(i,"USUARIO").toString();
						dtoCabSolic.setUsuario(usuario);
				}
				if(rs.getValueAt(i,"ZONA")!=null){
						Long zona=new Long(((BigDecimal)rs.getValueAt(i,"ZONA")).longValue());
						dtoCabSolic.setZona(zona);
				}
				
					
				listaDtos.add(dtoCabSolic);	
			}	//for
		}//if rs.vacio
		
		UtilidadesLog.info("DAOSolicitudCabecera.obtenerCabecerasSolicitud (ArrayList listaOIDs): Salida");
		return listaDtos;

	}//metodo

	 //BELC300008565 Parametros del metodos variados
    public void actualizarCabeceras(DTOFACConsolidado dtoConsolidado) throws MareException {
        // Actualiza los registros de cabecera de solicitud correspondientes a un consolidado 
        //Se obtienen los OID de los registros de cabecera de las solicitudes origen del consolidado 
        UtilidadesLog.info("DAOSolicitudCabecera.actualizarCabeceras(DTOFACConsolidado dtoConsolidado): Entrada");
		
        DTOFACCabeceraSolicitud dtoCabecera = dtoConsolidado.getDtoCabecera();
        ArrayList listaCabeceraSolicitud = dtoConsolidado.getListaSolicitudes();

        //crear listaOIDs 
        ArrayList listaOIDs = new ArrayList();

        for (int i = 0; i < listaCabeceraSolicitud.size(); i++) {
            //solicitud = listaCabecerasSolicitud.siguiente 
            //listaOIDs.añadir( solicitud.oidCabeceraSolicitud ) 
            listaOIDs.add(((DTOFACCabeceraSolicitud) listaCabeceraSolicitud.get(i)).getOidCabeceraSolicitud());
        }

        //Se actualizan los registros en BD: 
         StringBuffer consulta = new StringBuffer();
         Vector parametros = new Vector();

        /* Cambios por incidencia: BELC300010142
         * 
         * Se modifica la sentencia SQL:
          1.- Se elimina la primera subquery y se sustituye por el valor de una constante.
          2.- Se modifica la ultima subquery dado que el atributo estado del DTOFACCabeceraSolicitud contiene el valor
            que se corresponde con el oid del estado, por lo cual no es necesario buscarlo en la tabla.
          El diseño de la consulta queda de la siguiente manera:
          update PED_SOLIC_CABEC
          set
            SOCA_OID_SOLI_CABE = dtoConsolidado dtoCabecera.oidCabeceraSolicitud,
            GRPR_OID_GRUP_PROC = ConstantesPED.GP5
            PROC_OID_PROC = (Se accede a PED_PROCE con COD_PROC="P500" y se coge OID_PROC)
            ESSO_OID_ESTA_SOLI = dtoConsolidado. dtoCabecera.estado
          where 
            OID_SOLI_CABE in listaOIDs
         */
		
         consulta.append("UPDATE PED_SOLIC_CABEC "); 
         consulta.append(" SET  ");
         //Cambiado por incidencia BELC300008571
         consulta.append("   SOCA_OID_SOLI_CABE = ? , ");  
         parametros.add(dtoCabecera.getOidCabeceraSolicitud());
         consulta.append(" GRPR_OID_GRUP_PROC = ? , ");
         parametros.add(ConstantesPED.GP5);
         consulta.append(" PROC_OID_PROC = ( ");
 		     consulta.append("	 SELECT OID_PROC FROM PED_PROCE WHERE COD_PROC = 'P500' ),  ");
         consulta.append(" ESSO_OID_ESTA_SOLI = ? , ");
		     parametros.add(dtoCabecera.getEstado());
         //Añadido por incidencia 14180 y modificado por incidencia 14555
         SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
         java.sql.Date fecha =  new java.sql.Date(dtoCabecera.getFechaFacturacion().getTime());
         String sFecha = sdf.format(fecha);
         consulta.append(" FEC_FACT = TO_DATE( '"+sFecha+"' ,'YYYY-MM-DD') ");
         //parametros.add(sFecha);
                           
         consulta.append(" WHERE OID_SOLI_CABE IN ( "+convertirArrayToString(listaOIDs) +" ) ");

         for(int i=0;i<listaOIDs.size();i++){
            if(listaOIDs.get(i)!=null){
               //si es distinto de null lo pasamos a vector de la select.
               parametros.add(listaOIDs.get(i));
            }
         }
	 
         // Se ejecuta la consulta 
         BelcorpService bs = UtilidadesEJB.getBelcorpService();
         try {
            bs.dbService.executePreparedUpdate(consulta.toString(),parametros);
         } catch (Exception e) {
             UtilidadesLog.error("actualizarCabeceras: Exception",e);
             this.logSql("actualizarCabeceras. SQL: ",consulta.toString(),
              parametros);
             throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS));
         }
        UtilidadesLog.info("DAOSolicitudCabecera.actualizarCabeceras(DTOFACConsolidado dtoConsolidado): Salida");
    }
    
    public StringBuffer generaActualizarCabeceras(DTOFACConsolidado dtoConsolidado) throws MareException {
		
        DTOFACCabeceraSolicitud dtoCabecera = dtoConsolidado.getDtoCabecera();
        ArrayList listaCabeceraSolicitud = dtoConsolidado.getListaSolicitudes();

        ArrayList listaOIDs = new ArrayList();

        for (int i = 0; i < listaCabeceraSolicitud.size(); i++) {
            listaOIDs.add(((DTOFACCabeceraSolicitud) listaCabeceraSolicitud.get(i)).getOidCabeceraSolicitud());
        }

        StringBuffer consulta = new StringBuffer();
        Vector parametros = new Vector();
        
        consulta.append("UPDATE PED_SOLIC_CABEC SET "); 
        consulta.append(" SOCA_OID_SOLI_CABE = ");  
        consulta.append(dtoCabecera.getOidCabeceraSolicitud());
        consulta.append(" , GRPR_OID_GRUP_PROC = ");
        consulta.append(ConstantesPED.GP5);
        consulta.append(" ,PROC_OID_PROC = ( SELECT OID_PROC FROM PED_PROCE WHERE COD_PROC = 'P500' ) ");
        consulta.append(" ,ESSO_OID_ESTA_SOLI = ");
        consulta.append(dtoCabecera.getEstado());
        
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        java.sql.Date fecha =  new java.sql.Date(dtoCabecera.getFechaFacturacion().getTime());
        String sFecha = sdf.format(fecha);
        consulta.append(" ,FEC_FACT = TO_DATE( '"+sFecha+"' ,'YYYY-MM-DD') ");
        consulta.append(" WHERE OID_SOLI_CABE IN ( ");
        
        for(int i=0;i<listaOIDs.size();i++){
            if (i == (listaOIDs.size()-1)){
                consulta.append(listaOIDs.get(i).toString());
            }else{
                consulta.append(listaOIDs.get(i).toString()).append(" , ");
            }
        }
        consulta.append(" );");
        return consulta;
    }


    public void actualizarPosicion(DTOFACPosicionSolicitud dtoPosicion) throws MareException {
        UtilidadesLog.info("DAOSolicitudCabecera.actualizarPosicion(DTOFACPosicionSolicitud dtoPosicion): Entrada");
        UtilidadesLog.debug("*** DTOPosicion = "+dtoPosicion);	 
        StringBuffer consulta = new StringBuffer();
        Vector parametros = new Vector();

        // BELC300008590 A FALTA DEL MAPEO
    
        // Segun Incidencia 8577
        //- Actualiza campos de importes y precios de la posición:
        // Se añaden mas campos por incidencia BELC300014914
        consulta.append("UPDATE PED_SOLIC_POSIC "); 
        consulta.append(" SET  ");
		
        if(dtoPosicion.getIndicadorImpuestos() != null){
          consulta.append(" TAIM_OID_TASA_IMPU = ? , "); 
          parametros.add(dtoPosicion.getIndicadorImpuestos());
        }
        if(dtoPosicion.getTasaImpuesto() != null){
          consulta.append(" VAL_TASA_IMPU = ? , "); 
          parametros.add(dtoPosicion.getTasaImpuesto());		
        }
        if(dtoPosicion.getPrecioSinImpuestosUL() != null){
          consulta.append(" VAL_PREC_SIN_IMPU_UNIT_LOCA = ? , "); 
          parametros.add(dtoPosicion.getPrecioSinImpuestosUL());
        }
        if(dtoPosicion.getPrecioSinImpuestosUD() != null){
          consulta.append(" VAL_PREC_SIN_IMPU_UNIT_DOCU = ? , "); 
          parametros.add(dtoPosicion.getPrecioSinImpuestosUD());
        }
        if(dtoPosicion.getPrecioFacturaUL() != null){		
          consulta.append(" VAL_PREC_FACT_UNIT_LOCA = ? , "); 
          parametros.add(dtoPosicion.getPrecioFacturaUL());
        }
        if(dtoPosicion.getPrecioFacturaUD() != null){	
          consulta.append(" VAL_PREC_FACT_UNIT_DOCU = ? , "); 
          parametros.add(dtoPosicion.getPrecioFacturaUD());
        }
        if(dtoPosicion.getPrecioNetoUL() != null){	
          consulta.append(" VAL_PREC_NETO_UNIT_LOCA = ? , "); 
          parametros.add(dtoPosicion.getPrecioNetoUL());
        }
        if(dtoPosicion.getPrecioNetoUD() != null){			
          consulta.append(" VAL_PREC_NETO_UNIT_DOCU = ? , "); 
          parametros.add(dtoPosicion.getPrecioNetoUD());
        }
        if(dtoPosicion.getImporteImpuestoUL() != null){					
          consulta.append(" VAL_IMPO_IMPU_UNIT_LOCA = ? , "); 	
          parametros.add(dtoPosicion.getImporteImpuestoUL());
        }
        if(dtoPosicion.getImporteImpuestoUD() != null){				
          consulta.append(" VAL_IMPO_IMPU_UNIT_DOCU = ? , "); 
          parametros.add(dtoPosicion.getImporteImpuestoUD());
        }
        if(dtoPosicion.getPrecioTotalUL() != null){			
          consulta.append(" VAL_PREC_TOTA_UNIT_LOCA = ? , "); 
          parametros.add(dtoPosicion.getPrecioTotalUL());
        }
        if(dtoPosicion.getPrecioTotalUD() != null){			
          consulta.append(" VAL_PREC_TOTA_UNIT_DOCU = ? , "); 
          parametros.add(dtoPosicion.getPrecioTotalUD());
        }
        if(dtoPosicion.getPrecioContableTL() != null){	
          consulta.append(" VAL_PREC_CONT_TOTA_LOCA = ? , "); 
          parametros.add(dtoPosicion.getPrecioContableTL());
        }
        if(dtoPosicion.getPrecioContableTD() != null){	
          consulta.append(" VAL_PREC_CONT_TOTA_DOCU = ? , "); 
          parametros.add(dtoPosicion.getPrecioContableTD());
        }
        if(dtoPosicion.getPrecioCatalogoTL() != null){			
          consulta.append(" VAL_PREC_CATA_TOTA_LOCA = ? , "); 
          parametros.add(dtoPosicion.getPrecioCatalogoTL());
        }
        if(dtoPosicion.getPrecioCatalogoTD() != null){			
          consulta.append(" VAL_PREC_CATA_TOTA_DOCU = ? , "); 
          parametros.add(dtoPosicion.getPrecioCatalogoTD());
        }
        if(dtoPosicion.getPrecioCatalogoTLUnidadesDemandaReal() != null){			
          consulta.append(" VAL_PREC_CATA_TOTA_LOCA_UNID = ? , "); 
          parametros.add(dtoPosicion.getPrecioCatalogoTLUnidadesDemandaReal());
        }
        if(dtoPosicion.getPrecioFacturaTL() != null){			
          consulta.append(" VAL_PREC_FACT_TOTA_LOCA = ? , "); 
          parametros.add(dtoPosicion.getPrecioFacturaTL());
        }
        if(dtoPosicion.getPrecioFacturaTD() != null){			
          consulta.append(" VAL_PREC_FACT_TOTA_DOCU = ? , "); 
          parametros.add(dtoPosicion.getPrecioFacturaTD());
        }
        if(dtoPosicion.getPrecioSinImpuestosTL() != null){				
          consulta.append(" VAL_PREC_SIN_IMPU_TOTA_LOCA = ? , "); 
          parametros.add(dtoPosicion.getPrecioSinImpuestosTL());
        }
        if(dtoPosicion.getPrecioSinImpuestosTD() != null){				
          consulta.append(" VAL_PREC_SIN_IMPU_TOTA_DOCU = ? , "); 
          parametros.add(dtoPosicion.getPrecioSinImpuestosTD());
        }
        if(dtoPosicion.getImporteDescuentoTL() != null){				
          consulta.append(" VAL_IMPO_DESC_TOTA_LOCA = ? , "); 
          parametros.add(dtoPosicion.getImporteDescuentoTL());
        }	
        if(dtoPosicion.getImporteDescuentoTD() != null){			
          consulta.append(" VAL_IMPO_DESC_TOTA_DOCU = ? , "); 
          parametros.add(dtoPosicion.getImporteDescuentoTD());
        }
        if(dtoPosicion.getPrecioNetoTL() != null){	
          consulta.append(" VAL_PREC_NETO_TOTA_LOCA = ? , "); 
          parametros.add(dtoPosicion.getPrecioNetoTL());
        }
        if(dtoPosicion.getPrecioNetoTD() != null){	
          consulta.append(" VAL_PREC_NETO_TOTA_DOCU = ? , "); 
          parametros.add(dtoPosicion.getPrecioNetoTD());
        }
        if(dtoPosicion.getImporteImpuestoTL() != null){		
          consulta.append(" VAL_IMPO_IMPU_TOTA_LOCA = ? , "); 
          parametros.add(dtoPosicion.getImporteImpuestoTL());
        }
        if(dtoPosicion.getImporteImpuestoTD() != null){		
          consulta.append(" VAL_IMPO_IMPU_TOTA_DOCU = ? , "); 
          parametros.add(dtoPosicion.getImporteImpuestoTD());
        }
        //campos añadidos por incidencia BELC300014914
        if(dtoPosicion.getImporteDescuentoSinImpuestosUL() != null){
            consulta.append(" VAL_IMPO_DES_SIN_IMP_UNIT_LOCA  = ? , ");
            parametros.add(dtoPosicion.getImporteDescuentoSinImpuestosUL());
        }	
        if(dtoPosicion.getImporteDescuentoSinImpuestosUD() != null){
            consulta.append(" VAL_IMPO_DES_SIN_IMP_UNIT_DOCU   = ? , ");
            parametros.add(dtoPosicion.getImporteDescuentoSinImpuestosUD());
        }	
        if(dtoPosicion.getPrecioTotalTL() != null){
            consulta.append(" VAL_PREC_TOTA_TOTA_LOCA   = ?  ,");
			parametros.add(dtoPosicion.getPrecioTotalTL());
        }	
        if(dtoPosicion.getPrecioTotalTD() != null){
            consulta.append(" VAL_PREC_TOTA_TOTA_DOCU   = ?  ,");
			parametros.add(dtoPosicion.getPrecioTotalTD());
        }	
        if(dtoPosicion.getUnidadesAtendidas() != null){
            consulta.append(" NUM_UNID_ATEN   = ?  ,");
			parametros.add(dtoPosicion.getUnidadesAtendidas());
        }	
        if(dtoPosicion.getIndicadorNoImprimible() != null){
            consulta.append(" IND_NO_IMPR   = ?  ,");
			parametros.add(dtoPosicion.getIndicadorNoImprimible());
        }	
        if(dtoPosicion.getIndicadorDentroFueraCajaBolsa() != null){
            consulta.append(" IND_DENT_FUER_CAJA_BOLS   = ?  ,");
			parametros.add(dtoPosicion.getIndicadorDentroFueraCajaBolsa());
        }	
        if(dtoPosicion.getProducto() != null){
            consulta.append(" PROD_OID_PROD   = ?  ,");
			parametros.add(dtoPosicion.getProducto());
        }	
        if(dtoPosicion.getNumeroConsolidado() != null){
            consulta.append("  NUM_CONS   = ?  ,");
			parametros.add(dtoPosicion.getNumeroConsolidado());
        }	
        if(dtoPosicion.getImporteDescuentoSinImpuestosTL() != null){
            consulta.append(" VAL_IMPO_DES_SIN_IMP_TOTA = ? ,");
            parametros.add(dtoPosicion.getImporteDescuentoSinImpuestosTL());
        }else{
            consulta.append(" VAL_IMPO_DES_SIN_IMP_TOTA = 0 ,");
        }
        if(dtoPosicion.getImporteDescuentoSinImpuestosTD() != null){
            consulta.append(" VAL_IMPO_DES_SIN_IMP_TOTA_DOCU  = ? ,");
            parametros.add(dtoPosicion.getImporteDescuentoSinImpuestosTD());
        }else{
            consulta.append(" VAL_IMPO_DES_SIN_IMP_TOTA_DOCU  = 0 ,");
        }
        if(dtoPosicion.getUnidadesComprometidas() != null){
            consulta.append(" NUM_UNID_COMPR  = ? ");
            parametros.add(dtoPosicion.getUnidadesComprometidas());
        }else{
            consulta.append(" NUM_UNID_COMPR = 0 ");
        }
        

		//if(dtoPosicion.getOidPosicion() != null){
			consulta.append(" WHERE OID_SOLI_POSI = ?  ");
			parametros.add(dtoPosicion.getOidPosicion());
		//}
        
		 // Se ejecuta la consulta 
 		BelcorpService bs = UtilidadesEJB.getBelcorpService();
		try {
			bs.dbService.executePreparedUpdate(consulta.toString(),parametros);
		} catch (Exception e) {
			UtilidadesLog.error("actualizarPosicion: Exception",e);
			this.logSql("actualizarPosicion. SQL: ",consulta.toString(),
				parametros);
            throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS));
		 }
		UtilidadesLog.info("DAOSolicitudCabecera.actualizarPosicion(DTOFACPosicionSolicitud dtoPosicion): Salida");
    }

    public void actualizarProcesoEstado (DTOFACCabeceraSolicitud dtoCabecera) throws MareException {
		// Actualiza los atributos 'proceso' y 'estado' 
		// de la cabecera de solicitud, después de ejecutar un proceso de facturación. 
		UtilidadesLog.info("DAOSolicitudCabecera.actualizarProcesoEstado (DTOFACCabeceraSolicitud dtoCabecera): Entrada");
	
        StringBuffer consulta = new StringBuffer();
        Vector parametros = new Vector();

        consulta.append("UPDATE PED_SOLIC_CABEC "); 
        consulta.append(" SET  ");
        consulta.append(" ESPE_OID_ESTA_PEDI = ? , "); 
		parametros.add(dtoCabecera.getEstado());		 
        consulta.append(" PROC_OID_PROC = ?  "); 
		parametros.add(dtoCabecera.getProceso());		 
        consulta.append(" WHERE OID_SOLI_CABE = ? ");
        parametros.add(dtoCabecera.getOidCabeceraSolicitud());
		
		 // Se ejecuta la consulta 
 		BelcorpService bs = UtilidadesEJB.getBelcorpService();
		try {
			bs.dbService.executePreparedUpdate(consulta.toString(),parametros);
		} catch (Exception e) {
			UtilidadesLog.error("actualizarProcesoEstado : Exception",e);
			this.logSql("actualizarProcesoEstado . SQL: ",consulta.toString(),
				parametros);
            throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS));
		 }
		UtilidadesLog.info("DAOSolicitudCabecera.actualizarProcesoEstado (DTOFACCabeceraSolicitud dtoCabecera): Salida");
    }
    
    public ArrayList generaInsertarConsolidado (DTOFACCabeceraSolicitud dtoConsolidado) throws MareException {
        // Inserta un registro de consolidado en base de datos. Estos registros se almacenan 
        // en la tabla PED_SOLIC_CABEC. 
        UtilidadesLog.info("DAOSolicitudCabecera.generaInsertarConsolidado (DTOFACCabeceraSolicitud dtoConsolidado): Entrada");
        ArrayList respuesta = new ArrayList();
		
        Long oid = null;
        Long modulo = null;
        Long operacion = null;
            
        try {
          // Asignar el nuevo oid
            oid = SecuenciadorOID.obtenerSiguienteValor("PED_SOCA_SEQ");
        } catch (MareException me) {
            UtilidadesLog.error("Error al obtener secuencia",me);
            throw new MareException();
        }
        respuesta.add(oid);

        modulo = new Long(ConstantesSEG.MODULO_PED);
        
        operacion = ConstantesBEL.FAC075;

        StringBuffer insert = new StringBuffer();
        StringBuffer parametros = new StringBuffer();
        
        insert.append("INSERT INTO PED_SOLIC_CABEC ("); 
        insert.append(" OID_SOLI_CABE, ");
        parametros.append(oid);
        parametros.append(" , ");
        insert.append(" PAIS_OID_PAIS, ");
        parametros.append(dtoConsolidado.getOidPais());
        parametros.append(" , ");
        insert.append(" SBAC_OID_SBAC, ");
        parametros.append(dtoConsolidado.getSubacceso());
        parametros.append(" , ");
        insert.append(" VAL_NUME_SOLI, ");
        parametros.append(dtoConsolidado.getNumeroSolicitud());
        parametros.append(" , ");
    
        insert.append(" ESSO_OID_ESTA_SOLI, ");
        parametros.append(dtoConsolidado.getEstado());
        parametros.append(" , ");
        insert.append(" SOCI_OID_SOCI ");
        parametros.append(dtoConsolidado.getSociedad());
        parametros.append(" , ");
        insert.append(" ,CLSO_OID_CLAS_SOLI ");
        parametros.append(this.generaSelectClasificacion(dtoConsolidado.getTipoSolicitud()));
        parametros.append(" , ");
        if(modulo != null) {
            insert.append(" ,MODU_OID_MODU ");
            parametros.append(modulo);
            parametros.append(" , ");
        }
      
        if(operacion != null) {
            insert.append(" ,OPER_OID_OPER ");
            parametros.append(operacion);
            parametros.append(" , ");
        }
        insert.append(" ,TSPA_OID_TIPO_SOLI_PAIS ");
        parametros.append(dtoConsolidado.getTipoSolicitud());
        parametros.append(" , ");
        insert.append(" ,IND_OC ");
        parametros.append(this.generaSelectIndicadorOrdenDeCompra(dtoConsolidado.getTipoSolicitud()));
        parametros.append(" , ");
        insert.append(" ,IND_PEDI_PRUE ");
        parametros.append(this.generaSelectIndicadorPedidoPrueba(dtoConsolidado.getTipoSolicitud()));
        parametros.append(" , ");
        if(dtoConsolidado.getOidDocumentoReferencia() != null){
            insert.append(" ,SOCA_OID_DOCU_REFE ");
            parametros.append(dtoConsolidado.getOidDocumentoReferencia());
            parametros.append(" , ");
        }
        if(dtoConsolidado.getNumeroDocumentoOrigen() != null) {
            insert.append(" ,NUM_DOCU_ORIG ");
            parametros.append(dtoConsolidado.getNumeroDocumentoOrigen());
            parametros.append(" , ");
        }
        insert.append(" ,PERD_OID_PERI ");
        parametros.append(dtoConsolidado.getPeriodo());
        parametros.append(" , ");
        insert.append(" ,FEC_CRON ");
        parametros.append(convierteFecha(dtoConsolidado.getFecha()));
        parametros.append(" , ");
            
        if (dtoConsolidado.getFechaFacturacion()!=null){
            insert.append(" ,FEC_FACT ");
            parametros.append(convierteFecha(dtoConsolidado.getFechaFacturacion()));
            parametros.append(" , ");
        }
        
        if(dtoConsolidado.getFechaPrevistaFacturacion() != null) {
            insert.append(" ,FEC_PROG_FACT ");
            parametros.append(convierteFecha(dtoConsolidado.getFechaPrevistaFacturacion()));
            parametros.append(" , ");
        }
        if(dtoConsolidado.getNumeroLoteFacturacion() != null) {
            insert.append(" ,NUM_LOTE_FACT ");
            parametros.append(dtoConsolidado.getNumeroLoteFacturacion());
            parametros.append(" , ");
        }
        insert.append(" ,CLIE_OID_CLIE ");
        parametros.append(dtoConsolidado.getOidCliente());
        parametros.append(" , ");
        insert.append(" ,TICL_OID_TIPO_CLIE ");
        parametros.append(dtoConsolidado.getTipoCliente());
        parametros.append(" , ");
        insert.append(" ,SBTI_OID_SUBT_CLIE ");
        parametros.append(dtoConsolidado.getSubtipoCliente());
        parametros.append(" , ");
        if((dtoConsolidado.getDestinatario() != null)&&(dtoConsolidado.getDestinatario().longValue() != 0)) {
            insert.append(" ,CLIE_OID_CLIE_DEST ");
            parametros.append(dtoConsolidado.getDestinatario());
            parametros.append(" , ");
        }
        if(dtoConsolidado.getOidDireccionCliente() != null) {
            insert.append(" ,CLDI_OID_CLIE_DIRE ");
            parametros.append(dtoConsolidado.getOidDireccionCliente());
            parametros.append(" , ");
        }
        insert.append(" ,CLIE_OID_CLIE_PAGA ");
        parametros.append(dtoConsolidado.getOidPagadorFactura());
        parametros.append(" , ");
        insert.append(" ,CLIE_OID_CLIE_RECE_FACT ");
        parametros.append(dtoConsolidado.getReceptorFactura());
        parametros.append(" , ");
        insert.append(" ,TDOC_OID_TIPO_DOCU ");
        parametros.append(dtoConsolidado.getTipoDocumento());
        parametros.append(" , ");
        if(dtoConsolidado.getTipoDocumentoLegal() != null) {
            insert.append(" ,TIDO_OID_TIPO_DOCU ");
            parametros.append(dtoConsolidado.getTipoDocumentoLegal());
            parametros.append(" , ");
        }
        insert.append(" ,NUM_CLIEN "); 
        parametros.append(new Long(0));
        parametros.append(" , ");
        if(dtoConsolidado.getTipoDespacho() != null) {
            insert.append(" ,TIDS_OID_TIPO_DESP ");
            parametros.append(dtoConsolidado.getTipoDespacho());
            parametros.append(" , ");
        }
        if(dtoConsolidado.getAccesoFisico() != null) {
            insert.append(" ,ACFI_OID_ACCE_FISI ");
            parametros.append(dtoConsolidado.getAccesoFisico());
            parametros.append(" , ");
        }
        insert.append(" ,ZZON_OID_ZONA ");
        parametros.append(dtoConsolidado.getZona());
        parametros.append(" , ");
        if(dtoConsolidado.getTerritorioCliente() != null) {
          //incidencia: BELC300010096
            insert.append(" ,ZTAD_OID_TERR_ADMI ");
            parametros.append(dtoConsolidado.getTerritorioCliente());
            parametros.append(" , ");
        }
        insert.append(" ,TERR_OID_TERR ");  //incidencia: BELC300010096
        parametros.append(dtoConsolidado.getTerritorio());
        parametros.append(" , ");
        if((dtoConsolidado.getUbigeo() != null) && (dtoConsolidado.getUbigeo().longValue()!= 0)) {
            insert.append(" ,VEPO_OID_VALO_ESTR_GEOP ");
            parametros.append(dtoConsolidado.getUbigeo());
            parametros.append(" , ");
        }
        
        if (dtoConsolidado.getPuntoEmision()!=null){
            insert.append(" ,VAL_PUNT_EMIS ");
            parametros.append("'"+dtoConsolidado.getPuntoEmision()+"'");
            parametros.append(" , ");
        }
		
        if((dtoConsolidado.getFormaPago() != null)&&(dtoConsolidado.getFormaPago().longValue() != 0)) {
            insert.append(" ,FOPA_OID_FORM_PAGO ");
            parametros.append(dtoConsolidado.getFormaPago());
            parametros.append(" , ");
        }
        insert.append(" ,ALMC_OID_ALMA ");
        parametros.append(dtoConsolidado.getAlmacen());
        parametros.append(" , ");
        if(dtoConsolidado.getOidTasaImpuestoUbigeo() != null) {
            insert.append(" ,TAIM_OID_TASA_IMPU ");
            parametros.append(dtoConsolidado.getOidTasaImpuestoUbigeo());
            parametros.append(" , ");
        } else if (dtoConsolidado.getIndicadorImpuestosFlete() != null) {
            insert.append(" ,TAIM_OID_TASA_IMPU ");
            parametros.append(dtoConsolidado.getIndicadorImpuestosFlete());
            parametros.append(" , ");
        }
        if(dtoConsolidado.getTasaImpuesto() != null) {
            insert.append(" ,VAL_TASA_IMPU ");
            parametros.append(dtoConsolidado.getTasaImpuesto());
            parametros.append(" , ");
        }
        if(dtoConsolidado.getObservaciones() != null) { 
            insert.append(" ,VAL_GLOS_OBSE ");
            parametros.append("'"+dtoConsolidado.getObservaciones()+"'");
            parametros.append(" , ");
        }
        if(dtoConsolidado.getGrupoProcesos() != null) {
            insert.append(" ,GRPR_OID_GRUP_PROC ");
            parametros.append(dtoConsolidado.getGrupoProcesos());
            parametros.append(" , ");
        }
        insert.append(" ,PROC_OID_PROC ");
        parametros.append(dtoConsolidado.getProceso());
        parametros.append(" , ");
        if(dtoConsolidado.getEstadoCredito() != null) {
            insert.append(" ,ESPE_OID_ESTA_PEDI ");
            parametros.append(dtoConsolidado.getEstadoCredito());
            parametros.append(" , ");
        }
        insert.append(" ,IND_IMPR ");
        parametros.append("0");
        parametros.append(" , ");
        if(dtoConsolidado.getIndicadorEstadisticable() != null) {
            insert.append(" ,IND_ESTA ");
            parametros.append(dtoConsolidado.getIndicadorEstadisticable().booleanValue()==true?"1":"0");
            parametros.append(" , ");
        }
        if(dtoConsolidado.getIndicadorGeneraCuentaCorriente() != null) {
            insert.append(" ,IND_GENE_CC ");
            parametros.append(dtoConsolidado.getIndicadorGeneraCuentaCorriente().booleanValue()==true?"1":"0");
            parametros.append(" , ");
        }
        insert.append(" , IND_APLI_MANU ");
        parametros.append("0");
        parametros.append(" , ");
        if(dtoConsolidado.getIndicadorRevision() != null) {
            insert.append(" , INRE_OID_INDI_REVI ");   //pperez Incidencia BELC300023071
            parametros.append(dtoConsolidado.getIndicadorRevision());
            parametros.append(" , ");
        }
        // Agregado eiraola - atributo de V4 (inicio)
        if(dtoConsolidado.getOrigenChequeo() != null) {
            insert.append(" , VAL_ORIG_CHEQ ");
            parametros.append("'"+dtoConsolidado.getOrigenChequeo()+"'");
            parametros.append(" , ");
        }
        // Agregado eiraola - atributo de V4 (fin)
        if(dtoConsolidado.getUnidadesDemandaRealTotal() != null) {
            insert.append(" ,VAL_UNID_DEMA_REAL_TOTA ");
            parametros.append(dtoConsolidado.getUnidadesDemandaRealTotal());
            parametros.append(" , ");
        }
        if(dtoConsolidado.getUnidadesPorAtenderTotal() != null) {
            insert.append(" ,NUM_UNID_POR_ATEN_TOTA  ");
            parametros.append(dtoConsolidado.getUnidadesPorAtenderTotal());
            parametros.append(" , ");
        }
        if(dtoConsolidado.getUnidadesAtendidasTotal() != null) {
            insert.append(",NUM_UNID_ATEN_TOTA ");
            parametros.append(dtoConsolidado.getUnidadesAtendidasTotal());
            parametros.append(" , ");
        }
        if((dtoConsolidado.getMoneda() != null)&&(dtoConsolidado.getMoneda().longValue() != 0)) {
            insert.append(" ,MONE_OID_MONE ");
            parametros.append(dtoConsolidado.getMoneda());
            parametros.append(" , ");
        }
        if((dtoConsolidado.getTipoCambio() != null)&&(dtoConsolidado.getTipoCambio().longValue() != 0)) {
            insert.append(" ,VAL_TIPO_CAMB ");
            parametros.append(dtoConsolidado.getTipoCambio());
            parametros.append(" , ");
        }
        if(dtoConsolidado.getIndicadorExentoFlete() != null) {
            insert.append(" ,IND_EXEN_FLET ");
            parametros.append(dtoConsolidado.getIndicadorExentoFlete().booleanValue()==true?"1":"0");
            parametros.append(" , ");
        }
        if(dtoConsolidado.getBaseFleteLocal() != null) {
            insert.append(" ,VAL_BASE_FLET_LOCA ");
            parametros.append(dtoConsolidado.getBaseFleteLocal());
            parametros.append(" , ");
        }
        if(dtoConsolidado.getImporteFleteLocal() != null) {
            insert.append(" ,VAL_IMPO_FLET_LOCA ");
            parametros.append(dtoConsolidado.getImporteFleteLocal());
            parametros.append(" , ");
        }
        if(dtoConsolidado.getRecargoFleteLocal() != null) {
            insert.append(" ,VAL_RECA_FLET_LOCA ");
            parametros.append(dtoConsolidado.getRecargoFleteLocal());
            parametros.append(" , ");
        }
        if(dtoConsolidado.getOtrosRecargosLocal() != null) {
            insert.append(" ,VAL_OTRO_RECA_LOCA ");
            parametros.append(dtoConsolidado.getOtrosRecargosLocal());
            parametros.append(" , ");
        }
        if(dtoConsolidado.getTotalFleteLocal() != null) {
            insert.append(" ,VAL_TOTA_FLET_LOCA ");
            parametros.append(dtoConsolidado.getTotalFleteLocal());
            parametros.append(" , ");
        }
        if(dtoConsolidado.getImporteFleteTotalLocal() != null) {
            insert.append(" ,VAL_IMPO_FLET_TOTA_LOCA ");
            parametros.append(dtoConsolidado.getImporteFleteTotalLocal());
            parametros.append(" , ");
        }
        if(dtoConsolidado.getImporteFleteSinImpuestosTotalLocal() != null) {
            insert.append(" ,VAL_IMPO_FLET_SIN_IMPU_TOTA ");
            parametros.append(dtoConsolidado.getImporteFleteSinImpuestosTotalLocal());
            parametros.append(" , ");
        }
        if(dtoConsolidado.getBaseFleteDocumento() != null) {
            insert.append(" ,VAL_BASE_FLET_DOCU ");
            parametros.append(dtoConsolidado.getBaseFleteDocumento());
            parametros.append(" , ");
        }
        if(dtoConsolidado.getImporteFleteDocumento() != null) {
            insert.append(" ,VAL_IMPO_FLET_DOCU ");
            parametros.append(dtoConsolidado.getImporteFleteDocumento());
            parametros.append(" , ");
        }
        if(dtoConsolidado.getRecargoFleteDocumento() != null) {
            insert.append(" ,VAL_RECA_FLET_DOCU ");
            parametros.append(dtoConsolidado.getRecargoFleteDocumento());
            parametros.append(" , ");
        }
        if(dtoConsolidado.getOtrosRecargosDocumento() != null) {
            insert.append(" ,VAL_OTRO_RECA_DOCU ");
            parametros.append(dtoConsolidado.getOtrosRecargosDocumento());
            parametros.append(" , ");
        }
        if(dtoConsolidado.getTotalFleteDocumento() != null) {
            insert.append(" ,VAL_TOTA_FLET_DOCU ");
            parametros.append(dtoConsolidado.getTotalFleteDocumento());
            parametros.append(" , ");
        }
        if(dtoConsolidado.getImporteFleteTotalDocumento() != null) {
            insert.append(" ,VAL_IMPO_FLET_TOTA_DOCU ");
            parametros.append(dtoConsolidado.getImporteFleteTotalDocumento());
            parametros.append(" , ");
        }
        if(dtoConsolidado.getImporteFleteSinImpuestosTotalDocumento() != null) {
            insert.append(" ,VAL_IMPO_FLET_SIN_IMPU_DOCU ");
            parametros.append(dtoConsolidado.getImporteFleteSinImpuestosTotalDocumento());
            parametros.append(" , ");
        }
        if(dtoConsolidado.getImporteDescuento3TotalLocal() != null) {
            insert.append(" ,VAL_IMPO_DESC_3_TOTA_LOCA ");
            parametros.append(dtoConsolidado.getImporteDescuento3TotalLocal());
            parametros.append(" , ");
        }
        if(dtoConsolidado.getImporteDescuento3TotalDocumento() != null) {
            insert.append(" ,VAL_IMPO_DESC_3_TOTA_DOCU ");
            parametros.append(dtoConsolidado.getImporteDescuento3TotalDocumento());
            parametros.append(" , ");
        }
        if(dtoConsolidado.getPrecioContableSinImpuestosTotalLocal() != null) {
            insert.append(" ,VAL_PREC_CONT_SIN_IMPU_TOTA ");
            parametros.append(dtoConsolidado.getPrecioContableSinImpuestosTotalLocal());		
            parametros.append(" , ");
        }
        if(dtoConsolidado.getPrecioContableSinImpuestosTotalDocumento() != null) {
            insert.append(" ,VAL_PREC_CONT_SIN_IMPU_TOTA_1 ");
            parametros.append(dtoConsolidado.getPrecioContableSinImpuestosTotalDocumento());
            parametros.append(" , ");
        }
        if(dtoConsolidado.getImporteDescuento3SinImpuestosTotalLocal() != null) {
            insert.append(" ,VAL_IMPO_DTO_3_SIN_IMP_TOT_LOC ");
            parametros.append(dtoConsolidado.getImporteDescuento3SinImpuestosTotalLocal());
            parametros.append(" , ");
        }
        if(dtoConsolidado.getImporteDescuento3SinImpuestosTotalDocumento() != null) {
            insert.append(" ,VAL_IMPO_DESC_3_SIN_IMPU_TOTA ");
            parametros.append(dtoConsolidado.getImporteDescuento3SinImpuestosTotalDocumento());
            parametros.append(" , ");
        }
        if(dtoConsolidado.getImporteDescuentoTotalLocal() != null) {
            insert.append(" ,VAL_IMPO_DESC_TOTA_LOCA ");
            parametros.append(dtoConsolidado.getImporteDescuentoTotalLocal());
            parametros.append(" , ");
        }
        if(dtoConsolidado.getImporteDescuentoTotalDocumento() != null) {
            insert.append(" ,VAL_IMPO_DESC_TOTA_DOCU ");
            parametros.append(dtoConsolidado.getImporteDescuentoTotalDocumento());
            parametros.append(" , ");
        }
        if(dtoConsolidado.getPrecioNetoTotalLocal() != null) {
            insert.append(" ,VAL_PREC_NETO_TOTA_LOCA ");
            parametros.append(dtoConsolidado.getPrecioNetoTotalLocal());
            parametros.append(" , ");
        }
        if(dtoConsolidado.getPrecioNetoTotalDocumento() != null) {
            insert.append(" ,VAL_PREC_NETO_TOTA_DOCU ");
            parametros.append(dtoConsolidado.getPrecioNetoTotalDocumento());
            parametros.append(" , ");
        }
        if(dtoConsolidado.getImporteImpuestosTotalLocal() != null) {
            insert.append(" ,VAL_IMPO_IMPU_TOTA_LOCA ");
            parametros.append(dtoConsolidado.getImporteImpuestosTotalLocal());
            parametros.append(" , ");
        }
        if(dtoConsolidado.getImporteImpuestosTotalDocumento() != null) {
            insert.append(" ,VAL_IMPO_IMPU_TOTA_DOCU ");
            parametros.append(dtoConsolidado.getImporteImpuestosTotalDocumento());
            parametros.append(" , ");
        }
        if(dtoConsolidado.getTotalAPagarLocal() != null) {
            insert.append(" ,VAL_TOTA_PAGA_LOCA ");
            parametros.append(dtoConsolidado.getTotalAPagarLocal());
            parametros.append(" , ");
        }
        if(dtoConsolidado.getTotalAPagarDocumento() != null) {
            insert.append(" ,VAL_TOTA_PAGA_DOCU ");
            parametros.append(dtoConsolidado.getTotalAPagarDocumento());
            parametros.append(" , ");
        }
        if(dtoConsolidado.getImporteRedondeoLocal() != null) {
            insert.append(" ,VAL_IMPO_REDO_LOCA ");
            parametros.append(dtoConsolidado.getImporteRedondeoLocal());
            parametros.append(" , ");
        }
        if(dtoConsolidado.getImporteRedondeoDocumento() != null) {
            insert.append(" ,VAL_IMPO_REDO_DOCU ");
            parametros.append(dtoConsolidado.getImporteRedondeoDocumento());
            parametros.append(" , ");
        }
        if(dtoConsolidado.getUsuario() != null) {
            insert.append(" ,VAL_USUA ");
            parametros.append("'"+dtoConsolidado.getUsuario()+"'");
            parametros.append(" , ");
        }
        //Añadidos por incidencia 10134
        if(dtoConsolidado.getPrecioCatalogoTotalDocumento() != null) {
            insert.append(" ,VAL_PREC_CATA_TOTA_DOCU ");
            parametros.append(dtoConsolidado.getPrecioCatalogoTotalDocumento());
            parametros.append(" , ");
        }
        if(dtoConsolidado.getPrecioCatalogoTotalLocal() != null) {
            insert.append(" ,VAL_PREC_CATA_TOTA_LOCA ");
            parametros.append(dtoConsolidado.getPrecioCatalogoTotalLocal());
            parametros.append(" , ");
        }
        if(dtoConsolidado.getPrecioCatalogoSinImpuestoTotalDocumento() != null) {
            insert.append(" ,VAL_PREC_CATA_SIN_IMPU_TOTA_DO ");
            parametros.append(dtoConsolidado.getPrecioCatalogoSinImpuestoTotalDocumento());
            parametros.append(" , ");
        }
        if(dtoConsolidado.getPrecioContableSinImpuestosTotalLocal() != null) {
            insert.append(" ,VAL_PREC_CATA_SIN_IMPU_TOTA ");
            parametros.append(dtoConsolidado.getPrecioCatalogoSinImpuestoTotalLocal());
            parametros.append(" , ");
        }
        if(dtoConsolidado.getImporteDescuento1SinImpuestoTotalDocumento() != null) {
            insert.append(" ,VAL_IMPO_DESC_1_SIN_IMPU_TOTA ");
            parametros.append(dtoConsolidado.getImporteDescuento1SinImpuestoTotalDocumento());
            parametros.append(" , ");
        }
        if(dtoConsolidado.getImporteDescuento1SinImpuestoTotalLocal() != null) {
            insert.append(" ,VAL_IMPO_DTO_1_SIN_IMP_TOT_LOC ");
            parametros.append(dtoConsolidado.getImporteDescuento1SinImpuestoTotalLocal());
            parametros.append(" , ");
        }
        if(dtoConsolidado.getPrecioFacturaTotalDocumento() != null) {
            insert.append(" ,VAL_PREC_FACT_TOTA_DOCU ");
            parametros.append(dtoConsolidado.getPrecioFacturaTotalDocumento());
            parametros.append(" , ");
        }
        if(dtoConsolidado.getPrecioFacturaTotalLocal() != null) {
            insert.append(" ,VAL_PREC_FACT_TOTA_LOCA ");
            parametros.append(dtoConsolidado.getPrecioFacturaTotalLocal());
            parametros.append(" , ");
        }
        if(dtoConsolidado.getImporteDescuento1TotalDocumento() != null){
            insert.append(" ,VAL_IMPO_DESC_1_TOTA_DOCU ");
            parametros.append(dtoConsolidado.getImporteDescuento1TotalDocumento());
            parametros.append(" , ");
        }
        if(dtoConsolidado.getImporteDescuento1TotalLocal() != null){
            insert.append(" ,VAL_IMPO_DESC_1_TOTA_LOCA ");
            parametros.append(dtoConsolidado.getImporteDescuento1TotalLocal());
            parametros.append(" , ");
        }
        if(dtoConsolidado.getImporteRedondeoConsolidadoDocumento() != null){
            insert.append(" , VAL_IMPO_REDO_CONS_DOCU ");
            parametros.append(dtoConsolidado.getImporteRedondeoConsolidadoDocumento());
            parametros.append(" , ");
        }
        if(dtoConsolidado.getImporteRedondeoConsolidadoLocal() != null){
            insert.append(" , VAL_IMPO_REDO_CONS_LOCA ");
            parametros.append(dtoConsolidado.getImporteRedondeoConsolidadoLocal());
            parametros.append(" , ");
        }   
        if(dtoConsolidado.getPrecioContableTotalLocal() != null){
            insert.append(" , VAL_PREC_CONT_TOTA_LOCA ");
            parametros.append(dtoConsolidado.getPrecioContableTotalLocal());   
            parametros.append(" , ");
        }
        if(dtoConsolidado.getPrecioContableTotalDocumento() != null){
            insert.append(" , VAL_PREC_CONT_TOTA_DOCU ");
            parametros.append(dtoConsolidado.getPrecioContableTotalDocumento());
            parametros.append(" , ");
        }
        if(dtoConsolidado.getPrecioCatalogoTotalLocalUnidadesPorAtender() != null){
            insert.append(" ,VAL_PREC_CATA_TOTA_LOC_UNI_DEM ");
            parametros.append(dtoConsolidado.getPrecioCatalogoTotalLocalUnidadesPorAtender());
            parametros.append(" , ");
        }

        //añadido por incidencia 14180
        insert.append(" ,IND_TS_NO_CONSO");
        parametros.append("0");
        parametros.append(" );");
        
        insert.append(") VALUES ( ");
        insert.append(parametros);
        
        respuesta.add(insert);
        
        return respuesta;
    }
    
    private String convierteFecha (java.util.Date date){
        StringBuffer respuesta = new StringBuffer();;
        if (date!=null){
            respuesta.append("to_date('");
            SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");
            respuesta.append(df.format(date));
            respuesta.append("','dd/MM/yyyy')");
        }
        return respuesta.toString();
    }
    
    private StringBuffer generaSelectIndicadorOrdenDeCompra (Long tipoSoliPais){
        StringBuffer sb = new StringBuffer();
        sb.append("(SELECT ind_orde_comp indicadorordercompra ");
        sb.append(" FROM ped_tipo_solic ts, ped_tipo_solic_pais tsp, ped_clase_solic cs ");
        sb.append(" WHERE tsp.oid_tipo_soli_pais = "+tipoSoliPais);
        sb.append(" AND ts.oid_tipo_soli = tsp.tsol_oid_tipo_soli ");
        sb.append(" AND cs.oid_clas_soli = ts.clso_oid_clas_soli)");
        return sb;
    }
    
    private StringBuffer generaSelectClasificacion (Long tipoSoliPais){
        StringBuffer sb = new StringBuffer();
        sb.append("(SELECT clso_oid_clas_soli clasificacion ");
        sb.append(" FROM ped_tipo_solic ts, ped_tipo_solic_pais tsp, ped_clase_solic cs ");
        sb.append(" WHERE tsp.oid_tipo_soli_pais = "+tipoSoliPais);
        sb.append(" AND ts.oid_tipo_soli = tsp.tsol_oid_tipo_soli ");
        sb.append(" AND cs.oid_clas_soli = ts.clso_oid_clas_soli)");
        return sb;
    }
    
    private StringBuffer generaSelectIndicadorPedidoPrueba (Long tipoSoliPais){
        StringBuffer sb = new StringBuffer();
        sb.append("(SELECT ind_pedi_prue indicadorpedidoprueba ");
        sb.append(" FROM ped_tipo_solic_pais tsp ");
        sb.append(" WHERE tsp.oid_tipo_soli_pais = "+tipoSoliPais+")");
        return sb;
    }
    

    public Long insertarConsolidado (DTOFACCabeceraSolicitud dtoConsolidado) throws MareException {
        // Inserta un registro de consolidado en base de datos. Estos registros se almacenan 
        // en la tabla PED_SOLIC_CABEC. 
        UtilidadesLog.info("DAOSolicitudCabecera.insertarConsolidado (DTOFACCabeceraSolicitud dtoConsolidado): Entrada");
        UtilidadesLog.debug("*** DTOConsolidado = "+dtoConsolidado);
        StringBuffer consulta = new StringBuffer();
        Vector parametros = new Vector();
		
        Long oid = null;
        Long clasificacion = null;
        Long modulo = null;
        Long operacion = null;
    
        Boolean indicador = null;
        Boolean indicadorP = null;
            
        try {
          // Asignar el nuevo oid
            oid = SecuenciadorOID.obtenerSiguienteValor("PED_SOCA_SEQ");
        } catch (MareException me) {
            UtilidadesLog.error("Error al obtener secuencia",me);
            throw new MareException();
        }

        // Obtener valores de otras tablas
        //se accede a la tabla PED_TIPO_SOLIC usando dtoConsolidado.tipoSolicitud, y se obtiene CLSO_OID_CLAS_SOLI 
        // modificado por incidencia 13025
        //CLSO_OID_CLAS_SOLI = (se accede a la tabla PED_TIPO_SOLIC a traves de PED_TIPO_SOLIC_PAIS y se
        //obtiene CLSO_OID_CLAS_SOLI, usando dtoConsolidado.tipoSolicitud para filtrar en la tabla
        //PED_TIPO_SOLIC_PAIS)
        consulta.append(" SELECT CLSO_OID_CLAS_SOLI FROM PED_TIPO_SOLIC TS , PED_TIPO_SOLIC_PAIS TSP ");
        consulta.append(" WHERE TSP.OID_TIPO_SOLI_PAIS = ? ");
        parametros.add(dtoConsolidado.getTipoSolicitud());
        consulta.append("  AND TS.OID_TIPO_SOLI = TSP.TSOL_OID_TIPO_SOLI ");
        BelcorpService bs = UtilidadesEJB.getBelcorpService();
        RecordSet rs = null;
        try {
            rs = bs.dbService.executePreparedQuery(consulta.toString(),parametros);
        } catch (Exception e) {
            UtilidadesLog.error("insertarConsolidado : Exception",e);
            this.logSql("insertarConsolidado . SQL: ",consulta.toString(),
                parametros);
            throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS));
        }

        if(!rs.esVacio()) {  
          clasificacion = new Long(((BigDecimal)rs.getValueAt(0,0)).longValue());
        }
        
        // ***** Modificado por incidencia BELC300013490 *****
        /*consulta = new StringBuffer();
            parametros = new Vector();
        //se accede a la tabla SEG_MODUL con COD_MODU = CosntantesFAC.COD_MODULO_PEDIDOS y se obtiene OID_MODU
        consulta.append(" SELECT OID_MODU FROM SEG_MODUL WHERE COD_MODU = ? ");
        parametros.add(ConstantesFAC.COD_MODULO_PEDIDOS);
    
        rs = null;
        try {
          rs = bs.dbService.executePreparedQuery(consulta.toString(),parametros);
        } catch (Exception e) {
          UtilidadesLog.error("insertarConsolidado : Exception",e);
          this.logSql("insertarConsolidado . SQL: ",consulta.toString(),
            parametros);
                throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS));
         }
    
        if(!rs.esVacio()) {
          modulo = new Long(((BigDecimal)rs.getValueAt(0,0)).longValue());
        }*/
        // **** Se obtiene el modulo directamente de ConstantesSEG
        modulo = new Long(ConstantesSEG.MODULO_PED);
        UtilidadesLog.debug("*** Modulo = "+modulo);
        
        // ***** Modificado por incidencia BELC300013573 *****
        /*consulta = new StringBuffer();
            parametros = new Vector();
        //se accede a la tabla BEL_OPERA con COD_MODU = ConstantesFAC.COD_OP_FAC075 y se obtiene OID_OPER
        consulta.append(" SELECT OID_OPER FROM BEL_OPERA O WHERE O.COD_OPER = ? ");
        parametros.add(ConstantesFAC.COD_OP_FAC075);

		
        rs = null;
        try {
          rs = bs.dbService.executePreparedQuery(consulta.toString(),parametros);
        } catch (Exception e) {
          UtilidadesLog.error("insertarConsolidado : Exception",e);
          this.logSql("insertarConsolidado . SQL: ",consulta.toString(),
            parametros);
                throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS));
         }
    
        if(!rs.esVacio()) {
          operacion = new Long(((BigDecimal)rs.getValueAt(0,0)).longValue());
                UtilidadesLog.error("*** Operacion = "+operacion);
        }*/
        // **** Se obtiene el oid de la operacion directamente de ConstantesBEL
        operacion = ConstantesBEL.FAC075;
        UtilidadesLog.debug("*** Operacion = "+operacion);
        
        
        consulta = new StringBuffer();
        parametros = new Vector();
        //se accede a la tabla PED_CLASE_SOLIC usando CLSO_OID_CLAS_SOLI obtenido antes
        consulta.append(" SELECT IND_ORDE_COMP FROM PED_CLASE_SOLIC CS WHERE ");
        consulta.append(" OID_CLAS_SOLI = ? ");
        parametros.add(clasificacion);
        
        
        rs = null;
        try {
          rs = bs.dbService.executePreparedQuery(consulta.toString(),parametros);
        } catch (Exception e) {
          UtilidadesLog.error("insertarConsolidado : Exception",e);
          this.logSql("insertarConsolidado . SQL: ",consulta.toString(),
            parametros);
          throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS));
        }

        if(!rs.esVacio()) {
          indicador = new Boolean(((BigDecimal)rs.getValueAt(0,0)).intValue() == 1 ? true : false);
        }
        consulta = new StringBuffer();
        parametros = new Vector();
        // se accede a la tabla PED_TIPO_SOLIC_PAIS usando 'tipoSolicitud' y se obtiene IND_PEDI_PRUE
        consulta.append(" SELECT  IND_PEDI_PRUE FROM PED_TIPO_SOLIC_PAIS T ");
        // Se modifica porque en el dtoConsolidado.getTipoSolicitud devuelve el Tipo de Solicitud Pais y no el Tipo de Solicitud
        //consulta.append(" WHERE T.TSOL_OID_TIPO_SOLI = ? ");
        consulta.append(" WHERE T.OID_TIPO_SOLI_PAIS = ? ");
        parametros.add(dtoConsolidado.getTipoSolicitud());
		
        rs = null;
        try {
            rs = bs.dbService.executePreparedQuery(consulta.toString(),parametros);
        } catch (Exception e) {
            UtilidadesLog.error("insertarConsolidado : Exception",e);
            this.logSql("insertarConsolidado . SQL: ",consulta.toString(),
              parametros);
            throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS));
        }
        if(!rs.esVacio()) {
            indicadorP = new Boolean(((BigDecimal)rs.getValueAt(0,0)).intValue() == 1 ? true : false);
        }
				
        consulta = new StringBuffer();
        parametros = new Vector();
        consulta.append("INSERT INTO PED_SOLIC_CABEC ("); 
        consulta.append(" OID_SOLI_CABE, ");
        parametros.add(oid);
        consulta.append(" PAIS_OID_PAIS, ");
        parametros.add(dtoConsolidado.getOidPais());
        consulta.append(" SBAC_OID_SBAC, ");
        parametros.add(dtoConsolidado.getSubacceso());
        if(dtoConsolidado.getNumeroSolicitud() != null) { 
            consulta.append(" VAL_NUME_SOLI, ");
        }
        UtilidadesLog.debug("Se le va a asignar el numero de Consolidado: "+dtoConsolidado.getNumeroSolicitud());
        parametros.add(dtoConsolidado.getNumeroSolicitud());
    
        consulta.append(" ESSO_OID_ESTA_SOLI, ");
        parametros.add(dtoConsolidado.getEstado());
        consulta.append(" SOCI_OID_SOCI ");
        parametros.add(dtoConsolidado.getSociedad());
        if(clasificacion != null) {
            consulta.append(" ,CLSO_OID_CLAS_SOLI ");
            parametros.add(clasificacion);
        }
        if(modulo != null) {
            consulta.append(" ,MODU_OID_MODU ");
            parametros.add(modulo);
        }
      
        if(operacion != null) {
            consulta.append(" ,OPER_OID_OPER ");
            parametros.add(operacion);
        }
        consulta.append(" ,TSPA_OID_TIPO_SOLI_PAIS ");
        parametros.add(dtoConsolidado.getTipoSolicitud());
        if(indicador != null){
            consulta.append(" ,IND_OC ");
            parametros.add(indicador);
        }
        if(indicadorP != null){
            consulta.append(" ,IND_PEDI_PRUE ");
            parametros.add(indicadorP);
        }
        if(dtoConsolidado.getOidDocumentoReferencia() != null){
            consulta.append(" ,SOCA_OID_DOCU_REFE ");
            parametros.add(dtoConsolidado.getOidDocumentoReferencia());
        }
        if(dtoConsolidado.getNumeroDocumentoOrigen() != null) {
            consulta.append(" ,NUM_DOCU_ORIG ");
            parametros.add(dtoConsolidado.getNumeroDocumentoOrigen());
        }
        consulta.append(" ,PERD_OID_PERI ");
        parametros.add(dtoConsolidado.getPeriodo());
        consulta.append(" ,FEC_CRON ");
        parametros.add(new java.sql.Date (dtoConsolidado.getFecha().getTime()));
            
        //Modificadio por incidencia 14180, se modifica por la incidencia 14555
        if (dtoConsolidado.getFechaFacturacion()!=null){
            consulta.append(" ,FEC_FACT ");
            parametros.add(new java.sql.Date (dtoConsolidado.getFechaFacturacion().getTime()));
        }
        
        if(dtoConsolidado.getFechaPrevistaFacturacion() != null) {
            consulta.append(" ,FEC_PROG_FACT ");
            parametros.add(new java.sql.Date(dtoConsolidado.getFechaPrevistaFacturacion().getTime()));
        }
        if(dtoConsolidado.getNumeroLoteFacturacion() != null) {
            consulta.append(" ,NUM_LOTE_FACT ");
            parametros.add(dtoConsolidado.getNumeroLoteFacturacion());
        }
        consulta.append(" ,CLIE_OID_CLIE ");
        parametros.add(dtoConsolidado.getOidCliente());
        consulta.append(" ,TICL_OID_TIPO_CLIE ");
        parametros.add(dtoConsolidado.getTipoCliente());
        consulta.append(" ,SBTI_OID_SUBT_CLIE ");
        parametros.add(dtoConsolidado.getSubtipoCliente());
        if((dtoConsolidado.getDestinatario() != null)&&(dtoConsolidado.getDestinatario().longValue() != 0)) {
            consulta.append(" ,CLIE_OID_CLIE_DEST ");
            parametros.add(dtoConsolidado.getDestinatario());
        }
        if(dtoConsolidado.getOidDireccionCliente() != null) {
            consulta.append(" ,CLDI_OID_CLIE_DIRE ");
            parametros.add(dtoConsolidado.getOidDireccionCliente());
        }
        consulta.append(" ,CLIE_OID_CLIE_PAGA ");
        parametros.add(dtoConsolidado.getOidPagadorFactura());
        consulta.append(" ,CLIE_OID_CLIE_RECE_FACT ");
        parametros.add(dtoConsolidado.getReceptorFactura());
        consulta.append(" ,TDOC_OID_TIPO_DOCU ");
        parametros.add(dtoConsolidado.getTipoDocumento());
        if(dtoConsolidado.getTipoDocumentoLegal() != null) {
            consulta.append(" ,TIDO_OID_TIPO_DOCU ");
            parametros.add(dtoConsolidado.getTipoDocumentoLegal());
        }
        consulta.append(" ,NUM_CLIEN "); 
        parametros.add(new Long(0));
        if(dtoConsolidado.getTipoDespacho() != null) {
            consulta.append(" ,TIDS_OID_TIPO_DESP ");
            parametros.add(dtoConsolidado.getTipoDespacho());
        }
        if(dtoConsolidado.getAccesoFisico() != null) {
            consulta.append(" ,ACFI_OID_ACCE_FISI ");
            parametros.add(dtoConsolidado.getAccesoFisico());
        }
        consulta.append(" ,ZZON_OID_ZONA ");
        parametros.add(dtoConsolidado.getZona());
        if(dtoConsolidado.getTerritorioCliente() != null) {
          //incidencia: BELC300010096
            consulta.append(" ,ZTAD_OID_TERR_ADMI ");
            parametros.add(dtoConsolidado.getTerritorioCliente());
        }
        consulta.append(" ,TERR_OID_TERR ");  //incidencia: BELC300010096
        parametros.add(dtoConsolidado.getTerritorio());
        if((dtoConsolidado.getUbigeo() != null) && (dtoConsolidado.getUbigeo().longValue()!= 0)) {
            consulta.append(" ,VEPO_OID_VALO_ESTR_GEOP ");
            parametros.add(dtoConsolidado.getUbigeo());
        }
        
            //eliminado por incidencia 16500			
        /*TaponPuntoEmision taponPE = new TaponPuntoEmision();
        if(taponPE.obtenerPuntoEmision() != null) {
          consulta.append(" ,VAL_PUNT_EMIS ");
          parametros.add(taponPE.obtenerPuntoEmision());
                dtoConsolidado.setPuntoEmision(taponPE.obtenerPuntoEmision());
        }*/
        
        if (dtoConsolidado.getPuntoEmision()!=null){
            consulta.append(" ,VAL_PUNT_EMIS ");
            parametros.add(dtoConsolidado.getPuntoEmision());
        }
		
        if((dtoConsolidado.getFormaPago() != null)&&(dtoConsolidado.getFormaPago().longValue() != 0)) {
            consulta.append(" ,FOPA_OID_FORM_PAGO ");
            parametros.add(dtoConsolidado.getFormaPago());
        }
        consulta.append(" ,ALMC_OID_ALMA ");
        parametros.add(dtoConsolidado.getAlmacen());
        if(dtoConsolidado.getIndicadorImpuestosFlete() != null) {
            consulta.append(" ,TAIM_OID_TASA_IMPU ");
            parametros.add(dtoConsolidado.getIndicadorImpuestosFlete());
        }
        if(dtoConsolidado.getTasaImpuesto() != null) {
            consulta.append(" ,VAL_TASA_IMPU ");
            parametros.add(dtoConsolidado.getTasaImpuesto());
        }
        if(dtoConsolidado.getObservaciones() != null) { 
            consulta.append(" ,VAL_GLOS_OBSE ");
            parametros.add(dtoConsolidado.getObservaciones());
        }
        if(dtoConsolidado.getGrupoProcesos() != null) {
            consulta.append(" ,GRPR_OID_GRUP_PROC ");
            parametros.add(dtoConsolidado.getGrupoProcesos());
        }
        consulta.append(" ,PROC_OID_PROC ");
        parametros.add(dtoConsolidado.getProceso());
        if(dtoConsolidado.getEstadoCredito() != null) {
            consulta.append(" ,ESPE_OID_ESTA_PEDI ");
            parametros.add(dtoConsolidado.getEstadoCredito());
        }
        consulta.append(" ,IND_IMPR ");
        parametros.add(Boolean.FALSE);
        if(dtoConsolidado.getIndicadorEstadisticable() != null) {
            consulta.append(" ,IND_ESTA ");
            parametros.add(dtoConsolidado.getIndicadorEstadisticable());
        }
        if(dtoConsolidado.getIndicadorGeneraCuentaCorriente() != null) {
            consulta.append(" ,IND_GENE_CC ");
            parametros.add(dtoConsolidado.getIndicadorGeneraCuentaCorriente());
        }
        consulta.append(" , IND_APLI_MANU ");
        parametros.add(Boolean.FALSE);
        if(dtoConsolidado.getIndicadorRevision() != null) {
            consulta.append(" , INRE_OID_INDI_REVI ");   //pperez Incidencia BELC300023071
            parametros.add(dtoConsolidado.getIndicadorRevision());
        }
        if(dtoConsolidado.getUnidadesDemandaRealTotal() != null) {
            consulta.append(" ,VAL_UNID_DEMA_REAL_TOTA ");
            parametros.add(dtoConsolidado.getUnidadesDemandaRealTotal());
        }
        if(dtoConsolidado.getUnidadesPorAtenderTotal() != null) {
            consulta.append(" ,NUM_UNID_POR_ATEN_TOTA  ");
            parametros.add(dtoConsolidado.getUnidadesPorAtenderTotal());
        }
        if(dtoConsolidado.getUnidadesAtendidasTotal() != null) {
            consulta.append(",NUM_UNID_ATEN_TOTA ");
            parametros.add(dtoConsolidado.getUnidadesAtendidasTotal());
        }
        if((dtoConsolidado.getMoneda() != null)&&(dtoConsolidado.getMoneda().longValue() != 0)) {
            consulta.append(" ,MONE_OID_MONE ");
            parametros.add(dtoConsolidado.getMoneda());
        }
        if((dtoConsolidado.getTipoCambio() != null)&&(dtoConsolidado.getTipoCambio().longValue() != 0)) {
            consulta.append(" ,VAL_TIPO_CAMB ");
            parametros.add(dtoConsolidado.getTipoCambio());
        }
        if(dtoConsolidado.getIndicadorExentoFlete() != null) {
            consulta.append(" ,IND_EXEN_FLET ");
            parametros.add(dtoConsolidado.getIndicadorExentoFlete());
        }
        if(dtoConsolidado.getBaseFleteLocal() != null) {
            consulta.append(" ,VAL_BASE_FLET_LOCA ");
            parametros.add(dtoConsolidado.getBaseFleteLocal());
        }
        if(dtoConsolidado.getImporteFleteLocal() != null) {
            consulta.append(" ,VAL_IMPO_FLET_LOCA ");
            parametros.add(dtoConsolidado.getImporteFleteLocal());
        }
        if(dtoConsolidado.getRecargoFleteLocal() != null) {
            consulta.append(" ,VAL_RECA_FLET_LOCA ");
            parametros.add(dtoConsolidado.getRecargoFleteLocal());
        }
        if(dtoConsolidado.getOtrosRecargosLocal() != null) {
            consulta.append(" ,VAL_OTRO_RECA_LOCA ");
            parametros.add(dtoConsolidado.getOtrosRecargosLocal());
        }
        if(dtoConsolidado.getTotalFleteLocal() != null) {
            consulta.append(" ,VAL_TOTA_FLET_LOCA ");
            parametros.add(dtoConsolidado.getTotalFleteLocal());
        }
        if(dtoConsolidado.getImporteFleteTotalLocal() != null) {
            consulta.append(" ,VAL_IMPO_FLET_TOTA_LOCA ");
            parametros.add(dtoConsolidado.getImporteFleteTotalLocal());
        }
        if(dtoConsolidado.getImporteFleteSinImpuestosTotalLocal() != null) {
            consulta.append(" ,VAL_IMPO_FLET_SIN_IMPU_TOTA ");
            parametros.add(dtoConsolidado.getImporteFleteSinImpuestosTotalLocal());
        }
        if(dtoConsolidado.getBaseFleteDocumento() != null) {
            consulta.append(" ,VAL_BASE_FLET_DOCU ");
            parametros.add(dtoConsolidado.getBaseFleteDocumento());
        }
        if(dtoConsolidado.getImporteFleteDocumento() != null) {
            consulta.append(" ,VAL_IMPO_FLET_DOCU ");
            parametros.add(dtoConsolidado.getImporteFleteDocumento());
        }
        if(dtoConsolidado.getRecargoFleteDocumento() != null) {
            consulta.append(" ,VAL_RECA_FLET_DOCU ");
            parametros.add(dtoConsolidado.getRecargoFleteDocumento());
        }
        if(dtoConsolidado.getOtrosRecargosDocumento() != null) {
            consulta.append(" ,VAL_OTRO_RECA_DOCU ");
            parametros.add(dtoConsolidado.getOtrosRecargosDocumento());
        }
        if(dtoConsolidado.getTotalFleteDocumento() != null) {
            consulta.append(" ,VAL_TOTA_FLET_DOCU ");
            parametros.add(dtoConsolidado.getTotalFleteDocumento());
        }
        if(dtoConsolidado.getImporteFleteTotalDocumento() != null) {
            consulta.append(" ,VAL_IMPO_FLET_TOTA_DOCU ");
            parametros.add(dtoConsolidado.getImporteFleteTotalDocumento());
        }
        if(dtoConsolidado.getImporteFleteSinImpuestosTotalDocumento() != null) {
            consulta.append(" ,VAL_IMPO_FLET_SIN_IMPU_DOCU ");
            parametros.add(dtoConsolidado.getImporteFleteSinImpuestosTotalDocumento());
        }
        if(dtoConsolidado.getImporteDescuento3TotalLocal() != null) {
            consulta.append(" ,VAL_IMPO_DESC_3_TOTA_LOCA ");
            parametros.add(dtoConsolidado.getImporteDescuento3TotalLocal());
        }
        if(dtoConsolidado.getImporteDescuento3TotalDocumento() != null) {
            consulta.append(" ,VAL_IMPO_DESC_3_TOTA_DOCU ");
            parametros.add(dtoConsolidado.getImporteDescuento3TotalDocumento());
        }
        if(dtoConsolidado.getPrecioContableSinImpuestosTotalLocal() != null) {
            consulta.append(" ,VAL_PREC_CONT_SIN_IMPU_TOTA ");
            parametros.add(dtoConsolidado.getPrecioContableSinImpuestosTotalLocal());		
        }
        if(dtoConsolidado.getPrecioContableSinImpuestosTotalDocumento() != null) {
            consulta.append(" ,VAL_PREC_CONT_SIN_IMPU_TOTA_1 ");
            parametros.add(dtoConsolidado.getPrecioContableSinImpuestosTotalDocumento());
        }
        if(dtoConsolidado.getImporteDescuento3SinImpuestosTotalLocal() != null) {
            consulta.append(" ,VAL_IMPO_DTO_3_SIN_IMP_TOT_LOC ");
            parametros.add(dtoConsolidado.getImporteDescuento3SinImpuestosTotalLocal());
        }
        if(dtoConsolidado.getImporteDescuento3SinImpuestosTotalDocumento() != null) {
            consulta.append(" ,VAL_IMPO_DESC_3_SIN_IMPU_TOTA ");
            parametros.add(dtoConsolidado.getImporteDescuento3SinImpuestosTotalDocumento());
        }
        if(dtoConsolidado.getImporteDescuentoTotalLocal() != null) {
            consulta.append(" ,VAL_IMPO_DESC_TOTA_LOCA ");
            parametros.add(dtoConsolidado.getImporteDescuentoTotalLocal());
        }
        if(dtoConsolidado.getImporteDescuentoTotalDocumento() != null) {
            consulta.append(" ,VAL_IMPO_DESC_TOTA_DOCU ");
            parametros.add(dtoConsolidado.getImporteDescuentoTotalDocumento());
        }
        if(dtoConsolidado.getPrecioNetoTotalLocal() != null) {
            consulta.append(" ,VAL_PREC_NETO_TOTA_LOCA ");
            parametros.add(dtoConsolidado.getPrecioNetoTotalLocal());
        }
        if(dtoConsolidado.getPrecioNetoTotalDocumento() != null) {
            consulta.append(" ,VAL_PREC_NETO_TOTA_DOCU ");
            parametros.add(dtoConsolidado.getPrecioNetoTotalDocumento());
        }
        if(dtoConsolidado.getImporteImpuestosTotalLocal() != null) {
            consulta.append(" ,VAL_IMPO_IMPU_TOTA_LOCA ");
            parametros.add(dtoConsolidado.getImporteImpuestosTotalLocal());
        }
        if(dtoConsolidado.getImporteImpuestosTotalDocumento() != null) {
            consulta.append(" ,VAL_IMPO_IMPU_TOTA_DOCU ");
            parametros.add(dtoConsolidado.getImporteImpuestosTotalDocumento());
        }
        if(dtoConsolidado.getTotalAPagarLocal() != null) {
            consulta.append(" ,VAL_TOTA_PAGA_LOCA ");
            parametros.add(dtoConsolidado.getTotalAPagarLocal());
        }
        if(dtoConsolidado.getTotalAPagarDocumento() != null) {
            consulta.append(" ,VAL_TOTA_PAGA_DOCU ");
            parametros.add(dtoConsolidado.getTotalAPagarDocumento());
        }
        if(dtoConsolidado.getImporteRedondeoLocal() != null) {
            consulta.append(" ,VAL_IMPO_REDO_LOCA ");
            parametros.add(dtoConsolidado.getImporteRedondeoLocal());
        }
        if(dtoConsolidado.getImporteRedondeoDocumento() != null) {
            consulta.append(" ,VAL_IMPO_REDO_DOCU ");
            parametros.add(dtoConsolidado.getImporteRedondeoDocumento());
        }
        if(dtoConsolidado.getUsuario() != null) {
            consulta.append(" ,VAL_USUA ");
            parametros.add(dtoConsolidado.getUsuario());
        }
        //Añadidos por incidencia 10134
        if(dtoConsolidado.getPrecioCatalogoTotalDocumento() != null) {
            consulta.append(" ,VAL_PREC_CATA_TOTA_DOCU ");
            parametros.add(dtoConsolidado.getPrecioCatalogoTotalDocumento());
        }
        if(dtoConsolidado.getPrecioCatalogoTotalLocal() != null) {
            consulta.append(" ,VAL_PREC_CATA_TOTA_LOCA ");
            parametros.add(dtoConsolidado.getPrecioCatalogoTotalLocal());
        }
        if(dtoConsolidado.getPrecioCatalogoSinImpuestoTotalDocumento() != null) {
            consulta.append(" ,VAL_PREC_CATA_SIN_IMPU_TOTA_DO ");
            parametros.add(dtoConsolidado.getPrecioCatalogoSinImpuestoTotalDocumento());
        }
        if(dtoConsolidado.getPrecioContableSinImpuestosTotalLocal() != null) {
            consulta.append(" ,VAL_PREC_CATA_SIN_IMPU_TOTA ");
            parametros.add(dtoConsolidado.getPrecioCatalogoSinImpuestoTotalLocal());
        }
        if(dtoConsolidado.getImporteDescuento1SinImpuestoTotalDocumento() != null) {
            consulta.append(" ,VAL_IMPO_DESC_1_SIN_IMPU_TOTA ");
            parametros.add(dtoConsolidado.getImporteDescuento1SinImpuestoTotalDocumento());
        }
        if(dtoConsolidado.getImporteDescuento1SinImpuestoTotalLocal() != null) {
            consulta.append(" ,VAL_IMPO_DTO_1_SIN_IMP_TOT_LOC ");
            parametros.add(dtoConsolidado.getImporteDescuento1SinImpuestoTotalLocal());
        }
        if(dtoConsolidado.getPrecioFacturaTotalDocumento() != null) {
            consulta.append(" ,VAL_PREC_FACT_TOTA_DOCU ");
            parametros.add(dtoConsolidado.getPrecioFacturaTotalDocumento());
        }
        if(dtoConsolidado.getPrecioFacturaTotalLocal() != null) {
            consulta.append(" ,VAL_PREC_FACT_TOTA_LOCA ");
            parametros.add(dtoConsolidado.getPrecioFacturaTotalLocal());
        }
        if(dtoConsolidado.getImporteDescuento1TotalDocumento() != null){
            consulta.append(" ,VAL_IMPO_DESC_1_TOTA_DOCU ");
            parametros.add(dtoConsolidado.getImporteDescuento1TotalDocumento());
        }
        if(dtoConsolidado.getImporteDescuento1TotalLocal() != null){
            consulta.append(" ,VAL_IMPO_DESC_1_TOTA_LOCA ");
            parametros.add(dtoConsolidado.getImporteDescuento1TotalLocal());
        }
        if(dtoConsolidado.getImporteRedondeoConsolidadoDocumento() != null){
            consulta.append(" , VAL_IMPO_REDO_CONS_DOCU ");
            parametros.add(dtoConsolidado.getImporteRedondeoConsolidadoDocumento());
        }
        if(dtoConsolidado.getImporteRedondeoConsolidadoLocal() != null){
            consulta.append(" , VAL_IMPO_REDO_CONS_LOCA ");
            parametros.add(dtoConsolidado.getImporteRedondeoConsolidadoLocal());
        }   
        if(dtoConsolidado.getPrecioContableTotalLocal() != null){
            consulta.append(" , VAL_PREC_CONT_TOTA_LOCA ");
            parametros.add(dtoConsolidado.getPrecioContableTotalLocal());   
        }
        if(dtoConsolidado.getPrecioContableTotalDocumento() != null){
            consulta.append(" , VAL_PREC_CONT_TOTA_DOCU ");
            parametros.add(dtoConsolidado.getPrecioContableTotalDocumento());
        }
        if(dtoConsolidado.getPrecioCatalogoTotalLocalUnidadesPorAtender() != null){
            consulta.append(" ,VAL_PREC_CATA_TOTA_LOC_UNI_DEM ");
            parametros.add(dtoConsolidado.getPrecioCatalogoTotalLocalUnidadesPorAtender());
        }

        //añadido por incidencia 14180
        consulta.append(" ,IND_TS_NO_CONSO");
        parametros.add(new Integer(0));
        
        consulta.append(") VALUES ( ?");
        for (int i = 1; i < parametros.size(); i++){
            consulta.append(", ?");
        }
        consulta.append(" ) ");
		
		
        // Se ejecuta la consulta  		
        try {
            bs.dbService.executePreparedUpdate(consulta.toString(),parametros);
        } catch (Exception e) {
            UtilidadesLog.error("insertarConsolidado : Exception",e);
            this.logSql("insertarConsolidado . SQL: ",consulta.toString(),
              parametros);
            throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS));
        }
    
        consulta = new StringBuffer();
        parametros = new Vector();
        consulta.append(" INSERT INTO PED_SOLIC_CABEC_SECUE ( SOCA_OID_SOLI_CABE ) ");
        consulta.append(" VALUES (?) ");
        parametros.add(oid);
        
        bs = UtilidadesEJB.getBelcorpService();
        try {
            bs.dbService.executePreparedUpdate(consulta.toString(),parametros);
        } catch (Exception e) {
            UtilidadesLog.error("insertarConsolidado : Exception",e);
            this.logSql("insertarConsolidado . SQL: ",consulta.toString(),
              parametros);
            throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS));
        }
        
        
        UtilidadesLog.info("DAOSolicitudCabecera.insertarConsolidado (DTOFACCabeceraSolicitud dtoConsolidado): Salida");
        return oid;
    }

	public void actualizarRedondeosConsolidado(DTOFACCabeceraSolicitud dtoConsolidado,  
        Boolean actualizarRedondeoLocal, Boolean actualizarRedondeoDocumento) 
		throws MareException {

		UtilidadesLog.info("DAOSolicitudCabecera.actualizarRedondeosConsolidado(DTOFACCabeceraSolicitud dtoConsolidado, Boolean actualizarRedondeoLocal, Boolean actualizarRedondeoDocumento): Entrada");

		StringBuffer sql = new StringBuffer("");
		Vector vectorParametros = new Vector();
		
		sql.append(" UPDATE PED_SOLIC_CABEC ");
		sql.append(" SET ");

		if(actualizarRedondeoLocal.booleanValue()){

			sql.append(" VAL_TOTA_PAGA_LOCA = ? , ");
			vectorParametros.add(dtoConsolidado.getTotalAPagarLocal());
			sql.append("VAL_IMPO_REDO_CONS_LOCA = ? ");
			vectorParametros.add(dtoConsolidado.getImporteRedondeoConsolidadoLocal());
		}
		if(actualizarRedondeoDocumento.booleanValue()){

			if(actualizarRedondeoLocal.booleanValue()){
				sql.append(" , ");
			}
			sql.append(" VAL_TOTA_PAGA_DOCU = ? , ");
			vectorParametros.add(dtoConsolidado.getTotalAPagarDocumento());
			sql.append("VAL_IMPO_REDO_CONS_DOCU = ? ");
			vectorParametros.add(dtoConsolidado.getImporteRedondeoConsolidadoDocumento());
		}

        sql.append(" WHERE OID_SOLI_CABE = ? ");
        vectorParametros.add(dtoConsolidado.getOidCabeceraSolicitud());
        

		BelcorpService bs = null;

		try {                                                                                                       
		  bs = BelcorpService.getInstance();                                                                      
		} catch (MareMiiServiceNotFoundException e) {                                                               
		  throw new MareException(e);                                                                              
		} 
		try {                                                                                                       
			loguearSql("**** SQL  actualizarRedondeosConsolidado: ",sql.toString() , vectorParametros);		                        
			bs.dbService.executePreparedUpdate(sql.toString() , vectorParametros);                                           
		} catch (Exception e) {                                                                                     
			throw new MareException(e);                                                                              
		}           
		
	  UtilidadesLog.info("DAOSolicitudCabecera.actualizarRedondeosConsolidado(DTOFACCabeceraSolicitud dtoConsolidado, Boolean actualizarRedondeoLocal, Boolean actualizarRedondeoDocumento): Salida");
	}


	private void logSql(String metodo, String sql, Vector params){
        UtilidadesLog.info("DAOSolicitudCabecera.logSql(String metodo, String sql, Vector params): Entrada");
		UtilidadesLog.debug(metodo + sql);
		if (params!=null && params.size()>0) {
			String sParams="";
			for (int i=0; i<params.size();i++){
				sParams+="param "+ (i+1) + ": " + params.elementAt(i) + ", ";
			}
			UtilidadesLog.debug(metodo + sParams);
		}
        UtilidadesLog.info("DAOSolicitudCabecera.logSql(String metodo, String sql, Vector params): Salida");
	}
    
    /*
     * Autor Cortaberria
     * Fecha 26/07/2005
     * Se agrega la bandera eliminarComa
     */
	private  String convertirArrayToString(ArrayList array){
        UtilidadesLog.info("DAOSolicitudCabecera.convertirArrayToString(ArrayList array): Entrada"); 
		String retorno = "";
        if((array!=null)&&(array.size()!=0)){
			
        	StringBuffer sentencia = new StringBuffer("");
			boolean eliminarComa = false;
			for(int i=0;i<array.size();i++){
            		UtilidadesLog.debug("\n array[ ]=" + array.get(i));
            		if(array.get(i)!=null){
            		      	sentencia.append(" ?, ");
							eliminarComa = true;
                	}
           	}
            	//Quitamos la coma y el espacio del final
				if(eliminarComa) {
	                retorno= sentencia.substring(0,sentencia.length()-2);
				}
				UtilidadesLog.debug(retorno);
         
        }else{
            UtilidadesLog.info("DAOSolicitudCabecera.convertirArrayToString(ArrayList array): Salida 1");
			return "";
			}
        UtilidadesLog.info("DAOSolicitudCabecera.convertirArrayToString(ArrayList array): Salida 2"); 			
		return retorno;
	}//metodo
  
	private void loguearSql(String metodo, String sql, Vector params) {                                             
        UtilidadesLog.info("DAOSolicitudCabecera.loguearSql(String metodo, String sql, Vector params): Entrada"); 			
		this.getLog().debug(metodo + sql);                                                                           
                                                                                                                
		if (params != null && params.size() > 0) {                                                                  
			String sParams = "";                                                                                    
			for (int i=0; i<params.size(); i++) {                                                                   
				if (params.elementAt(i) != null)                                                                    
					sParams += "param "+ (i+1) + ": " +  (params.elementAt(i)).toString() + ", ";                   
				else                                                                                                
					sParams += "param "+ (i+1) + ": es nulo, ";                                                     
			}                                                                                                       
			this.getLog().debug(metodo + sParams);                                                                   
		}		                                                                                                    
        UtilidadesLog.info("DAOSolicitudCabecera.loguearSql(String metodo, String sql, Vector params): Salida"); 			
	}
	private Log getLog() {        
        UtilidadesLog.info("DAOSolicitudCabecera.getLog(): Entrada"); 			
		Log log = null;                                                                                             
		try {                                                                                                       
            UtilidadesLog.info("DAOSolicitudCabecera.getLog(): Salida"); 			
			return (((LoggingService)MareMii.getService(new MareTopic(MareMii.SERVICE_LOGGING))).getMareLog());            
		} catch (Exception e) {                                                                                     
			UtilidadesLog.error(e);
			UtilidadesLog.debug("No se pudo obtener el objeto Log");                                                
			throw new RuntimeException ("No se pudo obtener el objeto Log");                                        
		}                                                                                                           
	}	
  
  public StringBuffer actualizarPosicionPerf(DTOFACPosicionSolicitud dtoPosicion) throws MareException {
        UtilidadesLog.info("DAOSolicitudCabecera.actualizarPosicionPerf(DTOFACPosicionSolicitud dtoPosicion): Entrada");
        if(log.isDebugEnabled()) //sapaza -- cambio Optimizacion Logs -- 05/03/2010
            UtilidadesLog.debug("*** DTOPosicion = "+dtoPosicion);	 
        StringBuffer consulta = new StringBuffer();

        consulta.append("UPDATE PED_SOLIC_POSIC "); 
        consulta.append(" SET  ");
		
        if(dtoPosicion.getIndicadorImpuestos() != null){
          consulta.append(" TAIM_OID_TASA_IMPU = " + dtoPosicion.getIndicadorImpuestos() + " , "); 
        }
        if(dtoPosicion.getTasaImpuesto() != null){
          consulta.append(" VAL_TASA_IMPU = " + dtoPosicion.getTasaImpuesto() +", "); 
        }        
        if(dtoPosicion.getPrecioSinImpuestosUL() != null){
          consulta.append(" VAL_PREC_SIN_IMPU_UNIT_LOCA = " + dtoPosicion.getPrecioSinImpuestosUL() +" , ");           
        }
        if(dtoPosicion.getPrecioSinImpuestosUD() != null){
          consulta.append(" VAL_PREC_SIN_IMPU_UNIT_DOCU = " + dtoPosicion.getPrecioSinImpuestosUD() + ", "); 
        }
        if(dtoPosicion.getPrecioFacturaUL() != null){		
          consulta.append(" VAL_PREC_FACT_UNIT_LOCA = " + dtoPosicion.getPrecioFacturaUL() + ", ");           
        }
        if(dtoPosicion.getPrecioFacturaUD() != null){	
          consulta.append(" VAL_PREC_FACT_UNIT_DOCU = " + dtoPosicion.getPrecioFacturaUD() + " , ");           
        }
        if(dtoPosicion.getPrecioNetoUL() != null){	
          consulta.append(" VAL_PREC_NETO_UNIT_LOCA = " + dtoPosicion.getPrecioNetoUL() + " , ");           
        }
        if(dtoPosicion.getPrecioNetoUD() != null){			
          consulta.append(" VAL_PREC_NETO_UNIT_DOCU = " + dtoPosicion.getPrecioNetoUD() + " , ");           
        }
        if(dtoPosicion.getImporteImpuestoUL() != null){					
          consulta.append(" VAL_IMPO_IMPU_UNIT_LOCA = " + dtoPosicion.getImporteImpuestoUL() + "  , "); 	          
        }
        if(dtoPosicion.getImporteImpuestoUD() != null){				
          consulta.append(" VAL_IMPO_IMPU_UNIT_DOCU = " + dtoPosicion.getImporteImpuestoUD() +  " , ");           
        }
        if(dtoPosicion.getPrecioTotalUL() != null){			
          consulta.append(" VAL_PREC_TOTA_UNIT_LOCA = " + dtoPosicion.getPrecioTotalUL() + " , ");           
        }
        if(dtoPosicion.getPrecioTotalUD() != null){			
          consulta.append(" VAL_PREC_TOTA_UNIT_DOCU = " + dtoPosicion.getPrecioTotalUD() + " , ");           
        }
        if(dtoPosicion.getPrecioContableTL() != null){	
          consulta.append(" VAL_PREC_CONT_TOTA_LOCA = " + dtoPosicion.getPrecioContableTL() + " , ");           
        }
        if(dtoPosicion.getPrecioContableTD() != null){	
          consulta.append(" VAL_PREC_CONT_TOTA_DOCU = " + dtoPosicion.getPrecioContableTD() + " , ");           
        }
        if(dtoPosicion.getPrecioCatalogoTL() != null){			
          consulta.append(" VAL_PREC_CATA_TOTA_LOCA = " + dtoPosicion.getPrecioCatalogoTL() + " , ");           
        }
        if(dtoPosicion.getPrecioCatalogoTD() != null){			
          consulta.append(" VAL_PREC_CATA_TOTA_DOCU = " + dtoPosicion.getPrecioCatalogoTD() + " , ");           
        }
        if(dtoPosicion.getPrecioCatalogoTLUnidadesDemandaReal() != null){			
          consulta.append(" VAL_PREC_CATA_TOTA_LOCA_UNID = " + dtoPosicion.getPrecioCatalogoTLUnidadesDemandaReal() + " , ");           
        }
        if(dtoPosicion.getPrecioFacturaTL() != null){			
          consulta.append(" VAL_PREC_FACT_TOTA_LOCA = " + dtoPosicion.getPrecioFacturaTL() + " , ");           
        }
        if(dtoPosicion.getPrecioFacturaTD() != null){			
          consulta.append(" VAL_PREC_FACT_TOTA_DOCU = " + dtoPosicion.getPrecioFacturaTD() + " , ");           
        }
        if(dtoPosicion.getPrecioSinImpuestosTL() != null){				
          consulta.append(" VAL_PREC_SIN_IMPU_TOTA_LOCA = " + dtoPosicion.getPrecioSinImpuestosTL() +" , ");           
        }
        if(dtoPosicion.getPrecioSinImpuestosTD() != null){				
          consulta.append(" VAL_PREC_SIN_IMPU_TOTA_DOCU = " + dtoPosicion.getPrecioSinImpuestosTD() + " , ");           
        }
        if(dtoPosicion.getImporteDescuentoTL() != null){				
          consulta.append(" VAL_IMPO_DESC_TOTA_LOCA = " + dtoPosicion.getImporteDescuentoTL() + " , ");           
        }	
        if(dtoPosicion.getImporteDescuentoTD() != null){			
          consulta.append(" VAL_IMPO_DESC_TOTA_DOCU = " + dtoPosicion.getImporteDescuentoTD() + " , ");           
        }
        if(dtoPosicion.getPrecioNetoTL() != null){	
          consulta.append(" VAL_PREC_NETO_TOTA_LOCA = " + dtoPosicion.getPrecioNetoTL() + " , ");           
        }
        if(dtoPosicion.getPrecioNetoTD() != null){	
          consulta.append(" VAL_PREC_NETO_TOTA_DOCU = " + dtoPosicion.getPrecioNetoTD() + " , ");           
        }
        if(dtoPosicion.getImporteImpuestoTL() != null){		
          consulta.append(" VAL_IMPO_IMPU_TOTA_LOCA = " + dtoPosicion.getImporteImpuestoTL() + " , ");           
        }
        if(dtoPosicion.getImporteImpuestoTD() != null){		
          consulta.append(" VAL_IMPO_IMPU_TOTA_DOCU = " + dtoPosicion.getImporteImpuestoTD() + " , ");           
        }
        //campos añadidos por incidencia BELC300014914
        if(dtoPosicion.getImporteDescuentoSinImpuestosUL() != null){
            consulta.append(" VAL_IMPO_DES_SIN_IMP_UNIT_LOCA  = " + dtoPosicion.getImporteDescuentoSinImpuestosUL() + " , ");            
        }	
        if(dtoPosicion.getImporteDescuentoSinImpuestosUD() != null){
            consulta.append(" VAL_IMPO_DES_SIN_IMP_UNIT_DOCU   = " + dtoPosicion.getImporteDescuentoSinImpuestosUD() + " , ");            
        }	
        if(dtoPosicion.getPrecioTotalTL() != null){
            consulta.append(" VAL_PREC_TOTA_TOTA_LOCA = " + dtoPosicion.getPrecioTotalTL() + "  ,");			
        }	
        if(dtoPosicion.getPrecioTotalTD() != null){
            consulta.append(" VAL_PREC_TOTA_TOTA_DOCU = " +dtoPosicion.getPrecioTotalTD() + " ,");
        }	
        if(dtoPosicion.getUnidadesAtendidas() != null){
            consulta.append(" NUM_UNID_ATEN   = " + dtoPosicion.getUnidadesAtendidas() + "  ,");			
        }

        if(dtoPosicion.getIndicadorNoImprimible() != null && dtoPosicion.getIndicadorNoImprimible().booleanValue()){
            consulta.append(" IND_NO_IMPR = 1, ");			
        } else {
            consulta.append(" IND_NO_IMPR = 0, ");			
        }
        
        consulta.append(" IND_DENT_FUER_CAJA_BOLS   = (select m.COD_IND_DENT_CAJA INDICADOR from MAE_PRODU m where m.OID_PROD = "+dtoPosicion.getProducto()+"), ");

        if(dtoPosicion.getProducto() != null){
            consulta.append(" PROD_OID_PROD   = " + dtoPosicion.getProducto() + " ,");			
        }	
        if(dtoPosicion.getNumeroConsolidado() != null){
            consulta.append("  NUM_CONS   = " + dtoPosicion.getNumeroConsolidado()  + "  ,");
        }	
        if(dtoPosicion.getImporteDescuentoSinImpuestosTL() != null){
            consulta.append(" VAL_IMPO_DES_SIN_IMP_TOTA = " + dtoPosicion.getImporteDescuentoSinImpuestosTL() + " ,");            
        }else{
            consulta.append(" VAL_IMPO_DES_SIN_IMP_TOTA = 0 ,");
        }
        if(dtoPosicion.getImporteDescuentoSinImpuestosTD() != null){
            consulta.append(" VAL_IMPO_DES_SIN_IMP_TOTA_DOCU  = " + dtoPosicion.getImporteDescuentoSinImpuestosTD() + " ,");
        }else{
            consulta.append(" VAL_IMPO_DES_SIN_IMP_TOTA_DOCU  = 0 ,");
        }
        if(dtoPosicion.getUnidadesComprometidas() != null){
            consulta.append(" NUM_UNID_COMPR  = " + dtoPosicion.getUnidadesComprometidas());            
        }else{
            consulta.append(" NUM_UNID_COMPR = 0 ");
        }
        /* Agregado por Cambio FAC-003 ------ AL */ 
        if (dtoPosicion.getPrecioContableULAnterior() != null ) {
           consulta.append(", VAL_PREC_CONT_UNIT_LOCA  = " + dtoPosicion.getPrecioContableULAnterior());   
        }
        if (dtoPosicion.getPrecioContableUDAnterior() != null ) {
           consulta.append(", VAL_PREC_CONTA_UNIT_DOCU  = " + dtoPosicion.getPrecioContableUDAnterior());   
        }        
        /* Agregado por Cambio FAC-003 ------ AL */ 
		consulta.append(" WHERE OID_SOLI_POSI = " + dtoPosicion.getOidPosicion() + ";");
		
		UtilidadesLog.info("DAOSolicitudCabecera.actualizarPosicionPerf(DTOFACPosicionSolicitud dtoPosicion): Salida");
    return consulta;
    }
  
}
