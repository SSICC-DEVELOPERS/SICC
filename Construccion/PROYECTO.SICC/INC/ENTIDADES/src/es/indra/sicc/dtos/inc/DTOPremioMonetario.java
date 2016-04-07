package es.indra.sicc.dtos.inc;
import es.indra.sicc.util.DTOBelcorp;
import java.math.BigDecimal;
import java.util.ArrayList;

public class DTOPremioMonetario extends DTOBelcorp {
  private Long oidPremioMonetario;
  private Integer numeroPremio;
  private Long oidTipoPremioMonetario;
  private BigDecimal cantidad;
  private BigDecimal porcentaje;
  private Long oidMoneda;
  private Long oidFormaPago;
  private Boolean indPagoPartes;
  private Long oidCumplimiento;
  private Boolean indDescontarPagosAnticipados;
  private ArrayList lstPagosMonetarios;

  public DTOPremioMonetario() {
  }

  public Long getOidPremioMonetario() {
    return oidPremioMonetario;
  }

  public void setOidPremioMonetario(Long oidPremioMonetario) {
    this.oidPremioMonetario = oidPremioMonetario;
  }

  public Integer getNumeroPremio() {
    return numeroPremio;
  }

  public void setNumeroPremio(Integer numeroPremio) {
    this.numeroPremio = numeroPremio;
  }

  public Long getOidTipoPremioMonetario() {
    return oidTipoPremioMonetario;
  }

  public void setOidTipoPremioMonetario(Long oidTipoPremioMonetario) {
    this.oidTipoPremioMonetario = oidTipoPremioMonetario;
  }

  public BigDecimal getCantidad() {
    return cantidad;
  }

  public void setCantidad(BigDecimal cantidad) {
    this.cantidad = cantidad;
  }

  public BigDecimal getPorcentaje() {
    return porcentaje;
  }

  public void setPorcentaje(BigDecimal porcentaje) {
    this.porcentaje = porcentaje;
  }

  public Long getOidMoneda() {
    return oidMoneda;
  }

  public void setOidMoneda(Long oidMoneda) {
    this.oidMoneda = oidMoneda;
  }

  public Long getOidFormaPago() {
    return oidFormaPago;
  }

  public void setOidFormaPago(Long oidFormaPago) {
    this.oidFormaPago = oidFormaPago;
  }

  public Boolean getIndPagoPartes() {
    return indPagoPartes;
  }

  public void setIndPagoPartes(Boolean indPagoPartes) {
    this.indPagoPartes = indPagoPartes;
  }

  public Long getOidCumplimiento() {
    return oidCumplimiento;
  }

  public void setOidCumplimiento(Long oidCumplimiento) {
    this.oidCumplimiento = oidCumplimiento;
  }

  public Boolean getIndDescontarPagosAnticipados() {
    return indDescontarPagosAnticipados;
  }

  public void setIndDescontarPagosAnticipados(Boolean indDescontarPagosAnticipados) {
    this.indDescontarPagosAnticipados = indDescontarPagosAnticipados;
  }

  public ArrayList getLstPagosMonetarios() {
    return lstPagosMonetarios;
  }

  public void setLstPagosMonetarios(ArrayList lstPagosMonetarios) {
    this.lstPagosMonetarios = lstPagosMonetarios;
  }
}