package es.indra.sicc.bel.applet.componentes;

import es.indra.mare.common.dto.MareDTO;
import es.indra.sicc.bel.applet.GestorCobrosDevolucionesApplet;
import es.indra.sicc.comunapplet.UtilApplet;
import es.indra.sicc.dtos.ped.applet.DTODatosCliente;
import es.indra.sicc.comunapplet.exceptions.AppletException;

public class CobrosDevolucionesDetalleCabeceraController {
  
  private GestorCobrosDevolucionesApplet applet = null;
  private DTODatosCliente dtoDatosCliente = null;
  private Long oidCliente = null;
  
  public CobrosDevolucionesDetalleCabeceraController(GestorCobrosDevolucionesApplet applet) {
    this.applet = applet;
  }
  
  public void btnBuscarCliente_onClick() {
    //try {
      this.applet.ejecutarWeb("busquedaRapidaCliente", "'LPBusquedaRapidaCliente'");
    /*} catch (AppletException e) {
      UtilApplet.procesarError(e, this.applet);
    }*/
  }
  
  public void txtCodCliente_lostFocus() {
    if(!"".equals( this.applet.getTxtCodCliente())) { 
      // Obtenemos el resto de datos del cliente 
      this.dtoDatosCliente = this.obtenerDatosCliente();
    }    
  }
  
  public DTODatosCliente obtenerDatosCliente() {
    DTODatosCliente dto = new DTODatosCliente();
    dto.setCodCliente(this.applet.getTxtCodCliente());
    dto.setOidPais(this.applet.getOidPais());
    dto.setOidIdioma(this.applet.getOidIdioma());
    dto.setUserName(this.applet.getUsuario());
    
    System.out.println("pais: " + this.applet.getOidPais());
    try {
      MareDTO mareDTO = this.applet.ejecutarNegocio(
            "PEDObtenerDatosClienteRegistro" , 
            "es.indra.sicc.dtos.ped.applet.DTODatosCliente",
            dto);
      if(mareDTO instanceof DTODatosCliente) {
        dto = (DTODatosCliente) mareDTO;
        this.oidCliente = dto.getOidCliente();        
      }
 
      
    } catch (AppletException e) {
      UtilApplet.procesarError(e, this.applet);
      this.applet.setCodigoCliente("");
      this.applet.setCodigoClienteFocus();
    }
    return dto;
  }
  
  public DTODatosCliente getDTODatosCliente() {
    return this.dtoDatosCliente;
  }
  
  public void setOidCliente(Long oid) {
    this.oidCliente = oid;
  }
  
  public Long getOidCliente() {
    return this.oidCliente;
  }
}