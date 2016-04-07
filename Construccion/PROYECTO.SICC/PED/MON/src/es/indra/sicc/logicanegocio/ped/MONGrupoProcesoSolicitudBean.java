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
 * Autor: Hugo A. Mansi
 * Fecha de creación: 3 de agosto de 2004
 * Paquete N0002 PED
 * 
 */


package es.indra.sicc.logicanegocio.ped;
import es.indra.sicc.util.LogAPP;
import es.indra.sicc.util.UtilidadesLog;
import java.util.Date;
import javax.ejb.SessionBean;
import javax.ejb.SessionContext;
import es.indra.sicc.dtos.ped.DTOSolicitudValidacion;
import es.indra.sicc.dtos.ped.DTOListaProcesos;
import es.indra.mare.common.exception.MareException;
import es.indra.sicc.dtos.ped.DTOEstatusSolicitud;

import es.indra.sicc.dtos.ped.DTOProceso;
import es.indra.sicc.logicanegocio.ped.DAOGruposProceso;
import es.indra.sicc.logicanegocio.ped.DAOSolicitud;

import es.indra.mare.common.mii.services.jdbcservice.RecordSet;
import java.util.ArrayList;

import es.indra.sicc.logicanegocio.ped.ConstantesPED;
import es.indra.sicc.logicanegocio.seg.ConstantesSEG;

import es.indra.sicc.entidades.seg.MonedaLocal;
import es.indra.sicc.entidades.seg.MonedaLocalHome;
import es.indra.sicc.entidades.seg.PaisLocal;
import es.indra.sicc.entidades.seg.PaisLocalHome;

import javax.ejb.FinderException;
import es.indra.sicc.util.CodigosError;
import es.indra.sicc.util.UtilidadesError;
import es.indra.sicc.util.BelcorpService;
import es.indra.mare.common.mii.MareMiiServiceNotFoundException;
import es.indra.mare.common.mii.services.MareServiceException;

import es.indra.mare.common.dto.MareDTO;
import es.indra.mare.common.dto.IMareDTO;


import java.math.BigDecimal;
import es.indra.sicc.util.SEGEjbLocators;

import es.indra.mare.enterprise.mln.BusinessFacade;
import es.indra.mare.enterprise.mln.BusinessFacadeHome;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.rmi.PortableRemoteObject;
import java.util.Hashtable;
import es.indra.mare.common.mln.MareBusinessID;
import es.indra.sicc.logicanegocio.inc.MONIncentivosHome;
import es.indra.sicc.logicanegocio.inc.MONPremiacionHome;
import es.indra.sicc.logicanegocio.inc.MONBolsaFaltantesHome;
import es.indra.sicc.logicanegocio.inc.MONIncentivosLocalHome;
import es.indra.sicc.logicanegocio.inc.MONPremiacionLocalHome;
import es.indra.sicc.logicanegocio.inc.MONBolsaFaltantesLocalHome;
import es.indra.sicc.logicanegocio.mav.MONEnvioAgregadosBatchLocalHome;

public class MONGrupoProcesoSolicitudBean implements SessionBean  {
  SessionContext ctx = null;
  //private Boolean ejecucionOnline;
  public void setSessionContext(SessionContext ctx) {
        this.ctx=ctx;
  }      
	public void ejbCreate() {
    //this.ejecucionOnline = Boolean.FALSE;
	}

	public void ejbActivate() {
	}

	public void ejbPassivate() {
	} 

	public void ejbRemove() {
	}

    public DTOEstatusSolicitud procesarSolicitudReverso(Long oidGrupoProceso, DTOSolicitudValidacion dtoin, DTOListaProcesos procesos, Boolean online) throws MareException {
        UtilidadesLog.info("MONGrupoProcesoSolicitudBean.procesarSolicitudReverso(Long oidGrupoProceso, DTOSolicitudValidacion dtoin, DTOListaProcesos procesos): Entrada ");
        DTOEstatusSolicitud dtoEsta = new DTOEstatusSolicitud();
        
        UtilidadesLog.debug("antes de procesar");
        dtoEsta = this.procesar(dtoin,procesos,online);
        UtilidadesLog.debug("luego de procesar");
        UtilidadesLog.info("MONGrupoProcesoSolicitudBean.procesarSolicitudReverso(Long oidGrupoProceso, DTOSolicitudValidacion dtoin, DTOListaProcesos procesos): Salida ");
        return dtoEsta;
    }

    public DTOEstatusSolicitud procesarSolicitud(Long oidGrupoProceso, DTOSolicitudValidacion dtoin, DTOListaProcesos procesos, Boolean online) throws MareException {
        UtilidadesLog.info("MONGrupoProcesoSolicitudBean.procesarSolicitud(Long oidGrupoProceso, DTOSolicitudValidacion dtoin, DTOListaProcesos procesos): Entrada ");
        try{
            DAOSolicitud daoSol = new DAOSolicitud();
            if (Boolean.TRUE.equals(online)){
                if (this.validarFinalizacionGrupoAnterior( oidGrupoProceso, dtoin.getOidSolicitud(), dtoin.getOidTipoSolPais() ).booleanValue()) {
                    UtilidadesLog.info("MONGrupoProcesoSolicitudBean.procesarSolicitud(Long oidGrupoProceso, DTOSolicitudValidacion dtoin, DTOListaProcesos procesos): Salida ");
                    return this.procesar(dtoin, procesos, online);
                } else {     
                    RecordSet rs = daoSol.consultarProcesoSolicitud(dtoin.getOidSolicitud(), ConstantesSEG.IDIOMA_DEFECTO);
                    UtilidadesLog.debug("daoSol.consultarProcesoSolicitud(, retorna: " + rs); 
                    if (rs == null) {
                        UtilidadesLog.info("MONGrupoProcesoSolicitudBean.procesarSolicitud(Long oidGrupoProceso, DTOSolicitudValidacion dtoin, DTOListaProcesos procesos): Salida ");
                        LogAPP.error("La consulta de Proceso Solicitud no devolvio datos");
                        return null;
                    }
        
                    if (!(rs.getRowCount() > 0)) {
                        //APPLoggingService!!
                        LogAPP.error("La consulta de Proceso Solicitud no devolvio datos");
                    } else {
        
                        Long oidSolicitud = ( rs.getValueAt(0,0)==null ? null : new Long(((BigDecimal) rs.getValueAt(0,0)).toString()) );
                        Long numeSoli = ( rs.getValueAt(0,1)==null ? null : new Long(((BigDecimal) rs.getValueAt(0,1)).toString()) );
                        String descEstado   = ( rs.getValueAt(0,2)==null ? null : new String( rs.getValueAt(0,2).toString()));
                        String descGrupProc = ( rs.getValueAt(0,3)==null ? null : new String( rs.getValueAt(0,3).toString()));
                        String descProc     = ( rs.getValueAt(0,4)==null ? null : new String( rs.getValueAt(0,4).toString()));
                
                        //APPLoggingService!!
                        LogAPP.error("No se pudo procesar la solicitud, Oid Solicitud: " +
                                        oidSolicitud + " Nº de Solicitud: " + numeSoli + 
                                        " Estado: " + descEstado + " Grupo: " + descGrupProc +
                                        " Proceso: " + descProc);
                    }
                    UtilidadesLog.info("MONGrupoProcesoSolicitudBean.procesarSolicitud(Long oidGrupoProceso, DTOSolicitudValidacion dtoin, DTOListaProcesos procesos): Salida ");
                    return null;                        
                } 
            }else{
                return this.procesar(dtoin, procesos, online);
            }
            /*if (this.validarFinalizacionGrupoAnterior( oidGrupoProceso, dtoin.getOidSolicitud(), dtoin.getOidTipoSolPais() ).booleanValue()) {
                UtilidadesLog.info("MONGrupoProcesoSolicitudBean.procesarSolicitud(Long oidGrupoProceso, DTOSolicitudValidacion dtoin, DTOListaProcesos procesos): Salida ");*/
            
            /*} else {     
                RecordSet rs = daoSol.consultarProcesoSolicitud(dtoin.getOidSolicitud(), ConstantesSEG.IDIOMA_DEFECTO);
                UtilidadesLog.debug("daoSol.consultarProcesoSolicitud(, retorna: " + rs); 
                if (rs == null) {
                    UtilidadesLog.info("MONGrupoProcesoSolicitudBean.procesarSolicitud(Long oidGrupoProceso, DTOSolicitudValidacion dtoin, DTOListaProcesos procesos): Salida ");
                    LogAPP.error("La consulta de Proceso Solicitud no devolvio datos");
                    return null;
                }
    
                if (!(rs.getRowCount() > 0)) {
                    //APPLoggingService!!
                    LogAPP.error("La consulta de Proceso Solicitud no devolvio datos");
                } else {
    
                    Long oidSolicitud = ( rs.getValueAt(0,0)==null ? null : new Long(((BigDecimal) rs.getValueAt(0,0)).toString()) );
                    Long numeSoli = ( rs.getValueAt(0,1)==null ? null : new Long(((BigDecimal) rs.getValueAt(0,1)).toString()) );
                    String descEstado   = ( rs.getValueAt(0,2)==null ? null : new String( rs.getValueAt(0,2).toString()));
                    String descGrupProc = ( rs.getValueAt(0,3)==null ? null : new String( rs.getValueAt(0,3).toString()));
                    String descProc     = ( rs.getValueAt(0,4)==null ? null : new String( rs.getValueAt(0,4).toString()));
            
                    //APPLoggingService!!
                    LogAPP.error("No se pudo procesar la solicitud, Oid Solicitud: " +
                                    oidSolicitud + " Nº de Solicitud: " + numeSoli + 
                                    " Estado: " + descEstado + " Grupo: " + descGrupProc +
                                    " Proceso: " + descProc);
                }
                UtilidadesLog.info("MONGrupoProcesoSolicitudBean.procesarSolicitud(Long oidGrupoProceso, DTOSolicitudValidacion dtoin, DTOListaProcesos procesos): Salida ");
                return null;    
                
            }   */ 
        }catch(Exception e){
            UtilidadesLog.error("ERROR",e);
            throw new MareException(e);
        }
    }

    protected Boolean validarFinalizacionGrupoAnterior(Long oidGrupoProceso, Long oidSolicitud, Long oidTipoSolicitudPais) throws MareException {
        UtilidadesLog.info("MONGrupoProcesoSolicitudBean.validarFinalizacionGrupoAnterior(Long oidGrupoProceso, Long oidSolicitud, Long oidTipoSolicitudPais): Entrada ");
        DAOGruposProceso daoGP = new DAOGruposProceso();
        DAOSolicitud     daoSol = new DAOSolicitud();
        Long gpAnt = daoGP.obtenerGrupoProcesoAnterior(oidGrupoProceso);
        UtilidadesLog.debug("############### El gpAnt, es: " + gpAnt + "###############");
        UtilidadesLog.info("MONGrupoProcesoSolicitudBean.validarFinalizacionGrupoAnterior(Long oidGrupoProceso, Long oidSolicitud, Long oidTipoSolicitudPais): Salida ");
        return daoSol.validarFinalizacionGrupoProceso(oidSolicitud, oidTipoSolicitudPais, gpAnt);
  
    }
  
    /*protected DTOEstatusSolicitud procesar(DTOSolicitudValidacion dtoin, DTOListaProcesos procesos) throws MareException {
        UtilidadesLog.info("MONGrupoProcesoSolicitudBean.procesar(DTOSolicitudValidacion dtoin, DTOListaProcesos procesos): Entrada ");
        ArrayList listaProc = new ArrayList();
        listaProc = procesos.getListaProcesos();
        
        //ultimos estado y resultado retornado
        MareDTO ultResu   = new MareDTO();
        Long ultEstado = null;
        Long ultOidProceso = null;
        
        //Resultado
        DTOEstatusSolicitud dtoESResu = new DTOEstatusSolicitud();
        BelcorpService bs = null;
        
        
        try {
            BusinessFacadeHome bf = getBusinessFacadeHome();
            BusinessFacade businessFacade;
            businessFacade = bf.create();
            
            MonedaLocalHome mlocalHome = SEGEjbLocators.getMonedaLocalHome();
            PaisLocalHome plocalHome = SEGEjbLocators.getPaisLocalHome();
            bs = BelcorpService.getInstance();
            
            if (procesos == null) {
                dtoESResu.setEstatus(ConstantesPED.ESTADO_SOLICITUD_VALIDADO);
            } else {
                if ((listaProc != null) && (listaProc.size() > 0)) {
                
                    for(int i = 0; i < listaProc.size(); i++) {
                        DTOProceso elemDTOProc = (DTOProceso) listaProc.get(i);
                        
                        if (elemDTOProc.getCodProceso().equals(ConstantesPED.COD_PROCESO_NULO)) {
                        
                            // guardo ultimo estado.
                            ultEstado = ConstantesPED.ESTADO_SOLICITUD_VALIDADO;
                            ultOidProceso = elemDTOProc.getOidProceso();
                        } else {
                            if (dtoin.getNumDecimales() == null) {
                                if (dtoin.getOidMoneda() != null) {
                                    MonedaLocal mL = mlocalHome.findByPrimaryKey(dtoin.getOidMoneda());
                                    dtoin.setNumDecimales( new Integer(mL.getNumDeci().intValue()) );
                                } else {
                                    PaisLocal pL = plocalHome.findByPrimaryKey(dtoin.getOidPais());
                                    MonedaLocal mL = mlocalHome.findByPrimaryKey(pL.getMone_oid_mone());
                                    dtoin.setNumDecimales( new Integer(mL.getNumDeci().intValue()) );
                                
                                }
                            }                            
                            DTOEstatusSolicitud dtoES = null;
                            
                            dtoES = this.ejecutarProceso(dtoin, elemDTOProc, businessFacade);
                            
                            if ( (dtoES == null) ||
                            ((dtoES.getEstatus().longValue() != ConstantesPED.ESTADO_SOLICITUD_VALIDADO.longValue()) &&
                            (dtoES.getEstatus().longValue() != ConstantesPED.ESTADO_SOLICITUD_LIBERADO.longValue())) ) {
                            
                                //Se hacer rollback de la transaccion
                                ctx.setRollbackOnly();
                                //APPLoggingService...
                                
                                UtilidadesLog.debug("Se aborta transaccion, Oid Solicitud : " + 
                                dtoin.getOidSolicitud() + " Oid proceso: " + elemDTOProc.getOidProceso());
                                
                                bs.appLog.error("Se aborta transaccion, Oid Solicitud : " + 
                                dtoin.getOidSolicitud() + " Oid proceso: " + elemDTOProc.getOidProceso());
                                
                                //Se crea un DTOEstatusSolicitud
                                DTOEstatusSolicitud dtoES1 = new DTOEstatusSolicitud();
                                dtoES1.setOidProceso( elemDTOProc.getOidProceso() );
                                if (dtoES == null){
                                    dtoES1.setEstatus( ConstantesPED.ESTADO_SOLICITUD_ERRONEO );
                                }else{
                                    dtoES1.setEstatus( dtoES.getEstatus() );
                                }
                                
                                return dtoES1;
                            
                            } else {
                                ultOidProceso = elemDTOProc.getOidProceso();           
                                if (dtoES.getResultado() != null) {
                                    ultResu   = dtoES.getResultado();
                                    ultEstado = dtoES.getEstatus();
                                }                            
                            }                        
                        }                    
                    } //for...
                }
                dtoESResu.setOidProceso(ultOidProceso);
                if (ultEstado == null) {
                    dtoESResu.setEstatus(ConstantesPED.ESTADO_SOLICITUD_VALIDADO);
                } else {
                    dtoESResu.setEstatus(ultEstado);
                    dtoESResu.setResultado(ultResu);
                }
            }
        } catch(Exception ex){
           bs.appLog.error("Error en Procesar (GrupoProcesoSolicitud)", ex);
        }
        UtilidadesLog.info("MONGrupoProcesoSolicitudBean.procesar(DTOSolicitudValidacion dtoin, DTOListaProcesos procesos): Salida ");
        return dtoESResu;
    }*/
    
    protected DTOEstatusSolicitud procesar(DTOSolicitudValidacion dtoin, DTOListaProcesos procesos, Boolean online) throws MareException {
        UtilidadesLog.info("MONGrupoProcesoSolicitudBean.procesar(DTOSolicitudValidacion dtoin, DTOListaProcesos procesos): Entrada ");
        ArrayList listaProc = new ArrayList();
        listaProc = procesos.getListaProcesos();
        
        DTOEstatusSolicitud dtoES = null;
        //Resultado
        DTOEstatusSolicitud dtoESResu = new DTOEstatusSolicitud();
        
        try {
            if (procesos == null) {
                dtoESResu.setEstatus(ConstantesPED.ESTADO_SOLICITUD_VALIDADO);
            } else {
                if ((listaProc != null) && (listaProc.size() > 0)) {
                    MegaProcesadorGPs procesador = new MegaProcesadorGPs();
                    dtoES = (DTOEstatusSolicitud)procesador.ejecutarGP2Y4(dtoin, listaProc, online);
                    if ( (dtoES == null) ||
                    ((dtoES.getEstatus().longValue() != ConstantesPED.ESTADO_SOLICITUD_VALIDADO.longValue()) &&
                    (dtoES.getEstatus().longValue() != ConstantesPED.ESTADO_SOLICITUD_LIBERADO.longValue())) ) {
                        ctx.setRollbackOnly();
                        
                        //Se crea un DTOEstatusSolicitud
                        DTOEstatusSolicitud dtoES1 = new DTOEstatusSolicitud();
                        //dtoES1.setOidProceso( elemDTOProc.getOidProceso() );
                        if (dtoES == null){
                            dtoES1.setEstatus( ConstantesPED.ESTADO_SOLICITUD_ERRONEO );
                        }else{
                            dtoES1.setEstatus( dtoES.getEstatus() );
                        }
                        if (MegaProcesadorGPs.solicitudesConcursoEnEjecucion!=null && MegaProcesadorGPs.solicitudesConcursoEnEjecucion.containsKey(dtoin.getOidSolicitud())){
                            MegaProcesadorGPs.solicitudesConcursoEnEjecucion.remove(dtoin.getOidSolicitud());
                        }
                        return dtoES1;                    
                    }else{
                        if (MegaProcesadorGPs.solicitudesConcursoEnEjecucion!=null && MegaProcesadorGPs.solicitudesConcursoEnEjecucion.containsKey(dtoin.getOidSolicitud())){
                            MegaProcesadorGPs.solicitudesConcursoEnEjecucion.remove(dtoin.getOidSolicitud());
                        }
                        return dtoES;
                    }                    
                }
            }
        } catch(Exception ex){
            UtilidadesLog.error("Error en Procesar (GrupoProcesoSolicitud)", ex);
            LogAPP.error("Error en Procesar (GrupoProcesoSolicitud)", ex);
        }
        UtilidadesLog.info("MONGrupoProcesoSolicitudBean.procesar(DTOSolicitudValidacion dtoin, DTOListaProcesos procesos): Salida ");
        return dtoESResu;
    }
  
    protected DTOEstatusSolicitud ejecutarProceso(DTOSolicitudValidacion solicitud, DTOProceso proceso, BusinessFacade businessFacade) throws MareException {
        UtilidadesLog.info("MONGrupoProcesoSolicitudBean.ejecutarProceso(DTOSolicitudValidacion solicitud, DTOProceso proceso): Entrada ");
        try {
           Date date1 = new Date();
           UtilidadesLog.debug("dentro de ejecutarProceso(...."); 
    
           MareBusinessID id = new MareBusinessID(proceso.getBusinessID());
    
           solicitud.setProceso(proceso);
    
           DTOEstatusSolicitud dtoResu = new DTOEstatusSolicitud();
    
           UtilidadesLog.debug("voy a : businessFacade.execute(..., con: " + solicitud + " - " + id);
           UtilidadesLog.debug("por aca el pais del dto solicitud, es: " + solicitud.getOidPais());
           
           dtoResu = (DTOEstatusSolicitud)businessFacade.execute(solicitud, id);
           UtilidadesLog.info("MONGrupoProcesoSolicitudBean.ejecutarProceso(DTOSolicitudValidacion solicitud, DTOProceso proceso): Salida ");
           Date date2 = new Date();
           UtilidadesLog.warn("Solicitud "+solicitud.getOidSolicitud()+" - Proceso "+proceso.getCodProceso()+" ("+proceso.getBusinessID()+") "+" ->>> "+ (date2.getTime()-date1.getTime()));
           return dtoResu;
           
        } catch(Throwable ex) {
            UtilidadesLog.error("Exception: ",ex);
            UtilidadesLog.info("MONGrupoProcesoSolicitudBean.ejecutarProceso(DTOSolicitudValidacion solicitud, DTOProceso proceso): Salida ");
            return null;
        }
    }

  private BusinessFacadeHome getBusinessFacadeHome() throws NamingException {
    final InitialContext context = new InitialContext();
    return (BusinessFacadeHome)PortableRemoteObject.narrow(context.lookup("java:comp/env/BusinessFacade"), BusinessFacadeHome.class);
  }

  public DTOEstatusSolicitud procesarSolicitudOnLine(Long oidGrupoProceso, DTOSolicitudValidacion dtoin, DTOListaProcesos procesos) throws MareException {
    //this.ejecucionOnline = Boolean.TRUE;
    //return this.procesar(oidGrupoProceso, dtoin, procesos);
    return this.procesarSolicitud(oidGrupoProceso, dtoin, procesos, Boolean.TRUE);
  }

  public DTOEstatusSolicitud procesarSolicitudReversoOnline(Long oidGrupoProceso, DTOSolicitudValidacion dtoin, DTOListaProcesos procesos) throws MareException {
    return this.procesarSolicitudReverso(oidGrupoProceso, dtoin, procesos, Boolean.TRUE);
  }

  private MONValidacionCuadreOfertasHome getMONValidacionCuadreOfertasHome() throws NamingException
  {
    final InitialContext context = new InitialContext();
    return (MONValidacionCuadreOfertasHome)PortableRemoteObject.narrow(context.lookup("java:comp/env/MONValidacionCuadreOfertas"), MONValidacionCuadreOfertasHome.class);
  }

  private MONPEDValidacionHome getMONPEDValidacionHome() throws NamingException
  {
    final InitialContext context = new InitialContext();
    return (MONPEDValidacionHome)PortableRemoteObject.narrow(context.lookup("java:comp/env/MONPEDValidacion"), MONPEDValidacionHome.class);
  }

  private MONIncentivosHome getMONIncentivosHome() throws NamingException
  {
    final InitialContext context = new InitialContext();
    return (MONIncentivosHome)PortableRemoteObject.narrow(context.lookup("java:comp/env/MONIncentivos"), MONIncentivosHome.class);
  }

  private MONPremiacionHome getMONPremiacionHome() throws NamingException
  {
    final InitialContext context = new InitialContext();
    return (MONPremiacionHome)PortableRemoteObject.narrow(context.lookup("java:comp/env/MONPremiacion"), MONPremiacionHome.class);
  }

  private MONBolsaFaltantesHome getMONBolsaFaltantesHome() throws NamingException
  {
    final InitialContext context = new InitialContext();
    return (MONBolsaFaltantesHome)PortableRemoteObject.narrow(context.lookup("java:comp/env/MONBolsaFaltantes"), MONBolsaFaltantesHome.class);
  }

    private MONPEDValidacionLocalHome getMONPEDValidacionLocalHome() throws NamingException
    {
        final InitialContext context = new InitialContext();
        return (MONPEDValidacionLocalHome)context.lookup("java:comp/env/ejb/local/MONPEDValidacion");
    }

    private MONValidacionCuadreOfertasLocalHome getMONValidacionCuadreOfertasLocalHome() throws NamingException
    {
        final InitialContext context = new InitialContext();
        return (MONValidacionCuadreOfertasLocalHome)context.lookup("java:comp/env/ejb/local/MONValidacionCuadreOfertas");
    }

    private MONReversionCuadreOfertasLocalHome getMONReversionCuadreOfertasLocalHome() throws NamingException
    {
        final InitialContext context = new InitialContext();
        return (MONReversionCuadreOfertasLocalHome)context.lookup("java:comp/env/ejb/local/MONReversionCuadreOfertas");
    }

    private MONIncentivosLocalHome getMONIncentivosLocalHome() throws NamingException
    {
        final InitialContext context = new InitialContext();
        return (MONIncentivosLocalHome)context.lookup("java:comp/env/ejb/local/MONIncentivos");
    }

    private MONPremiacionLocalHome getMONPremiacionLocalHome() throws NamingException
    {
        final InitialContext context = new InitialContext();
        return (MONPremiacionLocalHome)context.lookup("java:comp/env/ejb/local/MONPremiacion");
    }

    private MONBolsaFaltantesLocalHome getMONBolsaFaltantesLocalHome() throws NamingException
    {
        final InitialContext context = new InitialContext();
        return (MONBolsaFaltantesLocalHome)context.lookup("java:comp/env/ejb/local/MONBolsaFaltantes");
    }

    private MONEnvioAgregadosBatchLocalHome getMONEnvioAgregadosBatchLocalHome() throws NamingException
    {
        final InitialContext context = new InitialContext();
        return (MONEnvioAgregadosBatchLocalHome)context.lookup("java:comp/env/MONEnvioAgregadosBatch");
    }
}