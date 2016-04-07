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
 * Autor : Matias Dolce
 */
package es.indra.sicc.logicanegocio.inc;

import es.indra.mare.common.exception.MareException;
import es.indra.mare.common.mii.services.jdbcservice.RecordSet;
import es.indra.sicc.dtos.inc.DTOBusquedaZonaTerritorioUA;
import es.indra.sicc.dtos.msg.ConstantesMSG;
import es.indra.sicc.cmn.negocio.comun.DTOComunes.DTOOIDPaginado;
import es.indra.sicc.cmn.negocio.i18n.Entidadi18nLocal;
import es.indra.sicc.dtos.cra.DTOPeriodo;
import es.indra.sicc.dtos.fac.DTOFACProcesoCierre;
import es.indra.sicc.dtos.inc.DTOAmbitRC;
import es.indra.sicc.dtos.inc.DTOAsignarPremios;
import es.indra.sicc.dtos.inc.DTOComunicarParticipantes;
import es.indra.sicc.dtos.inc.DTOETramitarCierre;
import es.indra.sicc.dtos.inc.DTOEntregaPremios;
import es.indra.sicc.dtos.inc.DTONivelesRanking;
import es.indra.sicc.dtos.inc.DTORanking;
import es.indra.sicc.dtos.inc.DTORankingNivelesPremios;
import es.indra.sicc.dtos.inc.DTOVentaRankingGerentes;
import es.indra.sicc.dtos.msg.DTOBuzonMensajes;
import es.indra.sicc.dtos.ped.DTOSolicitudValidacion;
import es.indra.sicc.entidades.cra.PeriodoLocal;
import es.indra.sicc.entidades.cra.PeriodoLocalHome;
import es.indra.sicc.entidades.inc.ConcursoParametrosGeneralesLocal;
import es.indra.sicc.entidades.inc.ConcursoParametrosGeneralesLocalHome;
import es.indra.sicc.entidades.inc.GanadorasLocal;
import es.indra.sicc.entidades.inc.GanadorasLocalHome;
import es.indra.sicc.entidades.inc.ObtencionPuntosLocal;
import es.indra.sicc.entidades.inc.ParametrosGeneralesPremiacionLocal;
import es.indra.sicc.entidades.inc.ParametrosGeneralesPremiacionLocalHome;
import es.indra.sicc.entidades.inc.ParametrosNivelPremiacionLocal;
import es.indra.sicc.entidades.inc.ParametrosNivelPremiacionLocalHome;
import es.indra.sicc.entidades.inc.ParametrosRankingLocal;
import es.indra.sicc.entidades.inc.ParametrosRankingLocalHome;
import es.indra.sicc.entidades.inc.PremioArticuloLocal;
import es.indra.sicc.entidades.inc.PremioArticuloLocalHome;
import es.indra.sicc.entidades.inc.PremioDescuentoLocal;
import es.indra.sicc.entidades.inc.PremioDescuentoLocalHome;
import es.indra.sicc.entidades.inc.PremioMonetarioLocal;
import es.indra.sicc.entidades.inc.PremioMonetarioLocalHome;
import es.indra.sicc.entidades.inc.PremioPuntosLocal;
import es.indra.sicc.entidades.inc.PremioPuntosLocalHome;
import es.indra.sicc.entidades.mae.ClienteDatosAdicionalesLocal;
import es.indra.sicc.entidades.mae.ClienteDatosAdicionalesLocalHome;
import es.indra.sicc.entidades.mae.ClienteDatosBasicosLocal;
import es.indra.sicc.entidades.mae.ClienteDatosBasicosLocalHome;
import es.indra.sicc.entidades.msg.MensajesLocal;
import es.indra.sicc.entidades.msg.MensajesLocalHome;
import es.indra.sicc.logicanegocio.cra.MONPeriodos;
import es.indra.sicc.logicanegocio.cra.MONPeriodosHome;
import es.indra.sicc.logicanegocio.inc.ConstantesRanking;
import es.indra.sicc.logicanegocio.mae.MONClientes;
import es.indra.sicc.logicanegocio.mae.MONClientesHome;
import es.indra.sicc.logicanegocio.msg.MONGestionMensajes;
import es.indra.sicc.logicanegocio.msg.MONGestionMensajesHome;
import es.indra.sicc.logicanegocio.seg.ConstantesSEG;
import es.indra.sicc.util.CRAEjbLocators;
import es.indra.sicc.util.CodigosError;
import es.indra.sicc.util.DTOBelcorp;
import es.indra.sicc.util.DTOOID;
import es.indra.sicc.util.DTOOIDs;
import es.indra.sicc.util.DTOSalida;
import es.indra.sicc.util.MAEEjbLocators;
import es.indra.sicc.util.MSGEjbLocators;
import es.indra.sicc.util.UtilidadesError;
import es.indra.sicc.util.UtilidadesLog;

import java.lang.Long;

import java.math.BigDecimal;

import java.rmi.RemoteException;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

import javax.ejb.CreateException;
import javax.ejb.SessionBean;
import javax.ejb.SessionContext;

import javax.naming.InitialContext;
import javax.naming.NamingException;

import javax.rmi.PortableRemoteObject;
import es.indra.sicc.cmn.negocio.i18n.Entidadi18nLocalHome;
import es.indra.sicc.logicanegocio.msg.MONGestionMensajesLocalHome;

import javax.persistence.NoResultException;
import javax.persistence.PersistenceException;

public class MONMantenimientoRankingBean
        implements SessionBean {
        
    private SessionContext sessionContext;
    
    public void ejbCreate() {
    }

    public void ejbActivate() {
    }

    public void ejbPassivate() {
    }

    public void ejbRemove() {
    }

    public void setSessionContext(SessionContext ctx) {
         sessionContext = ctx;
    }

    /**
      * @throws es.indra.mare.common.exception.MareException
      * @param DTOBelcorp
      * @return DTOSalida
      * @author mdolce
      * @date 20/07/2005
      */
    public DTOSalida obtenerNroConcursosVersionesRankingActivos(DTOBelcorp dtoIn)
            throws MareException {
        UtilidadesLog.info("MONMantenimientoRankingBean.obtenerNroConcursosVersionesRankingActivos(DTOBelcorp dtoIn):Entrada");
        UtilidadesLog.debug("#### Ingreso MONMantenimientoRankingBean.obtenerNroConcursosRankingActivos##########");

        DAOMantenimientoRanking dao = new DAOMantenimientoRanking();

        UtilidadesLog.debug("#### Salida MONMantenimientoRankingBean.obtenerNroConcursosRankingActivos##########");
        UtilidadesLog.info("MONMantenimientoRankingBean.obtenerNroConcursosVersionesRankingActivos(DTOBelcorp dtoIn):Salida");
        return dao.obtenerNroConcursosVersionesRankingActivos(dtoIn);
    }

    /**
      * @throws es.indra.mare.common.exception.MareException
      * @param DTOOID
      * @return DTOSalida
      * @author mdolce
      * @date 20/07/2005
      */
    public DTOSalida obtieneVersiones(DTOOID dtoIn) throws MareException {
        UtilidadesLog.info("MONMantenimientoRankingBean.obtieneVersiones(DTOOID dtoIn):Entrada");
        UtilidadesLog.debug("#### Ingreso MONMantenimientoRankingBean.obtieneVersiones ####");

        DAOMantenimientoRanking dao = new DAOMantenimientoRanking();

        UtilidadesLog.debug("#### Salida MONMantenimientoRankingBean.obtieneVersiones ####");
        UtilidadesLog.info("MONMantenimientoRankingBean.obtieneVersiones(DTOOID dtoIn):Salida");
        return dao.obtieneVersiones(dtoIn);
    }

    /**
      * @throws es.indra.mare.common.exception.MareException
      * @param DTORanking
      * @return DTOSalida
      * @author mdolce
      * @date 20/07/2005
    */
    public DTOSalida buscarConcursosRanking(DTORanking dtoIn)
            throws MareException {
        UtilidadesLog.info("MONMantenimientoRankingBean.buscarConcursosRanking(DTORanking dtoIn):Entrada");
        UtilidadesLog.debug("#### Ingreso MONMantenimientoRankingBean.buscarConcursosRanking ####");

        DAOMantenimientoRanking dao = new DAOMantenimientoRanking();

        UtilidadesLog.debug("#### Salida MONMantenimientoRankingBean.buscarConcursosRanking ####");
        UtilidadesLog.info("MONMantenimientoRankingBean.buscarConcursosRanking(DTORanking dtoIn):Salida");
        return dao.buscarConcursosRanking(dtoIn);
    }

    /**
      * @throws es.indra.mare.common.exception.MareException
      * @param DTOOIDPaginado
      * @return DTOSalida
      * @author mdolce
      * @date 20/07/2005
    */
    public DTOSalida recuperarNivelesPremios(DTOOIDPaginado dtoIn)
            throws MareException {
        UtilidadesLog.debug("#### Ingreso MONMantenimientoRankingBean.recuperarNivelesPremios ####");
        UtilidadesLog.info("MONMantenimientoRankingBean.recuperarNivelesPremios(DTOOIDPaginado dtoIn):Entrada");
        DAOMantenimientoRanking dao = new DAOMantenimientoRanking();

        UtilidadesLog.debug("#### Salida MONMantenimientoRankingBean.recuperarNivelesPremios ####");
        UtilidadesLog.info("MONMantenimientoRankingBean.recuperarNivelesPremios(DTOOIDPaginado dtoIn):Salida");
        return dao.recuperarNivelesPremios(dtoIn);
    }

    /**
      * @throws es.indra.mare.common.exception.MareException
      * @param DTOAmbitRC
      * @return DTOSalida
      * @author mdolce
      * @date 20/07/2005
    */
    public DTOSalida obtenerSGVConcursoAmbito(DTOAmbitRC dtoIn)
            throws MareException {
        UtilidadesLog.debug("#### Ingreso MONMantenimientoRankingBean.obtenerSGVConcursoAmbito ####");
        UtilidadesLog.info("MONMantenimientoRankingBean.obtenerSGVConcursoAmbito(DTOAmbitRC dtoIn):Entrada");
        DAOMantenimientoRanking dao = new DAOMantenimientoRanking();

        UtilidadesLog.debug("#### Salida MONMantenimientoRankingBean.obtenerSGVConcursoAmbito ####");
        UtilidadesLog.info("MONMantenimientoRankingBean.obtenerSGVConcursoAmbito(DTOAmbitRC dtoIn):Salida");
        return dao.obtenerSGVConcursAmbito(dtoIn);
    }

    /**
      * @throws es.indra.mare.common.exception.MareException
      * @param DTOAmbitRC
      * @return DTOSalida
      * @author mdolce
      * @date 20/07/2005
    */
    public DTOSalida obtenerRegionesConcursoAmbito(DTOAmbitRC dtoIn)
            throws MareException {
        UtilidadesLog.debug("#### Ingreso MONMantenimientoRankingBean.obtenerRegionesConcursoAmbito ####");
        UtilidadesLog.info("MONMantenimientoRankingBean.obtenerRegionesConcursoAmbito(DTOAmbitRC dtoIn):Entrada");
        DAOMantenimientoRanking dao = new DAOMantenimientoRanking();

        UtilidadesLog.debug("#### Salida MONMantenimientoRankingBean.obtenerRegionesConcursoAmbito ####");
        UtilidadesLog.info("MONMantenimientoRankingBean.obtenerRegionesConcursoAmbito(DTOAmbitRC dtoIn):Salida");
        return dao.obtenerRegionesConcursoAmbito(dtoIn);
    }

    /**
      * @throws es.indra.mare.common.exception.MareException
      * @param DTOAmbitRC
      * @return DTOSalida
      * @author mdolce
      * @date 20/07/2005
    */
    public DTOSalida obtenerZonasConcursoAmbito(DTOAmbitRC dtoIn)
            throws MareException {
        UtilidadesLog.debug("#### Ingreso MONMantenimientoRankingBean.obtenerZonasConcursoAmbito ####");
        UtilidadesLog.info("MONMantenimientoRankingBean.obtenerZonasConcursoAmbito(DTOAmbitRC dtoIn):Entrada");
        DAOMantenimientoRanking dao = new DAOMantenimientoRanking();

        UtilidadesLog.debug("#### Salida MONMantenimientoRankingBean.obtenerZonasConcursoAmbito ####");
        UtilidadesLog.info("MONMantenimientoRankingBean.obtenerZonasConcursoAmbito(DTOAmbitRC dtoIn):Salida");
        return dao.obtenerZonasConcursoAmbito(dtoIn);
    }

    /**
      * @throws es.indra.mare.common.exception.MareException
      * @param DTOAmbitRC
      * @return DTOSalida
      * @author mdolce
      * @date 20/07/2005
    */
    public DTOSalida obtenerSeccionesConcursoAmbito(DTOAmbitRC dtoIn)
            throws MareException {
        UtilidadesLog.debug("#### Ingreso MONMantenimientoRankingBean.obtenerSeccionesConcursoAmbito ####");
        UtilidadesLog.info("MONMantenimientoRankingBean.obtenerSeccionesConcursoAmbito(DTOAmbitRC dtoIn):Entrada");
        DAOMantenimientoRanking dao = new DAOMantenimientoRanking();

        UtilidadesLog.debug("#### Salida MONMantenimientoRankingBean.obtenerSeccionesConcursoAmbito ####");
        UtilidadesLog.info("MONMantenimientoRankingBean.obtenerSeccionesConcursoAmbito(DTOAmbitRC dtoIn):Salida");
        return dao.obtenerSeccionesConcursoAmbito(dtoIn);
    }

    /**
       * @throws es.indra.mare.common.exception.MareException
       * @param DTOAmbitoGeografico
       * @return DTOSalida
       * @author mdolce
       * @date 20/07/2005
    */
    public DTOSalida obtenerTerritoriosConcursoAmbito(DTOAmbitRC dtoIn)
            throws MareException {
        UtilidadesLog.debug("#### Ingreso MONMantenimientoRankingBean.obtenerTerritoriosConcursoAmbito ####");
        UtilidadesLog.info("MONMantenimientoRankingBean.obtenerTerritoriosConcursoAmbito(DTOAmbitRC dtoIn):Entrada");
        DAOMantenimientoRanking dao = new DAOMantenimientoRanking();

        UtilidadesLog.info("MONMantenimientoRankingBean.obtenerTerritoriosConcursoAmbito(DTOAmbitRC dtoIn):Salida");
        UtilidadesLog.debug("#### Salida MONMantenimientoRankingBean.obtenerTerritoriosConcursoAmbito ####");
        return dao.obtenerTerritoriosConcursoAmbito(dtoIn);
    }

    /**
     * Sistema: Belcorp
     * Módulo:  INC
     * Fecha:   27/07/2005
     * @version 1.00
     * @autor   Diego Morello
     */
    public DTOSalida recuperarVentaRankingGerentes(DTOVentaRankingGerentes dtoIn)
            throws MareException {
        UtilidadesLog.info("MONMantenimientoRankingBean.recuperarVentaRankingGerentes(DTOVentaRankingGerentes dtoIn):Entrada");
        
        try {
            if (this.validarFaseEvaluacion(dtoIn.getOidConcurso()).booleanValue()) {
                int error = UtilidadesError.armarCodigoError(ConstantesSEG.MODULO_INC, "", ErroresDeNegocio.INC_0025);
                throw new MareException(null, null, error);
             } else {
                //BELC300024444 - gPineda - 07/11/2006
                if( dtoIn.getOidTipoRanking().equals( ConstantesINC.TIPO_RANKING_INTERACTIVO ) ){
                  // vbongiov -- 17/11/2006
                  if(this.evaluacionVariableRankingVentas(dtoIn.getOidConcurso()).booleanValue()){
                      preProcesoSolicitudesVariableVentaRanking(dtoIn.getOidConcurso());
                  }
                  this.generarEvaluacionRanking(dtoIn);
                }
                
                DAOMantenimientoRanking dao = new DAOMantenimientoRanking();            
                UtilidadesLog.info("MONMantenimientoRankingBean.recuperarVentaRankingGerentes(DTOVentaRankingGerentes dtoIn):Salida");
                return dao.recuperarVentaRankingGerentes(dtoIn);
            }
        } catch (Exception e) {
            UtilidadesLog.debug("ERROR:");
            e.printStackTrace();
            throw new MareException(e);
        }
    }

    /**
     * Este método valida si el concurso está en fase de validación o en fase de calificación:
     * Si devuelve true esta en etapa de calificacion
     * Si devuelve false esta en etapa de evaluacion
     *
     * @param Long oidConcurso
     * @return boolean
     * @author Diego Morello
     * @date 27/07/2005
    */
    public Boolean validarFaseEvaluacion(Long oidConcurso)
            throws MareException {
        UtilidadesLog.info("MONMantenimientoRankingBean.validarFaseEvaluacion(Long oidConcurso):Entrada");

        try {
            ConcursoParametrosGeneralesLocalHome home = this.getConcursoParametrosGeneralesLocalHome();
            ConcursoParametrosGeneralesLocal concurso = home.findByPrimaryKey(oidConcurso);
            UtilidadesLog.debug("********** El concurso pais es " + concurso.getPais());
            UtilidadesLog.debug("********** El concurso canal es " + concurso.getCanal());
            UtilidadesLog.debug("********** El concurso marca es " + concurso.getMarca());
            UtilidadesLog.debug("********** El concurso es oid " + concurso.getOid());
            
            MONPeriodosHome homePeriodos = CRAEjbLocators.getMONPeriodosHome();
            MONPeriodos monPeriodos = homePeriodos.create();
            
            //DBLG500000746 - gPineda - 06/11/2006
            //DTOPeriodo dtoPeri = monPeriodos.obtienePeriodoActual(concurso.getPais(), concurso.getMarca(), concurso.getCanal());
            DTOPeriodo dtoPeri = monPeriodos.obtieneMenorPeriodoActual(concurso.getPais(), concurso.getMarca(), concurso.getCanal());
           
            // vbongiov -- 9/11/2006           
            PeriodoLocalHome periodoLH = this.getPeriodoLocalHome();
            PeriodoLocal periodoD = periodoLH.findByPrimaryKey(concurso.getPeriodoDesde());
            PeriodoLocal periodoH = periodoLH.findByPrimaryKey(concurso.getPeriodoHasta());            
            PeriodoLocal periodoActual = periodoLH.findByPrimaryKey(dtoPeri.getOid());   
            
            UtilidadesLog.debug("********** periodo de cra " + dtoPeri.getOid());
            UtilidadesLog.debug("********** periodo desde " + periodoD.getOid());
            UtilidadesLog.debug("********** periodo hasta " + periodoH.getOid());
            
            boolean validar = false;
            
            if((periodoD.getFechainicio().getTime() <= periodoActual.getFechainicio().getTime()) &&
               (periodoActual.getFechaFin().getTime() <= periodoH.getFechaFin().getTime())){
                 validar = true;
            }          
            
            UtilidadesLog.debug("fase de evaluacion: " + validar);
            
            UtilidadesLog.info("MONMantenimientoRankingBean.validarFaseEvaluacion(Long oidConcurso):Salida");
            return new Boolean(validar);
            
        } catch (NoResultException e) {
            UtilidadesLog.error("ERROR ", e);
            int error = UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE);
            throw new MareException(e, error);
        } catch (PersistenceException ce) {
            UtilidadesLog.error("ERROR ", ce);
            throw new MareException(ce, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS));
        } catch (CreateException e) {
            UtilidadesLog.error("ERROR ", e);
            int error = UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB);
            throw new MareException(e, error);
        } catch (RemoteException e) {
            UtilidadesLog.error("ERROR ", e);
            int error = UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB);
            throw new MareException(e, error);
        }
    }
    
    /**
     * Sistema: Belcorp
     * Módulo:  INC
     * Fecha:   9/11/2006
     * @version 1.00
     * @autor   Viviana Bongivoanni
     */
    public Boolean validarFaseCalificacion(Long oidConcurso)
            throws MareException {
        UtilidadesLog.info("MONMantenimientoRankingBean.validarFaseCalificacion(Long oidConcurso):Entrada");

        try {
            ConcursoParametrosGeneralesLocalHome home = this.getConcursoParametrosGeneralesLocalHome();
            ConcursoParametrosGeneralesLocal concurso = home.findByPrimaryKey(oidConcurso);
            UtilidadesLog.debug("********** El concurso pais es " + concurso.getPais());
            UtilidadesLog.debug("********** El concurso canal es " + concurso.getCanal());
            UtilidadesLog.debug("********** El concurso marca es " + concurso.getMarca());
            UtilidadesLog.debug("********** El concurso es oid " + concurso.getOid());
            
            MONPeriodosHome homePeriodos = CRAEjbLocators.getMONPeriodosHome();
            MONPeriodos monPeriodos = homePeriodos.create();
            
            //DBLG500000746 - gPineda - 06/11/2006
            //DTOPeriodo dtoPeri = monPeriodos.obtienePeriodoActual(concurso.getPais(), concurso.getMarca(), concurso.getCanal());
            DTOPeriodo dtoPeri = monPeriodos.obtieneMenorPeriodoActual(concurso.getPais(), concurso.getMarca(), concurso.getCanal());
            
            ParametrosRankingLocalHome homePar = this.getParametrosRankingLocalHome();
            ParametrosRankingLocal pRank = homePar.findByUK(oidConcurso);
            
            UtilidadesLog.debug("********** periodo de cra " + dtoPeri.getOid());
            UtilidadesLog.debug("********** periodo de parametros ranking " + pRank.getPerdOidPeri());

            // El siguiente booleano es true si el concurso está en fase de calificación
            boolean validar = dtoPeri.getOid().equals(pRank.getPerdOidPeri());
            UtilidadesLog.debug("fase de calificacion: " + !validar);
            
            UtilidadesLog.info("MONMantenimientoRankingBean.validarFaseCalificacion(Long oidConcurso):Salida");
            return new Boolean(validar);
            
        } catch (NoResultException e) {
            UtilidadesLog.error("ERROR ", e);
            int error = UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE);
            throw new MareException(e, error);
        } catch (PersistenceException ce) {
            UtilidadesLog.error("ERROR ", ce);
            throw new MareException(ce, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS));
        } catch (CreateException e) {
            UtilidadesLog.error("ERROR ", e);
            int error = UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB);
            throw new MareException(e, error);
        } catch (RemoteException e) {
            UtilidadesLog.error("ERROR ", e);
            int error = UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB);
            throw new MareException(e, error);
        }
    }


    /**
     * Sistema: Belcorp
     * Módulo:  INC
     * Fecha:   28/07/2005
     * @version 1.00
     * @autor   Diego Morello
     */
    public DTOSalida recuperarPremiosNiveles(DTORankingNivelesPremios dtoIn)
            throws MareException {
        UtilidadesLog.info("MONMantenimientoRankingBean.recuperarPremiosNiveles(DTORankingNivelesPremios dtoIn):Entrada");
        UtilidadesLog.debug("#### Ingreso MONMantenimientoRankingBean.recuperarPremiosNiveles ####");

        DTOSalida dtoSalida = new DAOMantenimientoRanking().recuperarPremiosNiveles(dtoIn);
        UtilidadesLog.debug("#### Salida MONMantenimientoRankingBean.recuperarPremiosNiveles ####");
        UtilidadesLog.info("MONMantenimientoRankingBean.recuperarPremiosNiveles(DTORankingNivelesPremios dtoIn):Salida");
        return dtoSalida;
    }

    /**
      * @throws es.indra.mare.common.exception.MareException
      * @param DTOVentaRankingGerentes
      * @return DTOSalida
      * @author mdolce
      * @date 28/07/2005
    */
    public DTOSalida calcularRanking(DTOVentaRankingGerentes dtoIn)
            throws MareException {
        UtilidadesLog.debug("#### Ingreso MONMantenimientoRankingBean.calcularRanking con dtoIn: " + dtoIn);
        UtilidadesLog.info("MONMantenimientoRankingBean.calcularRanking(DTOVentaRankingGerentes dtoIn):Entrada");
        DTOSalida dtoS = new DTOSalida();
        
        this.generarEvaluacionRanking(dtoIn);
        
        DAOMantenimientoRanking dao = new DAOMantenimientoRanking();
        UtilidadesLog.info("MONMantenimientoRankingBean.calcularRanking(DTOVentaRankingGerentes dtoIn):Salida");
        
        return dao.recuperarResultadosRanking(dtoIn.getOidConcurso());
    }

    /**
       * @throws es.indra.mare.common.exception.MareException
       * @param DTOComunicarParticipantes
       * @return void
       * @author Paola Cabrera
       * @date 03/08/2005
       * @descripcion: Este Metodo recibe los oid de los clientes que son
       * ganadores y aspirantes para el nivel que fue seleccionado y el oid del
       * concurso que se está procesando. Con esta información, se realiza el
       * llamado al caso de uso Insertar Buzon Mensaje y se realizar la respectiva
       * comunicación.
    */
    public void comunicarAParticipantes(DTOComunicarParticipantes dtoIn)
            throws MareException {
        UtilidadesLog.info("MONMantenimientoRankingBean.comunicarAParticipantes(DTOComunicarParticipantes dtoIn):Entrada");
        UtilidadesLog.debug("#### MONMantenimientoRankingBean.comunicarAParticipantes : " + dtoIn);

        if(this.validarFaseCalificacion(dtoIn.getOidConcurso()).booleanValue()) {
        
            ConcursoParametrosGeneralesLocalHome home = this.getConcursoParametrosGeneralesLocalHome();
            ConcursoParametrosGeneralesLocal concurso;
    
            try {
                Long pk = dtoIn.getOidConcurso();
                concurso = home.findByPrimaryKey(pk);
            } catch (NoResultException e) {
                UtilidadesLog.error("ERROR ", e);
                int error = UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE);
                throw new MareException(e, error);
            } catch (PersistenceException ce) {
                UtilidadesLog.error("ERROR ", ce);
                throw new MareException(ce, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS));
            }
    
            String numeroConcurso = concurso.getNumeroConcurso();
            ObtencionPuntosLocal obtencionPuntosL = null;
    
            MensajesLocal mensajesL = null;
            String codMensaje = " ";
                    
            try {
                MensajesLocalHome mensajesLH = this.getMensajesLocalHome();
                mensajesL = mensajesLH.findByPrimaryKey(ConstantesINC.OID_MENSAJE_RANKING);
            } catch (NoResultException e) {
                UtilidadesLog.error("ERROR ", e);
                int error = UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE);
                throw new MareException(e, error);
            } catch (PersistenceException ne) {
                UtilidadesLog.error("ERROR ", ne);
                throw new MareException(ne, UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
            }
            codMensaje = mensajesL.getCodMensaje();
            PeriodoLocal periodoL = null;
    
            try {
                PeriodoLocalHome periodoLH = this.getPeriodoLocalHome();
                periodoL = periodoLH.findByPrimaryKey(concurso.getPeriodoDesde());
            } catch (NoResultException nre) {
                sessionContext.setRollbackOnly();
                 UtilidadesLog.error("ERROR ", nre);
                throw new MareException(nre,        
                    UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE) );         
            } catch (PersistenceException ce) {
                UtilidadesLog.error("ERROR ", ce);
                throw new MareException(ce, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS));
            }
                    
            String campaniaInicio = periodoL.getNombrePeriodo();
                    
            try {
                PeriodoLocalHome periodoLHome = this.getPeriodoLocalHome();
                periodoL = periodoLHome.findByPrimaryKey(concurso.getPeriodoHasta());
            } catch (NoResultException nre) {
                sessionContext.setRollbackOnly();
                 UtilidadesLog.error("ERROR ", nre);
                throw new MareException(nre,        
                    UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE) );         
            } catch (PersistenceException ce) {
                UtilidadesLog.error("ERROR ", ce);
                throw new MareException(ce, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS));
            }
    
            String campaniaFin = periodoL.getNombrePeriodo();
            Long periodoActual = null;
    
            try {
                MONPeriodosHome monPerHome = CRAEjbLocators.getMONPeriodosHome();
                MONPeriodos monPer = monPerHome.create();
                DTOPeriodo dtoPeriodo = monPer.obtienePeriodoActual(concurso.getPais(), concurso.getMarca(), concurso.getCanal());
                periodoActual = dtoPeriodo.getOid();
            } catch (CreateException e) {
                UtilidadesLog.error("ERROR ", e);
                int error = UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB);
                throw new MareException(e, error);
            } catch (RemoteException e) {
                UtilidadesLog.error("ERROR ", e);
                int error = UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB);
                throw new MareException(e, error);
            }
            
    
            DTOBuzonMensajes dtoBuzonM = new DTOBuzonMensajes();
            Long[] oidCliente = dtoIn.getClientes();
            Long[] posiciones = dtoIn.getPosicion();
            //Cambio segun incidencia 21876 - dmaneiro - 07/12/2005
            Entidadi18nLocalHome ei18nlh = this.getEntidadi18nLocalHome();
            Long atrib = new Long(ConstantesINC.NUM_ATRIBUTO.longValue());
                   
            for (int i = 0; i < dtoIn.getClientes().length; i++) {
             
                //jrivas BLO-01
                DAOClientePremiacion dao = new DAOClientePremiacion();
                boolean clienteBloqueado = dao.validarClienteBloqueado(oidCliente[i], concurso.getPais());
                if (!clienteBloqueado) {

                    ClienteDatosBasicosLocal cliente = null;
        
                    try {
                       cliente = this.getClienteDatosBasicosLocalHome().findByPrimaryKey(oidCliente[i]);
                    } catch (NoResultException nre) {
                        sessionContext.setRollbackOnly();
                         UtilidadesLog.error("ERROR ", nre);
                        throw new MareException(nre,        
                            UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE) );         
                    } catch (PersistenceException ce) {
                        UtilidadesLog.error("ERROR ", ce);
                        throw new MareException(ce, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS));
                    }
                    
                    dtoBuzonM.setOidPais(dtoIn.getOidPais());
                    dtoBuzonM.setCodigoMensaje(codMensaje);
                    dtoBuzonM.setOidCliente(oidCliente[i]);
                    dtoBuzonM.setModuloOrigen(Long.valueOf(ConstantesSEG.MODULO_INC));
                    dtoBuzonM.setDatoVariable6(numeroConcurso);
                           
                    String nombre1 = new String(" ");
                    
                    if ((cliente.getVal_nom1() != null) && (cliente.getVal_nom1().length() > 0)) {
                        nombre1 = cliente.getVal_nom1();
                    }
                                
                    String nombre2 = new String(" ");
        
                    if (cliente.getVal_nom2() != null) {
                        nombre2 = " " + cliente.getVal_nom2();
                    }
                    
                    String apellido1 = new String(" ");
        
                    if (cliente.getVal_ape1() != null) {
                        apellido1 = " " + cliente.getVal_ape1();
                    }
                                
                    String apellido2 = new String(" ");
        
                    if (cliente.getVal_ape2() != null) {
                        apellido2 = " " + cliente.getVal_ape2();
                    }
                    
                    dtoBuzonM.setDatoVariable1(nombre1 + nombre2 + apellido1 + apellido2);
                    dtoBuzonM.setDatoVariable2(campaniaInicio);
                    dtoBuzonM.setDatoVariable3(campaniaFin);
                    dtoBuzonM.setDatoVariable4(posiciones[i].toString());
                    
                     //Agregado por inc 21876 - dmaneiro - 07/12/2005
                    try {
                        UtilidadesLog.debug("********* Antes de llamar a findByEntAtrIdioPK con:");
                        UtilidadesLog.debug("********* ConstantesINC.ENTIDAD_TIPO_PREMIO " + ConstantesINC.ENTIDAD_TIPO_PREMIO);
                        UtilidadesLog.debug("********* DTOE.getOidIdioma() " + dtoIn.getOidIdioma());
                      
                        Entidadi18nLocal ei18nl = ei18nlh.findByEntAtrIdioPK(ConstantesINC.ENTIDAD_TIPO_PREMIO, atrib, dtoIn.getOidIdioma(), dtoIn.getOidTipoPremio());
                       
                        dtoBuzonM.setDatoVariable5(ei18nl.getDetalle());
                    } catch (NoResultException nre) {
                        UtilidadesLog.debug(nre);
                        UtilidadesLog.debug("********* Antes de llamar a findByEntAtrIdioPK con idioma por defecto");
                        
                        try{
                        Entidadi18nLocal ei18nl2 = ei18nlh.findByEntAtrIdioPK(ConstantesINC.ENTIDAD_TIPO_PREMIO, atrib, ConstantesSEG.IDIOMA_DEFECTO,
                                                                          dtoIn.getOidTipoPremio());
                        dtoBuzonM.setDatoVariable5(ei18nl2.getDetalle());
                        
                        } catch (NoResultException nrex) {
                            UtilidadesLog.debug(nrex);                  
                            UtilidadesLog.debug("********* Despues de llamar a findByEntAtrIdioPK con idioma por defecto");
                        } catch (PersistenceException ce) {
                            UtilidadesLog.error("ERROR ", ce);
                            throw new MareException(ce, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS));
                        }
                        
                    } catch (PersistenceException ce) {
                        UtilidadesLog.error("ERROR ", ce);
                        throw new MareException(ce, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS));
                    }//FIN de Agregado 
 
                    dtoBuzonM.setListaConsultoras(ConstantesMSG.NO);
                    dtoBuzonM.setCodigoPatron("Ultimas Noticias");
        
                    UtilidadesLog.debug(" DTOBuzonMensajes: " + dtoBuzonM);
        
                    try {
                        MONGestionMensajesHome monMsgHome = MSGEjbLocators.getMONGestionMensajesHome();
                        MONGestionMensajes monMSG = monMsgHome.create();
        
                        UtilidadesLog.debug(" Antes de insertar +  " + dtoBuzonM);
                        monMSG.insertaDatosMensajeBatch(dtoBuzonM);
                        UtilidadesLog.debug(" Sale de insertar");
                    } catch (CreateException e) {
                        UtilidadesLog.error("ERROR ", e);
                        int error = UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB);
                        throw new MareException(e, error);
                    } catch (RemoteException e) {
                        UtilidadesLog.error("ERROR ", e);
                        int error = UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB);
                        throw new MareException(e, error);
                    }
                } //IF CLIENTE BLOQUEADO

                DTOEntregaPremios dtoEntrega = new DTOEntregaPremios();
    
                dtoEntrega.setOidConcurso(dtoIn.getOidConcurso());
                dtoEntrega.setOidPais(concurso.getPais());
                dtoEntrega.setOidMarca(concurso.getMarca());
                dtoEntrega.setOidCanal(concurso.getCanal());
                dtoEntrega.setOidDirigidoA(concurso.getDirigidoA());
                dtoEntrega.setOidCliente(oidCliente[i]);
                
                //jrivas BLO-01
                dtoEntrega.setClienteBloqueado(new Boolean(clienteBloqueado));
    
                ClienteDatosAdicionalesLocal clienteAdic = null;
    
                try {
                    //--Hacer un cliente.findByPK(dto.get(oidCliente[i])) 
                    clienteAdic = this.getClienteDatosAdicionalesLocalHome().findByCliente(oidCliente[i]);
                } catch (NoResultException nre) {
                    sessionContext.setRollbackOnly();
                     UtilidadesLog.error("ERROR ", nre);
                    throw new MareException(nre,        
                        UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE) );         
                } catch (PersistenceException ce) {
                    UtilidadesLog.error("ERROR ", ce);
                    throw new MareException(ce, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS));
                }
    
                if (clienteAdic.getCod_empl() != null) {
                    dtoEntrega.setCodEmpleado(Long.valueOf(clienteAdic.getCod_empl()));
                }
     
                dtoEntrega.setOidPeridodo(periodoActual);
                dtoEntrega.setOidNivelPremiacion(dtoIn.getOidNivelPremiacion());
                
                UtilidadesLog.debug(" se llama a entregaDePremios " + dtoEntrega);
                try {
                    this.entregaDePremios(dtoEntrega);
                } catch (Exception ex) {
                    UtilidadesLog.error("ERROR ", ex);
                    int error = UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB);
                    throw new MareException(ex, error);
                }
                UtilidadesLog.debug(" sale de entrega premios");
            }
            
        } else {
            int error = UtilidadesError.armarCodigoError(ConstantesSEG.MODULO_INC, "", ErroresDeNegocio.INC_0054);
            throw new MareException(null, null, error);
        }
        
        UtilidadesLog.debug("#### Salida MONMantenimientoRankingBean.comunicarAParticipantes ####");
        UtilidadesLog.info("MONMantenimientoRankingBean.comunicarAParticipantes(DTOComunicarParticipantes dtoIn):salida");
    } 


    /**
       * @throws es.indra.mare.common.exception.MareException
       * @param DTONivelesRanking
       * @return DTOSalida
       * @author Mariano Rodriguez
       * @date 21/07/2005
    */
    public DTOSalida recuperarGanadorasAspirantesNivel(DTONivelesRanking dtoIn)
            throws MareException {
        UtilidadesLog.error("MONMantenimientoRankingBean.recuperarGanadorasAspirantesNivel(DTONivelesRanking dtoIn):Entrada");
        UtilidadesLog.debug("#### Ingreso MONMantenimientoRankingBean.recuperarGanadorasAspirantesNivel ####");

        DAOMantenimientoRanking dao = new DAOMantenimientoRanking();

        Long periodo;

        try {
            ConcursoParametrosGeneralesLocal concursoParametrosGenerales = this.getConcursoParametrosGeneralesLocalHome().findByPrimaryKey(dtoIn.getOidConcurso());

            periodo = CRAEjbLocators.getMONPeriodosHome().create()
                                    .obtienePeriodoActual(concursoParametrosGenerales.getPais(), concursoParametrosGenerales.getMarca(),
                                                          concursoParametrosGenerales.getCanal()).getOid();
        } catch (NoResultException e) {
            UtilidadesLog.error("ERROR ", e);
            throw new MareException(new Exception(), UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE));
        } catch (PersistenceException ce) {
            UtilidadesLog.error("ERROR ", ce);
            throw new MareException(ce, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS));
        } catch (CreateException e) {
            UtilidadesLog.error("ERROR ", e);
            throw new MareException(new Exception(), UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
        } catch (RemoteException e) {
            UtilidadesLog.error("ERROR ", e);
            throw new MareException(new Exception(), UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
        }

        UtilidadesLog.debug("#### Salida MONMantenimientoRankingBean.recuperarGanadorasAspirantesNivel ####");
        UtilidadesLog.error("MONMantenimientoRankingBean.recuperarGanadorasAspirantesNivel(DTONivelesRanking dtoIn):Salida");
        return dao.recuperarGanadorasAspirantesNivel(dtoIn, periodo);
    }

    /**
      * @throws es.indra.mare.common.exception.MareException
      * @param DTOEntregaPremios
      * @return void
      * @author pcabrera
      * @date 21/07/2005
      * @descripcion Entrega el premio para los clientes que vienen por parametro.

    */
    public void entregaDePremios(DTOEntregaPremios dtoIn)
            throws MareException {
        UtilidadesLog.error("MONMantenimientoRankingBean.entregaDePremios(DTOEntregaPremios dtoIn):Entrada");
        UtilidadesLog.debug("# MONMantenimientoRankingBean.entregaDePremios : " + dtoIn);

        try {
            ClientePremiacion cliePrem = new ClientePremiacion();
            
            cliePrem.setOidCliente(dtoIn.getOidCliente());
            cliePrem.setOidPais(dtoIn.getOidPais());
            cliePrem.setOidMarca(dtoIn.getOidMarca());
            cliePrem.setOidCanal(dtoIn.getOidCanal());
            cliePrem.setOidCodigoEmpleado(dtoIn.getCodEmpleado()!=null?dtoIn.getCodEmpleado().toString():null);
            
            //jrivas BLO-01
            cliePrem.setClienteBloqueado(dtoIn.getClienteBloqueado().booleanValue());
     
            DTOETramitarCierre dtoe = new DTOETramitarCierre();
    
            dtoe.setOidPeriodo(dtoIn.getOidPeridodo());
            dtoe.setOidPais(dtoIn.getOidPais());
            dtoe.setOidMarca(dtoIn.getOidMarca());
            dtoe.setOidCanal(dtoIn.getOidCanal());
    
            DAOClientePremiacion dao = new DAOClientePremiacion();
            Periodo periodo = dao.obtenerPeriodo(dtoe);
    
            cliePrem.setPeriodo(periodo);
    
            ClientePremiacionConcurso clieConc = new ClientePremiacionConcurso();
           
            clieConc.setOidConcurso(dtoIn.getOidConcurso());
            boolean valor = true;
     
            clieConc.setRequisitosPremiacionSuperado(valor);
            clieConc.setDirigidoA(dtoIn.getOidDirigidoA());
     
            DAOClientePremiacionConcurso daoCliente = new DAOClientePremiacionConcurso();
    
            //  Se agrego un parametro null, Modificado por HRCS - Fecha 29/03/2007 - Incidencia Sicc 20070173
            Premio premio = daoCliente.recuperarPremioPorNivel(dtoIn.getOidNivelPremiacion(), null);
            UtilidadesLog.debug("premio.getOidPremio(): " + premio.getOidPremio());
            UtilidadesLog.debug("premio.getPeriodoDeDespacho(): " + premio.getPeriodoDeDespacho().getOidPeriodo());
            UtilidadesLog.debug("premio.getCantidad(): " + premio.getCantidad());
            
            // Si no hay periodo de despacho se toma el actual
            if(premio.getPeriodoDeDespacho().getOidPeriodo()==null) {
                premio.getPeriodoDeDespacho().setOidPeriodo(dtoIn.getOidPeridodo());        
            }
            
            UtilidadesLog.debug("premio.getPeriodoDeDespacho(): " + premio.getPeriodoDeDespacho().getOidPeriodo());
    
            ArrayList arrPremioGan = new ArrayList();
            arrPremioGan.add(premio);
    
            clieConc.setPremiosGanados(arrPremioGan);
    
            HashMap cliente = new HashMap();
            cliente.put(clieConc, clieConc);
    
            cliePrem.setClientesPremiacionConcurso(cliente);
    
            UtilidadesLog.debug(" ClientePremiacion: " + cliePrem);
    
            this.actualizarGanadoras(cliePrem);
    
            // Despachar premio
            UtilidadesLog.debug("antes de despacharPremios");
            DespacharPremiosHelper despacharPremiosHelper = new DespacharPremiosHelper();
            Iterator itClienConcursos = cliePrem.getClientesPremiacionConcurso().keySet().iterator();
            ClientePremiacionConcurso clienteConcurso = null;
        
            UtilidadesLog.debug("ClientesPremiacionConcurso cantidad" + cliePrem.getClientesPremiacionConcurso().size());

            while (itClienConcursos.hasNext()) {
                Object key = itClienConcursos.next();
                clienteConcurso = (ClientePremiacionConcurso) cliePrem.getClientesPremiacionConcurso().get(key);
                UtilidadesLog.debug("clienteConcurso.getRequisitosPremiacionSuperado() " + clienteConcurso.getRequisitosPremiacionSuperado());

                if (clienteConcurso.getRequisitosPremiacionSuperado()) {
                    UtilidadesLog.debug("clienteConcurso.getPremiosGanados()() " + clienteConcurso.getPremiosGanados());

                    if (clienteConcurso.getPremiosGanados() != null) {
                        Iterator itPremios = clienteConcurso.getPremiosGanados().iterator();

                        while (itPremios.hasNext()) {
                            Premio premioGanado = (Premio) itPremios.next();
                            UtilidadesLog.debug("premioGanado " + premioGanado);
                            UtilidadesLog.debug("premioGanado.getTipoPremio() " + premioGanado.getTipoPremio());

                            if (ConstantesINC.TIPO_PREMIO_MONETARIO.equals(premioGanado.getTipoPremio())) {
                                despacharPremiosHelper.despacharPremioTipoMonetario(cliePrem, premioGanado, clienteConcurso);
                            } else if (ConstantesINC.TIPO_PREMIO_ARTICULO.equals(premioGanado.getTipoPremio())) {
                                despacharPremiosHelper.despacharPremioTipoArticulo(cliePrem, premioGanado, clienteConcurso);
                            } else if (ConstantesINC.TIPO_PREMIO_PUNTUACION.equals(premioGanado.getTipoPremio())) {
                                despacharPremiosHelper.despacharPremioTipoPuntuacion(cliePrem, premioGanado, clienteConcurso);
                            } else if (ConstantesINC.TIPO_PREMIO_DESCUENTOS.equals(premioGanado.getTipoPremio())) {
                                despacharPremiosHelper.despacharPremioTipoDescuentos(cliePrem, premioGanado, clienteConcurso);
                            }
                        } //while(itPremios.hasNext())
                    } //clienteConcurso.getPremiosGanados() != null
                } //clienteConcurso.getRequisitosPremiacionSuperado()
            } //while(itClienConcursos.hasNext())
        } catch (MareException me) {
            UtilidadesLog.error("ERROR ", me);
            sessionContext.setRollbackOnly();
            throw me;
        } catch (Exception e) {
            UtilidadesLog.error("ERROR ", e);
            sessionContext.setRollbackOnly();
            throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
        }
        
        UtilidadesLog.debug("sale de despacharPremios");

        UtilidadesLog.debug("#### Salida MONMantenimientoRankingBean.entregaDePremios ####");
    }

    /**
       *
       * @fecha 27/07/2005
       * @throws es.indra.mare.common.exception.MareException
       * @return DTOSalida
       * @author Mariano Rodriguez
       * @param clientePremiacion
       *
       * @se modifica segun la incidencia
       * @BELC300020128
       */
    public void actualizarGanadoras(ClientePremiacion clientePremiacion)
            throws MareException {
        UtilidadesLog.debug(" Empieza MONMantenimientoRankingBean.actualizarGanadoras con ClientePremiacion: " + clientePremiacion);

        StringBuffer query = new StringBuffer();
        GestorMensajesTransformar gestorMensajesTransformar = new GestorMensajesTransformar();        

        Iterator it = clientePremiacion.getClientesPremiacionConcurso().values().iterator();

        while (it.hasNext()) {
            ClientePremiacionConcurso clientePremiacionConcurso = (ClientePremiacionConcurso) it.next();
            ArrayList ite = clientePremiacionConcurso.getPremiosGanados();
            
            for (int a = 0; a < ite.size(); a++) {
                Premio premio = (Premio) ite.get(a);

                UtilidadesLog.debug(" premio.getTipoPremio(): " + premio.getTipoPremio());

                if (premio.getTipoPremio().equals(ConstantesINC.TIPO_PREMIO_MONETARIO)) {
                
                    PremioMonetario premioGan = (PremioMonetario) premio;
                    UtilidadesLog.debug(" premioGan.getOidPremio(): " + premioGan.getOidPremio());
                    UtilidadesLog.debug(" premioGan.getPeriodoDeDespacho(): " + premioGan.getPeriodoDeDespacho().getOidPeriodo());

                    if (premioGan.getPagoEnPartes() == false) {
                        
                        GanadorasLocalHome ganadoras = null;
                        GanadorasLocal ganad = null;
                        ganadoras = this.getGanadorasLocalHome();
                        BigDecimal unidades = null;
                        Boolean listarGanador = Boolean.FALSE;
                        Boolean despachado = Boolean.FALSE;
                        Boolean descontar = Boolean.FALSE;
                        Long periodoDespacho = Long.valueOf(premioGan.getPeriodoDeDespacho().getOidPeriodo().toString());
                        
                        if (premioGan.getCantidad() != null) {
                            unidades = premioGan.getCantidad();
                            premioGan.setUnidades(unidades);
                        } else {
                            unidades = new BigDecimal("0");
                            premioGan.setUnidades(unidades);
                        }
                        
                        UtilidadesLog.debug(" Unidades: " + unidades);

                        try {
                            ganad = ganadoras.create(unidades, listarGanador, descontar, despachado, clientePremiacion.getOidCliente(),
                                                     periodoDespacho, premio.getNivel().getOidNivel());
                                                     
                            ganad.setFechaObtencion(new java.sql.Date(System.currentTimeMillis()));     
                            
                            //jrivas BLO-01
                            ganad.setClienteBloqueado(new Boolean(clientePremiacion.getClienteBloqueado()));
                            
                            ganadoras.merge(ganad);                            
                            
                        } catch (PersistenceException e) {
                            UtilidadesLog.error("ERROR ", e);
                            throw new MareException(new Exception(), UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS));
                        }
                    } else {
                       for (int i = 0; i < premioGan.getPagosEnPartes().size(); i++) {
                            PagoPartes pagoParte = (PagoPartes) premioGan.getPagosEnPartes().get(i);
                            GanadorasLocalHome ganadoras = null;
                            GanadorasLocal ganad = null;
                            ganadoras = this.getGanadorasLocalHome();
                            BigDecimal unidades = null;
                            Boolean listarGanador = Boolean.FALSE;
                            Boolean despachado = Boolean.FALSE;
                            Boolean descontar = Boolean.FALSE;
                            
                            // vbongiov - 10/05/2006 - DBLG500000363
                            Long periodoDespacho = Long.valueOf(pagoParte.getPeriodoControl().getOidPeriodo().toString());                            

                            if (premioGan.getCantidad() != null) {
                                unidades = premioGan.getCantidad().multiply(pagoParte.getPorcentajePremio()).divide(new BigDecimal(100),2, BigDecimal.ROUND_HALF_UP);
                                premioGan.setUnidades(premioGan.getCantidad());                                                                                                
                            } else {
                                unidades = new BigDecimal("0");
                                premioGan.setUnidades(unidades);
                            }
                            
                            UtilidadesLog.debug(" Unidades: " + unidades);

                            try {
                                ganad = ganadoras.create(unidades, listarGanador, descontar, despachado, clientePremiacion.getOidCliente(),
                                                         periodoDespacho, premio.getNivel().getOidNivel());
                                                         
                                ganad.setFechaObtencion(new java.sql.Date(System.currentTimeMillis()));     
                                
                                //jrivas BLO-01
                                ganad.setClienteBloqueado(new Boolean(clientePremiacion.getClienteBloqueado()));
                            
                                ganadoras.merge(ganad);                                                        
                                
                            } catch (PersistenceException e) {
                                UtilidadesLog.error("ERROR ", e);
                                throw new MareException(new Exception(),
                                                        UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS));
                            }
                        } 
                    } 
                } 
                else {
                    GanadorasLocalHome ganadoras = null;
                    GanadorasLocal ganad = null;
                    ganadoras = this.getGanadorasLocalHome();
                    BigDecimal unidades = new BigDecimal("0");
                    Boolean listarGanador = Boolean.FALSE;
                    Boolean despachado = Boolean.FALSE;
                    Boolean descontar = Boolean.FALSE;
                    
                    Long periodoDespacho = null;

                    if (premio.getTipoPremio().equals(ConstantesINC.TIPO_PREMIO_ARTICULO)) {
                        PremioArticuloLote premioGanAr = (PremioArticuloLote) premio;

                        if (premioGanAr.getPremio().getNumeroUnidades() != null) {
                            unidades = new BigDecimal((premioGanAr.getPremio().getNumeroUnidades()).toString());
                            premioGanAr.setUnidades(unidades);
                        } else {
                            unidades = new BigDecimal("0");
                            premioGanAr.setUnidades(unidades);
                        }

                        //Brecha INC-003 6-9-07 jrivas
                        //jrivas BLO-001 
                        if (!clientePremiacion.getClienteBloqueado()) {
                            Concurso concurso = new DespacharPremiosHelper().obtenerConcurso(clientePremiacionConcurso.getOidConcurso());                        
                            gestorMensajesTransformar.crearMensajeINC98(clientePremiacion.getOidCliente(), concurso, premio);
                        }                        
                    } 
                    

                    if (premio.getTipoPremio().equals(ConstantesINC.TIPO_PREMIO_PUNTUACION)) {
                        PremioPuntos premioGanP = (PremioPuntos) premio;
                    
                        if (premioGanP.getCantidad() != null) {
                            unidades = premioGanP.getCantidad();
                            premioGanP.setImportePremio(unidades);
                            premioGanP.setUnidades(unidades);
                        } else {
                            unidades = new BigDecimal("0");
                            premioGanP.setImportePremio(unidades);
                            premioGanP.setUnidades(unidades);
                        }
                    } 

                    if (premio.getTipoPremio().equals(ConstantesINC.TIPO_PREMIO_DESCUENTOS)) {
                        PremioDescuento premioGanDesc = (PremioDescuento) premio;
                        unidades = new BigDecimal("0");
                        premioGanDesc.setUnidades(unidades);
                    }

                    UtilidadesLog.debug(" Unidades: " + unidades);

                    try {
                    
                        // Obtener periodo actual 
                        // vbongiov - 10/05/2006 - DBLG500000363
                        MONPeriodos monPer = CRAEjbLocators.getMONPeriodosHome().create();            
                        UtilidadesLog.debug("pais: " + clientePremiacion.getOidPais() + " marca: " + clientePremiacion.getOidMarca() +
                                            "canal: " + clientePremiacion.getOidCanal());
                        
                        DTOPeriodo periodoActual  = monPer.obtienePeriodoActual(clientePremiacion.getOidPais(), 
                                                    clientePremiacion.getOidMarca(),
                                                    clientePremiacion.getOidCanal());
                       
                        periodoDespacho = periodoActual.getOid();
                    
                        UtilidadesLog.debug("unidades " +  unidades);
                        UtilidadesLog.debug("listarGanador " +  listarGanador);
                        UtilidadesLog.debug("descontar " +  descontar);
                        UtilidadesLog.debug("despachado " +  despachado);
                        UtilidadesLog.debug("clientePremiacion.getOidCliente() " +  clientePremiacion.getOidCliente());
                        UtilidadesLog.debug("periodoDespacho " +   periodoDespacho);
                        UtilidadesLog.debug("premio.getNivel().getOidNivel() " +  premio.getNivel().getOidNivel());
                                                 
                        ganad = ganadoras.create(unidades, listarGanador, descontar, despachado, clientePremiacion.getOidCliente(), periodoDespacho,
                                                 premio.getNivel().getOidNivel());
                                                 
                        ganad.setFechaObtencion(new java.sql.Date(System.currentTimeMillis()));  
                        
                        //jrivas BLO-01
                        ganad.setClienteBloqueado(new Boolean(clientePremiacion.getClienteBloqueado()));
                        
                        ganadoras.merge(ganad);
                        
                    } catch (CreateException e) {
                        UtilidadesLog.error("ERROR ", e);
                        throw new MareException(new Exception(), UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS));
                    } catch (RemoteException re) {
                        UtilidadesLog.error("ERROR ", re);
                        throw new MareException(re, UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
                    } 
                }
            }
        }

        UtilidadesLog.debug(" * SALE de MONMantenimientoRankingBean.actualizarGanadoras *");
        UtilidadesLog.error("MONMantenimientoRankingBean.actualizarGanadoras(DTOEntregaPremios dtoIn):Salida");
    }


    private BigDecimal getValue(BigDecimal obj) {
        return (obj != null) ? obj : new BigDecimal("0");
    }

    private BigDecimal getValue(Long obj) {
        return (obj != null) ? new BigDecimal(obj.toString()) : new BigDecimal("0");
    }

    /**
     * Sistema: Belcorp
     * Módulo:  INC
     * Fecha:   28/07/2005
     * @version 1.00
     * @autor   Diego Morello
     */
    public void asignarPremiosRanking(DTOAsignarPremios dto)
            throws MareException {
        UtilidadesLog.error("MONMantenimientoRankingBean.asignarPremiosRanking(DTOAsignarPremios dto):Entrada");
        UtilidadesLog.debug("Ingreso al metodo asignarPremiosRanking con DTOAsignarPremios: " + dto);
        try {
            ParametrosGeneralesPremiacionLocalHome pgPremHome = this.getParametrosGeneralesPremiacionLocalHome();
            ConcursoParametrosGeneralesLocalHome pgHome = this.getConcursoParametrosGeneralesLocalHome();
            MONPeriodosHome monPerHome = CRAEjbLocators.getMONPeriodosHome();
            ParametrosNivelPremiacionLocalHome pnpHome = this.getParametrosNivelPremiacionLocalHome();
            GanadorasLocal ganadoras = null;

            ConcursoParametrosGeneralesLocal concurso = null;
            ParametrosGeneralesPremiacionLocal pgPrem = null;
            ParametrosNivelPremiacionLocal pNivel = null;
            Long periodoDespacho = null;

            // Obtener periodo actual 
            // vbongiov - 10/05/2006 - DBLG500000363
            MONPeriodos monPer = monPerHome.create();
            
            Boolean listarGanador = Boolean.FALSE;
            Boolean despachado = Boolean.FALSE;
            Boolean descontar = Boolean.FALSE;

            GanadorasLocalHome ganHome = this.getGanadorasLocalHome();

            Long[] nivelesPrem = dto.getOidNivelesPremios();
            int numNivPrem = nivelesPrem.length;
            
            for (int i = 0; i < numNivPrem; i++) {
                UtilidadesLog.debug("nivelesPrem[" + i + "]: " + nivelesPrem[i]);
                
                pNivel = pnpHome.findByPrimaryKey(nivelesPrem[i]);
                
                pgPrem = pgPremHome.findByPrimaryKey(pNivel.getPremiacion());                
                concurso = pgHome.findByPrimaryKey(pgPrem.getConcurso());
                
                // Obtener periodo actual 
                // vbongiov - 10/05/2006 - DBLG500000363
                UtilidadesLog.debug("concurso.getPais(): " + concurso.getPais());
                UtilidadesLog.debug("concurso.getMarca(): " + concurso.getMarca());
                UtilidadesLog.debug("concurso.getCanal(): " + concurso.getCanal());
    
                DTOPeriodo dtoPeriodo = monPer.obtienePeriodoActual(concurso.getPais(), concurso.getMarca(), concurso.getCanal());
                periodoDespacho = dtoPeriodo.getOid();
                
                BigDecimal unidades = new BigDecimal("0");
                Long tipoPremio = pNivel.getTipoPremio();

                if (tipoPremio.equals(ConstantesINC.OID_TIPO_PREMIO_MONETARIO)) {
                    PremioMonetarioLocalHome monHome = this.getPremioMonetarioLocalHome();
                    PremioMonetarioLocal mon = monHome.findByUK(nivelesPrem[i]);

                    if (mon.getCantidad() != null) {
                        unidades = mon.getCantidad();
                    }
                } else if (tipoPremio.equals(ConstantesINC.OID_TIPO_PREMIO_ARTICULO)) {
                    PremioArticuloLocalHome artHome = this.getPremioArticuloLocalHome();
                    PremioArticuloLocal art = artHome.findByUK(nivelesPrem[i]);

                    if (art.getNumeroUnidades() != null) {
                        unidades = new BigDecimal(art.getNumeroUnidades().toString());
                    }
                } else if (tipoPremio.equals(ConstantesINC.OID_TIPO_PREMIO_PUNTOS)) {
                    PremioPuntosLocalHome puntHome = this.getPremioPuntosLocalHome();
                    PremioPuntosLocal punt = puntHome.findByUK(nivelesPrem[i]);

                    if (punt.getCantidad() != null) {
                        unidades = new BigDecimal(punt.getCantidad().toString());
                    }
                } else if (tipoPremio.equals(ConstantesINC.OID_TIPO_PREMIO_DESCUENTO)) {
                    PremioDescuentoLocalHome descHome = this.getPremioDescuentoLocalHome();
                    PremioDescuentoLocal desc = descHome.findByUK(nivelesPrem[i]);

                    if (desc.getCantidadDescuento() != null) {
                        unidades = desc.getCantidadDescuento();
                    }
                }

                Long[] gerentes = dto.getOidGanadores();
                int numGerentes = gerentes.length;

                for (int j = 0; j < numGerentes; j++) {
                    ganadoras = ganHome.create(unidades, listarGanador, descontar, despachado, gerentes[i], periodoDespacho, pNivel.getOid());
                    
                    // vbongiov - 10/05/2006 - DBLG500000363
                    ganadoras.setFechaObtencion(new java.sql.Date(System.currentTimeMillis()));     
                    
                    //jrivas BLO-001 
                    DAOClientePremiacion dao = new DAOClientePremiacion();
                    ganadoras.setClienteBloqueado(new Boolean(dao.validarClienteBloqueado(gerentes[i], concurso.getPais())));
                    
                    ganHome.merge(ganadoras);
                    
                }
            } // Fin for OIDs niveles premiación
        } catch (NoResultException e) {
            UtilidadesLog.error("ERROR ", e);
            int error = UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE);
            throw new MareException(e, error);
        } catch (PersistenceException ce) {
            UtilidadesLog.error("ERROR ", ce);
            throw new MareException(ce, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS));
        } catch (CreateException e) {
            UtilidadesLog.error("ERROR ", e);
            int error = UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS);
            throw new MareException(e, error);
        } catch (RemoteException e) {
            UtilidadesLog.error("ERROR ", e);
            int error = UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB);
            throw new MareException(e, error);
        }  catch (Exception e) {
            UtilidadesLog.error("ERROR ", e);
            throw new MareException(e);
        }
        UtilidadesLog.error("MONMantenimientoRankingBean.asignarPremiosRanking(DTOAsignarPremios dto):Salida");
    }
    
    /**
     * Sistema: Belcorp
     * Módulo:  INC
     * Fecha:   20/04/2006
     * @version 1.00
     * @autor   Viviana Bongiovanni
     * Inc DBLG500000590 y DBLG500000591
     */
    public void generarEvaluacionRanking(DTOVentaRankingGerentes dto) throws MareException {
    
        UtilidadesLog.info("MONMantenimientoRankingBean.generarEvaluacionRanking(DTOVentaRankingGerentes dto):Entrada");
      
        try {
            DTOFACProcesoCierre dtoProceso = new DTOFACProcesoCierre();
            
            ConcursoParametrosGeneralesLocalHome home = this.getConcursoParametrosGeneralesLocalHome();
            ConcursoParametrosGeneralesLocal concurso = home.findByPrimaryKey(dto.getOidConcurso());

            MONPeriodosHome homePeriodos = CRAEjbLocators.getMONPeriodosHome();
            MONPeriodos monPeriodos = homePeriodos.create();
            
            //DBLG500000746 - gPineda - 06/11/2006
            //DTOPeriodo dtoPeri = monPeriodos.obtienePeriodoActual(concurso.getPais(), concurso.getMarca(), concurso.getCanal());
            DTOPeriodo dtoPeri = monPeriodos.obtieneMenorPeriodoActual(concurso.getPais(), concurso.getMarca(), concurso.getCanal());

            dtoProceso.setPeriodo(dtoPeri.getOid());
            dtoProceso.setMarca(dtoPeri.getMarca());
            dtoProceso.setCanal(dtoPeri.getCanal());
            dtoProceso.setOidPais(dtoPeri.getPais());

            MONRankingHome monRankingHome = this.getMONRankingHome();
            MONRanking monRanking = monRankingHome.create();

            monRanking.evaluarRanking(dtoProceso, dto.getOidConcurso());
            
            UtilidadesLog.info("MONMantenimientoRankingBean.generarEvaluacionRanking(DTOVentaRankingGerentes dto):Salida");           
            
        } catch (NoResultException e) {
            UtilidadesLog.error("ERROR ", e);
            int error = UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE);
            throw new MareException(e, error);
        } catch (PersistenceException ce) {
            UtilidadesLog.error("ERROR ", ce);
            throw new MareException(ce, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS));
        } catch (CreateException e) {
            UtilidadesLog.error("ERROR ", e);
            int error = UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB);
            throw new MareException(e, error);
        } catch (RemoteException e) {
            UtilidadesLog.error("ERROR ", e);
            int error = UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB);
            throw new MareException(e, error);
        } catch (NamingException e) {
            UtilidadesLog.error("ERROR ", e);
            int error = UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB);
            throw new MareException(e, error);
        }

  }
  
  /**
   * Sistema: Belcorp
   * Módulo:  INC
   * Fecha:   26/07/2006
   * @version 1.00
   * @autor   Viviana Bongiovanni
   * Inc DBLG500000906
   */
  public void calificar(DTOComunicarParticipantes dtoIn) throws MareException {  
      UtilidadesLog.info("MONMantenimientoRankingBean.calificar(DTOComunicarParticipantes dtoIn):Entrada");
      UtilidadesLog.debug("dtoIn : " + dtoIn);

      ConcursoParametrosGeneralesLocalHome home = this.getConcursoParametrosGeneralesLocalHome();
      ConcursoParametrosGeneralesLocal concurso;

      try {
          Long pk = dtoIn.getOidConcurso();
          concurso = home.findByPrimaryKey(pk);
      } catch (NoResultException e) {
          UtilidadesLog.error("ERROR ", e);
          int error = UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE);
          throw new MareException(e, error);
      } catch (PersistenceException ce) {
          UtilidadesLog.error("ERROR ", ce);
          throw new MareException(ce, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS));
      }

      Long periodoActual = null;

      try {
          MONPeriodosHome monPerHome = CRAEjbLocators.getMONPeriodosHome();
          MONPeriodos monPer = monPerHome.create();
          DTOPeriodo dtoPeriodo = monPer.obtienePeriodoActual(concurso.getPais(), concurso.getMarca(), concurso.getCanal());
          periodoActual = dtoPeriodo.getOid();
      } catch (CreateException e) {
          UtilidadesLog.error("ERROR ", e);
          int error = UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB);
          throw new MareException(e, error);
      } catch (RemoteException e) {
          UtilidadesLog.error("ERROR ", e);
          int error = UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB);
          throw new MareException(e, error);
      }
      
      Long[] oidCliente = dtoIn.getClientes();
      Long[] posiciones = dtoIn.getPosicion();
      //Cambio segun incidencia 21876 - dmaneiro - 07/12/2005
      Entidadi18nLocalHome ei18nlh = this.getEntidadi18nLocalHome();
      Long atrib = new Long(ConstantesINC.NUM_ATRIBUTO.longValue());
      String descTipoPremio = null;
             
      for (int i = 0; i < dtoIn.getClientes().length; i++) {
          
          try {
              UtilidadesLog.debug("********* Antes de llamar a findByEntAtrIdioPK con:");
              UtilidadesLog.debug("********* ConstantesINC.ENTIDAD_TIPO_PREMIO " + ConstantesINC.ENTIDAD_TIPO_PREMIO);
              UtilidadesLog.debug("********* DTOE.getOidIdioma() " + dtoIn.getOidIdioma());
            
              Entidadi18nLocal ei18nl = ei18nlh.findByEntAtrIdioPK(ConstantesINC.ENTIDAD_TIPO_PREMIO, atrib, dtoIn.getOidIdioma(), dtoIn.getOidTipoPremio());
             
              descTipoPremio = ei18nl.getDetalle();
              
            } catch (NoResultException nre) {
              UtilidadesLog.debug(nre);
              UtilidadesLog.debug("********* Antes de llamar a findByEntAtrIdioPK con idioma por defecto");
              
              try{
              Entidadi18nLocal ei18nl2 = ei18nlh.findByEntAtrIdioPK(ConstantesINC.ENTIDAD_TIPO_PREMIO, atrib, ConstantesSEG.IDIOMA_DEFECTO,
                                                                dtoIn.getOidTipoPremio());
              descTipoPremio = ei18nl2.getDetalle();
              
              } catch (NoResultException nrex) {
                  UtilidadesLog.debug(nrex);                  
                  UtilidadesLog.debug("********* Despues de llamar a findByEntAtrIdioPK con idioma por defecto");
              } catch (PersistenceException ce) {
                  UtilidadesLog.error("ERROR ", ce);
                  throw new MareException(ce, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS));
              }
             
          } catch (PersistenceException ce) {
              UtilidadesLog.error("ERROR ", ce);
              throw new MareException(ce, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS));
          } //FIN de Agregado 
          
          DTOEntregaPremios dtoEntrega = new DTOEntregaPremios();

          dtoEntrega.setOidConcurso(dtoIn.getOidConcurso());
          dtoEntrega.setOidPais(concurso.getPais());
          dtoEntrega.setOidMarca(concurso.getMarca());
          dtoEntrega.setOidCanal(concurso.getCanal());
          dtoEntrega.setOidDirigidoA(concurso.getDirigidoA());
          dtoEntrega.setOidCliente(oidCliente[i]);

          ClienteDatosAdicionalesLocal clienteAdic = null;

          try {
              //--Hacer un cliente.findByPK(dto.get(oidCliente[i])) 
              clienteAdic = this.getClienteDatosAdicionalesLocalHome().findByCliente(oidCliente[i]);
          } catch (NoResultException nre) {
              sessionContext.setRollbackOnly();
               UtilidadesLog.error("ERROR ", nre);
              throw new MareException(nre,        
                  UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE) );         
          } catch (PersistenceException ce) {
              UtilidadesLog.error("ERROR ", ce);
              throw new MareException(ce, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS));
          }

          if (clienteAdic.getCod_empl() != null) {
              dtoEntrega.setCodEmpleado(Long.valueOf(clienteAdic.getCod_empl()));
          }

          dtoEntrega.setOidPeridodo(periodoActual);
          dtoEntrega.setOidNivelPremiacion(dtoIn.getOidNivelPremiacion());
          dtoEntrega.setDescTipoPremio(descTipoPremio);
          
          UtilidadesLog.debug(" se llama a entregaDePremios " + dtoEntrega);
          try {
              this.entregaDePremiosEvolutivo(dtoEntrega);
          } catch (Exception ex) {
              UtilidadesLog.error("ERROR ", ex);
              int error = UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB);
              throw new MareException(ex, error);
          }
          UtilidadesLog.debug(" sale de entrega premios");
      }
      
      UtilidadesLog.info("MONMantenimientoRankingBean.calificar(DTOComunicarParticipantes dtoIn):salida");
  }
  
  /**
   * Sistema: Belcorp
   * Módulo:  INC
   * Fecha:   26/07/2006
   * @version 1.00
   * @autor   Viviana Bongiovanni
   * Inc DBLG500000906
   */
  public void comunicarAParticipantesEvolutivo(DTOComunicarParticipantes dtoIn) throws MareException {
  UtilidadesLog.info("MONMantenimientoRankingBean.comunicarAParticipantesEvolutivo(DTOComunicarParticipantes dtoIn):Entrada");
        UtilidadesLog.debug("dto : " + dtoIn);

        if(this.validarFaseCalificacion(dtoIn.getOidConcurso()).booleanValue()) {
        
            ConcursoParametrosGeneralesLocalHome home = this.getConcursoParametrosGeneralesLocalHome();
            ConcursoParametrosGeneralesLocal concurso;
    
            try {
                Long pk = dtoIn.getOidConcurso();
                concurso = home.findByPrimaryKey(pk);
            } catch (NoResultException e) {
                UtilidadesLog.error("ERROR ", e);
                int error = UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE);
                throw new MareException(e, error);
            } catch (PersistenceException ce) {
                UtilidadesLog.error("ERROR ", ce);
                throw new MareException(ce, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS));
            }
    
            String numeroConcurso = concurso.getNumeroConcurso();
    
            MensajesLocal mensajesL = null;
            String codMensaje = " ";
                    
            try {
                MensajesLocalHome mensajesLH = this.getMensajesLocalHome();
                mensajesL = mensajesLH.findByPrimaryKey(ConstantesINC.OID_MENSAJE_RANKING);
            } catch (NoResultException e) {
                UtilidadesLog.error("ERROR ", e);
                int error = UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE);
                throw new MareException(e, error);
            } catch (PersistenceException ne) {
                UtilidadesLog.error("ERROR ", ne);
                throw new MareException(ne, UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
            }
            codMensaje = mensajesL.getCodMensaje();
            PeriodoLocal periodoL = null;
    
            try {
                PeriodoLocalHome periodoLH = this.getPeriodoLocalHome();
                periodoL = periodoLH.findByPrimaryKey(concurso.getPeriodoDesde());
            } catch (NoResultException nre) {
                sessionContext.setRollbackOnly();
                 UtilidadesLog.error("ERROR ", nre);
                throw new MareException(nre,        
                    UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE) );         
            } catch (PersistenceException ce) {
                UtilidadesLog.error("ERROR ", ce);
                throw new MareException(ce, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS));
            }
                    
            String campaniaInicio = periodoL.getNombrePeriodo();
                    
            try {
                PeriodoLocalHome periodoLHome = this.getPeriodoLocalHome();
                periodoL = periodoLHome.findByPrimaryKey(concurso.getPeriodoHasta());
            } catch (NoResultException nre) {
                sessionContext.setRollbackOnly();
                 UtilidadesLog.error("ERROR ", nre);
                throw new MareException(nre,        
                    UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE) );         
            } catch (PersistenceException ce) {
                UtilidadesLog.error("ERROR ", ce);
                throw new MareException(ce, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS));
            }
    
            String campaniaFin = periodoL.getNombrePeriodo();
            Long periodoActual = null;
    
            try {
                MONPeriodosHome monPerHome = CRAEjbLocators.getMONPeriodosHome();
                MONPeriodos monPer = monPerHome.create();
                DTOPeriodo dtoPeriodo = monPer.obtienePeriodoActual(concurso.getPais(), concurso.getMarca(), concurso.getCanal());
                periodoActual = dtoPeriodo.getOid();
            } catch (CreateException e) {
                UtilidadesLog.error("ERROR ", e);
                int error = UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB);
                throw new MareException(e, error);
            } catch (RemoteException e) {
                UtilidadesLog.error("ERROR ", e);
                int error = UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB);
                throw new MareException(e, error);
            }
            
    
            DTOBuzonMensajes dtoBuzonM = new DTOBuzonMensajes();
            Long[] oidCliente = dtoIn.getClientes();
            Long[] posiciones = dtoIn.getPosicion();
            //Cambio segun incidencia 21876 - dmaneiro - 07/12/2005
            Entidadi18nLocalHome ei18nlh = this.getEntidadi18nLocalHome();
            Long atrib = new Long(ConstantesINC.NUM_ATRIBUTO.longValue());
                   
            for (int i = 0; i < dtoIn.getClientes().length; i++) {
            
                //jrivas BLO-01
                DAOClientePremiacion dao = new DAOClientePremiacion();
                boolean clienteBloqueado = dao.validarClienteBloqueado(oidCliente[i], concurso.getPais());
                if (!clienteBloqueado) {
             
                    ClienteDatosBasicosLocal cliente = null;
        
                    try {
                       cliente = this.getClienteDatosBasicosLocalHome().findByPrimaryKey(oidCliente[i]);
                    } catch (NoResultException nre) {
                        sessionContext.setRollbackOnly();
                         UtilidadesLog.error("ERROR ", nre);
                        throw new MareException(nre,        
                            UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE) );         
                    } catch (PersistenceException ce) {
                        UtilidadesLog.error("ERROR ", ce);
                        throw new MareException(ce, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS));
                    }
                
                    dtoBuzonM.setOidPais(dtoIn.getOidPais());
                    dtoBuzonM.setCodigoMensaje(codMensaje);
                    dtoBuzonM.setOidCliente(oidCliente[i]);
                    dtoBuzonM.setModuloOrigen(Long.valueOf(ConstantesSEG.MODULO_INC));
                    dtoBuzonM.setDatoVariable6(numeroConcurso);
                           
                    String nombre1 = new String(" ");
                    
                    if ((cliente.getVal_nom1() != null) && (cliente.getVal_nom1().length() > 0)) {
                        nombre1 = cliente.getVal_nom1();
                    }
                                
                    String nombre2 = new String(" ");
        
                    if (cliente.getVal_nom2() != null) {
                        nombre2 = " " + cliente.getVal_nom2();
                    }
                    
                    String apellido1 = new String(" ");
        
                    if (cliente.getVal_ape1() != null) {
                        apellido1 = " " + cliente.getVal_ape1();
                    }
                                
                    String apellido2 = new String(" ");
        
                    if (cliente.getVal_ape2() != null) {
                        apellido2 = " " + cliente.getVal_ape2();
                    }
                    
                    
                    dtoBuzonM.setDatoVariable1(nombre1 + nombre2 + apellido1 + apellido2);
                    dtoBuzonM.setDatoVariable2(campaniaInicio);
                    dtoBuzonM.setDatoVariable3(campaniaFin);
                    dtoBuzonM.setDatoVariable4(posiciones[i].toString());
                    
                     //Agregado por inc 21876 - dmaneiro - 07/12/2005
                    try {
                        UtilidadesLog.debug("********* Antes de llamar a findByEntAtrIdioPK con:");
                        UtilidadesLog.debug("********* ConstantesINC.ENTIDAD_TIPO_PREMIO " + ConstantesINC.ENTIDAD_TIPO_PREMIO);
                        UtilidadesLog.debug("********* DTOE.getOidIdioma() " + dtoIn.getOidIdioma());
                      
                        Entidadi18nLocal ei18nl = ei18nlh.findByEntAtrIdioPK(ConstantesINC.ENTIDAD_TIPO_PREMIO, atrib, dtoIn.getOidIdioma(), dtoIn.getOidTipoPremio());
                       
                        dtoBuzonM.setDatoVariable5(ei18nl.getDetalle());
                    } catch (NoResultException nre) {
                        UtilidadesLog.debug(nre);
                        UtilidadesLog.debug("********* Antes de llamar a findByEntAtrIdioPK con idioma por defecto");
                        
                        try{
                        Entidadi18nLocal ei18nl2 = ei18nlh.findByEntAtrIdioPK(ConstantesINC.ENTIDAD_TIPO_PREMIO, atrib, ConstantesSEG.IDIOMA_DEFECTO,
                                                                          dtoIn.getOidTipoPremio());
                        dtoBuzonM.setDatoVariable5(ei18nl2.getDetalle());
                        
                        } catch (NoResultException nrex) {
                            UtilidadesLog.debug(nrex);                  
                            UtilidadesLog.debug("********* Despues de llamar a findByEntAtrIdioPK con idioma por defecto");
                        } catch (PersistenceException ce) {
                            UtilidadesLog.error("ERROR ", ce);
                            throw new MareException(ce, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS));
                        }
                       
                    } catch (PersistenceException ce) {
                        UtilidadesLog.error("ERROR ", ce);
                        throw new MareException(ce, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS));
                    }//FIN de Agregado 
                   
                    dtoBuzonM.setListaConsultoras(ConstantesMSG.NO);
                    dtoBuzonM.setCodigoPatron("Ultimas Noticias");
                    UtilidadesLog.debug(" DTOBuzonMensajes: " + dtoBuzonM);
        
                    try {
                        MONGestionMensajesHome monMsgHome = MSGEjbLocators.getMONGestionMensajesHome();
                        MONGestionMensajes monMSG = monMsgHome.create();
        
                        UtilidadesLog.debug(" Antes de insertar +  " + dtoBuzonM);
                        monMSG.insertaDatosMensajeBatch(dtoBuzonM);
                        UtilidadesLog.debug(" Sale de insertar");
                    } catch (CreateException e) {
                        UtilidadesLog.error("ERROR ", e);
                        int error = UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB);
                        throw new MareException(e, error);
                    } catch (RemoteException e) {
                        UtilidadesLog.error("ERROR ", e);
                        int error = UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB);
                        throw new MareException(e, error);
                    }
                } //IF CLIENTE BLOQUEADO
            }
            
        } else {
            int error = UtilidadesError.armarCodigoError(ConstantesSEG.MODULO_INC, "", ErroresDeNegocio.INC_0054);
            throw new MareException(null, null, error);
        }
        
        UtilidadesLog.info("MONMantenimientoRankingBean.comunicarAParticipantesEvolutivo(DTOComunicarParticipantes dtoIn):salida");
  }
  
  /**
   * Sistema: Belcorp
   * Módulo:  INC
   * Fecha:   26/07/2006
   * @version 1.00
   * @autor   Viviana Bongiovanni
   * Inc DBLG500000906
   */
  public void entregaDePremiosEvolutivo(DTOEntregaPremios dtoIn) throws MareException {
      UtilidadesLog.error("MONMantenimientoRankingBean.entregaDePremiosEvolutivo(DTOEntregaPremios dtoIn):Entrada");
      UtilidadesLog.debug("dtoIn : " + dtoIn);

      try {
          ClientePremiacion cliePrem = new ClientePremiacion();
          
          cliePrem.setOidCliente(dtoIn.getOidCliente());
          cliePrem.setOidPais(dtoIn.getOidPais());
          cliePrem.setOidMarca(dtoIn.getOidMarca());
          cliePrem.setOidCanal(dtoIn.getOidCanal());
          cliePrem.setOidCodigoEmpleado(dtoIn.getCodEmpleado()!=null?dtoIn.getCodEmpleado().toString():null);
          
          //jrivas BLO-01
          DAOClientePremiacion daoCP = new DAOClientePremiacion();
          boolean clienteBloqueado = daoCP.validarClienteBloqueado(dtoIn.getOidCliente(), dtoIn.getOidPais());
          cliePrem.setClienteBloqueado(clienteBloqueado);
          
          DTOETramitarCierre dtoe = new DTOETramitarCierre();
    
          dtoe.setOidPeriodo(dtoIn.getOidPeridodo());
          dtoe.setOidPais(dtoIn.getOidPais());
          dtoe.setOidMarca(dtoIn.getOidMarca());
          dtoe.setOidCanal(dtoIn.getOidCanal());
    
          DAOClientePremiacion dao = new DAOClientePremiacion();
          Periodo periodo = dao.obtenerPeriodo(dtoe);
    
          cliePrem.setPeriodo(periodo);
    
          ClientePremiacionConcurso clieConc = new ClientePremiacionConcurso();
         
          clieConc.setOidConcurso(dtoIn.getOidConcurso());
          boolean valor = true;
    
          clieConc.setRequisitosPremiacionSuperado(valor);
          clieConc.setDirigidoA(dtoIn.getOidDirigidoA());
    
          DAOClientePremiacionConcurso daoCliente = new DAOClientePremiacionConcurso();
    
          //  Se agrego un parametro null, Modificado por HRCS - Fecha 29/03/2007 - Incidencia Sicc 20070173
          Premio premio = daoCliente.recuperarPremioPorNivel(dtoIn.getOidNivelPremiacion(), null);
          UtilidadesLog.debug("premio.getOidPremio(): " + premio.getOidPremio());
          UtilidadesLog.debug("premio.getPeriodoDeDespacho(): " + premio.getPeriodoDeDespacho().getOidPeriodo());
          UtilidadesLog.debug("premio.getCantidad(): " + premio.getCantidad());
          
          // Si no hay periodo de despacho se toma el actual
          if(premio.getPeriodoDeDespacho().getOidPeriodo()==null) {
              premio.getPeriodoDeDespacho().setOidPeriodo(dtoIn.getOidPeridodo());        
          }
          
          UtilidadesLog.debug("premio.getPeriodoDeDespacho(): " + premio.getPeriodoDeDespacho().getOidPeriodo());
    
          ArrayList arrPremioGan = new ArrayList();
          arrPremioGan.add(premio);
    
          clieConc.setPremiosGanados(arrPremioGan);
    
          HashMap cliente = new HashMap();
          cliente.put(clieConc, clieConc);
    
          cliePrem.setClientesPremiacionConcurso(cliente);
    
          UtilidadesLog.debug(" ClientePremiacion: " + cliePrem);
    
          this.actualizarGanadoras(cliePrem);
    
          // Despachar premio
          UtilidadesLog.debug("antes de despacharPremios");
          DespacharPremiosHelper despacharPremiosHelper = new DespacharPremiosHelper();
          Iterator itClienConcursos = cliePrem.getClientesPremiacionConcurso().keySet().iterator();
          ClientePremiacionConcurso clienteConcurso = null;

          UtilidadesLog.debug("ClientesPremiacionConcurso cantidad" + cliePrem.getClientesPremiacionConcurso().size());

          while (itClienConcursos.hasNext()) {
              Object key = itClienConcursos.next();
              clienteConcurso = (ClientePremiacionConcurso) cliePrem.getClientesPremiacionConcurso().get(key);
              UtilidadesLog.debug("clienteConcurso.getRequisitosPremiacionSuperado() " + clienteConcurso.getRequisitosPremiacionSuperado());

              if (clienteConcurso.getRequisitosPremiacionSuperado()) {
                  UtilidadesLog.debug("clienteConcurso.getPremiosGanados()() " + clienteConcurso.getPremiosGanados());

                  if (clienteConcurso.getPremiosGanados() != null) {
                      Iterator itPremios = clienteConcurso.getPremiosGanados().iterator();

                      while (itPremios.hasNext()) {
                          Premio premioGanado = (Premio) itPremios.next();
                          UtilidadesLog.debug("premioGanado " + premioGanado);
                          UtilidadesLog.debug("premioGanado.getTipoPremio() " + premioGanado.getTipoPremio());

                          if (ConstantesINC.TIPO_PREMIO_MONETARIO.equals(premioGanado.getTipoPremio())) {
                              despacharPremiosHelper.despacharPremioTipoMonetario(cliePrem, premioGanado, clienteConcurso);
                          } else if (ConstantesINC.TIPO_PREMIO_ARTICULO.equals(premioGanado.getTipoPremio())) {
                              despacharPremiosHelper.despacharPremioTipoArticulo(cliePrem, premioGanado, clienteConcurso);
                          } else if (ConstantesINC.TIPO_PREMIO_PUNTUACION.equals(premioGanado.getTipoPremio())) {
                              despacharPremiosHelper.despacharPremioTipoPuntuacion(cliePrem, premioGanado, clienteConcurso);
                          } else if (ConstantesINC.TIPO_PREMIO_DESCUENTOS.equals(premioGanado.getTipoPremio())) {
                              despacharPremiosHelper.despacharPremioTipoDescuentos(cliePrem, premioGanado, clienteConcurso);
                          }
                      } //while(itPremios.hasNext())
                  } //clienteConcurso.getPremiosGanados() != null
              } //clienteConcurso.getRequisitosPremiacionSuperado()
          } //while(itClienConcursos.hasNext())
      
          UtilidadesLog.debug("sale de despacharPremios");
          
          //jrivas BLO-01
          if (!cliePrem.getClienteBloqueado()) {

              UtilidadesLog.debug("empieza comunicacion");
              // Comunicacion al cliente
          
              ConcursoParametrosGeneralesLocalHome home = this.getConcursoParametrosGeneralesLocalHome();
              ConcursoParametrosGeneralesLocal concurso;
              String numeroConcurso = "";
              
              Long pk = dtoIn.getOidConcurso();
              concurso = home.findByPrimaryKey(pk);
              numeroConcurso = concurso.getNumeroConcurso();                  
            
              MensajesLocal mensajesL = null;
              String codMensaje = " ";                      
              
              MensajesLocalHome mensajesLH = this.getMensajesLocalHome();
              mensajesL = mensajesLH.findByPrimaryKey(ConstantesINC.OID_MENSAJE_RANKING);
              
              codMensaje = mensajesL.getCodMensaje();
              
              // Periodo inicio
              PeriodoLocal periodoL = null;      
              String campaniaInicio = "";
              
              PeriodoLocalHome periodoLH = this.getPeriodoLocalHome();
              periodoL = periodoLH.findByPrimaryKey(concurso.getPeriodoDesde());
              campaniaInicio = periodoL.getNombrePeriodo();
              
              // Periodo fin
              String campaniaFin = "";  
              PeriodoLocalHome periodoLHome = this.getPeriodoLocalHome();
              periodoL = periodoLHome.findByPrimaryKey(concurso.getPeriodoHasta());
              campaniaFin = periodoL.getNombrePeriodo();
                  
              ParametrosNivelPremiacionLocalHome pnpHome = this.getParametrosNivelPremiacionLocalHome();
              ParametrosNivelPremiacionLocal pnp = pnpHome.findByPrimaryKey(dtoIn.getOidNivelPremiacion());
              
              String numeroNivel = pnp.getNumeroNivel().toString();
              
              // Obtendo territorio y zona
              DTOBusquedaZonaTerritorioUA dtoZonaTerri = new DTOBusquedaZonaTerritorioUA();
              dtoZonaTerri.setOidPais(dtoIn.getOidPais());
              dtoZonaTerri.setOidMarca(dtoIn.getOidMarca());
              dtoZonaTerri.setOidCanal(dtoIn.getOidCanal());
              dtoZonaTerri.setOidCliente(dtoIn.getOidCliente());
              
              MONClientes monCliente = MAEEjbLocators.getMONClientesHome().create();
              
              RecordSet rs = monCliente.obtenerZonaTerritorioUA(dtoZonaTerri).getResultado();
              
              String codigoZona = "";    
              String codigoTerritorio = "";
              
              if(!rs.esVacio()){
                 codigoZona = (String)rs.getValueAt(0, "COD_ZONA");              
                 codigoTerritorio = ((BigDecimal)rs.getValueAt(0, "COD_TERR")).toString();
              }
              
              // Obtengo las unidades
              ClientePremiacionConcurso clientePremConc = (ClientePremiacionConcurso)cliePrem.getClientesPremiacionConcurso().get(clieConc);          
              Premio premioG = (Premio)clientePremConc.getPremiosGanados().get(0);
              
              String unidades = premioG.getUnidades().toString();
              String descTipoPremio = premioG.getDescripcionTipoPremio();
              
              DTOBuzonMensajes dtoBuzonM = new DTOBuzonMensajes();
              
              ClienteDatosBasicosLocal clienteBasico = this.getClienteDatosBasicosLocalHome().findByPrimaryKey(dtoIn.getOidCliente());
              
              dtoBuzonM.setOidPais(dtoIn.getOidPais());
              dtoBuzonM.setCodigoMensaje(codMensaje);
              dtoBuzonM.setOidCliente(dtoIn.getOidCliente());
              dtoBuzonM.setModuloOrigen(Long.valueOf(ConstantesSEG.MODULO_INC));
              
              dtoBuzonM.setDatoVariable10((clienteBasico.getVal_nom1()!=null?clienteBasico.getVal_nom1():"") + " " + 
                                          (clienteBasico.getVal_nom2()!=null?clienteBasico.getVal_nom2():"") + " " + 
                                          (clienteBasico.getVal_ape1()!=null?clienteBasico.getVal_ape1():"") + " " +
                                          (clienteBasico.getVal_ape2()!=null?clienteBasico.getVal_ape2():""));
              
              dtoBuzonM.setDatoVariable1((clienteBasico.getVal_nom1()!=null?clienteBasico.getVal_nom1():""));
              dtoBuzonM.setDatoVariable2((clienteBasico.getVal_ape1()!=null?clienteBasico.getVal_ape1():""));
              dtoBuzonM.setDatoVariable3(clienteBasico.getCod_clie());
              dtoBuzonM.setDatoVariable4(codigoZona);
              dtoBuzonM.setDatoVariable5(codigoTerritorio);
              dtoBuzonM.setDatoVariable6(numeroNivel);
              dtoBuzonM.setDatoVariable7(descTipoPremio);
              dtoBuzonM.setDatoVariable8(unidades);
              
              dtoBuzonM.setListaConsultoras(ConstantesMSG.NO);
              dtoBuzonM.setCodigoPatron("Ultimas Noticias");
              
              MONGestionMensajesHome monMsgHome = MSGEjbLocators.getMONGestionMensajesHome();
              MONGestionMensajes monMSG = monMsgHome.create();
    
              UtilidadesLog.debug(" dtoBuzonM: " + dtoBuzonM);
              monMSG.insertaDatosMensajeBatch(dtoBuzonM);            
          } 
      } catch (CreateException e) {
          UtilidadesLog.error("ERROR ", e);
          int error = UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB);
          throw new MareException(e, error);
      } catch (RemoteException e) {
          UtilidadesLog.error("ERROR ", e);
          int error = UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB);
          throw new MareException(e, error);
      } catch (MareException me) {
          UtilidadesLog.error("ERROR ", me);
          sessionContext.setRollbackOnly();
          throw me;
      } catch (Exception e) {
          UtilidadesLog.error("ERROR ", e);
          sessionContext.setRollbackOnly();
          throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
      }

      UtilidadesLog.error("MONMantenimientoRankingBean.entregaDePremiosEvolutivo(DTOEntregaPremios dtoIn):Salida");
  }

  
  /**
    * Sistema:     Belcorp
    * Modulo:      INC
    * Fecha:       17/11/2006
    * @version     1.0
    * @autor       Viviana Bongiovanni
    */ 
  public void preProcesoSolicitudesVariableVentaRanking(Long oidConcurso) throws MareException {
      UtilidadesLog.info("MONMantenimientoRanking.preProcesoSolicitudesVariableVentaRanking(Long oidConcurso):Entrada");
      UtilidadesLog.debug("oidConcurso: " + oidConcurso);
      
      try {
      
          FactoriaConcurso factoria= FactoriaConcurso.getFactoriaConcurso();
       
          DTOOIDs dtoOids = new DTOOIDs();
          Long[] oids = { oidConcurso };
          dtoOids.setOids(oids);
    
          ArrayList concursos = factoria.getConcursosPorOID(dtoOids);
          Concurso concurso = (Concurso) concursos.get(0);
          
          MONIncentivos monInc = this.getMONIncentivosHome().create();    
          
          DAOBaseCalculo daoBaseCalculo = new DAOBaseCalculo();
         
          RecordSet rs = daoBaseCalculo.obtenerSolicitudesFacturadas(null, concurso.getPeriodoDesde().getOidPeriodo(), 
                                                                     concurso.getPeriodoHasta().getOidPeriodo(), Boolean.valueOf(concurso.getIndAnulacion()),Boolean.valueOf(concurso.getIndDevolucion()));
          
          if(rs!=null) {
                            
              int cant = rs.getRowCount();
              
              for (int row = 0; row < cant; row++) {
              
                  DTOSolicitudValidacion registro = new DTOSolicitudValidacion();
                  
                  registro.setOidCliente((rs.getValueAt(row, "CLIE_OID_CLIE") == null) ? null
                                                                                       : new Long(((BigDecimal) rs.getValueAt(row, "CLIE_OID_CLIE")).toString()));
                  registro.setOidSolicitud((rs.getValueAt(row, "OID_SOLI_CABE") == null) ? null
                                                                                         : new Long(((BigDecimal) rs.getValueAt(row, "OID_SOLI_CABE")).toString()));
                  registro.setZona((rs.getValueAt(row, "ZZON_OID_ZONA") == null) ? null
                                                                                 : new Long(((BigDecimal) rs.getValueAt(row, "ZZON_OID_ZONA")).toString()));
                  registro.setOidPeriodo((rs.getValueAt(row, "PERD_OID_PERI") == null) ? null
                                                                                       : new Long(((BigDecimal) rs.getValueAt(row, "PERD_OID_PERI")).toString()));
                  registro.setOidPais((rs.getValueAt(row, "PAIS_OID_PAIS") == null) ? null
                                                                                    : new Long(((BigDecimal) rs.getValueAt(row, "PAIS_OID_PAIS")).toString()));
                  registro.setOidMarca((rs.getValueAt(row, "MARC_OID_MARC") == null) ? null
                                                                                     : new Long(((BigDecimal) rs.getValueAt(row, "MARC_OID_MARC")).toString()));
                  registro.setOidCanal((rs.getValueAt(row, "CANA_OID_CANA") == null) ? null
                                                                                     : new Long(((BigDecimal) rs.getValueAt(row, "CANA_OID_CANA")).toString()));
                                                                                     
                  registro.setIndOrdenCompra((rs.getValueAt(row, "IND_OC")).toString().equals("1")?Boolean.TRUE: Boolean.FALSE);
                  
                  registro.setOidAcceso(new Long(((BigDecimal) rs.getValueAt(row, "ACCE_OID_ACCE")).toString()));
                  
                  UtilidadesLog.debug("registro.getOidSolicitud: " + registro.getOidSolicitud());
  
                  monInc.concursarSolicitudRanking(registro, oidConcurso);
              }
          }
          
      } catch (NamingException ne) {
          UtilidadesLog.error("ERROR ", ne);
          throw new MareException(ne, UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
      } catch (RemoteException fe) {
          UtilidadesLog.error("ERROR ", fe);
          throw new MareException(fe, UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
      } catch (CreateException fe) {
          UtilidadesLog.error("ERROR ", fe);
          throw new MareException(fe, UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
      }                                                                   
      
      UtilidadesLog.info("MONMantenimientoRanking.preProcesoSolicitudesVariableVentaRanking(Long oidConcurso):Salida");
  }
  
  /**
    * Sistema:     Belcorp
    * Modulo:      INC
    * Fecha:       17/11/2006
    * @version     1.0
    * @autor       Viviana Bongiovanni
    */ 
  public Boolean evaluacionVariableRankingVentas(Long oidConcurso) throws MareException {
      UtilidadesLog.info("MONMantenimientoRanking.evaluacionVariableRankingVentas(Long oidConcurso):Entrada");
      
      DAOVariablesVentaRanking dao = new DAOVariablesVentaRanking();
      HashMap variablesConcurso = dao.recuperarVariablesVentaRankingConcurso(oidConcurso);
      
      boolean evaluada = variablesConcurso.containsKey(ConstantesRanking.VAR_VTA_RANK_VENTAS);

      UtilidadesLog.debug("evaluacionVariableRankingVentas: " + evaluada);
        
      UtilidadesLog.info("MONMantenimientoRanking.evaluacionVariableRankingVentas(Long oidConcurso):Salida");
      return new Boolean(evaluada);
  }



    private MONRankingHome getMONRankingHome() throws NamingException {
        final InitialContext context = new InitialContext();

        return (MONRankingHome) PortableRemoteObject.narrow(context.lookup("java:comp/env/MONRanking"), MONRankingHome.class);
    }


    private MONGestionMensajesHome getMONGestionMensajesHome()
            throws NamingException {
        final InitialContext context = new InitialContext();

        return (MONGestionMensajesHome) PortableRemoteObject.narrow(context.lookup("java:comp/env/MONGestionMensajes"), MONGestionMensajesHome.class);
    }

    private MONPremiacionHome getMONPremiacionHome() throws NamingException {
        final InitialContext context = new InitialContext();

        return (MONPremiacionHome) PortableRemoteObject.narrow(context.lookup("java:comp/env/MONPremiacion"), MONPremiacionHome.class);
    }


    private MONClientesHome getMONClientesHome() throws NamingException {
    final InitialContext context = new InitialContext();
    return (MONClientesHome)PortableRemoteObject.narrow(context.lookup("java:comp/env/MONClientes"), MONClientesHome.class);
  }


    private MONIncentivosHome getMONIncentivosHome() throws NamingException {
    final InitialContext context = new InitialContext();
    return (MONIncentivosHome)PortableRemoteObject.narrow(context.lookup("java:comp/env/MONIncentivos"), MONIncentivosHome.class);
  }

    private MONGestionMensajesLocalHome getMONGestionMensajesLocalHome() throws NamingException {
        final InitialContext context = new InitialContext();
        return (MONGestionMensajesLocalHome)context.lookup("java:comp/env/ejb/local/MONGestionMensajes");
    }
    
    private PeriodoLocalHome getPeriodoLocalHome(){
        return new PeriodoLocalHome();
    }
    
    private ClienteDatosBasicosLocalHome getClienteDatosBasicosLocalHome() {
    return new ClienteDatosBasicosLocalHome();
  }
  
    private ClienteDatosAdicionalesLocalHome getClienteDatosAdicionalesLocalHome(){
            return new ClienteDatosAdicionalesLocalHome();
    }
    
    private Entidadi18nLocalHome getEntidadi18nLocalHome() {
        return new Entidadi18nLocalHome();
    }
    
    private ParametrosRankingLocalHome getParametrosRankingLocalHome() {
            return new ParametrosRankingLocalHome();
    }

    private ParametrosGeneralesPremiacionLocalHome getParametrosGeneralesPremiacionLocalHome() {
            return new ParametrosGeneralesPremiacionLocalHome();
    }

    private ConcursoParametrosGeneralesLocalHome getConcursoParametrosGeneralesLocalHome() {
            return new ConcursoParametrosGeneralesLocalHome();
    }

    private ParametrosNivelPremiacionLocalHome getParametrosNivelPremiacionLocalHome() {
            return new ParametrosNivelPremiacionLocalHome();
    }

    private PremioMonetarioLocalHome getPremioMonetarioLocalHome() {
            return new PremioMonetarioLocalHome();
    }

    private PremioArticuloLocalHome getPremioArticuloLocalHome() {
            return new PremioArticuloLocalHome();
    }

    private PremioPuntosLocalHome getPremioPuntosLocalHome() {
            return new PremioPuntosLocalHome();
    }

    private PremioDescuentoLocalHome getPremioDescuentoLocalHome() {
            return new PremioDescuentoLocalHome();
    }


    private GanadorasLocalHome getGanadorasLocalHome() {
            return new GanadorasLocalHome();
    }

    private MensajesLocalHome getMensajesLocalHome() {
            return new MensajesLocalHome();
    }
    

}
