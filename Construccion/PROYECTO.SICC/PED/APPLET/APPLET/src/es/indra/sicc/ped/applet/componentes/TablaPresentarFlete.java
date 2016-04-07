package es.indra.sicc.ped.applet.componentes;
import java.awt.Color;
import java.awt.event.KeyEvent;
import es.indra.sicc.comunapplet.Columna;
import es.indra.sicc.comunapplet.TablaApplet;

public class TablaPresentarFlete extends TablaApplet {
   public Columna colDesc   = new Columna("Descripción");
   public Columna colMontoFijo   = new Columna("Monto Fijo");
   public Columna colFleteMin   = new Columna("Flete Mínimo");
   public Columna colFleteMax    = new Columna("Flete Máximo");
   public Columna colTasa  = new Columna("Tasa");
   public Columna colTipoDespacho  = new Columna("Tipo Despacho");
   public Columna colContraEnt  = new Columna("Contra Entrega");
   public Columna colVacia     = new Columna("");
   
   public TablaPresentarFlete(String nombre) {
      super(nombre);

      try {
         jbInit();
      } catch ( Exception e ) {
         e.printStackTrace();
      }
   }
   
   public TablaPresentarFlete() {
      super("Tabla Solicitudes Anteriores");

      try {
         jbInit();
      } catch ( Exception e ) {
         e.printStackTrace();
      }
   }
   
   private void jbInit() throws Exception {
      setShowGrid( true );
      super.setColorBackground( Color.white );
      
      colDesc.setType( Columna.TYPE_ALFANUMERICO );
      colDesc.setEditable( false );
      colDesc.setWidth( 80 );
      super.add( colDesc );
      
      colMontoFijo.setType( Columna.TYPE_ALFANUMERICO );
      colMontoFijo.setEditable( false );
      colMontoFijo.setWidth( 80 );
      super.add( colMontoFijo );

      colFleteMin.setType( Columna.TYPE_ALFANUMERICO );
      colFleteMin.setEditable( false );
      colFleteMin.setWidth( 80 );
      super.add( colFleteMin );

      colFleteMax.setType( Columna.TYPE_ALFANUMERICO );
      colFleteMax.setEditable( false );
      colFleteMax.setWidth( 80 );
      super.add( colFleteMax );
      
      colTasa.setType( Columna.TYPE_ALFANUMERICO );
      colTasa.setEditable( false );
      colTasa.setWidth( 80 );
      super.add( colTasa );

      colTipoDespacho.setType( Columna.TYPE_ALFANUMERICO );
      colTipoDespacho.setEditable( false );
      colTipoDespacho.setWidth( 80 );
      super.add( colTipoDespacho );
      
      colContraEnt.setType( Columna.TYPE_ALFANUMERICO );
      colContraEnt.setEditable( false );
      colContraEnt.setWidth( 80 );
      super.add( colContraEnt );
      
      colVacia.setType( Columna.TYPE_ALFANUMERICO );
      colVacia.setEditable( false );
      colVacia.setWidth( 160 );
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