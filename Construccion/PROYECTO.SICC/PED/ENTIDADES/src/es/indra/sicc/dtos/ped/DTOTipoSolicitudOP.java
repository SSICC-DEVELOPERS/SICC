package es.indra.sicc.dtos.ped;
import es.indra.sicc.cmn.negocio.auditoria.DTOAuditableSICC;

public class DTOTipoSolicitudOP extends DTOAuditableSICC  {
  private Long oidTipoSolicitud;
  private Long oidTipoPosicion;
  private Long oidSubtipoPosicion;
  private Long oidMarca;
  private Long oidTipoCliente;
  private Long oidAcceso;
  private Long oidOperacion;

  public DTOTipoSolicitudOP() {

  }

  public Long getOidTipoSolicitud() {
    return oidTipoSolicitud;
  }

  public void setOidTipoSolicitud(Long newOidTipoSolicitud) {
    oidTipoSolicitud = newOidTipoSolicitud;
  }

  public Long getOidTipoPosicion() {
    return oidTipoPosicion;
  }

  public void setOidTipoPosicion(Long newOidTipoPosicion) {
    oidTipoPosicion = newOidTipoPosicion;
  }

  public Long getOidSubtipoPosicion() {
    return oidSubtipoPosicion;
  }

  public void setOidSubtipoPosicion(Long newOidSubtipoPosicion) {
    oidSubtipoPosicion = newOidSubtipoPosicion;
  }

  public Long getOidMarca() {
    return oidMarca;
  }

  public void setOidMarca(Long newOidMarca) {
    oidMarca = newOidMarca;
  }

  public Long getOidTipoCliente() {
    return oidTipoCliente;
  }

  public void setOidTipoCliente(Long newOidTipoCliente) {
    oidTipoCliente = newOidTipoCliente;
  }

  public Long getOidAcceso() {
    return oidAcceso;
  }

  public void setOidAcceso(Long newOidAcceso) {
    oidAcceso = newOidAcceso;
  }

  public Long getOidOperacion()
  {
    return oidOperacion;
  }

  public void setOidOperacion(Long oidOperacion)
  {
    this.oidOperacion = oidOperacion;
  }


}