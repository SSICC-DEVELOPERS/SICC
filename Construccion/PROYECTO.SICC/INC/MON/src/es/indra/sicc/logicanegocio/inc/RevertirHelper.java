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
 * Autor : Dante Castiglione
 */
package es.indra.sicc.logicanegocio.inc;

import es.indra.mare.common.exception.MareException;
import es.indra.sicc.util.UtilidadesLog;
import es.indra.sicc.dtos.inc.DTOEConcursoClientePeriodo;
import es.indra.sicc.dtos.inc.DTOESolicitud;
import es.indra.sicc.dtos.inc.DTOPuntajeProductosExigidos;
import es.indra.sicc.dtos.msg.DTOBuzonMensajes;
import es.indra.sicc.dtos.ped.DTOSolicitudValidacion;
import es.indra.sicc.entidades.inc.CalculoProductosExigidosLocal;
import es.indra.sicc.entidades.inc.CalculoProductosExigidosLocalHome;
import es.indra.sicc.entidades.inc.CandidataGanadoraLocal;
import es.indra.sicc.entidades.inc.CandidataGanadoraLocalHome;
import es.indra.sicc.entidades.inc.CuentaCorrientePuntosLocal;
import es.indra.sicc.entidades.inc.CuentaCorrientePuntosLocalHome;
import es.indra.sicc.entidades.inc.PedidosConcursoRecomendadaLocal;
import es.indra.sicc.entidades.inc.PedidosConcursoRecomendadaLocalHome;
import es.indra.sicc.entidades.inc.PuntajeProductosExigidosLocal;
import es.indra.sicc.entidades.inc.PuntajeProductosExigidosLocalHome;
import es.indra.sicc.entidades.inc.SolicitudConcursoMensajeLocal;
import es.indra.sicc.entidades.inc.SolicitudConcursoMensajeLocalHome;
import es.indra.sicc.entidades.inc.SolicitudConcursoRecomendadasLocal;
import es.indra.sicc.entidades.inc.SolicitudConcursoRecomendadasLocalHome;
import es.indra.sicc.logicanegocio.msg.MONGestionMensajes;
import es.indra.sicc.logicanegocio.msg.MONGestionMensajesHome;
import es.indra.sicc.util.CodigosError;
import es.indra.sicc.util.DTOOID;
import es.indra.sicc.util.DTOOIDs;
import es.indra.sicc.util.MSGEjbLocators;
import es.indra.sicc.util.UtilidadesError;

import java.rmi.RemoteException;

import javax.ejb.CreateException;

import javax.persistence.NoResultException;
import javax.persistence.PersistenceException;

public class RevertirHelper {

    public RevertirHelper() {
    }

    /*
     * Elimina los mensajes generados durante el proceso de calculo para una solicitud dada
     */
    public static void revertirMensajes(DTOESolicitud dtoeSolicitud)
            throws MareException {
        UtilidadesLog.info("RevertirHelper.revertirMensajes(DTOESolicitud dtoeSolicitud):Entrada");
        DAOConcursos dao = new DAOConcursos();
        DTOOIDs oidsMensajes = dao.obtenerMensajes(dtoeSolicitud);
        Long[] oids = oidsMensajes.getOids();

        for (int i = 0; i < oids.length; i++) {
            try {
                SolicitudConcursoMensajeLocalHome solicitudMensajeHome = getSolicitudConcursoMensajeLocalHome();
                SolicitudConcursoMensajeLocal solicitudMensaje = solicitudMensajeHome.findByPrimaryKey(oids[i]);
                Long oidBuzon = solicitudMensaje.getOidBuzonMensaje();

                MONGestionMensajesHome gestionMensajesHome = MSGEjbLocators.getMONGestionMensajesHome();
                MONGestionMensajes gestionMensajes = gestionMensajesHome.create();

                DTOBuzonMensajes mensaje = new DTOBuzonMensajes();
                mensaje.setOid(solicitudMensaje.getOidBuzonMensaje());
                gestionMensajes.eliminaDatosMensaje(mensaje);

                solicitudMensajeHome.remove(solicitudMensaje);
            } catch (NoResultException fe) {
                UtilidadesLog.error("ERROR ", fe);
                throw new MareException(fe, UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
            } catch (PersistenceException ee) {
                UtilidadesLog.error("ERROR ", ee);
                throw new MareException(ee, UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
            } catch (CreateException ee) {
                UtilidadesLog.error("ERROR ", ee);
                throw new MareException(ee, UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
            } catch (RemoteException rte) {
                UtilidadesLog.error("ERROR ", rte);
                throw new MareException(rte, UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
            }
        }
        UtilidadesLog.info("RevertirHelper.revertirMensajes(DTOESolicitud dtoeSolicitud):Salida");
    }

    /*
     * Revierte la informacion de recomendadas generada durante
     * el calculo de puntajes para una solicitud dada.
     * Para ello debe actualizar los registros de la entidad
     * PedidoConcursoRecomendada y eliminar los correspondientes en SolicitudConcursoRecomendadas
     */
    public static void revertirRecomendadas(DTOSolicitudValidacion solicitudValidacion)
            throws MareException {
        UtilidadesLog.info("RevertirHelper.revertirRecomendadas(DTOSolicitudValidacion solicitudValidacion):Entrada");
        UtilidadesLog.debug("****Entro RevertirHelper.revertirRecomendadas****");
        DTOESolicitud dtoeSolicitud = new DTOESolicitud();
        dtoeSolicitud.setOidSolicitud(solicitudValidacion.getOidSolicitud());

        DAOConcursos daoConcursos = new DAOConcursos();
        DTOOIDs oidRecomendadas = daoConcursos.obtenerRecomendadas(dtoeSolicitud);
        Long[] oids = oidRecomendadas.getOids();

        for (int i = 0; i < oids.length; i++) {
            try {
                SolicitudConcursoRecomendadasLocalHome solicitudConcursoRecomendadasHome = getSolicitudConcursoRecomendadasLocalHome();
                SolicitudConcursoRecomendadasLocal solicitudConcursoRecomendada = solicitudConcursoRecomendadasHome.findByPrimaryKey(oids[i]);

                DTOOIDs oidPedidoConcuRecomendadas = daoConcursos.obtenerPedidoConcursoRecomendada(solicitudConcursoRecomendada.getRecomendado(),
                                                                                                   solicitudConcursoRecomendada.getConcurso(),
                                                                                                   solicitudConcursoRecomendada.getPeriodo(),
                                                                                                   solicitudConcursoRecomendada.getRecomendante(),
                                                                                                   solicitudConcursoRecomendada.getGerente());

                Long[] oids2 = oidPedidoConcuRecomendadas.getOids();

                for (int j = 0; j < oids2.length; j++) {
                    try {
                        PedidosConcursoRecomendadaLocalHome pedidosConcursoRecomendadasHome = getPedidosConcursoRecomendadaLocalHome();
                        PedidosConcursoRecomendadaLocal pedidosConcursoRecomendada = pedidosConcursoRecomendadasHome.findByPrimaryKey(oids2[j]);
                        pedidosConcursoRecomendada.setMontoPedido(pedidosConcursoRecomendada.getMontoPedido().subtract(solicitudConcursoRecomendada.getMontoSolicitud()));
                        pedidosConcursoRecomendada.setUnidadesPedido(new Integer(pedidosConcursoRecomendada.getUnidadesPedido().intValue() -
                                                                                solicitudConcursoRecomendada.getUnidadesSolicitud().intValue()));
                        pedidosConcursoRecomendadasHome.merge(pedidosConcursoRecomendada);
                    } catch (NoResultException fe2) {
                        UtilidadesLog.debug(fe2);
                    } catch (PersistenceException ce) {
                        UtilidadesLog.error("ERROR ", ce);
                        throw new MareException(ce, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS));
                    }
                }
                solicitudConcursoRecomendadasHome.remove(solicitudConcursoRecomendada);
            } catch (NoResultException fe1) {
                UtilidadesLog.error("ERROR ", fe1);
                throw new MareException(fe1, UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
            } catch (PersistenceException re) {
                UtilidadesLog.error("ERROR ", re);
                throw new MareException(re, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_BORRADO_DE_DATOS));
            }
        }
        UtilidadesLog.info("RevertirHelper.revertirRecomendadas(DTOSolicitudValidacion solicitudValidacion):Salida");
    }

    /*
     * Revierte la informacion de exigencias generada durante
     * el calculo de puntajes para una solicitud dada.
     */
    public static void revertirExigencias(long oidConcurso, DTOSolicitudValidacion solicitudValidacion)
            throws MareException {
            UtilidadesLog.info("RevertirHelper.revertirExigencias(long oidConcurso, DTOSolicitudValidacion solicitudValidacion):Entrada");
        try {
            DAOConcursos dao = new DAOConcursos();
            PuntajeProductosExigidosLocalHome puntajeProductosExigidosHome = getPuntajeProductosExigidosLocalHome();
            DTOOID cpeOID = dao.obtenerCalculoProductosExigidos(new Long(oidConcurso), solicitudValidacion.getOidCliente(),
                                                                solicitudValidacion.getOidPeriodo());

            if (cpeOID != null) {
                CalculoProductosExigidosLocalHome calculoProductosExigidosHome = getCalculoProductosExigidosLocalHome();
                CalculoProductosExigidosLocal calculoProductosExigidos = calculoProductosExigidosHome.findByPrimaryKey(cpeOID.getOid());

                DTOPuntajeProductosExigidos ppeDTO = dao.obtenerSumatoriaProductosExigidos(oidConcurso,
                                                                                           solicitudValidacion.getOidSolicitud().longValue());

                if (ppeDTO != null) {
                    calculoProductosExigidos.setMontoPedido(calculoProductosExigidos.getMontoPedido().subtract(ppeDTO.getMontoPedidos()));
                    calculoProductosExigidos.setUnidadesPedido(new Integer(calculoProductosExigidos.getUnidadesPedido().intValue() -
                                                                           ppeDTO.getUnidadesPedido().intValue()));
                    calculoProductosExigidos.setPuntosPedido(new Integer(calculoProductosExigidos.getPuntosPedido().intValue() -
                                                                         ppeDTO.getPuntosPedido().intValue()));
                    calculoProductosExigidosHome.merge(calculoProductosExigidos);                                                     
                }

                // eliminar los objetos de Puntajes ProductosExigidos
                DTOOIDs dtoOids = dao.obtenerProductosExigidos(oidConcurso, solicitudValidacion.getOidSolicitud().longValue());

                if (dtoOids != null) {
                    Long[] oids = dtoOids.getOids();

                    for (int i = 0; i < oids.length; i++) {
                        PuntajeProductosExigidosLocal puntajeProductosExigidos = puntajeProductosExigidosHome.findByPrimaryKey(oids[i]);
                        puntajeProductosExigidosHome.remove(puntajeProductosExigidos);
                    }
                }
            }
        } catch (NoResultException fe) {
            UtilidadesLog.error("ERROR ", fe);
            throw new MareException(fe, UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
        } catch (PersistenceException rve) {
            UtilidadesLog.error("ERROR ", rve);
            throw new MareException(rve, UtilidadesError.armarCodigoError(CodigosError.ERROR_ELIMINAR_NO_EXISTE));
        }
        UtilidadesLog.info("RevertirHelper.revertirExigencias(long oidConcurso, DTOSolicitudValidacion solicitudValidacion):Salida");
    }

    /*
     * Revierte la informacion de la entidad CuentaCorrientePuntos para una solicitud dada.
     */
    public static void revertirCuentaCorriente(Solicitud solicitud, SolicitudConcurso solicitudConcurso)
            throws MareException {
            UtilidadesLog.info("RevertirHelper.revertirCuentaCorriente(Solicitud solicitud, SolicitudConcurso solicitudConcurso):Entrada");
        try {
            DAOConcursos dao = new DAOConcursos();
            DTOEConcursoClientePeriodo dtoe = new DTOEConcursoClientePeriodo();
            dtoe.setOidPeriodo(solicitud.getPeriodo().getOidPeriodo());
            dtoe.setOidCliente(solicitud.getCliente().getOidCliente());
            dtoe.setOidConcurso(solicitudConcurso.getOidConcurso());

            DTOOID ccpOID = dao.obtenerCuentaCorriente(dtoe);

            if (ccpOID != null) {
                CuentaCorrientePuntosLocalHome cuentaCorrientePuntosHome = getCuentaCorrientePuntosLocalHome();
                CuentaCorrientePuntosLocal cuentaCorrientePuntos = cuentaCorrientePuntosHome.findByPrimaryKey(ccpOID.getOid());

                if (solicitudConcurso.getExigenciasCumplidasEnSolicitud() == true) {
                    cuentaCorrientePuntos.setNumeroPuntos(new Integer(cuentaCorrientePuntos.getNumeroPuntos().intValue() - solicitudConcurso.getNumeroPuntos().intValue()));
                    cuentaCorrientePuntosHome.merge(cuentaCorrientePuntos);
                } else {
                    cuentaCorrientePuntosHome.remove(cuentaCorrientePuntos);
                }
            }
        } catch (NoResultException fe) {
            UtilidadesLog.error("ERROR ", fe);
            throw new MareException(fe, UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
        } catch (PersistenceException rve) {
            UtilidadesLog.error("ERROR ", rve);
            throw new MareException(rve, UtilidadesError.armarCodigoError(CodigosError.ERROR_ELIMINAR_NO_EXISTE));
        }
        UtilidadesLog.info("RevertirHelper.revertirCuentaCorriente(Solicitud solicitud, SolicitudConcurso solicitudConcurso):Salida");
    }

    /*
     * Determina si la solicitud tiene puntos en cuenta corriente independientemente del concurso.
     */
    public static boolean tieneCuentaCorriente(DTOSolicitudValidacion solicitudValidacion)
            throws MareException {
        UtilidadesLog.info("RevertirHelper.tieneCuentaCorriente(DTOSolicitudValidacion solicitudValidacion):Entrada");
        DTOEConcursoClientePeriodo dto = new DTOEConcursoClientePeriodo();
        dto.setOidPeriodo(solicitudValidacion.getOidPeriodo());
        dto.setOidCliente(solicitudValidacion.getOidCliente());

        DAOConcursos dao = new DAOConcursos();

        int count = dao.contarCuentasCorrientes(dto);
        UtilidadesLog.info("RevertirHelper.tieneCuentaCorriente(DTOSolicitudValidacion solicitudValidacion):Salida");
        return (count > 0);
    }

    /*
     * Revierte la informacion de CandidataGanadoras para una solicitud dada.
     */
    public static void revertirCandidataGanadora(Solicitud solicitud, SolicitudConcurso solicitudConcurso)
            throws MareException {
        UtilidadesLog.info("RevertirHelper.revertirCandidataGanadora(Solicitud solicitud, SolicitudConcurso solicitudConcurso):Entrada");
        try {
            DAOConcursos dao = new DAOConcursos();
            DTOEConcursoClientePeriodo dtoe = new DTOEConcursoClientePeriodo();
            dtoe.setOidPeriodo(solicitud.getPeriodo().getOidPeriodo());
            dtoe.setOidCliente(solicitud.getCliente().getOidCliente());
            dtoe.setOidConcurso(solicitudConcurso.getOidConcurso());

            DTOOID cgOID = dao.obtenerCandidataGanadora(dtoe);

            if (cgOID != null) {
                CandidataGanadoraLocalHome candidataGanadoraHome = getCandidataGanadoraLocalHome();
                CandidataGanadoraLocal candidataGanadora = candidataGanadoraHome.findByPrimaryKey(cgOID.getOid());

                if (solicitudConcurso.getCandidataGanadora() == false) {
                    candidataGanadoraHome.remove(candidataGanadora);
                }
            }
        } catch (NoResultException fe) {
            UtilidadesLog.error("ERROR ", fe);
            throw new MareException(fe, UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
        } catch (PersistenceException rve) {
            UtilidadesLog.error("ERROR ", rve);
            throw new MareException(rve, UtilidadesError.armarCodigoError(CodigosError.ERROR_ELIMINAR_NO_EXISTE));
        }
        UtilidadesLog.info("RevertirHelper.revertirCandidataGanadora(Solicitud solicitud, SolicitudConcurso solicitudConcurso):Salida");
    }

    /*
     * Determina si el cliente de la solicitud es CandidataGanadora independientemente del concurso.
     */
    public static boolean esCandidataGanadora(DTOSolicitudValidacion solicitudValidacion)
            throws MareException {
        UtilidadesLog.info("RevertirHelper.esCandidataGanadora(DTOSolicitudValidacion solicitudValidacion):Entrada");
        DTOEConcursoClientePeriodo dto = new DTOEConcursoClientePeriodo();
        dto.setOidPeriodo(solicitudValidacion.getOidPeriodo());
        dto.setOidCliente(solicitudValidacion.getOidCliente());

        DAOConcursos dao = new DAOConcursos();

        int count = dao.contarCandidataGanadoras(dto);
        UtilidadesLog.info("RevertirHelper.esCandidataGanadora(DTOSolicitudValidacion solicitudValidacion):Salida");

        return (count > 0);
    }
    
    private static SolicitudConcursoMensajeLocalHome getSolicitudConcursoMensajeLocalHome() {
            return new SolicitudConcursoMensajeLocalHome();
    }

    private static SolicitudConcursoRecomendadasLocalHome getSolicitudConcursoRecomendadasLocalHome() {
            return new SolicitudConcursoRecomendadasLocalHome();
    }

    private static PedidosConcursoRecomendadaLocalHome getPedidosConcursoRecomendadaLocalHome() {
            return new PedidosConcursoRecomendadaLocalHome();
    }

    private static PuntajeProductosExigidosLocalHome getPuntajeProductosExigidosLocalHome() {
            return new PuntajeProductosExigidosLocalHome();
    }

    private static CalculoProductosExigidosLocalHome getCalculoProductosExigidosLocalHome() {
            return new CalculoProductosExigidosLocalHome();
    }

    private static CuentaCorrientePuntosLocalHome getCuentaCorrientePuntosLocalHome() {
            return new CuentaCorrientePuntosLocalHome();
    }

    private static CandidataGanadoraLocalHome getCandidataGanadoraLocalHome() {
            return new CandidataGanadoraLocalHome();
    }

    
}
