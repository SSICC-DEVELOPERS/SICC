package es.indra.sicc.ped.applet;
import es.indra.mare.common.dto.MareDTO;
import es.indra.sicc.comunapplet.Dialogos;
import es.indra.sicc.comunapplet.UtilApplet;
import es.indra.sicc.dtos.ped.DTOCabeceraSolicitud;
import es.indra.sicc.comunapplet.exceptions.AppletException;
import es.indra.sicc.comunapplet.ConstantesApplet;
import es.indra.sicc.ped.applet.util.DateValidation;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class Cabecera 
{ 
  private RegistroOnlineApplet applet = null;
  
  public Cabecera(RegistroOnlineApplet applet) {
    this.applet = applet;
  }
  
  private boolean vaidarFecha() {
    String fecha = this.applet.txtFechaProgramadaFac.getText();
    //System.out.println("se valida la fecha");
    if(fecha == null || !"".equals(fecha.trim())) {
      DateValidation date = new DateValidation();
      if(!date.isValid(fecha)) {
        return false;
      }
      /*if(date.isPast(fecha)) {
        return false;
      }*/
    }
    return true;
  }

  private boolean validarNumeroClientes() {
    //System.out.println("se valido numero de clientes");
    String numero = this.applet.txtNumeroClientes.getText();
    return numero.matches("[0-9]*");
  }
  
  protected void validarCabeceraSolicitud() {
    try {
      Boolean correcto = this.applet.comprobarDatosObligatorios(); 
      if(!this.vaidarFecha()) {
        Dialogos.mensajeError(ConstantesApplet.FECHA_INVALIDA, this.applet);
        this.applet.txtFechaProgramadaFac.requestFocus();
        return;
      }
      if(!validarNumeroClientes()) {
        Dialogos.mensajeError(ConstantesApplet.NUMERO_INVALIDO, this.applet);
        this.applet.txtNumeroClientes.requestFocus();
        return;
      }
      //System.out.println("**************************************************");
      //System.out.println("la comprobacion de datos obligatorios resulto: " + correcto);
     // System.out.println("**************************************************");
      if(Boolean.TRUE.equals(correcto)) { 
        DTOCabeceraSolicitud dtoCabeceraSolicitud = new DTOCabeceraSolicitud();
        dtoCabeceraSolicitud.setIP(this.applet.ip);
        Long oidTipoSolicitud = new Long(this.applet.cbTipoSolicitud.getKey());
        dtoCabeceraSolicitud.setTipoSolicitud(oidTipoSolicitud);
        
        for(int i = 0; i < this.applet.cache.getTiposSolicitud().length; ++i) {
          if(oidTipoSolicitud.equals(this.applet.cache.getTiposSolicitud()[i].getOidTipoSolicitud())) {
            dtoCabeceraSolicitud.setTipoCliente(this.applet.cache.getTiposSolicitud()[i].getOidTipoCliente());
            dtoCabeceraSolicitud.setMarca(this.applet.cache.getTiposSolicitud()[i].getOidMarca());
            dtoCabeceraSolicitud.setCanal(this.applet.cache.getTiposSolicitud()[i].getOidCanal());
            dtoCabeceraSolicitud.setAcceso(this.applet.cache.getTiposSolicitud()[i].getOidAcceso());
            dtoCabeceraSolicitud.setSubacceso(this.applet.cache.getTiposSolicitud()[i].getOidSubacceso());
            // DBLG400000398 - dmorello, 22/02/2006: Debe preguntarse por != null y no por == null
            if(this.applet.cbAccesoFisico.getKey() != null &&
              !"".equals(this.applet.cbAccesoFisico.getKey()) &&
              !"-1".equals(this.applet.cbAccesoFisico.getKey())) {
                dtoCabeceraSolicitud.setAccesoFisico(new Long(this.applet.cbAccesoFisico.getKey()));
            }
            dtoCabeceraSolicitud.setMoneda(this.applet.cache.getTiposSolicitud()[i].getOidMoneda());
            if(dtoCabeceraSolicitud.getMoneda() == null) {
              dtoCabeceraSolicitud.setMoneda(new Long(1));
            }
            dtoCabeceraSolicitud.setPeriodo(new Long(this.applet.cbPeriodo.getKey()));
            dtoCabeceraSolicitud.setCliente(this.applet.txtCodCliente.getText());
            dtoCabeceraSolicitud.setTipoDespacho(new Long(this.applet.cbTipoDespacho.getKey()));
            
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
            String fecha = this.applet.txtFechaProgramadaFac.getText();
            try {
              dtoCabeceraSolicitud.setFechaPrevistaFacturacion(new java.sql.Timestamp(sdf.parse(fecha).getTime()));
            } catch (ParseException pe) {
            }
            
            //Pzerbino DBLG700000037 21/9/2006 Dia de la Primavera!!!!!!!!
            //dtoCabeceraSolicitud.setFecha(new java.util.Date());
            SimpleDateFormat sdfs = new SimpleDateFormat("dd/MM/yyyy");
            String fechaS = this.applet.fechaSistema;
            System.out.println("fechaS*******" + fechaS);
            try {
              dtoCabeceraSolicitud.setFecha(new java.sql.Timestamp(sdfs.parse(fechaS).getTime()));              
            } catch (ParseException pe) {
            }
            
            dtoCabeceraSolicitud.setUsuario(this.applet.getUser());
            dtoCabeceraSolicitud.setTipoDocumento(new Long(this.applet.cbTipoDocumento.getKey()));
            
            Long oidTipoDocLegal = null;
            if (this.applet.dtoDatosCliente != null && this.applet.dtoDatosCliente.getTiposDocumento() != null) {
              for(int j = 0; j < this.applet.dtoDatosCliente.getTiposDocumento().length && oidTipoDocLegal == null; ++j) {
                if(this.applet.dtoDatosCliente.getTiposDocumento()[j].getOid().equals(new Long(this.applet.cbTipoDocumento.getKey()))) {
                  oidTipoDocLegal = this.applet.dtoDatosCliente.getTiposDocumento()[j].getOidDocLegal();
                }
              }
            }
            dtoCabeceraSolicitud.setTipoDocumentoLegal(oidTipoDocLegal);
            dtoCabeceraSolicitud.setCodigoConsultoraAsociada(this.applet.txtConsultoraRefencia.getText());
            dtoCabeceraSolicitud.setDestino(new Long(this.applet.cbDestino.getKey()));
            dtoCabeceraSolicitud.setReceptorFactura(this.applet.txtReceptorFactura.getText());
            dtoCabeceraSolicitud.setPagadorFactura(this.applet.txtPagadorFactura.getText());
            if(!"".equals(this.applet.txtNumeroClientes.getText().trim() )) {
              dtoCabeceraSolicitud.setNumeroClientes(new Integer(this.applet.txtNumeroClientes.getText()));          
            }
            if(!"-1".equals(this.applet.cbFormaPago.getKey())) {
              dtoCabeceraSolicitud.setFormaPago(new Long(this.applet.cbFormaPago.getKey()));
            }
            dtoCabeceraSolicitud.setObservaciones(this.applet.atxObservaciones.getText());
            dtoCabeceraSolicitud.setIndicadorDigitacion(Boolean.FALSE);
            dtoCabeceraSolicitud.setOidPais(this.applet.oidPais);
            
            // DBLG400000392 - dmorello, 21/03/2006: Se setea el OID de idioma
            dtoCabeceraSolicitud.setOidIdioma(this.applet.oidIdioma);
            
            // DBLG400000393 - Gacevedo, 07/07/2006: Se setea el tipo de solicitud 
            // a fin de usarlo en la busqueda de productos.
            //this.applet.getDTOCabeceraSolicitud().setOidTipoSolicitud(this.applet.cache.getTiposSolicitud()[i].getOidTipoSolicitud());

            break;
          }
        }   
        // Se realiza la validación de la cabecera 
        MareDTO mareDTO = this.applet.ejecutarNegocio("PEDValidacionesGeneralesSolicitud" , 
                      "es.indra.sicc.dtos.ped.DTOCabeceraSolicitud",
                      dtoCabeceraSolicitud);
                      
        if(mareDTO instanceof DTOCabeceraSolicitud) {
          dtoCabeceraSolicitud = (DTOCabeceraSolicitud) mareDTO;
        } else {
          Dialogos.mensajeError(ConstantesApplet.PED_0016, this.applet);          
        }
         
        if (Boolean.TRUE.equals(dtoCabeceraSolicitud.getOK())) {
            /*if(dtoCabeceraSolicitud.getMoneda() == null) {
              dtoCabeceraSolicitud.setMoneda(new Long(1));
            }*/
            System.out.println("*********************************");
            System.out.println(dtoCabeceraSolicitud);
            System.out.println("*********************************");
            
          this.applet.mostrarDetalle();
        } else { 
          Dialogos.mensajeError(ConstantesApplet.PED_0016, this.applet);
        } 
        this.applet.dtoCabeceraSolicitud = dtoCabeceraSolicitud;
      } /*else {
        Dialogos.mensajeError(ConstantesApplet.ERROR_FALTAN_DATOS_OBLIGATORIOS, this.applet);
      }*/
    } catch (AppletException e) {
      e.printStackTrace();
      UtilApplet.procesarError(e, this.applet);
      //Dialogos.mensajeError(e.getCode(), this.applet);
    }
  }
}
