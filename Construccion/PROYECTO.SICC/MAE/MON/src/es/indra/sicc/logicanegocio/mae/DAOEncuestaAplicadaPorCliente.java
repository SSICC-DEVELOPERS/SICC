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
import es.indra.sicc.dtos.mae.DTOEncuestaAplicadaPorCliente;
import es.indra.sicc.util.BelcorpService;
import es.indra.sicc.util.CodigosError;
import es.indra.sicc.util.UtilidadesEJB;
import es.indra.sicc.util.UtilidadesError;
import es.indra.sicc.util.UtilidadesLog;
import es.indra.sicc.util.UtilidadesPaginacion;

import java.util.Vector;

/**
 * Sistema:         Belcorp
 * Modulo:          MAE
 * Componente:      DAO's
 * @date:           14/02/2006
 * @autor           Amores Ezequiel Eduardo
 */
public class DAOEncuestaAplicadaPorCliente {
    public DAOEncuestaAplicadaPorCliente() {
    }

    /**
     * Realiza una consulta para obtener los datos de las encuestas aplicadas 
     * de clientes, utilizando los filtros que se pasan como parametro en el 
     * dto.  
     * @return todas las encuestas encontradas, sus columnas son OID, COD_CLIE, 
     * DESC_RESP y DESC_PREG
     * @param los datos para el filtrado incluyendo el idioma (para poder 
     * internacionalizar el texto de las descripciones)
     * @exception MareException
     * 
     * @author Ezequiel Amores
     * @date 13/02/2006
     */
    public RecordSet buscarEncuestasAplicadasPorCliente(DTOEncuestaAplicadaPorCliente DTOE) 
            throws MareException {
        /*---------------  QUERY  ---------------
        SELECT encuesta.OID_ENCU_APLI_CLIE OID, 
               cliente.cod_clie COD_CLIE,
               gen_resp.VAL_I18N DESC_RESP,
               gen_preg.VAL_I18N DESC_PREG 
          FROM MAE_ENCUE_APLIC_CLIEN encuesta,
               MAE_PREGU_ENCUE pregunta, 
               MAE_RESPU_ENCUE respuesta,  
               MAE_CLIEN cliente,
               V_GEN_I18N_SICC gen_resp,
               V_GEN_I18N_SICC gen_preg
         WHERE cliente.OID_CLIE = encuesta.CLIE_OID_CLIE
               AND respuesta.OID_RESP = encuesta.REEN_OID_RESP
               AND pregunta.OID_PREG = respuesta.PREN_OID_PREG
               AND gen_resp.ATTR_ENTI = 'MAE_RESPU_ENCUE' 
               AND gen_preg.ATTR_ENTI = 'MAE_PREGU_ENCUE'  
               AND gen_resp.ATTR_NUM_ATRI = 1 
               AND gen_preg.ATTR_NUM_ATRI = 1            
	           AND respuesta.OID_RESP = gen_resp.VAL_OID
	           AND pregunta.OID_PREG = gen_preg.VAL_OID
	           AND encuesta.CLIE_OID_CLIE = 1465 
               AND encuesta.REEN_OID_RESP = 1001 
               AND pregunta.OID_PREG = 1001
	           AND gen_resp.IDIO_OID_IDIO = 1
               AND gen_preg.IDIO_OID_IDIO = 1
        -------------- FIN QUERY --------------*/
        UtilidadesLog.info("DAOEncuestaAplicadaPorCliente.buscarEncuestasAplicadasPorCliente(DTOEncuestaAplicadaPorCliente DTOE):Entrada");
        RecordSet rs = new RecordSet();
		StringBuffer consulta = new StringBuffer("");
        String consultaPaginacion = new String();
        Vector parametros = new Vector();
        
        consulta.append(" SELECT encuesta.OID_ENCU_APLI_CLIE OID, ");
        consulta.append("        cliente.cod_clie COD_CLIE, ");
        consulta.append("        gen_preg.VAL_I18N DESC_PREG, ");
        consulta.append("        gen_resp.VAL_I18N DESC_RESP ");
        consulta.append("   FROM MAE_ENCUE_APLIC_CLIEN encuesta, ");
        consulta.append("        MAE_PREGU_ENCUE pregunta, ");
        consulta.append("        MAE_RESPU_ENCUE respuesta, ");
        consulta.append("        MAE_CLIEN cliente, ");
        consulta.append("        V_GEN_I18N_SICC gen_resp, ");
        consulta.append("        V_GEN_I18N_SICC gen_preg ");
        consulta.append("  WHERE cliente.OID_CLIE = encuesta.CLIE_OID_CLIE ");
        consulta.append("        AND respuesta.OID_RESP = encuesta.REEN_OID_RESP ");
        consulta.append("        AND pregunta.OID_PREG = respuesta.PREN_OID_PREG");
        consulta.append("        AND gen_resp.ATTR_ENTI = 'MAE_RESPU_ENCUE'  ");
        consulta.append("        AND gen_preg.ATTR_ENTI = 'MAE_PREGU_ENCUE' ");
        consulta.append("        AND gen_resp.ATTR_NUM_ATRI = 1 ");
        consulta.append("        AND gen_preg.ATTR_NUM_ATRI = 1 ");
        consulta.append("        AND respuesta.OID_RESP = gen_resp.VAL_OID ");
        consulta.append("        AND pregunta.OID_PREG = gen_preg.VAL_OID ");
        
        if(DTOE.getOidCliente() != null ) {
            consulta.append("    AND encuesta.CLIE_OID_CLIE = ? ");
            parametros.add(DTOE.getOidCliente());
        }
        
        if(DTOE.getOidRespuesta() != null ) {
            consulta.append("    AND encuesta.REEN_OID_RESP = ? ");
            parametros.add(DTOE.getOidRespuesta());
        }
        
        if(DTOE.getOidPregunta() != null ) {
            consulta.append("    AND pregunta.OID_PREG = ? ");
            parametros.add(DTOE.getOidPregunta());
        }
        
        if(DTOE.getOidIdioma() != null ) {
            consulta.append("    AND gen_resp.IDIO_OID_IDIO = ? ");
            parametros.add(DTOE.getOidIdioma());
            consulta.append("    AND gen_preg.IDIO_OID_IDIO = ? ");
            parametros.add(DTOE.getOidIdioma());
        }  
        
        BelcorpService bs = UtilidadesEJB.getBelcorpService();

        try {
            consultaPaginacion = UtilidadesPaginacion.armarQueryPaginacion(
                consulta.toString(), DTOE);
            rs = bs.dbService.executePreparedQuery(consultaPaginacion, 
                parametros);
            UtilidadesLog.debug(rs.toString());
        } catch (Exception e) {
            String codigoError = CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS;
            this.logSql("DAOEncuestaAplicadaPorCliente.buscarEncuestasAplicadasPorCliente.SQL: ", consultaPaginacion.toString(), parametros);
            UtilidadesLog.error("DAOEncuestaAplicadaPorCliente.buscarEncuestasAplicadasPorCliente: Exception",e);
            throw new MareException(e, 
                UtilidadesError.armarCodigoError(codigoError));
        }
        if (rs.esVacio() || rs.getValueAt(0,0) == null) {
            UtilidadesLog.error("****DAOEncuestaAplicadaPorCliente.buscarEncuestasAplicadasPorCliente: No hay datos ");
            throw new MareException(null, null,                                                            
                UtilidadesError.armarCodigoError(
                    CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE));
        }
        UtilidadesLog.info("DAOEncuestaAplicadaPorCliente.buscarEncuestasAplicadasPorCliente(DTOEncuestaAplicadaPorCliente DTOE):Salida");
        return rs;
    
    }
    
    private void logSql(String metodo, String query, Vector params) {
        UtilidadesLog.info(metodo + query);
        if (params!=null && params.size()>0) {
            String sParams="";
            for (int i=0; i<params.size();i++) {
                sParams+="param "+ (i+1) + ": " + params.elementAt(i) + ", ";
            }
            UtilidadesLog.info(metodo + sParams);
        }
    
    }
    
}