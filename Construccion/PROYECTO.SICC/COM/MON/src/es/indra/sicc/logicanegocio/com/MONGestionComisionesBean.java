package es.indra.sicc.logicanegocio.com;

import es.indra.sicc.cmn.negocio.i18n.Entidadi18nLocal;
import es.indra.sicc.cmn.negocio.i18n.Entidadi18nLocalHome;
import es.indra.sicc.dtos.cra.DTOPeriodo;
import es.indra.sicc.entidades.com.ComisionesLocal;
import es.indra.sicc.entidades.com.ComisionesLocalHome;
import es.indra.sicc.logicanegocio.cra.MONPeriodos;
import es.indra.sicc.logicanegocio.cra.MONPeriodosHome;
import es.indra.sicc.util.UtilidadesEJB;
import es.indra.sicc.util.UtilidadesLog;
import java.rmi.RemoteException;
import java.sql.Date;
import java.sql.Timestamp;
import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.Collection;
import java.util.Iterator;
import java.util.Vector;
import javax.ejb.CreateException;
import javax.ejb.SessionBean;
import javax.ejb.SessionContext;
import es.indra.sicc.util.DTOSalida;
import es.indra.sicc.util.DTOOID;
import es.indra.mare.common.exception.MareException;
import es.indra.sicc.util.DTOBelcorp;
import es.indra.sicc.dtos.com.DTOEstados;
import es.indra.sicc.dtos.com.DTOBuscarInsertarComisiones;
import es.indra.sicc.dtos.com.DTOBuscarModificar;
import es.indra.sicc.dtos.com.DTOEstadoComision;
import es.indra.sicc.dtos.com.DTOBuscarMarcarModificar;
import es.indra.sicc.dtos.com.DTOPermitirModificar;
import es.indra.sicc.dtos.com.DTOCodigoComision;
import es.indra.sicc.dtos.com.DTOComisionesProductos;
import es.indra.sicc.logicanegocio.com.DAOGestionComisiones;
import es.indra.sicc.logicanegocio.cra.DAOCRA;
import es.indra.sicc.entidades.com.PlantillasComisionesMarcaLocalHome;
import es.indra.sicc.entidades.com.PlantillasComisionesMarcaLocal;
import es.indra.sicc.entidades.mae.MaestroProductosLocalHome;
import es.indra.sicc.entidades.mae.MaestroProductosLocal;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.ejb.FinderException;
import java.math.BigDecimal;
import es.indra.sicc.util.CodigosError;
import es.indra.sicc.util.UtilidadesError;
import es.indra.sicc.logicanegocio.com.ErroresDeNegocio;
import es.indra.sicc.logicanegocio.seg.ConstantesSEG;
import es.indra.mare.common.mii.services.jdbcservice.RecordSet;
import javax.rmi.PortableRemoteObject;
import es.indra.sicc.dtos.com.DTOComisiones;
import es.indra.sicc.dtos.com.DTOComisionesEscalonada;
import es.indra.sicc.util.BelcorpService;
import es.indra.sicc.entidades.com.ComisionesCobranzasLocalHome;
import es.indra.sicc.entidades.com.ComisionesCobranzasLocal;
import es.indra.sicc.entidades.com.ComisionesVentaHistoricaLocalHome;
import es.indra.sicc.entidades.com.ComisionesVentaHistoricaLocal;

import es.indra.sicc.entidades.com.ComisionesVentasLocalHome;
import es.indra.sicc.entidades.com.ComisionesVentasLocal;
import es.indra.sicc.entidades.com.ComisionesClientesLocalHome;
import es.indra.sicc.entidades.com.ComisionesClientesLocal;
import es.indra.sicc.entidades.com.ComisionesProductosLocalHome;
import es.indra.sicc.entidades.com.ComisionesProductosLocal;
import es.indra.sicc.entidades.com.ComisionesAccesoLocalHome;
import es.indra.sicc.entidades.com.ComisionesAccesoLocal;
import es.indra.sicc.entidades.com.ComisionesCobranzasTipoParticipanteLocalHome;
import es.indra.sicc.entidades.com.ComisionesCobranzasTipoParticipanteLocal;
import es.indra.sicc.entidades.com.PlantillasComisionesPaisLocalHome;

import java.util.ArrayList;

import javax.persistence.NoResultException;
import javax.persistence.PersistenceException;


public class MONGestionComisionesBean implements SessionBean {
  private SessionContext ctx;

  public void ejbCreate() {  }
  public void ejbActivate() {  }
  public void ejbPassivate()  {  }
  public void ejbRemove()  {  }

  public void setSessionContext(SessionContext ctx)  {
        this.ctx = ctx;
  }

  /**
   * Autor: Cristian Valenzuela
   * Metodo: obtenerCanalesPlantillas
   * Fecha: 7/3/2005
   */
  public DTOSalida obtenerCanalesPlantillas(DTOBelcorp dto) throws MareException  {
    UtilidadesLog.info("MONGestionComisionesBean.obtenerCanalesPlantillas(DTOBelcorp dto): Entrada");
    DTOSalida dtoSalida = null;
    DAOGestionComisiones dao = new DAOGestionComisiones();
    dtoSalida = dao.obtenerCanalesPlantillas(dto);
    UtilidadesLog.info("MONGestionComisionesBean.obtenerCanalesPlantillas(DTOBelcorp dto): Salida");
    return dtoSalida;
  }

  /**
   * Autor: Cristian Valenzuela
   * Metodo: obtenerDescripcionesPlantillas
   * Fecha: 7/3/2005
   */
  public DTOSalida obtenerDescripcionesPlantillas(DTOBelcorp dto) throws MareException  {
    UtilidadesLog.info("MONGestionComisionesBean.obtenerDescripcionesPlantillas(DTOBelcorp dto): Entrada");
    DTOSalida dtoSalida = null;
    DAOGestionComisiones dao = new DAOGestionComisiones();
    dtoSalida = dao.obtenerDescripcionesPlantillas(dto);
    UtilidadesLog.info("MONGestionComisionesBean.obtenerDescripcionesPlantillas(DTOBelcorp dto): Salida");  
    return dtoSalida; 
  }
  
  /**
   * Autor: Cristian Valenzuela
   * Metodo: buscarInsertarComisiones
   * Fecha: 8/3/2005
   */
  public DTOSalida buscarInsertarComisiones(DTOBuscarInsertarComisiones dto) throws MareException  {  
    UtilidadesLog.info("MONGestionComisionesBean.buscarInsertarComisiones(DTOBuscarInsertarComisiones dto): Entrada");
    DTOSalida dtoSalida = null;
    DAOGestionComisiones dao = new DAOGestionComisiones();
    dtoSalida = dao.buscarInsertarComisiones(dto);
    UtilidadesLog.info("MONGestionComisionesBean.buscarInsertarComisiones(DTOBuscarInsertarComisiones dto): Salida");  
    return dtoSalida; 
  }

  /**
   * Autor: Cristian Valenzuela
   * Metodo: obtenerMarcasPlantilla
   * Fecha: 7/3/2005 
   */
  public DTOSalida obtenerMarcasPlantilla(DTOOID dto) throws MareException  {
    UtilidadesLog.info("MONGestionComisionesBean.obtenerMarcasPlantilla(DTOOID dto): Entrada");
    DTOSalida dtoSalida = null;
    DAOGestionComisiones dao = new DAOGestionComisiones();
    dtoSalida = dao.obtenerMarcasPlantilla(dto);
    UtilidadesLog.info("MONGestionComisionesBean.obtenerMarcasPlantilla(DTOOID dto): Salida");
    return dtoSalida;
  }

  /**
   * Autor: Cristian Valenzuela
   * Metodo: obtenerAccesosPlantilla
   * Fecha: 7/3/2005 
   */
  public DTOSalida obtenerAccesosPlantilla(DTOOID dto) throws MareException  {
    UtilidadesLog.info("MONGestionComisionesBean.obtenerAccesosPlantilla(DTOOID dto): Entrada");
    DTOSalida dtoSalida = null;
    DAOGestionComisiones dao = new DAOGestionComisiones();
    dtoSalida = dao.obtenerAccesosPlantilla(dto);
    UtilidadesLog.info("MONGestionComisionesBean.obtenerAccesosPlantilla(DTOOID dto): Salida");  
    return dtoSalida;
  }

  /**
  * @autor jquiroga@indra.com.ar
  * @throws MareException  
  * @return DTOSalida
  * @documentation
      Obtiene los distintos códigos de las comisiones dadas de alta en el sistema. 
      
      Proceso 
      ======== 
      Retorna el DTOSalida devuelto por el método DAOGestionComisiones.obtenerCodigosComisiones(dto)  
  */
  public DTOSalida obtenerCodigosComisiones(DTOBelcorp dto) throws MareException  {
    UtilidadesLog.info("MONGestionComisionesBean.obtenerCodigosComisiones(DTOBelcorp dto): Entrada");
    DTOSalida dTOSalida = null;
    DAOGestionComisiones daoGestionComisiones=new DAOGestionComisiones();
    dTOSalida = daoGestionComisiones.obtenerCodigosComisiones(dto);
    UtilidadesLog.info("MONGestionComisionesBean.obtenerCodigosComisiones(DTOBelcorp dto): Salida");
    return dTOSalida;
  }

  /**
  * @autor jquiroga@indra.com.ar
  * @throws MareException  
  * @return DTOSalida
  * @documentation
      Obtiene las distintas marcas de las comisiones dadas de alta en el sistema. 
      
      Proceso 
      ======== 
      Retorna el DTOSalida devuelto por el método DAOGestionComisiones.obtenerMarcasComisiones(dto)
  */
  public DTOSalida obtenerMarcasComisiones(DTOBelcorp dto) throws MareException  {
    UtilidadesLog.info("MONGestionComisionesBean.obtenerMarcasComisiones(DTOBelcorp dto): Entrada");  
    DAOGestionComisiones daoGestionComisiones=new DAOGestionComisiones();
    DTOSalida dtoSalida = null;
    dtoSalida = daoGestionComisiones.obtenerMarcasComisiones(dto);
    UtilidadesLog.info("MONGestionComisionesBean.obtenerMarcasComisiones(DTOBelcorp dto): Salida");
    return dtoSalida;
  }

  /**
  * @autor jquiroga@indra.com.ar
  * @throws MareException  
  * @return DTOSalida
  * @documentation
      Obtiene los distintos canales de las comisiones dadas de alta en el sistema. 
      
      Proceso 
      ======== 
      Retorna el DTOSalida devuelto por el método DAOGestionComisiones.obtenerCanalesComisiones(dto)  
  */
  public DTOSalida obtenerCanalesComisiones(DTOBelcorp dto) throws MareException  {
    UtilidadesLog.info("MONGestionComisionesBean.obtenerCanalesComisiones(DTOBelcorp dto): Entrada");    
    DAOGestionComisiones daoGestionComisiones=new DAOGestionComisiones();
    DTOSalida dTOSalida = null;
    dTOSalida = daoGestionComisiones.obtenerCanalesComisiones(dto);
    UtilidadesLog.info("MONGestionComisionesBean.obtenerCanalesComisiones(DTOBelcorp dto): Salida");
    return dTOSalida;
  }

  /**
  * @autor jquiroga@indra.com.ar
  * @throws MareException  
  * @return DTOSalida
  * @documentation
      Obtiene los distintos accesos de las comisiones dadas de alta en el sistema. 
      
      Proceso 
      ======== 
      Retorna el DTOSalida devuelto por el método DAOGestionComisiones.obtenerAccesosComisiones(dto)  
  */
  public DTOSalida obtenerAccesosComisiones(DTOBelcorp dto) throws MareException  {
    UtilidadesLog.info("MONGestionComisionesBean.obtenerAccesosComisiones(DTOBelcorp dto): Entrada");    
    DAOGestionComisiones daoGestionComisiones=new DAOGestionComisiones();
    
    DTOSalida dtoSalida = null;
    dtoSalida = daoGestionComisiones.obtenerAccesosComisiones(dto);
    UtilidadesLog.info("MONGestionComisionesBean.obtenerAccesosComisiones(DTOBelcorp dto): Salida");    
    return dtoSalida;
  }
  
  /**
  * @autor jquiroga@indra.com.ar
  * @throws MareException 
  * @return DTOSalida
  * @documentation
      Obtiene las versiones de una comisión. 
      
      Proceso 
      ======== 
      Retorna el DTOSalida devuelto por el método DAOGestionComisiones.obtenerVersionesComision(dto)  
  */
  public DTOSalida obtenerVersionesComision(DTOCodigoComision dto) throws MareException  {
    UtilidadesLog.info("MONGestionComisionesBean.obtenerVersionesComision(DTOCodigoComision dto): Entrada");  
    DAOGestionComisiones daoGestionComisiones=new DAOGestionComisiones();
    DTOSalida dtoSalida = null;
    dtoSalida = daoGestionComisiones.obtenerVersionesComision(dto);
    UtilidadesLog.info("MONGestionComisionesBean.obtenerVersionesComision(DTOCodigoComision dto): Salida");
    return dtoSalida;
  }

  /**
  * @autor jquiroga@indra.com.ar
  * @throws MareException
  * @param 
  * @return 
  * @documentation
      Obtiene las comisiones que cumplen el criterio especificado por el usuario. 
      Búsqueda paginada. 
      
      Proceso 
      ========= 
      Retorna el DTOSalida que devuelve el método DAOGestionComisiones.buscarMarcarModificar(dto)  
  */
  public DTOSalida buscarMarcarModificar(DTOBuscarMarcarModificar dto) throws MareException  {
    UtilidadesLog.info("MONGestionComisionesBean.buscarMarcarModificar(): Entrada");
    DAOGestionComisiones daoGestionComisiones=new DAOGestionComisiones();
    DTOSalida dtoSalida = null;
    dtoSalida = daoGestionComisiones.buscarMarcarModificar(dto);
    UtilidadesLog.info("MONGestionComisionesBean.buscarMarcarModificar(): Salida");
    return dtoSalida;
  }

  /**
  * @autor jquiroga@indra.com.ar
  * @throws MareException  
  * @return void
  * @documentation
      Marca una comisión para solicitar su modificación. 
      
      Proceso 
      ======== 
      Integer iVersion = DAOGestionComisiones.obtenerVersionMaxima(dto.oid) 
      
      Se llama al método findByPrimaryKey(dto.oid) de la entidad (EJB Entity) COM:Comisiones. 
      
      Se crea un registro en la entidad (EJB Entity) COM:Comisiones poniendo todos los campos a igual valor que los del objeto recibido del método anterior a excepción de: 
      oid = nuevo valor de la secuencia 
      version = iVersion + 1 
      estado = ConstantesCOM.ESTADO_COMISION_SOLICITUD_CAMBIO 
      fecUltimoEstado = fecha del sistema 
      
      copiaRestoDatosComision(dto.oid, COM:Comisiones.oid que se ha creado)  
  */
  //mmaidana -- 12/04/2005 -- Se cambia el tipo de argumento, de DTOOID a
  //DTOComisiones.
  public void marcarModificar(DTOComisiones dto) throws MareException  {
    UtilidadesLog.info("MONGestionComisionesBean.marcarModificar(DTOComisiones dto): Entrada");
    Date fd=new Date(System.currentTimeMillis());        
    DAOGestionComisiones daoGestionComisiones=new DAOGestionComisiones();    
    Integer iVersion = daoGestionComisiones.obtenerVersionMaxima(dto.getOid());    

    ComisionesLocalHome comisionesLocalHome=null;
    ComisionesLocal comisionesLocal=null;
    ComisionesLocal comisionesLocal2=null;
    try {
      comisionesLocalHome=getComisionesLocalHome();
      
      comisionesLocal=comisionesLocalHome.findByPrimaryKey(dto.getOid());
      iVersion = new Integer(iVersion.intValue()+1);
      comisionesLocal2=comisionesLocalHome.create(
      comisionesLocal.getCodComi(),iVersion,
      comisionesLocal.getPlcpOidPlanComiPais(),
      comisionesLocal.getPlcmOidPlanComiMarc(),
      comisionesLocal.getPerdOidPeri(),
      comisionesLocal.getTplaOidTipoPlan(),
      comisionesLocal.getPerdOidPeriHast(),
      ConstantesCOM.ESTADO_COMISION_SOLICITUD_CAMBIO,
      comisionesLocal.getPlcoOidPlanComi(),
      comisionesLocal.getIndVentCob());
      comisionesLocal2.setFecUltiEsta(new Timestamp(fd.getTime()));
      comisionesLocal2.setIndComp(comisionesLocal.getIndComp());
      comisionesLocal2.setIndTratDife(comisionesLocal.getIndTratDife());
      comisionesLocal2.setNumPeriEspe(comisionesLocal.getNumPeriEspe());      
      comisionesLocal2.setPerdOidPeriVigoModi(comisionesLocal.getPerdOidPeriVigoModi());;
      comisionesLocal2.setPlcmOidPlanComiMarc(comisionesLocal.getPlcmOidPlanComiMarc());
      
      comisionesLocal2.setValConc(comisionesLocal.getValConc());
      comisionesLocal2.setValObse(comisionesLocal.getValObse());
      
      // vbongiov -- Cambio 20090913 -- 5/08/2009     
      comisionesLocal2.setConsideraSabDomFer(comisionesLocal.getConsideraSabDomFer());
      comisionesLocal2.setDsctoImpstoVtaPagos(comisionesLocal.getDsctoImpstoVtaPagos());

       // sapaza -- PER-SiCC-2010-0478 -- 19/08/2010
      comisionesLocal2.setComisionEscalonada(comisionesLocal.getComisionEscalonada());
      
      comisionesLocalHome.merge(comisionesLocal2);
      
      copiaRestoDatosComision(dto.getOid(), comisionesLocal2.getOid(), dto.getOidCanal());
      UtilidadesLog.info("MONGestionComisionesBean.marcarModificar(DTOComisiones dto): Salida");
      
    } catch (NoResultException nre) {
        ctx.setRollbackOnly();
         UtilidadesLog.error("ERROR ", nre);
        throw new MareException(nre,        
            UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE) );         
    } catch (PersistenceException pe) {
        ctx.setRollbackOnly();
        UtilidadesLog.error("ERROR ", pe);
        throw new MareException(pe,
            UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS));
    }
  }

  /**
  * @autor jquiroga@indra.com.ar
  * @throws MareException
  * @return DTOSalida
  * @documentation
      Obtiene las comisiones que cumplen el criterio especificado por el usuario. 
      Búsqueda paginada. 
      
      Proceso 
      ========= 
      Retorna el DTOSalida que devuelve el método DAOGestionComisiones.buscarAceptarModificacion(dto)  
  */
  public DTOSalida buscarAceptarModificacion(DTOEstadoComision dtoE) throws MareException  {
    UtilidadesLog.info("MONGestionComisionesBean.buscarAceptarModificacion(DTOEstadoComision dtoE): Entrada");
    DAOGestionComisiones daoGestionComisiones=new DAOGestionComisiones();    
    DTOSalida dtoSalida = null;
    dtoSalida = daoGestionComisiones.buscarAceptarModificacion(dtoE);       
    UtilidadesLog.info("MONGestionComisionesBean.buscarAceptarModificacion(DTOEstadoComision dtoE): Salida");
    return dtoSalida;
  }

  /**
  * @autor jquiroga@indra.com.ar
  * @throws MareException  
  * @return void
  * @documentation
      Guarda el estado seleccionado para la comisión que se está tratando. 
      
      Proceso 
      ======== 
      Se llama al método findByPrimaryKey(dto.oidComision) de la entidad (EJB Entity) COM:Comisiones. 
      
      Para el objeto que se obtiene se actualizan los atributos: 
      estado = dto.oidEstado 
      fecUltimoEstado = fecha del sistema  
  */
  public void permitirModificar(DTOPermitirModificar dto) throws MareException  {
    UtilidadesLog.info("MONGestionComisionesBean.permitirModificar(DTOPermitirModificar dto): Entrada");
    
    ComisionesLocalHome comisionesLocalHome;
    ComisionesLocal comisionesLocal;
    Date dt=new Date(System.currentTimeMillis());
    Timestamp ts=new Timestamp(dt.getTime());
    
    try {
      comisionesLocalHome=getComisionesLocalHome();
      comisionesLocal=comisionesLocalHome.findByPrimaryKey(dto.getOidComision());
      
      comisionesLocal.setEstado(dto.getOidEstado());
      comisionesLocal.setFecUltiEsta(ts);
      
      comisionesLocalHome.merge(comisionesLocal);
      
      UtilidadesLog.info("MONGestionComisionesBean.permitirModificar(DTOPermitirModificar dto): Salida");
      
    } catch (NoResultException nre) {
        ctx.setRollbackOnly();
         UtilidadesLog.error("ERROR ", nre);
        throw new MareException(nre,        
            UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE) );         
    } catch (PersistenceException pe) {
        ctx.setRollbackOnly();
        UtilidadesLog.error("ERROR ", pe);
        throw new MareException(pe,
            UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS));
    }

  }

  /**
  * @autor jquiroga@indra.com.ar
  * @throws MareException  
  * @return DTOSalida
  * @documentation
      Obtiene la versión vigente de una dada (la inmediatamente anterior con estado activo). 
      
      Proceso 
      ======== 
      DTOSalida dtoS = DAOGestionComisiones.cargaConfirmarModificar(dto) 
      
      Si dtoS.resultado tiene registros 
      DTOPeriodo dtoP = IPeriodos.obtienePeriodoActual(dtoS.resultado(0).oidPais, dtoS.resultado(0).oidMarca, dtoS.resultado(0).oidCanal) 
      
      dtoS.resultado(0).fecIniPeriodoActual = dtoP.fechaIni 
      Fin del Si 
      
      Se crea la variable DTOSalida dtoSalida que inicialmente estará vacía. 
      
      Si dtoS.resultado tiene registros 
      Se añade un elemento a dtoSalida.resultado y se carga como sigue: 
      dtoSalida.resultado(0).oid = dtoS.resultado(0).oid 
      dtoSalida.resultado(0).codigo = dtoS.resultado(0).codigo 
      dtoSalida.resultado(0).version = dtoS.resultado(0).version 
      dtoSalida.resultado(0).descripcion = dtoS.resultado(0).descripcion 
      dtoSalida.resultado(0).marca = dtoS.resultado(0).marca 
      dtoSalida.resultado(0).canal = dtoS.resultado(0).canal 
      dtoSalida.resultado(0).acceso = dtoS.resultado(0).acceso 
      dtoSalida.resultado(0).tipoComision = dtoS.resultado(0).tipoComision 
      dtoSalida.resultado(0).concepto = dtoS.resultado(0).concepto 
      dtoSalida.resultado(0).fecIniPeriodoActual = dtoS.resultado(0).fecIniPeriodoActual 
      Fin del Si 
      
      Se retorna dtoSalida que tiene las columnas: 
      oid, 
      codigo, 
      version, 
      descripcion, 
      marca, 
      canal, 
      acceso, 
      tipoComision, 
      concepto, 
      fecIniPeriodoActual  
  */
  public DTOSalida cargaConfirmarModificar(DTOOID dto) throws MareException  {
    UtilidadesLog.info("MONGestionComisionesBean.cargaConfirmarModificar(DTOOID dto): Entrada");
    DAOGestionComisiones daoGestionComisiones=new DAOGestionComisiones();
    DTOSalida dtoS=null;
    DTOSalida dtoSalida=null;
    RecordSet rs=null;
    RecordSet rs2=null;
    DTOPeriodo dtoPeriodo=null;    
    MONPeriodosHome monPeriodosHome=null;
    MONPeriodos monPeriodos=null;
    Vector valores=null;
    
    dtoS=daoGestionComisiones.cargaConfirmarModificar(dto);
    if(dtoS==null) return null;    
    rs=dtoS.getResultado();
    
    if(rs!=null && !rs.esVacio()) {
        dtoSalida=new DTOSalida();
        try {
          monPeriodosHome = (MONPeriodosHome)UtilidadesEJB.getHome("MONPeriodos", MONPeriodosHome.class);
          monPeriodos = monPeriodosHome.create();
          dtoPeriodo = monPeriodos.obtienePeriodoActual(objectToLong(rs.getValueAt(0, "oidPais")), objectToLong(rs.getValueAt(0, "oidMarca")), objectToLong(rs.getValueAt(0, "oidCanal")));          
          UtilidadesLog.debug("dtoPeriodo: "+dtoPeriodo);
        }
        catch (RemoteException rex) {
          UtilidadesLog.error(rex);
          throw new MareException(rex,
          UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
        }
        catch (CreateException cex) {
          UtilidadesLog.error(cex);
          throw new MareException(cex,
          UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
        }
        
        if(dtoPeriodo!=null) {
            //setValueAt(Object value,int row,int col) 
            rs.setValueAt((Object)dtoPeriodo.getFechaInicio(), 0, rs.getColumnPosition("fecIniPeriodoActual"));
            dtoS.setResultado(rs);
        }
        
        rs2=new RecordSet();
        valores = new Vector();
        
        valores.add(rs.getValueAt(0, "oid"));
        valores.add(rs.getValueAt(0, "codigo"));
        valores.add(rs.getValueAt(0, "version"));
        valores.add(rs.getValueAt(0, "descripcion"));
        valores.add(rs.getValueAt(0, "marca"));
        valores.add(rs.getValueAt(0, "canal"));
        valores.add(rs.getValueAt(0, "acceso"));
        valores.add(rs.getValueAt(0, "tipoComision"));
        valores.add(rs.getValueAt(0, "concepto"));
        valores.add(rs.getValueAt(0, "fecIniPeriodoActual"));
                       
        rs2.addColumn("oid");
        rs2.addColumn("codigo");
        rs2.addColumn("version");
        rs2.addColumn("descripcion");
        rs2.addColumn("marca");
        rs2.addColumn("canal");
        rs2.addColumn("acceso");
        rs2.addColumn("tipoComision");
        rs2.addColumn("concepto");
        rs2.addColumn("fecIniPeriodoActual");
        
        rs2.addRow(valores);
        dtoSalida.setResultado(rs2);
    }
    UtilidadesLog.debug("DTOSALIDA: **** " + dtoSalida);
    UtilidadesLog.info("MONGestionComisionesBean.cargaConfirmarModificar(DTOOID dto): Salida");
    return dtoSalida;
  }

  /**
  * @autor jquiroga@indra.com.ar
  * @throws MareException  
  * @return void
  * @documentation
      Aceptación de la modificación de una comisión. 
      
      Proceso 
      ======== 
      Se llama al método findByPrimaryKey(dto.oid) de la entidad (EJB Entity) COM:Comisiones. 
      
      Se actualizan los atributos del objeto obtenido: 
      estado = ConstantesCOM.ESTADO_COMISION_ACTIVA 
      fecUltimoEstado = fecha del sistema  
  */
  public void aceptarModificacion(DTOOID dto) throws MareException  {
    UtilidadesLog.info("MONGestionComisionesBean.aceptarModificacion(DTOOID dto): Entrada");
    ComisionesLocalHome comisionesLocalHome=null;
    ComisionesLocal comisionesLocal=null;
    Date dt=new Date(System.currentTimeMillis());
    Timestamp ts=new Timestamp(dt.getTime());
    
    try {
      comisionesLocalHome=getComisionesLocalHome();
      comisionesLocal=comisionesLocalHome.findByPrimaryKey(dto.getOid());
      
      comisionesLocal.setEstado(ConstantesCOM.ESTADO_COMISION_ACTIVA);
      comisionesLocal.setFecUltiEsta(ts);
      
      comisionesLocalHome.merge(comisionesLocal);
      
      UtilidadesLog.info("MONGestionComisionesBean.aceptarModificacion(DTOOID dto): Salida");
      
    } catch (NoResultException nre) {
        ctx.setRollbackOnly();
         UtilidadesLog.error("ERROR ", nre);
        throw new MareException(nre,        
            UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE) );         
    } catch (PersistenceException pe) {
        ctx.setRollbackOnly();
        UtilidadesLog.error("ERROR ", pe);
        throw new MareException(pe,
            UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS));
    }
  }

  /**
  * @autor jquiroga@indra.com.ar
  * @throws MareException  
  * @return void
  * @documentation
      Rechazo de la modificación de una comisión. 
      
      Proceso 
      ======== 
      Se llama al método findByPrimaryKey(dto.oid) de la entidad (EJB Entity) COM:Comisiones. 
      
      Se actualizan los atributos del objeto obtenido: 
      estado = ConstantesCOM.ESTADO_COMISION_CAMBIOS_RECHAZADOS 
      fecUltimoEstado = fecha del sistema
  */
  public void rechazarModificacion(DTOOID dtoE) throws MareException  {
    UtilidadesLog.info("MONGestionComisionesBean.rechazarModificacion(DTOOID dtoE): Entrada");
    ComisionesLocalHome comisionesLocalHome=null;
    ComisionesLocal comisionesLocal=null;
    Date dt=new Date(System.currentTimeMillis());
    Timestamp ts=new Timestamp(dt.getTime());
    
    try {
      comisionesLocalHome=getComisionesLocalHome();
      comisionesLocal=comisionesLocalHome.findByPrimaryKey(dtoE.getOid());
        
      comisionesLocal.setEstado(ConstantesCOM.ESTADO_COMISION_CAMBIOS_RECHAZADOS);
      comisionesLocal.setFecUltiEsta(ts);
      
      comisionesLocalHome.merge(comisionesLocal);
      
      UtilidadesLog.info("MONGestionComisionesBean.rechazarModificacion(DTOOID dtoE): Salida");
    } catch (NoResultException nre) {
        ctx.setRollbackOnly();
         UtilidadesLog.error("ERROR ", nre);
        throw new MareException(nre,        
            UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE) );         
    } catch (PersistenceException pe) {
        ctx.setRollbackOnly();
        UtilidadesLog.error("ERROR ", pe);
        throw new MareException(pe,
            UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS));
    }
  }

  /**
  * @autor jquiroga@indra.com.ar
  * @throws MareException  
  * @return DTOSalida
  * @documentation
      Obtiene los estados de comisiones (todos). 
      
      Proceso 
      ======== 
      Retorna el DTOSalida devuelto por el método DAOGestionComisiones.obtenerEstadosComisiones(dto)  
  */
  public DTOSalida obtenerEstadosComisiones(DTOEstados dtoE) throws MareException   {
    UtilidadesLog.info("MONGestionComisionesBean.obtenerEstadosComisiones(DTOEstados dtoE): Entrada");
    DAOGestionComisiones daoGestionComisiones=new DAOGestionComisiones();
    DTOSalida dtoSalida = null;
    dtoSalida = daoGestionComisiones.obtenerEstadosComisiones(dtoE);    
    UtilidadesLog.info("MONGestionComisionesBean.obtenerEstadosComisiones(DTOEstados dtoE): Salida");
    return dtoSalida;    
  }

  public DTOSalida buscarModificar(DTOBuscarModificar dto) throws MareException  {
    UtilidadesLog.info("MONGestionComisionesBean.buscarModificar(DTOBuscarModificar dto): Entrada");
    DTOSalida dtoSalida = null;
    DAOGestionComisiones dao = new DAOGestionComisiones();
    dtoSalida = dao.buscarModificar(dto);
    UtilidadesLog.info("MONGestionComisionesBean.buscarModificar(DTOBuscarModificar dto): Salida");
    return dtoSalida;   
  }

	/**
	 * @Author: Gustavo Viñales, 30/03/2005
   * @Modificado: Cristian Valenzuela 6/4/2005
	 */
   public void copiarComision(DTOComisiones dto) throws MareException {
        UtilidadesLog.info("MONGestionComisionesBean.copiarComision(DTOComisiones dto): Entrada");
        
        validaCopiaComision(dto.getOid());
        
        // si no se puede copiar, lanza una MareException.
        ComisionesLocalHome comisionesLocalHome = null;
        ComisionesLocal comisiones = null;
        ComisionesLocal copia = null;
        
        try  {
          comisionesLocalHome = getComisionesLocalHome();
          comisiones = comisionesLocalHome.findByPrimaryKey(dto.getOid());
          
          copia = comisionesLocalHome.create(generaCodigoComision(),
                                              new Integer(1),
                                              comisiones.getPlcpOidPlanComiPais(),
                                              comisiones.getPlcmOidPlanComiMarc(),
                                              comisiones.getPerdOidPeri(),
                                              comisiones.getTplaOidTipoPlan(),
                                              comisiones.getPerdOidPeriHast(),
                                              ConstantesCOM.ESTADO_COMISION_SOLICITUD_CAMBIO,
                                              comisiones.getPlcoOidPlanComi(),
                                              comisiones.getIndVentCob());
        } catch (NoResultException nre) {
            ctx.setRollbackOnly();
             UtilidadesLog.error("ERROR ", nre);
            throw new MareException(nre,        
                UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE) );         
        } catch (PersistenceException pe) {
            ctx.setRollbackOnly();
            UtilidadesLog.error("ERROR ", pe);
            throw new MareException(pe,
                UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS));
        }

        copia.setFecUltiEsta(new Timestamp(System.currentTimeMillis()));    
        copia.setIndComp(comisiones.getIndComp());
        copia.setIndTratDife(comisiones.getIndTratDife());
        copia.setNumPeriEspe(comisiones.getNumPeriEspe());
        copia.setPerdOidPeriVigoModi(comisiones.getPerdOidPeriVigoModi());
        copia.setValConc(comisiones.getValConc());
        copia.setValObse(comisiones.getValObse());
        
        // vbongiov -- Cambio 20090913 -- 5/08/2009     
        copia.setConsideraSabDomFer(comisiones.getConsideraSabDomFer());
        copia.setDsctoImpstoVtaPagos(comisiones.getDsctoImpstoVtaPagos());

        // sapaza -- PER-SiCC-2010-0478 -- 19/08/2010
        copia.setComisionEscalonada(comisiones.getComisionEscalonada());
        
        comisionesLocalHome.merge(copia);
        
        copiaRestoDatosComision(dto.getOid(), copia.getOid(), dto.getOidCanal());
        UtilidadesLog.info("MONGestionComisionesBean.copiarComision(DTOComisiones dto): Salida");
   }
  
/**
   * @author: ssantana, 31/3/2005
   * @throws es.indra.mare.common.exception.MareException   
   */
  public void eliminarComision(DTOOID dto) throws MareException  {
    UtilidadesLog.info("MONGestionComisionesBean.eliminarComision(DTOOID dto): Entrada");
  
    try 
    {
        ComisionesLocalHome comisionesLocalHome = this.getComisionesLocalHome();
        ComisionesLocal comisionesLocal = null;
        
        comisionesLocal = comisionesLocalHome.findByPrimaryKey(dto.getOid());
        comisionesLocal.setEstado(ConstantesCOM.ESTADO_COMISION_ELIMINADA);
        
        java.util.Date fechaActualSistema = new java.util.Date();
        Timestamp tFechaActual = new Timestamp(fechaActualSistema.getTime());
        
        comisionesLocal.setFecUltiEsta(tFechaActual);
        
        comisionesLocalHome.merge(comisionesLocal);
        
        UtilidadesLog.info("MONGestionComisionesBean.eliminarComision(DTOOID dto): Salida");
    } catch (NoResultException nre) {
        ctx.setRollbackOnly();
         UtilidadesLog.error("ERROR ", nre);
        throw new MareException(nre,        
            UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE) );         
    } catch (PersistenceException pe) {
        ctx.setRollbackOnly();
        UtilidadesLog.error("ERROR ", pe);
        throw new MareException(pe,
            UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS));
    }
  }

  /**
   * @Author: ssantana, 15/3/2005
   * @throws es.indra.mare.common.exception.MareException
   * @return DOTSalida   
   */
  public DTOSalida obtenerTiposInsercionProducto(DTOBelcorp dto) throws MareException  {
    UtilidadesLog.info("MONGestionComisionesBean.obtenerTiposInsercionProducto(DTOBelcorp dto): Entrada");
    DAOGestionComisiones daoGestion = new DAOGestionComisiones();  
    DTOSalida dtoSalida = null;    
    dtoSalida = daoGestion.obtenerTiposInsercionProducto(dto);
    UtilidadesLog.info("MONGestionComisionesBean.obtenerTiposInsercionProducto(DTOBelcorp dto): Salida");
    return dtoSalida;
  }

  /**
   * @Author: ssantana, 15/3/2005
   * @throws es.indra.mare.common.exception.MareException
   * @return DTOOID dto   
   */
  public DTOOID obtenerMarca(DTOComisiones dto) throws MareException {
      UtilidadesLog.info("MONGestionComisionesBean.obtenerMarca(DTOComisiones dto): Entrada");  
  
      PlantillasComisionesMarcaLocalHome plantillaComLocalHome = null;
      PlantillasComisionesMarcaLocal plantillaComLocal = null;
      DTOOID dtoOid = null;
      
      try {
        plantillaComLocalHome = this.getPlantillasComisionesMarcaLocalHome();
        plantillaComLocal = plantillaComLocalHome.findByUk(dto.getOidMarca(), dto.getOidPlantillasComisones());
      } catch (NoResultException nre) {
          ctx.setRollbackOnly();
           UtilidadesLog.error("ERROR ", nre);
          throw new MareException(nre,        
              UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE) );         
      } catch (PersistenceException pe) {
          ctx.setRollbackOnly();
          UtilidadesLog.error("ERROR ", pe);
          throw new MareException(pe,
              UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS));
      }
  
      dtoOid  = new DTOOID();
      dtoOid.setOid(plantillaComLocal.getOid());
      UtilidadesLog.debug(" Retorna DTOOID: " + dtoOid);
      UtilidadesLog.info("MONGestionComisionesBean.obtenerMarca(DTOComisiones dto): Salida");  
      return dtoOid;
  }
  
  
  

  /**
   * @Author: ssantana, 15/3/2005
   * @throws es.indra.mare.common.exception.MareException
   * @return DTOComisionesProductos dto   
   */
  public DTOComisionesProductos completarProducto(DTOComisionesProductos dto) throws MareException {  
    UtilidadesLog.info("MONGestionComisionesBean.completarProducto(DTOComisionesProductos dto): Entrada");
    MaestroProductosLocalHome maeProduLocalHome = null;
    MaestroProductosLocal maeProduLocal = null;    
    
      try {
        maeProduLocalHome = this.getMaestroProductosLocalHome();
      }
      catch (NamingException nEx) {
        UtilidadesLog.error(nEx);
        String sCodigoError = CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB;
        throw new MareException(nEx, UtilidadesError.armarCodigoError(sCodigoError));
      } 

      DTOComisionesProductos dtoS = dto;    
      
      if (dto.getCodProducto() != null) {
          try {
            maeProduLocal = maeProduLocalHome.findByUK( dto.getOidPais(), 
                                                        dto.getCodProducto());
          }
            catch (FinderException fEx) {
            UtilidadesLog.debug(fEx);
            int codigoError = UtilidadesError.armarCodigoError(ConstantesSEG.MODULO_COM, 
                                                                "",
                                                                ErroresDeNegocio.COM_0009);
            throw new MareException("No se encuentra el código de producto", codigoError);
          }        
          dtoS.setOidProducto(maeProduLocal.getOid());
     }          
    
    BelcorpService bs = BelcorpService.getInstance();
    RecordSet resultado = null;
       
    StringBuffer sql = new StringBuffer("");
      
    sql.append(" SELECT c.OID_TIPO_PROD AS oid, v.VAL_I18N AS DESCRIPCION ");
    sql.append(" FROM COM_TIPO_PRODU c, V_GEN_I18N_SICC v ");
    sql.append(" WHERE v.attr_enti = 'COM_TIPO_PRODU' ");
    sql.append(" AND v.attr_num_atri = 1 ");
    sql.append(" AND v.idio_oid_idio = " + dtoS.getOidIdioma());
    sql.append(" AND v.val_oid = c.OID_TIPO_PROD ");
	sql.append(" AND c.OID_TIPO_PROD = " + dtoS.getOidTipoProducto());       
       
    try {
      resultado = bs.dbService.executeStaticQuery(sql.toString());
      UtilidadesLog.debug("resultado: " + resultado);
    }
    catch (Exception ex) {
      UtilidadesLog.error(ex);
      String sCodigoError = CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS;
      throw new MareException(ex, UtilidadesError.armarCodigoError(sCodigoError));
    }
       
    String desTipoProducto = (String) resultado.getValueAt(0, "DESCRIPCION");
    dtoS.setDescTipoProducto(desTipoProducto);    
    
    UtilidadesLog.debug("dtoS: " + dtoS);
    UtilidadesLog.info("MONGestionComisionesBean.completarProducto(DTOComisionesProductos dto): Salida");
    return dtoS;    
  }
  
  /**
   * @author: ssantana, 3/4/2005
   * @throws es.indra.mare.common.exception.MareException   
   */
  private void validaCopiaComision(Long oidComisiones) throws MareException {
    UtilidadesLog.info("MONGestionComisionesBean.validaCopiaComision(Long oidComisiones): Entrada");
    // Modificado por inc. 15835.
    ComisionesLocalHome comisionesLocalHome = null;
    ComisionesLocal comisionesLocal = null;    
    
    DAOGestionComisiones dao = new DAOGestionComisiones();
    RecordSet rDatosPlantilla = dao.obtieneDatosPlantillaValidaCopiaComision(oidComisiones);
    UtilidadesLog.debug("rDatosPlantilla: " + rDatosPlantilla);
    BigDecimal estadoPlantilla = (BigDecimal) rDatosPlantilla.getValueAt(0,0);
    
    if ( estadoPlantilla.longValue() != ConstantesCOM.ESTADO_ACTIVO.longValue() ) {
      // Lanza excepcion COM-0003 (No se puede copiar la comision. La plantilla no está activa)
      String sCodigoModulo = ConstantesSEG.MODULO_COM;
      String sErrorNegocio = ErroresDeNegocio.COM_0003;
      int codigoError = UtilidadesError.armarCodigoError(sCodigoModulo, 
                                                         "",
                                                         sErrorNegocio);
      
      throw new MareException( "No se puede copiar la comision. La plantilla no está activa", 
                               codigoError);      
    }
    
    try {
       comisionesLocalHome = this.getComisionesLocalHome();
       comisionesLocal = comisionesLocalHome.findByPrimaryKey(oidComisiones);
       
    } catch (NoResultException nre) {
        ctx.setRollbackOnly();
         UtilidadesLog.error("ERROR ", nre);
        throw new MareException(nre,        
            UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE) );         
    } catch (PersistenceException pe) {
        ctx.setRollbackOnly();
        UtilidadesLog.error("ERROR ", pe);
        throw new MareException(pe,
            UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS));
    }
    
    BigDecimal oidTipoComision = (BigDecimal) rDatosPlantilla.getValueAt(0,2);
    
    // Si oidTipoComision es NULL o no coincide con COM:Comisiones.tipoComision
    // Lanza Excepcion COM-0005
    if (oidTipoComision == null || (oidTipoComision.longValue() != comisionesLocal.getTplaOidTipoPlan().longValue()) ) {
      // Lanza excepcion COM-0005
      // (El tipo de comisión de la plantilla y de la comisión no coinciden)
      String sCodigoModulo = ConstantesSEG.MODULO_COM;
      String sErrorNegocio = ErroresDeNegocio.COM_0005;
      int codigoError = UtilidadesError.armarCodigoError(sCodigoModulo, 
                                                         "",
                                                         sErrorNegocio);
      
      throw new MareException( "No se puede copiar la comision. La plantilla no está activa", 
                               codigoError);      
        
    }
    UtilidadesLog.info("MONGestionComisionesBean.validaCopiaComision(Long oidComisiones): Salida");
  }
  
  /**
  * @autor ssantana, 3/4/2005
  * @throws MareException  
  * @return void
  **/
  
  private void copiaRestoDatosComision(Long oidComisionOrigen, Long oidComisionCopia, Long oidCanal) 
      throws MareException   {
      UtilidadesLog.info("MONGestionComisionesBean.copiaRestoDatosComision(Long oidComisionOrigen, Long oidComisionCopia, Long oidCanal): Entrada");      
      
      UtilidadesLog.debug("*********** oidComisionOrigen " + oidComisionOrigen);
      UtilidadesLog.debug("*********** oidComisionCopia " + oidComisionCopia);
      UtilidadesLog.debug("*********** oidCanal " + oidCanal);      
      
      this.copiaComisionesAccesos(oidComisionOrigen, oidComisionCopia, oidCanal);
      this.copiaComisionesProductos(oidComisionOrigen, oidComisionCopia);
      this.copiaComisionesClientes(oidComisionOrigen, oidComisionCopia);
      this.copiaComisionesVentas(oidComisionOrigen, oidComisionCopia);
      this.copiaComisionesHistoricoVentas(oidComisionOrigen, oidComisionCopia);
      this.copiaComisionesCobranza(oidComisionOrigen, oidComisionCopia);
      
      
      /* nuevo DT de metodo para copiar descripciones    02/05/05 idedough  
       * seria:
       * Se llama al método findByEntPK(oidComisionOrigen) de la entidad (EJB Entity) CMN:Entidadi18n. 
          Por cada uno de los objetos obtenidos con el finder 
          Se crea un registro en la entidad (EJB Entity) 
          CMN:Entidadi18n poniendo todos los campos a igual valor que los del objeto 
          que se está tratando a excepción de: 
                oid = nuevo valor de la secuencia de CMN:Entidadi18n
                entidad_pk (de oidComision) = oidComisionCopia 
          Fin del Bucle 
       */
      Entidadi18nLocalHome enti18nLocalHome = null;
      Entidadi18nLocal enti18nLocal = null;      
      try 
      { enti18nLocalHome = new Entidadi18nLocalHome();
        Collection col = enti18nLocalHome.findByEntPK("COM_COMIS",oidComisionOrigen);      
        for(Iterator it = col.iterator();it.hasNext();) {  
          enti18nLocal = (Entidadi18nLocal)it.next();
           enti18nLocalHome.create("COM_COMIS",
                                    new Long(1),
                                    enti18nLocal.getIdioma(),
                                    enti18nLocal.getDetalle(),
                                    oidComisionCopia);
        }
        UtilidadesLog.info("MONGestionComisionesBean.copiaRestoDatosComision(Long oidComisionOrigen, Long oidComisionCopia, Long oidCanal): Salida");      
      }
      catch (NoResultException fEx) {  
         UtilidadesLog.debug(fEx);
         UtilidadesLog.debug("No se encontro Entidadi18n para comision origen " + oidComisionOrigen);         
      }  
      catch (PersistenceException cEx) {  
         UtilidadesLog.error(cEx);
         String sCodigoError = CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS;
         throw new MareException(cEx, UtilidadesError.armarCodigoError(sCodigoError));
      }
  }  
  
  /**
   * @author: ssantana, 3/4/2005
   * @throws es.indra.mare.common.exception.MareException
   */
  private void copiaComisionesVentas(Long oidComisionOrigen, Long oidComisionCopia) 
    throws MareException {
      UtilidadesLog.info("MONGestionComisionesBean.copiaComisionesVentas(Long oidComisionOrigen, Long oidComisionCopia): Entrada");
      ComisionesVentasLocalHome comVentasLocalHome = null;
      ComisionesVentasLocal comVentasLocalOrigen = null;
      ComisionesVentasLocal comVentasLocalCopia = null;      
      
      try
      {
          comVentasLocalHome = this.getComisionesVentasLocalHome();
          comVentasLocalOrigen = comVentasLocalHome.findByUK(oidComisionOrigen);
          
          // Crea la  nueva ComisionVentas con referencia al oid de la Comision Copia
          comVentasLocalCopia = comVentasLocalHome.create(oidComisionCopia, 
                                                            comVentasLocalOrigen.getFormula());

          // Igualo todos los valores restantes para concluir la copia          
          comVentasLocalCopia.setAnulaciones(comVentasLocalOrigen.getAnulaciones());
          comVentasLocalCopia.setCalculoIncobrables(comVentasLocalOrigen.getCalculoIncobrables());
          comVentasLocalCopia.setCalculoIncobrablesFechaEmision(comVentasLocalOrigen.getCalculoIncobrablesFechaEmision());
          comVentasLocalCopia.setCalculoIncobrablesFechaVencimiento(comVentasLocalOrigen.getCalculoIncobrablesFechaVencimiento());
          comVentasLocalCopia.setDevoluciones(comVentasLocalOrigen.getDevoluciones());
          comVentasLocalCopia.setDiasIncobrables(comVentasLocalOrigen.getDiasIncobrables());
          comVentasLocalCopia.setFaltantesNoAnunciados(comVentasLocalOrigen.getFaltantesNoAnunciados());
          comVentasLocalCopia.setImporteFijoComision(comVentasLocalOrigen.getImporteFijoComision());
          comVentasLocalCopia.setPorcentajeComision(comVentasLocalOrigen.getPorcentajeComision());
          comVentasLocalCopia.setTipoComisionVta(comVentasLocalOrigen.getTipoComisionVta());        
          comVentasLocalCopia.setTipoComisionVtaIncremental(comVentasLocalOrigen.getTipoComisionVtaIncremental());
          
          comVentasLocalHome.merge(comVentasLocalCopia);

          UtilidadesLog.info("MONGestionComisionesBean.copiaComisionesVentas(Long oidComisionOrigen, Long oidComisionCopia): Salida");
            
      } catch (NoResultException nre) {
          UtilidadesLog.debug("No se encontro ComisionesVentas para comision origen " + oidComisionOrigen);
          UtilidadesLog.debug(nre);
      } catch (PersistenceException pe) {
          ctx.setRollbackOnly();
          UtilidadesLog.error("ERROR ", pe);
          throw new MareException(pe,
              UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS));
      }
  }
  
  /**
   * @author: ssantana, 3/4/2005
   * @throws es.indra.mare.common.exception.MareException   
   */
  private void copiaComisionesAccesos(Long oidComisionOrigen, Long oidComisionCopia, Long oidCanal) 
    throws MareException {
    UtilidadesLog.info("MONGestionComisionesBean.copiaComisionesAccesos(Long oidComisionOrigen, Long oidComisionCopia, Long oidCanal): Entrada");
    ComisionesAccesoLocalHome comAccesosLocalHome = null;
    ComisionesAccesoLocal comAccesoLocalOrigen = null;    
    
    try 
    {
      comAccesosLocalHome = this.getComisionesAccesoLocalHome();

      Collection col = comAccesosLocalHome.findbyComision(oidComisionOrigen);
      
      Iterator it = col.iterator();
      while (it.hasNext())
      {
        comAccesoLocalOrigen = (ComisionesAccesoLocal) it.next();
        Long oidPlantillaComisionAcceso = comAccesoLocalOrigen.getAcceso();
        comAccesosLocalHome.create(oidPlantillaComisionAcceso, oidComisionCopia, oidCanal);
      }
      
      UtilidadesLog.info("MONGestionComisionesBean.copiaComisionesAccesos(Long oidComisionOrigen, Long oidComisionCopia, Long oidCanal): Salida");
        
      } catch (NoResultException nre) {
          UtilidadesLog.debug(nre);
          UtilidadesLog.debug("No se encontro ComisionesAccesos para comision origen " + oidComisionOrigen);       
      } catch (PersistenceException pe) {
          ctx.setRollbackOnly();
          UtilidadesLog.error("ERROR ", pe);
          throw new MareException(pe,
              UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS));
      }
  }  
  
  
  /**
   * @author: ssantana, 3/4/2005
   * @throws es.indra.mare.common.exception.MareException   
   */
  private void copiaComisionesProductos(Long oidComisionOrigen, Long oidComisionCopia) 
    throws MareException  {
    UtilidadesLog.info("MONGestionComisionesBean.copiaComisionesProductos(Long oidComisionOrigen, Long oidComisionCopia): Entrada");  
    ComisionesProductosLocalHome comProduLocalHome = null;
    ComisionesProductosLocal comProduLocalOrigen = null;
    ComisionesProductosLocal comProduLocalCopia = null;    
    
    try 
    {
       comProduLocalHome = this.getComisionesProductosLocalHome();
       Collection col = comProduLocalHome.findByComision(oidComisionOrigen);
       
       Iterator it = col.iterator();
       
       while(it.hasNext())
       {
          comProduLocalOrigen = (ComisionesProductosLocal) it.next();
          
          // Crea la copia
          comProduLocalCopia = comProduLocalHome.create(comProduLocalOrigen.getCodigo(), 
                                                        oidComisionCopia,
                                                        comProduLocalOrigen.getTipoProducto(),
                                                        comProduLocalOrigen.getTipoInsercionProducto());  
                                                        
          comProduLocalCopia.setCicloVida( comProduLocalOrigen.getCicloVida() );
          comProduLocalCopia.setComisionProducto( comProduLocalOrigen.getComisionProducto() );
          comProduLocalCopia.setGenerico( comProduLocalOrigen.getGenerico() );
          comProduLocalCopia.setMarcaProducto( comProduLocalOrigen.getMarcaProducto() );
          comProduLocalCopia.setNegocio( comProduLocalOrigen.getNegocio() );
          comProduLocalCopia.setProducto( comProduLocalOrigen.getProducto() );
          comProduLocalCopia.setSuperGenerico( comProduLocalOrigen.getSuperGenerico() );
          comProduLocalCopia.setTipoOferta( comProduLocalOrigen.getTipoOferta() );
          comProduLocalCopia.setUnidadNegocio( comProduLocalOrigen.getUnidadNegocio() );
          
          comProduLocalHome.merge(comProduLocalCopia);
                                   
       }
       
        UtilidadesLog.info("MONGestionComisionesBean.copiaComisionesProductos(Long oidComisionOrigen, Long oidComisionCopia): Salida");  
        
      } catch (NoResultException nre) {
          UtilidadesLog.debug("No se encontro ComisionesProductos para comision origen " + oidComisionOrigen);
          UtilidadesLog.debug(nre);
      } catch (PersistenceException pe) {
          ctx.setRollbackOnly();
          UtilidadesLog.error("ERROR ", pe);
          throw new MareException(pe,
              UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS));
      }
  }  
  
  
  /**
   * @author: ssantana, 3/4/2005
   * @throws es.indra.mare.common.exception.MareException   
   */
  private void copiaComisionesClientes(Long oidComisionOrigen, Long oidComisionCopia) 
    throws MareException  {
      UtilidadesLog.info("MONGestionComisionesBean.copiaComisionesClientes(Long oidComisionOrigen, Long oidComisionCopia): Entrada");
      ComisionesClientesLocalHome comClientesLocalHome = null;
      ComisionesClientesLocal comClientesLocalOrigen = null;
      ComisionesClientesLocal comClientesLocalCopia = null;
      
      try 
      {
        comClientesLocalHome = this.getComisionesClientesLocalHome();
        Collection col = comClientesLocalHome.findByComision(oidComisionOrigen);
        
        Iterator it = col.iterator();
        while (it.hasNext() )
        {
           comClientesLocalOrigen = (ComisionesClientesLocal) it.next();
           comClientesLocalCopia = comClientesLocalHome.create(oidComisionCopia, 
                                                               comClientesLocalOrigen.getTipoClienteComisionesCabecera(),
                                                               comClientesLocalOrigen.getCodigoOrden() );
                                                               
           comClientesLocalCopia.setFecAntiguedadDesde(comClientesLocalOrigen.getFecAntiguedadDesde());
           comClientesLocalCopia.setFecAntiguedadHasta(comClientesLocalOrigen.getFecAntiguedadHasta());
           comClientesLocalCopia.setRegion(comClientesLocalOrigen.getRegion());
           comClientesLocalCopia.setSeccion(comClientesLocalOrigen.getSeccion());
           comClientesLocalCopia.setSubgerenciaVentas(comClientesLocalOrigen.getSubgerenciaVentas());
           comClientesLocalCopia.setTerritorio(comClientesLocalOrigen.getTerritorio());
           comClientesLocalCopia.setTopeMaximo(comClientesLocalOrigen.getTopeMaximo());
           comClientesLocalCopia.setTopeMinimo(comClientesLocalOrigen.getTopeMinimo());
           comClientesLocalCopia.setZonas(comClientesLocalOrigen.getZonas());
           
           comClientesLocalHome.merge(comClientesLocalCopia);
        }
        UtilidadesLog.info("MONGestionComisionesBean.copiaComisionesClientes(Long oidComisionOrigen, Long oidComisionCopia): Salida");
      
      } catch (NoResultException nre) {
          UtilidadesLog.debug("No se encontro ComisionesClientes para comision origen " + oidComisionOrigen);
          UtilidadesLog.debug(nre);
      } catch (PersistenceException pe) {
          ctx.setRollbackOnly();
          UtilidadesLog.error("ERROR ", pe);
          throw new MareException(pe,
              UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS));
      }
  }  
  
  
  /**
   * @author: ssantana, 3/4/2005
   * @throws es.indra.mare.common.exception.MareException   
   */
  private void copiaComisionesHistoricoVentas(Long oidComisionOrigen, Long oidComisionCopia) 
  throws MareException {
      UtilidadesLog.info("MONGestionComisionesBean.copiaComisionesHistoricoVentas(Long oidComisionOrigen, Long oidComisionCopia): Entrada");
      
      ComisionesVentaHistoricaLocalHome comVHLocalHome = null;
      ComisionesVentaHistoricaLocal comVHLocalOrigen = null;
      ComisionesVentaHistoricaLocal comVHLocalCopia = null;
      
      try 
      {
         comVHLocalHome = this.getComisionesVentaHistoricaLocalHome();
         comVHLocalOrigen = comVHLocalHome.findByUK(oidComisionOrigen);
         
         // Creo la copia
         comVHLocalCopia = comVHLocalHome.create(oidComisionCopia, 
                                                 comVHLocalOrigen.getPeriodoFinal(),  
                                                 comVHLocalOrigen.getPeriodoInicial() );
                                                 
         // Completo la copia con los datos de Origen
         comVHLocalCopia.setAnulaciones( comVHLocalOrigen.getAnulaciones() );
         comVHLocalCopia.setDevoluciones( comVHLocalOrigen.getDevoluciones() );
         comVHLocalCopia.setMontoIncremento( comVHLocalOrigen.getMontoIncremento() );
         comVHLocalCopia.setPorcentajeIncremento( comVHLocalOrigen.getPorcentajeIncremento() );
         
         comVHLocalHome.merge(comVHLocalCopia);
      
         UtilidadesLog.info("MONGestionComisionesBean.copiaComisionesHistoricoVentas(Long oidComisionOrigen, Long oidComisionCopia): Salida");            
         
      } catch (NoResultException nre) {
          UtilidadesLog.debug("No se encontro ComisionesClientes para comision origen " + oidComisionOrigen);
          UtilidadesLog.debug(nre);
      } catch (PersistenceException pe) {
          ctx.setRollbackOnly();
          UtilidadesLog.error("ERROR ", pe);
          throw new MareException(pe,
              UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS));
      } 
  }  
  
  /**
   * @author: ssantana, 3/4/2005
   * @throws es.indra.mare.common.exception.MareException   
   */
  private void copiaComisionesCobranza(Long oidComisionOrigen, Long oidComisionCopia) 
    throws MareException  {
    UtilidadesLog.info("MONGestionComisionesBean.copiaComisionesCobranza(Long oidComisionOrigen, Long oidComisionCopia): Entrada");
    
    ComisionesCobranzasLocalHome comCobranzaLocalHome = null;
    ComisionesCobranzasLocal comCobranzaLocalOrigen = null;
    ComisionesCobranzasLocal comCobranzaLocalCopia = null;
    
    try 
    {
      comCobranzaLocalHome = this.getComisionesCobranzasLocalHome();
      Collection col = comCobranzaLocalHome.findByComision(oidComisionOrigen);
      
      Iterator it = col.iterator();
      
      while (it.hasNext())
      {
         comCobranzaLocalOrigen = (ComisionesCobranzasLocal) it.next();
         comCobranzaLocalCopia = comCobranzaLocalHome.create(oidComisionCopia, 
                                                             comCobranzaLocalOrigen.getTipoParticipante());
                                                             
         comCobranzaLocalCopia.setDiasTrasFacturacion(comCobranzaLocalOrigen.getDiasTrasFacturacion());
         
         comCobranzaLocalHome.merge(comCobranzaLocalCopia);
         
         Long oidCobranzaCopia = comCobranzaLocalCopia.getOid();
         Long oidCobranzaOrigen = comCobranzaLocalOrigen.getOid();
         
         this.copiaComisionesCobranzaTP(oidCobranzaOrigen, oidCobranzaCopia);
      }
      
      UtilidadesLog.info("MONGestionComisionesBean.copiaComisionesCobranza(Long oidComisionOrigen, Long oidComisionCopia): Salida");
      
    } catch (NoResultException nre) {
        UtilidadesLog.debug("No se encontro ComisionesCobranza para comision origen " + oidComisionOrigen);
        UtilidadesLog.debug(nre);
    } catch (PersistenceException pe) {
        ctx.setRollbackOnly();
        UtilidadesLog.error("ERROR ", pe);
        throw new MareException(pe,
            UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS));
    }
  }  
  
  private void copiaComisionesCobranzaTP(Long oidCobranzaOrigen, Long oidCobranzaCopia) 
    throws MareException {
     UtilidadesLog.info("MONGestionComisionesBean.copiaComisionesCobranzaTP(Long oidCobranzaOrigen, Long oidCobranzaCopia): Entrada"); 
     
     ComisionesCobranzasTipoParticipanteLocalHome comTPLocalHome = null;
     ComisionesCobranzasTipoParticipanteLocal comTPLocalOrigen = null;
     ComisionesCobranzasTipoParticipanteLocal comTPLocalCopia = null;
     DAOMantenimientoComisiones daoMantenimientoComisiones = new DAOMantenimientoComisiones();
      
     try 
     {
        comTPLocalHome = this.getComisionesCobranzasTipoParticipanteLocalHome();
        Collection col = comTPLocalHome.findByCobranza(oidCobranzaOrigen);
        Iterator it = col.iterator();
        
        while (it.hasNext())
        {
           comTPLocalOrigen  = (ComisionesCobranzasTipoParticipanteLocal) it.next();
           
           comTPLocalCopia = comTPLocalHome.create(comTPLocalOrigen.getNivelTramo(),
                                                   comTPLocalOrigen.getPorcentajeRecuperacion(),
                                                   oidCobranzaCopia,
                                                   comTPLocalOrigen.getPorcentajeComision() );
                                                   
           comTPLocalCopia.setDiasComision(comTPLocalOrigen.getDiasComision());
           
           // vbongiov -- Cambio 20090913 -- 5/08/2009
           comTPLocalCopia.setPorcentajeActividad(comTPLocalOrigen.getPorcentajeActividad());

            // sapaza -- PER-SiCC-2010-0478 -- 19/08/2010
            comTPLocalCopia.setPorcentajeComisionActividad(comTPLocalOrigen.getPorcentajeComisionActividad());
           
           comTPLocalHome.merge(comTPLocalCopia);
        }

        // sapaza -- PER-SiCC-2010-0478 -- 19/08/2010
        //Recorremos la lista de Comisiones Escalonadas
         DTOOID dto = new DTOOID();
         dto.setOid(oidCobranzaOrigen);
         ArrayList listaEscalonadas = daoMantenimientoComisiones.consultarComisionesEscalonada(dto);
         
         Iterator itAux = listaEscalonadas.iterator();
         while (itAux.hasNext()) {
             DTOComisionesEscalonada dtoAux = (DTOComisionesEscalonada) itAux.next();
             daoMantenimientoComisiones.guardarComisionEscalonada(dtoAux, oidCobranzaCopia);
         }
      
      UtilidadesLog.info("MONGestionComisionesBean.copiaComisionesCobranzaTP(Long oidCobranzaOrigen, Long oidCobranzaCopia): Salida");    
          
      } catch (NoResultException nre) {
          UtilidadesLog.debug(nre);
          UtilidadesLog.info("No se encontro ComisionesCobranzaTP para comision cobranza origen " + oidCobranzaOrigen);        
      } catch (PersistenceException pe) {
          ctx.setRollbackOnly();
          UtilidadesLog.error("ERROR ", pe);
          throw new MareException(pe,
              UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS));
      }
  }  
  
  
  /**
  * @autor jquiroga@indra.com.ar
  * @throws MareException  
  * @return Long
  * @documentation
      Dado un Object, obtiene el String y genera un Long si no es null.
  */
  private Long objectToLong(Object obj) {
    UtilidadesLog.info("MONGestionComisionesBean.objectToLong(Object obj): Entrada");
    if(obj==null) {
        UtilidadesLog.info("MONGestionComisionesBean.objectToLong(Object obj): Salida");
        return null;    
    }
    
    UtilidadesLog.info("MONGestionComisionesBean.objectToLong(Object obj): Salida");    
    return new Long(obj.toString());
  }
  
	/**
	 * @autor Gustavo Viñales
	 * 
	 * Proporciona el código de la comisión. 
	 * El formato es AA/000, donde AA es el año y 000 es un número secuencial. 
	 * 
	 * Proceso 
	 * ======= 
	 * Se definen las variables String sCodigo y sCodigoMax. 
	 * 
	 * Se define la variable Integer iSecuencia. 
	 * 
	 * sCodigo = dos últimas cifras del año del sistema 
	 * sCodigo += "/" 
	 * 
	 * sCodigoMax = DAOGestionComisiones.obtenerCodigoMaximo(sCodigo) 
	 * 
	 * Si sCodigoMax == null 
	 * sCodigo += "001" 
	 * Si no 
	 * iSecuencia = convertir a Integer las tres últimas posiciones de sCodigoMax 
	 * iSecuencia += 1 
	 * 
	 * sCodigo += iSecuencia formateado a tres posiciones (rellenando de ceros por la izquierda) 
	 * Fin del Si 
	 * 
	 * Se retorna sCodigo.
	 */
	 /*private String generaCodigoComision() throws MareException 
   {
      String sCodigo, sCodigoMax;
      int iSecuencia;
  
      Format formatter;
      // The year
      formatter = new SimpleDateFormat("yy");
      sCodigo = formatter.format(new java.util.Date());
     // sCodigo += "/";
      sCodigoMax = new DAOGestionComisiones().obtenerCodigoMaximo(sCodigo);
  
      if (sCodigoMax == null) {
        sCodigo += "001";
      } else {
        // iSecuencia = convertir a Integer las tres últimas posiciones de sCodigoMax 
        iSecuencia = new Integer(sCodigoMax.substring(3)).intValue();
        iSecuencia += 1;
        
        // Agregado de ssantana, 3/4/2005
        int iCantCeros = 3 - (String.valueOf(iSecuencia).length());

        StringBuffer sPaddedSequence = new StringBuffer("");
        for (int i = 0; i < iCantCeros; i++)
          sPaddedSequence.append("0");
          
        sCodigo += sPaddedSequence.toString() + String.valueOf(iSecuencia);
        UtilidadesLog.info("CodigoComision generado: " + sCodigo);        
        //sCodigo += iSecuencia formateado a tres posiciones (rellenando de ceros por la izquierda) 
      }
      return sCodigo;
	}*/
  
  


  private MONPeriodosHome getMONPeriodosHome() throws NamingException
  {
    final InitialContext context = new InitialContext();
    return (MONPeriodosHome)PortableRemoteObject.narrow(context.lookup("java:comp/env/MONPeriodos"), MONPeriodosHome.class);
  }


    /**
     * @autor Gustavo Viñales
     * 
     * Proporciona el código de la comisión. 
     * El formato es AA/000, donde AA es el año y 000 es un número secuencial. 
     * 
     * Proceso 
     * ======= 
     * Se definen las variables String sCodigo y sCodigoMax. 
     * 
     * Se define la variable Integer iSecuencia. 
     * 
     * sCodigo = dos últimas cifras del año del sistema 
     * sCodigo += "/" 
     * 
     * sCodigoMax = DAOGestionComisiones.obtenerCodigoMaximo(sCodigo) 
     * 
     * Si sCodigoMax == null 
     * sCodigo += "001" 
     * Si no 
     * iSecuencia = convertir a Integer las tres últimas posiciones de sCodigoMax 
     * iSecuencia += 1 
     * 
     * sCodigo += iSecuencia formateado a tres posiciones (rellenando de ceros por la izquierda) 
     * Fin del Si 
     * 
     * Se retorna sCodigo.
     */
  public String generaCodigoComision() throws MareException { 
      UtilidadesLog.info("MONGestionComisionesBean.generaCodigoComision(): Entrada");   
      String sCodigo, sCodigoMax;
      int iSecuencia;
  
      Format formatter;
      // The year
      formatter = new SimpleDateFormat("yy");
      sCodigo = formatter.format(new java.util.Date());
     // sCodigo += "/";
      sCodigoMax = new DAOGestionComisiones().obtenerCodigoMaximo(sCodigo);
      UtilidadesLog.debug("sCodigoMax " + sCodigoMax);   
  
      if (sCodigoMax == null) {
        sCodigo += "001";
      }
      else {
        // iSecuencia = convertir a Integer las tres últimas posiciones de sCodigoMax 
        iSecuencia = new Integer(sCodigoMax.substring(2)).intValue();
        UtilidadesLog.debug("iSecuencia " + iSecuencia);   
        iSecuencia += 1;
        UtilidadesLog.debug("iSecuencia " + iSecuencia);   
        
        // Agregado de ssantana, 3/4/2005
        int iCantCeros = 3 - (String.valueOf(iSecuencia).length());
        UtilidadesLog.debug("iCantCeros " + iCantCeros);   

        StringBuffer sPaddedSequence = new StringBuffer("");
        for (int i = 0; i < iCantCeros; i++)
          sPaddedSequence.append("0");
          
        sCodigo += sPaddedSequence.toString() + String.valueOf(iSecuencia);
        UtilidadesLog.debug("sCodigo " + sCodigo);        
        //sCodigo += iSecuencia formateado a tres posiciones (rellenando de ceros por la izquierda) 
      }
      
      UtilidadesLog.info("MONGestionComisionesBean.generaCodigoComision(): Salida");   
      return sCodigo;
  }

  public DTOSalida obtenerTiposPlantilla() throws MareException {
    UtilidadesLog.info("MONGestionComisionesBean.obtenerTiposPlantilla(): Entrada");
    DAOGestionComisiones dao = new DAOGestionComisiones();
    DTOSalida dtos = dao.obtenerTiposPlantilla();
    UtilidadesLog.info("MONGestionComisionesBean.obtenerTiposPlantilla(): Salida");
    return dtos;
  }


    public DTOSalida obtenerPeriodosMayores(DTOPeriodo dto) throws MareException {
    UtilidadesLog.info("MONGestionComisionesBean.obtenerPeriodosMayores(): Entrada");
    DAOGestionComisiones dao = new DAOGestionComisiones();
    DTOSalida dtos = dao.obtenerPeriodosMayores(dto);
    UtilidadesLog.info("MONGestionComisionesBean.obtenerPeriodosMayores(): Salida");
    return dtos;        
  }

  public DTOSalida obtenerPeriodoAnioAnterior(DTOOID dto) throws MareException {
    UtilidadesLog.info("MONGestionComisionesBean.obtenerPeriodoAnioAnterior(DTOOID dto): Entrada");
    DAOCRA dao = new DAOCRA();
    DTOPeriodo dtoPeriodo = new DTOPeriodo();
    dtoPeriodo.setOid(dto.getOid());
    DTOSalida dtos = dao.obtenerPeriodoAnioAnterior(dtoPeriodo);
    UtilidadesLog.info("MONGestionComisionesBean.obtenerPeriodoAnioAnterior(DTOOID dto): Salida");
    return dtos;            
  }
  
    private ComisionesLocalHome getComisionesLocalHome() throws MareException {      
       return new ComisionesLocalHome();
    }

    private PlantillasComisionesMarcaLocalHome getPlantillasComisionesMarcaLocalHome() throws MareException {      
       return new PlantillasComisionesMarcaLocalHome();
    }

    private MaestroProductosLocalHome getMaestroProductosLocalHome() throws NamingException
    {
        final InitialContext context = new InitialContext();
        return (MaestroProductosLocalHome)context.lookup("java:comp/env/MaestroProductos");
    }
    
    private ComisionesCobranzasLocalHome getComisionesCobranzasLocalHome() throws MareException {      
       return new ComisionesCobranzasLocalHome();
    }

    private ComisionesVentaHistoricaLocalHome getComisionesVentaHistoricaLocalHome() throws MareException {      
       return new ComisionesVentaHistoricaLocalHome();
    }

    private ComisionesVentasLocalHome getComisionesVentasLocalHome() throws MareException {      
       return new ComisionesVentasLocalHome();
    }

    private ComisionesClientesLocalHome getComisionesClientesLocalHome() throws MareException {      
       return new ComisionesClientesLocalHome();
    }

    private ComisionesProductosLocalHome getComisionesProductosLocalHome() throws MareException {      
       return new ComisionesProductosLocalHome();
    }

    private ComisionesAccesoLocalHome getComisionesAccesoLocalHome() throws MareException {      
       return new ComisionesAccesoLocalHome();
    }

    private ComisionesCobranzasTipoParticipanteLocalHome getComisionesCobranzasTipoParticipanteLocalHome() throws MareException {      
       return new ComisionesCobranzasTipoParticipanteLocalHome();
    }

    private PlantillasComisionesPaisLocalHome getPlantillasComisionesPaisLocalHome() throws MareException {      
       return new PlantillasComisionesPaisLocalHome();
    }

}
