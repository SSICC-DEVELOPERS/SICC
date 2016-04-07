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
 * Autor : Cortaberria
 * Autor : Dante Castiglione
 */
package es.indra.sicc.logicanegocio.inc;

import es.indra.mare.common.exception.MareException;

import es.indra.sicc.dtos.ped.DTOSolicitudValidacion;
import es.indra.sicc.entidades.inc.CandidataGanadoraLocal;
import es.indra.sicc.entidades.inc.CandidataGanadoraLocalHome;
import es.indra.sicc.entidades.inc.CuentaCorrientePuntosLocal;
import es.indra.sicc.entidades.inc.CuentaCorrientePuntosLocalHome;
import es.indra.sicc.entidades.inc.GanadorasLocal;
import es.indra.sicc.entidades.inc.GanadorasLocalHome;
import es.indra.sicc.util.CodigosError;
import es.indra.sicc.util.DTOOIDs;
import es.indra.sicc.util.UtilidadesError;

import es.indra.sicc.util.UtilidadesLog;

import javax.persistence.NoResultException;
import javax.persistence.PersistenceException;

public class RevertirPremiacionHelper {
    /*
     * Autor: Cotaberria
     * Fecha: 27/04/2005
     * Descripcion: Elimina los registros de CuentaCorriente en funcion de la reversion solicitada
     */
    public void revertirCuentaCorrientePuntos(DTOSolicitudValidacion solicitudValidacion)
            throws MareException {
        UtilidadesLog.info("RevertirPremiacionHelper.revertirCuentaCorrientePuntos(DTOSolicitudValidacion solicitudValidacion):Entrada");
        DAOCuentaCorrientePuntos dao = new DAOCuentaCorrientePuntos();
        DTOOIDs oidsDto = dao.obtenerCuentasARevertir(solicitudValidacion);

        Long[] oids = oidsDto.getOids();

        for (int i = 0; (oids != null) && (i < oids.length); i++) {
            try {
                CuentaCorrientePuntosLocalHome cuentaCorrientePuntosHome = this.getCuentaCorrientePuntosLocalHome();
                CuentaCorrientePuntosLocal cuentaCorrientePuntos = cuentaCorrientePuntosHome.findByPrimaryKey(oids[i]);
                cuentaCorrientePuntosHome.remove(cuentaCorrientePuntos);
            } catch (NoResultException fe) {
                UtilidadesLog.error("ERROR ", fe);
                throw new MareException(fe, UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
            } catch (PersistenceException re) {
                UtilidadesLog.error("ERROR ", re);
                throw new MareException(re, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_BORRADO_DE_DATOS));
            }
        }
        UtilidadesLog.info("RevertirPremiacionHelper.revertirCuentaCorrientePuntos(DTOSolicitudValidacion solicitudValidacion):Salida");
    }

    /*
     * Autor: Cotaberria
     * Fecha: 27/04/2005
     * Descripcion: Elimina los registros de Ganadoras en funcion de la reversion solicitada
     */
    public void revertirGanadoras(DTOSolicitudValidacion solicitudValidacion)
            throws MareException {
        UtilidadesLog.info("RevertirPremiacionHelper.revertirGanadoras(DTOSolicitudValidacion solicitudValidacion):Entrada");
        DAOGanadora dao = new DAOGanadora();
        DTOOIDs oids = dao.obtenerGanadoras(solicitudValidacion.getOidPeriodo(), solicitudValidacion.getOidCliente());

        //3) Recorro la lista de oids y por cada uno de ellos invoco al método remove. 
        Long[] ganadoras = oids.getOids();

        for (int i = 0; (ganadoras != null) && (i < ganadoras.length); i++) {
            try {
                GanadorasLocalHome ganadorasLocalHome = this.getGanadorasLocalHome();
                GanadorasLocal ganadorasLocal = ganadorasLocalHome.findByPrimaryKey(ganadoras[i]);
                ganadorasLocalHome.remove(ganadorasLocal);
            } catch (NoResultException fe) {
                UtilidadesLog.error("ERROR ", fe);
                throw new MareException(fe, UtilidadesError.armarCodigoError(CodigosError.ERROR_CLAVE_INVALIDA));
            } catch (PersistenceException re) {
                UtilidadesLog.error("ERROR ", re);
                throw new MareException(re, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_BORRADO_DE_DATOS));
            }
        }
        UtilidadesLog.info("RevertirPremiacionHelper.revertirGanadoras(DTOSolicitudValidacion solicitudValidacion):Salida");
    }

    /*
     * Autor: Cotaberria
     * Fecha: 27/04/2005
     */
    public void revertirCandidataGanadora(DTOSolicitudValidacion solicitudValidacion)
            throws MareException {
        UtilidadesLog.info("RevertirPremiacionHelper.revertirCandidataGanadora(DTOSolicitudValidacion solicitudValidacion):Entrada");
        DAOCandidataGanadora dao = new DAOCandidataGanadora();
        DTOOIDs oids = dao.obtenerCandidatasARevertir(solicitudValidacion.getOidCliente());

        Long[] candidatas = oids.getOids();

        for (int i = 0; (candidatas != null) && (i < candidatas.length); i++) {
            try {
                CandidataGanadoraLocalHome candidataGanadoraLocalHome = this.getCandidataGanadoraLocalHome();
                CandidataGanadoraLocal candidataGanadoraLocal = candidataGanadoraLocalHome.findByPrimaryKey(candidatas[i]);
                candidataGanadoraLocalHome.remove(candidataGanadoraLocal);
            } catch (NoResultException fe) {
                UtilidadesLog.error("ERROR ", fe);
                throw new MareException(fe, UtilidadesError.armarCodigoError(CodigosError.ERROR_CLAVE_INVALIDA));
            } catch (PersistenceException re) {
                UtilidadesLog.error("ERROR ", re);
                throw new MareException(re, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_BORRADO_DE_DATOS));
            }
        }
        UtilidadesLog.info("RevertirPremiacionHelper.revertirCandidataGanadora(DTOSolicitudValidacion solicitudValidacion):Salida");
    }
    
    private CuentaCorrientePuntosLocalHome getCuentaCorrientePuntosLocalHome() {
            return new CuentaCorrientePuntosLocalHome();
    }

    private GanadorasLocalHome getGanadorasLocalHome() {
            return new GanadorasLocalHome();
    }

    private CandidataGanadoraLocalHome getCandidataGanadoraLocalHome() {
            return new CandidataGanadoraLocalHome();
    }

    
}
