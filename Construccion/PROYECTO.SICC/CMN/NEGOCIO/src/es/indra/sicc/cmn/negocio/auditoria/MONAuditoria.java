package es.indra.sicc.cmn.negocio.auditoria;
import javax.ejb.EJBObject;
import java.rmi.RemoteException;
import java.util.HashMap;
import es.indra.mare.common.exception.MareException;

public interface MONAuditoria extends EJBObject  {
  DTOConfiguracionRastreo obtenerConfiguracionRastreo() throws MareException, RemoteException;

  HashMap obtenerConfiguracionAuditoria() throws RemoteException;

  void auditar(String codFunc, String usuario, String Entidad, Long pkEntidad, Integer op, String Dump) throws RemoteException, MareException;
}