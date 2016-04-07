package es.indra.sicc.dtos.ccc;
import es.indra.sicc.cmn.negocio.auditoria.DTOAuditableSICC;

public class DTORepBusquedaCC extends DTOAuditableSICC  {
  private String codCliente;
  private Long   numeroCargo;
  
  
  public DTORepBusquedaCC() {
  }

  public String getCodCliente() {
    return codCliente;
  }

  public void setCodCliente(String codCliente) {
    this.codCliente = codCliente;
  }

  public Long getNumeroCargo() {
    return numeroCargo;
  }

  public void setNumeroCargo(Long numeroCargo) {
    this.numeroCargo = numeroCargo;
  }
}