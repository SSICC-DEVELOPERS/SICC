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
 * @autor: Damasia Maneiro
 * Fecha: 26/05/2005
 * 
 * 
 * @NOTA: Modificado por revision de Auditoria
 * @autor: Paola Cabrera
 * @fecha: 21/09/2005 
 * 
 */
package es.indra.sicc.logicanegocio.inc;

import es.indra.mare.common.exception.MareException;
import es.indra.mare.common.mii.MareMiiServiceNotFoundException;
import es.indra.mare.common.mii.services.jdbcservice.RecordSet;

import es.indra.sicc.dtos.inc.DTOClienteEgreso;
import es.indra.sicc.entidades.inc.CuentaCorrientePuntosLocal;
import es.indra.sicc.entidades.inc.CuentaCorrientePuntosLocalHome;
import es.indra.sicc.logicanegocio.mae.ConstantesMAE;
import es.indra.sicc.util.BelcorpService;
import es.indra.sicc.util.CodigosError;
import es.indra.sicc.util.UtilidadesError;
import es.indra.sicc.util.UtilidadesLog;

import java.math.BigDecimal;

import java.sql.Date;

import java.util.ArrayList;

import javax.persistence.PersistenceException;


class DAOEgreso {
    public DAOEgreso() {
    }

    /**
    * Fecha de Creacion: 26/05/2005
    * Autor: Damasia Maneiro
    * Descripcion:
    * Vamos a recuperar todos los clientes que tengan el estado egresada y 
    * tengan puntos en la cuenta corriente de puntos
    * Tendremos que hacer join con loas tablas INCCuentaCorrientePuntos, 
    * MAEHistoricoEstatusCliente y INCConcursoPametros consultoras para 
    * obtenes los registros que cumplan:
    * -INCConcursoPametrosConsultoras.reingresoPierdePuntaje==TRUE
    * -MAEHistoricoEstatusCliente, periodoInicio <= periodo < periodoFinal
    * -MAEHistoricoEstatusCliente estatus==ConstantesMAE.OID_ESTATUS_EGRESADA
    * Recuperaremos: oidCliente, sumatorio de todos los puntos del cliente 
    * para el concurso, oidConcurso
    * Montamos un DTOClienteEgreso
    * Devolvemos todos en un ArrayList
    * @cambio 01/09/2005 Se realizo una subquery para obtener los 
    * clientesHistoricosEstatus segun los periodo de inicio y fin.
    * @autor gdmarzi
    */
    public ArrayList getInformacionClientesEgresados(Long oidPeriodo)
        throws MareException {
        UtilidadesLog.info("DAOEgreso.getInformacionClientesEgresados(Long "
            +"oidPeriodo):Entrada");

        BelcorpService bs;
        RecordSet rs;
        StringBuffer query = new StringBuffer();
        ArrayList clientesEgreso = new ArrayList();

        try {
            bs = BelcorpService.getInstance();
        } catch (MareMiiServiceNotFoundException e) {
            UtilidadesLog.error("ERROR ", e);
            throw new MareException(e,
                UtilidadesError.armarCodigoError(
                    CodigosError.ERROR_AL_PEDIR_UN_SERVICIO_MARE));
        }

        try {
            // subquery para obtener los oidClienteHistoticoEstatus cuyos 
            //periodos inicio y fin 
            // vbongiov -- 17/07/2006 -- inc DBLG500000997
            query.append(" SELECT desca.OID_DESC, CHE.CLIE_OID_CLIE, CPC.COPA_OID_PARA_GRAL, ");
            query.append(" SUM(NUM_PUNT) AS SUMA_PUNTOS ");
            
            // BELC300023732 - gPineda - 14/11/2006
            query.append(" , SUM( NUM_PUNT_EXIG) AS SUMA_PUNTOS_EXIG ");
            
            query.append(" FROM INC_CUENT_CORRI_PUNTO CCP, ");
            query.append(" MAE_CLIEN_HISTO_ESTAT CHE, INC_CONCU_PARAM_CONSU CPC, ");
            query.append(" INC_CONCU_PARAM_GENER GEN, INC_DESCA desca,");
            query.append("    ( SELECT OID_HIST_ESTA ");
            query.append( "    FROM MAE_CLIEN_HISTO_ESTAT CHE , CRA_PERIO , ");
            query.append("  cra_perio periodoDesde , cra_perio periodoHasta ");
            query.append("        WHERE CRA_PERIO.oid_peri = " + oidPeriodo);
            query.append(
                "        AND CHE.perd_oid_peri = periodoDesde.OID_PERI ");
            query.append(
                "        AND periodoDesde.FEC_INIC <= CRA_PERIO.FEC_INIC ");
            query.append( "       AND (CHE.PERD_OID_PERI_PERI_FIN  =  ");
            query.append("  periodoHasta.OID_PERI OR ");
            query.append(" CHE.PERD_OID_PERI_PERI_FIN is NULL) ");
            query.append(
                "       AND CRA_PERIO.FEC_INIC <= periodoHasta.FEC_INIC (+) ");
            query.append("        GROUP BY OID_HIST_ESTA )  CHE_PERIO ");
            query.append(" WHERE CPC.IND_REIN_PIER_PUNT = 1 ");
            query.append(
                "   AND CPC.COPA_OID_PARA_GRAL = CCP.COPA_OID_PARA_GRAL ");
            query.append("   AND CHE.CLIE_OID_CLIE = CCP.CLIE_OID_CLIE ");
            query.append("   AND NUM_PUNT != 0 ");
            query.append("   AND CHE.ESTA_OID_ESTA_CLIE = " +
                ConstantesMAE.OID_ESTATUS_EGRESADA);
            query.append("  AND CHE.OID_HIST_ESTA = CHE_PERIO.OID_HIST_ESTA ");
            query.append("  AND CPC.COPA_OID_PARA_GRAL = GEN.OID_PARA_GRAL ");
            query.append("  AND GEN.IND_ACTI = 1 ");
            query.append("  AND  CCP.COPA_OID_PARA_GRAL  = desca.CLIE_OID_CLIE (+) ");
            query.append("  AND  CCP.CLIE_OID_CLIE  = desca.CLIE_OID_CLIE(+) ");
            query.append(" GROUP BY desca.OID_DESC, CHE.CLIE_OID_CLIE, ");
            query.append(" CPC.COPA_OID_PARA_GRAL ");

            rs = bs.dbService.executeStaticQuery(query.toString());
            UtilidadesLog.debug("****rs gg: " + rs);
        } catch (Exception e) {
            UtilidadesLog.error("ERROR ", e);
            throw new MareException(e,
                UtilidadesError.armarCodigoError(
                    CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS));
        }

        BigDecimal oidDescalificacion = null;
        
        if (!rs.esVacio()) {
            DTOClienteEgreso dtoClienteEgreso = new DTOClienteEgreso();

            for (int fila = 0; rs.existeFila(fila); fila++) {
                // vbongiov -- 17/07/2006 -- inc DBLG500000997
                oidDescalificacion = (BigDecimal) rs.getValueAt(fila, "OID_DESC");
            
                if(oidDescalificacion == null){
                
                    dtoClienteEgreso.setOidCliente(new Long(
                            ((BigDecimal) rs.getValueAt(fila, "CLIE_OID_CLIE"))
                                .longValue()));
                    dtoClienteEgreso.setPuntajeTotal(new Double(
                            ((BigDecimal) rs.getValueAt(fila, "SUMA_PUNTOS"))
                                .doubleValue()));
                    dtoClienteEgreso.setOidConcurso(new Long(((BigDecimal) 
                        rs.getValueAt(fila, "COPA_OID_PARA_GRAL")).longValue()));
    
                    // BELC300023732 - gPineda - 14/11/2006
                    dtoClienteEgreso.setPuntajeExigidoTotal(new Double(((BigDecimal) 
                        rs.getValueAt(fila, "SUMA_PUNTOS_EXIG")).doubleValue()));
    
                    clientesEgreso.add(dtoClienteEgreso);
                }
            }
        }

        UtilidadesLog.info("DAOEgreso.getInformacionClientesEgresados(Long "
            +"oidPeriodo):Salida");

        return clientesEgreso;
    }

    /**
     * Fecha de Creacion: 26/05/2005
     * Autor: Damasia Maneiro
     * Descripcion:
     *
     */
    public void hacerCargoCCPuntos(DTOClienteEgreso dtoe, Long oidPeriodo)
        throws MareException {
        try {
            UtilidadesLog.info( "DAOEgreso.hacerCargoCCPuntos(DTOClienteEgreso"
                +"dtoe, Long oidPeriodo):Entrada");

            CuentaCorrientePuntosLocalHome cuentaCorrientePuntosLocalHome = this.getCuentaCorrientePuntosLocalHome();

            // BELC300023732 - gPineda - 14/11/2006
            CuentaCorrientePuntosLocal cuentaCorrientePuntosLocal = 
                cuentaCorrientePuntosLocalHome.create( /*new Integer(
                       dtoe.getPuntajeTotal().intValue()), new Integer(0),*/
                    new Integer( (-1)*dtoe.getPuntajeTotal().intValue() ),
                    new Integer( (-1)*dtoe.getPuntajeExigidoTotal().intValue() ),
                    new Date(System.currentTimeMillis()),
                    dtoe.getOidConcurso(), dtoe.getOidCliente(), oidPeriodo,
                    ConstantesINC.TIPO_MOVIMIENTO_CARGO);

          
            cuentaCorrientePuntosLocal.setNumMovimiento(new Integer(
                    cuentaCorrientePuntosLocal.getOid().intValue()));
            // vbongiov -- 17/07/2006 -- inc DBLG500000997
            cuentaCorrientePuntosLocal.setVal_desc(ConstantesINC.DESC_ANULACION_PTJE_EGRESOS);
            
            cuentaCorrientePuntosLocalHome.merge(cuentaCorrientePuntosLocal);
            
        } catch (PersistenceException ce) {
            UtilidadesLog.error("ERROR ", ce);
            throw new MareException(ce,UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS));
        }

        UtilidadesLog.info("DAOEgreso.hacerCargoCCPuntos(DTOClienteEgreso dto"
            +"e, Long oidPeriodo):Salida");
    }
    
    private CuentaCorrientePuntosLocalHome getCuentaCorrientePuntosLocalHome() {
            return new CuentaCorrientePuntosLocalHome();
    }

    
}
