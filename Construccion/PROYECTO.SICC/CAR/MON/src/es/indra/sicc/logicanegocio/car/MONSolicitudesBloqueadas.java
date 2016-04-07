package es.indra.sicc.logicanegocio.car;
import javax.ejb.EJBObject;
import java.rmi.RemoteException;
import es.indra.sicc.util.DTOSalida;
import es.indra.sicc.dtos.car.DTOBusquedaSolBloqueadas;
import es.indra.sicc.util.DTOOID;
import es.indra.sicc.dtos.car.DTODatosLiberacion;
import es.indra.sicc.dtos.car.DTOPaginado;
import es.indra.mare.common.exception.MareException;
import es.indra.sicc.dtos.car.DTOSolicitudBloqueada;

public interface MONSolicitudesBloqueadas extends EJBObject  {
	DTOSalida consultarSolicitudesBloqueadas(DTOBusquedaSolBloqueadas dtoin) throws RemoteException, MareException;

	void rechazarSolicitud(DTOOID dtoin) throws RemoteException, MareException;

	void liberarSolicitud(DTODatosLiberacion dtoin) throws RemoteException, MareException;

	void reasignarSolicitud(DTODatosLiberacion dtoin) throws RemoteException, MareException;

	DTOSalida obtenerNuevosEjecutivos(DTOPaginado dtoin) throws RemoteException, MareException;

    void actualizarSolicitudesEntregaBloqueadas(DTOSolicitudBloqueada solBloqueada) throws RemoteException, MareException;






}