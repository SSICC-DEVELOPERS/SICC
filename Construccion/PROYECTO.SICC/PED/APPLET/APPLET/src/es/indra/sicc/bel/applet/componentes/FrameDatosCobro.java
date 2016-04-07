/*
 * FrameDatosCobro.java
 *
 * Created on 28 de febrero de 2005, 14:08
 */
package es.indra.sicc.bel.applet.componentes;

import es.indra.sicc.comunapplet.ComboBoxApplet;
import es.indra.sicc.comunapplet.ConstantesBotones;
import es.indra.sicc.comunapplet.ConstantesBundlesApplet;
import es.indra.sicc.comunapplet.ConstantesLabels;
import es.indra.sicc.comunapplet.PropertiesApplet;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Insets;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;
//import es.indra.sicc.ped.applet.util.ConstantesApplet;
//import es.indra.sicc.ped.applet.componentes.ComboBoxApplet;

/**
 *
 * @author  pluna
  */

public class FrameDatosCobro extends JDialog{

  //Referencia al controller
  private DatosCobro datosCobro;

  private boolean               importeObligatorio;
  private boolean               BancoObligatorio;
  private boolean               chequeObligatorio;
  private boolean               tarjetaObligatorio;
  private boolean               valeCompraObligatorio;
  private boolean               notaCreditoObligatorio;
  private String                    sTitle                          =null;
  private JPanel                    pnDatosCobro         =new JPanel();
  private JPanel                    pnButtons                 =new JPanel();
  private JButton                  btnAceptar                =new JButton();
  private JLabel                    lblMedioPago             =new JLabel();
  private JLabel                    lblMoneda                  =new JLabel();
  private JLabel                    lblImporte                  =new JLabel();
  private JLabel                    lblImporteDivisa        =new JLabel();
  private JLabel                    lblTipoCambio           =new JLabel();
  private JLabel                    txtTipoCambio  =new JLabel();
  private JLabel                    lblBanco                      =new JLabel();
  private JLabel                    lblNCheque                 =new JLabel();
  private JLabel                    lblTipoTarjeta             =new JLabel();
  private JLabel                    lblNTarjeta                  =new JLabel();
  private JLabel                    lblNValeCompra         =new JLabel();
  private JLabel                    lblNNotaCredito         =new JLabel();
  private JLabel                    lblMedioPagoObligatorio = new JLabel();
  private ComboBoxApplet cbMedioPago = new ComboBoxApplet();
  private ComboBoxApplet cbMoneda = new ComboBoxApplet();
  private ComboBoxApplet cbBanco = new ComboBoxApplet();
  private ComboBoxApplet cbTipoTarjeta = new ComboBoxApplet();
  private  JTextField             txtImporte = new JTextField();
  private  JTextField             txtImporteDivisa = new JTextField();
  private  JTextField             txtNumeroCheque = new JTextField();
  private  JTextField             txtNumeroTarjeta = new JTextField();
  private  JTextField             txtNumeroValeCompra= new JTextField();
  private  JTextField             txtNumeroNotaCredito = new JTextField();
  private Long                      oidSolicitudNotaCredito;
  
  private int                       height;
  private int                       width;
  private int                       hSpace;
  private int                       vSpace;
  private int                       btnheight;
  private int                       btnwidth;
  
  
  public FrameDatosCobro(DatosCobro datosCobro, String sTitle){
    this(sTitle);
    this.datosCobro = datosCobro;
  }
  
  public FrameDatosCobro( String sTitle) {
        
    this.sTitle = sTitle;
    this.height=220;
    this.width=650;
        
    Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
    
    int xPos = (int)(d.getWidth() - 650)/2;
    int yPos = (int)(d.getHeight() - 220)/2;

    this.setBounds(xPos, yPos, 650, 220);
        
    try {
      initComponents();
    } catch ( Exception e ) {
      e.printStackTrace();
    }
    
    //setSize( new Dimension( width, height ) );
    
    setResizable( false );
    getContentPane().setBackground(new Color(242,242,241));
    
    this.setModal(true);
  }
  
  private void initComponents() throws Exception{
  
    Font contentFont = new Font("Arial", Font.PLAIN, 11);
  
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
        
      //Layouts
      getContentPane().setLayout( null );
      
      FlowLayout pnButtonsLayout = new FlowLayout();
      pnButtonsLayout.setAlignment(FlowLayout.LEFT);
      pnButtonsLayout.setHgap(0);
      pnButtonsLayout.setVgap(0);
      pnButtons.setLayout(pnButtonsLayout);
      
      pnDatosCobro.setLayout( null );
        
      //Borders
      //pnDatosCobro.setBorder(new javax.swing.border.TitledBorder(new EtchedBorder(),"Datos Detalle"));
        
      pnDatosCobro.setBorder(new CompoundBorder(new EmptyBorder(
        new Insets(1, 1, 1, 1)), new TitledBorder(
        new EtchedBorder(), "Datos Detalle", TitledBorder.DEFAULT_JUSTIFICATION, 
        TitledBorder.DEFAULT_POSITION, new Font("Dialog", 1, 11), new Color(153, 153, 153))));
      
        pnButtons.setBorder(new javax.swing.border.EtchedBorder());
        
      //atributes
        cbMedioPago.setEditable(true);
        
        cbBanco.setEditable(true);
        cbMoneda.setEditable(true);
        cbTipoTarjeta.setEditable(true);
        btnAceptar.setForeground( Blanco);
        
        //Asignacion a botones
        //PropertiesApplet.setProperties(ConstantesBundlesApplet.APPLET_BUTTONS_BUNDLE);
        btnAceptar.setText(PropertiesApplet.getPropertie(ConstantesBotones.BUTTON_ACEPTAR, ConstantesBundlesApplet.APPLET_BUTTONS_BUNDLE));

        //Asignacion a labels
        //PropertiesApplet.setProperties(ConstantesBundlesApplet.APPLET_LABELS_BUNDLE);
        
        btnAceptar.setMnemonic( KeyEvent.VK_A );
        setTitle( this.sTitle );
        lblMedioPagoObligatorio.setText("(*)");
        lblMedioPagoObligatorio.setFont(new Font ( "Arial", Font.BOLD, 11 ) );
        lblMedioPagoObligatorio.setForeground(Color.RED);
        
        lblMedioPago.setText(PropertiesApplet.getPropertie(ConstantesLabels.LABEL_MEDIO_PAGO, ConstantesBundlesApplet.APPLET_LABELS_BUNDLE));
        lblMedioPago.setFont( new Font ( "Arial", Font.BOLD, 11 ) );
        
        lblMoneda.setText(PropertiesApplet.getPropertie(ConstantesLabels.LABEL_MONEDA, ConstantesBundlesApplet.APPLET_LABELS_BUNDLE));
        lblMoneda.setFont( new Font ( "Arial", Font.BOLD, 11 ) );
        
        lblImporte.setText(PropertiesApplet.getPropertie(ConstantesLabels.LABEL_IMPORTE, ConstantesBundlesApplet.APPLET_LABELS_BUNDLE));
        lblImporte.setFont( new Font ( "Arial", Font.BOLD, 11 ) );
        
        lblImporteDivisa.setText(PropertiesApplet.getPropertie(ConstantesLabels.LABEL_IMPORTE_DIVISA, ConstantesBundlesApplet.APPLET_LABELS_BUNDLE));
        lblImporteDivisa.setFont( new Font ( "Arial", Font.BOLD, 11 ) );
        
        lblTipoCambio.setText(PropertiesApplet.getPropertie(ConstantesLabels.LABEL_TIPO_CAMBIO, ConstantesBundlesApplet.APPLET_LABELS_BUNDLE));
        lblTipoCambio.setFont( new Font ( "Arial", Font.BOLD, 11 ) );
        txtTipoCambio.setText("");
        
        txtTipoCambio.setHorizontalAlignment(JLabel.RIGHT);
        
        txtTipoCambio.setFont( new Font ( "Arial", Font.PLAIN, 11 ) );
        
        lblBanco.setText(PropertiesApplet.getPropertie(ConstantesLabels.LABEL_BANCO, ConstantesBundlesApplet.APPLET_LABELS_BUNDLE));
        lblBanco.setFont( new Font ( "Arial", Font.BOLD, 11 ) );
        
        lblNCheque.setText(PropertiesApplet.getPropertie(ConstantesLabels.LABEL_N_CHEQUE, ConstantesBundlesApplet.APPLET_LABELS_BUNDLE));
        lblNCheque.setFont( new Font ( "Arial", Font.BOLD, 11 ) );
        
        lblTipoTarjeta.setText(PropertiesApplet.getPropertie(ConstantesLabels.LABEL_TIPO_TARJETA, ConstantesBundlesApplet.APPLET_LABELS_BUNDLE));
        lblTipoTarjeta.setFont( new Font ( "Arial", Font.BOLD, 11 ) );
        
        lblNTarjeta.setText(PropertiesApplet.getPropertie(ConstantesLabels.LABEL_N_TARJETA, ConstantesBundlesApplet.APPLET_LABELS_BUNDLE));
        lblNTarjeta.setFont( new Font ( "Arial", Font.BOLD, 11 ) );
        
        lblNValeCompra.setText(PropertiesApplet.getPropertie(ConstantesLabels.LABEL_N_VALE_COMPRA, ConstantesBundlesApplet.APPLET_LABELS_BUNDLE));
        lblNValeCompra.setFont( new Font ( "Arial", Font.BOLD, 11 ) );
        
        lblNNotaCredito.setText(PropertiesApplet.getPropertie(ConstantesLabels.LABEL_N_NOTA_CREDITO, ConstantesBundlesApplet.APPLET_LABELS_BUNDLE));
        lblNNotaCredito.setFont( new Font ( "Arial", Font.BOLD, 11 ) );
        
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
        pnDatosCobro.add(txtTipoCambio);
        pnDatosCobro.add(lblBanco);
        pnDatosCobro.add(cbBanco);
        pnDatosCobro.add(lblNCheque);
        pnDatosCobro.add(txtNumeroCheque);
        pnDatosCobro.add(lblTipoTarjeta);
        pnDatosCobro.add(cbTipoTarjeta);
        pnDatosCobro.add(lblNTarjeta);
        pnDatosCobro.add(txtNumeroTarjeta);
        pnDatosCobro.add(lblNValeCompra);
        pnDatosCobro.add(txtNumeroValeCompra);
        pnDatosCobro.add(lblNNotaCredito);
        pnDatosCobro.add(txtNumeroNotaCredito);
        
        this.getContentPane().setLayout( new BorderLayout(0, 2) );
        
        getContentPane().add(pnButtons, BorderLayout.SOUTH);
        getContentPane().add(pnDatosCobro, BorderLayout.CENTER);

      //Bounds
        //pnDatosCobro.setBounds(this.hSpace, this.vSpace, this.width-2*this.hSpace, this.height-8*this.vSpace-this.btnheight);
        //pnButtons.setBounds(this.hSpace+2, this.height-6*this.vSpace-this.btnheight, this.width-3*this.hSpace, this.btnheight);
        btnAceptar.setBounds( 0, 0, this.btnwidth, this.btnheight );
        lblMedioPago.setBounds(15,20,80,20);
        cbMedioPago.setBounds(15,40,230,20);
        lblMedioPagoObligatorio.setBounds(250,40,130,20);
        lblMoneda.setBounds(280,20,80,20);
        cbMoneda.setBounds(280,40,200,20);
        lblImporte.setBounds(510,20,80,20);
        txtImporte.setBounds(510,40,120,20);
        
        //lblImporteDivisa.setBounds(15,60,80,20);
        lblImporteDivisa.setBounds(15,60,80,20);
        
        txtImporteDivisa.setBounds(15,80,100,20);
        lblTipoCambio.setBounds(135,60,80,20);
        txtTipoCambio.setBounds(165,80,80,20);
        lblBanco.setBounds(280,60,80,20);
        cbBanco.setBounds(280,80,200,20);
        lblNCheque.setBounds(510,60,80,20);
        txtNumeroCheque.setBounds(510,80,120,20);
        lblTipoTarjeta.setBounds(15,100,80,20);
        cbTipoTarjeta.setBounds(15,120,70,20);
        lblNTarjeta.setBounds(105,100,80,20);
        txtNumeroTarjeta.setBounds(105,120,155,20);
        lblNValeCompra.setBounds(280,100,90,20);//80 x 20
        txtNumeroValeCompra.setBounds(280,120,100,20);
        lblNNotaCredito.setBounds(510,100,80,20);
        txtNumeroNotaCredito.setBounds(510,120,120,20);
        
        //No editables
        this.cbBanco.setFont(contentFont);
        this.cbMedioPago.setFont(contentFont);
        this.cbMoneda.setFont(contentFont);
        this.cbTipoTarjeta.setFont(contentFont);
        
        //Listeners
        this.cbMedioPago.addItemListener(
          new ItemListener(){
            public void itemStateChanged(ItemEvent ie){
              if(ie.getStateChange() == ie.SELECTED && FrameDatosCobro.this.datosCobro != null){
                FrameDatosCobro.this.datosCobro.changeCbMedioPago();
              }
            }
          }
        );
        
        this.cbMoneda.addItemListener( 
          new ItemListener(){
            public void itemStateChanged(ItemEvent ie){
              System.out.println("====> itemevent");
              
              if(ie.getStateChange() == ie.SELECTED && FrameDatosCobro.this.datosCobro != null){
                FrameDatosCobro.this.datosCobro.changeCbMoneda();
              }
            }
          }
        );
        
        btnAceptar.addActionListener(
          new ActionListener(){
            public void actionPerformed(ActionEvent e){
              FrameDatosCobro.this.datosCobro.Aceptar();
            }
          }
        );
        
        this.addWindowListener(
          new WindowAdapter(){
            public void windowClosing(WindowEvent we){
              FrameDatosCobro.this.datosCobro.cancelar();
            }
          }
        );
        
        txtImporteDivisa.addFocusListener(new FocusAdapter () {
          public void focusLost ( FocusEvent evt ) {
            FrameDatosCobro.this.datosCobro.txtImporteDivisa_lostFocus();
          }
        });
        
        //pack();
  }
  public ComboBoxApplet getCbMedioPago()
  {
    return this.cbMedioPago;
  }
  public ComboBoxApplet getCbMoneda()
  {
    return this.cbMoneda;
  }
  public ComboBoxApplet getCbBanco()
  {
    return this.cbBanco;
  }
  public ComboBoxApplet getCbTipoTarjeta()
  {
    return this.cbTipoTarjeta;
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
    this.txtTipoCambio.setText(value);
  }
  public void setImporteObligatorio(boolean value)
  {
    this.importeObligatorio=value;
  }
 public JTextField getTxtNumeroCheque()
 {
  return this.txtNumeroCheque;
 }
 public JTextField getTxtNumeroTarjeta()
 {
  return this.txtNumeroTarjeta;
 }
 public JTextField getTxtNumeroValeCompra()
 {
  return this.txtNumeroValeCompra;
 }
 public JTextField getTxtNumeroNotaCredito()
 {
  return this.txtNumeroNotaCredito;
 }
 public void setBancoObligatorio(boolean value)
 {
  this.BancoObligatorio=value;
 }
 public void setChequeObligatorio(boolean value) 
 {
  this.chequeObligatorio=value;
 }
 public void setTarjetaObligatorio(boolean value)
 {
  this.tarjetaObligatorio=value;
 }
 public void setValeCompraObligatorio(boolean value)
 {
  this.valeCompraObligatorio=value;
 }
 public void setNotaCreditoObligatorio(boolean value)
 {
  this.notaCreditoObligatorio=value;
 }
 public boolean getImporteObligatorio()
 {
  return this.importeObligatorio;
 }
 public boolean getBancoObligatorio()
 {
  return this.BancoObligatorio;
 }
 public boolean getChequeObligatorio()
 {
  return this.chequeObligatorio;
 }
 public boolean getTarjetaObligatorio()
 {
  return this.tarjetaObligatorio;
 }
 public boolean getValeCompraObligatorio()
 {
  return this.valeCompraObligatorio;
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
  return this.txtTipoCambio;
 }
 public void setOidSolicitudNotaCredito(Long value)
 {
  this.oidSolicitudNotaCredito=value;
 }
 public Long getOidSolicitudNotaCredito()
 {
  return this.oidSolicitudNotaCredito;
 }
}