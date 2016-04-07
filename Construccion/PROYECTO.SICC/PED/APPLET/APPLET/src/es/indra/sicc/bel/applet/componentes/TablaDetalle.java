package es.indra.sicc.bel.applet.componentes;

import es.indra.sicc.bel.applet.util.DetalleCobroDevolucion;
//import es.indra.sicc.ped.applet.componentes.Columna;
//import es.indra.sicc.ped.applet.componentes.TablaApplet;
import es.indra.sicc.comunapplet.Columna;
import es.indra.sicc.comunapplet.TablaApplet;
import java.awt.Color;
import java.awt.event.KeyEvent;
import java.math.BigDecimal;

import es.indra.sicc.comunapplet.ConstantesColumnas;
import es.indra.sicc.comunapplet.ConstantesBundlesApplet;
import es.indra.sicc.comunapplet.PropertiesApplet;

public class TablaDetalle extends TablaApplet {
  //Columnas de la grilla solicitud digitada de la panatalla Digitar posiciones
  /*
  public Columna colMedioPago = new Columna("Medio de pago");
  public Columna colMoneda = new Columna("Moneda");
  public Columna colImporte = new Columna("Importe");
  public Columna colTipoCambio = new Columna("Tipo de cambio");
  public Columna colImporteDivisa = new Columna("Importe divisa");
  public Columna colNroNotaCredito = new Columna("Número nota crédito");
*/

  public Columna colMedioPago;
  public Columna colMoneda;
  public Columna colImporte;
  public Columna colTipoCambio;
  public Columna colImporteDivisa;
  public Columna colNroNotaCredito;
   
  public TablaDetalle(String nombre) {
    super(nombre);

    try {
      this.initColumns();
      this.jbInit();
    }catch ( Exception e ) {
      e.printStackTrace();
    }
  }
   
  public TablaDetalle() {
    super("TablaDetalle");

    try{
      this.initColumns();
      this.jbInit();
    }catch ( Exception e ) {
      e.printStackTrace();
    }
  }
   
  public void initColumns(){
    //PropertiesApplet.setProperties(ConstantesBundlesApplet.APPLET_COLUMNS_BUNDLE);
    colMedioPago = new Columna(PropertiesApplet.getPropertie(ConstantesColumnas.DETALLE_MEDIO_PAGO, ConstantesBundlesApplet.APPLET_COLUMNS_BUNDLE));
    colMoneda = new Columna(PropertiesApplet.getPropertie(ConstantesColumnas.DETALLE_MONEDA, ConstantesBundlesApplet.APPLET_COLUMNS_BUNDLE));
    colImporte = new Columna(PropertiesApplet.getPropertie(ConstantesColumnas.DETALLE_IMPORTE, ConstantesBundlesApplet.APPLET_COLUMNS_BUNDLE));
    colTipoCambio = new Columna(PropertiesApplet.getPropertie(ConstantesColumnas.DETALLE_TIPO_CAMBIO, ConstantesBundlesApplet.APPLET_COLUMNS_BUNDLE));
    colImporteDivisa = new Columna(PropertiesApplet.getPropertie(ConstantesColumnas.DETALLE_IMPORTE_DIVISA, ConstantesBundlesApplet.APPLET_COLUMNS_BUNDLE));
    colNroNotaCredito = new Columna(PropertiesApplet.getPropertie(ConstantesColumnas.DETALLE_N_NOTA_CREDITO, ConstantesBundlesApplet.APPLET_COLUMNS_BUNDLE));
  }
   
   private void jbInit() throws Exception {
      setShowGrid( true );
      super.setColorBackground( Color.white );
      
      this.colMedioPago.setType( Columna.TYPE_ALFANUMERICO );
      this.colMedioPago.setEditable( false );
      this.colMedioPago.setWidth( 200 );
      super.add( this.colMedioPago );
      
      this.colMoneda.setType( Columna.TYPE_ALFANUMERICO );
      this.colMoneda.setEditable( false );
      this.colMoneda.setWidth( 80 );
      super.add( this.colMoneda );
  
      this.colImporte.setType( Columna.TYPE_ALFANUMERICO );
      this.colImporte.setEditable( false );
      this.colImporte.setWidth( 90 );
      super.add( this.colImporte );
  
      this.colTipoCambio.setType( Columna.TYPE_ALFANUMERICO );
      this.colTipoCambio.setEditable( false );
      this.colTipoCambio.setWidth( 100 );
      super.add( this.colTipoCambio );
  
      this.colImporteDivisa.setType( Columna.TYPE_ALFANUMERICO );
      this.colImporteDivisa.setEditable( false );
      this.colImporteDivisa.setWidth( 100 );
      super.add( this.colImporteDivisa );
  
      this.colNroNotaCredito.setType( Columna.TYPE_ALFANUMERICO );
      this.colNroNotaCredito.setEditable( false );
      this.colNroNotaCredito.setWidth( 120 );
      super.add( this.colNroNotaCredito );
 
      super.setInsertCapable( false );
      super.setDeleteCapable( false );
      super.init();
   }
//------------------------------------------------------------------------------
   public void this_keyPressed( KeyEvent e ) {
      return;
   }
//-------------------------
   public void addFila( DetalleCobroDevolucion dto ) {
    int row = this.getRowCount();
    this.newRow();
    
    
    this.colMedioPago.setText( dto.getMedioPago()!=null?dto.getMedioPago():"", row );
    this.colMoneda.setText(dto.getMoneda()!=null?dto.getMoneda():"", row );
    this.colImporte.setText( dto.getImporte() != null ? dto.getImporte().toString() : "", row );
    this.colTipoCambio.setText( dto.getTipoCambio()!=null?dto.getTipoCambio():"", row );
    this.colImporteDivisa.setText(dto.getImporteDivisa() != null ? dto.getImporteDivisa().toString() : "", row);
    this.colNroNotaCredito.setText(dto.getNumeroNotaCredito()!=null?dto.getNumeroNotaCredito():"", row);
    
    this.deleteEmptyRows();
    
    int tamActual = this.getRowCount();
    if(row == tamActual) {
      this.setRowSelectionInterval(row - 1, row - 1);  
    } else {
      this.setRowSelectionInterval(row, row);
    }
  } 
  
  public DetalleCobroDevolucion getSelectedFile() {
    DetalleCobroDevolucion dto = new DetalleCobroDevolucion();
    int row = this.getSelectedRow();
    dto.setMedioPago(this.colMedioPago.getText( row ));
    dto.setMoneda(this.colMoneda.getText(row ));
    if(!"".equals(this.colImporte.getText( row ))) {
      dto.setImporte(new BigDecimal(this.colImporte.getText( row )));
    }
    dto.setTipoCambio(this.colTipoCambio.getText( row ));
    if(!"".equals(this.colImporteDivisa.getText(row))) {
      dto.setImporteDivisa(new BigDecimal(this.colImporteDivisa.getText(row)));
    }
    dto.setNumeroNotaCredito(this.colNroNotaCredito.getText(row));
    
    return dto;
  }
  
  public void updateFila( DetalleCobroDevolucion dto ) {
    int row = this.getSelectedRow();
    this.colMedioPago.setText( dto.getMedioPago(), row );
    this.colMoneda.setText(dto.getMoneda(), row );
    this.colImporte.setText( dto.getImporte() != null ? dto.getImporte().toString() : "", row );
    this.colTipoCambio.setText( dto.getTipoCambio(), row );
    this.colImporteDivisa.setText(dto.getImporteDivisa() != null ? dto.getImporteDivisa().toString() : "", row);
    this.colNroNotaCredito.setText(dto.getNumeroNotaCredito(), row);
    
    this.refresh(row);
  } 
  
}