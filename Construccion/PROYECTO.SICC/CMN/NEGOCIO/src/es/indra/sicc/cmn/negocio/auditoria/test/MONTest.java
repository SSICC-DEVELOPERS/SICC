package es.indra.sicc.cmn.negocio.auditoria.test;
import javax.ejb.EJBObject;
import java.rmi.RemoteException;

public interface MONTest extends EJBObject  {
  void find(String str) throws RemoteException;
}