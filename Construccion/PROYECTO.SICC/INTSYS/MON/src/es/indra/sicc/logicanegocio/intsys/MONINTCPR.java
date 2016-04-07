package es.indra.sicc.logicanegocio.intsys;

import javax.ejb.EJBObject;
import java.rmi.RemoteException;
import es.indra.sicc.dtos.intsys.DTOINTRecepcionarClasificacion;
import es.indra.mare.common.exception.MareException;
import es.indra.sicc.util.DTOSalida;
import es.indra.sicc.util.DTOBelcorp;
import es.indra.sicc.cmn.negocio.batch.DTOBatch;
import es.indra.sicc.cmn.negocio.batch.DTOSalidaBatch;

public interface MONINTCPR extends EJBObject  {
  DTOSalidaBatch recepcionarClasificacion(DTOINTRecepcionarClasificacion dtoe) throws RemoteException, MareException; 
  DTOSalida cargarPantalla(DTOBelcorp dtoe) throws MareException, RemoteException;

  DTOSalidaBatch recepcionarClasificacionBatch(DTOBatch dtoBtch) throws MareException, RemoteException;
}