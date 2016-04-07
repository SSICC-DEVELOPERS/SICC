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
import es.indra.sicc.dtos.rec.DTOAutorizacion;
import es.indra.mare.common.mii.services.jdbcservice.RecordSet;
import es.indra.sicc.util.UtilidadesLog;
import es.indra.sicc.util.BelcorpService;
import es.indra.sicc.util.CodigosError;
import es.indra.sicc.util.UtilidadesError;

public class DAOAutorizacion 
{
    public DAOAutorizacion()
    {
    }
    
    /*
     * @ssaavedr, se const. de acuerdo a inc.: BELC300021659
     * Obtiene las entidades Autorizacion que coincidan con los parámetros de la búsqueda
     */
    public RecordSet buscarAutorizaciones(DTOAutorizacion dto) throws MareException {
        UtilidadesLog.info("DAOAutorizacion.buscarAutorizaciones(DTOAutorizacion dto): Entrada");
        
        StringBuffer sql = new StringBuffer();
        RecordSet rs = new RecordSet();
        BelcorpService bs;
        
        sql.append("SELECT * FROM (");
        sql.append("SELECT ROWNUM AS OID, tabla.* FROM (");
        sql.append("SELECT usuario.NAME, operacion.VAL_DESC_LARG, tipoOperacion.VAL_TIPO_OPER , autorizacion.IMP_MAXI, ");
        sql.append("autorizacion.IMP_MONT_MAXI_DIFE, autorizacion.IND_INGR, autorizacion.IND_DESB, ");
        sql.append("usuario.idprincipal, operacion.oid_oper, tipoOperacion.OID_TIPO_OPER, ");
        sql.append("autorizacion.OID_AUTO ");
        // dmorello, 10/07/2006: Se agrega en un campo el total de líneas
        sql.append(", COUNT(*) OVER ( ) AS totalregistros ");
        sql.append("FROM REC_AUTOR autorizacion, REC_TIPOS_OPERA tipoOperacion, REC_OPERA operacion, PRINCIPALS usuario ");
        sql.append("where usuario.IDPRINCIPAL = autorizacion.USER_OID_USER "); 
        sql.append("and tipoOperacion.OID_TIPO_OPER = autorizacion.TIOP_OID_TIPO_OPER "); 
        sql.append("and operacion.OID_OPER = tipoOperacion.ROPE_OID_OPER");
        
        if (dto.getOidPais()!=null) 
        {
            sql.append(" and autorizacion.PAIS_OID_PAIS = " + dto.getOidPais().longValue());    
        }
        if (dto.getOidUsuario()!=null) 
        {
            sql.append(" and autorizacion.USER_OID_USER = " + dto.getOidUsuario().longValue());
        }
        if (dto.getOidTipoOperacion()!=null) 
        {
            sql.append(" and autorizacion.TIOP_OID_TIPO_OPER = " + dto.getOidTipoOperacion().longValue());
        }
        if (dto.getOidOperacion()!=null) 
        {
            sql.append(" and operacion.OID_OPER = " + dto.getOidOperacion().longValue());
        }
        
        sql.append(" ORDER BY NAME ASC, VAL_DESC_LARG ASC, VAL_TIPO_OPER ASC) tabla )");
        sql.append(" WHERE ROWNUM <= " + dto.getTamanioPagina().longValue());
        sql.append(" AND OID > " + dto.getIndicadorSituacion().longValue());
        
        try {
            bs = BelcorpService.getInstance();
        } catch (MareException e) {
            throw new MareException(e,
                UtilidadesError.armarCodigoError(
                    CodigosError.ERROR_AL_PEDIR_UN_SERVICIO_MARE));
        }
                                                                       
         try {
             // dmorello, 06/07/2006: Paso a utilizar la query paginada
             //rs = (RecordSet) bs.dbService.executeStaticQuery(sql.toString());
             rs = bs.dbService.executeStaticQuery(sql.toString());
         }catch (Exception e) {
             throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS));
         }                                                                    
         
        // dmorello, 05/07/2006
        if (rs.esVacio()) {
            Exception e = null;
            throw new MareException(e,
                UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE));
        }
                                                                       
        UtilidadesLog.info("DAOAutorizacion.buscarAutorizaciones(DTOAutorizacion dto): Salida");
        return rs;
        
    }
    
}