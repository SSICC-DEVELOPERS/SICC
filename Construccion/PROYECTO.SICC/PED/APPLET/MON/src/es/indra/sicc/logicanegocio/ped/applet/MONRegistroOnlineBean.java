package es.indra.sicc.logicanegocio.ped.applet;

import es.indra.mare.common.exception.MareException;
import es.indra.mare.common.mgc.MareMGC;
import es.indra.mare.common.mgu.MGUService;
import es.indra.mare.common.mgu.manager.Property;
import es.indra.mare.common.mgu.manager.UserIDImpl;
import es.indra.mare.common.mii.MareCredentials;
import es.indra.mare.common.mii.MareMii;
import es.indra.mare.common.mii.MareTopic;
import es.indra.mare.common.mii.services.jdbcservice.RecordSet;
import es.indra.sicc.cmn.negocio.i18n.Entidadi18nLocal;
import es.indra.sicc.cmn.negocio.i18n.Entidadi18nLocalHome;
//import es.indra.sicc.comunapplet.ConstantesApplet;
import es.indra.sicc.dtos.bel.DTOCambiosVentas;
import es.indra.sicc.dtos.bel.DTOMovimientoAlmacen;
import es.indra.sicc.dtos.bel.DTOMovimientoAlmacenCabecera;
import es.indra.sicc.dtos.bel.DTOMovimientoAlmacenDetalle;
import es.indra.sicc.dtos.bel.DTOObtenerNotasCreditoPendientes;
import es.indra.sicc.dtos.bel.DTOObtenerSolicitudCobro;
import es.indra.sicc.dtos.bel.DTOPosicionCambioVenta;
import es.indra.sicc.dtos.bel.DTOReportePedidos;
import es.indra.sicc.dtos.bel.DTOReversionMovimiento;
import es.indra.sicc.dtos.ccc.DTOSaldosPorDiasPeriodos;
import es.indra.sicc.dtos.ccc.DTOSaldosPorFechas;
import es.indra.sicc.dtos.ccc.DTOSaldosPorFechasyVtos;
import es.indra.sicc.dtos.ccc.DTOTotal;
import es.indra.sicc.dtos.ccc.DTOTotalyDias;
import es.indra.sicc.dtos.ped.DTOCabeceraSolicitud;
import es.indra.sicc.dtos.ped.DTONumeroSolicitud;
import es.indra.sicc.dtos.ped.DTOPosicionSolicitud;
import es.indra.sicc.dtos.ped.applet.DTOBuscarProductosRegistro;
import es.indra.sicc.dtos.ped.applet.DTOCargaPantallaBusqueda;
import es.indra.sicc.dtos.ped.applet.DTOCargaRegistroOnline;
import es.indra.sicc.dtos.ped.applet.DTODatosCliente;
import es.indra.sicc.dtos.ped.applet.DTODatosCombo;
import es.indra.sicc.dtos.ped.applet.DTOGenerarPosicionRegistro;
import es.indra.sicc.dtos.ped.applet.DTOInfoProducto;
import es.indra.sicc.dtos.ped.applet.DTOPresentarFlete;
import es.indra.sicc.dtos.ped.applet.DTORevertirPosicionRegistro;
import es.indra.sicc.dtos.ped.applet.DTOTipoDocumento;
import es.indra.sicc.dtos.ped.applet.DTOTiposSolicitud;
import es.indra.sicc.dtos.pre.DTOEValidarCodigoVenta;
import es.indra.sicc.dtos.pre.DTOSValidarCodigoVenta;
import es.indra.sicc.entidades.bel.AsociacionMaquinaCajaLocal;
import es.indra.sicc.entidades.bel.AsociacionMaquinaCajaLocalHome;
import es.indra.sicc.entidades.bel.CajaLocal;
import es.indra.sicc.entidades.bel.CajaLocalHome;
import es.indra.sicc.entidades.bel.StockLocal;
import es.indra.sicc.entidades.bel.StockLocalHome;
import es.indra.sicc.entidades.mae.ClienteDatosBasicosLocal;
import es.indra.sicc.entidades.mae.ClienteDatosBasicosLocalHome;
import es.indra.sicc.entidades.mae.MaestroProductosLocal;
import es.indra.sicc.entidades.mae.MaestroProductosLocalHome;
import es.indra.sicc.entidades.mae.MaestroProductosPK;
import es.indra.sicc.entidades.ped.TiposSolicitudPaisLocal;
import es.indra.sicc.entidades.ped.TiposSolicitudPaisLocalHome;
import es.indra.sicc.entidades.pre.DetalleOfertaLocal;
import es.indra.sicc.entidades.pre.DetalleOfertaLocalHome;
import es.indra.sicc.entidades.seg.PaisLocal;
import es.indra.sicc.entidades.seg.PaisLocalHome;
import es.indra.sicc.entidades.seg.RelacionMCorpoMProduLocal;
import es.indra.sicc.entidades.seg.RelacionMCorpoMProduLocalHome;
import es.indra.sicc.logicanegocio.bel.ConstantesBEL;
import es.indra.sicc.logicanegocio.bel.MONGenerarMovimientoAlmacen;
import es.indra.sicc.logicanegocio.bel.MONGenerarMovimientoAlmacenHome;
import es.indra.sicc.logicanegocio.bel.MONGestionFormasPagoDetalle;
import es.indra.sicc.logicanegocio.bel.MONGestionFormasPagoDetalleHome;
import es.indra.sicc.logicanegocio.ccc.MONInterfaceModulos;
import es.indra.sicc.logicanegocio.ccc.MONInterfaceModulosHome;
import es.indra.sicc.logicanegocio.mae.MONClientes;
import es.indra.sicc.logicanegocio.mae.MONClientesHome;
import es.indra.sicc.logicanegocio.mae.MONConfiguracionClientes;
import es.indra.sicc.logicanegocio.mae.MONConfiguracionClientesHome;
//import es.indra.sicc.logicanegocio.mae.MONProductos;
import es.indra.sicc.logicanegocio.mae.MONProductosHome;
import es.indra.sicc.logicanegocio.ped.ConstantesPED;
import es.indra.sicc.logicanegocio.ped.DAODigitacion;
import es.indra.sicc.logicanegocio.ped.DAOGestionStock;
import es.indra.sicc.logicanegocio.ped.DAOGruposProceso;
import es.indra.sicc.logicanegocio.ped.DAOPEDIntegracion;
import es.indra.sicc.logicanegocio.ped.DAOSolicitud;
import es.indra.sicc.logicanegocio.ped.ErroresNegocio;
import es.indra.sicc.logicanegocio.ped.MONDigitacionInicial;
import es.indra.sicc.logicanegocio.ped.MONDigitacionInicialHome;
import es.indra.sicc.logicanegocio.ped.MONGenerarPosicionSolicitud;
import es.indra.sicc.logicanegocio.ped.MONGenerarPosicionSolicitudHome;
import es.indra.sicc.logicanegocio.ped.MONProcesosPED;
import es.indra.sicc.logicanegocio.ped.MONProcesosPEDHome;
import es.indra.sicc.logicanegocio.pre.MONCuadreOfertas;
import es.indra.sicc.logicanegocio.pre.MONMantenimientoMF;
import es.indra.sicc.logicanegocio.pre.MONMantenimientoMFHome;
import es.indra.sicc.logicanegocio.pre.PREConsultas;
import es.indra.sicc.logicanegocio.seg.ConstantesSEG;
import es.indra.sicc.util.CodigosError;
import es.indra.sicc.util.DTOBelcorp;
import es.indra.sicc.util.DTOOID;
import es.indra.sicc.util.DTOSalida;
import es.indra.sicc.util.ExcepcionParametrizada;
import es.indra.sicc.util.UtilidadesEJB;
import es.indra.sicc.util.UtilidadesError;

import es.indra.sicc.util.UtilidadesLog;
import java.math.BigDecimal;

import java.rmi.RemoteException;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.ejb.CreateException;
import javax.ejb.FinderException;
import javax.ejb.SessionBean;
import javax.ejb.SessionContext;

import javax.naming.InitialContext;
import javax.naming.NamingException;

import javax.rmi.PortableRemoteObject;
import es.indra.sicc.dtos.bel.DTOApplet;
import es.indra.sicc.dtos.ped.applet.DTOSolicitudesAnteriores;
import es.indra.sicc.logicanegocio.pre.MONCuadreOfertasHome;

import javax.persistence.NoResultException;
import javax.persistence.PersistenceException;

public class MONRegistroOnlineBean implements SessionBean  {
  private SessionContext ctx = null;
  
  private Long obtenerControlStock(Long oidPeriodo, String codVenta, Long oidCliente, Long oidZona, Integer unidadesAtender) throws MareException  {    
    UtilidadesLog.info("MONRegistroOnlineBean.obtenerControlStock(Long oidPeriodo, String codVenta, Long oidCliente, Long oidZona, Integer unidadesAtender): Entrada ");
    DAOGestionStock daoGestionStock = new DAOGestionStock();
    BigDecimal bd_lControl;
    BigDecimal bd_UnidadesAtender;
    BigDecimal bd_Porcentaje;
    BigDecimal bd_unidadesAtender_para;
    BigDecimal bd_lStock=new BigDecimal(0);    
    bd_unidadesAtender_para=new BigDecimal(unidadesAtender.intValue());
    
    RecordSet ventas = daoGestionStock.obtieneVentasStock2(oidPeriodo, codVenta, oidCliente, oidZona);
    
    if(ventas == null || ventas.getRowCount() == 0) {
      return new Long(0);
    } else {
      for(int i=0; i<ventas.getRowCount(); i++) {
        bd_Porcentaje=objectToBigDecimal(ventas.getValueAt(i, 0));
        bd_UnidadesAtender=objectToBigDecimal(ventas.getValueAt(i, 1));
        
        if(bd_Porcentaje == null) {
          bd_lControl = bd_UnidadesAtender;
        }
        else {
          bd_lControl = (bd_unidadesAtender_para.multiply(bd_Porcentaje)).divide(new BigDecimal(100),0);  //SIN DECIMALES!
        }
        if(bd_lStock.compareTo(bd_lControl)==-1) {  //Es menor?
          bd_lStock = bd_lControl;
        }
      }
    }

    UtilidadesLog.info("MONRegistroOnlineBean.obtenerControlStock(Long oidPeriodo, String codVenta, Long oidCliente, Long oidZona, Integer unidadesAtender): Salida ");
    return objectToLong(bd_lStock);
  }
  
  private Boolean obtenerControlLiquidacion(Long oidPeriodo, String codVenta, Long oidCliente, Long oidZona) throws MareException  {
    UtilidadesLog.info("MONRegistroOnlineBean.obtenerControlLiquidacion(Long oidPeriodo, String codVenta, Long oidCliente, Long oidZona): Entrada ");
    DAOGestionStock daoGestionStock = new DAOGestionStock();    
    Integer iNumVentas = daoGestionStock.obtieneVentasLiquidacion2(oidPeriodo, codVenta, oidCliente, oidZona);
    UtilidadesLog.info("MONRegistroOnlineBean.obtenerControlLiquidacion(Long oidPeriodo, String codVenta, Long oidCliente, Long oidZona): Salida ");
    if(iNumVentas!=null && (iNumVentas.intValue() > 0))
      return Boolean.TRUE;
    else
      return Boolean.FALSE;
  }

  private Long obtenerLimiteVenta(Long oidPeriodo, String codVenta, Long oidCliente, Long oidZona) throws MareException
  {
    UtilidadesLog.info("MONRegistroOnlineBean.obtenerLimiteVenta(Long oidPeriodo, String codVenta, Long oidCliente, Long oidZona): Entrada ");
    DAOPEDIntegracion daoPEDIntegracion = new DAOPEDIntegracion();
    
    DTOOID dtoOID=daoPEDIntegracion.obtenerLimiteVenta(oidPeriodo, codVenta, oidCliente, oidZona);        
    if (dtoOID==null){
        UtilidadesLog.info("MONRegistroOnlineBean.obtenerLimiteVenta(Long oidPeriodo, String codVenta, Long oidCliente, Long oidZona): Salida ");
        return null;
    }
    UtilidadesLog.info("MONRegistroOnlineBean.obtenerLimiteVenta(Long oidPeriodo, String codVenta, Long oidCliente, Long oidZona): Salida ");
    return dtoOID.getOid();
  }

  // Obtiene las unidades disponibles a reservar
  private DTOInfoProducto obtenerUnidadesDisponibles(DTOInfoProducto dtoInfoProducto) throws MareException
  {
    UtilidadesLog.info("MONRegistroOnlineBean.obtenerUnidadesDisponibles(DTOInfoProducto dtoInfoProducto): Entrada ");
    StockLocalHome stockLocalHome;
    StockLocal stockLocal=null;
    boolean error=false;
    Long saldo = null;
    try {
      //stockLocalHome=getStockLocalHome();
      //stockLocal=stockLocalHome.findByClaveUnica(dtoInfoProducto.getOidAlmacen(), ConstantesBEL.OID_ESTADO_LIBRE_DISPOSICION, dtoInfoProducto.getOidProducto());
      saldo = this.obtenerSaldo(dtoInfoProducto.getOidAlmacen(), ConstantesBEL.CODIGO_ESTADO_LIBRE_DISPOSICION, dtoInfoProducto.getOidProducto(), dtoInfoProducto.getOidPais());
    }
    catch (Exception fex) {
      UtilidadesLog.error("Error",fex);
      error=true;
    }
    
    if(error || saldo.longValue() <=0) {
      dtoInfoProducto.setStockDisponible(new Long(0));
      return dtoInfoProducto;      
    }
    dtoInfoProducto.setStockDisponible(saldo);
    
    if(error || saldo.longValue() <=0) {  //Si se produce una Excepcion OR stock.saldo <= 0
      // Habrá que buscar el producto alternativo
      dtoInfoProducto.setCodigoVenta(null);
      dtoInfoProducto.setOidProducto(null);
      dtoInfoProducto.setCodigoProducto(null);
      dtoInfoProducto.setUnidadesDemandadas(new Integer(0));
    }
    else {
      dtoInfoProducto.setCantidadReservar(dtoInfoProducto.getUnidadesDemandadas());
      dtoInfoProducto.setUnidadesPorAtender(dtoInfoProducto.getUnidadesDemandadas());
      dtoInfoProducto.setUnidadesDemandaReal(dtoInfoProducto.getUnidadesDemandadas());
      
      if(dtoInfoProducto.getStockDisponible() != null && 
        dtoInfoProducto.getCantidadReservar() != null &&
        dtoInfoProducto.getStockDisponible().longValue() < dtoInfoProducto.getCantidadReservar().longValue()) {
        
        dtoInfoProducto.setCantidadReservar(LongToInteger(dtoInfoProducto.getStockDisponible()));
        dtoInfoProducto.setUnidadesPorAtender(dtoInfoProducto.getCantidadReservar());
        dtoInfoProducto.setUnidadesDemandaReal(dtoInfoProducto.getCantidadReservar());
      }
      if(dtoInfoProducto.getLimiteVenta() != null && 
        dtoInfoProducto.getCantidadReservar() != null &&
        0 < dtoInfoProducto.getLimiteVenta().longValue() && 
        dtoInfoProducto.getLimiteVenta().longValue() < dtoInfoProducto.getCantidadReservar().longValue()) { 
        
        dtoInfoProducto.setCantidadReservar(LongToInteger(dtoInfoProducto.getLimiteVenta()));
        dtoInfoProducto.setUnidadesPorAtender(dtoInfoProducto.getCantidadReservar());
        dtoInfoProducto.setUnidadesDemandaReal(dtoInfoProducto.getCantidadReservar());
      }
      if(dtoInfoProducto.getControlStock() != null &&
        dtoInfoProducto.getCantidadReservar() != null &&
        0 < dtoInfoProducto.getControlStock().longValue() && dtoInfoProducto.getControlStock().longValue() < dtoInfoProducto.getCantidadReservar().longValue()) { 
        
        dtoInfoProducto.setCantidadReservar(LongToInteger(dtoInfoProducto.getControlStock()));
        dtoInfoProducto.setUnidadesPorAtender(dtoInfoProducto.getCantidadReservar());
      }
    }
    UtilidadesLog.info("MONRegistroOnlineBean.obtenerUnidadesDisponibles(DTOInfoProducto dtoInfoProducto): Salida ");
    return dtoInfoProducto;
  }  
  
  private Long obtenerSaldo(Long almacen, String codigoLibreDisposicion, Long producto, Long pais) throws MareException{
      DAORegistroOnline dao = new DAORegistroOnline(ctx.getCallerPrincipal().getName());
      return dao.obtenerSaldo(almacen, codigoLibreDisposicion, producto, pais);
  }

  /**************************************************************************************
  VER INC BELC300013038    
    -El DAO que genera el RecordSet de entrada no ordena por OID_TIPO_SOLI_PAIS, por ende no funciona el algoritmmo.
    -Asi como esta el algoritmo solo contempla 1 o 2 periodos, no se sabe si pueden llegar mas o ninguno.
    -Asi como esta el algoritmo no contempla los huecos null que quedan en dtoTiposSolicitudes[].
  **************************************************************************************/
  // Crea un DTOTipoSolicitud a partir del RecordSet recibido
  // Si encontramos 2 registros con el mismo oidTipoSolicitud, significa que ese tipo de solicitud tiene 2 periodos solapados 
  // En ese caso, crearemos un único DTOTipoSolicitud y dos DTOCargaCombo con el valor de ambos periodos 
  private DTOTiposSolicitud[]  crearDTOTiposSolicitud(RecordSet resultado) throws MareException {
    //CONTROL DE ERRORES
    UtilidadesLog.info("MONRegistroOnlineBean.crearDTOTiposSolicitud(RecordSet resultado): Entrada ");
    if(resultado==null) {
        UtilidadesLog.info("MONRegistroOnlineBean.crearDTOTiposSolicitud(RecordSet resultado): Salida NULL");
      return null;
    }
    if(resultado.getRowCount()==0) {
        UtilidadesLog.info("MONRegistroOnlineBean.crearDTOTiposSolicitud(RecordSet resultado): Salida VACIO");
      return new DTOTiposSolicitud[0];
    }
    //CONTROL DE ERRORES
    
    Long ln_Anterior=null;
    Long ln_Posterior=null;
    DTODatosCombo[] dtoDatosCombos=null;
    DTODatosCombo dtoDatosCombo=null;
    DTOTiposSolicitud[] dtoTiposSolicitudes=new DTOTiposSolicitud[resultado.getRowCount()];
    DTOTiposSolicitud dtoTiposSolicitud;
    int i_anterior=0;
    for(int i=0; i<resultado.getRowCount(); i++) {
      ln_Posterior=objectToLong(resultado.getValueAt(i, "OID_TSP"));
      
      if(i!=0 && ln_Posterior.equals(ln_Anterior)) {
        //Creamos un DTODatosCombo[] de dos o mas periodos
        //UtilidadesLog.debug("Entro por si hay dos periodos");
        dtoDatosCombos = dtoTiposSolicitudes[i_anterior].getPeriodos();
        
        //Seteo el segundo periodo
        dtoDatosCombo=new DTODatosCombo();
        dtoDatosCombo.setOid(objectToLong(resultado.getValueAt(i, "OID_PERIODO")));
        dtoDatosCombo.setDesc((String)resultado.getValueAt(i, "PERIODO"));
        
        //POR SI HAY MAS QUE UN PERIODO ANTERIOR!
        dtoDatosCombos = addRowArrayDTODatosCombo(dtoDatosCombos, dtoDatosCombo);
        
        //Añadimos el nuevo Array de DTODatosCombo al dtoTiposSolicitudes anterior
        dtoTiposSolicitudes[i_anterior].setPeriodos(dtoDatosCombos);
      }
      else {
        i_anterior = i;
        //UtilidadesLog.debug("Entro por en el primer periodo");
        dtoTiposSolicitud=new DTOTiposSolicitud();        
       
        dtoTiposSolicitud.setOidTipoSolicitud(objectToLong(resultado.getValueAt(i, "OID_TSP"))); 
        dtoTiposSolicitud.setTipoSolicitud((String)resultado.getValueAt(i, "TIPO_SOLICITUD")); 
        dtoTiposSolicitud.setOidMarca(objectToLong(resultado.getValueAt(i, "OID_MARCA")));
        dtoTiposSolicitud.setMarca((String)resultado.getValueAt(i, "MARCA"));
        dtoTiposSolicitud.setOidCanal(objectToLong(resultado.getValueAt(i, "OID_CANAL")));
        dtoTiposSolicitud.setCanal((String)resultado.getValueAt(i, "CANAL"));
        dtoTiposSolicitud.setOidAcceso(objectToLong(resultado.getValueAt(i, "OID_ACCESO")));
        dtoTiposSolicitud.setAcceso((String)resultado.getValueAt(i, "ACCESO"));
        dtoTiposSolicitud.setOidSubacceso(objectToLong(resultado.getValueAt(i, "OID_SUBACCESO")));
        dtoTiposSolicitud.setSubacceso((String)resultado.getValueAt(i, "SUBACCESO"));
        dtoTiposSolicitud.setOidMoneda(objectToLong(resultado.getValueAt(i, "OID_MONEDA")));
        dtoTiposSolicitud.setMoneda((String)resultado.getValueAt(i, "MONEDA"));
        dtoTiposSolicitud.setOidTipoCliente(objectToLong(resultado.getValueAt(i, "TIPO_CLIENTE")));
        
        /*Agrego por incidencia 14373*/
        dtoTiposSolicitud.setCodAcceso((String)resultado.getValueAt(i, "COD_ACCE"));

        //Creamos un DTODatosCombo[] de 1 periodo, porque es el primero y/o el unico
        dtoDatosCombos=new DTODatosCombo[1];
        //Seteo el primer periodo
        dtoDatosCombos[0]=new DTODatosCombo();
        dtoDatosCombos[0].setOid(objectToLong(resultado.getValueAt(i, "OID_PERIODO")));
        dtoDatosCombos[0].setDesc(resultado.getValueAt(i, "PERIODO").toString()); 
        //Añadimos el DTODatosCombo[1] al dtoTiposSolicitudes
        dtoTiposSolicitud.setPeriodos(dtoDatosCombos);
        
        dtoTiposSolicitudes[i] = dtoTiposSolicitud;  
      }
      
      ln_Anterior=objectToLong(resultado.getValueAt(i, "OID_TSP"));
    }
    UtilidadesLog.info("MONRegistroOnlineBean.crearDTOTiposSolicitud(RecordSet resultado): Salida ");
    return delNullArrayDTOTiposSolicitudes(dtoTiposSolicitudes);  //QUITAR POSICIONES EN NULL!!!
  }

  //Crea un DTODatosCombo por cada fila del RecordSet recibido y los devuelve
  private DTODatosCombo[]  crearDTODatosCombo(RecordSet resultado) throws MareException
  {
    UtilidadesLog.info("MONRegistroOnlineBean.crearDTODatosCombo(RecordSet resultado): Entrada ");
    DTODatosCombo[] colDTODatosCombo= new DTODatosCombo[resultado.getRowCount()];

    for(int i=0; i<resultado.getRowCount(); i++) {
      colDTODatosCombo[i] = new DTODatosCombo();
      colDTODatosCombo[i].setOid(objectToLong(resultado.getValueAt(i, 0)));
      colDTODatosCombo[i].setDesc((String)resultado.getValueAt(i, 1));      
    }        
    UtilidadesLog.info("MONRegistroOnlineBean.crearDTODatosCombo(RecordSet resultado): Salida ");
  
    return colDTODatosCombo;
  }

  // Obtiene los tipos de documentos del cliente
  private DTODatosCliente obtenerDocumentosCliente(DTODatosCliente dtoE) throws MareException
  {
    UtilidadesLog.info("MONRegistroOnlineBean.obtenerDocumentosCliente(DTODatosCliente dtoE): Entrada ");  
    DTOOID dtoOID=new DTOOID();
    DTOSalida tiposDocumento=null;
    MONConfiguracionClientesHome monConfiguracionClientesHome=null;
    MONConfiguracionClientes monConfiguracionClientes=null;
    RecordSet rs=null;
    RecordSet rs2=null;
    DTOTipoDocumento dtoTipoDocumento=null;
    List list=null;
    
    try {
      //UtilidadesLog.debug("Cliente: "+dtoE.getOidCliente());
      dtoOID.setOid(dtoE.getOidCliente());
      dtoOID.setOidIdioma(dtoE.getOidIdioma());
    
      monConfiguracionClientesHome=(MONConfiguracionClientesHome)UtilidadesEJB.getHome("MONConfiguracionClientes", MONConfiguracionClientesHome.class);
      monConfiguracionClientes=monConfiguracionClientesHome.create();
  
      tiposDocumento=monConfiguracionClientes.obtenerTiposDocumentoCliente(dtoOID);
      rs=tiposDocumento.getResultado();
      
      DTOTipoDocumento[] dtoTipos = new DTOTipoDocumento[rs.getRowCount()];
      
      for(int i=0; i<rs.getRowCount(); i++) {
        dtoOID=new DTOOID();
        dtoTipoDocumento=new DTOTipoDocumento();
        rs2=null;
        
        dtoOID.setOid(Long.valueOf(rs.getValueAt(i, 0).toString()));
        rs2=monConfiguracionClientes.obtenerTipoDocumentoLegal(dtoOID);
        
        dtoTipoDocumento.setOid(bigDecimalToLong((BigDecimal)rs.getValueAt(i, 0)));
        dtoTipoDocumento.setDesc((String)rs.getValueAt(i, 1));
        dtoTipoDocumento.setOidDocLegal(bigDecimalToLong((BigDecimal)rs2.getValueAt(i, 0)));
        dtoTipoDocumento.setDesDocLegal((String)rs2.getValueAt(i, 1));
        
        //Añade DTOTipoDocumento al array DTOE.tiposDocumento, (temporalmente en un ArrayList)
        dtoTipos[i] = dtoTipoDocumento;
      }
      dtoE.setTiposDocumento(dtoTipos);
    }
    catch (RemoteException rex) {
        UtilidadesLog.error("Error",rex);
        throw new MareException(rex,UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
    }
    catch (CreateException cex) {
        UtilidadesLog.error("Error",cex);
        throw new MareException(cex,UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
    }
    catch (Exception ex) { //ERROR NO DOCUMENTADO
        UtilidadesLog.error("Error",ex);
        throw new MareException(ex);
    }
    UtilidadesLog.info("MONRegistroOnlineBean.obtenerDocumentosCliente(DTODatosCliente dtoE): Salida ");  
    return dtoE;
  }
  
  private Long bigDecimalToLong(BigDecimal b){
      if (b == null)
        return null;
      return new Long(b.toString());
  }

  private BigDecimal calcularDeudaVencida(Long oidCliente, Long pais) throws MareException
  {
    UtilidadesLog.info("MONRegistroOnlineBean.calcularDeudaVencida(Long oidCliente, Long pais): Entrada ");
    DTOTotalyDias dtoTotalyDias=null;
    MONInterfaceModulos monInterfaceModulos=null;
    MONInterfaceModulosHome monInterfaceModulosHome=null;
    DTOSaldosPorDiasPeriodos dtoSaldosPorDiasPeriodos = new DTOSaldosPorDiasPeriodos();
 
    try {
      dtoSaldosPorDiasPeriodos.setOidCliente(oidCliente);
      dtoSaldosPorDiasPeriodos.setOidPais(pais);
      monInterfaceModulosHome=(MONInterfaceModulosHome)UtilidadesEJB.getHome("MONInterfaceModulos", MONInterfaceModulosHome.class);
      monInterfaceModulos=monInterfaceModulosHome.create();
      dtoTotalyDias = monInterfaceModulos.calcularDeudaVencidaCCCliente(dtoSaldosPorDiasPeriodos);
    }
    catch (RemoteException rex) {
        UtilidadesLog.error("Error",rex);
        throw new MareException(rex,UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
    }
    catch (CreateException cex) {
        UtilidadesLog.error("Error",cex);
        throw new MareException(cex,UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
    }
    catch (Exception ex) { //ERROR NO DOCUMENTADO
        UtilidadesLog.error("Error",ex);
        throw new MareException(ex);
    }      
    UtilidadesLog.info("MONRegistroOnlineBean.calcularDeudaVencida(Long oidCliente, Long pais): Salida ");
    //Modificado por Cristian Valenzuela
    //Fecha: 11/1/2006
    //INCIDENCIA: BELC300021635
    //return new BigDecimal(dtoTotalyDias.getNumeroDias().intValue());
    return new BigDecimal(dtoTotalyDias.getTotal().intValue());    
  }

  // Crea un DTODatosCliente a partir del RecordSet recibido
  private DTODatosCliente crearDTODatosCliente(RecordSet resultado, Long pais) throws MareException  {    
    UtilidadesLog.info("MONRegistroOnlineBean.crearDTODatosCliente(RecordSet resultado, Long pais): Entrada ");
    BigDecimal bd_sna;
    BigDecimal bd_dt;
    BigDecimal bd_c3;
    DAOSolicitud daoSolicitud=new DAOSolicitud();
    DTOSaldosPorFechasyVtos dtoSaldosPorFechasyVtos;
    DTOSaldosPorFechas dtoSaldosPorFechas;
    DTODatosCliente dtoDatosCliente;
    DTOTotal dtoTotal;
    MONInterfaceModulos monInterfaceModulos;
    MONInterfaceModulosHome monInterfaceModulosHome;
        
    try {
      // Calcula el número de solicitudes nuevas aprobadas pendientes de facturar 
      bd_sna=daoSolicitud.calcularMontoSolicitudesNuevas(objectToLong(resultado.getValueAt(0, "OID_CLIENTE")));
    
      // Calcula la deuda total
      dtoSaldosPorFechasyVtos=new DTOSaldosPorFechasyVtos();
      dtoSaldosPorFechasyVtos.setOidCliente(objectToLong(resultado.getValueAt(0, "OID_CLIENTE")));
      dtoSaldosPorFechasyVtos.setOidPais(pais);
        
      //IServiceCCC=MONInterfaceModulosHome
      monInterfaceModulosHome=(MONInterfaceModulosHome)UtilidadesEJB.getHome("MONInterfaceModulos", MONInterfaceModulosHome.class);
      monInterfaceModulos=monInterfaceModulosHome.create();
      
      dtoTotal=monInterfaceModulos.calcularSaldoCCCliente(dtoSaldosPorFechasyVtos);
      bd_dt=dtoTotal.getTotal();
      //UtilidadesLog.debug("BD_DT: "+bd_dt+" - "+bd_dt.getClass().getName());
    
      // Calcula el valor del cupón de trámite
      dtoSaldosPorFechas=new DTOSaldosPorFechas();
      dtoSaldosPorFechas.setOidCliente(objectToLong(resultado.getValueAt(0, "OID_CLIENTE")));
 
      dtoTotal=monInterfaceModulos.calcularCuponTramiteCliente(dtoSaldosPorFechas);
      bd_c3=dtoTotal.getTotal();
      //UtilidadesLog.debug("BD_C3: "+bd_c3+" - "+bd_c3.getClass().getName());
    
      //Crea un DTODatosCliente
      dtoDatosCliente=new DTODatosCliente();
      dtoDatosCliente.setOidCliente(objectToLong(resultado.getValueAt(0, "OID_CLIENTE")));
      dtoDatosCliente.setNombre((String)resultado.getValueAt(0, "NOMBRE"));
      dtoDatosCliente.setApellidos((String)resultado.getValueAt(0, "APELLIDOS"));
      dtoDatosCliente.setLineaCredito(objectToBigDecimal(resultado.getValueAt(0, "LINEA_CREDITO")));
      //UtilidadesLog.debug("Linea Credito: "+dtoDatosCliente.getLineaCredito());
      //UtilidadesLog.debug("BD_SNA: "+bd_sna);
      if (dtoDatosCliente.getLineaCredito()==null )
          dtoDatosCliente.setLineaCredito(new BigDecimal(0));
      if (bd_sna==null )
          bd_sna=new BigDecimal(0);
      if (bd_dt==null )
          bd_dt=new BigDecimal(0);
      if (bd_c3==null )
          bd_c3=new BigDecimal(0);
      dtoDatosCliente.setLineaDisp(dtoDatosCliente.getLineaCredito().subtract(bd_sna).subtract(bd_dt).add(bd_c3));
      dtoDatosCliente.setDeudaVencida(calcularDeudaVencida(objectToLong(resultado.getValueAt(0, "OID_CLIENTE")), pais));
      UtilidadesLog.info("MONRegistroOnlineBean.crearDTODatosCliente(RecordSet resultado, Long pais): Salida ");
      return dtoDatosCliente;
    }
    catch (RemoteException rex) {
        UtilidadesLog.error("Error",rex);
        throw new MareException(rex,UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
    }
    catch (CreateException cex) {
        UtilidadesLog.error("Error",cex);
        throw new MareException(cex,UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
    }    
    catch (Exception ex) { //ERROR NO DOCUMENTADO
        UtilidadesLog.error("Error",ex);
        throw new MareException(ex);
    }
  }

  /*
   * Autor: COrtaberría
   * Fecha: 20/05/2005
   * Se estaba completando en oidproducto en lugar de codProducto.
   */
  private DTOCabeceraSolicitud completarPosicionesSimulacionCuadre(DTOCabeceraSolicitud dtoe) throws MareException{
    UtilidadesLog.info("MONRegistroOnlineBean.completarPosicionesSimulacionCuadre(DTOCabeceraSolicitud dtoe): Entrada ");
    MaestroProductosLocalHome maestroProductosLocalHome = null;
    MaestroProductosLocal maestroProductosLocal = null;
    Entidadi18nLocalHome entidadI18nLocalHome = null;
    Entidadi18nLocal entidadI18nLocal = null;
    
    try{
    
      ArrayList posiciones = dtoe.getPosiciones();
      maestroProductosLocalHome = getMaestroProductosLocalHome();
      entidadI18nLocalHome = new Entidadi18nLocalHome();
    
      int pos=0;
    
      while(posiciones.size() > pos){
    
        DTOPosicionSolicitud posicionSolicitud = (DTOPosicionSolicitud)posiciones.get(pos);
        Long producto = getMONMantenimientoMFHome().create().buscarProductoCV(posicionSolicitud.getCodigoVenta(), dtoe.getPeriodo());
        UtilidadesLog.debug("Producto: "+producto);
        if (producto==null) throw new MareException("NO EXISTE EL PRODUCTO, ERROR GRAVE");
        // Completa el código y la descripción del producto 
        maestroProductosLocal = maestroProductosLocalHome.findByPrimaryKey(new MaestroProductosPK(producto)); 
        posicionSolicitud.setCodigoProducto(maestroProductosLocal.getCodigoSAP()); 
        posicionSolicitud.setDescripcionProducto(maestroProductosLocal.getDescripcionCorta());
      
        // Completa la descripción de la forma de pago 
        UtilidadesLog.debug("#############################################################");
        UtilidadesLog.debug("#############################################################");
        UtilidadesLog.debug("hace el find con: " + ConstantesBEL.BEL_FORMA_PAGO + " " + 1 + " " + dtoe.getOidIdioma() + " " + posicionSolicitud.getFormaPago()) ;
        UtilidadesLog.debug("#############################################################");
        UtilidadesLog.debug("#############################################################");
        entidadI18nLocal = entidadI18nLocalHome.findByEntAtrIdioPK(ConstantesBEL.BEL_FORMA_PAGO, new Long(1), dtoe.getOidIdioma(), posicionSolicitud.getFormaPago());
        posicionSolicitud.setDescripcionFormaPago(entidadI18nLocal.getDetalle());

        // Inserta la posición 
        posiciones.set(pos, posicionSolicitud);
      
        pos++;
     }
  
     dtoe.setPosiciones(posiciones); 
     UtilidadesLog.info("MONRegistroOnlineBean.completarPosicionesSimulacionCuadre(DTOCabeceraSolicitud dtoe): Salida ");
     return dtoe;
   
    } catch (NamingException nex) {
        ctx.setRollbackOnly();
        UtilidadesLog.error("Error",nex);
        throw new MareException(nex,UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));      
    } catch (FinderException fex) {  //NO EXISTE EL CLIENTE        
        ctx.setRollbackOnly();
        UtilidadesLog.error("Error",fex);
        throw new MareException(fex,UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE));      
    } catch (NoResultException nre) { // NO EXISTE DESCRIPCION I18N
        ctx.setRollbackOnly();
        UtilidadesLog.error("Error",nre);
        throw new MareException(nre,UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE));
    } catch (PersistenceException pe) { // ERROR DE PERSISTENCIA
        ctx.setRollbackOnly();
        UtilidadesLog.error("Error",pe);
        throw new MareException(pe,UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS));
    } catch (Exception ex) { //ERROR NO DOCUMENTADO
        ctx.setRollbackOnly();
        UtilidadesLog.error("Error",ex);
        throw new MareException(ex);
    } 
    
  }
  
    
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

  public DTODatosCliente  buscarDatosCliente(DTODatosCliente dtoE) throws MareException {
    UtilidadesLog.info("MONRegistroOnlineBean.buscarDatosCliente(DTODatosCliente dtoE): Entrada ");
    ClienteDatosBasicosLocalHome cdbLHome = null;
    ClienteDatosBasicosLocal cdbLocal = null;
    MONClientesHome monClieHome = null;
    MONClientes monClientes = null;
    RecordSet resultado = null;
    DTOOID direccion = null;
    DTOSalida tipoDireccionCliente = null;
    DAORegistroOnline daoRegistroOnline = null;
    DTODatosCliente dtoDatosCliente = null;
    
    try {
      cdbLHome = new ClienteDatosBasicosLocalHome();
      
      if(dtoE.getOidCliente() == null) {
        cdbLocal = cdbLHome.findByCodigoYPais(dtoE.getOidPais(), dtoE.getCodCliente());
      }
      else {
        cdbLocal = cdbLHome.findByPrimaryKey(dtoE.getOidCliente());
      }
      
      /*if (cdbLocal == null) {
        System.out.print("\ncdbLocal ES NULL!\n");        
      }
      else {
        System.out.print("cdbLocal NO ES NULL!\n___________________________-\n");
        System.out.print(cdbLocal.getOid());
      }*/
 
      dtoE.setOidCliente(cdbLocal.getOid());
      dtoE.setCodCliente(cdbLocal.getCod_clie());             
      
      // DATOS CLIENTE
      //daoRegistroOnline = new DAORegistroOnline(ctx.getCallerPrincipal().getName());
      daoRegistroOnline = new DAORegistroOnline(dtoE.getUserName());
      resultado = daoRegistroOnline.obtenerDatosCliente(dtoE.getOidPais(), dtoE.getCodCliente());
      dtoDatosCliente = crearDTODatosCliente(resultado, dtoE.getOidPais());
      dtoDatosCliente.setOidIdioma(dtoE.getOidIdioma());    
      // TIPO DOCUMENTO 
      dtoDatosCliente = obtenerDocumentosCliente(dtoDatosCliente);    
      
      // DIRECCION 
      direccion = new DTOOID();
      direccion.setOid(dtoDatosCliente.getOidCliente());
      direccion.setOidIdioma(dtoE.getOidIdioma());
      
      monClieHome = (MONClientesHome)UtilidadesEJB.getHome("MONClientes", MONClientesHome.class);
      monClientes = monClieHome.create();
      
      tipoDireccionCliente =  monClientes.obtenerTiposDireccionCliente(direccion);
      dtoDatosCliente.setDirecciones(crearDTODatosCombo(tipoDireccionCliente.getResultado()));      
      
      dtoDatosCliente.setCodCliente(cdbLocal.getCod_clie());
      //dtoDatosCliente.setoid
      UtilidadesLog.info("MONRegistroOnlineBean.buscarDatosCliente(DTODatosCliente dtoE): Salida ");
      return dtoDatosCliente;      
    }
    catch (NoResultException nre) {  //NO EXISTE EL CLIENTE        
        //Lanza una Excepción con código de error: PED-035
        ctx.setRollbackOnly();
        UtilidadesLog.error("Error",nre);
        throw new MareException(nre, UtilidadesError.armarCodigoError(ConstantesSEG.MODULO_PED, "", ErroresNegocio.PED_035));
    }
    catch (PersistenceException pe) {  //ERROR DE PERSISTENCIA
        ctx.setRollbackOnly();
        UtilidadesLog.error("Error",pe);
        throw new MareException(pe, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS));
    }
    catch (RemoteException rex) {
        ctx.setRollbackOnly();
        UtilidadesLog.error("Error",rex);
        throw new MareException(rex,UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
    }
    catch (CreateException cex) {
        ctx.setRollbackOnly();
        UtilidadesLog.error("Error",cex);
        throw new MareException(cex,UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
    }
    catch (Exception ex) { //ERROR NO DOCUMENTADO
        ctx.setRollbackOnly();
        UtilidadesLog.error("Error",ex);
        throw new MareException(ex);
    }    
  }
  
  //Valida que el código de venta recibido existe y es digitable en el periodo vigente 
  public DTOInfoProducto validarCodigoVenta(DTOInfoProducto dtoInfoProducto) throws MareException {
    UtilidadesLog.info("MONRegistroOnlineBean.validarCodigoVenta(DTOInfoProducto dtoInfoProducto): Entrada ");
    DTOEValidarCodigoVenta dtoEValidarCodigoVenta=null;
    DTOSValidarCodigoVenta dtoSValidarCodigoVenta=null;
    MONMantenimientoMFHome monMantenimientoMFHome=null;    
    MONMantenimientoMF monMantenimientoMF=null;    
    
    MaestroProductosLocalHome mpLocalHome = null;
		MaestroProductosLocal mpLocal = null;
    
    try {
      dtoEValidarCodigoVenta=new DTOEValidarCodigoVenta();
      dtoEValidarCodigoVenta.setPeriodo(dtoInfoProducto.getPeriodo());
      dtoEValidarCodigoVenta.setAcceso(dtoInfoProducto.getAcceso());
      dtoEValidarCodigoVenta.setSubacceso(dtoInfoProducto.getSubacceso());
      dtoEValidarCodigoVenta.setOidPais(dtoInfoProducto.getOidPais());
      dtoEValidarCodigoVenta.setOidIdioma(dtoInfoProducto.getOidIdioma());
      dtoEValidarCodigoVenta.setCodigoVenta(dtoInfoProducto.getCodigoVenta());

      monMantenimientoMFHome = (MONMantenimientoMFHome)UtilidadesEJB.getHome("MONMantenimientoMF", MONMantenimientoMFHome.class);
      monMantenimientoMF = monMantenimientoMFHome.create();
      
      dtoSValidarCodigoVenta=monMantenimientoMF.validarCodigoVenta(dtoEValidarCodigoVenta);  
  
      if(dtoSValidarCodigoVenta == null || Boolean.FALSE.equals(dtoSValidarCodigoVenta.getIndicadorDigitableGP())) {
        throw new MareException(new Exception(), UtilidadesError.armarCodigoError(ConstantesSEG.MODULO_PED, "", ErroresNegocio.PED_012));
        
      }
      else { // Obtenemos el código de producto y la descripción
        mpLocalHome=getMaestroProductosLocalHome();
        mpLocal = mpLocalHome.findByPrimaryKey(new MaestroProductosPK(dtoSValidarCodigoVenta.getProducto()));
                  
        dtoInfoProducto.setOidProducto(mpLocal.getOid()); 
        dtoInfoProducto.setCodigoProducto(mpLocal.getCodigoSAP()); 
        dtoInfoProducto.setDescripcionProducto(mpLocal.getDescripcionCorta());
      }
    }
    catch (NamingException nex) {
        UtilidadesLog.error("Error",nex);
        throw new MareException(nex,UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));      
    }
    catch (FinderException fex) {
        UtilidadesLog.error("Error",fex);
        throw new MareException(fex,UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE));      
    }
    catch (CreateException cex) {
        UtilidadesLog.error("Error",cex);
        throw new MareException(cex,UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
    }    
    catch(RemoteException rex) {
        UtilidadesLog.error("Error",rex);
        throw new MareException(rex,UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));    
    }
    catch (Exception ex) { //ERROR NO DOCUMENTADO
        UtilidadesLog.error("Error",ex);
        throw new MareException(ex);
    }    
    UtilidadesLog.info("MONRegistroOnlineBean.validarCodigoVenta(DTOInfoProducto dtoInfoProducto): Salida ");
    return dtoInfoProducto;
  }

  // Valida que el código de producto introducido se corresponda con algun código de venta existente 
   public DTOInfoProducto validarCodigoProducto(DTOInfoProducto dtoInfoProducto) throws MareException
  {
    UtilidadesLog.info("MONRegistroOnlineBean.validarCodigoProducto(DTOInfoProducto dtoInfoProducto): Entrada ");
    MaestroProductosLocalHome mpLocalHome = null;
		MaestroProductosLocal mpLocal = null;
    RelacionMCorpoMProduLocalHome relacionMCorpoMProduLocalHome = null;
    RelacionMCorpoMProduLocal relacionMCorpoMProduLocal = null;
    MONMantenimientoMFHome monMantenimientoMFHome=null;    
    MONMantenimientoMF monMantenimientoMF=null;
    DTOSalida dtoSalida = null;

    try {
      //UtilidadesLog.debug("validarCodigoProducto con DTO: " + dtoInfoProducto);
      // Valida la marca del producto
      mpLocalHome=getMaestroProductosLocalHome();
      mpLocal = mpLocalHome.findByUK(dtoInfoProducto.getOidPais(),dtoInfoProducto.getCodigoProducto());
      relacionMCorpoMProduLocalHome = new RelacionMCorpoMProduLocalHome();
      relacionMCorpoMProduLocal = relacionMCorpoMProduLocalHome.findByUk(dtoInfoProducto.getOidPais(), dtoInfoProducto.getOidMarca(), mpLocal.getMarcaProducto()); 
    }
    catch(Exception ex) {
      ctx.setRollbackOnly();
      UtilidadesLog.error("Error",ex);

      // dmorello, 28/08/2008 - Migracion a EJB 3.0
      // Dado que, originalmente, todas las excepciones se manejaban de la misma manera,
      // se decide manejar como caso aparte cualquier error de persistencia
      // excepto la no existencia del entity buscado (la cual se maneja como antes)
      if ( (ex instanceof PersistenceException) && ! (ex instanceof NoResultException) ) {
          throw new MareException(ex, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS));
      }
    
      //    Si existe error, lanzamos una ExcepcionParametrizable con código PED-037 
      //    "Producto no autorizado para la marca {0}". Pasando como parámetro el valor de DTOInfoProducto.descripcionMarca 
      
      ExcepcionParametrizada exParam = new ExcepcionParametrizada(ex, UtilidadesError.armarCodigoError(ConstantesSEG.MODULO_PED, "", ErroresNegocio.PED_037));
      exParam.setPosicion(ExcepcionParametrizada.POSICION_FINAL);
      exParam.addParameter(dtoInfoProducto.getDescripcionMarca());
      throw exParam;      
    }
    
    try {
     dtoInfoProducto.setOidProducto(mpLocal.getOid());
     monMantenimientoMFHome = (MONMantenimientoMFHome)UtilidadesEJB.getHome("MONMantenimientoMF", MONMantenimientoMFHome.class);
     monMantenimientoMF = monMantenimientoMFHome.create();     
     dtoSalida=monMantenimientoMF.obtenerCodigosVenta(dtoInfoProducto);
     if(dtoSalida != null) {
       dtoInfoProducto.setListaProductos(dtoSalida.getResultado());       
     }
     else {
        //Lanza una Excepción con código de error: PED-036
        throw new MareException(new Exception(), UtilidadesError.armarCodigoError(ConstantesSEG.MODULO_PED, "", ErroresNegocio.PED_036));
     }  
    }
    catch (CreateException cex) {
        UtilidadesLog.error("Error",cex);
        throw new MareException(cex,UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
    }    
    catch(RemoteException rex) {
        UtilidadesLog.error("Error",rex);
        throw new MareException(rex,UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));    
    }
    catch (Exception ex) { //ERROR NO DOCUMENTADO
        UtilidadesLog.error("Error",ex);
        throw new MareException(ex);
    }   
    UtilidadesLog.info("MONRegistroOnlineBean.validarCodigoProducto(DTOInfoProducto dtoInfoProducto): Salida ");
    return dtoInfoProducto;
  }

  // Obtiene información de gestión de stock asociada al producto 
  public DTOInfoProducto obtenerInfoGestionStock(DTOInfoProducto dtoInfoProducto) throws MareException
  {
  
    UtilidadesLog.info("MONRegistroOnlineBean.obtenerInfoGestionStock(DTOInfoProducto dtoInfoProducto): Entrada ");
    // Obtiene el límite de venta 
    dtoInfoProducto.setLimiteVenta(this.obtenerLimiteVenta(dtoInfoProducto.getPeriodo(), dtoInfoProducto.getCodigoVenta(), dtoInfoProducto.getOidCliente(), dtoInfoProducto.getOidZona()));
    
    // Obtiene el stock disponible 
    dtoInfoProducto.setControlStock(this.obtenerControlStock(dtoInfoProducto.getPeriodo(), dtoInfoProducto.getCodigoVenta(), dtoInfoProducto.getOidCliente(), dtoInfoProducto.getOidZona(), dtoInfoProducto.getUnidadesDemandadas()));
    
    // Obtiene el control de liquidación 
    dtoInfoProducto.setControlLiquidacion(this.obtenerControlLiquidacion(dtoInfoProducto.getPeriodo(), dtoInfoProducto.getCodigoVenta(), dtoInfoProducto.getOidCliente(), dtoInfoProducto.getOidZona()));
      
    // Obtiene las unidades disponibles a reservar 
    dtoInfoProducto = this.obtenerUnidadesDisponibles(dtoInfoProducto);

    UtilidadesLog.info("MONRegistroOnlineBean.obtenerInfoGestionStock(DTOInfoProducto dtoInfoProducto): Salida ");
    return dtoInfoProducto;     
  }

  // Graba una solicitud
  public DTOCabeceraSolicitud grabarSolicitud(DTOCabeceraSolicitud dtoCabeceraSolicitud) throws MareException
  {
    UtilidadesLog.info("MONRegistroOnlineBean.grabarSolicitud(DTOCabeceraSolicitud dtoCabeceraSolicitud): Entrada ");
    MONDigitacionInicialHome monDigitacionInicialHome = null;
    MONDigitacionInicial monDigitacionInicial = null;
    RecordSet resultado=null;
    DAOGruposProceso daoGruposProceso = null;

    try {
      // Primero obtenemos el último proceso parametrizado para el tipo de solicitud y GP1 
      daoGruposProceso = new DAOGruposProceso();
      dtoCabeceraSolicitud.setProceso(daoGruposProceso.obtenerUltimoProcesoGP(ConstantesPED.GP1, dtoCabeceraSolicitud.getTipoSolicitud()));
      
      // A continuación guardamos la solicitud
      monDigitacionInicialHome = (MONDigitacionInicialHome)UtilidadesEJB.getHome("MONDigitacionInicial", MONDigitacionInicialHome.class);
      monDigitacionInicial = monDigitacionInicialHome.create();

      dtoCabeceraSolicitud = monDigitacionInicial.grabarSolicitud(dtoCabeceraSolicitud);
    }
    catch (MareException mex) {
        UtilidadesLog.error("Error",mex);
        throw new MareException(mex,UtilidadesError.armarCodigoError(CodigosError.ERROR_NO_IND_IMPUESTO));
    }
    catch (CreateException cex) {
        UtilidadesLog.error("Error",cex);
        throw new MareException(cex,UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
    }
    catch(RemoteException rex) {
        UtilidadesLog.error("Error",rex);
        throw new MareException(rex,UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));    
    }
    catch (Exception ex) { //ERROR NO DOCUMENTADO
        UtilidadesLog.error("Error",ex);
        throw new MareException(ex);
    }    
    UtilidadesLog.info("MONRegistroOnlineBean.grabarSolicitud(DTOCabeceraSolicitud dtoCabeceraSolicitud): Salida ");
    return dtoCabeceraSolicitud;
  }

  public DTOSalida buscarProductosAlternativos(DTOInfoProducto dtoE) throws MareException
  {
    UtilidadesLog.info("MONRegistroOnlineBean.buscarProductosAlternativos(DTOInfoProducto dtoE): Entrada ");
    MONMantenimientoMFHome monMantenimientoMFHome=null;    
    MONMantenimientoMF monMantenimientoMF=null;       
    DTOSalida dtoSalida=null;
     
    try {
      monMantenimientoMFHome = (MONMantenimientoMFHome)UtilidadesEJB.getHome("MONMantenimientoMF", MONMantenimientoMFHome.class);
      monMantenimientoMF = monMantenimientoMFHome.create();     
      dtoSalida=monMantenimientoMF.obtenerProductosAlternativos(dtoE.getPeriodo(),dtoE.getCodigoVenta());  
      
      if(dtoSalida == null) {
        //Lanza una Excepción con error PED-038
        throw new MareException(new Exception(), UtilidadesError.armarCodigoError(ConstantesSEG.MODULO_PED, "", ErroresNegocio.PED_038));
      }
    }
    catch (CreateException cex) {
        UtilidadesLog.error("Error",cex);
        throw new MareException(cex,UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
    }    
    catch(RemoteException rex) {
        UtilidadesLog.error("Error",rex);
        throw new MareException(rex,UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));    
    }
    catch (Exception ex) { //ERROR NO DOCUMENTADO
        UtilidadesLog.error("Error",ex);
        throw new MareException(ex);
    } 
    UtilidadesLog.info("MONRegistroOnlineBean.buscarProductosAlternativos(DTOInfoProducto dtoE): Salida ");
    return dtoSalida;
  }

  // Carga inicial de la página de registro on line. 
  // Incluye la carga de los valores por defecto 
  public DTOCargaRegistroOnline obtenerCargaInicial(DTOCargaRegistroOnline dtoOut) throws MareException
  {
    UtilidadesLog.info("MONRegistroOnlineBean.obtenerCargaInicial(DTOCargaRegistroOnline dtoOut): Entrada ");  
    DTOBelcorp dtoBelcorp = new DTOBelcorp();
    AsociacionMaquinaCajaLocalHome asociacionMaquinaCajaLocalHome = null;
    AsociacionMaquinaCajaLocal asociacionMaquinaCajaLocal = null;
    CajaLocalHome cajaLocalHome = null;
    CajaLocal cajaLocal = null;
    Entidadi18nLocalHome entidadi18nLocalHome = null;
    Entidadi18nLocal entidadi18nLocal = null;
    HashMap propiedades = null;
    String uName = dtoOut.getUserName();
    DAODigitacion daoDigitacion = null;
    RecordSet resultado = null;
    //DAORegistroOnline daoRegistroOnline = new DAORegistroOnline(ctx.getCallerPrincipal().getName());
    
    DAORegistroOnline daoRegistroOnline = new DAORegistroOnline(uName);
    MONGestionFormasPagoDetalleHome monGestionFormasPagoDetalleHome;
    MONGestionFormasPagoDetalle monGestionFormasPagoDetalle;
        
    try {
      dtoOut.setTamanioPagina(this.obtenerTamanioPagina(dtoOut.getCodUsuario()));
      
      entidadi18nLocalHome= new Entidadi18nLocalHome();
    
      dtoBelcorp.setOidPais(dtoOut.getOidPais());
      dtoBelcorp.setOidIdioma(dtoOut.getOidIdioma());
      
      // SUBACCESO 
      if(Boolean.TRUE.equals(dtoOut.isBelcenter())) {
        // Recupero el subacceso asociado al IP del usuario 
        asociacionMaquinaCajaLocalHome= new AsociacionMaquinaCajaLocalHome();
        asociacionMaquinaCajaLocal=asociacionMaquinaCajaLocalHome.findByUK(dtoOut.getIP());
                
        cajaLocalHome = new CajaLocalHome();
        cajaLocal=cajaLocalHome.findByPrimaryKey(asociacionMaquinaCajaLocal.getOidCaja());
        
        dtoOut.setOidSubAcceso(cajaLocal.getSubAcceso());     
 
        entidadi18nLocal=entidadi18nLocalHome.findByEntAtrIdioPK(ConstantesSEG.SEG_SUBAC, new Long(1), dtoOut.getOidIdioma(), dtoOut.getOidSubAcceso());
        
        dtoOut.setTxtsubAcceso(entidadi18nLocal.getDetalle());        
      }else {
        // Recupero el subacceso asociado al usuario        
        //uName = ctx.getCallerPrincipal().getName();
        try{
            propiedades = this.getProperties(new UserIDImpl(dtoOut.getCodUsuario()));
            //propiedades = mguMon.getProperties(new UserIDImpl(uName));
            
            Property property = (Property)propiedades.get(ConstantesPED.SUBACCESO_DEFECTO);
            String subacceso = (String)property.getValue();
            UtilidadesLog.debug(subacceso);
            dtoOut.setOidSubAcceso(new Long(subacceso));//objectToLong(propiedades.get(ConstantesPED.SUBACCESO_DEFECTO)));
        }catch(Exception e){
            UtilidadesLog.error("Error al obtener el subacceso");
        }
        try{
            entidadi18nLocal = entidadi18nLocalHome.findByEntAtrIdioPK(ConstantesSEG.SEG_SUBAC, new Long(1), dtoOut.getOidIdioma(), dtoOut.getOidSubAcceso());
            dtoOut.setTxtsubAcceso(entidadi18nLocal.getDetalle());
        }catch(Exception e){
            UtilidadesLog.error("No se seteo el Subacceso");
        }               
        dtoOut.setOidAcceso(objectToLong(propiedades.get(ConstantesPED.ACCESO_DEFECTO)));
        try{
            entidadi18nLocal = entidadi18nLocalHome.findByEntAtrIdioPK(ConstantesSEG.SEG_ACCES, new Long(1), dtoOut.getOidIdioma(), dtoOut.getOidAcceso()); 
            dtoOut.setTxtAcceso(entidadi18nLocal.getDetalle());
        }catch(Exception e){
            UtilidadesLog.error("No se seteo el Acceso");
        } 
             
        dtoOut.setOidCanal(objectToLong(propiedades.get(ConstantesPED.CANAL_DEFECTO)));
        try{
            entidadi18nLocal = entidadi18nLocalHome.findByEntAtrIdioPK(ConstantesSEG.SEG_CANAL, new Long(1), dtoOut.getOidIdioma(), dtoOut.getOidCanal()); 
            dtoOut.setTxtCanal(entidadi18nLocal.getDetalle());
        }catch(Exception e){
            UtilidadesLog.error("No se seteo el Canal");
        }
      }
      // ACCESO FISICO
      daoDigitacion = new DAODigitacion();
      resultado = daoDigitacion.obtenerAccesoFisico(dtoBelcorp);
      dtoOut.setAccesosFisico(crearDTODatosCombo(resultado)); 
      
      // TIPO DESPACHO 
      resultado = daoDigitacion.obtenerTipoDespacho(dtoBelcorp);
      dtoOut.setTiposDespacho(crearDTODatosCombo(resultado));   
 
      // FORMA PAGO MONGestionFormasPagoDetalle
      monGestionFormasPagoDetalleHome=(MONGestionFormasPagoDetalleHome)UtilidadesEJB.getHome("MONGestionFormasPagoDetalle", MONGestionFormasPagoDetalleHome.class);
      monGestionFormasPagoDetalle=monGestionFormasPagoDetalleHome.create();
    
      resultado = monGestionFormasPagoDetalle.obtenerFormasPagoPorPais(dtoBelcorp); 
      dtoOut.setFormasPago(crearDTODatosCombo(resultado));
    
      // TIPOS SOLICITUD 
      resultado = daoRegistroOnline.obtenerTiposSolicitud(dtoOut.getOidPais(), dtoOut.getOidIdioma(), dtoOut.getOidSubAcceso(), dtoOut.isBelcenter());
      dtoOut.setTiposSolicitud(crearDTOTiposSolicitud(resultado));
     
      // VALORES POR DEFECTO 
      dtoOut.setValoreDefecto(null);
          
      // DATOS CLIENTE 
      /*if(dtoOut.getDatosCliente() != null) { 
        dtoOut.getDatosCliente().setOidPais(dtoOut.getOidPais());
        dtoOut.setDatosCliente(buscarDatosCliente(dtoOut.getDatosCliente()));
      }*/
      
      // 18/07/2007 cdos gPineda
      // FECHA DEL SISTEMA
      dtoOut.setFechaFacturacion( new java.util.Date() );
    }
    catch (NoResultException nre) {
      ctx.setRollbackOnly();
      UtilidadesLog.error("Error",nre);
      throw new MareException(nre,UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE));
    }
    catch (PersistenceException pe) {
      ctx.setRollbackOnly();
      UtilidadesLog.error("Error",pe);
      throw new MareException(pe,UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS));
    }
    catch (Exception ex) { //ERROR NO DOCUMENTADO
        ctx.setRollbackOnly();
        UtilidadesLog.error("Error",ex);
        throw new MareException(ex);
    }  
    UtilidadesLog.info("MONRegistroOnlineBean.obtenerCargaInicial(DTOCargaRegistroOnline dtoOut): Salida ");  
    return dtoOut;
  }
  
  public DTOSalida obtenerSolicitudesAnteriores(DTOSolicitudesAnteriores dto) throws MareException{
        UtilidadesLog.info("MONRegistroOnlineBean.obtenerSolicitudesAnteriores(DTOSolicitudesAnteriores dto): Entrada ");
      DTOSalida dtoS = new DTOSalida();
      DAOSolicitud dao = new DAOSolicitud();
      dtoS.setResultado(dao.obtenerSolicitudesAnteriores(dto));
        UtilidadesLog.info("MONRegistroOnlineBean.obtenerSolicitudesAnteriores(DTOSolicitudesAnteriores dto): Salida ");
      return dtoS;
  }
  
    /**
    *Crear un DTOCargaPantallaBusqueda dtoCarga 
    // CATALOGO 
    resultado = IServiceOfertas.cargarCatalogos(DTOBelcorp) 
    dtoCarga.catalogos = crearDTODatosCombo(resultado) 
    
    // LINEA PRODUCTO 
    DTOSalida = IMateriales.obtenerLineasProductoPorPais(DTOBelcorp) 
    dtoCarga.lineasProducto = crearDTODatosCombo(DTOSalida.resultado) 
    
    Devuelve dtoCarga
    * @throws es.indra.mare.common.exception.MareException
    * @return DTOCargaPantallaBusqueda
    * @autor jpbosnja
    * @param DTOBelcorp
    */
    public DTOCargaPantallaBusqueda obtenerCargaBusquedaProductos(DTOBelcorp dtoe) throws MareException{
        UtilidadesLog.info("MONRegistroOnlineBean.obtenerCargaBusquedaProductos(DTOBelcorp dtoe): Entrada ");
        DTOCargaPantallaBusqueda dtoS = new DTOCargaPantallaBusqueda();
        try{
            PREConsultas pre = new PREConsultas();
            dtoS.setCatalogos(this.crearDTODatosCombo(pre.cargarCatalogos(dtoe).getResultado()));
            dtoS.setLineasProducto(this.crearDTODatosCombo(this.getMONProductosHome().create().obtenerLineasProductoPorPais(dtoe).getResultado()));
        }catch (NamingException nex) {
          UtilidadesLog.error(nex);
          throw new MareException(nex,UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));      
        }
        catch (Exception ex) { //ERROR NO DOCUMENTADO
            UtilidadesLog.error("Error",ex);
            throw new MareException(ex);
        } 
        UtilidadesLog.info("MONRegistroOnlineBean.obtenerCargaBusquedaProductos(DTOBelcorp dtoe): Salida ");
        return dtoS;
    }
    
    /**
    *DTOSalida = Llama al método IServiceMF.buscarProductosRegistro(DTOE) 
    Devuelve DTOSalida
    
    * @throws es.indra.mare.common.exception.MareException
    * @return DTOSalida
    * @autor jpbosnja
    * @param DTOBuscarProductosRegistro
    */
    public DTOSalida buscarProductosRegistro(DTOBuscarProductosRegistro dtoe) throws MareException{
        UtilidadesLog.info("MONRegistroOnlineBean.buscarProductosRegistro(DTOBuscarProductosRegistro dtoe): Entrada ");
        DTOSalida dtoS = new DTOSalida();

        try{
            
            dtoS = getMONMantenimientoMFHome().create().buscarProductosRegistro(dtoe);
        }catch (NamingException nex) {
          UtilidadesLog.error("Error",nex);
          throw new MareException(nex,UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));      
        }
        catch (Exception ex) { //ERROR NO DOCUMENTADO
            UtilidadesLog.error("Error",ex);
            throw new MareException(ex);
        }
        UtilidadesLog.info("MONRegistroOnlineBean.buscarProductosRegistro(DTOBuscarProductosRegistro dtoe): Salida ");
        return dtoS;        
    }
  
  /**
    *Crea un DTOMovimientoAlmacenCabecera con: 
    - pais: DTOE.pais 
    - numeroDocumento: null 
    - oidTipoMovimientoAlmacen: null 
    - fecha: Fecha del sistema 
    - oidAlmacenSalida: null 
    - oidAlmacenEntrada: null 
    - oidMarca: DTOE.marca 
    - oidCanal: DTOE.canal 
    - oidAcceso: DTOE.acceso 
    - oidSubacceso: DTOE.subacceso 
    - oidPeriodo: DTOE.periodo 
    - observaciones: DTOE.observaciones 
    - indicadorNoGenerarCabecera: noGenerarCabecera 
    
    Devuelve DTOMovimientoAlmacenCabecera
    
    * @throws es.indra.mare.common.exception.MareException
    * @return DTOSalida
    * @autor jpbosnja
    * @param DTOBuscarProductosRegistro
    */
    private DTOMovimientoAlmacenCabecera crearDTOMovimientoAlmacenCabecera (DTOCabeceraSolicitud dtoe, Boolean noGenerarCabecera){
        UtilidadesLog.info("MONRegistroOnlineBean.crearDTOMovimientoAlmacenCabecera (DTOCabeceraSolicitud dtoe, Boolean noGenerarCabecera): Entrada ");
        DTOMovimientoAlmacenCabecera dtoS = new DTOMovimientoAlmacenCabecera();
        
        dtoS.setOidIdioma(dtoe.getOidIdioma());
        
        dtoS.setOidPais(dtoe.getOidPais());
        dtoS.setFecha(new java.util.Date(System.currentTimeMillis()));
        dtoS.setOidMarca(dtoe.getMarca());
        dtoS.setOidCanal(dtoe.getCanal());
        dtoS.setOidAcceso(dtoe.getAcceso());
        dtoS.setOidSubacceso(dtoe.getSubacceso());
        dtoS.setOidPeriodo(dtoe.getPeriodo());
        dtoS.setObservaciones(dtoe.getObservaciones());
        dtoS.setIndicadorNoGenerarCabecera(noGenerarCabecera);
        UtilidadesLog.info("MONRegistroOnlineBean.crearDTOMovimientoAlmacenCabecera (DTOCabeceraSolicitud dtoe, Boolean noGenerarCabecera): Salida ");
        return dtoS;
    }

  public DTOSalida obtenerFlete(DTOPresentarFlete dtoe) throws MareException
  {
    UtilidadesLog.info("MONRegistroOnlineBean.obtenerFlete(DTOPresentarFlete dtoe): Entrada ");
    UtilidadesLog.debug("Entro con DTOPresentarFlete " + dtoe);
    UtilidadesLog.debug("dtoe.oidPais == " + dtoe.getOidPais());
    
    PaisLocalHome paisLocalHome=null;
    PaisLocal paisLocal=null;
    DTOSalida dtoSalida=new DTOSalida();
    DAOSolicitud daoSolicitud=new DAOSolicitud();

    try {
      // Obtenemos al ambito de la aplicación
      paisLocalHome = new PaisLocalHome();       
      paisLocal=paisLocalHome.findByPrimaryKey(dtoe.getOidPais());
      
      UtilidadesLog.debug("paisLocal.getInd_flet_zona_ubig() == "
                            + paisLocal.getInd_flet_zona_ubig());
      
      // DBLG400000406 - dmorello, 21/02/2006: Cambio == por método equals
      if(ConstantesPED.FLETE_ZONA.equals(paisLocal.getInd_flet_zona_ubig())) {
        dtoe.setFleteZona(Boolean.TRUE);
      } 
      else { 
        dtoe.setFleteZona(Boolean.FALSE); 
      }
      // Obtenemos el flete a mostrar
      dtoSalida.setResultado(daoSolicitud.obtenerFlete(dtoe));
    }
    catch (NoResultException nre) {
      ctx.setRollbackOnly();
      UtilidadesLog.error("Error",nre);
      throw new MareException(nre,UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE));      
    }
    catch (PersistenceException pe) {
      ctx.setRollbackOnly();
      UtilidadesLog.error("Error",pe);
      throw new MareException(pe,UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS));
    }
    catch (Exception ex) { //ERROR NO DOCUMENTADO
        ctx.setRollbackOnly();
        UtilidadesLog.error("Error",ex);
        throw new MareException(ex);
    }
    UtilidadesLog.info("MONRegistroOnlineBean.obtenerFlete(DTOPresentarFlete dtoe): Salida ");
    return dtoSalida;
  }

  // Realiza la reserva de almacén para la última posición de la solicitud recibida 
  public DTOGenerarPosicionRegistro reservarAlmacen(DTOGenerarPosicionRegistro dtoe) throws MareException
  {
    UtilidadesLog.info("MONRegistroOnlineBean.reservarAlmacen(DTOGenerarPosicionRegistro dtoe): Entrada ");
    int numeroPosiciones;
    DTOPosicionSolicitud posicionSolicitud=null;
    Boolean noGenerarCabecera=Boolean.FALSE;
    DTOReportePedidos dtoReportePedidos=null;
    DTOMovimientoAlmacen movimientoAlmacen=null;
    MONGenerarMovimientoAlmacenHome monGenerarMovimientoAlmacenHome=null;
    MONGenerarMovimientoAlmacen monGenerarMovimientoAlmacen=null; 
    DTOMovimientoAlmacenDetalle detalleAlmacen=null;
  
    try {
      // Genera el número de la solicitud
      if(dtoe.getCabeceraSolicitud().getNumeroSolicitud() == null) {
         dtoe.setCabeceraSolicitud(generarNumeroSolicitud(dtoe.getCabeceraSolicitud()));
      }
      
      numeroPosiciones=dtoe.getCabeceraSolicitud().getPosiciones().size();
      if(numeroPosiciones > 1) {
        noGenerarCabecera = Boolean.TRUE;
      }
  
      // Recupera la última posición de la solicitud 
      posicionSolicitud = (DTOPosicionSolicitud)dtoe.getCabeceraSolicitud().getPosiciones().get(numeroPosiciones -1);
      
      // Crea el DTOMovimientoAlmacen
      movimientoAlmacen = crearDTOMovimientoAlmacen(dtoe.getCabeceraSolicitud(), posicionSolicitud, noGenerarCabecera, dtoe.getCantidadReservar(), dtoe.getNumeroMovimiento());
      
      // Solicita la reserva de almacén 
      monGenerarMovimientoAlmacenHome=(MONGenerarMovimientoAlmacenHome)UtilidadesEJB.getHome("MONGenerarMovimientoAlmacen", MONGenerarMovimientoAlmacenHome.class);
      monGenerarMovimientoAlmacen=monGenerarMovimientoAlmacenHome.create();    
      dtoReportePedidos = monGenerarMovimientoAlmacen.grabarMovimientoAlmacenYStock(movimientoAlmacen);
      
      if(dtoReportePedidos.getLineasDetalle().size()>0) {
        // Actualiza la posición de la solicitud con el detalle de almacén recuperado 
        detalleAlmacen = (DTOMovimientoAlmacenDetalle)dtoReportePedidos.getLineasDetalle().get(0);  
        if(detalleAlmacen.getMovimientoOk() == Boolean.FALSE) {
          dtoe.setCantidadReservar(detalleAlmacen.getCantidad()); 
        }
      }
      else {
        return new DTOGenerarPosicionRegistro();
      }
      
      posicionSolicitud.setUnidadesPorAtender(detalleAlmacen.getCantidad());
      posicionSolicitud.setUnidadesComprometidas(detalleAlmacen.getCantidad());
      
      if(0 < dtoe.getControlStock().intValue() && dtoe.getControlStock().longValue() > dtoe.getCantidadReservar().longValue()) { 
        posicionSolicitud.setUnidadesDemandaReal(dtoe.getCantidadReservar()); 
      } 
      else { 
        posicionSolicitud.setUnidadesDemandaReal(posicionSolicitud.getUnidadesDemandadas());
      } 
      
      // Actualiza la posición dentro de la solicitud
      dtoe.getCabeceraSolicitud().getPosiciones().set(numeroPosiciones-1, (Object)posicionSolicitud);
    }
    catch (CreateException cex) {
        UtilidadesLog.error("Error",cex);
        throw new MareException(cex,UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
    }    
    catch(RemoteException rex) {
        UtilidadesLog.error("Error",rex);
        throw new MareException(rex,UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));    
    }
    catch (Exception ex) { //ERROR NO DOCUMENTADO
        UtilidadesLog.error("Error",ex);
        throw new MareException(ex);
    }   
    UtilidadesLog.info("MONRegistroOnlineBean.reservarAlmacen(DTOGenerarPosicionRegistro dtoe): Salida ");
    return dtoe;
  }

  public DTOMovimientoAlmacen crearDTOMovimientoAlmacen(DTOCabeceraSolicitud cabeceraSolicitud, DTOPosicionSolicitud posicionSolicitud, Boolean noGenerarCabecera, Long cantidadReservar, String numeroMovimiento) throws MareException
  {
    //CREAMOS UN DTOMovimientoAlmacen
    UtilidadesLog.info("MONRegistroOnlineBean.crearDTOMovimientoAlmacen(DTOCabeceraSolicitud cabeceraSolicitud, DTOPosicionSolicitud posicionSolicitud, Boolean noGenerarCabecera, Long cantidadReservar, String numeroMovimiento): Entrada ");
    DTOMovimientoAlmacen dtoMovimientoAlmacen=new DTOMovimientoAlmacen();
    
    //SETEAMOS LA CABECERA
    dtoMovimientoAlmacen.setCabecera(crearDTOMovimientoAlmacenCabecera(cabeceraSolicitud, noGenerarCabecera));
    
    /** VER INC BELC300013379 **/
    //SETEAMOS EL DETALLE
    ArrayList array=new ArrayList();
    array.add(crearDTOMovimientoAlmacenDetalle(cabeceraSolicitud, posicionSolicitud, cantidadReservar, numeroMovimiento));
    dtoMovimientoAlmacen.setDetalle(array);
    UtilidadesLog.info("MONRegistroOnlineBean.crearDTOMovimientoAlmacen(DTOCabeceraSolicitud cabeceraSolicitud, DTOPosicionSolicitud posicionSolicitud, Boolean noGenerarCabecera, Long cantidadReservar, String numeroMovimiento): Salida ");
    return dtoMovimientoAlmacen;
  }

  // Obtiene el movimiento de reserva de stock asociado al tipo de solicitud 
  public DTOMovimientoAlmacenDetalle  crearDTOMovimientoAlmacenDetalle(DTOCabeceraSolicitud cabeceraSolicitud, DTOPosicionSolicitud posicionSolicitud, Long cantidadReservar, String numeroMovimiento) throws MareException
  {
    UtilidadesLog.info("MONRegistroOnlineBean.crearDTOMovimientoAlmacenDetalle(DTOCabeceraSolicitud cabeceraSolicitud, DTOPosicionSolicitud posicionSolicitud, Long cantidadReservar, String numeroMovimiento): Entrada ");
    TiposSolicitudPaisLocalHome tipoSolicitudPaisLocalHome=null;
    TiposSolicitudPaisLocal tipoSolicitudPaisLocal=null;
    Long movimientoReservaStock;
    Long tipoOferta=new Long(0);
    DTOMovimientoAlmacenDetalle dtoMovimientoAlmacenDetalle=new DTOMovimientoAlmacenDetalle();
        
    try {
      tipoSolicitudPaisLocalHome= new TiposSolicitudPaisLocalHome();      
      tipoSolicitudPaisLocal=tipoSolicitudPaisLocalHome.findByPrimaryKey(cabeceraSolicitud.getTipoSolicitud());
      
      movimientoReservaStock = tipoSolicitudPaisLocal.getOidTipoMovReserva();
      // Obtiene el tipo de oferta 
      if(posicionSolicitud.getCodigoVenta() != null) {
        tipoOferta = obtenerTipoOferta(cabeceraSolicitud, posicionSolicitud.getCodigoVenta());
      }
      
      //Crea un DTOMovimientoAlmacenDetalle
      dtoMovimientoAlmacenDetalle.setOidPais(cabeceraSolicitud.getOidPais());
      dtoMovimientoAlmacenDetalle.setOidCanal(cabeceraSolicitud.getCanal());
      dtoMovimientoAlmacenDetalle.setOidAcceso(cabeceraSolicitud.getAcceso());
      dtoMovimientoAlmacenDetalle.setOidSubacceso(cabeceraSolicitud.getSubacceso());
      dtoMovimientoAlmacenDetalle.setNumeroMovimiento(numeroMovimiento);
      dtoMovimientoAlmacenDetalle.setOidTipoMovimientoAlmacen(movimientoReservaStock);
      dtoMovimientoAlmacenDetalle.setOidAlmacenSalida(cabeceraSolicitud.getAlmacen());
      dtoMovimientoAlmacenDetalle.setOidAlmacenEntrada(null);
      dtoMovimientoAlmacenDetalle.setOidProducto(posicionSolicitud.getProducto());
      dtoMovimientoAlmacenDetalle.setCantidad(cantidadReservar);
      dtoMovimientoAlmacenDetalle.setPrecioVentaNeto(new BigDecimal(0));
      dtoMovimientoAlmacenDetalle.setPrecioContable(new BigDecimal(0));
      dtoMovimientoAlmacenDetalle.setObservaciones(null);
      dtoMovimientoAlmacenDetalle.setNumeroPosicionReferencia(LongToInteger(posicionSolicitud.getNumeroPosicion()));
      dtoMovimientoAlmacenDetalle.setNumeroDocumentoReferencia(new Long(cabeceraSolicitud.getNumeroSolicitud()));
      dtoMovimientoAlmacenDetalle.setOperacion(ConstantesBEL.COD_PED001);
      dtoMovimientoAlmacenDetalle.setOidTipoOferta(tipoOferta);
    }
    catch (NoResultException nre) {
      ctx.setRollbackOnly();
      UtilidadesLog.error("Error",nre);
      throw new MareException(nre,UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE));      
    }
    catch (PersistenceException pe) {
      ctx.setRollbackOnly();
      UtilidadesLog.error("Error",pe);
      throw new MareException(pe,UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS));      
    }
    catch (Exception ex) { //ERROR NO DOCUMENTADO
        ctx.setRollbackOnly();
        UtilidadesLog.error("Error",ex);
        throw new MareException(ex);
    }    
    
    UtilidadesLog.info("MONRegistroOnlineBean.crearDTOMovimientoAlmacenDetalle(DTOCabeceraSolicitud cabeceraSolicitud, DTOPosicionSolicitud posicionSolicitud, Long cantidadReservar, String numeroMovimiento): Salida ");
    return dtoMovimientoAlmacenDetalle;
  }

  // Genera la última posición de la solicitud pero no la guarda en BD 
  public DTOCabeceraSolicitud generarPosicion(DTOGenerarPosicionRegistro dtoe) throws MareException
  {
    UtilidadesLog.info("MONRegistroOnlineBean.generarPosicion(DTOGenerarPosicionRegistro dtoe): Entrada ");
    UtilidadesLog.debug("Entro con DTOGenerarPosicionRegistro: " + dtoe);
    
    MONGenerarPosicionSolicitudHome monGenerarPosicionSolicitudHome=null;
    MONGenerarPosicionSolicitud monGenerarPosicionSolicitud=null;
    DTOCabeceraSolicitud cabeceraSolicitud=null;
  
    try {    
      if (dtoe.getCabeceraSolicitud()!=null && dtoe.getCabeceraSolicitud().getPosiciones()!=null &&
          dtoe.getCabeceraSolicitud().getPosiciones().size()>0){
          int posicion=dtoe.getCabeceraSolicitud().getPosiciones().size()-1;

          monGenerarPosicionSolicitudHome=(MONGenerarPosicionSolicitudHome)UtilidadesEJB.getHome("MONGenerarPosicionSolicitud", MONGenerarPosicionSolicitudHome.class);
          monGenerarPosicionSolicitud=monGenerarPosicionSolicitudHome.create();
    
          cabeceraSolicitud = monGenerarPosicionSolicitud.generarPosicion(dtoe.getCabeceraSolicitud(), new Long(posicion), Boolean.FALSE);
      }
    }
    catch (CreateException cex) {
        UtilidadesLog.error("Error",cex);
        throw new MareException(cex,UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
    }    
    catch(RemoteException rex) {
        UtilidadesLog.error("Error",rex);
        throw new MareException(rex,UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));    
    }
    catch (Exception ex) { //ERROR NO DOCUMENTADO
        UtilidadesLog.error("Error",ex);
        throw new MareException(ex);
    }     
    UtilidadesLog.info("MONRegistroOnlineBean.generarPosicion(DTOGenerarPosicionRegistro dtoe): Salida ");
    return cabeceraSolicitud;
  }

  public Long obtenerTipoOferta(DTOCabeceraSolicitud cabeceraSolicitud, String cv) throws MareException
  {
    UtilidadesLog.info("MONRegistroOnlineBean.obtenerTipoOferta(DTOCabeceraSolicitud cabeceraSolicitud, String cv): Entrada ");
    DTOEValidarCodigoVenta dtoEValidarCodigoVenta=new DTOEValidarCodigoVenta();
    DTOSValidarCodigoVenta dtoSValidarCodigoVenta=null;
    MONMantenimientoMFHome monMantenimientoMFHome=null;    
    MONMantenimientoMF monMantenimientoMF=null;
    DetalleOfertaLocalHome detalleOfertaLocalHome=null;
    DetalleOfertaLocal detalleOfertaLocal=null;
    
    try {
      dtoEValidarCodigoVenta.setPeriodo(cabeceraSolicitud.getPeriodo());
      dtoEValidarCodigoVenta.setAcceso(cabeceraSolicitud.getAcceso());
      dtoEValidarCodigoVenta.setSubacceso(cabeceraSolicitud.getSubacceso());
      dtoEValidarCodigoVenta.setCodigoVenta(cv);
      
      monMantenimientoMFHome = (MONMantenimientoMFHome)UtilidadesEJB.getHome("MONMantenimientoMF", MONMantenimientoMFHome.class);
      monMantenimientoMF = monMantenimientoMFHome.create();    
  
      dtoSValidarCodigoVenta=monMantenimientoMF.validarCodigoVenta(dtoEValidarCodigoVenta);
      if(dtoSValidarCodigoVenta.getOidDetalleOferta()!=null) {
        detalleOfertaLocalHome= new DetalleOfertaLocalHome();       
        detalleOfertaLocal=detalleOfertaLocalHome.findByPrimaryKey(dtoSValidarCodigoVenta.getOidDetalleOferta());
        UtilidadesLog.info("MONRegistroOnlineBean.obtenerTipoOferta(DTOCabeceraSolicitud cabeceraSolicitud, String cv): Salida ");
        return detalleOfertaLocal.getOidTipoOfer();
      }
      else {
        UtilidadesLog.info("MONRegistroOnlineBean.obtenerTipoOferta(DTOCabeceraSolicitud cabeceraSolicitud, String cv): Salida ");
        return null;      
      }
    }
    catch (CreateException cex) {
        ctx.setRollbackOnly();
        UtilidadesLog.error("Error",cex);
        throw new MareException(cex,UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
    }    
    catch(RemoteException rex) {
        ctx.setRollbackOnly();
        UtilidadesLog.error("Error",rex);
        throw new MareException(rex,UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));    
    }
    catch (NoResultException nre) {
      ctx.setRollbackOnly();
      UtilidadesLog.error("Error",nre);
      throw new MareException(nre,UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE));
    }
    catch (PersistenceException pe) {
      ctx.setRollbackOnly();
      UtilidadesLog.error("Error",pe);
      throw new MareException(pe,UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS));
    }
    catch (Exception ex) { //ERROR NO DOCUMENTADO
        ctx.setRollbackOnly();
        UtilidadesLog.error("Error",ex);
        throw new MareException(ex);
    }      
  }

  // Hay que generar el número de solicitud. Llamamos a CU Generar Número Documento
  private DTOCabeceraSolicitud generarNumeroSolicitud(DTOCabeceraSolicitud dtoe) throws MareException 
  {
    UtilidadesLog.info("MONRegistroOnlineBean.generarNumeroSolicitud(DTOCabeceraSolicitud dtoe): Entrada ");
    MONProcesosPEDHome monProcesosPEDHome=null;
    MONProcesosPED monProcesosPED=null;
    DTONumeroSolicitud dtoNumeroSolicitud=new DTONumeroSolicitud();
  
    try {    
      dtoNumeroSolicitud.setOidCanal(dtoe.getCanal());
      dtoNumeroSolicitud.setOidAcceso(dtoe.getAcceso());
      dtoNumeroSolicitud.setOidSubacceso(dtoe.getSubacceso());
      dtoNumeroSolicitud.setOperacion(ConstantesBEL.COD_PED001.toString());
      
      dtoNumeroSolicitud.setOidPais(dtoe.getOidPais());
      
      monProcesosPEDHome=(MONProcesosPEDHome)UtilidadesEJB.getHome("MONProcesosPED", MONProcesosPEDHome.class);
      monProcesosPED=monProcesosPEDHome.create();
    
      // Obtiene el número de solicitud 
      dtoe.setNumeroSolicitud(monProcesosPED.generaNumeroDocumento(dtoNumeroSolicitud));
    }
    catch (CreateException cex) {
        UtilidadesLog.error("Error",cex);
        throw new MareException(cex,UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
    }    
    catch(RemoteException rex) {
        UtilidadesLog.error("Error",rex);
        throw new MareException(rex,UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));    
    }
    catch (Exception ex) { //ERROR NO DOCUMENTADO
        UtilidadesLog.error("Error",ex);
        throw new MareException(ex);
    }     
    UtilidadesLog.info("MONRegistroOnlineBean.generarNumeroSolicitud(DTOCabeceraSolicitud dtoe): Salida ");
    return dtoe;
  }
  
  // Realiza la reversión del movimiento de almacén generado para la solicitud  
  public DTOCabeceraSolicitud revertirAlmacen(DTORevertirPosicionRegistro dtoe) throws MareException
  {
    UtilidadesLog.info("MONRegistroOnlineBean.revertirAlmacen(DTORevertirPosicionRegistro dtoe): Entrada ");
    int posicion;
    int pos;
    DTOPosicionSolicitud posicionSolicitud=null;    
    DTOReversionMovimiento reversionMovimiento=null;
    MONGenerarMovimientoAlmacenHome monGenerarMovimientoAlmacenHome=null;
    MONGenerarMovimientoAlmacen monGenerarMovimientoAlmacen=null;
    DTOReversionMovimiento dtoReversionMovimiento=new DTOReversionMovimiento();
    //DTOCabeceraSolicitud cabeceraSolicitud;
    
    try {           
      dtoReversionMovimiento.setPais(dtoe.getCabeceraSolicitud().getOidPais());
      dtoReversionMovimiento.setSubacceso(dtoe.getCabeceraSolicitud().getSubacceso());
      dtoReversionMovimiento.setNumDocumento(dtoe.getCabeceraSolicitud().getNumeroSolicitud());
      dtoReversionMovimiento.setNumLinea(null);
      dtoReversionMovimiento.setOperacion(ConstantesBEL.PED001);
          
      ArrayList posicionesRevertir=dtoe.getPosicionesRevertir();    
      monGenerarMovimientoAlmacenHome=(MONGenerarMovimientoAlmacenHome)UtilidadesEJB.getHome("MONGenerarMovimientoAlmacen", MONGenerarMovimientoAlmacenHome.class);
      monGenerarMovimientoAlmacen=monGenerarMovimientoAlmacenHome.create();
      if(posicionesRevertir != null) {
        //Recorre la lista de posiciones utilizando el contador "pos" y para cada una
        for(pos=0; pos<posicionesRevertir.size(); pos++) {
          // Recupera de la solicitud el número de posición indicado 
          posicion = new Long(posicionesRevertir.get(pos).toString()).intValue();
          posicionSolicitud = (DTOPosicionSolicitud)dtoe.getCabeceraSolicitud().getPosiciones().get(posicion-1);
          reversionMovimiento.setNumLinea(LongToInteger(posicionSolicitud.getNumeroPosicion()));
          
          // Revierte la asignación de almacén para la linea indicada           
          monGenerarMovimientoAlmacen.reversionMovimientoAlmacen(reversionMovimiento);
        }
  
        //Finalmente elimino las posiciones de la solicitud (Esto solo se puede hacer en este momento, no antes!) 
        //Recorre la lista de posiciones utilizando el contador "pos" y para cada una
        for(pos=0; pos<posicionesRevertir.size(); pos++) {
          posicion = new Long(posicionesRevertir.get(pos).toString()).intValue();
          dtoe.getCabeceraSolicitud().getPosiciones().remove(posicion);
        }      
      }
      else {
        // Revierte la asignación de almacén para toda la solicitud 
        monGenerarMovimientoAlmacen.reversionMovimientoAlmacen(reversionMovimiento); 
        
        // Elimina la solicitud 
        dtoe.setCabeceraSolicitud(null);
      }
    }
    catch (CreateException cex) {
        UtilidadesLog.error("Error",cex);
        throw new MareException(cex,UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
    }    
    catch(RemoteException rex) {
        UtilidadesLog.error("Error",rex);
        throw new MareException(rex,UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));    
    }
    catch (Exception ex) { //ERROR NO DOCUMENTADO
        UtilidadesLog.error("Error",ex);
        throw new MareException(ex);
    }
    UtilidadesLog.info("MONRegistroOnlineBean.revertirAlmacen(DTORevertirPosicionRegistro dtoe): Salida ");
    return dtoe.getCabeceraSolicitud();
  }
  
  public DTOSalida obtenerImportesCobro(DTOOID dtoOid) throws MareException
  {
    UtilidadesLog.info("MONRegistroOnlineBean.obtenerImportesCobro(DTOOID dtoOid): Entrada ");
    DTOSalida dtoSalida=new DTOSalida();    
    DAOSolicitud daoSolicitud=new DAOSolicitud();
    dtoSalida.setResultado(daoSolicitud.obtenerImportesCobro(dtoOid));
    UtilidadesLog.info("MONRegistroOnlineBean.obtenerImportesCobro(DTOOID dtoOid): Salida ");
    return dtoSalida;
  }
  
  public DTOObtenerSolicitudCobro obtenerSolicitudCobro(DTOObtenerSolicitudCobro dtoE) throws MareException
  {
    UtilidadesLog.info("MONRegistroOnlineBean.obtenerSolicitudCobro(DTOObtenerSolicitudCobro dtoE): Entrada ");
    DAOSolicitud daoSolicitud=new DAOSolicitud();
    dtoE = daoSolicitud.obtenerSolicitudCobro(dtoE); 
    UtilidadesLog.info("MONRegistroOnlineBean.obtenerSolicitudCobro(DTOObtenerSolicitudCobro dtoE): Salida ");
    return dtoE;
  }

  public DTOSalida obtenerNotasCreditoPendientes(DTOObtenerNotasCreditoPendientes dtoE) throws MareException
  {
    UtilidadesLog.info("MONRegistroOnlineBean.obtenerNotasCreditoPendientes(DTOObtenerNotasCreditoPendientes dtoE): Entrada ");
    DTOSalida dtoSalida=new DTOSalida();
    DAOSolicitud daoSolicitud=new DAOSolicitud();
    dtoSalida.setResultado(daoSolicitud.obtenerNotasCreditoPendientes(dtoE));
    UtilidadesLog.info("MONRegistroOnlineBean.obtenerNotasCreditoPendientes(DTOObtenerNotasCreditoPendientes dtoE): Salida ");
    return dtoSalida;
  }

  public void actualizarAplicacionManual(DTOOID dtoOId) throws MareException
  {
    UtilidadesLog.info("MONRegistroOnlineBean.actualizarAplicacionManual(DTOOID dtoOId): Entrada ");
    DAOSolicitud daoSolicitud=new DAOSolicitud();    
    daoSolicitud.actualizarAplicacionManual(dtoOId);    
    UtilidadesLog.info("MONRegistroOnlineBean.actualizarAplicacionManual(DTOOID dtoOId): Salida ");
  }

  public DTOSalida buscarSolicitudesCambiosVentas(DTOCambiosVentas dtoE) throws MareException
  {
    UtilidadesLog.info("MONRegistroOnlineBean.buscarSolicitudesCambiosVentas(DTOCambiosVentas dtoE): Entrada ");
    DTOSalida dtoSalida=new DTOSalida();
    //DAORegistroOnline daoRegistroOnline=new DAORegistroOnline(ctx.getCallerPrincipal().getName());
    DAORegistroOnline daoRegistroOnline=new DAORegistroOnline(dtoE.getUserName());
    dtoSalida.setResultado(daoRegistroOnline.buscarSolicitudesCambiosVentas(dtoE));
    UtilidadesLog.info("MONRegistroOnlineBean.buscarSolicitudesCambiosVentas(DTOCambiosVentas dtoE): Salida ");
    return dtoSalida;
  }

  public BigDecimal calcularMontoDevuelve(DTOApplet dtoa) throws MareException
  {
    UtilidadesLog.info("MONRegistroOnlineBean.calcularMontoDevuelve(DTOApplet dtoa): Entrada ");
    DTOOID dtoOId = (DTOOID)dtoa.getDto();
    //DAORegistroOnline daoRegistroOnline=new DAORegistroOnline(ctx.getCallerPrincipal().getName());
    DAORegistroOnline daoRegistroOnline=new DAORegistroOnline(dtoa.getUserName());
    UtilidadesLog.info("MONRegistroOnlineBean.calcularMontoDevuelve(DTOApplet dtoa): Salida ");
    return daoRegistroOnline.calcularMontoDevuelve(dtoOId.getOid());
  }

  public DTOOID obtenerNumeroUnidadesVendidas(DTOApplet dtoa) throws MareException
  {
    UtilidadesLog.info("MONRegistroOnlineBean.obtenerNumeroUnidadesVendidas(DTOApplet dtoa): Entrada ");
    DTOOID dtoOId=new DTOOID();
    DTOOID dtoE = (DTOOID)dtoa.getDto();
    //DAORegistroOnline daoRegistroOnline=new DAORegistroOnline(ctx.getCallerPrincipal().getName());    
    DAORegistroOnline daoRegistroOnline=new DAORegistroOnline(dtoa.getUserName());    
    dtoOId.setOid(daoRegistroOnline.obtenerNumeroUnidadesVendidas(dtoE.getOid()));
    UtilidadesLog.info("MONRegistroOnlineBean.obtenerNumeroUnidadesVendidas(DTOApplet dtoa): Salida ");
    return dtoOId;
  }

  public DTOSalida obtenerPosicionesCambioVenta(DTOApplet dtoa) throws MareException
  {
    UtilidadesLog.info("MONRegistroOnlineBean.obtenerPosicionesCambioVenta(DTOApplet dtoa): Entrada ");
    DTOSalida dtoSalida=new DTOSalida();
    DTOOID dtoE = (DTOOID)dtoa.getDto();
    //DAORegistroOnline daoRegistroOnline=new DAORegistroOnline(ctx.getCallerPrincipal().getName());    
    DAORegistroOnline daoRegistroOnline=new DAORegistroOnline(dtoa.getUserName());    
    dtoSalida.setResultado(daoRegistroOnline.obtenerPosicionesCambioVenta(dtoE.getOid()));
    UtilidadesLog.info("MONRegistroOnlineBean.obtenerPosicionesCambioVenta(DTOApplet dtoa): Salida ");
    return dtoSalida;
  }

  public void actualizarPosicionCambioVenta(DTOPosicionCambioVenta dtoE) throws MareException
  {
    UtilidadesLog.info("MONRegistroOnlineBean.actualizarPosicionCambioVenta(DTOPosicionCambioVenta dtoE): Entrada ");
    //DAORegistroOnline daoRegistroOnline=new DAORegistroOnline(ctx.getCallerPrincipal().getName());
    DAORegistroOnline daoRegistroOnline=new DAORegistroOnline(dtoE.getUserName());
    daoRegistroOnline.actualizarPosicionCambioVenta(dtoE);  
    UtilidadesLog.info("MONRegistroOnlineBean.actualizarPosicionCambioVenta(DTOPosicionCambioVenta dtoE): Salida ");
  }

  public DTOSalida simularCambiosVentas(DTOApplet dtoa) throws MareException
  {
    UtilidadesLog.info("MONRegistroOnlineBean.simularCambiosVentas(DTOApplet dtoa): Entrada ");
    DTOSalida dtoSalida=new DTOSalida();
    DTOOID dtoE = (DTOOID)dtoa.getDto();
    //DAORegistroOnline daoRegistroOnline=new DAORegistroOnline(ctx.getCallerPrincipal().getName());
    DAORegistroOnline daoRegistroOnline=new DAORegistroOnline(dtoa.getUserName());
    dtoSalida.setResultado(daoRegistroOnline.simularCambiosVentas(dtoE));
    UtilidadesLog.info("MONRegistroOnlineBean.simularCambiosVentas(DTOApplet dtoa): Salida ");
    return dtoSalida;  
  }  
  

  /* ------------ ENTIDADES ------------ */


    private MaestroProductosLocalHome getMaestroProductosLocalHome() throws NamingException
  {
    final InitialContext context = new InitialContext();
    return (MaestroProductosLocalHome)context.lookup("java:comp/env/MaestroProductos");
  }


    private MONProductosHome getMONProductosHome() throws NamingException
  {
    final InitialContext context = new InitialContext();
    return (MONProductosHome)context.lookup("java:comp/env/MONProductos");
  }


    private MONMantenimientoMFHome getMONMantenimientoMFHome() throws NamingException
  {
    final InitialContext context = new InitialContext();
    return (MONMantenimientoMFHome)PortableRemoteObject.narrow(context.lookup("java:comp/env/MONMantenimientoMF"), MONMantenimientoMFHome.class);
  }    
  /* ------------ ENTIDADES ------------ */
  
  
 
  /* ------------ METODOS AUXILIARES ------------ */
  private Long objectToLong(Object obj) {
    if (obj != null) {
      Long result = new Long(((BigDecimal)obj).longValue());
      return result;
    } else {
      return null;
    }
  }

  private Long quitarDecimalesALong(Long longVal) {
    if (longVal != null) {      
      return new Long(longVal.intValue());
    } else {
      return null;
    }
  }  
  
  private Integer objectToInteger(Object obj) {
    if (obj != null) {
      Integer result = new Integer((String)obj);
      return result;
    } else {
      return null;
    }
  }    

  private Integer LongToInteger(Long obj) {
    if (obj != null) {
      Integer result = new Integer(obj.intValue());
      return result;
    } else {
      return null;
    }
  }   

  private BigDecimal objectToBigDecimal(Object obj) {
    if (obj != null) {
      return (BigDecimal)obj;
    } else {
      return null;
    }
  } 
  
  //Elimina filas null de un array DTODatosCombo
  private DTOTiposSolicitud[] delNullArrayDTOTiposSolicitudes(DTOTiposSolicitud[] objArray) {
    DTOTiposSolicitud[] objArray2=null;
    int filasNull=0;
    int i, j;
    
    filasNull=countNullArrayDTOTiposSolicitud(objArray);
    objArray2=new DTOTiposSolicitud[objArray.length - filasNull];
    
    j=0;
    for(i=0; i<objArray.length; i++) {
      if(objArray[i]!=null) {
        objArray2[j]=objArray[i];
        j++;
      }      
    }
    
    return objArray2;
  }

  //Cuenta filas null de un array DTODatosCombo
  private int countNullArrayDTOTiposSolicitud(DTOTiposSolicitud[] objArray) {
    int xCount=0;
    
    if(objArray!=null) {
      for(int i=0; i<objArray.length ; i++) {
        if(objArray[i]==null)
          xCount++;
      }
    }
   
    return xCount;
  }

  //Agrega una fila nueva a un Array de DTODatosCombo.
  private DTODatosCombo[] addRowArrayDTODatosCombo(DTODatosCombo[] objArray, DTODatosCombo obj) {
    if(obj==null) {
      return objArray;      
    }
    if(objArray==null) {
      objArray=new DTODatosCombo[1];
    }
    
    DTODatosCombo[] objArray2 = new DTODatosCombo[objArray.length+1];
    for (int i = 0; i < objArray.length; ++i) {
      objArray2[i] = objArray[i];
    }    
    objArray2[objArray.length]=obj;
    
    return objArray2;
  }

  private MONProcesosPEDHome getMONProcesosPEDHome() throws NamingException
  {
    final InitialContext context = new InitialContext();
    return (MONProcesosPEDHome)PortableRemoteObject.narrow(context.lookup("java:comp/env/MONProcesosPED"), MONProcesosPEDHome.class);
  }

  private MONGenerarMovimientoAlmacenHome getMONGenerarMovimientoAlmacenHome() throws NamingException
  {
    final InitialContext context = new InitialContext();
    return (MONGenerarMovimientoAlmacenHome)PortableRemoteObject.narrow(context.lookup("java:comp/env/MONGenerarMovimientoAlmacen"), MONGenerarMovimientoAlmacenHome.class);
  }

  private MONGenerarPosicionSolicitudHome getMONGenerarPosicionSolicitudHome() throws NamingException
  {
    final InitialContext context = new InitialContext();
    return (MONGenerarPosicionSolicitudHome)PortableRemoteObject.narrow(context.lookup("java:comp/env/MONGenerarPosicionSolicitud"), MONGenerarPosicionSolicitudHome.class);
  }

  private MONDigitacionInicialHome getMONDigitacionInicialHome() throws NamingException
  {
    final InitialContext context = new InitialContext();
    return (MONDigitacionInicialHome)PortableRemoteObject.narrow(context.lookup("java:comp/env/MONDigitacionInicial"), MONDigitacionInicialHome.class);
  }

  private MONClientesHome getMONClientesHome() throws NamingException
  {
    final InitialContext context = new InitialContext();
    return (MONClientesHome)PortableRemoteObject.narrow(context.lookup("java:comp/env/MONClientes"), MONClientesHome.class);
  }

  private MONInterfaceModulosHome getMONInterfaceModulosHome() throws NamingException
  {
    final InitialContext context = new InitialContext();
    return (MONInterfaceModulosHome)PortableRemoteObject.narrow(context.lookup("java:comp/env/MONInterfaceModulos"), MONInterfaceModulosHome.class);
  }

  private MONConfiguracionClientesHome getMONConfiguracionClientesHome() throws NamingException
  {
    final InitialContext context = new InitialContext();
    return (MONConfiguracionClientesHome)PortableRemoteObject.narrow(context.lookup("java:comp/env/MONConfiguracionClientes"), MONConfiguracionClientesHome.class);
  }

  private MONGestionFormasPagoDetalleHome getMONGestionFormasPagoDetalleHome() throws NamingException
  {
    final InitialContext context = new InitialContext();
    return (MONGestionFormasPagoDetalleHome)PortableRemoteObject.narrow(context.lookup("java:comp/env/MONGestionFormasPagoDetalle"), MONGestionFormasPagoDetalleHome.class);
  }

  public Integer obtenerTamanioPagina(String user) {
    UtilidadesLog.info("MONRegistroOnlineBean.obtenerTamanioPagina(String user): Entrada ");
    Integer integer = null;
    try {
      MareMGC mgc = null;
      mgc = (MareMGC)MareMii.getService(new MareTopic(("Configuration")));
      String aux = (String) mgc.getProperty("application/tamanioPaginaClientePesado");
			
      integer = new Integer(aux);
    } catch (MareException e) {
      UtilidadesLog.debug("No se ha encontrado application/tamanioPaginaClientePesado");
      UtilidadesLog.debug("Se configura por default en 20");
      integer = new Integer(20);
    } catch (NumberFormatException e) {
      UtilidadesLog.debug("NumberFormatException al configurar el tamaño de la paginación");
      UtilidadesLog.debug("Se configura por default en 20");
      integer = new Integer(20);
    } catch (Exception e) {
      UtilidadesLog.debug("Exception no esperada al configurar el tamaño de la paginación");
      UtilidadesLog.debug("Se configura por default en 20");
      integer = new Integer(20);
    } 
    UtilidadesLog.debug("Se configuró tamanioPaginaClientePesado en " + integer);
    UtilidadesLog.info("MONRegistroOnlineBean.obtenerTamanioPagina(String user): Salida ");
    return integer;
  }

/*
 * Fecha de Creacion: 19/05/2005
 * Autor: Damasia Maneiro
 * Comentario: Realiza la simulación del cuadre de ofertas para la solicitud recibida 
 */
  public DTOCabeceraSolicitud simularCuadreOfertas(DTOCabeceraSolicitud dtoe) throws MareException {
    UtilidadesLog.info("MONRegistroOnlineBean.simularCuadreOfertas(DTOCabeceraSolicitud dtoe): Entrada ");
  
  DTOPosicionSolicitud posicionSolicitud = new DTOPosicionSolicitud();
  DAORegistroOnline daoRegistroOnline = new DAORegistroOnline(dtoe.getUsuario());
  DTOCabeceraSolicitud cabeceraSolicitud = new DTOCabeceraSolicitud();
  int pos=0; 
  
    try {           
    
      ArrayList posiciones = dtoe.getPosiciones();    
      MONCuadreOfertasHome cuadreOfertasHome = getMONCuadreOfertasHome();
      MONCuadreOfertas monCuadreOferta = cuadreOfertasHome.create(); 
      DTOPosicionSolicitud posicionSimularCuadre = null;  
      while(posiciones.size() > pos){
  
        posicionSolicitud = (DTOPosicionSolicitud)posiciones.get(pos);
        posicionSimularCuadre = daoRegistroOnline.obtenerPosicionSimularCuadre(posicionSolicitud);
        
        if(posicionSimularCuadre != null){
          posiciones.set(pos,posicionSimularCuadre);
        }
               
        pos++;
      }
    
      dtoe.setPosiciones(posiciones);
      dtoe.setIndPedidoPrueba(Boolean.TRUE);
      cabeceraSolicitud = monCuadreOferta.cuadrarOfertas(dtoe, null, null);
      cabeceraSolicitud.setOidIdioma(dtoe.getOidIdioma());            
      cabeceraSolicitud = completarPosicionesSimulacionCuadre(cabeceraSolicitud); 
      
    } catch (NamingException ne){
        UtilidadesLog.error("Error",ne);
        throw new MareException(ne,UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
    } catch (CreateException ce){
        UtilidadesLog.error("Error",ce);
        throw new MareException(ce,UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
    } catch(RemoteException re){
        UtilidadesLog.error("Error",re);
        throw new MareException(re,UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));    
    } catch (Exception ex){ //ERROR NO DOCUMENTADO
        UtilidadesLog.error("Error",ex);
        throw new MareException(ex);
    }
      UtilidadesLog.info("MONRegistroOnlineBean.simularCuadreOfertas(DTOCabeceraSolicitud dtoe): Salida ");
      return cabeceraSolicitud;   
 
  }

  private MONCuadreOfertasHome getMONCuadreOfertasHome() throws NamingException
  {
    final InitialContext context = new InitialContext();
    return (MONCuadreOfertasHome)PortableRemoteObject.narrow(context.lookup("java:comp/env/MONCuadreOfertas"), MONCuadreOfertasHome.class);
  }
  /* ------------ METODOS AUXILIARES ------------ */  
  
   public HashMap getProperties(UserIDImpl usr) throws MareException {
       MareCredentials credenciales = new MareCredentials(usr, null);
       MGUService mgu = null;
       try{
        mgu =(MGUService) MareMii.getService(new MareTopic(MareMii.SERVICE_MGU, credenciales));
       }catch(Exception e){
           throw new RuntimeException("Error al obtener las propiedades",e);
       }
       return mgu.getProperties();
   }  
}