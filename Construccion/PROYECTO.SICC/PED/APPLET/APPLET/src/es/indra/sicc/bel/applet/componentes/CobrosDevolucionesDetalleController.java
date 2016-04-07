package es.indra.sicc.bel.applet.componentes;

import es.indra.sicc.bel.applet.GestorCobrosDevolucionesApplet;
import es.indra.sicc.bel.applet.util.DetalleCobroDevolucion;
import es.indra.sicc.comunapplet.ConstantesApplet;
import es.indra.sicc.comunapplet.Dialogos;
import es.indra.sicc.dtos.bel.DTOCargaMedioPago;
import es.indra.sicc.dtos.bel.DTOCargaMoneda;
import es.indra.sicc.dtos.bel.DTODatosCobroDevolucion;
import es.indra.sicc.dtos.bel.DTOMovimientoCajaDetalle;
import java.math.BigDecimal;
import java.util.ArrayList;

public class CobrosDevolucionesDetalleController 
{
  private GestorCobrosDevolucionesApplet applet = null;
  private FrameDatosCobroDevolucion frameDevolucion = null;
  private Long oidSolicitudNotaCredito;
  private Long oidMedioPago;
  private Long oidMoneda;
    
  
  public CobrosDevolucionesDetalleController(GestorCobrosDevolucionesApplet applet) {
    this.applet = applet;
  }
  
  public void btnAnadir_click() {
    if(!"".equals(this.applet.getTxtCodCliente().trim())) {
      //if(this.frameDevolucion == null) {
        this.frameDevolucion = new FrameDatosCobroDevolucion("Datos de devolución de cobro", this.applet);
      //}
      //System.out.println("inicializa....");
      this.frameDevolucion.inicializar();
      //System.out.println("valores defecto....");
      this.frameDevolucion.seleccionarValoresDefecto();
      //System.out.println("modal....");
      this.frameDevolucion.setModal(true);
      this.frameDevolucion.show();
      // Se bloquea hasta que se oculta la ventana emergente  
      if(this.frameDevolucion.getAnadirFila()) {
        DetalleCobroDevolucion fila = this.frameDevolucion.generarDetalleCobroDevolucion();
        if(!"".equals(fila.getMedioPago().trim())) {
          this.anadirFilaDetalle(fila); 
          // Añade un nuevo DTO a la lista de movimientos 
          if(this.applet.getMovimientoCaja() == null) {
            this.applet.setMovimientoCaja(new ArrayList());
          }
          this.applet.getMovimientoCaja().add(this.crearDTOMovimientoCajaDetalle(fila)) ;
          // Actualizo el total 
          //this.applet.setTotalPagado(this.applet.getTotalPagado().add(fila.getImporte()));
          //this.applet.setCodigoCliente("");
          //this.applet.setObservaciones("");
          //this.applet.setOidCliente(this.getoi);
          //this.frameDevolucion.dispose();
          this.frameDevolucion.setTxtImporte("");
          this.frameDevolucion.setTxtImporteDivisa("");
          this.frameDevolucion.setTxtTipoCambio("");
        } else {
          this.applet.setCodigoCliente("");
          this.applet.setObservaciones("");
          this.frameDevolucion.dispose();
          this.frameDevolucion = null;
        }
      }
    } else {
      Dialogos.mensajeError(ConstantesApplet.ERROR_FALTAN_DATOS_OBLIGATORIOS, this.applet);
      this.applet.setCodigoClienteFocus();
    }
  }
  
  public DTOMovimientoCajaDetalle crearDTOMovimientoCajaDetalle(DetalleCobroDevolucion fila) {
    this.obtenerValoresDetalle(fila);

    DTOMovimientoCajaDetalle dto = new DTOMovimientoCajaDetalle();
    dto.setNumeroLinea(new Integer(this.applet.getTablaDetalle().getSelectedRow() + 1));
    dto.setOidTipoMovimientoCaja(this.applet.getOidTipoMovimientoCobrar());
    dto.setOidMonedaAlternativa(this.oidMoneda);
    dto.setOidMedioPagoBelcenter(this.oidMedioPago); 
    //System.out.println("aaaaa: " + this.applet.getOidMedioPago());
    //System.out.println("bbbb: " + this.oidMedioPago);
    dto.setImporte(fila.getImporte());
    dto.setImporteDivisa(fila.getImporteDivisa());
    dto.setOidSolicitudNotaCredito(this.frameDevolucion.getOidSolicitudNotaCredito()); 
    dto.setFecha(this.applet.getFechaSistemaDate());

    return dto;
  }
  
  public void obtenerValoresDetalle(DetalleCobroDevolucion fila) {
    
    if(this.applet.getCargaDatosDetalle() == null)  {
      this.applet.setCargaDatosDetalle(new DTODatosCobroDevolucion());
    }
    
    DTOCargaMedioPago[] dtosPagos = this.applet.getCargaDatosDetalle().getMedioPago();
    Long oidMedioPago = null;
    if(dtosPagos != null) {
      boolean flag = false;
      for (int i = 0; i < dtosPagos.length && !flag; ++i) {
        if(fila.getMedioPago().equals(dtosPagos[i].getDescripcion())) {
          oidMedioPago = dtosPagos[i].getOid();
          flag = true;
        }        
      }      
    }
    
    this.oidMedioPago = oidMedioPago;
    
    DTOCargaMoneda moneda = this.applet.getCargaDatosDetalle().getMoneda();
    Long oidMoneda = null;
    if(moneda != null) {
      boolean flag = false;
      if(fila.getMoneda().equals(moneda.getDescripcion())) {
        oidMoneda = moneda.getOid();
        flag = true;
      }      
    }
    
    this.oidMoneda = oidMoneda;
    
    this.oidSolicitudNotaCredito = this.frameDevolucion.getOidSolicitudNotaCredito();
  }
  
  /**
   * Carga la pantalla DatosCobroDevolucion y muestra la información de la linea modificar 
   */
  public void dbtnModificar_click() {
    if( this.applet.getTablaDetalle().getSelectedRowCount() == 1 &&
      this.applet.getTablaDetalle().getRowCount() > 0 &&
      !"".equals(this.applet.getTablaDetalle().colMedioPago.getText(0).trim())) {
    
      // Obtiene la linea seleccionada para modificar 
      DetalleCobroDevolucion fila = this.obtenerFilaDetalle();
      // Actualizo el total 
      /*if (fila.getImporte() != null) {
        this.applet.setTotalPagado(this.applet.getTotalPagado().add(fila.getImporte()));
      }*/
      
      // if(this.frameDevolucion == null) {
        this.frameDevolucion = new FrameDatosCobroDevolucion("Datos de devolución de cobro", this.applet);
      //}
      this.frameDevolucion.inicializar();
      this.frameDevolucion.mostrarDetalle(fila);
      this.frameDevolucion.setModal(true);
      this.frameDevolucion.show();
      // Se bloquea hasta que se oculta la ventana emergente  
      
      if(this.frameDevolucion.getAnadirFila()) {
        fila = this.frameDevolucion.generarDetalleCobroDevolucion();
        this.actualizarFilaDetalle(fila);
        
        // Actualiza el DTO correspondiente en la lista de movimientos con:
        //Número de fila seleccionada - 1 (Comenzando en 1) 
        int posicion = this.applet.getTablaDetalle().getSelectedRow();
        this.applet.getMovimientoCaja().set(posicion, this.crearDTOMovimientoCajaDetalle(fila));
        
        // Actualizo el total 
        this.applet.setTotalPagado(this.applet.getTotalPagado().add(fila.getImporte()));
      }      
      this.frameDevolucion.dispose();    
    } else {
      Dialogos.mensajeError(ConstantesApplet.GEN_UIGEN0004, this.applet);
    }
  }
  
  
  
  public DetalleCobroDevolucion obtenerFilaDetalle() {
    return this.applet.getTablaDetalle().getSelectedFile();
  }

  /**
   * Actualiza la linea seleccionada de la tablaDetalle utilizando el objeto fila
   * @param fila
   */
  public void actualizarFilaDetalle (DetalleCobroDevolucion fila) {
    this.applet.getTablaDetalle().updateFila(fila);
  }
  
  /**
   * Añade una fila a la tabla tablaDetalle utilizando el objeto fila recibido     
   * @param fila
   */
  public void anadirFilaDetalle (DetalleCobroDevolucion fila) {
    this.applet.getTablaDetalle().addFila(fila);
  }
  
  public void btnEliminar_click() {
    if(this.applet.getTablaDetalle().getSelectedRowCount() < 1 ||
      this.applet.getTablaDetalle().getRowCount() == 0  ||
      (this.applet.getTablaDetalle().getRowCount() > 0 &&
      "".equals(this.applet.getTablaDetalle().colMedioPago.getText(0).trim()))) {
      //Mostrar mensaje de que se debe seleccionar una fila
      Dialogos.mensajeError(ConstantesApplet.GEN_UIGEN0004, this.applet);
    } else {
      DetalleCobroDevolucion fila = this.obtenerFilaDetalle();
      // Elimina el DTO correspondiente: Número de fila seleccionada - 1 (Comenzando en 1) 
      int posicion = this.applet.getTablaDetalle().getSelectedRow();
      this.applet.getMovimientoCaja().remove(posicion);
      
      //Elimina la fila seleccionada de la tabla 
      this.applet.getTablaDetalle().deleteRow(posicion);
      
      // Actualizo el total 
      //this.applet.setTotalPagado(this.applet.getTotalPagado().subtract(fila.getImporte()));
    }    
  }

  public Long getOidMedioPago()
  {
    return oidMedioPago;
  }

  public void setOidMedioPago(Long oidMedioPago)
  {
    this.oidMedioPago = oidMedioPago;
  }

  public Long getOidMoneda()
  {
    return oidMoneda;
  }

  public void setOidMoneda(Long oidMoneda)
  {
    this.oidMoneda = oidMoneda;
  }
  
  
  
}