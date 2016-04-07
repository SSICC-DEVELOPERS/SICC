package es.indra.sicc.bel.applet.componentes;

import es.indra.sicc.comunapplet.Columna;
import es.indra.sicc.comunapplet.ConstantesBundlesApplet;
import es.indra.sicc.comunapplet.ConstantesColumnas;
import es.indra.sicc.comunapplet.PropertiesApplet;
import es.indra.sicc.comunapplet.TablaApplet;

import java.awt.Color;
import java.awt.event.KeyEvent;

public class TablaSimularCambiosVentas extends TablaApplet
{
   public Columna colProductos;
   public Columna colUnidades;
   public Columna colMonto;
   public Columna colUnidadesCambio;
   public Columna colUnidadesVenta;

   public TablaSimularCambiosVentas(String nombre) 
   {
      super(nombre);
      try {
        this.initColumns();
        jbInit();
      } catch ( Exception e ) {
         e.printStackTrace();
      }
   }
   
   public TablaSimularCambiosVentas() {
      super("TablaSimularCambiosVentas");
      try {
        this.initColumns();
        jbInit();
      } catch ( Exception e ) {
         e.printStackTrace();
      }
   }
   
  private void initColumns(){
    //PropertiesApplet.setProperties(ConstantesBundlesApplet.APPLET_COLUMNS_BUNDLE);
    colProductos = new Columna(PropertiesApplet.getPropertie(ConstantesColumnas.SIM_CAMBIOS_VENTAS_PRODUCTOS, ConstantesBundlesApplet.APPLET_COLUMNS_BUNDLE));
    colUnidades = new Columna(PropertiesApplet.getPropertie(ConstantesColumnas.SIM_CAMBIOS_VENTAS_UNIDADES, ConstantesBundlesApplet.APPLET_COLUMNS_BUNDLE));
    colMonto = new Columna(PropertiesApplet.getPropertie(ConstantesColumnas.SIM_CAMBIOS_VENTAS_MONTO, ConstantesBundlesApplet.APPLET_COLUMNS_BUNDLE));
    colUnidadesCambio = new Columna(PropertiesApplet.getPropertie(ConstantesColumnas.SIM_CAMBIOS_VENTAS_UNIDADES_CAMBIO, ConstantesBundlesApplet.APPLET_COLUMNS_BUNDLE));
    colUnidadesVenta = new Columna(PropertiesApplet.getPropertie(ConstantesColumnas.SIM_CAMBIOS_VENTAS_UNIDADES_VENTA, ConstantesBundlesApplet.APPLET_COLUMNS_BUNDLE));
  }
   
   
   private void jbInit() throws Exception {
      setShowGrid( true );
      super.setColorBackground( Color.white );
      
      colProductos.setType( Columna.TYPE_ALFANUMERICO );
      colProductos.setEditable( false );
      colProductos.setWidth( 140 );
      super.add(colProductos);
      
      colUnidades.setType( Columna.TYPE_ALFANUMERICO );
      colUnidades.setEditable( false );
      colUnidades.setWidth( 140 );
      super.add(colUnidades);
      
      colMonto.setType( Columna.TYPE_ALFANUMERICO );
      colMonto.setEditable( false );
      colMonto.setWidth( 140 );
      super.add(colMonto);
      
      colUnidadesCambio.setType( Columna.TYPE_ALFANUMERICO );
      colUnidadesCambio.setEditable( false );
      colUnidadesCambio.setWidth( 140 );
      super.add(colUnidadesCambio);

      colUnidadesVenta.setType( Columna.TYPE_ALFANUMERICO );
      colUnidadesVenta.setEditable( false );
      colUnidadesVenta.setWidth( 140 );
      super.add(colUnidadesVenta);

      super.setInsertCapable( false );
      super.setDeleteCapable( false );
      super.init();
   }
//------------------------------------------------------------------------------
   public void this_keyPressed( KeyEvent e ) {
      return;
   }

}