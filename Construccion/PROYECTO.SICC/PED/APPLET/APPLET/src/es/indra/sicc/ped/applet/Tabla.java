package es.indra.sicc.ped.applet;

import es.indra.sicc.dtos.ped.applet.DTOInfoProducto;
import es.indra.sicc.dtos.ped.DTOCabeceraSolicitud;

import es.indra.sicc.ped.applet.componentes.TablaDetalle;

public class Tabla {
  private TablaDetalle tablaDetalle;
  
  public Tabla(TablaDetalle t ) {
    this.tablaDetalle = t;
  }

  public TablaDetalle getTablaDetalle() {
    return tablaDetalle;
  }

  public void setTablaDetalle(TablaDetalle tablaDetalle) {
    this.tablaDetalle = tablaDetalle;
  }
  
  public void addFila(DTOInfoProducto dtoInfoProducto,
              DTOCabeceraSolicitud dtoCabeceraSolicitud,
              String demandaNoAtendida,
              String observaciones) {
    if (this.tablaDetalle == null) {
      System.out.println("la tabla detalle era null");
      this.tablaDetalle = new TablaDetalle();
    }
    //TODO que agregue la fila en la tabla. 
    int row = this.tablaDetalle.getRowCount();
    this.tablaDetalle.newRow();
    this.tablaDetalle.colCodProducto.setText( "codProd", row );
    this.tablaDetalle.colCodVenta.setText("codVenta", row );
    this.tablaDetalle.colControlLiquidacion.setText( "controlLiq", row );
    this.tablaDetalle.colDemandaNoAtendida.setText( "demand no atend.", row );
    this.tablaDetalle.colLimVenta.setText( "lim vta", row );
    this.tablaDetalle.colDescripcion.setText( "desc", row );
    this.tablaDetalle.colObservaciones.setText( "observa", row );
    this.tablaDetalle.colReserva.setText( "reserva", row );
    
    this.tablaDetalle.deleteEmptyRows();
    this.tablaDetalle.setRowSelectionInterval(0,0);
     
    //El diseño esta en DatosDetalle.addFila
  }
  
}