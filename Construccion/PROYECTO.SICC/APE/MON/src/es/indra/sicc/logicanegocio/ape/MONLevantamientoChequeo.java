package es.indra.sicc.logicanegocio.ape;
import es.indra.mare.common.exception.MareException;
import es.indra.sicc.dtos.ape.DTOChequeos;
import java.rmi.RemoteException;
import javax.ejb.EJBObject;

public interface MONLevantamientoChequeo extends EJBObject  {
    
    void realizarLevantamientoChequeo(DTOChequeos dtoE) throws MareException, RemoteException;
}