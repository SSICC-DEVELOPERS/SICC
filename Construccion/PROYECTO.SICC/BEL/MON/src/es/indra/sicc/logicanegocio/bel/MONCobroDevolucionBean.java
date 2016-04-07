package es.indra.sicc.logicanegocio.bel;
import es.indra.mare.common.exception.MareException;
import es.indra.mare.common.mii.services.jdbcservice.RecordSet;
import es.indra.sicc.cmn.negocio.i18n.Entidadi18nLocal;
import es.indra.sicc.cmn.negocio.i18n.Entidadi18nLocalHome;
import es.indra.sicc.dtos.bel.DTOCargaMedioPago;
import es.indra.sicc.dtos.bel.DTOCargaMoneda;
import es.indra.sicc.dtos.bel.DTODatosCobroDevolucion;
import es.indra.sicc.entidades.seg.MonedaLocal;
import es.indra.sicc.entidades.seg.MonedaLocalHome;
import es.indra.sicc.entidades.seg.PaisLocal;
import es.indra.sicc.entidades.seg.PaisLocalHome;
import es.indra.sicc.logicanegocio.seg.ConstantesSEG;
import es.indra.sicc.logicanegocio.seg.MONMantenimientoSEG;
import es.indra.sicc.logicanegocio.seg.MONMantenimientoSEGHome;
import es.indra.sicc.util.CodigosError;
import es.indra.sicc.util.DTOOID;
import es.indra.sicc.util.UtilidadesEJB;
import es.indra.sicc.util.UtilidadesError;
import es.indra.sicc.util.UtilidadesLog;
import java.math.BigDecimal;
import java.rmi.RemoteException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.ejb.CreateException;
import javax.ejb.FinderException;
import javax.ejb.SessionBean;
import javax.ejb.SessionContext;
import javax.naming.NamingException;
import javax.naming.InitialContext;
import es.indra.sicc.comunapplet.ConstantesApplet;
import es.indra.sicc.dtos.bel.DTOApplet;

import javax.persistence.NoResultException;
import javax.persistence.PersistenceException;

public class MONCobroDevolucionBean implements SessionBean 
{
  private SessionContext ctx = null;

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

  public void setSessionContext(SessionContext ctx)
  {
      this.ctx=ctx;
  }
  
  
  /**
  * @throws MareException
  * @return es.indra.sicc.dtos.bel.DTODatosCobroDevolucion
  * @param DTOOID
  * @autor jquiroga
  * @documentation
        // Carga inicial de la página Cobrar en Belcenter
        Crear DTOCargaDevolverDinero  -> Modificado por DTODatosCobroDevolucion en INC BELC300014213 
        
        // MEDIO PAGO
        resultado = DAOMediosPagoBelcenter.obtenerMediosPagoSubacceso(DTOOID)
        DTOCargaDevolverDinero.medioPago = crearDTOCargaMedioPago(resultado)
        
        // MONEDA
        pais = Pais.findByPrimaryKey(DTOBelcorp.pais)
        entidadi18N = EntidadI18N.findByEntAtrIdioPK(ConstantesSEG.SEG_MONED, 1, DTOE.idioma, pais.monedaAlternativa) 
        moneda = Moneda.findByPrimaryKey(pais.moneda)
        DTOCargaDevolverDinero.moneda.oid = pais.monedaAlternativa
        DTOCargaDevolverDinero.moneda.descripcion = entidadi18N.detalle
        DTOCargaDevolverDinero.moneda.decimales = moneda.numeroDecimales
        
        // TIPO CAMBIO
        DTOCargaDevolverDinero.tipoCambio = IServicioSEG.obtenerTipoCambio(pais.moneda, pais.monedaAlternativa) 
        Si DTOCargaDevolverDinero.tipoCambio == null o vacío
        {
        DTOCargaDevolverDinero.tipoCambio = IServicioSEG.obtenerTipoCambioAnterior(pais.moneda, pais.monedaAlternativa, Fecha sistema) 
        }
        
        Devuelve DTOCargaDevolverDinero
  */
  public DTODatosCobroDevolucion cargaInicial(DTOApplet dtoa) throws MareException {
    UtilidadesLog.info("MONCobroDevolucionBean.cargaInicial(DTOApplet dtoa):Entrada");
    DTOOID dtoE = (DTOOID)dtoa.getDto();
    String userName = dtoa.getUserName();
    // Carga inicial de la página Cobrar en Belcenter
    DTODatosCobroDevolucion dtoDatosCobroDevolucion=new DTODatosCobroDevolucion();
    //DAOMediosPagoBelcenter daoMediosPagoBelcenter=new DAOMediosPagoBelcenter(ctx.getCallerPrincipal().getName());
    DAOMediosPagoBelcenter daoMediosPagoBelcenter=new DAOMediosPagoBelcenter(userName);
    //DAOMediosPagoBelcenter daoMediosPagoBelcenter=new DAOMediosPagoBelcenter("USUARIO1");
    RecordSet resultado=null;
    
    PaisLocalHome paisLocalHome = null;
    PaisLocal paisLocal = null;
    Entidadi18nLocalHome entidadi18nLocalHome = null;
    Entidadi18nLocal entidadi18nLocal=null;
    MonedaLocalHome monedaLocalHome = null;
    MonedaLocal monedaLocal = null;
    MONMantenimientoSEGHome monMantenimientoSEGHome=null;
    MONMantenimientoSEG monMantenimientoSEG=null;     
    
    // MEDIO PAGO
    resultado = daoMediosPagoBelcenter.obtenerMediosPagoSubacceso(dtoE);
    dtoDatosCobroDevolucion.setMedioPago(crearDTOCargaMedioPago(resultado));
    
    //------------------------------------------
    // MONEDA    
    try {
      paisLocalHome=getPaisLocalHome();
      paisLocal = paisLocalHome.findByPrimaryKey(dtoE.getOidPais());
      
      entidadi18nLocalHome=getEntidadi18nLocalHome();
      entidadi18nLocal = entidadi18nLocalHome.findByEntAtrIdioPK(ConstantesSEG.SEG_MONED, new Long(1), dtoE.getOidIdioma(), paisLocal.getMone_oid_mone_alt());
      
      
      monedaLocalHome=getMonedaLocalHome();
      monedaLocal = monedaLocalHome.findByPrimaryKey(paisLocal.getMone_oid_mone());
    } catch (NoResultException fex) {
        UtilidadesLog.debug(fex);
        throw new MareException(fex,UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
    }  catch (PersistenceException ce) {   
        UtilidadesLog.error("ERROR ", ce);
        throw new MareException(ce, 
        UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
    } catch (Exception ex) { //ERROR NO DOCUMENTADO
        UtilidadesLog.debug(ex);
        throw new MareException(ex);
    }
    //if(dtoDatosCobroDevolucion.getMoneda()!=null) {
      dtoDatosCobroDevolucion.setMoneda(new DTOCargaMoneda());
      dtoDatosCobroDevolucion.getMoneda().setOid(paisLocal.getMone_oid_mone_alt());
      dtoDatosCobroDevolucion.getMoneda().setDescripcion(entidadi18nLocal.getDetalle());
      dtoDatosCobroDevolucion.getMoneda().setDecimales(longToInteger(monedaLocal.getNumDeci()));
    //}
    //------------------------------------------
    
    //------------------------------------------
    // TIPO CAMBIO
    try {
      monMantenimientoSEGHome=(MONMantenimientoSEGHome)UtilidadesEJB.getHome("MONMantenimientoSEG", MONMantenimientoSEGHome.class);
      monMantenimientoSEG=monMantenimientoSEGHome.create();
         
      dtoDatosCobroDevolucion.setTipoCambio(monMantenimientoSEG.obtenerTipoCambio(paisLocal.getMone_oid_mone(), paisLocal.getMone_oid_mone_alt()));
      if(dtoDatosCobroDevolucion.getTipoCambio() == null || dtoDatosCobroDevolucion.getTipoCambio().intValue()==0) {
        dtoDatosCobroDevolucion.setTipoCambio(monMantenimientoSEG.obtenerTipoCambioAnterior(paisLocal.getMone_oid_mone(), paisLocal.getMone_oid_mone_alt(), new Date(System.currentTimeMillis())));
      }
    }
    catch (CreateException cex) {
        UtilidadesLog.debug(cex);
        throw new MareException(cex,UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
    } 
    catch(RemoteException rex) {
        UtilidadesLog.debug(rex);
        throw new MareException(rex,UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));    
    }
    catch (Exception ex) { //ERROR NO DOCUMENTADO
        UtilidadesLog.debug(ex);
        throw new MareException(ex);
    }    
    //------------------------------------------
    UtilidadesLog.info("MONCobroDevolucionBean.cargaInicial(DTOApplet dtoa):Salida");
    return dtoDatosCobroDevolucion;
  }

  /**
  * @throws MareException
  * @return es.indra.sicc.dtos.bel.DTOCargaMedioPago[]
  * @param RecordSet
  * @autor jquiroga
  * @documentation
      Crea un DTOCargaMedioPago por cada fila del RecordSet recibido y los devuelve 
      
      DTOCargaMedioPago.oid = resultado.getValueAt(fila, 0) 
      DTOCargaMedioPago.descripcion = resultado.getValueAt(fila, 1) 
      DTOCargaMedioPago.oidTipoMedioPago = resultado.getValueAt(fila, 2) 
      
      Devuelve DTOCargaMedioPago[]   
  */
  private DTOCargaMedioPago[] crearDTOCargaMedioPago (RecordSet resultado) {
    UtilidadesLog.info("MONCobroDevolucionBean.crearDTOCargaMedioPago(RecordSet resultado):Entrada");
    if(resultado!=null) {
    
      DTOCargaMedioPago[] dtoCargaMedioPagos=new DTOCargaMedioPago[resultado.getRowCount()];
    
      for(int fila=0; fila<resultado.getRowCount(); fila++) {
        dtoCargaMedioPagos[fila]=new DTOCargaMedioPago();
        dtoCargaMedioPagos[fila].setOid(objectToLong(resultado.getValueAt(fila, 0)));
        dtoCargaMedioPagos[fila].setDescripcion(objectToString(resultado.getValueAt(fila, 1))); 
        dtoCargaMedioPagos[fila].setOidTipoMedioPago(objectToLong(resultado.getValueAt(fila, 2)));
      }
      UtilidadesLog.info("MONCobroDevolucionBean.crearDTOCargaMedioPago(RecordSet resultado):Salida");
      return dtoCargaMedioPagos;
    }
    else { 
      UtilidadesLog.info("MONCobroDevolucionBean.crearDTOCargaMedioPago(RecordSet resultado):Salida");
      return null;
    }
  }

  private Long objectToLong(Object obj) {
    if (obj != null) {
      Long result = new Long(((BigDecimal)obj).longValue());
      return result;
    }
    else {
      return null;
      }
  }
  
  private String objectToString(Object obj) {
    if (obj != null) {
      return (String)obj;
    }
    else {
      return null;
    }
  }
  
  private Integer longToInteger(Long obj) {
    if (obj != null) {
      Integer result = new Integer(obj.intValue());
      return result;
    } else {
      return null;
    }
  }

  private MonedaLocalHome getMonedaLocalHome() {
    return new MonedaLocalHome();
  }

  private PaisLocalHome getPaisLocalHome() {
    return new PaisLocalHome();
  }

  private Entidadi18nLocalHome getEntidadi18nLocalHome() {
    return new Entidadi18nLocalHome();
  }  
}