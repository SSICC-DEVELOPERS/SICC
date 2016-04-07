package es.indra.sicc.dtos.cob;
import es.indra.sicc.cmn.negocio.auditoria.DTOSiccPaginacion;


public class DTOBuscarGestionesDeCobranza extends DTOSiccPaginacion
{

  Long usuarioCobranzas;
  Long marca;
  Long canal;
  Long periodo;
  Long tipoCargo;
  Long oidCliente;
  Long codigoCliente;
  Long subgerenciaVentas;
  Long region;
  Long zona;
  Long seccion;
  Long territorio;
  private Long etapaDeuda;
  private String codCliente;

  public DTOBuscarGestionesDeCobranza()
  {
  }

  public Long getUsuarioCobranzas()
  {
    return usuarioCobranzas;
  }

  public void setUsuarioCobranzas(Long usuarioCobranzas)
  {
    this.usuarioCobranzas = usuarioCobranzas;
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

  public Long getTipoCargo()
  {
    return tipoCargo;
  }

  public void setTipoCargo(Long tipoCargo)
  {
    this.tipoCargo = tipoCargo;
  }

  public Long getOidCliente()
  {
    return oidCliente;
  }

  public void setOidCliente(Long oidCliente)
  {
    this.oidCliente = oidCliente;
  }

  public Long getCodigoCliente()
  {
    return codigoCliente;
  }

  public void setCodigoCliente(Long codigoCliente)
  {
    this.codigoCliente = codigoCliente;
  }

  public Long getSubgerenciaVentas()
  {
    return subgerenciaVentas;
  }

  public void setSubgerenciaVentas(Long subgerenciaVentas)
  {
    this.subgerenciaVentas = subgerenciaVentas;
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

  public Long getTerritorio()
  {
    return territorio;
  }

  public void setTerritorio(Long territorio)
  {
    this.territorio = territorio;
  }

  public Long getEtapaDeuda()
  {
    return etapaDeuda;
  }

  public void setEtapaDeuda(Long etapaDeuda)
  {
    this.etapaDeuda = etapaDeuda;
  }

  public String getCodCliente()
  {
    return codCliente;
  }

  public void setCodCliente(String codCliente)
  {
    this.codCliente = codCliente;
  }












































































  
  
}