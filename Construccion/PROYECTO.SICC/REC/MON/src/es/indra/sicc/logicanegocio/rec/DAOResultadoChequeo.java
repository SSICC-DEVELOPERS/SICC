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
import es.indra.sicc.cmn.negocio.comun.DTOComunes.DTOOIDPaginado;
import es.indra.sicc.logicanegocio.ped.ConstantesPED;
import es.indra.sicc.util.BelcorpService;
import es.indra.sicc.util.CodigosError;
import es.indra.sicc.util.DTOBelcorp;
import es.indra.sicc.util.DTOSalida;
import es.indra.sicc.util.UtilidadesEJB;
import es.indra.sicc.util.UtilidadesError;
import es.indra.sicc.util.UtilidadesLog;
import es.indra.sicc.util.UtilidadesPaginacion;
import java.util.Vector;

public class DAOResultadoChequeo  {
    private String usuario;
    public DAOResultadoChequeo() {
    }
    
    public DAOResultadoChequeo(String usuario){
        this.usuario = usuario;
    }
    
    public DTOSalida buscarSolicitudesCliente (DTOOIDPaginado dto) throws MareException{
        UtilidadesLog.info("DAOResultadoChequeo.buscarSolicitudesCliente (DTOOIDPaginado):Entrada");
        UtilidadesLog.debug("Datos entrada: " + dto);
        
        StringBuffer sql = new StringBuffer();
        Vector parametros = new Vector();
        RecordSet rs = null;
        
        sql.append(" SELECT sc.OID_SOLI_CABE as OID, ");
        sql.append(" sc.VAL_NUME_SOLI AS NUMERODOCUMENTO, ");
        sql.append(" sc.FEC_CRON AS FECHAEMISION, ");
        sql.append(" (SELECT idio.VAL_I18N  FROM V_GEN_I18N_SICC idio ");
        sql.append(" WHERE idio.ATTR_ENTI = 'PED_TIPO_SOLIC' ");
        sql.append(" AND idio.IDIO_OID_IDIO = ? ");
        parametros.add(dto.getOidIdioma());
        sql.append(" AND idio.VAL_OID = ts.TSOL_OID_TIPO_SOLI) as TIPOSOLICITUD, ");
        sql.append(" pe.VAL_NOMB_PERI AS PERIODO, ");
        sql.append(" (SELECT idio.VAL_I18N  FROM V_GEN_I18N_SICC idio ");
        sql.append(" WHERE idio.ATTR_ENTI = 'REC_RESUL_CHEQU' ");
        sql.append(" AND idio.IDIO_OID_IDIO = ? ");
        parametros.add(dto.getOidIdioma());
        sql.append(" AND idio.VAL_OID = sc.RECQ_OID_RESU_CHEQ) as REVISION, ");
        sql.append(" sc.VAL_OBSE_REVI AS OBSERVACIONES ");
        sql.append(" FROM PED_SOLIC_CABEC sc, ");
        sql.append(" PED_TIPO_SOLIC_PAIS ts, ");
        sql.append(" CRA_PERIO pe ");
        sql.append(" WHERE ts.OID_TIPO_SOLI_PAIS = sc.TSPA_OID_TIPO_SOLI_PAIS ");
        sql.append(" AND sc.PERD_OID_PERI = pe.OID_PERI ");
        sql.append(" AND sc.CLIE_OID_CLIE = ? ");
        parametros.add(dto.getOid());
        sql.append(" AND sc.IND_TS_NO_CONSO = 0 ");
        sql.append(" AND sc.ESSO_OID_ESTA_SOLI = ? ");
        parametros.add(ConstantesPED.ESTADO_SOLICITUD_VALIDADO);
        sql.append(" AND sc.INRE_OID_INDI_REVI IS NOT NULL ");
        //Modificado por la incidencia BELC300019623 y luego por BELC300019625
        sql.append(" AND sc.RECQ_OID_RESU_CHEQ IS NULL ");
        sql.append(" ORDER BY sc.FEC_CRON ");

        BelcorpService bs = UtilidadesEJB.getBelcorpService();
        String codigoError = null;
        String sqlPaginada = UtilidadesPaginacion.armarQueryPaginacion(sql.toString(),dto);
        
        try {
			rs = bs.dbService.executePreparedQuery(sqlPaginada, parametros);
            UtilidadesLog.debug("Resultado del RecordSet:" + rs);
		} catch (Exception e) {
			UtilidadesLog.error("obtenerMotivosRechazoDesbloqueo: ",e);
            codigoError = CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS;
            throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));
		}
        
        if (rs.esVacio()) {
            // GEN-0007 --> 0005                                                                                  
            UtilidadesLog.debug("****DAOCapturaProcesoReclamos.obtenerClientesREC: No hay datos ");				
            throw new MareException(new Exception(), UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE));           
        }
        
        UtilidadesLog.info("DAOResultadoChequeo.buscarSolicitudesCliente (DTOOIDPaginado):Salida");
        return new DTOSalida(rs);
    }
    
    /**
     * modificado: mmaidana
     * fecha: 24/11/2004
     * Se modifico la query para que filtre por pais y ordenado en forma
     * descendente por INDICADOR.
     * @throws es.indra.mare.common.exception.MareException
     * @return 
     * @param dto
     */
    public DTOSalida obtenerResultadosChequeo (DTOBelcorp dto) throws MareException {
        UtilidadesLog.info("DAOResultadoChequeo.obtenerResultadosChequeo (DTOBelcorp):Entrada");
        
        StringBuffer sql = new StringBuffer();
        Vector parametros = new Vector();
        RecordSet rs = null;
        
        sql.append(" SELECT OID_RESU_CHEQ AS OID, ");
        sql.append(" (SELECT idio.VAL_I18N  FROM V_GEN_I18N_SICC idio ");
        sql.append(" WHERE idio.ATTR_ENTI = 'REC_RESUL_CHEQU' ");
        sql.append(" AND idio.IDIO_OID_IDIO = ? ");
        parametros.add(dto.getOidIdioma());
        sql.append(" AND idio.VAL_OID = OID_RESU_CHEQ) as DESCRIPCION, ");
        sql.append(" IND_RESU AS INDICADOR ");
        sql.append(" FROM REC_RESUL_CHEQU ");
        sql.append(" WHERE PAIS_OID_PAIS = ? ");
        parametros.add(dto.getOidPais());
        sql.append(" ORDER BY INDICADOR DESC");

        BelcorpService bs = UtilidadesEJB.getBelcorpService();
        String codigoError = null;
        
        try {
			rs = bs.dbService.executePreparedQuery(sql.toString(), parametros);
            UtilidadesLog.debug("Resultado del RecordSet:" + rs);
		} catch (Exception e) {
			UtilidadesLog.error("obtenerMotivosRechazoDesbloqueo: ",e);
            codigoError = CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS;
            throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));
		}
        
        UtilidadesLog.info("DAOResultadoChequeo.obtenerResultadosChequeo (DTOBelcorp):Salida");
        return new DTOSalida(rs);
    }

}