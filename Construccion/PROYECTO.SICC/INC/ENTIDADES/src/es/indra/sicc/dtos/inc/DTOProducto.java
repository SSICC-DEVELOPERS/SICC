package es.indra.sicc.dtos.inc;
import es.indra.sicc.util.DTOBelcorp;
import java.util.ArrayList;

public class DTOProducto extends DTOBelcorp 
{
  private Long oidTipoProducto;
  private Long oidMarcaProducto;
  private Long oidUnidadNegocio;
  private Long oidNegocio;
  private Long oidSupergenerico;
  private Long oidGenerico;
  private Long oidTipoOferta;
  private Long oidCicloVida;
  private Long oidProducto;
  private String codigoProducto;
  private Long oidPeriodoDesde;
  private Long oidPeriodoHasta;
  private Integer puntosUnidad;
  private Integer factorMultiplicidad;
  private Integer unidadesExigidas;
  private Double montoExigido;
  private Integer puntosExigidos;
  private ArrayList lstProductos;
  private Boolean indComunicacion;
  private String codigoMensaje;

  public Long getOidTipoProducto()
  {
    return oidTipoProducto;
  }

  public void setOidTipoProducto(Long oidTipoProducto)
  {
    this.oidTipoProducto = oidTipoProducto;
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

  public Long getOidProducto()
  {
    return oidProducto;
  }

  public void setOidProducto(Long oidProducto)
  {
    this.oidProducto = oidProducto;
  }

  public String getCodigoProducto()
  {
    return codigoProducto;
  }

  public void setCodigoProducto(String codigoProducto)
  {
    this.codigoProducto = codigoProducto;
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

  public Double getMontoExigido()
  {
    return montoExigido;
  }

  public void setMontoExigido(Double montoExigido)
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

  public ArrayList getLstProductos()
  {
    return lstProductos;
  }

  public void setLstProductos(ArrayList lstProductos)
  {
    this.lstProductos = lstProductos;
  }

  public Boolean getIndComunicacion()
  {
    return indComunicacion;
  }

  public void setIndComunicacion(Boolean indComunicacion)
  {
    this.indComunicacion = indComunicacion;
  }

  public String getCodigoMensaje()
  {
    return codigoMensaje;
  }

  public void setCodigoMensaje(String codigoMensaje)
  {
    this.codigoMensaje = codigoMensaje;
  } 
  
}