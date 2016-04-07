package es.indra.sicc.dtos.ped;
import es.indra.sicc.cmn.negocio.auditoria.DTOAuditableSICC;

public class DTOObtenerPosicionesVerificacion extends DTOAuditableSICC {
    private Long oidCabeceraSolicitud;
    private String posicionesVerificacion;

  public Long getOidCabeceraSolicitud()
  {
    return oidCabeceraSolicitud;
  }

  public void setOidCabeceraSolicitud(Long oidCabeceraSolicitud)
  {
    this.oidCabeceraSolicitud = oidCabeceraSolicitud;
  }

  public String getPosicionesVerificacion()
  {
    return posicionesVerificacion;
  }

  public void setPosicionesVerificacion(String posicionesVerificacion)
  {
    this.posicionesVerificacion = posicionesVerificacion;
  }
}