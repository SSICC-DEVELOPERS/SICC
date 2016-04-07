package es.indra.sicc.ped.applet;

import es.indra.mare.common.dto.MareDTO;
import es.indra.sicc.dtos.ped.applet.DTODatosCliente;
import es.indra.sicc.comunapplet.Dialogos;
import es.indra.sicc.comunapplet.exceptions.AppletException;
import es.indra.sicc.comunapplet.ConstantesApplet;

public class Cliente 
{ 
  private RegistroOnlineApplet applet = null;
  
  public Cliente(RegistroOnlineApplet applet)
  {
    this.applet = applet;
  }
  
  protected void btnBuscarCliente_onClick() throws AppletException {
    this.applet.ejecutarWeb("obtenerCodigoCliente", "'LPBusquedaRapidaCliente'");
    //Con lo valores obtenidos se asigna el valor de codigo de cliente al campo 
    //txtcodCliente (marco Cliente) 
    //Mostramos codigo en txtCliente 
    // Obtenemos el resto de datos del cliente 
    this.applet.marcoCliente.obtenerDatosCliente();
  }
  
  // Método que se ejecuta al pulsar sobre el icono de búsqueda del campo txtConsultoraRefencia 
  protected void btnBuscarConsultoraReferencia_onClick() throws AppletException {
    //TODO probar
    this.applet.ejecutarWeb("obtenerConsultoraRefencia", "'LPBusquedaRapidaCliente'"); 
    //Mostramos codigo en txtConsultoraRefencia 
  }
  
  protected void cbTipoDocumento_onChange() throws AppletException {
    //Se asigna al cambo lbDocumentoLegal el valor del atributo descDocLegal del
    //DTOTipoDocumento correspondiente. (Se busca el DTOTipoDocumento en el 
    //atributo tipoDocumentoCliente)
    if(!"".equals(this.applet.cbTipoDocumento.getKey())) {
      Long oid = new Long(this.applet.cbTipoDocumento.getKey());
      if (this.applet.dtoDatosCliente != null && this.applet.dtoDatosCliente.getTiposDocumento() != null) {
        boolean flag = false;
        for(int i = 0; !flag && i < this.applet.dtoDatosCliente.getTiposDocumento().length; ++i) {
          if (this.applet.dtoDatosCliente.getTiposDocumento()[i].getOid().equals(oid)) {
            this.applet.lbDocumentoLegal.setText(this.applet.dtoDatosCliente.getTiposDocumento()[i].getDesDocLegal());
            break;
          }
        }
      }
    }
  }
  
  protected void txtcodCliente_lostFocus() throws AppletException {
    if(this.applet.txtCodCliente.getText() != null &&  
        this.applet.txtCodCliente.getText().trim().length() > 0) { 
          // Obtenemos el resto de datos del cliente 
          this.obtenerDatosCliente();
    }
  }

  protected void obtenerDatosCliente() throws AppletException {
    this.applet.dtoDatosCliente = new DTODatosCliente();
    this.applet.dtoDatosCliente.setCodCliente(this.applet.txtCodCliente.getText()); 
    this.applet.dtoDatosCliente.setOidPais(this.applet.oidPais);
    this.applet.dtoDatosCliente.setOidIdioma(this.applet.oidIdioma);
    this.applet.dtoDatosCliente.setUserName(this.applet.user);
    
    MareDTO mareDTO = this.applet.ejecutarNegocio(
              "PEDObtenerDatosClienteRegistro" , 
              "es.indra.sicc.dtos.ped.applet.DTODatosCliente",
              this.applet.dtoDatosCliente);
    
    if(mareDTO instanceof DTODatosCliente) {
      this.applet.dtoDatosCliente = (DTODatosCliente) mareDTO;
      // Mostramos los datos del cliente 
      this.mostrarDatosCliente();
    } else {
      Dialogos.mensajeError(ConstantesApplet.DATOS_CLIENTE_NO_EXISTENTES, this.applet);
    }
    
    
  }
  
  // Método que se ejecuta al pulsar sobre el icono de búsqueda del campo txtReceptorFactura 
  protected void btnBuscarReceptor_onClick() throws AppletException {
    this.applet.ejecutarWeb("obtenerReceptorFactura", "'LPBusquedaRapidaCliente'");
    //Mostramos codigo en txtReceptorFactura

    // Si el código es diferente al código de cliente mostramos un aviso 
    if(this.applet.txtReceptorFactura == null ||
      this.applet.txtReceptorFactura.getText().equals(this.applet.txtCodCliente)) {
        Dialogos.mensajeError(ConstantesApplet.PED_0013, this.applet);
        
    }
  }
  
  // Método que se ejecuta al pulsar sobre el icono de búsqueda del campo txtPagadorFactura 
  protected void btnBuscarPagador_onClick() throws AppletException {
    this.applet.ejecutarWeb("obtenerPagadorFactura", "'LPBusquedaRapidaCliente'");
    //Mostramos codigo en txtPagadorFactura 
    
    // Si el código es diferente al código de cliente mostramos un aviso 
    if(this.applet.txtPagadorFactura == null ||
      this.applet.txtPagadorFactura.getText().equals(this.applet.txtCodCliente)) {
        //Mostrar mensaje de aviso: PED-0014
        Dialogos.mensajeError(ConstantesApplet.PED_0014, this.applet);
    }
  }
  
  protected void txtReceptorFactura_lostFocus() throws AppletException {
    // Si el código es diferente al código de cliente mostramos un aviso 
    if(this.applet.txtReceptorFactura .getText() != null &&
      !"".equals(this.applet.txtReceptorFactura.getText().trim())) {
       // Si el código es diferente al código de cliente mostramos un aviso 
        if(!this.applet.txtReceptorFactura.getText().trim().equals(this.applet.txtCodCliente.getText().trim())) {
          //Mostrar mensaje de aviso: PED-0013 
          Dialogos.mensajeAceptar(ConstantesApplet.PED_0013, this.applet);
        }
    }
  }
  
  protected void txtPagadorFactura_lostFocus() throws AppletException {
    // Si el código es diferente al código de cliente mostramos un aviso 
    if(this.applet.txtPagadorFactura.getText() != null &&
      !"".equals(this.applet.txtPagadorFactura.getText().trim())) {
       // Si el código es diferente al código de cliente mostramos un aviso 
        if(!this.applet.txtPagadorFactura.getText().trim().equals(this.applet.txtCodCliente.getText().trim())) {
          //Mostrar mensaje de aviso: PED-0013 
          Dialogos.mensajeAceptar(ConstantesApplet.PED_0014, this.applet);
        }
    }
  } 
  
  protected void mostrarDatosCliente() throws AppletException {
    
    // DATOS GENERALES 
    this.applet.txtCodCliente.setText(this.applet.dtoDatosCliente.getCodCliente());
    this.applet.txtReceptorFactura.setText(this.applet.dtoDatosCliente.getCodCliente());
    this.applet.txtPagadorFactura.setText(this.applet.dtoDatosCliente.getCodCliente());
    this.applet.lbNombre.setText(this.applet.dtoDatosCliente.getNombre());
    this.applet.lbApellidos.setText(this.applet.dtoDatosCliente.getApellidos());
    this.applet.lbLineaCredito.setText(this.applet.dtoDatosCliente.getLineaCredito().toString());
    this.applet.lbLineaDisp.setText(this.applet.dtoDatosCliente.getLineaDisp().toString());
    this.applet.lbDeudaVencida.setText(this.applet.dtoDatosCliente.getDeudaVencida().toString());
    
    // TIPO DOCUMENTO 
    //System.out.println("La cantidad de tipo documento es: " + this.applet.dtoDatosCliente.getTiposDocumento().length);    
    this.applet.cbTipoDocumento.removeAllItems();
    this.applet.cbTipoDocumento.addItem("-1", "");
    for(int i = 0; i < this.applet.dtoDatosCliente.getTiposDocumento().length; ++i) {
      System.out.println("Agrega tipo documento " + this.applet.dtoDatosCliente.getTiposDocumento()[i].getDesc());
        this.applet.cbTipoDocumento.addItem(
                    this.applet.dtoDatosCliente.getTiposDocumento()[i].getOid().toString(),
                    this.applet.dtoDatosCliente.getTiposDocumento()[i].getDesc()
                    );
    }
    
    //Selecciona el primer elemento de la lista 
    if(this.applet.cbTipoDocumento.getItemCount() > 1) {
      this.applet.cbTipoDocumento.setSelectedIndex(1);
    }
    
    // TIPO DOCUMENTO LEGAL
    //Modificado por Cristian Valenzuela
    //Fecha: 11/1/2006
    //INCIDENCIA: BELC300021635    
    
    /*if(this.applet.cbTipoDocumento.getItemCount() > 1 ) {
      this.applet.lbDocumentoLegal.setText((String)this.applet.cbTipoDocumento.getItemAt(1));
    } else {
      this.applet.lbDocumentoLegal.setText("");
    }*/
    
    //(En el label documento legal estaba mostrando un valor incorrecto)
    this.cbTipoDocumento_onChange();
    //FIN - Modificado por Cristian Valenzuela
    
    // DESTINO    
    /*this.applet.cbDestino.removeAllItems();
    this.applet.cbDestino.addItem("-1", "");
    for(int i = 0; i < this.applet.dtoDatosCliente.getDirecciones().length; ++i) {
        this.applet.cbDestino.addItem(
                      this.applet.dtoDatosCliente.getDirecciones()[i].getOid().toString(),
                      this.applet.dtoDatosCliente.getDirecciones()[i].getDesc()
                    );
    }
    */
    this.applet.cargarCombo(this.applet.cbDestino, this.applet.dtoDatosCliente.getDirecciones());
    System.out.println("****** destinoDefecto " + this.applet.destinoDefecto);
    
    if(this.applet.destinoDefecto != null) {
      System.out.println("******* Antes de seleccionar el destino defecto");
      //this.applet.cbDestino.setSelectedIndexByKey(this.applet.destinoDefecto);
      this.applet.cbDestino.setSelectedIndexByText(this.applet.destinoDefecto);
    }
  }
}