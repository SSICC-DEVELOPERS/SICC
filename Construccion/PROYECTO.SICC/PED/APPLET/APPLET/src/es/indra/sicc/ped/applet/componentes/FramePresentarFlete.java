/*
 * FramePresentarFlete.java
 *
 * Created on 21 de febrero de 2005, 18:08
 */
package es.indra.sicc.ped.applet.componentes;

import es.indra.mare.common.dto.MareDTO;
import es.indra.mare.common.mii.services.jdbcservice.RecordSet;
import es.indra.sicc.comunapplet.UtilApplet;
import es.indra.sicc.comunapplet.exceptions.AppletException;
import es.indra.sicc.dtos.ped.applet.DTOPresentarFlete;
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

import es.indra.sicc.comunapplet.PaginacionClientePesado;


/**
 *
 * @author  pluna
 * Si es necesario modificar el tamaño del panel, modificar los valores de height
 * y width únicamente. el resto se adaptan automáticamente.
 */

public class FramePresentarFlete extends PaginacionClientePesado
{
  private String                    sTitle                =null;
  private JPanel                    pnProductos           =new JPanel();
  private JPanel                    pnGrillaProductos     =new JPanel();
  private JPanel                    pnAceptar             =new JPanel();
  private JScrollPane               spGrillaProductos     =new JScrollPane();
  public TablaPresentarFlete productos             =new TablaPresentarFlete();
  private JButton                   coAceptar             =new JButton();
  private int                       height;
  private int                       width;
  private int                       hSpace;
  private int                       vSpace;
  private int                       btnheight;
  private int                       btnwidth;
  private  DTOPresentarFlete dtoPresentarFlete;
  private RegistroOnlineApplet applet;
  
   public FramePresentarFlete( String sTitle, RecordSet rs,  DTOPresentarFlete dtoe, RegistroOnlineApplet applet ) {
        this.applet = applet;
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
        
        this.setPagina(rs);
        this.dtoPresentarFlete = dtoe;
        // Inicializa la pila de paginado 
        this.inicializar(dtoe);
        
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
        pnAceptar.setBackground( color);
        pnProductos.setBackground(color);
        getContentPane().setBackground(color);
        coAceptar.setBackground( new Color(5, 123, 162) );        
        
      //Layouts
        getContentPane().setLayout( null );
        pnAceptar.setLayout( new FlowLayout() );
        pnProductos.setLayout( null );
        pnGrillaProductos.setLayout( null );
        
      //Borders
        //pnAceptar.setBorder(new javax.swing.border.TitledBorder(new EtchedBorder(),"Aceptar"));
        pnGrillaProductos.setBorder( new EtchedBorder() );
        pnProductos.setBorder(new javax.swing.border.TitledBorder(new EtchedBorder(),"Presentar Flete"));
        
      //atributes
        coAceptar.setForeground( new Color (255, 255, 255) );
        coAceptar.setFont( new Font ( "Dialog", 1, 11 ) );
        coAceptar.setText( "Aceptar" );
        coAceptar.setMnemonic( KeyEvent.VK_A );
        
        spGrillaProductos.setHorizontalScrollBarPolicy( JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS );
        spGrillaProductos.setVerticalScrollBarPolicy( JScrollPane.VERTICAL_SCROLLBAR_ALWAYS );
        spGrillaProductos.getViewport().add( productos );

        setTitle( this.sTitle );

      //Adds
        pnAceptar.add( coAceptar );
        getContentPane().add( pnAceptar );        
        pnGrillaProductos.add( spGrillaProductos );
        pnProductos.add( pnGrillaProductos );
        getContentPane().add( pnProductos );

      //Bounds
        pnProductos.setBounds(this.hSpace, this.vSpace, this.width-2*this.hSpace, this.height-3*this.vSpace-2*this.btnheight);//6, 240, 670, 220
        pnGrillaProductos.setBounds(2*this.hSpace, 3*this.vSpace, this.width-6*this.hSpace, this.height-7*this.vSpace-2*this.btnheight );
        spGrillaProductos.setBounds(0, 0, this.width-6*this.hSpace, this.height-7*this.vSpace-2*this.btnheight );
        pnAceptar.setBounds(this.hSpace, this.height-2*this.vSpace-2*this.btnheight, this.width-2*this.hSpace, this.btnheight);//this.height-this.vSpace-this.btnheight
        coAceptar.setBounds( 0, 0, this.btnwidth, this.btnheight );
        
        coAceptar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                aceptar();
            }
        });
        
        pack();
        
  }
  
  public void cargarTabla() 
  { //TODO
    //Solo debe permitir la selección de un producto
    if(this.getPagina() != null && !this.getPagina().esVacio()){
        String descripcion = null;
        String montoFijo = null;
        String tasa = null;
        String tipoDespacho = null;
        String fleteMinimo = null;
        String fleteMaximo = null;
        String contraEntrega;
        
          for(int i = 0; i < this.getPagina().getRowCount(); i++){
            Object o = null;
            
            o = this.getPagina().getValueAt(i, "DESCRIPCION");
            descripcion = (o != null)? o.toString() : "";
            
            o = this.getPagina().getValueAt(i, "MONTO_FIJO");
            montoFijo = (o != null)? o.toString() : "";
            
            o = this.getPagina().getValueAt(i, "TASA");
            tasa = (o != null)? o.toString() : "";
            
            o = this.getPagina().getValueAt(i, "FLETE_MINIMO");
            fleteMinimo = (o != null)? o.toString() : "";
            
            o = this.getPagina().getValueAt(i, "FLETE_MAXIMO");
            fleteMaximo = (o != null)? o.toString() : "";
            
            o = this.getPagina().getValueAt(i, "CONTRA_ENTREGA");
            contraEntrega = (o != null)? o.toString() : "";
            
            o = this.getPagina().getValueAt(i, "TIPODESPACHO");
            tipoDespacho = (o != null)? o.toString() : "";
  
            /*
             * dmorello, 08/03/2006: La tabla ya tiene una fila al ser
             * construida; se llamará a newRow() al fin del ciclo si hace falta
             */
            //this.productos.newRow();
            this.productos.colDesc.setText(descripcion, i);
            this.productos.colMontoFijo.setText(montoFijo, i);
            this.productos.colTasa.setText(tasa, i);
            this.productos.colFleteMin.setText(fleteMinimo, i);
            this.productos.colFleteMax.setText(fleteMaximo, i);
            this.productos.colContraEnt.setText(contraEntrega, i);
            this.productos.colTipoDespacho.setText(tipoDespacho, i);
            
            if (i < this.getPagina().getRowCount() - 1) {
                this.productos.newRow();
            }
          }
        }
    
  }
  
  /*
  public String getCodVenta() 
  {//TODO retorna el codigo del elemento seleccionado. 
    return ""l;
  }*/
  
  private void aceptar() {
    this.setVisible(false);
  }
  
  protected Long obtenerPagina(Long oidUltimo) {
    this.dtoPresentarFlete.setIndicadorSituacion(oidUltimo); 
    
    try {
      MareDTO mareDTO = this.applet.ejecutarNegocio(
                            "PEDObtenerFleteRegistro" , 
                            "es.indra.sicc.dtos.ped.applet.DTOPresentarFlete",
                            this.dtoPresentarFlete);
                            
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
}