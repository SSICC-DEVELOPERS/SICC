package es.indra.sicc.dtos.intsys;
import es.indra.sicc.util.DTOBelcorp;
import java.math.BigDecimal;

public class DTODatosCartera extends DTOBelcorp  {
  private String codCliente;
  private String codPeriodo;
  private Long numeroDocumento;
  private BigDecimal importePendiente;

  public DTODatosCartera() {
  }

  public String getCodCliente() {
    return codCliente;
  }

  public void setCodCliente(String codCliente) {
    this.codCliente = codCliente;
  }

  public String getCodPeriodo() {
    return codPeriodo;
  }

  public void setCodPeriodo(String codPeriodo) {
    this.codPeriodo = codPeriodo;
  }

  public Long getNumeroDocumento() {
    return numeroDocumento;
  }

  public void setNumeroDocumento(Long numeroDocumento) {
    this.numeroDocumento = numeroDocumento;
  }

  public BigDecimal getImportePendiente() {
    return importePendiente;
  }

  public void setImportePendiente(BigDecimal importePendiente) {
    this.importePendiente = importePendiente;
  }
}
