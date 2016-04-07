package es.indra.sicc.dtos.inc;
import es.indra.sicc.util.DTOBelcorp;
import java.math.BigDecimal;

public class DTOProdu extends DTOBelcorp 
{
  private Long oid;
  private Long oidMarcaProducto;
  private Long oidUnidadNegocio;
  private Long oidNegocio;
  private Long oidSupergenerico;
  private Long oidGenerico;
  private Long oidProducto;
  private Long oidTipoOferta;
  private Long oidCicloVida;
  private Long oidPeriodoDesde;
  private Long oidPeriodoHasta;
  private String marcaProducto;
  private String unidadNegocio;
  private String negocio;
  private String supergenerico;
  private String generico;
  private String tipoOferta;
  private String cicloVida;
  private String codigoProducto;
  private String periodoDesde;
  private String periodoHasta;
  private Integer puntosUnidad;
  private Integer factorMultiplicidad;
  private Integer unidadesExigidas;
  private BigDecimal montoExigido;
  private Integer puntosExigidos;
  
  // vbongiov -- Cambio 20080807 -- 15/04/2009
  private String indAgrup;
  private String codIndAgrup;

  public Long getOid()
  {
    return oid;
  }

  public void setOid(Long oid)
  {
    this.oid = oid;
  }

  public Long getOidMarcaProducto()
  {
    return oidMarcaProducto;
  }

  public void setOidMarcaProducto(Long oidMarcaProducto)
  {
    this.oidMarcaProducto = oidMarcaProducto;
  }

  public Long getOidUnidadNegocio()
  {
    return oidUnidadNegocio;
  }

  public void setOidUnidadNegocio(Long oidUnidadNegocio)
  {
    this.oidUnidadNegocio = oidUnidadNegocio;
  }

  public Long getOidNegocio()
  {
    return oidNegocio;
  }

  public void setOidNegocio(Long oidNegocio)
  {
    this.oidNegocio = oidNegocio;
  }

  public Long getOidSupergenerico()
  {
    return oidSupergenerico;
  }

  public void setOidSupergenerico(Long oidSupergenerico)
  {
    this.oidSupergenerico = oidSupergenerico;
  }

  public Long getOidGenerico()
  {
    return oidGenerico;
  }

  public void setOidGenerico(Long oidGenerico)
  {
    this.oidGenerico = oidGenerico;
  }

  public Long getOidProducto()
  {
    return oidProducto;
  }

  public void setOidProducto(Long oidProducto)
  {
    this.oidProducto = oidProducto;
  }

  public Long getOidTipoOferta()
  {
    return oidTipoOferta;
  }

  public void setOidTipoOferta(Long oidTipoOferta)
  {
    this.oidTipoOferta = oidTipoOferta;
  }

  public Long getOidCicloVida()
  {
    return oidCicloVida;
  }

  public void setOidCicloVida(Long oidCicloVida)
  {
    this.oidCicloVida = oidCicloVida;
  }

  public Long getOidPeriodoDesde()
  {
    return oidPeriodoDesde;
  }

  public void setOidPeriodoDesde(Long oidPeriodoDesde)
  {
    this.oidPeriodoDesde = oidPeriodoDesde;
  }

  public Long getOidPeriodoHasta()
  {
    return oidPeriodoHasta;
  }

  public void setOidPeriodoHasta(Long oidPeriodoHasta)
  {
    this.oidPeriodoHasta = oidPeriodoHasta;
  }

  public String getMarcaProducto()
  {
    return marcaProducto;
  }

  public void setMarcaProducto(String marcaProducto)
  {
    this.marcaProducto = marcaProducto;
  }

  public String getUnidadNegocio()
  {
    return unidadNegocio;
  }

  public void setUnidadNegocio(String unidadNegocio)
  {
    this.unidadNegocio = unidadNegocio;
  }

  public String getNegocio()
  {
    return negocio;
  }

  public void setNegocio(String negocio)
  {
    this.negocio = negocio;
  }

  public String getSupergenerico()
  {
    return supergenerico;
  }

  public void setSupergenerico(String supergenerico)
  {
    this.supergenerico = supergenerico;
  }

  public String getGenerico()
  {
    return generico;
  }

  public void setGenerico(String generico)
  {
    this.generico = generico;
  }

  public String getTipoOferta()
  {
    return tipoOferta;
  }

  public void setTipoOferta(String tipoOferta)
  {
    this.tipoOferta = tipoOferta;
  }

  public String getCicloVida()
  {
    return cicloVida;
  }

  public void setCicloVida(String cicloVida)
  {
    this.cicloVida = cicloVida;
  }

  public String getCodigoProducto()
  {
    return codigoProducto;
  }

  public void setCodigoProducto(String codigoProducto)
  {
    this.codigoProducto = codigoProducto;
  }

  public String getPeriodoDesde()
  {
    return periodoDesde;
  }

  public void setPeriodoDesde(String periodoDesde)
  {
    this.periodoDesde = periodoDesde;
  }

  public String getPeriodoHasta()
  {
    return periodoHasta;
  }

  public void setPeriodoHasta(String periodoHasta)
  {
    this.periodoHasta = periodoHasta;
  }

  public Integer getPuntosUnidad()
  {
    return puntosUnidad;
  }

  public void setPuntosUnidad(Integer puntosUnidad)
  {
    this.puntosUnidad = puntosUnidad;
  }

  public Integer getFactorMultiplicidad()
  {
    return factorMultiplicidad;
  }

  public void setFactorMultiplicidad(Integer factorMultiplicidad)
  {
    this.factorMultiplicidad = factorMultiplicidad;
  }

  public Integer getUnidadesExigidas()
  {
    return unidadesExigidas;
  }

  public void setUnidadesExigidas(Integer unidadesExigidas)
  {
    this.unidadesExigidas = unidadesExigidas;
  }

  public BigDecimal getMontoExigido()
  {
    return montoExigido;
  }

  public void setMontoExigido(BigDecimal montoExigido)
  {
    this.montoExigido = montoExigido;
  }

  public Integer getPuntosExigidos()
  {
    return puntosExigidos;
  }

  public void setPuntosExigidos(Integer puntosExigidos)
  {
    this.puntosExigidos = puntosExigidos;
  }
  
  public String getIndAgrup()
  {
    return indAgrup;
  }
      
  public void setIndAgrup(String indAgrup)
  {
    this.indAgrup = indAgrup;
  }
  
  public String getCodIndAgrup()
  {
    return codIndAgrup;  
  }
    
  public void setCodIndAgrup(String codIndAgrup)
  {
    this.codIndAgrup = codIndAgrup;
  }
}