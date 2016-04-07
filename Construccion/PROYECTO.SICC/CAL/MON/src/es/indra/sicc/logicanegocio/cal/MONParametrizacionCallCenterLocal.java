package es.indra.sicc.logicanegocio.cal;
import javax.ejb.EJBLocalObject;
import es.indra.sicc.dtos.cal.DTOMensajeCallCenter;
import es.indra.mare.common.exception.MareException;
import es.indra.sicc.util.DTOBelcorp;

public interface MONParametrizacionCallCenterLocal extends EJBLocalObject 
{
    void actualizarMensajeCallCenter(DTOMensajeCallCenter dtoe) throws MareException;

    DTOMensajeCallCenter obtenerMensajeCallCenter(DTOBelcorp dtoe) throws MareException;
}