package es.indra.sicc.logicanegocio.intsys;
import es.indra.mare.common.dto.IMareDTO;
import es.indra.mare.common.dto.MareDTO;
import es.indra.mare.common.exception.MareException;
import es.indra.mare.common.mgc.MareMGC;
import es.indra.mare.common.mii.MareMii;
import es.indra.mare.common.mii.MareTopic;
import es.indra.mare.common.mln.MareBusinessID;
import es.indra.sicc.cmn.negocio.batch.DTOBatch;
import es.indra.sicc.cmn.negocio.batch.DTOSalidaBatch;
import es.indra.sicc.cmn.negocio.batch.DTOSubBatch;
import es.indra.sicc.cmn.negocio.batch.MONBatch;
import es.indra.sicc.cmn.negocio.batch.util.BatchUtil;
import es.indra.sicc.cmn.negocio.interfaces.IGestorInterfaces;
import es.indra.sicc.cmn.negocio.interfaces.comun.IRegistroSicc;
import es.indra.sicc.cmn.negocio.interfaces.comun.InterfacesException;
import es.indra.sicc.cmn.negocio.interfaces.comun.InterfazInfo;
import es.indra.sicc.cmn.negocio.interfaces.fachada.MONGestorInterfaces;
import es.indra.sicc.dtos.ped.DTOEjecucionProcesos;
import es.indra.sicc.entidades.seg.PaisLocal;
import es.indra.sicc.entidades.seg.PaisLocalHome;
import es.indra.sicc.util.BelcorpService;
import es.indra.sicc.util.CodigosError;
import es.indra.sicc.util.DTOString;
import es.indra.sicc.util.UtilidadesEJB;
import es.indra.sicc.util.UtilidadesError;
import es.indra.sicc.util.UtilidadesLog;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import javax.ejb.CreateException;
import javax.ejb.SessionBean;
import javax.ejb.SessionContext;
import es.indra.sicc.cmn.negocio.interfaces.fachada.MONGestorInterfacesHome;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.rmi.PortableRemoteObject;
import es.indra.sicc.dtos.intsys.DTOSecuenciacionClienteAPP;
import es.indra.mare.enterprise.mln.BusinessFacadeHome;
import es.indra.mare.enterprise.mln.BusinessFacadeLocalHome;

public class MONSecuenciacionAPPBean implements SessionBean  {
    public void ejbCreate() {
    }

    public void ejbActivate() {
    }

    public void ejbPassivate() {
    }

    public void ejbRemove() {
    }

    public void setSessionContext(SessionContext ctx) {
    }

    private String IDProc = null;  
    private Long tamanioSegmentoAPP_01 = null;
    private Long numeroMaximoSegmentosAPP_01 = null;

    public DTOSalidaBatch recepcionarSecuenciacionAPPBatch(DTOBatch dtoBatch) throws MareException {
        UtilidadesLog.info("MONSecuenciacionAPPBean.recepcionarSecuenciacionAPPBatch(DTOBatch dtoBatch): Entrada");
        Date initTransaction = new Date(System.currentTimeMillis());
        IMareDTO dtoPais = (DTOString)dtoBatch.getDTOOnline();
        this.IDProc = dtoBatch.getProcessID();
        int cantRegistros = 0;
        this.obtenerTamanioSegmentoAPP_01();
        
        PaisLocalHome paisHome = this.getPaisLocalHome();
        PaisLocal paisLocal = null;
        try{
          paisLocal = paisHome.findByUk(dtoPais.getString("cadena"));
        }catch(Exception e){
            UtilidadesLog.error("ERROR",e);
            throw new MareException();
        }

        ArrayList arrayRegistros = new ArrayList();
        MONGestorInterfaces g = null;
        InterfazInfo info = null;
        try {
            MONGestorInterfacesHome gint = getMONGestorInterfacesHome();            
            g = gint.create();
    
            info = new InterfazInfo(IGestorInterfaces.COD_INTERFAZ_APP01, new Long(getMONGestorInterfacesHome().create().obtenerNumeroLote()).toString(),  paisLocal.getOid());
            info.setDescripcionLote("");
            info.setObservaciones("");
    
            info = g.importarInterfaz(info);            
            String pais = new String("");            
            DTOSecuenciacionClienteAPP dtoSecuenciacion = null;
            for (IRegistroSicc registro = g.cargarRegistro(info, false);registro != null;registro = g.cargarRegistro(info, false)){
                if (cantRegistros == 0) {
                    pais = (String)registro.obtenerCampo(IRegistroSicc.APP01_CODIGO_PAIS);
                    if (!dtoPais.getString("cadena").equalsIgnoreCase(pais.toString())) {
                        UtilidadesLog.debug("El codigo de Pais Invalido --- Proceso Recepcionar Secuenciacion de Cliente (APP) Finalizado");
                        break;
                    }
                }
                dtoSecuenciacion = new DTOSecuenciacionClienteAPP();
                dtoSecuenciacion.setCodigoPais(pais);
                dtoSecuenciacion.setCodigoZona((String)registro.obtenerCampo(IRegistroSicc.APP01_CODIGO_ZONA));
                dtoSecuenciacion.setCodigoCliente((String)registro.obtenerCampo(IRegistroSicc.APP01_CODIGO_CLIENTE));
                dtoSecuenciacion.setCodigoSecuencia((String)registro.obtenerCampo(IRegistroSicc.APP01_SECUENCIA_CLIENTE));
                arrayRegistros.add(dtoSecuenciacion);
                cantRegistros++;                
            }
            UtilidadesLog.warn("Cantidad Registros Cargados = " + cantRegistros);
            
        } catch (NamingException Ne) {
            UtilidadesLog.error(Ne);                        
            throw new MareException(Ne, UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
        } catch (RemoteException ne) {            
            if ( ne.detail != null && (ne.detail instanceof InterfacesException ) ) {
                UtilidadesLog.error("Excepcion de la Interfaz " +  ((InterfacesException)ne.detail).getMotivo() , ne.detail );
            } else {                
                throw new MareException(ne, UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
            }
        } catch (CreateException ne) {
            UtilidadesLog.error(ne);
            throw new MareException(ne, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS));
        } catch (InterfacesException ie) {            
            UtilidadesLog.debug("Excepcion de la Interfaz: "+ ie.getMotivo());
            throw new MareException(ie.getMotivo(), ie);
        } catch (Exception e) {            
            UtilidadesLog.error(e);            
            throw new MareException("Error", e);
        } finally {
           try {
                g.cerrarInterfaz(info);            
            } catch (RemoteException ne) {            
                if ( ne.detail != null && (ne.detail instanceof InterfacesException ) ) {
                    UtilidadesLog.error("Excepcion de la Interfaz " +  ((InterfacesException)ne.detail).getMotivo() , ne.detail );
                } else {                
                    throw new MareException(ne, UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
                }
            } catch (InterfacesException ie) {            
                UtilidadesLog.debug("Excepcion de la Interfaz: "+ ie.getMotivo());
                throw new MareException(ie.getMotivo(), ie);
            } 
        }   
        
        try {
            String query = new String("TRUNCATE TABLE APP_RUTAS_CLIEN;");
            try {
                BelcorpService.getInstance().dbService.executeProcedure("PQ_PLANI.EXECUTOR", query.toString());
            } catch(Exception e) {
                UtilidadesLog.error("ERROR",e);
                throw new MareException(e);
            }    
            Iterator it = (Iterator)arrayRegistros.iterator();
            cantRegistros = 0;
            int segmentosEjecutandoSimultaneamente = 0;
            ArrayList arrayRegistrosGrupo = new ArrayList();
            while (it.hasNext()) {
                    arrayRegistrosGrupo.add((DTOSecuenciacionClienteAPP)it.next());
                    cantRegistros++;
                    if (this.tamanioSegmentoAPP_01.longValue() == cantRegistros || (!(it.hasNext()))){
                         ejecutarGrupo(arrayRegistrosGrupo, dtoBatch.getUser(), paisLocal.getOid());
                         cantRegistros = 0;
                         arrayRegistrosGrupo.clear();
                         segmentosEjecutandoSimultaneamente++;
                         if(this.numeroMaximoSegmentosAPP_01.intValue() == segmentosEjecutandoSimultaneamente) {
                            UtilidadesLog.debug("*** Se espera el procesamiento en Batch de los Segmentos de APP_01***");                                    
                            this.esperarProcesamiento();
                            segmentosEjecutandoSimultaneamente= 0;
                        }
                   } 
            }
            
            if (arrayRegistrosGrupo.size() > 0)
              ejecutarGrupo(arrayRegistrosGrupo, dtoBatch.getUser(), paisLocal.getOid());
        
            this.esperarProcesamiento();

        } catch (Exception e) {
           UtilidadesLog.error("ERROR",e);
           throw new MareException(e); 
        }        
        UtilidadesLog.warn("Proceso Recepcionar Secuenciacion de Cliente (APP) ----> " + (System.currentTimeMillis() - initTransaction.getTime()));
        UtilidadesLog.info("MONSecuenciacionAPPBean.recepcionarSecuenciacionAPPBatch(DTOBatch dtoBatch): Salida");        
        return new DTOSalidaBatch(0, "Proceso Recepcionar Secuenciacion de Cliente (APP) por Demonio Finalizado");
    }

    private MONGestorInterfacesHome getMONGestorInterfacesHome() throws NamingException {
        final InitialContext context = new InitialContext();
        return (MONGestorInterfacesHome)PortableRemoteObject.narrow(context.lookup("java:comp/env/MONGestorInterfaces"), MONGestorInterfacesHome.class);
    }

    private PaisLocalHome getPaisLocalHome() throws MareException {
        PaisLocalHome paisHome = (PaisLocalHome)UtilidadesEJB.getLocalHome("java:comp/env/Pais");
        return paisHome;

    }

    private void generarInsertSecuenciacion(ArrayList arrayRegistros, Long oidPais) throws MareException {
        UtilidadesLog.info("MONSecuenciacionAPPBean.generarInsertSecuenciacion(ArrayList arrayRegistros): Entrada");        
        StringBuffer query = new StringBuffer();
        
        Iterator it = (Iterator)arrayRegistros.iterator();
        
        while (it.hasNext()) {
             DTOSecuenciacionClienteAPP dtoSecuenciacion = (DTOSecuenciacionClienteAPP)it.next();
             query.append("INSERT INTO APP_RUTAS_CLIEN (");
             query.append("   OID_APP_RUTA_CLIE, ");
             query.append("   VAL_NUME_SECU, ");
             query.append("   CLIE_OID_CLIE, ");
             query.append("   PAIS_OID_PAIS, ");
             query.append("   RUTR_OID_RUTA_TRAN) ");
             query.append("VALUES ");
             query.append("(APP_APRC_SEQ.NEXTVAL,");
             query.append(dtoSecuenciacion.getCodigoSecuencia()).append(", ");
             query.append(" (SELECT MC.OID_CLIE");
             query.append(" FROM MAE_CLIEN MC ");
             query.append(" WHERE MC.PAIS_OID_PAIS = ").append(oidPais);
             query.append("  AND MC.COD_CLIE = '").append(dtoSecuenciacion.getCodigoCliente()).append("'),");
             query.append(oidPais).append(",");
             query.append(" (SELECT ART.OID_RUTA_TRAN");
             query.append(" FROM APP_RUTAS_TRANS ART    ");
             query.append(" WHERE ART.COD_RUTA = ").append(dtoSecuenciacion.getCodigoZona()).append(")");
             query.append(");");
        }

        try{
            BelcorpService.getInstance().dbService.executeProcedure("PQ_PLANI.EXECUTOR", query.toString());
        }catch(Exception e){
            UtilidadesLog.error("ERROR",e);
            throw new MareException(e);
        }    
        
        UtilidadesLog.info("MONSecuenciacionAPPBean.generarInsertSecuenciacion(ArrayList arrayRegistros): Salida");        
    }


    private MareDTO ejecutarGrupo(ArrayList lista, String user, Long oidPais)throws Exception{
        UtilidadesLog.info("MONSecuenciacionAPPBean.ejecutarGrupo(ArrayList lista, String user, Long oidPais): Entrada");
        MareDTO mDTOResu = new MareDTO();
        DTOEjecucionProcesos dtoEP = new DTOEjecucionProcesos(); 
        dtoEP.setListaSolicitudes(lista);
        dtoEP.setOidPais(oidPais);
        MareBusinessID mBI = new MareBusinessID("INTRecepcionarSecuenciacionAPPSegmentoBatch");
        
        DTOSubBatch dtoSB = new DTOSubBatch(new String("SEGMENTO_APP-01_"), this.IDProc, user, mBI, dtoEP); 
        BatchUtil batch = new BatchUtil();
        mDTOResu = batch.executeMLN(dtoSB, "PEDSegmentosProcesos");
        UtilidadesLog.info("MONSecuenciacionAPPBean.ejecutarGrupo(ArrayList lista, String user, Long oidPais): Salida");
        return mDTOResu;        
    }


    protected void obtenerTamanioSegmentoAPP_01() throws MareException {
        UtilidadesLog.info("MONSecuenciacionAPPBean.obtenerTamanioSegmentoAPP_01(): Entrada ");
        if (this.tamanioSegmentoAPP_01 == null){
            MareMGC mgc = (MareMGC) MareMii.getService(new MareTopic(MareMii.SERVICE_MGC));
            String tamanio = (String) mgc.getProperty("application.TamanioSegmentoAPP_01");
            if ((tamanio == null) || (tamanio.equals(""))) {
                UtilidadesLog.warn("MONSecuenciacionAPPBean.TamanioSegmentoAPP_01(): null!!! (application.properties no existe la linea: TamanioSegmentoAPP_01) se tomara 5000.");
                this.tamanioSegmentoAPP_01 = new Long(5000);
            } else {
                this.tamanioSegmentoAPP_01 = new Long(tamanio);
            }
            String nmaximo = (String) mgc.getProperty("application.NumeroMaximoSegmentosAPP_01");
            if ((nmaximo == null) || (nmaximo.equals(""))) {
                UtilidadesLog.warn("MONSecuenciacionAPPBean.NumeroMaximoSegmentosAPP_01 es null!!! (application.properties no existe la linea: NumeroMaximoSegmentosAPP_01) se tomara 4.");
                this.numeroMaximoSegmentosAPP_01 = new Long(4);
            } else {
                this.numeroMaximoSegmentosAPP_01 = new Long(nmaximo);
            } 
        }
        UtilidadesLog.info("MONSecuenciacionAPPBean.obtenerTamanioSegmentoAPP_01(): Salida ");	
    }

    protected void esperarProcesamiento() throws MareException {
        UtilidadesLog.info("MONSecuenciacionAPPBean.esperarProcesamiento(): Entrada");
        try {
            if (this.IDProc != null) {
                MONBatch mb = new MONBatch();
                mb.esperarHijos(this.IDProc);
            }  
        } catch (InterruptedException ie) {
            throw new MareException ("Error ejecutando Esperar Procesamiento", ie);
        }  
        UtilidadesLog.info("MONSecuenciacionAPPBean.esperarProcesamiento(): Salida");
    }


    private BusinessFacadeHome getBusinessFacadeHome() throws NamingException {
        final InitialContext context = new InitialContext();
        return (BusinessFacadeHome)PortableRemoteObject.narrow(context.lookup("java:comp/env/BusinessFacade"), BusinessFacadeHome.class);
    }

    private BusinessFacadeLocalHome getBusinessFacadeLocalHome() throws NamingException {
        final InitialContext context = new InitialContext();
        return (BusinessFacadeLocalHome)context.lookup("java:comp/env/BusinessFacadeBATCH");
    }

    public DTOSalidaBatch procesarSegmento(DTOBatch dtoin) throws MareException {
        UtilidadesLog.info("MONSecuenciacionAPPBean.procesarSegmento(DTOBatch dtoin): Entrada");
        DTOEjecucionProcesos dto = (DTOEjecucionProcesos) dtoin.getDTOOnline();
        ArrayList array = dto.getListaSolicitudes();
        this.generarInsertSecuenciacion(array, dto.getOidPais());  
          
        UtilidadesLog.info("MONSecuenciacionAPPBean.procesarSegmento(DTOBatch dtoin): Salida");
        return new DTOSalidaBatch(0, "Ejecucion Segmento Recepcionar Secuenciacion de Cliente (APP) por Demonio Completo");  
    }

}