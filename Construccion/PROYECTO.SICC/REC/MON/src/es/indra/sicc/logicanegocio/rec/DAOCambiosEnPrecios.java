/**
 * Copyright 2005 © por Indra Sistemas,S.A.. Todos los derechos reservados.
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
package es.indra.sicc.logicanegocio.rec;

import es.indra.mare.common.exception.MareException;
import es.indra.mare.common.mii.services.jdbcservice.RecordSet;

import es.indra.sicc.dtos.rec.DTOCargaListas;
import es.indra.sicc.dtos.rec.DTODetallePreRec;
import es.indra.sicc.dtos.rec.DTOBuscarCambiosPrecios;
import es.indra.sicc.dtos.rec.DTOLista;
import es.indra.sicc.dtos.rec.DTORecuperarCabeGen;
import es.indra.sicc.util.BelcorpService;
import es.indra.sicc.util.CodigosError;
import es.indra.sicc.util.DTOBelcorp;
import es.indra.sicc.util.UtilidadesEJB;
import es.indra.sicc.util.UtilidadesError;
import es.indra.sicc.util.UtilidadesLog;
import es.indra.sicc.util.DTOOID;

import es.indra.sicc.util.UtilidadesPaginacion;
import java.math.BigDecimal;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Vector;

import java.util.Iterator;

public class DAOCambiosEnPrecios {

    public DAOCambiosEnPrecios(){
    }

    // SQL modificada por incidencia BELC300019830
    // BELC300020247
    public RecordSet recuperarRegistros(DTODetallePreRec dtoe) throws MareException{
        UtilidadesLog.info("DAOCambiosEnPrecios.recuperarRegistros(DTODetallePreRec):Entrada");
        
        UtilidadesLog.debug("*** DTODetallePreRec: " + dtoe);
        
        RecordSet resultado = null;
        StringBuffer sql = new StringBuffer();
       //Vector parametros = new Vector();
        String codigoError = null;

//------------------------------------------------------------------------------
/* Antigua definicion del metodo, sin validez por incidencia <<REC-024>> */
/*		sql.append("SELECT ROWNUM OID, ");
		sql.append("sol.CLIE_OID_CLIE, cli.COD_CLIE, ");
		sql.append("cli.VAL_NOM1, cli.VAL_NOM2, cli.VAL_APE1, cli.VAL_APE2, ");
		sql.append("pos.NUM_UNID_ATEN as NUMEROUNIDADES, ");
		sql.append("pos.VAL_PREC_CATA_UNIT_LOCA as PRECIOCATALOGOORIGEN, ");
		sql.append("pos.NUM_UNID_ATEN * pos.VAL_PREC_CATA_UNIT_LOCA as IMPORTENETOORIGEN, ");
		sql.append("pos.VAL_IMPO_DESC_TOTA_LOCA as DESCUENTOORIGEN, ");
		sql.append("'' as PRECIOCATALOGODESTINO, ");
		sql.append("'' as IMPORTENETODESTINO, ");
		sql.append("'' as IMPORTEDIFERENCIA, ");
		sql.append("sol.TSPA_OID_TIPO_SOLI_PAIS, ");  
		sql.append("pos.OID_SOLI_POSI, "); // BELC300019647
        sql.append("'' , "); // oid del detalleGeneracionMasiva
        sql.append(" sol.SOCA_OID_SOLI_CABE OIDSOLICABE ");
		sql.append("FROM ");
		sql.append("PED_SOLIC_CABEC sol, ");
		sql.append("PED_SOLIC_POSIC pos, ");
		sql.append("MAE_CLIEN cli "); 
        sql.append("WHERE ");
        sql.append("pos.SOCA_OID_SOLI_CABE = sol.OID_SOLI_CABE ");
		sql.append("AND sol.CLIE_OID_CLIE = cli.OID_CLIE ");
		sql.append("AND sol.PERD_OID_PERI = ? ");
        parametros.add(dtoe.getOidPeriodo());
        if(dtoe.getOidSubAcceso() != null) {
            sql.append("AND sol.SBAC_OID_SBAC = ? ");
            parametros.add(dtoe.getOidSubAcceso());
        }
        sql.append("AND sol.PAIS_OID_PAIS = ? ");
        parametros.add(dtoe.getOidPais());
        sql.append("AND sol.TSPA_OID_TIPO_SOLI_PAIS IN (");
        ArrayList tiposSolicitud = dtoe.getArrayTipoSolicitud();
        for (int i=0; i < tiposSolicitud.size() - 1; i++) {
            sql.append("?, ");
            parametros.add((Long)tiposSolicitud.get(i));
        }
        sql.append("?) ");
        parametros.add((Long)tiposSolicitud.get(tiposSolicitud.size() - 1));
        sql.append("AND sol.FEC_FACT IS NOT NULL ");
        if (dtoe.getCodigoVentaAnterior() != null) {
            sql.append("AND pos.VAL_CODI_VENT = ? ");
            parametros.add(dtoe.getCodigoVentaAnterior());
        }
		sql.append("AND sol.SOCA_OID_SOLI_CABE NOT IN ( ");
		sql.append("    SELECT ");
		sql.append("		det.SOCA_OID_SOLI_CABE ");
		sql.append("	FROM ");
		sql.append("		REC_DETAL_GENER_MASIV det, ");
		sql.append("		REC_CABEC_GENER_MASIV cab ");
		sql.append("	WHERE ");
		sql.append("		det.CAGM_OID_CABE_GENE_MASI = cab.OID_CABE_GENE_MASI ");
		sql.append("		AND cab.PAIS_OID_PAIS = ? ");
        parametros.add(dtoe.getOidPais());
		sql.append("		AND cab.OFDE_OID_OFER_DETA = ?");
        parametros.add(dtoe.getDetalleOfertaAnterior());
		sql.append(")"); */
//------------------------------------------------------------------------------

//------------------------------------------------------------------------------

/**********************************************************************************************************************************
 * sbonanno - incidencia REC-015 - INICIO
 * ********************************************************************************************************************************/

/*
        sql.append(" SELECT DISTINCT ");
        sql.append(" consulta.consolidado AS OID, ");
        sql.append(" sol.clie_oid_clie AS oidcliente, ");
        sql.append(" cli.cod_clie AS codcliente, ");
        sql.append(" cli.val_nom1 AS nombre1, ");
        sql.append(" cli.val_nom2 AS nombre2, ");
        sql.append(" cli.val_ape1 AS apellido1, ");
        sql.append(" cli.val_ape2 AS apellido2, ");
        sql.append(" consulta.unidades AS unidades, ");
        sql.append(" pos.val_prec_cata_unit_loca AS preciocatalogoorigen, ");
        sql.append(" consulta.importe AS importeorigen, ");
        sql.append(" pos.val_impo_desc_unit_loca AS descuentoorigen, ");
        sql.append(" '' AS preciocatalogodestino, ");
        sql.append(" '' AS importenetodestino, ");
        sql.append(" '' AS importediferencia, ");
        
        sql.append(" con.tspa_oid_tipo_soli_pais AS oidtiposolicitud, ");
        
        //Modificado por Cristian Valenzuela - 29/06/2006
        //sql.append(" pos.oid_soli_posi AS oissolicitudposic, ");
        sql.append(" '' AS esp1, ");
        //Fin - Modificado por Cristian Valenzuela - 29/06/2006
        sql.append(" '' AS esp2, ");
        sql.append(" sol.soca_oid_soli_cabe oidsolicabe "); 
        sql.append(" FROM ped_solic_cabec con, ");
        sql.append(" ped_solic_cabec sol, ");
        sql.append(" ped_solic_posic pos, ");
        sql.append(" mae_clien cli, ");
        sql.append(" ( SELECT con.oid_soli_cabe consolidado, ");
            sql.append(" SUM (pos.num_unid_aten) unidades, ");
            //sql.append(" SUM (pos.num_unid_aten * pos.val_prec_cata_unit_loca) importe "); cambio rec-24
            sql.append(" SUM (pos.num_unid_aten * pos.VAL_PREC_FACT_UNIT_LOCA) importe ");
            sql.append(" FROM ped_solic_cabec con, ");
            sql.append(" ped_solic_cabec sol, ");
            sql.append(" ped_solic_posic pos ");
            sql.append(" WHERE con.oid_soli_cabe = sol.soca_oid_soli_cabe ");
            sql.append(" AND pos.soca_oid_soli_cabe = sol.oid_soli_cabe ");
            
            if (dtoe != null && dtoe.getOidPeriodo() != null){
                sql.append(" AND con.perd_oid_peri = " + dtoe.getOidPeriodo());
            }
            
            if (dtoe != null && dtoe.getOidSubAcceso() != null){
                sql.append(" AND con.sbac_oid_sbac = " + dtoe.getOidSubAcceso());
            }
            
            if (dtoe != null && dtoe.getOidPais() != null){
                sql.append(" AND con.pais_oid_pais = " + dtoe.getOidPais());
            }
            
            if (dtoe != null && dtoe.getArrayTipoSolicitud() != null && !dtoe.getArrayTipoSolicitud().isEmpty()){
                sql.append(" AND con.tspa_oid_tipo_soli_pais IN (" + arrayToString(dtoe.getArrayTipoSolicitud()) + ") ");
            }
            
            sql.append(" AND sol.fec_fact IS NOT NULL ");
            
            if (dtoe != null && dtoe.getCodigoVentaAnterior() != null){
                sql.append(" AND pos.val_codi_vent = " + dtoe.getCodigoVentaAnterior());
            }
            
            sql.append(" AND con.oid_soli_cabe NOT IN (");
                sql.append(" SELECT det.soca_oid_soli_cabe ");
                sql.append(" FROM rec_detal_gener_masiv det, ");
                sql.append(" rec_cabec_gener_masiv cab ");
                sql.append(" WHERE det.cagm_oid_cabe_gene_masi = cab.oid_cabe_gene_masi ");
                
                if (dtoe != null && dtoe.getOidPais() != null){
                    sql.append(" AND cab.pais_oid_pais = " + dtoe.getOidPais());
                }
                
                if (dtoe != null && dtoe.getDetalleOfertaAnterior() != null){
                    sql.append(" AND cab.ofde_oid_ofer_deta = " + dtoe.getDetalleOfertaAnterior());
                }
                
                sql.append(") ");
                
                sql.append(" GROUP BY con.oid_soli_cabe) consulta ");
        sql.append(" WHERE consulta.consolidado = con.oid_soli_cabe ");
        sql.append(" AND con.clie_oid_clie = cli.oid_clie ");
        sql.append(" AND con.oid_soli_cabe = sol.soca_oid_soli_cabe ");
        sql.append(" AND pos.soca_oid_soli_cabe = sol.oid_soli_cabe ");
        
        if (dtoe != null && dtoe.getCodigoVentaAnterior() != null){
            sql.append(" AND pos.val_codi_vent = " + dtoe.getCodigoVentaAnterior());
        }

*/
//------------------------------------------------------------------------------

            sql.append("   SELECT con.oid_soli_cabe AS OID,  ");// consolidado, oculto
            // Agregado por SICC20070456 - Rafael Romero - 04/10/2007
            sql.append("          con.oid_soli_cabe AS OID_CONSOLIDADO,  ");
            // Fin agregado SICC20070456
            sql.append("          sol.clie_oid_clie AS oidcliente,  ");// oculto
            sql.append("          cli.cod_clie AS codcliente, ");
            sql.append(" 	        cli.val_nom1 AS nombre1, ");
            sql.append("          cli.val_nom2 AS nombre2, ");
            sql.append(" 	        cli.val_ape1 AS apellido1, ");
            sql.append("          cli.val_ape2 AS apellido2, ");
            sql.append("          SUM (pos.num_unid_aten) unidades, ");
            sql.append("          pos.val_prec_cata_unit_loca AS preciocatalogoorigen, ");
            sql.append("          SUM (pos.num_unid_aten * pos.val_prec_fact_unit_loca) AS importeorigen, ");
            // Modificado por SICC20070465 - Rafael Romero - 05/10/2007
            //sql.append("          NVL(SUM (pos.val_impo_desc_unit_loca),0) AS descuentoorigen, ");
            sql.append("          NVL(SUM (pos.val_impo_desc_tota_loca),0) AS descuentoorigen, ");
            // Fin modificado SICC20070465
            sql.append("          '' AS preciocatalogodestino, ");
            sql.append(" 	        '' AS importenetodestino, ");
            sql.append("          '' AS importediferencia, ");
            // Modificado por SICC20070454 - Rafael Romero - 04/10/2007
            sql.append(" 	        con.tspa_oid_tipo_soli_pais AS oidtiposolicitud  ");// tipos de consolidados, oculto
            //sql.append(" '' AS esp1, ");
            //sql.append(" '' AS esp2, ");
            //sql.append("  sol.soca_oid_soli_cabe oidsolicabe "); 
            // Fin modificado SICC20070454
            sql.append("     FROM ped_solic_cabec con, ");
            sql.append("          ped_solic_cabec sol, ");
            sql.append("          ped_solic_posic pos, ");
            sql.append("          mae_clien cli ");
            sql.append("    WHERE con.oid_soli_cabe = sol.soca_oid_soli_cabe ");
            sql.append("      AND pos.soca_oid_soli_cabe = sol.oid_soli_cabe ");
            
            if (dtoe != null && dtoe.getOidPeriodo() != null){
                sql.append("      AND con.perd_oid_peri =  " + dtoe.getOidPeriodo() ); //1362 
            }    

            if (dtoe != null && dtoe.getOidSubAcceso() != null){
                sql.append("      AND con.sbac_oid_sbac =  " + dtoe.getOidSubAcceso() );
            }

            if (dtoe != null && dtoe.getOidPais() != null) {
            sql.append("      AND con.pais_oid_pais =  " + dtoe.getOidPais() );
            }

            if (dtoe != null && dtoe.getArrayTipoSolicitud() != null && !dtoe.getArrayTipoSolicitud().isEmpty()){
                sql.append("      AND con.tspa_oid_tipo_soli_pais IN (  " + arrayToString(dtoe.getArrayTipoSolicitud()) + ") ");
            }
            
            sql.append("      AND sol.fec_fact IS NOT NULL ");
            
            if (dtoe != null && dtoe.getCodigoVentaAnterior() != null) {
            sql.append("      AND pos.val_codi_vent = " + dtoe.getCodigoVentaAnterior() ); //100005
            }
            
            sql.append("      AND con.oid_soli_cabe NOT IN ( ");
            sql.append("          SELECT det.soca_oid_soli_cabe ");
            sql.append("            FROM rec_detal_gener_masiv det, ");
            sql.append("                 rec_cabec_gener_masiv cab ");
            sql.append("           WHERE det.cagm_oid_cabe_gene_masi = cab.oid_cabe_gene_masi ");

            if (dtoe != null && dtoe.getOidPais() != null) {
                sql.append("             AND cab.pais_oid_pais = " + dtoe.getOidPais() );
            }

            if (dtoe != null && dtoe.getDetalleOfertaAnterior() != null){
                sql.append("             AND cab.ofde_oid_ofer_deta = " + dtoe.getDetalleOfertaAnterior() + ")" ); //2591
            }
            sql.append("      AND sol.clie_oid_clie = cli.oid_clie ");
            sql.append(" GROUP BY con.oid_soli_cabe, ");
            sql.append("          con.tspa_oid_tipo_soli_pais, ");
            sql.append("          sol.clie_oid_clie, ");
            sql.append("          cli.cod_clie, ");
            sql.append(" 	 cli.val_nom1, ");
            sql.append("          cli.val_nom2, ");
            sql.append(" 	 cli.val_ape1, ");
            sql.append("          cli.val_ape2, ");
            sql.append("          pos.val_prec_cata_unit_loca, ");
            sql.append("          sol.soca_oid_soli_cabe ");


/**********************************************************************************************************************************
 * sbonanno - por incidencia REC-015 - FIN
 * ********************************************************************************************************************************/

        UtilidadesLog.debug("sql: " + sql);

         BelcorpService bs = UtilidadesEJB.getBelcorpService();
         String sqlPaginada = UtilidadesPaginacion.armarQueryPaginacion(sql.toString(), dtoe);

         try {                                                                  
            resultado = bs.dbService.executeStaticQuery(sqlPaginada);   
         } catch (Exception e) {                                                
            codigoError = CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS;      
            UtilidadesLog.error("DAOCambiosEnPrecios.recuperarRegistros: Exception",e);
            throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));
         }
         
         UtilidadesLog.debug("+++++++++++ RecordSet obtenido: " + resultado);
         
         UtilidadesLog.info("DAOCambiosEnPrecios.recuperarRegistros(DTODetallePreRec):Salida");
         return resultado;
    }
    
    
    private String arrayToString(ArrayList array){
        UtilidadesLog.info("DAOCambiosEnPrecios.arrayToString(ArrayList):Entrada");
    
        Iterator i = null;
        StringBuffer sbTiposSolicitud = new StringBuffer();
        Object o = null;
        Long tipoSolicitud = null;
    
        if (array != null){
            i = array.iterator();
            
            while (i.hasNext()){
                o = i.next();
                
                if (o != null){
                    tipoSolicitud = (Long)o;
                
                    if (sbTiposSolicitud.toString().equals("")){
                        sbTiposSolicitud.append(tipoSolicitud.toString());
                    } else {
                        sbTiposSolicitud.append(",").append(tipoSolicitud.toString());
                    }
                }
            }
        }
        
        UtilidadesLog.info("DAOCambiosEnPrecios.arrayToString(ArrayList):Salida");
        
        return sbTiposSolicitud.toString();
    }
    
    public DTOOID recuperarPrecio (Long OidOperacion) throws MareException{
        UtilidadesLog.info("DAOCambiosEnPrecios.recuperarPrecio(Long):Entrada");
        /*Vamos a recuperar el precio de envía (Factura o Catalogo) para la operación que el usuario selecciono*/ 
        RecordSet resultado = null;
        StringBuffer sql = new StringBuffer();
        Vector parametros = new Vector();
        String codigoError = null;
        
        sql.append(" SELECT op.PENV_OID_PRECIO_ENVIA FROM REC_OPERA op WHERE op.OID_OPER = ?");
        parametros.add(OidOperacion);
        
        BelcorpService bs = UtilidadesEJB.getBelcorpService();
        
        try {                                                                  
            resultado = bs.dbService.executePreparedQuery(sql.toString(),parametros);                                                       
        } catch (Exception e) {                                                
            codigoError = CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS;      
            UtilidadesLog.error(" recuperarPrecio: Exception",e);                                              
            throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));
        }
        if (resultado.esVacio()) {            
            UtilidadesLog.debug("****DAOCambiosEnPrecios.recuperarPrecio: No hay datos ");				
            throw new MareException(new Exception(), UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE));           
        }
     
        DTOOID dto = new DTOOID();
        dto.setOid(new Long(((BigDecimal)resultado.getValueAt(0,0)).longValue()));        
        UtilidadesLog.info("DAOCambiosEnPrecios.recuperarPrecio(Long):Salida");
        return dto;
    }
    
    public RecordSet buscarCambiosPrecios(DTOBuscarCambiosPrecios dtoE) throws MareException{

        UtilidadesLog.info("DAOCambiosEnPrecios.buscarCambiosPrecios(DTOBuscarCambiosPrecios):Entrada " + dtoE);
        /*Acceder a las tablas CabeceraGeneracionMasiva (REC) , DetalleGeneracionMasiva (REC), DetalleOferta (PRE), SolicitudCabecera (PED), Cliente (MAE), Operaciones (REC) haciendo join entre ellas 
        filtrando por: //aquellos filtros que no sean nulos 
        - CabeceraGeneracionMasiva.pais = dtoe.pais 
        - CabeceraGeneracionMasiva.numGenreacion = dtoe.numGenreacion 
        - DetalleOferta.oidMarca = dtoe.oidMarca 
        - DetalleOferta.oidCanal = dtoe.oidCanal 
        - CabeceraGeneracionMasiva.oidAcceso = dtoe.oidAcceso 
        - CabeceraGeneracionMasiva.oidSubAcceso = dtoe.oidSubAcceso 
        - DetalleGeneracionMasiva.oidTipoSolicitud IN dtoe.arrayTipoSolicitud 
        - SolicitudCabecera.numSolicitud = dtoe.numSolicitud 
        - DetalleOferta..oidPeriodoReferencia = dtoe.oidPeriodoReferencia 
        - Cliente.codCliente = dtoe.codCliente 
        - DetalleOferta.codVenta = dtoe.codVenta 
        - DetalleOferta.codVentaGenerar = dtoe.codVentaGenerar 
        - CabeceraGeneracionMasiva.oidOperacion = dtoe.oidOperacion 
        - Operaciones.oidTipoOperacion = dtoe.oidTipoOperacion 
        - CabeceraGeneracionMasiva.fechaGeneracion = dtoe.fechaGeneracion 
        - CabeceraGeneracionMasiva.oidEstadoGeneracion = ConstantesREC.ESTADO_GENERACION_PROVISIONAL 
        
        - y los de las join: CabeceraGeneracionMasiva con DetalleGeneracionMasiva 
        CabeceraGeneracionMasiva con DetalleOferta (através del campo OFDE_OID_DETA_OFER_DEST) 
        CabeceraGeneracionMasiva con DetalleOferta (através del campo OFDE_OID_OFER_DETA) 
        DetalleOferta con SolicitudCabecera 
        DetalleOferta con Cliente 
        CabeceraGeneracionMasiva con Operaciones 
        
        Obtener: 
        - CabeceraGeneracionMasiva.oid 
        - CabeceraGeneracionMasiva.numGenreacion 
        - DetalleOferta.codVenta 
        - DetalleOferta.codVentaGenerar 
        - Operaciones.codOperacion 
        - TipoOperacion.descripcion 
        
        
        Esta consulta se debe retornar paginada y ordenada por el CabeceraGeneracionMasiva.oid 
        Devolver un objeto RecordSet con los registros obtenidos 
        */
        StringBuffer sql = new StringBuffer();
        Vector parametros = new Vector();
 
        sql.append(" SELECT DISTINCT cgm.OID_CABE_GENE_MASI as OID, cgm.NUM_GENE NUMGENERACION, ");
        sql.append(" od1.VAL_CODI_VENT CODVENTA, od2.VAL_CODI_VENT CODVENTAGENERAR, ");
        sql.append(" op.COD_OPER CODOPERACION, ");
        sql.append(" (SELECT I.VAL_I18N FROM V_GEN_I18N_SICC I WHERE I.ATTR_ENTI = 'REC_TIPOS_OPERA' ");
        sql.append(" AND I.ATTR_NUM_ATRI = 1 AND I.IDIO_OID_IDIO = ? ");
        parametros.add(dtoE.getOidIdioma());
        sql.append(" AND TOP.OID_TIPO_OPER = I.VAL_OID ) AS TIPOOPERACION");
        
        sql.append(" FROM REC_CABEC_GENER_MASIV cgm, REC_DETAL_GENER_MASIV dgm, PRE_OFERT_DETAL od1, ");
        sql.append(" PRE_OFERT_DETAL od2, PED_SOLIC_CABEC sc, MAE_CLIEN c, REC_OPERA op, REC_TIPOS_OPERA TOP, CRA_PERIO p ");  

        sql.append(" WHERE cgm.oid_cabe_gene_masi = dgm.cagm_oid_cabe_gene_masi ");
        sql.append(" AND cgm.ofde_oid_deta_ofer_dest = od2.oid_deta_ofer ");
        sql.append(" AND cgm.ofde_oid_ofer_deta = od1 .oid_deta_ofer ");
        sql.append(" AND dgm.soca_oid_soli_cabe = sc.oid_soli_cabe ");
        sql.append(" AND cgm.tiop_oid_tipo_oper = TOP.oid_tipo_oper "); //incidencia 16012
        sql.append(" AND c.OID_CLIE = sc.clie_oid_clie ");
        sql.append(" AND op.oid_oper = TOP.rope_oid_oper ");
        sql.append(" AND sc.perd_oid_peri = p.oid_peri ");
        
        if(dtoE.getOidPais() != null){
            sql.append(" AND cgm.pais_oid_pais = ? ");      //pais
            parametros.add(dtoE.getOidPais());
        }
        if(dtoE.getNumGeneracion() != null){
            sql.append(" AND cgm.num_gene = ?  ");  //numgeneracion
            parametros.add(dtoE.getNumGeneracion());
        }
        if(dtoE.getOidMarca() != null){
            sql.append(" AND p.marc_oid_marc = ?  ");  //marca
            parametros.add(dtoE.getOidMarca());
        }
        if(dtoE.getOidCanal() != null){
            sql.append(" AND p.cana_oid_cana = ?  ");                       //canal
            parametros.add(dtoE.getOidCanal());
        }
        if(dtoE.getOidAcceso() != null){
            sql.append(" AND cgm.acce_oid_acce = ? ");  //acceso
            parametros.add(dtoE.getOidAcceso());
        }
        if(dtoE.getOidSubAcceso() != null){
            sql.append(" AND cgm.sbac_oid_sbac = ?  ");  // subacceso
            parametros.add(dtoE.getOidSubAcceso());
        }
        if(dtoE.getArrayTipoSolicitud() != null){   //tiposolicitud
          if(dtoE.getArrayTipoSolicitud().size()>0) {
                sql.append(" AND dgm.tspa_oid_tipo_soli_pais IN ( ? ");
                parametros.add(dtoE.getArrayTipoSolicitud().get(0));
                for(int i=1; i<dtoE.getArrayTipoSolicitud().size(); i++) {
                    sql.append(", ? ");
                    parametros.add(dtoE.getArrayTipoSolicitud().get(i));
                }
                sql.append(")");
            }
        }
        if(dtoE.getNumSolicitud() != null){
            sql.append(" AND sc.val_nume_soli = ? ");  //numsolicitud
            parametros.add(dtoE.getNumSolicitud());
        }  
        if(dtoE.getOidPeriodo() != null){  
            sql.append(" AND sc.perd_oid_peri = ? ");           // periodo
            parametros.add(dtoE.getOidPeriodo());
        }
        if(dtoE.getCodCliente() != null){
            sql.append(" AND c.cod_clie like '" + dtoE.getCodCliente() + "' ");             // codcliente
        }
        if(dtoE.getCodVenta() != null){
            sql.append(" AND od1 .VAL_CODI_VENT like '" + dtoE.getCodVenta() + "' ");     // codventa  
            
        }
        if(dtoE.getCodVentaGenerar() != null){
            sql.append(" AND od2 .VAL_CODI_VENT like '" + dtoE.getCodVentaGenerar() + "' ");      // codventagenerar  
            
        }
        if(dtoE.getOidOperacion() != null){
            sql.append(" AND op.oid_oper = ? ");              // oidOperacion
            parametros.add(dtoE.getOidOperacion());
        }
        if(dtoE.getOidTipoOperacion() != null){
            sql.append(" AND TOP.OID_TIPO_OPER = ? ");                 // oidtipooperacion
            parametros.add(dtoE.getOidTipoOperacion());
        }
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");  
        if(dtoE.getFechaGeneracion() != null){                     //fechageneracion
            java.sql.Date fecha = new java.sql.Date(dtoE.getFechaGeneracion().getTime());
            String sFecha = sdf.format(fecha);
            sql.append(" AND cgm.fec_gene = TO_DATE(?, 'yyyy-MM-dd') ");
            parametros.add(sFecha);
        }   
        if( dtoE.getOidEstadoGeneracion()!=null){
            sql.append(" AND cgm.ESGN_OID_ESTA_GENE = ? ");
            parametros.add(dtoE.getOidEstadoGeneracion());  // estadogeneracion
        }else{
            sql.append(" AND cgm.ESGN_OID_ESTA_GENE = ? ");
            parametros.add(ConstantesREC.ESTADO_GENERACION_PROVISIONAL);  // estadogeneracion
        }
        sql.append(" ORDER BY OID ");
        BelcorpService bs = UtilidadesEJB.getBelcorpService();
        RecordSet resultado = new RecordSet();
        String sqlPaginada = UtilidadesPaginacion.armarQueryPaginacion(sql.toString(), dtoE);
        
        try {                                                                  
            resultado = bs.dbService.executePreparedQuery(sqlPaginada, parametros);                                                       
        } catch (Exception e) {                                                
            String codigoError = CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS;      
            UtilidadesLog.error(" buscarCambiosPrecios: Exception",e);       
            throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));
        }
        if (resultado.esVacio()) {
            // GEN-0007 --> 0005                                                                                  
            UtilidadesLog.debug("****buscarCambiosPrecios: No hay datos ");				
            throw new MareException(new Exception(), UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE));           
         }

        UtilidadesLog.info("DAOCambiosEnPrecios.buscarCambiosPrecios(DTOBuscarCambiosPrecios):Salida");
        return resultado;
    }
    
    public RecordSet obtenerEstadosGeneracion(DTOBelcorp dtoE) throws MareException{

        //Documentation
        //Obtenemos los estados contenidos en la tabla EstadosGeneracion (REC) 
         UtilidadesLog.info("DAOCambiosEnPrecios.obtenerEstadosGeneracion(DTOBelcorp):Entrada");
        /*Acceder a la tabla EstadosGeneracion (REC) obtener: 
        - oid 
        - descripcion (internacionalizable) ----> se debe realizar la join con la tabla GEN_I18N_SICC para obtener las descripciones 
        devolver un recordSet con los registros encontrados
        */
        RecordSet resultado = null;
        StringBuffer sql = new StringBuffer();
        Vector parametros = new Vector();
        String codigoError = null;
        
        //SELECT
        sql.append(" SELECT OID_ESTA_GENE as OID,  idio.VAL_I18N as DESCRIPCION  ");
        //FROM
        sql.append(" FROM REC_ESTAD_GENER ,V_GEN_I18N_SICC idio "); 
        //WHERE
        sql.append(" WHERE  idio.VAL_OID = OID_ESTA_GENE "); 
        sql.append(" AND idio.IDIO_OID_IDIO = ? "); 
        parametros.add(dtoE.getOidIdioma());
        sql.append(" AND idio.ATTR_ENTI = 'REC_ESTAD_GENER' ");

        BelcorpService bs = UtilidadesEJB.getBelcorpService();
        try {                                                                  
            resultado = bs.dbService.executePreparedQuery(sql.toString(),      
            parametros);                                                       
        } catch (Exception e) {                                                
            codigoError = CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS;      
            UtilidadesLog.error(" obtenerEstadosGeneracion: Exception",e);   
            throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));
        }
        UtilidadesLog.info("DAOCambiosEnPrecios.obtenerEstadosGeneracion(DTOBelcorp):Entrada");
        return resultado;
    }

    public DTORecuperarCabeGen recuperarCabeceraGeneracion(DTOCargaListas dtoE) throws MareException{

        UtilidadesLog.info("DAOCambiosEnPrecios.recuperarCabeceraGeneracion(DTOCargaListas):Entrada");
        /*Documentation
        Acceder a las entidades CabeceraGeneracionMasiva (REC), DetalleGeneracionMasiva (REC), DetalleOferta (PRE), haciendo join entre ellas. 
        
        Filtrando por: 
        - CabeceraGeneracionMasiva.oid = oid recibido 
        - los de las join: - CabeceraGeneracionMasiv con DetalleGeneracionMasiva 
        - CabeceraGeneracionMasiva con DetalleOferta (a través de OFDE_OID_DETA_OFER_DEST ) //para obtener la descripcionCatalogoDestino 
        - CabeceraGeneracionMasiva con DetalleOferta (a través de OFDE_OID_OFER_DETA ) //para obtener la descripcionCatalogoOrigen 
        Obtener: 
        
        - DetalleOferta.textoBreve //descripcionCatalogoDestino 
        - DetalleOferta.textoBreve // descripcionCatalogoOrigen 
        - DetalleGeneracionMasiva.precioCatalogoOrigen 
        - DetalleGeneracionMasiva.precioCatalogoDestino 
        
        Con los valores obtenidos se crea un objeto del tipo DTORecuperarCabeGen con los siguientes atributos: 
        - descripcionOrigen = DetalleOferta.textoBreve 
        - descripcionDestino = DetalleOferta.textoBreve 
        - precioCatalogoOrigen = DetalleGeneracionMasiva.precioCatalogoOrigen 
        - precioCatalogoOrigen = DetalleGeneracionMasiva.precioCatalogoDestino
        */
        RecordSet resultado = null;
        StringBuffer sql = new StringBuffer();
        Vector parametros = new Vector();
        String codigoError = null;
        
        sql.append(" SELECT od1.val_text_brev DESCCATALOGODESTINO, od2.val_text_brev DESCCATALOGOORIGEN, ");
        sql.append(" dgm.imp_prec_cata_orig PRECIOCATALOGOORIGEN, dgm.imp_prec_cata_dest PRECIOCATALOGODESTINO ");
        sql.append(" FROM REC_CABEC_GENER_MASIV cgm, REC_DETAL_GENER_MASIV dgm, PRE_OFERT_DETAL od1, PRE_OFERT_DETAL od2 ");
        sql.append(" WHERE  cgm.oid_cabe_gene_masi = dgm.cagm_oid_cabe_gene_masi ");
        sql.append(" AND cgm.ofde_oid_deta_ofer_dest = od1.oid_deta_ofer ");
        sql.append(" AND cgm.ofde_oid_ofer_deta = od2.oid_deta_ofer ");
        sql.append(" AND cgm.oid_cabe_gene_masi = ? ");
        parametros.add(dtoE.getOidCabecera());

        BelcorpService bs = UtilidadesEJB.getBelcorpService();
        try {                                                                  
            resultado = bs.dbService.executePreparedQuery(sql.toString(),parametros); 
                                                      
        } catch (Exception e) {                                                
            codigoError = CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS;      
            UtilidadesLog.error(" recuperarCabeceraGeneracion: Exception",e);
            throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));
        }
        
        DTORecuperarCabeGen salida = new DTORecuperarCabeGen();

        if(!resultado.esVacio()){
            /*Con los valores obtenidos se crea un objeto del tipo DTORecuperarCabeGen con los siguientes atributos: 
            - descripcionOrigen = DetalleOferta.textoBreve 
            - descripcionDestino = DetalleOferta.textoBreve 
            - precioCatalogoOrigen = DetalleGeneracionMasiva.precioCatalogoOrigen 
            - precioCatalogoOrigen = DetalleGeneracionMasiva.precioCatalogoDestino
            */
            if(resultado.getValueAt(0,"DESCCATALOGOORIGEN") != null)
                salida.setDescripcionOrigen(resultado.getValueAt(0,"DESCCATALOGOORIGEN").toString());
            if(resultado.getValueAt(0,"DESCCATALOGODESTINO") != null)
                salida.setDescripcionDestino(resultado.getValueAt(0,"DESCCATALOGODESTINO").toString());
            if(resultado.getValueAt(0, "PRECIOCATALOGOORIGEN") != null)
                salida.setPrecioCatalogoOrigen((BigDecimal)resultado.getValueAt(0, "PRECIOCATALOGOORIGEN"));
            if(resultado.getValueAt(0,"PRECIOCATALOGODESTINO") != null)
                salida.setPrecioCatalogoDestino((BigDecimal)resultado.getValueAt(0,"PRECIOCATALOGODESTINO"));
        }

        UtilidadesLog.info("DAOCambiosEnPrecios.recuperarCabeceraGeneracion(DTOCargaListas):Salida");
        return salida;
    }

    // cambia la select por BELC300019830, ver tambien BELC300016257
    // BELC300020247
    // BELC300020340
    public RecordSet recuperarDetalleGeneracion(DTOCargaListas dtoE) throws MareException{

        UtilidadesLog.info("DAOCambiosEnPrecios.recuperarDetalleGeneracion(DTOCargaListas):Entrada");
        /*Acceder a las tablas: DetalleGeneracionMasiva (REC), Cliente (MAE), DetalleOferta (PRE),
          DetalleOferta (PRE), SolicitudPosicion (PED), SolicitudCabecera (PED)
          haciendo join entre ellas 
        
        filtrando por: 
        - DetalleGeneracionMasiva.oidCabeceraGeneracionMasiva = dto.oidCabecera 
        - DetalleGeneracionMasiva.indicativoSeleccion = dto.indicador 
        
        - Las join: 
        - DetalleGeneracionMasiva con Cliente 
        - DetalleGeneracionMasiva con CabeceraGeneracionMasiva
        - DetalleGeneracionMasiva con SolicitudCabecera
        - SolicitudCabecera con SolicitudPosicion
        - CabeceraGeneracionMasiva con DetalleOferta (a través de OFDE_OID_OFER_DETA )
        - SolicitudPosicion con DetalleOferta ( a través de VAL_CODI_VENT )
        
        obtener: 
        - DetalleGeneracionMasiva.oidSolicitudCabecera 
        - DetalleGeneracionMasiva.oidCliente 
        - Cliente.codCliente 
        - Cliente.nombre1 
        - Cliente.nombre2 
        - Cliente.apellido1 
        - Cliente.apellido2 
        - DetalleGeneracionMasiva.numUnidades 
        - DetalleGeneracionMasiva.precioCatalogoOrigen 
        - DetalleGeneracionMasiva.importeNetoOrigen 
        - SolicitudPosicion.importeDescuentoTotalLocal //de la join a través de OFDE_OID_OFER_DETA 
        - DetalleGeneracionMasiva.precioCatalogoDestino 
        - DetalleGeneracionMasiva.importeNetoDestino 
        - DetalleGeneracionMasiva.importeDiferencia 
        - DetalleGeneracionMasiva.oidTipoSolicitud 
        
        Devolver un RecordSet del los registros obtenidos con los siguientes campos: 
        - oidSoliCabe = DetalleGeneracionMasiva.oidSolicitudCabecera 
        - oidCliente = DetalleGeneracionMasiva.oidCliente 
        - codCliente = Cliente.codCliente 
        - nombre1 = Cliente.nombre1 
        - nombre2 = Cliente.nombre2 
        - apellido1 = Cliente.apellido1 
        - apellido2 = ClienteApellido2 
        - numeroUnidades = DetalleGeneracionMasiva.numUnidades 
        - precioCatalogoOrigen = DetalleGeneracionMasiva.precioCatalogoOrigen 
        - importeNetoOrigen = DetalleGeneracionMasiva.importeNetoOrigen 
        - descuentoOrigen = SolicitudPosicion.importeDescuentoTotalLocal 
        - precioCatalogoDestino = DetalleGeneracionMasiva.precioCatalogoDestino 
        - importeNetoDestino = DetalleGeneracionMasiva.importeNetoDestino 
        - importeDiferencia = DetalleGeneracionMasiva.importeDiferencia 
        - oidTipoSolicitud = DetalleGeneracionMasiva.oidTipoSolicitud 
        */
        RecordSet resultado = null;
        StringBuffer sql = new StringBuffer();
        Vector parametros = new Vector();
        String codigoError = null;
		
        sql.append(" SELECT dgm.oid_deta_gene_masi OID, ");
        sql.append(" dgm.soca_oid_soli_cabe OIDSOLICABE, ");
		sql.append(" dgm.clie_oid_clie OIDCLIENTE, c.cod_clie CODCLIENTE, c.val_nom1 NOMBRE1, ");
		sql.append(" c.val_nom2 NOMBRE2, c.val_ape1 APELLIDO1, c.val_ape2 APELLIDO2, ");
		sql.append(" dgm.num_unid NUMEROUNIDADES, dgm.imp_prec_cata_orig PRECIOCATALOGOORIGEN, ");
		sql.append(" dgm.imp_neto_orig IMPORTENETOORIGEN, SUM(sp.val_impo_desc_unit_loca) DESCUENTOORIGEN, ");
		sql.append(" dgm.imp_prec_cata_dest PRECIOCATALOGODESTINO, dgm.imp_neto_dest IMPORTENETODESTINO, ");
		sql.append(" dgm.imp_dife IMPORTEDIFERENCIA, dgm.tspa_oid_tipo_soli_pais OIDTIPOSOLICITUD ");
        //sql.append(" sp.OID_SOLI_POSI, dgm.OID_DETA_GENE_MASI "); // BELC300019647 ---- ELIMINADO POR REC-024
		
		sql.append(" FROM ");
        
        sql.append(" REC_CABEC_GENER_MASIV cgm, REC_DETAL_GENER_MASIV dgm, ");
		sql.append(" PRE_OFERT_DETAL od, MAE_CLIEN c, ");
		sql.append(" PED_SOLIC_CABEC cons, PED_SOLIC_CABEC sc, PED_SOLIC_POSIC sp ");
        
		sql.append(" WHERE ");
		
        sql.append(" dgm.CLIE_OID_CLIE = c.OID_CLIE ");
		sql.append(" AND dgm.CAGM_OID_CABE_GENE_MASI = cgm.OID_CABE_GENE_MASI ");
		sql.append(" AND dgm.SOCA_OID_SOLI_CABE = cons.OID_SOLI_CABE ");
		sql.append(" AND sc.SOCA_OID_SOLI_CABE = cons.OID_SOLI_CABE ");
		sql.append(" AND sp.SOCA_OID_SOLI_CABE = sc.OID_SOLI_CABE ");
		sql.append(" AND cgm.OFDE_OID_OFER_DETA = od.OID_DETA_OFER ");
		sql.append(" AND sp.VAL_CODI_VENT = od.VAL_CODI_VENT ");
	
        sql.append(" AND cgm.OID_CABE_GENE_MASI = ? ");
        parametros.add(dtoE.getOidCabecera());
		if (dtoE.getIndicador() != null) {
            sql.append(" AND dgm.IND_SELE = ? ");
            parametros.add(dtoE.getIndicador());
        }
        
        sql.append(" GROUP BY dgm.oid_deta_gene_masi, dgm.soca_oid_soli_cabe, ");
        sql.append(" dgm.clie_oid_clie, c.cod_clie, c.val_nom1, c.val_nom2, ");
        sql.append(" c.val_ape1, c.val_ape2, dgm.num_unid, dgm.imp_prec_cata_orig, ");
        sql.append(" dgm.imp_neto_orig, dgm.imp_prec_cata_dest, dgm.imp_neto_dest, ");
        sql.append(" dgm.imp_dife, dgm.tspa_oid_tipo_soli_pais ");
		sql.append(" ORDER BY dgm.OID_DETA_GENE_MASI");        
               
        BelcorpService bs = UtilidadesEJB.getBelcorpService();
        String sqlPaginada = UtilidadesPaginacion.armarQueryPaginacion(sql.toString(), dtoE);
        
        try {                                                                  
            resultado = bs.dbService.executePreparedQuery(sqlPaginada, parametros);                                                               
        } catch (Exception e) {                                                
            codigoError = CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS;      
            UtilidadesLog.error(" recuperarDetalleGeneracion: Exception",e);                                                    
            throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));
        }
        
        UtilidadesLog.info("DAOCambiosEnPrecios.recuperarDetalleGeneracion(DTOCargaListas):Salida");
        return resultado;
    }

    /**
     * Modificado: Cristian Valenzuela
     * Fecha:      29/06/2006
     * Incidencia: BELC300022743
     */
     
    // modificado por incidencia BELC300019898
    public ArrayList obtenerListaGeneracion(Long oidCabecera) throws MareException{        
        UtilidadesLog.info("DAOCambiosEnPrecios.obtenerListaGeneracion(Long oidCabecera):Entrada");
        //modificado por incidencia 16032
        RecordSet resultado = null;
        StringBuffer sql = new StringBuffer();
        Vector parametros = new Vector();
        String codigoError = null;
        BigDecimal bigBuffer = null;

        /* Modificacion por ssantana, 19/07/2006, inc. BELC300023578 
         * Se quita recuperacion de Oid Periodo Reclamo y se añade retorno de 
         * Pais, Marca y Canal del Periodo */ 
        sql.append("SELECT DISTINCT p1.fec_inic, p1.fec_fina,  ");
        sql.append("       dgm.soca_oid_soli_cabe OIDSOLICABE,  ");
        sql.append("       dgm.clie_oid_clie OIDCLIENTE, "); 
        sql.append("       dgm.imp_neto_orig IMPORTENETOORIGEN,  ");
        sql.append("       dgm.imp_neto_dest IMPORTENETODESTINO, ");
        sql.append("       dgm.imp_dife IMPORTEDIFERENCIA,  ");
        sql.append("       dgm.tspa_oid_tipo_soli_pais OIDTIPOSOLICITUD, ");
        sql.append("       OD1.TOFE_OID_TIPO_OFER OIDTIPOOFERTADESTINO,   ");
        sql.append("       OD2.TOFE_OID_TIPO_OFER OIDTIPOOFERTA, ");
        sql.append("       dgm.num_unid NUMEROUNIDADES,   ");
        sql.append("       sc.ticl_oid_tipo_clie OIDTIPOCLIENTE, ");
        sql.append("       sc.sbti_oid_subt_clie OIDSUBTIPOCLIENTE, ");  
        
        // gPineda - 28/02/2007 - SiCC 20070071
        //sql.append("       sc.sctdoc_oid_tipo_docu OIDTIPODOCUMENTO, ");
        sql.append("       tdoc.TIDO_OID_TIPO_DOCU OIDTIPODOCUMENTO, ");
        
        sql.append("       sc.perd_oid_peri OIDPERIODO,   ");
        sql.append("       top.oid_tipo_oper OIDTIPOOPERACION, ");
        /* sql.append("p2.oid_peri OIDPERIODORECLAMO,  cua.ztad_oid_terr_admi OIDTERRITORIOADMINISTRATIVO, "); */
        sql.append("       cua.ztad_oid_terr_admi OIDTERRITORIOADMINISTRATIVO, ");
        sql.append("       od1.PROD_OID_PROD OIDPRODUCTODESTINO,  ");
        sql.append("       od2.PROD_OID_PROD OIDPRODUCTOORIGEN, "); // BELC300020144
        
        //Agregado por Cristian Valenzuela - 29/06/2006
        sql.append("   sc.FEC_CRON, MF1.OID_MATR_FACT oidMFOrigen, MF2.OID_MATR_FACT oidMFDestino, ");        
        //Fin - Agregado por Cristian Valenzuela - 29/06/2006
        
        sql.append(" p1.marc_oid_marc, p1.cana_oid_cana, p1.pais_oid_pais, "); 
        /* Fin Modificacion por ssantana, 19/07/2006, inc. BELC300023578 
         * Se quita recuperacion de Oid Periodo Reclamo y se añade retorno de 
         * Pais, Marca y Canal del Periodo */ 
      /*  sql.append("  SP.OID_SOLI_POSI ");eliminado REC-15*/ 
      	
        sql.append(" dgm.IMP_PREC_CATA_DEST, ");
		sql.append(" dgm.IMP_PREC_CATA_ORIG ");

    	sql.append("FROM REC_CABEC_GENER_MASIV cgm, REC_DETAL_GENER_MASIV dgm,  REC_OPERA op, CRA_PERIO p1, ");
        sql.append("CRA_PERIO p2,  MAE_CLIEN_UNIDA_ADMIN cua, PED_SOLIC_CABEC sc, ");
        sql.append("REC_TIPOS_OPERA top,  PRE_OFERT_DETAL od1, PRE_OFERT_DETAL od2, ");
        //Agregado por Cristian Valenzuela - 29/06/2006
        sql.append("PRE_MATRI_FACTU MF1, PRE_MATRI_FACTU MF2 ");
        //Fin - Agregado por Cristian Valenzuela - 29/06/2006
        /*sql.append(" PED_SOLIC_CABEC sc2, ");
        sql.append(" PED_SOLIC_POSIC sp "); eliminado REC-15 */
        
        // gPineda - 28/02/2007 - SiCC 20070071
        sql.append(" ,mae_tipo_docum tdoc ");
        
        sql.append("WHERE dgm.CAGM_OID_CABE_GENE_MASI = cgm.OID_CABE_GENE_MASI ");
        sql.append("AND dgm.SOCA_OID_SOLI_CABE = sc.SOCA_OID_SOLI_CABE "); 
        sql.append("AND cgm.TIOP_OID_TIPO_OPER = top.OID_TIPO_OPER "); //incidencia 16012
        sql.append("AND top.ROPE_OID_OPER = op.OID_OPER ");
        sql.append("AND sc.PERD_OID_PERI = p2.OID_PERI ");
        sql.append("AND cua.PERD_OID_PERI_INI = p1.OID_PERI ");

// Modificacion por error en join - sbonanno - 11/08/06 - INICO
//        sql.append("AND cgm.OFDE_OID_DETA_OFER_DEST = od1.OID_DETA_OFER ");
//        sql.append("AND cgm.OFDE_OID_OFER_DETA = od2.OID_DETA_OFER ");
        sql.append("AND cgm.OFDE_OID_DETA_OFER_DEST = od2.OID_DETA_OFER ");
        sql.append("AND cgm.OFDE_OID_OFER_DETA = od1.OID_DETA_OFER ");
// Modificacion por error en join - sbonanno - 11/08/06 - FIN

        sql.append("AND cua.CLIE_OID_CLIE = sc.CLIE_OID_CLIE "); // me lo confirmaron por correo. Se reflejara en proximo DT
    
        sql.append("AND p1.PAIS_OID_PAIS = p2.PAIS_OID_PAIS "); 
        sql.append("AND p1.MARC_OID_MARC = p2.MARC_OID_MARC "); 
        sql.append("AND p1.CANA_OID_CANA = p2.CANA_OID_CANA "); 
        
        /*sql.append("AND p1.FEC_INIC <= trunc(sysdate)  AND  p1.FEC_FINA >= trunc(sysdate) ");  */  /*Incindencia DBLG400001023 pperez */
        sql.append("AND cgm.OID_CABE_GENE_MASI = ? ");
        parametros.add(oidCabecera);
        sql.append("AND cgm.ESGN_OID_ESTA_GENE = ? "); // BELC300019898
        parametros.add(ConstantesREC.ESTADO_GENERACION_PROVISIONAL);
        sql.append("AND cua.IND_ACTI = 1 ");
        sql.append("AND dgm.IND_SELE = 1 "); // BELC300019898    
        //Agregado por Cristian Valenzuela - 29/06/2006
        sql.append("AND MF1.OFDE_OID_DETA_OFER = od1.OID_DETA_OFER ");
        sql.append("AND MF2.OFDE_OID_DETA_OFER = od2.OID_DETA_OFER ");
        
        // gPineda - 28/02/2007 - SiCC 20070071
        sql.append("AND sc.TDOC_OID_TIPO_DOCU = tdoc.OID_TIPO_DOCU ");
        //Fin - Agregado por Cristian Valenzuela - 29/06/2006
        /*sql.append("AND od1.OID_DETA_OFER = SP.OFDE_OID_DETA_OFER ");
        sql.append("AND SP.SOCA_OID_SOLI_CABE = SC2.OID_SOLI_CABE ");
        sql.append("AND SC2.SOCA_OID_SOLI_CABE = SC.OID_SOLI_CABE ");eliminado REC-15*/
        BelcorpService bs = UtilidadesEJB.getBelcorpService();
        
        try {                                                                  
            resultado = bs.dbService.executePreparedQuery(sql.toString(),      
            parametros);                                                       
        }
        catch (Exception e) {                                                
            codigoError = CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS;      
            UtilidadesLog.error(" obtenerListaGeneracion: Exception",e);
            throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));
        }
        
        ArrayList salida = new ArrayList();
        DTOLista dto = null;
        
        if(!resultado.esVacio()){
            for(int i=0;i<resultado.getRowCount();i++){
                dto = new DTOLista();

                if(resultado.getValueAt(i,"OIDSOLICABE") != null)
                    dto.setOidSoliCabe(new Long(((BigDecimal)resultado.getValueAt(i,"OIDSOLICABE")).longValue()) );
                if(resultado.getValueAt(i,"OIDCLIENTE") != null)
                    dto.setOidCliente(new Long(((BigDecimal)resultado.getValueAt(i,"OIDCLIENTE")).longValue()) );
                if(resultado.getValueAt(i,"IMPORTENETOORIGEN") != null)
                    dto.setImporteNetoOrigen((BigDecimal)resultado.getValueAt(i,"IMPORTENETOORIGEN"));
                if(resultado.getValueAt(i,"IMPORTENETODESTINO") != null)
                    dto.setImporteNetoDestino((BigDecimal)resultado.getValueAt(i,"IMPORTENETODESTINO"));
                if(resultado.getValueAt(i,"IMPORTEDIFERENCIA") != null)
                    dto.setImporteDiferencia((BigDecimal)resultado.getValueAt(i,"IMPORTEDIFERENCIA"));
                if(resultado.getValueAt(i,"OIDTIPOSOLICITUD") != null)
                    dto.setOidTipoSolicitudPais(new Long(((BigDecimal)resultado.getValueAt(i,"OIDTIPOSOLICITUD")).longValue()) );
                if(resultado.getValueAt(i,"OIDTIPOOFERTADESTINO") != null)
                    dto.setOidTipoOferaDestino(new Long(((BigDecimal)resultado.getValueAt(i,"OIDTIPOOFERTADESTINO")).longValue()) );
                if(resultado.getValueAt(i,"OIDTIPOOFERTA") != null)
                    dto.setOidTipoOferta(new Long(((BigDecimal)resultado.getValueAt(i,"OIDTIPOOFERTA")).longValue()) );
                if(resultado.getValueAt(i,"NUMEROUNIDADES") != null)
                    dto.setNumeroUnidades(new Integer(((BigDecimal)resultado.getValueAt(i,"NUMEROUNIDADES")).intValue()) );
                if(resultado.getValueAt(i,"OIDTIPOCLIENTE") != null)
                    dto.setOidTipoCliente(new Long(((BigDecimal)resultado.getValueAt(i,"OIDTIPOCLIENTE")).longValue()) );
                if(resultado.getValueAt(i,"OIDSUBTIPOCLIENTE") != null)
                    dto.setOidSubTipoCliente(new Long(((BigDecimal)resultado.getValueAt(i,"OIDSUBTIPOCLIENTE")).longValue()) );  
                if(resultado.getValueAt(i,"OIDTIPODOCUMENTO") != null)
                    dto.setOidTipoDocumento(new Long(((BigDecimal)resultado.getValueAt(i,"OIDTIPODOCUMENTO")).longValue()) ); 
                if(resultado.getValueAt(i,"OIDPERIODO") != null)
                    dto.setOidPeriodo(new Long(((BigDecimal)resultado.getValueAt(i,"OIDPERIODO")).longValue()) ); 
                if(resultado.getValueAt(i,"OIDTIPOOPERACION") != null)
                    dto.setOidTipoOperacion(new Long(((BigDecimal)resultado.getValueAt(i,"OIDTIPOOPERACION")).longValue()) ); 
                    
                /* Modificacion por ssantana, 19/07/2006, inc. inc. BELC300023578  */
                /*if(resultado.getValueAt(i,"OIDPERIODORECLAMO") != null)
                    dto.setOidPeriodoReclamo(new Long(((BigDecimal)resultado.getValueAt(i,"OIDPERIODORECLAMO")).longValue()) ); */
                bigBuffer = (BigDecimal) resultado.getValueAt(i, "MARC_OID_MARC");
                dto.setOidMarca( Long.valueOf(bigBuffer.toString()) );
                
                bigBuffer = (BigDecimal) resultado.getValueAt(i, "CANA_OID_CANA");
                dto.setOidCanal( Long.valueOf(bigBuffer.toString()) );
                
                bigBuffer = (BigDecimal) resultado.getValueAt(i, "PAIS_OID_PAIS");
                dto.setOidPais( Long.valueOf(bigBuffer.toString()) );
                /* Fin Modificacion  por ssantana, 19/07/2006, inc. inc. BELC300023578  */
                
                if(resultado.getValueAt(i,"OIDTERRITORIOADMINISTRATIVO") != null)
                    dto.setOidTerritorioAdministrativo(new Long(((BigDecimal)resultado.getValueAt(i,"OIDTERRITORIOADMINISTRATIVO")).longValue()) );                
                // BELC300020144
                if(resultado.getValueAt(i, "OIDPRODUCTOORIGEN") != null)
                    dto.setOidProductoOrigen(new Long(((BigDecimal)resultado.getValueAt(i, "OIDPRODUCTOORIGEN")).longValue()));
                // BELC300020144
                if(resultado.getValueAt(i, "OIDPRODUCTODESTINO") != null)
                    dto.setOidProductoDestino(new Long(((BigDecimal)resultado.getValueAt(i, "OIDPRODUCTODESTINO")).longValue()));                
                
                //Agregado por Cristian Valenzuela - 29/06/2006
                if(resultado.getValueAt(i, "FEC_CRON") != null)
                    dto.setFechaDocumentoReferencia((Date)resultado.getValueAt(i, "FEC_CRON"));
                if(resultado.getValueAt(i, "OIDMFORIGEN") !=null)
                    dto.setOidMFOrigen(new Long(((BigDecimal)resultado.getValueAt(i, "OIDMFORIGEN")).longValue()));
                if(resultado.getValueAt(i, "OIDMFDESTINO") !=null)            
                    dto.setOidMFDestino(new Long(((BigDecimal)resultado.getValueAt(i, "OIDMFDESTINO")).longValue()));                    
                //Fin - Agregado por Cristian Valenzuela - 29/06/2006
            /*    if(resultado.getValueAt(i, "OID_SOLI_POSI") !=null)            
                   dto.setOidPosicionReferencia(new Long(((BigDecimal)resultado.getValueAt(i, "OID_SOLI_POSI")).longValue()));
              */
              if(resultado.getValueAt(i, "IMP_PREC_CATA_DEST") !=null){
                    dto.setImporteCatalogoDestino((BigDecimal)resultado.getValueAt(i, "IMP_PREC_CATA_DEST"));                    
              }   
              if(resultado.getValueAt(i, "IMP_PREC_CATA_ORIG") !=null){            
                    dto.setImporteCatalogoOrigen(((BigDecimal)resultado.getValueAt(i, "IMP_PREC_CATA_ORIG")));                    		         
              }
                salida.add(dto);
            }
        }

        UtilidadesLog.info("DAOCambiosEnPrecios.obtenerListaGeneracion(Long):Salida");
        return salida;
    }
}