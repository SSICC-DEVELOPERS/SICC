package es.indra.sicc.logicanegocio.fac;
import es.indra.mare.common.exception.MareException;
import es.indra.sicc.dtos.fac.DTOAsignacionImpresoras;
import es.indra.sicc.util.DTOSalida;
import javax.ejb.EJBObject;
import java.rmi.RemoteException;
import es.indra.sicc.util.DTOOIDs;

public interface MONMantenimientoImpresoras extends EJBObject 
{
    DTOSalida obtenerImpresorasVirtuales() throws MareException, RemoteException;

    void guardarAsignacionImpresoras(DTOAsignacionImpresoras dtoe) throws MareException, RemoteException;

    DTOSalida consultarAsignacionImpresoras(DTOAsignacionImpresoras DTOE) throws MareException, RemoteException;

    void eliminarAsignacionImpresoras(DTOOIDs dtoe) throws MareException, RemoteException;

}