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
 * Autor : Paola Cabrera
 */
package es.indra.sicc.logicanegocio.inc;

import es.indra.mare.common.exception.MareException;
import es.indra.mare.common.mii.services.jdbcservice.RecordSet;
import es.indra.sicc.cmn.negocio.i18n.Entidadi18nLocal;
import es.indra.sicc.cmn.negocio.i18n.Entidadi18nLocalHome;
import es.indra.sicc.dtos.inc.DTOObtenerTipoSubtipoSolicitud;
import es.indra.sicc.dtos.msg.ConstantesMSG;
import es.indra.sicc.dtos.cra.DTOPeriodo;
import es.indra.sicc.dtos.inc.DTOConsultarPremiosConsuelo;
import es.indra.sicc.dtos.inc.DTOPremConsueloFichero;
import es.indra.sicc.dtos.inc.DTOPremiosConsuelo;
import es.indra.sicc.dtos.inc.DTOPremioDetalle;
import es.indra.sicc.dtos.msg.DTOBuzonMensajes;
import es.indra.sicc.dtos.ped.DTOCabeceraSolicitud;
import es.indra.sicc.dtos.ped.DTOPosicionSolicitud;
import es.indra.sicc.entidades.mae.MaestroProductosLocal;
import es.indra.sicc.entidades.mae.MaestroProductosLocalHome;
import es.indra.sicc.logicanegocio.mae.ConstantesMAE;
import es.indra.sicc.entidades.inc.ArticulosPremiosConsueloLocal;
import es.indra.sicc.entidades.inc.ArticulosPremiosConsueloLocalHome;
import es.indra.sicc.entidades.inc.ClientesPremiosConsueloLocal;
import es.indra.sicc.entidades.inc.ClientesPremiosConsueloLocalHome;
import es.indra.sicc.entidades.inc.ConcursoParametrosGeneralesLocal;
import es.indra.sicc.entidades.inc.ConcursoParametrosGeneralesLocalHome;
import es.indra.sicc.entidades.inc.PremioConsueloLocal;
import es.indra.sicc.entidades.inc.PremioConsueloLocalHome;
import es.indra.sicc.entidades.mae.ClienteDatosBasicosLocal;
import es.indra.sicc.entidades.mae.ClienteDatosBasicosLocalHome;
import es.indra.sicc.entidades.msg.MensajesLocal;
import es.indra.sicc.entidades.msg.MensajesLocalHome;
import es.indra.sicc.entidades.zon.SeccionLocal;
import es.indra.sicc.entidades.zon.SeccionLocalHome;
import es.indra.sicc.entidades.zon.TerritorioLocal;
import es.indra.sicc.entidades.zon.TerritorioLocalHome;
import es.indra.sicc.entidades.zon.ZonaLocal;
import es.indra.sicc.entidades.zon.ZonaLocalHome;
import es.indra.sicc.logicanegocio.cra.MONPeriodos;
import es.indra.sicc.logicanegocio.cra.MONPeriodosHome;
import es.indra.sicc.logicanegocio.inc.ConstantesINC;
import es.indra.sicc.logicanegocio.msg.MONGestionMensajes;
import es.indra.sicc.logicanegocio.msg.MONGestionMensajesHome;
import es.indra.sicc.logicanegocio.ped.MONGenerarSolicitudModulosExternos;
import es.indra.sicc.logicanegocio.ped.MONGenerarSolicitudModulosExternosHome;
import es.indra.sicc.logicanegocio.seg.ConstantesSEG;
import es.indra.sicc.util.CRAEjbLocators;
import es.indra.sicc.util.CodigosError;
import es.indra.sicc.util.DTOBelcorp;
import es.indra.sicc.util.DTOOID;
import es.indra.sicc.util.DTOOIDs;
import es.indra.sicc.util.DTOSalida;
import es.indra.sicc.util.MAEEjbLocators;
import es.indra.sicc.util.MSGEjbLocators;
import es.indra.sicc.util.PEDEjbLocators;
import es.indra.sicc.util.UtilidadesError;
import es.indra.sicc.util.UtilidadesLog;
import es.indra.sicc.entidades.mae.MaestroProductosPK;
import es.indra.sicc.dtos.inc.DTOCentroServicio;

import java.math.BigDecimal;

import java.rmi.RemoteException;

import java.sql.Date;

import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Vector;

import javax.ejb.CreateException;
import javax.ejb.FinderException;
import javax.ejb.SessionBean;
import javax.ejb.SessionContext;

import javax.naming.InitialContext;
import javax.naming.NamingException;

import javax.persistence.NoResultException;
import javax.persistence.PersistenceException;

public class MONPremiosConsueloBean implements SessionBean {
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
    * @author Paola Cabrera
    * @fecha 13/07/2005
    */
    public DTOSalida obtenerEnviarA(DTOBelcorp DTOE) throws MareException {
        UtilidadesLog.info("MONPremiosConsuelo.obtenerEnviarA(DTOBelcorp DTOE):Entrada");

        DAOPremiosConsuelo daoPremiosConsuelo = new DAOPremiosConsuelo();

        DTOSalida dtoResu = new DTOSalida();
        RecordSet obtenerEnviar = daoPremiosConsuelo.obtenerEnviarA(DTOE);
        dtoResu.setResultado(obtenerEnviar);

        UtilidadesLog.debug("dtoResu: " + dtoResu);
        UtilidadesLog.info("MONPremiosConsuelo.obtenerEnviarA(DTOBelcorp DTOE):Salida");

        return dtoResu;
    }

    /**
    *
    * @throws es.indra.mare.common.exception.MareException
    * @return
    * @param DTOE
    * @author Paola Cabrera
    * @fecha 13/07/2005
    */
    public DTOSalida obtenerMotivosPremiosConsuelo(DTOBelcorp DTOE)
            throws MareException {
        UtilidadesLog.info("MONPremiosConsuelo.obtenerMotivosPremiosConsuelo(DTOBelcorp DTOE):Entrada");

        DAOPremiosConsuelo daoPremiosConsuelo = new DAOPremiosConsuelo();

        DTOSalida dtoResu = new DTOSalida();
        RecordSet obtenerMotivosPremiosC = daoPremiosConsuelo.obtenerMotivosPremiosConsuelo(DTOE);
        dtoResu.setResultado(obtenerMotivosPremiosC);

        UtilidadesLog.debug("dtoResu: " + dtoResu);
        UtilidadesLog.info("MONPremiosConsuelo.obtenerMotivosPremiosConsuelo(DTOBelcorp DTOE):Salida");
        return dtoResu;
    }

    /**
    *
    * @throws es.indra.mare.common.exception.MareException
    * @return
    * @param DTOE
    * @author Paola Cabrera
    * @fecha 13/07/2005
    */
    public DTOSalida obtenerConcursoGanadoras(DTOBelcorp DTOE)
            throws MareException {
        UtilidadesLog.info("MONPremiosConsuelo.obtenerConcursoGanadoras(DTOBelcorp DTOE):Entrada");

        DAOPremiosConsuelo daoPremiosConsuelo = new DAOPremiosConsuelo();

        DTOSalida dtoResu = new DTOSalida();
        RecordSet obtenerConcursoGanadoras = daoPremiosConsuelo.obtenerConcursoGanadoras(DTOE);
        dtoResu.setResultado(obtenerConcursoGanadoras);

        UtilidadesLog.debug("dtoResu: " + dtoResu);
        UtilidadesLog.info("MONPremiosConsuelo.obtenerConcursoGanadoras(DTOBelcorp DTOE):Salida");
        return dtoResu;
    }

    /**
    *
    * @throws es.indra.mare.common.exception.MareException
    * @return
    * @param DTOE
    * @author Paola Cabrera
    * @fecha 13/07/2005
    */
    public DTOSalida obtenerClientesGanadoras(DTOBelcorp DTOE)
            throws MareException {
        UtilidadesLog.info("MONPremiosConsuelo.obtenerClientesGanadoras(DTOBelcorp DTOE):Entrada");

        DAOPremiosConsuelo daoPremiosConsuelo = new DAOPremiosConsuelo();

        DTOSalida dtoResu = new DTOSalida();
        RecordSet obtenerClientesGanadoras = daoPremiosConsuelo.obtenerClientesGanadoras(DTOE);
        dtoResu.setResultado(obtenerClientesGanadoras);

        UtilidadesLog.debug("dtoResu: " + dtoResu);
        UtilidadesLog.info("MONPremiosConsuelo.obtenerClientesGanadoras(DTOBelcorp DTOE):Salida");
        return dtoResu;
    }

    /**
    *
    * @throws es.indra.mare.common.exception.MareException
    * @return
    * @param DTOE
    * @author Paola Cabrera
    * @fecha 13/07/2005
    * Modificado: Cristian Valenzuela
    * Fecha: 23/08/2006
    * Incidencia: BELC300023493 - DBLG500000695
    */
    public DTOSalida guardarPremiosConsuelo(DTOPremiosConsuelo DTOE)
            throws MareException {
        UtilidadesLog.info("MONPremiosConsuelo.guardarPremiosConsuelo(DTOPremiosConsuelo DTOE):Entrada");

        UtilidadesLog.debug("contenido del DTOE**** " + DTOE);

        PremioConsueloLocal premioConsueloL = null;

        ArrayList dtoPremConsueloFichero = null;
        DTOSalida dtoSalida = new DTOSalida();
        RecordSet valor = new RecordSet();

        Vector vect = new Vector();

        PremioConsueloLocalHome premioConsueloLH = this.getPremioConsueloLocalHome();
    
        try {
            premioConsueloL = premioConsueloLH.create(Long.valueOf(DTOE.getUnidades().toString()), DTOE.getMotivo(), DTOE.getEnviarA(),
                                                      DTOE.getDespachaArticulo());
        } catch (PersistenceException ne) {
            UtilidadesLog.error("ERROR ", ne);
            throw new MareException(ne, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS));
        }

        if (DTOE.getComunicacion().booleanValue()) {
            premioConsueloL.setComunicacion(Integer.valueOf("1"));
        } else {
            premioConsueloL.setComunicacion(Integer.valueOf("0"));
        }

        premioConsueloL.setObservaciones(DTOE.getObservaciones());

        if (DTOE.getCodMensaje() != null) {
            MensajesLocal msgL;

            MensajesLocalHome msgLH = this.getMensajesLocalHome();

            try {
                msgL = msgLH.findByUk(DTOE.getOidPais(), DTOE.getCodMensaje());
                UtilidadesLog.debug("msgL.getOid() " + msgL.getOid());

                premioConsueloL.setMensaje(msgL.getOid());
            } catch (NoResultException fe) {
                UtilidadesLog.error("ERROR ", fe);
                throw new MareException(null, null, UtilidadesError.armarCodigoError(ConstantesSEG.MODULO_INC, "", ErroresDeNegocio.INC_0001));
            }  catch (PersistenceException ce) {
                 UtilidadesLog.error("ERROR ", ce);
                 throw new MareException(ce, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS));
            }
        } //-- 

        Long oidPremioConsuelo = premioConsueloL.getOid();

        guardarArticulosPremiosConsuelo(DTOE.getLstPremiosDetalles(), oidPremioConsuelo);
        UtilidadesLog.debug("despues de  guardarArticulosPremiosConsuelo ");

        if (DTOE.getClientesSeleccionados() != null) {
            guardarClientesPremiosConsuelo(DTOE.getClientesSeleccionados(), oidPremioConsuelo);

            valor.addColumn("valor");
            vect.add(new Long(0));
            valor.addRow(vect);
            dtoSalida.setResultado(valor);
        }

        if (DTOE.getNroConcursoSeleccionados() != null) {
            guardarClientesPremioConsueloXnroConcurso(DTOE.getNroConcursoSeleccionados(), oidPremioConsuelo);
            valor.addColumn("valor");
            vect.add(new Long(0));
            valor.addRow(vect);
            dtoSalida.setResultado(valor);
        }

        if (DTOE.getClientesFicheroSeleccionados() != null) {
            //*** MODIFICADO INCIDENCIA BELC300023493 ***
            //dtoPremConsueloFichero = this.guardarClientesPremioConsueloXFicheroSeleccionado(DTOE.getClientesFicheroSeleccionados(), oidPremioConsuelo);
            dtoPremConsueloFichero = this.guardarClientesPremioConsueloXFicheroSeleccionado(DTOE.getClientesFicheroSeleccionados(), 
            oidPremioConsuelo, DTOE.getOidPais());           
            //*** MODIFICADO INCIDENCIA BELC300023493 ***
            
            UtilidadesLog.debug("DTOEetOids().length " + DTOE.getClientesFicheroSeleccionados().size());
            UtilidadesLog.debug("dtoPremConsFichero.size " + dtoPremConsueloFichero.size());

            //  tamaño de dtoPremConsueloFichero - tamaño DTOE.clientesFicheroSeleccionados;
            int total = (DTOE.getClientesFicheroSeleccionados().size() - dtoPremConsueloFichero.size());

            UtilidadesLog.debug("total: " + total);
            valor.addColumn("valor");
            vect.add(new Long(total));
            valor.addRow(vect);

            dtoSalida.setResultado(valor);
        }

        UtilidadesLog.debug("DTOE " + DTOE);

        if (DTOE.getComunicacion() != null) {
            if (DTOE.getComunicacion().booleanValue()) {
                if (dtoPremConsueloFichero != null) {
                    DTOE.setClientesFicheroSeleccionados(dtoPremConsueloFichero);
                    comunicarAlCliente(DTOE);
                } else {
                    comunicarAlCliente(DTOE);
                }
            }
        }

        UtilidadesLog.debug("LLAMANDO A  generarSolicitud ----");

        if (dtoPremConsueloFichero != null) {
            DTOE.setClientesFicheroSeleccionados(dtoPremConsueloFichero);
            this.generarSolicitud(DTOE);
        } else {
            this.generarSolicitud(DTOE);
        }

        UtilidadesLog.debug("SALE DE  generarSolicitud ----");

        UtilidadesLog.debug("Sale del metodo de guardarPermiosConsuelo con el dtoSalida " + dtoSalida.toString());
        UtilidadesLog.info("MONPremiosConsuelo.guardarPremiosConsuelo(DTOPremiosConsuelo DTOE):Salida");
        return dtoSalida;
    }

    /**
     * Sistema: Belcorp
     * Módulo:  INC
     * Fecha:   15/07/2005
     * @version 1.00
     * @autor Diego Morello
     */
    public void generarSolicitud(DTOPremiosConsuelo dtoE)
            throws MareException {
        UtilidadesLog.info("MONPremiosConsuelo.generarSolicitud(DTOPremiosConsuelo dtoE):Entrada");
        UtilidadesLog.debug("ENTRA A generarSolicitud con DTOPremiosConsuelo: " + dtoE);

        if (dtoE.getNroConcursoSeleccionados() != null) {
            ConcursoParametrosGeneralesLocalHome home = this.getConcursoParametrosGeneralesLocalHome();
            ConcursoParametrosGeneralesLocal concurso;

            try {
                Long pk = dtoE.getNroConcursoSeleccionados().getOid();
                concurso = home.findByPrimaryKey(pk);
            } catch (NoResultException e) {
                UtilidadesLog.error("ERROR ", e);
                int error = UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE);
                throw new MareException(e, error);
            } catch (PersistenceException ce) {
                UtilidadesLog.error("ERROR ", ce);
                throw new MareException(ce, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS));
            }

            DAOPremiosConsuelo daoPrem = new DAOPremiosConsuelo();
            RecordSet rs = daoPrem.obtenerClientesConcurso(dtoE.getNroConcursoSeleccionados());

            int rows = rs.getRowCount();

            for (int i = 0; i < rows; i++) {
                Long tipoCliente = null;
    
                if (ConstantesINC.TIPO_CONSULTORA.equals(concurso.getDirigidoA())) {
                    tipoCliente = ConstantesMAE.OID_TIPO_CLIENTE_CONSULTORA;
                }
    
                if (ConstantesINC.TIPO_GERENTE.equals(concurso.getDirigidoA())) {
                    tipoCliente = ConstantesMAE.OID_TIPO_CLIENTE_GERENTE;
                }
                
                Long oidCliente = new Long(rs.getValueAt(i, "CLIE_OID_CLIE").toString());

                DTOCabeceraSolicitud dtoCabeceraRetorno = new DTOCabeceraSolicitud();
                                
                DAODespachoPremios daoDesp = new DAODespachoPremios();
                TipoSolicitudPosicion tipoSolicitudPosicion = null;                
                
                // vbongiov -- 16/08/2006
                DTOObtenerTipoSubtipoSolicitud dtoObtenerTipoSubtipoSolicitud = new DTOObtenerTipoSubtipoSolicitud();
                
                dtoObtenerTipoSubtipoSolicitud.setOidPais(dtoE.getOidPais());
                dtoObtenerTipoSubtipoSolicitud.setOidOperacion(ConstantesINC.OPER_SOLIC_PREMIO_CONSUELO);
                dtoObtenerTipoSubtipoSolicitud.setOidCanal(concurso.getCanal());
                dtoObtenerTipoSubtipoSolicitud.setOidDirigidoA(concurso.getDirigidoA());
                dtoObtenerTipoSubtipoSolicitud.setOidMarca(concurso.getMarca());
                dtoObtenerTipoSubtipoSolicitud.setOidConcurso(concurso.getOid());
                dtoObtenerTipoSubtipoSolicitud.setOidCliente(oidCliente);
                dtoObtenerTipoSubtipoSolicitud.setOidPeriodo(null);

                tipoSolicitudPosicion = daoDesp.obtenerTipoSubtipoSolicitud(dtoObtenerTipoSubtipoSolicitud);

                Long periodoActual = null;

                try {
                    MONPeriodosHome monPerHome = CRAEjbLocators.getMONPeriodosHome();
                    MONPeriodos monPer = monPerHome.create();
                    DTOPeriodo dtoPeriodo = monPer.obtienePeriodoActual(dtoE.getOidPais(), concurso.getMarca(), concurso.getCanal());
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

                dtoCabeceraRetorno.setOidPais(dtoE.getOidPais());
                dtoCabeceraRetorno.setOidIdioma(dtoE.getOidIdioma());

                dtoCabeceraRetorno.setOperacion(ConstantesINC.OPER_SOLIC_PREMIO_CONSUELO);
                dtoCabeceraRetorno.setModulo(ConstantesINC.CODIGO_MODULO_ORIGEN);
                dtoCabeceraRetorno.setTipoSolicitud(tipoSolicitudPosicion.getTipoSolicitud());
                dtoCabeceraRetorno.setTipoCliente(tipoCliente);

                dtoCabeceraRetorno.setOidCliente(oidCliente);
                dtoCabeceraRetorno.setMarca(concurso.getMarca());
                dtoCabeceraRetorno.setCanal(concurso.getCanal());
                dtoCabeceraRetorno.setAcceso(tipoSolicitudPosicion.getAcceso());
                dtoCabeceraRetorno.setFecha(new Date(System.currentTimeMillis()));
                dtoCabeceraRetorno.setPeriodo(periodoActual);
                //modificado por Sapaza - fecha 12/09/2007 - incidencia Sicc20070414
                dtoCabeceraRetorno.setObservaciones(null);
                //dtoCabeceraRetorno.setObservaciones("");
                dtoCabeceraRetorno.setOidConcursoParametros(concurso.getOid());

                ArrayList list = new ArrayList();

                HashMap datoPremiosConsuelo = dtoE.getLstPremiosConsuelo();
                UtilidadesLog.debug(" datoPremiosConsuelo " + datoPremiosConsuelo.size());

                Iterator iteradorPremiosConsuelo = datoPremiosConsuelo.entrySet().iterator();
                String desc = new String();

                while (iteradorPremiosConsuelo.hasNext()) {
                    //--Tratamiento del Hash.... para descripcion 
                    //-- y para el oid de premios consuelo
                    Map.Entry entry = (Map.Entry) iteradorPremiosConsuelo.next();

                    Long oid = (Long) entry.getKey();
                    desc = (String) entry.getValue();

                    UtilidadesLog.debug("Contenido del oid " + oid);
                    UtilidadesLog.debug("Contenido del desc " + desc);

                    DTOPosicionSolicitud dtoPos = new DTOPosicionSolicitud();

                    dtoPos.setOidPais(dtoE.getOidPais());
                    dtoPos.setOidIdioma(dtoE.getOidIdioma());

                    dtoPos.setTipoPosicion(tipoSolicitudPosicion.getTipoPosicion());
                    dtoPos.setSubtipoPosicion(tipoSolicitudPosicion.getSubtipoPosicion());
                    dtoPos.setProducto(oid);
                    dtoPos.setUnidadesDemandadas(new Long(dtoE.getUnidades().intValue()));

                    list.add(dtoPos);
                }

                dtoCabeceraRetorno.setPosiciones(list);

                UtilidadesLog.debug("dtoCabeceraRetorno: " + dtoCabeceraRetorno);

                try {
                    MONGenerarSolicitudModulosExternosHome homeMonGer = PEDEjbLocators.getMONGenerarSolicitudModulosExternosHome();
                    MONGenerarSolicitudModulosExternos monGer = homeMonGer.create();

                    monGer.generaSolicitud(dtoCabeceraRetorno);
                } catch (CreateException e) {
                    UtilidadesLog.error("ERROR ", e);
                    int error = UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB);
                    throw new MareException(e, error);
                } catch (RemoteException e) {
                    UtilidadesLog.error("ERROR ", e);
                    int error = UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB);
                    throw new MareException(e, error);
                }
            } // Fin iteración DAOPremiosConsuelo.obtenerClientesConcurso
        } else if (dtoE.getClientesSeleccionados() != null) {
            Long[] oids = dtoE.getClientesSeleccionados().getOids();

            for (int i = 0; i < oids.length; i++) {
                DAOPremiosConsuelo daoPrem = new DAOPremiosConsuelo();
                Long tipoCliente = daoPrem.obtenerTipoCliente(oids[i]);
                Long dirigidoA = null;
                
                if(ConstantesMAE.OID_TIPO_CLIENTE_CONSULTORA.equals(tipoCliente)){
                    dirigidoA = ConstantesINC.OID_DIRIGIDO_A_CONSULTORAS;
                }
                
                if(ConstantesMAE.OID_TIPO_CLIENTE_GERENTE.equals(tipoCliente)) {
                    dirigidoA = ConstantesINC.OID_DIRIGIDO_A_GERENTE;
                }

                RecordSet rs = daoPrem.obtenerMarcaCanal(oids[i], dtoE.getOidPais());

                DTOCabeceraSolicitud dtoCabeceraRetorno = new DTOCabeceraSolicitud();

                DAODespachoPremios daoDesp = new DAODespachoPremios();
                
                // vbongiov -- 16/08/2006
                DTOObtenerTipoSubtipoSolicitud dtoObtenerTipoSubtipoSolicitud = new DTOObtenerTipoSubtipoSolicitud();
                
                dtoObtenerTipoSubtipoSolicitud.setOidPais(dtoE.getOidPais());
                dtoObtenerTipoSubtipoSolicitud.setOidOperacion(ConstantesINC.OPER_SOLIC_PREMIO_CONSUELO);
                dtoObtenerTipoSubtipoSolicitud.setOidCanal(new Long(rs.getValueAt(0, "CANA_OID_CANA").toString()));
                dtoObtenerTipoSubtipoSolicitud.setOidDirigidoA(dirigidoA);
                dtoObtenerTipoSubtipoSolicitud.setOidMarca(new Long(rs.getValueAt(0, "MARC_OID_MARC").toString()));
                dtoObtenerTipoSubtipoSolicitud.setOidConcurso(null);
                dtoObtenerTipoSubtipoSolicitud.setOidCliente(oids[i]);
                dtoObtenerTipoSubtipoSolicitud.setOidPeriodo(null);
                
                TipoSolicitudPosicion tipoSolicitudPosicion = daoDesp.obtenerTipoSubtipoSolicitud(dtoObtenerTipoSubtipoSolicitud);

                Long periodoActual = null;

                try {
                    MONPeriodosHome monPerHome = CRAEjbLocators.getMONPeriodosHome();
                    MONPeriodos monPer = monPerHome.create();
                    Long marca = new Long(rs.getValueAt(0, "MARC_OID_MARC").toString());
                    Long canal = new Long(rs.getValueAt(0, "CANA_OID_CANA").toString());
                    DTOPeriodo dtoPeriodo = monPer.obtienePeriodoActual(dtoE.getOidPais(), marca, canal);
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

                dtoCabeceraRetorno.setOidPais(dtoE.getOidPais());
                dtoCabeceraRetorno.setOidIdioma(dtoE.getOidIdioma());

                dtoCabeceraRetorno.setOperacion(ConstantesINC.OPER_SOLIC_PREMIO_CONSUELO);
                dtoCabeceraRetorno.setModulo(ConstantesINC.CODIGO_MODULO_ORIGEN);
                dtoCabeceraRetorno.setTipoSolicitud(tipoSolicitudPosicion.getTipoSolicitud());
                dtoCabeceraRetorno.setTipoCliente(tipoCliente);
                dtoCabeceraRetorno.setOidCliente(oids[i]);

                Long marca = new Long(rs.getValueAt(0, "MARC_OID_MARC").toString());
                dtoCabeceraRetorno.setMarca(marca);

                Long canal = new Long(rs.getValueAt(0, "CANA_OID_CANA").toString());
                dtoCabeceraRetorno.setCanal(canal);
                dtoCabeceraRetorno.setAcceso(tipoSolicitudPosicion.getAcceso());
                dtoCabeceraRetorno.setFecha(new Date(System.currentTimeMillis()));
                dtoCabeceraRetorno.setPeriodo(periodoActual);
                //modificado por Sapaza - fecha 12/09/2007 - incidencia Sicc20070414
                dtoCabeceraRetorno.setObservaciones(null);
                //dtoCabeceraRetorno.setObservaciones("");

                ArrayList list = new ArrayList();

                HashMap datoPremiosConsuelo = dtoE.getLstPremiosConsuelo();
                UtilidadesLog.debug(" datoPremiosConsuelo " + datoPremiosConsuelo.size());

                Iterator iteradorPremiosConsuelo = datoPremiosConsuelo.entrySet().iterator();
                String desc = new String();

                while (iteradorPremiosConsuelo.hasNext()) {
                    //--Tratamiento del Hash.... para descripcion 
                    //-- y para el oid de premios consuelo
                    Map.Entry entry = (Map.Entry) iteradorPremiosConsuelo.next();

                    Long oid = (Long) entry.getKey();
                    desc = (String) entry.getValue();

                    UtilidadesLog.debug("Contenido del oid " + oid);
                    UtilidadesLog.debug("Contenido del desc " + desc);

                    DTOPosicionSolicitud dtoPos = new DTOPosicionSolicitud();

                    dtoPos.setOidPais(dtoE.getOidPais());
                    dtoPos.setOidIdioma(dtoE.getOidIdioma());

                    dtoPos.setTipoPosicion(tipoSolicitudPosicion.getTipoPosicion());
                    dtoPos.setSubtipoPosicion(tipoSolicitudPosicion.getSubtipoPosicion());
                    dtoPos.setProducto(oid);
                    dtoPos.setUnidadesDemandadas(new Long(dtoE.getUnidades().intValue()));

                    list.add(dtoPos);
                }

                dtoCabeceraRetorno.setPosiciones(list);

                UtilidadesLog.debug("dtoCabeceraRetorno: " + dtoCabeceraRetorno);

                try {
                    MONGenerarSolicitudModulosExternosHome homeMonGer = PEDEjbLocators.getMONGenerarSolicitudModulosExternosHome();
                    MONGenerarSolicitudModulosExternos monGer = homeMonGer.create();

                    monGer.generaSolicitud(dtoCabeceraRetorno);
                } catch (CreateException e) {
                    UtilidadesLog.error("ERROR ", e);
                    int error = UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB);
                    throw new MareException(e, error);
                } catch (RemoteException e) {
                    UtilidadesLog.error("ERROR ", e);
                    int error = UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB);
                    throw new MareException(e, error);
                }
            } // Fin iteración dtoE.clientesSeleccionados
        } else if (dtoE.getClientesFicheroSeleccionados() != null) {
            Iterator itClie = dtoE.getClientesFicheroSeleccionados().iterator();

            while (itClie.hasNext()) {
                DTOPremConsueloFichero dtoPrem = (DTOPremConsueloFichero) itClie.next();

                ConcursoParametrosGeneralesLocalHome home = this.getConcursoParametrosGeneralesLocalHome();
                ConcursoParametrosGeneralesLocal concurso;

                try {
                    Long pk = dtoPrem.getOidConcurso();
                    concurso = home.findByPrimaryKey(pk);
                } catch (NoResultException e) {
                    UtilidadesLog.error("ERROR ", e);
                    int error = UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE);
                    throw new MareException(e, error);
                } catch (PersistenceException ce) {
                    UtilidadesLog.error("ERROR ", ce);
                    throw new MareException(ce, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS));
                }

                Long tipoCliente = null;
                if (ConstantesINC.TIPO_CONSULTORA.equals(concurso.getDirigidoA())) {
                    tipoCliente = ConstantesMAE.OID_TIPO_CLIENTE_CONSULTORA;
                }
    
                if (ConstantesINC.TIPO_GERENTE.equals(concurso.getDirigidoA())) {
                    tipoCliente = ConstantesMAE.OID_TIPO_CLIENTE_GERENTE;
                }

                DTOCabeceraSolicitud dtoCabeceraRetorno = new DTOCabeceraSolicitud();
                DAODespachoPremios daoDesp = new DAODespachoPremios();
                
                // vbongiov -- 16/08/2006
                DTOObtenerTipoSubtipoSolicitud dtoObtenerTipoSubtipoSolicitud = new DTOObtenerTipoSubtipoSolicitud();
                
                dtoObtenerTipoSubtipoSolicitud.setOidPais(dtoE.getOidPais());
                dtoObtenerTipoSubtipoSolicitud.setOidOperacion(ConstantesINC.OPER_SOLIC_PREMIO_CONSUELO);
                dtoObtenerTipoSubtipoSolicitud.setOidCanal(concurso.getCanal());
                dtoObtenerTipoSubtipoSolicitud.setOidDirigidoA(concurso.getDirigidoA());
                dtoObtenerTipoSubtipoSolicitud.setOidMarca(concurso.getMarca());
                dtoObtenerTipoSubtipoSolicitud.setOidConcurso(concurso.getOid());
                dtoObtenerTipoSubtipoSolicitud.setOidCliente(dtoPrem.getOidCliente());
                dtoObtenerTipoSubtipoSolicitud.setOidPeriodo(null);
                
                TipoSolicitudPosicion tipoSolicitudPosicion = daoDesp.obtenerTipoSubtipoSolicitud(dtoObtenerTipoSubtipoSolicitud);

                Long periodoActual = null; 

                try {
                    MONPeriodosHome monPerHome = CRAEjbLocators.getMONPeriodosHome();
                    MONPeriodos monPer = monPerHome.create();
                    DTOPeriodo dtoPeriodo = monPer.obtienePeriodoActual(dtoE.getOidPais(), concurso.getMarca(), concurso.getCanal());
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

                dtoCabeceraRetorno.setOidPais(dtoE.getOidPais());
                dtoCabeceraRetorno.setOidIdioma(dtoE.getOidIdioma());

                dtoCabeceraRetorno.setOperacion(ConstantesINC.OPER_SOLIC_PREMIO_CONSUELO);
                dtoCabeceraRetorno.setModulo(ConstantesINC.CODIGO_MODULO_ORIGEN);
                dtoCabeceraRetorno.setTipoSolicitud(tipoSolicitudPosicion.getTipoSolicitud());
                dtoCabeceraRetorno.setTipoCliente(tipoCliente);
                dtoCabeceraRetorno.setOidCliente(dtoPrem.getOidCliente());
                dtoCabeceraRetorno.setMarca(concurso.getMarca());
                dtoCabeceraRetorno.setCanal(concurso.getCanal());
                dtoCabeceraRetorno.setAcceso(tipoSolicitudPosicion.getAcceso());
                dtoCabeceraRetorno.setFecha(new Date(System.currentTimeMillis()));
                dtoCabeceraRetorno.setPeriodo(periodoActual);
                //modificado por Sapaza - fecha 12/09/2007 - incidencia Sicc20070414
                dtoCabeceraRetorno.setObservaciones(null);
                //dtoCabeceraRetorno.setObservaciones("");
                dtoCabeceraRetorno.setOidConcursoParametros(concurso.getOid());

                ArrayList list = new ArrayList();

                HashMap datoPremiosConsuelo = dtoE.getLstPremiosConsuelo();
                UtilidadesLog.debug(" datoPremiosConsuelo " + datoPremiosConsuelo.size());

                Iterator iteradorPremiosConsuelo = datoPremiosConsuelo.entrySet().iterator();
                String desc = new String();

                while (iteradorPremiosConsuelo.hasNext()) {
                    //--Tratamiento del Hash.... para descripcion 
                    //-- y para el oid de premios consuelo
                    Map.Entry entry = (Map.Entry) iteradorPremiosConsuelo.next();

                    Long oid = (Long) entry.getKey();
                    desc = (String) entry.getValue();

                    UtilidadesLog.debug("Contenido del oid " + oid);
                    UtilidadesLog.debug("Contenido del desc " + desc);

                    DTOPosicionSolicitud dtoPos = new DTOPosicionSolicitud();

                    dtoPos.setOidPais(dtoE.getOidPais());
                    dtoPos.setOidIdioma(dtoE.getOidIdioma());

                    dtoPos.setTipoPosicion(tipoSolicitudPosicion.getTipoPosicion());
                    dtoPos.setSubtipoPosicion(tipoSolicitudPosicion.getSubtipoPosicion());
                    dtoPos.setProducto(oid);
                    dtoPos.setUnidadesDemandadas(new Long(dtoE.getUnidades().intValue()));

                    list.add(dtoPos);
                }

                dtoCabeceraRetorno.setPosiciones(list);

                UtilidadesLog.debug("dtoCabeceraRetorno: " + dtoCabeceraRetorno);

                try {
                    MONGenerarSolicitudModulosExternosHome homeMonGer = PEDEjbLocators.getMONGenerarSolicitudModulosExternosHome();
                    MONGenerarSolicitudModulosExternos monGer = homeMonGer.create();

                    monGer.generaSolicitud(dtoCabeceraRetorno);
                } catch (CreateException e) {
                    UtilidadesLog.error("ERROR ", e);
                    int error = UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB);
                    throw new MareException(e, error);
                } catch (RemoteException e) {
                    UtilidadesLog.error("ERROR ", e);
                    int error = UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB);
                    throw new MareException(e, error);
                }
            } // Fin iteración clientesFicheroSeleccionados
        }

        UtilidadesLog.info("MONPremiosConsuelo.generarSolicitud(DTOPremiosConsuelo dtoE):Salida");
    }

    /**
     * Sistema: Belcorp
     * Módulo:  INC
     * Fecha:   18/07/2005
     * @version 1.00
     * @autor   Diego Morello
     */
    public DTOSalida obtenerArticulosPremioConsuelo() throws MareException {
        UtilidadesLog.info("MONPremiosConsuelo.obtenerArticulosPremioConsuelo():Entrada");
        RecordSet rs = new DAOPremiosConsuelo().obtenerArticulosPremioConsuelo();
        DTOSalida dtoSalida = new DTOSalida();
        dtoSalida.setResultado(rs);
        UtilidadesLog.info("MONPremiosConsuelo.obtenerArticulosPremioConsuelo():Salida");
        return dtoSalida;
    }

    /**
     * Sistema: Belcorp
     * Módulo:  INC
     * Fecha:   18/07/2005
     * @version 1.00
     * @autor   Diego Morello
     */
    public DTOSalida obtenerNroConcursoPremiosConsuelo()
            throws MareException {
        UtilidadesLog.info("MONPremiosConsuelo.obtenerNroConcursoPremiosConsuelo():Entrada");
        RecordSet rs = new DAOPremiosConsuelo().obtenerNroConcursoPremiosConsuelo();
        DTOSalida dtoSalida = new DTOSalida();
        dtoSalida.setResultado(rs);
        UtilidadesLog.info("MONPremiosConsuelo.obtenerNroConcursoPremiosConsuelo():Salida");
        return dtoSalida;
    }

    /**
     * Sistema: Belcorp
     * Módulo:  INC
     * Fecha:   19/07/2005
     * @version 1.00
     * @autor   Diego Morello
     */
    public DTOSalida consultarPremiosConsuelo(DTOConsultarPremiosConsuelo dtoE)
            throws MareException {
        UtilidadesLog.info("MONPremiosConsuelo.consultarPremiosConsuelo(DTOConsultarPremiosConsuelo dtoE):Entrada");
        
        UtilidadesLog.debug("DTO recibido: [ codCliente=" + dtoE.getCodCliente() + ",nroConcurso=" + dtoE.getNroConcurso() + ",articulo=" +
                           dtoE.getArticulo() + ",region=" + dtoE.getRegion() + ",zona=" + dtoE.getZona() + ",oidCliente=" + dtoE.getOidCliente() +
                           ",oidPais=" + dtoE.getOidPais() + "]");

        // Busco el OID del cliente si no viene en el DTO
        Long oidCliente = null;

        if ((dtoE.getOidCliente() == null) && (dtoE.getCodCliente() != null)) {
            // Instancio una entidad ClienteDatosBasicos
            try {
                ClienteDatosBasicosLocalHome cliHome = this.getClienteDatosBasicosLocalHome();
                UtilidadesLog.debug("-- Antes de findByUK (pais,codigo) --- (Ya hallo el home)");

                ClienteDatosBasicosLocal cliente = cliHome.findByUK(dtoE.getOidPais(), dtoE.getCodCliente());
                UtilidadesLog.debug("-- Después de findByUK");
                dtoE.setOidCliente(cliente.getOid());
            } catch (NoResultException nre) {
                ctx.setRollbackOnly();
                 UtilidadesLog.error("ERROR ", nre);
                throw new MareException(nre,        
                    UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE) );         
            } catch (PersistenceException pe) {
                ctx.setRollbackOnly();
                UtilidadesLog.error("ERROR ", pe);
                throw new MareException(pe,
                    UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS));
            }
        }

        UtilidadesLog.debug("-- Antes de DAOPremiosConsuelo.consultarPremiosConsuelo");

        DAOPremiosConsuelo daoPrem = new DAOPremiosConsuelo(ctx.getCallerPrincipal().getName());
        RecordSet rs = daoPrem.consultarPremiosConsuelo(dtoE);

        UtilidadesLog.debug("-- Despues de DAOPremiosConsuelo.consultarPremiosConsuelo");

        DTOSalida dtoSalida = new DTOSalida();
        dtoSalida.setResultado(rs);

        UtilidadesLog.info("MONPremiosConsuelo.consultarPremiosConsuelo(DTOConsultarPremiosConsuelo dtoE):Salida");

        return dtoSalida;
    }

    /**
    *
    * @throws es.indra.mare.common.exception.MareException
    * @return
    * @param DTOE
    * @author Paola Cabrera
    * @fecha
    */
    public void comunicarAlCliente(DTOPremiosConsuelo dtoE)
            throws MareException {
        UtilidadesLog.info("MONPremiosConsuelo.comunicarAlCliente(DTOPremiosConsuelo dtoE):Entrada");
        
        Entidadi18nLocalHome entidadi18nLH = this.getEntidadi18nLocalHome();
        Entidadi18nLocal ei18n = null;
        
        MaestroProductosLocal mProductosL = null;
        MaestroProductosLocalHome mProductosLH = MAEEjbLocators.getMaestroProductosLocalHome();
        DTOPremioDetalle dtoDetalle = null;
        
        DTOOID dtoOID = null;
        DTOCentroServicio dtoCentroServicio = null;
        DAOCentrosServicios daoCentrosServicios = new DAOCentrosServicios();
        
        HashMap premio = dtoE.getLstPremiosConsuelo();

        int posicion = premio.size();
        UtilidadesLog.debug("posicion " + posicion);

        UtilidadesLog.debug("Contenido del DTOE " + dtoE);

        java.util.Date now = GregorianCalendar.getInstance().getTime();
        UtilidadesLog.debug("despues de java.util.Date now " + now);

        long feP = now.getTime();

        java.sql.Date fechaP = new java.sql.Date(feP);
        UtilidadesLog.debug("aPfechaP  " + fechaP);

        ArrayList datoPremiosConsuelo = dtoE.getLstPremiosDetalles();
        int cant = datoPremiosConsuelo.size();
        UtilidadesLog.debug(" datoPremiosConsuelo: " + cant);
        
        MaestroProductosPK maestroProductosPK = null;

        for(int i=0; i<cant; i++) {        
            dtoDetalle = (DTOPremioDetalle)datoPremiosConsuelo.get(i);
            UtilidadesLog.debug("dtoDetalle: " + dtoDetalle);
            
            maestroProductosPK = new MaestroProductosPK(dtoDetalle.getOidProducto());

            // Descripcion de productos
            try{
                mProductosL = mProductosLH.findByPrimaryKey(maestroProductosPK);
            } catch (FinderException e) {
                UtilidadesLog.error("ERROR ", e);

                int error = UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE);
                throw new MareException(e, error);
            }
            
            if (dtoE.getNroConcursoSeleccionados() != null) {
                UtilidadesLog.debug("Por numeros De Concurso Seleccionados ");

                RecordSet rs = new DAOPremiosConsuelo().obtenerClientesConcurso(dtoE.getNroConcursoSeleccionados());
                UtilidadesLog.debug("despues de obtenerClientesConcurso");

                //--Por cada registro..
                if (!rs.esVacio()) {
                    for (int a = 0; a < rs.getRowCount(); a++) {
                        DTOBuzonMensajes dtoBuzon = new DTOBuzonMensajes();
                        
                        dtoBuzon.setOidPais(dtoE.getOidPais());
                        dtoBuzon.setCodigoMensaje(dtoE.getCodMensaje());

                        dtoBuzon.setOidCliente(bigDecimalToLong(rs.getValueAt(a, "CLIE_OID_CLIE")));

                        dtoBuzon.setModuloOrigen(Long.valueOf(ConstantesSEG.MODULO_INC));
                        
                        dtoBuzon.setDatoVariable1(fechaP.toString());

                        UtilidadesLog.debug("Contenido del dtoBuzon " + dtoBuzon);

                        ConcursoParametrosGeneralesLocalHome home = this.getConcursoParametrosGeneralesLocalHome();
                        ConcursoParametrosGeneralesLocal concurso;

                        Long pk = null;

                        UtilidadesLog.debug("dtoE.getNroConcursoSeleccionados() ***" + dtoE.getNroConcursoSeleccionados());

                        try {
                            pk = dtoE.getNroConcursoSeleccionados().getOid();

                            concurso = home.findByPrimaryKey(pk);
                        } catch (NoResultException e) {
                            UtilidadesLog.error("ERROR ", e);
                            int error = UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE);
                            throw new MareException(e, error);
                        } catch (PersistenceException ce) {
                            UtilidadesLog.error("ERROR ", ce);
                            throw new MareException(ce, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS));
                        }
                        
                        dtoBuzon.setDatoVariable14(concurso.getNumeroConcurso());

                        UtilidadesLog.debug("Contenido del pk " + pk);
                        UtilidadesLog.debug("Contenido del concurso " + concurso);

                        dtoBuzon = new DAOPremiosConsuelo().obtenerVariablesClientes(dtoBuzon, dtoE.getNroConcursoSeleccionados().getOid());

                        UtilidadesLog.debug("Contenido del dtoBuzon " + dtoBuzon);

                        String periodoActual = null;

                        try {
                            MONPeriodosHome monPerHome = CRAEjbLocators.getMONPeriodosHome();
                            MONPeriodos monPer = monPerHome.create();
                            DTOPeriodo dtoPeriodo = monPer.obtienePeriodoActual(dtoE.getOidPais(), concurso.getMarca(), concurso.getCanal());
                            periodoActual = dtoPeriodo.getCodigoPeriodo();
                        } catch (CreateException e) {
                            UtilidadesLog.error("ERROR ", e);
                            int error = UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB);
                            throw new MareException(e, error);
                        } catch (RemoteException e) {
                            UtilidadesLog.error("ERROR ", e);
                            int error = UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB);
                            throw new MareException(e, error);
                        }

                        UtilidadesLog.debug("Contenido del periodoActual " + periodoActual);
                        // vbongiov -- 31/05/2006 -- inc DBLG500000731
                        dtoBuzon.setDatoVariable11(mProductosL.getDescripcionCorta());
                        
                        if(dtoDetalle.getIndTipoEntrega().equals("C")){
                            dtoOID = new DTOOID();                            
                            dtoOID.setOid(dtoDetalle.getOidCentroServEntrega());
                            
                            dtoCentroServicio = daoCentrosServicios.obtenerCentroServicio(dtoOID);
                            
                            dtoBuzon.setDatoVariable15(dtoCentroServicio.getCodigo());
                            dtoBuzon.setDatoVariable16(dtoCentroServicio.getDescripcion());
                        }
                        
                        // vbongiov -- 31/05/2006 -- inc DBLG500000731
                        // Descripcion de motivo
                        try {
                            ei18n = entidadi18nLH.findByEntAtrIdioPK(ConstantesINC.ENTIDAD_MOTIVOS_PREM_CONS, new Long(ConstantesINC.NUM_ATRIBUTO.toString()),
                                                                     dtoE.getOidIdioma(), dtoE.getMotivo());
                        } catch (NoResultException nre) {
                            try {
                                ei18n = entidadi18nLH.findByEntAtrIdioPK(ConstantesINC.ENTIDAD_MOTIVOS_PREM_CONS, new Long(ConstantesINC.NUM_ATRIBUTO.toString()),
                                                                         ConstantesSEG.IDIOMA_DEFECTO, dtoE.getMotivo());
                            } catch (NoResultException nrex) {
                            
                            } catch (PersistenceException pe) {
                                ctx.setRollbackOnly();
                                UtilidadesLog.error("ERROR ", pe);
                                throw new MareException(pe,
                                    UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS));
                            }
                            
                        } catch (PersistenceException pe) {
                            ctx.setRollbackOnly();
                            UtilidadesLog.error("ERROR ", pe);
                            throw new MareException(pe,
                                UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS));
                        }                        

                        dtoBuzon.setDatoVariable13(ei18n.getDetalle());
                        
                        dtoBuzon.setListaConsultoras(ConstantesMSG.NO);
                        dtoBuzon.setCodigoPatron("Ultimas Noticias");

                        if (periodoActual != null) {
                            dtoBuzon.setDatoVariable10(periodoActual);
                        } else {
                            dtoBuzon.setDatoVariable10(null);
                        }
                        
                        try {
                            MONGestionMensajesHome monMsgHome = MSGEjbLocators.getMONGestionMensajesHome();

                            MONGestionMensajes monMSG = monMsgHome.create();

                            UtilidadesLog.debug("antes de insertarDatosMensaje --- ");

                            DTOBuzonMensajes dtoBuzonMensaje = monMSG.insertaDatosMensajeBatch(dtoBuzon);
                            
                            UtilidadesLog.debug("Sale de insertar ");
                        } catch (CreateException e) {
                            UtilidadesLog.error("ERROR ", e);
                            int error = UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB);
                            throw new MareException(e, error);
                        } catch (RemoteException e) {
                            UtilidadesLog.error("ERROR ", e);
                            int error = UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB);
                            throw new MareException(e, error);
                        }
                    } //--del recordset
                } //--Si es vacio....
            } //--del arrayList

            if (dtoE.getClientesSeleccionados() != null) {
                //-- sino DTOE.clientesSeleccionados != null entonces
                UtilidadesLog.debug(" getClientesSeleccionados");

                DTOOIDs dtoCliente = dtoE.getClientesSeleccionados();
                UtilidadesLog.debug(" dtoCliente " + dtoCliente);

                int finalCli = dtoCliente.getOids().length;
                Long[] oidCliente = dtoCliente.getOids();

                UtilidadesLog.debug("finalCli " + finalCli);

                //--por cada cliente seleccionado
                for (int b = 0; b < finalCli; b++) {
                    ClienteDatosBasicosLocal cliente = null;

                    UtilidadesLog.debug("oidCliente[b]  ---> " + oidCliente[b]);

                    try {
                        try {
                            cliente = this.getClienteDatosBasicosLocalHome().findByPrimaryKey(oidCliente[b]);
                        } catch (NoResultException nre) {
                            ctx.setRollbackOnly();
                             UtilidadesLog.error("ERROR ", nre);
                            throw new MareException(nre,        
                                UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE) );         
                        } catch (PersistenceException pe) {
                            ctx.setRollbackOnly();
                            UtilidadesLog.error("ERROR ", pe);
                            throw new MareException(pe,
                                UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS));
                        }
                    } //-fin try
                    catch (Exception e) {
                        UtilidadesLog.error("ERROR ", e);
                        if (e instanceof MareException) {
                            throw (MareException) e;
                        }
                        throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS));
                    }

                    DTOBuzonMensajes dtoBuzonMens = new DTOBuzonMensajes();

                    dtoBuzonMens.setOidPais(dtoE.getOidPais());
                    dtoBuzonMens.setCodigoMensaje(dtoE.getCodMensaje());
                    dtoBuzonMens.setOidCliente(oidCliente[b]);
                    dtoBuzonMens.setModuloOrigen(Long.valueOf(ConstantesSEG.MODULO_INC));

                    //---No tiene Concurso
                    dtoBuzonMens.setDatoVariable1(fechaP.toString());
                    dtoBuzonMens.setDatoVariable2(cliente.getVal_nom1());
                    dtoBuzonMens.setDatoVariable3(cliente.getVal_ape1());
                    dtoBuzonMens.setDatoVariable4(cliente.getCod_clie());

                    UtilidadesLog.debug(" dtoBuzonMens" + dtoBuzonMens);

                    RecordSet rec = new RecordSet();

                    DAOPremiosConsuelo dao = new DAOPremiosConsuelo();
                    rec = dao.obtenerMarcaCanal(oidCliente[b], dtoE.getOidPais());

                    UtilidadesLog.debug(" rec" + rec.toString());

                    String periodo = null;
                    SeccionLocal seccion = null;
                    ZonaLocal zona = null;
                    TerritorioLocal territorio = null;

                    for (int s = 0; s < rec.getRowCount(); s++) {
                        try {
                            SeccionLocalHome home = this.getSeccionLocalHome();
                                UtilidadesLog.debug("ZSCC_OID_SECC " + rec.getValueAt(s, "ZSCC_OID_SECC"));

                                seccion = home.findByPrimaryKey(bigDecimalToLong(rec.getValueAt(s, "ZSCC_OID_SECC")));
                        } catch (NoResultException nre) {
                            ctx.setRollbackOnly();
                             UtilidadesLog.error("ERROR ", nre);
                            throw new MareException(nre,        
                                UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE) );         
                        } catch (PersistenceException pe) {
                            ctx.setRollbackOnly();
                            UtilidadesLog.error("ERROR ", pe);
                            throw new MareException(pe,
                                UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS));
                        }

                        UtilidadesLog.debug("seccion.getOidZona() " + seccion.getOidZona());

                        try {
                            ZonaLocalHome home = this.getZonaLocalHome();
                                zona = home.findByPrimaryKey(seccion.getOidZona());
                        } catch (NoResultException nre) {
                            ctx.setRollbackOnly();
                             UtilidadesLog.error("ERROR ", nre);
                            throw new MareException(nre,        
                                UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE) );         
                        } catch (PersistenceException pe) {
                            ctx.setRollbackOnly();
                            UtilidadesLog.error("ERROR ", pe);
                            throw new MareException(pe,
                                UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS));
                        }

                        dtoBuzonMens.setDatoVariable5(zona.getCodZona());

                        try {
                            TerritorioLocalHome home = this.getTerritorioLocalHome();
                                territorio = home.findByPrimaryKey(bigDecimalToLong(rec.getValueAt(s, "TERR_OID_TERR")));
                        } catch (NoResultException nre) {
                            ctx.setRollbackOnly();
                             UtilidadesLog.error("ERROR ", nre);
                            throw new MareException(nre,        
                                UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE) );         
                        } catch (PersistenceException pe) {
                            ctx.setRollbackOnly();
                            UtilidadesLog.error("ERROR ", pe);
                            throw new MareException(pe,
                                UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS));
                        }

                        UtilidadesLog.debug("territorio " + territorio);
                        dtoBuzonMens.setDatoVariable6(territorio.getCodTerritorio().toString());

                        try {
                            MONPeriodosHome monPerHome = CRAEjbLocators.getMONPeriodosHome();
                            MONPeriodos monPer = monPerHome.create();
                            UtilidadesLog.debug("antes de obtener Periodo Actual");

                            DTOPeriodo dtoPeriodo = monPer.obtienePeriodoActual(dtoE.getOidPais(),
                                                                                bigDecimalToLong(rec.getValueAt(s, "MARC_OID_MARC")),
                                                                                bigDecimalToLong(rec.getValueAt(s, "CANA_OID_CANA")));

                            UtilidadesLog.debug("dtoPeriodo.getOid() *** " + dtoPeriodo.getOid());
                            periodo = dtoPeriodo.getCodigoPeriodo();
                        } catch (CreateException e) {
                            UtilidadesLog.error("ERROR ", e);
                            int error = UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB);
                            throw new MareException(e, error);
                        } catch (RemoteException e) {
                            UtilidadesLog.error("ERROR ", e);
                            int error = UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB);
                            throw new MareException(e, error);
                        }
                    } //--Termina el recordSet que me trajo la query --FOR

                    UtilidadesLog.debug("sale de  MONPeriodosHome");

                    if (periodo != null) {
                        dtoBuzonMens.setDatoVariable10(periodo);
                    } else {
                        dtoBuzonMens.setDatoVariable10(null);
                    }

                    // vbongiov -- 31/05/2006 -- inc DBLG500000731
                    dtoBuzonMens.setDatoVariable11(mProductosL.getDescripcionCorta());
                    
                    if(dtoDetalle.getIndTipoEntrega().equals("C")){
                        dtoOID = new DTOOID();                            
                        dtoOID.setOid(dtoDetalle.getOidCentroServEntrega());
                        
                        dtoCentroServicio = daoCentrosServicios.obtenerCentroServicio(dtoOID);
                        
                        dtoBuzonMens.setDatoVariable15(dtoCentroServicio.getCodigo());
                        dtoBuzonMens.setDatoVariable16(dtoCentroServicio.getDescripcion());
                    }
                    
                    // vbongiov -- 31/05/2006 -- inc DBLG500000731
                    // Descripcion de motivo
                    try {
                        ei18n = entidadi18nLH.findByEntAtrIdioPK(ConstantesINC.ENTIDAD_MOTIVOS_PREM_CONS, new Long(ConstantesINC.NUM_ATRIBUTO.toString()),
                                                                 dtoE.getOidIdioma(), dtoE.getMotivo());
                    } catch (NoResultException nre) {
                        try {
                            ei18n = entidadi18nLH.findByEntAtrIdioPK(ConstantesINC.ENTIDAD_MOTIVOS_PREM_CONS, new Long(ConstantesINC.NUM_ATRIBUTO.toString()),
                                                                     ConstantesSEG.IDIOMA_DEFECTO, dtoE.getMotivo());
                        } catch (NoResultException nrex) {
                        
                        } catch (PersistenceException pe) {
                            ctx.setRollbackOnly();
                            UtilidadesLog.error("ERROR ", pe);
                            throw new MareException(pe,
                                UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS));
                        }
                    } catch (PersistenceException pe) {
                        ctx.setRollbackOnly();
                        UtilidadesLog.error("ERROR ", pe);
                        throw new MareException(pe,
                            UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS));
                    }                        

                    dtoBuzonMens.setDatoVariable13(ei18n.getDetalle());

                    dtoBuzonMens.setListaConsultoras(ConstantesMSG.NO);
                    dtoBuzonMens.setCodigoPatron("Ultimas Noticias");

                    UtilidadesLog.debug(" dtoBuzonMens" + dtoBuzonMens);

                    try {
                        MONGestionMensajesHome monMsgHome = MSGEjbLocators.getMONGestionMensajesHome();
                        MONGestionMensajes monMSG = monMsgHome.create();

                        DTOBuzonMensajes dtoBuzonMensaje = monMSG.insertaDatosMensajeBatch(dtoBuzonMens);
                      
                    } catch (CreateException e) {
                        UtilidadesLog.error("ERROR ", e);
                        int error = UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB);
                        throw new MareException(e, error);
                    } catch (RemoteException e) {
                        UtilidadesLog.error("ERROR ", e);
                        int error = UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB);
                        throw new MareException(e, error);
                    }
                } //--fin del for
            } //fin  DTOE.clientesSeleccionados != null entonces

            if (dtoE.getClientesFicheroSeleccionados() != null) {
                UtilidadesLog.debug(" getClientesFicheroSeleccionados");

                int clienteFichero = dtoE.getClientesFicheroSeleccionados().size();
                UtilidadesLog.debug("clienteFichero " + clienteFichero);

                for (int c = 0; c < clienteFichero; c++) {
                    DTOBuzonMensajes dtoBuzonMen = new DTOBuzonMensajes();
                    dtoBuzonMen.setOidPais(dtoE.getOidPais());
                    dtoBuzonMen.setCodigoMensaje(dtoE.getCodMensaje());

                    ArrayList fichero = dtoE.getClientesFicheroSeleccionados();

                    UtilidadesLog.debug("fichero " + fichero);

                    DTOPremConsueloFichero dtoS = (DTOPremConsueloFichero) fichero.get(c);
                    UtilidadesLog.debug("******* DTOPremConsueloFichero::" + dtoS);
                    
                    Long oidCliente = dtoS.getOidCliente();
                    Long oidConc = dtoS.getOidConcurso();                   
                    
                    dtoBuzonMen.setOidCliente(oidCliente);
                    dtoBuzonMen.setModuloOrigen(Long.valueOf(ConstantesSEG.MODULO_INC));
                    dtoBuzonMen.setDatoVariable1(fechaP.toString());

                    UtilidadesLog.debug("******* antes de obtenerVariablesClientes");
                    dtoBuzonMen = new DAOPremiosConsuelo().obtenerVariablesClientes(dtoBuzonMen, oidConc);

                    ConcursoParametrosGeneralesLocalHome home = this.getConcursoParametrosGeneralesLocalHome();
                    ConcursoParametrosGeneralesLocal concurso;

                    try {
                        // Long pk = dtoE.getNroConcursoSeleccionados().getOid();
                        concurso = home.findByPrimaryKey(oidConc);
                        UtilidadesLog.debug("despues del pk");
                    } catch (NoResultException e) {
                        UtilidadesLog.error("ERROR ", e);
                        int error = UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE);
                        throw new MareException(e, error);
                    } catch (PersistenceException ce) {
                        UtilidadesLog.error("ERROR ", ce);
                        throw new MareException(ce, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS));
                    }
                    
                    dtoBuzonMen.setDatoVariable14(concurso.getNumeroConcurso());

                    // vbongiov -- 31/05/2006 -- inc DBLG500000731
                    dtoBuzonMen.setDatoVariable11(mProductosL.getDescripcionCorta());
                    
                    if(dtoDetalle.getIndTipoEntrega().equals("C")){
                        dtoOID = new DTOOID();                            
                        dtoOID.setOid(dtoDetalle.getOidCentroServEntrega());
                        
                        dtoCentroServicio = daoCentrosServicios.obtenerCentroServicio(dtoOID);
                        
                        dtoBuzonMen.setDatoVariable15(dtoCentroServicio.getCodigo());
                        dtoBuzonMen.setDatoVariable16(dtoCentroServicio.getDescripcion());
                    }
                    
                    String periodo = null;

                    try {
                        MONPeriodosHome monPerHome = CRAEjbLocators.getMONPeriodosHome();
                        MONPeriodos monPer = monPerHome.create();
                        DTOPeriodo dtoPeriodo = monPer.obtienePeriodoActual(dtoE.getOidPais(), concurso.getMarca(), concurso.getCanal());

                        periodo = dtoPeriodo.getCodigoPeriodo();
                    } catch (CreateException e) {
                        UtilidadesLog.error("ERROR ", e);
                        int error = UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB);
                        throw new MareException(e, error);
                    } catch (RemoteException e) {
                        UtilidadesLog.error("ERROR ", e);
                        int error = UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB);
                        throw new MareException(e, error);
                    }

                    if (periodo != null) {
                        dtoBuzonMen.setDatoVariable10(periodo);
                    } else {
                        dtoBuzonMen.setDatoVariable10(null);
                    }
                    
                    // vbongiov -- 31/05/2006 -- inc DBLG500000731
                    // Descripcion de motivo
                    try {
                        ei18n = entidadi18nLH.findByEntAtrIdioPK(ConstantesINC.ENTIDAD_MOTIVOS_PREM_CONS, new Long(ConstantesINC.NUM_ATRIBUTO.toString()),
                                                                 dtoE.getOidIdioma(), dtoE.getMotivo());
                    } catch (NoResultException nre) {
                        try {
                            ei18n = entidadi18nLH.findByEntAtrIdioPK(ConstantesINC.ENTIDAD_MOTIVOS_PREM_CONS, new Long(ConstantesINC.NUM_ATRIBUTO.toString()),
                                                                     ConstantesSEG.IDIOMA_DEFECTO, dtoE.getMotivo());
                        } catch (NoResultException nrex) {
                            
                        } catch (PersistenceException pe) {
                            ctx.setRollbackOnly();
                            UtilidadesLog.error("ERROR ", pe);
                            throw new MareException(pe,
                                UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS));
                        }
                    } catch (PersistenceException pe) {
                        ctx.setRollbackOnly();
                        UtilidadesLog.error("ERROR ", pe);
                        throw new MareException(pe,
                            UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS));
                    }                        

                    dtoBuzonMen.setDatoVariable13(ei18n.getDetalle());
                    
                    dtoBuzonMen.setListaConsultoras(ConstantesMSG.NO);
                    dtoBuzonMen.setCodigoPatron("Ultimas Noticias");

                    UtilidadesLog.debug(" dtoBuzonMen " + dtoBuzonMen);

                    try {
                        MONGestionMensajesHome monMsgHome = MSGEjbLocators.getMONGestionMensajesHome();
                        MONGestionMensajes monMSG = monMsgHome.create();

                        DTOBuzonMensajes dtoBuzonMensaje = monMSG.insertaDatosMensajeBatch(dtoBuzonMen);
                        
                    } catch (CreateException e) {
                        UtilidadesLog.error("ERROR ", e);
                        int error = UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB);
                        throw new MareException(e, error);
                    } catch (RemoteException e) {
                        UtilidadesLog.error("ERROR ", e);
                        int error = UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB);
                        throw new MareException(e, error);
                    }
                } //--Fin for
            } //--  DTOE.clientesFicheroSeleccionados 
        }

        UtilidadesLog.info("MONPremiosConsuelo.comunicarAlCliente(DTOPremiosConsuelo dtoE):Salida");
    } //--Fin metodo comunicarAlCliente

    /**
    *
    * @throws es.indra.mare.common.exception.MareException
    * @return
    * @param
    * @author Paola Cabrera
    * @fecha
    * Modificado: vbongiov -- 11/9/2007
    */
    public void guardarArticulosPremiosConsuelo(ArrayList articulo, Long oidPremioConsuelo)
            throws MareException {
            UtilidadesLog.info("MONPremiosConsuelo.guardarArticulosPremiosConsuelo(ArrayList articulo, Long oidPremioConsuelo):Entrada");
        /*
           por cada articulo hacer {

           crear la entidad INC:ArticulosPremiosConsuelo con:
           -premioConsuelo = oidPremioConsuelo
           -maestroProductos = articulo.oid
           }

        */
        UtilidadesLog.debug("Entra al metodo guardarArticulosPremiosConsuelo");

        ArticulosPremiosConsueloLocal articulosPremiosL = null;

        try {
            ArticulosPremiosConsueloLocalHome articulosPremiosLH = this.getArticulosPremiosConsueloLocalHome();
            DTOPremioDetalle dtoDetalle = null;

            int cant = articulo.size();
            UtilidadesLog.debug("cant: " + cant);

            for(int i=0; i<cant; i++) {        
                dtoDetalle = (DTOPremioDetalle)articulo.get(i);
                UtilidadesLog.debug("dtoDetalle: " + dtoDetalle);

                articulosPremiosL = articulosPremiosLH.create(oidPremioConsuelo, dtoDetalle.getOidProducto(), 
                                                              dtoDetalle.getIndCentroServGar(), dtoDetalle.getIndTipoEntrega());
                              
                articulosPremiosL.setOidCentroServGar(dtoDetalle.getOidCentroServGar());
                articulosPremiosL.setNumMeses(dtoDetalle.getNumMeses());
                articulosPremiosL.setObservaciones(dtoDetalle.getObservaciones());
                articulosPremiosL.setOidCentroServEntrega(dtoDetalle.getOidCentroServEntrega());               
                articulosPremiosLH.merge(articulosPremiosL);
            } 
            
        } catch (PersistenceException ne) {
            UtilidadesLog.error("ERROR ", ne);
            throw new MareException(ne, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS));
        } catch (Exception ex) {
            UtilidadesLog.error("ERROR ", ex);
            throw new MareException(ex);
        }
        
        UtilidadesLog.info("MONPremiosConsuelo.guardarArticulosPremiosConsuelo(ArrayList articulo, Long oidPremioConsuelo):Salida");
    } //--fin del metodo de guardarArticulos

    /**
    *
    * @throws es.indra.mare.common.exception.MareException
    * @return
    * @param
    * @author Paola Cabrera
    * @fecha
    */
    public void guardarClientesPremiosConsuelo(DTOOIDs DTOE, Long oidPremioConsuelo)
            throws MareException {
            UtilidadesLog.info("MONPremiosConsuelo.guardarClientesPremiosConsuelo(DTOOIDs DTOE, Long oidPremioConsuelo):Entrada");
        /*
         *
         * por cada registro en DTOE hacer {

            crear la entidad INC:ClientesPremiosConsuelo con:
            -cliente = DTOE.oid
         *
         *
         */
        UtilidadesLog.debug("Entra al metodo guardarClientesPremiosConsuelo");

        Long cliente = null;
        ClientesPremiosConsueloLocal clientesPremiosL = null;

        ClientesPremiosConsueloLocalHome clientesPremiosLH = this.getClientesPremiosConsueloLocalHome();

        int finDtoe = DTOE.getOids().length;
        Long[] oidCliente = DTOE.getOids();

        UtilidadesLog.debug(" finDtoe " + finDtoe);
        UtilidadesLog.debug(" oidCliente " + oidCliente);

        for (int i = 0; i < finDtoe; i++) {
            try {
                clientesPremiosL = clientesPremiosLH.create(oidCliente[i], oidPremioConsuelo);
            } catch (PersistenceException ne) {
                UtilidadesLog.error("ERROR ", ne);
                throw new MareException(ne, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS));
            }
        } //--Fin del for

        UtilidadesLog.info("MONPremiosConsuelo.guardarClientesPremiosConsuelo(DTOOIDs DTOE, Long oidPremioConsuelo):Salida");
    } //--fin del metodo

    /**
    *
    * @throws es.indra.mare.common.exception.MareException
    * @return
    * @param
    * @author Paola Cabrera
    * @fecha
    */
    public void guardarClientesPremioConsueloXnroConcurso(DTOOID DTOE, Long oidPremiosConsuelo)
            throws MareException {
        UtilidadesLog.info("MONPremiosConsuelo.guardarClientesPremioConsueloXnroConcurso(DTOOID DTOE, Long oidPremiosConsuelo):Entrada");

        RecordSet rs = new RecordSet();
        DAOPremiosConsuelo dao = new DAOPremiosConsuelo();

        rs = dao.obtenerClientesConcurso(DTOE);

        ClientesPremiosConsueloLocal clientesPremiosL = null;


        ClientesPremiosConsueloLocalHome clientesPremiosLH = this.getClientesPremiosConsueloLocalHome();
        UtilidadesLog.debug("rs.getRowCount() " + rs.getRowCount());

        for (int i = 0; i < rs.getRowCount(); i++) {
            try {
                clientesPremiosL = clientesPremiosLH.create(bigDecimalToLong(rs.getValueAt(i, "CLIE_OID_CLIE")), oidPremiosConsuelo);
                clientesPremiosL.setCopaOidParaGral(DTOE.getOid());
                clientesPremiosLH.merge(clientesPremiosL);
            } catch (PersistenceException ne) {
                UtilidadesLog.error("ERROR ", ne);
                throw new MareException(ne, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS));
            }
        }

        UtilidadesLog.info("MONPremiosConsuelo.guardarClientesPremioConsueloXnroConcurso(DTOOID DTOE, Long oidPremiosConsuelo):Salida");
    }

    private Long bigDecimalToLong(Object numero) {
        if (numero != null) {
            return new Long(((BigDecimal) numero).longValue());
        } else {
            return null;
        }
    }

    /**
    * @throws es.indra.mare.common.exception.MareException
    * @return
    * @param
    * @author Paola Cabrera
    * @fecha
    * Modificado: Cristian Valenzuela
    * Fecha: 23/08/2006
    * Incidencia: BELC300023493
    */
    public ArrayList guardarClientesPremioConsueloXFicheroSeleccionado(ArrayList DTOE, Long oidPremioConsuelo, Long oidPais)
            throws MareException {
        UtilidadesLog.info("MONPremiosConsuelo.guardarClientesPremioConsueloXFicheroSeleccionado" + 
        "(ArrayList DTOE, Long oidPremioConsuelo, Long oidPais):Entrada");
        UtilidadesLog.debug("Metodo guardarClientesPremioConsueloXFicheroSeleccionado con DTOE: " + 
                            DTOE + " y oidPremioConsuelo: " + oidPremioConsuelo 
                            + " y oid pais " + oidPais);

        ArrayList dtoSalArr = new ArrayList();
        DAOPremiosConsuelo dao = new DAOPremiosConsuelo();

        int vFinal = DTOE.size();
        UtilidadesLog.debug("vFinal " + vFinal);

        DTOPremConsueloFichero dtoPreConF = null;

        for (int i = 0; i < vFinal; i++) {
            Long oidConcurso = null;
            Long oidCliente = null;

            dtoPreConF = (DTOPremConsueloFichero) DTOE.get(i);
            UtilidadesLog.debug("***** dtoPreConF " + dtoPreConF);
            
            if (dtoPreConF.getCodCliente() == null) {
                UtilidadesLog.debug("Premios Consuelo: Nro. de Cliente con Formato inválido - " + 
                dtoPreConF.getCodCliente() + " - ");
                continue;
            }
            
            if (dtoPreConF.getNroConcurso() == null) {
                UtilidadesLog.debug("Premios Consuelo: Nro. de Concurso con Formato inválido - " + 
                dtoPreConF.getNroConcurso() + " - ");
                continue;
            }
            
            oidConcurso = dao.validarConcurso(dtoPreConF.getNroConcurso(), oidPais);
            UtilidadesLog.debug("********* oidConcurso " + oidConcurso);
            
            if(oidConcurso!=null) {
                try {
                    ClienteDatosBasicosLocalHome cdblh = this.getClienteDatosBasicosLocalHome();    
                    ClienteDatosBasicosLocal cdbl = cdblh.findByUK(dtoPreConF.getOidPais(),
                    dtoPreConF.getCodCliente());
                    
                    oidCliente = cdbl.getOid();
                    
                    //jrivas BLO-001 Se agrega la condicion de bloqueo.
                    DAOClientePremiacion daoCP = new DAOClientePremiacion();
                    if(oidCliente!=null && !daoCP.validarClienteBloqueado(oidCliente, oidPais)) {
                        dtoPreConF.setOidCliente(oidCliente);
                        dtoPreConF.setOidConcurso(oidConcurso);                        
                        dtoSalArr.add(dtoPreConF);
                     
                        ClientesPremiosConsueloLocal clientesPremiosL = null;

                        try {
                            ClientesPremiosConsueloLocalHome clientesPremiosLH =  this.getClientesPremiosConsueloLocalHome();
         
                            UtilidadesLog.debug("antes de clientesPremiosLH.create ");
                            UtilidadesLog.debug("oidCliente: " + oidCliente);
                            UtilidadesLog.debug("oidPremioConsuelo: " + oidPremioConsuelo);
                            
                            clientesPremiosL = clientesPremiosLH.create(oidCliente, oidPremioConsuelo);
                            clientesPremiosL.setCopaOidParaGral(oidConcurso);
                            UtilidadesLog.debug("despues de clientesPremiosLH.create ");                    
                        } catch (PersistenceException ne) {
                                UtilidadesLog.error("ERROR ", ne);
                                throw new MareException(ne, 
                                UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS));
                        }
                    
                    }
                    else  {
                        UtilidadesLog.debug("Premios Consuelo: Nro. de Cliente inexistente - " + 
                        dtoPreConF.getCodCliente() + " - ");                        
                    } 
                    
                } catch (NoResultException nre) {
                     UtilidadesLog.error("ERROR ", nre);  
                } catch (PersistenceException pe) {
                    ctx.setRollbackOnly();
                    UtilidadesLog.error("ERROR ", pe);
                    throw new MareException(pe,
                        UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS));
                }
            }
            else  {
                UtilidadesLog.debug("Premios Consuelo: Nro. de Concurso inexistente - " + 
                dtoPreConF.getNroConcurso() + " - ");                        
            }             

        }

        UtilidadesLog.debug("dtoSalArr: " + dtoSalArr);
        UtilidadesLog.info("MONPremiosConsuelo.guardarClientesPremioConsueloXFicheroSeleccionado(ArrayList DTOE, Long oidPremioConsuelo, Long oidPais):Salida");
        return dtoSalArr;
    }


    private MaestroProductosLocalHome getMaestroProductosLocalHome() throws NamingException
  {
    final InitialContext context = new InitialContext();
    return (MaestroProductosLocalHome)context.lookup("java:comp/env/MaestroProductos");
  }
  
    private ClienteDatosBasicosLocalHome getClienteDatosBasicosLocalHome() {
        return new ClienteDatosBasicosLocalHome();
      }
      
    private SeccionLocalHome getSeccionLocalHome() {
        return new SeccionLocalHome();
    }

    private TerritorioLocalHome getTerritorioLocalHome() {
           return new TerritorioLocalHome();
    }

    private ZonaLocalHome getZonaLocalHome() {
        return new ZonaLocalHome();
    }
    
    private Entidadi18nLocalHome getEntidadi18nLocalHome() {
        return new Entidadi18nLocalHome();
    }
    
    private PremioConsueloLocalHome getPremioConsueloLocalHome() {
            return new PremioConsueloLocalHome();
    }

    private ConcursoParametrosGeneralesLocalHome getConcursoParametrosGeneralesLocalHome() {
            return new ConcursoParametrosGeneralesLocalHome();
    }

    private ArticulosPremiosConsueloLocalHome getArticulosPremiosConsueloLocalHome() {
            return new ArticulosPremiosConsueloLocalHome();
    }

    private ClientesPremiosConsueloLocalHome getClientesPremiosConsueloLocalHome() {
            return new ClientesPremiosConsueloLocalHome();
    }

    private MensajesLocalHome getMensajesLocalHome() {
            return new MensajesLocalHome();
    }

    
    

 
}