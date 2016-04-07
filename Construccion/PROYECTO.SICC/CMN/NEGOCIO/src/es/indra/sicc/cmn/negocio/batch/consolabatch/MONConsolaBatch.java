package es.indra.sicc.cmn.negocio.batch.consolabatch;
import javax.ejb.EJBObject;
import java.rmi.RemoteException;
import es.indra.sicc.cmn.negocio.batch.DTOConsolaBatch;
import es.indra.sicc.util.DTOSalida;
import es.indra.sicc.util.DTOBelcorp;

import es.indra.mare.common.exception.MareException;

public interface MONConsolaBatch extends EJBObject 
{
  DTOSalida obtenerProcesosConsola(DTOConsolaBatch dtoin) throws MareException, RemoteException;

  DTOSalida obtenerSubProcesosConsola(DTOConsolaBatch dtoin) throws MareException, RemoteException;

  DTOSalida obtenerEstadosProcesos(DTOBelcorp dtoin) throws MareException, RemoteException;
}