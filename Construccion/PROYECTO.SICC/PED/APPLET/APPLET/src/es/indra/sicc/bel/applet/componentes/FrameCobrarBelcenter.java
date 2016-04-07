package es.indra.sicc.bel.applet.componentes;

import es.indra.mare.common.dto.MareDTO;
import es.indra.sicc.bel.applet.util.DetalleCobroDevolucion;
import es.indra.sicc.comunapplet.Communicator;
import es.indra.sicc.comunapplet.ConstantesBotones;
import es.indra.sicc.comunapplet.ConstantesBundlesApplet;
import es.indra.sicc.comunapplet.ConstantesDimensiones;
import es.indra.sicc.comunapplet.ConstantesFrames;
import es.indra.sicc.comunapplet.ConstantesLabels;
import es.indra.sicc.comunapplet.ConstantesMarcos;
import es.indra.sicc.comunapplet.PropertiesApplet;
import es.indra.sicc.comunapplet.UtilApplet;
import es.indra.sicc.comunapplet.exceptions.AppletException;
import es.indra.sicc.dtos.bel.DTOCargaCobroBelcenter;
import es.indra.sicc.dtos.bel.DTOCobroBelcenter;

import es.indra.sicc.dtos.bel.DTOContinuarFacturacion;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Insets;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import java.math.BigDecimal;

import java.util.ArrayList;

import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;

/*
 * CobrarBelcenter.java
 *
 * Created on 28 de febrero de 2005, 12:24 PM
 */

/**
 *
 * @author  mmaidana
 */
public class FrameCobrarBelcenter extends javax.swing.JDialog {

    private CobrarBelcenter cobrarBelcenter;

    private Font titleFont = new Font("Arial", Font.BOLD, 11);
    private Font contentFont = new Font("Arial", Font.PLAIN, 11);
    private Font panelFont = new Font("Arial", Font.BOLD, 12);


    public FrameCobrarBelcenter(CobrarBelcenter cobrarBelcenter) {
      this();
      this.cobrarBelcenter = cobrarBelcenter;
    }
    
    /** Creates new form FrameCobrarBelcenter */
    public FrameCobrarBelcenter() {
      initComponents();
      initUserComponents();
    }
    
    private void initUserComponents(){
    
      //Mnemonics
      this.btnAnyadir.setMnemonic('A');
      this.btnCambiosVentas.setMnemonic('V');
      this.btnCerrar.setMnemonic('C');
      this.btnEliminar.setMnemonic('E');
      this.btnModificar.setMnemonic('M');
      this.btnNotasPendientes.setMnemonic('N');
      this.btnGuardar.setMnemonic('G');
    
    
      //Backgrounds
      pnDatosCobro.setBackground(new Color(242,242,241));
      pnCobrarBelcenterCabecera.setBackground(new Color(242,242,241));
      pnDatosDetalle.setBackground(new Color(242,242,241));
      //pnBotonesTabla.setBackground(new Color(242,242,241));
      pnDatosPendientes.setBackground(new Color(242,242,241));
      //pnBotones.setBackground(new Color(242,242,241));
      
      //Fuentes
      pnDatosCobro.setFont(panelFont);
      pnCobrarBelcenterCabecera.setFont(panelFont);
      pnDatosDetalle.setFont(panelFont);
      pnDatosPendientes.setFont(panelFont);
    
      //Inicializacion de variables
      movimientosCaja = new ArrayList();
    
      //listeners
      this.addWindowListener(
        new WindowAdapter(){
          public void windowClosing(WindowEvent e){
            setVisible(false);
            dispose();
          }
        }
      );
    
      this.btnAnyadir.addActionListener(
        new ActionListener(){
          public void actionPerformed(ActionEvent e){
            anadir();            
          }
        }
      );
    
      this.btnModificar.addActionListener(
        new ActionListener(){
          public void actionPerformed(ActionEvent e){
            modificar();
          }
        }
      );
    
      this.btnEliminar.addActionListener(
        new ActionListener(){
          public void actionPerformed(ActionEvent e){
            cobrarBelcenter.eliminar();
          }
        }
      );
    
      this.btnCambiosVentas.addActionListener(
        new ActionListener(){
          public void actionPerformed(ActionEvent e){
            cambiosVentas();
          }
        }
      );
      
      this.btnCerrar.addActionListener(
        new ActionListener(){
          public void actionPerformed(ActionEvent e){
            cerrar();
          }
        }
      );
    
      this.btnNotasPendientes.addActionListener(
        new ActionListener(){
          public void actionPerformed(ActionEvent e){
            notasPendientes();
          }
        }
      );
      
      this.btnGuardar.addActionListener(
        new ActionListener(){
          public void actionPerformed(ActionEvent e){
            guardar();
          }
        }
      );
      
      this.addWindowListener( new WindowAdapter() {
        public void windowClosing( WindowEvent evt ) {
          /*cancel = true ;     //  used in the guard to prevent message box from coming up
          setVisible( false ) ;
          System.out.println("Dialog window closing called") ;
          ( evt.getWindow() ).dispose() ;*/
          close();
        }
      });
    
      //PropertiesApplet.setProperties(ConstantesBundlesApplet.APPLET_FRAMES_BUNDLE);
      this.setTitle(PropertiesApplet.getPropertie(ConstantesFrames.FRAMES_COBRAR_BELCENTER, ConstantesBundlesApplet.APPLET_FRAMES_BUNDLE));
      this.setResizable(false);
      this.getContentPane().setBackground(new Color(242,242,241));
    
      Dimension d = Toolkit.getDefaultToolkit().getScreenSize();

      int xPos = (int)(d.getWidth() - ConstantesDimensiones.FRAME_COBRAR_BELCENTER_WIDTH)/2;
      int yPos = (int)(d.getHeight() - ConstantesDimensiones.FRAME_COBRAR_BELCENTER_HEIGHT)/2;
    
      this.setBounds(xPos, yPos, ConstantesDimensiones.FRAME_COBRAR_BELCENTER_WIDTH, ConstantesDimensiones.FRAME_COBRAR_BELCENTER_HEIGHT); //850 x 620
      
      
      //this.setVisible(true);
    }
    
    private void anadir() {
      /*if( cobrarBelcenter != null ){
              System.out.println("no es null");
            }else{
              System.out.println("es null");
            }
          */
            try{
              cobrarBelcenter.anyadir();
            }catch(Exception ex){
              
              UtilApplet.procesarError(ex, this);
              
              //System.out.println(ex);
              ex.printStackTrace();
              
            }
    }
    
    private void modificar() {
      try{
              this.cobrarBelcenter.modificar();
            }catch(AppletException ae){
              //System.out.println(ae.toString());
              UtilApplet.procesarError(ae, this);
              ae.printStackTrace();
            }
    }
    
    private void cambiosVentas() {
      try{
              this.cobrarBelcenter.cambiosVentas();
            } catch(AppletException ae){
              //System.out.println(ae.toString());
              
              //System.out.println("codigo: " + ae.getCode());
              
              //System.out.println(((MareException)ae.getOriginalCause()).getCode());
              ae.getOriginalCause().printStackTrace();
              UtilApplet.procesarError(ae, this);
              
              //ae.printStackTrace();
            }
    }
    
    private void notasPendientes() {
      try{
              this.cobrarBelcenter.notasPendientes();
      }catch(AppletException ae){
        UtilApplet.procesarError(ae,this);
      }
    }
    
    private void guardar() {
      try{
        this.cancelar = false;
        this.cobrarBelcenter.guardar();        
      }catch(AppletException ae){
        UtilApplet.procesarError(ae,this);
      }
    }
    
    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    private void initComponents() {//GEN-BEGIN:initComponents
        pnDatosCobro = new javax.swing.JPanel();
        pnCobrarBelcenterCabecera = new javax.swing.JPanel();
        lblNConsolidado = new javax.swing.JLabel();
        lblDivisa = new javax.swing.JLabel();
        lblImporte = new javax.swing.JLabel();
        lblFecha = new javax.swing.JLabel();
        lblNombreCliente = new javax.swing.JLabel();
        lblCodCliente = new javax.swing.JLabel();
        lblCaja = new javax.swing.JLabel();
        lblSubacceso = new javax.swing.JLabel();
        lblAcceso = new javax.swing.JLabel();
        lblCanal = new javax.swing.JLabel();
        lblTxtCanal = new javax.swing.JLabel();
        lblTxtAcceso = new javax.swing.JLabel();
        lblTxtSubacceso = new javax.swing.JLabel();
        lblTxtCaja = new javax.swing.JLabel();
        lblTxtCodCliente = new javax.swing.JLabel();
        lblTxtNombreCliente = new javax.swing.JLabel();
        lblImporteAPagarEnDivisa = new javax.swing.JLabel();
        lblTxtImporteAPagarEnDivisa = new javax.swing.JLabel();
        lblTxtFecha = new javax.swing.JLabel();
        lblTxtNConsolidado = new javax.swing.JLabel();
        lblTxtImporteAPagar = new javax.swing.JLabel();
        lblTxtDivisa = new javax.swing.JLabel();
        pnDatosDetalle = new javax.swing.JPanel();
        
        spTablaDetalle = new JScrollPane();
        
        spTablaDetalle.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
        spTablaDetalle.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        
        tablaDetalle = new TablaCobrarBelcenter();
        tablaDetalle.deleteEmptyRows();
        
        spTablaDetalle.getViewport().add(tablaDetalle);

        pnBotonesTabla = new javax.swing.JPanel();
        btnAnyadir = new javax.swing.JButton();
        btnModificar = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();
        pnDatosPendientes = new javax.swing.JPanel();
        lblTotalPagado = new javax.swing.JLabel();
        lblTotalPendiente = new javax.swing.JLabel();
        lblTxtTotalPagado = new javax.swing.JLabel();
        lblTxtTotalPendiente = new javax.swing.JLabel();
        pnBotones = new javax.swing.JPanel();
        btnCambiosVentas = new javax.swing.JButton();
        this.btnCerrar = new javax.swing.JButton();
        btnNotasPendientes = new javax.swing.JButton();
        this.btnGuardar = new javax.swing.JButton();

        getContentPane().setLayout(new java.awt.BorderLayout(0, 2));

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        pnDatosCobro.setLayout(null);

        //pnDatosCobro.setBorder(new javax.swing.border.TitledBorder("Datos de cobro"));

        //--INICIO CONFIGURACION PANELS-----------------------------------------
        //PropertiesApplet.setProperties(ConstantesBundlesApplet.APPLET_MARCOS_BUNDLE);

        //PropertiesApplet.getPropertie(ConstantesMarcos.MARCOS_DATOS_CABECERA);

        pnDatosCobro.setBorder(new CompoundBorder(new EmptyBorder(
          new Insets(1, 1, 1, 1)), new TitledBorder(
          new EtchedBorder(), PropertiesApplet.getPropertie(ConstantesMarcos.MARCOS_DATOS_COBRO, ConstantesBundlesApplet.APPLET_MARCOS_BUNDLE), 
          TitledBorder.DEFAULT_JUSTIFICATION, //"Datos de cobro"
          TitledBorder.DEFAULT_POSITION, new Font("Dialog", 1, 11), new Color(153, 153, 153))));
        
        pnCobrarBelcenterCabecera.setLayout(null);

        //pnCobrarBelcenterCabecera.setBorder(new javax.swing.border.TitledBorder("Datos de cabecera"));
        
        pnCobrarBelcenterCabecera.setBorder(new CompoundBorder(new EmptyBorder(
          new Insets(1, 1, 1, 1)), new TitledBorder(
          new EtchedBorder(), PropertiesApplet.getPropertie(ConstantesMarcos.MARCOS_DATOS_CABECERA, ConstantesBundlesApplet.APPLET_MARCOS_BUNDLE), 
          TitledBorder.DEFAULT_JUSTIFICATION, //"Datos de cabecera"
          TitledBorder.DEFAULT_POSITION, new Font("Dialog", 1, 11), new Color(153, 153, 153))));

        //--INICIO CONFIGURACION LABELS-----------------------------------------
        //PropertiesApplet.setProperties(ConstantesBundlesApplet.APPLET_LABELS_BUNDLE);
        
        lblNConsolidado.setText(PropertiesApplet.getPropertie(ConstantesLabels.LABEL_N_CONSOLIDADO, ConstantesBundlesApplet.APPLET_LABELS_BUNDLE));
        pnCobrarBelcenterCabecera.add(lblNConsolidado);
        
        lblNConsolidado.setBounds(10, 140, 160, 15);
        
        lblNConsolidado.setFont(titleFont);

        lblDivisa.setText(PropertiesApplet.getPropertie(ConstantesLabels.LABEL_DIVISA, ConstantesBundlesApplet.APPLET_LABELS_BUNDLE));
        pnCobrarBelcenterCabecera.add(lblDivisa);
        
        lblDivisa.setBounds(550, 140, 130, 15);
        
        lblDivisa.setFont(titleFont);

        lblImporte.setText(PropertiesApplet.getPropertie(ConstantesLabels.LABEL_IMPORTE_A_PAGAR, ConstantesBundlesApplet.APPLET_LABELS_BUNDLE));
        pnCobrarBelcenterCabecera.add(lblImporte);
        
        lblImporte.setBounds(370, 140, 130, 15);
        
        lblImporte.setFont(titleFont);

        lblFecha.setText(PropertiesApplet.getPropertie(ConstantesLabels.LABEL_FECHA, ConstantesBundlesApplet.APPLET_LABELS_BUNDLE));
        pnCobrarBelcenterCabecera.add(lblFecha);
        
        lblFecha.setBounds(190, 140, 140, 15);
        
        lblFecha.setFont(titleFont);

        lblNombreCliente.setText(PropertiesApplet.getPropertie(ConstantesLabels.LABEL_NOMBRE_CLIENTE, ConstantesBundlesApplet.APPLET_LABELS_BUNDLE));
        pnCobrarBelcenterCabecera.add(lblNombreCliente);
        
        lblNombreCliente.setBounds(10, 100, 170, 15);
        
        lblNombreCliente.setFont(titleFont);

        lblCodCliente.setText(PropertiesApplet.getPropertie(ConstantesLabels.LABEL_COD_CLIENTE, ConstantesBundlesApplet.APPLET_LABELS_BUNDLE));
        pnCobrarBelcenterCabecera.add(lblCodCliente);
        
        lblCodCliente.setBounds(190, 60, 150, 15);
        
        lblCodCliente.setFont(titleFont);

        lblCaja.setText(PropertiesApplet.getPropertie(ConstantesLabels.LABEL_CAJA, ConstantesBundlesApplet.APPLET_LABELS_BUNDLE));
        pnCobrarBelcenterCabecera.add(lblCaja);
        
        lblCaja.setBounds(10, 60, 170, 15);
        
        lblCaja.setFont(titleFont);

        lblSubacceso.setText(PropertiesApplet.getPropertie(ConstantesLabels.LABEL_SUBACCESO, ConstantesBundlesApplet.APPLET_LABELS_BUNDLE));
        pnCobrarBelcenterCabecera.add(lblSubacceso);
        
        lblSubacceso.setBounds(370, 20, 170, 15);
        
        lblSubacceso.setFont(titleFont);

        lblAcceso.setText(PropertiesApplet.getPropertie(ConstantesLabels.LABEL_ACCESO, ConstantesBundlesApplet.APPLET_LABELS_BUNDLE));
        pnCobrarBelcenterCabecera.add(lblAcceso);
        
        lblAcceso.setBounds(190, 20, 150, 15);
        
        lblAcceso.setFont(titleFont);

        lblCanal.setText(PropertiesApplet.getPropertie(ConstantesLabels.LABEL_CANAL, ConstantesBundlesApplet.APPLET_LABELS_BUNDLE));
        pnCobrarBelcenterCabecera.add(lblCanal);
        
        lblCanal.setBounds(10, 20, 170, 15);
        
        lblCanal.setFont(titleFont);

        lblTxtCanal.setText("");
        pnCobrarBelcenterCabecera.add(lblTxtCanal);
        
        lblTxtCanal.setBounds(10, 35, 170, 15);
        
        lblTxtCanal.setFont(contentFont);
        

        lblTxtAcceso.setText("");
        pnCobrarBelcenterCabecera.add(lblTxtAcceso);
        
        lblTxtAcceso.setBounds(190, 35, 150, 15);
        
        lblTxtAcceso.setFont(contentFont);

        lblTxtSubacceso.setText("");
        pnCobrarBelcenterCabecera.add(lblTxtSubacceso);
        
        lblTxtSubacceso.setBounds(370, 35, 160, 15);
        
        lblTxtSubacceso.setFont(contentFont);

        lblTxtCaja.setText("");
        pnCobrarBelcenterCabecera.add(lblTxtCaja);
        
        lblTxtCaja.setBounds(10, 75, 170, 15);
        
        lblTxtCaja.setFont(contentFont);

        lblTxtCodCliente.setText("");
        pnCobrarBelcenterCabecera.add(lblTxtCodCliente);
        lblTxtCodCliente.setBounds(190, 75, 150, 15);
        lblTxtCodCliente.setFont(contentFont);

        lblTxtNombreCliente.setText("");
        pnCobrarBelcenterCabecera.add(lblTxtNombreCliente);
        
        lblTxtNombreCliente.setBounds(10, 115, 170, 15);
        
        lblTxtNombreCliente.setFont(contentFont);

        lblImporteAPagarEnDivisa.setText(PropertiesApplet.getPropertie(ConstantesLabels.LABEL_IMP_A_PAGAR_EN_DIVISA, ConstantesBundlesApplet.APPLET_LABELS_BUNDLE));
        pnCobrarBelcenterCabecera.add(lblImporteAPagarEnDivisa);
        
        lblImporteAPagarEnDivisa.setBounds(10, 180, 180, 15);
        
        lblImporteAPagarEnDivisa.setFont(titleFont);

        lblTxtImporteAPagarEnDivisa.setText("");
        pnCobrarBelcenterCabecera.add(lblTxtImporteAPagarEnDivisa);
        
        lblTxtImporteAPagarEnDivisa.setBounds(10, 195, 170, 15);
        
        lblTxtImporteAPagarEnDivisa.setFont(contentFont);

        lblTxtFecha.setText("");
        pnCobrarBelcenterCabecera.add(lblTxtFecha);
        
        lblTxtFecha.setBounds(190, 155, 150, 15);
        
        lblTxtFecha.setFont(contentFont);

        lblTxtNConsolidado.setText("");
        pnCobrarBelcenterCabecera.add(lblTxtNConsolidado);
        
        lblTxtNConsolidado.setBounds(10, 155, 160, 15);
        
        lblTxtNConsolidado.setFont(contentFont);

        lblTxtImporteAPagar.setText("");
        pnCobrarBelcenterCabecera.add(lblTxtImporteAPagar);
        
        lblTxtImporteAPagar.setBounds(370, 155, 140, 15);
        
        lblTxtImporteAPagar.setFont(contentFont);

        lblTxtDivisa.setText("");
        pnCobrarBelcenterCabecera.add(lblTxtDivisa);
        
        lblTxtDivisa.setBounds(550, 155, 160, 15);
        
        lblTxtDivisa.setFont(contentFont);

        pnDatosCobro.add(pnCobrarBelcenterCabecera);
        pnCobrarBelcenterCabecera.setBounds(10, 15, 823, 230);

        pnDatosDetalle.setLayout(new java.awt.BorderLayout(5, 0));
        //pnDatosDetalle.setLayout(null);

        //pnDatosDetalle.setBorder(new javax.swing.border.TitledBorder("Datos de detalle"));
        
        //--INICIO CONFIGURACION PANELS-----------------------------------------
        //PropertiesApplet.setProperties(ConstantesBundlesApplet.APPLET_MARCOS_BUNDLE);
        
        pnDatosDetalle.setBorder(new CompoundBorder(new EmptyBorder(
          new Insets(1, 1, 1, 1)), new TitledBorder(
          new EtchedBorder(), PropertiesApplet.getPropertie(ConstantesMarcos.MARCOS_DATOS_DETALLE, ConstantesBundlesApplet.APPLET_MARCOS_BUNDLE), 
          TitledBorder.DEFAULT_JUSTIFICATION, //"Datos de detalle"
          TitledBorder.DEFAULT_POSITION, new Font("Dialog", 1, 11), new Color(153, 153, 153))));
        
        //pnDatosDetalle.add(tablaDetalle, java.awt.BorderLayout.CENTER);
        pnDatosDetalle.add(spTablaDetalle, java.awt.BorderLayout.CENTER);
        //spTablaDetalle.setBounds(10, 245, 823, 190);
        
        java.awt.FlowLayout pnBotonesTablaLayout = new java.awt.FlowLayout(java.awt.FlowLayout.LEFT);
        pnBotonesTablaLayout.setHgap(0);
        pnBotonesTablaLayout.setVgap(0);

        //pnBotonesTabla.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT));
        pnBotonesTabla.setLayout( pnBotonesTablaLayout );
        pnBotonesTabla.setBorder( new EtchedBorder() );

        //--INICIO CONFIGURACION BOTONES TABLA----------------------------------
        //PropertiesApplet.setProperties(ConstantesBundlesApplet.APPLET_BUTTONS_BUNDLE);

        btnAnyadir.setBackground(new java.awt.Color(5, 123, 162));
        btnAnyadir.setForeground(new java.awt.Color(255, 255, 255));
        
        btnAnyadir.setText(PropertiesApplet.getPropertie(ConstantesBotones.BUTTON_ANYADIR, ConstantesBundlesApplet.APPLET_BUTTONS_BUNDLE));
        pnBotonesTabla.add(btnAnyadir);

        btnModificar.setBackground(new java.awt.Color(5, 123, 162));
        btnModificar.setForeground(new java.awt.Color(255, 255, 255));
        btnModificar.setText(PropertiesApplet.getPropertie(ConstantesBotones.BUTTON_MODIFICAR, ConstantesBundlesApplet.APPLET_BUTTONS_BUNDLE));
        pnBotonesTabla.add(btnModificar);

        btnEliminar.setBackground(new java.awt.Color(5, 123, 162));
        btnEliminar.setForeground(new java.awt.Color(255, 255, 255));
        btnEliminar.setText(PropertiesApplet.getPropertie(ConstantesBotones.BUTTON_ELIMINAR, ConstantesBundlesApplet.APPLET_BUTTONS_BUNDLE));
        pnBotonesTabla.add(btnEliminar);
        pnDatosDetalle.add(pnBotonesTabla, java.awt.BorderLayout.SOUTH);
        pnDatosCobro.add(pnDatosDetalle);
        
        pnDatosDetalle.setBounds(10, 245, 823, 190);
        pnDatosPendientes.setLayout(null);

        //--FIN CONFIGURACION BOTONES TABLA-------------------------------------



        //pnDatosPendientes.setBorder(new javax.swing.border.TitledBorder("Datos pendientes"));

        //--INICIO CONFIGURACION PANEL-----------------------------------------
        //PropertiesApplet.setProperties(ConstantesBundlesApplet.APPLET_MARCOS_BUNDLE);

        pnDatosPendientes.setBorder(new CompoundBorder(new EmptyBorder(
          new Insets(1, 1, 1, 1)), new TitledBorder(
          new EtchedBorder(), PropertiesApplet.getPropertie(ConstantesMarcos.MARCOS_DATOS_PENDIENTES, ConstantesBundlesApplet.APPLET_MARCOS_BUNDLE), 
          TitledBorder.DEFAULT_JUSTIFICATION, //"Datos pendientes"
          TitledBorder.DEFAULT_POSITION, new Font("Dialog", 1, 11), new Color(153, 153, 153))));
        
        //PropertiesApplet.setProperties(ConstantesBundlesApplet.APPLET_LABELS_BUNDLE);
        
        lblTotalPagado.setText(PropertiesApplet.getPropertie(ConstantesLabels.LABEL_TOTAL_PAGADO, ConstantesBundlesApplet.APPLET_LABELS_BUNDLE) );
        pnDatosPendientes.add(lblTotalPagado);
        lblTotalPagado.setBounds(10, 20, 80, 15);
        lblTotalPagado.setFont(titleFont);

        lblTotalPendiente.setText(PropertiesApplet.getPropertie(ConstantesLabels.LABEL_TOTAL_PENDIENTE, ConstantesBundlesApplet.APPLET_LABELS_BUNDLE));
        pnDatosPendientes.add(lblTotalPendiente);

        lblTotalPendiente.setBounds(190, 20, 100, 15);
        
        lblTotalPendiente.setFont(titleFont);

        lblTxtTotalPagado.setText("");
        pnDatosPendientes.add(lblTxtTotalPagado);
        
        lblTxtTotalPagado.setBounds(10, 35, 180, 15);
        
        lblTxtTotalPagado.setFont(contentFont);

        lblTxtTotalPendiente.setText("");
        pnDatosPendientes.add(lblTxtTotalPendiente);
        
        lblTxtTotalPendiente.setBounds(190, 35, 170, 15);
        
        lblTxtTotalPendiente.setFont(contentFont);

        pnDatosCobro.add(pnDatosPendientes);
        pnDatosPendientes.setBounds(10, 435, 823, 70);

        getContentPane().add(pnDatosCobro, java.awt.BorderLayout.CENTER);

        java.awt.FlowLayout pnBotonesLayout = new java.awt.FlowLayout(java.awt.FlowLayout.LEFT);
        pnBotonesLayout.setVgap(0);
        pnBotonesLayout.setVgap(0);
        pnBotones.setLayout(pnBotonesLayout);
        
        pnBotones.setBorder(new javax.swing.border.EtchedBorder() );
        pnBotones.setForeground(new java.awt.Color(255, 255, 255));

        //--INICIO CONFIGURACION BOTONES PIE VENTANA----------------------------
        //PropertiesApplet.setProperties(ConstantesBundlesApplet.APPLET_BUTTONS_BUNDLE);
        
        this.btnGuardar.setBackground(new java.awt.Color(5, 123, 162));
        this.btnGuardar.setForeground(new java.awt.Color(255, 255, 255));
        this.btnGuardar.setText(PropertiesApplet.getPropertie(ConstantesBotones.BUTTON_GUARDAR, ConstantesBundlesApplet.APPLET_BUTTONS_BUNDLE));        
        pnBotones.add(this.btnGuardar);
        
        btnCambiosVentas.setBackground(new java.awt.Color(5, 123, 162));
        btnCambiosVentas.setForeground(new java.awt.Color(255, 255, 255));
        btnCambiosVentas.setText(PropertiesApplet.getPropertie(ConstantesBotones.BUTTON_CAMBIOS_Y_VENTAS, ConstantesBundlesApplet.APPLET_BUTTONS_BUNDLE));        
        pnBotones.add(btnCambiosVentas);

        btnNotasPendientes.setBackground(new java.awt.Color(5, 123, 162));
        btnNotasPendientes.setForeground(new java.awt.Color(255, 255, 255));
        btnNotasPendientes.setText(PropertiesApplet.getPropertie(ConstantesBotones.BUTTON_NOTAS_CREDITOS_PEND, ConstantesBundlesApplet.APPLET_BUTTONS_BUNDLE));
        pnBotones.add(btnNotasPendientes);
        
        this.btnCerrar.setBackground(new java.awt.Color(5, 123, 162));
        this.btnCerrar.setForeground(new java.awt.Color(255, 255, 255));
        this.btnCerrar.setText(PropertiesApplet.getPropertie(ConstantesBotones.BUTTON_SALIR,ConstantesBundlesApplet.APPLET_BUTTONS_BUNDLE));
        
        pnBotones.add(this.btnCerrar);
        
        getContentPane().add(pnBotones, java.awt.BorderLayout.SOUTH);

        pack();
        
        
        
    }//GEN-END:initComponents
    
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                //CobrarBelcenter cb = new CobrarBelcenter();
                //cb.setVisible(true);
                //cb.setSize(850, 620);
                //cb.validate();
            }
        });
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAnyadir;
    private javax.swing.JButton btnCambiosVentas;
    private javax.swing.JButton btnCerrar;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnModificar;
    private javax.swing.JButton btnNotasPendientes;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JLabel lblAcceso;
    private javax.swing.JLabel lblCaja;
    private javax.swing.JLabel lblCanal;
    private javax.swing.JLabel lblCodCliente;
    private javax.swing.JLabel lblDivisa;
    private javax.swing.JLabel lblFecha;
    private javax.swing.JLabel lblImporte;
    private javax.swing.JLabel lblImporteAPagarEnDivisa;
    private javax.swing.JLabel lblNConsolidado;
    private javax.swing.JLabel lblNombreCliente;
    private javax.swing.JLabel lblSubacceso;
    private javax.swing.JLabel lblTotalPagado;
    private javax.swing.JLabel lblTotalPendiente;
    private javax.swing.JLabel lblTxtAcceso;
    private javax.swing.JLabel lblTxtCaja;
    private javax.swing.JLabel lblTxtCanal;
    private javax.swing.JLabel lblTxtCodCliente;
    private javax.swing.JLabel lblTxtDivisa;
    private javax.swing.JLabel lblTxtFecha;
    private javax.swing.JLabel lblTxtImporteAPagar;
    private javax.swing.JLabel lblTxtImporteAPagarEnDivisa;
    private javax.swing.JLabel lblTxtNConsolidado;
    private javax.swing.JLabel lblTxtNombreCliente;
    private javax.swing.JLabel lblTxtSubacceso;
    javax.swing.JLabel lblTxtTotalPagado;
    javax.swing.JLabel lblTxtTotalPendiente;
    private javax.swing.JPanel pnBotones;
    private javax.swing.JPanel pnBotonesTabla;
    private javax.swing.JPanel pnCobrarBelcenterCabecera;
    private javax.swing.JPanel pnDatosCobro;
    private javax.swing.JPanel pnDatosDetalle;
    private javax.swing.JPanel pnDatosPendientes;
    private TablaCobrarBelcenter tablaDetalle;
  private DTOCargaCobroBelcenter cargaCobro;
  private Long oidSubacceso;
  private DTOCobroBelcenter dtoCobroBelcenter;
  private BigDecimal totalPagado;
  private BigDecimal totalPendiente;
  private BigDecimal importePagar;
  private BigDecimal montoMaximoDiferencia;
  private Long oidTipoMovimientoCobrar;
  private Long oidCaja;
  private Long oidSolicitudCabecera;
  private Long oidCanal;
  private Long oidAcceso;
  private Long oidCliente;
  private Long numeroSolicitud;
  private Long oidPais;
  private Long oidMedioPago;
  private Long oidMoneda;
  private Long oidBanco;
  private Long oidTipoTarjeta;
  private Long oidSolicitudNotaCredito;
  private ArrayList movimientosCaja;
  private DetalleCobroDevolucion fila;
  private String idUsuario;
  private DatosCobro datosCobro;
  private Long oidIdioma;
  private boolean cancelar = true;

  private JScrollPane spTablaDetalle;
  
  public void setCancelar(boolean b) {
    this.cancelar = b;
  }
  
  public boolean getCancelar() {
    return this.cancelar;
  }

  public Long getOidSubacceso()
  {
    return oidSubacceso;
  }

  public void setOidSubacceso(Long oidSubacceso)
  {
    this.oidSubacceso = oidSubacceso;
  }

  public DTOCobroBelcenter getDtoCobroBelcenter()
  {
    return dtoCobroBelcenter;
  }

  public void setDtoCobroBelcenter(DTOCobroBelcenter dtoCobroBelcenter)
  {
    this.dtoCobroBelcenter = dtoCobroBelcenter;
  }

  public BigDecimal getTotalPagado()
  {
    return totalPagado;
  }

  public void setTotalPagado(BigDecimal totalPagado)
  {
    this.totalPagado = totalPagado;
  }

  public BigDecimal getTotalPendiente()
  {
    return totalPendiente;
  }

  public void setTotalPendiente(BigDecimal totalPendiente)
  {
    this.totalPendiente = totalPendiente;
  }

  public BigDecimal getImportePagar()
  {
    return importePagar;
  }

  public void setImportePagar(BigDecimal importePagar)
  {
    this.importePagar = importePagar;
  }

  public BigDecimal getMontoMaximoDiferencia()
  {
    return montoMaximoDiferencia;
  }

  public void setMontoMaximoDiferencia(BigDecimal montoMaximoDiferencia)
  {
    this.montoMaximoDiferencia = montoMaximoDiferencia;
  }

  public Long getOidTipoMovimientoCobrar()
  {
    return oidTipoMovimientoCobrar;
  }

  public void setOidTipoMovimientoCobrar(Long oidTipoMovimientoCobrar)
  {
    this.oidTipoMovimientoCobrar = oidTipoMovimientoCobrar;
  }

  public Long getOidCaja()
  {
    return oidCaja;
  }

  public void setOidCaja(Long oidCaja)
  {
    this.oidCaja = oidCaja;
  }

  public Long getOidSolicitudCabecera()
  {
    return oidSolicitudCabecera;
  }

  public void setOidSolicitudCabecera(Long oidSolicitudCabecera)
  {
    this.oidSolicitudCabecera = oidSolicitudCabecera;
  }

  public Long getOidCanal()
  {
    return oidCanal;
  }

  public void setOidCanal(Long oidCanal)
  {
    this.oidCanal = oidCanal;
  }

  public Long getOidAcceso()
  {
    return oidAcceso;
  }

  public void setOidAcceso(Long oidAcceso)
  {
    this.oidAcceso = oidAcceso;
  }

  public Long getOidCliente()
  {
    return oidCliente;
  }

  public void setOidCliente(Long oidCliente)
  {
    this.oidCliente = oidCliente;
  }

  public Long getNumeroSolicitud()
  {
    return numeroSolicitud;
  }

  public void setNumeroSolicitud(Long numeroSolicitud)
  {
    this.numeroSolicitud = numeroSolicitud;
  }

  public Long getOidPais()
  {
    return oidPais;
  }

  public void setOidPais(Long oidPais)
  {
    this.oidPais = oidPais;
  }

  public Long getOidMedioPago()
  {
    return oidMedioPago;
  }

  public void setOidMedioPago(Long oidMedioPago)
  {
    this.oidMedioPago = oidMedioPago;
  }

  public Long getOidMoneda()
  {
    return oidMoneda;
  }

  public void setOidMoneda(Long oidMoneda)
  {
    this.oidMoneda = oidMoneda;
  }

  public Long getOidBanco()
  {
    return oidBanco;
  }

  public void setOidBanco(Long oidBanco)
  {
    this.oidBanco = oidBanco;
  }

  public Long getOidTipoTarjeta()
  {
    return oidTipoTarjeta;
  }

  public void setOidTipoTarjeta(Long oidTipoTarjeta)
  {
    this.oidTipoTarjeta = oidTipoTarjeta;
  }

  public Long getOidSolicitudNotaCredito()
  {
    return oidSolicitudNotaCredito;
  }

  public void setOidSolicitudNotaCredito(Long oidSolicitudNotaCredito)
  {
    this.oidSolicitudNotaCredito = oidSolicitudNotaCredito;
  }

  public ArrayList getMovimientosCaja()
  {
    return movimientosCaja;
  }

  public void setMovimientosCaja(ArrayList movimientosCaja)
  {
    this.movimientosCaja = movimientosCaja;
  }

  public DetalleCobroDevolucion getFila()
  {
    return fila;
  }

  public void setFila(DetalleCobroDevolucion fila)
  {
    this.fila = fila;
  }
  
  public String getIdUsuario(){
    return idUsuario;
  }
  
  public void setIdUsuario(String idUsuario){
    this.idUsuario = idUsuario;
  }
  
  public DTOCargaCobroBelcenter getCargaCobro(){
    return cargaCobro;
  }
  
  public void setCargaCobro(DTOCargaCobroBelcenter cargaCobro){
    this.cargaCobro = cargaCobro;
  }
  
  public DatosCobro getDatosCobro(){
    if(datosCobro==null){
      datosCobro = new DatosCobro(this.cobrarBelcenter);
    }
    return datosCobro;
  }
  
  public void setDatosCobro(DatosCobro datosCobro){
    this.datosCobro = datosCobro;
  }
  
  public TablaCobrarBelcenter getTablaDetalle(){
    return this.tablaDetalle;
  }
  
  /*public void setTablaDetalle(TablaCobrarBelcenter tablaDetalle){
    this.tablaDetalle = tablaDetalle;
  }*/
  
    // End of variables declaration//GEN-END:variables
    
  public JLabel getLblTxtCanal(){
    return this.lblTxtCanal;
  }
  
  public JLabel getLblTxtAcceso(){
    return this.lblTxtAcceso;
  }
  
  public JLabel getLblTxtSubacceso(){
    return this.lblTxtSubacceso;
  }
  
  public JLabel getLblTxtCaja(){
    return this.lblTxtCaja;
  }
  
  public JLabel getLblTxtCodCliente(){
    return this.lblTxtCodCliente;
  }
  
  public JLabel getLblTxtNombreCliente(){
    return this.lblTxtNombreCliente;
  }
  
  public JLabel getLblTxtNConsolidado(){
    return this.lblTxtNConsolidado;
  }
  
  public JLabel getLblTxtFecha(){
    return this.lblTxtFecha;
  }
  
  public JLabel getLblTxtImporteAPagar(){
    return this.lblTxtImporteAPagar;
  }
  
  public JLabel getLblTxtDivisa(){
    return this.lblTxtDivisa;
  }
  
  public JLabel getLblTxtImporteAPagarEnDivisa(){
    return this.lblTxtImporteAPagarEnDivisa;
  }

  public JLabel getLblTxtTotalPagado(){
    return this.lblTxtTotalPagado;
  }
  
  public JLabel getLblTxtTotalPendiente(){
    return this.lblTxtTotalPendiente;
  }
  
  public Long getOidIdioma(){
    return this.oidIdioma;
  }
  
  public void setOidIdioma(Long oidIdioma){
    this.oidIdioma = oidIdioma;
  }
  
  private void cerrar() { 
    this.close();
    this.setVisible(false);
  }
  
  public void aniadirFila(DetalleCobroDevolucion fila) {
    //TablaCobrarBelcenter tabla = this.frameCobrarBelcenter.getTablaDetalle();
    //System.out.println("borro filas vacias");
    this.tablaDetalle.deleteEmptyRows();
    //this.frameCobrarBelcenter.getTablaDetalle().newRow();
    //System.out.println("agregue una");
    int posicion = this.tablaDetalle.getRowCount();
    this.tablaDetalle.newRow();
    
    this.tablaDetalle.colBanco.setText(fila.getBanco()!=null?fila.getBanco():"", posicion);
    
    
    //REDONDEAR 
    this.tablaDetalle.colImporte.setText(
        fila.getImporte()!=null
        ? fila.getImporte().setScale(2,BigDecimal.ROUND_HALF_EVEN).toString()
        : ""
        , posicion);
    
    this.tablaDetalle.colImporteDivisa.setText(
        fila.getImporteDivisa()!=null
        ? fila.getImporteDivisa().setScale(2,BigDecimal.ROUND_HALF_EVEN).toString()
        : ""
        , posicion);
    
    this.tablaDetalle.colMedioPago.setText(fila.getMedioPago()!=null?fila.getMedioPago():"", posicion);
    this.tablaDetalle.colMoneda.setText(fila.getMoneda()!=null?fila.getMoneda():"", posicion);
    this.tablaDetalle.colNCheque.setText(fila.getNumeroCheque()!=null?fila.getNumeroCheque():"", posicion);
    this.tablaDetalle.colNTarjeta.setText(fila.getNumeroTarjeta()!=null?fila.getNumeroTarjeta():"", posicion);
    this.tablaDetalle.colNValeCompra.setText(fila.getNumeroValeCompra()!=null?fila.getNumeroValeCompra():"", posicion);
    this.tablaDetalle.colTipoCambio.setText(fila.getTipoCambio()!=null?fila.getTipoCambio():"", posicion);
    this.tablaDetalle.colTipoTarjeta.setText(fila.getTipoTarjeta()!=null?fila.getTipoTarjeta():"", posicion);
    this.tablaDetalle.colNConsolidado.setText(fila.getNumeroNotaCredito()!=null?fila.getNumeroNotaCredito():"", posicion);
    
    //System.out.println("posicion: " + posicion);
    //System.out.println("texto banco: " + this.tablaDetalle.colBanco.getText(posicion));
    //System.out.println("texto importe: " + this.tablaDetalle.colImporte.getText(posicion));
  }
  
  // Este método se llama al cerrar la ventana CobrarBelcenter 
  private void close() {
    if(this.cancelar == true ) { 
      // Se continua con la facturación 
      DTOContinuarFacturacion dto = new DTOContinuarFacturacion();
      dto.setOidConsolidado( oidSolicitudCabecera );
      dto.setEstado(Boolean.FALSE);

      // Obtiene la información del stock del producto 
      try {
        Communicator com = new Communicator();
        com.ejecutarNegocio(this.cobrarBelcenter.getUrl(),
                                                  "BELContinuarFacturacion" , 
                                                  "es.indra.sicc.dtos.bel.DTOContinuarFacturacion",
                                                  dto);        
      } catch (AppletException e) {
        UtilApplet.procesarError(e, this);
      }
    }

  }
}
