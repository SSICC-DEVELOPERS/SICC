package es.indra.sicc.logicanegocio.pre;
import javax.ejb.EJBLocalObject;
import es.indra.sicc.dtos.ped.DTOCabeceraSolicitud;
import es.indra.sicc.dtos.ped.DTOPosicionSolicitud;
import es.indra.mare.common.exception.MareException;

public interface MONCuadreCompuestaFijaLocal extends EJBLocalObject 
{
    DTOCabeceraSolicitud cuadrarOferta(DTOCabeceraSolicitud dtoe, DTOPosicionSolicitud dtop, Long tipoPosicion, Long subtipoPosicion) throws MareException;
}