package es.indra.sicc.bel.applet.componentes;

import es.indra.mare.common.dto.MareDTO;
import es.indra.mare.common.exception.MareException;
import es.indra.sicc.bel.applet.componentes.FrameNotasCreditoPendientes;
import es.indra.sicc.bel.applet.util.DetalleCobroDevolucion;
import es.indra.sicc.comunapplet.Communicator;
import es.indra.sicc.comunapplet.ConstantesApplet;
import es.indra.sicc.comunapplet.Dialogos;
import es.indra.sicc.comunapplet.exceptions.AppletException;
import es.indra.sicc.dtos.bel.DTOCambiosVentas;
import es.indra.sicc.dtos.bel.DTOCargaCobroBelcenter;
import es.indra.sicc.dtos.bel.DTOCargaMedioPago;
import es.indra.sicc.dtos.bel.DTOCargaMoneda;
import es.indra.sicc.dtos.bel.DTOCobroBelcenter;
import es.indra.sicc.dtos.bel.DTOMovimientoCaja;
import es.indra.sicc.dtos.bel.DTOMovimientoCajaDetalle;
import es.indra.sicc.dtos.bel.DTOObtenerNotasCreditoPendientes;
import es.indra.sicc.dtos.ped.applet.DTODatosCombo;
import es.indra.sicc.util.DTOSalida;

import java.math.BigDecimal;

import java.sql.Date;


import es.indra.sicc.comunapplet.ConstantesBundlesApplet;

import es.indra.sicc.comunapplet.PropertiesApplet;

import es.indra.sicc.comunapplet.ConstantesFrames;


public class CobrarBelcenter {

  private FrameCobrarBelcenter frameCobrarBelcenter = null;
  private String url;
  private String userName = null;
  private Long oidPais;

  //yyy-------------------------------------------------------------------------
  public boolean $DEBUG = false;
  public DTOCargaCobroBelcenter dtoCargaCobroBelcenter;  
  //yyy-------------------------------------------------------------------------

  public CobrarBelcenter(String url, String userName, Long oidPais){
    this();
    this.setUrl(url);
    this.userName = userName;
    this.oidPais = oidPais;
  }

  public CobrarBelcenter(){
    this.frameCobrarBelcenter = new FrameCobrarBelcenter(this);
        
    if($DEBUG){
      //url = "http://192.168.118.101:7777/sicc/ServletApplet";
      this.frameCobrarBelcenter.setOidPais(new Long(1));
      this.frameCobrarBelcenter.setOidAcceso(new Long(1));
      this.frameCobrarBelcenter.setOidSubacceso(new Long(4));
      this.frameCobrarBelcenter.setOidIdioma(new Long(1));
      this.frameCobrarBelcenter.setOidCliente(new Long(1376));
      
      this.frameCobrarBelcenter.getCargaCobro();

      dtoCargaCobroBelcenter = new DTOCargaCobroBelcenter();
      
      dtoCargaCobroBelcenter.setTipoCambio(new BigDecimal(2));
      
      DTOCargaMedioPago[] dtocmps = new DTOCargaMedioPago[2];
      DTOCargaMedioPago dtocmp = new DTOCargaMedioPago();
      dtocmp.setOidTipoMedioPago(new Long(1));
      dtocmp.setDescripcion("tipo medio pago 1");
      dtocmps[0] = dtocmp;
      dtocmp = new DTOCargaMedioPago();
      dtocmp.setOidTipoMedioPago(new Long(2));
      dtocmp.setDescripcion("tipo medio pago 2");
      dtocmps[1] = dtocmp;
      dtoCargaCobroBelcenter.setMedioPago(dtocmps);
      
      DTOCargaMoneda dtom = new DTOCargaMoneda();
      dtom.setOid(new Long(1));
      dtom.setDescripcion("monedassss");
      dtom.setDecimales(new Integer(2));
      dtoCargaCobroBelcenter.setMoneda(dtom);
      
      DTODatosCombo[] dtodcs = new DTODatosCombo[2];
      DTODatosCombo dtodc = new DTODatosCombo();
      dtodc.setOid(new Long(1));
      dtodc.setDesc("banco de boston");
      dtodcs[0] = dtodc;
      dtodc = new DTODatosCombo();
      dtodc.setOid(new Long(2));
      dtodc.setDesc("citybank");
      dtodcs[1] = dtodc;
      dtoCargaCobroBelcenter.setBanco(dtodcs);

      dtodcs = new DTODatosCombo[2];
      dtodc = new DTODatosCombo();
      dtodc.setOid(new Long(1));
      dtodc.setDesc("tipo tarjeta 1");
      dtodcs[0] = dtodc;
      dtodc = new DTODatosCombo();
      dtodc.setOid(new Long(2));
      dtodc.setDesc("tipo tarjeta 2");
      dtodcs[1] = dtodc;
      dtoCargaCobroBelcenter.setTipoTarjeta(dtodcs);
      
      this.frameCobrarBelcenter.getTablaDetalle().newRow();
    } /*else {
      this.frameCobrarBelcenter.getTablaDetalle().newRow();
      this.frameCobrarBelcenter.getTablaDetalle().colMedioPago.setText("22",0);
    }*/
  }

  /*
   * Autor Cortaberria
   * Fecha 25/04/2005
   * Modifico calculo de importes totales
   */
  void anyadir() throws MareException {
    //this.frameCobrarBelcenter.getTablaDetalle().newRow();
    //this.frameCobrarBelcenter.getTablaDetalle().colMedioPago.setText("33",1);
    
    DatosCobro dc = frameCobrarBelcenter.getDatosCobro();

    dc.setOidPais(this.frameCobrarBelcenter.getOidPais());
    dc.setOidIdioma(this.frameCobrarBelcenter.getOidIdioma());
    
    dc.inicializar(this.userName);
    dc.seleccionarValoresDefecto();
    dc.setVisible(true);
    
    DetalleCobroDevolucion fila = dc.generarDetalleCobro();
    
    if(!dc.getAccionCancelada().booleanValue()){
      if(!fila.isEmpty().booleanValue()){
        //System.out.println("se va a anyadir la fila " + fila);
        this.anyadirFilaDetalle(fila);
        
        frameCobrarBelcenter.getMovimientosCaja().add(this.crearDTOMovimientoCajaDetalle(fila));
      
        BigDecimal bd = null;
  
        //Actualizar total pagado
        double totalPagado = (bd = frameCobrarBelcenter.getTotalPagado()) != null ? bd.doubleValue() : 0;
        double importeFila = (bd = fila.getImporte()) != null ? bd.doubleValue() : 0;
        bd = new BigDecimal(Double.toString(totalPagado + importeFila));
        frameCobrarBelcenter.setTotalPagado(bd);

 
        bd = null;
      
        //Actualiza total pendiente
        double importePagar = (bd = frameCobrarBelcenter.getImportePagar()) != null ? bd.doubleValue() : 0;
        bd = new BigDecimal(Double.toString(importePagar - (totalPagado + importeFila)));
        frameCobrarBelcenter.setTotalPendiente(bd);

        actualizarTotales();
        
      } else {
        System.out.println("la fila esta vacia");
      }
    } else {
      System.out.println("La accion se cancelo");
    }
    
    dc.getFrame().setVisible(false);
  }

  public DTOMovimientoCajaDetalle crearDTOMovimientoCajaDetalle(
      DetalleCobroDevolucion fila){
  
    this.obtenerValoresDetalle(fila);
    
    DTOMovimientoCajaDetalle dto = new DTOMovimientoCajaDetalle();
    
    //obtener cantidad de filas de la tabla
    int rowCount = this.frameCobrarBelcenter.getTablaDetalle().getRowCount();
    dto.setNumeroLinea(new Integer(rowCount + 1));
    dto.setOidTipoMovimientoCaja(frameCobrarBelcenter.getOidTipoMovimientoCobrar());
    dto.setOidMonedaAlternativa(frameCobrarBelcenter.getOidMoneda());
    dto.setOidMedioPagoBelcenter(frameCobrarBelcenter.getOidMedioPago());
    dto.setImporte(fila.getImporte());
    dto.setImporteDivisa(fila.getImporteDivisa());
    dto.setOidBancos(frameCobrarBelcenter.getOidBanco());
    dto.setNumeroCheque(fila.getNumeroCheque());
    dto.setOidTipoTarjeta(frameCobrarBelcenter.getOidTipoTarjeta());
    dto.setNumeroTarjeta(fila.getNumeroTarjeta());
    dto.setNumeroValeCompra(fila.getNumeroValeCompra());
    dto.setOidSolicitudNotaCredito(
      frameCobrarBelcenter.getDatosCobro().getFrame().getOidSolicitudNotaCredito());
    dto.setOidSolicitudCabecera(frameCobrarBelcenter.getOidSolicitudCabecera());
    dto.setFecha( new Date(System.currentTimeMillis()));
  
    return dto;
  }

  public void obtenerValoresDetalle(DetalleCobroDevolucion fila){
    DTOCargaCobroBelcenter dto = frameCobrarBelcenter.getCargaCobro();
  
    DTOCargaMedioPago[] cargaMedioPago = dto.getMedioPago();
    
    //incidencia 14252 03/03/2005 (resuelto)
    DTOCargaMoneda cargaMoneda = dto.getMoneda();
    DTODatosCombo[] datosComboBancos = dto.getBanco();
    DTODatosCombo[] datosCombosTipoTarjeta = dto.getTipoTarjeta();
    
    //Medio pago
    for(int i = 0; i < cargaMedioPago.length; i++){
      if(fila != null && fila.getMedioPago() != null && 
          fila.getMedioPago().equals(cargaMedioPago[i].getDescripcion())){
        frameCobrarBelcenter.setOidMedioPago(cargaMedioPago[i].getOid());
        break;
      }
    }
    
    //Moneda
    frameCobrarBelcenter.setOidMoneda(cargaMoneda.getOid());

    //Banco
    for(int i = 0; i < datosComboBancos.length; i++){
      if(fila != null && fila.getBanco() != null && 
          fila.getBanco().equals(datosComboBancos[i].getDesc())){
        frameCobrarBelcenter.setOidBanco(datosComboBancos[i].getOid());
        break;
      }
    }
    
    //Tipo tarjeta (puede ser null)
    frameCobrarBelcenter.setOidTipoTarjeta(null);
    for(int i = 0; i < datosCombosTipoTarjeta.length; i++){
      if(fila != null && fila.getTipoTarjeta() != null && 
          fila.getTipoTarjeta().equals( datosCombosTipoTarjeta[i].getDesc())){
        frameCobrarBelcenter.setOidTipoTarjeta(datosCombosTipoTarjeta[i].getOid());
        break;
      }
    }
    
    //Solicitud nota credito (puede ser null)
    frameCobrarBelcenter.setOidSolicitudNotaCredito(
      frameCobrarBelcenter.getDatosCobro().getFrame().getOidSolicitudNotaCredito());
  }
  
  /*
   * Autor Cortaberria
   * Fecha 25/04/2005
   * Modifico calculo de importes totales
   */
  void modificar() throws AppletException {
  
    //Verificar que se haya seleccionado alguna fila en la tabla
    if( this.frameCobrarBelcenter.getTablaDetalle().getSelectedRow() == -1 ){
      Dialogos.mensajeError(ConstantesApplet.GEN_UIGEN0004, this.frameCobrarBelcenter);
      return;
    }
  
    DetalleCobroDevolucion fila = this.obtenerFilaDetalle();
    BigDecimal bd = null;

    double totalPagadoOriginal = (bd = frameCobrarBelcenter.getTotalPagado()) != null ? 
                                  bd.doubleValue() : 0;
    
    double importeOriginal = (bd = fila.getImporte()) != null ? bd.doubleValue() : 0; 
    
    double importePagarOriginal = (bd = frameCobrarBelcenter.getImportePagar()) != null ? 
                                   bd.doubleValue() : 0;
    
    //Actualizar total pagado
    //bd = new BigDecimal((new Long(totalPagado - importe)).toString());
    //frameCobrarBelcenter.setTotalPagado(bd);

    //Actualizar total pendiente
    //bd = new BigDecimal((new Long(importePagar - totalPagado)).toString());
    //frameCobrarBelcenter.setTotalPendiente(bd);

    //Mostrar modal
    DatosCobro dc = frameCobrarBelcenter.getDatosCobro();
    dc.inicializar(this.userName);
    dc.mostrarDetalle(fila);
    //dc.setVisible(true);

    //**************************************************************************
    //Se bloquea hasta que se oculta la ventana emergente
    //**************************************************************************

    if(!dc.getAccionCancelada().booleanValue()){
      fila = dc.generarDetalleCobro();
      this.actualizarFilaDetalle(fila);
  
      //Actualiza el DTO correspondiente en la lista de movimientos
      int posicion = frameCobrarBelcenter.getTablaDetalle().getSelectedRow();
      
      frameCobrarBelcenter.getMovimientosCaja().set(posicion, 
        crearDTOMovimientoCajaDetalle(fila));
      
      //Actualizo los totales     
      bd = null;
      
      double importe = (bd = fila.getImporte()) != null ? bd.doubleValue() : 0;
      
      //Actualizar total pagado
      if(importeOriginal != importe) {
        double aux = totalPagadoOriginal - importeOriginal + importe;
        bd = new BigDecimal((Double.toString(aux)));
        frameCobrarBelcenter.setTotalPagado(bd);

        //Actualizar total pendiente
        bd = new BigDecimal((Double.toString(importePagarOriginal - aux)));
        frameCobrarBelcenter.setTotalPendiente(bd);

        actualizarTotales();
      }
      
    }

    dc.getFrame().setVisible(false);
  }

  public DetalleCobroDevolucion obtenerFilaDetalle(){
    DetalleCobroDevolucion fila = new DetalleCobroDevolucion();
    
    TablaCobrarBelcenter tabla = frameCobrarBelcenter.getTablaDetalle();
    int posicion = tabla.getSelectedRow();
    
    fila.setBanco(tabla.colBanco.getText(posicion));
    
    String valor = null;

    try{
      fila.setImporte((valor=tabla.colImporte.getText(posicion))!=null&&
        valor.trim().length()>0?new BigDecimal(valor):null);
    }catch(NumberFormatException nfe){}
    
    try{
      fila.setImporteDivisa((valor=tabla.colImporteDivisa.getText(posicion))!=null&&
        valor.trim().length()>0?new BigDecimal(valor):null);
    }catch(NumberFormatException nfe){}
    
    fila.setMedioPago(tabla.colMedioPago.getText(posicion));
    fila.setMoneda(tabla.colMoneda.getText(posicion));
    fila.setNumeroCheque(tabla.colNCheque.getText(posicion));
    
    fila.setNumeroNotaCredito(tabla.colNConsolidado.getText(posicion));
    
    fila.setNumeroTarjeta(tabla.colNTarjeta.getText(posicion));
    fila.setNumeroValeCompra(tabla.colNValeCompra.getText(posicion));
    fila.setTipoCambio(tabla.colTipoCambio.getText(posicion));
    fila.setTipoTarjeta(tabla.colTipoTarjeta.getText(posicion));
  
    return fila;
  }

  private void actualizarFilaDetalle(DetalleCobroDevolucion fila){
    TablaCobrarBelcenter tabla = null;
    int posicion;
    
    if(fila != null){
      tabla = frameCobrarBelcenter.getTablaDetalle();
      posicion = tabla.getSelectedRow();
      
      //yyy
      //fila.setNumeroNotaCredito
      
      if(posicion!=-1){
        tabla.colBanco.setText(fila.getBanco(), posicion);

        //REDONDEAR 
        tabla.colImporte.setText(
            fila.getImporte()!=null
            ? fila.getImporte().setScale(2,BigDecimal.ROUND_HALF_EVEN).toString()
            : ""
            , posicion);
    
        tabla.colImporteDivisa.setText(
            fila.getImporteDivisa()!=null
            ? fila.getImporteDivisa().setScale(2,BigDecimal.ROUND_HALF_EVEN).toString()
            : ""
            , posicion);
    
        //tabla.colImporte.setText(fila.getImporte()!=null?fila.getImporte().toString():null, posicion);
        //tabla.colImporteDivisa.setText(fila.getImporteDivisa()!=null?fila.getImporteDivisa().toString():null, posicion);
        
        tabla.colMedioPago.setText(fila.getMedioPago(), posicion);
        tabla.colMoneda.setText(fila.getMoneda(), posicion);
        tabla.colNCheque.setText(fila.getNumeroCheque(), posicion);
        tabla.colNTarjeta.setText(fila.getNumeroTarjeta(), posicion);
        tabla.colNValeCompra.setText(fila.getNumeroValeCompra(), posicion);
        tabla.colTipoCambio.setText(fila.getTipoCambio(), posicion);
        tabla.colTipoTarjeta.setText(fila.getTipoTarjeta(), posicion);
      }else{
        //si no se selecciono ninguna fila en la tabla
        //yyy!!!FALTA!!! mostrar mensaje error
        //el error se maneja mas arriba
      }
    }
  }

  public void anyadirFilaDetalle(DetalleCobroDevolucion fila){
    this.frameCobrarBelcenter.aniadirFila(fila);

  }

  void eliminar(){
    DetalleCobroDevolucion fila = obtenerFilaDetalle();
    TablaCobrarBelcenter tabla = frameCobrarBelcenter.getTablaDetalle();
    
    int cantidadSeleccionada = tabla.getSelectedRowCount();
    //System.out.println("cantidadSeleccionada: " + cantidadSeleccionada);
    if(cantidadSeleccionada > 0) {
      int []posiciones = tabla.getSelectedRows();
      for (int i = posiciones.length - 1; i >= 0; --i) {
        int posicion = posiciones[i];  
      
        frameCobrarBelcenter.getMovimientosCaja().remove(posicion);
        
        //Actualizo los totales
        BigDecimal bd = null;
        
        double totalPagado = (bd = frameCobrarBelcenter.getTotalPagado()) != null ? 
                              bd.doubleValue() : 0;
        
        double importe = (bd = fila.getImporte()) != null ? bd.doubleValue() : 0;
        
        double importePagar = (bd = frameCobrarBelcenter.getImportePagar()) != null ? 
                               bd.doubleValue() : 0;
    
        //Actualizar total pagado
        bd = new BigDecimal(Double.toString(totalPagado - importe));
        frameCobrarBelcenter.setTotalPagado(bd);
    
        //Actualizar total pendiente
        bd = new BigDecimal(Double.toString(importePagar - (totalPagado - importe)));
        frameCobrarBelcenter.setTotalPendiente(bd);
  
        actualizarTotales();
        
        tabla.deleteRow(posicion);
      }
    } else {
      Dialogos.mensajeError(ConstantesApplet.GEN_UIGEN0004, this.frameCobrarBelcenter);
    }
  }

  public void guardar() throws AppletException {
    //try{
      validarMaximaDiferenciaAdmisible();
      this.grabarCobro();
    /*}catch(MareException e){
      //mostrar mensaje de error asociado
      UtilApplet.procesarError(e, this.frameCobrarBelcenter);
    }*/
  }

  // Comprueba la máxima diferencia admisible de los importes 
  public void validarMaximaDiferenciaAdmisible() throws AppletException{
    BigDecimal totalPendiente = frameCobrarBelcenter.getTotalPendiente();
    BigDecimal montoMaximoDiferencia = frameCobrarBelcenter.getMontoMaximoDiferencia();
    
    if( totalPendiente != null && montoMaximoDiferencia != null ){
      if(Math.abs(totalPendiente.doubleValue()) > Math.abs(montoMaximoDiferencia.doubleValue())){
        //Genera una excepción con código de error: BEL-0014
        throw new AppletException(new Exception(), ConstantesApplet.BEL_0014);
      }
    }
  }

  public DTOMovimientoCaja crearDTOMovimientoCaja(){
    DTOMovimientoCaja dto = new DTOMovimientoCaja();
    dto.setOidPais(frameCobrarBelcenter.getOidPais());
    dto.setOidCaja(frameCobrarBelcenter.getOidCaja());
    dto.setOidSolicitudCabecera(frameCobrarBelcenter.getOidSolicitudCabecera());
    dto.setDiferenciaVuelto(frameCobrarBelcenter.getTotalPendiente());
    dto.setUsuario(this.userName);
    //dto.setUsuario(frameCobrarBelcenter.getIdUsuario());
    dto.setFecha( new java.sql.Date(System.currentTimeMillis()));
    dto.setOidCliente(frameCobrarBelcenter.getOidCliente());
    return dto;
  }

  public void grabarCobro() throws AppletException {
    DTOCobroBelcenter dto = new DTOCobroBelcenter();
    dto.setMovimientoCaja(this.crearDTOMovimientoCaja());
    dto.setMovimientoCajaDetalle(frameCobrarBelcenter.getMovimientosCaja());
    dto.setOidCanal(frameCobrarBelcenter.getOidCanal());
    dto.setOidAcceso(frameCobrarBelcenter.getOidAcceso());
    dto.setOidSubacceso(frameCobrarBelcenter.getOidSubacceso());
    dto.setTotalImporte(frameCobrarBelcenter.getTotalPagado());
    dto.setEnviarMensaje(Boolean.TRUE);
    dto.setContinuaFacturacion(Boolean.TRUE);
    dto.setOidPais(this.oidPais);    
  
    Communicator com = new Communicator();
    MareDTO mareDTO = com.ejecutarNegocio(url,
        "BELGrabarCobroBelcenter", 
        "es.indra.sicc.dtos.bel.DTOCobroBelcenter", 
        dto);
      
    /*DTOSalida dtos = (DTOSalida)com.ejecutarNegocio(url, 
      "BELGrabarCobroBelcenter", 
      "es.indra.sicc.dtos.bel.DTOCobroBelcenter", 
      dto);
      */
  
    frameCobrarBelcenter.setVisible(false);
  }

  public void cambiosVentas() throws AppletException {
    DTOCambiosVentas dto = new DTOCambiosVentas();
    dto.setOidPais(frameCobrarBelcenter.getOidPais());
    dto.setOidIdioma(this.frameCobrarBelcenter.getOidIdioma());
    
    //incidencia 14254 03/03/2005 (estos atributos no van)
    //dto.set !!!FALTA!!! oidCanal
    //dto.set !!!FALTA!!! oidAcceso
    
    dto.setOidSubacceso(frameCobrarBelcenter.getOidSubacceso());
    dto.setNumeroSolicitud(frameCobrarBelcenter.getNumeroSolicitud());
    dto.setSimulacion(Boolean.TRUE);

    Communicator com = new Communicator();
    DTOSalida dtos = null;
    
    if(!$DEBUG){
    
      //System.out.println("va a invocar");
      
      //dto.setProperty(ConstantesApplet.USER_NAME, this.userName);
      dto.setUserName(this.userName);
      MareDTO mareDTO = com.ejecutarNegocio(url,
        "BELCambiosVentasBelcenter", 
        "es.indra.sicc.dtos.bel.DTOCambiosVentas", 
        dto);
      if(mareDTO instanceof es.indra.sicc.comunapplet.dtos.applet.DTOSessionExpired) {
        this.frameCobrarBelcenter.setVisible(false); 
        return;
      } else {
        dtos = (DTOSalida) mareDTO;
      }
      //dtos = (DTOSalida)com.ejecutarNegocio(url, "BELCambiosVentasBelcenter", 
      //  "es.indra.sicc.dtos.bel.DTOCambiosVentas", dto);
        
      //System.out.println("paso...");
      //System.out.println("resultado: " + dtos);
      
      
    }

    //PropertiesApplet.setProperties(ConstantesBundlesApplet.APPLET_FRAMES_BUNDLE);
    FrameSimularCambiosVentas frameSCV = new FrameSimularCambiosVentas(
      PropertiesApplet.getPropertie(ConstantesFrames.FRAMES_SIMULAR_CAMBIOS_VENTAS, ConstantesBundlesApplet.APPLET_FRAMES_BUNDLE));
    
    if( dtos != null && dtos.getResultado() != null && !dtos.getResultado().esVacio() ){
      frameSCV.cargarTabla(dtos.getResultado());
    }


    frameSCV.setModal(true);
    frameSCV.setVisible(true);
    frameSCV.dispose();
  }

  public void notasPendientes() throws AppletException {
    DTOObtenerNotasCreditoPendientes dto = new DTOObtenerNotasCreditoPendientes();
    
    dto.setOidSubacceso(frameCobrarBelcenter.getOidSubacceso());
    dto.setOidCliente(frameCobrarBelcenter.getOidCliente());
    dto.setIndicadorSituacion(new Long(0));

    dto.setOidPais(this.getFrameCobrarBelcenter().getOidPais());

    Communicator com = new Communicator();
    DTOSalida dtos = null;
    
    if(!$DEBUG){
      MareDTO mareDTO = com.ejecutarNegocio(url,
        "BELObtenerNotasCreditoPendientes", 
        "es.indra.sicc.dtos.bel.DTOObtenerNotasCreditoPendientes", 
        dto);
      if(mareDTO instanceof es.indra.sicc.comunapplet.dtos.applet.DTOSessionExpired) {
        this.frameCobrarBelcenter.setVisible(false); 
        return;
      } else {
        dtos = (DTOSalida) mareDTO;
      }
    }

    //PropertiesApplet.setProperties(ConstantesBundlesApplet.APPLET_FRAMES_BUNDLE);
    FrameNotasCreditoPendientes frameNCP = new FrameNotasCreditoPendientes(
      PropertiesApplet.getPropertie(ConstantesFrames.FRAMES_NOTAS_CREDITO_PENDIENTES, ConstantesBundlesApplet.APPLET_FRAMES_BUNDLE));
    
    if(dtos != null && dtos.getResultado() != null && !dtos.getResultado().esVacio()){
      frameNCP.cargarTabla(dtos.getResultado());
    }
    
    frameNCP.setModal(true);    
    frameNCP.setVisible(true);
    frameNCP.dispose();
  }

  public void actualizarTotales(){
    BigDecimal tPagado = null;
    BigDecimal tPendiente = null;

    //this.frameCobrarBelcenter.lblTxtTotalPagado.setText((tPagado=frameCobrarBelcenter.getTotalPagado())!=null?tPagado.toString():"");
    //this.frameCobrarBelcenter.lblTxtTotalPendiente.setText((tPendiente=frameCobrarBelcenter.getTotalPendiente())!=null?tPendiente.toString():"");
    
//INCIDENCIA DBLG400000633: Redondear    

    tPagado=frameCobrarBelcenter.getTotalPagado();
    if (tPagado !=null)
        this.frameCobrarBelcenter.lblTxtTotalPagado.setText(tPagado.setScale(2,BigDecimal.ROUND_HALF_EVEN).toString());
    else
        this.frameCobrarBelcenter.lblTxtTotalPagado.setText("");
    
    tPendiente=frameCobrarBelcenter.getTotalPendiente();
    if (tPendiente!=null)
        this.frameCobrarBelcenter.lblTxtTotalPendiente.setText(tPendiente.setScale(2,BigDecimal.ROUND_HALF_EVEN).toString());
    else
        this.frameCobrarBelcenter.lblTxtTotalPendiente.setText("");
  }
  
  public static void main(String[] args){
  
    CobrarBelcenter cb = new CobrarBelcenter("http://cdos02ap:7777/sicc/ServletApplet", "USUARIO1", new Long(1));
    cb.getFrameCobrarBelcenter().show();
  
  }
  
  public FrameCobrarBelcenter getFrameCobrarBelcenter(){
    return frameCobrarBelcenter;
  }

  public String getUrl(){
    return url;
  }
  
  public void setUrl(String url){
    this.url = url;
  }
  
}