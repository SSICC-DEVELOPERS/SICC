package es.indra.sicc.ped.applet;

import es.indra.mare.common.dto.MareDTO;
import es.indra.sicc.bel.applet.componentes.CobrarBelcenter;
import es.indra.sicc.comunapplet.UtilApplet;
import es.indra.sicc.dtos.bel.DTOComprobarInicioCobro;
import es.indra.sicc.dtos.ped.DTOPosicionSolicitud;
import es.indra.sicc.dtos.ped.applet.DTOGenerarPosicionRegistro;
import es.indra.sicc.dtos.ped.applet.DTOInfoProducto;
import es.indra.sicc.dtos.ped.applet.DTOPresentarFlete;
import es.indra.sicc.dtos.ped.applet.DTORevertirPosicionRegistro;
import es.indra.sicc.dtos.ped.applet.DTOSolicitudesAnteriores;
import es.indra.sicc.dtos.ped.applet.DTOTiposSolicitud;
import es.indra.sicc.logicanegocio.ped.ConstantesPED;
import es.indra.sicc.ped.applet.componentes.FrameBuscarProducto;
import es.indra.sicc.ped.applet.componentes.FrameCodigosVenta;
import es.indra.sicc.ped.applet.componentes.FrameProductosAlternativos;
import es.indra.sicc.ped.applet.componentes.FrameSimularCuadreOfertas;
import es.indra.sicc.ped.applet.componentes.FrameSolicitudesAnteriores;
import es.indra.sicc.ped.applet.componentes.FramePresentarFlete;
import es.indra.sicc.comunapplet.Dialogos;
import es.indra.sicc.comunapplet.ConstantesApplet;
//import es.indra.sicc.ped.applet.util.ConstantesError;
import es.indra.sicc.dtos.pre.ConstantesPRE;

import es.indra.sicc.dtos.ped.DTOCabeceraSolicitud;

import es.indra.sicc.comunapplet.exceptions.AppletException;
import es.indra.sicc.util.DTOSalida;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Iterator;


public class DatosDetalle 
{
  private DTOInfoProducto dtoInfoProducto = null;
  private RegistroOnlineApplet applet;
  private FrameBuscarProducto frameBuscarProducto = null;
  private FrameCodigosVenta frameCodigosVenta = null;
  private FrameProductosAlternativos frameProductosAlternativos = null;
  private FrameSolicitudesAnteriores frameSolicitudesAnteriores = null;
  private FramePresentarFlete framePresentarFlete = null;
  private CobrarBelcenter  cobrarBelcenter=null;
  public DatosDetalle(RegistroOnlineApplet applet){
    this.applet = applet;
  }

  public void btnAnyadirClick()
  {
    if(applet.txtCodVenta.getText() == null || 
        applet.txtCodVenta.getText().trim().equals("") ) {
          
        Dialogos.mensajeError(ConstantesApplet.ERROR_FALTA_COMPLETAR_CAMPO_OBLIGATORIO, this.applet);
        applet.txtCodVenta.requestFocus();
        return;
    }
        
    if(applet.txtUnidDemandadas == null || 
        applet.txtUnidDemandadas.getText().trim().equals("") ){
      
        Dialogos.mensajeError(ConstantesApplet.ERROR_FALTA_COMPLETAR_CAMPO_OBLIGATORIO, this.applet);
        applet.txtUnidDemandadas.requestFocus();      
        return;
    }
    
    try {
      if(this.dtoInfoProducto == null) {
        Dialogos.mensajeError(ConstantesApplet.ERROR_FALTA_COMPLETAR_CAMPO_OBLIGATORIO, this.applet);
        return;
      }
      addFila();
    } catch (AppletException e) {
      e.printStackTrace();
      //Dialogos.mensajeError(e.getCode(), this.applet);
      UtilApplet.procesarError(e, this.applet);
    }
  }

  public void txtCodVentaOnChange() 
  {
    
    if(!"".equals(this.applet.txtCodVenta.getText().trim())) {
      try {
        DTOCabeceraSolicitud dtoCabecera = this.applet.getDTOCabeceraSolicitud();
        DTOInfoProducto dtoInfo = new DTOInfoProducto();
                        
        dtoInfo.setAcceso(dtoCabecera.getAcceso());
        dtoInfo.setSubacceso(dtoCabecera.getSubacceso());
        dtoInfo.setPeriodo(dtoCabecera.getPeriodo());
        dtoInfo.setCodigoVenta(applet.txtCodVenta.getText());
        dtoInfo.setOidPais(this.applet.getOidPais());
        
        MareDTO mareDTO = this.applet.ejecutarNegocio(
                "PEDValidarCVRegistro", 
                "es.indra.sicc.dtos.ped.applet.DTOInfoProducto", 
                dtoInfo);
        
        if( mareDTO instanceof DTOInfoProducto ){
          this.dtoInfoProducto = (DTOInfoProducto) mareDTO;
          applet.txtCodProducto.setText(this.dtoInfoProducto.getCodigoProducto());
          applet.lbDesc.setText(dtoInfoProducto.getDescripcionProducto());      
          
          
          this.applet.txtUnidDemandadas.setEditable(true);
          this.applet.txtUnidDemandadas.setText("1");
          //this.applet.txtUnidDemandadas.requestFocus();
        }else{        
          //this.dtoInfoProducto = null;
          
          Dialogos.mensajeError(ConstantesApplet.ERROR_CODIGO_VENTA_NO_EXISTE_O_NO_DIGITABLE, this.applet);
          
          this.applet.txtUnidDemandadas.setEditable(false);
          this.applet.txtUnidDemandadas.setText("1");          
          
        }
      } catch (AppletException e) {
        e.printStackTrace();
        UtilApplet.procesarError(e, this.applet);
        //Dialogos.mensajeError(e.getCode(), this.applet);
      }
    }  
  }

  public void txtCodProductoOnChange() {
    System.out.println("txtCodProductoOnChange()");  
    if(!"".equals(this.applet.txtCodProducto.getText().trim())) {
      if(this.dtoInfoProducto == null) {
        this.dtoInfoProducto = new DTOInfoProducto();
      }
      //this.dtoInfoProducto = new DTOInfoProducto();
      dtoInfoProducto.setCodigoProducto(this.applet.txtCodProducto.getText());
      dtoInfoProducto.setOidMarca(this.applet.dtoCabeceraSolicitud.getMarca());
      dtoInfoProducto.setDescripcionMarca(this.applet.lbMarca.getText());
      dtoInfoProducto.setAcceso(this.applet.dtoCabeceraSolicitud.getAcceso());
      dtoInfoProducto.setSubacceso(this.applet.dtoCabeceraSolicitud.getSubacceso());
      dtoInfoProducto.setPeriodo(this.applet.dtoCabeceraSolicitud.getPeriodo());
      dtoInfoProducto.setOidIdioma(this.applet.getOidIdioma());
      dtoInfoProducto.setOidPais(this.applet.getOidPais());
      dtoInfoProducto.setIndicadorSituacion(new Long(0));
      dtoInfoProducto.setTamanioPagina(this.applet.cache.getTamPagina());

  
      try {
        MareDTO mareDTO = this.applet.ejecutarNegocio(
            "PEDValidarCPRegistro" , 
            "es.indra.sicc.dtos.ped.applet.DTOInfoProducto", 
            dtoInfoProducto);
        
        String cod;
        String desc;
        
        if (mareDTO instanceof DTOInfoProducto) {
               dtoInfoProducto = (DTOInfoProducto) mareDTO;
           
               if (dtoInfoProducto.getListaProductos().getRowCount() == 1) {
                   cod = dtoInfoProducto.getListaProductos().getValueAt(0,"VAL_CODI_VENT").toString();
                   desc = dtoInfoProducto.getListaProductos().getValueAt(0,"VAL_TEXT_BREV").toString();
               }
               else {   
              
                  this.seleccionarCodigoVenta(); 
                /* Se bloquea hasta ocultar la ventana CodigosVenta */ 
              
                  cod = this.frameCodigosVenta.getCodVenta();
                  desc = this.frameCodigosVenta.getDescripcion();
                  
              }    
              
              this.applet.txtCodVenta.setText(cod);
              this.applet.lbDescripcion.setText(desc);
                  
              //y actualizamos DTOInfoProducto con: 
              this.dtoInfoProducto.setCodigoVenta(this.applet.txtCodVenta.getText());
              this.dtoInfoProducto.setDescripcionProducto(this.applet.lbDescripcion.getText());      
              this.applet.txtUnidDemandadas.setText("");
              this.applet.txtUnidDemandadas.setEnabled(true);
              this.applet.txtUnidDemandadas.requestFocus();
               
        } 
        else { 
          this.applet.txtUnidDemandadas.setText("");
          this.applet.txtUnidDemandadas.setEnabled(false);
          
          this.applet.txtCodVenta.requestFocus();
        }
      }catch (AppletException e) {
        //Dialogos.mensajeError(e.getCode(), this.applet);
        UtilApplet.procesarError(e, this.applet);
      }
    }
  }
  
  private boolean validarNumeroUnidades() {
    boolean numeroValido = true;
    String numero = this.applet.txtUnidDemandadas.getText().trim();    
    try {
      Long.parseLong(numero);
    } catch (NumberFormatException e) {
      numeroValido = false;
    }
    return numeroValido;
  }
  // Se ejecuta al modificar las unidades demandadas 
  public void txtUniDemandadasOnChange() 
  {
    System.out.println("txtUniDemandadasOnChange()");
    if(!"".equals(this.applet.txtUnidDemandadas.getText().trim())) {
      if(!this.validarNumeroUnidades()) {
        Dialogos.mensajeError(ConstantesApplet.ERROR_DATOS_INVALIDOS, this.applet);  

        this.applet.txtUnidDemandadas.setText("");
        this.applet.txtUnidDemandadas.requestFocus();
        return;
      }
      if("".equals(this.applet.txtCodVenta.getText().trim()) &&
        "".equals(this.applet.txtCodProducto.getText().trim()) ) {
          Dialogos.mensajeError(ConstantesApplet.ERROR_FALTA_CODIGO_VENTA_PRODUCT, this.applet);
          this.applet.txtCodVenta.requestFocus();  
          return;
        }
      try {
        //this.dtoInfoProducto = new DTOInfoProducto(); 
        this.dtoInfoProducto.setOidCliente(this.applet.dtoCabeceraSolicitud.getOidCliente());
        this.dtoInfoProducto.setOidZona(this.applet.dtoCabeceraSolicitud.getZona());
        this.dtoInfoProducto.setOidAlmacen(this.applet.dtoCabeceraSolicitud.getAlmacen());
        Integer unidDemandadas = null;
        try {
          unidDemandadas = new Integer(this.applet.txtUnidDemandadas.getText());
        } catch (NumberFormatException e) {
          unidDemandadas = new Integer(0);
        }
        this.dtoInfoProducto.setUnidadesDemandadas(unidDemandadas); 
        this.dtoInfoProducto.setOidPais(this.applet.getOidPais());
    
        // Obtiene la información del stock del producto 
        MareDTO mareDTO = this.applet.ejecutarNegocio(
                  "PEDObtenerInfoGestionStock" , 
                  "es.indra.sicc.dtos.ped.applet.DTOInfoProducto",
                  this.dtoInfoProducto);
        if (mareDTO instanceof DTOInfoProducto) {
          // Guarda en caché el control de stock 
          this.dtoInfoProducto = (DTOInfoProducto)mareDTO;
          this.applet.cache.setControlStock(this.dtoInfoProducto.getControlStock()); 
      
          if (this.dtoInfoProducto.getStockDisponible() != null 
             && this.dtoInfoProducto.getStockDisponible().longValue() <= 0) {
            
            //Incidencia DBLG400000299
            Dialogos.mensajeError(ConstantesApplet.UIPED041 , this.applet);
            //Fin Incidencia DBLG400000299
            
            this.buscarProductoAlternativo(); 
            
            if(this.frameProductosAlternativos.getHuboProductosAlternativos()) {
              //Actualiza el campo txtcodVenta con valor seleccionado en ProductosAlternativos.productos 
              String codAux = this.frameProductosAlternativos.getCodVenta();
              if(!"".equals(codAux)) {
                this.applet.txtCodVenta.setText(codAux);
                this.txtCodVentaOnChange();
              }
            
            } else {
             //Incidencia DBLG400000394   
              this.applet.txtCodVenta.setText("");
              this.applet.txtCodProducto.setText("");
              //this.applet.lbDescripcion.setText("");
              this.applet.lbDesc.setText("");
              this.applet.txtUnidDemandadas.setText("");
              this.applet.lbStockDisponibleCantidad.setText("");
        
              this.applet.lbLimiteVentaCantidad.setText(""); 
              this.applet.lbControlLiqCantidad.setText(""); 
              this.applet.lbReservaCantidad.setText(""); 
              this.applet.chkDemandaNoAtendida.setSelected(false); 
              this.applet.atxObservacionesDatosDetalle.setText(""); 
              //Fin Incidencia DBLG400000394  
            }
          } else { 
            //Actualiza en pantalla los campos: 
            Long aux = this.dtoInfoProducto.getStockDisponible();
            this.applet.lbStockDisponibleCantidad.setText((aux != null ? aux.toString() : ""));
            
            //Se setean las unidades demandadas nuevamente porque pudieron haber cambiado, 
            //debido a que el disponible era menor a lo que se pidio
            //System.out.println("AUX es: " + aux);
            this.applet.txtUnidDemandadas.setText(this.dtoInfoProducto.getUnidadesDemandadas().toString());
            
            aux = this.dtoInfoProducto.getLimiteVenta();
            this.applet.lbLimiteVentaCantidad.setText(aux != null ? aux.toString() : "");
    
            Boolean aux2 = this.dtoInfoProducto.getControlLiquidacion();
            //this.applet.lbControlLiqCantidad.setText((aux2 != null ? aux2.toString() : ""));
            if (aux2 == null || aux2.booleanValue() == false) {
              this.applet.lbControlLiqCantidad.setText( ConstantesPRE.NO);
            } else {
              this.applet.lbControlLiqCantidad.setText( ConstantesPRE.SI);
            }
            
            Integer aux3 = this.dtoInfoProducto.getCantidadReservar();
            this.applet.lbReservaCantidad.setText(aux3 != null ? aux3.toString() : "");
          }
        } else {
          Dialogos.mensajeError(ConstantesApplet.ERROR_DATOS_INVALIDOS, this.applet);
          return;
        }
      } catch (AppletException e) {
        //Dialogos.mensajeError(e.getCode(), this.applet);
        UtilApplet.procesarError(e, this.applet);
      }
    }
  }

  public void addFila() throws AppletException {
    
    // Genera una posición en la solicitud 
    DTOPosicionSolicitud dtoPosicionSolicitud = crearDTOPosicionSolicitud();
    //System.out.println("////////////////////////////////////////");
    //System.out.println("dtoPosicionSolicitud: " + dtoPosicionSolicitud);
    //System.out.println("////////////////////////////////////////");
      if(this.applet.dtoCabeceraSolicitud.getPosiciones() == null ) {
        this.applet.dtoCabeceraSolicitud.setPosiciones(new ArrayList());
      }
      this.applet.dtoCabeceraSolicitud.getPosiciones().add(dtoPosicionSolicitud);
      this.applet.dtoCabeceraSolicitud.setOK(Boolean.TRUE);
      //DBLG400000397 - dmorello, 22/02/2006
      this.applet.dtoCabeceraSolicitud.setIndicadorDigitacion(Boolean.TRUE);

    DTOGenerarPosicionRegistro dtoGenerarPosicionRegistro = new DTOGenerarPosicionRegistro();
    dtoGenerarPosicionRegistro.setCabeceraSolicitud(this.applet.dtoCabeceraSolicitud);
    if(this.dtoInfoProducto != null && this.dtoInfoProducto.getCantidadReservar() != null) {
      dtoGenerarPosicionRegistro.setCantidadReservar(new Long(this.dtoInfoProducto.getCantidadReservar().longValue())); 
    } else {
      dtoGenerarPosicionRegistro.setCantidadReservar(new Long(0));
    }

    MareDTO mareDTO = this.applet.ejecutarNegocio(
              "PEDGenerarPosicionRegistro" , 
              "es.indra.sicc.dtos.ped.applet.DTOGenerarPosicionRegistro", 
              dtoGenerarPosicionRegistro);
    
    if(mareDTO instanceof DTOCabeceraSolicitud) {
      this.applet.dtoCabeceraSolicitud = (DTOCabeceraSolicitud)mareDTO;
      
      if (Boolean.TRUE.equals(this.applet.dtoCabeceraSolicitud.getOK())) {
        String demandaNoAtendida = null;
        if (this.applet.chkDemandaNoAtendida.isSelected()) {
          demandaNoAtendida = ConstantesPRE.SI;
        } else {
          demandaNoAtendida = ConstantesPRE.NO;
        }
        
      String controlLiquidacion = null;
      Boolean aux = this.dtoInfoProducto.getControlLiquidacion();
      if (aux == null || aux.booleanValue() == false) {
         controlLiquidacion = ConstantesPRE.NO;
      } else {
        controlLiquidacion = ConstantesPRE.SI;
      }
  
        this.applet.tablaDetalle.addFila(
                dtoInfoProducto.getCodigoProducto(),
                dtoInfoProducto.getCodigoVenta(),
                controlLiquidacion,
                demandaNoAtendida, 
                (dtoInfoProducto.getLimiteVenta() == null ? "" : dtoInfoProducto.getLimiteVenta().toString()),
                dtoInfoProducto.getDescripcionProducto(),
                this.applet.atxObservacionesDatosDetalle.getText(),
                (dtoInfoProducto.getCantidadReservar() == null ? "" : dtoInfoProducto.getCantidadReservar().toString()),
                (dtoInfoProducto.getStockDisponible() == null ? "" : dtoInfoProducto.getStockDisponible().toString()),
                (dtoPosicionSolicitud.getUnidadesDemandaReal() == null ? "" : dtoPosicionSolicitud.getUnidadesDemandaReal().toString()),
                (dtoPosicionSolicitud.getUnidadesDemandadas() == null ? "" : dtoPosicionSolicitud.getUnidadesDemandadas().toString()),
                (dtoPosicionSolicitud.getUnidadesPorAtender() == null ? "" : dtoPosicionSolicitud.getUnidadesPorAtender().toString())
              );
        this.dtoInfoProducto = null;
        
        this.applet.txtCodVenta.setText("");
        this.applet.txtCodProducto .setText("");
        this.applet.lbDesc.setText("");
        this.applet.txtUnidDemandadas.setText(""); 
        this.applet.lbStockDisponibleCantidad.setText(""); 
        this.applet.lbLimiteVentaCantidad.setText(""); 
        this.applet.lbControlLiqCantidad.setText(""); 
        this.applet.lbReservaCantidad.setText(""); 
        this.applet.chkDemandaNoAtendida.setSelected(false); 
        this.applet.atxObservacionesDatosDetalle.setText(""); 
        
        // Realiza la reserva de almacén para la posición
        reservarAlmacen();
        
        // Guarda el número de movimiento en caché 
        this.applet.cache.setNumeroMovimiento(dtoGenerarPosicionRegistro.getNumeroMovimiento());

      } else {
        // La posición no es correcta. La elimina. 
        Dialogos.mensajeError(ConstantesApplet.ERROR_POSICION_INVALIDA, this.applet);
        this.applet.dtoCabeceraSolicitud.getPosiciones().remove(this.applet.dtoCabeceraSolicitud.getPosiciones().size() - 1);        
      }
    } else {
      this.applet.dtoCabeceraSolicitud.getPosiciones().remove(this.applet.dtoCabeceraSolicitud.getPosiciones().size() - 1);
      Dialogos.mensajeError(ConstantesApplet.ERROR_GENERACION_POSICION, this.applet);
    }    
  }

  //Comprueba que se ha seleccionado al menos una fila 
  public void btnEliminarClick()
  {
    System.out.println("dtoCabeceraSolicitud antes de eliminar: " + this.applet.dtoCabeceraSolicitud);
    if(this.applet.tablaDetalle.getSelectedRowCount() == 0) {
      Dialogos.mensajeAceptar(ConstantesApplet.GEN_UIGEN0004, this.applet);      
    } else { 
      // Revierte la asignación de stock asignada a las lineas 
      this.revertirAlmacen(Boolean.FALSE);
      
      System.out.println("dtoCabeceraSolicitud luego de revertirAlmacen: "
                            + this.applet.dtoCabeceraSolicitud);
      
      //Elimina de la tabla las filas seleccionadas 
      int[] filasSeleccionadas = this.applet.tablaDetalle.getSelectedRows();
      for(int i = 0; i < filasSeleccionadas.length; ++i) {
        this.applet.tablaDetalle.deleteRow(filasSeleccionadas[i]);
        // DBLG400000397 dmorello 4/4/2006: Remover fila nº filasSeleccionadas[i] y no i
        this.applet.dtoCabeceraSolicitud.getPosiciones().remove(filasSeleccionadas[i]);
      }
      // DBLG400000397 - dmorello, 06/04/2006: Se renumeran las posiciones
      this.recalcularPosiciones();
      
      if(this.applet.tablaDetalle.getRowCount() == 0) {
        this.applet.tablaDetalle.newRow();
      }
    } 
    System.out.println("dtoCabeceraSolicitud luego de eliminar: " + this.applet.dtoCabeceraSolicitud);
  }

  
  public void btnGuardarClick()
  {
    System.out.println("dtoCabeceraSolicitud al guardar: "
                        + this.applet.dtoCabeceraSolicitud);
    
    boolean hayPosicionesNoAnuladas = false;
    //Comprueba que se ha añadido alguna posición a la solicitud no anulada 
    //(campo demandaNoAtendida == ConstantesPRE.NO) 
    for (int i = 0; i < this.applet.tablaDetalle.getRowCount() && !hayPosicionesNoAnuladas; i++) {
      String aux = this.applet.tablaDetalle.colDemandaNoAtendida.getText(i);
      if(ConstantesPRE.NO.equals(aux)) {
        hayPosicionesNoAnuladas = true;
      }
    }
    
    if(!hayPosicionesNoAnuladas) {
      Dialogos.mensajeError(ConstantesApplet.UIPED031, this.applet);
    } else { 
      if (Dialogos.mensajeSINO(ConstantesApplet.MSG_CONFIRMACION, this.applet, false)) {
        try {
          if(Boolean.TRUE.equals(this.applet.dtoCabeceraSolicitud.getOK())) {
            this.applet.dtoCabeceraSolicitud.setEstado(ConstantesPED.ESTADO_SOLICITUD_VALIDADO);
          } else {
            this.applet.dtoCabeceraSolicitud.setEstado(ConstantesPED.ESTADO_SOLICITUD_ERRONEO);
          }
          this.grabarSolicitud(); 
        } catch (AppletException e) {
          //Dialogos.mensajeError(ConstantesApplet.ERROR_AL_GUARDAR_SOLICITUD, this.applet);
          System.out.println("AppletException e" + e + this.applet);
          UtilApplet.procesarError(e, this.applet);
          return;
        }
        
        // Actualizamos los valores de la caché 
        this.applet.cache.setUltimoPeriodo(new Long(this.applet.cbPeriodo.getKey()));
        this.applet.cache.setUltimoTipoSolicitud(new Long(this.applet.cbTipoSolicitud.getKey()));
        
        if(Boolean.TRUE.equals(this.applet.cache.getBelcenter())) {
          // Muestra la ventana de cobro 
          this.cobrarBelcenter();

          // Reinicia la solicitud 
          this.applet.reiniciar();          
        } else {
          // Muestra mensaje con número de solicitud
          Dialogos.mensajeAceptar(ConstantesApplet.UIPED034, " " + applet.dtoCabeceraSolicitud.getNumeroSolicitud(), this.applet);
          try {
              this.applet.ejecutarWeb("cerrarVentana", "");
              this.applet.stop();
              this.applet.destroy();
          } catch (AppletException e) {
          } 
          
        } 
      } 
    }   
  }

  public void grabarSolicitud() throws AppletException
  {
    MareDTO mareDTO = this.applet.ejecutarNegocio(
              "PEDGrabarSolicitudOnline", 
              "es.indra.sicc.dtos.ped.DTOCabeceraSolicitud",
              this.applet.dtoCabeceraSolicitud
              );
              
    if(mareDTO instanceof DTOCabeceraSolicitud) {
      this.applet.dtoCabeceraSolicitud = (DTOCabeceraSolicitud)mareDTO;
    }
  }

  //Limpia todos los campos de detalle pero no inicializa la lista de posiciones
  public void limpiarDetalle()
  {
    this.applet.lbCodClienteDetalle.setText("");
    this.applet.lbNombreDetalle.setText("");
    this.applet.lbApellidosDetalle.setText("");
    this.applet.lbLineaDispDetalle.setText("");
    this.applet.lbFormaPagoDetalle.setText("");
    this.applet.txtCodVenta.setText("");
    this.applet.txtCodProducto.setText("");
    this.applet.txtUnidDemandadas.setText("");
    this.applet.lbStockDisponibleCantidad.setText("");
    this.applet.lbControlLiqCantidad.setText("");
    this.applet.chkDemandaNoAtendida.setSelected(false);
    this.applet.lbReservaCantidad.setText("");
    this.applet.atxObservacionesDatosDetalle.setText("");
  }

  public void buscarProductoAlternativo()
  {
    MareDTO mareDTO = null;
    try {
      mareDTO = this.applet.ejecutarNegocio(
              "PEDBuscarAlternativosRegistro" , 
              "es.indra.sicc.dtos.ped.applet.DTOInfoProducto",
              this.dtoInfoProducto);
    } catch (AppletException e) 
    {
      //Muestra el mensaje de error y llama a limpiarDetalle       
        //Dialogos.mensajeError(e.getCode(), this.applet);
      UtilApplet.procesarError(e, this.applet);
      this.limpiarDetalle();
      return;
    }
    
    if( mareDTO instanceof DTOSalida) {
      DTOSalida dtos = (DTOSalida) mareDTO;
      if (this.frameProductosAlternativos == null) 
      {
        this.frameProductosAlternativos = new FrameProductosAlternativos("Buscar productos alternativos", this.applet);
      }
      this.frameProductosAlternativos.cargarTabla(dtos.getResultado());
      this.frameProductosAlternativos.setModal(true);
      this.frameProductosAlternativos.show();     
      
    } else {
      Dialogos.mensajeError(ConstantesApplet.ERROR_DE_SERVIDOR, this.applet);
      return;
    }
  }

  // Muestra la lista de productos 
  public void seleccionarCodigoVenta()
  {
    //if (this.frameCodigosVenta == null) {
        this.frameCodigosVenta = new FrameCodigosVenta("Seleccionar código de venta", this.applet, this.dtoInfoProducto.getListaProductos(), this.dtoInfoProducto);        
   // }
    //this.frameCodigosVenta.cargarTabla();
    this.frameCodigosVenta.setModal(true);
    this.frameCodigosVenta.show();
  }

  public void btnBuscarProductoClick()
  {
    //if(this.frameBuscarProducto == null) {
      this.frameBuscarProducto = new FrameBuscarProducto("Buscar Producto", this.applet);      
    //}

    this.frameBuscarProducto.cargaInicial();
    this.frameBuscarProducto.setModal(true);
    this.frameBuscarProducto.setVisible(true);
  
    this.applet.txtCodVenta.setText(this.frameBuscarProducto.getCodVenta());
    this.frameBuscarProducto.dispose();
    this.txtCodVentaOnChange();
  }

  // Buscar solicitudes anteriores 
  public void btnBuscarSolicitudesAnterioresClick()
  {
    //DTOOID dtoId = new DTOOID();
    //dtoId.setOid(this.applet.dtoDatosCliente.getOidCliente());
    DTOSolicitudesAnteriores dtos = new  DTOSolicitudesAnteriores();
    dtos.setOidCliente(this.applet.dtoDatosCliente.getOidCliente());
    dtos.setTamanioPagina(this.applet.cache.getTamPagina());
    dtos.setIndicadorSituacion(new Long(0));
    dtos.setOidIdioma(this.applet.oidIdioma);
    
    try {
      MareDTO mareDTO = this.applet.ejecutarNegocio(
              "PEDObtenerSolicitudesAnteriores" , 
              "es.indra.sicc.dtos.ped.applet.DTOSolicitudesAnteriores",
              dtos);
      
      if(mareDTO instanceof DTOSalida) {
        DTOSalida dtoSalida = (DTOSalida) mareDTO;
        if(dtoSalida.getResultado() == null || dtoSalida.getResultado().esVacio()) {
          Dialogos.mensajeAceptar(ConstantesApplet.UIPED033, this.applet);
          return;
        } else { 
          DTOSolicitudesAnteriores dtoe = new DTOSolicitudesAnteriores();
          dtoe.setOidCliente(this.applet.dtoDatosCliente.getOidCliente());
          dtoe.setTamanioPagina(this.applet.cache.getTamPagina());
          dtoe.setIndicadorSituacion(new Long(0));
          dtoe.setOidIdioma(this.applet.oidIdioma);
            
          //if (this.frameSolicitudesAnteriores == null) {
            this.frameSolicitudesAnteriores = new FrameSolicitudesAnteriores(
                  this.applet, "Buscar solucitudes anteriores",
                  dtoSalida.getResultado(),
                  dtoe);
          //}
          //this.frameSolicitudesAnteriores.cargarTabla(dtoSalida.getResultado());
          this.frameSolicitudesAnteriores.setModal(true);
          this.frameSolicitudesAnteriores.show();
          
          /* Se bloquea hasta que se oculta la ventana modal */ 
  
          if( Boolean.FALSE.equals(this.frameSolicitudesAnteriores.getContinuar()))
          { 
            // Reinicia la solicitud 
            this.applet.reiniciar();
          } else { 
            //Cierra la ventana ProductosAlternativos 
            this.frameSolicitudesAnteriores.dispose();
          } 
          
        } 
      } else {
        Dialogos.mensajeError(ConstantesApplet.ERROR_DE_SERVIDOR, this.applet);
        return;
      }
    }catch (AppletException e) {
        //Dialogos.mensajeError(e.getCode(), this.applet);
        UtilApplet.procesarError(e, this.applet);
      return;
    }
  }

  public void btnPresentarFlete()
  {
    DTOPresentarFlete dtoFlete = new DTOPresentarFlete(); 
    dtoFlete.setOidMarca(this.applet.dtoCabeceraSolicitud.getMarca());
    dtoFlete.setOidCanal(this.applet.dtoCabeceraSolicitud.getCanal());
    dtoFlete.setOidPeriodo(this.applet.dtoCabeceraSolicitud.getPeriodo());
    dtoFlete.setOidCliente(this.applet.dtoCabeceraSolicitud.getOidCliente());
    dtoFlete.setOidTipoDespacho(this.applet.dtoCabeceraSolicitud.getTipoDespacho());
    dtoFlete.setOidZona(this.applet.dtoCabeceraSolicitud.getZona());
    dtoFlete.setOidUbigeo(this.applet.dtoCabeceraSolicitud.getUbigeo());
    dtoFlete.setOidTipoCliente(this.applet.dtoCabeceraSolicitud.getTipoCliente());
    dtoFlete.setOidSubtipoCliente(this.applet.dtoCabeceraSolicitud.getSubtipoCliente());
    dtoFlete.setOidPais(this.applet.getOidPais());
    dtoFlete.setOidIdioma(this.applet.getOidIdioma());
    dtoFlete.setTamanioPagina(this.applet.cache.getTamPagina());
    dtoFlete.setIndicadorSituacion(new Long(0));
    
    try {
      MareDTO mareDTO = this.applet.ejecutarNegocio(
                "PEDObtenerFleteRegistro" , 
                "es.indra.sicc.dtos.ped.applet.DTOPresentarFlete",
                dtoFlete);
      if(mareDTO instanceof DTOSalida) {
        DTOSalida dtos = (DTOSalida) mareDTO;
        if(dtos.getResultado() == null || dtos.getResultado().esVacio()) {
          Dialogos.mensajeAceptar(ConstantesApplet.PED_040, this.applet);
        } else { 
          //if(this.framePresentarFlete == null) {
            this.framePresentarFlete = new FramePresentarFlete("Presentar flete", 
                                          dtos.getResultado(), 
                                          dtoFlete,
                                          this.applet);  
          //}
          
          //this.framePresentarFlete.cargarTabla(dtos.getResultado());
          /*
           * DBLG400000403 - dmorello, 24/02/2006
           * Se carga la tabla con los valores obtenidos de la BD.
           */
          this.framePresentarFlete.cargarTabla();
          this.framePresentarFlete.setModal(true);
          this.framePresentarFlete.show();
          /* Se bloquea hasta que se oculta la ventana modal */   
          this.framePresentarFlete.dispose();
        } 
      } else {
        Dialogos.mensajeError(ConstantesApplet.ERROR_DE_SERVIDOR, this.applet);
        return;
      }
    } catch (AppletException e) {
      e.printStackTrace();
        //Dialogos.mensajeError(e.getCode(), this.applet);
        UtilApplet.procesarError(e, this.applet);
      return;      
    }
  }

  public DTOPosicionSolicitud crearDTOPosicionSolicitud()
  { 
    DTOPosicionSolicitud dto = new DTOPosicionSolicitud(); 
    dto.setCodigoVenta(this.dtoInfoProducto.getCodigoVenta());
    dto.setOidProducto(this.dtoInfoProducto.getOidProducto());
    if (this.dtoInfoProducto.getUnidadesDemandadas() != null) {
      dto.setUnidadesDemandadas(new Long(this.dtoInfoProducto.getUnidadesDemandadas().intValue()));
    }
    dto.setUnidadesPorAtender(new Long(this.dtoInfoProducto.getUnidadesDemandaReal() != null ? this.dtoInfoProducto.getUnidadesPorAtender().intValue() :  0));
    dto.setUnidadesDemandaReal(new Long(this.dtoInfoProducto.getUnidadesDemandaReal() != null ? this.dtoInfoProducto.getUnidadesDemandaReal().intValue() : 0));
    //dto.setCodigoProducto(this.dtoInfoProducto.getCodigoProducto());
    //dto.setDescripcionProducto(this.dtoInfoProducto.getDescripcionProducto());
    //dto.setDescripcionFormaPago(this.dtoInfoProducto.getDescripcionProducto());
    
    dto.setOK(Boolean.TRUE);
    
    return dto;
  }

  public void reservarAlmacen()
  {
    
//Se recupera de cache el DTOTiposSolicitud correspondiente a DTOCabeceraSolicitud.tipoSolicitud 
    DTOTiposSolicitud[] dtos = this.applet.cache.getTiposSolicitud();
    DTOTiposSolicitud dtoTipoSolicitud = null;
    boolean seguir = true;
    for (int i = 0; i < dtos.length && seguir; ++i) {
      if(this.applet.dtoCabeceraSolicitud.getTipoSolicitud().equals(dtos[i].getOidTipoSolicitud())) {
        dtoTipoSolicitud = dtos[i];
        seguir = false;
      }
    }

    if(dtoTipoSolicitud != null  && Boolean.TRUE.equals(dtoTipoSolicitud.getReservaStock())) {
      DTOGenerarPosicionRegistro dtoPosicio = new DTOGenerarPosicionRegistro();
      dtoPosicio.setCabeceraSolicitud(this.applet.dtoCabeceraSolicitud);
      Long reserva = null;
      if("".equals(this.applet.lbReservaCantidad.getText().trim())) {
        reserva = new Long(0);
      } else {
        reserva = new Long(this.applet.lbReservaCantidad.getText().trim());
      }
      dtoPosicio.setCantidadReservar(reserva);
      
      dtoPosicio.setNumeroMovimiento(this.applet.cache.getNumeroMovimiento());
      dtoPosicio.setControlStock(this.applet.cache.getControlStock());

      try {
        
        MareDTO mareDTO = this.applet.ejecutarNegocio(
                "PEDReservarAlmacenRegistro" , 
                "es.indra.sicc.dtos.ped.applet.DTOGenerarPosicionRegistro",
                dtoPosicio );
  
        if(mareDTO instanceof DTOGenerarPosicionRegistro) {
          // Actualiza el valor de la columna cantidad a reservar para la nueva posición en la lista 
          dtoPosicio = (DTOGenerarPosicionRegistro) mareDTO;
          this.applet.lbReservaCantidad.setText(dtoPosicio.getCantidadReservar().toString()); 
          this.dtoInfoProducto.setCantidadReservar(new Integer(dtoPosicio.getCantidadReservar().intValue()));
          
          
        } else {
          Dialogos.mensajeError(ConstantesApplet.ERROR_DE_SERVIDOR, this.applet);
          return;
        }
      } catch(AppletException e) {
        e.printStackTrace();
        //Dialogos.mensajeError(e.getCode(), this.applet);
        UtilApplet.procesarError(e, this.applet);
      }
    }   
  }

  public void revertirAlmacen(Boolean completo)
  {
    DTOTiposSolicitud[] dtos = this.applet.cache.getTiposSolicitud();
    DTOTiposSolicitud dtoTipoSolicitud = null;
    boolean seguir = true;
    for (int i = 0; i < dtos.length && seguir; ++i) {
      if(this.applet.dtoCabeceraSolicitud.getTipoSolicitud().equals(dtos[i].getOidTipoSolicitud())) {
        dtoTipoSolicitud = dtos[i];
        seguir = false;
      }
    }

    if(dtoTipoSolicitud != null && 
      Boolean.TRUE.equals(dtoTipoSolicitud.getReservaStock())) {
        ArrayList posicionesRevertir = null;
        if( Boolean.FALSE.equals(completo)) {
          //Crear un ArrayList posicionesRevertir con el número de fila de las //
          //posiciones seleccionadas en pantalla (comenzando en 1) 
          posicionesRevertir = new ArrayList(this.applet.tablaDetalle.getSelectedRowCount());
          int []posiciones = this.applet.tablaDetalle.getSelectedRows();
          
          for (int i = 0; i < posiciones.length; i++) {
            posicionesRevertir.add(1,new Integer( posiciones[i] + 1));
          }
        }
        
        System.out.println("posicionesRevertir: " + posicionesRevertir);

        DTORevertirPosicionRegistro dtoRevertir = new DTORevertirPosicionRegistro();
        dtoRevertir.setCabeceraSolicitud(this.applet.dtoCabeceraSolicitud);
        dtoRevertir.setPosicionesRevertir(posicionesRevertir);
        
        System.out.println("dtoRevertir: " + dtoRevertir);
        
        // Revierte el almacén y actualiza el DTOCabeceraSolicitud actual con el que se recibe de la llamada 
        try {
          this.applet.ejecutarNegocio("PEDRevertirAlmacenRegistro" , 
                                    "es.indra.sicc.dtos.ped.applet.DTORevertirPosicionRegistro", 
                                    dtoRevertir);
        } catch (AppletException e) {
          e.printStackTrace();
        //Dialogos.mensajeError(e.getCode(), this.applet);
          UtilApplet.procesarError(e, this.applet);
        }
    }   
  }
  
  /*
   * Autor: Cortaberria
   * Fehca: 13/05/2005
   * Modificación pedida en incidencia 17879
   */
  public void cobrarBelcenter() {
    DTOComprobarInicioCobro dtoCobro = new DTOComprobarInicioCobro();
    dtoCobro.setOidPais(this.applet.getOidPais()); 
    dtoCobro.setOidIdioma(this.applet.getOidIdioma()); 
    dtoCobro.setIP(this.applet.ip);
    dtoCobro.setOidCabeceraSolicitud(this.applet.dtoCabeceraSolicitud.getOidCabeceraSolicitud() );
    dtoCobro.setOidSubacceso(this.applet.cache.getOidSubAcceso());
    dtoCobro.setCobrarBelcenter(this.applet.cache.getBelcenter());
    
    MareDTO mareDTO = null;
    try {
        mareDTO = this.applet.ejecutarNegocio(
        "BELComprobarInicioCobro" , 
        "es.indra.sicc.dtos.bel.DTOComprobarInicioCobro",
        dtoCobro
        );
        dtoCobro = (DTOComprobarInicioCobro)mareDTO;
          this.cobrarBelcenter = new CobrarBelcenter(this.applet.url, 
                                        this.applet.user, 
                                        this.applet.getOidPais());
          //this.cobrarBelcenter.setUrl(this.applet.url);
          this.cobrarBelcenter.getFrameCobrarBelcenter().setOidSubacceso(this.applet.dtoCabeceraSolicitud.getSubacceso());
          this.cobrarBelcenter.getFrameCobrarBelcenter().setTotalPagado(new BigDecimal("0"));
          this.cobrarBelcenter.getFrameCobrarBelcenter().setTotalPendiente(new BigDecimal("0"));
          this.cobrarBelcenter.getFrameCobrarBelcenter().setImportePagar(dtoCobro.getTotalPagarLocal());
          this.cobrarBelcenter.getFrameCobrarBelcenter().setOidTipoMovimientoCobrar(dtoCobro.getOidTipoMovimientoCobrar());
          this.cobrarBelcenter.getFrameCobrarBelcenter().setMontoMaximoDiferencia(dtoCobro.getMontoMaximoDiferencia());
          this.cobrarBelcenter.getFrameCobrarBelcenter().setOidCaja(dtoCobro.getOidCaja());
          this.cobrarBelcenter.getFrameCobrarBelcenter().setOidIdioma(this.applet.getOidIdioma());
          //this.cobrarBelcenter.getFrameCobrarBelcenter().setOidSolicitudCabecera(this.applet.dtoCabeceraSolicitud.getOidCabeceraSolicitud());
          this.cobrarBelcenter.getFrameCobrarBelcenter().setOidSolicitudCabecera(dtoCobro.getOidCabeceraSolicitud());
          this.cobrarBelcenter.getFrameCobrarBelcenter().setOidCanal(this.applet.dtoCabeceraSolicitud.getCanal());
          this.cobrarBelcenter.getFrameCobrarBelcenter().setOidAcceso(this.applet.dtoCabeceraSolicitud.getAcceso());
          this.cobrarBelcenter.getFrameCobrarBelcenter().setOidCliente(this.applet.dtoCabeceraSolicitud.getOidCliente()); 
          //this.cobrarBelcenter.getFrameCobrarBelcenter().setNumeroSolicitud(new Long(this.applet.dtoCabeceraSolicitud.getNumeroSolicitud()));
          this.cobrarBelcenter.getFrameCobrarBelcenter().setNumeroSolicitud(dtoCobro.getNumeroConsolidado());
          this.cobrarBelcenter.getFrameCobrarBelcenter().setOidPais(this.applet.dtoCabeceraSolicitud.getOidPais());

          this.cobrarBelcenter.getFrameCobrarBelcenter().getLblTxtCanal().setText(this.applet.lbCanalTipoSolicitud.getText());
          this.cobrarBelcenter.getFrameCobrarBelcenter().getLblTxtAcceso().setText(this.applet.lbAccesoTipoSolicitud.getText());
          this.cobrarBelcenter.getFrameCobrarBelcenter().getLblTxtSubacceso().setText(this.applet.lbSubaccesoTipoSolicitud.getText());
          this.cobrarBelcenter.getFrameCobrarBelcenter().getLblTxtCaja().setText(dtoCobro.getCaja()); 
          this.cobrarBelcenter.getFrameCobrarBelcenter().getLblTxtCodCliente().setText(this.applet. txtCodCliente.getText());
          this.cobrarBelcenter.getFrameCobrarBelcenter().getLblTxtNombreCliente().setText(this.applet.lbApellidos.getText() + "," + this.applet.lbNombre.getText());
          this.cobrarBelcenter.getFrameCobrarBelcenter().getLblTxtNConsolidado().setText(this.applet.dtoCabeceraSolicitud.getNumeroSolicitud());
          this.cobrarBelcenter.getFrameCobrarBelcenter().getLblTxtFecha().setText(this.applet.fechaSistema);
          if(dtoCobro.getTotalPagarLocal()!=null)
              this.cobrarBelcenter.getFrameCobrarBelcenter().getLblTxtImporteAPagar().setText(dtoCobro.getTotalPagarLocal().toString()); 
          else
              this.cobrarBelcenter.getFrameCobrarBelcenter().getLblTxtImporteAPagar().setText("");
          
         
         this.cobrarBelcenter.getFrameCobrarBelcenter().getLblTxtDivisa().setText(dtoCobro.getDivisa());
         
         if (this.applet.dtoCabeceraSolicitud.getMoneda() != null)
               if(dtoCobro.getTotalPagarDocumento()!=null)
                    this.cobrarBelcenter.getFrameCobrarBelcenter().getLblTxtImporteAPagarEnDivisa().setText(dtoCobro.getTotalPagarDocumento().toString()); 
                else
                    this.cobrarBelcenter.getFrameCobrarBelcenter().getLblTxtImporteAPagarEnDivisa().setText("");

          //this.cobrarBelcenter.getFrameCobrarBelcenter().setTablaDetalle(new TablaCobrarBelcenter());
          this.cobrarBelcenter.getFrameCobrarBelcenter().getLblTxtTotalPagado().setText("0");
          String val1,val2;
          if(this.cobrarBelcenter.getFrameCobrarBelcenter().getLblTxtImporteAPagar().getText().trim()!="")
              val1=this.cobrarBelcenter.getFrameCobrarBelcenter().getLblTxtImporteAPagar().getText();
          else
              val1="0";
        if((this.cobrarBelcenter.getFrameCobrarBelcenter().getLblTxtTotalPagado().getText().trim())!="")
              val2=this.cobrarBelcenter.getFrameCobrarBelcenter().getLblTxtTotalPagado().getText();
        else
            val2="0";

        BigDecimal valor = new BigDecimal(val1).add(new BigDecimal(val2).negate()).setScale(2,BigDecimal.ROUND_HALF_EVEN);

        this.cobrarBelcenter.getFrameCobrarBelcenter().getLblTxtTotalPendiente().setText(valor.toString()); 
       
        this.cobrarBelcenter.getFrameCobrarBelcenter().setModal(true);
        this.cobrarBelcenter.getFrameCobrarBelcenter().show();
        this.cobrarBelcenter.getFrameCobrarBelcenter().dispose();
    } catch (AppletException e) {
        //Dialogos.mensajeError(e.getCode(), this.applet);
        UtilApplet.procesarError(e, this.applet);
    }
  }
  
  // Simula el cuadre de ofertas para la solicitud actual 
  public void btnSimularCuadre_click() {
    //System.out.println("### " + this.applet.dtoCabeceraSolicitud);
    if(this.applet.dtoCabeceraSolicitud.getPosiciones() == null || this.applet.dtoCabeceraSolicitud.getPosiciones().size() == 0) {
      Dialogos.mensajeError(ConstantesApplet.UIPED031, this.applet);
      return;
    } else {
      this.applet.dtoCabeceraSolicitud.setOidIdioma(this.applet.getOidIdioma());
      FrameSimularCuadreOfertas frameSimular = new FrameSimularCuadreOfertas(
          "Simular cuadre ofertas", this.applet, this.applet.dtoCabeceraSolicitud);
      //System.out.println("################################################################");
      //System.out.println("this.applet.dtoCabeceraSolicitud: " +this.applet.dtoCabeceraSolicitud);
      //System.out.println("################################################################");
      frameSimular.setModal(true);
      try {
        frameSimular.simular();
        frameSimular.setVisible(true);
        
       
      } catch (AppletException e) {
        UtilApplet.procesarError(e, this.applet);
      }
      frameSimular.dispose();
    }
  }
  
  /**
   * DBLG400000397 - dmorello, 06/04/2006
   * Este método recibe una lista de DTOPosicionSolicitud y modifica los campos
   * numeroPosicion de cada uno para que queden numerados de 10 en 10 comenzando
   * desde cero
   * @param posiciones
   */
  private void recalcularPosiciones() {
    System.out.println("Procedo a recalcular los numeros de las posiciones");
    ArrayList posiciones = this.applet.dtoCabeceraSolicitud.getPosiciones();
    if (posiciones != null) {
        long posicion = 0;
        long multiplicador;
        if (Boolean.TRUE.equals(this.applet.dtoCabeceraSolicitud.getIndicadorDigitacion())) {
            multiplicador = 10;
        } else {
            multiplicador = 1;
        }
        Iterator iterator = posiciones.iterator();
        while (iterator.hasNext()) {
            DTOPosicionSolicitud dto = (DTOPosicionSolicitud)iterator.next();
            dto.setNumeroPosicion(new Long(posicion * multiplicador));
            posicion++;
        }
    }
  }
}