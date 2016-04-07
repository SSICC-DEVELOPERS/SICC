package es.indra.sicc.dtos.cob;
import es.indra.sicc.cmn.negocio.auditoria.DTOSiccPaginacion;

public class DTOEBuscarCronogramaCOBPeriodo extends DTOSiccPaginacion 
{
  Long marca;
  Long canal;
  Long periodo;
  Boolean paginado;

  public DTOEBuscarCronogramaCOBPeriodo()
  {
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

  public Long getPeriodo()
  {
    return periodo;
  }

  public void setPeriodo(Long periodo)
  {
    this.periodo = periodo;
  }

  public Boolean getPaginado()
  {
    return paginado;
  }

  public void setPaginado(Boolean paginado)
  {
    this.paginado = paginado;
  }
}