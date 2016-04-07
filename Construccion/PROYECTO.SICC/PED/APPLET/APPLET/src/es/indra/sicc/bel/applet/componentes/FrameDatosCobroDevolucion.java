package es.indra.sicc.bel.applet.componentes;

import es.indra.mare.common.dto.MareDTO;
import es.indra.sicc.bel.applet.GestorCobrosDevolucionesApplet;
import es.indra.sicc.comunapplet.ConstantesApplet;
import es.indra.sicc.comunapplet.Dialogos;
import es.indra.sicc.comunapplet.UtilApplet;
import es.indra.sicc.dtos.bel.DTOApplet;
import es.indra.sicc.dtos.bel.DTOCargaMedioPago;
import es.indra.sicc.dtos.bel.DTOCargaMoneda;
import es.indra.sicc.dtos.bel.DTODatosCobroDevolucion;
import es.indra.sicc.dtos.bel.DTOObtenerSolicitudCobro;
import es.indra.sicc.logicanegocio.bel.ConstantesBEL;
//import es.indra.sicc.comunapplet.applet.componentes.ComboBoxApplet;
import es.indra.sicc.comunapplet.ComboBoxApplet;
import es.indra.sicc.comunapplet.exceptions.AppletException;
import es.indra.sicc.util.DTOOID;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.math.BigDecimal;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JDialog;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.KeyEvent;

import es.indra.sicc.bel.applet.util.DetalleCobroDevolucion;
import javax.swing.border.EtchedBorder;


public class FrameDatosCobroDevolucion extends JDialog
{
  private GestorCobrosDevolucionesApplet applet = null;

  private boolean               importeObligatorio = false;
  private boolean               notaCreditoObligatorio = false;
  private Long                  oidSolicitudNotaCredito = null;
  private DetalleCobroDevolucion detalleCobroDevolucion = null;
  private JLabel                    lblMedioPago             =new JLabel();
  private JLabel                    lblMoneda                  =new JLabel();
  private ComboBoxApplet cbMedioPago = new ComboBoxApplet();
  private ComboBoxApplet cbMoneda = new ComboBoxApplet();
  private JLabel                    lblImporte                  =new JLabel();
  private JLabel                    lblImporteDivisa        =new JLabel();
  private JLabel                    lblTipoCambio           =new JLabel();
  private JLabel                    lbltxtTipoCambio  =new JLabel();
  private JLabel                    lblNotaCredito         =new JLabel();
  private JTextField             txtImporte = new JTextField();
  private JTextField             txtImporteDivisa = new JTextField();
  private JTextField             txtNumeroNotaCredito = new JTextField();
  private JButton                  btnAceptar                =new JButton();
  private JButton                  btnSalir                =new JButton();
  private String                    sTitle                          =null;
  private JPanel                    pnDatosCobro         =new JPanel();
  private JPanel                    pnButtons                 =new JPanel();
  
  private JLabel                    lblMedioPagoObligatorio = new JLabel();
  
  private int                       height = 0;
  private int                       width = 0;
  private int                       hSpace = 0;
  private int                       vSpace = 0;
  private int                       btnheight = 0;
  private int                       btnwidth = 0;
  
  private boolean anadirFila = false;
  
  
   public FrameDatosCobroDevolucion( String sTitle, GestorCobrosDevolucionesApplet applet) {
        this.applet = applet;
        this.sTitle = sTitle;
        this.height=220;
        this.width=650;
        try {
          initComponents();
        } catch ( Exception e ) {
          e.printStackTrace();
        }
        setSize( new Dimension( width, height ) );
        setResizable( false );
        getContentPane().setBackground(new Color(242,242,241));
    }
  private void initComponents() throws Exception
  {
      //Dimensions  
        this.hSpace=6;
        this.vSpace=6;
        this.btnheight=20;
        this.btnwidth=90;
        
      //Backgournds
        Color Background = new Color(242,242,241);
        Color ButtonBack = new Color(5, 123, 162);
        Color Blanco = new Color (255, 255, 255);
        //pnButtons.setBackground( Background);
        pnDatosCobro.setBackground(Background);
        getContentPane().setBackground(Background);
        btnAceptar.setBackground(ButtonBack );        
        btnSalir.setBackground(ButtonBack );        
        
      //Layouts
            getContentPane().setLayout( null );
            pnButtons.setLayout( null);
            pnDatosCobro.setLayout( null );
        
      //Borders
            pnDatosCobro.setBorder(new javax.swing.border.TitledBorder(new EtchedBorder(),"Datos Detalle"));
        
      //atributes
        cbMedioPago.setEditable(true);
        cbMedioPago.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbMedioPago_onChange();
            }
        });
        
        cbMoneda.setEditable(true);
        cbMoneda.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbMoneda_onChange();
            }
        });
        
        btnAceptar.setForeground( Blanco);
        btnAceptar.setText( "Aceptar" );
        btnAceptar.setMnemonic( KeyEvent.VK_A );
        btnAceptar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
               btnAceptar_click();
            }
        });
        
        btnSalir.setForeground( Blanco);
        btnSalir.setText( "Salir" );
        btnSalir.setMnemonic( KeyEvent.VK_S );
        btnSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
              salir();
            }
        });
        
        
        setTitle( this.sTitle );
        lblMedioPagoObligatorio.setText("(*)");
        lblMedioPagoObligatorio.setFont(new Font ( "Arial", Font.BOLD, 11 ) );
        lblMedioPagoObligatorio.setForeground(Color.RED);
        lblMedioPago.setText("Medio pago");
        lblMedioPago.setFont( new Font ( "Arial", Font.BOLD, 11 ) );
        lblMoneda.setText("Moneda");
        lblMoneda.setFont( new Font ( "Arial", Font.BOLD, 11 ) );
        lblImporte.setText("Importe");
        lblImporte.setFont( new Font ( "Arial", Font.BOLD, 11 ) );
        lblImporteDivisa.setText("Importe divisa");
        lblImporteDivisa.setFont( new Font ( "Arial", Font.BOLD, 11 ) );
        lblTipoCambio.setText("Tipo Cambio");
        lblTipoCambio.setFont( new Font ( "Arial", Font.BOLD, 11 ) );
        lbltxtTipoCambio.setText("");
        lbltxtTipoCambio.setFont( new Font ( "Arial", Font.PLAIN, 11 ) );
        lblNotaCredito.setText("Nota Crédito");
        lblNotaCredito.setFont( new Font ( "Arial", Font.BOLD, 11 ) );
        
      //Adds
        pnButtons.add( btnAceptar );
        pnDatosCobro.add(lblMedioPago);
        pnDatosCobro.add(cbMedioPago);
        pnDatosCobro.add(lblMedioPagoObligatorio);
        pnDatosCobro.add(lblMoneda);
        pnDatosCobro.add(cbMoneda);
        pnDatosCobro.add(lblImporte);
        pnDatosCobro.add(txtImporte);
        pnDatosCobro.add(lblImporteDivisa);
        pnDatosCobro.add(txtImporteDivisa);
        pnDatosCobro.add(lblTipoCambio);
        pnDatosCobro.add(lbltxtTipoCambio);
        pnDatosCobro.add(lblNotaCredito);
        pnDatosCobro.add(txtNumeroNotaCredito);
        getContentPane().add( pnButtons );        
        getContentPane().add( pnDatosCobro );

      //Bounds
        pnDatosCobro.setBounds(this.hSpace, this.vSpace, this.width-2*this.hSpace, this.height-8*this.vSpace-this.btnheight);
        pnButtons.setBounds(this.hSpace+2, this.height-6*this.vSpace-this.btnheight, this.width-3*this.hSpace, this.btnheight);
        btnAceptar.setBounds( 0, 0, this.btnwidth, this.btnheight );
        lblMedioPago.setBounds(15,20,80,20);
        cbMedioPago.setBounds(15,40,230,20);
        lblMedioPagoObligatorio.setBounds(250,40,130,20);
        lblMoneda.setBounds(280,20,80,20);
        cbMoneda.setBounds(280,40,200,20);
        lblImporte.setBounds(510,20,80,20);
        txtImporte.setBounds(510,40,120,20);
        lblImporteDivisa.setBounds(15,60,80,20);
        txtImporteDivisa.setBounds(15,80,100,20);
        lblTipoCambio.setBounds(135,60,80,20);
        lbltxtTipoCambio.setBounds(135,80,80,20);        
        lblNotaCredito.setBounds(510,60,120,20);
        txtNumeroNotaCredito.setBounds(510,80,120,20);
        
        txtImporteDivisa.addFocusListener(new FocusAdapter () {
          public void focusLost ( FocusEvent evt ) {
            txtImporteDivisa_lostFocus();
          }
        });
        
        pack();
        
  }
  
  public void inicializar() {
    try {
      this.anadirFila = false;
      if (this.applet.getCargaDatosDetalle() == null) {
        DTOOID dtoid = new DTOOID();
        dtoid.setOidPais(this.applet.getOidPais());
        dtoid.setOidIdioma(this.applet.getOidIdioma());
        dtoid.setOid(this.applet.getCache().getOidSubAcceso());
        DTOApplet dtoApplet = new DTOApplet();
        dtoApplet.setDto(dtoid);
        dtoApplet.setUserName(this.applet.getUsuario());
        //dtoid.setProperty(ConstantesApplet.USER_NAME, this.applet.getUsuario());
        MareDTO mare = this.applet.ejecutarNegocio(
                          "BELCargaDatosCobroDevolucion" , 
                          "es.indra.sicc.dtos.bel.DTOApplet",
                          dtoApplet);
                          
        if(mare instanceof DTODatosCobroDevolucion) {
          // Guardamos la información para las sucesivas 
          DTODatosCobroDevolucion datos = (DTODatosCobroDevolucion) mare;
          this.applet.setCargaDatosDetalle(datos);
          
          this.cargarDatos();
        } else {
          System.out.println("Mare tiene: " + mare);
          System.out.println("La clase es: " + mare.getClass().getName());
        }
      } else {
        this.cargarDatos();
      }
    } catch (AppletException e) {
      UtilApplet.procesarError(e, this);
    }
  }
  
  private void cargarDatos() {
    DTODatosCobroDevolucion datos = this.applet.getCargaDatosDetalle();
    //Carga la información de pantalla: 
    this.cargarComboMoneda(datos.getMoneda());
    this.cargarComboMedioPago(datos.getMedioPago());
    
    if("Cobro".equals(this.applet.getAccion())) {
      this.txtNumeroNotaCredito.setVisible(false);
      this.lblNotaCredito.setVisible(false);
    }
  }
  
  private void cargarComboMoneda(DTOCargaMoneda dto) {
    this.cbMoneda.removeAllItems();
    this.cbMoneda.addItem("","");
    if(dto != null && dto.getOid() != null) {
      this.cbMoneda.addItem(dto.getOid().toString(), dto.getDescripcion());    
    }
  }

  private void cargarComboMedioPago(DTOCargaMedioPago[] dto) {
    this.cbMedioPago.removeAllItems();
    this.cbMedioPago.addItem("","");
    if(dto != null) {
      boolean agregar = false;
      Long oid = null;
      String desc = null;
      for (int i = 0; i < dto.length; ++i) {
        oid = dto[i].getOidTipoMedioPago();
        desc = dto[i].getDescripcion();
            
        if("Devolucion".equals(this.applet.getAccion())) {
          if ( ConstantesBEL.TIPO_MP_EFECTIVO.equals(oid) || 
                ConstantesBEL.TIPO_MP_NOTA_CREDITO.equals(oid)) {
            agregar = true;            
          }
        } else if("Cobro".equals(this.applet.getAccion())) {
          if(ConstantesBEL.TIPO_MP_VENTA_CCC.equals(oid)) {
            agregar = true;
          }
        }
        if(agregar) {
          oid = dto[i].getOid();  
          this.cbMedioPago.addItem(oid.toString(), desc);        
          agregar = false;
        }
      }      
    }
  }
  
  
  private void cbMoneda_onChange() {
  System.out.println("cbMoneda_onChange() de frameDatosCobroDevolucion /////////////////");
    if("".equals(this.cbMoneda.getKey())) {
      this.txtImporte.setEnabled(true);
      this.txtImporte.setText("");
      this.txtImporteDivisa.setEnabled(false);
      this.txtImporteDivisa.setText("");
      this.lbltxtTipoCambio.setText("");
      this.importeObligatorio = true;
    } else {
      this.txtImporte.setEnabled(false);
      this.txtImporte.setText("");
      this.txtImporteDivisa.setEnabled(true);
      this.txtImporteDivisa.setText("");
      
      // Muestra el valor del tipo de cambio. Se redondea al número de decimales 
      //especificado en GestorCobrosDevoluciones.cargaDatosDetalle.moneda.numeroDecimales 
      String tipoCambio = this.applet.getCargaDatosDetalle().getTipoCambio().toString();
      if (this.applet.getCargaDatosDetalle().getMoneda().getDecimales() != null) {
        tipoCambio = this.redondearImporte(tipoCambio);
      }
      this.lbltxtTipoCambio.setText(tipoCambio);

      this.importeObligatorio = false;
    }
  }
  
  private void cbMedioPago_onChange() { 
    System.out.println("cbMedioPago_onChange() de frameDatosCobroDevolucion /////////////////");
    if(!"".equals(this.cbMedioPago.getKey())) {
      Long key = new Long(this.cbMedioPago.getKey());
      if("Devolucion".equals(this.applet.getAccion())) {
        DTOCargaMedioPago []dtosMedioMago = this.applet.getCargaDatosDetalle().getMedioPago();
        DTOCargaMedioPago dtoMedioMago = null;
        for (int i = 0; dtosMedioMago != null && dtoMedioMago == null && i < dtosMedioMago.length ; ++i) {
          if(key.equals(dtosMedioMago[i].getOid())) {
            dtoMedioMago = dtosMedioMago[i];
          }          
        }
        this.txtNumeroNotaCredito.setEnabled(false);
        this.notaCreditoObligatorio = false;
        
        //System.out.println("ConstantesBEL.TIPO_MP_NOTA_CREDITO: " + ConstantesBEL.TIPO_MP_NOTA_CREDITO);
        //System.out.println("dtoMedioMago.getOidTipoMedioPago(): " + (dtoMedioMago != null ? "1" + dtoMedioMago.getOidTipoMedioPago() : "2 null"));
        
        if(dtoMedioMago != null && ConstantesBEL.TIPO_MP_NOTA_CREDITO.equals(dtoMedioMago.getOidTipoMedioPago())) {
          this.txtNumeroNotaCredito.setEnabled(true);
          this.notaCreditoObligatorio = true;
        }
      } 
    }
  }
  
  private void btnAceptar_click() {
    
    boolean obligatoriosOk = this.camposObligatoriosCargados();  
    if(!obligatoriosOk) {
      //Dialogos.mensajeAceptar(ConstantesApplet.ERROR_FALTA_COMPLETAR_CAMPO_OBLIGATORIO, this);
    } else {
     // Valida el consolidado 
      if(this.notaCreditoObligatorio) {
        try {
          DTOObtenerSolicitudCobro dtoCobro = new DTOObtenerSolicitudCobro();
          dtoCobro.setOidPais(this.applet.getOidPais());
          dtoCobro.setOidSubacceso(this.applet.getCache().getOidSubAcceso());
          dtoCobro.setNumeroSolicitud(this.txtNumeroNotaCredito.getText());
          
          if (!"".equals(this.txtImporte.getText())) {
            try {
              dtoCobro.setImporte(new BigDecimal(this.txtImporte.getText()));
            } catch (NumberFormatException e) {
              this.txtImporte.requestFocus();
              Dialogos.mensajeAceptar(ConstantesApplet.NUMERO_INVALIDO, this);
              return;
            }
          }
          if (!"".equals(this.txtImporteDivisa.getText())) {
            try {
              dtoCobro.setImporteDivisa(new BigDecimal(this.txtImporteDivisa.getText()));
            } catch (NumberFormatException e) {
              this.txtImporteDivisa.requestFocus();
              Dialogos.mensajeAceptar(ConstantesApplet.NUMERO_INVALIDO, this);
              return;
            }
          }
          
          MareDTO mare = this.applet.ejecutarNegocio(
                  "BELObtenerSolicitudCobro" , 
                  "es.indra.sicc.dtos.bel.DTOObtenerSolicitudCobro",
                  dtoCobro); 
                            
          if(mare instanceof DTOOID) {
            this.oidSolicitudNotaCredito = ((DTOOID)mare).getOid();            
            this.anadirFila = true;
          } else {
            Dialogos.mensajeError(ConstantesApplet.ERROR_AL_OBTENER_SOLICITUD_COBRO, this);
          }
          this.setVisible(false);
        } catch (AppletException e) {
          UtilApplet.procesarError(e, this);
        }
      } else {      
        this.setVisible(false);
        this.anadirFila = true;
      }
      
      
    }
  }
  
  /**
   * Se comprueban los datos:
   *  - cbMedioPago 
   *  - txtImporte (Si importeObligatorio == True) 
   *  - txtImporteDivisa (Si importeObligatorio == False) 
   *  - txtNumeroNotaCredito (Si notaCreditoObligatorio == True) 
   *  
   * @return 
   */
  private boolean camposObligatoriosCargados() {
    boolean ok = true;
    
    if("".equals(this.cbMedioPago.getKey())) {
      ok = false;
      this.cbMedioPago.requestFocus();
      Dialogos.mensajeAceptar(ConstantesApplet.ERROR_FALTA_CAMPO_OBLIGATORIO, "Medio pago.", this);
    } else if(this.importeObligatorio
                && "".equals(this.txtImporte.getText().trim())) {
      ok = false;
      this.txtImporte.requestFocus();
      Dialogos.mensajeAceptar(ConstantesApplet.ERROR_FALTA_CAMPO_OBLIGATORIO, "Importe.", this);
    } else if(!this.importeObligatorio
                && "".equals(this.txtImporteDivisa.getText().trim())) {
      ok = false;
      this.txtImporteDivisa.requestFocus();
      Dialogos.mensajeAceptar(ConstantesApplet.ERROR_FALTA_CAMPO_OBLIGATORIO, "Importe divisa.", this);
    } else if(this.notaCreditoObligatorio
                && "".equals(this.txtNumeroNotaCredito.getText().trim())) {
      ok = false;
      this.txtNumeroNotaCredito.requestFocus();
      Dialogos.mensajeAceptar(ConstantesApplet.ERROR_FALTA_CAMPO_OBLIGATORIO, "Numero nota credito.", this);
    } 
    
    return ok;
  }
  
  private void txtImporteDivisa_onChange() {
    
      BigDecimal importeDivisa = null;
      BigDecimal tipoCambio = null;
    try {  
      importeDivisa = new BigDecimal(this.txtImporteDivisa.getText());
    } catch (NumberFormatException e) {
      this.txtImporteDivisa.requestFocus();
      Dialogos.mensajeAceptar(ConstantesApplet.NUMERO_INVALIDO, this);
      return;
    }  
    try {  
      tipoCambio = new BigDecimal(this.lbltxtTipoCambio.getText());
    } catch (NumberFormatException e) {
      this.lbltxtTipoCambio.requestFocus();
      Dialogos.mensajeAceptar(ConstantesApplet.NUMERO_INVALIDO, this);
      return;
    }
    
    String importe = importeDivisa.divide(tipoCambio, BigDecimal.ROUND_HALF_DOWN).toString();
    this.txtImporte.setText(importe);
      
    
  }
  
  private String redondearImporte(String importe) {
    //TODO ver si viene punto o coma como separador
    int cantDecimales = this.applet.getCargaDatosDetalle().getMoneda().getDecimales().intValue();
    if(importe.indexOf(".") > -1) {
      importe = importe.substring(0, importe.indexOf(".") + cantDecimales);
    }
    return importe;
  }
  
  public void seleccionarValoresDefecto() {
    if (this.cbMedioPago.getItemCount() > 1) {
      this.cbMedioPago.setSelectedIndex(1);
    }
    
    if(this.cbMoneda.getItemCount() > 0) {
      this.cbMoneda.setSelectedIndex(0);
    }
    //cbBanco
    //cbTipoTarjeta
    // Carga los datos asociados a la moneda local 
    this.cbMoneda_onChange();
    // Muestra los datos asociados al medio de pago 
    this.cbMedioPago_onChange();
    
    this.anadirFila = false;
  }
  
  public DetalleCobroDevolucion generarDetalleCobroDevolucion() {
    DetalleCobroDevolucion fila = new DetalleCobroDevolucion();
    fila.setMedioPago((String)this.cbMedioPago.getSelectedItem());
    //fila.setMoneda(this.cbMoneda.getKey().toString());
    fila.setMoneda((String)this.cbMoneda.getSelectedItem());
    
    if(!"".equals(this.txtImporte.getText().trim()) ) {
      fila.setImporte(new BigDecimal(this.txtImporte.getText()));
    } else {
      fila.setImporte(new BigDecimal(0));
    }
    if(!"".equals(this.txtImporteDivisa.getText().trim()) ) {
      fila.setImporteDivisa(new BigDecimal(this.txtImporteDivisa.getText()));
    } else {
      fila.setImporteDivisa(new BigDecimal(0));
    }
    fila.setTipoCambio(this.lbltxtTipoCambio.getText());
    if("Devolucion".equals(this.applet.getAccion()))  {
      fila.setNumeroNotaCredito(this.txtNumeroNotaCredito.getText());
    }

    return fila;
  }
  
  public void mostrarDetalle(DetalleCobroDevolucion fila) {
    //System.out.println("medio pago e la fial: " + fila.getMedioPago());
    
    for (int i = 0; i < this.cbMedioPago.getItemCount(); ++i) {
      String text = (String)this.cbMedioPago.getItemAt(i);
      //System.out.println("texto en la posicion " + i + ": " + text);
      if(text.equals(fila.getMedioPago())) {
        this.cbMedioPago.setSelectedIndex(i);      
      }
    }
    
    //System.out.println("moneda en la fial: " + fila.getMoneda());
    for (int i = 0; i < this.cbMoneda.getItemCount(); ++i) {
      String text = (String)this.cbMoneda.getItemAt(i);
      //System.out.println("moneda en la posicion " + i + ": " + text);
      if(text.equals(fila.getMoneda())) {
        this.cbMoneda.setSelectedIndex(i);      
      }
    }
    
//    this.cbMedioPago.setSelectedIndexByKey(fila.getMedioPago());
//    this.cbMoneda.setSelectedIndexByKey(fila.getMoneda()); 
    this.txtImporte.setText(fila.getImporte() != null ? fila.getImporte().toString() : ""); 
    this.txtImporteDivisa.setText(fila.getImporteDivisa() != null ? fila.getImporteDivisa().toString() : ""); 
    this.lbltxtTipoCambio.setText(fila.getTipoCambio()); 
    
    if("Devolucion".equals(this.applet.getAccion()))  {
      this.txtNumeroNotaCredito.setText(fila.getNumeroNotaCredito());
    }
  }
  
  private void txtImporteDivisa_lostFocus() {
    if(!"".equals(this.txtImporteDivisa.getText().trim())) {
      try {
        double impDiv = Double.parseDouble(this.txtImporteDivisa.getText().trim());
        double tasa = Double.parseDouble(this.lbltxtTipoCambio.getText());
        
        this.txtImporte.setText("" + (impDiv / tasa));
      } catch (NumberFormatException e) {
        //TODO
        this.txtImporteDivisa.requestFocus();
        Dialogos.mensajeError(ConstantesApplet.NUMERO_INVALIDO, this);
        
      }
      
    }
  }

  public ComboBoxApplet getCbMedioPago()
  {
    return this.cbMedioPago;
  }
  public ComboBoxApplet getCbMoneda()
  {
    return this.cbMoneda;
  }
  public JTextField getTxtImporte()
  {
    return this.txtImporte;
  }
  public JTextField getTxtImporteDivisa()
  {
  return this.txtImporteDivisa;
  }
  public void setTxtTipoCambio(String value)
  {
    this.lbltxtTipoCambio.setText(value);
  }
  public void setImporteObligatorio(boolean value)
  {
    this.importeObligatorio=value;
  }
 public JTextField getTxtNumeroNotaCredito()
 {
  return this.txtNumeroNotaCredito;
 }
 public void setNotaCreditoObligatorio(boolean value)
 {
  this.notaCreditoObligatorio=value;
 }
 public boolean getImporteObligatorio()
 {
  return this.importeObligatorio;
 }
 public boolean getNotaCreditoObligatorio()
 {
  return this.notaCreditoObligatorio;
 }
 public void setTxtImporte(String value)
 {
  this.txtImporte.setText(value);
 }
 public void setTxtImporteDivisa(String value)
 {
  this.txtImporteDivisa.setText(value);
 }
 public JLabel getTxtTipoCambio()
 {
  return this.lbltxtTipoCambio;
 }
 
 public void setOidSolicitudNotaCredito(Long l) {
   this.oidSolicitudNotaCredito = l;
 }
  public Long getOidSolicitudNotaCredito() {
    return this.oidSolicitudNotaCredito;
  }
  
  private void salir() {
    this.setVisible(false);
  }
  
  public boolean getAnadirFila() {
    return this.anadirFila;
  }
}