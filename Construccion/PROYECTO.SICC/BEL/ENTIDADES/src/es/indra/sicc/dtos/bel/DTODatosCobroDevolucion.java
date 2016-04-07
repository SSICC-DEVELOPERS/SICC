package es.indra.sicc.dtos.bel;
import es.indra.sicc.cmn.negocio.auditoria.DTOAuditableSICC;
import java.math.BigDecimal;

public class DTODatosCobroDevolucion extends DTOAuditableSICC
{
  private DTOCargaMoneda moneda;
  private BigDecimal tipoCambio;
  private DTOCargaMedioPago[] medioPago;

  public DTODatosCobroDevolucion()
  {
  }

  public DTOCargaMoneda getMoneda()
  {
    return moneda;
  }

  public void setMoneda(DTOCargaMoneda moneda)
  {
    this.moneda = moneda;
  }

  public BigDecimal getTipoCambio()
  {
    return tipoCambio;
  }

  public void setTipoCambio(BigDecimal tipoCambio)
  {
    this.tipoCambio = tipoCambio;
  }

  public DTOCargaMedioPago[] getMedioPago()
  {
    return medioPago;
  }

  public void setMedioPago(DTOCargaMedioPago[] medioPago)
  {
    this.medioPago = medioPago;
  }
}