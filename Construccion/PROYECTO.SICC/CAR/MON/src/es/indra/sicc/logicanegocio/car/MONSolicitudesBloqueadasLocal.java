package es.indra.sicc.logicanegocio.car;
import javax.ejb.EJBLocalObject;
import es.indra.sicc.dtos.car.DTOSolicitudBloqueada;
import es.indra.mare.common.exception.MareException;
import es.indra.sicc.dtos.car.DTOBusquedaSolBloqueadas;
import es.indra.sicc.util.DTOSalida;
import es.indra.sicc.dtos.car.DTODatosLiberacion;
import es.indra.sicc.dtos.car.DTOPaginado;
import es.indra.sicc.util.DTOOID;

public interface MONSolicitudesBloqueadasLocal extends EJBLocalObject 
{
    void actualizarSolicitudesEntregaBloqueadas(DTOSolicitudBloqueada solBloqueada) throws MareException;

    DTOSalida consultarSolicitudesBloqueadas(DTOBusquedaSolBloqueadas dtoin) throws MareException;

    void liberarSolicitud(DTODatosLiberacion dtoin) throws MareException;

    DTOSalida obtenerNuevosEjecutivos(DTOPaginado dtoin) throws MareException;

    void reasignarSolicitud(DTODatosLiberacion dtoin) throws MareException;

    void rechazarSolicitud(DTOOID dtoin) throws MareException;
}