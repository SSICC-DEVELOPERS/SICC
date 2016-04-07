package es.indra.sicc.bel.applet;

import es.indra.mare.common.dto.MareDTO;
import es.indra.sicc.bel.applet.componentes.CobrosDevolucionesDetalleCabeceraController;
import es.indra.sicc.bel.applet.componentes.CobrosDevolucionesDetalleController;
import es.indra.sicc.bel.applet.componentes.TablaDetalle;
import es.indra.sicc.comunapplet.ConstantesApplet;
import es.indra.sicc.comunapplet.Dialogos;
import es.indra.sicc.comunapplet.exceptions.AppletException;
import es.indra.sicc.dtos.bel.DTODatosCobroDevolucion;
import es.indra.sicc.dtos.bel.DTOMovimientoCaja;
import es.indra.sicc.ped.applet.RegistroCache;

import java.awt.Color;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;


import java.math.BigDecimal;


import java.sql.Date;

import java.util.ArrayList;

import javax.swing.JApplet;
/**
 *
 * @author  Cortaberria
 */
abstract class GestorCobrosDevoluciones extends JApplet  { //javax.swing.JDialog
    //Backgrounds
    private Color Background = new Color(242,242,241);
    private Color ButtonBack = new Color(5, 123, 162);
    private Color Blanco = new Color (255, 255, 255);
    protected Long oidSubAcceso = null;
    
    protected DTODatosCobroDevolucion cargaDatosDetalle;
    protected String ip;
    protected Long oidTipoMovimientoCobrar;
    protected Long oidIdioma;
    protected BigDecimal totalPagado;
    protected Long oidCaja;
    protected Long oidSolicitudCabecera;
    protected Long oidCliente = null;
    protected String usuario;
    protected Long oidPais;
    protected String fechaSistema;
    protected Date fechaSistemaDate;
    protected RegistroCache cache;
    protected String accion;
    protected String belcenter;
    protected Long oidCuentaCorriente = null;
    protected Long oidTipoTransaccion = null;
    protected Long oidEmpresa = null;
    protected String url = null;
    protected String urlLogin = null;
    protected int longCodClie = 0;
    
    protected CobrosDevolucionesDetalleCabeceraController marcoCobrosDevolucionesDetalleCabecera = null;
    protected CobrosDevolucionesDetalleController marcoCobrosDevolucionesDetalle = null;
    
    //protected JButton btnBuscar;
    
    protected javax.swing.JButton btnAnadir;
    protected javax.swing.JButton btnEliminar;
    protected javax.swing.JButton btnGuardar;
    protected javax.swing.JButton btnModificar;
    protected javax.swing.JButton btnBuscarCliente;
    protected javax.swing.JLabel lblCodClienteObligatorio;
    protected TablaDetalle tablaDetalle;
    protected javax.swing.JTextArea txtObservaciones;
    protected javax.swing.JLabel lbAcceso;
    protected javax.swing.JLabel lbCaja;
    protected javax.swing.JLabel lbCanal;
    protected javax.swing.JLabel lbFecha;
    protected javax.swing.JLabel lbSubAcceso;
    protected javax.swing.JLabel lblAcceso;
    protected javax.swing.JLabel lblCaja;
    protected javax.swing.JLabel lblCanal;
    protected javax.swing.JLabel lblCodCliente;
    protected javax.swing.JLabel lblFecha;
    protected javax.swing.JLabel lblObservaciones;
    protected javax.swing.JLabel lblSubAcceso;
    protected javax.swing.JPanel pnBotones;
    protected javax.swing.JPanel pnBotonesCabecera;
    protected javax.swing.JPanel pnDatosCabecera;
    protected javax.swing.JPanel pnDatosDetalle;
    protected javax.swing.JPanel pnGuardar;
    protected javax.swing.JPanel pnTablaDetalle;
    protected javax.swing.JScrollPane spbtnGuardar;
    protected javax.swing.JTextField txtCodCliente;
    //protected Long oidCliente;
    protected ArrayList movimientosCaja;
    protected Long oidMedioPago;
    protected Long oidMoneda;    
    
  
    /** Initializes the applet RegistroOnline1 */
    public void init() {
        /*try {
          this.initComponents();
          this.GestorCobrosDevoluciones_onload(); 
        } catch (AppletException e) {
          e.printStackTrace();
        }*/
    }
    
    protected abstract void btnGuardar_click() throws AppletException;
    protected abstract void validarImporteTotal() throws AppletException;
    protected abstract void grabarCobro() throws AppletException;
    protected abstract void ejecutarJava() throws AppletException;
    protected abstract DTOMovimientoCaja crearDTOMovimientoCaja() throws AppletException;
    public abstract Object ejecutarWeb(String nombreFuncionJS, String url) throws AppletException;
    public abstract MareDTO ejecutarNegocio(String idBusiness, String nombreDTO, MareDTO dto ) throws AppletException;
    protected abstract void GestorCobrosDevoluciones_onload() throws AppletException;
    protected abstract void cargarDatosIniciales() throws AppletException;
    //protected abstract DTOComprobarInicioCobro comprobarEstadoCaja() throws AppletException;
    protected abstract void cargarCache() throws AppletException;
    protected abstract void reiniciar() throws AppletException;
    
    
    public void start(){
        //System.out.println("Entre al start");
        try  {        
           cache = RegistroCache.getInstance();
           //System.out.println("Instancie Cache");
           //GestorCobrosDevoluciones_onload();
           //System.out.println("Fin carga de datos");
           this.initComponents();
           this.GestorCobrosDevoluciones_onload(); 
        } catch (Exception ex)  {
          ex.printStackTrace();
        }         
    }
    


    /** This method is called from within the init() method to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    private void initComponents() throws AppletException{
        pnDatosCabecera = new javax.swing.JPanel();
        lblCanal = new javax.swing.JLabel();
        lbCanal = new javax.swing.JLabel();
        lblAcceso = new javax.swing.JLabel();
        lbAcceso = new javax.swing.JLabel();
        lblSubAcceso = new javax.swing.JLabel();
        lbSubAcceso = new javax.swing.JLabel();
        lblCaja = new javax.swing.JLabel();
        lbCaja = new javax.swing.JLabel();
        lblFecha = new javax.swing.JLabel();
        lbFecha = new javax.swing.JLabel();
        lblCodCliente = new javax.swing.JLabel();
        txtCodCliente = new javax.swing.JTextField();
        lblCodClienteObligatorio = new javax.swing.JLabel();
        btnBuscarCliente = new javax.swing.JButton();
        lblObservaciones = new javax.swing.JLabel();
        txtObservaciones = new javax.swing.JTextArea();
        pnDatosDetalle = new javax.swing.JPanel();
        pnBotones = new javax.swing.JPanel();
        pnBotonesCabecera = new javax.swing.JPanel();
        btnAnadir = new javax.swing.JButton();
        btnModificar = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();
        pnTablaDetalle = new javax.swing.JPanel();
        spbtnGuardar = new javax.swing.JScrollPane();
        tablaDetalle = new TablaDetalle();
        pnGuardar = new javax.swing.JPanel();
        btnGuardar = new javax.swing.JButton();

        getContentPane().setLayout(null);

        //setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        pnDatosCabecera.setLayout(null);

        pnDatosCabecera.setBackground(new java.awt.Color(242, 242, 241));
        pnDatosCabecera.setBorder(new javax.swing.border.TitledBorder(null, "Datos de cabecera", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 1, 12), new java.awt.Color(153, 153, 153)));
        lblCanal.setFont(new java.awt.Font("Arial", 1, 11));
        lblCanal.setText("Canal");
        pnDatosCabecera.add(lblCanal);
        lblCanal.setBounds(10, 75, 200, 15);

        lbCanal.setFont(new java.awt.Font("Arial", 0, 11));
        lbCanal.setText("");
        pnDatosCabecera.add(lbCanal);
        lbCanal.setBounds(10, 85, 200, 15);

        lblAcceso.setFont(new java.awt.Font("Arial", 1, 11));
        lblAcceso.setText("Acceso");
        pnDatosCabecera.add(lblAcceso);
        lblAcceso.setBounds(270, 75, 200, 15);

        lbAcceso.setFont(new java.awt.Font("Arial", 0, 11));
        lbAcceso.setText("");
        pnDatosCabecera.add(lbAcceso);
        lbAcceso.setBounds(270, 85, 200, 20);

        lblSubAcceso.setFont(new java.awt.Font("Arial", 1, 11));
        lblSubAcceso.setText("Subacceso");
        pnDatosCabecera.add(lblSubAcceso);
        lblSubAcceso.setBounds(490, 75, 80, 15);

        lbSubAcceso.setFont(new java.awt.Font("Arial", 0, 11));
        lbSubAcceso.setText("");
        pnDatosCabecera.add(lbSubAcceso);
        lbSubAcceso.setBounds(490, 85, 200, 15);

        lblCaja.setFont(new java.awt.Font("Arial", 1, 11));
        lblCaja.setText("Caja");
        pnDatosCabecera.add(lblCaja);
        //lblCaja.setBounds(10, 80, 23, 14);
        lblCaja.setBounds(10, 105, 200, 15);

        lbCaja.setFont(new java.awt.Font("Arial", 0, 11));
        lbCaja.setText("");
        pnDatosCabecera.add(lbCaja);
        lbCaja.setBounds(10, 115, 200, 15);

        lblFecha.setFont(new java.awt.Font("Arial", 1, 11));
        lblFecha.setText("Fecha");
        pnDatosCabecera.add(lblFecha);
        //lblFecha.setBounds(270, 80, 32, 14);
        lblFecha.setBounds(270, 105, 200, 15);

        lbFecha.setFont(new java.awt.Font("Arial", 0, 11));
        lbFecha.setText("");
        pnDatosCabecera.add(lbFecha);
        lbFecha.setBounds(270, 115, 200, 15);

        lblCodCliente.setFont(new java.awt.Font("Arial", 1, 11));
        lblCodCliente.setText("C\u00f3d. cliente");
        pnDatosCabecera.add(lblCodCliente);
        lblCodCliente.setBounds(10, 30, 200, 20);

        txtCodCliente.setFont(new java.awt.Font("Arial", 0, 11));
        txtCodCliente.setText("");
        pnDatosCabecera.add(txtCodCliente);
        txtCodCliente.setBounds(10, 50, 240, 15);

        lblCodClienteObligatorio.setFont(new java.awt.Font("Arial", 1, 11));
        lblCodClienteObligatorio.setForeground(new java.awt.Color(255, 0, 0));
        lblCodClienteObligatorio.setText("(*)");
        pnDatosCabecera.add(lblCodClienteObligatorio);
        lblCodClienteObligatorio.setBounds(250, 50, 20, 14);

        //btnBuscarCliente.setBackground(new java.awt.Color(242, 242, 241));
        //btnBuscarCliente.setBackground(new java.awt.Color(242, 242, 241));
        //Image  im = getImage(getCodeBase(),"images/iconBuscar.gif");

        //System.out.println(getCodeBase()+"images/iconBuscar.gif");
        //Icon ics= new ImageIcon(im);   
        //btnBuscarCliente.setIcon(ics);
        //btnBuscarCliente.setBorder(null);
        btnBuscarCliente.setBackground(new java.awt.Color(5, 123, 162));
        btnBuscarCliente.setFont(new java.awt.Font("Arial", 0, 11));
        btnBuscarCliente.setForeground(new java.awt.Color(255, 255, 255));
        btnBuscarCliente.setText("Buscar cliente");
        btnBuscarCliente.setMaximumSize(new java.awt.Dimension(110, 20));
        btnBuscarCliente.setMinimumSize(new java.awt.Dimension(110, 20));
        btnBuscarCliente.setPreferredSize(new java.awt.Dimension(73, 20));
        
        
        pnBotonesCabecera.add(btnBuscarCliente);
        
        lblObservaciones.setFont(new java.awt.Font("Arial", 1, 11));
        lblObservaciones.setText("Observaciones");
        pnDatosCabecera.add(lblObservaciones);
        lblObservaciones.setBounds(10, 133, 90, 14);

        txtObservaciones.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        pnDatosCabecera.add(txtObservaciones);
        txtObservaciones.setBounds(10, 150, 690, 50);

        pnDatosCabecera.add(pnBotonesCabecera);
        pnBotonesCabecera.setBounds(10, 200, 690, 20);

        getContentPane().add(pnDatosCabecera);
        pnDatosCabecera.setBounds(0, 0, 710, 230);
        
        pnDatosDetalle.setLayout(null);

        pnDatosDetalle.setBackground(new java.awt.Color(242, 242, 241));
        pnDatosDetalle.setBorder(new javax.swing.border.TitledBorder(null, "Datos de detalle", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 1, 12), new java.awt.Color(153, 153, 153)));
        pnBotones.setLayout(new javax.swing.BoxLayout(pnBotones, javax.swing.BoxLayout.X_AXIS));
        pnBotonesCabecera.setLayout(new javax.swing.BoxLayout(pnBotonesCabecera, javax.swing.BoxLayout.X_AXIS));
        
        btnAnadir.setBackground(new java.awt.Color(5, 123, 162));
        btnAnadir.setFont(new java.awt.Font("Arial", 0, 11));
        btnAnadir.setForeground(new java.awt.Color(255, 255, 255));
        btnAnadir.setText("A\u00f1adir");
        btnAnadir.setMaximumSize(new java.awt.Dimension(73, 20));
        btnAnadir.setMinimumSize(new java.awt.Dimension(73, 20));
        btnAnadir.setPreferredSize(new java.awt.Dimension(73, 20));
        pnBotones.add(btnAnadir);

        btnModificar.setBackground(new java.awt.Color(5, 123, 162));
        btnModificar.setFont(new java.awt.Font("Arial", 0, 11));
        btnModificar.setForeground(new java.awt.Color(255, 255, 255));
        btnModificar.setText("Modificar");
        btnModificar.setMaximumSize(new java.awt.Dimension(78, 20));
        btnModificar.setMinimumSize(new java.awt.Dimension(78, 20));
        btnModificar.setPreferredSize(new java.awt.Dimension(78, 20));
        pnBotones.add(btnModificar);

        btnEliminar.setBackground(new java.awt.Color(5, 123, 162));
        btnEliminar.setFont(new java.awt.Font("Arial", 0, 11));
        btnEliminar.setForeground(new java.awt.Color(255, 255, 255));
        btnEliminar.setText("Eliminar");
        btnEliminar.setMaximumSize(new java.awt.Dimension(71, 20));
        btnEliminar.setMinimumSize(new java.awt.Dimension(71, 20));
        btnEliminar.setPreferredSize(new java.awt.Dimension(71, 20));
        pnBotones.add(btnEliminar);

        pnDatosDetalle.add(pnBotones);
        pnBotones.setBounds(10, 200, 690, 20);

        pnTablaDetalle.setLayout(null);
        spbtnGuardar.setViewportView(tablaDetalle);

        pnTablaDetalle.add(spbtnGuardar);
        spbtnGuardar.setBounds(0, 0, 690, 180);

        pnDatosDetalle.add(pnTablaDetalle);
        pnTablaDetalle.setBounds(10, 20, 690, 180);

        getContentPane().add(pnDatosDetalle);
        pnDatosDetalle.setBounds(0, 230, 710, 230);

        pnGuardar.setLayout(new javax.swing.BoxLayout(pnGuardar, javax.swing.BoxLayout.X_AXIS));

        btnGuardar.setBackground(new java.awt.Color(5, 123, 162));
        btnGuardar.setFont(new java.awt.Font("Arial", 0, 11));
        btnGuardar.setForeground(new java.awt.Color(255, 255, 255));
        btnGuardar.setText("Guardar");
        btnGuardar.setMaximumSize(new java.awt.Dimension(78, 20));
        btnGuardar.setMinimumSize(new java.awt.Dimension(78, 20));
        btnGuardar.setPreferredSize(new java.awt.Dimension(73, 20));
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });

        pnGuardar.add(btnGuardar);

        getContentPane().add(pnGuardar);
        pnGuardar.setBounds(0, 460, 710, 20);
        btnBuscarCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
               btnBuscarClienteActionPerformed(evt);
            }
        });
        btnAnadir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
               btnAnadirActionPerformed(evt);
            }
        });
        btnModificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
               btnModificarActionPerformed(evt);
            }
        });
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
               btnEliminarActionPerformed(evt);
            }
        });
        
        txtCodCliente.addFocusListener(new FocusAdapter () {
          public void focusLost ( FocusEvent evt ) {
            if(longCodClie > 0 && txtCodCliente.getText().trim().length() > 0) {
              String aux = txtCodCliente.getText();
              while(aux.length() < longCodClie) {
                aux = "0" + aux;            
              }
              txtCodCliente.setText(aux);
            }
            marcoCobrosDevolucionesDetalleCabecera.txtCodCliente_lostFocus();
          }
        });

      //  pack();
    }
    
    protected void deshabilitarTodo() {
      this.setEnabled(false); 
    }
  
protected void btnGuardarActionPerformed(java.awt.event.ActionEvent evt)
{
    try
    {
      this.btnGuardar_click();
    }
    catch(AppletException e)
    {
          Dialogos.mensajeError(ConstantesApplet.ERROR_CARGA_INICIAL, this);              
    }
    
} 
protected void btnBuscarClienteActionPerformed(java.awt.event.ActionEvent evt)
{
    this.marcoCobrosDevolucionesDetalleCabecera.btnBuscarCliente_onClick();
}
protected void btnAnadirActionPerformed(java.awt.event.ActionEvent evt)
{
  this.marcoCobrosDevolucionesDetalle.btnAnadir_click();
}
protected void btnModificarActionPerformed(java.awt.event.ActionEvent evt)
{
  this.marcoCobrosDevolucionesDetalle.dbtnModificar_click();
}
protected void btnEliminarActionPerformed(java.awt.event.ActionEvent evt)
{
  this.marcoCobrosDevolucionesDetalle.btnEliminar_click();
}

 public static void main(String[] args) {
    //FrameBuscarProducto frame = new FrameBuscarProducto( "Buscar Producto" );
    GestorCobrosDevolucionesApplet frame = new GestorCobrosDevolucionesApplet();
    frame.start();
    frame.setVisible(true);
  }
}
