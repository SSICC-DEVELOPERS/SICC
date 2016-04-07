package es.indra.sicc.ped.applet.componentes;

import es.indra.sicc.comunapplet.Columna;
import es.indra.sicc.comunapplet.TablaApplet;import java.awt.Color;
import java.awt.event.KeyEvent;

public class TablaDetalle extends TablaApplet {
     //Columnas de la grilla solicitud digitada de la panatalla Digitar posiciones
   public Columna colCodVenta           = new Columna("Código de venta");
   public Columna colCodProducto        = new Columna("Código de producto");
   public Columna colDescripcion        = new Columna("Descripción");
   public Columna colUniDemanda         = new Columna("Unidades demandadas");
   public Columna colUniAtender         = new Columna("Unidades a atender");
   public Columna colUniDemandaReal     = new Columna("Unidades demanda real");
   public Columna colStockDisp          = new Columna("Stock disponible");
   public Columna colLimVenta           = new Columna("Limite de venta");
   public Columna colControlLiquidacion = new Columna("Control liquidación");
   public Columna colReserva            = new Columna("Reserva");
   public Columna colDemandaNoAtendida  = new Columna("Demanda no atendida");
   public Columna colObservaciones      = new Columna("Observaciones");
   
//------------------------------------------------------------------------------
   public TablaDetalle(String nombre) {
      super(nombre);

      try {
         this.jbInit();
      } catch ( Exception e ) {
         e.printStackTrace();
      }
   }
   
   public TablaDetalle() {
      super("TablaDetalle");

      try {
         this.jbInit();
      } catch ( Exception e ) {
         e.printStackTrace();
      }
   }
//------------------------------------------------------------------------------
   private void jbInit() throws Exception {
      setShowGrid( true );
      super.setColorBackground( Color.white );
      
      colCodVenta.setType( Columna.TYPE_ALFANUMERICO );
      colCodVenta.setEditable( false );
      colCodVenta.setWidth( 100 );
      super.add( colCodVenta );
      
      colCodProducto.setType( Columna.TYPE_ALFANUMERICO );
      colCodProducto.setEditable( false );
      colCodProducto.setWidth( 120 );
      super.add( colCodProducto );
  
      colDescripcion.setType( Columna.TYPE_ALFANUMERICO );
      colDescripcion.setEditable( false );
      colDescripcion.setWidth( 120 );
      super.add( colDescripcion );
  
      colUniDemanda.setType( Columna.TYPE_ALFANUMERICO );
      colUniDemanda.setEditable( false );
      colUniDemanda.setWidth( 130 );
      super.add( colUniDemanda );
  
      colUniAtender.setType( Columna.TYPE_ALFANUMERICO );
      colUniAtender.setEditable( false );
      colUniAtender.setWidth( 120 );
      super.add( colUniAtender );
  
      colUniDemandaReal.setType( Columna.TYPE_ALFANUMERICO );
      colUniDemandaReal.setEditable( false );
      colUniDemandaReal.setWidth( 130 );
      super.add( colUniDemandaReal );
  
      colStockDisp.setType( Columna.TYPE_ALFANUMERICO );
      colStockDisp.setEditable( false );
      colStockDisp.setWidth( 100 );
      super.add( colStockDisp );
  
      colLimVenta.setType( Columna.TYPE_ALFANUMERICO );
      colLimVenta.setEditable( false );
      colLimVenta.setWidth( 100 );
      super.add( colLimVenta );
  
      colControlLiquidacion.setType( Columna.TYPE_ALFANUMERICO );
      colControlLiquidacion.setEditable( false );
      colControlLiquidacion.setWidth( 110 );
      super.add( colControlLiquidacion );

      colReserva.setType( Columna.TYPE_ALFANUMERICO );
      colReserva.setEditable( false );
      colReserva.setWidth( 100 );
      super.add( colReserva );
    
      colDemandaNoAtendida.setType( Columna.TYPE_ALFANUMERICO );
      colDemandaNoAtendida.setEditable( false );
      colDemandaNoAtendida.setWidth( 130 );
      super.add( colDemandaNoAtendida );

      colObservaciones.setType( Columna.TYPE_ALFANUMERICO );
      colObservaciones.setEditable( false );
      colObservaciones.setWidth( 200 );
      super.add( colObservaciones );

      super.setInsertCapable( false );
      super.setDeleteCapable( false );
      super.init();
   }
//------------------------------------------------------------------------------
   public void this_keyPressed( KeyEvent e ) {
      return;
   }
//-------------------------
   public void addFila(
          String colCodProducto,
          String colCodVenta,
          String colControlLiquidacion,
          String colDemandaNoAtendida,
          String colLimVenta,
          String colDescripcion,
          String colObservaciones,
          String colReserva,
          String colStockDisp,
          String colUniDemandaReal,
          String colUniDemandadas,
          String colUniAtender
          
   ) {
    int row = this.getRowCount();
    this.newRow();
    this.colCodProducto.setText( colCodProducto, row );
    this.colCodVenta.setText(colCodVenta, row );
    this.colControlLiquidacion.setText( colControlLiquidacion, row );
    this.colDemandaNoAtendida.setText( colDemandaNoAtendida, row );
    this.colLimVenta.setText( colLimVenta, row );
    this.colDescripcion.setText( colDescripcion, row );
    this.colObservaciones.setText( colObservaciones, row );
    this.colReserva.setText( colReserva, row );
    this.colStockDisp.setText( colStockDisp, row );
    this.colUniDemandaReal.setText( colUniDemandaReal, row );
    this.colUniDemanda.setText(colUniDemandadas, row);
    this.colUniAtender.setText(colUniAtender, row);
    
    this.deleteEmptyRows();
    int tamActual = this.getRowCount();
    if(row == tamActual) {
      this.setRowSelectionInterval(row - 1, row - 1);  
    } else {
      this.setRowSelectionInterval(row, row);
    }
  }
}