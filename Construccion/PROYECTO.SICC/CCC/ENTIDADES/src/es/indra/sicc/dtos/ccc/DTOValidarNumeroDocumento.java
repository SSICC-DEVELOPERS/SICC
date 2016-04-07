package es.indra.sicc.dtos.ccc;
import es.indra.sicc.cmn.negocio.auditoria.DTOAuditableSICC;

public class DTOValidarNumeroDocumento extends DTOAuditableSICC 
{
  private Long numeroDocumento;
  private String codigoCliente;

  public DTOValidarNumeroDocumento()
  {
  }

  public Long getNumeroDocumento()
  {
    return numeroDocumento;
  }

  public void setNumeroDocumento(Long numeroDocumento)
  {
    this.numeroDocumento = numeroDocumento;
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