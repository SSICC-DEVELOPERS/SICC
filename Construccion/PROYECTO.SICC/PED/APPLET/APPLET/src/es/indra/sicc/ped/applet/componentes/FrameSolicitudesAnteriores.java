/*
 * FrameSolicitudesAnteriores.java
 *
 * Created on 21 de febrero de 2005, 18:08
 */
package es.indra.sicc.ped.applet.componentes;

import es.indra.mare.common.dto.MareDTO;
import es.indra.mare.common.mii.services.jdbcservice.RecordSet;
import es.indra.sicc.comunapplet.Dialogos;
import es.indra.sicc.comunapplet.UtilApplet;
import es.indra.sicc.comunapplet.PaginacionClientePesado;
import es.indra.sicc.dtos.ped.applet.DTOSolicitudesAnteriores;
import es.indra.sicc.ped.applet.RegistroOnlineApplet;

import es.indra.sicc.comunapplet.ConstantesApplet;
import es.indra.sicc.util.DTOSalida;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;
import javax.swing.border.EtchedBorder;

import es.indra.sicc.comunapplet.exceptions.AppletException;

import java.math.BigDecimal;

/**
 *
 * @author  pluna
 * Si es necesario modificar el tamaño del panel, modificar los valores de height
 * y width únicamente. el resto se adaptan automáticamente.
 */

public class FrameSolicitudesAnteriores extends PaginacionClientePesado
{
  private String                    sTitle                =null;
  private JLabel                    lbMensaje             =new JLabel();
  private JPanel                    pnResultados           =new JPanel();
  private JPanel                    pnGrillaResultados     =new JPanel();
  private JPanel                    pnBotones             =new JPanel();
  private JScrollPane               spGrillaResultados     =new JScrollPane();
  public TablaSolicitudes           tablaResultado        =new TablaSolicitudes();
  private JButton                   coSi             =new JButton();
  private JButton                   coNo             =new JButton();
  private JButton                   coContinuar             =new JButton();
  private JButton                   coConsultarSolicitud             =new JButton();
  private JButton                   coModificarSolicitud             =new JButton();  
  private int                       height;
  private int                       width;
  private int                       hSpace;
  private int                       vSpace;
  private int                       btnheight;
  private int                       btnwidth;
  
  private Boolean continuar = null;
  private RegistroOnlineApplet applet = null;
  
  private Long oidCabeceraSolicitud = null;
  
  private DTOSolicitudesAnteriores dtoSolicitudesAnteriores = null;
  
  public FrameSolicitudesAnteriores(RegistroOnlineApplet applet, String sTitle, RecordSet rs, DTOSolicitudesAnteriores dtoe ) {
    this.applet = applet;
    this.setPagina(rs);
    this.sTitle = sTitle;
    this.dtoSolicitudesAnteriores = dtoe;

    
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
    
    this.cargarTabla();
    this.inicializar(this.dtoSolicitudesAnteriores);
  }
  
  
  private void initComponents() throws Exception
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
        pnResultados.setBackground(color);
        getContentPane().setBackground(color);
        coSi.setBackground( new Color(5, 123, 162) );        
        coNo.setBackground( new Color(5, 123, 162) );        
        coConsultarSolicitud.setBackground( new Color(5, 123, 162) );        
        coModificarSolicitud.setBackground( new Color(5, 123, 162) );        
        
        //listeners
        coSi.addActionListener(
          new ActionListener(){
            public void actionPerformed(ActionEvent e){
              si();
            }
          }
        );

        coNo.addActionListener(
          new ActionListener(){
            public void actionPerformed(ActionEvent e){
              no();
            }
          }
        );

        coConsultarSolicitud.addActionListener(
          new ActionListener(){
            public void actionPerformed(ActionEvent e){
              consultarSolicitud();
            }
          }
        );

        coModificarSolicitud.addActionListener(
          new ActionListener(){
            public void actionPerformed(ActionEvent e){
              modificarSolicitud();
            }
          }
        );
        
      //Layouts
        getContentPane().setLayout( null );
        pnBotones.setLayout( new FlowLayout() );
        pnResultados.setLayout( null );
        pnGrillaResultados.setLayout( null );
        
      //Borders
        //pnBotones.setBorder(new javax.swing.border.TitledBorder(new EtchedBorder(),"Aceptar"));
        pnGrillaResultados.setBorder( new EtchedBorder() );
        pnResultados.setBorder(new javax.swing.border.TitledBorder(new EtchedBorder(),"Solicitudes Anteriores"));
        
      //atributes
        lbMensaje.setFont( new Font("Dialog", 2, 18) );
        //lbMensaje.setText("UIPED032");
        
        coSi.setForeground( new Color (255, 255, 255) );
        coSi.setFont( new Font ( "Dialog", 1, 11 ) );
        coSi.setText( "Si" );
        coSi.setMnemonic( KeyEvent.VK_S );
        
        coNo.setForeground( new Color (255, 255, 255) );
        coNo.setFont( new Font ( "Dialog", 1, 11 ) );
        coNo.setText( "No" );
        coNo.setMnemonic( KeyEvent.VK_N );
        
        coConsultarSolicitud.setForeground( new Color (255, 255, 255) );
        coConsultarSolicitud.setFont( new Font ( "Dialog", 1, 11 ) );
        coConsultarSolicitud.setText( "Consultar Solicitud" );
        coConsultarSolicitud.setMnemonic( KeyEvent.VK_C );
        
        coModificarSolicitud.setForeground( new Color (255, 255, 255) );
        coModificarSolicitud.setFont( new Font ( "Dialog", 1, 11 ) );
        coModificarSolicitud.setText( "Modificar Solicitud" );
        coModificarSolicitud.setMnemonic( KeyEvent.VK_M );
        
        spGrillaResultados.setHorizontalScrollBarPolicy( JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS );
        spGrillaResultados.setVerticalScrollBarPolicy( JScrollPane.VERTICAL_SCROLLBAR_ALWAYS );
        spGrillaResultados.getViewport().add( tablaResultado );

        setTitle( this.sTitle );

      //Adds
        pnBotones.add( coSi );
        pnBotones.add( coNo );
        pnBotones.add( coConsultarSolicitud );
        pnBotones.add( coModificarSolicitud );
        
        pnBotones.add( this.btnAdelante );
        pnBotones.add( this.btnAtras );
        pnBotones.add( this.btnInicio );
        super.btnAdelante.setBounds( 0, 0, this.btnwidth, this.btnheight);
        super.btnAtras.setBounds( 0, 0, this.btnwidth, this.btnheight);
        super.btnInicio.setBounds( 0, 0, this.btnwidth, this.btnheight);
        
        getContentPane().add( pnBotones );        
        pnGrillaResultados.add( spGrillaResultados );
        pnResultados.add( pnGrillaResultados );
        getContentPane().add(lbMensaje);
        getContentPane().add( pnResultados );

      //Bounds
        pnResultados.setBounds(this.hSpace, this.vSpace+this.btnheight, this.width-2*this.hSpace, this.height-3*this.vSpace-3*this.btnheight);//6, 240, 670, 220
        pnGrillaResultados.setBounds(2*this.hSpace, 3*this.vSpace, this.width-6*this.hSpace, this.height-7*this.vSpace-3*this.btnheight );
        spGrillaResultados.setBounds(0, 0, this.width-6*this.hSpace, this.height-7*this.vSpace-3*this.btnheight );
        pnBotones.setBounds(this.hSpace, this.height-2*this.vSpace-2*this.btnheight, this.width-2*this.hSpace, this.btnheight);//this.height-this.vSpace-this.btnheight
        coSi.setBounds( 0, 0, this.btnwidth, this.btnheight );
        coNo.setBounds( 0, 0, this.btnwidth, this.btnheight );
        coConsultarSolicitud.setBounds( 0, 0, this.btnwidth, this.btnheight );
        coModificarSolicitud.setBounds( 0, 0, this.btnwidth, this.btnheight );
        lbMensaje.setBounds(this.hSpace, this.vSpace, 2*this.btnwidth, this.btnheight);//20,25,80,15
        
        pack();
        
  }
  
  public void cargarTabla() {
    //Solo debe permitir la selección de una solicitud 
//System.out.println("esta en cargarTabla con rs: " + this.getPagina());    
    Integer numSolic = null;
    String periodo = null;
    String proceso = null;
    String estado = null;
    Long totalPagar = null;
    Object o = null;
    
    if(this.getPagina() != null && !this.getPagina().esVacio()){
      for(int i = 0; i < this.getPagina().getRowCount(); i++){
        try{
          numSolic = (o = this.getPagina().getValueAt(i, "NUMERO_SOLICITUD")) != null ? 
            new Integer(o.toString()) : null;
        }catch(NumberFormatException nfe){}
        
        periodo = (o = this.getPagina().getValueAt(i, "PERIODO")) != null ? o.toString() : "";
        proceso = (o = this.getPagina().getValueAt(i, "PROCESO")) != null ? o.toString() : "";
        estado = (o = this.getPagina().getValueAt(i, "ESTADO")) != null ? o.toString() : "";
        
        try{
          totalPagar = (o = this.getPagina().getValueAt(i, "TOTAL_PAGAR")) != null ? 
            new Long(o.toString()) : null;
        }catch(NumberFormatException nfe){}
        
        tablaResultado.newRow();
        tablaResultado.colNroSoli.setText(numSolic.intValue(), i);
        tablaResultado.colPeriodo.setText(periodo, i);
        tablaResultado.colProcVal.setText(proceso, i);
        tablaResultado.colEstado.setText(estado, i);
        tablaResultado.colTotPagar.setText(totalPagar.longValue(), i);
      }
      tablaResultado.deleteEmptyRows();
      tablaResultado.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
    }
  }
  
  public Boolean getContinuar(){
    //TODO 
    //return Boolean.TRUE;
    return continuar;
  }

  public void setContinuar(Boolean b){
    this.continuar = new Boolean(b.booleanValue());
  }
  
  private void si(){
    this.setContinuar(Boolean.TRUE);
    this.setVisible(false);
  }
  
  private void no(){
    this.setContinuar(Boolean.FALSE);
    this.setVisible(false);
  }
  
  private void consultarSolicitud(){
  
    if( tablaResultado.getSelectedRow()==-1 ){
      //TODO: mostrar mensaje error
      Dialogos.mensajeAceptar(ConstantesApplet.GEN_UIGEN0004, this);
    }else{
      Integer iCod = null;
      String cod = tablaResultado.colNroSoli.getText(tablaResultado.getSelectedRow());
      iCod = cod != null ? new Integer(cod) : null;
      oidCabeceraSolicitud = obtenerOIDCabeceraSolicitud(iCod);
  
      try{
        applet.ejecutarWeb("consultarModificarSolicitud", 
          "'LPConsultarModificarSolicitud', '', 'Consultar', " + oidCabeceraSolicitud);
      }catch(AppletException ae){
        //Dialogos.mensajeError("Error en la busqueda de registros", ae.getMessage(), this);
        UtilApplet.procesarError(ae, this.applet);
      }
    }
  }
  
  private void modificarSolicitud(){
    
    if( tablaResultado.getSelectedRow()==-1 ){
        //TODO: mostrar mensaje error
    }else{
      Integer iCod = null;
      String cod = tablaResultado.colNroSoli.getText(tablaResultado.getSelectedRow());
      iCod = cod != null ? new Integer(cod) : null;
      oidCabeceraSolicitud = obtenerOIDCabeceraSolicitud(iCod);
    
      try{
        applet.ejecutarWeb("consultarModificarSolicitud", 
          "'LPConsultarModificarSolicitud', '', 'Modificar', " + oidCabeceraSolicitud);
      }catch(AppletException ae){
        //Dialogos.mensajeError("Error en la busqueda de registros", ae.getMessage(), this);
        UtilApplet.procesarError(ae, this.applet);
      }
    }
  }
  
  private Long obtenerOIDCabeceraSolicitud(Integer num){
  
    Integer ns = null;
    Object o = null;
    Long ret = null;
  
    if(this.getPagina() != null && !this.getPagina().esVacio() && num != null){
      for(int i = 0; i < this.getPagina().getRowCount(); i++){
        try{
          ns = (o = this.getPagina().getValueAt(i, "NUMERO_SOLICITUD")) != null ? new Integer(o.toString()) : null;
        }catch(NumberFormatException nfe){
          ns = null;
        }
        
        if(ns != null && ns.equals(num)){
          try{
            ret = (o = this.getPagina().getValueAt(i, "OID_SOLICITUD")) != null ? new Long((((BigDecimal)o).toString())) : null;
          }catch(NumberFormatException nfe){
            ret = null;
          }
          return ret;
        }
      }
    }
    return null;
  }
  
  protected Long obtenerPagina(Long oidUltimo) {
    this.dtoSolicitudesAnteriores.setIndicadorSituacion(oidUltimo); 
    
    try {
      MareDTO mareDTO = this.applet.ejecutarNegocio(
                            "PEDObtenerSolicitudesAnteriores" , 
                            "es.indra.sicc.dtos.ped.applet.DTOSolicitudesAnteriores",
                            this.dtoSolicitudesAnteriores);
                            
      if(mareDTO instanceof DTOSalida) {
        DTOSalida dtoSalida = (DTOSalida) mareDTO;
        this.setPagina(dtoSalida.getResultado());
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
  
  /**
   * Autor: Cortaberria
   * Fecha: 23/04/2005
   * Se sobreescribe este metodo debido a que la paginacion se lleva a cabo mediante el
   * numero de linea y no el OID
   */
  protected Long obtenerUltimoRegistroPagina() {
    Long oidUltimo = null;
    
    // Si la página contiene registros, devuelve el oid del último 
    if (this.getPagina() != null && this.getPagina().getRowCount() > 0) { 
      // Recupera el valor de la primera columna para la última fila 
      oidUltimo = new Long(((BigDecimal) this.getPagina().getValueAt(this.getPagina().getRowCount()-1, "LINEA")).longValue());
    } else {
      oidUltimo = super.obtenerUltimoRegistroPagina();       
    } 
    
    return oidUltimo;
  }

  
  public static void main(String []args) 
  {
    FrameSolicitudesAnteriores frame = new FrameSolicitudesAnteriores(null, "alal", new RecordSet(), null);
    frame.show();
  }
}