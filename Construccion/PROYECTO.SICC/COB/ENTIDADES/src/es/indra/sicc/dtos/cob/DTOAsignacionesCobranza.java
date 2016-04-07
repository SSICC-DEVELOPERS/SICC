package es.indra.sicc.dtos.cob;
import es.indra.sicc.cmn.negocio.auditoria.DTOSiccPaginacion;
import java.math.BigDecimal;

public class DTOAsignacionesCobranza extends DTOSiccPaginacion 
{
  Long usuarioOrigen;
  Long usuarioDestino;
  Long etapaDeuda;
  Long marca;
  Long canal;
  Long periodo;
  Integer numeroClientes;
  Float porcentajeClientes;
  Long oidCliente;
  String codigoCliente;
  Long tipoCliente;
  Long subtipoCliente;
  Float porcentajeHasta;
  BigDecimal importeHasta;
  Long subgerencia;
  Long region;
  Long zona;
  Long seccion;
  String territorio;
  Boolean paginado;
  private Long ordenacion;

  public DTOAsignacionesCobranza()
  {
  }

  public Long getUsuarioOrigen()
  {
    return usuarioOrigen;
  }

  public void setUsuarioOrigen(Long usuarioOrigen)
  {
    this.usuarioOrigen = usuarioOrigen;
  }

  public Long getUsuarioDestino()
  {
    return usuarioDestino;
  }

  public void setUsuarioDestino(Long usuarioDestino)
  {
    this.usuarioDestino = usuarioDestino;
  }

  public Long getEtapaDeuda()
  {
    return etapaDeuda;
  }

  public void setEtapaDeuda(Long etapaDeuda)
  {
    this.etapaDeuda = etapaDeuda;
  }

  public Long getMarca()
  {
    return marca;
  }

  public void setMarca(Long marca)
  {
    this.marca = marca;
  }

  public Long getCanal()
  {
    return canal;
  }

  public void setCanal(Long canal)
  {
    this.canal = canal;
  }

  public Long getPeriodo()
  {
    return periodo;
  }

  public void setPeriodo(Long periodo)
  {
    this.periodo = periodo;
  }

  public Integer getNumeroClientes()
  {
    return numeroClientes;
  }

  public void setNumeroClientes(Integer numeroClientes)
  {
    this.numeroClientes = numeroClientes;
  }

  public Float getPorcentajeClientes()
  {
    return porcentajeClientes;
  }

  public void setPorcentajeClientes(Float porcentajeClientes)
  {
    this.porcentajeClientes = porcentajeClientes;
  }

  public Long getOidCliente()
  {
    return oidCliente;
  }

  public void setOidCliente(Long oidCliente)
  {
    this.oidCliente = oidCliente;
  }

  public String getCodigoCliente()
  {
    return codigoCliente;
  }

  public void setCodigoCliente(String codigoCliente)
  {
    this.codigoCliente = codigoCliente;
  }

  public Long getTipoCliente()
  {
    return tipoCliente;
  }

  public void setTipoCliente(Long tipoCliente)
  {
    this.tipoCliente = tipoCliente;
  }

  public Long getSubtipoCliente()
  {
    return subtipoCliente;
  }

  public void setSubtipoCliente(Long subtipoCliente)
  {
    this.subtipoCliente = subtipoCliente;
  }

  public Float getPorcentajeHasta()
  {
    return porcentajeHasta;
  }

  public void setPorcentajeHasta(Float porcentajeHasta)
  {
    this.porcentajeHasta = porcentajeHasta;
  }

  public BigDecimal getImporteHasta()
  {
    return importeHasta;
  }

  public void setImporteHasta(BigDecimal importeHasta)
  {
    this.importeHasta = importeHasta;
  }

  public Long getSubgerencia()
  {
    return subgerencia;
  }

  public void setSubgerencia(Long subgerencia)
  {
    this.subgerencia = subgerencia;
  }

  public Long getRegion()
  {
    return region;
  }

  public void setRegion(Long region)
  {
    this.region = region;
  }

  public Long getZona()
  {
    return zona;
  }

  public void setZona(Long zona)
  {
    this.zona = zona;
  }

  public Long getSeccion()
  {
    return seccion;
  }

  public void setSeccion(Long seccion)
  {
    this.seccion = seccion;
  }

  public String getTerritorio()
  {
    return territorio;
  }

  public void setTerritorio(String territorio)
  {
    this.territorio = territorio;
  }

  public Boolean getPaginado()
  {
    return paginado;
  }

  public void setPaginado(Boolean paginado)
  {
    this.paginado = paginado;
  }

  public Long getOrdenacion()
  {
    return ordenacion;
  }

  public void setOrdenacion(Long ordenacion)
  {
    this.ordenacion = ordenacion;
  }
}