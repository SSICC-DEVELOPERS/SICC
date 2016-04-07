package es.indra.sicc.dtos.inc;
import es.indra.sicc.util.DTOBelcorp;
import java.math.BigDecimal;

public class DTOPagoMonetario extends DTOBelcorp {
  private Long oidPagoMonetario;
  private Integer numeroPago;
  private Long oidPeriodoControl;
  private String periodoControl;
  private BigDecimal premio;

  public DTOPagoMonetario() {
  }

  public Long getOidPagoMonetario() {
    return oidPagoMonetario;
  }

  public void setOidPagoMonetario(Long oidPagoMonetario) {
    this.oidPagoMonetario = oidPagoMonetario;
  }

  public Integer getNumeroPago() {
    return numeroPago;
  }

  public void setNumeroPago(Integer numeroPago) {
    this.numeroPago = numeroPago;
  }

  public Long getOidPeriodoControl() {
    return oidPeriodoControl;
  }

  public void setOidPeriodoControl(Long oidPeriodoControl) {
    this.oidPeriodoControl = oidPeriodoControl;
  }

  public String getPeriodoControl() {
    return periodoControl;
  }

  public void setPeriodoControl(String periodoControl) {
    this.periodoControl = periodoControl;
  }

  public BigDecimal getPremio() {
    return premio;
  }

  public void setPremio(BigDecimal premio) {
    this.premio = premio;
  }
}