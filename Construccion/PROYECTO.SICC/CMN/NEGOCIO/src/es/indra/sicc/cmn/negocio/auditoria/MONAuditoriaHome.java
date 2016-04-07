package es.indra.sicc.cmn.negocio.auditoria;
import javax.ejb.EJBHome;
import java.rmi.RemoteException;
import javax.ejb.CreateException;

public interface MONAuditoriaHome extends EJBHome  {
  MONAuditoria create() throws RemoteException, CreateException;
}