package es.indra.sicc.ped.applet.componentes;

import es.indra.sicc.comunapplet.Columna;
import es.indra.sicc.comunapplet.TablaApplet;
import java.awt.Color;
import java.awt.event.KeyEvent;
import javax.swing.table.TableCellRenderer;


public class TablaSimular extends TablaApplet {
   public Columna colFormaPago = new Columna("Forma pago");
   public Columna colCodVenta = new Columna("Código venta");
   public Columna colCodProducto = new Columna("Código producto");
   public Columna colDescProducto = new Columna("Descripción producto");
   public Columna colUniAtender = new Columna("Unidades a atender");
   public Columna colPrecioUnitario = new Columna("Precio unitario");
   public Columna colPrecioTotal = new Columna("Precio total");
   //public Columna colColor = new Columna("");
   
  // public Color color;
   
   
   
//------------------------------------------------------------------------------
   public TablaSimular(String nombre) {
      super(nombre, Boolean.TRUE);

      try {
         this.jbInit();
      } catch ( Exception e ) {
         e.printStackTrace();
      }
   }
   
   public TablaSimular() {
      super("TablaSimular", Boolean.TRUE);

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
      
      this.colFormaPago.setType( Columna.TYPE_ALFANUMERICO );
      this.colFormaPago.setEditable( false );
      this.colFormaPago.setWidth( 130 );
      super.add( this.colFormaPago );

      this.colCodVenta.setType( Columna.TYPE_ALFANUMERICO );
      this.colCodVenta.setEditable( false );
      this.colCodVenta.setWidth( 120 );
      super.add( this.colCodVenta );
  
      this.colCodProducto.setType( Columna.TYPE_ALFANUMERICO );
      this.colCodProducto.setEditable( false );
      this.colCodProducto.setWidth( 100 );
      super.add( this.colCodProducto );
      
      this.colDescProducto.setType( Columna.TYPE_ALFANUMERICO );
      this.colDescProducto.setEditable( false );
      this.colDescProducto.setWidth( 120 );
      super.add( this.colDescProducto );
  
      this.colUniAtender.setType( Columna.TYPE_ALFANUMERICO );
      this.colUniAtender.setEditable( false );
      this.colUniAtender.setWidth( 120 );
      super.add( this.colUniAtender );
  
      this.colPrecioUnitario.setType( Columna.TYPE_ALFANUMERICO );
      this.colPrecioUnitario.setEditable( false );
      this.colPrecioUnitario.setWidth( 130 );
      super.add( this.colPrecioUnitario );
      
      this.colPrecioTotal.setType( Columna.TYPE_ALFANUMERICO );
      this.colPrecioTotal.setEditable( false );
      this.colPrecioTotal.setWidth( 120 );
      super.add( this.colPrecioTotal );
      /*
      this.colColor.setType( Columna.COLOR );
      this.colColor.setEditable( false );
      this.colColor.setWidth( 100 );
      super.add(this.colColor);*/
   
      super.setInsertCapable( false );
      super.setDeleteCapable( false );
      super.init();
      
      /*TableCellRenderer renderer = new ColorTableCellRenderer();
        try
        {
           this.setDefaultRenderer( Class.forName
               ( "java.awt.Color" ), renderer );
        }
        catch( ClassNotFoundException ex )
        {
            System.exit( 0 );
        }*/
   }
//------------------------------------------------------------------------------
   public void this_keyPressed( KeyEvent e ) {
      return;
   }
  public void addFila(
          String colFormaPago,
          String colCodVenta,
          String colCodProducto,
          String colDescProducto,
          String colUniAtender,
          String colPrecioUnitario,
          String colPrecioTotal
   ) {
    //this.color = color;
    int row = this.getRowCount();
    this.newRow();
    this.colFormaPago.setText( colFormaPago, row );
    this.colCodVenta.setText(colCodVenta, row );
    this.colCodProducto.setText( colCodProducto, row );
    this.colDescProducto.setText( colDescProducto, row );
    this.colUniAtender.setText( colUniAtender, row );
    this.colPrecioUnitario.setText( colPrecioUnitario, row );
    this.colPrecioTotal.setText( colPrecioTotal, row );
    
    this.deleteEmptyRows();
    int tamActual = this.getRowCount();
    if(row == tamActual) {
      this.setRowSelectionInterval(row - 1, row - 1);  
    } else {
      this.setRowSelectionInterval(row, row);
    }
  }
  
  public void setColorultimaFila(Color color) {
    int row = this.getRowCount() - 1;
    this.setColorBackground(color, row);
  }
 
}