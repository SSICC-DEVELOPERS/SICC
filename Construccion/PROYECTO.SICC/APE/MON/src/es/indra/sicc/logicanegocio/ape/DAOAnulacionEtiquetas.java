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
import es.indra.sicc.dtos.ape.DTOBusquedaEtiqueta;
import es.indra.sicc.util.BelcorpService;
import es.indra.sicc.util.CodigosError;
import es.indra.sicc.util.DTOOIDs;
import es.indra.sicc.util.DTOSalida;
import es.indra.sicc.util.UtilidadesEJB;
import es.indra.sicc.util.UtilidadesError;
import es.indra.sicc.util.UtilidadesLog;

public class DAOAnulacionEtiquetas {

    /**
     * Ejecuta una query paginada que devuelve informacion de las etiquetas
     * no anuladas. Si en el dtoE viene un numero de consolidado, filtra las
     * etiquetas por ese numero.
     * @author dmorello
     * @since 22-01-2007
     */
    public DTOSalida buscarEtiquetas(DTOBusquedaEtiqueta dtoE) throws MareException {
        UtilidadesLog.info("DAOAnulacionEtiquetas.buscarEtiquetas(DTOBusquedaEtiqueta dtoE): Entrada");
    
        BelcorpService bs = UtilidadesEJB.getBelcorpService();
        StringBuffer query = new StringBuffer();
        
				//query.append(" SELECT ROWNUM AS OID, datos.* ");
				//query.append("   FROM ( ");
				query.append("     SELECT sol.oid_soli_cabe OID, clie.cod_clie, ");
				query.append("            (SELECT val_i18n ");
				query.append("               FROM v_gen_i18n_sicc ");
				query.append("              WHERE attr_enti = 'SEG_CANAL' ");
				query.append("                AND idio_oid_idio = ");
        query.append(dtoE.getOidIdioma());
				query.append("                AND val_oid = acceso.cana_oid_cana) AS canal, ");
				query.append("            (SELECT val_i18n ");
				query.append("               FROM v_gen_i18n_sicc ");
				query.append("              WHERE attr_enti = 'SEG_ACCES' ");
				query.append("                AND idio_oid_idio = ");
        query.append(dtoE.getOidIdioma());
				query.append("                AND val_oid = acceso.oid_acce) AS acceso, ");
				query.append("            (SELECT val_i18n ");
				query.append("               FROM v_gen_i18n_sicc ");
				query.append("              WHERE attr_enti = 'SEG_SUBAC' ");
				query.append("                AND idio_oid_idio = ");
        query.append(dtoE.getOidIdioma());
				query.append("                AND val_oid = subacceso.oid_sbac) AS subacceso, ");
				query.append("            sol.val_nume_soli, COUNT(*) AS numerocajas ");
				query.append("         FROM ape_etiqu etiqueta, ");
				query.append("            ped_solic_cabec sol, ");
				query.append("            mae_clien clie, ");
				query.append("            seg_subac subacceso, ");
				query.append("            seg_acces acceso ");
				query.append("      WHERE (etiqueta.ind_esta != '");
        query.append(ConstantesAPE.ESTADO_ANULADA).append('\'').append(" OR etiqueta.ind_esta IS NULL) ");
				query.append("        AND etiqueta.soca_oid_soli_cabe = sol.oid_soli_cabe ");
        query.append("        AND sol.pais_oid_pais = ").append(dtoE.getOidPais());
        if (dtoE.getNroSolicCabec() != null) {
            query.append("    AND sol.val_nume_soli = ");
            query.append(dtoE.getNroSolicCabec());
        }
				query.append("        AND sol.clie_oid_clie = clie.oid_clie ");
				query.append("        AND sol.sbac_oid_sbac = subacceso.oid_sbac ");
				query.append("        AND subacceso.acce_oid_acce = acceso.oid_acce ");
        query.append("     GROUP BY sol.oid_soli_cabe, sol.val_nume_soli, clie.cod_clie, ");
        query.append("              acceso.cana_oid_cana, acceso.oid_acce, subacceso.oid_sbac ");
				query.append("     ORDER BY oid, cod_clie, canal, acceso, subacceso, val_nume_soli ");
				//query.append("   ) datos ");
        
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
        UtilidadesLog.info("DAOAnulacionEtiquetas.buscarEtiquetas(DTOBusquedaEtiqueta dtoE): Salida");
        return dtoSalida;
    }
    
    
    /**
     * Anula las etiquetas cuyos OIDs de consolidado vienen por parametro
     * @author dmorello
     * @since 22-01-2007
     */
    public void anularEtiquetas(DTOOIDs dtoE) throws MareException {
        UtilidadesLog.info("DAOAnulacionEtiquetas.anularEtiquetas(DTOOIDs dtoE): Entrada");
    
        Long[] oids = dtoE.getOids();
        StringBuffer update = new StringBuffer();
        BelcorpService bs = UtilidadesEJB.getBelcorpService();
        update.append(" UPDATE APE_ETIQU ");
        update.append(" SET IND_ESTA = '").append(ConstantesAPE.ESTADO_ANULADA).append('\'');
        update.append(" WHERE SOCA_OID_SOLI_CABE IN (");
        for (int i = 0; i < oids.length; ) {
            update.append(oids[i]);
            if (++i < oids.length) {
                update.append(',');
            } else {
                update.append(')');
            }
        }
        try {
            bs.dbService.executeUpdate(update.toString());
        } catch (Exception e) {
            String error = CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS;
            throw new MareException(e, UtilidadesError.armarCodigoError(error));
        }
        
        UtilidadesLog.info("DAOAnulacionEtiquetas.anularEtiquetas(DTOOIDs dtoE): Salida");
    }
    
    
}