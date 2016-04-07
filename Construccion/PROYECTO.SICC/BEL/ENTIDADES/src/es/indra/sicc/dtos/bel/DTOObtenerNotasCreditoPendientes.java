package es.indra.sicc.dtos.bel;

import es.indra.sicc.cmn.negocio.auditoria.DTOSiccPaginacion;

public class DTOObtenerNotasCreditoPendientes extends DTOSiccPaginacion
{
  private Long oidCliente;
  private Long oidSubacceso;

  public DTOObtenerNotasCreditoPendientes()
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

  public Long getOidSubacceso()
  {
    return oidSubacceso;
  }

  public void setOidSubacceso(Long oidSubacceso)
  {
    this.oidSubacceso = oidSubacceso;
  }
}