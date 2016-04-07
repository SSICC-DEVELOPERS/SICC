package es.indra.sicc.dtos.ped;

import es.indra.sicc.dtos.ped.DTOSolicitudValidacion;

public class DTOSolicitudReversion extends DTOSolicitudValidacion {
  private Long oidDetalleOferta;

  public DTOSolicitudReversion(){
  }


  public void setOidDetalleOferta(Long oidDetalleOferta)
  {
    this.oidDetalleOferta = oidDetalleOferta;
  }


  public Long getOidDetalleOferta()
  {
    return oidDetalleOferta;
  }
  
  
}