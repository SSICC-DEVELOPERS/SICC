package es.indra.sicc.logicanegocio.rec;
import javax.ejb.EJBObject;
import java.rmi.RemoteException;
import es.indra.mare.common.dto.MareDTO;
import es.indra.mare.common.exception.MareException;

public interface ExtensionREC extends EJBObject 
{
    void validarMotivoDevolucionS(MareDTO dto) throws RemoteException, MareException;
}