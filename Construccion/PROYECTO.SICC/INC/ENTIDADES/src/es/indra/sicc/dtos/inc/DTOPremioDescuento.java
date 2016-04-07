package es.indra.sicc.dtos.inc;
import es.indra.sicc.util.DTOBelcorp;
import java.util.ArrayList;
import java.math.BigDecimal;

public class DTOPremioDescuento  extends DTOBelcorp {
  private Long oidPremioDescuento;
  private Long oidTipoDescuento;
  private BigDecimal cantidadDescuento;
  private BigDecimal porcentajeDescuento;
  private Long oidPeriodoAplicacionDesde;
  private Long oidPeriodoAplicacionHasta;
  private Integer numeroPremio;
  private ArrayList lstArticulos;

  public DTOPremioDescuento() {
  }

  public Long getOidPremioDescuento() {
    return oidPremioDescuento;
  }

  public void setOidPremioDescuento(Long oidPremioDescuento) {
    this.oidPremioDescuento = oidPremioDescuento;
  }

  public Long getOidTipoDescuento() {
    return oidTipoDescuento;
  }

  public void setOidTipoDescuento(Long oidTipoDescuento) {
    this.oidTipoDescuento = oidTipoDescuento;
  }

  public BigDecimal getCantidadDescuento() {
    return cantidadDescuento;
  }

  public void setCantidadDescuento(BigDecimal cantidadDescuento) {
    this.cantidadDescuento = cantidadDescuento;
  }

  public BigDecimal getPorcentajeDescuento() {
    return porcentajeDescuento;
  }

  public void setPorcentajeDescuento(BigDecimal porcentajeDescuento) {
    this.porcentajeDescuento = porcentajeDescuento;
  }

  public Long getOidPeriodoAplicacionDesde() {
    return oidPeriodoAplicacionDesde;
  }

  public void setOidPeriodoAplicacionDesde(Long oidPeriodoAplicacionDesde) {
    this.oidPeriodoAplicacionDesde = oidPeriodoAplicacionDesde;
  }

  public Long getOidPeriodoAplicacionHasta() {
    return oidPeriodoAplicacionHasta;
  }

  public void setOidPeriodoAplicacionHasta(Long oidPeriodoAplicacionHasta) {
    this.oidPeriodoAplicacionHasta = oidPeriodoAplicacionHasta;
  }

  public Integer getNumeroPremio() {
    return numeroPremio;
  }

  public void setNumeroPremio(Integer numeroPremio) {
    this.numeroPremio = numeroPremio;
  }

  public ArrayList getLstArticulos() {
    return lstArticulos;
  }

  public void setLstArticulos(ArrayList lstArticulos) {
    this.lstArticulos = lstArticulos;
  }
}