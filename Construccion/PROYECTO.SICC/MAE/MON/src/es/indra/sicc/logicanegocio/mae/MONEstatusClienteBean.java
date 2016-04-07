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
import es.indra.mare.common.mgc.MareMGC;
import es.indra.mare.common.mii.MareMii;
import es.indra.mare.common.mii.MareTopic;
import es.indra.mare.common.mii.services.jdbcservice.RecordSet;
import es.indra.mare.common.mln.MareBusinessID;
import es.indra.mare.enterprise.mln.BusinessFacadeLocalHome;
import es.indra.sicc.cmn.negocio.auditoria.DTOAuditableSICC;
import es.indra.sicc.cmn.negocio.batch.DTOBatch;
import es.indra.sicc.cmn.negocio.batch.DTOSalidaBatch;
import es.indra.sicc.cmn.negocio.batch.MONBatchEJBLocalHome;
import es.indra.sicc.cmn.negocio.batch.util.BatchUtil;
import es.indra.sicc.dtos.fac.DTOFACCierreFacturacion;
import es.indra.sicc.dtos.fac.DTOFACProcesoCierre;
import es.indra.sicc.dtos.mae.DTOCierreRegion;
import es.indra.sicc.dtos.mae.DTOClienteEvaluarEstado;
import es.indra.sicc.dtos.mae.DTOEstados;
import es.indra.sicc.dtos.mae.DTORangoClientesEvaluarEstado;
import es.indra.sicc.entidades.cra.PeriodoLocal;
import es.indra.sicc.entidades.cra.PeriodoLocalHome;
import es.indra.sicc.entidades.fac.TiposCierreLocal;
import es.indra.sicc.entidades.fac.TiposCierreLocalHome;
import es.indra.sicc.entidades.mae.ClienteBloqueoLocal;
import es.indra.sicc.entidades.mae.ClienteBloqueoLocalHome;
import es.indra.sicc.entidades.mae.ClienteDatosAdicionalesLocal;
import es.indra.sicc.entidades.mae.ClienteDatosAdicionalesLocalHome;
import es.indra.sicc.entidades.mae.ClienteHistoricoEstatusLocal;
import es.indra.sicc.entidades.mae.ClienteHistoricoEstatusLocalHome;
import es.indra.sicc.entidades.mae.EstatusClienteLocal;
import es.indra.sicc.entidades.mae.EstatusClienteLocalHome;
import es.indra.sicc.entidades.mae.HistoricoClasificacionLocalHome;
import es.indra.sicc.entidades.mae.TipoBloqueoLocal;
import es.indra.sicc.entidades.mae.TipoBloqueoLocalHome;
import es.indra.sicc.entidades.mae.TipoClienteLocal;
import es.indra.sicc.entidades.mae.TipoClienteLocalHome;
import es.indra.sicc.logicanegocio.cra.DAOCRA;
import es.indra.sicc.logicanegocio.fac.ConstantesFAC;
import es.indra.sicc.logicanegocio.fac.DAOFACCierreFacturacion;
import es.indra.sicc.logicanegocio.mae.DAOMAEEstatusCliente;
import es.indra.sicc.logicanegocio.mae.ErroresDeNegocio;
import es.indra.sicc.logicanegocio.ped.MONPedidosSolicitud;
import es.indra.sicc.logicanegocio.ped.MONPedidosSolicitudHome;
import es.indra.sicc.logicanegocio.seg.ConstantesSEG;
import es.indra.sicc.util.BelcorpService;
import es.indra.sicc.util.CodigosError;
import es.indra.sicc.util.DTOBelcorp;
import es.indra.sicc.util.DTOOIDs;
import es.indra.sicc.util.DTOSalida;
import es.indra.sicc.util.PEDEjbLocators;
import es.indra.sicc.util.SecuenciadorOID;
import es.indra.sicc.util.UtilidadesEJB;
import es.indra.sicc.util.UtilidadesError;
import es.indra.sicc.util.UtilidadesLog;

import java.math.BigDecimal;

import java.rmi.*;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Enumeration;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.Vector;

import javax.ejb.CreateException;
import javax.ejb.FinderException;
import javax.ejb.SessionBean;
import javax.ejb.SessionContext;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import es.indra.sicc.dtos.cra.DTOPeriodo;

import javax.persistence.NoResultException;
import javax.persistence.PersistenceException;

/*
 * rgiorgi - 19/8/2005: se formatea la clase.
 * */
public class MONEstatusClienteBean implements SessionBean {
    SessionContext sessionContext = null;
    private UtilidadesLog log = new UtilidadesLog();
    
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

    public String asignarEstatusInicial(ClienteDatosAdicionalesLocal clienteDatosAdicionales, Long periodoActual, ArrayList tiposClientes, DTOAuditableSICC dtoAudi) throws MareException {
        UtilidadesLog.info("MONEstatusCliente.asignarEstatusInicial(ClienteDatosAdicionalesLocal, periodoActual, ArrayList tiposClientes, DTOAuditableSICC): Entrada"); 
        // Método que asigna un estatus al cliente indicado. Recibe el entityBean ClienteDatosAdicionales del cliente que queremos 
        // asignar el estado inicial, además del tipo de estatus de cliente y el periodo actual. 
        // Hacemos un findByPrimaryKey en el entitybean TipoCliente.
        //UtilidadesLog.debug(" asignarEstatusInicial paso inicial");
        TipoClienteLocal tipocliente = null;
        TipoClienteLocalHome tipoclienteHome;
        DAOMAEEstatusCliente daoMAEEstatusCliente = new DAOMAEEstatusCliente(sessionContext.getCallerPrincipal().getName());
        RecordSet verificaHistoricoEstatus = null;

        try {
            // vbongiv -- 17/01/2008 -- Cambio SiCC20070461 MAE
            if(!daoMAEEstatusCliente.validarIndEvaluarEstatus(tiposClientes).esVacio()) {
            
                verificaHistoricoEstatus = daoMAEEstatusCliente.verificaHistoricoEstatus(clienteDatosAdicionales.getClie_oid_clie());
                
                UtilidadesLog.debug("clienteDatosAdicionales.getEsta_oid_esta_clie(): " + clienteDatosAdicionales.getEsta_oid_esta_clie());
            
                if(verificaHistoricoEstatus.esVacio() && clienteDatosAdicionales.getEsta_oid_esta_clie()==null){
                
                    UtilidadesLog.debug("no tiene estado ni historico");
                    
                    // Hacemos un findByCodigo en el home de la entidad EstatusClientes con el código "01" como 
                    // parametro (estatus Registrado). CAMBIADO "01" * ConstantesMAE.ESTATUS_REGISTRADO
                    EstatusClienteLocalHome estatusHome = new EstatusClienteLocalHome();
    
                    EstatusClienteLocal estatus = estatusHome.findByCodigo(ConstantesMAE.ESTATUS_REGISTRADO); // Tiene que haber datos en la tabla estatus home
    
                    //UtilidadesLog.debug(" asignarEstatusInicial paso 2");
                    // 		clienteDatosAdicionales.estatus = le asignamos el oid del entity que acabamos de recuperar 
                    clienteDatosAdicionales.setEsta_oid_esta_clie(estatus.getOid());
    
                    // 		clienteDatosAdicionales.numCampanyasSinPedido = 0 
                    clienteDatosAdicionales.setNum_camp_sin_pedi(new Long(0));
    
                    // 		Llamamos al método guardarHistoricoEstatus de este MON pasandole: 
                    // 		estado = oid de estado recuperado anteriormente 
                    //		-periodoNuevo = el parametro recibido 
                    //		-cliente = el atributo cliente del entity ClienteDatosBasicos 
                    this.guardarHistoricoEstatus(estatus.getOid(), periodoActual, clienteDatosAdicionales.getClie_oid_clie(), dtoAudi);
                    
                    try {
                        new ClienteDatosAdicionalesLocalHome().merge(clienteDatosAdicionales);
                    } catch (PersistenceException pe) {
                        sessionContext.setRollbackOnly();
                        throw new MareException(pe, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS));
                    }
                   
                } else if((verificaHistoricoEstatus.esVacio() && clienteDatosAdicionales.getEsta_oid_esta_clie()!=null) ||
                          (!verificaHistoricoEstatus.esVacio() && clienteDatosAdicionales.getEsta_oid_esta_clie()==null)){
                          
                    UtilidadesLog.debug("tiene estado o historico");
                          
                    UtilidadesLog.info("MONEstatusCliente.asignarEstatusInicial(ClienteDatosAdicionalesLocal, periodoActual, ArrayList tiposClientes, DTOAuditableSICC): Salida"); 
                    return ErroresDeNegocio.PROBLEMAS_ESTATUS;
                          
                }
            }
            
        } catch (NoResultException nre) {
            sessionContext.setRollbackOnly();
            throw new MareException(nre, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE));
        } catch (PersistenceException pe) {
            sessionContext.setRollbackOnly();
            throw new MareException(pe, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS));
        } catch (Exception ex) {
            UtilidadesLog.error("ERROR ", ex);
            ex.printStackTrace();
            throw new MareException(ex);
        } 
        
        UtilidadesLog.info("MONEstatusCliente.asignarEstatusInicial(ClienteDatosAdicionalesLocal, periodoActual, ArrayList tiposClientes, DTOAuditableSICC): Salida"); 
        return null;
    }

    private void guardarHistoricoEstatus(Long estado, Long periodoNuevo, Long cliente, DTOAuditableSICC dtoAudi) throws MareException {
        
            UtilidadesLog.info("MONEstatusCliente.guardarHistoricoEstatus(estado, periodoNuevo, cliente, , DTOAuditableSICC): Entrada"); 
            
            
            ClienteHistoricoEstatusLocalHome clienteEstatusHome = new ClienteHistoricoEstatusLocalHome();
            ClienteHistoricoEstatusLocal clienteEstatus = null;
            PeriodoLocalHome periodoLocalHome = new PeriodoLocalHome();
            PeriodoLocal pInicio = null;
            PeriodoLocal pNuevo = null;
            
            DAOMAEEstatusCliente daoEstaClien = new DAOMAEEstatusCliente(sessionContext.getCallerPrincipal().getName());
            Long oidRetornado = daoEstaClien.obtenerUltimoHistorico(cliente, periodoNuevo, estado);
            DAOCRA daoCra = new DAOCRA();
            
            if(oidRetornado==null) {
                // No hay registro de historico previo
                UtilidadesLog.debug("*** 1.-");
                try {
                    UtilidadesLog.debug("*** Create con cliente: "+cliente+" estado: "+ estado+" periodoNuevo: "+ periodoNuevo);
                    ClienteHistoricoEstatusLocal clienteHistEstat = clienteEstatusHome.create(cliente, estado, periodoNuevo, null);
                    UtilidadesLog.debug("clienteHistEstat.getOid(): " + clienteHistEstat.getOid());
                    Long[] clasificaciones = (new DAOMAEMaestroClientes(sessionContext.getCallerPrincipal().getName())).obtenerClasificacionesCliente(cliente);
                        
                    UtilidadesLog.debug("  guardarHistoricoEstatus paso 3");
    
                    HistoricoClasificacionLocalHome historicoHome = new HistoricoClasificacionLocalHome();
    
                    for (int u = 0; u < clasificaciones.length; u++) {
                        UtilidadesLog.debug("clasificaciones[u]: " + clasificaciones[u]);
                        UtilidadesLog.debug("clienteHistorico.getOid(): " + clienteHistEstat.getOid());
    
                        historicoHome.create(clienteHistEstat.getOid(), clasificaciones[u]);
                    }
                    
                    
                } catch (PersistenceException pe){
                    UtilidadesLog.error(pe);
                    sessionContext.setRollbackOnly();
                    throw new MareException(pe, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS));
                }
                
                
            } else {
                // Se encontro registro de historico previo
                UtilidadesLog.debug("*** 2.- ");
                try {
                    clienteEstatus = clienteEstatusHome.findByPrimaryKey(oidRetornado);
                    
                    Long periodoAnterior = daoCra.obtienePeriodoAnteriorActual(periodoNuevo);
                    
                    Long perInicio = clienteEstatus.getPerd_oid_peri();
                    pInicio = periodoLocalHome.findByPrimaryKey(perInicio);
                    pNuevo = periodoLocalHome.findByPrimaryKey(periodoNuevo);
                    
                    if(perInicio!=null && perInicio.longValue()==periodoNuevo.longValue()){
                    UtilidadesLog.debug("*** 3.-");
                       clienteEstatus.setEsta_oid_esta_clie(estado);
                    } else if (pInicio.getFechainicio().before(pNuevo.getFechainicio())){
                            UtilidadesLog.debug("*** 4.-");
                            clienteEstatus.setPerd_oid_peri_peri_fin(periodoAnterior);
                            
                            try
                            {
                                //ClienteHistoricoEstatusLocal clienteHistEstat = clienteEstatusHome.create(cliente, estado, perInicio, null);
                                UtilidadesLog.debug("*** Create con cliente: "+cliente+" estado: "+ estado+" periodoNuevo: "+ periodoNuevo);
                                ClienteHistoricoEstatusLocal clienteHistEstat = clienteEstatusHome.create(cliente, estado, periodoNuevo, null);
                                UtilidadesLog.debug("clienteHistEstat.getOid(): " + clienteHistEstat.getOid());
                                Long[] clasificaciones = (new DAOMAEMaestroClientes(sessionContext.getCallerPrincipal().getName())).obtenerClasificacionesCliente(cliente);
                                    
                                UtilidadesLog.debug("  guardarHistoricoEstatus paso 3");
                
                                HistoricoClasificacionLocalHome historicoHome = new HistoricoClasificacionLocalHome();
                
                                for (int u = 0; u < clasificaciones.length; u++) {
                                    UtilidadesLog.debug("clasificaciones[u]: " + clasificaciones[u]);
                                    UtilidadesLog.debug("clienteHistorico.getOid(): " + clienteHistEstat.getOid());
                
                                    historicoHome.create(clienteHistEstat.getOid(), clasificaciones[u]);
                                }
                                
                                clienteEstatusHome.merge(clienteEstatus);
                            } catch (PersistenceException pe) {
                                UtilidadesLog.error(pe);
                                sessionContext.setRollbackOnly();
                                throw new MareException(pe, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS));
                            }
                        } else {
                                try{
                                UtilidadesLog.info("*** 5.-");
                                    UtilidadesLog.debug("*** Create con cliente: "+cliente+" estado: "+ estado+" periodoNuevo: "+ periodoNuevo);
                                    ClienteHistoricoEstatusLocal clienteHistEstat = clienteEstatusHome.create(cliente, estado, periodoNuevo, null);
                                } catch (PersistenceException pe){
                                UtilidadesLog.error(pe);
                                sessionContext.setRollbackOnly();
                                throw new MareException(pe, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS));
                            }
                        }
                    
                    
                } catch (NoResultException nre) {
                    sessionContext.setRollbackOnly();
                    throw new MareException(nre, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE));
                } catch (PersistenceException pe) {
                    sessionContext.setRollbackOnly();
                    throw new MareException(pe, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS));
                }
            }
            
            
    }

    public void TestEstatusInicial(Long cliente, Long perio, ArrayList tiposClientes) throws MareException, FinderException {
        UtilidadesLog.info("MONEstatusCliente.TestEstatusInicial(estado, periodoNuevo, cliente, , DTOAuditableSICC): Entrada"); 
        // inicializacion datos de prueba
        //UtilidadesLog.debug("TestEstatusInicial paso inicial");
        DTOAuditableSICC dtoaud = new DTOAuditableSICC();
        dtoaud.setIpCliente("200.100.100.100");
        dtoaud.setPrograma("ninguno");

        ClienteDatosAdicionalesLocalHome clienteadicionalesHome = new ClienteDatosAdicionalesLocalHome();

        ClienteDatosAdicionalesLocal clienteadicionales = clienteadicionalesHome.findByPrimaryKey(cliente);

        //UtilidadesLog.debug("TestEstatusInicial paso 1");										
        //llamada al metodo
        asignarEstatusInicial(clienteadicionales, perio, tiposClientes, dtoaud);

        //UtilidadesLog.debug("TestEstatusInicial paso final");
    }

    public DTOSalida obtenerPosiblesEstatusCliente(DTOBelcorp dto) throws MareException {
        UtilidadesLog.info("MONEstatusCliente.obtenerPosiblesEstatusCliente(DTOBelcorp): Entrada"); 
        UtilidadesLog.info("MONEstatusCliente.obtenerPosiblesEstatusCliente(DTOBelcorp): Salida"); 
        return DAOMAEEstatusCliente.obtenerPosiblesEstatusCliente(dto);
    }

    /**
     *
     */
    public void comprobarEstadoCliente(Long cliente) throws MareException {
        UtilidadesLog.info("MONEstatusCliente.comprobarEstadoCliente(cliente): Entrada"); 

        ClienteDatosAdicionalesLocal clientesDAL = null;
        TipoBloqueoLocalHome tipoBloqueoLH = null;
        TipoBloqueoLocal tipoBloqueoL = null;
        ClienteBloqueoLocalHome clienteBloqueoLH = null;
        ClienteBloqueoLocal clienteBloqueoL = null;
        Long oidTipoBloqueo = null;

        try {
            ClienteDatosAdicionalesLocalHome clientesDALH = new ClienteDatosAdicionalesLocalHome();
            clientesDAL = clientesDALH.findByCliente(cliente);
            UtilidadesLog.debug("ClienteDatosAdicionales luego del finder");
        } catch (NoResultException ex) {
            UtilidadesLog.debug("NoResultException ClienteDatosAdicionales");
            throw new ClienteNoUtilizableException(ex);
        } catch (PersistenceException ex) {
            sessionContext.setRollbackOnly();
            throw new MareException(ex, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS));
        }

        if (clientesDAL.getInd_acti().intValue() == 0) {
            UtilidadesLog.debug("Informo excepcion Cliente Inactivo.");
            throw new ClienteInactivoException();
        }

        try {
            tipoBloqueoLH = new TipoBloqueoLocalHome();
            tipoBloqueoL = tipoBloqueoLH.findByCodigo(ConstantesMAE.BLOQUEO_FINANCIERO);
            UtilidadesLog.debug("TipoBloqueo luego del finder");
            oidTipoBloqueo = tipoBloqueoL.getOid();
            UtilidadesLog.debug("ComprobarEstado Oid TipoBloqueo: " + oidTipoBloqueo);
        } catch (NoResultException ex) {
            UtilidadesLog.debug("Informo excepcion TipoBloqueo Financiero");
            throw new ClienteNoUtilizableException(ex);
        } catch (PersistenceException ex) {
            sessionContext.setRollbackOnly();
            throw new MareException(ex, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS));
        }

        try {
            clienteBloqueoLH = new ClienteBloqueoLocalHome();
            clienteBloqueoL = clienteBloqueoLH.findByClienteTipoBloqueo(cliente, oidTipoBloqueo);
            UtilidadesLog.debug("ClienteBloqueo luego del finder");
            throw new ClienteBloqueoFinancieroException();
        } catch (NoResultException ex) {
            UtilidadesLog.debug("Cliente sin bloqueo financiero.");
        } catch (PersistenceException ex) {
            sessionContext.setRollbackOnly();
            throw new MareException(ex, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS));
        }

        try {
            tipoBloqueoL = tipoBloqueoLH.findByCodigo(ConstantesMAE.BLOQUEO_ADMINISTRATIVO);
            UtilidadesLog.debug("TipoBloqueo luego del finder por bloqueo administradtivo");
            oidTipoBloqueo = tipoBloqueoL.getOid();
        } catch (NoResultException ex) {
            UtilidadesLog.debug("Informo excepcion TipoBloqueo Administrativo ClienteNoUtilizable");
            throw new ClienteNoUtilizableException(ex);
        } catch (PersistenceException ex) {
            sessionContext.setRollbackOnly();
            throw new MareException(ex, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS));
        }

        try {
            clienteBloqueoL = clienteBloqueoLH.findByClienteTipoBloqueo(cliente, oidTipoBloqueo);
            UtilidadesLog.debug("ClienteBloqueo luego del finder");
            throw new ClienteBloqueoAdminException();
        } catch (NoResultException ex) {
            UtilidadesLog.debug("ClienteBloqueo sin bloqueo: " + oidTipoBloqueo);
        } catch (PersistenceException ex) {
            sessionContext.setRollbackOnly();
            throw new MareException(ex, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS));
        }
        UtilidadesLog.info("MONEstatusCliente.comprobarEstadoCliente(cliente): Salida"); 
    }

    /**
             * //Recorremos todos los clientes del sistema para indicarles un estado activo o inactivo dependiendo de los pedidos que hayan pasado.
             * @author Mario Bobadilla
             * @fecha 09/09/04
             */
    /*****************
    Autor: Viviana Bongiovanni
    Fecha: 29/12/2004
    Agregado de FinderException
    Modificado: SICC-DMCO-MAE-GCC-006 - Cleal
    *********************/
    /*
     * public void evaluarIndicadorActivo(DTOCierreRegion dtoCierre) throws MareException {
        UtilidadesLog.info("MONEstatusCliente.evaluarIndicadorActivo(DTOCierreRegion): Entrada"); 
        

        DAOMAEEstatusCliente dao = new DAOMAEEstatusCliente(sessionContext.getCallerPrincipal().getName());
        ClienteDatosAdicionalesLocalHome clienteadicionalesHome = MAEEjbLocators.getClienteDatosAdicionalesLocalHome();

        RecordSet rs = new RecordSet();
        UtilidadesLog.debug("antes de ejecutar: dao.obtenerClientesActualizarIndActivo");
        rs = dao.obtenerClientesActualizarIndActivo(dtoCierre);

        UtilidadesLog.debug("los registros que obtengo: " + rs);

        for (int i = 0; i < rs.getRecords().size(); i++) {
            UtilidadesLog.debug("recorriendo fila: " + i);

            Hashtable tabla = this.armarRecordSet(rs, i);

            if (tabla.containsKey("OID_CLIE_DATO_ADIC") && tabla.containsKey("NUM_CAMP_SIN_PEDI") && tabla.containsKey("NUM_PERI_RETI")) {
                try {
                    UtilidadesLog.debug("busco en clienteadicionales: " + tabla.get("OID_CLIE_DATO_ADIC").toString());

                    ClienteDatosAdicionalesLocal clienteadicionales = clienteadicionalesHome.findByPrimaryKey(new Long(tabla.get("OID_CLIE_DATO_ADIC").toString()));

                    
                    long a = (tabla.get("NUM_CAMP_SIN_PEDI") != null) ? new Long(tabla.get("NUM_CAMP_SIN_PEDI").toString()).longValue() : new Long(0).longValue();
                    long b = new Long(tabla.get("NUM_PERI_RETI").toString()).longValue();

                    if (a <= b) {
                        UtilidadesLog.debug("Activa");
                        clienteadicionales.setInd_acti(new Long(1));
                    } else {
                        UtilidadesLog.debug("Desactiva");
                        clienteadicionales.setInd_acti(new Long(0));
                    }
                } catch (FinderException fe) {
                    throw new MareException(fe, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE));
                }
            }
        }

        UtilidadesLog.info("MONEstatusCliente.evaluarIndicadorActivo(DTOCierreRegion): Salida"); 
    }
    */

    /**
    * Metodo de apoyo a la clase que devuelve un hashtable con las filas del Recordset
    * en pares [clave(Columnm name de la tabla),valor(valor de la columna)]
    * no se encuentra definido en el diseño
    * @author Mario Bobadilla
    * fecha 28/05/04
    */
    private Hashtable armarRecordSet(RecordSet rs, int i) {
       UtilidadesLog.info("MONEstatusCliente.armarRecordSet(RecordSet, int): Entrada"); 
        Hashtable tabla = new Hashtable();
        Vector tupla = new Vector();
        Vector columnas = new Vector();
        Object obj = null;
        tupla = rs.getRow(i);
        columnas = rs.getColumnIdentifiers();

        for (int j = 0; j < tupla.size(); j++) {
            if (tupla.get(j) != obj) {
                tabla.put(columnas.get(j), tupla.get(j));
            }
        }
        
        UtilidadesLog.info("MONEstatusCliente.armarRecordSet(RecordSet, int): Salida"); 
        return tabla;
    }

    /**
    * Asignar estatus en lotes.    Recorremos todas las consultoras del sistema para
    * asignarles un nuevo estado, dependiendo de su actividad en el periodo actual.
    * @param es.indra.sicc.cmn.negocio.batch.DTOBatch dto
    * @throws es.indra.mare.common.exception.MareException
    * @author Fernando Coronel
    * @version "1.0 Paquete MAE-201-334"
    * @observaciones 
    *     [13/Nov/2006] eiraola
    *     Para Performance se modifica el proceso para trabajar las tareas de 
    *     actualizacion por conjunto de clientes y no de forma individual cliente
    *     a cliente.
    * @mejora Los bloques o lotes de ejecucion no deben ser ejecutados en segmentos batch.
    *         Es necesario mantener una sola transaccion con la ejecucion de todos los lotes.
    *         Incidencia 20070256.
    * @autor gdmarzi        
    */
    public void asignarEstatusLotes(DTOCierreRegion dtoCierre, String IDProc) throws MareException {
        UtilidadesLog.info("MONEstatusCliente.asignarEstatusLotes(dtoCierre, IDProc): Entrada"); 
        MareMGC mgc;
        String strNumConBloque;
        int numConBloque = 10000;

        try {
            RecordSet rs = DAOMAEEstatusCliente.obtenerClientesActualizarEstatusLote(dtoCierre);   // Performance

            UtilidadesLog.debug("el recordset obtenido, es: " + rs);

            //Obtenemos la propiedad "application/sicc.numeroConsultorasBloque" a traves del servicio MGC. 
            mgc = (MareMGC) MareMii.getService(new MareTopic("Configuration"));
            strNumConBloque = (String) mgc.getProperty("application/sicc.numeroConsultorasBloque");
            UtilidadesLog.debug("bloque: " + strNumConBloque);
            
            if (strNumConBloque != null) {
                numConBloque = Integer.parseInt(strNumConBloque);
            } else { // Si dicha propiedad no estuviera definida, tomamos 10000 como valor por defecto 
                numConBloque = 10000;
            }
            UtilidadesLog.debug("bloque definitivo: " + strNumConBloque);

            //  Recorremos las filas y juntamos grupos de filas del número indicando por la propiedad que hemos 
            //  obtenido (o menos si llegamos al final del recordset) creamos un recordset en el que copiamos cada grupo de filas.            
            if (!rs.esVacio()) {
                RecordSet rsGrupo = new RecordSet();
                Vector vecGrupos = new Vector();
                rsGrupo.setColumnIdentifiers(rs.getColumnIdentifiers());

                for (int i = 0; i < rs.getRowCount(); i++) {
                    if ((i != 0) && ((i % numConBloque) == 0)) {
                        vecGrupos.add(rsGrupo);
                        rsGrupo = new RecordSet();
                        rsGrupo.setColumnIdentifiers(rs.getColumnIdentifiers());
                    }
                    rsGrupo.addRow(rs.getRow(i));
                }
                UtilidadesLog.debug("rsGrupo, es: " + rsGrupo);
                vecGrupos.add(rsGrupo);
                
                int cantLotes = vecGrupos.size();
                UtilidadesLog.debug("voy a recorrer: vecGrupos, que mide: " + cantLotes);

            
                for (int i = 0; i < cantLotes; i++) {
                    DTORangoClientesEvaluarEstado dtoRangoCl = new DTORangoClientesEvaluarEstado();
                    dtoRangoCl.setConsultoras((RecordSet) vecGrupos.get(i));
                    dtoRangoCl.setPeriodo(dtoCierre.getPeriodo());
                    dtoRangoCl.setIndReevaluacion(dtoCierre.getIndReevaluacion());

                    this.actualizarEstatusRangoClientes(dtoRangoCl);
                }
            }
        } catch (MareException e) {
            sessionContext.setRollbackOnly();
            e.printStackTrace();
            throw e;
        } catch (Exception e) {
            sessionContext.setRollbackOnly();
            e.printStackTrace();
            throw new MareException(e);
        }
        UtilidadesLog.info("MONEstatusCliente.asignarEstatusLotes(dtoCierre, IDProc): Salida"); 
    }


    /*****************
    Autor: Viviana Bongiovanni
    Fecha: 29/12/2004
    Evaluacion de actividad de clientes
    *********************/
    public void lanzarEvaluarIndicadorActivo(DTOFACProcesoCierre dto) throws MareException {
        UtilidadesLog.info("MONEstatusCliente.lanzarEvaluarIndicadorActivo(DTOFACProcesoCierre): Entrada"); 

        DTOCierreRegion dtocierre = new DTOCierreRegion();
        dtocierre.setPeriodo(dto.getPeriodo());
        dtocierre.setOidPais(dto.getOidPais());
        dtocierre.setOidIdioma(dto.getOidIdioma());
        dtocierre.setRegion(new Float(dto.getRegion().longValue()));
        dtocierre.setMarca(dto.getMarca());
        dtocierre.setCanal(dto.getCanal());
        this.evaluarIndicadorActivo(dtocierre);

        UtilidadesLog.info("MONEstatusCliente.lanzarEvaluarIndicadorActivo(DTOFACProcesoCierre): Salida"); 
    }

    /*****************
    Autor: Viviana Bongiovanni
    Fecha: 29/12/2004
    Evaluacion del nuevo estado de las consultoras
    *********************/
    public void lanzarActualizacionEstatusClientes(DTOFACProcesoCierre dto) throws MareException, InterruptedException {
        UtilidadesLog.info("MONEstatusCliente.lanzarActualizacionEstatusClientes(DTOFACProcesoCierre): Entrada"); 

        DTOCierreRegion dtocierre = new DTOCierreRegion();
        dtocierre.setPeriodo(dto.getPeriodo());
        dtocierre.setOidPais(dto.getOidPais());
        dtocierre.setOidIdioma(dto.getOidIdioma());
        dtocierre.setRegion(new Float(dto.getRegion().longValue()));
        if (dto.getIndReevaluacion() == null) {
            dto.setIndReevaluacion(Boolean.FALSE);
        }
        dtocierre.setIndReevaluacion(dto.getIndReevaluacion());

        this.asignarEstatusLotes(dtocierre, dto.getIDProc());

        UtilidadesLog.info("MONEstatusCliente.lanzarActualizacionEstatusClientes(DTOFACProcesoCierre): Salida"); 
    }


    /*****************
    Autor: Viviana Bongiovanni
    Fecha: 30/12/2004
    *********************/
    private MONPedidosSolicitud getMONPedidosSolicitud() throws MareException {
        UtilidadesLog.info("MONEstatusCliente.getMONPedidosSolicitud(): Entrada"); 
        try {
            MONPedidosSolicitudHome pedHome = PEDEjbLocators.getMONPedidosSolicitudHome();
            UtilidadesLog.info("MONEstatusCliente.getMONPedidosSolicitud(): Salida"); 

            return pedHome.create();
        } catch (RemoteException re) {
            throw new MareException(re, UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
        } catch (CreateException ce) {
            throw new MareException(ce, UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
        }
    }

    private BusinessFacadeLocalHome getBusinessFacadeLocalHome() throws NamingException {
        UtilidadesLog.info("MONEstatusCliente.getBusinessFacadeLocalHome(): Entrada"); 
        final InitialContext context = new InitialContext();
        UtilidadesLog.info("MONEstatusCliente.getBusinessFacadeLocalHome(): Salida"); 

        return (BusinessFacadeLocalHome) context.lookup("java:comp/env/BusinessFacadeBATCH");
    }

    private MONBatchEJBLocalHome getMONBatchEJBLocalHome() throws NamingException {
        UtilidadesLog.info("MONEstatusCliente.getMONBatchEJBLocalHome(): Entrada"); 
        final InitialContext context = new InitialContext();
        UtilidadesLog.info("MONEstatusCliente.getMONBatchEJBLocalHome(): Salida"); 
        return (MONBatchEJBLocalHome) context.lookup("java:comp/env/MONBatchEJB");
    }
    
  public void reasignarEstatusEnLotes(DTOFACCierreFacturacion dtoe) throws MareException {
      UtilidadesLog.info("MONEstatusCliente.reasignarEstatusEnLotes(DTOFACCierreFacturacion dtoe): Entrada");
      
      TiposCierreLocalHome tiposCierreLH = new TiposCierreLocalHome();
      TiposCierreLocal tiposCierreL = null;
      Long oidTipoCierrePeriodo = null;
      Long oidTipoCierreRegion = null;
      Collection colTiposCierre = null;
      
      try {
          colTiposCierre = tiposCierreLH.findAll();
      } catch(NoResultException nre) {
          throw new MareException(nre, UtilidadesError.armarCodigoError(
                  CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE));
          } catch(PersistenceException pe) {
              throw new MareException(pe, UtilidadesError.armarCodigoError(
                      CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS));
      }
      Iterator iterator = colTiposCierre.iterator();
      
      while (iterator.hasNext()) {
          tiposCierreL = (TiposCierreLocal)iterator.next();
          
          if (tiposCierreL.getCodigo().equals(ConstantesFAC.TIPO_CIERRE_PERIODO)) {
                oidTipoCierrePeriodo = tiposCierreL.getOid();
          }
          if (tiposCierreL.getCodigo().equals(ConstantesFAC.TIPO_CIERRE_REGION)) {
                oidTipoCierreRegion = tiposCierreL.getOid();
          }
      }
      
      DAOFACCierreFacturacion daoFac = new DAOFACCierreFacturacion();
      
      
      // Se Verifica el cierre de periodo (cod "P" oid 3)
      UtilidadesLog.debug(" Verificando el cierre de Periodo: " + dtoe.getPeriodo());
      dtoe.setTipoCierre(oidTipoCierrePeriodo);
      dtoe.setCodigoTipoCierre(ConstantesFAC.TIPO_CIERRE_PERIODO);
                
      Integer nroCtrlCierresPeriodo = daoFac.obtenerNumeroControlCierres(dtoe);
      UtilidadesLog.debug(" ... cant cierres_" + nroCtrlCierresPeriodo);
      
      if (nroCtrlCierresPeriodo.intValue() > 0) { // Ya se ha ejecutado un cierre de periodo
          // MAE-0038 "Cierre de periodo ya ejecutado: no puede reasignar Estatus en lote"
          UtilidadesLog.error("El Cierre de Periodo ya habia sido ejecutado.");
          UtilidadesLog.info("MONEstatusCliente.reasignarEstatusEnLotes(DTOFACCierreFacturacion dtoe): Salida A");
          throw new MareException(new Exception(),
              UtilidadesError.armarCodigoError(ConstantesSEG.MODULO_MAE,"", ErroresDeNegocio.MAE_0038));
      }
      
      // vbongiv -- Cambio 20070458 -- 31/01/2008
      // Obtiene las regiones cerradas
      DAOMAEEstatusCliente daoMAEEstatusCliente = new DAOMAEEstatusCliente(sessionContext.getCallerPrincipal().getName());
      
      // Obtiene regiones
      DTOOIDs oidRegiones = daoMAEEstatusCliente.obtieneRegiones(dtoe);
      
      if(oidRegiones.getOids().length ==0){
          UtilidadesLog.error("No hay regiones cerradas");
          UtilidadesLog.info("MONEstatusCliente.reasignarEstatusEnLotes(DTOFACCierreFacturacion dtoe): Salida");
          throw new MareException(new Exception(),
              UtilidadesError.armarCodigoError(ConstantesSEG.MODULO_MAE,"", ErroresDeNegocio.MAE_0043));
      } else {
          dtoe.setRegiones(oidRegiones);
      }
      
      // Activa consultoras
      daoMAEEstatusCliente.activarConsultoras(dtoe);
      
      dtoe.setTipoCierre(null);
      dtoe.setCodigoTipoCierre(null);
      UtilidadesLog.debug("dtoe_" + dtoe);
      
      // Si se pasaron ambas validaciones, se llama al método reasignarEstatusEnLotesBatch en modo batch
      UtilidadesLog.debug(" ... Se pasaron las validaciones... ahora la ejecucion es Batch");
      DTOBatch dtoBatch = new DTOBatch( "reasignarEstatusEnLotesBatch", 
              new MareBusinessID("MAEReasignarEstatusEnLotesBatch"), 
              dtoe);
      UtilidadesLog.debug("el nuevo dtoBatch_" + dtoBatch);
      try {
          BatchUtil.executeMLN(dtoBatch, "FACProcesosGP5");   // No uso MAEProcesosClientesQueue porque la usan sus subprocesos
      } catch(RemoteException re) {
          UtilidadesLog.error("*** Error en reasignarEstatusEnLotes",re);
          String codigoError = CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB;
          throw new MareException(re, UtilidadesError.armarCodigoError(codigoError));			
      }

      UtilidadesLog.info("MONEstatusCliente.reasignarEstatusEnLotes(DTOFACCierreFacturacion dtoe): Salida C");
  }

  public DTOSalidaBatch reasignarEstatusEnLotesBatch(DTOBatch dtoBatch) throws MareException {
      UtilidadesLog.info("MONEstatusCliente.reasignarEstatusEnLotesBatch(dtoBatch): Entrada");
      
      // Recibimos el parametro DTOFACCierreFacturacion desde online
      DTOFACCierreFacturacion dtoe = null;
      try {
          UtilidadesLog.debug("el dtoBacth entrada_" + dtoBatch);
          dtoe = (DTOFACCierreFacturacion)dtoBatch.getDTOOnline();
          UtilidadesLog.debug(" RECIBIDO DTOFACCierreFacturacion_" + dtoe);
      } catch(ClassCastException cce) {
          UtilidadesLog.error("*** ClassCastException  en  MONEstatusCliente.reasignarEstatusEnLotesBatch, salimos del metodo");
          throw new MareException("ClassCastException  en  MONEstatusCliente.reasignarEstatusEnLotesBatch", cce);
      }
      
      Long regiones[] = dtoe.getRegiones().getOids();
      int cantRegiones = regiones.length;
      UtilidadesLog.debug(" la cantidad de regiones a procesar es_" + cantRegiones);
      
      Long oidRegion;
      DTOFACProcesoCierre dtoProcesoCierre;
      
      for (int i = 0; i < cantRegiones; i++) {
          oidRegion = regiones[i];
          UtilidadesLog.debug(" --- Lanzando reevaluacion de Estatus de Clientes para region_" + oidRegion);
          
          dtoProcesoCierre = new DTOFACProcesoCierre();
          dtoProcesoCierre.setOidPais(dtoe.getOidPais());
          dtoProcesoCierre.setOidIdioma(dtoe.getOidIdioma());
          dtoProcesoCierre.setMarca(dtoe.getMarca());
          dtoProcesoCierre.setCanal(dtoe.getCanal());
          dtoProcesoCierre.setPeriodo(dtoe.getPeriodo());
          dtoProcesoCierre.setRegion(oidRegion);
          dtoProcesoCierre.setProceso("Reasignar_estatus_en_lotes");
          dtoProcesoCierre.setIDProc(dtoBatch.getProcessID()); //El identificador padre sera reasignarEstatusEnLotesBatch_nnnnn
          dtoProcesoCierre.setIndReevaluacion(Boolean.TRUE);
          try {
              lanzarActualizacionEstatusClientes(dtoProcesoCierre);
          } catch (InterruptedException ie) {
              UtilidadesLog.error("Bucle_" + i + " InterruptedException en ReasignarEstatusEnLotes para Region_"+ oidRegion);
              throw new MareException ("Error ejecutando Actualizacion de Estatus Clientes", ie);
          }
      }
      
      UtilidadesLog.info("MONEstatusCliente.reasignarEstatusEnLotesBatch(dtoBatch): Salida");
      return new DTOSalidaBatch (0, "Reasignacion de Estatus de Clientes realizada");
  }


    public void evaluarIndicadorActivo(DTOCierreRegion dtoCierre) throws MareException {
        
        UtilidadesLog.info("MONEstatusCliente.evaluarIndicadorActivo(DTOCierreRegion): Entrada");         
        RecordSet rs;
        rs = this.obtenerClientesActualizarIndActivo(dtoCierre);
        int tamano = rs.getRowCount();
        String clienActivar = new String ();
        String clienDesactivar = new String ();
        
        // sapaza -- COL-SiCC-2015-0051 -- 30/03/2015
        String clienDesbloquear = new String ();
        
        long estado;
        int contActivar=0;
        int contDesActivar=0;
        Vector vExecutor = new Vector();
        for (int i = 0; i < tamano; i++) {
            estado = ((BigDecimal)rs.getValueAt(i,"ESTADO")).longValue();
            if (estado == 1){
                clienActivar =  clienActivar + ((BigDecimal)rs.getValueAt(i,"OID_CLIE_DATO_ADIC")).toString() + ",";
                contActivar = contActivar + 1;
            }else {
                clienDesactivar = clienDesactivar + ((BigDecimal)rs.getValueAt(i,"OID_CLIE_DATO_ADIC")).toString() + ",";
                clienDesbloquear = clienDesbloquear + ((BigDecimal)rs.getValueAt(i,"CLIE_OID_CLIE")).toString() + ",";
                contDesActivar = contDesActivar + 1;
            }
            
            if (contActivar >= 900){
                this.armarUpdateActualizarBase(clienActivar.substring(0,(clienActivar.length()-1)), 1, vExecutor);
                clienActivar = new String ();
                contActivar = 0;
            }
            if (contDesActivar >= 900){
                this.armarUpdateActualizarBase(clienDesactivar.substring(0,(clienDesactivar.length()-1)), 0,vExecutor);
                
                // sapaza -- COL-SiCC-2015-0051 -- 30/03/2015
                this.armarUpdateDesbloqueoCliente(clienDesbloquear.substring(0,(clienDesbloquear.length()-1)), dtoCierre.getOidPais(),vExecutor);
                
                clienDesactivar = new String ();
                clienDesbloquear = new String ();
                contDesActivar = 0;
            }
        }
        
        if (contActivar > 0){
            this.armarUpdateActualizarBase(clienActivar.substring(0,(clienActivar.length()-1)), 1,vExecutor);
        }
        if (contDesActivar > 0){
            this.armarUpdateActualizarBase(clienDesactivar.substring(0,(clienDesactivar.length()-1)), 0,vExecutor);
            
            // sapaza -- COL-SiCC-2015-0051 -- 30/03/2015
            this.armarUpdateDesbloqueoCliente(clienDesbloquear.substring(0,(clienDesbloquear.length()-1)), dtoCierre.getOidPais(),vExecutor);
        }        
        
        invocarExecutor (vExecutor);

        UtilidadesLog.info("MONEstatusCliente.evaluarIndicadorActivo(DTOCierreRegion): Salida"); 
        
    }
    
    private void invocarExecutor (Vector vExecutor) throws MareException {
        String query = new String ();
        int cantSentencias = vExecutor.size();
        UtilidadesLog.debug("    cantidad de sentencias a ejecutar_" + cantSentencias);
        if (cantSentencias == 0) return;
                
        for (int i=0; i< cantSentencias; i++){
            query = query + ((StringBuffer) vExecutor.get(i)).toString();
        }
        try {
            UtilidadesEJB.getBelcorpService().dbService.executeProcedure("PQ_PLANI.EXECUTOR" ,query);
        } catch (Exception ex ){
            UtilidadesLog.error(ex.getMessage());
            throw new MareException(ex, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS));
        }
    }
    
    private void armarUpdateActualizarBase (String clientes, int indicador, Vector vExecutor) throws MareException {
        UtilidadesLog.info("MONEstatusCliente.actualizarBase(String, int): Entrada"); 

        RecordSet resultado = null;
        StringBuffer query = new StringBuffer();
        query.append("UPDATE MAE_CLIEN_DATOS_ADICI ");
        query.append("SET  IND_ACTI= " + indicador);
        query.append(" WHERE oid_clie_dato_Adic in ( " + clientes);
        query.append(" );");
        
        vExecutor.add(vExecutor.size(),query);
        
        UtilidadesLog.info("MONEstatusCliente.actualizarBase(String, int): Salida"); 

    }
    
    private RecordSet obtenerClientesActualizarIndActivo(DTOCierreRegion dto) throws MareException {
        UtilidadesLog.info("MONEstatusCliente.obtenerClientesActualizarIndActivo(DTOCierreRegion): Entrada"); 

        RecordSet resultado = null;
        StringBuffer query = new StringBuffer();

        try {

			query.append(" SELECT estado, b.oid_clie_dato_adic ");
            query.append(" , b.clie_oid_clie "); // sapaza -- COL-SiCC-2015-0051 -- 30/03/2015
            query.append(" FROM  MAE_CLIEN_DATOS_ADICI b, ");
            query.append("      (SELECT  CASE WHEN a.num_camp_sin_pedi IS NULL   THEN NULL ");
            query.append("       WHEN (a.num_camp_sin_pedi < num_peri_reti) THEN 1 ");
            
            // sapaza -- PER-SiCC-2010-0534 -- 07/09/2010
            query.append("       WHEN (a.num_camp_sin_pedi = num_peri_reti) THEN 0 ");
	    query.append("              ELSE 2  ");
                        
			query.append("              END AS estado ");
            query.append("            ,a.oid_clie_dato_adic ");
			query.append("       FROM MAE_CLIEN_DATOS_ADICI a, ");
            query.append("           seg_pais p, ");
			query.append("           (SELECT uadm.clie_oid_clie oidCliente ");
            query.append("           FROM ");
			query.append("               MAE_CLIEN_UNIDA_ADMIN uadm ");
            query.append("              ,ZON_TERRI_ADMIN tadm ");
            query.append("              ,ZON_SECCI seccion ");
            query.append("              ,ZON_ZONA zona  ");
			query.append("              ,( SELECT periodoinicio.oid_peri  ");
            query.append("                 FROM CRA_PERIO periodoinicio ");
			query.append("                     ,CRA_PERIO periodoactual ");
            query.append("                 WHERE periodoactual.oid_peri = " + dto.getPeriodo());
			query.append("                   AND periodoinicio.marc_oid_marc = periodoactual.marc_oid_marc ");
            query.append("                   AND periodoinicio.cana_oid_cana = periodoactual.cana_oid_cana ");
			query.append("                   AND periodoinicio.fec_inic <= periodoactual.fec_inic ");
            query.append("                   AND periodoinicio.pais_oid_pais = " +dto.getOidPais());
			query.append("                ) periodo ");
            query.append("           WHERE  zona.zorg_oid_regi = "  + dto.getRegion());
            query.append("               AND zona.pais_oid_pais = " + dto.getOidPais());
            query.append("               AND zona.MARC_OID_MARC = " + dto.getMarca());
			query.append("               AND zona.cana_oid_cana = " + dto.getCanal());
            query.append("               AND seccion.zzon_oid_zona = zona.oid_zona ");
			query.append("               AND tadm.zscc_oid_secc = seccion.oid_secc  ");
            query.append("               AND tadm.marc_oid_marc = " + dto.getMarca());
			query.append("               AND tadm.cana_oid_cana = " + dto.getCanal());
            query.append("               AND uadm.ztad_oid_terr_admi(+)= tadm.oid_terr_admi ");
			query.append("               AND uadm.perd_oid_peri_ini = periodo.oid_peri ");
            // Modificado por SICC20070319 - Rafael Romero - 02/10/2007
            query.append("               AND uadm.perd_oid_peri_fin IS NULL ");
            query.append("               AND NOT EXISTS ( ");
            query.append("                          SELECT 1 ");
            query.append("                            FROM mae_zona_sinde zonexcp ");
            query.append("                           WHERE zonexcp.ZZON_OID_ZONA = zona.OID_ZONA) ");
            query.append("               )  clie_zona_perio ");
            // Fin modificado SICC20070319
			query.append("       WHERE   a.clie_oid_clie =clie_zona_perio.oidCliente ");
            query.append("           AND num_camp_sin_pedi IS NOT NULL    ");
            query.append("           AND  p.oid_pais = " + dto.getOidPais());
            query.append("       )c    ");
            query.append(" WHERE c.OID_CLIE_DATO_ADIC = b.OID_CLIE_DATO_ADIC  ");
            query.append("   AND b.ind_acti <> c.estado ");
            query.append("   AND c.estado IS NOT NULL ");
            
            query.append("   AND c.estado < 2 "); // sapaza -- PER-SiCC-2010-0534 -- 07/09/2010
            
            // Agregado por SICC20070319 - Rafael Romero - 02/10/2007
            query.append("   AND NOT EXISTS ( ");
            query.append("          SELECT 1 ");
            query.append("            FROM mae_clien_tipo_subti clisbt, mae_subti_sinde sbtexcp ");
            query.append("           WHERE sbtexcp.pais_oid_pais = " + dto.getOidPais());
            query.append("             AND sbtexcp.marc_oid_marc = " + dto.getMarca());
            query.append("             AND sbtexcp.cana_oid_cana = " + dto.getCanal());
            query.append("             AND sbtexcp.sbti_oid_subt_clie = clisbt.sbti_oid_subt_clie ");
            query.append("             AND clisbt.clie_oid_clie = b.clie_oid_clie) ");
            // Fin agregado SICC20070319            

			resultado = UtilidadesEJB.getBelcorpService().dbService.executeStaticQuery(query.toString() );
        
        }catch(Exception e) {
        if (e instanceof MareException) {
                ((MareException) e).getOriginalCause().printStackTrace();
                throw (MareException) e;
        } else {
            e.printStackTrace();
            throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS));
        }
            
        }
        UtilidadesLog.info("MONEstatusCliente.obtenerClientesActualizarIndActivo(DTOCierreRegion): Salida"); 
        return resultado;
        
    }
    
    /**
     * Deprecated. Se utiliza un metodo privado y con otro dto de entrada.
     * Incidencia 20070256.
     */
    public void actualizarEstatusRangoClientes(DTOBatch dtoBatch) throws MareException {

    }    
    
   /**
    * Permite actualizar el numero de campanyas sin pedido para todos los clientes,
    * y en caso que correspondiese llama a actualizar el estatus e historicos 
    * (de estatus y de clasificacion).
    * Maneja un Hashtable cuyas claves son oidCliente y sus respectivos valores
    * son DTOClienteEvaluarEstado
    * @author eiraola
    * @date 15/Nov/2006
    * @observacion Metodo redefinido por performance. Observar que se comento el codigo
    * completo del metodo original
    * @mejora la ejecucion deja de ser batch por motivos transaccionales.
    *         La transaccion pasa a ser controlada por el metodo que invoca a este.
    *         Incidencia 20070256.
    * @autor gdmarzi
    */
    private void actualizarEstatusRangoClientes(DTORangoClientesEvaluarEstado dtoRangoClientesEvaluarEstado) throws MareException {
        UtilidadesLog.info("MONEstatusCliente.actualizarEstatusRangoClientes(): Entrada");
        DAOCRA daoCra = new DAOCRA();
        Long oidCliente;
        Long oidDatosAdicionales;
        Long oidEstatusActual;
        Long oidEstatusNuevo;
        int cantidadPedidosEnPeriodo;
        short numCampSinPedi;
        Hashtable clientesAActualizarHistEsta = new Hashtable();
        DTOClienteEvaluarEstado clienAActualizar;
        Vector vUpdateDatosAdic = new Vector();
        Vector vUpdateDatosCliente = new Vector();
        String codEstatusActual;
        String codEstatusNuevo;
        Long oidPais;
        

        // Procesamos los registros de clientes        
        try {
            RecordSet rs = dtoRangoClientesEvaluarEstado.getConsultoras();
            int cantClientes = rs.getRowCount();
            UtilidadesLog.debug("Cantidad de clientes a Procesar su Estatus_" + cantClientes);
            if (cantClientes == 0) {
                UtilidadesLog.info("MONEstatusCliente.actualizarEstatusRangoClientes(): Salida (sin clientes)");
                return;
            }
            
            Long periodoActual = dtoRangoClientesEvaluarEstado.getPeriodo();
            UtilidadesLog.debug("Periodo (actual) a Evaluar_" + periodoActual);
            Long periodoAnterior = daoCra.obtienePeriodoAnteriorActual(periodoActual);
            UtilidadesLog.debug("Periodo anterior_" + periodoAnterior);
            
            boolean indReevaluacion = dtoRangoClientesEvaluarEstado.getIndReevaluacion().booleanValue();
            
            //BLO-01 jrivas
            oidPais = new Long(((BigDecimal)rs.getValueAt(0, "OID_PAIS")).longValue());
            DAOMAEEstatusCliente dao = new DAOMAEEstatusCliente(sessionContext.getCallerPrincipal().getName());
            int nivelGravedadBloqueo = dao.recuperarDatosBloqueos(oidPais);
            int numeroPeriodosReingreso = dao.recuperarNumeroPeriodosReingreso(oidPais); // sapaza -- PER-SiCC-2010-0506 -- 15/11/2010
            dao.cargarListaPeriodos(periodoActual, numeroPeriodosReingreso); // sapaza -- PER-SiCC-2010-0506 -- 15/11/2010
            //BLO-01 jrivas FIN
            UtilidadesLog.debug("nivelGravedadBloqueo "  + nivelGravedadBloqueo);
            
            // Actualizamos el estado para cada cliente
            for (int i = 0; i < cantClientes; i++) {
                oidCliente =  new Long(((BigDecimal)rs.getValueAt(i, "CLIE_OID_CLIE")).longValue());
                oidDatosAdicionales =  new Long(((BigDecimal)rs.getValueAt(i, "OID_CLIE_DATO_ADIC")).longValue());
                oidEstatusActual =  new Long(((BigDecimal)rs.getValueAt(i, "ESTA_OID_ESTA_CLIE")).longValue());
                oidEstatusNuevo =  new Long(((BigDecimal)rs.getValueAt(i, "ESTA_OID_ESTA_CLIE_NUEVO")).longValue());
                cantidadPedidosEnPeriodo = Integer.valueOf(((BigDecimal)rs.getValueAt(i, "CANTIDADPEDIDOS")).toString()).intValue();
                codEstatusActual = rs.getValueAt(i, "COD_ESTA_CLIE").toString();
                //BLO-01 jrivas
                codEstatusNuevo = rs.getValueAt(i, "COD_ESTA_CLIE_NUEVO").toString();

                // MAE-014 CU Reasignar Estatus [inicio]
                if (indReevaluacion == true) { // Indicador Reevaluacion Activo
                    UtilidadesLog.debug("Validando si debemos 'Reevaluar' este cliente:");
                    
                    if (rs.getValueAt(i, "NUM_CAMP_SIN_PEDI") != null) {
                        numCampSinPedi = Short.valueOf(((BigDecimal) rs.getValueAt(i, "NUM_CAMP_SIN_PEDI")).toString()).shortValue();
                    } else {
                        numCampSinPedi = 0;
                    }
                    
                    if (cantidadPedidosEnPeriodo == 0) { // No paso pedido en la campanya
                        UtilidadesLog.debug("     --> El cliente no paso pedido en la campanya... continuamos con siguiente cliente");
                        continue;
                    }
                    if (numCampSinPedi == 0 && !codEstatusActual.equals(ConstantesMAE.ESTATUS_REGISTRADO)) { // (Paso pedido pero...) Ya fue evaluado antes por cierre region (y fue insertada antes del cierre)
                        UtilidadesLog.debug("     --> El cliente (aunque sí pasó pedido) ya fue reevaluado al cierre... continuamos con siguiente cliente");
                        continue;
                    }
                    // Los que nos quedan y debemos reevaluar son aquellos que:
                    // - Pasaron pedido en la campanya pero SOLAMENTE luego del cierre 
                    //   de region (por eso su numero de campanyas sin hacer pedido es mayor a cero).
                    // - Aunque no tengan numero de campanyas sin hacer pedido mayor a cero,
                    //   tambien se incluye a reevaluar a clientes Insertados luego del cierre 
                    //   de region y que pasaron pedido.
                    UtilidadesLog.debug("     --> OK. Debemos reevaluar el Estatus del cliente_" + oidCliente);
                    
                    Long oidEstatusActualActualizado;
                    DTOEstados estados = new DTOEstados();
                    Long oidEstatusNuevoActualizado;
                    if (!codEstatusActual.equals(ConstantesMAE.ESTATUS_REGISTRADO)) {
                        // Si en el cierre de region se produjo un cambio de estatus
                        // lo detectamos y 'deshacemos' a traves del Historico de Estatus
                        oidEstatusActualActualizado = actualizarEstatusAAnteriorHistoricoPerf(oidCliente, oidEstatusActual, 
                                periodoActual, periodoAnterior);
                                
                        if (!oidEstatusActualActualizado.equals(oidEstatusActual)) {
                            //BLO-01 jrivas INICIO
                            estados = obtenerSiguienteEstadoPerf(oidEstatusActualActualizado, 
                                            true, 
                                            numCampSinPedi, 
                                            Short.valueOf(rs.getValueAt(i, "NUM_PERI_RETI").toString()).shortValue(),
                                            Short.valueOf(rs.getValueAt(i, "NUM_PERI_EGRE").toString()).shortValue());
                            
                            oidEstatusNuevoActualizado = estados.getOidNuevoEstado();
                            codEstatusNuevo = estados.getCodNuevoEstado();
                            codEstatusActual = estados.getCodEstadoActual();
                            //BLO-01 jrivas FIN
                            
                            oidEstatusActual = oidEstatusActualActualizado;
                            oidEstatusNuevo = oidEstatusNuevoActualizado;
                        }
                    }
                    
                    if (numCampSinPedi > 0) {
                        numCampSinPedi--;
                    }
                    
                }
                // MAE-014 CU Reasignar Estatus [fin]
                
                // Actualiza en DatosAdicionales el numero de campañas sin pedidos
                if (cantidadPedidosEnPeriodo > 0) {                             // Si paso pedido
                    numCampSinPedi = 0;
                } else {                                                        // No paso pedido
                    if (rs.getValueAt(i, "NUM_CAMP_SIN_PEDI") != null) {
                        numCampSinPedi = Short.valueOf(((BigDecimal) rs.getValueAt(i, "NUM_CAMP_SIN_PEDI")).toString()).shortValue();
                    } else {
                        numCampSinPedi = 0;
                    }
                    numCampSinPedi++;
                }
                
                if(log.isDebugEnabled()) {     
                    UtilidadesLog.debug("se va a actualizar NumCampSinPedi a: " + numCampSinPedi);
                
                    UtilidadesLog.debug("nivelGravedadBloqueo " + nivelGravedadBloqueo);
                    UtilidadesLog.debug("codEstatusActual " + codEstatusActual);
                    UtilidadesLog.debug("codEstatusNuevo " + codEstatusNuevo);
                }    
                
                // sapaza -- PER-SiCC-2010-0506 -- 15/11/2010
                //BLO-01 INICIO jrivas 15/11/2007
                if (nivelGravedadBloqueo > 0) {
                    Boolean validarStatus = null;
                    boolean bloqueoRealizado = false;
                    
                    if(!codEstatusActual.equals(ConstantesMAE.ESTATUS_REINGRESO) &&
                        codEstatusNuevo.equals(ConstantesMAE.ESTATUS_REINGRESO)) {
                        validarStatus = dao.validarHistoricoEstatus(periodoActual, oidCliente, ConstantesMAE.ESTATUS_REINGRESO);
                        
                        if(validarStatus)
                            bloqueoRealizado = dao.realizarBloqueos(periodoActual, oidCliente, nivelGravedadBloqueo);
                    }      
                
                    if (!bloqueoRealizado) {
                        if(validarStatus == null)
                            validarStatus = dao.validarHistoricoEstatus(periodoActual, oidCliente, ConstantesMAE.ESTATUS_REINGRESO);
                            
                        if(!validarStatus)                            
                            dao.realizarDesbloqueos(oidCliente);
                    }    
                }                
                //BLO-01 FIN

                if (oidEstatusActual.equals(oidEstatusNuevo)) {
                    /* gPineda - 09/03/2007 - SICC 20070092
                    // Actualizamos solamente el Numero de campanyas sin realizar pedido
                    armarUpdateDatosAdicionales(oidDatosAdicionales, numCampSinPedi, null, vUpdateDatosAdic);*/
                    this.armarUpdateDatosAdicionales(oidDatosAdicionales, numCampSinPedi, oidEstatusNuevo, vUpdateDatosAdic);
                } else {
                    // Actualizamos el Estatus y el Numero de campanyas sin realizar pedido
                    UtilidadesLog.debug("se va a actualizar Estatus: " + oidEstatusNuevo);
                    this.armarUpdateDatosAdicionales(oidDatosAdicionales, numCampSinPedi, oidEstatusNuevo, vUpdateDatosAdic);

                    // sapaza -- PER-SiCC-2010-0506 -- 15/11/2010
                    if (codEstatusNuevo.equals(ConstantesMAE.ESTATUS_REINGRESO))
                        armarUpdateDatosCliente(oidCliente, vUpdateDatosCliente);
                    
                    // Debemos guardar el cambio de estatus en el historico
                    clienAActualizar = new DTOClienteEvaluarEstado(oidCliente, oidEstatusNuevo);
                    clientesAActualizarHistEsta.put(oidCliente, clienAActualizar);
                }
            }  // Fin for
            
            UtilidadesLog.debug("Ejecutando Update sobre DatosAdicionales masivo...");
            this.invocarExecutor(vUpdateDatosAdic);  // Actualiza los registros de Datos Adicionales del Cliente
            this.invocarExecutor(vUpdateDatosCliente); // sapaza -- PER-SiCC-2010-0506 -- 15/11/2010
            
            this.guardarHistoricoEstatusLote(clientesAActualizarHistEsta, periodoActual);
            
        } catch (Exception e) {
            e.printStackTrace();
            sessionContext.setRollbackOnly();
            throw new MareException(e);
        }
        UtilidadesLog.info("MONEstatusCliente.actualizarEstatusRangoClientes(DTOBatch): Salida"); 
    }

    
   /**
    * Permite actualizar el Historico de Estatus para aquellos clientes que tuvieron
    * un cambio de estatus en este proceso.
    * @author eiraola
    * @date 15/Nov/2006
    * @observacion Metodo creado por performance
    */
    private void guardarHistoricoEstatusLote(Hashtable clientes, Long periodoActual) 
            throws MareException {
        UtilidadesLog.info("MONEstatusCliente.guardarHistoricoEstatusLotes(clientes, periodoActual): Entrada");
        
        Enumeration oidsCliente = clientes.keys();
        int cantClientes = clientes.size();
        UtilidadesLog.debug("*** Cantidad de clientes a actualizar HistoricoEstatus_" + cantClientes);
        
        if (cantClientes == 0) {
            UtilidadesLog.info("MONEstatusCliente.guardarHistoricoEstatusLotes(clientes, periodoActual): Salida (sin clientes)");
            return;
        }
        
        try {
            DAOCRA daoCra = new DAOCRA();
            Long periodoAnterior = daoCra.obtienePeriodoAnteriorActual(periodoActual);
            
            DAOMAEEstatusCliente daoEstatus = new DAOMAEEstatusCliente(sessionContext.getCallerPrincipal().getName());
            Hashtable clientesPorEstatus = agruparClientesPorEstatusNuevo(clientes);
            RecordSet historicos = daoEstatus.obtenerUltimoHistoricoLoteClientes(clientesPorEstatus, periodoActual);
            
            int cantHistoricos = historicos.getRowCount();
            UtilidadesLog.debug("***         se recuperaron Historicos Estatus: " + cantHistoricos);
            
            DTOClienteEvaluarEstado cliente;
            Long oidCliente;
            Long oidEstatusNuevo;
            Long oidHistoEstatus;
            Long oidPeriIni;
            Long anterior = null;
            
            // Solo tomaremos el primero de los n historicos recuperados
            UtilidadesLog.debug("****** Leyendo los datos de ultimos Historicos...");
            for (int j = 0; j < cantHistoricos; j++) {
                oidCliente = Long.valueOf(((BigDecimal)historicos.getValueAt(j, "CLIE_OID_CLIE")).toString());
                if (oidCliente.equals(anterior)) {
                    continue;  // Solo tomamos el primer historico de cada cliente
                }
                anterior = oidCliente;
                oidHistoEstatus = Long.valueOf(((BigDecimal)historicos.getValueAt(j, "OID_HIST_ESTA")).toString());
                oidPeriIni = Long.valueOf(((BigDecimal)historicos.getValueAt(j, "PERD_OID_PERI")).toString());
                cliente = (DTOClienteEvaluarEstado)clientes.get(oidCliente);
                cliente.setOidHistoricoEstatus(oidHistoEstatus);
                cliente.setOidPeriodoInicioHistoEstatus(oidPeriIni);
                clientes.put(oidCliente, cliente);
            }
            
            oidsCliente = clientes.keys();
            Vector vUpdateHistoEsta_PeriFin = new Vector();
            Vector vUpdateHistoEsta_Esta = new Vector();
            Vector vInsertHistoEsta = new Vector();
            Long oidHistoEstatusNuevo;
            
            UtilidadesLog.debug("****** Preparando los INSERT/UPDATE sobre HistoricoEstatus...");
            ArrayList clientesAActualizarHistoClasif = new ArrayList();
            
            while (oidsCliente.hasMoreElements()) {
                oidCliente = (Long)oidsCliente.nextElement();
                cliente = (DTOClienteEvaluarEstado)clientes.get(oidCliente);
                oidEstatusNuevo = cliente.getOidEstatusNuevo();
                oidHistoEstatus = cliente.getOidHistoricoEstatus();
                
                if (oidHistoEstatus == null) {
                    // Insertar un nuevo registro en Historico de Estatus
                    oidHistoEstatusNuevo = armarInsertHistoEstatus(periodoActual, oidCliente, oidEstatusNuevo, vInsertHistoEsta);
                    
                    cliente.setOidHistoricoEstatusNuevo(oidHistoEstatusNuevo); // Este nuevo oid de HistoEstatus lo guardamos para luego insertar HistoClasi
                    clientes.put(oidCliente, cliente);
                    
                    // Obtener las clasificaciones del cliente y luego insertar
                    // en Historico de Clasificaciones con oid del nuevo Historico de Estatus
                    clientesAActualizarHistoClasif.add(oidCliente);
                    
                } else { // El cliente tenia (al menos) un historico de estatus "abierto" (sin periodo de fin)
                    oidPeriIni = cliente.getOidPeriodoInicioHistoEstatus();
                    
                    if (oidPeriIni.equals(periodoActual)) {
                        // Actualizar solo el campo Estatus del registro de Historico de Estatus
                        armarUpdateEstatusHistoEstatus(oidHistoEstatus, oidEstatusNuevo, vUpdateHistoEsta_Esta);
                        
                    } else {
                        // Finalizar el registro de Historico de Estatus obtenido con periodo anterior
                        armarUpdatePeriFinHistoEstatus(oidHistoEstatus, periodoAnterior, vUpdateHistoEsta_PeriFin);
                        
                        // Insertar un nuevo registro en Historico de Estatus
                        oidHistoEstatusNuevo = armarInsertHistoEstatus(periodoActual, oidCliente, oidEstatusNuevo, vInsertHistoEsta);
                        
                        cliente.setOidHistoricoEstatusNuevo(oidHistoEstatusNuevo); // Este nuevo oid de HistoEstatus lo guardamos para luego insertar HistoClasi
                        clientes.put(oidCliente, cliente);
                        
                        // Obtener las clasificaciones del cliente y luego insertar
                        // en Historico de Clasificaciones con oid del nuevo Historico de Estatus
                        clientesAActualizarHistoClasif.add(oidCliente);                        
                    }
                }
            }
            
            UtilidadesLog.debug("*** Ejecutando Update del 'estatus' de HistoricoEstatus masivo...");
            invocarExecutor(vUpdateHistoEsta_Esta);   // Actualiza el Periodo Fin en los registros de Historico de Estatus del Cliente
            
            UtilidadesLog.debug("*** Ejecutando Update del 'periodo de fin' de HistoricoEstatus masivo...");
            invocarExecutor(vUpdateHistoEsta_PeriFin);      // Actualiza el Estatus en los registros de Historico de Estatus del Cliente
            
            UtilidadesLog.debug("*** Ejecutando Insert de HistoricoEstatus masivo...");
            invocarExecutor(vInsertHistoEsta);           // Inserta los Historicos de Estatus de los Clientes
            
            this.guardarHistoricoClasificacionesLote(clientes, clientesAActualizarHistoClasif);
            
        } catch (Exception e) {
            UtilidadesLog.error("Error al guardar HistoricoEstatus", e);
            throw new MareException(e, UtilidadesError.armarCodigoError(
                CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS));
        }
        UtilidadesLog.info("MONEstatusCliente.guardarHistoricoEstatusLotes(clientes, periodoActual): Salida");
    }
    
   /**
    * Para aquellos clientes que generaron un nuevo registro en Historico
    * de Estatus se inserta para cada una de sus clasificaciones en el Historico
    * de Clasificaciones.
    * @author eiraola
    * @date 15/Nov/2006
    * @observacion Metodo creado por performance
    */
    private void guardarHistoricoClasificacionesLote(Hashtable datosClientes, 
            ArrayList clientesAActualizarHistoClasi) throws MareException {
        UtilidadesLog.info("MONEstatusCliente.guardarHistoricoClasificacionesLote(clientes, periodoActual): Entrada");
        
        int cantClientes = clientesAActualizarHistoClasi.size();
        
        if (cantClientes == 0) {
            UtilidadesLog.info("MONEstatusCliente.guardarHistoricoClasificacionesLote(clientes, periodoActual): Salida (sin clientes)");
            return;
        }
        
        BelcorpService bs;
        
        try {
            bs = BelcorpService.getInstance();
        } catch (MareException me) {
            throw new MareException(me,
                UtilidadesError.armarCodigoError(
                    CodigosError.ERROR_AL_PEDIR_UN_SERVICIO_MARE));
        }
        
        try {
            DAOMAEEstatusCliente daoEstatus = new DAOMAEEstatusCliente(sessionContext.getCallerPrincipal().getName());
            RecordSet clasificaciones = daoEstatus.obtenerClasificacionesLoteClientes(clientesAActualizarHistoClasi);
            int cantTotalClasificaciones = clasificaciones.getRowCount();
            
            if (cantTotalClasificaciones == 0) {
                UtilidadesLog.info("MONEstatusCliente.guardarHistoricoClasificacionesLote(clientes, periodoActual): Salida (sin clasificaciones)");
                return;
            }
            
            StringBuffer insertHistoClasi = new StringBuffer();
            Long oidCliente;
            Long oidClasificacion;
            Long oidHistEstaInsertado;
            DTOClienteEvaluarEstado cliente;
            
            UtilidadesLog.debug("****** Preparando INSERT para Historico Clasificaciones...");
            for (int j = 0; j < cantTotalClasificaciones; j++) {
                oidCliente = Long.valueOf(((BigDecimal)clasificaciones.getValueAt(j, "CLIE_OID_CLIE")).toString());
                oidClasificacion = Long.valueOf(((BigDecimal)clasificaciones.getValueAt(j, "CLAS_OID_CLAS")).toString());
                
                cliente = (DTOClienteEvaluarEstado)datosClientes.get(oidCliente);
                oidHistEstaInsertado = cliente.getOidHistoricoEstatusNuevo();
                
                insertHistoClasi.append("INSERT INTO mae_histo_clasi (OID_HIST_CLAS, CLHE_OID_HIST_ESTA, CLAS_OID_CLAS) ");
                insertHistoClasi.append("VALUES (MAE_HTCL_SEQ.nextval, " + oidHistEstaInsertado + ", " + oidClasificacion + ");");
            }
            
            UtilidadesLog.debug("*** Ejecutando Insert de HistoricoClasificacion masivo...");
            bs.dbService.executeProcedure("PQ_PLANI.EXECUTOR", insertHistoClasi.toString());
            
        } catch (Exception e) {
            UtilidadesLog.error("Error al guardar HistoricoClasificaciones", e);
            throw new MareException(e, UtilidadesError.armarCodigoError(
                CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS));
        }
        UtilidadesLog.info("MONEstatusCliente.guardarHistoricoClasificacionesLote(clientes, periodoActual): Salida");
    }
    
    private void armarUpdateDatosAdicionales(Long oidDatosAdic, short numCampSinPedi, 
            Long estatus, Vector vUpdateDatosAdic) throws MareException {
        
        StringBuffer updateDatosAdic = new StringBuffer();
        updateDatosAdic.append("UPDATE MAE_CLIEN_DATOS_ADICI");
        updateDatosAdic.append(" SET NUM_CAMP_SIN_PEDI = "+ numCampSinPedi);    // Este campo siempre se actualiza
        
        if (estatus != null) {
            updateDatosAdic.append(" , ESTA_OID_ESTA_CLIE = " + estatus + " ");
        }
        updateDatosAdic.append(" WHERE OID_CLIE_DATO_ADIC = " + oidDatosAdic + ";");
        vUpdateDatosAdic.add(updateDatosAdic);  // Acumulo los Update en este Vector que existe fuera del método
    }

    private void armarUpdateEstatusHistoEstatus(Long oidHistoEstatus, Long oidEstatusNuevo, 
            Vector vUpdateHistoEstatus) throws MareException {
        
        StringBuffer updateHistoEstatus = new StringBuffer();
        updateHistoEstatus.append("UPDATE mae_clien_histo_estat");
        updateHistoEstatus.append(" SET ESTA_OID_ESTA_CLIE = " + oidEstatusNuevo);
        updateHistoEstatus.append(" WHERE OID_HIST_ESTA = " + oidHistoEstatus + ";");
        
        vUpdateHistoEstatus.add(updateHistoEstatus);  // Acumulo los Update en este Vector que existe fuera del método
    }
    
    private void armarUpdatePeriFinHistoEstatus(Long oidHistoEstatus, Long periodoAnterior, 
            Vector vUpdateHistoEstatus) throws MareException {
        
        StringBuffer updateHistoEstatus = new StringBuffer();
        updateHistoEstatus.append("UPDATE mae_clien_histo_estat SET");
        updateHistoEstatus.append(" PERD_OID_PERI_PERI_FIN = " + periodoAnterior);
        updateHistoEstatus.append(" WHERE OID_HIST_ESTA = " + oidHistoEstatus + ";");
        
        vUpdateHistoEstatus.add(updateHistoEstatus);  // Acumulo los Update en este Vector que existe fuera del método
    }
    
    private Long armarInsertHistoEstatus(Long periodoActual, Long oidCliente, 
            Long oidEstatusNuevo, Vector vInsertHistoEstatus) throws MareException {
        
        Long oidHistoEstatusNuevo = SecuenciadorOID.obtenerSiguienteValor("MAE_CLHE_SEQ");
        
        StringBuffer insertHistoEstatus = new StringBuffer();
        insertHistoEstatus.append("INSERT INTO mae_clien_histo_estat (OID_HIST_ESTA,");
        insertHistoEstatus.append(" PERD_OID_PERI, PERD_OID_PERI_PERI_FIN,");
        insertHistoEstatus.append(" CLIE_OID_CLIE, ESTA_OID_ESTA_CLIE) ");
        insertHistoEstatus.append(" VALUES (" + oidHistoEstatusNuevo + ", ");
        insertHistoEstatus.append(  periodoActual + ", null, ");
        insertHistoEstatus.append(  oidCliente + ", " + oidEstatusNuevo + ");");
        
        vInsertHistoEstatus.add(insertHistoEstatus);  // Acumulo los Update en este Vector que existe fuera del método
        return oidHistoEstatusNuevo;    
    }
    
    private Hashtable agruparClientesPorEstatusNuevo(Hashtable clientes) throws MareException {
        UtilidadesLog.info("MONEstatusCliente.agruparPorEstatusNuevo(clientes): Entrada");
        Hashtable clientesAgrupadosPorEstatusNuevo = new Hashtable();
        ArrayList grupoClientes;
        Enumeration oidsCliente = clientes.keys();
        
        Long oidCliente;
        DTOClienteEvaluarEstado cliente;
        Long oidEstatusNuevo;
            
        while (oidsCliente.hasMoreElements()) {
            oidCliente = (Long)oidsCliente.nextElement();
            cliente = (DTOClienteEvaluarEstado)clientes.get(oidCliente);
            oidEstatusNuevo = cliente.getOidEstatusNuevo();
            
            grupoClientes = (ArrayList)clientesAgrupadosPorEstatusNuevo.get(oidEstatusNuevo);
            
            if (grupoClientes == null) {
                grupoClientes = new ArrayList();
            }
            grupoClientes.add(oidCliente);
            clientesAgrupadosPorEstatusNuevo.put(oidEstatusNuevo, grupoClientes);
        }
        
        // A continuacion recorro solamente para la traza
        Enumeration estatuses = clientesAgrupadosPorEstatusNuevo.keys();
        while (estatuses.hasMoreElements()) {
            oidEstatusNuevo = (Long)estatuses.nextElement();
            grupoClientes = (ArrayList)clientesAgrupadosPorEstatusNuevo.get(oidEstatusNuevo);
            UtilidadesLog.debug("Se formo un grupo para el estatus " + oidEstatusNuevo 
                                + " con " + grupoClientes.size() + " clientes.");
        }
        
        UtilidadesLog.info("MONEstatusCliente.agruparPorEstatusNuevo(clientes): Salida");
        return clientesAgrupadosPorEstatusNuevo;    
    }
    
    private Long actualizarEstatusAAnteriorHistoricoPerf(Long oidCliente, Long oidEstatusActual, 
            Long periodoActual, Long periodoAnterior) throws MareException {
        UtilidadesLog.info("MONEstatusCliente.actualizarEstatusAAnteriorHistoricoPerf(periodoActual, oidCliente, estatusActual): Entrada");
        UtilidadesLog.debug(" --- clienteOid_" + oidCliente + " periodoActual_" + periodoActual + " estatusActual_" + oidEstatusActual);
        
        ClienteHistoricoEstatusLocalHome clienteHistoEstatusHome = new ClienteHistoricoEstatusLocalHome();
        ClienteHistoricoEstatusLocal histoEstatus = null;
        EstatusClienteLocalHome estatusClienteHome = new EstatusClienteLocalHome();
        EstatusClienteLocal estatusCliente = null;
        
        try {
            histoEstatus = clienteHistoEstatusHome.findByUK(oidCliente, periodoActual);
        } catch (NoResultException nre) {
            UtilidadesLog.debug(" No se encontro HistoricoEstatus para cliente y periodoActual");
            UtilidadesLog.info("MONEstatusCliente.actualizarEstatusAAnteriorHistoricoPerf(periodoActual, oidCliente, estatusActual): Salida A");
            return oidEstatusActual;
        } catch (PersistenceException pe) {
            sessionContext.setRollbackOnly();
            throw new MareException(pe, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS));
        }
        UtilidadesLog.debug("     histoEstatus_" + histoEstatus + " estatus_" + histoEstatus.getEsta_oid_esta_clie());
                        
        // Eliminar de BBDD el registro del Historico de Estatus de Clientes
        try {
            //  Agregado por HRCS - Fecha 01/03/2007 - Incidencia SICC 20070072
            UtilidadesLog.debug("       eliminando los registros HistoricoClasificacion cuyo oid historicoEstatus es_" + histoEstatus.getOid());
            DAOMAEEstatusCliente daoEstaClien = new DAOMAEEstatusCliente(sessionContext.getCallerPrincipal().getName());
            daoEstaClien.borraClientHistoClasi( histoEstatus.getOid() );
            
            UtilidadesLog.debug("     eliminando el HistoricoEstatus cuyo oid de historico es_" + histoEstatus.getOid());
            clienteHistoEstatusHome.remove(histoEstatus);
        } catch (PersistenceException pe) {
            sessionContext.setRollbackOnly();
            throw new MareException(pe, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS));
        }
        
        // Actualizar el anterior estatus del cliente
        ClienteHistoricoEstatusLocal histoEstatusAnterior = null;
        try {
            histoEstatusAnterior = clienteHistoEstatusHome.findHistoricoPorPeriodoFin(oidCliente, periodoAnterior);
        } catch (NoResultException nre) {
            UtilidadesLog.debug(" No se encontro HistoricoEstatus para cliente y periodoAnterior");
            UtilidadesLog.info("MONEstatusCliente.actualizarEstatusAAnteriorHistoricoPerf(periodoActual, oidCliente, estatusActual): Salida B");
            return oidEstatusActual;
        } catch (PersistenceException pe) {
            sessionContext.setRollbackOnly();
            throw new MareException(pe, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS));
        }
        
        BelcorpService bs;
        
        try {
            bs = BelcorpService.getInstance();
        } catch (MareException me) {
            throw new MareException(me,
                UtilidadesError.armarCodigoError(
                    CodigosError.ERROR_AL_PEDIR_UN_SERVICIO_MARE));
        }
        try {
            UtilidadesLog.debug("     actualizando periodo de fin a null para el Historico anterior");
            StringBuffer updateRehabilitarHistoEstatus = new StringBuffer();
            updateRehabilitarHistoEstatus.append("UPDATE mae_clien_histo_estat SET");
            updateRehabilitarHistoEstatus.append(" PERD_OID_PERI_PERI_FIN = null ");
            updateRehabilitarHistoEstatus.append(" WHERE OID_HIST_ESTA = " + histoEstatusAnterior.getOid());
            
            bs.dbService.executeUpdate(updateRehabilitarHistoEstatus.toString());
        } catch (Exception e) {
            throw new MareException(e, 
                UtilidadesError.armarCodigoError(
                    CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS));
        }
        
        UtilidadesLog.info("MONEstatusCliente.actualizarEstatusAAnteriorHistoricoPerf(periodoActual, oidCliente, oidEstatusActual): Salida C");
        return histoEstatusAnterior.getEsta_oid_esta_clie();
    }
    
    //BLO-001 jrivas 15/11/2007    
    private DTOEstados obtenerSiguienteEstadoPerf(Long oidEstatusActual, boolean pasoPedido, 
            short numCampSinPedi, short numPeriodosRetiro, short numPeriodosEgreso) throws Exception {
        UtilidadesLog.info("MONEstatusCliente.obtenerSiguienteEstadoPerf(...): Entrada");
        short numPeriodosSinPedido = numCampSinPedi;
        EstatusClienteLocalHome estatusHome = new EstatusClienteLocalHome();
        EstatusClienteLocal estatus = null;
        try {
            estatus = estatusHome.findByPrimaryKey(oidEstatusActual);
        } catch (NoResultException nre) {
            sessionContext.setRollbackOnly();
            UtilidadesLog.error("No se encontro el Codigo de Estatus");
            throw new MareException(nre, UtilidadesError.armarCodigoError(
                CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE));
        } catch (PersistenceException pe) {
            sessionContext.setRollbackOnly();
            throw new MareException(pe, UtilidadesError.armarCodigoError(
                CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS));
        }
        String estatusActual = estatus.getCod_esta_clie();
        String estatusNuevo;
                    
        if (pasoPedido) {
            if (estatusActual.equals(ConstantesMAE.ESTATUS_REGISTRADO)) {
                estatusNuevo = ConstantesMAE.ESTATUS_NUEVO;
            } else if (estatusActual.equals(ConstantesMAE.ESTATUS_NUEVO)) {
                estatusNuevo = ConstantesMAE.ESTATUS_NORMAL;
            } else if (estatusActual.equals(ConstantesMAE.ESTATUS_NORMAL)) {
                estatusNuevo = ConstantesMAE.ESTATUS_NORMAL;
            } else if (estatusActual.equals(ConstantesMAE.ESTATUS_EGRESANTE)) {
                estatusNuevo = ConstantesMAE.ESTATUS_NORMAL;
            } else if (estatusActual.equals(ConstantesMAE.ESTATUS_EGRESADA) && (numPeriodosSinPedido <= numPeriodosRetiro)) {
                estatusNuevo = ConstantesMAE.ESTATUS_REINGRESO;
            } else if (estatusActual.equals(ConstantesMAE.ESTATUS_REINGRESO)) {
                estatusNuevo = ConstantesMAE.ESTATUS_NORMAL;
            } else if (estatusActual.equals(ConstantesMAE.ESTATUS_RETIRADO)) {
                estatusNuevo = ConstantesMAE.ESTATUS_REACTIVADO;
            } else if (estatusActual.equals(ConstantesMAE.ESTATUS_REACTIVADO)) {
                estatusNuevo = ConstantesMAE.ESTATUS_NORMAL;
            } else {
                estatusNuevo = estatusActual;
            }
        } else {
            numPeriodosSinPedido++;
            UtilidadesLog.debug("***numPeriodosSinPedido++: "+ numPeriodosSinPedido);
            
            if (estatusActual.equals(ConstantesMAE.ESTATUS_NUEVO) && (numPeriodosSinPedido == 1)) {
                estatusNuevo = ConstantesMAE.ESTATUS_EGRESANTE;
            } else if (estatusActual.equals(ConstantesMAE.ESTATUS_NORMAL) && (numPeriodosSinPedido == 1)) {
                estatusNuevo = ConstantesMAE.ESTATUS_EGRESANTE;
            } else if (estatusActual.equals(ConstantesMAE.ESTATUS_EGRESANTE) && (numPeriodosSinPedido >= numPeriodosEgreso)) {
                estatusNuevo = ConstantesMAE.ESTATUS_EGRESADA;
            } else if (estatusActual.equals(ConstantesMAE.ESTATUS_EGRESADA) && (numPeriodosSinPedido >= numPeriodosRetiro)) {
                estatusNuevo = ConstantesMAE.ESTATUS_RETIRADO;
            } else if (estatusActual.equals(ConstantesMAE.ESTATUS_REINGRESO) && (numPeriodosSinPedido == 1)) {
                estatusNuevo = ConstantesMAE.ESTATUS_EGRESANTE;
            } else if (estatusActual.equals(ConstantesMAE.ESTATUS_REACTIVADO) && (numPeriodosSinPedido == 1)) {
                estatusNuevo = ConstantesMAE.ESTATUS_EGRESANTE;
            } else if(estatusActual.equals(ConstantesMAE.ESTATUS_EGRESANTE) && (numPeriodosSinPedido <= numPeriodosEgreso)){
                estatusNuevo = ConstantesMAE.ESTATUS_EGRESANTE;
            } else if(estatusActual.equals(ConstantesMAE.ESTATUS_EGRESADA) && (numPeriodosSinPedido < numPeriodosRetiro)){
                estatusNuevo = ConstantesMAE.ESTATUS_EGRESADA;
            } else {
                estatusNuevo = estatusActual;
            }
        }
        
        try {
            estatus = estatusHome.findByCodigo(estatusNuevo);
        } catch (NoResultException nre) {
            sessionContext.setRollbackOnly();
            UtilidadesLog.error("No se encontro Estatus con el codigo indicado");
            throw new MareException(nre, UtilidadesError.armarCodigoError(
                CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE));
        } catch (PersistenceException pe) {
            sessionContext.setRollbackOnly();
            throw new MareException(pe, UtilidadesError.armarCodigoError(
                CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS));
        }
        DTOEstados salida = new DTOEstados();
        //BLO-01 jrivas 15/11/2007
        salida.setOidNuevoEstado(estatus.getOid());
        salida.setCodNuevoEstado(estatusNuevo);
        salida.setCodEstadoActual(estatusActual);
        UtilidadesLog.info("MONEstatusCliente.obtenerSiguienteEstadoPerf(...): Salida");
        return salida;
    }

  /**
   * Sistema: Belcorp
   * Módulo:  MAE
   * Fecha:   29/01/2008
   * @version 1.00
   * @autor   Viviana Bongiovanni
   * Cambio 20070458
   */
  public DTOSalida obtienePeriodoActualReasigEstatus(DTOPeriodo dtoe) throws MareException {
    UtilidadesLog.info("MONEstatusCliente.obtienePeriodoActualReasigEstatus(DTOPeriodo dtoe): Entrada");
    DAOMAEEstatusCliente daoMAEEstatusCliente = new DAOMAEEstatusCliente(sessionContext.getCallerPrincipal().getName());
    DTOSalida dtoSalida = daoMAEEstatusCliente.obtienePeriodoActualReasigEstatus(dtoe);
    UtilidadesLog.info("MONEstatusCliente.obtienePeriodoActualReasigEstatus(DTOPeriodo dtoe): Salida");
    return dtoSalida;
  }

    // sapaza -- PER-SiCC-2010-0506 -- 15/11/2010    
    private void armarUpdateDatosCliente(Long oidCliente, Vector vUpdateDatosCliente) {
        StringBuffer query = new StringBuffer("UPDATE MAE_CLIEN SET FEC_REIN = SYSDATE");
        query.append(" WHERE OID_CLIE = " + oidCliente + ";");
        
        vUpdateDatosCliente.add(query);
    } 
  
    // sapaza -- COL-SiCC-2015-0051 -- 30/03/2015
    private void armarUpdateDesbloqueoCliente (String clientes, Long oidPais, Vector vExecutor) throws MareException {
        UtilidadesLog.info("MONEstatusCliente.armarUpdateDesbloqueoCliente(String): Entrada"); 

        RecordSet resultado = null;
        StringBuffer update = new StringBuffer();
        update.append("UPDATE MAE_CLIEN_BLOQU ");
        update.append("   SET FEC_DESB = SYSDATE, ");
        update.append("       MAAB_OID_VALO_ACCI_DESB = MAAB_OID_VALO_ACCI_BLOQ, ");
        update.append("       OBS_DESB = 'Desbloqueo automatico al inactivar cliente' ");
        update.append(" WHERE FEC_DESB IS NULL ");
        update.append("   AND TIBQ_OID_TIPO_BLOQ IN (SELECT blo.oid_tipo_bloq ");
        update.append("          FROM MAE_TIPO_BLOQU blo, MAE_TIPO_BLOQU_DESBL des,SEG_PAIS pai ");
        update.append("         WHERE blo.cod_tipo_bloq = des.tibq_cod_tipo_bloq ");
        update.append("           and des.pais_cod_pais = pai.cod_pais ");
        update.append("           and des.ind_acti = 1 ");
        update.append("           and pai.oid_pais = " + oidPais + ") ");
        update.append("   AND CLIE_OID_CLIE in ( " + clientes);
        update.append(" );");
        
        vExecutor.add(vExecutor.size(),update);
        
        UtilidadesLog.info("MONEstatusCliente.armarUpdateDesbloqueoCliente(String): Salida"); 

    }
    
}