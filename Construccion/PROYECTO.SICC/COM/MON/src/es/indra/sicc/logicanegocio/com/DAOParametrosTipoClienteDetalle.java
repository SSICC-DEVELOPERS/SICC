package es.indra.sicc.logicanegocio.com;

import es.indra.sicc.util.CodigosError;
import es.indra.sicc.util.DTOBelcorp;
import es.indra.sicc.util.UtilidadesError;
import es.indra.sicc.util.UtilidadesLog;
import es.indra.sicc.util.BelcorpService;
import es.indra.sicc.util.UtilidadesEJB;
import es.indra.sicc.util.DTOSalida;

import es.indra.sicc.logicanegocio.seg.ConstantesSEG;

import es.indra.mare.common.exception.MareException;
import es.indra.mare.common.mii.services.jdbcservice.RecordSet;

import es.indra.sicc.dtos.com.DTOTipoClienteComDetalle;

import es.indra.sicc.util.UtilidadesPaginacion;
import java.util.Vector;

/**
 * 
 * @date 
 * @author ciglesias
 */
public class DAOParametrosTipoClienteDetalle
{
    /**
     * 
     * @date 
     */
    public DAOParametrosTipoClienteDetalle()
    {
    }
    
    public DTOSalida obtenerTipoClienteCOMGerente(DTOBelcorp dtoE) throws MareException
    {
    
        /*
            Proceso: 
            ->  Hacer consulta JDBC sobre la tabla TipoClienteComisionesCabecera 
                filtrando por TipoClienteComisionesCabecera.pais = dto.get(pais) 
                y TipoClienteComisionesCabecera.idClasificacion = ConstantesCOM.CODIGO_CLASIFICACION_GERENTE 
                recuperando 
                OID_TIPO_CLIE_COMI_CABE OID y la descripción internacionalizada 
            ->  Devolver RecordSet obtenido encapsulado en un DTOSalida 
        */

		UtilidadesLog.info("DAOParametrosTipoClienteDetalle.obtenerTipoClienteCOMGerente - Entrada");
        UtilidadesLog.debug("DTO ENTRADA" + dtoE);
        
        DTOSalida dtoSalida = new DTOSalida(new RecordSet());
        RecordSet rs = null;
        StringBuffer query = new StringBuffer();
        Vector parameters = new Vector();
        BelcorpService bs = UtilidadesEJB.getBelcorpService();
        String errorCode = null;

        query.append("SELECT val_OID AS OID, idioma.VAL_I18N " +
            "FROM COM_TIPO_CLIEN_COMIS_CABEC c, V_GEN_I18N_SICC idioma " +
            "where idioma.ATTR_ENTI = 'COM_TIPO_CLIEN_COMIS_CABEC'  " +
            "AND idioma.val_oid = c.OID_TIPO_CLIE_COMI_CABE  " +
            "AND idioma.attr_num_atri = 1 " +
            "AND idioma.idio_oid_idio = ? " +
            "AND c.pais_oid_pais = ? AND  c.cod_clas = ? ");

        parameters.add(dtoE.getOidIdioma());
        parameters.add(dtoE.getOidPais());
        parameters.add(ConstantesCOM.CODIGO_CLASIFICACION_GERENTE);
        
        try {
          rs = bs.getInstance().dbService.executePreparedQuery(query.toString(),parameters);
        } catch(Exception e) {
            errorCode = CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS;

			logError("obtenerTipoClienteCOMGerente. Exception: ", e);
            UtilidadesLog.debug("obtenerTipoClienteCOMGerente. SQL: " + query);


            throw new MareException(e, UtilidadesError.armarCodigoError(errorCode));
        }
        
        if (rs != null) {
            dtoSalida = new DTOSalida(rs);
		}

		UtilidadesLog.info("DAOParametrosTipoClienteDetalle.obtenerTipoClienteCOMGerente - Salida");

        return dtoSalida;   
    }
    
    public DTOSalida buscarTipoClienteComDetalle(DTOTipoClienteComDetalle dtoE) throws MareException
    {
        /*
            -> Crear DTOSalida dtoSalida
            
            -> Realizar la siguiente consulta JDBC en la entidad 
                TipoClienteComisionesCabecera (cabecera),
                TipoClienteComisionesDetalle (detalle), 
                i18N, 
                TipoCliente MAE, 
                SubtipoCliente MAE, 
                Clasificacion MAE, 
                TipoClasificacion MAE 
            recuperando 
                detalle.OID, 
                cabecera.IdSubclasificacion,  
                codTipoCliente, 
                codSubtipoCliente, 
                codTipoClasificacion, 
                codClasificacion,  
                detalle.descripcion internacionalizable, 
                oidTipoCliente (oculto), 
                oidSubtipoCliente(oculto), 
                oidTipoClasificacion (oculto), 
                oidClasificacion (oculto) 
            y en donde:
                
                Si dtoE.get(descripcion) != null
                    i18N descripción internacionalizable  = 
                    dtoE.get(descripcion)  (permitir el uso de comodines) 
                fin si
                
                Si dtoE.get(idSubclasificacion) != null 
                    detalle.cabecera = dtoE.get(idSubclasificacion)
                fin si
            
                Si dtoE.get(oidTipoCliente) != null  
                    tipoCliente = dtoE.get(oidTipoCliente)
                fin si
                
                Si   dtoE.get(oidSubtipoCliente) != null 
                    subtipoCliente = dtoE.get(oidSubtipoCliente) || 
                    subtipoCliente == null
                fin si
                
                Si   dtoE.get(oidTipoClasificacion) != null 
                    tipoClasificacion = dtoE.get(oidTipoClasificaion) || 
                    tipoClasificacion == null
                fin si
            
                Si   dtoE.get(oidClasificacion) != null 
                    clasificacion = dtoE.get(oidClasificaion) || 
                    clasificacion == null
                fin si
                
            -> Si hay registros
                --> setear el resultado de la consulta a dtoSalida
            -> Sino
                --> Lanzar MareException con mensaje de error 
                    COM-0018 "No existen registros para los criterios de 
                                búsqueda utilizados."
            ->Fin si  
            
            ->Retornar dtoSalida  
            
        */
         
		UtilidadesLog.info("DAOParametrosTipoClienteDetalle.buscarTipoClienteComDetalle - Entrada");
        UtilidadesLog.debug("DTO ENTRADA" + dtoE);
        
        DTOSalida dtoSalida = new DTOSalida(new RecordSet());
        RecordSet rs = null;
        StringBuffer query = new StringBuffer();
        Vector parameters = new Vector();
        BelcorpService bs = UtilidadesEJB.getBelcorpService();
        String errorCode = null;

         /*query.append(" SELECT d.oid_tipo_clie_comi_deta AS OID, " +
            " idioma.VAL_I18N AS SUBCLASIFICACION, " +
            " t.cod_tipo_clie AS COD_TIPO_CLIE, " +
            " s.cod_subt_clie AS COD_SUBT_CLIE, " + 
            " tc.cod_tipo_clas AS COD_TIPO_CLAS, clas.cod_clas AS COD_CLAS, " +
            " i18n.val_i18n AS DESCRIPCION, t.oid_tipo_clie AS OID_TIPO_CLIE, s.oid_subt_clie AS OID_SUBT_CLIE, " +
            " tc.oid_tipo_clas AS OID_TIPO_CLAS, clas.oid_clas AS OID_CLAS, " +
            " d.tccc_oid_tipo_clie_comi_cabe AS IdSubclasificacion " +
            " FROM mae_subti_clien s, " +
            " com_tipo_clien_comis_detal d, mae_tipo_clien t, mae_clasi clas, " +
            " V_GEN_I18N_SICC idioma, " +
            " mae_tipo_clasi_clien tc, v_gen_i18n_sicc i18n " +
            " WHERE d.tccl_oid_tipo_clas = tc.oid_tipo_clas(+) " +
            " AND d.clas_oid_clas = clas.oid_clas(+) " +
            " AND d.sbti_oid_subt_clie = s.oid_subt_clie(+) " +
            " AND d.ticl_oid_tipo_clie = t.oid_tipo_clie " +
            " AND i18n.attr_enti = 'COM_TIPO_CLIEN_COMIS_DETAL' " +
            " AND i18n.VAL_OID = d.oid_tipo_clie_comi_deta " +
            " AND i18n.idio_oid_idio = " + dtoE.getOidIdioma() +
			      " AND i18n.ATTR_NUM_ATRI = 1 " +
            " AND idioma.ATTR_ENTI = 'COM_TIPO_CLIEN_COMIS_CABEC' " +
            " AND idioma.val_oid = d.TCCC_OID_TIPO_CLIE_COMI_CABE " +
            " AND idioma.attr_num_atri = 1 " +
            " AND idioma.idio_oid_idio = " + dtoE.getOidIdioma() );*/
        
        
        /*  pperez 25/09/06   --  */
        query.append("   SELECT d.oid_tipo_clie_comi_deta AS OID, idioma.val_i18n AS subclasificacion,   ");
        query.append("          desctc.desc_tipo_clien AS cod_tipo_clie, descstc.desc_sub_tipo_clie AS cod_subt_clie,  ");
        query.append("          desctcl.desc_tipo_clasi AS cod_tipo_clas, descclasi.desc_clasi AS cod_clas,  ");
        query.append("          i18n.val_i18n AS descripcion, desctc.oidtipocliente AS oid_tipo_clie,  ");
        query.append("          descstc.oidsubtipoclie AS oid_subt_clie, desctcl.oidtipoclasi AS oid_tipo_clas,  ");
        query.append("          descclasi.oidclasi AS oid_clas,  ");
        query.append("          d.tccc_oid_tipo_clie_comi_cabe AS idsubclasificacion  ");
        query.append("     FROM COM_TIPO_CLIEN_COMIS_DETAL d,  ");
        query.append("          v_gen_i18n_sicc idioma,  ");
        query.append("          v_gen_i18n_sicc i18n,  ");
        query.append("   	   (SELECT t.OID_TIPO_CLIE AS oidtipocliente,  ");
        query.append("                            i18n.val_i18n AS desc_tipo_clien  ");
        query.append("                       FROM mae_tipo_clien t, v_gen_i18n_sicc i18n  ");
        query.append("                      WHERE i18n.attr_enti = 'MAE_TIPO_CLIEN'  ");
        query.append("                        AND i18n.attr_num_atri = 1  ");
        query.append("                        AND i18n.idio_oid_idio = 1  ");
        query.append("                        AND i18n.val_oid = t.OID_TIPO_CLIE) desctc,  ");
        query.append("   	   (SELECT s.oid_subt_clie AS oidsubtipoclie,  ");
        query.append("                            i18n.val_i18n AS desc_sub_tipo_clie  ");
        query.append("                       FROM mae_subti_clien s, v_gen_i18n_sicc i18n  ");
        query.append("                      WHERE i18n.attr_enti = 'MAE_SUBTI_CLIEN'  ");
        query.append("                        AND i18n.attr_num_atri = 1  ");
        query.append("                        AND i18n.idio_oid_idio = 1  ");
        query.append("                        AND i18n.val_oid = s.oid_subt_clie) descstc,  ");
        query.append("   	   (SELECT tc.oid_tipo_clas AS oidtipoclasi,  ");
        query.append("                            i18n.val_i18n AS desc_tipo_clasi  ");
        query.append("                       FROM mae_tipo_clasi_clien tc, v_gen_i18n_sicc i18n  ");
        query.append("                      WHERE i18n.attr_enti = 'MAE_TIPO_CLASI_CLIEN'  ");
        query.append("                        AND i18n.attr_num_atri = 1  ");
        query.append("                        AND i18n.idio_oid_idio = 1  ");
        query.append("                        AND i18n.val_oid = tc.OID_TIPO_CLAS) desctcl,  ");
        query.append("   	   (SELECT clas.oid_clas AS oidclasi,  ");
        query.append("                            i18n.val_i18n AS desc_clasi  ");
        query.append("                       FROM mae_clasi clas, v_gen_i18n_sicc i18n  ");
        query.append("                      WHERE i18n.attr_enti = 'MAE_CLASI'  ");
        query.append("                        AND i18n.attr_num_atri = 1  ");
        query.append("                        AND i18n.idio_oid_idio = 1  ");
        query.append("                        AND i18n.val_oid = clas.oid_clas) descclasi	");
        query.append("    WHERE d.tccl_oid_tipo_clas = desctcl.oidtipoclasi(+)  ");
        query.append("      AND d.clas_oid_clas = descclasi.oidclasi(+)  ");
        query.append("      AND d.sbti_oid_subt_clie = descstc.oidsubtipoclie(+)  ");
        query.append("      AND d.ticl_oid_tipo_clie = desctc.oidtipocliente (+)  ");
        query.append("      AND i18n.attr_enti = 'COM_TIPO_CLIEN_COMIS_DETAL'  ");
        query.append("      AND i18n.val_oid = d.oid_tipo_clie_comi_deta  ");
        query.append("      AND i18n.idio_oid_idio = 1  ");
        query.append("      AND i18n.attr_num_atri = 1  ");
        query.append("      AND idioma.attr_enti = 'COM_TIPO_CLIEN_COMIS_CABEC'  ");
        query.append("      AND idioma.val_oid = d.tccc_oid_tipo_clie_comi_cabe  ");
        query.append("      AND idioma.attr_num_atri = 1  ");
        query.append("      AND idioma.idio_oid_idio = 1  ");

        if (dtoE.getDescripcion() != null) {
            query.append(" AND i18n.val_i18n like ? ");
            parameters.add("%" + dtoE.getDescripcion() + "%");
        }
        
        if (dtoE.getIdSubclasificacion() != null) {
            query.append(" AND d.TCCC_OID_TIPO_CLIE_COMI_CABE = ? ");
            parameters.add(dtoE.getIdSubclasificacion());
        }

        if (dtoE.getOidTipoCliente() != null) {
            query.append(" AND d.ticl_oid_tipo_clie = ? ");
            parameters.add(dtoE.getOidTipoCliente());
        }

        if (dtoE.getOidSubtipoCliente() != null) {
            query.append(" AND d.sbti_oid_subt_clie = ? ");
            parameters.add(dtoE.getOidSubtipoCliente());
        }

        if (dtoE.getOidTipoClasificacion() != null) {
            query.append(" AND d.tccl_oid_tipo_clas = ? ");
            parameters.add(dtoE.getOidTipoClasificacion());
        }

        if (dtoE.getOidClasificacion() != null) 
        {
            query.append(" AND d.clas_oid_clas = ? ");
            parameters.add(dtoE.getOidClasificacion());
        }

    UtilidadesLog.debug("QUERY" + query);
		String sql = UtilidadesPaginacion.armarQueryPaginacion(query.toString(), dtoE);
    UtilidadesLog.debug("SQL despues de paginacion" + sql.toString());    
        try {
            rs = bs.dbService.executePreparedQuery(sql, parameters);
        } catch(Exception e) {
            errorCode = CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS;

			logError("obtenerTipoClienteCOMGerente. Exception: ", e);
			logSql("obtenerTipoClienteCOMGerente. SQL: ", sql, parameters);

            throw new MareException(e, UtilidadesError.armarCodigoError(errorCode));                        
        }
        
        if (rs.esVacio() || rs.getValueAt(0,0) == null || rs == null) {

          UtilidadesLog.info("***************************************************************************");
          UtilidadesLog.info("DAOParametrosTipoClienteDetalle.buscarTipoClienteComDetalle - Sin registros");
          UtilidadesLog.info("***************************************************************************");

          throw new MareException(new Exception(), 
                  UtilidadesError.armarCodigoError(
                      ConstantesSEG.MODULO_COM, "", 
                      ErroresDeNegocio.COM_0018));            
        }

        dtoSalida = new DTOSalida(rs);

		UtilidadesLog.info("DAOParametrosTipoClienteDetalle.buscarTipoClienteComDetalle - Salida");

        return dtoSalida; 
    }
   
    private void logError(String mensaje,Throwable e) {
		UtilidadesLog.error("*** Error método " + mensaje + ": " + e.getMessage() + " ***");
		UtilidadesLog.error(e);
	}
    
    private void logSql(String metodo, String sql, Vector parameters){
		UtilidadesLog.debug(metodo + sql);
        
		if (parameters != null && parameters.size() > 0) {
			String parametersValues = "";
			
            for (int i=0; i<parameters.size();i++){
				parametersValues += "parámetro " + (i + 1) + ": " + parameters.elementAt(i) + ", ";
			}

			UtilidadesLog.debug(metodo + parametersValues);
		}
	}
}

