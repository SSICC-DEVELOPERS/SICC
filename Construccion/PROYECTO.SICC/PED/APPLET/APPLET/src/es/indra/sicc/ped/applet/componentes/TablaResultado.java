package es.indra.sicc.ped.applet.componentes;
import es.indra.sicc.comunapplet.Columna;
import es.indra.sicc.comunapplet.TablaApplet;
import java.awt.Color;
import java.awt.event.KeyEvent;


public class TablaResultado extends TablaApplet {
   public Columna colCodVenta         = new Columna("Cód. de venta");
   public Columna colDescripcionCorta = new Columna("Descripción corta");
   public Columna colDescripcionLarga = new Columna("Descripción larga");
   public Columna colCantidad         = new Columna("Cantidad");
   public Columna colPrecio           = new Columna("Precio");
   
   public TablaResultado(String nombre) {
      super(nombre);

      try {
         jbInit();
      } catch ( Exception e ) {
         e.printStackTrace();
      }
   }
   
   public TablaResultado() {
      super("TablaResultado");

      try {
         jbInit();
      } catch ( Exception e ) {
         e.printStackTrace();
      }
   }
   
   private void jbInit() throws Exception {
      setShowGrid( true );
      super.setColorBackground( Color.white );
      
      colCodVenta.setType( Columna.TYPE_ALFANUMERICO );
      colCodVenta.setEditable( false );
      colCodVenta.setWidth( 140 );
      super.add( colCodVenta );
      
      colDescripcionCorta.setType( Columna.TYPE_ALFANUMERICO );
      colDescripcionCorta.setEditable( false );
      colDescripcionCorta.setWidth( 160 );
      super.add( colDescripcionCorta );

      colDescripcionLarga.setType( Columna.TYPE_ALFANUMERICO );
      colDescripcionLarga.setEditable( false );
      colDescripcionLarga.setWidth( 160 );
      super.add( colDescripcionLarga );

      colCantidad.setType( Columna.TYPE_ALFANUMERICO );
      colCantidad.setEditable( false );
      colCantidad.setWidth( 105 );
      super.add( colCantidad );
      
      colPrecio.setType( Columna.TYPE_ALFANUMERICO );
      colPrecio.setEditable( false );
      colPrecio.setWidth( 105 );
      super.add( colPrecio );
      
      super.setInsertCapable( false );
      super.setDeleteCapable( false );
      super.init();
   }
//------------------------------------------------------------------------------
   public void this_keyPressed( KeyEvent e ) {
      return;
   }
   
}