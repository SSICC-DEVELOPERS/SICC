package es.indra.sicc.logicanegocio.cob;
import javax.ejb.EJBObject;
import java.rmi.RemoteException;
import es.indra.mare.common.dto.MareDTO;
import es.indra.mare.common.exception.MareException;

public interface ExtensionCOB extends EJBObject 
{
    void validacionEntreExclusivas(MareDTO datos) throws RemoteException, MareException;

    void validacionUsuariosCronogramaCob(MareDTO datos) throws RemoteException, MareException;

    void validacionRecordatorio(MareDTO datos) throws RemoteException, MareException;

    void validacionOrdenArgumento(MareDTO dto) throws MareException, RemoteException;
}