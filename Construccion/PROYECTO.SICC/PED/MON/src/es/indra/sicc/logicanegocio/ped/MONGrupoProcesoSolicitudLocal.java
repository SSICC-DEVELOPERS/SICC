package es.indra.sicc.logicanegocio.ped;
import javax.ejb.EJBLocalObject;
import es.indra.sicc.dtos.ped.DTOSolicitudValidacion;
import es.indra.sicc.dtos.ped.DTOListaProcesos;
import es.indra.sicc.dtos.ped.DTOEstatusSolicitud;
import es.indra.mare.common.exception.MareException;

public interface MONGrupoProcesoSolicitudLocal extends EJBLocalObject 
{
    DTOEstatusSolicitud procesarSolicitud(Long oidGrupoProceso, DTOSolicitudValidacion dtoin, DTOListaProcesos procesos, Boolean online) throws MareException;

    DTOEstatusSolicitud procesarSolicitudOnLine(Long oidGrupoProceso, DTOSolicitudValidacion dtoin, DTOListaProcesos procesos) throws MareException;

    DTOEstatusSolicitud procesarSolicitudReverso(Long oidGrupoProceso, DTOSolicitudValidacion dtoin, DTOListaProcesos procesos, Boolean online) throws MareException;

    DTOEstatusSolicitud procesarSolicitudReversoOnline(Long oidGrupoProceso, DTOSolicitudValidacion dtoin, DTOListaProcesos procesos) throws MareException;
}