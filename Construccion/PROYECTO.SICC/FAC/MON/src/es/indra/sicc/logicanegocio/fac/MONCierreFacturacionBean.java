package es.indra.sicc.logicanegocio.fac;

import es.indra.mare.common.exception.MareException;
import es.indra.mare.common.mgc.MareMGC;
import es.indra.mare.common.mgu.manager.Property;
import es.indra.mare.common.mgu.manager.UserIDImpl;
import es.indra.mare.common.mii.MareMii;
import es.indra.mare.common.mii.MareTopic;
import es.indra.mare.common.mii.services.jdbcservice.RecordSet;
import es.indra.mare.common.mln.MareBusinessID;
import es.indra.mare.enterprise.mln.BusinessFacade;
import es.indra.mare.enterprise.mln.BusinessFacadeHome;
import es.indra.mare.enterprise.mln.BusinessFacadeLocalHome;
import es.indra.sicc.cmn.negocio.batch.DTOBatch;
import es.indra.sicc.cmn.negocio.batch.DTOSalidaBatch;
import es.indra.sicc.cmn.negocio.batch.DTOSubBatch;
import es.indra.sicc.cmn.negocio.batch.MONBatch;
import es.indra.sicc.cmn.negocio.batch.util.BatchUtil;
import es.indra.sicc.dtos.fac.DTOCargaInicialCierre;
import es.indra.sicc.dtos.fac.DTODatosProgramaCierre;
import es.indra.sicc.dtos.fac.DTOFACCierreFacturacion;
import es.indra.sicc.dtos.fac.DTOFACProcesoCierre;
import es.indra.sicc.entidades.fac.TiposCierreLocal;
import es.indra.sicc.entidades.fac.TiposCierreLocalHome;
import es.indra.sicc.logicanegocio.inc.FactoriaConcurso;
import es.indra.sicc.logicanegocio.men.MONUsuarios;
import es.indra.sicc.logicanegocio.men.MONUsuariosHome;
import es.indra.sicc.logicanegocio.ped.ConstantesPED;
import es.indra.sicc.logicanegocio.ped.DAOMonitor;
import es.indra.sicc.logicanegocio.seg.ConstantesSEG;
import es.indra.sicc.util.BelcorpService;
import es.indra.sicc.util.CodigosError;
import es.indra.sicc.util.DTOBelcorp;
import es.indra.sicc.util.DTOOID;
import es.indra.sicc.util.DTOSalida;
import es.indra.sicc.util.UtilidadesBD;
import es.indra.sicc.util.UtilidadesEJB;
import es.indra.sicc.util.UtilidadesError;
import es.indra.sicc.util.UtilidadesLog;

import java.rmi.RemoteException;

import java.text.SimpleDateFormat;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Iterator;

import javax.ejb.SessionBean;
import javax.ejb.SessionContext;

import javax.naming.InitialContext;
import javax.naming.NamingException;

import javax.persistence.NoResultException;

import javax.rmi.PortableRemoteObject;


public class MONCierreFacturacionBean implements SessionBean  {
    private Collection tiposCierre = null;
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


    public void tramitarCierre(DTOFACCierreFacturacion dtoe) throws MareException, RemoteException {
        UtilidadesLog.info("MONCierreFacturacionBean.tramitarCierre(DTOFACCierreFacturacion dtoe): Entrada");
        DAOFACCierreFacturacion daoCierre = new DAOFACCierreFacturacion();
        TiposCierreLocalHome tiposCierresLH = this.getTiposCierreLocalHome();
        try {
            this.tiposCierre = tiposCierresLH.findAll();
        }catch (NoResultException e){
                UtilidadesLog.error("tramitarCierre: FinderException", e);
                throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE));
        }
        dtoe.setCodigoTipoCierre(this.obtenerTipoCierre(dtoe.getTipoCierre()));
        Integer ctrlCierres = daoCierre.obtenerNumeroControlCierres(dtoe);
        UtilidadesLog.debug("ctrlCierres: "+ctrlCierres.intValue());
    		if(ctrlCierres.intValue()>0){
            UtilidadesLog.debug("SE INTENTA CERRAR ALGO YA CERRADO");
            String mensaje = null;
           if (dtoe.getCodigoTipoCierre().equals(ConstantesFAC.TIPO_CIERRE_PERIODO)) {
                UtilidadesLog.debug("Cierre Periodo ya existente");                    
                mensaje = ErroresDeNegocio.FAC_0001;
           } else if (dtoe.getCodigoTipoCierre().equals(ConstantesFAC.TIPO_CIERRE_REGION)) {
                UtilidadesLog.debug("Cierre Region ya existente");                        
                mensaje = ErroresDeNegocio.FAC_0002;
           } else if (dtoe.getCodigoTipoCierre().equals(ConstantesFAC.TIPO_CIERRE_ZONA)){
               UtilidadesLog.debug("Cierre Zona ya existente");                    
               mensaje = ErroresDeNegocio.FAC_0003;
           }
           UtilidadesLog.error("Mensaje: "+mensaje);
           MareException me = new MareException(new Exception(), UtilidadesError.armarCodigoError(ConstantesSEG.MODULO_FAC, "", mensaje));
           UtilidadesLog.error("ERROR",me);
          throw me;           
        }
        
        try {
            MONUsuarios monUsu = this.getMONUsuariosHome().create();
            String uName = ctx.getCallerPrincipal().getName();
            HashMap propiedades = monUsu.getProperties(new UserIDImpl(uName));
    
            Property subacceso = (Property) propiedades.get(ConstantesPED.SUBACCESO_DEFECTO);
            dtoe.setSubacceso(new Long(subacceso.getValue().toString())); 
            
            // sapaza -- PER-SiCC-2011-0544 -- 02/08/2011  
            dtoe.setCodigoUsuario(uName);
    
            DTOBatch dtoBatch = new DTOBatch("CIERREFAC",new MareBusinessID("FACCerrarFacturacionBatch"),dtoe);
            
            BatchUtil.executeMLN( dtoBatch, new MareBusinessID( "FACProcesosGP5" ));

        }catch (Exception e){
                UtilidadesLog.error("tramitarCierre: Exception", e);
                throw new MareException("tramitarCierre: Exception: " + e);
        }        
    
        UtilidadesLog.info("MONCierreFacturacionBean.tramitarCierre(DTOFACCierreFacturacion dtoe): Salida");
    }


    /**
     * 
     */
    private void cerrarPeriodo(DTOFACCierreFacturacion dtoCierreFacturacion) throws MareException, RemoteException {
        UtilidadesLog.info("MONCierreFacturacionBean.cerrarPeriodo(DTOFACCierreFacturacion dtoCierreFacturacion): Entrada");
        DTOFACProcesoCierre dtoProcesoCierre;
        String resultadoProceso;
        Hashtable procesosLanzados= new Hashtable();
        DTOOID tipoCierre = this.obtenerTipoCierre(ConstantesFAC.TIPO_CIERRE_PERIODO);

        DAOFACCierreFacturacion daoCierre = new DAOFACCierreFacturacion();
        ArrayList procesosCierre = daoCierre.obtenerProcesosCierre(dtoCierreFacturacion.getOidPais(), tipoCierre.getOid());
        Iterator it = procesosCierre.iterator();
        
        // sapaza -- PER-SiCC-2011-1005 -- 21/12/2011
        FactoriaConcurso.refrescarConcursos();
        
        while (it.hasNext()) {
            resultadoProceso = ConstantesFAC.PROCESO_CIERRE_OK;
            dtoProcesoCierre = (DTOFACProcesoCierre)it.next();
            dtoProcesoCierre.setOidPais(dtoCierreFacturacion.getOidPais());
            dtoProcesoCierre.setMarca(dtoCierreFacturacion.getMarca());
            dtoProcesoCierre.setCanal(dtoCierreFacturacion.getCanal());
            dtoProcesoCierre.setPeriodo(dtoCierreFacturacion.getPeriodo());
            dtoProcesoCierre.setOidIdioma(dtoCierreFacturacion.getOidIdioma());
            dtoProcesoCierre.setIDProc(dtoCierreFacturacion.getIDProc());
            dtoProcesoCierre.setSubacceso(dtoCierreFacturacion.getSubacceso());                
            if((dtoProcesoCierre.getPrograma()!=null)&&(!dtoProcesoCierre.getPrograma().trim().equals(""))){
                if (dtoProcesoCierre.getOidProcesoPrecedencia()!=null){
                        if (procesosLanzados.containsKey(dtoProcesoCierre.getOidProcesoPrecedencia())){
                            if ("N".equals(procesosLanzados.get(dtoProcesoCierre.getOidProcesoPrecedencia()).toString())){
                                esperarProcesamiento(dtoCierreFacturacion.getIDProc());
                                procesosLanzados = new Hashtable();
                            }
                        }
                    }
                    ejecutarBatch (dtoProcesoCierre);
                    procesosLanzados.put(dtoProcesoCierre.getOid(),"N");
            }else{
                UtilidadesLog.debug("No hay MareBusinessID a ser ejecutada");
            }
        }
        esperarProcesamiento(dtoCierreFacturacion.getIDProc());
        
        // sapaza -- PER-SiCC-2011-0544 -- 02/08/2011  
        actualizarProgramaCierre(dtoCierreFacturacion, null, procesosCierre.size());
        
        UtilidadesLog.info("MONCierreFacturacionBean.cerrarPeriodo(DTOFACCierreFacturacion dtoCierreFacturacion): Salida");
    }


    /**
    * 
    * Se procesa el cierre de las regiones seleccionadas, se ejecutan los procesos definidos de a una region a la vez.
    * @mejora En cada region se ejecutan los procesos en el orden indicado quedando a la espera de la finalizacion de cada uno.
    *         Es necesario respetar el orden para obtener el resultado esperado, ya que un proceso
    *         depende de los resultado de otro proceso anterior. 
    *         Ademas, cada proceso puede ejecutar o no de manera segmentada, pero no se deben cruzar 
    *         los segmentos de ejecucion de distintos procesos como sucedia hasta esta mejora.
    *         Incidencia 20070256.
    * @autor gdmarzi
    */
    private void cerrarRegiones(DTOFACCierreFacturacion dtoCierreFacturacion) throws MareException, RemoteException{
        UtilidadesLog.info("MONCierreFacturacionBean.cerrarRegiones(DTOFACCierreFacturacion dtoCierreFacturacion): Entrada");
        DTOOID oidRegion;
        DTOFACProcesoCierre dtoProcesoCierre;
        DTOOID tipoCierre = this.obtenerTipoCierre(ConstantesFAC.TIPO_CIERRE_REGION);
        DAOFACCierreFacturacion daoCierre = new DAOFACCierreFacturacion();

        ArrayList procesosCierre = daoCierre.obtenerProcesosCierreRegion(dtoCierreFacturacion.getOidPais(), tipoCierre.getOid());

        for (int i = 0; i < dtoCierreFacturacion.getRegiones().getOids().length; i++) {
            oidRegion = new DTOOID();
            oidRegion.setOid(dtoCierreFacturacion.getRegiones().getOids()[i]);
            UtilidadesLog.debug("region: " + dtoCierreFacturacion.getRegiones().getOids()[i]);
            Iterator itProcesosCierre = procesosCierre.iterator();
            while (itProcesosCierre.hasNext()) {
                dtoProcesoCierre = (DTOFACProcesoCierre)itProcesosCierre.next();
                dtoProcesoCierre.setOidPais(dtoCierreFacturacion.getOidPais());
                dtoProcesoCierre.setMarca(dtoCierreFacturacion.getMarca());
                dtoProcesoCierre.setCanal(dtoCierreFacturacion.getCanal());
                dtoProcesoCierre.setPeriodo(dtoCierreFacturacion.getPeriodo());
                dtoProcesoCierre.setRegion(oidRegion.getOid());
                dtoProcesoCierre.setOidIdioma(dtoCierreFacturacion.getOidIdioma());
                dtoProcesoCierre.setIDProc(dtoCierreFacturacion.getIDProc());
                dtoProcesoCierre.setSubacceso(dtoCierreFacturacion.getSubacceso());
                UtilidadesLog.debug("DTOFACProcesoCierre: " + dtoProcesoCierre);
                if((dtoProcesoCierre.getPrograma()!=null)&&(!dtoProcesoCierre.getPrograma().trim().equals(""))){
                    // ejecuta un proceso definido y espera su finalizacion para ejecutar el proximo.
                    ejecutarBatch (dtoProcesoCierre);
                    esperarProcesamiento(dtoCierreFacturacion.getIDProc());
                } else {
                    UtilidadesLog.debug("No hay MareBusinessID a ser ejecutada");
                }
            }
            
            // sapaza -- PER-SiCC-2011-0544 -- 02/08/2011  
            try {
                MONCierreFacturacionLocal monCie = this.getMONCierreFacturacionLocalHome().create();
                UtilidadesLog.warn("ACTUALIZARPROGRAMACIERRE, PARA LA REGION = " + dtoCierreFacturacion.getRegiones().getOids()[i]);
                monCie.actualizarProgramaCierre(dtoCierreFacturacion, dtoCierreFacturacion.getRegiones().getOids()[i],
                            procesosCierre.size());
            }catch (Exception e){
                    UtilidadesLog.error("tramitarCierre: Exception", e);
                    throw new MareException("tramitarCierre: Exception: " + e);
            }
            
        }
        
        UtilidadesLog.info("MONCierreFacturacionBean.cerrarRegiones(DTOFACCierreFacturacion dtoCierreFacturacion): Salida");
    }


   /**
    * Se procesa el cierre de las zonas seleccionadas, se ejecutan los procesos definidos de forma batch para el cierre de zona.
    * @mejora se procesan las zonas utilizando la segmentacion en batch para mejorar la performance.
    * @autor gdmarzi
    */
    private void cerrarZonas(DTOFACCierreFacturacion dtoCierreFacturacion) throws MareException, RemoteException {
        UtilidadesLog.info("MONCierreFacturacionBean.cerrarZonas(DTOFACCierreFacturacion dtoCierreFacturacion): Entrada");
        Long oidZona;
        DTOSubBatch dtoSubBatch;
        MareMGC mgc = new MareMGC();
        mgc = (MareMGC) MareMii.getService(new MareTopic(MareMii.SERVICE_MGC));
        String nroSegmentosCierreZona = (String) mgc.getProperty("application.NumeroMaximoSegmentosZONAS");
        UtilidadesLog.debug("nroSegmentosCierreZona: " + nroSegmentosCierreZona);
        DTOOID tipoCierre = this.obtenerTipoCierre(ConstantesFAC.TIPO_CIERRE_ZONA);
        DAOFACCierreFacturacion daoCierre = new DAOFACCierreFacturacion();

        ArrayList procesosCierre = daoCierre.obtenerProcesosCierre(dtoCierreFacturacion.getOidPais(), tipoCierre.getOid());

        int nroZonas = dtoCierreFacturacion.getZonas().getOids().length;
        int numerosProcesosPorZona = procesosCierre.size() + 1;
        int numeroZonasSimultaneas = new Integer(nroSegmentosCierreZona).intValue() / numerosProcesosPorZona;
        int zonasEnEjecucion = 0;
        UtilidadesLog.debug("numeroZonasSimultaneas: " + numeroZonasSimultaneas);
        for (int i = 0;i < nroZonas; i++) {
            oidZona = dtoCierreFacturacion.getZonas().getOids()[i];
            dtoCierreFacturacion.setZona(oidZona);
            String nombreSubproceso = "CierreZonaSegmentoZona_" + oidZona ;
            dtoSubBatch = new DTOSubBatch(nombreSubproceso, 
                                          dtoCierreFacturacion.getIDProc(), 
                                          ctx.getCallerPrincipal().getName(), 
                                          new MareBusinessID("FACCerrarZonaSegmento"), 
                                          dtoCierreFacturacion);
            UtilidadesLog.debug("dtoCierreFacturacion: " + dtoCierreFacturacion);
            zonasEnEjecucion = zonasEnEjecucion + 1;
            BatchUtil.executeMLN(dtoSubBatch, new MareBusinessID("FACProcesosGP5"));
            // si se lanzaron el total de zonas en simultaneo o se lanzo la ulitma zona, espero.
            if ((zonasEnEjecucion == numeroZonasSimultaneas) || (nroZonas == i+1)) {
                // esperamos que se ejecute el grupo de zonas simultaneo actual.
                this.esperarProcesamiento(dtoCierreFacturacion.getIDProc());
                zonasEnEjecucion = 0;
            }
        }
        
        UtilidadesLog.info("MONCierreFacturacionBean.cerrarZonas(DTOFACCierreFacturacion dtoCierreFacturacion): Salida");
    }

    
    /**
    * Lanza los procesos asociados al cierre de una zona.
    * @mejora ejecuta en un segmento los procesos asociado al cierre de esta zona.
    * @autor gdmarzi
    */
    public DTOSalidaBatch cerrarZonaSegmento(DTOBatch dto) throws MareException {
        Hashtable procesosLanzados= new Hashtable();
        DTOFACProcesoCierre dtoProcesoCierre;
        DTOOID tipoCierre = this.obtenerTipoCierre(ConstantesFAC.TIPO_CIERRE_ZONA);
        DAOFACCierreFacturacion daoCierre = new DAOFACCierreFacturacion();
        DTOFACCierreFacturacion dtoCierreFacturacion = (DTOFACCierreFacturacion) dto.getDTOOnline();
        ArrayList procesosCierre = daoCierre.obtenerProcesosCierre(dtoCierreFacturacion.getOidPais(), tipoCierre.getOid());
        Iterator itProcesosCierre = procesosCierre.iterator();
        while (itProcesosCierre.hasNext()) {
            dtoProcesoCierre = (DTOFACProcesoCierre)itProcesosCierre.next(); 
            dtoProcesoCierre.setOidPais(dtoCierreFacturacion.getOidPais());
            dtoProcesoCierre.setMarca(dtoCierreFacturacion.getMarca());
            dtoProcesoCierre.setCanal(dtoCierreFacturacion.getCanal());
            dtoProcesoCierre.setPeriodo(dtoCierreFacturacion.getPeriodo());
            dtoProcesoCierre.setZona(dtoCierreFacturacion.getZona());
            dtoProcesoCierre.setOidIdioma(dtoCierreFacturacion.getOidIdioma());
            dtoProcesoCierre.setIDProc(dto.getProcessID());
            dtoProcesoCierre.setSubacceso(dtoCierreFacturacion.getSubacceso());                
            UtilidadesLog.debug("DTOFACProcesoCierre: " + dtoProcesoCierre);
            UtilidadesLog.debug("MareBusinessID: " + dtoProcesoCierre.getPrograma());

            if((dtoProcesoCierre.getPrograma()!=null)&&(!dtoProcesoCierre.getPrograma().trim().equals(""))){
                if (dtoProcesoCierre.getOidProcesoPrecedencia()!=null){
                    if (procesosLanzados.containsKey(dtoProcesoCierre.getOidProcesoPrecedencia())){
                        if ("N".equals(procesosLanzados.get(dtoProcesoCierre.getOidProcesoPrecedencia()).toString())){
                            this.esperarProcesamiento(dto.getProcessID());
                            procesosLanzados = new Hashtable();
                        }
                    }
                }
                this.ejecutarBatch(dtoProcesoCierre);
                procesosLanzados.put(dtoProcesoCierre.getOid(),"N");

            }else{
                UtilidadesLog.debug("No hay MareBusinessID a ser ejecutada");
            }
        }
        this.esperarProcesamiento(dto.getProcessID());
        
        // sapaza -- PER-SiCC-2011-0544 -- 02/08/2011  
        UtilidadesLog.warn("ACTUALIZARPROGRAMACIERRE, PARA LA ZONA = " + dtoCierreFacturacion.getZona());
        actualizarProgramaCierre(dtoCierreFacturacion, null, procesosCierre.size());

        return new DTOSalidaBatch(0, "Cerrar Zona Segmento OK");
    }


    private void ejecutarBatch (DTOFACProcesoCierre dtoProcesoCierre)throws MareException{
        try{
            String nombre = null;
            if (dtoProcesoCierre.getPrograma().length()>30){
                nombre = "PROC_CIERRE-"+dtoProcesoCierre.getPrograma().substring(0,30);
            }else{
                nombre = "PROC_CIERRE-"+dtoProcesoCierre.getPrograma();
            }
            DTOSubBatch dtoSB = new DTOSubBatch(nombre, 
                                              dtoProcesoCierre.getIDProc(),
                                              ctx.getCallerPrincipal().getName(),
                                              new MareBusinessID("FACCerrarFacturacionProcesoBatch"),  
                                              dtoProcesoCierre);            
            
            BatchUtil.executeMLN( dtoSB, new MareBusinessID( "FACProcesosGP5" ));
        }catch (Exception e){
            UtilidadesLog.error("ERROR",e);
            throw new MareException(e);
        }
    }
    
    protected void esperarProcesamiento(String idProceso) throws MareException {
        UtilidadesLog.info("MONSecuenciaProcesosBean.esperarProcesamiento(): Entrada ");
        try {
            MONBatch mb = new MONBatch();
            mb.esperarHijos(idProceso);
        } catch (InterruptedException ie) {
            UtilidadesLog.info("MONSecuenciaProcesosBean.esperarProcesamiento(): Salida ");
          throw new MareException ("Error ejecutando Esperar Procesamiento", ie);
        }  
        UtilidadesLog.info("MONSecuenciaProcesosBean.esperarProcesamiento(): Salida ");
    }


    private DTOOID obtenerTipoCierre(String codigoCierre)
        throws MareException {
        UtilidadesLog.info("MONCierreFacturacionBean.obtenerTipoCierre(String codigoCierre): Entrada");
        UtilidadesLog.debug("codigoCierre recibido:" + codigoCierre);

        if (this.tiposCierre == null) {
            TiposCierreLocalHome tiposCierresLH = this.getTiposCierreLocalHome();
            try {
              this.tiposCierre = tiposCierresLH.findAll();
            }catch (NoResultException e){
                    UtilidadesLog.error("tramitarCierre: FinderException", e);
                    throw new MareException(e,
                        UtilidadesError.armarCodigoError(
                            CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE));
            }
        }

        TiposCierreLocal tipoCierreEJB;
        Long oidTipoCierre = null;
        Iterator it = this.tiposCierre.iterator();
        
        while (it.hasNext()){
                tipoCierreEJB = (TiposCierreLocal)it.next();
                if (tipoCierreEJB.getCodigo().equals(codigoCierre)){
                        oidTipoCierre = tipoCierreEJB.getOid();
                        break;
                }
        }
    
        DTOOID retorno = new DTOOID();
        retorno.setOid(oidTipoCierre);
            UtilidadesLog.debug("DTOOID a retornar: " + retorno);
            UtilidadesLog.info("MONCierreFacturacionBean.obtenerTipoCierre(String codigoCierre): Salida");
        return retorno;
    }


    private String obtenerTipoCierre(Long oid) throws MareException {
        UtilidadesLog.info("MONCierreFacturacionBean.obtenerTipoCierre(Long oid): Entrada");

        TiposCierreLocal tipoCierreEJB;
        String CodTipoCierre = "";
        Iterator it = this.tiposCierre.iterator();
        
        while (it.hasNext()){
                tipoCierreEJB = (TiposCierreLocal)it.next();
                if (tipoCierreEJB.getOid().longValue() == oid.longValue()){
                        CodTipoCierre = tipoCierreEJB.getCodigo();
                        break;
                }
        }
        UtilidadesLog.info("MONCierreFacturacionBean.obtenerTipoCierre(Long oid): Salida");
    		return CodTipoCierre;
    }
    
    private BusinessFacade getBusinessFacade() throws MareException {
        UtilidadesLog.info("MONCierreFacturacionBean.getBusinessFacade(): Entrada");
        BusinessFacadeHome home=null;
        try  {
            home = (BusinessFacadeHome)UtilidadesEJB.getHome(
            "java:comp/env/BusinessFacade", BusinessFacadeHome.class);
        } catch (Exception ex)  {
            UtilidadesLog.error(ex);
        } 
        BusinessFacade ejb = null;
        try {
            ejb = home.create();
        } catch (Exception e) {
            UtilidadesLog.error("*** Error en BusinessFacade",e);
            String codigoError = CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB;
            throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));
        } 
    		UtilidadesLog.info("MONCierreFacturacionBean.getBusinessFacade(): Salida");
        return ejb;
    }


    private BusinessFacadeHome getBusinessFacadeHome() throws NamingException {
        final InitialContext context = new InitialContext();
        return (BusinessFacadeHome)PortableRemoteObject.narrow(context.lookup("java:comp/env/BusinessFacade"), BusinessFacadeHome.class);
    }


    /**
     * 
     */
    public DTOSalidaBatch tramitarCierreBatch(DTOBatch dtoin) throws MareException {
        UtilidadesLog.info("MONCierreFacturacionBean.tramitarCierreBatch(DTOBatch dtoin): Entrada");
        DTOFACCierreFacturacion dtoe = null;
        try{
            dtoe = (DTOFACCierreFacturacion)dtoin.getDTOOnline();
        }catch (Exception e){
            UtilidadesLog.error("Tramitar Cierre - No se ha recbido el DTO esperado");
            return new DTOSalidaBatch("DTO NO VALIDO");
        }
        UtilidadesLog.debug("dtoin: " + dtoin);
        dtoe.setIDProc(dtoin.getProcessID());
        UtilidadesLog.debug("DTOFACCierreFacturacion: " + dtoe);
        TiposCierreLocalHome tiposCierresLH = this.getTiposCierreLocalHome();
        try {
            this.tiposCierre = tiposCierresLH.findAll();
        }catch (NoResultException e){
                UtilidadesLog.error("tramitarCierreBatch: FinderException", e);
                throw new MareException(e,
                    UtilidadesError.armarCodigoError(
                        CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE));
        }
        try{
            if(dtoe.getTipoCierre().longValue() == (this.obtenerTipoCierre(ConstantesFAC.TIPO_CIERRE_PERIODO).getOid()).longValue()){
               UtilidadesLog.debug("Periodo: "+ConstantesFAC.TIPO_CIERRE_PERIODO);
               this.cerrarPeriodo(dtoe);  
            }else{
                if(dtoe.getTipoCierre().longValue() == (this.obtenerTipoCierre(ConstantesFAC.TIPO_CIERRE_REGION).getOid()).longValue()){
                    UtilidadesLog.debug("Tipo Cierre: "+dtoe.getTipoCierre());
                    this.cerrarRegiones(dtoe);
                }else{
                    if(dtoe.getTipoCierre().longValue() == (this.obtenerTipoCierre(ConstantesFAC.TIPO_CIERRE_ZONA).getOid()).longValue()){
                        UtilidadesLog.debug("Tipo Cierre: "+dtoe.getTipoCierre());
                        this.cerrarZonas(dtoe);
                    }
                }
            }
        }catch (RemoteException re){
            UtilidadesLog.error("*** Error en tramitarCierreBatch",re);
            String codigoError = CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB;
            throw new MareException(re, UtilidadesError.armarCodigoError(codigoError));			
        }
        UtilidadesLog.info("MONCierreFacturacionBean.tramitarCierreBatch(DTOBatch dtoin): Salida");
        return new DTOSalidaBatch(0, "Tramitar Cierre OK");
    }

    private BusinessFacadeLocalHome getBusinessFacadeLocalHome() throws NamingException {
        final InitialContext context = new InitialContext();
        return (BusinessFacadeLocalHome)context.lookup("java:comp/env/BusinessFacadeBATCH");
    }

    public DTOSalidaBatch ejecutaProcesoCierre(DTOBatch dto) throws MareException {
        UtilidadesLog.info("MONCierreFacturacionBean.ejecutaProcesoCierre(DTOFACProcesoCierre dtoe): Entrada");
        DTOFACProcesoCierre dtoe = (DTOFACProcesoCierre)dto.getDTOOnline();
        BusinessFacade businesFacade = this.getBusinessFacade();
        long time = System.currentTimeMillis();
        String resultadoProceso = ConstantesFAC.PROCESO_CIERRE_OK;
        dtoe.setIDProc(dto.getProcessID());
        try{
            businesFacade.execute(dtoe,new MareBusinessID(dtoe.getPrograma()));
        }catch(RemoteException re){
            UtilidadesLog.error("ERROR",re);
            resultadoProceso = ConstantesFAC.PROCESO_CIERRE_ERROR;
        }
        StringBuffer query = new StringBuffer();
        query.append("SELECT FAC_COCI_SEQ.NEXTVAL FROM DUAL");
        
        RecordSet rs = UtilidadesBD.executeQuery(query.toString());
        Long oid = UtilidadesBD.convertirALong(rs.getValueAt(0, 0));
        
        query = new StringBuffer();
        query.append("INSERT INTO FAC_CONTR_CIERR ( ");
        query.append("OID_CTRL, " );
        query.append("PAIS_OID_PAIS, ");
        query.append("VAL_SECU_CIER, ");
        query.append("FEC_CIER, ");
        query.append("VAL_PROC_EJEC, ");
        query.append("VAL_RESU_PROC, ");
        query.append("PERD_OID_PERI, ");
        query.append("ZZON_OID_ZONA, ");
        query.append("TCIE_OID_TIPO_CIER, ");
        query.append("ZORG_OID_REGI ");
        query.append(")VALUES ( ");
        query.append(oid).append(", ");
        query.append(dtoe.getOidPais()).append(", ");
        query.append(oid).append(", ");
        query.append("TRUNC(SYSDATE), ");
        query.append("'").append(dtoe.getProceso()).append("', ");
        query.append("'").append(resultadoProceso).append("', ");
        query.append(dtoe.getPeriodo()).append(", ");
        query.append(dtoe.getZona()).append(", ");
        query.append(dtoe.getTipoCierre()).append(", ");        
        query.append(dtoe.getRegion());           
        query.append(");");

        try {
          BelcorpService.getInstance().dbService.executeProcedure("PQ_PLANI.EXECUTOR", query.toString());
        } catch (Exception e) {
          UtilidadesLog.error("ERROR",e);
          throw new MareException(e);
        }

        UtilidadesLog.warn("PROCESO CIERRE: "+dtoe.getProceso()+" ->>> "+(System.currentTimeMillis()-time));
        UtilidadesLog.info("MONCierreFacturacionBean.ejecutaProcesoCierre(DTOFACProcesoCierre dtoe): Salida");
        return new DTOSalidaBatch(0, "Tramitar Cierre OK");
    }

    private MONCierreFacturacionLocalHome getMONCierreFacturacionLocalHome() throws NamingException {
        final InitialContext context = new InitialContext();
        return (MONCierreFacturacionLocalHome)context.lookup("java:comp/env/ejb/local/MONCierreFacturacion");
    }

    private TiposCierreLocalHome getTiposCierreLocalHome() throws MareException {
        return new TiposCierreLocalHome();
    }

    private MONUsuariosHome getMONUsuariosHome() throws NamingException {
        final InitialContext context = new InitialContext();
        return (MONUsuariosHome) PortableRemoteObject.narrow( context.lookup( "java:comp/env/MONUsuarios" ), MONUsuariosHome.class );
    }

    public DTOSalida obtenerRegiones(DTODatosProgramaCierre dto) throws MareException {
        UtilidadesLog.info("MONCierreFacturacionBean.obtenerRegiones(DTODatosProgramaCierre dto): Entrada");
        
        DTOSalida dtoS= new DTOSalida();
        String codigoError;
        RecordSet respuesta;
        StringBuffer buf = new StringBuffer();

        try {
            buf.append("SELECT DISTINCT R.OID_REGI, R.DES_REGI ");
            buf.append("  FROM ZON_REGIO R, ");
            buf.append("       FAC_PROGR_CIERR PRO, ");
            buf.append("       CRA_PERIO CRA, ");
            buf.append("       SEG_PERIO_CORPO cor ");
            buf.append(" WHERE r.ind_acti = 1 ");
            buf.append("   AND r.ind_borr = 0 ");
            buf.append("   AND r.Cod_Regi = pro.Cod_Regi ");
            buf.append("   AND pro.Fec_Cier = TO_DATE('" + dto.getFecha() + "' ,'" + dto.getFormatoFecha() + "') ");
            buf.append("   AND pro.tip_cier = '" + dto.getTipoCierre()  + "' ");
            buf.append("   AND pro.est_cier = 'A' ");
            buf.append("   AND cra.oid_peri = " + dto.getOidPeriodo());
            buf.append("   AND cra.peri_oid_peri = cor.oid_peri ");
            buf.append("   AND pro.CAM_PROC = cor.cod_peri ");
            buf.append(" ORDER BY R.DES_REGI ");
              
            respuesta = BelcorpService.getInstance().dbService.executeStaticQuery(buf.toString());
        } catch(Exception e) {
            codigoError = CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS;
            throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));
        }

          UtilidadesLog.info("MONCierreFacturacionBean.obtenerRegiones(DTODatosProgramaCierre dto): Salida");
          return new DTOSalida(respuesta);
    }

    public DTOSalida obtenerZonas(DTODatosProgramaCierre dto) throws MareException {
        UtilidadesLog.info("MONCierreFacturacionBean.obtenerZonas(DTODatosProgramaCierre dto): Entrada");
        
        DTOSalida dtoS= new DTOSalida();
        String codigoError;
        RecordSet respuesta;
        StringBuffer buf = new StringBuffer();

        try {
            buf.append("SELECT DISTINCT Z.OID_ZONA, Z.DES_ZONA ");
            buf.append("  FROM ZON_ZONA Z, ");
            buf.append("       FAC_PROGR_CIERR PRO, ");
            buf.append("       CRA_PERIO CRA, ");
            buf.append("       SEG_PERIO_CORPO cor ");
            buf.append(" WHERE z.ind_acti = 1 ");
            buf.append("   AND z.ind_borr = 0 ");
            buf.append("   AND z.Cod_Zona = pro.Cod_Zona ");
            buf.append("   AND pro.Fec_Cier = TO_DATE('" + dto.getFecha() + "' ,'" + dto.getFormatoFecha() + "') ");
            buf.append("   AND pro.tip_cier = '" + dto.getTipoCierre()  + "' ");
            buf.append("   AND pro.est_cier = 'A' ");
            buf.append("   AND cra.oid_peri = " + dto.getOidPeriodo());
            buf.append("   AND cra.peri_oid_peri = cor.oid_peri ");
            buf.append("   AND pro.CAM_PROC = cor.cod_peri ");
            buf.append(" ORDER BY Z.DES_ZONA ");
              
            respuesta = BelcorpService.getInstance().dbService.executeStaticQuery(buf.toString());
        } catch(Exception e) {
            codigoError = CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS;
            throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));
        }

          UtilidadesLog.info("MONCierreFacturacionBean.obtenerZonas(DTODatosProgramaCierre dto): Salida");
          return new DTOSalida(respuesta);
    }

    public DTOSalida obtenerDatosPeriodo(DTODatosProgramaCierre dto) throws MareException {
        UtilidadesLog.info("MONCierreFacturacionBean.obtenerDatosPeriodo(DTODatosProgramaCierre dto): Entrada");
        
        DTOSalida dtoS= new DTOSalida();
        String codigoError;
        RecordSet respuesta;
        StringBuffer buf = new StringBuffer();

        try {
            buf.append("SELECT pro.COD_CAMP, pro.COD_CAMP ");
            buf.append("  FROM FAC_PROGR_CIERR PRO, ");
            buf.append("       CRA_PERIO CRA, ");
            buf.append("       SEG_PERIO_CORPO cor ");
            buf.append(" WHERE pro.tip_cier = 'C' ");
            buf.append("   AND pro.est_cier = 'A' ");
            buf.append("   AND cra.oid_peri = " + dto.getOidPeriodo());
            buf.append("   AND cra.peri_oid_peri = cor.oid_peri ");
            buf.append("   AND pro.CAM_PROC = cor.cod_peri ");
              
            respuesta = BelcorpService.getInstance().dbService.executeStaticQuery(buf.toString());
        } catch(Exception e) {
            codigoError = CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS;
            throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));
        }

          UtilidadesLog.info("MONCierreFacturacionBean.obtenerDatosPeriodo(DTODatosProgramaCierre dto): Salida");
          return new DTOSalida(respuesta);
    }
    
    private String convertirFecha(Date fecha) {
        UtilidadesLog.info("MONCierreFacturacionBean.convertirFecha(Date fecha): Entrada");
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String sFecha = sdf.format(fecha);                                                          
        UtilidadesLog.info("MONCierreFacturacionBean.convertirFecha(Date fecha): Salida");
        return sFecha;
    }

    public void actualizarProgramaCierre(DTOFACCierreFacturacion dtoe, Long oidRegion, int totalProcesos) throws MareException {
        UtilidadesLog.info("MONCierreFacturacionBean.actualizarProgramaCierre(DTOBatch dto, String tipoCierre): Entrada");
        
        // sapaza -- PER-SiCC-2011-0594 -- 18/08/2011
        //obtenemos el indicador de control de cierre
        String indCierre = obtenerValorParametroPais(dtoe.getOidPais());
        UtilidadesLog.debug("indCierre : " + indCierre);
        
        if(indCierre.equalsIgnoreCase("1")) {
            //obtenemos el codigo de Periodo
            StringBuffer select = new StringBuffer();
            select.append("SELECT cor.COD_PERI ");
            select.append("  FROM CRA_PERIO cra, SEG_PERIO_CORPO cor ");
            select.append(" WHERE cra.PERI_OID_PERI = cor.OID_PERI ");
            select.append("   AND cra.OID_PERI = " + dtoe.getPeriodo());
            
            RecordSet respuesta;
            try {
                respuesta = BelcorpService.getInstance().dbService.executeStaticQuery(select.toString());
            } catch (Exception e) {
              UtilidadesLog.error("ERROR",e);
              throw new MareException(e);
            }
            
            //obtenemos el codigo de Periodo y fecha de Proceso
            String codigoPeriodo = respuesta.getValueAt(0,0).toString();
            String fecha = convertirFecha(dtoe.getFecha());
            
            //obtenemos los codigos de region o zona
            String codigoZona = null;
            String codigoRegion = null;
            if(dtoe.getCodigoTipoCierre().equals(ConstantesFAC.TIPO_CIERRE_ZONA)){
                select = new StringBuffer();
                select.append("SELECT COD_ZONA FROM ZON_ZONA WHERE OID_ZONA = " + dtoe.getZona());
                
                try {
                    respuesta = BelcorpService.getInstance().dbService.executeStaticQuery(select.toString());
                    codigoZona = respuesta.getValueAt(0,0).toString();
                } catch (Exception e) {
                  UtilidadesLog.error("ERROR",e);
                  throw new MareException(e);
                }
            }
            if(dtoe.getCodigoTipoCierre().equals(ConstantesFAC.TIPO_CIERRE_REGION)){
                select = new StringBuffer();
                select.append("SELECT COD_REGI FROM ZON_REGIO WHERE OID_REGI = " + oidRegion);
                
                try {
                    respuesta = BelcorpService.getInstance().dbService.executeStaticQuery(select.toString());
                    codigoRegion = respuesta.getValueAt(0,0).toString();
                } catch (Exception e) {
                  UtilidadesLog.error("ERROR",e);
                  throw new MareException(e);
                }
            }
            
            //Verificamos si se tiene que actualizar la entidad de Programa Cierre
            select = new StringBuffer();
            select.append(" SELECT COUNT(1) ");
            select.append("   FROM FAC_CONTR_CIERR CON, FAC_PROCE_CIERR CIE, CRA_TRANS CRA ");
            select.append("  WHERE CON.PERD_OID_PERI = " + dtoe.getPeriodo());
            
            if(dtoe.getCodigoTipoCierre().equals(ConstantesFAC.TIPO_CIERRE_ZONA))
                select.append("    AND CON.ZZON_OID_ZONA = " + dtoe.getZona());
            if(dtoe.getCodigoTipoCierre().equals(ConstantesFAC.TIPO_CIERRE_REGION))            
                select.append("    AND CON.ZORG_OID_REGI = " + oidRegion);
                
            select.append("   AND CON.TCIE_OID_TIPO_CIER = CIE.TCIE_OID_TIPO_CIER ");
            select.append("   AND CIE.TCIE_OID_TIPO_CIER = " + dtoe.getTipoCierre());
            select.append("   AND CIE.TRAN_OID_TRAN = cra.OID_TRAN ");
            select.append("   AND CON.VAL_PROC_EJEC = CRA.COD_PROC ");
            select.append("   AND CON.VAL_RESU_PROC = 'OK' ");
            
            Integer totalProcesosAux = new Integer(0);
            try {
                respuesta = BelcorpService.getInstance().dbService.executeStaticQuery(select.toString());
                totalProcesosAux = new Integer(respuesta.getValueAt(0,0).toString());
            } catch (Exception e) {
              UtilidadesLog.error("ERROR",e);
              throw new MareException(e);
            }
            
            if(dtoe.getCodigoTipoCierre().equals(ConstantesFAC.TIPO_CIERRE_ZONA))
                UtilidadesLog.warn("ACTUALIZARPROGRAMACIERRE, PROCESOS EJECUTADOS = " + totalProcesosAux +
                                    ", PARA LA ZONA = " + dtoe.getZona());
            if(dtoe.getCodigoTipoCierre().equals(ConstantesFAC.TIPO_CIERRE_REGION))            
                UtilidadesLog.warn("ACTUALIZARPROGRAMACIERRE, PROCESOS EJECUTADOS = " + totalProcesosAux +
                                ", PARA LA REGION = " + oidRegion);
            
            //ACTUALIZAMOS LA ENTIDAD FAC_PROGR_CIERR
            if(totalProcesos == totalProcesosAux.intValue()) {
                StringBuffer update = new StringBuffer();
                update.append("UPDATE FAC_PROGR_CIERR ");
                update.append("   SET EST_CIER = 'P'," );
                update.append("       USU_MODI = '" + dtoe.getCodigoUsuario() + "', ");
                update.append("       FEC_MODI = SYSDATE ");
                update.append(" WHERE EST_CIER = 'A' ");
                
                if(!dtoe.getCodigoTipoCierre().equals(ConstantesFAC.TIPO_CIERRE_PERIODO))
                    update.append("   AND FEC_CIER = TO_DATE('" + fecha + "','yyyy-MM-dd') ");
                
                if(dtoe.getCodigoTipoCierre().equals(ConstantesFAC.TIPO_CIERRE_ZONA)){
                    update.append("   AND COD_ZONA = '" + codigoZona + "' ");
                }
                if(dtoe.getCodigoTipoCierre().equals(ConstantesFAC.TIPO_CIERRE_REGION)){
                    update.append("   AND COD_REGI = '" + codigoRegion + "' ");
                }
                
                if(dtoe.getCodigoTipoCierre().equals(ConstantesFAC.TIPO_CIERRE_PERIODO))
                    update.append("   AND TIP_CIER = 'C' ");
                else
                    update.append("   AND TIP_CIER = '" + dtoe.getCodigoTipoCierre() + "' ");
                    
                update.append("   AND CAM_PROC = '" + codigoPeriodo + "' ");
            
                UtilidadesLog.warn("ACTUALIZARPROGRAMACIERRE, UPDATE = " + update.toString());
                
                try {
                  BelcorpService.getInstance().dbService.executeUpdate(update.toString());
                } catch (Exception e) {
                  UtilidadesLog.error("ERROR",e);
                  throw new MareException(e);
                }
            }
        }
        
        UtilidadesLog.info("MONCierreFacturacionBean.ejecutaProcesoCierre(DTOBatch dto, String tipoCierre): Salida");
    }

    // sapaza -- PER-SiCC-2011-0594 -- 18/08/2011
    public DTOCargaInicialCierre cargaInicialCierre(DTOBelcorp dto) throws MareException {
        UtilidadesLog.info("MONCierreFacturacionBean.cargaInicialCierre(DTOBelcorp dto): Entrada");
        DTOCargaInicialCierre dtoCI = new DTOCargaInicialCierre();
        DAOMonitor daoM = new DAOMonitor();
        
        //obtenemos el indicador de control de cierre
        String indCierre = obtenerValorParametroPais(dto.getOidPais());
        UtilidadesLog.debug("indCierre : " + indCierre);
        dtoCI.setIndicadorControlCierre(indCierre);
        
        if(indCierre.equals("1")) {
            // obtenemos la fecha de proceso y campaña activa
            RecordSet rsAux = daoM.obtenerDatosCampañaActiva(dto.getOidPais());
            if(rsAux!=null && !rsAux.esVacio()) {
                if (rsAux.getValueAt(0, "COD_PAIS") != null) {
                    dtoCI.setCodigoPais(rsAux.getValueAt(0, "COD_PAIS").toString());
                }
                if (rsAux.getValueAt(0, "COD_PERI") != null) {
                    dtoCI.setCodigoPeriodo(rsAux.getValueAt(0, "COD_PERI").toString());
                }
                if (rsAux.getValueAt(0, "FEC_PROC") != null) {
                   dtoCI.setFechaProceso((java.sql.Date)rsAux.getValueAt(0, "FEC_PROC"));
                }
                if (rsAux.getValueAt(0, "OID_PERI") != null) {
                    dtoCI.setOidPeriodo(new Long(rsAux.getValueAt(0, "OID_PERI").toString()));
                }
                
            }
        }

        UtilidadesLog.info("MONCierreFacturacionBean.cargaInicialCierre(DTOBelcorp dto): Salida");        
        return dtoCI;
        
    }

    // sapaza -- PER-SiCC-2011-0594 -- 18/08/2011      
    private String obtenerValorParametroPais(Long oidPais) throws MareException {
        DAOFACCierreFacturacion daoCierre = new DAOFACCierreFacturacion();
        String indCierre = "0";
        
        String indicador = daoCierre.obtenerValorParametroPais(oidPais, "FAC","001");
        if(indicador != null) indCierre = indicador;
        
        return indCierre;
    }
    
}
