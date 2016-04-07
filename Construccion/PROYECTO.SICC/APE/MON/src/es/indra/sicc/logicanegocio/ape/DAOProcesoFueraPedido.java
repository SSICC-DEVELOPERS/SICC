/**
 * Copyright 2007 © por Indra Sistemas,S.A.. Todos los derechos reservados.
 * Avda. de Bruselas, 35
 * Parque Empresarial Arroyo de la Vega
 * 28108 Alcobendas, Madrid
 * España
 *
 * Privado y Confidencial.
 * La información contenida en este documento es propiedad de Indra sistemas.
 * Para uso exclusivo de empleados autorizados no permitiéndose
 * la distribución de este código sin permiso expreso.
 * 
 */

package es.indra.sicc.logicanegocio.ape;

import es.indra.sicc.util.UtilidadesLog;
import es.indra.mare.common.exception.MareException;
import es.indra.mare.common.mii.services.jdbcservice.RecordSet;
import java.util.ArrayList;
import es.indra.sicc.util.BelcorpService;
import es.indra.sicc.util.UtilidadesEJB;
import es.indra.sicc.dtos.ape.DTOConfListaAFP;
import es.indra.sicc.dtos.ape.DTOListaPicadoDetalle;
import es.indra.sicc.dtos.ape.DTOListaPicadoCabecera;
import es.indra.sicc.dtos.ape.DTOLineaArmado;
import java.math.BigDecimal;
import java.sql.Date;
import java.sql.Timestamp;
import es.indra.sicc.util.CodigosError;
import es.indra.sicc.util.UtilidadesError;
import java.util.HashMap;
import java.util.Iterator;
import javax.ejb.DuplicateKeyException;
import java.text.SimpleDateFormat;

public class DAOProcesoFueraPedido  {

    /**
     * 
     * @author scsaavedra
     * @since 09-04-2007
     * 
     * Notas
     * @CHANGELOG 
     * 2007.04.11 MAMONTIEL DT . La entidad ConfiguracionListaAFP fue separada en ConfiguracionListaAFPCabecera y ConfiguracionListaAFPDetalle (BELC400000402) 
     */
    public ArrayList obtenerAgrupacionesPorConsolidado(Long oidConsolidado) throws MareException {
        UtilidadesLog.info("DAOProcesoFueraPedido.obtenerAgrupacionesPorConsolidado(Long oidConsolidado): Entrada");
        
        BelcorpService bs = UtilidadesEJB.getBelcorpService();
        StringBuffer query = new StringBuffer();
        ArrayList lstRetorno = new ArrayList();
        
		// dmorello, 22/02/2008
        // Se reescribe por completo la query
        /*		query.append("SELECT DISTINCT confCabecera.OID_CONF_LAFP_CABE OID, "); 
        query.append("confCabecera.NUM_AGRU AGRUP, ");
				query.append("zona.ZORG_OID_REGI REGION, ");
        query.append("seccion.ZZON_OID_ZONA ZONA, ");
        query.append("terriAdm.ZSCC_OID_SECC SECC ");
        query.append("FROM APE_CONFI_LIAFP_CABEC confCabecera , ");
        query.append("APE_CONFI_LIAFP_DETAL confDetalle , ");
        query.append("PED_SOLIC_CABEC consolidado, ");
        query.append("ZON_TERRI_ADMIN terriAdm, ");
        query.append("ZON_SECCI seccion, ");
        query.append("ZON_ZONA zona ");
        query.append("WHERE consolidado.OID_SOLI_CABE = " + oidConsolidado.longValue());
        query.append(" AND consolidado.ZTAD_OID_TERR_ADMI = terriAdm.OID_TERR_ADMI ");
        query.append("AND terriAdm.ZSCC_OID_SECC = seccion.OID_SECC ");
        query.append("AND seccion.ZZON_OID_ZONA = zona.OID_ZONA ");
        query.append("AND confDetalle.ZORG_OID_REGI = zona.ZORG_OID_REGI ");
        query.append("AND ((confDetalle.ZZON_OID_ZONA = NULL) OR (confDetalle.ZZON_OID_ZONA = seccion.ZZON_OID_ZONA)) ");
        query.append("AND ((confDetalle.ZSCC_OID_SECC = NULL) OR (confDetalle.ZSCC_OID_SECC = terriAdm.ZSCC_OID_SECC)) ");
        query.append("AND confCabecera.OID_CONF_LAFP_CABE = confDetalle.LIAC_OID_CONF_LAFP_CABE ");
        query.append("ORDER BY region, zona, secc DESC");*/
        query.append("SELECT agrupaciones.oid_conf_lafp_cabe AS oid");
        query.append("     , agrupaciones.num_agru AS agrup");
        query.append("     , agrupaciones.zorg_oid_regi AS region");
        query.append("     , agrupaciones.zzon_oid_zona AS zona");
        query.append("     , agrupaciones.zscc_oid_secc AS secc");
        query.append("    FROM (SELECT cab.oid_conf_lafp_cabe");
        query.append("               , cab.num_agru");
        query.append("               , det.zorg_oid_regi");
        query.append("               , det.zzon_oid_zona");
        query.append("               , det.zscc_oid_secc");
        query.append("            FROM ape_confi_liafp_cabec cab");
        query.append("               , ape_confi_liafp_detal det");
        query.append("           WHERE det.liac_oid_conf_lafp_cabe = cab.oid_conf_lafp_cabe");
        query.append("         ) agrupaciones");
        query.append("       , (SELECT zona.zorg_oid_regi");
        query.append("               , cons.zzon_oid_zona");
        query.append("               , tad.zscc_oid_secc");
        query.append("            FROM ped_solic_cabec cons");
        query.append("               , zon_zona zona");
        query.append("               , zon_terri_admin tad");
        query.append("           WHERE cons.oid_soli_cabe = ").append(oidConsolidado);
        query.append("             AND cons.ztad_oid_terr_admi = tad.oid_terr_admi");
        query.append("             AND cons.zzon_oid_zona = zona.oid_zona) datoscons");
        query.append("   WHERE datoscons.zorg_oid_regi = agrupaciones.zorg_oid_regi");
        query.append("     AND ((datoscons.zzon_oid_zona = agrupaciones.zzon_oid_zona) OR (agrupaciones.zzon_oid_zona IS NULL))");
        query.append("     AND ((datoscons.zscc_oid_secc = agrupaciones.zscc_oid_secc) OR (agrupaciones.zscc_oid_secc IS NULL))");
        query.append("ORDER BY zona NULLS LAST");
        query.append("       , secc NULLS LAST");
        // Fin dmorello 22/02/2008
        RecordSet rs = null;
        UtilidadesLog.debug("query, : " + query.toString());
        try {
            rs = bs.dbService.executeStaticQuery(query.toString());
        } catch (Exception e) {
            UtilidadesLog.debug("error consulta: obtenerAgrupacionesPorConsolidado:: " + e);
        }
        
        UtilidadesLog.debug("rs: " + rs);
        if ((rs==null) || (rs.getRowCount()<=0)) {
            UtilidadesLog.debug("consulta: obtenerAgrupacionesPorConsolidado sin datos");      
        }else{
            int cant = rs.getRowCount(); 
            DTOConfListaAFP dtoConfListaAFP = null;
            for(int i=0; i<cant; i++){   
                dtoConfListaAFP = new DTOConfListaAFP();
                dtoConfListaAFP.setOidConfListaAFP(Long.valueOf(((BigDecimal)rs.getValueAt(i,"OID")).toString()));
                dtoConfListaAFP.setAgrupacion(Long.valueOf(((BigDecimal)rs.getValueAt(i,"AGRUP")).toString()));
                dtoConfListaAFP.setOidRegion(Long.valueOf(((BigDecimal)rs.getValueAt(i,"REGION")).toString()));
                // dmorello, 29/02/2008: Se considerará el caso de zona o sección nula
                //dtoConfListaAFP.setOidZona(Long.valueOf(((BigDecimal)rs.getValueAt(i,"ZONA")).toString()));
                //dtoConfListaAFP.setOidSeccion(Long.valueOf(((BigDecimal)rs.getValueAt(i,"SECC")).toString()));
                if (rs.getValueAt(i, "ZONA") != null) {
                    dtoConfListaAFP.setOidZona( new Long( ((BigDecimal)rs.getValueAt(i,"ZONA")).longValue() ) );
                }
                if (rs.getValueAt(i, "SECC") != null) {
                    dtoConfListaAFP.setOidSeccion( new Long( ((BigDecimal)rs.getValueAt(i,"SECC")).longValue() ) );
                }
                // Fin dmorello 29/02/2008
                lstRetorno.add(dtoConfListaAFP);
            }
        }         
        UtilidadesLog.info("DAOProcesoFueraPedido.obtenerAgrupacionesPorConsolidado(Long oidConsolidado): Salida");
        return lstRetorno;
    }    

    /**
     * 
     * @author scsaavedra
     * @since 09-04-2007
     * 
     * Modificaciones:
     * - BELC400000721 - dmorello, 06/09/2007:
     *   Deja de devolver Long, pasa a devolver un RecordSet [oidLista, numUnidaTota]
     */
    public RecordSet comprobarListaPicado(Long oidConsolidado, Long oidConfiguracionCD, Long oidAgrupacion, String codAgrupacionDefault) throws MareException {
        UtilidadesLog.info("DAOProcesoFueraPedido.comprobarListaPicado (Long oidConsolidado, Long oidConfiguracionCD, Long oidAgrupacion, String codAgrupacionDefault): Entrada");
        
        BelcorpService bs = UtilidadesEJB.getBelcorpService();
        StringBuffer query = new StringBuffer();
        ArrayList lstRetorno = new ArrayList();
        
				query.append("SELECT lstPicadoCab.OID_LIST_PICA_CABE "); 
        query.append("     , lstPicadoCab.NUM_UNID_TOTA ");      // BELC400000721 - dmorello, 06/09/2007/
        query.append("FROM APE_LISTA_PICAD_CABEC lstPicadoCab, ");
        query.append("PED_SOLIC_CABEC consolidado, ");
        query.append("ZON_TERRI_ADMIN terriAdm, ");
        query.append("ZON_SECCI seccion, ");
        query.append("ZON_ZONA zona ");
        query.append("WHERE consolidado.OID_SOLI_CABE = " + oidConsolidado.longValue());
        query.append(" AND consolidado.ZTAD_OID_TERR_ADMI = terriAdm.OID_TERR_ADMI ");
        query.append("AND terriAdm.ZSCC_OID_SECC = seccion.OID_SECC ");
        query.append("AND seccion.ZZON_OID_ZONA = zona.OID_ZONA ");
        query.append("AND lstPicadoCab.PERD_OID_PERI = consolidado.PERD_OID_PERI ");
        query.append("AND lstPicadoCab.CCDI_OID_CONF_CENT_DIST = " + oidConfiguracionCD.longValue());
        query.append(" AND lstPicadoCab.FEC_FACTU = consolidado.FEC_FACT ");
        
        if (oidAgrupacion!=null) {
             query.append("AND lstPicadoCab.LIAC_OID_CONF_LAFP_CABE = " + oidAgrupacion.longValue()); //Inc. BELC400000382 Script: BELCORP_04_0047  
        } else { // Inc. BELC400000629
            if (codAgrupacionDefault!=null) {
                // Inc. BELC400000629
                query.append(" AND lstPicadoCab.SOCA_OID_SOLI_CABE IS NULL"); // Es una lista de picado FP
                
                // dmorello, 28/02/2008
                query.append(" AND lstPicadoCab.ZORG_OID_REGI = zona.ZORG_OID_REGI ");
                
                if (codAgrupacionDefault.equals(ConstantesAPE.FUERA_PEDIDO_ZONA)){
                    query.append(" AND lstPicadoCab.ZZON_OID_ZONA = seccion.ZZON_OID_ZONA ");     
                }else if (codAgrupacionDefault.equals(ConstantesAPE.FUERA_PEDIDO_SECCION)){
                    query.append(" AND lstPicadoCab.ZSCC_OID_SECC = terriAdm.ZSCC_OID_SECC ");       
                }
            }
        }
        RecordSet rs = null;
        UtilidadesLog.debug("query, : " + query.toString());
        try {
            rs = bs.dbService.executeStaticQuery(query.toString());
        } catch (Exception e) {
            UtilidadesLog.debug("error consulta: comprobarListaPicado: " + e);
        }
        
        UtilidadesLog.debug("rs: " + rs);
        UtilidadesLog.info("DAOProcesoFueraPedido.comprobarListaPicado (Long oidConsolidado, Long oidConfiguracionCD, Long oidAgrupacion, String codAgrupacionDefault): Salida");
        
        /* BELC400000721 - dmorello, 06/09/2007: Paso a devolver el RecordSet */
        //if ((rs==null) || (rs.getRowCount()<=0)) {
        //    UtilidadesLog.debug("consulta: comprobarListaPicado sin datos");      
        //    return null;
        //}else{
        //    return Long.valueOf(((BigDecimal)rs.getValueAt(0,"OID_LIST_PICA_CABE")).toString());
        //}
        return rs;
    }  
    
    /**
     * 
     * @author scsaavedra
     * @since 09-04-2007
     */
    public ArrayList obtenerListaPicadoDetalles(Long oidCabecera) throws MareException {
        UtilidadesLog.info("DAOProcesoFueraPedido.obtenerListaPicadoDetalles(Long oidCabecera): Entrada");
        
        BelcorpService bs = UtilidadesEJB.getBelcorpService();
        StringBuffer query = new StringBuffer();
        ArrayList lstRetorno = new ArrayList();
        
        query.append("SELECT lstPicadoDet.OID_LIST_PICA_DETA, lstPicadoDet.PROD_OID_PROD, ");
        query.append("lstPicadoDet.MCDD_OID_MAPA_CENT_DIST_DETA, lstPicadoDet.NUM_UNID_PROD ");
        query.append("FROM APE_LISTA_PICAD_DETAL lstPicadoDet ");
        query.append("WHERE lstPicadoDet.LPCA_OID_LIST_PICA_CABE = " + oidCabecera.longValue());
        
        RecordSet rs = null;
        UtilidadesLog.debug("query, : " + query.toString());
        try {
            rs = bs.dbService.executeStaticQuery(query.toString());
        } catch (Exception e) {
            UtilidadesLog.debug("error consulta: obtenerListaPicadoDetalles: " + e);
        }
        
        UtilidadesLog.debug("rs: " + rs);
        if ((rs==null) || (rs.getRowCount()<=0)) {
            UtilidadesLog.debug("consulta: comprobarListaPicado sin datos");      
            UtilidadesLog.info("DAOProcesoFueraPedido.obtenerListaPicadoDetalles(Long oidCabecera): Salida");
            return null;
        }else{
            int cant = rs.getRowCount(); 
            DTOListaPicadoDetalle dtoListaPicadoDetalle = null;
            for(int i=0; i<cant; i++){   
                dtoListaPicadoDetalle = new DTOListaPicadoDetalle();
                dtoListaPicadoDetalle.setOid(Long.valueOf(((BigDecimal)rs.getValueAt(i,"OID_LIST_PICA_DETA")).toString()));
                dtoListaPicadoDetalle.setOidProducto(Long.valueOf(((BigDecimal)rs.getValueAt(i,"PROD_OID_PROD")).toString()));
                dtoListaPicadoDetalle.setOidMapaCDDetalle(Long.valueOf(((BigDecimal)rs.getValueAt(i,"MCDD_OID_MAPA_CENT_DIST_DETA")).toString()));
                dtoListaPicadoDetalle.setUnidadesProducto(Long.valueOf(((BigDecimal)rs.getValueAt(i,"NUM_UNID_PROD")).toString()));
                lstRetorno.add(dtoListaPicadoDetalle);
            }
            UtilidadesLog.info("DAOProcesoFueraPedido.obtenerListaPicadoDetalles(Long oidCabecera): Salida");
            return lstRetorno;
        }
 
    }

    /**
     * 
     * @author scsaavedra
     * @since 09-04-2007
     */
    public String obtenerFueraPedidoDefault(Long oidConfiguracionCD) throws MareException {
        UtilidadesLog.info("DAOProcesoFueraPedido.obtenerFueraPedidoDefault(Long oidConfiguracionCD): Entrada");
        
        BelcorpService bs = UtilidadesEJB.getBelcorpService();
        StringBuffer query = new StringBuffer();
        
        // Eliminado - eiraola 22/08/2007 - Inc. 629 [INICIO]
        //query.append("SELECT confCD.VAL_FUER_PEDI_DEFA ");
        //query.append("FROM APP_CONFI_CENTR_DISTR confCD ");
        //query.append("WHERE confCD.OID_CONF_CENT_DIST = " + oidConfiguracionCD.longValue());
        // Eliminado - eiraola 22/08/2007 - Inc. 629 [FIN]
        
        // Agregado - eiraola 22/08/2007 - Inc. 629 [INICIO]
        query.append("SELECT agrup.COD_AAFP ");
        query.append("  FROM APP_CONFI_CENTR_DISTR confcd, ");
        query.append("       APE_AGRUP_AFP agrup ");
        query.append(" WHERE confcd.oid_conf_cent_dist = " + oidConfiguracionCD);
        query.append("   AND confcd.AAFP_OID_AAFP = agrup.OID_AAFP ");
        // Agregado - eiraola 22/08/2007 - Inc. 629 [FIN]
        
        RecordSet rs = null;
        //UtilidadesLog.debug("query, : " + query.toString());
        try {
            rs = bs.dbService.executeStaticQuery(query.toString());
        } catch (Exception e) {
            UtilidadesLog.debug("error consulta: obtenerFueraPedidoDefault: " + e);
        }
        
        UtilidadesLog.debug("rs: " + rs);
        if ((rs==null) || (rs.getRowCount()<=0)) {
            UtilidadesLog.debug("consulta: obtenerFueraPedidoDefault sin datos");      
            UtilidadesLog.info("DAOProcesoFueraPedido.obtenerFueraPedidoDefault(Long oidConfiguracionCD): Salida");
            return null;
        }else{
            UtilidadesLog.info("DAOProcesoFueraPedido.obtenerFueraPedidoDefault(Long oidConfiguracionCD): Salida");
            //if (rs.getValueAt(0,"VAL_FUER_PEDI_DEFA")!=null){
            //    return rs.getValueAt(0,"VAL_FUER_PEDI_DEFA").toString();
            if (rs.getValueAt(0, "COD_AAFP") != null) {
                return rs.getValueAt(0, "COD_AAFP").toString();
            } else {
                return null;  
            }
        }
 
    }

    /**
     * 
     * @author scsaavedra
     * @since 09-04-2007
     */
    public DTOListaPicadoCabecera obtenerListaPicadoACrear(Long oidConsolidado, Long oidLineaArmado, Long oidCentroDist, 
                                                           Long oidAgrupacion, String codAgrupacionDefault) throws MareException {
        UtilidadesLog.info("DAOProcesoFueraPedido.obtenerListaPicadoACrear(Long oidConsolidado, Long oidLineaArmado, Long oidCentroDist, Long oidAgrupacion, String codAgrupacionDefault): Entrada");
        
        BelcorpService bs = UtilidadesEJB.getBelcorpService();
        StringBuffer query = new StringBuffer();
        
        //Gpons - Inc. 409: Se recupera Region.
        query.append("SELECT zona.ZORG_OID_REGI, SolicitudCabeceraSecuencia.NUM_SECU_ZONA_RUTA, ");
        query.append("SolicitudCabecera.PERD_OID_PERI, ");
        query.append("SolicitudCabecera.FEC_FACT ");
        if (codAgrupacionDefault!=null){
            query.append(",SolicitudCabecera.ZZON_OID_ZONA ");  
            query.append(",terriAdm.ZSCC_OID_SECC ");
        }
        
        query.append("FROM PED_SOLIC_CABEC SolicitudCabecera, ");
        query.append("PED_SOLIC_CABEC_SECUE SolicitudCabeceraSecuencia, ");
        query.append("ZON_ZONA Zona ");
        
        if (codAgrupacionDefault!=null){
            query.append(",ZON_TERRI_ADMIN terriAdm ");
        }
        
        query.append("WHERE SolicitudCabecera.OID_SOLI_CABE = " + oidConsolidado.longValue());
        query.append(" AND SolicitudCabeceraSecuencia.SOCA_OID_SOLI_CABE = " + oidConsolidado.longValue());
        query.append(" AND zona.OID_ZONA = solicitudcabecera.ZZON_OID_ZONA ");        
        if (codAgrupacionDefault!=null){
            //query.append(" AND consolidado.ZTAD_OID_TERR_ADMI = terriAdm.OID_TERR_ADMI ");
            query.append(" AND SolicitudCabecera.ZTAD_OID_TERR_ADMI = terriAdm.OID_TERR_ADMI ");
        }
        
        RecordSet rs = null;
        UtilidadesLog.debug("query, : " + query.toString());
        try {
            rs = bs.dbService.executeStaticQuery(query.toString());
        } catch (Exception e) {
            UtilidadesLog.debug("error consulta: obtenerListaPicadoACrear: " + e);
        }
        
        UtilidadesLog.debug("rs: " + rs);
        if ((rs==null) || (rs.getRowCount()<=0)) {
            UtilidadesLog.debug("consulta: obtenerListaPicadoACrear sin datos");      
            UtilidadesLog.info("DAOProcesoFueraPedido.obtenerListaPicadoACrear(Long oidConsolidado, Long oidLineaArmado, Long oidCentroDist, Long oidAgrupacion, String codAgrupacionDefault): Salida");
            return null;
        }else{
            DTOListaPicadoCabecera dtoListaPicadoCabecera = new DTOListaPicadoCabecera();
            
            //dtoListaPicadoCabecera.setCodigoListaPicado(); pasa a ser trigguer
            dtoListaPicadoCabecera.setOidPeriodo(Long.valueOf(((BigDecimal)rs.getValueAt(0,"PERD_OID_PERI")).toString())); 
            dtoListaPicadoCabecera.setOidConfiguracionCD(oidCentroDist);
            DTOLineaArmado dtoLineaArmado = new DTOLineaArmado();
            dtoLineaArmado.setOid(oidLineaArmado);
            dtoListaPicadoCabecera.setLineaArmado(dtoLineaArmado);
            dtoListaPicadoCabecera.setOidAgrupacion(oidAgrupacion);
            
            if (codAgrupacionDefault!=null){
                if (codAgrupacionDefault.equals(ConstantesAPE.FUERA_PEDIDO_ZONA)){
                    dtoListaPicadoCabecera.setOidZona(Long.valueOf(((BigDecimal)rs.getValueAt(0,"ZZON_OID_ZONA")).toString()));
                }else if (codAgrupacionDefault.equals(ConstantesAPE.FUERA_PEDIDO_SECCION)){   
                    // dmorello, 22/02/2008
                    dtoListaPicadoCabecera.setOidZona(new Long( ((BigDecimal)rs.getValueAt(0,"ZZON_OID_ZONA")).longValue() ) );
                    // Fin dmorello, 22/02/2008
                    dtoListaPicadoCabecera.setOidSeccion(Long.valueOf(((BigDecimal)rs.getValueAt(0,"ZSCC_OID_SECC")).toString()));
                }
            }   
            dtoListaPicadoCabecera.setIndicadorImpresion(new Boolean(true));
            dtoListaPicadoCabecera.setFechaCreacion(new Date(System.currentTimeMillis()));
            dtoListaPicadoCabecera.setFechaFacturacion(new Timestamp(((java.sql.Date)rs.getValueAt(0,"FEC_FACT")).getTime()));
            dtoListaPicadoCabecera.setSecuenciaZonaRuta(Long.valueOf(((BigDecimal)rs.getValueAt(0,"NUM_SECU_ZONA_RUTA")).toString()));
            
            //Gpons-07/06/2007: Inc. 409: Se agrega region obligatorio.            
            dtoListaPicadoCabecera.setOidRegion(Long.valueOf(((BigDecimal)rs.getValueAt(0,"ZORG_OID_REGI")).toString()));            

            UtilidadesLog.info("DAOProcesoFueraPedido.obtenerListaPicadoACrear(Long oidConsolidado, Long oidLineaArmado, Long oidCentroDist, Long oidAgrupacion, String codAgrupacionDefault): Salida");
            return dtoListaPicadoCabecera;
        }
        
    }

    /**
     * 
     * @author scsaavedra
     * @since 09-04-2007
     */
    public void actualizarDetallesCantidad(ArrayList lstDetallesAActualizar) throws MareException {
        UtilidadesLog.info("DAOProcesoFueraPedido.actualizarDetallesCantidad(ArrayList lstDetallesAActualizar): Entrada");
        if (lstDetallesAActualizar.size()>0){
            StringBuffer update = null;
            DTOListaPicadoDetalle dtoListaPicadoDetalle = null;
            BelcorpService bs = UtilidadesEJB.getBelcorpService();
            int mide = lstDetallesAActualizar.size();
            for (int i = 0; i < mide; i++) {
                update =new StringBuffer();
                dtoListaPicadoDetalle = (DTOListaPicadoDetalle)lstDetallesAActualizar.get(i);
                
                update.append("UPDATE APE_LISTA_PICAD_DETAL SET NUM_UNID_PROD = " + dtoListaPicadoDetalle.getUnidadesProducto().longValue() + " WHERE OID_LIST_PICA_DETA = " + dtoListaPicadoDetalle.getOid().longValue());
                try {
                    bs.dbService.executeUpdate(update.toString());
                } catch (Exception e) {
                    String error = CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS;
                    throw new MareException(e, UtilidadesError.armarCodigoError(error));
                }
                
                
            }
        }
        UtilidadesLog.info("DAOProcesoFueraPedido.actualizarDetallesCantidad(ArrayList lstDetallesAActualizar): Salida");
    }                                                          
    
    /**
     * @author scsaavedra
     * @since 09-04-2007
     * 
     * CHANGELOG
     * ---------
     * 01/10/2009 - dmorello, Cambio 20090839 - Se inserta valor para el nuevo campo NUM_IDZO en APE_LISTA_PICAD_DETAL
     */
    public void insertarDetalles(ArrayList lstDetallesAInsertar) throws MareException {
        UtilidadesLog.info("DAOProcesoFueraPedido.insertarDetalles(ArrayList lstDetallesAInsertar): Entrada");
        
        if (lstDetallesAInsertar.size()>0) {
            StringBuffer insert = null;
            DTOListaPicadoDetalle dtoListaPicadoDetalle = null;
            BelcorpService bs = UtilidadesEJB.getBelcorpService();
            int mide = lstDetallesAInsertar.size();
            for (int i = 0; i < mide; i++) {
                insert = new StringBuffer();
                dtoListaPicadoDetalle = (DTOListaPicadoDetalle)lstDetallesAInsertar.get(i);

                StringBuffer query = new StringBuffer();                        
                Long oidLPD = null;
                RecordSet rs = null;
                query.append(" SELECT APE_LPDE_SEQ.NEXTVAL FROM DUAL");                                  
                rs = this.executeQuery(query.toString());
                if(rs != null && !rs.esVacio()) {
                    oidLPD = this.bigDecimalToLong(rs.getValueAt(0,0));
                    
                    Long indImpr = null;
                    if (dtoListaPicadoDetalle.getIndicadorImpresion()!=null){
                        if (dtoListaPicadoDetalle.getIndicadorImpresion().booleanValue()){
                            indImpr = new Long(1);
                        }else{
                            indImpr = new Long(0);
                        }    
                    }    
                    
                    insert.append(" INSERT INTO APE_LISTA_PICAD_DETAL (OID_LIST_PICA_DETA, ");
                    insert.append(" NUM_CODI_POSI, ");
                    insert.append(" NUM_UNID_PROD, ");
                    
                    if (dtoListaPicadoDetalle.getValorLinea()!=null)
                        insert.append(" VAL_LINE, ");
                        
                    if (dtoListaPicadoDetalle.getNumeroCaja()!=null)    
                        insert.append(" NUM_CAJA, ");
                        
                    if (dtoListaPicadoDetalle.getIndicadorImpresion()!=null)    
                        insert.append(" IND_IMPR, ");
                        
                    if (dtoListaPicadoDetalle.getNombrePicador()!=null)    
                        insert.append(" VAL_NOMB_PICA, ");
                        
                    if (dtoListaPicadoDetalle.getUnidadesPicadas()!=null)    
                        insert.append(" NUM_UNID_PICA, ");
                        
                    if (dtoListaPicadoDetalle.getUnidadesChequeadas()!=null)    
                        insert.append(" NUM_UNID_CHEQ, ");
                        
                    insert.append(" LPCA_OID_LIST_PICA_CABE, ");
                    
                    if (dtoListaPicadoDetalle.getOidTipoCajaEmbalaje()!=null)
                        insert.append(" TCEM_OID_TIPO_CAJA_EMBA, ");
                        
                    insert.append(" MCDD_OID_MAPA_CENT_DIST_DETA, ");
                    insert.append(" NUM_IDZO, ");
                    insert.append(" SIPI_OID_SIST_PICA, ");
                    insert.append(" PROD_OID_PROD) VALUES ( " + oidLPD.longValue() + ", " + dtoListaPicadoDetalle.getCodigoPosicion());
                    insert.append(", " + dtoListaPicadoDetalle.getUnidadesProducto().longValue());
                    
                    if (dtoListaPicadoDetalle.getValorLinea()!=null)
                        insert.append(", " + dtoListaPicadoDetalle.getValorLinea());
                        
                    if (dtoListaPicadoDetalle.getNumeroCaja()!=null)    
                        insert.append(", " + dtoListaPicadoDetalle.getNumeroCaja().longValue());
                        
                    if (dtoListaPicadoDetalle.getIndicadorImpresion()!=null)    
                        insert.append(", " + indImpr.longValue());
                        
                    if (dtoListaPicadoDetalle.getNombrePicador()!=null)        
                        insert.append(", " + dtoListaPicadoDetalle.getNombrePicador());
                        
                    if (dtoListaPicadoDetalle.getUnidadesPicadas()!=null)        
                        insert.append(", " + dtoListaPicadoDetalle.getUnidadesPicadas().longValue());
                    
                    if (dtoListaPicadoDetalle.getUnidadesChequeadas()!=null)        
                        insert.append(", " + dtoListaPicadoDetalle.getUnidadesChequeadas().longValue());
                        
                    insert.append(", " +  dtoListaPicadoDetalle.getOidCabecera().longValue());
                    
                    if (dtoListaPicadoDetalle.getOidTipoCajaEmbalaje()!=null)
                        insert.append(", " + dtoListaPicadoDetalle.getOidTipoCajaEmbalaje().longValue());
                        
                    insert.append(", " + dtoListaPicadoDetalle.getOidMapaCDDetalle().longValue());
                    insert.append(", " + dtoListaPicadoDetalle.getIdZona());
                    insert.append(", " + dtoListaPicadoDetalle.getOidSistemaPicado().longValue() + ", " + 
                                         dtoListaPicadoDetalle.getOidProducto().longValue() + ")");
                    
                    UtilidadesLog.debug("antes de insert....");
                    try {
                        bs.dbService.executeUpdate(insert.toString());     
                        
                    } catch (DuplicateKeyException ex) {
                        UtilidadesLog.error(ex);
                        throw new MareException(ex, UtilidadesError.armarCodigoError(
                            CodigosError.ERROR_DE_CLAVE_DUPLICADA));
                    } catch (Exception e){        
                        UtilidadesLog.error("insert APE_LISTA_PICAD_DETAL: Exception", e);
                        throw new MareException(e, UtilidadesError.armarCodigoError(
                            CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS));
                    } 
                }
            }
        }
        UtilidadesLog.info("DAOProcesoFueraPedido.insertarDetalles(ArrayList lstDetallesAInsertar): Salida");
  
    }

    /**
     * 
     * @author scsaavedra
     * @since 09-04-2007
     */
    public void actualizarTotalesCabecera(Long oidListaPicado, Long unidadesTotales) throws MareException {
        UtilidadesLog.info("DAOProcesoFueraPedido.actualizarTotalesCabecera(Long oidListaPicado, Long unidadesTotales): Entrada");
        
        StringBuffer update = new StringBuffer();
        BelcorpService bs = UtilidadesEJB.getBelcorpService();
        update.append("UPDATE APE_LISTA_PICAD_CABEC SET NUM_UNID_TOTA = " + unidadesTotales.longValue() + " WHERE OID_LIST_PICA_CABE = " + oidListaPicado.longValue());
        try {
            bs.dbService.executeUpdate(update.toString());
        } catch (Exception e) {
            String error = CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS;
            throw new MareException(e, UtilidadesError.armarCodigoError(error));
        }
        
        UtilidadesLog.info("DAOProcesoFueraPedido.actualizarTotalesCabecera(Long oidListaPicado, Long unidadesTotales): Salida");
    }

    /**
     * 
     * @author scsaavedra
     * @since 09-04-2007
     */
    public Long crearListaPicadoCabecera(DTOListaPicadoCabecera dtoE) throws MareException {
        UtilidadesLog.info("DAOProcesoFueraPedido.crearListaPicadoCabecera(DTOListaPicadoCabecera dtoE): Entrada");
    
        StringBuffer query = new StringBuffer();                        
        Long oidLPC = null;
        RecordSet rs = null;
        query.append("SELECT APE_LPCA_SEQ.NEXTVAL FROM DUAL");                                  
  
        rs = this.executeQuery(query.toString());
  
        if(rs != null && !rs.esVacio()){
            oidLPC = this.bigDecimalToLong(rs.getValueAt(0,0));
            StringBuffer insert = new StringBuffer();
            BelcorpService bs = UtilidadesEJB.getBelcorpService();
            
            UtilidadesLog.debug("oidLPC: " + oidLPC.longValue());
            
            /*String indChq = null; 
            if (dtoE.getIndicadorChequeo()!=null){
                if (dtoE.getIndicadorChequeo().booleanValue()){
                    indChq = new String("S");
                }else{
                    indChq = new String("N");
                }              
            }*/ 
            
            Long indImpr = null;
            if(dtoE.getIndicadorImpresion()!=null){
                if (dtoE.getIndicadorImpresion().booleanValue()){
                    indImpr = new Long(1);
                }else{
                    indImpr = new Long(0);
                }   
            }
            SimpleDateFormat miFecha = new SimpleDateFormat("dd/MM/yyyy");
            String sFecha = miFecha.format(dtoE.getFechaCreacion());
            query.append(sFecha + "' ,'DD/MM/YYYY')");          
            
            String indIntEnv = null;
            if (dtoE.getIndicadorInterfaceEnviada()!=null){
                if (dtoE.getIndicadorInterfaceEnviada().booleanValue()){
                    indIntEnv = new String("S");
                }else{
                    indIntEnv = new String("N");
                }   
            }             
            SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy hh:mm:ss");
            
            String sInicio   = null;
            String sFin      = null;
            String sFechaFact = null;
            
            if (dtoE.getFechaHoraInicioEmbalaje()!=null){
                java.sql.Date fechaIni  = new java.sql.Date(dtoE.getFechaHoraInicioEmbalaje().getTime());
                sInicio    = sdf.format(fechaIni);
            }    
            if (dtoE.getFechaHoraFinEmbalaje()!=null){    
                java.sql.Date fechaFin  = new java.sql.Date(dtoE.getFechaHoraFinEmbalaje().getTime());
                sFin       = sdf.format(fechaFin);
            }    
            if (dtoE.getFechaFacturacion()!=null){    
                java.sql.Date fechaFact = new java.sql.Date(dtoE.getFechaFacturacion().getTime());
                /* BELC400000710 - dmorello, 05/09/2007 */
                //sFechaFact = sdf.format(fechaFact);
                sFechaFact = miFecha.format(fechaFact);
            }    
            
            insert.append(" INSERT INTO APE_LISTA_PICAD_CABEC (OID_LIST_PICA_CABE, ");
            //insert.append(" COD_LIST_PICA, "); pasa a ser trigguer!!
            
            //SCS, por inc.: BELC400000473
            /*
            if (dtoE.getIndicadorChequeo()!=null)
                insert.append(" IND_CHEQ, ");
                
            se graba lo que traiga el atributo que ahora es long! (indicadorChequeo)    
            */

            if (dtoE.getIndicadorChequeo()!=null)            
                insert.append(" INRE_OID_INDI_REVI, ");
            
            if (dtoE.getNumeroTotalCajas()!=null)
                insert.append(" NUM_TOTA_CAJA, ");
               
            if (dtoE.getSecuencia()!=null)    
                insert.append(" VAL_SECU, ");
            
            if(dtoE.getIndicadorImpresion()!=null)
                insert.append(" IND_IMPR, ");

            insert.append(" FEC_CREA, ");
            
            if (dtoE.getVolumen()!=null)
                insert.append(" NUM_VOLU, ");
                
            if (dtoE.getNumeroUnidadesTotales()!=null)        
                insert.append(" NUM_UNID_TOTA, ");
                
            /*if (dtoE.getOidAgrupacion()!=null)    
                insert.append(" NUM_AGRU, ");  BELCORP_04_0047*/
                
            insert.append(" IND_IMP1, ");
            
            if (dtoE.getSecuenciaZonaRuta()!=null)
                insert.append(" NUM_SECU_ZONA_RUTA, ");
                
            insert.append(" VAL_TEXT_CHEQ, ");
            insert.append(" VAL_TEXT_PRIM_PEDI, ");
            
            if (dtoE.getIndicadorInterfaceEnviada()!=null)
                insert.append(" IND_INTE_ENVI, ");
                
            if (dtoE.getFechaHoraInicioEmbalaje()!=null)
                insert.append(" FEC_HORA_INIC_EMBA, ");
                
            if (dtoE.getFechaHoraFinEmbalaje()!=null)
                insert.append(" FEC_HORA_FINA_EMBA, ");
                
            insert.append(" PERD_OID_PERI, ");
            if (dtoE.getOidSeccion()!=null)
                insert.append(" ZSCC_OID_SECC, ");
                
            insert.append(" CCDI_OID_CONF_CENT_DIST, ");
            
            if (dtoE.getOidAgrupacion()!=null)  
                // dmorello, 22/02/2008
                //insert.append(" CAFP_OID_CONF_LAFP, ");          //segun arese (mail del 13/04/07) ...y el campo obligatorio corresponde al atributo oidAgrupacion del DTO...
                insert.append(" LIAC_OID_CONF_LAFP_CABE, ");
                // Fin dmorello 22/02/2008
                
            insert.append(" LIAR_OID_LINE_ARMA, ");
            
            // dmorello, 28/02/2008 - Las listas AFP NO TIENEN OID DE CONSOLIDADO!!!
            //if (dtoE.getOidSolicitudCAbecera()!=null)
            //    insert.append(" SOCA_OID_SOLI_CABE, ");
                
            if (dtoE.getOidZona()!=null)    
                insert.append(" ZZON_OID_ZONA, ");
                
            //Gpons-07/06/2007: Inc. 409: Se agrega region obligatorio.
            insert.append(" FEC_FACTU, ZORG_OID_REGI ) VALUES ( " + oidLPC.longValue());
   
            //SCS, por inc.: BELC400000473
            /*if (dtoE.getIndicadorChequeo()!=null)
                insert.append(", " + indChq);
            */
            if (dtoE.getIndicadorChequeo()!=null)
                insert.append(", " + dtoE.getIndicadorChequeo().longValue());
            
            if (dtoE.getNumeroTotalCajas()!=null)
                insert.append(", " + dtoE.getNumeroTotalCajas().longValue());
            
            if (dtoE.getSecuencia()!=null)
                insert.append(", " + dtoE.getSecuencia());
            if(dtoE.getIndicadorImpresion()!=null)
                insert.append(", " + indImpr);
            
            insert.append(", TO_DATE( '" + sFecha + "' ,'DD/MM/YYYY')");
            
            if (dtoE.getVolumen()!=null)
                insert.append(", " + dtoE.getVolumen());
            if (dtoE.getNumeroUnidadesTotales()!=null)    
                insert.append(", " + dtoE.getNumeroUnidadesTotales().longValue());
                
            /*if (dtoE.getOidAgrupacion()!=null)    
                insert.append(", " + dtoE.getAgrupacion().longValue());BELCORP_04_0047*/
                
            insert.append(", 'N'");
            
            if (dtoE.getSecuenciaZonaRuta()!=null)
                insert.append(", " + dtoE.getSecuenciaZonaRuta().longValue());
                
            insert.append(", " + dtoE.getTextoChequeo());
            insert.append(", " + dtoE.getTextoPrimerPedido());
            
            if (dtoE.getIndicadorInterfaceEnviada()!=null)
                insert.append(", " + indIntEnv);

            if (dtoE.getFechaHoraInicioEmbalaje()!=null)
                insert.append(", TO_DATE('" + sInicio + "','dd-MM-yyyy HH24:MI:SS')");
            if (dtoE.getFechaHoraFinEmbalaje()!=null)
                insert.append(", TO_DATE('" + sFin    + "','dd-MM-yyyy HH24:MI:SS')");
            insert.append(", " + dtoE.getOidPeriodo().longValue());
            
            if (dtoE.getOidSeccion()!=null)
                insert.append(", " + dtoE.getOidSeccion().longValue());
            
            insert.append(", " + dtoE.getOidConfiguracionCD().longValue());
            if (dtoE.getOidAgrupacion()!=null)    
                insert.append(", " + dtoE.getOidAgrupacion().longValue());
                
            insert.append(", " + dtoE.getLineaArmado().getOid().longValue());
            
            if (dtoE.getOidSolicitudCAbecera()!=null)
                insert.append(", " + dtoE.getOidSolicitudCAbecera().longValue());
            
            if (dtoE.getOidZona()!=null)
                insert.append(", " + dtoE.getOidZona().longValue());
            
            if (dtoE.getFechaFacturacion()!=null)
               /* BELC400000711 - dmorello, 05/09/2007 */
               //insert.append(", TO_DATE('" + sFechaFact + "','dd-MM-yyyy HH24:MI:SS')");
               insert.append(", TO_DATE('" + sFechaFact + "','dd/MM/yyyy')");

            //Gpons-07/06/2007: Inc. 409: Se agrega region obligatorio.            
            insert.append(", " + dtoE.getOidRegion().longValue());

            insert.append(")");
            UtilidadesLog.debug("antes de insert....instr.: " + insert.toString());
            try {
                bs.dbService.executeUpdate(insert.toString());     
                
            } catch (DuplicateKeyException ex) {
                UtilidadesLog.error(ex);
                throw new MareException(ex, UtilidadesError.armarCodigoError(
                    CodigosError.ERROR_DE_CLAVE_DUPLICADA));
            } catch (Exception e){        
                UtilidadesLog.error("insert APE_LISTA_PICAD_DETAL: Exception", e);
                throw new MareException(e, UtilidadesError.armarCodigoError(
                    CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS));
            } 
            UtilidadesLog.info("DAOProcesoFueraPedido.crearListaPicadoCabecera(DTOListaPicadoCabecera dtoE): Salida");
            return oidLPC;
        }
        UtilidadesLog.info("DAOProcesoFueraPedido.crearListaPicadoCabecera(DTOListaPicadoCabecera dtoE): Salida");
        return null;
    }
    
    /**
     * 
     * @author scsaavedra
     * @since 09-04-2007
     */    
    private RecordSet executeQuery(String query) throws MareException {
      UtilidadesLog.info("DAOProcesoFueraPedido.executeQuery(String query): Entrada");
      RecordSet rs = null;
    
      try {
        BelcorpService belcorpService = BelcorpService.getInstance();
        rs = belcorpService.dbService.executeStaticQuery( query );
      } catch ( Exception ex ) {
        throw new MareException( ex, 
            UtilidadesError.armarCodigoError(
              CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS ));
      }       
      UtilidadesLog.info("DAOProcesoFueraPedido.executeQuery(String query): Salida");  
      return rs;
  }
  
    /**
     * 
     * @author scsaavedra
     * @since 09-04-2007
     */  
  private Long bigDecimalToLong(Object numero) {
      if (numero != null) {
          return new Long(((BigDecimal) numero).longValue());
      } else {
          return null;
      }
  }
  
  
  /**
   * Creado por incidencia RI 20080820
   * Se inserta en APE_LISTA_PICAD_DETAL_TEMP un registro con la info de los
   * DTOs de entrada, que corresponden a un detalle de lista de picado y su
   * correspondiente cabecera, los cuales seran creados luego de la facturacion
   * en las tablas correspondientes.
   * 
   * @author dmorello
   * @since 12-mar-2009
   * 
   * CHANGELOG
   * ---------
   * 01/10/2009 - dmorello, Cambio 20090839 - Se inserta valor tambien para el campo NUM_IDZO
   */
  public void insertarDetalleAFPTemporal(DTOListaPicadoCabecera dtoCabecera,
            DTOListaPicadoDetalle dtoDetalle) throws MareException {
            
      UtilidadesLog.info("DAOProcesoFueraPedido.insertarDetalleAFPTemporal"
            + "(DTOListaPicadoCabecera, DTOListaPicadoDetalle): Entrada"); 
            
      UtilidadesLog.debug("dtoCabecera: " + dtoCabecera);
      UtilidadesLog.debug("dtoDetalle: " + dtoDetalle);
            
      BelcorpService bs = UtilidadesEJB.getBelcorpService();
      StringBuffer insert = new StringBuffer();
      
      Long indImprDeta = null;
      Long indImprCabe = null;
      if (dtoDetalle.getIndicadorImpresion() != null) {
          indImprDeta = new Long(dtoDetalle.getIndicadorImpresion().booleanValue()? 1 : 0);
      }
      if (dtoCabecera.getIndicadorImpresion() != null) {
          indImprCabe = new Long(dtoCabecera.getIndicadorImpresion().booleanValue()? 1 : 0);
      }
      
      SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
      String strFechaCreacion = sdf.format(dtoCabecera.getFechaCreacion());
      String strFechaFact = sdf.format(dtoCabecera.getFechaFacturacion());
      
      insert.append("INSERT INTO APE_LISTA_PICAD_DETAL_TEMP ( ");
      insert.append("    OID_LIST_PICA_DETA_TEMP, ");
      insert.append("    NUM_UNID_PROD, ");
      insert.append("    IND_IMPR_DETA, ");
      insert.append("    MCDD_OID_MAPA_CENT_DIST_DETA, ");
      insert.append("    SIPI_OID_SIST_PICA, ");
      insert.append("    PROD_OID_PROD, ");
      insert.append("    IND_IMPR_CABE, ");
      insert.append("    FEC_CREA, ");
      insert.append("    NUM_SECU_ZONA_RUTA, ");
      insert.append("    PERD_OID_PERI, ");
      insert.append("    ZSCC_OID_SECC, ");
      insert.append("    CCDI_OID_CONF_CENT_DIST, ");
      insert.append("    LIAR_OID_LINE_ARMA, ");
      insert.append("    ZZON_OID_ZONA, ");
      insert.append("    FEC_FACTU, ");
      insert.append("    ZORG_OID_REGI, ");
      insert.append("    NUM_IDZO, ");
      insert.append("    LIAC_OID_CONF_LAFP_CABE ");
      insert.append(") VALUES ( ");
      insert.append("    APE_LPDT_SEQ.nextval, ");
      insert.append(dtoDetalle.getUnidadesProducto()).append(',');
      insert.append(indImprDeta).append(',');
      insert.append(dtoDetalle.getOidMapaCDDetalle()).append(',');
      insert.append(dtoDetalle.getOidSistemaPicado()).append(',');
      insert.append(dtoDetalle.getOidProducto()).append(',');
      insert.append(indImprCabe).append(',');
      insert.append("TO_DATE('").append(strFechaCreacion).append("', 'DD/MM/YYYY'),");
      insert.append(dtoCabecera.getSecuenciaZonaRuta()).append(',');
      insert.append(dtoCabecera.getOidPeriodo()).append(',');
      insert.append(dtoCabecera.getOidSeccion()).append(',');
      insert.append(dtoCabecera.getOidConfiguracionCD()).append(',');
      insert.append(dtoCabecera.getLineaArmado().getOid()).append(',');
      insert.append(dtoCabecera.getOidZona()).append(',');
      insert.append("TO_DATE('").append(strFechaFact).append("', 'DD/MM/YYYY'),");
      insert.append(dtoCabecera.getOidRegion()).append(',');
      insert.append(dtoDetalle.getIdZona()).append(',');
      insert.append(dtoCabecera.getOidAgrupacion());
      insert.append(")");
      
      try {
          bs.dbService.executeUpdate(insert.toString());
      } catch (Exception e) {
          String error = CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS;
          throw new MareException(e, UtilidadesError.armarCodigoError(error));
      }
            
      UtilidadesLog.info("DAOProcesoFueraPedido.insertarDetalleAFPTemporal"
            + "(DTOListaPicadoCabecera, DTOListaPicadoDetalle): Salida");  
  }
  
  
  
  /**
   * Creado por incidencia RI 20080820
   * Se obtiene, a partir de los registros en APE_LISTA_PICAD_DETAL_TEMP,
   * la informacion de las cabeceras de listas de picado AFP que deben
   * crearse o actualizarse para el pais recibido por parametro
   * @author dmorello
   * @since 29-ene-2009
   * 
   * CHANGELOG
   * ---------
   * dmorello, 12/03/2009: Se elimina el campo NUM_UNID_LISTA_EXISTENTE
   *                       Se modifica la obtencion del campo OID_LISTA_EXISTENTE
   *                       Se descartan los registros con numero de unidades cero
   */
  public RecordSet obtenerDatosParaCabecerasAFP(Long oidPais) throws MareException {
      UtilidadesLog.info("DAOProcesoFueraPedido.obtenerDatosParaCabecerasAFP(): Entrada");
      
      BelcorpService bs = UtilidadesEJB.getBelcorpService();
      StringBuffer query = new StringBuffer();
      
      query.append(" SELECT  cab_nueva.*, ");
      query.append("         (SELECT cab.oid_list_pica_cabe ");
      query.append("            FROM ape_lista_picad_cabec cab ");
      query.append("           WHERE cab.perd_oid_peri = cab_nueva.perd_oid_peri ");
      query.append("             AND cab.fec_factu = cab_nueva.fec_factu ");
      query.append("             AND cab.ccdi_oid_conf_cent_dist = cab_nueva.ccdi_oid_conf_cent_dist ");
      query.append("             AND cab.zorg_oid_regi = cab_nueva.zorg_oid_regi ");
      query.append("             AND (   (    cab.liac_oid_conf_lafp_cabe IS NOT NULL ");
      query.append("                      AND cab.liac_oid_conf_lafp_cabe = cab_nueva.liac_oid_conf_lafp_cabe ");
      query.append("                     ) ");
      query.append("                  OR (    cab.liac_oid_conf_lafp_cabe IS NULL ");
      query.append("                      AND cab.zzon_oid_zona = cab_nueva.zzon_oid_zona ");
      query.append("                      AND cab.zscc_oid_secc = cab_nueva.zscc_oid_secc ");
      query.append("                     ) ");
      query.append("                 )) AS oid_lista_existente, NULL AS num_secu_zona_ruta ");
      query.append("     FROM (SELECT   ind_impr_cabe, fec_crea, perd_oid_peri, ");
      query.append("                    zscc_oid_secc, ccdi_oid_conf_cent_dist, liar_oid_line_arma, ");
      query.append("                    zzon_oid_zona, fec_factu, zorg_oid_regi, ");
      query.append("                    liac_oid_conf_lafp_cabe, COUNT (DISTINCT prod_oid_prod) cant_productos ");
      query.append("               FROM ape_lista_picad_detal_temp det ");
      query.append("                  , app_confi_centr_distr cd ");
      query.append("              WHERE det.ccdi_oid_conf_cent_dist = cd.oid_conf_cent_dist ");
      query.append("                AND cd.pais_oid_pais = ").append(oidPais);
      query.append("                AND det.num_unid_prod > 0 ");
      query.append("           GROUP BY ind_impr_cabe, ");
      query.append("                    fec_crea, ");
      query.append("                    perd_oid_peri, ");
      query.append("                    zscc_oid_secc, ");
      query.append("                    ccdi_oid_conf_cent_dist, ");
      query.append("                    liar_oid_line_arma, ");
      query.append("                    zzon_oid_zona, ");
      query.append("                    fec_factu, ");
      query.append("                    zorg_oid_regi, ");
      query.append("                    liac_oid_conf_lafp_cabe) cab_nueva ");
      query.append(" ORDER BY cab_nueva.perd_oid_peri, ");
      query.append("          cab_nueva.fec_factu, ");
      query.append("          cab_nueva.ccdi_oid_conf_cent_dist, ");
      query.append("          cab_nueva.liac_oid_conf_lafp_cabe NULLS LAST, ");
      query.append("          cab_nueva.zorg_oid_regi, ");
      query.append("          cab_nueva.zzon_oid_zona NULLS LAST, ");
      query.append("          cab_nueva.zscc_oid_secc NULLS LAST ");
     
      RecordSet rs = null;
      
      try {
          rs = bs.dbService.executeStaticQuery(query.toString());
      } catch (Exception e) {
          String error = CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS;
          throw new MareException(e, UtilidadesError.armarCodigoError(error));
      }
      
      UtilidadesLog.info("DAOProcesoFueraPedido.obtenerDatosParaCabecerasAFP(): Salida");
      return rs;
  }
  
  
  /**
   * Creado por incidencia RI 20080820
   * Se obtiene, a partir de los registros en APE_LISTA_PICAD_DETAL_TEMP,
   * la informacion de los detalles de listas de picado AFP que deben
   * crearse o actualizarse para el pais recibido por parametro
   * @author dmorello
   * @since 29-ene-2009
   * 
   * CHANGELOG
   * ---------
   * dmorello, 12/03/2009: Se descartan los registros con numero de unidades cero
   * dmorello, 01/10/2009: Cambio 20090839 - Se recupera el campo NUM_IDZO de APE_LISTA_PICAD_DETAL_TEMP
   */
  public RecordSet obtenerDatosParaDetallesAFP(Long oidPais) throws MareException {
      UtilidadesLog.info("DAOProcesoFueraPedido.obtenerDatosParaDetallesAFP(): Entrada");
      
      BelcorpService bs = UtilidadesEJB.getBelcorpService();
      StringBuffer query = new StringBuffer();
      
      query.append(" SELECT   ind_impr_cabe, fec_crea, NULL as num_secu_zona_ruta, perd_oid_peri, ");
      query.append("          zscc_oid_secc, ccdi_oid_conf_cent_dist, liar_oid_line_arma, ");
      query.append("          zzon_oid_zona, fec_factu, zorg_oid_regi, liac_oid_conf_lafp_cabe, ");
      query.append("          ind_impr_deta, mcdd_oid_mapa_cent_dist_deta, num_idzo, sipi_oid_sist_pica, ");
      query.append("          prod_oid_prod, SUM (num_unid_prod) AS num_unid_prod ");
      query.append("     FROM ape_lista_picad_detal_temp det ");
      query.append("        , app_confi_centr_distr cd ");
      query.append("  WHERE det.ccdi_oid_conf_cent_dist = cd.oid_conf_cent_dist ");
      query.append("    AND cd.pais_oid_pais = ").append(oidPais);
      query.append("    AND det.num_unid_prod > 0 ");
      query.append(" GROUP BY ind_impr_cabe, ");
      query.append("          fec_crea, ");
      query.append("          perd_oid_peri, ");
      query.append("          zscc_oid_secc, ");
      query.append("          ccdi_oid_conf_cent_dist, ");
      query.append("          liar_oid_line_arma, ");
      query.append("          zzon_oid_zona, ");
      query.append("          fec_factu, ");
      query.append("          zorg_oid_regi, ");
      query.append("          liac_oid_conf_lafp_cabe, ");
      query.append("          ind_impr_deta, ");
      query.append("          mcdd_oid_mapa_cent_dist_deta, ");
      query.append("          num_idzo, ");
      query.append("          sipi_oid_sist_pica, ");
      query.append("          prod_oid_prod ");
      query.append(" ORDER BY perd_oid_peri, ");
      query.append("          fec_factu, ");
      query.append("          ccdi_oid_conf_cent_dist, ");
      query.append("          liac_oid_conf_lafp_cabe NULLS LAST, ");
      query.append("          zorg_oid_regi, ");
      query.append("          zzon_oid_zona NULLS LAST, ");
      query.append("          zscc_oid_secc NULLS LAST ");
      
      RecordSet rs = null;
      
      try {
          rs = bs.dbService.executeStaticQuery(query.toString());
      } catch (Exception e) {
          String error = CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS;
          throw new MareException(e, UtilidadesError.armarCodigoError(error));
      }
      
      UtilidadesLog.info("DAOProcesoFueraPedido.obtenerDatosParaDetallesAFP(): Salida");
      return rs;  
  }
  
  /**
   * Creado por incidencia RI 20080820
   * Se eliminan todos los registros en APE_LISTA_PICAD_DETAL_TEMP
   * @author dmorello
   * @since 12-mar-2009
   */
  public void eliminarDetallesTemporales(Long oidPais) throws MareException {
      UtilidadesLog.info("DAOProcesoFueraPedido.eliminarDetallesTemporales(): Entrada");
      
      BelcorpService bs = UtilidadesEJB.getBelcorpService();
      try {
          StringBuffer delete = new StringBuffer();
          
          delete.append(" DELETE FROM APE_LISTA_PICAD_DETAL_TEMP ");
          delete.append("  WHERE ccdi_oid_conf_cent_dist IN (");
          delete.append("      SELECT oid_conf_cent_dist ");
          delete.append("        FROM app_confi_centr_distr ");
          delete.append("       WHERE pais_oid_pais = ").append(oidPais);
          delete.append("  )");
          
          bs.dbService.executeUpdate(delete.toString());
      } catch (Exception e) {
          String error = CodigosError.ERROR_DE_BORRADO_DE_DATOS;
          throw new MareException(e, UtilidadesError.armarCodigoError(error));
      }
      
      UtilidadesLog.info("DAOProcesoFueraPedido.eliminarDetallesTemporales(): Salida");
  }
  
  /**
   * Actualiza el numero de unidades de un conjunto de listas de picado
   * recibido por parametro.
   * @author dmorello
   * @since 29-ene-2009
   * 
   * CHANGELOG
   * ---------
   * dmorello, 12/03/2009: El hashmap recibido contiene UNIDADES A AGREGAR a cada lista
   *                       en lugar del total de unidades a escribir.
   */
  public void actualizarTotalesCabeceras(HashMap hashCabeceras) throws MareException {
      UtilidadesLog.info("DAOProcesoFueraPedido.actualizarTotalesCabeceras(HashMap hashCabeceras): Entrada");
      
      // Cuantas sentencias de update paso al executor de una sola vez
      final int UPDATES_POR_EJECUCION = 500;
      
      BelcorpService bs = UtilidadesEJB.getBelcorpService();
      StringBuffer updates = new StringBuffer();
      int cantUpdates = 0;
      
      Object oidLista;
      Object unidades;
      Iterator it = hashCabeceras.keySet().iterator();
      while (it.hasNext()) {
          oidLista = it.next();
          unidades = hashCabeceras.get(oidLista);
          
          updates.append("UPDATE APE_LISTA_PICAD_CABEC ");
          updates.append("   SET NUM_UNID_TOTA = NUM_UNID_TOTA + ").append(unidades);
          updates.append(" WHERE OID_LIST_PICA_CABE = ").append(oidLista).append(';');
          
          cantUpdates++;
          if (cantUpdates == UPDATES_POR_EJECUCION || !it.hasNext()) {
              try {
                  bs.dbService.executeProcedure("PQ_PLANI.EXECUTOR", updates.toString());
              } catch (Exception e) {
                  String error = CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS;
                  throw new MareException(e, UtilidadesError.armarCodigoError(error));
              }
              cantUpdates = 0;
          }
      }
      
      UtilidadesLog.info("DAOProcesoFueraPedido.actualizarTotalesCabeceras(HashMap hashCabeceras): Salida");
  }
    
}