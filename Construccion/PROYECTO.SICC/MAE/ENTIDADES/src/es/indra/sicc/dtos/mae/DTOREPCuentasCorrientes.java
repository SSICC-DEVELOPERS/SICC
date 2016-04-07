package es.indra.sicc.dtos.mae;
import es.indra.sicc.cmn.negocio.auditoria.DTOAuditableSICC;
import java.math.BigDecimal;

public class DTOREPCuentasCorrientes extends DTOAuditableSICC 
{
  private BigDecimal saldoActual;
  private Integer nroVecesProntoPago;
  private Integer nroVecesRecargoFinanciero;
  private Long promedioDiasMora;
  private Long valorTotalMora;
  private Long porcDeFactura;

  public DTOREPCuentasCorrientes()
  {
  }

  public BigDecimal getSaldoActual()
  {
    return saldoActual;
  }

  public void setSaldoActual(BigDecimal saldoActual)
  {
    this.saldoActual = saldoActual;
  }

  public Integer getNroVecesProntoPago()
  {
    return nroVecesProntoPago;
  }

  public void setNroVecesProntoPago(Integer nroVecesProntoPago)
  {
    this.nroVecesProntoPago = nroVecesProntoPago;
  }

  public Integer getNroVecesRecargoFinanciero()
  {
    return nroVecesRecargoFinanciero;
  }

  public void setNroVecesRecargoFinanciero(Integer nroVecesRecargoFinanciero)
  {
    this.nroVecesRecargoFinanciero = nroVecesRecargoFinanciero;
  }

  public Long getPromedioDiasMora()
  {
    return promedioDiasMora;
  }

  public void setPromedioDiasMora(Long promedioDiasMora)
  {
    this.promedioDiasMora = promedioDiasMora;
  }

  public Long getValorTotalMora()
  {
    return valorTotalMora;
  }

  public void setValorTotalMora(Long valorTotalMora)
  {
    this.valorTotalMora = valorTotalMora;
  }

  public Long getPorcDeFactura()
  {
    return porcDeFactura;
  }

  public void setPorcDeFactura(Long porcDeFactura)
  {
    this.porcDeFactura = porcDeFactura;
  }
}