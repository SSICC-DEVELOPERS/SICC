package es.indra.sicc.bel.applet.componentes;

import es.indra.sicc.comunapplet.Columna;
import es.indra.sicc.comunapplet.TablaApplet;

import java.awt.Color;
import java.awt.event.KeyEvent;

import es.indra.sicc.comunapplet.PropertiesApplet;
import es.indra.sicc.comunapplet.ConstantesBundlesApplet;
import es.indra.sicc.comunapplet.ConstantesColumnas;

public class TablaCobrarBelcenter extends TablaApplet {
/*
  public Columna colMedioPago = new Columna("Medio pago");
  public Columna colMoneda = new Columna("Moneda");
  public Columna colImporte = new Columna("Importe");
  public Columna colImporteDivisa = new Columna("Importe divisa");
  public Columna colTipoCambio = new Columna("Tipo cambio");
  public Columna colNCheque = new Columna("N° cheque");
  public Columna colBanco = new Columna("Banco");
  public Columna colTipoTarjeta = new Columna("Tipo tarjeta");
  public Columna colNTarjeta = new Columna("N° tarjeta");
  public Columna colNValeCompra = new Columna("N° vale compra");
  public Columna colNConsolidado = new Columna("N° consolidado");
*/

  public Columna colMedioPago;
  public Columna colMoneda;
  public Columna colImporte;
  public Columna colImporteDivisa;
  public Columna colTipoCambio;
  public Columna colNCheque;
  public Columna colBanco;
  public Columna colTipoTarjeta;
  public Columna colNTarjeta;
  public Columna colNValeCompra;
  public Columna colNConsolidado;

  public TablaCobrarBelcenter(String nombre) {
    super(nombre);
    try {
      initColumns();
      jbInit();
    } catch ( Exception e ) {
      e.printStackTrace();
    }
  }

  public TablaCobrarBelcenter () {
    super("TablaCobrarBelcenter ");
    try {
      initColumns();
      jbInit();
    } catch ( Exception e ) {
      e.printStackTrace();
    }
  }


  private void initColumns(){
    //PropertiesApplet.setProperties(ConstantesBundlesApplet.APPLET_COLUMNS_BUNDLE);
    colMedioPago = new Columna(PropertiesApplet.getPropertie(ConstantesColumnas.COBRAR_BELCENTER_MEDIO_PAGO, ConstantesBundlesApplet.APPLET_COLUMNS_BUNDLE));
    colMoneda = new Columna(PropertiesApplet.getPropertie(ConstantesColumnas.COBRAR_BELCENTER_MONEDA, ConstantesBundlesApplet.APPLET_COLUMNS_BUNDLE));
    colImporte = new Columna(PropertiesApplet.getPropertie(ConstantesColumnas.COBRAR_BELCENTER_IMPORTE, ConstantesBundlesApplet.APPLET_COLUMNS_BUNDLE));
    colImporteDivisa = new Columna(PropertiesApplet.getPropertie(ConstantesColumnas.COBRAR_BELCENTER_IMPORTE_DIVISA, ConstantesBundlesApplet.APPLET_COLUMNS_BUNDLE));
    colTipoCambio = new Columna(PropertiesApplet.getPropertie(ConstantesColumnas.COBRAR_BELCENTER_TIPO_CAMBIO, ConstantesBundlesApplet.APPLET_COLUMNS_BUNDLE));
    colNCheque = new Columna(PropertiesApplet.getPropertie(ConstantesColumnas.COBRAR_BELCENTER_N_CHEQUE, ConstantesBundlesApplet.APPLET_COLUMNS_BUNDLE));
    colBanco = new Columna(PropertiesApplet.getPropertie(ConstantesColumnas.COBRAR_BELCENTER_BANCO, ConstantesBundlesApplet.APPLET_COLUMNS_BUNDLE));
    colTipoTarjeta = new Columna(PropertiesApplet.getPropertie(ConstantesColumnas.COBRAR_BELCENTER_TIPO_TARJETA, ConstantesBundlesApplet.APPLET_COLUMNS_BUNDLE));
    colNTarjeta = new Columna(PropertiesApplet.getPropertie(ConstantesColumnas.COBRAR_BELCENTER_N_TARJETA, ConstantesBundlesApplet.APPLET_COLUMNS_BUNDLE));
    colNValeCompra = new Columna(PropertiesApplet.getPropertie(ConstantesColumnas.COBRAR_BELCENTER_N_VALE_COMPRA, ConstantesBundlesApplet.APPLET_COLUMNS_BUNDLE));
    colNConsolidado = new Columna(PropertiesApplet.getPropertie(ConstantesColumnas.COBRAR_BELCENTER_N_CONSOLIDADO, ConstantesBundlesApplet.APPLET_COLUMNS_BUNDLE));
  }


  private void jbInit() throws Exception {
    setShowGrid( true );
    super.setColorBackground( Color.white );
      
    colMedioPago.setType( Columna.TYPE_ALFANUMERICO );
    colMedioPago.setEditable( false );
    colMedioPago.setWidth( 140 );
    super.add( colMedioPago );
    
    colMoneda.setType( Columna.TYPE_ALFANUMERICO );
    colMoneda.setEditable( false );
    colMoneda.setWidth( 140 );
    super.add( colMoneda );
    
    colImporte.setType( Columna.TYPE_ALFANUMERICO );
    colImporte.setEditable( false );
    colImporte.setWidth( 140 );
    super.add( colImporte );

    colImporteDivisa.setType( Columna.TYPE_ALFANUMERICO );
    colImporteDivisa.setEditable( false );
    colImporteDivisa.setWidth( 140 );
    super.add( colImporteDivisa );
    
    colTipoCambio.setType( Columna.TYPE_ALFANUMERICO );
    colTipoCambio.setEditable( false );
    colTipoCambio.setWidth( 140 );
    super.add( colTipoCambio );
    
    colNCheque.setType( Columna.TYPE_ALFANUMERICO );
    colNCheque.setEditable( false );
    colNCheque.setWidth( 140 );
    super.add( colNCheque );

    colBanco.setType( Columna.TYPE_ALFANUMERICO );
    colBanco.setEditable( false );
    colBanco.setWidth( 140 );
    super.add( colBanco );

    colTipoTarjeta.setType( Columna.TYPE_ALFANUMERICO );
    colTipoTarjeta.setEditable( false );
    colTipoTarjeta.setWidth( 140 );
    super.add( colTipoTarjeta );
    
    colNTarjeta.setType( Columna.TYPE_ALFANUMERICO );
    colNTarjeta.setEditable( false );
    colNTarjeta.setWidth( 140 );
    super.add( colNTarjeta );
    
    colNValeCompra.setType( Columna.TYPE_ALFANUMERICO );
    colNValeCompra.setEditable( false );
    colNValeCompra.setWidth( 140 );
    super.add( colNValeCompra );
    
    colNConsolidado.setType( Columna.TYPE_ALFANUMERICO );
    colNConsolidado.setEditable( false );
    colNConsolidado.setWidth( 140 );
    super.add( colNConsolidado );
    
    super.setInsertCapable( false );
    super.setDeleteCapable( true );
    //super.setEditable(true);
    super.init();
  }

  public void this_keyPressed( KeyEvent e ) {
    return;
  }
}