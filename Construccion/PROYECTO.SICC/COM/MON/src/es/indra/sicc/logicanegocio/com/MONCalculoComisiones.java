package es.indra.sicc.logicanegocio.com;
import javax.ejb.EJBObject;
import java.rmi.RemoteException;
import es.indra.mare.common.exception.MareException;
import es.indra.sicc.dtos.com.DTOClasificarComisiones;

public interface MONCalculoComisiones extends EJBObject 
{
    void clasificarComisiones(DTOClasificarComisiones dtoEntrada) throws MareException, RemoteException;

    Long[] recuperarAccesos(Long oidComision, Long oidCanal) throws RemoteException, MareException;
}