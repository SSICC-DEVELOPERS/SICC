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
 */

package es.indra.sicc.logicanegocio.mae;

import es.indra.mare.common.exception.MareException;
import es.indra.mare.common.mii.services.jdbcservice.RecordSet;

import es.indra.sicc.cmn.negocio.auditoria.DTOAuditableSICC;
import es.indra.sicc.cmn.negocio.auditoria.DTOSiccPaginacion;
import es.indra.sicc.dtos.mae.DTOReimprimirFichasInscripcion;
import es.indra.sicc.entidades.mae.ControlImpresionFichasInscripcionLocal;
import es.indra.sicc.entidades.mae.ControlImpresionFichasInscripcionLocalHome;
import es.indra.sicc.logicanegocio.mae.DAOMAEMaestroClientes;
import es.indra.sicc.util.BelcorpService;
import es.indra.sicc.util.CodigosError;
import es.indra.sicc.util.DTOSalida;
import es.indra.sicc.util.UtilidadesEJB;
import es.indra.sicc.util.UtilidadesError;

import es.indra.sicc.util.UtilidadesLog;
import java.math.BigDecimal;

import javax.ejb.SessionBean;
import javax.ejb.SessionContext;

import javax.persistence.PersistenceException;

/*
 * rgiorgi - 19/8/2005: se formatea la clase.
 * */
public class MONFichasInscripcionBean implements SessionBean {
    private SessionContext ctx = null;

    public void ejbCreate() {
    }

    public void ejbActivate() {
    }

    public void ejbPassivate() {
    }

    public void ejbRemove() {
    }

    public void setSessionContext(SessionContext ctx) {
        this.ctx = ctx;
    }

    public DTOSalida obtenerFichasInscripcion(DTOSiccPaginacion dto) throws MareException {
       UtilidadesLog.info("MONFichasInscirpcion.obtenerFichasInscripcion(DTOSiccPaginacion): Entrada"); 
        DTOSalida dtos = new DTOSalida();
        DAOMAEMaestroClientes maestroClie = new DAOMAEMaestroClientes(ctx.getCallerPrincipal().getName());
        dtos = maestroClie.obtenerFichasInscripcionPorPais(dto);

        //        if(dtos.getResultado().esVacio()){
        //           throw new MareException( CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE);                
        //        }
        UtilidadesLog.info("MONFichasInscirpcion.obtenerFichasInscripcion(DTOSiccPaginacion): Salida"); 
        return dtos;
    }

    public void reimprimirFichasInscripcion(DTOReimprimirFichasInscripcion dto) throws MareException {
        UtilidadesLog.info("MONFichasInscirpcion.reimprimirFichasInscripcion(DTOReimprimirFichasInscripcion): Entrada"); 

        ControlImpresionFichasInscripcionLocal ctrlImpreFichasLocal = null;
        ControlImpresionFichasInscripcionLocalHome ctrlImpreFichasLocalHome = null;
        DTOAuditableSICC dtoAuditable = new DTOAuditableSICC();
        dtoAuditable.setIpCliente(dto.getIpCliente());
        dtoAuditable.setPrograma(dto.getPrograma());
        UtilidadesLog.debug("reimprimirFichasInscripcion(1)");
        ctrlImpreFichasLocalHome = new ControlImpresionFichasInscripcionLocalHome();

        Long[] clientes = new Long[dto.getClientes().length];
        clientes = dto.getClientes();

        for (int i = 0; i < dto.getClientes().length; i++) {
            Integer numImpresion = obtenVersionReimpresion(clientes[i]);

            try {
                UtilidadesLog.debug("reimprimirFichasInscripcion(2)");
                ctrlImpreFichasLocal = ctrlImpreFichasLocalHome.create(clientes[i], numImpresion);
                UtilidadesLog.debug("reimprimirFichasInscripcion(3)");
                ctrlImpreFichasLocal.setMotivo(dto.getMotivos());
                ctrlImpreFichasLocalHome.merge(ctrlImpreFichasLocal);
            } catch (PersistenceException e) {
                ctx.setRollbackOnly();
                throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS));
            }
        }

      UtilidadesLog.info("MONFichasInscirpcion.reimprimirFichasInscripcion(DTOReimprimirFichasInscripcion): Salida"); 
    }

    public Integer obtenVersionReimpresion(Long oidCliente) throws MareException {
       UtilidadesLog.info("MONFichasInscirpcion.obtenVersionReimpresion(oidCliente): Entrada"); 
        BelcorpService bs;
        RecordSet resultado = new RecordSet();
        bs = UtilidadesEJB.getBelcorpService();

        Integer verImpre = null;
        StringBuffer query = new StringBuffer();

        try {
            query.append(" SELECT MAX(NVL(NUM_IMPR,0))+1 ");
            query.append(" FROM MAE_CONTR_IMPRE_FICHA_INSCR ");
            query.append(" WHERE CLIE_OID_CLIE = " + oidCliente);

            bs = BelcorpService.getInstance();
            resultado = bs.dbService.executeStaticQuery(query.toString());

            if (resultado.getValueAt(0, 0) == null) {
                verImpre = new Integer(1);
            } else {
                BigDecimal d2 = (BigDecimal) resultado.getValueAt(0, 0);
                verImpre = new Integer(d2.intValue());
            }
        } catch (MareException me) {
            UtilidadesLog.debug("me.toString()" + me.toString());
        } catch (Exception e) {
            throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS));
        }
        UtilidadesLog.info("MONFichasInscirpcion.obtenVersionReimpresion(oidCliente): Salida"); 

        return verImpre;
    }

    /*private ControlImpresionFichasInscripcionLocalHome getControlImpresionFichasInscripcionLocalHome() throws NamingException {
        final InitialContext context = new InitialContext();
        return (ControlImpresionFichasInscripcionLocalHome)context.lookup("java:comp/env/ControlImpresionFichasInscripcion");
    }*/
}
