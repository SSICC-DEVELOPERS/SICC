package es.indra.sicc.logicanegocio.intsys;
import es.indra.mare.common.exception.MareException;
import es.indra.sicc.cmn.negocio.batch.DTOBatch;
import javax.ejb.EJBObject;
import java.rmi.RemoteException;
import es.indra.sicc.dtos.intsys.DTOINT;
import es.indra.sicc.cmn.negocio.batch.DTOSalidaBatch;

public interface MONINTRET extends EJBObject  {
  void recepcionarReclamosCalypso(DTOINT dto) throws MareException, RemoteException;

  void recepcionarReclamosCabecera(DTOINT dto) throws MareException, RemoteException;

  void recepcionarOperacionReclamo(DTOINT dto) throws MareException, RemoteException;

  void recepcionarLineaOperacionReclamo(DTOINT dto) throws MareException, RemoteException;

    DTOSalidaBatch recepcionarReclamosCalypsoINI(DTOBatch dtoBatch) throws MareException, RemoteException;

    void recepcionarReclamosCalypsoBizTalk(DTOINT dto, String archivoRET1, String archivoRET2, String archivoRET3) throws MareException, RemoteException;
}