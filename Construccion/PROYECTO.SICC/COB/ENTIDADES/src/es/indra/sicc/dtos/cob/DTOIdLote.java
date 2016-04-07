package es.indra.sicc.dtos.cob;
import es.indra.sicc.cmn.negocio.auditoria.DTOSiccPaginacion;

public class DTOIdLote extends DTOSiccPaginacion
{
  private Long oidLote;

  public Long getOidLote()
  {
    return oidLote;
  }

  public void setOidLote(Long oidLote)
  {
    this.oidLote = oidLote;
  }


  
}