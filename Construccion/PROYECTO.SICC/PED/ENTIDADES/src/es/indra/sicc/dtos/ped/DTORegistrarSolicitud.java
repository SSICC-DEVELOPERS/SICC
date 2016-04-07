package es.indra.sicc.dtos.ped;
import es.indra.sicc.cmn.negocio.auditoria.DTOAuditableSICC;

public class DTORegistrarSolicitud extends DTOAuditableSICC {

    private String cliente;
    private Long oidCliente;
    private Long subgerenciaVentas;
    private Long region;
    private Long zona;
    private Long lote;
    private Boolean ok;

  public String getCliente()
  {
    return cliente;
  }

  public void setCliente(String cliente)
  {
    this.cliente = cliente;
  }

  public Long getLote()
  {
    return lote;
  }

  public void setLote(Long lote)
  {
    this.lote = lote;
  }

  public Long getOidCliente()
  {
    return oidCliente;
  }

  public void setOidCliente(Long oidCliente)
  {
    this.oidCliente = oidCliente;
  }

  public Boolean getOk()
  {
    return ok;
  }

  public void setOk(Boolean ok)
  {
    this.ok = ok;
  }

  public Long getRegion()
  {
    return region;
  }

  public void setRegion(Long region)
  {
    this.region = region;
  }

  public Long getSubgerenciaVentas()
  {
    return subgerenciaVentas;
  }

  public void setSubgerenciaVentas(Long subgerenciaVentas)
  {
    this.subgerenciaVentas = subgerenciaVentas;
  }

  public Long getZona()
  {
    return zona;
  }

  public void setZona(Long zona)
  {
    this.zona = zona;
  }

}