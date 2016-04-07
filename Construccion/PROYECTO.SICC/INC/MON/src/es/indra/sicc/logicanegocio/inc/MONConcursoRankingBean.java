/**
 * Copyright 2004 © por Indra Sistemas,S.A.. Todos los derechos reservados.
 * Avda. de Bruselas, 35
 * Parque Empresarial Arroyo de la Vega
 * 28108 Alcobendas, MadridDAOConcursoRanking
 * España
 *
 * Privado y Confidencial.
 * La información contenida en este documento es propiedad de Indra sistemas.
 * Para uso exclusivo de empleados autorizados no permitiéndose
 * la distribución de este código sin permiso expreso.
 *
 */
package es.indra.sicc.logicanegocio.inc;

import es.indra.mare.common.exception.MareException;
import es.indra.mare.common.mii.services.jdbcservice.RecordSet;

import es.indra.sicc.dtos.inc.DTOBuscarConcursos;
import es.indra.sicc.dtos.inc.DTOClasificacionParticipantes;
import es.indra.sicc.dtos.inc.DTOConcurso;
import es.indra.sicc.dtos.inc.DTODatosGeneralesConcursoRanking;
import es.indra.sicc.dtos.inc.DTOListaAmbitosGeograficos;
import es.indra.sicc.dtos.inc.DTOListaEstatusVenta;
import es.indra.sicc.dtos.inc.DTOListaVariablesVentaRanking;
import es.indra.sicc.dtos.inc.DTONivelesPremiacion;
import es.indra.sicc.dtos.inc.DTOParametrosConsultorasRanking;
import es.indra.sicc.dtos.inc.DTOParametrosGeneralesConcurso;
import es.indra.sicc.dtos.inc.DTOParametrosGeneralesPremiacion;
import es.indra.sicc.dtos.inc.DTOParametrosGerentes;
import es.indra.sicc.dtos.inc.DTOProducto;
import es.indra.sicc.dtos.inc.DTOTipoProducto;
import es.indra.sicc.dtos.inc.DTOVariablesVentaRankingConcurso;
import es.indra.sicc.entidades.cra.PeriodoLocal;
import es.indra.sicc.entidades.cra.PeriodoLocalHome;
import es.indra.sicc.entidades.inc.AmbitoGeograficoLocal;
import es.indra.sicc.entidades.inc.AmbitoGeograficoLocalHome;
import es.indra.sicc.entidades.inc.ClasificacionParticipantesConcursoLocal;
import es.indra.sicc.entidades.inc.ClasificacionParticipantesConcursoLocalHome;
import es.indra.sicc.entidades.inc.ConcursoParametrosConsultorasLocal;
import es.indra.sicc.entidades.inc.ConcursoParametrosConsultorasLocalHome;
import es.indra.sicc.entidades.inc.ConcursoParametrosGeneralesLocal;
import es.indra.sicc.entidades.inc.ConcursoParametrosGeneralesLocalHome;
import es.indra.sicc.entidades.inc.ConcursoParametrosGerentesLocal;
import es.indra.sicc.entidades.inc.ConcursoParametrosGerentesLocalHome;
import es.indra.sicc.entidades.inc.EstatusVentaConsultoraLocal;
import es.indra.sicc.entidades.inc.EstatusVentaConsultoraLocalHome;
import es.indra.sicc.entidades.inc.ParametrosGeneralesPremiacionLocal;
import es.indra.sicc.entidades.inc.ParametrosGeneralesPremiacionLocalHome;
import es.indra.sicc.entidades.inc.ParametrosNivelPremiacionLocal;
import es.indra.sicc.entidades.inc.ParametrosNivelPremiacionLocalHome;
import es.indra.sicc.entidades.inc.ParametrosRankingLocal;
import es.indra.sicc.entidades.inc.ParametrosRankingLocalHome;
import es.indra.sicc.entidades.inc.ProductosExcluidosLocal;
import es.indra.sicc.entidades.inc.ProductosExcluidosLocalHome;
import es.indra.sicc.entidades.inc.ProductosLocal;
import es.indra.sicc.entidades.inc.ProductosLocalHome;
import es.indra.sicc.entidades.inc.ProductosValidosLocal;
import es.indra.sicc.entidades.inc.ProductosValidosLocalHome;
import es.indra.sicc.entidades.inc.VariablesVentaRankingConcursoLocal;
import es.indra.sicc.entidades.inc.VariablesVentaRankingConcursoLocalHome;
import es.indra.sicc.entidades.msg.MensajesLocal;
import es.indra.sicc.entidades.msg.MensajesLocalHome;
import es.indra.sicc.logicanegocio.seg.ConstantesSEG;
import es.indra.sicc.util.CodigosError;
import es.indra.sicc.util.DTOBelcorp;
import es.indra.sicc.util.DTOOID;
import es.indra.sicc.util.DTOSalida;
import es.indra.sicc.util.UtilidadesError;
import es.indra.sicc.util.UtilidadesLog;

import java.math.BigDecimal;

import java.rmi.RemoteException;

import java.util.Collection;
import java.util.Iterator;

import javax.ejb.CreateException;
import javax.ejb.SessionBean;
import javax.ejb.SessionContext;

import javax.naming.InitialContext;
import javax.naming.NamingException;

import javax.rmi.PortableRemoteObject;

import javax.persistence.NoResultException;
import javax.persistence.PersistenceException;

public class MONConcursoRankingBean
        implements SessionBean {
    private SessionContext ctx;
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

    /**
     *
     * @throws es.indra.mare.common.exception.MareException
     * @return
     * @param DTOE
     * @author Marcelo J. Maidana -- 17/06/2005
     */
    public DTOSalida obtenerNivelAgrupamiento(DTOBelcorp DTOE)
            throws MareException {
        UtilidadesLog.info("MONConcursoRankingBean.obtenerNivelAgrupamiento(DTOBelcorp DTOE):Entrada");
        DAOConcursoRanking dao = new DAOConcursoRanking();
        RecordSet nivelAgrupamiento = dao.obtenerNivelAgrupamiento(DTOE);
        DTOSalida dtos = new DTOSalida();
        dtos.setResultado(nivelAgrupamiento);
        UtilidadesLog.info("MONConcursoRankingBean.obtenerNivelAgrupamiento(DTOBelcorp DTOE):Salida");

        return dtos;
    }

    /**
     *
     * @throws es.indra.mare.common.exception.MareException
     * @return
     * @param DTOE
     * @author Marcelo J. Maidana -- 17/06/2005
     */
    public DTOSalida obtenerTipoRanking(DTOBelcorp DTOE)
            throws MareException {
        UtilidadesLog.info("MONConcursoRankingBean.obtenerTipoRanking(DTOBelcorp DTOE):Entrada");
        DAOConcursoRanking dao = new DAOConcursoRanking();
        RecordSet tipoRanking = dao.obtenerTipoRanking(DTOE);
        DTOSalida dtos = new DTOSalida();
        dtos.setResultado(tipoRanking);
        UtilidadesLog.info("MONConcursoRankingBean.obtenerTipoRanking(DTOBelcorp DTOE):Salida");

        return dtos;
    }

    /**
     *
     * @throws es.indra.mare.common.exception.MareException
     * @return
     * @param DTOE
     * @author Sergio C. Saavedra -- 21/06/2005
     */
    public void guardarDatosConcursoRanking(DTOConcurso DTOE)
            throws MareException {
        UtilidadesLog.info("MONConcursoRankingBean.guardarDatosConcursoRanking(DTOConcurso DTOE):Entrada");
        UtilidadesLog.debug("dentro de MONConcursoRanking==>>guardarDatosConcursoRanking(.." + DTOE);

        try {
            MONConcursoHome monConcurso = this.getMONConcursoHome();
            Long oidConcCreado = monConcurso.create().guardarParametrosGeneralesConcurso(DTOE.getParamGenerales());

            DTOE.getParamGenerales().setOid(oidConcCreado);

            this.guardarDatosGeneralesConcursoRanking(DTOE.getParamGenerales());

            // Borra AmbitosGeograficos
            if (DTOE.getIndBorradoAmbitosGeograficos().booleanValue()) {
                this.borrarAmbitosGeograficos(oidConcCreado);
            }

            // Guarda AmbitosGeograficos
            if (DTOE.getIndObligAmbitosGeograficos().booleanValue()) {
                monConcurso.create().guardarAmbitosGeograficos(DTOE.getListaAmbitosGeograficos(), oidConcCreado);
            }

            // Borra Variables Venta Ranking
            if (DTOE.getIndBorradoVariablesVentaRanking().booleanValue()) {
                this.borrarVariablesVentaRankingConcurso(oidConcCreado);
            }

            // Guarda Variables Venta Ranking
            if (DTOE.getIndObligVariablesVentaRanking().booleanValue()) {
                this.guardarVariablesVentaRankingConcurso(DTOE.getVariablesVentaRanking(), oidConcCreado);
            }

            // Borra Gerentes
            if (DTOE.getIndBorradoGerentes().booleanValue()) {
                this.borrarParametrosGerentes(oidConcCreado);
            }

            // Borra Consultoras
            if (DTOE.getIndBorradoConsultorasRanking().booleanValue()) {
                this.borrarParametrosConsultorasRanking(oidConcCreado);
            }

            // Guarda Gerentes
            if (DTOE.getIndObligGerentes().booleanValue()) {
                monConcurso.create().guardarParametrosGerentes(DTOE.getParamGerentes(), oidConcCreado);
            }

            // Guarda Consultoras
            if (DTOE.getIndObligConsultoras().booleanValue()) {
                this.guardarParametrosConsultorasRanking(DTOE.getParamConsultorasRanking(), oidConcCreado);
            }

            // Borra ClasificacionParticipantes
            if (DTOE.getIndBorradoClasificacionParticipantes().booleanValue()) {
                this.borrarClasificacionParticipantes(oidConcCreado);
            }

            // Guarda ClasificacionParticipantes
            if (DTOE.getIndClasificacionParticipantes().booleanValue()) {
                monConcurso.create().guardarClasificacionParticipantes(DTOE.getClasificParticipantes(), oidConcCreado);
            }

            // Borra EstatusVenta
            if (DTOE.getIndBorradoEstatusVenta().booleanValue()) {
                this.borrarEstatusVenta(oidConcCreado);
            }

            // Guarda EstatusVenta
            if (DTOE.getIndEstatusVenta().booleanValue()) {
                //Cleal - INC 06
                //monConcurso.create().guardarEstatusVenta(DTOE, oidConcCreado);
                DTOE.setEstatusVentaConsultoras(DTOE.getEstatusVenta());
                monConcurso.create().guardarEstatusVentaConsultoras(DTOE, oidConcCreado);
            }

            // Borra productos validos
            if (DTOE.getIndBorradoProductosValidos().booleanValue()) {
                this.borrarProductosValidos(oidConcCreado);
            }

            // Borra productos excluidos
            if (DTOE.getIndBorradoProductosExcluidos().booleanValue()) {
                this.borrarProductosExcluidos(oidConcCreado);
            }

            // Guarda Productos
            this.guardarProductosRanking(DTOE, oidConcCreado);

            // Borra Premios
            if (DTOE.getIndBorradoPremios().booleanValue()) {
                this.borrarPremiosRanking(oidConcCreado);
            }

            // Guarda Premios
            if (DTOE.getIndObligPremios().booleanValue()) {
                UtilidadesLog.debug("guardarParametrosPremiacion, con: " + DTOE.getParamGralesPremiacion());
                this.guardarPremiosRanking(DTOE.getParamGralesPremiacion(), oidConcCreado);

                if (DTOE.getIndNivelPremiacion().booleanValue()) {
                    DTOE.getListaNivelesPremiacion().setOidPais(DTOE.getOidPais());
                    UtilidadesLog.debug("guardarNivelesPremiacion, con: " + DTOE.getListaNivelesPremiacion());
                    monConcurso.create().guardarNivelesPremiacion(DTOE.getListaNivelesPremiacion(), oidConcCreado);
                }
            }

            UtilidadesLog.info("MONConcursoRankingBean.guardarDatosConcursoRanking(DTOConcurso DTOE):Salida");
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
    }

    private MONConcursoHome getMONConcursoHome() throws NamingException {
        final InitialContext context = new InitialContext();

        return (MONConcursoHome) PortableRemoteObject.narrow(context.lookup("java:comp/env/MONConcurso"), MONConcursoHome.class);
    }

    /**
      *
      * @throws es.indra.mare.common.exception.MareException
      * @return
      * @param DTOE
      * @author Sergio C. Saavedra -- 21/06/2005
      */
    public void guardarDatosGeneralesConcursoRanking(DTOParametrosGeneralesConcurso DTOE)
            throws MareException {
        UtilidadesLog.info("MONConcursoRankingBean.guardarDatosGeneralesConcursoRanking(DTOParametrosGeneralesConcurso DTOE):Entrada");
        ConcursoParametrosGeneralesLocal concursoParametrosGeneralesL = null;
        ParametrosRankingLocal parametrosRankingL = null;
        ParametrosRankingLocal parametrosRankingL1 = null;

        UtilidadesLog.debug("dentro de MONConcursoRanking==>>guardarDatosGeneralesConcursoRanking(.." + DTOE);

        try {
            ConcursoParametrosGeneralesLocalHome concursoParametrosGeneralesLH = this.getConcursoParametrosGeneralesLocalHome();
            concursoParametrosGeneralesL = concursoParametrosGeneralesLH.findByPrimaryKey(DTOE.getOid());

            //Modificar tipo exigencia
            concursoParametrosGeneralesL.setTipoExigencia(DTOE.getDatosGeneralesRanking().getOidTipoExigencia());
            concursoParametrosGeneralesL.setRanking(new Boolean(true));
            
            concursoParametrosGeneralesLH.merge(concursoParametrosGeneralesL);

            //Se guarda el registro en ParametrosRanking 
            if (DTOE.getDatosGeneralesRanking().getOid() != null) //modificacion 
             {
                ParametrosRankingLocalHome parametrosRankingLH = this.getParametrosRankingLocalHome();
                parametrosRankingL = parametrosRankingLH.findByPrimaryKey(DTOE.getDatosGeneralesRanking().getOid());

                parametrosRankingL.setCopaOidParaGral(DTOE.getOid());

                PeriodoLocalHome periodoLocal = this.getPeriodoLocalHome();

                PeriodoLocal periodoH = periodoLocal.findByPrimaryKey(DTOE.getOidPeriodoHasta());
                PeriodoLocal periodoC = periodoLocal.findByPrimaryKey(DTOE.getDatosGeneralesRanking().getOidPeriodoCalificacion());
                PeriodoLocal periodoP = periodoLocal.findByPrimaryKey(DTOE.getDatosGeneralesRanking().getOidPeriodoPremiacion());

                if ((periodoH.getFechainicio().getTime() <= periodoC.getFechainicio().getTime()) &&
                        (periodoH.getFechaFin().getTime() <= periodoC.getFechaFin().getTime())) {
                    parametrosRankingL.setPerdOidPeri(DTOE.getDatosGeneralesRanking().getOidPeriodoCalificacion());
                } else {
                    throw new MareException(null, null, UtilidadesError.armarCodigoError(ConstantesSEG.MODULO_INC + ErroresDeNegocio.INC_0301));
                }

                if ((periodoC.getFechainicio().getTime() <= periodoP.getFechainicio().getTime()) &&
                        (periodoC.getFechaFin().getTime() <= periodoP.getFechaFin().getTime())) {
                    parametrosRankingL.setPerdOidPeriPrem(DTOE.getDatosGeneralesRanking().getOidPeriodoPremiacion());
                } else {
                    throw new MareException(null, null, UtilidadesError.armarCodigoError(ConstantesSEG.MODULO_INC + ErroresDeNegocio.INC_0302));
                }

                parametrosRankingL.setTprkOidTipoRank(DTOE.getDatosGeneralesRanking().getOidTipoRanking());
                parametrosRankingL.setAgraOidAgruRank(DTOE.getDatosGeneralesRanking().getOidNivelAgrupamiento());
                parametrosRankingLH.merge(parametrosRankingL);
            } else { //inserción... 

                ParametrosRankingLocalHome parametrosRankingLH = this.getParametrosRankingLocalHome();

                PeriodoLocalHome periodoLocal = this.getPeriodoLocalHome();

                PeriodoLocal periodoH = periodoLocal.findByPrimaryKey(DTOE.getOidPeriodoHasta());
                PeriodoLocal periodoC = periodoLocal.findByPrimaryKey(DTOE.getDatosGeneralesRanking().getOidPeriodoCalificacion());
                PeriodoLocal periodoP = periodoLocal.findByPrimaryKey(DTOE.getDatosGeneralesRanking().getOidPeriodoPremiacion());

                if (!((periodoH.getFechainicio().getTime() <= periodoC.getFechainicio().getTime()) &&
                        (periodoH.getFechaFin().getTime() <= periodoC.getFechaFin().getTime()))) {
                    throw new MareException(null, null, UtilidadesError.armarCodigoError(ConstantesSEG.MODULO_INC + ErroresDeNegocio.INC_0301));
                }

                if (!((periodoC.getFechainicio().getTime() <= periodoP.getFechainicio().getTime()) &&
                        (periodoC.getFechaFin().getTime() <= periodoP.getFechaFin().getTime()))) {
                    throw new MareException(null, null, UtilidadesError.armarCodigoError(ConstantesSEG.MODULO_INC + ErroresDeNegocio.INC_0302));
                }

                parametrosRankingL1 = parametrosRankingLH.create(DTOE.getOid(), DTOE.getDatosGeneralesRanking().getOidPeriodoCalificacion(),
                                                                 DTOE.getDatosGeneralesRanking().getOidPeriodoPremiacion(),
                                                                 DTOE.getDatosGeneralesRanking().getOidTipoRanking(),
                                                                 DTOE.getDatosGeneralesRanking().getOidNivelAgrupamiento());
            }

            UtilidadesLog.debug("termino de MONConcursoRanking==>>guardarDatosGeneralesConcursoRanking(..");
        } catch (NoResultException fe) {
            UtilidadesLog.error("ERROR ", fe);
            throw new MareException(fe, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE));
        } catch (PersistenceException ce) {
            UtilidadesLog.error("ERROR ", ce);
            throw new MareException(ce, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS));
        }
        UtilidadesLog.info("MONConcursoRankingBean.guardarDatosGeneralesConcursoRanking(DTOParametrosGeneralesConcurso DTOE):Salida");
    }


    /**
     *
     * @throws es.indra.mare.common.exception.MareException
     * @return
     * @param DTOE
     * @author Sergio C. Saavedra -- 21/06/2005
     */
    public void guardarVariablesVentaRankingConcurso(DTOListaVariablesVentaRanking DTOE, Long oidConcurso)
            throws MareException {
        UtilidadesLog.info("MONConcursoRankingBean.guardarVariablesVentaRankingConcurso(DTOListaVariablesVentaRanking DTOE, Long oidConcurso):Entrada");
        //Eliminar los registros de VentasRankingConsultoras
        VariablesVentaRankingConcursoLocal variablesVentaRankingConcursoL = null;
        UtilidadesLog.debug("dentro de MONConcursoRanking==>>guardarVariablesVentaRankingConcurso(.." + DTOE);

        try {
            VariablesVentaRankingConcursoLocalHome variablesVentaRankingConcursoLH = this.getVariablesVentaRankingConcursoLocalHome();
            Collection vvrcCol = variablesVentaRankingConcursoLH.findByConcurso(oidConcurso);

            //Eliminar los registros de VentasRankingConcurso
            if (vvrcCol != null) {
                for (Iterator itVariables = vvrcCol.iterator(); itVariables.hasNext();) {
                    VariablesVentaRankingConcursoLocal registro = (VariablesVentaRankingConcursoLocal) itVariables.next();
                    variablesVentaRankingConcursoLH.remove(registro);
                }
            }

            //Guardar las variablesVentaRanking 
            if ((DTOE.getListaVariables() != null) && (DTOE.getListaVariables().size() > 0)) {
                for (int j = 0; j < DTOE.getListaVariables().size(); j++) {
                    DTOVariablesVentaRankingConcurso registro = (DTOVariablesVentaRankingConcurso) DTOE.getListaVariables().get(j);
                    variablesVentaRankingConcursoL = variablesVentaRankingConcursoLH.create(new Long(registro.getPeso().longValue()),
                                                                                            new Long(registro.getDivisor().longValue()), oidConcurso,
                                                                                            registro.getOidVariableVenta(), registro.getAplicable());

                    variablesVentaRankingConcursoL.setNumDiasCobr((registro.getNumeroDiasCobro() == null) ? null
                                                                                                          : new Long(registro.getNumeroDiasCobro()
                                                                                                                             .longValue()));
                    variablesVentaRankingConcursoLH.merge(variablesVentaRankingConcursoL);
                }
            }

            UtilidadesLog.debug("termino de MONConcursoRanking==>>guardarVariablesVentaRankingConcurso(..");
        } catch (NoResultException fe) {
            UtilidadesLog.error("ERROR ", fe);
            throw new MareException(fe, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE));
        } catch (PersistenceException fe) {
            UtilidadesLog.error("ERROR ", fe);
            throw new MareException(fe, UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
        }
        UtilidadesLog.info("MONConcursoRankingBean.guardarVariablesVentaRankingConcurso(DTOListaVariablesVentaRanking DTOE, Long oidConcurso):Salida");
    }


    /**
     *
     * @throws es.indra.mare.common.exception.MareException
     * @return
     * @param DTOE
     * @author Sergio C. Saavedra -- 21/06/2005
     */
    public void guardarParametrosConsultorasRanking(DTOParametrosConsultorasRanking DTOE, Long oidConcurso)
            throws MareException {
        UtilidadesLog.info("MONConcursoRankingBean.guardarParametrosConsultorasRanking(DTOParametrosConsultorasRanking DTOE, Long oidConcurso):Entrada");
        // La base de calculo se guardan en la entidad ConcursoParametrosGenerales 
        ConcursoParametrosGeneralesLocal concursoParametrosGeneralesL = null;
        ConcursoParametrosConsultorasLocal concursoParametrosConsultorasL = null;

        UtilidadesLog.debug("dentro de MONConcursoRanking==>>guardarParametrosConsultorasRanking(.." + DTOE);

        try {
            ConcursoParametrosGeneralesLocalHome concursoParametrosGeneralesLH = this.getConcursoParametrosGeneralesLocalHome();
            ConcursoParametrosConsultorasLocalHome concursoParametrosConsultorasLH = this.getConcursoParametrosConsultorasLocalHome();

            concursoParametrosGeneralesL = concursoParametrosGeneralesLH.findByPrimaryKey(oidConcurso);

            concursoParametrosGeneralesL.setBaseCalculo(DTOE.getOidBaseCalculo());
            
            concursoParametrosGeneralesLH.merge(concursoParametrosGeneralesL);

            //Se guarda el registro en ConcursoParametrosConsultoras
            if (DTOE.getOidParametrosConsultoras() != null) //modificacion 
             {
                concursoParametrosConsultorasL = concursoParametrosConsultorasLH.findByPrimaryKey(DTOE.getOidParametrosConsultoras());

                concursoParametrosConsultorasL.setTipoVenta(DTOE.getOidTipoVenta());
                concursoParametrosConsultorasL.setConcurso(oidConcurso);

                PeriodoLocalHome periodoLocal = this.getPeriodoLocalHome();
                PeriodoLocal periodoLDesde = null;

                if (DTOE.getOidPeriodoDesde() != null) {
                    periodoLDesde = periodoLocal.findByPrimaryKey(DTOE.getOidPeriodoDesde());
                }

                if ((DTOE.getOidPeriodoDesde() != null) && (DTOE.getOidPeriodoHasta() != null)) {
                    PeriodoLocal periodoLHasta = periodoLocal.findByPrimaryKey(DTOE.getOidPeriodoHasta());

                    if (!((periodoLDesde.getFechainicio().getTime() <= periodoLHasta.getFechainicio().getTime()) &&
                            (periodoLDesde.getFechaFin().getTime() <= periodoLHasta.getFechaFin().getTime()))) {
                        throw new MareException(null, null, UtilidadesError.armarCodigoError(ConstantesSEG.MODULO_INC + ErroresDeNegocio.INC_0332));
                    }
                }

                concursoParametrosConsultorasL.setPeriodoDesde(DTOE.getOidPeriodoDesde());
                concursoParametrosConsultorasL.setPeriodoHasta(DTOE.getOidPeriodoHasta());
                concursoParametrosConsultorasLH.merge(concursoParametrosConsultorasL);
            } else { //inserción 
                concursoParametrosConsultorasL = concursoParametrosConsultorasLH.create(oidConcurso);

                concursoParametrosConsultorasL.setTipoVenta(DTOE.getOidTipoVenta());
                concursoParametrosConsultorasL.setConcurso(oidConcurso);

                PeriodoLocalHome periodoLocal = this.getPeriodoLocalHome();
                PeriodoLocal periodoLDesde = null;

                if (DTOE.getOidPeriodoDesde() != null) {
                    periodoLDesde = periodoLocal.findByPrimaryKey(DTOE.getOidPeriodoDesde());
                }

                if ((DTOE.getOidPeriodoDesde() != null) && (DTOE.getOidPeriodoHasta() != null)) {
                    PeriodoLocal periodoLHasta = periodoLocal.findByPrimaryKey(DTOE.getOidPeriodoHasta());

                    if (!((periodoLDesde.getFechainicio().getTime() <= periodoLHasta.getFechainicio().getTime()) &&
                            (periodoLDesde.getFechaFin().getTime() <= periodoLHasta.getFechaFin().getTime()))) {
                        throw new MareException(null, null, UtilidadesError.armarCodigoError(ConstantesSEG.MODULO_INC + ErroresDeNegocio.INC_0332));
                    }
                }

                concursoParametrosConsultorasL.setPeriodoDesde(DTOE.getOidPeriodoDesde());
                concursoParametrosConsultorasL.setPeriodoHasta(DTOE.getOidPeriodoHasta());
                concursoParametrosConsultorasLH.merge(concursoParametrosConsultorasL);
            }

            UtilidadesLog.info("MONConcursoRankingBean.guardarParametrosConsultorasRanking(DTOParametrosConsultorasRanking DTOE, Long oidConcurso):Salida");
        } catch (NoResultException fe) {
            UtilidadesLog.error("ERROR ", fe);
            throw new MareException(fe, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE));
        } catch (PersistenceException fe) {
            UtilidadesLog.error("ERROR ", fe);
            throw new MareException(fe, UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
        }
    }


    /**
     *
     * @throws es.indra.mare.common.exception.MareException
     * @return
     * @param DTOE
     * @author Sergio C. Saavedra -- 21/06/2005
     */
    public void guardarProductosRanking(DTOConcurso DTOE, Long oidConcurso)
            throws MareException {
        UtilidadesLog.info("MONConcursoRankingBean.guardarProductosRanking(DTOConcurso DTOE, Long oidConcurso):Entrada");
        UtilidadesLog.debug("dentro de MONConcursoRanking==>>guardarProductosRanking(.." + DTOE);

        try {
            if (DTOE.getIndObligProductosValidos().booleanValue()) {
                UtilidadesLog.debug("IndObligProductosValidos");

                if (DTOE.getProductosValidos().getCodigoMensaje() != null) {
                    try {
                        MensajesLocalHome msgLH = this.getMensajesLocalHome();
                        msgLH.findByUk(DTOE.getOidPais(), DTOE.getProductosValidos().getCodigoMensaje());
                    } catch (NoResultException fe) {
                        UtilidadesLog.error("ERROR ", fe);
                        throw new MareException(null, null, UtilidadesError.armarCodigoError(ConstantesSEG.MODULO_INC, "", ErroresDeNegocio.INC_0008));
                    }  catch (PersistenceException ce) {
                         UtilidadesLog.error("ERROR ", ce);
                         throw new MareException(ce, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS));
                    }
                }

                ProductosLocalHome productosLH = this.getProductosLocalHome();

                try {
                    ProductosLocal productosL = productosLH.findByUK(oidConcurso);
                    productosL.setComunicacionValidos(DTOE.getProductosValidos().getIndComunicacion());
                    productosL.setMensajeValidos(DTOE.getProductosValidos().getCodigoMensaje());
                    productosLH.merge(productosL);
                } catch (NoResultException fe) {
                    UtilidadesLog.debug(fe);
                    //no existe el prod., create!!
                    ProductosLocal productosL = productosLH.create(oidConcurso);
                    productosL.setComunicacionValidos(DTOE.getProductosValidos().getIndComunicacion());
                    productosL.setMensajeValidos(DTOE.getProductosValidos().getCodigoMensaje());
                    productosLH.merge(productosL);
                } catch (PersistenceException ce) {
                    UtilidadesLog.error("ERROR ", ce);
                    throw new MareException(ce, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS));
                }

                MONConcursoHome monConcurso = this.getMONConcursoHome();
                monConcurso.create().guardarProductosValidos(DTOE.getProductosValidos(), oidConcurso);
            }

            if (DTOE.getIndObligProductosExcluidos().booleanValue()) {
                UtilidadesLog.debug("IndObligProductosExcluidos");

                if (DTOE.getProductosExcluidos().getCodigoMensaje() != null) {
                    try {
                        MensajesLocalHome msgLH = this.getMensajesLocalHome();
                        msgLH.findByUk(DTOE.getOidPais(), DTOE.getProductosExcluidos().getCodigoMensaje());
                    } catch (NoResultException fe) {
                        UtilidadesLog.error("ERROR ", fe);
                        throw new MareException(null, null, UtilidadesError.armarCodigoError(ConstantesSEG.MODULO_INC, "", ErroresDeNegocio.INC_0309));
                    }  catch (PersistenceException ce) {
                         UtilidadesLog.error("ERROR ", ce);
                         throw new MareException(ce, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS));
                    }
                }

                ProductosLocalHome productosLH = this.getProductosLocalHome();

                try {
                    ProductosLocal productosL = productosLH.findByUK(oidConcurso);
                    productosL.setComunicacionExcluidos(DTOE.getProductosExcluidos().getIndComunicacion());
                    productosL.setMensajeExcluidos(DTOE.getProductosExcluidos().getCodigoMensaje());
                    productosLH.merge(productosL);
                } catch (NoResultException fe) {
                    UtilidadesLog.debug(fe);
                    //no existe el prod., create!!
                    ProductosLocal productosL = productosLH.create(oidConcurso);
                    productosL.setComunicacionExcluidos(DTOE.getProductosExcluidos().getIndComunicacion());
                    productosL.setMensajeExcluidos(DTOE.getProductosExcluidos().getCodigoMensaje());
                    productosLH.merge(productosL);
                } catch (PersistenceException ce) {
                    UtilidadesLog.error("ERROR ", ce);
                    throw new MareException(ce, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS));
                }

                MONConcursoHome monConcurso = this.getMONConcursoHome();
                monConcurso.create().guardarProductosExcluidos(DTOE.getProductosExcluidos(), oidConcurso);
            }

            UtilidadesLog.debug("termino de MONConcursoRanking==>>guardarProductosRanking(..");
        } catch (RemoteException fe) {
            UtilidadesLog.error("ERROR ", fe);
            throw new MareException(fe, UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
        } catch (NamingException ne) {
            UtilidadesLog.error("ERROR ", ne);
            throw new MareException(ne, UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
        } catch (CreateException fe) {
            UtilidadesLog.error("ERROR ", fe);
            throw new MareException(fe, UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
        }
        UtilidadesLog.info("MONConcursoRankingBean.guardarProductosRanking(DTOConcurso DTOE, Long oidConcurso):Salida");
    }


    /**
     *
     * @throws es.indra.mare.common.exception.MareException
     * @return
     * @param DTOE
     * @author Sergio C. Saavedra -- 21/06/2005
     */
    public void guardarPremiosRanking(DTOParametrosGeneralesPremiacion DTOE, Long oidConcurso)
            throws MareException {
        UtilidadesLog.info("MONConcursoRankingBean.guardarPremiosRanking(DTOParametrosGeneralesPremiacion DTOE, Long oidConcurso):Entrada");
        try {
            //Se guarda el registro en ParametrosGeneralesPremiacion 
            UtilidadesLog.debug("dentro de MONConcursoRanking==>>guardarPremiosRanking(.." + DTOE);

            if (DTOE.getOidParamGralesPremiacion() != null) {
                ParametrosGeneralesPremiacionLocalHome parametrosGeneralesPremiacionLH = this.getParametrosGeneralesPremiacionLocalHome();

                ParametrosGeneralesPremiacionLocal parametrosGeneralesPremiacionL = parametrosGeneralesPremiacionLH.findByPrimaryKey(DTOE.getOidParamGralesPremiacion());

                parametrosGeneralesPremiacionL.setNumeroNiveles(DTOE.getNroNiveles());
                parametrosGeneralesPremiacionL.setComunicacion(DTOE.getIndComunicacion());
                parametrosGeneralesPremiacionL.setConcurso(oidConcurso);

                if (DTOE.getMensaje() != null) {
                    try {
                        MensajesLocalHome msgLH = this.getMensajesLocalHome();
                        MensajesLocal msgL = msgLH.findByUk(DTOE.getOidPais(), DTOE.getMensaje());
                        parametrosGeneralesPremiacionL.setMensaje(msgL.getOid());
                    } catch (NoResultException fe) {
                        UtilidadesLog.error("ERROR ", fe);
                        throw new MareException(null, null, UtilidadesError.armarCodigoError(ConstantesSEG.MODULO_INC, "", ErroresDeNegocio.INC_0001));
                    }  catch (PersistenceException ce) {
                         UtilidadesLog.error("ERROR ", ce);
                         throw new MareException(ce, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS));
                    }
                }
                parametrosGeneralesPremiacionL.setPeriodoDespacho(DTOE.getOidPeriodo());
                
                parametrosGeneralesPremiacionLH.merge(parametrosGeneralesPremiacionL);
            } else {
                ParametrosGeneralesPremiacionLocalHome parametrosGeneralesPremiacionLH = this.getParametrosGeneralesPremiacionLocalHome();

                ParametrosGeneralesPremiacionLocal parametrosGeneralesPremiacionL = parametrosGeneralesPremiacionLH.create(DTOE.getNroNiveles(),
                                                                                                                           DTOE.getIndComunicacion(),
                                                                                                                           oidConcurso);

                if (DTOE.getMensaje() != null) {
                    try {
                        MensajesLocalHome msgLH = this.getMensajesLocalHome();
                        MensajesLocal msgL = msgLH.findByUk(DTOE.getOidPais(), DTOE.getMensaje());
                        parametrosGeneralesPremiacionL.setMensaje(msgL.getOid());
                    } catch (NoResultException fe) {
                        UtilidadesLog.error("ERROR ", fe);
                        throw new MareException(null, null, UtilidadesError.armarCodigoError(ConstantesSEG.MODULO_INC, "", ErroresDeNegocio.INC_0001));
                    }  catch (PersistenceException ce) {
                         UtilidadesLog.error("ERROR ", ce);
                         throw new MareException(ce, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS));
                    }
                }

                parametrosGeneralesPremiacionL.setPeriodoDespacho(DTOE.getOidPeriodo());
                
                parametrosGeneralesPremiacionL.setPeriodoDespachoExigido(DTOE.getIndPeriodoDespacho());
                parametrosGeneralesPremiacionL.setPremiosAcumulativosNiveles(DTOE.getIndPremiosAcumulativosNiveles());
                parametrosGeneralesPremiacionL.setNivelesRotativos(DTOE.getIndNivelesRotativos());
                parametrosGeneralesPremiacionL.setAccesoNivelSuperior(DTOE.getIndAccesoNivelPremioSuperior());
                parametrosGeneralesPremiacionL.setPremiosElectivos(DTOE.getIndPremiosElectivos());
                parametrosGeneralesPremiacionLH.merge(parametrosGeneralesPremiacionL);
            }
        } catch (PersistenceException fe) {
            UtilidadesLog.error("ERROR ", fe);
            throw new MareException(fe, UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
        }
        UtilidadesLog.info("MONConcursoRankingBean.guardarPremiosRanking(DTOParametrosGeneralesPremiacion DTOE, Long oidConcurso):Salida");
    }


    /**
     *
     * @throws es.indra.mare.common.exception.MareException
     * @return
     * @param DTOE
     * @author Sergio C. Saavedra -- 23/06/2005
     */
    public DTOSalida buscarConcursosRanking(DTOBuscarConcursos DTOE)
            throws MareException {
        
        DAOConcursoRanking daoCR = new DAOConcursoRanking();

        return daoCR.buscarConcursosRanking(DTOE);
    }

    /**
      *
      * @throws es.indra.mare.common.exception.MareException
      * @return
      * @param DTOE
      * @author Sergio C. Saavedra -- 23/06/2005
      */
    public DTOConcurso obtenerDatosConcursoRanking(DTOOID DTOE)
            throws MareException {
        UtilidadesLog.info("MONConcursoRankingBean.obtenerDatosConcursoRanking(DTOOID DTOE):Entrada");
        UtilidadesLog.debug("inicia MONConcursoRanking.obtenerDatosConcursoRanking() DTOE: " + DTOE);

        //contempla inc.: BELC300019355 .......
        try {
            DTOConcurso dtoC = new DTOConcurso();
            MONConcursoHome monConcurso = this.getMONConcursoHome();

            DTOParametrosGeneralesConcurso dtoPGC = monConcurso.create().obtenerParametrosGeneralesConcurso(DTOE);
            UtilidadesLog.debug("DTOParametrosGeneralesConcurso: " + dtoPGC);

            DTODatosGeneralesConcursoRanking dtoDGCR = this.obtenerDatosGeneralesConcursoRanking(DTOE);
            UtilidadesLog.debug("DTODatosGeneralesConcursoRanking: " + dtoDGCR);
            dtoC.setParamGenerales(dtoPGC);
            dtoC.getParamGenerales().setDatosGeneralesRanking(dtoDGCR);

            if ((dtoPGC != null) && (dtoDGCR != null)) {
                dtoC.setIndParamGenerales(new Boolean(true));
                dtoC.setIndObligParamGenerales(new Boolean(true));
            } else {
                dtoC.setIndParamGenerales(new Boolean(false));
                dtoC.setIndObligParamGenerales(new Boolean(false));
            }

            DTOListaAmbitosGeograficos dtoLAG = monConcurso.create().obtenerListaAmbitosGeograficos(DTOE);
            UtilidadesLog.debug("DTOListaAmbitosGeograficos: " + dtoLAG);
            dtoC.setListaAmbitosGeograficos(dtoLAG);

            if (dtoLAG != null) {
                dtoC.setIndAmbitosGeograficos(new Boolean(true));
                dtoC.setIndObligAmbitosGeograficos(new Boolean(true));
            } else {
                dtoC.setIndAmbitosGeograficos(new Boolean(false));
                dtoC.setIndObligAmbitosGeograficos(new Boolean(false));
            }

            DTOListaVariablesVentaRanking dtoLVVR = this.obtenerVariablesVentaRankingConcurso(DTOE);
            UtilidadesLog.debug("DTOListaVariablesVentaRanking: " + dtoLVVR);
            dtoC.setVariablesVentaRanking(dtoLVVR);

            if (dtoLVVR != null) {
                dtoC.setIndVariablesVentaRanking(new Boolean(true));
                dtoC.setIndObligVariablesVentaRanking(new Boolean(true));
            } else {
                dtoC.setIndVariablesVentaRanking(new Boolean(false));
                dtoC.setIndObligVariablesVentaRanking(new Boolean(false));
            }

            DTOParametrosGerentes dtoPG = monConcurso.create().obtenerParametrosGerentes(DTOE);
            UtilidadesLog.debug("DTOParametrosGerentes: " + dtoPG);
            dtoC.setParamGerentes(dtoPG);

            if (dtoPG != null) {
                dtoC.setIndGerentes(new Boolean(true));
                dtoC.setIndObligGerentes(new Boolean(true));
            } else {
                dtoC.setIndGerentes(new Boolean(false));
                dtoC.setIndObligGerentes(new Boolean(false));
            }

            // vbongiov INC-6 
            // DTOListaEstatusVenta dtoLEV = monConcurso.create().obtenerListaEstatusVentaConsultora(DTOE);
            DAOConcurso daoConcurso = new DAOConcurso();
            DTOListaEstatusVenta dtoLEV = daoConcurso.obtenerListaEstatusVenta(DTOE);
            UtilidadesLog.debug("DTOListaEstatusVenta: " + dtoLEV);
            dtoC.setEstatusVenta(dtoLEV);

            if (dtoLEV != null) {
                dtoC.setIndEstatusVenta(new Boolean(true));
            } else {
                dtoC.setIndEstatusVenta(new Boolean(false));
            }

            DTOParametrosConsultorasRanking dtoPCR = this.obtenerParametrosConsultorasRanking(DTOE);
            UtilidadesLog.debug("DTOParametrosConsultorasRanking: " + dtoPCR);
            dtoC.setParamConsultorasRanking(dtoPCR);

            if (dtoPCR != null) {
                dtoC.setIndConsultoras(new Boolean(true));
                dtoC.setIndObligConsultoras(new Boolean(true));
            } else {
                dtoC.setIndConsultoras(new Boolean(false));
                dtoC.setIndObligConsultoras(new Boolean(false));
            }

            DTOClasificacionParticipantes dtoParticipante = new DTOClasificacionParticipantes();

            dtoParticipante.setOidPais(DTOE.getOidPais());
            dtoParticipante.setOidIdioma(DTOE.getOidIdioma());
            dtoParticipante.setOidConcurso(DTOE.getOid());
            dtoParticipante.setOidDirigidoA(dtoC.getParamGenerales().getOidDirigidoA());

            DTOClasificacionParticipantes dtoCP = monConcurso.create().obtenerListasClasificacion(dtoParticipante);
            UtilidadesLog.debug("DTOClasificacionParticipantes: " + dtoCP);
            dtoC.setClasificParticipantes(dtoCP);

            if ((dtoC.getClasificParticipantes() != null) && (dtoC.getClasificParticipantes().getLstClasificacionParticipantes() != null) &&
                    (dtoC.getClasificParticipantes().getLstClasificacionParticipantes().size() > 0)) {
                dtoC.setIndClasificacionParticipantes(new Boolean(true));
            } else {
                dtoC.setIndClasificacionParticipantes(new Boolean(false));
            }

            DTOProducto dtoP = monConcurso.create().obtenerProductosValidos(DTOE);
            UtilidadesLog.debug("obtenerProductosValidos: " + dtoP);
            dtoC.setProductosValidos(dtoP);

            if (dtoP != null) {
                dtoC.setIndProductosValidos(new Boolean(true));
                dtoC.setIndObligProductosValidos(new Boolean(true));
            } else {
                dtoC.setIndProductosValidos(new Boolean(false));
                dtoC.setIndObligProductosValidos(new Boolean(false));
            }

            dtoP = monConcurso.create().obtenerProductosExcluidos(DTOE);
            UtilidadesLog.debug("obtenerProductosExcluidos: " + dtoP);
            dtoC.setProductosExcluidos(dtoP);

            if (dtoP != null) {
                dtoC.setIndProductosExcluidos(new Boolean(true));
                dtoC.setIndObligProductosExcluidos(new Boolean(true));
            } else {
                dtoC.setIndProductosExcluidos(new Boolean(false));
                dtoC.setIndObligProductosExcluidos(new Boolean(false));
            }
            
            if(dtoC.getIndObligProductosValidos().booleanValue() || dtoC.getIndObligProductosExcluidos().booleanValue()){
                dtoC.setIndObligProductos(Boolean.TRUE);
            } else {
                dtoC.setIndObligProductos(Boolean.FALSE);
            }

            DTOParametrosGeneralesPremiacion dtoPGP = this.obtenerPremiosRanking(DTOE);
            UtilidadesLog.debug("DTOParametrosGeneralesPremiacion: " + dtoPGP);
            dtoC.setParamGralesPremiacion(dtoPGP);

            if (dtoPGP != null) {
                dtoC.setIndPremios(new Boolean(true));
                dtoC.setIndObligPremios(new Boolean(true));
            } else {
                dtoC.setIndPremios(new Boolean(false));
                dtoC.setIndObligPremios(new Boolean(false));
            }

            /* ---------------------------------- AGREGADO inc.: 18149 -------------------------------------------------*/
            DTONivelesPremiacion dtoNP = monConcurso.create().obtenerNivelesPremiacion(DTOE);
            UtilidadesLog.debug("DTONivelesPremiacion: " + dtoNP);
            dtoC.setListaNivelesPremiacion(dtoNP);

            if (dtoNP != null) {
                dtoC.setIndNivelPremiacion(new Boolean(true));
            } else {
                dtoC.setIndNivelPremiacion(new Boolean(false));
            }

            /* ---------------------------------------------------------------------------------------------------------*/
            UtilidadesLog.debug("termino MONConcursoRanking.obtenerDatosConcursoRanking()");
            UtilidadesLog.info("MONConcursoRankingBean.obtenerDatosConcursoRanking(DTOOID DTOE):Salida");
            return dtoC;
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
    }

    public DTODatosGeneralesConcursoRanking obtenerDatosGeneralesConcursoRanking(DTOOID DTOE)
            throws MareException {
        DAOConcursoRanking daoCR = new DAOConcursoRanking();

        return daoCR.obtenerDatosGeneralesConcursoRanking(DTOE);
    }

    /**
      * @author: ssantana, 21/6/2005
      * @throws es.indra.mare.common.exception.MareException
      * @return DTOSalida
      * @param DTOTipoProducto DTOE
      */
    public DTOSalida obtenerTiposProductoRanking(DTOTipoProducto DTOE)
            throws MareException {
        UtilidadesLog.info("MONConcursoRankingBean.obtenerTiposProductoRanking(DTOTipoProducto DTOE):Entrada");
        

        DTOSalida dtoSalida = new DTOSalida();
        RecordSet r = null;
        DAOConcursoRanking daoConcursoRanking = new DAOConcursoRanking();

        r = daoConcursoRanking.obtenerTiposProductoRanking(DTOE);

        dtoSalida.setResultado(r);

        UtilidadesLog.debug("DTOSalida: " + dtoSalida);
        UtilidadesLog.info("MONConcursoRankingBean.obtenerTiposProductoRanking(DTOTipoProducto DTOE):Salida");
        return dtoSalida;
    }

    /**
    * @Autor: Emilio Noziglia
    * @Fecha : 24/06/2005
    * @Recibe: DTOBelcorp dtoe con pais e idioma
    * @Retorna: DTOSalida
    * @Descripción: obtiene los datos para llenar combos de Variables Venta.
    * @Referencia: SICC-DMCO-INC-INC9 B
    */
    public DTOSalida obtenerVariablesVentaRanking(DTOBelcorp dtoe)
            throws MareException {
        UtilidadesLog.info("MONConcursoRankingBean.obtenerVariablesVentaRanking(DTOBelcorp dtoe):Entrada");
        UtilidadesLog.debug("Entra a obtenerVariablesVentaRanking con DTOBelcorp:" + dtoe);

        DTOSalida dtoS = new DTOSalida();
        DAOConcursoRanking daoConc = new DAOConcursoRanking();
        RecordSet variablesVentaRanking = daoConc.obtenerVariablesVentaRanking(dtoe);
        dtoS.setResultado(variablesVentaRanking);
        UtilidadesLog.debug("Sale de obtenerVariablesVentaRanking con DTOSalida:" + dtoS);
        UtilidadesLog.info("MONConcursoRankingBean.obtenerVariablesVentaRanking(DTOBelcorp dtoe):Salida");

        return dtoS;
    }

    /**
      *
      * @throws es.indra.mare.common.exception.MareException
      * @return
      * @param DTOE
      * @author Sergio C. Saavedra -- 24/06/2005
      */
    public DTOListaVariablesVentaRanking obtenerVariablesVentaRankingConcurso(DTOOID DTOE)
            throws MareException {
        UtilidadesLog.info("MONConcursoRankingBean.obtenerVariablesVentaRankingConcurso(DTOOID DTOE):Entrada");
        

        DTOListaVariablesVentaRanking dtoResu = new DTOListaVariablesVentaRanking();
        DAOConcursoRanking daoConcursoRanking = new DAOConcursoRanking();

        dtoResu = daoConcursoRanking.obtenerVariablesVentaRankingConcurso(DTOE);

        UtilidadesLog.debug("dtoResu: " + dtoResu);
        UtilidadesLog.info("MONConcursoRankingBean.obtenerVariablesVentaRankingConcurso(DTOOID DTOE):Salida");
        return dtoResu;
    }

    /**
      *
      * @throws es.indra.mare.common.exception.MareException
      * @return
      * @param DTOE
      * @author Sergio C. Saavedra -- 24/06/2005
      */
    public DTOParametrosConsultorasRanking obtenerParametrosConsultorasRanking(DTOOID DTOE)
            throws MareException {
       UtilidadesLog.info("MONConcursoRankingBean.obtenerParametrosConsultorasRanking(DTOOID DTOE):Entrada");

        DTOParametrosConsultorasRanking dtoResu = new DTOParametrosConsultorasRanking();
        DAOConcursoRanking daoConcursoRanking = new DAOConcursoRanking();

        dtoResu = daoConcursoRanking.obtenerParametrosConsultorasRanking(DTOE);

        UtilidadesLog.debug("dtoResu: " + dtoResu);
        UtilidadesLog.info("MONConcursoRankingBean.obtenerParametrosConsultorasRanking(DTOOID DTOE):Salida");
        return dtoResu;
    }

    /**
      *
      * @throws es.indra.mare.common.exception.MareException
      * @return
      * @param DTOE
      * @author Sergio C. Saavedra -- 24/06/2005
      */
    public DTOParametrosGeneralesPremiacion obtenerPremiosRanking(DTOOID DTOE)
            throws MareException {
        UtilidadesLog.info("MONConcursoRankingBean.obtenerPremiosRanking(DTOOID DTOE):Entrada");

        DTOParametrosConsultorasRanking dtoResu = new DTOParametrosConsultorasRanking();
        DAOConcursoRanking daoConcursoRanking = new DAOConcursoRanking();

        DTOParametrosGeneralesPremiacion dtoParametrosPremiacion = daoConcursoRanking.obtenerPremiosRanking(DTOE);

        try {
            MONConcursoHome monConcurso = this.getMONConcursoHome();

            RecordSet maxPrem = monConcurso.create().obtenerMaximoNumeroPremio(DTOE).getResultado();

            Object o = null;

            if (dtoParametrosPremiacion != null) {
                dtoParametrosPremiacion.setNumeroPremio(((o = maxPrem.getValueAt(0, 0)) != null) ? new Integer(((BigDecimal) o).toString()) : null);
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
        UtilidadesLog.info("MONConcursoRankingBean.obtenerPremiosRanking(DTOOID DTOE):Salida");
        return dtoParametrosPremiacion;
    }

    /**
     * @throws es.indra.mare.common.exception.MareException
     * @return void
     * @param Long
     * @author Sergio C. Saavedra -- 21/07/2005
     */
    public void borrarAmbitosGeograficos(Long oidConcurso)
            throws MareException {
        UtilidadesLog.info("MONConcursoRankingBean.borrarAmbitosGeograficos(Long oidConcurso):Entrada");
        //elimina los ambitos geograficos exist. en la entidad......
        AmbitoGeograficoLocal ambitoGeograficosL = null;

        UtilidadesLog.debug("Empieza borrarAmbitosGeograficos con oidConcurso: " + oidConcurso);

        try {
            AmbitoGeograficoLocalHome ambitoGeograficosLH = this.getAmbitoGeograficoLocalHome();
            Collection ambitos = ambitoGeograficosLH.findByConcurso(oidConcurso);

            //Eliminar los registros de Ambitos.. 
            if (ambitos != null) {
                for (Iterator itAmbitos = ambitos.iterator(); itAmbitos.hasNext();) {
                    AmbitoGeograficoLocal registro = (AmbitoGeograficoLocal) itAmbitos.next();
                    ambitoGeograficosLH.remove(registro);
                }
            }
        } catch (NoResultException fe) {
            UtilidadesLog.debug(fe);
            //throw new MareException(fe, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE));
        } catch (PersistenceException fe) {
            UtilidadesLog.error("ERROR ", fe);
            throw new MareException(fe, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_BORRADO_DE_DATOS));
        }

        UtilidadesLog.info("MONConcursoRankingBean.borrarAmbitosGeograficos(Long oidConcurso):Salida");
    }

    /**
     * @throws es.indra.mare.common.exception.MareException
     * @return void
     * @param Long
     * @author Sergio C. Saavedra -- 21/07/2005
     */
    public void borrarVariablesVentaRankingConcurso(Long oidConcurso)
            throws MareException {
        UtilidadesLog.info("MONConcursoRankingBean.borrarVariablesVentaRankingConcurso(Long oidConcurso):Entrada");
        //Eliminar los registros de VentasRankingConcurso
        VariablesVentaRankingConcursoLocal variablesVentaRankingConcursoL = null;
        UtilidadesLog.debug("Empieza borrarVariablesVentaRankingConcurso con oidConcurso: " + oidConcurso);

        try {
            VariablesVentaRankingConcursoLocalHome variablesVentaRankingConcursoLH = this.getVariablesVentaRankingConcursoLocalHome();
            Collection vvrcCol = variablesVentaRankingConcursoLH.findByConcurso(oidConcurso);

            //Eliminar los registros de VentasRankingConcurso 
            if (vvrcCol != null) {
                for (Iterator itVariables = vvrcCol.iterator(); itVariables.hasNext();) {
                    VariablesVentaRankingConcursoLocal registro = (VariablesVentaRankingConcursoLocal) itVariables.next();
                    variablesVentaRankingConcursoLH.remove(registro);
                }
            }
        } catch (NoResultException fe) {
            UtilidadesLog.debug(fe);
            //throw new MareException(fe, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE));
        } catch (PersistenceException fe) {
            UtilidadesLog.error("ERROR ", fe);
            throw new MareException(fe, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_BORRADO_DE_DATOS));
        }

        UtilidadesLog.info("MONConcursoRankingBean.borrarVariablesVentaRankingConcurso(Long oidConcurso):Salida");
    }

    /**
     * @throws es.indra.mare.common.exception.MareException
     * @return void
     * @param Long
     * @author Sergio C. Saavedra -- 21/07/2005
     */
    public void borrarProductosValidos(Long oidConcurso)
            throws MareException {
        UtilidadesLog.info("MONConcursoRankingBean.borrarProductosValidos(Long oidConcurso):Entrada");
        //Eliminar los registros de Prod. Validos..
        ProductosValidosLocal productosValidosLocal = null;
        UtilidadesLog.debug("Empieza borrarProductosValidos con oidConcurso: " + oidConcurso);

        try {
            ProductosLocalHome productosLH = this.getProductosLocalHome();
            ProductosValidosLocalHome productosValidosLH = this.getProductosValidosLocalHome();

            ProductosLocal productosL = productosLH.findByUK(oidConcurso);
            UtilidadesLog.debug("productosL: " + productosL);

            Collection prodValidos = productosValidosLH.findByProducto(productosL.getOid());
            UtilidadesLog.debug("prodValidos: " + prodValidos);

            //Eliminar los registros de VentasRankingConcurso 
            if (prodValidos != null) {
                for (Iterator itProdVal = prodValidos.iterator(); itProdVal.hasNext();) {
                    ProductosValidosLocal registro = (ProductosValidosLocal) itProdVal.next();
                    productosValidosLH.remove(registro);
                }
            }
        } catch (NoResultException fe) {
            UtilidadesLog.debug(fe);
            //throw new MareException(fe, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE));
        } catch (PersistenceException fe) {
            UtilidadesLog.error("ERROR ", fe);
            throw new MareException(fe, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_BORRADO_DE_DATOS));
        }

        UtilidadesLog.info("MONConcursoRankingBean.borrarProductosValidos(Long oidConcurso):Salida");
    }

    /**
     * @throws es.indra.mare.common.exception.MareException
     * @return void
     * @param Long
     * @author Sergio C. Saavedra -- 21/07/2005
     */
    public void borrarProductosExcluidos(Long oidConcurso)
            throws MareException {
        UtilidadesLog.info("MONConcursoRankingBean.borrarProductosExcluidos(Long oidConcurso):Entrada");
        //Eliminar los registros de Prod. Excluidos..
        ProductosExcluidosLocal productosExcluidosdosLocal = null;
        UtilidadesLog.debug("Empieza borrarProductosExcluidos con oidConcurso: " + oidConcurso);

        try {
            ProductosLocalHome productosLH = this.getProductosLocalHome();
            ProductosExcluidosLocalHome productosExcluidosLH = this.getProductosExcluidosLocalHome();

            ProductosLocal productosL = productosLH.findByUK(oidConcurso);
            UtilidadesLog.debug("productosL: " + productosL);

            Collection prodExcluidos = productosExcluidosLH.findByProducto(productosL.getOid());
            UtilidadesLog.debug("prodExcluidos: " + prodExcluidos);

            //Eliminar los registros de VentasRankingConcurso 
            if (prodExcluidos != null) {
                for (Iterator itProdExcl = prodExcluidos.iterator(); itProdExcl.hasNext();) {
                    ProductosExcluidosLocal registro = (ProductosExcluidosLocal) itProdExcl.next();
                    productosExcluidosLH.remove(registro);
                }
            }
        } catch (NoResultException fe) {
            UtilidadesLog.debug(fe);
            //throw new MareException(fe, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE));
        } catch (PersistenceException fe) {
            UtilidadesLog.error("ERROR ", fe);
            throw new MareException(fe, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_BORRADO_DE_DATOS));
        }

        UtilidadesLog.info("MONConcursoRankingBean.borrarProductosExcluidos(Long oidConcurso):Salida");
    }

    /**
     * @throws es.indra.mare.common.exception.MareException
     * @return void
     * @param Long
     * @author Sergio C. Saavedra -- 21/07/2005
     */
    public void borrarParametrosGerentes(Long oidConcurso)
            throws MareException {
        UtilidadesLog.info("MONConcursoRankingBean.borrarParametrosGerentes(Long oidConcurso):Entrada");
        // La base de calculo se guarda en la entidad ConcursoParametrosGenerales, por lo tanto al 
        //borrar un registro en gerentes hay que borrar la base en parámetros generales 
        ConcursoParametrosGeneralesLocal concursoParametrosGeneralesL = null;
        ConcursoParametrosGerentesLocal concursoParametrosGerentesL = null;

        UtilidadesLog.debug("Empieza borrarParametrosGerentes con oidConcurso: " + oidConcurso);

        try {
            ConcursoParametrosGeneralesLocalHome concursoParametrosGeneralesLH = this.getConcursoParametrosGeneralesLocalHome();
            concursoParametrosGeneralesL = concursoParametrosGeneralesLH.findByPrimaryKey(oidConcurso);

            concursoParametrosGeneralesL.setBaseCalculo(null);

            ConcursoParametrosGerentesLocalHome concursoParametrosGerentesLH = this.getConcursoParametrosGerentesLocalHome();
            ConcursoParametrosGerentesLocal registro = concursoParametrosGerentesLH.findByConcurso(oidConcurso);
            concursoParametrosGerentesLH.remove(registro);
        } catch (NoResultException fe) {
            UtilidadesLog.debug(fe);
            //throw new MareException(fe, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE));
        } catch (PersistenceException fe) {
            UtilidadesLog.error("ERROR ", fe);
            throw new MareException(fe, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_BORRADO_DE_DATOS));
        }

        UtilidadesLog.info("MONConcursoRankingBean.borrarParametrosGerentes(Long oidConcurso):Salida");
    }

    /**
     * @throws es.indra.mare.common.exception.MareException
     * @return void
     * @param Long
     * @author Sergio C. Saavedra -- 21/07/2005
     */
    public void borrarClasificacionParticipantes(Long oidConcurso)
            throws MareException {
        //Elimina clasific. part. 
        UtilidadesLog.info("MONConcursoRankingBean.borrarClasificacionParticipantes(Long oidConcurso):Entrada");
        ClasificacionParticipantesConcursoLocal clasificacionParticipantesConcursoL = null;

        UtilidadesLog.debug("Empieza borrarClasificacionParticipantes con oidConcurso: " + oidConcurso);

        try {
            ClasificacionParticipantesConcursoLocalHome clasificacionParticipantesConcursoLH = this.getClasificacionParticipantesConcursoLocalHome();
            Collection colPartConc = clasificacionParticipantesConcursoLH.findByConcurso(oidConcurso);

            if (colPartConc != null) {
                for (Iterator itParConc = colPartConc.iterator(); itParConc.hasNext();) {
                    ClasificacionParticipantesConcursoLocal registro = (ClasificacionParticipantesConcursoLocal) itParConc.next();
                    clasificacionParticipantesConcursoLH.remove(registro);
                }
            }
        } catch (NoResultException fe) {
            UtilidadesLog.debug(fe);
            //throw new MareException(fe, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE));
        } catch (PersistenceException fe) {
            UtilidadesLog.error("ERROR ", fe);
            throw new MareException(fe, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_BORRADO_DE_DATOS));
        }

        UtilidadesLog.info("MONConcursoRankingBean.borrarClasificacionParticipantes(Long oidConcurso):Salida");
    }

    /**
     * @throws es.indra.mare.common.exception.MareException
     * @return void
     * @param Long
     * @author Sergio C. Saavedra -- 21/07/2005
     */
    public void borrarParametrosConsultorasRanking(Long oidConcurso)
            throws MareException {
        UtilidadesLog.info("MONConcursoRankingBean.borrarParametrosConsultorasRanking(Long oidConcurso):Entrada");
        // La base de calculo se guarda en la entidad ConcursoParametrosGenerales, por lo tanto 
        // al borrar un registro en consultoras hay que borrar la base en parámetros generales 
        ConcursoParametrosGeneralesLocal concursoParametrosGeneralesL = null;
        ConcursoParametrosConsultorasLocal concursoParametrosConsultorasL = null;

        UtilidadesLog.debug("Empieza borrarParametrosConsultorasRanking con oidConcurso: " + oidConcurso);

        try {
            ConcursoParametrosGeneralesLocalHome concursoParametrosGeneralesLH = this.getConcursoParametrosGeneralesLocalHome();
            concursoParametrosGeneralesL = concursoParametrosGeneralesLH.findByPrimaryKey(oidConcurso);

            ConcursoParametrosConsultorasLocalHome concursoParametrosConsultorasLH = this.getConcursoParametrosConsultorasLocalHome();

            concursoParametrosGeneralesL.setBaseCalculo(null);
            
            concursoParametrosGeneralesLH.merge(concursoParametrosGeneralesL);

            //borro de consultoras.......
            Collection colConcParCons = concursoParametrosConsultorasLH.findByConcurso(oidConcurso);

            if (colConcParCons != null) {
                for (Iterator itConcParCons = colConcParCons.iterator(); itConcParCons.hasNext();) {
                    ConcursoParametrosConsultorasLocal registro = (ConcursoParametrosConsultorasLocal) itConcParCons.next();
                    concursoParametrosConsultorasLH.remove(registro);
                }
            }
        } catch (NoResultException fe) {
            UtilidadesLog.debug(fe);
            //throw new MareException(fe, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE));
        } catch (PersistenceException fe) {
            UtilidadesLog.error("ERROR ", fe);
            throw new MareException(fe, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_BORRADO_DE_DATOS));
        }

        UtilidadesLog.info("MONConcursoRankingBean.borrarParametrosConsultorasRanking(Long oidConcurso):Salida");
    }

    /**
     * @throws es.indra.mare.common.exception.MareException
     * @return void
     * @param Long
     * @author Sergio C. Saavedra -- 21/07/2005
     */
    public void borrarEstatusVenta(Long oidConcurso) throws MareException {
        //Se borran los registros de la entidad EstatusVentaConsultora para ese concurso
        UtilidadesLog.info("MONConcursoRankingBean.borrarEstatusVenta(Long oidConcurso):Entrada");
        EstatusVentaConsultoraLocal estatusVentaConsultoraL = null;

        UtilidadesLog.debug("Empieza borrarEstatusVenta con oidConcurso: " + oidConcurso);

        try {
            EstatusVentaConsultoraLocalHome estatusVentaConsultoraLH = this.getEstatusVentaConsultoraLocalHome();
            Collection colEstVtaCons = estatusVentaConsultoraLH.findByConcurso(oidConcurso);

            if (colEstVtaCons != null) {
                for (Iterator itEstVtaCons = colEstVtaCons.iterator(); itEstVtaCons.hasNext();) {
                    EstatusVentaConsultoraLocal registro = (EstatusVentaConsultoraLocal) itEstVtaCons.next();
                    estatusVentaConsultoraLH.remove(registro);
                }
            }
        } catch (NoResultException fe) {
            UtilidadesLog.debug(fe);
            //throw new MareException(fe, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE));
        } catch (PersistenceException fe) {
            UtilidadesLog.error("ERROR ", fe);
            throw new MareException(fe, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_BORRADO_DE_DATOS));
        }

        UtilidadesLog.info("MONConcursoRankingBean.borrarEstatusVenta(Long oidConcurso):Salida");
    }

    /**
     * @throws es.indra.mare.common.exception.MareException
     * @return void
     * @param Long
     * @author Sergio C. Saavedra -- 21/07/2005
     */
    public void borrarPremiosRanking(Long oidConcurso)
            throws MareException {
        // primero se borran los datos de los niveles y luego se borran los datos de premios
        UtilidadesLog.info("MONConcursoRankingBean.borrarPremiosRanking(Long oidConcurso):Entrada");
        UtilidadesLog.debug("Empieza borrarPremiosRanking con oidConcurso: " + oidConcurso);

        ParametrosGeneralesPremiacionLocal parametrosGeneralesPremiacionL = null;
        MONConcurso mConc = null;

        try {
            MONConcursoHome monConcurso = this.getMONConcursoHome();
            mConc = monConcurso.create();

            ParametrosGeneralesPremiacionLocalHome parametrosGeneralesPremiacionLH = this.getParametrosGeneralesPremiacionLocalHome();

            try {
                parametrosGeneralesPremiacionL = parametrosGeneralesPremiacionLH.findByUK(oidConcurso);
            } catch (NoResultException fe) {
                UtilidadesLog.debug("No hay pestania Premios");
                UtilidadesLog.info("MONConcursoRankingBean.borrarPremiosRanking(Long oidConcurso):Salida");
                return;
            } catch (PersistenceException ce) {
                UtilidadesLog.error("ERROR ", ce);
                throw new MareException(ce, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS));
            }

            ParametrosNivelPremiacionLocalHome parametrosNivelPremiacionLH = this.getParametrosNivelPremiacionLocalHome();

            Collection parNivPrem = null;

            try {
                parNivPrem = parametrosNivelPremiacionLH.findByParametroGeneralPremiacion(parametrosGeneralesPremiacionL.getOid());
            } catch (NoResultException fe) {
                UtilidadesLog.debug(fe);
                UtilidadesLog.debug("No hay niveles");
            } catch (PersistenceException ce) {
                UtilidadesLog.error("ERROR ", ce);
                throw new MareException(ce, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS));
            }

            if (!parNivPrem.isEmpty()) {
                for (Iterator itParNivPrem = parNivPrem.iterator(); itParNivPrem.hasNext();) {
                    ParametrosNivelPremiacionLocal registro = (ParametrosNivelPremiacionLocal) itParNivPrem.next();

                    mConc.borrarPremios(registro.getOid());
                }
            }
            parametrosGeneralesPremiacionLH.remove(parametrosGeneralesPremiacionL);
        } catch (PersistenceException fe) {
            UtilidadesLog.error("ERROR ", fe);
            throw new MareException(fe, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_BORRADO_DE_DATOS));
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

        UtilidadesLog.info("MONConcursoRankingBean.borrarPremiosRanking(Long oidConcurso):Salida");
    }
    
   /**
     * Autor: Cristian Valenzuela
     * Fecha: 18/10/2006
     * Incidencia: BELC300024282
     */
    public DTOSalida obtenerDetalleParticipantes(DTOOID DTOE) throws MareException {
      UtilidadesLog.info("MONConcursoRankingBean.obtenerDetalleParticipantes(DTOOID DTOE): Entrada");
      DAOConcursoRanking dao = new DAOConcursoRanking();      
      DTOSalida dtoSalida = dao.obtenerDetalleParticipantes(DTOE);
      UtilidadesLog.debug("dtoSalida: " + dtoSalida);
      UtilidadesLog.info("MONConcursoRankingBean.obtenerDetalleParticipantes(DTOOID DTOE): Salida");
      return dtoSalida;
    }


    private PeriodoLocalHome getPeriodoLocalHome(){
        return new PeriodoLocalHome();
    }
    
    private ConcursoParametrosGeneralesLocalHome getConcursoParametrosGeneralesLocalHome() {
            return new ConcursoParametrosGeneralesLocalHome();
    }

    private ParametrosRankingLocalHome getParametrosRankingLocalHome() {
            return new ParametrosRankingLocalHome();
    }

    private VariablesVentaRankingConcursoLocalHome getVariablesVentaRankingConcursoLocalHome() {
            return new VariablesVentaRankingConcursoLocalHome();
    }

    private ConcursoParametrosConsultorasLocalHome getConcursoParametrosConsultorasLocalHome() {
            return new ConcursoParametrosConsultorasLocalHome();
    }

    private ProductosLocalHome getProductosLocalHome() {
            return new ProductosLocalHome();
    }

    private ParametrosGeneralesPremiacionLocalHome getParametrosGeneralesPremiacionLocalHome() {
            return new ParametrosGeneralesPremiacionLocalHome();
    }
    
    private AmbitoGeograficoLocalHome getAmbitoGeograficoLocalHome() {
            return new AmbitoGeograficoLocalHome();
    }

    private ProductosValidosLocalHome getProductosValidosLocalHome() {
            return new ProductosValidosLocalHome();
    }

    private ProductosExcluidosLocalHome getProductosExcluidosLocalHome() {
            return new ProductosExcluidosLocalHome();
    }

    private ConcursoParametrosGerentesLocalHome getConcursoParametrosGerentesLocalHome() {
            return new ConcursoParametrosGerentesLocalHome();
    }

    private ClasificacionParticipantesConcursoLocalHome getClasificacionParticipantesConcursoLocalHome() {
            return new ClasificacionParticipantesConcursoLocalHome();
    }

    private EstatusVentaConsultoraLocalHome getEstatusVentaConsultoraLocalHome() {
            return new EstatusVentaConsultoraLocalHome();
    }

    private ParametrosNivelPremiacionLocalHome getParametrosNivelPremiacionLocalHome() {
            return new ParametrosNivelPremiacionLocalHome();
    }
    
    private MensajesLocalHome getMensajesLocalHome() {
            return new MensajesLocalHome();
    }    

    

    

}
