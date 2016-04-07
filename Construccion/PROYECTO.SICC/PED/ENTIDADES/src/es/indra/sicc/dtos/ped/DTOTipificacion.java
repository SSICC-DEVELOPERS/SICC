package es.indra.sicc.dtos.ped;
import es.indra.sicc.cmn.negocio.auditoria.DTOAuditableSICC;

public class DTOTipificacion extends DTOAuditableSICC  {
  private Long orden;
  private Long oidTipoCliente;
  private Long oidSubtipoCliente;
  private Long oidTipoClasificacion;
  private Long oidClasificacion;

  public DTOTipificacion() {
  }

  public Long getOrden() {
    return orden;
  }

  public void setOrden(Long newOrden) {
    orden = newOrden;
  }

  public Long getOidTipoCliente() {
    return oidTipoCliente;
  }

  public void setOidTipoCliente(Long newOidTipoCliente) {
    oidTipoCliente = newOidTipoCliente;
  }

  public Long getOidSubtipoCliente() {
    return oidSubtipoCliente;
  }

  public void setOidSubtipoCliente(Long newOidSubtipoCliente) {
    oidSubtipoCliente = newOidSubtipoCliente;
  }

  public Long getOidTipoClasificacion() {
    return oidTipoClasificacion;
  }

  public void setOidTipoClasificacion(Long newOidTipoClasificacion) {
    oidTipoClasificacion = newOidTipoClasificacion;
  }

  public Long getOidClasificacion() {
    return oidClasificacion;
  }

  public void setOidClasificacion(Long newOidClasificacion) {
    oidClasificacion = newOidClasificacion;
  }
}