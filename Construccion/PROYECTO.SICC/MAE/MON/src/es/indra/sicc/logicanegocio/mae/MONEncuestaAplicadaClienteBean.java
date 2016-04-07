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
 */
 
package es.indra.sicc.logicanegocio.mae;
import es.indra.mare.common.exception.MareException;
import es.indra.mare.common.mii.services.jdbcservice.RecordSet;
import es.indra.sicc.dtos.mae.DTOEncuestaAplicadaPorCliente;
import es.indra.sicc.entidades.mae.ClienteDatosBasicosLocal;
import es.indra.sicc.entidades.mae.ClienteDatosBasicosLocalHome;
import es.indra.sicc.entidades.mae.EncuestaAplicadaPorClienteLocal;
import es.indra.sicc.entidades.mae.EncuestaAplicadaPorClienteLocalHome;
import es.indra.sicc.entidades.mae.RespuestasEncuestaLocal;
import es.indra.sicc.entidades.mae.RespuestasEncuestaLocalHome;
import es.indra.sicc.logicanegocio.mae.DAOMAEParametrizacionMaestroClientes;
import es.indra.sicc.logicanegocio.seg.ConstantesSEG;
import es.indra.sicc.util.CodigosError;
import es.indra.sicc.util.DTOBelcorp;
import es.indra.sicc.util.DTOOID;
import es.indra.sicc.util.DTOOIDs;
import es.indra.sicc.util.DTOSalida;
import es.indra.sicc.util.UtilidadesError;
import es.indra.sicc.util.UtilidadesLog;
import javax.ejb.CreateException;
import javax.ejb.DuplicateKeyException;
import javax.ejb.FinderException;
import javax.ejb.RemoveException;
import javax.ejb.SessionBean;
import javax.ejb.SessionContext;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import javax.persistence.EntityExistsException;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceException;


/** 
 * Sistema:       Belcorp
 * Modulo:        MAE 
 * Componente:    MONEncuestaAplicadaClienteBean
 * 
 * @author Ezequiel Amores
 * @date 14/02/2006
 */
public class MONEncuestaAplicadaClienteBean implements SessionBean 
{
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
     * Se obtiene la/s pregunta/s con los datos del dto, se lo carga al dtoSalida y 
     * se retorna el dtoSalida.
     * @throws es.indra.mare.common.exception.MareException
     * @return DTOSalida
     * @param dto
     */
    public DTOSalida obtenerPreguntasEncuesta(DTOBelcorp dto) 
            throws MareException {
        UtilidadesLog.info("****Metodo MONEncuestaAplicadaClienteBean.obtenerPreguntasEncuesta: Entrada");
        DAOMAEParametrizacionMaestroClientes daoPMC = 
                new DAOMAEParametrizacionMaestroClientes();
        DTOSalida dtoSalida = daoPMC.obtenerPreguntasEncuesta(dto);
        UtilidadesLog.info("****Metodo MONEncuestaAplicadaClienteBean.obtenerPreguntasEncuesta: Salida");
        return dtoSalida;
    }
    
    /**
     * Se obtiene la/s respuesta/s con los datos del dto, se lo carga al dtoSalida y 
     * se retorna el dtoSalida.
     * @throws es.indra.mare.common.exception.MareException
     * @return 
     * @param dto
     */
    public DTOSalida obtenerRespuestasPorPregunta (DTOOID dto) 
            throws MareException {
        UtilidadesLog.info("****Metodo MONEncuestaAplicadaClienteBean.obtenerRespuestasPorPregunta: Entrada");
        DAOMAEParametrizacionMaestroClientes daoPMC = 
                new DAOMAEParametrizacionMaestroClientes();
        DTOSalida dtoSalida = daoPMC.obtenerRespuestasPorPregunta(dto);
        UtilidadesLog.info("****Metodo MONEncuestaAplicadaClienteBean.obtenerRespuestasPorPregunta: Salida");
        return dtoSalida;
    }
    
    /**
     * Si se ha seleccionado previamente una entidad EncuestaAplicadaPorCliente,
     * la actualiza y sino crea una nueva entidad EncuestaAplicadaPorCliente.
     * @throws es.indra.mare.common.exception.MareException
     * @param DTOE
     */
    public void actualizarEncuestaAplicadaCliente(DTOEncuestaAplicadaPorCliente DTOE) 
            throws MareException {
        UtilidadesLog.info("****Metodo MONEncuestaAplicadaClienteBean.actualizarEncuestaAplicadaCliente: Entrada");
        EncuestaAplicadaPorClienteLocalHome homeEAPC = null;
        EncuestaAplicadaPorClienteLocal localEAPC = null;
        ClienteDatosBasicosLocalHome homeCDB = null;
        ClienteDatosBasicosLocal localCDB = null;
        
        homeCDB = this.getClienteDatosBasicosLocalHome();
        
        if(DTOE.getOidCliente() != null) {
            try {
                localCDB = homeCDB.findByPrimaryKey(DTOE.getOidCliente());
            } catch (NoResultException nre) {
                ctx.setRollbackOnly();
                UtilidadesLog.error(nre);
                throw new MareException(nre, UtilidadesError.armarCodigoError(
                    CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE));
            } catch (PersistenceException pe) {
                ctx.setRollbackOnly();
                UtilidadesLog.error(pe);
                throw new MareException(pe, UtilidadesError.armarCodigoError(
                    CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS));
            }        
        } else { // El oidCliente es null (se ingreso el codigoCliente manual)
            try {
                localCDB = homeCDB.findByUK(DTOE.getOidPais(), DTOE.getCodigoCliente());
            } catch (NoResultException nre) {
                UtilidadesLog.debug("Excepcion - el oidCliente es null y findByUK no funciono - DTOE.getCodigoCliente() es:_" + DTOE.getCodigoCliente() + "_y el DTOE.getOidPais() es:_" + DTOE.getOidPais() );
                UtilidadesLog.error(nre);
                ctx.setRollbackOnly();
                throw new MareException(nre,
                    UtilidadesError.armarCodigoError(ConstantesSEG.MODULO_MAE, 
                        "", ErroresDeNegocio.MAE_0024));
            } catch (PersistenceException pe) {
                ctx.setRollbackOnly();
                UtilidadesLog.error(pe);
                throw new MareException(pe, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS));
            }
                   
            if(localCDB != null) { //se encontro un registro
                try {
                    localCDB = homeCDB.findByPrimaryKey(localCDB.getOid() );
                    DTOE.setOidCliente(localCDB.getOid());
                            
                } catch (NoResultException nre) {
                    UtilidadesLog.debug("Excepcion - se encontro un registro del cliente - localCDB.getOid() es: " + localCDB.getOid() );
                    UtilidadesLog.error(nre);
                    ctx.setRollbackOnly();
                    throw new MareException(nre,
                        UtilidadesError.armarCodigoError(
                            ConstantesSEG.MODULO_MAE, "", ErroresDeNegocio.MAE_0024));
                } catch (PersistenceException pe) {
                    ctx.setRollbackOnly();
                    UtilidadesLog.error(pe);
                    throw new MareException(pe, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS));
                }
            }
        }
        
        
        homeEAPC = this.getEncuestaAplicadaPorClienteLocalHome();
        
        if (DTOE.getOid() == null) { // Es una encuesta aplicada nueva
            try {
                /* Creamos un nuevo Entity con los datos del dto */
                localEAPC = homeEAPC.create(DTOE.getOidCliente(), DTOE.getOidRespuesta()); 
            } catch (EntityExistsException eee) {
                ctx.setRollbackOnly();
                UtilidadesLog.error(eee);
                throw new MareException(eee, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_CLAVE_DUPLICADA));
            } catch (PersistenceException pe) {
                ctx.setRollbackOnly();
                UtilidadesLog.error(pe);
                throw new MareException(pe, UtilidadesError.armarCodigoError(
                    CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS));
            }

        } else { // Es una encuesta a modificar
            try {
                localEAPC = homeEAPC.findByPrimaryKey(DTOE.getOid());
                localEAPC.setOidClie(DTOE.getOidCliente());
                localEAPC.setOidResp(DTOE.getOidRespuesta());    
                try {
                    homeEAPC.merge(localEAPC);
                } catch (PersistenceException pe) {
                    ctx.setRollbackOnly();
                    throw new MareException(pe, UtilidadesError.armarCodigoError(
                        CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS));
                }
            } catch (NoResultException nre) {
                ctx.setRollbackOnly();
                UtilidadesLog.error(nre);
                throw new MareException(nre, UtilidadesError.armarCodigoError(
                    CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE));
            } catch (PersistenceException pe) {
                ctx.setRollbackOnly();
                UtilidadesLog.error(pe);
                throw new MareException(pe, UtilidadesError.armarCodigoError(
                    CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS));
            }
        }
        
        UtilidadesLog.info("****Metodo MONEncuestaAplicadaClienteBean.actualizarEncuestaAplicadaCliente: Salida");
    }
    
    /**
     * Obtiene las entidades EncuestaAplicadasPorCliente que coincidan con los parámetros de la búsqueda.
     * @throws es.indra.mare.common.exception.MareException
     * @return 
     * @param DTOE
     */
    public DTOSalida buscarEncuestasAplicadasCliente(DTOEncuestaAplicadaPorCliente DTOE) 
            throws MareException {
        UtilidadesLog.info("****Metodo MONEncuestaAplicadaClienteBean.buscarEncuestasAplicadasCliente: Entrada");
        ClienteDatosBasicosLocalHome homeCDB = null;
        ClienteDatosBasicosLocal localCDB = null;
        
        homeCDB = this.getClienteDatosBasicosLocalHome();
                
        if(DTOE.getOidCliente() == null && DTOE.getCodigoCliente()!= null) {
            try {
                UtilidadesLog.debug("***DTOE.getOidPais():"+DTOE.getOidPais()+"  DTOE.getCodigoCliente(): "+DTOE.getCodigoCliente());
                localCDB = homeCDB.findByUK(DTOE.getOidPais(), DTOE.getCodigoCliente());
            } catch (NoResultException nre) {
                ctx.setRollbackOnly();
                UtilidadesLog.debug("***Salio por: NoResultException");  
                UtilidadesLog.error(nre);
                throw new MareException(nre,
                    UtilidadesError.armarCodigoError(ConstantesSEG.MODULO_MAE, 
                        "", ErroresDeNegocio.MAE_0024));
            } catch (PersistenceException pe) {
                ctx.setRollbackOnly();
                UtilidadesLog.debug("***Salio por: PersistenceException");  
                UtilidadesLog.error(pe);
                throw new MareException(pe,
                    UtilidadesError.armarCodigoError(ConstantesSEG.MODULO_MAE, 
                        "", ErroresDeNegocio.MAE_0024));
            } catch (Exception e) {
                ctx.setRollbackOnly();
                UtilidadesLog.debug("***Salio por: Exception");
                UtilidadesLog.error(e);
                throw new MareException(e,
                    UtilidadesError.armarCodigoError(ConstantesSEG.MODULO_MAE, 
                        "", ErroresDeNegocio.MAE_0024));
            }
            if(localCDB != null) { //se encontro un registro
                DTOE.setOidCliente(localCDB.getOid());
            }
        }
        
        DAOEncuestaAplicadaPorCliente daoEAPC = new DAOEncuestaAplicadaPorCliente();
        RecordSet recordset = new RecordSet();
        DTOSalida dtoSalida = new DTOSalida();
        recordset = daoEAPC.buscarEncuestasAplicadasPorCliente(DTOE);
        dtoSalida.setResultado(recordset);
        
        UtilidadesLog.info("****Metodo MONEncuestaAplicadaClienteBean.buscarEncuestasAplicadasCliente: Salida");
        return dtoSalida;
    }

    /**
     * Se recibe un DTOID con el oid de una encuesta aplicada por cliente.
     * Se carga un DTO con todos los datos de la Encuesta y lo devuelve.
     * @throws es.indra.mare.common.exception.MareException
     * @return DTOEncuestaAplicadaPorCliente
     * @param DTOE
     */
    public DTOEncuestaAplicadaPorCliente obtenerEncuestaAplicadaCliente(DTOOID DTOE) 
            throws MareException {
        UtilidadesLog.info("****Metodo MONEncuestaAplicadaClienteBean.obtenerEncuestaAplicadaCliente: Entrada");
        EncuestaAplicadaPorClienteLocalHome homeEAPC = null;
        EncuestaAplicadaPorClienteLocal localEAPC = null;
        ClienteDatosBasicosLocalHome homeCDB = null;
        ClienteDatosBasicosLocal localCDB = null;
        RespuestasEncuestaLocalHome homeRE = null;
        RespuestasEncuestaLocal localRE = null;
        
        homeEAPC = this.getEncuestaAplicadaPorClienteLocalHome();
        
        try {
            localEAPC = homeEAPC.findByPrimaryKey(DTOE.getOid());
        } catch (NoResultException nre) {
            ctx.setRollbackOnly();
            UtilidadesLog.error(nre);
            throw new MareException(nre, UtilidadesError.armarCodigoError(
                CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE));
        } catch (PersistenceException pe) {
            ctx.setRollbackOnly();
            UtilidadesLog.error(pe);
            throw new MareException(pe, UtilidadesError.armarCodigoError(
                CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS));
        }
        
        DTOEncuestaAplicadaPorCliente dtoEAPC = new DTOEncuestaAplicadaPorCliente();
        dtoEAPC.setOid(localEAPC.getOid());
        dtoEAPC.setOidCliente(localEAPC.getOidClie());
        dtoEAPC.setOidRespuesta(localEAPC.getOidResp());
        
        homeCDB = this.getClienteDatosBasicosLocalHome();
        
        try {
            localCDB = homeCDB.findByPrimaryKey(localEAPC.getOidClie());
        } catch (NoResultException e) {
            ctx.setRollbackOnly();
            UtilidadesLog.error(e);
            throw new MareException(e, UtilidadesError.armarCodigoError(
                CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE));
        } catch (PersistenceException e) {
            ctx.setRollbackOnly();
            UtilidadesLog.error(e);
            throw new MareException(e, UtilidadesError.armarCodigoError(
                CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS));
        }
        dtoEAPC.setCodigoCliente(localCDB.getCod_clie());
        
        homeRE = this.getRespuestasEncuestaLocalHome();
        
        try {
            localRE = homeRE.findByPrimaryKey(localEAPC.getOidResp());
        } catch (NoResultException e) {
            ctx.setRollbackOnly();
            UtilidadesLog.error(e);
            throw new MareException(e, UtilidadesError.armarCodigoError(
                CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE));
        } catch (PersistenceException e) {
            ctx.setRollbackOnly();
            UtilidadesLog.error(e);
            throw new MareException(e, UtilidadesError.armarCodigoError(
                CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS));
        }
        dtoEAPC.setOidPregunta(localRE.getOidPregunta());
        UtilidadesLog.info("****Metodo MONEncuestaAplicadaClienteBean.obtenerEncuestaAplicadaCliente: Salida");
        return dtoEAPC;
    }
    
    /**
     * Se eliminan las entidades EncuestaAplicadaPorCliente cuyos oids se reciben 
     * como parametros de entrada.
     * @throws MareException
     * @param dto
     */
    public void eliminarEncuestaAplicadaCliente(DTOOIDs dto) throws MareException {
        EncuestaAplicadaPorClienteLocalHome homeEAPC = null;
        EncuestaAplicadaPorClienteLocal localEAPC = null;
        
        homeEAPC = this.getEncuestaAplicadaPorClienteLocalHome();
        
        Long oids[] = dto.getOids();
        int cantOids = oids.length;        
        
        for(int i = 0; i < cantOids ; i++) {
            try {
                localEAPC = homeEAPC.findByPrimaryKey(oids[i]);
                try {
                    homeEAPC.remove(localEAPC);
                } catch (PersistenceException pe) {
                    ctx.setRollbackOnly();
                    throw new MareException(pe,UtilidadesError.armarCodigoError(
                        CodigosError.ERROR_DE_BORRADO_DE_DATOS));
                }
            } catch (NoResultException nre) {
                UtilidadesLog.error(nre);
                throw new MareException(nre,UtilidadesError.armarCodigoError(
                    CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE));
            } catch (PersistenceException pe) {
                UtilidadesLog.error(pe);
                throw new MareException(pe,UtilidadesError.armarCodigoError(
                    CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS));
            }
        }
    }
    
    /*------------------------------ Metodos LocalHome: Se obtiene la interfaz LocalHome de los EJB  -------------------------------------*/    
    private EncuestaAplicadaPorClienteLocalHome getEncuestaAplicadaPorClienteLocalHome() {
        return new EncuestaAplicadaPorClienteLocalHome();
    }
    
    private ClienteDatosBasicosLocalHome getClienteDatosBasicosLocalHome()  {
        return new ClienteDatosBasicosLocalHome();
    }
    
    private RespuestasEncuestaLocalHome getRespuestasEncuestaLocalHome() {
        return new RespuestasEncuestaLocalHome();
    }
    
}