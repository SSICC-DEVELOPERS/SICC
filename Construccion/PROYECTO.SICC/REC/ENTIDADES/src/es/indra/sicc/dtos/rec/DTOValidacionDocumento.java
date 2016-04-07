package es.indra.sicc.dtos.rec;

public class DTOValidacionDocumento 
{
  private Boolean error;
  private Integer posicion;

  public DTOValidacionDocumento()
  {
  }

  public Boolean getError()
  {
    return error;
  }

  public void setError(Boolean error)
  {
    this.error = error;
  }

  public Integer getPosicion()
  {
    return posicion;
  }

  public void setPosicion(Integer posicion)
  {
    this.posicion = posicion;
  }
}