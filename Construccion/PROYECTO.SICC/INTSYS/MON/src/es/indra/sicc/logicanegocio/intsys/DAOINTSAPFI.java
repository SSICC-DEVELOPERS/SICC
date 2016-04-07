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
package es.indra.sicc.logicanegocio.intsys;


import es.indra.mare.common.exception.MareException;
import es.indra.mare.common.mii.services.jdbcservice.RecordSet;
import es.indra.sicc.dtos.intsys.DTOParametrosContablesFAC;
import es.indra.sicc.util.BelcorpService;
import es.indra.sicc.util.CodigosError;
import es.indra.sicc.util.DTOSalida;
import es.indra.sicc.util.UtilidadesEJB;
import es.indra.sicc.util.UtilidadesError;
import es.indra.sicc.util.UtilidadesLog;
import es.indra.sicc.util.UtilidadesPaginacion;

public class DAOINTSAPFI {

    public DAOINTSAPFI() { }
    
    /**
     * Creado por incidencia DBLG500001104
     * @author dmorello
     * @since 14-09-2006
     */
    public DTOSalida obtenerImportesContablesFAC() throws MareException {
        UtilidadesLog.info("DAOINTSAPFI.obtenerImportesContablesFAC(): Entrada");
        
        BelcorpService bs =UtilidadesEJB.getBelcorpService();
        RecordSet rs = null;
        
        StringBuffer query = new StringBuffer();
        
        query.append(" SELECT OID_IMPO_CONT_FACT, COD_IMPO_CONT ");
        query.append(" FROM INT_IMPOR_CONTA_FACTU ");
        query.append(" ORDER BY COD_IMPO_CONT ASC ");
        
        try {
            rs = bs.dbService.executeStaticQuery(query.toString());
        } catch (Exception e) {
            throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS));
        }
    
        UtilidadesLog.debug("rs: " + rs);
    
        DTOSalida dtoSalida = new DTOSalida();
        dtoSalida.setResultado(rs);
      
        UtilidadesLog.info("DAOINTSAPFI.obtenerImportesContablesFAC(): Entrada");
        return dtoSalida;
    }
    
    /**
     * Creado por incidencia DBLG500001104
     * @author dmorello
     * @since 14-09-2006
     */
    public DTOSalida buscarParametrosContablesFAC(DTOParametrosContablesFAC dtoE) throws MareException {
        UtilidadesLog.info("DAOINTSAPFI.buscarParametrosContablesFAC(DTOParametrosContablesFAC dtoE): Entrada");
        
        BelcorpService bs = UtilidadesEJB.getBelcorpService();
        StringBuffer query = new StringBuffer();
        RecordSet rs = null;
        
        
        query.append(" SELECT * FROM ( ");
        query.append(" SELECT ROWNUM OID, tabla.* ");
        query.append(" FROM ( ");
        query.append(" SELECT ");
        query.append("   pcf.OID_PARA_CONT_FACT, ");
        query.append("   pcf.COD_APUN, ");
        query.append("   pcf.VAL_TIPO_ASIE, ");
        query.append("   pcf.VAL_IDEN_CABE_DETA, ");
        query.append("   pcf.VAL_DESC, ");
        query.append("   pcf.VAL_GRUP_ARTI, ");
        query.append("   pcf.VAL_INDI_DEBE_HABE, ");
        query.append("   pcf.CUCO_OID_CUEN_CONT, ");
        query.append("   (SELECT val_i18n ");
        query.append("      FROM v_gen_i18n_sicc ");
        query.append("     WHERE idio_oid_idio = " +dtoE.getOidIdioma());
        query.append("       AND attr_enti = 'CCC_CUENT_CONTA' ");
        query.append("       AND val_oid = pcf.CUCO_OID_CUEN_CONT) AS CUENTA_CONTABLE, ");
        query.append("   pcf.IMCF_OID_IMPO_CONT_FACT, ");
        query.append("   icf.COD_IMPO_CONT, ");
        query.append("   pcf.MAPR_OID_MARC_PROD, ");
        query.append("   smp.DES_MARC_PROD, ");
        query.append("   pcf.NEGO_OID_NEGO, ");
        query.append("   (SELECT val_i18n ");
        query.append("      FROM v_gen_i18n_sicc ");
        query.append("     WHERE idio_oid_idio = " + dtoE.getOidIdioma());
        query.append("       AND attr_enti = 'MAE_NEGOC' ");
        query.append("       AND val_oid = pcf.NEGO_OID_NEGO) AS NEGOCIO, ");
        query.append("   pcf.PAIS_OID_PAIS, ");
        query.append("   pcf.PROD_OID_PROD, ");
        query.append("   produ.COD_SAP, ");
        query.append("   COUNT(*) OVER() AS TOTAL_LINEAS ");
        query.append(" FROM ");
        query.append("   INT_PARAM_CONTA_FACTU pcf, ");
        query.append("   INT_IMPOR_CONTA_FACTU icf, ");
        query.append("   SEG_MARCA_PRODU smp, ");
        query.append("   MAE_NEGOC nego, ");
        query.append("   MAE_PRODU produ ");
        query.append(" WHERE pcf.IMCF_OID_IMPO_CONT_FACT = icf.OID_IMPO_CONT_FACT ");
        query.append("   AND pcf.MAPR_OID_MARC_PROD = smp.OID_MARC_PROD(+) ");
        query.append("   AND pcf.NEGO_OID_NEGO = nego.OID_NEGO(+) ");
        query.append("   AND pcf.PROD_OID_PROD = produ.OID_PROD(+) ");
        
        if (dtoE.getCodApunte() != null) {
            // splatas - DBLG700000162 - 27/10/2006
            //query.append("   AND pcf.COD_APUN = " + dtoE.getCodApunte());
            query.append("   AND pcf.COD_APUN LIKE '" + dtoE.getCodApunte() + "\' ");
        }
        if (dtoE.getTipoAsiento() != null) {
            query.append("   AND pcf.VAL_TIPO_ASIE = '" + dtoE.getTipoAsiento() + '\'');
        }
        if (dtoE.getCabeceraDetalle() != null) {
            query.append("   AND pcf.VAL_IDEN_CABE_DETA = '" + dtoE.getCabeceraDetalle() + '\'');
        }
        if (dtoE.getDescripcion() != null) {
            //DBLG700000124 - gPineda - 12/10/2006
            //query.append("   AND pcf.VAL_DESC = " + dtoE.getDescripcion());
            query.append("   AND pcf.VAL_DESC LIKE '" + dtoE.getDescripcion() + "\' ");
        }
        
        // splatas - DBLG700000162 - 27/10/2006
        if (dtoE.getGrupoProductos() != null  &&  !dtoE.getGrupoProductos().equals("%")) {
            // splatas - DBLG700000162 - 27/10/2006
            //query.append("   AND pcf.VAL_GRUP_ARTI = " + dtoE.getGrupoProductos());  
            query.append("   AND pcf.VAL_GRUP_ARTI LIKE '" + dtoE.getGrupoProductos() + "\' ");  
        }
        
        if (dtoE.getDebeHaber() != null) {
            query.append("   AND pcf.VAL_INDI_DEBE_HABE = '" + dtoE.getDebeHaber() + '\'');
        }
        if (dtoE.getCuentaContable() != null) {
            query.append("   AND pcf.CUCO_OID_CUEN_CONT = " + dtoE.getCuentaContable());
        }
        if (dtoE.getCodImporte() != null) {
            query.append("   AND pcf.IMCF_OID_IMPO_CONT_FACT = " + dtoE.getCodImporte());
        }
        if (dtoE.getMarcaProductos() != null) {
            query.append("   AND pcf.MAPR_OID_MARC_PROD = " + dtoE.getMarcaProductos());
        }
        if (dtoE.getNegocio() != null) {
            query.append("   AND pcf.NEGO_OID_NEGO = " + dtoE.getNegocio());
        }
        if (dtoE.getOidPais() != null) {
            query.append("   AND pcf.PAIS_OID_PAIS = " + dtoE.getOidPais());
        }
        
        // splatas - DBLG700000162 - 27/10/2006
        if (dtoE.getCodProductoSAP() != null  &&  !dtoE.getCodProductoSAP().equals("%")) {
            // splatas - DBLG700000162 - 27/10/2006
            //query.append("   AND produ.COD_SAP = '" + dtoE.getCodProductoSAP() + '\'');
            query.append("   AND produ.COD_SAP LIKE '" + dtoE.getCodProductoSAP() + '\'');
        }
        query.append(" ORDER BY COD_APUN, VAL_TIPO_ASIE, VAL_IDEN_CABE_DETA, VAL_DESC, ");
        query.append(" VAL_GRUP_ARTI, VAL_INDI_DEBE_HABE, CUENTA_CONTABLE, COD_IMPO_CONT, ");
        query.append(" DES_MARC_PROD, NEGOCIO, COD_SAP ");
        query.append(" ) tabla ");
        query.append(" ) WHERE OID > " + dtoE.getIndicadorSituacion());
        query.append(" AND ROWNUM <= " + dtoE.getTamanioPagina());
        
        try {
            rs = bs.dbService.executeStaticQuery(query.toString());
        } catch (Exception e) {
            throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS));
        }
        
        UtilidadesLog.debug("rs = " + rs);
        
        if (rs.esVacio()) {
            throw new MareException("", UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE));
        }
        
        DTOSalida dtoSalida = new DTOSalida();
        dtoSalida.setResultado(rs);
        
        UtilidadesLog.info("DAOINTSAPFI.buscarParametrosContablesFAC(DTOParametrosContablesFAC dtoE): Salida");
        return dtoSalida;
    }

}