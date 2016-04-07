package es.indra.sicc.ped.applet.componentes;
import es.indra.mare.common.dto.MareDTO;
import es.indra.sicc.comunapplet.exceptions.AppletException;
import es.indra.sicc.dtos.ped.DTOCabeceraSolicitud;
import es.indra.sicc.dtos.ped.DTOPosicionSolicitud;
import es.indra.sicc.ped.applet.RegistroOnlineApplet;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.math.BigDecimal;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EtchedBorder;

public class FrameSimularCuadreOfertas extends JDialog  {
  
  private int height;
  private int width;
  private int hSpace;
  private int vSpace;
  private int btnheight;
  private int btnwidth; 
  private String sTitle = null;
  private JButton btnAceptar = new JButton();
  private JPanel pnSimular = new JPanel();
  private JPanel pnBotones = new JPanel();  
  //private JPanel pnTotal = new JPanel();  
  private JPanel pnGrillaSimular = new JPanel();
  private JScrollPane spGrillaSimular  = new JScrollPane();  
  public TablaSimular tablaSimular = new TablaSimular();
  
  private JLabel lbprecioTotal = new JLabel();
  private JLabel lbprecioTotalValor = new JLabel();
  
  private RegistroOnlineApplet applet = null;
  
  private DTOCabeceraSolicitud dtoe;
  
/*  public FrameSimularCuadreOfertas() {
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
    //this.pnBotones.setBackground(new Color());
  }
  */
  public FrameSimularCuadreOfertas(String sTitle, RegistroOnlineApplet applet, DTOCabeceraSolicitud dtoe) {
    this.applet = applet;
    this.dtoe = dtoe;
    
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
       
    
  }
  
  protected void jbInit() throws Exception {
        
        this.hSpace=6;
        this.vSpace=6;
        this.btnheight=29;
        this.btnwidth=85;
        
      //Backgournds
        Color color = new Color(242,242,241);//242,242,241
        //this.pnBotones.setBackground( color);
        this.pnSimular.setBackground(color);
        this.getContentPane().setBackground(color);
        this.btnAceptar.setBackground( new Color(5, 123, 162) );        
        
        //listeners
        this.btnAceptar.addActionListener(
          new ActionListener(){
            public void actionPerformed(ActionEvent e){
              aceptar();
            }
          }
        );
        
      //Layouts
        this.getContentPane().setLayout( null );
        this.pnBotones.setLayout( null );
        this.pnSimular.setLayout( null );
        this.pnGrillaSimular.setLayout( null );
        this.lbprecioTotal.setLayout(null);
        this.lbprecioTotalValor.setLayout(null);
        
      //Borders
        this.pnBotones.setBorder(new EtchedBorder());
        this.pnGrillaSimular.setBorder( new EtchedBorder() );
        this.pnSimular.setBorder(new javax.swing.border.TitledBorder(new EtchedBorder(),"Simular cuadre"));
        
      //atributes
        this.btnAceptar.setForeground( new Color (255, 255, 255) );
        this.btnAceptar.setFont( new Font ( "Dialog", 1, 11 ) );
        this.btnAceptar.setText( "Aceptar" );
        this.btnAceptar.setMnemonic( KeyEvent.VK_A );
        
        this.spGrillaSimular.setHorizontalScrollBarPolicy( JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS );
        this.spGrillaSimular.setVerticalScrollBarPolicy( JScrollPane.VERTICAL_SCROLLBAR_ALWAYS );
        this.spGrillaSimular.getViewport().add( this.tablaSimular );

        this.lbprecioTotal.setText("Precio total:");
        this.lbprecioTotal.setFont( new Font ( "Arial", Font.BOLD, 11 ) );
        this.lbprecioTotalValor.setText("0");
        this.lbprecioTotalValor.setFont( new Font ( "Arial", Font.PLAIN, 11 ) );
        
        this.setTitle( this.sTitle );

      //Adds
        this.pnBotones.add( btnAceptar );
        this.getContentPane().add( pnBotones );
        this.pnGrillaSimular.add( this.spGrillaSimular );
        this.pnSimular.add( this.pnGrillaSimular );
        this.pnSimular.add(this.lbprecioTotal);
        this.pnSimular.add(this.lbprecioTotalValor);
        this.getContentPane().add( this.pnSimular );

      //Bounds        
        this.pnSimular.setBounds(this.hSpace, this.vSpace, this.width-2*this.hSpace, this.height-3*this.vSpace-2*this.btnheight);//6, 240, 670, 220
        this.pnGrillaSimular.setBounds(2*this.hSpace, 3*this.vSpace, this.width-6*this.hSpace, this.height-15*this.vSpace-2*this.btnheight );
        this.spGrillaSimular.setBounds(0, 0, this.width-6*this.hSpace, this.height-15*this.vSpace-2*this.btnheight );
        this.lbprecioTotal.setBounds(2*this.hSpace, this.height-10*this.vSpace-2*this.btnheight, 140, 20);
        this.lbprecioTotalValor.setBounds(2*this.hSpace, this.height-8*this.vSpace-2*this.btnheight, 140, 20);
        this.pnBotones.setBounds(this.hSpace, this.height-2*this.vSpace-2*this.btnheight, this.width-2*this.hSpace, this.btnheight);//this.height-this.vSpace-this.btnheight
        this.btnAceptar.setBounds( 0, 0, this.btnwidth, this.btnheight );
        
        
        pack();


  }
  
  private void aceptar() {
    this.setVisible(false);
  }
  
  // Calcula el precio unitario de una posición 
  private BigDecimal calcularPrecioUnitario (DTOPosicionSolicitud posicion, Double tipoCambio) {
    BigDecimal precio = null;
    if(posicion.getPrecioCatalogoUnitarioLocal() != null 
        && !posicion.getPrecioCatalogoUnitarioLocal().equals(new BigDecimal(0))) {
      
      precio = posicion.getPrecioCatalogoUnitarioLocal(); 
    } else { 
      precio = posicion.getPrecioContableUnitarioDocumento();
    } 

    if(tipoCambio != null && tipoCambio.doubleValue() > 0 ) {
      precio = precio.multiply(new BigDecimal(tipoCambio.doubleValue()));
    } 
    
    return precio;
  }
  
  // Muestra la solicitud antes y despues del cuadre 
  public void simular() throws AppletException {
    // Realiza una copia de la solicitud antes de hacer el cuadre 
    ArrayList posiciones = this.dtoe.getPosiciones();
    Long[] unidadesAnteriores = new Long[posiciones.size()];
    for (int i = 0; i < posiciones.size(); ++i) {
      Long aux = ((DTOPosicionSolicitud)posiciones.get(i)).getUnidadesPorAtender();
      if(aux != null) {
        unidadesAnteriores[i] = new Long(aux.longValue());
      }      
    }
    
   // try {
      this.dtoe.setUsuario(this.applet.getUser());
      // Realiza la simulación del cuadre 
      MareDTO mareDTO = this.applet.ejecutarNegocio(
                          "PEDSimularCuadreOfertas" , 
                          "es.indra.sicc.dtos.ped.DTOCabeceraSolicitud",
                          this.dtoe
                          );
      
      // Muestra la solicitud antes y despues del cuadre 
      this.mostrarSolicitud((DTOCabeceraSolicitud)mareDTO, unidadesAnteriores);
    /*} catch (AppletException e) {
      UtilApplet.procesarError(e, this);
    }*/
  }

  // Muestra las posiciones de la solicitud antes de realizar el cuadre 
  // Si la posición ha sido modificada por el cuadre eliminando unidades se mostrará de color rojo 
  // Si se trata de una nueva posición añadida por el cuadre se muestra de color verde  
  private void mostrarSolicitud (DTOCabeceraSolicitud dto, Long[] unidadesAnteriores) {

    BigDecimal precioTotalPosiciones = new BigDecimal(0); 
System.out.println("unidadesAnteriores: " + unidadesAnteriores);
    //RecordSet 
    ArrayList posiciones = dto.getPosiciones();
    if(posiciones != null) {
      Color verde = new Color(102,204,51);
      Color rojo = new Color(221,0,0);
      
      for (int posicion = 0; posicion < posiciones.size(); ++posicion) {
        DTOPosicionSolicitud posicionSolicitud = (DTOPosicionSolicitud)posiciones.get(posicion);

        BigDecimal precioUnitario = this.calcularPrecioUnitario(posicionSolicitud, dto.getTipoCambio());
        BigDecimal precioTotal = null;
        if(precioUnitario != null) {
          precioTotal = precioUnitario.multiply(new BigDecimal(posicionSolicitud.getUnidadesPorAtender().longValue()));
        }
        Long unidadesOld = null;
        if(posicion < unidadesAnteriores.length) {
          unidadesOld = unidadesAnteriores[posicion];
        }
        
        this.tablaSimular.addFila(
          posicionSolicitud.getDescripcionFormaPago(), 
          posicionSolicitud.getCodigoVenta(),
          posicionSolicitud.getCodigoProducto(),
          posicionSolicitud.getDescripcionProducto(),
          (posicionSolicitud.getUnidadesPorAtender() != null ? posicionSolicitud.getUnidadesPorAtender().toString() : ""),
          (precioUnitario != null ? precioUnitario.toString() : ""),
          (precioTotal != null ? precioTotal.toString() : "")
        );


         // Compruebo si se trata de una nueva posición 
         System.out.println("tiene que seteear color");
         System.out.println("posicionSolicitud.getUnidadesDemandadas(): " + posicionSolicitud.getUnidadesDemandadas());
         System.out.println("unidadesOld: " + unidadesOld);
         System.out.println("posicionSolicitud.getUnidadesPorAtender(): " + posicionSolicitud.getUnidadesPorAtender());
        if(posicionSolicitud.getUnidadesDemandadas() == null ||  
          posicionSolicitud.getUnidadesDemandadas().longValue() == 0 ) {
            System.out.println("verde");
            this.tablaSimular.setColorultimaFila(verde);
        } else {
          // Compruebo si se han eliminado unidades de la posición comparandola con la misma posición antes del cuadre 
          
          if( unidadesOld != null && 
            !unidadesOld.equals(posicionSolicitud.getUnidadesPorAtender())) {
              
              System.out.println("rojo");  
              this.tablaSimular.setColorultimaFila(rojo);
          } 
        }

        // Incrementa el precio total 
        precioTotalPosiciones = precioTotalPosiciones.add(precioTotal);
      }      
    } 

    // Muestra el precio total para la solicitud en el Label precioTotal 
    this.lbprecioTotalValor.setText(precioTotalPosiciones.toString());    
  }
  
  public static void main(String []args) {
    FrameSimularCuadreOfertas frame = new FrameSimularCuadreOfertas("dd", null, null);
    frame.setModal(true);
    //frame.tablaSimular.setColorAdmin(true);
    //frame.tablaSimular.setDefaultRenderer(Color.class, new ColorTableCellRenderer());
    
    
    //frame.tablaSimular.color = Color.BLACK;
    frame.tablaSimular.setColorAdmin(true);
    frame.tablaSimular.addFila("1","2","3","4","5","6","7");
    //frame.tablaSimular.setColorultimaFila(Color.BLACK);
    frame.tablaSimular.addFila("1","2","3","4","5","6","7");
    //frame.tablaSimular.setColorultimaFila(Color.BLUE);
    frame.tablaSimular.addFila("1","2","3","4","5","6","7");
    frame.tablaSimular.addFila("1","2","3","4","5","6","7");
    //frame.tablaSimular.refresh();
    //frame.tablaSimular.repaint();
    //frame.repaint();
    //frame.tablaSimular.setColorultimaFila(Color.YELLOW);
    //frame.tablaSimular.addFila("1","2","3","4","5","6","7");
    //frame.tablaSimular.addFila("1","2","3","4","5","6","7");
    frame.tablaSimular.setColorultimaFila(Color.BLUE);
    frame.show();
    frame.dispose();
  }
  
  
}