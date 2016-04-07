package es.indra.sicc.dtos.mae;
import es.indra.sicc.cmn.negocio.auditoria.DTOAuditableSICC;

public class DTOGenerarCodigoCliente extends DTOAuditableSICC 
{
  private String codigoCliente;
  private String digitoControl;

  public DTOGenerarCodigoCliente()
  {
  }

  public String getCodigoCliente()
  {
    return codigoCliente;
  }

  public void setCodigoCliente(String codigoCliente)
  {
    this.codigoCliente = codigoCliente;
  }

  public String getDigitoControl()
  {
    return digitoControl;
  }

  public void setDigitoControl(String digitoControl)
  {
    this.digitoControl = digitoControl;
  }
}