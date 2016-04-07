package es.indra.sicc.logicanegocio.pre;
import javax.ejb.EJBLocalObject;
import es.indra.sicc.dtos.ped.DTOCabeceraSolicitud;
import java.util.ArrayList;
import es.indra.mare.common.exception.MareException;

public interface MONCuadreCondicionadaLocal extends EJBLocalObject 
{
    DTOCabeceraSolicitud cuadrarOferta(DTOCabeceraSolicitud dtoe, ArrayList posicionesOferta, Long tipoPosicion, Long subtipoPosicion) throws MareException;
}