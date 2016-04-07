package es.indra.sicc.dtos.fac;
import es.indra.sicc.util.DTOBelcorp;

public class DTOFACReporte extends DTOBelcorp 
{
  private Long periodo;
  private Long region;
  private Long zona;
  private Long marca;
  private Long canal;

  public DTOFACReporte()
  {
  }

  public Long getPeriodo()
  {
    return periodo;
  }

  public void setPeriodo(Long periodo)
  {
    this.periodo = periodo;
  }

  public Long getRegion()
  {
    return region;
  }

  public void setRegion(Long region)
  {
    this.region = region;
  }

  public Long getZona()
  {
    return zona;
  }

  public void setZona(Long zona)
  {
    this.zona = zona;
  }

  public Long getMarca()
  {
    return marca;
  }

  public void setMarca(Long marca)
  {
    this.marca = marca;
  }

  public Long getCanal()
  {
    return canal;
  }

  public void setCanal(Long canal)
  {
    this.canal = canal;
  }
}