package es.indra.sicc.dtos.ped.applet;
import es.indra.sicc.comunapplet.dtos.applet.DTOPaginacionClientePesado;

public class DTOSolicitudesAnteriores extends DTOPaginacionClientePesado 
{
  private Long oidCliente;

  public Long getOidCliente()
  {
    return oidCliente;
  }

  public void setOidCliente(Long oidCliente)
  {
    this.oidCliente = oidCliente;
  }
}