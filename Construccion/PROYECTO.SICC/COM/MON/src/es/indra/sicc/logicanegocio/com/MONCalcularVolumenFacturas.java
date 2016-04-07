package es.indra.sicc.logicanegocio.com;
import javax.ejb.EJBObject;
import java.rmi.RemoteException;
import es.indra.sicc.dtos.com.DTODatosCalculosComision;
import es.indra.mare.common.exception.MareException;

public interface MONCalcularVolumenFacturas extends EJBObject 
{
  void calcularVolumenFacturas(DTODatosCalculosComision dto) throws MareException, RemoteException;

}