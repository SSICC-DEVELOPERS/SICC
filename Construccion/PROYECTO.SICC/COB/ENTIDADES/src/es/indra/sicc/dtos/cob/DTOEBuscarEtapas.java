package es.indra.sicc.dtos.cob;
import es.indra.sicc.cmn.negocio.auditoria.DTOAuditableSICC;

public class DTOEBuscarEtapas extends DTOAuditableSICC 
{
  Long marca;
  Long canal;
  Long periodo;

  public DTOEBuscarEtapas()
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
}