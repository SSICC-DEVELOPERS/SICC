package es.indra.sicc.dtos.intsys;
import java.math.BigDecimal;

public class DTODAT32 
{
  private String codigoZona;
  private BigDecimal montoDeudaPendiente;
  private BigDecimal totalCargosDirectos;
  private BigDecimal totalAjustesNC;
  private BigDecimal totalDepuraciones;
  private BigDecimal abonos21dias;
  private BigDecimal abonos31dias;
  private BigDecimal abonos42dias;
  private BigDecimal abonos63dias;
  private BigDecimal abonosMayores63dias;

  public DTODAT32()
  {
  }

  public String getCodigoZona()
  {
    return codigoZona;
  }

  public void setCodigoZona(String codigoZona)
  {
    this.codigoZona = codigoZona;
  }

  public BigDecimal getMontoDeudaPendiente()
  {
    return montoDeudaPendiente;
  }

  public void setMontoDeudaPendiente(BigDecimal montoDeudaPendiente)
  {
    this.montoDeudaPendiente = montoDeudaPendiente;
  }

  public BigDecimal getTotalCargosDirectos()
  {
    return totalCargosDirectos;
  }

  public void setTotalCargosDirectos(BigDecimal totalCargosDirectos)
  {
    this.totalCargosDirectos = totalCargosDirectos;
  }

  public BigDecimal getTotalAjustesNC()
  {
    return totalAjustesNC;
  }

  public void setTotalAjustesNC(BigDecimal totalAjustesNC)
  {
    this.totalAjustesNC = totalAjustesNC;
  }

  public BigDecimal getTotalDepuraciones()
  {
    return totalDepuraciones;
  }

  public void setTotalDepuraciones(BigDecimal totalDepuraciones)
  {
    this.totalDepuraciones = totalDepuraciones;
  }

  public BigDecimal getAbonos21dias()
  {
    return abonos21dias;
  }

  public void setAbonos21dias(BigDecimal abonos21dias)
  {
    this.abonos21dias = abonos21dias;
  }

  public BigDecimal getAbonos31dias()
  {
    return abonos31dias;
  }

  public void setAbonos31dias(BigDecimal abonos31dias)
  {
    this.abonos31dias = abonos31dias;
  }

  public BigDecimal getAbonos42dias()
  {
    return abonos42dias;
  }

  public void setAbonos42dias(BigDecimal abonos42dias)
  {
    this.abonos42dias = abonos42dias;
  }

  public BigDecimal getAbonos63dias()
  {
    return abonos63dias;
  }

  public void setAbonos63dias(BigDecimal abonos63dias)
  {
    this.abonos63dias = abonos63dias;
  }

  public BigDecimal getAbonosMayores63dias()
  {
    return abonosMayores63dias;
  }

  public void setAbonosMayores63dias(BigDecimal abonosMayores63dias)
  {
    this.abonosMayores63dias = abonosMayores63dias;
  }
}