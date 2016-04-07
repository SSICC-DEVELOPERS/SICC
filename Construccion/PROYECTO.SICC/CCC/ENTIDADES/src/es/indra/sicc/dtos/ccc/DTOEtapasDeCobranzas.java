package es.indra.sicc.dtos.ccc;
import es.indra.sicc.cmn.negocio.auditoria.DTOAuditableSICC;
import java.math.BigDecimal;

public class DTOEtapasDeCobranzas extends DTOAuditableSICC 
{
  Integer edadInicial;
  Integer edadFinal;
  BigDecimal importeDesde;
  BigDecimal importeHasta;
  Long tipoBalanceo;
  Boolean telefono;
  Long oidCronoCobra;
  Long oidMarca;
  Long oidSeccion;
  Long oidSubgerenciaVentas;
  Long oidTerritorio;
  Long oidZona;
  Long oidRegion;
  Long oidTipoCargoAbono;
  Long oidCanal;
  Long oidPeriodoOrigen;
  Long oidAcceso;
  private Long oidEtapa;

  public DTOEtapasDeCobranzas()
  {
  }

  public Integer getEdadInicial()
  {
    return edadInicial;
  }

  public void setEdadInicial(Integer edadInicial)
  {
    this.edadInicial = edadInicial;
  }

  public Integer getEdadFinal()
  {
    return edadFinal;
  }

  public void setEdadFinal(Integer edadFinal)
  {
    this.edadFinal = edadFinal;
  }

  public BigDecimal getImporteDesde()
  {
    return importeDesde;
  }

  public void setImporteDesde(BigDecimal importeDesde)
  {
    this.importeDesde = importeDesde;
  }

  public BigDecimal getImporteHasta()
  {
    return importeHasta;
  }

  public void setImporteHasta(BigDecimal importeHasta)
  {
    this.importeHasta = importeHasta;
  }

  public Long getTipoBalanceo()
  {
    return tipoBalanceo;
  }

  public void setTipoBalanceo(Long tipoBalanceo)
  {
    this.tipoBalanceo = tipoBalanceo;
  }

  public Boolean getTelefono()
  {
    return telefono;
  }

  public void setTelefono(Boolean telefono)
  {
    this.telefono = telefono;
  }

  public Long getOidCronoCobra()
  {
    return oidCronoCobra;
  }

  public void setOidCronoCobra(Long oidCronoCobra)
  {
    this.oidCronoCobra = oidCronoCobra;
  }

  public Long getOidMarca()
  {
    return oidMarca;
  }

  public void setOidMarca(Long oidMarca)
  {
    this.oidMarca = oidMarca;
  }

  public Long getOidSeccion()
  {
    return oidSeccion;
  }

  public void setOidSeccion(Long oidSeccion)
  {
    this.oidSeccion = oidSeccion;
  }

  public Long getOidSubgerenciaVentas()
  {
    return oidSubgerenciaVentas;
  }

  public void setOidSubgerenciaVentas(Long oidSubgerenciaVentas)
  {
    this.oidSubgerenciaVentas = oidSubgerenciaVentas;
  }

  public Long getOidTerritorio()
  {
    return oidTerritorio;
  }

  public void setOidTerritorio(Long oidTerritorio)
  {
    this.oidTerritorio = oidTerritorio;
  }

  public Long getOidZona()
  {
    return oidZona;
  }

  public void setOidZona(Long oidZona)
  {
    this.oidZona = oidZona;
  }

  public Long getOidRegion()
  {
    return oidRegion;
  }

  public void setOidRegion(Long oidRegion)
  {
    this.oidRegion = oidRegion;
  }

  public Long getOidTipoCargoAbono()
  {
    return oidTipoCargoAbono;
  }

  public void setOidTipoCargoAbono(Long oidTipoCargoAbono)
  {
    this.oidTipoCargoAbono = oidTipoCargoAbono;
  }

  public Long getOidCanal()
  {
    return oidCanal;
  }

  public void setOidCanal(Long oidCanal)
  {
    this.oidCanal = oidCanal;
  }

  public Long getOidPeriodoOrigen()
  {
    return oidPeriodoOrigen;
  }

  public void setOidPeriodoOrigen(Long oidPeriodoOrigen)
  {
    this.oidPeriodoOrigen = oidPeriodoOrigen;
  }

  public Long getOidAcceso()
  {
    return oidAcceso;
  }

  public void setOidAcceso(Long oidAcceso)
  {
    this.oidAcceso = oidAcceso;
  }

  public Long getOidEtapa()
  {
    return oidEtapa;
  }

  public void setOidEtapa(Long oidEtapa)
  {
    this.oidEtapa = oidEtapa;
  }
}