package es.indra.sicc.logicanegocio.dto;
import javax.ejb.EJBLocalObject;
import es.indra.sicc.util.DTOOID;
import es.indra.sicc.dtos.dto.DTOAprobarDescuento;
import es.indra.mare.common.exception.MareException;
import es.indra.sicc.dtos.dto.DTOAprobacionDescuento;
import es.indra.sicc.util.DTOColeccion;
import es.indra.sicc.util.DTOSalida;

public interface MONSimulacionDescuentoLocal extends EJBLocalObject 
{
    DTOAprobarDescuento cargarAprobarDescuento(DTOOID dto) throws MareException;

    void aprobarDescuento(DTOAprobacionDescuento dto) throws MareException;

    DTOColeccion cargarSolicitudes(DTOColeccion dto) throws MareException;

    DTOSalida pedirSolicitudesDetalle(DTOOID dto) throws MareException;
}