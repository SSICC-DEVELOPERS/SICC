package es.indra.sicc.logicanegocio.ped;

import es.indra.mare.common.dto.MareDTO;
import es.indra.mare.common.exception.MareException;
import es.indra.mare.common.mgc.MareMGC;
import es.indra.mare.common.mii.MareMii;
import es.indra.mare.common.mii.MareTopic;
import es.indra.mare.common.mii.services.jdbcservice.RecordSet;
import es.indra.mare.common.mln.MareBusinessID;
import es.indra.sicc.cmn.negocio.batch.DTOBatch;
import es.indra.sicc.cmn.negocio.batch.DTOSubBatch;
import es.indra.sicc.cmn.negocio.batch.MONBatch;
import es.indra.sicc.cmn.negocio.batch.util.BatchUtil;
import es.indra.sicc.dtos.ped.DTOEjecucionProcesos;
import es.indra.sicc.dtos.ped.DTOEstatusSolicitud;
import es.indra.sicc.dtos.ped.DTOListaProcesos;
import es.indra.sicc.dtos.ped.DTOProcesoAnterior;
import es.indra.sicc.dtos.ped.DTOSeguimientoPedidos;
import es.indra.sicc.dtos.ped.DTOSolicitudValidacion;
import es.indra.sicc.util.BelcorpService;
import es.indra.sicc.util.CodigosError;
import es.indra.sicc.util.LogAPP;
import es.indra.sicc.util.PEDEjbLocators;
import es.indra.sicc.util.SEGEjbLocators;
import es.indra.sicc.util.UtilidadesEJB;
import es.indra.sicc.util.UtilidadesError;

import es.indra.sicc.util.UtilidadesLog;
import java.math.BigDecimal;
import java.rmi.RemoteException;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;

import java.util.ListIterator;
import javax.ejb.CreateException;
import javax.ejb.SessionBean;
import javax.ejb.SessionContext;

import javax.naming.InitialContext;
import javax.naming.NamingException;

import javax.rmi.PortableRemoteObject;

import es.indra.sicc.logicanegocio.seg.MONMantenimientoSEG;
import es.indra.sicc.logicanegocio.seg.MONMantenimientoSEGHome;

import es.indra.sicc.logicanegocio.seg.ConstantesSEG;
import es.indra.sicc.cmn.negocio.batch.DTOSalidaBatch;
import es.indra.mare.enterprise.mln.BusinessFacadeLocalHome;
import es.indra.sicc.cmn.negocio.i18n.Entidadi18nLocalHome;

import es.indra.sicc.dtos.msg.ConstantesMSG;
import es.indra.sicc.entidades.fac.TiposCierreLocal;
import es.indra.sicc.entidades.fac.TiposCierreLocalHome;
import es.indra.sicc.entidades.msg.MensajesLocal;
import es.indra.sicc.entidades.msg.MensajesLocalHome;

import es.indra.sicc.entidades.ped.TiposSolicitudPaisLocal;
import es.indra.sicc.entidades.ped.TiposSolicitudPaisLocalHome;

import java.util.Collection;

import javax.persistence.NoResultException;

public class MONGrupoProcesoBean implements SessionBean  {
  private SessionContext ctx;
  private ArrayList listaSolicitudes;
  private Long oidGrupoProceso;
  private DTOListaProcesos listaProcesos;
  private Long[] subAccesosCALLCENTER = null;
  private static Long tamanioSubSegmento = null;
  private String IDProc;
  private String user;
  private static UtilidadesLog logAux = new UtilidadesLog();
  
   // sapaza -- Ajuste Segmentacion SICC -- 26/09/2014
   private static String tipoSegmentacion;
   private String codigoBatch;
  
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
  
  /*
   * Autor: Cortaberria
   * Fecha: 18/05/2005
   * Creado por incidencia 18097
   */
  protected MareDTO procesar(DTOEjecucionProcesos dtoin, Boolean online) throws MareException {
    UtilidadesLog.warn("**********************************************************************************");
    UtilidadesLog.warn("***************************EMPEZO LA EJECUCION************************************");
    UtilidadesLog.warn("**********************************************************************************");
    java.util.Date date1= new java.util.Date();
    UtilidadesLog.info("MONGrupoProcesoBean.procesar(DTOEjecucionProcesos dtoin, Boolean online): Entrada ");
    //Inc.:BELC300007602 
    MareDTO dtoR = null;
    try {
        
       //doliva -- cambio Optimizacion Logs -- 09/04/2010 
       if(logAux.isDebugEnabled())
        UtilidadesLog.debug("Estando en: MONGrupoProceso.procesar, dtoin, es: " + dtoin);
       
       DTOListaProcesos dtoLP = new DTOListaProcesos();

       this.obtenerSubAcessosCallCenter();
       this.listaSolicitudes = dtoin.getListaSolicitudes();

        //doliva -- cambio Optimizacion Logs -- 09/04/2010 
       if(logAux.isDebugEnabled())
            UtilidadesLog.debug("y la lista de solicitudes, es: " + this.listaSolicitudes); 
       
       this.oidGrupoProceso = dtoin.getOidGrupoProcesos();

       DAOGruposProceso daoGP = new DAOGruposProceso();
       if (dtoin != null) {
         dtoLP = daoGP.obtenerGrupoProcesos(dtoin.getOidGrupoProcesos(), dtoin.getOidTipoSolicitud());
         this.listaProcesos = dtoLP;
       } 
        UtilidadesLog.info("MONGrupoProcesoBean.procesar(DTOEjecucionProcesos dtoin, Boolean online): Salida ");
        dtoR = this.procesarSolicitudes(online);
    } catch(Exception ex){
        UtilidadesLog.error("Error al ejecutar: Ejecutar: ", ex);
        LogAPP.error("Error al ejecutar: Ejecutar: ", ex);
    }
    java.util.Date date2= new java.util.Date();
    UtilidadesLog.warn("**********************************************************************************");
    UtilidadesLog.warn("*************************FINALIZO LA EJECUCION************************************");
    UtilidadesLog.warn("*************************TIEMPO TOTAL: "+(date2.getTime()-date1.getTime())+"*****************************");
    UtilidadesLog.warn("**********************************************************************************");
    return dtoR;
  }
  
  /*
   * Autor: Cortaberria
   * Fecha: 18/05/2005
   * Modificado por incidencia 18097
   */
  public MareDTO ejecutar(DTOEjecucionProcesos dtoin) throws MareException {
    UtilidadesLog.info("MONGrupoProcesoBean.ejecutar(DTOEjecucionProcesos dtoin): Entrada ");
    UtilidadesLog.info("MONGrupoProcesoBean.ejecutar(DTOEjecucionProcesos dtoin): Salida ");
    return this.procesar(dtoin, Boolean.TRUE);
  } 

  /*
   * Autor: Cortaberria
   * Fecha: 18/05/2005
   * Modificado por incidencia 18097
   */
  public DTOSalidaBatch ejecutarBatch(DTOBatch dtoin) throws MareException { 
    UtilidadesLog.info("MONGrupoProcesoBean.ejecutarBatch(DTOBatch dtoin): Entrada ");
    MareDTO dtoonline = (MareDTO)dtoin.getDTOOnline();
    
    if (dtoonline instanceof DTOEjecucionProcesos) {
      this.procesar((DTOEjecucionProcesos)dtoonline, Boolean.FALSE);
        UtilidadesLog.info("MONGrupoProcesoBean.ejecutarBatch(DTOBatch dtoin): Salida ");
      return new DTOSalidaBatch(0,"Ejecucion MONGrupoProceso:ejecutarBatch completada");  
    } else {
        UtilidadesLog.info("MONGrupoProcesoBean.ejecutarBatch(DTOBatch dtoin): Salida ");
      throw new MareException(null, null, UtilidadesError.armarCodigoError("1", "", ErroresNegocio.PED_025));
    }    
  } 
  
  /*
   * Autor: Cortaberria
   * Fecha: 18/05/2005
   * Modificado por incidencia 18097
   */
  protected MareDTO procesarSolicitudes(Boolean online) throws MareException {
    UtilidadesLog.info("MONGrupoProcesoBean.procesarSolicitudes(Boolean online): Entrada ");
    ArrayList lista = new ArrayList();
    ArrayList listaRechazada = new ArrayList();
    UtilidadesLog.debug("#################### ENTRANDO EN: procesarSolicitudes() #######################");
    lista = listaSolicitudes;
    DAOSolicitud daoSol = new DAOSolicitud();
    MareDTO dtoResu = new MareDTO();

    if ((lista != null) && (lista.size() > 0)) { 
    
      try {
        //doliva -- cambio Optimizacion Logs -- 09/04/2010
        if(logAux.isDebugEnabled())
            UtilidadesLog.debug("la lista de solicitudes, mide: " + lista.size());
            
        if(!Boolean.TRUE.equals(online)) {
           lista = daoSol.validarFinalizacionGrupoProceso(lista, new DAOGruposProceso().obtenerGrupoProcesoAnterior(oidGrupoProceso));
        }
        int size = lista.size();
        for (int i = 0; i < size; i++) {
          DTOEstatusSolicitud dtoES = null;
          if(Boolean.TRUE.equals(online)) {
            DTOSolicitudValidacion dtoSolicitud = (DTOSolicitudValidacion)lista.get(i);
            
            // sapaza -- PER-SiCC-2011-0726 -- 12/12/2011
            if(dtoSolicitud.getIndRecepcionOnline()!=null && dtoSolicitud.getIndRecepcionOnline()) 
                dtoES = getMONGrupoProcesoSolicitudLocalHome().create().procesarSolicitud(oidGrupoProceso, dtoSolicitud, listaProcesos, Boolean.TRUE);
            else    
                dtoES = getMONGrupoProcesoSolicitudLocalHome().create().procesarSolicitudOnLine(oidGrupoProceso, dtoSolicitud, listaProcesos);
            
            if (dtoES != null) {
              if ( (dtoES.getEstatus().longValue() == ConstantesPED.ESTADO_SOLICITUD_VALIDADO.longValue()) ||
                   (dtoES.getEstatus().longValue() == ConstantesPED.ESTADO_SOLICITUD_LIBERADO.longValue()) ) {
    
                // sapaza -- PER-SiCC-2011-0477 -- 08/07/2011
                //this.actualizarSeguimientoPedido( ((DTOSolicitudValidacion)lista.get(i)), oidGrupoProceso);

                // sapaza -- PER-SiCC-2011-0726 -- 12/12/2011
                if(dtoSolicitud.getIndRecepcionOnline()!=null && dtoSolicitud.getIndRecepcionOnline())
                    this.getMONGrupoProcesoLocal().actualizarProcesoSolicitud(((DTOSolicitudValidacion)lista.get(i)).getOidSolicitud(), 
                                                    oidGrupoProceso, dtoES.getOidProceso(), dtoES.getEstatus());
                else
                    daoSol.actualizarProcesoSolicitud(((DTOSolicitudValidacion)lista.get(i)).getOidSolicitud(), oidGrupoProceso, 
                                                           dtoES.getOidProceso(), dtoES.getEstatus());
              } else {
                       //metodo actualizarEstado del DAOSolicitud 
                 //doliva -- cambio Optimizacion Logs -- 09/04/2010      
                 if(logAux.isDebugEnabled()){
                     UtilidadesLog.debug("actualizo estado de solicitud: " + ((DTOSolicitudValidacion)lista.get(i)).getOidSolicitud());
                     UtilidadesLog.debug("a estado: " + dtoES.getEstatus().toString());
                 }
                 
                 daoSol.actualizarEstado( ((DTOSolicitudValidacion)lista.get(i)).getOidSolicitud() , new Integer(dtoES.getEstatus().toString()) );
              }

                    // gPineda - 15/01/2007 - V_PED_12
              if( ConstantesPED.ESTADO_SOLICITUD_RECHAZADO.equals( dtoES.getEstatus() )  ){
                 daoSol.actualizarSolicitudRechazo( (DTOSolicitudValidacion)lista.get(i) );
              }
                        
              UtilidadesLog.debug("procesarSolicitudes(); actualice estado.......");
    
                   //de acuerdo al ult. corrido acumulo el resultado
              if (dtoES.getResultado() != null) {
                 dtoResu = dtoES.getResultado();            
              }
           }
         } else {
            dtoResu = this.getMONGrupoProcesoLocal().procesarSolicitud(oidGrupoProceso, (DTOSolicitudValidacion)lista.get(i),listaProcesos);
         }
              
       } //for
       UtilidadesLog.info("MONGrupoProcesoBean.procesarSolicitudes(Boolean online): Salida ");
       return dtoResu;
     } catch(Exception e) {
       UtilidadesLog.error("ERROR",e);
       throw new MareException(e);
     }
   }
   UtilidadesLog.info("MONGrupoProcesoBean.procesarSolicitudes(Boolean online): Salida ");
   return null;
  }
  //29/03/2005: rgiorgi: inc. 15417.
  /*
   * Autor: Cortaberria
   * Fecha: 18/05/2005
   * Modifico visibilidad
   * SCS 16/02/2006, se agrega oid de g. de proceso a la funcion 
   */
  protected void actualizarSeguimientoPedido(DTOSolicitudValidacion dtoin, Long oidGP) throws MareException {
    UtilidadesLog.info("MONGrupoProcesoBean.actualizarSeguimientoPedido(DTOSolicitudValidacion dtoin): Entrada ");
    
    //doliva -- cambio Optimizacion Logs -- 09/04/2010
    if(logAux.isDebugEnabled())
        UtilidadesLog.debug("MONGrupoProcesoBean.actualizarSeguimientoPedido(DTOSolicitudValidacion dtoin): " + dtoin);
    
    if (dtoin != null) {

        //doliva -- cambio Optimizacion Logs -- 09/04/2010
        if(logAux.isDebugEnabled())
            UtilidadesLog.debug("oidGP: " + oidGP);

        if ( (oidGP.longValue() == ConstantesPED.GP2.longValue()) && 
             (dtoin.getIndOrdenCompra().booleanValue() == true) &&
             ((dtoin.getIndPedGTZona().booleanValue() == true) ||
               ((this.contenidoEnCALLCENTER(dtoin.getOidSubAcceso())!= null && //si el subacceso no es de callCenter ==> nullPointer
                 this.contenidoEnCALLCENTER(dtoin.getOidSubAcceso()).booleanValue() == true)))
            ){  

             DTOSeguimientoPedidos dtoSP = new DTOSeguimientoPedidos();
         
             dtoSP.setSolicitud(dtoin.getOidSolicitud());

             dtoSP.setHitoSeguimiento(ConstantesPED.HITO_02);
             dtoSP.setTipoDocumento(ConstantesPED.TIPO_DOCUMENTO_PEDIDO);
             
             try {
                 //doliva -- cambio Optimizacion Logs -- 09/04/2010
                 if(logAux.isDebugEnabled())
                     UtilidadesLog.debug("voy a actualizarSeguimientoPedidos con: " + dtoSP);
                     
                getMONSeguimientoPedidosLocalHome().create().actualizarSeguimientoPedidos(dtoSP);
            
             } catch(NamingException re) {
                throw new MareException(re, UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
             } catch(CreateException ce) {
                throw new MareException(ce, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS) );               
             }
      
            }
    }   
    UtilidadesLog.info("MONGrupoProcesoBean.actualizarSeguimientoPedido(DTOSolicitudValidacion dtoin): Salida ");
  }
  
  /*
   * Autor: Cortaberria
   * Fecha: 18/05/2005
   * Modifico visibilidad
   */
  protected void cargarProcesos(Long oidGrupoProceso, Long oidTipoSolcitiudPais) throws MareException {
    UtilidadesLog.info("MONGrupoProcesoBean.cargarProcesos(Long oidGrupoProceso, Long oidTipoSolcitiudPais): Entrada ");
    DAOGruposProceso daoGP = new DAOGruposProceso();
    listaProcesos = daoGP.obtenerGrupoProcesos(oidGrupoProceso, oidTipoSolcitiudPais);
    UtilidadesLog.info("MONGrupoProcesoBean.cargarProcesos(Long oidGrupoProceso, Long oidTipoSolcitiudPais): Salida ");
  }
  
  
  /*
   * Autor: Cortaberria
   * Fecha: 18/05/2005
   * Modifico visibilidad
   */
	protected void reversarSolicitudes(Boolean online) throws MareException {
    UtilidadesLog.info("MONGrupoProcesoBean.reversarSolicitudes(Boolean online): Entrada ");
    try  {

      DTOEstatusSolicitud miDtoEst = null;  
      DTOProcesoAnterior miDtoProcAnt = null;
      Iterator it = listaSolicitudes.iterator();
      DAOSolicitud miDao = new DAOSolicitud(); 
      MONSeguimientoPedidosLocalHome monSegH = this.getMONSeguimientoPedidosLocalHome();
      MONGrupoProcesoSolicitudLocalHome miGPShome = this.getMONGrupoProcesoSolicitudLocalHome();
	  MONGrupoProcesoSolicitudLocal miGPS = miGPShome.create();

      UtilidadesLog.debug("it, mide: " + listaSolicitudes.size());

      while (it.hasNext()) {

        UtilidadesLog.debug("itero solicitudes");

        DTOSolicitudValidacion dtoSol = (DTOSolicitudValidacion) it.next();

        UtilidadesLog.debug("antes de miGPS.procesarSolicitudReverso(....");
        if(Boolean.TRUE.equals(online) ) {
          miDtoEst = miGPS.procesarSolicitudReversoOnline(oidGrupoProceso,dtoSol,listaProcesos);
        } else {
          miDtoEst = miGPS.procesarSolicitudReverso(oidGrupoProceso,dtoSol,listaProcesos, Boolean.FALSE);
        }
        UtilidadesLog.debug("luego de miGPS.procesarSolicitudReverso(....");

        UtilidadesLog.debug("miDtoEst, es: " + miDtoEst);


         if ((miDtoEst != null) && (miDtoEst.getEstatus() != null)) {
		    if (miDtoEst.getEstatus().longValue() == ConstantesPED.ESTADO_SOLICITUD_VALIDADO.longValue()) {
             
          DTOSeguimientoPedidos dtoSeg = new DTOSeguimientoPedidos();
          miDtoProcAnt = obtenerUltimoProcesoGPAnterior(dtoSol.getOidTipoSolPais());
          //incidencia 7400
          UtilidadesLog.debug(".............. a punto de tirar para atras solicitud ............");
          miDao.actualizarProcesoSolicitud(dtoSol.getOidSolicitud(),
                                           miDtoProcAnt.getOidGrupoProceso(),
                                           miDtoProcAnt.getOidProceso(),
                                           miDtoEst.getEstatus());
                                           
          MONSeguimientoPedidosLocal monSeg = monSegH.create();

          //ac� incidencia 7404 dtoSeg.setHitoSeguimiento(new Long(0));
          dtoSeg.setHitoSeguimiento(ConstantesPED.HITO_01);

          dtoSeg.setSolicitud(dtoSol.getOidSolicitud());

          UtilidadesLog.debug("antes de: monSeg.eliminarHitosPosteriores(dtoSeg)");
          monSeg.eliminarHitosPosteriores(dtoSeg);
          UtilidadesLog.debug("luego de: monSeg.eliminarHitosPosteriores(dtoSeg)");
    		}
         }  
 
	    }

    } catch (CreateException cx)  {
            throw new MareException(cx,
                UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
    } catch (NamingException nx){
            throw new MareException(nx,
                UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
	}
    UtilidadesLog.info("MONGrupoProcesoBean.reversarSolicitudes(Boolean online): Salida ");
}
  
  /*
   * Autor: Cortaberria
   * Fecha: 18/05/2005
   * Creado por incidencia 18097
   */
    protected void procesarReverso(DTOEjecucionProcesos dtoin, Boolean online) throws MareException {
        UtilidadesLog.info("MONGrupoProcesoBean.procesarReverso(DTOEjecucionProcesos dtoin, Boolean online): Entrada ");
        
        listaSolicitudes = dtoin.getListaSolicitudes();
        oidGrupoProceso = dtoin.getOidGrupoProcesos();
        DAOGruposProceso miDao = new DAOGruposProceso();
        try {
            listaProcesos = miDao.obtenerGrupoProcesosReverso(oidGrupoProceso, dtoin.getOidTipoSolicitud());
            reversarSolicitudes(online);
        }catch (MareException e) {
            LogAPP.error("",e);
        }
        UtilidadesLog.info("MONGrupoProcesoBean.procesarReverso(DTOEjecucionProcesos dtoin, Boolean online): Salida ");
    }
  
  /*
   * Autor: Cortaberria
   * Fecha: 18/05/2005
   * Modificado por incidencia 18097
   */
	public void reversar(DTOEjecucionProcesos dtoin) throws MareException {
        UtilidadesLog.info("MONGrupoProcesoBean.reversar(DTOEjecucionProcesos dtoin): Entrada ");    
        this.procesarReverso(dtoin, Boolean.TRUE);
        UtilidadesLog.info("MONGrupoProcesoBean.reversar(DTOEjecucionProcesos dtoin): Salida ");    
  }
  
  /*
   * Autor: Cortaberria
   * Fecha: 18/05/2005
   * Modificado por incidencia 18097
   */
	public DTOSalidaBatch reversarBatch(DTOBatch dtoin) throws MareException {
        UtilidadesLog.info("MONGrupoProcesoBean.reversarBatch(DTOBatch dtoin): Entrada ");
        MareDTO dtoonline = (MareDTO)dtoin.getDTOOnline();
        if (dtoonline instanceof DTOEjecucionProcesos) {
            UtilidadesLog.debug("llamo a reversar..."); 
            this.procesarReverso((DTOEjecucionProcesos)dtoonline, Boolean.FALSE);
            UtilidadesLog.debug("llame a reversar...");
            UtilidadesLog.info("MONGrupoProcesoBean.reversarBatch(DTOBatch dtoin): Salida ");
            return new DTOSalidaBatch(0,"Ejecucion MONGrupoProceso:reversarBatch completada");  
        } else {
            UtilidadesLog.info("MONGrupoProcesoBean.reversarBatch(DTOBatch dtoin): Salida ");
            throw new MareException(null, null, UtilidadesError.armarCodigoError("1", "", ErroresNegocio.PED_025));
        }
	}
  
  /*
   * Autor: Cortaberria
   * Fecha: 18/05/2005
   * Modifico visibilidad
   */
	protected DTOProcesoAnterior obtenerUltimoProcesoGPAnterior(Long oidTipoSolicitud) throws MareException {
    UtilidadesLog.info("MONGrupoProcesoBean.obtenerUltimoProcesoGPAnterior(Long oidTipoSolicitud): Entrada ");
    Long ultimoProc;
    Long gProcAnt;
    Long oidTipoSol;
    //oidTipoSol = null;
    DAOGruposProceso miDao = new DAOGruposProceso();
    
	  gProcAnt= miDao.obtenerGrupoProcesoAnterior(oidGrupoProceso);
	  ultimoProc= miDao.obtenerUltimoProcesoGP(gProcAnt,oidTipoSolicitud);
    DTOProcesoAnterior miDto = new DTOProcesoAnterior();
	  miDto.setOidGrupoProceso(gProcAnt);
	  miDto.setOidProceso(ultimoProc);  
    UtilidadesLog.info("MONGrupoProcesoBean.obtenerUltimoProcesoGPAnterior(Long oidTipoSolicitud): Salida ");
    return miDto;
	}

  private MONSeguimientoPedidosHome getMONSeguimientoPedidosHome() throws NamingException {
    final InitialContext context = new InitialContext();
    return (MONSeguimientoPedidosHome)PortableRemoteObject.narrow(context.lookup("java:comp/env/MONSeguimientoPedidos"), MONSeguimientoPedidosHome.class);
  }

  private MONGrupoProcesoSolicitudHome getMONGrupoProcesoSolicitudHome() throws NamingException {
    final InitialContext context = new InitialContext();
    return (MONGrupoProcesoSolicitudHome)PortableRemoteObject.narrow(context.lookup("java:comp/env/MONGrupoProcesoSolicitud"), MONGrupoProcesoSolicitudHome.class);
  }

  protected void obtenerSubAcessosCallCenter() throws MareException {
     //el codigo de acceso, debe no ser hard-code, inc.
    UtilidadesLog.info("MONGrupoProcesoBean.obtenerSubAcessosCallCenter(): Entrada ");
     try {
     
        if (subAccesosCALLCENTER== null){
            Long[] oidSbac = SEGEjbLocators.getMONMantenimientoSEGHome().create().obtenerSubAccesosPorCodigoAcceso("'"+ConstantesSEG.ACCESO_CALLCENTER+"'");
            subAccesosCALLCENTER = oidSbac;
        }

     } catch(CreateException ce) {
            throw new MareException(ce,        
                UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS) );         
     } catch(RemoteException re) {
            throw new MareException(re,
                UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
     }                
    UtilidadesLog.info("MONGrupoProcesoBean.obtenerSubAcessosCallCenter(): Salida ");
  }
  
  private Boolean contenidoEnCALLCENTER(Long oidSubAcceso) throws MareException {
    UtilidadesLog.info("MONGrupoProcesoBean.contenidoEnCALLCENTER(Long oidSubAcceso): Entrada ");
     //recorro el array y veo si el oid esta dentro del suso dicho.
     if (this.subAccesosCALLCENTER != null){
         for (int i = 0; i < this.subAccesosCALLCENTER.length; i++) {
            if (subAccesosCALLCENTER[i] !=null && oidSubAcceso != null && ((Long)subAccesosCALLCENTER[i]).longValue() == oidSubAcceso.longValue()) {
                UtilidadesLog.info("MONGrupoProcesoBean.: Entrada ");
                return Boolean.TRUE;
            }
         }
     }
    UtilidadesLog.info("MONGrupoProcesoBean.contenidoEnCALLCENTER(Long oidSubAcceso): Salida ");
    return Boolean.FALSE;
     
  }

 protected void obtenerTamanioSegmentosGP2y4(Long grupoProceso) throws MareException {
   UtilidadesLog.info("MONGrupoProceso.obtenerTamanioSegmentosGP2y4(Long grupoProceso): Entrada ");
   DAOSolicitud daoSolicitud = new DAOSolicitud();
     
   // sapaza -- Ajuste Segmentacion SICC -- 26/09/2014
   if(this.tipoSegmentacion.equals(ConstantesPED.TIPO_SEGMENTACION_PROPERTIES)) {
       MareMGC mgc = (MareMGC) MareMii.getService(new MareTopic(MareMii.SERVICE_MGC));
       String salida = "";
       if (grupoProceso.longValue() == ConstantesPED.GP2.longValue()) {
          salida = (String) mgc.getProperty("application.TamanioSubSegmentosGP2");
       } else if (grupoProceso.longValue() == ConstantesPED.GP4.longValue()) {
          salida = (String) mgc.getProperty("application.TamanioSubSegmentosGP4");
       }   
       if ((salida == null) || (salida.equals(""))) {
         UtilidadesLog.warn("No existe parametro de Segmentacion para GP2 o GP4, se tomara 10 como segmento ");
         this.tamanioSubSegmento = new Long(10);           
       } else {
         this.tamanioSubSegmento = new Long(salida);
       }
   }
   
     if(this.tipoSegmentacion.equals(ConstantesPED.TIPO_SEGMENTACION_MANUAL) || 
          this.tipoSegmentacion.equals(ConstantesPED.TIPO_SEGMENTACION_AUTOMATICO)) {
         
         if (grupoProceso.longValue() == ConstantesPED.GP2.longValue()) {
             this.tamanioSubSegmento = new Long(daoSolicitud.obtenerTamanioSubSegmento(this.codigoBatch, "GP2"));
         } else if (grupoProceso.longValue() == ConstantesPED.GP4.longValue()) {
             this.tamanioSubSegmento = new Long(daoSolicitud.obtenerTamanioSubSegmento(this.codigoBatch, "GP4"));
         }   
     }
   
   UtilidadesLog.info("MONGrupoProceso.obtenerTamanioSegmentosGP2y4(Long grupoProceso): Salida ");	
 }


    public DTOSalidaBatch reSegmentar(DTOBatch dtoin) throws MareException{
        MareDTO dtoonline = (MareDTO)dtoin.getDTOOnline();
        user = dtoin.getUser();
        IDProc = dtoin.getProcessID(); 
        if (dtoonline instanceof DTOEjecucionProcesos) {
            // sapaza -- Ajuste Segmentacion SICC -- 26/09/2014
            DAOSolicitud daoSolicitud = new DAOSolicitud();
            this.tipoSegmentacion = daoSolicitud.obtenerTipoSegmentacion();
            this.codigoBatch = ((DTOEjecucionProcesos) dtoonline).getCodigoBatch();
        
            ArrayList sol = ((DTOEjecucionProcesos) dtoonline).getListaSolicitudes();
            ListIterator it = sol.listIterator();
            Long grupoProceso = ((DTOEjecucionProcesos) dtoonline).getOidGrupoProcesos();
            this.obtenerTamanioSegmentosGP2y4(grupoProceso);
            boolean continua = true;
            ArrayList miVector = new ArrayList();
            DTOSolicitudValidacion elemLista;
            MareDTO Mdto = null;
            int contador = 0;
            Long tipoAnt = null;
            while (continua){
                while (it.hasNext()){
                    elemLista = (DTOSolicitudValidacion)it.next();
                    tipoAnt = elemLista.getOidTipoSolPais();
                    if (contador == this.tamanioSubSegmento.longValue()) {
                        contador = 0;
                        it.previous();
                        break;
                    } else {
                       miVector.add(elemLista);
                       contador++;                    
                    }
                }
                Mdto = this.ejecutarGrupoProcesos(miVector, grupoProceso, tipoAnt);
                miVector = new ArrayList();            
                if (!it.hasNext()) {
                    continua = false;
                }
            }
            this.esperarProcesamiento();
            return new DTOSalidaBatch(0,"Ejecucion MONGrupoProceso:reSegmentar completada");  
        } else {
            throw new MareException(null, null, UtilidadesError.armarCodigoError("1", "", ErroresNegocio.PED_025));
        } 
    }

    protected MareDTO ejecutarGrupoProcesos(ArrayList Lista, Long oidGrupoProceso, Long oidTipoSolicitudPais) throws MareException {
        UtilidadesLog.info("MONGrupoProceso.ejecutarGrupoProcesos(ArrayList Lista, Long oidGrupoProceso, Long oidTipoSolicitudPais): Entrada ");
        DTOEjecucionProcesos dtoEP = new DTOEjecucionProcesos(); 
        dtoEP.setListaSolicitudes(Lista);
        dtoEP.setOidTipoSolicitud(oidTipoSolicitudPais);
        dtoEP.setOidGrupoProcesos(oidGrupoProceso);
        MareDTO mDTOResu = null;   
        String GP = "";
        if (oidGrupoProceso.longValue() == ConstantesPED.GP2.longValue()) {
          GP = new String("SUB_SEGMENTO_GP2_");
        } else if (oidGrupoProceso.longValue() == ConstantesPED.GP4.longValue()) {
          GP = new String("SUB_SEGMENTO_GP4_");
        }   
        try {
            MareBusinessID mBI = new MareBusinessID();
            mBI.setBusinessID(new String("PEDEjecutarSubProcesos"));
            DTOSubBatch dtoSB = new DTOSubBatch(GP, IDProc, this.user, mBI, dtoEP);            
            BatchUtil batch = new BatchUtil();
            mDTOResu = batch.executeMLN(dtoSB, "PEDSegmentosProcesos");            
            return mDTOResu;    
        }catch (RemoteException re) {
            throw new MareException(re, UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
        }      
    }
    
    protected void esperarProcesamiento() throws MareException {
        UtilidadesLog.info("MONGrupoProceso.esperarProcesamiento(): Entrada ");
        try {
            if (this.IDProc != null) {
                MONBatch mb = new MONBatch();
                mb.esperarHijos(this.IDProc);
            }  
        } catch (InterruptedException ie) {
            UtilidadesLog.info("MONGrupoProceso.esperarProcesamiento(): Salida ");
            throw new MareException ("Error ejecutando Esperar Procesamiento", ie);
        }  
        UtilidadesLog.info("MONGrupoProceso.esperarProcesamiento(): Salida ");
    }

    private BusinessFacadeLocalHome getBusinessFacadeLocalHome() throws NamingException{
        final InitialContext context = new InitialContext();
        return (BusinessFacadeLocalHome)context.lookup("java:comp/env/BusinessFacade");
    }

    public MareDTO procesarSolicitud(Long oidGrupoProceso, DTOSolicitudValidacion dto, DTOListaProcesos listaProcesos) throws MareException{
        UtilidadesLog.info("MONSecuenciaProcesosBean.procesarSolicitud(Long oidGrupoProceso, DTOSolicitudValidacion dto, DTOListaProcesos listaProcesos): Entrada ");
        DTOEstatusSolicitud dtoES = null;
        MareDTO dtoResu = new MareDTO();
        DAOSolicitud daoSol = new DAOSolicitud();
        Date date1 = new Date();
        try{
            dtoES = getMONGrupoProcesoSolicitudLocalHome().create().procesarSolicitud(oidGrupoProceso, dto, listaProcesos, Boolean.FALSE); 
            if (dtoES != null) {
                if ( (dtoES.getEstatus().longValue() == ConstantesPED.ESTADO_SOLICITUD_VALIDADO.longValue()) ||
                      (dtoES.getEstatus().longValue() == ConstantesPED.ESTADO_SOLICITUD_LIBERADO.longValue()) ) {

                    // sapaza -- PER-SiCC-2011-0477 -- 08/07/2011
                    //this.actualizarSeguimientoPedido( dto, oidGrupoProceso);
                    
                    this.getMONGrupoProcesoLocal().actualizarProcesoSolicitud(dto.getOidSolicitud(), oidGrupoProceso, dtoES.getOidProceso(), dtoES.getEstatus());
                } else {
                    if ( (dtoES.getEstatus().longValue() != ConstantesPED.ESTADO_SOLICITUD_ERRONEO.longValue())){
                        //metodo actualizarEstado del DAOSolicitud 
                        daoSol.actualizarEstado( dto.getOidSolicitud() , new Integer(dtoES.getEstatus().toString()) );
                    }            
                }
                
                // gPineda - 15/01/2007 - V_PED_12
                if( ConstantesPED.ESTADO_SOLICITUD_RECHAZADO.equals( dtoES.getEstatus() )  ){
                    daoSol.actualizarSolicitudRechazo( dto );
                }
            
                //de acuerdo al ult. corrido acumulo el resultado
                if (dtoES.getResultado() != null) {
                    dtoResu = dtoES.getResultado();            
                }
            }
            Date date2 = new Date();
            UtilidadesLog.warn("Tiempo Solicitud "+dto.getOidSolicitud()+" ->>> "+(date2.getTime()-date1.getTime()));
            UtilidadesLog.info("MONSecuenciaProcesosBean.procesarSolicitud(Long oidGrupoProceso, DTOSolicitudValidacion dto, DTOListaProcesos listaProcesos): Salida ");
            return dtoResu;
        
        } catch(Exception e) {
            UtilidadesLog.error("ERROR",e);
            throw new MareException(e,
            UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
        }
    }

    private MONGrupoProcesoLocal getMONGrupoProcesoLocal() throws MareException {
	    // Se obtiene el interfaz home
        MONGrupoProcesoLocalHome localHome = (MONGrupoProcesoLocalHome)UtilidadesEJB.getLocalHome("java:comp/env/MONGrupoProcesoLocal");
        // Se obtiene el interfaz remoto
        MONGrupoProcesoLocal ejb = null;
        try {
            ejb = localHome.create();
        } catch (Exception e) {
            UtilidadesLog.error("ERROR",e);
            String codigoError = CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB;
            throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));
        } 
        return ejb;
    }

    public void actualizarProcesoSolicitud(Long oidSolicitud, Long oidGrupoProceso, Long oidProceso, Long estatus) throws MareException{
        DAOSolicitud daoSol = new DAOSolicitud();
        daoSol.actualizarProcesoSolicitud(oidSolicitud, oidGrupoProceso, oidProceso, estatus);
    }
    
    private MONGrupoProcesoHome getMONGrupoProcesoHome() throws NamingException {
        final InitialContext context = new InitialContext();
        return (MONGrupoProcesoHome)PortableRemoteObject.narrow(context.lookup("java:comp/env/MONGrupoProceso"), MONGrupoProcesoHome.class);
    }

    private MONGrupoProcesoSolicitudLocalHome getMONGrupoProcesoSolicitudLocalHome() throws NamingException
    {
        final InitialContext context = new InitialContext();
        return (MONGrupoProcesoSolicitudLocalHome)context.lookup("java:comp/env/ejb/local/MONGrupoProcesoSolicitud");
    }

    private MONSeguimientoPedidosLocalHome getMONSeguimientoPedidosLocalHome() throws NamingException
    {
        final InitialContext context = new InitialContext();
        return (MONSeguimientoPedidosLocalHome)context.lookup("java:comp/env/ejb/local/MONSeguimientoPedidos");
    }

    public DTOSalidaBatch ejecutarCacheEntidades(DTOBatch dtoin) throws MareException {
        //UtilidadesLog.warn("Ejecutando Segmento de Cacheo de Entidades - Inicio");
        for (int i=0; i < 40; i++) {
            try {
                //UtilidadesLog.warn("Cacheando Entidades-cmn " + i);
                Entidadi18nLocalHome entidadi18nLocalHome = new Entidadi18nLocalHome();
                Collection coleccionI18N = entidadi18nLocalHome.findByEntPK("BEL_TIPO_MOVIM_ALMAC", new Long(1));
            } catch (Exception e) {
                continue;
            }
            // sapaza -- SIN-RCR-20140507 AJUSTE CIERRE ZONAS -- 07/05/2014
            try {
                //UtilidadesLog.warn("Cacheando Entidades-fac " + i);
                TiposCierreLocalHome tiposCierresLH = new TiposCierreLocalHome();
                TiposCierreLocal tipoCierre = tiposCierresLH.findByPrimaryKey(new Long(1));
            } catch (Exception e) {
                continue;
            }
            try {
                //UtilidadesLog.warn("Cacheando Entidades-msg " + i);
                MensajesLocalHome msjLocalHome = new MensajesLocalHome();
                MensajesLocal msjLocal = msjLocalHome.findByUk(new Long(1), ConstantesMSG.MENSAJE_PED05);
            } catch (Exception e) {
                continue;
            }
            try {
                //UtilidadesLog.warn("Cacheando Entidades-ped " + i);
                TiposSolicitudPaisLocalHome soli_pais = new TiposSolicitudPaisLocalHome();
                TiposSolicitudPaisLocal solicitud_pais = soli_pais.findByPrimaryKey(new Long(1));
            } catch (Exception e) {
                continue;
            }
        }
        //UtilidadesLog.warn("Ejecutando Segmento de Cacheo de Entidades - Fin");
        return new DTOSalidaBatch(0,"Ejecucion MONGrupoProceso:reSegmentar completada");
    }
}
