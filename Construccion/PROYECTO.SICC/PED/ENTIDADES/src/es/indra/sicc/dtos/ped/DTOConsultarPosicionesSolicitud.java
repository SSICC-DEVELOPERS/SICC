package es.indra.sicc.dtos.ped;
import es.indra.sicc.cmn.negocio.auditoria.DTOSiccPaginacion;

public class DTOConsultarPosicionesSolicitud extends DTOSiccPaginacion {

    private Long oidCabeceraSolicitud;
    private Long oidTipoInformacion;


  public void setOidCabeceraSolicitud(Long oidCabeceraSolicitud)
  {
    this.oidCabeceraSolicitud = oidCabeceraSolicitud;
  }


  public Long getOidCabeceraSolicitud()
  {
    return oidCabeceraSolicitud;
  }


  public void setOidTipoInformacion(Long oidTipoInformacion)
  {
    this.oidTipoInformacion = oidTipoInformacion;
  }


  public Long getOidTipoInformacion()
  {
    return oidTipoInformacion;
  }
    
    
}