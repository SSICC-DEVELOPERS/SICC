package es.indra.sicc.cmn.negocio.correo;
import javax.ejb.EJBObject;
import java.rmi.RemoteException;
import es.indra.mare.common.exception.MareException;
import javax.mail.internet.AddressException;
public interface MONServicioCorreoElectronico extends EJBObject  {
	void enviarCorreo(DTOCorreoElectronico dto) throws MareException, RemoteException;

    void enviarCorreo(DTOCorreoElectronico dto, String s) throws RemoteException, MareException, AddressException;
}