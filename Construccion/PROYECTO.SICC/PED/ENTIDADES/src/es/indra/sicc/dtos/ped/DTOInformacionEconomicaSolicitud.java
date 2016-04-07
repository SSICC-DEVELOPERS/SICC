package es.indra.sicc.dtos.ped;
import es.indra.sicc.cmn.negocio.auditoria.DTOAuditableSICC;
import java.math.BigDecimal;

public class DTOInformacionEconomicaSolicitud extends DTOAuditableSICC {

    private Long oidMoneda;
    private String moneda;
    private BigDecimal montoDescuento1;
    private BigDecimal montoDescuento2;
    private BigDecimal montoDescuento3;
    private BigDecimal fletePagar;
    private BigDecimal totalImpuestos;
    private BigDecimal totalPagar;


  public void setMoneda(String moneda)
  {
    this.moneda = moneda;
  }


  public String getMoneda()
  {
    return moneda;
  }


  public void setMontoDescuento1(BigDecimal montoDescuento1)
  {
    this.montoDescuento1 = montoDescuento1;
  }


  public BigDecimal getMontoDescuento1()
  {
    return montoDescuento1;
  }


  public void setMontoDescuento2(BigDecimal montoDescuento2)
  {
    this.montoDescuento2 = montoDescuento2;
  }


  public BigDecimal getMontoDescuento2()
  {
    return montoDescuento2;
  }


  public void setMontoDescuento3(BigDecimal montoDescuento3)
  {
    this.montoDescuento3 = montoDescuento3;
  }


  public BigDecimal getMontoDescuento3()
  {
    return montoDescuento3;
  }


  public void setFletePagar(BigDecimal fletePagar)
  {
    this.fletePagar = fletePagar;
  }


  public BigDecimal getFletePagar()
  {
    return fletePagar;
  }


  public void setTotalImpuestos(BigDecimal totalImpuestos)
  {
    this.totalImpuestos = totalImpuestos;
  }


  public BigDecimal getTotalImpuestos()
  {
    return totalImpuestos;
  }


  public void setTotalPagar(BigDecimal totalPagar)
  {
    this.totalPagar = totalPagar;
  }


  public BigDecimal getTotalPagar()
  {
    return totalPagar;
  }


  public void setOidMoneda(Long oidMoneda)
  {
    this.oidMoneda = oidMoneda;
  }


  public Long getOidMoneda()
  {
    return oidMoneda;
  }

}