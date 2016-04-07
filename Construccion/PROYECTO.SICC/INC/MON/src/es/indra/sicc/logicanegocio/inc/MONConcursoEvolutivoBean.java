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
 *
 * @author: Sergio Platas
 * @date: 25/07/2005
 */
package es.indra.sicc.logicanegocio.inc;

import es.indra.mare.common.exception.MareException;

import es.indra.sicc.cmn.negocio.auditoria.DTOSiccPaginacion;
import es.indra.sicc.cmn.negocio.comun.DTOComunes.DTOOIDPaginado;
import es.indra.sicc.util.DTOSalida;
import es.indra.sicc.util.UtilidadesLog;

import javax.ejb.SessionBean;
import javax.ejb.SessionContext;

public class MONConcursoEvolutivoBean
        implements SessionBean {
    public void ejbCreate() {
    }

    public void ejbActivate() {
    }

    public void ejbPassivate() {
    }

    public void ejbRemove() {
    }

    public void setSessionContext(SessionContext ctx) {
    }

    /**
     * @throws es.indra.mare.common.exception.MareException
     * @return
     * @param DTOE
     */
    public DTOSalida recuperarConcursosRanking(DTOSiccPaginacion DTOE)
            throws MareException {
        UtilidadesLog.info("MONConcursoEvolutivoBean.recuperarConcursosRanking(DTOSiccPaginacion DTOE):Entrada");
        UtilidadesLog.debug("Entró a 'MONConcursoEvolutivo.recuperarConcursosRanking(" + DTOE.toString() + ")' :");

        DTOSalida dtoS = new DTOSalida();
        DAOConcursoEvolutivo daoConcEvol = new DAOConcursoEvolutivo();

        dtoS.setResultado(daoConcEvol.recuperarConcursosRanking(DTOE));

        UtilidadesLog.debug("'MONConcursoEvolutivo.recuperarConcursosRanking()' retorna: " + dtoS.toString());
        UtilidadesLog.info("MONConcursoEvolutivoBean.recuperarConcursosRanking(DTOSiccPaginacion DTOE):Salida");
        return dtoS;
    }

    /**
     * @throws es.indra.mare.common.exception.MareException
     * @return
     * @param DTOE
     */
    public DTOSalida recuperarNivelesConcursoEvolutivo(DTOOIDPaginado DTOE)
            throws MareException {
        UtilidadesLog.info("MONConcursoEvolutivoBean.recuperarNivelesConcursoEvolutivo(DTOOIDPaginado DTOE):Entrada");
        UtilidadesLog.debug("Entró a 'recuperarNivelesConcursoEvolutivo(" + DTOE.toString() + ")'.");

        DTOSalida dtoS = new DTOSalida();
        DAOConcursoEvolutivo daoConcEvol = new DAOConcursoEvolutivo();
        dtoS.setResultado(daoConcEvol.recuperarNivelesConcursoEvolutivo(DTOE));

        UtilidadesLog.debug("'recuperarNivelesConcursoEvolutivo()' retorna: " + dtoS);
        UtilidadesLog.info("MONConcursoEvolutivoBean.recuperarNivelesConcursoEvolutivo(DTOOIDPaginado DTOE):Salida");
        return dtoS;
    }
}
