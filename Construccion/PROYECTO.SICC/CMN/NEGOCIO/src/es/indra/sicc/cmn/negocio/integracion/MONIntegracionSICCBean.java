package es.indra.sicc.cmn.negocio.integracion;

import es.indra.mare.common.dto.MareDTO;
import es.indra.mare.common.exception.MareException;
import es.indra.mare.common.mii.services.jdbcservice.RecordSet;
import es.indra.mare.common.mln.MareBusinessID;
import es.indra.mare.enterprise.mln.BusinessFacade;
import es.indra.mare.enterprise.mln.BusinessFacadeHome;
import es.indra.sicc.cmn.negocio.batch.DTOBatch;
import es.indra.sicc.cmn.negocio.batch.MONBatch;
import es.indra.sicc.cmn.negocio.batch.Proceso;
import es.indra.sicc.cmn.negocio.batch.util.BatchUtil;
import es.indra.sicc.cmn.negocio.batch.util.ConfigFactory;
import es.indra.sicc.cmn.negocio.interfaces.IGestorInterfaces;
import es.indra.sicc.cmn.negocio.interfaces.daemon.util.Util;
import es.indra.sicc.dtos.cra.ConstantesCRA;
import es.indra.sicc.dtos.fac.DTOFACCierreFacturacion;
import es.indra.sicc.dtos.inc.DTOReemplazoArticuloLote;
import es.indra.sicc.dtos.intsys.DTOCargaInicialInterfaz;
import es.indra.sicc.dtos.intsys.DTOINT;
import es.indra.sicc.dtos.intsys.DTOINTCargaInicialLarissa;
import es.indra.sicc.dtos.ped.DTOArranqueGP;
import es.indra.sicc.dtos.ped.DTOBuscarDatosMonitor;
import es.indra.sicc.dtos.ped.DTODatosMonitor;
import es.indra.sicc.dtos.ped.DTOInfoMonitor;
import es.indra.sicc.dtos.ped.DTOParametroMonitor;
import es.indra.sicc.dtos.ped.DTOSecuenciaSolicitudes;
import es.indra.sicc.dtos.ped.DTOSolicitudValidacion;
import es.indra.sicc.entidades.cra.PeriodoLocal;
import es.indra.sicc.entidades.cra.PeriodoLocalHome;
import es.indra.sicc.entidades.fac.TiposCierreLocal;
import es.indra.sicc.entidades.fac.TiposCierreLocalHome;
import es.indra.sicc.entidades.seg.PeriodoCorporativoLocal;
import es.indra.sicc.entidades.seg.PeriodoCorporativoLocalHome;
import es.indra.sicc.entidades.seg.TipoPeriodoCorporativoLocal;
import es.indra.sicc.entidades.seg.TipoPeriodoCorporativoLocalHome;
import es.indra.sicc.logicanegocio.fac.ConstantesFAC;
import es.indra.sicc.logicanegocio.fac.DAOFACCierreFacturacion;
import es.indra.sicc.logicanegocio.fac.ErroresDeNegocio;
import es.indra.sicc.logicanegocio.intsys.MONINT;
import es.indra.sicc.logicanegocio.intsys.MONINTHome;
import es.indra.sicc.logicanegocio.mae.DAOMAEEstatusCliente;
import es.indra.sicc.logicanegocio.ped.ConstantesPED;
import es.indra.sicc.logicanegocio.ped.DAOSolicitud;
import es.indra.sicc.logicanegocio.ped.MONMonitor;
import es.indra.sicc.logicanegocio.ped.MONMonitorHome;
import es.indra.sicc.logicanegocio.ped.MONSecuenciaProcesosLocal;
import es.indra.sicc.logicanegocio.ped.MONSecuenciaProcesosLocalHome;
import es.indra.sicc.logicanegocio.seg.ConstantesSEG;
import es.indra.sicc.util.CodigosError;
import es.indra.sicc.util.DTOOIDs;
import es.indra.sicc.util.DTOString;
import es.indra.sicc.util.UtilidadesEJB;
import es.indra.sicc.util.UtilidadesError;
import es.indra.sicc.util.UtilidadesLog;

import java.rmi.RemoteException;

import java.text.SimpleDateFormat;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.Iterator;

import javax.ejb.CreateException;
import javax.ejb.EJBException;
import javax.ejb.SessionBean;
import javax.ejb.SessionContext;

import javax.naming.InitialContext;
import javax.naming.NamingException;

import javax.persistence.NoResultException;
import javax.persistence.PersistenceException;

import javax.rmi.PortableRemoteObject;


public class MONIntegracionSICCBean implements SessionBean {
    private SessionContext ctx;

    public void ejbCreate() {
    }

    public void setSessionContext(SessionContext context) throws EJBException {
        ctx = context;
    }

    public void ejbRemove() throws EJBException {
    }

    public void ejbActivate() throws EJBException {
    }

    public void ejbPassivate() throws EJBException {
    }

    private MONSecuenciaProcesosLocalHome getMONSecuenciaProcesosLocalHome() throws NamingException {
      final InitialContext context = new InitialContext();
      return (MONSecuenciaProcesosLocalHome)context.lookup("java:comp/env/ejb/local/MONSecuenciaProcesos");
    }

    private MONMonitorHome getMONMonitorHome() throws NamingException {
        final InitialContext context = new InitialContext();

        return (MONMonitorHome)PortableRemoteObject.narrow(context.lookup("MONMonitor"), MONMonitorHome.class);
    }
    
    private MONMonitor getMONMonitor() throws MareException {
        UtilidadesLog.info("MONIntegracionSICCBean.getMONMonitorHome(): Entrada");
        MONMonitorHome home = (MONMonitorHome)UtilidadesEJB.getHome("MONMonitor", MONMonitorHome.class);
        MONMonitor ejb = null;
        try {
            ejb = home.create();
        } catch (Exception e) {
            UtilidadesLog.error(e);
            String codigoError = CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB;
            throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));
        } 
        UtilidadesLog.info("MONIntegracionSICCBean.getMONMonitorHome(): Salida");
        return ejb;
    }    
    
    private BusinessFacade getBusinessFacade() throws MareException {
      BusinessFacade businessFacade = null;
            
      try {
            InitialContext context = new InitialContext();
            BusinessFacadeHome mlnHome = (BusinessFacadeHome)context.lookup( "mare.mln.BusinessFacade" );
            businessFacade = mlnHome.create();

        } catch (Exception e) {
            Util.getLog().error("ERROR",e);
            throw new MareException( "Error localizando la BusinessFacade remota", e );
        }
            
        return businessFacade;
    }
    
    public DTOSalidaSICC ejecutarProceso(DTOEntradaSICC dto) throws MareException {
        UtilidadesLog.info("MONIntegracionSICCBean.ejecutarProceso(DTOEntradaSICC dto): Entrada");
        DTOSalidaSICC dtoSalida = new DTOSalidaSICC();
        String procesoNegocio = dto.getProcesoNegocio();
        
        //Seteamos valores oids de Pais, Idioma y Periodo
        DAOIntegracionSICC daoIntegracion = new DAOIntegracionSICC();
        daoIntegracion.obtenerOidsBasicos(dto);
        
        if(procesoNegocio.equals(ConstantesIntegracion.PROCESO_PEDIDO_GP2)) {
            pasarPedidoGP2(dto);
        }
        if(procesoNegocio.equals(ConstantesIntegracion.PROCESO_MONITOR_GP2)) {
            dtoSalida = pasarPedidoMonitorGP2(dto);
        }
        if(procesoNegocio.equals(ConstantesIntegracion.PROCESO_INTERFAZ_SAM6)) {
            dtoSalida = ejecutarInterfazSAM6(dto);
        }
        if(procesoNegocio.equals(ConstantesIntegracion.PROCESO_CIERRE_ZONA)) {
            dtoSalida = ejecutarProcesoCierre(dto, ConstantesFAC.TIPO_CIERRE_ZONA);
        }
        if(procesoNegocio.equals(ConstantesIntegracion.PROCESO_CIERRE_REGION)) {
            dtoSalida = ejecutarProcesoCierre(dto, ConstantesFAC.TIPO_CIERRE_REGION);
        }
        if(procesoNegocio.equals(ConstantesIntegracion.PROCESO_CIERRE_PERIODO)) {
            dtoSalida = ejecutarProcesoCierre(dto, ConstantesFAC.TIPO_CIERRE_PERIODO);
        }
        if(procesoNegocio.equals(ConstantesIntegracion.PROCESO_REEMPLAZOS_INCENTIVOS)) {
            dtoSalida = ejecutarReemplazoIncentivos(dto);
        }
        if(procesoNegocio.equals(ConstantesIntegracion.PROCESO_MONITOR_GP4)) {
            dtoSalida = pasarPedidoMonitorGP4(dto);
        }
        if(procesoNegocio.equals(ConstantesIntegracion.PROCESO_REEVALUAR_ESTATUS)) {
            dtoSalida = ejecutarReevaluarEstatus(dto);
        }
        if(procesoNegocio.equals(ConstantesIntegracion.PROCESO_REVERTIR_SOLICITUDES)) {
            dtoSalida = ejecutarRevertirSolicitudes(dto);
        }
        if(procesoNegocio.equals(ConstantesIntegracion.PROCESO_INTERFAZ_LARISSA)) {
            dtoSalida = ejecutarInterfazLarissa(dto);
        }
        if(procesoNegocio.equals(ConstantesIntegracion.PROCESO_INTERFAZ_RECEPCIONAR_ECM)) {
            dtoSalida = ejecutarInterfazRecepcionarECM(dto);
        }
        if(procesoNegocio.equals(ConstantesIntegracion.PROCESO_ACTIVAR_CONCURSOS)) {
            dtoSalida = ejecutarActivarConcursos(dto);
        }
        if(procesoNegocio.equals(ConstantesIntegracion.PROCESO_CERRAR_CONCURSOS)) {
            dtoSalida = ejecutarCerrarConcursos(dto);
        }
        
        UtilidadesLog.info("MONIntegracionSICCBean.ejecutarProceso(DTOEntradaSICC dto): Salida");
        return dtoSalida;
    }
    
    private void pasarPedidoGP2(DTOEntradaSICC dtoe) throws MareException {
        UtilidadesLog.info("MONIntegracionSICCBean.pasarPedidoGP2(DTOEntradaSICC dtoe): Entrada");
        DAOSolicitud daoSol = new DAOSolicitud();
        
        try {
            ArrayList solicitud = (ArrayList)dtoe.getParametros().get("solicitudes");
            
            // sapaza -- PER-SiCC-2012-0805 -- 11/09/2012
            ArrayList listaSolicitudes = daoSol.crearDTOSolicitudValidacion(solicitud, dtoe.getOidPais());
            
            //Para ejecutar en modo online el Pedido, en especial la OC y lo deje en GP3
            for(int i=0; i<listaSolicitudes.size(); i++) {
                DTOSolicitudValidacion dto = (DTOSolicitudValidacion)listaSolicitudes.get(i);
                dto.setIndEjecOnLine(true);
            }

            DTOParametroMonitor dtoParametros = new DTOParametroMonitor();
            dtoParametros.setOidGrupoProceso( ConstantesPED.GP2 );
            dtoParametros.setModoFacturacion( "R" );
            dtoParametros.setFechaFacturacion(convertirFechaaDate(dtoe.getFechaProceso(), dtoe.getFormatoFecha()));
            dtoParametros.setIndOrdenesCompra(Boolean.TRUE);
            dtoParametros.setOidPais(dtoe.getOidPais()); 
            dtoParametros.setCodigoUsuario(dtoe.getCodigoUsuario());
            /*if (cajaL != null)
                dtoParametros.setCodCaja(cajaL.getCodigoCaja()); */

            DTOArranqueGP dtoArranque = new DTOArranqueGP();
            dtoArranque.setListaSolicitudes(listaSolicitudes);
            dtoArranque.setParametros(dtoParametros);
        
            MONSecuenciaProcesosLocalHome mSecuenciaPLocalHome = (MONSecuenciaProcesosLocalHome)this.getMONSecuenciaProcesosLocalHome();
            MONSecuenciaProcesosLocal mSecuenciaLocalP = mSecuenciaPLocalHome.create();                         
            MareDTO salida = mSecuenciaLocalP.ejecutar(dtoArranque);
        } catch(CreateException ce) {
            ce.printStackTrace();
            ctx.setRollbackOnly();
            throw new MareException(ce, UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
        } catch (MareException ma) {
            ctx.setRollbackOnly();
            throw ma;
        } catch(NamingException fe) {
            ctx.setRollbackOnly();
            throw new MareException(fe, UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));          
        } catch (Exception e) {
            e.printStackTrace();
            ctx.setRollbackOnly();
            throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS));      
        }
        
        UtilidadesLog.info("MONIntegracionSICCBean.pasarPedidoGP2(DTOEntradaSICC dtoe): Salida");
    }

    private DTOSalidaSICC pasarPedidoMonitorGP2(DTOEntradaSICC dtoe) throws MareException {
        UtilidadesLog.info("MONIntegracionSICCBean.pasarPedidoMonitorGP2(DTOEntradaSICC dtoe): Entrada");
        DAOIntegracionSICC daoIntegracion = new DAOIntegracionSICC();
        DTOSalidaSICC dtoSalida = new DTOSalidaSICC();
        
        UtilidadesLog.info("DTO recibido de SSICC: ");
        UtilidadesLog.info(dtoe.toString());
        
        try {
            //1) Realizamos la Busqueda de las zonas a procesar, como si estuvieramos en el monitor
            UtilidadesLog.info("1.-- INVOCAMOS A LA BUSQUEDA DE MONITOR");
            DTOBuscarDatosMonitor dtoBDM = new DTOBuscarDatosMonitor();
            dtoBDM.setOidIdioma(dtoe.getOidIdioma());
            dtoBDM.setOidPais(dtoe.getOidPais());
            dtoBDM.setFechaInicio(convertirFechaaDate(dtoe.getFechaProceso(), dtoe.getFormatoFecha()));
            dtoBDM.setFechaFin(dtoBDM.getFechaInicio());
        
            ArrayList listaTiposSolicitudes = new ArrayList();
            if(dtoe.getParametros().get("listaTiposSolicitudes") != null)
                listaTiposSolicitudes = (ArrayList)dtoe.getParametros().get("listaTiposSolicitudes");
            else
                listaTiposSolicitudes = daoIntegracion.obtenerOidsTiposSolicitudesOC();
            
            dtoBDM.setOidTipoSolicitudPais(listaTiposSolicitudes);
            dtoBDM.setOidPeriodo(dtoe.getOidPeriodo());
        
            MONMonitorHome home = getMONMonitorHome();
            MONMonitor monMonitor = home.create();                         
            DTODatosMonitor dtoMonitor = new DTODatosMonitor();
            
            try {
                dtoMonitor = monMonitor.obtenerDatosMejorado(dtoBDM);
            } catch(Exception ex) {
                throw new MareException("ERROR, NO SE ENCONTRARON SOLICITUDES DE PEDIDO O/C PARA PASAR A GP2");
            }
        
            //2) Creamos la lista de zonas y secuencias a enviar
            UtilidadesLog.info("2.-- CREAMOS LA LISTA DE ZONAS Y SECUENCIAS A ENVIAR");
            RecordSet resultado =  dtoMonitor.getProcesos();
            ArrayList listaSecuencias = new ArrayList();
            Long secuencia = new Long(0);
            for(int i=0; i<resultado.getRowCount(); i++) {
                String tieneText = (String)resultado.getValueAt(i, 0);
                
                if(tieneText.equalsIgnoreCase("1")) {               
                    Long oidTipoSolicitud = new Long(resultado.getValueAt(i, 14).toString());
                    Long oidZona = new Long(resultado.getValueAt(i, 16).toString()); 
                    
                    Long totalPedidos = new Long(resultado.getValueAt(i, 4).toString());  
                    if(totalPedidos.longValue() > 0) {
                        secuencia = secuencia + 1;
                        
                        DTOSecuenciaSolicitudes dtoSecuencia = new DTOSecuenciaSolicitudes();
                        dtoSecuencia.setOidPais(dtoe.getOidPais());
                        dtoSecuencia.setOidIdioma(dtoe.getOidIdioma());
                        dtoSecuencia.setOidTipoSolicitud(oidTipoSolicitud);
                        dtoSecuencia.setOidZona(oidZona);
                        dtoSecuencia.setSecuencia(secuencia);
                        listaSecuencias.add(dtoSecuencia);
                    }    
                }    
            }
            
            if(listaSecuencias.size()==0) {
                throw new MareException("ERROR, NO SE ENCONTRARON SOLICITUDES DE PEDIDO O/C PARA PASAR A GP2");
            }

            //3) Invocamos al proceso Batch de GP2            
            UtilidadesLog.info("3.-- INVOCAMOS AL PROCESO BATCH DE GP2");
            DTOInfoMonitor dtoIM = new DTOInfoMonitor();
            dtoIM.setOidPais(dtoe.getOidPais());
            dtoIM.setOidIdioma(dtoe.getOidIdioma());
            dtoIM.setOidPeriodo(dtoe.getOidPeriodo());
            dtoIM.setFechaInicio(new java.sql.Date(convertirFechaaDate(dtoe.getFechaProceso(), dtoe.getFormatoFecha()).getTime()));
            dtoIM.setFechaFin(dtoIM.getFechaInicio());
            dtoIM.setSecuencia(listaSecuencias);
            dtoIM.setGP(ConstantesPED.GP1);
            dtoIM.setCodigoUsuario(dtoe.getCodigoUsuario());
            
            String codigoBatch = monMonitor.procesarSolicitudesIntegracionSSICC(dtoIM);
            
            //4) Obtenemos el Id de Proceso Batch
            dtoSalida.setIdProcesoBatch(codigoBatch);
            UtilidadesLog.info("4.-- OBTENEMOS EL ID DE PROCESO BATCH de GP2: " + dtoSalida.getIdProcesoBatch());
            
        } catch(CreateException ce) {
            ce.printStackTrace();
            ctx.setRollbackOnly();
            throw new MareException(ce, UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
        } catch (MareException ma) {
            ctx.setRollbackOnly();
            throw ma;
        } catch(NamingException fe) {
            ctx.setRollbackOnly();
            throw new MareException(fe, UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));          
        } catch(RemoteException re) {
            ctx.setRollbackOnly();
            throw new MareException(re, UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));                      
        } catch (Exception e) {
            e.printStackTrace();
            ctx.setRollbackOnly();
            throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS));      
        }
        
        UtilidadesLog.info("DTO enviado a SSICC: ");
        UtilidadesLog.info(dtoSalida.toString());
        
        UtilidadesLog.info("MONIntegracionSICCBean.pasarPedidoMonitorGP2(DTOEntradaSICC dtoe): Salida");
        return dtoSalida;
    }

    private DTOSalidaSICC ejecutarInterfazSAM6(DTOEntradaSICC dtoe) throws MareException {
        UtilidadesLog.info("MONIntegracionSICCBean.ejecutarInterfazSAM6(DTOEntradaSICC dtoe): Entrada");
        DAOIntegracionSICC daoIntegracion = new DAOIntegracionSICC();
        DTOSalidaSICC dtoSalida = new DTOSalidaSICC();
        
        UtilidadesLog.info("DTO recibido de SSICC: ");
        UtilidadesLog.info(dtoe.toString());
        
        try {
            DTOString dto = new DTOString();
            dto.setCadena( dtoe.getCodigoPais() );
            
            DTOBatch dtoBatch = new DTOBatch( "[INT]_notifyFile", 
                                                new MareBusinessID( "INTRecepcionarStocksDiarios" ),
                                                dto );
                                                
            //Obtenemos el codigo Batch de la Ejecucion de la Interfaz                                                
            String codigoBatch = dtoBatch.getProcessID();
        
            BusinessFacade bf = getBusinessFacade();
            bf.execute( dtoBatch, new MareBusinessID("INTProcesoInterfaces"));
            
            //Obtenemos el Id de Proceso Batch
            dtoSalida.setIdProcesoBatch(codigoBatch);
            UtilidadesLog.info("OBTENEMOS EL ID DE PROCESO BATCH de SAM6: " + dtoSalida.getIdProcesoBatch());
                        
        } catch (MareException ma) {
            ctx.setRollbackOnly();
            throw ma;
        } catch(RemoteException re) {
            ctx.setRollbackOnly();
            throw new MareException(re, UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));                      
        } catch (Exception e) {
            e.printStackTrace();
            ctx.setRollbackOnly();
            throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS));      
        }
        
        UtilidadesLog.info("DTO enviado a SSICC: ");
        UtilidadesLog.info(dtoSalida.toString());
        
        UtilidadesLog.info("MONIntegracionSICCBean.ejecutarInterfazSAM6(DTOEntradaSICC dtoe): Salida");
        return dtoSalida;
    }

    private DTOSalidaSICC ejecutarProcesoCierre(DTOEntradaSICC dtoe, String tipoCierre) throws MareException {
        UtilidadesLog.info("MONIntegracionSICCBean.ejecutarProcesoCierre(DTOEntradaSICC dtoe): Entrada");
        DAOIntegracionSICC daoIntegracion = new DAOIntegracionSICC();
        DAOFACCierreFacturacion daoCierre = new DAOFACCierreFacturacion();
        DTOSalidaSICC dtoSalida = new DTOSalidaSICC();
        
        UtilidadesLog.info("Tipo Cierre: " + tipoCierre);
        UtilidadesLog.info("DTO recibido de SSICC: ");
        UtilidadesLog.info(dtoe.toString());
        
        try {
            DTOFACCierreFacturacion dtoCierreFac = new DTOFACCierreFacturacion();
            dtoCierreFac.setOidPais(dtoe.getOidPais());
            dtoCierreFac.setOidIdioma(dtoe.getOidIdioma());
            dtoCierreFac.setCodigoUsuario(dtoe.getCodigoUsuario());
            
            // - marca:
            dtoCierreFac.setMarca(daoIntegracion.obtenerOidMarca(dtoe.getCodigoMarca()));
            
            // - canal:
            dtoCierreFac.setCanal(daoIntegracion.obtenerOidCanal(dtoe.getCodigoCanal()));
            
            // - periodo
            dtoCierreFac.setPeriodo(dtoe.getOidPeriodo());
            
            // - fecha
            dtoCierreFac.setFecha(convertirFechaaDate(dtoe.getFechaProceso(), dtoe.getFormatoFecha()));

            //Tipo Cierre Zona o Region
            dtoCierreFac.setCodigoTipoCierre(tipoCierre);
            dtoCierreFac.setTipoCierre(daoIntegracion.obtenerOidTipoCierre(dtoCierreFac.getCodigoTipoCierre())); 

            if (dtoCierreFac.getCodigoTipoCierre().equals(ConstantesFAC.TIPO_CIERRE_REGION)) {
                //listaZonas
                Long[] listaRegiones = (Long[])dtoe.getParametros().get("listaRegiones");
                DTOOIDs dtoOids = new DTOOIDs();
                dtoOids.setOids(listaRegiones);
                dtoCierreFac.setRegiones(dtoOids);
                
            } else if (dtoCierreFac.getCodigoTipoCierre().equals(ConstantesFAC.TIPO_CIERRE_ZONA)){
                //listaZonas
                Long[] listaZonas = (Long[])dtoe.getParametros().get("listaZonas");
                DTOOIDs dtoOids = new DTOOIDs();
                dtoOids.setOids(listaZonas);
                dtoCierreFac.setZonas(dtoOids);
                
            }                       
        
            //Se valida si ya se cerra alguno de las zonas o regiones a procesar
            Integer ctrlCierres = daoCierre.obtenerNumeroControlCierres(dtoCierreFac);
            UtilidadesLog.debug("ctrlCierres: "+ctrlCierres.intValue());
            if(ctrlCierres.intValue()>0){
                UtilidadesLog.debug("SE INTENTA CERRAR ALGO YA CERRADO");
                String mensaje = null;
                
                if (dtoCierreFac.getCodigoTipoCierre().equals(ConstantesFAC.TIPO_CIERRE_PERIODO)) {
                     UtilidadesLog.debug("Cierre Periodo ya existente");                    
                     mensaje = ErroresDeNegocio.FAC_0001;
                } else if (dtoCierreFac.getCodigoTipoCierre().equals(ConstantesFAC.TIPO_CIERRE_REGION)) {
                    UtilidadesLog.debug("Cierre Region ya existente");                        
                    mensaje = ErroresDeNegocio.FAC_0002;
                } else if (dtoCierreFac.getCodigoTipoCierre().equals(ConstantesFAC.TIPO_CIERRE_ZONA)){
                   UtilidadesLog.debug("Cierre Zona ya existente");                    
                   mensaje = ErroresDeNegocio.FAC_0003;
                }
                
                UtilidadesLog.error("Mensaje: "+mensaje);
                MareException me = new MareException(new Exception(), UtilidadesError.armarCodigoError(ConstantesSEG.MODULO_FAC, "", mensaje));
                UtilidadesLog.error("ERROR",me);
                throw me;           
            }
            
            DTOBatch dtoBatch = new DTOBatch("CIERREFAC",new MareBusinessID("FACCerrarFacturacionBatch"), dtoCierreFac);
            
            //Ejecutamos el proceso de Cierre de Zonas
            BatchUtil.executeMLN( dtoBatch, new MareBusinessID( "FACProcesosGP5" ));
            
            //Obtenemos el codigo Batch de la Ejecucion de la Interfaz                                                
            String codigoBatch = dtoBatch.getProcessID();
            
            //Obtenemos el Id de Proceso Batch
            dtoSalida.setIdProcesoBatch(codigoBatch);
            UtilidadesLog.info("OBTENEMOS EL ID DE PROCESO BATCH de PROCESO_CIERRE : " + dtoSalida.getIdProcesoBatch());
                        
        } catch (MareException ma) {
            ctx.setRollbackOnly();
            throw ma;
        } catch (Exception e) {
            e.printStackTrace();
            ctx.setRollbackOnly();
            throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS));      
        }
        
        UtilidadesLog.info("DTO enviado a SSICC: ");
        UtilidadesLog.info(dtoSalida.toString());
        
        UtilidadesLog.info("MONIntegracionSICCBean.ejecutarProcesoCierre(DTOEntradaSICC dtoe): Salida");
        return dtoSalida;
    }
    
    private void esperarProcesamiento(String idBatch) throws MareException {
        UtilidadesLog.info("MONIntegracionSICCBean.esperarProcesamiento(): Entrada");
        
        if(!idBatch.equals("")) {
            MONBatch mb = new MONBatch();
            boolean termino = false;
            
            while (!termino) {
                Proceso proc = mb.getProcesoBatch(idBatch);
                
                if(proc.getFechaFin() != null) 
                    termino = true;
                else {
                    try {
                        Thread.sleep (ConfigFactory.getBatchConfig().getWaitPoollingTime()*2);
                    }
                    catch (InterruptedException ie) {
                        UtilidadesLog.info("MONIntegracionSICCBean.esperarProcesamiento(): Salida ");
                        throw new MareException ("Error ejecutando Esperar Procesamiento", ie);
                    }
                }                
            }
        }
        
        UtilidadesLog.info("MONIntegracionSICCBean.esperarProcesamiento(): Salida");
    }
    
    private Date convertirFechaaDate(String fecha, String formato) {
        SimpleDateFormat sdf = new SimpleDateFormat(formato);
        Date dFecha = null;
        
        try {
          dFecha = sdf.parse(fecha);
        } catch(Exception ex)  {}
        
        return dFecha;
    }

    // sapaza -- PER-SiCC-2013-1227 -- 11/12/2013
    private DTOSalidaSICC ejecutarReemplazoIncentivos(DTOEntradaSICC dtoe) throws MareException {
        UtilidadesLog.info("MONIntegracionSICCBean.ejecutarReemplazoIncentivos(DTOEntradaSICC dtoe): Entrada");
        DAOIntegracionSICC daoIntegracion = new DAOIntegracionSICC();
        DTOSalidaSICC dtoSalida = new DTOSalidaSICC();
        
        UtilidadesLog.info("DTO recibido de SSICC: ");
        UtilidadesLog.info(dtoe.toString());
        
        try {
            //Recuperamos el oid Concurso
            Long oidConcurso = (Long)dtoe.getParametros().get("oidConcurso");
            
            //Creamos el DTO con los datos necesarios para el proceso de reemplazos
            DTOReemplazoArticuloLote dto = new DTOReemplazoArticuloLote();
            dto.setOidConcurso(oidConcurso);
            dto.setValUsua(dtoe.getCodigoUsuario());
            dto.setOidPais(dtoe.getOidPais());
            
            DTOBatch dtoBatch = new DTOBatch( "generarNuevaSolicitudReemplazo", 
                                                new MareBusinessID( "INCGenerarNuevaSolicitud" ),
                                                dto );
                                                
            //Obtenemos el codigo Batch de la Ejecucion de la Interfaz                                                
            String codigoBatch = dtoBatch.getProcessID();
        
            BusinessFacade bf = getBusinessFacade();
            bf.execute( dtoBatch, new MareBusinessID("ZONReterritorializacion"));
            
            //Obtenemos el Id de Proceso Batch
            dtoSalida.setIdProcesoBatch(codigoBatch);
            UtilidadesLog.info("OBTENEMOS EL ID DE PROCESO REEMPLAZO INCENTIVOS: " + dtoSalida.getIdProcesoBatch());
                        
        } catch (MareException ma) {
            ctx.setRollbackOnly();
            throw ma;
        } catch(RemoteException re) {
            ctx.setRollbackOnly();
            throw new MareException(re, UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));                      
        } catch (Exception e) {
            e.printStackTrace();
            ctx.setRollbackOnly();
            throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS));      
        }
        
        UtilidadesLog.info("DTO enviado a SSICC: ");
        UtilidadesLog.info(dtoSalida.toString());
        
        UtilidadesLog.info("MONIntegracionSICCBean.ejecutarReemplazoIncentivos(DTOEntradaSICC dtoe): Salida");
        return dtoSalida;
    }

    private DTOSalidaSICC pasarPedidoMonitorGP4(DTOEntradaSICC dtoe) throws MareException {
        UtilidadesLog.info("MONIntegracionSICCBean.pasarPedidoMonitorGP4(DTOEntradaSICC dtoe): Entrada");
        DAOIntegracionSICC daoIntegracion = new DAOIntegracionSICC();
        DTOSalidaSICC dtoSalida = new DTOSalidaSICC();
        
        UtilidadesLog.info("DTO recibido de SSICC: ");
        UtilidadesLog.info(dtoe.toString());
        
        try {
            //1) Realizamos la Busqueda de las zonas a procesar, como si estuvieramos en el monitor
            UtilidadesLog.info("1.-- INVOCAMOS A LA BUSQUEDA DE MONITOR");
            DTOBuscarDatosMonitor dtoBDM = new DTOBuscarDatosMonitor();
            dtoBDM.setOidIdioma(dtoe.getOidIdioma());
            dtoBDM.setOidPais(dtoe.getOidPais());
            dtoBDM.setFechaInicio(convertirFechaaDate(dtoe.getFechaProceso(), dtoe.getFormatoFecha()));
            dtoBDM.setFechaFin(dtoBDM.getFechaInicio());
        
            ArrayList listaTiposSolicitudes = new ArrayList();
            if(dtoe.getParametros().get("listaTiposSolicitudes") != null)
                listaTiposSolicitudes = (ArrayList)dtoe.getParametros().get("listaTiposSolicitudes");
            else
                listaTiposSolicitudes = daoIntegracion.obtenerOidsTiposSolicitudesOC();
            
            dtoBDM.setOidTipoSolicitudPais(listaTiposSolicitudes);
            dtoBDM.setOidPeriodo(dtoe.getOidPeriodo());
        
            MONMonitorHome home = getMONMonitorHome();
            MONMonitor monMonitor = home.create();                         
            DTODatosMonitor dtoMonitor = new DTODatosMonitor();
            
            try {
                dtoMonitor = monMonitor.obtenerDatosMejorado(dtoBDM);
            } catch(Exception ex) {
                throw new MareException("ERROR, NO SE ENCONTRARON SOLICITUDES DE PEDIDO O/C PARA PASAR A GP4");
            }
        
            //2) Creamos la lista de zonas y secuencias a enviar
            UtilidadesLog.info("2.-- CREAMOS LA LISTA DE ZONAS Y SECUENCIAS A ENVIAR");
            RecordSet resultado =  dtoMonitor.getProcesos();
            ArrayList listaSecuencias = new ArrayList();
            Long secuencia = new Long(0);
            for(int i=0; i<resultado.getRowCount(); i++) {
                String tieneText = (String)resultado.getValueAt(i, 0);
                
                if(tieneText.equalsIgnoreCase("1")) {               
                    Long oidTipoSolicitud = new Long(resultado.getValueAt(i, 14).toString());
                    Long oidZona = new Long(resultado.getValueAt(i, 16).toString()); 
                    
                    Long totalPedidos = new Long(resultado.getValueAt(i, 8).toString());  
                    if(totalPedidos.longValue() > 0) {
                        secuencia = secuencia + 1;
                        
                        DTOSecuenciaSolicitudes dtoSecuencia = new DTOSecuenciaSolicitudes();
                        dtoSecuencia.setOidPais(dtoe.getOidPais());
                        dtoSecuencia.setOidIdioma(dtoe.getOidIdioma());
                        dtoSecuencia.setOidTipoSolicitud(oidTipoSolicitud);
                        dtoSecuencia.setOidZona(oidZona);
                        dtoSecuencia.setSecuencia(secuencia);
                        listaSecuencias.add(dtoSecuencia);
                    }    
                }    
            }
            
            if(listaSecuencias.size()==0) {
                throw new MareException("ERROR, NO SE ENCONTRARON SOLICITUDES DE PEDIDO O/C PARA PASAR A GP4");
            }

            //3) Invocamos al proceso Batch de GP2            
            UtilidadesLog.info("3.-- INVOCAMOS AL PROCESO BATCH DE GP4");
            DTOInfoMonitor dtoIM = new DTOInfoMonitor();
            dtoIM.setOidPais(dtoe.getOidPais());
            dtoIM.setOidIdioma(dtoe.getOidIdioma());
            dtoIM.setOidPeriodo(dtoe.getOidPeriodo());
            dtoIM.setFechaInicio(new java.sql.Date(convertirFechaaDate(dtoe.getFechaProceso(), dtoe.getFormatoFecha()).getTime()));
            dtoIM.setFechaFin(dtoIM.getFechaInicio());
            dtoIM.setSecuencia(listaSecuencias);
            dtoIM.setGP(ConstantesPED.GP3);
            dtoIM.setCodigoUsuario(dtoe.getCodigoUsuario());
            dtoIM.setIndTipificacion(false);
            dtoIM.setFechaProceso(new java.sql.Date(convertirFechaaDate(dtoe.getFechaProceso(), dtoe.getFormatoFecha()).getTime()));
            
            String codigoBatch = monMonitor.procesarSolicitudesIntegracionSSICC(dtoIM);
            
            //4) Obtenemos el Id de Proceso Batch
            dtoSalida.setIdProcesoBatch(codigoBatch);
            UtilidadesLog.info("4.-- OBTENEMOS EL ID DE PROCESO BATCH de GP4: " + dtoSalida.getIdProcesoBatch());
            
        } catch(CreateException ce) {
            ce.printStackTrace();
            ctx.setRollbackOnly();
            throw new MareException(ce, UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
        } catch (MareException ma) {
            ctx.setRollbackOnly();
            throw ma;
        } catch(NamingException fe) {
            ctx.setRollbackOnly();
            throw new MareException(fe, UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));          
        } catch(RemoteException re) {
            ctx.setRollbackOnly();
            throw new MareException(re, UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));                      
        } catch (Exception e) {
            e.printStackTrace();
            ctx.setRollbackOnly();
            throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS));      
        }
        
        UtilidadesLog.info("DTO enviado a SSICC: ");
        UtilidadesLog.info(dtoSalida.toString());
        
        UtilidadesLog.info("MONIntegracionSICCBean.pasarPedidoMonitorGP4(DTOEntradaSICC dtoe): Salida");
        return dtoSalida;
    }

    private DTOSalidaSICC ejecutarReevaluarEstatus(DTOEntradaSICC dtoe) throws MareException {
        UtilidadesLog.info("MONIntegracionSICCBean.ejecutarReevaluarEstatus(DTOEntradaSICC dtoe): Entrada");
        DAOIntegracionSICC daoIntegracion = new DAOIntegracionSICC();
        DTOSalidaSICC dtoSalida = new DTOSalidaSICC();
        
        UtilidadesLog.info("DTO recibido de SSICC: ");
        UtilidadesLog.info(dtoe.toString());
        
        try {
             //Creamos el DTO con los datos necesarios para el proceso
             DTOFACCierreFacturacion dtoCierreFac = new DTOFACCierreFacturacion();
             
            dtoCierreFac.setOidPais(dtoe.getOidPais());
            dtoCierreFac.setOidIdioma(dtoe.getOidIdioma());
            dtoCierreFac.setCodigoUsuario(dtoe.getCodigoUsuario());
            dtoCierreFac.setMarca(daoIntegracion.obtenerOidMarca(dtoe.getCodigoMarca()));
            dtoCierreFac.setCanal(daoIntegracion.obtenerOidCanal(dtoe.getCodigoCanal()));
            dtoCierreFac.setPeriodo(dtoe.getOidPeriodo());

            //Obtenemos la lista de Tipos de Cierre  para obtener el oidTipoCierreRegion
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
            UtilidadesLog.debug(" Verificando el cierre de Periodo: " + dtoCierreFac.getPeriodo());
            dtoCierreFac.setTipoCierre(oidTipoCierrePeriodo);
            dtoCierreFac.setCodigoTipoCierre(ConstantesFAC.TIPO_CIERRE_PERIODO);
                      
            Integer nroCtrlCierresPeriodo = daoFac.obtenerNumeroControlCierres(dtoCierreFac);
            UtilidadesLog.debug(" ... cant cierres_" + nroCtrlCierresPeriodo);
            
            if (nroCtrlCierresPeriodo.intValue() > 0) { // Ya se ha ejecutado un cierre de periodo
                // MAE-0038 "Cierre de periodo ya ejecutado: no puede reasignar Estatus en lote"
                UtilidadesLog.error("El Cierre de Periodo ya habia sido ejecutado.");
                UtilidadesLog.info("MONEstatusCliente.reasignarEstatusEnLotes(DTOFACCierreFacturacion dtoe): Salida A");
                throw new MareException("Cierre de periodo ya ejecutado: no puede reasignar Estatus en lote");
            }
            
            // Obtiene las regiones cerradas
            DAOMAEEstatusCliente daoMAEEstatusCliente = new DAOMAEEstatusCliente(dtoCierreFac.getCodigoUsuario());
            
            // Obtiene regiones
            DTOOIDs oidRegiones = daoMAEEstatusCliente.obtieneRegiones(dtoCierreFac);
            
            if(oidRegiones.getOids().length ==0){
                UtilidadesLog.error("No hay regiones cerradas");
                UtilidadesLog.info("MONEstatusCliente.reasignarEstatusEnLotes(DTOFACCierreFacturacion dtoe): Salida");
                throw new MareException("No se encontraron regiones cerradas para el periodo seleccionado");
            } else {
                dtoCierreFac.setRegiones(oidRegiones);
            }
            
            // Activa consultoras
            daoMAEEstatusCliente.activarConsultoras(dtoCierreFac);
            
            dtoCierreFac.setTipoCierre(null);
            dtoCierreFac.setCodigoTipoCierre(null);
            UtilidadesLog.debug("dtoCierreFac: " + dtoCierreFac);
            
            // Se pasaron ambas validaciones, se llama al método reasignarEstatusEnLotesBatch en modo batch
            UtilidadesLog.debug(" ... Se pasaron las validaciones... ahora la ejecucion es Batch");
            MareBusinessID id = new MareBusinessID(new String("MAEReasignarEstatusEnLotesBatch"));
            DTOBatch dtoBatch = new DTOBatch(new String("reasignarEstatusEnLotesBatch"), id, dtoCierreFac, dtoe.getCodigoUsuario());
                
            //Obtenemos el codigo Batch de la Ejecucion de la Interfaz                                                
            String codigoBatch = dtoBatch.getProcessID();
        
            BusinessFacade bf = getBusinessFacade();
            bf.execute( dtoBatch, new MareBusinessID("FACProcesosGP5"));
            
            //Obtenemos el Id de Proceso Batch
            dtoSalida.setIdProcesoBatch(codigoBatch);
            UtilidadesLog.info("OBTENEMOS EL ID DE PROCESO REEVALUAR ESTATUS: " + dtoSalida.getIdProcesoBatch());
                        
        } catch (MareException ma) {
            ctx.setRollbackOnly();
            throw ma;
        } catch(RemoteException re) {
            ctx.setRollbackOnly();
            throw new MareException(re, UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));                      
        } catch (Exception e) {
            e.printStackTrace();
            ctx.setRollbackOnly();
            throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS));      
        }
        
        UtilidadesLog.info("DTO enviado a SSICC: ");
        UtilidadesLog.info(dtoSalida.toString());
        
        UtilidadesLog.info("MONIntegracionSICCBean.ejecutarReevaluarEstatus(DTOEntradaSICC dtoe): Salida");
        return dtoSalida;
    }

    private DTOSalidaSICC ejecutarRevertirSolicitudes(DTOEntradaSICC dtoe) throws MareException {
        UtilidadesLog.info("MONIntegracionSICCBean.ejecutarRevertirSolicitudes(DTOEntradaSICC dtoe): Entrada");
        DAOIntegracionSICC daoIntegracion = new DAOIntegracionSICC();
        DTOSalidaSICC dtoSalida = new DTOSalidaSICC();
        
        UtilidadesLog.info("DTO recibido de SSICC: ");
        UtilidadesLog.info(dtoe.toString());
            
        try {
            //Creamos el DTO con los datos necesarios para el proceso
            DTOInfoMonitor dtoIM = new DTOInfoMonitor();
            dtoIM.setOidPais(dtoe.getOidPais());
            dtoIM.setOidIdioma(dtoe.getOidIdioma());
            dtoIM.setCodigoUsuario(dtoe.getCodigoUsuario());
            dtoIM.setFechaInicio(new java.sql.Date(convertirFechaaDate(dtoe.getFechaProceso(), dtoe.getFormatoFecha()).getTime()));
            
            //EJECUTAMOS EL PROCESO
            MareBusinessID id = new MareBusinessID(new String("PEDReversarSolicitudesServicio"));
            DTOBatch dtoBatch = new DTOBatch(new String("MONITOR"), id, dtoIM, dtoe.getCodigoUsuario());
                
            //Obtenemos el codigo Batch de la Ejecucion de la Interfaz                                                
            String codigoBatch = dtoBatch.getProcessID();
        
            BusinessFacade bf = getBusinessFacade();
            bf.execute( dtoBatch, new MareBusinessID("PEDSecuenciaProcesos"));
            
            //Obtenemos el Id de Proceso Batch
            dtoSalida.setIdProcesoBatch(codigoBatch);
            UtilidadesLog.info("OBTENEMOS EL ID DE PROCESO REEVALUAR ESTATUS: " + dtoSalida.getIdProcesoBatch());
                        
        } catch (MareException ma) {
            ctx.setRollbackOnly();
            throw ma;
        } catch(RemoteException re) {
            ctx.setRollbackOnly();
            throw new MareException(re, UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));                      
        } catch (Exception e) {
            e.printStackTrace();
            ctx.setRollbackOnly();
            throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS));      
        }
        
        UtilidadesLog.info("DTO enviado a SSICC: ");
        UtilidadesLog.info(dtoSalida.toString());
        
        UtilidadesLog.info("MONIntegracionSICCBean.ejecutarRevertirSolicitudes(DTOEntradaSICC dtoe): Salida");
        return dtoSalida;
    }

    private DTOSalidaSICC ejecutarInterfazLarissa(DTOEntradaSICC dtoe) throws MareException {
        UtilidadesLog.info("MONIntegracionSICCBean.ejecutarInterfazLarissa(DTOEntradaSICC dtoe): Entrada");
        DAOIntegracionSICC daoIntegracion = new DAOIntegracionSICC();
        DTOSalidaSICC dtoSalida = new DTOSalidaSICC();
        
        UtilidadesLog.info("DTO recibido de SSICC: ");
        UtilidadesLog.info(dtoe.toString());
        
        try {
            //Obtenemos numero de Lote y Descripcion de Interfaz de Larissa
            DTOString dtos = new DTOString();
            dtos.setCadena(IGestorInterfaces.COD_INTERFAZ_LAR1);
            dtos.setOidIdioma(dtoe.getOidIdioma());
            dtos.setOidPais(dtoe.getOidPais());
            DTOCargaInicialInterfaz dtoInter = this.getMONINT().cargaInicial(dtos);
            
            //Creamos el DTO con los datos necesarios para el proceso
            DTOINTCargaInicialLarissa dto = new DTOINTCargaInicialLarissa();
            dto.setOidPais(dtoe.getOidPais());
            dto.setOidIdioma(dtoe.getOidIdioma());
            
            dto.setMarca(daoIntegracion.obtenerOidMarca(dtoe.getCodigoMarca()));
            dto.setCanal(daoIntegracion.obtenerOidCanal(dtoe.getCodigoCanal()));
            dto.setPeriodo(dtoe.getOidPeriodo());
            dto.setDescripcionLote(dtoInter.getDescripcion());
            dto.setNumeroLote(dtoInter.getNumeroLote().toString());
            dto.setEnviarEstimados(new Boolean(true));
            
            //Seteamos Numero de Lote
            dtoSalida.setNumeroLote(dto.getNumeroLote());
        
            /**
             * PeriodoCorporativo periodo = PeriodoCorporativoHome.findByPrimaryKey( dtoe.periodo ) 
             * dtoe.tipoPeriodo = periodo.tipoPeriodoCorporativo 
             * dtoe.codigoPeriodo = periodo.codigoPeriodoCorporativo 
             */
            UtilidadesLog.debug ("DTOINTCargaInicialLarissa: "+dto);
            PeriodoCorporativoLocalHome periodoCorporativoLocalHome = null;
            PeriodoCorporativoLocal periodoCorporativoLocal = null;
            PeriodoLocalHome periodoLocalHome = null;
            PeriodoLocal periodoLocal=null;
            
            //añadido por incidencia 20300
            periodoLocalHome = this.getPeriodoLocalHome();
            
            periodoCorporativoLocalHome = this.getPeriodoCorporativoLocalHome();
            try{
                periodoLocal = periodoLocalHome.findByPrimaryKey(dto.getPeriodo());
            }catch (NoResultException ex){        
                UtilidadesLog.error("*** Error finder en enviarInterfaces de MONLAR -Periodo-",ex);
                return null;       
            }  catch (PersistenceException ce) {   
                UtilidadesLog.error("ERROR ", ce);
                throw new MareException(ce, 
                UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
            }
            try{
                periodoCorporativoLocal = periodoCorporativoLocalHome.findByPrimaryKey(periodoLocal.getOidPeriodoCorporativo());
            }catch (NoResultException ex){        
                UtilidadesLog.error("*** Error finder en enviarInterfaces de MONLAR -PeriodoCorporativo-",ex);
                return null;
                /*Eliminado por incidencia 14522
                String codigoError = CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE;
                throw new MareException(ex, UtilidadesError.armarCodigoError(codigoError));*/            
             }  catch (PersistenceException ce) {   
                 UtilidadesLog.error("ERROR ", ce);
                 throw new MareException(ce, 
                 UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
            }
            dto.setTipoPeriodo(periodoCorporativoLocal.getOidTipoPeriodo());
            dto.setCodigoPeriodo(periodoCorporativoLocal.getCodigoPeriodo());
            UtilidadesLog.debug("periodoCorporativoLocal.TipooPeriodo: "+periodoCorporativoLocal.getOidTipoPeriodo());
            UtilidadesLog.debug("periodoCorporativoLocal.CodigoPeriodo: "+periodoCorporativoLocal.getCodigoPeriodo());
            /*
             * TipoPeriodoCorporativo tipoPeriodo = TipoPeriodoCorporativoHome.findByPrimaryKey( periodo.tipoPeriodoCorporativo ) 
             * dtoe.codigoTipoPeriodo = tipoPeriodo.codigoTipoPeriodo
             */
             
            TipoPeriodoCorporativoLocalHome tipoPeriodoCorporativoLocalHome = null;
            TipoPeriodoCorporativoLocal tipoPeriodoCorporativoLocal = null;
            
            tipoPeriodoCorporativoLocalHome = this.getTipoPeriodoCorporativoLocalHome();
            try{
                //tipoPeriodoCorporativoLocal = tipoPeriodoCorporativoLocalHome.findByPrimaryKey(dto.getPeriodo());
                tipoPeriodoCorporativoLocal = tipoPeriodoCorporativoLocalHome.findByPrimaryKey(periodoCorporativoLocal.getOidTipoPeriodo());

            }catch (NoResultException ex){        
                UtilidadesLog.error("*** Error finder en enviarInterfaces de MONLAR -TipoPeriodoCorporativo-",ex);
                return null;
                /*Eliminado por incidencia 14522
                String codigoError = CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE;
                throw new MareException(ex, UtilidadesError.armarCodigoError(codigoError));*/
             }  catch (PersistenceException ce) {   
                 UtilidadesLog.error("ERROR ", ce);
                 throw new MareException(ce, 
                 UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
            }
            dto.setCodigoTipoPeriodo(tipoPeriodoCorporativoLocal.getCodigoTipoPeriodo());
            UtilidadesLog.debug("tipoPeriodoCorporativoLocal.CodigoPeriodo: "+tipoPeriodoCorporativoLocal.getCodigoTipoPeriodo());
                    
            DTOBatch dtoBatch = null;
            StringBuffer sbBatchs = new StringBuffer("");
            
            UtilidadesLog.debug("Empieza a encolar las interfaces del combo");
            if (dto.getEnviarEstimados().booleanValue()){
                UtilidadesLog.debug("Interfaz enviarMatrizProductosEstimados activada");
                dtoBatch = new DTOBatch ("enviarMatrizProductosEstimados",new MareBusinessID("INTEnviarMatrizProductosEstimados"),dto);
                try {
                    BatchUtil.executeMLN( dtoBatch, "INTProcesoInterfaces" );
                }catch(RemoteException re){
                    UtilidadesLog.error("*** Error en enviarInterfaces",re);
                    String codigoError = CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB;
                    throw new MareException(re, UtilidadesError.armarCodigoError(codigoError));                     
                }
                sbBatchs.append(dtoBatch.getProcessID()).append(",");
            }
            
            //Se lanzan todas las interfaces cargadas desde el listado de la pagina
            UtilidadesLog.debug("Encolamos enviarMatrizProductosVentaReal");
            dtoBatch = new DTOBatch ("enviarMatrizProductosVentaReal",new MareBusinessID("INTEnviarMatrizProductosVentaReal"),dto);
            try {
                BatchUtil.executeMLN( dtoBatch, "INTProcesoInterfaces" );
                sbBatchs.append(dtoBatch.getProcessID()).append(",");
            }catch(RemoteException re){
                UtilidadesLog.error("*** Error en enviarInterfaces",re);
                String codigoError = CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB;
                throw new MareException(re, UtilidadesError.armarCodigoError(codigoError));                     
            }
            
            //Añadido segun incidencia 16916
            UtilidadesLog.debug("Encolamos enviarMaestroZonas");
            dtoBatch = new DTOBatch ("enviarMaestroZonas",new MareBusinessID("INTEnviarMaestroZonasLAR"),dto);
            try {
                BatchUtil.executeMLN( dtoBatch, "INTProcesoInterfaces" );
            }catch(RemoteException re){
                    UtilidadesLog.error("*** Error en enviarInterfaces",re);
                    String codigoError = CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB;
                    throw new MareException(re, UtilidadesError.armarCodigoError(codigoError));                     
            }        
            
            UtilidadesLog.debug("Encolamos enviarMaestroTerritorios");
            dtoBatch = new DTOBatch ("enviarMaestroTerritorios",new MareBusinessID("INTEnviarMaestroTerritorios"),dto);
            try {
                BatchUtil.executeMLN( dtoBatch, "INTProcesoInterfaces" );
                sbBatchs.append(dtoBatch.getProcessID()).append(",");
            }catch(RemoteException re){
                UtilidadesLog.error("*** Error en enviarInterfaces",re);
                String codigoError = CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB;
                throw new MareException(re, UtilidadesError.armarCodigoError(codigoError));                     
            }
            
            UtilidadesLog.debug("Encolamos enviarClasesTipoSolicitud");
            dtoBatch = new DTOBatch ("enviarClasesTipoSolicitud",new MareBusinessID("INTEnviarClasesTipoSolicitud"),dto);
            try {
                BatchUtil.executeMLN( dtoBatch, "INTProcesoInterfaces" );
            }catch(RemoteException re){
                    UtilidadesLog.error("*** Error en enviarInterfaces",re);
                    String codigoError = CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB;
                    throw new MareException(re, UtilidadesError.armarCodigoError(codigoError));                     
            }
            
            UtilidadesLog.debug("Encolamos enviarMaestroDestinosClientes");
            dtoBatch = new DTOBatch ("enviarMaestroDestinosClientes",new MareBusinessID("INTEnviarMaestroDestinosClientes"),dto);
            try {
                BatchUtil.executeMLN( dtoBatch, "INTProcesoInterfaces" );
                sbBatchs.append(dtoBatch.getProcessID()).append(",");
            }catch(RemoteException re){
                UtilidadesLog.error("*** Error en enviarInterfaces",re);
                String codigoError = CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB;
                throw new MareException(re, UtilidadesError.armarCodigoError(codigoError));                     
            }

            //añadido por Sapaza, fecha 28/04/2008, nuevas interfaces LAR9 y LAR10
            UtilidadesLog.debug("Encolamos enviarSecuenciaPedidos");
            dtoBatch = new DTOBatch ("enviarSecuenciaPedidos",new MareBusinessID("INTEnviarSecuenciaPedidos"),dto);
            try {
                BatchUtil.executeMLN( dtoBatch, "INTProcesoInterfaces" );
            }catch(RemoteException re){
                UtilidadesLog.error("*** Error en enviarInterfaces",re);
                String codigoError = CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB;
                throw new MareException(re, UtilidadesError.armarCodigoError(codigoError));                     
            }

            UtilidadesLog.debug("Encolamos enviarDocumentoIdentidadClientes");
            dtoBatch = new DTOBatch ("enviarDocumentoIdentidadClientes",new MareBusinessID("INTEnviarDocumentoIdentidadClientes"),dto);
            try {
                BatchUtil.executeMLN( dtoBatch, "INTProcesoInterfaces" );
                sbBatchs.append(dtoBatch.getProcessID()).append(",");
            }catch(RemoteException re){
                UtilidadesLog.error("*** Error en enviarInterfaces",re);
                String codigoError = CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB;
                throw new MareException(re, UtilidadesError.armarCodigoError(codigoError));                     
            }
            
            UtilidadesLog.debug("Encolamos enviarCabeceraDetalleDocumentos");
            dtoBatch = new DTOBatch ("enviarCabeceraDetalleDocumentos",new MareBusinessID("INTEnviarCabeceraDetalleDocumentos"),dto);
            try {
                BatchUtil.executeMLN( dtoBatch, "INTProcesoInterfaces" );
                sbBatchs.append(dtoBatch.getProcessID());
            }catch(RemoteException re){
                UtilidadesLog.error("*** Error en enviarInterfaces",re);
                String codigoError = CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB;
                throw new MareException(re, UtilidadesError.armarCodigoError(codigoError));                     
            }
            
            //Obtenemos el Id de Proceso Batch
            dtoSalida.setIdProcesoBatch(sbBatchs.toString());
            UtilidadesLog.info("OBTENEMOS EL ID DE PROCESO INTERFAZ LARISSA: " + sbBatchs.toString());
                        
        } catch (MareException ma) {
            ctx.setRollbackOnly();
            throw ma;
        } catch(RemoteException re) {
            ctx.setRollbackOnly();
            throw new MareException(re, UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));                      
        } catch (Exception e) {
            e.printStackTrace();
            ctx.setRollbackOnly();
            throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS));      
        }
        
        UtilidadesLog.info("DTO enviado a SSICC: ");
        UtilidadesLog.info(dtoSalida.toString());
        
        UtilidadesLog.info("MONIntegracionSICCBean.ejecutarInterfazLarissa(DTOEntradaSICC dtoe): Salida");
        return dtoSalida;
    }
    
    private DTOSalidaSICC ejecutarInterfazRecepcionarECM(DTOEntradaSICC dtoe) throws MareException {
        UtilidadesLog.info("MONIntegracionSICCBean.ejecutarInterfazRecepcionarECM(DTOEntradaSICC dtoe): Entrada");
        DAOIntegracionSICC daoIntegracion = new DAOIntegracionSICC();
        DTOSalidaSICC dtoSalida = new DTOSalidaSICC();
        
        UtilidadesLog.info("DTO recibido de SSICC: ");
        UtilidadesLog.info(dtoe.toString());
        
        try {
            //Obtenemos numero de Lote y Descripcion de Interfaz de Larissa
            DTOString dtos = new DTOString();
            dtos.setCadena(IGestorInterfaces.COD_INTERFAZ_ECM1);
            dtos.setOidIdioma(dtoe.getOidIdioma());
            dtos.setOidPais(dtoe.getOidPais());
            DTOCargaInicialInterfaz dtoInter = this.getMONINT().cargaInicial(dtos);
            
            //Creamos el DTO con los datos necesarios para el proceso
            DTOINT dto = new DTOINT();
            dto.setOidPais(dtoe.getOidPais());
            dto.setOidIdioma(dtoe.getOidIdioma());
            dto.setDescripcionLote(dtoInter.getDescripcion());
            dto.setNumeroLote(dtoInter.getNumeroLote());
            dto.setNombreArchivo(ConstantesIntegracion.ARCHIVO_SIMULADO_ACO);
            
            //Seteamos Numero de Lote
            dtoSalida.setNumeroLote(dto.getNumeroLote().toString());
                    
            DTOBatch dtoBatch = null;
            StringBuffer sbBatchs = new StringBuffer("");
            
            //Se lanzan primero la carga de la interface y cuando finalice se lanza 
            //la carga en pedidos y en incentivos
            UtilidadesLog.debug("Encolamos Cargar Ventas Asociadas en INT");
            dtoBatch = new DTOBatch("Cargar Ventas Asociadas en INT",new MareBusinessID("INTCargarVentasAsociadasINT"),dto);
            try {
                BatchUtil.executeMLN( dtoBatch, "INTProcesoInterfaces" );
                sbBatchs.append(dtoBatch.getProcessID()).append(",");
            }catch(RemoteException re){
                UtilidadesLog.error("*** Error en enviarInterfaces",re);
                String codigoError = CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB;
                throw new MareException(re, UtilidadesError.armarCodigoError(codigoError));                     
            }
            
            esperarProcesamiento(dtoBatch.getProcessID());
            
            UtilidadesLog.debug("Encolamos Cargar Ventas Asociadas en PED");
            dtoBatch = new DTOBatch( "Cargar Ventas Asociadas en PED",new MareBusinessID("INTCargarVentasAsociadasPED"),dto);
            try {
                BatchUtil.executeMLN( dtoBatch, "INTProcesoInterfaces" );
                sbBatchs.append(dtoBatch.getProcessID()).append(",");
            }catch(RemoteException re){
                UtilidadesLog.error("*** Error en enviarInterfaces",re);
                String codigoError = CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB;
                throw new MareException(re, UtilidadesError.armarCodigoError(codigoError));                     
            }
            
            UtilidadesLog.debug("Encolamos Cargar Ventas Asociadas en INC");
            dtoBatch = new DTOBatch( "Cargar Ventas Asociadas en INC", new MareBusinessID( "INTCargarVentasAsociadasINC" ),dto);
            try {
                BatchUtil.executeMLN( dtoBatch, "INTProcesoInterfaces" );
                sbBatchs.append(dtoBatch.getProcessID());
            }catch(RemoteException re){
                UtilidadesLog.error("*** Error en enviarInterfaces",re);
                String codigoError = CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB;
                throw new MareException(re, UtilidadesError.armarCodigoError(codigoError));                     
            }
            
            //Obtenemos el Id de Proceso Batch
            dtoSalida.setIdProcesoBatch(sbBatchs.toString());
            UtilidadesLog.info("OBTENEMOS EL ID DE PROCESO INTERFAZ ECM: " + sbBatchs.toString());
                        
        } catch (MareException ma) {
            ctx.setRollbackOnly();
            throw ma;
        } catch(RemoteException re) {
            ctx.setRollbackOnly();
            throw new MareException(re, UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));                      
        } catch (Exception e) {
            e.printStackTrace();
            ctx.setRollbackOnly();
            throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS));      
        }
        
        UtilidadesLog.info("DTO enviado a SSICC: ");
        UtilidadesLog.info(dtoSalida.toString());
        
        UtilidadesLog.info("MONIntegracionSICCBean.ejecutarInterfazRecepcionarECM(DTOEntradaSICC dtoe): Salida");
        return dtoSalida;
    }
    
    private DTOSalidaSICC ejecutarActivarConcursos(DTOEntradaSICC dtoe) throws MareException {
        UtilidadesLog.info("MONIntegracionSICCBean.ejecutarActivarConcursos(DTOEntradaSICC dtoe): Entrada");
        DAOIntegracionSICC daoIntegracion = new DAOIntegracionSICC();
        DTOSalidaSICC dtoSalida = new DTOSalidaSICC();
        
        UtilidadesLog.info("DTO recibido de SSICC: ");
        UtilidadesLog.info(dtoe.toString());
        
        try {
            //Creamos el DTO con los datos necesarios para el proceso de reemplazos
            MareDTO dto = new MareDTO();
            dto.setProperty(ConstantesCRA.DATO_PAIS, dtoe.getOidPais());
            dto.setProperty(ConstantesCRA.DATO_MARCA, daoIntegracion.obtenerOidMarca(dtoe.getCodigoMarca()));
            dto.setProperty(ConstantesCRA.DATO_CANAL, daoIntegracion.obtenerOidCanal(dtoe.getCodigoCanal()));
            dto.setProperty(ConstantesCRA.DATO_PERIODO, dtoe.getOidPeriodo());
            dto.setProperty(ConstantesCRA.DATO_MODULO, new Long(ConstantesSEG.MODULO_INC));
            
            DTOBatch dtoBatch = new DTOBatch( "Activacion de concursos", 
                                                new MareBusinessID( "INCActivarConcursosBatch" ),
                                                dto,
                                                dtoe.getCodigoUsuario());
                                                
            //Obtenemos el codigo Batch de la Ejecucion de la Interfaz                                                
            String codigoBatch = dtoBatch.getProcessID();
            
            try {
                BatchUtil.executeMLN( dtoBatch, "INCPROCESOSBATCH" );
            }catch(RemoteException re){
                UtilidadesLog.error("*** Error en enviarInterfaces",re);
                String codigoError = CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB;
                throw new MareException(re, UtilidadesError.armarCodigoError(codigoError));                     
            }
            
            //Obtenemos el Id de Proceso Batch
            dtoSalida.setIdProcesoBatch(codigoBatch);
            UtilidadesLog.info("OBTENEMOS EL ID DE PROCESO ACTIVAR CONCURSOS: " + dtoSalida.getIdProcesoBatch());
                        
        } catch (MareException ma) {
            ctx.setRollbackOnly();
            throw ma;
        } catch(RemoteException re) {
            ctx.setRollbackOnly();
            throw new MareException(re, UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));                      
        } catch (Exception e) {
            e.printStackTrace();
            ctx.setRollbackOnly();
            throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS));      
        }
        
        UtilidadesLog.info("DTO enviado a SSICC: ");
        UtilidadesLog.info(dtoSalida.toString());
        
        UtilidadesLog.info("MONIntegracionSICCBean.ejecutarActivarConcursos(DTOEntradaSICC dtoe): Salida");
        return dtoSalida;
    }

    private DTOSalidaSICC ejecutarCerrarConcursos(DTOEntradaSICC dtoe) throws MareException {
        UtilidadesLog.info("MONIntegracionSICCBean.ejecutarCerrarConcursos(DTOEntradaSICC dtoe): Entrada");
        DAOIntegracionSICC daoIntegracion = new DAOIntegracionSICC();
        DTOSalidaSICC dtoSalida = new DTOSalidaSICC();
        
        UtilidadesLog.info("DTO recibido de SSICC: ");
        UtilidadesLog.info(dtoe.toString());
        
        try {
            //Creamos el DTO con los datos necesarios para el proceso de reemplazos
            MareDTO dto = new MareDTO();
            dto.setProperty(ConstantesCRA.DATO_PAIS, dtoe.getOidPais());
            dto.setProperty(ConstantesCRA.DATO_MARCA, daoIntegracion.obtenerOidMarca(dtoe.getCodigoMarca()));
            dto.setProperty(ConstantesCRA.DATO_CANAL, daoIntegracion.obtenerOidCanal(dtoe.getCodigoCanal()));
            dto.setProperty(ConstantesCRA.DATO_PERIODO, dtoe.getOidPeriodo());
            dto.setProperty(ConstantesCRA.DATO_MODULO, new Long(ConstantesSEG.MODULO_INC));
            dto.setProperty(ConstantesCRA.DATO_VARIABLE_ENTORNO, Boolean.valueOf(false));
            
            DTOBatch dtoBatch = new DTOBatch( "Cerrado de concursos", 
                                                new MareBusinessID( "INCCerrarConcursosBatch" ),
                                                dto,
                                                dtoe.getCodigoUsuario());
                                                
            //Obtenemos el codigo Batch de la Ejecucion de la Interfaz                                                
            String codigoBatch = dtoBatch.getProcessID();
            
            try {
                BatchUtil.executeMLN( dtoBatch, "INCPROCESOSBATCH" );
            }catch(RemoteException re){
                UtilidadesLog.error("*** Error en enviarInterfaces",re);
                String codigoError = CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB;
                throw new MareException(re, UtilidadesError.armarCodigoError(codigoError));                     
            }
            
            //Obtenemos el Id de Proceso Batch
            dtoSalida.setIdProcesoBatch(codigoBatch);
            UtilidadesLog.info("OBTENEMOS EL ID DE PROCESO CERRAR CONCURSOS: " + dtoSalida.getIdProcesoBatch());
                        
        } catch (MareException ma) {
            ctx.setRollbackOnly();
            throw ma;
        } catch(RemoteException re) {
            ctx.setRollbackOnly();
            throw new MareException(re, UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));                      
        } catch (Exception e) {
            e.printStackTrace();
            ctx.setRollbackOnly();
            throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS));      
        }
        
        UtilidadesLog.info("DTO enviado a SSICC: ");
        UtilidadesLog.info(dtoSalida.toString());
        
        UtilidadesLog.info("MONIntegracionSICCBean.ejecutarCerrarConcursos(DTOEntradaSICC dtoe): Salida");
        return dtoSalida;
    }
    
    private PeriodoLocalHome getPeriodoLocalHome() {
            return new PeriodoLocalHome();
    }

    private PeriodoCorporativoLocalHome getPeriodoCorporativoLocalHome() {
            return new PeriodoCorporativoLocalHome();
    }

    private TipoPeriodoCorporativoLocalHome getTipoPeriodoCorporativoLocalHome() {
            return new TipoPeriodoCorporativoLocalHome();
    }

    private MONINT getMONINT() throws MareException {
        // Se obtiene el interfaz home
        UtilidadesLog.info("MONAdamBean.getMONINT(): Entrada");
        MONINTHome home = (MONINTHome)UtilidadesEJB.getHome("MONINT", MONINTHome.class);
    
        // Se obtiene el interfaz remoto
        MONINT ejb = null;
        try {
            ejb = home.create();
        } catch (Exception e) {
            UtilidadesLog.error(e);
            String codigoError = CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB;
            throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));
        } 
        
        UtilidadesLog.info("MONAdamBean.getMONINT(): Salida");
        return ejb;
    }
    
}
