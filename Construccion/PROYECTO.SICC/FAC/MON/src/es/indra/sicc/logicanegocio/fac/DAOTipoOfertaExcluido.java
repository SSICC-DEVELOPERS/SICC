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
import es.indra.mare.common.mii.services.jdbcservice.RecordSet;

import es.indra.sicc.dtos.fac.DTOTipoOfertaExcluido;
import es.indra.sicc.util.BelcorpService;
import es.indra.sicc.util.CodigosError;
import es.indra.sicc.util.UtilidadesEJB;
import es.indra.sicc.util.UtilidadesError;
import es.indra.sicc.util.UtilidadesLog;

import es.indra.sicc.util.UtilidadesPaginacion;
import java.sql.Date;

import java.text.SimpleDateFormat;

import java.util.Vector;


public class DAOTipoOfertaExcluido {
    public DAOTipoOfertaExcluido() {
    }

    /**
     * @author Guido Pons
     * @date 03/07/2006
     * @throws es.indra.mare.common.exception.MareException
     * @param dto
     * 
     * Descripción: Obtiene las entidades TipoOfertaExcluido que coincidan con
     * los parámetros de la búsqueda
     * Modificado por sapaza: Para que pueda filtrar cuando envia solo fechaDesde o fechaHasta
     */    
    
    RecordSet buscarTiposOfertaExcluidos(DTOTipoOfertaExcluido dtoEntrada)
        throws MareException {

        UtilidadesLog.info("DAOTipoOfertaExcluido.buscarTiposOfertaExcluidos(DTOTipoOfertaExcluido dtoEntrada): Entrada");
        Vector parametros = new Vector();
        StringBuffer sql = new StringBuffer();
        
        sql.append(" SELECT tipoOferExc.OID_TIPO_OFER_EXCL OID, ");
        sql.append(" tipoOferExc.FEC_DESD, tipoOferExc.FEC_HAST, ");
        sql.append("(SELECT IDIO.val_i18n FROM V_GEN_I18N_SICC IDIO WHERE");
        sql.append(" IDIO.attr_enti = 'SEG_CANAL' AND IDIO.idio_oid_idio = ? ");
        parametros.add(dtoEntrada.getOidIdioma());
        sql.append(" AND IDIO.val_oid = tipoOferta.CANA_OID_CANA) as Canal, ");
        sql.append("(SELECT IDIO.val_i18n FROM V_GEN_I18N_SICC IDIO WHERE");
        sql.append(" IDIO.attr_enti = 'PRE_TIPO_OFERT' AND IDIO.idio_oid_idio = ? ");
        parametros.add(dtoEntrada.getOidIdioma());
        sql.append( " AND IDIO.val_oid = tipoOferExc.TOFE_OID_TIPO_OFER) as tipoOferta,  ");
        sql.append("  tipoOferta.CANA_OID_CANA,");
        sql.append(" tipoOferExc.TOFE_OID_TIPO_OFER");
        sql.append(" FROM  FAC_TIPO_OFERT_EXCLU tipoOferExc, PRE_TIPO_OFERT tipoOferta ");
        sql.append(" WHERE 1=1 ");

        if (dtoEntrada.getOidPais() != null) {
            sql.append(" AND tipoOferExc.PAIS_OID_PAIS = ? ");
            parametros.add(dtoEntrada.getOidPais());
        }

        if (dtoEntrada.getOidTipoOferta() != null) {
            sql.append(" AND tipoOferExc.TOFE_OID_TIPO_OFER = ? ");
            parametros.add(dtoEntrada.getOidTipoOferta());
        }

        sql.append(" AND tipoOferta.OID_TIPO_OFER = tipoOferExc.TOFE_OID_TIPO_OFER ");

        if (dtoEntrada.getOidCanal() != null) {
            sql.append(" AND tipoOferta.CANA_OID_CANA = ? ");
            parametros.add(dtoEntrada.getOidCanal());
        }

        if ((dtoEntrada.getFechaDesde() != null) &&
                (dtoEntrada.getFechaHasta() != null)) {
            Date fechDesde = new java.sql.Date(dtoEntrada.getFechaDesde()
                                                         .getTime());
            Date fechHasta = new java.sql.Date(dtoEntrada.getFechaHasta()
                                                         .getTime());

            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            String fechaDesde = sdf.format(fechDesde);
            String fechaHasta = sdf.format(fechHasta);

            sql.append(" AND tipoOferExc.FEC_DESD  >=  TO_DATE( ? ,'YYYY-MM-DD') ");
            parametros.add(fechaDesde);
            sql.append(" AND tipoOferExc.FEC_HAST  <=  TO_DATE( ? ,'YYYY-MM-DD') ");
            parametros.add(fechaHasta);
        }    
        else //<inicio>Agregado por Sapaza
        {
            if (dtoEntrada.getFechaDesde() != null) {
              Date fechDesde = new java.sql.Date(dtoEntrada.getFechaDesde().getTime());

              SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
              String fechaDesde = sdf.format(fechDesde);
              
              sql.append(" AND tipoOferExc.FEC_DESD  >=  TO_DATE( ? ,'YYYY-MM-DD') ");
              parametros.add(fechaDesde);
            }

            if (dtoEntrada.getFechaHasta() != null) {
              Date fechHasta = new java.sql.Date(dtoEntrada.getFechaHasta().getTime());
              SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
              String fechaHasta = sdf.format(fechHasta);
              
              sql.append(" AND tipoOferExc.FEC_HAST  <=  TO_DATE( ? ,'YYYY-MM-DD') ");
              parametros.add(fechaHasta);
            }
        }//<fin>Agregado por Sapaza

        sql.append(" ORDER BY tipoOferExc.FEC_DESD, tipoOferExc.FEC_HAST  ");
        
        
        String sqlPag = UtilidadesPaginacion.armarQueryPaginacion(sql.toString(), dtoEntrada);

        BelcorpService bs = UtilidadesEJB.getBelcorpService();
        RecordSet rs = null;
        String codigoError = null;

        try {
            rs = bs.dbService.executePreparedQuery(sqlPag, parametros);
        } catch (Exception e) {
            codigoError = CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS;

            //this.logError("obtenerSolicitudesCupon: Exception", e);
            //this.logSql("obtenerSolicitudesCupon. SQL: ", sql.toString(), parametros);
            throw new MareException(e,
                UtilidadesError.armarCodigoError(codigoError));
        }

        UtilidadesLog.debug("rs: " + rs);

        if (rs.esVacio()) {
            UtilidadesLog.debug("****buscarTiposOfertaExcluidos: no hay datos ");
            codigoError = CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE;
            throw new MareException(new Exception(),
                UtilidadesError.armarCodigoError(codigoError));
        }

        UtilidadesLog.info("DAOTipoOfertaExcluido.buscarTiposOfertaExcluidos(DTOTipoOfertaExcluido dtoEntrada): Salida");
        return rs;
    }

    /**
     * @author Guido Pons
     * @date 03/07/2006
     * @throws es.indra.mare.common.exception.MareException
     * @param dto
     * 
     * Descripción: Obtiene las entidades TipoOfertaExcluido que posean igual pais y tipo de oferta,
     * y con fechas solapadas con los datos de entrada
    */
    RecordSet obtenerTipoOferExcluidoFechasSolapadas(
              DTOTipoOfertaExcluido dtoEntrada) throws MareException {

        UtilidadesLog.info("DAOTipoOfertaExcluido.obtenerTipoOferExcluidoFechasSolapadas(DTOTipoOfertaExcluido dtoEntrada): Entrada");

        Vector parametros = new Vector();
        StringBuffer sql = new StringBuffer();

        sql.append("SELECT tipoOferExc.OID_TIPO_OFER_EXCL ");
        sql.append("FROM FAC_TIPO_OFERT_EXCLU tipoOferExc ");
        sql.append("WHERE 1=1 ");

        if (dtoEntrada.getOid() != null) {
            sql.append(" AND tipoOferExc.OID_TIPO_OFER_EXCL <> ? ");
            parametros.add(dtoEntrada.getOid());
        }

        sql.append(" AND tipoOferExc.PAIS_OID_PAIS = ? ");
        parametros.add(dtoEntrada.getOidPais());
        sql.append(" AND tipoOferExc.TOFE_OID_TIPO_OFER = ? ");
        parametros.add(dtoEntrada.getOidTipoOferta());

        if ((dtoEntrada.getFechaDesde() != null) &&
                (dtoEntrada.getFechaHasta() != null)) {

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        
            sql.append(
                " AND tipoOferExc.FEC_DESD  >=  TO_DATE( ? ,'YYYY-MM-DD') ");
            parametros.add(sdf.format(dtoEntrada.getFechaDesde()));
            sql.append(
                " AND tipoOferExc.FEC_HAST  <=  TO_DATE( ? ,'YYYY-MM-DD') ");
            parametros.add(sdf.format(dtoEntrada.getFechaHasta()));
        }

        BelcorpService bs = UtilidadesEJB.getBelcorpService();
        RecordSet rs = null;
        String codigoError = null;

        try {
            rs = bs.dbService.executePreparedQuery(sql.toString(), parametros);
        } catch (Exception e) {
            codigoError = CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS;

            //this.logError("obtenerSolicitudesCupon: Exception", e);
            //this.logSql("obtenerSolicitudesCupon. SQL: ", sql.toString(), parametros);
            throw new MareException(e,
                UtilidadesError.armarCodigoError(codigoError));
        }

        UtilidadesLog.debug("rs: " + rs);

        if (rs.esVacio()) {
            return null;
        }

        UtilidadesLog.info("DAOTipoOfertaExcluido.obtenerTipoOferExcluidoFechasSolapadas(DTOTipoOfertaExcluido dtoEntrada): Salida");
        return rs;
    }
}
