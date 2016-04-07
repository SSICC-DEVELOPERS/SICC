package es.indra.sicc.dtos.ccc;
import es.indra.sicc.util.DTOBelcorp;

public class DTOClienteBloqueo extends DTOBelcorp 
{
  private Long oidCliente;
  private Long oidTipoBloqueo;
  private Long nvlGravedadBloqueo;

  public DTOClienteBloqueo()
  {
  }

  public Long getOidCliente()
  {
    return oidCliente;
  }

  public void setOidCliente(Long oidCliente)
  {
    this.oidCliente = oidCliente;
  }

  public Long getOidTipoBloqueo()
  {
    return oidTipoBloqueo;
  }

  public void setOidTipoBloqueo(Long oidTipoBloqueo)
  {
    this.oidTipoBloqueo = oidTipoBloqueo;
  }

  public Long getNvlGravedadBloqueo()
  {
    return nvlGravedadBloqueo;
  }

  public void setNvlGravedadBloqueo(Long nvlGravedadBloqueo)
  {
    this.nvlGravedadBloqueo = nvlGravedadBloqueo;
  }
}