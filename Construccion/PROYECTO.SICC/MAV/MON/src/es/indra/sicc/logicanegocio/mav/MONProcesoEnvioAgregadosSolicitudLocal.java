package es.indra.sicc.logicanegocio.mav;
import javax.ejb.EJBLocalObject;
import es.indra.sicc.dtos.ped.DTOSolicitudValidacion;
import es.indra.sicc.dtos.ped.DTOEstatusSolicitud;
import es.indra.mare.common.exception.MareException;

public interface MONProcesoEnvioAgregadosSolicitudLocal extends EJBLocalObject 
{
    DTOEstatusSolicitud revertirAgregados(DTOSolicitudValidacion dto) throws MareException;

    DTOEstatusSolicitud validarAgregados(DTOSolicitudValidacion dto) throws MareException;
}