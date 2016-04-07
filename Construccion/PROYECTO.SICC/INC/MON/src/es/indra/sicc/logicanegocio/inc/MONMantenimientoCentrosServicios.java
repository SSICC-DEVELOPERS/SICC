package es.indra.sicc.logicanegocio.inc;
import javax.ejb.EJBObject;
import java.rmi.RemoteException;
import es.indra.mare.common.exception.MareException;
import es.indra.sicc.util.DTOSalida;
import es.indra.sicc.dtos.inc.DTOCentroServicio;
import es.indra.sicc.util.DTOOIDs;
import es.indra.sicc.util.DTOBelcorp;

public interface MONMantenimientoCentrosServicios extends EJBObject 
{
    DTOSalida buscarCentrosServicios(DTOCentroServicio dto) throws RemoteException, MareException;

    void insertarCentroServicio(DTOCentroServicio dto) throws MareException, RemoteException;


    void eliminarCentroServicio(DTOOIDs dto) throws RemoteException, MareException;

  DTOSalida obtenerCentroServicio(DTOBelcorp dteo) throws RemoteException, MareException;
}