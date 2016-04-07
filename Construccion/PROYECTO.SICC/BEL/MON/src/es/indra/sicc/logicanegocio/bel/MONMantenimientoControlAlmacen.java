package es.indra.sicc.logicanegocio.bel;
import es.indra.mare.common.exception.MareException;
import javax.ejb.EJBObject;
import java.rmi.RemoteException;
import es.indra.sicc.dtos.bel.DTOControlAlmacen;
import es.indra.sicc.util.DTOSalida;
import es.indra.sicc.util.DTOOID;
import es.indra.sicc.util.DTOOIDs;

public interface MONMantenimientoControlAlmacen extends EJBObject  {
    void actualizarControlAlmacen(DTOControlAlmacen dtoE) throws MareException, RemoteException;

    DTOSalida buscarControlesAlmacen(DTOControlAlmacen dtoE) throws MareException, RemoteException;

    DTOControlAlmacen obtenerControlAlmacen(DTOOID dtoE) throws MareException, RemoteException;

    void eliminarControlAlmacen(DTOOIDs dtoE) throws MareException, RemoteException;
}