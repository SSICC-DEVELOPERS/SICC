package es.indra.sicc.bel.applet.util;

import java.math.BigDecimal;

public class DetalleCobroDevolucion 
{
  private String medioPago;
  private String moneda;
  private BigDecimal importe;
  private BigDecimal importeDivisa;
  private String tipoCambio;
  private String banco;
  private String numeroCheque;
  private String tipoTarjeta;
  private String numeroTarjeta;
  private String numeroValeCompra;
  private String numeroNotaCredito;

  public Boolean isEmpty(){
    if( (medioPago == null || medioPago.trim().equals("")) &&
        (moneda == null || moneda.trim().equals("")) &&
        importe == null &&
        importeDivisa == null &&
        (tipoCambio == null || tipoCambio.trim().equals("")) &&
        (banco == null || banco.trim().equals("")) &&
        (numeroCheque == null || numeroCheque.trim().equals("")) &&
        (tipoTarjeta == null || tipoTarjeta.trim().equals("")) &&
        (numeroTarjeta == null || numeroTarjeta.trim().equals("")) &&
        (numeroValeCompra == null || numeroValeCompra.trim().equals("")) &&
        (numeroNotaCredito == null || numeroNotaCredito.trim().equals(""))) {
      return Boolean.TRUE;
    } else {
      return Boolean.FALSE;
    }
  }

  public String getMedioPago()
  {
    return medioPago;
  }

  public void setMedioPago(String medioPago)
  {
    this.medioPago = medioPago;
  }

  public String getMoneda()
  {
    return moneda;
  }

  public void setMoneda(String moneda)
  {
    this.moneda = moneda;
  }

  public BigDecimal getImporte()
  {
    return importe;
  }

  public void setImporte(BigDecimal importe)
  {
    this.importe = importe;
  }

  public BigDecimal getImporteDivisa()
  {
    return importeDivisa;
  }

  public void setImporteDivisa(BigDecimal importeDivisa)
  {
    this.importeDivisa = importeDivisa;
  }

  public String getTipoCambio()
  {
    return tipoCambio;
  }

  public void setTipoCambio(String tipoCambio)
  {
    this.tipoCambio = tipoCambio;
  }

  public String getBanco()
  {
    return banco;
  }

  public void setBanco(String banco)
  {
    this.banco = banco;
  }

  public String getNumeroCheque()
  {
    return numeroCheque;
  }

  public void setNumeroCheque(String numeroCheque)
  {
    this.numeroCheque = numeroCheque;
  }

  public String getTipoTarjeta()
  {
    return tipoTarjeta;
  }

  public void setTipoTarjeta(String tipoTarjeta)
  {
    this.tipoTarjeta = tipoTarjeta;
  }

  public String getNumeroTarjeta()
  {
    return numeroTarjeta;
  }

  public void setNumeroTarjeta(String numeroTarjeta)
  {
    this.numeroTarjeta = numeroTarjeta;
  }

  public String getNumeroValeCompra()
  {
    return numeroValeCompra;
  }

  public void setNumeroValeCompra(String numeroValeCompra)
  {
    this.numeroValeCompra = numeroValeCompra;
  }

  public String getNumeroNotaCredito()
  {
    return numeroNotaCredito;
  }

  public void setNumeroNotaCredito(String numeroNotaCredito)
  {
    this.numeroNotaCredito = numeroNotaCredito;
  }
}