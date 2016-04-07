package es.indra.sicc.ped.applet.componentes;
import es.indra.sicc.comunapplet.Columna;
import es.indra.sicc.comunapplet.TablaApplet;
import java.awt.Color;
import java.awt.event.KeyEvent;

public class TablaProductos extends TablaApplet {
   public Columna colCodVenta        = new Columna("Código de venta ");
   public Columna colDescripcion = new Columna("Descripción");
   public Columna colTipoOferta = new Columna("Tipo de oferta");
   public Columna colCicloVida = new Columna("Ciclo de vida");
   public Columna colVacia     = new Columna("");   
   
   public TablaProductos(String nombre) {
      super(nombre);

      try {
         jbInit();
      } catch ( Exception e ) {
         e.printStackTrace();
      }
   }
   
   public TablaProductos() {
      super("TablaProductos");

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
      colCodVenta.setWidth( 80 );
      super.add( colCodVenta );
      
      colDescripcion.setType( Columna.TYPE_ALFANUMERICO );
      colDescripcion.setEditable( false );
      colDescripcion.setWidth( 80 );
      super.add( colDescripcion );

      colTipoOferta.setType( Columna.TYPE_ALFANUMERICO );
      colTipoOferta.setEditable( false );
      colTipoOferta.setWidth( 80 );
      super.add( colTipoOferta );

      colCicloVida.setType( Columna.TYPE_ALFANUMERICO );
      colCicloVida.setEditable( false );
      colCicloVida.setWidth( 80 );
      super.add( colCicloVida );
      
      colVacia.setType( Columna.TYPE_ALFANUMERICO );
      colVacia.setEditable( false );
      colVacia.setWidth( 320 );
      super.add( colVacia );
      
      super.setInsertCapable( false );
      super.setDeleteCapable( false );
      super.init();
   }
//------------------------------------------------------------------------------
   public void this_keyPressed( KeyEvent e ) {
      return;
   }
 
}