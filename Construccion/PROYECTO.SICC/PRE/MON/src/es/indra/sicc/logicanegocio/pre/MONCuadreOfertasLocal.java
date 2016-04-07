package es.indra.sicc.logicanegocio.pre;
import javax.ejb.EJBLocalObject;
import es.indra.sicc.dtos.ped.DTOSolicitudValidacion;
import es.indra.mare.common.exception.MareException;
import es.indra.sicc.dtos.ped.DTOCabeceraSolicitud;

public interface MONCuadreOfertasLocal extends EJBLocalObject 
{
    void revertirCuadre(DTOSolicitudValidacion dtoe) throws MareException;

    DTOCabeceraSolicitud cuadrarOfertas(DTOCabeceraSolicitud dtoe, Long tipoPosicion, Long subtipoPosicion) throws MareException;
}