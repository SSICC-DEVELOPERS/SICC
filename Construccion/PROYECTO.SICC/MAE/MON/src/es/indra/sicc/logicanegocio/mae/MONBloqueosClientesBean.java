/**
 * Copyright 2007 © por Indra Sistemas,S.A.. Todos los derechos reservados.
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
import es.indra.sicc.cmn.negocio.i18n.MONI18n;
import es.indra.sicc.cmn.negocio.i18n.MONI18nHome;
import es.indra.sicc.dtos.mae.DTOAccionesProcesosBloqueo;
import es.indra.sicc.dtos.mae.DTOBuscarAccionesProcesosBloqueo;
import es.indra.sicc.dtos.mae.DTOBuscarClienteBloqueo;
import es.indra.sicc.dtos.mae.DTOBuscarTiposBloqueoUsuario;
import es.indra.sicc.dtos.mae.DTOClienteBloqueo;
import es.indra.sicc.dtos.mae.DTOTipoBloqueo;
import es.indra.sicc.dtos.mae.DTOUsuariosBloqueo;
import es.indra.sicc.dtos.mae.DTOBuscarUsuariosBloqueo;
import es.indra.sicc.entidades.mae.AccionesProcesosBloqueoLocal;
import es.indra.sicc.entidades.mae.TipoBloqueoLocal;
import es.indra.sicc.entidades.mae.TipoBloqueoLocalHome;
import es.indra.sicc.logicanegocio.seg.ConstantesSEG;
import es.indra.sicc.util.CodigosError;
import es.indra.sicc.util.DTOBelcorp;
import es.indra.sicc.util.DTOOID;
import es.indra.sicc.util.DTOOIDs;
import es.indra.sicc.util.DTOSalida;
import es.indra.sicc.util.DTOString;
import es.indra.sicc.util.UtilidadesEJB;
import es.indra.sicc.util.UtilidadesError;
import es.indra.sicc.util.UtilidadesLog;

import java.rmi.RemoteException;

import javax.ejb.CreateException;
import javax.ejb.FinderException;
import javax.ejb.SessionBean;
import javax.ejb.SessionContext;
import es.indra.sicc.entidades.mae.AccionesProcesosBloqueoLocalHome;
import es.indra.sicc.entidades.mae.UsuariosBloqueoLocal;
import es.indra.sicc.entidades.mae.UsuariosBloqueoLocalHome;

import javax.persistence.EntityExistsException;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceException;


/**
 * Creado por cambio COL-BLO-001 (V4)
 * @author dmorello
 * @since 14-03-2008
 */
public class MONBloqueosClientesBean implements SessionBean {
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
     * @author dmorello
     * @since 12-10-2007
     */
    public DTOSalida obtenerValoresAccionesBloqueo() throws MareException {
        UtilidadesLog.info("MONBloqueosClientesBean.obtenerValoresAccionesBloqueo(): Entrada");
        RecordSet rs = new DAOBloqueosClientes().obtenerValoresAccionesBloqueo();
        UtilidadesLog.info("MONBloqueosClientesBean.obtenerValoresAccionesBloqueo(): Salida");
        return new DTOSalida(rs);
    }

    /**
     * @author dmorello
     * @since 12-10-2007
     */
    public DTOSalida obtenerMotivosRechazo() throws MareException{
        UtilidadesLog.info("MONBloqueosClientesBean.obtenerMotivosRechazo(): Entrada");
        RecordSet rs = new DAOBloqueosClientes().obtenerMotivosRechazo();
        UtilidadesLog.info("MONBloqueosClientesBean.obtenerMotivosRechazo(): Salida");
        return new DTOSalida(rs);
    }

    /**
     * Inserta/actualiza registros en la entidad TipoBloqueo
     * y las traducciones i18n de los mismos
     * @author dmorello
     * @since 12-10-2007
     */
    public void guardarTipoBloqueo(DTOTipoBloqueo dtoe) throws MareException {
        UtilidadesLog.info("MONBloqueosClientesBean.guardarTipoBloqueo(DTOTipoBloqueo dtoe): Entrada");
        UtilidadesLog.debug("dtoe: " + dtoe);
        
        DAOBloqueosClientes dao = new DAOBloqueosClientes();
        // Verifico si se repite el nivel de gravedad
        if (! dao.validarNivelGravedadSinRepetir(dtoe.getNivelGravedad(), dtoe.getOid()).booleanValue()) {
            // Lanzo mensaje de error
            throw new MareException("",
                UtilidadesError.armarCodigoError(ConstantesSEG.MODULO_MAE, "", ErroresDeNegocio.MAE_0040));
        }
        
        // Nivel gravedad OK, entonces paso a guardar
        TipoBloqueoLocalHome tipoHome = this.getTipoBloqueoLocalHome();
        TipoBloqueoLocal tipo = null;
        try {
            MONI18n i18n = this.getMONI18n();
            // Verifico si corresponde insertar o actualizar
            if (dtoe.getOid() == null) {
                
                // Hay que insertar... Inserto en la entidad TipoBloqueo
                /*
                 * (String cod_tipo_bloq, Integer ind_bloq_fina, Integer num_nive_grav_bloq,
                 * Long stmr_oid_moti_rech, Long maab_oid_valo_acci_bloq, Long maab_oid_valo_acci_desb)
                 */
                try {
                    tipo = tipoHome.create(dtoe.getCodigo(), null, dtoe.getNivelGravedad(),
                                           dtoe.getOidMotivoRechazo(), dtoe.getOidValorAccionBloqueo(),
                                           dtoe.getOidValorAccionDesbloqueo());
                    
                    if (dtoe.getIndBloqueoFinanciero() != null) {
                        boolean indBloqFina = dtoe.getIndBloqueoFinanciero().booleanValue();
                        if (indBloqFina)
                            tipo.setInd_bloq_fina(new Integer(1));
                        else
                            tipo.setInd_bloq_fina(new Integer(0));
                    }
                    tipoHome.merge(tipo);
                } catch (PersistenceException pe) {
                    ctx.setRollbackOnly();
                    String error = CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS;
                    throw new MareException(pe, UtilidadesError.armarCodigoError(error));
                }
                
                // Inserto traducciones
                i18n.insertarTraducciones("MAE_TIPO_BLOQU", tipo.getOid(), dtoe.getAttTraducible());
            } else {
                // Hay que actualizar... Actualizo en la entidad TipoBloqueo
                // No se actualiza el campo cod_tipo_bloq.
                tipo = tipoHome.findByPrimaryKey(dtoe.getOid());
                if (dtoe.getIndBloqueoFinanciero() != null) {
                    tipo.setInd_bloq_fina(new Integer(dtoe.getIndBloqueoFinanciero().booleanValue()? 1 : 0));
                } else {
                    tipo.setInd_bloq_fina(null);
                }
                tipo.setMaab_oid_valo_acci_bloq(dtoe.getOidValorAccionBloqueo());
                tipo.setMaab_oid_valo_acci_desb(dtoe.getOidValorAccionDesbloqueo());
                tipo.setNum_nive_grav_bloq(dtoe.getNivelGravedad());
                tipo.setStmr_oid_moti_rech(dtoe.getOidMotivoRechazo());
                
                tipoHome.merge(tipo);
                
                // Actualizo traducciones
                i18n.actualizaTraducciones("MAE_TIPO_BLOQU", tipo.getOid(), dtoe.getAttTraducible());
            }
        } catch (RemoteException e) {
            ctx.setRollbackOnly();
            String error = CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB;
            throw new MareException(e, UtilidadesError.armarCodigoError(error));
        } catch (NoResultException e) {
            ctx.setRollbackOnly();
            String error = CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE;
            throw new MareException(e, UtilidadesError.armarCodigoError(error));
        } catch (PersistenceException e) {
            ctx.setRollbackOnly();
            String error = CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS;
            throw new MareException(e, UtilidadesError.armarCodigoError(error));
        }
        UtilidadesLog.info("MONBloqueosClientesBean.guardarTipoBloqueo(DTOTipoBloqueo dtoe): Salida");
    }

    /**
     * @author dmorello
     * @since 12-10-2007
     */
    public DTOSalida consultarTiposBloqueo(DTOTipoBloqueo dtoe) throws MareException  {
        UtilidadesLog.info("MONBloqueosClientesBean.consultarTiposBloqueo(DTOTipoBloqueo dtoe): Entrada");
        RecordSet rs = new DAOBloqueosClientes().consultarTiposBloqueo(dtoe);
        UtilidadesLog.info("MONBloqueosClientesBean.consultarTiposBloqueo(DTOTipoBloqueo dtoe): Salida");
        return new DTOSalida(rs);
    }

    /**
     * Elimina registros de la entidad TipoBloqueo
     * asi como sus respectivas traducciones i18n
     * @author dmorello
     * @since 12-10-2007
     */
    public void eliminarTiposBloqueo(DTOOIDs dtoe) throws MareException {
        UtilidadesLog.info("MONBloqueosClientesBean.eliminarTiposBloqueo(DTOOIDs dtoe): Entrada");
        
        try {
            Long[] oids = dtoe.getOids();
            TipoBloqueoLocalHome tipoHome = this.getTipoBloqueoLocalHome();
            MONI18n i18n = this.getMONI18n();
            TipoBloqueoLocal tipo = null;
            
            // Voy eliminando los tipos de bloqueo uno a uno
            for (int i = 0; i < oids.length; i++) {
                // Borro el registro de la entidad
                tipo = tipoHome.findByPrimaryKey(oids[i]);
                try {
                    tipoHome.remove(tipo);
                } catch (PersistenceException e) {
                    ctx.setRollbackOnly();
                    String error = CodigosError.ERROR_DE_BORRADO_DE_DATOS;
                    throw new MareException(e, UtilidadesError.armarCodigoError(error));
                }
                
                // Borro las traducciones
                i18n.eliminarTraducciones("MAE_TIPO_BLOQU", oids[i]);
            }
        } catch (NoResultException nre) {
            ctx.setRollbackOnly();
            String error = CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE;
            throw new MareException(nre, UtilidadesError.armarCodigoError(error));
        } catch (PersistenceException pe) {
            ctx.setRollbackOnly();
            String error = CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS;
            throw new MareException(pe, UtilidadesError.armarCodigoError(error));
        } catch (RemoteException re) {
            ctx.setRollbackOnly();
            String error = CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB;
            throw new MareException(re, UtilidadesError.armarCodigoError(error));
        }
        UtilidadesLog.info("MONBloqueosClientesBean.eliminarTiposBloqueo(DTOOIDs dtoe): Salida");
    }

    /**
     * @author dmorello
     * @since 12-10-2007
     */
    public DTOSalida obtenerTiposBloqueo(DTOBelcorp dtoe) throws MareException {
        UtilidadesLog.info("MONBloqueosClientesBean.obtenerTiposBloqueo(DTOBelcorp dtoe): Entrada");
        RecordSet rs = new DAOBloqueosClientes().obtenerTiposBloqueo(dtoe);
        UtilidadesLog.info("MONBloqueosClientesBean.obtenerTiposBloqueo(DTOBelcorp dtoe): Salida");
        return new DTOSalida(rs);
    }

    /**
     * @author dmorello
     * @since 12-10-2007
     */
    public DTOSalida obtenerBloqueosFinancieros(DTOBelcorp dtoe) throws MareException {
        UtilidadesLog.info("MONBloqueosClientesBean.obtenerBloqueosFinancieros(): Entrada");
        RecordSet rs = new DAOBloqueosClientes().obtenerBloqueosFinancieros();
        UtilidadesLog.info("MONBloqueosClientesBean.obtenerBloqueosFinancieros(): Salida");
        return new DTOSalida(rs);
    }

    
    /**
     * Implementa la busqueda para la Lista Editable de Acciones-Procesos-Bloqueo.
     * Es consulta paginada, y el orden NO es por OID.
     * @author eiraola
     * @since 17/10/2007
     */
    public DTOSalida buscarAccionesProcesosBloqueo(DTOBuscarAccionesProcesosBloqueo dtoE) throws MareException {
        UtilidadesLog.info("MONBloqueosClientesBean.buscarAccionesProcesosBloqueo(dtoE): Entrada");
        UtilidadesLog.debug(" se recibieron los siguientes filtros " + dtoE);
        RecordSet rs = new DAOBloqueosClientes().buscarAccionesProcesosBloqueo(dtoE);
        UtilidadesLog.debug(" --- rs: " + rs);
        
        if (rs == null || rs.esVacio()) {
            UtilidadesLog.debug(" --- No existen datos");
            throw new MareException(null, null, UtilidadesError.armarCodigoError(
                    CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE));
        }
        UtilidadesLog.info("MONBloqueosClientesBean.buscarAccionesProcesosBloqueo(dtoE): Salida");
        return new DTOSalida(rs);
    }

    
     /**
     * Implementa el CU MAE-201 Insertar Acciones-Procesos-Bloqueo (solamente Insertar, 
     * no tiene Modificar pues todo dato es UK).
     * @author eiraola
     * @since 22/10/2007
     */
    public void guardarAccionesProcesosBloqueo(DTOAccionesProcesosBloqueo dtoE) throws MareException {
        UtilidadesLog.info("MONBloqueosClientesBean.guardarAccionesProcesosBloqueo(dtoE): Entrada");
        UtilidadesLog.debug(" --- datos recibidos para insercion " + dtoE);
        
        AccionesProcesosBloqueoLocalHome apbLocalHome = this.getAccionesProcesosBloqueoLocalHome();
        
        try {
            apbLocalHome.create(dtoE.getOidTipoBloqueo(), dtoE.getOidProcesoBloqueo(), 
                                dtoE.getOidAccionBloqueo(), dtoE.getOidPais());
        } catch (EntityExistsException eee) {
            ctx.setRollbackOnly();
            UtilidadesLog.error(" no se pudo insertar en Entidad AccionesProcesosBloqueo - EntityExistsException: " 
                                + eee.getMessage());
            throw new MareException(eee, UtilidadesError.armarCodigoError(
                    CodigosError.ERROR_INTEGRIDAD_INSERCION));
        } catch (PersistenceException pe) {
            ctx.setRollbackOnly();
            UtilidadesLog.error(" no se pudo insertar en Entidad AccionesProcesosBloqueo - PersistenceException: " 
                                + pe.getMessage());
            throw new MareException(pe, UtilidadesError.armarCodigoError(
                    CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS));
        }
        UtilidadesLog.info("MONBloqueosClientesBean.guardarAccionesProcesosBloqueo(dtoE): Salida");
    }
        
    
    /**
     * Implementa el CU MAE-203	Eliminar Acciones-Procesos-Bloqueo.
     * @author eiraola
     * @since 23/10/2007
     */
    public void eliminarAccionesProcesosBloqueo(DTOOIDs dtoE) throws MareException {
        UtilidadesLog.info("MONBloqueosClientesBean.eliminarAccionesProcesosBloqueo(dtoOids): Entrada");
        
        AccionesProcesosBloqueoLocalHome apbLocalHome = this.getAccionesProcesosBloqueoLocalHome();
        AccionesProcesosBloqueoLocal apbLocal = null;
        
        Long oids[] = dtoE.getOids();
        int cantOids = oids.length;
        
        for (int i = 0; i < cantOids; i++) {
            try {
                apbLocal = apbLocalHome.findByPrimaryKey(oids[i]);
                try {
                    apbLocalHome.remove(apbLocal);
                } catch (PersistenceException pe) {
                    ctx.setRollbackOnly();
                    UtilidadesLog.error("PersistenceException al borrar: 'AccionesProcesosBloqueo' " + pe.getMessage());
                    throw new MareException(pe, UtilidadesError.armarCodigoError(
                        CodigosError.ERROR_DE_BORRADO_DE_DATOS));
                }
            } catch (NoResultException nre) {
                ctx.setRollbackOnly();
                UtilidadesLog.error("NoResultException: 'AccionesProcesosBloqueo' " + nre.getMessage());
                throw new MareException(nre, UtilidadesError.armarCodigoError(
                    CodigosError.ERROR_ELIMINAR_NO_EXISTE));
            } catch (PersistenceException pe) {
                ctx.setRollbackOnly();
                UtilidadesLog.error("PersistenceException: 'AccionesProcesosBloqueo' " + pe);
                throw new MareException(pe, UtilidadesError.armarCodigoError(
                    CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS));
            }
        }
        UtilidadesLog.info("MONBloqueosClientesBean.eliminarAccionesProcesosBloqueo(dtoOids): Salida");
    }
    
     /**
     * Consulta para combo de 'Procesos bloqueo'.
     * @author eiraola
     * @since 17/10/2007
     */
    public DTOSalida obtenerProcesosBloqueo(DTOBelcorp dtoE) throws MareException {
        UtilidadesLog.info("MONBloqueosClientesBean.obtenerProcesosBloqueo(dtoE): Entrada");
        RecordSet rs = new DAOBloqueosClientes().obtenerProcesosBloqueo(dtoE);
        UtilidadesLog.info("MONBloqueosClientesBean.obtenerProcesosBloqueo(dtoE): Salida");
        return new DTOSalida(rs);
    }
    
    /**
     * Consulta para combo de 'Acciones bloqueo'.
     * @author eiraola
     * @since 17/10/2007
     */
    public DTOSalida obtenerAccionesBloqueo(DTOOID dtoE) throws MareException {
        UtilidadesLog.info("MONBloqueosClientesBean.obtenerAccionesBloqueo(dtoOid): Entrada");
        RecordSet rs = new DAOBloqueosClientes().obtenerAccionesBloqueo(dtoE);
        UtilidadesLog.info("MONBloqueosClientesBean.obtenerAccionesBloqueo(dtoOid): Salida");
        return new DTOSalida(rs);
    }
    
    /**
     * Recupera OID, descripcion i18n e indicador de DNI para los tipos de
     * documentos (MAE) asociados al país recibido por parametro.
     * @author dmorello
     * @since 05-11-2007
     */
    public DTOSalida obtenerTiposDocumentoPais(DTOBelcorp dtoe) throws MareException {
        UtilidadesLog.info("MONBloqueosClientesBean.obtenerTiposDocumentoPais(DTOBelcorp dtoe): Entrada");
        RecordSet rs = new DAOBloqueosClientes().obtenerTiposDocumentoPais(dtoe);
        UtilidadesLog.info("MONBloqueosClientesBean.obtenerTiposDocumentoPais(DTOBelcorp dtoe): Salida");
        return new DTOSalida(rs);
    }

    /**
     * Recupera información sobre los bloqueos existentes para los clientes
     * recuperados según los filtros del parámetro de entrada.
     * @throws MareException Si no encuentra clientes para los filtros recibidos
     * @author dmorello
     * @since 05-11-2007
     */
    public DTOSalida buscarBloqueosClientes(DTOBuscarClienteBloqueo dtoe) throws MareException {
        UtilidadesLog.info("MONBloqueosClientesBean.buscarBloqueosClientes(DTOBuscarClienteBloqueo dtoe): Entrada");
        RecordSet rs = new DAOBloqueosClientes().buscarBloqueosClientes(dtoe);
        UtilidadesLog.info("MONBloqueosClientesBean.buscarBloqueosClientes(DTOBuscarClienteBloqueo dtoe): Salida");
        return new DTOSalida(rs);
    }

    /**
     * Consulta sobre entidad 'MAE Valores Usuario Bloqueo' para combo de 'Accion permitida'.
     * @author eiraola
     * @since 08/11/2007
     */
    public DTOSalida obtenerValoresUsuarioBloqueo(DTOBelcorp dtoE) throws MareException {
        UtilidadesLog.info("MONBloqueosClientesBean.obtenerValoresUsuarioBloqueo(dtoE): Entrada");
        RecordSet rs = new DAOBloqueosClientes().obtenerValoresUsuarioBloqueo(dtoE);
        UtilidadesLog.info("MONBloqueosClientesBean.obtenerValoresUsuarioBloqueo(dtoE): Salida");
        return new DTOSalida(rs);
    }
    
    /**
     * Implementa los CU MAE-205 Insertar Usuarios-Bloqueo y MAE-206 Modificar Usuarios-Bloqueo
     * @author eiraola
     * @since 08/11/2007
     */
    public void guardarUsuariosBloqueo(DTOUsuariosBloqueo dtoE) throws MareException {
        UtilidadesLog.info("MONBloqueosClientesBean.guardarUsuariosBloqueo(dtoE): Entrada");
        UtilidadesLog.debug(" --- datos recibidos " + dtoE);
        
        UsuariosBloqueoLocalHome ubLocalHome = this.getUsuariosBloqueoLocalHome();
        
        if (dtoE.getOid() == null) { // INSERCION
            try {
                ubLocalHome.create(dtoE.getIdUser(), dtoE.getOidTipoBloqueo(), dtoE.getOidAccionPermitida(), 
                        dtoE.getOidPais());
            } catch (EntityExistsException eee) {
                ctx.setRollbackOnly();
                UtilidadesLog.error(" no se pudo insertar en Entidad UsuariosBloqueo - EntityExistsException: " 
                                    + eee.getMessage());
                throw new MareException(eee, UtilidadesError.armarCodigoError(
                        CodigosError.ERROR_INTEGRIDAD_INSERCION));
            } catch (PersistenceException pe) {
                ctx.setRollbackOnly();
                UtilidadesLog.error(" no se pudo insertar en Entidad UsuariosBloqueo - PersistenceException: " 
                                    + pe.getMessage());
                throw new MareException(pe, UtilidadesError.armarCodigoError(
                        CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS));
            }
            
        } else { // MODIFICACION
            try {
                UsuariosBloqueoLocal ubLocal = ubLocalHome.findByPrimaryKey(dtoE.getOid());
                ubLocal.setOidAccionPermitida(dtoE.getOidAccionPermitida());
                ubLocalHome.merge(ubLocal);
            } catch (NoResultException nre) {
                ctx.setRollbackOnly();
                UtilidadesLog.error(" no se encontro el registro en Entidad UsuariosBloqueo - FinderException: " 
                                    + nre.getMessage());
                throw new MareException(nre, UtilidadesError.armarCodigoError(
                        CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE));
            } catch (PersistenceException pe) {
                ctx.setRollbackOnly();
                UtilidadesLog.error(" no se pudo modificar registro en Entidad UsuariosBloqueo - PersistenceException: " 
                                    + pe.getMessage());
                throw new MareException(pe, UtilidadesError.armarCodigoError(
                        CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS));
            }
        }
        UtilidadesLog.info("MONBloqueosClientesBean.guardarUsuariosBloqueo(dtoE): Salida");
    }
    
    /**
     * Implementa el CU MAE-208	Eliminar Usuarios-Bloqueo.
     * @author eiraola
     * @since 08/11/2007
     */
    public void eliminarUsuariosBloqueo(DTOOIDs dtoE) throws MareException {
        UtilidadesLog.info("MONBloqueosClientesBean.eliminarUsuariosBloqueo(dtoOids): Entrada");
        
        UsuariosBloqueoLocalHome ubLocalHome = this.getUsuariosBloqueoLocalHome();
        UsuariosBloqueoLocal ubLocal = null;
        
        Long oids[] = dtoE.getOids();
        int cantOids = oids.length;
        
        for (int i = 0; i < cantOids; i++) {
            try {
                ubLocal = ubLocalHome.findByPrimaryKey(oids[i]);
                try {
                    ubLocalHome.remove(ubLocal);
                } catch (PersistenceException pe) {
                    ctx.setRollbackOnly();
                    UtilidadesLog.error("PersistenceException al borrar: 'UsuariosBloqueo' " + pe);
                    throw new MareException(pe, UtilidadesError.armarCodigoError(
                        CodigosError.ERROR_DE_BORRADO_DE_DATOS));
                }
            } catch (NoResultException nre) {
                ctx.setRollbackOnly();
                UtilidadesLog.error("NoResultException: 'UsuariosBloqueo' " + nre.getMessage());
                throw new MareException(nre, UtilidadesError.armarCodigoError(
                    CodigosError.ERROR_ELIMINAR_NO_EXISTE));
            } catch (PersistenceException pe) {
                ctx.setRollbackOnly();
                UtilidadesLog.error("PersistenceException: 'UsuariosBloqueo' " + pe);
                throw new MareException(pe, UtilidadesError.armarCodigoError(
                    CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS));
            }
        }
        UtilidadesLog.info("MONBloqueosClientesBean.eliminarUsuariosBloqueo(dtoOids): Salida");
    }
    
     /**
     * Implementa la busqueda para la Lista Editable de Usuarios-Bloqueo.
     * Es consulta paginada, y el orden NO es por OID.
     * @author eiraola
     * @since 08/11/2007
     */
    public DTOSalida buscarUsuariosBloqueo(DTOBuscarUsuariosBloqueo dtoE) throws MareException {
        UtilidadesLog.info("MONBloqueosClientesBean.buscarUsuariosBloqueo(dtoE): Entrada");
        UtilidadesLog.debug(" se recibieron los siguientes filtros " + dtoE);
        RecordSet rs = new DAOBloqueosClientes().buscarUsuariosBloqueo(dtoE);
        UtilidadesLog.debug(" --- rs: " + rs);
        
        if (rs == null || rs.esVacio()) {
            UtilidadesLog.debug(" --- No existen datos");
            throw new MareException(null, null, UtilidadesError.armarCodigoError(
                    CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE));
        }
        UtilidadesLog.info("MONBloqueosClientesBean.buscarUsuariosBloqueo(dtoE): Salida");
        return new DTOSalida(rs);
    }

    /**
     * Recupera OID y descripcion i18n de todos los tipos de bloqueo para los
     * cuales el usuario del DTO de entrada cuenta con permiso para bloquear.
     * @author dmorello
     * @since 11-12-2007
     */
    public DTOSalida obtenerTiposBloqueoUsuario(DTOString dtoe) throws MareException  {
        UtilidadesLog.info("MONBloqueosClientesBean.obtenerTiposBloqueoUsuario(DTOString dtoe): Entrada");
        RecordSet rs = new DAOBloqueosClientes().obtenerTiposBloqueoUsuario(dtoe);
        UtilidadesLog.info("MONBloqueosClientesBean.obtenerTiposBloqueoUsuario(DTOString dtoe): Salida");
        return new DTOSalida(rs);
    }
  
    /**
     * Inserta o actualiza un registro en MAE_CLIEN_BLOQU de acuerdo al DTO de
     * entrada.
     * @author dmorello
     * @since 11-12-2007
     */
    public void guardarBloqueo(DTOClienteBloqueo dtoe) throws MareException {
        UtilidadesLog.info("MONBloqueosClientesBean.guardarBloqueo(DTOClienteBloqueo dtoe): Entrada");
        UtilidadesLog.debug("dtoe: " + dtoe);
        DAOBloqueosClientes dao = new DAOBloqueosClientes();
        if (dtoe.getOid() == null) {
            // Es un nuevo bloqueo -> inserto
            dao.insertarBloqueo(dtoe);
        } else {
            // Verifico si es un desbloqueo o una modificacion de bloqueo
            if (Boolean.TRUE.equals(dtoe.getIndDesbloqueo())) {
                UtilidadesLog.debug("Voy a desbloquear el cliente");
                
                // Procedo a actualizar el bloqueo directamente
                dao.actualizarBloqueo(dtoe);
                
            } else {
                UtilidadesLog.debug("Voy a modificar el bloqueo del cliente");
                
                // Verifico que el nuevo tipo de bloqueo sea más grave que el actual
                Long oidBloq = dtoe.getOid();
                Long oidNuevoTipoBloq = dtoe.getOidTipoBloqueo();
                boolean nuevoTipoBloqueoEsMasGrave = dao.validarMayorGravedadNuevoTipoBloqueo(oidBloq, oidNuevoTipoBloq);
                
                if (nuevoTipoBloqueoEsMasGrave) {
                    dao.actualizarBloqueo(dtoe);
                } else {
                    throw new MareException("",
                        UtilidadesError.armarCodigoError(ConstantesSEG.MODULO_MAE, "", ErroresDeNegocio.MAE_0041));
                }
            }
        
            
        }
        UtilidadesLog.info("MONBloqueosClientesBean.guardarBloqueo(DTOClienteBloqueo dtoe): Salida");
    }

    /**
     * Recupera el histórico de bloqueos (conjunto de registros de MAE_CLIEN_BLOQU)
     * para el cliente cuyo OID se recibe por parámetro.
     * @throws MareException Si no encuentra registros para el cliente recibido
     * @author dmorello
     * @since 13/12/2007
     */
    public DTOSalida consultarHistoricoBloqueosCliente(DTOOID dtoe) throws MareException  {
        UtilidadesLog.info("MONBloqueosClientesBean.consultarHistoricoBloqueosCliente(DTOOID dtoe): Entrada");
        RecordSet rs = new DAOBloqueosClientes().consultarHistoricoBloqueosCliente(dtoe);
        UtilidadesLog.info("MONBloqueosClientesBean.consultarHistoricoBloqueosCliente(DTOOID dtoe): Salida");
        return new DTOSalida(rs);
    }
    
    /**
     * Devuelve los OIDs de todos los tipos de bloqueo si dtoe.oidTipoBloqueo
     * es null, caso contrario devuelve el OID del tipo de bloqueo hallado
     * Para cada uno, devuelve un indicador de forma de bloqueo manual ['S'|'N']
     * y un indicador de forma de desbloqueo manual.
     * Devuelve otros dos indicadores ['S'|'N'], uno dice si el usuario recibido
     * en el dtoe tiene permiso para bloquear con cada tipo de bloqueo, y otro
     * si tiene permiso para desbloquear a clientes con cada tipo de bloqueo.
     * 
     * @author dmorello
     * @since 04-01-2008
     */
    public DTOSalida obtenerTiposBloqueosUsuarioPermisos(DTOBuscarTiposBloqueoUsuario dtoe) throws MareException {
        UtilidadesLog.info("MONBloqueosClientesBean.obtenerTiposBloqueosUsuarioPermisos(DTOBuscarTiposBloqueoUsuario dtoe): Entrada");
        RecordSet rs = new DAOBloqueosClientes().obtenerTiposBloqueosUsuarioPermisos(dtoe);
        UtilidadesLog.info("MONBloqueosClientesBean.obtenerTiposBloqueosUsuarioPermisos(DTOBuscarTiposBloqueoUsuario dtoe): Salida");
        return new DTOSalida(rs);
    }

    private MONI18n getMONI18n() throws MareException, RemoteException {
        try {
            return this.getMONI18nHome().create();
        } catch (CreateException e) {
            String error = CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB;
            throw new MareException(e, UtilidadesError.armarCodigoError(error));
        }
    }

    private TipoBloqueoLocalHome getTipoBloqueoLocalHome() throws MareException {
        return new TipoBloqueoLocalHome();
    }

    private MONI18nHome getMONI18nHome() throws MareException {
        UtilidadesLog.info("MONBloqueosClientesBean.getMONI18nHome(): Entrada");
        Object home = UtilidadesEJB.getHome("java:comp/env/MONI18n", MONI18nHome.class);
        UtilidadesLog.info("MONBloqueosClientesBean.getMONI18nHome(): Salida");
        return (MONI18nHome)home;
    }

    private AccionesProcesosBloqueoLocalHome getAccionesProcesosBloqueoLocalHome() {
        return new AccionesProcesosBloqueoLocalHome();
    }
    
        
    private UsuariosBloqueoLocalHome getUsuariosBloqueoLocalHome() {
        return new UsuariosBloqueoLocalHome();
    }
    

}