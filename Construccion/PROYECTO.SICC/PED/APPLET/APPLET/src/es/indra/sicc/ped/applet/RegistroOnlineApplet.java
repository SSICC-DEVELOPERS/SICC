package es.indra.sicc.ped.applet;

import es.indra.mare.common.dto.MareDTO;
import es.indra.sicc.comunapplet.UtilApplet;
import es.indra.sicc.comunapplet.Dialogos;
import es.indra.sicc.ped.applet.componentes.TablaDetalle;
import es.indra.sicc.comunapplet.exceptions.AppletException;
import es.indra.sicc.dtos.ped.applet.DTOCargaRegistroOnline;
import es.indra.sicc.dtos.ped.applet.DTODatosCliente;
import es.indra.sicc.dtos.ped.applet.DTODatosCombo;
import es.indra.sicc.dtos.ped.applet.DTOTiposSolicitud;
import es.indra.sicc.dtos.ped.DTOCabeceraSolicitud;
import es.indra.sicc.dtos.ped.DTOValoresDefecto;
import es.indra.sicc.logicanegocio.ped.ConstantesPED;
import es.indra.sicc.logicanegocio.ped.ConstantesValoresDefecto;
import es.indra.sicc.comunapplet.ComboBoxApplet;
import es.indra.sicc.ped.applet.RegistroOnline;
import es.indra.sicc.comunapplet.Communicator;
import es.indra.sicc.comunapplet.ConstantesApplet;

import java.net.URL;
import java.text.SimpleDateFormat;

import javax.swing.ButtonModel;
import netscape.javascript.JSObject;

public class RegistroOnlineApplet extends RegistroOnline {
    private Boolean accesoFisicoObligatorio = null;
    protected DTODatosCliente dtoDatosCliente = null;
    protected String destinoDefecto = null;
    
    protected DTOCabeceraSolicitud dtoCabeceraSolicitud;
      /*
     * //Buscar los parametros recibido en la pagina 
       Se llama al metodo cargarDatosIniciales 
     */
    protected void registroOnline_onload() throws AppletException {
        //System.out.println("Entro al init");
        this.pestaniaCabeceraImplementacion = new Cabecera(this);
        this.marcoCliente = new Cliente(this);
        this.marcoDatosDetalle = new DatosDetalle(this);
        //System.out.println("Code: " + this.getCodeBase() ); 
        try {
            if (this.getParameter("url")!=null && !this.getParameter("url").equals("")){
                url = this.getParameter("url");
                String auxURL = this.getCodeBase().toString();
                //auxURL = auxURL.substring(0, auxURL.indexOf("sicc/") + "sicc/".length());
                auxURL = auxURL.substring(0, auxURL.indexOf("/sicc") + 1);
                System.out.println("AUXURL: "+auxURL);
                this.url = auxURL + this.url;
                System.out.println("url: " + url);                
            } else {
              Dialogos.mensajeError(ConstantesApplet.ERROR_FALTA_PARAMETRO_OBLIGATORIO_URL, this);
              //System.exit(0);
              this.deshabilitarTodo();
            }
            if (this.getParameter("oidPais")!=null && !this.getParameter("oidPais").equals("")){
                oidPais = new Long(this.getParameter("oidPais"));
                //System.out.println("Pais: "+oidPais);                
            } else {
              Dialogos.mensajeError(ConstantesApplet.ERROR_FALTA_PARAMETRO_OBLIGATORIO_PAIS, this);
              //System.exit(0);
              this.deshabilitarTodo();
            }
          if (this.getParameter("fechaSistema")!=null){
                fechaSistema = this.getParameter("fechaSistema");
                //System.out.println("Fecha Sistema: "+fechaSistema);
                //Mostrar error
            }
          if (this.getParameter("user")!=null){
                user = this.getParameter("user");
                //System.out.println("user: " + user);                
            }
            if (this.getParameter("oidCliente")!=null && !this.getParameter("oidCliente").equals("")){
                oidCliente = new Long(this.getParameter("oidCliente"));
                //System.out.println("Cliente: "+oidCliente);
            }
            if (this.getParameter("oidTipoCliente")!=null && !this.getParameter("oidTipoCliente").equals("")){
                oidTipoCliente = new Long(this.getParameter("oidTipoCliente"));
                //System.out.println("Tipo Cliente: "+oidTipoCliente);
            }
            if (this.getParameter("oidTipoSolicitud")!=null && !this.getParameter("oidTipoSolicitud").equals("")){
                oidTipoSolicitud = new Long(this.getParameter("oidTipoSolicitud"));
                //System.out.println("Tipo Solicitud: "+oidTipoSolicitud);
            }
            if (this.getParameter("belcenter")!=null && !this.getParameter("belcenter").equals("")){
                if (cache == null) {
                  this.cache = RegistroCache.getInstance();
                }
                this.cache.setBelcenter(new Boolean(this.getParameter("belcenter")));
                //System.out.println("Belcenter: "+ this.getParameter("belcenter"));
            }
            if (this.getParameter("oidIdioma")!=null && !this.getParameter("oidIdioma").equals("")){
                this.oidIdioma = new Long(this.getParameter("oidIdioma"));
                System.out.println("oidIdioma: "+ this.oidIdioma);
            }
            if (this.getParameter("ip")!=null && !this.getParameter("ip").equals("")){
                this.ip = this.getParameter("ip");
                //System.out.println("ip: "+ this.ip);
            }
            if (this.getParameter("oidAcceso")!=null && !this.getParameter("oidAcceso").equals("")){
                this.oidAcceso = new Long(this.getParameter("oidAcceso"));
                //System.out.println("oidAcceso: "+ this.oidAcceso);
            }
            if (this.getParameter("oidSubacceso")!=null && !this.getParameter("oidSubacceso").equals("")){
                this.oidSubacceso = new Long(this.getParameter("oidSubacceso"));
                //System.out.println("oidSubacceso: "+ this.oidSubacceso);
            }
            if (this.getParameter("oidCanal")!=null && !this.getParameter("oidCanal").equals("")){
                this.oidCanal = new Long(this.getParameter("oidCanal"));
                //System.out.println("oidCanal: "+ this.oidCanal);
            }
            if (this.getParameter("login")!=null){
              this.urlLogin = this.getParameter("login"); 
              String aux = this.getCodeBase().toString();
              aux = aux.substring(0, aux.indexOf("sicc/") + "sicc/".length());
              this.urlLogin = aux + this.urlLogin;
              //System.out.println("pagina login: " + urlLogin);
            }
            if (this.getParameter("longitudCodigoCliente")!=null && !this.getParameter("longitudCodigoCliente").equals("")){
                this.longCodClie = Integer.parseInt(this.getParameter("longitudCodigoCliente"));
                //System.out.println("longitudCodigoCliente: "+ this.longCodClie);
            }
            /*
            url="http://192.168.118.101:7777/sicc/ServletApplet";
             oidPais = new Long(1);
             fechaSistema ="22/03/2005";
             user = "USUARIO1";
            oidCliente = new Long(1376);
            oidTipoCliente = new Long(1);
            oidTipoSolicitud = new Long(1389);
            if (cache == null) {
              this.cache = RegistroCache.getInstance();
            }
            this.cache.setBelcenter(Boolean.TRUE);  
            this.oidIdioma = new Long(1);
            this.ip = " 192.168.118.101";
            this.oidAcceso = new Long(1);
            this.oidSubacceso = new Long(8);
            this.oidCanal = new Long(1);
            */
            this.cargarDatosIniciales();
            
            this.jTabbedPane.setEnabledAt(this.jTabbedPane.indexOfComponent(this.pestaniaCabecera),true); //pestaniaCabecera.setEnabled(true);
            this.jTabbedPane.setEnabledAt(this.jTabbedPane.indexOfComponent(this.pestaniaDetalle),false);//pestaniaDetalle.setEnabled(false);
            this.jTabbedPane.setSelectedIndex(jTabbedPane.indexOfComponent(pestaniaCabecera));
      
      
        } catch(Exception e) {
            e.printStackTrace();
        }
    }
    
    protected void cargarDatosIniciales() throws AppletException{
        if (this.cache.getCargado().booleanValue() == false){
          /* se comenta segun incidencia 13178
            if (Boolean.FALSE.equals(this.cache.getBelcenter())) { 
            dtoDatosCliente = new DTODatosCliente();
            dtoDatosCliente.setOidCliente(this.oidCliente);
          } else {
            dtoDatosCliente = null;
          }*/
        
          DTOCargaRegistroOnline dtoCargaRegistroOnline = new DTOCargaRegistroOnline();
          dtoCargaRegistroOnline.setOidPais(this.oidPais);
          dtoCargaRegistroOnline.setOidIdioma(this.oidIdioma);
          dtoCargaRegistroOnline.setCodUsuario(this.user);
          dtoCargaRegistroOnline.setBelcenter(this.cache.getBelcenter());
          dtoCargaRegistroOnline.setOidAcceso(this.oidAcceso);
          dtoCargaRegistroOnline.setOidSubAcceso(this.oidSubacceso);
          dtoCargaRegistroOnline.setOidCanal(this.oidCanal);
          if (Boolean.TRUE.equals(this.cache.getBelcenter())) { 
            dtoCargaRegistroOnline.setIP(this.ip);  
          }
          //dtoCargaRegistroOnline.setDatosCliente(dtoDatosCliente);
          dtoCargaRegistroOnline.setUserName(this.user);
          MareDTO mareDTO = this.ejecutarNegocio("PEDObtenerCargaInicialRegistro", 
            "es.indra.sicc.dtos.ped.applet.DTOCargaRegistroOnline",
            dtoCargaRegistroOnline);
  
  
          if (mareDTO instanceof DTOCargaRegistroOnline) {
            DTOCargaRegistroOnline dtoR = (DTOCargaRegistroOnline) mareDTO;
            cache.setAccesosFisicos(dtoR.getAccesosFisico());
            cache.setFormaPago(dtoR.getFormasPago());
            cache.setOidSubAcceso(dtoR.getOidSubAcceso());
            cache.setPeriodos(dtoR.getPeriodos());
            cache.setTiposDespacho(dtoR.getTiposDespacho());
            cache.setTiposSolicitud(dtoR.getTiposSolicitud());
            cache.setTxtSubAcceso(dtoR.getTxtsubAcceso());
            cache.setCargado(Boolean.TRUE);     
            cache.setTamPagina(dtoR.getTamanioPagina());
            
            //17/07/2006 cdos gPineda
            cache.setFechaFacturacion( dtoR.getFechaFacturacion() );
            
          } else {            
            Dialogos.mensajeError(ConstantesApplet.ERROR_CARGA_INICIAL, this);
            return;
          }
        }
        // Se llenan los combos de la pantalla 
        this.cargarCombos();
        
        // Muestra la fecha programada de facturación 
        this.mostrarFechaFacturacion();
        
        // Seleccionar un tipo de solicitud y mostrar sus datos asociados 
        this.seleccionarTipoSolicitud();
        
        if(Boolean.FALSE.equals(this.cache.getBelcenter())) { 
          dtoDatosCliente = new DTODatosCliente();
          dtoDatosCliente.setOidCliente(this.oidCliente);
          dtoDatosCliente.setOidPais(this.oidPais);
          dtoDatosCliente.setOidIdioma(this.oidIdioma);
          dtoDatosCliente.setUserName(this.user);
          MareDTO mareDTO = ejecutarNegocio(
                "PEDObtenerDatosClienteRegistro" , 
                "es.indra.sicc.dtos.ped.applet.DTODatosCliente",
                dtoDatosCliente
                );
                
          if(mareDTO instanceof DTODatosCliente) {
            dtoDatosCliente = (DTODatosCliente)mareDTO;

            this.marcoCliente.mostrarDatosCliente();
          } else {
            Dialogos.mensajeError(ConstantesApplet.DATOS_CLIENTE_NO_EXISTENTES, this);
            return;
          }
        }
    }
    
    
    protected void cargarCombos() throws AppletException{
        if (this.cache == null) {
          Dialogos.mensajeError(ConstantesApplet.ERROR_CARGA_INICIAL, this);
          return;
        }
        
        //System.out.println("Voy a cargar Los Tipos Solicitud");
        //Incidencia 13189
        cbTipoSolicitud.removeAllItems();
        cbTipoSolicitud.addItem("-1", "");
        if (cache!=null && cache.getTiposSolicitud()!=null){
          for (int i = 0; i<cache.getTiposSolicitud().length; i++){
            
            boolean agregar = false;
          /* Ver incidencia 14373 Se comena esta parte y se cambio por el if que esta a continuacion
            Long []oids = ConstantesApplet.OIDS_ACCESO_CALLCENTER;           
            if(Boolean.TRUE.equals(this.cache.getBelcenter())) {
              for (int j = 0; j < oids.length && agregar; j++) {
                if(oids[j].equals(cache.getTiposSolicitud()[i].getOidAcceso())) {                
                  agregar = false;
                }
              }
            } else {
              for (int j = 0; j < oids.length && agregar; j++) {
                if(!oids[j].equals(cache.getTiposSolicitud()[i].getOidAcceso())) {                
                  agregar = false;
                }
              }
            }
            */            
            /******************************************************************/
            if(Boolean.TRUE.equals(this.cache.getBelcenter()) &&
              !ConstantesApplet.ACCESO_CALLCENTER.equals(cache.getTiposSolicitud()[i].getCodAcceso())) {
                 agregar = true;
            } else if(Boolean.FALSE.equals(this.cache.getBelcenter()) &&
              ConstantesApplet.ACCESO_CALLCENTER.equals(cache.getTiposSolicitud()[i].getCodAcceso())) {
                 agregar = true;
            }
            /******************************************************************/
            
            if(agregar) {
               cbTipoSolicitud.addItem(
                    cache.getTiposSolicitud()[i].getOidTipoSolicitud().toString(),
                    cache.getTiposSolicitud()[i].getTipoSolicitud());
            }
          }
        }
        
        //System.out.println("Voy a cargar Los Accesos Fisicos");
        this.cargarCombo(this.cbAccesoFisico, cache.getAccesosFisicos());            
        
        //System.out.println("Voy a cargar Los Periodos");
        this.cargarCombo(this.cbPeriodo, cache.getPeriodos());
        this.seleccionarPeriodo();
                    
        //System.out.println("Voy a cargar Las Formas de Pago");
        this.cargarCombo(this.cbFormaPago, cache.getFormaPago());
        
        //System.out.println("Voy a cargar Los Tipo Despacho");
        this.cargarCombo(this.cbTipoDespacho, cache.getTiposDespacho());
    }

    public MareDTO ejecutarNegocio(String idBusiness, String nombreDTO, MareDTO dto ) throws AppletException {      
      Communicator comunicator = new Communicator();
    
      MareDTO mareDTO = comunicator.ejecutarNegocio(this.url, idBusiness, nombreDTO, dto);
      if(mareDTO instanceof es.indra.sicc.comunapplet.dtos.applet.DTOSessionExpired) {
        try {
          //System.out.println("se redirecciona a la url: " + urlLogin);
          URL _url = new URL( urlLogin );
          getAppletContext().showDocument( _url );   
        } catch (Exception e) {
          e.printStackTrace();
        }
        //return;
      }
      return mareDTO;
    }

  
   public Object ejecutarWeb(String nombreFuncionJS, String url) throws AppletException {
      //System.out.println("Se llamo a ejecutarWeb con nombre Funcion JS: " + nombreFuncionJS);
      JSObject win = JSObject.getWindow(this);
      Object obj = null;
      obj = win.eval(nombreFuncionJS + "(" + url + ")");
      //System.out.println("Se llamo termino la ejecucion de ejecutarWeb");
      return obj;
    }
    
    protected void ejecutarJava() throws AppletException {
      //No esta implementado
      System.out.println("Se llamo a ejecutarJava");
    }
    
    // Muestra el detalle de una solicitud y protege los datos de la cabecera 
    protected void mostrarDetalle() throws AppletException {
      this.jTabbedPane.setEnabledAt(jTabbedPane.indexOfComponent(pestaniaCabecera),true); //pestaniaCabecera.setEnabled(true);
      this.jTabbedPane.setEnabledAt(jTabbedPane.indexOfComponent(pestaniaDetalle),true);//pestaniaDetalle.setEnabled(false);

      //Desactiva componentes de la pestaña cabecera
      this.btnAltaCliente.setEnabled(false);
      for (int i=0; i < this.TipoSolicitud.getComponentCount(); i++)
            this.TipoSolicitud.getComponent(i).setEnabled(false);
      for (int i=0; i < this.pnDatosSolicitud.getComponentCount(); i++)
            this.pnDatosSolicitud.getComponent(i).setEnabled(false);
      for (int i=0; i < this.Cliente.getComponentCount(); i++)
            this.Cliente.getComponent(i).setEnabled(false);
      for (int i=0; i < this.pnAceptarCancelar.getComponentCount(); i++)
            this.pnAceptarCancelar.getComponent(i).setEnabled(false);

      this.jTabbedPane.setSelectedIndex(jTabbedPane.indexOfComponent(pestaniaDetalle));
      
      this.lbCodClienteDetalle.setText(this.txtCodCliente.getText());
      this.lbNombreDetalle.setText(this.lbNombre.getText()); 
      this.lbApellidosDetalle.setText(this.lbApellidos.getText());
      this.lbLineaDispDetalle.setText(this.lbLineaDisp.getText()); 
      this.lbFormaPagoDetalle.setText((String)this.cbFormaPago.getItemAt(this.cbFormaPago.getSelectedIndex()));

      // valor por default = 1
      this.txtUnidDemandadas.setText(new Long(1).toString());


      //if (ConstantesPED.CV.equals(this.chkIndCodigoVentaProducto.getText()) ) {// V 
      if (this.rbIndCodigVentaCV.isSelected()) {
        //ConstantesPED.CV.equals(this.valueIndCodigVenta) ) {// V //this.rbIndCodigVentaCV.isSelected()
        this.txtCodVenta.requestFocus(); 
        this.txtCodProducto.setEnabled(false);
      }  else { 
        this.txtCodProducto.requestFocus(); 
        this.txtCodVenta.setEnabled(false);
      } 
    }
    
    protected void seleccionarTipoSolicitud() throws AppletException {
      if(Boolean.TRUE.equals(this.cache.getBelcenter() )) {// Belcenter 
        this.cbTipoSolicitud.setEnabled(true);
        // Obtiene de sesión la última selección del usuario 
        Long oidTipoSolicitud = cache.getUltimoTipoSolicitud();

        if(oidTipoSolicitud != null ) { 
          this.cbTipoSolicitud.setSelectedIndexByKey(oidTipoSolicitud.toString());
        } else { 
          if (cache.getTiposSolicitud() != null &&
            cache.getTiposSolicitud().length > 0) {
              this.cbTipoSolicitud.setSelectedIndexByKey(
                cache.getTiposSolicitud()[0].getOidTipoSolicitud().toString());
          }
        } 
      } else { // Callcenter INCIDENCIA 
        if(this.oidTipoSolicitud != null) {
          this.cbTipoSolicitud.setSelectedIndexByKey(this.oidTipoSolicitud.toString()); 
          this.cbTipoSolicitud.setEnabled(false); 
        }        
      } 

      // Mostramos los datos asociados al tipo de solicitud seleccionado 
      this.mostrarDatosAsociadosTipoSolicitud();

      // Obtenemos los valores por defecto asociados al tipo de solicitud 
      this.obtenerValoresDefecto();
    }
    
    //Mostramos en la pagina la información asociada al tipo de solicitud 
    //seleccionado en cbTipoSolicitud 
    protected void mostrarDatosAsociadosTipoSolicitud() throws AppletException {
      DTOTiposSolicitud dtoTiposSolicitud = null;
      
      if (this.cache.getTiposSolicitud() != null ) {
        boolean seguir = true;
        for(int i = 0; seguir && i < this.cache.getTiposSolicitud().length; ++i) {
          if(this.cbTipoSolicitud.getKey() != null && !"".equals(this.cbTipoSolicitud.getKey().trim())) {
            Long key = new Long(this.cbTipoSolicitud.getKey());
            if (key.equals(this.cache.getTiposSolicitud()[i].getOidTipoSolicitud())) {
              dtoTiposSolicitud = this.cache.getTiposSolicitud()[i];
              seguir = false;
            }
          }
        }
        
        if(dtoTiposSolicitud != null) {
          this.lbMarcaTipoSolicitud.setText(dtoTiposSolicitud.getMarca()); 
          this.lbCanalTipoSolicitud.setText(dtoTiposSolicitud.getCanal());
          this.lbAccesoTipoSolicitud.setText(dtoTiposSolicitud.getAcceso());
          this.lbMonedaDocTipoSolicitud.setText(dtoTiposSolicitud.getMoneda());
  
  // Si el acceso es belcenter el subacceso será el registrado en la máquina del usuario 
  // En caso contrario, el asociado al tipo de solicitud y en su defecto, 
  //el del usuario por defecto 
          if(Boolean.TRUE.equals(this.cache.getBelcenter())) {
            this.lbSubaccesoTipoSolicitud.setText(this.cache.getTxtSubAcceso()); 
          } else { 
            if(dtoTiposSolicitud.getSubacceso() != null) {
              this.lbSubaccesoTipoSolicitud.setText(dtoTiposSolicitud.getSubacceso());
            } else { 
              this.lbSubaccesoTipoSolicitud.setText(this.cache.getTxtSubAcceso() );
            }  
          } 
  
          // Carga los periodos del tipo de solicitud 
          this.mostrarPeriodos(dtoTiposSolicitud.getOidTipoSolicitud());
          this.seleccionarPeriodo();        
        } else {
          System.out.println("********************************************************************");
          System.out.println("mostrarDatosAsociadosTipoSolicitud no se encontro el tipo Solicitud");
          System.out.println("********************************************************************");
        }
      }
    }
  
    // Recupera de sesión el periodo utilizado por el usuario en la solicitud 
    //anterior (en el caso de que la actual no sea la primera) y lo selecciona en 
    //el combo cbPeriodo. Si no existe ningún valor en sesión, selecciona el primero     
    protected void seleccionarPeriodo() throws AppletException {
      Long periodoCache = this.cache.getUltimoPeriodo();
      //System.out.println("estpy en seleccionarPeriodo() " + this.cbPeriodo.getItemCount());

      if(periodoCache == null) {
        if(this.cbPeriodo.getItemCount() > 0 && 
        this.cache.getPeriodos() != null &&
        this.cache.getPeriodos().length > 0) {
          this.cbPeriodo.setSelectedIndexByKey( 
              this.cache.getPeriodos()[0].getOid().toString());
              this.cache.setUltimoPeriodo(this.cache.getPeriodos()[0].getOid());        
              //System.out.println("Se selecciona el periodo2 " + this.cache.getPeriodos()[0].getOid().toString());
        } else {
          if(this.cbPeriodo.getItemCount() > 1) {
            this.cbPeriodo.setSelectedIndex(this.cbPeriodo.getItemCount() - 1); 
            this.cache.setUltimoPeriodo(new Long(this.cbPeriodo.getKey()));
            //System.out.println("Se selecciona el periodo3 " + this.cbPeriodo.getKey());  
          } else {
            System.out.println("No hay periodos cargados");
          }
        }
      } else {
        //System.out.println("Se selecciona el periodo2 " + periodoCache);
        this.cbPeriodo.setSelectedIndexByKey(periodoCache.toString());
      }
    }

  // Obtiene y asigna los valores por defecto a la pantalla 
  protected void obtenerValoresDefecto() throws AppletException {
    DTOValoresDefecto dtoValoresDefecto = new DTOValoresDefecto();
    
    dtoValoresDefecto.setModulo(new Long(ConstantesValoresDefecto.MODULO_PED.intValue()) );
    dtoValoresDefecto.setFormulario(ConstantesValoresDefecto.PG_REGISTRO_ONLINE );
    if (this.cbTipoSolicitud.getKey() != null && !"".equals(this.cbTipoSolicitud.getKey().trim())) {
      dtoValoresDefecto.setTipoSolicitud(new Long(this.cbTipoSolicitud.getKey()));
    }
    String []campos = new String[4];
    campos[0] = ConstantesValoresDefecto.CB_ACCESO_FISICO;
    campos[1] = ConstantesValoresDefecto.CB_DESTINO;
    campos[2] = ConstantesValoresDefecto.CB_TIPO_DESPACHO;
    campos[3] = ConstantesValoresDefecto.RB_CV_PRODUCTO;
    dtoValoresDefecto.setCampo(campos);
  
    MareDTO mareDTO = this.ejecutarNegocio("PEDObtenerValoresDefecto",           
            "es.indra.sicc.dtos.ped.DTOValoresDefecto",
            dtoValoresDefecto);
  
    if (mareDTO instanceof DTOValoresDefecto) {
      dtoValoresDefecto = (DTOValoresDefecto)mareDTO;
      // Asignamos los valores por defecto 
  
      // Acceso físico 
      if( dtoValoresDefecto.getValor() != null &&
          dtoValoresDefecto.getValor().length > 0 &&
          dtoValoresDefecto.getValor()[0] != null) {
            
            this.cbAccesoFisico.setSelectedIndexByKey(dtoValoresDefecto.getValor()[0]);
      }
      if(dtoValoresDefecto.getEditable() != null &&
        dtoValoresDefecto.getEditable().length > 0 &&
        Boolean.FALSE.equals(dtoValoresDefecto.getEditable()[0])) {

        this.cbAccesoFisico.setEnabled(false);                
      } else {
        this.cbAccesoFisico.setEnabled(true);
      }
      
      if(dtoValoresDefecto.getObligatorio() != null &&
        dtoValoresDefecto.getObligatorio().length > 0) {
          accesoFisicoObligatorio = dtoValoresDefecto.getObligatorio()[0];
      }        
            // Destino 
        if(dtoValoresDefecto.getValor() != null &&
          dtoValoresDefecto.getValor().length > 1 &&
          dtoValoresDefecto.getValor()[1] != null) {
  
            this.destinoDefecto = dtoValoresDefecto.getValor()[1];
        } 
  
        // Tipo despacho 
        if(dtoValoresDefecto.getValor() != null &&
          (dtoValoresDefecto.getValor().length > 2 &&
          dtoValoresDefecto.getValor()[2] != null &&
          !"".equals(dtoValoresDefecto.getValor()[2].trim()))) {
  
            this.cbTipoDespacho.setSelectedIndexByKey(dtoValoresDefecto.getValor()[2]);
        } else {          
          /*if(this.cache.getTiposDespacho() != null &&
            this.cache.getTiposDespacho().length > 0) {
                this.cbTipoDespacho.setSelectedIndexByKey(
                         this.cache.getTiposDespacho()[0].getOid().toString());           
          }*/ 
          if(this.cbTipoDespacho.getItemCount() > 0) {
            this.cbTipoDespacho.setSelectedIndex(1);
          }
        }
  
  
        // Indicador CV / Producto 
        if(dtoValoresDefecto.getValor() != null &&
          dtoValoresDefecto.getValor().length > 3 &&
          dtoValoresDefecto.getValor()[3] != null) {
        
            if(ConstantesPED.CV.equals(dtoValoresDefecto.getValor()[3])) {
              //El elemento rbIndCodigVentaProducto esta hecho lcomo un checkBox, 
              //ver que corresponde, puede ser que este erroneo y que verdaderamente sea un
              //radio, cuyos valores con V(CV) o P (PRODUCTO)
              
              //this.rbIndCodigVentaCV.setSelected(true);//(V) 
              ButtonModel model = this.rbIndCodigVentaCV.getModel();
              this.groupIndCodigVenta.setSelected(model, true);
              //System.out.println("se selecciona V");
            } else {
              //this.rbIndCodigVentaProducto.setSelected(true);//(P) 
              ButtonModel model = this.rbIndCodigVentaProducto.getModel();
              this.groupIndCodigVenta.setSelected(model, true);
              //System.out.println("se selecciona P");
            }
        } else {
        //System.out.println("se selecciona V 2");
          //this.rbIndCodigVentaCV.setSelected(true);//(V) 
          ButtonModel model = this.rbIndCodigVentaCV.getModel();
          this.groupIndCodigVenta.setSelected(model, true);

        }
        if(dtoValoresDefecto.getEditable() != null &&
          dtoValoresDefecto.getEditable().length > 3 &&
          Boolean.FALSE.equals(dtoValoresDefecto.getEditable()[3])) {
  
            this.rbIndCodigVentaProducto.setEnabled(false);
            this.rbIndCodigVentaCV.setEnabled(false);
        } /*else {
            this.rbIndCodigVentaProducto.setSelected(true);
            this.rbIndCodigVentaCV.setEnabled(true);
        }*/
        
        this.seleccionarPeriodo();
        
      } else {
        System.out.println("no hay valores por defecto");
        return;
      }
  }

    // En primer lugar valida que todos los Campos de Solicitud que tengan activado el 
    //flag Indicador Obligatorio obtenido de Valores por Defecto estén rellenos. 
    protected Boolean comprobarDatosObligatorios() throws AppletException {
      boolean obligatoriosOk = true;
      
      // Comprueba si el acceso físico es obligatorio 
      if(Boolean.TRUE.equals(this.accesoFisicoObligatorio)) {
        //System.out.println("Acceso es obligatorio");
        //El campo cbAccesoFísico será obligatorio 
        if (0 <= this.cbAccesoFisico.getSelectedIndex()) {
          obligatoriosOk = false;
          Dialogos.mensajeError(ConstantesApplet.ERROR_FALTA_CAMPO_OBLIGATORIO, "Acceso físico", this);
        }
      }

      //Comprobar que se han introducido los datos obligatorios: 

      if (this.cbTipoSolicitud.getSelectedIndex() <= 0) {
        this.cbTipoSolicitud.requestFocus();
        Dialogos.mensajeError(ConstantesApplet.ERROR_FALTA_CAMPO_OBLIGATORIO, "Tipo solicitud", this);
        obligatoriosOk = false;
      } else if (this.cbPeriodo.getSelectedIndex() <= 0) {
        this.cbPeriodo.requestFocus();
        Dialogos.mensajeError(ConstantesApplet.ERROR_FALTA_CAMPO_OBLIGATORIO, "Periodo", this);
        obligatoriosOk = false;
      } else if (this.txtCodCliente.getText() == null || "".equals(this.txtCodCliente.getText().trim())) {
        this.txtCodCliente.requestFocus();
        Dialogos.mensajeError(ConstantesApplet.ERROR_FALTA_CAMPO_OBLIGATORIO, "Codigo cliente", this);
        obligatoriosOk = false;
      } else if(this.cbTipoDespacho.getSelectedIndex() <= 0) {
        Dialogos.mensajeError(ConstantesApplet.ERROR_FALTA_CAMPO_OBLIGATORIO, "Tipo despacho", this);
        obligatoriosOk = false;
        this.cbTipoDespacho.requestFocus();
      } else if(this.cbTipoDocumento.getSelectedIndex() <= 0) {
        this.cbTipoDocumento.requestFocus();
        Dialogos.mensajeError(ConstantesApplet.ERROR_FALTA_CAMPO_OBLIGATORIO, "Tipo documento", this);
        obligatoriosOk = false;
      } else if(this.txtReceptorFactura.getText() == null || "".equals(this.txtReceptorFactura.getText().trim())) {
        this.txtReceptorFactura.requestFocus();
        obligatoriosOk = false;
      } else if(this.txtPagadorFactura.getText() == null || "".equals(this.txtPagadorFactura.getText().trim())) {
        obligatoriosOk = false;
        Dialogos.mensajeError(ConstantesApplet.ERROR_FALTA_CAMPO_OBLIGATORIO, "Pagador factura", this);
        this.txtPagadorFactura.requestFocus();
      } else if(this.cbDestino.getSelectedIndex() <= 0 ) {
        obligatoriosOk = false;
        Dialogos.mensajeError(ConstantesApplet.ERROR_FALTA_CAMPO_OBLIGATORIO, "Destino", this);
        this.cbDestino.requestFocus();
      }

      return new Boolean(obligatoriosOk);
    }

    protected void mostrarFechaFacturacion() throws AppletException {
      if(Boolean.TRUE.equals(this.cache.getBelcenter())) {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        //this.txtFechaProgramadaFac.setText(sdf.format(new java.util.Date())); 
        this.txtFechaProgramadaFac.setText(sdf.format( this.cache.getFechaFacturacion() ));
        this.txtFechaProgramadaFac.setEnabled(false);
      } else { 
        this.txtFechaProgramadaFac.setEnabled(true);
      }
    }

    protected void mostrarPeriodos(Long oidTipoSolicitud) throws AppletException {
      DTOTiposSolicitud []dtosTiposSolicitudes = this.cache.getTiposSolicitud();
      boolean flag = false;
      if (dtosTiposSolicitudes != null) {
        for(int i = 0; !flag && i < dtosTiposSolicitudes.length; ++i) {
          if (dtosTiposSolicitudes[i].getOidTipoSolicitud().equals(oidTipoSolicitud)) {
            //Carga en cbPeriodo los periodos encontrados en DTOTipoSolicitud.periodos 
            DTODatosCombo[] dtoDatosCombo = dtosTiposSolicitudes[i].getPeriodos();
            this.cargarCombo(this.cbPeriodo, dtoDatosCombo);            
            flag = true;
          }
        }
      }
    }
      

  public void cargarCombo(ComboBoxApplet combo, DTODatosCombo[] dtoDatosCombo) throws AppletException {
    combo.removeAllItems();
    combo.addItem("-1","");
    if (dtoDatosCombo != null) {
      for (int i = 0; i < dtoDatosCombo.length; ++i) {      
        if (dtoDatosCombo[i] != null) {
          //System.out.println("datos combo: " + dtoDatosCombo[i]);
          combo.addItem(
            dtoDatosCombo[i].getOid().toString(),
            dtoDatosCombo[i].getDesc());
        }
      }
    } 
  }

  // Reinicia la solicitud 
  public void reiniciar() {
    //Limpia los campos: (En los combos seleccionar el valor vacío) 
    this.cbAccesoFisico.setSelectedIndex(0);
    this.txtCodCliente.setText("");
    this.lbNombre.setText("");
    this.lbApellidos.setText("");
    this.txtFechaProgramadaFac.setText("");
    this.lbLineaCredito.setText("");
    this.lbLineaDisp.setText("");
    this.lbDeudaVencida.setText("");
    this.cbTipoDocumento.setSelectedIndex(0);
    this.lbDocumentoLegal.setText("");
    this.txtConsultoraRefencia.setText("");
    this.cbDestino.setSelectedIndex(0);
    this.txtReceptorFactura.setText("");
    this.txtPagadorFactura.setText(""); 
    this.txtNumeroClientes.setText("");
    this.cbFormaPago.setSelectedIndex(0);
    this.atxObservaciones.setText("");
    
    //limpiado de campos de pestaña Detalle
    this.lbCodClienteDetalle.setText("");
    this.lbNombreDetalle.setText("");
    this.lbApellidosDetalle.setText("");
    this.lbLineaDispDetalle.setText("");
    this.lbFormaPagoDetalle.setText("");
    this.txtCodVenta.setText("");
    this.txtCodProducto.setText("");
    this.lbDescripcion.setText("");
    this.txtUnidDemandadas.setText("");
    this.lbStockDisponibleCantidad.setText("");
    this.lbLimiteVentaCantidad.setText("");
    this.lbControlLiqCantidad.setText("");
    this.lbReservaCantidad.setText("");
    this.chkDemandaNoAtendida.setSelected(false);
    this.atxObservacionesDatosDetalle.setText("");
    System.out.println("tablaDetalle Clear");
    this.tablaDetalle.clear();
    //this.tablaDetalle = new TablaDetalle();
    
    
    try {
      // Muestra la fecha programada de facturación 
      this.mostrarFechaFacturacion();
  
      // Seleccionar un tipo de solicitud y mostrar sus datos asociados 
      this.seleccionarTipoSolicitud(); 
  
      // Si estamos en callcenter mostramos los datos del cliente 
      if(Boolean.FALSE.equals(this.cache.getBelcenter())) {
        this.marcoCliente.mostrarDatosCliente();
      }
    } catch (AppletException e) {
      //Dialogos.mensajeError(ConstantesApplet.ERROR_AL_REINICIAR_CAMPOS, this);
      UtilApplet.procesarError(e, this);
    }
    
    this.jTabbedPane.setEnabledAt(this.jTabbedPane.indexOfComponent(this.pestaniaCabecera),true); //pestaniaCabecera.setEnabled(true);
    this.jTabbedPane.setEnabledAt(this.jTabbedPane.indexOfComponent(this.pestaniaDetalle),false);//pestaniaDetalle.setEnabled(false);
    
    //Activa componentes de la pestaña cabecera
    this.btnAltaCliente.setEnabled(true);
    for (int i=0; i < this.TipoSolicitud.getComponentCount(); i++)
         this.TipoSolicitud.getComponent(i).setEnabled(true);
    for (int i=0; i < this.pnDatosSolicitud.getComponentCount(); i++)
         this.pnDatosSolicitud.getComponent(i).setEnabled(true);
    for (int i=0; i < this.Cliente.getComponentCount(); i++)
         this.Cliente.getComponent(i).setEnabled(true);
    for (int i=0; i < this.pnAceptarCancelar.getComponentCount(); i++)
         this.pnAceptarCancelar.getComponent(i).setEnabled(true);
    
    this.jTabbedPane.setSelectedIndex(jTabbedPane.indexOfComponent(pestaniaCabecera));
    
  }

/******************************************************************************/
/***************************MARCO TIPO SOLICITUD*******************************/
/******************************************************************************/  

  protected void cbtipoSolicitud_onchange() throws AppletException {
    System.out.println("cbtipoSolicitud_onchange");
    if(cbTipoSolicitud.getKey() != null && !"-1".equals(cbTipoSolicitud.getKey().trim()) &&
        !"".equals(cbTipoSolicitud.getKey().trim())) {
      Long tipoSolic = new Long(cbTipoSolicitud.getKey());
      this.cache.setUltimoTipoSolicitud(tipoSolic);
      
      this.mostrarDatosAsociadosTipoSolicitud();
      this.obtenerValoresDefecto();
    } else {
      this.lbMarcaTipoSolicitud.setText("");
      this.lbCanalTipoSolicitud.setText("");
      this.lbAccesoTipoSolicitud.setText("");
      this.lbSubaccesoTipoSolicitud.setText("");
      this.lbMarcaTipoSolicitud.setText("");
    }
  }

  public DTOCabeceraSolicitud getDTOCabeceraSolicitud(){
    return dtoCabeceraSolicitud;
  }
  
  public void setDTOCabeceraSolicitud(DTOCabeceraSolicitud dto){
    dtoCabeceraSolicitud = dto;
  }
  
  
    public void print(String s) 
  {
    System.out.println("llego como String: " + s);
  }
  
  public void print(Object s) 
  {
    System.out.println("llego como object: " + s);
  }
  
  public Object getMsg() 
  {
    System.out.println("entro en getMSG");
    return "CHAUUUU";
  }
    
    
    public void setCodigoCliente(String texto) throws AppletException {
      //System.out.println("entro en setCodigoCliente con el texto: " + texto);
      this.txtCodCliente.setText(texto);
      this.marcoCliente.txtcodCliente_lostFocus();
      //this.repaint();
    }
    
    public void setPagadorFactura(String texto) {
      //System.out.println("va a cargar el txtPagadorFactura con: " + texto);
      this.txtPagadorFactura.setText(texto);
    }
    
    public void setReceptorFactura(String texto) {
      //System.out.println("va a cargar el txtReceptorFactura con: " + texto);
      this.txtReceptorFactura.setText(texto);
    }
    
    public void setConsultoraRefencia(String texto) {
      //System.out.println("va a cargar el txtConsultoraRefencia con: " + texto);
      this.txtConsultoraRefencia.setText(texto);
    }

}
