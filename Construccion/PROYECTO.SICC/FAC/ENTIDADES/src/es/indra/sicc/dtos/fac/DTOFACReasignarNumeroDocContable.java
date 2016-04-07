package es.indra.sicc.dtos.fac;
import es.indra.sicc.util.DTOBelcorp;

public class DTOFACReasignarNumeroDocContable extends DTOBelcorp
{
  private Long oidTipoDocContable;
  private Long oidCanal;
  private Long oidAcceso;
  private Long oidSubAcceso;
  private Long ejercicio;
  private Long rangoDocInternoDesde;
  private Long rangoDocInternoHasta;
  private String serieDocLegal;
  private Long rangoDocLegalDesde;
  private Long rangoDocLegalHasta;
  // Agregado por HRCS - Fecha 30/05/2007 - Cambio Sicc20070258
  private Long cantidadDocumentosImpresos;
  private Long cantidadDocumentosNoImpresos;
  private Long numeroRegistrosNoNulos;

  public DTOFACReasignarNumeroDocContable()
  {
  }

  public Long getOidTipoDocContable()
  {
    return oidTipoDocContable;
  }

  public void setOidTipoDocContable(Long oidTipoDocContable)
  {
    this.oidTipoDocContable = oidTipoDocContable;
  }

  public Long getOidCanal()
  {
    return oidCanal;
  }

  public void setOidCanal(Long oidCanal)
  {
    this.oidCanal = oidCanal;
  }

  public Long getOidAcceso()
  {
    return oidAcceso;
  }

  public void setOidAcceso(Long oidAcceso)
  {
    this.oidAcceso = oidAcceso;
  }

  public Long getOidSubAcceso()
  {
    return oidSubAcceso;
  }

  public void setOidSubAcceso(Long oidSubAcceso)
  {
    this.oidSubAcceso = oidSubAcceso;
  }

  public Long getEjercicio()
  {
    return ejercicio;
  }

  public void setEjercicio(Long ejercicio)
  {
    this.ejercicio = ejercicio;
  }

  public Long getRangoDocInternoDesde()
  {
    return rangoDocInternoDesde;
  }

  public void setRangoDocInternoDesde(Long rangoDocInternoDesde)
  {
    this.rangoDocInternoDesde = rangoDocInternoDesde;
  }

  public Long getRangoDocInternoHasta()
  {
    return rangoDocInternoHasta;
  }

  public void setRangoDocInternoHasta(Long rangoDocInternoHasta)
  {
    this.rangoDocInternoHasta = rangoDocInternoHasta;
  }

  public String getSerieDocLegal()
  {
    return serieDocLegal;
  }

  public void setSerieDocLegal(String serieDocLegal)
  {
    this.serieDocLegal = serieDocLegal;
  }

  public Long getRangoDocLegalDesde()
  {
    return rangoDocLegalDesde;
  }

  public void setRangoDocLegalDesde(Long rangoDocLegalDesde)
  {
    this.rangoDocLegalDesde = rangoDocLegalDesde;
  }

  public Long getRangoDocLegalHasta()
  {
    return rangoDocLegalHasta;
  }

  public void setRangoDocLegalHasta(Long rangoDocLegalHasta)
  {
    this.rangoDocLegalHasta = rangoDocLegalHasta;
  }


    public void setCantidadDocumentosImpresos(Long cantidadDocumentosImpresos) {
        this.cantidadDocumentosImpresos = cantidadDocumentosImpresos;
    }


    public Long getCantidadDocumentosImpresos() {
        return cantidadDocumentosImpresos;
    }


    public void setCantidadDocumentosNoImpresos(Long cantidadDocumentosNoImpresos) {
        this.cantidadDocumentosNoImpresos = cantidadDocumentosNoImpresos;
    }


    public Long getCantidadDocumentosNoImpresos() {
        return cantidadDocumentosNoImpresos;
    }


    public void setNumeroRegistrosNoNulos(Long numeroRegistrosNoNulos) {
        this.numeroRegistrosNoNulos = numeroRegistrosNoNulos;
    }


    public Long getNumeroRegistrosNoNulos() {
        return numeroRegistrosNoNulos;
    }
}