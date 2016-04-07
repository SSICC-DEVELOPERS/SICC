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
import es.indra.mare.common.mii.MareMiiServiceNotFoundException;
import es.indra.mare.common.mii.services.jdbcservice.RecordSet;

import es.indra.sicc.cmn.negocio.auditoria.DTOAuditableSICC;
import es.indra.sicc.cmn.negocio.i18n.Entidadi18nLocal;
import es.indra.sicc.cmn.negocio.i18n.Entidadi18nLocalHome;
import es.indra.sicc.cmn.negocio.validacion.MONValidacion;
import es.indra.sicc.cmn.negocio.validacion.MONValidacionHome;
import es.indra.sicc.dtos.car.DTOCalculoPedidos;
import es.indra.sicc.dtos.car.DTOCreditoRiesgo;
import es.indra.sicc.dtos.ccc.DTODias;
import es.indra.sicc.dtos.ccc.DTOSaldosPorDiasPeriodos;
import es.indra.sicc.dtos.ccc.DTOSaldosPorFechas;
import es.indra.sicc.dtos.ccc.DTOSaldosPorFechasyVtos;
import es.indra.sicc.dtos.ccc.DTOTotal;
import es.indra.sicc.dtos.ccc.DTOTotalyDias;
import es.indra.sicc.dtos.cob.DTODatosClienteCOB;
import es.indra.sicc.dtos.cra.DTOPeriodo;
import es.indra.sicc.dtos.mae.DTOBuscarClienteBloqueo;
import es.indra.sicc.dtos.mae.DTOBuscarClientesCursos;
import es.indra.sicc.dtos.mae.DTOBusquedaRapidaCliente;
import es.indra.sicc.dtos.mae.DTOClasificacionCliente;
import es.indra.sicc.dtos.mae.DTOClasificaciones;
import es.indra.sicc.dtos.mae.DTOCliente;
import es.indra.sicc.dtos.mae.DTOClienteMarca;
import es.indra.sicc.dtos.mae.DTOClienteSubtipos;
import es.indra.sicc.dtos.mae.DTOClientesAsignarAptas;
import es.indra.sicc.dtos.mae.DTOCodigoCliente;
import es.indra.sicc.dtos.mae.DTOComunicacion;
import es.indra.sicc.dtos.mae.DTOConsultaCliente;
import es.indra.sicc.dtos.mae.DTOCrearClienteBasico;
import es.indra.sicc.dtos.mae.DTOCrearLotesClientes;
import es.indra.sicc.dtos.mae.DTODireccion;
import es.indra.sicc.dtos.mae.DTOGenerarCodigoCliente;
import es.indra.sicc.dtos.mae.DTOIdentificacion;
import es.indra.sicc.dtos.mae.DTOModificarCliente;
import es.indra.sicc.dtos.mae.DTOObservacion;
import es.indra.sicc.dtos.mae.DTOObtenerPestanya4;
import es.indra.sicc.dtos.mae.DTOPestanya1Base;
import es.indra.sicc.dtos.mae.DTOPestanya2;
import es.indra.sicc.dtos.mae.DTOPestanya2Base;
import es.indra.sicc.dtos.mae.DTOPestanya3;
import es.indra.sicc.dtos.mae.DTOPestanya3Base;
import es.indra.sicc.dtos.mae.DTOPestanya4;
import es.indra.sicc.dtos.mae.DTOPestanyaBusqueda1;
import es.indra.sicc.dtos.mae.DTOPreferencia;
import es.indra.sicc.dtos.mae.DTOPremioRecomendacion;
import es.indra.sicc.dtos.mae.DTOProblemaSolucion;
import es.indra.sicc.dtos.mae.DTOPsicografia;
import es.indra.sicc.dtos.mae.DTOREPClienteDatosBasicos;
import es.indra.sicc.dtos.mae.DTOREPCobranzas;
import es.indra.sicc.dtos.mae.DTOREPCredito;
import es.indra.sicc.dtos.mae.DTOREPCuentasCorrientes;
import es.indra.sicc.dtos.mae.DTOREPHistorialCreditoCliente;
import es.indra.sicc.dtos.mae.DTOREPSolicitudMasAntiguaNoCancelada;
import es.indra.sicc.dtos.mae.DTOREPSolicitudesBloqueadas;
import es.indra.sicc.dtos.mae.DTOTarjeta;
import es.indra.sicc.dtos.mae.DTOTipoSubtipo;
import es.indra.sicc.dtos.mae.DTOTipoSubtipoCliente;
import es.indra.sicc.dtos.mae.DTOValidarClientes;
import es.indra.sicc.dtos.mae.DTOVinculo;
import es.indra.sicc.dtos.msg.DTOBuzonMensajes;
import es.indra.sicc.dtos.ped.DTONumeroSolicitud;
import es.indra.sicc.dtos.zon.DTOELocalizacionDirecciones;
import es.indra.sicc.dtos.zon.DTOUBIGEO;
import es.indra.sicc.dtos.zon.DTOUBIGEOS;
import es.indra.sicc.dtos.zon.DTOUnidadAdministrativa;
import es.indra.sicc.entidades.car.AsignacionEjecutivoCuentaLocal;
import es.indra.sicc.entidades.car.EjecutivosCuentaLocal;
import es.indra.sicc.entidades.cra.PeriodoLocal;
import es.indra.sicc.entidades.cra.PeriodoLocalHome;
import es.indra.sicc.entidades.edu.MatrizCursosLocal;
import es.indra.sicc.entidades.mae.ClienteBloqueoLocal;
import es.indra.sicc.entidades.mae.ClienteBloqueoLocalHome;
import es.indra.sicc.entidades.mae.ClienteClasificacionLocal;
import es.indra.sicc.entidades.mae.ClienteClasificacionLocalHome;
import es.indra.sicc.entidades.mae.ClienteComunicacionLocal;
import es.indra.sicc.entidades.mae.ClienteComunicacionLocalHome;
import es.indra.sicc.entidades.mae.ClienteDatosAdicionalesLocal;
import es.indra.sicc.entidades.mae.ClienteDatosAdicionalesLocalHome;
import es.indra.sicc.entidades.mae.ClienteDatosBasicosLocal;
import es.indra.sicc.entidades.mae.ClienteDatosBasicosLocalHome;
import es.indra.sicc.entidades.mae.ClienteDireccionLocal;
import es.indra.sicc.entidades.mae.ClienteDireccionLocalHome;
import es.indra.sicc.entidades.mae.ClienteHistoricoEstatusLocal;
import es.indra.sicc.entidades.mae.ClienteHistoricoEstatusLocalHome;
import es.indra.sicc.entidades.mae.ClienteIdentificacionLocal;
import es.indra.sicc.entidades.mae.ClienteIdentificacionLocalHome;
import es.indra.sicc.entidades.mae.ClienteMarcaLocal;
import es.indra.sicc.entidades.mae.ClienteMarcaLocalHome;
import es.indra.sicc.entidades.mae.ClienteObservacionLocal;
import es.indra.sicc.entidades.mae.ClienteObservacionLocalHome;
import es.indra.sicc.entidades.mae.ClientePreferenciaLocal;
import es.indra.sicc.entidades.mae.ClientePreferenciaLocalHome;
import es.indra.sicc.entidades.mae.ClientePrimerContactoLocal;
import es.indra.sicc.entidades.mae.ClientePrimerContactoLocalHome;
import es.indra.sicc.entidades.mae.ClienteProblemaLocal;
import es.indra.sicc.entidades.mae.ClienteProblemaLocalHome;
import es.indra.sicc.entidades.mae.ClientePsicografiasLocal;
import es.indra.sicc.entidades.mae.ClientePsicografiasLocalHome;
import es.indra.sicc.entidades.mae.ClienteTarjetaLocal;
import es.indra.sicc.entidades.mae.ClienteTarjetaLocalHome;
import es.indra.sicc.entidades.mae.ClienteTipoSubTipoLocal;
import es.indra.sicc.entidades.mae.ClienteTipoSubTipoLocalHome;
import es.indra.sicc.entidades.mae.ClienteUnidadAdministrativaLocal;
import es.indra.sicc.entidades.mae.ClienteUnidadAdministrativaLocalHome;
import es.indra.sicc.entidades.mae.ClienteVinculoLocal;
import es.indra.sicc.entidades.mae.ClienteVinculoLocalHome;
import es.indra.sicc.entidades.mae.CriterioBusquedaLocal;
import es.indra.sicc.entidades.mae.CriterioBusquedaLocalHome;
import es.indra.sicc.entidades.mae.ParametrosClientesLocal;
import es.indra.sicc.entidades.mae.PesosModulo11Local;
import es.indra.sicc.entidades.mae.TipoBloqueoLocal;
import es.indra.sicc.entidades.mae.TipoBloqueoLocalHome;
import es.indra.sicc.entidades.mae.TipoClasificacionLocal;
import es.indra.sicc.entidades.mae.TipoClasificacionLocalHome;
import es.indra.sicc.entidades.mae.TipoVinculoLocal;
import es.indra.sicc.entidades.mae.TipoVinculoLocalHome;
import es.indra.sicc.entidades.ped.AtributosEspecialesLocal;
import es.indra.sicc.entidades.ped.AtributosEspecialesLocalHome;
import es.indra.sicc.entidades.ped.ClaseSolicitudLocal;
import es.indra.sicc.entidades.ped.ClaseSolicitudLocalHome;
import es.indra.sicc.entidades.seg.MarcaLocal;
import es.indra.sicc.entidades.seg.MarcaLocalHome;
import es.indra.sicc.entidades.zon.RegionLocal;
import es.indra.sicc.entidades.zon.RegionLocalHome;
import es.indra.sicc.entidades.zon.SeccionLocal;
import es.indra.sicc.entidades.zon.SeccionLocalHome;
import es.indra.sicc.entidades.zon.TerritorioAdministrativoLocal;
import es.indra.sicc.entidades.zon.TerritorioAdministrativoLocalHome;
import es.indra.sicc.entidades.zon.ValoresEstructuraGeopoliticaLocal;
import es.indra.sicc.entidades.zon.ValoresEstructuraGeopoliticaLocalHome;
import es.indra.sicc.entidades.zon.ZonaLocal;
import es.indra.sicc.entidades.zon.ZonaLocalHome;
import es.indra.sicc.logicanegocio.car.MONCreditoRiesgo;
import es.indra.sicc.logicanegocio.car.MONCreditoRiesgoHome;
import es.indra.sicc.logicanegocio.ccc.MONInterfaceModulos;
import es.indra.sicc.logicanegocio.ccc.MONInterfaceModulosHome;
import es.indra.sicc.logicanegocio.ccc.MONMantenimientoCCC;
import es.indra.sicc.logicanegocio.cra.MONPeriodos;
import es.indra.sicc.logicanegocio.cra.MONPeriodosHome;
import es.indra.sicc.logicanegocio.mae.DAOMAEMaestroClientes;
import es.indra.sicc.logicanegocio.msg.MONGestionMensajes;
import es.indra.sicc.logicanegocio.ped.DAOSolicitud;
import es.indra.sicc.logicanegocio.ped.MONProcesosPED;
import es.indra.sicc.logicanegocio.ped.MONProcesosPEDHome;
import es.indra.sicc.logicanegocio.seg.ConstantesSEG;
import es.indra.sicc.logicanegocio.seg.MONMantenimientoSEG;
import es.indra.sicc.logicanegocio.seg.MONMantenimientoSEGHome;
import es.indra.sicc.logicanegocio.zon.DAOZON;
import es.indra.sicc.logicanegocio.zon.MONEstructuraVial;
import es.indra.sicc.logicanegocio.zon.MONEstructuraVialHome;
import es.indra.sicc.logicanegocio.zon.MONReterritorializacionLocal;
import es.indra.sicc.logicanegocio.zon.MONReterritorializacionLocalHome;
import es.indra.sicc.logicanegocio.zon.MONUnidadesAdministrativas;
import es.indra.sicc.logicanegocio.zon.MONUnidadesAdministrativasHome;
import es.indra.sicc.util.BelcorpService;
import es.indra.sicc.util.CAREjbLocators;
import es.indra.sicc.util.CCCEjbLocators;
import es.indra.sicc.util.CRAEjbLocators;
import es.indra.sicc.util.CodigosError;
import es.indra.sicc.util.DTOBelcorp;
import es.indra.sicc.util.DTOBoolean;
import es.indra.sicc.util.DTOColeccion;
import es.indra.sicc.util.DTOOID;
import es.indra.sicc.util.DTOOIDs;
import es.indra.sicc.util.DTOSalida;
import es.indra.sicc.util.DTOString;
import es.indra.sicc.util.MAEEjbLocators;
import es.indra.sicc.util.MSGEjbLocators;
import es.indra.sicc.util.SEGEjbLocators;
import es.indra.sicc.util.UtilidadesEJB;
import es.indra.sicc.util.UtilidadesError;
import es.indra.sicc.util.UtilidadesI18N;
import es.indra.sicc.util.UtilidadesLog;
import es.indra.sicc.util.ZONEjbLocators;

import java.math.BigDecimal;

import java.rmi.RemoteException;

import java.sql.Date;
import java.sql.Timestamp;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Vector;

import javax.ejb.CreateException;
import javax.ejb.SessionBean;
import javax.ejb.SessionContext;

import javax.naming.InitialContext;
import javax.naming.NamingException;

import javax.rmi.PortableRemoteObject;
import es.indra.sicc.dtos.mae.DTOClienteIndicador;

import es.indra.sicc.dtos.inc.DTOBusquedaZonaTerritorioUA;

import es.indra.sicc.entidades.car.AsignacionEjecutivoCuentaLocalHome;
import es.indra.sicc.entidades.car.EjecutivosCuentaLocalHome;
import es.indra.sicc.entidades.mae.ParametrosClientesLocalHome;

import es.indra.sicc.entidades.mae.PesosModulo11LocalHome;

import es.indra.sicc.util.UtilidadesBD;

import javax.persistence.EntityExistsException;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceException;
import javax.persistence.RollbackException;

/*
 * rgiorgi - 19/8/2005: se formatea la clase.
 * */
public class MONClientesBean implements SessionBean, IMaestroClientes {
    private static final int NRO_POSICIONES_CON_PESO = 15;
    private static final int NRO_BASE = 11;
    private static final String OPE_MAE_CODCLIENTE = "MAECLT"; //inc.14013
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

    public Boolean hayClientesTerrAdm(Long terrAdm) throws MareException {
         UtilidadesLog.info("MONClientesBean.hayClientesTerrAdm(terrAdm): Entrada"); 
        /* Dada una unidad administrativa, se comprueba si tiene
         * algún cliente activo asociado.
         * Para ello llama al metodo obtenerClientesTerritorio del
         * DAOMAEMaestroClientes pasandole el parametro recibido y
         * devolvemos true si obtenemos un array con el
         * tamaño mayor que 0 o false en otro caso*/
        DAOMAEMaestroClientes daoMae = new DAOMAEMaestroClientes(sessionContext.getCallerPrincipal().getName());
        Long[] resultado = daoMae.obtenerClientesTerritorio(terrAdm);

        if (resultado.length > 0) {
            UtilidadesLog.info("MONClientesBean.hayClientesTerrAdm(terrAdm): Salida"); 
            return Boolean.TRUE;
        } else {
             UtilidadesLog.info("MONClientesBean.hayClientesTerrAdm(terrAdm): Salida"); 
            return Boolean.FALSE;
        }
    }

    public String calcularModaNSEConsultoras(DTOUnidadAdministrativa unidadAdministrativa) throws MareException {
        UtilidadesLog.info("MONClientesBean.calcularModaNSEConsultoras(DTOUnidadAdministrativa): Entrada"); 
        // Llama a calcularModaNSETerritorio de DAOMAEMaestroClientes
        // y obtiene el NSE con mayor moda. Devuelve esto, pero como String. 

        DAOMAEMaestroClientes dao = new DAOMAEMaestroClientes(sessionContext.getCallerPrincipal().getName());

        Long terrAdministrativo = unidadAdministrativa.getOidTerritorioAdministrativo();
        String NSEDevuelto = dao.calcularModaNSETerritorio(terrAdministrativo);

        UtilidadesLog.info("MONClientesBean.calcularModaNSEConsultoras(DTOUnidadAdministrativa): Salida " + NSEDevuelto); 

        return NSEDevuelto;
    }

    public Boolean hayConsultorasTerrAdm(Long[] territorios) throws MareException {
        UtilidadesLog.info("MONClientesBean.hayConsultorasTerrAdm(territorios): Entrada"); 
        DAOMAEMaestroClientes dao = new DAOMAEMaestroClientes(sessionContext.getCallerPrincipal().getName());
        Boolean res = new Boolean(dao.obtenerConsultorasTerritorios(territorios).length > 0);

        return res;
    }

    public Long obtenerOidCliente(Long pais, String codCliente) throws MareException {
        UtilidadesLog.info("MONClientesBean.obtenerOidCliente(pias, codigocliente): Entrada"); 
        DAOMAEMaestroClientes dao = new DAOMAEMaestroClientes(sessionContext.getCallerPrincipal().getName());
        UtilidadesLog.info("MONClientesBean.obtenerOidCliente(pias, codigocliente): Salida"); 
        return dao.obtenerOidCliente(pais, codCliente);
    }

    public DTOSalida listaClientesPais(DTOBelcorp dto) throws MareException {
        UtilidadesLog.info("MONClientesBean.listaClientesPais(DTOBelcorp): Entrada"); 
        UtilidadesLog.info("MONClientesBean.listaClientesPais(DTOBelcorp): Salida"); 
        return DAOMAEMaestroClientes.listaClientesPais(dto);
    }

    public Long[] obtenerConsultorasTerritorios(Long[] territorios) throws MareException {
        UtilidadesLog.info("MONClientesBean.obtenerConsultorasTerritorios(territorios): Entrada"); 
        DAOMAEMaestroClientes dao = new DAOMAEMaestroClientes(sessionContext.getCallerPrincipal().getName());
        UtilidadesLog.info("MONClientesBean.obtenerOidCliente.obtenerConsultorasTerritorios(territorios): Salida"); 

        return dao.obtenerConsultorasTerritorios(territorios);
    }

    public RecordSet listadoClientes() throws MareException {
        return null;
    }

    /*
    *  esCodigoClienteAutomatico : verifica si para el pais esta permitida la generacion automatica de lotes de clientes
    *
    *   @param dtoBelcorp -> DTO que contiene el oid del pais.(no hace falta el del idioma)
    */
    public DTOBoolean esCodigoClienteAutomatico(DTOBelcorp dtoBelcorp) throws MareException {
        UtilidadesLog.info("MONClientesBean.esCodigoClienteAutomatico(DTOBelcorp): Entrada"); 
        
        DTOBoolean dtoBoolean = new DTOBoolean();
        dtoBoolean.setValor(false);

        try {
            ParametrosClientesLocal parametrosClientesLocal = new ParametrosClientesLocalHome().findByPais(dtoBelcorp.getOidPais());

            // seteo el valor que me devuelve el metodo del entity
            dtoBoolean.setValor(parametrosClientesLocal.esAsignacionAutomatica());

            // tratamiento errors & exceptions
        } catch (NoResultException nre) {
            throw new MareException(nre, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE));
        } catch (PersistenceException exception) {
            throw new MareException(exception, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS));
        }
        UtilidadesLog.info("MONClientesBean.esCodigoClienteAutomatico(DTOBelcorp): Salida"); 

        return dtoBoolean;
    }

    /*
    *  crearLotesClientes : verifica si para el pais esta permitida la generacion automatica de lotes de clientes
    *
    *   @param DTOCrearLotesClientes dto -> DTO que contiene cantidad de clientes a generar.
    */
    public DTOSalida crearLotesClientes(DTOCrearLotesClientes dto) throws MareException {
        //se rediseña el metodo de acuerdo a la inc.: BELC300014756
        UtilidadesLog.info("MONClientesBean.crearLotesClientes(DTOCrearLotesClientes): Entrada"); 
        DTOBelcorp dtoBcrp = new DTOBelcorp();
        dtoBcrp.setOidPais(dto.getOidPais());

        UtilidadesLog.info("dentro de MONCLIENTES==>>crearLotesClientes, recibo: " + dto);

        Vector resultVec = new Vector();
        DTOSalida dtoSalida = new DTOSalida();

        //Por cada cliente que nos hayan pedido crear 
        try {
            ClienteDatosBasicosLocalHome clienteDatosBasicosLocalHome = getClienteDatosBasicosLocalHome();

            DTOGenerarCodigoCliente dtoGCC = null;

            for (int i = 0; i < dto.getNumClientes().intValue(); i++) {
                dtoGCC = this.generaCodigoCliente(dtoBcrp);
                UtilidadesLog.info("luego de llamar a this.generaCodigoCliente(..., obtengo: " + dtoGCC);

                //Llamamos a create del entity ClienteDatosBasicos pasandole como parametro:
                //-pais: el pais del dto
                //-codigoCliente: el valor de siguienteCodigo
                //-indFichaInscripcion: true
                UtilidadesLog.info("voy a crear sobre mae_clien.......");

                ClienteDatosBasicosLocal clienteDatosBasicosLocal = clienteDatosBasicosLocalHome.create(dto.getOidPais(), dtoGCC.getCodigoCliente(), true);
                clienteDatosBasicosLocal.setCod_digi_ctrl(dtoGCC.getDigitoControl());
                clienteDatosBasicosLocalHome.merge(clienteDatosBasicosLocal);

                //Guardamos el valor de siguienteCodigo en un recordset que vamos a devolver
                resultVec.add(new Long(dtoGCC.getCodigoCliente()));
            }
        //} catch (NamingException namingException) {
        //    sessionContext.setRollbackOnly();
        //    throw new MareException(namingException, UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
        } catch (PersistenceException pe) {
            sessionContext.setRollbackOnly();
            throw new MareException(pe, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS));
        }

        try {
            // asigno el dto de salida
            RecordSet resultados = new RecordSet();
            resultados.addColumn("codigo");

            for (int o = 0; o < resultVec.size(); o++) {
                resultados.addRow(new Long[] { (Long) resultVec.get(o) });
            }

            UtilidadesLog.info("\n\n**********************************************");

            for (int y = 0; y < resultados.getRowCount(); y++) {
                UtilidadesLog.info("resultado:" + y + "  valor:" + resultados.getValueAt(y, 0));
            }

            dtoSalida.setResultado(resultados);
        } catch (Exception exception) {
            sessionContext.setRollbackOnly();
            throw new MareException(exception, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS));
        }

        //Devolvemos la lista de codigos que hemos ido guardando, en forma de recordset
        UtilidadesLog.info("MONClientesBean.crearLotesClientes(DTOCrearLotesClientes): Salida"); 
        return dtoSalida;

        /*UtilidadesLog.info(" ********* MONCLIENTES ********");
        UtilidadesLog.info(" Metodo crearLotesClientes ");

        // inc 1415 : no se deben crear los datos adicionales para los clientes, debido a que se necesita un estado para la
        // creacion de los datos adicionales. El diseñador Gonzalo Herreros removio la linea  "Con el oid del entity creado
        // llamamos al create de ClienteDatosAdicionales y le pasamos el oid como clave foranea a ClienteDatosBasicos"
        DTOSalida dtoSalida = new DTOSalida();
        DAOMAEMaestroClientes dao = new DAOMAEMaestroClientes(sessionContext.getCallerPrincipal().getName());
        Long siguienteCodigo = dao.obtenerSiguienteCodigoPais(dto.getOidPais());
        UtilidadesLog.info(" primer cod a utilizar: " + siguienteCodigo);

        Vector resultVec = new Vector();

        try {
            // Obtengo el home de cliente datos basicos
            ClienteDatosBasicosLocalHome clienteDatosBasicosLocalHome = getClienteDatosBasicosLocalHome();
            clienteDatosBasicosLocalHome.parametrosAuditoria(dto);

            StringBuffer siguienteCodigo2 = new StringBuffer(siguienteCodigo.toString());

            MONMantenimientoSEGHome mmsHome = SEGEjbLocators.getMONMantenimientoSEGHome();
            Integer largo = mmsHome.create().obtenerLongitudNumeroCliente(dto.getOidPais());
            UtilidadesLog.info("antes del for " + siguienteCodigo2);
            UtilidadesLog.info("el largo es " + largo);

            if( siguienteCodigo2.length() < largo.intValue() ){
               for (int i = largo.intValue()-siguienteCodigo2.length(); i>0; i-- ){
                   siguienteCodigo2.insert(0,"0");
               }
            }
            UtilidadesLog.info("el codigo antes del for " + siguienteCodigo2);

            //Por cada cliente que nos hayan pedido crear
            for (int i = 0; i < dto.getNumClientes().intValue(); i++) {
                //Llamamos a create del entity ClienteDatosBasicos pasandole como parametro:
                //-pais: el pais del dto
                //-codigoCliente: el valor de siguienteCodigo
                //-indFichaInscripcion: true
                ClienteDatosBasicosLocal clienteDatosBasicosLocal = clienteDatosBasicosLocalHome.create(dto.getOidPais(), siguienteCodigo2.toString(), true);

                //Guardamos el valor de siguienteCodigo en un recordset que vamos a devolver
                resultVec.add(new Long(siguienteCodigo2.toString()));

                //Aumentamos en uno para el siguiente cliente
                siguienteCodigo2 = new StringBuffer((new Long((new Long(siguienteCodigo2.toString())).longValue() + 1L)).toString());
                UtilidadesLog.info("el codigo dentro del for " + siguienteCodigo2);

                if( siguienteCodigo2.length() < largo.intValue() ){
                   for (int x = largo.intValue()-siguienteCodigo2.length(); x>0; x-- ){
                      siguienteCodigo2.insert(0,"0");
                      UtilidadesLog.info("el codigo dentro del if del for " + siguienteCodigo2);
                   }
                }



            }
        } catch (NamingException namingException) {
            sessionContext.setRollbackOnly();
            throw new MareException(namingException,
                UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
        } catch (CreateException createException) {
            sessionContext.setRollbackOnly();
            throw new MareException(createException,
                UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS));
        } catch (Exception exception) {
            sessionContext.setRollbackOnly();
            throw new MareException(exception,
                UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS));
        }

        try {
            // asigno el dto de salida
            RecordSet resultados = new RecordSet();
            resultados.addColumn("codigo");

            for (int o = 0; o < resultVec.size(); o++) {
                resultados.addRow(new Long[] { (Long) resultVec.get(o) });

                //UtilidadesLog.info("");
            }

            UtilidadesLog.info("\n\n**********************************************");

            for (int y = 0; y < resultados.getRowCount(); y++) {
                UtilidadesLog.info("resultado:" + y + "  valor:" + resultados.getValueAt(y, 0));
            }

            dtoSalida.setResultado(resultados);
        } catch (java.lang.Exception exception) {
            sessionContext.setRollbackOnly();
            throw new MareException(exception,
                UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS));
        }

        //Devolvemos la lista de codigos que hemos ido guardando, en forma de recordset
        return dtoSalida;*/
    }

    public Long obtenerTerritorio(DTODireccion direccion, Boolean georeferenciador) throws MareException {
        UtilidadesLog.info("MONClientesBean.obtenerTerritorio(DTODIreccion, georeferenciados): Entrada"); 
        /* Inc. 2759
                if (direccion.getEsDireccionPrincipal().booleanValue() == false) {
                    throw new MareException(null, null,
                        UtilidadesError.armarCodigoError(CodigosError.ERROR_PARAMETROS_INCORRECTOS));
                }
        */
        UtilidadesLog.info("obtenerTerritorio");
        /* Cleal - 22361
        if (georeferenciador.booleanValue()) {
            throw new MareException(null, null, UtilidadesError.armarCodigoError(ConstantesSEG.MODULO_MAE, "", ErroresDeNegocio.IGEOREFERENCIADOR_NOT_READY));
        }
        */
        UtilidadesLog.info("*** georeferenciador: "+georeferenciador);
        if (Boolean.FALSE.equals(georeferenciador)) {
            
            DTOELocalizacionDirecciones dtoLD = new DTOELocalizacionDirecciones();
    
            dtoLD.setOidPais(direccion.getOidPais());
            dtoLD.setOidTipoVia(direccion.getTipoVia());
            dtoLD.setNombreVia(direccion.getNombreVia());
            dtoLD.setNumeroPortal((direccion.getNumeroPrincipal() != null) ? direccion.getNumeroPrincipal().toString() : "");
            dtoLD.setOidUGnivel(direccion.getUnidadGeografica());
            UtilidadesLog.info("******DTO LD " + dtoLD);
    
            try {
                UtilidadesLog.info("1");
    
                MONEstructuraVialHome mEVHome = ZONEjbLocators.getMONEstructuraVialHome();
                UtilidadesLog.info("2");
    
                DTOUBIGEOS dtoS = null;
    
                try {
                    dtoS = mEVHome.create().localizarDireccion(dtoLD);
                    UtilidadesLog.info("3");
                } catch (MareException re) {
                    //sessionContext.setRollbackOnly();
                    throw new MareException(null, null, UtilidadesError.armarCodigoError(ConstantesSEG.MODULO_MAE, "", ErroresDeNegocio.NO_EXISTE_NOMBRE_O_NUMERO_VIA));
                }
    
                Vector vUBIGEOS = dtoS.getDtoUbigeoVec();
                vUBIGEOS.trimToSize();
                UtilidadesLog.info("4");
                
                //Se comenta por resolucion de Incidencia DBLG400000506 pzerbino 02/02/2006            
                /*
                if (vUBIGEOS.size() != 1) {
                    UtilidadesLog.error("5 vUBIGEOS.size() = " + vUBIGEOS.size());
                    throw new MareException(null, null, UtilidadesError.armarCodigoError(ConstantesSEG.MODULO_MAE, "", ErroresDeNegocio.MAE_0011));
                }
                */
                
                if (vUBIGEOS.size() <= 0) {
                  throw new MareException(null, null, UtilidadesError.armarCodigoError(ConstantesSEG.MODULO_MAE, "", ErroresDeNegocio.MAE_0011));
                }
    
                DTOUBIGEO dtoUBIGEO = (DTOUBIGEO) vUBIGEOS.get(0); //obtengo el unico elemento.
                
                if (dtoUBIGEO == null) {
                    throw new MareException(null, null, UtilidadesError.armarCodigoError(ConstantesSEG.MODULO_MAE, "", ErroresDeNegocio.MAE_0011));
                }
    
                UtilidadesLog.info("7");
                UtilidadesLog.info("MONClientesBean.obtenerTerritorio(DTODIreccion, georeferenciados): Salida"); 
    
                return dtoUBIGEO.getOidTerritorio();
            } catch (CreateException re) {
                //sessionContext.setRollbackOnly();
                throw new MareException(re, UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
            } catch (RemoteException re) {
                //sessionContext.setRollbackOnly();
                throw new MareException(re, UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
            }
        } else return null;
    }

    public String generarDigitoControl(Long codigoCliente) throws MareException {
        UtilidadesLog.info("MONClientesBean.generarDigitoControl(codigoCliente): Entrada"); 
        PesosModulo11Local pm11L;
        Collection pesos;
        HashMap hmPesos = new HashMap();

        try {
            pesos = new PesosModulo11LocalHome().findAll();

            Iterator it = pesos.iterator();

            while (it.hasNext()) {
                pm11L = (PesosModulo11Local) it.next();
                hmPesos.put(pm11L.getNum_posi(), pm11L.getVal_peso_apli());
            }
        } catch (PersistenceException pe) {
            throw new MareException(pe, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS));
        }

        if (hmPesos.size() != NRO_POSICIONES_CON_PESO) {
            throw new MareException(null, null, UtilidadesError.armarCodigoError(ConstantesSEG.MODULO_MAE, "", ErroresDeNegocio.NRO_POSICIONES_CON_PESO_INCORRECTO));
        }

        //Ya tengo los pesos de las posiciones, debo convertir el nro.
        String sNumero = codigoCliente.toString();
        long tamanio = sNumero.length();

        StringBuffer valorFinal = new StringBuffer(sNumero);

        if (tamanio < NRO_POSICIONES_CON_PESO) {
            for (int i = 0; i < (NRO_POSICIONES_CON_PESO - tamanio); i++) {
                valorFinal.insert(0, "0");
            }
        }

        long suma = 0;
        long digitoActual;
        long pesoActual;
        long resto;
        char[] digitos = valorFinal.toString().toCharArray();
        long digitoControl;
        String resultado;

        for (int i = 1; i < (NRO_POSICIONES_CON_PESO + 1); i++) {
            digitoActual = Long.parseLong(String.valueOf((digitos[i - 1])));
            pesoActual = ((Long) hmPesos.get(new Long(i))).longValue();

            suma = suma + (digitoActual * pesoActual);
        }

        resto = suma % NRO_BASE;

        if (resto == 0) {
            digitoControl = 0;
            resultado = "0";
        } else {
            if (resto == 1) {
                resultado = null;
            } else {
                digitoControl = NRO_BASE - resto;
                resultado = "" + digitoControl;
            }
        }
        
        UtilidadesLog.info("MONClientesBean.generarDigitoControl(codigoCliente): Salida"); 

        return resultado;
    }

    public String ejecutarFuncionGeneraNumeros(ArrayList arrayParametros) throws MareException {
        UtilidadesLog.info("MONClientesBean.ejecutarFuncionGeneraNumeros(ArrayList): Entrada"); 
        String numero = null;
        try {                 
          numero = BelcorpService.getInstance().dbService.ExecuteFunction("OBT_COD_CLIE", arrayParametros);        
          UtilidadesLog.info("MONClientesBean.ejecutarFuncionGeneraNumeros(ArrayList):numeroGENERADO:"+ numero); 
        } catch(Exception e) {
          UtilidadesLog.error("ERROR",e);
          throw new MareException(e);
        } 
        UtilidadesLog.info("MONClientesBean.ejecutarFuncionGeneraNumeros(ArrayList): Salida"); 
        return numero;
    }
    
    public DTOPestanya1Base pestanya1Base(DTOBelcorp dto) throws MareException {
        UtilidadesLog.info("MONClientesBean.pestanya1Base(DTOBelcorp): Entrada"); 
        DAOMAEConfiguracionClientes daoCliente = new DAOMAEConfiguracionClientes(sessionContext.getCallerPrincipal().getName());
        DAOMAEMaestroClientes daoMaestroCliente = new DAOMAEMaestroClientes(sessionContext.getCallerPrincipal().getName());

        DTOPestanya1Base result = new DTOPestanya1Base();
        result.setTiposDocumento(daoCliente.obtenerTiposDocumentoPorPais(dto));

        DTOBoolean automatico = this.esCodigoClienteAutomatico(dto);
        
        StringBuffer query = new StringBuffer();
        
        query.append("SELECT ("); 
        query.append(" SELECT COD_PAIS"); 
        query.append(" FROM SEG_PAIS"); 
        query.append(" WHERE OID_PAIS = ").append(dto.getOidPais());
        query.append(" ) COD_PAIS "); 
        query.append(" FROM DUAL");        
        
        RecordSet rs = null;
        
        rs = UtilidadesBD.executeQuery(query.toString());
        ArrayList arrayParametros = new ArrayList();
        
        arrayParametros.add(UtilidadesBD.convertirAString(rs.getValueAt(0, "COD_PAIS")));
        arrayParametros.add("_");        
        arrayParametros.add(this.OPE_MAE_CODCLIENTE);
        arrayParametros.add("-");    

        try {
            if (automatico.getValor()) {
                //Long codigoCliente = daoMaestroCliente.obtenerSiguienteCodigoPais(dto.getOidPais());
                String digitoControl = null;

                //esto se descomenta en resolucion de la inc 14013
                //MONProcesosPED inum = PEDEjbLocators.getMONProcesosPEDHome().create();
                //MONProcesosPED inum = this.getMONProcesosPEDHome().create();

                // ssantana, 15/4/2005, inc. 14117
                // digitoControl puede venir NULL, asi que se reingresa hasta que 
                // se obtenga un dígito de Control NOT NULL.
                String codigoCliente = null;
                
                String moduloGenCodCliente = daoMaestroCliente.obtenerValorModuloCliente(dto.getOidPais(), "VAL_CODCLIE");
                int numDigitoControl = 1;
                
                // sapaza -- PER-SiCC-2013-1083 -- 04/10/2013
                if("MOD00".equals(moduloGenCodCliente)) {
                    codigoCliente = this.ejecutarFuncionGeneraNumeros(arrayParametros);
                    // codigoCliente = inum.generaSecuenciaDocumento(dtoSoli);
                    UtilidadesLog.info("este es el codigo de cliente: " + codigoCliente);
                    
                    digitoControl = "";
                    numDigitoControl = 0;
                }
                else {
                    while (digitoControl == null) {
                        codigoCliente = this.ejecutarFuncionGeneraNumeros(arrayParametros);
                       // codigoCliente = inum.generaSecuenciaDocumento(dtoSoli);
                        UtilidadesLog.info("este es el codigo de cliente: " + codigoCliente);
    
                        digitoControl = this.generarDigitoControl(new Long(codigoCliente));
                        UtilidadesLog.info("En el bucle, digito de control es " + digitoControl);
                    }
                }    

                UtilidadesLog.info("este es el digito de control: " + digitoControl);

                //String digitoControl = this.generarDigitoControl(codigoCliente);
                Integer numCaracteres;

                MONMantenimientoSEGHome mmsHome = SEGEjbLocators.getMONMantenimientoSEGHome();
                numCaracteres = mmsHome.create().obtenerLongitudNumeroCliente(dto.getOidPais());

                StringBuffer cadenaCodigoCliente = new StringBuffer("" + codigoCliente);

                if ((cadenaCodigoCliente.length() + numDigitoControl) > numCaracteres.intValue()) {
                    //if (cadenaCodigoCliente.length() > numCaracteres.intValue()) {
                    throw new MareException(null, null, UtilidadesError.armarCodigoError(ConstantesSEG.MODULO_MAE, "", ErroresDeNegocio.MAE_0005));
                } else {
                    //Le añadimos ceros a la izquierda hasta completar el numCaracteres exigido 
                    int cantCeros = numCaracteres.intValue() - cadenaCodigoCliente.length();

                    //inc. 14013
                    // ssantana, 15/4/2005
                    // Se comenta el parche abajo debido a que se ha corrido script de inc. 14013
                    for (int i = 0; i < (cantCeros - numDigitoControl); i++) {
                        cadenaCodigoCliente.insert(0, "0");
                    }

                    //este parche es para que funcione en pruebas hasta que corrijan la inc. 14013 
                    /*for (int i = 0; i < cantCeros -2; i++) {
                        cadenaCodigoCliente.insert(0, "0");
                    }
                    cadenaCodigoCliente.insert(0, "3");*/
                    /*for (int i = 0; i < cantCeros ; i++) {
                        cadenaCodigoCliente.insert(0, "0");
                    }*/
                    //Le incorporamos el digito de control al final de codigo completado con ceros
                    UtilidadesLog.info("codigo de cliente sin digito: " + cadenaCodigoCliente);
                    cadenaCodigoCliente.append(digitoControl);
                    UtilidadesLog.info("codigo de cliente con digito: " + cadenaCodigoCliente);
                }

                //Metemos los dos valores obtenidos en el dto de salida 
                result.setCodigoCliente(cadenaCodigoCliente.toString());
                result.setDigitoControl(digitoControl);
            }
        /*} catch (NamingException namingException) {
            sessionContext.setRollbackOnly();
            throw new MareException(namingException, UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));*/
        } catch (CreateException re) {
            throw new MareException(re, UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
        } catch (RemoteException re) {
            throw new MareException(re, UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
        }
        UtilidadesLog.info("MONClientesBean.pestanya1Base(DTOBelcorp): Salida"); 

        return result;
    }

    public DTOPestanya2Base pestanya2Base(DTOCodigoCliente dto) throws RemoteException, MareException {
        UtilidadesLog.info("MONClientesBean.pestanya2Base(DTOBelcorp): Entrada"); 
        
        DTOPestanya2Base salida = new DTOPestanya2Base();
        salida.setFormasPago(null);
        salida.setSaldo("");
        salida.setEstaCastigado(Boolean.FALSE);
        salida.setExiste(Boolean.FALSE);

        ClienteDatosBasicosLocal clienteLocal;
        ClienteDatosBasicosLocalHome clienteLocalHome;
        MONInterfaceModulosHome mONInterfaceModulosHome;
        MONInterfaceModulos mONInterfaceModulos;

        try {
            clienteLocalHome = new ClienteDatosBasicosLocalHome();
            mONInterfaceModulosHome = CCCEjbLocators.getMONInterfaceModulosHome();
            clienteLocal = clienteLocalHome.findByCodigoYPais(dto.getOidPais(), dto.getCodigoCliente());
            salida.setExiste(Boolean.TRUE);
            salida.setOidCliente(clienteLocal.getOid());

            DTOSaldosPorFechasyVtos dtoCCC = new DTOSaldosPorFechasyVtos();
            dtoCCC.setOidCliente(clienteLocal.getOid());
            dtoCCC.setOidPais(clienteLocal.getPais_oid_pais());
            mONInterfaceModulos = mONInterfaceModulosHome.create();

            DTOTotal dtoT = mONInterfaceModulos.consultarCuentasCastigadasCliente(dtoCCC);

            if (dtoT.getTotal().doubleValue() != 0) {
                UtilidadesLog.info("pestanya2Base Entro al if");
                salida.setEstaCastigado(Boolean.TRUE);

                if (dtoT.getTotal() != null) {
                    salida.setSaldo(dtoT.getTotal().toString());
                }
            }
            
        } catch (NoResultException nre) {
            salida.setFormasPago(this.obtenerFormasPagoPorPais(dto));
        } catch (PersistenceException pe) {
            sessionContext.setRollbackOnly();
            throw new MareException(pe, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS));
        } catch (CreateException createException) {
            sessionContext.setRollbackOnly();
            throw new MareException(createException, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS));
        }
        UtilidadesLog.info("MONClientesBean.pestanya2Base(DTOBelcorp): Salida"); 

        return salida;
    }

    /*
     * TODO: Este método debe desaparecer cuando este la interfaz con CCC.
     * */
    private Double comprobarCuentasCastigadas(Long oidCliente) throws MareException {
        //Double salida = new Double(0.7);
        UtilidadesLog.info("MONClientesBean.comprobarCuentasCastigadas(oidCliente): Entrada"); 
        Double salida = new Double(0.0);
        UtilidadesLog.info("MONClientesBean.comprobarCuentasCastigadas(oidCliente): Salida"); 

        return salida;
    }

    /*
     * TODO: Este método debe desaparecer cuando este la interfaz con BEL.
     * */
    private RecordSet obtenerFormasPagoPorPais(DTOBelcorp dto) throws MareException {
        UtilidadesLog.info("MONClientesBean.obtenerFormasPagoPorPais(DTOBelcorp): Entrada"); 
        RecordSet rs = new RecordSet();
        StringBuffer query = new StringBuffer();
        BelcorpService bs;

        query.append("SELECT   b.oid_form_pago, b.cod_form_pago, v.val_i18n descripcion ");
        query.append("    FROM bel_forma_pago b, v_gen_i18n_sicc v ");
        query.append("   WHERE b.pais_oid_pais = " + dto.getOidPais());
        query.append("     AND v.attr_enti = 'BEL_FORMA_PAGO' ");
        query.append("     AND v.attr_num_atri = 1 ");
        query.append("     AND v.idio_oid_idio = " + dto.getOidIdioma());
        query.append("     AND v.val_oid = b.oid_form_pago ");
        query.append(" ORDER BY 3 ");

        try {
            bs = BelcorpService.getInstance();
        } catch (MareMiiServiceNotFoundException ex) {
            throw new MareException(ex, UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_PEDIR_UN_SERVICIO_MARE));
        }

        try {
            rs = bs.dbService.executeStaticQuery(query.toString());
        } catch (Exception ex) {
            throw new MareException(ex, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS));
        }
        UtilidadesLog.info("MONClientesBean.obtenerFormasPagoPorPais(DTOBelcorp): Salida"); 

        return rs;
    }

    public DTOPestanya3Base pestanya3Base(DTOOIDs subtipoCliente) throws MareException {
        UtilidadesLog.info("MONClientesBean.pestanya3Base(DTOOIDs): Entrada"); 
        DTOPestanya3Base result = new DTOPestanya3Base();
        DAOMAEConfiguracionClientes daoConfClientes = new DAOMAEConfiguracionClientes(sessionContext.getCallerPrincipal().getName());
        Boolean bUsaGEOREFERENCIADOR = Boolean.FALSE;
        MONMantenimientoSEG mms;

        result.setTiposDirecciones(daoConfClientes.obtenerTiposDireccion(subtipoCliente));

        try {
            MONMantenimientoSEGHome mmsHome = SEGEjbLocators.getMONMantenimientoSEGHome();
            mms = mmsHome.create();

            bUsaGEOREFERENCIADOR = mms.usaGeoreferenciador(subtipoCliente.getOidPais());
            result.setUsaGeoreferenciador(bUsaGEOREFERENCIADOR);
            
            /* Cleal MAE-03
            if (bUsaGEOREFERENCIADOR.booleanValue()) {
                result.setTipoVia(null);
            } else {*/
                result.setTipoVia(((DTOSalida) mms.recuperarTiposVia(subtipoCliente)).getResultado());
            //}

            result.setMarcas(((DTOSalida) mms.recuperarMarcas(subtipoCliente, Boolean.TRUE)).getResultado());

            result.setCanales(((DTOSalida) mms.recuperarCanales(subtipoCliente, Boolean.TRUE)).getResultado());

            DTOClasificaciones salida = daoConfClientes.obtenerClasificacionesSubtipo(subtipoCliente);

            result.setTiposClasificacion(salida.getTipoClasificacion());

            result.setClasificaciones(salida.getClasificacion());
        } catch (CreateException re) {
            throw new MareException(re, UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
        } catch (RemoteException re) {
            throw new MareException(re, UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
        }
        
        UtilidadesLog.info("MONClientesBean.pestanya3Base(DTOOIDs): Salida"); 

        return result;
    }

    /**
     * 
     * Modificado: SICC-GCC-MAE-005 - Cleal
     * Se eliminan los campos interior, lote, manzana y kilometro en el paso 5
     */
    private Long insertarClienteBasico(DTOCrearClienteBasico dto) throws MareException {
        UtilidadesLog.info("*****DATOS A PASAR AL MON DE ZON "); 
        ClienteDatosBasicosLocalHome clienteDBasicosLH;
        ClienteDatosBasicosLocal clienteDBasicosL;
        ClienteDatosAdicionalesLocalHome clienteDAdicionalesLH;
        ClienteDatosAdicionalesLocal clienteDAdicionalesL;
        ClienteTipoSubTipoLocalHome clienteTSubtipoLH;
        ClienteTipoSubTipoLocal clienteTSubtipoL;
        ClienteIdentificacionLocalHome identificacionLH;
        ClienteIdentificacionLocal identificacionL;
        ClienteDireccionLocalHome direccionLH;
        ClienteDireccionLocal direccionL;
        ClienteMarcaLocalHome clienteMarcaLH;
        ClienteMarcaLocal clienteMarcaL;
        ClienteClasificacionLocalHome clienteClasiLH;
        ClienteClasificacionLocal clienteClasiL;
        TipoClasificacionLocalHome tipoClasiLH;
        TipoClasificacionLocal tipoClasiL;
        StringBuffer codigoActual = null;
        Long oidCliente;
        Long oidEntityTipoSubtipo = null;

        UtilidadesLog.info("DTOCrearClienteBasico: " + dto);

        UtilidadesLog.info("insertarClienteBasico validacion estructural.");
        this.validarAccesos(dto);

        //Paso 0
     
        try {
            MONMantenimientoSEG monSEG = SEGEjbLocators.getMONMantenimientoSEGHome().create();
            int longitudDeseada = monSEG.obtenerLongitudNumeroCliente(dto.getOidPais()).intValue();

            codigoActual = new StringBuffer(dto.getCodigoCliente());

            int longitudActual = codigoActual.length();

            //UtilidadesLog.info("antes del if , la longitud actual es " + longitudActual);
            //UtilidadesLog.info("antes del if , la longitud deseada es " + longitudDeseada);
            if (longitudActual > longitudDeseada) {
                throw new MareException(null, null, UtilidadesError.armarCodigoError(ConstantesSEG.MODULO_MAE, "", ErroresDeNegocio.MAE_0025));
            } else if (longitudActual < longitudDeseada) {
                for (int i = 0; i < (longitudDeseada - longitudActual); i++) {
                    codigoActual = codigoActual.insert(0, "0");
                }
            }
        } catch (MareException me) {
            me.printStackTrace();
            throw me;
        } catch (Exception e) {
            e.printStackTrace();
            throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
        }

        try {
            clienteDBasicosLH = new ClienteDatosBasicosLocalHome();

            //Comprobacion de cliente existente
            UtilidadesLog.info("Comprobando existencia de cliente nro: " + codigoActual);

            clienteDBasicosL = clienteDBasicosLH.findByCodigoYPais(dto.getOidPais(), codigoActual.toString());

            throw new MareException(null, null, UtilidadesError.armarCodigoError(ConstantesSEG.MODULO_MAE, "", ErroresDeNegocio.MAE_0030));
        } catch (NoResultException nre) {
            //seguimos adelante, el cliente no existe.
            UtilidadesLog.info("el cliente no existe, lo creamos");
        } catch (PersistenceException pe) {
            sessionContext.setRollbackOnly();
            throw new MareException(pe, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS));
        }

        try {
            //Paso 1
            Date now = new Date(System.currentTimeMillis());
            clienteDBasicosLH = new ClienteDatosBasicosLocalHome();

            clienteDBasicosL = clienteDBasicosLH.create(dto.getOidPais(), codigoActual.toString(), false);

            clienteDBasicosL.setCod_digi_ctrl(dto.getDigitoControl());
            clienteDBasicosL.setVal_ape1(dto.getApellido1());
            clienteDBasicosL.setVal_ape2(dto.getApellido2());
            clienteDBasicosL.setVal_apel_casa(dto.getApellidoCasada());
            clienteDBasicosL.setVal_nom1(dto.getNombre1());
            clienteDBasicosL.setVal_nom2(dto.getNombre2());
            clienteDBasicosL.setVal_trat(dto.getTratamiento());
            clienteDBasicosL.setCod_sexo(dto.getSexo());

            if (dto.getFechaIngreso() != null) {
                clienteDBasicosL.setFec_ingr(new Timestamp(truncarFecha(dto.getFechaIngreso()).getTime()));
            }

            clienteDBasicosL.setFopa_oid_form_pago(dto.getFormaPago());
            
            clienteDBasicosLH.merge(clienteDBasicosL);

            oidCliente = clienteDBasicosL.getOid();

            clienteDAdicionalesLH = new ClienteDatosAdicionalesLocalHome();

            clienteDAdicionalesL = clienteDAdicionalesLH.create(oidCliente, null, now);
            clienteDAdicionalesL.setInd_acti(new Long(1));
            clienteDAdicionalesLH.merge(clienteDAdicionalesL);

            //Paso 2
            UtilidadesLog.info("Antes de llamar a insertarCriteriosBusqueda " );
            this.insertarCriteriosBusqueda(clienteDBasicosL, clienteDAdicionalesL, dto.getOidIdioma());
            UtilidadesLog.info("despues de llamar a insertarCriteriosBusqueda " );
            //Paso 3

            DTOTipoSubtipoCliente[] tiposSubtipos = dto.getTiposSubtipos();
            UtilidadesLog.info("DTOTipoSubtipoCliente[] tiposSubtipos " );
            boolean bPrincipal = false;
            Long oidTipoCliente = null;
            HashMap hmTipoSubtipo = new HashMap();
            // vbongiv -- 17/01/2008 -- Cambio SiCC20070461 MAE
            ArrayList listaOidTipos = new ArrayList();

            UtilidadesLog.info(" antes DTOTipoSubtipoCliente[] tiposSubtipos " );
            clienteTSubtipoLH = new ClienteTipoSubTipoLocalHome();
            UtilidadesLog.info("despues DTOTipoSubtipoCliente[] tiposSubtipos " );
            if (tiposSubtipos != null) {
                for (int i = 0; i < tiposSubtipos.length; i++) {
                    if (tiposSubtipos[i].getPrincipal() == null) {
                        tiposSubtipos[i].setPrincipal(Boolean.FALSE);
                    }

                    bPrincipal = tiposSubtipos[i].getPrincipal().booleanValue();
                    clienteTSubtipoL = clienteTSubtipoLH.create(oidCliente, tiposSubtipos[i].getTipo(), tiposSubtipos[i].getSubtipo(), (bPrincipal == true) ? new Long(1) : new Long(0), now);
                    hmTipoSubtipo.put(tiposSubtipos[i].getSubtipo(), clienteTSubtipoL.getOid());
                    
                    // vbongiv -- 17/01/2008 -- Cambio SiCC20070461 MAE
                    listaOidTipos.add(tiposSubtipos[i].getTipo());

                    if (bPrincipal) {
                        oidTipoCliente = clienteTSubtipoL.getTicl_oid_tipo_clie();
                    }
                }
            }

            //Paso 4
            UtilidadesLog.info("antes DTOIdentificacion[] identificaciones = dto.getIdentificaciones() " );
            DTOIdentificacion[] identificaciones = dto.getIdentificaciones();
            identificacionLH = new ClienteIdentificacionLocalHome();
            UtilidadesLog.info("despues DTOIdentificacion[] identificaciones = dto.getIdentificaciones() " );
            
            UtilidadesLog.info("antes  identificaciones != null " );
            if (identificaciones != null) {
                UtilidadesLog.info("despues  identificaciones != null " );
                for (int i = 0; i < identificaciones.length; i++) {
                    UtilidadesLog.info("dentro del for " + identificaciones.length );
                    if (identificaciones[i].getEsPrincipal() == null) {
                        identificaciones[i].setEsPrincipal(Boolean.FALSE);
                    }
                    UtilidadesLog.info("antes identificacionL " );      
                    identificacionL = identificacionLH.create(identificaciones[i].getTipoDocumento(), oidCliente, identificaciones[i].getNumeroDocumento(), (identificaciones[i].getEsPrincipal().booleanValue() == true) ? new Long(1) : new Long(0), now);
                    UtilidadesLog.info("depues identificacionL " );  
                    identificacionL.setVal_iden_pers_empr(identificaciones[i].getIndPersonaEmpresa());
                    identificacionLH.merge(identificacionL);
                }
            }

            //Paso 5
            UtilidadesLog.info("antes DTODireccion[] direcciones = dto.getDirecciones() " );
            DTODireccion[] direcciones = dto.getDirecciones();
            DTODireccion direccionPrincipal;
            int cantidadDireccionesPrincipales = 0;
            Long oidTerritorio = null;
            Long oidTerritorioPrincipal = null;
            direccionLH = new ClienteDireccionLocalHome();
            UtilidadesLog.info("despues DTODireccion[] direcciones = dto.getDirecciones() " );
            if (direcciones != null) {
                for (int i = 0;
                        (i < direcciones.length) && (cantidadDireccionesPrincipales < 2);
                        i++) {
                    if (direcciones[i].getEsDireccionPrincipal() == null) {
                        direcciones[i].setEsDireccionPrincipal(Boolean.FALSE);
                    }

                    UtilidadesLog.info("********DATOS A PASAR AL MON DE ZON " + direcciones[i]);
                    UtilidadesLog.info("*** dto: "+dto);
                    oidTerritorio = this.obtenerTerritorio(direcciones[i], dto.getUsaGeoreferenciador());
                    UtilidadesLog.info("oidTerritorio: " + oidTerritorio);

                    if (direcciones[i].getEsDireccionPrincipal().booleanValue()) {
                        direccionPrincipal = direcciones[i];
                        cantidadDireccionesPrincipales++;
                        oidTerritorioPrincipal = oidTerritorio;
                    }

                    UtilidadesLog.info("oidTerritorioPrincipal: " + oidTerritorioPrincipal);
                    //Cleal - 22631
                    ValoresEstructuraGeopoliticaLocalHome valoresEstructuraGeopoliticaLocalHome = new ValoresEstructuraGeopoliticaLocalHome();
                    ValoresEstructuraGeopoliticaLocal valoresEstructuraGeopoliticaLocal = valoresEstructuraGeopoliticaLocalHome.findByPrimaryKey(direcciones[i].getUnidadGeografica());
                    
                    String str1 = (valoresEstructuraGeopoliticaLocal.getOrde_1()==null)?"":valoresEstructuraGeopoliticaLocal.getOrde_1();
                    String str2 = (valoresEstructuraGeopoliticaLocal.getOrde_2()==null)?"":valoresEstructuraGeopoliticaLocal.getOrde_2();
                    String str3 = (valoresEstructuraGeopoliticaLocal.getOrde_3()==null)?"":valoresEstructuraGeopoliticaLocal.getOrde_3();
                    String str4 = (valoresEstructuraGeopoliticaLocal.getOrde_4()==null)?"":valoresEstructuraGeopoliticaLocal.getOrde_4();
                    String str5 = (valoresEstructuraGeopoliticaLocal.getOrde_5()==null)?"":valoresEstructuraGeopoliticaLocal.getOrde_5();
                    String str6 = (valoresEstructuraGeopoliticaLocal.getOrde_6()==null)?"":valoresEstructuraGeopoliticaLocal.getOrde_6();
                    String str7 = (valoresEstructuraGeopoliticaLocal.getOrde_7()==null)?"":valoresEstructuraGeopoliticaLocal.getOrde_7();
                    String str8 = (valoresEstructuraGeopoliticaLocal.getOrde_8()==null)?"":valoresEstructuraGeopoliticaLocal.getOrde_8();
                    String str9 = (valoresEstructuraGeopoliticaLocal.getOrde_9()==null)?"":valoresEstructuraGeopoliticaLocal.getOrde_9();
                    String ubigeo = str1+str2+str3+str4+str5+str6+str7+str8+str9;
                    
                    direccionL = direccionLH.create(oidCliente, direcciones[i].getTipoDireccion(), direcciones[i].getTipoVia(), now, ubigeo);
                    direccionL.setTerr_oid_terr(oidTerritorio); 
                    direccionL.setVal_nomb_via(direcciones[i].getNombreVia().replaceAll(">","").replaceAll("<",""));                    
                    
                    if (direcciones[i].getNumeroPrincipal() != null) {
                        direccionL.setNum_ppal(direcciones[i].getNumeroPrincipal().toString());
                    }

                    direccionL.setVal_cod_post(direcciones[i].getCodigoPostal());
                    
                    //Pedido de cambio: (COMPLETAR) Falta informar Claudio.
                    if (direcciones[i].getObservaciones()!=null){
                        // Modificaciones por SiCC 20070330 - Rafael Romero - 28/06/2007
                        // Evitar guardar los caracteres '>' o '<'
                        // Se eliminan de la cadena antes de almacenar en Base de datos
                        // direccionL.setVal_obse(direcciones[i].getObservaciones().replace('\n',' '));
                        direccionL.setVal_obse(direcciones[i].getObservaciones().replace('\n',' ').replaceAll(">","").replaceAll("<",""));
                        // Fin modificaciones SiCC 20070330
                    }
                    direccionL.setInd_dire_ppal((direcciones[i].getEsDireccionPrincipal().booleanValue() == true) ? new Long(1) : new Long(0));
                    direccionL.setZvia_oid_via(direcciones[i].getVia());
                    direccionL.setInd_ctrl_inte_geor(null);
                    direccionL.setVal_nomb_fich(null);
                    direccionL.setVal_coor_x(null);
                    direccionL.setVal_coor_y(null);
                    direccionL.setVal_coor_z(null);
                    direccionLH.merge(direccionL);
                }

                if (cantidadDireccionesPrincipales != 1) {
                    UtilidadesLog.error("insertarBasico cantidadDireccionesPrincipales != 1");
                    throw new IllegalArgumentException("Se ha recibido en la inserción " + "de clientes un DTODirecciones con varias direcciones principales.");
                }
            }

            //Paso 7
            clienteMarcaLH = new ClienteMarcaLocalHome();
            
            UtilidadesLog.info("antes DTOClienteMarca[] marcas = dto.getMarcas() " );
            
            DTOClienteMarca[] marcas = dto.getMarcas();
            UtilidadesLog.info("despues DTOClienteMarca[] marcas = dto.getMarcas() " );

            if (marcas != null) {
                for (int i = 0; i < marcas.length; i++) {
                    if (marcas[i].getPrincipal() == null) {
                        marcas[i].setPrincipal(Boolean.FALSE);
                    }

                    if (marcas[i].getMarca() != null) {
                        clienteMarcaL = clienteMarcaLH.create(oidCliente, marcas[i].getMarca(), (marcas[i].getPrincipal().booleanValue() == true) ? new Long(1) : new Long(0), now);
                    }
                }
            }

            //Paso 8
            UtilidadesLog.info("antes DTOClasificacionCliente[] clasificaciones = dto.getClasificaciones() " );
            DTOClasificacionCliente[] clasificaciones = dto.getClasificaciones();
            UtilidadesLog.info("despues DTOClasificacionCliente[] clasificaciones = dto.getClasificaciones() " );
            
            int contadorClasificacionesPrincipales = 0;

            DTOClasificacionCliente dtoClasificacionCliente = new DTOClasificacionCliente();

            DTOPeriodo periodoActual = null;
            UtilidadesLog.info("antes CRAEjbLocators.getMONPeriodosHome() " );
            MONPeriodosHome mpHome = CRAEjbLocators.getMONPeriodosHome();

            MONPeriodos mp = mpHome.create();
            clienteClasiLH = new ClienteClasificacionLocalHome();
            tipoClasiLH = new TipoClasificacionLocalHome();
            
            if (clasificaciones != null) {
                for (int i = 0;
                        (i < clasificaciones.length) && (contadorClasificacionesPrincipales < 2);
                        i++) {
                    if (clasificaciones[i].getPrincipal() == null) {
                        clasificaciones[i].setPrincipal(Boolean.FALSE);
                    }

                    if ((clasificaciones[i].getMarca() != null) && (clasificaciones[i].getCanal() != null) && (clasificaciones[i].getPrincipal() != null)) {

                        periodoActual = mp.obtienePeriodoActual(dto.getOidPais(), clasificaciones[i].getMarca(), clasificaciones[i].getCanal(), dto.getPeriodoContacto());

                        if ((clasificaciones[i].getClasificacion() != null) && (clasificaciones[i].getTipoClasificacion() != null)) {
                            tipoClasiL = tipoClasiLH.findByPrimaryKey(clasificaciones[i].getTipoClasificacion());

                            Long oidSubTipoClienClasi = tipoClasiL.getSbti_oid_subt_clie();
                            oidEntityTipoSubtipo = (Long) hmTipoSubtipo.get(oidSubTipoClienClasi);
                        }


                        //(SCS)segun lo charlado con JF, solo grabo la clasificacion si tengo data en Tipo clasificación
                        //y en Clasificación, todo esto porque no tengo el canal en la pest. 4, aparte se dejo la 
                        //obligatoriedad en la pantalla: contenido_grupo4_insertar de por lo meno un registro en la lista
                        if ((clasificaciones[i].getClasificacion() != null) && (clasificaciones[i].getTipoClasificacion() != null)) {
                            UtilidadesLog.info("(SCS)tengo clasificacion, guardo......");
                            clienteClasiL = clienteClasiLH.create(oidEntityTipoSubtipo, clasificaciones[i].getClasificacion(), periodoActual.getOid(), clasificaciones[i].getTipoClasificacion(), (clasificaciones[i].getPrincipal().booleanValue() == true) ? new Long(1) : new Long(0), now);
                            clienteClasiL.setFec_clas(new Timestamp(truncarFecha(now).getTime()));
                            clienteClasiLH.merge(clienteClasiL);
                        } else {
                            UtilidadesLog.info("(SCS)NO tengo clasificacion, NO guardo......");
                        }

                        if (clasificaciones[i].getPrincipal().booleanValue()) {
                            contadorClasificacionesPrincipales++;
                            dtoClasificacionCliente = clasificaciones[i];
                       }
                    }
                }

                if ((contadorClasificacionesPrincipales != 1) && (contadorClasificacionesPrincipales != 0)) { //agregado por SCS
                    UtilidadesLog.error("contadorClasificacionesPrincipales != 1");
                    throw new IllegalArgumentException("Se ha recibido en la inserción " + "de clientes varias clasificaciones principales.");
                }
            }
            
            MONEstatusClienteHome mecHome = this.getMONEstatusClienteHome();
            MONEstatusCliente mec = mecHome.create();
            // vbongiv -- 17/01/2008 -- Cambio SiCC20070461 MAE
            mec.asignarEstatusInicial(clienteDAdicionalesL, periodoActual.getOid(), listaOidTipos, dto);

            //Paso 9
            UtilidadesLog.info("antes ZONEjbLocators.getMONUnidadesAdministrativasHome() " );
            MONUnidadesAdministrativasHome muaVHome = ZONEjbLocators.getMONUnidadesAdministrativasHome();
            MONUnidadesAdministrativas mua = muaVHome.create();
            if(oidTerritorioPrincipal!=null){
                if (marcas != null) {
                    for (int i = 0; i < marcas.length; i++) {
                        if (marcas[i].getMarca() != null) {
                            mua.actualizarUnidadesAdmMAE(marcas[i].getMarca(), dto.getOidPais(), dtoClasificacionCliente.getCanal(), oidTerritorioPrincipal, oidCliente, dto, new Long(1));
                        }
                    }
                }
            
            //Paso 10
            this.asignarNivelRiesgoCredito(dto.getOidPais(), dtoClasificacionCliente.getMarca(), dtoClasificacionCliente.getCanal(), oidTerritorioPrincipal, clienteDAdicionalesL);
            }
            
            UtilidadesLog.info("MONClientesBean.insertarClienteBasico(DTOCrearClienteBasico): Salida"); 

            return oidCliente;
        } catch (PersistenceException pe) {
            UtilidadesLog.error("Error: ", pe);
            sessionContext.setRollbackOnly();
            String error;
            if (pe instanceof EntityExistsException || pe instanceof RollbackException) {
                error = CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS;
            } else if (pe instanceof NoResultException) {
                error = CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE;
            } else {
                error = CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS;
            }
            throw new MareException(pe, UtilidadesError.armarCodigoError(error));
        } catch (MareException me) {
            UtilidadesLog.error(me);
            sessionContext.setRollbackOnly();
            throw me;
        } catch (Exception ex) {
            UtilidadesLog.error(ex);
            sessionContext.setRollbackOnly();
            throw new MareException(ex, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS));
        }
    }

    public DTOPestanyaBusqueda1 pestanya1Busqueda(DTOBelcorp dto) throws MareException {
        UtilidadesLog.info("MONClientesBean.pestanya1Busqueda(DTOBelcorp): Entrada"); 
        DAOMAEConfiguracionClientes confClientes = new DAOMAEConfiguracionClientes(sessionContext.getCallerPrincipal().getName());
        String codigoError;

        /* Creamos un DTOPestanyaBusqueda1 que rellenamos de la siguiente manera: */
        DTOPestanyaBusqueda1 dtoPest = new DTOPestanyaBusqueda1();

        /*-Llamamos al metodo obtenerTiposDocumentoPorPais pasandole el dto recibido, el resultado de la llamada lo ponemos en el atributo tiposDocumento */
        dtoPest.setTiposDocumento(confClientes.obtenerTiposDocumentoPorPais(dto));

        /*        -if (esCodigoClienteAutomatico(dto.pais) {
                Llamamos al metodo obtenerLongitudNumeroCliente pasandole el pais del dto y obtenemos el atributo tamCodigoCliente
                } else tamCodigoCliente = null;*/
        if (esCodigoClienteAutomatico(dto).getValor()) {
            try {
                MONMantenimientoSEG mantSeg = SEGEjbLocators.getMONMantenimientoSEGHome().create();
                dtoPest.setTamCodigoCliente(mantSeg.obtenerLongitudNumeroCliente(dto.getOidPais()));
            } catch (CreateException ce) {
                codigoError = CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB;
                throw new MareException(ce, UtilidadesError.armarCodigoError(codigoError));
            } catch (RemoteException re) {
                codigoError = CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB;
                throw new MareException(re, UtilidadesError.armarCodigoError(codigoError));
            }
        } else {
            dtoPest.setTamCodigoCliente(null);
        }
        
        UtilidadesLog.info("MONClientesBean.pestanya1Busqueda(DTOBelcorp): Salida"); 

        return dtoPest;
    }

    public void insertarCriteriosBusqueda(ClienteDatosBasicosLocal clienteDatosBasicos, ClienteDatosAdicionalesLocal clienteDatosAdicionales, Long idioma) throws MareException {
        UtilidadesLog.info("MONClientesBean.insertarCriteriosBusqueda(ClienteDatosBasicosLocal, ClienteDatosAdicionalesLocal, idioma): Entrada"); 
        CriterioBusquedaLocalHome criterioLH;
        CriterioBusquedaLocal criterioL;
        AtributosEspecialesLocalHome attrEspecialLH;
        AtributosEspecialesLocal attrEspecialL;
        String codigoCrite1 = "";
        String codigoCrite2 = "";
        UtilidadesLog.info("entrando a insertarCriteriosBusqueda");

        try {
            criterioLH = new CriterioBusquedaLocalHome();

            criterioL = criterioLH.findByPais(clienteDatosBasicos.getPais_oid_pais());
            attrEspecialLH = new AtributosEspecialesLocalHome();

            attrEspecialL = attrEspecialLH.findByPrimaryKey(criterioL.getAtre_oid_atri_esp1());
            codigoCrite1 = attrEspecialL.getCod_atri();
            attrEspecialL = attrEspecialLH.findByPrimaryKey(criterioL.getAtre_oid_atri_esp2());
            codigoCrite2 = attrEspecialL.getCod_atri();
            
            this.guardarAtributoDinamico(clienteDatosBasicos, clienteDatosAdicionales, codigoCrite1, codigoCrite2, idioma);
            UtilidadesLog.info("MONClientesBean.insertarCriteriosBusqueda(ClienteDatosBasicosLocal, ClienteDatosAdicionalesLocal, idioma): Salida"); 
            
        } catch (NoResultException e) {
            //Corto la ejecución.
            UtilidadesLog.info("no se encontró criterio de busqueda");
            return;
        } catch (PersistenceException ex) {
            //Corto la ejecución.
            UtilidadesLog.error("Se produjo un error en: insertarCriteriosBusqueda. \n " + ex.toString());
            throw new MareException(ex, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS));
        }
    }

    private String obtenerResultado(Object obj) {
        
        UtilidadesLog.info("obtenerResultado obj: " + obj);

        String resultado = null;

        if (obj == null) {
            return null;
        } else if (obj instanceof BigDecimal) {
            return "" + ((BigDecimal) obj).toString();
        } else if (obj instanceof java.sql.Date) {
            return "" + ((java.sql.Date) obj).getTime();
        } else if (obj instanceof java.util.Date) {
            return "" + ((java.util.Date) obj).getTime();
        } else {
            return obj.toString();
        }
    }

    /*
     * guardarAtributoDinamico:
     *         la idea es guardar el hardcodeo en en hashmap y mediante reflection
     *  obtener la propiedad de alguno de los 2 entities. Una vez
     *  obtenido el valor, se setean los criterios de busqueda de la entidad
     *  ClienteDatosBasicos.
     *  Si el atributo es un código con FK en la tabla, entonces debe
     *  internacionalizarse llamando a una utilidad de i18n que trae la
     *  descripcion.
     * */
    private void guardarAtributoDinamico(ClienteDatosBasicosLocal clienteDatosBasicos, ClienteDatosAdicionalesLocal clienteDatosAdicionales, String codigoCrite1, String codigoCrite2, Long idioma) throws MareException {
        UtilidadesLog.info("MONClientesBean.guardarAtributoDinamico(ClienteDatosBasicosLocal, ClienteDatosAdicionalesLocal, codigoCrite1, codigoCrite2, idioma): Entrada"); 
        HashMap hmDatosPropiedades = new HashMap();
        HashMap hmTraducibles = new HashMap();
        UtilidadesLog.info("guardarAtributoDinamico");
        hmDatosPropiedades.put("MAECLIEAPELL1", "val_ape1");
        hmDatosPropiedades.put("MAECLIEAPELL2", "val_ape2");
        hmDatosPropiedades.put("MAECLIEAPELLCA", "val_apel_casa");
        hmDatosPropiedades.put("MAECLIENOM1", "val_nom1");
        hmDatosPropiedades.put("MAECLIENOM2", "val_nom2");
        hmDatosPropiedades.put("MAECLIETRAT", "val_trat");
        hmDatosPropiedades.put("MAECLIESEXO", "cod_sexo");
        hmDatosPropiedades.put("MAECLIEFECHING", "fec_ingr");
        hmDatosPropiedades.put("MAECLIEFORMPA", "fopa_oid_form_pago");

        hmDatosPropiedades.put("MAECLIEFECHNA", "fec_naci");
        hmDatosPropiedades.put("MAECLIECODEMP", "cod_empl");
        hmDatosPropiedades.put("MAECLIENACIO", "snon_oid_naci");
        hmDatosPropiedades.put("MAECLIEEDAD", "val_edad");
        hmDatosPropiedades.put("MAECLIEESTCIV", "escv_oid_esta_civi");
        hmDatosPropiedades.put("MAECLIEOCUP", "val_ocup");
        hmDatosPropiedades.put("MAECLIEPROF", "val_prof");
        hmDatosPropiedades.put("MAECLIECENTRA", "val_cent_trab");
        hmDatosPropiedades.put("MAECLIECARGO", "val_carg_dese");
        hmDatosPropiedades.put("MAECLIENIVESTU", "nied_oid_nive_estu");
        hmDatosPropiedades.put("MAECLIECENESTU", "val_cent_estu");
        hmDatosPropiedades.put("MAECLIEPERSDEP", "num_pers_depe");
        hmDatosPropiedades.put("MAECLIENSEP", "val_nive_soci_eco3");
        hmDatosPropiedades.put("MAECLIECICLVID", "tclv_oid_cicl_vida");
        hmDatosPropiedades.put("MAECLIEDESCORR", "ind_corr");
        hmDatosPropiedades.put("MAECLIEINGFAM", "imp_ingr_fami");

        hmTraducibles.put("MAECLIEFORMPA", "BEL_FORMA_PAGO");
        hmTraducibles.put("MAECLIENACIO", "SEG_NACIO");
        hmTraducibles.put("MAECLIEESTCIV", "MAE_ESTAT_CLIEN");
        hmTraducibles.put("MAECLIENIVESTU", "MAE_NIVEL_ESTUD");
        hmTraducibles.put("MAECLIENSEP", "MAE_TIPO_NIVEL_SOCEC_PERSO");
        hmTraducibles.put("MAECLIECICLVID", "MAE_CICLO_VIDA");

        String propiedad1 = (String) hmDatosPropiedades.get(codigoCrite1);
        String propiedad2 = (String) hmDatosPropiedades.get(codigoCrite2);
        String resultado1 = null;
        String resultado2 = null;

        UtilidadesLog.info("propiedad1 " + propiedad1);
        UtilidadesLog.info("propiedad2 " + propiedad2);

        //Primer criterio
        if (propiedad1 != null) {
            resultado1 = obtenerResultado(clienteDatosBasicos.getObject(propiedad1));
            UtilidadesLog.info("resultado1: " + resultado1);

            if (resultado1 == null) {
                resultado1 = obtenerResultado(clienteDatosAdicionales.getObject(propiedad1));
                UtilidadesLog.info("resultado1: " + resultado1);
            }

            if (resultado1 != null) {
                if (hmTraducibles.containsKey(codigoCrite1)) {
                    UtilidadesLog.info("xxx 1 ");
                    resultado1 = UtilidadesI18N.recuperarTraducciones((String) hmTraducibles.get(codigoCrite1), new Long(Long.parseLong(resultado1)), idioma, new Long(1) //Atributo 1
                        );
                    UtilidadesLog.info("xxx resultado1: " + resultado1);
                }

                clienteDatosBasicos.setVal_crit_bus1(resultado1);
            }
        }

        //Segundo criterio
        if (propiedad2 != null) {
            resultado2 = obtenerResultado(clienteDatosBasicos.getObject(propiedad2));

            if (resultado2 == null) {
                resultado2 = obtenerResultado(clienteDatosAdicionales.getObject(propiedad2));
            }

            if (resultado2 != null) {
                if (hmTraducibles.containsKey(codigoCrite2)) {
                    UtilidadesLog.info("xxx 2 ");
                    resultado2 = UtilidadesI18N.recuperarTraducciones((String) hmTraducibles.get(codigoCrite2), new Long(Long.parseLong(resultado2)), idioma, new Long(1) //Atributo 1
                        );
                    UtilidadesLog.info("xxx resultado2: " + resultado2);
                }

                clienteDatosBasicos.setVal_crit_bus2(resultado2);
            }
        }
        
        this.getClienteDatosBasicosLocalHome().merge(clienteDatosBasicos);
        UtilidadesLog.info("MONClientesBean.guardarAtributoDinamico(ClienteDatosBasicosLocal, ClienteDatosAdicionalesLocal, codigoCrite1, codigoCrite2, idioma): Salida"); 
    }

    public DTOSalida obtenerVias(DTOOID dtoid) throws MareException {
       UtilidadesLog.info("MONClientesBean.obtenerVias(DTOOID): Entrada"); 
        String codigoError;
        DTOSalida dto = new DTOSalida();        

        try {
            MONEstructuraVial monEV = ZONEjbLocators.getMONEstructuraVialHome().create();
            dto = monEV.obtenerViasPais(dtoid);
        } catch (MareException me) {
            if (me.getCode() != Integer.parseInt(CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE)) {
                throw me;
            } else {
                dto.setResultado(new RecordSet());
            }
        } catch (Exception e) {
            e.printStackTrace();
            throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
        }
        
        UtilidadesLog.info("MONClientesBean.obtenerVias(DTOOID): Salida"); 

        return dto;
    }

    public DTOConsultaCliente consultar(DTOOID oid) throws MareException {
        UtilidadesLog.info("MONClientesBean.consultar(DTOOID): Entrada"); 
        DAOMAEMaestroClientes dao = new DAOMAEMaestroClientes(sessionContext.getCallerPrincipal().getName());
        UtilidadesLog.info("MONClientesBean.consultar(DTOOID): Salida"); 
        return dao.consultarCliente(oid);
    }

    public DTOPestanya2 pestanya2Busqueda(DTOBelcorp dto) throws MareException {
        UtilidadesLog.info("MONClientesBean.pestanya2Busqueda(DTOBelcorp): Entrada"); 
        DTOPestanya2Base dtop2B = new DTOPestanya2Base();
        DTOSalida dtoSalida = new DTOSalida();
        DAOMAEConfiguracionClientes dmcc = new DAOMAEConfiguracionClientes(sessionContext.getCallerPrincipal().getName());
        String codigoError;

        try {
            MONMantenimientoSEG MonmSeg = SEGEjbLocators.getMONMantenimientoSEGHome().create();
            dtop2B.setFormasPago(this.obtenerFormasPagoPorPais(dto));

            DTOPestanya2 dtoP2 = new DTOPestanya2();
            dtoP2.setBase(dtop2B);
            dtoP2.setNacionalidad(MonmSeg.recuperarNacionalidades(dto).getResultado());
            dtoP2.setEstadoCivil(dmcc.obtenerEstadosCiviles(dto));
            dtoP2.setNivelEstudios(dmcc.obtenerNivelesEstudiosPorPais(dto));
            dtoP2.setNSEP(dmcc.buscarTipoNSEPPorPais(dto));
            dtoP2.setCiclosVida(dmcc.obtenerCiclosVida(dto));
            dtoP2.setPaises(MonmSeg.recuperarPaisesSinTodos(dto).getResultado());
            dtoP2.setTiposPreferencias(dmcc.obtenerTiposPreferenciasPorPais(dto));
            dtoP2.setMarcas(MonmSeg.recuperarMarcas(dto).getResultado());
            dtoP2.setTiposVinculo(dmcc.obtenerTiposVinculosPais(dto));
            dtoP2.setTipoCliente(dmcc.obtenerTipos(dto));

            dtoSalida = MonmSeg.recuperarCanales(dto, Boolean.FALSE);
            dtoP2.setCanales(dtoSalida.getResultado());
            UtilidadesLog.info("MONClientesBean.pestanya2Busqueda(DTOBelcorp): Salida"); 

            return dtoP2;
        } catch (CreateException e) {
            codigoError = CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB;
            throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));
        } catch (RemoteException e) {
            codigoError = CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB;
            throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));
        }
    }

    public DTOOID crearClienteBasico(DTOCrearClienteBasico dto) throws MareException {
        UtilidadesLog.info("MONClientesBean.crearClienteBasico(DTOCrearClienteBasico): Entrada"); 
        DTOOID dtooid = new DTOOID();
        dtooid.setOid(this.insertarClienteBasico(dto));
        UtilidadesLog.info("MONClientesBean.crearClienteBasico(DTOCrearClienteBasico): Salida"); 

        return dtooid;
    }

    public DTOPremioRecomendacion insertar(DTOCliente dto) throws MareException {
        UtilidadesLog.info("MONClientesBean.insertar(DTOCliente): Entrada"); 
        ClienteDatosBasicosLocalHome clienteDBasicosLH;
        ClienteDatosBasicosLocal clienteDBasicosL;
        ClienteDatosAdicionalesLocalHome clienteDAdicionalesLH;
        ClienteDatosAdicionalesLocal clienteDAdicionalesL;
        ClienteVinculoLocalHome clienteVinculoLH;
        ClienteVinculoLocal clienteVinculoL;
        ClientePreferenciaLocalHome clientePreferenciaLH;
        ClientePreferenciaLocal clientePreferenciaL;
        ClienteObservacionLocalHome clienteObservacionLH;
        ClienteObservacionLocal clienteObservacionL;
        ClientePrimerContactoLocalHome clientePrimerContactoLH;
        ClientePrimerContactoLocal clientePrimerContactoL;
        ClienteComunicacionLocalHome clienteComunicacionLH;
        ClienteComunicacionLocal clienteComunicacionL;
        ClienteTarjetaLocalHome clienteTarjetaLH;
        ClienteTarjetaLocal clienteTarjetaL;
        ClienteProblemaLocalHome clienteProblemaLH;
        ClienteProblemaLocal clienteProblemaL;
        ClientePsicografiasLocalHome clientePsicografiasLH;
        ClientePsicografiasLocal clientePsicografiasL;
        ClienteTipoSubTipoLocalHome clienteTipoSubTipoLH;
        ClienteTipoSubTipoLocal clienteTipoSubTipoL;
        TipoVinculoLocalHome tipoVinculoLH;
        TipoVinculoLocal tipoVinculoL;
        int vinculoPrincipal = 0;

        //Paso 1
        UtilidadesLog.info("insertar Paso1");

        Long oidCliente = this.insertarClienteBasico(dto.getBase());
        UtilidadesLog.info("insertar Paso1.1");

        try {
            Date now = new Date(System.currentTimeMillis());
            clienteDAdicionalesLH = new ClienteDatosAdicionalesLocalHome();
            clienteDAdicionalesL = clienteDAdicionalesLH.findByCliente(oidCliente);

            if (dto.getFechaNacimiento() != null) {
                clienteDAdicionalesL.setFec_naci(truncarFecha(dto.getFechaNacimiento()));
            }

            if (dto.getNacionalidad() != null) {
                clienteDAdicionalesL.setSnon_oid_naci(new Long(dto.getNacionalidad().longValue()));
            }

            clienteDAdicionalesL.setCod_empl(dto.getCodigoEmpleado());

            if (dto.getEdad() != null) {
                clienteDAdicionalesL.setVal_edad(new Long(dto.getEdad().longValue()));
            }

            clienteDAdicionalesL.setEscv_oid_esta_civi(dto.getEstadoCivil());
            clienteDAdicionalesL.setVal_ocup(dto.getOcupacion());
            clienteDAdicionalesL.setVal_prof(dto.getProfesion());
            clienteDAdicionalesL.setVal_cent_trab(dto.getCentroTrabajo());
            clienteDAdicionalesL.setVal_carg_dese(dto.getCargo());
            clienteDAdicionalesL.setNied_oid_nive_estu(dto.getNivelEstudios());
            clienteDAdicionalesL.setVal_cent_estu(dto.getCentroEstudios());

            if (dto.getNumeroHijos() != null) {
                clienteDAdicionalesL.setNum_hijo(new Long(dto.getNumeroHijos().longValue()));
            }

            if (dto.getPersonasDependientes() != null) {
                clienteDAdicionalesL.setNum_pers_depe(new Long(dto.getPersonasDependientes().longValue()));
            }

            clienteDAdicionalesL.setNsep_oid_nsep(dto.getNSEP());
            clienteDAdicionalesL.setTclv_oid_cicl_vida(dto.getCicloVida());

            if (dto.getDeseaCorrespondencia() != null) {
                clienteDAdicionalesL.setInd_corr(dto.getDeseaCorrespondencia().booleanValue() ? new Long(1) : new Long(0));
            } else {
                clienteDAdicionalesL.setInd_corr(new Long(0));
            }

            clienteDAdicionalesL.setImp_ingr_fami(dto.getImporteIngresos());

            //Paso 2
            UtilidadesLog.info("insertar Paso2");

            DTOVinculo[] vinculos = dto.getVinculos();

            if ((vinculos != null) && (vinculos.length > 0)) {
                int cantVinculosPrincipales = 0;
                clienteVinculoLH = new ClienteVinculoLocalHome();
                            
                for (int i = 0; i < vinculos.length; i++) {
                
                    if (vinculos[i].getPrincipal() == null) {
                        vinculos[i].setPrincipal(Boolean.FALSE);
                    } else
                    {
                        if (vinculos[i].getPrincipal().booleanValue() == true)
                        {
                            vinculoPrincipal = i;
                        }
                    }

                    if (vinculos[i].getPrincipal().booleanValue()) {
                        cantVinculosPrincipales++;
                    }
                
                    //  Modificado por HRCS - Fecha 14/08/2007 - Cambio Sicc20070361
                    //  Nuevo logica para procesar cuando el vinculo es del tipo DUPLA CYZONE: se valida si ya existe un vinculo
                    //  para actualizarlo. De contrario se crea la nueva clasificacion para el cliente y se envia un mensaje de 
                    //  bienvenida a Dupla Cyzone.
                    DAOMAEConfiguracionClientes daoCliente = new DAOMAEConfiguracionClientes(sessionContext.getCallerPrincipal().getName());
                    if (vinculos[i].getTipo().longValue() == daoCliente.getOidTipoVinculo(dto.getBase().getOidPais(),
                                                                                          ConstantesMAE.COD_TIPO_VINCULO_DUPLACYZONE).longValue() )   {
                    
                        Long periodoActual = null;
                        if (dto.getBase().getPeriodoContacto()!=null)   {
                            periodoActual = dto.getBase().getPeriodoContacto();
                            UtilidadesLog.debug("Utilizando el periodo de primer contacto: " + periodoActual);
                        }
                        else    {
                            RecordSet rs = this.obtenerPeriodoActualPorFecha( dto.getBase().getOidPais(),
                                                                              dto.getBase().getClasificaciones()[0].getMarca(), 
                                                                              dto.getBase().getClasificaciones()[0].getCanal() );
                            periodoActual = new Long( ((BigDecimal)rs.getValueAt(0,1)).longValue() );
                        }
                        //  Validar si ya existe
                        Long oidClienteVinculo = this.buscarClienteVinculoDuplaCyzone( vinculos[i].getOidCliente(), now );
                        if (oidClienteVinculo!=null)    {
                            //  Actualizar Vinculo
                            this.actualizarFechaHastaClienteVinculo( oidClienteVinculo );
                        }
                        else    {
                            //  Insertar Nueva Clasificacion Dupla Cyzone
                            this.crearClasificacionDuplaCyzone( vinculos[i].getOidCliente(), periodoActual, now);
                        }
                        //  Comunicar Bienvenida Dupla
                        this.comunicarBienvenidaDuplaCyzone( vinculos[i].getOidCliente(), dto.getBase().getOidPais(), dto.getBase().getOidIdioma() );
                        
                        //  Crear el nuevo vinculo de Dupla Cyzone con fecha hasta = null
                        vinculos[i].setFechaHasta(null);
                        this.crearClienteVinculo(oidCliente, vinculos[i], clienteVinculoLH, now);
                    }
                    else    {
                        //  Procede de la forma normal
                        this.crearClienteVinculo(oidCliente, vinculos[i], clienteVinculoLH, now);
                    }
                }

                if (cantVinculosPrincipales > 1) {
                    UtilidadesLog.error("insertar vinculos != 1: " + cantVinculosPrincipales);
                    throw new IllegalArgumentException("Se ha recibido en la inserción " + "de clientes un DTOCliente con varios vinculos principales");
                }
            }

            //Paso 3
            UtilidadesLog.info("insertar Paso3"); 
            

            DTOPreferencia[] preferencias = dto.getPreferencias();

            if (preferencias != null) {
                clientePreferenciaLH = new ClientePreferenciaLocalHome();

                for (int i = 0; i < preferencias.length; i++) {
                    clientePreferenciaL = clientePreferenciaLH.create(oidCliente, preferencias[i].getTipo());
                    clientePreferenciaL.setDes_clie_pref(preferencias[i].getDescripcion());
                }
            }

            //Paso 4
            UtilidadesLog.info("insertar Paso4");

            DTOObservacion[] observaciones = dto.getObservaciones();

            if (observaciones != null) {
                clienteObservacionLH = new ClienteObservacionLocalHome();

                for (int i = 0; i < observaciones.length; i++) {
                    clienteObservacionL = clienteObservacionLH.create(observaciones[i].getMarca(), oidCliente, new Long(observaciones[i].getNumero().longValue()), observaciones[i].getTexto());
                }
            }

            //Paso 5
            UtilidadesLog.info("insertar Paso5");

            if ((dto.getOidClienteContactado() != null) && (dto.getTipoClienteContactado() != null)) {
                clienteTipoSubTipoLH = new ClienteTipoSubTipoLocalHome();
                clienteTipoSubTipoL = clienteTipoSubTipoLH.findByClienteTipo(dto.getOidClienteContactado(), dto.getTipoClienteContactado());

                Long oidTipoSubtipo = clienteTipoSubTipoL.getOid();

                clientePrimerContactoLH = new ClientePrimerContactoLocalHome();

                clientePrimerContactoL = clientePrimerContactoLH.create(oidCliente, oidTipoSubtipo, now);

                UtilidadesLog.info("---------- FechaContacto 1");

                if (dto.getTipoContacto() != null) {
                    clientePrimerContactoL.setCod_tipo_cont("" + dto.getTipoContacto());
                }

                UtilidadesLog.info("---------- FechaContacto 3");

                if (dto.getFechaSiguienteContacto() != null) {
                    UtilidadesLog.info("   dto.getFechaSiguienteContacto(): " + dto.getFechaSiguienteContacto().toString());
                    clientePrimerContactoL.setFec_sigu_cont(new Timestamp(truncarFecha(dto.getFechaSiguienteContacto()).getTime()));
                }

                UtilidadesLog.info("---------- FechaContacto 4");

                if (dto.getFechaPrimerContacto() != null) {
                    UtilidadesLog.info("  dto.getFechaPrimerContacto(): " + dto.getFechaPrimerContacto().toString());
                    clientePrimerContactoL.setFec_cont(new Timestamp(truncarFecha(dto.getFechaPrimerContacto()).getTime()));
                }

                UtilidadesLog.info("---------- Marca ");

                Long marcaContacto = dto.getMarcaContacto();

                if (marcaContacto != null) {
                    UtilidadesLog.info(" dto.getMarcaContacto(): " + marcaContacto.toString());
                    clientePrimerContactoL.setMarc_oid_marc(marcaContacto);
                }

                UtilidadesLog.info("--------- Canal ");

                Long canalContacto = dto.getCanalContacto();

                if (canalContacto != null) {
                    UtilidadesLog.info(" dto.getCanalContacto(): " + canalContacto.toString());
                    clientePrimerContactoL.setCana_oid_cana(canalContacto);
                }

                UtilidadesLog.info("-------- Periodo ");

                Long periodoContacto = dto.getPeriodoContacto();

                if (periodoContacto != null) {
                    UtilidadesLog.info(" dto.getPeriodoContacto(): " + periodoContacto.toString());
                    clientePrimerContactoL.setPerd_oid_peri(periodoContacto);
                }
            }

            //Paso 6
            UtilidadesLog.info("insertar Paso6");

            DTOComunicacion[] comunicaciones = dto.getComunicaciones();

            if (comunicaciones != null) {
                clienteComunicacionLH = new ClienteComunicacionLocalHome();

                for (int i = 0; i < comunicaciones.length; i++) {
                    if (comunicaciones[i].getPrincipal() == null) {
                        comunicaciones[i].setPrincipal(Boolean.FALSE);
                    }

                    clienteComunicacionL = clienteComunicacionLH.create(oidCliente, comunicaciones[i].getTipoComunicacion(), now);

                    clienteComunicacionL.setInd_comu_ppal(comunicaciones[i].getPrincipal().booleanValue() ? new Long(1) : new Long(0));

                    if (comunicaciones[i].getDiaComunicacion() != null) {
                        clienteComunicacionL.setVal_dia_comu(new String(comunicaciones[i].getDiaComunicacion().toString()));
                    }

                    // by Ssantana
                    if (comunicaciones[i].getHoraDesde() != null) {
                        clienteComunicacionL.setFec_hora_desd(new Timestamp(comunicaciones[i].getHoraDesde().longValue()));
                    } else {
                        clienteComunicacionL.setFec_hora_desd(null);
                    }

                    if (comunicaciones[i].getHoraHasta() != null) {
                        clienteComunicacionL.setFec_hora_hast(new Timestamp(comunicaciones[i].getHoraHasta().longValue()));
                    } else {
                        clienteComunicacionL.setFec_hora_hast(null);
                    }

                    // end 

                    /*                    clienteComunicacionL.setFec_hora_desd(new Timestamp(comunicaciones[i].getHoraDesde().longValue()));
                                        clienteComunicacionL.setFec_hora_hast(new Timestamp(comunicaciones[i].getHoraHasta().longValue());
                                        clienteComunicacionL.setVal_hora_desd(comunicaciones[i].getHoraDesde());
                                        clienteComunicacionL.setVal_hora_hast(comunicaciones[i].getHoraHasta());*/
                    if (comunicaciones[i].getIntervaloComunicacion() != null) {
                        clienteComunicacionL.setVal_inte_comu(comunicaciones[i].getIntervaloComunicacion().booleanValue() ? new Long(1) : new Long(0));
                    } else {
                        clienteComunicacionL.setVal_inte_comu(new Long(0));
                    }

                    clienteComunicacionL.setVal_text_comu(comunicaciones[i].getTextoComunicacion());
                }
            }

            //Paso 7
            UtilidadesLog.info("insertar Paso7");

            DTOTarjeta[] tarjetas = dto.getTarjetas();

            if (tarjetas != null) {
                clienteTarjetaLH = new ClienteTarjetaLocalHome();

                for (int i = 0; i < tarjetas.length; i++) {
                    clienteTarjetaL = clienteTarjetaLH.create(oidCliente, tarjetas[i].getTipo());

                    clienteTarjetaL.setCban_oid_banc(tarjetas[i].getBanco());
                    clienteTarjetaL.setClta_oid_clas_tarj(tarjetas[i].getClase());
                }
            }

            //Paso 8
            UtilidadesLog.info("insertar Paso8");

            DTOProblemaSolucion[] problemas = dto.getProblemasSoluciones();

            if (problemas != null) {
                clienteProblemaLH = new ClienteProblemaLocalHome();

                for (int i = 0; i < problemas.length; i++) {
                    clienteProblemaL = clienteProblemaLH.create(oidCliente, problemas[i].getTipoProblema(), problemas[i].getSolucion());

                    clienteProblemaL.setDes_prob(problemas[i].getDescripcionProblema());
                    clienteProblemaL.setVal_nego_prod(problemas[i].getNegocio());

                    clienteProblemaL.setDes_solu(problemas[i].getDescripcionSolucion());
                    clienteProblemaL.setTsoc_oid_tipo_solu(problemas[i].getTipoSolucion());
                }
            }

            //if null
            //Paso 9
            UtilidadesLog.info("insertar Paso9");

            DTOPsicografia[] psicografias = dto.getPsicografias();

            if (psicografias != null) {
                clientePsicografiasLH = new ClientePsicografiasLocalHome();

                for (int i = 0; i < psicografias.length; i++) {
                    clientePsicografiasL = clientePsicografiasLH.create(oidCliente, psicografias[i].getMarca(), psicografias[i].getTipoPerfil());

                    clientePsicografiasL.setCod_test(psicografias[i].getCodigoTest());

                    if (psicografias[i].getFecha() != null) {
                        clientePsicografiasL.setFec_psic(new Timestamp(truncarFecha(psicografias[i].getFecha()).getTime()));
                    }
                }
            }

            //Paso 11
            UtilidadesLog.info("insertar Paso11");
            clienteDBasicosLH = new ClienteDatosBasicosLocalHome();
            clienteDBasicosL = clienteDBasicosLH.findByPrimaryKey(oidCliente);

            clienteDAdicionalesLH = new ClienteDatosAdicionalesLocalHome();
            clienteDAdicionalesL = clienteDAdicionalesLH.findByCliente(oidCliente);

            UtilidadesLog.info("insertar Paso11.1");
            this.insertarCriteriosBusqueda(clienteDBasicosL, clienteDAdicionalesL, dto.getOidIdioma());

            //Se va a cerar el DTOBuzonMensajes
            UtilidadesLog.info("Se va a cerar el DTOBuzonMensajes");

            DTOBuzonMensajes dtoBuzonMsg = new DTOBuzonMensajes();
            UtilidadesLog.info("Se creo DTOBuzonMensajes");
            dtoBuzonMsg.setCodigoMensaje(new String("MAE01"));
            UtilidadesLog.info("Se setean valores al dtoBuzonMsg.setOidCliente(oidCliente)" + oidCliente);
            dtoBuzonMsg.setOidCliente(oidCliente);
            
            dtoBuzonMsg.setModuloOrigen(new Long(ConstantesSEG.MODULO_MAE));
            UtilidadesLog.info("Se setean valores al dto.getBase().getTratamientoDesc()" );
            dtoBuzonMsg.setDatoVariable1(dto.getBase().getTratamientoDesc());

            String nombreCompleto = dto.getBase().getNombre1() + " " + dto.getBase().getNombre2() + " " + dto.getBase().getApellido1() + " " + dto.getBase().getApellido2();
            
            UtilidadesLog.info("Trataamiento nombre completo");
            if (nombreCompleto.length() > 100) {
                nombreCompleto = nombreCompleto.substring(0, 100);
            }

            dtoBuzonMsg.setDatoVariable2(nombreCompleto);
            dtoBuzonMsg.setDatoVariable3("false");
            dtoBuzonMsg.setOidIdioma(dto.getBase().getOidIdioma());
            dtoBuzonMsg.setOidPais(dto.getBase().getOidPais());
            UtilidadesLog.info("JOJOJJOJOJOJ");

            MONGestionMensajes monMSG = MSGEjbLocators.getMONGestionMensajesHome().create();
            UtilidadesLog.info("Va a insertar un mensaje..");
            monMSG.insertaDatosMensaje(dtoBuzonMsg);
            UtilidadesLog.info("YA inserto el mensaje....");

            UtilidadesLog.info("insertar Paso10");

            DTOPremioRecomendacion resultado = new DTOPremioRecomendacion();

            if ((vinculos != null) && (vinculos.length > 0) && (vinculos[0] != null)) {
                tipoVinculoLH = new TipoVinculoLocalHome();

                tipoVinculoL = tipoVinculoLH.findByPrimaryKey(vinculos[vinculoPrincipal].getTipo());

                Long indicador = tipoVinculoL.getInd_reco();

                if ((indicador != null) && (indicador.longValue() == 1)) {
                
                /*inicio modificado ciglesias incidencia 24377 17/11/2006
                    resultado.setClienteRecomendante(oidCliente);
                    resultado.setClienteRecomendado(vinculos[vinculoPrincipal].getOidCliente());
                */
                    resultado.setClienteRecomendante(vinculos[vinculoPrincipal].getOidCliente());
                    resultado.setClienteRecomendado(oidCliente);
                    
                /*fin modificado ciglesias 24377*/

                    return resultado;
                }
            } else {
                UtilidadesLog.info("insertar Paso10, fin sin vinculos que grabar.");
            }
            
            UtilidadesLog.info("MONClientesBean.insertar(DTOCliente): Salida"); 

            return resultado;
        } catch (CreateException createException) {
            UtilidadesLog.info("CreateException createException: Salida");           
            sessionContext.setRollbackOnly();
            throw new MareException(createException, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS));
        } catch (MareException me) {
            UtilidadesLog.info("MareException me: Salida");
            sessionContext.setRollbackOnly();
            throw me;
        } catch (Exception ex) {
            UtilidadesLog.info("Exception ex: Salida");
            sessionContext.setRollbackOnly();
            throw new MareException(ex, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS));
        }
    }

    public DTOPestanya3 pestanya3Busqueda(DTOBelcorp dtoBelcorp) throws MareException {
        UtilidadesLog.info("MONClientesBean.pestanya3Busqueda(DTOBelcorp): Entrada"); 
        String codigoError;
        DTOPestanya3Base dtoPestanya3B = new DTOPestanya3Base();
        DTOPestanya3 dtoPesta3 = new DTOPestanya3();
        DAOMAEConfiguracionClientes daoCliente = new DAOMAEConfiguracionClientes(sessionContext.getCallerPrincipal().getName());
        RecordSet rsClie = new RecordSet();
        DTOSalida sl = new DTOSalida();
        RecordSet rsVia = new RecordSet();
        DTOSalida slMarcas = new DTOSalida();
        RecordSet rsMarcas = new RecordSet();
        RecordSet rsTipoClie = new RecordSet();
        RecordSet rsComunica = new RecordSet();

        //niveles 
        //nivelGeograficoPadre
        //tipos de direcciones
        rsClie = daoCliente.obtenerTiposDireccion(dtoBelcorp);
        dtoPestanya3B.setTiposDirecciones(rsClie);

        //usaGeorefenciador
        try {
            MONMantenimientoSEG monSEG = SEGEjbLocators.getMONMantenimientoSEGHome().create();
            Boolean tieneGeo = monSEG.usaGeoreferenciador(dtoBelcorp.getOidPais());

            /*Cleal MAE-03
            if (tieneGeo.booleanValue()) {
                dtoPestanya3B.setTipoVia(null);
            } else {
                sl = monSEG.recuperarTiposVia(dtoBelcorp);
                rsVia = sl.getResultado();
                dtoPestanya3B.setTipoVia(rsVia);
            }*/
            dtoPestanya3B.setUsaGeoreferenciador(tieneGeo);
            UtilidadesLog.debug("*** tieneGeo: "+tieneGeo);
            sl = monSEG.recuperarTiposVia(dtoBelcorp);
            rsVia = sl.getResultado();
            dtoPestanya3B.setTipoVia(rsVia);

            //marcas
            slMarcas = monSEG.recuperarMarcas(dtoBelcorp, Boolean.TRUE);
            rsMarcas = slMarcas.getResultado();
            dtoPestanya3B.setMarcas(rsMarcas);

            //canales, tiposClasificacion y clasificacion
            dtoPestanya3B.setCanales(null);
            dtoPestanya3B.setTiposClasificacion(null);
            dtoPestanya3B.setClasificaciones(null);

            //llena el DTOPestanya3
            dtoPesta3.setBase(dtoPestanya3B);

            rsComunica = daoCliente.obtenerTiposComunicacionPorPais(dtoBelcorp);
            dtoPesta3.setTiposComunicacion(rsComunica);

            DTOTipoSubtipo dtoSubTipo = new DTOTipoSubtipo();
            dtoSubTipo = daoCliente.obtenerTipoSubtipo(dtoBelcorp);

            rsTipoClie = dtoSubTipo.getTipos();
            dtoPesta3.setTiposCliente(rsTipoClie);

            //oidCLientesVinculo y oidClienteContacto
            dtoPesta3.setOidClientesVinculo(null);
            dtoPesta3.setOidClienteContacto(null);
        } catch (CreateException e) {
            codigoError = CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB;
            throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));
        } catch (RemoteException e) {
            codigoError = CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB;
            throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));
        }
        UtilidadesLog.info("MONClientesBean.pestanya3Busqueda(DTOBelcorp): Salida"); 

        return dtoPesta3;
    }

    public DTOCliente obtenerCliente(DTOOID oid) throws MareException {
        UtilidadesLog.info("MONClientesBean.obtenerCliente(DTOOID): Entrada"); 
        DAOMAEMaestroClientes dao = new DAOMAEMaestroClientes(sessionContext.getCallerPrincipal().getName());
        UtilidadesLog.info("MONClientesBean.obtenerCliente(DTOOID): Salida"); 

        return dao.obtenerCliente(oid);
    }

    public DTOPestanya4 pestanya4Busqueda(DTOBelcorp dto) throws MareException {
        UtilidadesLog.info("MONClientesBean.pestanya4Busqueda(DTOBelcorp): Entrada"); 
        String codigoError;
        DAOMAEConfiguracionClientes dmcc = new DAOMAEConfiguracionClientes(sessionContext.getCallerPrincipal().getName());
        DTOPestanya4 dtop4 = new DTOPestanya4();
        DTOClasificaciones dtoclas = new DTOClasificaciones();

        try {
            MONMantenimientoSEG MonmSeg = SEGEjbLocators.getMONMantenimientoSEGHome().create();
            MONMantenimientoCCC MonCCC = CCCEjbLocators.getMONMantenimientoCCCHome().create();
            dtop4.setTiposTarjeta(dmcc.obtenerTiposTarjeta(dto));
            dtop4.setClasesTarjeta(dmcc.obtenerClasesTarjeta(dto));
            dtop4.setTiposProblema(dmcc.obtenerTiposProblemaPais(dto));
            dtop4.setTiposSolucion(dmcc.obtenerTiposSolucionPais(dto));

            //dtop4.setTiposPerfil(dmcc.obtenerPerfilesPsicograficosPais(dto));
            dtop4.setMarcas(MonmSeg.recuperarMarcas(dto).getResultado());
            dtop4.setCanales(MonmSeg.recuperarCanales(dto).getResultado());
            dtop4.setBancos(MonCCC.obtenerBancos(dto));

            // Obtiene RecordSet Clasificaciones. 
            RecordSet rTipo = dmcc.obtenerClasificaciones(dto).getTipoClasificacion();
            RecordSet rClasif = dmcc.obtenerClasificaciones(dto).getClasificacion();
            UtilidadesLog.info("Tipos Clasificacion: " + rTipo.toString());
            UtilidadesLog.info("Clasificacion: " + rClasif.toString());
            dtop4.setClasificaciones(rClasif);
            dtop4.setTiposClasificacion(rTipo);

            //Obtiene tipos subtipos
            RecordSet rTipoCli = dmcc.obtenerTipoSubtipo(dto).getTipos();
            RecordSet rSubtiCli = dmcc.obtenerTipoSubtipo(dto).getSubtipos();
            dtop4.setTipos(rTipoCli);
            dtop4.setSubtipos(rSubtiCli);

            UtilidadesLog.info(dtop4.toString());
            UtilidadesLog.info("MONClientesBean.pestanya4Busqueda(DTOBelcorp): Salida"); 

            return dtop4;
        } catch (CreateException e) {
            codigoError = CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB;
            throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));
        } catch (RemoteException e) {
            codigoError = CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB;
            throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));
        }
    }

    public DTOPestanya2 pestanya2(DTOCodigoCliente dto) throws MareException {
        UtilidadesLog.info("MONClientesBean.pestanya2(DTOCodigoCliente): Entrada"); 
        String codigoError;
        DTOBelcorp dtoBelcorp = new DTOBelcorp();

        dtoBelcorp.setOidIdioma(dto.getOidIdioma());
        dtoBelcorp.setOidPais(dto.getOidPais());

        DTOSalida dtoSalida = new DTOSalida();
        
        java.util.Date fechaI = null;
        java.util.Date fechaF = null;

        try {
            fechaI = new java.util.Date();        
            DTOPestanya2Base dtop2B = this.pestanya2Base(dto);
            fechaF = new java.util.Date();
            UtilidadesLog.debug("Tiempo pestanya2Base():" + (fechaF.getTime() - fechaI.getTime()) );
            DTOPestanya2 dtop2 = new DTOPestanya2();
            MONMantenimientoSEG MonmSeg = SEGEjbLocators.getMONMantenimientoSEGHome().create();
            DAOMAEConfiguracionClientes dmcc = new DAOMAEConfiguracionClientes(sessionContext.getCallerPrincipal().getName());
            dtop2.setBase(dtop2B);
            
            fechaI = new java.util.Date();        
            dtop2.setNacionalidad(MonmSeg.recuperarNacionalidades(dto).getResultado());
            fechaF = new java.util.Date();            
            UtilidadesLog.debug("Tiempo recuperarNacionalidades():" + (fechaF.getTime() - fechaI.getTime()) );            

            fechaI = new java.util.Date();
            dtop2.setEstadoCivil(dmcc.obtenerEstadosCiviles(dto));
            fechaF = new java.util.Date();            
            UtilidadesLog.debug("Tiempo obtenerEstadosCiviles():" + (fechaF.getTime() - fechaI.getTime()) );            
            
            fechaI = new java.util.Date();
            dtop2.setNivelEstudios(dmcc.obtenerNivelesEstudiosPorPais(dto));
            fechaF = new java.util.Date();            
            UtilidadesLog.debug("Tiempo obtenerNivelesEstudiosPorPais():" + (fechaF.getTime() - fechaI.getTime()) );            
            
            fechaI = new java.util.Date();
            dtop2.setNSEP(dmcc.buscarTipoNSEPPorPais(dto));
            fechaF = new java.util.Date();            
            UtilidadesLog.debug("Tiempo buscarTipoNSEPPorPais():" + (fechaF.getTime() - fechaI.getTime()) );            
            
            fechaI = new java.util.Date();
            dtop2.setCiclosVida(dmcc.obtenerCiclosVida(dto));
            fechaF = new java.util.Date();            
            UtilidadesLog.debug("Tiempo obtenerCiclosVida():" + (fechaF.getTime() - fechaI.getTime()) );            
            
            /*fechaI = new java.util.Date();
            dtop2.setPaises(MonmSeg.recuperarPaisesSinTodos(dto).getResultado());
            fechaF = new java.util.Date();            
            UtilidadesLog.debug("Tiempo recuperarPaisesSinTodos():" + (fechaF.getTime() - fechaI.getTime()) );*/
            
            fechaI = new java.util.Date();
            dtop2.setTiposPreferencias(dmcc.obtenerTiposPreferenciasPorPais(dto));
            fechaF = new java.util.Date();            
            UtilidadesLog.debug("Tiempo obtenerTiposPreferenciasPorPais():" + (fechaF.getTime() - fechaI.getTime()) );            
            
            fechaI = new java.util.Date();
            dtop2.setMarcas(MonmSeg.recuperarMarcas(dto).getResultado());
            fechaF = new java.util.Date();            
            UtilidadesLog.debug("Tiempo recuperarMarcas():" + (fechaF.getTime() - fechaI.getTime()) );            
            
            fechaI = new java.util.Date();
            dtop2.setTiposVinculo(dmcc.obtenerTiposVinculosPais(dto));
            fechaF = new java.util.Date();            
            UtilidadesLog.debug("Tiempo obtenerTiposVinculosPais():" + (fechaF.getTime() - fechaI.getTime()) );            
            
            fechaI = new java.util.Date();
            dtop2.setTipoCliente(dmcc.obtenerTipos(dto));
            fechaF = new java.util.Date();            
            UtilidadesLog.debug("Tiempo obtenerTipos():" + (fechaF.getTime() - fechaI.getTime()) );            
            
            fechaI = new java.util.Date();
            dtoSalida = MonmSeg.recuperarCanales(dtoBelcorp, Boolean.FALSE);
            fechaF = new java.util.Date();            
            UtilidadesLog.debug("Tiempo recuperarCanales():" + (fechaF.getTime() - fechaI.getTime()) );            
            
            dtop2.setCanales(dtoSalida.getResultado());

            /*RecordSet rs = dtop2.getPaises();
            RecordSet datos = new RecordSet();
            datos.addColumn(new String("OID"));
            datos.addColumn(new String("LONGITUDES"));

            int i = rs.getRowCount();
            
            for (int indice = 0; indice < i; indice++) {
                fechaI = new java.util.Date();    
                datos.addRow(this.getVector(rs.getValueAt(indice, "OID_PAIS"), MonmSeg.obtenerLongitudNumeroCliente(dto.getOidPais())));
                fechaF = new java.util.Date();            
                UtilidadesLog.debug("Tiempo obtenerLongitudNumeroCliente():" + (fechaF.getTime() - fechaI.getTime()) );            
            }

            dtop2.setLongitudesCodigoClientePais(datos);*/
            UtilidadesLog.info("MONClientesBean.pestanya2(DTOCodigoCliente): Salida"); 

            return dtop2;
        } catch (CreateException e) {
            codigoError = CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB;
            throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));
        } catch (RemoteException e) {
            codigoError = CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB;
            throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));
        }
    }

    private Vector getVector(Object rs, Object obj) {
        Vector vc = new Vector();
        vc.addElement((rs));
        vc.addElement(obj);

        return vc;
    }

    public DTOPestanya4 pestanya4(DTOObtenerPestanya4 dto) throws MareException {
        UtilidadesLog.info("MONClientesBean.pestanya4(DTOObtenerPestanya4): Entrada"); 
        String codigoError;
        DTOPestanya4 dtop4 = new DTOPestanya4();
        DTOSalida dtoS = new DTOSalida();
        DTOBelcorp dtoB = new DTOBelcorp();

        DAOMAEConfiguracionClientes dmcc = new DAOMAEConfiguracionClientes(sessionContext.getCallerPrincipal().getName());

        try {
            Long[] subtipos = dto.getSubtipoCliente();
            DTOOID dtoOidSubTipo;

            //DTOOIDs dtoOidsSubTipo;      
            DTOClasificaciones clasificacionesActuales;
            RecordSet rsClasificaciones = new RecordSet();
            RecordSet rsTiposClasificacion = new RecordSet();
            RecordSet rsAux1;
            RecordSet rsAux2;

            if (subtipos != null) {
                /*          dtoOidsSubTipo = new DTOOIDs();
                          dtoOidsSubTipo.setOids(subtipos);
                                                        dtoOidsSubTipo.setOidPais( dto.getOidPais() );
                                                        dtoOidsSubTipo.setOidIdioma( dto.getOidIdioma() );
                          clasificacionesActuales = dmcc.obtenerClasificacionesSubtipo(dtoOidsSubTipo);
                          rsTiposClasificacion = clasificacionesActuales.getTipoClasificacion();
                          rsClasificaciones = clasificacionesActuales.getClasificacion();*/
                for (int i = 0; i < subtipos.length; i++) {
                    dtoOidSubTipo = new DTOOID();
                    dtoOidSubTipo.setOid(subtipos[i]);
                    dtoOidSubTipo.setOidPais(dto.getOidPais());
                    dtoOidSubTipo.setOidIdioma(dto.getOidIdioma());

                    clasificacionesActuales = dmcc.obtenerClasificacionesSubtipo(dtoOidSubTipo);
                    rsAux1 = clasificacionesActuales.getClasificacion();
                    rsAux2 = clasificacionesActuales.getTipoClasificacion();

                    if (rsClasificaciones.getColumnIdentifiers().size() == 0) {
                        rsClasificaciones.setColumnIdentifiers(rsAux1.getColumnIdentifiers());
                    }

                    if (rsTiposClasificacion.getColumnIdentifiers().size() == 0) {
                        rsTiposClasificacion.setColumnIdentifiers(rsAux2.getColumnIdentifiers());
                    }

                    for (int j = 0;
                            !rsAux1.esVacio() && (j < rsAux1.getRowCount());
                            j++) {
                        rsClasificaciones.addRow(rsAux1.getRow(j));
                    }

                    for (int j = 0;
                            !rsAux2.esVacio() && (j < rsAux2.getRowCount());
                            j++) {
                        rsTiposClasificacion.addRow(rsAux2.getRow(j));
                    }
                }
            }

            MONMantenimientoCCC MonCCC = CCCEjbLocators.getMONMantenimientoCCCHome().create();
            MONMantenimientoSEG MonmSeg = SEGEjbLocators.getMONMantenimientoSEGHome().create();

            dtop4.setTiposTarjeta(dmcc.obtenerTiposTarjeta(dto));
            dtop4.setClasesTarjeta(dmcc.obtenerClasesTarjeta(dto));
            dtop4.setBancos(MonCCC.obtenerBancos(dto));
            dtop4.setCanales(MonmSeg.recuperarCanales(dto).getResultado());
            dtop4.setTiposProblema(dmcc.obtenerTiposProblemaPais(dto));
            dtop4.setTiposSolucion(dmcc.obtenerTiposSolucionPais(dto));
            dtop4.setTiposPerfiles(dmcc.obtenerPerfilesPsicograficosPais(dto)); //inc. 2597

            dtop4.setTiposClasificacion(rsTiposClasificacion);
            dtop4.setClasificaciones(rsClasificaciones);

            dtop4.setMarcasSeleccionadas(recuperarTraduccionesMarcas(dto));
            UtilidadesLog.info("MONClientesBean.pestanya4(DTOObtenerPestanya4): Salida"); 

            return dtop4;
        } catch (CreateException e) {
            codigoError = CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB;
            throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));
        } catch (RemoteException e) {
            codigoError = CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB;
            throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));
        }
    }

    private RecordSet recuperarTraduccionesMarcas(DTOObtenerPestanya4 dto) throws MareException {
        UtilidadesLog.info("MONClientesBean.recuperarTraduccionesMarcas(DTOObtenerPestanya4): Entrada"); 
        DTOSalida dtos = null;

        try {
            MONMantenimientoSEGHome mmsHome = SEGEjbLocators.getMONMantenimientoSEGHome();
            dtos = mmsHome.create().recuperarMarcas(dto);
        } catch (Exception e) {
            throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
        }

        if (dtos != null) {
            Long[] marcasElegidas = dto.getMarcasElegidas();
            HashSet hsMarcasElegidas = new HashSet();

            if (marcasElegidas != null) {
                for (int i = 0; i < marcasElegidas.length; i++) {
                    hsMarcasElegidas.add(marcasElegidas[i]);
                }
            }

            RecordSet rsMarcas = dtos.getResultado();
            Long marcaActual = null;

            if (rsMarcas != null) {
                rsMarcas.removeColumn(2);

                for (int i = 0; i < rsMarcas.getRowCount(); i++) {
                    marcaActual = new Long(((BigDecimal) rsMarcas.getValueAt(i, 0)).longValue());

                    if (!(hsMarcasElegidas.contains(marcaActual))) {
                        rsMarcas.removeRow(i);
                        i--;
                    }
                }
            }
            UtilidadesLog.info("MONClientesBean.recuperarTraduccionesMarcas(DTOObtenerPestanya4): Salida");  
            return rsMarcas;
        } else {
            UtilidadesLog.info("MONClientesBean.recuperarTraduccionesMarcas(DTOObtenerPestanya4): Salida"); 
            return new RecordSet();
        }
    }

    public void desactivar(DTOClienteIndicador dTOClieInd) throws MareException {
         UtilidadesLog.info("MONClientesBean.desactivar(DTOClienteIndicador): Entrada"); 
         
        DTOOIDs clientes = dTOClieInd.getOidindicadores();
        int size = clientes.getOids().length;
        try {

            for (int u = 0; u < size; u++) {

                ClienteDatosAdicionalesLocalHome clienteHome = new ClienteDatosAdicionalesLocalHome();
                ClienteDatosAdicionalesLocal cliente = clienteHome.findByCliente(clientes.getOids()[u]);
                UtilidadesLog.info(cliente.getPrimaryKey().toString());
                UtilidadesLog.debug("*** dTOClieInd.getIndicadores()[u]: "+dTOClieInd.getIndicadores()[u]);
                if(dTOClieInd.getIndicadores()[u].equals(ConstantesMAE.IND_CLIEN_ACTIVO)){
                    cliente.setInd_acti(new Long(0)); // 0 = false
                    UtilidadesLog.info("*** Desactivo cliente: "+cliente.getOid());
                } else {
                    cliente.setInd_acti(new Long(1));
                    UtilidadesLog.info("*** Activo cliente: "+cliente.getOid());
                }
                try {
                    clienteHome.merge(cliente);
                } catch (PersistenceException pe) {
                    sessionContext.setRollbackOnly();
                    String error = CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS;
                    throw new MareException(pe, UtilidadesError.armarCodigoError(error));
                }
                actualizarFecUltiActuaCliente(cliente.getClie_oid_clie());
            }
            UtilidadesLog.info("MONClientesBean.desactivar(DTOClienteIndicador): Salida");
        } catch (NoResultException nre) {
            //	Si no se encuentra la entidad se debe lanzar una MareException ya que es un error interno del sistema 
            // porque un usuario nunca puede borrar clientes. 
            UtilidadesLog.error(nre);
            sessionContext.setRollbackOnly();
            throw new MareException(nre, UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
        } catch (PersistenceException pe) {
            sessionContext.setRollbackOnly();
            String error = CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS;
            throw new MareException(pe, UtilidadesError.armarCodigoError(error));
        }
         
    }
    
    private void actualizarFecUltiActuaCliente (Long cliente)throws MareException{
        StringBuffer sb = new StringBuffer();
        sb.append("update mae_clien m set m.FEC_ULTI_ACTU = sysdate where oid_clie = "+cliente);
        try{
            BelcorpService.getInstance().dbService.executeUpdate(sb.toString());
        }catch(Exception e){
            UtilidadesLog.error("ERROR",e);
            throw new MareException(e);
        }
    }

    public DTOSalida buscar(DTOCliente dto) throws MareException {
        UtilidadesLog.info("MONClientesBean.buscar(DTOCliente): Entrada"); 
        DAOMAEMaestroClientes dao = new DAOMAEMaestroClientes(sessionContext.getCallerPrincipal().getName());
        UtilidadesLog.info("MONClientesBean.buscar(DTOCliente): Salida"); 
        return dao.buscarClientes(dto);
    }

    public Boolean comprobarCodigosCliente(DTOValidarClientes dto, DTOPestanya3 resultado) throws MareException {
         UtilidadesLog.info("MONClientesBean.comprobarCodigosCliente(DTOValidarClientes, DTOPestanya3): Entrada"); 
        /*
         * Este método se utiliza en los mantenimientos de clientes para válidar códigos de cliente introducidos por el
         * sistema, si el cliente es encontrado se obtiene su oid. Si están todos los clientes se devuelve false indicando
         * que no hay ningún problema, si falta alguno se devuelve true. */
        /*  En el caso de clienteContacto además hay que validar que es del tipo indicado por tipoClienteContacto. */
        ClienteDatosBasicosLocalHome basicoHome;

        try {
            basicoHome = new ClienteDatosBasicosLocalHome();

            if (dto.getClientesVinculo() != null) {
                int longitud = dto.getClientesVinculo().length;
                Long[] oidsClientesVinculos = new Long[longitud];

                resultado.setOidClientesVinculo(oidsClientesVinculos); //por si falla el finder de abajo, asignamos un array vacio.

                //Buscamos el oid de cada cliente de vinculos, si hay cualquier problema se captura la excepcion y no se continua 
                ClienteDatosBasicosLocal cliente = null;
                UtilidadesLog.info("Antes de chequeo de Vinculos");

                for (int i = 0; i < longitud; i++) {
                    UtilidadesLog.info("Bucle " + i);
                    cliente = basicoHome.findByCodigoYPais(dto.getPaisesVinculo()[i], dto.getClientesVinculo()[i]);
                    oidsClientesVinculos[i] = cliente.getOid();
                }

                UtilidadesLog.info("Luego de chequeo de Vinculos");
                resultado.setOidClientesVinculo(oidsClientesVinculos);
            } else {
                resultado.setOidClientesVinculo(null);
            }

            //Ahora buscamos el cliente contactado 
            ClienteDatosBasicosLocal clienteContactado = basicoHome.findByCodigoYPais(dto.getPaisContactado(), dto.getClienteContacto());

            // Sólo resta comprobar que es del tipo indicado 
            DAOMAEMaestroClientes daoMaesCliente = new DAOMAEMaestroClientes(sessionContext.getCallerPrincipal().getName());

            UtilidadesLog.info("Cheque de Cliente Contactado");

            if ((daoMaesCliente.tieneClienteTipo(clienteContactado.getOid(), dto.getTipoClienteContacto())).booleanValue() == true) {
                UtilidadesLog.info("Match");
                resultado.setOidClienteContacto(clienteContactado.getOid());

                //resultado.setOidClienteContacto(cliente.getOid());
            } else {
                UtilidadesLog.info("No Match");
                resultado.setOidClienteContacto(new Long(0));

                //return Boolean.TRUE;
            }

            //Indicamos que no se completó correctamente y dejamos sin rellenar el atributo oidClienteContacto a propósito 
        } catch (IndexOutOfBoundsException e) {
            UtilidadesLog.info("MONClientesBean.comprobarCodigosCliente(DTOValidarClientes, DTOPestanya3): Salida"); 
            return Boolean.TRUE;
        } catch (NullPointerException e) {
            //    Salimos del método devolviendo true para indicar que no se completó correctamente la tarea. 
            UtilidadesLog.info("MONClientesBean.comprobarCodigosCliente(DTOValidarClientes, DTOPestanya3): Salida"); 
            return Boolean.TRUE;
        } catch (PersistenceException e) {
            //  Salimos del método devolviendo true para indicar que no se completó correctamente la tarea.
            UtilidadesLog.info("PersistenceException: " + e);
           // e.printStackTrace();
            UtilidadesLog.info("MONClientesBean.comprobarCodigosCliente(DTOValidarClientes, DTOPestanya3): Salida");  
            return Boolean.TRUE;
        }
        UtilidadesLog.info("MONClientesBean.comprobarCodigosCliente(DTOValidarClientes, DTOPestanya3): Salida"); 
        return Boolean.FALSE;
    }

    public DTOPestanya3 pestanya3(DTOValidarClientes dto) throws MareException {
        UtilidadesLog.info("MONClientesBean.pestanya3(DTOValidarClientes): Entrada"); 
        /* * Creamos un DTOPestanya3 resultado, que devolveremos como resultado de la llamada. */
        DTOPestanya3 dtoPest3 = new DTOPestanya3();

        /*        Llamamos al método de este MON: comprobarCodigosCliente pasandole el dto entrada y el dto resultado.
                Si nos devuelve false es que no ha encontrado ningún problema que impida continuar,
                si nos devuelve true devolvemos el dto resultado. */
        comprobarCodigosCliente(dto, dtoPest3);

        /*
        if (comprobarCodigosCliente(dto,dtoPest3).booleanValue() == true){
           return dtoPest3;
        }
        */
        /*
        Llamamos a pestanya3Base de este MON, pasandole un DTOOID que creamos con el atributo subtipoCliente del dto entrada.
        Metemos en el atributo base el dto resultado, el dto obtenido en el paso anterior. */

        // cambiado por rfalco. Antes recibia solo un oid
        DTOOIDs dtoids = new DTOOIDs();
        dtoids.setOids(new Long[] { dto.getSubtipoCliente() });
        dtoids.setOidIdioma(dto.getOidIdioma());
        dtoids.setOidPais(dto.getOidPais());

        //dtoid.setOid(dto.getSubtipoCliente());  
        dtoPest3.setBase(pestanya3Base(dtoids));

        /*        Para rellenar el atributo tiposComunicacion llamamos a
         *        DAOMAEConfiguracionClientes.obtenerTiposComunicacionPorPais pasandole el dto de entrada. */
        DAOMAEConfiguracionClientes daomaeConf = new DAOMAEConfiguracionClientes(sessionContext.getCallerPrincipal().getName());
        dtoPest3.setTiposComunicacion(daomaeConf.obtenerTiposComunicacionPorPais(dto));

        /*       Para rellenar el atributo tiposCliente cogemos el atributo tipos del dto DTOSubtipo que obtenemos al
                 llamar a DAOMAEConfiguracionClientes.obtenerTipoSubtipo, pasandole el dto de entrada.         */
        dtoPest3.setTiposCliente(daomaeConf.obtenerTipoSubtipo(dto).getTipos());

        // Agregado por SiCC20070433 - Rafael Romero - 24/09/2007
        // Si el sub tipo de cliente es Hija Dupla
        // Se realizan las validaciones de limites de edad y del tipo subtipo de recomendante
        DAOMAEConfiguracionClientes dao = new DAOMAEConfiguracionClientes(sessionContext.getCallerPrincipal().getName());
        Long cte_oid_subtipo_hija_dupla = dao.getOidSubtipoCliente(ConstantesMAE.COD_TIPO_CLIEN_HIJADUPLA, ConstantesMAE.COD_SUBTIPO_CLIEN_HIJADUPLA);
        dtoPest3.setCteOidSubTipoHijaDupla(cte_oid_subtipo_hija_dupla);
        if(dto.getSubtipoCliente().equals(cte_oid_subtipo_hija_dupla)){
            UtilidadesLog.debug("MONClientesBean.pestanya3(DTOValidarClientes): Se van a realizar las validaciones para HijaDupla"); 
            // Limites de edad
            DTOCodigoCliente dtoE = new DTOCodigoCliente();
            dtoE.setOidIdioma(dto.getOidIdioma());
            dtoE.setOidPais(dto.getOidPais());
            dtoE.setEdad(dto.getEdad());
            // Se toma el primer vinculo...
            // para subtipo HijaDupla, solo hay un vinculo
            dtoE.setCodigoCliente(dto.getClientesVinculo()[0]);
            
            UtilidadesLog.debug("dtoE\n"+dtoE); 
            
            boolean edadValida = false;
            try{
                edadValida = dao.validarEdadHijaDupla(dtoE).getValor();
            }catch(Exception e){
                UtilidadesLog.error("Error en Validacion de edad Hija Dupla",e);
            }
            if(!edadValida){
                dtoPest3.setNivelValidacionEdadHijaDupla(new Integer(1));
            }else{
                dtoPest3.setNivelValidacionEdadHijaDupla(new Integer(0));
            }

            RecordSet tiposCliente = dao.recuperarTipoSubtipoCliente(dtoE).getResultado();
            // Se hacen 3 validaciones de tipo...
            // Primero que exista el vinculo... (ya se valida en metodo comprobarCodigosCliente), se revalida en entidad de tipos_subtipos
            // Segundo que NO sea tipo HijaDupla...
            // Tercero que SI sea Consultora
            if(tiposCliente!=null && tiposCliente.getRowCount()>0){
                boolean esConsultora = false;
                boolean esHijaDupla = false;
                for(int i=0; i<tiposCliente.getRowCount() && !esHijaDupla ; i++){
                    Long tipo = new Long( ((BigDecimal)tiposCliente.getValueAt(0,2)).longValue() );
                    Long TIPO_HIJADUPLA = new Long( ((BigDecimal)tiposCliente.getValueAt(0,4)).longValue() );
                    Long TIPO_CONSULTORA = new Long( ((BigDecimal)tiposCliente.getValueAt(0,5)).longValue() );
                    if(TIPO_HIJADUPLA.equals(tipo)){
                        // Es de tipo HijaDupla...
                        esHijaDupla = true;
                    }
                    if(TIPO_CONSULTORA.equals(tipo)){
                        esConsultora = true;
                    }
                }
                if(esHijaDupla){
                    // Es de tipo HijaDupla...
                    dtoPest3.setNivelValidacionTipoHijaDupla(new Integer(2));
                }else{
                    if(!esConsultora){
                        // No es consultora...
                        dtoPest3.setNivelValidacionTipoHijaDupla(new Integer(3));
                    }else{
                        // Todas las validaciones de tipo superadas...
                        dtoPest3.setNivelValidacionTipoHijaDupla(new Integer(0));
                    }
                }
            }else{
                // No existe cliente en entidad cliente_tipo_subtipo
                dtoPest3.setNivelValidacionTipoHijaDupla(new Integer(1));
            }

        }
        // Fin agregado SiCC20070433

        /*     Devolvemos el dto que hemos creado. */
        UtilidadesLog.info("MONClientesBean.pestanya3(DTOValidarClientes): Salida"); 
        return dtoPest3;
    }

    public DTOSalida busquedaRapida(DTOBusquedaRapidaCliente dto) throws MareException {
        UtilidadesLog.info("MONClientesBean.busquedaRapida(DTOBusquedaRapidaCliente): Entrada"); 
        String codigoError;

        //try{
        //if(dto.getCodigoCliente()!=null){
        //Debemos rellenar con ceros si no tiene la longitud mínima 

        /*Llamamos al método obtenerLongitudNumeroCliente de la interfaz
        IServicioSEG pasandole el pais del dto y obtenemos un entero que
        indica el tamaño que debe tener el código.*/

        //  StringBuffer codigClie = new StringBuffer();
        // codigClie.append( dto.getCodigoCliente() );
        // MONMantenimientoSEGHome mmsHome = SEGEjbLocators.getMONMantenimientoSEGHome();
        // Integer largo = mmsHome.create().obtenerLongitudNumeroCliente(dto.getOidPais());
        //UtilidadesLog.info("largo: " + largo);
        //UtilidadesLog.info("codigClie: " + codigClie.length() );
        // if( codigClie.length() < largo.intValue() ){
        //     for (int i = largo.intValue()-codigClie.length(); i>0; i-- ){
        //       codigClie.insert(0,"0");
        //UtilidadesLog.info( "codigClie  " + codigClie.toString());
        //   }
        //   dto.setCodigoCliente(codigClie.toString());
        //  }                
        //}
        //UtilidadesLog.info("dto: " + dto);
        DAOMAEMaestroClientes daoMae = new DAOMAEMaestroClientes(sessionContext.getCallerPrincipal().getName());
        DTOSalida sl = new DTOSalida();
        sl = daoMae.busquedaRapida(dto);
        UtilidadesLog.info("MONClientesBean.busquedaRapida(DTOBusquedaRapidaCliente): Salida"); 

        return sl;

        /*
        } catch (CreateException e) {
        codigoError = CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB;
        throw new MareException(e,UtilidadesError.armarCodigoError(codigoError));
        } catch (RemoteException e) {
        codigoError = CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB;
        throw new MareException(e,UtilidadesError.armarCodigoError(codigoError));
        }
        */
    }

  /**
   * 11-06-2007     Modificado por Sapaza, incidencia Sicc 20070276, se cambia la logica de actualizar
   *                las unidades administrativas del cliente, y si es necesario realizar el rollback
   *                de la actualizacion del status.
   * @throws es.indra.mare.common.exception.MareException
   * @param indDirePrincipal
   * @param dto
   * @param cliente
   * @param territorio
   * @param canal
   * @param pais
   * @param marca
   */
    public void actualizarUnidadesAdmMAE(Long marca, Long pais, Long canal, Long territorio, Long cliente, DTOAuditableSICC dto, Long indDirePrincipal) throws MareException {
        UtilidadesLog.info("MONClientesBean.actualizarUnidadesAdmMAE(marca, pais, canal, territorio, cliente,DTOAuditableSICC ): Entrada"); 
        try {
            MONUnidadesAdministrativasHome muaVHome = ZONEjbLocators.getMONUnidadesAdministrativasHome();
            MONUnidadesAdministrativas mua = muaVHome.create();

            //clienteDatosBasicosLH.p
            // Obtener zona
            UtilidadesLog.debug("******************************************************");
            UtilidadesLog.debug("******************************************************");

            DTOUnidadAdministrativa dtoUA = mua.generaUATerritorio(pais, marca, canal, territorio, null);

            if (dtoUA == null) {
                String mensajeLog = " [MAE] [actualizarUnidadesAdmMAE] Para Pais/Marca/Canal/Territorio: " + pais + "/" + marca + "/" + canal + "/" + territorio + " ,no se hallo UA";
                BelcorpService.getInstance().log.info(mensajeLog);
                UtilidadesLog.info("[MAE] [actualizarUnidadesAdmMAE] Para Pais/Marca/Canal/Territorio: " + pais + "/" + marca + "/" + canal + "/" + territorio + " ,no se hallo UA");
                throw new MareException(null, null, UtilidadesError.armarCodigoError(ConstantesSEG.MODULO_MAE, "", ErroresDeNegocio.NO_SE_HALLO_UA_PARA));
            }

            /*MONPeriodos craPerio = CRAEjbLocators.getMONPeriodosHome().create();
            DTOPeriodo dtoPerio = craPerio.obtienePeriodoActual(pais, marca, canal);
            UtilidadesLog.debug("dtoPerio: " + dtoPerio);

            ClienteUnidadAdministrativaLocalHome unidadAdministrativaHome = MAEEjbLocators.getClienteUnidadAdministrativaLocalHome();
            UtilidadesLog.debug("SCS, el DTOAuditableSICC, es: " + dto);
            unidadAdministrativaHome.parametrosAuditoria(dto);
            UtilidadesLog.debug("SCS voy a buscar, sobre Unidad Administrativa, con oidCliente_" + cliente + " para el nuevo oidTerriAdmin_" + dtoUA.getOidTerritorioAdministrativo());

            //Collection unidadAdministrativaCollection = unidadAdministrativaHome.findUAActiva(cliente,territorio);// cliente, territorio
            //Collection unidadAdministrativaCollection = unidadAdministrativaHome.findUAActiva(cliente, dtoUA.getOidTerritorioAdministrativo()); // cliente, territorio      
            Collection unidadAdministrativaCollection = unidadAdministrativaHome.findUAActivaByCliente(cliente);  // Inc.BELC300022782 

            UtilidadesLog.debug("---- VERIFICAMOS si habia alguna UA ACTIVA para el cliente");
            UtilidadesLog.debug("---- se encontraron_" + unidadAdministrativaCollection.size() + " UA activas");
            boolean crearUnidadAdministrativaNueva = true;
            // Si había alguna Unidad Administrativa 'activa', la desactivamos 
            Iterator itadm = unidadAdministrativaCollection.iterator();
            while (itadm.hasNext()){
                ClienteUnidadAdministrativaLocal uniAdm = (ClienteUnidadAdministrativaLocal) itadm.next();
                if (uniAdm.getInd_acti()!=null && uniAdm.getInd_acti().equals(new Long(0))){
                    continue;
                }
                if (uniAdm.getPerd_oid_peri_ini().equals(dtoPerio.getOid())){
                    uniAdm.setZtad_oid_terr_admi(dtoUA.getOidTerritorioAdministrativo());
                    uniAdm.setInd_acti(new Long(1));
                    crearUnidadAdministrativaNueva = false;
                }else{
                    uniAdm.setInd_acti(new Long(0));
                    uniAdm.setPerd_oid_peri_fin(dtoPerio.getOid());
                }
            }
            //Long clie_oid_clie, Long perd_oid_peri_ini, Long perd_oid_peri_fin, Long ztad_oid_terr_admi, Long ind_acti
            // Hay una incidencia (1752) para saber que tengo que pasar como periodo fin, por ahora se le pasa el mismo periodo
            UtilidadesLog.debug("---- Realizamos el create de UA nueva ....");
            UtilidadesLog.debug("---- cliente: " + cliente);
            UtilidadesLog.debug("---- dtoUA: " + dtoUA);
            if (crearUnidadAdministrativaNueva){
                //unidadAdministrativaHome.create(cliente, dtoPerio.getOid(), null, dtoUA.getOidTerritorioAdministrativo(), new Long(1)); //ind. activo
                insertarUnidadAdministrativa(cliente, dtoPerio.getOid(), null, dtoUA.getOidTerritorioAdministrativo(), new Long(1)); //ind. activo
            }*/               
            
            //Modificado por Sapaza - fecha 07/08/2007 - incidencia Sicc20070380
            ClienteUnidadAdministrativaLocalHome unidadAdministrativaHome = new ClienteUnidadAdministrativaLocalHome();            
            Collection unidadAdministrativaCollection = unidadAdministrativaHome.findByCliente(cliente);  
            Iterator itadm = unidadAdministrativaCollection.iterator();
            
            if (itadm.hasNext()){
                UtilidadesLog.debug("--- Cliente Tiene unidades administrativas");
                
                Collection unidadAdministrativaCollection2 = unidadAdministrativaHome.findUAActivaByCliente(cliente); 
                Iterator itadm2 = unidadAdministrativaCollection2.iterator();
               
                if (itadm2.hasNext()){
                    UtilidadesLog.debug("--- Cliente Tiene unidades administrativas activas");
                    
                    ClienteUnidadAdministrativaLocal uniAdm = (ClienteUnidadAdministrativaLocal) itadm2.next();
                    RecordSet registro = (new DAOZON()).obtenerTerritorioAdministrativo(uniAdm.getZtad_oid_terr_admi());
                    
                    Long regionOrigen = new Long(((BigDecimal) registro.getValueAt(0, "REGION")).longValue());
                    Long oidTerritorioAnt = new Long(((BigDecimal) registro.getValueAt(0, "TERR_ADM")).longValue());
                    
                    UtilidadesLog.debug("MAE - regionOrigen: " + regionOrigen);                
                    UtilidadesLog.debug("MAE - Territorio Administrativo activo: " + oidTerritorioAnt);                
                    
                    this.actualizarUnidadAdmCliente(cliente, pais, marca, canal, regionOrigen, 
                         dtoUA.getOidRegion(), oidTerritorioAnt, dtoUA.getOidTerritorioAdministrativo());
                }
            }
            else {
                UtilidadesLog.debug("--- Cliente NO Tiene unidades administrativas");
                MONPeriodos craPerio = CRAEjbLocators.getMONPeriodosHome().create();
                DTOPeriodo dtoPerio = craPerio.obtienePeriodoActual(pais, marca, canal);
                UtilidadesLog.debug("dtoPerio: " + dtoPerio);                
                
                insertarUnidadAdministrativa(cliente, dtoPerio.getOid(), null, dtoUA.getOidTerritorioAdministrativo(), new Long(1));
            }
            
            //<inicio>Se actualiza los pedidos no facturados con nueva Unidad Administrativa, incidencia SiCC-20070174
            if((indDirePrincipal) != null && (indDirePrincipal.intValue() == 1)) {
                UtilidadesLog.debug("---- Actualizar Pedidos no Facturados");
                actualizarPedidosConNuevaUniAdm(cliente, marca, territorio, dtoUA.getOidTerritorioAdministrativo(),
                                                dtoUA.getOidZona());
            }
            //<fin>incidencia SiCC-20070174

            UtilidadesLog.info("MONClientesBean.actualizarUnidadesAdmMAE(marca, pais, canal, territorio, cliente,DTOAuditableSICC ): Salida"); 
            
        } catch (CreateException ce) {
            sessionContext.setRollbackOnly();
            throw new MareException(ce, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS));
        } catch (MareException me) {
            UtilidadesLog.info("mare exception code: " + me.getCode() + " - desc: " + me.toString());
            sessionContext.setRollbackOnly();
            throw me;
        } catch (Exception e) {
            UtilidadesLog.info("error en actualizarUnidadesAdmMAE: " + e.toString());
            sessionContext.setRollbackOnly();
            throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS));
        }
    }
    
    private void insertarUnidadAdministrativa (Long cliente, Long periIni, Long periFin, Long territ, Long indActi) throws MareException{
        StringBuffer sb = new StringBuffer();
        
        sb.append(" INSERT INTO MAE_CLIEN_UNIDA_ADMIN ( OID_CLIE_UNID_ADMI, CLIE_OID_CLIE, PERD_OID_PERI_INI, ");
        sb.append(" PERD_OID_PERI_FIN, ZTAD_OID_TERR_ADMI, IND_ACTI ) VALUES ( ");
        sb.append(" MAE_CUAD_SEQ.nextVal ");
        sb.append(" , "+cliente);
        sb.append(" , "+periIni);
        sb.append(" , "+periFin);
        sb.append(" , "+territ);
        sb.append(" , "+indActi);
        sb.append(" )");
        try{
            BelcorpService.getInstance().dbService.executeUpdate(sb.toString());
        }catch(Exception e){
            UtilidadesLog.error("ERROR: "+sb.toString(),e);
            throw new MareException(e);
        }
    }
    /**
     * 
     * Modificado: SICC-GCC-MAE-005 - Cleal
     * Se eliminan los campos interior, manzana, lote y kilometro en el paso 5 
     */
    private String modificarClienteBase(DTOCrearClienteBasico dto, Long oid) throws MareException {
        UtilidadesLog.info("MONClientesBean.modificarClienteBase(DTOCrearClienteBasico,oid): Entrada"); 
        ClienteDatosBasicosLocalHome clienteDBasicosLH;
        ClienteDatosBasicosLocal clienteDBasicosL;
        ClienteDatosAdicionalesLocalHome clienteDAdicionalesLH;
        ClienteDatosAdicionalesLocal clienteDAdicionalesL;
        ClienteTipoSubTipoLocalHome clienteTSubtipoLH;
        ClienteTipoSubTipoLocal clienteTSubtipoL;
        ClienteIdentificacionLocalHome identificacionLH;
        ClienteIdentificacionLocal identificacionL;
        ClienteDireccionLocalHome direccionLH;
        ClienteDireccionLocal direccionL = null;
        ClienteMarcaLocalHome clienteMarcaLH;
        ClienteMarcaLocal clienteMarcaL;
        ClienteClasificacionLocalHome clienteClasiLH;
        ClienteClasificacionLocal clienteClasiL;
        TipoClasificacionLocalHome tipoClasiLH;
        TipoClasificacionLocal tipoClasiL;
        ClienteUnidadAdministrativaLocal clienteUAL;
        

        this.validarAccesos(dto);

        try {
            //Paso 1
            Date now = new Date(System.currentTimeMillis());
            clienteDBasicosLH = new ClienteDatosBasicosLocalHome();

            clienteDBasicosL = clienteDBasicosLH.findByPrimaryKey(oid);

            clienteDBasicosL.setPais_oid_pais(dto.getOidPais());
            clienteDBasicosL.setCod_clie(dto.getCodigoCliente());
            clienteDBasicosL.setCod_digi_ctrl(dto.getDigitoControl());
            clienteDBasicosL.setVal_ape1(dto.getApellido1());
            clienteDBasicosL.setVal_ape2(dto.getApellido2());
            clienteDBasicosL.setVal_apel_casa(dto.getApellidoCasada());
            clienteDBasicosL.setVal_nom1(dto.getNombre1());
            clienteDBasicosL.setVal_nom2(dto.getNombre2());
            clienteDBasicosL.setVal_trat(dto.getTratamiento());
            clienteDBasicosL.setCod_sexo(dto.getSexo());

           /* if (dto.getFechaIngreso() != null) {
                clienteDBasicosL.setFec_ingr(new Timestamp(truncarFecha(dto.getFechaIngreso()).getTime()));
            }*/ // no se debe actualizar la fecha de ingreso , no es modificable desde pantalla

            clienteDBasicosL.setFopa_oid_form_pago(dto.getFormaPago()); //Inc. 1809

            //Paso 3
            
            RecordSet rSubtipos = dto.getRTipoSubtipoCliente();
            HashMap hmTipoSubtipo = new HashMap();
            Long oidTipoCliente = null;
            // vbongiv -- 17/01/2008 -- Cambio SiCC20070461 MAE
            ArrayList listaOidTipos = new ArrayList();
                
            if (rSubtipos != null && !rSubtipos.esVacio()) {
                clienteTSubtipoLH = new ClienteTipoSubTipoLocalHome();
                String sOid = null;
                String sOidTipo = null;
                String sOidSubtipo = null;
                Long nPpal = null;
                
                int cantRegistros =  rSubtipos.getRowCount();
                UtilidadesLog.debug("--- cantidad de registros TipoSubtipo_" + cantRegistros);
                for (int i=0; i<cantRegistros; i++) {
                  sOid = (String) rSubtipos.getValueAt(i,0);
                  sOidTipo = (String) rSubtipos.getValueAt(i,3);
                  sOidSubtipo = (String) rSubtipos.getValueAt(i,4);
                  nPpal = (Long)rSubtipos.getValueAt(i,5);
                  
                  // vbongiv -- 17/01/2008 -- Cambio SiCC20070461 MAE
                  listaOidTipos.add(sOidTipo);
                  
                  if (sOid != null && !sOid.equals("g")) {
                     clienteTSubtipoL = 
                            clienteTSubtipoLH.findByPrimaryKey(Long.valueOf(sOid));
                            
                     clienteTSubtipoL.setTicl_oid_tipo_clie(Long.valueOf(sOidTipo));                     
                     clienteTSubtipoL.setSbti_oid_subt_clie(Long.valueOf(sOidSubtipo));
                     clienteTSubtipoL.setInd_ppal(nPpal);
                     
                     try {
                         clienteTSubtipoLH.merge(clienteTSubtipoL);
                     } catch (PersistenceException e) {
                         UtilidadesLog.error(e);
                         sessionContext.setRollbackOnly();
                         throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS));
                     }
                     
                  } else {
                     clienteTSubtipoL = 
                            clienteTSubtipoLH.create(oid, 
                                                     Long.valueOf(sOidTipo),
                                                     Long.valueOf(sOidSubtipo),
                                                     nPpal,
                                                     now);
                  }
                  hmTipoSubtipo.put(Long.valueOf(sOidSubtipo), clienteTSubtipoL.getOid());
                  if (nPpal.equals(new Long("1"))) {
                        UtilidadesLog.debug("--- TipoSubtipo principal_" + clienteTSubtipoL.getOid());
                        oidTipoCliente = Long.valueOf(sOidTipo);   
                  }
                }
            }
            
            //Paso 4
            
            RecordSet rIdentificaciones = dto.getRIdentificacionCliente();
            if (rIdentificaciones != null && !rIdentificaciones.esVacio()) {
               identificacionLH = new ClienteIdentificacionLocalHome();
               String sOid = null;
               String sOidTipoDocumento = null;
               String sNumDocumento = null;
               String sPersonaEmpresa = null;
               Long nPpal = null;
               
               int cantRegistros = rIdentificaciones.getRowCount();
               for (int i=0; i<cantRegistros; i++) {
                  sOid = (String) rIdentificaciones.getValueAt(i, 0);
                  sOidTipoDocumento = (String) rIdentificaciones.getValueAt(i, 1);
                  sNumDocumento = (String) rIdentificaciones.getValueAt(i, 2);
                  sPersonaEmpresa = (String) rIdentificaciones.getValueAt(i,5);
                  nPpal = (Long) rIdentificaciones.getValueAt(i,4);
                  
                  if (sOid != null && !sOid.equals("g")) {
                     identificacionL = 
                            identificacionLH.findByPrimaryKey(Long.valueOf(sOid));
                     identificacionL.setClie_oid_clie(oid);
                     identificacionL.setNum_docu_iden(sNumDocumento);
                     identificacionL.setTdoc_oid_tipo_docu(Long.valueOf(sOidTipoDocumento));
                     identificacionL.setVal_iden_pers_empr(sPersonaEmpresa);
                     identificacionL.setVal_iden_docu_prin(nPpal);
                  } else {
                     identificacionL = 
                            identificacionLH.create(Long.valueOf(sOidTipoDocumento),
                                                    oid,
                                                    sNumDocumento,
                                                    nPpal,
                                                    now);
                     identificacionL.setVal_iden_pers_empr(sPersonaEmpresa);                               
                  }
                  
                  try {
                      identificacionLH.merge(identificacionL);
                  } catch (PersistenceException e) {
                      sessionContext.setRollbackOnly();
                      UtilidadesLog.error(e);
                      throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS));
                  }
               }
               
            }
            
            //Paso 5

            DTODireccion[] direcciones = dto.getDirecciones();
            DTODireccion direccionPrincipal = null;
            int cantidadDireccionesPrincipales = 0;
            Long oidTerritorioPrincipal = null;
            Long oidTerritorioActual;

            if (direcciones != null) {
                direccionLH = new ClienteDireccionLocalHome();

                for (int i = 0;
                        (i < direcciones.length) && (cantidadDireccionesPrincipales < 2);
                        i++) {
                    if (direcciones[i].getEsDireccionPrincipal() == null) {
                        direcciones[i].setEsDireccionPrincipal(Boolean.FALSE);
                    }

                    oidTerritorioActual = this.obtenerTerritorio(direcciones[i], dto.getUsaGeoreferenciador());

                    if (direcciones[i].getEsDireccionPrincipal().booleanValue()) {
                        direccionPrincipal = direcciones[i];
                        oidTerritorioPrincipal = oidTerritorioActual;
                        cantidadDireccionesPrincipales++;
                    }

                    if (direcciones[i].getOid() != null) {
                        direccionL = direccionLH.findByPrimaryKey(direcciones[i].getOid());
                        if (oidTerritorioActual != null){
                            direccionL.setTerr_oid_terr(oidTerritorioActual);
                        }
                        direccionL.setTidc_oid_tipo_dire(direcciones[i].getTipoDireccion());
                        direccionL.setClie_oid_clie(oid);
                        direccionL.setTivi_oid_tipo_via(direcciones[i].getTipoVia());

                    } else {
                        //Cleal - 22631
                        ValoresEstructuraGeopoliticaLocalHome valoresEstructuraGeopoliticaLocalHome = new ValoresEstructuraGeopoliticaLocalHome();
                        ValoresEstructuraGeopoliticaLocal valoresEstructuraGeopoliticaLocal = valoresEstructuraGeopoliticaLocalHome.findByPrimaryKey(direcciones[i].getUnidadGeografica());
                        
                        String str1 = (valoresEstructuraGeopoliticaLocal.getOrde_1()==null)?"":valoresEstructuraGeopoliticaLocal.getOrde_1();
                        String str2 = (valoresEstructuraGeopoliticaLocal.getOrde_2()==null)?"":valoresEstructuraGeopoliticaLocal.getOrde_2();
                        String str3 = (valoresEstructuraGeopoliticaLocal.getOrde_3()==null)?"":valoresEstructuraGeopoliticaLocal.getOrde_3();
                        String str4 = (valoresEstructuraGeopoliticaLocal.getOrde_4()==null)?"":valoresEstructuraGeopoliticaLocal.getOrde_4();
                        String str5 = (valoresEstructuraGeopoliticaLocal.getOrde_5()==null)?"":valoresEstructuraGeopoliticaLocal.getOrde_5();
                        String str6 = (valoresEstructuraGeopoliticaLocal.getOrde_6()==null)?"":valoresEstructuraGeopoliticaLocal.getOrde_6();
                        String str7 = (valoresEstructuraGeopoliticaLocal.getOrde_7()==null)?"":valoresEstructuraGeopoliticaLocal.getOrde_7();
                        String str8 = (valoresEstructuraGeopoliticaLocal.getOrde_8()==null)?"":valoresEstructuraGeopoliticaLocal.getOrde_8();
                        String str9 = (valoresEstructuraGeopoliticaLocal.getOrde_9()==null)?"":valoresEstructuraGeopoliticaLocal.getOrde_9();
                        String ubigeo = str1+str2+str3+str4+str5+str6+str7+str8+str9;
                            
                        direccionL = direccionLH.create(oid, direcciones[i].getTipoDireccion(), direcciones[i].getTipoVia(), now, ubigeo);
                        direccionL.setTerr_oid_terr(oidTerritorioActual);
                        if ((direccionL.getInd_ctrl_inte_geor() != null) && (direccionL.getInd_ctrl_inte_geor().charValue() == 'N')) {
                            direccionL.setInd_ctrl_inte_geor(null);
                        }                       

                        //<inicio>incidencia SiCC-20070174
                        //actualizamos la Nueva Direccion y Ubicacion Geografica para los pedidos no facturados, 
                        //en caso haya cambio de direccion principal del Cliente
                        if (direcciones[i].getEsDireccionPrincipal().booleanValue())
                            actualizarPedidosConNuevaDireccion(oid, direccionL.getOid(), valoresEstructuraGeopoliticaLocal.getOid());
                        //<fin>incidencia SiCC-20070174
                        
                    }

                    direccionL.setVal_nomb_via(direcciones[i].getNombreVia().replaceAll(">","").replaceAll("<",""));

                    if (direcciones[i].getNumeroPrincipal() != null) {
                        direccionL.setNum_ppal(direcciones[i].getNumeroPrincipal().toString());
                    }

                    direccionL.setVal_cod_post(direcciones[i].getCodigoPostal());
                    
                    //Pedido de cambio: (COMPLETAR) Falta informar Claudio.
                    if (direcciones[i].getObservaciones()!=null){
                        // Modificaciones por SiCC 20070330 - Rafael Romero - 28/06/2007
                        // Evitar guardar los caracteres '>' o '<'
                        // Se eliminan de la cadena antes de almacenar en Base de datos
                        // direccionL.setVal_obse(direcciones[i].getObservaciones().replace('\n',' '));
                        direccionL.setVal_obse(direcciones[i].getObservaciones().replace('\n',' ').replaceAll(">","").replaceAll("<",""));
                        // Fin modificaciones SiCC 20070330
                    }
                    direccionL.setInd_dire_ppal((direcciones[i].getEsDireccionPrincipal().booleanValue() == true) ? new Long(1) : new Long(0));
                    UtilidadesLog.debug("*** direcciones[i].getVia(): "+direcciones[i].getVia());
                    direccionL.setZvia_oid_via(direcciones[i].getVia());
                    UtilidadesLog.debug("*** despues de setear zvia_oid_zvia");                    
                }
                
                try {
                    direccionLH.merge(direccionL);
                } catch (PersistenceException e) {
                    UtilidadesLog.error(e);
                    sessionContext.setRollbackOnly();
                    throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS));
                }

                if (cantidadDireccionesPrincipales != 1) {
                    UtilidadesLog.error("modificarClienteBase cantidadDireccionesPrincipales != 1");
                    throw new IllegalArgumentException("Se ha recibido en la inserción " + "de clientes un DTODirecciones con varias direcciones principales.");
                }
            }

            //Paso 6
            //	ya se encuentra almacenado en el paso 5.
            //Paso 7

            DTOClienteMarca[] marcas = dto.getMarcas();

            if (marcas != null) {
                clienteMarcaLH = new ClienteMarcaLocalHome();

                for (int i = 0; i < marcas.length; i++) {

                    if (marcas[i].getPrincipal() == null) {
                        marcas[i].setPrincipal(Boolean.FALSE);
                    }

                    if (marcas[i].getOid() != null) {
                        clienteMarcaL = clienteMarcaLH.findByPrimaryKey(marcas[i].getOid());
                        clienteMarcaL.setClie_oid_clie(oid);
                        clienteMarcaL.setInd_ppal((marcas[i].getPrincipal().booleanValue() == true) ? new Long(1) : new Long(0));
                        clienteMarcaL.setMarc_oid_marc(marcas[i].getMarca());
                        
                        try {
                            clienteMarcaLH.merge(clienteMarcaL);
                        } catch (PersistenceException e) {
                            sessionContext.setRollbackOnly();
                            UtilidadesLog.error(e);
                            throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS));
                        }
                    } else {
                        clienteMarcaL = clienteMarcaLH.create(oid, marcas[i].getMarca(), (marcas[i].getPrincipal().booleanValue() == true) ? new Long(1) : new Long(0), now);
                    }
                }
            }

            //Paso 8

            DTOClasificacionCliente[] clasificaciones = dto.getClasificaciones();
            int contadorClasificacionesPrincipales = 0;
            DTOClasificacionCliente dtoClasificacionCliente = new DTOClasificacionCliente();
            DTOPeriodo periodoActual = new DTOPeriodo();

            if (clasificaciones != null) {

                MONPeriodosHome mpHome = CRAEjbLocators.getMONPeriodosHome();
                MONPeriodos mp = mpHome.create();
                clienteClasiLH = new ClienteClasificacionLocalHome();
                tipoClasiLH = new TipoClasificacionLocalHome();

                for (int i = 0;
                        (i < clasificaciones.length) && (contadorClasificacionesPrincipales < 2);
                        i++) {

                    if (clasificaciones[i].getPrincipal() == null) {
                        clasificaciones[i].setPrincipal(Boolean.FALSE);
                    }

                    periodoActual = mp.obtienePeriodoActual(dto.getOidPais(), clasificaciones[i].getMarca(), clasificaciones[i].getCanal(), dto.getPeriodoContacto());

                    if (clasificaciones[i].getOid() != null) {
                        clienteClasiL = clienteClasiLH.findByPrimaryKey(clasificaciones[i].getOid());
                        clienteClasiL.setClas_oid_clas(clasificaciones[i].getClasificacion());
                        clienteClasiL.setTccl_oid_tipo_clasi(clasificaciones[i].getTipoClasificacion());
                        clienteClasiL.setInd_ppal((clasificaciones[i].getPrincipal().booleanValue() == true) ? new Long(1) : new Long(0));
                        
                        try {
                            clienteClasiLH.merge(clienteClasiL);
                        } catch (PersistenceException e) {
                            sessionContext.setRollbackOnly();
                            UtilidadesLog.error(e);
                            throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS));
                        }
                    } else if ((clasificaciones[i].getClasificacion() != null) && (clasificaciones[i].getTipoClasificacion() != null)) {

                        tipoClasiL = tipoClasiLH.findByPrimaryKey(clasificaciones[i].getTipoClasificacion());

                        Long oidSubTipoClienClasi = tipoClasiL.getSbti_oid_subt_clie();
                        Long oidEntityTipoSubtipo = (Long) hmTipoSubtipo.get(oidSubTipoClienClasi);
                        clienteClasiL = clienteClasiLH.create(oidEntityTipoSubtipo, clasificaciones[i].getClasificacion(), periodoActual.getOid(), clasificaciones[i].getTipoClasificacion(), (clasificaciones[i].getPrincipal().booleanValue() == true) ? new Long(1) : new Long(0), now);
                    }


                    if (clasificaciones[i].getPrincipal().booleanValue()) {
                        contadorClasificacionesPrincipales++;
                        dtoClasificacionCliente = clasificaciones[i];
                    }

                }

                if (contadorClasificacionesPrincipales != 1) {
                    UtilidadesLog.error("contadorClasificacionesPrincipales != 1");
                    throw new IllegalArgumentException("Se ha recibido en la inserción " + "de clientes varias clasificaciones principales.");
                }
            }

            //Paso 9
            /* Agregado para Inc. BELC300022782 - 04/05/2006 Emilio Iraola */
            UtilidadesLog.debug("MONClientes - modificarClienteBase() - ClienteUnidadAdministrativa.findOidTerriAdmin(oid)_" + oid );
            
            Collection clieUAs = new ClienteUnidadAdministrativaLocalHome().findOidTerriAdmin(oid);
            UtilidadesLog.debug("            - el oid_terri de la direccion es_" + oidTerritorioPrincipal);
            ArrayList oidsTerriAdmin = new ArrayList();  // Con los oid de Territorio Administrativo de MAE_CLIEN_UNIDA_ADMIN
            
            if (!clieUAs.isEmpty()) {
                Iterator itClieUAs = clieUAs.iterator();
                while (itClieUAs.hasNext()) {
                    clienteUAL = (ClienteUnidadAdministrativaLocal) itClieUAs.next();           
                    oidsTerriAdmin.add( clienteUAL.getZtad_oid_terr_admi() );
                    UtilidadesLog.debug("            - Un oid_terri_admin del cliente es_" + clienteUAL.getZtad_oid_terr_admi());
                }
            }
            
            /* FIN Agregado para Inc. BELC300022782 */
            
            MONUnidadesAdministrativasHome muaVHome = ZONEjbLocators.getMONUnidadesAdministrativasHome();
            MONUnidadesAdministrativas mua = muaVHome.create();

            DTOUnidadAdministrativa dtoUANueva; // Agregado Inc. BELC300022782
          if(oidTerritorioPrincipal!=null){   
                if (marcas != null) {
                    DAOZON daoZ = new DAOZON();
                    for (int i = 0; i < marcas.length; i++) {
                                            
                        if (marcas[i].getMarca() != null) {
                            UtilidadesLog.debug("            - verificando si actualizar la marca_" + marcas[i].getMarca());
                            dtoUANueva = daoZ.obtenerUnidadAdministrativa(marcas[i].getMarca(), dto.getOidPais(), dtoClasificacionCliente.getCanal(), oidTerritorioPrincipal, null);
                            UtilidadesLog.debug("            - el dtoUANueva recuperada con oidTerritorioPrincipal es_" + dtoUANueva);
                            if ( (dtoUANueva != null) && (!oidsTerriAdmin.contains(dtoUANueva.getOidTerritorioAdministrativo())) ) {
                                mua.actualizarUnidadesAdmMAE(marcas[i].getMarca(), dto.getOidPais(), dtoClasificacionCliente.getCanal(), oidTerritorioPrincipal, clienteDBasicosL.getOid(), dto, new Long(1));
                                UtilidadesLog.debug("            - se ACTUALIZO MAE_CLIEN_UNIDA_ADMIN " );
                            }
                        }
                    
                    }
                }
        }
            // vbongiv -- 17/01/2008 -- Cambio SiCC20070461 MAE
            //Paso 11
            clienteDAdicionalesLH = new ClienteDatosAdicionalesLocalHome();
                
            if ((clienteDBasicosL.getInd_fich_insc() != null) && (clienteDBasicosL.getInd_fich_insc().longValue() == 1)) {
                UtilidadesLog.debug("... cliente ingresado por Lote");
                


                clienteDAdicionalesL = clienteDAdicionalesLH.create(clienteDBasicosL.getOid(), null, now);
                clienteDAdicionalesL.setInd_acti(new Long(1));
            } else {
                clienteDAdicionalesL = clienteDAdicionalesLH.findByCliente(clienteDBasicosL.getOid());
            }

            MONEstatusClienteHome mecHome = MAEEjbLocators.getMONEstatusClienteHome();
            MONEstatusCliente mec = mecHome.create();

            String problemasEstatus = mec.asignarEstatusInicial(clienteDAdicionalesL, periodoActual.getOid(), listaOidTipos, dto);
            
            UtilidadesLog.debug("problemasEstatus: " + problemasEstatus);
            
            //Paso 11
            if ((clienteDBasicosL.getInd_fich_insc() != null) && (clienteDBasicosL.getInd_fich_insc().longValue() == 1)) {
                UtilidadesLog.debug("... cliente ingresado por Lote");
               
                if(oidTerritorioPrincipal!=null){ 
                    this.asignarNivelRiesgoCredito(dto.getOidPais(), dtoClasificacionCliente.getMarca(), dtoClasificacionCliente.getCanal(), oidTerritorioPrincipal, clienteDAdicionalesL);
                }                

            }
            clienteDBasicosL.setInd_fich_insc(new Long(0));
            UtilidadesLog.info("MONClientesBean.modificarClienteBase(DTOCrearClienteBasico,oid): Salida"); 
            
            try {
                clienteDBasicosLH.merge(clienteDBasicosL);
            } catch (PersistenceException e) {
                UtilidadesLog.error(e);
                sessionContext.setRollbackOnly();
                throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS));
            }
            
            return problemasEstatus;
            
        } catch (CreateException createException) {
            UtilidadesLog.error(createException);
            sessionContext.setRollbackOnly();
            throw new MareException(createException, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS));
        } catch (NoResultException e) {
            UtilidadesLog.error(e);
            sessionContext.setRollbackOnly();
            throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE));
        } catch (PersistenceException e) {
            UtilidadesLog.error(e);
            sessionContext.setRollbackOnly();
            throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS));
        } catch (MareException me) {
            UtilidadesLog.error(me);
            sessionContext.setRollbackOnly();
            throw me;
        } catch (Exception ex) {
            UtilidadesLog.error(ex);
            sessionContext.setRollbackOnly();
            throw new MareException(ex, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS));
        }
    }

    public DTOPremioRecomendacion modificar(DTOModificarCliente dto) throws MareException {
        UtilidadesLog.info("MONClientesBean.modificar(DTOModificarCliente): Entrada"); 
        ClienteDatosBasicosLocalHome clienteDBasicosLH;
        ClienteDatosBasicosLocal clienteDBasicosL;
        ClienteDatosAdicionalesLocalHome clienteDAdicionalesLH;
        ClienteDatosAdicionalesLocal clienteDAdicionalesL;
        ClienteVinculoLocalHome clienteVinculoLH;
        ClienteVinculoLocal clienteVinculoL;
        ClientePreferenciaLocalHome clientePreferenciaLH;
        ClientePreferenciaLocal clientePreferenciaL;
        ClienteObservacionLocalHome clienteObservacionLH;
        ClienteObservacionLocal clienteObservacionL;
        ClientePrimerContactoLocalHome clientePrimerContactoLH;
        ClientePrimerContactoLocal clientePrimerContactoL;
        ClienteComunicacionLocalHome clienteComunicacionLH;
        ClienteComunicacionLocal clienteComunicacionL;
        ClienteTarjetaLocalHome clienteTarjetaLH;
        ClienteTarjetaLocal clienteTarjetaL;
        ClienteProblemaLocalHome clienteProblemaLH;
        ClienteProblemaLocal clienteProblemaL;
        ClientePsicografiasLocalHome clientePsicografiasLH;
        ClientePsicografiasLocal clientePsicografiasL;
        ClienteTipoSubTipoLocalHome clienteTipoSubTipoLH;
        ClienteTipoSubTipoLocal clienteTipoSubTipoL;
        TipoVinculoLocalHome tipoVinculoLH;
        TipoVinculoLocal tipoVinculoL;
        ClienteClasificacionLocalHome clienteClasiLH;
        ClienteClasificacionLocal clienteClasiL;
        ClienteDireccionLocalHome direccionLH;
        ClienteDireccionLocal direccionL;
        ClienteIdentificacionLocalHome identificacionLH;
        ClienteIdentificacionLocal identificacionL;
        ClienteMarcaLocalHome clienteMarcaLH;
        ClienteMarcaLocal clienteMarcaL;
        DTOPremioRecomendacion resultado = new DTOPremioRecomendacion();


        DTOCliente datosCliente = dto.getDatosCliente();
        Long oidCliente;

        try {
            Date now = new Date(System.currentTimeMillis());

            //Paso 0 - ex-paso 4
            UtilidadesLog.info("modificar, 1");

            Long[] oids = dto.getClasificacionesQuitadas();

            if (oids != null) {
                clienteClasiLH = new ClienteClasificacionLocalHome();

                for (int i = 0; i < oids.length; i++) {
                    clienteClasiL = clienteClasiLH.findByPrimaryKey(oids[i]);
                    try {
                        clienteClasiLH.remove(clienteClasiL);
                    } catch (PersistenceException pe) {
                        sessionContext.setRollbackOnly();
                        String error = CodigosError.ERROR_DE_BORRADO_DE_DATOS;
                        throw new MareException(pe, UtilidadesError.armarCodigoError(error));
                    }
                }
            }

            UtilidadesLog.info("remuevo tipo subtipo cliente");
            oids = dto.getTiposQuitados();

            if (oids != null) {
                clienteTipoSubTipoLH = new ClienteTipoSubTipoLocalHome();

                for (int i = 0; i < oids.length; i++) {
                    clienteTipoSubTipoL = clienteTipoSubTipoLH.findByPrimaryKey(oids[i]);
                    try {
                        clienteTipoSubTipoLH.remove(clienteTipoSubTipoL);
                    } catch (PersistenceException pe) {
                        sessionContext.setRollbackOnly();
                        String error = CodigosError.ERROR_DE_BORRADO_DE_DATOS;
                        throw new MareException(pe, UtilidadesError.armarCodigoError(error));
                    }
                }
            }

            UtilidadesLog.info("modificar, 2");
            oids = dto.getComunicacionesQuitadas();

            if (oids != null) {
                clienteComunicacionLH = new ClienteComunicacionLocalHome();

                for (int i = 0; i < oids.length; i++) {
                    clienteComunicacionL = clienteComunicacionLH.findByPrimaryKey(oids[i]);
                    try {
                        clienteComunicacionLH.remove(clienteComunicacionL);
                    } catch (PersistenceException pe) {
                        sessionContext.setRollbackOnly();
                        String error = CodigosError.ERROR_DE_BORRADO_DE_DATOS;
                        throw new MareException(pe, UtilidadesError.armarCodigoError(error));
                    }
                }
            }

            UtilidadesLog.info("modificar, 3");
            oids = dto.getDireccionesQuitadas();

            if (oids != null) {
                direccionLH = new ClienteDireccionLocalHome();
                DAOMAEMaestroClientes daoMaestro = new DAOMAEMaestroClientes(sessionContext.getCallerPrincipal().getName());

                for (int i = 0; i < oids.length; i++) {
                    direccionL = direccionLH.findByPrimaryKey(oids[i]);
                    //Modificado por Sapaza, incidencia V_MAE_08 - se marca la direccion como eliminado
                    daoMaestro.eliminarDireccionCliente(oids[i]); //direccionL.remove();
                }
            }

            UtilidadesLog.info("modificar, 4");
            oids = dto.getIdentificacionesQuitadas();

            if (oids != null) {
                identificacionLH = new ClienteIdentificacionLocalHome();

                for (int i = 0; i < oids.length; i++) {
                    identificacionL = identificacionLH.findByPrimaryKey(oids[i]);
                    identificacionLH.remove(identificacionL);
                    try {
                        identificacionLH.remove(identificacionL);
                    } catch (PersistenceException pe) {
                        sessionContext.setRollbackOnly();
                        String error = CodigosError.ERROR_DE_BORRADO_DE_DATOS;
                        throw new MareException(pe, UtilidadesError.armarCodigoError(error));
                    }
                }
            }

            UtilidadesLog.info("modificar, 5");
            oids = dto.getMarcasQuitadas();

            if (oids != null) {
                clienteMarcaLH = new ClienteMarcaLocalHome();

                for (int i = 0; i < oids.length; i++) {
                    clienteMarcaL = clienteMarcaLH.findByPrimaryKey(oids[i]);
                    try {
                        clienteMarcaLH.remove(clienteMarcaL);
                    } catch (PersistenceException pe) {
                        sessionContext.setRollbackOnly();
                        String error = CodigosError.ERROR_DE_BORRADO_DE_DATOS;
                        throw new MareException(pe, UtilidadesError.armarCodigoError(error));
                    }
                }
            }

            UtilidadesLog.info("modificar, 6");
            oids = dto.getObservacionesQuitadas();

            if (oids != null) {
                clienteObservacionLH = new ClienteObservacionLocalHome();

                for (int i = 0; i < oids.length; i++) {
                    clienteObservacionL = clienteObservacionLH.findByPrimaryKey(oids[i]);
                    try {
                        clienteObservacionLH.remove(clienteObservacionL);
                    } catch (PersistenceException pe) {
                        sessionContext.setRollbackOnly();
                        String error = CodigosError.ERROR_DE_BORRADO_DE_DATOS;
                        throw new MareException(pe, UtilidadesError.armarCodigoError(error));
                    }
                }
            }

            UtilidadesLog.info("modificar, 7");
            oids = dto.getPreferenciasQuitadas();

            if (oids != null) {
                clientePreferenciaLH = new ClientePreferenciaLocalHome();

                for (int i = 0; i < oids.length; i++) {
                    clientePreferenciaL = clientePreferenciaLH.findByPrimaryKey(oids[i]);
                    try {
                        clientePreferenciaLH.remove(clientePreferenciaL);
                    } catch (PersistenceException pe) {
                        sessionContext.setRollbackOnly();
                        String error = CodigosError.ERROR_DE_BORRADO_DE_DATOS;
                        throw new MareException(pe, UtilidadesError.armarCodigoError(error));
                    }
                }
            }

            UtilidadesLog.info("modificar, 8");
            oids = dto.getProblemasQuitados();

            if (oids != null) {
                clienteProblemaLH = new ClienteProblemaLocalHome();

                for (int i = 0; i < oids.length; i++) {
                    clienteProblemaL = clienteProblemaLH.findByPrimaryKey(oids[i]);
                    try {
                        clienteProblemaLH.remove(clienteProblemaL);
                    } catch (PersistenceException pe) {
                        sessionContext.setRollbackOnly();
                        String error = CodigosError.ERROR_DE_BORRADO_DE_DATOS;
                        throw new MareException(pe, UtilidadesError.armarCodigoError(error));
                    }
                }
            }

            UtilidadesLog.info("modificar, 9");
            oids = dto.getPsicografiasQuitadas();

            if (oids != null) {
                clientePsicografiasLH = new ClientePsicografiasLocalHome();

                for (int i = 0; i < oids.length; i++) {
                    clientePsicografiasL = clientePsicografiasLH.findByPrimaryKey(oids[i]);
                    try {
                        clientePsicografiasLH.remove(clientePsicografiasL);
                    } catch (PersistenceException pe) {
                        sessionContext.setRollbackOnly();
                        String error = CodigosError.ERROR_DE_BORRADO_DE_DATOS;
                        throw new MareException(pe, UtilidadesError.armarCodigoError(error));
                    }
                }
            }

            UtilidadesLog.info("modificar, 10");

            UtilidadesLog.info("modificar, 11");
            oids = dto.getTarjetasQuitadas();

            if (oids != null) {
                clienteTarjetaLH = new ClienteTarjetaLocalHome();

                for (int i = 0; i < oids.length; i++) {
                    clienteTarjetaL = clienteTarjetaLH.findByPrimaryKey(oids[i]);
                    try {
                        clienteTarjetaLH.remove(clienteTarjetaL);
                    } catch (PersistenceException pe) {
                        sessionContext.setRollbackOnly();
                        String error = CodigosError.ERROR_DE_BORRADO_DE_DATOS;
                        throw new MareException(pe, UtilidadesError.armarCodigoError(error));
                    }
                }
            }

            UtilidadesLog.info("modificar, 12");
            oids = dto.getVinculosQuitados();

            if (oids != null) {
                clienteVinculoLH = new ClienteVinculoLocalHome();

                for (int i = 0; i < oids.length; i++) {
                    clienteVinculoL = clienteVinculoLH.findByPrimaryKey(oids[i]);
                    try {
                        clienteVinculoLH.remove(clienteVinculoL);
                    } catch (PersistenceException pe) {
                        sessionContext.setRollbackOnly();
                        String error = CodigosError.ERROR_DE_BORRADO_DE_DATOS;
                        throw new MareException(pe, UtilidadesError.armarCodigoError(error));
                    }
                }
            }

            //Paso 0,5 Inc. BELC300024052
            // vbongiv -- 17/01/2008 -- Cambio SiCC20070461 MAE
            String problemasEstatus = this.modificarClienteBase(dto.getDatosCliente().getBase(), dto.getDatosCliente().getOid());
            
            resultado.setProblemasEstatus(problemasEstatus);

            //Paso 1 - ex-paso 0
            UtilidadesLog.info("modificar, traza 1");
            clienteDAdicionalesLH = new ClienteDatosAdicionalesLocalHome();

            oidCliente = dto.getDatosCliente().getOid(); 
           
            clienteDAdicionalesL = clienteDAdicionalesLH.findByCliente(dto.getDatosCliente().getOid());
           

            if (datosCliente.getFechaNacimiento() != null) {
                clienteDAdicionalesL.setFec_naci(truncarFecha(datosCliente.getFechaNacimiento()));
            }

            clienteDAdicionalesL.setCod_empl(datosCliente.getCodigoEmpleado());
            //Cleal
            UtilidadesLog.debug("*** datosCliente.getNacionalidad(): "+datosCliente.getNacionalidad());
            clienteDAdicionalesL.setSnon_oid_naci(datosCliente.getNacionalidad());

            UtilidadesLog.debug("*** datosCliente.getEdad(): "+datosCliente.getEdad());
            if (datosCliente.getEdad() != null) {
                clienteDAdicionalesL.setVal_edad(new Long(datosCliente.getEdad().longValue()));
                UtilidadesLog.debug("*** Se actualizo la edad");
            }

            clienteDAdicionalesL.setEscv_oid_esta_civi(datosCliente.getEstadoCivil());
            clienteDAdicionalesL.setVal_ocup(datosCliente.getOcupacion());
            clienteDAdicionalesL.setVal_prof(datosCliente.getProfesion());
            clienteDAdicionalesL.setVal_cent_trab(datosCliente.getCentroTrabajo());
            clienteDAdicionalesL.setVal_carg_dese(datosCliente.getCargo());
            clienteDAdicionalesL.setNied_oid_nive_estu(datosCliente.getNivelEstudios());
            clienteDAdicionalesL.setVal_cent_estu(datosCliente.getCentroEstudios());

            if (datosCliente.getNumeroHijos() != null) {
                clienteDAdicionalesL.setNum_hijo(new Long(datosCliente.getNumeroHijos().longValue()));
            }

            if (datosCliente.getPersonasDependientes() != null) {
                clienteDAdicionalesL.setNum_pers_depe(new Long(datosCliente.getPersonasDependientes().longValue()));
            }

            clienteDAdicionalesL.setNsep_oid_nsep(datosCliente.getNSEP());
            clienteDAdicionalesL.setTclv_oid_cicl_vida(datosCliente.getCicloVida());

            if (datosCliente.getDeseaCorrespondencia() != null) {
                clienteDAdicionalesL.setInd_corr(datosCliente.getDeseaCorrespondencia().booleanValue() ? new Long(1) : new Long(0));
            } else {
                clienteDAdicionalesL.setInd_corr(new Long(0));
            }

            clienteDAdicionalesL.setImp_ingr_fami(datosCliente.getImporteIngresos());
            
            clienteDAdicionalesLH.merge(clienteDAdicionalesL);

            //Set de Forma Pago no va aca: inc. 1809
            UtilidadesLog.info("modificar, traza 2");
            
            RecordSet rVinculos = datosCliente.getRVinculo();
            if (rVinculos != null && !rVinculos.esVacio()) {
               clienteVinculoLH = new ClienteVinculoLocalHome();
            
               String sOid = null;
               String sCodigoCliente = null;
               String sTipoVinc = null;
               java.util.Date dFechaDesde = null;
               java.util.Date dFechaHasta = null;
               Long nPrincipal = null;
               String sOidCliente = null;
               boolean yaExistePpal = false;
               
               int cantRegistros = rVinculos.getRowCount();
               for (int i=0; i<cantRegistros; i++){
                  sOid = (String) rVinculos.getValueAt(i,0);
                  sTipoVinc = (String) rVinculos.getValueAt(i,2);
                  dFechaDesde = (java.util.Date) rVinculos.getValueAt(i,3);
                  dFechaHasta = (java.util.Date) rVinculos.getValueAt(i,4);
                  nPrincipal = (Long) rVinculos.getValueAt(i,5);
                  sOidCliente = (String) rVinculos.getValueAt(i,6);
                  
                  UtilidadesLog.info("sOid " + sOid);
                  UtilidadesLog.info("sCodigoCliente " + sCodigoCliente);
                  UtilidadesLog.info("sTipoVinc " + sTipoVinc);
                  UtilidadesLog.info("dFechaDesde " + dFechaDesde);
                  UtilidadesLog.info("dFechaHasta " + dFechaHasta);
                  UtilidadesLog.info("nPrincipal " + nPrincipal);
                  UtilidadesLog.info("sOidCliente " + sOidCliente);
                  UtilidadesLog.info("oidCliente " + oidCliente);
                  
                  //  Agregado por HRCS - Fecha 20/08/2007 - Cambio Sicc20070361
                  //  Nuevo logica para procesar cuando el vinculo es del tipo DUPLA CYZONE: se valida si ya existe un vinculo
                  //  para actualizarlo. De contrario se crea la nueva clasificacion para el cliente y se envia un mensaje de 
                  //  bienvenida a Dupla Cyzone.
                  DAOMAEConfiguracionClientes daoCliente = new DAOMAEConfiguracionClientes(sessionContext.getCallerPrincipal().getName());
                  if (sTipoVinc.equals(daoCliente.getOidTipoVinculo(dto.getDatosCliente().getBase().getOidPais(),
                                                                    ConstantesMAE.COD_TIPO_VINCULO_DUPLACYZONE).toString()))   {
                 
                        Long oidClienteMadre = Long.valueOf(sOidCliente); 
                        if (!this.existeClienteVinculo(dto.getDatosCliente().getBase().getOidPais(),
                                                       oidClienteMadre, // vinculante = madre
                                                       oidCliente,  // vinculando = hija
                                                       Long.valueOf(sTipoVinc),
                                                       Boolean.TRUE))   {
                                                       
                            Long periodoActual = null;
                            if (dto.getDatosCliente().getBase().getPeriodoContacto()!=null)   {
                                periodoActual = dto.getDatosCliente().getBase().getPeriodoContacto();
                                UtilidadesLog.debug("Utilizando el periodo de primer contacto: " + periodoActual);
                            }
                            else    {
                                RecordSet rs = this.obtenerPeriodoActualPorFecha( dto.getDatosCliente().getBase().getOidPais(),
                                                                                  dto.getDatosCliente().getBase().getClasificaciones()[0].getMarca(), 
                                                                                  dto.getDatosCliente().getBase().getClasificaciones()[0].getCanal() );
                                periodoActual = new Long( ((BigDecimal)rs.getValueAt(0,1)).longValue() );
                            }
                            //  Validar si ya existe
                            Long oidClienteVinculo = this.buscarClienteVinculoDuplaCyzone( oidClienteMadre, now);
                            if (oidClienteVinculo!=null)    {
                                //  Actualizar Vinculo
                                this.actualizarFechaHastaClienteVinculo( oidClienteVinculo );
                            }
                            else    {
                                //  Insertar Nueva Clasificacion Dupla Cyzone
                                this.crearClasificacionDuplaCyzone( oidClienteMadre, periodoActual, now);
                            }
                            //  Busca si la hija ya tenia un vinculante, para actualizarlo y borrarle su clasificacion DuplaCyzone
                            this.actualizarAnteriorVinculanteDuplaCyzone( oidCliente, now);
                            //  Comunicar Bienvenida Dupla
                            this.comunicarBienvenidaDuplaCyzone( oidClienteMadre, dto.getDatosCliente().getBase().getOidPais(), dto.getDatosCliente().getBase().getOidIdioma() );
                            
                            //  Busca si tiene ya un registro en cliente vinculo que este cerrado (fechaHasta no nula)
                            if (this.existeClienteVinculo(dto.getDatosCliente().getBase().getOidPais(),
                                                           oidClienteMadre, // vinculante = madre
                                                           oidCliente,  // vinculando = hija
                                                           Long.valueOf(sTipoVinc),
                                                           Boolean.FALSE))   {
                                clienteVinculoL = clienteVinculoLH.findByUK( oidClienteMadre, oidCliente, Long.valueOf(sTipoVinc) );
                            }
                            else    {
                                //  Crear el nuevo vinculo de Dupla Cyzone con fecha hasta = null
                                try {
                                    clienteVinculoL = clienteVinculoLH.create(oidClienteMadre,
                                                                              oidCliente,
                                                                              Long.valueOf(sTipoVinc),
                                                                              now);
                                } catch (PersistenceException pe) {
                                    sessionContext.setRollbackOnly();
                                    String error = CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS;
                                    throw new MareException(pe, UtilidadesError.armarCodigoError(error));
                                }
                            }
                                                           
                            if (dFechaDesde != null) {
                                long time = truncarFecha(dFechaDesde).getTime();
                                clienteVinculoL.setFec_desd(new Timestamp(time));
                            }
                            clienteVinculoL.setFec_hast(null);
                            clienteVinculoL.setInd_vinc_ppal(nPrincipal);
                            clienteVinculoLH.merge(clienteVinculoL);
                        }
                        else    {
                            UtilidadesLog.error("El cliente ya tiene un vinculo con los datos ingresados. Como no se ha modificado entonces no se actualiza.");
                        }
                  }
                  else  {   // Se procede de la forma anterior
                  
                      if (sOid != null && !sOid.equals("g")) {
                         UtilidadesLog.info("entro vinculo existente");
                         
                         clienteVinculoL = 
                         clienteVinculoLH.findByPrimaryKey(Long.valueOf(sOid));
                         /* modif. - splatas - 17/10/2006 
                         clienteVinculoL.setClie_oid_clie_vnte(Long.valueOf(sOidCliente));
                         clienteVinculoL.setClie_oid_clie_vndo(clienteDAdicionalesL.getClie_oid_clie());
                         */
                         //clienteVinculoL.setClie_oid_clie_vnte(clienteDAdicionalesL.getClie_oid_clie());
                         //clienteVinculoL.setClie_oid_clie_vndo(Long.valueOf(sOidCliente));
                         // fin modif.
                         /** eiraola 30/11/2006 Incidencia DBLG7....165**/ 
                         clienteVinculoL.setClie_oid_clie_vnte(Long.valueOf(sOidCliente)); // Preexistente
                         clienteVinculoL.setClie_oid_clie_vndo(oidCliente);                // Cliente que estamos procesando
    
    
    
                         
                         clienteVinculoL.setTivc_oid_tipo_vinc(Long.valueOf(sTipoVinc));
                         try {
                            clienteVinculoLH.merge(clienteVinculoL);
                         } catch (PersistenceException pe) {
                             sessionContext.setRollbackOnly();
                             String error = CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS;
                             throw new MareException(pe, UtilidadesError.armarCodigoError(error));
                         }
                      } else {
                         UtilidadesLog.info("entro vinculo nuevo");
                         
                         UtilidadesLog.debug("   - SAP601: clienteVinculoLH.create( " + oidCliente 
                            + ", " + sOidCliente + ", " + sTipoVinc + ", " + now + " )");
                        try {
                             clienteVinculoL = 
                                  clienteVinculoLH.create(Long.valueOf(sOidCliente),
                                                          oidCliente,
                                                          Long.valueOf(sTipoVinc),
                                                          now);
                        } catch (PersistenceException pe) {
                            sessionContext.setRollbackOnly();
                            String error = CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS;
                            throw new MareException(pe, UtilidadesError.armarCodigoError(error));
                        }
                                                      
                        /*fin deshacer modif ciglesias 24377*/
                        
                        
                        /* inicio Modificado incidencia DBLG700000052 */
                        if (nPrincipal.longValue() == 1) 
                         {
                            UtilidadesLog.info("entro a principal nuevo");
                         
                            tipoVinculoLH = new TipoVinculoLocalHome();
                
                            tipoVinculoL = tipoVinculoLH.findByPrimaryKey(Long.valueOf(sTipoVinc));
                
                            Long indicador = tipoVinculoL.getInd_reco();
                            
                            UtilidadesLog.info("indicador " + indicador);
                
                            if ((indicador != null) && (indicador.longValue() == 1)) {
                            
                            /*inicio modificado ciglesias incidencia 24377 17/11/2006*/
    
                                resultado.setClienteRecomendante(Long.valueOf(sOidCliente));
                                resultado.setClienteRecomendado(oidCliente);
                                
                            /*fin modificado ciglesias 24377*/
                              
                                UtilidadesLog.info("resultado.getClienteRecomendado " + resultado.getClienteRecomendado());
                                UtilidadesLog.info("resultado.getClienteRecomendante " + resultado.getClienteRecomendante());
                                
                            }                        
                         }
                        /* fin Modificado incidencia DBLG700000052 */
                      }
                      
                      clienteVinculoL.setInd_vinc_ppal(nPrincipal);
                      
                      if (dFechaDesde != null) {
                        long time = truncarFecha(dFechaDesde).getTime();
                        clienteVinculoL.setFec_desd(new Timestamp(time));
                      }
                      
                      if (dFechaHasta != null) {
                        long time = truncarFecha(dFechaHasta).getTime();
                        clienteVinculoL.setFec_hast(new Timestamp(time));
                      }
                      
                      try {
                          clienteVinculoLH.merge(clienteVinculoL);
                      } catch (PersistenceException pe) {
                          sessionContext.setRollbackOnly();
                          String error = CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS;
                          throw new MareException(pe, UtilidadesError.armarCodigoError(error));
                      }
                  }
                  
                  if (nPrincipal.longValue() == 1) {
                    if (!yaExistePpal) {
                       yaExistePpal = true;
                    } else {
                       UtilidadesLog.error("cantVinculosPrincipales > 1");
                       throw new IllegalArgumentException("Se ha recibido en la " + 
                            "inserción de clientes un DTOCliente con varios vinculos " +
                            "principales");
                    }
                  }
               }
            }

            UtilidadesLog.info("modificar, traza 3 ");
            
            RecordSet rPreferencias = datosCliente.getRPreferencia();
            if (rPreferencias != null && !rPreferencias.esVacio()) {
               clientePreferenciaLH = new ClientePreferenciaLocalHome();
            
               int cantRegistros = rPreferencias.getRowCount();
               String sOid = null;
               String sOidTipo = null;
               String sDesc = null;
               for (int i=0 ; i<cantRegistros; i++) {
                   sOid = (String)rPreferencias.getValueAt(i,0);
                   sOidTipo = (String)rPreferencias.getValueAt(i,1);
                   sDesc = (String)rPreferencias.getValueAt(i,2);

                   if (sOid != null && !sOid.equals("g") ){
                      clientePreferenciaL = 
                            clientePreferenciaLH.findByPrimaryKey(Long.valueOf(sOid));
                      clientePreferenciaL.setClie_oid_clie(oidCliente);       
                      clientePreferenciaL.setTipf_oid_tipo_pref(Long.valueOf(sOidTipo));
                      try {
                          clientePreferenciaLH.merge(clientePreferenciaL);
                      } catch (PersistenceException pe) {
                          sessionContext.setRollbackOnly();
                          String error = CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS;
                          throw new MareException(pe, UtilidadesError.armarCodigoError(error));
                      }
                   } else {
                       try {
                           clientePreferenciaL = 
                                 clientePreferenciaLH.create(oidCliente,
                                                             Long.valueOf(sOidTipo));
                       } catch (PersistenceException pe) {
                           sessionContext.setRollbackOnly();
                           String error = CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS;
                           throw new MareException(pe, UtilidadesError.armarCodigoError(error));
                       }
                   }
                   clientePreferenciaL.setDes_clie_pref(sDesc);
               }
            }

            UtilidadesLog.info("modificar, traza 4");
            
            RecordSet rObservaciones = datosCliente.getRObservaciones();
            if (rObservaciones != null && !rObservaciones.esVacio() ) {
               clienteObservacionLH = new ClienteObservacionLocalHome();
               String sOid = null;
               String sOidMarca = null;
               String sNumObserv = null;
               String sValTexto = null;
 
               int cantRegistros = rObservaciones.getRowCount();              
               for (int i=0; i<cantRegistros; i++) {
                   sOid = (String) rObservaciones.getValueAt(i, 0);
                   sOidMarca = (String) rObservaciones.getValueAt(i, 1);
                   sNumObserv = (String) rObservaciones.getValueAt(i, 2);
                   sValTexto = (String) rObservaciones.getValueAt(i, 3);

                   if (sOid != null && !sOid.equals("g")){
                      clienteObservacionL = 
                              clienteObservacionLH.findByPrimaryKey(Long.valueOf(sOid));
                      clienteObservacionL.setClie_oid_clie(oidCliente);        
                      clienteObservacionL.setMarc_oid_marc(Long.valueOf(sOidMarca));
                      clienteObservacionL.setNum_obse(Long.valueOf(sNumObserv));
                      clienteObservacionL.setVal_text(sValTexto);
                      try {
                          clienteObservacionLH.merge(clienteObservacionL);
                      } catch (PersistenceException pe) {
                          sessionContext.setRollbackOnly();
                          String error = CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS;
                          throw new MareException(pe, UtilidadesError.armarCodigoError(error));
                      }
                   } else {
                      try {
                          clienteObservacionL = 
                                  clienteObservacionLH.create(Long.valueOf(sOidMarca),
                                                              oidCliente,
                                                              Long.valueOf(sNumObserv),
                                                              sValTexto);
                      } catch (PersistenceException pe) {
                          sessionContext.setRollbackOnly();
                          String error = CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS;
                          throw new MareException(pe, UtilidadesError.armarCodigoError(error));
                      }
                   }
               }
            }

            UtilidadesLog.info("modificar, traza 5");

            if (datosCliente.getOidClienteContactado() != null) {
                clienteTipoSubTipoLH = new ClienteTipoSubTipoLocalHome();
                clienteTipoSubTipoL = clienteTipoSubTipoLH.findByClienteTipo(datosCliente.getOidClienteContactado(), datosCliente.getTipoClienteContactado());

                Long oidTipoSubtipo = clienteTipoSubTipoL.getOid();

                clientePrimerContactoLH = new ClientePrimerContactoLocalHome();
                clientePrimerContactoL = null;

                boolean hayPrimerContacto = true;

                try {
                    UtilidadesLog.info("Buscar Primer Contacto");
                    clientePrimerContactoL = clientePrimerContactoLH.findByCliente(oidCliente);
                } catch (NoResultException nre) {
                    UtilidadesLog.info("No hay primer contacto");
                    hayPrimerContacto = false;
                }

                if (!hayPrimerContacto) { // Si no hay primer contacto lo crea. 
                    UtilidadesLog.info("Crea primero Contacto");
                    try {
                        clientePrimerContactoL = clientePrimerContactoLH.create(oidCliente, oidTipoSubtipo, now);
                    } catch (PersistenceException pe) {
                        sessionContext.setRollbackOnly();
                        String error = CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS;
                        throw new MareException(pe, UtilidadesError.armarCodigoError(error));
                    }
                }

                // clientePrimerContactoL = clientePrimerContactoLH.create(oidCliente, oidTipoSubtipo);
                // Damos por sentado que hay por lo menos un registro para ese cliente en clientePrimerContacto
                UtilidadesLog.info("Procede a guardar");

                if (datosCliente.getTipoContacto() != null) {
                    clientePrimerContactoL.setCod_tipo_cont("" + datosCliente.getTipoContacto());
                }

                /* if (datosCliente.getFechaPrimerPedidoContactado() != null) {
                 clientePrimerContactoL.setFec_prim_pedi(new Timestamp(
                 truncarFecha(datosCliente.getFechaPrimerPedidoContactado()).getTime()));
                }*/
                if (datosCliente.getFechaSiguienteContacto() != null) {
                    clientePrimerContactoL.setFec_sigu_cont(new Timestamp(truncarFecha(datosCliente.getFechaSiguienteContacto()).getTime()));
                }

                /*if (datosCliente.getFechaPrimerPedidoContactado() != null) {
                  clientePrimerContactoL.setFec_prim_pedi(new Timestamp(
                  truncarFecha(datosCliente.getFechaPrimerPedidoContactado()).getTime()));
                }*/
                if (datosCliente.getFechaPrimerContacto() != null) {
                    clientePrimerContactoL.setFec_cont(new Timestamp(truncarFecha(datosCliente.getFechaPrimerContacto()).getTime()));
                }

                UtilidadesLog.info("---------- Marca ");

                Long marcaContacto = datosCliente.getMarcaContacto();

                if (marcaContacto != null) {
                    UtilidadesLog.info(" dto.getMarcaContacto(): " + marcaContacto.toString());
                    clientePrimerContactoL.setMarc_oid_marc(marcaContacto);
                }

                UtilidadesLog.info("--------- Canal ");

                Long canalContacto = datosCliente.getCanalContacto();

                if (canalContacto != null) {
                    UtilidadesLog.info(" dto.getCanalContacto(): " + canalContacto.toString());
                    clientePrimerContactoL.setCana_oid_cana(canalContacto);
                }

                UtilidadesLog.info("-------- Periodo ");

                Long periodoContacto = datosCliente.getPeriodoContacto();

                if (periodoContacto != null) {
                    UtilidadesLog.info(" dto.getPeriodoContacto(): " + periodoContacto.toString());
                    clientePrimerContactoL.setPerd_oid_peri(periodoContacto);
                }
                
                try {
                    clientePrimerContactoLH.merge(clientePrimerContactoL);
                } catch (PersistenceException pe) {
                    sessionContext.setRollbackOnly();
                    String error = CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS;
                    throw new MareException(pe, UtilidadesError.armarCodigoError(error));
                }
            } else // El usuario no eligio nada en Primer Contacto. Debe borrar lo que ya está
             {
                // Borra el contacto existente (si existe).
                Long oidClienteModificado = datosCliente.getOid();
                UtilidadesLog.info("Borra Primero Contacto Existente");
                UtilidadesLog.info("oidCLiente cuyo primer contacto vamos a eliminar: " + oidClienteModificado.toString());

                clientePrimerContactoLH = new ClientePrimerContactoLocalHome();

                try {
                    clientePrimerContactoL = clientePrimerContactoLH.findByCliente(oidClienteModificado);

                    // Al encontrar algo, quita la tupla. 
                    UtilidadesLog.info("Ejecuta el remove");
                    try {
                        clientePrimerContactoLH.remove(clientePrimerContactoL);
                    } catch (PersistenceException pe) {
                        sessionContext.setRollbackOnly();
                        String error = CodigosError.ERROR_DE_BORRADO_DE_DATOS;
                        throw new MareException(pe, UtilidadesError.armarCodigoError(error));
                    }
                } catch (NoResultException nre) {
                    // No existe tupla para este oidCliente en MAE_CLIEN_PRIME_CONTA
                    ;
                }
            }

            UtilidadesLog.info("modificar, traza 6");
            RecordSet rComunicaciones = datosCliente.getRComunicaciones();
            if (rComunicaciones != null && !rComunicaciones.esVacio()) {
               clienteComunicacionLH = new ClienteComunicacionLocalHome();
               
               String sOidComunicacion = null;
               String sOidTipoComunicacion = null;
               String sDiaComunicacion = null;
               String sTextoComunicacion = null;
               Long indPpal = null;
               String sHoraDesde = null;
               String sHoraHasta = null;
               String sIntervalo = null;
               
               int cantRegistros = rComunicaciones.getRowCount();
               for (int i=0; i<cantRegistros; i++) {
                  sOidComunicacion = (String) rComunicaciones.getValueAt(i,0);
                  sOidTipoComunicacion = (String) rComunicaciones.getValueAt(i,1);
                  sDiaComunicacion = (String) rComunicaciones.getValueAt(i,2);
                  sTextoComunicacion = (String) rComunicaciones.getValueAt(i,3);
                  indPpal = (Long) rComunicaciones.getValueAt(i,4);
                  sHoraDesde = (String) rComunicaciones.getValueAt(i,5);
                  sHoraHasta = (String) rComunicaciones.getValueAt(i,6);
                  sIntervalo = (String) rComunicaciones.getValueAt(i,7);

                  if (sOidComunicacion != null && !sOidComunicacion.equals("g")) {
                     clienteComunicacionL = 
                            clienteComunicacionLH.findByPrimaryKey(Long.valueOf(sOidComunicacion));
                     clienteComunicacionL.setClie_oid_clie(oidCliente);
                     clienteComunicacionL.setTicm_oid_tipo_comu(Long.valueOf(sOidTipoComunicacion));
                     try {
                         clienteComunicacionLH.merge(clienteComunicacionL);
                     } catch (PersistenceException pe) {
                         sessionContext.setRollbackOnly();
                         String error = CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS;
                         throw new MareException(pe, UtilidadesError.armarCodigoError(error));
                     }
                  } else {
                      try {
                          clienteComunicacionL = 
                                 clienteComunicacionLH.create(oidCliente, 
                                                              Long.valueOf(sOidTipoComunicacion), 
                                                              now);
                      } catch (PersistenceException pe) {
                          sessionContext.setRollbackOnly();
                          String error = CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS;
                          throw new MareException(pe, UtilidadesError.armarCodigoError(error));
                      }
                  }
                    
                  
                  if (indPpal == null ){ indPpal = new Long(0); };
                  clienteComunicacionL.setInd_comu_ppal(indPpal);
                  clienteComunicacionL.setVal_dia_comu(sDiaComunicacion);
                  
                  /* Validaciones de formato, en parte Cliente */ 
                  if (sHoraDesde != null && sHoraDesde.length() > 0) {
                     java.util.Date fechaBuffer = this.recuperaFecha(sHoraDesde, "HH:mm");
                     Timestamp t = new Timestamp(fechaBuffer.getTime());
                     clienteComunicacionL.setFec_hora_desd(t);
                  }
                  
                  if (sHoraHasta != null && sHoraHasta.length() > 0) {
                     java.util.Date fechaBuffer = this.recuperaFecha(sHoraHasta, "HH:mm");
                     Timestamp t = new Timestamp(fechaBuffer.getTime());
                     clienteComunicacionL.setFec_hora_hast(t);
                  }
                  
                  if (sIntervalo != null && sIntervalo.length()>0){
                     clienteComunicacionL.setVal_inte_comu(Long.valueOf(sIntervalo));
                  }
                  clienteComunicacionL.setVal_text_comu(sTextoComunicacion);
                  
                  try {
                      clienteComunicacionLH.merge(clienteComunicacionL);
                  } catch (PersistenceException pe) {
                      sessionContext.setRollbackOnly();
                      String error = CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS;
                      throw new MareException(pe, UtilidadesError.armarCodigoError(error));
                  }
               }
            }

            UtilidadesLog.info("modificar, traza 7");

            DTOTarjeta[] tarjetas = datosCliente.getTarjetas();

            if (tarjetas != null) {
                clienteTarjetaLH = new ClienteTarjetaLocalHome();

                for (int i = 0; i < tarjetas.length; i++) {
                    if (tarjetas[i].getOid() != null) {
                        clienteTarjetaL = clienteTarjetaLH.findByPrimaryKey(tarjetas[i].getOid());
                        clienteTarjetaL.setClie_oid_clie(oidCliente);
                        clienteTarjetaL.setTitr_oid_tipo_tarj(tarjetas[i].getTipo());
                    } else {
                        try {
                            clienteTarjetaL = clienteTarjetaLH.create(oidCliente, tarjetas[i].getTipo());
                        } catch (PersistenceException pe) {
                            sessionContext.setRollbackOnly();
                            String error = CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS;
                            throw new MareException(pe, UtilidadesError.armarCodigoError(error));
                        }
                    }

                    clienteTarjetaL.setCban_oid_banc(tarjetas[i].getBanco());
                    clienteTarjetaL.setClta_oid_clas_tarj(tarjetas[i].getClase());
                    try {
                        clienteTarjetaLH.merge(clienteTarjetaL);
                    } catch (PersistenceException pe) {
                        sessionContext.setRollbackOnly();
                        String error = CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS;
                        throw new MareException(pe, UtilidadesError.armarCodigoError(error));
                    }
                }
            }

            UtilidadesLog.info("modificar, traza 8");

            DTOProblemaSolucion[] problemas = datosCliente.getProblemasSoluciones();

            if (problemas != null) {
                clienteProblemaLH = new ClienteProblemaLocalHome();

                for (int i = 0; i < problemas.length; i++) {
                    if (problemas[i].getOid() != null) {
                        clienteProblemaL = clienteProblemaLH.findByPrimaryKey(problemas[i].getOid());
                        clienteProblemaL.setClie_oid_clie(oidCliente);
                        clienteProblemaL.setTipb_oid_tipo_prob(problemas[i].getTipoProblema());
                        clienteProblemaL.setInd_solu(problemas[i].getSolucion());
                    } else {
                        try {
                            clienteProblemaL = clienteProblemaLH.create(oidCliente, problemas[i].getTipoProblema(), problemas[i].getSolucion());
                        } catch (PersistenceException pe) {
                            sessionContext.setRollbackOnly();
                            String error = CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS;
                            throw new MareException(pe, UtilidadesError.armarCodigoError(error));
                        }
                    }

                    clienteProblemaL.setDes_prob(problemas[i].getDescripcionProblema());
                    clienteProblemaL.setVal_nego_prod(problemas[i].getNegocio());
                    clienteProblemaL.setDes_solu(problemas[i].getDescripcionSolucion());
                    clienteProblemaL.setTsoc_oid_tipo_solu(problemas[i].getTipoSolucion());
                    try {
                        clienteProblemaLH.merge(clienteProblemaL);
                    } catch (PersistenceException pe) {
                        sessionContext.setRollbackOnly();
                        String error = CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS;
                        throw new MareException(pe, UtilidadesError.armarCodigoError(error));
                    }
                } //for
            }

            UtilidadesLog.info("modificar, traza 9");

            DTOPsicografia[] psicografias = datosCliente.getPsicografias();

            if (psicografias != null) {
                clientePsicografiasLH = new ClientePsicografiasLocalHome();

                for (int i = 0; i < psicografias.length; i++) {
                    if (psicografias[i].getOid() != null) {
                        clientePsicografiasL = clientePsicografiasLH.findByPrimaryKey(psicografias[i].getOid());
                        clientePsicografiasL.setClie_oid_clie(oidCliente);
                        clientePsicografiasL.setMarc_oid_marc(psicografias[i].getMarca());
                        clientePsicografiasL.setTpoid_tipo_perf_psic(psicografias[i].getTipoPerfil());
                    } else {
                        try {
                            clientePsicografiasL = clientePsicografiasLH.create(oidCliente, psicografias[i].getMarca(), psicografias[i].getTipoPerfil());
                        } catch (PersistenceException pe) {
                            sessionContext.setRollbackOnly();
                            String error = CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS;
                            throw new MareException(pe, UtilidadesError.armarCodigoError(error));
                        }
                    }

                    clientePsicografiasL.setCod_test(psicografias[i].getCodigoTest());

                    if (psicografias[i].getFecha() != null) {
                        clientePsicografiasL.setFec_psic(new Timestamp(truncarFecha(psicografias[i].getFecha()).getTime()));
                    }
                    try {
                        clientePsicografiasLH.merge(clientePsicografiasL);
                    } catch (PersistenceException pe) {
                        sessionContext.setRollbackOnly();
                        String error = CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS;
                        throw new MareException(pe, UtilidadesError.armarCodigoError(error));
                    }
                }
            }

            //Paso 2
            UtilidadesLog.info("modificar, traza 10");

            //Paso 3
            UtilidadesLog.info("modificar, traza 11");
            clienteDBasicosLH = new ClienteDatosBasicosLocalHome();
            clienteDBasicosL = clienteDBasicosLH.findByPrimaryKey(oidCliente);

            clienteDAdicionalesLH = new ClienteDatosAdicionalesLocalHome();
            clienteDAdicionalesL = clienteDAdicionalesLH.findByCliente(oidCliente);

            UtilidadesLog.info("modificar, traza 12");
            this.insertarCriteriosBusqueda(clienteDBasicosL, clienteDAdicionalesL, dto.getOidIdioma());
            UtilidadesLog.info("modificar, traza 13, saliendo...");
            UtilidadesLog.info("MONClientesBean.modificar(DTOModificarCliente): Salida"); 
        } catch (NoResultException nre) {
            sessionContext.setRollbackOnly();
            throw new MareException(nre, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS));
        } catch (PersistenceException pe) {
            sessionContext.setRollbackOnly();
            throw new MareException(pe, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS));
        } catch (MareException me) {
            sessionContext.setRollbackOnly();
            throw me;
        } catch (Exception ex) {
            sessionContext.setRollbackOnly();
            throw new MareException(ex, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS));
        }
        
        UtilidadesLog.info("resultado.getClienteRecomendado " + resultado.getClienteRecomendado());
        UtilidadesLog.info("resultado.getClienteRecomendante " + resultado.getClienteRecomendante());
        UtilidadesLog.info("resultado.getProblemasEstatus " + resultado.getProblemasEstatus());
        
        return resultado;
    }

    private void asignarNivelRiesgoCredito(Long pais, Long marca, Long canal, Long territorio, ClienteDatosAdicionalesLocal clienteDatosAdicionales) throws MareException {
        UtilidadesLog.info("MONClientesBean.asignarNivelRiesgoCredito(pais, marca, canal, territorio, ClienteDatosAdicionales): Entrada"); 
        try {
            MONUnidadesAdministrativasHome muaVHome = ZONEjbLocators.getMONUnidadesAdministrativasHome();
            MONUnidadesAdministrativas mua = muaVHome.create();
            DTOUnidadAdministrativa dtoUA = mua.generaUATerritorio(pais, marca, canal, territorio, null);
            UtilidadesLog.info("DTOUnidadAdministrativa: " + dtoUA);

            DTOCreditoRiesgo dtoCreditoRiesgo = new DTOCreditoRiesgo();
            MONCreditoRiesgo creditoRiesgo = this.getMONCreditoRiesgo();

            if (dtoUA != null) {
                dtoCreditoRiesgo = creditoRiesgo.obtenerCreditoRiesgoConsultoraNueva(pais, dtoUA.getOidTerritorioAdministrativo());
            }

            UtilidadesLog.info("DTOCreditoRiesgo: " + dtoCreditoRiesgo);

            clienteDatosAdicionales.setNiri_oid_nive_ries(dtoCreditoRiesgo.getNivelRiesgo());
            clienteDatosAdicionales.setImp_mont_line_cred((dtoCreditoRiesgo.getMontoLineaCredito() == null) ? null : new Double(dtoCreditoRiesgo.getMontoLineaCredito().toString()));
            UtilidadesLog.info("MONClientesBean.asignarNivelRiesgoCredito(pais, marca, canal, territorio, ClienteDatosAdicionales): Salida"); 
        } catch (CreateException ce) {
            sessionContext.setRollbackOnly();
            throw new MareException(ce, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS));
        } catch (MareException me) {
            UtilidadesLog.error("Error en asignarNivelRiesgoCredito: mareexception: " + me.toString());
            sessionContext.setRollbackOnly();
            throw me;
        } catch (Exception e) {
            UtilidadesLog.error("Error en asignarNivelRiesgoCredito: " + e.toString());
            sessionContext.setRollbackOnly();
            throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS));
        }
    }

    private void validarAccesos(DTOCrearClienteBasico dto) throws MareException {
        UtilidadesLog.info("MONClientesBean.validarAccesos(DTOCrearClienteBasico): Entrada"); 
        DTOClienteMarca dtoActual;
        DTOClasificacionCliente dtoClasidicacionActual;
        Boolean valido;
        MONValidacion monValidacion;

        DTOClienteMarca[] dtoMarcas = dto.getMarcas();
        DTOClasificacionCliente[] dtoClasificaciones = dto.getClasificaciones();

        try {
            monValidacion = this.getMONValidacionHome().create();

            if (dtoMarcas != null) {
                for (int i = 0; i < dtoMarcas.length; i++) {
                    dtoActual = dtoMarcas[i];

                    //TODO: verificar que el oid de marca queda en getMarca!!!
                    valido = monValidacion.validarAccesos(dtoActual.getOidPais(), null, dtoActual.getMarca(), null, null, null, null, null, null, null, null);

                    if (valido.booleanValue() == false) {
                      throw new MareException(null, null, UtilidadesError.armarCodigoError(CodigosError.ERROR_ASOCIACION_ESTRUCTURAL));
                    }
                }
            }

            if (dtoClasificaciones != null) {
                for (int i = 0; i < dtoClasificaciones.length; i++) {
                    dtoClasidicacionActual = dtoClasificaciones[i];
                    valido = monValidacion.validarAccesos(dtoClasidicacionActual.getOidPais(), null, dtoClasidicacionActual.getMarca(), dtoClasidicacionActual.getCanal(), null, null, null, null, null, null, null);

                    if (valido.booleanValue() == false) {
                        throw new MareException(null, null, UtilidadesError.armarCodigoError(CodigosError.ERROR_ASOCIACION_ESTRUCTURAL));
                    }
                }
            }
            UtilidadesLog.info("MONClientesBean.validarAccesos(DTOCrearClienteBasico): Salida"); 
        } catch (CreateException ce) {
            sessionContext.setRollbackOnly();
            throw new MareException(ce, UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
        } catch (RemoteException re) {
            sessionContext.setRollbackOnly();
            throw new MareException(re, UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
        }
    }

    private MONValidacionHome getMONValidacionHome() throws MareException {
        UtilidadesLog.info("MONClientesBean.getMONValidacionHome(): Entrada"); 
        MONValidacionHome localHome = (MONValidacionHome) UtilidadesEJB.getHome("MONValidacion", MONValidacionHome.class);
        UtilidadesLog.info("MONClientesBean.getMONValidacionHome(): Salida"); 
        return localHome;
    }

    //Segun incidencia 8899 se agraga un campo mas ==>>> String observaciones
    public boolean ponerbloqueoFinanciero(Long cliente, String motivo, String observaciones) throws MareException {
        UtilidadesLog.info("MONClientesBean.ponerbloqueoFinanciero(cliente, motivo, observaciones): Entrada"); 
        TipoBloqueoLocalHome tipoBloquepLH;
        TipoBloqueoLocal tipoBloquepL;
        ClienteBloqueoLocalHome clienteBloquepLH = null;
        ClienteBloqueoLocal clienteBloquepL;

        try {
            tipoBloquepLH = new TipoBloqueoLocalHome();
            tipoBloquepL = tipoBloquepLH.findByCodigo(ConstantesMAE.BLOQUEO_FINANCIERO);
        } catch (NoResultException nre) {
            sessionContext.setRollbackOnly();
            throw new MareException(nre, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS));
        } catch (PersistenceException pe) {
            sessionContext.setRollbackOnly();
            throw new MareException(pe, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS));
        }

        try {
            clienteBloquepLH = new ClienteBloqueoLocalHome();
            clienteBloquepL = clienteBloquepLH.findByClienteTipoBloqueo(cliente, tipoBloquepL.getOid());
        } catch (NoResultException ex) {
            try {
                String usuario = sessionContext.getCallerPrincipal().getName();
                clienteBloquepLH.create(cliente, tipoBloquepL.getOid(), new Timestamp(System.currentTimeMillis()), motivo, usuario, observaciones);
            } catch (PersistenceException e) {
                sessionContext.setRollbackOnly();
                throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS));
            }
            UtilidadesLog.info("MONClientesBean.ponerbloqueoFinanciero(cliente, motivo, observaciones): Salida"); 

            return true;
        } catch (PersistenceException pe) {
            sessionContext.setRollbackOnly();
            throw new MareException(pe, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS));
        }
        
        UtilidadesLog.info("MONClientesBean.ponerbloqueoFinanciero(cliente, motivo, observaciones): Salida");  
        return false;
    }

    public boolean quitarBloqueoFinanciero(Long cliente) throws MareException {
        UtilidadesLog.info("MONClientesBean.quitarBloqueoFinanciero(cliente): Entrada"); 
        TipoBloqueoLocalHome tipoBloquepLH;
        TipoBloqueoLocal tipoBloquepL;
        ClienteBloqueoLocalHome clienteBloquepLH;
        ClienteBloqueoLocal clienteBloquepL;

        try {
            tipoBloquepLH = new TipoBloqueoLocalHome();
            tipoBloquepL = tipoBloquepLH.findByCodigo(ConstantesMAE.BLOQUEO_FINANCIERO);
        } catch (NoResultException ex) {
            sessionContext.setRollbackOnly();
            throw new MareException(ex, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE));
        } catch (PersistenceException ex) {
            sessionContext.setRollbackOnly();
            throw new MareException(ex, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS));
        }

        try {
            clienteBloquepLH = new ClienteBloqueoLocalHome();
            clienteBloquepL = clienteBloquepLH.findByClienteTipoBloqueo(cliente, tipoBloquepL.getOid());
            try {
                clienteBloquepLH.remove(clienteBloquepL);
            } catch (PersistenceException ex) {
                sessionContext.setRollbackOnly();
                throw new MareException(ex, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS));
            }
        } catch (NoResultException ex) {
            UtilidadesLog.info("MONClientesBean.quitarBloqueoFinanciero(cliente): Salida"); 
            return false;
        } catch (PersistenceException ex) {
            sessionContext.setRollbackOnly();
            throw new MareException(ex, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS));
        }
        UtilidadesLog.info("MONClientesBean.quitarBloqueoFinanciero(cliente): Salida"); 
        return true;
    }

    /**
     *Obtiene la direccion de un un cliente dado un oid de cliente y un tipo de dirección.
      Si no se especifica el tipo de direccion se devuelve la principal.

      si (oidTipoDireccion == null) {
      Llamamos al finder findDireccionPrincipalCliente del entity DireccionCliente pasandole el oidCliente.
      Obtenemos una Collection de entidades ClienteDireccion.
      si la Collection esta vacia el metodo devuelve null
      si devuelve más de una entidad generamos una MareException con un error de sistema indicando que el sistema se ha vuelto inconsistente porque un cliente tiene más de una dirección principal.
      else con las propiedades del unico entity devuelto generamos un DTODireccion y lo devolvemos como resultado de la llamada (en un array de un sólo dto)
      } else {
      Llamamos al findByClienteyTipo del entity DireccionCliente pasandole el oidCliente y el oidTipo.
      Por cada entity que contenga creamos un DTODireccion y los devolvemos todos en un
     */
    public DTODireccion[] obtenerDireccionCliente(Long oidCliente, Long oidTipoDireccion) throws MareException {
        UtilidadesLog.info("MONClientesBean.obtenerDireccionCliente(oidCliente, oidTipoDireccion): Entrada"); 
        Collection col = null;
        Iterator it = null;
        DTODireccion[] dtoDirecciones = null;

        try {
            if (oidTipoDireccion == null) {
                col = new ClienteDireccionLocalHome().findDireccionPrincipalCliente(oidCliente);

                if (col.size() == 0) {
                    return null;
                }

                if (col.size() > 1) {
                    throw new MareException(new Exception(), UtilidadesError.armarCodigoError(CodigosError.ERROR_ASOCIACION_ESTRUCTURAL));
                }

                it = col.iterator();

                ClienteDireccionLocal clienteD = (ClienteDireccionLocal) it.next();
                DTODireccion dtoDireccion = new DTODireccion();
                dtoDireccion.setOid(clienteD.getOid());
                dtoDireccion.setEsDireccionPrincipal((clienteD.getInd_dire_ppal().longValue() == 0) ? Boolean.FALSE : Boolean.TRUE);
                dtoDireccion.setCodigoPostal(clienteD.getVal_cod_post());
                /* 
                if (clienteD.getVal_km() != null) {
                    dtoDireccion.setKilometro(new Integer(clienteD.getVal_km().intValue()));
                }*/

                dtoDireccion.setTipoDireccion(clienteD.getTidc_oid_tipo_dire());

                /*if (clienteD.getVal_lote() != null) {
                    dtoDireccion.setLote(new Integer(clienteD.getVal_lote().intValue()));
                }*/

                dtoDireccion.setVia(clienteD.getZvia_oid_via());
                dtoDireccion.setUnidadGeografica(clienteD.getTerr_oid_terr());
                dtoDireccion.setNombreVia(clienteD.getVal_nomb_via());

                if (clienteD.getNum_ppal() != null) {
                    /*
                     * V-PED001 - dmorello, 06/10/2006
                     * Cambio el tipo de numeroPrincipal de Integer a String
                     */
                    //dtoDireccion.setNumeroPrincipal(new Integer(clienteD.getNum_ppal()));
                    dtoDireccion.setNumeroPrincipal(clienteD.getNum_ppal());
                }

                dtoDireccion.setObservaciones(clienteD.getVal_obse());
                dtoDirecciones = new DTODireccion[1];
                dtoDirecciones[0] = dtoDireccion;
            } else {
                col = new ClienteDireccionLocalHome().findByClienteYTipo(oidCliente, oidTipoDireccion);

                int i = 0;

                if ((col != null) && (col.size() > 0)) {
                    it = col.iterator();
                    dtoDirecciones = new DTODireccion[col.size()];
                }

                while ((it != null) && it.hasNext()) {
                    ClienteDireccionLocal clienteD = (ClienteDireccionLocal) it.next();
                    DTODireccion dtoDireccion = new DTODireccion();
                    dtoDireccion.setOid(clienteD.getOid());
                    dtoDireccion.setEsDireccionPrincipal((clienteD.getInd_dire_ppal().longValue() == 0) ? Boolean.FALSE : Boolean.TRUE);
                    dtoDireccion.setCodigoPostal(clienteD.getVal_cod_post());
                    
                    if (clienteD.getVal_km() != null) {
                        dtoDireccion.setKilometro(new Integer(clienteD.getVal_km().intValue()));
                    }

                    dtoDireccion.setTipoDireccion(clienteD.getTidc_oid_tipo_dire());

                    if (clienteD.getVal_lote() != null) {
                        dtoDireccion.setLote(new Integer(clienteD.getVal_lote().intValue()));
                    }

                    dtoDireccion.setVia(clienteD.getZvia_oid_via());
                    dtoDireccion.setUnidadGeografica(clienteD.getTerr_oid_terr());
                    dtoDireccion.setNombreVia(clienteD.getVal_nomb_via());

                    if (clienteD.getNum_ppal() != null) {
                        /*
                         * V-PED001 - dmorello, 06/10/2006
                         * Cambio el tipo de numeroPrincipal de Integer a String
                         */
                        //dtoDireccion.setNumeroPrincipal(new Integer(clienteD.getNum_ppal()));
                        dtoDireccion.setNumeroPrincipal(clienteD.getNum_ppal());
                    }

                    dtoDireccion.setObservaciones(clienteD.getVal_obse());
                    dtoDirecciones[i] = dtoDireccion;
                    i++;
                }
            }
        }catch (MareException e) {
            throw e;
        }catch (Exception e) {
            UtilidadesLog.error("Error",e);
            throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE));
        }
        
        UtilidadesLog.info("MONClientesBean.obtenerDireccionCliente(oidCliente, oidTipoDireccion): Salida"); 

        return dtoDirecciones;
    }

    private Date truncarFecha(java.util.Date fecha) {
        if (fecha != null) {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            java.sql.Date fechaTruncada = java.sql.Date.valueOf(sdf.format(fecha));

            return fechaTruncada;
        } else {
            return null;
        }
    }
    
    

    public String obtenerDireccion(DTOOID dto) throws MareException {
        UtilidadesLog.info("MONClientesBean.obtenerDireccion(DTOOID): Entrada"); 
        DAOMAEMaestroClientes dao = new DAOMAEMaestroClientes(sessionContext.getCallerPrincipal().getName());
        UtilidadesLog.info("MONClientesBean.obtenerDireccion(DTOOID): Salida"); 
        return (dao.obtenerDireccion(dto));
    }

    public DTOSalida buscarClientesBloqueoFinanciero(DTOBuscarClienteBloqueo criterios) throws MareException {
        UtilidadesLog.info("MONClientesBean.buscarClientesBloqueoFinanciero(DTOBuscarClienteBloqueo): Entrada"); 
        DAOMAEMaestroClientes dao = new DAOMAEMaestroClientes(sessionContext.getCallerPrincipal().getName());
        UtilidadesLog.info("MONClientesBean.buscarClientesBloqueoFinanciero(DTOBuscarClienteBloqueo): Salida"); 
        return (dao.buscarClientesBloqueoFinanciero(criterios));
    }

    public DTOSalida obtenerTiposDireccionCliente(DTOOID cliente) throws MareException {
        UtilidadesLog.info("MONClientesBean.obtenerTiposDireccionCliente(DTOOID): Entrada"); 
        DAOMAEMaestroClientes dao = new DAOMAEMaestroClientes(sessionContext.getCallerPrincipal().getName());
        UtilidadesLog.info("MONClientesBean.obtenerTiposDireccionCliente(DTOOID): Salida"); 
        return new DTOSalida(dao.obtenerTiposDireccionCliente(cliente));
    }

    public DTOUnidadAdministrativa obtenerUnidadAdministrativa(Long cliente, Long periodo) throws MareException {
        UtilidadesLog.info("MONClientesBean.obtenerUnidadAdministrativa(cliente, periodo): Entrada"); 
        DAOMAEMaestroClientes dao = new DAOMAEMaestroClientes(sessionContext.getCallerPrincipal().getName());
        UtilidadesLog.info("MONClientesBean.obtenerUnidadAdministrativa(cliente, periodo): Salida"); 
        return dao.obtenerUnidadAdministrativa(cliente, periodo);
    }

    public DTOSalida buscarClientesParaCurso(DTOBuscarClientesCursos dto) throws MareException {
        UtilidadesLog.info("MONClientesBean.buscarClientesParaCurso(DTOBuscarClientesCursos): Entrada"); 

        DAOMAEMaestroClientes daoMaestroCliente = new DAOMAEMaestroClientes(sessionContext.getCallerPrincipal().getName());
        DTOSalida dtoSalida = daoMaestroCliente.buscarClientesParaCurso(dto);
        UtilidadesLog.info("MONClientesBean.buscarClientesParaCurso(DTOBuscarClientesCursos): Salida"); 

        return dtoSalida;
    }

    public boolean estaClienteBloqueado(Long cliente, String tipoBloqueo) throws MareException {
        UtilidadesLog.info("MONClientesBean.estaClienteBloqueado(cliente, tipoBloqueo): Entrada"); 
        DAOMAEMaestroClientes dao = new DAOMAEMaestroClientes(sessionContext.getCallerPrincipal().getName());
        UtilidadesLog.info("MONClientesBean.estaClienteBloqueado(cliente, tipoBloqueo): Salida"); 
        return dao.estaClienteBloqueado(cliente, tipoBloqueo);
    }

    public DTOSalida obtieneClientesAsignarAptas(DTOClientesAsignarAptas dto) throws MareException {
        UtilidadesLog.info("MONClientesBean.obtieneClientesAsignarAptas(DTOClientesAsignarAptas): Entrada"); 
        DAOMAEMaestroClientes daoMaestroClientes = new DAOMAEMaestroClientes(sessionContext.getCallerPrincipal().getName());
        UtilidadesLog.info("MONClientesBean.obtieneClientesAsignarAptas(DTOClientesAsignarAptas): Salida"); 
        return daoMaestroClientes.obtieneClientesAsignarAptas(dto);
    }

    public int obtieneClientesAsignarAptasInBD(MatrizCursosLocal matCur, DTOClientesAsignarAptas dto, Long oidAsigna) throws MareException {
        UtilidadesLog.info("MONClientesBean.obtieneClientesAsignarAptasInBD(MatrizCursosLocal matCur, DTOClientesAsignarAptas dto, Long oidAsigna): Entrada"); 
        DAOMAEMaestroClientes daoMaestroClientes = new DAOMAEMaestroClientes(sessionContext.getCallerPrincipal().getName());
        int retorno = daoMaestroClientes.obtieneClientesAsignarAptas(matCur,dto,oidAsigna);
        UtilidadesLog.info("MONClientesBean.obtieneClientesAsignarAptasInBD(MatrizCursosLocal matCur, DTOClientesAsignarAptas dto, Long oidAsigna): Salida"); 
        return retorno;
    }

    public DTOClienteSubtipos obtieneClienteSubtiposAptas(DTOCodigoCliente dto) throws MareException {
        UtilidadesLog.info("MONClientesBean.obtieneClienteSubtiposAptas(DTOCodigoCliente): Entrada"); 
        /*
        Se obtiene el objeto ClienteDatosBasicos (EJB Entity) cuyo código de cliente es dto.codigoCliente:
        findByCodigoYPais(dto.pais, dto.codigoCliente)

        Se crea DAOMAEMaestroClientes y se invoca el método obtieneClienteSubtiposAptas(ClienteDatosBasicos.oid)

        Se retorna en DTOClienteSubtipos los valores:
        DTOClienteSubtipos.oidCliente = ClienteDatosBasicos.oid
        DTOClienteSubtipos.subtipos = el RecordSet retornado por el método obtieneClienteSubtiposAptas de DAOMAEMaestroClientes
        */
        UtilidadesLog.info("llega al metodo");

        DTOClienteSubtipos dtoClienteSubtipo = new DTOClienteSubtipos();
        ClienteDatosBasicosLocalHome clienteDatosBasicosLH = null;
        ClienteDatosBasicosLocal clienteDatosBasicosL = null;

        try {
            clienteDatosBasicosLH = new ClienteDatosBasicosLocalHome();
            UtilidadesLog.info("locator local home");
            clienteDatosBasicosL = clienteDatosBasicosLH.findByCodigoYPais(dto.getOidPais(), dto.getCodigoCliente());
            UtilidadesLog.info("finder local");

            DAOMAEMaestroClientes daoMaestroClientes = new DAOMAEMaestroClientes(sessionContext.getCallerPrincipal().getName());
            UtilidadesLog.info("maestro de cleintes");

            DTOSalida dtoSalida = daoMaestroClientes.obtieneClienteSubtiposAptas(clienteDatosBasicosL.getOid());
            UtilidadesLog.info("sale");
            dtoClienteSubtipo.setOidCliente(clienteDatosBasicosL.getOid());
            UtilidadesLog.info("seteo");
            dtoClienteSubtipo.setSubtipos(dtoSalida.getResultado());
            UtilidadesLog.info("seteo");
        } catch (NoResultException ex) {
            sessionContext.setRollbackOnly();
            throw new MareException(ex, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE));
        } catch (PersistenceException ex) {
            sessionContext.setRollbackOnly();
            throw new MareException(ex, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS));
        }
        
        UtilidadesLog.info("MONClientesBean.obtieneClienteSubtiposAptas(DTOCodigoCliente): Salida"); 

        return dtoClienteSubtipo;
    }

    /**
    * @Autor: Hugo Andrés Mansi
    * @Fecha : 04/10/2004
    * @Recibe: un DTOBuscarClienteBloqueo
    * @Retorna: un DTOSalida con el resultado de la consulta
    * @Descripción: Busca los clientes que no tengan BLOQUEO_FINANCIERO. Es decir,
    *               cuyo MAE_TIPO_BLOQU.COD_TIPO_BLOQU <> MAEConstantes.BLOQUEO_FINANCIERO (02)
    *               o bien que no haya ningún registro para el cliente en la tabla MAE_CLIEN_BLOQU.
    */
    public DTOSalida buscarClientesDesBloqueoFinanciero(DTOBuscarClienteBloqueo dto) throws MareException {
        UtilidadesLog.info("MONClientesBean.buscarClientesDesBloqueoFinanciero(DTOBuscarClienteBloqueo): Entrada"); 
        DAOMAEMaestroClientes miDao = new DAOMAEMaestroClientes(sessionContext.getCallerPrincipal().getName());
        DTOSalida dtoSal = new DTOSalida();
        dtoSal = miDao.buscarClientesDesbloqueoFinanciero(dto);
        UtilidadesLog.info("MONClientesBean.buscarClientesDesBloqueoFinanciero(DTOBuscarClienteBloqueo): Salida"); 
        return dtoSal;
    }

    /*****************
    Autor: Viviana Bongiovanni
    Fecha: 05/01/2005
    *********************/
    private MONCreditoRiesgo getMONCreditoRiesgo() throws MareException {
        UtilidadesLog.info("MONClientesBean.getMONCreditoRiesgo(): Entrada"); 
        try {
            MONCreditoRiesgoHome carHome = CAREjbLocators.getMONCreditoRiesgoHome();
             UtilidadesLog.info("MONClientesBean.getMONCreditoRiesgo(): Salida"); 
            return carHome.create();
        } catch (RemoteException re) {
            throw new MareException(re, UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
        } catch (CreateException ce) {
            throw new MareException(ce, UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
        }
    }

    public DTOSalida obtenerMarcasClienteUnidadAdministrativa(DTOCodigoCliente dto) throws MareException {
        UtilidadesLog.info("MONClientesBean.obtenerMarcasClienteUnidadAdministrativa(DTOCodigoCliente): Entrada"); 
        DAOMAEMaestroClientes dao = new DAOMAEMaestroClientes(sessionContext.getCallerPrincipal().getName());
        DTOSalida out = dao.obtenerMarcasClienteUnidadAdministrativa(dto);
        UtilidadesLog.info("MONClientesBean.obtenerMarcasClienteUnidadAdministrativa(DTOCodigoCliente): Salida"); 
        return out;
    }

    public DTOSalida obtenerCanalesClienteUnidadAdministrativa(DTOCodigoCliente dto) throws MareException {
        UtilidadesLog.info("MONClientesBean.obtenerCanalesClienteUnidadAdministrativa(DTOCodigoCliente): Entrada"); 
        DAOMAEMaestroClientes dao = new DAOMAEMaestroClientes(sessionContext.getCallerPrincipal().getName());
        DTOSalida out = dao.obtenerCanalesClienteUnidadAdministrativa(dto);
        UtilidadesLog.info("MONClientesBean.obtenerCanalesClienteUnidadAdministrativa(DTOCodigoCliente): Salida"); 

        return out;
    }

    public DTOSalida consultarGerenteZona(DTOOID dto) throws MareException {
        UtilidadesLog.info("MONClientesBean.consultarGerenteZona(DTOOID): Entrada"); 
        DTOSalida dtoSal = new DTOSalida();
        DAOMAEMaestroClientes dao = new DAOMAEMaestroClientes(sessionContext.getCallerPrincipal().getName());
        dtoSal = dao.consultarGerenteZona(dto);
        UtilidadesLog.info("MONClientesBean.consultarGerenteZona(DTOOID): Salida"); 

        return dtoSal;
    }

    public DTOSalida obtenerZonaMarcaCanal(DTOOID dto) throws MareException {
        UtilidadesLog.info("MONClientesBean.obtenerZonaMarcaCanal(DTOOID): Entrada"); 
        DTOSalida dtoSal = new DTOSalida();
        DAOMAEMaestroClientes dao = new DAOMAEMaestroClientes(sessionContext.getCallerPrincipal().getName());
        dtoSal = dao.obtenerZonaMarcaCanal(dto);
        UtilidadesLog.info("MONClientesBean.obtenerZonaMarcaCanal(DTOOID): Salida"); 
        return dtoSal;
    }

    private MONEstatusClienteHome getMONEstatusClienteHome() throws NamingException {
        final InitialContext context = new InitialContext();

        return (MONEstatusClienteHome) PortableRemoteObject.narrow(context.lookup("java:comp/env/MONEstatusCliente"), MONEstatusClienteHome.class);
    }

    /**
     * Llamar al metodo de este MON pestanya1Base(), enviando el mismo dto de entrada
       a este metodo

       Con la respuesta recibida, crear un dto result de tipo DTOGenerarCodigoCliente:

       //Encapsulamos los atributos del dto obtenido en el dto de salida
       result.codigoCliente = dtos.codigoCliente;
       result.digitoControl = dtos.digitoControl;

       devolver result.
     * @throws es.indra.mare.common.exception.MareException
     * @return
     * @param dtoe
     */
    public DTOGenerarCodigoCliente generaCodigoCliente(DTOBelcorp dtoe) throws MareException {
        UtilidadesLog.info("MONClientesBean.generaCodigoCliente(DTOBelcorp): Entrada"); 
        DTOGenerarCodigoCliente dtoS = new DTOGenerarCodigoCliente();
        DTOPestanya1Base dtoI = this.pestanya1Base(dtoe);
        dtoS.setCodigoCliente(dtoI.getCodigoCliente());
        dtoS.setDigitoControl(dtoI.getDigitoControl());
        UtilidadesLog.info("MONClientesBean.generaCodigoCliente(DTOBelcorp): Salida"); 
        return dtoS;
    }

    public DTOSalida obtenerGerentesRegion(DTOOID dto) throws MareException {
        UtilidadesLog.info("MONClientesBean.obtenerGerentesRegion(DTOOID): Entrada"); 
        DTOSalida dtoS = new DTOSalida();
        RecordSet rs = new RecordSet();
        StringBuffer query = new StringBuffer();
        BelcorpService bs;

        query.append(" SELECT B.OID_CLIE as oidCliente, ");
        query.append(" (B.val_nom1||' '||B.val_nom2||' '||B.val_ape1||' '||B.val_ape2) as nombreGerente, ");
        query.append(" A.MARC_OID_MARC MARCA, ");
        query.append(" A.CANA_OID_CANA CANAL, ");
        query.append(" A.OID_REGI REGION  ");
        query.append(" FROM zon_regio A, ");
        query.append(" mae_clien B  ");
        query.append(" WHERE 1=1 ");

        if (dto.getOidPais() != null) {
            query.append(" AND A.PAIS_OID_PAIS = " + dto.getOidPais() + "  ");
        }

        query.append(" AND B.oid_clie (+) = A.clie_oid_clie  ");
        query.append(" ORDER BY nombreGerente ");

        try {
            bs = BelcorpService.getInstance();
        } catch (MareMiiServiceNotFoundException ex) {
            throw new MareException(ex, UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_PEDIR_UN_SERVICIO_MARE));
        }

        try {
            rs = bs.dbService.executeStaticQuery(query.toString());
        } catch (Exception ex) {
            throw new MareException(ex, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS));
        }

        dtoS.setResultado(rs);
        UtilidadesLog.info("MONClientesBean.obtenerGerentesRegion(DTOOID): Salida"); 

        return dtoS;
    }

    private MONProcesosPEDHome getMONProcesosPEDHome() throws NamingException {
        UtilidadesLog.info("MONClientesBean.getMONProcesosPEDHome(): Entrada"); 
        final InitialContext context = new InitialContext();
        UtilidadesLog.info("MONClientesBean.getMONProcesosPEDHome(): Salida"); 
        return (MONProcesosPEDHome) PortableRemoteObject.narrow(context.lookup("java:comp/env/MONProcesosPED"), MONProcesosPEDHome.class);
    }

    /**
     * @Autor: Emilio Noziglia
     * @Fecha : 20/05/2005
     * @Recibe: un DTOCodigoCliente
     * @Retorna: un DTOREPHistorialCreditoCliente
     * @Descripción: obtiene todo el historial de credito de un cliente.
     *
     */
    public DTOREPHistorialCreditoCliente obtenerHistorialCreditoCliente(DTOCodigoCliente dtoE) throws MareException {
        UtilidadesLog.info("MONClientesBean.obtenerHistorialCreditoCliente(DTOCodigoCliente): Entrada"); 
        UtilidadesLog.info("entra en obtenerHistorialCreditoCliente con DTOCodigoCliente " + dtoE);

        DTOREPHistorialCreditoCliente dtoS = new DTOREPHistorialCreditoCliente();

        dtoS.setDatosBasicosCliente(this.obtenerDatosBasicosCliente(dtoE));
        dtoS.setSolicitudMasAntiguaNoCancelada(this.obtenerSolicitudMasAntiguaNoCancelada(dtoE));
        dtoS.setCuentasCorrientes(this.obtenerCuentaCorriente(dtoE));
        dtoS.setCobranzas(this.obtenerCobranzas(dtoE));
        dtoS.setCredito(this.obtenerDatosCredito(dtoE));
        dtoS.setSolicitudesBloquedas(this.obtenerSolicitudesBloqueadas(dtoE));
        UtilidadesLog.info("MONClientesBean.obtenerHistorialCreditoCliente(DTOCodigoCliente): Salida"); 

        return dtoS;
    }

    /**
     * @Autor: Emilio Noziglia
     * @Fecha : 20/05/2005
     * @Recibe: un DTOCodigoCliente
     * @Retorna: un DTOREPClienteDatosBasicos
     * @Descripción: obtiene los datos basicos de un cliente.
     *
     */
    public DTOREPClienteDatosBasicos obtenerDatosBasicosCliente(DTOCodigoCliente dtoE) throws MareException {
        UtilidadesLog.info("MONClientesBean.obtenerDatosBasicosCliente(DTOCodigoCliente): Entrada"); 

        DTOREPClienteDatosBasicos dtoS = new DTOREPClienteDatosBasicos();

        try {
            //cod cliente
            UtilidadesLog.info("obteniendo cod cliente");
            dtoS.setCodigoCliente(dtoE.getCodigoCliente());

            //monbre cliente
            UtilidadesLog.info("obteniendo Nombre Cliente");

            ClienteDatosBasicosLocal cliente = this.getClienteDatosBasicosLocalHome().findByUK(dtoE.getOidPais(), dtoE.getCodigoCliente());
            dtoS.setNombreCliente(((cliente.getVal_nom1() == null) ? "" : (cliente.getVal_nom1() + " ")) + ((cliente.getVal_nom2() == null) ? "" : (cliente.getVal_nom2() + " ")) + ((cliente.getVal_ape1() == null) ? "" : (cliente.getVal_ape1() + " ")) + ((cliente.getVal_ape2() == null) ? "" : (cliente.getVal_ape2())));

            //telefono
            UtilidadesLog.info("obteniendo telefono");

            ClienteComunicacionLocal clienteComunicacion = null;

            try {
                clienteComunicacion = new ClienteComunicacionLocalHome().findByUK(cliente.getOid(), ConstantesMAE.TIPO_COMUNICACION_TFNO);
                dtoS.setTelefono(clienteComunicacion.getVal_text_comu());
            } catch (NoResultException nre) {
                UtilidadesLog.info("El Cliente no tiene telefono");
            } catch (PersistenceException pe) {
                sessionContext.setRollbackOnly();
                throw new MareException(pe, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS));
            }

            //status cliente
            UtilidadesLog.info("obteniendo status cliente");

            ClienteDatosAdicionalesLocal clienteDatosAdicionales = new ClienteDatosAdicionalesLocalHome().findByCliente(cliente.getOid());
            Entidadi18nLocal e18n = new Entidadi18nLocalHome().findByEntAtrIdioPK("MAE_ESTAT_CLIEN", new Long(1), dtoE.getOidIdioma(), clienteDatosAdicionales.getEsta_oid_esta_clie());
            dtoS.setStatusCliente(e18n.getDetalle());

            //Email
            UtilidadesLog.info("obteniendo Email");

            try {
                clienteComunicacion = null;
                clienteComunicacion = new ClienteComunicacionLocalHome().findByUK(cliente.getOid(), ConstantesMAE.TIPO_COMUNICACION_EMAIL);
                dtoS.setEmail(clienteComunicacion.getVal_text_comu());
            } catch (NoResultException nre) {
                UtilidadesLog.info("El Cliente no tiene mail");
            } catch (PersistenceException pe) {
                sessionContext.setRollbackOnly();
                throw new MareException(pe, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS));
            }

            //marca
            //canal
            UtilidadesLog.info("obteniendo marca,canal");

            try {
                Collection clieUAdms = new ClienteUnidadAdministrativaLocalHome().findByCliente(cliente.getOid());

                if (!clieUAdms.isEmpty()) {
                    Iterator itclieUAdms = clieUAdms.iterator();
                    boolean seguir = true;
                    UtilidadesLog.info("obteniendo marca,canal 1:" + itclieUAdms.hasNext());

                    while (itclieUAdms.hasNext() && seguir) {
                        ClienteUnidadAdministrativaLocal clienteUa = (ClienteUnidadAdministrativaLocal) itclieUAdms.next();
                        

                        if (clienteUa.getInd_acti().equals(new Long(1))) {
                            try {
                                TerritorioAdministrativoLocal terrAdmClie = new TerritorioAdministrativoLocalHome().findByPrimaryKey(clienteUa.getZtad_oid_terr_admi());
                                Entidadi18nLocal e18nCanal = new Entidadi18nLocalHome().findByEntAtrIdioPK("SEG_CANAL", new Long(1), dtoE.getOidIdioma(), terrAdmClie.getOidCanal());
                        
                                dtoS.setCanal(e18nCanal.getDetalle());

                                MarcaLocal marcaClie = new MarcaLocalHome().findByPrimaryKey(terrAdmClie.getOidMarca());
                        
                                dtoS.setMarca(marcaClie.getDes_marc());
                            } catch (Exception e) {
                                UtilidadesLog.info("Hubo un problema en TerritorioAdministrativoLocal, Entidadi18nLocal o MarcaLocal");
                            }

                            seguir = false;
                        }
                    }
                }
            } catch (NoResultException nre) {
                UtilidadesLog.info("El Cliente no tiene Unidad Administrativa");
            } catch (PersistenceException pe) {
                sessionContext.setRollbackOnly();
                throw new MareException(pe, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS));
            }

            //Periodo Ingreso
            UtilidadesLog.info("obteniendo Periodo Ingreso");

            try {
                    //modificado enoziglia 08/09/2005 se debe filtrar el cliente y el estatus "registrado" o sea 1.
                    ClienteHistoricoEstatusLocal estaHistoClie = new ClienteHistoricoEstatusLocalHome().findByClienteEstatus(cliente.getOid(), ConstantesMAE.OID_ESTATUS_REGISTRADA);
                    PeriodoLocal periodo = new PeriodoLocalHome().findByPrimaryKey(estaHistoClie.getPerd_oid_peri());
                    dtoS.setPeriodo(periodo.getNombrePeriodo());
            } catch (NoResultException nre) {
                UtilidadesLog.info("El Cliente no tiene Historico de Estatus");
            } catch (PersistenceException pe) {
                sessionContext.setRollbackOnly();
                throw new MareException(pe, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS));
            }

            //bloqueo administrativo
            //motivo bloqueo administrativo
            //bloqueo financiero
            UtilidadesLog.info("obteniendo bloqueo administrativo,motivo bloqueo administrativo, bloqueo financiero");

            try {
                Collection clientebloqueos = new ClienteBloqueoLocalHome().findByCliente(cliente.getOid());
                dtoS.setBloqueoAdministrativo(Boolean.FALSE);
                dtoS.setBloqueoFinanciero(Boolean.FALSE);
                dtoS.setMotivoBloqueoAdministrativo(new String(""));

                if (!clientebloqueos.isEmpty()) {
                    Iterator itclientebloqueos = clientebloqueos.iterator();

                    while (itclientebloqueos.hasNext()) {
                        ClienteBloqueoLocal clientebloqueo = (ClienteBloqueoLocal) itclientebloqueos.next();
                        TipoBloqueoLocal tipobloq = new TipoBloqueoLocalHome().findByPrimaryKey(clientebloqueo.getTibq_oid_tipo_bloq());

                        if (tipobloq.getCod_tipo_bloq().equals("02")) {
                            dtoS.setBloqueoAdministrativo(Boolean.TRUE);
                            dtoS.setMotivoBloqueoAdministrativo(clientebloqueo.getVal_moti_bloq());
                        } else if (tipobloq.getCod_tipo_bloq().equals("01")) {
                            dtoS.setBloqueoFinanciero(Boolean.TRUE);
                        }
                    }
                }
            } catch (NoResultException nre) {
                UtilidadesLog.info("El Cliente no tiene Bloqueos");
            } catch (PersistenceException pe) {
                sessionContext.setRollbackOnly();
                throw new MareException(pe, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS));
            }

            //fecha de ingreso
            UtilidadesLog.info("obteniendo fecha de ingreso");

            if (cliente.getFec_ingr() != null) {
                dtoS.setFechaDeIngreso(new java.sql.Date(cliente.getFec_ingr().getTime()));
            }

            UtilidadesLog.info("MONClientesBean.obtenerDatosBasicosCliente(DTOCodigoCliente): Salida"); 
        } catch (NoResultException e) {
            sessionContext.setRollbackOnly();
            throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE));
        } catch (PersistenceException pe) {
            sessionContext.setRollbackOnly();
            throw new MareException(pe, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS));
        }

        return dtoS;
    }

    /**
     * @Autor: Emilio Noziglia
     * @Fecha : 20/05/2005
     * @Recibe: un DTOCodigoCliente
     * @Retorna: un DTOREPSolicitudMasAntiguaNoCancelada
     * @Descripción: obtiene la solicitud mas antigua no cancelada de un cliente.
     *
     */
    public DTOREPSolicitudMasAntiguaNoCancelada obtenerSolicitudMasAntiguaNoCancelada(DTOCodigoCliente dtoE) throws MareException {
        UtilidadesLog.info("MONClientesBean.obtenerSolicitudMasAntiguaNoCancelada(DTOCodigoCliente): Entrada"); 

        DTOREPSolicitudMasAntiguaNoCancelada dtoS = new DTOREPSolicitudMasAntiguaNoCancelada();

        DAOMAEMaestroClientes dao = new DAOMAEMaestroClientes(sessionContext.getCallerPrincipal().getName());
        DTOSalida dtoRes = dao.obtieneSolicitudMasAntiguaNoCancelada(dtoE);
        RecordSet rs = dtoRes.getResultado();

        if (!rs.esVacio()) {
            dtoS.setTipoSolicitud((String) rs.getValueAt(0, "TIPO_SOLI"));
            dtoS.setNumeroSolicitud(BigToInteger(rs.getValueAt(0, "NUM_IDEN_CUOT")));
            dtoS.setSociedad((String) rs.getValueAt(0, "SOCIEDAD"));
            dtoS.setFechaFacturacion((Date) rs.getValueAt(0, "FEC_DOCU"));
            dtoS.setFechaVencimiento((Date) rs.getValueAt(0, "FEC_VENC"));
            dtoS.setCondicionPago((String) rs.getValueAt(0, "FORMA_PAGO"));
            dtoS.setMontoPedido((BigDecimal) rs.getValueAt(0, "MONTO"));
            dtoS.setMontoSaldo((BigDecimal) rs.getValueAt(0, "MONTO_SALDO"));
        }

        UtilidadesLog.info("MONClientesBean.obtenerSolicitudMasAntiguaNoCancelada(DTOCodigoCliente): Salida"); 

        return dtoS;
    }

    /**
     * @Autor: Emilio Noziglia
     * @Fecha : 20/05/2005
     * @Recibe: un Object
     * @Retorna: un Integer
     * @Descripción: transforma un objeto a Integer.
     *
     */
    private Integer BigToInteger(Object num) {
        if (num != null) {
            return (new Integer(((BigDecimal) num).intValue()));
        } else {
            return null;
        }
    }

    /**
     * @Autor: Emilio Noziglia
     * @Fecha : 20/05/2005
     * @Recibe: un Object
     * @Retorna: un Long
     * @Descripción: transforma un objeto a long.
     *
     */
    private Long BigToLong(Object num) {
        if (num != null) {
            return (new Long(((BigDecimal) num).longValue()));
        } else {
            return null;
        }
    }


    /**
     * @Autor: Emilio Noziglia
     * @Fecha : 20/05/2005
     * @Recibe: un DTOCodigoCliente
     * @Retorna: un DTOREPCuentasCorrientes
     * @Descripción: obtiene los datos de cuentas corrientes de un cliente.
     *
     */
    public DTOREPCuentasCorrientes obtenerCuentaCorriente(DTOCodigoCliente dtoE) throws MareException {
        UtilidadesLog.info("MONClientesBean.obtenerCuentaCorriente(DTOCodigoCliente): Entrada"); 

        DTOREPCuentasCorrientes dtoS = new DTOREPCuentasCorrientes();

        try {
            //saldo actual
            UtilidadesLog.info("obteniendo saldo actual");

            ClienteDatosBasicosLocal cliente = this.getClienteDatosBasicosLocalHome().findByUK(dtoE.getOidPais(), dtoE.getCodigoCliente());
            MONInterfaceModulos ccc = this.getMONInterfaceModulosHome().create();
            DTOSaldosPorFechasyVtos dtoCcc = new DTOSaldosPorFechasyVtos();
            dtoCcc.setOidCliente(cliente.getOid());
            dtoCcc.setOidPais(dtoE.getOidPais());

            DTOTotal saldo = ccc.calcularSaldoCCCliente(dtoCcc);
            dtoS.setSaldoActual(saldo.getTotal());

            //nro de veces pronto pago
            UtilidadesLog.info("obteniendo nro de veces pronto pago");
            dtoS.setNroVecesProntoPago(ccc.obtenerNroVecesProntoPago(cliente.getOid(), dtoE.getOidPais()));

            //nro de veces recargo financiero
            UtilidadesLog.info("obteniendo nro de veces recargo financiero");
            dtoS.setNroVecesRecargoFinanciero(ccc.obtenerNroVecesRecargoFinanciero(cliente.getOid(), dtoE.getOidPais()));

            //promedio dias de mora
            UtilidadesLog.info("obteniendo promedio dias de mora");

            DTODias dtodiasmora = ccc.calcularDiasAtrasoCliente(dtoCcc);

            if (dtodiasmora.getNumeroDias() != null) {
                dtoS.setPromedioDiasMora(new Long(dtodiasmora.getNumeroDias().intValue()));
            }

            //valor total en mora
            UtilidadesLog.info("obteniendo valor total en mora");

            DTOSaldosPorDiasPeriodos dtoSDp = new DTOSaldosPorDiasPeriodos();
            dtoSDp.setOidCliente(cliente.getOid());
            dtoSDp.setOidPais(dtoE.getOidPais());
            dtoSDp.setOidIdioma(dtoE.getOidIdioma());

            DTOTotalyDias dtototalmora = ccc.calcularDeudaVencidaCCCliente(dtoSDp);
            dtoS.setValorTotalMora(BigToLong(dtototalmora.getTotal()));

            //porcentaje de mora respecto a la factura
            UtilidadesLog.info("obteniendo porcentaje de mora respecto a la factura");

            if ((saldo.getTotal() != null) && (saldo.getTotal().longValue() != 0) && (dtodiasmora.getNumeroDias() != null) && (dtodiasmora.getNumeroDias().longValue() != 0)) {
                long saldoActual = saldo.getTotal().longValue();
                long dias = dtodiasmora.getNumeroDias().longValue();
                long porcentaje = (dias / saldoActual) * 100;
                dtoS.setPorcDeFactura(new Long(porcentaje));
            }
        } catch (NamingException namingException) {
            sessionContext.setRollbackOnly();
            namingException.printStackTrace();
            throw new MareException(namingException, UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
        } catch (CreateException createException) {
            sessionContext.setRollbackOnly();
            createException.printStackTrace();
            throw new MareException(createException, UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
        } catch (NoResultException e) {
            sessionContext.setRollbackOnly();
            throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE));
        } catch (PersistenceException e) {
            sessionContext.setRollbackOnly();
            throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS));
        } catch (RemoteException re) {
            sessionContext.setRollbackOnly();
            throw new MareException(re, UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
        }

        UtilidadesLog.info("MONClientesBean.obtenerCuentaCorriente(DTOCodigoCliente): Salida"); 

        return dtoS;
    }

    private MONInterfaceModulosHome getMONInterfaceModulosHome() throws NamingException {
        UtilidadesLog.info("MONClientesBean.getMONInterfaceModulosHome(): Entrada"); 
        final InitialContext context = new InitialContext();
        UtilidadesLog.info("MONClientesBean.getMONInterfaceModulosHome(): Salida"); 
        return (MONInterfaceModulosHome) PortableRemoteObject.narrow(context.lookup("java:comp/env/MONInterfaceModulos"), MONInterfaceModulosHome.class);
    }

    /**
     * @Autor: Emilio Noziglia
     * @Fecha : 20/05/2005
     * @Recibe: un DTOCodigoCliente
     * @Retorna: un DTOREPCobranzas
     * @Descripción: obtiene los datos de cobranzas de un cliente.
     *
     */
    public DTOREPCobranzas obtenerCobranzas(DTOCodigoCliente dtoE) throws MareException {
        UtilidadesLog.info("MONClientesBean.obtenerCobranzas(DTOCodigoCliente): Entrada"); 

        DTOREPCobranzas dtoS = new DTOREPCobranzas();

        try {
            //actualmente en cobranzas
            UtilidadesLog.info("obteniendo actualmente en cobranzas");

            ClienteDatosBasicosLocal cliente = this.getClienteDatosBasicosLocalHome().findByUK(dtoE.getOidPais(), dtoE.getCodigoCliente());
            DAOMAEMaestroClientes dao = new DAOMAEMaestroClientes(sessionContext.getCallerPrincipal().getName());
            dtoS.setActualmenteEnCobranzas(dao.obtenerDeudaCobranza(cliente.getOid()));

            //datos etapa
            UtilidadesLog.info("obteniendo datos etapa");
            dtoS.setDatosEtapa(dao.obtenerVecesEtapa(cliente.getOid(),cliente.getPais_oid_pais()));
        } catch (NoResultException e) {
            sessionContext.setRollbackOnly();
            throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE));
        } catch (PersistenceException e) {
            sessionContext.setRollbackOnly();
            throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS));
        }

        UtilidadesLog.info("MONClientesBean.obtenerCobranzas(DTOCodigoCliente): Salida"); 

        return dtoS;
    }

    public DTOSalida obtenerUsuarioResponsable(DTOBelcorp dto) throws MareException {
        UtilidadesLog.info("MONClientesBean.obtenerUsuarioResponsable(DTOBelcorp): Entrada"); 
        DTOSalida dtoSal = new DTOSalida();
        DAOMAEMaestroClientes dao = new DAOMAEMaestroClientes(sessionContext.getCallerPrincipal().getName());
        dtoSal = dao.obtenerUsuarioResponsable(dto);
        UtilidadesLog.info("MONClientesBean.obtenerUsuarioResponsable(DTOBelcorp): Salida"); 
        return dtoSal;
    }

    /**
     * @Autor: Emilio Noziglia
     * @Fecha : 20/05/2005
     * @Recibe: un DTOCodigoCliente
     * @Retorna: un DTOREPCredito
     * @Descripción: obtiene los datos de credito dado un codigo cliente.
     *
     */
    public DTOREPCredito obtenerDatosCredito(DTOCodigoCliente dtoE) throws MareException {
        UtilidadesLog.info("MONClientesBean.obtenerDatosCredito(DTOCodigoCliente): Entrada"); 

        DTOREPCredito dtoS = new DTOREPCredito();
        DAOMAEMaestroClientes daoMaeCli = new DAOMAEMaestroClientes(sessionContext.getCallerPrincipal().getName());
        DAOSolicitud daoSolic = new DAOSolicitud();

        try {
            Entidadi18nLocalHome e18nlh = new Entidadi18nLocalHome();

            ClienteDatosBasicosLocal cliente = new ClienteDatosBasicosLocalHome().findByUK(dtoE.getOidPais(), dtoE.getCodigoCliente());
            UtilidadesLog.info("OidCliente:" + cliente.getOid());

            Collection clienteUas = new ClienteUnidadAdministrativaLocalHome().findByCliente(cliente.getOid());

            ClienteUnidadAdministrativaLocal clienteUa = null;
            boolean encontro = false;

            if (!clienteUas.isEmpty()) {
                Iterator itclienteUas = clienteUas.iterator();

                while (itclienteUas.hasNext() && !encontro) {
                    clienteUa = (ClienteUnidadAdministrativaLocal) itclienteUas.next();

                    if ((clienteUa != null) && (clienteUa.getInd_acti() != null) && (clienteUa.getInd_acti().equals(new Long(1)))) {
                        encontro = true;
                    }
                }
            }

            if (!encontro) {
                UtilidadesLog.info("No hay unidad administrativa del cliente.");
                throw new MareException(null, null, UtilidadesError.armarCodigoError(ConstantesSEG.MODULO_ZON, "", es.indra.sicc.logicanegocio.zon.ErroresDeNegocio.NO_EXISTE_UNIDAD_ADMINISTRATIVA));
            }

            TerritorioAdministrativoLocal terrAdm = new TerritorioAdministrativoLocalHome().findByPrimaryKey(clienteUa.getZtad_oid_terr_admi());
            SeccionLocal seccion = new SeccionLocalHome().findByPrimaryKey(terrAdm.getOidSeccion());
            ZonaLocal zona = new ZonaLocalHome().findByPrimaryKey(seccion.getOidZona());
            RegionLocal region = new RegionLocalHome().findByPrimaryKey(zona.getOidRegion());

            UtilidadesLog.info("Zonificacion del cliente:TerrAdmin:" + clienteUa.getZtad_oid_terr_admi());
            UtilidadesLog.info("Secc:" + terrAdm.getOidSeccion() + " Zona:" + seccion.getOidZona() + " Region:" + zona.getOidRegion());
            UtilidadesLog.info("SubgVtas:" + region.getSgvOidSubgVenta());

            Collection asignEjec = new AsignacionEjecutivoCuentaLocalHome().findBySBGRegZon(region.getSgvOidSubgVenta(), region.getOid(), zona.getOid());

            if (asignEjec.isEmpty()) {
                UtilidadesLog.info("No hay ejecutivo de cuentas asignado para la zonificacion del cliente.");

                //muestra el error no hay asignacion de ejecutivos de cuenta para la unidad administrativa del cliente
                throw new MareException(null, null, UtilidadesError.armarCodigoError(ConstantesSEG.MODULO_MAE, "", ErroresDeNegocio.NO_HAY_EJECUTIVOS_CUENTA_ASIGNADOS));
            }

            UtilidadesLog.info("Obtuvo Asignacion Ejecutivos Cuenta");

            EjecutivosCuentaLocal ejecCuen = new EjecutivosCuentaLocalHome().findByPrimaryKey(((AsignacionEjecutivoCuentaLocal) asignEjec.iterator().next()).getOidEjecutivoCuenta());
            Long codUsuar = ejecCuen.getCodigoEjecutivoCuenta();

            UtilidadesLog.info("Obtuvo Ejecutivo Cuenta.Usuario:" + codUsuar);
            dtoS.setResponsableCredito(daoMaeCli.obtenerNombreUsuarioLargo(codUsuar));

            //los nombres utilizados salen del SICC-DECU-REP-201-302-CAR.doc
            long LC = 0;
            long SNA = 0;
            long DT = 0;
            long C3 = 0;
            long LCD = 0;

            //Linea de credito
            //linea credito actual
            UtilidadesLog.info("obteniendo linea credito actual");

            ClienteDatosAdicionalesLocalHome cliDatAdicLH = new ClienteDatosAdicionalesLocalHome();
            ClienteDatosAdicionalesLocal clienDatAdic = cliDatAdicLH.findByCliente(cliente.getOid());

            if (clienDatAdic.getImp_mont_line_cred() != null) {
                LC = clienDatAdic.getImp_mont_line_cred().longValue();
                dtoS.setLineaCreditoActual(new Long(LC));
            }

            //linea credito disponible
            UtilidadesLog.info("obteniendo linea credito disponible");
            SNA = daoSolic.calcularMontoSolicitudesNuevas(cliente.getOid()).longValue();

            MONInterfaceModulosHome cccIntModH = CCCEjbLocators.getMONInterfaceModulosHome();
            MONInterfaceModulos cccIntMod = (MONInterfaceModulos) cccIntModH.create();
            DTOSaldosPorFechasyVtos dtoIn = new DTOSaldosPorFechasyVtos();
            dtoIn.setOidCliente(cliente.getOid());
            dtoIn.setOidPais(dtoE.getOidPais());
            dtoIn.setOidIdioma(dtoE.getOidIdioma());

            DTOTotal dtoTotDT = cccIntMod.calcularSaldoCCCliente(dtoIn);

            if (dtoTotDT.getTotal() != null) {
                DT = dtoTotDT.getTotal().longValue();
            }

            DTOSaldosPorFechas dtoSPF = new DTOSaldosPorFechas();
            dtoSPF.setOidCliente(cliente.getOid());
            dtoSPF.setOidPais(dtoE.getOidPais());
            dtoSPF.setOidIdioma(dtoE.getOidIdioma());

            DTOTotal dtoTotC3 = cccIntMod.calcularCuponTramiteCliente(dtoSPF);

            if (dtoTotC3.getTotal() != null) {
                C3 = dtoTotC3.getTotal().longValue();
            }

            LCD = LC - SNA - DT + C3;
            UtilidadesLog.info("Linea de Credito Disponible:----------------------------------");
            UtilidadesLog.info("LCD:" + LCD + " LC:" + LC + " SNA:" + SNA + " DT:" + DT + " C3:" + C3);
            UtilidadesLog.info("--------------------------------------------------------------");
            dtoS.setLineaCreditoDisponible(new Long(LCD));

            //periodo ultima evaluacion (periodo linea credito)
            UtilidadesLog.info("obteniendo periodo ultima evaluacion (Periodo:" + clienDatAdic.getPerd_oid_peri_line_cred() + ")");

            PeriodoLocalHome periLH = new PeriodoLocalHome();
            PeriodoLocal peri = null;
            ClaseSolicitudLocalHome cslh = new ClaseSolicitudLocalHome();
            MONCreditoRiesgo creditoRiesgo = this.getMONCreditoRiesgo();
            MONPeriodosHome monPerioH = this.getMONPeriodosHome();
            MONPeriodos monPeriodos = monPerioH.create();         
            
            Collection colClaseSolic = cslh.findByIndOrdenCompra(Boolean.TRUE); //TRUE = Orden de Compra activo
            Iterator itcolClaseSolic = colClaseSolic.iterator();
            ClaseSolicitudLocal claseSolic = null;

            if (itcolClaseSolic.hasNext()) {
                claseSolic = (ClaseSolicitudLocal) itcolClaseSolic.next();
            } else {
                UtilidadesLog.info("No se encontro clase solicitud con orden de compra en true.");
            }
            
            
            if (clienDatAdic.getPerd_oid_peri_line_cred() != null) {
                peri = periLH.findByPrimaryKey(clienDatAdic.getPerd_oid_peri_line_cred());
                UtilidadesLog.info("periodo ultima evaluacion:" + peri.getNombrePeriodo());
                dtoS.setPeriodoLineaCredito(peri.getNombrePeriodo());

                //pedido promedio ultima evaluacion
                UtilidadesLog.info("obteniendo pedido promedio ultima evaluacion");
               
                DTOCalculoPedidos dtoCredRies = new DTOCalculoPedidos();
                dtoCredRies.setOidClaseSolicitud(claseSolic.getOid());

                dtoCredRies.setOidCliente(cliente.getOid());
                dtoCredRies.setOidPeriodo1(clienDatAdic.getPerd_oid_peri_line_cred());

                DTOPeriodo dtoPeriodoActual = monPeriodos.obtienePeriodoActual(peri.getOidPais(), peri.getOidMarca(), peri.getOidCanal());
                dtoCredRies.setOidPeriodo2(dtoPeriodoActual.getOid());

                if (dtoCredRies.getOidPeriodo1() != null) {
                    BigDecimal pedidoPromedio = creditoRiesgo.calcularPedidoPromedioUltimaEvaluacion(dtoCredRies);
                    dtoS.setPedidoPromedioUltimaEvaluacion(new Long(pedidoPromedio.longValue()));
                }

                //promedio linea credito consumida ultimos 6 meses
                UtilidadesLog.info("obteniendo promedio linea credito consumida ultimos 6 meses");

                long PORC = 0;

                if (LC != 0) {
                    PORC = (LC - LCD) / LC;
                }

                UtilidadesLog.info("Promedio Linea de Credito Consumida:-----------------------");
                UtilidadesLog.info("PORC:" + PORC + " LC:" + LC + " LCD:" + LCD);
                UtilidadesLog.info("-----------------------------------------------------------");
                dtoS.setPorcLineaCreditoActualConsumida(new Long(PORC));
            }

            //Nivel de Riesgo
            //periodo ultima evaluacion (periodo nivel de riesgo)
            DTOCalculoPedidos dtoCredRies = new DTOCalculoPedidos(); 
            
            dtoCredRies.setOidCliente(cliente.getOid());
            dtoCredRies.setOidClaseSolicitud(claseSolic.getOid());
            
            //porcentaje pedidos desde ultima evaluacion
            UtilidadesLog.info("obteniendo porcentaje pedidos desde ultima evaluacion (NroPeriodosPedidoUltEval)");
            DTOPeriodo dtoPeriodoActual = new DTOPeriodo();

            if (clienDatAdic.getPerd_oid_peri_nive_ries() != null) {
                dtoCredRies.setOidPeriodo1(clienDatAdic.getPerd_oid_peri_nive_ries());
                peri = periLH.findByPrimaryKey(clienDatAdic.getPerd_oid_peri_nive_ries());
                dtoS.setPeriodoUltimaEvaluacion(peri.getNombrePeriodo());
                dtoPeriodoActual = monPeriodos.obtienePeriodoActual(peri.getOidPais(), peri.getOidMarca(), peri.getOidCanal());
            } else {
                if (cliente.getFec_ingr() != null) {
                    DTOPeriodo dtoPeriodoIngreso = daoMaeCli.obtienePrimerPeriodoCliente(cliente.getOid());
                    dtoCredRies.setOidPeriodo1((dtoPeriodoIngreso != null) ? dtoPeriodoIngreso.getOid() : null);
                    dtoS.setPeriodoUltimaEvaluacion(dtoPeriodoIngreso.getNombre());
                    dtoPeriodoActual = monPeriodos.obtienePeriodoActual(dtoPeriodoIngreso.getOidPais(), dtoPeriodoIngreso.getMarca(), dtoPeriodoIngreso.getCanal());
                }
            }
            
            dtoCredRies.setOidPeriodo2((dtoPeriodoActual!=null)?dtoPeriodoActual.getOid():null);
            
            if (dtoCredRies.getOidPeriodo1() != null) {
                Integer nroPeriPedi = creditoRiesgo.calcularPeriodosPedidoUltimaEvaluacion(dtoCredRies);
                dtoS.setNroPeriodosPedidoUltEval(nroPeriPedi);
            } else {
                UtilidadesLog.info("NO SE ENCONTRO PERIODO 1 PARA calcularPeriodosPedidoUltimaEvaluacion - Nivel Riesgo.");
            }
            

            //nivel de riesgo actual
            UtilidadesLog.info("obteniendo nivel de riesgo actual");

            if (clienDatAdic.getNiri_oid_nive_ries() != null) {
                Entidadi18nLocal e18n = e18nlh.findByEntAtrIdioPK("CAR_NIVEL_RIESG", new Long(1), dtoE.getOidIdioma(), clienDatAdic.getNiri_oid_nive_ries());
                dtoS.setNivelRiesgo(e18n.getDetalle());
            }
        } catch (NamingException namingException) {
            sessionContext.setRollbackOnly();
            throw new MareException(namingException, UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
        } catch (NoResultException e) {
            sessionContext.setRollbackOnly();
            throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE));
        } catch (PersistenceException e) {
            sessionContext.setRollbackOnly();
            throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS));
        } catch (RemoteException re) {
            sessionContext.setRollbackOnly();
            throw new MareException(re, UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
        } catch (CreateException createException) {
            sessionContext.setRollbackOnly();
            throw new MareException(createException, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS));
        }

        UtilidadesLog.info("MONClientesBean.obtenerDatosCredito(DTOCodigoCliente): Salida"); 

        return dtoS;
    }

    public DTODatosClienteCOB consultarDatosClienteCOB(DTOString dto) throws MareException {
        UtilidadesLog.info("MONClientesBean.consultarDatosClienteCOB(DTOString): Entrada"); 
        DAOMAEMaestroClientes daoMaestroCliente = new DAOMAEMaestroClientes(sessionContext.getCallerPrincipal().getName());
        DTODatosClienteCOB dtoSalida = daoMaestroCliente.consultarDatosClienteCOB(dto);
        UtilidadesLog.info("MONClientesBean.consultarDatosClienteCOB(DTOString): Salida"); 

        return dtoSalida;
    }


    private MONPeriodosHome getMONPeriodosHome() throws NamingException {
        UtilidadesLog.info("MONClientesBean.getMONPeriodosHome(): Entrada"); 
        final InitialContext context = new InitialContext();
        UtilidadesLog.info("MONClientesBean.getMONPeriodosHome(): Salida"); 
        return (MONPeriodosHome) PortableRemoteObject.narrow(context.lookup("java:comp/env/MONPeriodos"), MONPeriodosHome.class);
    }


    /**
     * @Autor: Emilio Noziglia
     * @Fecha : 20/05/2005
     * @Recibe: un DTOCodigoCliente
     * @Retorna: un DTOREPSolicitudesBloqueadas
     * @Descripción: obtiene las solicitudes bloqueadas en los ultimos seis meses.
     *
     */
    public DTOREPSolicitudesBloqueadas obtenerSolicitudesBloqueadas(DTOCodigoCliente dtoE) throws MareException {
        UtilidadesLog.info("MONClientesBean.obtenerSolicitudesBloqueadas(DTOCodigoCliente): Entrada"); 

        DTOREPSolicitudesBloqueadas dtoS = new DTOREPSolicitudesBloqueadas();

        try {
            DAOMAEMaestroClientes daoMae = new DAOMAEMaestroClientes(sessionContext.getCallerPrincipal().getName());
            ClienteDatosBasicosLocal cliente = this.getClienteDatosBasicosLocalHome().findByUK(dtoE.getOidPais(), dtoE.getCodigoCliente());

            //(datos solicitudes bloqueadas) solicitudes bloqueadas ultimos 6 meses
            UtilidadesLog.info("obteniendo solicitudes bloqueadas ultimos 6 meses");
            dtoS.setSoliBloqUltimosSeisMeses(daoMae.obtenerSolicitudesBloqueadasUltimos6Meses(cliente.getOid(), dtoE.getOidIdioma()));
        } catch (NoResultException e) {
            sessionContext.setRollbackOnly();
            throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE));
        } catch (PersistenceException e) {
            sessionContext.setRollbackOnly();
            throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS));
        }

        UtilidadesLog.info("MONClientesBean.obtenerSolicitudesBloqueadas(DTOCodigoCliente): Salida"); 

        return dtoS;
    }

    private ClienteDatosBasicosLocalHome getClienteDatosBasicosLocalHome() {
        return new ClienteDatosBasicosLocalHome();
    }


    private ClienteHistoricoEstatusLocalHome getClienteHistoricoEstatusLocalHome() {
        return new ClienteHistoricoEstatusLocalHome();
    }


    /**    
     *@Author: Pablo Perez
     *@Fecha: 28/10/2005
     *@throws: MareException
     *@return: DTODireccion[]
     *@param: Long oidCliente, Long oidTipoDireccion
     *@Observaciones: Metodo creado a raiz de incidencia bloqueante de Perú. Ref: 21299
     */ 

    public DTODireccion[] obtenerDireccionesPorTipo(Long oidCliente, Long oidTipoDireccion, Long idioma) throws MareException {
        UtilidadesLog.info("MONClientesBean.obtenerDireccionesPorTipo(Long oidCliente, Long oidTipoDireccion): Entrada"); 
        DAOMAEMaestroClientes dao = new DAOMAEMaestroClientes(sessionContext.getCallerPrincipal().getName());
        UtilidadesLog.info("MONClientesBean.obtenerDireccionesPorTipo(Long oidCliente, Long oidTipoDireccion): Salida"); 
        return dao.obtenerDireccionesPorTipo(oidCliente, oidTipoDireccion, idioma);
    }
    
    public DTOString validarDocumento(DTOColeccion dto)
        throws MareException
    {
        UtilidadesLog.info("MONClientesBean.validarDocumento(DTOColeccion dto): Entrada");
        DAOMAEMaestroClientes dAOMAEMaestroClientes = new DAOMAEMaestroClientes(sessionContext.getCallerPrincipal().getName());
        UtilidadesLog.debug("*** dto.getOidPais(): " + dto.getOidPais());
        Long oidClie = null;
        String CodClie = "";
        DTOSalida dtoS = dAOMAEMaestroClientes.recuperarDocumentos(dto.getOidPais(), dto);
        RecordSet rset = dtoS.getResultado();
        UtilidadesLog.info("*** dtoS.getResultado(): " + dtoS.getResultado());
        if(!rset.esVacio())
        {
            oidClie = rset.getValueAt(0, 0) == null ? null : new Long(((BigDecimal)rset.getValueAt(0, 0)).longValue());
            CodClie = rset.getValueAt(0, 1) == null ? null : (String)rset.getValueAt(0, 1);
        }
        UtilidadesLog.info("*** 2.-");
        DTOString dtoStr = new DTOString();
        String saldo = "";
        if(oidClie != null)
        {
            UtilidadesLog.debug("*** oid: " + oidClie);
            DTOSaldosPorFechasyVtos dtoCCC = new DTOSaldosPorFechasyVtos();
            dtoCCC.setOidCliente(oidClie);
            dtoCCC.setOidPais(dto.getOidPais());
            UtilidadesLog.debug("*** 1.-");
            MONInterfaceModulosHome mONInterfaceModulosHome = CCCEjbLocators.getMONInterfaceModulosHome();
            UtilidadesLog.debug("*** 2.-");
            try
            {
                UtilidadesLog.debug("*** 3.-");
                MONInterfaceModulos mONInterfaceModulos = mONInterfaceModulosHome.create();
                UtilidadesLog.debug("*** 4.-");
                DTOTotal dtoT = mONInterfaceModulos.consultarCuentasCastigadasCliente(dtoCCC);
                UtilidadesLog.debug("dtoT: " + dtoT);
                if(dtoT.getTotal() != null && dtoT.getTotal().doubleValue() > (double)0)
                {
                    saldo = dtoT.getTotal().toString();
                    UtilidadesLog.info("***Saldo = " + saldo);
                }
            }
            catch(CreateException createException)
            {
                sessionContext.setRollbackOnly();
                throw new MareException(createException, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS));
            }
            catch(RemoteException re)
            {
                throw new MareException(re, UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
            }
        }
        UtilidadesLog.info("MONClientesBean.validarDocumento(DTOColeccion dto): Salida");
        if(rset.esVacio())
        {
            dtoStr.setCadena("");
        } else {
            dtoStr.setCadena("|" + saldo+"|"+oidClie+"|"+CodClie);
        }
        return dtoStr;
    }


    private java.util.Date recuperaFecha(String sCadena, String sFormato) 
            throws Exception {
            
       /* 
        * String sCadena: Cadena que contiene una fecha
        * String sFormato: Cadena con el formato de la fecha
        * 
        * Retorna un objeto Date con la fecha luego de parsearla
        * con el formato de sFormato 
        */
            
       SimpleDateFormat simpleDate = new SimpleDateFormat(sFormato);
       java.util.Date fechaRetorno = simpleDate.parse(sCadena);
       
       return fechaRetorno;
   }    

  /**
   * Utilizando al DAOMAEMaestroClientes recupera la Unidad Administrativa del
   * cliente en el periodo indicado por parametro.
   * @author: Emilio Iraola
   * @date: 27/06/2006
   * @return: DTOUnidadAdministrativa
   * @param: Long oidCliente, Long oidPeriodo
   * @obs: Metodo creado a raiz de incidencia DBLG400001109
   */
  public DTOUnidadAdministrativa obtenerUAActiva(Long oidCliente, Long oidPeriodo) throws MareException {
      UtilidadesLog.info("MONClientesBean.obtenerUAActiva(Long oidCliente, Long oidPeriodo): Entrada"); 
      DAOMAEMaestroClientes dao = new DAOMAEMaestroClientes(sessionContext.getCallerPrincipal().getName());
      UtilidadesLog.info("MONClientesBean.obtenerUAActiva(Long oidCliente, Long oidPeriodo): Salida"); 
      return dao.obtenerUAActiva(oidCliente, oidPeriodo);
  }

  /**
   * Sistema: Belcorp
   * Módulo:  INC
   * Fecha:   26/07/2006
   * @version 1.00
   * @autor   Viviana Bongiovanni
   * Inc DBLG500000906
   */
  public DTOSalida obtenerZonaTerritorioUA(DTOBusquedaZonaTerritorioUA dto) throws MareException {
      UtilidadesLog.info("MONClientesBean.obtenerZonaTerritorioUA(DTOBusquedaZonaTerritorioUA dto):Entrada");
      
      DAOMAEMaestroClientes dao = new DAOMAEMaestroClientes(sessionContext.getCallerPrincipal().getName());
      
      RecordSet zonaTerritorioUA = dao.obtenerZonaTerritorioUA(dto);
      DTOSalida dtos = new DTOSalida();
      dtos.setResultado(zonaTerritorioUA);
      UtilidadesLog.info("MONClientesBean.obtenerZonaTerritorioUA(DTOBusquedaZonaTerritorioUA dto):Salida");

      return dtos;
  }

    public DTOBoolean validarRecomendanteEnHijaDupla(DTOCodigoCliente dto) throws MareException {
        DAOMAEConfiguracionClientes dao = new DAOMAEConfiguracionClientes(sessionContext.getCallerPrincipal().getName());
        return dao.validarRecomendanteEnHijaDupla(dto);
    }

    private void actualizarPedidosConNuevaDireccion(Long cliente, Long direccion, Long unidadGeografica) throws MareException {
        UtilidadesLog.info("MONClientesBean.actualizarPedidosConNuevaDireccion(Long cliente, Long direccion, Long unidadGeografica): Entrada"); 
        StringBuffer sb = new StringBuffer();
        
        sb.append(" UPDATE PED_SOLIC_CABEC  ");
        sb.append("    SET CLDI_OID_CLIE_DIRE = " + direccion + ",");
        sb.append("        VEPO_OID_VALO_ESTR_GEOP = " + unidadGeografica );
        sb.append("  WHERE CLIE_OID_CLIE = " + cliente);        
        sb.append("    AND FEC_FACT IS NULL ");
    
        try{
            BelcorpService.getInstance().dbService.executeUpdate(sb.toString());
        }catch(Exception e){
            UtilidadesLog.error("ERROR: "+sb.toString(),e);
            throw new MareException(e);
        }
        
        UtilidadesLog.info("MONClientesBean.actualizarPedidosConNuevaDireccion(Long cliente, Long direccion, Long unidadGeografica): Salida"); 
    }
    
    private void actualizarPedidosConNuevaUniAdm(Long cliente, Long marca, Long territorio, Long territorioAdm, Long zona) throws MareException {
        UtilidadesLog.info("MONClientesBean.actualizarPedidosConNuevaUniAdm(Long cliente, Long marca, Long territorio, Long territorioAdm, Long zona): Entrada");     
        StringBuffer sb = new StringBuffer();
        
        sb.append(" UPDATE PED_SOLIC_CABEC  ");
        sb.append("    SET TERR_OID_TERR = " + territorio + ",");
        sb.append("        ZTAD_OID_TERR_ADMI = " + territorioAdm + ",");
        sb.append("        ZZON_OID_ZONA = " + zona );
        sb.append("  WHERE OID_SOLI_CABE IN (SELECT PSC.OID_SOLI_CABE  ");        
        sb.append("                            FROM PED_SOLIC_CABEC PSC, CRA_PERIO PER ");                
        sb.append("                           WHERE PSC.CLIE_OID_CLIE = " + cliente );                
        sb.append("                             AND PSC.PERD_OID_PERI = PER.OID_PERI ");                
        sb.append("                             AND PSC.FEC_FACT IS NULL ");                
        sb.append("                             AND PER.MARC_OID_MARC = " + marca + ") ");                        
    
        try{
            BelcorpService.getInstance().dbService.executeUpdate(sb.toString());
        }catch(Exception e){
            UtilidadesLog.error("ERROR: "+sb.toString(),e);
            throw new MareException(e);
        }

        UtilidadesLog.info("MONClientesBean.actualizarPedidosConNuevaUniAdm(Long cliente, Long marca, Long territorio, Long territorioAdm, Long zona): Entrada");             
    }

    private MONReterritorializacionLocalHome getReterritorializacionLocalHome() throws MareException {
        UtilidadesLog.info("MONClientesBean.getReterritorializacionLocalHome(): Entrada");
        MONReterritorializacionLocalHome reterritorioLocalHome = (MONReterritorializacionLocalHome) UtilidadesEJB.getLocalHome("java:comp/env/MONReterritorializacion");
        UtilidadesLog.info("MONClientesBean.getReterritorializacionLocalHome(): Salida");
        return reterritorioLocalHome;
    }
 
  /**
   * 11-06-2007    agregado por Sapaza, incidencia Sicc20070266, se actualiza las unidades administrativas
   *               y se hace rollback del estatus del cliente, si es necesario,
   * @throws es.indra.mare.common.exception.MareException
   * @param oidTerritorioNuevo
   * @param oidTerritorioAnt
   * @param regionDestino
   * @param regionOrigen
   * @param canal
   * @param marca
   * @param pais
   * @param cliente
   */
    private void actualizarUnidadAdmCliente(Long cliente, Long pais, Long marca, Long canal, Long regionOrigen, 
                                            Long regionDestino, Long oidTerritorioAnt, Long oidTerritorioNuevo) throws MareException {
        UtilidadesLog.info("MONClientesBean.actualizarUnidadAdmCliente(): Entrada");    
        MONReterritorializacionLocal reterritorioLocal = null;
        ArrayList listCliente = new ArrayList();
        listCliente.add(cliente);
  
        try {
            reterritorioLocal = this.getReterritorializacionLocalHome().create();

        } catch (CreateException cex) {
            UtilidadesLog.error(cex);
            throw new MareException(cex, UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
        }

        UtilidadesLog.info("cliente :" + cliente);
        UtilidadesLog.info("oidTerritorioAnt :" + oidTerritorioAnt);
        UtilidadesLog.info("oidTerritorioNuevo :" + oidTerritorioNuevo);
        UtilidadesLog.info("this.regionOrigen :" + regionOrigen);
        UtilidadesLog.info("this.regionDestino :" + regionDestino);

        //llamamos para que actualicen las unidades administrativas y el estatus del cliente
        reterritorioLocal.actualizarClientesUnidadesAdminyStatus(listCliente, pais, marca, canal, null, 
                          null, regionOrigen, regionDestino, oidTerritorioAnt, oidTerritorioNuevo);        
                          
        UtilidadesLog.info("MONClientesBean.actualizarUnidadAdmCliente(): Salida");    
    }

    /**
     * Agregado por HRCS - Fecha 10/08/2007 - Cambio Sicc20070361
     * Metodo que se ejecuta inicialmente para recuperar todos los tipos de vinculos
     * @throws es.indra.mare.common.exception.MareException
     * @return DTOSalida
     * @param pais
     */
    public DTOSalida obtenerTodosTiposVinculo(es.indra.sicc.util.DTOOID dto) throws MareException {
        
        UtilidadesLog.debug("MONClientesBean.obtenerTodosTiposVinculo(Long pais): Entrada");
        RecordSet rs = null;
        StringBuffer query = new StringBuffer();
        query.append(" SELECT oid_tipo_vinc, cod_tipo_vinc || '|' || ind_reco ");
        query.append("   FROM mae_tipo_vincu ");
        query.append("  WHERE pais_oid_pais=" + dto.getOidPais() );

        try {
            rs = BelcorpService.getInstance().dbService.executeStaticQuery(query.toString());
        } catch (Exception exception) {
            UtilidadesLog.error(exception);
            throw new MareException(exception, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS));
        }
        DTOSalida dtos = new DTOSalida();
        dtos.setResultado(rs);

        if ((rs == null) || rs.esVacio()) {
            throw new MareException(new Exception(), UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE));
        }
        
        UtilidadesLog.debug("MONClientesBean.obtenerTodosTiposVinculo(Long pais): Salida");
        return dtos;
    }

    /**
     * Agregado por HRCS - Fecha 14/08/2007 - Cambio Sicc20070361
     * Metodo que valida la edad de Hija Dupla
     * @throws es.indra.mare.common.exception.MareException
     * @return DTOBoolean
     * @param dto DTOCodigoCliente
     */
    public DTOBoolean validarEdadHijaDupla(DTOCodigoCliente dto) throws MareException {
        DAOMAEConfiguracionClientes dao = new DAOMAEConfiguracionClientes(sessionContext.getCallerPrincipal().getName());
        return dao.validarEdadHijaDupla(dto);
    }
    
    /**
     * Agregado por HRCS - Fecha 15/08/2007 - Cambio Sicc20070361
     * Metodo que busca si existe un vinculo Dupla Cyzone activo
     * @throws es.indra.mare.common.exception.MareException
     * @return Oid del Cliente Vinculo
     * @param fecha
     * @param cliente
     */
    public Long buscarClienteVinculoDuplaCyzone(Long cliente, Date fecha ) throws MareException {
        Long oid = null;
        RecordSet rs = null;
        SimpleDateFormat formatter = new SimpleDateFormat ("dd/MM/yyyy");
        StringBuffer query = new StringBuffer();
        query.append(" SELECT oid_clie_vinc ");
        query.append(" FROM mae_clien_vincu ");
        query.append(" WHERE tivc_oid_tipo_vinc=(select oid_tipo_vinc from mae_tipo_vincu where cod_tipo_vinc='"+ConstantesMAE.COD_TIPO_VINCULO_DUPLACYZONE+"')");
        query.append(" AND clie_oid_clie_vnte = " + cliente);
        query.append(" AND fec_desd <= to_date('"+formatter.format(fecha)+"', 'dd/mm/yyyy') ");
        query.append(" AND fec_hast is null ");

        try {
            rs = BelcorpService.getInstance().dbService.executeStaticQuery(query.toString());
        } catch (Exception exception) {
            UtilidadesLog.error(exception);
            throw new MareException(exception, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS));
        }
        
        if (rs!=null && !rs.esVacio())  {
            oid = new Long( ((BigDecimal)rs.getValueAt(0,0)).longValue() );
            UtilidadesLog.debug("Oid MAE_CLIEN_VINCU: "+oid );
        }
        return oid;
    }
    
    /**
     * Agregado por HRCS - Fecha 15/08/2007 - Cambio Sicc20070361
     * Actualiza la fecha hasta del vinculo dupla cyzone activo dado
     * @throws es.indra.mare.common.exception.MareException
     * @param oidClienteVinculo
     */
    public void actualizarFechaHastaClienteVinculo(Long oidClienteVinculo) throws MareException {

        StringBuffer sb = new StringBuffer();
        sb.append(" UPDATE mae_clien_vincu SET fec_hast=TRUNC(SYSDATE-1) WHERE oid_clie_vinc = " + oidClienteVinculo);
        try {
            BelcorpService.getInstance().dbService.executeUpdate(sb.toString());
        } catch(Exception e)    {
            UtilidadesLog.error("ERROR: "+sb.toString(),e);
            throw new MareException(e);
        }
    }
    
    /**
     * Agregado por HRCS - Fecha 15/08/2007 - Cambio Sicc20070361
     * Crea una clasificacion Dupla Cyzone para un cliente dado
     * @throws es.indra.mare.common.exception.MareException
     * @param periodo
     * @param cliente
     */
    public void crearClasificacionDuplaCyzone(Long cliente, Long periodo, Date fecha ) throws MareException {
        
        RecordSet rs = null;
        //  Obtiene el tipo y subtipo del cliente
        //
        StringBuffer query = new StringBuffer();
        query.append(" SELECT oid_clie_tipo_subt, ticl_oid_tipo_clie, sbti_oid_subt_clie ");
        query.append(" FROM mae_clien_tipo_subti ");
        query.append(" WHERE clie_oid_clie = " + cliente);
        query.append(" AND ticl_oid_tipo_clie = (select oid_tipo_clie ");
        query.append("     from mae_tipo_clien where cod_tipo_clie = '"+ConstantesMAE.TIPO_CLIENTE_CONSULTORA+"')");
        try {
            rs = BelcorpService.getInstance().dbService.executeStaticQuery(query.toString());
        } catch (Exception exception) {
            UtilidadesLog.error(exception);
            throw new MareException(exception, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS));
        }
        Long oidClienteTipoSubtipo = null;
        Long oidClienteTipo = null;
        Long oidClienteSubtipo = null;
        if (rs!=null && !rs.esVacio())  {
            oidClienteTipoSubtipo = new Long( ((BigDecimal)rs.getValueAt(0,0)).longValue() );
            oidClienteTipo = new Long( ((BigDecimal)rs.getValueAt(0,1)).longValue() );
            oidClienteSubtipo = new Long( ((BigDecimal)rs.getValueAt(0,2)).longValue() );
        }

        //  Obtiene el tipo de clasificacion de Dupla Cyzone
        //
        StringBuffer query2 = new StringBuffer();
        query2.append(" SELECT oid_tipo_clas ");
        query2.append(" FROM mae_tipo_clasi_clien ");
        query2.append(" WHERE cod_tipo_clas = '"+ ConstantesMAE.COD_TIPO_CLASIFICACION_DULPACYZONE +"' ");
        query2.append(" AND sbti_oid_subt_clie = " + oidClienteSubtipo); 
        try {
            rs = BelcorpService.getInstance().dbService.executeStaticQuery(query2.toString());
        } catch (Exception exception) {
            UtilidadesLog.error(exception);
            throw new MareException(exception, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS));
        }
        Long oidTipoClasiDuplaCyzone = null;
        if (rs!=null && !rs.esVacio())  {
            oidTipoClasiDuplaCyzone = new Long( ((BigDecimal)rs.getValueAt(0,0)).longValue() );
        }       
        
        //  Obtiene la clasificacion de Dupla Cyzone
        //
        StringBuffer query3 = new StringBuffer();
        query3.append(" SELECT oid_clas ");
        query3.append(" FROM mae_clasi ");
        query3.append(" WHERE cod_clas = '"+ ConstantesMAE.COD_CLASIFICACION_DULPACYZONE +"'");
        query3.append(" AND tccl_oid_tipo_clas=" + oidTipoClasiDuplaCyzone);
        try {
            rs = BelcorpService.getInstance().dbService.executeStaticQuery(query3.toString());
        } catch (Exception exception) {
            UtilidadesLog.error(exception);
            throw new MareException(exception, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS));
        }
        Long oidClasiDuplaCyzone = null;
        if (rs!=null && !rs.esVacio())  {
            oidClasiDuplaCyzone = new Long( ((BigDecimal)rs.getValueAt(0,0)).longValue() );
        }  

        //  Valida que no exista una clasificacion similar.
        //  Esto fue necesario porque la pantalla de modificar cliente, puede marcar en sesion
        //  el tipo de vinculo como eliminado y tambien como insertado.
        StringBuffer query4 = new StringBuffer();
        query4.append(" SELECT * ");
        query4.append(" FROM mae_clien_clasi ");
        query4.append(" WHERE ctsu_oid_clie_tipo_subt=" + oidClienteTipoSubtipo);
        query4.append(" AND tccl_oid_tipo_clasi=" + oidTipoClasiDuplaCyzone);
         try {
            rs = BelcorpService.getInstance().dbService.executeStaticQuery(query4.toString());
        } catch (Exception exception) {
            UtilidadesLog.error(exception);
            throw new MareException(exception, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS));
        }
        if (rs!=null && rs.esVacio())  {
            //  Agregar nueva clasificacion de DuplaCyzone
            //
            try {
                ClienteClasificacionLocalHome clienteClasiLH;
                ClienteClasificacionLocal clienteClasiL;
                clienteClasiLH = new ClienteClasificacionLocalHome();
                clienteClasiL = clienteClasiLH.create(oidClienteTipoSubtipo, 
                                                      oidClasiDuplaCyzone, 
                                                      periodo, 
                                                      oidTipoClasiDuplaCyzone, 
                                                      new Long(0),     // Indicador Principal en '0'
                                                      fecha );
                clienteClasiL.setFec_clas( new Timestamp(truncarFecha(fecha).getTime()) );  //  Agregado 07/09/2007
            } catch (PersistenceException pe) {
                UtilidadesLog.error(pe);
                sessionContext.setRollbackOnly();
                throw new MareException(pe, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS));
            }
        }
    }
    
    /**
     * Agregado por HRCS - Fecha 15/08/2007 - Cambio Sicc20070361
     * Envia un mensaje de bienvenida a DuplaCyzone dado un oid de cliente
     * @throws es.indra.mare.common.exception.MareException
     * @param pais
     * @param cliente
     */
    public void comunicarBienvenidaDuplaCyzone(Long cliente, Long pais, Long idioma) throws MareException {

        //  Verifica si tiene mensajes MAE02 y MAE03 en el buzon para el cliente
        //
        RecordSet rs = null;
        StringBuffer query2 = new StringBuffer();
        query2.append(" SELECT oid_buzo_mens ");
        query2.append(" FROM msg_buzon_mensa ");
        query2.append(" WHERE clie_oid_clie=" + cliente);
        query2.append(" AND mens_oid_mens in (select oid_mens from msg_mensa where cod_mens in (");
        query2.append("  '"+ConstantesMAE.COD_MENSAJE_RECHAZO_DUPLACYZONE+"',");
        query2.append("  '"+ConstantesMAE.COD_MENSAJE_BIENVENIDA_DUPLACYZONE+"') ) ");
        query2.append(" AND ind_acti="+ConstantesMAE.IND_CLIEN_ACTIVO);
        try {
            rs = BelcorpService.getInstance().dbService.executeStaticQuery(query2.toString());
        } catch (Exception exception) {
            UtilidadesLog.error(exception);
            throw new MareException(exception, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS));
        }
        Vector oidBuzon = new Vector();
        if (rs!=null && !rs.esVacio())  {
            for(int j=0;j<rs.getRowCount();j++)   {
                oidBuzon.add(new Long( ((BigDecimal)rs.getValueAt(j,0)).longValue() ));
            }
        }

        try {
            MONGestionMensajes monMSG = MSGEjbLocators.getMONGestionMensajesHome().create();
            for(int i=0;i<oidBuzon.size();i++)   {
                //  Eliminando mensaje del buzon si existe
                DTOBuzonMensajes dtoBuzonMsgEli = new DTOBuzonMensajes();
                dtoBuzonMsgEli.setOid( (Long)oidBuzon.get(i) );
                monMSG.eliminaDatosMensaje(dtoBuzonMsgEli);
            }
            //  Insertando mensaje en el buzon
            DTOBuzonMensajes dtoBuzonMsg = new DTOBuzonMensajes();
            dtoBuzonMsg.setCodigoMensaje(ConstantesMAE.COD_MENSAJE_BIENVENIDA_DUPLACYZONE);
            dtoBuzonMsg.setOidCliente(cliente);
            dtoBuzonMsg.setModuloOrigen(new Long(ConstantesSEG.MODULO_MAE));
            dtoBuzonMsg.setOidIdioma(idioma);
            dtoBuzonMsg.setOidPais(pais);
            monMSG.insertaDatosMensaje(dtoBuzonMsg);
            
        } catch (CreateException createException) {
            UtilidadesLog.error(createException);
            sessionContext.setRollbackOnly();
            throw new MareException(createException, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS));
        } catch (Exception ex) {
            UtilidadesLog.info("Exception ex: Salida");
            sessionContext.setRollbackOnly();
            throw new MareException(ex, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS));
        }
    }
    
    /**
     * Agregado por HRCS - Fecha 15/08/2007 - Cambio Sicc20070361
     * 
     * @throws es.indra.mare.common.exception.MareException
     * @throws javax.ejb.CreateException
     * @param fecha Fecha Actual
     * @param clienteVinculoLH
     * @param vinculo
     * @param cliente
     */
    private void crearClienteVinculo(Long cliente, DTOVinculo vinculo, ClienteVinculoLocalHome clienteVinculoLH, Date fecha) throws CreateException, MareException  {
        
        UtilidadesLog.debug("   - SAP601: clienteVinculoLH.create( "+ cliente + ", " + vinculo.getOidCliente() + ", " + vinculo.getTipo() + ", " + fecha + " ) ");

        ClienteVinculoLocal clienteVinculoL = clienteVinculoLH.create(vinculo.getOidCliente(), cliente, vinculo.getTipo(), fecha);

        clienteVinculoL.setInd_vinc_ppal(vinculo.getPrincipal().booleanValue() ? new Long(1) : new Long(0));

        if (vinculo.getFechaDesde() != null) {
            clienteVinculoL.setFec_desd(new Timestamp(truncarFecha(vinculo.getFechaDesde()).getTime()));
        }

        if (vinculo.getFechaHasta() != null) {
            clienteVinculoL.setFec_hast(new Timestamp(truncarFecha(vinculo.getFechaHasta()).getTime()));
        }
        else    {
            clienteVinculoL.setFec_hast(null);
        }
        
        clienteVinculoLH.merge(clienteVinculoL);
    }

    /**
     * Agregado por HRCS - Fecha 22/08/2007 - Cambio Sicc20070361
     * Recupera el tipo y subtipo de un cliente
     * @throws es.indra.mare.common.exception.MareException
     * @return 
     * @param dto
     */
    public DTOSalida recuperarTipoSubtipoCliente(DTOCodigoCliente dto) throws MareException {
        DAOMAEConfiguracionClientes dao = new DAOMAEConfiguracionClientes(sessionContext.getCallerPrincipal().getName());
        return dao.recuperarTipoSubtipoCliente(dto);
    }

    /**
     * Agregado por HRCS - Fecha 22/08/2007 - Cambio Sicc20070361
     * Envia un mensaje de Rechazo Duplaz Cyzone, validando que no tenga previamente mensajes
     * @throws es.indra.mare.common.exception.MareException
     * @return 
     * @param dto
     */
    public DTOBoolean enviarMensajeRechazoDupla(DTOCodigoCliente dto) throws MareException {
        
        UtilidadesLog.debug("MONClientesBean.enviarMensajeRechazoDupla(DTOCodigoCliente dto): Entrada");
        DTOBoolean dtoB = new DTOBoolean();
        dtoB.setValor(false);
        //  Obtiene el oid del cliente
        //
        RecordSet rs = null;
        StringBuffer query1 = new StringBuffer();
        query1.append(" SELECT oid_clie ");
        query1.append(" FROM mae_clien ");
        query1.append(" WHERE cod_clie='" + dto.getCodigoCliente()+"'");
        try {
            rs = BelcorpService.getInstance().dbService.executeStaticQuery(query1.toString());
        } catch (Exception exception) {
            UtilidadesLog.error(exception);
            throw new MareException(exception, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS));
        }
        Long oidCliente = null;
        if (rs==null || rs.esVacio())  {
            String error = CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE;
            throw new MareException("MONClientesBean.enviarMensajeRechazoDupla:No se encontro al cliente", UtilidadesError.armarCodigoError(error));
        }
        else    {
            oidCliente = new Long( ((BigDecimal)rs.getValueAt(0,0)).longValue() );
        
            //  Verifica si tiene mensajes MAE02 y MAE03 en el buzon para el cliente
            //
            StringBuffer query2 = new StringBuffer();
            query2.append(" SELECT oid_buzo_mens ");
            query2.append(" FROM msg_buzon_mensa ");
            query2.append(" WHERE clie_oid_clie=" + oidCliente);
            query2.append(" AND mens_oid_mens in (select oid_mens from msg_mensa where cod_mens in (");
            query2.append("  '"+ConstantesMAE.COD_MENSAJE_RECHAZO_DUPLACYZONE+"',");
            query2.append("  '"+ConstantesMAE.COD_MENSAJE_BIENVENIDA_DUPLACYZONE+"') ) ");
            query2.append(" AND ind_acti="+ConstantesMAE.IND_CLIEN_ACTIVO);
            try {
                rs = BelcorpService.getInstance().dbService.executeStaticQuery(query2.toString());
            } catch (Exception exception) {
                UtilidadesLog.error(exception);
                throw new MareException(exception, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS));
            }
            if (rs!=null && !rs.esVacio())  {
                UtilidadesLog.info("No se agrega mensaje de Rechazo al buzon porque ya existe uno igual o de Bienvenida.");
            }
            else    {
                try {        
                    MONGestionMensajes monMSG = MSGEjbLocators.getMONGestionMensajesHome().create();
                    //  Insertando mensaje en el buzon
                    DTOBuzonMensajes dtoBuzonMsg = new DTOBuzonMensajes();
                    dtoBuzonMsg.setCodigoMensaje(ConstantesMAE.COD_MENSAJE_RECHAZO_DUPLACYZONE);
                    dtoBuzonMsg.setOidCliente(oidCliente);
                    dtoBuzonMsg.setModuloOrigen(new Long(ConstantesSEG.MODULO_MAE));
                    dtoBuzonMsg.setOidIdioma(dto.getOidIdioma());
                    dtoBuzonMsg.setOidPais(dto.getOidPais());
                    monMSG.insertaDatosMensaje(dtoBuzonMsg);
                    dtoB.setValor(true);
                    
                } catch (CreateException createException) {
                    UtilidadesLog.error(createException);
                    sessionContext.setRollbackOnly();
                    throw new MareException(createException, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS));
                } catch (Exception ex) {
                    UtilidadesLog.info("Exception ex: Salida");
                    sessionContext.setRollbackOnly();
                    throw new MareException(ex, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS));
                }
            }
        }
        UtilidadesLog.debug("MONClientesBean.enviarMensajeRechazoDupla(DTOCodigoCliente dto): Salida");
        return dtoB;
    }
    
    /**
     * Agregado por HRCS - Fecha 20/08/2007 - Cambio Sicc20070361
     * Modificado por HRCS - Fecha 12/09/2007 - Cambio Sicc20070385
     * Valida si existe un vinculo asociado entre los clientes
     * @throws es.indra.mare.common.exception.MareException
     * @return 
     * @param tipo Tipo de Vinculo
     * @param vinculante Oid del Cliente Vinculante (madre)
     * @param vinculando Oid del Cliente Vinculando (Hija)
     * @param fechaNula Indicador si se busca por fecha nula o no nula
     */
    public boolean existeClienteVinculo(Long pais, Long vinculante, Long vinculando, Long tipo, Boolean fechaNula) throws MareException {
        RecordSet rs = null;
        StringBuffer query = new StringBuffer();
        query.append(" SELECT * ");
        query.append(" FROM mae_clien_vincu cv, mae_tipo_vincu tv ");
        query.append(" WHERE cv.tivc_oid_tipo_vinc = tv.oid_tipo_vinc ");
        query.append(" AND tv.pais_oid_pais=" + pais );
        query.append(" AND clie_oid_clie_vnte=" + vinculante );
        query.append(" AND clie_oid_clie_vndo=" + vinculando );
        query.append(" AND tivc_oid_tipo_vinc=" + tipo );
        if (fechaNula!=null)    {
            if (fechaNula.booleanValue())  {
                query.append(" AND fec_hast is null " );
            }
            else    {
                query.append(" AND fec_hast is not null " );
            }
        }
        
        try {
            rs = BelcorpService.getInstance().dbService.executeStaticQuery(query.toString());
        } catch (Exception exception) {
            UtilidadesLog.error(exception);
            throw new MareException(exception, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS));
        }
        
        if (rs!=null && !rs.esVacio())  {
            return true;
        }
        return false;
    }
    
    /**
     * Agregado por HRCS - Fecha 21/08/2007 - Cambio Sicc20070361
     * Obtiene el periodo actual en base a la fecha y considerando el cruce de periodos.
     * Para el cruce se ordena por oid_peri.
     * @return 
     * @param fecha
     * @param canal
     * @param marca
     * @param pais
     */
    public RecordSet obtenerPeriodoActualPorFecha(Long pais, Long marca, Long canal) throws MareException {

        SimpleDateFormat formatter = new SimpleDateFormat ("dd/MM/yyyy");
        Date fecha = new Date(System.currentTimeMillis());
        StringBuffer consulta = new StringBuffer();
        Vector parametros = new Vector();
        consulta.append(" SELECT   x.n, x.oid_peri, x.oid_cod_peri, x.cod_peri ");
        consulta.append(" FROM ( ");
        consulta.append("    SELECT ROWNUM AS n, p.oid_peri AS oid_peri, ");
        consulta.append("         fec_inic AS fec_inic, fec_fina AS fec_fina, ");
        consulta.append("         pais_oid_pais AS pais_oid_pais, ");
        consulta.append("         marc_oid_marc AS marc_oid_marc, ");
        consulta.append("         cana_oid_cana AS cana_oid_cana, ");
        consulta.append("         pc.oid_peri AS oid_cod_peri, ");
        consulta.append("         pc.cod_peri AS cod_peri ");
        consulta.append("     FROM cra_perio p, seg_perio_corpo pc ");
        consulta.append("    WHERE p.peri_oid_peri = pc.oid_peri ");
        consulta.append("      AND fec_inic <= TO_DATE ('"+formatter.format(fecha)+"', 'DD/MM/YYYY') ");
        consulta.append("      AND TO_DATE ('"+formatter.format(fecha)+"', 'DD/MM/YYYY') <= fec_fina ");
        consulta.append("      AND p.pais_oid_pais = ? ");
        parametros.add(pais);
        if (marca != null) {
            consulta.append("      AND p.marc_oid_marc = ? ");
            parametros.add(marca);
        }
        if (canal != null) {
            consulta.append("      AND p.cana_oid_cana = ? ");
            parametros.add(canal);
        }
        consulta.append("    ORDER BY oid_peri ASC) x ");
        consulta.append(" ORDER BY n ");
        
        BelcorpService bs = UtilidadesEJB.getBelcorpService();
        RecordSet rs = null;
        try {
          rs = bs.dbService.executePreparedQuery(consulta.toString(), parametros);
        } catch (Exception e) {
          UtilidadesLog.error(" obtenerPeriodoActualPorFecha: Exception", e);
          throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS));
        }
        return rs;
    }
    
    /**
     * Agregado por HRCS - Fecha 23/08/2007 - Cambio Sicc20070361
     * Valida si existe una consultora madre para la hija dupla como parametro. Si existe una consultora madre
     * se le actualiza su vinculo a cerrado (fecha hasta) y se borran los registros de clasificacion y buzon de
     * mensajes DuplaCyzone.
     * @throws es.indra.mare.common.exception.MareException
     * @param fecha
     * @param cliente Oid del Cliente Hija Dupla
     */
    public void actualizarAnteriorVinculanteDuplaCyzone(Long cliente, Date fecha ) throws MareException {

        UtilidadesLog.debug("MONClientesBean.actualizarAnteriorVinculanteDuplaCyzone(Long cliente, Date fecha): Entrada");
        RecordSet rs = null;
        SimpleDateFormat formatter = new SimpleDateFormat ("dd/MM/yyyy");
        StringBuffer query = new StringBuffer();
        query.append(" SELECT oid_clie_vinc, clie_oid_clie_vnte ");
        query.append(" FROM mae_clien_vincu ");
        query.append(" WHERE tivc_oid_tipo_vinc=(select oid_tipo_vinc from mae_tipo_vincu where cod_tipo_vinc='"+ConstantesMAE.COD_TIPO_VINCULO_DUPLACYZONE+"')");
        query.append(" AND clie_oid_clie_vndo = " + cliente);   //  Hija Dupla
        query.append(" AND fec_desd <= to_date('"+formatter.format(fecha)+"', 'dd/mm/yyyy') ");
        query.append(" AND fec_hast is null ");

        try {
            rs = BelcorpService.getInstance().dbService.executeStaticQuery(query.toString());
        } catch (Exception exception) {
            UtilidadesLog.error(exception);
            throw new MareException(exception, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS));
        }
        Long oidVinculo = null;
        Long oidClienteVnte = null;
        if (rs!=null && !rs.esVacio())  {
            oidVinculo = new Long( ((BigDecimal)rs.getValueAt(0,0)).longValue() );
            oidClienteVnte = new Long( ((BigDecimal)rs.getValueAt(0,1)).longValue() );
         
            StringBuffer sb = new StringBuffer();
            sb.append(" UPDATE mae_clien_vincu SET fec_hast=TRUNC(SYSDATE-1) WHERE oid_clie_vinc = " + oidVinculo);
            try {
                BelcorpService.getInstance().dbService.executeUpdate(sb.toString());
            } catch(Exception e)    {
                UtilidadesLog.error("ERROR: "+sb.toString(),e);
                throw new MareException(e);
            }
            
            //  Borrando la clasificacion de DuplaCyzone que tenia la consultora
            StringBuffer sb2 = new StringBuffer();
            sb2.append(" DELETE FROM mae_clien_clasi ");
            sb2.append(" WHERE tccl_oid_tipo_clasi=(SELECT oid_tipo_clas from mae_tipo_clasi_clien ");
            sb2.append("   WHERE sbti_oid_subt_clie=(SELECT oid_subt_clie from mae_subti_clien ");
            sb2.append("     WHERE ticl_oid_tipo_clie=(SELECT oid_tipo_clie from mae_tipo_clien where cod_tipo_clie='"+ConstantesMAE.TIPO_CLIENTE_CONSULTORA+"') ");
            sb2.append(" AND cod_subt_clie='"+ConstantesMAE.CODIGO_CONSULTORA_TIPO_NEGOCIO+"') ");
            sb2.append(" AND cod_tipo_clas='"+ConstantesMAE.COD_TIPO_CLASIFICACION_DULPACYZONE+"') ");
            sb2.append(" AND ctsu_oid_clie_tipo_subt=(select oid_clie_tipo_subt from mae_clien_tipo_subti where clie_oid_clie="+oidClienteVnte+")");
            try {
                BelcorpService.getInstance().dbService.executeUpdate(sb2.toString());
            } catch(Exception e)    {
                UtilidadesLog.error("ERROR: "+sb2.toString(),e);
                throw new MareException(e);
            }
            
            //  Borrando los mensajes de MAE02 - MAE03 para eliminarlos
            StringBuffer sb3 = new StringBuffer();
            sb3.append(" DELETE FROM msg_buzon_mensa ");
            sb3.append(" WHERE clie_oid_clie="+oidClienteVnte );
            sb3.append(" AND mens_oid_mens in (select oid_mens from msg_mensa where cod_mens in (");
            sb3.append("  '"+ConstantesMAE.COD_MENSAJE_RECHAZO_DUPLACYZONE+"',");
            sb3.append("  '"+ConstantesMAE.COD_MENSAJE_BIENVENIDA_DUPLACYZONE+"') ) ");
            sb3.append(" AND ind_acti="+ConstantesMAE.IND_CLIEN_ACTIVO);
  
            try {
                BelcorpService.getInstance().dbService.executeUpdate(sb3.toString());
            } catch(Exception e)    {
                UtilidadesLog.error("ERROR: "+sb3.toString(),e);
                throw new MareException(e);
            }
        }
        UtilidadesLog.debug("MONClientesBean.actualizarAnteriorVinculanteDuplaCyzone(Long cliente, Date fecha): Salida");
    }

    /**
     * 25-09-2007, agregado por Sapaza, para obtener el oid y nombreCompleto del Cliente, cambio CCC-003
     * @throws es.indra.mare.common.exception.MareException
     * @return 
     * @param dto
     */
    public DTOSalida busquedaRapidaNombreCompleto(DTOBusquedaRapidaCliente dto) throws MareException {
        UtilidadesLog.info("MONClientesBean.busquedaRapidaNombreCompleto(DTOBusquedaRapidaCliente): Entrada"); 
        String codigoError;

        DAOMAEMaestroClientes daoMae = new DAOMAEMaestroClientes(sessionContext.getCallerPrincipal().getName());
        DTOSalida sl = new DTOSalida();
        sl = daoMae.busquedaRapidaNombreCompleto(dto);
        UtilidadesLog.info("MONClientesBean.busquedaRapidaNombreCompleto(DTOBusquedaRapidaCliente): Salida"); 

        return sl;
    }

}