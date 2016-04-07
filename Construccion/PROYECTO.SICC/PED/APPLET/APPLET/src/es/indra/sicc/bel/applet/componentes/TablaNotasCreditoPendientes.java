package es.indra.sicc.bel.applet.componentes;

import es.indra.sicc.comunapplet.Columna;
import es.indra.sicc.comunapplet.ConstantesBundlesApplet;
import es.indra.sicc.comunapplet.ConstantesColumnas;
import es.indra.sicc.comunapplet.PropertiesApplet;
import es.indra.sicc.comunapplet.TablaApplet;

import java.awt.Color;
import java.awt.event.KeyEvent;

public class TablaNotasCreditoPendientes extends TablaApplet{
   public Columna colNConsolidado;
   public Columna colFecha;
   public Columna colTotalPagar;
   public Columna colMoneda;
   public Columna colTotalPagarMoneda;

   public TablaNotasCreditoPendientes(String nombre) 
   {
      super(nombre);
      try {
        this.initColumns();
        jbInit();
      } catch ( Exception e ) {
         e.printStackTrace();
      }
   }
   
   public TablaNotasCreditoPendientes () {
      super("TablaNotasCreditoPendientes ");
      try {
        this.initColumns();
        jbInit();
      } catch ( Exception e ) {
         e.printStackTrace();
      }
   }
   
  private void initColumns(){
    //PropertiesApplet.setProperties(ConstantesBundlesApplet.APPLET_COLUMNS_BUNDLE);
    colNConsolidado = new Columna(PropertiesApplet.getPropertie(ConstantesColumnas.NOTAS_CRED_PEND_N_CONSOLIDADO, ConstantesBundlesApplet.APPLET_COLUMNS_BUNDLE));
    colFecha = new Columna(PropertiesApplet.getPropertie(ConstantesColumnas.NOTAS_CRED_PEND_FECHA, ConstantesBundlesApplet.APPLET_COLUMNS_BUNDLE));
    colTotalPagar = new Columna(PropertiesApplet.getPropertie(ConstantesColumnas.NOTAS_CRED_PEND_TOTAL_PAGAR, ConstantesBundlesApplet.APPLET_COLUMNS_BUNDLE));
    colMoneda = new Columna(PropertiesApplet.getPropertie(ConstantesColumnas.NOTAS_CRED_PEND_MONEDA, ConstantesBundlesApplet.APPLET_COLUMNS_BUNDLE));
    colTotalPagarMoneda = new Columna(PropertiesApplet.getPropertie(ConstantesColumnas.NOTAS_CRED_PEND_TOTAL_PAGAR_MONEDA, ConstantesBundlesApplet.APPLET_COLUMNS_BUNDLE));
   }
   
   private void jbInit() throws Exception {
      setShowGrid( true );
      super.setColorBackground( Color.white );
      
      colNConsolidado.setType( Columna.TYPE_ALFANUMERICO );
      colNConsolidado.setEditable( false );
      colNConsolidado.setWidth( 140 );
      super.add( colNConsolidado );
      
      colFecha.setType( Columna.TYPE_ALFANUMERICO );
      colFecha.setEditable( false );
      colFecha.setWidth( 140 );
      super.add( colFecha);
      
      colTotalPagar.setType( Columna.TYPE_ALFANUMERICO );
      colTotalPagar.setEditable( false );
      colTotalPagar.setWidth( 140 );
      super.add( colTotalPagar);
      
      colMoneda.setType( Columna.TYPE_ALFANUMERICO );
      colMoneda.setEditable( false );
      colMoneda.setWidth( 140 );
      super.add( colMoneda);

      colTotalPagarMoneda.setType( Columna.TYPE_ALFANUMERICO );
      colTotalPagarMoneda.setEditable( false );
      colTotalPagarMoneda.setWidth( 140 );
      super.add( colTotalPagarMoneda);

      super.setInsertCapable( false );
      super.setDeleteCapable( false );
      super.init();
   }
//------------------------------------------------------------------------------
   public void this_keyPressed( KeyEvent e ) {
      return;
   }

}