package es.indra.sicc.logicanegocio.ape;
import javax.ejb.EJBObject;
import java.rmi.RemoteException;
import es.indra.sicc.dtos.ape.DTOListaPicadoCabecera;
import es.indra.mare.common.exception.MareException;

public interface MONCalculoCubicaje extends EJBObject  {
  void calcularCubicajePorVolumen(DTOListaPicadoCabecera listaPicado) throws RemoteException, MareException;
}