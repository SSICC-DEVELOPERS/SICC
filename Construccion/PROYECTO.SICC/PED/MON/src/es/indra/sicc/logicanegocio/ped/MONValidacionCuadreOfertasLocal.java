package es.indra.sicc.logicanegocio.ped;
import javax.ejb.EJBLocalObject;
import es.indra.sicc.dtos.ped.DTOSolicitudValidacion;
import es.indra.sicc.dtos.ped.DTOEstatusSolicitud;
import es.indra.mare.common.exception.MareException;

public interface MONValidacionCuadreOfertasLocal extends EJBLocalObject 
{
    DTOEstatusSolicitud validarCuadreOfertas(DTOSolicitudValidacion dtoe) throws MareException;
}