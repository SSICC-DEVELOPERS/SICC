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
 *
 */

package es.indra.sicc.logicanegocio.ape;

import es.indra.mare.common.exception.MareException;
import es.indra.mare.common.mii.services.jdbcservice.RecordSet;
import es.indra.sicc.util.BelcorpService;
import es.indra.sicc.util.CodigosError;
import es.indra.sicc.util.UtilidadesEJB;
import es.indra.sicc.util.UtilidadesError;
import es.indra.sicc.util.UtilidadesLog;
import java.math.BigDecimal;


public class DAOEtiquetado {

    /**
     * Recupera la impresora asignada al subacceso y la sublínea
     * recibidos por parámetro.
     * 
     * dmorello, 13/04/2007
     * Se agrega el parametro "impresora", que representa el nº impresora PTL.
     * 
     * @throws es.indra.mare.common.exception.MareException
     * @return OID de la impresora. Si no existe, devuelve null.
     * @param sublinea OID de la sublinea
     * @param subacceso OID del subacceso
     * @author dmorello
     * @since 20-03-2007
     */
    public Long recuperarImpresoraEtiquetado(Long subacceso, Long sublinea, String impresora) throws MareException {
        UtilidadesLog.info("DAOEtiquetado.recuperarImpresoraEtiquetado(Long subacceso, Long sublinea): Entrada");
        
        BelcorpService bs = UtilidadesEJB.getBelcorpService();
        StringBuffer query = new StringBuffer();
        
        /*
         * La siguiente consulta devuelve a lo sumo un registro
         * ya que subacceso y sublínea son UK de APE_ASIGN_IMPRE
         */
        query.append(" SELECT impr.oid_impr ");
        query.append("   FROM fac_impre_virtu impr, ");
        query.append("        ape_asign_impre asign ");
        query.append("  WHERE impr.oid_impr = asign.imvi_oid_impr ");
        /* dmorello, 07/06/2007 */
        //query.append("    AND asign.sbac_oid_sbac = ").append(subacceso);
        query.append("    AND asign.sbar_oid_subl_arma = ").append(sublinea);
        if (impresora != null) {
           query.append(" AND asign.num_impr_ptl =  ").append(impresora);
        // dmorello, 02/08/2007
        //} else {
        //   query.append(" AND asign.num_impr_ptl IS NULL ");
        // Fin dmorello 02/08/2007
        }
        
        RecordSet rs = null;
        try {
            rs = bs.dbService.executeStaticQuery(query.toString());
        } catch (Exception e) {
            String error = CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS;
            throw new MareException(e, UtilidadesError.armarCodigoError(error));
        }
        
        Long oidImpresora = null;
        if (! rs.esVacio()) {
            oidImpresora = new Long(((BigDecimal)rs.getValueAt(0,0)).longValue());
        }
        
        UtilidadesLog.info("DAOEtiquetado.recuperarImpresoraEtiquetado(Long subacceso, Long sublinea): Entrada");
        return oidImpresora;
    }

}