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
import es.indra.sicc.dtos.ape.DTOParamBalanceoAreaChequeo;
import es.indra.sicc.dtos.fac.DTOFACCabeceraSolicitud;
import es.indra.sicc.logicanegocio.mae.ConstantesMAE;
import es.indra.sicc.logicanegocio.ped.ConstantesPED;
import es.indra.sicc.util.BelcorpService;
import es.indra.sicc.util.CodigosError;
import es.indra.sicc.util.DTOOID;
import es.indra.sicc.util.DTOSalida;
import es.indra.sicc.util.UtilidadesEJB;
import es.indra.sicc.util.UtilidadesError;
import es.indra.sicc.util.UtilidadesLog;
import es.indra.sicc.util.UtilidadesPaginacion;

import java.math.BigDecimal;

import java.util.ArrayList;
import java.util.Vector;

public class DAOBalanceoAreaChequeo {

    /**
     * recupera los parametros de balanceo de area de chequeo 
     * @author hhernandez
     * @since 07-02-2007
     */
    public DTOSalida consultarParamBalanceoAreaChequeo(DTOParamBalanceoAreaChequeo  dtoE) throws MareException {
        UtilidadesLog.info("DAOBalanceoAreaChequeo.consultarParamBalanceoAreaChequeo(DTOParamBalanceoAreaChequeo dtoE): Entrada");
        Vector parametros = new Vector();
        StringBuffer query=new StringBuffer();
    
        query.append("		SELECT tsbac.OID_TIPO_SOLI_BALA_AREA_CHEQ AS OID , pbac.OID_PARA_BALA_AREA_CHEQ , pbac.CCDI_OID_CONF_CENT_DIST AS oidCentroDistribucion,");
        query.append("			   (SELECT val_i18n ");
        query.append("				   FROM v_gen_i18n_sicc ");
        query.append("				  WHERE attr_enti = 'APP_CONFI_CENTR_DISTR' ");
        query.append("					AND idio_oid_idio = ");
        query.append(dtoE.getOidIdioma());
        query.append("					AND val_oid = pbac.CCDI_OID_CONF_CENT_DIST) AS centroDistribucion ,");
        
        query.append("				pbac.LIAR_OID_LINE_ARMA AS oidLineaArmado,");
        query.append("			   (SELECT val_i18n ");
        query.append("				   FROM v_gen_i18n_sicc ");
        query.append("				  WHERE attr_enti = 'APE_LINEA_ARMAD' ");
        query.append("					AND idio_oid_idio = ");
        query.append(dtoE.getOidIdioma()); 
        query.append("					AND val_oid = pbac.LIAR_OID_LINE_ARMA) AS lineaArmado, 							");
        
        query.append("				tsbac.TSPA_OID_TIPO_SOLI_PAIS  AS oidTipoSolicitud, ");
        query.append("				pbac.cod_agru,  ");
        query.append("        (SELECT (SELECT val_i18n ");
        query.append("                  FROM v_gen_i18n_sicc ");
        query.append("                 WHERE attr_enti = 'PED_TIPO_SOLIC' ");
        query.append("                   AND idio_oid_idio = " );
        query.append(dtoE.getOidIdioma()); 
        query.append("                   AND val_oid = pedtsolp.tsol_oid_tipo_soli) ");
        query.append("          FROM PED_TIPO_SOLIC_PAIS pedtsolp ");
        query.append("         WHERE pedtsolp.oid_tipo_soli_pais = tsbac.tspa_oid_tipo_soli_pais) AS tiposolicitud, ");
       
        query.append("				pbac.NUM_PEDI_HORA_ARMA AS pedidosArmadoHora, pbac.NUM_UNID_HORA_PERS_CHEQ AS unidadesChequeoHoraPersona,");
        query.append("				pbac.NUM_PARA_DIST AS parametroDistribución  ");
        query.append("				,pbac.num_hora_xdia as hora_dia   ");
        query.append("		FROM APE_PARAM_BALAN_AREA_CHEQU pbac, APE_TIPOS_SOLIC_BALA_AREA_CHEQ tsbac ");
        query.append("		WHERE ");
        query.append("			  pbac.OID_PARA_BALA_AREA_CHEQ = tsbac.PBAC_OID_PARA_BALA_AREA_CHEQ ");
        
        if (dtoE.getOidCentroDistribucion() != null) {
            query.append("			  AND pbac.CCDI_OID_CONF_CENT_DIST = ? ");
            parametros.add(dtoE.getOidCentroDistribucion());
        }
        if (dtoE.getOidLineaArmado() != null) {
            query.append("	     AND  pbac.LIAR_OID_LINE_ARMA = ? ");
             parametros.add(dtoE.getOidLineaArmado());
        }
        
         if (dtoE.getCodAgrupacion() != null) {
            query.append("	     AND  pbac.COD_AGRU = ? ");
             parametros.add(dtoE.getCodAgrupacion());
        }
        
        String sql = UtilidadesPaginacion.armarQueryPaginacion(query.toString(),dtoE);
    
        // Se ejecuta la consulta SQL
        BelcorpService bs = UtilidadesEJB.getBelcorpService();
        RecordSet rs = null;
        String codigoError = null;
        try {
          rs = bs.dbService.executePreparedQuery(sql,parametros);
        } catch (Exception e) {
                codigoError = CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS;
          UtilidadesLog.error("consultarParamBalanceoAreaChequeo: Exception",e);
                 throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));
        }
    
            UtilidadesLog.debug("Se han obtenido: [" + rs.getRowCount() + "] registro(s)");
        // Se crea un DTOSalida a partir del RecordSet
        DTOSalida dtoSalida = new DTOSalida(rs);
      
        UtilidadesLog.info(" DAOBalanceoAreaChequeo.consultarParamBalanceoAreaChequeo(DTOParamBalanceoAreaChequeo dtoe): Salida");		
        return dtoSalida;        
    }
    
    /**
     * recupera los tipos de solicitud relacionados a una linea 
     * @author hhernandez
     * @since 07-02-2007
     */
    public DTOSalida obtenerSolicitudesBalanceoAreaChequeo(DTOParamBalanceoAreaChequeo  dtoE) throws MareException {
        UtilidadesLog.info("DAOBalanceoAreaChequeo.obtenerSolicitudesBalanceoAreaChequeo(DTOParamBalanceoAreaChequeo  dtoE): Entrada");
    
        BelcorpService bs = UtilidadesEJB.getBelcorpService();
        StringBuffer query = new StringBuffer();
        
        query.append("		SELECT tsbac.TSPA_OID_TIPO_SOLI_PAIS AS oid, ");
        query.append("        (SELECT (SELECT val_i18n ");
        query.append("                  FROM v_gen_i18n_sicc ");
        query.append("                 WHERE attr_enti = 'PED_TIPO_SOLIC' ");
        query.append("                   AND idio_oid_idio = "+ dtoE.getOidIdioma()+" "); 
        query.append("                   AND val_oid = pedtsolp.tsol_oid_tipo_soli) ");
        query.append("          FROM PED_TIPO_SOLIC_PAIS pedtsolp ");
        query.append("         WHERE pedtsolp.oid_tipo_soli_pais = tsbac.tspa_oid_tipo_soli_pais) AS tiposolicitud ");
        query.append("		FROM APE_TIPOS_SOLIC_BALA_AREA_CHEQ tsbac ");
        
        if (dtoE.getOidParametros() != null) {
          query.append("		WHERE ");
          query.append("			  tsbac.PBAC_OID_PARA_BALA_AREA_CHEQ = " +dtoE.getOidParametros() + " ");
        }

        RecordSet rs = null;
        try {
            rs = bs.dbService.executeStaticQuery(query.toString());
        } catch (Exception e) {
            String error = CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS;
            throw new MareException(e, UtilidadesError.armarCodigoError(error));
        }
        
        UtilidadesLog.debug("rs: " + rs);
        
        if (rs.esVacio()) {
            String error = CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE;
            throw new MareException("", UtilidadesError.armarCodigoError(error));
        }
        
        DTOSalida dtoSalida = new DTOSalida();
        dtoSalida.setResultado(rs);
        UtilidadesLog.info("DAOBalanceoAreaChequeo.obtenerSolicitudesBalanceoAreaChequeo(DTOParamBalanceoAreaChequeo dtoE): Salida");
        return dtoSalida;
    }
    
    /**
     * Obtiene el indicadores de revisión, de la entidad REC:ClientesAChequear, 
     * para la cabecera de solicitud recibida. Si el cliente tiene más de un indicador 
     * se devuelve el equivalente a "ambas".
     * CU Balanceo área de chequeo
     * @autor eiraola
     * @since 01/Mar/2007
     */
    /*public DTOOID obtenerRevisionClientesAChequear(DTOFACCabeceraSolicitud cabecera) throws MareException {
        UtilidadesLog.info("DAOBalanceoAreaChequeo.obtenerRevisionClientesAChequear(cabecera): Entrada");
            
        BelcorpService bs = UtilidadesEJB.getBelcorpService();
        StringBuffer query = new StringBuffer();
        
        query.append(" select cach.inre_oid_indi_revi ");
        query.append("   from rec_clien_a_chequ cach ");
        query.append("  where cach.perd_oid_peri = " + cabecera.getPeriodo());
        query.append("    and cach.clie_oid_clie = " + cabecera.getOidCliente());
        
        RecordSet rs = null;
        
        try {
            rs = bs.dbService.executeStaticQuery(query.toString());
        } catch (Exception e) {
            throw new MareException(e, UtilidadesError.armarCodigoError(
                CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS));
        }
        
        UtilidadesLog.debug("rs: " + rs);
        int cantReg = rs.getRowCount();
        DTOOID oidRevision = new DTOOID();
        oidRevision.setOid(null);
        
        if (cantReg > 1) {
            oidRevision.setOid(ConstantesPED.OID_REVISION_AMBAS);
        } else if (cantReg == 1) {
            oidRevision.setOid(new Long(((BigDecimal) rs.getValueAt(0, "inre_oid_indi_revi")).longValue()));
        }
        
        UtilidadesLog.debug(" retornamos DTOOID: " + oidRevision);
        UtilidadesLog.info("DAOBalanceoAreaChequeo.obtenerRevisionClientesAChequear(cabecera): Salida");
        return oidRevision;
    }*/

    /**
     * Recupera el indicador de revisión para los consultoras con estatus "Nueva".
     * CU Balanceo área de chequeo
     * @autor eiraola
     * @since 01/Mar/2007
     */
    public DTOOID obtenerRevisionClientesNuevos(DTOFACCabeceraSolicitud cabecera) 
            throws MareException {
        UtilidadesLog.info("DAOBalanceoAreaChequeo.obtenerRevisionClientesNuevos(cabecera): Entrada");
            
        BelcorpService bs = UtilidadesEJB.getBelcorpService();
        StringBuffer query = new StringBuffer();
        
        query.append(" select " + ConstantesPED.OID_REVISION_LINEA + " as OID_REVISION ");
        query.append("   from rec_confi_linea lin ");
        query.append("  where lin.perd_oid_peri = " + cabecera.getPeriodo());
        
        if (cabecera.getOidSubgVentas() != null) {
            query.append("    and lin.zsgv_oid_subg_vent = " + cabecera.getOidSubgVentas());
        }
        if (cabecera.getRegion() != null) {
            query.append("    and (lin.zorg_oid_regi = " + cabecera.getRegion() 
                         + " or lin.zorg_oid_regi is null)");
        }
        if (cabecera.getZona() != null) {
            query.append("    and (lin.zzon_oid_zona = " + cabecera.getZona() 
                         + " or lin.zzon_oid_zona is null)");
        }
        if (cabecera.getSeccion() != null) {
            query.append("    and (lin.zscc_oid_secc = " + cabecera.getSeccion() 
                         + " or lin.zscc_oid_secc is null)");
        }
        query.append("    and lin.ind_cheq_nuev = " + ConstantesAPE.TRUE);
        query.append(" union ");
        query.append(" select " + ConstantesPED.OID_REVISION_CAMPO + " as OID_REVISION ");
        query.append("   from rec_confi_campo cam ");
        query.append("  where cam.perd_oid_peri = " + cabecera.getPeriodo());
        query.append("    and cam.ind_cheq_nuev = " + ConstantesAPE.TRUE);
        
        RecordSet rs = null;
        
        try {
            rs = bs.dbService.executeStaticQuery(query.toString());
        } catch (Exception e) {
            throw new MareException(e, UtilidadesError.armarCodigoError(
                CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS));
        }
        
        UtilidadesLog.debug("rs: " + rs);
        int cantReg = rs.getRowCount();
        DTOOID oidRevision = new DTOOID();
        
        if (cantReg > 1) {
            oidRevision.setOid(ConstantesPED.OID_REVISION_AMBAS);
        } else if (cantReg == 0) {
            oidRevision.setOid(null);
        } else if (cantReg == 1) {
            Long oidTipoRevObtenido = new Long(((BigDecimal) rs.getValueAt(0, "OID_REVISION")).longValue());
            oidRevision.setOid(oidTipoRevObtenido);
            /*if (cabecera.getIndicadorRevision() != null 
                    && !cabecera.getIndicadorRevision().equals(oidTipoRevObtenido)) {
                oidRevision.setOid(ConstantesPED.OID_REVISION_AMBAS);
            } else {
                oidRevision.setOid(oidTipoRevObtenido);
            }*/
        }
        UtilidadesLog.debug(" retornamos oidIndiReviNueva: " + oidRevision.getOid());
        UtilidadesLog.info("DAOBalanceoAreaChequeo.obtenerRevisionClientesNuevos(cabecera): Salida");
        return oidRevision;
    }
    
    /*
     * Verificamos si para el período y la UA corresponde el chequeo en campo.
     * CU Balanceo área de chequeo
     * @autor eiraola
     * @since 01/Mar/2007
     * @observaciones 23/03/2007 Deja de utilizarse por performance.
     */
    /*public DTOOID obtenerRevisionClientesZonaChequeo(DTOFACCabeceraSolicitud cabecera) 
            throws MareException {
        UtilidadesLog.info("DAOBalanceoAreaChequeo.obtenerRevisionClientesZonaChequeo(cabecera): Entrada");
            
        BelcorpService bs = UtilidadesEJB.getBelcorpService();
        StringBuffer query = new StringBuffer();
        
        query.append(" select " + ConstantesPED.OID_REVISION_CAMPO + " as oid_revision_campo ");
        query.append("  from rec_zonas_campo zcc, ");
        query.append("       rec_confi_campo rcc ");
        query.append(" where zcc.cccc_oid_conf_camp = rcc.oid_conf_camp ");
        query.append("   and rcc.perd_oid_peri = " + cabecera.getPeriodo());
        
        if (cabecera.getOidSubgVentas() != null) {
            query.append(" and zcc.zsgv_oid_subg_vent = " + cabecera.getOidSubgVentas());
        }
        if (cabecera.getRegion() != null) {
            query.append(" and zcc.zorg_oid_regi = " + cabecera.getRegion());
        }
        if (cabecera.getZona() != null) {
            query.append(" and zcc.zzon_oid_zona = " + cabecera.getZona());
        }
        if (cabecera.getSeccion() != null) {
            query.append(" and zcc.zscc_oid_secc = " + cabecera.getSeccion());
        }
        
                
        RecordSet rs = null;
        
        try {
            rs = bs.dbService.executeStaticQuery(query.toString());
        } catch (Exception e) {
            throw new MareException(e, UtilidadesError.armarCodigoError(
                CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS));
        }
        
        UtilidadesLog.debug("rs: " + rs);
        int cantReg = rs.getRowCount();
        DTOOID oidRevision = new DTOOID();
        
        if (cantReg >= 1) {
            UtilidadesLog.debug(" cabecera indicadorRevision: " + cabecera.getIndicadorRevision());
            Long oidTipoRevCampo = new Long(((BigDecimal) rs.getValueAt(0, "oid_revision_campo")).longValue());
            
            if (cabecera.getIndicadorRevision() != null 
                    && cabecera.getIndicadorRevision().equals(ConstantesPED.OID_REVISION_LINEA)) {
                oidRevision.setOid(ConstantesPED.OID_REVISION_AMBAS);
            } else {
                oidRevision.setOid(oidTipoRevCampo);
            }
        } else {
            oidRevision.setOid(null);
        }
        
        UtilidadesLog.debug(" retornamos DTOOID: " + oidRevision);
        UtilidadesLog.info("DAOBalanceoAreaChequeo.obtenerRevisionClientesZonaChequeo(cabecera): Salida");
        return oidRevision;
    }*/

    /** 
     * Dado el conjunto de oids de clientes de los consolidados en proceso y su periodo, 
     * se recupera de la entidad 'REC:Clientes a chequear' aquellos oids de consultoras
     * especificadas para chequeo y su indicador a aplicar.
     * La consulta tiene en cuenta que si una consultora tenia mas de un registro 
     * en dicha entidad debe retornarse el valor del oid de indicador 'Ambas'.
     * @author eiraola
     * @date 23/03/2007
     */
    public DTOSalida obtenerClientesAChequear(ArrayList oidsClientes, Long oidPeriodo) throws MareException {
        UtilidadesLog.info("DAOBalanceoAreaChequeo.obtenerClientesAChequear(oidsClientes, oidPeriodo): Entrada");
        DTOSalida clientesAChequear = new DTOSalida();
        BelcorpService bs = UtilidadesEJB.getBelcorpService();
        StringBuffer query = new StringBuffer();
        
        query.append(" select taux.CLIE_OID_CLIE, ");
        query.append("        case when (count(*) > 1) "); // Mas de un registro garantiza 'Ambas' (pues not null y UK)
        query.append("             then " + ConstantesPED.OID_REVISION_AMBAS);
        query.append("             else (select cach.inre_oid_indi_revi ");
        query.append("                     from rec_clien_a_chequ cach ");
        query.append("                    where cach.clie_oid_clie = taux.clie_oid_clie ");
        query.append("                      and cach.perd_oid_peri = "+ oidPeriodo +") ");
        query.append("             end INRE_OID_INDI_REVI ");
        query.append("  from (");
        query.append("        select cac.clie_oid_clie, cac.inre_oid_indi_revi ");
        query.append("          from rec_clien_a_chequ cac ");
        query.append("         where cac.perd_oid_peri = "+ oidPeriodo);
        query.append("           and ( cac.clie_oid_clie in "+ this.armarListaSql("cac.clie_oid_clie", oidsClientes) +" ) ");
        query.append("       ) taux ");
        query.append(" group by taux.clie_oid_clie ");
        
        RecordSet rs = null;
        
        try {
            rs = bs.dbService.executeStaticQuery(query.toString());
        } catch (Exception e) {
            throw new MareException(e, UtilidadesError.armarCodigoError(
                CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS));
        }
        
        clientesAChequear.setResultado(rs);
        
        UtilidadesLog.info("DAOBalanceoAreaChequeo.obtenerClientesAChequear(oidsClientes, oidPeriodo): Salida");
        return clientesAChequear;
    }

    /**
     * Dado el conjunto de oids de clientes de los consolidados que vamos a procesar
     * se recuperan los oids de clientes que corresponden a consultoras con estatus
     * 'Nueva'.
     * @author eiraola
     * @date 23/03/2007
     */
    public DTOSalida obtenerListaConsultorasEstatusNueva(ArrayList oidsCliente) throws MareException {
        UtilidadesLog.info("DAOBalanceoAreaChequeo.obtenerListaConsultorasEstatusNueva(oidsClientes): Entrada");
        DTOSalida consultorasEstatusNueva = new DTOSalida();
        BelcorpService bs = UtilidadesEJB.getBelcorpService();
        StringBuffer query = new StringBuffer();
        
        query.append(" select mda.CLIE_OID_CLIE ");
        query.append("   from mae_clien_datos_adici mda ");
        query.append(" where mda.esta_oid_esta_clie = " + ConstantesMAE.OID_ESTATUS_NUEVA);
        query.append("   and mda.clie_oid_clie in " + this.armarListaSql("mda.clie_oid_clie", oidsCliente));
        
        RecordSet rs = null;
        
        try {
            rs = bs.dbService.executeStaticQuery(query.toString());
        } catch (Exception e) {
            throw new MareException(e, UtilidadesError.armarCodigoError(
                CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS));
        }
        
        consultorasEstatusNueva.setResultado(rs);
        
        UtilidadesLog.info("DAOBalanceoAreaChequeo.obtenerListaConsultorasEstatusNueva(oidsClientes): Salida");
        return consultorasEstatusNueva;
    }

    /**
     * Obtiene la configuracion de Zonas de chequeo en Campo (REC) que determina
     * las UA especificadas para chequear en campo de forma completa.
     * @author eiraola
     * @date 23/03/2007
     */
    public DTOSalida obtenerZonasChequeoEnCampo(Long periodo) throws MareException {
        UtilidadesLog.info("DAOBalanceoAreaChequeo.obtenerZonasChequeoEnCampo(periodo): Entrada");
        DTOSalida zonasChequeoEnCampo = new DTOSalida();
        BelcorpService bs = UtilidadesEJB.getBelcorpService();
        StringBuffer query = new StringBuffer();
        
        query.append("SELECT zcc.OID_ZONA_CAMP, rcc.PERD_OID_PERI, zcc.ZSGV_OID_SUBG_VENT, ");
        query.append("       zcc.ZORG_OID_REGI, zcc.ZZON_OID_ZONA, zcc.ZSCC_OID_SECC ");
        query.append("  FROM rec_zonas_campo zcc, ");
        query.append("       rec_confi_campo rcc ");
        query.append(" WHERE zcc.cccc_oid_conf_camp = rcc.oid_conf_camp ");
        query.append("   AND rcc.perd_oid_peri = " + periodo);
        
        RecordSet rs = null;
        
        try {
            rs = bs.dbService.executeStaticQuery(query.toString());
        } catch (Exception e) {
            throw new MareException(e, UtilidadesError.armarCodigoError(
                CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS));
        }
        
        zonasChequeoEnCampo.setResultado(rs);
        
        UtilidadesLog.info("DAOBalanceoAreaChequeo.obtenerZonasChequeoEnCampo(periodo): Salida");
        return zonasChequeoEnCampo;
    }

    /**
     * Crea una lista SQL fragmentada cada 1000 elementos por restriccion del
     * operador IN.
     * Ej.: (1723, 1728,..... 1999) OR cac.clie_oid_clie IN (322, 4545,.....)
     * @author eiraola
     * @date 23/03/2007
     */
    private StringBuffer armarListaSql(String nombreCampo, ArrayList valoresLista) throws MareException {
        StringBuffer fragmentoQuery = new StringBuffer();
        int cantValores = valoresLista.size();
        
        fragmentoQuery.append("(");
                
        for (int i = 0; i < cantValores; i++) {
            if ( (i+1) < cantValores ) {
                if ((i+1)%1000 == 0) {
                    fragmentoQuery.append(valoresLista.get(i) + ") OR "+ nombreCampo +" IN (");
                } else {
                    fragmentoQuery.append(valoresLista.get(i) + ",");
                }
            } else {
                fragmentoQuery.append(valoresLista.get(i));
            }
        }
        fragmentoQuery.append(")");
        
        return fragmentoQuery;
    }
}