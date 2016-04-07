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

package es.indra.sicc.logicanegocio.mae;

import es.indra.mare.common.exception.MareException;
import es.indra.mare.common.mii.services.jdbcservice.RecordSet;
import es.indra.sicc.util.BelcorpService;
import es.indra.sicc.util.CodigosError;
import es.indra.sicc.util.DTOBelcorp;
import es.indra.sicc.util.DTOOID;
import es.indra.sicc.util.DTOSalida;
import es.indra.sicc.util.UtilidadesEJB;
import es.indra.sicc.util.UtilidadesError;
import es.indra.sicc.util.UtilidadesLog;

import java.util.Vector;

/**
 * Sistema:         Belcorp
 * Modulo:          MAE
 * Componente:      DAO's
 * Fecha:           10/02/2006
 * Observaciones:     
 * @autor           Ariel D.
 */
public class DAOMAEParametrizacionMaestroClientes  {
        
    // Constructores
    public DAOMAEParametrizacionMaestroClientes() {
    }

    // Metodos
    /**
     * Obtiene los oids (OID) y textos descriptivos (DESC_PREG) de las preguntas 
     * de encuestas.  
     * @return un DTOSalida que contiene a su vez el RecordSet de la consulta
     * @param un DTOBelcorp con el pais e idioma (este ultimo debe estar 
     * presentepara poder internacionalizar el texto de la pregunta)
     * @exception MareException
     * 
     * @author Emilio Iraola
     * @date 13/02/2006
     */
    DTOSalida obtenerPreguntasEncuesta(DTOBelcorp dto) throws MareException {
        UtilidadesLog.info("DAOMAEParametrizacionMaestroClientes.obtenerPreguntasEncuesta(DTOBelcorp dto):Entrada");
        RecordSet rs = new RecordSet();
		StringBuffer consulta = new StringBuffer("");
        DTOSalida dtoS = new DTOSalida();
        
        consulta.append(" SELECT preg.OID_PREG OID, ");
        consulta.append("        gen_preg.VAL_I18N DESC_PREG ");
        consulta.append(" FROM MAE_PREGU_ENCUE preg, ");
        consulta.append("      V_GEN_I18N_SICC gen_preg ");
        consulta.append(" WHERE preg.OID_PREG = gen_preg.VAL_OID AND ");
        consulta.append("       gen_preg.ATTR_ENTI = 'MAE_PREGU_ENCUE' AND ");
        consulta.append("       gen_preg.ATTR_NUM_ATRI = 1 AND ");
        if (dto.getOidIdioma() != null) {
            consulta.append("   gen_preg.IDIO_OID_IDIO = " + dto.getOidIdioma() 
                        + " ");
        }
        
        BelcorpService bs = UtilidadesEJB.getBelcorpService();
        
        try {
            rs = bs.dbService.executeStaticQuery(consulta.toString());
        
        } catch (Exception e) {
            UtilidadesLog.error("obtenerPreguntasEncuesta: Exception",e);
            String codigoError = CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS;
            throw new MareException(e, 
                UtilidadesError.armarCodigoError(codigoError));						
        } 
    
        if (!rs.esVacio()){
            dtoS.setResultado(rs);
        } else {
            UtilidadesLog.error("obtenerPreguntasEncuesta: ResultSet VACIO");
            throw new MareException(null, null, 
                 UtilidadesError.armarCodigoError(
                     CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE));
        }        

        UtilidadesLog.info("DAOMAEParametrizacionMaestroClientes.obtenerPreguntasEncuesta(DTOBelcorp dto):Salida");
        return dtoS;
    }

    /**
     * Obtiene los oids (OID) y textos descriptivos (DESC_RESP) de las 
     * respuestas de una pregunta cuyo oid se pasa como parametro.  
     * @return un DTOSalida que contiene a su vez el RecordSet de la consulta
     * @param un DTOOID con el idioma (para internacionalizar) y con el oid
     * de la pregunta cuyas respuestas se desean obtener (filtro)
     * @exception MareException
     * 
     * @author Emilio Iraola
     * @date 13/02/2006
     */
    DTOSalida obtenerRespuestasPorPregunta(DTOOID dto) throws MareException {
        UtilidadesLog.info("DAOMAEParametrizacionMaestroClientes.obtenerRespuestasPorPregunta(DTOOID dto):Entrada");
        RecordSet rs = new RecordSet();
		StringBuffer consulta = new StringBuffer("");
        DTOSalida dtoS = new DTOSalida();
        
        consulta.append(" SELECT resp.OID_RESP OID, ");
        consulta.append("        gen_resp.VAL_I18N DESC_RESP ");
        consulta.append(" FROM MAE_RESPU_ENCUE resp, ");
        consulta.append("      V_GEN_I18N_SICC gen_resp ");
        consulta.append(" WHERE resp.OID_RESP = gen_resp.VAL_OID AND ");
        consulta.append("       gen_resp.ATTR_ENTI = 'MAE_RESPU_ENCUE' AND ");
        consulta.append("       gen_resp.ATTR_NUM_ATRI = 1 ");    
        
        // filtro las respuestas por el oid de pregunta dado
        if (dto.getOid() != null) {
            consulta.append("   AND resp.PREN_OID_PREG = " + dto.getOid() + " ");
        }
        // filtro las respuestas por el idioma dado
        if (dto.getOidIdioma() != null) {
            consulta.append("   AND gen_resp.IDIO_OID_IDIO = " 
                + dto.getOidIdioma() + " ");
        }
        
        BelcorpService bs = UtilidadesEJB.getBelcorpService();
        
        try {
            rs = bs.dbService.executeStaticQuery(consulta.toString());
        
        } catch (Exception e) {
            UtilidadesLog.error("obtenerRespuestasPorPregunta: Exception",e);
            String codigoError = CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS;
            throw new MareException(e, 
                UtilidadesError.armarCodigoError(codigoError));						
        } 
    
        if (!rs.esVacio()){
            dtoS.setResultado(rs);
        } else {
            UtilidadesLog.error("obtenerRespuestasPorPregunta: ResultSet VACIO");
            throw new MareException(null, null, 
                 UtilidadesError.armarCodigoError(
                     CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE));
        }        

        UtilidadesLog.info("DAOMAEParametrizacionMaestroClientes.obtenerRespuestasPorPregunta(DTOOID dto):Salida");
        return dtoS;
    } 

}