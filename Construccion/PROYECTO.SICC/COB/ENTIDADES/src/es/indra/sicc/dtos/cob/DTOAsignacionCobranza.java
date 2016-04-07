package es.indra.sicc.dtos.cob;
import java.math.BigDecimal;
import es.indra.sicc.util.DTOBelcorp;

public class DTOAsignacionCobranza extends DTOBelcorp
{
  private Long oidSociedad;
  private Long oidCobranza;
  private Long oidAcceso;
  private Long oidSubacceso;
  private BigDecimal importeDeudaAsignada;
  private Long nroIdentificadorCuota;
  private String ejercicioCuota;
  private Long nroOrdenCuota;
  private BigDecimal importeOriginal;
  private Long oidCuota;
  private BigDecimal importeDeudaCancelada;
  private Long oidEstado;
  private Long oidCliente;
  private Long oidEtapa;
  private Long oidClienteTipoSubtipo;

  public DTOAsignacionCobranza()
  {
  }

  public Long getOidSociedad()
  {
    return oidSociedad;
  }

  public void setOidSociedad(Long oidSociedad)
  {
    this.oidSociedad = oidSociedad;
  }

  public Long getOidCobranza()
  {
    return oidCobranza;
  }

  public void setOidCobranza(Long oidCobranza)
  {
    this.oidCobranza = oidCobranza;
  }

  public Long getOidAcceso()
  {
    return oidAcceso;
  }

  public void setOidAcceso(Long oidAcceso)
  {
    this.oidAcceso = oidAcceso;
  }

  public Long getOidSubacceso()
  {
    return oidSubacceso;
  }

  public void setOidSubacceso(Long oidSubacceso)
  {
    this.oidSubacceso = oidSubacceso;
  }

  public BigDecimal getImporteDeudaAsignada()
  {
    return importeDeudaAsignada;
  }

  public void setImporteDeudaAsignada(BigDecimal importeDeudaAsignada)
  {
    this.importeDeudaAsignada = importeDeudaAsignada;
  }

  public Long getNroIdentificadorCuota()
  {
    return nroIdentificadorCuota;
  }

  public void setNroIdentificadorCuota(Long nroIdentificadorCuota)
  {
    this.nroIdentificadorCuota = nroIdentificadorCuota;
  }

  public String getEjercicioCuota()
  {
    return ejercicioCuota;
  }

  public void setEjercicioCuota(String ejercicioCuota)
  {
    this.ejercicioCuota = ejercicioCuota;
  }

  public Long getNroOrdenCuota()
  {
    return nroOrdenCuota;
  }

  public void setNroOrdenCuota(Long nroOrdenCuota)
  {
    this.nroOrdenCuota = nroOrdenCuota;
  }

  public BigDecimal getImporteOriginal()
  {
    return importeOriginal;
  }

  public void setImporteOriginal(BigDecimal importeOriginal)
  {
    this.importeOriginal = importeOriginal;
  }

  public Long getOidCuota()
  {
    return oidCuota;
  }

  public void setOidCuota(Long oidCuota)
  {
    this.oidCuota = oidCuota;
  }

  public BigDecimal getImporteDeudaCancelada()
  {
    return importeDeudaCancelada;
  }

  public void setImporteDeudaCancelada(BigDecimal importeDeudaCancelada)
  {
    this.importeDeudaCancelada = importeDeudaCancelada;
  }

  public Long getOidEstado()
  {
    return oidEstado;
  }

  public void setOidEstado(Long oidEstado)
  {
    this.oidEstado = oidEstado;
  }

  public Long getOidCliente()
  {
    return oidCliente;
  }

  public void setOidCliente(Long oidCliente)
  {
    this.oidCliente = oidCliente;
  }

  public Long getOidEtapa()
  {
    return oidEtapa;
  }

  public void setOidEtapa(Long oidEtapa)
  {
    this.oidEtapa = oidEtapa;
  }

  public Long getOidClienteTipoSubtipo()
  {
    return oidClienteTipoSubtipo;
  }

  public void setOidClienteTipoSubtipo(Long oidClienteTipoSubtipo)
  {
    this.oidClienteTipoSubtipo = oidClienteTipoSubtipo;
  }
}