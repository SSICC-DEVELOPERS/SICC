package es.indra.sicc.logicanegocio.ped;
import javax.ejb.EJBObject;
import java.rmi.RemoteException;
import es.indra.sicc.dtos.ped.DTOCabeceraSolicitud;
import es.indra.sicc.util.DTOOID;
import es.indra.mare.common.exception.MareException;
import java.util.Vector;


public interface MONGenerarSolicitudModulosExternos extends EJBObject  {
	DTOOID generaSolicitud(DTOCabeceraSolicitud dto) throws RemoteException, MareException;

    Vector generarSolicitudes(Vector dtosCabecera) throws RemoteException, MareException;

    Vector generarPosiciones(Vector dtosCabecera) throws RemoteException, MareException;
}