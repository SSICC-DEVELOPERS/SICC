/*
 * RegistroOnline1.java
 *
 * Created on 9 de diciembre de 2004, 12:49 PM
 */

package es.indra.sicc.cmn.applet;
import es.indra.sicc.dtos.prueba.DTOBuscarDatosCliente;
import es.indra.sicc.dtos.prueba.DTOCargaRegistroOnline;
import es.indra.sicc.dtos.prueba.DTODatosCliente;
import es.indra.sicc.dtos.prueba.DTOObtenerCargaInicial;
import es.indra.sicc.logicanegocio.prueba.MONRegistroOnline;
import es.indra.sicc.logicanegocio.prueba.MONRegistroOnlineHome;
import es.indra.sicc.util.prueba.Base64;

import es.indra.sicc.cmn.applet.util.Communicator;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.ObjectOutputStream;
import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.URLConnection;
import java.net.URLEncoder;
import java.util.Hashtable;

import javax.naming.Context;
import javax.naming.InitialContext;

import javax.rmi.PortableRemoteObject;

import netscape.javascript.*;

/**
 *
 * @author  jpbosnja
 */
public class RegistroOnline extends javax.swing.JApplet {
    Long oidPais;
    String fechaSistema;
    String ormi;
    String user;
    String clave;
    RegistroCache cache;
    Long oidCliente;
    Long oidTipoCliente;
    Long oidTipoSolicitud;

    int bg_red = 245;      // initialize background colors
    int bg_green = 12;
    int bg_blue = 123;
    
    
    /** Initializes the applet RegistroOnline1 */
    public void init() {
        initComponents();
        System.out.println("Entro al init");
        try {
            if (this.getParameter("oidPais")!=null && !this.getParameter("oidPais").equals("")){
                oidPais = new Long(this.getParameter("oidPais"));
                System.out.println("Pais: "+oidPais);
                //Mostrar error
            }
            if (this.getParameter("fechaSistema ")!=null){
                fechaSistema = this.getParameter("fechaSistema ");
                System.out.println("Fecha Sistema: "+fechaSistema);
                //Mostrar error
            }
            if (this.getParameter("ormi")!=null){
                ormi = this.getParameter("ormi");
                System.out.println("Ormi: "+ormi);
                //Mostrar error
            }
            if (this.getParameter("user")!=null){
                user = this.getParameter("user");
                System.out.println("User: "+user);
                //Mostrar error
            }
            if (this.getParameter("clave")!=null){
                clave = this.getParameter("clave");
                System.out.println("Clave: "+clave);
                //Mostrar error
            }
            if (this.getParameter("oidCliente")!=null && !this.getParameter("oidCliente").equals("")){
                oidCliente = new Long(this.getParameter("oidCliente"));
                System.out.println("Cliente: "+oidCliente);
                //Mostrar error
            }
            if (this.getParameter("oidTipoCliente")!=null && !this.getParameter("oidTipoCliente").equals("")){
                oidTipoCliente = new Long(this.getParameter("oidTipoCliente"));
                System.out.println("Tipo Cliente: "+oidTipoCliente);
                //Mostrar error
            }
            if (this.getParameter("oidTipoSolicitud")!=null && !this.getParameter("oidTipoSolicitud").equals("")){
                oidTipoSolicitud = new Long(this.getParameter("oidTipoSolicitud"));
                System.out.println("Tipo Solicitud: "+oidTipoSolicitud);
                //Mostrar error
            }
            
        } catch(Exception e) {
            e.printStackTrace();
        }
    }

    public void start(){
        System.out.println("Entre al start");
        try  {
           cache = RegistroCache.getInstance();
           System.out.println("Instancie Cache");
           cargarDatosIniciales();
           System.out.println("Fin carga de datos");
        } catch (Exception ex)  {
          ex.printStackTrace();
        } 
    }
    
    /**
     *Si cache.cargado =TRUE entonces 
        // Se llenan los combos de la pantalla 
        2.1 Se llama al metodo cargarCombos. 
        //Se señeccionar los valores indicados en los valores por defecto 
        2.2 Se llama al método aplicarValoresPorDefecto 
        Sino 
        3.1.- Se llama al metodo lookupServidor y se obtiene una referencia al MONRegistroOnline 

        //Se obtienen del servidor todos los datos para los combos de la pantalla. 
        3.2.- Llama al metodo MONRegistroCliente.obtenerCargaInicial pasandole el oidPais y el user. 

        //Se cargan todos los datos de carga inicial del registro y se mantienen en una clase que implemente un patros singleton para agilizar la carga posterior de la pantalla. 
        3.3.- Se obtiene un DTOCargaRegistroOnline 
        .- Se asigna al cache según correspondan. 
        .- Se asigna el valor TRUE al atributo cache.cargado 

        // Se llenan los combos de la pantalla 
        3.4 Se llama al metodo cargarCombos. 

        //Se señeccionar los valores indicados en los valores por defecto 
        3.4 Se llama al método aplicarValoresPorDefecto 

        Fin SI 
    **/
    private void cargarDatosIniciales() throws Exception{
        if (cache.getCargado().booleanValue() == false){
            /*
            MONRegistroOnline mon = lookupServidor();
            DTOCargaRegistroOnline dtoR = mon.obtenerCargaInicial(oidPais, user);
            */
            DTOObtenerCargaInicial dtoCargaInicial = new DTOObtenerCargaInicial();
            dtoCargaInicial.setOidPais(this.oidPais);
            dtoCargaInicial.setUser(this.user);
            Object obj = this.getDatosFromServlet("obtenerCargaInicial", 
                  "es.indra.sicc.dtos.prueba.DTOObtenerCargaInicial", 
                  dtoCargaInicial);
            
            if (obj instanceof DTOCargaRegistroOnline) {
              DTOCargaRegistroOnline dtoR = (DTOCargaRegistroOnline) obj;
              cache.setAccesosFisicos(dtoR.getAccesosFisico());
              cache.setFormaPago(dtoR.getFormasPago());
              cache.setOidSubAcceso(dtoR.getOidSubAcceso());
              cache.setPeriodos(dtoR.getPeriodos());
              cache.setTiposDespacho(dtoR.getTiposDespacho());
              cache.setTiposSolicitud(dtoR.getTiposSolicitud());
              cache.setTxtSubAcceso(dtoR.getTxtsubAcceso());
              cache.setCargado(Boolean.TRUE);            
            }
        }
        cargarCombos();
        aplicarValoresPorDefecto();
    }
    
    private void cargarCombos() throws Exception{
        System.out.println("Voy a cargar Los Accesos Fisicos");
        if (cache!=null && cache.getAccesosFisicos()!=null){
            for (int i = 0; i<cache.getAccesosFisicos().length; i++){
                System.out.println("Cargando "+cache.getAccesosFisicos()[i].getDesc());
                cbAccesoFisico.addItem(cache.getAccesosFisicos()[i].getDesc());
            }
        }
        if (cache!=null && cache.getPeriodos()!=null){
            
            for (int i = 0; i<cache.getPeriodos().length; i++){
                System.out.println("Cargando "+cache.getPeriodos()[i].getDesc());
                cbPeriodo.addItem(cache.getPeriodos()[i].getDesc());
            }
        }
        System.out.println("Voy a cargar Las Formas de Pago");
        if (cache!=null && cache.getFormaPago()!=null){
            System.out.println("Voy a cargar "+cache.getFormaPago().length+" Formas de Pago");
            for (int i = 0; i<cache.getFormaPago().length; i++){
                System.out.println("Cargando "+cache.getFormaPago()[i].getDesc());
                cbFormaPago.addItem(cache.getFormaPago()[i].getDesc());
            }
        }
        System.out.println("Voy a cargar Los Tipo Despacho");
        if (cache!=null && cache.getTiposDespacho()!=null){
            for (int i = 0; i<cache.getTiposDespacho().length; i++){
                System.out.println("Cargando "+cache.getTiposDespacho()[i].getDesc());
                cbTipoDespacho.addItem(cache.getTiposDespacho()[i].getDesc());
            }
        }
        System.out.println("Voy a cargar Los Tipos Solicitud");
        if (cache!=null && cache.getTiposSolicitud()!=null){
            for (int i = 0; i<cache.getTiposSolicitud().length; i++){
                System.out.println("Cargando "+cache.getTiposSolicitud()[i].getTipoSolicitud());
                cbTipoSolicitud.addItem(cache.getTiposSolicitud()[i].getTipoSolicitud());
            }
        }    
    }

    private void aplicarValoresPorDefecto() throws Exception{

    }

    private MONRegistroOnline lookupServidor() throws Exception{
        /*Hashtable env = new Hashtable();
        env.put(Context.INITIAL_CONTEXT_FACTORY, "com.evermind.server.rmi.RMIInitialContextFactory");
        env.put(Context.SECURITY_PRINCIPAL, user);
        env.put(Context.SECURITY_CREDENTIALS, clave);
        env.put(Context.PROVIDER_URL, ormi);*/
        Hashtable env = new Hashtable();
        // Standalone OC4J connection details
        env.put(Context.INITIAL_CONTEXT_FACTORY, "com.evermind.server.rmi.RMIInitialContextFactory");
        env.put(Context.SECURITY_PRINCIPAL, "admin");
        env.put(Context.SECURITY_CREDENTIALS, "belcorp");
        env.put(Context.PROVIDER_URL, "ormi://CDOS0035/mare");

        Context context = new InitialContext(env);
        System.out.println("Obtuve el Contexto");
        MONRegistroOnlineHome mONRegistroOnlineHome = (MONRegistroOnlineHome)PortableRemoteObject.narrow(context.lookup("MONRegistroOnline"), MONRegistroOnlineHome.class);
        MONRegistroOnline mONRegistroOnline;
        System.out.println("Obteve la Interfaz");

        // Use one of the create() methods below to create a new instance
        mONRegistroOnline = mONRegistroOnlineHome.create();
        System.out.println("LLame al create");
      return mONRegistroOnline;
    }
    
    /** This method is called from within the init() method to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    private void initComponents() {//GEN-BEGIN:initComponents
        jTabbedPane = new javax.swing.JTabbedPane();
        Pestaña1 = new javax.swing.JPanel();
        DatosSolicitud = new javax.swing.JPanel();
        lbPeriodo = new javax.swing.JLabel();
        cbPeriodo = new javax.swing.JComboBox();
        lbAccesoFisico = new javax.swing.JLabel();
        cbAccesoFisico = new javax.swing.JComboBox();
        lbTipoDespacho = new javax.swing.JLabel();
        cbTipoDespacho = new javax.swing.JComboBox();
        lbFechaProgramadaFac = new javax.swing.JLabel();
        txtFechaProgramadaFac = new javax.swing.JTextField();
        lbIndCodigoVentaProducto = new javax.swing.JLabel();
        chkIndCodigoVentaProducto = new javax.swing.JCheckBox();
        lbFormaPago = new javax.swing.JLabel();
        cbFormaPago = new javax.swing.JComboBox();
        lbObservaciones = new javax.swing.JLabel();
        jScrollPaneObservaciones = new javax.swing.JScrollPane();
        atxObservaciones = new javax.swing.JTextArea();
        TipoSolicitud = new javax.swing.JPanel();
        lblTipoSolicitud = new javax.swing.JLabel();
        cbTipoSolicitud = new javax.swing.JComboBox();
        lbMarca = new javax.swing.JLabel();
        lbMarca1 = new javax.swing.JLabel();
        lbCanal = new javax.swing.JLabel();
        lbCanal1 = new javax.swing.JLabel();
        lbAcceso = new javax.swing.JLabel();
        lbAcceso1 = new javax.swing.JLabel();
        lbSubacceso = new javax.swing.JLabel();
        lbSubacceso1 = new javax.swing.JLabel();
        lbMonedaDoc = new javax.swing.JLabel();
        lbMonedaDoc1 = new javax.swing.JLabel();
        Cliente = new javax.swing.JPanel();
        lbTituloNombre = new javax.swing.JLabel();
        lbTituloCodCliente = new javax.swing.JLabel();
        txtCodCliente = new javax.swing.JTextField();
        btnBuscarCliente = new javax.swing.JButton();
        lbNombre = new javax.swing.JLabel();
        lbTituloApellidos = new javax.swing.JLabel();
        lbApellidos = new javax.swing.JLabel();
        lbTituloLineaCredito = new javax.swing.JLabel();
        lbLineaCredito = new javax.swing.JLabel();
        lbTituloLineaDisp = new javax.swing.JLabel();
        lbLineaDisp = new javax.swing.JLabel();
        lbTituloDeudaVencida = new javax.swing.JLabel();
        lbDeudaVencida = new javax.swing.JLabel();
        lbTituloTipoDocumento = new javax.swing.JLabel();
        cbTipoDocumento = new javax.swing.JComboBox();
        lbTituloDocumentoLegal = new javax.swing.JLabel();
        lbDocumentoLegal = new javax.swing.JLabel();
        lbTituloDestino = new javax.swing.JLabel();
        cbDestino = new javax.swing.JComboBox();
        lbTituloConsultoraRefencia = new javax.swing.JLabel();
        txtConsultoraRefencia = new javax.swing.JTextField();
        btnBuscarConRefencia = new javax.swing.JButton();
        lbTituloReceptorFactura = new javax.swing.JLabel();
        txtReceptorFactura = new javax.swing.JTextField();
        btnBuscarReceptorFac = new javax.swing.JButton();
        lbTituloPagadorFactura = new javax.swing.JLabel();
        txtPagadorFactura = new javax.swing.JTextField();
        btnBuscarPagador = new javax.swing.JButton();
        Pestaña2 = new javax.swing.JPanel();
        DatosCabecera = new javax.swing.JPanel();
        lbTituloLineaDispDetalle = new javax.swing.JLabel();
        lbLineaDispDetalle = new javax.swing.JLabel();
        lbTituloCodClienteDetalle = new javax.swing.JLabel();
        lbTituloNombreDetalle = new javax.swing.JLabel();
        lbNombreDetalle = new javax.swing.JLabel();
        lbTituloApellidosDetalle = new javax.swing.JLabel();
        lbApellidosDetalle = new javax.swing.JLabel();
        lbCodClienteDetalle = new javax.swing.JLabel();
        lbTituloFormaPagoDetalle = new javax.swing.JLabel();
        lbFormaPagoDetalle = new javax.swing.JLabel();
        DatosDetalle = new javax.swing.JPanel();
        lbCodVenta = new javax.swing.JLabel();
        lbStockDisponible1 = new javax.swing.JLabel();
        lbCodProducto = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        lbDesc = new javax.swing.JLabel();
        lbDesc1 = new javax.swing.JLabel();
        lbUnidDemandadas = new javax.swing.JLabel();
        lbLimiteVenta1 = new javax.swing.JLabel();
        lbStockDisponible = new javax.swing.JLabel();
        txtCodVenta = new javax.swing.JTextField();
        txtCodProductp = new javax.swing.JTextField();
        txtUnidDemandadas = new javax.swing.JTextField();
        lbControlLiq = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        lbDemandaNoAtendida = new javax.swing.JLabel();
        lbObservaciones1 = new javax.swing.JLabel();
        lbControlLiq1 = new javax.swing.JLabel();
        lbReserva1 = new javax.swing.JLabel();
        chkDemandaNoAtendida = new javax.swing.JCheckBox();
        btnAniadir = new javax.swing.JButton();
        jScrollPaneObservaciones1 = new javax.swing.JScrollPane();
        atxObservaciones1 = new javax.swing.JTextArea();
        TablaDetalle = new javax.swing.JPanel();
        jTable1 = new javax.swing.JTable();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();

        Pestaña1.setLayout(null);

        DatosSolicitud.setLayout(null);

        DatosSolicitud.setBorder(new javax.swing.border.TitledBorder("DatosSolicitud"));
        lbPeriodo.setText("Periodo");
        DatosSolicitud.add(lbPeriodo);
        lbPeriodo.setBounds(30, 30, 36, 15);

        DatosSolicitud.add(cbPeriodo);
        cbPeriodo.setBounds(140, 30, 100, 21);

        lbAccesoFisico.setText("Acceso f\u00edsico");
        DatosSolicitud.add(lbAccesoFisico);
        lbAccesoFisico.setBounds(310, 30, 100, 15);

        DatosSolicitud.add(cbAccesoFisico);
        cbAccesoFisico.setBounds(420, 30, 100, 21);

        lbTipoDespacho.setText("Tipo despacho");
        DatosSolicitud.add(lbTipoDespacho);
        lbTipoDespacho.setBounds(550, 30, 120, 15);

        DatosSolicitud.add(cbTipoDespacho);
        cbTipoDespacho.setBounds(680, 30, 100, 21);

        lbFechaProgramadaFac.setText("Fecha prog. fac.");
        DatosSolicitud.add(lbFechaProgramadaFac);
        lbFechaProgramadaFac.setBounds(550, 60, 120, 15);

        DatosSolicitud.add(txtFechaProgramadaFac);
        txtFechaProgramadaFac.setBounds(680, 60, 100, 21);

        lbIndCodigoVentaProducto.setText("Ind. Cod. Venta");
        DatosSolicitud.add(lbIndCodigoVentaProducto);
        lbIndCodigoVentaProducto.setBounds(310, 60, 100, 15);

        DatosSolicitud.add(chkIndCodigoVentaProducto);
        chkIndCodigoVentaProducto.setBounds(420, 60, 21, 21);

        lbFormaPago.setText("Forma pago");
        DatosSolicitud.add(lbFormaPago);
        lbFormaPago.setBounds(30, 60, 100, 15);

        DatosSolicitud.add(cbFormaPago);
        cbFormaPago.setBounds(140, 60, 160, 20);

        lbObservaciones.setText("Observaciones");
        DatosSolicitud.add(lbObservaciones);
        lbObservaciones.setBounds(30, 90, 100, 15);

        jScrollPaneObservaciones.setViewportView(atxObservaciones);

        DatosSolicitud.add(jScrollPaneObservaciones);
        jScrollPaneObservaciones.setBounds(140, 90, 380, 50);

        Pestaña1.add(DatosSolicitud);
        DatosSolicitud.setBounds(0, 90, 800, 150);

        TipoSolicitud.setLayout(null);

        TipoSolicitud.setBorder(new javax.swing.border.TitledBorder("Tipo Solicitud"));
        lblTipoSolicitud.setText("Tipo Solicitud");
        TipoSolicitud.add(lblTipoSolicitud);
        lblTipoSolicitud.setBounds(30, 30, 100, 15);

        cbTipoSolicitud.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbTipoSolicitudActionPerformed(evt);
            }
        });

        TipoSolicitud.add(cbTipoSolicitud);
        cbTipoSolicitud.setBounds(140, 30, 100, 21);

        lbMarca.setText("Marca");
        TipoSolicitud.add(lbMarca);
        lbMarca.setBounds(310, 30, 100, 15);

        lbMarca1.setText("");
        TipoSolicitud.add(lbMarca1);
        lbMarca1.setBounds(420, 30, 60, 15);

        lbCanal.setText("Canal");
        TipoSolicitud.add(lbCanal);
        lbCanal.setBounds(540, 30, 120, 15);

        lbCanal1.setText("");
        TipoSolicitud.add(lbCanal1);
        lbCanal1.setBounds(680, 30, 100, 15);

        lbAcceso.setText("Acceso");
        TipoSolicitud.add(lbAcceso);
        lbAcceso.setBounds(30, 60, 100, 15);

        lbAcceso1.setText("");
        TipoSolicitud.add(lbAcceso1);
        lbAcceso1.setBounds(140, 60, 100, 15);

        lbSubacceso.setText("Subacceso");
        TipoSolicitud.add(lbSubacceso);
        lbSubacceso.setBounds(310, 60, 100, 15);

        lbSubacceso1.setText("");
        TipoSolicitud.add(lbSubacceso1);
        lbSubacceso1.setBounds(420, 60, 60, 15);

        lbMonedaDoc.setText("Moneda");
        TipoSolicitud.add(lbMonedaDoc);
        lbMonedaDoc.setBounds(540, 60, 130, 15);

        lbMonedaDoc1.setText("");
        TipoSolicitud.add(lbMonedaDoc1);
        lbMonedaDoc1.setBounds(680, 60, 100, 15);

        Pestaña1.add(TipoSolicitud);
        TipoSolicitud.setBounds(0, 0, 800, 90);

        Cliente.setLayout(null);

        Cliente.setBorder(new javax.swing.border.TitledBorder("Cliente"));
        lbTituloNombre.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lbTituloNombre.setText("Nombre");
        Cliente.add(lbTituloNombre);
        lbTituloNombre.setBounds(30, 60, 100, 15);

        lbTituloCodCliente.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        lbTituloCodCliente.setText("Cod. cliente");
        Cliente.add(lbTituloCodCliente);
        lbTituloCodCliente.setBounds(30, 30, 100, 15);

        Cliente.add(txtCodCliente);
        txtCodCliente.setBounds(140, 30, 100, 20);

        btnBuscarCliente.setText("Buscar");
        Cliente.add(btnBuscarCliente);
        btnBuscarCliente.setBounds(310, 30, 110, 20);
        btnBuscarCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarClienteActionPerformed(evt);
            }
        });



        lbNombre.setText("");
        Cliente.add(lbNombre);
        lbNombre.setBounds(140, 60, 100, 15);

        lbTituloApellidos.setText("Apellidos");
        Cliente.add(lbTituloApellidos);
        lbTituloApellidos.setBounds(310, 60, 90, 15);

        lbApellidos.setText("");
        Cliente.add(lbApellidos);
        lbApellidos.setBounds(420, 60, 130, 15);

        lbTituloLineaCredito.setText("L\u00ednea credito");
        Cliente.add(lbTituloLineaCredito);
        lbTituloLineaCredito.setBounds(560, 60, 110, 15);

        lbLineaCredito.setText("");
        Cliente.add(lbLineaCredito);
        lbLineaCredito.setBounds(680, 60, 110, 15);

        lbTituloLineaDisp.setText("L\u00ednea disp.");
        Cliente.add(lbTituloLineaDisp);
        lbTituloLineaDisp.setBounds(30, 90, 100, 15);

        lbLineaDisp.setText("");
        Cliente.add(lbLineaDisp);
        lbLineaDisp.setBounds(140, 90, 100, 15);

        lbTituloDeudaVencida.setText("Deuda vencida");
        Cliente.add(lbTituloDeudaVencida);
        lbTituloDeudaVencida.setBounds(310, 90, 100, 15);

        lbDeudaVencida.setText("");
        Cliente.add(lbDeudaVencida);
        lbDeudaVencida.setBounds(420, 90, 1300, 15);

        lbTituloTipoDocumento.setText("Tipo doc.");
        Cliente.add(lbTituloTipoDocumento);
        lbTituloTipoDocumento.setBounds(560, 90, 110, 15);

        cbTipoDocumento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbTipoDocumentoActionPerformed(evt);
            }
        });

        Cliente.add(cbTipoDocumento);
        cbTipoDocumento.setBounds(680, 90, 110, 21);

        lbTituloDocumentoLegal.setText("Doc. legal");
        Cliente.add(lbTituloDocumentoLegal);
        lbTituloDocumentoLegal.setBounds(30, 120, 100, 15);

        lbDocumentoLegal.setText("");
        Cliente.add(lbDocumentoLegal);
        lbDocumentoLegal.setBounds(140, 120, 100, 15);

        lbTituloDestino.setText("Destino");
        Cliente.add(lbTituloDestino);
        lbTituloDestino.setBounds(310, 120, 100, 15);

        Cliente.add(cbDestino);
        cbDestino.setBounds(420, 120, 130, 21);

        lbTituloConsultoraRefencia.setText("Consultora ref.");
        Cliente.add(lbTituloConsultoraRefencia);
        lbTituloConsultoraRefencia.setBounds(30, 160, 100, 15);

        Cliente.add(txtConsultoraRefencia);
        txtConsultoraRefencia.setBounds(170, 160, 130, 21);

        btnBuscarConRefencia.setText("Buscar");
        Cliente.add(btnBuscarConRefencia);
        btnBuscarConRefencia.setBounds(310, 160, 100, 20);

        lbTituloReceptorFactura.setText("Receptor factura");
        Cliente.add(lbTituloReceptorFactura);
        lbTituloReceptorFactura.setBounds(30, 190, 110, 15);

        Cliente.add(txtReceptorFactura);
        txtReceptorFactura.setBounds(170, 190, 130, 21);

        btnBuscarReceptorFac.setText("Buscar");
        Cliente.add(btnBuscarReceptorFac);
        btnBuscarReceptorFac.setBounds(310, 190, 100, 20);

        lbTituloPagadorFactura.setText("Pagador factura");
        Cliente.add(lbTituloPagadorFactura);
        lbTituloPagadorFactura.setBounds(30, 220, 110, 15);

        Cliente.add(txtPagadorFactura);
        txtPagadorFactura.setBounds(170, 220, 130, 20);

        btnBuscarPagador.setText("Buscar");
        Cliente.add(btnBuscarPagador);
        btnBuscarPagador.setBounds(310, 220, 100, 20);

        Pestaña1.add(Cliente);
        Cliente.setBounds(0, 240, 800, 250);

        jTabbedPane.addTab("Cabecera", Pestaña1);

        Pestaña2.setLayout(null);

        DatosCabecera.setLayout(null);

        DatosCabecera.setBorder(new javax.swing.border.TitledBorder("Datos Cabecera"));
        lbTituloLineaDispDetalle.setText("L\u00ednea disp.");
        DatosCabecera.add(lbTituloLineaDispDetalle);
        lbTituloLineaDispDetalle.setBounds(20, 60, 120, 15);

        lbLineaDispDetalle.setText("");
        DatosCabecera.add(lbLineaDispDetalle);
        lbLineaDispDetalle.setBounds(150, 60, 70, 15);

        lbTituloCodClienteDetalle.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lbTituloCodClienteDetalle.setText("Cod. cliente");
        lbTituloCodClienteDetalle.setAlignmentY(0.0F);
        DatosCabecera.add(lbTituloCodClienteDetalle);
        lbTituloCodClienteDetalle.setBounds(20, 30, 120, 15);

        lbTituloNombreDetalle.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        lbTituloNombreDetalle.setText("Nombre");
        DatosCabecera.add(lbTituloNombreDetalle);
        lbTituloNombreDetalle.setBounds(300, 30, 90, 15);

        lbNombreDetalle.setText("");
        DatosCabecera.add(lbNombreDetalle);
        lbNombreDetalle.setBounds(410, 30, 100, 15);

        lbTituloApellidosDetalle.setText("Apellidos");
        DatosCabecera.add(lbTituloApellidosDetalle);
        lbTituloApellidosDetalle.setBounds(540, 30, 70, 15);

        lbApellidosDetalle.setText("");
        DatosCabecera.add(lbApellidosDetalle);
        lbApellidosDetalle.setBounds(640, 30, 140, 15);

        lbCodClienteDetalle.setText("");
        DatosCabecera.add(lbCodClienteDetalle);
        lbCodClienteDetalle.setBounds(150, 30, 110, 15);

        lbTituloFormaPagoDetalle.setText("Forma pago");
        DatosCabecera.add(lbTituloFormaPagoDetalle);
        lbTituloFormaPagoDetalle.setBounds(300, 60, 100, 15);

        lbFormaPagoDetalle.setText("");
        DatosCabecera.add(lbFormaPagoDetalle);
        lbFormaPagoDetalle.setBounds(410, 60, 140, 15);

        Pestaña2.add(DatosCabecera);
        DatosCabecera.setBounds(0, 0, 800, 90);

        DatosDetalle.setLayout(null);

        DatosDetalle.setBorder(new javax.swing.border.TitledBorder("Datos Detalle"));
        lbCodVenta.setText("Cod. Venta");
        DatosDetalle.add(lbCodVenta);
        lbCodVenta.setBounds(20, 30, 54, 15);

        lbStockDisponible1.setText("");
        DatosDetalle.add(lbStockDisponible1);
        lbStockDisponible1.setBounds(410, 70, 120, 15);

        lbCodProducto.setText("Cod. Producto");
        DatosDetalle.add(lbCodProducto);
        lbCodProducto.setBounds(300, 30, 100, 15);

        jLabel4.setText("Limite Venta");
        DatosDetalle.add(jLabel4);
        jLabel4.setBounds(540, 70, 90, 15);

        lbDesc.setText("Descripcion");
        DatosDetalle.add(lbDesc);
        lbDesc.setBounds(540, 30, 90, 15);

        lbDesc1.setText("");
        DatosDetalle.add(lbDesc1);
        lbDesc1.setBounds(640, 30, 150, 15);

        lbUnidDemandadas.setText("Unid. Demandadas");
        DatosDetalle.add(lbUnidDemandadas);
        lbUnidDemandadas.setBounds(20, 70, 120, 15);

        lbLimiteVenta1.setText("");
        DatosDetalle.add(lbLimiteVenta1);
        lbLimiteVenta1.setBounds(640, 70, 140, 15);

        lbStockDisponible.setText("Stock Disponible");
        DatosDetalle.add(lbStockDisponible);
        lbStockDisponible.setBounds(300, 70, 100, 15);

        DatosDetalle.add(txtCodVenta);
        txtCodVenta.setBounds(150, 30, 90, 21);

        DatosDetalle.add(txtCodProductp);
        txtCodProductp.setBounds(410, 30, 120, 21);

        DatosDetalle.add(txtUnidDemandadas);
        txtUnidDemandadas.setBounds(150, 70, 90, 21);

        lbControlLiq.setText("Control Liquidacion");
        DatosDetalle.add(lbControlLiq);
        lbControlLiq.setBounds(20, 110, 120, 15);

        jLabel11.setText("Reserva");
        DatosDetalle.add(jLabel11);
        jLabel11.setBounds(300, 110, 100, 15);

        lbDemandaNoAtendida.setText("Demanda No Atendida");
        DatosDetalle.add(lbDemandaNoAtendida);
        lbDemandaNoAtendida.setBounds(495, 110, 140, 15);

        lbObservaciones1.setText("Observaciones");
        DatosDetalle.add(lbObservaciones1);
        lbObservaciones1.setBounds(20, 150, 110, 15);

        lbControlLiq1.setText("");
        DatosDetalle.add(lbControlLiq1);
        lbControlLiq1.setBounds(150, 110, 90, 15);

        lbReserva1.setText("");
        DatosDetalle.add(lbReserva1);
        lbReserva1.setBounds(410, 110, 70, 15);

        DatosDetalle.add(chkDemandaNoAtendida);
        chkDemandaNoAtendida.setBounds(640, 110, 20, 21);

        btnAniadir.setText("A\u00f1adir");
        btnAniadir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAniadirActionPerformed(evt);
            }
        });

        DatosDetalle.add(btnAniadir);
        btnAniadir.setBounds(410, 160, 73, 20);

        jScrollPaneObservaciones1.setViewportView(atxObservaciones1);

        DatosDetalle.add(jScrollPaneObservaciones1);
        jScrollPaneObservaciones1.setBounds(150, 150, 250, 50);

        Pestaña2.add(DatosDetalle);
        DatosDetalle.setBounds(0, 90, 800, 210);

        TablaDetalle.setLayout(null);

        TablaDetalle.setBorder(new javax.swing.border.TitledBorder("Tabla Detalle"));
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        TablaDetalle.add(jTable1);
        jTable1.setBounds(30, 30, 490, 140);

        Pestaña2.add(TablaDetalle);
        TablaDetalle.setBounds(0, 300, 800, 190);

        jTabbedPane.addTab("Detalle", Pestaña2);
        jTabbedPane.setBounds(0, 300, 820, 200);

        getContentPane().add(jTabbedPane, java.awt.BorderLayout.CENTER);

        jMenu.setText("Cliente");
        jMenuItem1.setText("Alta Cliente");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                altaClienteActionPerformed(evt);
            }
        });
        jMenu.add(jMenuItem1);

        jMenuBar1.add(jMenu);

        setJMenuBar(jMenuBar1);

    }//GEN-END:initComponents

    private void cbTipoDocumentoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbTipoDocumentoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbTipoDocumentoActionPerformed

    private void btnAniadirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAniadirActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnAniadirActionPerformed
    
    private void altaClienteActionPerformed(java.awt.event.ActionEvent evt) {
        this.ejecutarWeb("mostrarVentadaModal" + "( 'LPRegistroOnlineModalEjemplo' )");
        
    }
    
    private void btnBuscarClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarClienteActionPerformed
        Long codclie = null;
        if(this.oidPais == null || this.txtCodCliente.getText() == null) 
        {
          return;
        }
        try {
          //MONRegistroOnline mon = this.lookupServidor();          
          if (this.txtCodCliente.getText() != null && 
                this.txtCodCliente.getText().trim().length() > 0) {
            codclie = new Long(this.txtCodCliente.getText());
          }
          
          DTOBuscarDatosCliente dtoBuscarDatosCliente = new DTOBuscarDatosCliente();
          dtoBuscarDatosCliente.setCodClie(codclie);
          dtoBuscarDatosCliente.setOidPais(this.oidPais.toString());
          
          Object obj = this.getDatosFromServlet("buscarDatosCliente", 
                  "es.indra.sicc.dtos.prueba.DTOBuscarDatosCliente", 
                  dtoBuscarDatosCliente);
            
            if (obj instanceof DTODatosCliente) {
              DTODatosCliente dtoc = (DTODatosCliente) obj;
              //mon.buscarDatosCliente(this.oidPais.toString(), codclie);
              if (dtoc != null) {
                this.cargarDatosCliete(dtoc);
              }
            }
        } catch (Exception e) {
          e.printStackTrace();
          System.out.println("Error al buscar el codigo de cliente: " + codclie);
        }
        
        // TODO add your handling code here:
    }//GEN-LAST:event_btnAniadirActionPerformed
    
    private void cargarDatosCliete(DTODatosCliente dtoc) {
      //TODO cargar los datos del cliente
      this.lbNombre.setText(dtoc.getNombre());
      this.lbApellidos.setText(dtoc.getApellidos());
      this.lbLineaCredito.setText(dtoc.getLineaCredito().toString());
      this.lbLineaDisp.setText(dtoc.getLineaDisp().toString());
      this.lbDeudaVencida.setText(dtoc.getDeudaVencida().toString());
      //this.lbDocumentoLegal.setText(); TODO
      for(int i = 0; i < dtoc.getTiposDocumento().length; ++i) {
        this.cbTipoDocumento.addItem(
                    dtoc.getTiposDocumento()[i].getDesc()
                    );
      }
      
      for(int i = 0; i < dtoc.getDirecciones().length; ++i) {
        this.cbDestino.addItem(
                    dtoc.getDirecciones()[i].getDesc()
                    );
      }
      
      this.lbCodClienteDetalle.setText(this.txtCodCliente.getText());
      this.lbNombreDetalle.setText(dtoc.getNombre());
      this.lbApellidosDetalle.setText(dtoc.getApellidos());
      this.lbLineaDispDetalle.setText(dtoc.getLineaDisp().toString());
      this.lbFormaPagoDetalle.setText((String)this.cbFormaPago.getSelectedItem());
      
      
    }
    /**
     *1.- Se toma el registro correspondinete al tipo de solicitud seleccionado en el combo en el atributo cache.tiposSolicicitud. 
      2.- Se asignan a la pantalla los siguientes valores: 
      lbmarca= DTOTipoSolicitud.marca 
      lbCanal= DTOTipoSolicitud.canal 
      lbAcceso= DTOTipoSolicitud.acceso 
      lbSubAcceso= cache.txtSubAcceso (este atributo es del objeto cache 
      lbMonedaDoc= DTOTipoSolicitud.moneda
     * 
     */
    private void cbTipoSolicitudActionPerformed(java.awt.event.ActionEvent evt) {
        String tipoSolic = (String)cbTipoSolicitud.getSelectedItem();
        for (int i=0; i<cache.getTiposSolicitud().length;i++){
            if (cache.getTiposSolicitud()[i].getTipoSolicitud()!=null &&
                cache.getTiposSolicitud()[i].getTipoSolicitud().equals(tipoSolic)){
                if (cache.getTiposSolicitud()[i].getMarca()!=null){
                    lbMarca1.setText(cache.getTiposSolicitud()[i].getMarca());
                }
                if (cache.getTiposSolicitud()[i].getCanal()!=null){
                    lbCanal1.setText(cache.getTiposSolicitud()[i].getCanal());
                }
                if (cache.getTiposSolicitud()[i].getAcceso()!=null){
                    lbAcceso1.setText(cache.getTiposSolicitud()[i].getAcceso());
                }
                if (cache.getTxtSubAcceso()!=null){
                    lbSubacceso1.setText(cache.getTxtSubAcceso());
                }
                if (cache.getTiposSolicitud()[i].getMoneda()!=null){
                    lbMonedaDoc1.setText(cache.getTiposSolicitud()[i].getMoneda());
                }                
            }
        }
    }
    
    private javax.swing.JPanel Cliente;
    private javax.swing.JPanel DatosCabecera;
    private javax.swing.JPanel DatosDetalle;
    private javax.swing.JPanel DatosSolicitud;
    private javax.swing.JPanel Pestaña1;
    private javax.swing.JPanel Pestaña2;
    private javax.swing.JPanel TablaDetalle;
    private javax.swing.JPanel TipoSolicitud;
    private javax.swing.JTextArea atxObservaciones;
    private javax.swing.JTextArea atxObservaciones1;
    private javax.swing.JButton btnAniadir;
    private javax.swing.JButton btnBuscarCliente;
    private javax.swing.JButton btnBuscarConRefencia;
    private javax.swing.JButton btnBuscarPagador;
    private javax.swing.JButton btnBuscarReceptorFac;
    private javax.swing.JComboBox cbAccesoFisico;
    private javax.swing.JComboBox cbDestino;
    private javax.swing.JComboBox cbFormaPago;
    private javax.swing.JComboBox cbPeriodo;
    private javax.swing.JComboBox cbTipoDespacho;
    private javax.swing.JComboBox cbTipoDocumento;
    private javax.swing.JComboBox cbTipoSolicitud;
    private javax.swing.JCheckBox chkDemandaNoAtendida;
    private javax.swing.JCheckBox chkIndCodigoVentaProducto;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JMenu jMenu;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JScrollPane jScrollPaneObservaciones;
    private javax.swing.JScrollPane jScrollPaneObservaciones1;
    private javax.swing.JTabbedPane jTabbedPane;
    private javax.swing.JTable jTable1;
    private javax.swing.JLabel lbAcceso;
    private javax.swing.JLabel lbAcceso1;
    private javax.swing.JLabel lbAccesoFisico;
    private javax.swing.JLabel lbApellidos;
    private javax.swing.JLabel lbApellidosDetalle;
    private javax.swing.JLabel lbCanal;
    private javax.swing.JLabel lbCanal1;
    private javax.swing.JLabel lbCodClienteDetalle;
    private javax.swing.JLabel lbCodProducto;
    private javax.swing.JLabel lbCodVenta;
    private javax.swing.JLabel lbControlLiq;
    private javax.swing.JLabel lbControlLiq1;
    private javax.swing.JLabel lbDemandaNoAtendida;
    private javax.swing.JLabel lbDesc;
    private javax.swing.JLabel lbDesc1;
    private javax.swing.JLabel lbDeudaVencida;
    private javax.swing.JLabel lbDocumentoLegal;
    private javax.swing.JLabel lbFechaProgramadaFac;
    private javax.swing.JLabel lbFormaPago;
    private javax.swing.JLabel lbFormaPagoDetalle;
    private javax.swing.JLabel lbIndCodigoVentaProducto;
    private javax.swing.JLabel lbLimiteVenta1;
    private javax.swing.JLabel lbLineaCredito;
    private javax.swing.JLabel lbLineaDisp;
    private javax.swing.JLabel lbLineaDispDetalle;
    private javax.swing.JLabel lbMarca;
    private javax.swing.JLabel lbMarca1;
    private javax.swing.JLabel lbMonedaDoc;
    private javax.swing.JLabel lbMonedaDoc1;
    private javax.swing.JLabel lbNombre;
    private javax.swing.JLabel lbNombreDetalle;
    private javax.swing.JLabel lbObservaciones;
    private javax.swing.JLabel lbObservaciones1;
    private javax.swing.JLabel lbPeriodo;
    private javax.swing.JLabel lbReserva1;
    private javax.swing.JLabel lbStockDisponible;
    private javax.swing.JLabel lbStockDisponible1;
    private javax.swing.JLabel lbSubacceso;
    private javax.swing.JLabel lbSubacceso1;
    private javax.swing.JLabel lbTipoDespacho;
    private javax.swing.JLabel lbTituloApellidos;
    private javax.swing.JLabel lbTituloApellidosDetalle;
    private javax.swing.JLabel lbTituloCodCliente;
    private javax.swing.JLabel lbTituloCodClienteDetalle;
    private javax.swing.JLabel lbTituloConsultoraRefencia;
    private javax.swing.JLabel lbTituloDestino;
    private javax.swing.JLabel lbTituloDeudaVencida;
    private javax.swing.JLabel lbTituloDocumentoLegal;
    private javax.swing.JLabel lbTituloFormaPagoDetalle;
    private javax.swing.JLabel lbTituloLineaCredito;
    private javax.swing.JLabel lbTituloLineaDisp;
    private javax.swing.JLabel lbTituloLineaDispDetalle;
    private javax.swing.JLabel lbTituloNombre;
    private javax.swing.JLabel lbTituloNombreDetalle;
    private javax.swing.JLabel lbTituloPagadorFactura;
    private javax.swing.JLabel lbTituloReceptorFactura;
    private javax.swing.JLabel lbTituloTipoDocumento;
    private javax.swing.JLabel lbUnidDemandadas;
    private javax.swing.JLabel lblTipoSolicitud;
    private javax.swing.JTextField txtCodCliente;
    private javax.swing.JTextField txtCodProductp;
    private javax.swing.JTextField txtCodVenta;
    private javax.swing.JTextField txtConsultoraRefencia;
    private javax.swing.JTextField txtFechaProgramadaFac;
    private javax.swing.JTextField txtPagadorFactura;
    private javax.swing.JTextField txtReceptorFactura;
    private javax.swing.JTextField txtUnidDemandadas;
    // End of variables declaration
    
    private void ejecutarWeb(String nombreFuncionJS) {
      System.out.println("Se llamo a ejecutarWeb con nombre Funcion JS: " + nombreFuncionJS);
      JSObject win = JSObject.getWindow(this);
      //String parametros = "'http://lala'";
      win.eval(nombreFuncionJS); //+ "(" + parametros + ")");
      System.out.println("Se llamo termino la ejecucion de ejecutarWeb");
    }
    
    public void ejecutarJava() {
      //TODO
      System.out.println("Se llamo a ejecutarJava");
    }
    
    public void setCodigoCliente(String texto) {
      System.out.println("entro en setCodigoCliente con el texto: " + texto);
      this.txtCodCliente.setText(texto);
      //this.repaint();
    }
    
    private Object getDatosFromServlet(String idBusiness, String nombreDTO, Object dto ) {
      Object object = null;
      
      //Se serializa el objeto
      ByteArrayOutputStream baos = new ByteArrayOutputStream();
      try {
        ObjectOutputStream oos = new ObjectOutputStream(baos);
 
        oos.writeObject(dto);
        oos.flush();
      } catch (java.io.IOException e) {
        e.printStackTrace();
      }
      byte []serializedBytes = baos.toByteArray();
      // now you have the serialized bytes.
      
      serializedBytes = Base64.encode(serializedBytes);
      String serializedDto = new String(serializedBytes);
          
      //se arma el mensaje a ser enviado
      URLConnection urlConn = Communicator.createURLConnection("http://cdos02ap:7777/sicc/servletPrueba");
      String content = "IDBusiness=" + idBusiness + "&DTOE=" + nombreDTO;
      content += "&DTOData=" + serializedDto;
      //content = URLEncoder.encode(content);
      //content = content.replaceAll(" ", "%20");
      Communicator com = new Communicator();
      com.postRequest(urlConn, content);
      byte[] response = com.receiveBinaryResponse(urlConn);

      if(response != null || response.length > 0) {
        //se deserealiza la respuesta y se retorna el objeto
            
        ByteArrayInputStream bais = new ByteArrayInputStream(response);
        try {
          java.io.ObjectInputStream ois = new java.io.ObjectInputStream(bais);
          object = ois.readObject();
        } catch (java.io.IOException e) {
          e.printStackTrace();
        } catch (ClassNotFoundException e) {
          e.printStackTrace();
        }
      }
      System.out.println("el object es: " + object);    
      
      return object;
    }
}
