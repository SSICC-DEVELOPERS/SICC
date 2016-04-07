/**
 * Copyright 2003 © por Indra Sistemas,S.A.. Todos los derechos reservados.
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
 
package es.indra.sicc.logicanegocio.ped;

import es.indra.mare.common.exception.MareException;
import es.indra.mare.common.mii.MareMiiServiceNotFoundException;
import es.indra.mare.common.mii.services.jdbcservice.RecordSet;
import es.indra.sicc.dtos.ped.DTOBuscarSeguimientoPedidos;
import es.indra.sicc.dtos.ped.DTOSeguimientoPedidos;
import es.indra.sicc.util.BelcorpService;
import es.indra.sicc.util.CodigosError;
import es.indra.sicc.util.DTOBelcorp;
import es.indra.sicc.util.DTOOIDs;
import es.indra.sicc.util.UtilidadesError;
import es.indra.sicc.util.UtilidadesPaginacion;

import es.indra.sicc.util.UtilidadesLog;

import java.math.BigDecimal;

public class DAOSeguimientoPedidos  {

	private String usuario;
	
	public DAOSeguimientoPedidos(String newusuario) {
		usuario = newusuario;
	}

	private BelcorpService getBelcorpService() throws MareException{

        try {
            BelcorpService bs = BelcorpService.getInstance();
			return bs;
        } catch (MareMiiServiceNotFoundException e) {
            throw new MareException(e,
                UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_PEDIR_UN_SERVICIO_MARE));
        }		
		
	}
	
	public RecordSet obtenerHitosSeguimiento(DTOBelcorp DTOE)
		throws MareException{
        
        UtilidadesLog.info("DAOSeguimientoPedidos.obtenerHitosSeguimiento(DTOBelcorp DTOE): Entrada ");
        RecordSet respuesta;
        StringBuffer query = new StringBuffer();
		
        BelcorpService bs = getBelcorpService();

		try{			
			query.append("  SELECT  hs.oid_hito, i.val_i18n ");
			query.append("    FROM ped_hito_segui hs, v_gen_i18n_sicc i ");
			query.append("   WHERE i.attr_enti = 'PED_HITO_SEGUI' ");
			query.append("     AND i.attr_num_atri = 1 ");
			query.append("     AND i.idio_oid_idio = " + DTOE.getOidIdioma() );
			query.append("     AND hs.oid_hito = i.val_oid ");
			query.append("ORDER BY 2 ");

			respuesta = bs.dbService.executeStaticQuery(query.toString());
        } catch (Exception e) {
            throw new MareException(e,
                UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS));
        }
        UtilidadesLog.info("DAOSeguimientoPedidos.obtenerHitosSeguimiento(DTOBelcorp DTOE): Salida ");
		return respuesta;
	}

	public RecordSet obtenerTiposDocumentoSeguimiento(DTOBelcorp DTOE)
		throws MareException{
        
        UtilidadesLog.info("DAOSeguimientoPedidos.obtenerTiposDocumentoSeguimiento(DTOBelcorp DTOE): Entrada ");
        RecordSet respuesta;
        StringBuffer query = new StringBuffer();
		
        BelcorpService bs = getBelcorpService();

		try{

			query.append("    SELECT tds.oid_tipo, i.val_i18n ");
			query.append("      FROM ped_tipo_docum_segui tds, v_gen_i18n_sicc i ");
			query.append("     WHERE i.attr_enti = 'PED_TIPO_DOCUM_SEGUI' ");
			query.append("       AND i.attr_num_atri = 1 ");
			query.append("       AND i.idio_oid_idio = " + DTOE.getOidIdioma() );
			query.append("       AND tds.oid_tipo = i.val_oid ");
			query.append("  ORDER BY 2 ");

			respuesta = bs.dbService.executeStaticQuery(query.toString());
        } catch (Exception e) {
            throw new MareException(e,
                UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS));
        }
        UtilidadesLog.info("DAOSeguimientoPedidos.obtenerTiposDocumentoSeguimiento(DTOBelcorp DTOE): Salida ");
		return respuesta;		
	}

    /*
    * 12-05-2005 - rgiorgi: cambio en la query.
    * 07/06/2005 - gdmarzi: evaluacion y mejora de la subquery X, no podes ponerle X, por incidenica 18964.
    * 23/06/2005 - pperanzola: se cambia según el diseño de la incidencia BELC300016881
    * 28/06/2005 - pperanzola: se cambia según el diseño de la incidencia BELC300019435
    * 22/07/2005 - ssaavedr: de acuerdo a intercambio de mails con J.Espin, se cambia la consulta.
    * 25/08/2005 - mmaidana: debido a inc. 20759 (con origen en la 19418) se modifica la query.
    * 15/09/2005 - ssaavedr: se agregaron a la consulta filtros de pantalla, pero de manera dual
    *                        o sea para consolidados y solicitudes no consolidadas. 
    */
	public RecordSet buscarSeguimientoPedidos(DTOBuscarSeguimientoPedidos DTOE) throws MareException{
        UtilidadesLog.info("DAOSeguimientoPedidos.buscarSeguimientoPedidos(DTOBuscarSeguimientoPedidos DTOE): Entrada ");
        RecordSet respuesta;
        StringBuffer query = new StringBuffer();
        BelcorpService bs = getBelcorpService();
        
		try{
			query.append("SELECT * From ");
			query.append("(SELECT   x.OID OID, ");
            query.append("(SELECT i2.val_i18n FROM v_gen_i18n_sicc i2 WHERE i2.idio_oid_idio = " + DTOE.getOidIdioma() + " AND i2.attr_enti = 'SEG_CANAL' AND i2.val_oid = x.cana_sol) cana_sol, ");
            query.append("(SELECT i4.val_i18n FROM v_gen_i18n_sicc i4 WHERE i4.idio_oid_idio = " + DTOE.getOidIdioma() + " AND i4.attr_enti = 'SEG_ACCES' AND i4.val_oid = x.acce_sol) acce_sol, ");
            query.append("(SELECT i6.val_i18n FROM v_gen_i18n_sicc i6 WHERE i6.idio_oid_idio = " + DTOE.getOidIdioma() + " AND i6.attr_enti = 'SEG_SUBAC' AND i6.val_oid = x.sbac_sol) sbac_sol, ");
            query.append("x.num_sol, ");
			query.append("(SELECT i1.val_i18n FROM v_gen_i18n_sicc i1 WHERE i1.idio_oid_idio = " + DTOE.getOidIdioma() + " AND i1.attr_enti = 'SEG_CANAL' AND i1.val_oid = x.cana_con) cana_con, ");
            query.append("(SELECT i3.val_i18n FROM v_gen_i18n_sicc i3 WHERE i3.idio_oid_idio = " + DTOE.getOidIdioma() + " AND i3.attr_enti = 'SEG_ACCES' AND i3.val_oid = x.acce_con) acce_con, ");
            query.append("(SELECT i5.val_i18n FROM v_gen_i18n_sicc i5 WHERE i5.idio_oid_idio = " + DTOE.getOidIdioma() + " AND i5.attr_enti = 'SEG_SUBAC' AND i5.val_oid = x.sbac_con) sbac_con, ");
            query.append("x.num_con, ");
            query.append("(SELECT i7.val_i18n FROM v_gen_i18n_sicc i7 WHERE i7.idio_oid_idio = " + DTOE.getOidIdioma() + " AND i7.attr_enti = 'PED_HITO_SEGUI' AND i7.val_oid = x.hito) hito, ");
            query.append("x.fecha, ");
            query.append("x.comp, ");
            query.append("(SELECT i8.val_i18n FROM v_gen_i18n_sicc i8 WHERE i8.idio_oid_idio = " + DTOE.getOidIdioma() + " AND i8.attr_enti = 'PED_TIPO_DOCUM_SEGUI' AND i8.val_oid = oid_tipo_doc) tipo_doc, ");
            query.append("x.oid_con, ");
            query.append("x.oid_sol, ");
            query.append("x.oid_cons, ");
            query.append("x.oid_soli, ");
            query.append("x.oid_tipo_doc ");
            query.append("FROM ");
            query.append("ped_hito_segui h, ");
            query.append("(SELECT segui.oid_segu_pedi OID, con.sbac_oid_sbac sbac_con, ");
                         query.append("sol.sbac_oid_sbac sbac_sol, sol.val_nume_soli, ");
                         query.append("hise_oid_hito hito, segui.fec, segui.ind_comp comp, ");
                         query.append("con.val_nume_soli num_con, sol.val_nume_soli num_sol, ");
                         query.append("segui.fec fecha, a.cana_oid_cana cana_con, ");
                         query.append("sa.acce_oid_acce acce_con, va.cana_oid_cana cana_sol, ");
                         query.append("vsa.acce_oid_acce acce_sol, con.oid_soli_cabe oid_con, ");
                         query.append("sol.oid_soli_cabe oid_sol, ");
                         query.append("segui.soca_oid_soli_cabe oid_soli, ");
                         query.append("segui.soca_oid_cons oid_cons, ");
                         query.append("segui.tdse_oid_tipo oid_tipo_doc, sol.soca_oid_soli_cabe , con.oid_soli_cabe ");
                         query.append("FROM ped_segui_pedid segui, ");
                         query.append("ped_solic_cabec sol, ");
                         query.append("seg_canal c, ");
                         query.append("seg_subac sa, ");
                         query.append("seg_acces a, ");
                         query.append("vca_seg_canal vc, ");
                         query.append("vca_seg_subac vsa, ");
                         query.append("vca_seg_acces va, ");                                               
                         query.append("ped_solic_cabec con ");
                         
                         query.append("WHERE (segui.soca_oid_soli_cabe = sol.oid_soli_cabe ");
                         query.append("OR segui.soca_oid_cons = sol.oid_soli_cabe) ");
                         
                         if (DTOE.getOidPais()!=null){
                             query.append(" AND sol.pais_oid_pais = " + DTOE.getOidPais() );
                         }
                         query.append(" AND sol.soca_oid_soli_cabe = con.oid_soli_cabe (+) ");

                         if (DTOE.getCanal()!=null) {
                             query.append(" AND c.oid_cana (+) = " + DTOE.getCanal());
                         }
                         if (DTOE.getAcceso()!=null) {
                             query.append(" AND a.oid_acce (+) = " + DTOE.getAcceso());
                         }
                         if (DTOE.getSubacceso()!=null){
                             query.append(" AND sa.oid_sbac (+) = " + DTOE.getSubacceso());
                         }                         
                         query.append("AND con.sbac_oid_sbac = sa.oid_sbac (+) "); 
                         query.append("AND sa.acce_oid_acce = a.oid_acce (+) ");
                         query.append("AND a.cana_oid_cana = c.oid_cana (+) ");
                         
                         
                         if (DTOE.getCanal()!=null) {
                             query.append(" AND va.cana_oid_cana = " + DTOE.getCanal());
                         }
                         if (DTOE.getAcceso()!=null) {
                             query.append(" AND vsa.acce_oid_acce = " + DTOE.getAcceso());
                         }
                         if (DTOE.getSubacceso()!=null){
                             query.append(" AND sol.sbac_oid_sbac = " + DTOE.getSubacceso());
                         }                         
                         query.append("AND sol.sbac_oid_sbac = vsa.oid_sbac ");
                         query.append("AND vsa.acce_oid_acce = va.oid_acce ");
                         query.append("AND va.cana_oid_cana = vc.oid_cana ");  
                         
                        
                         if (DTOE.getHito()!=null) {
                             query.append("AND segui.hise_oid_hito = " + DTOE.getHito());
                         }                 
                         
                         if (DTOE.getTipoDocumento()!=null) {
                             query.append(" AND segui.tdse_oid_tipo = " + DTOE.getTipoDocumento());
                         }
                         if (DTOE.getNumeroConsolidado()!=null){
                             query.append(" AND con.val_nume_soli = " + DTOE.getNumeroConsolidado() );
                         }
                         
                         query.append(" AND vc.cod_usua = '" + usuario + "' ");
                         query.append(" AND va.cod_usua = '" + usuario + "' ");
                         query.append(" AND vsa.cod_usua = '" + usuario + "') x ");                         
                         query.append(" WHERE h.oid_hito = x.hito ");
                         query.append(" order by 4,5,6,8,9,10) ");
            
            UtilidadesLog.debug("la consulta resultante, es: " + query.toString());
            
			respuesta = bs.dbService.executeStaticQuery(
  		    UtilidadesPaginacion.armarQueryPaginacion(query.toString(), DTOE));      
        /* 
		try{
			query.append("SELECT x.OID OID,i1.val_i18n desc1, i3.val_i18n desc2 , i5.val_i18n desc3, ");
			query.append("       x.num_sol, i2.val_i18n desc4, i4.val_i18n desc5 , i6.val_i18n desc6, x.num_con, ");
			query.append("       i7.val_i18n, x.fecha, x.comp,x.oid_con, x.oid_sol, X.OID_CONS, X.OID_SOLI, X.OID_TIPO_DOC  ");
			query.append("  FROM v_gen_i18n_sicc i1, ");
			query.append("       v_gen_i18n_sicc i2, ");
			query.append("       v_gen_i18n_sicc i3, ");
			query.append("       v_gen_i18n_sicc i4, ");
			query.append("       v_gen_i18n_sicc i5, ");
			query.append("       v_gen_i18n_sicc i6, ");
            query.append("       v_gen_i18n_sicc i7, ");
			query.append("       ped_hito_segui h, ");
			query.append("       (SELECT segui.oid_segu_pedi OID, con.sbac_oid_sbac sbac_con, ");
			query.append("               sol.sbac_oid_sbac sbac_sol, sol.val_nume_soli, ");
			query.append("               hise_oid_hito hito, segui.fec, segui.ind_comp comp, ");
			query.append("               con.val_nume_soli num_con, sol.val_nume_soli num_sol, ");
			query.append("               segui.fec fecha, a.cana_oid_cana cana_con, ");
			query.append("               sa.acce_oid_acce acce_con, a.cana_oid_cana cana_sol, ");
			query.append("               sa.acce_oid_acce acce_sol, con.oid_soli_cabe oid_con, ");
			query.append("               sol.oid_soli_cabe oid_sol ");
            query.append("               ,SEGUI.SOCA_OID_SOLI_CABE OID_SOLI, SEGUI.SOCA_OID_CONS OID_CONS, SEGUI.TDSE_OID_TIPO OID_TIPO_DOC ");
			query.append("          FROM ped_segui_pedid segui, ");
			query.append("               ped_solic_cabec sol, ");
			query.append("               vca_seg_canal c, ");
			query.append("               vca_seg_subac sa, ");
			query.append("               vca_seg_acces a, ");
			query.append("               ped_solic_cabec con ");
                         
            // pperez 10/12/2004 19:20 inc: 11337
			query.append("         WHERE segui.soca_oid_soli_cabe = sol.oid_soli_cabe ");
            // query.append("         WHERE segui.soca_oid_cons = sol.oid_soli_cabe ");
            
            if (DTOE.getNumeroConsolidado()!=null){
                query.append("           AND con.val_nume_soli = " + DTOE.getNumeroConsolidado() );
            }
            if (DTOE.getOidPais()!=null){
                query.append("           AND sol.pais_oid_pais = " + DTOE.getOidPais() );
            }
            query.append("           AND c.oid_cana = a.cana_oid_cana");
            query.append("           AND con.sbac_oid_sbac = sa.oid_sbac ");
            query.append("           AND sa.acce_oid_acce = a.oid_acce ");
            if (DTOE.getCanal()!=null) {
                query.append("           AND a.cana_oid_cana = "+ DTOE.getCanal());
            }
            if (DTOE.getAcceso()!=null) {
                query.append("           AND sa.acce_oid_acce = "+ DTOE.getAcceso());
            }
            if (DTOE.getSubacceso()!=null){
                query.append("           AND con.sbac_oid_sbac = " + DTOE.getSubacceso());
            }
			query.append("           AND sol.sbac_oid_sbac = sa.oid_sbac ");
			query.append("           AND sa.acce_oid_acce = a.oid_acce ");
            
            // pperez 10/12/2004 19:20 inc: 11337
			query.append("           AND sol.soca_oid_soli_cabe = con.oid_soli_cabe ");
            // query.append("           AND sol.oid_soli_cabe = sol2.soca_oid_soli_cabe ");

            if (DTOE.getHito()!=null) {
                query.append("           AND segui.hise_oid_hito = " + DTOE.getHito());
            }
            if (DTOE.getTipoDocumento()!=null) {
                query.append("           AND segui.tdse_oid_tipo = " + DTOE.getTipoDocumento());
            }
      
			query.append("           AND c.cod_usua = '" + usuario + "' ");
			query.append("           AND a.cod_usua = '" + usuario + "' ");
			query.append("           AND sa.cod_usua = '" + usuario + "') x ");

			query.append(" WHERE h.oid_hito = x.hito ");
            if (DTOE.getOidIdioma()!=null) {
                query.append("   AND i1.idio_oid_idio = " + DTOE.getOidIdioma() );
            }
			query.append("   AND i1.attr_enti = 'SEG_CANAL' ");
			query.append("   AND i1.val_oid = x.cana_con ");
			query.append("   AND i2.attr_enti = 'SEG_CANAL' ");
			query.append("   AND i2.val_oid = x.cana_sol ");
			query.append("   AND i3.attr_enti = 'SEG_ACCES' ");
			query.append("   AND i3.val_oid = x.acce_con ");
			query.append("   AND i4.attr_enti = 'SEG_ACCES' ");
			query.append("   AND i4.val_oid = x.acce_sol ");
			query.append("   AND i5.attr_enti = 'SEG_SUBAC' ");
			query.append("   AND i5.val_oid = x.sbac_con ");
			query.append("   AND i6.attr_enti = 'SEG_SUBAC' ");
			query.append("   AND i6.val_oid = x.sbac_sol ");
            query.append("   AND i7.attr_enti = 'PED_HITO_SEGUI' ");
            query.append("   AND i7.val_oid = x.hito ");
            
            if (DTOE.getOidIdioma()!=null) {
                query.append("   AND i2.idio_oid_idio = " + DTOE.getOidIdioma() );
                query.append("   AND i3.idio_oid_idio = " + DTOE.getOidIdioma() );
                query.append("   AND i4.idio_oid_idio = " + DTOE.getOidIdioma() );
                query.append("   AND i5.idio_oid_idio = " + DTOE.getOidIdioma() );
                query.append("   AND i6.idio_oid_idio = " + DTOE.getOidIdioma() );
                query.append("   AND i7.idio_oid_idio = " + DTOE.getOidIdioma() );
            }
			query.append(" order by 4,5,6,8,9,10 ");

			respuesta = bs.dbService.executeStaticQuery(
				UtilidadesPaginacion.armarQueryPaginacion(query.toString(), DTOE));*/
        } catch (Exception e) {
            throw new MareException(e,
                UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS));
        }
        if(respuesta.esVacio()) {
            String codigoError = CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE;
            throw new MareException(null, null,UtilidadesError.armarCodigoError(codigoError));
        }
        UtilidadesLog.info("DAOSeguimientoPedidos.buscarSeguimientoPedidos(DTOBuscarSeguimientoPedidos DTOE): Salida ");
		return respuesta;	
	}


	public DTOOIDs obtenerHitosPosteriores(DTOSeguimientoPedidos DTOE) 
		throws MareException{
        
        UtilidadesLog.info("DAOSeguimientoPedidos.obtenerHitosPosteriores(DTOSeguimientoPedidos DTOE): Entrada ");
        RecordSet respuesta;
        StringBuffer query = new StringBuffer();
		DTOOIDs salida = new DTOOIDs();
		
        BelcorpService bs = getBelcorpService();

		try{

			query.append("SELECT oid_segu_pedi ");
			query.append("  FROM ped_segui_pedid ");
			query.append(" WHERE soca_oid_soli_cabe = " + DTOE.getSolicitud() );
			query.append("   AND hise_oid_hito > " + DTOE.getHitoSeguimiento() );

			respuesta = bs.dbService.executeStaticQuery(query.toString());

        } catch (Exception e) {
            throw new MareException(e,
                UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS));
        }
            
		if (respuesta.esVacio()==false){
			Long[] oids = new Long[respuesta.getRowCount()];
			
			for (int i=0; i<respuesta.getRowCount(); i++){
				oids[i] = new Long(
					((BigDecimal)respuesta.getValueAt(i,0)).toString());
			}
			salida.setOids(oids);
		}	
        UtilidadesLog.info("DAOSeguimientoPedidos.obtenerHitosPosteriores(DTOSeguimientoPedidos DTOE): Entrada ");
		return salida;
	}
}