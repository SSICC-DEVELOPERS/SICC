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
 * @autor:  Dante Castiglione
 * 
 * 
 * @NOTA: Modificado por revision de Auditoria
 * @autor: Paola Cabrera
 * @fecha: 22/09/2005 
 */
package es.indra.sicc.logicanegocio.inc;

import es.indra.mare.common.exception.MareException;
import es.indra.mare.common.mii.services.jdbcservice.RecordSet;

import es.indra.sicc.dtos.inc.DTOPrecioReclamo;
import es.indra.sicc.util.BelcorpService;
import es.indra.sicc.util.CodigosError;
import es.indra.sicc.util.UtilidadesEJB;
import es.indra.sicc.util.UtilidadesError;

import es.indra.sicc.util.UtilidadesLog;
import java.math.BigDecimal;

public class DAOSoporteExterno {
    private static final boolean debug = true;

    public DAOSoporteExterno() {
    }

    /* Autor Marta Aurora Montiel
     * 23/03/05
     * Incidencia BELC300014887
     **/
    public DTOPrecioReclamo obtenerPrecioReclamo(DTOPrecioReclamo dto)
            throws MareException {
        UtilidadesLog.info("DAOSoporteExterno.obtenerPrecioReclamo(DTOPrecioRe"
            +"clamo dto):Entrada");
        /*
        * Operation DTOPrecioReclamo obtenerPrecioReclamo (DTOPrecioReclamo 
        * DTOE), in Class DAOSoporteExterno
          Devolver el dtoS.
        *
        * */
        StringBuffer querySelect = new StringBuffer();
        
        RecordSet rs;

        //Armando SELECT
        querySelect.append(" SELECT E.IMP_PREC_PUBL, E.PROD_OID_PROD ");
        querySelect.append(" FROM INC_PARAM_GENER_PREMI A, INC_PARAM_NIVEL_PREMI B, ");
        querySelect.append(" INC_PREMI_ARTIC C, INC_LOTE_PREMI_ARTIC D, INC_ARTIC_LOTE E ");
        querySelect.append(" WHERE A.COPA_OID_PARA_GRAL = " + dto.getOidConcurso());
        querySelect.append(" AND B.PAGP_OID_PARA_GENE_PREM = A.OID_PARA_GENE_PREM ");
        querySelect.append(" AND C.PANP_OID_PARA_NIVE_PREM = B.OID_PARA_NIVE_PREM ");
        querySelect.append(" AND D.PRAR_OID_PREM_ARTI = C.OID_PREM_ARTI ");
        querySelect.append(" AND E.LOPA_OID_LOTE_PREM_ARTI = D.OID_LOTE_PREM_ARTI ");
        querySelect.append(" AND E.COD_VENT_FICT = " + dto.getCodigoVenta());
        
        // vbongiov -- Cambio 20091380 -- 22/10/2009
        querySelect.append(" UNION ");
        querySelect.append(" SELECT reem.IMP_PREC_PUBL, reem.PROD_OID_PROD ");
        querySelect.append(" FROM INC_PARAM_GENER_PREMI A, INC_PARAM_NIVEL_PREMI B, ");
        querySelect.append(" INC_PREMI_ARTIC C, INC_LOTE_PREMI_ARTIC D, INC_ARTIC_LOTE E, ");
        querySelect.append(" INC_REEMP_ARTIC_LOTE reem ");
        querySelect.append(" WHERE A.COPA_OID_PARA_GRAL = " + dto.getOidConcurso());
        querySelect.append(" AND B.PAGP_OID_PARA_GENE_PREM = A.OID_PARA_GENE_PREM ");
        querySelect.append(" AND C.PANP_OID_PARA_NIVE_PREM = B.OID_PARA_NIVE_PREM ");
        querySelect.append(" AND D.PRAR_OID_PREM_ARTI = C.OID_PREM_ARTI ");
        querySelect.append(" AND E.LOPA_OID_LOTE_PREM_ARTI = D.OID_LOTE_PREM_ARTI ");
        querySelect.append(" AND reem.ARLO_OID_ARTI_LOTE = E.OID_ARTI_LOTE ");
        querySelect.append(" AND reem.COD_VENT_FICT = " + dto.getCodigoVenta());                      
      
        BelcorpService bs = UtilidadesEJB.getBelcorpService();

        try {
            rs = (RecordSet) bs.dbService.executeStaticQuery(querySelect.toString());
        } catch (MareException me) {
            UtilidadesLog.error("ERROR ", me);
            throw me;
        } catch (Exception e) {
            UtilidadesLog.error("ERROR ", e);
            throw new MareException(e, UtilidadesError.armarCodigoError(
                CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS));
        }

        // sapaza -- PER-SiCC-2014-0074 -- 04/02/2014
        /*if (rs.esVacio()) {
            throw new MareException(null, null, UtilidadesError
                .armarCodigoError(CodigosError
                    .ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE));
        }*/

        DTOPrecioReclamo dtoSal = new DTOPrecioReclamo();
        dtoSal.setCodigoVenta(dto.getCodigoVenta());
        dtoSal.setOidConcurso(dto.getOidConcurso());
        
        if (rs.esVacio()) {
            dtoSal.setPrecioPublico(new BigDecimal("1"));
        } else {    
            dtoSal.setPrecioPublico((BigDecimal) rs.getValueAt(0, 0));
            dtoSal.setOidProducto(new Long(((BigDecimal) rs.getValueAt(0, 1)).longValue()));
        }
        
        UtilidadesLog.info("DAOSoporteExterno.obtenerPrecioReclamo(DTOPrecio"
            +"Reclamo dto):Salida");
        return dtoSal;
    }
}
