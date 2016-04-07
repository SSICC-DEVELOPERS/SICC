package es.indra.sicc.ped.applet.componentes;
import es.indra.mare.common.dto.MareDTO;
import es.indra.mare.common.mii.services.jdbcservice.RecordSet;
import es.indra.sicc.comunapplet.Dialogos;
import es.indra.sicc.comunapplet.PaginacionClientePesado;
import es.indra.sicc.comunapplet.UtilApplet;
import es.indra.sicc.comunapplet.exceptions.AppletException;
import es.indra.sicc.dtos.ped.applet.DTOInfoProducto;
import es.indra.sicc.ped.applet.RegistroOnlineApplet;
import es.indra.sicc.util.DTOSalida;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.KeyEvent;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EtchedBorder;
import javax.swing.ListSelectionModel;

import es.indra.sicc.comunapplet.ConstantesApplet;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class FrameCodigosVenta extends PaginacionClientePesado { //JDialog 
  private String codigoSeleccionado = "";
  private String descripcionSeleccionada = "";
  private DTOInfoProducto dtoInfoProducto = null;
  RegistroOnlineApplet applet = null;

  private String                    sTitle                =null;
  private JButton                   btnAceptar            =new JButton();
  private JPanel                    pnProductos           =new JPanel();
  private JPanel                    pnGrillaProductos     =new JPanel();
  private JScrollPane               spGrillaProductos     =new JScrollPane();
  private TablaProductos            tablaProductos        =new TablaProductos();
  private JPanel                    pnBotones             =new JPanel();  
  private int                       height;
  private int                       width;
  private int                       hSpace;
  private int                       vSpace;
  private int                       btnheight;
  private int                       btnwidth;  

  public FrameCodigosVenta(String sTitle, RegistroOnlineApplet applet, RecordSet rs, DTOInfoProducto dto) {
    this.applet = applet;
    
    this.sTitle = sTitle;
    this.height=495;
    this.width=690;
    try {
       jbInit();
    } catch(Exception e) {
      e.printStackTrace();
    }
    setSize( new Dimension( width, height ) );
    setResizable( false );
    getContentPane().setBackground(new Color(242,242,241));
    
    this.setPagina(rs);
    this.dtoInfoProducto = dto;
    this.inicializar(dto);
    this.cargarTabla();
  }

  protected void jbInit() throws Exception
  {
        super.jbInit();
      //Dimensions  
        this.hSpace=6;
        this.vSpace=6;
        this.btnheight=29;
        this.btnwidth=75;
        
      //Backgournds
        Color color = new Color(242,242,241);//242,242,241
        pnBotones.setBackground( color);
        pnProductos.setBackground(color);
        getContentPane().setBackground(color);
        btnAceptar.setBackground( new Color(5, 123, 162) );        
        
        //listeners
        btnAceptar.addActionListener(
          new ActionListener(){
            public void actionPerformed(ActionEvent e){
              aceptar();
            }
          }
        );
        
      //Layouts
        getContentPane().setLayout( null );
        pnBotones.setLayout( new FlowLayout() );
        pnProductos.setLayout( null );
        pnGrillaProductos.setLayout( null );
        
      //Borders
        //pnBotones.setBorder(new javax.swing.border.TitledBorder(new EtchedBorder(),"Aceptar"));
        pnGrillaProductos.setBorder( new EtchedBorder() );
        pnProductos.setBorder(new javax.swing.border.TitledBorder(new EtchedBorder(),"Codigos Venta"));
        
      //atributes
        btnAceptar.setForeground( new Color (255, 255, 255) );
        btnAceptar.setFont( new Font ( "Dialog", 1, 11 ) );
        btnAceptar.setText( "Aceptar" );
        btnAceptar.setMnemonic( KeyEvent.VK_A );
        
        spGrillaProductos.setHorizontalScrollBarPolicy( JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS );
        spGrillaProductos.setVerticalScrollBarPolicy( JScrollPane.VERTICAL_SCROLLBAR_ALWAYS );
        spGrillaProductos.getViewport().add( tablaProductos );

        setTitle( this.sTitle );

      //Adds
        pnBotones.add( btnAceptar );
        pnBotones.add( this.btnAdelante );
        pnBotones.add( this.btnAtras );
        pnBotones.add( this.btnInicio );
        getContentPane().add( pnBotones );        
        pnGrillaProductos.add( spGrillaProductos );
        pnProductos.add( pnGrillaProductos );
        getContentPane().add( pnProductos );

      //Bounds
        pnProductos.setBounds(this.hSpace, this.vSpace, this.width-2*this.hSpace, this.height-3*this.vSpace-2*this.btnheight);//6, 240, 670, 220
        pnGrillaProductos.setBounds(2*this.hSpace, 3*this.vSpace, this.width-6*this.hSpace, this.height-7*this.vSpace-2*this.btnheight );
        spGrillaProductos.setBounds(0, 0, this.width-6*this.hSpace, this.height-7*this.vSpace-2*this.btnheight );
        pnBotones.setBounds(this.hSpace, this.height-2*this.vSpace-2*this.btnheight, this.width-2*this.hSpace, this.btnheight);//this.height-this.vSpace-this.btnheight
        btnAceptar.setBounds( 0, 0, this.btnwidth, this.btnheight );
        super.btnAdelante.setBounds( this.btnwidth * 2, 0, this.btnwidth, this.btnheight );
        super.btnAtras.setBounds( this.btnwidth * 3, 0, this.btnwidth, this.btnheight );
        super.btnInicio.setBounds( this.btnwidth * 4, 0, this.btnwidth, this.btnheight );
        pack();

/*    this.getContentPane().setLayout(null);
    
    btnAceptar.setText("Aceptar");
    btnAceptar.setAutoscrolls(true);
    btnAceptar.setContentAreaFilled(false);
    btnAceptar.setBounds(new Rectangle(25, 210, 105, 25));
    
    this.getContentPane().add(btnAceptar, null);
    */
  }
  
  public void cargarTabla() 
  { //Solo debe permitir la selección de un producto
    
    String valCodiVent = null;
    String valTextBrev = null;
    /*
    Long oidTipoOfer = null;
    Long oidCicloVida = null;
    */
    String tipoOfer = null;
    String cicloVida = null;
    Object o = null;
    
    tablaProductos.deleteRows();
    tablaProductos.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
    
    if(this.getPagina() != null && !this.getPagina().esVacio()){
      for(int i = 0; i < this.getPagina().getRowCount(); i++){
        valCodiVent =  (o = this.getPagina().getValueAt(i, "VAL_CODI_VENT")) != null ? o.toString() : null;
        valTextBrev = (o = this.getPagina().getValueAt(i, "VAL_TEXT_BREV")) != null ? o.toString() : null;

        tipoOfer = (o = this.getPagina().getValueAt(i, 2)) != null ? o.toString() : null;
        cicloVida = (o = this.getPagina().getValueAt(i, 3)) != null ? o.toString() : null;
        
        tablaProductos.newRow();
        tablaProductos.colCodVenta.setText(valCodiVent, i);
        tablaProductos.colDescripcion.setText(valTextBrev, i);
        
        //yyy TODO: mostrar codigo de estos dos campos
        /*tablaProductos.colTipoOferta.setText(oidTipoOfer != null ? 
          oidTipoOfer.longValue() : 0, i);
          */
        tablaProductos.colTipoOferta.setText(tipoOfer != null ? 
          tipoOfer : "", i);
      
        /*tablaProductos.colCicloVida.setText(oidCicloVida != null ? 
          oidCicloVida.longValue() : 0, i);*/
          tablaProductos.colCicloVida.setText(cicloVida != null ? 
          cicloVida : "", i);
      }
      tablaProductos.deleteEmptyRows();
    }
  }
  
  //retorna el codigo del elemento seleccionado. 
  public String getCodVenta() 
  {
    return this.codigoSeleccionado;
  }
  
  //retorna la desc. del elemento seleccionado. 
  public String getDescripcion() 
  {
    return this.descripcionSeleccionada;
  }
  
  private String aceptar(){
    //JOptionPane.showMessageDialog(null, "mensaje");
  
    if(tablaProductos.getSelectedRow()==-1){
      //Debe seleccionar al menos un elemento de la lista
      Dialogos.mensajeAceptar(ConstantesApplet.GEN_UIGEN0004, this);
      return null;
    }else{
      this.codigoSeleccionado = tablaProductos.colCodVenta.getText(tablaProductos.getSelectedRow());
      this.descripcionSeleccionada = tablaProductos.colDescripcion.getText(tablaProductos.getSelectedRow());
      this.setVisible(false);
      return tablaProductos.colCodVenta.getText(tablaProductos.getSelectedRow());
    }
  }
  
  protected Long obtenerPagina(Long oidUltimo) {
    this.dtoInfoProducto.setIndicadorSituacion(oidUltimo); 
    
    try {
      this.dtoInfoProducto.setListaProductos(null);
      MareDTO mareDTO = this.applet.ejecutarNegocio(
                            "PEDObtenerCodigosVenta" , 
                            "es.indra.sicc.dtos.ped.applet.DTOInfoProducto",
                            this.dtoInfoProducto);
                            
      if(mareDTO instanceof DTOSalida) {
        DTOSalida dtoSalida = (DTOSalida) mareDTO;
        this.setPagina(dtoSalida.getResultado());
        this.dtoInfoProducto.setListaProductos(dtoSalida.getResultado());
        this.cargarTabla();
      }
    } catch (AppletException e) {
      UtilApplet.procesarError(e, this);
    }
    // Obtiene el oid del último registro 
    oidUltimo = obtenerUltimoRegistroPagina();

    return oidUltimo;
  }
  
  protected Long obtenerPagina() {
    return this.obtenerPagina(obtenerUltimoRegistroPagina());
  }
  
/*  public static void main(String []args) {
    FrameCodigosVenta frame = new FrameCodigosVenta("");
    RecordSet rs = new RecordSet();
    rs.addColumn("VAL_CODI_VENT");
    rs.addColumn("VAL_TEXT_BREV");
    rs.addColumn("col1");
    rs.addColumn("col2");
    Vector carga = new Vector();
    carga.add("1");
    carga.add("2");
    carga.add("3");
    carga.add("4");
    rs.addRow(carga);
    rs.addRow(carga);
    rs.addRow(carga);
    rs.addRow(carga);
    rs.addRow(carga);
    rs.addRow(carga);
    rs.addRow(carga);
    rs.addRow(carga);
    rs.addRow(carga);
    rs.addRow(carga);
    rs.addRow(carga);
    rs.addRow(carga);
    rs.addRow(carga);
    rs.addRow(carga);
    rs.addRow(carga);
    rs.addRow(carga);
    rs.addRow(carga);
    rs.addRow(carga);
    rs.addRow(carga);
    frame.show();
    
  }*/
  
}
