package es.indra.sicc.dtos.cob;
import es.indra.sicc.cmn.negocio.auditoria.DTOSiccPaginacion;

public class DTOConsultarResumenAsignacion extends DTOSiccPaginacion 
{
  Long oidUsuarioCobranza;
  String codigoCliente;

  public DTOConsultarResumenAsignacion()
  {
  }

  public Long getOidUsuarioCobranza()
  {
    return oidUsuarioCobranza;
  }

  public void setOidUsuarioCobranza(Long oidUsuarioCobranza)
  {
    this.oidUsuarioCobranza = oidUsuarioCobranza;
  }

  public String getCodigoCliente()
  {
    return codigoCliente;
  }

  public void setCodigoCliente(String codigoCliente)
  {
    this.codigoCliente = codigoCliente;
  }
}