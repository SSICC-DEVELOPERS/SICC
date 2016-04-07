package es.indra.sicc.logicanegocio.mav;
import javax.ejb.EJBObject;
import java.rmi.RemoteException;
import es.indra.sicc.dtos.ped.DTOSolicitudValidacion;
import es.indra.sicc.dtos.ped.DTOEstatusSolicitud;
import es.indra.mare.common.exception.MareException;

public interface MONEnvioAgregadosBatch extends EJBObject 
{
    DTOEstatusSolicitud  validarAgregados(DTOSolicitudValidacion dto) throws MareException, RemoteException;
}