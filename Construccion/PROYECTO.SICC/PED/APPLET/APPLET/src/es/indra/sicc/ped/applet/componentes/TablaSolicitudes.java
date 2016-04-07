package es.indra.sicc.ped.applet.componentes;
import java.awt.Color;
import java.awt.event.KeyEvent;
import es.indra.sicc.comunapplet.Columna;
import es.indra.sicc.comunapplet.TablaApplet;

public class TablaSolicitudes extends TablaApplet {
   public Columna colNroSoli   = new Columna("Numero de Solicitud");
   public Columna colPeriodo   = new Columna("Periodo");
   public Columna colProcVal   = new Columna("Proceso Validación");
   public Columna colEstado    = new Columna("Estado");
   public Columna colTotPagar  = new Columna("Total a Pagar");
   public Columna colVacia     = new Columna("");
   
   public TablaSolicitudes(String nombre) {
      super(nombre);

      try {
         jbInit();
      } catch ( Exception e ) {
         e.printStackTrace();
      }
   }
   
   public TablaSolicitudes() {
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
      
      colNroSoli.setType( Columna.TYPE_ALFANUMERICO );
      colNroSoli.setEditable( false );
      colNroSoli.setWidth( 80 );
      super.add( colNroSoli );
      
      colPeriodo.setType( Columna.TYPE_ALFANUMERICO );
      colPeriodo.setEditable( false );
      colPeriodo.setWidth( 80 );
      super.add( colPeriodo );

      colProcVal.setType( Columna.TYPE_ALFANUMERICO );
      colProcVal.setEditable( false );
      colProcVal.setWidth( 80 );
      super.add( colProcVal );

      colEstado.setType( Columna.TYPE_ALFANUMERICO );
      colEstado.setEditable( false );
      colEstado.setWidth( 80 );
      super.add( colEstado );
      
      colTotPagar.setType( Columna.TYPE_ALFANUMERICO );
      colTotPagar.setEditable( false );
      colTotPagar.setWidth( 80 );
      super.add( colTotPagar );
      
      colVacia.setType( Columna.TYPE_ALFANUMERICO );
      colVacia.setEditable( false );
      colVacia.setWidth( 240 );
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