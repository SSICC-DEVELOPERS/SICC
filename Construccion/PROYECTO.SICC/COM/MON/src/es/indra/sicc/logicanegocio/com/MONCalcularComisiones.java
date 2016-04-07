package es.indra.sicc.logicanegocio.com;
import javax.ejb.EJBObject;
import java.rmi.RemoteException;
import es.indra.sicc.dtos.com.DTODatosCalculosComision;
import es.indra.mare.common.exception.MareException;

public interface MONCalcularComisiones extends EJBObject 
{
  void calcularComisionesXVenta(DTODatosCalculosComision dto) throws RemoteException, MareException;

  void calcularComisionesXCobranzas(DTODatosCalculosComision dto) throws RemoteException, MareException;

}