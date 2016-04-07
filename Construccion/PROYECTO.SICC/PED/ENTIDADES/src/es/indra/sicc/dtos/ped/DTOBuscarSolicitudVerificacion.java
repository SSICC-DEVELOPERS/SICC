package es.indra.sicc.dtos.ped;
import es.indra.sicc.cmn.negocio.auditoria.DTOSiccPaginacion;

public class DTOBuscarSolicitudVerificacion extends DTOSiccPaginacion {

    private Long oidTipoSolicitud;
    private Long oidPeriodo;
    private Long oidCliente;
    private Long oidProceso;

  public Long getOidCliente()
  {
    return oidCliente;
  }

  public void setOidCliente(Long oidCliente)
  {
    this.oidCliente = oidCliente;
  }

  public Long getOidPeriodo()
  {
    return oidPeriodo;
  }

  public void setOidPeriodo(Long oidPeriodo)
  {
    this.oidPeriodo = oidPeriodo;
  }

  public Long getOidProceso()
  {
    return oidProceso;
  }

  public void setOidProceso(Long oidProceso)
  {
    this.oidProceso = oidProceso;
  }

  public Long getOidTipoSolicitud()
  {
    return oidTipoSolicitud;
  }

  public void setOidTipoSolicitud(Long oidTipoSolicitud)
  {
    this.oidTipoSolicitud = oidTipoSolicitud;
  }
}