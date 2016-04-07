package es.indra.sicc.dtos.ped;
import es.indra.sicc.cmn.negocio.auditoria.DTOAuditableSICC;

public class DTOInformacionSolicitud extends DTOAuditableSICC {

    private DTOInformacionBasicaSolicitud dtoInformacionBasicaSolicitud;
    private DTOInformacionClienteSolicitud dtoInformacionClienteSolicitud;
    private DTOInformacionAdministrativaSolicitud dtoInformacionAdministrativaSolicitud;
    private DTOInformacionEconomicaSolicitud dtoInformacionEconomicaSolicitud;
    private DTOInformacionEstadoSolicitud dtoInformacionEstadoSolicitud;
    private Long oidCabeceraSolicitud;


  public void setDtoInformacionBasicaSolicitud(DTOInformacionBasicaSolicitud dtoInformacionBasicaSolicitud)
  {
    this.dtoInformacionBasicaSolicitud = dtoInformacionBasicaSolicitud;
  }


  public DTOInformacionBasicaSolicitud getDtoInformacionBasicaSolicitud()
  {
    return dtoInformacionBasicaSolicitud;
  }


  public void setDtoInformacionClienteSolicitud(DTOInformacionClienteSolicitud dtoInformacionClienteSolicitud)
  {
    this.dtoInformacionClienteSolicitud = dtoInformacionClienteSolicitud;
  }


  public DTOInformacionClienteSolicitud getDtoInformacionClienteSolicitud()
  {
    return dtoInformacionClienteSolicitud;
  }


  public void setDtoInformacionAdministrativaSolicitud(DTOInformacionAdministrativaSolicitud dtoInformacionAdministrativaSolicitud)
  {
    this.dtoInformacionAdministrativaSolicitud = dtoInformacionAdministrativaSolicitud;
  }


  public DTOInformacionAdministrativaSolicitud getDtoInformacionAdministrativaSolicitud()
  {
    return dtoInformacionAdministrativaSolicitud;
  }


  public void setDtoInformacionEconomicaSolicitud(DTOInformacionEconomicaSolicitud dtoInformacionEconomicaSolicitud)
  {
    this.dtoInformacionEconomicaSolicitud = dtoInformacionEconomicaSolicitud;
  }


  public DTOInformacionEconomicaSolicitud getDtoInformacionEconomicaSolicitud()
  {
    return dtoInformacionEconomicaSolicitud;
  }


  public void setDtoInformacionEstadoSolicitud(DTOInformacionEstadoSolicitud dtoInformacionEstadoSolicitud)
  {
    this.dtoInformacionEstadoSolicitud = dtoInformacionEstadoSolicitud;
  }


  public DTOInformacionEstadoSolicitud getDtoInformacionEstadoSolicitud()
  {
    return dtoInformacionEstadoSolicitud;
  }


  public void setOidCabeceraSolicitud(Long oidCabeceraSolicitud)
  {
    this.oidCabeceraSolicitud = oidCabeceraSolicitud;
  }


  public Long getOidCabeceraSolicitud()
  {
    return oidCabeceraSolicitud;
  }

}