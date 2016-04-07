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
 */
package es.indra.sicc.logicanegocio.ape;
import es.indra.mare.common.exception.MareException;
import es.indra.mare.common.mii.services.jdbcservice.RecordSet;
import es.indra.sicc.cmn.negocio.i18n.DTOI18nSICC;
import es.indra.sicc.dtos.ape.DTOBuscarAnaqueles;
import es.indra.sicc.dtos.ape.DTOConfiguracionCentroDistribucion;
import es.indra.sicc.dtos.ape.DTOLineaArmado;
import es.indra.sicc.dtos.ape.DTOMapaCentroDistribucionCabecera;
import es.indra.sicc.dtos.ape.DTOMapaCentroDistribucionDetalle;
import es.indra.sicc.dtos.ape.DTOOrdenAnaquelesCabecera;
import es.indra.sicc.dtos.ape.DTOSublineaArmado;
import es.indra.sicc.dtos.ape.DTOMapaZonasCabecera;
import es.indra.sicc.logicanegocio.seg.ConstantesSEG;
import es.indra.sicc.util.BelcorpService;
import es.indra.sicc.util.CodigosError;
import es.indra.sicc.util.DTOSalida;
import es.indra.sicc.util.UtilidadesEJB;
import es.indra.sicc.util.UtilidadesError;
import es.indra.sicc.util.UtilidadesLog;
import es.indra.sicc.dtos.ape.DTOOrdenAnaquelesDetalle;
import es.indra.sicc.dtos.ape.DTOOrdenAnaquel;
import java.math.BigDecimal;
import java.util.ArrayList;
import es.indra.sicc.util.DTOOID;
import java.util.Vector;

public class DAOMantenimientoOrdenAnaqueles {

    /**
     * Recupera los números de anaqueles a ordenar. 
     * @author scsaavedra
     * @since 24-01-2007
     */
    public DTOSalida obtenerNroAnaquelesAOrdenar(DTOMapaCentroDistribucionDetalle dtoE) throws MareException {
        UtilidadesLog.info("DAOMantenimientoOrdenAnaqueles.obtenerNroAnaquelesAOrdenar(DTOMapaCentroDistribucionDetalle dtoE): Entrada");
        
        UtilidadesLog.info("DTOMapaCentroDistribucionDetalle dtoE, es: " + dtoE);
    
        BelcorpService bs = UtilidadesEJB.getBelcorpService();
        StringBuffer query = new StringBuffer();
        DTOSalida dtoSalida = new DTOSalida();
        
        //query.append(" select * from ( ");
        
				query.append(" SELECT mcdd.OID_MAPA_CENT_DIST_DETA, mcdd.NUM_ANAQ NANAQUEL,  ");
        query.append(" NVL(mcdd.IND_EXPA,0) IND_EXPA  , NVL(mcdd1.NUM_ANAQ,'BLANCO') NUM_ANAQ_DEST");
				query.append(" FROM APE_MAPA_CENTR_DISTR_DETAL mcdd, APE_MAPA_CENTR_DISTR_DETAL mcdd1 ");
        query.append(" WHERE mcdd.MCDC_OID_MAPA_CENT_DIST_CABE = " + dtoE.getMapaCentroDistribucionCabecera().getOid().longValue());
        query.append(" AND mcdd.SBAR_OID_SUBL_ARMA = " + dtoE.getSublineaArmado().getOid().longValue());
        query.append(" AND mcdd.MCDD_OID_MAPA_CENT_DIST_DETA = mcdd1.OID_MAPA_CENT_DIST_DETA(+) ");
        query.append(" ORDER BY mcdd.NUM_ANAQ ");
        
        //query.append(" ) where rownum <= 10 ");
        
        RecordSet rs = null;
        UtilidadesLog.debug("query, : " + query.toString());
        try {
            rs = bs.dbService.executeStaticQuery(query.toString());
        } catch (Exception e) {
            String error = CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS;
            throw new MareException(e, UtilidadesError.armarCodigoError(error));
        }
        
        UtilidadesLog.debug("rs: " + rs);
        
        if (rs.esVacio()) {
            throw new MareException("", UtilidadesError.armarCodigoError(ConstantesSEG.MODULO_APE, "",ErroresDeNegocio.APE_0044));
        }
        dtoSalida.setResultado(rs);
        UtilidadesLog.info("DAOMantenimientoOrdenAnaqueles.obtenerNroAnaquelesAOrdenar(DTOMapaCentroDistribucionDetalle dtoE): Salida");
        return dtoSalida;
    }


    /**
     * Obtiene los datos de la entidad OrdenAnaquelesCabecera, cuya UK se recibe como parametro de entrada. 
     * @author scsaavedra
     * @since 24-01-2007
     */
    public DTOOrdenAnaquelesCabecera obtenerOrdenAnaquelesCabecera(DTOOrdenAnaquelesCabecera dtoE) throws MareException {
        UtilidadesLog.info("DAOMantenimientoOrdenAnaqueles.obtenerOrdenAnaquelesCabecera(DTOOrdenAnaquelesCabecera dtoE): Entrada");
        
        BelcorpService bs = UtilidadesEJB.getBelcorpService();
        StringBuffer query = new StringBuffer();
        DTOOrdenAnaquelesCabecera dtoRet = new DTOOrdenAnaquelesCabecera();
        
				query.append("SELECT oac.OID_ANAQ_CABE, gen.VAL_I18N, oac.LIAR_OID_LINE_ARMA, oac.VAL_DEFE ");
				query.append("FROM APE_ORDEN_ANAQU_CABEC oac, v_gen_i18n_sicc gen ");
        query.append("WHERE oac.MZCA_OID_MAPA_ZONA_CABE = " + dtoE.getMapaZonaCabecera().getOid().longValue());
        
        if (dtoE.getCodigoMapaOrden() != null) {
            query.append(" AND oac.COD_MAPA_ORDE = " + dtoE.getCodigoMapaOrden());
        }
        if (dtoE.getOid() != null) {
            query.append(" AND oac.OID_ANAQ_CABE = " + dtoE.getOid()); // agregado eiraola 03/Jul/2007
        }
        
        query.append("AND gen.attr_enti = 'APE_ORDEN_ANAQU_CABEC' ");
        query.append(" AND gen.idio_oid_idio = " + dtoE.getOidIdioma().longValue());
        query.append(" AND gen.val_oid = oac.OID_ANAQ_CABE ");
        RecordSet rs = null;
        try {
            rs = bs.dbService.executeStaticQuery(query.toString());
        } catch (Exception e) {
            String error = CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS;
            throw new MareException(e, UtilidadesError.armarCodigoError(error));
        }
        
        UtilidadesLog.debug("rs: " + rs);
        
        if ((rs==null) || (rs.getRowCount()<=0)) {
            UtilidadesLog.info("DAOMantenimientoOrdenAnaqueles.obtenerOrdenAnaquelesCabecera(DTOOrdenAnaquelesCabecera dtoE): Salida (sin datos!)");
            // Lanzar el error APE-0033 // "No se encontró ningún Orden de Anaquel que cumpla con los criterios seleccionados" 
            throw new MareException("", UtilidadesError.armarCodigoError(ConstantesSEG.MODULO_APE, "",ErroresDeNegocio.APE_0033));
        } else {
            if (rs.getValueAt(0,"OID_ANAQ_CABE")!=null) {
                dtoE.setOid(new Long(((BigDecimal)rs.getValueAt(0,"OID_ANAQ_CABE")).toString()));
            }
            
            if (rs.getValueAt(0,"VAL_I18N")!=null) {
                dtoE.setDescOrdenAnaqueles(rs.getValueAt(0,"VAL_I18N").toString());
            }
        
            if (rs.getValueAt(0,"VAL_DEFE")!=null) {
                if (rs.getValueAt(0,"VAL_DEFE").toString().equals("1"))
                    dtoE.setValorDefecto(new Boolean(true));  
                else  
                    dtoE.setValorDefecto(new Boolean(false));
            }
            
            UtilidadesLog.debug("v x def.: " + dtoE.getValorDefecto());
        
            DTOLineaArmado dtoLA = new DTOLineaArmado();  
            if (rs.getValueAt(0,"LIAR_OID_LINE_ARMA")!=null) {
                dtoLA.setOid(new Long(((BigDecimal)rs.getValueAt(0,"LIAR_OID_LINE_ARMA")).toString()));
            }
            
            DTOSublineaArmado dtoSLA = new DTOSublineaArmado();           
            dtoSLA.setLineaArmado(dtoLA);
            
            dtoE.setSublineaArmado(dtoSLA);
            UtilidadesLog.info("DAOMantenimientoOrdenAnaqueles.obtenerOrdenAnaquelesCabecera(DTOOrdenAnaquelesCabecera dtoE): Salida (con datos!)");
            return dtoE;
        }
    }    

    /**
     * Obtiene los datos de la entidad OrdenAnaquelesCabecera, cuya UK se recibe como parametro de entrada . 
     * @author scsaavedra
     * @since 25-01-2007
     */
    public ArrayList obtenerOrdenAnaquelesDetalles(DTOOrdenAnaquelesCabecera dtoE) throws MareException {
        UtilidadesLog.info("DAOMantenimientoOrdenAnaqueles.obtenerOrdenAnaquelesDetalles(DTOOrdenAnaquelesCabecera dtoE): Entrada");

        BelcorpService bs = UtilidadesEJB.getBelcorpService();
        StringBuffer query = new StringBuffer();

				//query.append("SELECT ordenDet.OID_ORDE_ANAQ_DETA, ordenDet.NUM_ANAQ, ordenDet.NUM_ORDE ");
        query.append("SELECT ordenDet.OID_ORDE_ANAQ_DETA, ordenDet.MCDD_OID_MAPA_CENT_DIST_DETA, ordenDet.NUM_ORDE ");
				query.append("FROM APE_ORDEN_ANAQU_DETAL ordenDet ");
        query.append("WHERE ordenDet.OACA_OID_ANAQ_CABE = " + dtoE.getOid().longValue());
        RecordSet rs = null;
        
        try {
            rs = bs.dbService.executeStaticQuery(query.toString());
        } catch (Exception e) {
            String error = CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS;
            throw new MareException(e, UtilidadesError.armarCodigoError(error));
        }
        
        UtilidadesLog.debug("rs: " + rs);

        if ((rs==null) || (rs.getRowCount()<=0)) {
            UtilidadesLog.info("DAOMantenimientoOrdenAnaqueles.obtenerOrdenAnaquelesDetalles(DTOOrdenAnaquelesCabecera dtoE): Salida (sin datos!)");
            // Lanzar el error APE-0034 // "No se encontró ningún Número de Anaquel que cumpla con los criterios seleccionados
            throw new MareException("", UtilidadesError.armarCodigoError(ConstantesSEG.MODULO_APE, "",ErroresDeNegocio.APE_0034));
        } else {
            ArrayList lstdetalles = new ArrayList();
            int rows = rs.getRowCount();
            
            DTOOrdenAnaquelesDetalle dtoDetalle = null;
            for (int indice = 0; indice < rows; indice++) {
            
                dtoDetalle = new DTOOrdenAnaquelesDetalle();
                
                if (rs.getValueAt(indice,"OID_ORDE_ANAQ_DETA")!=null) {
                    dtoDetalle.setOid(new Long(((BigDecimal)rs.getValueAt(indice,"OID_ORDE_ANAQ_DETA")).toString()));
                }
                /*if (rs.getValueAt(indice,"NUM_ANAQ")!=null) {
                    dtoDetalle.setNumeroAnaquel(rs.getValueAt(indice,"NUM_ANAQ").toString());
                }*/
                if (rs.getValueAt(indice,"MCDD_OID_MAPA_CENT_DIST_DETA")!=null) {
                    dtoDetalle.setOidAnaquel(new Long(((BigDecimal)rs.getValueAt(indice,"MCDD_OID_MAPA_CENT_DIST_DETA")).toString()));
                }
                if (rs.getValueAt(indice,"NUM_ORDE")!=null) {
                    dtoDetalle.setNumeroOrden(new Long(((BigDecimal)rs.getValueAt(indice,"NUM_ORDE")).toString()));
                }
                lstdetalles.add(dtoDetalle);
            }
            
            UtilidadesLog.info("DAOMantenimientoOrdenAnaqueles.obtenerOrdenAnaquelesDetalles(DTOOrdenAnaquelesCabecera dtoE): Salida");
            return lstdetalles;
            
        }

    }
    
    /**
     * Recupera los números de anaqueles a ordenar. 
     * @author scsaavedra
     * @since 25-01-2007
     */
    public DTOSalida obtenerMapasOrdenPorMapaZonas(DTOOID dtoE) throws MareException {
        UtilidadesLog.info("DAOMantenimientoOrdenAnaqueles.obtenerMapasOrdenPorMapaZonas(DTOOIDs dtoE): Entrada");
        
        BelcorpService bs = UtilidadesEJB.getBelcorpService();
        StringBuffer query = new StringBuffer();

				query.append(" SELECT ordenCab.OID_ANAQ_CABE, gen.VAL_I18N, ordenCab.COD_MAPA_ORDE ");
				query.append(" FROM APE_ORDEN_ANAQU_CABEC ordenCab, v_gen_i18n_sicc gen ");
        
        // vbongiov -- BELC400000677 -- 28/08/2007
        if(dtoE instanceof DTOOrdenAnaquel){
          query.append("WHERE ordenCab.MZCA_OID_MAPA_ZONA_CABE = " + dtoE.getOid().longValue());
          
        } else {          
          // vbongiov -- BELC400000594 -- 13/08/2007
          query.append(" , APE_ASIGN_PRODU_ANAQU_CABEC cab ");
          query.append(" WHERE cab.OID_ASIG_PROD_ANAQ_CABE = " + dtoE.getOid().longValue());
          query.append(" AND ordenCab.MZCA_OID_MAPA_ZONA_CABE = cab.MZCA_OID_MAPA_ZONA_CABE ");
        }
        
        query.append(" AND gen.attr_enti = 'APE_ORDEN_ANAQU_CABEC' ");
        query.append(" AND gen.idio_oid_idio = " + dtoE.getOidIdioma().longValue());
        query.append(" AND gen.val_oid = ordenCab.OID_ANAQ_CABE ");        
        query.append(" ORDER BY gen.VAL_I18N "); 
        
        RecordSet rs = null;
        
        try {
            rs = bs.dbService.executeStaticQuery(query.toString());
        } catch (Exception e) {
            String error = CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS;
            throw new MareException(e, UtilidadesError.armarCodigoError(error));
        }
        
        UtilidadesLog.debug("rs: " + rs);
        DTOSalida dtoSal = new DTOSalida();
        
        dtoSal.setResultado(rs);
        
        UtilidadesLog.info("DAOMantenimientoOrdenAnaqueles.obtenerMapasOrdenPorMapaZonas(DTOOIDs dtoE): Salida");
        return dtoSal;
        
    }
    
    /**
     * Elimina los datos de la entidad OrdenAnaquelesCabecera. 
     * @author scsaavedra
     * @since 25-01-2007
     */
    public void eliminarOrdenAnaquelesCabecera(Long oid) throws MareException {
        UtilidadesLog.info("DAOMantenimientoOrdenAnaqueles.eliminarOrdenAnaquelesCabecera(Long oid): Entrada");
        
        BelcorpService bs = UtilidadesEJB.getBelcorpService();
        StringBuffer query = new StringBuffer();

				query.append("DELETE FROM APE_ORDEN_ANAQU_CABEC ordenCab ");
        query.append("WHERE ordenCab.OID_ANAQ_CABE = " + oid.longValue());
        
        try{
            int rowDeleted = bs.dbService.executeUpdate(query.toString());
            UtilidadesLog.debug("se eliminaron: " + rowDeleted + " rows...");
        } catch (Exception e){
            if (e instanceof MareException){
                throw (MareException) e;
            }
            UtilidadesLog.error("Exception:  ",e);
            throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_BORRADO_DE_DATOS));
        }
        UtilidadesLog.info("DAOMantenimientoOrdenAnaqueles.eliminarOrdenAnaquelesCabecera(Long oid): Salida");
        
    }    
    
    /**
     * Elimina los datos de la entidad OrdenAnaquelesDetalle. 
     * @author scsaavedra
     * @since 25-01-2007
     */
    public void eliminarOrdenAnaquelesDetalles(Long oid) throws MareException {
        UtilidadesLog.info("DAOMantenimientoOrdenAnaqueles.eliminarOrdenAnaquelesDetalles(Long oid): Entrada");
    
        BelcorpService bs = UtilidadesEJB.getBelcorpService();
        StringBuffer query = new StringBuffer();

        query.append("DELETE FROM APE_ORDEN_ANAQU_DETAL ordenDet ");
        query.append("WHERE ordenDet.OACA_OID_ANAQ_CABE = " + oid.longValue());
        
        try{
            int rowDeleted = bs.dbService.executeUpdate(query.toString());
            UtilidadesLog.debug("se eliminaron: " + rowDeleted + " rows...");
        } catch (Exception e){
            if (e instanceof MareException){
                throw (MareException) e;
            }
            UtilidadesLog.error("Exception:  ",e);
            throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_BORRADO_DE_DATOS));
        }
        UtilidadesLog.info("DAOMantenimientoOrdenAnaqueles.eliminarOrdenAnaquelesDetalles(Long oid): Salida");
    }    
    
    private String cadenaInt(Long[] cadena) {
        UtilidadesLog.info("DAOMantenimientoOrdenAnaqueles.cadenaInt(Long[] cadena): Entrada ");
        int i;
        int size = cadena.length;
        StringBuffer sentencia = new StringBuffer("");
        String retorno = "";

        if (size > 0) {
            for (i = 0; i < size; i++) {
                sentencia.append(" ?, ");
            }
            //Quitamos la coma y el espacio del final
            retorno = sentencia.substring(0, sentencia.length() - 2);
        }
        UtilidadesLog.info("DAOMantenimientoOrdenAnaqueles.cadenaInt(Long[] cadena): Salida ");
        return retorno;
    }
    
    /**
     * Obtiene los datos de la entidad OrdenAnaquelesCabecera, marcada como default para el 
     * MapaZonas que se recibe por parámetro. En caso de que no exista, retorna null
     * @author scsaavedra
     * @since 25-01-2007
     */
    public DTOOrdenAnaquelesCabecera obtenerDefaultOrdenAnaqueles(DTOOID dtoE) throws MareException {
        UtilidadesLog.info("DAOMantenimientoOrdenAnaqueles.obtenerDefaultOrdenAnaqueles(DTOOID dtoE): Entrada");
        
        BelcorpService bs = UtilidadesEJB.getBelcorpService();
        StringBuffer query = new StringBuffer();
        
        UtilidadesLog.debug("DTOOID dtoE, es: " + dtoE);

        // Inicio - eliminado eiraola 02/Jul/2007
				//query.append("SELECT ordenCab.OID_ANAQ_CABE, gen.VAL_I18N, ordenCab.COD_MAPA_ORDE, ");
				//query.append("ordenCab.SBAR_OID_SUBL_ARMA, sublinea.LIAR_OID_LINE_ARMA ");
        //query.append("FROM APE_ORDEN_ANAQU_CABEC ordenCab, APE_SUBLI_ARMAD sublinea, v_gen_i18n_sicc gen ");
        //query.append("WHERE ordenCab.MZCA_OID_MAPA_ZONA_CABE = " + dtoE.getOid().longValue());
        //query.append(" AND ordenCab.VAL_DEFE = 1 ");
        //query.append("AND sublinea.OID_SUBL_ARMA = ordenCab.SBAR_OID_SUBL_ARMA ");
        //query.append("AND gen.attr_enti = 'APE_ORDEN_ANAQU_CABEC' ");
        //query.append("AND gen.idio_oid_idio = " + dtoE.getOidIdioma().longValue());
        // Fin - eliminado eiraola 02/Jul/2007
        
        // Inicio - agrega eiraola 02/Jul/2007 (el objetivo de la modificacion es 
        // obtener las descripciones para parametrizar el error de Orden default "duplicado")
        Long oidIdioma = dtoE.getOidIdioma();
        
        //vbongiov -- 31/08/2007
        query.append("SELECT oc.OID_ANAQ_CABE, ");
        query.append("       pq_apl_aux.valor_gen_i18n_sicc("+ oidIdioma 
                                                             +", oc.OID_ANAQ_CABE,"
                                                             +"'APE_ORDEN_ANAQU_CABEC') DESCORDEN, ");
        query.append("       oc.COD_MAPA_ORDE, ");
        query.append("       oc.LIAR_OID_LINE_ARMA, ");
        query.append("       pq_apl_aux.valor_gen_i18n_sicc("+ oidIdioma 
                                                             +", mcd.CCDI_OID_CONF_CENT_DIST, "
                                                             +"'APP_CONFI_CENTR_DISTR') DESCCD, ");
        query.append("       pq_apl_aux.valor_gen_i18n_sicc("+ oidIdioma 
                                                             +", mz.MCDC_OID_MAPA_CENT_DIST_CABE, "
                                                             +"'APE_MAPA_CENTR_DISTR_CABEC') DESCMAPACD, ");
        query.append("       pq_apl_aux.valor_gen_i18n_sicc("+ oidIdioma 
                                                             +", oc.MZCA_OID_MAPA_ZONA_CABE, "
                                                             +"'APE_MAPA_ZONA_CABEC') DESCMAPAZONA ");
        query.append("  FROM APE_ORDEN_ANAQU_CABEC oc, ");
        query.append("       APE_MAPA_ZONA_CABEC mz, ");
        query.append("       APE_MAPA_CENTR_DISTR_CABEC mcd, "); 
        query.append("       APP_CONFI_CENTR_DISTR cd "); 
        query.append(" WHERE oc.MZCA_OID_MAPA_ZONA_CABE = " + dtoE.getOid().longValue());
        query.append("   AND oc.VAL_DEFE = '" + ConstantesAPE.TRUE + "' ");
        query.append("   AND oc.MZCA_OID_MAPA_ZONA_CABE = mz.OID_MAPA_ZONA_CABE ");
        query.append("   AND mz.MCDC_OID_MAPA_CENT_DIST_CABE = mcd.OID_MAPA_CENT_DIST_CABE ");
        query.append("   AND mcd.CCDI_OID_CONF_CENT_DIST = cd.OID_CONF_CENT_DIST ");
        // Fin - agrega eiraola 02/Jul/2007
        
        RecordSet rs = null;
        
        try {
            rs = bs.dbService.executeStaticQuery(query.toString());
        } catch (Exception e) {
            String error = CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS;
            throw new MareException(e, UtilidadesError.armarCodigoError(error));
        }
        
        UtilidadesLog.debug("rs: " + rs);
        
        if ((rs==null) || (rs.getRowCount()<=0)) {
            UtilidadesLog.info("DAOMantenimientoOrdenAnaqueles.obtenerDefaultOrdenAnaqueles(DTOOID dtoE): Salida (vacio)");
            return new DTOOrdenAnaquelesCabecera();
        } else {
            DTOOrdenAnaquelesCabecera dtoCabecera = new DTOOrdenAnaquelesCabecera();
            
            dtoCabecera.setOid(new Long(((BigDecimal)rs.getValueAt(0,"OID_ANAQ_CABE")).toString()));
            //dtoCabecera.setDescOrdenAnaqueles(rs.getValueAt(0,"VAL_I18N").toString());
            dtoCabecera.setDescOrdenAnaqueles((rs.getValueAt(0,"DESCORDEN") != null)? rs.getValueAt(0,"DESCORDEN").toString() : null);
            dtoCabecera.setCodigoMapaOrden(new Long(((BigDecimal)rs.getValueAt(0,"COD_MAPA_ORDE")).toString()));
            dtoCabecera.setValorDefecto(new Boolean(ConstantesAPE.TRUE.toString()));
            
            DTOMapaZonasCabecera dtoMapaZona = new DTOMapaZonasCabecera();
            dtoMapaZona.setOid(dtoE.getOid());
            
            // Descripcion del Mapa de Zona
            Vector descripcionesMapaZonas = new Vector();
            DTOI18nSICC dtoI18n = new DTOI18nSICC();
            dtoI18n.setValorI18n((rs.getValueAt(0,"DESCMAPAZONA") != null)? rs.getValueAt(0,"DESCMAPAZONA").toString() : null);
            descripcionesMapaZonas.add(dtoI18n);
            dtoMapaZona.setDescripcionMapaZonas(descripcionesMapaZonas);
            
            // Descripcion del Mapa CD
            DTOMapaCentroDistribucionCabecera dtoMapaCD = new DTOMapaCentroDistribucionCabecera();
            dtoMapaCD.setDescripcionMapa((rs.getValueAt(0,"DESCMAPACD") != null)? rs.getValueAt(0,"DESCMAPACD").toString() : null);
            
            // Descripcion del Centro de Distribucion
            DTOConfiguracionCentroDistribucion dtoCD = new DTOConfiguracionCentroDistribucion();
            dtoCD.setDescripcion((rs.getValueAt(0,"DESCCD") != null)? rs.getValueAt(0,"DESCCD").toString() : null);
            dtoMapaCD.setCentroDistribucion(dtoCD);
            
            dtoMapaZona.setMapaCentroDistribucionCabecerea(dtoMapaCD);
            dtoCabecera.setMapaZonaCabecera(dtoMapaZona);
            
            DTOLineaArmado dtoLinea = new DTOLineaArmado();
            dtoLinea.setOid(new Long(((BigDecimal)rs.getValueAt(0,"LIAR_OID_LINE_ARMA")).toString()));
            
            DTOSublineaArmado dtoSublinea = new DTOSublineaArmado();
            dtoSublinea.setLineaArmado(dtoLinea);
            
            dtoCabecera.setSublineaArmado(dtoSublinea);
            
            UtilidadesLog.info("DAOMantenimientoOrdenAnaqueles.obtenerDefaultOrdenAnaqueles(DTOOID dtoE): Salida (lleno)");            
            return dtoCabecera;
        }
        
    }    

    /**
     * Recupera los numeros de anaqueles a ordenar para el combo Anaqueles.
     * @author eiraola
     * @since 26-06-2007
     */
    public DTOSalida obtenerNumerosAnaquelesAOrdenar(DTOBuscarAnaqueles dtoE) throws MareException {
        UtilidadesLog.info("DAOMantenimientoOrdenAnaqueles.obtenerNumerosAnaquelesAOrdenar(DTOBuscarAnaqueles dtoE): Entrada");
        
        UtilidadesLog.info(" --- Entrada DTOBuscarAnaqueles dtoE: " + dtoE);
        
        BelcorpService bs = UtilidadesEJB.getBelcorpService();
        StringBuffer query = new StringBuffer();
        DTOSalida dtoSalida = new DTOSalida();
        
				query.append("SELECT OID_MAPA_CENT_DIST_DETA, ");
        query.append("       NUM_ANAQ ");
				query.append("  FROM APE_MAPA_CENTR_DISTR_DETAL mcdd ");
        query.append(" WHERE mcdd.MCDC_OID_MAPA_CENT_DIST_CABE = " + dtoE.getOidMapaCDCabecera());
        query.append("   AND mcdd.SBAR_OID_SUBL_ARMA = " + dtoE.getOidSublinea());
        query.append("   AND (mcdd.IND_EXPA IS NULL OR mcdd.IND_EXPA = 0)");
        query.append(" ORDER BY NUM_ANAQ");
        RecordSet rs = null;
        
        try {
            rs = bs.dbService.executeStaticQuery(query.toString());
        } catch (Exception e) {
            String error = CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS;
            throw new MareException(e, UtilidadesError.armarCodigoError(error));
        }
        
        UtilidadesLog.debug(" --- Salida rs: " + rs);
        
        if (rs.esVacio()) {
            throw new MareException("", UtilidadesError.armarCodigoError(
                ConstantesSEG.MODULO_APE, "", ErroresDeNegocio.APE_0044));
        }
        dtoSalida.setResultado(rs);
        UtilidadesLog.info("DAOMantenimientoOrdenAnaqueles.obtenerNumerosAnaquelesAOrdenar(DTOBuscarAnaqueles dtoE): Salida");
        return dtoSalida;
    }
}
