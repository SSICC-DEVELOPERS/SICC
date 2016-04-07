package es.indra.sicc.logicanegocio.pre;
import javax.ejb.EJBLocalObject;
import es.indra.sicc.dtos.ped.DTOCabeceraSolicitud;
import es.indra.mare.common.exception.MareException;

public interface MONCuadrePromocionLocal extends EJBLocalObject 
{
    DTOCabeceraSolicitud cuadrarOferta(DTOCabeceraSolicitud dtoe, Long tipoPosicion, Long subtipoPosicion) throws MareException;
}