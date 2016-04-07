/*
 * FrameProductosAlternativos.java
 *
 * Created on 21 de febrero de 2005, 18:08
 */
package es.indra.sicc.ped.applet.componentes;

import es.indra.mare.common.mii.services.jdbcservice.RecordSet;
import es.indra.sicc.ped.applet.RegistroOnlineApplet;
import es.indra.sicc.comunapplet.ConstantesApplet;
import es.indra.sicc.comunapplet.Dialogos;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.KeyEvent;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EtchedBorder;
import javax.swing.JDialog;

import javax.swing.ListSelectionModel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author  pluna
 * Si es necesario modificar el tamaño del panel, modificar los valores de height
 * y width únicamente. el resto se adaptan automáticamente.
 */

public class FrameProductosAlternativos extends JDialog
{
  private String                    sTitle                =null;
  private JPanel                    pnProductos           =new JPanel();
  private JPanel                    pnGrillaProductos     =new JPanel();
  private JPanel                    pnAceptar             =new JPanel();
  private JScrollPane               spGrillaProductos     =new JScrollPane();
  public TablaProductosAlternativos productos             =new TablaProductosAlternativos();
  private JButton                   coAceptar             =new JButton();
  private int                       height;
  private int                       width;
  private int                       hSpace;
  private int                       vSpace;
  private int                       btnheight;
  private int                       btnwidth;
  
  /* BELC300023145 : DBLG500000661 - 03/07/2006
   * cdos gPineda - se debe mostrar el cod y descripcion del producto prinpal
   * en dos label, y no en las columnas de la lista.
   */
  private JPanel                    pnPrincipal            =new JPanel();
  private JLabel                    lblTitCodPrincipal     =new JLabel();
  private JLabel                    lblTitDesPrincipal     =new JLabel();
  private JLabel                    lblCodPrincipal        =new JLabel();
  private JLabel                    lblDesPrincipal        =new JLabel();
  private int                       lblheight;
  private int                       lblwidth;
  
  private String codigoSeleccionado = "";
  private RegistroOnlineApplet applet = null;
  private boolean huboProductosAlternativos = false;
  
   public FrameProductosAlternativos( String sTitle, RegistroOnlineApplet app ) {
        this.applet = app;
        
        this.sTitle = sTitle;
        this.height=495;
        this.width=690;
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
        this.btnheight=29;
        this.btnwidth=75;
        // BELC300023145 : DBLG500000661 - cdos gPineda 03/07/2006
        this.lblheight=23;
        this.lblwidth=this.width-4*this.hSpace;
        
      //Backgournds
        Color color = new Color(242,242,241);//242,242,241
        pnAceptar.setBackground( color);
        pnProductos.setBackground(color);
        getContentPane().setBackground(color);
        coAceptar.setBackground( new Color(5, 123, 162) );        
        // BELC300023145 : DBLG500000661 - cdos gPineda 03/07/2006
        pnPrincipal.setBackground(color);
        
        //listeners
        coAceptar.addActionListener(
          new ActionListener(){
            public void actionPerformed(ActionEvent e){
              aceptar();
            }
          }
        );
        
        
        
      //Layouts
        getContentPane().setLayout( null );
        pnAceptar.setLayout( new FlowLayout() );
        pnProductos.setLayout( null );
        pnGrillaProductos.setLayout( null );
        // BELC300023145 : DBLG500000661 - cdos gPineda 03/07/2006
        pnPrincipal.setLayout(null);
        
      //Borders
        //pnAceptar.setBorder(new javax.swing.border.TitledBorder(new EtchedBorder(),"Aceptar"));
        pnGrillaProductos.setBorder( new EtchedBorder() );
        pnProductos.setBorder(new javax.swing.border.TitledBorder(new EtchedBorder(),"Productos Alternativos"));
        // BELC300023145 : DBLG500000661 - cdos gPineda 03/07/2006
        pnPrincipal.setBorder(new javax.swing.border.TitledBorder(new EtchedBorder(),"Producto Principal"));
        
      //atributes
        // BELC300023145 : DBLG500000661 - cdos gPineda 03/07/2006
        lblTitCodPrincipal.setFont( new Font ( "Arial", Font.BOLD, 11 ) );
        lblTitCodPrincipal.setText( "Código SAP" );

        lblTitDesPrincipal.setFont( new Font ( "Arial", Font.BOLD, 11 ) );
        lblTitDesPrincipal.setText( "Descripción SAP" );
        
        lblCodPrincipal.setFont( new Font ( "Dialog", Font.PLAIN, 11 ) );
        lblDesPrincipal.setFont( new Font ( "Dialog", Font.PLAIN, 11 ) );
        
        
        coAceptar.setForeground( new Color (255, 255, 255) );
        coAceptar.setFont( new Font ( "Dialog", 1, 11 ) );
        coAceptar.setText( "Aceptar" );
        coAceptar.setMnemonic( KeyEvent.VK_A );
        
        spGrillaProductos.setHorizontalScrollBarPolicy( JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS );
        spGrillaProductos.setVerticalScrollBarPolicy( JScrollPane.VERTICAL_SCROLLBAR_ALWAYS );
        spGrillaProductos.getViewport().add( productos );

        setTitle( this.sTitle );

      //Adds
        
        // BELC300023145 : DBLG500000661 - cdos gPineda 03/07/2006
        pnPrincipal.add(lblTitCodPrincipal);
        pnPrincipal.add(lblCodPrincipal);
        pnPrincipal.add(lblTitDesPrincipal);
        pnPrincipal.add(lblDesPrincipal);
        getContentPane().add(pnPrincipal);
        
        pnAceptar.add( coAceptar );
        getContentPane().add( pnAceptar );        
        pnGrillaProductos.add( spGrillaProductos );
        pnProductos.add( pnGrillaProductos );
        getContentPane().add( pnProductos );

      //Bounds
        // BELC300023145 : DBLG500000661 - cdos gPineda 03/07/2006
        int heightPrincipal = 2 * this.vSpace + 5 * this.lblheight;
        pnPrincipal.setBounds(          this.hSpace,                       this.vSpace, this.width-2*this.hSpace,   heightPrincipal);
        lblTitCodPrincipal.setBounds( 2*this.hSpace,  0*this.lblheight + 3*this.vSpace,            this.lblwidth,    this.lblheight);
        lblCodPrincipal.setBounds(    2*this.hSpace,  1*this.lblheight + 3*this.vSpace,            this.lblwidth,    this.lblheight);
        lblTitDesPrincipal.setBounds( 2*this.hSpace,  2*this.lblheight + 3*this.vSpace,            this.lblwidth,    this.lblheight);
        lblDesPrincipal.setBounds(    2*this.hSpace,  3*this.lblheight + 3*this.vSpace,            this.lblwidth,    this.lblheight);
        
        //pnProductos.setBounds(this.hSpace, this.vSpace, this.width-2*this.hSpace, this.height-3*this.vSpace-2*this.btnheight);//6, 240, 670, 220
        pnProductos.setBounds( this.hSpace, this.vSpace + heightPrincipal, this.width-2*this.hSpace, this.height-3*this.vSpace-2*this.btnheight - heightPrincipal );
        //pnGrillaProductos.setBounds(2*this.hSpace, 3*this.vSpace, this.width-6*this.hSpace, this.height-7*this.vSpace-2*this.btnheight );
        pnGrillaProductos.setBounds(2*this.hSpace, 3*this.vSpace, this.width-6*this.hSpace, this.height-7*this.vSpace-2*this.btnheight - heightPrincipal );
        
        spGrillaProductos.setBounds( 0, 0, this.width-6*this.hSpace, this.height-7*this.vSpace-2*this.btnheight - heightPrincipal );
        pnAceptar.setBounds(  this.hSpace, this.height-2*this.vSpace-2*this.btnheight, this.width-2*this.hSpace, this.btnheight);//this.height-this.vSpace-this.btnheight
        coAceptar.setBounds( 0, 0, this.btnwidth, this.btnheight );

        pack();
        
  }
  
  public String getCodVenta() 
  {
    return this.codigoSeleccionado;  
  }
  
  public void cargarTabla(RecordSet rs){
    //carga en la tabla ProductosAlternativos.productos el contenido de la primera columna del RecordSet       
    //Solo debe permitir la selección de un producto 
    
    String
        codVenta = null,        // código de venta del producto alternativo
        codPrincipal = null,    // codigo SAP del producto principal
        desPrincipal = null,    // descripción corta del producto principal
        codAlternativo = null,  // código SAP del producto alternativo
        desAlternativo = null;  // descripción corta del producto alternativo
    Object o = null;

/*
 * cdos gPineda 23/05/2006
 * INC  BELC300023161 (DBLG500000556)
 * Se limpia la tabla antes de cargarla.
 */
    productos.deleteRows();
//    productos.deleteEmptyRows();

    productos.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
    
    if(rs != null && !rs.esVacio()){
      
      // BELC300023145 : DBLG500000661 - cdos gPineda 03/07/2006
      o = rs.getValueAt(0,"COD_PRINCIPAL");
      codPrincipal = (o != null) ? o.toString() : "";
      lblCodPrincipal.setText( codPrincipal );
      o = rs.getValueAt(0,"DES_PRINCIPAL");
      desPrincipal = (o != null) ? o.toString() : "";
      lblDesPrincipal.setText( desPrincipal );
        
      
      for(int i = 0; i < rs.getRowCount(); i++){
        codVenta = (o = rs.getValueAt(i, "CV_ALTERNATIVO")) != null ? o.toString() : "";
        /*
         * DBLG400000395 - dmorello, 23/02/2006
         * Se setearán en las cuatro nuevas columnas de la tabla
         * los valores de código SAP y descripciones del producto principal
         * y de los productos alternativos.
         */
        /* BELC300023145 : DBLG500000661 - cdos gPineda 03/07/2006
        o = rs.getValueAt(i,"COD_PRINCIPAL");
        codPrincipal = (o != null) ? o.toString() : "";
        o = rs.getValueAt(i,"DES_PRINCIPAL");
        desPrincipal = (o != null) ? o.toString() : "";
        */
        o = rs.getValueAt(i,"COD_ALTERNATIVO");
        codAlternativo = (o != null) ? o.toString() : "";
        o = rs.getValueAt(i,"DES_ALTERNATIVO");
        desAlternativo = (o != null) ? o.toString() : "";

        productos.newRow();
        
        productos.colCodVenta.setText(codVenta, i);
        //productos.colCodPrincipal.setText(codPrincipal,i);
        //productos.colDesPrincipal.setText(desPrincipal,i);
        productos.colCodAlternativo.setText(codAlternativo,i);
        productos.colDesAlternativo.setText(desAlternativo,i);
      }
    }
  }
  
  private String aceptar(){
  
    if( productos.getSelectedRow()==-1 ){
      //Debe seleccionar al menos un elemento de la lista
      Dialogos.mensajeAceptar(ConstantesApplet.GEN_UIGEN0004, this);
      return null;
    }else{
      this.setVisible(false);
      this.codigoSeleccionado = productos.colCodVenta.getText(productos.getSelectedRow());
      return productos.colCodVenta.getText(productos.getSelectedRow());
    }
  
  }
  
  public void show() {
    if(this.productos.getRowCount() <= 0) {
      Dialogos.mensajeAceptar(ConstantesApplet.NO_EXISTEN_PRODUCTOS_ALTERNATIVOS, this.applet);
      this.huboProductosAlternativos = false;
    } else {
      super.show();
      this.huboProductosAlternativos = true;
    }
  }
  
  public boolean getHuboProductosAlternativos() {
    return this.huboProductosAlternativos;
  }
}