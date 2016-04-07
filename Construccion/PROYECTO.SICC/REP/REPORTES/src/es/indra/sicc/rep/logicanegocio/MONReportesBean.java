package es.indra.sicc.rep.logicanegocio;


import es.indra.mare.common.exception.MareException;
import es.indra.mare.common.mii.services.jdbcservice.RecordSet;
import es.indra.mare.common.mln.MareBusinessID;
import es.indra.mare.enterprise.mln.BusinessFacadeLocalHome;
import es.indra.sicc.cmn.negocio.batch.DTOBatch;
import es.indra.sicc.cmn.negocio.batch.DTOSalidaBatch;
import es.indra.sicc.cmn.negocio.batch.util.BatchUtil;
import es.indra.sicc.dtos.cra.DTOPeriodo;
import es.indra.sicc.entidades.rep.RepReporLocal;
import es.indra.sicc.entidades.rep.RepReporLocalHome;
import es.indra.sicc.logicanegocio.seg.ConstantesSEG;
import es.indra.sicc.rep.dtos.DTOBusquedaRapidaProductos;
import es.indra.sicc.rep.dtos.DTOCriteriosReportes;
import es.indra.sicc.rep.dtos.DTOEstructuraFacturacion;
import es.indra.sicc.rep.dtos.DTOPeriodoCorporativos;
import es.indra.sicc.rep.dtos.DTOReporte;
import es.indra.sicc.rep.dtos.DTOValidaCodigoVenta;
import es.indra.sicc.util.CodigosError;
import es.indra.sicc.util.DTOBelcorp;
import es.indra.sicc.util.DTOBoolean;
import es.indra.sicc.util.DTOSalida;
import es.indra.sicc.util.DTOString;
import es.indra.sicc.util.UtilidadesError;
import es.indra.sicc.dtos.zon.DTOUnidadAdministrativa;
import java.rmi.RemoteException;
import java.sql.Timestamp;
import javax.ejb.SessionBean;
import javax.ejb.SessionContext;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import es.indra.sicc.util.DTOOID;
import es.indra.sicc.rep.dtos.DTORecargaComisiones;
import es.indra.sicc.util.UtilidadesBD;
import es.indra.sicc.util.UtilidadesLog;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceException;
import oracle.sql.BLOB;

public class MONReportesBean implements SessionBean 
{
  private SessionContext sessionContext;
  
  public void ejbCreate()
  {
  }

  public void ejbActivate()
  {
  }

  public void ejbPassivate()
  {
  }

  public void ejbRemove()
  {
  }

  public void setSessionContext(SessionContext ctx) {
      sessionContext = ctx;
  }

  /**
   * CHANGELOG
   * ---------
   * Incidencia SiCC 20090889 - dmorello, 20/04/2009
   * - Se reemplaza uso de entity GenReporLocal por JDBC.
   */
  public DTOString lanzarBatch(DTOReporte dtoin) throws MareException {

        RepReporLocal rrL;
       // System.out.println("dentro de: lanzarBatch, recibo: " + dtoin);
        DTOString dtoResu = new DTOString();
        DAOFrontReport daoFR = new  DAOFrontReport();
        Long oidSecuencia = null;
        try {
          
          //busco en rep_reporte el oid, perteneciente al codigo que me pasa matias....
         // System.out.println("voy a buscar en RepReport: " + dtoin.getIdReporte());
          RepReporLocalHome rrLH =  getRepReporLocalHome();
          rrL = rrLH.findByUk(dtoin.getIdReporte());

        } catch (NoResultException fe) {
           // System.out.println("finder exception!!");
            fe.printStackTrace();
            sessionContext.setRollbackOnly();
            throw new MareException(fe,
                UtilidadesError.armarCodigoError(
                    CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE));
        } catch (Exception e) {
           // System.out.println("finder exception3!!");
            e.printStackTrace();
            sessionContext.setRollbackOnly();
            throw new MareException(e,
                UtilidadesError.armarCodigoError(
                    CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));        
        }
        
      //  System.out.println("el oid " + rrL.getOidRepo());
       // System.out.println("paso 1");
        //inserto registro en gen reporte, con el oid del proceso dummy dado que como no ejecute
        //todavia batch, no tengo el codigo....
        Timestamp time = new Timestamp(System.currentTimeMillis());     
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String fecha = sdf.format(time);
      
       // System.out.println("paso 2");
        try {
        // System.out.println("paso 3");
            
          //  System.out.println("paso 4 ....");
             
            oidSecuencia = daoFR.insertGenRep(new String("Encolado..."),
                                              sessionContext.getCallerPrincipal().getName(),   
                                              fecha,
                                              dtoin.getParametros().get("MODULO").toString(),
                                              rrL.getOidRepo(),
                                              dtoin.getParametros().get("EXTENSION").toString());
                                
        } catch (PersistenceException createException) {
           // System.out.println("error de creacion!!!!!");
            createException.printStackTrace();
            this.sessionContext.setRollbackOnly();
            throw new MareException(createException,
                UtilidadesError.armarCodigoError(
                    CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS));
        } catch (Exception exception) {
            exception.printStackTrace();
            this.sessionContext.setRollbackOnly();
            throw new MareException(exception,
                UtilidadesError.armarCodigoError(
                    CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS));
        }
        ///////////////////////////////////////////////////////////
        //Creo un DTOBatch .....
      //  System.out.println("paso 6 ....");
        MareBusinessID id = new MareBusinessID(new String("REPInvocarPedidoReporte"));
       // System.out.println("paso 7.....");                    
        dtoin.setOidReporte(oidSecuencia);
        
      //  System.out.println("paso 8 ......");
        
        DTOBatch dtoB = new DTOBatch(new String("REPORTES_"+rrL.getCodRepo()), id, dtoin, sessionContext.getCallerPrincipal().getName());
        
        DTOSalidaBatch salidaBatch = null;
            
        try {
            BatchUtil batch = new BatchUtil();
            salidaBatch = (DTOSalidaBatch)batch.executeMLN(dtoB, "REPProcesosBatch"); 
        } catch (RemoteException re) {
            re.printStackTrace();
            sessionContext.setRollbackOnly();
            throw new MareException(re,
                UtilidadesError.armarCodigoError(
                    CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
        }                    
        //ahora actualizo el codigo de proceso....
        daoFR.actualizarProcessID(oidSecuencia, salidaBatch.getProcessID());
      //  System.out.println("el id de procesos" + salidaBatch.getProcessID());
        dtoResu.setCadena(salidaBatch.getProcessID());       
      //  System.out.println("retorno: " + dtoResu);
    return dtoResu;
  }

  private BusinessFacadeLocalHome getBusinessFacadeLocalHome() throws NamingException
  {
    final InitialContext context = new InitialContext();
    return (BusinessFacadeLocalHome)context.lookup("java:comp/env/BusinessFacadeBATCH");
  }

     private RepReporLocalHome getRepReporLocalHome() {       
       return new RepReporLocalHome();
     }


    public DTOReporte verReporte(DTOString dtoCodRep) throws MareException
  {
      //  System.out.println("dentro de verReporte(...., recibo " + dtoCodRep);
        DTOReporte dtoR = new DTOReporte();
        String codRep = dtoCodRep.getCadena();
        DAOFrontReport dfr = new DAOFrontReport();
        RepReporLocal rrL = null;
        
        try {
             //veo es status de la generacion del reporte
             if (dfr.statusGeneracion(codRep).intValue() == 0) {
               //encolado
               throw new MareException(new Exception(), 
                      UtilidadesError.armarCodigoError(CodigosError.ERROR_REPORTE_ENCOLADO));             
             } else if(dfr.statusGeneracion(codRep).intValue() == 1) {  
               //ejecutandose
               throw new MareException(new Exception(), 
                      UtilidadesError.armarCodigoError(CodigosError.ERROR_REPORTE_EJECUTANDOSE));             
             } else if(dfr.statusGeneracion(codRep).intValue() == 2) {    
               //finalizado, finder!!
               RecordSet reportes = new DAOFrontReport().obtenerReportesPorCodProc(codRep);
               UtilidadesLog.debug("reportes.rowCount = " + reportes.getRowCount());
             
                if ((reportes.getRowCount() > 0)) {
               
                 int i = 0;
                 byte[] b = null;
                 Long oidRepo = null;
                  while (i < reportes.getRowCount()) {
                   b = UtilidadesBD.oracleBlobToByteArray((BLOB)reportes.getValueAt(i, "VAL_INFO"));
                   UtilidadesLog.debug("b.length: " + b.length);
                   oidRepo = new Long(((BigDecimal)reportes.getValueAt(i, "RREP_OID_REPO")).longValue());
                   i++;
                 }
                 if (b==null){
                  //  System.out.println("exc. el blob esta vacio......");
                    throw new MareException(new Exception(), UtilidadesError.armarCodigoError(ConstantesSEG.MODULO_REP + CodigosError.ERROR_DE_LECTURA_BLOB));             
//     	  	          throw new MareException(null, null,
                       	//UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_LECTURA_BLOB));             
                 }
                // System.out.println("blob, mide: " + b.length);
               //  System.out.println("y es: " + b);
               
                 dtoR.setResultados(b);
                 //busco el nombre del reporte (codigo!)....
                 try { 
                  // System.out.println("voy a buscar en RepReport: " + oidRepo);
                   RepReporLocalHome rrLH =  getRepReporLocalHome();
                   rrL = rrLH.findByPrimaryKey(oidRepo);  
                  // System.out.println("El oid de reporte, rescato: " + rrL.getCodRepo());
                   dtoR.setNombreResultados(rrL.getCodRepo());
                 } catch (NoResultException ez) {
                  // System.out.println("en tabla REP_REPOR, no se hallo el cod. de reporte: " + rrL.getCodRepo());
                   throw new MareException(new Exception(), 
                            UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE));             
                 }
               } else {
                //  System.out.println("Algo anda mal");
                  throw new MareException(new Exception(), 
                            UtilidadesError.armarCodigoError(ConstantesSEG.MODULO_REP + CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE));             
               }               
             } else if(dfr.statusGeneracion(codRep).intValue() == 3) { 
               //erroneo               
               throw new MareException(new Exception(), 
                      UtilidadesError.armarCodigoError(ConstantesSEG.MODULO_REP + CodigosError.ERROR_REPORTE_FIN_ERRONEO));             
             } else if(dfr.statusGeneracion(codRep).intValue() == 4) { 
               //abortado
               throw new MareException(new Exception(), UtilidadesError.armarCodigoError(ConstantesSEG.MODULO_REP + CodigosError.ERROR_REPORTE_ABORTADO));             
             }  
        } catch (NoResultException ez) {
            ez.printStackTrace();
           // System.out.println("##### por naming FinderException.......");
            throw new MareException(ez,
                UtilidadesError.armarCodigoError(
                    CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE));
        } catch (MareException exception) {        
            throw exception;
        } catch (Exception exception) {
              // System.out.println("no deberia haber entrado por aca, es seguramente error de codigo..");
               exception.printStackTrace();
               throw new MareException(new Exception(), 
               UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_LECTURA_BLOB));                     
        }  
       // System.out.println("retorno: " + dtoR);
        return dtoR;
 }

  public DTOSalida consultarEstados(DTOCriteriosReportes dtoin) throws MareException {
         DTOSalida dtoS = new  DTOSalida();
         DAOFrontReport miDAO = new DAOFrontReport();
         dtoS.setResultado(miDAO.consultarReportes(dtoin));
         return dtoS;
  }

    public DTOBoolean validaCodigoVenta(DTOValidaCodigoVenta dto) throws MareException{
        DAOFrontReport dao = new DAOFrontReport();
        return dao.validaCodigoVenta(dto);
    }

     public DTOSalida obtenerPeriodosCorporativos(DTOPeriodoCorporativos dto) throws MareException{
        DAOFrontReport dao = new DAOFrontReport();
        return dao.obtenerPeriodosCorporativos(dto);
    }

    public DTOSalida obtenerZonasParaListaOculta(DTOBelcorp dto) throws MareException{
        DAOFrontReport dao = new DAOFrontReport();
        return dao.obtenerZonasParaListaOculta(dto);
    }

    public DTOSalida busquedaRapidaProductos(DTOBusquedaRapidaProductos dto) throws MareException    {
        DAOFrontReport dao = new DAOFrontReport();
        return dao.busquedaRapidaProductos(dto);
    }

    public DTOSalida periodosCronogramaTotalGrupo(DTOPeriodo dto) throws MareException{
        DAOFrontReport dao = new DAOFrontReport();
        return dao.periodosCronogramaTotalGrupo(dto);    
    }

    public DTOSalida obtenerModulos(DTOBelcorp dto) throws MareException    {
       DAOFrontReport dao = new DAOFrontReport();
       return dao.obtenerModulos(dto);    
    }

    public DTOSalida obtenerMarcaProducto(DTOBelcorp dto) throws MareException{
       DAOFrontReport dao = new DAOFrontReport();
       return dao.obtenerMarcaProducto(dto);    
    }

    public DTOSalida obtenerPeriodosEstructuraFacturacion(DTOEstructuraFacturacion dto) throws MareException{        
       DAOFrontReport dao = new DAOFrontReport();
       return dao.obtenerPeriodosEstructuraFacturacion(dto); 
    }

    public DTOSalida obtenerZonasEstructuraFacturacion(DTOEstructuraFacturacion dto) throws MareException{
       DAOFrontReport dao = new DAOFrontReport();
       return dao.obtenerZonasEstructuraFacturacion(dto); 
    }

    public DTOSalida obtener5PeriodosPosteriores(DTOPeriodo dto) throws MareException{
       DAOFrontReport dao = new DAOFrontReport();
       return dao.obtener5PeriodosPosteriores(dto); 
    }

    public DTOSalida obtenerOperacionesSinAnulaciones(DTOBelcorp dto) throws MareException{
       DAOFrontReport dao = new DAOFrontReport();
       return dao.obtenerOperacionesSinAnulacion(dto); 
    }

  public DTOSalida obtenerConsursosMarcas(DTOString dto) throws MareException {
       DAOFrontReport dao = new DAOFrontReport();
       return dao.obtenerConsursosMarcas(dto); 
  }

  public DTOSalida obtenerPeriodosConcurso(DTOOID dto) throws MareException {
       DAOFrontReport dao = new DAOFrontReport();
       return dao.obtenerPeriodosConcurso(dto); 
  }

  public DTOSalida obtener4PeriodosPosteriores(DTOOID dto) throws MareException {
       DAOFrontReport dao = new DAOFrontReport();
       return dao.obtener4PeriodosPosteriores(dto); 
    
  }

  public DTOSalida recargaComisiones(DTORecargaComisiones dto) throws MareException {
       DAOFrontReport dao = new DAOFrontReport();
       return dao.recargaComisiones(dto); 
  }

  public DTOSalida obtenerMoneda(DTOBelcorp dto) throws MareException{
       DAOFrontReport dao = new DAOFrontReport();
       return dao.obtenerMoneda(dto); 
  }

  public DTOSalida cargarPeriodosREP(DTOPeriodo dto) throws MareException {
       DAOFrontReport dao = new DAOFrontReport();
       return dao.cargarPeriodosREP(dto); 
  }

  public DTOSalida recargarRegionesRep(DTOString dto) throws MareException {
       DAOFrontReport dao = new DAOFrontReport();
       return dao.recargarRegionesRep(dto); 
  }

  public DTOSalida recargarZonasRep(DTOString dto) throws MareException {
       DAOFrontReport dao = new DAOFrontReport();
       return dao.recargarZonasRep(dto); 
  }

  public DTOSalida recargarSeccionesRep(DTOString dto) throws MareException {
       DAOFrontReport dao = new DAOFrontReport();
       return dao.recargarSeccionesRep(dto); 
  }

  public DTOSalida recargarTerritoriosRep(DTOString dto) throws MareException {
       DAOFrontReport dao = new DAOFrontReport();
       return dao.recargarTerritoriosZonasRep(dto);
  }

  public DTOSalida recargarTerritoriosSeccionesRep(DTOString dto) throws MareException {
       DAOFrontReport dao = new DAOFrontReport();
       return dao.recargarTerritoriosSeccionesRep(dto);
  }

  public DTOSalida recargarNivelesConcursos(DTOString dto) throws MareException {
       DAOFrontReport dao = new DAOFrontReport();
       return dao.recargarNivelesConcursos(dto);
  }

    public DTOSalida recargaNumerosDescuentosRep(DTOString dto) throws MareException {
       DAOFrontReport dao = new DAOFrontReport();
       return dao.recargaNumerosDescuentosRep(dto);
    }

    public DTOSalida recargaTipoSolicitudPorClaseRep(DTOString dto) throws MareException {
       DAOFrontReport dao = new DAOFrontReport();
       return dao.recargaTipoSolicitudPorClaseRep(dto);
    }

    public DTOSalida recargarRegionesParaListaCanalRep(DTOUnidadAdministrativa dto) throws MareException {
        DAOFrontReport dao = new DAOFrontReport();
        return dao.recargarRegionesParaListaCanalRep(dto);
    }

    public DTOSalida recargarGerentesRegionRep(DTOString dto) throws MareException {
       DAOFrontReport dao = new DAOFrontReport();
       return dao.recargarGerentesRegionRep(dto);
    }
 }