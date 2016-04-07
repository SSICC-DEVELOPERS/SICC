/*
 * FrameBuscarProducto.java
 *
 * Created on 15 de febrero de 2005, 18:12
 */

package es.indra.sicc.ped.applet.componentes;

import es.indra.mare.common.dto.MareDTO;
import es.indra.sicc.comunapplet.Dialogos;
import es.indra.sicc.comunapplet.UtilApplet;
import es.indra.sicc.comunapplet.dtos.applet.DTOPaginacionClientePesado;
import es.indra.sicc.dtos.ped.DTOCabeceraSolicitud;
import es.indra.sicc.dtos.ped.applet.DTOCargaPantallaBusqueda;
//import es.indra.sicc.logicanegocio.ped.applet.DTOServlet;
import es.indra.sicc.ped.applet.RegistroCache;
import es.indra.sicc.ped.applet.RegistroOnlineApplet;
import es.indra.sicc.comunapplet.exceptions.AppletException;
import es.indra.sicc.util.DTOBelcorp;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.KeyEvent;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.border.EtchedBorder;  


import es.indra.sicc.comunapplet.ComboBoxApplet;

import es.indra.sicc.dtos.ped.applet.DTOBuscarProductosRegistro;
import es.indra.sicc.util.DTOSalida;

//import es.indra.mare.common.mii.services.jdbcservice.RecordSet;

//import java.math.BigDecimal;



import es.indra.sicc.comunapplet.ConstantesApplet;
import es.indra.sicc.comunapplet.PaginacionClientePesado;

/**
 *
 * @author  jpbosnja
 */
public class FrameBuscarProducto extends PaginacionClientePesado {
    
    private RegistroOnlineApplet applet = null;
    
    private String         sTitle                 = null;
    
    private ComboBoxApplet cbCatalogo             = new ComboBoxApplet();
    private ComboBoxApplet cbLineaProducto        = new ComboBoxApplet();
    private JPanel         pnCriteriosDeBusqueda  = new JPanel();
    private JPanel         pnBuscar               = new JPanel();
    private JPanel         pnResultados           = new JPanel();
    private JPanel         pnResultadosBusqueda   = new JPanel();
    private JPanel         pnGrillaResultados     = new JPanel();
    private JScrollPane    spGrillaResultados     = new JScrollPane();
    private JPanel         jPanel2;
    private JLabel         lbCatalogo             = new JLabel();
    private JLabel         lbDescripcionCorta     = new JLabel();
    private JLabel         lbDescripcionLarga     = new JLabel();
    private JLabel         lbLineaProducto        = new JLabel();
    private JLabel         lbPagina               = new JLabel();
    private JLabel         lbPrecioCatalogoDesde  = new JLabel();
    private JLabel         lbPrecioCatalogoHasta  = new JLabel();
    private JLabel         lbResultadosBusqueda   = new JLabel();
    private JTextField     txtDescCorta           = new JTextField();
    private JTextField     txtDescLarga           = new JTextField();
    private JTextField     txtPagina              = new JTextField();
    private JTextField     txtPrecioCatalogoDesde = new JTextField();
    private JTextField     txtPrecioCatalogoHasta = new JTextField();
    private JButton        coBuscar               = new JButton();

    private JPanel         pnAceptar               = new JPanel();
    private JButton        coAceptar               = new JButton();
    private JButton        coCerrar               = new JButton();


    public TablaResultado  tablaResultado         = new TablaResultado();
    


    public FrameBuscarProducto(String sTitle, RegistroOnlineApplet applet){
      this(sTitle);
      this.applet = applet;
      //this.cargaInicial();
      this.inicializar(new DTOPaginacionClientePesado());
    }
    
    private FrameBuscarProducto( String sTitle ) {
        this.sTitle = sTitle;
        try {
          initComponents();
        } catch ( Exception e ) {
          e.printStackTrace();
        }
        //setSize( new Dimension( 690, 495 ) );
        setSize( new Dimension( 690, 530 ) );
        
        setResizable( false );
        
        getContentPane().setBackground(new Color(242,242,241));
    }
    
    
    
    private void initComponents() throws Exception {
        super.jbInit();
        getContentPane().setLayout( null );
        setTitle( this.sTitle );
      
        pnCriteriosDeBusqueda.setLayout(null);
        pnCriteriosDeBusqueda.setBorder(new javax.swing.border.TitledBorder(new EtchedBorder(),"Criterios de búsqueda"));
        
        cbCatalogo.setEditable( true );
        cbCatalogo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbCatalogoActionPerformed(evt);
            }
        });

        coBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buscar();
            }
        });

        coAceptar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                aceptar();
            }
        });
        
        coCerrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cerrar();
            }
        });

        pnCriteriosDeBusqueda.add(cbCatalogo);
        cbCatalogo.setBounds(20, 41, 180, 21);

        cbLineaProducto.setEditable( true );
        pnCriteriosDeBusqueda.add( cbLineaProducto );
        cbLineaProducto.setBounds(320, 41, 190, 21);

        pnCriteriosDeBusqueda.add(txtPagina);
        txtPagina.setBounds(220, 41, 70, 21);

        lbCatalogo.setFont( new Font("Dialog", 1, 11) );
        lbCatalogo.setText("Catálogo");
        pnCriteriosDeBusqueda.add(lbCatalogo);
        lbCatalogo.setBounds(20, 25, 80, 15);

        lbPagina.setFont( new Font("Dialog", 1, 11) );
        lbPagina.setText("Página");
        pnCriteriosDeBusqueda.add(lbPagina);
        lbPagina.setBounds(220, 25, 50, 15);

        lbLineaProducto.setFont( new Font("Dialog", 1, 11) );
        lbLineaProducto.setText("Línea producto");
        pnCriteriosDeBusqueda.add(lbLineaProducto);
        lbLineaProducto.setBounds(320, 25, 90, 15);

        lbPrecioCatalogoDesde.setFont( new Font("Dialog", 1, 11) );
        lbPrecioCatalogoDesde.setText("Precio catálogo desde");
        pnCriteriosDeBusqueda.add(lbPrecioCatalogoDesde);
        lbPrecioCatalogoDesde.setBounds(20, 76, 130, 15);

        lbPrecioCatalogoHasta.setFont( new Font("Dialog", 1, 11) );
        lbPrecioCatalogoHasta.setText("Precio catálogo hasta");
        pnCriteriosDeBusqueda.add(lbPrecioCatalogoHasta);
        lbPrecioCatalogoHasta.setBounds(170, 76, 130, 15);

        lbDescripcionCorta.setFont( new Font("Dialog", 1, 11) );
        lbDescripcionCorta.setText("Descripción corta");
        pnCriteriosDeBusqueda.add(lbDescripcionCorta);
        lbDescripcionCorta.setBounds(20, 125, 110, 15);

        lbDescripcionLarga.setFont( new Font("Dialog", 1, 11) );
        lbDescripcionLarga.setText("Descripción larga");
        pnCriteriosDeBusqueda.add(lbDescripcionLarga);
        lbDescripcionLarga.setBounds(290, 125, 100, 15);

        pnCriteriosDeBusqueda.add(txtPrecioCatalogoDesde);
        txtPrecioCatalogoDesde.setBounds(20, 93, 120, 21);

        txtPrecioCatalogoHasta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPrecioCatalogoHastaActionPerformed(evt);
            }
        });

        pnCriteriosDeBusqueda.add(txtPrecioCatalogoHasta);
        txtPrecioCatalogoHasta.setBounds(170, 93, 120, 21);

        pnCriteriosDeBusqueda.add(txtDescCorta);
        txtDescCorta.setBounds(20, 141, 220, 21);

        pnCriteriosDeBusqueda.add(txtDescLarga);
        txtDescLarga.setBounds(290, 141, 270, 21);

        pnCriteriosDeBusqueda.setBackground( new Color(242,242,241) );
        getContentPane().add( pnCriteriosDeBusqueda );
        pnCriteriosDeBusqueda.setBounds(4, 5, 675, 180);
        
        //--------
        pnBuscar.setLayout( null );
        coBuscar.setBackground( new Color(5, 123, 162) );
        coBuscar.setForeground( new Color (255, 255, 255) );
        coBuscar.setFont( new Font ( "Dialog", 1, 11 ) );
        coBuscar.setText( "Buscar" );
        coBuscar.setMnemonic( KeyEvent.VK_B );
        pnBuscar.add( coBuscar );
        coBuscar.setBounds( 0, 0, 80, 29 );
        
        pnBuscar.setBorder( new EtchedBorder() );
        getContentPane().add( pnBuscar );
        pnBuscar.setBounds(6, 200, 671, 29);
        //-------------
        
        pnResultados.setLayout( null );
        pnResultadosBusqueda.setLayout( null );
        pnGrillaResultados.setLayout( null );

        lbResultadosBusqueda.setFont( new Font("Dialog", 1, 11) );
        lbResultadosBusqueda.setText("Resultado de búsqueda");
        pnResultadosBusqueda.add( lbResultadosBusqueda );
        lbResultadosBusqueda.setBounds(5, 6, 130, 15);
        
        pnResultadosBusqueda.setBorder( new EtchedBorder() );
        pnResultados.add( pnResultadosBusqueda );
        pnResultadosBusqueda.setBounds(0, 0, 670, 29);
        
        spGrillaResultados.setHorizontalScrollBarPolicy( JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS );
        spGrillaResultados.setVerticalScrollBarPolicy( JScrollPane.VERTICAL_SCROLLBAR_ALWAYS );
        spGrillaResultados.getViewport().add( tablaResultado );
        pnGrillaResultados.add( spGrillaResultados );
        spGrillaResultados.setBounds(0, 0, 670, 190 );
        
        pnGrillaResultados.setBorder( new EtchedBorder() );
        pnResultados.add( pnGrillaResultados );
        pnGrillaResultados.setBounds(0, 30, 670, 190 );
        
        getContentPane().add( pnResultados );
        pnResultados.setBounds(6, 240, 670, 220);
        
        //--------agregado
        pnAceptar.setLayout( null );
        coAceptar.setBackground( new Color(5, 123, 162) );
        coAceptar.setForeground( new Color (255, 255, 255) );
        coAceptar.setFont( new Font ( "Dialog", 1, 11 ) );
        coAceptar.setText( "Aceptar" );
        coAceptar.setMnemonic( KeyEvent.VK_A );
        pnAceptar.add( coAceptar );
        //coAceptar.setBounds( 0, 0, 75, 29 );
        coAceptar.setBounds( 0, 0, 80, 29 );
        
        coCerrar.setBackground( new Color(5, 123, 162) );
        coCerrar.setForeground( new Color (255, 255, 255) );
        coCerrar.setFont( new Font ( "Dialog", 1, 11 ) );
        coCerrar.setText( "Cerrar" );
        coCerrar.setMnemonic( KeyEvent.VK_C );
        pnAceptar.add( coCerrar );
        //coAceptar.setBounds( 0, 0, 75, 29 );
        coCerrar.setBounds( 81, 0, 80, 29 );
        
        pnAceptar.add( this.btnAdelante );
        pnAceptar.add( this.btnAtras );
        pnAceptar.add( this.btnInicio );
        super.btnAdelante.setBounds( 80 * 2, 0, 80, 29 );
        super.btnAtras.setBounds( 80 * 3, 0, 80, 29 );
        super.btnInicio.setBounds( 80 * 4, 0, 80, 29 );
        
        pnAceptar.setBorder( new EtchedBorder() );
        getContentPane().add( pnAceptar );
        //pnAceptar.setBounds(6, 185, 671, 29);
        pnAceptar.setBounds(6, 470, 671, 29);
        //-------------
        
        
        pack();
    }

    private void txtPrecioCatalogoHastaActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
    }

    private void cmbCatalogoActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
    }
    
    public void cargaInicial() {
      
      //if(this.applet == null) {
        DTOBelcorp dto = new DTOBelcorp();
        dto.setOidPais(this.applet.getOidPais());
        dto.setOidIdioma(this.applet.getOidIdioma());
        try {
          MareDTO mareDTO = this.applet.ejecutarNegocio(
                "PEDCargaBuscarProductosRegistro" , 
                "es.indra.sicc.util.DTOBelcorp",
                dto);
    
    
          if(mareDTO instanceof DTOCargaPantallaBusqueda) {
            DTOCargaPantallaBusqueda dtoPantalla = (DTOCargaPantallaBusqueda)mareDTO;
            this.applet.cargarCombo(this.cbCatalogo, dtoPantalla.getCatalogos());
            this.applet.cargarCombo(this.cbLineaProducto, dtoPantalla.getLineasProducto());        
          } else {
            Dialogos.mensajeError(ConstantesApplet.ERROR_CARGA_INICIAL, this);
          }
        } catch (AppletException e) {
          //Dialogos.mensajeError(ConstantesApplet.ERROR_CARGA_INICIAL, this);
          UtilApplet.procesarError(e, this.applet);
        }
      }
    //}
    
    private void buscar(){
    /*
      String key = "";
      
      DTOBuscarProductosRegistro dto = new DTOBuscarProductosRegistro();
      dto.setOidAlmacen(applet.getDTOCabeceraSolicitud().getAlmacen());
      
      try{
      dto.setOidCatalogo((key = cbCatalogo.getKey()) != null && !key.trim().equals("") && !key.trim().equals("-1") ? 
        new Long(key) : null);
      }catch(NumberFormatException nfe){}
      
      try{
      dto.setPagina((key = txtPagina.getText()) != null && !key.trim().equals("") ? 
        new Long(key) : null);
      }catch(NumberFormatException nfe){}
      
      try{
      dto.setOidLineaProducto((key = cbLineaProducto.getKey()) != null && 
        !key.trim().equals("") && !key.trim().equals("-1") ? new Long(key) : null);
      }catch(NumberFormatException nfe){}
      
      dto.setDescripcionLarga(!"".equals(txtDescLarga.getText().trim()) ? txtDescLarga.getText().trim() : null );
      dto.setDescripcionCorta(!"".equals(txtDescCorta.getText().trim()) ? txtDescCorta.getText().trim() : null );
      
      try{
      dto.setPrecioDesde((key = txtPrecioCatalogoDesde.getText()) != null && 
        !key.trim().equals("") ? new Long(key) : null);
      }catch(NumberFormatException nfe){}

      try{
      dto.setPrecioHasta((key = txtPrecioCatalogoHasta.getText()) != null && 
        !key.trim().equals("") ? new Long("") : null);
      }catch(NumberFormatException nfe){}
    
      DTOSalida dtos = null;
    
      // CODIGO_VENTA          (String)
      // DESCRIPCION_CORTA  (String)
      // DESCRIPCION_LARGA (String)
      // CANTIDAD                (BigDecimal)
      // PRECIO             (BigDecimal)

      MareDTO mareDTO = null;
      try{
        mareDTO = applet.ejecutarNegocio("PEDBuscarProductosRegistro", "es.indra.sicc.dtos.ped.applet.DTOBuscarProductosRegistro", dto);
      }catch(AppletException ae){
      
      }
      
      if(mareDTO instanceof DTOSalida) {
        RecordSet rs = dtos.getResultado();
              
        tablaResultado.deleteEmptyRows();
        tablaResultado.setSelectionMode( ListSelectionModel.SINGLE_INTERVAL_SELECTION );
      
        this.setPagina(rs);
      } else {
        Dialogos.mensajeError(ConstantesApplet.NO_EXISTEN_DATOS, this);
      }
*/
      this.obtenerPagina();
      
      /*
       * DBLG400000392 - dmorello, 15/03/2006
       * Se inicializará aquí y no en cargarTabla()
       */
      this.inicializar(new DTOPaginacionClientePesado());
    }
    
    private void cargarTabla() {
      if(this.getPagina() != null && !this.getPagina().esVacio()){
        String codigoVenta = null;
        String descCorta = null;
        String descLarga = null;
        String cantidad = null;
        String precio = null;
        Object val = null;
        
        /* DBLG500000736 - gpons, 13/07/2006
         * Borra las filas de la busqueda anterior
         */
        tablaResultado.deleteRows();
        
          for(int i = 0; i < this.getPagina().getRowCount(); i++){            
            codigoVenta = (String)this.getPagina().getValueAt(i, "CODIGO_VENTA");
            descCorta = (String)this.getPagina().getValueAt(i, "DESCRIPCION_CORTA");
            descLarga = (String)this.getPagina().getValueAt(i, "DESCRIPCION_LARGA");
            cantidad = (this.getPagina().getValueAt(i, "CANTIDAD") != null ? this.getPagina().getValueAt(i, "CANTIDAD").toString() : "");
            precio = (this.getPagina().getValueAt(i, "PRECIO") != null ? this.getPagina().getValueAt(i, "PRECIO").toString() : "");
  
            tablaResultado.newRow();
            tablaResultado.colCodVenta.setText(codigoVenta, i);
            tablaResultado.colDescripcionCorta.setText(descCorta, i);
            tablaResultado.colDescripcionLarga.setText(descLarga, i);
            tablaResultado.colCantidad.setText(cantidad, i);
            tablaResultado.colPrecio.setText(precio, i);
          }
          
          tablaResultado.deleteEmptyRows();
          tablaResultado.setSelectionMode( ListSelectionModel.SINGLE_INTERVAL_SELECTION ); 
          /*
           * DBLG400000392 - dmorello, 15/03/2006
           * Sólo hace falta inicializar cuando se pulsa Buscar, por lo cual
           * la llamada a inicializar() se hará sólo en buscar()
           */
          //this.inicializar(new DTOPaginacionClientePesado());
        }
    }
    
    private void aceptar(){
      int i = tablaResultado.getSelectedRow();
      
      if(i == -1){
        Dialogos.mensajeAceptar(ConstantesApplet.GEN_UIGEN0004, this);
        //Debe seleccionar al menos un elemento de la lista        
      }else{
        this.setVisible(false);
      }
    }
    
    public String getCodVenta() 
    {
      return this.tablaResultado.colCodVenta.getText(this.tablaResultado.getSelectedRow());      
    }
    
    private void cerrar() 
    {
      this.setVisible(false);
    }

  protected Long obtenerPagina(Long oidUltimo) {
  
    System.out.println("obtenerPagina(Long): entro con " + oidUltimo);
  
    DTOBuscarProductosRegistro dtoBuscarProductoRegistro = new DTOBuscarProductosRegistro();
    dtoBuscarProductoRegistro.setOidCabeceraSolicitud(this.applet.getDTOCabeceraSolicitud().getOidCabeceraSolicitud());
    if(!"".equals(this.cbCatalogo.getKey()) && !"-1".equals(this.cbCatalogo.getKey())) {
      dtoBuscarProductoRegistro.setOidCatalogo(new Long(this.cbCatalogo.getKey()));
    }
    
    try {
      dtoBuscarProductoRegistro.setPagina(new Long(this.txtPagina.getText()));
    } catch (NumberFormatException e) {
      dtoBuscarProductoRegistro.setPagina(null);
    } 
    
    if(!"".equals(this.cbLineaProducto.getKey()) && !"-1".equals(this.cbLineaProducto.getKey()) ) {
      dtoBuscarProductoRegistro.setOidLineaProducto(new Long(this.cbLineaProducto.getKey()));
    }
    
    if (!"".equals(this.txtDescLarga.getText().trim())) {
      dtoBuscarProductoRegistro.setDescripcionLarga(this.txtDescLarga.getText());
    } else {
      dtoBuscarProductoRegistro.setDescripcionLarga(null);
    }
    
    if (!"".equals(this.txtDescCorta.getText().trim())) {
      dtoBuscarProductoRegistro.setDescripcionCorta(this.txtDescCorta.getText());
    } else {
      dtoBuscarProductoRegistro.setDescripcionCorta(null);
    }
    
    try {
      dtoBuscarProductoRegistro.setPrecioDesde(new Long(this.txtPrecioCatalogoDesde.getText())); 
    } catch (NumberFormatException e) {
      dtoBuscarProductoRegistro.setPrecioDesde(null);
    }
    try {
      dtoBuscarProductoRegistro.setPrecioHasta(new Long(this.txtPrecioCatalogoHasta.getText())); 
    } catch (NumberFormatException e) {
      dtoBuscarProductoRegistro.setPrecioHasta(null);
    }
    dtoBuscarProductoRegistro.setTamanioPagina(RegistroCache.getInstance().getTamPagina());
    /*
     * DBLG400000392 - dmorello, 15/02/2006
     * Se asignará al campo indicadorSituacion el valor oidUltimo y no
     * obtenerUltimoRegistroPagina(), para adecuarse a lo indicado en el DMCO
     */
    dtoBuscarProductoRegistro.setIndicadorSituacion(oidUltimo);
    
    DTOCabeceraSolicitud dtoCabecera = this.applet.getDTOCabeceraSolicitud();
      
    dtoBuscarProductoRegistro.setAcceso(dtoCabecera.getAcceso());
    dtoBuscarProductoRegistro.setSubacceso(dtoCabecera.getSubacceso());
    dtoBuscarProductoRegistro.setPeriodo(dtoCabecera.getPeriodo());
     
    dtoBuscarProductoRegistro.setOidPais(dtoCabecera.getOidPais());
    dtoBuscarProductoRegistro.setOidIdioma(dtoCabecera.getOidIdioma());
    dtoBuscarProductoRegistro.setOidTipoSolicitud(dtoCabecera.getTipoSolicitud());
    //dtoBuscarProductoRegistro.setOidAlmacen(dtoCabecera.getAlmacen());
    
    
    
    
    
    

    try {
      MareDTO mareDTO = this.applet.ejecutarNegocio(
                            "PEDBuscarProductosRegistro" , 
                            "es.indra.sicc.dtos.ped.applet.DTOBuscarProductosRegistro",
                            dtoBuscarProductoRegistro);
                            
      if(mareDTO instanceof DTOSalida) {
        DTOSalida dtoSalida = (DTOSalida) mareDTO;
        this.setPagina(dtoSalida.getResultado());
        this.cargarTabla();
      } else {
        Dialogos.mensajeError(ConstantesApplet.NO_EXISTEN_DATOS, this);
      }
    } catch (AppletException e) {
      UtilApplet.procesarError(e, this);
    }
    // Obtiene el oid del último registro 
    oidUltimo = obtenerUltimoRegistroPagina();

    return oidUltimo;
  }

  protected Long obtenerPagina() {
    /*
     * DBLG400000392 - dmorello, 17/02/2006
     * Se pasará como parámetro al metodo llamado un Long de valor cero
     * para que siempre que se pulse Buscar, muestre los primeros resultados
     * en lugar de comportarse como si se hubiera pulsado Adelante.
     */
    return this.obtenerPagina(new Long(0));
  }    
}
