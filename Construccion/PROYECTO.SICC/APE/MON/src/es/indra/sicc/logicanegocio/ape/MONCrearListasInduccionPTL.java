package es.indra.sicc.logicanegocio.ape;
import javax.ejb.EJBObject;
import java.rmi.RemoteException;
import es.indra.sicc.dtos.intsys.DTOListaPicadoInduccionPTL;
import es.indra.mare.common.exception.MareException;

public interface MONCrearListasInduccionPTL extends EJBObject  {
  void crearListasPicadoInduccionPTL(DTOListaPicadoInduccionPTL dtoe) throws RemoteException, MareException;
}