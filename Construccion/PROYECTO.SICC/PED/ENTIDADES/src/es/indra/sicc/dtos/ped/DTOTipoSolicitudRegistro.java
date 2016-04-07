package es.indra.sicc.dtos.ped;
import es.indra.sicc.cmn.negocio.auditoria.DTOAuditableSICC;

public class DTOTipoSolicitudRegistro extends DTOAuditableSICC {

  private Long oidMarca;
  private Long oidCanal;
  private Long numeroSolicitudesLote;
  private Long oidTipoSolicitudPais;
  private Long numeroLote;

  public Long getNumeroLote()
  {
    return numeroLote;
  }

  public void setNumeroLote(Long numeroLote)
  {
    this.numeroLote = numeroLote;
  }

  public Long getNumeroSolicitudesLote()
  {
    return numeroSolicitudesLote;
  }

  public void setNumeroSolicitudesLote(Long numeroSolicitudesLote)
  {
    this.numeroSolicitudesLote = numeroSolicitudesLote;
  }

  public Long getOidCanal()
  {
    return oidCanal;
  }

  public void setOidCanal(Long oidCanal)
  {
    this.oidCanal = oidCanal;
  }

  public Long getOidMarca()
  {
    return oidMarca;
  }

  public void setOidMarca(Long oidMarca)
  {
    this.oidMarca = oidMarca;
  }

  public Long getOidTipoSolicitudPais()
  {
    return oidTipoSolicitudPais;
  }

  public void setOidTipoSolicitudPais(Long oidTipoSolicitudPais)
  {
    this.oidTipoSolicitudPais = oidTipoSolicitudPais;
  }
  
}